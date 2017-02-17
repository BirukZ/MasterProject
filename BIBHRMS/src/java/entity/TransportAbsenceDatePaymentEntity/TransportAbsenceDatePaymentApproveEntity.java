/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.TransportAbsenceDatePaymentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.TransportAbsenceDatePaymentManager.TransportAbsenceDatePaymentApproveManager;
import manager.TransportAbsenceDatePaymentManager.TransportPaymentsModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Henok
 */
public class TransportAbsenceDatePaymentApproveEntity extends ConnectionManager {
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
    public ResultSet selectProcessedTransportPaymentRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT REQUEST_ID, " +
                "  mugher.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                //   "  NEXT_STATE AS DECISION, " +
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_TRANSPORT_PAYMENT_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                "AND mugher.TBL_PERMISSION.CODE=DECISION " +
                "ORDER BY TIME_STAMP";
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

    public ResultSet selectPendingRequests(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE  (REQUESTER_ID= ?" +
                " OR USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID=? ))" +
                " AND  REQUEST_STATUS = ? " +
                " ORDER BY TRANSPORT_PAYMENT_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _ps.setString(3, TransportAbsenceDatePaymentApproveManager.INITIAL_STATE_TRANSPORT_PAYMENT);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectMyRequestsHistory(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE " +
                " ( REQUESTER_ID like ?  OR  USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID  like ?  ) ) " +
                " AND REQUEST_STATUS not like " + TransportAbsenceDatePaymentApproveManager.INITIAL_STATE_TRANSPORT_PAYMENT +
                " ORDER BY TRANSPORT_PAYMENT_REQUEST_ID DESC";
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

    public ResultSet selectEmployeeAndTransportPaymentList(int requestId) throws SQLException {
        String _selectQuery = " SELECT TRANSPORT_PAYMENT_EMP_ID, TRANSPORT_PAYMENT_REQUEST_ID, EMPLOYEE_ID, S_ABSENT_DATE, E_ABSENT_DATE, TARIF_PER_DAY, PAYMENT_FOR_S_ABSENT, DAYS_IN_MONTH, TOTAL_E_ABSENT_DAYS, EXTRA_PAYMENT_PER_DAY, TOTAL_EXTRA_PAYMENT, TOTAL_PAYMENT, SERVICE_DESTINATION, " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FIRST_NAME,MIDDLE_NAME,LAST_NAME, DEPARTMENT_NAME " +
                " FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST  , HR_TRANSPORT_PAYMENT_EMP_LIST  " +
                " WHERE   EMPLOYEE_ID=EMP_ID" +
                " and TRANSPORT_PAYMENT_REQUEST_ID= " + requestId+" " +
                " ORDER BY SERVICE_DESTINATION ASC";
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
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE TRANSPORT_PAYMENT_REQUEST_ID = ? ";
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

    public boolean insertDecision(TransportPaymentsModel decision, String startDate, String endDate) throws SQLException {
        String _insertQuery = "INSERT INTO HR_TRANSPORT_PAYMENT_PROCESSED " +
                " (HR_TRANSP_PAYMENT_PROCESS_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_TRANSP_PAY_PROC_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_TRANSPORT_PAYMENT_REQUEST SET REQUEST_STATUS = ? , START_DATE = ?, END_DATE = ? WHERE TRANSPORT_PAYMENT_REQUEST_ID=?";
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, decision.getRequestID());
            _ps.setString(2, decision.getProcessedBy());
            _ps.setString(3, decision.getDecision());
            _ps.setString(4, decision.getComment());
            _ps.setString(5, decision.getUn());
            _ps.setString(6, decision.getRecordDate());
            _ps.executeUpdate();
//            Savepoint firstSavePoint = _con.setSavepoint();
//            _con.setAutoCommit(false);
//            try {
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, decision.getNextDate());
            _ps.setString(2, startDate);
            _ps.setString(3, endDate);
            _ps.setInt(4, decision.getRequestID());
            _ps.executeUpdate();
//                _con.setAutoCommit(true);
//            } catch (SQLException ex) {
//                _con.rollback(firstSavePoint);
//            }
            return true;
        } finally {
            releaseResources();
        }
    }

//    public int updateSelectedEmployeeStatus(ArrayList<TransportAbsenceDatePaymentModel>  employeeList) throws SQLException {
//        String _updateQuery = "UPDATE HR_TRAIN_NEED_ASSMT_EMP_LIST " +
//                " SET SELECTED_OR_NOT = ? " +
//                " WHERE TRAIN_NEED_ASSESS_EMP_LIST_ID =?";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_updateQuery);
//            for (TransportAbsenceDatePaymentModel currentEmployee : employeeList) {
//                _ps.setString(1, currentEmployee.isSelected() ? "YES" : "NO");
//                _ps.setInt(2, currentEmployee.getTrainingParticipantId());
//                _ps.addBatch();
//            }
//            _ps.executeBatch();
//            _ps.clearBatch();
//            _ps.close();
//            return 1;
//
//        } finally {
//            releaseResources();
//        }
//    }

}
