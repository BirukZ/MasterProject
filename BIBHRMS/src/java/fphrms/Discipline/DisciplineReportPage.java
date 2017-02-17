/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Discipline;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.Help.Template;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRequestManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeManager.EmployeeManage;
import fphrms.Termination.RetireRequestPage;
import fphrms.Report.MainReport;
import fphrms.Template_1;
import fphrms.Termination.RetireApprovalPage;
import manager.disciplineManager.DisciplinePenaltyRegistrationManager;
import manager.disciplineManager.PenaltyRegistrationManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DisciplineReportPage extends AbstractPageBean {
    //<editor-fold  defaultstate="collapsed" desc="default">
    // <editor-fold defaultstate="collapsed" desc="Local Variables">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        userName = getSessionBean1().getUserName();
        checkDefaultCheckBoxes();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
//    //private HtmlInputTextarea txtaDeciderCommen1 = new HtmlInputTextarea();
//
//    public HtmlInputTextarea getTxtaDeciderCommen1() {
//        return txtaDeciderCommen1;
//    }
//
//    public void setTxtaDeciderCommen1(HtmlInputTextarea hit) {
//        this.txtaDeciderCommen1 = hit;
//    }
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
    }
    private HtmlPanelGroup pnlGrpPowerDeligationContent = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlGrpPowerDeligationContent() {
        return pnlGrpPowerDeligationContent;
    }

    public void setPnlGrpPowerDeligationContent(HtmlPanelGroup hpg) {
        this.pnlGrpPowerDeligationContent = hpg;
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlSelectBooleanCheckbox ckbAnyRequester = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox ckbAnyAccused = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox ckbAnyRequestParameter = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox ckbStatusOnProgress = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox ckbStatusApproved = new HtmlSelectBooleanCheckbox();
    private HtmlSelectBooleanCheckbox ckbStatusRejected = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbAnyRequester() {
        return ckbAnyRequester;
    }

    public void setCkbAnyRequester(HtmlSelectBooleanCheckbox ckbAnyRequester) {
        this.ckbAnyRequester = ckbAnyRequester;
    }

    public HtmlSelectBooleanCheckbox getCkbAnyAccused() {
        return ckbAnyAccused;
    }

    public void setCkbAnyAccused(HtmlSelectBooleanCheckbox ckbAnyAccused) {
        this.ckbAnyAccused = ckbAnyAccused;
    }

    public String getAccusedId() {
        return accusedId;
    }

    public void setAccusedId(String accusedId) {
        this.accusedId = accusedId;
    }

    public String getDisciplineFromDate() {
        return disciplineFromDate;
    }

    public void setDisciplineFromDate(String disciplineFromDate) {
        this.disciplineFromDate = disciplineFromDate;
    }

    public String getDisciplineToDate() {
        return disciplineToDate;
    }

    public void setDisciplineToDate(String disciplineToDate) {
        this.disciplineToDate = disciplineToDate;
    }

    public HtmlInputText getTxtDisciplineFromDate() {
        return txtDisciplineFromDate;
    }

    public void setTxtDisciplineFromDate(HtmlInputText txtDisciplineFromDate) {
        this.txtDisciplineFromDate = txtDisciplineFromDate;
    }

    public HtmlInputText getTxtDisciplineToDate() {
        return txtDisciplineToDate;
    }

    public void setTxtDisciplineToDate(HtmlInputText txtDisciplineToDate) {
        this.txtDisciplineToDate = txtDisciplineToDate;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlSelectBooleanCheckbox getCkbAnyRequestParameter() {
        return ckbAnyRequestParameter;
    }

    public void setCkbAnyRequestParameter(HtmlSelectBooleanCheckbox ckbAnyRequestParameter) {
        this.ckbAnyRequestParameter = ckbAnyRequestParameter;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(String penaltyType) {
        this.penaltyType = penaltyType;
    }

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtAccusedDepartment = new HtmlInputText();

    public HtmlInputText getTxtAccusedDepartment() {
        return txtAccusedDepartment;
    }

    public void setTxtAccusedDepartment(HtmlInputText hit) {
        this.txtAccusedDepartment = hit;
    }
    private HtmlInputText txtAccusedId = new HtmlInputText();

    public HtmlInputText getTxtAccusedId() {
        return txtAccusedId;
    }

    public void setTxtAccusedId(HtmlInputText hit) {
        this.txtAccusedId = hit;
    }
    private HtmlInputText txtAccusedPosition = new HtmlInputText();

    public HtmlInputText getTxtAccusedPosition() {
        return txtAccusedPosition;
    }

    public void setTxtAccusedPosition(HtmlInputText hit) {
        this.txtAccusedPosition = hit;
    }
    private HtmlInputText txtDisciplineFromDate = new HtmlInputText();

    public HtmlInputText getTxtDisciplineStartDate() {
        return txtDisciplineFromDate;
    }

    public void setTxtDisciplineStartDate(HtmlInputText hit) {
        this.txtDisciplineFromDate = hit;
    }
    private HtmlInputText txtDisciplineToDate = new HtmlInputText();

    public HtmlInputText getTxtDisciplineEndDate() {
        return txtDisciplineToDate;
    }

    public void setTxtDisciplineEndDate(HtmlInputText hit) {
        this.txtDisciplineToDate = hit;
    }
    private HtmlSelectOneMenu drlDisciplineType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisciplineType() {
        return drlDisciplineType;
    }

    public void setDrlDisciplineType(HtmlSelectOneMenu hsom) {
        this.drlDisciplineType = hsom;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }

    public ArrayList<Option> getDisciplineTypes() {
        return disciplineTypes;
    }

    public void setDisciplineTypes(ArrayList<Option> disciplineTypes) {
        this.disciplineTypes = disciplineTypes;
    }

    public ArrayList<Option> getPenaltyTypesListOption() {
        return penaltyTypesListOption;
    }

    public void setPenaltyTypesListOption(ArrayList<Option> penaltyTypesListOption) {
        this.penaltyTypesListOption = penaltyTypesListOption;
    }

    public ArrayList<Option> getRepititionTypes() {
        return repititionTypes;
    }

    public void setRepititionTypes(ArrayList<Option> repititionTypes) {
        this.repititionTypes = repititionTypes;
    }
    private SelectInputDateBean calReportedDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalReportedDateBean() {
        return calReportedDateBean;
    }

    public void setCalReportedDateBean(SelectInputDateBean calReportedDateBean) {
        this.calReportedDateBean = calReportedDateBean;
    }
    private SelectInputDateBean calOffenceDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalOffenceDateBean() {
        return calOffenceDateBean;
    }

    public void setCalOffenceDateBean(SelectInputDateBean calOffenceDateBean) {
        this.calOffenceDateBean = calOffenceDateBean;
    }
    private SelectInputDate calOffenceDate = new SelectInputDate();

    public SelectInputDate getCalOffenceDate() {
        return calOffenceDate;
    }

    public void setCalOffenceDate(SelectInputDate sid) {
        this.calOffenceDate = sid;
    }
    private SelectInputDate calReportedDate = new SelectInputDate();

    public SelectInputDate getCalReportedDate() {
        return calReportedDate;
    }

    public void setCalReportedDate(SelectInputDate sid) {
        this.calReportedDate = sid;
    }
    private HtmlCommandButton btnSearchAccused = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchAccused() {
        return btnSearchAccused;
    }

    public void setBtnSearchAccused(HtmlCommandButton hcb) {
        this.btnSearchAccused = hcb;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDateOfOffence() {
        return disciplineFromDate;
    }

    public void setDateOfOffence(String dateOfOffence) {
        this.disciplineFromDate = dateOfOffence;
    }

    public String getDescriptionOfOffence() {
        return descriptionOfOffence;
    }

    public void setDescriptionOfOffence(String descriptionOfOffence) {
        this.descriptionOfOffence = descriptionOfOffence;
    }

    public int getDisciplineProblemId() {
        return disciplineProblemId;
    }

    public void setDisciplineProblemId(int disciplineProblemId) {
        this.disciplineProblemId = disciplineProblemId;
    }

    public DisciplineRegistrationManager getDisciplineRegistrationManager() {
        return disciplineRegistrationManager;
    }

    public void setDisciplineRegistrationManager(DisciplineRegistrationManager disciplineRegistrationManager) {
        this.disciplineRegistrationManager = disciplineRegistrationManager;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public String getOffenderId() {
        return accusedId;
    }

    public void setOffenderId(String offenderId) {
        this.accusedId = offenderId;
    }

    public String getReportedDate() {
        return disciplineToDate;
    }

    public void setReportedDate(String reportedDate) {
        this.disciplineToDate = reportedDate;
    }

    public String getRequestedMeasureToBeTaken() {
        return requestedMeasureToBeTaken;
    }

    public void setRequestedMeasureToBeTaken(String requestedMeasureToBeTaken) {
        this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    private HtmlCommandButton btnSearchDeligatee = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchDeligatee() {
        return btnSearchDeligatee;
    }

    public void setBtnSearchDeligatee(HtmlCommandButton btnSearchDeligatee) {
        this.btnSearchDeligatee = btnSearchDeligatee;
    }
    private HtmlCommandButton btnSearchRequester = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchRequester() {
        return btnSearchRequester;
    }

    public void setBtnSearchRequester(HtmlCommandButton hcb) {
        this.btnSearchRequester = hcb;
    }

    //<editor-fold  defaultstate="collapsed" desc="Local Variables">
    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public DisciplineRequestManager getDisciplineRequestManager() {
        return disciplineRequestManager;
    }

    public void setDisciplineRequestManager(DisciplineRequestManager disciplineRequestManager) {
        this.disciplineRequestManager = disciplineRequestManager;
    }

    public ArrayList<Option> getDisciplineTypesList() {
        return disciplineTypesList;
    }

    public void setDisciplineTypesList(ArrayList<Option> disciplineTypesList) {
        this.disciplineTypesList = disciplineTypesList;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlCommandButton btnPrieviewAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnPrieviewAll() {
        return btnPrieviewAll;
    }

    public void setBtnPrieviewAll(HtmlCommandButton hcb) {
        this.btnPrieviewAll = hcb;
    }
    private HtmlSelectOneMenu drlPenalty = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPenalty() {
        return drlPenalty;
    }

    public void setDrlPenalty(HtmlSelectOneMenu hsom) {
        this.drlPenalty = hsom;
    }
//</editor-fold>
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DisciplineReportPage() {
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected CustomValidations getCustomValidations() {
        return (CustomValidations) getBean("CustomValidations");
    }
    //</editor-fold>
/////////////////////////////////////////////////////////////////////////////////////////////
    String loggedInEmployeeId;
    String userName;
    EmployeeManage employeeManager = new EmployeeManage();
    DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();
    DisciplineRequestModel disciplineRequestModel = new DisciplineRequestModel();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    PenaltyRegistrationManager penaltyRegistrationManager = new PenaltyRegistrationManager();
    DisciplinePenaltyRegistrationManager disciplinePenaltyRegistrationManager = new DisciplinePenaltyRegistrationManager();
    //=============================================================================
    ArrayList<Option> disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
    ArrayList<Option> disciplineTypes = disciplineRegistrationManager.getAllDesciplineTypesOption();//new ArrayList<Option>();//
    ArrayList<Option> repititionTypes = disciplinePenaltyRegistrationManager.getPossibleRepitions();// new ArrayList<Option>();
    ArrayList<Option> penaltyTypesListOption = penaltyRegistrationManager.getAllPenaltyTypesOption();//
    ArrayList<DisciplineRequestModel> generatedReportList = new ArrayList<DisciplineRequestModel>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    //================================================================================
    int disciplineProblemId;// DISCIPLINE_PROBLEM_ID
    String requesterId = "-1"; //REQUESTER_ID
    String accusedId = "-1";//OFFENDER_ID always employee
    String disciplineFromDate = "-1";//DATE_OF_OFFENCE//when does it happen
    String disciplineToDate = "-1";//REPORTED_DATE//reported to the hrms e
    String offenderDepartment = "-1";
    String offenceType = "-1";// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
    String penaltyType = "-1";//
    //  int repititionOfOffence = -1;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
    String descriptionOfOffence = null;//DESCRIPTION_OF_OFFENCE//details
    String requestedMeasureToBeTaken = null;//REQUESTED_MEASURE_TO_BE_TAKEN
    String status = null;//STATUS
    //==============================================================================

    private boolean populateRequesterTextComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeID);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeID);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateAccusedTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                accusedId = empInfoHashMap.get("employeeId").toString();
                txtAccusedDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtAccusedFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtAccusedId.setValue(accusedId);
                txtAccusedPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void clearRequesterTextComponents() {
        requesterId = "-1";
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        ckbAnyRequester.setSelected(true);
    }

    private void clearDisciplineTextComponents() {
        txtDisciplineFromDate.setValue(null);
        txtDisciplineToDate.setValue(null);
        drlDisciplineType.resetValue();
        drlPenalty.resetValue();
        ckbAnyRequestParameter.setSelected(true);
        resetDisciplineAttributes();
    }

    private void resetDisciplineAttributes() {
        offenceType = "-1";
        penaltyType = "-1";
        disciplineFromDate = "-1";
        disciplineToDate = "-1";
    }

    private void clearAccusedTextComponents() {
        accusedId = "-1";
        txtAccusedId.setValue(null);
        txtAccusedDepartment.setValue(null);
        txtAccusedFullName.setValue(null);
        txtAccusedPosition.setValue(null);
        ckbAnyAccused.setSelected(true);
    }

    private void clearDataTable() {
        generatedReportList = new ArrayList<DisciplineRequestModel>();
    }

    private void checkDefaultCheckBoxes() {
        ckbAnyRequestParameter.setSelected(true);
        ckbAnyAccused.setSelected(true);
        ckbAnyRequester.setSelected(true);
        ckbStatusAny.setSelected(true);
        ckbStatusApproved.setSelected(true);
        ckbStatusOnProgress.setSelected(true);
        ckbStatusRejected.setSelected(true);
    }

    private void clearAllComponents() {
        clearDisciplineTextComponents();
        clearRequesterTextComponents();
        clearAccusedTextComponents();
        clearDataTable();
    }

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public void drlDecision_processValueChange(ValueChangeEvent vce) {
    }

    public String btnPostDecision_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtDeligateeId_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        clearAllComponents();
        checkDefaultCheckBoxes();
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private boolean validateAndInitializeDisciplineAttributes() {
        //disciplineFromDate, requesterType, requesterId, accusedId, disciplineToDate, offenceType, repititionOfOffence, descriptionOfOffence, requestedMeasureToBeTaken, status, "No"
        if (txtDisciplineFromDate.getValue() == null ||
                drlDisciplineType.getValue().toString().split("--")[0].equals("-1")) {
            showSuccessOrFailureMessage(false, " NOT FILLED <br>=> Date or Decision or  <br>=> Description<br>=>DisciplineType");
            return false;
        } else {
            offenceType = drlDisciplineType.getValue().toString().split("--")[0];
        }
        return true;
    }

    private boolean validateAndInitializeDisciplineRequest() {
        if (requesterId == null || accusedId == null) {
            showSuccessOrFailureMessage(false, "SELECT EMPLOYEE FIRST");
            return false;
        } else if (requesterId.equals(accusedId)) {
            showSuccessOrFailureMessage(false, "SAME REQUESTER AND ACCUSED");
            return false;
        } else if (!validateAndInitializeDisciplineAttributes()) {
            return false;
        }
        if (txtDisciplineFromDate == null) {
            return false;
        } else {
            if (((Date) calOffenceDate.getValue()).after((Date) calReportedDate.getValue()) ||//offence date not allowed to be after reported date
                    ((Date) calReportedDate.getValue()).after(new Date())) {//reported date not allowed to be  future date
                showSuccessOrFailureMessage(false, "INVALID OFFENCE DATE : " + dateFormat.format((Date) calOffenceDate.getValue()) +
                        "<br> OR<br>INVALID REPORTED DATE : " + dateFormat.format((Date) calReportedDate.getValue()));
                return false;
            } else {
                disciplineFromDate = dateFormat.format((Date) calOffenceDate.getValue());
                disciplineToDate = dateFormat.format((Date) calReportedDate.getValue());
            }
        }

        return true;
    }

    public String txtApprovedEndDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String txtForwardedToEmployeeFullName_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCalendarDisciplineDate_action() {//
        calOffenceDate.setRendered(true);
        return null;
    }

    public String btnCalendarReportedDate_action() {
        calReportedDate.setRendered(true);
        disciplineFromDate = dateFormat.format(calReportedDate.getValue());
        return null;
    }

    public void calReportedDate_processValueChange(ValueChangeEvent vce) {
        txtDisciplineToDate.setValue(dateFormat.format(calReportedDate.getValue()));
        disciplineToDate = dateFormat.format(calReportedDate.getValue());
        calReportedDate.setRendered(false);
    }

    public void calOffenceDate_processValueChange(ValueChangeEvent vce) {
        txtDisciplineFromDate.setValue(dateFormat.format(calOffenceDate.getValue()));
        disciplineFromDate = dateFormat.format(calOffenceDate.getValue());
        calOffenceDate.setRendered(false);
    }

    public void pnlGrpEvaluationContent_processMyEvent(DragEvent de) {
    }

    public String btnSearchAccused_action() {
        if (txtAccusedId.getValue() != null) {
            accusedId = txtAccusedId.getValue().toString();
            if (!populateAccusedTextComponents(accusedId)) {
                accusedId = "-1";
            } else if (!drlDisciplineType.getValue().toString().equals("-1--0")) {//if some value is selected
                int disciplineTypeId = Integer.parseInt(drlDisciplineType.getValue().toString().split("--")[0]);
                int phaseOutPeriod = Integer.parseInt(drlDisciplineType.getValue().toString().split("--")[1]);//in months
            // repititionOfOffence = disciplineRequestManager.getPrevieousOffenceCommited(disciplineTypeId, accusedId, phaseOutPeriod);
            }
        }
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null) {
            requesterId = txtRequesterId.getValue().toString();
            if (!populateRequesterTextComponents(requesterId)) {
                requesterId = "-1";
            }
        }
        return null;
    }

    public String lnkDisciplineRegistrationPage_action() {
        return "DisciplineTypes";
    }

    public String lnkGovernmentDeductions_action() {
        return "DisciplineApprove";
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireRequestPage getTermination$RetireRequestPage() {
        return (RetireRequestPage) getBean("Termination$RetireRequestPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template getHelp$Template() {
        return (fphrms.Help.Template) getBean("Help$Template");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template_1 getTemplate_1() {
        return (Template_1) getBean("Template_1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String lnkDisciplineRegistrationPage_action_action() {
        return "DisciplineTypes";
    }

    public DisciplineRequestModel getDisciplineRequestModel() {
        return disciplineRequestModel;
    }

    public void setDisciplineRequestModel(DisciplineRequestModel disciplineRequestModel) {
        this.disciplineRequestModel = disciplineRequestModel;
    }

    public String getUserName() {
        return userName;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataAnyRequester = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataAnyAccused = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataAnyParameter = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataAnyAccused() {
        return defaultSelectedDataAnyAccused;
    }

    public void setDefaultSelectedDataAnyAccused(DefaultSelectedData defaultSelectedDataAnyAccused) {
        this.defaultSelectedDataAnyAccused = defaultSelectedDataAnyAccused;
    }

    public DefaultSelectedData getDefaultSelectedDataAnyParameter() {
        return defaultSelectedDataAnyParameter;
    }

    public void setDefaultSelectedDataAnyParameter(DefaultSelectedData defaultSelectedDataAnyParameter) {
        this.defaultSelectedDataAnyParameter = defaultSelectedDataAnyParameter;
    }

    public DefaultSelectedData getDefaultSelectedDataAnyRequester() {
        return defaultSelectedDataAnyRequester;
    }

    public void setDefaultSelectedDataAnyRequester(DefaultSelectedData defaultSelectedDataAnyRequester) {
        this.defaultSelectedDataAnyRequester = defaultSelectedDataAnyRequester;
    }

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData defaultSelectedData4) {
        this.defaultSelectedData4 = defaultSelectedData4;
    }

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData defaultSelectedData5) {
        this.defaultSelectedData5 = defaultSelectedData5;
    }

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData defaultSelectedData6) {
        this.defaultSelectedData6 = defaultSelectedData6;
    }

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData defaultSelectedData7) {
        this.defaultSelectedData7 = defaultSelectedData7;
    }
    private HtmlSelectBooleanCheckbox ckbStatusAny = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbStatusAny() {
        return ckbStatusAny;
    }

    public void setCkbStatusAny(HtmlSelectBooleanCheckbox ckbStatusAny) {
        this.ckbStatusAny = ckbStatusAny;
    }

    public HtmlSelectBooleanCheckbox getCkbStatusApproved() {
        return ckbStatusApproved;
    }

    public void setCkbStatusApproved(HtmlSelectBooleanCheckbox ckbStatusApproved) {
        this.ckbStatusApproved = ckbStatusApproved;
    }
    private DefaultSelectedData selectedObjectOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfPenality = new DefaultSelectedData();
    private DefaultSelectedData selectedDataOfRepition = new DefaultSelectedData();

    public ArrayList<DisciplineRequestModel> getGeneratedReportList() {
        return generatedReportList;
    }

    public void setGeneratedReportList(ArrayList<DisciplineRequestModel> generatedReportList) {
        this.generatedReportList = generatedReportList;
    }

    public String getOffenderDepartment() {
        return offenderDepartment;
    }

    public void setOffenderDepartment(String offenderDepartment) {
        this.offenderDepartment = offenderDepartment;
    }

    public DefaultSelectedData getSelectedDataOfPenality() {
        return selectedDataOfPenality;
    }

    public void setSelectedDataOfPenality(DefaultSelectedData selectedDataOfPenality) {
        this.selectedDataOfPenality = selectedDataOfPenality;
    }

    public DefaultSelectedData getSelectedDataOfRepition() {
        return selectedDataOfRepition;
    }

    public void setSelectedDataOfRepition(DefaultSelectedData selectedDataOfRepition) {
        this.selectedDataOfRepition = selectedDataOfRepition;
    }

    public DefaultSelectedData getSelectedObjectOfDisciplineType() {
        return selectedObjectOfDisciplineType;
    }

    public void setSelectedObjectOfDisciplineType(DefaultSelectedData selectedObjectOfDisciplineType) {
        this.selectedObjectOfDisciplineType = selectedObjectOfDisciplineType;
    }

    public HtmlSelectBooleanCheckbox getCkbStatusOnProgress() {
        return ckbStatusOnProgress;
    }

    public void setCkbStatusOnProgress(HtmlSelectBooleanCheckbox ckbStatusOnProgress) {
        this.ckbStatusOnProgress = ckbStatusOnProgress;
    }

    public HtmlSelectBooleanCheckbox getCkbStatusRejected() {
        return ckbStatusRejected;
    }

    public void setCkbStatusRejected(HtmlSelectBooleanCheckbox ckbStatusRejected) {
        this.ckbStatusRejected = ckbStatusRejected;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText txtRequesterFullName) {
        this.txtRequesterFullName = txtRequesterFullName;
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    public String txtAccusedFullName_action() {
        clearAccusedTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateAccusedTextComponents(requesterId);
        return null;
    }
    private SelectInputText txtAccusedFullName = new SelectInputText();

    public SelectInputText getTxtAccusedFullName() {
        return txtAccusedFullName;
    }

    public void setTxtAccusedFullName(SelectInputText txtEmployeeFullName) {
        this.txtAccusedFullName = txtEmployeeFullName;
    }

    public String txtEmployeeFullName_action() {
        clearAccusedTextComponents();
        accusedId = ApplicationBean1.getSelectedEmployeeId();
        populateAccusedTextComponents(accusedId);
        return null;
    }

    public String getSelectedStatus() {
        String selectedStstus = "";
        if (ckbStatusApproved.isSelected()) {
            selectedStstus += "App--";
        }
        if (ckbStatusOnProgress.isSelected()) {
            selectedStstus += "Onp--";
        }
        if (ckbStatusRejected.isSelected()) {
            selectedStstus += "Rej--";
        }
        return selectedStstus;
    }

    public void ckbStatusAny_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusAny")) {
            if (ckbStatusAny.isSelected()) {
                ckbStatusApproved.setSelected(true);
                ckbStatusOnProgress.setSelected(true);
                ckbStatusRejected.setSelected(true);
            } else {
                ckbStatusApproved.setSelected(false);
                ckbStatusOnProgress.setSelected(false);
                ckbStatusRejected.setSelected(false);
            }
        }
    }

    public void ckbStatusOnProgress_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusOnProgress") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public void ckbStatusApproved_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusApproved") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public void ckbStatusRejected_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbStatusRejected") && vce.getNewValue().toString().equals("false")) {
            //if (vce.getNewValue().toString().equals("false")) {
            ckbStatusAny.setSelected(false);
        }
    }

    public String btnPrieviewAll_action() {
        //return null means stay on the same page
        return null;
    }

    public boolean validateAndInitializeAttributes() {
        if (txtDisciplineFromDate.getValue() == null || txtDisciplineFromDate.getValue().toString().equals("")) {
            disciplineFromDate = "-1";
        } else {
            disciplineFromDate = txtDisciplineFromDate.getValue().toString();
        }
        if (txtDisciplineToDate.getValue() == null || txtDisciplineToDate.getValue().toString().equals("")) {
            disciplineToDate = "-1";
        } else {
            disciplineToDate = txtDisciplineToDate.getValue().toString();
        }

        if (drlDisciplineType.getValue() != null) {
            offenceType = drlDisciplineType.getValue().toString().split("--")[0];
        } else {
            offenceType = "-1";
        }
        if (drlPenalty.getValue() != null) {
            penaltyType = drlPenalty.getValue().toString();
        } else {
            penaltyType = "-1";
        }
        return true;
    }

    public String btnGenerateReport_action() {
        try {
            validateAndInitializeAttributes();
            status = getSelectedStatus();
            generatedReportList = disciplineRequestManager.getDisciplineReport(
                    requesterId, accusedId, offenderDepartment, disciplineFromDate, disciplineToDate,
                    offenceType, penaltyType, status);
            if (generatedReportList.size() == 0) {
                showSuccessOrFailureMessage(false, "NO LIST IS FOUND WHICH SATISFY YOUR CRITERIA.\nADJUST YOUR PARAMETERS TO VIEW RESULTS");
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
            showSuccessOrFailureMessage(false, "Some Fields Not Selected");
        }
        return null;

    }

    public void ckbAnyRequester_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyRequester") && vce.getNewValue().toString().equals("false")) {
            clearRequesterTextComponents();
        }
    }

    public void ckbAnyAccused_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyAccused") && vce.getNewValue().toString().equals("false")) {
            clearAccusedTextComponents();
        }
    }

    public void ckbAnyRequestParameter_processValueChange(ValueChangeEvent vce) {
        if (((HtmlSelectBooleanCheckbox) vce.getSource()).getId().equals("ckbAnyRequestParameter") && vce.getNewValue().toString().equals("false")) {
            clearDisciplineTextComponents();
        }
    }
}
