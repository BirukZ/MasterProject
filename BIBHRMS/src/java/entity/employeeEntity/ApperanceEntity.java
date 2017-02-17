/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class ApperanceEntity extends ConnectionManager {
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
    public ApperanceEntity() {
    }
    String empId;

    public ApperanceEntity(String empId, String height, String Chest, String blood_Group, String eye_Color, String face_Color, String weight, byte[] finger_print) {
        this.empId = empId;
        this.height = height;
        this.Chest = Chest;
        this.blood_Group = blood_Group;
        this.eye_Color = eye_Color;
        this.face_Color = face_Color;
        this.weight = weight;
        this.finger_print = finger_print;
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

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
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

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getPhotobinary() {
        return photobinary;
    }

    public void setPhotobinary(String photobinary) {
        this.photobinary = photobinary;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
    String height;
    String Chest;
    String blood_Group;
    String eye_Color;
    String face_Color;
    String weight;
    byte[] finger_print;

    public byte[] getFinger_print() {
        return finger_print;
    }

    public void setFinger_print(byte[] finger_print) {
        this.finger_print = finger_print;
    }
    String photobinary;
    FileInputStream in;

    public int saveEmployeeApperance(ApperanceEntity employeeEntity) {


        String _select = "INSERT INTO hr_emp_appearance" +
                "(emp_Id,HEIGHT,WEIGHT,BLOOD_GROUP,EYE_COLOR)" +
                " VALUES (?,?,?,?,?)";

        int check;
        
        
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeEntity.getEmpId());
            _ps.setString(2, employeeEntity.getHeight());
            _ps.setString(3, employeeEntity.getWeight());
            _ps.setString(4, employeeEntity.getBlood_Group());
            _ps.setString(5, employeeEntity.getEye_Color());

            check = _ps.executeUpdate();
            
            return check;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }
         finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return 0;
    }

    public int updateEmployeeApperance(ApperanceEntity employeeEntity) {


        String _select = "update  hr_emp_appearance set " +
                " HEIGHT=?,WEIGHT=?,BLOOD_GROUP=?,EYE_COLOR=? where emp_Id=?" +
                " ";
        int check;
        
        
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeEntity.getEmpId());
            _ps.setString(2, employeeEntity.getHeight());
            _ps.setString(3, employeeEntity.getWeight());
            _ps.setString(4, employeeEntity.getBlood_Group());
            _ps.setString(5, employeeEntity.getEye_Color());

            check = _ps.executeUpdate();
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return 0;
    }

    public int deleteEmployeeApperance(String empID) {
        String _deletet = "DELETE FROM hr_emp_appearance WHERE emp_Id=?";
        
        
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
         finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return 0;

    }

    public HashMap readEmployeeApperance(String employeeId) {

        String _select = "SELECT * From  hr_emp_appearance where EMP_ID=? ";

        
        
        
        HashMap empApperance = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                empApperance.put("emp_Id", _rs.getString("emp_Id"));
                empApperance.put("HEIGHT", _rs.getString("HEIGHT"));
                empApperance.put("WEIGHT", _rs.getString("WEIGHT"));
                empApperance.put("BLOOD_GROUP", _rs.getString("BLOOD_GROUP"));
                empApperance.put("EYE_COLOR", _rs.getString("EYE_COLOR"));
                empApperance.put("CHEST", _rs.getString("CHEST"));
                empApperance.put("FINGER_PRINT", _rs.getBlob("FINGER_PRINT"));
                return empApperance;
            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();

            return null;
        }
         finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return null;


    }
}
