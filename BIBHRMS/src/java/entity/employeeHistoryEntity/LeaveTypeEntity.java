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
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class LeaveTypeEntity extends ConnectionManager {

    private String leave_Type_Code;
    private String description;
    private String minimumDays;
    private String maximumDays;
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    private int leaveTypeId;
    private String leaveTypeName;
    private String leaveType;
    private String forGender;
    private String forEmploymentType;
    private String remark;

    public String getForEmploymentType() {
        return forEmploymentType;
    }

    public void setForEmploymentType(String forEmploymentType) {
        this.forEmploymentType = forEmploymentType;
    }

    public String getForGender() {
        return forGender;
    }

    public void setForGender(String forGender) {
        this.forGender = forGender;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public int getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(int leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getLeaveTypeName() {
        return leaveTypeName;
    }

    public void setLeaveTypeName(String leaveTypeName) {
        this.leaveTypeName = leaveTypeName;
    }

    public String getMaximumDays() {
        return maximumDays;
    }

    public void setMaximumDays(String maximumDays) {
        this.maximumDays = maximumDays;
    }

    public String getMinimumDays() {
        return minimumDays;
    }

    public void setMinimumDays(String minimumDays) {
        this.minimumDays = minimumDays;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LeaveTypeEntity(int leaveTypeId,
            String leaveTypeName,
            String leaveType,
            String minimumDays,
            String maximumDays,
            String forGender,
            String forEmploymentType,
            String remark) {
        this.leaveTypeId = leaveTypeId;
        this.leaveTypeName = leaveTypeName;
        this.leaveType = leaveType;
        this.minimumDays = minimumDays;
        this.maximumDays = maximumDays;
        this.forGender = forGender;
        this.forEmploymentType = forEmploymentType;
        this.remark = remark;
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

    /**
     *
     */
    public LeaveTypeEntity() {
    }

    /**
     *
     * @param leave_Type_Code
     * @param description
     * @param min_Num_Of_Days
     * @param max_Num_Of_Days
     */
    public LeaveTypeEntity(String leave_Type_Code, String description, String min_Num_Of_Days, String max_Num_Of_Days) {
        this.leave_Type_Code = leave_Type_Code;
        this.description = description;
        this.minimumDays = min_Num_Of_Days;
        this.maximumDays = max_Num_Of_Days;
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
        return minimumDays;
    }

    /**
     * @param min_Num_Of_Days the min_Num_Of_Days to set
     */
    public void setMin_Num_Of_Days(String min_Num_Of_Days) {
        this.minimumDays = min_Num_Of_Days;
    }

    /**
     * @return the max_Num_Of_Days
     */
    public String getMax_Num_Of_Days() {
        return maximumDays;
    }

    /**
     * @param max_Num_Of_Days the max_Num_Of_Days to set
     */
    public void setMax_Num_Of_Days(String max_Num_Of_Days) {
        this.maximumDays = max_Num_Of_Days;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     * The method fetches all leave types and arranges the result into an <code>ArrayList</code>
     * of type <code>LeaveType</code>
     * @param data Vector object
     * @return an <code>ArrayList</code> of type <code>LeaveType</code>
     */
    public ArrayList<LeaveTypeEntity> readAllLeaveTypes() {
        ArrayList<LeaveTypeEntity> leaveList = new ArrayList<LeaveTypeEntity>();
        String str = "SELECT * FROM hr_lu_leave_type";
        try {
            _ps = getConnection().prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LeaveTypeEntity leaveType = new LeaveTypeEntity(_rs.getString("leave_Type_Code"),
                        _rs.getString("description"), _rs.getString("min_Num_Of_Days"),
                        _rs.getString("max_Num_Of_Days"));
                leaveList.add(leaveType);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return leaveList;
    }

    /**
     * The method fetches all leave types and arranges the result into an <code>ArrayList</code>
     * of type <code>LeaveType</code>
     * @param data Vector object
     * @return an <code>ArrayList</code> of type <code>LeaveType</code>
     */
    public ArrayList<HashMap> readAllLeaveTypes(String gender, String forPostion) {
        ArrayList<HashMap> leaveList = new ArrayList<HashMap>();

        String str = "SELECT * " +
                "FROM HR_LU_LEAVE_TYPE " +
                "WHERE (GENDER         =? " +
                "OR GENDER             ='Both') " +
                "AND( FOREMPLOYMENTTYPE=? " +
                "OR FOREMPLOYMENTTYPE  ='Both')";

        try {
            _ps = getConnection().prepareStatement(str);
            _ps.setString(1, gender);
            _ps.setString(2, forPostion);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("leaveTypeId", _rs.getString("LEAVE_TYPE_CODE") + "=" +//LEAVE_TYPE_CODE
                        _rs.getString("max_Num_Of_Days") + "="
                        + _rs.getString("description") );
                hm.put("leaveTypeName", _rs.getString("description"));
                leaveList.add(hm);
            }
            return leaveList;
        } catch (SQLException e) {
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

    public OracleCachedRowSet leaveTypeInformation() {
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        String qry = "SELECT LEAVE_TYPE_CODE, " +
                "  DESCRIPTION, " +
                "  MIN_NUM_OF_DAYS, " +
                "  MAX_NUM_OF_DAYS, " +
                "  NVL(GENDER,'Not Register') GENDER, " +
                "  NVL(FOREMPLOYMENTTYPE,'Not Register') FOREMPLOYMENTTYPE, " +
                "  NVL(LEAVE_TYPE,'Not Register') LEAVE_TYPE, " +
                "  NVL(REMARK,'Not Remarked') REMARK " +
                " FROM HR_LU_LEAVE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int add() throws Exception {
        int transactionStatus = 0;
        if (this.addLeaveType(this) == 1) {
            transactionStatus = 1;
        }
        return transactionStatus;
    }

    private int addLeaveType(LeaveTypeEntity leaveType) throws SQLException {
        _con = getConnection();
        String str = "INSERT INTO HR_LU_LEAVE_TYPE " +
                "  ( " +
                "    DESCRIPTION, " +
                "    MIN_NUM_OF_DAYS, " +
                "    MAX_NUM_OF_DAYS, " +
                "    GENDER, " +
                "    FOREMPLOYMENTTYPE, " +
                "    LEAVE_TYPE, " +
                "    REMARK " +
                "  ) " +
                "  VALUES " +
                "  ( ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        try {
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, leaveType.getLeaveTypeName());
            ps.setString(2, leaveType.getMinimumDays());
            ps.setString(3, leaveType.getMaximumDays());
            ps.setString(4, leaveType.getForGender());
            ps.setString(5, leaveType.getForEmploymentType());
            ps.setString(6, leaveType.getLeaveType());
            ps.setString(7, leaveType.getRemark());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int update() throws Exception {
        int transactionStatus = 0;
        if (this.updateLeaveType(this) == 1) {
            transactionStatus = 1;
        }
        return transactionStatus;
    }

    private int updateLeaveType(LeaveTypeEntity leaveType) throws Exception {
        _con = getConnection();
        String str = "UPDATE HR_LU_LEAVE_TYPE " +
                "SET DESCRIPTION     = ?, " +
                "  MIN_NUM_OF_DAYS   = ?, " +
                "  MAX_NUM_OF_DAYS   = ?, " +
                "  GENDER            = ?, " +
                "  FOREMPLOYMENTTYPE = ?, " +
                "  LEAVE_TYPE        = ?, " +
                "  REMARK            = ? " +
                "WHERE LEAVE_TYPE_CODE =?";
        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, leaveType.getLeaveTypeName());
        ps.setString(2, leaveType.getMinimumDays());
        ps.setString(3, leaveType.getMaximumDays());
        ps.setString(4, leaveType.getForGender());
        ps.setString(5, leaveType.getForEmploymentType());
        ps.setString(6, leaveType.getLeaveType());
        ps.setString(7, leaveType.getRemark());
        ps.setInt(8, leaveType.getLeaveTypeId());
        return ps.executeUpdate();
    }

    public boolean delete(int leaveTypeId) throws SQLException {
        return this.deleteLeaveType(leaveTypeId);
    }

    private boolean deleteLeaveType(int leaveTypeId) throws SQLException {
        boolean deleted = false;
        _con = getConnection();

        String str = "DELETE " +
                " FROM HR_LU_LEAVE_TYPE " +
                " WHERE LEAVE_TYPE_CODE = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setInt(1, leaveTypeId);

        if (ps.executeUpdate() >= 1) {
            deleted = true;
        }
        return deleted;
    }

    public String readLeaveTypeDesc(String leaveTypdId) {
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            String str = "SELECT DESCRIPTION " +
                    " FROM HR_LU_LEAVE_TYPE " +
                    " WHERE LEAVE_TYPE_CODE = '" + leaveTypdId + "'";
            _con = getConnection();
            ps = _con.prepareStatement(str);
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
}

