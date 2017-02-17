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
import oracle.jdbc.rowset.OracleCachedRowSet;


/**
 * The class represents the leave process
 * @author Administrator
 */
public class LeaveEntity extends ConnectionManager{

    
    private int leave_Id = 0;
    private String employeeID;
    private String leaveType;
    private String physicalYear;
    private String requestDateFrom;
    private String requestDateTo;
    private String requestingReason;
    private String requestDate;
    private String region;
    private String zoneOrCity;
    private String woredaOrSubCity;
    private String kebelle;
    private String phoneNumberResident;
    private String phoneNumberMobile;
    private String leaveDy;
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
    public LeaveEntity() {
    }

    /**
     * This constructor is used to creates an instance of this class, Leave
     * @param leave_Id the leave record identifier
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param region the region the employee will spent his/her leave
     * @param zoneOrCity the zone the employee will spent his/her leave
     * @param woredaOrSubCity the woreda or sub city  the employee will spent his/her leave
     * @param kebelle the kebelle the employee will spent his/her leave
     * @param phoneNumberResident  the phone number the employee will spent his/her leave
     * @param phoneNumberMobile the mobile number  the employee will spent his/her leave
     * @param leaveDy the total leave days
     */
    public LeaveEntity(int leave_Id, String employeeID, String leaveType, String physicalYear, String requestDateFrom, String requestDateTo, String requestingReason, String requestDate, String region, String zoneOrCity, String woredaOrSubCity, String kebelle, String phoneNumberResident, String phoneNumberMobile, String leaveDy) {
        this.leave_Id = leave_Id;
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.physicalYear = physicalYear;
        this.requestDateFrom = requestDateFrom;
        this.requestDateTo = requestDateTo;
        this.requestingReason = requestingReason;
        this.requestDate = requestDate;
        this.region = region;
        this.zoneOrCity = zoneOrCity;
        this.woredaOrSubCity = woredaOrSubCity;
        this.kebelle = kebelle;
        this.phoneNumberResident = phoneNumberResident;
        this.phoneNumberMobile = phoneNumberMobile;
        this.leaveDy = leaveDy;
    }

    /**
     * This constructor is used to creates an instance of this class, Leave
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param region the region the employee will spent his/her leave
     * @param zoneOrCity the zone the employee will spent his/her leave
     * @param woredaOrSubCity the woreda or sub city  the employee will spent his/her leave
     * @param kebelle the kebelle the employee will spent his/her leave
     * @param phoneNumberResident  the phone number the employee will spent his/her leave
     * @param phoneNumberMobile the mobile number  the employee will spent his/her leave
     * @param leaveDy the total leave days
     */
    public LeaveEntity(String employeeID, String leaveType, String physicalYear, String requestDateFrom, String requestDateTo, String requestingReason, String requestDate, String region, String zoneOrCity, String woredaOrSubCity, String kebelle, String phoneNumberResident, String phoneNumberMobile, String leaveDy) {
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.physicalYear = physicalYear;
        this.requestDateFrom = requestDateFrom;
        this.requestDateTo = requestDateTo;
        this.requestingReason = requestingReason;
        this.requestDate = requestDate;
        this.region = region;
        this.zoneOrCity = zoneOrCity;
        this.woredaOrSubCity = woredaOrSubCity;
        this.kebelle = kebelle;
        this.phoneNumberResident = phoneNumberResident;
        this.phoneNumberMobile = phoneNumberMobile;
        this.leaveDy = leaveDy;
    }

    /**
     * This constructor is used to creates an instance of this class, Leave
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param leaveDy the total leave days
     */
    public LeaveEntity(String employeeID, String leaveType, String physicalYear, String requestDateFrom, String requestDateTo, String requestingReason, String requestDate, String leaveDy) {
        this.employeeID = employeeID;
        this.leaveType = leaveType;
        this.physicalYear = physicalYear;
        this.requestDateFrom = requestDateFrom;
        this.requestDateTo = requestDateTo;
        this.requestingReason = requestingReason;
        this.requestDate = requestDate;
        this.leaveDy = leaveDy;
    }

