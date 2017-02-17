/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.SubsidyEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.SubsidyManager.SubsidyIndividualRequestManager;
import manager.SubsidyManager.SubsidyIndividualApproveManager;
import manager.SubsidyManager.SubsidyIndividualRequestManager.SubSidiyRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class SubsidyIndividualRequestEntity
        extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public int insertTerminationRequest(SubSidiyRequestModel terminationRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_SUBSIDY_REQUEST " +
                " (SUBSIDY_ID,LOCATION, MONTH,DOCU_REFE," +
                " TOTALAMOUNT,REMARK, REQUESTER_ID," +
                " REQUEST_STATUS, APPLIED_DATE,RECORDED_BY,RECOREDED_DATE_TIME)" +
                " VALUES (HR_SUBSID_REQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, terminationRequestModel.getLocation());
            _ps.setString(2, terminationRequestModel.getMonth());
            _ps.setString(3, terminationRequestModel.getDocumeentReferenceNumber());
            _ps.setDouble(4, terminationRequestModel.getTotalAmount());
            _ps.setString(5, terminationRequestModel.getDescription());
            _ps.setString(6, terminationRequestModel.getRequesterId());
            _ps.setString(7, terminationRequestModel.getRequestStatus());
            _ps.setString(8, terminationRequestModel.getAppliedDate());
            _ps.setString(9, terminationRequestModel.getRecordedBy());
            _ps.setString(10, terminationRequestModel.getRecorededDateAndTime());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

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

    public SubsidyIndividualRequestEntity(int terminationRequestId, String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
        this(requesterId, terminationCatagory, terminationType, requestStatus, appliedDate, terminationDate, description, isDocumeentAttached, recordedBy, recorededDateAndTime);
        this.terminationRequestId = terminationRequestId;
    }

    public SubsidyIndividualRequestEntity(String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
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

    public SubsidyIndividualRequestEntity() {
    }

    /**
     * Inserts PowerDeligationRequest attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    /**
     * Updates Termintion Request attribute of the database.<br>
     * The constructor with full argument must be called before this method
     * @see
     * @throws  SQLException
     */
    public int updateTerminationRequest(SubSidiyRequestModel terminationRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_SUBSIDY_REQUEST " +
                " SET  LOCATION=?,     MONTH=?,      DOCU_REFE=?," +
                " TOTALAMOUNT=?, REMARK=?, REQUESTER_ID=?," +
                " REQUEST_STATUS=?, APPLIED_DATE=?,  RECORDED_BY=?, RECOREDED_DATE_TIME=? " +
                " where SUBSIDY_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);

            _ps.setString(1, terminationRequestModel.getLocation());
            _ps.setString(2, terminationRequestModel.getMonth());
            _ps.setString(3, terminationRequestModel.getDocumeentReferenceNumber());
            _ps.setDouble(4, terminationRequestModel.getTotalAmount());
            _ps.setString(5, terminationRequestModel.getDescription());
            _ps.setString(6, terminationRequestModel.getRequesterId());
            _ps.setString(7, terminationRequestModel.getRequestStatus());
            _ps.setString(8, terminationRequestModel.getAppliedDate());
            _ps.setString(9, terminationRequestModel.getRecordedBy());
            _ps.setString(10, terminationRequestModel.getRecorededDateAndTime());
            _ps.setInt(11, terminationRequestModel.getSubsidyID());
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
        String _deleteQuery = "DELETE HR_SUBSIDY_REQUEST  WHERE SUBSIDY_ID=?";
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
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from MUGHER.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from MUGHER.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + SubsidyIndividualApproveManager.PROCESS_SUBSIDY + "'))";

        String _selectQuery = " SELECT * FROM HR_SUBSIDY_REQUEST WHERE REQUESTER_ID= '" + requesterId + "'" +
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
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from MUGHER.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from MUGHER.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from MUGHER.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + SubsidyIndividualApproveManager.PROCESS_SUBSIDY + "'))";

        String _selectQuery = "SELECT * FROM HR_SUBSIDY_REQUEST " +
                " WHERE REQUEST_STATUS NOT LIKE 'App-%' " +//not on pending
                " AND REQUEST_STATUS NOT LIKE 'Rej-%' " +//not rejected
                //                " AND REQUEST_STATUS <> '" + SubsidyIndividualApproveManager.INITIAL_STATE_TERMINATION + "' " +//not initial state
                //                " AND REQUEST_STATUS <> '" + SubsidyIndividualApproveManager.FINAL_STATE_TERMINATION + "' " +//not in final state
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
//                //   " REQUEST_STATUS = " + SubsidyIndividualApproveManager.INITIAL_STATE_TERMINATION + " AND " +
//                " ( RECORDED_BY='" + userName + "' " +
//                "       OR REQUESTER_ID IN (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "'))";

        String _selectQuery = "SELECT * FROM HR_SUBSIDY_REQUEST" +
                "  WHERE REQUEST_STATUS like " + SubsidyIndividualApproveManager.INITIAL_STATE_SUBSIDY + " " +
                " AND ( REQUESTER_ID like ? or RECORDED_BY like ? )" +
                " order by SUBSIDY_ID desc";

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

        String _selectQuery = "SELECT * FROM HR_SUBSIDY_REQUEST" +
                "  WHERE REQUEST_STATUS not like " + SubsidyIndividualApproveManager.INITIAL_STATE_SUBSIDY + " " +
                " AND ( REQUESTER_ID  like ? or RECORDED_BY like ? )" +
                " order by SUBSIDY_ID desc";

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
        String _selectQuery = "SELECT MAX(SUBSIDY_ID)  AS SUBSIDY_ID FROM HR_SUBSIDY_REQUEST WHERE REQUESTER_ID='" + requesterId + "'";
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
    public ResultSet selectTerminationRequestByRequestId(int subsidyId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_SUBSIDY_REQUEST WHERE SUBSIDY_ID=" + subsidyId + "";
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
        String _selectQuery = "SELECT ID,LOCATION " +
                "FROM HR_LU_SUBSIDY_LOCATION ";

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
