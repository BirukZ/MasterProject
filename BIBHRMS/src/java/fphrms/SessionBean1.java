
/*
 * SessionBean1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms;

import com.sun.rave.web.ui.appbase.AbstractSessionBean;
import com.sun.sql.rowset.CachedRowSetXImpl;
import com.sun.webui.jsf.model.Option;
import entity.attendanceEntity.Absentee;
import entity.trainingEntity.FeeEntity;
import entity.trainingEntity.TraineeEntity;
import entity.trainingEntity.TrainerSpecializationEntity;
import entity.trainingEntity.TrainingRequestEntity;
import entity.trainingEntity.TrainingTypeEntity;
import entity.userManagement.Entity.UsersEntity;
import fphrms.pageSecurity.PageAdmin.AvilablePermissionDataModel;
import fphrms.pageSecurity.PageAdmin.AvilableRoleDataModel;
import fphrms.pageSecurity.PageAdmin.AvilableUserDataModel;
import fphrms.pageSecurity.PageAdmin.SelectedPermissionDataModel;
import fphrms.pageSecurity.PageAdmin.SelectedRoleDataModel;
import fphrms.pageSecurity.PageAdmin.SelectedUserDataModel;
import manager.departmentManage.DepartmentManage;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
//import javax.swing.JOptionPane;
import manager.clearanceManager.ClearanceManager;
import manager.employeeHistoryManager.EvaluationManager;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeHistoryManager.EvaluationSessionManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;
import manager.recruitmentManager.AdvertisementManager;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.InitiateManager;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 * <p>Session scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available across
 *  multiple HTTP requests for an individual user.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class SessionBean1 extends AbstractSessionBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        hr_employee_infoRowSet.setDataSourceName("java:comp/env/jdbc/federal_police_db_MySQL");
        hr_employee_infoRowSet.setCommand("SELECT * FROM hr_employee_info");
        hr_employee_infoRowSet.setTableName("hr_employee_info");





    }
    private CachedRowSetXImpl hr_employee_infoRowSet = new CachedRowSetXImpl();

    public CachedRowSetXImpl getHr_employee_infoRowSet() {
        return hr_employee_infoRowSet;
    }

    public void setHr_employee_infoRowSet(CachedRowSetXImpl crsxi) {
        this.hr_employee_infoRowSet = crsxi;
    }
    // </editor-fold>
    private List absenteeList = new ArrayList<Absentee>();
    public List selectedCandidateList = new ArrayList<CandidateManager>();
    public List vacancyList = new ArrayList<AdvertisementManager>();
    public List zoneOrCityList = new ArrayList<LookUpManager>();
    public List woredaOrSubCityList = new ArrayList<LookUpManager>();
    private List payGradList = new ArrayList<LookUpManager>();
    public List optKebele = new ArrayList<LookUpManager>();
    public List evaCriteriaOPt = new ArrayList<EvaluationManager>();
    public List evaSessionOPt = new ArrayList<EvaluationSessionManager>();
    public List evaResultOPt = new ArrayList<EvaluationResultManager>();
    public List evaSessionResultOPt = new ArrayList<EvaluationResultManager>();
    public List evaCriteriaEditOPt = new ArrayList<EvaluationManager>();
    public List department = new ArrayList<DepartmentManage>();
    private String empId;
    public String departmentDescrption;
    public String profetion;
    private List traineeList = new ArrayList<TraineeEntity>();
    private List trainingRequestList = new ArrayList<TrainingRequestEntity>();
    private List trainingRequestedList = new ArrayList<TrainingRequestEntity>();
    private List trainingApprovedOrRejectList = new ArrayList<TrainingRequestEntity>();
    private List specializationList = new ArrayList<TrainerSpecializationEntity>();
    private List trainingTypeList = new ArrayList<TrainingTypeEntity>();
    private List feeList = new ArrayList<FeeEntity>();
    private Option[] paymentMethodOpt;
    private Option[] trainingAwardOpt;
    private Option[] parentTrainingOpt;
    private Option[] trainerOpt;
    private boolean parentMethodOptIsCalled = false;
    private boolean paymentMethodOptIsCalled = false;
    private boolean trainingAwardOptIsCalled = false;
    private boolean trainerOptIsCalled = false;
    public String jobDescription;
    private HashMap reportCriteria = new HashMap();
    private HashMap param = new HashMap();
    private String format;
    private String fileName;
    private int reportIndex;
    private boolean reportType;
    public OracleCachedRowSet rs;
    public Collection coll;

    public Collection getColl() {
        return coll;
    }

    public void setColl(Collection coll) {
        this.coll = coll;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public HashMap getParam() {
        return param;
    }

    public void setParam(HashMap param) {
        this.param = param;
    }

    public HashMap getReportCriteria() {
        return reportCriteria;
    }

    public void setReportCriteria(HashMap reportCriteria) {
        this.reportCriteria = reportCriteria;
    }

    public boolean isReportType() {
        return reportType;
    }

    public void setReportType(boolean reportType) {
        this.reportType = reportType;
    }

    public OracleCachedRowSet getRs() {
        return rs;
    }

    public void setRs(OracleCachedRowSet rs) {
        this.rs = rs;
    }

    public String getProfetion() {
        return profetion;
    }

    public void setProfetion(String profetion) {
        this.profetion = profetion;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }
    private InitiateManager initiateManager = new InitiateManager();

    public boolean isParentMethodOptIsCalled() {
        return parentMethodOptIsCalled;
    }

    public void setParentMethodOptIsCalled(boolean parentMethodOptIsCalled) {
        this.parentMethodOptIsCalled = parentMethodOptIsCalled;
    }

    public Option[] getParentTrainingOpt() {
        return parentTrainingOpt;
    }

    public void setParentTrainingOpt(Option[] parentTrainingOpt) {
        this.parentTrainingOpt = parentTrainingOpt;
    }

    public Option[] getPaymentMethodOpt() {
        return paymentMethodOpt;
    }

    public void setPaymentMethodOpt(Option[] paymentMethodOpt) {
        this.paymentMethodOpt = paymentMethodOpt;
    }

    public boolean isPaymentMethodOptIsCalled() {
        return paymentMethodOptIsCalled;
    }

    public void setPaymentMethodOptIsCalled(boolean paymentMethodOptIsCalled) {
        this.paymentMethodOptIsCalled = paymentMethodOptIsCalled;
    }

    public Option[] getTrainerOpt() {
        return trainerOpt;
    }

    public void setTrainerOpt(Option[] trainerOpt) {
        this.trainerOpt = trainerOpt;
    }

    public boolean isTrainerOptIsCalled() {
        return trainerOptIsCalled;
    }

    public void setTrainerOptIsCalled(boolean trainerOptIsCalled) {
        this.trainerOptIsCalled = trainerOptIsCalled;
    }

    public boolean isTrainingAwardOptIsCalled() {
        return trainingAwardOptIsCalled;
    }

    public void setTrainingAwardOptIsCalled(boolean trainingAwardOptIsCalled) {
        this.trainingAwardOptIsCalled = trainingAwardOptIsCalled;
    }

    public Option[] getTrainingAwardOpt() {
        return trainingAwardOpt;
    }

    public void setTrainingAwardOpt(Option[] trainingAwardOpt) {
        this.trainingAwardOpt = trainingAwardOpt;
    }

    public List getFeeList() {
        return feeList;
    }

    public void setFeeList(List feeList) {
        this.feeList = feeList;
    }

    public List getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List specializationList) {
        this.specializationList = specializationList;
    }

    public List getTraineeList() {
        return traineeList;
    }

    public void setTraineeList(List traineeList) {
        this.traineeList = traineeList;
    }

    public List getTrainingApprovedOrRejectList() {
        return trainingApprovedOrRejectList;
    }

    public void setTrainingApprovedOrRejectList(List trainingApprovedOrRejectList) {
        this.trainingApprovedOrRejectList = trainingApprovedOrRejectList;
    }

    public List getTrainingRequestList() {
        return trainingRequestList;
    }

    public void setTrainingRequestList(List trainingRequestList) {
        this.trainingRequestList = trainingRequestList;
    }

    public List getTrainingRequestedList() {
        return trainingRequestedList;
    }

    public void setTrainingRequestedList(List trainingRequestedList) {
        this.trainingRequestedList = trainingRequestedList;
    }

    public List getTrainingTypeList() {
        return trainingTypeList;
    }

    public void setTrainingTypeList(List trainingTypeList) {
        this.trainingTypeList = trainingTypeList;
    }

    public void addTrainerSpecializationList(TrainerSpecializationEntity trainerSpecializationList) {
        getSpecializationList().add(trainerSpecializationList);
    }

    public void addTrainingTypeList(TrainingTypeEntity trainingTypeList) {
        getTrainingTypeList().add(trainingTypeList);
    }

    public void addFeeList(FeeEntity feeList) {
        getFeeList().add(feeList);
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the absenteeList
     */
    public List getAbsenteeList() {
        return absenteeList;
    }

    /**
     * @param absenteeList the absenteeList to set
     */
    public void setAbsenteeList(List absenteeList) {
        this.absenteeList = absenteeList;
    }

    public void addAbsentee(Absentee absentee) {
        absenteeList.add(absentee);
    }

    public List getDepartment() {
        return department;
    }

    public void setDepartment(List department) {
        this.department = department;
    }

    public void addDepartment(DepartmentManage addTo) {
        department.add(addTo);
    }
    public List minExperiance = new ArrayList<DepartmentManage>();
    public List mediaTypeList = new ArrayList<AdvertisementManager>();

    public List getOptKebele() {
        return optKebele;
    }

    public void setOptKebele(List optKebele) {
        this.optKebele = optKebele;
    }

    public void addKebele(LookUpManager addToTable) {
        optKebele.add(addToTable);
    }

    /**
     * @return the evaCriteriaOPt
     */
    public List getEvaCriteriaOPt() {
        return evaCriteriaOPt;
    }

    /**
     * @param evaCriteriaOPt the evaCriteriaOPt to set
     */
    public void setEvaCriteriaOPt(List evaCriteriaOPt) {
        this.evaCriteriaOPt = evaCriteriaOPt;
    }

    public void addEvaCriteria(EvaluationManager addEvaCriteriaToTable) {
        getEvaCriteriaOPt().add(addEvaCriteriaToTable);
    }

    public List getPayGradList() {
        return payGradList;
    }

    public void setPayGradList(List payGradList) {
        this.payGradList = payGradList;
    }

    public void addPayGradList(LookUpManager addToTable) {
        payGradList.add(addToTable);
    }

    public void addZoneOrCityList(LookUpManager addToTable) {
        zoneOrCityList.add(addToTable);
    }

    public List getWoredaOrSubCityList() {
        return woredaOrSubCityList;
    }

    public void setWoredaOrSubCityList(List woredaOrSubCityList) {
        this.woredaOrSubCityList = woredaOrSubCityList;
    }

    public void addWoredaOrSubCityList(LookUpManager lookUpmanager) {
        woredaOrSubCityList.add(lookUpmanager);
    }

    public List getZoneOrCityList() {
        return zoneOrCityList;
    }

    public void setZoneOrCityList(List cityOrCityList) {
        this.zoneOrCityList = cityOrCityList;
    }

    public void addCityOrCityList(LookUpManager lookUpmanager) {
        zoneOrCityList.add(lookUpmanager);
    }

    public List getVacancyList() {
        return vacancyList;
    }

    public void setVacancyList(List vacancyList) {
        this.vacancyList = vacancyList;
    }

    public void addVacancyList(AdvertisementManager candidate) {
        vacancyList.add(candidate);
    }

    public List getSelectedCandidateList() {
        return selectedCandidateList;
    }

    public void setSelectedCandidateList(List selectedCandidateList) {
        this.selectedCandidateList = selectedCandidateList;
    }

    public List getMediaTypeList() {
        return mediaTypeList;
    }

    public void setMediaTypeList(List mediaTypeList) {
        this.mediaTypeList = mediaTypeList;
    }
    public String employee_id;
    private List clearingDeptList = new ArrayList<ClearanceManager>();

    public List getClearingDeptList() {
        return clearingDeptList;
    }

    public void setClearingDeptList(List clearingDeptList) {
        this.clearingDeptList = clearingDeptList;
    }

    public String getEmployee_id() {
        return employee_id;
    }

    public void addMediaTypeList(AdvertisementManager mediaTypeObj) {
        mediaTypeList.add(mediaTypeObj);
    }

    public void setEmployee_id(String employee_id) {
        this.employee_id = employee_id;
    }

    public List getMinExperiance() {
        return minExperiance;
    }

    public void setMinExperiance(List minExperiance) {
        this.minExperiance = minExperiance;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public void addminExperiance(DepartmentManage departmentManage) {
        this.getMinExperiance().add(departmentManage);
    }

    /**
     * <p>Construct a new session data bean instance.</p>
     */
    public SessionBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * session scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * session scope.</p>
     *
     * <p>You may customize this method to initialize and cache data values
     * or resources that are required for the lifetime of a particular
     * user session.</p>
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
            log("SessionBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

    // </editor-fold>
    // Perform application initialization that must complete
    // *after* managed components are initialized
    // TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when the session containing it is about to be
     * passivated.  Typically, this occurs in a distributed servlet container
     * when the session is about to be transferred to a different
     * container instance, after which the <code>activate()</code> method
     * will be called to indicate that the transfer is complete.</p>
     *
     * <p>You may customize this method to release references to session data
     * or resources that can not be serialized with the session itself.</p>
     */
    public void passivate() {
    }

    /**
     * <p>This method is called when the session containing it was
     * reactivated.</p>
     *
     * <p>You may customize this method to reacquire references to session
     * data or resources that could not be serialized with the
     * session itself.</p>
     */
    public void activate() {
    }

    /**
     * <p>This method is called when this bean is removed from
     * session scope.  Typically, this occurs as a result of
     * the session timing out or being terminated by the application.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }
    private String userName = null,  password = null,  requestedPage = null,  employeeName = null,  employeeId = null,  empDeptId = null,  dbUserName;
    int kebeleId = 0, officeLevel = 0;
    UsersEntity users = new UsersEntity();
    EmployeeManage employeeManage = new EmployeeManage();
    SiteSecurityManager siteSecurityManager = new SiteSecurityManager();

    public String getEmpDeptId() {
        return empDeptId;
    }

    public void setEmpDeptId(String empDeptId) {
        this.empDeptId = empDeptId;
    }

    public int getKebeleId() {
        return kebeleId;
    }

    public void setKebeleId(int kebeleId) {
        this.kebeleId = kebeleId;
    }

    public int getOfficeLevel() {
        return officeLevel;
    }

    public void setOfficeLevel(int officeLevel) {
        this.officeLevel = officeLevel;
    }


    //<editor-fold defaultstate="collapsed" desc="Getter and Setters " >
    public String getDbUserName() {

        return dbUserName;
    }

    public void setDbUserName(String dbUserName) {
        this.dbUserName = dbUserName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getRequestedPage() {
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq =
                (HttpServletRequest) context.getExternalContext().getRequest();
        String _requestedPage = httpReq.getRequestURI();
        setRequestedPage(_requestedPage);
        return requestedPage;
    }

    public void setRequestedPage(String _requestedPage) {
        requestedPage = _requestedPage;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String _password) {
        password = _password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String _userName) throws Exception {

        try {
            setDbUserName(users.getDbUserName(_userName));
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        this.userName = _userName;
        this.employeeId = siteSecurityManager.selectEmployeeId(userName);
       
        employeeManage.loadEmpoyeeProfile(employeeId);
        this.employeeName = employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name();
        this.empDeptId = employeeManage.getDepartmentId();
        this.profetion = employeeManage.getJobDescription();
        this.departmentDescrption = employeeManage.getDepartmentDescription();
    }
    /////////////////////////////////////////////////////////////////////
    ArrayList<AvilablePermissionDataModel> avilablePermission =
            new ArrayList<AvilablePermissionDataModel>();
    ArrayList<SelectedPermissionDataModel> selectedPermission =
            new ArrayList<SelectedPermissionDataModel>();

    public ArrayList<AvilablePermissionDataModel> getAvilablePermission() {
        return avilablePermission;
    }

    public void setAvilablePermission(ArrayList<AvilablePermissionDataModel> avilablePermission) {
        this.avilablePermission = avilablePermission;
    }

    public ArrayList<SelectedPermissionDataModel> getSelectedPermission() {
        return selectedPermission;
    }

    public void setSelectedPermission(ArrayList<SelectedPermissionDataModel> selectedPermission) {
        this.selectedPermission = selectedPermission;
    }

    ////////////////////////////////////////////////////////////////////
    ArrayList<AvilableRoleDataModel> avilableRoleResource = new ArrayList<AvilableRoleDataModel>();
    ArrayList<SelectedRoleDataModel> selectedRoleResource =
            new ArrayList<SelectedRoleDataModel>();

    public ArrayList<AvilableRoleDataModel> getAvilableRoleResource() {
        return avilableRoleResource;
    }

    public void setAvilableRoleResource(ArrayList<AvilableRoleDataModel> avilableRoleResource) {
        this.avilableRoleResource = avilableRoleResource;
    }

    public ArrayList<SelectedRoleDataModel> getSelectedRoleResource() {
        return selectedRoleResource;
    }

    public void setSelectedRoleResource(ArrayList<SelectedRoleDataModel> selectedRoleResource) {
        this.selectedRoleResource = selectedRoleResource;
    }

    ////////////////////////////////////////////////////////////////////
    ArrayList<AvilableUserDataModel> avilableUserRole =
            new ArrayList<AvilableUserDataModel>();
    ArrayList<SelectedUserDataModel> selectedUserRole =
            new ArrayList<SelectedUserDataModel>();

    public ArrayList<AvilableUserDataModel> getAvilableUserRole() {
        return avilableUserRole;
    }

    public void setAvilableUserRole(ArrayList<AvilableUserDataModel> avilableUserRole) {
        this.avilableUserRole = avilableUserRole;
    }

    public ArrayList<SelectedUserDataModel> getSelectedUserRole() {
        return selectedUserRole;
    }

    public void setSelectedUserRole(ArrayList<SelectedUserDataModel> selectedUserRole) {
        this.selectedUserRole = selectedUserRole;
    }

    public void addCandidateInfo(CandidateManager candidate) {
        selectedCandidateList.add(candidate);
    }

    /**
     * @return the evaSessionOPt
     */
    public List getEvaSessionOPt() {
        return evaSessionOPt;
    }

    /**
     * @param evaSessionOPt the evaSessionOPt to set
     */
    public void setEvaSessionOPt(List evaSessionOPt) {
        this.evaSessionOPt = evaSessionOPt;
    }

    /**
     * @return the evaResultOPt
     */
    public List getEvaResultOPt() {
        return evaResultOPt;
    }

    /**
     * @param evaResultOPt the evaResultOPt to set
     */
    public void setEvaResultOPt(List evaResultOPt) {
        this.evaResultOPt = evaResultOPt;
    }

    /**
     * @return the evaSessionResultOPt
     */
    public List getEvaSessionResultOPt() {
        return evaSessionResultOPt;
    }

    /**
     * @param evaSessionResultOPt the evaSessionResultOPt to set
     */
    public void setEvaSessionResultOPt(List evaSessionResultOPt) {
        this.evaSessionResultOPt = evaSessionResultOPt;
    }

    /**
     * @return the evaCriteriaEditOPt
     */
    public List getEvaCriteriaEditOPt() {
        return evaCriteriaEditOPt;
    }

    /**
     * @param evaCriteriaEditOPt the evaCriteriaEditOPt to set
     */
    public void setEvaCriteriaEditOPt(List evaCriteriaEditOPt) {
        this.evaCriteriaEditOPt = evaCriteriaEditOPt;
    }

    public void addEvaSession(EvaluationSessionManager addEvaCriteriaToTable) {
        getEvaSessionOPt().add(addEvaCriteriaToTable);
    }

    public void addEvaSessionResult(EvaluationResultManager addEvaResultToTable) {
        getEvaResultOPt().add(addEvaResultToTable);

    }

    public void addEvaResultToTbl(EvaluationResultManager addEvaCriteriaToTable) {
        getEvaResultOPt().add(addEvaCriteriaToTable);
    }

    public void addEvaResultToTblRead(EvaluationResultManager addEvaCriteriaToTableR) {
        getEvaSessionResultOPt().add(addEvaCriteriaToTableR);
    }

    public void addEvaCriteriaEdit(EvaluationManager addEvaCriteriaEditToTable) {
        getEvaCriteriaEditOPt().add(addEvaCriteriaEditToTable);
    }

    public String getDepartmentDescrption() {
        return departmentDescrption;
    }

    public void setDepartmentDescrption(String departmentDescrption) {
        this.departmentDescrption = departmentDescrption;
    }

    /**
     * @return the initiateManager
     */
    public InitiateManager getInitiateManager() {
        return initiateManager;
    }

    /**
     * @param initiateManager the initiateManager to set
     */
    public void setInitiateManager(InitiateManager initiateManager) {
        this.initiateManager = initiateManager;
    }

    public void clearSessionParameter() {
        reportCriteria.clear();
        param.clear();
        format = null;
        fileName = null;
        reportIndex = 0;
        reportType = false;
        rs = null;
//      reportDual = null;
    }
}
