/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class LeaveType extends ConnectionManager{


    private String leave_Type_Code;
    private String description;
    private String min_Num_Of_Days;
    private String max_Num_Of_Days;
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
     *
     */
    public LeaveType() {
    }

    /**
     *
     * @param leave_Type_Code
     * @param description
     * @param min_Num_Of_Days
     * @param max_Num_Of_Days
     */
    public LeaveType(String leave_Type_Code, String description, String min_Num_Of_Days, String max_Num_Of_Days) {
        this.leave_Type_Code = leave_Type_Code;
        this.description = description;
        this.min_Num_Of_Days = min_Num_Of_Days;
        this.max_Num_Of_Days = max_Num_Of_Days;
    }

    /**
     * @return the leave_Type_Code
     */
    public String getLeave_Type_Code() {
        return leave_Type_Code;
    }

    /**
     * @param leave_Type_Code the leave_Type_Code to set
     */
    public void setLeave_Type_Code(String leave_Type_Code) {
        this.leave_Type_Code = leave_Type_Code;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the min_Num_Of_Days
     */
    public String getMin_Num_Of_Days() {
        return min_Num_Of_Days;
    }

    /**
     * @param min_Num_Of_Days the min_Num_Of_Days to set
     */
    public void setMin_Num_Of_Days(String min_Num_Of_Days) {
        this.min_Num_Of_Days = min_Num_Of_Days;
    }

    /**
     * @return the max_Num_Of_Days
     */
    public String getMax_Num_Of_Days() {
        return max_Num_Of_Days;
    }

    /**
     * @param max_Num_Of_Days the max_Num_Of_Days to set
     */
    public void setMax_Num_Of_Days(String max_Num_Of_Days) {
        this.max_Num_Of_Days = max_Num_Of_Days;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The method fetches all leave types and arranges the result into an <code>ArrayList</code>
     * of type <code>LeaveType</code>
     * @param data Vector object
     * @return an <code>ArrayList</code> of type <code>LeaveType</code>
     */
    public ArrayList<LeaveType> readAllLeaveTypes() {
       

        ArrayList<LeaveType> leaveList = new ArrayList<LeaveType>();
        String str = "SELECT * FROM hr_lu_leave_type";
        try {
            _ps = getConnection().prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LeaveType leaveType = new LeaveType(_rs.getString("leave_Type_Code"),
                        _rs.getString("description"), _rs.getString("min_Num_Of_Days"),
                        _rs.getString("max_Num_Of_Days"));
                leaveList.add(leaveType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return leaveList;
    }
}
