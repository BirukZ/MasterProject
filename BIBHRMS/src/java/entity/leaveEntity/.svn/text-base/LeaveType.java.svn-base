/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.leaveEntity;

/**
 *
 * @author ONEJAVA
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class LeaveType extends ConnectionManager {

    private String leave_Type_Code;
    private String description;
    private String min_Num_Of_Days;
    private String max_Num_Of_Days;

    /**
     *
     */
    public LeaveType() {
    }
    Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            _con.close();
        }
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

        ResultSet rs = null;
        PreparedStatement ps = null;
        ArrayList<LeaveType> leaveList = new ArrayList<LeaveType>();
        String select = "SELECT * FROM hr_lu_leave_type";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            _rs = ps.executeQuery();
            ocrs.populate(_rs);
            _rs.close();
            ps.close();
            while (ocrs.next()) {
                LeaveType leaveType = new LeaveType(ocrs.getString("leave_Type_Code"),
                        ocrs.getString("description"), ocrs.getString("min_Num_Of_Days"),
                        ocrs.getString("max_Num_Of_Days"));
                leaveList.add(leaveType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return leaveList;
    }

    public HashMap readParametersOfLeaveType(String LeaveId) {

        String str = "SELECT NVL(LEAVE_TYPE_CODE,'N/A') LEAVE_TYPE_CODE, " +
                "  NVL(DESCRIPTION,'N/A') DESCRIPTION, " +
                "  NVL(MIN_NUM_OF_DAYS,'N/A') MIN_NUM_OF_DAYS, " +
                "  NVL(MAX_NUM_OF_DAYS,'N/A') MAX_NUM_OF_DAYS " +
                "FROM HR_LU_LEAVE_TYPE " +
                "WHERE LEAVE_TYPE_CODE=?";
        HashMap hm = new HashMap();
        try {
            Connection con = getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement(str);
            ps.setString(1, LeaveId);
            rs = ps.executeQuery();
            while (rs.next()) {
                hm.put("leave_Type_Code", rs.getString("leave_Type_Code"));
                hm.put("description", rs.getString("description"));
                hm.put("min_Num_Of_Days", rs.getString("min_Num_Of_Days"));
                hm.put("max_Num_Of_Days", rs.getString("max_Num_Of_Days"));
            }
            return hm;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

    }
}

