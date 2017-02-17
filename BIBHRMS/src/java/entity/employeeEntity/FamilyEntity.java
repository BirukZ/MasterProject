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
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class FamilyEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

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

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public FamilyEntity() {
    }
    String hire;

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

    public int getEmergencyJob() {
        return emergencyJob;
    }

    public void setEmergencyJob(int emergencyJob) {
        this.emergencyJob = emergencyJob;
    }

    public String getEmergency_Contact() {
        return emergency_Contact;
    }

    public void setEmergency_Contact(String emergency_Contact) {
        this.emergency_Contact = emergency_Contact;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getHire() {
        return hire;
    }

    public void setHire(String hire) {
        this.hire = hire;
    }

    public String getRelation_Type() {
        return relation_Type;
    }

    public void setRelation_Type(String relation_Type) {
        this.relation_Type = relation_Type;
    }
    String familyId;
    String dateof_Birth;
    String emergency_Contact;
    String _sex;
    String relation_Type;
    String family_FirstName;
    String familyMidelName;
    String familyLastName;
    String aliveOrDied;
    String employeeId;
    int emergencyJob;
    byte[] phtoPath;

    public byte[] getPhtoPath() {
        return phtoPath;
    }

    public Connection get_con() {
        return _con;
    }

    public String getFamilyId() {
        return familyId;
    }

    public void setFamilyId(String familyId) {
        this.familyId = familyId;
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

    public String getAliveOrDied() {
        return aliveOrDied;
    }

    public void setAliveOrDied(String aliveOrDied) {
        this.aliveOrDied = aliveOrDied;
    }

    public FileInputStream getIn() {
        return in;
    }

    public void setIn(FileInputStream in) {
        this.in = in;
    }

    public void setPhtoPath(byte[] phtoPath) {
        this.phtoPath = phtoPath;
    }
    public int size;

    public int getSize() {
        return size;
    }

//    public int countEmployeeFamily(String empID) {
//        String count = "SELECT Max(rownum)as num  from hr_emp_family WHERE emp_Id=?";
//        int rownum = 0;
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(count);
//            _ps.setString(1, empID);
//            _rs = _ps.executeQuery();
//            if (_rs.next()) {
//                rownum = _rs.getInt("num");
//            }
//
//            return rownum;
//        } catch (Exception ex) {
//        } finally {
//            try {
//                releaseResources();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//
//        return 0;
//    }

//    public void setSize(int size) {
//        this.size = size;
//    }
//    public void setSize(String empID) {
//        String count = "SELECT Max(rownum)as num  from hr_emp_family WHERE emp_Id=?";
//        int number = 0;
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(count);
//            _ps.setString(1, empID);
//            _rs = _ps.executeQuery();
//            if (_rs.next()) {
//                number = _rs.getInt("num");
//            }
//
//        } catch (Exception ex) {
//        } finally {
//            try {
//                releaseResources();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//
//        this.size = number;
//    }
    public void setSize(int size) {
    }
    FileInputStream in;

    public int saveEmployeeFamily(FamilyEntity employeeEntity) {
        int checkSav = 0;

        String _select = "INSERT INTO hr_emp_family " +
                "(emp_Id," +
                "first_Name," +
                "middle_Name," +
                "last_Name," +
                "Date_Of_Birth," +
                "sex," +
                "Relation_Type," +
                "EMERGENCEY_CONTACT," +
                "alive_or_died," +
                "HEIR," +
                "PHONENO)" +
                " VALUES(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, this.getEmployeeId());
            _ps.setString(2, employeeEntity.getFamily_FirstName());
            _ps.setString(3, employeeEntity.getFamilyMidelName());
            _ps.setString(4, employeeEntity.getFamilyLastName());
            _ps.setString(5, employeeEntity.getDateof_Birth());
            _ps.setString(6, employeeEntity.get_sex());
            _ps.setString(7, employeeEntity.getRelation_Type());
            _ps.setString(8, employeeEntity.getEmergency_Contact());
            _ps.setString(9, employeeEntity.getAliveOrDied());
            _ps.setString(10, employeeEntity.getHire());
            _ps.setString(11, employeeEntity.getPhoneNo());
            checkSav = _ps.executeUpdate();
            return checkSav;
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
        return 0;
    }

    public int updateEmployeeFamily(FamilyEntity employeeEntity, String fam_ID) {
        int check;
        String _select = "UPDATE hr_emp_family SET " +
                //" emp_Id=?,first_Name=?,middle_Name=?,last_Name=?,Date_Of_Birth=?,sex=?," +
                " first_Name=?,middle_Name=?,last_Name=?,Date_Of_Birth=?,sex=?," +
                // "Relation_Type=?,EMERGENCEY_CONTACT=?,heir=?,PHOTO=?, alive_or_died=? where ID=?";
                "Relation_Type=?,EMERGENCEY_CONTACT=?,heir=?, alive_or_died=?, PHONENO=? where ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
//          //  _ps.setString(1, this.getEmployeeId());
//            _ps.setString(2, employeeEntity.getFamily_FirstName());
//            _ps.setString(3, employeeEntity.getFamilyMidelName());
//            _ps.setString(4, employeeEntity.getFamilyLastName());
//            _ps.setString(5, employeeEntity.getDateof_Birth());
//            _ps.setString(6, employeeEntity.get_sex());
//            _ps.setString(7, employeeEntity.getRelation_Type());
//            _ps.setString(8, employeeEntity.getEmergency_Contact());
//            _ps.setString(9, employeeEntity.getHire());
            //  _ps.setString(1, this.getEmployeeId());
            _ps.setString(1, employeeEntity.getFamily_FirstName());
            _ps.setString(2, employeeEntity.getFamilyMidelName());
            _ps.setString(3, employeeEntity.getFamilyLastName());
            _ps.setString(4, employeeEntity.getDateof_Birth());
            _ps.setString(5, employeeEntity.get_sex());
            _ps.setString(6, employeeEntity.getRelation_Type());
            _ps.setString(7, employeeEntity.getEmergency_Contact());
            _ps.setString(8, employeeEntity.getHire());
            //    _ps.setBytes(10, employeeEntity.getPhtoPath());
            _ps.setString(9, employeeEntity.getAliveOrDied());
            _ps.setString(10, employeeEntity.getPhoneNo());
            _ps.setInt(11, Integer.parseInt(employeeEntity.getFamilyId()));
            check = _ps.executeUpdate();
            return check;
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
        return 0;

    }
    /*
    (String hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type,
    String family_FirstName, String familyMidelName,String familyLastName,
    String aliveOrDied, String id, int avilbleOnDbFamily) {
     */

    public FamilyEntity(String hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type,
            String family_FirstName, String familyMidelName, String familyLastName,
            String aliveOrDied) {
        this.hire = hire;
        this.dateof_Birth = dateof_Birth;
        this.emergency_Contact = emergency_Contact;
        this._sex = _sex;
        this.relation_Type = relation_Type;
        this.family_FirstName = family_FirstName;
        this.familyMidelName = familyMidelName;
        this.familyLastName = familyLastName;
        this.aliveOrDied = aliveOrDied;
    }
String phoneNo;
    public FamilyEntity(String familyId, String hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type,
            String family_FirstName, String familyMidelName, String familyLastName,
            String aliveOrDied) {
        this(hire, dateof_Birth, emergency_Contact, _sex, relation_Type,
                family_FirstName, familyMidelName, familyLastName,
                aliveOrDied);
        this.familyId = familyId;
    }

    public FamilyEntity(String hire, String dateof_Birth, String emergency_Contact, String _sex,String phoneNo, String relation_Type,
            String family_FirstName, String familyMidelName, String familyLastName,
            String aliveOrDied, String familyId, String xxxxx) {
        this(hire, dateof_Birth, emergency_Contact, _sex, relation_Type,
                family_FirstName, familyMidelName, familyLastName,
                aliveOrDied);
        this.phoneNo=phoneNo;
        this.familyId = familyId;
    }

    public FamilyEntity(String hire, String dateof_Birth, String emergency_Contact, String _sex, String relation_Type, String family_FirstName, String familyMidelName, String familyLastName, byte[] phtoPaht, int emergencyJob) {
        this.hire = hire;
        this.dateof_Birth = dateof_Birth;
        this.emergency_Contact = emergency_Contact;
        this._sex = _sex;
        this.relation_Type = relation_Type;
        this.family_FirstName = family_FirstName;
        this.familyMidelName = familyMidelName;
        this.familyLastName = familyLastName;
        this.phtoPath = phtoPaht;
        this.emergencyJob = emergencyJob;
    }

    public ResultSet readEmployeeFamily(String empID) throws SQLException
    {

        String select = "SELECT DISTINCT * " +
                " FROM hr_emp_family " +
                " WHERE emp_id=? " +
                " ORDER BY RELATION_TYPE, " +
                "  FIRST_NAME";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readFamily(String empID) throws SQLException {

        String select = "SELECT DISTINCT * " +
                "FROM hr_emp_family " +
                "WHERE emp_id      ='" + empID + "' " +
                "AND (ALIVE_OR_DIED='YES' " +
                "OR ALIVE_OR_DIED  ='Alive') " +
                "ORDER BY RELATION_TYPE, " +
                "  FIRST_NAME";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
//            _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readFamilyForLeave(String empID) throws SQLException {

        String select = "SELECT FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME, " +
                "  DATE_OF_BIRTH, " +
                "  SEX, " +
                "  EMP_ID, " +
                "  RELATION_TYPE, " +
                "  ID, " +
                "  HEIR, " +
                "  EMERGENCEY_CONTACT, " +
                "  ALIVE_OR_DIED " +
                " FROM VIEW_EMPLOYEE_FAMILY " +
                "WHERE emp_id='"+empID+"'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
   public ResultSet readEmployeeRelativeForLeave(String empID) throws SQLException {

        String select = "SELECT FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME, " +
                "  DATE_OF_BIRTH, " +
                "  SEX, " +
                "  EMP_ID, " +
                "  RELATION_TYPE, " +
                "  ID, " +
                "  HEIR, " +
                "  EMERGENCEY_CONTACT, " +
                "  ALIVE_OR_DIED " +
                "FROM VIEW_EMPLOYEE_RELATIVE " +
                "WHERE emp_id='"+empID+"'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }


    public int countNumberOfFamily(String employeeId) {
        String select = "SELECT count(*) FROM hr_emp_family WHERE EMP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, employeeId);
            _ps.executeQuery();
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int checkFamilyID(int familyID) {
        String select = "SELECT count(emp_Id) FROM hr_emp_family WHERE ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, familyID);
            _ps.executeQuery();
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
}
