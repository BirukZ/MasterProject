/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlMessage;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import fphrms.*;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.convert.DateTimeConverter;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import manager.employeeManager.EmployeeManage;
import com.sun.webui.jsf.model.Option;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import javax.faces.model.SelectItem;
import manager.employeeHistoryManager.EvaluationSessionManager;
import manager.globalUseManager.StringDateManipulation;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EvaluationSession extends AbstractPageBean {

    /**
     * @return the selectedId
     */
    EmployeeManage employeeManager = new EmployeeManage();
    EvaluationSessionManager sessionManagerObject = new EvaluationSessionManager();
    ArrayList<SelectItem> sessionCategory = new ArrayList<SelectItem>();
    private Option[] sessionAuthorizerHistory;
    String authorHolder = "";
    int buttonIndicator = 0;
    int selectedEvaSessionRow = -1;
    int idSessionIdHolder;
    private Object evaSessionPopeffectWindow;
    public String searchValueAuthor = "";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currenTDateToSet = "fromDate";
    private List evaSessionOPt = new ArrayList<EvaluationSessionManager>();

    public List getEvaSessionOPt() {
        return evaSessionOPt;
    }

    public void setEvaSessionOPt(List evaSessionOPt) {
        this.evaSessionOPt = evaSessionOPt;
    }

    /**
     * @return the sessionAuthorizerHistory
     */
    public Option[] getSessionAuthorizerHistory() {
        return sessionAuthorizerHistory;
    }

    /**
     * @param sessionAuthorizerHistory the sessionAuthorizerHistory to set
     */
    public void setSessionAuthorizerHistory(Option[] sessionAuthorizerHistory) {
        this.sessionAuthorizerHistory = sessionAuthorizerHistory;
    }

    /**
     * @return the evaSessionPopeffectWindow
     */
    public Object getEvaSessionPopeffectWindow() {
        return evaSessionPopeffectWindow;
    }

    /**
     * @param evaSessionPopeffectWindow the evaSessionPopeffectWindow to set
     */
    public void setEvaSessionPopeffectWindow(Object evaSessionPopeffectWindow) {
        this.evaSessionPopeffectWindow = evaSessionPopeffectWindow;
    }

    public ArrayList<SelectItem> getSessionCategory() {
        return sessionCategory;
    }

    public void setSessionCategory(ArrayList<SelectItem> sessionCategory) {
        this.sessionCategory = sessionCategory;
    }

    public static String getSelectedId() {
        return selectedId;
    }

    /**
     * @param aSelectedId the selectedId to set
     */
    public static void setSelectedId(String aSelectedId) {
        selectedId = aSelectedId;
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
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private SelectInputText txtSearchByNameEvaSession = new SelectInputText();

    public SelectInputText getTxtSearchByNameEvaSession() {
        return txtSearchByNameEvaSession;
    }

    public void setTxtSearchByNameEvaSession(SelectInputText sit) {
        this.txtSearchByNameEvaSession = sit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private static String selectedId;
    private HtmlInputText inputTextEvaSessionTitle = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionTitle() {
        return inputTextEvaSessionTitle;
    }

    public void setInputTextEvaSessionTitle(HtmlInputText hit) {
        this.inputTextEvaSessionTitle = hit;
    }
    private HtmlInputText inputTextSessionAutorID = new HtmlInputText();

    public HtmlInputText getInputTextSessionAutorID() {
        return inputTextSessionAutorID;
    }

    public void setInputTextSessionAutorID(HtmlInputText hit) {
        this.inputTextSessionAutorID = hit;
    }
    private HtmlInputText inputTextEvaSessionDepartment = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionDepartment() {
        return inputTextEvaSessionDepartment;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }

    public void setInputTextEvaSessionDepartment(HtmlInputText hit) {
        this.inputTextEvaSessionDepartment = hit;
    }
    private HtmlInputText inputTextEvaSessionAutorized = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionAutorized() {
        return inputTextEvaSessionAutorized;
    }

    public void setInputTextEvaSessionAutorized(HtmlInputText hit) {
        this.inputTextEvaSessionAutorized = hit;
    }
    private HtmlInputText inputTextEvaSessionReferenceDate = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionReferenceDate() {
        return inputTextEvaSessionReferenceDate;
    }

    public void setInputTextEvaSessionReferenceDate(HtmlInputText hit) {
        this.inputTextEvaSessionReferenceDate = hit;
    }
    private HtmlInputText inputTextEvaSessionReferenceNO = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionReferenceNO() {
        return inputTextEvaSessionReferenceNO;
    }

    public void setInputTextEvaSessionReferenceNO(HtmlInputText hit) {
        this.inputTextEvaSessionReferenceNO = hit;
    }
    private HtmlInputText inputTextEvaSessionStartingDate = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionStartingDate() {
        return inputTextEvaSessionStartingDate;
    }

    public void setInputTextEvaSessionStartingDate(HtmlInputText hit) {
        this.inputTextEvaSessionStartingDate = hit;
    }
    private HtmlInputText inputTextEvaSessionEndingDate = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionEndingDate() {
        return inputTextEvaSessionEndingDate;
    }

    public void setInputTextEvaSessionEndingDate(HtmlInputText hit) {
        this.inputTextEvaSessionEndingDate = hit;
    }
    private HtmlSelectOneMenu selectOneMenuEvaSession = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaSession() {
        return selectOneMenuEvaSession;
    }

    public void setSelectOneMenuEvaSession(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaSession = hsom;
    }
    private DateTimeConverter dateTimeConverter1 = new DateTimeConverter();

    public DateTimeConverter getDateTimeConverter1() {
        return dateTimeConverter1;
    }

    public void setDateTimeConverter1(DateTimeConverter dtc) {
        this.dateTimeConverter1 = dtc;
    }
    private HtmlCommandButton btnEvaSessionDateCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnEvaSessionDateCalender() {
        return btnEvaSessionDateCalender;
    }

    public void setBtnEvaSessionDateCalender(HtmlCommandButton hcb) {
        this.btnEvaSessionDateCalender = hcb;
    }
    private HtmlCommandButton btnEvaSessionStartDateDateCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnEvaSessionStartDateDateCalender() {
        return btnEvaSessionStartDateDateCalender;
    }

    public void setBtnEvaSessionStartDateDateCalender(HtmlCommandButton hcb) {
        this.btnEvaSessionStartDateDateCalender = hcb;
    }
    private HtmlCommandButton btnEvaSessionEndingDateDateCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnEvaSessionEndingDateDateCalender() {
        return btnEvaSessionEndingDateDateCalender;
    }

    public void setBtnEvaSessionEndingDateDateCalender(HtmlCommandButton hcb) {
        this.btnEvaSessionEndingDateDateCalender = hcb;
    }
    private UISelectItems selectOneMenu1selectItemsEvaSession = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsEvaSession() {
        return selectOneMenu1selectItemsEvaSession;
    }

    public void setSelectOneMenu1selectItemsEvaSession(UISelectItems uisi) {
        this.selectOneMenu1selectItemsEvaSession = uisi;
    }
    private HtmlCommandButton buttonNewESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonNewESession() {
        return buttonNewESession;
    }

    public void setButtonNewESession(HtmlCommandButton hcb) {
        this.buttonNewESession = hcb;
    }
    private HtmlCommandButton buttonStartESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonStartESession() {
        return buttonStartESession;
    }

    public void setButtonStartESession(HtmlCommandButton hcb) {
        this.buttonStartESession = hcb;
    }
    private HtmlCommandButton buttonEditESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonEditESession() {
        return buttonEditESession;
    }

    public void setButtonEditESession(HtmlCommandButton hcb) {
        this.buttonEditESession = hcb;
    }
    private HtmlCommandButton buttonUpdateESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonUpdateESession() {
        return buttonUpdateESession;
    }

    public void setButtonUpdateESession(HtmlCommandButton hcb) {
        this.buttonUpdateESession = hcb;
    }
    private HtmlCommandButton buttonDeleteESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonDeleteESession() {
        return buttonDeleteESession;
    }

    public void setButtonDeleteESession(HtmlCommandButton hcb) {
        this.buttonDeleteESession = hcb;
    }
    private HtmlCommandButton buttonResetESession = new HtmlCommandButton();

    public HtmlCommandButton getButtonResetESession() {
        return buttonResetESession;
    }

    public void setButtonResetESession(HtmlCommandButton hcb) {
        this.buttonResetESession = hcb;
    }
    private HtmlOutputLabel lblevaEvaSessionFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblevaEvaSessionFormMessage() {
        return lblevaEvaSessionFormMessage;
    }

    public void setLblevaEvaSessionFormMessage(HtmlOutputLabel hol) {
        this.lblevaEvaSessionFormMessage = hol;
    }
    private PanelLayout pnevaEvaSessionMessage = new PanelLayout();

    public PanelLayout getPnevaEvaSessionMessage() {
        return pnevaEvaSessionMessage;
    }

    public void setPnevaEvaSessionMessage(PanelLayout pl) {
        this.pnevaEvaSessionMessage = pl;
    }
    private HtmlPanelGroup RetirementApproval1 = new HtmlPanelGroup();

    public HtmlPanelGroup getRetirementApproval1() {
        return RetirementApproval1;
    }

    public void setRetirementApproval1(HtmlPanelGroup hpg) {
        this.RetirementApproval1 = hpg;
    }
    private PanelLayout panelLayoutTableController = new PanelLayout();

    public PanelLayout getPanelLayoutTableController() {
        return panelLayoutTableController;
    }

    public void setPanelLayoutTableController(PanelLayout pl) {
        this.panelLayoutTableController = pl;
    }
    private PanelLayout panelLayoutTableControllerSession = new PanelLayout();

    public PanelLayout getPanelLayoutTableControllerSession() {
        return panelLayoutTableControllerSession;
    }

    public void setPanelLayoutTableControllerSession(PanelLayout pl) {
        this.panelLayoutTableControllerSession = pl;
    }
    private HtmlDataTable dataTableEvaSession = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaSession() {
        return dataTableEvaSession;
    }

    public void setDataTableEvaSession(HtmlDataTable hdt) {
        this.dataTableEvaSession = hdt;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlDataTable dataTableEvaSessionT = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaSessionT() {
        return dataTableEvaSessionT;
    }

    public void setDataTableEvaSessionT(HtmlDataTable hdt) {
        this.dataTableEvaSessionT = hdt;
    }
    private UIColumn columnEvaSessionId = new UIColumn();

    public UIColumn getColumnEvaSessionId() {
        return columnEvaSessionId;
    }

    public void setColumnEvaSessionId(UIColumn uic) {
        this.columnEvaSessionId = uic;
    }
    private RowSelector rowSelectorEvaSession = new RowSelector();

    public RowSelector getRowSelectorEvaSession() {
        return rowSelectorEvaSession;
    }

    public void setRowSelectorEvaSession(RowSelector rs) {
        this.rowSelectorEvaSession = rs;
    }
    private UIColumn columnAuthorId = new UIColumn();

    public UIColumn getColumnAuthorId() {
        return columnAuthorId;
    }

    public void setColumnAuthorId(UIColumn uic) {
        this.columnAuthorId = uic;
    }
    private HtmlCommandButton btnNewSessionESession = new HtmlCommandButton();

    public HtmlCommandButton getBtnNewSessionESession() {
        return btnNewSessionESession;
    }

    public void setBtnNewSessionESession(HtmlCommandButton hcb) {
        this.btnNewSessionESession = hcb;
    }
    private PanelPopup evaSessionPopUpMsg = new PanelPopup();

    public PanelPopup getEvaSessionPopUpMsg() {
        return evaSessionPopUpMsg;
    }

    public void setEvaSessionPopUpMsg(PanelPopup pp) {
        this.evaSessionPopUpMsg = pp;
    }
    private HtmlOutputText lblevaSessionPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblevaSessionPopUpMsgMain() {
        return lblevaSessionPopUpMsgMain;
    }

    public void setLblevaSessionPopUpMsgMain(HtmlOutputText hot) {
        this.lblevaSessionPopUpMsgMain = hot;
    }
    private HtmlCommandButton btnevaSessionPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaSessionPopUpYes() {
        return btnevaSessionPopUpYes;
    }

    public void setBtnevaSessionPopUpYes(HtmlCommandButton hcb) {
        this.btnevaSessionPopUpYes = hcb;
    }
    private HtmlCommandButton btnevaSessionPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaSessionPopUpNo() {
        return btnevaSessionPopUpNo;
    }

    public void setBtnevaSessionPopUpNo(HtmlCommandButton hcb) {
        this.btnevaSessionPopUpNo = hcb;
    }
    private PanelLayout panelLayoutaEvaSessionAuthorizerHistory = new PanelLayout();

    public PanelLayout getPanelLayoutaEvaSessionAuthorizerHistory() {
        return panelLayoutaEvaSessionAuthorizerHistory;
    }

    public void setPanelLayoutaEvaSessionAuthorizerHistory(PanelLayout pl) {
        this.panelLayoutaEvaSessionAuthorizerHistory = pl;
    }
    private HtmlSelectOneListbox selectOneListbox1EvaSessionAuthorizerHistory = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1EvaSessionAuthorizerHistory() {
        return selectOneListbox1EvaSessionAuthorizerHistory;
    }

    public void setSelectOneListbox1EvaSessionAuthorizerHistory(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1EvaSessionAuthorizerHistory = hsol;
    }
    private HtmlCommandButton button1AuthorizerHistory = new HtmlCommandButton();

    public HtmlCommandButton getButton1AuthorizerHistory() {
        return button1AuthorizerHistory;
    }

    public void setButton1AuthorizerHistory(HtmlCommandButton hcb) {
        this.button1AuthorizerHistory = hcb;
    }
    private HtmlOutputText outputTextForReferenceDate = new HtmlOutputText();

    public HtmlOutputText getOutputTextForReferenceDate() {
        return outputTextForReferenceDate;
    }

    public void setOutputTextForReferenceDate(HtmlOutputText hot) {
        this.outputTextForReferenceDate = hot;
    }
    private HtmlOutputText outputTextForStartingDate = new HtmlOutputText();

    public HtmlOutputText getOutputTextForStartingDate() {
        return outputTextForStartingDate;
    }

    public void setOutputTextForStartingDate(HtmlOutputText hot) {
        this.outputTextForStartingDate = hot;
    }
    private HtmlOutputText outputTextForEndingDate = new HtmlOutputText();

    public HtmlOutputText getOutputTextForEndingDate() {
        return outputTextForEndingDate;
    }

    public void setOutputTextForEndingDate(HtmlOutputText hot) {
        this.outputTextForEndingDate = hot;
    }
    private HtmlOutputText outputTextForReferenceNO = new HtmlOutputText();

    public HtmlOutputText getOutputTextForReferenceNO() {
        return outputTextForReferenceNO;
    }

    public void setOutputTextForReferenceNO(HtmlOutputText hot) {
        this.outputTextForReferenceNO = hot;
    }
    private HtmlOutputText outputTextForselectOneMenuEvaSession = new HtmlOutputText();

    public HtmlOutputText getOutputTextForselectOneMenuEvaSession() {
        return outputTextForselectOneMenuEvaSession;
    }

    public void setOutputTextForselectOneMenuEvaSession(HtmlOutputText hot) {
        this.outputTextForselectOneMenuEvaSession = hot;
    }
    private HtmlOutputText outputTexttxtSearchByNameEvaSessionSearch = new HtmlOutputText();

    public HtmlOutputText getOutputTexttxtSearchByNameEvaSessionSearch() {
        return outputTexttxtSearchByNameEvaSessionSearch;
    }

    public void setOutputTexttxtSearchByNameEvaSessionSearch(HtmlOutputText hot) {
        this.outputTexttxtSearchByNameEvaSessionSearch = hot;
    }
    private UISelectItems selectOneListbox1selectItemsEvaSessionAuthorizerHistory = new UISelectItems();

    public UISelectItems getSelectOneListbox1selectItemsEvaSessionAuthorizerHistory() {
        return selectOneListbox1selectItemsEvaSessionAuthorizerHistory;
    }

    public void setSelectOneListbox1selectItemsEvaSessionAuthorizerHistory(UISelectItems uisi) {
        this.selectOneListbox1selectItemsEvaSessionAuthorizerHistory = uisi;
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
    private HtmlMessage message1ReferenceDate = new HtmlMessage();

    public HtmlMessage getMessage1ReferenceDate() {
        return message1ReferenceDate;
    }

    public void setMessage1ReferenceDate(HtmlMessage hm) {
        this.message1ReferenceDate = hm;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calFromDate = new SelectInputDate();

    public SelectInputDate getCalFromDate() {
        return calFromDate;
    }

    public void setCalFromDate(SelectInputDate sid) {
        this.calFromDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calReferenceDate = new SelectInputDate();

    public SelectInputDate getCalReferenceDate() {
        return calReferenceDate;
    }

    public void setCalReferenceDate(SelectInputDate sid) {
        this.calReferenceDate = sid;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDate calEndingDate = new SelectInputDate();

    public SelectInputDate getCalEndingDate() {
        return calEndingDate;
    }

    public void setCalEndingDate(SelectInputDate sid) {
        this.calEndingDate = sid;
    }
    private HtmlInputText txtEnddate = new HtmlInputText();

    public HtmlInputText getTxtEnddate() {
        return txtEnddate;
    }

    public void setTxtEnddate(HtmlInputText hit) {
        this.txtEnddate = hit;
    }
    private HtmlInputText txtStartDate = new HtmlInputText();

    public HtmlInputText getTxtStartDate() {
        return txtStartDate;
    }

    public void setTxtStartDate(HtmlInputText hit) {
        this.txtStartDate = hit;
    }
    private HtmlCommandButton calendarStartDate = new HtmlCommandButton();

    public HtmlCommandButton getCalendarStartDate() {
        return calendarStartDate;
    }

    public void setCalendarStartDate(HtmlCommandButton hcb) {
        this.calendarStartDate = hcb;
    }
    private HtmlCommandButton calendarEndDate = new HtmlCommandButton();

    public HtmlCommandButton getCalendarEndDate() {
        return calendarEndDate;
    }

    public void setCalendarEndDate(HtmlCommandButton hcb) {
        this.calendarEndDate = hcb;
    }
    private SelectInputDateBean selectInputDateBean4 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean4() {
        return selectInputDateBean4;
    }

    public void setSelectInputDateBean4(SelectInputDateBean sidb) {
        this.selectInputDateBean4 = sidb;
    }
    private SelectInputDate calSessionStartDate = new SelectInputDate();

    public SelectInputDate getCalSessionStartDate() {
        return calSessionStartDate;
    }

    public void setCalSessionStartDate(SelectInputDate sid) {
        this.calSessionStartDate = sid;
    }
    private SelectInputDateBean selectInputDateBean5 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean5() {
        return selectInputDateBean5;
    }

    public void setSelectInputDateBean5(SelectInputDateBean sidb) {
        this.selectInputDateBean5 = sidb;
    }
    private HtmlCommandLink commandLink4 = new HtmlCommandLink();

    public HtmlCommandLink getCommandLink4() {
        return commandLink4;
    }

    public void setCommandLink4(HtmlCommandLink hcl) {
        this.commandLink4 = hcl;
    }
    private PanelCollapsible pnl_col_Common_Tasks = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Common_Tasks() {
        return pnl_col_Common_Tasks;
    }

    public void setPnl_col_Common_Tasks(PanelCollapsible pc) {
        this.pnl_col_Common_Tasks = pc;
    }
    private SelectInputDate sessionEndDate = new SelectInputDate();

    public SelectInputDate getSessionEndDate() {
        return sessionEndDate;
    }

    public void setSessionEndDate(SelectInputDate sid) {
        this.sessionEndDate = sid;
    }
    private UIColumn newStartDate = new UIColumn();

    public UIColumn getNewStartDate() {
        return newStartDate;
    }

    public void setNewStartDate(UIColumn uic) {
        this.newStartDate = uic;
    }
    private UIColumn newEndDate = new UIColumn();

    public UIColumn getNewEndDate() {
        return newEndDate;
    }

    public void setNewEndDate(UIColumn uic) {
        this.newEndDate = uic;
    }

    public EvaluationSession() {
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
        sessionCategory = sessionManagerObject.readEvaSession();
        disableComponentes();
        disableButtons();
        this.buttonResetESession.setDisabled(true);
        this.buttonNewESession.setDisabled(false);

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
    @Override
    public void prerender() {
        this.inputTextEvaSessionReferenceDate.setRequired(true);
        this.inputTextEvaSessionReferenceDate.setRequiredMessage("Requred");
        this.inputTextEvaSessionStartingDate.setRequired(true);
        this.inputTextEvaSessionStartingDate.setRequiredMessage("Requred");
        this.inputTextEvaSessionEndingDate.setRequired(true);
        this.inputTextEvaSessionEndingDate.setRequiredMessage("Requred");
        this.selectOneMenuEvaSession.setRequired(true);
        this.selectOneMenuEvaSession.setRequiredMessage("Requred");
        inputTextEvaSessionAutorized.setValue(getSessionBean1().getEmployeeName());
        selectedId = getSessionBean1().getEmployeeId();
        this.loadEmployeeProfileDetail(selectedId);
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

    public void panelBorder1north_processMyEvent(DragEvent de) {
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
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    private void dateValidator(FacesContext context, UIComponent component, Object value) {
        try {
            String datePatern = "(19[0-9]{2}|20[0-9]{2})\\-(0[1-9]|1[0-3])\\-(0[1-9]|[1-2][0-9]|30)";
            //messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            ResourceBundle messageResource = null;
            // FacesContext context = null;
            if (!Pattern.matches(datePatern, value.toString().subSequence(0, value.toString().length()))) {
                ((UIInput) component).setValid(false);
                error(component, ("Invalid Date Format"));
            }
            if (value.toString().split("-")[1].equalsIgnoreCase("13")) {
                int year = Integer.parseInt(value.toString().split("-")[0]);
                int day = Integer.parseInt(value.toString().split("-")[2]);
                if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                    if (day > 6) {
                        ((UIInput) component).setValid(false);
                        error(component, ("Invalid Date Format"));
                    }
                } else if (day > 5) {
                    ((UIInput) component).setValid(false);
                    error(component, ("Invalid Date Format"));
                }

            }
        } catch (Exception ex) {
        }
    }

    public void sessionpopulateTable() {

        int count = sessionManagerObject.countEvaSession(searchValueAuthor);
        buttonIndicator = 0;


        try {
            if (count > 0) {
                enableButtons();
                disableComponentes();
                this.columnAuthorId.setRendered(true);
                this.columnEvaSessionId.setRendered(true);
                this.btnNewSessionESession.setDisabled(true);
                this.buttonStartESession.setDisabled(true);
                this.buttonUpdateESession.setDisabled(true);
                this.buttonResetESession.setDisabled(true);
                HashMap[] evaSessionList = sessionManagerObject.readEvaSessionRenderd(searchValueAuthor);

                for (int i = 0; i < count; i++) {
                    EvaluationSessionManager addToTable = new EvaluationSessionManager(evaSessionList[i].get("EVALUATION_SESSION_ID").hashCode(), evaSessionList[i].get("START_DATE").toString(), evaSessionList[i].get("END_DATE").toString(), evaSessionList[i].get("REFERENCE_NO").toString(), evaSessionList[i].get("REFERENCE_DATE").toString(), evaSessionList[i].get("PURPOSE").toString(), evaSessionList[i].get("AUTHORIZED_EMP_ID").toString(), evaSessionList[i].get("new_start_date").toString(), evaSessionList[i].get("new_end_date").toString());
                    this.evaSessionOPt.add(addToTable);
                }
            } else {
                disableButtons();
                this.buttonNewESession.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }

    }

    public void disableComponentes() {
        this.inputTextEvaSessionAutorized.setDisabled(true);
        this.inputTextEvaSessionDepartment.setDisabled(true);
        this.inputTextEvaSessionEndingDate.setDisabled(true);
        this.inputTextEvaSessionReferenceDate.setDisabled(true);
        this.inputTextEvaSessionReferenceNO.setDisabled(true);
        this.inputTextEvaSessionStartingDate.setDisabled(true);
        this.inputTextEvaSessionTitle.setDisabled(true);
        this.selectOneMenuEvaSession.setDisabled(true);
        this.txtSearchByNameEvaSession.setDisabled(true);
    }

    public void enableComponentes() {

        this.inputTextEvaSessionEndingDate.setDisabled(false);
        this.inputTextEvaSessionReferenceDate.setDisabled(false);
        this.inputTextEvaSessionReferenceNO.setDisabled(false);
        this.inputTextEvaSessionStartingDate.setDisabled(false);
        this.selectOneMenuEvaSession.setDisabled(false);
        this.txtSearchByNameEvaSession.setDisabled(false);
    }

    public void clearComponents() {
        this.inputTextEvaSessionEndingDate.setValue("");
        this.inputTextEvaSessionReferenceDate.setValue("");
        this.inputTextEvaSessionReferenceNO.setValue("");
        this.inputTextEvaSessionStartingDate.setValue("");
        this.selectOneMenuEvaSession.setValue("");
        this.inputTextEvaSessionAutorized.setValue("");
        this.inputTextEvaSessionDepartment.setValue("");
        this.inputTextEvaSessionEndingDate.setValue("");
        this.inputTextEvaSessionReferenceDate.setValue("");
        this.txtSearchByNameEvaSession.setValue("");
        this.inputTextEvaSessionTitle.setValue("");
        evaSessionOPt.clear();
        txtStartDate.setValue("");
        txtEnddate.setValue("");
    }

    public void disableButtons() {
        this.btnNewSessionESession.setDisabled(true);
        this.buttonDeleteESession.setDisabled(true);
        this.buttonEditESession.setDisabled(true);
        this.buttonNewESession.setDisabled(true);
        this.buttonResetESession.setDisabled(true);
        this.buttonStartESession.setDisabled(true);
        this.buttonUpdateESession.setDisabled(true);
        this.button1AuthorizerHistory.setDisabled(true);
    }

    public void enableButtons() {
        this.buttonDeleteESession.setDisabled(false);
        this.buttonEditESession.setDisabled(false);
        this.buttonNewESession.setDisabled(false);
        this.buttonResetESession.setDisabled(false);
        this.buttonStartESession.setDisabled(false);
        this.buttonUpdateESession.setDisabled(false);
    }

    public String txtSearchByNameEvaSession_action() {
        //return null means stay on the same page
        outputTexttxtSearchByNameEvaSessionSearch.setValue("");
        selectedId = this.getSessionBean1().getEmpId();
        this.loadEmployeeProfileDetail(selectedId);
        return null;
    }

    private void loadEmployeeProfileDetail(String empId) {
        this.inputTextSessionAutorID.setValue(null);
        this.inputTextEvaSessionAutorized.setValue(null);
        this.inputTextEvaSessionDepartment.setValue(null);
        this.inputTextEvaSessionTitle.setValue(null);


        try {
            employeeManager.loadEmpoyeeProfile(empId);
            inputTextSessionAutorID.resetValue();
            inputTextEvaSessionTitle.resetValue();
            this.inputTextSessionAutorID.setValue(empId);
            this.inputTextEvaSessionAutorized.setValue(employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            this.inputTextEvaSessionDepartment.setValue(employeeManager.getJobName());
            this.inputTextEvaSessionTitle.setValue(employeeManager.getTitleDes());


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String btnEvaSessionStartDateDateCalender_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnEvaSessionEndingDateDateCalender_action() {
        //return null means stay on the same page
        return null;
    }

    public String buttonResetESession_action() {
        if (buttonIndicator == 1) {
            init();
        } else if (buttonIndicator == 2) {
            evaSessionOPt.clear();
            this.buttonResetESession.setDisabled(true);

        } else if (buttonIndicator == 4) {
            this.selectOneMenuEvaSession.setValue("");
            this.inputTextEvaSessionAutorized.setValue("");
            this.inputTextEvaSessionDepartment.setValue("");
            this.inputTextEvaSessionEndingDate.setValue("");
            this.inputTextEvaSessionReferenceDate.setValue("");
            this.inputTextEvaSessionTitle.setValue("");
            this.inputTextEvaSessionReferenceNO.setValue("");
            this.inputTextEvaSessionStartingDate.setValue("");
            txtEnddate.setValue("");
            txtStartDate.setValue("");
            disableButtons();
            this.buttonNewESession.setDisabled(false);
            evaSessionOPt.clear();
            this.selectOneListbox1EvaSessionAuthorizerHistory.setDisabled(false);


        } else if (buttonIndicator == 8) {

            this.selectOneListbox1EvaSessionAuthorizerHistory.setDisabled(false);
            this.button1AuthorizerHistory.setDisabled(false);
            this.txtSearchByNameEvaSession.setDisabled(false);
            this.buttonNewESession.setDisabled(false);
            this.selectOneListbox1EvaSessionAuthorizerHistory.resetValue();
            evaSessionOPt.clear();


        }

        //return null means stay on the same page
        return null;
    }

    public String buttonNewESession_action() {
        buttonIndicator = 1;
        enableComponentes();
        clearComponents();
        disableButtons();
        this.btnNewSessionESession.setDisabled(false);
        this.columnAuthorId.setRendered(false);
        this.columnEvaSessionId.setRendered(false);
        this.buttonStartESession.setDisabled(false);
        this.buttonResetESession.setDisabled(false);
        this.button1AuthorizerHistory.setDisabled(false);
        this.selectOneListbox1EvaSessionAuthorizerHistory.setDisabled(false);

        //return null means stay on the same page
        return null;
    }

    public String btnNewSessionESession_action() {
        buttonIndicator = 2;
        String startDate = null;
        String endDate = null;
        String referenceNo = null;
        String referenceDate = null;
        String authorizedEmpID = null;
        String purpose = null;


        int dateDefferenceA = StringDateManipulation.compareDateDifference(this.inputTextEvaSessionStartingDate.getValue().toString(), this.inputTextEvaSessionEndingDate.getValue().toString());

        if (this.inputTextEvaSessionReferenceNO.getValue() != null && !this.inputTextEvaSessionReferenceNO.getValue().toString().equals("")) {
            referenceNo = this.inputTextEvaSessionReferenceNO.getValue().toString();
            inputTextEvaSessionReferenceNO.setValue("");
        } else {
            referenceNo = "No Reference";
        }
        if (this.inputTextEvaSessionStartingDate.getValue() != null) {
            startDate = this.inputTextEvaSessionStartingDate.getValue().toString();
        }
        if (this.inputTextSessionAutorID.getValue() != null) {
            authorizedEmpID = this.inputTextSessionAutorID.getValue().toString();
        }

        if (this.inputTextEvaSessionReferenceDate.getValue() != null && !this.inputTextEvaSessionReferenceDate.getValue().toString().equals("")) {
            referenceDate = this.inputTextEvaSessionReferenceDate.getValue().toString();

            if (selectOneMenuEvaSession.getValue().equals("0") || selectOneMenuEvaSession.getValue() == null) {
                outputTextForselectOneMenuEvaSession.setRendered(true);
                outputTextForselectOneMenuEvaSession.setValue("Requred");
            } else {
                if (this.inputTextEvaSessionEndingDate.getValue() != null && dateDefferenceA >= 0) {
                    endDate = this.inputTextEvaSessionEndingDate.getValue().toString();
                    purpose = sessionManagerObject.readSinglePurpose(Integer.valueOf(this.selectOneMenuEvaSession.getValue().toString()));
                    EvaluationSessionManager addEvaSessionToTable = new EvaluationSessionManager(startDate, endDate, referenceNo, referenceDate, authorizedEmpID, purpose, txtStartDate.getValue().toString(), txtEnddate.getValue().toString());
                    try {
                        this.evaSessionOPt.add(addEvaSessionToTable);

                    } catch (Exception e) {
                    }
                } else {
                    outputTextForEndingDate.setRendered(true);
                    outputTextForEndingDate.setValue("Invalid Date");
                }


            }
        } else {
            message1ReferenceDate.setRendered(true);
        }


        //return null means stay on the same page
        return null;
    }

    public String buttonStartESession_action() {
        buttonIndicator = 3;
        int chekSave = 0;
        List evaSessions = evaSessionOPt;
        Iterator<EvaluationSessionManager> ittEvaSession = evaSessions.iterator();
        while (ittEvaSession.hasNext()) {
            EvaluationSessionManager evaSess = ittEvaSession.next();
            chekSave = sessionManagerObject.addEvaSessionManager(evaSess.getStartDate(),
                    evaSess.getEndDate(), evaSess.getReferenceNo(), evaSess.getReferenceDate(), evaSess.getAuthorizedEmpID(),
                    evaSess.getPurpose(), evaSess.getStart_new_Date(), evaSess.getEnd_new_Date());
        }

        if (chekSave == 1) {
            this.showSuccessOrFailureMessage(true, "The Session is Started successfully !!!");
            clearComponents();
            disableComponentes();
            disableButtons();
            this.txtSearchByNameEvaSession.setValue(null);
            this.inputTextSessionAutorID.setValue(null);
            this.buttonNewESession.setDisabled(false);


        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
            clearComponents();

        }
        //return null means stay on the same page
        return null;
    }

    public void rowSelectorEvaSession_processMyEvent(RowSelectorEvent rse) {
        selectedEvaSessionRow = rse.getRow();
    }

    public String buttonEditESession_action() {
        buttonIndicator = 4;
        if (selectedEvaSessionRow == -1) {
            this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (evaSessionOPt.isEmpty() == true && selectedEvaSessionRow != -1) {
            this.showSuccessOrFailureMessage(false, "The Table is Empty!");

        } else {
            enableComponentes();
            disableButtons();
            this.buttonUpdateESession.setDisabled(false);
            this.buttonResetESession.setDisabled(false);

            int rowNumber = selectedEvaSessionRow;
            EvaluationSessionManager evaSession = (EvaluationSessionManager) evaSessionOPt.get(rowNumber);
            evaSessionOPt.remove(rowNumber);
            this.inputTextEvaSessionStartingDate.setValue(evaSession.getStartDate());
            this.inputTextEvaSessionEndingDate.setValue(evaSession.getEndDate());
            this.inputTextEvaSessionReferenceDate.setValue(evaSession.getReferenceDate());
            this.inputTextEvaSessionReferenceNO.setValue(evaSession.getReferenceNo());
            idSessionIdHolder = evaSession.getEvaSessionId();
            authorHolder = evaSession.getAuthorizedEmpID();
            this.txtStartDate.setValue(evaSession.getStart_new_Date());
            this.txtEnddate.setValue(evaSession.getEnd_new_Date());
        }
        //return null means stay on the same page
        return null;
    }

    public String buttonUpdateESession_action() {
        buttonIndicator = 5;
        int chekUpdate = 0;
        String startDate = null;
        String endDate = null;
        String referenceNo = null;
        String referenceDate = null;
//        String authorizedEmpID = null;
        String purpose = null;

        if (this.inputTextEvaSessionStartingDate.getValue() != null) {
            startDate = this.inputTextEvaSessionStartingDate.getValue().toString();
        }
        if (this.inputTextEvaSessionEndingDate.getValue() != null) {
            endDate = this.inputTextEvaSessionEndingDate.getValue().toString();
        }
        if (this.inputTextEvaSessionReferenceNO.getValue() != null) {
            referenceNo = this.inputTextEvaSessionReferenceNO.getValue().toString();
        }
        if (this.inputTextEvaSessionReferenceDate.getValue() != null) {
            referenceDate = this.inputTextEvaSessionReferenceDate.getValue().toString();
        }
//        if (this.inputTextSessionAutorID.getValue() != null) {
//            authorizedEmpID = this.inputTextSessionAutorID.getValue().toString();
//        }
        if (!selectOneMenuEvaSession.getValue().equals("0")) {
            purpose = sessionManagerObject.readSinglePurpose(Integer.valueOf(this.selectOneMenuEvaSession.getValue().toString()));
        }

        EvaluationSessionManager addEvaSessionToTable = new EvaluationSessionManager(idSessionIdHolder, startDate, endDate, referenceNo, referenceDate, authorHolder, purpose, txtStartDate.getValue().toString(), txtEnddate.getValue().toString());
        evaSessionOPt.add(addEvaSessionToTable);

        chekUpdate = sessionManagerObject.updateEvaSession(idSessionIdHolder, startDate, endDate, referenceNo, referenceDate, authorHolder, purpose, txtStartDate.getValue().toString(), txtEnddate.getValue().toString());

        if (chekUpdate == 1) {
            this.showSuccessOrFailureMessage(true, "The Evaluation Criteria record is successfully Updated!");
            sessionAuthorizerHistory = sessionManagerObject.loadSessionAuthorizer(this.inputTextSessionAutorID.getValue().toString());
            clearComponents();
            sessionpopulateTable();
            this.buttonUpdateESession.setDisabled(true);


        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured during Updating .Please Try Again?");
            clearComponents();
            sessionpopulateTable();
        }

        //return null means stay on the same page
        return null;
    }

    public String buttonDeleteESession_action() {
        buttonIndicator = 6;
        if (selectedEvaSessionRow == -1) {
            this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (evaSessionOPt.isEmpty() == true && selectedEvaSessionRow != -1) {
            this.showSuccessOrFailureMessage(false, "The Table is Empty!");

        } else {
            lblevaSessionPopUpMsgMain.setValue("Are you shure You want to delete this record?");
            evaSessionPopUpMsg.setRendered(true);
            btnevaSessionPopUpNo.setRendered(true);
            btnevaSessionPopUpYes.setRendered(true);
        }

        //return null means stay on the same page
        return null;
    }

    public String btnevaSessionPopUpYes_action() {
        evaSessionPopUpMsg.setRendered(false);
        int chekDelete = 0;
        int rowNumber = selectedEvaSessionRow;
        EvaluationSessionManager evaSession = (EvaluationSessionManager) evaSessionOPt.get(rowNumber);
        evaSessionOPt.remove(rowNumber);
        chekDelete = sessionManagerObject.deleteEvaSession(evaSession.getEvaSessionId());
        sessionAuthorizerHistory = sessionManagerObject.loadSessionAuthorizer(this.inputTextSessionAutorID.getValue().toString());
        //return null means stay on the same page
        return null;
    }

    public String btnevaSessionPopUpNo_action() {
        evaSessionPopUpMsg.setRendered(false);
        clearComponents();
        sessionpopulateTable();
        //return null means stay on the same page
        return null;
    }

    public String button1AuthorizerHistory_action() {
        buttonIndicator = 7;
        evaSessionOPt.clear();
        if (this.inputTextSessionAutorID.getValue() != null && !this.inputTextSessionAutorID.getValue().toString().equals("")) {
            sessionAuthorizerHistory = sessionManagerObject.loadSessionAuthorizer(this.inputTextSessionAutorID.getValue().toString());
            disableButtons();
            this.buttonNewESession.setDisabled(false);
        } else {
            outputTexttxtSearchByNameEvaSessionSearch.setValue("Search Here First");
            outputTexttxtSearchByNameEvaSessionSearch.setRendered(true);
        }
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1EvaSessionAuthorizerHistory_processValueChange(ValueChangeEvent vce) {
        buttonIndicator = 8;
        String str[] = vce.getNewValue().toString().split("---");
        searchValueAuthor = str[0];
        int count = sessionManagerObject.countEvaSession(searchValueAuthor);

        try {
            if (count > 0) {
                enableButtons();
                disableComponentes();
                this.columnAuthorId.setRendered(true);
                this.columnEvaSessionId.setRendered(true);
                disableButtons();
                this.buttonResetESession.setDisabled(false);
                this.buttonEditESession.setDisabled(false);
                this.buttonDeleteESession.setDisabled(false);
                evaSessionOPt.clear();
                HashMap[] evaSessionList = sessionManagerObject.readEvaSessionRenderd(searchValueAuthor);

                for (int i = 0; i < count; i++) {
                    EvaluationSessionManager addToTable = new EvaluationSessionManager(evaSessionList[i].get("EVALUATION_SESSION_ID").hashCode(), evaSessionList[i].get("START_DATE").toString(), evaSessionList[i].get("END_DATE").toString(), evaSessionList[i].get("REFERENCE_NO").toString(), evaSessionList[i].get("REFERENCE_DATE").toString(), evaSessionList[i].get("PURPOSE").toString(), evaSessionList[i].get("AUTHORIZED_EMP_ID").toString(), evaSessionList[i].get("new_start_date").toString(), evaSessionList[i].get("new_end_date").toString());
                    evaSessionOPt.add(addToTable);
                }
            } else {
                disableButtons();
                evaSessionOPt.clear();
                this.buttonNewESession.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();


        }

    }

    public String buttonCalReferenceDate_action() {
        this.inputTextEvaSessionReferenceDate.setValue("");
        calReferenceDate.setRendered(true);
        return null;
    }

    public void inputTextEvaSessionReferenceDate_validate(FacesContext context, UIComponent component, Object value) {
        dateValidator(context, component, value);
        message1ReferenceDate.setVisible(false);
    }

    public int calculateEmpServiceDays(String currentDate, String terminateDate) {
        int serviceInDays = 0;
        if (terminateDate.length() >= 1) {
            serviceInDays = StringDateManipulation.compareDateDifference(currentDate, terminateDate);
            return serviceInDays;
        } else {
        }

        return serviceInDays;
    }

    public void inputTextEvaSessionStartingDate_validate(FacesContext context, UIComponent component, Object value) {
        dateValidator(context, component, value);
        String currDate = StringDateManipulation.toDayInEc();
        int dateDefference = this.calculateEmpServiceDays(currDate, inputTextEvaSessionStartingDate.getValue().toString());
        if (dateDefference < 0) {
            ((UIInput) component).setValid(false);
            error(component, ("Invalid Date"));
        }
    }

    public void inputTextEvaSessionEndingDate_validate(FacesContext context, UIComponent component, Object value) {
        dateValidator(context, component, value);
//        int dateDefferenceA = -1;
//         dateDefferenceA = StringDateManipulation.compareDateDifference(this.inputTextEvaSessionStartingDate.getValue().toString(), this.inputTextEvaSessionEndingDate.getValue().toString());
//        if (dateDefferenceA < 0 ) {
//            ((UIInput) component).setValid(false);
//            error(component, ("Invalid Date"));
//        }
    }

    public String buttonCalEndingDate_action() {
        inputTextEvaSessionEndingDate.setValue("");
        calEndingDate.setRendered(true);
        return null;
    }

    public String commandLink1_action() {

        //return null means stay on the same page
        return "EvaluationSession";
    }

    public String commandLink2_action() {
        //return null means stay on the same page
        return "EvaluationResult";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "EvaluationCriterias";
    }

    public String buttonCalStartingDate_action() {
        this.outputTextForStartingDate.setValue("");
        calFromDate.setRendered(true);
        return null;
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

    public void inputTextEvaSessionReferenceDate_processValueChange(ValueChangeEvent vce) {
        outputTextForEndingDate.setRendered(false);
        outputTextForEndingDate.setValue("");
    }

    public void inputTextEvaSessionStartingDate_processValueChange(ValueChangeEvent vce) {
        outputTextForEndingDate.setRendered(false);
        outputTextForEndingDate.setValue("");
    }

    public void inputTextEvaSessionEndingDate_processValueChange(ValueChangeEvent vce) {
        outputTextForEndingDate.setRendered(false);
        outputTextForEndingDate.setValue("");
    }

    public void selectOneMenuEvaSession_processValueChange(ValueChangeEvent vce) {
        outputTextForselectOneMenuEvaSession.setRendered(false);
        outputTextForselectOneMenuEvaSession.setValue("");
    }

    public void calFromDate_processValueChange(ValueChangeEvent vce) {

        String selectedDate = dateFormat.format((Date) calFromDate.getValue());
        inputTextEvaSessionStartingDate.setValue(dateFormat.format(calFromDate.getValue()));

        calFromDate.setRendered(false);
    }

    public void calReferenceDate_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) calReferenceDate.getValue());
        inputTextEvaSessionReferenceDate.setValue(dateFormat.format(calReferenceDate.getValue()));

        calReferenceDate.setRendered(false);
    }

    public void calEndingDate_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) calEndingDate.getValue());
        inputTextEvaSessionEndingDate.setValue(dateFormat.format(calEndingDate.getValue()));
        calEndingDate.setRendered(false);
    }

    public String calendarStartDate_action() {
        //return null means stay on the same page
//        this.outputTextForStartingDate.setValue("");
        calSessionStartDate.setRendered(true);
        return null;
    }

    public void buttonCalReferenceDate_processAction(ActionEvent ae) {
    }

    public void calSessionStartDate_processValueChange(ValueChangeEvent vce) {

        String selectedDate = dateFormat.format((Date) calSessionStartDate.getValue());
        txtStartDate.setValue(dateFormat.format(calSessionStartDate.getValue()));

        calSessionStartDate.setRendered(false);
    }

    public void sessionEndDate_processValueChange(ValueChangeEvent vce) {

        String selectedDate = dateFormat.format((Date) sessionEndDate.getValue());
        txtEnddate.setValue(dateFormat.format(sessionEndDate.getValue()));

        sessionEndDate.setRendered(false);
    }

    public void buttonCalStartingDate_processAction(ActionEvent ae) {
    }

    public String calendarEndDate_action() {
        //return null means stay on the same page
        sessionEndDate.setRendered(true);
        return null;
    }
}

