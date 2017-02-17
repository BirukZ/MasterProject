/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Authorization;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.CustomValidations;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.AuthorizationModel;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class AuthorizationPage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
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
    private HtmlInputText txtDeligatorDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeligatorDepartment() {
        return txtDeligatorDepartment;
    }

    public void setTxtDeligatorDepartment(HtmlInputText hit) {
        this.txtDeligatorDepartment = hit;
    }
    private HtmlInputText txtDeligatorId = new HtmlInputText();

    public HtmlInputText getTxtDeligatorId() {
        return txtDeligatorId;
    }

    public void setTxtDeligatorId(HtmlInputText hit) {
        this.txtDeligatorId = hit;
    }
    private HtmlInputText txtDeligatorPosition = new HtmlInputText();

    public HtmlInputText getTxtDeligatorPosition() {
        return txtDeligatorPosition;
    }

    public void setTxtDeligatorPosition(HtmlInputText hit) {
        this.txtDeligatorPosition = hit;
    }
    private HtmlInputText txtDeligatorFullName = new HtmlInputText();

    public HtmlInputText getTxtDeligatorFullName() {
        return txtDeligatorFullName;
    }

    public void setTxtDeligatorFullName(HtmlInputText hit) {
        this.txtDeligatorFullName = hit;
    }
    private HtmlInputText txtDeligatorTItile = new HtmlInputText();

    public HtmlInputText getTxtDeligatorTItile() {
        return txtDeligatorTItile;
    }

    public void setTxtDeligatorTItile(HtmlInputText hit) {
        this.txtDeligatorTItile = hit;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlInputText txtDeciderRank = new HtmlInputText();

    public HtmlInputText getTxtDeciderRank() {
        return txtDeciderRank;
    }

    public void setTxtDeciderRank(HtmlInputText hit) {
        this.txtDeciderRank = hit;
    }
    private HtmlInputText txtApprovedStartDate = new HtmlInputText();

    public HtmlInputText getTxtApprovedStartDate() {
        return txtApprovedStartDate;
    }

    public void setTxtApprovedStartDate(HtmlInputText hit) {
        this.txtApprovedStartDate = hit;
    }
    private HtmlInputText txtApprovedEndDate = new HtmlInputText();

    public HtmlInputText getTxtApprovedEndDate() {
        return txtApprovedEndDate;
    }

    public void setTxtApprovedEndDate(HtmlInputText hit) {
        this.txtApprovedEndDate = hit;
    }
    private HtmlInputText txtTakenEndDate = new HtmlInputText();

    public HtmlInputText getTxtTakenEndDate() {
        return txtTakenEndDate;
    }

    public void setTxtTakenEndDate(HtmlInputText hit) {
        this.txtTakenEndDate = hit;
    }
    private HtmlInputText txtTakenStartDate = new HtmlInputText();

    public HtmlInputText getTxtTakenStartDate() {
        return txtTakenStartDate;
    }

    public void setTxtTakenStartDate(HtmlInputText hit) {
        this.txtTakenStartDate = hit;
    }
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
    private PanelPopup pnlPopupInsertProcessState = new PanelPopup();

    public PanelPopup getPnlPopupInsertProcessState() {
        return pnlPopupInsertProcessState;
    }

    public void setPnlPopupInsertProcessState(PanelPopup pp) {
        this.pnlPopupInsertProcessState = pp;
    }
    private HtmlSelectOneMenu drlProcessInPopup = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProcessInPopup() {
        return drlProcessInPopup;
    }
    HtmlSelectBooleanCheckbox cbkCanBeFinal = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCbkCanBeFinal() {
        return cbkCanBeFinal;
    }

    public void setCbkCanBeFinal(HtmlSelectBooleanCheckbox cbkCanBeFinal) {
        this.cbkCanBeFinal = cbkCanBeFinal;
    }

    public void setDrlProcessInPopup(HtmlSelectOneMenu hsom) {
        this.drlProcessInPopup = hsom;
    }
    private HtmlInputText txtStateName = new HtmlInputText();

    public HtmlInputText getTxtStateName() {
        return txtStateName;
    }

    public void setTxtStateName(HtmlInputText hit) {
        this.txtStateName = hit;
    }
    private HtmlInputTextarea txtStateDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtStateDescription() {
        return txtStateDescription;
    }

    public void setTxtStateDescription(HtmlInputTextarea hit) {
        this.txtStateDescription = hit;
    }
    private HtmlSelectOneMenu drlProcess = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProcess() {
        return drlProcess;
    }

    public void setDrlProcess(HtmlSelectOneMenu hsom) {
        this.drlProcess = hsom;
    }
    private HtmlSelectOneMenu drlRole = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRole() {
        return drlRole;
    }

    public void setDrlRole(HtmlSelectOneMenu hsom) {
        this.drlRole = hsom;
    }
    private HtmlSelectOneMenu drlProcessState = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProcessState() {
        return drlProcessState;
    }

    public void setDrlProcessState(HtmlSelectOneMenu hsom) {
        this.drlProcessState = hsom;
    }
    private HtmlCommandButton btnClosePopupInsertState = new HtmlCommandButton();

    public HtmlCommandButton getBtnClosePopupInsertState() {
        return btnClosePopupInsertState;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public void setBtnClosePopupInsertState(HtmlCommandButton hcb) {
        this.btnClosePopupInsertState = hcb;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private PanelLayout pnlMessageBody = new PanelLayout();

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pl) {
        this.pnlMessageBody = pl;
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


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public AuthorizationPage() {
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
    AuthorizationManager authorizationManager = new AuthorizationManager();
    ArrayList authorizedStates = new ArrayList();
    ArrayList<SelectItem> rolesList = (new SiteSecurityManager()).getAvailableRolesWithId();
    ArrayList<Option> statesList = new ArrayList<Option>();
    ArrayList<Option> processesList = AuthorizationManager.getProcessTypes();
    ArrayList<AuthorizationModel> authorizationModelLists = new ArrayList<AuthorizationModel>();

    public ArrayList getAuthorizedStates() {
        return authorizedStates;
    }

    public void setAuthorizedStates(ArrayList authorizedStates) {
        this.authorizedStates = authorizedStates;
    }

    public String selTxtEmployeeSearch_action() {
        String requesterId = ApplicationBean1.getSelectedEmployeeId();
//        populateRequesterAndRequestAttributes(requesterId);
//        txtRequesterId.setValue(requesterId);
//        txtSearchById.setValue(requesterId);
//        makePageReadyForUpdate();
        return null;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public ArrayList<Option> getProcessesList() {
        return processesList;
    }

    public void setProcessesList(ArrayList<Option> processesList) {
        this.processesList = processesList;
    }

    public static int getCounter() {
        return counter;
    }

    public static void setCounter(int counter) {
        AuthorizationPage.counter = counter;
    }

    public ArrayList<SelectItem> getRolesList() {
        return rolesList;
    }

    public void setRolesList(ArrayList<SelectItem> rolesList) {
        this.rolesList = rolesList;
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    public ArrayList<AuthorizationModel> getAuthorizationModelLists() {
        return authorizationModelLists;
    }

    public void setAuthorizationModelLists(ArrayList<AuthorizationModel> authorizationModelLists) {
        this.authorizationModelLists = authorizationModelLists;
    }

    public ArrayList<Option> getStatesList() {
        return statesList;
    }

    public void setStatesList(ArrayList<Option> statesList) {
        this.statesList = statesList;
    }

    public String btnSaveState_action() {
        if (txtStateName.getValue() == null || txtStateName.getValue().equals("")) {
            // showSuccessOrFailureMessage(false, "INSERT NAME");
        } else if (drlProcessInPopup.getValue() == null || drlProcessInPopup.getValue().toString().equals("-1")) {
            // showSuccessOrFailureMessage(false, " PROCESS NOT SELECTED ");
        } else {
            pnlPopupInsertProcessState.setRendered(false);
            String processId = drlProcessInPopup.getValue().toString();
            String processName = txtStateName.getValue().toString();
            String processSateDescription = txtStateDescription.getValue().toString();
            boolean canBeFinal = cbkCanBeFinal.isSelected();
            if (authorizationManager.saveState(processId, processName, processSateDescription, canBeFinal)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFULL");
                statesList = AuthorizationManager.getProcessStates(drlProcessInPopup.getValue().toString());
            } else {
                showSuccessOrFailureMessage(false, "NOT SAVED PLZ TRY AGAIN");
            }
        }

        txtStateName.setValue(null);
        return null;
    }

    public String btnAddProcessState_action() {
        if (drlProcess.getValue() != null && drlProcess.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT PROCESS FIRST");
        } else {
            pnlPopupInsertProcessState.setRendered(true);
        }
        return null;
    }

    public void drlProcess_processValueChange(ValueChangeEvent vce) {
        if (vce != null && !vce.getNewValue().toString().equals("-1")) {
            statesList = AuthorizationManager.getProcessStates(vce.getNewValue().toString());
            authorizationModelLists = authorizationManager.getAuthorizedStates(vce.getNewValue().toString());
        } else {
            statesList = new ArrayList<Option>();
        }
    }

    private boolean validateAuthorization() {
        if (drlProcess.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT PROCESS");
            return false;
        } else if (drlProcessState.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT STATE");
            return false;
        } else if (drlRole.getValue() == null || drlRole.getValue().toString().equals("-1")) {
            showSuccessOrFailureMessage(false, "SELECT ROLE");
            return false;
        } else if (authorizationModelLists.size() > 0) {
            String processState = drlProcessState.getValue().toString();
  
        }
        return true;
    }
    static int counter = 0;

    public String btnAddToTable_action() {
        if (validateAuthorization()) {
            String processId = drlProcess.getValue().toString();
            String processName = drlProcess.getValue().toString();//drlProcess.getLabel().toString();
            String stateId = drlProcessState.getValue().toString();
            String stateName = drlProcessState.getValue().toString();// drlProcessState.getLabel().toString();
            String roleId = drlRole.getValue().toString();
            String roleName = drlRole.getValue().toString();//drlRole.getLabel().toString();
            counter++;
            AuthorizationModel authorizationModel = new AuthorizationModel(counter, processId, stateId, roleId, processName, stateName, roleName);
            authorizationModelLists.add(authorizationModel);
        }
        return null;
    }

    public String btnReset_action() {
        authorizationModelLists = new ArrayList<AuthorizationModel>();
        counter = 0;
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupInsertState_action() {
        txtStateName.setValue(null);
        pnlPopupInsertProcessState.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnPostDecision_action() {
        if (authorizationModelLists != null && authorizationModelLists.size() > 0) {
            if (authorizationManager.saveAuthorizations(authorizationModelLists)) {
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
            } else {
                showSuccessOrFailureMessage(false, "SORYY SAVING FAILED");
            }
        }
        //return null means stay on the same page
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public void pnlGrpPowerDeligationContent_processMyEvent(DragEvent de) {
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

    public void drlProcessState_processValueChange(ValueChangeEvent vce) {
    }
}
