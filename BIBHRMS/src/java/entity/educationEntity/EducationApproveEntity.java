/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.educationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.authorizationManager.DescisionModel;
import manager.educationManager.EducationPaymentApproveManager;
import manager.educationManager.EducationApproveManager;
import manager.educationManager.EducationRequestModel;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class EducationApproveEntity extends ConnectionManager {

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
//EducationApproveManager educationApproveManager= new EducationApproveManager();

    public boolean insertEducationDecision(EducationRequestModel educationRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_EDUCATION_PROCESSED " +
                " (EDUCATION_PROCESSED_ID,REQUEST_ID, PROCESSED_BY,DECISION, " +
                "  COMMENT_GIVEN, RECORDED_BY, TIME_STAMP,FORWARDED_TO_COMMITTEE)" +
                " VALUES (HR_EDUCATION_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE HR_EDUCATION_REQUEST SET REQUEST_STATUS=? WHERE EDUCATION_REQUEST_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, educationRequestModel.getRequestId());
            _ps.setString(2, educationRequestModel.getProcessedBy());
            _ps.setString(3, educationRequestModel.getDecision());
            _ps.setString(4, educationRequestModel.getCommnetGiven());
            _ps.setString(5, educationRequestModel.getRecordedBy());
            _ps.setString(6, educationRequestModel.getRecorededDateAndTime());
            _ps.setString(7, educationRequestModel.getForwardedToCommittee());

            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, educationRequestModel.getStatus());
            _ps.setInt(2, educationRequestModel.getRequestId());
            _ps.executeUpdate();

            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * Retrives termination requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =8 for the porcess termination
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName) throws SQLException {
        //select process's possible states for that user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from mugher.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from MUGHER.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from mugher.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from MUGHER.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + EducationApproveManager.PROCESS_EDUCATION + "'))";
        String _selectQuery = "SELECT * FROM HR_EDUCATION_REQUEST WHERE REQUEST_STATUS  IN (" + _innerSelectQuery + ")ORDER BY TIME_STAMP desc";

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
        String _selectQuery = "SELECT * FROM HR_EDUCATION_REQUEST WHERE EDUCATION_REQUEST_ID  IN " +
                "(SELECT REQUEST_ID FROM HR_EDUCATION_PROCESSED WHERE RECORDED_BY =?) ORDER BY TIME_STAMP desc";
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

    public void deleteApprovedRequestList(int educProcessedId) throws SQLException {
        String _deleteQuery = " delete from HR_EDUCATION_PROCESSED where DECISION= '343$$361' and EDUCATION_PROCESSED_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educProcessedId);
            _ps.executeUpdate();
        } finally {
            releaseResources();
        }


    }

    public ResultSet selectForwardToCommitee() throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUCATION_REQUEST req " +
                "INNER JOIN hr_education_processed pro " +
                "ON req.education_request_id= pro.request_id " +
                "WHERE FORWARDED_TO_COMMITTEE LIKE 'YES' " +
                "AND pro.DECISION like '%_$$_%' " +
                "AND req.request_status not LIKE'App-%' " +
                "ORDER BY pro.time_stamp desc";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            //_ps.setString(1, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTableInfo(String requestID) throws SQLException {

        String _selectQuery = "select * from HR_ADMINSTRATIVE_COST where requester_id=?";
        String select = "select * from HR_COURSE_PERSEMISTER where requester_id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requestID);
            _rs = _ps.executeQuery();
