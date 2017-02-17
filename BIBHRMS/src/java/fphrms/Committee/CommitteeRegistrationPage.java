/*
 * CommitteeRegistrationPage.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Committee;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.LookUpManger;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.committeeManager.CommitteeModel;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CommitteeRegistrationPage extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {

        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        populateApproverTextComponents(loggedInEmployeeId);

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
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
    private HtmlSelectOneMenu drlCommitteeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeType() {
        return drlCommitteeType;
    }

    public void setDrlCommitteeType(HtmlSelectOneMenu hsom) {
        this.drlCommitteeType = hsom;
    }
    private DefaultSelectedData selectedObjectCommitteeStatus = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectCommitteeStatus() {
        return selectedObjectCommitteeStatus;
    }

    public void setSelectedObjectCommitteeStatus(DefaultSelectedData selectedObjectCommitteeStatus) {
        this.selectedObjectCommitteeStatus = selectedObjectCommitteeStatus;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private HtmlInputTextarea txtaDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDescription() {
        return txtaDescription;
    }

    public void setTxtaDescription(HtmlInputTextarea hit) {
        this.txtaDescription = hit;
    }
    private HtmlInputText txtCommitteeName1 = new HtmlInputText();

    public HtmlInputText getTxtCommitteeName1() {
        return txtCommitteeName1;
    }

    public void setTxtCommitteeName1(HtmlInputText hit) {
        this.txtCommitteeName1 = hit;
    }
    private HtmlInputText txtCommitteeName = new HtmlInputText();

    public HtmlInputText getTxtCommitteeName() {
        return txtCommitteeName;
    }

    public void setTxtCommitteeName(HtmlInputText hit) {
        this.txtCommitteeName = hit;
    }
    private HtmlInputTextarea txtaResponsiblity = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaResponsiblity() {
        return txtaResponsiblity;
    }

    public void setTxtaResponsiblity(HtmlInputTextarea hit) {
        this.txtaResponsiblity = hit;
    }
    private HtmlInputText txtEstablishedDate = new HtmlInputText();

    public HtmlInputText getTxtEstablishedDate() {
        return txtEstablishedDate;
    }

    public void setTxtEstablishedDate(HtmlInputText txtEstablishedDate) {
        this.txtEstablishedDate = txtEstablishedDate;
    }
    private HtmlSelectOneMenu drlCommitteeStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCommitteeStatus() {
        return drlCommitteeStatus;
    }

    public void setDrlCommitteeStatus(HtmlSelectOneMenu hsom) {
        this.drlCommitteeStatus = hsom;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calEstablishedDate = new SelectInputDate();

    public SelectInputDate getCalEstablishedDate() {
        return calEstablishedDate;
    }

    public void setCalEstablishedDate(SelectInputDate sid) {
        this.calEstablishedDate = sid;
    }
    private HtmlInputTextarea txt_commitedesc = new HtmlInputTextarea();

    public HtmlInputTextarea getTxt_commitedesc() {
        return txt_commitedesc;
    }

    public void setTxt_commitedesc(HtmlInputTextarea hit) {
        this.txt_commitedesc = hit;
    }
    private HtmlCommandButton btn_Save = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Save() {
        return btn_Save;
    }

    public void setBtn_Save(HtmlCommandButton hcb) {
        this.btn_Save = hcb;
    }
    private HtmlCommandButton btn_Close = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Close() {
        return btn_Close;
    }

    public void setBtn_Close(HtmlCommandButton hcb) {
        this.btn_Close = hcb;
    }
    private HtmlInputText txt_CommiteeName = new HtmlInputText();

    public HtmlInputText getTxt_CommiteeName() {
        return txt_CommiteeName;
    }

    public void setTxt_CommiteeName(HtmlInputText hit) {
        this.txt_CommiteeName = hit;
    }
    private HtmlOutputLabel out_txt_FormaerName = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_FormaerName() {
        return out_txt_FormaerName;
    }

    public void setOut_txt_FormaerName(HtmlOutputLabel hol) {
        this.out_txt_FormaerName = hol;
    }
    private HtmlOutputLabel out_txt_FormerDepartment = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_FormerDepartment() {
        return out_txt_FormerDepartment;
    }

    public void setOut_txt_FormerDepartment(HtmlOutputLabel hol) {
        this.out_txt_FormerDepartment = hol;
    }
    private HtmlOutputLabel out_txt_formerPosition = new HtmlOutputLabel();

    public HtmlOutputLabel getOut_txt_formerPosition() {
        return out_txt_formerPosition;
    }

    public void setOut_txt_formerPosition(HtmlOutputLabel hol) {
        this.out_txt_formerPosition = hol;
    }
  


    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CommitteeRegistrationPage() {
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
// </editor-fold >
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    public int get__placeholder() {
        return __placeholder;
    }

    public ArrayList<SelectItem> getCommitteeTypesList() {
        return committeeTypesList;
    }

    public void setCommitteeTypesList(ArrayList<SelectItem> committeeTypesList) {
        this.committeeTypesList = committeeTypesList;
    }

    public ArrayList<SelectItem> getCommitteeStatusList() {
        return committeeStatusList;
    }

    public void setCommitteeStatusList(ArrayList<SelectItem> committeeStatusList) {
        this.committeeStatusList = committeeStatusList;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int committeeId) {
        this.committeeId = committeeId;
    }

    public ArrayList<CommitteeModel> getCommitteeLists() {
        return committeeLists;
    }

    public void setCommitteeLists(ArrayList<CommitteeModel> committeeLists) {
        this.committeeLists = committeeLists;
    }

    public CommitteeModel getCommitteeModel() {
        return committeeModel;
    }

    public void setCommitteeModel(CommitteeModel committeeModel) {
        this.committeeModel = committeeModel;
    }

    public String getCommitteeName() {
        return committeeName;
    }

    public void setCommitteeName(String committeeName) {
        this.committeeName = committeeName;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }
   private PanelLayout pnlContainer = new PanelLayout();
   private PanelPopup pnlPopUp = new PanelPopup();
  private HtmlInputText txtTableNames = new HtmlInputText();

    public HtmlInputText getTxtTableNames() {
        return txtTableNames;
    }

    public void setTxtTableNames(HtmlInputText txtTableNames) {
        this.txtTableNames = txtTableNames;
    }

    public PanelLayout getPnlContainer() {

        return pnlContainer;
    }

    public void setPnlContainer(PanelLayout pnlContainer) {
        this.pnlContainer = pnlContainer;
    }

    public PanelPopup getPnlPopUp() {
        return pnlPopUp;
    }

    public void setPnlPopUp(PanelPopup pnlPopUp) {
        this.pnlPopUp = pnlPopUp;
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

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }


    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public int getSelectedRow() {
        return selectedRow;
    }

    public void setSelectedRow(int selectedRow) {
        this.selectedRow = selectedRow;
    }

    public CommitteeRegistrationManager getCommitteeRegistrationManager() {
        return committeeRegistrationManager;
    }

    public void setCommitteeRegistrationManager(CommitteeRegistrationManager committeeRegistrationManager) {
        this.committeeRegistrationManager = committeeRegistrationManager;
    }

    public String getCommitteeStatus() {
        return committeeStatus;
    }

    public void setCommitteeStatus(String committeeStatus) {
        this.committeeStatus = committeeStatus;
    }

    public String getCommitteeType() {
        return committeeType;
    }

    public void setCommitteeType(String committeeType) {
        this.committeeType = committeeType;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(String establishedDate) {
        this.establishedDate = establishedDate;
    }

    public int getNumberOfmembers() {
        return numberOfmembers;
    }

    public void setNumberOfmembers(int numberOfmembers) {
        this.numberOfmembers = numberOfmembers;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getResponsiblity() {
        return responsiblity;
    }

    public void setResponsiblity(String responsiblity) {
        this.responsiblity = responsiblity;
    }
      private PanelLayout divValue = new PanelLayout();
       public PanelLayout getDivValue() {
        divValue.setStyle("display: block; left: 190px;");
        return divValue;
    }
    // </editor-fold>
    CommitteeRegistrationManager committeeRegistrationManager = new CommitteeRegistrationManager();
    ArrayList<CommitteeModel> committeeLists = committeeRegistrationManager.getAllActiveCommittees();
    ArrayList<SelectItem> committeeTypesList = committeeRegistrationManager.getCommitteeTypes();
    ArrayList<SelectItem> committeeTypesListFromLu = committeeRegistrationManager.getAllCommitteesTypeForLu();

    public LookUpManger getLuManager() {
        return luManager;
    }

    public void setLuManager(LookUpManger luManager) {
        this.luManager = luManager;
    }

    ArrayList<SelectItem> committeeStatusList = committeeRegistrationManager.getCommitteeStatus();
    CommitteeModel committeeModel = new CommitteeModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    /*COMMITTEE_ID
    COMMITTEE_NAME
    COMMITTEE_TYPE
    DESCRIPTION
    NUM_OF_MEMBERS
    ESTABLISHED_DATE
    STATUS
    RESPONSIBLITY
    PARENT_ID*/
    int committeeId;
    String committeeName;

    String committeeType;
    String committeeStatus;
    String description;
    String responsiblity;
    String establishedDate;
    int parentId;
    String databaseStatus;
    int numberOfmembers;
   String loggedInEmployeeId = "";// getSessionBean1().getEmployeeId();
    String loggedInEmployeeDept = "";
    String formerName;
    String formerPosition;
    String formerDepartment;
     EmployeeManage employeeManager = new EmployeeManage();

    public ArrayList<SelectItem> getCommitteeTypesListFromLu() {
        return committeeTypesListFromLu;
    }

    public void setCommitteeTypesListFromLu(ArrayList<SelectItem> committeeTypesListFromLu) {
        this.committeeTypesListFromLu = committeeTypesListFromLu;
    }

    public String btnReset_action() {
        clearCommitteeComponents();
        committeeLists = committeeRegistrationManager.getAllActiveCommittees();
        return null;
    }

    public String btnSave_action() {
        if (committeeRegistrationManager.saveCommitttees(committeeLists)) {
            showSuccessOrFailureMessage(true, "SAVING SUCCEDDED");
            committeeLists = committeeRegistrationManager.getAllActiveCommittees();
        } else {
            showSuccessOrFailureMessage(false, "SAVING FAILES");
        }
        return null;
    }
    int selectedRow = -1;

    public void rowSelectorOverTime_processMyEvent(RowSelectorEvent rse) {
        selectedRow = rse.getRow();
    }

    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

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

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    boolean validateAndInitialize() {
        try {
            committeeName = txtCommitteeName.getValue().toString();
            committeeType = drlCommitteeType.getValue().toString();
            committeeStatus = selectedObjectCommitteeStatus.getSelectedObject().toString();//drlCommitteeType.getValue().toString();
            description = txtaDescription.getValue().toString();
            responsiblity = txtaResponsiblity.getValue().toString();
            establishedDate = txtEstablishedDate.getValue().toString();
            formerName=out_txt_FormaerName.getValue().toString();
            formerPosition=out_txt_formerPosition.getValue().toString();
            formerDepartment=out_txt_FormerDepartment.getValue().toString();
            databaseStatus = "New";

            if (committeeStatus.equals("-1") || committeeType.equals("-1")) {
                showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
                return false;
            }
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, "ALL FIELDS SHOULD BE FILLED");
            return false;
        }
        return true;
    }


    boolean clearCommitteeComponents() {
        txtCommitteeName.setValue(null);
        drlCommitteeType.setValue(null);
        drlCommitteeType.resetValue();
        txtaDescription.setValue(null);
        txtEstablishedDate.setValue(null);
        databaseStatus = "New";

        return true;
    }


    public String btnAddToTable_action() {
        if (validateAndInitialize()) {
            committeeModel = new CommitteeModel(committeeName, committeeType, committeeStatus, description, responsiblity, establishedDate, databaseStatus,formerName,formerDepartment,formerPosition);
            committeeLists.add(committeeModel);
            clearCommitteeComponents();
        }
        return null;
    }

    public String cmdLnkRemove_action() {
        if (selectedRow != -1) {
            if (committeeLists.get(selectedRow).getDatabaseStatus().equals("New")) {
                committeeLists.remove(selectedRow);
            } else {//if Edited or Old
                committeeLists.get(selectedRow).setDatabaseStatus("Deleted");


            }
        }
        return null;
    }

    public String cmdLnkOk_action() {
        if (committeeLists.get(selectedRow).getDatabaseStatus().equals("Old")) {
             committeeLists.get(selectedRow).setDatabaseStatus("Edited");
            // committeeModel.setDatabaseStatus("Edited");
        }

        else {//if Edited or Old
            committeeLists.get(selectedRow).setDatabaseStatus("Edited");
        }
        return null;
    }

    public String btnCalEstablishedDate_action() {
        calEstablishedDate.setRendered(true);
        return null;
    }

    public void calEstablishedDate_processValueChange(ValueChangeEvent vce) {
        txtEstablishedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEstablishedDate.setRendered(false);

    }
     public void imgPopX_processAction(ActionEvent ae) {
        pnlPopUp.setRendered(false);
    }
       LookUpManger luManager = new LookUpManger();
    

    public String btn_PopCommittee_action() {
        //return null means stay on the same page

        pnlPopUp.setRendered(true);
        return null;
    }

   
   

    public String btn_Save_action() {
        //return null means stay on the same page
        String commiteeName;
        String committeeDescribtion;
        commiteeName=txt_CommiteeName.getValue().toString();
        committeeDescribtion=txt_commitedesc.getValue().toString();
        if(committeeRegistrationManager.saveCommiteeType(commiteeName,committeeDescribtion)){
        
         showSuccessOrFailureMessage(true, "Saving is Good");
        }
        else{
         showSuccessOrFailureMessage(false, "SAVING IS  FILLED");
        }

        return null;
    }

    public String btn_Close_action() {
        pnlPopUp.setRendered(false);
        return null;
    }

     private void populateApproverTextComponents(String approverId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = loggedInEmployeeId;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
               // txtDeciderId.setDisabled(false);
            } else {
                try {

                    approverId = empInfoHashMap.get("employeeId").toString();
                    out_txt_FormerDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                    out_txt_FormaerName.setValue(empInfoHashMap.get("employeeFullName"));
                    out_txt_formerPosition.setValue(empInfoHashMap.get("employeePosition"));
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }



   
}
