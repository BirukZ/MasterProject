/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.salaryDelegationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.salaryDelegationManager.SalaryDelegationApproveManager;
import manager.salaryDelegationManager.SalaryDelegationRequestManager.SalaryDelegationRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class SalaryDelegationRequestEntity extends ConnectionManager {

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

    public boolean insertSalaryDelegationRequest(SalaryDelegationRequestModel requestAttributes) throws SQLException {
        String _insertRequestAttributeQuery = "INSERT INTO HR_SALARY_DELEGATION_REQUEST " +
                " (SALARY_DELEGATION_REQUEST_ID,DELEGATOR_ID,DELEGATEE_ID,APPLIED_DATE,START_DATE,END_DATE," +
                " DELEGATED_ITEMS,REASON, DOC_REFERENCE_NUMBER,STATUS,TIME_STAMP,USER_NAME)" +
                "  VALUES (HR_SALARY_DEL_REQUEST_SEQ.NEXTVAL," +
                " ?,?,?,?,?,?,?,?,?,?,?) ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_insertRequestAttributeQuery);
            _ps.setString(1, requestAttributes.getDelegatorId());
            _ps.setString(2, requestAttributes.getDelegateeId());
            _ps.setString(3, requestAttributes.getAppliedDate());
            _ps.setString(4, requestAttributes.getStartDate());
            _ps.setString(5, requestAttributes.getEndDate());
            _ps.setString(6, requestAttributes.getDelegaredItems());
            _ps.setString(7, requestAttributes.getReason());
            _ps.setString(8, requestAttributes.getDocReferenceNumber());
            _ps.setString(9, requestAttributes.getStatus());
            _ps.setString(10, requestAttributes.getTimeStamp());
            _ps.setString(11, requestAttributes.getUserName());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public int updateSalaryDelegationRequestAttributes(SalaryDelegationRequestModel requestAttributes) throws SQLException {
        String _updateRequestAttributeQuery = "UPDATE HR_SALARY_DELEGATION_REQUEST  SET " +
                " DELEGATOR_ID = ? ,DELEGATEE_ID = ? ,APPLIED_DATE = ? ,START_DATE = ? ,END_DATE = ? ," +
                " DELEGATED_ITEMS = ?, REASON = ? ,DOC_REFERENCE_NUMBER = ? ,STATUS = ? ,TIME_STAMP = ? ,USER_NAME = ? " +
                " WHERE SALARY_DELEGATION_REQUEST_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateRequestAttributeQuery);
            _ps.setString(1, requestAttributes.getDelegatorId());
            _ps.setString(2, requestAttributes.getDelegateeId());
            _ps.setString(3, requestAttributes.getAppliedDate());
            _ps.setString(4, requestAttributes.getStartDate());
            _ps.setString(5, requestAttributes.getEndDate());

            _ps.setString(6, requestAttributes.getDelegaredItems());
            _ps.setString(7, requestAttributes.getReason());
            _ps.setString(8, requestAttributes.getDocReferenceNumber());
            _ps.setString(9, requestAttributes.getStatus());
            _ps.setString(10, requestAttributes.getTimeStamp());
            _ps.setString(11, requestAttributes.getUserName());
            _ps.setInt(12, requestAttributes.getSalaryDelegationRequestId());
            _ps.executeUpdate();
            return 1;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteSalaryDelegationRequest(int requestId) throws SQLException {
        String _deleteRequestQuery = "DELETE HR_SALARY_DELEGATION_REQUEST " +
                " where SALARY_DELEGATION_REQUEST_ID =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteRequestQuery);
            _ps.setInt(1, requestId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectSalaryDelegationRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_SALARY_DELEGATION_REQUEST" +
                " WHERE SALARY_DELEGATION_REQUEST_ID= ?";
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

    public ResultSet selectMyRequestsHistory(String employeeId, String userName) throws SQLException {

        String _selectQuery = " SELECT * FROM HR_SALARY_DELEGATION_REQUEST " +
                " WHERE " +
                //                " (  DELEGATOR_ID LIKE ?    OR  USER_NAME IN (select USER_NAME from BIB.tbl_users where EMPLOYEE_ID  like ?  ) ) " +
                " STATUS NOT LIKE '" + SalaryDelegationApproveManager.INITIAL_STATE_SALARY_DELEGATION + "' " +
                " AND  (  DELEGATOR_ID = ?    OR  USER_NAME = ? ) " +
                " ORDER BY SALARY_DELEGATION_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, employeeId);
            _ps.setString(2, userName);
//            _ps.setString(3, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingRequests(String requesterId) throws SQLException {
       
        String _selectQuery = " SELECT * FROM HR_SALARY_DELEGATION_REQUEST " +
                " WHERE  ( DELEGATOR_ID LIKE ?  OR  DELEGATEE_ID LIKE ? " +
                " OR USER_NAME IN (select USER_NAME from BIB.tbl_users where EMPLOYEE_ID=? ))" +
                " AND  STATUS = ? " +
                " ORDER BY SALARY_DELEGATION_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _ps.setString(3, requesterId);
            _ps.setString(4, SalaryDelegationApproveManager.INITIAL_STATE_SALARY_DELEGATION);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
