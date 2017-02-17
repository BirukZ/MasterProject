/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.terminationManager.TerminationApproveManager;
import manager.terminationManager.TerminationRequestManager.TerminationRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class TerminationRequestEntity
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
    private int terminationRequestId;//@Column(name = "TERMINATION_REQUEST_ID")
    private String requesterId;// @Column(name = "REQUESTER_ID")
    private String terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
    private String terminationType;// @Column(name = "TERMINATION_TYPE")
    private String requestStatus;// @Column(name = "REQUEST_STATUS")
    private String appliedDate;//@Column(name = "APPLIED_DATE")
    private String terminationDate;//  @Column(name = "TERMINATION_DATE")
    private String description;// @Column(name = "DESCRIPTION")
    private String isDocumeentAttached;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
    private String recordedBy;// @Column(name = "RECORDED_BY")
    private String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")

    public TerminationRequestEntity(int terminationRequestId, String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
        this(requesterId, terminationCatagory, terminationType, requestStatus, appliedDate, terminationDate, description, isDocumeentAttached, recordedBy, recorededDateAndTime);
        this.terminationRequestId = terminationRequestId;
    }

    public TerminationRequestEntity(String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
        this.requesterId = requesterId;
        this.terminationCatagory = terminationCatagory;
        this.terminationType = terminationType;
        this.requestStatus = requestStatus;
        this.appliedDate = appliedDate;
        this.terminationDate = terminationDate;
        this.description = description;
        this.isDocumeentAttached = isDocumeentAttached;
        this.recordedBy = recordedBy;
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public TerminationRequestEntity() {
    }

    /**
     * Inserts PowerDeligationRequest attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int insertTerminationRequest(TerminationRequestModel terminationRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_TERMINATION_REQUEST " +
                " (TERMINATION_REQUEST_ID,REQUESTER_ID, TERMINATION_CATAGORY,TERMINATION_TYPE," +
                " REQUEST_STATUS,APPLIED_DATE, TERMINATION_DATE," +
                " DESCRIPTION, IS_DOCUMEENT_ATTACHED,  RECORDED_BY,RECOREDED_DATE_AND_TIME,TREMINATOR_ID,REQUESTER_TYPE)" +
                " VALUES (HR_TERMINATION_REQUEST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, terminationRequestModel.getRequesterId());
            _ps.setInt(2, terminationRequestModel.getTerminationCatagory());
            _ps.setInt(3, terminationRequestModel.getTerminationType());
            _ps.setString(4, terminationRequestModel.getRequestStatus());
            _ps.setString(5, terminationRequestModel.getAppliedDate());
            _ps.setString(6, terminationRequestModel.getTerminationDate());
            _ps.setString(7, terminationRequestModel.getDescription());
            _ps.setString(8, terminationRequestModel.getDocumeentReferenceNumber());
            _ps.setString(9, terminationRequestModel.getRecordedBy());
            _ps.setString(10, terminationRequestModel.getRecorededDateAndTime());
            _ps.setString(11, terminationRequestModel.getTerminatorId());
            _ps.setString(12, terminationRequestModel.getRequesterType());
           
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Updates Termintion Request attribute of the database.<br>
     * The constructor with full argument must be called before this method
     * @see
     * @throws  SQLException
     */
    public int updateTerminationRequest(TerminationRequestModel terminationRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_TERMINATION_REQUEST " +
                " SET  REQUESTER_ID=?,     TERMINATION_CATAGORY=?,      TERMINATION_TYPE=?," +
                " REQUEST_STATUS=?, APPLIED_DATE=?, TERMINATION_DATE=?," +
                " DESCRIPTION=?, IS_DOCUMEENT_ATTACHED=?,  RECORDED_BY=?, RECOREDED_DATE_AND_TIME=?, TREMINATOR_ID=?, REQUESTER_TYPE=?, PENALITY_PAYMENT=?,HAS_ASUCCESIOR=?" +
                " where TERMINATION_REQUEST_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);

            _ps.setString(1, terminationRequestModel.getRequesterId());
            _ps.setInt(2, terminationRequestModel.getTerminationCatagory());
            _ps.setInt(3, terminationRequestModel.getTerminationType());
            _ps.setString(4, terminationRequestModel.getRequestStatus());
            _ps.setString(5, terminationRequestModel.getAppliedDate());
            _ps.setString(6, terminationRequestModel.getTerminationDate());
            _ps.setString(7, terminationRequestModel.getDescription());
            _ps.setString(8, terminationRequestModel.getDocumeentReferenceNumber());
            _ps.setString(9, terminationRequestModel.getRecordedBy());
            _ps.setString(10, terminationRequestModel.getRecorededDateAndTime());
            _ps.setString(11, terminationRequestModel.getTerminatorId());
            _ps.setString(12, terminationRequestModel.getRequesterType());
            _ps.setDouble(13, terminationRequestModel.getPenalityPay());
            _ps.setString(14, terminationRequestModel.getHasSuccesioser());
            _ps.setInt(15, terminationRequestModel.getTerminationRequestId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Deletes PowerDeligationRequest from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean deletePowerDeligationRequest(int requestId) throws SQLException {
        String _deleteQuery = "DELETE HR_TERMINATION_REQUEST  WHERE TERMINATION_REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, requestId);
            _ps.executeUpdate();
            return true;
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
    public ResultSet selectTerminationRequestFromId(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST WHERE TERMINATION_REQUEST_ID= " + requestId;
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
     * returns ResultSet object of a request Termination Types.<br>
     * For the termination catagory  passed as an argument
     * @param  terminationCatagory it is either resign or retirement
     * @throws  SQLException
     */
    public ResultSet selectTerminationTypes(int terminationCatagory) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_TERMINATION_TYPES WHERE TERMINATION_CATAGORY= '" + terminationCatagory + "'";
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
 public ResultSet selectTerminationTypesOne(int terminationCatagory) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_TERMINATION_TYPES WHERE TERMINATION_TYPE_ID= '" + terminationCatagory + "'";
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
     * @return  ResultSet of termination requsts with the given requester.
     * @param requesterId  of employee to whom the request is made
     * @param userName  the user name of the employee who logged in to the system
     * @throws SQLException
     */
    public ResultSet selectTerminationRequestByRequesterId(String requesterId, String userName) throws SQLException {

        //select process possible states for that user in the process termination
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + TerminationApproveManager.PROCESS_TERMINATION + "'))";

        String _selectQuery = " SELECT * FROM HR_TERMINATION_REQUEST WHERE REQUESTER_ID= '" + requesterId + "'" +
                " AND REQUEST_STATUS IN(" + _innerSelectQuery + ")";
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
    public ResultSet selectApprovableTerminationRequests(String userName) throws SQLException {

        //select process possible states accessible to the user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + TerminationApproveManager.PROCESS_TERMINATION + "'))";

        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST " +
                " WHERE REQUEST_STATUS NOT LIKE 'App-%' " +//not on pending
                " AND REQUEST_STATUS NOT LIKE 'Rej-%' " +//not rejected
                //                " AND REQUEST_STATUS <> '" + TerminationApproveManager.INITIAL_STATE_TERMINATION + "' " +//not initial state
                //                " AND REQUEST_STATUS <> '" + TerminationApproveManager.FINAL_STATE_TERMINATION + "' " +//not in final state
                " AND REQUEST_STATUS IN(" + _innerSelectQuery + ")";//the user is authorized to access the result
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

    public ResultSet selectPendingTerminationRequests(String requesterId, String recorededBy) throws SQLException {
//        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST " +
//                " WHERE " +
//                //   " REQUEST_STATUS = " + TerminationApproveManager.INITIAL_STATE_TERMINATION + " AND " +
//                " ( RECORDED_BY='" + userName + "' " +
//                "       OR REQUESTER_ID IN (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + userName + "'))";

        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST" +
                "  WHERE REQUEST_STATUS like " + TerminationApproveManager.INITIAL_STATE_TERMINATION + " " +
                " AND ( REQUESTER_ID like ? or RECORDED_BY like ? )" +
                " order by TERMINATION_REQUEST_ID desc";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, recorededBy);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectHistoryTerminationRequests(String requesterId, String recorededBy) throws SQLException {
//        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST " +
//                " WHERE " +
//                //   " REQUEST_STATUS = " + TerminationApproveManager.INITIAL_STATE_TERMINATION + " AND " +
//                " ( RECORDED_BY='" + userName + "' " +
//                "       OR REQUESTER_ID IN (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + userName + "'))";

        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST" +
                "  WHERE REQUEST_STATUS not like " + TerminationApproveManager.INITIAL_STATE_TERMINATION + " " +
                " AND ( REQUESTER_ID  like ? or RECORDED_BY like ? )" +
                " order by TERMINATION_REQUEST_ID desc";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, recorededBy);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of termination request of an employee<br>
     * It returns either single or no row result set.
     * @param  requesterId  id of employee who requested termination
     * @throws  SQLException
     */
    public ResultSet selectEmployeeLatestTerminationRequest(String requesterId) throws SQLException {
        String _selectQuery = "SELECT MAX(TERMINATION_REQUEST_ID)  AS TERMINATION_REQUEST_ID FROM HR_TERMINATION_REQUEST WHERE REQUESTER_ID='" + requesterId + "'";
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
     * returns ResultSet object of termination request of an employee<br>
     * It returns either single or no row result set.
     * @param  requesterId  id of employee who requested termination
     * @throws  SQLException
     */
    public ResultSet selectTerminationRequestByRequestId(int terminationRequestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST WHERE TERMINATION_REQUEST_ID=" + terminationRequestId + "";
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

    public ResultSet selectcategoey() throws SQLException {
        String _selectQuery = "SELECT ID,CATEGORY_NAME " +
                "FROM HR_LU_TERMINATION_CATEGORY ";

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

    public ResultSet selectEmployeeStatu(String empId) throws SQLException {
        String _selectQuery = "SELECT EMP_STATUS FROM  HR_EMPLOYEE_INFO where EMP_ID='" + empId + "'";
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
