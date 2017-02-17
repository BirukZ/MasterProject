/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.leaveManager.LeaveApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class LeaveRequestEntity extends ConnectionManager {

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
    int leaveRequestId;// LEAVE_REQUEST_ID
    String requesterId;//REQUESTER_ID
    String appliedDate;//APPLIED_DATE
    String leaveType;//LEAVE_TYPE
    String leaveStartDate;//LEAVE_START_DATE
    int leaveDuration;//LEAVE_DURATION
    String reason;//REASON
    String requestStatus;//REQUEST_STATUS
    String leaveAddressId;//LEAVE_ADDRESS_ID
    String recordedBy;//RECORDED_BY
    String timeStamp;//TIME_STAMP
    String avilebelLeaveDayes;
    String fromDate;
    String toDate;
    String leaveDays;
    public String pysicalYear;
    private String returnDate;
    String physicalYear;
    HashMap leaveRequestInfo;
    ArrayList<HashMap> leaveYear;
    HashMap listOfReserLeave;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<HashMap> employeeFamily;
    private ArrayList<HashMap> listOfFamilyPassedAwaye;
    String currentDate = dateFormat.format(new Date());
    int currentYear = GregorianCalendarManipulation.getYear(currentDate);
    String pyscalYear=String.valueOf(currentYear);

    public ArrayList<HashMap> getListOfFamilyPassedAwaye() {
        return listOfFamilyPassedAwaye;
    }

    public void setListOfFamilyPassedAwaye(ArrayList<HashMap> listOfFamilyPassedAwaye) {
        this.listOfFamilyPassedAwaye = listOfFamilyPassedAwaye;
    }

    public ArrayList<HashMap> getEmployeeFamily() {
        return employeeFamily;
    }

    public void setEmployeeFamily(ArrayList<HashMap> employeeFamily) {
        this.employeeFamily = employeeFamily;
    }

    public String getPysicalYear() {
        return pysicalYear;
    }

    public void setPysicalYear(String pysicalYear) {
        this.pysicalYear = pysicalYear;
    }

//    public String getHolidayDate() {
//        return holidayDate;
//    }
//
//    public void setHolidayDate(String holidayDate) {
//        this.holidayDate = holidayDate;
//    }
//
//    public String getHolidayId() {
//        return holidayId;
//    }
//
//    public void setHolidayId(String holidayId) {
//        this.holidayId = holidayId;
//    }
//
//    public String getHolidayName() {
//        return holidayName;
//    }
//
//    public void setHolidayName(String holidayName) {
//        this.holidayName = holidayName;
//    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getAvilebelLeaveDayes() {
        return avilebelLeaveDayes;
    }

    public void setAvilebelLeaveDayes(String avilebelLeaveDayes) {
        this.avilebelLeaveDayes = avilebelLeaveDayes;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLeaveAddressId() {
        return leaveAddressId;
    }

    public void setLeaveAddressId(String leaveAddressId) {
        this.leaveAddressId = leaveAddressId;
    }

    public String getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(String leaveDays) {
        this.leaveDays = leaveDays;
    }

    public int getLeaveDuration() {
        return leaveDuration;
    }

    public void setLeaveDuration(int leaveDuration) {
        this.leaveDuration = leaveDuration;
    }

    public int getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getPhysicalYear() {
        return physicalYear;
    }

    public void setPhysicalYear(String physicalYear) {
        this.physicalYear = physicalYear;
    }

    public HashMap getLeaveRequestInfo() {
        return leaveRequestInfo;
    }

    public void setLeaveRequestInfo(HashMap leaveRequestInfo) {
        this.leaveRequestInfo = leaveRequestInfo;
    }

    public String getLeaveStartDate() {
        return leaveStartDate;
    }

    public void setLeaveStartDate(String leaveStartDate) {
        this.leaveStartDate = leaveStartDate;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public ArrayList<HashMap> getLeaveYear() {
        return leaveYear;
    }

    public void setLeaveYear(ArrayList<HashMap> leaveYear) {
        this.leaveYear = leaveYear;
    }

    public HashMap getListOfReserLeave() {
        return listOfReserLeave;
    }

    public void setListOfReserLeave(HashMap listOfReserLeave) {
        this.listOfReserLeave = listOfReserLeave;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public LeaveRequestEntity(HashMap leaveRequestInfo,
            ArrayList<HashMap> listOfFamilyPassedAwaye) {
        this.leaveRequestInfo = leaveRequestInfo;
        this.listOfFamilyPassedAwaye = listOfFamilyPassedAwaye;
    }

//    public LeaveRequestEntity(String holidayId, String holidayName, String holidayDate) {
//        this.holidayId = holidayId;
//        this.holidayName = holidayName;
//        this.holidayDate = holidayDate;
//
//    }
    public LeaveRequestEntity(String reason, String avilebelLeaveDayes, String fromDate,
            String toDate, String leaveDays, String leaveType, HashMap leaveRequestInfo) {
        this.reason = reason;
        this.avilebelLeaveDayes = avilebelLeaveDayes;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveDays = leaveDays;
        this.leaveType = leaveType;
        this.leaveRequestInfo = leaveRequestInfo;
    }

    public LeaveRequestEntity(String reason,
            String avilebelLeaveDayes,
            String fromDate,
            String toDate,
            String leaveDays,
            String leaveType,
            HashMap leaveRequestInfo,
            ArrayList<HashMap> leaveYear,
            HashMap listOfReserLeave,
            String returnDate,
            String userYear)
    {
        this.reason = reason;
        this.avilebelLeaveDayes = avilebelLeaveDayes;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveDays = leaveDays;
        this.leaveType = leaveType;
        this.leaveRequestInfo = leaveRequestInfo;
        this.leaveYear = leaveYear;
        this.listOfReserLeave = listOfReserLeave;
        this.returnDate = returnDate;
        this.physicalYear = userYear;
    }

    public LeaveRequestEntity(String requesterId, String appliedDate, String leaveType, String leaveStartDate, int leaveDuration, String reason, String requestStatus, String leaveAddressId, String recordedBy, String timeStamp) {
        this(requesterId, appliedDate, leaveType, reason, requestStatus, leaveAddressId, recordedBy, timeStamp);
        this.leaveStartDate = leaveStartDate;
        this.leaveDuration = leaveDuration;
    }

    public LeaveRequestEntity(String requesterId, String appliedDate, String leaveType, String reason, String requestStatus, String leaveAddressId, String recordedBy, String timeStamp) {
        this.requesterId = requesterId;
        this.appliedDate = appliedDate;
        this.leaveType = leaveType;
        this.reason = reason;
        this.requestStatus = requestStatus;
        this.leaveAddressId = leaveAddressId;
        this.recordedBy = recordedBy;
        this.timeStamp = timeStamp;
    }

    public LeaveRequestEntity(int leaveRequestId, String requesterId, String appliedDate, String leaveType, String leaveStartDate, int leaveDuration, String reason, String requestStatus, String leaveAddressId, String recordedBy, String timeStamp) {
        this(requesterId, appliedDate, leaveType, leaveStartDate, leaveDuration, reason, requestStatus, leaveAddressId, recordedBy, timeStamp);
        this.leaveRequestId = leaveRequestId;
    }

    public LeaveRequestEntity(int leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public LeaveRequestEntity() {
    }

    /**
     * Inserts LeaveRequest attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
//    public boolean insertLeaveRequest(LeaveRequestModel requestAttributes, Set<LeaveRequestModel> leaveRequests) throws SQLException {
//        String _insertQuery = "INSERT INTO HR_LEAVE_REQUEST " +
//                " ( LEAVE_REQUEST_ID, REQUESTER_ID, LEAVE_TYPE,LEAVE_DAYS_TAKEN, REQUEST_STATUS," +
//                " APPLIED_DATE,  REASON, LEAVE_ADDRESS_ID,RECORDED_BY,TIME_STAMP)" +
//                " VALUES (HR_LEAVE_REQUEST_SEQ.NEXTVAL,?,?,?, ?,?,?, ?,?,?) ";
//
//        String _insertDateDurationQuery = "INSERT INTO HR_LEAVE_REQUEST_DATE_DURATION " +
//                " (DATE_DURATION_ID, REQUEST_ID, START_DATE, DURATION,RETURNING_DATE)" +
//                " VALUES (HR_LEAVE_DATE_DURATION_SEQ.NEXTVAL,HR_LEAVE_REQUEST_SEQ.CURRVAL,?,?,?) ";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_insertQuery);
//            _ps.setString(1, requestAttributes.getRequesterId());
//            _ps.setString(2, requestAttributes.getLeaveType());
//            _ps.setInt(3, requestAttributes.getTotalDaysRequested());
//            _ps.setString(4, requestAttributes.getRequestStatus());
//            _ps.setString(5, requestAttributes.getAppliedDate());
//            _ps.setString(6, requestAttributes.getReason());
//            _ps.setString(7, requestAttributes.getLeaveAddressId());
//            _ps.setString(8, requestAttributes.getRecordedBy());
//            _ps.setString(9, requestAttributes.getTimeStamp());
//            _ps.executeUpdate();
//
//            _ps = _con.prepareStatement(_insertDateDurationQuery);
//            for (LeaveRequestModel currentDateAndDuration : leaveRequests) {
//                _ps.setString(1, currentDateAndDuration.getLeaveStartDate());
//                _ps.setInt(2, currentDateAndDuration.getLeaveDuration());
//                _ps.setString(3, currentDateAndDuration.getReturningDate());
//                _ps.executeUpdate();
//            }
//            //   _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
//        }
//    }
    public int insertLeaveRequest(ArrayList<LeaveRequestEntity> daysList) throws SQLException {
        String _insertQuery = "INSERT INTO HR_LEAVE_REQUEST " +
                " (LEAVE_REQUEST_ID, REQUESTER_ID, LEAVE_TYPE, REQUEST_STATUS," +
                " APPLIED_DATE, LEAVE_START_DATE, LEAVE_DURATION," +
                " REASON, LEAVE_ADDRESS_ID,RECORDED_BY,TIME_STAMP)" +
                " VALUES (HR_LEAVE_REQUEST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?) ";
        // String _insertLeaveAdressQuery = "INTO HR_LEAVE_REQUEST....";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, leaveType);
            _ps.setString(3, requestStatus);
            _ps.setString(4, appliedDate);
            _ps.setString(5, leaveStartDate);
            _ps.setInt(6, leaveDuration);
            _ps.setString(7, reason);
            _ps.setString(8, leaveAddressId);
            _ps.setString(9, recordedBy);
            _ps.setString(10, timeStamp);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public boolean updateLeaveBankForLeaveWithOutPay(HashMap RegisterLeavWithOutPayInfo) throws SQLException {
          String insertquary =" INSERT INTO HR_LEAVEWITHOUTPAY_BANK " +
                " (LEAVE_WITHOUT_ID, LEAVE_REQUEST_ID, REQUESTER_ID, REQUEST_YEAR," +
                " REQUEST_DATE, LEAVE_AMOUNT, DEDUCT_AMOUNT)" +
                " VALUES (HR_WITOUT_PAY_SEQ.NEXTVAL,?,?,?,?,?,?)";
        String updateEmployeeLeaveBalance = " UPDATE HR_EMP_LEAVE_BANK SET USEDLEAVE=? " +
                " WHERE EMP_ID=? AND YEAR=?";
        int row4 = 0;
        try {
            PreparedStatement ps = null;
            Savepoint savepoint = null;
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            _ps = conn.prepareStatement(insertquary);
            _ps.setString(1, RegisterLeavWithOutPayInfo.get("requestID").toString());
            _ps.setString(2, RegisterLeavWithOutPayInfo.get("employeeId").toString());
            _ps.setString(3, RegisterLeavWithOutPayInfo.get("requestYear").toString());
            _ps.setString(4, RegisterLeavWithOutPayInfo.get("requestDate").toString());
            _ps.setString(5, RegisterLeavWithOutPayInfo.get("leaveAmount").toString());
            _ps.setString(6, RegisterLeavWithOutPayInfo.get("deductAmount").toString());
            if (_ps.executeUpdate() > 0)
            {
              ps = conn.prepareStatement(updateEmployeeLeaveBalance);
              ps.setString(1, RegisterLeavWithOutPayInfo.get("totalDeductedAmount").toString());
              ps.setString(2, RegisterLeavWithOutPayInfo.get("employeeId").toString());
              ps.setString(3,RegisterLeavWithOutPayInfo.get("requestYear").toString());
              ps.executeUpdate();
            }


        } finally {
            releaseResources();
        }
        return true;
    }


    /**
     * Updates Termintion Request attribute of the database.<br>
     * The constructor with full argument must be called before this method
     * @see
     * @throws  SQLException
     */
    public boolean updateLeaveRequest(LeaveRequestEntity leaveRequestInformation) throws SQLException {
        String updateQuery = "UPDATE HR_EMP_LEAVE " +
                "SET LEAVE_TYPE        = ?, " +
                "  REQUESTED_FROM_DATE = ?, " +
                "  REQUESTED_TO_DATE   = ?, " +
                "  REQUESTING_REASON   = ?, " +
                "  REQUESTED_DATE      = ?, " +
                "  STATUS              = ?, " +
                "  LEAVE_DAYS          = ?, " +
                "  LEVETYPE            = ? " +
                "WHERE LEAVE_ID        = ?";
        String updateEmployeeFamilyInfo = "UPDATE HR_EMP_FAMILY SET ALIVE_OR_DIED=?" +
                " WHERE ID=? ";
        int row4 = 0;
        try {
            PreparedStatement ps = null;
            Savepoint savepoint = null;
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            _ps = conn.prepareStatement(updateQuery);
            _ps.setString(1, leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString());
            _ps.setString(2, leaveRequestInformation.getLeaveRequestInfo().get("fromDate").toString());
            _ps.setString(3, leaveRequestInformation.getLeaveRequestInfo().get("toDate").toString());
            _ps.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("reason").toString());
            _ps.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("currentDate").toString());
            _ps.setString(6, LeaveApproveManager.INITIAL_STATE_LEAVE);
            _ps.setString(7, leaveRequestInformation.getLeaveRequestInfo().get("leaveDays").toString());
            _ps.setString(8, leaveRequestInformation.getLeaveRequestInfo().get("kindOfLeave").toString());
            _ps.setString(9, leaveRequestInformation.getLeaveRequestInfo().get("LEAVEID").toString());

            if (_ps.executeUpdate() > 0) {
                if (leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString().equals("15")) {
                    ps = conn.prepareStatement(updateEmployeeFamilyInfo);
                    for (HashMap hm : leaveRequestInformation.getListOfFamilyPassedAwaye()) {
                        ps.setString(1, "NO");
                        ps.setString(2, hm.get("ID").toString());
                        row4 = ps.executeUpdate();
                    }
                    if (row4 > 0) {
                        conn.commit();
                        return true;
                    } else {
                        conn.rollback(savepoint);
                        return false;
                    }
                } else {
                    conn.commit();
                    return true;
                }
            } else {
                return false;
            }
        } finally {
            releaseResources();
        }
    }
    


    /**
     * Deletes upda from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean deleteLeaveRequest(String requestId, String leaveType) throws SQLException {
        String _deleteRequestQuery = "DELETE FROM HR_EMP_LEAVE_STATUS WHERE LEAVE_ID = '" + requestId + "'";
        String _deleteDatesQuery = "DELETE FROM HR_EMP_LEAVE WHERE LEAVE_ID = '" + requestId + "'";
        try {
            PreparedStatement _ps2;
            _con = getConnection();
            if (leaveType.equals("19")) {

                _con.setAutoCommit(false);
                _ps = _con.prepareStatement(_deleteRequestQuery);
                //  _ps.setInt(1, requestId);
                _ps.executeUpdate();
                _ps2 = _con.prepareStatement(_deleteDatesQuery);
                // _ps2.setInt(1, requestId);
                if (_ps2.executeUpdate() > 0) {
                    _con.commit();
                    return true;
                } else {
                    return false;
                }
            } else {
                _ps2 = _con.prepareStatement(_deleteDatesQuery);
                if (_ps2.executeUpdate() > 0) {
                    return true;
                } else {
                    return false;
                }
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    //finally {
//            releaseResources();
//        }
//   
    }

    /**
     * Deletes TErminationRequest from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean deleteAnnualLeaveRequest(String requestId) throws SQLException {
        String _deleteRequestQuery = "DELETE  HR_EMP_LEAVE_STATUS WHERE  LEAVE_ID=?";
        String _deleteDatesQuery = "DELETE  HR_EMP_LEAVE WHERE LEAVE_ID=?";
        try {
            _con.setAutoCommit(false);
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteRequestQuery);
            _ps.setString(1, requestId);
            if (_ps.executeUpdate() > 0) {
                _ps = _con.prepareStatement(_deleteDatesQuery);
                _ps.setString(1, requestId);
                if (_ps.executeUpdate() > 0) {
                    _con.commit();
                    return true;
                } else {
                    _con.rollback();
                    return false;
                }
            } else {
                _con.rollback();
                return false;
            }

        } finally {
            releaseResources();
        }
    }

    /**
     * Deletes TErminationRequest from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean updateAnnualLeaveRequest(String requestId) throws SQLException {
        String _deleteRequestQuery = "DELETE  HR_EMP_LEAVE_STATUS WHERE  LEAVE_ID=?";

        try {
            _con.setAutoCommit(false);
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteRequestQuery);
            _ps.setString(1, requestId);
            if (_ps.executeUpdate() > 0) {
                // _con.commit();
                return true;

            } else {
                _con.rollback();
                return false;
            }

        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of a request with the given id.<br>
     * It returns a ResultSet of either a single row or with no row.
     * @param  requestId  primary key of the table.
     * @throws  SQLException
     */
    public ResultSet selectLeaveRequestFromId(int requestId) throws SQLException {
        String _selectQuery = " SELECT LEAVE_REQUEST_ID,REQUESTER_ID,APPLIED_DATE,LEAVE_TYPE,REASON,REQUEST_STATUS," +
                " LEAVE_ADDRESS_ID,RECORDED_BY,TIME_STAMP,DATE_DURATION_ID,REQUEST_ID,START_DATE,DURATION,RETURNING_DATE" +
                " FROM HR_LEAVE_REQUEST , HR_LEAVE_REQUEST_DATE_DURATION" +
                " WHERE LEAVE_REQUEST_ID=REQUEST_ID AND LEAVE_REQUEST_ID= " + requestId;

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of a request with the given id.<br>
     * It returns a ResultSet of either a single row or with no row.
     * @param  requestId  primary key of the table.
     * @throws  SQLException
     */
    public ResultSet selectLeaveTaken(String employeeId, int leaveType, String referenceDate) throws SQLException {
        String _selectQuery = " SELECT LEAVE_REQUEST_ID,REQUESTER_ID,APPLIED_DATE,LEAVE_TYPE,REASON,REQUEST_STATUS," +
                " LEAVE_ADDRESS_ID,RECORDED_BY,TIME_STAMP,DATE_DURATION_ID,REQUEST_ID,START_DATE,DURATION,RETURNING_DATE" +
                " FROM HR_LEAVE_REQUEST , HR_LEAVE_REQUEST_DATE_DURATION" +
                " WHERE LEAVE_REQUEST_ID=REQUEST_ID AND LEAVE_REQUEST_ID= " + employeeId;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of a request Leave Types
     * applicable for the gender passed as an argument.<br>
     * @throws  SQLException
     */
    public ResultSet selectLeaveTypes(String gender) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_LEAVE_TYPE " +
                " WHERE GENDER='Both' OR GENDER='" + gender + "'" +
                "  ORDER BY DESCRIPTION";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * @return  ResultSet of leave requsts with the given requester.
     * @param requesterId  of employee to whom the request is made
     * @param userName  the user name of the employee who logged in to the system
     * @throws SQLException
     */
    public ResultSet selectLeaveRequestByRequesterId(String requesterId, String userName) throws SQLException {
        //select prcess states the manager can process on
        String _innerSelectQueryForState = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from  BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + LeaveApproveManager.PROCESS_LEAVE + "'))";
        //select employees who are subordinate of the logged in manager
        String _innerSelectQueryforSubordinates = " SELECT EMP_ID FROM HR_EMPLOYEE_INFO " +
                "   WHERE  DEPARTMENT_ID IN ( SELECT  DEPT_ID  FROM TBL_DEPARTMENT" +
                "          START WITH DEPT_ID=(SELECT DEPARTMENT_ID FROM HR_EMPLOYEE_INFO " +
                "                   WHERE EMP_ID =(SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + userName + "'))" +
                "          CONNECT BY PRIOR  BRANCH_ID=DEPT_ID);";

        String _selectQuery = " SELECT *  FROM HR_LEAVE_REQUEST " +
                " WHERE REQUESTER_ID= '" + requesterId + "'" +
                " AND REQUEST_STATUS IN(" + _innerSelectQueryForState + ")";
        //      " AND REQUESTER_ID IN ("+_innerSelectQuerySubordinates +")";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * @return  ResultSet of leave requsts with the given requester.
     * @param requesterId  of employee to whom the request is made
     * @param userName  the user name of the employee who logged in to the system
     * @throws SQLException
     */
    public ResultSet selectLeaveRequestByStatus(String status, String userName) throws SQLException {
        //select prcess states the manager can process on
        String _innerSelectQueryForState = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + LeaveApproveManager.PROCESS_LEAVE + "'))";
        //select employees who are subordinate of the logged in manager
        String _innerSelectQueryForSubordinates = " SELECT EMP_ID FROM HR_EMPLOYEE_INFO " +
                "   WHERE  DEPARTMENT_ID IN ( SELECT  DEPT_ID  FROM TBL_DEPARTMENT" +
                "          START WITH DEPT_ID=(SELECT DEPARTMENT_ID FROM HR_EMPLOYEE_INFO " +
                "                   WHERE EMP_ID =(SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + userName + "'))" +
                "          CONNECT BY PRIOR  BRANCH_ID=DEPT_ID);";

        String _selectQuery = " SELECT *  FROM HR_LEAVE_REQUEST " +
                " WHERE REQUEST_STATUS LIKE '" + status + "%'";
        //       " AND REQUESTER_ID IN (" + _innerSelectQueryForSubordinates + ")";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of requests which are not in their final state, nor rejected
     * @param userName  the user name of the employee who logged in to the system
     * @throws  SQLException
     */
    public ResultSet selectActiveLeaveRequests(String userName) throws SQLException {

        //select prcess states the manager can process on
        String _innerSelectQueryForState = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + LeaveApproveManager.PROCESS_LEAVE + "'))";
        //select employees who are subordinate of the logged in manager
        String _innerSelectQueryforSubordinates = " SELECT EMP_ID FROM HR_EMPLOYEE_INFO " +
                "   WHERE  DEPARTMENT_ID IN ( SELECT  DEPT_ID  FROM TBL_DEPARTMENT" +
                "          START WITH DEPT_ID=(SELECT DEPARTMENT_ID FROM HR_EMPLOYEE_INFO WHERE EMP_ID =(SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + userName + "'))" +
                "          CONNECT BY PRIOR  BRANCH_ID=DEPT_ID);";

        String _selectQuery = "SELECT  SELECT LEAVE_REQUEST_ID,REQUESTER_ID,APPLIED_DATE,LEAVE_TYPE,REASON,REQUEST_STATUS,LEAVE_ADDRESS_ID," +
                " RECORDED_BY,TIME_STAMP,DATE_DURATION_ID,START_DATE,DURATION,RETURNING_DATE" +
                " FROM HR_LEAVE_REQUEST , HR_LEAVE_REQUEST_DATE_DURATION " +
                " WHERE LEAVE_REQUEST_ID=REQUEST_ID" +
                " REQUEST_STATUS NOT LIKE '#%' " +//not on pending
                " AND REQUEST_STATUS NOT LIKE 'Rej%' " +//not rejected
                " AND REQUEST_STATUS <> '" + LeaveApproveManager.INITIAL_STATE_LEAVE + "' " +//not initial state
                " AND REQUEST_STATUS <> '" + LeaveApproveManager.FINAL_STATE_LEAVE + "' " +//not in final state
                " AND REQUEST_STATUS IN(" + _innerSelectQueryForState + ")";//the user is authorized to access the result
        //      " AND REQUESTER_ID IN ("+_innerSelectQuerySubordinates +")";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of leave request of an employee<br>
     * It returns either single or no row result set.
     * @param  requesterId  id of employee who requested leave
     * @throws  SQLException
     */
    public ResultSet selectEmployeeLatestLeaveRequest(String requesterId, String referenceDate, String userName) throws SQLException {
        String _selectQuery = "SELECT MAX(LEAVE_REQUEST_ID)  AS LEAVE_REQUEST_ID" +
                "  FROM    HR_LEAVE_REQUEST" +
                "  WHERE REQUEST_STATUS ='" + LeaveApproveManager.INITIAL_STATE_LEAVE + "'" +
                "        AND REQUESTER_ID='" + requesterId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

//    /**
//     * returns ResultSet object of leave request of an employee<br>
//     * It returns either single or no row result set.
//     * @param  requesterId  id of employee who requested leave
//     * @throws  SQLException
//     */
//    public ResultSet insertLeaveAddress(LeaveAddressModel leaveAddressModel) throws SQLException {
//        String _insertQuery = "INSERT INTO HR_EMP_ADDRESS_LEAVE ( EMP_ADDRESS_ID,EMP_ID,ADDRESS_TYPE," +
//                " REGION, ZONE_OR_SUBCITY, WOREDA, KEBELE, HOUSE_NUMBER, " +
//                " TELEPHONE_HOME, TELEPHONE_MOBILE)" +
//                " VALUES (HR_EMP_ADDRESS_SEQ.NEXTVAL, ?,?,?,?,?,?,?,?,?)";
//
//        String _selectQuery = "SELECT HR_EMP_ADDRESS_SEQ.CURRVAL AS LEAVE_ADDRESS_ID FROM DUAL";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_insertQuery);
//
//            _ps.setString(1, leaveAddressModel.getEmployeeId());
//            _ps.setString(2, leaveAddressModel.getAddressType());
//            _ps.setString(3, leaveAddressModel.getRegion());
//            _ps.setString(4, leaveAddressModel.getZoneOrSubCity());
//            _ps.setString(5, leaveAddressModel.getWoreda());
//            _ps.setString(6, leaveAddressModel.getKebele());
//            _ps.setString(7, leaveAddressModel.getHouseNumber());
//            _ps.setString(8, leaveAddressModel.getTelephoneHome());
//            _ps.setString(9, leaveAddressModel.getMobilePhoneNumber());
//
//            _ps.executeUpdate();
//            //SavePoint
//            _ps = _con.prepareStatement(_selectQuery);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }
    /**
     * used to chech weather date is holiday or not
     */
    public ResultSet getNationalHoliday(int month, int day) throws SQLException {
        String _selectQuery = "SELECT COUNT (MONTH_OF_HOLIDAY) AS NUM_OF_HOLIDAYS FROM HR_LU_NATIONAL_HOLIDAYS WHERE MONTH_OF_HOLIDAY=? AND DAY_OF_HOLIDAY=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, month);
            _ps.setInt(2, day);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public int selectLeaveTakenThisYear(String employeeId, String leaveType, String year) throws SQLException {
        String _selectQuery = "SELECT SUM (LEAVE_DAYS_TAKEN)  AS TOTAL" +
                " FROM HR_LEAVE_REQUEST " +
                " WHERE " +
                "  REQUEST_STATUS LIKE 'App-%' AND" +//approved
                "  REQUESTER_ID=?" +
                "  AND APPLIED_DATE LIKE ?" +//for the year
                "  AND  LEAVE_TYPE=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, employeeId);
            _ps.setString(2, year + "-%");
            _ps.setString(3, leaveType);
            _rs = _ps.executeQuery();
            int daysTaken = 0;
            if (_rs.next()) {
                daysTaken = _rs.getInt("TOTAL");
            } else {
            }
            return daysTaken;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllNationalHolidays() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_NATIONAL_HOLIDAYS";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public HashMap selectLeaveInformation(String requestedLeaveId) throws SQLException {
        String _select = " SELECT STATUS,HIRE_DATE,FIRST_NAME,MIDDLE_NAME,LAST_NAME,JOB_CODE,HR_LEAVEE.EMP_ID, " +
                " HR_LU_LEAVE_TYPE.DESCRIPTION,LEAVE_ID,HR_EMPLOYEE_INFO.EMP_ID,LEAVE_TYPE,REQUESTED_FROM_DATE,REQUESTED_TO_DATE,REQUESTING_REASON,REQUESTED_DATE " +
                " FROM HR_LEAVEE,HR_LU_LEAVE_TYPE,HR_EMPLOYEE_INFO " +
                " WHERE LEAVE_TYPE_CODE=LEAVE_TYPE " +
                " AND HR_LEAVEE.EMP_ID=HR_EMPLOYEE_INFO.EMP_ID " +
                " AND hr_leavee.leave_id=?";
        HashMap leaveAttribute = new HashMap();
        ResultSet _rs;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, requestedLeaveId);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                leaveAttribute.put("STATUS", _rs.getString("STATUS"));
                leaveAttribute.put("FULL_NAME", _rs.getString("FIRST_NAME") + "   " + _rs.getString("MIDDLE_NAME") + "   " + _rs.getString("LAST_NAME"));
                leaveAttribute.put("JOB_CODE", _rs.getString("JOB_CODE"));
                leaveAttribute.put("LEAVE_TYPE", _rs.getString("LEAVE_TYPE"));
                leaveAttribute.put("REQUESTED_PHYSICAL_YEAR", _rs.getString("LEAVE_ID"));
                leaveAttribute.put("REQUESTED_FROM_DATE", _rs.getString("REQUESTED_FROM_DATE"));
                leaveAttribute.put("REQUESTED_TO_DATE", _rs.getString("REQUESTED_TO_DATE"));
                leaveAttribute.put("REQUESTING_REASON", _rs.getString("REQUESTING_REASON"));
                leaveAttribute.put("LEAVE_ID", _rs.getString("LEAVE_ID"));
                leaveAttribute.put("EMP_ID", _rs.getString("EMP_ID"));
                leaveAttribute.put("DESCRIPTION", _rs.getString("DESCRIPTION"));
            }
            return leaveAttribute;
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }

        return null;
    }

    public boolean oldLeaverequest(String employeeID) {
        String selectString = "SELECT to_date(REQUESTED_TO_DATE,'yyyy-mm-dd') " +
                "FROM HR_EMP_LEAVE, " +
                "  hr_employee_info " +
                "WHERE ( regexp_like(SUBSTR(STATUS, 0, 2),'[1-9]') " +
                "OR (to_date(REQUESTED_TO_DATE,'yyyy-mm-dd') > to_date(sysdate) " +
                "AND hr_employee_info.emp_status             ='02') ) " +
                "AND hr_emp_leave.emp_id                     =hr_employee_info.emp_id " +
                "AND hr_emp_leave.emp_id                     ='" + employeeID + "'";


        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(selectString);
            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
            if (ocrs.next()) {
                if (ocrs.getInt("READDATA") > 0) {
                    return false;
                } else {
                    return true;
                }
            } else {
                return true;
            }

        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public ArrayList<HashMap> requestedLeaveLists(String employeeID) throws SQLException
    {
        String _select = "SELECT HR_EMP_LEAVE.LEAVE_ID, " +
                "  HR_EMP_LEAVE.REQUESTED_DATE, " +
                "  Hr_Emp_Leave.Status, " +
                "  Hr_Emp_Leave.Leave_Type, " +
                "  Hr_Lu_Leave_Type.Description, " +
                "  HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE " +
                "FROM HR_EMP_LEAVE, " +
                "  Hr_Lu_Leave_Type " +
                "WHERE Hr_Emp_Leave.Emp_Id              =? " +
                "AND Hr_Emp_Leave.Leave_Type            =HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE " +
                "AND (HR_LU_LEAVE_TYPE.FOREMPLOYMENTTYPE= " +
                "  (SELECT Leavestartfrom FROM Hr_Employee_Info WHERE Emp_Id =? " +
                "  ) " +
                "OR HR_LU_LEAVE_TYPE.FOREMPLOYMENTTYPE='Both') " +
                "ORDER BY Hr_Emp_Leave.Requested_Date DESC ";

        ArrayList<HashMap> requests = new ArrayList<HashMap>();
        HashMap leaveAttribute = new HashMap();
        _con = getConnection();
        _ps = _con.prepareStatement(_select);
        _ps.setString(1, employeeID);
        _ps.setString(2, employeeID);
        _rs = _ps.executeQuery();
        while (_rs.next()) {
            leaveAttribute = new HashMap();
            leaveAttribute.put("LEAVE_ID", _rs.getString("LEAVE_ID"));
            leaveAttribute.put("STATUS", _rs.getString("STATUS"));
            leaveAttribute.put("REQUESTED_DATE", _rs.getString("REQUESTED_DATE"));
            leaveAttribute.put("DESCRIPTION", _rs.getString("DESCRIPTION"));
            requests.add(leaveAttribute);
        }

        return requests;
    }

    public float countReserveLeave(String employeeId)
    {
        String select = "SELECT SUM(AVAILABLELEAVENUMBER) - SUM(USEDLEAVE) AS COUNTLEAVE " +
                "FROM HR_RESERVE_LEAVE " +
                "WHERE EMP_ID                     =? " +
                "AND TO_NUMBER(AVAILABLELEAVENUMBER) > TO_NUMBER(USEDLEAVE) AND " +
                " STATUS like 'App%'" +
                "ORDER BY LEAVEYEAR";

        try {
            PreparedStatement _pscount = null;
            ResultSet _rscount = null;
            Connection _conn = getConnection();
            _pscount = _conn.prepareStatement(select);
            _pscount.setString(1, employeeId);
            _rscount = _pscount.executeQuery();
            if (_rscount.next()) {
                if (_rscount.getString("COUNTLEAVE") != null) {
                    return Float.parseFloat(_rscount.getString("COUNTLEAVE"));
                } else {
                    return 0;
                }

            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<HashMap> reserveLeave(String employeeId) {
        ArrayList<HashMap> listOfReserve = new ArrayList<HashMap>();
        String select = " SELECT RESERVELAVEID, " +
                "  AVAILABLELEAVENUMBER, " +
                "  LEAVEYEAR, " +
                "  USEDLEAVE, " +
                "  EMP_ID " +
                " FROM HR_RESERVE_LEAVE " +
                " WHERE EMP_ID = ? " +
                " AND TO_NUMBER(AVAILABLELEAVENUMBER) > TO_NUMBER(USEDLEAVE) " +
                " AND STATUS like 'App%'" +
                " ORDER BY LEAVEYEAR ";
        try {
            _ps = null;
            _rs = null;
            Connection conn = getConnection();
            _ps = conn.prepareStatement(select);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();
            float availeLeave = 0;
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("reservelaveid", _rs.getString("RESERVELAVEID").toString());
                hm.put("availableleavenumber", _rs.getString("AVAILABLELEAVENUMBER").toString());
                hm.put("leaveyear", _rs.getString("LEAVEYEAR").toString());
                hm.put("emp_id", _rs.getString("EMP_ID").toString());
                hm.put("USEDLEAVE", _rs.getString("USEDLEAVE").toString());
                availeLeave = Float.parseFloat(_rs.getString("AVAILABLELEAVENUMBER")) -
                        Float.parseFloat(_rs.getString("USEDLEAVE"));
                hm.put("availeLeave", Float.toString(availeLeave));

                listOfReserve.add(hm);
            }
            return listOfReserve;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * <p>returns start and end date of all the leaves taken </p>
     * <p>by an employee of id empId
     * @param empId
     * intended for calculating remaining annual leave days of an employee
     */
    public ArrayList<HashMap> selectAnnualLeavesTaken(String empId) {
        ArrayList<HashMap> readUsedLeave = new ArrayList<HashMap>();
        HashMap usedLeave = null;
        String _select = "SELECT HR_EMP_LEAVE_STATUS.LEAVE_DAYS, " +
                "  HR_EMP_LEAVE_STATUS.PHYSICAL_YEAR " +
                "FROM HR_EMP_LEAVE_STATUS, " +
                "  HR_EMP_LEAVE " +
                "WHERE HR_EMP_LEAVE.EMP_ID            =? " +
                "AND STATUS                           ='1' " +
                "AND HR_EMP_LEAVE_STATUS.LEAVE_ID     =HR_EMP_LEAVE.LEAVE_ID " +
                "AND HR_EMP_LEAVE_STATUS.PHYSICAL_YEAR= " +
                "  (SELECT MAX(PHYSICAL_YEAR) " +
                "  FROM HR_EMP_LEAVE_STATUS, " +
                "    HR_EMP_LEAVE " +
                "  WHERE HR_EMP_LEAVE.EMP_ID       =? " +
                "  AND HR_EMP_LEAVE_STATUS.LEAVE_ID=HR_EMP_LEAVE.LEAVE_ID " +
                "  AND HR_EMP_LEAVE_STATUS.LEVETYPE=1 " +
                "  )";


        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            Connection conn = getConnection();
            _ps = conn.prepareStatement(_select);
            _ps.setString(1, empId);
            _ps.setString(2, empId);
            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            while (ocrs.next()) {
                usedLeave = new HashMap();
                usedLeave.put("LEAVE_DAYS", ocrs.getString("LEAVE_DAYS"));
                usedLeave.put("PHYSICAL_YEAR", ocrs.getString("PHYSICAL_YEAR"));
                readUsedLeave.add(usedLeave);
            }
            closePooledConnections(conn);
            return readUsedLeave;
        } catch (Exception ex) {

            ex.printStackTrace();


            return null;

        }
    }

    public int saveEmployeeAnualLeaveRequest(LeaveRequestEntity leaveRequestInformation, String status, String registerby) {
        String itemId = null;
        //  int row3 = 0;
        int row4 = 0;
        int insertStatus = 0;
        boolean firstTime = true;
        // String requestId = null;
        //  PreparedStatement ps2 = null;
        //  PreparedStatement psBackUp = null;
        PreparedStatement _ps1 = null;
        //   PreparedStatement psDelete = null;
        PreparedStatement updateLeaveBank = null;
        String inseretTOLeaveRequestInfo = "INSERT INTO HR_EMP_LEAVE ( LEAVE_ID,emp_Id, " +
                " leave_Type, " +
                " requested_From_Date," +
                " requested_To_Date, " +
                " requesting_Reason, " +
                " requested_Date, " +
                " STATUS," +
                " LEAVE_DAYS," +
                " LEVETYPE," +
                " PHYSICALYEAR," +
                " RETURNDATE," +
                " REGISTERBY)" +
                " values(SEQ_HR_REQUESTS.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?)";
        String insertIntoLeaveStatus = " INSERT INTO  HR_EMP_LEAVE_STATUS" +
                " (LEAVE_ID," +
                "  PHYSICAL_YEAR," +
                "  LEAVE_DAYS," +
                "  LEVETYPE," +
                "  FROMLEAVE," +
                "  LEAVEIDES" +
                "  )" +
                " VALUES (SEQ_HR_REQUESTS.currval , ? , ?, ?, ?, ?)";
        String updateReserLeave = " UPDATE HR_RESERVE_LEAVE " +
                " SET  USEDLEAVE                =? " +
                " WHERE RESERVELAVEID      =? ";
        String leaveBank = " UPDATE HR_EMP_LEAVE_BANK SET USEDLEAVE=? WHERE ID=?";
        String leave_Bank = " UPDATE HR_EMP_LEAVE_BANK SET USEDLEAVE=? WHERE ID=?";
        String uesedLeave = "anualLeave";
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            _ps = conn.prepareStatement(inseretTOLeaveRequestInfo);
            _ps.setString(1, leaveRequestInformation.getLeaveRequestInfo().get("employeeId").toString());
            _ps.setString(2, leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString());
            _ps.setString(3, leaveRequestInformation.getLeaveRequestInfo().get("fromDate").toString());
            _ps.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("toDate").toString());
            _ps.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("reason").toString());
            _ps.setString(6, leaveRequestInformation.getLeaveRequestInfo().get("currentDate").toString());
            _ps.setString(7, status);
            _ps.setString(8, leaveRequestInformation.getLeaveRequestInfo().get("leaveDays").toString());
            _ps.setString(9, leaveRequestInformation.getLeaveRequestInfo().get("kindOfLeave").toString());
            _ps.setString(10, leaveRequestInformation.getPhysicalYear());
            _ps.setString(11, leaveRequestInformation.getReturnDate());
            _ps.setString(12, registerby);
            if (_ps.executeUpdate() > 0) {
                _ps1 = conn.prepareStatement(insertIntoLeaveStatus);
                for (HashMap hm : leaveRequestInformation.getLeaveYear()) {
                    _ps1.setString(1, hm.get("uesedLeave").toString());
                    _ps1.setInt(2, Integer.parseInt(hm.get("year").toString()));
                    _ps1.setString(3, "1");
                    _ps1.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("leaveFromDesc").toString());
                    _ps1.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("leaveIdDesc").toString());
                    insertStatus = _ps1.executeUpdate();
                }
                if (insertStatus > 0) {
                    for (HashMap hm2 : leaveRequestInformation.getLeaveYear()) {
                        if (!hm2.get("leaveFrom").toString().equals(uesedLeave)) {
                            firstTime = true;
                        }
                        if (firstTime) {
                            if (hm2.get("leaveFrom").toString().equals("anualLeave")) {
                                updateLeaveBank = conn.prepareStatement(leaveBank);
                            } else {
                                updateLeaveBank = conn.prepareStatement(updateReserLeave);
                            }
                            firstTime = false;
                            uesedLeave = hm2.get("leaveFrom").toString();
                        }
                        updateLeaveBank.setString(1, hm2.get("oldLeaveAmount").toString());
                        updateLeaveBank.setString(2, hm2.get("id").toString());
                        row4 = updateLeaveBank.executeUpdate();
                    }
                }
            }
            if (row4 > 0) {
                conn.commit();
                return 1;
            } else {
                conn.rollback();
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return 0;
        }
    }

    public boolean updateEmployeeAnualLeaveRequest(LeaveRequestEntity leaveRequestInformation) {
        String itemId = null;
        //  int row3 = 0;
        int row4 = 0;
        int insertStatus = 0;
        boolean firstTime = true;
        // String requestId = null;
        //  PreparedStatement ps2 = null;
        //  PreparedStatement psBackUp = null;
        PreparedStatement _ps1 = null;
        //   PreparedStatement psDelete = null;
        PreparedStatement updateLeaveBank = null;
        String inseretTOLeaveRequestInfo = "INSERT INTO HR_EMP_LEAVE ( emp_Id, " +
                " leave_Type, " +
                " requested_From_Date," +
                " requested_To_Date, " +
                " requesting_Reason, " +
                " requested_Date, " +
                " STATUS," +
                " LEAVE_DAYS," +
                " LEVETYPE)" +
                " values(?,?,?,?,?,?,?,?,?)";
        String insertIntoLeaveStatus = " INSERT INTO  HR_EMP_LEAVE_STATUS" +
                " (LEAVE_ID," +
                "  PHYSICAL_YEAR," +
                "  LEAVE_DAYS," +
                "  LEVETYPE," +
                "  FROMLEAVE," +
                "  LEAVEIDES" +
                "  )" +
                " VALUES (SEQ_HR_REQUESTS.currval , ? , ?, ?, ?, ?)";
        String updateReserLeave = " UPDATE HR_RESERVE_LEAVE " +
                " SET  USEDLEAVE                =?," +
                "      LEAVE_ID                 =SEQ_HR_REQUESTS.currval " +
                " WHERE RESERVELAVEID      =? ";
//        String updateReserLeave2 = " UPDATE HR_RESERVE_LEAVE " +
//                " SET AVAILABLELEAVENUMBER=? " +
//                " WHERE RESERVELAVEID      =? ";
//        String leaveBackup = "INSERT " +
//                "INTO HR_RESERVE_LEAVE_BACKUP " +
//                "  (LEAVEYEAR , " +
//                "    AVAILABLELEAVENUMBER , " +
//                "    EMP_ID , " +
//                "    STATUS ) " +
//                " (SELECT LEAVEYEAR , " +
//                "      AVAILABLELEAVENUMBER , " +
//                "      EMP_ID , " +
//                "      STATUS " +
//                "    FROM HR_RESERVE_LEAVE " +
//                "    WHERE RESERVELAVEID=? " +
//                "  )";
//        String deleteEmployee = "DELETE FROM HR_RESERVE_LEAVE_BACKUP WHERE EMP_ID=?";
        String leaveBank = " UPDATE HR_EMP_LEAVE_BANK SET USEDLEAVE=? WHERE ID=?";
        String uesedLeave = "anualLeave";
        try {
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            _ps = conn.prepareStatement(inseretTOLeaveRequestInfo);
            _ps.setString(1, leaveRequestInformation.getLeaveRequestInfo().get("employeeId").toString());
            _ps.setString(2, leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString());
            _ps.setString(3, leaveRequestInformation.getLeaveRequestInfo().get("fromDate").toString());
            _ps.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("toDate").toString());
            _ps.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("reason").toString());
            _ps.setString(6, leaveRequestInformation.getLeaveRequestInfo().get("currentDate").toString());
            _ps.setString(7, LeaveApproveManager.INITIAL_STATE_LEAVE);
            _ps.setString(8, leaveRequestInformation.getLeaveRequestInfo().get("leaveDays").toString());
            _ps.setString(9, leaveRequestInformation.getLeaveRequestInfo().get("kindOfLeave").toString());
            if (_ps.executeUpdate() > 0) {
                _ps1 = conn.prepareStatement(insertIntoLeaveStatus);
                for (HashMap hm : leaveRequestInformation.getLeaveYear()) {
                    _ps1.setString(1, hm.get("uesedLeave").toString());
                    _ps1.setInt(2, Integer.parseInt(hm.get("year").toString()));
                    _ps1.setString(3, "1");
                    _ps1.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("leaveFromDesc").toString());
                    _ps1.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("leaveIdDesc").toString());
                    insertStatus = _ps1.executeUpdate();
                }
                if (insertStatus > 0) {
                    for (HashMap hm2 : leaveRequestInformation.getLeaveYear()) {
                        if (!hm2.get("leaveFrom").toString().equals(uesedLeave)) {
                            firstTime = true;
                        }
                        if (firstTime) {
                            if (hm2.get("leaveFrom").toString().equals("anualLeave")) {
                                updateLeaveBank = conn.prepareStatement(leaveBank);
                            } else {
                                updateLeaveBank = conn.prepareStatement(updateReserLeave);
                            }
                            firstTime = false;
                            uesedLeave = hm2.get("leaveFrom").toString();
                        }
                        updateLeaveBank.setString(1, hm2.get("oldLeaveAmount").toString());
                        updateLeaveBank.setString(2, hm2.get("id").toString());
                        row4 = updateLeaveBank.executeUpdate();
                    }
                }
            }
            if (row4 > 0) {
                conn.commit();
                return true;
            } else {
                conn.rollback();
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return false;
        }
    }

    public int saveEmployeeLeaveRequest(LeaveRequestEntity leaveRequestInformation, String registerby) {
       
        int row4 = 0;
        PreparedStatement ps = null;
        String inseretTOLeaveRequestInfo = "INSERT INTO HR_EMP_LEAVE ( emp_Id, " +
                " leave_Type, " +
                " requested_From_Date," +
                " requested_To_Date, " +
                " requesting_Reason, " +
                " requested_Date, " +
                " STATUS," +
                " LEAVE_DAYS," +
                " LEVETYPE," +
                " PHYSICALYEAR," +
                " RETURNDATE," +
                " REGISTERBY)" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?)";
        String updateEmployeeProfile = "UPDATE HR_EMP_FAMILY SET ALIVE_OR_DIED=?" +
                " WHERE ID=? ";
        try {
            Savepoint savepoint = null;
            Connection conn = getConnection();
            conn.setAutoCommit(false);
            _ps = conn.prepareStatement(inseretTOLeaveRequestInfo);
            _ps.setString(1, leaveRequestInformation.getLeaveRequestInfo().get("employeeId").toString());
            _ps.setString(2, leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString());
            _ps.setString(3, leaveRequestInformation.getLeaveRequestInfo().get("fromDate").toString());
            _ps.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("toDate").toString());
            _ps.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("reason").toString());
            _ps.setString(6, leaveRequestInformation.getLeaveRequestInfo().get("currentDate").toString());
            _ps.setString(7, LeaveApproveManager.INITIAL_STATE_LEAVE);
            _ps.setString(8, leaveRequestInformation.getLeaveRequestInfo().get("leaveDays").toString());
            _ps.setString(9, leaveRequestInformation.getLeaveRequestInfo().get("kindOfLeave").toString());
            _ps.setString(10, pyscalYear);
            _ps.setString(11, leaveRequestInformation.getReturnDate());
            _ps.setString(12, registerby);
            if (_ps.executeUpdate() > 0) {
                if (leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString().equals("20") ||
                        leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString().equals("21")) {
                    ps = conn.prepareStatement(updateEmployeeProfile);
                    for (HashMap hm : leaveRequestInformation.getListOfFamilyPassedAwaye()) {
                        ps.setString(1, "NO");
                        ps.setString(2, hm.get("ID").toString());
                        row4 = ps.executeUpdate();
                    }
                    if (row4 > 0) {
                        conn.commit();
                        return 1;
                    } else {
                        conn.rollback(savepoint);
                        return 0;
                    }
                } else {
                    conn.commit();
                    return 1;
                }
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     * save employee two houres leaves
     * @param requestID
     * @return
     */
    public int saveEmployeeGetPassLeaveRequest(LeaveRequestEntity leaveRequestInformation, String registerby) {

        String inseretTOLeaveRequestInfo = "INSERT INTO HR_EMP_LEAVE ( emp_Id, " +
                " leave_Type, " +
                " requested_From_Date," +
                " requested_To_Date, " +
                " requesting_Reason, " +
                " requested_Date, " +
                " STATUS," +
                " LEAVE_DAYS," +
                " LEVETYPE," +
                " STARTTIME," +
                " ENDTIME," +
                " REGISTERBY" +
                " )" +
                " values(?,?,?,?,?,?,?,?,?,?,?,?)";

        try {

            Connection conn = getConnection();
            _ps = conn.prepareStatement(inseretTOLeaveRequestInfo);
            _ps.setString(1, leaveRequestInformation.getLeaveRequestInfo().get("employeeId").toString());
            _ps.setString(2, leaveRequestInformation.getLeaveRequestInfo().get("leaveType").toString());
            _ps.setString(3, leaveRequestInformation.getLeaveRequestInfo().get("fromDate").toString());
            _ps.setString(4, leaveRequestInformation.getLeaveRequestInfo().get("toDate").toString());
            _ps.setString(5, leaveRequestInformation.getLeaveRequestInfo().get("reason").toString());
            _ps.setString(6, leaveRequestInformation.getLeaveRequestInfo().get("currentDate").toString());
            _ps.setString(7, LeaveApproveManager.INITIAL_STATE_LEAVE);
            _ps.setString(8, leaveRequestInformation.getLeaveRequestInfo().get("leaveDays").toString());
            _ps.setString(9, leaveRequestInformation.getLeaveRequestInfo().get("kindOfLeave").toString());
            _ps.setString(10, leaveRequestInformation.getLeaveRequestInfo().get("startTime").toString());
            _ps.setString(11, leaveRequestInformation.getLeaveRequestInfo().get("endTime").toString());
            _ps.setString(12, registerby);
            if (_ps.executeUpdate() > 0) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public HashMap readPreviousRequestsInfo(String requestID) {
        String select = "SELECT HR_EMP_LEAVE.LEAVE_TYPE, " +
                "  REQUESTED_FROM_DATE, " +
                "  REQUESTED_TO_DATE, " +
                "  REQUESTING_REASON, " +
                "  REQUESTED_DATE, " +
                "  STATUS, " +
                "  LEAVE_DAYS, " +
                "  MAX_NUM_OF_DAYS," +
                "  LEAVE_ID," +
                " DESCRIPTION " +
                "FROM HR_EMP_LEAVE, " +
                "  HR_LU_LEAVE_TYPE " +
                "WHERE HR_EMP_LEAVE.LEAVE_TYPE=HR_LU_LEAVE_TYPE.LEAVE_TYPE_CODE " +
                "AND LEAVE_ID                 =?";

        HashMap hm = new HashMap();

        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, requestID);
            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            if (ocrs.next()) {
                hm.put("LEAVE_TYPE", ocrs.getString("LEAVE_TYPE"));
                hm.put("REQUESTED_FROM", ocrs.getString("REQUESTED_FROM_DATE"));
                hm.put("REQUESTED_TO", ocrs.getString("REQUESTED_TO_DATE"));
                hm.put("REQUESTING_REASON", ocrs.getString("REQUESTING_REASON"));
                hm.put("STATUS", ocrs.getString("STATUS"));
                hm.put("LEAVE_DAYS", ocrs.getString("LEAVE_DAYS"));
                hm.put("REQUESTED_DATE", ocrs.getString("REQUESTED_DATE"));
                hm.put("MAX_NUM_OF_DAYS", ocrs.getString("MAX_NUM_OF_DAYS"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));

                return hm;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        }

    }

    /**
     *
     * @param requestId
     * @return
     */
    public OracleCachedRowSet ReadRequestsInfo(String requestId) {

        String _select = " SELECT      " +
                "               IT.WF_ITEM_ID,    " +
                "               WFS.WF_STATE_ID,   " +
                "               WFS.WF_STATE_NAME,   " +
                "               WFS.PROPERTY,    " +
                "               WFIO.WF_OWNER_GROUP_ID,    " +
                "               WFO.OWNER_GROUP_NAME,    " +
                "               WF.WORKFLOW_ID,     " +
                "               WF.WORKFLOW_NAME,    " +
                "               LE.LEAVE_ID,     " +
                "               LE.LEAVE_TYPE,  " +
                "               LE.REQUESTING_REASON," +
                "               LE.REQUESTED_DATE," +
                "               LE.REQUESTED_FROM_DATE   " +
                "       FROM" +
                "               HR_WORKFLOW_ITEM WFI, " +
                "               HR_WORKFLOW_STATE WFS," +
                "               HR_WORKFLOWS WF," +
                "               HR_WORKFLOW_ITEM_OWNER WFIO," +
                "               HR_WORKFLOW_OWNER_GROUP WFO," +
                "               HR_EMP_LEAVE LE," +
                "               HR_LU_LEAVE_TYPE LT," +
                "               HR_WORKFLOW_ITEM IT" +
                "        WHERE  WFS.WF_STATE_ID= WFI.CURRENT_STATE_ID AND" +
                "               WF.WORKFLOW_ID= WFI.WORKFLOW_ID AND           " +
                "               WFIO.WF_ITEM_ID=WFI.WF_ITEM_ID AND" +
                "               WFO.WF_OWNER_GROUP_ID= WFIO.WF_OWNER_GROUP_ID AND " +
                "               LE.LEAVE_ID=WFI.REQUEST_ID AND         " +
                "               LT.LEAVE_TYPE_CODE=LE.LEAVE_TYPE AND" +
                "               IT.REQUEST_ID=LE.LEAVE_ID AND                         " +
                "                LE.LEAVE_ID='" + requestId + "'";


        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps =
                    _con.prepareStatement(_select);
            _rs =
                    _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public int deleteLeave(String leaveID) throws SQLException {
        String _delete = "DELETE FROM HR_EMP_LEAVE WHERE LEAVE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_delete);
            _ps.setString(1, leaveID);
//        closePooledConnections();
            int result = _ps.executeUpdate();
            _ps.close();
//        closePooledConnections();
            return result;
        } finally {
            releaseResources();
        }

    }

    public boolean isHolidayButNotWeekend(String date) {
        String select = "SELECT * " +
                " FROM HR_LU_HOLIDAYS " +
                " WHERE DATEOFHOLIDAYS ='" + date + "'";
        Connection con = null;
        try {


            con = getConnection();
            PreparedStatement ps = con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
            return false;
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<HashMap> holidayList(String startDate, String endDate) {
        try {
            String select = "SELECT * " +
                    " FROM HR_LU_HOLIDAYS " +
                    " WHERE DATEOFHOLIDAYS BETWEEN '" + startDate + "' AND '" + endDate + "'";
            Connection con = null;
            con = getConnection();
            PreparedStatement ps = con.prepareStatement(select);
            ResultSet rs = ps.executeQuery();
            ArrayList<HashMap> holiday = new ArrayList<HashMap>();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("holidayDate", rs.getString("DATEOFHOLIDAYS"));
                hm.put("description", rs.getString("NAMEOFHOLIDAYS"));
                holiday.add(hm);
            }
            return holiday;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkLeaveType(String employeeId, String leaveType) {
        try {
            String sql = "SELECT COUNT(*) AS COUNTER " +
                    "FROM HR_EMP_LEAVE " +
                    "WHERE EMP_ID=? " +
                    "AND LEAVE_TYPE=? " +
                    "AND STATUS  like 'App%'";
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            ps.setString(2, leaveType);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNTER") > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkGetLeavePass(String employeeId, String leaveType, String month) {
        try {


            String sql = "SELECT COUNT(*) AS COUNTER " +
                    "FROM HR_EMP_LEAVE " +
                    "WHERE EMP_ID    ='" + employeeId + "' " +
                    "AND LEAVE_TYPE  ='" + leaveType + "' " +
                    "AND STATUS LIKE 'App%' " +
                    "AND SUBSTR(REQUESTED_DATE,1,7)='" + month + "'";


            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNTER") > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HashMap> selectSickLeaves(String empId, String year) {
        ArrayList<HashMap> readUsedLeave = new ArrayList<HashMap>();
        HashMap usedLeave = null;
        String _select = "SELECT leave_days " +
                "FROM HR_EMP_LEAVE " +
                "WHERE LEAVE_TYPE='7' " +
                "AND EMP_ID      =? " +
                "AND status LIKE 'App%' " +
                "AND SUBSTR(REQUESTED_TO_DATE, 0, 4)=?";


        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            Connection conn = getConnection();
            _ps = conn.prepareStatement(_select);
            _ps.setString(1, empId);
            _ps.setString(2, year);
            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            while (ocrs.next()) {
                usedLeave = new HashMap();
                usedLeave.put("leave_days", ocrs.getString("leave_days"));
                readUsedLeave.add(usedLeave);
            }
            closePooledConnections(conn);
            return readUsedLeave;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> checkDathOfRelative(String empId, String year) {
        ArrayList<HashMap> readUsedLeave = new ArrayList<HashMap>();
        HashMap usedLeave = null;
        String _select = "SELECT LEAVE_DAYS, " +
                "  EMP_ID " +
                "FROM HR_EMP_LEAVE " +
                "WHERE status LIKE 'App%' " +
                "AND EMP_ID                                     ='" + empId + "' " +
                "AND to_date(REQUESTED_FROM_DATE,'yyyy-mm-dd') >= to_date('" + year + "-07-01','yyyy-mm-dd') " +
                "AND LEAVE_TYPE                                 ='21'";
        try {

            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            Connection conn = getConnection();
            _ps = conn.prepareStatement(_select);

            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            while (ocrs.next()) {
                usedLeave = new HashMap();
                usedLeave.put("leave_days", ocrs.getString("leave_days"));
                readUsedLeave.add(usedLeave);
            }
            closePooledConnections(conn);
            return readUsedLeave;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException*/
    public ResultSet selectProcessedLeaveRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT LP.REQUEST_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  LP.PROCESSED_BY , " +
                "  LP.RECORDED_BY, " +
                "  LP.DECISION, " +
                "  LP.TIME_STAMP, " +
                "  LP.COMMENT_GIVEN, " +
                "  EP.FIRST_NAME, " +
                "  EP.MIDDLE_NAME, " +
                "  EP.LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_LEAVE_PROCESSED LP, " +
                "  HR_EMPLOYEE_INFO EP, " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE REQUEST_ID                = " + requestId + "  " +
                " AND EP.EMP_ID                   =LP.PROCESSED_BY " +
                " AND BIB.TBL_USERS.EMPLOYEE_ID=LP.RECORDED_BY " +
                " AND BIB.TBL_PERMISSION.CODE  =LP.DECISION " +
                " ORDER BY LP.TIME_STAMP ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> getEmployeeRegisterLeave(String leaveRequestId) {
        String _selectQuery = "SELECT FROMLEAVE, " +
                "  LEAVEIDES , " +
                "  PHYSICAL_YEAR , " +
                "  LEAVE_DAYS  " +
                "FROM HR_EMP_LEAVE_STATUS " +
                "WHERE LEAVE_ID=? " +
                "ORDER BY LEAVE_DAYS DESC";

        try {
            ArrayList<HashMap> listOfRequestLeave = new ArrayList<HashMap>();
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, leaveRequestId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("FROMLEAVE", _rs.getString("FROMLEAVE"));
                hm.put("LEAVEIDES", _rs.getString("LEAVEIDES"));
                hm.put("PHYSICAL_YEAR", _rs.getString("PHYSICAL_YEAR"));
                hm.put("LEAVE_DAYS", _rs.getString("LEAVE_DAYS"));
                listOfRequestLeave.add(hm);
            }
            return listOfRequestLeave;
        } catch (Exception e) {

            e.printStackTrace();
            return null;
        }

    }

    public boolean updateLeaveBank(String leaveId, float usedLeave) {
        String _updateQuery = "UPDATE HR_EMP_LEAVE_BANK " +
                "SET USEDLEAVE = " +
                "  (SELECT USEDLEAVE  -   " + usedLeave + " FROM HR_EMP_LEAVE_BANK WHERE ID='" + leaveId + "'  )" +
                "WHERE ID='" + leaveId + "'";
        try {
            _con.setAutoCommit(false);
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            if (_ps.executeUpdate() > 0) {
                _con.commit();
                return true;
            } else {
                _con.rollback();
                return false;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean updatReservLeave(String leave, int usedLeave) {
        String _updateQuery = "UPDATE HR_EMP_LEAVE_BANK " +
                "SET USEDLEAVE = " +
                "  (SELECT USEDLEAVE FROM HR_EMP_LEAVE_BANK WHERE ID='" + leave + "' - " + usedLeave + ") " +
                "WHERE ID='" + leave + "'";
        try {
//            OracleCachedRowSet xx=new OracleCachedRowSet();
//            xx.populate(_rs)
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.executeUpdate();
            if (_ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public void call(Collection<Object> var) {
        if (var == null) {
            new LeaveRequestEntity();
        }
    }
}
