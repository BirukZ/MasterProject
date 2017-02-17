/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import com.sun.webui.jsf.model.Option;
import control.HolidaysManager;
import entity.employeeEntity.AddressEntity;
import entity.employeeEntity.ApperanceEntity;
import entity.employeeEntity.EmployeeEntity;
import entity.employeeEntity.FamilyEntity;
import entity.experianceEntity.ExperianceEntity;
import fphrms.EmployeeList;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.faces.model.SelectItem;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.LookUpManager;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author Administrator
 */
public class EmployeeManage implements Serializable {

    public static final String EMPLOYEE_TYPE_OFFICE = "Office";
    public static final String EMPLOYEE_TYPE_shift = "Shift";
    public static final String EMPLOYEE_LEAVETIME_ADDRESS = "1";
    public static final String EMPLOYEE_CURRENT_ADDRESS = "2";
    public static final String EMPLOYEE_BIRTHPLASE_ADDRESS = "3";
    ExperianceEntity employeeExperianceEntity = new ExperianceEntity();
    ApperanceEntity apperanceEntity = new ApperanceEntity();
    private Option[] maritalstatus;
    private Option[] readNation;
    private Option[] readDepartment;
    private Option[] readTitle;
    private Option[] job;
    private Option[] loadEmpIds;
    String titleID;
    String dateof_Birth;
    String emergency_Contact;
    String _sex;
    String relation_Type;
    String aliveOrDied;
    String phone_no;
    String family_FirstName;
    String familyMidelName;
    String familyLastName;
    String emploeeId;
    int databaseStatus;
    String employeeId;
    FamilyEntity family = new FamilyEntity();
    LookUpManager lookup = new LookUpManager();
    String institution;
    String experiencePrivateOrGovernmental;
    String experienceContractOrPrtmanent;
    private String empIdentification;
    private String fullName;
    private String deptId;
    private boolean selected;
    private boolean selectedAddress;
    private boolean selectedExperance;
    private String titleDes;
    private String titleType;
    private String startDate;
    private String terminationReason;
    String rank;
    String copletionDate;
    String id;
    int avilabelOnDb;
    String regionDescrption;
    String zoneDescription;
    String woredaDescription;
    AddressEntity addressEntity = new AddressEntity();
    String address1;
    String woredaSubCity;
    String kebelle;
    String telNumberHome;
    String telNumberOffice;
    String zoneCity;
    String telNumberMobile;
    String region;
    String kebelleDescription;
    String sefere;
    static int new_inserted = 0;
    static int new_removed = 1;
    static int old_not_cahanged = 2;
    static int old_edited = 3;
    static int old_deleted = 4;
    String woreda;
    String kabele;
    String zone;
    String houseNumber;
    String pobox;
    String moblile;
    String telOffice;
    String telHome;
    String email;
    String imagePath;
    byte[] empImage;
    String OldEmployeeID;
    static int odl_edited = 3;
    static int odl_deleted = 4;
    String title;
    String firstName;
    String midelName;
    String lastName;
    String sex;
    String dateOfBirth;
    String maritalStatus;
    String nationality;
    String religion;
    String nation;
    String hireDate;
    String retirementNo;
    String department;
    String jobCode;
    String jobName;
    String rankId;
    String drlPayGrade;
    String salary;
    private String experienceRelationinInMugherJobCode;
    private String experienceRelationinInMugherJobDescription;
    private String experienceValidForLeave;
    private String tinNumber;
    private String location;
    String empId;
    String familyId;
    public static final String EMPLOYEELEAVETYPEADDRESS = "10";
    public static final String EMPLOYEECURRENTTYPEADDRESS = "1";





    public String getPhone_no() {
        return phone_no;
    }

    public void setPhone_no(String phone_no) {
        this.phone_no = phone_no;
    }

    public String getSefere() {
        return sefere;
    }