    /**
     * Reads leave request records of an employee
     * @param employeeID the employee identifier
     * @return leave, the result of the <b>LeaveEntity</b> object of the select statement
     */
    public LeaveEntity readLeaveOnlyRequested(String employeeID) {
        
        LeaveEntity leave = null;

        String str = "SELECT * FROM hr_leavee WHERE emp_Id=? AND action_Taken='No'";

        try {
             _ps = getConnection().prepareStatement(str);
            _ps.setString(1, employeeID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                leave = new LeaveEntity(_rs.getInt("LEAVE_ID"), _rs.getString("EMP_ID"),
                        _rs.getString("LEAVE_TYPE"), _rs.getString("REQUESTED_PHYSICAL_YEAR"), _rs.getString("REQUESTED_FROM_DATE"),
                        _rs.getString("REQUESTED_TO_DATE"), _rs.getString("REQUESTING_REASON"), _rs.getString("REQUESTED_DATE"),
                        _rs.getString("LEAVE_TIME_ADDRESS_REGION"), _rs.getString("LEAVE_TIME_ADDRESS_ZONE_OR_CI"), _rs.getString("LEAVE_TIME_ADDRESS_WOREDA_OR_"),
                        _rs.getString("LEAVE_TIME_ADDRESS_KEBELLE"), _rs.getString("LEAVE_TIME_ADDRESS_PHONE_NUMB"),
                        _rs.getString("LEAVE_TIME_ADDRESS_PHONE00000"), _rs.getString("LEAVE_DAYS"));
            }
            return leave;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
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
     * Reads leave records of an employee with the given employee id
     * @param employeeID the employee identifier
     * @param forWhat the action, request or approve
     * @return rs, the <b>ResultSet</b> of one of the select statements
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public ArrayList<HashMap> readLeave(String employeeID, String forWhat) {
       
        String str = null;
        if (forWhat.equalsIgnoreCase("all")) {
            str = "SELECT ALL hr_employee_info.first_Name, " +
                    "hr_employee_info.middle_Name,  " +
                    "hr_employee_info.last_Name,   " +
                    "hr_leavee.leave_Id, hr_leavee.emp_Id,  " +
                    "hr_leavee.leave_Type,  " +
                    "(SELECT HR_LU_LEAVE_TYPE.DESCRIPTION FROM HR_LU_LEAVE_TYPE WHERE HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE = hr_leavee.leave_Type) as leveTypeDesc, " +
                    "hr_leavee.requested_Physical_Year,  " +
                    "hr_leavee.requested_From_Date,  " +
                    "hr_leavee.requested_To_Date,  " +
                    "hr_leavee.requesting_Reason,  " +
                    "hr_leavee.requested_Date,  " +
                    "hr_leavee.approved_Physical_Year,  " +
                    "hr_leavee.approved_From_Date,  " +
                    "hr_leavee.approved_To_Date,  " +
                    "hr_leavee.approved_By,  " +
                    "hr_leavee.approval_Date,  " +
                    "hr_leavee.granted_Physical_Year,  " +
                    "hr_leavee.granted_Frome_Date,  " +
                    "hr_leavee.granted_To_Date,  " +
                    "hr_leavee.granted_By,  " +
                    "hr_leavee.granted_Date,  " +
                    "hr_leavee.actual_Leave_Frome_Date,  " +
                    "hr_leavee.actual_Leave_To_Date,  " +
                    "hr_leavee.action_Taken,  " +
                    "hr_leavee.leave_Days, " +
                    "hr_leavee.status " +
                    "FROM hr_employee_info, hr_leavee  " +
                    "WHERE hr_employee_info.emp_Id = hr_leavee.emp_Id  " +
                    "AND hr_leavee.emp_Id = ?";
        } else if (forWhat.equalsIgnoreCase("Approve") || forWhat.equalsIgnoreCase("Request")) {
            str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, " +
                    "hr_employee_info.`last_Name`,  hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, " +
                    "hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, " +
                    "hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, " +
                    "hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`, " +
                    "hr_leavee.`approved_Physical_Year`, hr_leavee.`approved_From_Date`, " +
                    "hr_leavee.`approved_To_Date`, hr_leavee.`approved_By`, " +
                    "hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, " +
                    "hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, " +
                    "hr_leavee.`granted_By`, hr_leavee.`granted_Date`, " +
                    "hr_leavee.`actual_Leave_Frome_Date`, " +
                    "hr_leavee.`actual_Leave_To_Date`, " +
                    "hr_leavee.`leave_Time_Address_Region`, " +
                    "hr_leavee.`leave_Time_Address_Zone_Or_City`, " +
                    "hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, " +
                    "hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`" +
                    "leave_Time_Address_Phone_Number_Resident`, hr_leavee.`" +
                    "leave_Time_Address_Phone_Number_Mobile`, hr_leavee.`action_Taken` , " +
                    "hr_leavee.`leave_Days` FROM hr_employee_info, hr_leavee " +
                    "WHERE hr_leavee.`action_Taken`='No' " +
                    "AND hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` " +
                    "AND hr_leavee.`emp_Id` =?";
        } else if (forWhat.equalsIgnoreCase("Grant")) {
            str = "SELECT ALL hr_employee_info.`first_Name`," +
                    " hr_employee_info.`middle_Name`, hr_leavee.`leave_Id`," +
                    " hr_leavee.`emp_Id`, hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, " +
                    "hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, " +
                    "hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`," +
                    " hr_leavee.`approved_Physical_Year`," +
                    " hr_leavee.`approved_From_Date`, hr_leavee.`approved_To_Date`," +
                    " hr_leavee.`approved_By`, hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, " +
                    "hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, hr_leavee.`granted_By`," +
                    " hr_leavee.`granted_Date`, hr_leavee.`actual_Leave_Frome_Date`, " +
                    "hr_leavee.`actual_Leave_To_Date`, hr_leavee.`leave_Time_Address_Region`, " +
                    "hr_leavee.`leave_Time_Address_Zone_Or_City`, " +
                    "hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`," +
                    " hr_leavee.`leave_Time_Address_Kebelle`," +
                    " hr_leavee.`leave_Time_Address_Phone_Number_Resident`, " +
                    "hr_leavee.`leave_Time_Address_Phone_Number_Mobile`," +
                    " hr_leavee.`action_Taken` , hr_leavee.`leave_Days` " +
                    "  FROM hr_employee_info, hr_leavee " +
                    "WHERE hr_leavee.`action_Taken`='Approved' OR `action_Taken`='With Modification' AND" +
                    " hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` AND hr_leavee.STATUS =?";
        } else if (forWhat.equalsIgnoreCase("Actual")) {
            str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`, hr_leavee.`approved_Physical_Year`, hr_leavee.`approved_From_Date`, hr_leavee.`approved_To_Date`, hr_leavee.`approved_By`, hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, hr_leavee.`granted_By`, hr_leavee.`granted_Date`, hr_leavee.`actual_Leave_Frome_Date`, hr_leavee.`actual_Leave_To_Date`, hr_leavee.`leave_Time_Address_Region`, hr_leavee.`leave_Time_Address_Zone_Or_City`, hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`leave_Time_Address_Phone_Number_Resident`, hr_leavee.`leave_Time_Address_Phone_Number_Mobile`, hr_leavee.`action_Taken` , hr_leavee.`leave_Days`  FROM hr_employee_info, hr_leavee WHERE hr_leavee.`action_Taken`='Granted' AND hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` AND hr_leavee.`emp_Id` =?";
        } else if (forWhat.equalsIgnoreCase("Select")) {
            str = "SELECT ALL hr_employee_info.first_Name, " +
                    "hr_employee_info.middle_Name, " +
                    " hr_employee_info.last_Name,  hr_leavee.leave_Id, hr_leavee.emp_Id,  " +
                    " hr_leavee.leave_Type,  " +
                    "(SELECT HR_LU_LEAVE_TYPE.DESCRIPTION FROM HR_LU_LEAVE_TYPE WHERE HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE = hr_leavee.leave_Type) as leveTypeDesc, " +
                    " hr_leavee.requested_Physical_Year," +
                    " hr_leavee.requested_From_Date," +
                    " hr_leavee.requested_To_Date," +
                    " hr_leavee.requesting_Reason, " +
                    " hr_leavee.requested_Date, " +
                    " hr_leavee.approved_Physical_Year," +
                    " hr_leavee.approved_From_Date, " +
                    " hr_leavee.approved_To_Date," +
                    " hr_leavee.approved_By," +
                    " hr_leavee.approval_Date," +
                    " hr_leavee.granted_Physical_Year," +
                    " hr_leavee.granted_Frome_Date," +
                    " hr_leavee.granted_By," +
                    " hr_leavee.granted_Date," +
                    " hr_leavee.actual_Leave_Frome_Date," +
                    " hr_leavee.actual_Leave_To_Date, " +
                    " hr_leavee.action_Taken," +
                    " hr_leavee.leave_Days" +
                    " FROM hr_employee_info, hr_leavee" +
                    " WHERE hr_employee_info.emp_Id = hr_leavee.emp_Id  and hr_leavee.action_taken='No'";

        } else if (forWhat.equalsIgnoreCase("head")) {
            str = "  SELECT ALL hr_employee_info.first_Name, " +
                    "hr_employee_info.middle_Name,  " +
                    "hr_employee_info.last_Name,   " +
                    "hr_leavee.leave_Id, hr_leavee.emp_Id,  " +
                    "hr_leavee.leave_Type,  " +
                    "(SELECT HR_LU_LEAVE_TYPE.DESCRIPTION FROM HR_LU_LEAVE_TYPE WHERE HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE = hr_leavee.leave_Type) as leveTypeDesc, " +
                    "hr_leavee.requested_Physical_Year,  " +
                    "hr_leavee.requested_From_Date,  " +
                    "hr_leavee.requested_To_Date,  " +
                    "hr_leavee.requesting_Reason,  " +
                    "hr_leavee.requested_Date,  " +
                    "hr_leavee.approved_Physical_Year,  " +
                    "hr_leavee.approved_From_Date,  " +
                    "hr_leavee.approved_To_Date,  " +
                    "hr_leavee.approved_By,  " +
                    "hr_leavee.approval_Date,  " +
                    "hr_leavee.granted_Physical_Year,  " +
                    "hr_leavee.granted_Frome_Date,  " +
                    "hr_leavee.granted_To_Date,  " +
                    "hr_leavee.granted_By,  " +
                    "hr_leavee.granted_Date,  " +
                    "hr_leavee.actual_Leave_Frome_Date,  " +
                    "hr_leavee.actual_Leave_To_Date,  " +
                    "hr_leavee.action_Taken,  " +
                    "hr_leavee.leave_Days ," +
                    "hr_leavee.status," +
                    " hr_leavee.immediatebosscomment," +
                    "hr_leavee.immediatebossid," +
                    "hr_leavee.IMMCOMMENTDATE" +
                    " FROM hr_employee_info, hr_leavee " +
                    " WHERE   hr_employee_info.emp_Id=hr_leavee.emp_Id and hr_leavee.status=?";
        }
        try {
            _ps = getConnection().prepareStatement(str);
            if (!forWhat.equalsIgnoreCase("Select")) {
                _ps.setString(1, employeeID);
            }

            _rs = _ps.executeQuery();
            ArrayList<HashMap> leaveRecords = new ArrayList<HashMap>();
            while (_rs.next()) {
               
                HashMap data = new HashMap();
                data.put("lid", String.valueOf(_rs.getString("leave_Id")));
                data.put("leaveType", _rs.getString("leave_Type"));
                data.put("leaveTypeDesc", _rs.getString("leveTypeDesc"));
                data.put("reason", _rs.getString("requesting_Reason"));
                data.put("from", _rs.getString("requested_From_Date"));
                data.put("to", _rs.getString("requested_To_Date"));
                data.put("request_date", _rs.getString("requested_Date"));
                data.put("fiscalYr", _rs.getString("requested_Physical_Year"));
                data.put("totalDays", _rs.getString("leave_Days"));

                leaveRecords.add(data);
            }
            return leaveRecords;
        } catch (SQLException ex) {
          
            return null;

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
     * Reads the leave days an employee has from the hr_leavee
     * table of the database
     * @param empId the employee identifier
     * @return a <b>ResultSet</b> object rs.
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet readLeaveDays(String empId) throws SQLException {

       

        String str = "SELECT * FROM HR_LU_LEAVE where EMPLOYEE_ID=? ";
       _ps = getConnection().prepareStatement(str);
        _ps.setString(1, empId);
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs=new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet)ocrs;
    }

    /**
     * Inserts the this leave instance into the hr_leavee table of the database.
     * Uses the getter methods to access the data of the object
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public int insertLeave() throws SQLException {
        String str = "INSERT INTO hr_leavee (LEAVE_ID, emp_Id, leave_Type, " +
                "requested_Physical_Year, " +
                "requested_From_Date, requested_To_Date, " +
                "requesting_Reason, requested_Date, " +
                "leave_Days,STATUS) " +
                "values(SEQ_LEAVE.NEXTVAL,?,?,?,?,?,?,?,?,'1')";

        _ps = getConnection().prepareStatement(str);
        _ps.setString(1, getEmployeeID());
        _ps.setString(2, getLeaveType());
        _ps.setString(3, getPhysicalYear());
        _ps.setString(4, getRequestDateFrom());
        _ps.setString(5, getRequestDateTo());
        _ps.setString(6, getRequestingReason());
        _ps.setString(7, getRequestDate());
        _ps.setString(8, getLeaveDy());

        return _ps.executeUpdate();
    }

    public int insertImmediateBossComment(String comment, String empID, String date, int leaveID) {
        String str = "UPDATE hr_leavee set IMMEDIATEBOSSCOMMENT=?,IMMEDIATEBOSSID=?,IMMEDIATEBOSSGIVECOMMENTDATE=?,STATUS=2 where LEAVE_ID=?";
        try {
            _ps = getConnection().prepareStatement(str);
            _ps.setString(1, comment);
            _ps.setString(2, empID);
            _ps.setString(3, date);
            _ps.setInt(4, leaveID);
            return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
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

    /**
     * Reads leave records from the hr_leavee table based on leave id and reason
     * @param leaveId
     * @param forWhat
     * @return rs, the <b>ResultSet</b> of one of the select statements
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public ArrayList<HashMap> readLeaveWithId(int leaveId, String forWhat) {
       
        String str = null;
        // String str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`, hr_leavee.`approved_Physical_Year`, hr_leavee.`approved_From_Date`, hr_leavee.`approved_To_Date`, hr_leavee.`approved_By`, hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, hr_leavee.`granted_By`, hr_leavee.`granted_Date`, hr_leavee.`actual_Leave_Frome_Date`, hr_leavee.`actual_Leave_To_Date`, hr_leavee.`leave_Time_Address_Region`, hr_leavee.`leave_Time_Address_Zone_Or_City`, hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`leave_Time_Address_Phone_Number_Resident`, hr_leavee.`leave_Time_Address_Phone_Number_Mobile`, hr_leavee.`action_Taken`  FROM hr_employee_info, hr_leavee WHERE hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` AND hr_leavee.`emp_Id` =?";
        if (forWhat.equalsIgnoreCase("all")) {
            str = "SELECT ALL hr_employee_info.first_Name, " +
                    "hr_employee_info.middle_Name,  " +
                    "hr_employee_info.last_Name,   " +
                    "hr_leavee.leave_Id, hr_leavee.emp_Id,  " +
                    "hr_leavee.leave_Type,  " +
                    "hr_leavee.requested_Physical_Year,  " +
                    "hr_leavee.requested_From_Date,  " +
                    "hr_leavee.requested_To_Date,  " +
                    "hr_leavee.requesting_Reason,  " +
                    "hr_leavee.requested_Date,  " +
                    "hr_leavee.approved_Physical_Year,  " +
                    "hr_leavee.approved_From_Date,  " +
                    "hr_leavee.approved_To_Date,  " +
                    "hr_leavee.approved_By,  " +
                    "hr_leavee.approval_Date,  " +
                    "hr_leavee.granted_Physical_Year,  " +
                    "hr_leavee.granted_Frome_Date,  " +
                    "hr_leavee.granted_To_Date,  " +
                    "hr_leavee.granted_By,  " +
                    "hr_leavee.granted_Date,  " +
                    "hr_leavee.actual_Leave_Frome_Date,  " +
                    "hr_leavee.actual_Leave_To_Date,  " +
                    "hr_leavee.action_Taken,  " +
                    "hr_leavee.leave_Days  " +
                    "FROM hr_employee_info, hr_leavee  " +
                    "WHERE hr_employee_info.emp_Id = hr_leavee.emp_Id  " +
                    "AND hr_leavee.leave_Id =?";
        } else if (forWhat.equalsIgnoreCase("Approve") || forWhat.equalsIgnoreCase("Request")) {
            str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, " +
                    "hr_employee_info.`last_Name`,  hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, " +
                    "hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, " +
                    "hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, " +
                    "hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`, " +
                    "hr_leavee.`approved_Physical_Year`, hr_leavee.`approved_From_Date`, " +
                    "hr_leavee.`approved_To_Date`, hr_leavee.`approved_By`, " +
                    "hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, " +
                    "hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, " +
                    "hr_leavee.`granted_By`, hr_leavee.`granted_Date`, " +
                    "hr_leavee.`actual_Leave_Frome_Date`, " +
                    "hr_leavee.`actual_Leave_To_Date`, " +
                    //                    "hr_leavee.`leave_Time_Address_Region`, " +
                    //                    "hr_leavee.`leave_Time_Address_Zone_Or_City`, " +
                    //                    "hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, " +
                    //                    "hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`" +
                    //                    "leave_Time_Address_Phone_Number_Resident`, hr_leavee.`" +
                    //                    "leave_Time_Address_Phone_Number_Mobile`, " +
                    "hr_leavee.`action_Taken` , " +
                    "hr_leavee.`leave_Days` FROM hr_employee_info, hr_leavee " +
                    "WHERE hr_leavee.`action_Taken`='No' " +
                    "AND hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` " +
                    "AND hr_leavee.`leave_Id` =?";

        } else if (forWhat.equalsIgnoreCase("Grant")) {
            str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, " +
                    "hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, hr_leavee.`leave_Type`, " +
                    "hr_leavee.`requested_Physical_Year`, hr_leavee.`requested_From_Date`, " +
                    "hr_leavee.`requested_To_Date`, hr_leavee.`requesting_Reason`, " +
                    "hr_leavee.`requested_Date`, hr_leavee.`approved_Physical_Year`, " +
                    "hr_leavee.`approved_From_Date`, hr_leavee.`approved_To_Date`, " +
                    "hr_leavee.`approved_By`, hr_leavee.`approval_Date`, " +
                    "hr_leavee.`granted_Physical_Year`, hr_leavee.`granted_Frome_Date`, " +
                    "hr_leavee.`granted_To_Date`, hr_leavee.`granted_By`, " +
                    "hr_leavee.`granted_Date`, hr_leavee.`actual_Leave_Frome_Date`, " +
                    "hr_leavee.`actual_Leave_To_Date`, hr_leavee.`leave_Time_Address_Region`, " +
                    "hr_leavee.`leave_Time_Address_Zone_Or_City`, hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`leave_Time_Address_Phone_Number_Resident`, hr_leavee.`leave_Time_Address_Phone_Number_Mobile`, hr_leavee.`action_Taken` , hr_leavee.`leave_Days`   FROM hr_employee_info, hr_leavee WHERE hr_leavee.`action_Taken`='Approved' OR `action_Taken`='With Modification' AND hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` AND hr_leavee.`leave_Id` =?";
        } else if (forWhat.equalsIgnoreCase("Actual")) {
            str = "SELECT ALL hr_employee_info.`first_Name`, hr_employee_info.`middle_Name`, hr_leavee.`leave_Id`, hr_leavee.`emp_Id`, hr_leavee.`leave_Type`, hr_leavee.`requested_Physical_Year`, hr_leavee.`requested_From_Date`, hr_leavee.`requested_To_Date`, hr_leavee.`requesting_Reason`, hr_leavee.`requested_Date`, hr_leavee.`approved_Physical_Year`, hr_leavee.`approved_From_Date`, hr_leavee.`approved_To_Date`, hr_leavee.`approved_By`, hr_leavee.`approval_Date`, hr_leavee.`granted_Physical_Year`, hr_leavee.`granted_Frome_Date`, hr_leavee.`granted_To_Date`, hr_leavee.`granted_By`, hr_leavee.`granted_Date`, hr_leavee.`actual_Leave_Frome_Date`, hr_leavee.`actual_Leave_To_Date`, hr_leavee.`leave_Time_Address_Region`, hr_leavee.`leave_Time_Address_Zone_Or_City`, hr_leavee.`leave_Time_Address_Woreda_Or_Sub_City`, hr_leavee.`leave_Time_Address_Kebelle`, hr_leavee.`leave_Time_Address_Phone_Number_Resident`, hr_leavee.`leave_Time_Address_Phone_Number_Mobile`, hr_leavee.`action_Taken` , hr_leavee.`leave_Days`  FROM hr_employee_info, hr_leavee WHERE hr_leavee.`action_Taken`='Granted' AND hr_employee_info.`emp_Id`=hr_leavee.`emp_Id` AND hr_leavee.`leave_Id` =?";
        } else if (forWhat.equalsIgnoreCase("head")) {
            str = "SELECT ALL hr_employee_info.first_Name," +
                    "hr_employee_info.middle_Name, " +
                    "hr_employee_info.last_Name," +
                    "hr_leavee.leave_Id, hr_leavee.emp_Id," +
                    "hr_leavee.leave_Type,(SELECT HR_LU_LEAVE_TYPE.DESCRIPTION FROM HR_LU_LEAVE_TYPE WHERE HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE = hr_leavee.leave_Type) as leveTypeDesc, " +
                    "hr_leavee.requested_Physical_Year," +
                    "hr_leavee.requested_From_Date," +
                    "hr_leavee.requested_To_Date," +
                    "hr_leavee.requesting_Reason," +
                    "hr_leavee.requested_Date," +
                    "hr_leavee.approved_Physical_Year," +
                    "hr_leavee.approved_From_Date," +
                    "hr_leavee.approved_To_Date," +
                    "hr_leavee.approved_By," +
                    "hr_leavee.approval_Date," +
                    "hr_leavee.granted_Physical_Year," +
                    "hr_leavee.granted_Frome_Date," +
                    "hr_leavee.granted_To_Date,hr_leavee.granted_By,  " +
                    "hr_leavee.granted_Date," +
                    "hr_leavee.actual_Leave_Frome_Date," +
                    "hr_leavee.actual_Leave_To_Date,  " +
                    "hr_leavee.action_Taken, " +
                    "hr_leavee.leave_Days ," +
                    "hr_leavee.status," +
                    "hr_leavee.immediatebosscomment,hr_leavee.immediatebossid," +
                    "hr_leavee.IMMCOMMENTDATE" +
                    "FROM hr_employee_info, hr_leavee " +
                    "WHERE   hr_employee_info.emp_Id=hr_leavee.emp_Id and hr_leavee.status=?";
        } else if (forWhat.equalsIgnoreCase("headlink")) {
            str = "SELECT ALL hr_employee_info.first_Name," +
                    "hr_employee_info.middle_Name, " +
                    "hr_employee_info.last_Name," +
                    "hr_leavee.leave_Id, hr_leavee.emp_Id," +
                    "hr_leavee.leave_Type,(SELECT HR_LU_LEAVE_TYPE.DESCRIPTION FROM HR_LU_LEAVE_TYPE WHERE HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE = hr_leavee.leave_Type) as leveTypeDesc, " +
                    "hr_leavee.requested_Physical_Year," +
                    "hr_leavee.requested_From_Date," +
                    "hr_leavee.requested_To_Date," +
                    "hr_leavee.requesting_Reason," +
                    "hr_leavee.requested_Date," +
                    "hr_leavee.approved_Physical_Year," +
                    "hr_leavee.approved_From_Date," +
                    "hr_leavee.approved_To_Date," +
                    "hr_leavee.approved_By," +
                    "hr_leavee.approval_Date," +
                    "hr_leavee.granted_Physical_Year," +
                    "hr_leavee.granted_Frome_Date," +
                    "hr_leavee.granted_To_Date,hr_leavee.granted_By,  " +
                    "hr_leavee.granted_Date," +
                    "hr_leavee.actual_Leave_Frome_Date," +
                    "hr_leavee.actual_Leave_To_Date,  " +
                    "hr_leavee.action_Taken, " +
                    "hr_leavee.leave_Days ," +
                    "hr_leavee.status," +
                    "hr_leavee.immediatebossid," +
                    "hr_leavee.immediatebosscomment," +
                    "hr_leavee.IMMCOMMENTDATE " +
                    "FROM hr_employee_info, hr_leavee  " +
                    "WHERE   hr_employee_info.emp_Id=hr_leavee.emp_Id and hr_leavee.leave_Id =?";
        }
        try {

            _ps = getConnection().prepareStatement(str);
            _ps.setInt(1, leaveId);
            _rs = _ps.executeQuery();
            ArrayList<HashMap> leaveRecords = new ArrayList<HashMap>();
            while (_rs.next()) {
                HashMap data = new HashMap();
                data.put("lid", String.valueOf(_rs.getString("leave_Id")));
                data.put("leaveType", _rs.getString("leave_Type"));
                data.put("totalDays", _rs.getString("leave_Days"));
                data.put("reason", _rs.getString("requesting_Reason"));
                data.put("from", _rs.getString("requested_From_Date"));
                data.put("to", _rs.getString("requested_To_Date"));
                data.put("request_date", _rs.getString("requested_Date"));
                data.put("fiscalYr", _rs.getString("requested_Physical_Year"));
                data.put("emp_Id", _rs.getString("emp_Id"));
                data.put("status", _rs.getString("status"));
                if (forWhat.equalsIgnoreCase("headlink")) {
                    data.put("immedBosscom", _rs.getString("immediatebosscomment"));
                    data.put("immediatebossid", _rs.getString("immediatebossid"));
                    data.put("forwaredDate", _rs.getString("IMMCOMMENTDATE"));

                }


                leaveRecords.add(data);
            }
            return leaveRecords;
        } catch (SQLException ex) {
          

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

    /**
     *updates hr_leave table of the current leave record
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public int updateLeave() throws SQLException {
        String str = "UPDATE hr_leavee set leave_Type=?, requested_Physical_Year=? ," +
                "requested_From_Date=?, requested_To_Date=?, requesting_Reason=?, " +
                "requested_Date=? WHERE leave_Id=?";

        _ps = getConnection().prepareStatement(str);

        _ps.setString(1, getLeaveType());
        _ps.setString(2, getPhysicalYear());
        _ps.setString(3, getRequestDateFrom());
        _ps.setString(4, getRequestDateTo());
        _ps.setString(5, getRequestingReason());
        _ps.setString(6, getRequestDate());
        _ps.setInt(7, getLeave_Id());

        return _ps.executeUpdate();
    }

    /**
     * @return the leave_Id
     */
    public int getLeave_Id() {
        return leave_Id;
    }

    /**
     * @param leave_Id the leave_Id to set
     */
    public void setLeave_Id(int leave_Id) {
        this.leave_Id = leave_Id;
    }

    /**
     * @return the employeeID
     */
    public String getEmployeeID() {
        return employeeID;
    }

    /**
     * @param employeeID the employeeID to set
     */
    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    /**
     * @return the leaveType
     */
    public String getLeaveType() {
        return leaveType;
    }

    /**
     * @param leaveType the leaveType to set
     */
    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    /**
     * @return the physicalYear
     */
    public String getPhysicalYear() {
        return physicalYear;
    }

    /**
     * @param physicalYear the physicalYear to set
     */
    public void setPhysicalYear(String physicalYear) {
        this.physicalYear = physicalYear;
    }

    /**
     * @return the requestDateFrom
     */
    public String getRequestDateFrom() {
        return requestDateFrom;
    }

    /**
     * @param requestDateFrom the requestDateFrom to set
     */
    public void setRequestDateFrom(String requestDateFrom) {
        this.requestDateFrom = requestDateFrom;
    }

    /**
     * @return the requestDateTo
     */
    public String getRequestDateTo() {
        return requestDateTo;
    }

    /**
     * @param requestDateTo the requestDateTo to set
     */
    public void setRequestDateTo(String requestDateTo) {
        this.requestDateTo = requestDateTo;
    }

    /**
     * @return the requestingReason
     */
    public String getRequestingReason() {
        return requestingReason;
    }

    /**
     * @param requestingReason the requestingReason to set
     */
    public void setRequestingReason(String requestingReason) {
        this.requestingReason = requestingReason;
    }

    /**
     * @return the requestDate
     */
    public String getRequestDate() {
        return requestDate;
    }

    /**
     * @param requestDate the requestDate to set
     */
    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    /**
     * @return the region
     */
    public String getRegion() {
        return region;
    }

    /**
     * @param region the region to set
     */
    public void setRegion(String region) {
        this.region = region;
    }

    /**
     * @return the zoneOrCity
     */
    public String getZoneOrCity() {
        return zoneOrCity;
    }

    /**
     * @param zoneOrCity the zoneOrCity to set
     */
    public void setZoneOrCity(String zoneOrCity) {
        this.zoneOrCity = zoneOrCity;
    }

    /**
     * @return the woredaOrSubCity
     */
    public String getWoredaOrSubCity() {
        return woredaOrSubCity;
    }

    /**
     * @param woredaOrSubCity the woredaOrSubCity to set
     */
    public void setWoredaOrSubCity(String woredaOrSubCity) {
        this.woredaOrSubCity = woredaOrSubCity;
    }

    /**
     * @return the kebelle
     */
    public String getKebelle() {
        return kebelle;
    }

    /**
     * @param kebelle the kebelle to set
     */
    public void setKebelle(String kebelle) {
        this.kebelle = kebelle;
    }

    /**
     * @return the phoneNumberResident
     */
    public String getPhoneNumberResident() {
        return phoneNumberResident;
    }

    /**
     * @param phoneNumberResident the phoneNumberResident to set
     */
    public void setPhoneNumberResident(String phoneNumberResident) {
        this.phoneNumberResident = phoneNumberResident;
    }

    /**
     * @return the phoneNumberMobile
     */
    public String getPhoneNumberMobile() {
        return phoneNumberMobile;
    }

    /**
     * @param phoneNumberMobile the phoneNumberMobile to set
     */
    public void setPhoneNumberMobile(String phoneNumberMobile) {
        this.phoneNumberMobile = phoneNumberMobile;
    }

    /**
     * @return the leaveDy
     */
    public String getLeaveDy() {
        return leaveDy;
    }

    /**
     * @param leaveDy the leaveDy to set
     */
    public void setLeaveDy(String leaveDy) {
        this.leaveDy = leaveDy;
    }

    /**
     * Changes the status of the leave record in the hr_leavee table and updates
     * the table with approval information
     * @param approverID the approval identifier
     * @param approvalPhysicalYear the fiscal year
     * @param approvalDateFrom the start date of the approved leave
     * @param approvalDateTo the end date of the approved leave
     * @param approvalDate the approval date
     * @param actionTaken the action taken, approval or rejection
     * @param leaveId the leave record identifier
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */

    //leave.approveLeave(approverID, approvalPhysicalYear, approvalDateFrom, approvalDateTo, leaveId, leveType, headComment)
    public int approveLeave(String approverID, String approvalPhysicalYear,
            String approvalDateFrom, String approvalDateTo, String leaveId, String leveType, String headComment, String approvalDate) throws SQLException {
        String str;
        str = "UPDATE hr_leavee set approved_Physical_Year=?, " +
                "approved_From_Date=? ,approved_To_Date=?, approved_By=?, " +
                "approval_Date=?, STATUS=?,APPROVER_COMMENT=? WHERE leave_Id=?";
        if (!leveType.equals("1")) {
            approvalPhysicalYear = "";

        }
        _ps = getConnection().prepareStatement(str);
        _ps.setString(1, approvalPhysicalYear);
        _ps.setString(2, approvalDateFrom);
        _ps.setString(3, approvalDateTo);
        _ps.setString(4, approverID);
        _ps.setString(5, approvalDate);
        _ps.setInt(6, 3);
        _ps.setString(7, headComment);
        _ps.setString(8, leaveId);
        return _ps.executeUpdate();

    }

    /**
     * Update hr_leavee table upon rejection
     * @param approverID the approval identifier
     * @param approvalDate the approval date
     * @param actionTaken the action taken, approval or rejection
     * @param leaveId the leave identifier
     * @param forWhat the reason
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public int rejectLeave(String approverID, String rejectDate, String comment,String leveID) throws SQLException {
        String str = null;
        //str = "UPDATE hr_leavee set granted_By=?, granted_Date=?, action_Taken=? WHERE leave_Id=?";APPROVAL_DATE
        str = "UPDATE hr_leavee set APPROVED_BY=?, APPROVAL_DATE=?, APPROVER_COMMENT=?,STATUS=? WHERE leave_Id=?";
       _ps = getConnection().prepareStatement(str);
        _ps.setString(1, approverID);
        _ps.setString(2, rejectDate);
        _ps.setString(3, comment);
        _ps.setInt(4, 4);
        _ps.setString(5, leveID);
        return _ps.executeUpdate();
    }
}
