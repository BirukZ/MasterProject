/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.documentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import manager.documentRequestManager.DocumentApproveManager;
import manager.documentRequestManager.DocumentApproveManager.DecisionMadeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class DocumentApproveEntity extends ConnectionManager {

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

    public ResultSet selectProcessedDocumentRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT REQUEST_ID, PROCESSED_BY ,RECORDED_BY, DECISION, TIME_STAMP, COMMENT_GIVEN," +
                " mugher.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID," +
                " FIRST_NAME, MIDDLE_NAME, LAST_NAME ,PERMISSION_NAME" +
                " FROM HR_DOCUMENT_REQUEST_PROCESSED ,HR_EMPLOYEE_INFO ,mugher.TBL_PERMISSION,mugher.TBL_USERS " +
                " WHERE REQUEST_ID=" + requestId +
                " AND HR_EMPLOYEE_INFO.EMP_ID=PROCESSED_BY " +
                " AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                " AND mugher.TBL_PERMISSION.CODE=DECISION" +
                " ORDER BY TIME_STAMP";
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

    public ResultSet selectEmployeeExperience(String empId) throws SQLException {
        String selectSql = "SELECT P.PREV_JOB_POSITION, J.JOB_DESCRIPTION AS OLDJOBDESC, P.PREV_RANK, R.RANK_DESCRIPTION AS OLDRANKDESC,  " +
                "P.PREV_SALARY, P.PROMOTION_DATE, E.JOB_CODE as newJob, JF.JOB_DESCRIPTION as newJobDesc, E.RANK_ID as newRank, E.SALARY as newSalary, E.HIRE_DATE    " +
                "FROM HR_PROMOTION_HISTORY P, HR_EMPLOYEE_INFO E, HR_LU_JOB_TYPE J,  " +
                "HR_LU_JOB_TYPE JF, HR_LU_RANK R  " +
                "WHERE P.EMPLOYEE_ID = '" + empId + "' AND P.EMPLOYEE_ID = E.EMP_ID   " +
                "AND J.JOB_CODE = P.PREV_JOB_POSITION AND R.RANK_ID = P.PREV_RANK AND JF.JOB_CODE = E.JOB_CODE  " +
                "ORDER BY P.PROMOTION_DATE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectSql, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return (ResultSet) ocrs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  mugher.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from mugher.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + DocumentApproveManager.PROCESS_DOCUMENT + "'))";

        String _selectQuery = "SELECT * FROM HR_DOCUMENT_REQUEST WHERE STATUS  IN (" + _innerSelectQuery + ")";

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

    public ResultSet selectProcessedRequestsHistory(String userName) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_DOCUMENT_REQUEST WHERE DOCUMENT_REQUEST_ID" +
                "  IN ( SELECT REQUEST_ID FROM HR_DOCUMENT_REQUEST_PROCESSED WHERE RECORDED_BY=?) " +
                " ORDER BY DOCUMENT_REQUEST_ID DESC ";
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

    public boolean insertDocumentDecision(DecisionMadeModel decisionMadeModel) throws SQLException {

        String _insertQuery = "INSERT INTO HR_DOCUMENT_REQUEST_PROCESSED " +
                " (DOCUMENT_REQUEST_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                " COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (HR_DOCUMENT_REQ_PROCESSED_SEQ.NEXTVAL, ?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_DOCUMENT_REQUEST SET STATUS=? WHERE DOCUMENT_REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            //(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime)
            _ps.setInt(1, decisionMadeModel.getRequestId());
            _ps.setString(2, decisionMadeModel.getProcessedBy());
            _ps.setString(3, decisionMadeModel.getDecision());//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(4, decisionMadeModel.getCommentGiven());
            _ps.setString(5, decisionMadeModel.getRecordedBy());
            _ps.setString(6, decisionMadeModel.getTimeStamp());
            //    Savepoint firstSavePoint = _con.setSavepoint();
// _con.setAutoCommit(false);
// try {
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, decisionMadeModel.getNextState()); //status inserted to HR_LEAVE_REQUEST table
            _ps.setInt(2, decisionMadeModel.getRequestId());
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

    public boolean updateDocReturnStatus(String docReturn, int docReqId) throws SQLException {
        boolean updated = false;
        String updateDocReturn = "UPDATE HR_DOCUMENT_REQUEST SET GUARANTEE_DOC_STATUS = ? WHERE DOCUMENT_REQUEST_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(updateDocReturn);
            //(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime)
            _ps.setString(1, docReturn);
            _ps.setInt(2, docReqId);

            if (_ps.executeUpdate() != 0) {
                updated = true;
            }
            return updated;
        } finally {
            releaseResources();
        }
    }
}
