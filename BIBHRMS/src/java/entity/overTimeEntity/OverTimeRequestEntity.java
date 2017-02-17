/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.overTimeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.overTimeManager.OverTimeApproveManager;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class OverTimeRequestEntity extends ConnectionManager {

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

    public int insertOverTimeRequest(OverTimeRequestModel requestAttributes, ArrayList<OverTimeRequestModel> employeeAndTimeList, String loggedInEmployeeId) throws SQLException {
        String _insertRequestAttributeQuery = "INSERT INTO HR_OVER_TIME_REQUEST " +
                " (OVER_TIME_REQUEST_ID,REQUESTER_ID,APPLIED_DATE," +
                // "  ADDRESS_CODE,OVER_TIME_FACTOR,REASON_SUMMARY, REASON,DOC_REFERENCE_NUMBER,STATUS,TIME_STAMP,USER_NAME)" +
                "  ADDRESS_CODE,REASON_SUMMARY, REASON,DOC_REFERENCE_NUMBER,STATUS,TIME_STAMP,USER_NAME,LOGIN_PERSON_ID)" +
                "  VALUES (HR_OVER_TIME_REQUEST_SEQ.NEXTVAL," +
                " ?,?,?,?,?,?,?,?,?,?) ";
        String _insertEmployeesListQuery = "INSERT INTO HR_OVER_TIME_EMPLOYEE " +
                //" (OVER_TIME_EMPLOYEE_ID,REQUEST_ID,EMPLOYEE_ID,START_DATE,START_TIME,END_DATE,END_TIME,OVER_TIME_FACTOR)" +
                " (OVER_TIME_EMPLOYEE_ID,REQUEST_ID,EMPLOYEE_ID,START_DATE,START_TIME,END_DATE,END_TIME,DAY_TYPE)" +
                " VALUES (HR_OVER_TIME_EMPLOYEE_SEQ.NEXTVAL, HR_OVER_TIME_REQUEST_SEQ.CURRVAL," +
                " ?,?,?,?,?,?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertRequestAttributeQuery);
            _ps.setString(1, requestAttributes.getRequesterId());
            _ps.setString(2, requestAttributes.getAppliedDate());
            _ps.setString(3, requestAttributes.getAddressCode());
            //  _ps.setDouble(4, requestAttributes.getOverTimeFactor());
            _ps.setInt(4, requestAttributes.getReasonSummary());
            _ps.setString(5, requestAttributes.getReasonDescription());
            _ps.setString(6, requestAttributes.getDocReferenceNumber());
            _ps.setString(7, requestAttributes.getStatus());
            _ps.setString(8, requestAttributes.getTimeStamp());
            _ps.setString(9, requestAttributes.getUserName());
            _ps.setString(10, loggedInEmployeeId);
            _ps.executeUpdate();

            //////////////////////////////////
            PreparedStatement _ps2 = _con.prepareStatement(_insertEmployeesListQuery);
            int lengthOfList = employeeAndTimeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps2.setString(1, employeeAndTimeList.get(counter).getEmployeeId());
                _ps2.setString(2, employeeAndTimeList.get(counter).getStartDate());
                _ps2.setString(3, employeeAndTimeList.get(counter).getStartTime());
                _ps2.setString(4, employeeAndTimeList.get(counter).getEndDate());
                _ps2.setString(5, employeeAndTimeList.get(counter).getEndTime());
                _ps2.setString(6, employeeAndTimeList.get(counter).getDayTipe());
                //   _ps2.setDouble(6, employeeAndTimeList.get(counter).getOverTimeFactor());
                _ps2.addBatch();
            }
            _ps2.executeBatch();
            _ps2.clearBatch();
            _ps2.close();
            return 1;

        } finally {
            releaseResources();
        }
    }

    public int updateOverTimeRequestAttributes(OverTimeRequestModel requestAttributes) throws SQLException {
        String _updateRequestAttributeQuery = "UPDATE HR_OVER_TIME_REQUEST  SET " +
                // " REQUESTER_ID =?, APPLIED_DATE=?, ADDRESS_CODE=?, OVER_TIME_FACTOR=?, REASON_SUMMARY = ? , REASON=?,DOC_REFERENCE_NUMBER=?, STATUS=?, TIME_STAMP=?, USER_NAME=? " +
                " REQUESTER_ID =?, APPLIED_DATE=?, ADDRESS_CODE=?, REASON_SUMMARY = ? , REASON=?,DOC_REFERENCE_NUMBER=?, STATUS=?, TIME_STAMP=?, USER_NAME=? " +
                " WHERE OVER_TIME_REQUEST_ID=? ";
        try {


            _con = getConnection();
            _ps = _con.prepareStatement(_updateRequestAttributeQuery);
            _ps.setString(1, requestAttributes.getRequesterId());
            _ps.setString(2, requestAttributes.getAppliedDate());
            _ps.setString(3, requestAttributes.getAddressCode());
            _ps.setInt(4, requestAttributes.getReasonSummary());
            _ps.setString(5, requestAttributes.getReasonDescription());
            _ps.setString(6, requestAttributes.getDocReferenceNumber());
            _ps.setString(7, requestAttributes.getStatus());
            _ps.setString(8, requestAttributes.getTimeStamp());
            _ps.setString(9, requestAttributes.getUserName());
            _ps.setInt(10, requestAttributes.getoverTimeRequestId());
            _ps.executeUpdate();
            return 1;
        } finally {
            releaseResources();
        }
    }

    public int insertOverTimeRequestAttendants(int overTimeRequestId, ArrayList<OverTimeRequestModel> employeeAndTimeList) throws SQLException {

        String _insertEmployeesListQuery = "INSERT INTO HR_OVER_TIME_EMPLOYEE " +
                //   " (OVER_TIME_EMPLOYEE_ID,REQUEST_ID,EMPLOYEE_ID,START_DATE,START_TIME,END_DATE,END_TIME,OVER_TIME_FACTOR)" +
                " (OVER_TIME_EMPLOYEE_ID,REQUEST_ID,EMPLOYEE_ID,START_DATE,START_TIME,END_DATE,END_TIME,DAY_TYPE)" +
                " VALUES (HR_OVER_TIME_EMPLOYEE_SEQ.NEXTVAL, " +
                " ?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertEmployeesListQuery);
            int lengthOfList = employeeAndTimeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setInt(1, overTimeRequestId);
                _ps.setString(2, employeeAndTimeList.get(counter).getEmployeeId());
                _ps.setString(3, employeeAndTimeList.get(counter).getStartDate());
                _ps.setString(4, employeeAndTimeList.get(counter).getStartTime());
                _ps.setString(5, employeeAndTimeList.get(counter).getEndDate());
                _ps.setString(6, employeeAndTimeList.get(counter).getEndTime());
                _ps.setString(7, employeeAndTimeList.get(counter).getDayTipe());
                //  _ps.setDouble(7, employeeAndTimeList.get(counter).getOverTimeFactor());
                _ps.addBatch();
            }
            _ps.executeBatch();
            _ps.clearBatch();
            _ps.close();
            return 1;

        } finally {
            releaseResources();
        }
    }

    public int updateOverTimeRequestAttendants(ArrayList<OverTimeRequestModel> employeeAndTimeList) throws SQLException {
        String _updateEmployeesListQuery = "UPDATE HR_OVER_TIME_EMPLOYEE " +
                //  " SET START_DATE=?, START_TIME=?, END_DATE =?, END_TIME=?, OVER_TIME_FACTOR=?)" +
                " SET START_DATE=?, START_TIME=?, END_DATE =?, END_TIME=?)" +
                " WHERE OVER_TIME_EMPLOYEE_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateEmployeesListQuery);
            int lengthOfList = employeeAndTimeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, employeeAndTimeList.get(counter).getStartDate());
                _ps.setString(2, employeeAndTimeList.get(counter).getStartTime());
                _ps.setString(3, employeeAndTimeList.get(counter).getEndDate());
                _ps.setString(4, employeeAndTimeList.get(counter).getEndTime());
                //      _ps.setDouble(5, employeeAndTimeList.get(counter).getOverTimeFactor());
                _ps.setInt(5, employeeAndTimeList.get(counter).getOverTimeEmployeeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            _ps.clearBatch();
            _ps.close();
            return 1;

        } finally {
            releaseResources();
        }
    }

    public int deleteOverTimeRequestAttendants(ArrayList<OverTimeRequestModel> employeeAndTimeList) throws SQLException {
        String _deleteEmployeesListQuery = "DELETE HR_OVER_TIME_EMPLOYEE " +
                " where OVER_TIME_EMPLOYEE_ID =? ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_deleteEmployeesListQuery);
            int lengthOfList = employeeAndTimeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, employeeAndTimeList.get(counter).getOverTimeEmployeeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            _ps.clearBatch();
            return 1;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEmployeeAndOverTimeList(int requestId) throws SQLException {
        String _selectQuery = " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, STATUS, " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FIRST_NAME,MIDDLE_NAME,LAST_NAME, DEPARTMENT_NAME " +
                " FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST  , HR_OVER_TIME_EMPLOYEE  " +
                " WHERE   EMPLOYEE_ID=EMP_ID" +
                " and REQUEST_ID= " + requestId;
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

    public ResultSet selectRequestAttributes(int requestId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_OVER_TIME_REQUEST " +
                " WHERE OVER_TIME_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingRequests(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_OVER_TIME_REQUEST " +
                " WHERE  (REQUESTER_ID= ?" +
                " OR USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID=? ))" +
                " AND  STATUS = ? " +
                " ORDER BY OVER_TIME_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _ps.setString(3, OverTimeApproveManager.INITIAL_STATE_OVERTIME);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectMyRequestsHistory(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_OVER_TIME_REQUEST " +
                " WHERE " +
                " ( REQUESTER_ID like ?  OR  USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID  like ?  ) ) " +
                " AND STATUS not like " + OverTimeApproveManager.INITIAL_STATE_OVERTIME +
                " ORDER BY OVER_TIME_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }



    public ResultSet selectAllOverTimeReasons() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_OVER_TIME_POSSIBLE_REASONS";
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

    public ResultSet selectRequestsReport(OverTimeRequestModel requestParameter) throws SQLException {
        String _selectQuery =
                "SELECT * FROM VW_OVER_TIME_REPORT , HR_OVER_TIME_EMPLOYEE " +
                "WHERE VW_OVER_TIME_REPORT.OVER_TIME_REQUEST_ID = HR_OVER_TIME_EMPLOYEE.REQUEST_ID " +
                "AND VW_OVER_TIME_REPORT.REQUESTER_ID         <= ? " +
                "AND VW_OVER_TIME_REPORT.REQUESTER_ID         >= ? " +
                "AND VW_OVER_TIME_REPORT.ADDRESS_CODE         <= ? " +
                "AND VW_OVER_TIME_REPORT.ADDRESS_CODE         >= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.START_DATE          >= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.END_DATE            <= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.START_TIME          >= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.END_TIME            <= ? " +
//                "AND HR_OVER_TIME_EMPLOYEE.OVER_TIME_FACTOR    <= ? " +
//                "AND HR_OVER_TIME_EMPLOYEE.OVER_TIME_FACTOR    >= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.EMPLOYEE_ID         <= ? " +
                "AND HR_OVER_TIME_EMPLOYEE.EMPLOYEE_ID         >= ? " +
                "AND VW_OVER_TIME_REPORT.REQUEST_STATUS IN (" + requestParameter.getStatus() + ")";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            //==========common parameters===================================
            _ps.setString(1, requestParameter.getRequesterId().equals("-1") ? "ZZ/00000" : requestParameter.getRequesterId());
            _ps.setString(2, requestParameter.getRequesterId().equals("-1") ? "AA/00000" : requestParameter.getRequesterId());
            _ps.setString(3, requestParameter.getAddressCode().equals("-1") ? "ZZ" : requestParameter.getAddressCode());
            _ps.setString(4, requestParameter.getAddressCode().equals("-1") ? "AA" : requestParameter.getAddressCode());
            //   _ps.setString(5, requestParameter.getStatus());

            //==========date and time=======================================
            _ps.setString(5, requestParameter.getStartDate().equals("-1") ? "1900-01-01" : requestParameter.getStartDate());//-1 means any
            _ps.setString(6, requestParameter.getEndDate().equals("-1") ? "3900-01-01" : requestParameter.getEndDate());//-1 means any
            _ps.setString(7, requestParameter.getStartTime().equals("-1") ? "00:00" : requestParameter.getStartTime());//-1 means any
            _ps.setString(8, requestParameter.getEndTime().equals("-1") ? "24:01" : requestParameter.getEndTime());//-1 means any
            //==========overtime factor and attendant=======================
//            _ps.setDouble(9, requestParameter.getOverTimeFactor() == -1 ? 10 : requestParameter.getOverTimeFactor());
//            _ps.setDouble(10, requestParameter.getOverTimeFactor() == -1 ? 0 : requestParameter.getOverTimeFactor());
            _ps.setString(91, requestParameter.getEmployeeId().equals("-1") ? "ZZ/99999" : requestParameter.getEmployeeId());//-1 means any
            _ps.setString(10, requestParameter.getEmployeeId().equals("-1") ? "AA/00000" : requestParameter.getEmployeeId());
            //================================================================
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectLoginId(int overTimeRequestId) throws SQLException {

        //select process's possible states for that user in the process Power deligation
        String _selectQuery = "select LOGIN_PERSON_ID from HR_OVER_TIME_REQUEST where OVER_TIME_REQUEST_ID ='" + overTimeRequestId+ "'";


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
}
