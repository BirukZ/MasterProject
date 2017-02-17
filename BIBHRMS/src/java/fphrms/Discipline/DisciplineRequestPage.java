/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright mekete Vs BravoZulu
 */
package fphrms.Discipline;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlMessage;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataProvider;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.sql.Timestamp;
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
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import manager.disciplineManager.DisciplineRegistrationManager;
import manager.disciplineManager.DisciplineRequestManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeManager.EmployeeManage;
import fphrms.Termination.RetireRequestPage;
import fphrms.Report.MainReport;
import fphrms.Template_1;
import fphrms.Termination.RetireApprovalPage;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.disciplineManager.DisciplineApproveManager;
import manager.disciplineManager.DisciplinePenaltyRegistrationManager;
import manager.disciplineManager.EyeWitnessManager;
import manager.disciplineManager.EyeWitnessManager.EyeWitnessModel;
import manager.disciplineManager.EyeWitnessManager.OtherMemberEyeWitnessModel;
import manager.globalUseManager.LookUpManager;
import control.LookUpManger;
import entity.disciplineEntity.DisciplineApproveEntity;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import manager.globalUseManager.HRValidation;
import manager.powerDeligationManager.PowerDeligationRequestManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DisciplineRequestPage extends AbstractPageBean {
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
        loggedInEmployeeDept = getSessionBean1().getEmpDeptId();
        userName = getSessionBean1().getUserName();
        disciplineRequestManager.setUserName(userName);
        disciplineRequestManager.setLoggedinEmployeeId(loggedInEmployeeId);
        radioGroupApplierType.resetValue();
        groupEyeWitnessType.resetValue();
        lnkRecordEyeWitnesses.setDisabled(true);
        lnkOtherWitness.setDisabled(true);
        lnkOtherWitness.setRendered(false);
        drl_Reputaion.setDisabled(true);
        txtReportedDate.setValue(dateFormat.format(new Date()));
        historyRequestLists = disciplineRequestManager.getRequestsByRequester();
        pendingListsThatCanBeApproved = disciplineRequestManager.getPendingRequestsCanBeApprovrd();
        this.setRegionOpt(lookUpManager.readRegion());
        this.setWoredaList(lookUpManager.readZoneOrCityInARegion(null));

             

        pnl_col_PendingApproved.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_PendingApproved_processAction(ae);
            }
        });
        pnl_col_Pending.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                pnl_col_Pending_processAction(ae);
            }
        });
    //  zoneList =lookUpManager.readZoneOrCityInARegion(employeeAddressList.getRegion());
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
    private DefaultSelectedData selectedObjectOfPendingList = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectOfDisciplineType = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectPending = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectHistory = new DefaultSelectedData();
    private DefaultSelectedData selectedObjectPendingCanBeApproved = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectPendingCanBeApproved() {
        return selectedObjectPendingCanBeApproved;
    }

    public void setSelectedObjectPendingCanBeApproved(DefaultSelectedData selectedObjectPendingCanBeApproved) {
        this.selectedObjectPendingCanBeApproved = selectedObjectPendingCanBeApproved;
    }

    public DefaultSelectedData getSelectedObjectPending() {
        return selectedObjectPending;
    }

    public void setSelectedObjectPending(DefaultSelectedData selectedObjectPending) {
        this.selectedObjectPending = selectedObjectPending;
    }

    public DefaultSelectedData getSelectedObjectOfDisciplineType() {
        return selectedObjectOfDisciplineType;
    }

    public void setSelectedObjectOfDisciplineType(DefaultSelectedData selectedObjectOfDisciplineType) {
        this.selectedObjectOfDisciplineType = selectedObjectOfDisciplineType;
    }

    public DefaultSelectedData getSelectedObjectOfPendingList() {
        return selectedObjectOfPendingList;
    }

    public void setSelectedObjectOfPendingList(DefaultSelectedData selectedObjectOfPendingList) {
        this.selectedObjectOfPendingList = selectedObjectOfPendingList;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
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
    private HtmlInputText txtRequesterId = new HtmlInputText();

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
    private HtmlInputText txtEmployeeDepartment = new HtmlInputText();

    public HtmlInputText getTxtEmployeeDepartment() {
        return txtEmployeeDepartment;
    }

    public void setTxtEmployeeDepartment(HtmlInputText hit) {
        this.txtEmployeeDepartment = hit;
    }
    private HtmlInputText txtEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtEmployeeId() {
        return txtEmployeeId;
    }

    public void setTxtEmployeeId(HtmlInputText hit) {
        this.txtEmployeeId = hit;
    }
    private HtmlInputText txtEmployeePosition = new HtmlInputText();

    public HtmlInputText getTxtEmployeePosition() {
        return txtEmployeePosition;
    }

    public void setTxtEmployeePosition(HtmlInputText hit) {
        this.txtEmployeePosition = hit;
    }
    private HtmlInputText txtDisciplineDate = new HtmlInputText();

    public HtmlInputText getTxtDisciplineDate() {
        return txtDisciplineDate;
    }

    public void setTxtDisciplineDate(HtmlInputText hit) {
        this.txtDisciplineDate = hit;
    }
    private HtmlInputText txtReportedDate = new HtmlInputText();

    public HtmlInputText getTxtReportedDate() {
        return txtReportedDate;
    }

    public void setTxtReportedDate(HtmlInputText hit) {
        this.txtReportedDate = hit;
    }
    private HtmlSelectOneMenu drlDisciplineType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDisciplineType() {
        return drlDisciplineType;
    }

    public void setDrlDisciplineType(HtmlSelectOneMenu hsom) {
        this.drlDisciplineType = hsom;
    }
    private HtmlInputTextarea txtaDisciplineDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDisciplineDescription() {
        return txtaDisciplineDescription;
    }

    public void setTxtaDisciplineDescription(HtmlInputTextarea hit) {
        this.txtaDisciplineDescription = hit;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private HtmlInputText txtDisciplinePreviousOccurance = new HtmlInputText();

    public HtmlInputText getTxtDisciplinePreviousOccurance() {
        return txtDisciplinePreviousOccurance;
    }

    public void setTxtDisciplinePreviousOccurance(HtmlInputText hit) {
        this.txtDisciplinePreviousOccurance = hit;
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
    private HtmlSelectOneRadio radioGroupApplierType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupApplierType() {
        return radioGroupApplierType;
    }

    public void setRadioGroupApplierType(HtmlSelectOneRadio hsor) {
        this.radioGroupApplierType = hsor;
    }
    private HtmlCommandButton btnSearchOffender = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchOffender() {
        return btnSearchOffender;
    }

    public void setBtnSearchOffender(HtmlCommandButton hcb) {
        this.btnSearchOffender = hcb;
    }
    private HtmlInputTextarea txtaRequestedMeasureToBeTaken = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaRequestedMeasureToBeTaken() {
        return txtaRequestedMeasureToBeTaken;
    }

    public void setTxtaRequestedMeasureToBeTaken(HtmlInputTextarea hit) {
        this.txtaRequestedMeasureToBeTaken = hit;
    }
   // private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessageApproveHere = new HtmlOutputLabel();
    private HtmlOutputLabel lblSuccessOrErrorMessageOther = new HtmlOutputLabel();
    private HtmlOutputLabel pnlgridpnMessageOther = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private PanelLayout pnlMessageBodyApproveHere = new PanelLayout();
    private PanelLayout pnlMessageBodyApproveHereRequest = new PanelLayout();
    private PanelLayout pnlMessageBodyOther = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlPanelGroup panelGroupMessageApproveHerePopUP = new HtmlPanelGroup();

    public PanelLayout getPnlMessageBodyApproveHereRequest() {
        return pnlMessageBodyApproveHereRequest;
    }

    public void setPnlMessageBodyApproveHereRequest(PanelLayout pnlMessageBodyApproveHereRequest) {
        this.pnlMessageBodyApproveHereRequest = pnlMessageBodyApproveHereRequest;
    }

    public HtmlPanelGroup getPanelGroupMessageApproveHerePopUP() {
        return panelGroupMessageApproveHerePopUP;
    }

    public void setPanelGroupMessageApproveHerePopUP(HtmlPanelGroup panelGroupMessageApproveHerePopUP) {
        this.panelGroupMessageApproveHerePopUP = panelGroupMessageApproveHerePopUP;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessageApproveHere() {
        return lblSuccessOrErrorMessageApproveHere;
    }

    public void setLblSuccessOrErrorMessageApproveHere(HtmlOutputLabel lblSuccessOrErrorMessageApproveHere) {
        this.lblSuccessOrErrorMessageApproveHere = lblSuccessOrErrorMessageApproveHere;
    }
    //  private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private HtmlPanelGroup panelGroupMessageApproveHere = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessageApproveHere() {
        return panelGroupMessageApproveHere;
    }

    public void setPanelGroupMessageApproveHere(HtmlPanelGroup panelGroupMessageApproveHere) {
        this.panelGroupMessageApproveHere = panelGroupMessageApproveHere;
    }

    public PanelLayout getPnlMessageBodyApproveHere() {
        return pnlMessageBodyApproveHere;
    }

    public void setPnlMessageBodyApproveHere(PanelLayout pnlMessageBodyApproveHere) {
        this.pnlMessageBodyApproveHere = pnlMessageBodyApproveHere;
    }
    private HtmlPanelGroup panelGroupMessageOther = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();
    private PanelPopup pnlPopupSuccessOrFailureForApproveHere = new PanelPopup();
    private PanelPopup pnlPopupSuccessOrFailureOther = new PanelPopup();
    private PanelPopup pnlPopupApproveHere = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailureForApproveHere() {
        return pnlPopupSuccessOrFailureForApproveHere;
    }

    public void setPnlPopupSuccessOrFailureForApproveHere(PanelPopup pnlPopupSuccessOrFailureForApproveHere) {
        this.pnlPopupSuccessOrFailureForApproveHere = pnlPopupSuccessOrFailureForApproveHere;
    }

    public PanelPopup getPnlPopupApproveHere() {
        return pnlPopupApproveHere;
    }

    public void setPnlPopupApproveHere(PanelPopup pnlPopupApproveHere) {
        this.pnlPopupApproveHere = pnlPopupApproveHere;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        lnkRegisterEyeWitness.setRendered(false);
        pnlPopupSuccessOrFailure.setRendered(false);
        pnlPopupSuccessOrFailureForApproveHere.setRendered(false);
        return null;
    }

    public String btnClosePopupApproveHere_action() {

        pnlPopupApproveHere.setRendered(false);
        return null;
    }

    public String btnClosePopupSuccessOrFailureOther_action() {
        pnlPopupSuccessOrFailureOther.setRendered(false);

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
        return dateOfOffence;
    }

    public void setDateOfOffence(String dateOfOffence) {
        this.dateOfOffence = dateOfOffence;
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

    public String getIsDocumentAttached() {
        return documentReferenceNumber;
    }

    public void setIsDocumentAttached(String isDocumentAttached) {
        this.documentReferenceNumber = isDocumentAttached;
    }

    public String getCanBeApproved() {
        return canBeApproved;
    }

    public void setCanBeApproved(String canBeApproved) {
        this.canBeApproved = canBeApproved;
    }

    public String getOffenceType() {
        return offenceType;
    }

    public void setOffenceType(String offenceType) {
        this.offenceType = offenceType;
    }

    public String getOffenderId() {
        return offenderId;
    }

    public void setOffenderId(String offenderId) {
        this.offenderId = offenderId;
    }

    public int getRepititionOfOffence() {
        return repititionOfOffence;
    }

    public void setRepititionOfOffence(int repititionOfOffence) {
        this.repititionOfOffence = repititionOfOffence;
    }

    public String getReportedDate() {
        return reportedDate;
    }

    public void setReportedDate(String reportedDate) {
        this.reportedDate = reportedDate;
    }

    public String getRequestedMeasureToBeTaken() {
        return requestedMeasureToBeTaken;
    }

    public void setRequestedMeasureToBeTaken(String requestedMeasureToBeTaken) {
        this.requestedMeasureToBeTaken = requestedMeasureToBeTaken;
    }

    public String getRequesterType() {
        return requesterType;
    }

    public void setRequesterType(String requesterType) {
        this.requesterType = requesterType;
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

    public String getDisciplinedEmployeeId() {
        return disciplinedEmployeeId;
    }

    public void setDisciplinedEmployeeId(String disciplinedEmployeeId) {
        this.disciplinedEmployeeId = disciplinedEmployeeId;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

//    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
//        return lblSuccessOrErrorMessage;
//    }
//
//    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
//        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
//    }

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

    public ArrayList<Option> getPendingListsThatCanBeApproved() {
        return pendingListsThatCanBeApproved;
    }

    public void setPendingListsThatCanBeApproved(ArrayList<Option> pendingListsThatCanBeApproved) {
        this.pendingListsThatCanBeApproved = pendingListsThatCanBeApproved;
    }

    public ArrayList<Option> getPendingRequestLists() {
        return pendingRequestLists;
    }

    public ArrayList<Option> getHistoryRequestLists() {
        return historyRequestLists;
    }

    public void setHistoryRequestLists(ArrayList<Option> historyRequestLists) {
        this.historyRequestLists = historyRequestLists;
    }

    public DefaultSelectedData getSelectedObjectHistory() {
        return selectedObjectHistory;
    }

    public void setSelectedObjectHistory(DefaultSelectedData selectedObjectHistory) {
        this.selectedObjectHistory = selectedObjectHistory;
    }

    public void setPendingRequestLists(ArrayList<Option> pendingRequestLists) {
        this.pendingRequestLists = pendingRequestLists;
    }

    public DisciplineRequestManager getDisciplineRequestManager() {
        return disciplineRequestManager;
    }

    public void setDisciplineRequestManager(DisciplineRequestManager disciplineRequestManager) {
        this.disciplineRequestManager = disciplineRequestManager;
    }

    public String getANOTHEREMPLOYEE() {
        return ANOTHEREMPLOYEE;
    }

    public void setANOTHEREMPLOYEE(String ANOTHEREMPLOYEE) {
        this.ANOTHEREMPLOYEE = ANOTHEREMPLOYEE;
    }

    public String getNOTWORKER() {
        return NOTWORKER;
    }

    public void setNOTWORKER(String NOTWORKER) {
        this.NOTWORKER = NOTWORKER;
    }

    public String getWORKER() {
        return WORKER;
    }

    public void setWORKER(String WORKER) {
        this.WORKER = WORKER;
    }

    public String getIMMEDIATEBOSS() {
        return IMMEDIATEBOSS;
    }

    public void setIMMEDIATEBOSS(String IMMEDIATEBOSS) {
        this.IMMEDIATEBOSS = IMMEDIATEBOSS;
    }

    public String getNOTEMPLOYEE() {
        return NOTEMPLOYEE;
    }

    public void setNOTEMPLOYEE(String NOTEMPLOYEE) {
        this.NOTEMPLOYEE = NOTEMPLOYEE;
    }

    public ArrayList<Option> getDisciplineTypesList() {
        return disciplineTypesList;
    }

    public void setDisciplineTypesList(ArrayList<Option> disciplineTypesList) {
        this.disciplineTypesList = disciplineTypesList;
    }

    public String getSaveOrEditOrUpdateLabel() {
        return saveOrEditOrUpdateLabel;
    }

    public void setSaveOrEditOrUpdateLabel(String saveOrEditOrUpdateLabel) {
        this.saveOrEditOrUpdateLabel = saveOrEditOrUpdateLabel;
    }
    private HtmlInputText txtDocReferenceNumber = new HtmlInputText();

    public HtmlInputText getTxtDocReferenceNumber() {
        return txtDocReferenceNumber;
    }

    public void setTxtDocReferenceNumber(HtmlInputText hit) {
        this.txtDocReferenceNumber = hit;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();

    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pp) {
        this.pnlPopupViewPrevieousDecisions = pp;
    }
    private HtmlCommandButton btnSaveOrUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveOrUpdate() {
        return btnSaveOrUpdate;
    }

    public void setBtnSaveOrUpdate(HtmlCommandButton hcb) {
        this.btnSaveOrUpdate = hcb;
    }
    private PanelPopup pnlEyeWitnessesRegistration = new PanelPopup();
    private PanelPopup pnlOtherEyeWitnessesRegistration = new PanelPopup();

    public PanelPopup getPnlOtherEyeWitnessesRegistration() {
        return pnlOtherEyeWitnessesRegistration;
    }

    public void setPnlOtherEyeWitnessesRegistration(PanelPopup pnlOtherEyeWitnessesRegistration) {
        this.pnlOtherEyeWitnessesRegistration = pnlOtherEyeWitnessesRegistration;
    }

    public PanelPopup getPnlEyeWitnessesRegistration() {
        return pnlEyeWitnessesRegistration;
    }

    public void setPnlEyeWitnessesRegistration(PanelPopup pp) {
        this.pnlEyeWitnessesRegistration = pp;
    }
    private HtmlInputText txtWitnessId = new HtmlInputText();

    public HtmlInputText getTxtWitnessId() {
        return txtWitnessId;
    }

    public void setTxtWitnessId(HtmlInputText hit) {
        this.txtWitnessId = hit;
    }
    private HtmlInputText txtWitnessDepartment = new HtmlInputText();

    public HtmlInputText getTxtWitnessDepartment() {
        return txtWitnessDepartment;
    }

    public void setTxtWitnessDepartment(HtmlInputText hit) {
        this.txtWitnessDepartment = hit;
    }
    private HtmlInputText txtWitnessPosition = new HtmlInputText();

    public HtmlInputText getTxtWitnessPosition() {
        return txtWitnessPosition;
    }

    public void setTxtWitnessPosition(HtmlInputText hit) {
        this.txtWitnessPosition = hit;
    }
    private SelectInputText txtWitnessFullName_New1 = new SelectInputText();

    public SelectInputText getTxtWitnessFullName() {
        return txtWitnessFullName_New1;
    }

    public void setTxtWitnessFullName(SelectInputText sit) {
        this.txtWitnessFullName_New1 = sit;
    }
    private HtmlCommandLink lnkRecordEyeWitnesses = new HtmlCommandLink();

    public HtmlCommandLink getLnkRecordEyeWitnesses() {
        return lnkRecordEyeWitnesses;
    }

    public void setLnkRecordEyeWitnesses(HtmlCommandLink hcl) {
        this.lnkRecordEyeWitnesses = hcl;
    }
    private HtmlCommandLink lnkRegisterEyeWitness = new HtmlCommandLink();
    private HtmlCommandLink lnkRegisterEyeWitnessOther = new HtmlCommandLink();

    public HtmlCommandLink getLnkRegisterEyeWitness() {
        return lnkRegisterEyeWitness;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessageOther() {
        return lblSuccessOrErrorMessageOther;
    }

    public void setLblSuccessOrErrorMessageOther(HtmlOutputLabel lblSuccessOrErrorMessageOther) {
        this.lblSuccessOrErrorMessageOther = lblSuccessOrErrorMessageOther;
    }

    public HtmlCommandLink getLnkRegisterEyeWitnessOther() {
        return lnkRegisterEyeWitnessOther;
    }

    public void setLnkRegisterEyeWitnessOther(HtmlCommandLink lnkRegisterEyeWitnessOther) {
        this.lnkRegisterEyeWitnessOther = lnkRegisterEyeWitnessOther;
    }

    public HtmlPanelGroup getPanelGroupMessageOther() {
        return panelGroupMessageOther;
    }

    public void setPanelGroupMessageOther(HtmlPanelGroup panelGroupMessageOther) {
        this.panelGroupMessageOther = panelGroupMessageOther;
    }

    public PanelLayout getPnlMessageBodyOther() {
        return pnlMessageBodyOther;
    }

    public void setPnlMessageBodyOther(PanelLayout pnlMessageBodyOther) {
        this.pnlMessageBodyOther = pnlMessageBodyOther;
    }

    public PanelPopup getPnlPopupSuccessOrFailureOther() {
        return pnlPopupSuccessOrFailureOther;
    }

    public void setPnlPopupSuccessOrFailureOther(PanelPopup pnlPopupSuccessOrFailureOther) {
        this.pnlPopupSuccessOrFailureOther = pnlPopupSuccessOrFailureOther;
    }

    public HtmlOutputLabel getPnlgridpnMessageOther() {
        return pnlgridpnMessageOther;
    }

    public void setPnlgridpnMessageOther(HtmlOutputLabel pnlgridpnMessageOther) {
        this.pnlgridpnMessageOther = pnlgridpnMessageOther;
    }

    public void setLnkRegisterEyeWitness(HtmlCommandLink lnkRegisterEyeWitness) {
        this.lnkRegisterEyeWitness = lnkRegisterEyeWitness;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems() {
        return selectOneRadio1DefaultItems;
    }

    public void setSelectOneRadio1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems = dsi;
    }
    private HtmlSelectOneRadio groupEyeWitnessType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getGroupEyeWitnessType() {
        return groupEyeWitnessType;
    }

    public void setGroupEyeWitnessType(HtmlSelectOneRadio hsor) {
        this.groupEyeWitnessType = hsor;
    }
    private PanelLayout pnl_EyeWitnessType = new PanelLayout();

    public PanelLayout getPnl_EyeWitnessType() {
        return pnl_EyeWitnessType;
    }

    public void setPnl_EyeWitnessType(PanelLayout pl) {
        this.pnl_EyeWitnessType = pl;
    }
    private PanelLayout panelLayout_Name = new PanelLayout();

    public PanelLayout getPanelLayout_Name() {
        return panelLayout_Name;
    }

    public void setPanelLayout_Name(PanelLayout pl) {
        this.panelLayout_Name = pl;
    }
    private PanelLayout panelLayout_Adress = new PanelLayout();

    public PanelLayout getPanelLayout_Adress() {
        return panelLayout_Adress;
    }

    public void setPanelLayout_Adress(PanelLayout pl) {
        this.panelLayout_Adress = pl;
    }
    private PanelLayout panelLayout_DataTable = new PanelLayout();

    public PanelLayout getPanelLayout_DataTable() {
        return panelLayout_DataTable;
    }

    public void setPanelLayout_DataTable(PanelLayout pl) {
        this.panelLayout_DataTable = pl;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlInputText txt_FirstName = new HtmlInputText();

    public HtmlInputText getTxt_FirstName() {
        return txt_FirstName;
    }

    public void setTxt_FirstName(HtmlInputText hit) {
        this.txt_FirstName = hit;
    }
    private HtmlInputText txt_MiddleName = new HtmlInputText();

    public HtmlInputText getTxt_MiddleName() {
        return txt_MiddleName;
    }

    public void setTxt_MiddleName(HtmlInputText hit) {
        this.txt_MiddleName = hit;
    }
    private HtmlInputText txt_LastName = new HtmlInputText();

    public HtmlInputText getTxt_LastName() {
        return txt_LastName;
    }

    public void setTxt_LastName(HtmlInputText hit) {
        this.txt_LastName = hit;
    }
    private HtmlInputText txt_Age = new HtmlInputText();

    public HtmlInputText getTxt_Age() {
        return txt_Age;
    }

    public void setTxt_Age(HtmlInputText hit) {
        this.txt_Age = hit;
    }
    private HtmlInputText txt_HouseNumber = new HtmlInputText();

    public HtmlInputText getTxt_HouseNumber() {
        return txt_HouseNumber;
    }

    public void setTxt_HouseNumber(HtmlInputText hit) {
        this.txt_HouseNumber = hit;
    }
    private HtmlInputText txt_Moblie = new HtmlInputText();

    public HtmlInputText getTxt_Moblie() {
        return txt_Moblie;
    }

    public void setTxt_Moblie(HtmlInputText hit) {
        this.txt_Moblie = hit;
    }
    private HtmlInputText txt_Email = new HtmlInputText();

    public HtmlInputText getTxt_Email() {
        return txt_Email;
    }

    public void setTxt_Email(HtmlInputText hit) {
        this.txt_Email = hit;
    }
    private HtmlInputText txt_OfficeTel = new HtmlInputText();

    public HtmlInputText getTxt_OfficeTel() {
        return txt_OfficeTel;
    }

    public void setTxt_OfficeTel(HtmlInputText hit) {
        this.txt_OfficeTel = hit;
    }
    private HtmlInputText txt_HomeTel = new HtmlInputText();

    public HtmlInputText getTxt_HomeTel() {
        return txt_HomeTel;
    }

    public void setTxt_HomeTel(HtmlInputText hit) {
        this.txt_HomeTel = hit;
    }
    private DefaultTableDataProvider defaultTableDataProvider = new DefaultTableDataProvider();

    public DefaultTableDataProvider getDefaultTableDataProvider() {
        return defaultTableDataProvider;
    }

    public void setDefaultTableDataProvider(DefaultTableDataProvider dtdp) {
        this.defaultTableDataProvider = dtdp;
    }
    private HtmlInputText txt_PoBox = new HtmlInputText();

    public HtmlInputText getTxt_PoBox() {
        return txt_PoBox;
    }

    public void setTxt_PoBox(HtmlInputText hit) {
        this.txt_PoBox = hit;
    }
    private HtmlSelectOneMenu drl_Region = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Region() {
        return drl_Region;
    }

    public void setDrl_Region(HtmlSelectOneMenu hsom) {
        this.drl_Region = hsom;
    }
    private HtmlSelectOneMenu drl_Woreda = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Woreda() {
        return drl_Woreda;
    }

    public void setDrl_Woreda(HtmlSelectOneMenu hsom) {
        this.drl_Woreda = hsom;
    }
    private HtmlSelectOneMenu drl_Zone = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Zone() {
        return drl_Zone;
    }

    public void setDrl_Zone(HtmlSelectOneMenu hsom) {
        this.drl_Zone = hsom;
    }
    private HtmlSelectOneMenu drl_Kebele = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Kebele() {
        return drl_Kebele;
    }

    public void setDrl_Kebele(HtmlSelectOneMenu hsom) {
        this.drl_Kebele = hsom;
    }
    private HtmlSelectOneMenu drl_sex = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_sex() {
        return drl_sex;
    }

    public void setDrl_sex(HtmlSelectOneMenu hsom) {
        this.drl_sex = hsom;
    }
    private HtmlCommandLink lnkOtherWitness = new HtmlCommandLink();

    public HtmlCommandLink getLnkOtherWitness() {
        return lnkOtherWitness;
    }

    public void setLnkOtherWitness(HtmlCommandLink hcl) {
        this.lnkOtherWitness = hcl;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailureOther = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailureOther() {
        return btnClosePopupSuccessOrFailureOther;
    }

    public void setBtnClosePopupSuccessOrFailureOther(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailureOther = hcl;
    }
    private javax.faces.component.html.HtmlCommandLink remove = new javax.faces.component.html.HtmlCommandLink();

    public javax.faces.component.html.HtmlCommandLink getRemove() {
        return remove;
    }

    public void setRemove(javax.faces.component.html.HtmlCommandLink hcl) {
        this.remove = hcl;
    }
    private javax.faces.component.html.HtmlInputText txt_updateFullName = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_updateFullName() {
        return txt_updateFullName;
    }

    public void setTxt_updateFullName(javax.faces.component.html.HtmlInputText hit) {
        this.txt_updateFullName = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_sex = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_sex() {
        return txt_update_sex;
    }

    public void setTxt_update_sex(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_sex = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_age = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_age() {
        return txt_update_age;
    }

    public void setTxt_update_age(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_age = hit;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_update_region = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_update_region() {
        return drl_update_region;
    }

    public void setDrl_update_region(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_update_region = hsom;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_update_woreda = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_update_woreda() {
        return drl_update_woreda;
    }

    public void setDrl_update_woreda(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_update_woreda = hsom;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_update_zone = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_update_zone() {
        return drl_update_zone;
    }

    public void setDrl_update_zone(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_update_zone = hsom;
    }
    private javax.faces.component.html.HtmlSelectOneMenu drl_update_kebele = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDrl_update_kebele() {
        return drl_update_kebele;
    }

    public void setDrl_update_kebele(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.drl_update_kebele = hsom;
    }
    private javax.faces.component.html.HtmlInputText txt_update_houseNO = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_houseNO() {
        return txt_update_houseNO;
    }

    public void setTxt_update_houseNO(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_houseNO = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_poBox = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_poBox() {
        return txt_update_poBox;
    }

    public void setTxt_update_poBox(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_poBox = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_updateMobile = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_updateMobile() {
        return txt_updateMobile;
    }

    public void setTxt_updateMobile(javax.faces.component.html.HtmlInputText hit) {
        this.txt_updateMobile = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_Email = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_Email() {
        return txt_update_Email;
    }

    public void setTxt_update_Email(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_Email = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_teleOffice = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_teleOffice() {
        return txt_update_teleOffice;
    }

    public void setTxt_update_teleOffice(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_teleOffice = hit;
    }
    private javax.faces.component.html.HtmlInputText txt_update_Tele_HOme = new javax.faces.component.html.HtmlInputText();

    public javax.faces.component.html.HtmlInputText getTxt_update_Tele_HOme() {
        return txt_update_Tele_HOme;
    }

    public void setTxt_update_Tele_HOme(javax.faces.component.html.HtmlInputText hit) {
        this.txt_update_Tele_HOme = hit;
    }
    private javax.faces.component.html.HtmlCommandButton btn_ReoveOther = new javax.faces.component.html.HtmlCommandButton();

    public javax.faces.component.html.HtmlCommandButton getBtn_ReoveOther() {
        return btn_ReoveOther;
    }

    public void setBtn_ReoveOther(javax.faces.component.html.HtmlCommandButton hcb) {
        this.btn_ReoveOther = hcb;
    }
    private HtmlCommandButton btn_ADDTable = new HtmlCommandButton();

    public HtmlCommandButton getBtn_ADDTable() {
        return btn_ADDTable;
    }

    public void setBtn_ADDTable(HtmlCommandButton hcb) {
        this.btn_ADDTable = hcb;
    }
    private HtmlMessage messageFirstName = new HtmlMessage();

    public HtmlMessage getMessageFirstName() {
        return messageFirstName;
    }

    public void setMessageFirstName(HtmlMessage hm) {
        this.messageFirstName = hm;
    }
    private HtmlMessage messageMiddleName = new HtmlMessage();

    public HtmlMessage getMessageMiddleName() {
        return messageMiddleName;
    }

    public void setMessageMiddleName(HtmlMessage hm) {
        this.messageMiddleName = hm;
    }
    private HtmlOutputLabel lbl_LastName = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_LastName() {
        return lbl_LastName;
    }

    public void setLbl_LastName(HtmlOutputLabel hol) {
        this.lbl_LastName = hol;
    }
    private HtmlOutputLabel lbl_MiddleName = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_MiddleName() {
        return lbl_MiddleName;
    }

    public void setLbl_MiddleName(HtmlOutputLabel hol) {
        this.lbl_MiddleName = hol;
    }
    private HtmlOutputLabel lblFirstName = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFirstName() {
        return lblFirstName;
    }

    public void setLblFirstName(HtmlOutputLabel hol) {
        this.lblFirstName = hol;
    }
    private HtmlOutputLabel lbl_FirstName = new HtmlOutputLabel();

    public HtmlOutputLabel getLbl_FirstName() {
        return lbl_FirstName;
    }

    public void setLbl_FirstName(HtmlOutputLabel hol) {
        this.lbl_FirstName = hol;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private HtmlSelectOneMenu drl_Reputaion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Reputaion() {
        return drl_Reputaion;
    }

    public void setDrl_Reputaion(HtmlSelectOneMenu hsom) {
        this.drl_Reputaion = hsom;
    }
    private SelectInputText txtWitnessFullName_New = new SelectInputText();

    public SelectInputText getTxtWitnessFullName_New() {
        return txtWitnessFullName_New;
    }

    public void setTxtWitnessFullName_New(SelectInputText txtWitnessFullName_New) {
        this.txtWitnessFullName_New = txtWitnessFullName_New;
    }

    public SelectInputText getTxtWitnessFullName_New1() {
        return txtWitnessFullName_New1;
    }

    public void setTxtWitnessFullName_New1(SelectInputText sit) {
        this.txtWitnessFullName_New1 = sit;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private HtmlSelectOneMenu drlDis_Type_ForManager = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDis_Type_ForManager() {
        return drlDis_Type_ForManager;
    }

    public void setDrlDis_Type_ForManager(HtmlSelectOneMenu hsom) {
        this.drlDis_Type_ForManager = hsom;
    }
    private HtmlCommandLink cmd_ApproveNow = new HtmlCommandLink();

    public HtmlCommandLink getCmd_ApproveNow() {
        return cmd_ApproveNow;
    }

    public void setCmd_ApproveNow(HtmlCommandLink hcl) {
        this.cmd_ApproveNow = hcl;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private HtmlInputTextarea txtArea_ExpectedPenality = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtArea_ExpectedPenality() {
        return txtArea_ExpectedPenality;
    }

    public void setTxtArea_ExpectedPenality(HtmlInputTextarea hit) {
        this.txtArea_ExpectedPenality = hit;
    }
    private HtmlInputText txt_DeductionAmount = new HtmlInputText();

    public HtmlInputText getTxt_DeductionAmount() {
        return txt_DeductionAmount;
    }

    public void setTxt_DeductionAmount(HtmlInputText hit) {
        this.txt_DeductionAmount = hit;
    }
    private HtmlInputText txt_DeductionDuration = new HtmlInputText();

    public HtmlInputText getTxt_DeductionDuration() {
        return txt_DeductionDuration;
    }

    public void setTxt_DeductionDuration(HtmlInputText hit) {
        this.txt_DeductionDuration = hit;
    }
    private HtmlInputTextarea txtArea_Commeents = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtArea_Commeents() {
        return txtArea_Commeents;
    }

    public void setTxtArea_Commeents(HtmlInputTextarea hit) {
        this.txtArea_Commeents = hit;
    }
    private HtmlSelectOneMenu drl_Decision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_Decision() {
        return drl_Decision;
    }

    public void setDrl_Decision(HtmlSelectOneMenu hsom) {
        this.drl_Decision = hsom;
    }
    private PanelCollapsible pnl_col_History = new PanelCollapsible();

    public PanelCollapsible getPnl_col_History() {
        return pnl_col_History;
    }

    public void setPnl_col_History(PanelCollapsible pc) {
        this.pnl_col_History = pc;
    }
    private PanelCollapsible pnl_col_PendingApproved = new PanelCollapsible();

    public PanelCollapsible getPnl_col_PendingApproved() {
        return pnl_col_PendingApproved;
    }

    public void setPnl_col_PendingApproved(PanelCollapsible pc) {
        this.pnl_col_PendingApproved = pc;
    }
    private PanelCollapsible pnl_col_Pending = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Pending() {
        return pnl_col_Pending;
    }

    public void setPnl_col_Pending(PanelCollapsible pc) {
        this.pnl_col_Pending = pc;
    }
    private PanelCollapsible pnl_col_Common_Tasks = new PanelCollapsible();

    public PanelCollapsible getPnl_col_Common_Tasks() {
        return pnl_col_Common_Tasks;
    }

    public void setPnl_col_Common_Tasks(PanelCollapsible pc) {
        this.pnl_col_Common_Tasks = pc;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessageNew = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessageNew() {
        return lblSuccessOrErrorMessageNew;
    }

    public void setLblSuccessOrErrorMessageNew(HtmlOutputLabel hol) {
        this.lblSuccessOrErrorMessageNew = hol;
    }

//</editor-fold>
    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DisciplineRequestPage() {
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

        if (disciplineTypesList.isEmpty() || (lookUpManagercont.getEmpitiedTableList() != null && lookUpManagercont.getEmpitiedTableList().contains("HR_LU_DISCIPLINE_TYPE"))) {
            disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
            lookUpManagercont.getEmpitiedTableList().remove("HR_LU_DISCIPLINE_TYPE");
        }
        if (pendingRequestLists.isEmpty()) {
            pendingRequestLists = disciplineRequestManager.getPendingRequests();
            pendingListsThatCanBeApproved = disciplineRequestManager.getPendingRequestsCanBeApprovrd();

        }

        else {
        }
       
     populateApproverTextComponents(loggedInEmployeeId);

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

    public DisciplineApproveManager getDisciplineApproveManager() {
        return disciplineApproveManager;
    }

    public void setDisciplineApproveManager(DisciplineApproveManager disciplineApproveManager) {
        this.disciplineApproveManager = disciplineApproveManager;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public ArrayList<EyeWitnessModel> getEyeWitnessesList() {
        return eyeWitnessesList;
    }

    public void setEyeWitnessesList(ArrayList<EyeWitnessModel> eyeWitnessesList) {
        this.eyeWitnessesList = eyeWitnessesList;
    }

    public EyeWitnessManager getEyeWitnessManager() {
        return eyeWitnessManager;
    }

    public void setEyeWitnessManager(EyeWitnessManager eyeWitnessManager) {
        this.eyeWitnessManager = eyeWitnessManager;
    }

    public EyeWitnessModel getEyeWitnessModel() {
        return eyeWitnessModel;
    }

    public void setEyeWitnessModel(EyeWitnessModel eyeWitnessModel) {
        this.eyeWitnessModel = eyeWitnessModel;
    }

    public int getSelectedRowEyeWitness() {
        return selectedRowEyeWitness;
    }

    public void setSelectedRowEyeWitness(int selectedRowEyeWitness) {
        this.selectedRowEyeWitness = selectedRowEyeWitness;
    }

    public String getEmployeeStatus() {
        return employeeStatus;
    }

    public void setEmployeeStatus(String employeeStatus) {
        this.employeeStatus = employeeStatus;
    }

    public int getRankID() {
        return rankID;
    }

    public void setRankID(int rankID) {
        this.rankID = rankID;
    }

    public String getWitnessId() {
        return witnessId;
    }

    public void setWitnessId(String witnessId) {
        this.witnessId = witnessId;
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
    String loggedInEmployeeDept;
    String userName;
    String saveOrEditOrUpdateLabel = "Save";
    String disciplinedEmployeeId;
    DisciplineApproveEntity disciplineApproveEntity = new DisciplineApproveEntity();
    PowerDeligationRequestManager delegationManager=new PowerDeligationRequestManager();
    LookUpManager lookUpManager = new LookUpManager();
    LookUpManger lookUpManagercont = new LookUpManger();
    EmployeeManage employeeManager = new EmployeeManage();
    EyeWitnessModel eyeWitnessModel = new EyeWitnessModel();
    EyeWitnessManager eyeWitnessManager = new EyeWitnessManager();
    DisciplineRequestManager disciplineRequestManager = new DisciplineRequestManager();
    DisciplineApproveManager disciplineApproveManager = new DisciplineApproveManager();
    DisciplinePenaltyRegistrationManager disciplinePenaltyRegistrationManager = new DisciplinePenaltyRegistrationManager();
    DisciplineRequestManager.DisciplineRequestModel disciplineRequestModel = new DisciplineRequestManager.DisciplineRequestModel();
    DisciplineRegistrationManager disciplineRegistrationManager = new DisciplineRegistrationManager();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    ArrayList<EyeWitnessModel> eyeWitnessesList = new ArrayList<EyeWitnessModel>();
    ArrayList<OtherMemberEyeWitnessModel> otherEyeWitnessesList = new ArrayList<OtherMemberEyeWitnessModel>();
    // ArrayList<Option> disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
    ArrayList<Option> disciplineTypesList = new ArrayList<Option>();
    ArrayList<Option> disciplineTypesListForManager = new ArrayList<Option>();
    //ArrayList<Option> pendingRequestLists = disciplineRequestManager.getPendingRequests();//new ArrayList<Option>();
    ArrayList<Option> pendingRequestLists = new ArrayList<Option>();//new ArrayList<Option>();
    ArrayList<Option> pendingListsThatCanBeApproved = new ArrayList<Option>();//new ArrayList<Option>();
    ArrayList<Option> historyRequestLists = new ArrayList<Option>();
    ArrayList<Option> repititionTypes = disciplinePenaltyRegistrationManager.getPossibleRepitions();// new ArrayList<Option>();
    ArrayList<Option> availableDecisionsToMake = new ArrayList<Option>();
    ArrayList<SelectItem> regionOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> woredaList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> zoneList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> kebeleList = new ArrayList<SelectItem>();
    //public ArrayList<SelectItem> kebeleList = null;
    ArrayList<Option> sex = eyeWitnessManager.getSex();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public int selectedRowEyeOtherWitness;

    //otherWitnessSex=this.getSex();
    //requester types
    public String IMMEDIATEBOSS = DisciplineRequestManager.REQUERSTER_TYPE_IMMEDIATEBOSS;
    public String ANOTHEREMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_ANOTHEREMPLOYEE;
    public String NOTEMPLOYEE = DisciplineRequestManager.REQUERSTER_TYPE_NOTEMPLOYEE;
    public String WORKER = DisciplineRequestManager.EYEWITNESS_TYPE_WORKER;
    public String NOTWORKER = DisciplineRequestManager.EYEWITNESS_TYPE_OTHER;
    ResourceBundle messageResource = null;
    int disciplineProblemId;// DISCIPLINE_PROBLEM_ID
    String forwareToCommeete = "No";
    String employeeStatus;
    String witnessType = "";
    String requesterType = IMMEDIATEBOSS;//REQUESTER_TYPE the default value of
    String requesterId = null; //REQUESTER_ID
    int requesterRank = 0;
    String requesterJobLevel=null;
    double salary;
    int duration;
    int penaliyedDays;
    String witnessId = null;
    String offenderId = null;//OFFENDER_ID always employee
    String dateOfOffence = null;//DATE_OF_OFFENCE//when does it happen
    String reportedDate = null;//REPORTED_DATE//reported to the hrms e
    String offenceType = null;// OFFENCE_TYPE,//if it is registerd in the table HR_DISCIPLINE_TYPE, ELSE "Other"
    String canBeApproved = "False";
    int rankID;
    int repititionOfOffence = -1;//REPITITION_OF_OFFENCE//how many times does it occured before the phase out time
    int disciplineTypeId;
    String descriptionOfOffence = null;//DESCRIPTION_OF_OFFENCE//details
    String requestedMeasureToBeTaken = null;//REQUESTED_MEASURE_TO_BE_TAKEN
    String status = null;//STATUS
    String documentReferenceNumber = null;//IS_DOCUMENT_ATTACHED
    String firstName = null;
    String middleName = null;
    String lastName = null;
    String fullName = null;
    String Witnesssex = null;
    String region = null;
    String woreda = null;
    String zone = null;
    String kebele = null;
    String houseNumber = null;
    String poBox = null;
    String eMail = null;
    int age = 0;
    int mobile = 0;
    int teleOffice = 0;
    int teleHome = 0;
    String reporterID;
    String reporterFullName;
    String reporterDepartment;
    String reporterposition;
    RequestHistoryModel requesterHistory = new RequestHistoryModel();

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
                requesterRank = Integer.parseInt(empInfoHashMap.get("employeeRank").toString());
                requesterJobLevel=empInfoHashMap.get("employeeJobLevel").toString();
                 return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private void populateApproverTextComponents(String approverId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = loggedInEmployeeId;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
            //  txtDeciderId.setDisabled(false);
            } else {
                try {

                    approverId = empInfoHashMap.get("employeeId").toString();

                    reporterDepartment = (empInfoHashMap.get("employeeDepartmentPath")).toString();
                    reporterFullName = (empInfoHashMap.get("employeeFullName")).toString();
                    reporterID = (empInfoHashMap.get("employeeId")).toString();
                    reporterposition = (empInfoHashMap.get("employeePosition")).toString();

                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
        }
    }


    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
    private void validateTelephone(FacesContext context, UIComponent component, Object value) {
        String patternTel = "[0-9]{4}[-]{1}[0-9]{6}";
        String patternTel2 = "[0-9]{3}[0-9]{3}[-]{1}[0-9]{6}";
        String patternTel3 = "[0-9]{10}";
        String patternTel4 = "[0-9]{12}";

        boolean matchStringText = Pattern.matches(patternTel, (CharSequence) (value.toString()));
        boolean matchStringText2 = Pattern.matches(patternTel2, (CharSequence) (value.toString()));
        boolean matchStringText3 = Pattern.matches(patternTel3, (CharSequence) (value.toString()));
        boolean matchStringText4 = Pattern.matches(patternTel4, (CharSequence) (value.toString()));


        if (matchStringText || matchStringText2 || matchStringText3 || matchStringText) {
        } else {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("telValidate"));
        }
    }
    //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

    private void validateMobile(FacesContext context, UIComponent component, Object value) {
        String patternTel = "[0-9]{4}[-]{1}[0-9]{6}";
        String patternTel2 = "[0-9]{3}[0-9]{3}[-]{1}[0-9]{6}";
        String patternTel3 = "[0-9]{10}";
        String patternTel4 = "[0-9]{12}";

        boolean matchStringText = Pattern.matches(patternTel, (CharSequence) (value.toString()));
        boolean matchStringText2 = Pattern.matches(patternTel2, (CharSequence) (value.toString()));
        boolean matchStringText3 = Pattern.matches(patternTel3, (CharSequence) (value.toString()));
        boolean matchStringText4 = Pattern.matches(patternTel4, (CharSequence) (value.toString()));


        if (matchStringText || matchStringText2 || matchStringText3 || matchStringText) {
//
        } else {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("telValidate"));
        }

    }

    private void validateEmail(FacesContext context, UIComponent component, Object value) {
        String patternEmail = "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[_A-Za-z0-9-]+)";
        boolean matchStringText = Pattern.matches(patternEmail, (CharSequence) (value.toString()));
        if (matchStringText == false) {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("salaryValidate"));
        }
    }

    private void validateName(FacesContext context, UIComponent component, Object value) {
        try {
            String patternName = "[a-zA-Z]*[//]?[a-zA-Z]*|^[?-???\\\\]*[//]?[?-???\\\\]*";
            boolean matchStringText = Pattern.matches(patternName, (CharSequence) (value.toString()));
            if (matchStringText == false) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("nameValidate"));
            }
        } catch (Exception ex) {
        }
    }

    private boolean populateEyeWitnessComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (!empInfoHashMap.get("employeeId").toString().equals("-1")) {
                witnessId = empInfoHashMap.get("employeeId").toString();
                txtWitnessDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtWitnessFullName_New.setValue(empInfoHashMap.get("employeeFullName"));
                //txtWitnessId.setValue(employeeID);
                txtWitnessId.setValue(witnessId);
                txtWitnessPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
            return false;
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEmployeeEyeWitnessTextComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeID);
                return false;
            } else {
                witnessId = empInfoHashMap.get("employeeId").toString();
                txtWitnessDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtWitnessFullName_New.setValue(empInfoHashMap.get("employeeFullName"));
                txtWitnessId.setValue(employeeID);
                txtWitnessPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateEmployeeTextComponents(String employeeId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                return false;
            } else {
                offenderId = empInfoHashMap.get("employeeId").toString();
                txtEmployeeDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtEmployeeFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtEmployeeId.setValue(offenderId);
                txtEmployeePosition.setValue(empInfoHashMap.get("employeePosition"));
                rankID = Integer.parseInt(empInfoHashMap.get("employeeRank").toString());

                if (rankID >= 14) {
                    employeeStatus = "Manager";
                    drlDis_Type_ForManager.setRendered(true);
                    disciplineTypesListForManager = disciplineRequestManager.getDisciplineTypesForManager();
                } else {
                    employeeStatus = "Normal";
                    drlDis_Type_ForManager.setRendered(false);

                }

                //  disciplineTypeSelection();
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateDisciplineTextComponents(DisciplineRequestModel disciplineRequestModel) {
        txtDisciplineDate.setValue(disciplineRequestModel.getDateOfOffence());
        txtReportedDate.setValue(disciplineRequestModel.getReportedDate());//reset date
        txtaDisciplineDescription.setValue(disciplineRequestModel.getDescriptionOfOffence());
        txtaRequestedMeasureToBeTaken.setValue(disciplineRequestModel.getRequestedMeasureToBeTaken());
        txtDisciplinePreviousOccurance.setValue(disciplineRequestModel.getRepititionOfOffence());
        txtDocReferenceNumber.setValue(disciplineRequestModel.getDocumentReferenceNumber());
        drl_Reputaion.setValue(disciplineRequestModel.getRepititionOfOffence());
        if (employeeStatus.equalsIgnoreCase("Normal")) {
            setSelectedDisciplineType(disciplineRequestModel.getOffenceType());
        } else if (employeeStatus.equalsIgnoreCase("Manager")) {
            setSelectedDisciplineTypeForManager(disciplineRequestModel.getOffenceType());
        }
        return true;
    }

    private void populateAllComponents(DisciplineRequestModel disciplineRequestModel) {

        populateRequesterTextComponents(disciplineRequestModel.getRequesterId());
        populateEmployeeTextComponents(disciplineRequestModel.getOffenderId());
        populateDisciplineTextComponents(disciplineRequestModel);
        populateDecisionHistory(disciplineRequestModel.getDisciplineProblemId());
    }

    private boolean populateEyeWitnessTable(int requestId) {
        eyeWitnessesList = eyeWitnessManager.getEyeWitnessesList(requestId);
        return true;
    }

    private void populateDecisionHistory(int disciplineRequestId) {

        decisionsMadeOnRequest = disciplineApproveManager.getRequestHistory(disciplineRequestId);


        if (decisionsMadeOnRequest.size() > 0) {
            lnkViewPrevieousDecisions.setRendered(true);

            if (decisionsMadeOnRequest.get(0).getGivenDecision().equalsIgnoreCase("Resubmit")) {
                btnSaveOrUpdate.setDisabled(false);
                saveOrEditOrUpdateLabel = "Update";
            } else {
                btnSaveOrUpdate.setDisabled(true);
                saveOrEditOrUpdateLabel = "Save";
            }

        } else {
            lnkViewPrevieousDecisions.setRendered(false);
            makePageReadyForUpdate();
        }
    }

    private void populateAllComponents(int requestId) {
        //  disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(requestId);
        populateRequesterTextComponents(disciplineRequestModel.getRequesterId());
        populateEmployeeTextComponents(disciplineRequestModel.getOffenderId());
        populateDisciplineTextComponents(disciplineRequestModel);
        populateEyeWitnessTable(requestId);


    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        requesterId = null;
    }

    private void clearEyeWitnessTextComponents() {
        txtWitnessId.setValue(null);
        txtWitnessDepartment.setValue(null);
        txtWitnessFullName_New.setValue(null);
        txtWitnessPosition.setValue(null);
        requesterId = null;
    // txtWitnessFullName_New1.setValue(null);
    }

    private void clearOtherEyeWitnessTextCompnets() {
        txt_Age.resetValue();
        txt_FirstName.resetValue();
        txt_MiddleName.resetValue();
        txt_LastName.resetValue();
        txt_HomeTel.resetValue();
        txt_HouseNumber.resetValue();
        txt_Moblie.resetValue();
        txt_OfficeTel.resetValue();
        txt_Email.resetValue();
        txt_PoBox.resetValue();
        lbl_FirstName.setRendered(false);
        lbl_MiddleName.setRendered(false);
        lbl_LastName.setRendered(false);
        drl_Kebele.resetValue();
        drl_Region.resetValue();
        drl_Zone.resetValue();
        drl_sex.resetValue();
        drl_Woreda.resetValue();

    }

    private void clearDisciplineTextComponents() {
        txtDisciplineDate.setValue(null);
        txtaDisciplineDescription.setValue(null);
        txtaRequestedMeasureToBeTaken.setValue(null);
        txtReportedDate.setValue(dateFormat.format(new Date()));//reset date
        txtDisciplinePreviousOccurance.setValue(null);
        drlDisciplineType.setValue("--SelectDisciplineType--");
        txtDocReferenceNumber.setValue(null);
    }

    private void clearEmployeeTextComponents() {
        txtEmployeeId.setValue(null);
        txtEmployeeDepartment.setValue(null);
        txtEmployeeFullName.setValue(null);
        txtEmployeePosition.setValue(null);
    }

    private void clearAllComponents() {
        clearDisciplineTextComponents();
        clearEyeWitnessTextComponents();
        clearRequesterTextComponents();
        clearEmployeeTextComponents();
        eyeWitnessModel = new EyeWitnessModel();
        eyeWitnessesList = new ArrayList<EyeWitnessModel>();
        selectedObjectPending.setSelectedObject(null);
        selectedObjectHistory.setSelectedObject(null);
        pendingRequestLists = disciplineRequestManager.getPendingRequests();
    }

    public String getRequesterJobLevel() {
        return requesterJobLevel;
    }

    public void setRequesterJobLevel(String requesterJobLevel) {
        this.requesterJobLevel = requesterJobLevel;
    }

    public ArrayList<Option> getAvailableDecisionsToMake() {
        return availableDecisionsToMake;
    }

    public void setAvailableDecisionsToMake(ArrayList<Option> availableDecisionsToMake) {
        this.availableDecisionsToMake = availableDecisionsToMake;
    }

    public ArrayList<Option> getDisciplineTypesListForManager() {
        return disciplineTypesListForManager;
    }

    public void setDisciplineTypesListForManager(ArrayList<Option> disciplineTypesListForManager) {
        this.disciplineTypesListForManager = disciplineTypesListForManager;
    }

    public String getReporterDepartment() {
        return reporterDepartment;
    }

    public void setReporterDepartment(String reporterDepartment) {
        this.reporterDepartment = reporterDepartment;
    }

    public String getReporterFullName() {
        return reporterFullName;
    }

    public void setReporterFullName(String reporterFullName) {
        this.reporterFullName = reporterFullName;
    }

    public String getReporterID() {
        return reporterID;
    }

    public void setReporterID(String reporterID) {
        this.reporterID = reporterID;
    }

    public String getReporterposition() {
        return reporterposition;
    }

    public void setReporterposition(String reporterposition) {
        this.reporterposition = reporterposition;
    }

    public String getLoggedInEmployeeDept() {
        return loggedInEmployeeDept;
    }

    public void setLoggedInEmployeeDept(String loggedInEmployeeDept) {
        this.loggedInEmployeeDept = loggedInEmployeeDept;
    }

    public String getWitnessType() {
        return witnessType;
    }

    public void setWitnessType(String witnessType) {
        this.witnessType = witnessType;
    }

    public ArrayList<Option> getRepititionTypes() {
        return repititionTypes;
    }

    public void setRepititionTypes(ArrayList<Option> repititionTypes) {
        this.repititionTypes = repititionTypes;
    }

    public ArrayList<Option> getSex() {
        return sex;
    }

    public void setSex(ArrayList<Option> sex) {
        this.sex = sex;
    }

    public ArrayList<SelectItem> getKebeleList() {
        return kebeleList;
    }

    public void setKebeleList(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
    }

    public ArrayList<SelectItem> getZoneList() {
        return zoneList;
    }

    public void setZoneList(ArrayList<SelectItem> zoneList) {
        this.zoneList = zoneList;
    }

    public ArrayList<SelectItem> getWoredaList() {
        return woredaList;
    }

    public void setWoredaList(ArrayList<SelectItem> woredaList) {
        this.woredaList = woredaList;
    }

    public ArrayList<SelectItem> getRegionOpt() {
        return regionOpt;
    }

    public void setRegionOpt(ArrayList<SelectItem> regionOpt) {
        this.regionOpt = regionOpt;
    }

    public ArrayList<OtherMemberEyeWitnessModel> getOtherEyeWitnessesList() {
        return otherEyeWitnessesList;
    }

    public void setOtherEyeWitnessesList(ArrayList<OtherMemberEyeWitnessModel> otherEyeWitnessesList) {
        this.otherEyeWitnessesList = otherEyeWitnessesList;
    }

    public String lnkViewPrevieousDecisions_action() {

        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
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

    private void makePageReadyForUpdate() {
        btnSaveOrUpdate.setDisabled(false);
        saveOrEditOrUpdateLabel = "Update";
        lnkViewPrevieousDecisions.setRendered(false);
        lnkRecordEyeWitnesses.setRendered(true);




    }

    private void makePageReadyForView() {
        saveOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(true);
        lnkViewPrevieousDecisions.setRendered(true);
        lnkRecordEyeWitnesses.setRendered(false);
    }

    public String getNewOrEditOrUpdateLabel() {
        // return MessageLocalizer.getLocalizedMessage(newOrEditOrUpdateLabel, "Localization.HRLocalization");
        return saveOrEditOrUpdateLabel;
    }

    private void makePageReadyForEdit() {
        //enableAllComponents();
        makePageReadyForUpdate();
    }

    private void makePageReadyForSave() {
        saveOrEditOrUpdateLabel = "Save";
        btnSaveOrUpdate.setDisabled(false);
        lnkRecordEyeWitnesses.setRendered(false);
        clearAllComponents();
    }

    public String btnReset_action() {
        clearAllComponents();
        makePageReadyForSave();
        return null;
    }
    

   

    public void showSuccessOrFailureMessageDere(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessageOther.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessageOther.setValue(messageToDisplay);
        lblSuccessOrErrorMessageOther.setVisible(true);
        pnlPopupSuccessOrFailureOther.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }


    public void showSuccessOrFailureMessageApprovedHere(boolean success, String messageToDisplay, int durationInSecond) {
      //  pnlPopupSuccessOrFailureForApproveHere.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
       lblSuccessOrErrorMessageApproveHere.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
       lblSuccessOrErrorMessageApproveHere.setValue(messageToDisplay);
       lblSuccessOrErrorMessageApproveHere.setVisible(true);
        pnlPopupSuccessOrFailureForApproveHere.setRendered(true);
          String val = "message";
        String fadeTime = Integer.toString(durationInSecond * 1000);//(success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void showSuccessOrFailureMessageOther(boolean success, String messageToDisplay, int durationInSecond) {
        lnkRegisterEyeWitnessOther.setRendered(true);
        lblSuccessOrErrorMessageOther.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessageOther.setValue(messageToDisplay);
        lblSuccessOrErrorMessageOther.setVisible(true);
        //pnlPopupSuccessOrFailureOther.setRendered(true);
        pnlPopupSuccessOrFailureOther.setRendered(true);
        String val = "message";
        String fadeTime = Integer.toString(durationInSecond * 1000);//(success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

      public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        int fadeTime = success ? 3000 : 8000;
      //  lnkRecordEyeWitnesses.setRendered(false);
      //  showSuccessOrFailureMessage(success, messageToDisplay, fadeTime);
    }

    public void OthershowSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        int fadeTime = success ? 3000 : 8000;
        lnkRegisterEyeWitnessOther.setRendered(false);
        showSuccessOrFailureMessageOther(success, messageToDisplay, fadeTime);
    }

//   public void showSuccessOrFailureMessage(boolean success, String messageToDisplay)
//        {
//        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
//        lblSuccessOrErrorMessage.setValue(messageToDisplay);
//        lblSuccessOrErrorMessage.setVisible(true);
//        pnlPopupSuccessOrFailure.setAutoCentre(true);
//        pnlPopupSuccessOrFailure.setRendered(true);
//        lnkRecordEyeWitnesses.setRendered(true);
//        String val = "message";
//        String fadeTime = (success ? "3000" : "8000");
//        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
//                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
//        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
//    }
    private boolean validateAndInitializeDisciplineAttributes() {

        if (employeeStatus.equalsIgnoreCase("Manager")) {
            if (txtDisciplineDate.getValue() == null ||
                    txtaRequestedMeasureToBeTaken.getValue() == null ||
                    txtaDisciplineDescription.getValue() == null ||
                    drlDis_Type_ForManager.getValue().toString().split("--").equals("-1")) {
                showSuccessOrFailureMessageApprovedHere(false, " NOT FILLED <br>=> Date or Decision or  <br>=> Description<br>=>DisciplineType",50);
                return false;
            } else {
                offenceType = drlDis_Type_ForManager.getValue().toString().split("--")[0];
                descriptionOfOffence = txtaDisciplineDescription.getValue().toString();
                requestedMeasureToBeTaken = txtaRequestedMeasureToBeTaken.getValue().toString();
            }
        } else {
            if (txtDisciplineDate.getValue().toString() == null ||
                    txtaRequestedMeasureToBeTaken.getValue() == null ||
                    txtaDisciplineDescription.getValue() == null ||
                    drlDisciplineType.getValue().toString().split("--")[0].equals("-1")) {
                showSuccessOrFailureMessageApprovedHere(false, " NOT FILLED <br>=> Date or Decision or  <br>=> Description<br>=>DisciplineType",50);
                return false;
            } else {
                offenceType = drlDisciplineType.getValue().toString().split("--")[0];
                descriptionOfOffence = txtaDisciplineDescription.getValue().toString();
                requestedMeasureToBeTaken = txtaRequestedMeasureToBeTaken.getValue().toString();
            }
        }
        return true;
    }

    private boolean validateAndInitializeDisciplineRequest() {
        if (requesterId == null || offenderId == null) {
           showSuccessOrFailureMessageApprovedHere(false, "SELECT EMPLOYEE FIRST",50);
            return false;
        } else if (requesterId.equals(offenderId)) {
            showSuccessOrFailureMessageApprovedHere(false, "SAME REQUESTER AND ACCUSED",50);
            return false;
        } else if (!requesterId.equals(loggedInEmployeeId) && (txtDocReferenceNumber.getValue() == null || txtDocReferenceNumber.getValue().toString().equals(""))) {
            showSuccessOrFailureMessageApprovedHere(false, "PLEASE FILL DOCUMENT REFERENCE NUMBER",50);
            return false;
        } else if (!validateAndInitializeDisciplineAttributes()) {
            return false;
        }
        if (txtDisciplineDate == null) {
            return false;
        } else {
            if (((Date) calOffenceDate.getValue()).after((Date) calReportedDate.getValue()) ||//offence date not allowed to be after reported date
                    ((Date) calReportedDate.getValue()).after(new Date())) {//reported date not allowed to be  future date
                showSuccessOrFailureMessageApprovedHere(false, "INVALID OFFENCE DATE : " + dateFormat.format((Date) calOffenceDate.getValue()) +
                        "<br> OR<br>INVALID REPORTED DATE : " + dateFormat.format((Date) calReportedDate.getValue()),50);
                return false;
            } else {
                dateOfOffence = dateFormat.format((Date) calOffenceDate.getValue());
                reportedDate = dateFormat.format((Date) calReportedDate.getValue());
            }
        }
        if (txtaDisciplineDescription.getValue() != null) {
            descriptionOfOffence = txtaDisciplineDescription.getValue().toString();
        } else {
            descriptionOfOffence = "Not Registered";
        }
        if (txtaRequestedMeasureToBeTaken.getValue() != null) {
            requestedMeasureToBeTaken = txtaRequestedMeasureToBeTaken.getValue().toString();
        } else {
            requestedMeasureToBeTaken = "Not Registered";
        }
        if (txtDocReferenceNumber.getValue() != null) {
            documentReferenceNumber = txtDocReferenceNumber.getValue().toString();
        } else {
            documentReferenceNumber = "none";
        }
        return true;
    }

    private void makePageReadyForApprove() {

        availableDecisionsToMake = disciplineApproveManager.getAvailableDecisionsToMake(getSessionBean1().getUserName());
        salary = disciplineRequestManager.getEmployeeSalary(offenderId);
        duration = disciplineRequestModel.getDeductionDuration();
        penaliyedDays = Integer.parseInt(disciplineRequestModel.getPenalizedDays());
        if (penaliyedDays == 0) {
            disciplineRequestModel.setDeductAmount(0.0);
        } else {
            double dalySalary = (salary / 26);
            double deduction = (dalySalary * penaliyedDays);
            double lastDeduction = (deduction / duration);
            disciplineRequestModel.setDeductAmount(lastDeduction);
        }

        txtArea_ExpectedPenality.setValue(disciplineRequestModel.getExpectedPenalityToBeGiven());
        txt_DeductionAmount.setValue(disciplineRequestModel.getDeductAmount());
        txt_DeductionDuration.setValue(disciplineRequestModel.getDeductionDuration());

    }

    public String btnSaveOrUpdate_action() {
              if(isEntryValidForDisRequest()){

        if (saveOrEditOrUpdateLabel.equalsIgnoreCase("Save"))

        {

            if (validateAndInitializeDisciplineRequest()) {

                if (requesterType.equals(IMMEDIATEBOSS) || requesterType.equals(ANOTHEREMPLOYEE)) {

                    if ((employeeManager.isBossOfEmployee(requesterId, offenderId) && ((requesterRank >= 12) && (requesterJobLevel.equalsIgnoreCase("MG"))))||delegationManager.cheakDisciplineAutontication(requesterId)) {

                        if (disciplineRequestManager.IsPenalityCanBeApproved(Integer.parseInt(offenceType.toString()), repititionOfOffence)) {
                            canBeApproved = "True";
                        //  showSuccessOrFailureMessageApprovedHere(true, "YOU CAN APPROVED THIS PENALITY HERE:",20);
                        }
                    }
                        
                    if (disciplineRequestManager.saveDisciplineRequest(dateOfOffence, requesterType, requesterId,
                            offenderId, reportedDate, offenceType, repititionOfOffence, descriptionOfOffence,
                            requestedMeasureToBeTaken, documentReferenceNumber, reporterID, reporterFullName, reporterDepartment, reporterposition, employeeStatus, canBeApproved)) {
                        lnkRecordEyeWitnesses.setRendered(true);
                      
                         showSuccessOrFailureMessageApprovedHere(true," SAVING SUCCESSFUL: " +
                                "<br>YOU CAN REGISTER EYE WITNESSES ANY TIME " +
                                "  BY SELECTING THIS REQUEST FROM THE LEFT MENU",50);
                        pendingRequestLists = disciplineRequestManager.getPendingRequests();
                        pendingListsThatCanBeApproved = disciplineRequestManager.getPendingRequestsCanBeApprovrd();
                        clearAllComponents();
                    } else {
                        lnkRecordEyeWitnesses.setRendered(false);
                        showSuccessOrFailureMessageApprovedHere(false, "!SORRY SAVING FAILED",50);
                    }

                } else if (requesterType.equals(NOTEMPLOYEE)) {
                }
            }
        }
         } else if (saveOrEditOrUpdateLabel.equalsIgnoreCase("Update")) {
            makePageReadyForUpdate();
            repititionOfOffence = Integer.parseInt(drl_Reputaion.getValue().toString());

            if (validateAndInitializeDisciplineRequest()) {
                if (requesterType.equals(IMMEDIATEBOSS) || requesterType.equals(ANOTHEREMPLOYEE)) {
                    if (disciplineRequestManager.UPdateDisciplineRequest(dateOfOffence, requesterType, requesterId,
                            offenderId, reportedDate, offenceType, repititionOfOffence, descriptionOfOffence,
                            requestedMeasureToBeTaken, documentReferenceNumber, disciplineProblemId, reporterID, reporterFullName, reporterDepartment, reporterposition)) {
                        lnkRecordEyeWitnesses.setRendered(true);
                        showSuccessOrFailureMessageApprovedHere(true, "UPDATING SUCCESSFUL: ",50);

                        pendingRequestLists = disciplineRequestManager.getPendingRequests();
                    // clearAllComponents();
                    } else {
                        lnkRecordEyeWitnesses.setRendered(false);
                        showSuccessOrFailureMessageApprovedHere(false, "!UPDATING FAILED",50);
                    }
                }
            }
        } else {// if(saveOrEditOrUpdateLabel.equalsIgnoreCase("Update")){
            //update mmethod called here
        }
        return null;
    }

    public int getRequesterRank() {
        return requesterRank;
    }

    public void setRequesterRank(int requesterRank) {
        this.requesterRank = requesterRank;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getPenaliyedDays() {
        return penaliyedDays;
    }

    public void setPenaliyedDays(int penaliyedDays) {
        this.penaliyedDays = penaliyedDays;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
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
        dateOfOffence = dateFormat.format(calReportedDate.getValue());
        return null;
    }

    public void calReportedDate_processValueChange(ValueChangeEvent vce) {
        txtReportedDate.setValue(dateFormat.format(calReportedDate.getValue()));
        reportedDate = dateFormat.format(calReportedDate.getValue());
        calReportedDate.setRendered(false);
    }

    public void calOffenceDate_processValueChange(ValueChangeEvent vce) {
        txtDisciplineDate.setValue(dateFormat.format(calOffenceDate.getValue()));
        dateOfOffence = dateFormat.format(calOffenceDate.getValue());
        calOffenceDate.setRendered(false);
    }

    public void radioGroupApplierType_processValueChange(ValueChangeEvent vce) {
        requesterType = vce.getNewValue().toString();
        if (vce.getNewValue().toString().equals(IMMEDIATEBOSS)) {
            //  btnSearchRequester.setRendered(false);
            //  txtRequesterId.setDisabled(true);
            populateRequesterTextComponents(loggedInEmployeeId);
        } else if (vce.getNewValue().toString().equals(ANOTHEREMPLOYEE)) {
            requesterId = null;
            clearRequesterTextComponents();
        //    txtRequesterId.setDisabled(false);
        //  btnSearchRequester.setRendered(true);
        } else {//}else if(vce.getNewValue().toString().equals(NOTEMPLOYEE)) {
        }
    }

    public void drlDisciplineType_processValueChange(ValueChangeEvent vce) {

        String phaseOutPeriodNew;
        int phaseOutPeriod;
        String phaseOut;
        try {
            if (offenderId != null) {
                disciplineTypeId = Integer.parseInt(vce.getNewValue().toString().split("--")[0]);
                //int phaseOutPeriod = Integer.parseInt(vce.getNewValue().toString().split("--")[1]);//in months
                phaseOutPeriodNew = vce.getNewValue().toString().split("--")[1];
                phaseOutPeriod = Integer.parseInt(phaseOutPeriodNew.toString());
                repititionOfOffence = disciplineRequestManager.getPrevieousOffenceCommited(disciplineTypeId, offenderId, phaseOutPeriod);
                txtDisciplinePreviousOccurance.setValue(repititionOfOffence);
            }
            drl_Reputaion.setDisabled(false);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }

    }

   

    public String btnSearchOffender_action() {
        if (txtEmployeeId.getValue() != null) {
            offenderId = txtEmployeeId.getValue().toString();
            if (!populateEmployeeTextComponents(offenderId)) {
                offenderId = null;
            } else if (!drlDisciplineType.getValue().toString().equals("-1--0")) {//if some value is selected
                int disciplineTypeId = Integer.parseInt(drlDisciplineType.getValue().toString().split("--")[0]);
                int phaseOutPeriod = Integer.parseInt(drlDisciplineType.getValue().toString().split("--")[1]);//in months
                repititionOfOffence = disciplineRequestManager.getPrevieousOffenceCommited(disciplineTypeId, offenderId, phaseOutPeriod);
                txtDisciplinePreviousOccurance.setValue(repititionOfOffence);
            }
        }
        return null;
    }

    public boolean setSelectedDisciplineType(String disciplineType) {
        for (Option lookingFor : disciplineTypesList) {
            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
                drlDisciplineType.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }

    public boolean setSelectedDisciplineTypeForManager(String disciplineType)
    {
        for (Option lookingFor : disciplineTypesListForManager) {
            if (lookingFor.getValue().toString().startsWith(disciplineType)) {
                drlDis_Type_ForManager.setValue(lookingFor.getValue().toString());
                return true;
            }
        }
        return false;
    }

    public void headerTextEducLevelName_processValueChange(ValueChangeEvent vce) {
        String[] requestInfo = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(requestInfo[0]);
        requesterId = requestInfo[1];
        status = requestInfo[2];
        offenceType = requestInfo[3];
        //  populateAllComponents(offenceType, disciplineProblemId);
        makePageReadyForUpdate();
    }

    public void selectHistory_processValueChange(ValueChangeEvent vce) {

        String[] requestInfo = vce.getNewValue().toString().split("--");
        disciplineProblemId = Integer.parseInt(requestInfo[0]);
        requesterId = requestInfo[1];
        status = requestInfo[2];
        offenceType = requestInfo[3];
        disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
        populateAllComponents(disciplineRequestModel);
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null) {
            requesterId = txtRequesterId.getValue().toString();
            if (!populateRequesterTextComponents(requesterId)) {
                requesterId = null;
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

    public String lnkDisciplineRegistrationPage_action_action() {
        return "DisciplineTypes";
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
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

    public String txtFullName_action() {
        clearEmployeeTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateEmployeeTextComponents(requesterId);
        return null;
    }
    private SelectInputText txtEmployeeFullName = new SelectInputText();

    public SelectInputText getTxtEmployeeFullName() {
        return txtEmployeeFullName;
    }

    public void setTxtEmployeeFullName(SelectInputText txtEmployeeFullName) {
        this.txtEmployeeFullName = txtEmployeeFullName;
    }

    public String txtEmployeeFullName_action() {
        clearEmployeeTextComponents();
        offenderId = ApplicationBean1.getSelectedEmployeeId();
        populateEmployeeTextComponents(offenderId);
        return null;
    }

    public String txtWitnessFullName_action() {
        clearEyeWitnessTextComponents();
        witnessId = ApplicationBean1.getSelectedEmployeeId();
        populateEyeWitnessComponents(witnessId);
        return null;
    }

    public void cmdLnkRemoveEntryOther_processAction(ActionEvent ae) {
        int selectedRowEyeOtherWitness = -1;
    }

    public void lnkViewPrevieousDecisions_processAction(ActionEvent ae) {
    }
    int selectedRowEyeWitness = -1;

    public void rowSelectorDisciplinePenalty_processMyEvent(RowSelectorEvent rse) {
        selectedRowEyeWitness = rse.getRow();
    }

    public void rowSelectorDisciplineWitness_processMyEvent(RowSelectorEvent rse) {
        int selectedRowOtherEyeWitness = -1;
        selectedRowOtherEyeWitness = rse.getRow();
    }

    public String lnkRecordEyeWitnesses_action() {
        populateAndRenderEyeWitnessPanel();

        return null;
    }

    private void populateAndRenderEyeWitnessPanel() {
        eyeWitnessesList = eyeWitnessManager.getEyeWitnessesList(disciplineProblemId);
        pnlEyeWitnessesRegistration.setRendered(true);
        pnlPopupSuccessOrFailure.setRendered(false);
    }

    public void lnkRegisterEyeWitness_action() {
        disciplineProblemId = disciplineRequestManager.getCurrentRequestId();
        populateAndRenderEyeWitnessPanel();

    }

    public void lnkRegisterEyeWitnessOther_action() {
        // disciplineProblemId=disciplineRequestManager.getCurrentRequestId();
        otherEyeWitnessesList = eyeWitnessManager.getOtherEyeWitnessList(disciplineProblemId);
        pnlOtherEyeWitnessesRegistration.setRendered(true);
        pnlPopupSuccessOrFailureOther.setRendered(false);

    }

    public String cmdLnkRemoveEntry_action() {
        if (selectedRowEyeWitness != -1) {
            if (eyeWitnessesList.get(selectedRowEyeWitness).getDatabaseStatus().equals("New")) {
                eyeWitnessesList.remove(selectedRowEyeWitness);
            } else {
                if (!eyeWitnessesList.get(selectedRowEyeWitness).getPointedByAccused().equalsIgnoreCase("Yes")) {
                    eyeWitnessesList.get(selectedRowEyeWitness).setDatabaseStatus("Deleted");
                } else {
                    eyeWitnessesList.get(selectedRowEyeWitness).setPointedByRequester("No");
                }
            }
        }
        return null;
    }

    public String cmdLnkRemoveEntryOther_action() {
        if (selectedRowEyeOtherWitness != -1) {
            if (otherEyeWitnessesList.get(selectedRowEyeOtherWitness).getDatabaseStatus().equals("New")) {
                // cmd_Remove.setRendered(true);
                otherEyeWitnessesList.remove(selectedRowEyeOtherWitness);
            } else {
                if (otherEyeWitnessesList.get(selectedRowEyeOtherWitness).getDatabaseStatus().equals("Old")) {

                    otherEyeWitnessesList.get(selectedRowEyeOtherWitness).setDatabaseStatus("Update");

                    eyeWitnessManager.saveOtherEyeWitnesses(otherEyeWitnessesList);
                }
//                else {
//                    eyeWitnessesList.get(selectedRowEyeWitness).setPointedByRequester("No");
//                }
            }
        }
        return null;
    }

    public String btnClosePopupEyeWitnesses_action() {
        pnlEyeWitnessesRegistration.setRendered(false);
        return null;
    }

    public String btnCloseOtherPopupEyeWitnesses_action() {
        pnlOtherEyeWitnessesRegistration.setRendered(false);
        return null;
    }

    public void panelGroupEyeWitnesses_processMyEvent(DragEvent de) {
    }

    public void disciplineTypeSelection() {
        if (employeeStatus.equalsIgnoreCase("Employee")) {
            drlDis_Type_ForManager.setRendered(false);
            if (disciplineTypesList.isEmpty() || (lookUpManagercont.getEmpitiedTableList() != null && lookUpManagercont.getEmpitiedTableList().contains("HR_LU_DISCIPLINE_TYPE"))) {
                disciplineTypesList = disciplineRequestManager.getDisciplineTypes();
                lookUpManagercont.getEmpitiedTableList().remove("HR_LU_DISCIPLINE_TYPE");
            } else if (employeeStatus.equalsIgnoreCase("Manager")) {

                drlDis_Type_ForManager.setRendered(true);
                if (disciplineTypesListForManager.isEmpty() || (lookUpManagercont.getEmpitiedTableList() != null && lookUpManagercont.getEmpitiedTableList().contains("HR_LU_DISCIPLINE_TYPE"))) {
                    disciplineTypesListForManager = disciplineRequestManager.getDisciplineTypesForManager();

                    lookUpManagercont.getEmpitiedTableList().remove("HR_LU_DISCIPLINE_TYPE");
                }
            }
        } else {
        }


    }

    private boolean checkAvailablityOfEyeWitness() {
        for (EyeWitnessModel currentWitness : eyeWitnessesList) {
            if (currentWitness.getWitnessId().equals(witnessId)) {
                if (currentWitness.getDatabaseStatus().equals("Old") || currentWitness.getDatabaseStatus().equals("Deleted")) {
                    currentWitness.setDatabaseStatus("Edited");
                    currentWitness.setPointedByAccused("Yes");
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean cheakOtherWitnnesConditon() {
        boolean condition = true;
        if (txt_FirstName.getValue().toString().equalsIgnoreCase("") || txt_FirstName.getValue().equals(null) || txt_MiddleName.getValue().toString().equalsIgnoreCase("") || txt_MiddleName.getValue().equals(null) || txt_LastName.getValue().toString().equalsIgnoreCase("") || txt_LastName.getValue().equals(null)) {
            lbl_FirstName.setRendered(true);
            lbl_MiddleName.setRendered(true);
            lbl_LastName.setRendered(true);
            condition = false;
        }
        return condition;
    }

    public String btnAddWinessToTable_action() {
        if (!(witnessId == null || witnessId.equals("-1"))) {
            if (checkAvailablityOfEyeWitness()) {

                eyeWitnessModel = new EyeWitnessModel(disciplineProblemId, witnessId, txtWitnessFullName_New.getValue().toString(), txtWitnessDepartment.getValue().toString(), "New", "Yes", "No", "Employee");
                eyeWitnessesList.add(eyeWitnessModel);
                clearEyeWitnessTextComponents();
                txtWitnessFullName_New1.resetValue();
            }
        }
        return null;
    }

    public String btnSaveWitnesses_action() {

        if (eyeWitnessManager.saveEyeWitnesses(eyeWitnessesList, disciplineProblemId, "Employee")) {
            eyeWitnessManager.uPDateIssue(disciplineProblemId, "Employee");
            showSuccessOrFailureMessageApprovedHere(true, "SAVING OKAY",50);
            pnlEyeWitnessesRegistration.setRendered(false);
        } else {
            showSuccessOrFailureMessageApprovedHere(false, "SAVING FAILED",50);
            pnlEyeWitnessesRegistration.setRendered(false);
        }

        return null;
    }

    public String btnSaveOtherWitnesses_action() {

        if (eyeWitnessManager.saveOtherEyeWitnesses(otherEyeWitnessesList)) {
            eyeWitnessManager.uPDateIssueOther(disciplineProblemId, "Other");

            showSuccessOrFailureMessageDere(true, " Information  Saved Successfuly.");

        //OthershowSuccessOrFailureMessage(true, "SAVING OK");

        // showSuccessOrFailureMessageOther(false, "SAVING OK");
        } else {
            showSuccessOrFailureMessageDere(true, " Information  Saved Successfuly.");
        //OthershowSuccessOrFailureMessage(true, "SAVING FAILED");
        //showSuccessOrFailureMessageOther(false, "SAVING FAILED");

        }

        return null;
    }

    public String btnResetWitnesses_action() {
        clearEyeWitnessTextComponents();
        return null;
    }

    public String btnResetOtherWitnesses_action() {
        //  showSuccessOrFailureMessageOther(true, "this is the reset");
        this.clearOtherEyeWitnessTextCompnets();
        return null;
    }

    public String btnSearchWitness_action() {
        if (txtWitnessId.getValue() != null) {
            witnessId = txtWitnessId.getValue().toString();
            if (!populateEyeWitnessComponents(witnessId)) {
                witnessId = "-1";
            }
        }
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Links">

    public String lnkDisciplineRequest_action() {
        return "DisciplineIssue";
    }

    public String lnkDisciplineApprove_action() {
        return "DisciplineApprove";
    }

    public String lnkAccusedDefence_action() {
        return "AccusedDefence";
    }

    public String lnkEyeWitness_action() {
        return "EyeWitness";
    }

    public String lnkCommitteeMembers_action() {
        return "CommitteeMembers";
    }

    public String lnkDisciplineType_action() {
        return "DisciplineTypes";
    }

    public String lnkCommittee_action() {
        return "Committee";
    }

    public String btnDisciplinePenalty_action() {
        return "DisciplinePenalty";
    }

    public String btnPenaltyType_action() {
        return "PenaltyTypes";
    }

   
    String currentStatus = null;

    public void selectPending_processValueChange(ValueChangeEvent vce) {
        try {

            if (vce.getNewValue() != null) {
                String[] requestInfos = vce.getNewValue().toString().split("--");
                disciplineProblemId = Integer.parseInt(requestInfos[0]);//
                requesterId = requestInfos[1];
                currentStatus = requestInfos[2];
                offenceType = requestInfos[3];
                employeeStatus = requestInfos[4];
                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                } else {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);
                    populateAllComponents(disciplineRequestModel);
                }


//            clearDecisionComponents();
//            renderPreviosDescisionLink(currentStatus);
//            renderCommitteeLink(disciplineProblemId, currentStatus);
//            renderAccusedCommentLink(disciplineProblemId);
            }
        } catch (Exception e) {
        }

    }

    public void drl_Region_processValueChange(ValueChangeEvent vce) {

        zoneList = lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString());
    }

    public void drl_Zone_processValueChange(ValueChangeEvent vce) {
        kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
    }

    public void drl_Woreda_processValueChange(ValueChangeEvent vce) {
        woredaList = lookUpManager.readWoredaAndZone(vce.getNewValue().toString());


    }

    public String btn_ADDTable_action() {

        int disciplineProblemID = disciplineProblemId;
        String dataBaseStatus = "New";
        firstName = txt_FirstName.getValue().toString();
        middleName = txt_MiddleName.getValue().toString();
        lastName = txt_LastName.getValue().toString();
        fullName = firstName + " " + middleName + " " + lastName;
        Witnesssex = drl_sex.getValue().toString();
        region = drl_Region.getValue().toString();
        woreda = drl_Woreda.getValue().toString();
        zone = drl_Zone.getValue().toString();
        kebele = drl_Kebele.getValue().toString();


        if (txt_PoBox.getValue().equals(null) || txt_PoBox.getValue().toString().equalsIgnoreCase("")) {
            poBox = null;
        } else if (txt_Email.getValue().equals(null) || txt_Email.getValue().toString().equalsIgnoreCase("")) {
            eMail = null;
        } else if (txt_HomeTel.getValue().equals(null) || txt_HomeTel.getValue().toString().equalsIgnoreCase("")) {
            teleHome = 0;
        } else if (txt_OfficeTel.getValue().equals(null) || txt_OfficeTel.getValue().toString().equalsIgnoreCase("")) {
            teleOffice = 0;
        } else if (txt_Moblie.getValue().equals(null) || txt_Moblie.getValue().toString().equalsIgnoreCase("")) {
            mobile = 0;
        } else if (txt_HouseNumber.getValue().equals(null) || txt_HouseNumber.getValue().toString().equalsIgnoreCase("")) {
            houseNumber = null;
        } else {

            houseNumber = txt_HouseNumber.getValue().toString();
            poBox = txt_PoBox.getValue().toString();
            eMail = txt_Email.getValue().toString();
            age = Integer.parseInt(txt_Age.getValue().toString());
            mobile = Integer.parseInt(txt_Moblie.getValue().toString());
            teleOffice = Integer.parseInt(txt_OfficeTel.getValue().toString());
            teleHome = Integer.parseInt(txt_HomeTel.getValue().toString());
        }


        if (cheakOtherWitnnesConditon()) {

            otherEyeWitnessesList.add(new OtherMemberEyeWitnessModel(dataBaseStatus, disciplineProblemID, fullName, Witnesssex, age, region, woreda, zone, kebele, houseNumber, poBox, mobile, eMail, teleOffice, teleHome));
        }
        this.clearOtherEyeWitnessTextCompnets();

        return null;
    }

    public void drl_sex_processValueChange(ValueChangeEvent vce) {
    }

    public void txt_PoBox_validate(FacesContext context, UIComponent component, Object value) {
        // this.validateTelephone(context, component, value);
    }

    public void txt_Moblie_validate(FacesContext context, UIComponent component, Object value) {
        this.validateMobile(context, component, value);
    }

    public void txt_Email_validate(FacesContext context, UIComponent component, Object value) {
        this.validateEmail(context, component, value);
    }

    public void txt_OfficeTel_validate(FacesContext context, UIComponent component, Object value) {
        this.validateTelephone(context, component, value);
    }

    public void txt_HomeTel_validate(FacesContext context, UIComponent component, Object value) {
        this.validateTelephone(context, component, value);
    }

    public void txt_FirstName_validate(FacesContext context, UIComponent component, Object value) {
        this.validateName(context, component, value);
    }

    public void txt_MiddleName_validate(FacesContext context, UIComponent component, Object value) {
        this.validateName(context, component, value);
    }

    public void txt_LastName_validate(FacesContext context, UIComponent component, Object value) {
        this.validateName(context, component, value);
    }

    public void groupEyeWitnessType_processValueChange(ValueChangeEvent vce) {

        requesterType = vce.getNewValue().toString();

        if (vce.getNewValue().toString().equals(WORKER)) {
            lnkRecordEyeWitnesses.setRendered(true);
            lnkRecordEyeWitnesses.setDisabled(false);
            lnkOtherWitness.setRendered(false);
            witnessType = "Employee";
        // groupEyeWitnessType.resetValue();

        } else if (vce.getNewValue().toString().equals(NOTWORKER)) {
            lnkRecordEyeWitnesses.setRendered(false);
            lnkOtherWitness.setRendered(true);
            lnkOtherWitness.setDisabled(false);
            groupEyeWitnessType.resetValue();
            witnessType = "Other";

        }
    }

    public String lnkOtherWitness_action() {
        pnlOtherEyeWitnessesRegistration.setRendered(true);
        otherEyeWitnessesList = eyeWitnessManager.getOtherEyeWitnessList(disciplineProblemId);
        return null;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
    }
    public int selectedRowOtherEyeWitness;

    public void OtherWitnessRegistration_processMyEvent(RowSelectorEvent rse) {
        selectedRowOtherEyeWitness = rse.getRow();
    }

    public String btn_ReoveOther_action() {

        if (selectedRowOtherEyeWitness != -1) {
            if (otherEyeWitnessesList.get(selectedRowEyeOtherWitness).getDatabaseStatus().equals("New")) {

                btn_ReoveOther.setValue("Remove");
                otherEyeWitnessesList.remove(selectedRowOtherEyeWitness);
            } else {
                if (otherEyeWitnessesList.get(selectedRowOtherEyeWitness).getDatabaseStatus().equals("Old")) {

                    btn_ReoveOther.setValue("UPdate");

                    otherEyeWitnessesList.get(selectedRowOtherEyeWitness).setDatabaseStatus("Update");

                    eyeWitnessManager.saveOtherEyeWitnesses(otherEyeWitnessesList);
                }
//                else {
//                    eyeWitnessesList.get(selectedRowEyeWitness).setPointedByRequester("No");
//                }
            }
        }
        return null;
    }

    public boolean CanBeApprovedHere(String requesterID, String accusedID, int disciplineID, int reputation) {

        if (employeeManager.isBossOftheEmployee(requesterID, accusedID)) {
            if (disciplineRequestManager.IsPenalityCanBeApproved(disciplineID, reputation)) {
                pendingListsThatCanBeApproved = disciplineRequestManager.getPendingRequests();

            }
        }
        return true;
    }

    public void panelGroupOtherEyeWitnesses_processMyEvent(DragEvent de) {
    }

    public void drl_Reputaion_processValueChange(ValueChangeEvent vce) {

        if (!vce.getNewValue().equals("-1") && vce.getNewValue() != null) {
            String accusedEmployeeID = txtEmployeeId.getValue().toString();
            String currentDay = dateFormat.format(new Date());
            drlDisciplineType.setDisabled(false);
            //  drlDisciplineType.getValue().toString();
            //  int reputaion = Integer.parseInt(vce.getNewValue().toString());
            //  String dbDay = disciplineApproveManager.getCommeentsForWardDay(disciplineProblemId);
            int reputaionCondition = Integer.parseInt(vce.getNewValue().toString());

            if (disciplineRequestManager.ChackPreviousPenalityNewly(accusedEmployeeID, reputaionCondition, disciplineTypeId, currentDay)) {
                showSuccessOrFailureMessageApprovedHere(false, "SORRY PLEASE SELECT OTHER REPUTATION : " +
                        "<br>THIS EMPLOYEE ALREADY PENALIZED BY SELECTED REPUTATION",50);
                btnSaveOrUpdate.setDisabled(true);
            } //            if (disciplineRequestManager.ChackPreviousPenality(accusedEmployeeID, reputaionCondition,disciplineTypeId))
            //
            //              {
            //                showSuccessOrFailureMessage(false, "SORRY PLEASE SELECT OTHER REPUTATION : " +
            //                        "<br>THIS EMPLOYEE ALREADY PENALIZED BY SELECTED REPUTATION");
            //                btnSaveOrUpdate.setDisabled(true);
            //              }
            else {
                if (reputaionCondition == 1) {

                    repititionOfOffence = 1;
                } else if (reputaionCondition == 2) {

                    repititionOfOffence = 2;
                } else if (reputaionCondition == 3) {
                    repititionOfOffence = 3;
                } else if (reputaionCondition == 4) {
                    repititionOfOffence = 4;
                } else if (reputaionCondition == 5) {
                    repititionOfOffence = 5;
                }
            }
        }
    }

    public String txtWitnessFullNameNew_action() {
        clearEyeWitnessTextComponents();
        witnessId = ApplicationBean1.getSelectedEmployeeId();
        populateEmployeeEyeWitnessTextComponents(witnessId);
        return null;

    }

    public String cmd_ApproveNow_action() {
        //return null means stay on the same page
        pnlPopupApproveHere.setRendered(true);
        makePageReadyForApprove();
        return null;
    }

    public String button1_action() {
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        //return null means stay on the same page
        return null;
    }

    public void pnl_col_History_processAction(ActionEvent ae) {
        pnl_col_History.setExpanded(true);
        pnl_col_Pending.setExpanded(true);
        pnl_col_History.setExpanded(true);
        pnl_col_Common_Tasks.setExpanded(false);

    }

    public void pnl_col_Pending_processAction(ActionEvent ae) {
        pnl_col_Pending.setExpanded(true);
        pnl_col_Pending.setExpanded(true);
        pnl_col_History.setExpanded(true);
        pnl_col_Common_Tasks.setExpanded(false);
    }

    public void pnl_col_PendingApproved_processAction(ActionEvent ae) {
        pnl_col_PendingApproved.setExpanded(true);
        pnl_col_Pending.setExpanded(true);
        pnl_col_History.setExpanded(true);
        pnl_col_Common_Tasks.setExpanded(false);
    }

    public void pnl_col_Common_Tasks_processAction(ActionEvent ae) {
        pnl_col_Common_Tasks.setExpanded(true);
        pnl_col_PendingApproved.setExpanded(false);
        pnl_col_Pending.setExpanded(false);
        pnl_col_History.setExpanded(false);
    }
    ///////////////////////////////////////////////Validation///////////////////////////////////////////////////////////////////
     public boolean isEntryValidForDisRequest() {
        boolean results = true; // set false when error ocurred
        boolean required;
        String errorMessage = "*";
        int errorValue = 0;
        required = HRValidation.validateRequired(this.txtDisciplineDate.getValue());

        if (!required) {
            ((UIInput) txtDisciplineDate).setValid(false);
            error(txtDisciplineDate, errorMessage);
            results =
                    false;
        }

        required = HRValidation.validateRequired(this.drl_Reputaion.getValue());

        if (!required) {
            ((UIInput) drl_Reputaion).setValid(false);
            error(drl_Reputaion, errorMessage);
            results = false;

        }
        required = HRValidation.validateRequired(this.txtDocReferenceNumber.getValue());

        if (!required) {
            ((UIInput) txtDocReferenceNumber).setValid(false);
            error(txtDocReferenceNumber, errorMessage);
            results =
                    false;
        }
          required = HRValidation.validateRequired(this.drlDisciplineType.getValue());

        if (!required) {
            ((UIInput) drlDisciplineType).setValid(false);
            error(drlDisciplineType, errorMessage);
            results =
                    false;
        }
            required = HRValidation.validateRequired(this.txtaDisciplineDescription.getValue());

        if (!required) {
            ((UIInput) txtaDisciplineDescription).setValid(false);
            error(txtaDisciplineDescription, errorMessage);
            results =
                    false;
        }
              required = HRValidation.validateRequired(this.txtaRequestedMeasureToBeTaken.getValue());

        if (!required) {
            ((UIInput) txtaRequestedMeasureToBeTaken).setValid(false);
            error(txtaRequestedMeasureToBeTaken, errorMessage);
            results =
                    false;
        }
              required = HRValidation.validateRequired(this.txtaRequestedMeasureToBeTaken.getValue());

        return results;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public void selectPendingCanBeApproved_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                String[] requestInfos = vce.getNewValue().toString().split("--");
                disciplineProblemId = Integer.parseInt(requestInfos[0]);//
                requesterId = requestInfos[1];
                currentStatus = requestInfos[2];
                offenceType = requestInfos[3];
                employeeStatus = requestInfos[4];

                if (employeeStatus.equalsIgnoreCase("Manager")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssuedForManager(offenceType, disciplineProblemId);

                    makePageReadyForApprove();
                    populateAllComponents(disciplineRequestModel);
                    cmd_ApproveNow.setDisabled(false);

                } else if (employeeStatus.equalsIgnoreCase("Normal")) {
                    disciplineRequestModel = disciplineRequestManager.getDisciplineIssued(offenceType, disciplineProblemId);

                    makePageReadyForApprove();
                    populateAllComponents(disciplineRequestModel);
                    cmd_ApproveNow.setDisabled(false);

                }
            }
        } catch (Exception e) {
        }


    }

    public String btn_Approve_action() {
        //return null means stay on the same page
        String decision = drl_Decision.getValue().toString();
        String approverCommentesForFiear = txtArea_Commeents.getValue().toString();
        String suggestedPenalityDuration = "";
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        double suggestedPenalityDeduct = 0.0;
        String suggstedDuration = "";
        String lastApproverCommentes = txtArea_Commeents.getValue().toString();
        String suggetedPenality = "";
        String suggetedFromPromotion = "";
        String suggetedFromTransfer = "";
        String newPenalty = "";
        String lastComments = "";
        double deductionAmount = 0.0;
        String deductionDuration = "";
        double approvedPenltyDeduct = Double.parseDouble(txt_DeductionAmount.getValue().toString());
        String approvedPenltyDuration = txt_DeductionDuration.getValue().toString();
        String approvedPenality = txtArea_ExpectedPenality.getValue().toString();
        String promotionSuspended = "";
        String transferSuspende = "";
        String promotionDuration = "";
        String transferDuration = "";
        String agreeOnDefaultPenalty = "Yes";
        String forwaredToCommitee = "No";
        forwareToCommeete = "No";
        if (disciplineApproveManager.saveDecisionOnRequestPage(disciplineProblemId, loggedInEmployeeId, currentStatus, lastApproverCommentes, decision, userName, currentDateAndTime, agreeOnDefaultPenalty, forwareToCommeete, newPenalty, deductionAmount, deductionDuration, suggestedPenalityDeduct, suggestedPenalityDuration, approvedPenality, approvedPenltyDeduct, approvedPenltyDuration, lastApproverCommentes, suggetedFromPromotion, suggetedFromTransfer, promotionDuration, transferDuration)) {

            showSuccessOrFailureMessageApprovedHere(true, "DECISION IS POSTED SUCCESSFULLY ", 20);
            pendingListsThatCanBeApproved = disciplineRequestManager.getPendingRequestsCanBeApprovrd();
            historyRequestLists = disciplineRequestManager.getRequestsByRequester();
        }

        return null;
    }

   


   

   
    // </editor-fold 
}