    public void setSefere(String sefere) {
        this.sefere = sefere;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public String getExperienceRelationinInMugherJobCode() {
        return experienceRelationinInMugherJobCode;
    }

    public void setExperienceRelationinInMugherJobCode(String experienceRelationinInMugherJobCode) {
        this.experienceRelationinInMugherJobCode = experienceRelationinInMugherJobCode;
    }

    public String getExperienceRelationinInMugherJobDescription() {
        return experienceRelationinInMugherJobDescription;
    }

    public void setExperienceRelationinInMugherJobDescription(String experienceRelationinInMugherJobDescription) {
        this.experienceRelationinInMugherJobDescription = experienceRelationinInMugherJobDescription;
    }

    public String getExperienceValidForLeave() {
        return experienceValidForLeave;
    }

    public void setExperienceValidForLeave(String experienceValidForLeave) {
        this.experienceValidForLeave = experienceValidForLeave;
    }

    public String getTitleDes() {
        return titleDes;
    }

    public void setTitleDes(String titleDes) {
        this.titleDes = titleDes;
    }

    public String getTitleID() {
        return titleID;
    }

    public void setTitleID(String titleID) {
        this.titleID = titleID;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }

    public EmployeeManage(String titleID, String titleDesc, String titleType) {
        this.titleID = titleID;
        this.titleDes = titleDesc;
        this.titleType = titleType;

    }

    public int countEmpTitle() {
        return employeeEntity.countEmpTitle();
    }

    public EmployeeManage(String titleDesc, String titleType) {
//        this.titleID = titleID;
        this.titleDes = titleDesc;
        this.titleType = titleType;

    }

    public boolean isSelectedExperance() {
        return selectedExperance;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public void setSelectedExperance(boolean selectedExperance) {
        this.selectedExperance = selectedExperance;
    }

    public boolean isSelectedAddress() {
        return selectedAddress;
    }

    public void setSelectedAddress(boolean selectedAddress) {
        this.selectedAddress = selectedAddress;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmpIdentification() {
        return empIdentification;
    }

    public void setEmpIdentification(String empIdentification) {
        this.empIdentification = empIdentification;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getStartDate() {
        return startDate;
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

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public EmployeeManage(String institution, String terminationReason,
            String rank, String startDate, String copletionDate, String salary,
            String emploeeId, String job_Code, String id) {
        this.institution = institution;
        this.terminationReason = terminationReason;
        this.rank = rank;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.salary = salary;
        this.emploeeId = emploeeId;
        this.job_Code = job_Code;
        this.id = id;
    }

    public EmployeeManage(String institution, String terminationReason, String rank,
            String startDate, String copletionDate, String salary, String emploeeId,
            String job_Code, String id,
            String experiencePrivateOrGovernmental,
            String experienceContractOrPrtmanent,
            String experienceRelationinInMugherJobCode,
            String experienceRelationinInMugherJobDescription,
            String experienceValidForLeave) {
        this.institution = institution;
        this.terminationReason = terminationReason;
        this.rank = rank;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.salary = salary;
        this.emploeeId = emploeeId;
        this.job_Code = job_Code;
        this.id = id;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.experienceRelationinInMugherJobCode = experienceRelationinInMugherJobCode;
        this.experienceRelationinInMugherJobDescription = experienceRelationinInMugherJobDescription;
        this.experienceValidForLeave = experienceValidForLeave;
    }

    public EmployeeManage(String employeeID, String height, String weight,
            String eyeColor, String bloodGroup) {
        this.empId = employeeID;
        this.height = height;
        this.weight = weight;
        this.eye_Color = eyeColor;
        this.blood_Group = bloodGroup;

    }

    public int saveEmployeeApperance(EmployeeManage employeeManage, int perform) {
        ApperanceEntity addApperance = new ApperanceEntity(employeeManage.getEmpId(),
                employeeManage.getHeight(), employeeManage.getChest(),
                employeeManage.getBlood_Group(), employeeManage.getEye_Color(), "",
                employeeManage.getWeight(), employeeManage.finger_print);
        int myReturn = 0;
        if (perform == 1) {
            myReturn = apperanceEntity.saveEmployeeApperance(addApperance);

        } else if (perform == 2) {

            myReturn = apperanceEntity.updateEmployeeApperance(addApperance);
        }
        return myReturn;
    }
       public void ClearCandidateInfo(String candidateID) {
       employeeEntity.ClearCandidate(candidateID);
    }

    public int getAvilabelOnDb() {
        return avilabelOnDb;
    }

    public void setAvilabelOnDb(int avilabelOnDb) {
        this.avilabelOnDb = avilabelOnDb;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRegionDescrption() {
        return regionDescrption;
    }

    public void setRegionDescrption(String regionDescrption) {
        this.regionDescrption = regionDescrption;
    }

    public String getWoredaDescription() {
        return woredaDescription;
    }

    public void setWoredaDescription(String woredaDescription) {
        this.woredaDescription = woredaDescription;
    }

    public String getZoneDescription() {
        return zoneDescription;
    }

    public void setZoneDescription(String zoneDescription) {
        this.zoneDescription = zoneDescription;
    }
////////////here

    public EmployeeManage(String empId, String region,
            String zoneCity,
            String woredaSubCity,
            String kebelle,
            String houseNumber,
            String telNumberHome, String telNumberOffice,
            String telNumberMobile, String email,
            String pobox, String addressType, String id, int avilabelOnDb,
            String regionDescrption, String zoneDescription,
            String woredaDescription, String kebelleDescription,String sefere, int databaseStatus) {
        this(empId, region, zoneCity, woredaSubCity,
                kebelle, houseNumber,
                telNumberHome, telNumberOffice,
                telNumberMobile, email,
                pobox, addressType, id,
                avilabelOnDb, regionDescrption,
                zoneDescription, woredaDescription, kebelleDescription);
                this.sefere=sefere;
    }

    public EmployeeManage(String empId, String region, String zoneCity, String woredaSubCity,
            String kebelle, String houseNumber,
            String telNumberHome, String telNumberOffice,
            String telNumberMobile, String email,
            String pobox, String addressType, String id,
            int avilabelOnDb, String regionDescrption, String zoneDescription,
            String woredaDescription, String kebelleDescription) {
        this.empId = empId;
        this.region = region;
        this.zoneCity = zoneCity;
        this.woredaSubCity = woredaSubCity;
        this.kebelle = kebelle;
        this.houseNumber = houseNumber;
        this.telNumberHome = telNumberHome;
        this.telNumberOffice = telNumberOffice;
        this.telNumberMobile = telNumberMobile;
        this.email = email;
        this.pobox = pobox;
        this.addressType = addressType;
        this.id = id;
        this.databaseStatus = avilabelOnDb;
        this.avilabelOnDb = avilabelOnDb;
        this.regionDescrption = regionDescrption;
        this.zoneDescription = zoneDescription;
        this.woredaDescription = woredaDescription;
        this.kebelleDescription = kebelleDescription;
    }

    public ArrayList<EmployeeList> employeeNametoAutoList(String employeeName) {

        try {
            byte[] bytePicture = null;
            ResultSet rs = employeeEntity.searchEmployeeNametoAuto(employeeName);
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            if (rs != null) {
                while (rs.next()) {
                    OracleSerialBlob employeePicture = (OracleSerialBlob) rs.getBlob("PHOTO");
                    bytePicture = employeePicture.getBytes(0, (int) employeePicture.length());
                    EmployeeList empMgt = new EmployeeList(rs.getString("fullName"),
                            rs.getString("EMP_ID"), bytePicture);
                    proformaoption.add(empMgt);

                }
            }
            return proformaoption;
        } catch (Exception ex) {
            ex.printStackTrace();
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<EmployeeList> employeeNameWithOutPhoto(String employeeName) {

        try {
            ResultSet rs = employeeEntity.searchEmployeeNameWithOutPhoto(employeeName);
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            while (rs.next()) {
                EmployeeList empMgt = new EmployeeList(rs.getString("fullName"), rs.getString("EMP_ID"));
                proformaoption.add(empMgt);

            }
            return proformaoption;
        } catch (Exception ex) {
            ex.printStackTrace();
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public int saveEmployeeAddress(EmployeeManage employeeManage, int prform) {
        int check;
        AddressEntity address = new AddressEntity(
                employeeManage.getKebelle(), employeeManage.getTelNumberHome(),
                employeeManage.telNumberOffice,
                employeeManage.getTelNumberMobile(),
                employeeManage.getZoneCity(), employeeManage.getWoredaSubCity(),
                employeeManage.getEmpId(), employeeManage.getRegion(),
                employeeManage.getHouseNumber(),
                employeeManage.getPobox(),
                employeeManage.getEmail(),
                employeeManage.getAddressType(),
                 employeeManage.getSefere(),
                employeeManage.getId());
        if (prform == 1) {
            return addressEntity.saveEmployeeAddress(address);
        } else {
            check = addressEntity.updateEmployeeAddress(address);
        }
        return check;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getKebelle() {
        return kebelle;
    }

    public void setKebelle(String kebelle) {
        this.kebelle = kebelle;
    }

    public String getTelNumberHome() {
        return telNumberHome;
    }

    public void setTelNumberHome(String telNumberHome) {
        this.telNumberHome = telNumberHome;
    }

    public String getTelNumberOffice() {
        return telNumberOffice;
    }

    public void setTelNumberOffice(String telNumberOffice) {
        this.telNumberOffice = telNumberOffice;
    }

    public String getWoredaSubCity() {
        return woredaSubCity;
    }

    public void setWoredaSubCity(String woredaSubCity) {
        this.woredaSubCity = woredaSubCity;
    }

    public String getZoneCity() {
        return zoneCity;
    }

    public void setZoneCity(String zoneCity) {
        this.zoneCity = zoneCity;
    }

    public String getTelNumberMobile() {
        return telNumberMobile;
    }

    public void setTelNumberMobile(String telNumberMobile) {
        this.telNumberMobile = telNumberMobile;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getKabele() {
        return kabele;
    }

    public void setKabele(String kabele) {
        this.kabele = kabele;
    }

    public String getMoblile() {
        return moblile;
    }

    public void setMoblile(String moblile) {
        this.moblile = moblile;
    }

    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getTelHome() {
        return telHome;
    }

    public void setTelHome(String telHome) {
        this.telHome = telHome;
    }

    public String getTelOffice() {
        return telOffice;
    }

    public void setTelOffice(String telOffice) {
        this.telOffice = telOffice;
    }

    public String getWoreda() {
        return woreda;
    }

    public void setWoreda(String woreda) {
        this.woreda = woreda;
    }

    public String getZone() {
        return zone;
    }

    public void setZone(String zone) {
        this.zone = zone;
    }
    String addressType;

    public EmployeeManage() {
    }

    public int employeeNumber() {
        return employeeEntity.countEmployee();
    }

    public EmployeeManage(String addressType, String region, String woreda,
            String kabele, String zone, String houseNumber, String pobox,
            String moblile, String telOffice, String telHome, String email) {
        this.addressType = addressType;
        this.region = region;
        this.woreda = woreda;
        this.kabele = kabele;
        this.zone = zone;
        this.houseNumber = houseNumber;
        this.pobox = pobox;
        this.moblile = moblile;
        this.telOffice = telOffice;
        this.telHome = telHome;
        this.email = email;
    }

    public String getKebelleDescription() {
        return kebelleDescription;
    }

    public void setKebelleDescription(String kebelleDescription) {
        this.kebelleDescription = kebelleDescription;
    }

    public String getFamilyId() {
        return familyId;
    }

    public static int getNew_inserted() {
        return new_inserted;
    }

    public static void setNew_inserted(int new_inserted) {
        EmployeeManage.new_inserted = new_inserted;
    }

    public static int getNew_removed() {
        return new_removed;
    }

    public static void setNew_removed(int new_removed) {
        EmployeeManage.new_removed = new_removed;
    }

    public static int getOdl_deleted() {
        return odl_deleted;
    }

    public static void setOdl_deleted(int odl_deleted) {
        EmployeeManage.odl_deleted = odl_deleted;
    }

    public static int getOdl_edited() {
        return odl_edited;
    }

    public static void setOdl_edited(int odl_edited) {
        EmployeeManage.odl_edited = odl_edited;
    }

    public static int getOld_deleted() {
        return old_deleted;
    }

    public static void setOld_deleted(int old_deleted) {
        EmployeeManage.old_deleted = old_deleted;
    }

    public static int getOld_edited() {
        return old_edited;
    }

    public static void setOld_edited(int old_edited) {
        EmployeeManage.old_edited = old_edited;
    }

    public static int getOld_not_cahanged() {
        return old_not_cahanged;
    }

    public static void setOld_not_cahanged(int old_not_cahanged) {
        EmployeeManage.old_not_cahanged = old_not_cahanged;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
    }

    public String getOldEmployeeID() {
        return OldEmployeeID;
    }

    public void setOldEmployeeID(String OldEmployeeID) {
        this.OldEmployeeID = OldEmployeeID;
    }

    public byte[] getEmpImage() {
        return empImage;
    }

    public void setEmpImage(byte[] empImage) {
        this.empImage = empImage;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public EmployeeManage(String empId, String title, String firstName,
            String midelName, String lastName, String sex, String dateOfBirth,
            String maritalStatus, String nationality, String nation,
            String hireDate, String retirementNo, String department,
            String jobCode, String rankId, String drlPayGrade, String salary,
            String civilType, byte[] imagePath, String directorate,
            String division,
            String mastebabriya,
            String team, String tinNumber) {

        this.empId = empId;
        this.title = title;
        this.firstName = firstName;
        this.midelName = midelName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.nation = nation;
        this.hireDate = hireDate;
        this.retirementNo = retirementNo;
        this.department = department;
        this.jobCode = jobCode;
        this.rankId = rankId;
        this.drlPayGrade = drlPayGrade;
        this.salary = salary;
        this.permanentOrContract = civilType;
        this.empImage = imagePath;
//        this.mastebabriya = mastebabriya;
//        this.directorate = directorate;
//        this.division = division;
//        this.team = team;
        this.tinNumber = tinNumber;

    }

    public EmployeeManage(String empId, String title, String firstName, String midelName,
            String lastName, String sex, String dateOfBirth, String maritalStatus,
            String religion, String nationality, String nation, String hireDate,
            String retirementNo, String department, String jobCode, String rankId,
            String drlPayGrade, String salary,
            String permanentOrContract, String officeOrshift, byte[] imagePath,
            String tinNumber,
            String location) {
        this.empId = empId;
        this.title = title;
        this.firstName = firstName;
        this.midelName = midelName;
        this.lastName = lastName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.maritalStatus = maritalStatus;
        this.nationality = nationality;
        this.religion = religion;
        this.nation = nation;
        this.hireDate = hireDate;
        this.retirementNo = retirementNo;
        this.department = department;
        this.jobCode = jobCode;
        this.rankId = rankId;
        this.drlPayGrade = drlPayGrade;
        this.salary = salary;
        this.permanentOrContract = permanentOrContract;
        this.officeOrShift = officeOrshift;
        this.empImage = imagePath;
        this.tinNumber = tinNumber;
        this.location = location;
    }

////////////////////////////end employee information///////////////////////
    public ArrayList<String> selectFamily(String employeeId) {
        return null;
    }

    public boolean isBossOfEmployee(String bossId, String empId) {
        try {
            if (bossId.equals(empId)) {
                return true;
            } else if (employeeEntity.isBossOfEmployee(bossId, empId) == 0) {
                return false;
            } else {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean isEmployeeHold(String jobCode) {
        try {
            return employeeEntity.isEmployeeHold(jobCode);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public String updateEmployeeProfile(EmployeeManage empProfile) {

        EmployeeEntity saveEmployee = new EmployeeEntity(empProfile.getEmpId(),
                empProfile.getTitle(),
                empProfile.getFirstName(),
                empProfile.getMidelName(),
                empProfile.getLastName(),
                empProfile.getSex(),
                empProfile.getDateOfBirth(),
                empProfile.getMaritalStatus(),
                empProfile.getNationality(),
                empProfile.getNation(),
                empProfile.getHireDate(),
                empProfile.getRetirementNo(),
                empProfile.getDepartment(),
                empProfile.getJobCode(),
                empProfile.getRankId(),
                empProfile.getDrlPayGrade(),
                empProfile.getSalary(),
                empProfile.getPermanentOrContract(),
                empProfile.getEmpImage(),
                empProfile.getOldEmployeeID(),
                empProfile.getLocation());

        return employeeEntity.updatePersonalInformation(saveEmployee);
    }

    public String saveEmployeeInformation(EmployeeManage empProfile, int perform) {
        EmployeeEntity saveEmployee = new EmployeeEntity(empProfile.getEmpId(),
                empProfile.getTitle(),
                empProfile.getFirstName(),
                empProfile.getMidelName(),
                empProfile.getLastName(),
                empProfile.getSex(),
                empProfile.getDateOfBirth(),
                empProfile.getMaritalStatus(),
                empProfile.getReligion(),
                empProfile.getNationality(),
                empProfile.getNation(),
                empProfile.getHireDate(),
                empProfile.getRetirementNo(),
                empProfile.getDepartment(),
                empProfile.getJobCode(),
                empProfile.getRankId(),
                empProfile.getDrlPayGrade(),
                empProfile.getSalary(),
                empProfile.getPermanentOrContract(),
                empProfile.getOfficeOrshift(),
                empProfile.getEmpImage(),
                empProfile.getTinNumber(),
                empProfile.getLocation());

        try {
            if (perform == 1) {
                return employeeEntity.savePersonalInformation(saveEmployee);
            } else if (perform == 2) {
                return employeeEntity.updatePersonalInformation(saveEmployee);
            } else {
                return "0";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return "0";
        }


    }

    public int countSize(String employeeID) {
        return family.countNumberOfFamily(employeeID);
    }

    public int countEmployeeEducation() {
        return family.getSize();
    }

    public int countSizeAddress(String empId) {
        return addressEntity.getSize(empId);
    }

    public HashMap[] getEmployeeFamily(String employeeID) {
        ArrayList familyList = new ArrayList(readEmployeeFamily(employeeID));
        return (HashMap[]) familyList.toArray();
    }

    public ArrayList<HashMap> readEmployeeFamily(String employeeID) {
        ArrayList<HashMap> familyList = new ArrayList<HashMap>();
        try {
            // OracleCachedRowSet _rs = family.readFamily(employeeID);
            ResultSet _rs = family.readEmployeeFamily(employeeID);
            while (_rs.next()) {
                HashMap _list = new HashMap();
                _list.put("FIRST_NAME", _rs.getString("FIRST_NAME")== null ? "Unknown" : _rs.getString("FIRST_NAME"));
                _list.put("MIDDLE_NAME", _rs.getString("MIDDLE_NAME")== null ? "Unknown" : _rs.getString("MIDDLE_NAME"));
                _list.put("LAST_NAME", _rs.getString("LAST_NAME")== null ? "Unknown" : _rs.getString("LAST_NAME"));
                _list.put("DATE_OF_BIRTH", _rs.getString("DATE_OF_BIRTH") == null ? "Unknown" : _rs.getString("DATE_OF_BIRTH"));
                _list.put("RELATION", _rs.getString("RELATION_TYPE")== null ? "Unknown" : _rs.getString("RELATION_TYPE"));
                //  _list.put("PHOTO", _rs.getBlob("PHOTO"));
                _list.put("ID", Integer.toString(_rs.getInt("ID")));
                _list.put("SEX", _rs.getString("SEX")== null ? "Unknown" : _rs.getString("SEX"));
                _list.put("PHONENO", _rs.getString("PHONENO") == null ? "Unknown" : _rs.getString("PHONENO"));
                _list.put("HEIR", _rs.getString("HEIR")== null ? "Unknown" : _rs.getString("HEIR"));
                _list.put("JOB", _rs.getString("JOB")== null ? "Unknown" : _rs.getString("JOB"));
                _list.put("EMERGENCEY", _rs.getString("EMERGENCEY_CONTACT")== null ? "Unknown" : _rs.getString("EMERGENCEY_CONTACT"));
                _list.put("ALIVE_OR_DIED", _rs.getString("ALIVE_OR_DIED")== null ? "Unknown" : _rs.getString("ALIVE_OR_DIED"));
                _list.put("DATABASE_STATUS", old_not_cahanged);
                familyList.add(_list);
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return familyList;
    }
    //====================================================

    public ArrayList<HashMap> readEmployeeFamilyForLeave(String employeeID) {
        ArrayList<HashMap> familyList = new ArrayList<HashMap>();
        try {
            // OracleCachedRowSet _rs = family.readFamily(employeeID);
            ResultSet _rs = family.readFamilyForLeave(employeeID);
            while (_rs.next()) {
                HashMap _list = new HashMap();
                _list.put("FIRST_NAME", _rs.getString("FIRST_NAME"));
                _list.put("MIDDLE_NAME", _rs.getString("MIDDLE_NAME"));
                _list.put("LAST_NAME", _rs.getString("LAST_NAME"));
                _list.put("DATE_OF_BIRTH", _rs.getString("DATE_OF_BIRTH") == null ? "Unknown" : _rs.getString("DATE_OF_BIRTH"));
                _list.put("RELATION", _rs.getString("RELATION_TYPE"));
                _list.put("ID", Integer.toString(_rs.getInt("ID")));
                _list.put("SEX", _rs.getString("SEX"));

                _list.put("EMERGENCEY", _rs.getString("EMERGENCEY_CONTACT"));
                _list.put("ALIVE_OR_DIED", _rs.getString("ALIVE_OR_DIED"));
                _list.put("DATABASE_STATUS", old_not_cahanged);
                familyList.add(_list);
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return familyList;
    }

    public ArrayList<HashMap> readEmployeeRelativeForLeave(String employeeID) {
        ArrayList<HashMap> familyList = new ArrayList<HashMap>();
        try {
            // OracleCachedRowSet _rs = family.readFamily(employeeID);
            ResultSet _rs = family.readEmployeeRelativeForLeave(employeeID);
            while (_rs.next()) {
                HashMap _list = new HashMap();
                _list.put("FIRST_NAME", _rs.getString("FIRST_NAME"));
                _list.put("MIDDLE_NAME", _rs.getString("MIDDLE_NAME"));
                _list.put("LAST_NAME", _rs.getString("LAST_NAME"));
                _list.put("RELATION", _rs.getString("RELATION_TYPE"));
                _list.put("ALIVE_OR_DIED", _rs.getString("ALIVE_OR_DIED"));
                _list.put("ID", Integer.toString(_rs.getInt("ID")));
                familyList.add(_list);
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return familyList;
    }

    public HashMap readEmployeeAppreance(String employeeID) {
        return apperanceEntity.readEmployeeApperance(employeeID);
    }

    public HashMap[] readEmployeeAddrss(String employeeID) {
        return addressEntity.readAddress(employeeID);
    }

    public HashMap readEmployeeLeaveTimeAddrss(String employeeID) {
        return null;//addressEntity.readAddress(employeeID);
    }

    public EmployeeManage(String hire, String dateof_Birth, String emergency_Contact,
            String _sex, String relation_Type, String family_FirstName,
            String familyMidelName,
            String familyLastName, String id, int avilbleOnDbFamily) {
        this.hire = hire;
        this.dateof_Birth = dateof_Birth;
        this.emergency_Contact = emergency_Contact;
        this._sex = _sex;
        this.relation_Type = relation_Type;
        this.family_FirstName = family_FirstName;
        this.familyMidelName = familyMidelName;
        this.familyLastName = familyLastName;
        this.familyId = id;
        //this.empId= employeeID;
        this.avilbleOnDbFamily = avilbleOnDbFamily;

    }

    public EmployeeManage(String hire, String dateof_Birth, String emergency_Contact,
            String _sex,String phone, String relation_Type, String family_FirstName,
            String familyMidelName,
            String familyLastName, String aliveOrDied, String id, int avilbleOnDbFamily)
    {
        this(hire, dateof_Birth, emergency_Contact, _sex, relation_Type, family_FirstName, familyMidelName,
                familyLastName, id, avilbleOnDbFamily);
        this.phone_no=phone;
        this.aliveOrDied = aliveOrDied;


    }

    public EmployeeManage(String hire, String dateof_Birth, String emergency_Contact,
            String _sex, String relation_Type, String family_FirstName, String familyMidelName,
            String familyLastName, String id, int avilbleOnDbFamily, byte[] familyImage) {
        this(hire, dateof_Birth, emergency_Contact,
                _sex, relation_Type, family_FirstName, familyMidelName,
                familyLastName, id, avilbleOnDbFamily);
        this.familyPhoto = familyImage;
    }

    public EmployeeManage(String hire, String dateof_Birth, String emergency_Contact,
            String _sex, String relation_Type, String family_FirstName, String familyMidelName,
            String familyLastName, String id, String aliveOrDied, int avilbleOnDbFamily, byte[] familyImage) {
        this(hire, dateof_Birth, emergency_Contact, _sex, relation_Type, family_FirstName, familyMidelName,
                familyLastName, id, avilbleOnDbFamily, familyImage);
        this.aliveOrDied = aliveOrDied;
    }

    public EmployeeManage(String hire, String dateof_Birth, String emergency_Contact,
            String _sex, String relation_Type, String family_FirstName,
            String familyMidelName, String familyLastName,
            byte[] photoPath, int avilbleOnDbFamily) {
        this.hire = hire;
        this.dateof_Birth = dateof_Birth;
        this.emergency_Contact = emergency_Contact;
        this._sex = _sex;
        this.relation_Type = relation_Type;
        this.family_FirstName = family_FirstName;
        this.familyMidelName = familyMidelName;
        this.familyLastName = familyLastName;
        this.familyPhoto = photoPath;
        this.avilbleOnDbFamily = avilbleOnDbFamily;
    }
    String hire;

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }
    byte[] familyPhoto;

    public byte[] getFamilyPhoto() {
        return familyPhoto;
    }

    public void setFamilyPhoto(byte[] familyPhoto) {
        this.familyPhoto = familyPhoto;
    }
    int avilbleOnDbFamily;

    public int getAvilbleOnDbFamily() {
        return avilbleOnDbFamily;
    }

    public void setAvilbleOnDbFamily(int avilbleOnDbFamily) {
        this.avilbleOnDbFamily = avilbleOnDbFamily;
    }

    public String get_sex() {
        return _sex;
    }

    public void set_sex(String _sex) {
        this._sex = _sex;
    }

    public String getDateof_Birth() {
        return dateof_Birth;
    }

    public void setDateof_Birth(String dateof_Birth) {
        this.dateof_Birth = dateof_Birth;
    }

    public String getEmergency_Contact() {
        return emergency_Contact;
    }

    public void setEmergency_Contact(String emergency_Contact) {
        this.emergency_Contact = emergency_Contact;
    }

    public String getFamilyLastName() {
        return familyLastName;
    }

    public void setFamilyLastName(String familyLastName) {
        this.familyLastName = familyLastName;
    }

    public String getFamilyMidelName() {
        return familyMidelName;
    }

    public void setFamilyMidelName(String familyMidelName) {
        this.familyMidelName = familyMidelName;
    }

    public String getFamily_FirstName() {
        return family_FirstName;
    }

    public void setFamily_FirstName(String family_FirstName) {
        this.family_FirstName = family_FirstName;
    }

    public String getRelation_Type() {
        return relation_Type;
    }

    public void setRelation_Type(String relation_Type) {
        this.relation_Type = relation_Type;
    }

    public String getEmploeeId() {
        return emploeeId;
    }

    public int getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(int databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getAliveOrDied() {
        return aliveOrDied;
    }

    public static String getEMPLOYEE_TYPE_OFFICE() {
        return EMPLOYEE_TYPE_OFFICE;
    }

    public static String getEMPLOYEE_TYPE_shift() {
        return EMPLOYEE_TYPE_shift;
    }

    public void setAliveOrDied(String aliveOrDied) {
        this.aliveOrDied = aliveOrDied;
    }

    public void setEmploeeId(String emploeeId) {
        this.emploeeId = emploeeId;

    }
    private Option[] readNationality;

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDrlPayGrade() {
        return drlPayGrade;
    }

    public void setDrlPayGrade(String drlPayGrade) {
        this.drlPayGrade = drlPayGrade;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getHireDate() {
        return hireDate;
    }

    public void setHireDate(String hireDate) {
        this.hireDate = hireDate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getMidelName() {
        return midelName;
    }

    public void setMidelName(String midelName) {
        this.midelName = midelName;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getNationality() {
        return nationality;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    public Option[] getReadDepartment() {
        return readDepartment;
    }

    public void setReadDepartment(Option[] readDepartment) {
        this.readDepartment = readDepartment;
    }

    public Option[] getReadNation() {
        return readNation;
    }

    public void setReadNation(Option[] readNation) {
        this.readNation = readNation;
    }

    public Option[] getReadNationality() {
        return readNationality;
    }

    public void setReadNationality(Option[] readNationality) {
        this.readNationality = readNationality;
    }

    public Option[] getReadTitle() {
        return readTitle;
    }

    public void setReadTitle(Option[] readTitle) {
        this.readTitle = readTitle;
    }

    public String getRetirementNo() {
        return retirementNo;
    }

    public void setRetirementNo(String retirementNo) {
        this.retirementNo = retirementNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Option[] getLoadEmpIds() {
        return loadEmpIds;
    }

    public void setLoadEmpIds(Option[] loadEmpIds) {
        this.loadEmpIds = loadEmpIds;
    }

    public String getEmpTitle() {
        return empTitle;
    }

    public void setEmpTitle(String empTitle) {
        this.empTitle = empTitle;
    }

    public String getChest() {
        return Chest;
    }

    public void setChest(String Chest) {
        this.Chest = Chest;
    }

    public String getBlood_Group() {
        return blood_Group;
    }

    public void setBlood_Group(String blood_Group) {
        this.blood_Group = blood_Group;
    }

    public String getOfficeOrshift() {
        return officeOrShift;
    }

    public void setOfficeOrshift(String officeOrshift) {
        this.officeOrShift = officeOrshift;
    }

    public String getPermanentOrContract() {
        return permanentOrContract;
    }

    public void setPermanentOrContract(String permanentOrContract) {
        this.permanentOrContract = permanentOrContract;
    }

    public String getDate_Of_Birth() {
        return date_Of_Birth;
    }

    public void setDate_Of_Birth(String date_Of_Birth) {
        this.date_Of_Birth = date_Of_Birth;
    }

    public String getDepartmentDescription() {
        return departmentDescription;
    }

    public void setDepartmentDescription(String departmentDescription) {
        this.departmentDescription = departmentDescription;
    }

    public String getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(String department_id) {
        this.department_id = department_id;
    }

    public String getEmp_Status() {
        return emp_Status;
    }

    public void setEmp_Status(String emp_Status) {
        this.emp_Status = emp_Status;
    }

    public EmployeeEntity getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntity employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public String getEye_Color() {
        return eye_Color;
    }

    public void setEye_Color(String eye_Color) {
        this.eye_Color = eye_Color;
    }

    public String getFace_Color() {
        return face_Color;
    }

    public void setFace_Color(String face_Color) {
        this.face_Color = face_Color;
    }

    public String getFirst_Name() {
        return first_Name;
    }

    public void setFirst_Name(String first_Name) {
        this.first_Name = first_Name;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getHire_Date() {
        return hire_Date;
    }

    public void setHire_Date(String hire_Date) {
        this.hire_Date = hire_Date;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getLast_Name() {
        return last_Name;
    }

    public void setLast_Name(String last_Name) {
        this.last_Name = last_Name;
    }

    public String getMarital_Status() {
        return marital_Status;
    }

    public void setMarital_Status(String marital_Status) {
        this.marital_Status = marital_Status;
    }

    public String getMedical_id() {
        return medical_id;
    }

    public void setMedical_id(String medical_id) {
        this.medical_id = medical_id;
    }

    public String getMiddle_Name() {
        return middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        this.middle_Name = middle_Name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getRankeDscription() {
        return rankeDscription;
    }

    public void setRankeDscription(String rankeDscription) {
        this.rankeDscription = rankeDscription;
    }

    public String getRetirement_no() {
        return retirement_no;
    }

    public void setRetirement_no(String retirement_no) {
        this.retirement_no = retirement_no;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getSpecial_Ability() {
        return special_Ability;
    }

    public void setSpecial_Ability(String special_Ability) {
        this.special_Ability = special_Ability;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    String middle_Name;
    String last_Name;
    String department_id;
    String hire_Date;
    String date_Of_Birth;
    String marital_Status;
    String medical_id;
    String photo;
    String special_Ability;
    String retirement_no;
    String permanentOrContract;
    String officeOrShift;
    String emp_Status;
    String height;
    String Chest;
    String blood_Group;
    String eye_Color;
    String face_Color;
    String weight;
    byte[] finger_print;
    String departmentDescription;
    String jobDescription;
    //String jobName;
    String rankeDscription;
    String titleId;
    String nation_Code;
    String nationality_Description;
    String departmentId;
    String religion_Code;
    String nationality_Code;
    String job_Code;
    String first_Name;
    String empTitle;
    private String leaveStartFrom;
    OracleSerialBlob photobinary = null;

    public String getLeaveStartFrom() {
        return leaveStartFrom;
    }

    public void setLeaveStartFrom(String leaveStartFrom) {
        this.leaveStartFrom = leaveStartFrom;
    }

    public String getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getNationality_Description() {
        return nationality_Description;
    }

    public void setNationality_Description(String nationality_Description) {
        this.nationality_Description = nationality_Description;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }

    public String getNation_Code() {
        return nation_Code;
    }

    public void setNation_Code(String nation_Code) {
        this.nation_Code = nation_Code;
    }

    public String getNationality_Code() {
        return nationality_Code;
    }

    public void setNationality_Code(String nationality_Code) {
        this.nationality_Code = nationality_Code;
    }

    public AddressEntity getAddressEntity() {
        return addressEntity;
    }

    public String getOfficeOrShift() {
        return officeOrShift;
    }

    public void setOfficeOrShift(String officeOrShift) {
        this.officeOrShift = officeOrShift;
    }

    public String getReligion_Code() {
        return religion_Code;
    }

    public void setReligion_Code(String religion_Code) {
        this.religion_Code = religion_Code;
    }

    public void setAddressEntity(AddressEntity addressEntity) {
        this.addressEntity = addressEntity;
    }

    public ApperanceEntity getApperanceEntity() {
        return apperanceEntity;
    }

    public void setApperanceEntity(ApperanceEntity apperanceEntity) {
        this.apperanceEntity = apperanceEntity;
    }

    public FamilyEntity getFamily() {
        return family;
    }

    public void setFamily(FamilyEntity family) {
        this.family = family;
    }

    public byte[] getFinger_print() {
        return finger_print;
    }

    public void setFinger_print(byte[] finger_print) {
        this.finger_print = finger_print;
    }

    public LookUpManager getLookup() {
        return lookup;
    }

    public void setLookup(LookUpManager lookup) {
        this.lookup = lookup;
    }

    public OracleSerialBlob getPhotobinary() {
        return photobinary;
    }

    public void setPhotobinary(OracleSerialBlob photobinary) {
        this.photobinary = photobinary;
    }

    public ExperianceEntity getSaveEmployeeEntity() {
        return employeeExperianceEntity;
    }

    public void setSaveEmployeeEntity(ExperianceEntity saveEmployeeEntity) {
        this.employeeExperianceEntity = saveEmployeeEntity;
    }

    public String getTitleId() {
        return titleId;
    }

    public void setTitleId(String titleId) {
        this.titleId = titleId;
    }

    public Option[] getJob() {
        return job;
    }

    public void setJob(Option[] job) {
        this.job = job;
    }

    public Option[] getMaritalstatus() {
        return maritalstatus;
    }

    public void setMaritalstatus(Option[] maritalstatus) {
        this.maritalstatus = maritalstatus;
    }
    public ArrayList data;

    public ArrayList getData() {
        return data;
    }

    public void setData(ArrayList data) {
        this.data = data;
    }
    EmployeeEntity employeeEntity = new EmployeeEntity();

    public ArrayList<EmployeeList> EmployeeNametoAutoListForEmployeePage(String employeeName) {

        try {
            ResultSet rs = employeeEntity.searchEmployeeNametoAutoForEmployeePage(employeeName);
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            while (rs.next()) {
                EmployeeList empMgt = new EmployeeList(rs.getString("FIRST_NAME") + " " +
                        rs.getString("MIDDLE_NAME") + " " +
                        rs.getString("LAST_NAME"), rs.getString("EMP_ID"));
                proformaoption.add(empMgt);

            }
            return proformaoption;
        } catch (Exception ex) {
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<SelectItem> getReligionList() {
        ArrayList<SelectItem> religionList = new ArrayList<SelectItem>();
        religionList.add(new SelectItem("-1", "--Select Religion--"));
        religionList.add(new SelectItem("CR_OR", " Orthodox"));
        religionList.add(new SelectItem("CR_PR", " Protestant"));
        religionList.add(new SelectItem("CR_CT", " Catholic"));
        religionList.add(new SelectItem("CR_JH", " Jhovah"));
        religionList.add(new SelectItem("MS_MS", " Muslim"));
        religionList.add(new SelectItem("XX_XX", " Other"));
        return religionList;
    }

    public ArrayList<EmployeeList> EmployeeNametoAutoList() {

        try {
            ResultSet rs = employeeEntity.searchEmployeeNametoAuto();
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            while (rs.next()) {
                
                EmployeeList empMgt = new EmployeeList(rs.getString("FIRST_NAME") + " " +
                        rs.getString("MIDDLE_NAME") + " " + rs.getString("LAST_NAME"),
                        rs.getString("EMP_ID"));
                proformaoption.add(empMgt);
            }
            return proformaoption;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public Option[] loadEmployeesId() {
        try {
            ArrayList<EmployeeEntity> readEmployeeIDs = employeeEntity.readEmployeeId();
            loadEmpIds = new Option[readEmployeeIDs.size() + 1];
            Option fristEmpId = new Option("---Select Employee ID---");
            loadEmpIds[0] = fristEmpId;
            for (int i = 0; i < readEmployeeIDs.size(); i++) {
                employeeEntity = readEmployeeIDs.get(i);
                Option assign = new Option(employeeEntity.getEmpId(), employeeEntity.getEmpId());
                loadEmpIds[i + 1] = assign;

            }
        } catch (Exception ex) {
        }
        return loadEmpIds;
    }

    private Calendar convertDateToCalendar(String date) {
        try {
            String dateParameters[] = date.split("-");
            int year = Integer.parseInt(dateParameters[0]);
            int month = Integer.parseInt(dateParameters[1]);
            int day = Integer.parseInt(dateParameters[2]);
            return new GregorianCalendar(year, month, day);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return null;

    }

    private int searchById(String employeeeId) {
        EmployeeEntity lode = null;
        try {
            EmployeeEntity.setEmployeeId(employeeeId);
            lode = employeeEntity.serachById(employeeEntity);
            if (lode == null) {
                return 0;
            }
        } catch (Exception ex) {
        }
        return 1;
    }

    public int loadEmpoyeeProfile(String employeeId) {
        try {
            if (this.searchById(employeeId) == 1) {
                this.first_Name = employeeEntity.getFirst_Name();
                this.middle_Name = employeeEntity.getMiddle_Name();
                this.last_Name = employeeEntity.getLast_Name();
                this.departmentDescription = employeeEntity.getDepartmentDescription();
                this.hire_Date = employeeEntity.getHire_Date();
                this.date_Of_Birth = employeeEntity.getDate_Of_Birth();
                this.salary = employeeEntity.getSalary();
                this.marital_Status = employeeEntity.getMarital_Status();
                this.sex = employeeEntity.getSex();
                this.photo = employeeEntity.getPhoto();
                this.retirement_no = employeeEntity.getRetirement_no();
                this.permanentOrContract = employeeEntity.getPermanentOrContract();
                this.emp_Status = employeeEntity.getEmp_Status();
                this.height = employeeEntity.getHeight();
                this.Chest = employeeEntity.getChest();
                this.blood_Group = employeeEntity.getBlood_Group();
                this.eye_Color = employeeEntity.getEye_Color();
                this.face_Color = employeeEntity.getFace_Color();
                this.weight = employeeEntity.getWeight();
                this.jobDescription = employeeEntity.getJobDescription();
                this.jobName=employeeEntity.getJobName();
                this.rankeDscription = employeeEntity.getRankeDscription();
                this.rankId = employeeEntity.getRankid();
                this.empTitle = employeeEntity.getTitle();
                this.department_id = employeeEntity.getDepartment_id();
                this.departmentId = employeeEntity.getDepartmentid();
                this.nation_Code = employeeEntity.getNation();
                this.nationality_Code = employeeEntity.getNationality();
                this.religion_Code = employeeEntity.getReligion();
                this.photobinary = employeeEntity.getPhotobinary();
                this.drlPayGrade = employeeEntity.getPayGrade();
                this.jobCode = employeeEntity.getJob_Code();
                this.titleDes = employeeEntity.getTitleDes();
                this.officeOrShift = employeeEntity.getOfficeOrShift();
                this.permanentOrContract = employeeEntity.getPermanentOrContract();//
                this.leaveStartFrom = employeeEntity.getLeaveStartFrom();
                this.titleType = employeeEntity.getType();
                this.tinNumber = employeeEntity.getTinNumber();
                this.location = employeeEntity.getLocation();
                this.departmentDescription = employeeEntity.getDepartmentDescription();
                return 1;
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return 0;

    }

    public ArrayList<String> readEmployeeId1() {
        return employeeEntity.readEmployeeId1();
    }

    public int deleteEmployeeFamily(String familyId) {
        return employeeEntity.deleteEmployeeFamily(familyId);
    }

    public int deleteEmployeeAppreance(String employeeId) {
        return apperanceEntity.deleteEmployeeApperance(employeeId);
    }

    public int deleteEmployeeAddress(String addressId) {
        return addressEntity.deleteEmployeeAddress(addressId);
    }

    public ArrayList<SelectItem> assignAddressType() {
        ArrayList<String> readAddress = new ArrayList<String>();
        ArrayList<SelectItem> readAddressType = new ArrayList<SelectItem>();
        readAddress.add("Home Address");
        readAddress.add("Emergency Contact Address");
        readAddress.add("Leave Time Living Address");
        readAddress.add("Birth Place Address");
        readAddress.add("Family Living Address");

        for (int i = 0; i < readAddress.size(); i++) {
            readAddressType.add(new Option(String.valueOf(readAddress.get(i)),
                    String.valueOf(readAddress.get(i))));
        }
        readAddressType.add(0, new Option(null, "Select Address Type"));
        return readAddressType;

    }

    public ArrayList<SelectItem> assignRelationType() {
        try {
            ArrayList<String> readRelationType = new ArrayList<String>();
            readRelationType.add("Father");
            readRelationType.add("Mother");
            readRelationType.add("Spouse");
          //  readRelationType.add("ባል");
            readRelationType.add("Sibling");
           // readRelationType.add("እህት");
            readRelationType.add("Uncle");
            readRelationType.add("Aunt");
            readRelationType.add("Child");
            readRelationType.add("Other ");
            //========================================
            readRelationType.add("Grandparent");
            readRelationType.add("Father-in-law");
            readRelationType.add("Mother-in-law");
            readRelationType.add("Brother-in-law");
            readRelationType.add("Sister-in-law");
            readRelationType.add("Spouse Uncle");
            readRelationType.add("Spouse Aunt");
            readRelationType.add("Spouse Grandparent");
            readRelationType.add("Step Son/Daughter");
            readRelationType.add("Niece/ Nephew");
           // readRelationType.add("የወንድም ልጅ");
            //=============================================
            ArrayList<SelectItem> relationType = new ArrayList<SelectItem>();

            for (int i = 0; i < readRelationType.size(); i++) {
                relationType.add(new Option(String.valueOf(readRelationType.get(i)),
                        String.valueOf(readRelationType.get(i))));
            }
            relationType.add(0, new Option(null, "Select Relation Type"));
            return relationType;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//    public String readNewId() {
//        return employeeEntity.createNewEmployeeId();
//    }
    public static byte[] extractByteArray(File file) {
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {
            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);
        } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        return byteFile;
    }

    public int saveEmployeeFamily(EmployeeManage employeeManager, int perform)
    {
        if (employeeManager.getFamilyId() == null)
        {
            employeeManager.setFamilyId("");
        }
        int checkValue = 0;
        FamilyEntity familyEntity = new FamilyEntity();
        familyEntity.setEmployeeId(this.getEmploeeId());
        /*
        (String familyId,
        String hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type,
        String family_FirstName, String familyMidelName, String familyLastName,
        String aliveOrDied)*/
        FamilyEntity familyInformation = new FamilyEntity(
                employeeManager.getHire(),
                employeeManager.getDateof_Birth(),
                employeeManager.getEmergency_Contact(),
                employeeManager.get_sex(),
                employeeManager.getPhone_no(),
                employeeManager.getRelation_Type(),
                employeeManager.getFamily_FirstName(),
                employeeManager.getFamilyMidelName(),
                employeeManager.getFamilyLastName(),
                employeeManager.getAliveOrDied(),
                employeeManager.getFamilyId(), "");
        if (perform == 1) {
            checkValue = familyEntity.saveEmployeeFamily(familyInformation);
        }
        if (perform == 2) {
            // avilbleOnDbFamily = old_edited;
            if (employeeManager.getAvilbleOnDbFamily() == old_edited) {
                checkValue = familyEntity.updateEmployeeFamily(familyInformation, employeeManager.getFamilyId());
            } else if (employeeManager.getAvilbleOnDbFamily() == 0) {
                checkValue = familyEntity.saveEmployeeFamily(familyInformation);
            }
        }
        return checkValue;
    }

    /**
     * The method reads the employs services hired date and calculates the total service
     * in days.
     * @param empId the employee identofier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmpServiceDays(String empId) {
        employeeEntity.setEmployeeId(empId);
        employeeEntity.serachById(employeeEntity);
        int serviceInDays = 0;
        String todayInEc = StringDateManipulation.toDayInEc();
        if (employeeEntity.getHire_Date().length() >= 10) {
            String hiredDate = employeeEntity.getHire_Date();
            serviceInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInEc);
            return serviceInDays;
        } else {
            //  s.println("Bad Date Formatt");
        }

        return serviceInDays;
    }

    public int calculateEmpServiceYears(String empId) {
        employeeEntity.setEmployeeId(empId);
        employeeEntity.serachById(employeeEntity);
        int serviceInDays = 0;
        double serviceInDaysIndouble = 0.00;
        double totalServiceInYears = 0.000;
        String todayInEc = StringDateManipulation.toDayInEc();
        double k = 0.000;
        if (employeeEntity.getHire_Date().length() >= 10) {
            String hiredDate = employeeEntity.getHire_Date();
            serviceInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInEc);
            int i = 0;
            for (int j = StringDateManipulation.getYear(hiredDate); j <= StringDateManipulation.getYear(todayInEc); j++) {
                k++;
                if ((j % 4 == 0)) {//if it is leap year
                    i = i + 1;
                }
            }
            i += 365;
            serviceInDaysIndouble = (double) serviceInDays;
            k = (double) i;
            totalServiceInYears = serviceInDaysIndouble / k;
            totalServiceInYears = Math.round(totalServiceInYears);
//            if (StringDateManipulation.getMonth(hiredDate) < StringDateManipulation.getMonth(todayInEc)) {
//                totalServiceInYears++;
//            } else if (StringDateManipulation.getYear(hiredDate) == StringDateManipulation.getYear(todayInEc) &&
//                    StringDateManipulation.getMonth(hiredDate) == StringDateManipulation.getMonth(todayInEc) &&
//                    StringDateManipulation.getDate(hiredDate) < StringDateManipulation.getDate(hiredDate)) {
//            }

            return (int) totalServiceInYears;
        } else {
        }

        return (int) totalServiceInYears;
    }

    public int saveEmployeeExperiance(EmployeeManage employeeManager, int perform) {
        ExperianceEntity experianceEntity = new ExperianceEntity(
                employeeManager.getInstitution(),
                employeeManager.getTerminationReason(),
                employeeManager.getId(),
                employeeManager.getStartDate(),
                employeeManager.getCopletionDate(),
                employeeManager.getSalary(),
                employeeManager.getEmploeeId(),
                employeeManager.getJob_Code(),
                employeeManager.getRank(),
                employeeManager.getExperiencePrivateOrGovernmental(),
                employeeManager.getExperienceContractOrPrtmanent(),
                employeeManager.getExperienceRelationinInMugherJobCode(),
                employeeManager.getExperienceValidForLeave());
        if (perform == 1) {
            return employeeExperianceEntity.saveEmployeeExperiance(experianceEntity);
        } else {
            return employeeExperianceEntity.updateEmployeeExperiance(experianceEntity);
        }
    }

    /**
     * The method reads the employs services hired date and calculates the total service
     * in months.
     * @param empId the empoyee identifier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmployeeServiceMonth(String empId) {
        try {

            JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
            EmployeeEntity.setEmployeeId(empId);
            employeeEntity.serachById(employeeEntity);
            int serviceInDays = 0;
            int totalServiceInMonths = 0;
            String todayInGc = StringDateManipulation.toDayInGc();
            if (employeeEntity.getHire_Date().length() >= 10) {
                String hiredDate = employeeEntity.getHire_Date();
                serviceInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInGc);
                totalServiceInMonths = serviceInDays / 30;
                return totalServiceInMonths;
            } else {
                //  s.println("Bad Date Formatt");
            }
            return totalServiceInMonths;
        } catch (Exception e) {
            return 0;
        }
    }

    /**
     * The method reads the employs services hired date and calculates the total service
     * in years.
     * @param hiredate the empoyee hiredate
     * @return an integer indicating the total service years

     */
    public int calculateEmpServiceYear(String hiredDate) {

        int serviceInDays = 0;
        double serviceInDaysIndouble = 0.00;
        double totalServiceInYears = 0.000;
        String todayInEc = StringDateManipulation.toDayInEc();
        double k = 0.000;
        if (hiredDate.length() >= 10) {
            serviceInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInEc);
            int i = 0;
            for (int j = StringDateManipulation.getYear(hiredDate); j <= StringDateManipulation.getYear(todayInEc); j++) {
                k++;
                if ((j % 4 == 0)) {//if it is leap year
                    i = i + 1;
                }
            }
            i += 365;
            serviceInDaysIndouble = (double) serviceInDays;
            k = (double) i;
            totalServiceInYears = serviceInDaysIndouble / k;
            totalServiceInYears = Math.round(totalServiceInYears);
//            if (StringDateManipulation.getMonth(hiredDate) < StringDateManipulation.getMonth(todayInEc)) {
//                totalServiceInYears++;
//            } else if (StringDateManipulation.getYear(hiredDate) == StringDateManipulation.getYear(todayInEc) &&
//                    StringDateManipulation.getMonth(hiredDate) == StringDateManipulation.getMonth(todayInEc) &&
//                    StringDateManipulation.getDate(hiredDate) < StringDateManipulation.getDate(hiredDate)) {
//            }

            return (int) totalServiceInYears;
        } else {
        }

        return (int) totalServiceInYears;
    }

    /**
     * The method reads the employ's birth date and calculates his/her age
     * in years.
     * @param empId the empoyee identifier
     * @return an integer indicating the total service years
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmployeeAgeInYears(String empId) {
        EmployeeEntity.setEmployeeId(empId);
        employeeEntity.serachById(employeeEntity);
        String birthDate = employeeEntity.getDate_Of_Birth();
        return Math.abs(GregorianCalendarManipulation.calaculateYearDifference(birthDate));
    }

    /**
     * calculates the number of sercices an employee gave since
     * his/her recruitment date
     * @param employeeId
     */
    public int calculateEmployeeServiceYear(String employeeId) {
        EmployeeEntity.setEmployeeId(employeeId);
        employeeEntity.serachById(employeeEntity);
        String recruitmentDate = employeeEntity.getHire_Date();
        return Math.abs(GregorianCalendarManipulation.calaculateYearDifference(recruitmentDate));
    }

    public int calculateServiceYear(String employeeId) {
        EmployeeEntity.setEmployeeId(employeeId);
        employeeEntity.serachById(employeeEntity);
        String recruitmentDate = employeeEntity.getHire_Date();
        return GregorianCalendarManipulation.calculateExpriance(recruitmentDate);
    }




    public int calculateEmployeeServiceYearHireDate(String hireDate) {
        return GregorianCalendarManipulation.calculateExpriance(hireDate);
    }

    /**
     * The method reads the employs birth date and calculates his/her age
     * in days.
     * @param empId the employee identofier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmpAgeInDays(String empId) {
        employeeEntity.setEmployeeId(empId);
        employeeEntity.serachById(employeeEntity);
        int employeeAgeInDays = 0;
        String todayInEc = StringDateManipulation.toDayInEc();
        if (employeeEntity.getDate_Of_Birth().length() >= 10) {
            String hiredDate = employeeEntity.getDate_Of_Birth();
            employeeAgeInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInEc);
            return employeeAgeInDays;
        } else {
            //    s.println("Bad Date Formatt");
        }

        return employeeAgeInDays;
    }

    /**
     * The method reads the employs birth date and calculates his/her age
     * in months.
     * @param empId the empoyee identifier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmpAgeInMonths(String empId) {
        employeeEntity.setEmployeeId(empId);
        employeeEntity.serachById(employeeEntity);
        int employeeAgeInDays = 0;
        int employeeAgeInMonths = 0;
        String todayInEc = StringDateManipulation.toDayInEc();

        if (employeeEntity.getDate_Of_Birth().length() >= 10) {
            String hiredDate = employeeEntity.getDate_Of_Birth();
            employeeAgeInDays = StringDateManipulation.compareDateDifference(hiredDate, todayInEc);
            employeeAgeInMonths = employeeAgeInDays / 30;
            return employeeAgeInMonths;
        } else {
            //  s.println("Bad Date Formatt");
        }
        return employeeAgeInMonths;
    }

    public ArrayList<SelectItem> employeeName() {
        ArrayList<SelectItem> emplist = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = employeeEntity.readEmployeeName();
            if (_rs != null) {
                while (_rs.next()) {
                    String fullNameDesc = _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name");
                    emplist.add(new Option(_rs.getString("emp_Id"), fullNameDesc));
                }
                if (emplist.size() > 0) {
                    emplist.add(0, new Option(null, "---Select Employee Name---"));
                } else {
                    emplist.add(0, new Option(null, "No Employee name was found"));
                }
                _rs.close();
            } else {
                return null;
            }
            return emplist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int deleteEmployee(String empID) {
        return employeeEntity.deleteEmployee(empID);
    }

    public int deleteEmployeeFromExcelDate(String empID) {
        return employeeEntity.deleteEmployeeFromExcelDate(empID);
    }

    public ArrayList<HashMap> readEmployeeExperiance(String employeeId) {
        return employeeExperianceEntity.readExperiance(employeeId);
    }

    public int deleteEmployeeExperiance(String expID) {
        return employeeExperianceEntity.deleteEmployeeExperiance(expID);
    }

//    public int countExperiance(String empID) {
//        return employeeExperianceEntity.countEmployeeExperiance(empID);
//    }
    public String calculateLeaveToDate(String dateFr, String leaveDays) {
        String dateTo = null;
        dateTo = StringDateManipulation.nextDayInEC(dateFr);
        for (int i = 0; i < Integer.parseInt(leaveDays); i++) {
            dateTo = StringDateManipulation.nextDayInEC(dateTo);
        }
        int NoHoliyDays = StringDateManipulation.compareDateDifference(dateFr, dateTo) - HolidaysManager.getWorkingDays(dateFr, dateTo);
        for (int i = 0; i < NoHoliyDays; i++) {
            dateTo = StringDateManipulation.nextDayInEC(dateTo);
        }
        return dateTo;
    }

    public ArrayList<SelectItem> readDataFromExcel() {
        try {
            ArrayList<EmployeeEntity> employee_Entity = employeeEntity.readEmployeeTable();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (employee_Entity != null) {
                if (employee_Entity.size() > 0) {
                    for (int i = 0; i < employee_Entity.size(); i++) {
                        employeeEntity = employee_Entity.get(i);
                        questionlist.add(new Option(String.valueOf(employeeEntity.getcode()),
                                String.valueOf(employeeEntity.getDescription())));
                    }
                    questionlist.add(0, new Option(null, " Select Employee ID"));
                } else {
                    questionlist.add(0, new Option(null, "Employee id  not avilabel"));
                }
            }
            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int deleteEmpTitle(String titleID) {
        return employeeEntity.deleteEmpTitle(titleID);
    }

    public HashMap readEmployeeFromExcel(String employeeID) {
        return null;
    }

    public int addNewTitle(String titleDesc, String titleType) {
        return employeeEntity.addNewTitle(titleDesc, titleType);
    }

    public HashMap[] readEmpTitle() {
        return employeeEntity.readEmpTitle();
    }

    public ArrayList<String> readEmployeesId(String userName) {
        return employeeEntity.readEmployeeId1();

    }

    public HashMap readEmployeeBasicInfo(String employeeId) {
        try {
            return employeeEntity.readEmployeeBasicInfoFromId(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public HashMap readEmployeeBasicInformation(String employeeId) {
        try {
            return employeeEntity.readEmployeeBasicInformation(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean updateEmployeeStatus(String empId, String status) {
        try {
            employeeEntity.updateEmployeeStatus(empId, status);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<EmployeeList> EmployeeNametoAutoList(String employeeName) {
        try {
            OracleCachedRowSet orcs = new OracleCachedRowSet();
            byte[] bytePicture = null;
            orcs = employeeEntity.searchEmployeeNametoAuto(employeeName);
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            while (orcs.next()) {

                EmployeeList empMgt = new EmployeeList(orcs.getString("FIRST_NAME") + " " +
                        orcs.getString("MIDDLE_NAME") + " " + orcs.getString("LAST_NAME"),
                        orcs.getString("EMP_ID"), bytePicture);
                proformaoption.add(empMgt);
            }
            return proformaoption;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    /**
     * The method reads the employs exprance start and end datae and calculates the total service
     * in days.
     * @param empId the employee identofier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmployeeExperianceServiceYear(String empId) {
        try {
            String startExDate = null;
            String endDate = null;
            int experanceyear = 0;
            ArrayList<HashMap> listExpriance = employeeExperianceEntity.readEmployeeExprianceForLeave(empId);
            for (HashMap hm : listExpriance) {
                startExDate = hm.get("startDate").toString();
                endDate = hm.get("endDate").toString();
                Calendar startDateCal = convertDateToCalendar(startExDate);
                Calendar endDateCal = convertDateToCalendar(endDate);
                experanceyear += Math.abs(GregorianCalendarManipulation.calaculateYearDifference(startDateCal, endDateCal));
            }

            return experanceyear;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public String calculateEmployeeExperianceNotMugher(String empId) {
        try {
            String startExDate = null;
            String endDate = null;
            int experanceyear = 0;
            ArrayList<HashMap> listExpriance = employeeExperianceEntity.readEmployeeExpriance(empId);
            for (HashMap hm : listExpriance) {
                startExDate = hm.get("startDate").toString();
                endDate = hm.get("endDate").toString();
                Calendar startDateCal = convertDateToCalendar(startExDate);
                Calendar endDateCal = convertDateToCalendar(endDate);
                experanceyear += Math.abs(GregorianCalendarManipulation.calaculateYearDifference(startDateCal, endDateCal));
            }
            return Integer.toString(experanceyear);
        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    void calculate() {
        Calendar myBirthDate = Calendar.getInstance();
        myBirthDate.clear();
        myBirthDate.set(2008, 3 - 1, 26);
        Calendar now = Calendar.getInstance();
        Calendar clone = (Calendar) myBirthDate.clone(); // Otherwise changes are been reflected.
        int years = -1;
        while (!clone.after(now)) {
            clone.add(Calendar.YEAR, 1);
            years++;
        }
    //  s.println("years>>>>>>" + years); // 32
    }

    public String readHireDate(String employeeId) {
        return employeeEntity.readHireDate(employeeId);
    }

    public String departmentDetileDescription(String departmentId) {
       
        return employeeEntity.departmentDetileDescription(departmentId);
    }

    public OracleSerialBlob readEmployeePhoto(String employeeId) {
        return employeeEntity.readEmployeePhoto(employeeId);
    }

    public boolean updateLeaveTimeAddress(
            String employeeId,
            String region,
            String zoneOrCity,
            String woreda,
            String kabele,
            String houseNumber,
            String telephoneHome,
            String telephoneMoblie,
            String addressId) {
        try {
            return addressEntity.updateLeaveTimeAddress(employeeId,
                    region,
                    zoneOrCity,
                    woreda,
                    kabele,
                    houseNumber,
                    telephoneHome,
                    telephoneMoblie,
                    addressId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public int employeLevel(String employeeId) {
        try {
            return employeeEntity.employeLevel(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public boolean isBossOftheEmployee(String requesterId, String participantId) {
        try {

            if (employeeEntity.isBossOfEmployee(requesterId, participantId) >= 1) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

    public String employeeDepartmentPath(String employeeId) {
        return employeeEntity.employeeDepartmentPath(employeeId);
    }

    public String employeeWorkingPlace(String departmentId) {
        return employeeEntity.employeeWorkingPlace(departmentId);
    }

    public String employeeFullName(String employeeId) {
        return employeeEntity.employeeFullName(employeeId);
    }

    public byte[] singleSelect(String documentId) {

        try {
            byte[] bytePicture = null;
            ResultSet rs = employeeEntity.selectDocument(documentId);

            if (rs.next()) {

                bytePicture = rs.getBlob("EMPFILE").getBytes(1, (int) rs.getBlob("EMPFILE").length());
                return bytePicture;
            }
        } catch (Exception ex) {
            ex.printStackTrace();


        }
        return null;
    }

    public ArrayList<SelectItem> getListLocation() {
        ArrayList<SelectItem> lsitOfLocation = new ArrayList<SelectItem>();
        lsitOfLocation.add(new SelectItem(null, "Select Location"));
        lsitOfLocation.add(new SelectItem("Addis Ababa", "Addis Ababa"));
        lsitOfLocation.add(new SelectItem("Adma", "Adma"));
        lsitOfLocation.add(new SelectItem("Bahirdar", "Bahirdar"));
        lsitOfLocation.add(new SelectItem("Mekele", "Mekele"));
        lsitOfLocation.add(new SelectItem("Gondar", "Gondar"));
        lsitOfLocation.add(new SelectItem("Hosanna", "Hosanna"));
        lsitOfLocation.add(new SelectItem("Bichena", "Bichena"));
        lsitOfLocation.add(new SelectItem("Kobo Robit", "Kobo Robit"));
        lsitOfLocation.add(new SelectItem("Jimma", "Jimma"));
        lsitOfLocation.add(new SelectItem("Hawassa", "Hawassa"));
        lsitOfLocation.add(new SelectItem("Gambella", "Gambella"));
        lsitOfLocation.add(new SelectItem("Dessie", "Dessie"));
        lsitOfLocation.add(new SelectItem("Debrebirhan", "Debrebirhan"));
        lsitOfLocation.add(new SelectItem("Bale Goba", "Bale Goba"));
        lsitOfLocation.add(new SelectItem("Bale Robe", "Bale Robe"));
        lsitOfLocation.add(new SelectItem("Halaba", "Halaba"));
        lsitOfLocation.add(new SelectItem("Yirgalem", "Yirgalem"));
        lsitOfLocation.add(new SelectItem("Shashemene", "Shashemene"));
        lsitOfLocation.add(new SelectItem("Debere Markos", "Debere Markos"));
        lsitOfLocation.add(new SelectItem("Moyale", "Moyale"));
        lsitOfLocation.add(new SelectItem("Dejen", "Dejen"));
        lsitOfLocation.add(new SelectItem("Nekemet", "Nekemet"));
        lsitOfLocation.add(new SelectItem("Dire Dawa", "Dire Dawa"));
        lsitOfLocation.add(new SelectItem("Harar", "Harar"));
        //lsitOfLocation.add(new SelectItem("Dire Dawa", "Dire Dawa"));



        return lsitOfLocation;
    }
}
