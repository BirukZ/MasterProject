/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import manager.recruitmentManager.RecruitmentApproveManager;
import manager.recruitmentManager.RecruitmentApproveManager.RecruitmentDecisionModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class RecruitmentApproveEntity extends ConnectionManager {

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

    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        //select process's possible states for that user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + RecruitmentApproveManager.PROCESS_RECRUITMENT + "'))";
        String _selectQuery = "SELECT * FROM HR_RECRUITMENT_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ")";

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

    public ResultSet selectMyDecisionsOnRequest(String userName) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_RECRUITMENT_REQUEST WHERE RECRUIT_REQUEST_ID  IN " +
                "( SELECT REQUEST_ID FROM HR_RECRUITMENT_PROCESSED WHERE RECORDED_BY =?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean insertRecruitmentTimeDecision(RecruitmentDecisionModel recruitmentDecisionModel) {
        String _insertQuery = "INSERT INTO HR_RECRUITMENT_PROCESSED " +
                " (RECRUITMENT_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_RECRUITMENT_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_RECRUITMENT_REQUEST SET REQUEST_STATUS=? WHERE RECRUIT_REQUEST_ID=?";
        String _updateQuery2 = "UPDATE HR_RECRUITMENT_REQUEST_STATUS SET RECRUITMENT_REQUEST_STATUS.APPROVE='1' WHERE RECRUIT_REQUEST_ID='" + recruitmentDecisionModel.getrecruitmentRequestId() + "'";

        try {
            Savepoint a = null;
            _con = getConnection();
            _con.setAutoCommit(false);
            a = _con.setSavepoint("savepoint_1");
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, recruitmentDecisionModel.getrecruitmentRequestId());
            _ps.setString(2, recruitmentDecisionModel.getProcessedBy());
            _ps.setString(3, recruitmentDecisionModel.getDecision());
            _ps.setString(4, recruitmentDecisionModel.getCommentGiven());
            _ps.setString(5, recruitmentDecisionModel.getRecordedBy());
            _ps.setString(6, recruitmentDecisionModel.getRecorededDateAndTime());
            int row1 = _ps.executeUpdate();
            if (row1 == 1) {
                _ps = _con.prepareStatement(_updateQuery);
                _ps.setString(1, recruitmentDecisionModel.getNextState());
                _ps.setInt(2, recruitmentDecisionModel.getrecruitmentRequestId());
                row1 = _ps.executeUpdate();
                if (row1 == 1) {
                    if (recruitmentDecisionModel.getDecision() == "6") {
                        _ps = _con.prepareStatement(_updateQuery2);
                        _ps.executeUpdate();
                        _con.commit();
                        _con.setAutoCommit(true);

                    } else {
                        _con.commit();
                        _con.setAutoCommit(true);

                    }
                }
                return true;
            } else {
                _con.rollback(a);
                _con.setAutoCommit(true);
                return false;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;


        }
    }

    public ResultSet selectProcessedRecruitmentRequest(
            int requestId) throws SQLException {
        String _selectQuery = "SELECT REQUEST_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_RECRUITMENT_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                "AND BIB.TBL_PERMISSION.CODE=DECISION " +
                "ORDER BY TIME_STAMP";
        try {
            _con = getConnection();
            _ps =
                    _con.prepareStatement(_selectQuery);
            _rs =
                    _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
