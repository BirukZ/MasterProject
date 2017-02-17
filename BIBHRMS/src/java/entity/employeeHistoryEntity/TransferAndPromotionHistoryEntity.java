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
import manager.employeeHistoryManager.TransferAndPromotionHistoryModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Mugher
 */
public class TransferAndPromotionHistoryEntity extends ConnectionManager {

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

    public boolean insertTransferAndPromotionHistory(ArrayList<TransferAndPromotionHistoryModel> committeeMemberList) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_PROMOTION_HISTORY " +
                " ( PROMOTION_HISTORY_ID,EMPLOYEE_ID,REQUESTER_DEPARTMENT,PROMOTION_TYPE, " +
                " REASON,PREV_JOB_POSITION,PREV_RANK,PREV_SALARY,  " +
                " NEW_JOB_POSITION,NEW_RANK,NEW_SALARY,ADV_NUMBER,PROMOTION_DATE, " +
                " COMPLETED_DATE,PROM_LETTER_NUMBER,REQUEST_DATE,REQUEST_LETTER_NUMBER,TIME_STAMP,USER_NAME)" +
                "VALUES(HR_PROMOTION_HISTORY_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (TransferAndPromotionHistoryModel currentData : committeeMemberList) {
                _ps.setString(1, currentData.getEmployeeId());
                _ps.setString(2, currentData.getRequesterDepartment());
                _ps.setString(3, currentData.getPromotionType());
                _ps.setString(4, currentData.getReason());

                _ps.setString(5, currentData.getPreviousJobPosition().split("--")[0]);
                _ps.setString(6, currentData.getPreviousRank());
                _ps.setString(7, currentData.getPreviousSalary());

                _ps.setString(8, currentData.getNewJobPosition().split("--")[0]);
                _ps.setString(9, currentData.getNewRank());
                _ps.setString(10, currentData.getNewSalary());

                _ps.setString(11, currentData.getAdvertisenmentNumber());
                _ps.setString(12, currentData.getPromotionDate());
                _ps.setString(13, currentData.getCompletedDate());
                _ps.setString(14, currentData.getPromotionLetterNumber());
                _ps.setString(15, currentData.getPromotionRequestLetterNumber());
                _ps.setString(16, currentData.getPromotionLetterNumber());
                _ps.setString(17, currentData.getTimeStamp());
                _ps.setString(18, currentData.getUserName());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTransferAndPromotionHistory(ArrayList<TransferAndPromotionHistoryModel> committeeMemberList) throws SQLException {
        String _updateQuery = "UPDATE  HR_PROMOTION_HISTORY SET " +
                " EMPLOYEE_ID = ? , REQUESTER_DEPARTMENT = ? , PROMOTION_TYPE = ? ,  " +
                " REASON = ? , PREV_JOB_POSITION = ? , PREV_RANK = ? , PREV_SALARY = ? ,   " +
                " NEW_JOB_POSITION = ? , NEW_RANK = ? , NEW_SALARY = ? , ADV_NUMBER = ? , PROMOTION_DATE = ? ,  " +
                " COMPLETED_DATE = ? , PROM_LETTER_NUMBER = ? ,REQUEST_LETTER_NUMBER =?, REQUEST_DATE = ?, " +
                " TIME_STAMP = ? , USER_NAME = ? " +
                " WHERE PROMOTION_HISTORY_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (TransferAndPromotionHistoryModel currentData : committeeMemberList) {
                _ps.setString(1, currentData.getEmployeeId());
                _ps.setString(2, currentData.getRequesterDepartment());
                _ps.setString(3, currentData.getPromotionType());
                _ps.setString(4, currentData.getReason());
                _ps.setString(5, currentData.getPreviousJobPosition().split("--")[0]);
                _ps.setString(6, currentData.getPreviousRank());
                _ps.setString(7, currentData.getPreviousSalary());
                _ps.setString(8, currentData.getNewJobPosition().split("--")[0]);
                _ps.setString(9, currentData.getNewRank());
                _ps.setString(10, currentData.getNewSalary());
                _ps.setString(11, currentData.getAdvertisenmentNumber());
                _ps.setString(12, currentData.getPromotionDate());
                _ps.setString(13, currentData.getPromotionRequestDate());
                _ps.setString(14, currentData.getCompletedDate());
                _ps.setString(15, currentData.getPromotionRequestLetterNumber());
                _ps.setString(16, currentData.getPromotionLetterNumber());
                _ps.setString(17, currentData.getTimeStamp());
                _ps.setString(18, currentData.getUserName());
                _ps.setInt(19, currentData.getTransferAndPromotionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTransferAndPromotionHistory(ArrayList<TransferAndPromotionHistoryModel> committeeMemberList) throws SQLException {
        String _insertCommitteeMemberQuery = "DELETE  HR_PROMOTION_HISTORY " +
                " WHERE PROMOTION_HISTORY_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertCommitteeMemberQuery);
            for (TransferAndPromotionHistoryModel currentData : committeeMemberList) {
                _ps.setInt(1, currentData.getTransferAndPromotionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTransferAndPromotionHistory(String employeeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_PROMOTION_HISTORY" +
                " WHERE  EMPLOYEE_ID  = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTransferAndPromotionTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PROMOTION_TRANSFER_TYPES";
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
     * This method should be declared in class DepartmentEntity.java
     */
    @Deprecated
    public ResultSet selectAllDepartments() throws SQLException {
        String _selectQuery = " SELECT * FROM TBL_DEPT_BUNNA";
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