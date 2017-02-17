/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.powerDeligationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import javax.swing.JOptionPane;
import manager.powerDeligationManager.PowerDeligationApproveManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class PowerDeligationApproveEntity
        extends ConnectionManager {

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
    private int powDelProcessedId;//@Column(name = "POW_DEL_PROCESSED_ID")
    private int powDelReqId; //@Column(name = "POW_DEL_REQ_ID")
    private String proceesedBy;//@Column(name = "PROCESSED_BY")
    private String nextState;//   @Column(name = "NEXT_STATE")
    private String recordedBy;//  @Column(name = "RECORDED_BY")
    private String recordedDate;//  @Column(name = "RECORDED_DATE")
    private String commentGiven;// @Column(name = "COMMENT_GIVEN")
    private String decision;
    private String nextStateExternal;

    public PowerDeligationApproveEntity(int powDelReqId, String proceesedBy, String nextState, String recordedBy, String recordedDate, String commentGiven) {
        this.powDelReqId = powDelReqId;
        this.proceesedBy = proceesedBy;
        this.nextState = nextState;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
        this.commentGiven = commentGiven;
    }

    public PowerDeligationApproveEntity(int powDelReqId, String proceesedBy, String decision, String nextState, String recordedBy, String recordedDate, String commentGiven, String nextStateExternal) {
        this.powDelReqId = powDelReqId;
        this.proceesedBy = proceesedBy;
        this.nextState = nextState;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
        this.commentGiven = commentGiven;
        this.decision = decision;
        this.nextStateExternal = nextStateExternal;
    }

    public PowerDeligationApproveEntity(int powDelProcessedId, int powDelReqId, String proceesedBy, String nextState, String recordedBy, String recordedDate, String commentGiven) {
        this(powDelReqId, proceesedBy, nextState, recordedBy, recordedDate, commentGiven);
        this.powDelProcessedId = powDelProcessedId;
    }

    public PowerDeligationApproveEntity() {
    }

    /**
     * Inserts PowerDeligationDecision attribute to the database.<br>
     * The constructor with full argument, must be called before calling this method
     */
    public boolean insertPowerDeligationDecision(boolean external) throws SQLException {
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        String _insertQuery = " INSERT INTO HR_POWER_DELIGATION_PROCESSED " +
                " (POW_DEL_PROCESSED_ID,POW_DEL_REQ_ID, PROCESSED_BY,NEXT_STATE," +
                " RECORDED_BY, RECORDED_DATE, COMMENT_GIVEN)" +
                " VALUES (HR_POWER_DEL_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";

        String _insertExternalQuery = "INSERT INTO HR_POWER_DELIGATION_PROCESSED " +
                " (POW_DEL_PROCESSED_ID,POW_DEL_REQ_ID, PROCESSED_BY,EXTERNAL_NEXT_STATE," +
                " RECORDED_BY, RECORDED_DATE, COMMENT_GIVEN)" +
                " VALUES (HR_POWER_DEL_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?) ";

        String _updateQuery = " UPDATE HR_POWER_DELIGATION_REQUEST SET DELIGATION_STATUS=? WHERE POW_DEL_REQ_ID=? ";
        String _updateExternalQuery = " UPDATE HR_POWER_DELIGATION_REQUEST SET EXTERNAL_DELEGATION_STATUS=? WHERE POW_DEL_REQ_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);


            if (external) {
                _ps2 = _con.prepareStatement(_insertExternalQuery);
                _ps2.setInt(1, powDelReqId);
                _ps2.setString(2, proceesedBy);
                _ps2.setString(3, decision);
                _ps2.setString(4, recordedBy);
                _ps2.setString(5, recordedDate);
                _ps2.setString(6, commentGiven);

                _ps2.executeUpdate();
                _ps3 = _con.prepareStatement(_updateExternalQuery);
                _ps3.setString(1, nextStateExternal);
                _ps3.setInt(2, powDelReqId);
                _ps3.executeUpdate();
            } else {
                _ps.setInt(1, powDelReqId);
                _ps.setString(2, proceesedBy);
                _ps.setString(3, decision);
                _ps.setString(4, recordedBy);
                _ps.setString(5, recordedDate);
                _ps.setString(6, commentGiven);
                _ps.executeUpdate();
                _ps = _con.prepareStatement(_updateQuery);
                _ps.setString(1, nextState);
                _ps.setInt(2, powDelReqId);
                _ps.executeUpdate();
            }
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * Updates PowerDeligationRequest attribute  the database.<br>
     * The constructor with full argument must be called before this method
     */
    public int updatePowerDeligationDecision() throws SQLException {
        String _insertQuery = " UPDATE HR_POWER_DELIGATION_PROCESSED " +
                " POW_DEL_REQ_ID=?,      PROCESSED_BY=?,      NEXT_STATE=?," +
                " RECORDED_BY=?, RECORDED_DATE=?, COMMENT_GIVEN=?," +
                " WHERE POW_DEL_PROCESSED_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, powDelReqId);
            _ps.setString(2, proceesedBy);
            _ps.setString(3, nextState);
            _ps.setString(4, recordedBy);
            _ps.setString(5, recordedDate);
            _ps.setString(6, commentGiven);
            _ps.setInt(7, powDelProcessedId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of processed requests with their current status<br>
     * Basically intended to show the history of a  given power deligation request.
     * @param  the status of the request
     * @throws  SQLException
     */
    public ResultSet selectProcessedDeligationRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT POW_DEL_REQ_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                "  NEXT_STATE    AS DECISION , " +
                "  RECORDED_DATE AS TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_POWER_DELIGATION_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE POW_DEL_REQ_ID          = ? " +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                "AND BIB.TBL_PERMISSION.CODE=NEXT_STATE " +
                "ORDER BY PROCESSED_BY";

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

    public ResultSet selectProcessedDeligationRequestExternal(int requestId) throws SQLException {
        String _selectQuery = "SELECT POW_DEL_REQ_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                "  NEXT_STATE    AS DECISION , " +
                "  RECORDED_DATE AS TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                " FROM HR_POWER_DELIGATION_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                " WHERE POW_DEL_REQ_ID          = ? " +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                " AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                " AND BIB.Tbl_Permission.Code=EXTERNAL_NEXT_STATE" +
                " ORDER BY PROCESSED_BY";
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

    public ResultSet selectAllMyPrevieousDecisions(String approverUserName) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_POWER_DELIGATION_REQUEST " +
                " WHERE POW_DEL_REQ_ID IN " +
                " ( " +
                "       SELECT POW_DEL_REQ_ID " +
                "       FROM HR_POWER_DELIGATION_PROCESSED " +
                "       WHERE RECORDED_BY = ?  or" +
                "       PROCESSED_BY IN (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME =? )" +
                "  )" +
                " ORDER BY TIME_STAMP DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, approverUserName);
            _ps.setString(2, approverUserName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllBenefitPakage(int PositionID) throws SQLException {
        String _selectQuery = "SELECT hlub.benefit_name, " +
                "  hlub.benefit_duration, " +
                "  hlub.benefit_value, " +
                "  hlub.benefit_duration, " +
                "  hlub.in_percent, " +
                "  hlub.percent, " +
                "  hlbp.BENEFIT_TYPE_ID, " +
                "  hlbp.amount_of_birr, " +
                "  hlbp.POSITION_ID " +
                " FROM hr_lu_benefit_types hlub " +
                " INNER JOIN HR_LU_BENEFIT_POSITION hlbp " +
                " ON hlbp.benefit_type_id=hlub.benefit_type_id " +
                " WHERE hlbp.position_id =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, PositionID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * Retrives power deligation requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =5 for the porcess power deligation
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName, boolean chechRole) throws SQLException {
        //select process's possible states for that user in the process Power deligation
        String _innerSelectQuery = " select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from  BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where PROCESS_ID='" + PowerDeligationApproveManager.PROCESS_POWER_DELIGATION + "'))";

        String _innerSelectExternalQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from  BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where PROCESS_ID='" + PowerDeligationApproveManager.PROCESS_OTHER_POWER_DELIGATION + "'))";

        String _selectQuery = " SELECT * FROM HR_POWER_DELIGATION_REQUEST WHERE DELIGATION_STATUS  IN (" + _innerSelectQuery + ") ORDER BY TIME_STAMP DESC ";
        String _selectExternalQuery = " SELECT * FROM HR_POWER_DELIGATION_REQUEST WHERE DELIGATION_STATUS IN (" + _innerSelectQuery + ")" + " Or EXTERNAL_DELEGATION_STATUS  IN (" + _innerSelectExternalQuery + ") ORDER BY TIME_STAMP DESC";
        //  String _selectExternalQuery = " SELECT * FROM HR_POWER_DELIGATION_REQUEST  WHERE EXTERNAL_DELEGATION_STATUS  IN (" + _innerSelectExternalQuery + ") ORDER BY TIME_STAMP DESC";

        try {
            _con = getConnection();

            if (chechRole) {
                _ps = _con.prepareStatement(_selectQuery);
                _rs = _ps.executeQuery();
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                return (ResultSet) ocrs;
            } else {
                _ps = _con.prepareStatement(_selectExternalQuery);
                _rs = _ps.executeQuery();
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                return (ResultSet) ocrs;
            }

        } finally {
            releaseResources();
        }
    }

    /**POW_DEL_PROCESSED_ID
    POW_DEL_REQ_ID
    PROCESSED_BY
    NEXT_STATE
    RECORDED_BY
    RECORDED_DATE
    COMMENT_GIVEN*/
    public ResultSet selectProcessedRequestsHistory(int requestId) throws SQLException {
        String _selectQuery = "SELECT POW_DEL_REQ_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                "  DECISION, " +
                "  RECORDED_DATE AS TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_OVER_TIME_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_PERMISSION , " +
                "  BIB.TBL_USERS " +
                "WHERE POW_DEL_REQ_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                "AND BIB.TBL_PERMISSION.CODE=DECISION " +
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

    public ResultSet selectNextState(String processStateId) throws SQLException {
        //select process's possible states for that user in the process Power deligation

        String _selectQuery = "SELECT PROCESS_STATE_ID,CAN_BE_FINAL FROM BIB.TBL_PROCESS_STATE WHERE PROCESS_ID=" + PowerDeligationApproveManager.PROCESS_POWER_DELIGATION + " AND PREVIES_PROCESS_STATE_ID=" + processStateId;

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
