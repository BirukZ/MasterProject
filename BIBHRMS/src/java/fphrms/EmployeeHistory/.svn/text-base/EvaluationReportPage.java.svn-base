/*
 * Page1.java
 *
 * Created on : Nov 30, 2011, 9:10:29 AM
 * Author     : Administrator
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import control.ReportControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import manager.attendanceManager.AttendanceManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.LookUpManager;
import manager.departmentManage.DepartmentManage;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.EvaluationSessionManager;
import manager.employeeManager.ReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EvaluationReportPage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;
    private ArrayList<SelectItem> employeeTitle = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> lstResignTypes = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> division = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberia = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> titles = new ArrayList<SelectItem>();
    private LookUpManager lookUpManager = new LookUpManager();
    private AttendanceManager attendanceManager = new AttendanceManager();
    private ReportControl reportControl = new ReportControl();
    private EmployeeManage employeeManage = new EmployeeManage();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<ResignIC> evaluatedEmpList = new ArrayList<ResignIC>();
    private static String employeeId = null;
    private ImageIcon LOGO;
    private ImageIcon employeePicture;
    private byte[] bytEmployeePicture;
    private static String departmentIdFromSession = "";
    EvaluationSessionManager sessionManagerObject = new EvaluationSessionManager();
    EvaluationResultManager evaluationResultManager = new EvaluationResultManager();
    Option[] sessionCategory;
    private Option[] managedSessions;
    private Option[] autorizerID;
    private Option[] evaluatorID;

    public ArrayList<ResignIC> getEvaluatedEmpList() {
        return evaluatedEmpList;
    }

    public void setEvaluatedEmpList(ArrayList<ResignIC> evaluatedEmpList) {
        this.evaluatedEmpList = evaluatedEmpList;
    }

    public Option[] getEvaluatorID() {
        return evaluatorID;
    }

    public void setEvaluatorID(Option[] evaluatorID) {
        this.evaluatorID = evaluatorID;
    }

    public Option[] getAutorizerID() {
        return autorizerID;
    }

    public void setAutorizerID(Option[] autorizerID) {
        this.autorizerID = autorizerID;
    }

    public Option[] getManagedSessions() {
        return managedSessions;
    }

    public void setManagedSessions(Option[] managedSessions) {
        this.managedSessions = managedSessions;
    }

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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
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
    private DefaultSelectedData selectBooleanCheckbox7Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox7Bean() {
        return selectBooleanCheckbox7Bean;
    }

    public void setSelectBooleanCheckbox7Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox7Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkMilitery = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMilitery() {
        return chkMilitery;
    }

    public void setChkMilitery(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMilitery = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkCivil = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCivil() {
        return chkCivil;
    }

    public void setChkCivil(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCivil = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkPermanent = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkPermanent() {
        return chkPermanent;
    }

    public void setChkPermanent(HtmlSelectBooleanCheckbox hsbc) {
        this.chkPermanent = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkContrat = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkContrat() {
        return chkContrat;
    }

    public void setChkContrat(HtmlSelectBooleanCheckbox hsbc) {
        this.chkContrat = hsbc;
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
    private HtmlSelectOneMenu cboEmployeeTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboEmployeeTitle() {
        return cboEmployeeTitle;
    }

    public void setCboEmployeeTitle(HtmlSelectOneMenu hsom) {
        this.cboEmployeeTitle = hsom;
    }
    private HtmlInputText txtFromDate = new HtmlInputText();

    public HtmlInputText getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtFromDate(HtmlInputText hit) {
        this.txtFromDate = hit;
    }
    private HtmlInputText txtToDate = new HtmlInputText();

    public HtmlInputText getTxtToDate() {
        return txtToDate;
    }

    public void setTxtToDate(HtmlInputText hit) {
        this.txtToDate = hit;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnPreviewSelected = new HtmlCommandButton();

    public HtmlCommandButton getBtnPreviewSelected() {
        return btnPreviewSelected;
    }

    public void setBtnPreviewSelected(HtmlCommandButton hcb) {
        this.btnPreviewSelected = hcb;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }
    private HtmlDataTable dtResult = new HtmlDataTable();

    public HtmlDataTable getDtResult() {
        return dtResult;
    }

    public void setDtResult(HtmlDataTable hdt) {
        this.dtResult = hdt;
    }

    public ArrayList<SelectItem> getEmployeeTitle() {
        return employeeTitle;
    }

    public void setEmployeeTitle(ArrayList<SelectItem> employeeTitle) {
        this.employeeTitle = employeeTitle;
    }

    public ImageIcon getLOGO() {
        return LOGO;
    }

    public void setLOGO(ImageIcon LOGO) {
        this.LOGO = LOGO;
    }

    public ImageIcon getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(ImageIcon employeePicture) {
        this.employeePicture = employeePicture;
    }

    public byte[] getBytEmployeePicture() {
        return bytEmployeePicture;
    }

    public void setBytEmployeePicture(byte[] bytEmployeePicture) {
        this.bytEmployeePicture = bytEmployeePicture;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
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
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectedData defaultSelectedData222 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData222() {
        return defaultSelectedData222;
    }

    public void setDefaultSelectedData222(DefaultSelectedData dsd) {
        this.defaultSelectedData222 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems1() {
        return selectOneMenu2DefaultItems1;
    }

    public void setSelectOneMenu2DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems2() {
        return selectOneMenu2DefaultItems2;
    }

    public void setSelectOneMenu2DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems3() {
        return selectOneMenu2DefaultItems3;
    }

    public void setSelectOneMenu2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems3 = dsia;
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
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu5DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu5DefaultItems() {
        return selectOneMenu5DefaultItems;
    }

    public void setSelectOneMenu5DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu5DefaultItems = dsi;
    }

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentName();
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public ArrayList<SelectItem> getDirectorate() {
        return directorate;
    }

    public void setDirectorate(ArrayList<SelectItem> directorate) {
        this.directorate = directorate;
    }

    public ArrayList<SelectItem> getDivision() {
        return division;
    }

    public void setDivision(ArrayList<SelectItem> division) {
        this.division = division;
    }

    public ArrayList<SelectItem> getMastebaberia() {
        return mastebaberia;
    }

    public void setMastebaberia(ArrayList<SelectItem> mastebaberia) {
        this.mastebaberia = mastebaberia;
    }

    public ArrayList<SelectItem> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<SelectItem> team) {
        this.team = team;
    }
    private HtmlSelectOneMenu cboSector = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboSector() {
        return cboSector;
    }

    public void setCboSector(HtmlSelectOneMenu hsom) {
        this.cboSector = hsom;
    }
    private HtmlSelectOneMenu cboDivision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboDivision() {
        return cboDivision;
    }

    public void setCboDivision(HtmlSelectOneMenu hsom) {
        this.cboDivision = hsom;
    }
    private HtmlSelectOneMenu cboTeam = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboTeam() {
        return cboTeam;
    }

    public void setCboTeam(HtmlSelectOneMenu hsom) {
        this.cboTeam = hsom;
    }
    private HtmlSelectOneMenu cboDirectorate = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboDirectorate() {
        return cboDirectorate;
    }

    public void setCboDirectorate(HtmlSelectOneMenu hsom) {
        this.cboDirectorate = hsom;
    }
    private HtmlSelectOneMenu cboCooperative = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCboCooperative() {
        return cboCooperative;
    }

    public void setCboCooperative(HtmlSelectOneMenu hsom) {
        this.cboCooperative = hsom;
    }
    private HtmlOutputText lblRecordFound = new HtmlOutputText();

    public HtmlOutputText getLblRecordFound() {
        return lblRecordFound;
    }

    public void setLblRecordFound(HtmlOutputText hot) {
        this.lblRecordFound = hot;
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

    public ArrayList<SelectItem> getTitles() {
        return titles;
    }

    public void setTitles(ArrayList<SelectItem> titles) {
        this.titles = titles;
    }
    private DefaultSelectedData defaultSelectedData223 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData223() {
        return defaultSelectedData223;
    }

    public void setDefaultSelectedData223(DefaultSelectedData dsd) {
        this.defaultSelectedData223 = dsd;
    }

    public Option[] getSessionCategory() {
        return sessionCategory;
    }

    public void setSessionCategory(Option[] sessionCategory) {
        this.sessionCategory = sessionCategory;
    }
    private DefaultSelectedData defaultSelectedData224 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData224() {
        return defaultSelectedData224;
    }

    public void setDefaultSelectedData224(DefaultSelectedData dsd) {
        this.defaultSelectedData224 = dsd;
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
    private DefaultSelectedData defaultSelectedData225 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData225() {
        return defaultSelectedData225;
    }

    public void setDefaultSelectedData225(DefaultSelectedData dsd) {
        this.defaultSelectedData225 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData226 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData226() {
        return defaultSelectedData226;
    }

    public void setDefaultSelectedData226(DefaultSelectedData dsd) {
        this.defaultSelectedData226 = dsd;
    }
    private DefaultSelectedData defaultSelectedData227 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData227() {
        return defaultSelectedData227;
    }

    public void setDefaultSelectedData227(DefaultSelectedData dsd) {
        this.defaultSelectedData227 = dsd;
    }
    private DefaultSelectedData defaultSelectedData228 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData228() {
        return defaultSelectedData228;
    }

    public void setDefaultSelectedData228(DefaultSelectedData dsd) {
        this.defaultSelectedData228 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu selectOneMenuEvaPurpose = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaPurpose() {
        return selectOneMenuEvaPurpose;
    }

    public void setSelectOneMenuEvaPurpose(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaPurpose = hsom;
    }
    private HtmlSelectOneMenu selectOneMenu1ManagedSession = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1ManagedSession() {
        return selectOneMenu1ManagedSession;
    }

    public void setSelectOneMenu1ManagedSession(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1ManagedSession = hsom;
    }
    private HtmlSelectOneMenu iceSelOneMnuAuthorizedBy = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getIceSelOneMnuAuthorizedBy() {
        return iceSelOneMnuAuthorizedBy;
    }

    public void setIceSelOneMnuAuthorizedBy(HtmlSelectOneMenu hsom) {
        this.iceSelOneMnuAuthorizedBy = hsom;
    }
    private HtmlSelectOneMenu selectOneMenuEvaluatedBy = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaluatedBy() {
        return selectOneMenuEvaluatedBy;
    }

    public void setSelectOneMenuEvaluatedBy(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaluatedBy = hsom;
    }
    private HtmlInputText inputTextEmployeeID = new HtmlInputText();

    public HtmlInputText getInputTextEmployeeID() {
        return inputTextEmployeeID;
    }

    public void setInputTextEmployeeID(HtmlInputText hit) {
        this.inputTextEmployeeID = hit;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxSingleR = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxSingleR() {
        return selectBooleanCheckboxSingleR;
    }

    public void setSelectBooleanCheckboxSingleR(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxSingleR = hsbc;
    }
    private HtmlSelectBooleanCheckbox selectBooleanCheckboxGeneralR = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getSelectBooleanCheckboxGeneralR() {
        return selectBooleanCheckboxGeneralR;
    }

    public void setSelectBooleanCheckboxGeneralR(HtmlSelectBooleanCheckbox hsbc) {
        this.selectBooleanCheckboxGeneralR = hsbc;
    }
    private RowSelector rowSelectorEvaReport = new RowSelector();

    public RowSelector getRowSelectorEvaReport() {
        return rowSelectorEvaReport;
    }

    public void setRowSelectorEvaReport(RowSelector rs) {
        this.rowSelectorEvaReport = rs;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EvaluationReportPage() {
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
        sessionCategory = sessionManagerObject.readEvaSessionPurp();
        inputTextEmployeeID.setDisabled(true);
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
//        txtFromDate.setRequired(true);
//        txtToDate.setRequired(true);
        cboSector.setRequired(true);
//        txtFromDate.setRequiredMessage("Required.");
//        txtToDate.setRequiredMessage("Required.");
        cboSector.setRequiredMessage("Required.");
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

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setVisible(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void loadEmployeePicture(byte[] employeePicture) {
        try {
            if (employeePicture != null) {
                this.employeePicture = new ImageIcon((byte[]) employeePicture);
            } else {
                this.employeePicture = new ImageIcon();
            }
        } catch (Exception ex) {
        }

    }

    public void LoadLOGO() {
        List data = null;
        ReportManager manager1 = new ReportManager();
        data = manager1.loadCompanyLogo();
        ListIterator<ReportManager> lstmb = data.listIterator();
        try {
            while (lstmb.hasNext()) {
                ReportManager mag = lstmb.next();
                if (mag.getFPLOGO() != null) {
                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
                } else {
                    LOGO = new ImageIcon();
                }
            }
        } catch (Exception ex) {
        }

    }

    public static class ResignIC implements Serializable {

        private String employeeId;
        private String fullName;
        private String department;
        private String dateTerminated;
        private boolean selected;
        int selectedEvaResultRow = -1;

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getDateTerminated() {
            return dateTerminated;
        }

        public void setDateTerminated(String dateTerminated) {
            this.dateTerminated = dateTerminated;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public ResignIC() {
        }

        public ResignIC(String employeeId, String fullName, String department, String dateTerminated) {
            this.employeeId = employeeId;
            this.fullName = fullName;
            this.department = department;
            this.dateTerminated = dateTerminated;
        }
    }

    public void componentHandlerSingle() {
        this.chkMilitery.setDisabled(true);
        this.chkCivil.setDisabled(true);
        this.chkFemale.setDisabled(true);
        this.chkMale.setDisabled(true);
        this.cboEmployeeTitle.setDisabled(true);
        this.cboSector.setDisabled(true);
        this.cboDivision.setDisabled(true);
        this.cboTeam.setDisabled(true);
        this.cboDirectorate.setDisabled(true);
        this.cboCooperative.setDisabled(true);
        this.inputTextEmployeeID.setDisabled(false);
    }

    public void componentHandlerGeneral() {
        this.chkMilitery.setDisabled(false);
        this.chkCivil.setDisabled(false);
        this.chkFemale.setDisabled(false);
        this.chkMale.setDisabled(false);
        this.cboEmployeeTitle.setDisabled(false);
        this.cboSector.setDisabled(false);
        this.cboDivision.setDisabled(false);
        this.cboTeam.setDisabled(false);
        this.cboDirectorate.setDisabled(false);
        this.cboCooperative.setDisabled(false);
        this.inputTextEmployeeID.setDisabled(true);
    }

    public String btnSearch_action() {
        //return null means stay on the same page
        String strSeach = "";
        try {
            getEvaluatedEmpList().clear();
            if (chkCivil.isSelected() || chkMilitery.isSelected()) {
                if (!cboSector.getValue().toString().equalsIgnoreCase("0")) {
                    //Employee type filtering
                    if (chkCivil.isSelected()) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.CIVIL_TYPE=" + "'Civil'";
                            if (chkPermanent.isSelected()) {
                                if (strSeach.equalsIgnoreCase("")) {
                                    strSeach = strSeach + " HR_EMPLOYEE_INFO.EMPLOYMENTTYPE" + "'01'";
                                } else {
                                    strSeach = strSeach + " AND HR_EMPLOYEE_INFO.EMPLOYMENTTYPE" + "'01'";
                                }
                            }
                            if (chkContrat.isSelected()) {
                                if (strSeach.equalsIgnoreCase("")) {
                                    strSeach = strSeach + " HR_EMPLOYEE_INFO.EMPLOYMENTTYPE" + "'02'";
                                } else {
                                    strSeach = strSeach + " AND HR_EMPLOYEE_INFO.EMPLOYMENTTYPE" + "'02'";
                                }
                            }
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.CIVIL_TYPE=" + "'Civil'";
                        }

                    }
                    if (chkMilitery.isSelected()) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.CIVIL_TYPE=" + "'Miltery'";
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.CIVIL_TYPE=" + "'Miltery'";
                        }
                    }
                    //Sex filtering
                    if (chkMale.isSelected()) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.SEX=" + "'Male'";
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.SEX=" + "'Male'";
                        }
                    }
                    if (chkFemale.isSelected()) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.SEX=" + "'Female'";
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.SEX=" + "'Female'";
                        }
                    }
                    //  Title filtering
                    if (!cboEmployeeTitle.getValue().toString().equalsIgnoreCase("0")) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.TITLE='" + cboEmployeeTitle.getValue().toString() + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.TITLE='" + cboEmployeeTitle.getValue().toString() + "'";
                        }
                    }
                    //Department filtering
                    if (!cboSector.getValue().toString().equalsIgnoreCase("0")) {
                        departmentIdFromSession = cboSector.getValue().toString();
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EMPLOYEE_INFO.DEPARTMENT_ID='" + String.valueOf(cboSector.getValue().toString()) + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.DEPARTMENT_ID='" + String.valueOf(cboSector.getValue().toString()) + "'";
                        }

                        if (!cboDirectorate.getValue().toString().equalsIgnoreCase("0")) {
                            departmentIdFromSession = cboDirectorate.getValue().toString();
                            if (strSeach.equalsIgnoreCase("")) {
                                strSeach = strSeach + " HR_EMPLOYEE_INFO.DIRECTORATE='" + String.valueOf(cboDirectorate.getValue().toString()) + "'";
                            } else {
                                strSeach = strSeach + " AND HR_EMPLOYEE_INFO.DIRECTORATE='" + String.valueOf(cboDirectorate.getValue().toString()) + "'";
                            }

                            if (!cboDivision.getValue().toString().equalsIgnoreCase("0")) {
                                departmentIdFromSession = cboDivision.getValue().toString();
                                if (strSeach.equalsIgnoreCase("")) {
                                    strSeach = strSeach + " HR_EMPLOYEE_INFO.DIVISION='" + String.valueOf(cboDivision.getValue().toString()) + "'";
                                } else {
                                    strSeach = strSeach + " AND HR_EMPLOYEE_INFO.DIVISION='" + String.valueOf(cboDivision.getValue().toString()) + "'";
                                }
                                if (!cboCooperative.getValue().toString().equalsIgnoreCase("0")) {
                                    departmentIdFromSession = cboCooperative.getValue().toString();
                                    if (strSeach.equalsIgnoreCase("")) {
                                        strSeach = strSeach + " HR_EMPLOYEE_INFO.MASTEBABRIYA='" + String.valueOf(cboCooperative.getValue().toString()) + "'";
                                    } else {
                                        strSeach = strSeach + " AND HR_EMPLOYEE_INFO.MASTEBABRIYA='" + String.valueOf(cboCooperative.getValue().toString()) + "'";
                                    }
                                    if (!cboTeam.getValue().toString().equalsIgnoreCase("0")) {
                                        departmentIdFromSession = cboTeam.getValue().toString();
                                        if (strSeach.equalsIgnoreCase("")) {
                                            strSeach = strSeach + " HR_EMPLOYEE_INFO.TEAM='" + String.valueOf(cboTeam.getValue().toString()) + "'";
                                        } else {
                                            strSeach = strSeach + " AND HR_EMPLOYEE_INFO.TEAM='" + String.valueOf(cboTeam.getValue().toString()) + "'";
                                        }
                                    }
                                }

                            }
                        }
                    }
                    //Evaluation filtering
                    if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0")) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EVA_PURPOSE.PURPOSE_ID = '" + selectOneMenuEvaPurpose.getValue().toString() + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EVA_PURPOSE.PURPOSE_ID = '" + selectOneMenuEvaPurpose.getValue().toString() + "'";
                        }
                    }

                    if (iceSelOneMnuAuthorizedBy.getValue() != null && !iceSelOneMnuAuthorizedBy.getValue().equals("0")) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + iceSelOneMnuAuthorizedBy.getValue().toString() + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + iceSelOneMnuAuthorizedBy.getValue().toString() + "'";
                        }
                    }

                    if (selectOneMenu1ManagedSession.getValue() != null && !selectOneMenu1ManagedSession.getValue().equals("0")) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + selectOneMenu1ManagedSession.getValue().toString() + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + selectOneMenu1ManagedSession.getValue().toString() + "'";
                        }
                    }

                    if (selectOneMenuEvaluatedBy.getValue() != null && selectOneMenuEvaluatedBy.getValue().equals("0")) {
                        if (strSeach.equalsIgnoreCase("")) {
                            strSeach = strSeach + " HR_EVALUATION_RESULT.EVALUATOR_ID = '" + selectOneMenuEvaluatedBy.getValue().toString() + "'";
                        } else {
                            strSeach = strSeach + " AND HR_EVALUATION_RESULT.EVALUATOR_ID  = '" + selectOneMenuEvaluatedBy.getValue().toString() + "'";
                        }
                    }
                    ArrayList<HashMap> evaluatedEmpListS = new ArrayList<HashMap>();
                    evaluatedEmpListS = evaluationResultManager.loadEvaluationReportToTable(strSeach);
                    if (evaluatedEmpListS != null) {
                        lblRecordFound.setValue(String.valueOf(evaluatedEmpListS.size()));
                        for (HashMap hm : evaluatedEmpListS) {
                            getEvaluatedEmpList().add(new ResignIC(
                                    hm.get("EMP_ID").toString(),
                                    hm.get("EMPLOYEEFULLNAME").toString(),
                                    "",
                                    hm.get("EMP_ID").toString()));

                        }
                    } else {
                        lblRecordFound.setValue(String.valueOf(0));
                    }

                } else {
                    showSuccessOrFailureMessage(false, "Please select zerf.");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private ArrayList<SelectItem> titleList(String type) {
        return lookUpManager.assignTitle(type);
    }

    public void chkMilitery_processValueChange(ValueChangeEvent vce) {
        try {

            if (!CommonValidation.isUpdatePhase(vce)) {
                if (vce.getNewValue() != null) {
                    if (chkMilitery.isSelected()) {
                        cboEmployeeTitle.resetValue();
                        titles = titleList("military");
                        chkContrat.setDisabled(true);
                        chkPermanent.setDisabled(true);
                        chkCivil.setSelected(false);
                        chkContrat.setDisabled(true);
                        chkPermanent.setDisabled(true);
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    public void chkCivil_processValueChange(ValueChangeEvent vce) {
        try {
            if (!CommonValidation.isUpdatePhase(vce)) {
                if (chkCivil.isSelected()) {
                    if (vce.getNewValue() != null) {
                        cboEmployeeTitle.resetValue();
                        titles = titleList("civil");
                        chkMilitery.setSelected(false);
                        chkContrat.setDisabled(false);
                        chkPermanent.setDisabled(false);
                        chkContrat.setDisabled(false);
                        chkPermanent.setDisabled(false);
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    public void chkPermanent_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                chkContrat.setSelected(false);
            }
        }
    }

    public void chkContrat_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                chkPermanent.setSelected(false);
            }
        }
    }

    public void chkFemale_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                chkMale.setSelected(false);
            }
        }
    }

    public void chkMale_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                chkFemale.setSelected(false);
            }
        }
    }

    public void rwSelectorEmployee_processMyEvent(RowSelectorEvent rse) {
        int row = dtResult.getRowIndex();
        if (row > -1) {
            if (getEvaluatedEmpList().get(row).isSelected() == true) {
                employeeId = getEvaluatedEmpList().get(row).employeeId;
            } else {
                employeeId = null;
            }
        }
    }

    @SuppressWarnings("unchecked")
    public String btnPreviewSelected_action() {
        //return null means stay on the same page
        String forDepartment = "";
        String fromDate = null;
        String toDate = null;
        String empID = "";
        HashMap param = new HashMap();
        String jasperLocation = "E:\\FEDERALREPORTS\\Evaluation\\EvaluationReport.jasper";
        String reportName = "EvaluationReport";

        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        Collection data = null;
        try {
            //=================
            String strSeach = "";

            if (inputTextEmployeeID.getValue() != null && !inputTextEmployeeID.getValue().equals("")) {
                empID = inputTextEmployeeID.getValue().toString();
            }
            if (inputTextEmployeeID.getValue() != null) {
                strSeach = " HR_EMPLOYEE_INFO.EMP_ID = '" + inputTextEmployeeID.getValue().toString() + "' ";
                //Evaluation filtering
//                        if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0")) {
//                            if (strSeach.equalsIgnoreCase("")) {
//                                strSeach = strSeach + " HR_EVA_PURPOSE.PURPOSE_ID = '" + selectOneMenuEvaPurpose.getValue().toString() + "'";
//                            } else {
//                                strSeach = strSeach + " AND HR_EVA_PURPOSE.PURPOSE_ID = '" + selectOneMenuEvaPurpose.getValue().toString() + "'";
//                            }
//                        }

                if (iceSelOneMnuAuthorizedBy.getValue() != null && !iceSelOneMnuAuthorizedBy.getValue().equals("0")) {
                    if (strSeach.equalsIgnoreCase("")) {
                        strSeach = strSeach + " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + iceSelOneMnuAuthorizedBy.getValue().toString() + "'";
                    } else {
                        strSeach = strSeach + " AND HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + iceSelOneMnuAuthorizedBy.getValue().toString() + "'";
                    }
                }

                if (selectOneMenu1ManagedSession.getValue() != null && !selectOneMenu1ManagedSession.getValue().equals("0")) {
                    if (strSeach.equalsIgnoreCase("")) {
                        strSeach = strSeach + " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + selectOneMenu1ManagedSession.getValue().toString() + "'";
                    } else {
                        strSeach = strSeach + " AND HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + selectOneMenu1ManagedSession.getValue().toString() + "'";
                    }
                }

                if (selectOneMenuEvaluatedBy.getValue() != null && selectOneMenuEvaluatedBy.getValue().equals("0")) {
                    if (strSeach.equalsIgnoreCase("")) {
                        strSeach = strSeach + " HR_EVALUATION_RESULT.EVALUATOR_ID = '" + selectOneMenuEvaluatedBy.getValue().toString() + "'";
                    } else {
                        strSeach = strSeach + " AND HR_EVALUATION_RESULT.EVALUATOR_ID  = '" + selectOneMenuEvaluatedBy.getValue().toString() + "'";
                    }
                }

                data = evaluationResultManager.loadEvaluationReport(strSeach, empID);
            }



            //==============
            servletOutputStream = response.getOutputStream();
            LoadLOGO();
            param.put("LOGO", LOGO.getImage());
            param.put("R_SUM", String.valueOf(evaluationResultManager.getTotalRsult()));
            param.put("R_AVERAGE", String.valueOf(evaluationResultManager.getAverageResult()));
            reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
            servletOutputStream.flush();
            servletOutputStream.close();
            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //   }
        return null;
    }

    public void cboSector_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equalsIgnoreCase("0")) {
                    setDirectorate(null);
                    setDivision(null);
                    setMastebaberia(null);
                    setTeam(null);
//                    setDirectorate(departmentManage.getZerfName(vce.getNewValue().toString()));
                }
            }
        }
    }

    public void cboDivision_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equalsIgnoreCase("0")) {
                    setMastebaberia(null);
                    setTeam(null);
//                    setMastebaberia(departmentManage.getZerfName(vce.getNewValue().toString()));
                }
            }
        }
    }

    public void cboTeam_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equalsIgnoreCase("0")) {
                }
            }
        }
    }

    public void cboDirectorate_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equalsIgnoreCase("0")) {
                    setDivision(null);
                    setMastebaberia(null);
                    setTeam(null);
//                    setDivision(departmentManage.getZerfName(vce.getNewValue().toString()));
                }
            }
        }
    }

    public void cboCooperative_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equalsIgnoreCase("0")) {
                    setTeam(null);
//                    setTeam(departmentManage.getZerfName(vce.getNewValue().toString()));
                }
            }
        }

    }

    public String btnReset_action() {
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {

        //return null means stay on the same page
        return "EvaluationCriterias";
    }

    public String commandLink2_action() {
        //return null means stay on the same page
        return "EvaluationResult";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "EvaluationSession";
    }

    public String buttonEvaluationNavigatorCriteria_action() {
        //return null means stay on the same page
        return "EvaluationCriterias";
    }

    public String buttonEvaluationNavigatorSession_action() {
        //return null means stay on the same page
        return "EvaluationSession";
    }

    public String buttonEvaluationNavigatorResult_action() {
        //return null means stay on the same page
        return "EvaluationResult";
    }

    public String commandLink4_action() {
        //return null means stay on the same page
        return "EvaluationResultDisplay";
    }

    public String commandLink5_action() {
        //return null means stay on the same page
        return "EvaluationResultResolveComplain";
    }

    public String commandLink6_action() {
        //return null means stay on the same page
        return "EvaluationNavigation";
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public void selectOneMenuEvaPurpose_processValueChange(ValueChangeEvent vce) {
        if (this.selectBooleanCheckboxSingleR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0") && this.inputTextEmployeeID.getValue() != null &&
                    !this.inputTextEmployeeID.getValue().toString().equals("")) {
                this.autorizerID = sessionManagerObject.readSessionAutorizer(vce.getNewValue().toString(), this.inputTextEmployeeID.getValue().toString());
            }
        } else if (this.selectBooleanCheckboxGeneralR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0")) {
                this.autorizerID = sessionManagerObject.readSessionAutorizer(vce.getNewValue().toString(), null);
            }
        }


    }

    public void iceSelOneMnuAuthorizedBy_processValueChange(ValueChangeEvent vce) {
        if (this.selectBooleanCheckboxSingleR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0") && this.inputTextEmployeeID.getValue() != null) {
                if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0") &&
                        !this.inputTextEmployeeID.getValue().toString().equals("")) {
                    this.managedSessions = sessionManagerObject.readManagedSessions(vce.getNewValue().toString(),
                            selectOneMenuEvaPurpose.getValue().toString(), this.inputTextEmployeeID.getValue().toString());
                }
            }
        } else if (this.selectBooleanCheckboxGeneralR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0")) {
                if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0")) {
                    this.managedSessions = sessionManagerObject.readManagedSessions(vce.getNewValue().toString(),
                            selectOneMenuEvaPurpose.getValue().toString(), null);
                }
            }
        }
    }

    public void selectOneMenu1ManagedSession_processValueChange(ValueChangeEvent vce) {
        if (this.selectBooleanCheckboxSingleR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0") && this.inputTextEmployeeID.getValue() != null) {
                if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0") &&
                        !this.inputTextEmployeeID.getValue().toString().equals("")) {
                    this.evaluatorID = sessionManagerObject.readEvaluatorInfo(vce.getNewValue().toString(),
                            selectOneMenuEvaPurpose.getValue().toString(),
                            this.inputTextEmployeeID.getValue().toString());
                }
            }
        } else if (this.selectBooleanCheckboxGeneralR.isSelected()) {
            if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0")) {
                if (selectOneMenuEvaPurpose.getValue() != null && !selectOneMenuEvaPurpose.getValue().equals("0")) {
                    this.evaluatorID = sessionManagerObject.readEvaluatorInfo(vce.getNewValue().toString(),
                            selectOneMenuEvaPurpose.getValue().toString(), null);
                }
            }
        }
    }

    public void selectBooleanCheckboxSingleR_processValueChange(ValueChangeEvent vce) {
        this.componentHandlerSingle();
        this.selectBooleanCheckboxGeneralR.setSelected(false);
    }

    public void selectBooleanCheckboxGeneralR_processValueChange(ValueChangeEvent vce) {
        this.componentHandlerGeneral();
        this.selectBooleanCheckboxSingleR.setSelected(false);
    }

    public void rowSelectorEvaReport_processMyEvent(RowSelectorEvent rse) {
        ResignIC rowSelected = new ResignIC();
        rowSelected.selectedEvaResultRow = rse.getRow();
        rowSelected = evaluatedEmpList.get(rowSelected.selectedEvaResultRow);
        this.inputTextEmployeeID.setValue(rowSelected.getEmployeeId().toString());
    }
}
