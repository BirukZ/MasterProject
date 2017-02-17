/*
 * EmployeePage.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright one
 */
package fphrms.Employee;
import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlMessage;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGrid;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.PanelTab;
import com.icesoft.faces.component.paneltabset.PanelTabSet;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.tree.Tree;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItem;
import javax.faces.component.html.HtmlCommandLink;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import com.sun.webui.jsf.model.Option;
import java.util.Iterator;
import java.util.List;
import com.icesoft.faces.component.inputfile.InputFile;
import com.icesoft.faces.component.inputfile.FileInfo;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.tree.IceUserObject;
import com.icesoft.faces.context.ByteArrayResource;
import com.icesoft.faces.context.effects.JavascriptContext;
import control.LookUpManger;
import fphrms.AutoAllCompleteDictionary;
import fphrms.EmployeeList;
import java.util.regex.Pattern;
import javax.servlet.ServletContext;
import java.text.SimpleDateFormat;
import manager.employeeManager.EmployeeManage;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.LookUpManager;
import oracle.sql.BLOB;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.TimeZone;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;

import manager.employeeManager.EducationManager;
import manager.employeeManager.LanguageManager;
import javax.faces.model.SelectItem;


import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import manager.Utility.Validater;
import manager.educationManager.EducationRequestManager;
import manager.employeeManager.ContractEmployeeManager;
import manager.employeeManager.EmployeeFileManager;
import manager.employeeManager.EmployeeTrainingManager;
import manager.fileManager.ResourceManager;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.HRValidation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import manager.organizationManager.JobTypeManager;
import manager.organizationManager.LoadTree;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.RecruitmentManager;
import oracle.jdbc.rowset.OracleSerialBlob;
import com.icesoft.faces.context.Resource;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.faces.context.ExternalContext;
//import javax.swing.JOptionPane;


/*to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EmployeePage extends AbstractPageBean {

    private InputStream inputStream;
    public static byte[] fileFromDb;
    public static boolean fromDb = true;
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> allJobs = new ArrayList<SelectItem>();
    static int DEPARRTMENT_ID = 0;
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    JobTypeManager jobTypeManager = new JobTypeManager();
    private ArrayList<SelectItem> gradingSystems = new ArrayList<SelectItem>();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String selectedEmployeedId = null;
    EmployeeList currentEmployee1 = new EmployeeList("", "0", null);
    public static String current_action = "NewEmployee";
    private EducationManager educationManager = new EducationManager();
    private ArrayList<SelectItem> locationList = new ArrayList<SelectItem>();
    private EducationRequestManager educationRequestManager = new EducationRequestManager();
    private List updateListOfEmployeeTraining = new ArrayList<EmployeeTrainingManager>();
    private List employeeFileList = new ArrayList<EmployeeFileManager>();
    private ContractEmployeeManager contratManager = new ContractEmployeeManager();
    private EmployeeFileManager employeeFileManager = new EmployeeFileManager();
    private ArrayList<SelectItem> fileType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> emplocationList = educationManager.getAllLocation();
    String familyId;
    private String fileExtenstion = "";
    String addressId = "0";
    private int filetableSize = 0;
    byte[] employeeFile = null;
    String educationId = "0";
    String languageId = "0";
    String experianceId = "0";
    public Option[] kebelleTypes = null;
    public ArrayList<SelectItem> kebeleList = null;
    String photoPath = null;
    String familyPhoto = "/Employee/images/new.JPG";
    byte[] relativePhoto = null;
    private static ArrayList<SelectItem> nationalityName = new ArrayList<SelectItem>();
    ArrayList<SelectItem> maritalstatus = new ArrayList<SelectItem>();
    ArrayList<SelectItem> nation = new ArrayList<SelectItem>();
    ArrayList<SelectItem> department = new ArrayList<SelectItem>();
    ArrayList<SelectItem> _job = new ArrayList<SelectItem>();
    public List employeeAddress = new ArrayList<EmployeeManage>();
    public List empTitleOPt = new ArrayList<EmployeeManage>();
    private List listOfEmployeeTraining = new ArrayList<EmployeeTrainingManager>();
    private ArrayList<SelectItem> instituationList = new ArrayList<SelectItem>();
    private EmployeeTrainingManager employeeTrainingManager = new EmployeeTrainingManager();
    private List employeeUpdateFileList = new ArrayList<EmployeeFileManager>();
    LookUpManager lookUpManager = new LookUpManager();
    EmployeeManage employeeManager = new EmployeeManage();
    DepartmentManage departmentManage = new DepartmentManage();
    CandidateManager candidateManager = new CandidateManager();
    boolean checkSaveExcelDate = false;
    private String realImageFilePath = "/Employee/images/sample.jpg";
    private String realImageFilePathfa = "/Employee/images/sample1.jpg";
    public String IMAGE_URL = "/resources/image-file";
    public String IMAGE_URL_FA = "/resources/image-file";
    String newNameInput = null;
    boolean rankSelect = false;
    byte[] empImage = null;
    String educationID = null;
    boolean checkCandidate = false;
    RecruitmentManager ruitmentManager = new RecruitmentManager();
    ArrayList<SelectItem> bachCode = new ArrayList<SelectItem>();
    ArrayList<SelectItem> candidateName = new ArrayList<SelectItem>();
   public String candidateID;
    int avilabelOnDb = 0;
    int avilbelOnDbEducation = 0;
    int avilbleOnDbLanguage = 0;
    int avilbleOnDbFamily = 0;
    int selectedFamilyRow = -1;
    int selectedAddressRow = -1;
    int selecteEducationRow = -1;
    int selecteLanguageRow = -1;
    int educationTypeTableSize = 0;
    int selectEducationType = -1;
    int countEducationType = 0;
    boolean excelDataPhoto = false;
    boolean excelDataPhotoFamily = false;
    int selectedExperience = -1;
    int selectedFamily = -1;
    int familyTableSize = 0;
    int adressTableSize = 0;
    int langTableSize = 0;
    int lanCounter = 0;
    private boolean downloadAvailable;
    Option[] titleTypeA;
    private ArrayList<SelectItem> sponsoredByTraining = new ArrayList<SelectItem>();
    private String trainingId = "";
    ResourceBundle messageResource = null;
    int buttonIdentifier = 0;
    int fileButtonIdentifier = 0;
    private int fileCounter = 0;
    int familybuttonIdentifier = 0;
    int addressButtonIdentifier = 0;
    int buttonIdentifierLang = 0;
    int countAdress = 0;
    int countfamily = 0;
    int counter = 0;
    int educCounter = 0;
    int popupIdentifier = 0;
    int selectedNoAttenRow = -1;
    int buttonIdentifierEduc = 0;
    int trainingButtonIdentifier = 0;
    int educTableSize = 0;
    FacesContext context = null;
    String departmentIDFromDes;
    private int trainingCounter = 0;
    private String filePath = null;
    private int trainingTablesize = 0;
    private int selectedTrainingRow = -1;
    private String contratEmployeeId;
    private String employeeContractId;
    private ArrayList<SelectItem> religionName = new ArrayList<SelectItem>();
    private LookUpManger lookUpManger = new LookUpManger();
    private String fileId;
    private int selectedFileRow = -1;
    int tableSize;
    private Resource faResource;
    List matchesList = new ArrayList<SelectItem>();
    private String selectedEmployeeId;

    public ArrayList<SelectItem> getEmplocationList() {
        return emplocationList;
    }

    public void setEmplocationList(ArrayList<SelectItem> emplocationList) {
        this.emplocationList = emplocationList;
    }

    public ArrayList<SelectItem> getLocationList() {
        return locationList;
    }

    public void setLocationList(ArrayList<SelectItem> locationList) {
        this.locationList = locationList;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

    public List getList() {
        return matchesList;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }

    public Resource getFaResource() {
        return faResource;
    }

    public void setFaResource(Resource faResource) {
        this.faResource = faResource;
    }

    public ArrayList<SelectItem> getFileType() {
        return fileType;
    }

    public void setFileType(ArrayList<SelectItem> fileType) {
        this.fileType = fileType;
    }

    public boolean isDownloadAvailable() {
        return downloadAvailable;
    }

    public void setDownloadAvailable(boolean downloadAvailable) {
        this.downloadAvailable = downloadAvailable;
    }

    public List getEmployeeUpdateFileList() {
        return employeeUpdateFileList;
    }

    public void setEmployeeUpdateFileList(List employeeUpdateFileList) {
        this.employeeUpdateFileList = employeeUpdateFileList;
    }

    public byte[] getEmployeeFile() {
        return employeeFile;
    }

    public void setEmployeeFile(byte[] employeeFile) {
        this.employeeFile = employeeFile;
    }

    public List getEmployeeFileList() {
        return employeeFileList;
    }

    public void setEmployeeFileList(List employeeFileList) {
        this.employeeFileList = employeeFileList;
    }

    public List getUpdateListOfEmployeeTraining() {
        return updateListOfEmployeeTraining;
    }

    public void setUpdateListOfEmployeeTraining(List updateListOfEmployeeTraining) {
        this.updateListOfEmployeeTraining = updateListOfEmployeeTraining;
    }

    public void setGradingSystems(ArrayList<SelectItem> gradingSystems) {
        this.gradingSystems = gradingSystems;
    }

    public ArrayList<SelectItem> getAllJobs() {
        return allJobs;
    }

    public void setAllJobs(ArrayList<SelectItem> allJobs) {
        this.allJobs = allJobs;
    }

    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public String getDepartmentIDFromDes() {
        return departmentIDFromDes;
    }

    public void setDepartmentIDFromDes(String departmentIDFromDes) {
        this.departmentIDFromDes = departmentIDFromDes;
    }

    public ArrayList<SelectItem> getSponsoredByTraining() {
        return sponsoredByTraining;
    }

    public void setSponsoredByTraining(ArrayList<SelectItem> sponsoredByTraining) {
        this.sponsoredByTraining = sponsoredByTraining;
    }

    public ArrayList<SelectItem> getInstituationList() {
        return instituationList;
    }

    public void setInstituationList(ArrayList<SelectItem> instituationList) {
        this.instituationList = instituationList;
    }

    public Option[] getTitleTypeA() {
        Option[] newTitleType = new Option[4];
        newTitleType[0] = new Option("0", "--Select Type--");
        newTitleType[1] = new Option("Both", "Both");
        newTitleType[2] = new Option("Female", "Female");
        newTitleType[3] = new Option("Male", "Male");
        return newTitleType;

    }

    public List getListOfEmployeeTraining() {
        return listOfEmployeeTraining;
    }

    public void setListOfEmployeeTraining(List listOfEmployeeTraining) {
        this.listOfEmployeeTraining = listOfEmployeeTraining;
    }

    public void setTitleTypeA(Option[] titleTypeA) {

        this.titleTypeA = titleTypeA;
    }
    // public List familyInformation = new ArrayList<EmployeeManage>();
    public ArrayList<EmployeeManage> familyInformation = new ArrayList<EmployeeManage>();
    public ArrayList<EducationManager> listOfEducationUpdate = new ArrayList<EducationManager>();
    private HtmlCommandButton btnSaveNewInstiutationType = new HtmlCommandButton();
    private HtmlCommandButton btnSaveNewILocationType = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveNewILocationType() {
        return btnSaveNewILocationType;
    }

    public void setBtnSaveNewILocationType(HtmlCommandButton btnSaveNewILocationType) {
        this.btnSaveNewILocationType = btnSaveNewILocationType;
    }

    public HtmlCommandButton getBtnSaveNewInstiutationType() {
        return btnSaveNewInstiutationType;
    }

    public void setBtnSaveNewInstiutationType(HtmlCommandButton btnSaveNewInstiutationType) {
        this.btnSaveNewInstiutationType = btnSaveNewInstiutationType;
    }

    public ArrayList<EducationManager> getListOfEducationUpdate() {
        return listOfEducationUpdate;
    }

    public void setListOfEducationUpdate(ArrayList<EducationManager> listOfEducationUpdate) {
        this.listOfEducationUpdate = listOfEducationUpdate;
    }
    public List listOfEducationType = new ArrayList<EducationManager>();

    public List getListOfEducationType() {
        return listOfEducationType;
    }

    public void setListOfEducationType(List listOfEducationType) {
        this.listOfEducationType = listOfEducationType;
    }
    public ArrayList<EducationManager> listOfEducation = new ArrayList<EducationManager>();

    public ArrayList<EducationManager> getListOfEducation() {
        return listOfEducation;
    }

    public void setListOfEducation(ArrayList<EducationManager> listOfEducation) {
        this.listOfEducation = listOfEducation;
    }
    public List familyInfoUpdate = new ArrayList<EmployeeManage>();
    public List listOfLanguageUpdate = new ArrayList<LanguageManager>();

    public List getListOfLanguageUpdate() {
        return listOfLanguageUpdate;
    }

    public void setListOfLanguageUpdate(List listOfLanguageUpdate) {
        this.listOfLanguageUpdate = listOfLanguageUpdate;
    }
    public List listOfLanguage = new ArrayList<LanguageManager>();

    public List getListOfLanguage() {
        return listOfLanguage;
    }

    public void setListOfLanguage(List listOfLanguage) {
        this.listOfLanguage = listOfLanguage;
    }

    public List getFamilyInfoUpdate() {
        return familyInfoUpdate;
    }

    public void setFamilyInfoUpdate(List familyInfoUpdate) {
        this.familyInfoUpdate = familyInfoUpdate;
    }

    public SelectInputDate getTxtDateOfBirth() {
        return txtDateOfBirth;
    }

    public void setContext(FacesContext context) {
        this.context = context;
    }

    public ArrayList<EmployeeManage> getFamilyInformation() {
        return familyInformation;
    }

    public void setFamilyInformation(ArrayList<EmployeeManage> familyInformation) {
        this.familyInformation = familyInformation;
    }

    public String getNewOrEdit() {
        return newOrEdit;
    }

    public void setNewOrEdit(String newOrEdit) {
        this.newOrEdit = newOrEdit;
    }

    public static int getNew_inserted() {
        return new_inserted;
    }

    public static void setNew_inserted(int new_inserted) {
        EmployeePage.new_inserted = new_inserted;
    }

    public static int getNew_removed() {
        return new_removed;
    }

    public static void setNew_removed(int new_removed) {
        EmployeePage.new_removed = new_removed;
    }

    public static int getOld_deleted() {
        return old_deleted;
    }

    public static void setOld_deleted(int old_deleted) {
        EmployeePage.old_deleted = old_deleted;
    }

    public static int getOld_edited() {
        return old_edited;
    }

    public static void setOld_edited(int old_edited) {
        EmployeePage.old_edited = old_edited;
    }

    public static int getOld_not_cahanged() {
        return old_not_cahanged;
    }

    public static void setOld_not_cahanged(int old_not_cahanged) {
        EmployeePage.old_not_cahanged = old_not_cahanged;
    }
    public List listOfExpUpdate = new ArrayList<EmployeeManage>();

    public List getListOfExpUpdate() {
        return listOfExpUpdate;
    }

    public void setListOfExpUpdate(List listOfExpUpdate) {
        this.listOfExpUpdate = listOfExpUpdate;
    }

    public LookUpManager getLookUpManager() {
        return lookUpManager;
    }

    public void setLookUpManager(LookUpManager lookUpManager) {
        this.lookUpManager = lookUpManager;
    }
    public List listOfExperience = new ArrayList<EmployeeManage>();

    public List getListOfExperience() {
        return listOfExperience;
    }

    public void setListOfExperience(List listOfExperience) {
        this.listOfExperience = listOfExperience;
    }
    ArrayList<SelectItem> readDataFromExcel = new ArrayList<SelectItem>();
    ArrayList<SelectItem> zoneList = new ArrayList<SelectItem>();
    private HtmlOutputLabel lblEducFullName = new HtmlOutputLabel();
    private HtmlOutputLabel lblLanguageFullName = new HtmlOutputLabel();
    private HtmlOutputLabel lblAddressTypeFullName = new HtmlOutputLabel();
    private HtmlOutputLabel lblExpreienceFullName = new HtmlOutputLabel();
    private HtmlOutputLabel lblForFamilyFullName = new HtmlOutputLabel();

    public HtmlOutputLabel getLblForFamilyFullName() {
        return lblForFamilyFullName;
    }

    public void setLblForFamilyFullName(HtmlOutputLabel lblForFamilyFullName) {
        this.lblForFamilyFullName = lblForFamilyFullName;
    }

    public HtmlOutputLabel getLblExpreienceFullName() {
        return lblExpreienceFullName;
    }

    public void setLblExpreienceFullName(HtmlOutputLabel lblExpreienceFullName) {
        this.lblExpreienceFullName = lblExpreienceFullName;
    }

    public HtmlOutputLabel getLblAddressTypeFullName() {
        return lblAddressTypeFullName;
    }

    public void setLblAddressTypeFullName(HtmlOutputLabel lblAddressTypeFullName) {
        this.lblAddressTypeFullName = lblAddressTypeFullName;
    }

    public int getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(int databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public ArrayList<SelectItem> getZoneList() {
        return zoneList;
    }

    public void setZoneList(ArrayList<SelectItem> zoneList) {
        this.zoneList = zoneList;
    }

    public HtmlOutputLabel getLblEducFullName() {
        return lblEducFullName;
    }

    public void setLblEducFullName(HtmlOutputLabel lblEducFullName) {
        this.lblEducFullName = lblEducFullName;
    }

    public HtmlOutputLabel getLblLanguageFullName() {
        return lblLanguageFullName;
    }

    public void setLblLanguageFullName(HtmlOutputLabel lblLanguageFullName) {
        this.lblLanguageFullName = lblLanguageFullName;
    }

    public ArrayList<SelectItem> getReadDataFromExcel() {
        return employeeManager.readDataFromExcel();
    }

    public void setReadDataFromExcel(ArrayList<SelectItem> readDataFromExcel) {
        this.readDataFromExcel = readDataFromExcel;
    }

    public int getAvilbleOnDbFamily() {
        return avilbleOnDbFamily;
    }

    public void setAvilbleOnDbFamily(int avilbleOnDbFamily) {
        this.avilbleOnDbFamily = avilbleOnDbFamily;
    }

    public int getAvilabelOnDb() {
        return avilabelOnDb;
    }

    public void setAvilabelOnDb(int avilabelOnDb) {
        this.avilabelOnDb = avilabelOnDb;
    }

    public String getCandidateID() {
        return candidateID;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public ArrayList<SelectItem> getCandidateName() {
        return candidateName;
    }

    public void setCandidateName(ArrayList<SelectItem> candidateName) {
        this.candidateName = candidateName;
    }

    public ArrayList<SelectItem> getBachCode() {
        return bachCode;
    }

    public void setBachCode(ArrayList<SelectItem> bachCode) {
        this.bachCode = bachCode;
    }

    public byte[] getEmpImage() {
        return empImage;
    }

    public void setEmpImage(byte[] empImage) {
        this.empImage = empImage;
    }

    public List getEmpTitleOPt() {
        return empTitleOPt;
    }

    public void setEmpTitleOPt(List empTitleOPt) {
        this.empTitleOPt = empTitleOPt;
    }

    public List getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(List employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public List getEmployeeAdressUpdate() {
        return employeeAdressUpdate;
    }

    public void setEmployeeAdressUpdate(List employeeAdressUpdate) {
        this.employeeAdressUpdate = employeeAdressUpdate;
    }
    public List employeeAdressUpdate = new ArrayList<EmployeeManage>();

    public ArrayList<SelectItem> get_job() {
        return _job;
    }

    public void set_job(ArrayList<SelectItem> _job) {
        this._job = _job;
    }
    ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    ArrayList<SelectItem> devision = new ArrayList<SelectItem>();
    ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    ArrayList<SelectItem> team = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<SelectItem> team) {
        this.team = team;
    }

    public ArrayList<SelectItem> getDirectorate() {
        return directorate;
    }

    public void setDirectorate(ArrayList<SelectItem> directorate) {
        this.directorate = directorate;
    }

    public ArrayList<SelectItem> getMastebaberi() {
        return mastebaberi;
    }

    public void setMastebaberi(ArrayList<SelectItem> mastebaberi) {
        this.mastebaberi = mastebaberi;
    }
    ArrayList<SelectItem> mastebaberi = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getDevision() {
        return devision;
    }

    public void setDevision(ArrayList<SelectItem> devision) {
        this.devision = devision;
    }

    public ArrayList<SelectItem> getZerf() {
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }
    ArrayList<SelectItem> _jobRank = new ArrayList<SelectItem>();
    ArrayList<SelectItem> payGradeOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> _title = new ArrayList<SelectItem>();
    ArrayList<SelectItem> __reationType = new ArrayList<SelectItem>();
    ArrayList<SelectItem> _addressTypeList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> regionOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> woredaList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> educLevelOpt = lookUpManager.readEducationLevel();/* new ArrayList<SelectItem>();*/

    ArrayList<SelectItem> educTypeOpt/* = new ArrayList<SelectItem>();
            seteducTypeOpt*/ = lookUpManager.readEducationTypes();
    ArrayList<SelectItem> languageOpt = new ArrayList<SelectItem>();
    ArrayList<SelectItem> measurementOpt = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getMeasurementOpt() {
        return lookUpManager.readMeasurement();
    }

    public void setMeasurementOpt(ArrayList<SelectItem> measurementOpt) {
        this.measurementOpt = measurementOpt;
    }

    public ArrayList<SelectItem> getLanguageOpt() {
        return lookUpManager.readLanguageType();
    }

    public void setLanguageOpt(ArrayList<SelectItem> languageOpt) {
        this.languageOpt = languageOpt;
    }

    public ArrayList<SelectItem> getGradingSystems() {
        return lookUpManager.getAllGradingSystems();
    }

    public ArrayList<SelectItem> getEducTypeOpt() {
        return educTypeOpt;
    }

    public ArrayList<SelectItem> getAllEducationCatagories() {
        return lookUpManager.readAllEducationCatagories();
    }

    public void setEducTypeOpt(ArrayList<SelectItem> educTypeOpt) {
        this.educTypeOpt = educTypeOpt;
    }

    public ArrayList<SelectItem> getEducLevelOpt() {
//        if (drlEducationCatagories.getValue() == null) {
//            educTypeOpt = lookUpManager.readEducationLevel();
//        } else {
//            educTypeOpt = lookUpManager.readEducationByCategoryForJob(drlEducationCatagories.getValue().toString());
//        }
//        educTypeOpt = lookUpManager.readEducationLevel();
        return educLevelOpt;
    }

    public void setEducLevelOpt(ArrayList<SelectItem> educLevelOpt) {
        this.educLevelOpt = educLevelOpt;
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

    public ArrayList<SelectItem> get_addressTypeList() {
        return employeeManager.assignAddressType();
    }

    public void set_addressTypeList(ArrayList<SelectItem> _addressTypeList) {
        this._addressTypeList = _addressTypeList;
    }

    public ArrayList<SelectItem> get__reationType() {
        return employeeManager.assignRelationType();
    }

    public void set__reationType(ArrayList<SelectItem> __reationType) {
        this.__reationType = __reationType;
    }

    public ArrayList<SelectItem> get_title() {
        return _title;
    }

    public void set_title(ArrayList<SelectItem> _title) {
        this._title = _title;
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

    private void validateNumber(FacesContext context, UIComponent component, Object value) {
        try {
            String patternNumber = "^?[0-9]+(\\.[0-9]+)?$";//"^\\d+$+,+.";
            boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (value.toString()));
            if (matchStringText == false) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("salaryValidate"));
            }
        } catch (Exception ex) {
        }
    }

    private void validateDate(FacesContext context, UIComponent component, Object value) {
        try {
            String datePatern = "(19[0-9]{2}|20[0-9]{2})\\-(0[1-9]|1[0-3])\\-(0[1-9]|[1-2][0-9]|30)";
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            if (!Pattern.matches(datePatern, value.toString().subSequence(0, value.toString().length()))) {
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("dateValidate"));
            }
            if (value.toString().split("-")[1].equalsIgnoreCase("13")) {
                int year = Integer.parseInt(value.toString().split("-")[0]);
                int day = Integer.parseInt(value.toString().split("-")[2]);
                if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                    if (day > 6) {
                        ((UIInput) component).setValid(false);
                        error(component, messageResource.getString("dateValidate"));
                    }
                } else if (day > 5) {
                    ((UIInput) component).setValid(false);
                    error(component, messageResource.getString("dateValidate"));
                }

            }
        } catch (Exception ex) {
        }
    }

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

    public ArrayList<SelectItem> getPayGradeOpt() {
        return payGradeOpt;
    }

    public void setPayGradeOpt(ArrayList<SelectItem> payGradeOpt) {
        this.payGradeOpt = payGradeOpt;
    }

    public ArrayList<SelectItem> get_jobRank() {
        return _jobRank;
    }

    public void set_jobRank(ArrayList<SelectItem> _jobRank) {
        this._jobRank = _jobRank;
    }

    public ArrayList<SelectItem> getDepartment() {
        return departmentManage.getDepartmentName();
    }

    public void setDepartment(ArrayList<SelectItem> department) {
        this.department = department;
    }

    public ArrayList<SelectItem> getNation() {
        return nation;
    }

    public void setNation(ArrayList<SelectItem> nation) {
        this.nation = nation;
    }

    public ArrayList<SelectItem> getMaritalstatus() {
        return lookUpManager.assignMaritalStatus();
    }

    public void setMaritalstatus(ArrayList<SelectItem> maritalstatus) {
        this.maritalstatus = maritalstatus;
    }

    public ArrayList<SelectItem> getNationalityName() {
        return nationalityName;
    }

    public ArrayList<SelectItem> getReligionName() {
        return religionName;
    }

    public void setReligionName(ArrayList<SelectItem> religionName) {
        this.religionName = religionName;
    }

    public void setNationalityName(ArrayList<SelectItem> nationalityName) {
        this.nationalityName = nationalityName;
    }

    public String getLanguageId() {
        return languageId;
    }

    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getNewNameInput() {
        return newNameInput;
    }

    public void setNewNameInput(String newNameInput) {
        this.newNameInput = newNameInput;
    }

    public String getIMAGE_URL() {
        return IMAGE_URL;
    }

    public void setIMAGE_URL(String IMAGE_URL) {
        this.IMAGE_URL = IMAGE_URL;
    }

    public byte[] getRelativePhoto() {
        return relativePhoto;
    }

    public void setRelativePhoto(byte[] relativePhoto) {
        this.relativePhoto = relativePhoto;
    }

    public String getFamilyPhoto() {
        return familyPhoto;
    }

    public void setFamilyPhoto(String familyPhoto) {
        this.familyPhoto = familyPhoto;
    }

    public String getPhotoName() {
        return photoName;
    }

    public void setPhotoName(String photoName) {
        this.photoName = photoName;
    }

    public String getPhotoPath() {
        return photoPath;
    }

    public void setPhotoPath(String photoPath) {
        this.photoPath = photoPath;
    }
    String photoName;

    public ArrayList<SelectItem> getOptKebele() {
        return kebeleList;
    }

    public void setOptKebele(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
    }

    public Option[] getKebelleTypes() {
        return kebelleTypes;
    }

    public void setKebelleTypes(Option[] kebelleTypes) {
        this.kebelleTypes = kebelleTypes;
    }
    public boolean sexSelect = true;

    public boolean getSexSelect() {
        return sexSelect;
    }

    public void setSexSelect(boolean sexSelect) {
        this.sexSelect = sexSelect;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext ec = context.getExternalContext();
        faResource = new ResourceManager(ec, "resourceName");
        setDownloadAvailable(false);
        defaultSelectedDataSexFemale.setSelectedBoolean(false);
        defaultSelectedDataSexMale.setSelectedBoolean(false);
        dateFormat.setTimeZone(TimeZone.getTimeZone("GMT"));
        setInstituationList(educationRequestManager.getNAmeOfInstitution());
        setSponsoredByTraining(employeeTrainingManager.getListOfSponsored());
        setAllJobs(jobTypeManager.getAllJobTypesSelectItem());
        setBachCode(ruitmentManager.readBachCodeForEmployeement());
        setLocationList(employeeManager.getListLocation());

        drlTitle.setValue(employeeManager.getEmpTitle());
       
        panelCollapsible1.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                panelCollapsible1_processAction(ae);
            }
        });
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
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
    private SelectInputDateBean selectInputDateDateOfBirthBean = new SelectInputDateBean();
     private SelectInputDateBean selectInputDateOfContractStartDateBean = new SelectInputDateBean();
     private SelectInputDateBean selectInputDateOfContractEndDateBean = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateHireDateBean = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateDateOfEducStartDateBean = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateDateOfEducEndDateBean = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateDateOfExpStartDateBean = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateDateOfExpEndDateBean = new SelectInputDateBean();

    public static String getCurrent_action() {
        return current_action;
    }

    public static void setCurrent_action(String current_action) {
        EmployeePage.current_action = current_action;
    }

    public String getDataIsOnEditAddress() {
        return dataIsOnEditAddress;
    }

    public void setDataIsOnEditAddress(String dataIsOnEditAddress) {
        this.dataIsOnEditAddress = dataIsOnEditAddress;
    }

    public String getDataIsOnEditEducation() {
        return dataIsOnEditEducation;
    }

    public void setDataIsOnEditEducation(String dataIsOnEditEducation) {
        this.dataIsOnEditEducation = dataIsOnEditEducation;
    }

    public String getDataIsOnEditExperience() {
        return dataIsOnEditExperience;
    }

    public void setDataIsOnEditExperience(String dataIsOnEditExperience) {
        this.dataIsOnEditExperience = dataIsOnEditExperience;
    }

    public String getDataIsOnEditFamily() {
        return dataIsOnEditFamily;
    }

    public void setDataIsOnEditFamily(String dataIsOnEditFamily) {
        this.dataIsOnEditFamily = dataIsOnEditFamily;
    }

    public String getDataIsOnEditLanguage() {
        return dataIsOnEditLanguage;
    }

    public void setDataIsOnEditLanguage(String dataIsOnEditLanguage) {
        this.dataIsOnEditLanguage = dataIsOnEditLanguage;
    }

    public ArrayList<SelectItem> getKebeleList() {
        return kebeleList;
    }

    public void setKebeleList(ArrayList<SelectItem> kebeleList) {
        this.kebeleList = kebeleList;
    }

    public SelectInputDateBean getSelectInputDateDateOfEducEndDateBean() {
        return selectInputDateDateOfEducEndDateBean;
    }

    public void setSelectInputDateDateOfEducEndDateBean(SelectInputDateBean selectInputDateDateOfEducEndDateBean) {
        this.selectInputDateDateOfEducEndDateBean = selectInputDateDateOfEducEndDateBean;
    }

    public SelectInputDateBean getSelectInputDateDateOfEducStartDateBean() {
        return selectInputDateDateOfEducStartDateBean;
    }

    public void setSelectInputDateDateOfEducStartDateBean(SelectInputDateBean selectInputDateDateOfEducStartDateBean) {
        this.selectInputDateDateOfEducStartDateBean = selectInputDateDateOfEducStartDateBean;
    }

    public SelectInputDateBean getSelectInputDateDateOfExpEndDateBean() {
        return selectInputDateDateOfExpEndDateBean;
    }

    public void setSelectInputDateDateOfExpEndDateBean(SelectInputDateBean selectInputDateDateOfExpEndDateBean) {
        this.selectInputDateDateOfExpEndDateBean = selectInputDateDateOfExpEndDateBean;
    }

    public SelectInputDateBean getSelectInputDateDateOfExpStartDateBean() {
        return selectInputDateDateOfExpStartDateBean;
    }

    public void setSelectInputDateDateOfExpStartDateBean(SelectInputDateBean selectInputDateDateOfExpStartDateBean) {
        this.selectInputDateDateOfExpStartDateBean = selectInputDateDateOfExpStartDateBean;
    }

    public static int getDEPARRTMENT_ID() {
        return DEPARRTMENT_ID;
    }

    public static void setDEPARRTMENT_ID(int DEPARRTMENT_ID) {
        EmployeePage.DEPARRTMENT_ID = DEPARRTMENT_ID;
    }

    public String getIMAGE_URL_FA() {
        return IMAGE_URL_FA;
    }

    public void setIMAGE_URL_FA(String IMAGE_URL_FA) {
        this.IMAGE_URL_FA = IMAGE_URL_FA;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public int getAddressButtonIdentifier() {
        return addressButtonIdentifier;
    }

    public void setAddressButtonIdentifier(int addressButtonIdentifier) {
        this.addressButtonIdentifier = addressButtonIdentifier;
    }

    public int getAdressTableSize() {
        return adressTableSize;
    }

    public void setAdressTableSize(int adressTableSize) {
        this.adressTableSize = adressTableSize;
    }

    public int getAvilbelOnDbEducation() {
        return avilbelOnDbEducation;
    }

    public void setAvilbelOnDbEducation(int avilbelOnDbEducation) {
        this.avilbelOnDbEducation = avilbelOnDbEducation;
    }

    public int getAvilbleOnDbLanguage() {
        return avilbleOnDbLanguage;
    }

    public void setAvilbleOnDbLanguage(int avilbleOnDbLanguage) {
        this.avilbleOnDbLanguage = avilbleOnDbLanguage;
    }

    public HtmlCommandButton getBtnEdit1Address() {
        return btnEdit1Address;
    }

    public void setBtnEdit1Address(HtmlCommandButton btnEdit1Address) {
        this.btnEdit1Address = btnEdit1Address;
    }

    public int getButtonIdentifier() {
        return buttonIdentifier;
    }

    public void setButtonIdentifier(int buttonIdentifier) {
        this.buttonIdentifier = buttonIdentifier;
    }

    public int getButtonIdentifierEduc() {
        return buttonIdentifierEduc;
    }

    public void setButtonIdentifierEduc(int buttonIdentifierEduc) {
        this.buttonIdentifierEduc = buttonIdentifierEduc;
    }

    public int getButtonIdentifierLang() {
        return buttonIdentifierLang;
    }

    public void setButtonIdentifierLang(int buttonIdentifierLang) {
        this.buttonIdentifierLang = buttonIdentifierLang;
    }

    public CandidateManager getCandidateManager() {
        return candidateManager;
    }

    public void setCandidateManager(CandidateManager candidateManager) {
        this.candidateManager = candidateManager;
    }

    public boolean isCheckCandidate() {
        return checkCandidate;
    }

    public void setCheckCandidate(boolean checkCandidate) {
        this.checkCandidate = checkCandidate;
    }

    public boolean isCheckSaveExcelDate() {
        return checkSaveExcelDate;
    }

    public void setCheckSaveExcelDate(boolean checkSaveExcelDate) {
        this.checkSaveExcelDate = checkSaveExcelDate;
    }

    public int getCountAdress() {
        return countAdress;
    }

    public void setCountAdress(int countAdress) {
        this.countAdress = countAdress;
    }

    public int getCountEducationType() {
        return countEducationType;
    }

    public void setCountEducationType(int countEducationType) {
        this.countEducationType = countEducationType;
    }

    public int getCountTitle() {
        return countTitle;
    }

    public void setCountTitle(int countTitle) {
        this.countTitle = countTitle;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public int getCountfamily() {
        return countfamily;
    }

    public void setCountfamily(int countfamily) {
        this.countfamily = countfamily;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public int getEducCounter() {
        return educCounter;
    }

    public void setEducCounter(int educCounter) {
        this.educCounter = educCounter;
    }

    public int getEducTableSize() {
        return educTableSize;
    }

    public void setEducTableSize(int educTableSize) {
        this.educTableSize = educTableSize;
    }

    public String getEducationID() {
        return educationID;
    }

    public void setEducationID(String educationID) {
        this.educationID = educationID;
    }

    public String getEducationId() {
        return educationId;
    }

    public void setEducationId(String educationId) {
        this.educationId = educationId;
    }

    public EducationManager getEducationManager() {
        return educationManager;
    }

    public void setEducationManager(EducationManager educationManager) {
        this.educationManager = educationManager;
    }

    public int getEducationTypeTableSize() {
        return educationTypeTableSize;
    }

    public void setEducationTypeTableSize(int educationTypeTableSize) {
        this.educationTypeTableSize = educationTypeTableSize;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public boolean isExcelDataPhoto() {
        return excelDataPhoto;
    }

    public void setExcelDataPhoto(boolean excelDataPhoto) {
        this.excelDataPhoto = excelDataPhoto;
    }

    public boolean isExcelDataPhotoFamily() {
        return excelDataPhotoFamily;
    }

    public void setExcelDataPhotoFamily(boolean excelDataPhotoFamily) {
        this.excelDataPhotoFamily = excelDataPhotoFamily;
    }

    public String getExperianceId() {
        return experianceId;
    }

    public void setExperianceId(String experianceId) {
        this.experianceId = experianceId;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public int getFamilyTableSize() {
        return familyTableSize;
    }

    public void setFamilyTableSize(int familyTableSize) {
        this.familyTableSize = familyTableSize;
    }

    public int getFamilybuttonIdentifier() {
        return familybuttonIdentifier;
    }

    public void setFamilybuttonIdentifier(int familybuttonIdentifier) {
        this.familybuttonIdentifier = familybuttonIdentifier;
    }

    public int getLanCounter() {
        return lanCounter;
    }

    public void setLanCounter(int lanCounter) {
        this.lanCounter = lanCounter;
    }

    public int getLangTableSize() {
        return langTableSize;
    }

    public void setLangTableSize(int langTableSize) {
        this.langTableSize = langTableSize;
    }

    public LanguageManager getLanguageManager() {
        return languageManager;
    }

    public void setLanguageManager(LanguageManager languageManager) {
        this.languageManager = languageManager;
    }

    public ResourceBundle getMessageResource() {
        return messageResource;
    }

    public void setMessageResource(ResourceBundle messageResource) {
        this.messageResource = messageResource;
    }

    public int getPopupIdentifier() {
        return popupIdentifier;
    }

    public void setPopupIdentifier(int popupIdentifier) {
        this.popupIdentifier = popupIdentifier;
    }

    public boolean isRankSelect() {
        return rankSelect;
    }

    public void setRankSelect(boolean rankSelect) {
        this.rankSelect = rankSelect;
    }

    public String getRealImageFilePath() {
        return realImageFilePath;
    }

    public void setRealImageFilePath(String realImageFilePath) {
        this.realImageFilePath = realImageFilePath;
    }

    public String getRealImageFilePathfa() {
        return realImageFilePathfa;
    }

    public void setRealImageFilePathfa(String realImageFilePathfa) {
        this.realImageFilePathfa = realImageFilePathfa;
    }

    public RecruitmentManager getRuitmentManager() {
        return ruitmentManager;
    }

    public void setRuitmentManager(RecruitmentManager ruitmentManager) {
        this.ruitmentManager = ruitmentManager;
    }

    public int getSelectEducationType() {
        return selectEducationType;
    }

    public void setSelectEducationType(int selectEducationType) {
        this.selectEducationType = selectEducationType;
    }

    public SelectInputDateBean getSelectInputDateOfContractEndDateBean() {
        return selectInputDateOfContractEndDateBean;
    }

    public void setSelectInputDateOfContractEndDateBean(SelectInputDateBean selectInputDateOfContractEndDateBean) {
        this.selectInputDateOfContractEndDateBean = selectInputDateOfContractEndDateBean;
    }

    public SelectInputDateBean getSelectInputDateOfContractStartDateBean() {
        return selectInputDateOfContractStartDateBean;
    }

    public void setSelectInputDateOfContractStartDateBean(SelectInputDateBean selectInputDateOfContractStartDateBean) {
        this.selectInputDateOfContractStartDateBean = selectInputDateOfContractStartDateBean;
    }

    public SelectInputDateBean getSelectInputDateDateOfBirthBean() {
        return selectInputDateDateOfBirthBean;
    }

    public void setSelectInputDateDateOfBirthBean(SelectInputDateBean selectInputDateDateOfBirthBean) {
        this.selectInputDateDateOfBirthBean = selectInputDateDateOfBirthBean;
    }

    public SelectInputDateBean getSelectInputDateHireDateBean() {
        return selectInputDateHireDateBean;
    }

    public void setSelectInputDateHireDateBean(SelectInputDateBean selectInputDateHireDateBean) {
        this.selectInputDateHireDateBean = selectInputDateHireDateBean;
    }

    public int getSelecteEducationRow() {
        return selecteEducationRow;
    }

    public void setSelecteEducationRow(int selecteEducationRow) {
        this.selecteEducationRow = selecteEducationRow;
    }

    public int getSelecteLanguageRow() {
        return selecteLanguageRow;
    }

    public void setSelecteLanguageRow(int selecteLanguageRow) {
        this.selecteLanguageRow = selecteLanguageRow;
    }

    public int getSelectedAddressRow() {
        return selectedAddressRow;
    }

    public void setSelectedAddressRow(int selectedAddressRow) {
        this.selectedAddressRow = selectedAddressRow;
    }

    public int getSelectedExperience() {
        return selectedExperience;
    }

    public void setSelectedExperience(int selectedExperience) {
        this.selectedExperience = selectedExperience;
    }

    public int getSelectedFamily() {
        return selectedFamily;
    }

    public void setSelectedFamily(int selectedFamily) {
        this.selectedFamily = selectedFamily;
    }

    public int getSelectedFamilyRow() {
        return selectedFamilyRow;
    }

    public void setSelectedFamilyRow(int selectedFamilyRow) {
        this.selectedFamilyRow = selectedFamilyRow;
    }

    public int getSelectedNoAttenRow() {
        return selectedNoAttenRow;
    }

    public void setSelectedNoAttenRow(int selectedNoAttenRow) {
        this.selectedNoAttenRow = selectedNoAttenRow;
    }

    public int getTableSize() {
        return tableSize;
    }

    public void setTableSize(int tableSize) {
        this.tableSize = tableSize;
    }

    public int getTitleTableSize() {
        return titleTableSize;
    }

    public void setTitleTableSize(int titleTableSize) {
        this.titleTableSize = titleTableSize;
    }

    public void setSelectOneMenu2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems3 = dsia;
    }
    private HtmlSelectOneMenu drlNation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNation() {
        return drlNation;
    }

    public void setDrlNation(HtmlSelectOneMenu hsom) {
        this.drlNation = hsom;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private HtmlInputText txtFEmployeeId = new HtmlInputText();

    public HtmlInputText getTxtFEmployeeId() {
        return txtFEmployeeId;
    }

    public void setTxtFEmployeeId(HtmlInputText hit) {
        this.txtFEmployeeId = hit;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems4() {
        return selectOneMenu2DefaultItems4;
    }

    public void setSelectOneMenu2DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems5() {
        return selectOneMenu2DefaultItems5;
    }

    public void setSelectOneMenu2DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems6() {
        return selectOneMenu2DefaultItems6;
    }

    public void setSelectOneMenu2DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems6 = dsia;
    }
    private DefaultSelectedData defaultSelectedData15 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData15() {
        return defaultSelectedData15;
    }

    public void setDefaultSelectedData15(DefaultSelectedData dsd) {
        this.defaultSelectedData15 = dsd;
    }
    private HtmlSelectOneMenu drlTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTitle() {
        return drlTitle;
    }

    public void setDrlTitle(HtmlSelectOneMenu hsom) {
        this.drlTitle = hsom;
    }
    private DefaultSelectedData defaultSelectedData16 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData16() {
        return defaultSelectedData16;
    }

    public void setDefaultSelectedData16(DefaultSelectedData dsd) {
        this.defaultSelectedData16 = dsd;
    }
    private HtmlInputText txtFirstName = new HtmlInputText();

    public HtmlInputText getTxtFirstName() {
        return txtFirstName;
    }

    public void setTxtFirstName(HtmlInputText hit) {
        this.txtFirstName = hit;
    }
    private HtmlInputText txtMidelName = new HtmlInputText();

    public HtmlInputText getTxtMidelName() {
        return txtMidelName;
    }

    public void setTxtMidelName(HtmlInputText hit) {
        this.txtMidelName = hit;
    }
    private HtmlInputText txtLastName = new HtmlInputText();

    public HtmlInputText getTxtLastName() {
        return txtLastName;
    }

    public void setTxtLastName(HtmlInputText hit) {
        this.txtLastName = hit;
    }
    private HtmlSelectOneMenu drlJobCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlJobCode() {
        return drlJobCode;
    }

    public void setDrlJobCode(HtmlSelectOneMenu hsom) {
        this.drlJobCode = hsom;
    }
    private HtmlInputText txtSalary = new HtmlInputText();

    public HtmlInputText getTxtSalary() {
        return txtSalary;
    }

    public void setTxtSalary(HtmlInputText hit) {
        this.txtSalary = hit;
    }
    private DefaultSelectedData defaultSelectedData17 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData17() {
        return defaultSelectedData17;
    }

    public void setDefaultSelectedData17(DefaultSelectedData dsd) {
        this.defaultSelectedData17 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems7() {
        return selectOneMenu2DefaultItems7;
    }

    public void setSelectOneMenu2DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems8() {
        return selectOneMenu2DefaultItems8;
    }

    public void setSelectOneMenu2DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems9() {
        return selectOneMenu2DefaultItems9;
    }

    public void setSelectOneMenu2DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems9 = dsia;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private DefaultSelectedData defaultSelectedData19 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData19() {
        return defaultSelectedData19;
    }

    public void setDefaultSelectedData19(DefaultSelectedData dsd) {
        this.defaultSelectedData19 = dsd;
    }
    private HtmlInputText txtFamilyFirstName = new HtmlInputText();

    public HtmlInputText getTxtFamilyFirstName() {
        return txtFamilyFirstName;
    }

    public void setTxtFamilyFirstName(HtmlInputText hit) {
        this.txtFamilyFirstName = hit;
    }
    private HtmlSelectOneMenu drlRelationType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRelationType() {
        return drlRelationType;
    }

    public void setDrlRelationType(HtmlSelectOneMenu hsom) {
        this.drlRelationType = hsom;
    }
    private HtmlInputText txtFamilyMiddleName = new HtmlInputText();

    public HtmlInputText getTxtFamilyMiddleName() {
        return txtFamilyMiddleName;
    }

    public void setTxtFamilyMiddleName(HtmlInputText hit) {
        this.txtFamilyMiddleName = hit;
    }
    private HtmlInputText txtFamilyLastName = new HtmlInputText();

    public HtmlInputText getTxtFamilyLastName() {
        return txtFamilyLastName;
    }

    public void setTxtFamilyLastName(HtmlInputText hit) {
        this.txtFamilyLastName = hit;

    }
    static int new_inserted = 0;
    static int new_removed = 1;
    static int old_not_cahanged = 2;
    static int old_edited = 3;
    static int old_deleted = 4;
    private HtmlSelectBooleanCheckbox cobHeir = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCobHeir() {
        return cobHeir;
    }

    public void setCobHeir(HtmlSelectBooleanCheckbox hsbc) {
        this.cobHeir = hsbc;
    }
    private HtmlSelectBooleanCheckbox choEmergenceyContact = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoEmergenceyContact() {
        return choEmergenceyContact;
    }

    public void setChoEmergenceyContact(HtmlSelectBooleanCheckbox hsbc) {
        this.choEmergenceyContact = hsbc;
    }
    private PanelLayout lyFamilyName = new PanelLayout();

    public PanelLayout getLyFamilyName() {
        return lyFamilyName;
    }

    public void setLyFamilyName(PanelLayout pl) {
        this.lyFamilyName = pl;
    }
    private HtmlCommandLink linkEdit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEdit() {
        return linkEdit;
    }

    public void setLinkEdit(HtmlCommandLink hcl) {
        this.linkEdit = hcl;
    }
    private HtmlPanelGrid tblFamily = new HtmlPanelGrid();

    public HtmlPanelGrid getTblFamily() {
        return tblFamily;
    }

    public void setTblFamily(HtmlPanelGrid hpg) {
        this.tblFamily = hpg;
    }
    private HtmlDataTable dataTable = new HtmlDataTable();

    public HtmlDataTable getDataTable() {
        return dataTable;
    }

    public void setDataTable(HtmlDataTable hdt) {
        this.dataTable = hdt;
    }
    private HtmlSelectOneRadio optsex = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getOptsex() {
        return optsex;
    }

    public void setOptsex(HtmlSelectOneRadio hsor) {
        this.optsex = hsor;
    }
    private UISelectItem femaleFamily = new UISelectItem();

    public UISelectItem getFemaleFamily() {
        return femaleFamily;
    }

    public void setFemaleFamily(UISelectItem uisi) {
        this.femaleFamily = uisi;
    }
    private UISelectItem malefamily = new UISelectItem();

    public UISelectItem getMalefamily() {
        return malefamily;
    }

    public void setMalefamily(UISelectItem uisi) {
        this.malefamily = uisi;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectedData defaultSelectedData21 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData21() {
        return defaultSelectedData21;
    }

    public void setDefaultSelectedData21(DefaultSelectedData dsd) {
        this.defaultSelectedData21 = dsd;
    }
    private DefaultSelectedData defaultSelectedData22 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData22() {
        return defaultSelectedData22;
    }

    public void setDefaultSelectedData22(DefaultSelectedData dsd) {
        this.defaultSelectedData22 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems5 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems5 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems7 = dsia;
    }
    private DefaultSelectedData defaultSelectedData23 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData23() {
        return defaultSelectedData23;
    }

    public void setDefaultSelectedData23(DefaultSelectedData dsd) {
        this.defaultSelectedData23 = dsd;
    }
    private DefaultSelectedData defaultSelectedData24 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData24() {
        return defaultSelectedData24;
    }

    public void setDefaultSelectedData24(DefaultSelectedData dsd) {
        this.defaultSelectedData24 = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems1() {
        return selectOneMenu3DefaultItems1;
    }

    public void setSelectOneMenu3DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems2() {
        return selectOneMenu3DefaultItems2;
    }

    public void setSelectOneMenu3DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu3DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu3DefaultItems3() {
        return selectOneMenu3DefaultItems3;
    }

    public void setSelectOneMenu3DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu3DefaultItems3 = dsia;
    }
    private HtmlCommandButton btnADSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnADSave() {
        return btnADSave;
    }

    public void setBtnADSave(HtmlCommandButton hcb) {
        this.btnADSave = hcb;
    }
    private HtmlSelectOneMenu drlRegion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRegion() {
        return drlRegion;
    }

    public void setDrlRegion(HtmlSelectOneMenu hsom) {
        this.drlRegion = hsom;
    }
    private HtmlSelectOneMenu drlWoreda = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlWoreda() {
        return drlWoreda;
    }

    public void setDrlWoreda(HtmlSelectOneMenu hsom) {
        this.drlWoreda = hsom;
    }
    private HtmlSelectOneMenu drlZone = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZone() {
        return drlZone;
    }

    public void setDrlZone(HtmlSelectOneMenu hsom) {
        this.drlZone = hsom;
    }
    private HtmlSelectOneMenu drlKebele = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlKebele() {
        return drlKebele;
    }

    public void setDrlKebele(HtmlSelectOneMenu hsom) {
        this.drlKebele = hsom;
    }
    private HtmlInputText txtHouseNumber = new HtmlInputText();

    public HtmlInputText getTxtHouseNumber() {
        return txtHouseNumber;
    }

    public void setTxtHouseNumber(HtmlInputText hit) {
        this.txtHouseNumber = hit;
    }
    private HtmlInputText txtPobox = new HtmlInputText();

    public HtmlInputText getTxtPobox() {
        return txtPobox;
    }

    public void setTxtPobox(HtmlInputText hit) {
        this.txtPobox = hit;
    }
    private HtmlInputText txtTelOffice = new HtmlInputText();

    public HtmlInputText getTxtTelOffice() {
        return txtTelOffice;
    }

    public void setTxtTelOffice(HtmlInputText hit) {
        this.txtTelOffice = hit;
    }
    private HtmlInputText txtTelHome = new HtmlInputText();

    public HtmlInputText getTxtTelHome() {
        return txtTelHome;
    }

    public void setTxtTelHome(HtmlInputText hit) {
        this.txtTelHome = hit;
    }
    private HtmlInputText txtMobile = new HtmlInputText();

    public HtmlInputText getTxtMobile() {
        return txtMobile;
    }

    public void setTxtMobile(HtmlInputText hit) {
        this.txtMobile = hit;
    }
    private HtmlInputText txtEmail = new HtmlInputText();

    public HtmlInputText getTxtEmail() {
        return txtEmail;
    }

    public void setTxtEmail(HtmlInputText hit) {
        this.txtEmail = hit;
    }
    private PopupBean panelPopup1Bean1 = new PopupBean();

    public PopupBean getPanelPopup1Bean1() {
        return panelPopup1Bean1;
    }

    public void setPanelPopup1Bean1(PopupBean pb) {
        this.panelPopup1Bean1 = pb;
    }
    private PopupBean panelPopup1Bean2 = new PopupBean();

    public PopupBean getPanelPopup1Bean2() {
        return panelPopup1Bean2;
    }

    public void setPanelPopup1Bean2(PopupBean pb) {
        this.panelPopup1Bean2 = pb;
    }
    private HtmlOutputText lblPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMain() {
        return lblPopUpMsgMain;
    }

    public void setLblPopUpMsgMain(HtmlOutputText hot) {
        this.lblPopUpMsgMain = hot;
    }
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYes() {
        return btnPopUpYes;
    }

    public void setBtnPopUpYes(HtmlCommandButton hcb) {
        this.btnPopUpYes = hcb;
    }
    private PanelPopup popUpConfirmation = new PanelPopup();

    public PanelPopup getPopUpConfirmation() {
        return popUpConfirmation;
    }

    public void setPopUpConfirmation(PanelPopup pp) {
        this.popUpConfirmation = pp;
    }
    private HtmlOutputText lblPopUpMsgContaint = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgContaint() {
        return lblPopUpMsgContaint;
    }

    public void setLblPopUpMsgContaint(HtmlOutputText hot) {
        this.lblPopUpMsgContaint = hot;
    }
    private PopupBean panelPopup1Bean3 = new PopupBean();

    public PopupBean getPanelPopup1Bean3() {
        return panelPopup1Bean3;
    }

    public void setPanelPopup1Bean3(PopupBean pb) {
        this.panelPopup1Bean3 = pb;
    }
    private HtmlCommandButton btnSaveAddressType = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveAddressType() {
        return btnSaveAddressType;
    }

    public void setBtnSaveAddressType(HtmlCommandButton hcb) {
        this.btnSaveAddressType = hcb;
    }
    private HtmlCommandButton btnCloseAddressType = new HtmlCommandButton();

    public HtmlCommandButton getBtnCloseAddressType() {
        return btnCloseAddressType;
    }

    public void setBtnCloseAddressType(HtmlCommandButton hcb) {
        this.btnCloseAddressType = hcb;
    }
    private PanelPopup popUpInputAddressType = new PanelPopup();

    public PanelPopup getPopUpInputAddressType() {
        return popUpInputAddressType;
    }

    public void setPopUpInputAddressType(PanelPopup pp) {
        this.popUpInputAddressType = pp;
    }
    private DefaultSelectedData defaultSelectedData25 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData25() {
        return defaultSelectedData25;
    }

    public void setDefaultSelectedData25(DefaultSelectedData dsd) {
        this.defaultSelectedData25 = dsd;
    }
    private HtmlSelectOneMenu drlAddressType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlAddressType() {
        return drlAddressType;
    }

    public void setDrlAddressType(HtmlSelectOneMenu hsom) {
        this.drlAddressType = hsom;
    }
    private DefaultSelectedData defaultSelectedData28 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData28() {
        return defaultSelectedData28;
    }

    public void setDefaultSelectedData28(DefaultSelectedData dsd) {
        this.defaultSelectedData28 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems5 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems5 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems6() {
        return selectOneRadio1DefaultItems6;
    }

    public void setSelectOneRadio1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems6 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems7() {
        return selectOneRadio1DefaultItems7;
    }

    public void setSelectOneRadio1DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems7 = dsia;
    }
    private HtmlCommandButton btnAPSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnAPSave() {
        return btnAPSave;
    }

    public void setBtnAPSave(HtmlCommandButton hcb) {
        this.btnAPSave = hcb;
    }
    private HtmlInputText txtHeight = new HtmlInputText();

    public HtmlInputText getTxtHeight() {
        return txtHeight;
    }

    public void setTxtHeight(HtmlInputText hit) {
        this.txtHeight = hit;
    }
    private HtmlInputText txtWeight = new HtmlInputText();

    public HtmlInputText getTxtWeight() {
        return txtWeight;
    }

    public void setTxtWeight(HtmlInputText hit) {
        this.txtWeight = hit;
    }
    private HtmlInputText txtEyeColor = new HtmlInputText();

    public HtmlInputText getTxtEyeColor() {
        return txtEyeColor;
    }

    public void setTxtEyeColor(HtmlInputText hit) {
        this.txtEyeColor = hit;
    }
    private DefaultSelectedData defaultSelectedData29 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData29() {
        return defaultSelectedData29;
    }

    public void setDefaultSelectedData29(DefaultSelectedData dsd) {
        this.defaultSelectedData29 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems8 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems8 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems10 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems10() {
        return selectOneMenu1DefaultItems10;
    }

    public void setSelectOneMenu1DefaultItems10(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems10 = dsia;
    }
    private SelectInputDateBean selectInputDateEducStart = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateEducEnd = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateExperienceStart = new SelectInputDateBean();
    private SelectInputDateBean selectInputDateExperienceEnd = new SelectInputDateBean();
    private DefaultSelectedData defaultSelectedData30 = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataGradingScale = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataEducationType = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataGradingScale() {
        return defaultSelectedDataGradingScale;
    }

    public void setDefaultSelectedDataGradingScale(DefaultSelectedData defaultSelectedDataGradingScale) {
        this.defaultSelectedDataGradingScale = defaultSelectedDataGradingScale;
    }

    public DefaultSelectedData getDefaultSelectedDataEducationType() {
        return defaultSelectedDataEducationType;
    }

    public void setDefaultSelectedDataEducationType(DefaultSelectedData defaultSelectedDataEducationType) {
        this.defaultSelectedDataEducationType = defaultSelectedDataEducationType;
    }

    public String getExperienceContractOrPrtmanent() {
        return experienceContractOrPrtmanent;
    }

    public void setExperienceContractOrPrtmanent(String experienceContractOrPrtmanent) {
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
    }

    public String getExperiencePrivateOrGovernmental() {
        return experiencePrivateOrGovernmental;
    }

    public void setExperiencePrivateOrGovernmental(String experiencePrivateOrGovernmental) {
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
    }

    public String getIsAlive() {
        return isAlive;
    }

    public void setIsAlive(String isAlive) {
        this.isAlive = isAlive;
    }

    public SelectInputDateBean getSelectInputDateEducEnd() {
        return selectInputDateEducEnd;
    }

    public void setSelectInputDateEducEnd(SelectInputDateBean selectInputDateEducEnd) {
        this.selectInputDateEducEnd = selectInputDateEducEnd;
    }

    public SelectInputDateBean getSelectInputDateEducStart() {
        return selectInputDateEducStart;
    }

    public void setSelectInputDateEducStart(SelectInputDateBean selectInputDateEducStart) {
        this.selectInputDateEducStart = selectInputDateEducStart;
    }

    public SelectInputDateBean getSelectInputDateExperienceEnd() {
        return selectInputDateExperienceEnd;
    }

    public void setSelectInputDateExperienceEnd(SelectInputDateBean selectInputDateExperienceEnd) {
        this.selectInputDateExperienceEnd = selectInputDateExperienceEnd;
    }

    public SelectInputDateBean getSelectInputDateExperienceStart() {
        return selectInputDateExperienceStart;
    }

    public void setSelectInputDateExperienceStart(SelectInputDateBean selectInputDateExperienceStart) {
        this.selectInputDateExperienceStart = selectInputDateExperienceStart;
    }

    public DefaultSelectedData getDefaultSelectedData30() {
        return defaultSelectedData30;
    }

    public void setDefaultSelectedData30(DefaultSelectedData dsd) {
        this.defaultSelectedData30 = dsd;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private PanelLayout lyEducationCode = new PanelLayout();

    public PanelLayout getLyEducationCode() {
        return lyEducationCode;
    }

    public void setLyEducationCode(PanelLayout pl) {
        this.lyEducationCode = pl;
    }
    private HtmlInputText txtInstitution = new HtmlInputText();

    public HtmlInputText getTxtInstitution() {
        return txtInstitution;
    }

    public void setTxtInstitution(HtmlInputText hit) {
        this.txtInstitution = hit;
    }
    private HtmlSelectOneMenu drlTypesOfEducation = new HtmlSelectOneMenu();
    private HtmlSelectOneMenu drlEducationCatagories = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEducationCatagories() {
        return drlEducationCatagories;
    }

    public void setDrlEducationCatagories(HtmlSelectOneMenu drlEducationCatagories) {
        this.drlEducationCatagories = drlEducationCatagories;
    }

    public HtmlSelectOneMenu getDrlTypesOfEducation() {
        return drlTypesOfEducation;
    }

    public void setDrlTypesOfEducation(HtmlSelectOneMenu hsom) {
        this.drlTypesOfEducation = hsom;
    }
    private HtmlInputText txtaward = new HtmlInputText();

    public HtmlInputText getTxtaward() {
        return txtaward;
    }

    public void setTxtaward(HtmlInputText hit) {
        this.txtaward = hit;
    }
    private HtmlInputText txtResult = new HtmlInputText();

    public HtmlInputText getTxtResult() {
        return txtResult;
    }

    public void setTxtResult(HtmlInputText hit) {
        this.txtResult = hit;
    }
    private HtmlCommandButton cmdEducationAdd = new HtmlCommandButton();

    public HtmlCommandButton getCmdEducationAdd() {
        return cmdEducationAdd;
    }

    public void setCmdEducationAdd(HtmlCommandButton hcb) {
        this.cmdEducationAdd = hcb;
    }
    private HtmlSelectOneMenu drlLevelOfEducation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLevelOfEducation() {
        return drlLevelOfEducation;
    }

    public void setDrlLevelOfEducation(HtmlSelectOneMenu hsom) {
        this.drlLevelOfEducation = hsom;
    }
    private HtmlCommandLink linkEditEducation = new HtmlCommandLink();

    public HtmlCommandLink getLinkEditEducation() {
        return linkEditEducation;
    }

    public void setLinkEditEducation(HtmlCommandLink hcl) {
        this.linkEditEducation = hcl;
    }
    private PanelLayout lyEducationlevel = new PanelLayout();

    public PanelLayout getLyEducationlevel() {
        return lyEducationlevel;
    }

    public void setLyEducationlevel(PanelLayout pl) {
        this.lyEducationlevel = pl;
    }
    private HtmlDataTable educationTable = new HtmlDataTable();

    public HtmlDataTable getEducationTable() {
        return educationTable;
    }

    public void setEducationTable(HtmlDataTable hdt) {
        this.educationTable = hdt;
    }
    private DefaultSelectedData defaultSelectedData31 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData31() {
        return defaultSelectedData31;
    }

    public void setDefaultSelectedData31(DefaultSelectedData dsd) {
        this.defaultSelectedData31 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems11 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems11() {
        return selectOneMenu1DefaultItems11;
    }

    public void setSelectOneMenu1DefaultItems11(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems11 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems12 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems12() {
        return selectOneMenu1DefaultItems12;
    }

    public void setSelectOneMenu1DefaultItems12(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems12 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems13 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems13() {
        return selectOneMenu1DefaultItems13;
    }

    public void setSelectOneMenu1DefaultItems13(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems13 = dsia;
    }
    private DefaultSelectedData defaultSelectedData32 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData32() {
        return defaultSelectedData32;
    }

    public void setDefaultSelectedData32(DefaultSelectedData dsd) {
        this.defaultSelectedData32 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems10 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems10() {
        return selectOneMenu2DefaultItems10;
    }

    public void setSelectOneMenu2DefaultItems10(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems10 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems11 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems11() {
        return selectOneMenu2DefaultItems11;
    }

    public void setSelectOneMenu2DefaultItems11(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems11 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems12 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems12() {
        return selectOneMenu2DefaultItems12;
    }

    public void setSelectOneMenu2DefaultItems12(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems12 = dsia;
    }
    private DefaultSelectedData defaultSelectedData33 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData33() {
        return defaultSelectedData33;
    }

    public void setDefaultSelectedData33(DefaultSelectedData dsd) {
        this.defaultSelectedData33 = dsd;
    }
    private DefaultSelectedData defaultSelectedData34 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData34() {
        return defaultSelectedData34;
    }

    public void setDefaultSelectedData34(DefaultSelectedData dsd) {
        this.defaultSelectedData34 = dsd;
    }
    private HtmlSelectOneMenu drlLanguageType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLanguageType() {
        return drlLanguageType;
    }

    public void setDrlLanguageType(HtmlSelectOneMenu hsom) {
        this.drlLanguageType = hsom;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private HtmlCommandButton btnLAAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnLAAdd() {
        return btnLAAdd;
    }

    public void setBtnLAAdd(HtmlCommandButton hcb) {
        this.btnLAAdd = hcb;
    }
    private HtmlSelectOneMenu drlListening = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlListening() {
        return drlListening;
    }

    public void setDrlListening(HtmlSelectOneMenu hsom) {
        this.drlListening = hsom;
    }
    private HtmlSelectOneMenu drlSpeaking = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSpeaking() {
        return drlSpeaking;
    }

    public void setDrlSpeaking(HtmlSelectOneMenu hsom) {
        this.drlSpeaking = hsom;
    }
    private HtmlSelectOneMenu drlReading = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReading() {
        return drlReading;
    }

    public void setDrlReading(HtmlSelectOneMenu hsom) {
        this.drlReading = hsom;
    }
    private HtmlSelectOneMenu drlWriting = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlWriting() {
        return drlWriting;
    }

    public void setDrlWriting(HtmlSelectOneMenu hsom) {
        this.drlWriting = hsom;
    }
    private HtmlCommandButton btnLASave = new HtmlCommandButton();

    public HtmlCommandButton getBtnLASave() {
        return btnLASave;
    }

    public void setBtnLASave(HtmlCommandButton hcb) {
        this.btnLASave = hcb;
    }
    private HtmlCommandLink cmdLanguageEdit = new HtmlCommandLink();

    public HtmlCommandLink getCmdLanguageEdit() {
        return cmdLanguageEdit;
    }

    public void setCmdLanguageEdit(HtmlCommandLink hcl) {
        this.cmdLanguageEdit = hcl;
    }
    private HtmlDataTable tblLanguageTable = new HtmlDataTable();

    public HtmlDataTable getTblLanguageTable() {
        return tblLanguageTable;
    }

    public void setTblLanguageTable(HtmlDataTable hdt) {
        this.tblLanguageTable = hdt;
    }
    private DefaultTableDataModel dataTable1Model3 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model3() {
        return dataTable1Model3;
    }

    public void setDataTable1Model3(DefaultTableDataModel dtdm) {
        this.dataTable1Model3 = dtdm;
    }
    private HtmlInputText txtExperianceInstitution = new HtmlInputText();

    public HtmlInputText getTxtExperianceInstitution() {
        return txtExperianceInstitution;
    }

    public void setTxtExperianceInstitution(HtmlInputText hit) {
        this.txtExperianceInstitution = hit;
    }
    private HtmlInputText txtJobType = new HtmlInputText();

    public HtmlInputText getTxtJobType() {
        return txtJobType;
    }

    public void setTxtJobType(HtmlInputText hit) {
        this.txtJobType = hit;
    }
    private HtmlInputTextarea txtTermination = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtTermination() {
        return txtTermination;
    }

    public void setTxtTermination(HtmlInputTextarea hit) {
        this.txtTermination = hit;
    }
    private HtmlInputText txtExperanceSalary = new HtmlInputText();

    public HtmlInputText getTxtExperanceSalary() {
        return txtExperanceSalary;
    }

    public void setTxtExperanceSalary(HtmlInputText hit) {
        this.txtExperanceSalary = hit;
    }
    private HtmlInputText txtExRank = new HtmlInputText();

    public HtmlInputText getTxtExRank() {
        return txtExRank;
    }

    public void setTxtExRank(HtmlInputText hit) {
        this.txtExRank = hit;
    }
    private HtmlCommandButton btnAddExperience = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddExperience() {
        return btnAddExperience;
    }

    public void setBtnAddExperience(HtmlCommandButton hcb) {
        this.btnAddExperience = hcb;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink linkExperiance = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getLinkExperiance() {
        return linkExperiance;
    }

    public void setLinkExperiance(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.linkExperiance = hcl;
    }
    private HtmlDataTable tableExperiance = new HtmlDataTable();

    public HtmlDataTable getTableExperiance() {
        return tableExperiance;
    }
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

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

    public HtmlCommandButton getBtnSaveNewLanguageType() {
        return btnSaveNewLanguageType;
    }

    public void setBtnSaveNewLanguageType(HtmlCommandButton btnSaveNewLanguageType) {
        this.btnSaveNewLanguageType = btnSaveNewLanguageType;
    }
    //private HtmlOutputLabel pnlInsertNewLanguageType = new HtmlOutputLabel();
//    private PanelLayout pnlMessageBody = new PanelLayout();
//    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlInsertNewLanguageType = new PanelPopup();
    private PanelPopup pnlInsertNewInstiutationType = new PanelPopup();
    private PanelPopup pnlInsertNewLocationType = new PanelPopup();

    public PanelPopup getPnlInsertNewLocationType() {
        return pnlInsertNewLocationType;
    }

    public void setPnlInsertNewLocationType(PanelPopup pnlInsertNewLocationType) {
        this.pnlInsertNewLocationType = pnlInsertNewLocationType;
    }

    HtmlInputText txtNameNewInstiutationType = new HtmlInputText();


     HtmlInputText txtNameNewLocationType = new HtmlInputText();

    public HtmlInputText getTxtNameNewLocationType() {
        return txtNameNewLocationType;
    }

    public void setTxtNameNewLocationType(HtmlInputText txtNameNewLocationType) {
        this.txtNameNewLocationType = txtNameNewLocationType;
    }


    public HtmlInputText getTxtNameNewInstiutationType() {
        return txtNameNewInstiutationType;
    }

    public void setTxtNameNewInstiutationType(HtmlInputText txtNameNewInstiutationType) {
        this.txtNameNewInstiutationType = txtNameNewInstiutationType;
    }

    public PanelPopup getPnlInsertNewInstiutationType() {
        return pnlInsertNewInstiutationType;
    }

    public void setPnlInsertNewInstiutationType(PanelPopup pnlInsertNewInstiutationType) {
        this.pnlInsertNewInstiutationType = pnlInsertNewInstiutationType;
    }

    public PanelPopup getPnlInsertNewLanguageType(){
        return pnlInsertNewLanguageType;
    }

    public void setPnlInsertNewLanguageType(PanelPopup pnlInsertNewLanguageType) {
        this.pnlInsertNewLanguageType = pnlInsertNewLanguageType;
    }

    public String btnClosePopupInsertNewLanguageType_action() {
        pnlInsertNewLanguageType.setRendered(false);
        return null;
    }


     public String btnClosePopupInsertNewInstiutationType_action() {
        pnlInsertNewInstiutationType.setRendered(false);
        return null;
    }



     public String btnClosePopupInsertNewLocationType_action() {
        pnlInsertNewLocationType.setRendered(false);
        return null;
    }

    public String btnSaveNewLanguageType_action() {
        if (txtNameNewLanguageType.getValue() != null && !txtNameNewLanguageType.getValue().toString().equals("")) {
            if (languageManager.saveLanguageType(txtNameNewLanguageType.getValue().toString())) {
                txtNameNewLanguageType.setValue(null);
                pnlInsertNewLanguageType.setRendered(false);
            }
        }
        return null;
    }

      public String btnSaveNewInstiutationType_action() {
        if (txtNameNewInstiutationType.getValue() != null && !txtNameNewInstiutationType.getValue().toString().equals("")) {
            if (languageManager.saveInstiutationType(txtNameNewInstiutationType.getValue().toString())) {
                txtNameNewInstiutationType.setValue(null);
                pnlInsertNewInstiutationType.setRendered(false);
            }
        }
        return null;
    }


       public String btnSaveNewLocationType_action() {
        if (txtNameNewLocationType.getValue() != null && !txtNameNewLocationType.getValue().toString().equals("")) {
            if (languageManager.saveLocationType(txtNameNewLocationType.getValue().toString())) {
                txtNameNewLocationType.setValue(null);
                pnlInsertNewLocationType.setRendered(false);
            }
        }
        return null;
    }






    public void setTableExperiance(HtmlDataTable hdt) {
        this.tableExperiance = hdt;
    }
    private HtmlCommandButton btnEXSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXSave() {
        return btnEXSave;
    }

    public void setBtnEXSave(HtmlCommandButton hcb) {
        this.btnEXSave = hcb;
    }
    private HtmlInputText txtSearchByName = new HtmlInputText();

    public HtmlInputText getTxtSearchByName() {
        return txtSearchByName;
    }

    public void setTxtSearchByName(HtmlInputText hit) {
        this.txtSearchByName = hit;
    }
    private HtmlInputText txtTry = new HtmlInputText();

    public HtmlInputText getTxtTry() {
        return txtTry;
    }

    public void setTxtTry(HtmlInputText hit) {
        this.txtTry = hit;
    }
    private PanelTabSet panelTabSet1 = new PanelTabSet();

    public PanelTabSet getPanelTabSet1() {
        return panelTabSet1;
    }

    public boolean isSexSelect() {
        return sexSelect;
    }

    public void setPanelTabSet1(PanelTabSet pts) {
        this.panelTabSet1 = pts;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private InputFile inputPhoto = new InputFile();

    public InputFile getInputPhoto() {
        return inputPhoto;
    }

    public void setInputPhoto(InputFile if0) {
        this.inputPhoto = if0;
    }
//    private DefaultSelectedData defaultSelectedData35 = new DefaultSelectedData();
//
//    public DefaultSelectedData getDefaultSelectedData35() {
//        return defaultSelectedData35;
//    }
//
//    public void setDefaultSelectedData35(DefaultSelectedData dsd) {
//        this.defaultSelectedData35 = dsd;
//    }
//    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();
//
//    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
//        return selectBooleanCheckbox2Bean;
//    }
//
//    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
//        this.selectBooleanCheckbox2Bean = dsd;
//    }
//    private HtmlSelectBooleanCheckbox ckbSexFemale = new HtmlSelectBooleanCheckbox();
//
//    public HtmlSelectBooleanCheckbox getCboGenderFemale() {
//        return ckbSexFemale;
//    }
//
//    public void setCboGenderFemale(HtmlSelectBooleanCheckbox hsbc) {
//        this.ckbSexFemale = hsbc;
//    }
    private HtmlSelectBooleanCheckbox ckbSexMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboGenderMale() {
        return ckbSexMale;
    }

    public void setCboGenderMale(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbSexMale = hsbc;
    }
    private DefaultSelectedData defaultSelectedDataOffice = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataShift = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataOffice() {
        return defaultSelectedDataOffice;
    }

    public void setDefaultSelectedDataOffice(DefaultSelectedData defaultSelectedDataOffice) {
        this.defaultSelectedDataOffice = defaultSelectedDataOffice;
    }

    public DefaultSelectedData getDefaultSelectedDataShift() {
        return defaultSelectedDataShift;
    }

    public void setDefaultSelectedDataShift(DefaultSelectedData defaultSelectedDataShift) {
        this.defaultSelectedDataShift = defaultSelectedDataShift;
    }
    private DefaultSelectedData defaultSelectedDataPermanentCheckBox = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataContractCheckBox = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataContractCheckBox() {
        return defaultSelectedDataContractCheckBox;
    }

    public void setDefaultSelectedDataContractCheckBox(DefaultSelectedData defaultSelectedDataContractCheckBox) {
        this.defaultSelectedDataContractCheckBox = defaultSelectedDataContractCheckBox;
    }

    public DefaultSelectedData getDefaultSelectedDataPermanentCheckBox() {
        return defaultSelectedDataPermanentCheckBox;
    }

    public void setDefaultSelectedDataPermanentCheckBox(DefaultSelectedData defaultSelectedDataPermanentCheckBox) {
        this.defaultSelectedDataPermanentCheckBox = defaultSelectedDataPermanentCheckBox;
    }
    private HtmlOutputText lblFirstNameError = new HtmlOutputText();

    public HtmlOutputText getLblFirstNameError() {
        return lblFirstNameError;
    }

    public void setLblFirstNameError(HtmlOutputText hot) {
        this.lblFirstNameError = hot;
    }
    private HtmlMessage msgErrorMiddelName = new HtmlMessage();

    public HtmlMessage getMsgErrorMiddelName() {
        return msgErrorMiddelName;
    }

    public void setMsgErrorMiddelName(HtmlMessage hm) {
        this.msgErrorMiddelName = hm;
    }
    private HtmlMessage message1 = new HtmlMessage();

    public HtmlMessage getMessage1() {
        return message1;
    }

    public void setMessage1(HtmlMessage hm) {
        this.message1 = hm;
    }
    private HtmlGraphicImage imgMember = new HtmlGraphicImage();

    public HtmlGraphicImage getImgMember() {
        return imgMember;
    }

    public void setImgMember(HtmlGraphicImage hgi) {
        this.imgMember = hgi;
    }
    private PanelLayout tabPersonalData = new PanelLayout();

    public PanelLayout getTabPersonalData() {
        return tabPersonalData;
    }

    public void setTabPersonalData(PanelLayout pl) {
        this.tabPersonalData = pl;
    }
    private HtmlCommandButton btnYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnYes() {
        return btnYes;
    }

    public void setBtnYes(HtmlCommandButton hcb) {
        this.btnYes = hcb;
    }
    private HtmlCommandButton btnNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnNo() {
        return btnNo;
    }

    public void setBtnNo(HtmlCommandButton hcb) {
        this.btnNo = hcb;
    }
    private HtmlCommandButton btnPopUpOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpOk() {
        return btnPopUpOk;
    }

    public void setBtnPopUpOk(HtmlCommandButton hcb) {
        this.btnPopUpOk = hcb;
    }
    private HtmlGraphicImage imgMemberFamily = new HtmlGraphicImage();

    public HtmlGraphicImage getImgMemberFamily() {
        return imgMemberFamily;
    }

    public void setImgMemberFamily(HtmlGraphicImage hgi) {
        this.imgMemberFamily = hgi;
    }
    private PanelTab tabPersonal = new PanelTab();

    public PanelTab getTabPersonal() {
        return tabPersonal;
    }

    public void setTabPersonal(PanelTab pt) {
        this.tabPersonal = pt;
    }
    private DefaultSelectedData defaultSelectedData38 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData38() {
        return defaultSelectedData38;
    }

    public void setDefaultSelectedData38(DefaultSelectedData dsd) {
        this.defaultSelectedData38 = dsd;
    }
    private DefaultSelectedData defaultSelectedData39 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData39() {
        return defaultSelectedData39;
    }

    public void setDefaultSelectedData39(DefaultSelectedData dsd) {
        this.defaultSelectedData39 = dsd;
    }
    private HtmlSelectBooleanCheckbox chkFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkFemale() {
        return chkFemale;
    }

    public void setChkFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkFemale = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkMale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMale() {
        return chkMale;
    }

    public void setChkMale(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMale = hsbc;
    }
    private HtmlCommandButton btnFaSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaSave() {
        return btnFaSave;
    }

    public void setBtnFaSave(HtmlCommandButton hcb) {
        this.btnFaSave = hcb;
    }
    private HtmlCommandButton btnFaEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaEdit() {
        return btnFaEdit;
    }

    public void setBtnFaEdit(HtmlCommandButton hcb) {
        this.btnFaEdit = hcb;
    }
    private DefaultTableDataModel dataTable1Model4 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model4() {
        return dataTable1Model4;
    }

    public void setDataTable1Model4(DefaultTableDataModel dtdm) {
        this.dataTable1Model4 = dtdm;
    }
    private HtmlCommandButton btnAddAddress = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAddress() {
        return btnAddAddress;
    }

    public void setBtnAddAddress(HtmlCommandButton hcb) {
        this.btnAddAddress = hcb;
    }
    private HtmlCommandButton btnEdit1Address = new HtmlCommandButton();

    public HtmlCommandButton getbtnEdit1Address() {
        return btnEdit1Address;
    }

    public void setbtnEdit1Address(HtmlCommandButton hcb) {
        this.btnEdit1Address = hcb;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink linkEditAddress = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getLinkEditAddress() {
        return linkEditAddress;
    }

    public void setLinkEditAddress(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.linkEditAddress = hcl;
    }
    private HtmlDataTable tblAddress = new HtmlDataTable();

    public HtmlDataTable getTblAddress() {
        return tblAddress;
    }

    public void setTblAddress(HtmlDataTable hdt) {
        this.tblAddress = hdt;
    }
    private HtmlCommandButton btnADEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnADEdit() {
        return btnADEdit;
    }

    public void setBtnADEdit(HtmlCommandButton hcb) {
        this.btnADEdit = hcb;
    }
    private DefaultSelectedData defaultSelectedData40 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData40() {
        return defaultSelectedData40;
    }

    public void setDefaultSelectedData40(DefaultSelectedData dsd) {
        this.defaultSelectedData40 = dsd;
    }
    private DefaultSelectedData defaultSelectedData41 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData41() {
        return defaultSelectedData41;
    }

    public void setDefaultSelectedData41(DefaultSelectedData dsd) {
        this.defaultSelectedData41 = dsd;
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
    private HtmlSelectBooleanCheckbox optA = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getOptA() {
        return optA;
    }

    public void setOptA(HtmlSelectBooleanCheckbox hsbc) {
        this.optA = hsbc;
    }
    private HtmlSelectBooleanCheckbox optB = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getOptB() {
        return optB;
    }

    public void setOptB(HtmlSelectBooleanCheckbox hsbc) {
        this.optB = hsbc;
    }
    private HtmlSelectBooleanCheckbox optAB = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getOptAB() {
        return optAB;
    }

    public void setOptAB(HtmlSelectBooleanCheckbox hsbc) {
        this.optAB = hsbc;
    }
    private HtmlSelectBooleanCheckbox optO = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getOptO() {
        return optO;
    }

    public void setOptO(HtmlSelectBooleanCheckbox hsbc) {
        this.optO = hsbc;
    }
    private HtmlCommandButton btnEDEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDEdit() {
        return btnEDEdit;
    }

    public void setBtnEDEdit(HtmlCommandButton hcb) {
        this.btnEDEdit = hcb;
    }
    private HtmlCommandButton btnEDSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDSave() {
        return btnEDSave;
    }

    public void setBtnEDSave(HtmlCommandButton hcb) {
        this.btnEDSave = hcb;
    }
    private HtmlCommandButton btnEDReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDReset() {
        return btnEDReset;
    }

    public void setBtnEDReset(HtmlCommandButton hcb) {
        this.btnEDReset = hcb;
    }
    private HtmlCommandButton btnEDDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDDelete() {
        return btnEDDelete;
    }

    public void setBtnEDDelete(HtmlCommandButton hcb) {
        this.btnEDDelete = hcb;
    }
    private HtmlCommandButton btnLAEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnLAEdit() {
        return btnLAEdit;
    }

    public void setBtnLAEdit(HtmlCommandButton hcb) {
        this.btnLAEdit = hcb;
    }
    private HtmlCommandButton btnLAReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnLAReset() {
        return btnLAReset;
    }

    public void setBtnLAReset(HtmlCommandButton hcb) {
        this.btnLAReset = hcb;
    }
    private HtmlCommandButton btnLADelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnLADelete() {
        return btnLADelete;
    }

    public void setBtnLADelete(HtmlCommandButton hcb) {
        this.btnLADelete = hcb;
    }
    private HtmlCommandButton btnEXEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXEdit() {
        return btnEXEdit;
    }

    public void setBtnEXEdit(HtmlCommandButton hcb) {
        this.btnEXEdit = hcb;
    }
    private HtmlCommandButton btnEXReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXReset() {
        return btnEXReset;
    }

    public void setBtnEXReset(HtmlCommandButton hcb) {
        this.btnEXReset = hcb;
    }
    private HtmlCommandButton btnEXDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXDelete() {
        return btnEXDelete;
    }

    public void setBtnEXDelete(HtmlCommandButton hcb) {
        this.btnEXDelete = hcb;
    }
    private HtmlOutputText lblTotalEmp1 = new HtmlOutputText();

    public HtmlOutputText getLblTotalEmp1() {
        return lblTotalEmp1;
    }

    public void setLblTotalEmp1(HtmlOutputText hot) {
        this.lblTotalEmp1 = hot;
    }
    private HtmlOutputText lblSexValidation = new HtmlOutputText();

    public HtmlOutputText getLblSexValidation() {
        return lblSexValidation;
    }

    public void setLblSexValidation(HtmlOutputText hot) {
        this.lblSexValidation = hot;
    }
    private HtmlOutputText lblPhoto = new HtmlOutputText();

    public HtmlOutputText getLblPhoto() {
        return lblPhoto;
    }

    public void setLblPhoto(HtmlOutputText hot) {
        this.lblPhoto = hot;
    }
    private HtmlOutputText lblValidateFamilyGender = new HtmlOutputText();

    public HtmlOutputText getLblValidateFamilyGender() {
        return lblValidateFamilyGender;
    }

    public void setLblValidateFamilyGender(HtmlOutputText hot) {
        this.lblValidateFamilyGender = hot;
    }
    private HtmlCommandButton btnFaAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaAdd() {
        return btnFaAdd;
    }

    public void setBtnFaAdd(HtmlCommandButton hcb) {
        this.btnFaAdd = hcb;
    }
    private HtmlOutputText lblBloodGroup1 = new HtmlOutputText();

    public HtmlOutputText getLblBloodGroup1() {
        return lblBloodGroup1;
    }

    public void setLblBloodGroup1(HtmlOutputText hot) {
        this.lblBloodGroup1 = hot;
    }
    private HtmlCommandButton btnAPEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnAPEdit() {
        return btnAPEdit;
    }

    public void setBtnAPEdit(HtmlCommandButton hcb) {
        this.btnAPEdit = hcb;
    }
    private HtmlCommandButton btnAYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnAYes() {
        return btnAYes;
    }

    public void setBtnAYes(HtmlCommandButton hcb) {
        this.btnAYes = hcb;
    }
    private HtmlCommandButton btnDeleteYesEducation = new HtmlCommandButton();

    public HtmlCommandButton getBtnDeleteYesEducation() {
        return btnDeleteYesEducation;
    }

    public void setBtnDeleteYesEducation(HtmlCommandButton hcb) {
        this.btnDeleteYesEducation = hcb;
    }
    private DefaultSelectedData defaultSelectedData42 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData42() {
        return defaultSelectedData42;
    }

    public void setDefaultSelectedData42(DefaultSelectedData dsd) {
        this.defaultSelectedData42 = dsd;
    }
    private DefaultSelectedData defaultSelectedData43 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData43() {
        return defaultSelectedData43;
    }

    public void setDefaultSelectedData43(DefaultSelectedData dsd) {
        this.defaultSelectedData43 = dsd;
    }
    private DefaultSelectedData defaultSelectedData44 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData44() {
        return defaultSelectedData44;
    }

    public void setDefaultSelectedData44(DefaultSelectedData dsd) {
        this.defaultSelectedData44 = dsd;
    }
    private DefaultSelectedData defaultSelectedData45 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData45() {
        return defaultSelectedData45;
    }

    public void setDefaultSelectedData45(DefaultSelectedData dsd) {
        this.defaultSelectedData45 = dsd;
    }
    private DefaultSelectedData defaultSelectedData46 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData46() {
        return defaultSelectedData46;
    }

    public void setDefaultSelectedData46(DefaultSelectedData dsd) {
        this.defaultSelectedData46 = dsd;
    }
    private DefaultSelectedData defaultSelectedData47 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData47() {
        return defaultSelectedData47;
    }

    public void setDefaultSelectedData47(DefaultSelectedData dsd) {
        this.defaultSelectedData47 = dsd;
    }
    private HtmlSelectOneMenu drlCandidateName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlCandidateName() {
        return drlCandidateName;
    }

    public void setDrlCandidateName(HtmlSelectOneMenu hsom) {
        this.drlCandidateName = hsom;
    }
    private HtmlSelectBooleanCheckbox chkMedicalFit = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkMedicalFit() {
        return chkMedicalFit;
    }

    public void setChkMedicalFit(HtmlSelectBooleanCheckbox hsbc) {
        this.chkMedicalFit = hsbc;
    }
    private HtmlSelectBooleanCheckbox chkCrimeFree = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkCrimeFree() {
        return chkCrimeFree;
    }

    public void setChkCrimeFree(HtmlSelectBooleanCheckbox hsbc) {
        this.chkCrimeFree = hsbc;
    }
    private HtmlOutputText lblErrorMessageForCandidate = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForCandidate() {
        return lblErrorMessageForCandidate;
    }

    public void setLblErrorMessageForCandidate(HtmlOutputText hot) {
        this.lblErrorMessageForCandidate = hot;
    }
    private InputFile inputmemberPhoto = new InputFile();

    public InputFile getInputmemberPhoto() {
        return inputmemberPhoto;
    }

    public void setInputmemberPhoto(InputFile if0) {
        this.inputmemberPhoto = if0;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private HtmlCommandButton btnFaUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaUpdate() {
        return btnFaUpdate;
    }

    public void setBtnFaUpdate(HtmlCommandButton hcb) {
        this.btnFaUpdate = hcb;
    }
    private PanelCollapsible panelCollapsible5 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible5() {
        return panelCollapsible5;
    }

    public void setPanelCollapsible5(PanelCollapsible pc) {
        this.panelCollapsible5 = pc;
    }
    private HtmlCommandButton btnFaDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaDelete() {
        return btnFaDelete;
    }

    public void setBtnFaDelete(HtmlCommandButton hcb) {
        this.btnFaDelete = hcb;
    }
    private HtmlCommandButton btnADDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnADDelete() {
        return btnADDelete;
    }

    public void setBtnADDelete(HtmlCommandButton hcb) {
        this.btnADDelete = hcb;
    }
    private HtmlCommandButton btnApDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnApDelete() {
        return btnApDelete;
    }

    public void setBtnApDelete(HtmlCommandButton hcb) {
        this.btnApDelete = hcb;
    }
    private PanelPopup pnlPopUpDateSetting = new PanelPopup();

    public PanelPopup getPnlPopUpDateSetting() {
        return pnlPopUpDateSetting;
    }

    public void setPnlPopUpDateSetting(PanelPopup pp) {
        this.pnlPopUpDateSetting = pp;
    }
    private HtmlInputText txtDateDefference = new HtmlInputText();

    public HtmlInputText getTxtDateDefference() {
        return txtDateDefference;
    }

    public void setTxtDateDefference(HtmlInputText hit) {
        this.txtDateDefference = hit;
    }
    private HtmlInputTextarea txtDDDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDDDescription() {
        return txtDDDescription;
    }

    public void setTxtDDDescription(HtmlInputTextarea hit) {
        this.txtDDDescription = hit;
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
    private HtmlCommandButton btnFaReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnFaReset() {
        return btnFaReset;
    }

    public void setBtnFaReset(HtmlCommandButton hcb) {
        this.btnFaReset = hcb;
    }
    private HtmlCommandButton btnADNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnADNew() {
        return btnADNew;
    }

    public void setBtnADNew(HtmlCommandButton hcb) {
        this.btnADNew = hcb;
    }
    private HtmlCommandButton btnADReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnADReset() {
        return btnADReset;
    }

    public void setBtnADReset(HtmlCommandButton hcb) {
        this.btnADReset = hcb;
    }
    private HtmlCommandButton btnADUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnADUpdate() {
        return btnADUpdate;
    }

    public void setBtnADUpdate(HtmlCommandButton hcb) {
        this.btnADUpdate = hcb;
    }
    private HtmlCommandButton btnAPNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnAPNew() {
        return btnAPNew;
    }

    public void setBtnAPNew(HtmlCommandButton hcb) {
        this.btnAPNew = hcb;
    }
    private HtmlCommandButton btnEDNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDNew() {
        return btnEDNew;
    }

    public void setBtnEDNew(HtmlCommandButton hcb) {
        this.btnEDNew = hcb;
    }
    private HtmlCommandButton btnEDUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEDUpdate() {
        return btnEDUpdate;
    }

    public void setBtnEDUpdate(HtmlCommandButton hcb) {
        this.btnEDUpdate = hcb;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink cmdFaRemove = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getCmdFaRemove() {
        return cmdFaRemove;
    }

    public void setCmdFaRemove(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.cmdFaRemove = hcl;
    }
    private HtmlCommandButton btnAPReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnAPReset() {
        return btnAPReset;
    }

    public void setBtnAPReset(HtmlCommandButton hcb) {
        this.btnAPReset = hcb;
    }
    private HtmlCommandButton btnLANew = new HtmlCommandButton();

    public HtmlCommandButton getBtnLANew() {
        return btnLANew;
    }

    public void setBtnLANew(HtmlCommandButton hcb) {
        this.btnLANew = hcb;
    }
    private HtmlCommandButton btnLAUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnLAUpdate() {
        return btnLAUpdate;
    }

    public void setBtnLAUpdate(HtmlCommandButton hcb) {
        this.btnLAUpdate = hcb;
    }
    private HtmlCommandButton btnEXNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXNew() {
        return btnEXNew;
    }

    public void setBtnEXNew(HtmlCommandButton hcb) {
        this.btnEXNew = hcb;
    }
    private HtmlCommandButton btnEXUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnEXUpdate() {
        return btnEXUpdate;
    }

    public void setBtnEXUpdate(HtmlCommandButton hcb) {
        this.btnEXUpdate = hcb;
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
    private DefaultSelectedData defaultSelectedData48 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData48() {
        return defaultSelectedData48;
    }

    public void setDefaultSelectedData48(DefaultSelectedData dsd) {
        this.defaultSelectedData48 = dsd;
    }
    private DefaultSelectedData defaultSelectedData49 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData49() {
        return defaultSelectedData49;
    }

    public void setDefaultSelectedData49(DefaultSelectedData dsd) {
        this.defaultSelectedData49 = dsd;
    }
    private HtmlSelectOneMenu drlMaritalStatus = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMaritalStatus() {
        return drlMaritalStatus;
    }

    public void setDrlMaritalStatus(HtmlSelectOneMenu hsom) {
        this.drlMaritalStatus = hsom;
    }
    private HtmlInputText txtRetirementNo = new HtmlInputText();

    public HtmlInputText getTxtRetirementNo() {
        return txtRetirementNo;
    }

    public void setTxtRetirementNo(HtmlInputText hit) {
        this.txtRetirementNo = hit;
    }
    private DefaultSelectedData defaultSelectedData50 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData50() {
        return defaultSelectedData50;
    }

    public void setDefaultSelectedData50(DefaultSelectedData dsd) {
        this.defaultSelectedData50 = dsd;
    }
    private DefaultSelectedData defaultSelectedData51 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData51() {
        return defaultSelectedData51;
    }

    public void setDefaultSelectedData51(DefaultSelectedData dsd) {
        this.defaultSelectedData51 = dsd;
    }
    private RowSelector rowSelectorEvaSession = new RowSelector();

    public RowSelector getRowSelectorEvaSession() {
        return rowSelectorEvaSession;
    }

    public void setRowSelectorEvaSession(RowSelector rs) {
        this.rowSelectorEvaSession = rs;
    }
    private PanelPopup familyPopUpMsg = new PanelPopup();

    public PanelPopup getFamilyPopUpMsg() {
        return familyPopUpMsg;
    }

    public void setFamilyPopUpMsg(PanelPopup pp) {
        this.familyPopUpMsg = pp;
    }
    private HtmlOutputText lblMessagePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblMessagePopUpMsgMain() {
        return lblMessagePopUpMsgMain;
    }

    public void setLblMessagePopUpMsgMain(HtmlOutputText hot) {
        this.lblMessagePopUpMsgMain = hot;
    }
    private HtmlCommandButton btnYesFamilyPopUp = new HtmlCommandButton();

    public HtmlCommandButton getBtnYesFamilyPopUp() {
        return btnYesFamilyPopUp;
    }

    public void setBtnYesFamilyPopUp(HtmlCommandButton hcb) {
        this.btnYesFamilyPopUp = hcb;
    }
    private HtmlCommandButton btnNoFamilyPopUp = new HtmlCommandButton();

    public HtmlCommandButton getBtnNoFamilyPopUp() {
        return btnNoFamilyPopUp;
    }

    public void setBtnNoFamilyPopUp(HtmlCommandButton hcb) {
        this.btnNoFamilyPopUp = hcb;
    }
    private RowSelector rowSelectorEmployeeAddress = new RowSelector();

    public RowSelector getRowSelectorEmployeeAddress() {
        return rowSelectorEmployeeAddress;
    }

    public void setRowSelectorEmployeeAddress(RowSelector rs) {
        this.rowSelectorEmployeeAddress = rs;
    }
    private HtmlCommandButton btnYesAddressPopUp = new HtmlCommandButton();

    public HtmlCommandButton getBtnYesAddressPopUp() {
        return btnYesAddressPopUp;
    }

    public void setBtnYesAddressPopUp(HtmlCommandButton hcb) {
        this.btnYesAddressPopUp = hcb;
    }
    private HtmlCommandButton btnNoAddressPopUp = new HtmlCommandButton();

    public HtmlCommandButton getBtnNoAddressPopUp() {
        return btnNoAddressPopUp;
    }

    public void setBtnNoAddressPopUp(HtmlCommandButton hcb) {
        this.btnNoAddressPopUp = hcb;
    }
    private RowSelector rowSelectorEmployeeEducation = new RowSelector();

    public RowSelector getRowSelectorEmployeeEducation() {
        return rowSelectorEmployeeEducation;
    }

    public void setRowSelectorEmployeeEducation(RowSelector rs) {
        this.rowSelectorEmployeeEducation = rs;
    }
    private RowSelector rowSelectorEmployeeLanguage = new RowSelector();

    public RowSelector getRowSelectorEmployeeLanguage() {
        return rowSelectorEmployeeLanguage;
    }

    public void setRowSelectorEmployeeLanguage(RowSelector rs) {
        this.rowSelectorEmployeeLanguage = rs;
    }
    private HtmlOutputText lblRequiredMes = new HtmlOutputText();

    public HtmlOutputText getLblRequiredMes() {
        return lblRequiredMes;
    }

    public void setLblRequiredMes(HtmlOutputText hot) {
        this.lblRequiredMes = hot;
    }
    private DefaultSelectedData defaultSelectedData52 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData52() {
        return defaultSelectedData52;
    }

    public void setDefaultSelectedData52(DefaultSelectedData dsd) {
        this.defaultSelectedData52 = dsd;
    }
    private RowSelector rowSelectorEmployeeExperance = new RowSelector();

    public RowSelector getRowSelectorEmployeeExperance() {
        return rowSelectorEmployeeExperance;
    }

    public void setRowSelectorEmployeeExperance(RowSelector rs) {
        this.rowSelectorEmployeeExperance = rs;
    }
    private HtmlCommandButton btnFamilyNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnFamilyNew() {
        return btnFamilyNew;
    }

    public void setBtnFamilyNew(HtmlCommandButton hcb) {
        this.btnFamilyNew = hcb;
    }
    private PanelPopup employeePlanPopUpMsg = new PanelPopup();

    public PanelPopup getEmployeePlanPopUpMsg() {
        return employeePlanPopUpMsg;
    }

    public void setEmployeePlanPopUpMsg(PanelPopup pp) {
        this.employeePlanPopUpMsg = pp;
    }
    private HtmlCommandButton btntemployeePopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtntemployeePopUpYes() {
        return btntemployeePopUpYes;
    }

    public void setBtntemployeePopUpYes(HtmlCommandButton hcb) {
        this.btntemployeePopUpYes = hcb;
    }
    private HtmlCommandButton btntemployeePopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtntemployeePopUpNo() {
        return btntemployeePopUpNo;
    }

    public void setBtntemployeePopUpNo(HtmlCommandButton hcb) {
        this.btntemployeePopUpNo = hcb;
    }
    private PanelLayout panelLayoutImageHolderemployee = new PanelLayout();

    public PanelLayout getPanelLayoutImageHolderemployee() {
        return panelLayoutImageHolderemployee;
    }

    public void setPanelLayoutImageHolderemployee(PanelLayout pl) {
        this.panelLayoutImageHolderemployee = pl;
    }
    private HtmlOutputText lblemployeePopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblemployeePopUpMsgMain() {
        return lblemployeePopUpMsgMain;
    }

    public void setLblemployeePopUpMsgMain(HtmlOutputText hot) {
        this.lblemployeePopUpMsgMain = hot;
    }
    private DefaultSelectedData defaultSelectedData53 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData53() {
        return defaultSelectedData53;
    }

    public void setDefaultSelectedData53(DefaultSelectedData dsd) {
        this.defaultSelectedData53 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems14 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems14() {
        return selectOneMenu1DefaultItems14;
    }

    public void setSelectOneMenu1DefaultItems14(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems14 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems15 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems15() {
        return selectOneMenu1DefaultItems15;
    }

    public void setSelectOneMenu1DefaultItems15(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems15 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems16 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems16() {
        return selectOneMenu1DefaultItems16;
    }

    public void setSelectOneMenu1DefaultItems16(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems16 = dsia;
    }
    private HtmlInputText inputTextPopUpempTitle = new HtmlInputText();

    public HtmlInputText getInputTextPopUpempTitle() {
        return inputTextPopUpempTitle;
    }

    public void setInputTextPopUpempTitle(HtmlInputText hit) {
        this.inputTextPopUpempTitle = hit;
    }
    private HtmlSelectOneMenu inputTextPopUpempTitleType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getInputTextPopUpempTitleType() {
        return inputTextPopUpempTitleType;
    }

    public void setInputTextPopUpempTitleType(HtmlSelectOneMenu hsom) {
        this.inputTextPopUpempTitleType = hsom;
    }
    private HtmlCommandButton btnempTitleAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnempTitleAdd() {
        return btnempTitleAdd;
    }

    public void setBtnempTitleAdd(HtmlCommandButton hcb) {
        this.btnempTitleAdd = hcb;
    }
    private HtmlCommandButton btnempTitleNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnempTitleNew() {
        return btnempTitleNew;
    }

    public void setBtnempTitleNew(HtmlCommandButton hcb) {
        this.btnempTitleNew = hcb;
    }
    private HtmlCommandButton btnempTitleSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnempTitleSave() {
        return btnempTitleSave;
    }

    public void setBtnempTitleSave(HtmlCommandButton hcb) {
        this.btnempTitleSave = hcb;
    }
    private HtmlCommandButton btnempTitleDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnempTitleDelete() {
        return btnempTitleDelete;
    }

    public void setBtnempTitleDelete(HtmlCommandButton hcb) {
        this.btnempTitleDelete = hcb;
    }
    private HtmlCommandButton btnempTitleCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnempTitleCancel() {
        return btnempTitleCancel;
    }

    public void setBtnempTitleCancel(HtmlCommandButton hcb) {
        this.btnempTitleCancel = hcb;
    }
    private HtmlPanelGroup panelGroupempTitleMsgBody1 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempTitleMsgBody1() {
        return panelGroupempTitleMsgBody1;
    }

    public void setPanelGroupempTitleMsgBody1(HtmlPanelGroup hpg) {
        this.panelGroupempTitleMsgBody1 = hpg;
    }
    private HtmlPanelGroup panelGroupempTitleMsgBody11 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempTitleMsgBody11() {
        return panelGroupempTitleMsgBody11;
    }

    public void setPanelGroupempTitleMsgBody11(HtmlPanelGroup hpg) {
        this.panelGroupempTitleMsgBody11 = hpg;
    }
    private PanelPopup empTitlePopUpMsg = new PanelPopup();

    public PanelPopup getEmpTitlePopUpMsg() {
        return empTitlePopUpMsg;
    }

    public void setEmpTitlePopUpMsg(PanelPopup pp) {
        this.empTitlePopUpMsg = pp;
    }
    private HtmlPanelGroup panelGroupempTitleMsgBody = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempTitleMsgBody() {
        return panelGroupempTitleMsgBody;
    }

    public void setPanelGroupempTitleMsgBody(HtmlPanelGroup hpg) {
        this.panelGroupempTitleMsgBody = hpg;
    }
    private HtmlPanelGroup panelGroupempTitleMsgBodyDelete = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempTitleMsgBodyDelete() {
        return panelGroupempTitleMsgBodyDelete;
    }

    public void setPanelGroupempTitleMsgBodyDelete(HtmlPanelGroup hpg) {
        this.panelGroupempTitleMsgBodyDelete = hpg;
    }
    private HtmlCommandButton buttonempTitleY = new HtmlCommandButton();

    public HtmlCommandButton getButtonempTitleY() {
        return buttonempTitleY;
    }

    public void setButtonempTitleY(HtmlCommandButton hcb) {
        this.buttonempTitleY = hcb;
    }
    private HtmlPanelGroup panelGroupempTitleMsgBodyButtons = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempTitleMsgBodyButtons() {
        return panelGroupempTitleMsgBodyButtons;
    }

    public void setPanelGroupempTitleMsgBodyButtons(HtmlPanelGroup hpg) {
        this.panelGroupempTitleMsgBodyButtons = hpg;
    }
    private PopupBean panelPopup1Bean4 = new PopupBean();

    public PopupBean getPanelPopup1Bean4() {
        return panelPopup1Bean4;
    }

    public void setPanelPopup1Bean4(PopupBean pb) {
        this.panelPopup1Bean4 = pb;
    }
    private DefaultTableDataModel dataTable1Model5 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model5() {
        return dataTable1Model5;
    }

    public void setDataTable1Model5(DefaultTableDataModel dtdm) {
        this.dataTable1Model5 = dtdm;
    }
    private RowSelector rowSelectorempTitleAdd = new RowSelector();

    public RowSelector getRowSelectorempTitleAdd() {
        return rowSelectorempTitleAdd;
    }

    public void setRowSelectorempTitleAdd(RowSelector rs) {
        this.rowSelectorempTitleAdd = rs;
    }
    private UIColumn column11 = new UIColumn();

    public UIColumn getColumn11() {
        return column11;
    }

    public void setColumn11(UIColumn uic) {
        this.column11 = uic;
    }
    private HtmlDataTable tblEducationType1 = new HtmlDataTable();

    public HtmlDataTable getTblEducationType1() {
        return tblEducationType1;
    }

    public void setTblEducationType1(HtmlDataTable hdt) {
        this.tblEducationType1 = hdt;
    }
    private PanelPopup popupAddEducationType = new PanelPopup();

    public PanelPopup getPopupAddEducationType() {
        return popupAddEducationType;
    }

    public void setPopupAddEducationType(PanelPopup pp) {
        this.popupAddEducationType = pp;
    }
    private HtmlInputText inputTextPopUpempEducation = new HtmlInputText();

    public HtmlInputText getInputTextPopUpempEducation() {
        return inputTextPopUpempEducation;
    }

    public void setInputTextPopUpempEducation(HtmlInputText hit) {
        this.inputTextPopUpempEducation = hit;
    }
    private RowSelector rowSelectorempEducationAdd = new RowSelector();

    public RowSelector getRowSelectorempEducationAdd() {
        return rowSelectorempEducationAdd;
    }

    public void setRowSelectorempEducationAdd(RowSelector rs) {
        this.rowSelectorempEducationAdd = rs;
    }
    private HtmlPanelGroup panelGroupempEducationMsgBodyDelete = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempEducationMsgBodyDelete() {
        return panelGroupempEducationMsgBodyDelete;
    }

    public void setPanelGroupempEducationMsgBodyDelete(HtmlPanelGroup hpg) {
        this.panelGroupempEducationMsgBodyDelete = hpg;
    }
    private HtmlCommandButton buttonempEducationY = new HtmlCommandButton();

    public HtmlCommandButton getButtonempEducationY() {
        return buttonempEducationY;
    }

    public void setButtonempEducationY(HtmlCommandButton hcb) {
        this.buttonempEducationY = hcb;
    }
    private HtmlCommandButton buttonempEducationN = new HtmlCommandButton();

    public HtmlCommandButton getButtonempEducationN() {
        return buttonempEducationN;
    }

    public void setButtonempEducationN(HtmlCommandButton hcb) {
        this.buttonempEducationN = hcb;
    }
    private HtmlPanelGroup panelGroupempEducationMsgBody11 = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempEducationMsgBody11() {
        return panelGroupempEducationMsgBody11;
    }

    public void setPanelGroupempEducationMsgBody11(HtmlPanelGroup hpg) {
        this.panelGroupempEducationMsgBody11 = hpg;
    }
    private HtmlPanelGroup panelGroupempEducationMsgBody = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempEducationMsgBody() {
        return panelGroupempEducationMsgBody;
    }

    public void setPanelGroupempEducationMsgBody(HtmlPanelGroup hpg) {
        this.panelGroupempEducationMsgBody = hpg;
    }
    private HtmlPanelGroup panelGroupempEducationMsgBodyButtons = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupempEducationMsgBodyButtons() {
        return panelGroupempEducationMsgBodyButtons;
    }

    public void setPanelGroupempEducationMsgBodyButtons(HtmlPanelGroup hpg) {
        this.panelGroupempEducationMsgBodyButtons = hpg;
    }
    private HtmlCommandButton btnempEducationAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnempEducationAdd() {
        return btnempEducationAdd;
    }

    public void setBtnempEducationAdd(HtmlCommandButton hcb) {
        this.btnempEducationAdd = hcb;
    }
    private HtmlCommandButton btnempEducationSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnempEducationSave() {
        return btnempEducationSave;
    }

    public void setBtnempEducationSave(HtmlCommandButton hcb) {
        this.btnempEducationSave = hcb;
    }
    private HtmlCommandButton btnempEducationDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnempEducationDelete() {
        return btnempEducationDelete;
    }

    public void setBtnempEducationDelete(HtmlCommandButton hcb) {
        this.btnempEducationDelete = hcb;
    }
    private HtmlCommandButton btnempEducationCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnempEducationCancel() {
        return btnempEducationCancel;
    }

    public void setBtnempEducationCancel(HtmlCommandButton hcb) {
        this.btnempEducationCancel = hcb;
    }
    HtmlInputText txtNameNewLanguageType = new HtmlInputText();
    private HtmlCommandButton btnSaveNewLanguageType = new HtmlCommandButton();
    private HtmlCommandButton btnempEducationNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnempEducationNew() {
        return btnempEducationNew;
    }

    public HtmlInputText getTxtNameNewLanguageType() {
        return txtNameNewLanguageType;
    }

    public void setTxtNameNewLanguageType(HtmlInputText txtNameNewLanguageType) {
        this.txtNameNewLanguageType = txtNameNewLanguageType;
    }

    public void setBtnempEducationNew(HtmlCommandButton hcb) {
        this.btnempEducationNew = hcb;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlInputText txtfDepartment = new HtmlInputText();

    public HtmlInputText getTxtfDepartment() {
        return txtfDepartment;
    }

    public void setTxtfDepartment(HtmlInputText hit) {
        this.txtfDepartment = hit;
    }
    private PopupBean panelPopup1Bean5 = new PopupBean();

    public PopupBean getPanelPopup1Bean5() {
        return panelPopup1Bean5;
    }

    public void setPanelPopup1Bean5(PopupBean pb) {
        this.panelPopup1Bean5 = pb;
    }
    private DefaultSelectedData defaultSelectedData54 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData54() {
        return defaultSelectedData54;
    }

    public void setDefaultSelectedData54(DefaultSelectedData dsd) {
        this.defaultSelectedData54 = dsd;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu drlRankId = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRankId() {
        return drlRankId;
    }

    public void setDrlRankId(HtmlSelectOneMenu hsom) {
        this.drlRankId = hsom;
    }
    private DefaultSelectedData defaultSelectedDataForPayGrade = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataForPayGrade() {
        return defaultSelectedDataForPayGrade;
    }

    public void setDefaultSelectedDataForPayGrade(DefaultSelectedData defaultSelectedDataForPayGrade) {
        this.defaultSelectedDataForPayGrade = defaultSelectedDataForPayGrade;
    }

    public String getSelectedEmployeedId() {
        return selectedEmployeedId;
    }

    public void setSelectedEmployeedId(String selectedEmployeedId) {
        this.selectedEmployeedId = selectedEmployeedId;
    }
    private DefaultSelectedData defaultSelectedData57 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData57() {
        return defaultSelectedData57;
    }

    public void setDefaultSelectedData57(DefaultSelectedData dsd) {
        this.defaultSelectedData57 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems17 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems17() {
        return selectOneMenu1DefaultItems17;
    }

    public void setSelectOneMenu1DefaultItems17(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems17 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems18 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems18() {
        return selectOneMenu1DefaultItems18;
    }

    public void setSelectOneMenu1DefaultItems18(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems18 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems19 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems19() {
        return selectOneMenu1DefaultItems19;
    }

    public void setSelectOneMenu1DefaultItems19(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems19 = dsia;
    }
    private HtmlSelectOneMenu drlPayGrade = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPayGrade() {
        return drlPayGrade;
    }

    public void setDrlPayGrade(HtmlSelectOneMenu hsom) {
        this.drlPayGrade = hsom;
    }
    private DefaultSelectedData defaultSelectedDataReligion = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataReligion() {
        return defaultSelectedDataReligion;
    }

    public void setDefaultSelectedDataReligion(DefaultSelectedData defaultSelectedDataReligion) {
        this.defaultSelectedDataReligion = defaultSelectedDataReligion;
    }
    private DefaultSelectedData defaultSelectedData58 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData58() {
        return defaultSelectedData58;
    }

    public void setDefaultSelectedData58(DefaultSelectedData dsd) {
        this.defaultSelectedData58 = dsd;
    }
    private HtmlSelectOneMenu drlNationality = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNationality() {
        return drlNationality;
    }

    public void setDrlNationality(HtmlSelectOneMenu hsom) {
        this.drlNationality = hsom;
    }
    private SelectInputDate txtDateOfBirth = new SelectInputDate();

    public SelectInputDate getCalBirthDate() {
        return txtDateOfBirth;
    }

    public void setTxtDateOfBirth(SelectInputDate sid) {
        this.txtDateOfBirth = sid;
    }
    private SelectInputDate calHireDate = new SelectInputDate();

    public SelectInputDate getCalHireDate() {
        return calHireDate;
    }

    public void setCalHireDate(SelectInputDate sid) {
        this.calHireDate = sid;
    }
    private SelectInputDate calFamilyDateOfBirth = new SelectInputDate();

    public SelectInputDate getCalFamilyDateOfBirth() {
        return calFamilyDateOfBirth;
    }

    public void setCalFamilyDateOfBirth(SelectInputDate sid) {
        this.calFamilyDateOfBirth = sid;
    }
    private SelectInputDate calEndEduc = new SelectInputDate();
    private SelectInputDate calStartEduc = new SelectInputDate();

    public SelectInputDate getCalEndEduc() {
        return calEndEduc;
    }

    public void setCalEndEduc(SelectInputDate calEndEduc) {
        this.calEndEduc = calEndEduc;
    }

    public SelectInputDate getCalStartEduc() {
        return calStartEduc;
    }

    public void setCalStartEduc(SelectInputDate calStartEduc) {
        this.calStartEduc = calStartEduc;
    }
    private SelectInputDate calExpEndDate = new SelectInputDate();

    public SelectInputDate getCalExpEndDate() {
        return calExpEndDate;
    }

    public void setCalExpEndDate(SelectInputDate sid) {
        this.calExpEndDate = sid;
    }
    private SelectInputDate calExpStartDate = new SelectInputDate();

    public SelectInputDate getCalExpStartDate() {
        return calExpStartDate;
    }

    public void setCalExpStartDate(SelectInputDate sid) {
        this.calExpStartDate = sid;
    }
    private HtmlSelectBooleanCheckbox cboShift = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboShift() {
        return cboShift;
    }

    public void setCboShift(HtmlSelectBooleanCheckbox hsbc) {
        this.cboShift = hsbc;
    }
    private HtmlSelectBooleanCheckbox cboOffice = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboOffice() {
        return cboOffice;
    }

    public void setCboOffice(HtmlSelectBooleanCheckbox hsbc) {

        this.cboOffice = hsbc;
    }
    private HtmlSelectBooleanCheckbox cboPermanent = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboPermanent() {
        return cboPermanent;
    }

    public void setCboPermanent(HtmlSelectBooleanCheckbox hsbc) {
        this.cboPermanent = hsbc;
    }
    private HtmlSelectBooleanCheckbox cboContract = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCboContract() {
        return cboContract;
    }

    public void setCboContract(HtmlSelectBooleanCheckbox hsbc) {
        this.cboContract = hsbc;
    }
    private HtmlSelectOneMenu drlGradingScale = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlGradingScale() {
        return drlGradingScale;
    }

    public void setDrlGradingScale(HtmlSelectOneMenu hsom) {
        this.drlGradingScale = hsom;
    }
    private HtmlInputText txtBirthDate = new HtmlInputText();

    public HtmlInputText getTxtBirthDate() {
        return txtBirthDate;
    }

    public void setTxtBirthDate(HtmlInputText hit) {
        this.txtBirthDate = hit;
    }
    private HtmlInputText txtRecruitmentDate = new HtmlInputText();

    public HtmlInputText getTxtRecruitmentDate() {
        return txtRecruitmentDate;
    }

    public void setTxtRecruitmentDate(HtmlInputText hit) {
        this.txtRecruitmentDate = hit;
    }
    private SelectInputDate calBirthDate = new SelectInputDate();
     private SelectInputDate calContractStartDate = new SelectInputDate();
      private SelectInputDate calContractEndDate = new SelectInputDate();

    public SelectInputDate getCalContractEndDate() {
        return calContractEndDate;
    }

    public void setCalContractEndDate(SelectInputDate calContractEndDate) {
        this.calContractEndDate = calContractEndDate;
    }

  

    public SelectInputDate getCalContractStartDate() {
        return calContractStartDate;
    }

    public void setCalContractStartDate(SelectInputDate calContractStartDate) {
        this.calContractStartDate = calContractStartDate;
    }

    public void setCalBirthDate(SelectInputDate sid) {
        this.calBirthDate = sid;
    }
    private HtmlSelectOneMenu drlReligion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReligion() {
        return drlReligion;
    }

    public void setDrlReligion(HtmlSelectOneMenu hsom) {
        this.drlReligion = hsom;
    }
    private SelectInputText txtSearchByName1 = new SelectInputText();

    public SelectInputText getTxtSearchByName1() {
        return txtSearchByName1;
    }

    public void setTxtSearchByName1(SelectInputText sit) {
        this.txtSearchByName1 = sit;
    }
    private DefaultSelectedData defaultSelectedDataSexMale = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataSexFemale = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataSexFemale() {
        return defaultSelectedDataSexFemale;
    }

    public void setDefaultSelectedDataSexFemale(DefaultSelectedData defaultSelectedDataSexFemale) {
        this.defaultSelectedDataSexFemale = defaultSelectedDataSexFemale;
    }

    public DefaultSelectedData getDefaultSelectedDataSexMale() {
        return defaultSelectedDataSexMale;
    }

    public void setDefaultSelectedDataSexMale(DefaultSelectedData defaultSelectedDataSexMale) {
        this.defaultSelectedDataSexMale = defaultSelectedDataSexMale;
    }
    private HtmlSelectBooleanCheckbox ckbSexFemale = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbSexFemale() {
        return ckbSexFemale;
    }

    public void setCkbSexFemale(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbSexFemale = hsbc;
    }

    public HtmlSelectBooleanCheckbox getCkbSexMale() {
        return ckbSexMale;
    }

    public void setCkbSexMale(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbSexMale = hsbc;
    }
    private HtmlInputText txtDispStartEducDate = new HtmlInputText();

    public HtmlInputText getTxtDispStartEducDate() {
        return txtDispStartEducDate;
    }

    public void setTxtDispStartEducDate(HtmlInputText hit) {
        this.txtDispStartEducDate = hit;
    }
    private HtmlInputText txtDispEndEducDate = new HtmlInputText();

    public HtmlInputText getTxtDispEndEducDate() {
        return txtDispEndEducDate;
    }

    public void setTxtDispEndEducDate(HtmlInputText hit) {
        this.txtDispEndEducDate = hit;
    }
    private HtmlOutputText popupempEducationCategory = new HtmlOutputText();

    public HtmlOutputText getPopupempEducationCategory() {
        return popupempEducationCategory;
    }

    public void setPopupempEducationCategory(HtmlOutputText hot) {
        this.popupempEducationCategory = hot;
    }
    private DefaultSelectedData defaultSelectedData59 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData59() {
        return defaultSelectedData59;
    }

    public void setDefaultSelectedData59(DefaultSelectedData dsd) {
        this.defaultSelectedData59 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbExperiencePermanent = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperiencePermanent() {
        return ckbExperiencePermanent;
    }

    public void setCkbExperiencePermanent(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperiencePermanent = hsbc;
    }
    private DefaultSelectedData defaultSelectedData60 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData60() {
        return defaultSelectedData60;
    }

    public void setDefaultSelectedData60(DefaultSelectedData dsd) {
        this.defaultSelectedData60 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbExperienceContract = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperienceContract() {
        return ckbExperienceContract;
    }

    public void setCkbExperienceContract(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperienceContract = hsbc;
    }
    private DefaultSelectedData defaultSelectedData61 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData61() {
        return defaultSelectedData61;
    }

    public void setDefaultSelectedData61(DefaultSelectedData dsd) {
        this.defaultSelectedData61 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbExperiencePrivate = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperiencePrivate() {
        return ckbExperiencePrivate;
    }

    public void setCkbExperiencePrivate(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperiencePrivate = hsbc;
    }
    private DefaultSelectedData defaultSelectedData62 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData62() {
        return defaultSelectedData62;
    }

    public void setDefaultSelectedData62(DefaultSelectedData dsd) {
        this.defaultSelectedData62 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbExperienceGovernmental = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbExperienceGovernmental() {
        return ckbExperienceGovernmental;
    }

    public void setCkbExperienceGovernmental(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbExperienceGovernmental = hsbc;
    }
    private DefaultSelectedData defaultSelectedData63 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData63() {
        return defaultSelectedData63;
    }

    public void setDefaultSelectedData63(DefaultSelectedData dsd) {
        this.defaultSelectedData63 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbFamilyAliveOrDied = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbFamilyAliveOrDied() {
        return ckbFamilyAliveOrDied;
    }

    public void setCkbFamilyAliveOrDied(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbFamilyAliveOrDied = hsbc;
    }
    private HtmlInputText txtDisplayedExpStartDate = new HtmlInputText();

    public HtmlInputText getTxtDisplayedExpStartDate() {
        return txtDisplayedExpStartDate;
    }

    public void setTxtDisplayedExpStartDate(HtmlInputText hit) {
        this.txtDisplayedExpStartDate = hit;
    }
    private HtmlInputText txtDisplayedExpEndDate = new HtmlInputText();

    public HtmlInputText getTxtDisplayedExpEndDate() {
        return txtDisplayedExpEndDate;
    }

    public void setTxtDisplayedExpEndDate(HtmlInputText hit) {
        this.txtDisplayedExpEndDate = hit;
    }
    private HtmlInputText txtFamilyBirthDate = new HtmlInputText();

    public HtmlInputText getTxtFamilyBirthDate() {
        return txtFamilyBirthDate;
    }

    public void setTxtFamilyBirthDate(HtmlInputText hit) {
        this.txtFamilyBirthDate = hit;
    }
    private DefaultSelectedData defaultSelectedData64 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData64() {
        return defaultSelectedData64;
    }

    public void setDefaultSelectedData64(DefaultSelectedData dsd) {
        this.defaultSelectedData64 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems20 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems20() {
        return selectOneMenu1DefaultItems20;
    }

    public void setSelectOneMenu1DefaultItems20(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems20 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems21 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems21() {
        return selectOneMenu1DefaultItems21;
    }

    public void setSelectOneMenu1DefaultItems21(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems21 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems22 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems22() {
        return selectOneMenu1DefaultItems22;
    }

    public void setSelectOneMenu1DefaultItems22(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems22 = dsia;
    }
    private HtmlInputText txtTinNumber = new HtmlInputText();

    public HtmlInputText getTxtTinNumber() {
        return txtTinNumber;
    }

    public void setTxtTinNumber(HtmlInputText hit) {
        this.txtTinNumber = hit;
    }
    private DefaultSelectedData defaultSelectedData65 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData65() {
        return defaultSelectedData65;
    }

    public void setDefaultSelectedData65(DefaultSelectedData dsd) {
        this.defaultSelectedData65 = dsd;
    }
    private HtmlSelectOneMenu drlProfessionInMugher = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlProfessionInMugher() {
        return drlProfessionInMugher;
    }

    public void setDrlProfessionInMugher(HtmlSelectOneMenu hsom) {
        this.drlProfessionInMugher = hsom;
    }
    private HtmlInputText txtTraEndDate = new HtmlInputText();

    public HtmlInputText getTxtTraEndDate() {
        return txtTraEndDate;
    }

    public void setTxtTraEndDate(HtmlInputText hit) {
        this.txtTraEndDate = hit;
    }
    private HtmlInputText txtTraStartDate = new HtmlInputText();

    public HtmlInputText getTxtTraStartDate() {
        return txtTraStartDate;
    }

    public void setTxtTraStartDate(HtmlInputText hit) {
        this.txtTraStartDate = hit;
    }
    private HtmlCommandButton btnAddTraining = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddTraining() {
        return btnAddTraining;
    }

    public void setBtnAddTraining(HtmlCommandButton hcb) {
        this.btnAddTraining = hcb;
    }
    private HtmlInputText txtTrainingName = new HtmlInputText();

    public HtmlInputText getTxtTrainingName() {
        return txtTrainingName;
    }

    public void setTxtTrainingName(HtmlInputText hit) {
        this.txtTrainingName = hit;
    }
    private DefaultSelectedData defaultSelectedData66 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData66() {
        return defaultSelectedData66;
    }

    public void setDefaultSelectedData66(DefaultSelectedData dsd) {
        this.defaultSelectedData66 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems23 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems23() {
        return selectOneMenu1DefaultItems23;
    }

    public void setSelectOneMenu1DefaultItems23(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems23 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems24 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems24() {
        return selectOneMenu1DefaultItems24;
    }

    public void setSelectOneMenu1DefaultItems24(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems24 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems25 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems25() {
        return selectOneMenu1DefaultItems25;
    }

    public void setSelectOneMenu1DefaultItems25(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems25 = dsia;
    }
    private DefaultSelectedData defaultSelectedData67 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData67() {
        return defaultSelectedData67;
    }

    public void setDefaultSelectedData67(DefaultSelectedData dsd) {
        this.defaultSelectedData67 = dsd;
    }
    private DefaultSelectedData defaultSelectedData68 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData68() {
        return defaultSelectedData68;
    }

    public void setDefaultSelectedData68(DefaultSelectedData dsd) {
        this.defaultSelectedData68 = dsd;
    }
    private HtmlSelectOneMenu drlInstitutionName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlInstitutionName() {
        return drlInstitutionName;
    }

    public void setDrlInstitutionName(HtmlSelectOneMenu hsom) {
        this.drlInstitutionName = hsom;
    }
    private HtmlSelectOneMenu drlSponsoredBy = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlSponsoredBy() {
        return drlSponsoredBy;
    }

    public void setDrlSponsoredBy(HtmlSelectOneMenu hsom) {
        this.drlSponsoredBy = hsom;
    }
    private HtmlCommandButton btnTrainingNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingNew() {
        return btnTrainingNew;
    }

    public void setBtnTrainingNew(HtmlCommandButton hcb) {
        this.btnTrainingNew = hcb;
    }
    private HtmlCommandButton btnTrainingSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingSave() {
        return btnTrainingSave;
    }

    public void setBtnTrainingSave(HtmlCommandButton hcb) {
        this.btnTrainingSave = hcb;
    }
    private HtmlCommandButton btnTrainingEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingEdit() {
        return btnTrainingEdit;
    }

    public void setBtnTrainingEdit(HtmlCommandButton hcb) {
        this.btnTrainingEdit = hcb;
    }
    private HtmlCommandButton btnTrainingUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingUpdate() {
        return btnTrainingUpdate;
    }

    public void setBtnTrainingUpdate(HtmlCommandButton hcb) {
        this.btnTrainingUpdate = hcb;
    }
    private HtmlCommandButton btnTrainingReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingReset() {
        return btnTrainingReset;
    }

    public void setBtnTrainingReset(HtmlCommandButton hcb) {
        this.btnTrainingReset = hcb;
    }
    private HtmlCommandButton btnTrainingDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnTrainingDelete() {
        return btnTrainingDelete;
    }

    public void setBtnTrainingDelete(HtmlCommandButton hcb) {
        this.btnTrainingDelete = hcb;
    }
    private HtmlOutputLabel lblTrainingFullName = new HtmlOutputLabel();

    public HtmlOutputLabel getLblTrainingFullName() {
        return lblTrainingFullName;
    }

    public void setLblTrainingFullName(HtmlOutputLabel hol) {
        this.lblTrainingFullName = hol;
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
    private DefaultSelectedData defaultSelectedData69 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData69() {
        return defaultSelectedData69;
    }

    public void setDefaultSelectedData69(DefaultSelectedData dsd) {
        this.defaultSelectedData69 = dsd;
    }
    private HtmlSelectBooleanCheckbox ckbUsethisExperienceforLeave = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbUsethisExperienceforLeave() {
        return ckbUsethisExperienceforLeave;
    }

    public void setCkbUsethisExperienceforLeave(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbUsethisExperienceforLeave = hsbc;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private PanelPopup pnlPopUpDateSettingForContractEmployee = new PanelPopup();

    public PanelPopup getPnlPopUpDateSettingForContractEmployee() {
        return pnlPopUpDateSettingForContractEmployee;
    }

    public void setPnlPopUpDateSettingForContractEmployee(PanelPopup pp) {
        this.pnlPopUpDateSettingForContractEmployee = pp;
    }
    private HtmlInputText txtCotractStartDate = new HtmlInputText();

    public HtmlInputText getTxtCotractStartDate() {
        return txtCotractStartDate;
    }

    public void setTxtCotractStartDate(HtmlInputText hit) {
        this.txtCotractStartDate = hit;
    }
    private HtmlInputText txtfContractEndDate = new HtmlInputText();

    public HtmlInputText getTxtfContractEndDate() {
        return txtfContractEndDate;
    }

    public void setTxtfContractEndDate(HtmlInputText hit) {
        this.txtfContractEndDate = hit;
    }
    private HtmlOutputText lblRemainingDayes = new HtmlOutputText();

    public HtmlOutputText getLblRemainingDayes() {
        return lblRemainingDayes;
    }

    public void setLblRemainingDayes(HtmlOutputText hot) {
        this.lblRemainingDayes = hot;
    }
    private HtmlCommandButton btnSaveContract = new HtmlCommandButton();

    public HtmlCommandButton getBtnSaveContract() {
        return btnSaveContract;
    }

    public void setBtnSaveContract(HtmlCommandButton hcb) {
        this.btnSaveContract = hcb;
    }
    private HtmlCommandButton btnEditContract = new HtmlCommandButton();

    public HtmlCommandButton getBtnEditContract() {
        return btnEditContract;
    }

    public void setBtnEditContract(HtmlCommandButton hcb) {
        this.btnEditContract = hcb;
    }
    private HtmlCommandButton btnUpdateContract = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdateContract() {
        return btnUpdateContract;
    }

    public void setBtnUpdateContract(HtmlCommandButton hcb) {
        this.btnUpdateContract = hcb;
    }
    private HtmlCommandButton btnCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnCancel() {
        return btnCancel;
    }

    public void setBtnCancel(HtmlCommandButton hcb) {
        this.btnCancel = hcb;
    }
    private HtmlCommandButton bntCotractStartDate = new HtmlCommandButton();

    public HtmlCommandButton getBntCotractStartDate() {
        return bntCotractStartDate;
    }

    public void setBntCotractStartDate(HtmlCommandButton hcb) {
        this.bntCotractStartDate = hcb;
    }
    private HtmlCommandButton bntCotractEndDate = new HtmlCommandButton();

    public HtmlCommandButton getBntCotractEndDate() {
        return bntCotractEndDate;
    }

    public void setBntCotractEndDate(HtmlCommandButton hcb) {
        this.bntCotractEndDate = hcb;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private DefaultSelectedData defaultSelectedData70 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData70() {
        return defaultSelectedData70;
    }

    public void setDefaultSelectedData70(DefaultSelectedData dsd) {
        this.defaultSelectedData70 = dsd;
    }
    private DefaultSelectedData defaultSelectedData71 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData71() {
        return defaultSelectedData71;
    }

    public void setDefaultSelectedData71(DefaultSelectedData dsd) {
        this.defaultSelectedData71 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems13 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems13() {
        return selectOneMenu2DefaultItems13;
    }

    public void setSelectOneMenu2DefaultItems13(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems13 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems14 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems14() {
        return selectOneMenu2DefaultItems14;
    }

    public void setSelectOneMenu2DefaultItems14(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems14 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems15 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems15() {
        return selectOneMenu2DefaultItems15;
    }

    public void setSelectOneMenu2DefaultItems15(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems15 = dsia;
    }
    private DefaultSelectedData defaultSelectedData72 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData72() {
        return defaultSelectedData72;
    }

    public void setDefaultSelectedData72(DefaultSelectedData dsd) {
        this.defaultSelectedData72 = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData73 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData73() {
        return defaultSelectedData73;
    }

    public void setDefaultSelectedData73(DefaultSelectedData dsd) {
        this.defaultSelectedData73 = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems() {
        return selectOneMenu4DefaultItems;
    }

    public void setSelectOneMenu4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems = dsi;
    }
    private DefaultSelectedData defaultSelectedData74 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData74() {
        return defaultSelectedData74;
    }

    public void setDefaultSelectedData74(DefaultSelectedData dsd) {
        this.defaultSelectedData74 = dsd;
    }
    private DefaultSelectedData defaultSelectedData75 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData75() {
        return defaultSelectedData75;
    }

    public void setDefaultSelectedData75(DefaultSelectedData dsd) {
        this.defaultSelectedData75 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calContratTerminationDate = new SelectInputDate();

    public SelectInputDate getCalContratTerminationDate() {
        return calContratTerminationDate;
    }

    public void setCalContratTerminationDate(SelectInputDate sid) {
        this.calContratTerminationDate = sid;
    }
    private HtmlInputText txtContractTerminationDate = new HtmlInputText();

    public HtmlInputText getTxtContractTerminationDate() {
        return txtContractTerminationDate;
    }

    public void setTxtContractTerminationDate(HtmlInputText hit) {
        this.txtContractTerminationDate = hit;
    }
    private HtmlInputTextarea txtTerminationRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtTerminationRemark() {
        return txtTerminationRemark;
    }

    public void setTxtTerminationRemark(HtmlInputTextarea hit) {
        this.txtTerminationRemark = hit;
    }
    private PanelPopup popContractTermination = new PanelPopup();

    public PanelPopup getPopContractTermination() {
        return popContractTermination;
    }

    public void setPopContractTermination(PanelPopup pp) {
        this.popContractTermination = pp;
    }
    private PanelPopup pnMessageForEmployeeStatus = new PanelPopup();

    public PanelPopup getPnMessageForEmployeeStatus() {
        return pnMessageForEmployeeStatus;
    }

    public void setPnMessageForEmployeeStatus(PanelPopup pp) {
        this.pnMessageForEmployeeStatus = pp;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage1EmployeeStatus = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage1EmployeeStatus() {
        return lblFormMessage1EmployeeStatus;
    }

    public void setLblFormMessage1EmployeeStatus(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage1EmployeeStatus = hol;
    }
    private HtmlInputText txtDuration = new HtmlInputText();

    public HtmlInputText getTxtDuration() {
        return txtDuration;
    }

    public void setTxtDuration(HtmlInputText hit) {
        this.txtDuration = hit;
    }
    private DefaultSelectedData defaultSelectedData76 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData76() {
        return defaultSelectedData76;
    }

    public void setDefaultSelectedData76(DefaultSelectedData dsd) {
        this.defaultSelectedData76 = dsd;
    }
    private DefaultTableDataModel dataTable1Model6 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model6() {
        return dataTable1Model6;
    }

    public void setDataTable1Model6(DefaultTableDataModel dtdm) {
        this.dataTable1Model6 = dtdm;
    }
    private HtmlSelectOneMenu ddnFileType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDdnFileType() {
        return ddnFileType;
    }

    public void setDdnFileType(HtmlSelectOneMenu hsom) {
        this.ddnFileType = hsom;
    }
    private HtmlInputText txtFileName = new HtmlInputText();

    public HtmlInputText getTxtFileName() {
        return txtFileName;
    }

    public void setTxtFileName(HtmlInputText hit) {
        this.txtFileName = hit;
    }
    private InputFile fileUploadAttached = new InputFile();

    public InputFile getFileUploadAttached() {
        return fileUploadAttached;
    }

    public void setFileUploadAttached(InputFile if0) {
        this.fileUploadAttached = if0;
    }
    private HtmlInputTextarea txtFileRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtFileRemark() {
        return txtFileRemark;
    }

    public void setTxtFileRemark(HtmlInputTextarea hit) {
        this.txtFileRemark = hit;
    }
    private HtmlCommandButton btnFileNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileNew() {
        return btnFileNew;
    }

    public void setBtnFileNew(HtmlCommandButton hcb) {
        this.btnFileNew = hcb;
    }
    private HtmlCommandButton btnFileEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileEdit() {
        return btnFileEdit;
    }

    public void setBtnFileEdit(HtmlCommandButton hcb) {
        this.btnFileEdit = hcb;
    }
    private HtmlCommandButton btnFileSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileSave() {
        return btnFileSave;
    }

    public void setBtnFileSave(HtmlCommandButton hcb) {
        this.btnFileSave = hcb;
    }
    private HtmlCommandButton btnFileReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileReset() {
        return btnFileReset;
    }

    public void setBtnFileReset(HtmlCommandButton hcb) {
        this.btnFileReset = hcb;
    }
    private HtmlCommandButton btnFileDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileDelete() {
        return btnFileDelete;
    }

    public void setBtnFileDelete(HtmlCommandButton hcb) {
        this.btnFileDelete = hcb;
    }
    private HtmlCommandButton btnFileUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnFileUpdate() {
        return btnFileUpdate;
    }

    public void setBtnFileUpdate(HtmlCommandButton hcb) {
        this.btnFileUpdate = hcb;
    }
    private HtmlCommandButton btnAddFileTbl = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddFileTbl() {
        return btnAddFileTbl;
    }

    public void setBtnAddFileTbl(HtmlCommandButton hcb) {
        this.btnAddFileTbl = hcb;
    }
    private HtmlDataTable dataTablFile = new HtmlDataTable();

    public HtmlDataTable getDataTablFile() {
        return dataTablFile;
    }

    public void setDataTablFile(HtmlDataTable hdt) {
        this.dataTablFile = hdt;
    }
    private PanelCollapsible panelCollapsible1 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible1() {
        return panelCollapsible1;
    }

    public void setPanelCollapsible1(PanelCollapsible pc) {
        this.panelCollapsible1 = pc;
    }
    private PanelCollapsible panelCollapsible3 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible3() {
        return panelCollapsible3;
    }

    public void setPanelCollapsible3(PanelCollapsible pc) {
        this.panelCollapsible3 = pc;
    }
    private DefaultSelectedData defaultSelectedData77 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData77() {
        return defaultSelectedData77;
    }

    public void setDefaultSelectedData77(DefaultSelectedData dsd) {
        this.defaultSelectedData77 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choIsCrimeFree = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoIsCrimeFree() {
        return choIsCrimeFree;
    }

    public void setChoIsCrimeFree(HtmlSelectBooleanCheckbox hsbc) {
        this.choIsCrimeFree = hsbc;
    }
    private HtmlSelectBooleanCheckbox choIsMedicallyFit = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoIsMedicallyFit() {
        return choIsMedicallyFit;
    }

    public void setChoIsMedicallyFit(HtmlSelectBooleanCheckbox hsbc) {
        this.choIsMedicallyFit = hsbc;
    }
    private DefaultSelectedData defaultSelectedData78 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData78() {
        return defaultSelectedData78;
    }

    public void setDefaultSelectedData78(DefaultSelectedData dsd) {
        this.defaultSelectedData78 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems26 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems26() {
        return selectOneMenu1DefaultItems26;
    }

    public void setSelectOneMenu1DefaultItems26(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems26 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems27 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems27() {
        return selectOneMenu1DefaultItems27;
    }

    public void setSelectOneMenu1DefaultItems27(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems27 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems28 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems28() {
        return selectOneMenu1DefaultItems28;
    }

    public void setSelectOneMenu1DefaultItems28(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems28 = dsia;
    }
    private HtmlSelectOneMenu drlEmpTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEmpTitle() {
        return drlEmpTitle;
    }

    public void setDrlEmpTitle(HtmlSelectOneMenu hsom) {
        this.drlEmpTitle = hsom;
    }
    private DefaultSelectedData defaultSelectedData79 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData79() {
        return defaultSelectedData79;
    }

    public void setDefaultSelectedData79(DefaultSelectedData dsd) {
        this.defaultSelectedData79 = dsd;
    }
    private HtmlSelectOneMenu drlLocation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLocation() {
        return drlLocation;
    }

    public void setDrlLocation(HtmlSelectOneMenu hsom) {
        this.drlLocation = hsom;
    }
    private HtmlInputText txt_Sefere = new HtmlInputText();

    public HtmlInputText getTxt_Sefere() {
        return txt_Sefere;
    }

    public void setTxt_Sefere(HtmlInputText hit) {
        this.txt_Sefere = hit;
    }
    private HtmlInputText txt_phone_no = new HtmlInputText();

    public HtmlInputText getTxt_phone_no() {
        return txt_phone_no;
    }

    public void setTxt_phone_no(HtmlInputText hit) {
        this.txt_phone_no = hit;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink cmd_instiutation = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getCmd_instiutation() {
        return cmd_instiutation;
    }

    public void setCmd_instiutation(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.cmd_instiutation = hcl;
    }
    private com.icesoft.faces.component.ext.HtmlCommandLink cmd_locationNew = new com.icesoft.faces.component.ext.HtmlCommandLink();

    public com.icesoft.faces.component.ext.HtmlCommandLink getCmd_locationNew() {
        return cmd_locationNew;
    }

    public void setCmd_locationNew(com.icesoft.faces.component.ext.HtmlCommandLink hcl) {
        this.cmd_locationNew = hcl;
    }
//

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public EmployeePage() {
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
        this.getListOfExpUpdate().clear();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        this.getListOfExperience().clear();
        this.getListOfEducation().clear();
        this.getListOfEducationUpdate().clear();
        disableTrainingComponents();
        this.listOfLanguage.clear();
        this.listOfLanguageUpdate.clear();
        this.getListOfExpUpdate().clear();
        this.getListOfExperience().clear();
        this.setRegionOpt(lookUpManager.readRegion());
        btnFaDelete.setDisabled(true);
        btnFaUpdate.setDisabled(true);
        btnFaSave.setDisabled(true);
        btnAddAddress.setDisabled(true);
        inputmemberPhoto.setDisabled(true);
        btnFaAdd.setDisabled(true);
        ///////////////////////////////////////////Address Buttons//////////////////////////
        btnAddAddress.setDisabled(true);
        btnADEdit.setDisabled(true);
        btnADDelete.setDisabled(true);
        btnADNew.setDisabled(false);
        btnADReset.setDisabled(true);
        btnADSave.setDisabled(true);
        btnADUpdate.setDisabled(true);

        ///////////////////////////Family Buttons///////////////////////////////
        this.setNation(lookUpManager.onDisplayNation());
        this.set_job(departmentManage.onDisplayJob());
        this.setPayGradeOpt(lookUpManager.readPayGrade(null));

        this.setWoredaList(lookUpManager.readZoneOrCityInARegion(null));
        ///////////////////////////////////Apperance Buttons//////////////////////////////
        btnAPNew.setDisabled(false);
        btnAPSave.setDisabled(true);
        btnAPEdit.setDisabled(true);
        btnApDelete.setDisabled(true);
        btnAPReset.setDisabled(true);
        ///////////////////////////////////////////Education Button//////////////////////////////////////
        btnEDNew.setDisabled(false);
        btnEDSave.setDisabled(true);
        btnEDEdit.setDisabled(true);
        btnEDUpdate.setDisabled(true);
        btnEDDelete.setDisabled(true);
        btnEDReset.setDisabled(true);
        cmdEducationAdd.setDisabled(true);
        /////////////////////////////////////////////Language buttons///////////////////////////////////////
        disableLanguageComponents();
        btnLANew.setDisabled(false);
        btnLASave.setDisabled(true);
        btnLAEdit.setDisabled(true);
        btnLAUpdate.setDisabled(true);
        btnLAReset.setDisabled(true);
        btnLADelete.setDisabled(true);
        btnLAAdd.setDisabled(true);
        cmdLanguageEdit.setDisabled(true);
        ///////////////////////////////////////////////Experance Buttons//////////////////////////////////////////////////
        btnEXNew.setDisabled(false);
        btnEXSave.setDisabled(true);
        btnEXEdit.setDisabled(true);
        btnEXUpdate.setDisabled(true);
        btnEXReset.setDisabled(true);
        btnEXDelete.setDisabled(true);
        btnAddExperience.setDisabled(true);
        // colFamilyTable.setImmediate(true);
        disablComponentsFa();
        clearComponentsFa();
        clearComponents();
        disableAddressComponents();
        clearComponentsAddress();
        clearApperanceComponents();
        disableApperanceComponents();
        clearEducationComponents();
        disableEducationComponents();
        this.clearLanguageComponents();
        this.disableLanguageComponents();
        this.clearLanguageComponents();
        this.disableLanguageComponents();
        this.clearExperianceComponents();
        this.disableExperianceComponents();
        lblTotalEmp1.setValue("Code");
        /////////////////////////////////////////   training //////////////////////////////////
        btnTrainingNew.setDisabled(false);
        btnTrainingSave.setDisabled(true);
        btnTrainingEdit.setDisabled(true);
        btnTrainingUpdate.setDisabled(true);
        btnTrainingReset.setDisabled(true);
        btnTrainingDelete.setDisabled(true);
        btnAddTraining.setDisabled(true);
        this.setFileType(employeeFileManager.readFileType());
        //////////////////////////////////////////////////////////////////////////////////////
        this.set_title(lookUpManager.assignTitleDesc());
        _jobRank = lookUpManager.assignJobRank();
        religionName = employeeManager.getReligionList();
        super.init();
        try {
            ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();
            this.realImageFilePath = theApplicationsServletContext.getRealPath(IMAGE_URL);
            maritalstatus = lookUpManager.assignMaritalStatus();
            if (nationalityName.isEmpty() || (lookUpManger.getEmpitiedTableList() != null &&
                    lookUpManger.getEmpitiedTableList().contains("hr_lu_nationality"))) {
                nationalityName = lookUpManager.getNationalityName();
                lookUpManger.getEmpitiedTableList().remove("hr_lu_nationality");
            }

            if (nation.isEmpty() || (lookUpManger.getEmpitiedTableList() != null &&
                    lookUpManger.getEmpitiedTableList().contains("hr_lu_nation"))) {
                nation = lookUpManager.assignNation();
                lookUpManger.getEmpitiedTableList().remove("hr_lu_nation");
            }
            nation = lookUpManager.assignNation();
            if (_title.isEmpty() || (lookUpManger.getEmpitiedTableList() != null &&
                    lookUpManger.getEmpitiedTableList().contains("hr_lu_title"))) {
                this.set_title(lookUpManager.assignTitle());
                lookUpManger.getEmpitiedTableList().remove("hr_lu_title");
            }

        } catch (Exception ex) {
        }
        this.disableComponents();
        try {
            _init();
        } catch (Exception e) {
            log("Employee Paye Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }



    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    private DefaultMutableTreeNode addNode(DefaultMutableTreeNode parent,
            String title, String DPlan) {
        DefaultMutableTreeNode node = new DefaultMutableTreeNode();
        IceUserObject userObject = new IceUserObject(node);

        userObject.setLeafIcon("../xmlhttp/css/rime/css-images/tree_document.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_folder_closed.gif");
        userObject.setBranchExpandedIcon("../xmlhttp/css/rime/css-images/tree_folder_open.gif");
        userObject.setBranchContractedIcon("../xmlhttp/css/rime/css-images/tree_nav_bottom_close.gif");
        userObject.setExpanded(false);

        node.setUserObject(userObject);
        //userObject.setTreeNode(employee);
        //branch
        if (title != null) {
            userObject.setText(title);
            userObject.setLeaf(false);
            userObject.setExpanded(false);
            node.setAllowsChildren(true);
        } // leaf node
        else {
            userObject.setText(DPlan);
            userObject.setLeaf(true);
            node.setAllowsChildren(false);
        }
        // finally add the node to the parent.
        if (parent != null) {
            parent.add(node);
        }

        return node;
    }

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
//        cmdAdSave.setStyle("margintext-decoration:line-through;");
//       getApplicationBean1().maritalStatusCode();
        //addressTypeList;

//        txtMidelName.setRequired(true);
//        txtLastName.setRequired(true);
//        txtDateOfBirth.setRequired(true);
//        drlNationality.setRequired(true);
//
//        drlReligion.setRequired(true);
//        drlNation.setRequired(true);
//        drlRankId.setRequired(true);
//        drlTitle.setRequired(true);
//        drlEmpTitle.setRequired(true);
//        txtSalary.setRequired(true);
//        calHireDate.setRequired(true);
//        txtRetirementNo.setRequired(true);
//        txtTinNumber.setRequired(true);
//        drlMaritalStatus.setRequired(true);
//        txtFirstName.setRequired(true);
//        drlPayGrade.setRequired(true);
//        txtfDepartment.setRequired(true);
//        txtMidelName.setRequiredMessage("Required");
//        txtLastName.setRequiredMessage("Required");
//        txtDateOfBirth.setRequiredMessage("Required");
//        drlNationality.setRequiredMessage("Required");
//        drlReligion.setRequiredMessage("Required");
//        drlNation.setRequiredMessage("Required");
//        drlRankId.setRequiredMessage("Required");
//        drlTitle.setRequiredMessage("Required");
//        drlEmpTitle.setRequiredMessage("Required");
//        txtSalary.setRequiredMessage("Required");
//        calHireDate.setRequiredMessage("Required");
//        txtRetirementNo.setRequiredMessage("Required");
//        txtTinNumber.setRequiredMessage("Required");
//        drlMaritalStatus.setRequiredMessage("Required");
//        txtFirstName.setRequiredMessage("Required");
//        drlPayGrade.setRequiredMessage("Required");
//        txtfDepartment.setRequiredMessage("Required");
//        drlRelationType.setRequired(true);
//        txtFamilyFirstName.setRequired(true);
//        txtFamilyMiddleName.setRequired(true);
//        txtFamilyLastName.setRequired(true);
//        //txtFamilyDateOfBirth.setRequired(true);
//        drlRelationType.setRequiredMessage("Required");
//        txtFamilyFirstName.setRequiredMessage("Required");
//        txtFamilyMiddleName.setRequiredMessage("Required");
//        txtFamilyLastName.setRequiredMessage("Required");

//////////////////////////////Address type///////////////////////////
        drlAddressType.setRequiredMessage("Required");
        drlAddressType.setRequired(true);
        drlRegion.setRequiredMessage("Required");
        drlRegion.setRequired(true);
        drlWoreda.setRequiredMessage("Required");
        drlWoreda.setRequired(true);
        drlZone.setRequiredMessage("Required");
        drlZone.setRequired(true);
        /////////////////////////Apperance//////////////////////////////
        txtHeight.setRequiredMessage("Required");
        txtHeight.setRequired(true);
        txtWeight.setRequiredMessage("Required");
        txtWeight.setRequired(true);
        txtEyeColor.setRequiredMessage("Required");
        txtEyeColor.setRequired(true);

        ////////////////////////////Education//////////////////////////
//        drlLevelOfEducation.setRequiredMessage("Required");
//        drlLevelOfEducation.setRequired(true);
//        drlTypesOfEducation.setRequiredMessage("Required");
//        drlTypesOfEducation.setRequired(true);
//        txtaward.setRequiredMessage("Required");
//        txtaward.setRequired(true);
        /////////////////////////////Language////////////////////////////////////
        drlLanguageType.setRequiredMessage("Required");
        drlLanguageType.setRequired(true);
        drlListening.setRequiredMessage("Required");
        drlListening.setRequired(true);
        drlSpeaking.setRequiredMessage("Required");
        drlSpeaking.setRequired(true);
        drlWriting.setRequiredMessage("Required");
        drlWriting.setRequired(true);
        drlReading.setRequiredMessage("Required");
        drlReading.setRequired(true);
        //////////////////////////////////////Experiance///////////////////////////
        txtExperianceInstitution.setRequiredMessage("Required");
        txtExperianceInstitution.setRequired(true);
       // txtExperanceSalary.setRequiredMessage("Required");
       // txtExperanceSalary.setRequired(true);
        txtJobType.setRequiredMessage("Required");
        txtJobType.setRequired(true);
      //  txtExRank.setRequiredMessage("Required");
       // txtExRank.setRequired(true);
        calExpStartDate.setRequiredMessage("Required");
        calExpStartDate.setRequired(true);
        calExpEndDate.setRequiredMessage("Required");
        calExpEndDate.setRequired(true);
        txtTermination.setRequiredMessage("Required");
        txtTermination.setRequired(true);
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>
     * ()</code> was called (regardless of whether
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

    private void enableAllNewButtons() {
        btnFamilyNew.setDisabled(false);
        btnADNew.setDisabled(false);
        btnEDNew.setDisabled(false);
        btnLANew.setDisabled(false);
        btnEXNew.setDisabled(false);
    }

    private void disableComponents() {
        drlTitle.setDisabled(true);
        drlEmpTitle.setDisabled(true);
        txtFirstName.setDisabled(true);
        txtLastName.setDisabled(true);
        txtMidelName.setDisabled(true);
        txtDateOfBirth.setDisabled(true);
        drlMaritalStatus.setDisabled(true);
        drlNationality.setDisabled(true);
        drlReligion.setDisabled(true);
        drlNation.setDisabled(true);
        calHireDate.setDisabled(true);
        txtRetirementNo.setDisabled(true);
        txtTinNumber.setDisabled(true);
        txtfDepartment.setDisabled(true);
        drlJobCode.setDisabled(true);
        drlRankId.setDisabled(true);
        drlPayGrade.setDisabled(true);
        txtSalary.setDisabled(true);
        inputPhoto.setDisabled(true);
        btnDelete.setDisabled(true);
        ckbSexFemale.setDisabled(true);
        ckbSexMale.setDisabled(true);
        drlLocation.setDisabled(true);
        cboContract.setDisabled(true);
        cboPermanent.setDisabled(true);
    }

    private void enableComponents() {
        drlTitle.setDisabled(false);
        drlEmpTitle.setDisabled(false);
        txtFirstName.setDisabled(false);
        txtLastName.setDisabled(false);
        txtMidelName.setDisabled(false);
        txtDateOfBirth.setDisabled(false);
        drlMaritalStatus.setDisabled(false);
        drlNationality.setDisabled(false);
        drlReligion.setDisabled(false);
        drlNation.setDisabled(false);
        calHireDate.setDisabled(false);
        txtRetirementNo.setDisabled(false);
        txtTinNumber.setDisabled(false);
        txtfDepartment.setDisabled(false);
        drlJobCode.setDisabled(false);
        drlRankId.setDisabled(false);
        drlPayGrade.setDisabled(false);
        inputPhoto.setDisabled(false);
        btnReset.setDisabled(false);
        btnDelete.setDisabled(false);
        ckbSexFemale.setDisabled(false);
        ckbSexMale.setDisabled(false);
        drlLocation.setDisabled(false);
        cboContract.setDisabled(false);
        cboPermanent.setDisabled(false);
    }

    void clearComponentsFa() {
        txtFamilyBirthDate.setValue("");
        dataIsOnEditFamily = "NO";
        drlRelationType.setValue("");
        calFamilyDateOfBirth.resetValue();
        txtFamilyFirstName.setValue("");
        txtFamilyLastName.setValue("");
        txtFamilyMiddleName.setValue("");
        chkMale.setSelected(false);
        chkFemale.setSelected(false);
        choEmergenceyContact.setSelected(false);
        cobHeir.setSelected(false);
        ckbFamilyAliveOrDied.setSelected(false);

    }

    void enableComponentsFa() {
        drlRelationType.setDisabled(false);
        calFamilyDateOfBirth.setDisabled(false);
        txtFamilyBirthDate.setDisabled(false);
        txtFamilyFirstName.setDisabled(false);
        txtFamilyLastName.setDisabled(false);
        txtFamilyMiddleName.setDisabled(false);
        chkMale.setDisabled(false);
        chkFemale.setDisabled(false);
        cobHeir.setDisabled(false);
        ckbFamilyAliveOrDied.setDisabled(false);
        choEmergenceyContact.setDisabled(false);
        inputmemberPhoto.setDisabled(false);
    }

    void disablComponentsFa() {
        drlRelationType.setDisabled(true);
        txtFamilyBirthDate.setDisabled(true);
        calFamilyDateOfBirth.setDisabled(true);
        txtFamilyFirstName.setDisabled(true);
        txtFamilyLastName.setDisabled(true);
        txtFamilyMiddleName.setDisabled(true);
        chkMale.setDisabled(true);
        chkFemale.setDisabled(true);
        cobHeir.setDisabled(true);
        ckbFamilyAliveOrDied.setDisabled(true);
        choEmergenceyContact.setDisabled(true);


    }

    private void clearComponents() {
        calHireDate.resetValue();
        ckbSexFemale.setSelected(false);
        ckbSexMale.setSelected(false);
        cboOffice.setSelected(false);
        cboShift.setSelected(false);
        drlTitle.resetValue();
        drlEmpTitle.resetValue();
        drlJobCode.resetValue();
        drlMaritalStatus.resetValue();
        drlNation.resetValue();
        drlNationality.resetValue();
        drlPayGrade.resetValue();
        drlRankId.resetValue();
        drlReligion.resetValue();
        drlTitle.setValue("");
        drlEmpTitle.setValue("");
        drlJobCode.setValue("");
        drlMaritalStatus.setValue("");
        drlNation.setValue("");
        drlNationality.setValue("");
        drlPayGrade.setValue("");
        drlRankId.setValue("");
        drlReligion.setValue("");
//        defaultSelectedDataForPayGrade.setSelectedObject(null);
        imgMember.setValue("");
        imgMember.setValue("");
        inputPhoto.setValue("");
        txtBirthDate.setValue(null);
        txtDateOfBirth.resetValue();
        txtfDepartment.resetValue();
        txtFEmployeeId.resetValue();
        txtFirstName.resetValue();
        txtLastName.resetValue();
        txtMidelName.resetValue();
        txtRecruitmentDate.setValue(null);
        txtRetirementNo.setValue("000000");
        txtTinNumber.resetValue();
        txtSalary.resetValue();
        imgMember.setValue("");
        defaultSelectedData79.setSelectedObject(null);
    }

//            employeeManager.loadEmpoyeeProfile(txtFEmployeeId.getValue().toString().trim());
    public void drlNationality_processValueChange(ValueChangeEvent vce) {

        if (vce.getNewValue() != null) {
            this.setNation(lookUpManager.assignNation());
        }
    }

    public void drlDepartment_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                this.setPerofation(departmentManage.readJobCode(vce.getNewValue().toString()));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlRankId_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            drlPayGrade.setDisabled(false);
            this.setPayGradeOpt(lookUpManager.readPayGrade(drlRankId.getValue().toString()));
        }

    }

    public String savePersonalInformation(int perform) {
        try {

        boolean hasError = false;
        int validationResult = 0;
        lblPhoto.setRendered(false);
        int checkSave = 0;
        String empId = "";
        String title = "";
        String firstName = "";
        String midelName = "";
        String lastName = "";
        String sex = "";
        String dateOfBirth = "";
        String maritalStatus = "";
        String nationality = "";
        String religion = "";
        String nation = "";
        String hireDate = "";
        String retirementNo = "";
        String department = "";
        String jobCode = "";
        String rankId = "";
        String payGrade = "";
        String salary = "";
        String empTitle[] = {};
        String tinNumber = null;
        String permanentOrContract = "";
        String officeOrShift = "";
        String location = "";

        // validationResult = Validater.isDataValid(txtFEmployeeId.getValue(), Validater.ALPHA_NUMERIC, false);
        validationResult = Validater.isDataValid(txtFEmployeeId.getValue(), Validater.NUMBER, false);
        if (getTxtFEmployeeId().getValue() == null || getTxtFEmployeeId().getValue().toString().equals("")) {
            showSuccessOrFailureMessage(false, "PLEASE ENTER EMPLOYEE ID OR SELECT EMPLOYEE FIRST");
            hasError = true;
        } else {
            if (perform == 1) {//if to save new employee
                try {
                    empId = getTxtFEmployeeId().getValue().toString().trim();
                    Integer.parseInt(empId);//check if convertible to int
                } catch (NumberFormatException nfe) {
                    showSuccessOrFailureMessage(false, "INLAID ID\nPLEASE ENTER NUMBER PART ONLY.\n THE SYSTEM WILL TAKE CARE OF THE PREFIX");
                    hasError = true;
                }
            } else {//if to update
                empId = selectedEmployeedId;
            }
        }

        if (HRValidation.validateRequired(drlLocation.getValue())) {
            location = drlLocation.getValue().toString();
        } else {
            location = "Unknown";
        }
//
        if (HRValidation.validateRequired(getDrlEmpTitle().getValue())) {
            empTitle = getDrlEmpTitle().getValue().toString().split("--");
            validationResult = Validater.isDataValid(empTitle[0], Validater.ALPHA_NUMERIC, false);
            if (validationResult == 1) {
                hasError = true;
            } else if (validationResult == 2) {
                hasError = true;
            } else if (validationResult == 0) {
                title = getDrlTitle().getValue().toString();
            }
        } else {
            hasError = true;
        }
        validationResult = Validater.isDataValid(getTxtFirstName().getValue(), Validater.ALPHA_NUMERIC, false);
        if (validationResult == 1) {
            hasError = true;
        } else if (validationResult == 2) {
            hasError = true;
        } else if (validationResult == 0) {
            firstName = getTxtFirstName().getValue().toString();
        }
        validationResult = Validater.isDataValid(getTxtMidelName().getValue(), Validater.ALPHA_NUMERIC, false);
        if (validationResult == 1) {
            hasError = true;
        } else if (validationResult == 2) {
            hasError = true;
        } else if (validationResult == 0) {
            midelName = getTxtMidelName().getValue().toString();
        }
        validationResult = Validater.isDataValid(getTxtLastName().getValue(), Validater.ALPHA_NUMERIC, false);
        if (validationResult == 1) {
            hasError = true;
        } else if (validationResult == 2) {
            hasError = true;
        } else if (validationResult == 0) {
            lastName = getTxtLastName().getValue().toString();
        }
        if (ckbSexFemale.isSelected()) {
            sex = "Female";
            lblSexValidation.setRendered(false);
        } else if (ckbSexMale.isSelected()) {
            sex = "Male";
            lblSexValidation.setRendered(false);
        } else {
            hasError = true;
            lblSexValidation.setRendered(true);
            lblSexValidation.setValue("Sex is required!");
        }
        if (cboContract.isSelected()) {
            permanentOrContract = "Contract";
        } else if (cboPermanent.isSelected()) {
            permanentOrContract = "Permanent";
        } else {
            hasError = true;
        }

        if (cboOffice.isSelected()) {
            officeOrShift = "Clerical";
        } else if (cboShift.isSelected()) {
            officeOrShift = "NonClearical";
        } else {
            hasError = true;
        }

        if (getCalBirthDate().getValue() != null) {
            validationResult = Validater.isDataValid(dateFormat.format(getCalBirthDate().getValue()), Validater.DATE, false);
            if (validationResult == 2) {
                hasError = true;
            } else {
                dateOfBirth = dateFormat.format(getCalBirthDate().getValue());
            }
        } else {
            hasError = true;
        }
        if (getDrlMaritalStatus().getValue() != null && !getDrlMaritalStatus().getValue().toString().equalsIgnoreCase("")) {
            maritalStatus = getDrlMaritalStatus().getValue().toString();

        } else {
            hasError = true;
        }
        if (getDrlNationality().getValue() != null && !getDrlNationality().getValue().toString().equalsIgnoreCase("")) {
            nationality = getDrlNationality().getValue().toString();

        } else {
            hasError = true;
        }
        if (getDrlReligion().getValue() != null && !getDrlReligion().getValue().toString().equalsIgnoreCase("")) {
            if (!getDrlReligion().getValue().toString().equalsIgnoreCase("-1")) {
                religion = getDrlReligion().getValue().toString();
            } else {
                hasError = true;
            }
        } else {
            hasError = true;
        }
        if (getDrlNation().getValue() != null && !getDrlNation().getValue().toString().equalsIgnoreCase("")) {
            nation = getDrlNation().getValue().toString();

        } else {
            hasError = true;
        }

        if (getCalHireDate().getValue() != null) {
            validationResult = Validater.isDataValid(dateFormat.format(getCalHireDate().getValue()), Validater.DATE, false);
            if (validationResult == 2) {
                hasError = true;
            } else {
                hireDate = dateFormat.format(getCalHireDate().getValue());
            }
        } else {
            hasError = true;
        }
        if (getTxtRetirementNo().getValue() != null && !getTxtRetirementNo().getValue().toString().equalsIgnoreCase("")) {
//            if (cboPermanent.isSelected()) {//employee is permanenet
//                if (getTxtRetirementNo().getValue().toString().equalsIgnoreCase("000000")) {
//                    hasError = true;
//                }
//            }
            retirementNo = getTxtRetirementNo().getValue().toString();

        } else {
            hasError = true;
        }
        if (DEPARRTMENT_ID != 0) {
            department = String.valueOf(DEPARRTMENT_ID);
        } else {
            hasError = true;
        }
        if (getDrlJobCode().getValue() != null && !getDrlJobCode().getValue().toString().equalsIgnoreCase("")) {
            department = String.valueOf(DEPARRTMENT_ID);
        } else {
            hasError = true;
        }
        if (getDrlJobCode().getValue() != null && !getDrlJobCode().getValue().toString().equalsIgnoreCase("")) {
            jobCode = getDrlJobCode().getValue().toString();
        } else {
            hasError = true;
        }
        if (getDrlRankId().getValue() != null && !getDrlRankId().getValue().toString().equalsIgnoreCase("")) {
            rankId = getDrlRankId().getValue().toString();
        } else {
            hasError = true;
        }
        if (getDrlPayGrade().getValue() != null && !getDrlPayGrade().getValue().toString().equalsIgnoreCase("")) {
            payGrade = getDrlPayGrade().getValue().toString();
        } else {
            hasError = true;
        }
        validationResult = Validater.isDataValid(getTxtSalary().getValue(), Validater.DECIMAL, false);
        if (validationResult == 1) {
            hasError = true;
        } else if (validationResult == 2) {
            hasError = true;
        } else if (validationResult == 0) {
            salary = getTxtSalary().getValue().toString();
        }
//        validationResult = Validater.isDataValid(txtTinNumber.getValue(), Validater.NUMBER, false);
//        if (validationResult == 1) {
//            hasError = true;
//        } else if (validationResult == 2) {
//            hasError = true;
//        } else if (validationResult == 0) {
//            tinNumber = txtTinNumber.getValue().toString();
//        }

        if (txtTinNumber.getValue() != null) {
            tinNumber = txtTinNumber.getValue().toString();
        } else {
            tinNumber = "";
        }
        if (photoPath != null || this.getEmpImage() != null) {
            lblPhoto.setRendered(false);
        } else {
            hasError = true;
            lblPhoto.setValue("Employee's photo is Required111!");
            lblPhoto.setRendered(true);
        }
//        if (imgMember == null || !excelDataPhoto) {
//            hasError = true;
//            lblPhoto.setValue("Employee's photo is Required2222222222!");
//            lblPhoto.setRendered(true);
//        }


        if (!hasError) {

            EmployeeManage saveMemberInformation = new EmployeeManage(
                    empId,
                    empTitle[0],
                    firstName,
                    midelName,
                    lastName,
                    sex,
                    dateOfBirth,
                    maritalStatus,
                    religion,
                    nationality,
                    nation,
                    hireDate,
                    retirementNo,
                    department,
                    jobCode,
                    rankId,
                    payGrade,
                    salary,
                    permanentOrContract,
                    officeOrShift,
                    this.getEmpImage(),
                    tinNumber,
                    location);


            String saveStatus[] = employeeManager.saveEmployeeInformation(
                    saveMemberInformation, perform).split("=");
            if (saveStatus[0].equals("1")) {
                txtCotractStartDate.setDisabled(false);
                txtfContractEndDate.setDisabled(false);
                bntCotractStartDate.setDisabled(false);
                bntCotractEndDate.setDisabled(false);
                btnSaveContract.setDisabled(false);
                btnUpdateContract.setDisabled(true);
                btnEditContract.setDisabled(true);

                if (cboContract.isSelected()) {
                    pnlPopUpDateSettingForContractEmployee.setRendered(true);
                    if (saveStatus[1] != null) {
                        contratEmployeeId = saveStatus[1];
                    } else {
                        contratEmployeeId = empId;
                    }

                } else {
                    showSuccessOrFailureMessage(true, "The Member Profile Updated Successfully.");
                }



                this.disableComponents();
                btnEdit.setDisabled(false);
                btnDelete.setDisabled(false);
                btnSave.setDisabled(true);
                btnNew.setDisabled(false);
                btnUpdate.setDisabled(true);
            } else {
                showSuccessOrFailureMessage(false, "Error Occured During Saving Member Profile. Make sure that the EMPLOYEE ID yuo inserted is not used");
            }
        } else {
            showSuccessOrFailureMessage(false, "DATA VALIDATION FAILED. SOME DATA IS MISSED OR INVALID \n PLEASE  MAKE SURE YOU INSERTED ALL VALUES CORRECTLY");
        }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public String btnSave_action() {
        this.savePersonalInformation(1);
        if(candidateID!=null){
        employeeManager.ClearCandidateInfo(candidateID);
        }
        return null;
    }

    public void drlNation_processValueChange(ValueChangeEvent vce) {
    }

    public void btnAdd_processAction(ActionEvent ae) {
        String emergenceyContact = "null";
        String emergency_Contact = null;
        String heir = "NO";
        if (cobHeir.isSelected()) {
            heir = "YES";
        }
        if (ckbFamilyAliveOrDied.isSelected()) {
            heir = "YES";
        }

        if (choEmergenceyContact.isSelected()) {
            emergenceyContact = "Emergency Contact";
        }
        emergency_Contact = "true";
        try {

            EmployeeManage addTotabele = new EmployeeManage(
                    heir,
                    // dateFormat.format(   calFamilyDateOfBirth.getValue()),
                    txtFamilyBirthDate.getValue().toString(),
                    emergency_Contact,
                    "female",
                    drlRelationType.getValue().toString(),
                    txtFamilyFirstName.getValue().toString().trim(),
                    txtFamilyMiddleName.getValue().toString(),
                    txtFamilyLastName.getValue().toString().trim(),
                    this.getRelativePhoto(),
                    avilbleOnDbFamily);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cmdfamilySavePersonal_processAction(ActionEvent ae) {
    }

    public void colFamilyTable_processAction(ActionEvent ae) {
    }

    public void colEmergercyContact_processAction(ActionEvent ae) {
        panelCollapsible5.setExpanded(false);
    }

    public void choEmergenceyContact_processValueChange(ValueChangeEvent vce) {
        try {
            String gender = null;
            if (chkMale.isSelected()) {
                gender = "Male";
            }
            if (chkFemale.isSelected()) {
                gender = "Female";
            }
        } catch (Exception e) {
        }
    }

    public void drlRelationType_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                if (employeeManager.getSex().equals("Male")) {
                    if (!employeeManager.getMarital_Status().equals("Married")) {
                        if (vce.getNewValue().equals("Wife")) {
                            showSuccessOrFailureMessage(false, "Not allowed to add this kindes of relation type!");
                        }
                    }
                    if (vce.getNewValue().equals("Husband")) {
                        showSuccessOrFailureMessage(false, "Not allowed to add this kindes of relation type!");
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void cobHeir_processValueChange(ValueChangeEvent vce) {
    }

    public void saveEmployeeAddress(int perform) {

        int chkSave = 0;
        try {
            if (perform == 1) {//save
                employeeManager.setEmploeeId(selectedEmployeedId);
                for (EmployeeManage currentNewAddress : (List<EmployeeManage>) getEmployeeAddress()) {
                    if (currentNewAddress.getDatabaseStatus() == new_inserted) {
                        chkSave = employeeManager.saveEmployeeAddress(currentNewAddress, perform);
                    }
                }
                if (chkSave == 1) {
                    this.disableAddressComponents();
                    showSuccessOrFailureMessage(true, "The Member Address Information Saved Successfully.");
                    adressTableSize = adressTableSize + countAdress;
                    countAdress = 0;
                    btnADNew.setDisabled(false);
                    btnADSave.setDisabled(true);
                    btnADEdit.setDisabled(false);
                    btnADUpdate.setDisabled(true);
                    btnADReset.setDisabled(false);
                    btnADDelete.setDisabled(false);
                    btnAddAddress.setDisabled(true);
                    loadEmployeeAddress();
                } else {
                    showSuccessOrFailureMessage(false, "Error Occured While Saving Member Address Information. Please Try Agin?");
                }
            } else {//update
                for (EmployeeManage currentUpdatedAddress : (List<EmployeeManage>) getEmployeeAddress()) {
                    if (currentUpdatedAddress.getDatabaseStatus() == old_edited) {
                        chkSave = employeeManager.saveEmployeeAddress(currentUpdatedAddress, perform);
                    }
                }
                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "The Member Address Information Updated Successfully.");
                    this.listOfExpUpdate.clear();
                    btnADNew.setDisabled(false);
                    btnADSave.setDisabled(true);
                    btnADEdit.setDisabled(false);
                    btnADUpdate.setDisabled(true);
                    btnADReset.setDisabled(false);
                    btnADDelete.setDisabled(false);
                    btnAddAddress.setDisabled(true);
                    loadEmployeeAddress();
                } else {
                    showSuccessOrFailureMessage(false, "Error ccured while updating member Address information. Please try agin?");
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void btnPopUpOk_processAction(ActionEvent ae) {
        popUpConfirmation.setRendered(false);

    }

    public void btnCloseAddressType_processAction(ActionEvent ae) {
        popUpInputAddressType.setRendered(false);
    }

    public void drlRegion_processValueChange(ValueChangeEvent vce) {
        drlWoreda.setDisabled(false);
        try {
            zoneList = lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString());
        // this.setWoredaList(lookUpManager.readZoneOrCityInARegion(vce.getNewValue().toString()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlWoreda_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
//                drlKebele.setDisabled(false);
//                zoneList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlZone_processValueChange(ValueChangeEvent vce) {
        try {
            woredaList = lookUpManager.readWoredaAndZone(vce.getNewValue().toString());
        //kebeleList = lookUpManager.readKebelleInSubCity(vce.getNewValue().toString());
        } catch (Exception ex) {
        }
    }

    public void saveEmployeeApperance(int perform) {
        String booldGroup = null;
        if (optA.isSelected()) {
            booldGroup = "A";
        }
        if (optB.isSelected()) {
            booldGroup = "B";
        }
        if (optAB.isSelected()) {
            booldGroup = "AB";
        }
        if (optO.isSelected()) {
            booldGroup = "O";
        }

        EmployeeManage contManager = new EmployeeManage(txtFEmployeeId.getValue().toString().trim(),
                txtHeight.getValue().toString().trim(),
                txtWeight.getValue().toString().trim(),
                txtEyeColor.getValue().toString().trim(),
                booldGroup);
        if (employeeManager.saveEmployeeApperance(contManager, perform) == 1) {
            //  popUpConfirmation.setRendered(true);
            if (perform == 1) {
                showSuccessOrFailureMessage(true, "The Member Apperance information  Saved Successfully.");
                btnAPNew.setDisabled(true);
                btnAPReset.setDisabled(false);
                btnAPSave.setDisabled(true);
                btnApDelete.setDisabled(false);
                btnAPEdit.setDisabled(false);
                disableApperanceComponents();
            } else {
                showSuccessOrFailureMessage(false, "The Member Apperance Not updated.");
                disableApperanceComponents();
            }
            disableApperanceComponents();

        } else {

            if (perform == 2) {
                showSuccessOrFailureMessage(false, "The Member Apperance  not Saved try agin?");
            } else {
                showSuccessOrFailureMessage(true, "The Member Apperance not Updated try agin?");
            }
        }
    }

    public void btnAPSave_processAction(ActionEvent ae) {
        if (optA.isSelected() || optB.isSelected() || optAB.isSelected() || optO.isSelected()) {
            lblBloodGroup1.setRendered(false);
            this.saveEmployeeApperance(1);
        } else {
            lblBloodGroup1.setRendered(true);
            lblBloodGroup1.setValue("Required");
        }
    }
    int databaseStatus;

    public void addEmployeeEducation() {
        boolean hasError = true;
        double check = 0;
        int validationResult = 0;
        String leaveOfEducation;
        String typesOfEducation;
        String award;
        try {
            if (drlGradingScale.getValue().toString().equals("-1") || drlGradingScale.getValue().toString().equals("0")) {
                txtResult.setValue("0.00");
            } else {
                check = Math.abs(Double.parseDouble(drlGradingScale.getValue().toString().trim()));
            }

            HRValidation.validateData(drlLevelOfEducation.getValue(), HRValidation.NUMBER_PATTERN, true);
            if (validationResult != 0) {
                hasError = false;
            }
            HRValidation.validateData(drlTypesOfEducation.getValue(), HRValidation.FLOAT_PATTERN, true);
            if (validationResult != 0) {
                hasError = false;
            }
            HRValidation.validateData(txtaward.getValue(), HRValidation.NUMBER_PATTERN, true);
            if (validationResult != 0) {
                hasError = false;
            }
            if (hasError)
            {
               // String educationLevelDescription = educationManager.readEducationDescription(drlLevelOfEducation.getValue().toString());
                 String[] eductype=drlLevelOfEducation.getValue().toString().split("-");
                        String educLevel=eductype[0];
                        String educCode=eductype[1];
                        String educationLevelDescription=educLevel;
                        
//                        String[] eductype=drlLevelOfEducation.getValue().toString().split("-");
//                        String educLevel=eductype[0];
//                        String educCode=eductype[1];
                       
              

                String educationTypeDescription = educationManager.readTypeDescription(drlTypesOfEducation.getValue().toString());
                if (check < Double.parseDouble(txtResult.getValue().toString().trim()))
                {
                    showSuccessOrFailureMessage(false, "Result is Larger than scale : Impossible!");
                } else {
                    String educStartDate = "";
                    try {
                        if (txtDispStartEducDate.getValue() != null && !txtDispStartEducDate.getValue().toString().equals("") && !txtDispStartEducDate.getValue().toString().equals("Unknown")) {
                            dateFormat.parse(txtDispStartEducDate.getValue().toString());
                            educStartDate = txtDispStartEducDate.getValue().toString();
                        } else {
                            educStartDate = "";
                        }
                     
                        EducationManager addEducation = new EducationManager(educLevel,
                                drlTypesOfEducation.getValue().toString(),
                                txtInstitution.getValue().toString().trim(),
                                // txtDispStartEducDate.getValue() == null || txtDispStartEducDate.getValue().toString().equals("") || txtDispStartEducDate.getValue().toString().equals("Unknown") ? "" : txtDispStartEducDate.getValue().toString(),
                                educStartDate,
                                dateFormat.format(calEndEduc.getValue()),
                                txtaward.getValue() == null ? "" : txtaward.getValue().toString().trim(),
                                txtResult.getValue().toString().trim(),
                                txtFEmployeeId.getValue().toString().trim(),
                                educationID,
                                databaseStatus,
                                educationLevelDescription,
                                educationTypeDescription,
                                Integer.parseInt(drlGradingScale.getValue().toString()),
                                databaseStatus);

                        if (buttonIdentifierEduc == 1 || buttonIdentifierEduc == 2) {
                            this.educCounter++;
                            this.listOfEducation.add(addEducation);
                            btnEDDelete.setDisabled(false);
                            btnEDSave.setDisabled(false);
                            this.btnEDEdit.setDisabled(false);
                        } else if (buttonIdentifierEduc == 3) {

                            this.listOfEducation.add(this.selecteEducationRow, addEducation);
                            this.listOfEducationUpdate.add(addEducation);
                            this.btnEDEdit.setDisabled(false);
                            this.btnEDUpdate.setDisabled(false);
                            btnEDDelete.setDisabled(false);
                            this.disableEducationComponents();
                        }
                        this.clearEducationComponents();
                    } catch (ParseException pe) {
                        showSuccessOrFailureMessage(false, "Invalid Start Date!");
                    }

                    if (newOrEdit.equals("New")) {
                        databaseStatus = new_inserted;
                    } else if (newOrEdit.equals("Edit")) {
                        dataIsOnEditEducation = "NO";
                        databaseStatus = old_edited;
                        btnEDUpdate.setDisabled(false);
                    }
                }
            } else {
                showSuccessOrFailureMessage(false, " PLESE FILL ALL FIELDS ");
            }
        } catch (NumberFormatException nfe) {
            showSuccessOrFailureMessage(false, "INVALID NUMBER " + txtResult.getValue().toString());
        } catch (NullPointerException npe) {
            showSuccessOrFailureMessage(false, " PLESE FILL ALL FIELDS ");
        } catch (Exception ex) {
            showSuccessOrFailureMessage(false, " UNKNOWN EXCEPTION ");
        }
    }

    public void saveEmployeeEducation(int perform) {
        int chkSave = 0;
        try {
            if (perform == 1) {//save
                for (EducationManager educManager : getListOfEducation()) {
                    if (educManager.getDatabaseStatus() == new_inserted) {
                        chkSave = educManager.saveEmployeeEducation(educManager, perform);
                    }
                }
                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Education Information  Saved Successfuly.");
                    this.educCounter = 0;
                    loadEmployeeEducation();
                    btnEDNew.setDisabled(false);
                    btnEDSave.setDisabled(true);
                    btnEDEdit.setDisabled(false);
                    btnEDUpdate.setDisabled(true);
                    btnEDDelete.setDisabled(false);
                    btnEDReset.setDisabled(false);
                    cmdEducationAdd.setDisabled(true);
                } else {
                    showSuccessOrFailureMessage(false, "Member Education Information not Saved. Please Try again.");
                }
            } else {//update

                for (EducationManager educManager : getListOfEducationUpdate()) {
                    chkSave = educManager.saveEmployeeEducation(educManager, perform);
                }
                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Education Information  Updated Successfuly.");
                    this.listOfEducationUpdate.clear();
                    loadEmployeeEducation();
                    btnEDNew.setDisabled(false);
                    btnEDSave.setDisabled(true);
                    btnEDEdit.setDisabled(false);
                    btnEDUpdate.setDisabled(true);
                    btnEDDelete.setDisabled(false);
                    btnEDReset.setDisabled(false);
                    cmdEducationAdd.setDisabled(true);

                } else {
                    showSuccessOrFailureMessage(false, "Member Education Information not Updated. Please Try again.");
                    this.listOfEducationUpdate.clear();
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void addEmployeeLanguage() {
        try {

            String language_description = languageManager.readLanguageName(drlLanguageType.getValue().toString());
            LanguageManager addLanguage = new LanguageManager(
                    drlListening.getValue().toString(),
                    drlSpeaking.getValue().toString().trim(),
                    drlReading.getValue().toString().trim(),
                    drlWriting.getValue().toString().trim(),
                    drlLanguageType.getValue().toString(),
                    txtFEmployeeId.getValue().toString().trim(),
                    languageId,
                    language_description);
            if (this.buttonIdentifierLang == 1 || buttonIdentifierLang == 2) {
                lanCounter++;
                this.listOfLanguage.add(addLanguage);
                clearLanguageComponents();
            } else if (buttonIdentifierLang == 3) {
                this.listOfLanguage.add(this.selecteLanguageRow, addLanguage);
                this.listOfLanguageUpdate.add(addLanguage);
                clearLanguageComponents();
                this.disableLanguageComponents();
            }
            if (newOrEdit.equals("New")) {
                databaseStatus = new_inserted;
            } else if (newOrEdit.equals("Edit")) {
                dataIsOnEditLanguage = "NO";
                databaseStatus = old_edited;
                btnLAUpdate.setDisabled(false);
            }

        } catch (Exception ex) {
        }

    }

    public void saveEmployeeLanguage(int perform) {
        int chkSave = 0;
        try {
            if (perform == 1)
                    {
                List employeeLanguage = this.getListOfLanguage().subList((langTableSize), (langTableSize + lanCounter));
                Iterator<LanguageManager> iter = employeeLanguage.iterator();
                while (iter.hasNext()) {
                    LanguageManager employeLanguage = iter.next();
                    chkSave = employeLanguage.saveEmployeeLanguage(employeLanguage, perform);
                }
                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Language Ability  Saved Successfuly.");
                    lanCounter = 0;
                    btnLANew.setDisabled(false);
                    btnLASave.setDisabled(true);
                    btnLAEdit.setDisabled(false);
                    btnLAUpdate.setDisabled(true);
                    btnLAReset.setDisabled(false);
                    btnLADelete.setDisabled(false);
                    btnLAAdd.setDisabled(true);
                    listOfLanguage.clear();
                    loadEmployeeLanguage();
                } else {
                    showSuccessOrFailureMessage(false, "Member Language Ability not Saved.Please Try again.");
                }
            } else {
                List employeeLanguageList = this.getListOfLanguageUpdate();
                Iterator<LanguageManager> iter = employeeLanguageList.iterator();

                while (iter.hasNext()) {
                    LanguageManager employeLanguage = iter.next();
                    chkSave = employeLanguage.saveEmployeeLanguage(employeLanguage, perform);
                }
                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Language Ability  Updated Successfuly.");
                    this.listOfLanguageUpdate.clear();
                    btnLANew.setDisabled(false);
                    btnLASave.setDisabled(true);
                    btnLAEdit.setDisabled(false);
                    btnLAUpdate.setDisabled(true);
                    btnLAReset.setDisabled(false);
                    btnLADelete.setDisabled(false);
                    btnLAAdd.setDisabled(true);
                    listOfLanguage.clear();
                    loadEmployeeLanguage();
                } else {
                    showSuccessOrFailureMessage(false, "Member Language Ability not Updated Try again.");
                    this.listOfLanguageUpdate.clear();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

//    LanguageManager languageInformation = new LanguageManager();
    public void addEmpllooyeeExperiance() {
        try {
            String rankID=null;
            String expiranceSalry=null;
            String useThisExprianceForLeave = "NO";
            if (ckbExperienceGovernmental.isSelected()) {
                experiencePrivateOrGovernmental = "Gvt";
            } else if (ckbExperiencePrivate.isSelected()) {
                experiencePrivateOrGovernmental = "Pvt";
            } else {
                experiencePrivateOrGovernmental = "";
            }

            if (ckbExperiencePermanent.isSelected()) {
                experienceContractOrPrtmanent = "Perm";
            } else if (ckbExperienceContract.isSelected()) {
                experienceContractOrPrtmanent = "Cont";
            } else {
                experienceContractOrPrtmanent = "";
            }
            if (drlProfessionInMugher.getValue() != null) {
                String jobSplite[] = drlProfessionInMugher.getValue().toString().split("--");
                experienceRelatedToMugherJob = jobSplite[0];
                experienceRelatedToMugherJobDescription = jobSplite[1];
            }
          //  double salary = Double.parseDouble(txtExperanceSalary.getValue().toString().trim());
            if (experiencePrivateOrGovernmental.equals("") ||
                    experienceContractOrPrtmanent.equals("") ||
                    txtDisplayedExpStartDate.getValue() == null || txtDisplayedExpStartDate.getValue().toString().equals("") ||
                    txtDisplayedExpEndDate.getValue() == null || txtDisplayedExpEndDate.getValue().toString().equals("")) {
            } else {
                if (ckbUsethisExperienceforLeave.isSelected())
                {
                    useThisExprianceForLeave = "YES";
                }
                if(txtExperanceSalary.getValue().toString().equalsIgnoreCase("")){
                expiranceSalry=null;

                }else {

                expiranceSalry=txtExperanceSalary.getValue().toString();
                }
                 if(txtExRank.getValue().toString().equalsIgnoreCase(null))
                       {
                     rankID=null;
                       }
                 else{

                 rankID=txtExRank.getValue().toString();
                     }
                EmployeeManage addExperiance = new EmployeeManage(
                        txtExperianceInstitution.getValue().toString().trim(),
                        txtTermination.getValue().toString(),
                        rankID,
                        txtDisplayedExpStartDate.getValue().toString(),
                        txtDisplayedExpEndDate.getValue().toString(),
                        expiranceSalry,
                        txtFEmployeeId.getValue().toString().trim(),
                        txtJobType.getValue().toString().trim(),
                        experianceId,
                        experiencePrivateOrGovernmental,
                        experienceContractOrPrtmanent,
                        experienceRelatedToMugherJob,
                        experienceRelatedToMugherJobDescription,
                        useThisExprianceForLeave);
                if (buttonIdentifier == 1 || buttonIdentifier == 2) {
                    counter++;
                    this.listOfExperience.add(addExperiance);
                    btnEXSave.setDisabled(false);
                    this.btnEXEdit.setDisabled(false);
                    this.btnEXDelete.setDisabled(false);
                } else if (buttonIdentifier == 3) {
                    this.listOfExperience.add(this.selectedExperience, addExperiance);
                    this.listOfExpUpdate.add(addExperiance);
                    this.btnEXEdit.setDisabled(false);
                    this.btnEXUpdate.setDisabled(false);
                    this.disableExperianceComponents();
                }
                dataIsOnEditExperience = "NO";
                this.clearExperianceComponents();
            }
        } catch (Exception nfe) {
            nfe.printStackTrace();
            showSuccessOrFailureMessage(false, "INVALID SALARY ");
        }
    }

    public void saveEmployeeExperiance(int perform) {
        int chkSave = 0;
        try {
            if (perform == 1) {//save
                List employeeExperiance = this.getListOfExperience().subList((tableSize), (tableSize + counter));
                Iterator<EmployeeManage> iter = employeeExperiance.iterator();
                while (iter.hasNext()) {
                    EmployeeManage saveEmployeeExperiance = iter.next();
                    chkSave =
                            employeeManager.saveEmployeeExperiance(saveEmployeeExperiance, perform);
                }

                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Experiance  Save Successfuly.");
                    this.clearExperianceComponents();
                    counter = 0;
                    loadEmployeeExperiance();

                    disableExperianceComponents();

                    this.btnEXSave.setDisabled(true);
                    this.btnEXNew.setDisabled(false);
                    this.btnEXReset.setDisabled(true);
                    btnAddExperience.setDisabled(true);
                } else {
                    showSuccessOrFailureMessage(false, "Member Experiance not Saved Try again.");
                    counter =
                            0;
                    disableExperianceComponents();

                    this.btnEXSave.setDisabled(false);
                    this.btnEXNew.setDisabled(true);
                    this.btnEXReset.setDisabled(false);
                }

            } else {//update
                List employeeExperiance = this.getListOfExpUpdate();
                Iterator<EmployeeManage> iter = employeeExperiance.iterator();
                while (iter.hasNext()) {
                    EmployeeManage saveEmployeeExperiance = iter.next();
                    chkSave =
                            employeeManager.saveEmployeeExperiance(saveEmployeeExperiance, perform);
                }

                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "Member Experiance  Updated Successfuly.");
                    this.listOfExpUpdate.clear();
                    this.btnEXNew.setDisabled(false);
                    this.btnEXUpdate.setDisabled(true);
                    this.btnEXDelete.setDisabled(false);
                    loadEmployeeExperiance();

                } else {
                    showSuccessOrFailureMessage(false, "Member Experiance not Updated Try again.");
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String btnCalendeHireDate_action() {

        return null;
    }

    public void btnReset_processAction(ActionEvent ae) {
        this.clearComponents();
        txtFEmployeeId.resetValue();
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnReset.setDisabled(true);
        btnNew.setDisabled(false);
    }

    public void ckbSexFemale_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            if (ckbSexFemale.isSelected()) {
                ckbSexMale.setSelected(false);
                lblSexValidation.setRendered(false);
            }

        }
    }

    public void ckbSexMale_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            if (ckbSexMale.isSelected()) {
                ckbSexFemale.setSelected(false);
                lblSexValidation.setRendered(false);
            }

        }
    }

    public void txtFirstName_validate(FacesContext context, UIComponent component, Object value) {
        //this.validateName(context, component, value);
    }

    public void inputmemberPhoto_processAction(ActionEvent ae) {
        if (!excelDataPhotoFamily) {
            imgMemberFamily.setValue(null);
            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            photoPath =
                    fileInfo.getPhysicalPath().toString();
            File file = new File(photoPath);
            setRelativePhoto(EmployeeManage.extractByteArray(file));
            imgMemberFamily.setValue(getRelativePhoto());
        } else {
            String image = "D:\\MUGHER_HRMS\\HRMS\\web\\Employee\\imagesSample_1.JPG";
            File file = new File(image);
            setEmpImage(EmployeeManage.extractByteArray(file));
            imgMemberFamily.setValue(getEmpImage());
            excelDataPhoto =
                    false;
        }

    }

    public void inputPhoto_processAction(ActionEvent ae) {
        try {


//            inputPhoto.setAutoUpload(true);
//            inputPhoto.setImmediate(true);
            lblPhoto.setRendered(false);
            InputFile inpuFile = new InputFile();//InputFile) ae.getSource();
            inpuFile =(InputFile) ae.getSource();
            FileInfo fileInfo = new FileInfo();//inpuFile.getFileInfo();
            fileInfo =  inpuFile.getFileInfo();
            photoPath =
                    new String();
            photoPath = fileInfo.getPhysicalPath().toString();
            File file = new File(photoPath);
            imgMember.setValue(null);
            
            setEmpImage(EmployeeManage.extractByteArray(file));
            imgMember.setValue(getEmpImage());
          

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String btnSearchById_action() {
        return null;
    }

    void setEmployeeProfile() {
        adressTableSize = 0;
        langTableSize = 0;
        educTableSize = 0;
        tableSize = 0;
        familyTableSize = 0;
        counter = 0;
        lanCounter = 0;
        educCounter = 0;
        countAdress = 0;
        countfamily = 0;
        this.getEmployeeAddress().clear();
        this.getEmployeeAdressUpdate().clear();
        this.getListOfExpUpdate().clear();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        this.getListOfExperience().clear();
        this.getListOfEducation().clear();
        this.getListOfEducationUpdate().clear();
        this.listOfLanguage.clear();
        this.listOfLanguageUpdate.clear();
        try {
            btnDelete.setDisabled(false);
            btnReset.setDisabled(false);
            OracleSerialBlob blo = null;
            blo = (OracleSerialBlob) (employeeManager.getPhotobinary());
            imgMember.setValue(null);
            try {
                setEmpImage(null);
                setEmpImage(blo.getBytes(0, (int) blo.length()));
                imgMember.setValue(this.getEmpImage());
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            drlNationality.setValue(employeeManager.getNationality_Code());
            drlReligion.setValue(employeeManager.getReligion_Code());

            try {
                drlNationality.setValue(employeeManager.getNationality_Code());
                drlReligion.setValue(employeeManager.getReligion_Code());
                this.setNation(lookUpManager.assignNation());

                txtFirstName.setValue(employeeManager.getFirst_Name());
                txtMidelName.setValue(employeeManager.getMiddle_Name());
                txtLastName.setValue(employeeManager.getLast_Name());

                txtDateOfBirth.setValue(dateFormat.parse(employeeManager.getDate_Of_Birth()));
                txtBirthDate.setValue(employeeManager.getDate_Of_Birth());
                drlMaritalStatus.setValue(employeeManager.getMarital_Status());
                txtSalary.setValue(employeeManager.getSalary());
                txtRetirementNo.setValue(employeeManager.getRetirement_no());
                // txtTinNumber.setValue(employeeManager.getTinNumber());
                drlNation.setValue(employeeManager.getNation_Code());
                calHireDate.setValue(dateFormat.parse(employeeManager.getHire_Date()));
                txtRecruitmentDate.setValue(employeeManager.getHire_Date());


                DEPARRTMENT_ID =
                        Integer.parseInt(employeeManager.getDepartmentId());
                this.setPerofation(departmentManage.readJobCode(employeeManager.getDepartmentId()));
                drlJobCode.setValue(employeeManager.getJobCode());
                drlPayGrade.setValue(employeeManager.getDrlPayGrade());
                drlEmpTitle.setValue(employeeManager.getEmpTitle() + "--" + employeeManager.getTitleType());
                drlRankId.setValue(employeeManager.getRankId());
                txtTinNumber.setValue(employeeManager.getTinNumber());
                drlLocation.setValue(employeeManager.getLocation());
                this.setPayGradeOpt(lookUpManager.readPayGrade(employeeManager.getRankId()));
                if (employeeManager.getSex().equals("Female")) {
                    ckbSexFemale.setSelected(true);
                } else if (employeeManager.getSex().equals("Male")) {
                    ckbSexMale.setSelected(true);
                }
                if (employeeManager.getPermanentOrContract().equals("Permanent")) {
                    cboPermanent.setSelected(true);
                    cboContract.setSelected(false);
                } else if (employeeManager.getPermanentOrContract().equals("Contract")) {
                    cboContract.setSelected(true);
                    cboPermanent.setSelected(false);
                    txtCotractStartDate.setDisabled(true);
                    txtfContractEndDate.setDisabled(true);
                    bntCotractStartDate.setDisabled(true);
                    bntCotractEndDate.setDisabled(true);
                    btnSaveContract.setDisabled(true);
                    btnEditContract.setDisabled(false);
                    btnDelete.setDisabled(false);
                    btnSave.setDisabled(true);
                    btnNew.setDisabled(false);
                    btnUpdate.setDisabled(true);
                    btnFamilyNew.setDisabled(false);
                    String list[] = contratManager.readContractDate(txtFEmployeeId.getValue().toString());
                    if (list != null) {
                        long countContractDate = 0;
                        txtCotractStartDate.setValue(list[0]);
                        txtfContractEndDate.setValue(list[1]);
                        employeeContractId = list[4];
                        if (list[5] == null) {
                            countContractDate = StringDateManipulation.getTwoComparisonofDatesValue(
                                    jodanTimeCalender.currentForeignersDateFinder(),
                                    list[1]);
                        } else {
                            countContractDate = StringDateManipulation.getTwoComparisonofDatesValue(
                                    list[5].toString(),
                                    list[1]);

                        }
                        if (countContractDate >= 0) {
                            lblRemainingDayes.setStyle("font-size: 46px; height: 100px; left: 0px; top: 40px; position: absolute; width: 100px");
                            lblRemainingDayes.setValue(countContractDate);
                        } else {
                            lblRemainingDayes.setStyle("color:red;font-size: 46px; height: 100px; left: 0px; top: 40px; position: absolute; width: 100px");
                            lblRemainingDayes.setValue(countContractDate);
                        }
                    }
                    pnlPopUpDateSettingForContractEmployee.setRendered(true);



                }

                if (employeeManager.getOfficeOrshift().equals("Clerical")) {
                    cboOffice.setSelected(true);
                } else if (employeeManager.getOfficeOrshift().equals("NonClerical")) {
                    cboShift.setSelected(true);
                }
                btnDelete.setDisabled(false);
                btnEdit.setDisabled(false);
                btnSave.setDisabled(true);
                btnNew.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnFamilyNew.setDisabled(false);
                String departmentName = departmentManage.readDepartmentDescrption(employeeManager.getDepartmentId());
                txtfDepartment.setValue(departmentName);
            // prerender();

            } catch (Exception ex) {
            }
        } catch (Exception ex) {
        }
    }
    String isAlive = "YES";

    public void btnFaAdd_action() {
        if (newOrEdit.equals("New"))
        {
            databaseStatus = new_inserted;
        } else if (newOrEdit.equals("Edit"))
        {
            databaseStatus = old_edited;
            dataIsOnEditFamily = "NO";
            btnEDUpdate.setDisabled(false);
        }

        boolean hasError = false;
        int validationResult = 0;
        int checkAvilabe = 0;
        String gender = null;
        String emergency_Contact = "NO";
        String heir = "NO";
        String dateof_Birth = "";
        String _sex = "";
        String relation_Type = "";
        String family_FirstName = "";
        String familyMidelName = "";
        String familyLastName = "";
        String id = "";
        String phoneNo="";
        String dateOfBirth=null;

        if (cobHeir.isSelected()) {
            heir = "YES";
        }

        if (choEmergenceyContact.isSelected()) {
            emergency_Contact = "YES";
        }

        if (!ckbFamilyAliveOrDied.isSelected()) {
            isAlive = "NO";
        }

        if (chkFemale.isSelected() || chkMale.isSelected()) {
            lblValidateFamilyGender.setRendered(false);
            if (chkMale.isSelected()) {
                gender = "Male";
            }

            if (chkFemale.isSelected()) {
                gender = "Female";
            }

        } else {
            hasError = true;
            lblValidateFamilyGender.setRendered(true);
            lblValidateFamilyGender.setValue("Family's Gender is required!");
        }

        if (chkFemale.isSelected() || chkMale.isSelected()) {
            lblValidateFamilyGender.setRendered(false);
            if (chkMale.isSelected()) {
                gender = "Male";
            }

            if (chkFemale.isSelected()) {
                gender = "Female";
            }
            if(txtFamilyBirthDate.getValue().toString().equalsIgnoreCase(null))
                {
               dateOfBirth=null;
                } else{
                dateOfBirth=txtFamilyBirthDate.getValue().toString();

                }

           dateOfBirth=txtFamilyBirthDate.getValue().toString();
           if(txtFamilyLastName.getValue().toString().equalsIgnoreCase(null))
           {
           familyLastName=null;
           }else {
           
          familyLastName=txtFamilyLastName.getValue().toString();

              }

            EmployeeManage addFamily = new EmployeeManage(heir,
                    // dateFormat.format(calFamilyDateOfBirth.getValue()),
                    //txtFamilyBirthDate.getValue().toString(),
                    dateOfBirth,
                    emergency_Contact,
                    gender,
                    txt_phone_no.getValue().toString(),
                    drlRelationType.getValue().toString(),
                    txtFamilyFirstName.getValue().toString(),
                    txtFamilyMiddleName.getValue().toString(),
                    familyLastName,
                  //  txtFamilyLastName.getValue().toString(),
               
                    isAlive,
                    familyId,
                    databaseStatus//    ,this.getRelativePhoto()
                    );
            if (familybuttonIdentifier == 1 || familybuttonIdentifier == 2) {
                countfamily++;
                this.familyInformation.add(addFamily);
                btnFaSave.setDisabled(false);
            } else if (familybuttonIdentifier == 3) {
                this.familyInformation.add(this.selectedFamilyRow, addFamily);
                this.familyInfoUpdate.add(addFamily);
                this.btnFaEdit.setDisabled(false);
                this.btnFaUpdate.setDisabled(false);
                this.clearComponentsFa();
                this.disablComponentsFa();
            }

            clearComponentsFa();
        } else {
            lblValidateFamilyGender.setRendered(true);
        }

    }

    void loadEmployeeFamily() {
        ArrayList<HashMap> familyList = employeeManager.readEmployeeFamily(
                txtFEmployeeId.getValue().toString());
        for (HashMap currentFamily : familyList) {
            EmployeeManage familyToAdd = new EmployeeManage(
                    currentFamily.get("HEIR").toString(),
                    currentFamily.get("DATE_OF_BIRTH").toString(),
                    currentFamily.get("EMERGENCEY").toString(),
                    currentFamily.get("SEX").toString(),
                    currentFamily.get("PHONENO").toString(),
                    currentFamily.get("RELATION").toString(),
                    currentFamily.get("FIRST_NAME").toString(),
                    currentFamily.get("MIDDLE_NAME").toString(),
                    currentFamily.get("LAST_NAME").toString(),
                    currentFamily.get("ALIVE_OR_DIED").toString(),
                    currentFamily.get("ID").toString(),
                    old_not_cahanged //   this.getRelativePhoto());
                    );
            this.getFamilyInformation().add(familyToAdd);
        }

    }

    void loadEmployeeFamilyBackup() {
        HashMap[] list = employeeManager.getEmployeeFamily(txtFEmployeeId.getValue().toString());
        oracle.sql.BLOB photobinary = null;
        familyTableSize =
                list.length;// employeeManager.countSize(txtFEmployeeId.getValue().toString());
        //   if (familyTableSize > 0) {
        for (int i = 0; i <
                familyTableSize; i++) {
            try {
                if (list[i].get("PHOTO") != null) {
                    BLOB blo = (BLOB) list[i].get("PHOTO");
                    setRelativePhoto(blo.getBytes(1, (int) blo.length()));
                } else {
                    setRelativePhoto(null);
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }

            btnFaEdit.setDisabled(false);
            btnFaDelete.setDisabled(false);

            EmployeeManage addFamily = new EmployeeManage(list[i].get("HEIR").toString(),
                    list[i].get("DATE").toString(),
                    list[i].get("EMERGENCEY").toString(),
                    list[i].get("SEX").toString(),
                    list[i].get("RELATION").toString(),
                    list[i].get("FIRST_NAME").toString(),
                    list[i].get("MIDDLE_NAME").toString(),
                    // list[i].get("ALIVE_OR_DIED").toString(),//use it after test
                    list[i].get("LAST_NAME").toString(),
                    list[i].get("ID").toString(),
                    1, this.getRelativePhoto());
            this.getFamilyInformation().add(addFamily);
        //  }
        //  imgMemberFamily.setValue(null);
        }

    }

    void loadEmployeeAddress() {
        employeeAddress.clear();
        HashMap[] list = employeeManager.readEmployeeAddrss(txtFEmployeeId.getValue().toString());
        EmployeeManage empControl;

        adressTableSize =
                employeeManager.countSizeAddress(txtFEmployeeId.getValue().toString());
        String kebelle_Name = null;
        if (adressTableSize > 0) {
            for (int i = 0; i <
                    adressTableSize; i++) {
                try {
                    String kebelleDescription = lookUpManager.readKebelleDescrption(list[i].get("KEBELE").toString());
                    empControl =
                            new EmployeeManage(
                            selectedEmployeedId,
                            list[i].get("REGION_ID").toString(),
                            list[i].get("WOREDA_OR_SUBCITY").toString(),//excahnged with lower, now subcity
                            list[i].get("WOREDA_OR_SUBCITY_ID").toString(), //excahnged with lower, woreda
                            list[i].get("KEBELE").toString(),
                            list[i].get("HOUSE_NUMBER").toString(),
                            list[i].get("TELEPHONE_RESIDENCE").toString(),
                            list[i].get("TELEPHONE_OFFICE").toString(),
                            list[i].get("MOBILE").toString(),
                            list[i].get("EMAIL").toString(),
                            list[i].get("P_O_BOX").toString(),
                            list[i].get("ADDRESSTYPE").toString(),
                            list[i].get("ID").toString(),
                            old_not_cahanged,
                            list[i].get("regionDescription").toString(),
                            list[i].get("zoneDescription").toString(),
                            list[i].get("woredaDiscretion").toString(),
                            kebelleDescription,
                            list[i].get("SEFERE").toString(),
                            old_not_cahanged);
                    this.getEmployeeAddress().add(empControl);
                    btnADEdit.setDisabled(false);
                    btnADDelete.setDisabled(false);
                } catch (Exception ex) {
                }
            }
        }
    }

    void loadEmployeeFile() {
        ArrayList<HashMap> listEmployeeFile = employeeFileManager.readEmployeeFile(txtFEmployeeId.getValue().toString());
        try {
            employeeFileList.clear();
            filetableSize = 0;
            if (listEmployeeFile != null) {
                btnFileEdit.setDisabled(false);
                btnFileReset.setDisabled(false);
                btnFileDelete.setDisabled(false);
                byte code[];
                for (HashMap hm : listEmployeeFile) {
                    try {
                        OracleSerialBlob blo = (OracleSerialBlob) hm.get("EMPFILE");
                        setEmployeeFile(blo.getBytes(0, (int) blo.length()));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    EmployeeFileManager addTotabele = new EmployeeFileManager(
                            hm.get("FILETYPE").toString(),
                            hm.get("ID").toString(),
                            hm.get("FILENAME").toString(),
                            hm.get("REMARK").toString(),
                            getEmployeeFile(),
                            hm.get("EMP_ID").toString(),
                            hm.get("FILEEXTENSION").toString());
                    this.employeeFileList.add(addTotabele);
                    filetableSize++;

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

//    void loadEmployeeApperance() {
//        HashMap list = employeeManager.readEmployeeAppreance(txtFEmployeeId.getValue().toString());
//        try {
//            if (list != null) {
//                btnAPNew.setDisabled(true);
//                btnAPEdit.setDisabled(false);
//                btnApDelete.setDisabled(false);
//                txtHeight.setValue(list.get("HEIGHT"));
//                txtWeight.setValue(list.get("WEIGHT"));
//                txtEyeColor.setValue(list.get("EYE_COLOR"));
//
//                if (list.get("BLOOD_GROUP").equals("A")) {
//                    optA.setSelected(true);
//                }
//
//                if (list.get("BLOOD_GROUP").equals("B")) {
//                    optB.setSelected(true);
//                }
//
//                if (list.get("BLOOD_GROUP").equals("AB")) {
//                    optAB.setSelected(true);
//                }
//
//                if (list.get("BLOOD_GROUP").equals("O")) {
//                    optO.setSelected(true);
//                }
//
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        }
//
//    }
    void loadEmployeeEducation()
         {
        this.listOfEducation.clear();
        String satrt_Date = ""; //"start";
        String end_Date = "";//End";
        String instituation = " ";//Instituation";
        String award = "";//";
        String result = "";//";
        String educType = "";
        ArrayList<HashMap> hashMapListEducation = educationManager.getEmployeeEducation(selectedEmployeedId);
        educTableSize = hashMapListEducation.size();
        for (HashMap currentEducation : hashMapListEducation) {
            satrt_Date = currentEducation.get("STARTING_DATE").toString();
            end_Date =
                    currentEducation.get("COMPLETION_DATE").toString();
            award =
                    currentEducation.get("AWARD").toString();
            result =
                    currentEducation.get("RESULT").toString();
            String empId = currentEducation.get("EMP_ID").toString();
            String id = currentEducation.get("ID").toString();
            String educationLevelDescription = currentEducation.get("educ_level").toString();
            String educationTypeDescription = currentEducation.get("EDUC_TYPE").toString();
            instituation =
             currentEducation.get("INSTITUTION").toString();
            String educTypeCode = currentEducation.get("EDUCATION_TYPE").toString();
            String levelCode = currentEducation.get("EDUC_LEVEL_CODE").toString();
            int gradingScale = Integer.parseInt(currentEducation.get("GRADING_SYSTEM").toString());
            EducationManager addTotabele = new EducationManager(
                    levelCode,
                    educTypeCode,
                    instituation,
                    satrt_Date,
                    end_Date,
                    award,
                    result,
                    empId,
                    id,
                    1,//1is old
                    educationLevelDescription,
                    educationTypeDescription, gradingScale, old_not_cahanged);
            this.listOfEducation.add(addTotabele);
        }

    }

    void loadEmployeeEducationOld() {
        this.listOfEducation.clear();
        String satrt_Date = ""; //"start";
        String end_Date = "";//End";
        String instituation = " ";//Instituation";
        String award = "";//";
        String result = "";//";

        String educType = "";
        btnEDNew.setDisabled(false);
        HashMap[] list = educationManager.readEmployeeEducation(txtFEmployeeId.getValue().toString());
        EducationManager addTotabele = new EducationManager();
        try {
            educTableSize = list.length;// educationManager.countEmployeeEducation(txtFEmployeeId.getValue().toString());
            if (educTableSize > 0) {
                btnEDDelete.setDisabled(false);
                btnEDEdit.setDisabled(false);
                btnEDNew.setDisabled(false);

                for (int i = 0; i <
                        educTableSize; i++) {
                    satrt_Date = list[i].get("STARTING_DATE").toString();
                    end_Date =
                            list[i].get("COMPLETION_DATE").toString();
                    award =
                            list[i].get("AWARD").toString();
                    result =
                            list[i].get("RESULT").toString();
                    String empId = list[i].get("EMP_ID").toString();
                    String id = list[i].get("ID").toString();
                    String educationLevelDescription = list[i].get("educ_level").toString();
                    String educationTypeDescription = list[i].get("EDUC_TYPE").toString();
                    instituation =
                            list[i].get("INSTITUTION").toString();
                    String educTypeCode = list[i].get("EDUCATION_TYPE").toString();
                    String levelCode = list[i].get("EDUC_LEVEL_CODE").toString();
                    int gradingScale = Integer.parseInt(list[i].get("SCALE").toString());

                    addTotabele =
                            new EducationManager(
                            levelCode,
                            educTypeCode,
                            instituation,
                            satrt_Date,
                            end_Date,
                            award,
                            result,
                            empId,
                            id,
                            1,//1is old
                            educationLevelDescription,
                            educationTypeDescription, gradingScale, old_not_cahanged);
                    this.listOfEducation.add(addTotabele);

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    LanguageManager languageManager = new LanguageManager();

    void loadEmployeeLanguage() {

        HashMap[] list = languageManager.readEmployeeLanguage(txtFEmployeeId.getValue().toString());
        LanguageManager addTotabele = null;
        try {
            langTableSize = languageManager.countEmployeeLanguage(txtFEmployeeId.getValue().toString());
            if (langTableSize > 0) {
                btnLAEdit.setDisabled(false);
                btnLADelete.setDisabled(false);
                for (int i = 0; i <
                        langTableSize; i++) {

                    addTotabele = new LanguageManager(
                            list[i].get("LISTENING").toString(),
                            list[i].get("SPEAKING").toString(),
                            list[i].get("READING").toString(),
                            list[i].get("WRITING").toString(),
                            list[i].get("LANGUAGE_CODE").toString(),
                            list[i].get("EMP_ID").toString(),
                            list[i].get("ID").toString(),
                            list[i].get("description").toString());
                    this.listOfLanguage.add(addTotabele);
                }

            }
        } catch (Exception ex) {
        }

    }

    void loadEmployeeTraining() {
        this.listOfEmployeeTraining.clear();
        btnTrainingNew.setDisabled(false);
        ArrayList<HashMap> employeeEducationList = employeeTrainingManager.readEmployeeTraining(txtFEmployeeId.getValue().toString());
        try {
            selectedTrainingRow = -1;
            trainingTablesize = employeeEducationList.size();
            if (trainingTablesize > 0) {

                for (HashMap hm : employeeEducationList) {
                    getListOfEmployeeTraining().add(new EmployeeTrainingManager(
                            hm.get("TRAININGNAME").toString(),
                            hm.get("INSTITUTIONNAME").toString(),
                            hm.get("START_DATE").toString(),
                            hm.get("END_DATE").toString(),
                            hm.get("EMPLOYEEID").toString(),
                            hm.get("EMP_TRA_ID").toString(),
                            hm.get("SPONSORED_BY").toString(),
                            hm.get("INSTITUTION").toString(),
                            hm.get("DURATION").toString()));
                }
                btnTrainingDelete.setDisabled(false);
                btnTrainingEdit.setDisabled(false);
                btnTrainingNew.setDisabled(false);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void loadEmployeeExperiance() {
        listOfExperience.clear();
        ArrayList<HashMap> list = employeeManager.readEmployeeExperiance(txtFEmployeeId.getValue().toString());
        EmployeeManage addTotabele = null;
        try {
            tableSize = list.size();             // employeeManager.countExperiance(txtFEmployeeId.getValue().toString());
            if (tableSize > 0) {
                btnEXDelete.setDisabled(false);
                btnEXEdit.setDisabled(false);
                for (HashMap hm : list) {
                    addTotabele = new EmployeeManage(
                            hm.get("INSTITUION").toString(),
                            hm.get("REASON_FOR_TERMINATION").toString(),
                            hm.get("RANK").toString(),
                            hm.get("START_DATE").toString(),
                            hm.get("END_DATE").toString(),
                            hm.get("SALARY").toString(),
                            hm.get("EMP_ID").toString(),
                            hm.get("JOB_TITLE").toString(),
                            hm.get("ID").toString(),
                            hm.get("PRIVATE_OR_GVTAL").toString(),
                            hm.get("PERMANENT_OR_CONTRACT").toString(),
                            hm.get("PROFESSIONINMUGHER").toString(),
                            hm.get("JOB_NAME").toString(),
                            hm.get("USETHISEXPERIENCEFORLEAVE").toString());
                    this.listOfExperience.add(addTotabele);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public String txtSearchByName1_action() {

        this.clearComponents();
        disableComponents();
        this.clearApperanceComponents();
        this.clearComponentsAddress();
        this.clearComponentsFa();
        this.clearEducationComponents();
        this.clearExperianceComponents();
        this.clearLanguageComponents();
        if (employeeManager.loadEmpoyeeProfile(this.getSelectedEmployeeId()) == 1) {
            if (employeeManager.getEmp_Status().equals("01") ||
                    employeeManager.getEmp_Status().equals("02") ||
                    employeeManager.getEmp_Status().equals("07")) {
                selectedEmployeedId = this.getSelectedEmployeeId();
                txtFEmployeeId.setValue(this.getSelectedEmployeeId());
                String fullName = employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name();
                showEmployeeFullName(fullName);
                enableAllNewButtons();
                this.setEmployeeProfile();
                this.loadEmployeeFamily();
                this.loadEmployeeAddress();
                this.loadEmployeeEducation();
                this.loadEmployeeLanguage();
                this.loadEmployeeExperiance();
                this.loadEmployeeTraining();
                this.loadEmployeeFile();
            } else {

                lblFormMessage1EmployeeStatus.setValue("This Employee is not Active.Do you wnat to display employee Data?");
                pnMessageForEmployeeStatus.setRendered(true);

            }
        } else {
            selectedEmployeedId = null;
            btnNew.setDisabled(false);
        }

        return null;
    }

    public void btnYes_processAction(ActionEvent ae) {
        popUpConfirmation.setRendered(false);
        lblPopUpMsgContaint.setValue("");
        if (employeeManager.deleteEmployee(txtFEmployeeId.getValue().toString()) == 1) {
            showSuccessOrFailureMessage(false, " record is deleted successfully!");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
            btnPopUpOk.setRendered(true);
            btnDelete.setDisabled(true);
            btnSave.setDisabled(true);
            btnEdit.setDisabled(true);
            btnReset.setDisabled(true);
            btnNew.setDisabled(false);
            txtFEmployeeId.resetValue();
            this.clearComponents();
            disableComponents();

        } else {
            showSuccessOrFailureMessage(false, " record is  Not deleted.Please  Try Agin?");
        }

    }

    public void btnNo_processAction(ActionEvent ae) {
        popUpConfirmation.setRendered(false);

    }

    public void txtMidelName_processValueChange(ValueChangeEvent vce) {
    }

    public void txtFEmployeeId_processValueChange(ValueChangeEvent vce) {
        this.newNameInput = vce.getNewValue().toString();

    }

    public void btnSaveAddressType_processAction(ActionEvent ae) {
    }

    public void panelGroup2_processMyEvent(DragEvent de) {
    }

    public void chkFemale_processValueChange(ValueChangeEvent vce) {
        chkMale.setSelected(false);
        lblValidateFamilyGender.setRendered(false);
    }

    public void chkMale_processValueChange(ValueChangeEvent vce) {
        chkFemale.setSelected(false);
        lblValidateFamilyGender.setRendered(false);
    }

    void saveFamilyinFormation(int perform) {
        int chkSave = 0;
        try {
            if (perform == 1) {//save
                employeeManager.setEmploeeId(txtFEmployeeId.getValue().toString());
                for (EmployeeManage toBeInserted : familyInformation) {
                    if (toBeInserted.getAvilbleOnDbFamily() == new_inserted) {
                        chkSave = employeeManager.saveEmployeeFamily(toBeInserted, perform);
                    }
                }
                if (chkSave == 1) {
                    disablComponentsFa();
                    showSuccessOrFailureMessage(true, "The Member Family Information Saved Successfully.");
                    familyTableSize =
                            familyTableSize + countfamily;
                    countfamily =
                            0;
                    btnFamilyNew.setDisabled(false);
                    btnFaSave.setDisabled(true);
                    btnFaEdit.setDisabled(false);
                    btnFaUpdate.setDisabled(true);
                    btnFaReset.setDisabled(false);
                    btnFaDelete.setDisabled(false);
                    btnFaAdd.setDisabled(true);
                } else {
                    showSuccessOrFailureMessage(false, "Error Occured While Saving Member Family Information. Please Try Agin?");
                    btnFamilyNew.setDisabled(true);
                    btnFaSave.setDisabled(true);
                    btnFaEdit.setDisabled(false);
                    btnFaUpdate.setDisabled(false);
                    btnFaReset.setDisabled(false);
                    btnFaDelete.setDisabled(true);
                    btnFaAdd.setDisabled(true);
                }

            } else {//update
                for (EmployeeManage toBeUpdated : familyInformation) {
                    if (toBeUpdated.getAvilbleOnDbFamily() == old_edited) {
                        chkSave = employeeManager.saveEmployeeFamily(toBeUpdated, perform);
                    }
                }

                if (chkSave == 1) {
                    showSuccessOrFailureMessage(true, "The Member Family Information Updated Successfully.");
                    this.listOfExpUpdate.clear();
                    btnFamilyNew.setDisabled(false);
                    btnFaSave.setDisabled(true);
                    btnFaEdit.setDisabled(false);
                    btnFaUpdate.setDisabled(true);
                    btnFaReset.setDisabled(false);
                    btnFaDelete.setDisabled(false);
                    btnFaAdd.setDisabled(true);
                } else {
                    showSuccessOrFailureMessage(false, "Error ccured while updating member family information. Please try agin?");
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    private void showEmployeeFullName(String fullName) {
        txtSearchByName1.setValue(fullName);
        fullName = "     Employee Name  :  " + fullName;
        lblEducFullName.setValue(fullName);
        lblExpreienceFullName.setValue(fullName);
        lblLanguageFullName.setValue(fullName);
        lblForFamilyFullName.setValue(fullName);
        lblAddressTypeFullName.setValue(fullName);
        lblTrainingFullName.setValue(fullName);
    }

    public String btnSearch_action() {
        this.getEmployeeAddress().clear();
        this.getEmployeeAdressUpdate().clear();
        this.getListOfEducation().clear();
        this.getListOfEducationUpdate().clear();
        this.listOfLanguage.clear();
        this.listOfLanguageUpdate.clear();
        this.getListOfExpUpdate().clear();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        this.getListOfExperience().clear();
        this.clearComponents();
        this.clearComponentsFa();
        this.clearApperanceComponents();
        this.clearComponentsAddress();
        this.clearEducationComponents();
        this.clearLanguageComponents();
        this.clearExperianceComponents();
        this.clearTrainingComponents();
        getListOfEmployeeTraining().clear();
        getUpdateListOfEmployeeTraining().clear();
        disableComponents();
        disablComponentsFa();
        disableAddressComponents();
        disableApperanceComponents();
        disableEducationComponents();
        disableLanguageComponents();
        disableExperianceComponents();
        disableTrainingComponents();
        try {
            if (employeeManager.loadEmpoyeeProfile(txtFEmployeeId.getValue().toString()) == 1) {
                if (employeeManager.getEmp_Status().equals("01") ||
                        employeeManager.getEmp_Status().equals("02") ||
                        employeeManager.getEmp_Status().equals("07")) {
                    selectedEmployeedId = txtFEmployeeId.getValue().toString();
                    String fullName = employeeManager.getFirst_Name() + " " +
                            employeeManager.getMiddle_Name() + " " +
                            employeeManager.getLast_Name();
                    showEmployeeFullName(fullName);
                    this.setEmployeeProfile();
                    this.loadEmployeeFamily();
                    this.loadEmployeeAddress();
                    this.loadEmployeeEducation();
                    this.loadEmployeeLanguage();
                    this.loadEmployeeExperiance();
                    this.loadEmployeeTraining();
                    this.loadEmployeeFile();
                    enableAllNewButtons();

                } else {
                    lblFormMessage1EmployeeStatus.setValue("This Employee is not Active.Do you wnat to display employee Data?");
                    pnMessageForEmployeeStatus.setRendered(true);
                }

            } else {
                selectedEmployeedId = null;
                showEmployeeFullName("");
                showSuccessOrFailureMessage(false, "There is no Member by this ID! Please insert another ID and try again?");
                btnNew.setDisabled(false);
            }

        } catch (Exception ex) {
        }

        return null;
    }

    public void btnFaReset_processAction(ActionEvent ae) {
        this.clearComponentsFa();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        disablComponentsFa();

        btnFaDelete.setDisabled(true);
        btnFaSave.setDisabled(true);
        btnFamilyNew.setDisabled(false);
        btnFaUpdate.setDisabled(true);
        btnFaEdit.setDisabled(true);
        btnFaReset.setDisabled(true);

    }

    public void btnFaEdit_action() {
        newOrEdit = "Edit";
        familybuttonIdentifier = 3;
        if (this.selectedFamilyRow == -1) {
            showSuccessOrFailureMessage(false, "First You Have To Select a Record From The Table!!!");
        } else if (this.selectedFamilyRow != -1 && this.familyInformation.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            if (dataIsOnEditFamily.equals("YES")) {
                showSuccessOrFailureMessage(false, "First finish the data you are editing");
            } else {
                dataIsOnEditFamily = "YES";
                String data;

                EmployeeManage employeeFamily = (EmployeeManage) this.familyInformation.get(this.selectedFamilyRow);
                this.familyInformation.remove(this.selectedFamilyRow);
                txtFamilyFirstName.setValue(employeeFamily.getFamily_FirstName());
                txtFamilyLastName.setValue(employeeFamily.getFamilyLastName());
                txtFamilyMiddleName.setValue(employeeFamily.getFamilyMidelName());
                drlRelationType.setValue(employeeFamily.getRelation_Type());
                try {
                    // calFamilyDateOfBirth.setValue(dateFormat.parse(employeeFamily.getDateof_Birth()));
                    txtFamilyBirthDate.setValue(employeeFamily.getDateof_Birth());
                } catch (Exception ex) {
                    ex.printStackTrace();
                    ErrorLogWriter.writeError(ex);
                }

                avilbleOnDbFamily = employeeFamily.getAvilbleOnDbFamily();
                familyId =
                        employeeFamily.getFamilyId();
                data =
                        employeeFamily.getHire();
                if (data.equals("YES")) {
                    cobHeir.setSelected(true);
                } else {
                    cobHeir.setSelected(false);
                }

                data = employeeFamily.get_sex();
                if (data.equals("Female")) {
                    chkFemale.setSelected(true);
                }

                if (data.equals("Male")) {
                    chkMale.setSelected(true);
                }

                data = employeeFamily.getAliveOrDied();
                if (data.equals("YES")) {
                    ckbFamilyAliveOrDied.setSelected(true);
                } else {
                    ckbFamilyAliveOrDied.setSelected(false);
                }

                data = employeeFamily.getEmergency_Contact();
                if (data.equals("YES")) {
                    choEmergenceyContact.setSelected(true);
                } else {
                    choEmergenceyContact.setSelected(false);
                }

                try {
                    setRelativePhoto(employeeFamily.getFamilyPhoto());
                    imgMemberFamily.setValue(getRelativePhoto());

                } catch (Exception ex) {

                    ex.printStackTrace();
                }

                btnFamilyNew.setDisabled(true);
                btnFaSave.setDisabled(true);
                btnFaEdit.setDisabled(true);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(false);
                btnFaDelete.setDisabled(true);
                btnFaAdd.setDisabled(false);
                this.enableComponentsFa();
            }

        }

        btnFamilyNew.setDisabled(true);
        btnFaSave.setDisabled(true);
        btnFaEdit.setDisabled(true);
        btnFaUpdate.setDisabled(false);
        btnFaReset.setDisabled(false);
        btnFaDelete.setDisabled(true);
        btnFaAdd.setDisabled(false);


    }

    public void button5_processAction(ActionEvent ae) {
    }

    public void btnFaDelete_processAction(ActionEvent ae) {

        if (selectedFamilyRow == -1) {
            showSuccessOrFailureMessage(false, "First select record from the table?");
        } else if (this.getFamilyInformation().isEmpty() == true && selectedFamilyRow != -1) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            lblMessagePopUpMsgMain.setValue("Are you shure You want to delete this record?");
            familyPopUpMsg.setRendered(true);
            btnYesFamilyPopUp.setRendered(true);
            btnNoFamilyPopUp.setRendered(true);

        }

    }

    public void drlAddressType_processValueChange(ValueChangeEvent vce) {
    }

    void clearComponentsAddress() {
        dataIsOnEditAddress = "NO";
        drlAddressType.resetValue();
        drlRegion.resetValue();
        drlWoreda.resetValue();
        drlZone.resetValue();
        drlKebele.resetValue();
        ////////////////////////////////
        drlAddressType.setValue("");
        drlRegion.setValue("");
        drlWoreda.setValue("");
        drlZone.setValue("");
        drlKebele.setValue("");
        //////////////////////////////////
        txtHouseNumber.setValue("");
        txtPobox.setValue("");
        txtEmail.setValue("");
        txtTelHome.setValue("");
        txtTelOffice.setValue("");
        txtMobile.setValue("");
    }

    void clearEducationComponents() {
        dataIsOnEditEducation = "NO";
        drlLevelOfEducation.setValue("");
        drlGradingScale.setValue("");
        defaultSelectedDataGradingScale.setSelectedObject(null);
        drlGradingScale.resetValue();
        drlEducationCatagories.resetValue();
        drlGradingScale.resetValue();
        txtResult.setValue("");
        txtaward.setValue("");
        txtInstitution.setValue("");
        txtDispEndEducDate.setValue("");
        txtDispStartEducDate.setValue("");
        drlTypesOfEducation.setValue("");
        drlTypesOfEducation.resetValue();
        defaultSelectedDataEducationType.setSelectedObject(null);
        defaultSelectedData30.setSelectedObject(null);
//        calEndEduc.resetValue();
//        calStartEduc.resetValue();
        txtDispStartEducDate.setValue("");
        txtDispEndEducDate.setValue("");
    }

    void disableEducationComponents() {
        drlLevelOfEducation.setDisabled(true);
        txtResult.setDisabled(true);
        txtInstitution.setDisabled(true);
        calStartEduc.setDisabled(true);
        drlTypesOfEducation.setDisabled(true);
        calEndEduc.setDisabled(true);
        txtaward.setDisabled(true);
        drlGradingScale.setDisabled(true);
        drlEducationCatagories.setDisabled(true);
    }

    void enableEducationComponents() {
        drlLevelOfEducation.setDisabled(false);
        txtResult.setDisabled(false);
        txtInstitution.setDisabled(false);
        calStartEduc.setDisabled(false);
        drlTypesOfEducation.setDisabled(false);
        calEndEduc.setDisabled(false);
        txtaward.setDisabled(false);
        drlGradingScale.setDisabled(false);
        drlEducationCatagories.setDisabled(false);

    }

    void disableAddressComponents() {
        drlAddressType.setDisabled(true);
        drlRegion.setDisabled(true);
        drlWoreda.setDisabled(true);
        drlZone.setDisabled(true);
        drlKebele.setDisabled(true);
        txtHouseNumber.setDisabled(true);
        txtPobox.setDisabled(true);
        txtEmail.setDisabled(true);
        txtTelHome.setDisabled(true);
        txtTelOffice.setDisabled(true);
        txtMobile.setDisabled(true);
    }

    void enableAddressComponents() {
        drlAddressType.setDisabled(false);
        drlRegion.setDisabled(false);
        drlWoreda.setDisabled(false);
        drlZone.setDisabled(false);
        drlKebele.setDisabled(false);
        txtHouseNumber.setDisabled(false);
        txtPobox.setDisabled(false);
        txtEmail.setDisabled(false);
        txtTelHome.setDisabled(false);
        txtTelOffice.setDisabled(false);
        txtMobile.setDisabled(false);

    }

    void clearLanguageComponents() {
        dataIsOnEditLanguage = "NO";
        drlLanguageType.setValue("-1");
        drlListening.setValue("0");
        drlSpeaking.setValue("0");
        drlWriting.setValue("0");
        drlReading.setValue("0");
    }

    void enableLanguageComponents() {
        drlLanguageType.setDisabled(false);
        drlListening.setDisabled(false);
        drlSpeaking.setDisabled(false);
        drlWriting.setDisabled(false);
        drlReading.setDisabled(false);
    }

    void disableLanguageComponents() {
        drlLanguageType.setDisabled(true);
        drlListening.setDisabled(true);
        drlSpeaking.setDisabled(true);
        drlWriting.setDisabled(true);
        drlReading.setDisabled(true);
        btnLAAdd.setDisabled(true);
    }

    void clearExperianceComponents() {
        dataIsOnEditExperience = "NO";
        calExpEndDate.resetValue();
        ckbExperiencePermanent.setSelected(false);
        ckbExperienceContract.setSelected(false);
        ckbExperienceGovernmental.setSelected(false);
        ckbExperiencePrivate.setSelected(false);
        txtExperianceInstitution.setValue("");
        txtJobType.setValue("");
        txtDisplayedExpStartDate.setValue("");
        txtExperanceSalary.setValue("");
        txtExRank.setValue("");
        txtDisplayedExpEndDate.setValue("");
        txtTermination.setValue("");
        drlProfessionInMugher.setValue("");
        ckbUsethisExperienceforLeave.setSelected(false);


    }

    void enableExperianceComponents() {
        calExpEndDate.setDisabled(false);
        ckbExperiencePermanent.setDisabled(false);
        ckbExperienceContract.setDisabled(false);
        ckbExperienceGovernmental.setDisabled(false);
        ckbExperiencePrivate.setDisabled(false);
        txtExperianceInstitution.setDisabled(false);
        txtJobType.setDisabled(false);
        txtDisplayedExpStartDate.setDisabled(false);
        txtExperanceSalary.setDisabled(false);
        txtExRank.setDisabled(false);
        txtDisplayedExpEndDate.setDisabled(false);
        txtTermination.setDisabled(false);
        drlProfessionInMugher.setDisabled(false);
        ckbUsethisExperienceforLeave.setDisabled(false);

    }

    void disableExperianceComponents() {
        calExpEndDate.setDisabled(true);
        ckbExperiencePermanent.setDisabled(true);
        ckbExperienceContract.setDisabled(true);
        ckbExperienceGovernmental.setDisabled(true);
        ckbExperiencePrivate.setDisabled(true);
        txtExperianceInstitution.setDisabled(true);
        txtJobType.setDisabled(true);
        txtDisplayedExpStartDate.setDisabled(true);
        txtExperanceSalary.setDisabled(true);
        txtExRank.setDisabled(true);
        txtDisplayedExpEndDate.setDisabled(true);
        txtTermination.setDisabled(true);
        drlProfessionInMugher.setDisabled(true);
        ckbUsethisExperienceforLeave.setDisabled(true);

    }

    public void btnADReset_processAction(ActionEvent ae) {
        this.clearComponentsAddress();
        disableAddressComponents();

        btnAddAddress.setDisabled(true);
        btnADEdit.setDisabled(true);
        btnADDelete.setDisabled(true);
        btnADNew.setDisabled(false);
        btnADReset.setDisabled(false);
        btnADSave.setDisabled(true);
        btnADUpdate.setDisabled(true);


    }

    public void optA_processValueChange(ValueChangeEvent vce) {
        optB.setSelected(false);
        optAB.setSelected(false);
        optO.setSelected(false);
        lblBloodGroup1.setRendered(false);
    }

    public void optB_processValueChange(ValueChangeEvent vce) {
        optA.setSelected(false);
        optAB.setSelected(false);
        optO.setSelected(false);
        lblBloodGroup1.setRendered(false);
    }

    public void optAB_processValueChange(ValueChangeEvent vce) {
        optB.setSelected(false);
        optA.setSelected(false);
        optO.setSelected(false);
        lblBloodGroup1.setRendered(false);
    }

    public void optO_processValueChange(ValueChangeEvent vce) {
        optB.setSelected(false);
        optAB.setSelected(false);
        optA.setSelected(false);
        lblBloodGroup1.setRendered(false);
    }

    public void btnAPEdit_processAction(ActionEvent ae) {
    }

    public String cmdApReset_action() {

        return null;
    }

    public String txtWeight_action() {

        return null;
    }

    public String inputfingerprint_action() {

        return null;
    }

    void enableApperanceComponents() {
        txtHeight.setDisabled(false);
        txtWeight.setDisabled(false);
        optA.setDisabled(false);
        optB.setDisabled(false);
        optAB.setDisabled(false);
        optO.setDisabled(false);
        txtEyeColor.setDisabled(false);
    }

    void disableApperanceComponents() {
        txtHeight.setDisabled(true);
        txtWeight.setDisabled(true);
        optA.setDisabled(true);
        optB.setDisabled(true);
        optAB.setDisabled(true);
        optO.setDisabled(true);
        txtEyeColor.setDisabled(true);
    }

    void clearApperanceComponents() {
        txtHeight.setValue("");
        txtWeight.setValue("");
        optA.setSelected(false);
        optB.setSelected(false);
        optAB.setSelected(false);
        optO.setSelected(false);
        txtEyeColor.setValue("");

    }

    public void btnAPReset_processAction(ActionEvent ae) {
        clearApperanceComponents();
        disableApperanceComponents();

        btnAPNew.setDisabled(true);
        btnAPReset.setDisabled(true);
        btnAPSave.setDisabled(true);
        btnApDelete.setDisabled(true);
        btnAPEdit.setDisabled(true);


    }

    public String cmdLaEdit_action() {

        return null;
    }

    public String btnAddExperience_action() {

        try {
            this.addEmpllooyeeExperiance();
        } catch (Exception ex) {
        }
        return null;
    }

    public String cmdExSave_action() {

        return null;
    }

    public void txtSalary_processValueChange(ValueChangeEvent vce) {
    }

    public void txtSalary_validate(FacesContext context, UIComponent component, Object value) {
        this.validateNumber(context, component, value);
    }

    public void txtMidelName_validate(FacesContext context, UIComponent component, Object value) {
        //this.validateName(context, component, value);
    }

    public void txtLastName_validate(FacesContext context, UIComponent component, Object value) {
        //this.validateName(context, component, value);
    }

    public void txtDateOfBirth_validate(FacesContext context, UIComponent component, Object value) {
        try {
            String todayInEc = StringDateManipulation.toDayInEc();

            int checDay = StringDateManipulation.compareDateDifference(txtDateOfBirth.getValue().toString(), todayInEc);
//            if (checDay < 18) {
//                txtDateOfBirth.setValidatorMessage("Invalid");
////                    ((UIInput) component).setValid(false);
////                    error(component, messageResource.getString("dateValidate"));
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    public void txtHireDate_validate(FacesContext context, UIComponent component, Object value) {
        this.validateDate(context, component, value);
    }

    public void txtFamilyFirstName_validate(FacesContext context, UIComponent component, Object value) {
        //this.validateName(context, component, value);
    }

    public void txtFamilyMiddleName_validate(FacesContext context, UIComponent component, Object value) {
        //  this.validateName(context, component, value);
    }

    public void txtFamilyLastName_validate(FacesContext context, UIComponent component, Object value) {
        ///this.validateName(context, component, value);
    }

    public void txtFamilyDateOfBirth_validate(FacesContext context, UIComponent component, Object value) {
        // this.validateDate(context, component, value);
    }

    public void txtPobox_validate(FacesContext context, UIComponent component, Object value) {
        //  this.validateDate(context, component, value);
    }

    public void txtTelOffice_validate(FacesContext context, UIComponent component, Object value) {
        // this.validateTelephone(context, component, value);
    }

    public void txtTelHome_validate(FacesContext context, UIComponent component, Object value) {
        //  this.validateTelephone(context, component, value);
    }

    public void txtMobile_validate(FacesContext context, UIComponent component, Object value) {
        // this.validateTelephone(context, component, value);
    }

    public void txtEmail_validate(FacesContext context, UIComponent component, Object value) {
        this.validateEmail(context, component, value);
    }

    public String cmdApEdit_action() {

        if (btnAPEdit.getValue().equals("Edit")) {
            btnAPEdit.setValue("Update");
            enableApperanceComponents();

        } else {
            if (optA.isSelected() || optB.isSelected() || optAB.isSelected() || optO.isSelected()) {
                lblBloodGroup1.setRendered(false);
                this.saveEmployeeApperance(2);
            } else {
                lblBloodGroup1.setRendered(true);
                lblBloodGroup1.setValue("Required");
            }

        }
        return null;
    }

    public String btnAYes_action() {
        popUpConfirmation.setRendered(true);
        btnYes.setRendered(false);
        btnNo.setRendered(false);
        btnPopUpOk.setRendered(true);
        btnAYes.setRendered(false);
        if (employeeManager.deleteEmployeeAppreance(txtFEmployeeId.getValue().toString()) == 1) {
            lblPopUpMsgContaint.setValue("The Member Apperance information  Deleted Successfully.");
            clearApperanceComponents();

            btnAPNew.setDisabled(false);
            btnAPReset.setDisabled(true);
            btnAPSave.setDisabled(true);
            btnApDelete.setDisabled(true);
            btnAPEdit.setDisabled(true);
            disableApperanceComponents();

        } else {
            lblPopUpMsgContaint.setValue("The Member Apperance information Not  Deleted.Please Try Agin?");
        }

        return null;
    }

//    public String button5_action() {
//
//        if (educationManager.deleteEmployeeEducation(txtFEmployeeId.getValue().toString()) == 1) {
//            popUpConfirmation.setRendered(true);
//            lblPopUpMsgContaint.setValue(txtFirstName.getValue() + "  " + txtMidelName.getValue() + "  " + txtLastName.getValue() + " Education  deleted successfully!");
//            btnYes.setRendered(false);
//            btnNo.setRendered(false);
//            btnPopUpOk.setRendered(true);
//            this.clearComponents();
//        } else {
//            popUpConfirmation.setRendered(true);
//            lblPopUpMsgContaint.setValue(txtFirstName.getValue() + "  " + txtMidelName.getValue() + "  " + txtLastName.getValue() + " Education Not deleted Please Try Agin");
//            btnYes.setRendered(false);
//            btnNo.setRendered(false);
//            btnPopUpOk.setRendered(true);
//        }
//        return null;
//    }
    public String btnDeleteYesEducation_action() {

        btnDeleteYesEducation.setRendered(false);
        if (educationManager.deleteEmployeeEducation(txtFEmployeeId.getValue().toString().trim()) == 1) {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("Member Education Profile  Deleted Successfuly.");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
            btnPopUpOk.setRendered(true);

        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("Member Education Profile Not Deleted Try Agin.");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
            btnPopUpOk.setRendered(true);
        }

        return null;
    }

    public String cmdLaReset_action() {

        clearLanguageComponents();
        disableLanguageComponents();

        btnLASave.setDisabled(true);
        btnLASave.setValue("New");
        btnLAEdit.setValue("Edit");
        btnLAEdit.setDisabled(true);
        btnLADelete.setDisabled(true);
        return null;
    }

    public void drlBachCode_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                if (!vce.getNewValue().toString().equals("BachCode") && !vce.getNewValue().toString().equals("0")) {
                    drlCandidateName.setDisabled(false);
                    this.setCandidateName(ruitmentManager.candidateName(vce.getNewValue().toString()));
                } else {
//                  clearComponents();
//                  disableComponents();
                    drlCandidateName.setDisabled(true);
                    chkCrimeFree.setDisabled(true);
                    chkMedicalFit.setDisabled(true);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

    void displayCandidateName(String candidateID) {
        try {
            checkCandidate = true;
            
            HashMap candidateList = candidateManager.selectCandidate(candidateID);
            if (candidateList != null) {
                txtFirstName.setValue(candidateList.get("CANDIDATE_F_NAME"));
                txtMidelName.setValue(candidateList.get("CANDIDATE_M_NAME"));
                txtLastName.setValue(candidateList.get("CANDIDATE_L_NAME"));
                 txtBirthDate.setValue(candidateList.get("DATEOFBIRTH"));
               // txtDateOfBirth.setValue(candidateList.get("DATEOFBIRTH"));
                if (candidateList.get("GENDER").equals("Female")) {
                    ckbSexFemale.setSelected(true);
                }

                if (candidateList.get("GENDER").equals("Male")) {
                    ckbSexMale.setSelected(true);
                }
                enableComponents();

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void drlCandidateName_processValueChange(ValueChangeEvent vce) {
        clearApperanceComponents();
        clearComponents();
        clearComponentsAddress();
        clearComponentsFa();
        clearEducationComponents();
        clearExperianceComponents();
        clearLanguageComponents();
        if (!drlCandidateName.getValue().equals("Select")) {
            displayCandidateName(vce.getNewValue().toString());
        }

    }

    public void chkMedicalFit_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForCandidate.setRendered(false);
//        disablComponentsFa();
//        disableAddressComponents();
//        disableApperanceComponents();
//        disableExperianceComponents();
//        disableEducationComponents();
//        disableLanguageComponents();
//        if(chkMedicalFit.isSelected()&&chkCrimeFree.isSelected()){
//          //  enableAddressComponents();
//        //    enableApperanceComponents();
//            enableComponentsFa();
//                }
    }

    public void chkCrimeFree_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForCandidate.setRendered(false);
    }

    public void txtHeight_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String cmdDispline_action() {
        return null;
    }

    public String cmdRetirement_action() {
        return "Terminationrequest";
    }

    public String cmdEmployeeProfile_action() {
        return "EmployeeProfile";
    }

    public String cmdRecruitment_action() {
        return "RequirementRequest";
    }

    public String cmdWillRegistration_action() {
        return "EmployeeWill";
    }

    public String cmdFamilyUpdatePersonal_action() {

        return null;
    }

    public String btnEducationCalender_action() {
        return null;
    }

    public void drlPayGrade_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            txtSalary.setDisabled(false);
            txtSalary.setValue(lookUpManager.readSalary(drlRankId.getValue().toString(), drlPayGrade.getValue().toString()));
        }

    }

    public String btnFaNew_action() {
        familybuttonIdentifier = 1;
        if (txtFEmployeeId.getValue() != null) {
            this.clearComponentsFa();
            this.enableComponentsFa();
            if (dataTable.getRowCount() > 0) {
                // btnFaNew.setDisabled(true);
                btnFaSave.setDisabled(false);
                btnFaEdit.setDisabled(false);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(false);
                btnFaDelete.setDisabled(false);
                btnFaAdd.setDisabled(false);
            } else {
                // btnFaNew.setDisabled(true);
                btnFaSave.setDisabled(false);
                btnFaEdit.setDisabled(true);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(false);
                btnFaDelete.setDisabled(true);
                btnFaAdd.setDisabled(false);
            }

        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Family Information ?");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
        }

        return null;
    }

    public void panelCollapsible5_processAction(ActionEvent ae) {
        panelCollapsible5.setExpanded(true);
//        colEmergercyContact.setExpanded(false);
    }

    public String modalPnlCloseBtnDateSetting_action() {

        pnlPopUpDateSetting.setRendered(false);
        return null;
    }

    public String btnUpdate_action() {
        if (selectedEmployeedId == null) {
            showSuccessOrFailureMessage(false, "   FIRST SELECT EMPLOYEE");
        } else {
            this.savePersonalInformation(2);
        }

        return null;
    }

    public void btnEdit_processAction(ActionEvent ae) {
        this.enableComponents();
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnSave.setDisabled(true);
        btnNew.setDisabled(true);
        btnUpdate.setDisabled(false);
    }

    public String btnNew2_action() {

        adressTableSize = 0;
        langTableSize =
                0;
        educTableSize =
                0;
        tableSize =
                0;
        familyTableSize =
                0;
        counter =
                0;
        lanCounter =
                0;
        educCounter =
                0;
        countAdress =
                0;
        countfamily =
                0;
        this.getEmployeeAddress().clear();
        this.getEmployeeAdressUpdate().clear();
        this.getListOfExpUpdate().clear();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        this.getListOfExperience().clear();
        this.getListOfEducation().clear();
        this.getListOfEducationUpdate().clear();
        this.listOfLanguage.clear();
        this.listOfLanguageUpdate.clear();
        this.getListOfExperience().clear();
        this.getListOfExpUpdate().clear();
        this.clearComponents();
        this.clearComponentsFa();
        this.clearApperanceComponents();
        this.clearComponentsAddress();
        this.clearEducationComponents();
        this.clearLanguageComponents();
        this.clearExperianceComponents();
        btnSave.setDisabled(false);
        btnEDNew.setDisabled(false);
        txtFEmployeeId.setDisabled(false);
        this.enableComponents();
        btnNew.setDisabled(true);
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(false);
        return null;
    }

    public String btnFaUpdate_action() {
        familybuttonIdentifier = 4;
        this.saveFamilyinFormation(2);
        return null;
    }

    public String btnADNew_action() {
        newOrEdit = "New";
        dataIsOnEditAddress =
                "NO";
        addressButtonIdentifier =
                1;
        int n;
        try {
            n = tblAddress.getRowCount();
            if (n != 0) {
                this.clearComponentsAddress();
                this.enableAddressComponents();
                btnAddAddress.setDisabled(false);
                btnADNew.setDisabled(true);
                btnADSave.setDisabled(true);
                btnADEdit.setDisabled(false);
                btnADUpdate.setDisabled(true);
                btnADDelete.setDisabled(false);
                btnADReset.setDisabled(false);
            } else {
                if (txtFEmployeeId.getValue() != null) {

                    this.clearComponentsAddress();
                    this.enableAddressComponents();
                    btnADNew.setDisabled(true);
                    btnADSave.setDisabled(false);
                    btnADEdit.setDisabled(true);
                    btnADUpdate.setDisabled(true);
                    btnADDelete.setDisabled(true);
                    btnADReset.setDisabled(false);
                    btnAddAddress.setDisabled(false);

                } else {
                    popUpConfirmation.setRendered(true);
                    lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Address ?");
                    btnYes.setRendered(false);
                    btnNo.setRendered(false);

                }

            }
        } catch (Exception ex) {
        }





















        return null;
    }

    public String btnADUpdate_action() {

        this.saveEmployeeAddress(2);
        return null;
    }

    public String btnAPNew_action() {


//        btnAPEdit.setDisabled(true);
//        btnAPDelete.setDisabled(true);
        if (txtFEmployeeId.getValue() != null) {
            enableApperanceComponents();
            clearApperanceComponents();

            btnAPNew.setDisabled(true);
            btnAPReset.setDisabled(false);
            btnAPSave.setDisabled(false);
            btnApDelete.setDisabled(true);
            btnAPEdit.setDisabled(true);
        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Appearance ?");
            btnYes.setRendered(false);
            btnNo.setRendered(false);

        }

        return null;
    }

    public String btnAPUpdate_action() {

        if (optA.isSelected() || optB.isSelected() || optAB.isSelected() || optO.isSelected()) {
            lblBloodGroup1.setRendered(false);
            this.saveEmployeeApperance(2);
        } else {
            lblBloodGroup1.setRendered(true);
            lblBloodGroup1.setValue("Required");

        }

        return null;
    }

    public String btnAPEdit_action() {

        enableApperanceComponents();
        btnAPNew.setDisabled(true);
        btnAPReset.setDisabled(false);
        btnAPSave.setDisabled(true);
        btnApDelete.setDisabled(true);
        btnAPEdit.setDisabled(true);
        return null;
    }

    public String cmdLeanguageAdd_action() {

        return null;
    }

    public String btnEDNew_action() {
        newOrEdit = "New";
        current_action =
                "NewEducation";
        if (txtFEmployeeId.getValue() != null) {
            buttonIdentifierEduc = 1;
            this.clearEducationComponents();
            this.enableEducationComponents();
            if (educTableSize > 0) {
                btnEDNew.setDisabled(true);
                btnEDSave.setDisabled(false);
                btnEDEdit.setDisabled(false);
                btnEDUpdate.setDisabled(true);
                btnEDDelete.setDisabled(false);
                btnEDReset.setDisabled(false);
                cmdEducationAdd.setDisabled(false);
            } else {
                btnEDNew.setDisabled(true);
                btnEDSave.setDisabled(false);
                btnEDEdit.setDisabled(true);
                btnEDUpdate.setDisabled(true);
                btnEDDelete.setDisabled(true);
                btnEDReset.setDisabled(false);
                cmdEducationAdd.setDisabled(false);
            }

        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Education ?");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
        }

        return null;
    }

    /**
     * this method used to delete members familys Individually
     * this metod call confiramation metode
     * @return
     */
    public String cmdFaRemove_action() {

        return null;
    }

    public void txtInstitution_validate(FacesContext context, UIComponent component, Object value) {
    }

    public String btnEDUpdate_action() {
        current_action = "UpdateEducation";
        this.saveEmployeeEducation(2);
        btnSearch_action();

        return null;
    }

    public String btnLANew_action() {

        buttonIdentifierLang = 1;
        try {
            if (txtFEmployeeId.getValue() != null) {
                if (tblLanguageTable.getRowCount() > 0) {
                    this.clearLanguageComponents();
                    this.enableLanguageComponents();
                    btnLANew.setDisabled(true);
                    btnLASave.setDisabled(false);
                    btnLAEdit.setDisabled(false);
                    btnLAUpdate.setDisabled(true);
                    btnLAReset.setDisabled(false);
                    btnLADelete.setDisabled(false);
                    btnLAAdd.setDisabled(false);
                } else {
                    this.clearLanguageComponents();
                    this.enableLanguageComponents();
                    btnLANew.setDisabled(true);
                    btnLASave.setDisabled(false);
                    btnLAEdit.setDisabled(true);
                    btnLAUpdate.setDisabled(true);
                    btnLAReset.setDisabled(false);
                    btnLADelete.setDisabled(true);
                    btnLAAdd.setDisabled(false);
                }

            } else {
                popUpConfirmation.setRendered(true);
                lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Language skill ?");
                btnYes.setRendered(false);
                btnNo.setRendered(false);
            }

        } catch (Exception ex) {
        }
        return null;
    }

    public String btnLASave_action() {
        this.saveEmployeeLanguage(1);
        btnSearch_action();

        return null;
    }

    public String btnLAUpdate_action() {

        this.saveEmployeeLanguage(2);
        return null;
    }

    public String btnLAEdit_action() {
        buttonIdentifierLang = 3;
        try {
            if (this.selecteLanguageRow == -1) {
                showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            } else if (this.selecteLanguageRow != -1 && this.listOfLanguage.isEmpty() == true) {
                showSuccessOrFailureMessage(false, "The Table is Empty!");
            } else {


                if (dataIsOnEditLanguage.equals("YES")) {
                    showSuccessOrFailureMessage(false, "First finish the data you are editing");
                } else {
                    dataIsOnEditLanguage = "YES";
                    this.enableLanguageComponents();
                    LanguageManager languageInformation = (LanguageManager) listOfLanguage.get(this.selecteLanguageRow);
                    listOfLanguage.remove(this.selecteLanguageRow);
                    drlLanguageType.setValue(languageInformation.getLanguageType());
                    drlSpeaking.setValue(languageInformation.getSpeaking());
                    drlReading.setValue(languageInformation.getReading());
                    drlWriting.setValue(languageInformation.getWriting());
                    drlListening.setValue(languageInformation.getListening());
                    languageId =
                            languageInformation.getId();
                    btnLANew.setDisabled(true);
                    btnLASave.setDisabled(true);
                    //   btnLAEdit.setDisabled(true);
                    btnLAUpdate.setDisabled(false);
                    btnLAReset.setDisabled(false);
                    btnLADelete.setDisabled(true);
                    btnLAAdd.setDisabled(false);
                    if (selecteLanguageRow >= langTableSize) {
                        buttonIdentifierLang = 2;
                        lanCounter--;

                        btnLANew.setDisabled(true);
                        btnLASave.setDisabled(false);
                        btnLAEdit.setDisabled(true);
                        btnLAUpdate.setDisabled(true);
                        btnLAReset.setDisabled(false);
                        btnLADelete.setDisabled(true);
                        btnLAAdd.setDisabled(false);
                    }

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String btnEXNew_action() {

        buttonIdentifier = 1;
        if (txtFEmployeeId.getValue() != null) {
            this.clearExperianceComponents();
            this.enableExperianceComponents();
            if (tableExperiance.getRowCount() > 0) {
                btnEXNew.setDisabled(true);
                btnEXSave.setDisabled(false);
                btnEXEdit.setDisabled(false);
                btnEXUpdate.setDisabled(true);
                btnEXReset.setDisabled(false);
                btnEXDelete.setDisabled(false);
                btnAddExperience.setDisabled(false);

            } else {
                btnEXNew.setDisabled(true);
                btnEXSave.setDisabled(false);
                btnEXEdit.setDisabled(true);
                btnEXUpdate.setDisabled(true);
                btnEXReset.setDisabled(false);
                btnEXDelete.setDisabled(true);
                btnAddExperience.setDisabled(false);
            }

        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Experance ?");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
        }

        return null;
    }

    public String btnEXSave_action() {
        this.saveEmployeeExperiance(1);
        btnSearch_action();

        return null;
    }

    public void tnEXSave_processAction(ActionEvent ae) {
    }

    public String btnEXUpdate_action() {

        buttonIdentifier = 4;
        this.saveEmployeeExperiance(2);
        return null;
    }

    public void rowSelectorEvaSession_processMyEvent(RowSelectorEvent rse) {
        selectedFamilyRow = rse.getRow();
        btnFaEdit.setDisabled(false);
        btnFaDelete.setDisabled(false);
    }

    public String btnYesFamilyPopUp_action() {

        try {
            int rowNumber = selectedFamilyRow;
            EmployeeManage familyInformation = (EmployeeManage) this.getFamilyInformation().get(rowNumber);
            if (employeeManager.deleteEmployeeFamily(familyInformation.getFamilyId()) == 1) {
                familyPopUpMsg.setRendered(false);
                this.getFamilyInformation().remove(rowNumber);
                popUpConfirmation.setRendered(true);
                lblPopUpMsgContaint.setValue("The Member Family Profile Delete Successfully.");
                btnYes.setRendered(false);
                btnNo.setRendered(false);
                btnYesAddressPopUp.setRendered(false);
                btnNoFamilyPopUp.setRendered(false);
                btnYesFamilyPopUp.setRendered(false);
                btnNoAddressPopUp.setRendered(false);
                btnDeleteYesEducation.setRendered(false);

                this.disablComponentsFa();
                this.clearComponentsFa();
                if (dataTable.getRowCount() == 0) {
                    btnFaDelete.setDisabled(true);
                    btnFaEdit.setDisabled(true);
                }

                btnFaSave.setDisabled(true);
                //  btnFaNew.setDisabled(false);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(true);
                selectedFamilyRow =
                        -1;


            } else {
                popUpConfirmation.setRendered(true);
                lblPopUpMsgContaint.setValue("The Member Family Profile Not Delete .");
                btnYes.setRendered(false);
                btnNo.setRendered(false);
                this.disablComponentsFa();
                btnYesFamilyPopUp.setRendered(false);


            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public String btnNoFamilyPopUp_action() {

        familyPopUpMsg.setRendered(false);
        return null;
    }

    public void rowSelectorEmployeeAddress_processMyEvent(RowSelectorEvent rse) {
        selectedAddressRow = rse.getRow();
    }

    public String btnNoAddressPopUp_action() {

        familyPopUpMsg.setRendered(false);
        return null;
    }

    public String btnYesAddressPopUp_action() {

        int rowNumber = selectedAddressRow;
        EmployeeManage familyInformation = (EmployeeManage) getEmployeeAddress().get(rowNumber);
        familyPopUpMsg.setRendered(false);

        if (employeeManager.deleteEmployeeAddress(familyInformation.getId()) == 1) {
            getEmployeeAddress().remove(rowNumber);

//            drlRegion.setValue("");
//            drlWoreda.setValue("");
//            drlZone.setValue("");
//            drlKebele.setValue("");
//            txtHouseNumber.setValue("");
//            txtPobox.setValue("");
//            txtEmail.setValue("");
//            txtTelHome.setValue("");
//            txtTelOffice.setValue("");
//            txtMobile.setValue("");
//            drlAddressType.setValue("");
//            disableAddressComponents();
//            lblPopUpMsgContaint.setValue("The Member Address Delete Successfully.");
//            btnYes.setRendered(false);
//            btnNo.setRendered(false);
//            btnYesAddressPopUp.setRendered(false);
//            btnNoAddressPopUp.setRendered(false);
//            btnYesFamilyPopUp.setRendered(false);
//            btnNoFamilyPopUp.setRendered(false);
//            this.disablComponentsFa();
//            this.clearComponentsFa();
//
//



            disableAddressComponents();

            clearComponentsAddress();

            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("The Member Address Profile Delete Successfully.");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
            btnDeleteYesEducation.setRendered(false);

            if (tblAddress.getRowCount() == 0) {
                btnADDelete.setDisabled(true);
                btnADEdit.setDisabled(true);
            }

            btnADSave.setDisabled(true);
            btnADNew.setDisabled(false);
            btnADUpdate.setDisabled(true);
            btnADReset.setDisabled(true);
            btnAddAddress.setDisabled(true);

            selectedAddressRow =
                    -1;


        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("The Member Address Profile Not Delete .");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
            this.disablComponentsFa();
        }

        return null;
    }

    public void drlLanguageType_processValueChange(ValueChangeEvent vce) {
        try {
            drlWriting.setValue("Good");
            drlSpeaking.setValue("Good");
            drlListening.setValue("Good");
            drlReading.setValue("Good");
        } catch (Exception e) {
        }
    }

    public void rowSelectorEmployeeEducation_processMyEvent(RowSelectorEvent rse) {
        selecteEducationRow = rse.getRow();
        btnEDEdit.setDisabled(false);
        btnEDDelete.setDisabled(false);
    }

    public void rowSelectorEmployeeLanguage_processMyEvent(RowSelectorEvent rse) {
        selecteLanguageRow = rse.getRow();
    }

    public String btnEDSave_action() {
        current_action = "SaveEducation";
        this.saveEmployeeEducation(1);
        return null;
    }

    public String btnEdit_action() {
        excelDataPhoto = true;
        txtSalary.setDisabled(false);
        return null;
    }

    public String btnDelete_action() {

        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete all " + employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + "  " + employeeManager.getLast_Name() + " information ?");
        popupIdentifier =
                7;
        return null;
    }

    public void drlDivision_validate(FacesContext context, UIComponent component, Object value) {
    }

    public void rowSelectorEmployeeExperance_processMyEvent(RowSelectorEvent rse) {
        selectedExperience = rse.getRow();
    }

    public String btnEXEdit_action() {
        buttonIdentifier = 3;
        if (this.selectedExperience == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selectedExperience != -1 && this.listOfExperience.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            if (dataIsOnEditExperience.equals("YES")) {
                showSuccessOrFailureMessage(false, "First finish the data you are editing");
            } else {
                dataIsOnEditExperience = "YES";
                EmployeeManage employeeExperiance = (EmployeeManage) this.listOfExperience.get(this.selectedExperience);
                this.listOfExperience.remove(this.selectedExperience);
                txtExperianceInstitution.setValue(employeeExperiance.getInstitution());
                txtJobType.setValue(employeeExperiance.getJob_Code());
                try {
                    // calExpStartDate.setValue(dateFormat.parse(employeeExperiance.getStartDate()));
                    txtDisplayedExpStartDate.setValue(employeeExperiance.getStartDate());
                    txtDisplayedExpEndDate.setValue(employeeExperiance.getCopletionDate());
                } catch (Exception ex) {
                    Logger.getLogger(EmployeePage.class.getName()).log(Level.SEVERE, null, ex);
                }

                if (employeeExperiance.getExperienceContractOrPrtmanent().equals("Cont")) {
                    experienceContractOrPrtmanent = "Cont";
                    ckbExperienceContract.setSelected(true);
                    ckbExperiencePermanent.setSelected(false);
                } else if (employeeExperiance.getExperienceContractOrPrtmanent().equals("Perm")) {
                    experienceContractOrPrtmanent = "Perm";
                    ckbExperienceContract.setSelected(false);
                    ckbExperiencePermanent.setSelected(true);
                }

                if (employeeExperiance.getExperiencePrivateOrGovernmental().equals("Prv")) {
                    experiencePrivateOrGovernmental = "Pvt";
                    ckbExperienceGovernmental.setSelected(false);
                    ckbExperiencePrivate.setSelected(true);
                } else if (employeeExperiance.getExperiencePrivateOrGovernmental().equals("Gvt")) {
                    experiencePrivateOrGovernmental = "Gvt";
                    ckbExperienceGovernmental.setSelected(true);
                    ckbExperiencePrivate.setSelected(false);
                }
                if (employeeExperiance.getExperienceValidForLeave().equals("YES")) {
                    ckbUsethisExperienceforLeave.setSelected(true);
                } else {
                    ckbUsethisExperienceforLeave.setSelected(false);
                }
                drlProfessionInMugher.setValue(employeeExperiance.getExperienceRelationinInMugherJobCode() + "--" +
                        employeeExperiance.getExperienceRelationinInMugherJobDescription());
                txtTermination.setValue(employeeExperiance.getTerminationReason());
                txtExRank.setValue(employeeExperiance.getRank());
                txtExperanceSalary.setValue(employeeExperiance.getSalary());
                experianceId =
                        employeeExperiance.getId();
                btnEXNew.setDisabled(true);
                btnEXSave.setDisabled(true);
                //  btnEXEdit.setDisabled(true);
                btnEXUpdate.setDisabled(true);
                btnEXReset.setDisabled(false);
                btnEXDelete.setDisabled(true);
                btnAddExperience.setDisabled(false);
                this.enableExperianceComponents();
                if (this.selectedExperience >= tableSize) {
                    buttonIdentifier = 2;
                    this.counter--;
                }

            }
        }
        return null;
    }

    public String btnFaSave_action() {
        this.saveFamilyinFormation(1);
        btnSearch_action();

        return null;
    }
    String newOrEdit = "New";
    String dataIsOnEditFamily = "NO";
    String dataIsOnEditEducation = "NO";
    String dataIsOnEditExperience = "NO";
    String dataIsOnEditLanguage = "NO";
    String dataIsOnEditAddress = "NO";

    public String btnFamilyNew_action() {
        newOrEdit = "New";
        String familyBirthDate = "1900-01-01";
        familybuttonIdentifier =
                1;
        ckbFamilyAliveOrDied.setSelected(true);
        if (selectedEmployeedId != null) {
            this.clearComponentsFa();
            this.enableComponentsFa();
            if (dataTable.getRowCount() > 0) {
                btnFamilyNew.setDisabled(true);
                btnFaSave.setDisabled(true);
                btnFaEdit.setDisabled(false);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(false);
                btnFaDelete.setDisabled(false);
                btnFaAdd.setDisabled(false);
            } else {
                btnFamilyNew.setDisabled(true);
                btnFaSave.setDisabled(true);
                btnFaEdit.setDisabled(true);
                btnFaUpdate.setDisabled(true);
                btnFaReset.setDisabled(false);
                btnFaDelete.setDisabled(true);
                btnFaAdd.setDisabled(false);
            }

        } else {
            popUpConfirmation.setRendered(true);
            lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Family Information ?");
            btnYes.setRendered(false);
            btnNo.setRendered(false);
        }

        return null;
    }

   
    public String btnAddAddress_action()
            {

        try {
            String regionDescrption = lookUpManager.readRegionDescrption(drlRegion.getValue().toString());
            String zoneDescription = lookUpManager.readZonenDescrption(drlZone.getValue().toString());
            String woredaDescription = lookUpManager.readWoredaDescrption(drlWoreda.getValue().toString());
            String kebelleDescription=lookUpManager.readKebelleDescrption(drlKebele.getValue().toString()); 
            String poBox = "";
            String sefere="";
            String email = "";
            String telMobile = "";
            String telOffice = "";
            String telHome = "";

            if (!txtTelHome.getValue().equals(null)) {
                telHome = txtTelHome.getValue().toString().trim();
            }

            if (!txtTelOffice.getValue().equals(null)) {
                telOffice = txtTelOffice.getValue().toString().trim();
            }

            if (!txtMobile.getValue().equals(null)) {
                telMobile = txtMobile.getValue().toString().trim();
            }

            if (!txtEmail.getValue().equals(null)) {
                email = txtEmail.getValue().toString().trim();
            }

            if (!txtPobox.getValue().equals(null)) {
                poBox = txtPobox.getValue().toString().trim();
            }
             if (!txt_Sefere.getValue().equals(null)) {
                sefere = txt_Sefere.getValue().toString().trim();
            }

            if (newOrEdit.equals("Edit"))
            {
                databaseStatus = old_edited;
            } else {
                databaseStatus = new_inserted;
                dataIsOnEditAddress =
                        "NO";
            }

            EmployeeManage employeeAdress = new EmployeeManage(
                    selectedEmployeedId,
                    drlRegion.getValue().toString(),
                    drlZone.getValue().toString(),
                    drlWoreda.getValue().toString(),
                    drlKebele.getValue().toString(),
                    txtHouseNumber.getValue().toString().trim(),
                    telHome,
                    telOffice,
                    telMobile,
                    email,
                    poBox,
                    drlAddressType.getValue().toString(),
                    addressId,
                    databaseStatus,// avilabelOnDb,
                    regionDescrption,
                    zoneDescription,
                    woredaDescription,
                    kebelleDescription,
                    sefere,
                    databaseStatus);
            if (addressButtonIdentifier == 1 || addressButtonIdentifier == 2) {
                countAdress++;
                this.employeeAddress.add(employeeAdress);
                btnADDelete.setDisabled(false);
                btnADEdit.setDisabled(false);
                btnADSave.setDisabled(false);
                this.btnADUpdate.setDisabled(true);
            } else if (addressButtonIdentifier == 3) {
                this.employeeAddress.add(this.selectedAddressRow, employeeAdress);
                this.employeeAdressUpdate.add(employeeAdress);
                this.btnADEdit.setDisabled(false);
                this.btnADUpdate.setDisabled(false);
                btnADDelete.setDisabled(false);
                this.disableAddressComponents();
            }

            this.clearComponentsAddress();
        } catch (Exception ex) {
        }

        return null;
    }

    public String btnADSave_action() {
        this.saveEmployeeAddress(1);
        btnSearch_action();

        return null;
    }

    public String btnADEdit_action() {
        newOrEdit = "Edit";
        btnADReset.setDisabled(false);
        try {
            addressButtonIdentifier = 3;
            if (selectedAddressRow == -1) {
                showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            } else if (this.employeeAddress.isEmpty()) {
                showSuccessOrFailureMessage(false, "The Table is Empty!");

            } else {
                if (dataIsOnEditAddress.equals("YES")) {
                    showSuccessOrFailureMessage(false, "First finish the data you are editing");
                } else {
                    dataIsOnEditAddress = "NO";
                    EmployeeManage employeeAddressList = (EmployeeManage) this.employeeAddress.get(this.selectedAddressRow);
                    this.employeeAddress.remove(this.selectedAddressRow);
                    drlAddressType.setValue(employeeAddressList.getAddressType());
                    drlRegion.setValue(employeeAddressList.getRegion());
                    zoneList =
                            lookUpManager.readZoneOrCityInARegion(employeeAddressList.getRegion());
                    drlZone.setValue(employeeAddressList.getZoneCity());
                    woredaList =
                            lookUpManager.readWoredaAndZone(employeeAddressList.getZoneCity());
                    drlWoreda.setValue(employeeAddressList.getWoredaSubCity());
                    kebeleList =
                            lookUpManager.readKebelleInSubCity(employeeAddressList.getWoredaSubCity());
                    drlKebele.setValue(employeeAddressList.getKebelle());
                    txtHouseNumber.setValue(employeeAddressList.getHouseNumber());
                    if (employeeAddressList.getPobox().equals("Not Register")) {
                        txtPobox.setValue("");
                    } else {
                        txtPobox.setValue(employeeAddressList.getPobox());
                    }

                    if (employeeAddressList.getEmail().equals("Not Register")) {
                        txtEmail.setValue("");
                    } else {
                        txtEmail.setValue(employeeAddressList.getEmail());
                    }

                    if (employeeAddressList.getTelNumberHome().equals("Not Register")) {
                        txtTelHome.setValue("");
                    } else {
                        txtTelHome.setValue(employeeAddressList.getTelNumberHome());
                    }

                    if (employeeAddressList.getTelNumberOffice().equals("Not Register")) {
                        txtTelOffice.setValue("");
                    } else {
                        txtTelOffice.setValue(employeeAddressList.getTelNumberOffice());
                    }

                    if (employeeAddressList.getTelNumberMobile().equals("Not Register")) {
                        txtMobile.setValue("");
                    } else {
                        txtMobile.setValue(employeeAddressList.getTelNumberMobile());
                    }

                    addressId = employeeAddressList.getId();
                    // this.enableAddressComponents();
                    btnAddAddress.setDisabled(false);
                    btnAddAddress.setDisabled(false);
                    avilabelOnDb =
                            1;
                    if (selectedAddressRow >= adressTableSize) {
                        addressButtonIdentifier = 2;
                        countAdress--;

                    }


                }
            }
            this.enableAddressComponents();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;
    }

    public String btnLAAdd_action() {
        this.addEmployeeLanguage();

        return null;
    }

    public String btntemployeePopUpYes_action() {
        try {

            employeePlanPopUpMsg.setRendered(false);
            if (popupIdentifier == 1) {
                popupIdentifier = 0;
                int chekDelete = 0;
                int rowNumber = this.selectedExperience;
                EmployeeManage experienceO = (EmployeeManage) listOfExperience.get(rowNumber);
                chekDelete =
                        employeeManager.deleteEmployeeExperiance(experienceO.getId());
                if (chekDelete == 1) {
                    listOfExperience.remove(rowNumber);
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    tableSize--;

                    this.selectedExperience = -1;

                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 2) {
                popupIdentifier = 0;
                int chekDelete = 0;
                int rowNumber = this.selecteLanguageRow;
                LanguageManager languageO = (LanguageManager) this.listOfLanguage.get(rowNumber);
                chekDelete =
                        languageManager.deleteEmployeeLanguage(languageO.getId());
                if (chekDelete == 1) {
                    listOfLanguage.remove(rowNumber);
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    this.langTableSize--;
                    this.selecteLanguageRow = -1;
                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 3) {
                popupIdentifier = 0;
                int chekDelete = 0;
                int rowNumber = this.selecteEducationRow;
                EducationManager educationO = (EducationManager) this.listOfEducation.get(rowNumber);
                chekDelete =
                        educationManager.deleteEmployeeEducation(educationO.getId());
                if (chekDelete == 1) {
                    listOfEducation.remove(rowNumber);
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    this.educTableSize--;
                    this.selecteEducationRow = -1;
                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 4) {
                popupIdentifier = 0;
                int chekDelete = 0;
                chekDelete =
                        employeeManager.deleteEmployeeAppreance(txtFEmployeeId.getValue().toString());
                if (chekDelete == 1) {
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    clearApperanceComponents();

                    btnAPNew.setDisabled(false);
                    btnAPReset.setDisabled(true);
                    btnAPSave.setDisabled(true);
                    btnApDelete.setDisabled(true);
                    btnAPEdit.setDisabled(true);
                    disableApperanceComponents();

                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 5) {
                popupIdentifier = 0;
                int chekDelete = 0;
                int rowNumber = this.selectedAddressRow;
                EmployeeManage addressDel = (EmployeeManage) this.employeeAddress.get(rowNumber);
                employeeAddress.remove(rowNumber);
                chekDelete =
                        employeeManager.deleteEmployeeAddress(addressDel.getId());
                if (chekDelete == 1) {
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    this.adressTableSize--;
                    this.selectedAddressRow = -1;
                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 6) {
                popupIdentifier = 0;
                int chekDelete = 0;
                int rowNumber = this.selectedFamilyRow;
                EmployeeManage familyDel = (EmployeeManage) this.familyInformation.get(rowNumber);
                chekDelete =
                        employeeManager.deleteEmployeeFamily(familyDel.getFamilyId());
                if (chekDelete == 1) {
                    familyInformation.remove(rowNumber);
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    this.familyTableSize--;
                    this.selectedFamilyRow = -1;
                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 7) {
                popupIdentifier = 0;
                int chekDelete = 0;
                chekDelete =
                        employeeManager.deleteEmployee(txtFEmployeeId.getValue().toString());
                if (chekDelete == 1) {
                    showSuccessOrFailureMessage(true, "Record deleted successfully");
                    clearApperanceComponents();

                    clearComponents();

                    clearComponentsAddress();

                    clearComponentsFa();

                    clearEducationComponents();

                    clearExperianceComponents();

                    clearLanguageComponents();

                    disableComponents();

                    btnNew.setDisabled(true);
                    btnReset.setDisabled(true);
                    btnSave.setDisabled(true);
                    btnUpdate.setDisabled(true);
                    btnDelete.setDisabled(true);
                    btnEdit.setDisabled(true);
                    txtSearchByName1.setValue("");
                    txtFEmployeeId.setValue("");
                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again!");
                }

            } else if (popupIdentifier == 8) {
                popupIdentifier = 0;
                EmployeeTrainingManager trainingObj = (EmployeeTrainingManager) this.listOfEmployeeTraining.get(selectedTrainingRow);
                if (employeeTrainingManager.deleteEmployeeTraining(trainingObj.getTrainingId()) == 1) {
                    listOfEmployeeTraining.remove(selectedTrainingRow);
                    showSuccessOrFailureMessage(true, "Record deleted successfully!");
                    this.trainingTablesize--;
                    this.selectedTrainingRow = -1;

                } else {
                    showSuccessOrFailureMessage(false, "Error while deleting. Please Try again?");
                }

            }
//
        } catch (Exception e) {
            e.printStackTrace();
        }



        return null;
    }

    public String btnEXDelete_action() {
        popupIdentifier = 1;
        buttonIdentifier =
                5;
        disableExperianceComponents();

        if (this.listOfExperience.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty");
        } else if (this.selectedExperience == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else {
            if (this.selectedExperience < tableSize) {
                this.lblemployeePopUpMsgMain.setValue("Are you shure You want to delete this record?");
                employeePlanPopUpMsg.setRendered(true);
            } else {
                this.counter--;
                this.listOfExperience.remove(selectedExperience);
                buttonIdentifier =
                        2;

            }

        }
        if (tableSize > 0) {
            btnEXNew.setDisabled(false);
            btnEXSave.setDisabled(true);
            btnEXEdit.setDisabled(false);
            btnEXUpdate.setDisabled(true);
            btnEXReset.setDisabled(false);
            btnEXDelete.setDisabled(false);
            btnAddExperience.setDisabled(true);

        } else {
            btnEXNew.setDisabled(false);
            btnEXSave.setDisabled(true);
            btnEXEdit.setDisabled(true);
            btnEXUpdate.setDisabled(true);
            btnEXReset.setDisabled(true);
            btnEXDelete.setDisabled(true);
            btnAddExperience.setDisabled(true);
        }

        return null;
    }

    public String btntemployeePopUpNo_action() {
        employeePlanPopUpMsg.setRendered(false);

        return null;
    }

    public String cmdEducationAdd_action() {
        this.addEmployeeEducation();
        return null;
    }

    public String btnLADelete_action() {

        disableLanguageComponents();
        if (listOfLanguage.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");
        } else if (selecteLanguageRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        } else {
            if (this.selecteLanguageRow < langTableSize) {
                employeePlanPopUpMsg.setRendered(true);
                lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
                popupIdentifier = 2;
            } else {
                this.lanCounter--;
                this.listOfLanguage.remove(selecteLanguageRow);
                buttonIdentifierLang = 2;

            }

        }
        return null;
    }

    public String btnEDEdit_action() {
        newOrEdit = "Edit";
        current_action = "EditEducation";
        this.buttonIdentifierEduc = 3;
        if (this.selecteEducationRow == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selecteEducationRow != -1 && this.listOfEducation.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {

            if (dataIsOnEditEducation.equals("YES")) {
                showSuccessOrFailureMessage(false, "First finish the data you are editing");
            } else {
                dataIsOnEditEducation = "YES";
                EducationManager employeeEducation = (EducationManager) listOfEducation.get(selecteEducationRow);
                listOfEducation.remove(selecteEducationRow);
                drlLevelOfEducation.setValue(employeeEducation.getLevelOfEducation());
                txtInstitution.setValue(employeeEducation.getInstuation());
                drlTypesOfEducation.setValue(employeeEducation.getTypesOfEducation());
                drlGradingScale.setValue(employeeEducation.getGradingSystem());
                txtaward.setValue(employeeEducation.getAward());
                txtResult.setValue(employeeEducation.getResult());
                btnEDUpdate.setDisabled(false);
                txtDispStartEducDate.setValue(employeeEducation.getStartDate());
                txtDispEndEducDate.setValue(employeeEducation.getCopletionDate());
                txtaward.setValue(employeeEducation.getAward());
                txtResult.setValue(employeeEducation.getResult());
                educationID =
                        employeeEducation.getId();
                btnEDNew.setDisabled(true);
                btnEDSave.setDisabled(true);
                btnEDEdit.setDisabled(true);
                btnEDUpdate.setDisabled(true);
                btnEDReset.setDisabled(false);
                btnEDDelete.setDisabled(true);
                this.cmdEducationAdd.setDisabled(false);
                this.enableEducationComponents();
                if (selecteEducationRow >= educTableSize) {
                    buttonIdentifierEduc = 2;
                    educCounter--;

                }


            }
        }

        return null;
    }

    public String btnEDDelete_action() {
        disableEducationComponents();
        if (listOfEducation.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");
        } else if (selecteEducationRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        } else {
            lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
            popupIdentifier =
                    3;
            employeePlanPopUpMsg.setRendered(true);
        }

        return null;
    }

    public String btnApDelete_action() {
        employeePlanPopUpMsg.setRendered(true);
        lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
        popupIdentifier =
                4;

        return null;
    }

    public String btnADDelete_action() {
        popupIdentifier = 5;
        if (employeeAddress.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");
        } else if (selectedAddressRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        } else {
            if (selectedAddressRow < adressTableSize) {
                employeePlanPopUpMsg.setRendered(true);
                lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
            } else {
                this.countAdress--;
                this.employeeAddress.remove(selectedAddressRow);
                addressButtonIdentifier =
                        2;
                clearApperanceComponents();

                disableAddressComponents();

            }





        }
        if (adressTableSize > 0) {
            btnADNew.setDisabled(false);
            btnADSave.setDisabled(true);
            btnADEdit.setDisabled(false);
            btnADUpdate.setDisabled(true);
            btnADReset.setDisabled(false);
            btnADDelete.setDisabled(false);
            btnAddAddress.setDisabled(true);

        } else {
            btnADNew.setDisabled(false);
            btnADSave.setDisabled(true);
            btnADEdit.setDisabled(true);
            btnADUpdate.setDisabled(true);
            btnADReset.setDisabled(false);
            btnADDelete.setDisabled(true);
            btnAddAddress.setDisabled(true);
        }

        return null;
    }

    public String btnFaDelete_action() {
        if (selectedFamilyRow != -1 && familyInformation.isEmpty() == false) {
            employeePlanPopUpMsg.setRendered(true);
            lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
            popupIdentifier =
                    6;
        } else if (familyInformation.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");

        } else if (selectedFamilyRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        }

        return null;
    }

    public String btnempTitleNew_action() {
        this.inputTextPopUpempTitle.setValue("");
        this.inputTextPopUpempTitleType.resetValue();
        //empTitleOPt.clear();
        this.inputTextPopUpempTitle.setDisabled(false);
        this.inputTextPopUpempTitleType.setDisabled(false);
        this.btnempTitleDelete.setDisabled(true);
        this.btnempTitleAdd.setDisabled(false);
        this.btnempTitleSave.setDisabled(false);
        inputTextPopUpempTitle.setDisabled(false);
        inputTextPopUpempTitleType.setDisabled(false);
        btnempTitleAdd.setDisabled(false);
        btnempTitleSave.setDisabled(false);
        btnempTitleNew.setDisabled(true);


        return null;
    }

    public String btnempTitleSave_action() {
        int checkSave = 0;
        EmployeeManage newEmpManager = new EmployeeManage();
        List newTitle = this.getEmpTitleOPt().subList((titleTableSize), (titleTableSize + countTitle));  //titleTableSize
        Iterator<EmployeeManage> ittNewNo = newTitle.iterator();
        while (ittNewNo.hasNext()) {
            EmployeeManage empTitle = ittNewNo.next();
            checkSave =
                    newEmpManager.addNewTitle(empTitle.getTitleDes(), empTitle.getTitleType());
        }

        if (checkSave == 1) {
            empTitlePopUpMsg.setRendered(false);
            this.get_title();
            populateEmpTitleTable();

        }






        return null;
    }

    public String btnempTitleDelete_action() {
        this.panelGroupempTitleMsgBody11.setRendered(false);
        this.panelGroupempTitleMsgBodyDelete.setRendered(true);
        this.panelGroupempTitleMsgBody1.setRendered(false);
        this.panelGroupempTitleMsgBodyButtons.setRendered(false);

        return null;
    }

    public String buttonempTitleY_action() {
        EmployeeManage newEmpManager = new EmployeeManage();
        panelGroupempTitleMsgBody11.setRendered(true);
        panelGroupempTitleMsgBodyDelete.setRendered(false);
        panelGroupempTitleMsgBody1.setRendered(true);
        panelGroupempTitleMsgBodyButtons.setRendered(true);
        int rowNumber = selectedNoAttenRow;
        EmployeeManage empTitleId = (EmployeeManage) empTitleOPt.get(rowNumber);
        empTitleOPt.remove(rowNumber);
        newEmpManager.deleteEmpTitle(empTitleId.getTitleID());

        return null;
    }

    public String buttonempTitleN_action() {
        panelGroupempTitleMsgBody11.setRendered(true);
        panelGroupempTitleMsgBodyDelete.setRendered(false);
        panelGroupempTitleMsgBody1.setRendered(true);
        panelGroupempTitleMsgBodyButtons.setRendered(true);
        empTitleOPt.clear();
        this.populateEmpTitleTable();


        return null;
    }

    public String btnempTitleCancel_action() {
        this.panelGroupempTitleMsgBody11.setRendered(false);
        this.panelGroupempTitleMsgBodyDelete.setRendered(true);
        this.panelGroupempTitleMsgBody1.setRendered(false);
        this.panelGroupempTitleMsgBodyButtons.setRendered(false);
        this.btnempTitleDelete.setDisabled(true);
        this.btnempTitleAdd.setDisabled(false);
        this.btnempTitleSave.setDisabled(false);
        inputTextPopUpempTitle.setDisabled(false);
        inputTextPopUpempTitleType.setDisabled(false);
        btnempTitleAdd.setDisabled(false);
        btnempTitleSave.setDisabled(false);
        btnempTitleNew.setDisabled(false);
        empTitleOPt.clear();
        this.populateEmpTitleTable();

        return null;
    }
    int titleTableSize = 0;
    int countTitle = 0;

    public String btnempTitleAdd_action() {
        String newTiltle = null;
        String newCategory = null;
        if (this.inputTextPopUpempTitle.getValue() != null || !this.inputTextPopUpempTitle.getValue().toString().equals("")) {
            newTiltle = this.inputTextPopUpempTitle.getValue().toString();
            inputTextPopUpempTitle.setValue("");
        }

        if (this.inputTextPopUpempTitleType.getValue() != null || !this.inputTextPopUpempTitleType.getValue().toString().equals("0")) {
            newCategory = this.inputTextPopUpempTitleType.getValue().toString();
            inputTextPopUpempTitleType.setValue("0");
        }

        EmployeeManage addNewNo = new EmployeeManage(newTiltle, newCategory);
        empTitleOPt.add(addNewNo);
        countTitle++;

        return null;
    }

    public String btnempEducationAdd_action() {
        try {
            if (inputTextPopUpempEducation.getValue() != null) {
                // EducationManager addNewNo = new EducationManager(inputTextPopUpempEducation.getValue().toString());
                String category = "-1";
                if (drlEducationCatagories.getValue() != null) {
                    if (drlEducationCatagories.getValue().toString().equals("-1")) {
                        category = "Uncatagorized";
                    } else {
                        category = drlEducationCatagories.getValue().toString();
                    }
                }

                EducationManager addNewNo = new EducationManager("", inputTextPopUpempEducation.getValue().toString(), category);
                listOfEducationType.add(addNewNo);
                inputTextPopUpempEducation.resetValue();
                countEducationType++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void populateEmpTitleTable() {
//        this.column1.setRendered(true);
        EmployeeManage newEmpManager = new EmployeeManage();
        titleTableSize = newEmpManager.countEmpTitle();
        try {
            if (titleTableSize > 0) {
                HashMap[] empTitleList = newEmpManager.readEmpTitle();
                for (int i = 0; i <
                        titleTableSize; i++) {
                    EmployeeManage addToTable = new EmployeeManage(empTitleList[i].get("TITLE_ID").toString(), empTitleList[i].get("TITLE_DESCRIPTION").toString(), empTitleList[i].get("TYPE").toString());
                    empTitleOPt.add(addToTable);
                }
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public void populateEmpEducationTable() {
        listOfEducationType.clear();
        educationTypeTableSize = educationManager.countTypeOfEducation();
        try {
            if (educationTypeTableSize > 0) {
                HashMap[] educationTypeList = educationManager.readEducationType(); //one java
                for (int i = 0; i <
                        educationTypeTableSize; i++) {
                    EducationManager addToTable = new EducationManager(educationTypeList[i].get("EDUC_TYPE_CODE").toString(), educationTypeList[i].get("DESCRIPTION").toString());
                    listOfEducationType.add(addToTable);
                }
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

    }

    public String buttonempTitleClose_action() {

        empTitlePopUpMsg.setRendered(false);
        return null;
    }

    public void rowSelectorempTitleAdd_processMyEvent(RowSelectorEvent rse) {
        selectedNoAttenRow = rse.getRow();
    }

    public String btnempEducationSave_action() {
        int checkSave = 0;
        EducationManager newEmpManager = new EducationManager();//listOfEducationType
        List newTitle = this.getListOfEducationType().subList((educationTypeTableSize), (educationTypeTableSize + countEducationType));
        Iterator<EducationManager> ittNewNo = newTitle.iterator();
        while (ittNewNo.hasNext()) {
            EducationManager empTitle = ittNewNo.next();
            // checkSave = newEmpManager.addNewEducationType(empTitle.getDescription());
            checkSave = newEmpManager.addNewEducationType(empTitle.getDescription(), empTitle.getCategory());

        }

        if (checkSave == 1) {
            popupAddEducationType.setRendered(false);
            listOfEducationType.clear();
            countEducationType =
                    0;
        }

        return null;
    }

    public void rowSelectorempEducationAdd_processMyEvent(RowSelectorEvent rse) {
        selectEducationType = rse.getRow();
    }

    public String buttonempEducationY_action() {
        EducationManager newEmpManager = new EducationManager();
        panelGroupempEducationMsgBodyDelete.setRendered(false);
        panelGroupempEducationMsgBodyButtons.setRendered(true);
        panelGroupempEducationMsgBody.setRendered(true);
        panelGroupempEducationMsgBody11.setRendered(true);
        int rowNumber = selectEducationType;
        educationTypeTableSize--;

        EducationManager empTitleId = (EducationManager) listOfEducationType.get(rowNumber);
        listOfEducationType.remove(rowNumber);

        newEmpManager.deleteEducationType(empTitleId.getEducationTypeCode());

        return null;
    }

    public String btnempEducationDelete_action() {
        panelGroupempEducationMsgBodyDelete.setRendered(true);
        panelGroupempEducationMsgBodyButtons.setRendered(false);
        panelGroupempEducationMsgBody.setRendered(false);
        panelGroupempEducationMsgBody11.setRendered(false);

        return null;
    }

    public String buttonempEducationClose_action() {

        popupAddEducationType.setRendered(false);
        listOfEducationType.clear();

        return null;
    }

    public String btnempEducationCancel_action() {

        populateEmpEducationTable();
        btnempEducationAdd.setDisabled(true);
        btnempEducationSave.setDisabled(true);
        btnempEducationCancel.setDisabled(true);
        inputTextPopUpempEducation.setDisabled(true);
        btnempEducationNew.setDisabled(false);
        return null;
    }

    public String commandLink2_action() {
        this.populateEmpTitleTable();
        empTitlePopUpMsg.setRendered(true);
        inputTextPopUpempTitle.setDisabled(true);
        inputTextPopUpempTitleType.setDisabled(true);
        btnempTitleAdd.setDisabled(true);
        btnempTitleSave.setDisabled(true);


        return null;
    }

    public String cmdLinkAddEducType_action() {

        populateEmpEducationTable();
        popupAddEducationType.setRendered(true);
        inputTextPopUpempEducation.setDisabled(true);
        btnempEducationAdd.setDisabled(true);
        btnempEducationSave.setDisabled(true);
        btnempEducationCancel.setDisabled(true);
        btnempEducationNew.setDisabled(false);

        return null;
    }

    public String btnempEducationNew_action() {
        btnempEducationAdd.setDisabled(false);
        btnempEducationSave.setDisabled(false);
        btnempEducationCancel.setDisabled(false);
        inputTextPopUpempEducation.setDisabled(false);
        btnempEducationNew.setDisabled(true);

        return null;
    }

    public String cmdAddNewLanguage_action() {
        txtNameNewLanguageType.setValue(null);
        pnlInsertNewLanguageType.setRendered(true);
        return null;
    }

    public void commandLink1_processAction(ActionEvent ae) {

        String departmentName;
        String department = tree1.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            DEPARRTMENT_ID =
                    Integer.parseInt(_department[1].trim());
            txtfDepartment.setValue(departmentName);
            if (DEPARRTMENT_ID != 0) {
                this.setPerofation(departmentManage.readJobCode(String.valueOf(DEPARRTMENT_ID)));
            } else {
                this.setPerofation(departmentManage.onDisplayJob());
            }

            panelLayout3.setRendered(false);
        }

    }

    public String btnSaveContratTermination_action() {
        ContractEmployeeManager contractEmployeeManager = new ContractEmployeeManager();
        contractEmployeeManager.setContractTermiDate(txtContractTerminationDate.getValue().toString());
        contractEmployeeManager.setContractTermiRemark(txtTerminationRemark.getValue().toString());
        contractEmployeeManager.setEmployeeId(txtFEmployeeId.getValue().toString());
        contractEmployeeManager.setContratId(employeeContractId);
        if (contratManager.saveContractTermination(contractEmployeeManager)) {
            popContractTermination.setRendered(false);
            showSuccessOrFailureMessage(true, "Employee Contrate Termination Information  Saved Successfuly.");
        } else {
            popContractTermination.setRendered(false);
            showSuccessOrFailureMessage(false, "Employee  Contrate Termination Information not Saved  Successfuly.Please try Again ?");
        }
//        txtfDepartment.setValue(tree1.getCurrentNode().toString());
//        panelLayout3.setRendered(false);
        return null;
    }

    public String btnEXReset_action() {
        clearExperianceComponents();
        disableExperianceComponents();

        btnEXNew.setDisabled(false);
        btnEXSave.setDisabled(true);
        btnEXEdit.setDisabled(false);
        btnEXUpdate.setDisabled(true);
        btnEXReset.setDisabled(false);
        btnEXDelete.setDisabled(false);
        btnAddExperience.setDisabled(true);
        counter =
                0;
        this.loadEmployeeExperiance();
        return null;
    }

    public String btnLAReset_action() {
        this.clearLanguageComponents();
        this.enableLanguageComponents();
        if (langTableSize > 0) {
            btnLAEdit.setDisabled(false);
            btnLADelete.setDisabled(false);
        } else {
            btnLAEdit.setDisabled(true);
            btnLADelete.setDisabled(true);
        }

        btnLANew.setDisabled(false);
        btnLASave.setDisabled(true);
        btnLAUpdate.setDisabled(true);
        btnLAReset.setDisabled(false);
        btnLAAdd.setDisabled(true);
        listOfLanguage.clear();
        this.loadEmployeeLanguage();
        disableLanguageComponents();

        return null;
    }

    public String btnEDReset_action() {
        current_action = "NewEducation";
        this.clearEducationComponents();
        this.disableEducationComponents();
        loadEmployeeEducation();

        btnEDDelete.setDisabled(true);
        btnEDEdit.setDisabled(true);
        btnEDNew.setDisabled(false);
        return null;
    }

    public String btnNew_action() {
        btnReset_action();
        this.enableComponents();
        excelDataPhoto =
                false;
        newNameInput =
                "";
        adressTableSize =
                0;
        langTableSize =
                0;
        educTableSize =
                0;
        tableSize =
                0;
        familyTableSize =
                0;
        counter =
                0;
        lanCounter =
                0;
        educCounter =
                0;
        countAdress =
                0;
        countfamily =
                0;
        this.getEmployeeAddress().clear();
        this.getEmployeeAdressUpdate().clear();
        this.getListOfExpUpdate().clear();
        this.getFamilyInfoUpdate().clear();
        this.getFamilyInformation().clear();
        this.getListOfExperience().clear();
        this.getListOfEducation().clear();
        this.getListOfEducationUpdate().clear();
        this.listOfLanguage.clear();
        this.listOfLanguageUpdate.clear();
        this.getListOfExperience().clear();
        this.getListOfExpUpdate().clear();
        this.clearComponents();
        this.clearComponentsFa();
        //  this.clearApperanceComponents();
        this.clearComponentsAddress();
        this.clearEducationComponents();
        this.clearLanguageComponents();
        this.clearExperianceComponents();
        btnSave.setDisabled(false);
        btnEDNew.setDisabled(false);
        // txtFEmployeeId.setValue(employeeManager.readNewId());
        txtFEmployeeId.setDisabled(false);
        txtFEmployeeId.setValue("");
        txtFEmployeeId.setValue(null);
        txtSearchByName1.setSelectedItem(null);
        txtSearchByName1.setValue(null);
        txtSearchByName1.resetValue();
        btnNew.setDisabled(true);
        btnDelete.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(false);
        // cboCivile.setSelected(true);
        drlPayGrade.resetValue();
        drlPayGrade.setDisabled(true);
        return null;
    }

    public void btnupdate_processAction(ActionEvent ae) {
        if (optA.isSelected() || optB.isSelected() || optAB.isSelected() || optO.isSelected()) {
            lblBloodGroup1.setRendered(false);
            this.saveEmployeeApperance(2);
        } else {
            lblBloodGroup1.setRendered(true);
            lblBloodGroup1.setValue("Required");
        }

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

    public void cboPermanent_processValueChange(ValueChangeEvent vce) {
        if (cboPermanent.isSelected()) {
            cboContract.setSelected(false);
            txtRetirementNo.setRequired(true);
        }

    }

    public void cboContract_processValueChange(ValueChangeEvent vce) {
        if (cboContract.isSelected()) {
            cboPermanent.setSelected(false);
        }

    }

    public void cboShift_processValueChange(ValueChangeEvent vce) {
        if (cboShift.isSelected()) {
            cboOffice.setSelected(false);
            defaultSelectedDataOffice.setSelectedBoolean(false);
        }

    }

    public void cboOffice_processValueChange(ValueChangeEvent vce) {
        if (cboOffice.isSelected()) {
            cboShift.setSelected(false);
            defaultSelectedDataShift.setSelectedBoolean(false);
        }

    }

    public void drlGradingScale_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals("0")) {
            txtResult.setValue("0.00");
        }

    }

    public String btnCalendarBirthDate_action() {
        txtDateOfBirth.setRendered(true);
        return null;
    }

    public void calHireDate_processValueChange(ValueChangeEvent vce) {
        txtRecruitmentDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calHireDate.setRendered(false);
    }

    public String btnCalRecruitmentDate_action() {
        calHireDate.setRendered(true);
        return null;
    }

    public void calBirthDate_processValueChange(ValueChangeEvent vce) {
        txtBirthDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calBirthDate.setRendered(false);
    }
     public void calContractStartDate_processValueChange(ValueChangeEvent vce) {
        txtCotractStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calContractStartDate.setRendered(false);
    }
      public void calContractEndDate_processValueChange(ValueChangeEvent vce) {
        txtContractTerminationDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calContractEndDate.setRendered(false);
    }

    public String btnCalBirthDate_action() {
        calBirthDate.setRendered(true);
        txtBirthDate.setRendered(true);
        return null;
    }

    public String btnCalFamilyBirthDate_action() {
        calFamilyDateOfBirth.setRendered(true);
        return null;
    }

    public String btnViewTree_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        LoadTree loadTree = new LoadTree();
        this.tree1Model.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        panelLayout3.setRendered(true);
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btnReset_action() {
        clearComponents();
        txtSearchByName1.setValue("");
        txtFEmployeeId.setValue("");
        return null;
    }

    public String btnCalEducStartDate_action() {
        calStartEduc.setRendered(true);
        return null;
    }

    public String btnCalEducEndDate_action() {
        calEndEduc.setRendered(true);
        return null;
    }

    public void calStartEduc_processValueChange(ValueChangeEvent vce) {
        txtDispStartEducDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartEduc.setRendered(false);
    }

    public void calEndEduc_processValueChange(ValueChangeEvent vce) {
        txtDispEndEducDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndEduc.setRendered(false);
    }

    public void drlEducationCatagories_processValueChange(ValueChangeEvent vce) {
        if (drlEducationCatagories.getValue().toString().equals("-1")) {
            popupempEducationCategory.setValue("No Catagory Selected.\nYou can close this window and select category first");
        } else {
            popupempEducationCategory.setValue("Category : " + vce.getNewValue().toString());
        }

        setEducTypeOpt(lookUpManager.readEducationByCategoryForJob(vce.getNewValue().toString()));

    }
    String experiencePrivateOrGovernmental = "";
    String experienceContractOrPrtmanent = "";
    String experienceRelatedToMugherJob = "";
    String experienceRelatedToMugherJobDescription = "";

    public void ckbExperiencePermanent_processValueChange(ValueChangeEvent vce) {
        if (ckbExperiencePermanent.isSelected()) {
            ckbExperienceContract.setSelected(false);
            experienceContractOrPrtmanent =
                    "Permanent";
        } else {
            experienceContractOrPrtmanent = "";
        }

    }

    public void ckbExperienceContract_processValueChange(ValueChangeEvent vce) {
        if (ckbExperienceContract.isSelected()) {
            ckbExperiencePermanent.setSelected(false);
            experienceContractOrPrtmanent =
                    "Contract";
        } else {
            experienceContractOrPrtmanent = "";
        }

    }

    public void ckbExperiencePrivate_processValueChange(ValueChangeEvent vce) {
        if (ckbExperiencePrivate.isSelected()) {
            ckbExperienceGovernmental.setSelected(false);
            experiencePrivateOrGovernmental =
                    "Private";
        } else {
            experiencePrivateOrGovernmental = "";
        }

    }

    public void ckbExperienceGovernmental_processValueChange(ValueChangeEvent vce) {
        if (ckbExperienceGovernmental.isSelected()) {
            ckbExperiencePrivate.setSelected(false);
            experiencePrivateOrGovernmental =
                    "Gov'tal";
        } else {
            experiencePrivateOrGovernmental = "";
        }

    }

    public void ckbFamilyAliveOrDied_processValueChange(ValueChangeEvent vce) {
        if (ckbFamilyAliveOrDied.isSelected()) {
            isAlive = "YES";
        } else {
            isAlive = "NO";
        }

    }

    public String btnFaReset_action() {
        btnFamilyNew.setDisabled(false);
        clearComponentsFa();

        getFamilyInformation().clear();
        btnFaNew_action();

        this.loadEmployeeFamily();
        return null;
    }

    public String btnADReset_action() {
        btnADNew.setDisabled(false);
        clearComponentsAddress();

        loadEmployeeAddress();

        return null;
    }

    public String btnCalExpStartDate_action() {
        calExpStartDate.setRendered(true);
        return null;
    }

    public String btnCalExpEndDate_action() {
        calExpEndDate.setRendered(true);
        return null;
    }

    public void calExpStartDate_processValueChange(ValueChangeEvent vce) {
        txtDisplayedExpStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calExpStartDate.setRendered(false);
    }

    public void calExpEndDate_processValueChange(ValueChangeEvent vce) {
        txtDisplayedExpEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calExpEndDate.setRendered(false);
    }

    public void calFamilyDateOfBirth_processValueChange(ValueChangeEvent vce) {
        try {
            txtFamilyBirthDate.setValue(dateFormat.format(vce.getNewValue()));
            calFamilyDateOfBirth.setRendered(false);
        } catch (Exception e) {
        }

    }

    public void drlPassedCandidatesList_processValueChange(ValueChangeEvent vce) {

        try {
            if (vce.getNewValue() != null) {
                if (vce.getSource().toString() != null) {
                    if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0")) {
                        drlCandidateName.setDisabled(false);
                        candidateName = ruitmentManager.candidateName(vce.getNewValue().toString());
                    //this.setCandidateName(ruitmentManager.candidateName(vce.getNewValue().toString()));
                    } else {
//                  clearComponents();
//                  disableComponents();
                        drlCandidateName.setDisabled(true);
                        chkCrimeFree.setDisabled(true);
                        chkMedicalFit.setDisabled(true);
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String btnTrainingSave_action() {
        int chkSave = 0;
        List employeeTraining = this.getListOfEmployeeTraining().subList((this.trainingTablesize),
                (trainingTablesize + this.trainingCounter));
        Iterator<EmployeeTrainingManager> iter = employeeTraining.iterator();
        while (iter.hasNext()) {
            EmployeeTrainingManager employeTraining = iter.next();
            chkSave = employeeTrainingManager.saveEmployeeTraining(employeTraining);
        }
        if (chkSave == 1) {
            showSuccessOrFailureMessage(true, "Member Training Information  Saved Successfuly.");
            this.trainingCounter = 0;
            loadEmployeeTraining();
            btnTrainingNew.setDisabled(false);
            btnTrainingSave.setDisabled(true);
            btnTrainingEdit.setDisabled(false);
            btnTrainingUpdate.setDisabled(true);
            btnTrainingDelete.setDisabled(false);
            btnTrainingReset.setDisabled(false);
            btnAddTraining.setDisabled(true);
            disableTrainingComponents();

        } else {
            showSuccessOrFailureMessage(false, "Member Training Information not Saved. Please Try again.");
        }


        //return null means stay on the same page
        return null;
    }

    public String btnAddTraining_action() {
        if (this.isTrainingDataEntryValid()) {
            try {

                String duration = " not register";
                if (txtDuration.getValue() != null && !txtDuration.getValue().toString().equals("")) {
                    duration = txtDuration.getValue().toString();
                }
                EmployeeTrainingManager addTraining = new EmployeeTrainingManager(
                        txtTrainingName.getValue().toString(),
                        drlInstitutionName.getValue().toString(),
                        txtTraStartDate.getValue().toString().trim(),
                        txtTraEndDate.getValue().toString().trim(),
                        txtFEmployeeId.getValue().toString().trim(),
                        trainingId,
                        drlSponsoredBy.getValue().toString(),
                        drlInstitutionName.getValue().toString(),
                        duration);
                if (trainingButtonIdentifier == 1 || trainingButtonIdentifier == 2) {
                    this.trainingCounter++;
                    this.listOfEmployeeTraining.add(addTraining);
                    btnEDDelete.setDisabled(false);
                    btnEDSave.setDisabled(false);
                    this.btnEDEdit.setDisabled(false);
                } else if (trainingButtonIdentifier == 3) {
                    btnTrainingUpdate.setDisabled(false);
                    this.listOfEmployeeTraining.add(this.selectedTrainingRow, addTraining);
                    this.updateListOfEmployeeTraining.add(addTraining);
                    btnTrainingEdit.setDisabled(false);
                    btnTrainingDelete.setDisabled(false);
                    this.disableTrainingComponents();
                }

                this.clearTrainingComponents();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //return null means stay on the same page
        return null;
    }

    private boolean isTrainingDataEntryValid() {
        boolean result = true;
//        this.validateComponent(txtTrainingName, this.txtTrainingName.getValue(), "1", HRValidation.TEXT_PATTERN);
        this.validateComponent(txtTraStartDate, this.txtTraStartDate.getValue(), "2", HRValidation.DATE_PATTERN);
        this.validateComponent(txtTraEndDate, this.txtTraEndDate.getValue(), "2", HRValidation.DATE_PATTERN);
        // this.validateComponent(drlTrainingInstitution, this.txtTrainingInstitution.getValue(), "2", HRValidation.TEXT_PATTERN);
        return result;
    }

    /**
     * The method validates UI component using the <code>validateData</code> method of the
     * class <code>HRValidation</code>
     * @param component the UI component
     * @param componentValue the value of the UI component
     * @param validationType either for required or data validity or both
     * @param pattern the patther againest wich the data will be validated
     * @return either true or false
     */
    private boolean validateComponent(UIComponent component, Object componentValue, String validationType, int pattern) {
        boolean result = true;
        boolean required;
        boolean chechk = false;
        String errorMessage = "Required";
        int errorValue = 0;
        if (validationType.equals("1")) {//checks data validity and required
            errorValue = HRValidation.validateData(componentValue, HRValidation.DATE_PATTERN, true);
            if (errorValue != 0) {
                result = false;
                if (errorValue == 1) {
                    ((UIInput) component).setValid(false);
                    error(component, errorMessage);
                } else {
                    ((UIInput) component).setValid(false);
                    error(component, "Invalid Value");
                }
            }
        } else if (validationType.equals("2")) {//checks only data validity but not required
            errorValue = HRValidation.validateData(componentValue, HRValidation.TEXT_PATTERN, false);
            if (errorValue != 0) {
                result = false;
                ((UIInput) component).setValid(false);
                error(component, "Invalid Value");
            }
        } else {//checks only required not data validity
            chechk = HRValidation.validateRequired(componentValue);
            if (!chechk) {
                result = false;
                ((UIInput) component).setValid(false);
                error(component, errorMessage);

            }
        }
        return result;
    }

    void clearTrainingComponents() {
        txtTrainingName.setValue("");
        txtTraStartDate.setValue("");
        txtTraEndDate.setValue("");
        drlInstitutionName.setValue(null);
        drlSponsoredBy.setValue(null);
        txtDuration.setValue("");
    }

    void disableTrainingComponents() {
        txtTraStartDate.setDisabled(true);
        drlInstitutionName.setDisabled(true);
        drlSponsoredBy.setDisabled(true);
        txtTrainingName.setDisabled(true);
        txtTraEndDate.setDisabled(true);
        txtDuration.setDisabled(true);
    }

    void enableTrainingComponents() {
        txtTraStartDate.setDisabled(false);
        drlInstitutionName.setDisabled(false);
        drlSponsoredBy.setDisabled(false);
        txtTrainingName.setDisabled(false);
        txtTraEndDate.setDisabled(false);
        txtDuration.setDisabled(false);
    }

    public void rowSelectorEmployeeTraining_processMyEvent(RowSelectorEvent rse) {
        selectedTrainingRow = rse.getRow();

    }

    public String btnTrainingEdit_action() {
        this.trainingButtonIdentifier = 3;
        if (this.selectedTrainingRow == -1) {

            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");

        } else if (this.selectedTrainingRow != -1 && this.listOfEmployeeTraining.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            EmployeeTrainingManager trainingManager = (EmployeeTrainingManager) listOfEmployeeTraining.get(selectedTrainingRow);
            listOfEmployeeTraining.remove(selectedTrainingRow);
            trainingId = trainingManager.getTrainingId();
            txtTrainingName.setValue(trainingManager.getTrainingName());
            txtTraStartDate.setValue(trainingManager.getStartDate());
            drlInstitutionName.setValue(trainingManager.getInstitutionId());

            drlSponsoredBy.setValue(trainingManager.getSponsoredBy());
            txtTraEndDate.setValue(trainingManager.getEndDate());
            txtDuration.setValue(trainingManager.getDuration());
            btnEDNew.setDisabled(true);
            btnEDSave.setDisabled(true);
            btnEDEdit.setDisabled(true);
            btnEDUpdate.setDisabled(true);
            btnEDReset.setDisabled(false);
            btnEDDelete.setDisabled(true);
            btnAddTraining.setDisabled(false);
            this.enableTrainingComponents();
            if (selectedTrainingRow >= trainingTablesize) {
                //   buttonIdentifierEduc = 2;
                trainingCounter--;
            }

        }

        //return null means stay on the same page
        return null;
    }

    public String btnTrainingNew_action() {
        this.trainingButtonIdentifier = 1;
        try {
            if (HRValidation.validateRequired(txtFEmployeeId.getValue())) {
                this.clearTrainingComponents();
                this.enableTrainingComponents();
                btnTrainingNew.setDisabled(true);
                btnTrainingSave.setDisabled(false);
                btnTrainingUpdate.setDisabled(true);
                btnTrainingReset.setDisabled(false);
                btnAddTraining.setDisabled(false);
                if (listOfEmployeeTraining.size() > 0) {
                    btnTrainingEdit.setDisabled(false);
                    btnTrainingDelete.setDisabled(false);
                } else {
                    btnTrainingEdit.setDisabled(true);
                    btnTrainingDelete.setDisabled(true);
                }

            } else {
                popUpConfirmation.setRendered(true);
                lblPopUpMsgContaint.setValue("First select employee You want  to add his/her Training Information ?");
                btnYes.setRendered(false);
                btnNo.setRendered(false);
            }

        } catch (Exception ex) {
        }
        //return null means stay on the same page
        return null;
    }

    public String btnTrainingUpdate_action() {
        int chkSave = 0;
        List employeeTraining = this.getUpdateListOfEmployeeTraining();
        Iterator<EmployeeTrainingManager> iter = employeeTraining.iterator();

        while (iter.hasNext()) {
            EmployeeTrainingManager trainingManager = iter.next();
            chkSave = employeeTrainingManager.updateEmployeeTraining(trainingManager);
        }
        if (chkSave == 1) {
            //  lblFormMessage.setStyleClass("success");
            showSuccessOrFailureMessage(true, "Employee Training Information  Updated Successfuly.");
            // showConformationMsg(getMessage().getStyleClass().toString());
            this.updateListOfEmployeeTraining.clear();
            loadEmployeeTraining();

            btnEDNew.setDisabled(false);
            btnEDSave.setDisabled(true);
            btnEDEdit.setDisabled(false);
            btnEDUpdate.setDisabled(true);
            btnEDDelete.setDisabled(false);
            btnEDReset.setDisabled(false);
            cmdEducationAdd.setDisabled(true);
            disableTrainingComponents();

        } else {
            //lblFormMessage.setStyleClass("error");
            showSuccessOrFailureMessage(false, "Employee Training Information " +
                    " not Updated. Please Try again.");
        //showConformationMsg(getMessage().getStyleClass().toString());
        // this.listOfEducationUpdate.clear();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnTrainingDelete_action() {
        disableTrainingComponents();
        enableTrainingComponents();
        if (listOfEmployeeTraining.isEmpty()) {
            showSuccessOrFailureMessage(false, "The table is empty!!");
        } else if (selectedTrainingRow == -1) {
            showSuccessOrFailureMessage(false, "First select data from the table!!");
        } else {
            if (this.selectedTrainingRow <= trainingTablesize) {
                employeePlanPopUpMsg.setRendered(true);
                lblemployeePopUpMsgMain.setValue("Are you sure you want to delete  this record ?");
                popupIdentifier = 8;
            } else {
                this.trainingCounter--;
                this.listOfEmployeeTraining.remove(selectedTrainingRow);
                trainingButtonIdentifier = 2;

            }

        }

        //return null means stay on the same page
        return null;
    }

    public String btnTrainingReset_action() {
        this.clearTrainingComponents();
        if (trainingTablesize > 0) {
            btnTrainingEdit.setDisabled(false);
            btnTrainingDelete.setDisabled(false);
        } else {
            btnTrainingEdit.setDisabled(true);
            btnTrainingDelete.setDisabled(true);
        }

        btnTrainingNew.setDisabled(false);
        btnTrainingSave.setDisabled(true);
        btnTrainingUpdate.setDisabled(true);
        btnTrainingReset.setDisabled(false);
        btnAddTraining.setDisabled(true);
        listOfEmployeeTraining.clear();
        this.loadEmployeeTraining();
        disableTrainingComponents();
        //return null means stay on the same page
        return null;
    }

    public void calStartDate_processValueChange(ValueChangeEvent vce) {
        txtTraStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calStartDate.setRendered(false);
    }

    public void calEndDate_processValueChange(ValueChangeEvent vce) {
        txtTraEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calEndDate.setRendered(false);
    }

    public String btnTrainingStartDate_action() {
        calStartDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnTrainingEndDate_action() {
        calEndDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        if (HRValidation.validateRequired(vce.getNewValue())) {
            //clearApperanceComponents();
            clearComponents();
            clearComponentsAddress();
            clearComponentsFa();
            clearEducationComponents();
            clearExperianceComponents();
            clearTrainingComponents();
            clearLanguageComponents();
            candidateID=vce.getNewValue().toString();
            displayCandidateName(candidateID);

        }
    }

    public String btnSaveContract_action() {


        String start_Date = null;
        String end_Date = null;
        String emp_Id = null;
        if (this.txtCotractStartDate.getValue() != null) {
            start_Date = this.txtCotractStartDate.getValue().toString();
        }
        if (this.txtfContractEndDate.getValue() != null) {
            end_Date = this.txtfContractEndDate.getValue().toString();
        }
        if (contratEmployeeId != null) {
            emp_Id = contratEmployeeId;
        }
        //checkContartSave = contratManager.saveContract(emp_Id, start_Date, end_Date, "1");

        if (contratManager.saveContract(emp_Id, start_Date, end_Date, "1")) {
            txtCotractStartDate.setDisabled(true);
            txtfContractEndDate.setDisabled(true);
            bntCotractStartDate.setDisabled(true);
            bntCotractEndDate.setDisabled(true);
            btnSaveContract.setDisabled(true);
            pnlPopUpDateSettingForContractEmployee.setRendered(false);

            showSuccessOrFailureMessage(true, "The Member Profile and Contract Date Saved Successfully .");
        } else {

            showSuccessOrFailureMessage(false, "The Member Profile Saved Successfully but Contract Date Not Saved.");
        }

        //return null means stay on the same page
        return null;
    }

    public String btnEditContract_action() {

        txtCotractStartDate.setDisabled(false);
        txtfContractEndDate.setDisabled(false);
        bntCotractStartDate.setDisabled(false);
        bntCotractEndDate.setDisabled(false);
        btnSaveContract.setDisabled(true);
        btnUpdateContract.setDisabled(false);
        btnEditContract.setDisabled(false);

        //return null means stay on the same page
        return null;
    }

    public String btnUpdateContract_action() {

        String start_Date = null;
        String end_Date = null;
        String emp_Id = null;
        if (this.txtCotractStartDate.getValue() != null) {
            start_Date = this.txtCotractStartDate.getValue().toString();
        }
        if (this.txtfContractEndDate.getValue() != null) {
            end_Date = this.txtfContractEndDate.getValue().toString();
        }
        if (this.txtFEmployeeId.getValue() != null) {
            emp_Id = this.txtFEmployeeId.getValue().toString();
        }

        if (contratManager.saveContract(emp_Id, start_Date, end_Date, "2")) {
            txtCotractStartDate.setDisabled(true);
            txtfContractEndDate.setDisabled(true);
            bntCotractStartDate.setDisabled(true);
            bntCotractEndDate.setDisabled(true);
            btnSaveContract.setDisabled(true);
            pnlPopUpDateSettingForContractEmployee.setRendered(false);
        }
        //return null means stay on the same page
        return null;
    }

    public String btnCancel_action() {
        txtCotractStartDate.setDisabled(true);
        txtfContractEndDate.setDisabled(true);
        bntCotractStartDate.setDisabled(true);
        bntCotractEndDate.setDisabled(true);
        btnSaveContract.setDisabled(true);
        pnlPopUpDateSettingForContractEmployee.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseBtnDateSettingControll_action() {
        pnlPopUpDateSettingForContractEmployee.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void calContratTerminationDate_processValueChange(ValueChangeEvent vce) {
        txtContractTerminationDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calContratTerminationDate.setRendered(false);
    }

    public String btnContrateTerminationCalend_action() {
        calContratTerminationDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String commandLink3_action() {
        popContractTermination.setRendered(true);
        pnlPopUpDateSettingForContractEmployee.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSatusDisplayYse_action()
    {
        pnMessageForEmployeeStatus.setRendered(false);
        this.setEmployeeProfile();
        this.loadEmployeeFamily();
        this.loadEmployeeAddress();
        this.loadEmployeeEducation();
        this.loadEmployeeLanguage();
        this.loadEmployeeExperiance();
        this.loadEmployeeTraining();
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseMesssageEmployeeStatus_action() {
        popContractTermination.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnSatusDisplayNo_action() {
        pnMessageForEmployeeStatus.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnAddFileTbl_action() {
        try {
            if (isFileDataEntryValid()) {
                if (getEmployeeFile() != null) {
                    EmployeeFileManager addemployeeFile = new EmployeeFileManager(
                            ddnFileType.getValue().toString(),
                            fileId,
                            txtFileName.getValue().toString(),
                            txtFileRemark.getValue().toString(),
                            getEmployeeFile(),
                            txtFEmployeeId.getValue().toString(),
                            fileExtenstion);
                    if (fileButtonIdentifier == 1 || fileButtonIdentifier == 2) {
                        fileCounter++;
                        employeeFileList.add(addemployeeFile);
                        btnFileSave.setDisabled(false);
                        this.btnFileEdit.setDisabled(false);
                        this.btnFileReset.setDisabled(false);
                    } else if (fileButtonIdentifier == 3) {
                        employeeFileList.add(selectedFileRow, addemployeeFile);
                        this.employeeUpdateFileList.add(addemployeeFile);
                        this.btnFileEdit.setDisabled(false);
                        this.btnFileUpdate.setDisabled(false);
                    }
                } else {
                    showSuccessOrFailureMessage(false, "Server can't upload selected file. Please try again later");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public void fileUploadAttached_processAction(ActionEvent ae) {
        try {
            int index = 0;
            InputFile inpuFile = (InputFile) ae.getSource();
            FileInfo fileInfo = inpuFile.getFileInfo();
            filePath = fileInfo.getPhysicalPath().toString();
            File file = new File(filePath);
            fileExtenstion = file.getName();
            index = fileExtenstion.lastIndexOf(".");
            fileExtenstion = fileExtenstion.substring(index + 1);

            setEmployeeFile(EmployeeManage.extractByteArray(file));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private boolean isFileDataEntryValid() {
        boolean result = true;
        int errorValue = 0;
        //this.validateComponent(ddnFileType, this.ddnFileType.getValue(), "3", 0);
//        this.validateComponent(txtFileName, this.txtFileName.getValue(), "1", HRValidation.NAME_PATTERN);
        //    this.validateComponent(txtFileRemark, this.txtFileRemark.getValue(), "2", HRValidation.TEXT_PATTERN);
        errorValue = HRValidation.validateData(this.ddnFileType.getValue(), HRValidation.NO_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            ((UIInput) ddnFileType).setValid(false);
            error(ddnFileType, "Invalid Value");
        }
        errorValue = HRValidation.validateData(this.txtFileRemark.getValue(), HRValidation.TEXT_PATTERN, false);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtFileRemark).setValid(false);
            error(txtFileRemark, "Invalid Value");
        }
        errorValue = HRValidation.validateData(this.txtFileName.getValue(), HRValidation.NAME_PATTERN, true);
        if (errorValue != 0) {
            result = false;
            ((UIInput) txtFileName).setValid(false);
            error(txtFileName, "Invalid Value");
        }

        return result;
    }

    public String btnFileNew_action() {
        fileButtonIdentifier = 1;

        if (txtFEmployeeId.getValue() != null) {
            this.clearFileComponents();
            this.enableFileComponents();
            if (filetableSize > 0) {
                btnFileNew.setDisabled(true);
                btnFileSave.setDisabled(false);
                btnFileEdit.setDisabled(false);
                btnFileUpdate.setDisabled(true);
                btnFileDelete.setDisabled(false);
                btnFileReset.setDisabled(false);
                btnAddFileTbl.setDisabled(false);

            } else {
                btnFileNew.setDisabled(true);
                btnFileSave.setDisabled(false);
                btnFileEdit.setDisabled(true);
                btnFileUpdate.setDisabled(true);
                btnFileDelete.setDisabled(false);
                btnFileReset.setDisabled(true);
                btnAddFileTbl.setDisabled(false);


            }

        } else {

            showSuccessOrFailureMessage(false, "First select employee You want" +
                    "  to upload files");

        }
        //return null means stay on the same page
        return null;
    }

    void disableFileComponents() {
        fileUploadAttached.setDisabled(true);
        ddnFileType.setDisabled(true);
        txtFileName.setDisabled(true);
        txtFileRemark.setDisabled(true);

    }

    void enableFileComponents() {
        fileUploadAttached.setDisabled(false);
        ddnFileType.setDisabled(false);
        txtFileName.setDisabled(false);
        txtFileRemark.setDisabled(false);

    }

    void clearFileComponents() {
        txtFileName.setValue("");
        txtFileRemark.setValue("");
        setDownloadAvailable(false);
    }

    public String btnFileSave_action() {
        try {
            boolean chekRefSave = false;
            List employeeFile = this.getEmployeeFileList().subList((filetableSize),
                    (filetableSize + fileCounter));
            Iterator<EmployeeFileManager> iter = employeeFile.iterator();
            while (iter.hasNext()) {
                EmployeeFileManager saveEmployeeFile = iter.next();
                chekRefSave = employeeFileManager.saveEmployeeFile(saveEmployeeFile);
            }

            if (chekRefSave) {
                //lblFormMessage.setStyleClass("success");
                showSuccessOrFailureMessage(true, "Employe file information  Save Successfuly.");
                //showConformationMsg(getMessage().getStyleClass().toString());
                this.clearFileComponents();
                fileCounter = 0;
                loadEmployeeFile();
                disableFileComponents();
                btnFileNew.setDisabled(false);
                btnFileSave.setDisabled(true);
                btnFileEdit.setDisabled(false);
                btnFileUpdate.setDisabled(true);
                btnFileDelete.setDisabled(true);
                btnFileReset.setDisabled(false);
                btnAddFileTbl.setDisabled(true);
            } else {

                showSuccessOrFailureMessage(false, "Employe file information not Saved Try again.");

                this.btnFileNew.setDisabled(false);
                this.btnFileNew.setDisabled(true);
                this.btnFileDelete.setDisabled(false);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    public String btnFileEdit_action() {
        fileButtonIdentifier = 10;
        if (this.selectedFileRow == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else if (this.selectedFileRow != -1 && this.employeeFileList.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else {
            EmployeeFileManager employeeFileSelecter = (EmployeeFileManager) this.employeeFileList.get(selectedFileRow);
            this.employeeFileList.remove(this.selectedFileRow);
            fileId = employeeFileSelecter.getFileId();
            txtFileName.setValue(employeeFileSelecter.getFileName());
            ddnFileType.setValue(employeeFileSelecter.getFileType());
            txtFileRemark.setValue(employeeFileSelecter.getRemark());
            setEmployeeFile(employeeFileSelecter.getFile());
            btnFileNew.setDisabled(true);
            btnFileSave.setDisabled(true);
            btnFileEdit.setDisabled(true);
            btnFileUpdate.setDisabled(true);
            btnFileDelete.setDisabled(false);
            btnFileReset.setDisabled(true);
            btnAddFileTbl.setDisabled(false);
            this.enableFileComponents();
            buttonIdentifier = 3;
            if (this.selectedFileRow >= filetableSize) {
                buttonIdentifier = 2;
                this.fileCounter--;
            }

        }
        //return null means stay on the same page
        return null;
    }

    public String btnFileUpdate_action() {
        boolean chkSave = false;
        List employeeFileInfo = this.getEmployeeUpdateFileList();
        Iterator<EmployeeFileManager> iter = employeeFileInfo.iterator();
        while (iter.hasNext()) {
            EmployeeFileManager updateEmployeeFile = iter.next();
            chkSave =
                    employeeFileManager.updateEmployeeFile(updateEmployeeFile);
        }

        if (chkSave) {
            // lblFormMessage.setStyleClass("success");
            showSuccessOrFailureMessage(true, "Employee File information  Updated Successfuly.");
            //showConformationMsg(getMessage().getStyleClass().toString());
            this.getEmployeeUpdateFileList().clear();
            this.btnFileNew.setDisabled(false);
            this.btnFileUpdate.setDisabled(true);
            this.btnFileReset.setDisabled(false);
            loadEmployeeFile();

        } else {
            // lblFormMessage.setStyleClass("error");
            showSuccessOrFailureMessage(false, "Employee File information not Updated Try again.");
        //showConformationMsg(getMessage().getStyleClass().toString());
        }
        //return null means stay on the same page
        return null;
    }

    public String btnFileReset_action() {
        clearFileComponents();
        disableFileComponents();

        btnFileNew.setDisabled(false);
        btnFileSave.setDisabled(true);
        btnFileEdit.setDisabled(false);
        btnFileUpdate.setDisabled(true);
        btnFileReset.setDisabled(false);
        btnFileDelete.setDisabled(false);
        btnAddFileTbl.setDisabled(true);
        fileCounter = 0;
        this.loadEmployeeFile();
        //return null means stay on the same page
        return null;
    }

    public String btnFileDelete_action() {
        popupIdentifier = 10;
        fileButtonIdentifier = 0;
        disableFileComponents();

        if (this.employeeFileList.isEmpty() == true) {
            showSuccessOrFailureMessage(false, "The Table is Empty");
        } else if (this.selectedFileRow == -1) {
            showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
        } else {
            if (this.selectedFileRow < filetableSize) {
                this.lblemployeePopUpMsgMain.setValue("Are you shure You want to delete this record?");
                employeePlanPopUpMsg.setRendered(true);
            } else {
                this.fileCounter--;
                this.employeeFileList.remove(selectedFileRow);
                buttonIdentifier = 2;

            }

        }
        if (filetableSize > 0) {
            btnFileNew.setDisabled(false);
            btnFileSave.setDisabled(true);
            btnFileEdit.setDisabled(false);
            btnFileUpdate.setDisabled(true);
            btnFileReset.setDisabled(false);
            btnFileDelete.setDisabled(false);
        //btnAddAddressTbl.setDisabled(true);

        } else {
            btnFileNew.setDisabled(false);
            btnFileSave.setDisabled(true);
            btnFileEdit.setDisabled(true);
            btnFileUpdate.setDisabled(true);
            btnFileReset.setDisabled(true);
            btnFileDelete.setDisabled(true);
        //btnAddAddressTbl.setDisabled(true);
        }
        //return null means stay on the same page
        return null;
    }

    public void rowSelectorFile_processMyEvent(RowSelectorEvent rse) {
        selectedFileRow = rse.getRow();

    }
    private int selectedRow = -1;
    public String fileName = "";
    private String mimeType;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getMimeType() {
        return mimeType;
    }

    public void setMimeType(String mimeType) {
        this.mimeType = mimeType;
    }

    public String lnkFile_action() {
        selectedRow = dataTablFile.getRowIndex();
        try {

            if (selectedRow > -1) {
                EmployeeFileManager manager = (EmployeeFileManager) employeeFileList.get(selectedRow);
                setDownloadAvailable(false);
                readPdfFiles(manager.getFileId(), manager.getFileName(), manager.getFileExtension());
                setDownloadAvailable(true);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public void panelCollapsible3_processAction(ActionEvent ae) {
        panelCollapsible1.setExpanded(false);
        panelCollapsible3.setExpanded(true);
    }

    public void panelCollapsible1_processAction(ActionEvent ae) {
        panelCollapsible1.setExpanded(true);
        panelCollapsible3.setExpanded(false);
    }

    public void drlTitle_processValueChange(ValueChangeEvent vce) {
    }

    public void drlEmpTitle_processValueChange(ValueChangeEvent vce) {
        try {
            if (vce.getNewValue() != null) {
                String tile[] = vce.getNewValue().toString().split("--");
                if (tile[1].equals("Male")) {
                    ckbSexFemale.setDisabled(true);
                    ckbSexMale.setDisabled(true);
                    ckbSexMale.setSelected(true);
                    ckbSexFemale.setSelected(false);
                } else if (tile[1].equals("Female")) {
                    ckbSexFemale.setDisabled(true);
                    ckbSexMale.setDisabled(true);
                    ckbSexMale.setSelected(false);
                    ckbSexFemale.setSelected(true);
                } else {
                    ckbSexFemale.setDisabled(false);
                    ckbSexMale.setDisabled(false);
                    ckbSexMale.setSelected(false);
                    ckbSexFemale.setSelected(false);
                }

            } else {
                ckbSexFemale.setDisabled(false);
                ckbSexMale.setDisabled(false);
                ckbSexMale.setSelected(false);
                ckbSexFemale.setSelected(false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void txtSearchByName1_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null && !CommonValidation.isUpdatePhase(vce)) {
            AutoAllCompleteDictionary.init(vce.getNewValue().toString().toUpperCase(), true);
            this.matchesList = AutoAllCompleteDictionary.dictionary;
            if (vce.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) vce.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentEmployee1 = (EmployeeList) autoComplete1.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee1.getEmpIdentification());
                } //
            }
        }
    }
    //////////////////////////////////file handling

    public InputStream open() throws IOException {
        if (inputStream == null) {
            if (fromDb) {
                if (fileFromDb != null) {
                    try {
                        byte[] byteArray = fileFromDb;
                        inputStream = new ByteArrayInputStream(byteArray);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            } else {
            }
        }
        return inputStream;
    }

    public void readPdfFiles(String documentId, String _fileName, String extension) {
        try {
            byte[] attachedFile = employeeManager.singleSelect(documentId);
            ResourceManager.fileFromDb = attachedFile;
            StringBuilder builder = new StringBuilder();
            builder.append(_fileName);
            builder.append(".");
            builder.append(extension);
            setFileName(builder.toString());
            setMimeType("application/" + extension);
            faResource = new ByteArrayResource(attachedFile);


        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public String fileUploadAttached_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnSave1_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnEdit1_action() {
        //return null means stay on the same page
        return null;
    }

    public String bntCotractStartDate_action() {
        calContractStartDate.setRendered(true);
        //return null means stay on the same page

        return null;
    }

    public String bntCotractEndDate_action() {
       calContractEndDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String cmd_instiutation_action() {
        //return null means stay on the same page
        pnlInsertNewInstiutationType.setRendered(true);
        return null;
    }

    public String cmd_locationNew_action() {
        //return null means stay on the same page
        pnlInsertNewLocationType.setRendered(true);
        return null;
    }
//    public ResourceManager(ExternalContext ec, String resourceName) {
//        this.extContext = ec;
//        this.resourceName = resourceName;
//        this.lastModified = new Date();
//    }
}


