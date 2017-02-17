/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.disciplineEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import manager.disciplineManager.CommtteeComments;
import manager.disciplineManager.DisciplineApproveManager;
import manager.disciplineManager.DisciplineApproveManager.CommitteeMinuteFileUpLoad;
import manager.disciplineManager.DisciplineApproveManager.DisciplineProcessedModel;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

/**
 *
 * @author mekete
 */
public class DisciplineApproveEntity extends ConnectionManager {

    DisciplineRequestModel disciplineRequestModel = new DisciplineRequestModel();
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

    public DisciplineApproveEntity() {
    }

    public int insertDecisionMadeOnDiscipline(DisciplineProcessedModel processedModel) {
        String _insertQuery = " INSERT INTO HR_DISCIPLINE_PROCESSED " +
                " (DISCIPLINE_PROCESSED_ID,REQUEST_ID,PROCESSED_BY,COMMENT_GIVEN,DECISION,RECORDED_BY,TIME_STAMP,AGREE_ON_DEFAULT_PENALTY," +
                " FORWARDED_TO_COMMITTEE,NEW_PENALTY_PROPOSED,DEDUCTION_AMOUNT,DURATION," +
                " SUGGESTED_DEDUCT,SUGGESTED_DURATION,APPROVED_PENALITY,APPROVED_DEDUCT,APPROVED_DURATION,LAST_COMMENTES,SUSPENDED_FROM_PROM," +
                " SUSPENDED_FROM_TRAN,PROMOTION_DURATION,TRANSFER_DURATION )" +
                " VALUES (HR_DISCIPLINE_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        String _updateQuery = " UPDATE HR_DISCIPLINE_ISSUE " +
                " SET STATUS=? WHERE DISCIPLINE_PROBLEM_ID= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, processedModel.getRequestId());
            _ps.setString(2, processedModel.getProcessedBy());
            _ps.setString(3, processedModel.getCommnetGiven());
            _ps.setString(4, processedModel.getDecision());
            _ps.setString(5, processedModel.getRecordedBy());
            _ps.setString(6, processedModel.getTimeStamp());
            _ps.setString(7, processedModel.getAgreeOnDefaultPenalty());
            _ps.setString(8, processedModel.getForWared());
            _ps.setString(9, processedModel.getSuggestedPenality());
            _ps.setDouble(10, processedModel.getDeductionAmout());
            _ps.setString(11, processedModel.getDuration());
            _ps.setDouble(12, processedModel.getSuggestedPenaltyDeduction());
            _ps.setString(13, processedModel.getSuggestedPenalityDuration());
            _ps.setString(14, processedModel.getApprovedPenality());
            _ps.setDouble(15, processedModel.getApprovedPenalityDeduction());
            _ps.setString(16, processedModel.getApprovedPenalityDuration());
            _ps.setString(17, processedModel.getLastApproverCommentes());
            _ps.setString(18, processedModel.getPromotionSuspend());
            _ps.setString(19, processedModel.getTransferSuspend());
            _ps.setString(20, processedModel.getPromotionDuration());
            _ps.setString(21, processedModel.getTransferDuration());
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, processedModel.getDecision());
            _ps.setInt(2, processedModel.getRequestId());
            System.out.println(_updateQuery);
            return _ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        //releaseResources();
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public int insertDecisionMadeOnDisciplineFromRequest(DisciplineProcessedModel disciplineProcessedModelRequestApprove) {
        String _insertQuery = " INSERT INTO HR_DISCIPLINE_PROCESSED " +
                " (DISCIPLINE_PROCESSED_ID,REQUEST_ID,PROCESSED_BY,COMMENT_GIVEN,DECISION,RECORDED_BY,TIME_STAMP,AGREE_ON_DEFAULT_PENALTY," +
                " FORWARDED_TO_COMMITTEE,NEW_PENALTY_PROPOSED,DEDUCTION_AMOUNT,DURATION," +
                " SUGGESTED_DEDUCT,SUGGESTED_DURATION,APPROVED_PENALITY,APPROVED_DEDUCT,APPROVED_DURATION,LAST_COMMENTES,SUSPENDED_FROM_PROM," +
                " SUSPENDED_FROM_TRAN,PROMOTION_DURATION,TRANSFER_DURATION )" +
                " VALUES (HR_DISCIPLINE_PROCESSED_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        String _updateQuery = " UPDATE HR_DISCIPLINE_ISSUE " +
                " SET STATUS=? WHERE DISCIPLINE_PROBLEM_ID= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, disciplineProcessedModelRequestApprove.getRequestId());
            _ps.setString(2, disciplineProcessedModelRequestApprove.getProcessedBy());
            _ps.setString(3, disciplineProcessedModelRequestApprove.getCommnetGiven());
            _ps.setString(4, disciplineProcessedModelRequestApprove.getStatus());
            _ps.setString(5, disciplineProcessedModelRequestApprove.getRecordedBy());
            _ps.setString(6, disciplineProcessedModelRequestApprove.getTimeStamp());
            _ps.setString(7, disciplineProcessedModelRequestApprove.getAgreeOnDefaultPenalty());
            _ps.setString(8, disciplineProcessedModelRequestApprove.getForWared());
            _ps.setString(9, disciplineProcessedModelRequestApprove.getNewPenaltyType());
            _ps.setDouble(10, disciplineProcessedModelRequestApprove.getDeductionAmout());
            _ps.setString(11, disciplineProcessedModelRequestApprove.getDuration());
            _ps.setDouble(12, disciplineProcessedModelRequestApprove.getSuggestedPenaltyDeduction());
            _ps.setString(13, disciplineProcessedModelRequestApprove.getSuggestedPenalityDuration());
            _ps.setString(14, disciplineProcessedModelRequestApprove.getApprovedPenality());
            _ps.setDouble(15, disciplineProcessedModelRequestApprove.getApprovedPenalityDeduction());
            _ps.setString(16, disciplineProcessedModelRequestApprove.getApprovedPenalityDuration());
            _ps.setString(17, disciplineProcessedModelRequestApprove.getLastApproverCommentes());
            _ps.setString(18, disciplineProcessedModelRequestApprove.getPromotionSuspend());
            _ps.setString(19, disciplineProcessedModelRequestApprove.getTransferSuspend());
            _ps.setString(20, disciplineProcessedModelRequestApprove.getPromotionDuration());
            _ps.setString(21, disciplineProcessedModelRequestApprove.getTransferDuration());
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, disciplineProcessedModelRequestApprove.getStatus());
            _ps.setInt(2, disciplineProcessedModelRequestApprove.getRequestId());

