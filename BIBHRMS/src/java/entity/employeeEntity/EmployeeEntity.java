/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;
import java.io.*;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author Administrator
 */
public class EmployeeEntity extends ConnectionManager {

    ResultSet _rs = null;
    Connection _con = null;
    PreparedStatement _ps = null;
    private String leaveStartFrom;
    String region;
    String woreda;
    String kabele;
    String zone;
    String houseNumber;
    String pobox;
    String moblile;
    String telOffice;
    String telHome;
    String email;
    String imageName;
    byte[] empImage;
    private String tinNumber;
    private String location;
    String middle_Name;
    String last_Name;
    String title;
    String department_id;
    String hire_Date;
    String date_Of_Birth;
    String salary;
    String marital_Status;
    String sex;
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
    String finger_print;
    String departmentDescription;
    String jobDescription;
    String job_Code;
    String jobName;

    private String type;

  

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

    public String getLeaveStartFrom() {
        return leaveStartFrom;
    }

    public void setLeaveStartFrom(String leaveStartFrom) {
        this.leaveStartFrom = leaveStartFrom;
    }

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }

    public EmployeeEntity(String employyeID, String height, String weight, String bloodGroup, String eyeColor, String chest) {
        this.empId = employyeID;
        this.height = height;
        this.weight = weight;
        this.blood_Group = bloodGroup;
        this.eye_Color = eyeColor;
        this.Chest = chest;
    }
    String employeeName;

    public String getEmployeeName() {
        return employeeName;
    }

    public HashMap<String, String> readEmployeeBasicInfo(String empId) {

        HashMap<String, String> myReturn = new HashMap();
        String stm = "select tbl_employee_info.FRIST_NAME  ||'  '||   tbl_employee_info.FATHER_NAME  ||'  '||  tbl_employee_info.G_FATHER_NAME as fulName," +
                "tbl_employee_info.SEX," +
                "tbl_employee_info.WORKINGPLACE,   " +
                "  tbl_employee_info.JOBPOSITION,  " +
                " tbl_employee_info.WORKINGPLACE, " +
                " tbl_employee_info.SALARY from tbl_employee_info " +
                "where EMPLOYEE_ID='" + empId + "'";

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();

            if (rs == null) {
            } else {

                while (rs.next()) {
                    //  String id = rs.getString("employee_id");
                    myReturn.put("jobposition", rs.getString("JOBPOSITION"));
                    myReturn.put("fulName", rs.getString("fulName"));
                    myReturn.put("workingPlace", rs.getString("WORKINGPLACE"));
                    myReturn.put("salary", rs.getString("SALARY"));
                    myReturn.put("sex", rs.getString("SEX"));

                }
            }
        } catch (SQLException ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return myReturn;

    }

    public boolean isEmployeeHold(String jobCode) throws Exception {
        String stm = "SELECT COUNT(EMP_ID) AS COUNTED " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE JOB_CODE       ='" + jobCode + "' ";
        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                if (rs.next()) {
                    if (rs.getInt("COUNTED") > 0) {
                        return false;
                    } else {
                        return true;
                    }

                } else {
                    return true;
                }
            } else {
                return true;
            }
        } finally {
            releaseResources();
        }





    }

    public int isBossOfEmployee(String bossId, String empId) throws SQLException {

        String stm = "SELECT COUNT(EMP_ID) AS COUNTED " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID       ='" + empId + "' " +
                "AND DEPARTMENT_ID IN " +
                "  (SELECT DEPT_ID " +
                "  FROM TBL_DEPT_BUNNA " +
                "    START WITH DEPT_ID = " +
                "    (SELECT DEPARTMENT_ID FROM HR_EMPLOYEE_INFO WHERE EMP_ID='" + bossId + "' " +
                "    ) " +
                "    CONNECT BY PRIOR DEPT_ID = BRANCH_ID " +
                "  )";

        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(stm);
//            _ps.setString(1, empId);
//            _ps.setString(2, bossId);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {
                if (rs.next()) {
                    return rs.getInt("COUNTED");
                } else {
                    return 0;
                }
            }
        } finally {
            releaseResources();
        }
        return 0;

    }

    public String readEmployeesId(String userName) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int saveEmployeeApperance(EmployeeEntity employeeEntity) {
        int checkSave = 0;
        String _select = "INSERT INTO hr_emp_appearance" +
                "(emp_Id,HEIGHT,WEIGHT,BLOOD_GROUP,EYE_COLOR,CHEST)" +
                " VALUES ('" + employeeEntity.getEmpId() + "','" +
                employeeEntity.getHeight() + "','" +
                employeeEntity.getWeight() + "','" +
                employeeEntity.getBlood_Group() + "','" +
                employeeEntity.getEye_Color() + "','" +
                employeeEntity.getChest() + "')";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            checkSave = _ps.executeUpdate();
            return checkSave;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return checkSave;
    }
    String woredaSubCity;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getTelNumberMobile() {
        return telNumberMobile;
    }

    public void setTelNumberMobile(String telNumberMobile) {
        this.telNumberMobile = telNumberMobile;
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
    String kebelle;
    String telNumberHome;
    String telNumberOffice;
    String telNumberMobile;
    String address;
    String zoneCity;
    String rankid;

    public String getRankid() {
        return rankid;
    }

    public void setRankid(String rankid) {
        this.rankid = rankid;
    }

    public String getZoneCity() {
        return zoneCity;
    }

    public void setZoneCity(String zoneCity) {
        this.zoneCity = zoneCity;
    }

    public EmployeeEntity(String empId, String region,
            String zoneCity, String woredaSubCity,
            String kebelle, String houseNumber,
            String telNumberHome, String telNumberOffice,
            String telNumberMobile, String email,
            String pobox, String addressType) {
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
    }
    public static String employeeId;

    public static String getEmployeeId() {
        return employeeId;
    }

    public static void setEmployeeId(String employeeId) {
        EmployeeEntity.employeeId = employeeId;
    }
    private String religion;
    private String nationality;
    private String nation;
    private String payGrade;
    String dateof_Birth;
    String emergency_Contact;
    String _sex;
    String relation_Type;
    String family_FirstName;
    String familyMidelName;
    String familyLastName;
    String emergenceyContact;

    public String getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(String payGrade) {
        this.payGrade = payGrade;
    }

    public Connection get_con() {
        return _con;
    }

    public void set_con(Connection _con) {
        this._con = _con;
    }

    public PreparedStatement get_ps() {
        return _ps;
    }

    public void set_ps(PreparedStatement _ps) {
        this._ps = _ps;
    }

    public ResultSet get_rs() {
        return _rs;
    }

    public void set_rs(ResultSet _rs) {
        this._rs = _rs;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
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

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }
    int hire;

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

    public int getHire() {
        return hire;
    }

    public void setHire(int hire) {
        this.hire = hire;
    }

    public String getRelation_Type() {
        return relation_Type;
    }

    public void setRelation_Type(String relation_Type) {
        this.relation_Type = relation_Type;
    }

    public String getEmergenceyContact() {
        return emergenceyContact;
    }

    public void setEmergenceyContact(String emergenceyContact) {
        this.emergenceyContact = emergenceyContact;
    }

    public String getEmergencyJob() {
        return emergencyJob;
    }

    public void setEmergencyJob(String emergencyJob) {
        this.emergencyJob = emergencyJob;
    }
    String emergencyJob;

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

    public EmployeeEntity(
            String addressType,
            String region,
            String woreda,
            String kabele,
            String zone,
            String houseNumber,
            String pobox,
            String moblile,
            String telOffice,
            String telHome,
            String email) {
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

    public String getTinNumber() {
        return tinNumber;
    }

    public void setTinNumber(String tinNumber) {
        this.tinNumber = tinNumber;
    }

    public byte[] getEmpImage() {
        return empImage;
    }

    public void setEmpImage(byte[] empImage) {
        this.empImage = empImage;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }

    public EmployeeEntity(int hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type, String family_FirstName, String familyMidelName, String familyLastName, String emergenceyContact, String emergencyJob) {
        this.hire = hire;
        this.dateof_Birth = dateof_Birth;
        this.emergency_Contact = emergency_Contact;
        this._sex = _sex;
        this.relation_Type = relation_Type;
        this.family_FirstName = family_FirstName;
        this.familyMidelName = familyMidelName;
        this.familyLastName = familyLastName;
        this.emergenceyContact = emergenceyContact;
        this.emergencyJob = emergencyJob;
    }

    public EmployeeEntity(String empId,
            String title,
            String firstName,
            String midelName,
            String lastName,
            String sex,
            String dateOfBirth,
            String maritalStatus,
            String nationality,
            String nation,
            String hireDate,
            String retirementNo,
            String department,
            String jobCode,
            String rankId,
            String payGrade,
            String salary,
            String civilType,
            byte[] imageName,
            String tinNumber,
            String location) {
        this.empId = empId;
        this.title = title;
        this.first_Name = firstName;
        this.middle_Name = midelName;
        this.last_Name = lastName;
        this.sex = sex;
        this.date_Of_Birth = dateOfBirth;
        this.nationality = nationality;
        this.nation = nation;
        this.hire_Date = hireDate;
        this.retirement_no = retirementNo;
        this.department_id = department;
        this.jobDescription = jobCode;
        this.rankeDscription = rankId;
        this.payGrade = payGrade;
        this.salary = salary;
        this.empImage = imageName;
        this.permanentOrContract = civilType;
        this.marital_Status = maritalStatus;
        this.tinNumber = tinNumber;
        this.location = location;
    }

    public EmployeeEntity(
            String empId,
            String title,
            String firstName,
            String midelName,
            String lastName,
            String sex,
            String dateOfBirth,
            String maritalStatus,
            String religion,
            String nationality,
            String nation,
            String hireDate,
            String retirementNo,
            String department,
            String jobCode,
            String rankId,
            String payGrade,
            String salary,
            String permanentOrContract,
            String officeOrShift,
            byte[] imageName,
            String tinNumber,
            String location) {
        this(empId,
                title,
                firstName,
                midelName,
                lastName,
                sex,
                dateOfBirth,
                maritalStatus,
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
                imageName,
                tinNumber,
                location);
        this.religion = religion;
    }

    public EmployeeEntity(String empId,
            String title,
            String firstName,
            String midelName,
            String lastName,
            String sex,
            String dateOfBirth,
            String maritalStatus,
            String nationality,
            String nation,
            String hireDate,
            String retirementNo,
            String department,
            String jobCode,
            String rankId,
            String payGrade,
            String salary,
            String permanentOrContract,
            String officeOrShift,
            byte[] imageName,
            String tinNumber,
            String location) {
        this.empId = empId;
        this.title = title;
        this.first_Name = firstName;
        this.middle_Name = midelName;
        this.last_Name = lastName;
        this.sex = sex;
        this.date_Of_Birth = dateOfBirth;
        this.nationality = nationality;
        this.nation = nation;
        this.hire_Date = hireDate;
        this.retirement_no = retirementNo;
        this.department_id = department;
        this.jobDescription = jobCode;
        this.rankid = rankId;
        this.payGrade = payGrade;
        this.salary = salary;
        this.marital_Status = maritalStatus;
        this.permanentOrContract = permanentOrContract;
        this.officeOrShift = officeOrShift;
        this.empImage = imageName;
        this.tinNumber = tinNumber;
        this.location = location;
    }

    public String savePersonalInformation(EmployeeEntity saveEntity) throws IOException {

        String _select = null;
        String empStatus = "01";
        String todayInEc = StringDateManipulation.toDayInEc();
        String hireDate = saveEntity.getHire_Date().toString();
        String errorcode;
        String newEmployeeId = "";
        try {
            newEmployeeId = creatNewEmployeeIdToBeDeletedAfterAutomation(
                    saveEntity.getEmpId(),
                    saveEntity.getFirst_Name(),
                    saveEntity.getMiddle_Name());
            if (saveEntity.getPermanentOrContract().equals("Contract")) {
                newEmployeeId += "C";
            }
        } catch (Exception e) {
            ErrorLogWriter.writeError(e);
        }
        int pos = 0;
        int check;
        try {
            int countServices = StringDateManipulation.compareDateDifference(hireDate, todayInEc);
            countServices = countServices / 30;
            if (countServices <= 6) {
                empStatus = "07";
            }
        } catch (Exception e) {
            ErrorLogWriter.writeError(e);
        }
        _select = "INSERT INTO hr_employee_info" +
                "(emp_Id," +
                "title," +
                "first_Name," +
                "middle_Name," +
                "last_Name," +
                "sex," +
                "Date_Of_Birth," +
                "marital_Status," +
                "nationality," +
                "nation_Code," +
                "hire_Date," +
                "retirement_no," +
                "DEPARTMENT_ID," +
                "job_Code," +
                "rank_Id," +
                "pay_Grade," +
                "salary," +
                "EMPLOYMENTTYPE," +
                "Office_or_shift," +
                "PHOTO," +
                " RELIGION ," +
                "EMP_STATUS," +
                "TIN_NUMBER," +
                "LOCATION)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            //  _ps.setString(1, saveEntity.getEmpId());
            _ps.setString(1, newEmployeeId);
            _ps.setString(2, saveEntity.getTitle());
            _ps.setString(3, saveEntity.getFirst_Name());
            _ps.setString(4, saveEntity.getMiddle_Name());
            _ps.setString(5, saveEntity.getLast_Name());
            _ps.setString(6, saveEntity.getSex());
            _ps.setString(7, saveEntity.getDate_Of_Birth());
            _ps.setString(8, saveEntity.getMarital_Status());
            _ps.setString(9, saveEntity.getNationality());
            _ps.setInt(10, Integer.parseInt(saveEntity.getNation()));
            _ps.setString(11, saveEntity.getHire_Date());
            _ps.setString(12, saveEntity.getRetirement_no());
            _ps.setInt(13, Integer.parseInt(saveEntity.getDepartment_id()));
            _ps.setString(14, saveEntity.getJobDescription());
            _ps.setString(15, saveEntity.getRankid());
            _ps.setString(16, saveEntity.getPayGrade());
            _ps.setString(17, (saveEntity.getSalary()));
            _ps.setString(18, saveEntity.getPermanentOrContract());
            _ps.setString(19, saveEntity.getOfficeOrShift());
            _ps.setBytes(20, saveEntity.getEmpImage());
            _ps.setString(21, saveEntity.getReligion());
            _ps.setString(22, empStatus);
            _ps.setString(23, saveEntity.getTinNumber());
            _ps.setString(24, saveEntity.getLocation());
            if (_ps.executeUpdate() > 0) {
                return "1=" + newEmployeeId;
            } else {
                return "0=" + newEmployeeId;
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            pos = ex.getMessage().indexOf(":");
            errorcode = ex.getMessage().substring(0, pos);
            if (errorcode.equals("ORA-00001")) {
                check = 3;
            } else {
                check = 0;
            }

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return Integer.toString(check) + newEmployeeId;

    }
    String first_Name;
    String empTitle;

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

    public String getFinger_print() {
        return finger_print;
    }

    public void setFinger_print(String finger_print) {
        this.finger_print = finger_print;
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

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getCode() {
        return code;
    }

    public String getRetirement_no() {
        return retirement_no;
    }

    public void setRetirement_no(String retirement_no) {
        this.retirement_no = retirement_no;
    }

    public String getOfficeOrShift() {
        return officeOrShift;
    }

    public void setOfficeOrShift(String officeOrShift) {
        this.officeOrShift = officeOrShift;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }
    String rankeDscription;
    //oracle.sql.BLOB photobinary;
    OracleSerialBlob photobinary;

    public OracleSerialBlob getPhotobinary() {
        return photobinary;
    }

    public void setPhotobinary(OracleSerialBlob photobinary) {
        this.photobinary = photobinary;
    }

//    public BLOB getPhotobinary() {
//        return photobinary;
//    }
//
//    public void setPhotobinary(BLOB photobinary) {
//        this.photobinary = photobinary;
//    }
    public EmployeeEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public EmployeeEntity(String first_Name, String middle_Name, String last_Name, String title, String titleDes,
            String department_id, String hire_Date, String date_Of_Birth, String salary, String marital_Status,
            String sex, String medical_id, String photo, String special_Ability, String retirement_no,
            String permanentOrContract, String emp_Status, String height, String Chest, String blood_Group,
            String eye_Color, String face_Color, String weight, String finger_print, String departmentDescription,
            String jobDescription, String rankid, OracleSerialBlob bineryPhto) {

        this.first_Name = first_Name;
        this.middle_Name = middle_Name;
        this.last_Name = last_Name;
        this.title = title;
        this.titleDes = titleDes;
        this.department_id = department_id;
        this.hire_Date = hire_Date;
        this.date_Of_Birth = date_Of_Birth;
        this.salary = salary;
        this.marital_Status = marital_Status;
        this.sex = sex;
        this.medical_id = medical_id;
        this.photo = photo;
        this.special_Ability = special_Ability;
        this.retirement_no = retirement_no;
        this.permanentOrContract = permanentOrContract;
        this.emp_Status = emp_Status;
        this.height = height;
        this.Chest = Chest;
        this.blood_Group = blood_Group;
        this.eye_Color = eye_Color;
        this.face_Color = face_Color;
        this.weight = weight;
        this.finger_print = finger_print;
        this.departmentDescription = departmentDescription;
        this.jobDescription = jobDescription;
        this.rankid = rankid;
        this.photobinary = bineryPhto;
    }

    public EmployeeEntity(String first_Name,
            String middle_Name,
            String last_Name,
            String title,
            String titleDes,
            String department_id,
            String hire_Date,
            String date_Of_Birth,
            String salary,
            String marital_Status,
            String sex,
            String medical_id,
            String photo,
            String special_Ability,
            String retirement_no,
            String permanentOrContract,
            String officeOrShift,
            String emp_Status,
            String height,
            String Chest,
            String blood_Group,
            String eye_Color,
            String face_Color,
            String weight,
            String finger_print,
            String departmentDescription,
            String jobDescription,
            String rankid,
            String religion,
            OracleSerialBlob bineryPhto,
            String leaveStartFrom,
            String location) {
        this(first_Name, middle_Name, last_Name, title, titleDes,
                department_id, hire_Date, date_Of_Birth, salary, marital_Status,
                sex, medical_id, photo, special_Ability, retirement_no,
                permanentOrContract, officeOrShift, emp_Status, height, Chest, blood_Group,
                eye_Color, face_Color, weight, finger_print, departmentDescription,
                jobDescription, rankid, bineryPhto, leaveStartFrom, location);

        this.religion = religion;
    }

    public EmployeeEntity(String first_Name, String middle_Name, String last_Name, String title, String titleDes,
            String department_id, String hire_Date, String date_Of_Birth, String salary, String marital_Status,
            String sex, String medical_id, String photo, String special_Ability, String retirement_no,
            String permanentOrContract, String officeOrShift, String emp_Status, String height, String Chest, String blood_Group,
            String eye_Color, String face_Color, String weight, String finger_print, String departmentDescription,
            String jobDescription, String rankid, OracleSerialBlob bineryPhto, String leaveStartFrom,
            String location) {

        this.first_Name = first_Name;
        this.middle_Name = middle_Name;
        this.last_Name = last_Name;
        this.title = title;
        this.titleDes = titleDes;
        this.department_id = department_id;
        this.hire_Date = hire_Date;
        this.date_Of_Birth = date_Of_Birth;
        this.salary = salary;
        this.marital_Status = marital_Status;
        this.sex = sex;
        this.medical_id = medical_id;
        this.photo = photo;
        this.special_Ability = special_Ability;
        this.retirement_no = retirement_no;
        this.permanentOrContract = permanentOrContract;
        this.officeOrShift = officeOrShift;
        this.emp_Status = emp_Status;
        this.height = height;
        this.Chest = Chest;
        this.blood_Group = blood_Group;
        this.eye_Color = eye_Color;
        this.face_Color = face_Color;
        this.weight = weight;
        this.finger_print = finger_print;
        this.departmentDescription = departmentDescription;
        this.jobDescription = jobDescription;
        this.rankid = rankid;
        this.photobinary = bineryPhto;
        this.leaveStartFrom = leaveStartFrom;
        this.location = location;
    }
    private String departmentid;

    public String getDepartmentid() {
        return departmentid;
    }

    public void setDepartmentid(String departmentid) {
        this.departmentid = departmentid;
    }
    private String empId;
    private String code;

    public String getcode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    private String description;

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public EmployeeEntity() {
    }

    public EmployeeEntity(String _empId) {
        this.empId = _empId;
    }

    public ResultSet searchEmployeeNametoAuto() {
        String qry = "SELECT FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMP_ID from HR_EMPLOYEE_INFO ";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet searchEmployeeNametoAutoForEmployeePage(String employeeName) {
        String qry = null;
        qry = "SELECT FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMP_ID from HR_EMPLOYEE_INFO WHERE FIRST_NAME like'" + employeeName + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            return null;
        }
    }

    public EmployeeEntity serachById(EmployeeEntity employeeEntity) {
        EmployeeEntity employeesProfile = null;
        String _select = "SELECT hr_employee_info.RANK_ID, " +
                "  hr_employee_info.PAY_GRADE, " +
                "  hr_employee_info.NATIONALITY, " +
                "  hr_employee_info.department_id, " +
                "  hr_employee_info.NATION_CODE, " +
                "  hr_employee_info.TITLE, " +
                "  hr_employee_info.first_Name, " +
                "  hr_employee_info.middle_Name, " +
                "  hr_employee_info.last_Name, " +
                "  hr_employee_info.hire_Date, " +
                "  hr_employee_info.salary, " +
                "  hr_employee_info.OFFICE_OR_SHIFT, " +
                "  hr_employee_info.EMPLOYMENTTYPE, " +
                "  hr_employee_info.Date_Of_Birth, " +
                "  hr_employee_info.marital_Status, " +
                "  hr_employee_info.PHOTO, " +
                "  hr_employee_info.sex, " +
                "  hr_employee_info.retirement_no, " +
                "  hr_employee_info.emp_Status, " +
                "  hr_employee_info.job_Code, " +
                "  hr_employee_info.RELIGION, " +
                "  hr_lu_job_type.JOB_DESCRIPTION, " +
                "  hr_lu_job_type.JOB_NAME, " +
                "  hr_lu_rank.RANK_DESCRIPTION, " +
                "  hr_lu_title.title_description, " +
                "  hr_lu_title.TYPE, " +
                "  hr_lu_nationality.nationalitydescription, " +
                "  hr_lu_nation.description , " +
                "  hr_employee_info.LEAVESTARTFROM, " +
                "  hr_employee_info.TIN_NUMBER, " +
                "  Hr_Employee_Info.Location, " +
                "  de.dep_description " +
                " FROM hr_employee_info, " +
                "  hr_lu_job_type, " +
                "  hr_lu_rank, " +
                "  hr_lu_title, " +
                "  hr_lu_nationality, " +
                "  Hr_Lu_Nation , " +
                " TBL_DEPT_BUNNA de " +
                " WHERE hr_lu_job_type.job_code      = hr_employee_info.job_Code " +
                " AND hr_lu_rank.rank_id             =hr_employee_info.rank_id " +
                 "AND hr_lu_title.title_id           =hr_employee_info.title " +
                " AND Hr_Lu_Nationality.Nationalityid=Hr_Employee_Info.Nationality " +
                " AND Hr_Lu_Nation.Nation_Code       =Hr_Employee_Info.Nation_Code " +
                " AND hr_employee_info.department_id = de.dept_id   and " +
                "  hr_employee_info.emp_Id='" + EmployeeEntity.getEmployeeId() + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {

                this.first_Name = ocrs.getString("first_Name");
                this.middle_Name = ocrs.getString("middle_Name");
                this.last_Name = ocrs.getString("last_Name");
                this.title = ocrs.getString("TITLE");
                this.type = ocrs.getString("TYPE");
                this.titleDes = ocrs.getString("title_description");
                this.hire_Date = ocrs.getString("hire_Date");
                this.date_Of_Birth = ocrs.getString("date_Of_Birth");
                this.salary = ocrs.getString("salary");
                this.marital_Status = ocrs.getString("marital_Status");
                this.sex = ocrs.getString("sex");
                this.job_Code = ocrs.getString("job_Code");
                this.retirement_no = ocrs.getString("retirement_no");
                this.permanentOrContract = ocrs.getString("EMPLOYMENTTYPE");
                this.emp_Status = ocrs.getString("emp_Status");
                this.departmentid = ocrs.getString("department_id");
                this.jobDescription = ocrs.getString("JOB_DESCRIPTION");
                this.jobName= ocrs.getString("JOB_NAME");
                this.rankeDscription = ocrs.getString("RANK_DESCRIPTION");
                this.nationality = ocrs.getString("NATIONALITY");
                this.nation = ocrs.getString("NATION_CODE");
                this.rankid = ocrs.getString("RANK_ID");
                this.payGrade = ocrs.getString("PAY_GRADE");
                this.photobinary = (OracleSerialBlob) ocrs.getBlob("PHOTO");
                this.officeOrShift = ocrs.getString("OFFICE_OR_SHIFT");
                this.religion = ocrs.getString("RELIGION");
                this.leaveStartFrom = ocrs.getString("LEAVESTARTFROM");
                this.tinNumber = ocrs.getString("TIN_NUMBER");
                this.location = ocrs.getString("LOCATION");
              //  this.departmentDescription = ocrs.getString("dep_description");
                employeesProfile = new EmployeeEntity(first_Name,
                        middle_Name,
                        last_Name,
                        title,
                        titleDes,
                        department_id,
                        hire_Date,
                        date_Of_Birth,
                        salary,
                        marital_Status,
                        sex,
                        medical_id,
                        photo,
                        special_Ability,
                        retirement_no,
                        permanentOrContract,
                        officeOrShift,
                        emp_Status,
                        height,
                        Chest,
                        blood_Group,
                        eye_Color,
                        face_Color,
                        weight,
                        finger_print,
                        departmentDescription,
                        jobDescription,
                        rankid,
                        religion,
                        photobinary,
                        leaveStartFrom,
                        location);

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return employeesProfile;
    }

    public ArrayList<EmployeeEntity> readEmployeeId() {
        String last_emp_id = "";
        String _select;
        _select = "select max(EMP_ID) from HR_EMPLOYEE_Info";
        ArrayList<EmployeeEntity> employeesID = new ArrayList<EmployeeEntity>();
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            boolean code = true;
            while (_rs.next()) {
                last_emp_id = _rs.getString("EMp_Id");
            }
            return employeesID;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
      public void ClearCandidate(String candidateID) {
         String _select = "delete from HR_CANDIDATE WHERE CANDIDATE_ID =?";
           try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, candidateID);
            _rs = _ps.executeQuery();
               } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
           // return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<String> readEmployeeId1() {
        String _select = "SELECT emp_Id FROM hr_employee_info";
        ArrayList<String> employeesID = new ArrayList<String>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                employeesID.add(_rs.getString("emp_Id"));
            }
            return employeesID;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<EmployeeEntity> readNationality() {
        String _select = "SELECT nationalityID,nationalityDescription FROM hr_lu_nationality";
        ArrayList<EmployeeEntity> nationality = new ArrayList<EmployeeEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                this.code = _rs.getString("nationalityID");
                this.description = _rs.getString("nationalityDescription");
                EmployeeEntity nationalityEntity = new EmployeeEntity(code, description);
                nationality.add(nationalityEntity);
            }
            return nationality;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<EmployeeEntity> readRelationType() {
        String _select = "SELECT Distinct  Relation_Type FROM hr_emp_family";
        ArrayList<EmployeeEntity> relationType = new ArrayList<EmployeeEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                this.code = _rs.getString("Relation_Type");
                this.description = _rs.getString("Relation_Type");
                EmployeeEntity nationalityEntity = new EmployeeEntity(code, description);
                relationType.add(nationalityEntity);
            }

            return relationType;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int saveEmployeeFamily(EmployeeEntity employeeEntity) {

        int checkSave = 0;

        String _select = "INSERT INTO hr_emp_family " +
                "(emp_Id,first_Name,middle_Name,last_Name,Date_Of_Birth,sex,Relation_Type,EMERGENCYCONTACT,job,heir)" +
                " VALUES ('" + employeeEntity.getEmployeeId() + "','" + employeeEntity.getFamily_FirstName() + "','" + employeeEntity.getFamilyMidelName() + "','" +
                employeeEntity.getFamilyLastName() + "','" + employeeEntity.getDateof_Birth() + "','" +
                "" + employeeEntity.get_sex() + "','" + employeeEntity.getRelation_Type() + "','" + employeeEntity.getEmergenceyContact() + "','" + employeeEntity.emergencyJob + "','" + employeeEntity.getHire() + "')";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            checkSave = _ps.executeUpdate();

            return checkSave;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return checkSave;

    }

    public ArrayList<String> selectFamily(String employeeId) {
        String _select = "select * from  hr_emp_family where EMP_ID='" + employeeId + "' ";

        ArrayList<String> familyList = new ArrayList<String>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                familyList.add(_rs.getString("FIRST_NAME"));
                familyList.add(_rs.getString("MIDDLE_NAME"));
                familyList.add(_rs.getString("LAST_NAME"));
                familyList.add(_rs.getString("DATE_OF_BIRTH"));
                familyList.add(_rs.getString("SEX"));
                familyList.add(_rs.getString("RELATION_TYPE"));
                familyList.add(_rs.getString("PHOTO"));
                familyList.add(_rs.getString("HEIR"));
                familyList.add(_rs.getString("JOB"));
                familyList.add(_rs.getString("EMERGENCEY_CONTACT"));
            }

            return familyList;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String updatePersonalInformation(EmployeeEntity saveEntity) {
        String _update = "UPDATE hr_employee_info " +
                "SET emp_Id       =?, " +
                "  title          =?, " +
                "  first_Name     =?, " +
                "  middle_Name    =?, " +
                "  last_Name      =?, " +
                "  sex            =?, " +
                "  Date_Of_Birth  =?, " +
                "  marital_Status =?, " +
                "  nationality    =?, " +
                "  nation_Code    =?, " +
                "  hire_Date      =?, " +
                "  retirement_no  =?, " +
                "  DEPARTMENT_ID  =?, " +
                "  job_Code       =?, " +
                "  rank_Id        =?, " +
                "  pay_Grade      =?, " +
                "  salary         =?, " +
                "  EMPLOYMENTTYPE =?, " +
                "  Office_or_shift=?, " +
                "  RELIGION       =?, " +
                "  PHOTO          =?, " +
                "  TIN_NUMBER     =?, " +
                "  LOCATION     =? " +
                "WHERE emp_Id     =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, saveEntity.getEmpId());
            _ps.setString(2, saveEntity.getTitle());
            _ps.setString(3, saveEntity.getFirst_Name());
            _ps.setString(4, saveEntity.getMiddle_Name());
            _ps.setString(5, saveEntity.getLast_Name());
            _ps.setString(6, saveEntity.getSex());
            _ps.setString(7, saveEntity.getDate_Of_Birth());
            _ps.setString(8, saveEntity.getMarital_Status());
            _ps.setString(9, saveEntity.getNationality());
            _ps.setInt(10, Integer.parseInt(saveEntity.getNation()));
            _ps.setString(11, saveEntity.getHire_Date());
            _ps.setString(12, saveEntity.getRetirement_no());
            _ps.setInt(13, Integer.parseInt(saveEntity.getDepartment_id()));
            _ps.setString(14, saveEntity.getJobDescription());
            _ps.setString(15, saveEntity.getRankid());
            _ps.setString(16, saveEntity.getPayGrade());
            _ps.setString(17, (saveEntity.getSalary()));
            _ps.setString(18, saveEntity.getPermanentOrContract());
            _ps.setString(19, saveEntity.getOfficeOrShift());
            _ps.setString(20, saveEntity.getReligion());
            _ps.setBytes(21, saveEntity.getEmpImage());
            _ps.setString(22, saveEntity.getTinNumber());
            _ps.setString(23, saveEntity.getLocation());
            _ps.setString(24, saveEntity.getEmpId());
            if (_ps.executeUpdate() > 0) {
                return "1";
            } else {
                return "0";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return "0";
    }

    public ResultSet readEmployeeName() throws SQLException {
        String _select = " SELECT emp_Id, " +
                "  first_Name, " +
                "  middle_Name, " +
                "  last_Name " +
                "FROM hr_employee_info " +
                "WHERE emp_id NOT IN " +
                "  (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS " +
                "  ) " +
                "ORDER BY first_Name, " +
                "  middle_Name, " +
                "  last_Name";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * The method removes a row of employee data from the hr_employee_info table
     * in the database based on the given employee id, and checks if the
     * execution is successfull.
     * @param empID the unique employee identifier
     * @return either 1 when the deletion is successfull
     *         or 0 when it fails
     */
    public int deleteEmployeeFamily(String empID) {
        String _deletet = "DELETE FROM HR_EMP_FAMILY WHERE ID=?";
        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setInt(1, Integer.parseInt(empID));
            check = ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int countEmployee() {
        String _deletet = "select count(rownum) as num FROM hr_employee_info";
        int rownum;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            _rs = ps.executeQuery();
            rownum = _rs.getInt("num");

            return rownum;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteEmployeeFromExcelDate(String empID) {
        String _deletet = "DELETE FROM hr_employee WHERE emp_Id=?";
        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, empID);
            check = ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteEmployee(String empID) {
        String _deletet = "DELETE FROM hr_employee_info WHERE emp_Id=?";



        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, empID);
            check = ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }


        return 0;
    }

    public String createNewEmployeeId(String firstLetter, String departmentId) {
        String nextId = "";
        String prefex = "";
        int next = 1;
        String lastId = "";
        String _select;
        if (firstLetter.length() == 0) {
            return null;
        } else if (firstLetter.length() > 1) {
            firstLetter = (String.valueOf(firstLetter.charAt(0))).toUpperCase();
        }
        firstLetter = "MU-" + firstLetter;
        _select = "select max(EMP_ID) as lastEmpId from HR_EMPLOYEE_Info ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();

            if (_rs.next()) {
                lastId = _rs.getString("lastEmpId");
            } else {
                lastId = firstLetter + "-00001";
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        if (lastId != null) {
            String[] _last = lastId.split("-");
            next = Integer.parseInt(_last[1]) + 1;
        }

        if (next < 10) {
            prefex = "0000";
        } else if (next < 100) {//rprev  } else if (next >= 10 && next < 100) {
            prefex = "000";
        } else if (next < 1000) {//prev  } else if (next >= 100) {
            prefex = "00";
        } else if (next < 10000) {//prev  } else if (next >= 1000) {
            prefex = "0";
        } else if (next >= 10000) {
            prefex = "";
        }
        nextId = firstLetter.toUpperCase() + "-" + prefex + Integer.toString(next);
        return nextId;

    }

//    public String creatNewEmployeeIdToBeDeletedAfterAutomation2(String idEnterdByEncoder, String deptId, String middeleName) {
//        int idAdjusted = Integer.parseInt(idEnterdByEncoder.trim());
//        String prefix = "";
//        if (idAdjusted < 10) {
//            prefix = "0000";
//        } else if (idAdjusted < 100) {//rprev  } else if (next >= 10 && next < 100) {
//            prefix = "000";
//        } else if (idAdjusted < 1000) {//prev  } else if (next >= 100) {
//            prefix = "00";
//        } else if (idAdjusted < 10000) {//prev  } else if (next >= 1000) {
//            prefix = "0";
//        } else if (idAdjusted >= 10000) {
//            prefix = "";
//        }
//        String addressCode = (new DepartmentEntity()).getDepartmenttAdressCode(Integer.parseInt(deptId));
//        if (addressCode == null) {
//            addressCode = "AA";
//        }
//        return addressCode + "/" + prefix + Integer.toString(idAdjusted);
//    }
    public String creatNewEmployeeIdToBeDeletedAfterAutomation(String idEnterdByEncoder, String firstName, String middeleName) {
        int idAdjusted = Integer.parseInt(idEnterdByEncoder.trim());
        String prefix = "";
        if (idAdjusted < 10) {
            prefix = "0000";
        } else if (idAdjusted < 100) {//rprev  } else if (next >= 10 && next < 100) {
            prefix = "000";
        } else if (idAdjusted < 1000) {//prev  } else if (next >= 100) {
            prefix = "00";
        } else if (idAdjusted < 10000) {//prev  } else if (next >= 1000) {
            prefix = "0";
        } else if (idAdjusted >= 10000) {
            prefix = "";
        }
        String nameIndex = firstName.substring(0, 1).toUpperCase() + middeleName.substring(0, 1).toUpperCase();
        return nameIndex + "/" + prefix + Integer.toString(idAdjusted);
    }

    /**
     * The method is used to make department changes in the hr_employee_info table.
     * @param department the employee's department
     * @param empId the employee identifier
     * @return either (1) the row count for SQL UPDATE statement
     *         or (2) 0 if the SQL UPDATE statement returns nothing
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int updateEmployeeDepartment(String department, String empId) throws Exception {
        String strEmpMaritalStatus = "UPDATE hr_employee_info set department_id=? " +
                "WHERE emp_Id=?";
        int check;
        PreparedStatement ps = getConnection().prepareStatement(strEmpMaritalStatus);
        ps.setString(1, department);
        ps.setString(2, empId);
        check = ps.executeUpdate();

        return check;
    }

    /**
     * The method is used to make status changes in the hr_employee_info table when
     * employees go through different states.
     * @param department the employee's department
     * @param empId the employee identifier
     * @return either (1) the row count for SQL UPDATE statement
     *         or (2) 0 if the SQL UPDATE statement returns nothing
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int updateEmployeeStatus(String empId, String status) throws Exception {
        String strUpdateEmp = "UPDATE hr_employee_info set emp_Status=? " +
                "WHERE emp_Id=?";
        int check;
        PreparedStatement ps = getConnection().prepareStatement(strUpdateEmp);
        ps.setString(1, status);
        ps.setString(2, empId);
        check = ps.executeUpdate();
        return check;
    }

    public ArrayList<EmployeeEntity> readEmployeeTable() {
        String _select = "SELECT emp_id from hr_employee order by emp_id";
        ArrayList<EmployeeEntity> employee = new ArrayList<EmployeeEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {

                this.code = _rs.getString("emp_id");
                this.description = _rs.getString("emp_id");
                EmployeeEntity employee_Entity = new EmployeeEntity(code, description);
                employee.add(employee_Entity);
            }
            return employee;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countEmpTitle() {
        HashMap[] list = null;
        int rownum;
        String str = "SELECT Max(rownum) as num FROM HR_LU_TITLE ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                rownum = _rs.getInt("num");
                return rownum;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap[] readEmpTitle() {
        HashMap[] list = null;
        int i = 0;
        String str = "SELECT  * FROM  HR_LU_TITLE " +
                " ORDER BY TITLE_ID ";
        try {
            list = new HashMap[this.countEmpTitle()];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("TITLE_ID", _rs.getString("TITLE_ID"));
                list[i].put("TITLE_DESCRIPTION", _rs.getString("TITLE_DESCRIPTION"));
                list[i].put("TYPE", _rs.getString("TYPE"));

                i++;
            }

            return list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String getTitleDes() {
        return titleDes;
    }

    public void setTitleDes(String titleDes) {
        this.titleDes = titleDes;
    }

    public String getTitleType() {
        return titleType;
    }

    public void setTitleType(String titleType) {
        this.titleType = titleType;
    }
    String titleType;
    String titleDes;

    public int addNewTitle(String titleDesc, String titleType) {
        this.setTitleDes(titleDesc);
        this.setTitleType(titleType);

        return this.insertNewTitle();
    }

    private int insertNewTitle() {
        int check;
        String insEvaCrt = "INSERT INTO HR_LU_TITLE (TITLE_DESCRIPTION,TYPE)  VALUES (?, ?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, this.getTitleDes());
            _ps.setString(2, this.getTitleType());
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int deleteEmpTitle(String titleID) {
        String _deletet = "DELETE FROM hr_lu_title WHERE TITLE_ID=?";
        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, titleID);
            check = ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public HashMap readEmployeeBasicInfoFromId(String employeeId) throws SQLException {
        String qry = "SELECT * FROM VW_EMPLOYEE_BY_DEPT_LIST_NEW WHERE EMP_ID='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("EMP_ID"));
                    data.put("employeeFullName", _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    data.put("employeeTitledFullName", _rs.getString("TITLE_DESCRIPTION") + " " + _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    data.put("employeeTitle", _rs.getString("TITLE_DESCRIPTION"));
                    data.put("employeeRank", _rs.getString("RANK_ID") == null ? "" : _rs.getString("RANK_ID"));
                    data.put("employeePosition", _rs.getString("job_name") == null ? "" : _rs.getString("job_name"));
                    data.put("employeePositionName", _rs.getString("JOB_NAME") == null ? "" : _rs.getString("JOB_NAME"));
                    data.put("employeeSalary", _rs.getString("SALARY") == null ? "" : _rs.getString("SALARY"));
                    data.put("employeeJobCode", _rs.getString("JOB_CODE"));
                    data.put("employeeGender", _rs.getString("GENDER"));
                    data.put("employeeDepartment", _rs.getString("DEPARTMENT_ID"));
                    data.put("employeeDepartmentName", _rs.getString("DEPARTMENT_NAME"));
                    data.put("employeeDepartmentPath", _rs.getString("DEPARTMENT_NAME"));
                    data.put("employeeJobLevel", _rs.getString("job_level"));

                } else {
                    data.put("employeeId", "");
                    data.put("employeeFullName", "");
                    data.put("employeeTitledFullName", "");
                    data.put("employeeTitle", "");
                    data.put("employeeRank", "");
                    data.put("employeeGender", "");
                    data.put("employeeJobCode", "");
                    data.put("employeePositionName", "");
                    data.put("employeeSalary", "");
                    data.put("employeePosition", "");
                    data.put("employeeDepartment", "");
                    data.put("employeeDepartmentName", "");
                    data.put("employeeDepartmentName", "");
                    data.put("employeeDepartmentPath", "");
                    data.put("employeeJobLevel", "");
                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap readEmployeeBasicInformation(String employeeId) throws SQLException {
        String qry = "SELECT * FROM VW_EMPLOYEEBASICINFO WHERE EMP_ID='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("EMP_ID"));
                    data.put("employeeFullName", _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    data.put("employeeTitledFullName", _rs.getString("TITLE_DESCRIPTION") + " " + _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    data.put("employeeTitle", _rs.getString("TITLE_DESCRIPTION"));
                    data.put("employeeRank", _rs.getString("RANK_ID") == null ? "" : _rs.getString("RANK_ID"));
                    data.put("employeePosition", _rs.getString("JOB_DESCRIPTION") == null ? "" : _rs.getString("JOB_DESCRIPTION"));
                    data.put("employeeJobCode", _rs.getString("JOB_CODE"));
                    data.put("employeeGender", _rs.getString("GENDER"));
                    data.put("employeeDepartment", _rs.getString("DEPARTMENT_ID"));
                    data.put("employeeDepartmentName", _rs.getString("DEP_DESCRIPTION"));
                    data.put("employeeDepartmentPath", _rs.getString("DEP_DESCRIPTION"));
                    data.put("HIRE_DATE", _rs.getString("HIRE_DATE"));

                } else {
                    data.put("employeeId", "");
                    data.put("employeeFullName", "");
                    data.put("employeeTitledFullName", "");
                    data.put("employeeTitle", "");
                    data.put("employeeRank", "");
                    data.put("employeeGender", "");
                    data.put("employeeJobCode", "");
                    data.put("employeePosition", "");
                    data.put("employeeDepartment", "");
                    data.put("employeeDepartmentName", "");
                    data.put("employeeDepartmentName", "");
                    data.put("employeeDepartmentPath", "");
                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap readEmployeeBasicInfoFrom(String employeeId) throws SQLException {
        String qry = "SELECT * FROM HR_EMPLOYEE_INFO WHERE EMP_ID='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                data = new HashMap();
                data.put("employeeId", _rs.getString("EMP_ID"));
                data.put("employeRank", _rs.getString("RANK_ID") == null ? "" : _rs.getString("RANK_ID"));
                data.put("payGrade", _rs.getString("PAY_GRADE"));
                data.put("EMPSALARY", _rs.getString("SALARY"));
                data.put("DATE_OF_BIRTH", _rs.getString("DATE_OF_BIRTH"));
                return data;

            } else {
                return null;
            }



        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<EmployeeEntity> readAllEmpToBeEvaluated(String empID, String filter) {

        PreparedStatement _ps1 = null;
        ResultSet _rs1 = null;
        String structHolder = "";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());

//        String readEmpOrgStracture = "SELECT  HR_EMPLOYEE_INFO.EMP_ID, " +
//                " HR_EMPLOYEE_INFO.HIRE_DATE, " +
//                " HR_EMPLOYEE_INFO.DIRECTORATE, " +
//                " HR_EMPLOYEE_INFO.DIVISION, " +
//                " HR_EMPLOYEE_INFO.MASTEBABRIYA, " +
//                " HR_EMPLOYEE_INFO.TEAM " +
//                " FROM HR_EMPLOYEE_INFO " +
//                " WHERE " +
//                " HR_EMPLOYEE_INFO.EMP_ID = '" + empID + "'";
        String readEmpOrgStracture = "SELECT  HR_EMPLOYEE_INFO.EMP_ID," +
                "HR_EMPLOYEE_INFO.HIRE_DATE," +
                "hr_employee_info.department_id" +
                " FROM HR_EMPLOYEE_INFO " +
                "WHERE " +
                "HR_EMPLOYEE_INFO.EMP_ID = 'AA/00999'";


//        String readResultPurp = "SELECT  HR_EMPLOYEE_INFO.EMP_ID, " +
//                " HR_EMPLOYEE_INFO.FIRST_NAME, " +
//                " HR_EMPLOYEE_INFO.MIDDLE_NAME, " +
//                " HR_EMPLOYEE_INFO.LAST_NAME, " +
//                " HR_EMPLOYEE_INFO.HIRE_DATE, " +
//                " HR_EMPLOYEE_INFO.DIRECTORATE, " +
//                " HR_EMPLOYEE_INFO.DIVISION, " +
//                " HR_EMPLOYEE_INFO.MASTEBABRIYA, " +
//                " HR_EMPLOYEE_INFO.TEAM " +
//                " FROM HR_EMPLOYEE_INFO " +
//                " WHERE " +
//                " HR_EMPLOYEE_INFO.TEAM = ?" +
//                " OR HR_EMPLOYEE_INFO.MASTEBABRIYA = ?" +
//                " OR HR_EMPLOYEE_INFO.DIVISION = ? " +
//                " OR HR_EMPLOYEE_INFO.DIRECTORATE = ? ";
        String readResultPurp = "SELECT  HR_EMPLOYEE_INFO.EMP_ID," +
                "HR_EMPLOYEE_INFO.FIRST_NAME," +
                "HR_EMPLOYEE_INFO.MIDDLE_NAME," +
                "HR_EMPLOYEE_INFO.LAST_NAME," +
                "HR_EMPLOYEE_INFO.HIRE_DATE," +
                "HR_EMPLOYEE_INFO.department_id " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE " +
                "HR_EMPLOYEE_INFO.department_id=? ";


        ArrayList<EmployeeEntity> resultList = new ArrayList<EmployeeEntity>();
        try {
            _con = getConnection();
            _ps1 = _con.prepareStatement(readEmpOrgStracture);
            _rs = _ps1.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                if (ocrs.getString("department_id") != null) {
                    structHolder = ocrs.getString("department_id");

                }

            }
//            while (ocrs.next()) {
//                if (ocrs.getString("TEAM") != null) {
//                    structHolder = ocrs.getString("TEAM");
//
//                } else if (ocrs.getString("TEAM") == null) {
//                    if (ocrs.getString("MASTEBABRIYA") != null) {
//                        structHolder = ocrs.getString("MASTEBABRIYA");
//
//                    } else if (ocrs.getString("MASTEBABRIYA") == null) {
//                        if (ocrs.getString("DIVISION") != null) {
//                            structHolder = ocrs.getString("DIVISION");
//
//                        } else if (ocrs.getString("DIVISION") == null) {
//                            if (ocrs.getString("DIRECTORATE") != null) {
//                                structHolder = ocrs.getString("DIRECTORATE");
//
//                            }
//                        }
//                    }
//                }
//
//            }
            _ps = _con.prepareStatement(readResultPurp);
            _ps.setString(1, structHolder);
            _rs1 = _ps.executeQuery();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            ocrs1.populate(_rs1);
            _rs1.close();

            while (ocrs1.next()) {
                if (filter.equals("1")) {
                    EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                    resultList.add(resultType);
                } else if (filter.equals("2")) {
                    int dateDiff = StringDateManipulation.compareDateDifference(ocrs1.getString("HIRE_DATE"), currentDate);

                    if ((79 < dateDiff) && (dateDiff < 101)) {
                        EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                        resultList.add(resultType);
                    } else {
                    }

                } else if (filter.equals("3")) {
                    int dateDiff = StringDateManipulation.compareDateDifference(ocrs1.getString("HIRE_DATE"), currentDate);

                    if (dateDiff >= 170 && dateDiff <= 200) {
                        EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                        resultList.add(resultType);
                    } else {
                    }

                } else {
                    EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                    resultList.add(resultType);
                }
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet searchEmployeeNametoAuto(String employeeName) {

       

        String qry = null;
        qry = " SELECT " +
                "  code.TITLE_DESCRIPTION " +
                "    ||' ' || " +
                "  code.fullName fullName, " +
                "  code.EMP_ID, " +
                "  code.PHOTO " +
                " FROM " +
                "  (SELECT " +
                "   TITLE_DESCRIPTION, " +
                "   FIRST_NAME " +
                "    ||' ' " +
                "    || MIDDLE_NAME " +
                "    || ' ' " +
                "    || LAST_NAME AS fullName, " +
                "   EMP_ID, " +
                "   PHOTO " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  INNER JOIN HR_LU_TITLE  " +
                "  ON HR_LU_TITLE.TITLE_ID = HR_EMPLOYEE_INFO.TITLE " +
                "  )code " +
                " WHERE upper(code.fullName) LIKE '" + employeeName + "%' " +
                " AND rownum <=10";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet orcs = new OracleCachedRowSet();
            orcs.populate(_rs);
            return orcs;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet searchEmployeeNameWithOutPhoto(
            String employee_Name) {
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String qry = null;
        qry =
                " SELECT " +
                "  code.TITLE_DESCRIPTION " +
                "    ||' ' || " +
                "  code.fullName fullName, " +
                "  code.EMP_ID " +
                " FROM " +
                "  (SELECT " +
                "   TITLE_DESCRIPTION, " +
                "   FIRST_NAME " +
                "    ||' ' " +
                "    || MIDDLE_NAME " +
                "    || ' ' " +
                "    || LAST_NAME AS fullName, " +
                "    EMP_ID " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  INNER JOIN HR_LU_TITLE  " +
                "  ON HR_LU_TITLE.TITLE_ID = HR_EMPLOYEE_INFO.TITLE " +
                "  )code " +
                " WHERE upper(code.fullName) LIKE '" + employee_Name + "%' " +
                " AND rownum <=10";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();

            return _rs;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<EmployeeEntity> readAllEmpToBeEvaluated(String empID, String filter, String dept_id) {
        PreparedStatement _ps1 = null;
        ResultSet _rs1 = null;
        String currentDate = StringDateManipulation.toDayInEc();


        String readResultPurp = "SELECT  HR_EMPLOYEE_INFO.EMP_ID,HR_EMPLOYEE_INFO.FIRST_NAME,HR_EMPLOYEE_INFO.MIDDLE_NAME,HR_EMPLOYEE_INFO.LAST_NAME,HR_EMPLOYEE_INFO.HIRE_DATE,HR_EMPLOYEE_INFO.DEPARTMENT_ID,HR_EMPLOYEE_INFO.EMP_STATUS   FROM HR_EMPLOYEE_INFO WHERE (HR_EMPLOYEE_INFO.EMP_STATUS = ?  OR HR_EMPLOYEE_INFO.EMP_STATUS = ?)AND  HR_EMPLOYEE_INFO.DEPARTMENT_ID =?";
        ArrayList<EmployeeEntity> resultList = new ArrayList<EmployeeEntity>();
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(readResultPurp);
            _ps.setString(1, "01");
            _ps.setString(2, "02");
            _ps.setString(3, dept_id);
            _rs1 = _ps.executeQuery();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            ocrs1.populate(_rs1);
            _rs1.close();

            while (ocrs1.next()) {
                if (filter.equals("1")) {
                    EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                    resultList.add(resultType);
                } else if (filter.equals("2")) {
                    int dateDiff = StringDateManipulation.compareDateDifference(ocrs1.getString("HIRE_DATE"), currentDate);

                    if ((79 < dateDiff) && (dateDiff < 101)) {
                        EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                        resultList.add(resultType);
                    } else {
                    }

                } else if (filter.equals("3")) {
                    int dateDiff = StringDateManipulation.compareDateDifference(ocrs1.getString("HIRE_DATE"), currentDate);

                    if (dateDiff >= 170 && dateDiff <= 200) {
                        EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                        resultList.add(resultType);
                    } else {
                    }

                } else {
                    EmployeeEntity resultType = new EmployeeEntity(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME") + " ---------> " + ocrs1.getString("EMP_ID"));
                    resultList.add(resultType);
                }
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
    }

    public String readHireDate(String employeeID) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        int i = 0;
        String str = "SELECT  HIRE_DATE FROM  HR_EMPLOYEE_INFO WHERE EMP_ID=? ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, employeeID);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                return _rs.getString("HIRE_DATE");
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String departmentDetileDescription(String departmentId) {
        try {
            String sql = "SELECT sys_connect_by_path( TBL_DEPT_BUNNA.DEP_DESCRIPTION,'[' ) AS DESCRIPTION " +
                    "FROM TBL_DEPT_BUNNA " +
                    "WHERE DEPT_ID                            ='" + departmentId + "' " +
                    "  START WITH TBL_DEPT_BUNNA.DEPT_ID      =1 " +
                    "  CONNECT BY PRIOR TBL_DEPT_BUNNA.DEPT_ID=BRANCH_ID";
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {

                return rs.getString("DESCRIPTION");
            } else {
                return null;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public OracleSerialBlob readEmployeePhoto(String employeeId) {
        try {
            OracleSerialBlob employeeImage;
            String sql = "SELECT PHOTO FROM HR_EMPLOYEE_INFO " +
                    "WHERE EMP_ID                            ='" + employeeId + "' ";

            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            if (ocrs.next()) {
                employeeImage = (OracleSerialBlob) ocrs.getBlob("PHOTO");
                return employeeImage;
            } else {
                return null;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int employeLevel(String employeeId) throws SQLException {

        String stm = "SELECT * " +
                "FROM hr_employee_info, " +
                "  hr_lu_job_type " +
                "WHERE hr_employee_info.emp_id  ='" + employeeId + "' " +
                "AND hr_lu_job_type.job_code    =hr_employee_info.job_code " +
                "AND ( hr_lu_job_type.job_level ='TM' " +
                "OR hr_lu_job_type.job_level    ='DR' " +
                "OR hr_lu_job_type.job_level    ='CE' " +
                "OR hr_lu_job_type.job_level    ='PR')";


        try {
            Connection conn = getConnection();
            PreparedStatement ps = conn.prepareStatement(stm);
            ResultSet rs = ps.executeQuery();

            if (rs != null) {

                if (rs.next()) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } finally {
            releaseResources();
        }
        return 0;

    }

    public String employeeFullName(String employeeId) {
        {
            String _select = "SELECT FIRST_NAME " +
                    "  || ' ' " +
                    "  || MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || LAST_NAME AS FULLNAME " +
                    "FROM HR_EMPLOYEE_INFO " +
                    "WHERE EMP_ID=?";
            try {
                _con = getConnection();
                _ps = _con.prepareStatement(_select);
                _ps.setString(1, employeeId);
                _rs = _ps.executeQuery();
                if (_rs.next()) {
                    return _rs.getString("FULLNAME");
                } else {
                    return "not found";
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return "";
            } finally {
                try {
                    releaseResources();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

            }
        }


    }

    public String employeeWorkingPlace(String departmentId) {
        String _select = "SELECT DEPT_NAME FROM TBL_DEPARTMENT WHERE DEPT_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, departmentId);
            _rs = _ps.executeQuery();

            if (_rs.next()) {
                String departmentName = _rs.getString("DEPT_NAME");
                int index = departmentName.indexOf("(");
                int lastIndex = departmentName.lastIndexOf(")");
                // lastIndex -= 1;
                if (index > 0) {
                    return departmentName.substring(index + 1, lastIndex).trim();
                } else {
                    return "";
                }
            } else {
                return "";
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return "";
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        }
    }

    public String employeeDepartmentPath(String employeeId) {
        String _select = "SELECT DEPARTMENT_PATH" +
                "   FROM VW_EMPLOYEE_BY_DEPARTMENT_BK " +
                " WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();

            if (_rs.next()) {
                return _rs.getString("DEPARTMENT_PATH");
            } else {
                return "";
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return "";
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet selectDocument(
            String documentId) {
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String qry = null;

        qry =
                "SELECT * FROM hr_emp_file WHERE ID ='" + documentId + "'";
        try {

            _con = getConnection();
            _ps =
                    _con.prepareCall(qry);
            _rs =
                    _ps.executeQuery();

            return _rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
