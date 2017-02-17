/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceTracking;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author DPClone
 */
public class AttendanceEntity extends ConnectionManager{

    
    
    private String deptId;
    private String absenceEmpId;
    private String abStatus;
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Statement st = null;

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
    public String getAbsenceEmpId() {
        return absenceEmpId;
    }

    public void setAbsenceEmpId(String absenceEmpId) {
        this.absenceEmpId = absenceEmpId;
    }

    public String getDeptId() {
        return deptId;
    }

    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    public String getAbStatus() {
        return abStatus;
    }

    public void setAbStatus(String abStatus) {
        this.abStatus = abStatus;
    }

    public AttendanceEntity() {
    }

    public AttendanceEntity(String absenceEmpId) {
        this.absenceEmpId = absenceEmpId;
    }

    public AttendanceEntity(String absenceEmpId, String abStatus) {
        this.absenceEmpId = absenceEmpId;
        this.abStatus = abStatus;
    }

    /**
     * The method fetches all the data of all employees from the hr_employee_info table
     * @return a <code>ResultSet</code> object rs with the data of the employee
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readEmployee() throws Exception {
       
        _con = getConnection();
        
        
        String sql = "SELECT *FROM hr_employee_info WHERE DEPARTMENT_ID ='" + getDeptId() + "'";
        st = _con.createStatement();
        st.executeQuery(sql);
        _rs =  st.getResultSet();

        return _rs;
    }

    /**
     * The method fetches all the data of all employees from the hr_employee_info table
     * @return a <code>ResultSet</code> object rs with the data of the employee
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readEmployee(String value) throws Exception {
        
        _con = getConnection();
        
        
        String sql = "SELECT *FROM hr_employee_info WHERE EMP_ID ='" + value + "'";
        st = _con.createStatement();
        st.executeQuery(sql);
        _rs =  st.getResultSet();

        return _rs;
    }

    public int deleteAbsentee(AttendanceEntity aThis) {
        String str = "DELETE FROM HR_ABSENCE WHERE EMP_ID='" + aThis.getAbsenceEmpId() + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            return _ps.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public int updateAbsentees(AttendanceEntity aThis) throws Exception {
        _con = getConnection();
        String str = "UPDATE HR_ABSENCE SET STATUS='" + aThis.abStatus + "' WHERE EMP_ID='" + aThis.absenceEmpId + "'";
        _ps = _con.prepareStatement(str);
        return _ps.executeUpdate();
    }

    public int updateAttendance(String attendanceId,String attendanceDescription) throws Exception {
        _con = getConnection();
        String str = "UPDATE HR_ATTENDANCE SET ABSENTEE_DESCRIPTION='" + attendanceDescription + "' WHERE ATTENDANCE_ID='" + attendanceId + "'";
        _ps = _con.prepareStatement(str);
        return _ps.executeUpdate();
    }
}