//            _ps2 = _con.prepareStatement(select);
//            _ps2.setString(1, requestID);
//            _rs2 = _ps2.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
//              ocrs.populate(_rs2);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException*/
    public ResultSet selectProcessedOverTimeRequest(int requestId) throws SQLException {
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
                "FROM HR_EDUCATION_PROCESSED , " +
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

    public ResultSet selectForwardedToCommittee(int requestId, String status) throws SQLException {

        String _selectQuery = "SELECT HR_EDUCATION_PROCESSED.*, " +
                "   REQUESTER_ID, " +
                "   HR_EDUCATION_REQUEST.REQUEST_STATUS " +
                " FROM HR_EDUCATION_REQUEST, " +
                "   HR_EDUCATION_PROCESSED " +
                " WHERE REQUEST_ID = ? " +
                " AND DECISION LIKE ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, "%" + status);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean NewSaveCommitteeComenets(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int educationRequestIds, String memberUserName, String memberPassWord, String status, String savedStatus) throws SQLException {

        String Sql = " insert into HR_EDUC_COMMITTEE_COMMENTS(EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBILITY,COMMENT_GIVEN,EDUCATION_REQUEST_ID,USER_NAME,PASSWORD,SAVED_STATUS,STATUS)" +
                " values (?,?,?,?,?,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setString(1, memberEmployeeId);
            _ps.setString(2, memberFullName);
            _ps.setString(3, memberResponsiblity);
            _ps.setString(4, memberComentes);
            _ps.setInt(5, educationRequestIds);
            _ps.setString(6, memberUserName);
            _ps.setString(7, memberPassWord);
            _ps.setString(8, savedStatus);
            _ps.setString(9, status);


            //  _ps.execute();
            _ps.execute();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectActiveCommittees() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_COMMITTEE_TYPE " +
                " ORDER BY COMMITTEE_TYPE_CODE";
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
//    public boolean NewSaveCommitteeComenets(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int disciplineProblmeId, String memberUserName, String memberPassWord, String status, String savedStatus) throws SQLException {
//
//        String Sql = " insert into HR_COMMITTEE_COMMEENTES(EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBLITY,COMMEENTES_GIVEN,DISICIPLINE_PROBLEM_ID,SAVED_STATUS)" +
//                " values (?,?,?,?,?,?)";
//
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(Sql);
//            _ps.setString(1, memberEmployeeId);
//            _ps.setString(2, memberFullName);
//            _ps.setString(3, memberResponsiblity);
//            _ps.setString(4, memberComentes);
//            _ps.setInt(5, disciplineProblmeId);
//            _ps.setString(6, "Done");
//
//
//            //  _ps.execute();
//            _ps.execute();
//            return true;
//        } finally {
//            releaseResources();
//        }
//    }

    public ResultSet getAllEduacCommitee() throws SQLException {
        String _selectQuery = "Select * from HR_EDUCATION_PROCESSED where DECISION like '%_$$_%' ";
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

    public ResultSet selectCommeetessComments(int educRequestId) throws SQLException {

        String Sql = " SELECT EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBILITY,COMMENT_GIVEN,EDUCATION_REQUEST_ID,SAVED_STATUS" +
                " FROM HR_EDUC_COMMITTEE_COMMENTS" +
                " WHERE EDUCATION_REQUEST_ID= ? and SAVED_STATUS= 'Done'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, educRequestId);
            _rs = _ps.executeQuery();
   
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectCommeetessComments(int educRequestId, String memberUserName) throws SQLException {

        String Sql = " SELECT EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBILITY,COMMENT_GIVEN,EDUCATION_REQUEST_ID" +
                " FROM HR_EDUC_COMMITTEE_COMMENTS" +
                " WHERE EDUCATION_REQUEST_ID= ? and USER_NAME= ? and SAVED_STATUS= 'Done'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, educRequestId);
            _ps.setString(2, memberUserName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet isForwardedToCommitee(int educationRequestId) throws SQLException {

        String _selectQuery = "SELECT FORWARDED_TO_COMMITTEE " +
                " FROM HR_EDUCATION_PROCESSED " +
                " WHERE REQUEST_ID = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, educationRequestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> readEmployeeFile(int requestId) {
        ArrayList<HashMap> listEmployeeFile = new ArrayList<HashMap>();
        String _select = "SELECT pro.EDUCATION_PROCESSED_ID, " +
                "  pro.REQUEST_ID, " +
                "  pro.MINUTE, " +
                "  pro.FILEEXTENSION " +
                "FROM HR_EDUCATION_PROCESSED pro " +
                "INNER JOIN HR_EDUCATION_request req " +
                "ON pro.request_id    =req.education_request_id " +
                "WHERE pro.REQUEST_ID =? " +
                "AND req.request_status LIKE '%-%' " +
                "AND pro.minute IS NOT NULL";
        _ps = null;
        _con = null;
        ResultSet rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setInt(1, requestId);
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();

                hm.put("EDUCATION_PROCESSED_ID", ocrs.getString("EDUCATION_PROCESSED_ID"));
                hm.put("REQUEST_ID", ocrs.getString("REQUEST_ID"));
                hm.put("FILEEXTENSION", ocrs.getString("FILEEXTENSION"));
                listEmployeeFile.add(hm);
            }
            rs.close();
            _ps.close();
            closePooledConnections(_con);
            return listEmployeeFile;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return null;
    }

    public OracleSerialBlob select_Document(int documentId) {
        String qry = null;
        qry = " SELECT ATTACHED_FILE,FILE_ID,REQUEST_ID FROM HR_EDUCATION_APPROVE_FILE WHERE REQUEST_ID ='" + documentId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {

                return (OracleSerialBlob) ocrs.getBlob("ATTACHED_FILE");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet selectDocumentAttrbutie(int requestID) {
        String qry = null;


        qry = " SELECT * FROM HR_EDUCATION_APPROVE_FILE WHERE REQUEST_ID ='" + requestID + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertFile(ArrayList<SelectItem> minuteAttachedList, String fileExtension, byte[] minute) throws SQLException {
        String _insertFileQuery = "INSERT INTO HR_EDUCATION_APPROVE_FILE " +
                " (FILE_ID,FILE_NAME, FILE_TYPE,FILE_EXTENSTION, " +
                "  REQUEST_ID, ATTACHED_FILE)" +
                " VALUES (hr_file_edu.NEXTVAL,?,?,?,?,?) ";
        String _updateMinattaYesOrNot = "UPDATE HR_EDUCATION_PROCESSED SET " +
                " MINUTE_ATTACHED = 'YES' " +
                " WHERE REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertFileQuery);
            for (SelectItem currentRequest : minuteAttachedList) {
                _ps.setString(1, "Minute");
                _ps.setString(2, "Minute");
                _ps.setString(3, fileExtension);
                _ps.setInt(4, Integer.valueOf(currentRequest.getValue().toString()));
                _ps.setBytes(5, minute);
                _ps.addBatch();
            }
            _ps.executeBatch();
            _ps = _con.prepareStatement(_updateMinattaYesOrNot);
            for (SelectItem currentRequest : minuteAttachedList) {
                _ps.setString(1, currentRequest.getValue().toString());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public int selectEmployeeStatu(int reqId) throws SQLException {
        String _selectQuery = "SELECT * FROM  HR_EDUCATION_APPROVE_FILE where REQUEST_ID='" + reqId + "'";
        //String _select = "SELECT DISTINCT REQUESTER_ID FROM HR_TRANSFER_REQUESTS WHERE REQUESTER_ID='" + checkId + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
             int row = _ps.executeUpdate();
            _ps.close();
            //closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            return 0;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }
  public int CheckIDFoundInRequestHistory(int checkId) {
        String _select = "SELECT * FROM  HR_EDUCATION_APPROVE_FILE where REQUEST_ID='" + checkId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            int row = _ps.executeUpdate();
            _ps.close();
            //closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            return 0;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }
    public int UodateFile(EducationRequestModel educationRequestModel) throws SQLException {

        String _updateQuery = "UPDATE HR_EDUCATION_APPROVE_FILE SET FILE_EXTENSTION=?,ATTACHED_FILE=? WHERE REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, educationRequestModel.getFileExtension());
            _ps.setBytes(2, educationRequestModel.getMinute());
            _ps.setInt(3, educationRequestModel.getEducationRequestId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllForwardedRequest() throws SQLException {
        String _selectQuery = "SELECT req.education_request_id, " +
                "  info.first_name " +
                "  ||' ' " +
                "  || info.middle_name " +
                "  || ' ' " +
                "  || info.last_name AS fullName " +
                "FROM HR_EDUCATION_PROCESSED pro " +
                "INNER JOIN hr_education_request req " +
                "ON req.education_request_id=pro.request_id " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.requester_id " +
                "WHERE DECISION LIKE '%_$$_%' " +
                "AND pro.minute_attached='NO'";
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



