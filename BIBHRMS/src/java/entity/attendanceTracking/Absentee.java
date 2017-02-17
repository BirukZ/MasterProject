/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceTracking;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Preferred Customer
 */
public class Absentee extends ConnectionManager{

    
    
    private String attendanceId;
    private String empId;
    private String status;
    private String statusName;
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
    /**
     * The default Absentee constructor without parameter
     */
    public Absentee() {
    }


    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param absenceId the absentee's employee id
     * @param empId the reporters employee id
     * @param status the status of the attendance
     */
    public Absentee(String attendanceId, String empId, String status, String statusN) {
        this.attendanceId = attendanceId;
        this.empId = empId;
        this.status = status;
        this.statusName = statusN;
    }

    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param absenceId the absentee's employee id
     * @param empId the reporters employee id
     * @param status the status of the attendance
     */
    public Absentee(String attendanceId, String empId, String status) {
        this.attendanceId = attendanceId;
        this.empId = empId;
        this.status = status;
    }

    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param empId the reporters employee id
     * @param status the status of the attendance
     */
    public Absentee(String empId, String status) {
        this.empId = empId;
        this.status = status;
    }

    /**
     * The method inserts absentees into the hr_absence table in the database.
     * @return either (1) the row count for SQL INSERT statement
     *         or (2) 0 if the SQL INSERT statement returns nothing
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int insertAbsentees() throws Exception {
        _con = getConnection();

        String str = "INSERT INTO HR_ABSENCE (ABSENCE_ID,EMP_ID, ATTENDANCE_ID, " +
                " STATUS) values(SEQ_HR_ABSENCE.NEXTVAL, ?, ?, ?)";
        _ps = _con.prepareStatement(str);
        _ps.setString(1, getEmpId());
        _ps.setString(2, getAttendanceId());
        _ps.setString(3, getStatus());

        return _ps.executeUpdate();
    }



    /**
     * The method removes a row of data, absentee employees, from the hr_absence
     * table based on the attendance identifier
     * @param attendanceId the unique attendance record identifier
     * @return either true or false, based on the value of the executeUpdate method
     */
    public boolean DeleteAbsentees(String attendanceId) throws Exception {
        _con = getConnection();

        String str = "DELETE FROM hr_absence WHERE attendance_Id = ?";
        try {
           _ps = _con.prepareStatement(str);
            _ps.setString(1, attendanceId);

            if (_ps.executeUpdate() != 1) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    /**
     * Fetches absentee employees from the hr_absence table in the database
     * with the specified attendance id
     * @param attendanceId the unique attendance record identifier
     * @return a <code>ResultSet</code> object rs with absentee record
     */
    public ResultSet readAbsentee(String val) throws Exception {
        _con = getConnection();
        Statement st = null;
        
        try {
            st = (Statement) _con.createStatement();
            st.executeQuery("SELECT * FROM HR_ABSENCE WHERE EMP_ID = '" + val + "'");
            _rs =  st.getResultSet();

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
        return _rs;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the attendanceId
     */
    public String getAttendanceId() {
        return attendanceId;
    }

    /**
     * @param attendanceId the attendanceId to set
     */
    public void setAttendanceId(String attendanceId) {
        this.attendanceId = attendanceId;
    }

    /**
     * @return the statusName
     */
    public String getStatusName() {
        return statusName;
    }

    /**
     * @param statusName the statusName to set
     */
    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
}
