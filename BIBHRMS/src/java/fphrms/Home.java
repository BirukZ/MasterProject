/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import java.util.*;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class Home extends AbstractPageBean {
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

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private HashMap<String, Locale> locales = null;
    public static boolean isLoged = false;
    private HtmlInputText txtUserName = new HtmlInputText();

    public HtmlInputText getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(HtmlInputText hit) {
        this.txtUserName = hit;
    }
    private PanelPopup pnlLogin = new PanelPopup();

    public PanelPopup getPnlLogin() {
        return pnlLogin;
    }

    public void setPnlLogin(PanelPopup pp) {
        this.pnlLogin = pp;
    }
    private HtmlInputSecret txtPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(HtmlInputSecret his) {
        this.txtPassword = his;
    }
    private HtmlCommandButton btnLogin = new HtmlCommandButton();

    public HtmlCommandButton getBtnLogin() {
        return btnLogin;
    }

    public void setBtnLogin(HtmlCommandButton hcb) {
        this.btnLogin = hcb;
    }
    private HtmlCommandLink lnkEducationPaymentRequest = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationPaymentRequest() {
        return lnkEducationPaymentRequest;
    }

    public void setLnkEducationPaymentRequest(HtmlCommandLink hcl) {
        this.lnkEducationPaymentRequest = hcl;
    }
    private HtmlCommandLink lnkEducationPaymentApprove = new HtmlCommandLink();

    public HtmlCommandLink getLnkEducationPaymentApprove() {
        return lnkEducationPaymentApprove;
    }

    public void setLnkEducationPaymentApprove(HtmlCommandLink hcl) {
        this.lnkEducationPaymentApprove = hcl;
    }
    private HtmlCommandLink lnkchangeInstit = new HtmlCommandLink();

    public HtmlCommandLink getLnkchangeInstit() {
        return lnkchangeInstit;
    }

    public void setLnkchangeInstit(HtmlCommandLink hcl) {
        this.lnkchangeInstit = hcl;
    }
    private HtmlCommandLink lnkprocessChangeInst = new HtmlCommandLink();

    public HtmlCommandLink getLnkprocessChangeInst() {
        return lnkprocessChangeInst;
    }

    public void setLnkprocessChangeInst(HtmlCommandLink hcl) {
        this.lnkprocessChangeInst = hcl;
    }
    private HtmlCommandLink lnklookUpTables = new HtmlCommandLink();

    public HtmlCommandLink getLnklookUpTables() {
        return lnklookUpTables;
    }

    public void setLnklookUpTables(HtmlCommandLink hcl) {
        this.lnklookUpTables = hcl;
    }
    private HtmlCommandLink lnkshiftTimeRegn = new HtmlCommandLink();

    public HtmlCommandLink getLnkshiftTimeRegn() {
        return lnkshiftTimeRegn;
    }

    public void setLnkshiftTimeRegn(HtmlCommandLink hcl) {
        this.lnkshiftTimeRegn = hcl;
    }
    private HtmlCommandLink lnkEmpShift = new HtmlCommandLink();

    public HtmlCommandLink getLnkEmpShift() {
        return lnkEmpShift;
    }

    public void setLnkEmpShift(HtmlCommandLink hcl) {
        this.lnkEmpShift = hcl;
    }
    private HtmlCommandLink lnkshiftRigs = new HtmlCommandLink();

    public HtmlCommandLink getLnkshiftRigs() {
        return lnkshiftRigs;
    }

    public void setLnkshiftRigs(HtmlCommandLink hcl) {
        this.lnkshiftRigs = hcl;
    }
    private HtmlCommandLink lnkInstitutioRegstration = new HtmlCommandLink();

    public HtmlCommandLink getLnkInstitutioRegstration() {
        return lnkInstitutioRegstration;
    }

    public void setLnkInstitutioRegstration(HtmlCommandLink hcl) {
        this.lnkInstitutioRegstration = hcl;
    }
    private HtmlCommandLink lnkAgreementAndDuty = new HtmlCommandLink();

    public HtmlCommandLink getLnkAgreementAndDuty() {
        return lnkAgreementAndDuty;
    }

    public void setLnkAgreementAndDuty(HtmlCommandLink hcl) {
        this.lnkAgreementAndDuty = hcl;
    }

    public Home() {
        locales = new HashMap<String, Locale>(2);
        locales.put("english", new Locale("en", "US"));
        locales.put("amharic", new Locale("am", "ET"));

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
        //   if (isLoged) {
        //       pnlLogin.setRendered(false);
        //   }
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }
/////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public String btnLogin_action() {
//        ResultSet rsFoundUser;
        //   AccessControl accessCtrl = new AccessControl();
        String userName = null;
        String password = null;
        String myReturn = null;
        if (this.getTxtUserName().getValue() != null) {
            userName = this.getTxtUserName().getValue().toString().trim();
        }
        //   if (this.getPwdPassword().getValue() != null) {
        //       password = this.getPwdPassword().getValue().toString().trim();
        //   }
        //  rsFoundUser = accessCtrl.readUser(userName);

        //     try {

        //        if (!rsFoundUser.next()) {
        //         layoutPanelUserNotFound.setVisible(true);
        //     } else if (!rsFoundUser.getString("password").equals(this.pwdPassword.getValue().toString())) {
        //         layoutPanelWrongPassword.setVisible(true);
        //     } else {

//                commonTaskLeave.setVisible(false);
//                commonTaskAccessControl.setVisible(false);
//                commonTask1.setVisible(false);
//                commonTask3.setVisible(false);
//                commonTask4.setVisible(false);
//                commonTask5.setVisible(false);
//                commonTask6.setVisible(false);
//                layoutPanel1.setVisible(false);
        isLoged = true;
        //        layoutPanel1.setVisible(false);
//
//                this.getSessionBean1().getSessionData().put("userName", this.txtUserName.getValue().toString());
//
//                ArrayList<PageAccess> pagesList = accessCtrl.setAccessControl(userName);
//
//                if (-1 != pagesList.indexOf("LeaveRequest") || -1 != pagesList.indexOf("LeaveApproval") || -1 != pagesList.indexOf("LeaveGrant")) {
//
//                    commonTaskLeave.setVisible(true);
//                }
//                if (-1 != pagesList.indexOf("AccessControlPage")) {
//                    commonTaskAccessControl.setVisible(true);
//                }

        //myReturn = "Employee";
        // myReturn = "LeaveApproval";
        //       }

        //   } catch (Exception ex) {
        //       ex.printStackTrace(); ErrorLogWriter.writeError(ex);
        // return null;
        //  }
        return myReturn;
    }

    public String am_action() {
        // TODO: Replace with your code
        UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
        viewRoot.setLocale(new Locale("am"));
        return "chooseLocale";
    }

    public String lnkEn_action() {
        //return null means stay on the same page

        return null;
    }

    public void amharic_processAction(javax.faces.event.ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public String amharic_action() {
        //return null means stay on the same page
//          UIViewRoot viewRoot = FacesContext.getCurrentInstance().getViewRoot();
//        viewRoot.setLocale(new Locale("am"));
        return null;
    }

    public void english_processAction(javax.faces.event.ActionEvent ae) {
        String current = ae.getComponent().getId();
        FacesContext context = FacesContext.getCurrentInstance();
        context.getViewRoot().setLocale((Locale) locales.get(current));
    }

    public void btnLogin_processAction(ActionEvent ae) {
    }

    public String lnkOverTimeRequest_action() {
        return "OverTimeRequest";
    }

    public String lnkOverTimeApprove_action() {
        return "OverTimeApprove";
    }

    public String lnkOverTimeAttendanceApprovePage_action() {
        return "OverTimeAttendanceApprove";
    }

    public String lnkOverTimeAttendance_action() {
        //return null means stay on the same page
        return "OverTimeAttendance";
    }

    public String lnkOverTimeReport_action() {
        //return null means stay on the same page
        return "OverTimeReport";
    }

    public String lnkDocumentRequest_action() {
        //return null means stay on the same page
        return "DocumentRequest";
    }

    public String lnkLeaveManagment_action() {
        //return null means stay on the same page
        return "leaveManagment";
    }

    public String lnkAssignEmployeetoHisherBoss_action() {
        //return null means stay on the same page
        return "AssignEmployee";
    }

    public String lnklnkYearlyBonesRequest_action() {
        //return null means stay on the same page
        return "YearlyBonesRequest";
    }

    public String lnklnkHolydayBonesRequest_action() {
        //return null means stay on the same page
        return "HolydayBonesRequest";
    }

    public String lnkDocumentRequestApproval_action() {
        //return null means stay on the same page
        return "DocumentRequestApproval";
    }

    public String lnkCourtOrderPayment_action() {
        //return null means stay on the same page
        return "CourtOrderPayment";
    }

    public String cmdEmployeeAttendance_action() {
        //return null means stay on the same page
        return "AttendanceTracking";
    }

    public String cmdPromotionRequest_action() {
        //return null means stay on the same page
        return "RequestForPromotion";
    }

    public String cmdApprovePromotionRequest_action() {
        //return null means stay on the same page
        return "ApproveRequestPromotion";
    }

    public String cmdPromoteEmployees_action() {
        //return null means stay on the same page
        return "PromoteEmployee";
    }

    public String ccmdPromoteReport_action() {
        //return null means stay on the same page
        return "PromoteReport";
    }

    public String cmdLeaveTypePage_action() {
        //return null means stay on the same page
        return "LeaveTypePage";
    }

    public String lnkTerminationApproval_action() {
        //return null means stay on the same page
        return "TerminationApproval";
    }

    public String lnkTerminationClearance_action() {
        //return null means stay on the same page
        return "TerminationClearance";
    }

    public String lnkDefineQuestionnaire_action() {
        //return null means stay on the same page
        return "DefineQuestionnaire";
    }

    public String lnkTransferReques_action() {
        //return null means stay on the same page
        return "TransferRequest";
    }

    public String cmdPowerDeligationRequest_action() {
        return "PowerDeligationRequest";
    }

    public String cmdPowerDeligationApprove_action() {
        return "PowerDeligationApprove";
    }

    public String cmdSalaryDeligationRequest_action() {
        return "SalaryDeligationRequest";
    }

    public String cmdSalaryDeligationApprove_action() {
        return "SalaryDeligationApprove";
    }

    public String cmdViewPowerDelegationReport_action() {
        return "ViewDelegation";
    }

    public String lnkTransferApprove_action() {
        //return null means stay on the same page
        return "TransferApprove";
    }

    public String cmdFilterCandidateForExam_action() {
        //return null means stay on the same page
        return "FilterCandidateForExam";
    }

    public String lnkCommittee_action() {
        //return null means stay on the same page
        return "CommitteeRegistration";
    }


     public String lnkEvaluation_action() {
        //return null means stay on the same page
        return "EvaluationNavigation";
    }


    public String lnkCommitteeMember_action() {
        return "CommitteeMemberRegistration";
    }

    public String lnkPositionBenefit_action() {
        return "PositionBenefit";
    }

    public String lnkBenefitType_action() {
        return "BenefitType";
    }

    public String lnkReportPageList_action() {
        return "ReportPageRegistration";
    }

    public String lnkReportCritera_action() {
        return "ReportCritera";
    }

    public String lnkAdministration_action() {
        //return null means stay on the same page
        return "Admin";
    }

    public String lnkAuthorization_action() {
        return "Authorization";
    }

    public String cmdOrganization_action() {
        //return null means stay on the same page
        return "OrganizationStructure";
    }
     public String cmdIncrementSalary_action() {
        //return null means stay on the same page
        return "IncrementSalary";
    }


    public String cmdJobType_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String cmdJobTypeQualification_action() {
        //return null means stay on the same page
        return "JobTypeQualifications";
    }

    public String cmdJobAssignment_action() {
        //return null means stay on the same page
        return "JobAssignment";
    }

    public String cmdRecruitmentRequest_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdFilterCandidate_action() {
        //return null means stay on the same page

        return "FilterCandidates";
    }

    public String cmdMaintainAdvertisement_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String cmdExamQuestions_action() {
        //return null means stay on the same page
        return "ExameQuestion";
    }

    public String cmdPositionBenefitTypes_action() {
        return "PositionBenefit";
    }

    public String cmdBenefitTypes_action() {
        return "BenefitType";
    }

    public String cmdApprovedRecruitmentList_action() {
        //return null means stay on the same page
        return "RecruitmentApprove";
    }

    public String cmdEmployeeProfile_action() {
        //return null means stay on the same page
        return "EmployeeProfile";
    }

    public String cmdPromotion_action() {
        //return null means stay on the same page
        return "Promotion";
    }

    public String cmdTransfer_action() {
        //return null means stay on the same page
        return "TransferRequest";
    }

     public String cmdTransferApprove_action() {
        //return null means stay on the same page
        return "TransferRequestApprove";
    }


    public String cmdEvaluation_action() {
        //return null means stay on the same page
        return "EvaluationNavigation";
    }

    public String cmdTransferHistory_action() {
        //return null means stay on the same page
        return "TransferAndPromotionHistory";
    }

    public String cmdTerminationRequest_action() {
        //return null means stay on the same page
        return "Terminationrequest";
    }

    public String cmdPayGrade_action() {
        //return null means stay on the same page
        return "PayGrade";
    }

    public String cmdRegionAndZoneOrCity_action() {
        //return null means stay on the same page
        return "Region";
    }

    public String cmdWoreda_action() {
        //return null means stay on the same page
        return "Woreda";
    }

    public String cmdKebelle_action() {
        //return null means stay on the same page
        return "Kebelle";
    }

    public String cmdLeaveRequest_action() {
        //return null means stay on the same page
        return "LeaveRequest";
    }

    public String cmdLeaveApprove_action() {
        //return null means stay on the same page
        return "LeaveApprove";
    }

    public String cmdLeaveBalance_action() {
        //return null means stay on the same page
        return "LeaveBalance";
    }

    public String cmdLeaveTransfer_action() {
        //return null means stay on the same page
        return "LeaveTransferRequest";
    }

    public String cmdLeaveTransferApprove_action() {
        //return null means stay on the same page
        return "LeaveTransferApprove";
    }

    public String cmdLeaveType_action() {
        //return null means stay on the same page
        return "LeaveType";
    }

    public String lnkTrainner_action() {
        //return null means stay on the same page
        return "TrainingTypes";
    }

    public String lnkTrainingRequest_action() {
        //return null means stay on the same page
        return "TrainingRequest";
    }

    public String lnkTrainingApproval_action() {
        //return null means stay on the same page
        return "TrainingApprove";
    }

    public String lnkServiceAbsentPaymentRequest_action() {
        //return null means stay on the same page
        return "TransportPaymentRequest";
    }

    public String lnkServiceAbsentPaymentApproval_action() {
        //return null means stay on the same page
        return "TransportAbsenceDatePaymentApprove";
    }

    public String lnkServiceAbsentRegistration_action() {
        //return null means stay on the same page
        return "TransportAbsenceDateRegistration";
    }

    public String lnkAssignEmployeeInlocation_action() {
        //return null means stay on the same page
        return "AssignEmployeeInlocation";
    }

    public String lnkEducationRequest_action() {
        //return null means stay on the same page
        return "EducationRequest";
    }

    public String lnkEducationApprove_action() {
        //return null means stay on the same page
        return "EducationApprove";
    }

    public String lnkEducationPaymentRequest_action() {
        //return null means stay on the same page
        return "EducationPaymentRequest";
    }

    public String lnkEducationPaymentApprove_action() {
        //return null means stay on the same page
        return "EducationPaymentApprove";
    }

    public String lnkDisciplineTypes_action() {
        return "DisciplineTypes";
    }

    public String lnkPenaltyTypes_action() {
        return "PenaltyTypes";
    }

    public String lnkDisciplinePenaltyTypes_action() {
        return "DisciplinePenalty";
    }

    public String lnkDisciplineReport_action() {
        return "DisciplineReport";
    }

    public String cmdDisciplineApproval_action() {
        return "DisciplineApprove";
    }

    public String cmdDisciplineRequest_action() {
        return "DisciplineRequest";
    }

    public String cmdAccusedDefence_action() {
        return "AccusedDefence";
    }

    public String cmdVacancyNotice_action() {
        //return null means stay on the same page
        return "InternalVacancyList";
    }

    public String lnklookUpTables_action() {
        //return null means stay on the same page
        return "DynamicTableloockupCreator";
    }

    public String lnkDynamicReport_action() {
        //return null means stay on the same page
        return "DynamicRepot";
    }

    public String lnkchangeInstit_action() {
        //return null means stay on the same page
        return "ChangeInstitutionPage";
    }

    public String lnkshiftRigs_action() {
        //return null means stay on the same page
        return "ShiftRegistration";
    }

    public String lnkEmpShift_action() {
        // TODO: Replace with your code
        return "EmployeesShift";
    }

    public String lnkshiftTimeRegn_action() {
        // TODO: Replace with your code
        return "ShiftTimeRegistration";
    }

    public String lnkActionPlan_action() {
        //return null means stay on the same page
        return "ActionPlan";
    }

    public String lnkActionPlanCost_action() {
        //return null means stay on the same page
        return "ActionPlanCost";
    }

    public String lnkTrainingProgress_action() {
        //return null means stay on the same page
        return "TrainingProgress";
    }

    public String lnkTrainingProgressCost_action() {
        //return null means stay on the same page
        return "TrainingProgressCost";
    }

    public String lnkEducationPostPaymentRequest_action() {
        // TODO: Replace with your code
        return "EducationPostPaymentRequestPage";
    }

    public String lnkEducationPostPaymentApprove_action() {
        // TODO: Replace with your code
        return "EducationPostPaymentApprovePage";
    }

    public String lnkTerminationClearaceSetting_action() {
        //return null means stay on the same page
        return "TerminationClearaceSetting";
    }

    public String lnkManageQuestions_action() {
        //return null means stay on the same page
        return "ManageQuestions";
    }

    public String lnkTerminationApprove_action() {
        //return null means stay on the same page
        return "TerminationApprove";
    }

    public String lnkGenerateQuestionnairs_action() {
        //return null means stay on the same page
        return "GenerateQuestionnairs";
    }

    public String lnkTerminationReq_action() {
        //return null means stay on the same page
        return "TerminationRequest";
    }

    public String lnkAssignQuestionnaire_action() {
        //return null means stay on the same page
        return "AssignQuestionnaire";
    }

    public String lnkRetirmnt_action() {
        //return null means stay on the same page
        return "Retirment";
    }

    public String lnkReturnFromAnnualLeaveApproave_action() {
        //return null means stay on the same page
        return "ReturnFromAnnualLeaveApproave";
    }

    public String lnkEmployeeLeaveSechedule_action() {
        //return null means stay on the same page
        return "EmployeeLeaveSechedule";
    }

    public String lnkLeaveReport_action() {
        //return null means stay on the same page
        return "LeaveReport";
    }

    public String lnkExtendLeave_action() {
        //return null means stay on the same page
        return "ExtendLeave";
    }

    public String lnkCertifyAttendance_action() {
        //return null means stay on the same page
        return "CertifyAttendance";
    }

    public String lnkDailyWorkerRegistration_action() {
        //return null means stay on the same page
        return "DailyWorkerRegistration";
    }

    public String lnkDailyWorkerAttendance_action() {
        //return null means stay on the same page
        return "DailyWorkerAttendance";
    }
       public String lnkApproveDailyWorkerAttendance_action() {
        //return null means stay on the same page
        return "ApproveDailyWorkerAttendance";
    }


    public String lnkReturnFromAnnualLeaveRequest_action() {
        //return null means stay on the same page

        return "ReturnFromAnnualLeaveRequest";
    }

    public String lnkTakeAttendance_action() {
        //return null means stay on the same page

        return "AttendanceTracking";
    }

    public String lnkApproveBonesRequest_action() {
        //return null means stay on the same page

        return "ApproveBonesRequest";
    }

    public String lnkHolydayBonesApprove_action() {
        //return null means stay on the same page

        return "HolydayBonesApprove";
    }

    public String lnkEmployeeEvaluationResult_action() {
        //return null means stay on the same page

        return "EmployeeEvaluationResult";
    }

    public String lnkBonesReport_action() {
        //return null means stay on the same page

        return "BonesReport";
    }

    public String lnkApproveAttendance_action() {
        //return null means stay on the same page

        return "ApproveAttendance";
    }

    public String lnkprocessChangeInst_action() {
        // TODO: Replace with your code
        //return null means stay on the same page
        return "ChangeInstitutionApprovePage";


    }

    public String lnkInstitutioRegstration_action() {
        // TODO: Replace with your code

        return "InstitutionRegistrationPage";
    }

    public String lnkAgreementAndDuty_action() {
        //return null means stay on the same page
        return "AgreementWithDuty";
    }

    public String lnkSubsidyReq_action() {
        //return null means stay on the same page
        return "SubsidyIndividualRequestPage";
    }

    public String lnkSubsidyApprove_action() {
        //return null means stay on the same page
        return "SubsidyIndividualApprovePage";
    }

    public String lnkMilkBenfit_action() {
        //return null means stay on the same page
        return "EmployeeMilkRegistraion";
    }

    public String lnkBenefitRequest_action() {
        //return null means stay on the same page
        return "BenefitRequestPage";
    }

    public String lnkbenefitApprove_action() {
        //return null means stay on the same page
        return "BenefitRequestApprove";
    }

    public String lnkMilkBenefit_action() {

        //return null means stay on the same page
        return "EmployeeMilkRegistraion";
    }
}