            return _ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        //releaseResources();
        }
    }


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public void clearfromPending(int disciplineProblemId) throws SQLException {
//        String deleteQuery=" delete from hr_discipline_issue where discipline_problem_id= ?";
//        try{
//        _con=getConnection();
//        _ps= _con.prepareStatement(deleteQuery);
//        _ps.setInt(1, disciplineProblemId);
//        _ps.executeUpdate();
//    } finally {
//            releaseResources();
//        }
    }

    public boolean NewSaveCommitteeComenets(String memberEmployeeId, String memberFullName, String memberResponsiblity, String memberComentes, int diciplineProblemId, String memberUserName, String memberPassWord, String status, String savedStatus, String commentsGivenDay, String suggestedPenality) throws SQLException {
        String Sql = " insert into HR_COMMITTEE_COMMEENTES(EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBLITY,COMMEENTES_GIVEN,DISICIPLINE_PROBLEM_ID,SAVED_STATUS,COMMEENTS_GIVEN_DAY,SUGGESTED_PENALTY,USER_NAME)" +
                " values (?,?,?,?,?,?,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setString(1, memberEmployeeId);
            _ps.setString(2, memberFullName);
            _ps.setString(3, memberResponsiblity);
            _ps.setString(4, memberComentes);
            _ps.setInt(5, diciplineProblemId);
            _ps.setString(6, "Done");
            _ps.setString(7, commentsGivenDay);
            _ps.setString(8, suggestedPenality);
            _ps.setString(9, memberUserName);



            //  _ps.execute();
            _ps.execute();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean saveChairManCommentes(int disciplineProblemId, String commentes, String suggetedPenality, double dedctionAmount, String duration, String savedStatus, String commeentsGivenday) throws SQLException {
        String Sql = " insert into HR_COMCHAIR_MAN_COMMEENTES(DISCIPLINE_PROBLEM_ID,COMMEENTES_GIVEN,SUGGESTED_PENALITY,DEDUCTION_AMOUNT,DURATION,SAVED_STATUS,COMMEENT_GIVEN_DAY)" +
                " values (?,?,?,?,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, disciplineProblemId);
            _ps.setString(2, commentes);
            _ps.setString(3, suggetedPenality);
            _ps.setDouble(4, dedctionAmount);
            _ps.setString(5, duration);
            _ps.setString(6, "Done");
            _ps.setString(7, commeentsGivenday);
            _ps.execute();
            return true;
        } finally {
            releaseResources();
        }
    }

    public int saveRevocPenltiy(int disciplineProblemId, String commentes, String courtDecision, String commeentsGivenday, String documentRefrance, String savedStaus) throws SQLException {
        String Sql = " insert into HR_DISCIPLINE_REJECT_COMMENT(DISCIPLINE_PRROBLEM_ID,APPROVER_COMMEENTES,COURT_DECISION,APPROVED_DATE,DOCUMENT_REFERANCE,SAVED_STATUS)" +
                " values (?,?,?,?,?,?)";
        String _updateQuery = "UPDATE HR_DISCIPLINE_ISSUE " +
                " SET STATUS=? WHERE DISCIPLINE_PROBLEM_ID= ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, disciplineProblemId);
            _ps.setString(2, commentes);
            _ps.setString(3, courtDecision);
            _ps.setString(4, commeentsGivenday);
            _ps.setString(5, documentRefrance);
            _ps.setString(6, "Done");
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, "REJECT");
            _ps.setInt(2, disciplineProblemId);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        //releaseResources();
        }
    }

    public ResultSet selectCommeetessComments(int disReqID, String memberUserName) throws SQLException {

        String Sql = "SELECT EMPLOYEE_ID, " +
                "  EMPLOYEE_NAME, " +
                "  RESPONSIBLITY, " +
                "  COMMEENTES_GIVEN, " +
                "  DISICIPLINE_PROBLEM_ID " +
                "FROM HR_COMMITTEE_COMMEENTES " +
                "WHERE DISICIPLINE_PROBLEM_ID=?" +
                "AND USER_NAME =?" +
                "AND SAVED_STATUS= 'Done'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, disReqID);
            _ps.setString(2, memberUserName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getChairManCommentes(int disciplineProblemId) throws SQLException {
        String _selectQuery = "SELECT * " +
                " FROM HR_COMCHAIR_MAN_COMMEENTES" +
                " WHERE DISCIPLINE_PROBLEM_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineProblemId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet cheakPenalityStatus(int disciplineProblemId) throws SQLException {
        String _selectQuery = "SELECT  SAVED_STATUS  " +
                " FROM HR_DISCIPLINE_REJECT_COMMENT " +
                " WHERE DISCIPLINE_PRROBLEM_ID =? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineProblemId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getRejectPenality(int disciplineProblemId) throws SQLException {
        String _selectQuery = "SELECT * " +
                " FROM HR_DISCIPLINE_REJECT_COMMENT" +
                " WHERE DISCIPLINE_PRROBLEM_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineProblemId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectDicisionsMadeByEmployee(String userName) throws SQLException {
        String _selectQuery = "SELECT HR_DISCIPLINE_PROCESSED.*, " +
                "   REQUESTER_ID, " +
                "   HR_DISCIPLINE_ISSUE.STATUS, HR_DISCIPLINE_ISSUE.OFFENCE_TYPE," +
                "   HR_DISCIPLINE_ISSUE.DISCIPLINE_PROBLEM_ID,HR_DISCIPLINE_ISSUE.REPITITION_OF_OFFENCE,hr_discipline_issue.employee_status, " +
                "   OFFENDER_ID " +
                " FROM HR_DISCIPLINE_ISSUE, " +
                "   HR_DISCIPLINE_PROCESSED " +
                " WHERE DISCIPLINE_PROBLEM_ID=REQUEST_ID  " +
                " AND HR_DISCIPLINE_PROCESSED.DECISION='APPROVE'" +
                "  AND HR_DISCIPLINE_PROCESSED.RECORDED_BY      =? " +
                "  OR  HR_DISCIPLINE_PROCESSED.PROCESSED_BY      =? ORDER BY HR_DISCIPLINE_PROCESSED.TIME_STAMP DESC ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, userName);
            _ps.setString(2, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getcommentesGivenday(int diciplineId) throws SQLException {

        String _selectQuery = " select REPORTED_DATE from HR_DISCIPLINE_ISSUE WHERE DISCIPLINE_PROBLEM_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, diciplineId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getForwadToCommiteeday(int diciplineId) throws SQLException {

        String _selectQuery = " select SUBSTR(TIME_STAMP,1,10) TIME_STAMP from HR_DISCIPLINE_PROCESSED WHERE REQUEST_ID=? AND DECISION LIKE '%$$41'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, diciplineId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getEmployeeSalary(String offenderId) throws SQLException {
        String _selectQuery = "select salary from hr_employee_info where emp_id= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, offenderId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public void deleteApprovedRequestList(int disciplineProcessedId) throws SQLException {
        String _deleteQuery = " delete from HR_DISCIPLINE_PROCESSED where DECISION LIKE '%$$41'and DISCIPLINE_PROCESSED_ID= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, disciplineProcessedId);
            _ps.executeUpdate();
        } finally {
            releaseResources();
        }


    }

    public ResultSet selectDocumentAttrbutie(int requestID) {
        String qry = null;



        qry = " SELECT * FROM HR_DISCIPLINE_COMMITTEE_MINUTE WHERE REQUEST_ID ='" + requestID + "'and FILE_NAME='Minute'";

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

    public ResultSet selectLatestDecisionOnRequestee(int requestId) throws SQLException {
        String _selectQuery = "SELECT * " +
                " FROM HR_DISCIPLINE_PROCESSED" +
                " WHERE REQUEST_ID = ? ";
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

    public ResultSet selectForwardedToCommittee(int requestId, String status) throws SQLException {

        String _selectQuery = " SELECT HR_DISCIPLINE_PROCESSED.*, " +
                "   REQUESTER_ID, " +
                "   HR_DISCIPLINE_ISSUE.STATUS, " +
                "   OFFENDER_ID " +
                " FROM HR_DISCIPLINE_ISSUE, " +
                "   HR_DISCIPLINE_PROCESSED " +
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

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException*/
    public ResultSet selectCommeetessComments(int diciplineId) throws SQLException {

        String Sql = " SELECT EMPLOYEE_ID,EMPLOYEE_NAME,RESPONSIBLITY,COMMEENTES_GIVEN,DISICIPLINE_PROBLEM_ID,COMMEENTS_GIVEN_DAY,SUGGESTED_PENALTY" +
                " FROM HR_COMMITTEE_COMMEENTES" +
                " WHERE DISICIPLINE_PROBLEM_ID= ? and SAVED_STATUS= 'Done'";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(Sql);
            _ps.setInt(1, diciplineId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectProcessedDisciplineRequest(int requestId) throws SQLException {
        String _selectQuery = " SELECT REQUEST_ID, " +
                "  BIB.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                " NEW_PENALTY_PROPOSED," +
                " DEDUCTION_AMOUNT," +
                " DURATION," +
                " SUGGESTED_DEDUCT," +
                " SUGGESTED_DURATION," +
                " APPROVED_PENALITY," +
                " APPROVED_DEDUCT," +
                " APPROVED_DURATION," +
                " LAST_COMMENTES," +
                " SUSPENDED_FROM_PROM," +
                " SUSPENDED_FROM_TRAN," +
                " PROMOTION_DURATION," +
                " TRANSFER_DURATION " +
                " FROM HR_DISCIPLINE_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  BIB.TBL_USERS " +
                "WHERE REQUEST_ID=" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID=PROCESSED_BY " +
                "AND BIB.TBL_USERS.user_name=RECORDED_BY " +
                "AND HR_DISCIPLINE_PROCESSED.DECISION like 'APPROVE' " +
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

    /**
     * Retrives leave requests which can be processes by the user.
     * An employee has to see only requests which can be processes with his/her priviledge
     * @param  userName user name of the employee who logged in to the sysytem
     * processId =1 for the porcess leave
     * @throws  SQLException
     */
    public ResultSet selectApprovableRequest(String userName) throws SQLException {

        String _innerSelectQuery = " select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + DisciplineApproveManager.PROCESS_DISCIPLINE + "'))";

        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE " +
                "WHERE STATUS  IN (" + _innerSelectQuery + ") ORDER BY REPORTED_DATE DESC";

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

    public ResultSet selectApprovableRequestsByCommittee(String loggedInEmployeeId, String userName) throws SQLException {
        String _innerSelectQueryCommittee = "SELECT  CURRENT_STATUS " +
                "FROM HR_DISCIPLINE_TO_COMMITTEE " +
                "WHERE committee_id IN " +
                "  (SELECT COMMITTEE_ID " +
                "  FROM HR_COMMITTEE_MEMBER " +
                "  WHERE EMP_ID='" + loggedInEmployeeId + "' " +
                "  AND STATUS ='Active' )";

        String _innerSelectQueryStatus = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from  BIB.tbl_role_user   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + DisciplineApproveManager.PROCESS_DISCIPLINE + "'))";
        String _selectQuery = "SELECT * FROM HR_DISCIPLINE_ISSUE " +
                "WHERE STATUS  IN (" + _innerSelectQueryStatus + ") " +
                " OR STATUS  IN (" + _innerSelectQueryCommittee + ") " +
                " ORDER BY DISCIPLINE_PROBLEM_ID DESC";

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

    public ResultSet selectRequestForwardToCommeete() throws SQLException {

        String _selectQuery = " SELECT di.discipline_problem_id," +
                " di.requester_id," +
                " di.offence_date," +
                " di.reported_date," +
                " di.offender_id," +
                " di.offence_type," +
                " di.description_of_offence," +
                " di.requested_measure_to_be_taken," +
                " di.is_document_attached," +
                " di.repitition_of_offence," +
                " di.recoreded_by," +
                " di.time_stamp," +
                " di.status," +
                "di.employee_status," +
                " dp.discipline_processed_id," +
                " dp.request_id," +
                " dp.processed_by," +
                " dp.comment_given," +
                " dp.decision," +
                " dp.recorded_by," +
                " dp.time_stamp," +
                " dp.agree_on_default_penalty," +
                " dp.forwarded_to_committee," +
                " dp.new_penalty_proposed, " +
                " dp.deduction_amount," +
                " dp.duration, " +
                " dp.suggested_deduct," +
                " dp.suggested_duration," +
                " dp.approved_penality," +
                " dp.approved_deduct, " +
                " dp.approved_duration, " +
                " dp.last_commentes" +
                " FROM HR_DISCIPLINE_ISSUE di " +
                " INNER JOIN  HR_DISCIPLINE_PROCESSED  dp " +
                " ON dp.request_id= di.discipline_problem_id " +
                " WHERE dp.forwarded_to_committee ='YES' " +
                " AND dp.decision like '%$$41' ORDER BY  dp.time_stamp DESC";


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

    public ResultSet IsPenalityCanBeApproved(int disciplineID, int reputation) throws SQLException {

        String _selectQuery = " SELECT dtr.DESCIPLINE_TYPE, " +
                "  dtr.PENALTY, " +
                "  pt.PENALTY_TYPE_ID, " +
                "  pt.MONETARY_PENALTY_DAYS, " +
                "  pt.ACTION_TAKER " +
                "  FROM HR_DISCIPLINED_TYPE_REPITITION DTR " +
                "  INNER JOIN hr_lu_penalty_type pt " +
                "  ON dtr.penalty =pt.penalty_type_id " +
                "  WHERE dtr.descipline_type= ?";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public int insertFile(CommitteeMinuteFileUpLoad fileUpLoad) throws SQLException {
        String _insertAccusedFileAttacheCommentes = " INSERT INTO HR_DISCIPLINE_COMMITTEE_MINUTE (FILE_ID,FILE_NAME,FILE_TYPE,FILE_EXTENSTION,REQUEST_ID,ATTACHED_FILE)" +
                " VALUES(HR_COMMITEE_MINUITE_SEQ.NEXTVAL,?,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
            //_ps.setInt(1, fileUpLoad.getFileID());
            _ps.setString(1, fileUpLoad.getFileName());
            _ps.setString(2, fileUpLoad.getFileType());
            _ps.setString(3, fileUpLoad.getExtention());
            _ps.setInt(4, fileUpLoad.getRequestID());
            _ps.setBytes(5, fileUpLoad.getAttachedFile());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public OracleSerialBlob select_Document(int documentId) {
        String qry = null;
        qry = " SELECT ATTACHED_FILE FROM HR_DISCIPLINE_COMMITTEE_MINUTE WHERE FILE_ID ='" + documentId + "'";
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
}
