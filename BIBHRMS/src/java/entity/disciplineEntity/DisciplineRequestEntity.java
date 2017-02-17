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
import manager.disciplineManager.DisciplineApproveManager;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete VS Bravo Zulu
 */
public class DisciplineRequestEntity
        extends ConnectionManager {

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

    public DisciplineRequestEntity() {
    }

    public int insertDisciplineRequest(DisciplineRequestModel requestModel) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIPLINE_ISSUE " +
                " (DISCIPLINE_PROBLEM_ID,REQUESTER_TYPE,REQUESTER_ID," +
                " OFFENCE_DATE,REPORTED_DATE,OFFENDER_ID," +
                " OFFENCE_TYPE, DESCRIPTION_OF_OFFENCE,REPITITION_OF_OFFENCE," +
                " REQUESTED_MEASURE_TO_BE_TAKEN, IS_DOCUMENT_ATTACHED," +
                " STATUS, RECOREDED_BY,TIME_STAMP,EMPLOYEE_STATUS,REPORTER_ID,REPORTER_FULLNAME," +
                " REPORTER_DEPARTMENT,REPORTER_POSITION,CANBE_APPROVED)" +
                " VALUES (HR_DISCIPLINE_PROBLEM_REQ_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

        String _insertAttachedDocumentsQuery = "INSERT INTO HR_ALL_ATTACHED_DOCUMENTS " +
                " ATTACHED_DOCUMENT_ID,REFERENCING_TABLE,REFERENCING_TABLE_PRIMARYKEY, " +
                " FILE_NAME_OF_DOCUMENT,FILE_FORMAT_OF_DOCUMENT,DOCUMENT," +
                " RECORDED_BY, TIME_STAMP" +
                " VALUES (HR_ALL_ATTACHED_DOCUMENTS_SEQ.NEXTVAL,'HR_DISCIPLINE_PROBLEM_REQUEST','DISCIPLINE_PROBLEM_ID'," +
                " ?,?,?," +
                " ?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            _ps.setString(1, requestModel.getRequesterType());
            _ps.setString(2, requestModel.getRequesterId());
            _ps.setString(3, requestModel.getDateOfOffence());
            _ps.setString(4, requestModel.getReportedDate());
            _ps.setString(5, requestModel.getOffenderId());
            _ps.setString(6, requestModel.getOffenceType());
            _ps.setString(7, requestModel.getDescriptionOfOffence());
            _ps.setInt(8, requestModel.getRepititionOfOffence());
            _ps.setString(9, requestModel.getRequestedMeasureToBeTaken());
            _ps.setString(10, requestModel.getDocumentReferenceNumber());
            _ps.setString(11, requestModel.getStatus());
            _ps.setString(12, requestModel.getRecordedBy());
            _ps.setString(13, requestModel.getTimeStamp());
            _ps.setString(14, requestModel.getEmployeeStatus());
            _ps.setString(15, requestModel.getReporterID());
            _ps.setString(16, requestModel.getReporterFullName());
            _ps.setString(17, requestModel.getReporterDepartment());
            _ps.setString(18, requestModel.getReporterPosition());
            _ps.setString(19, requestModel.getApprovedHere());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int UPdateDisciplineRequest(DisciplineRequestModel requestModel) throws SQLException {
        String _insertDisciplineProblemQuery = " UPDATE HR_DISCIPLINE_ISSUE  SET " +
                " REQUESTER_TYPE=?," +
                " REQUESTER_ID=?, " +
                " OFFENCE_DATE =?," +
                " REPORTED_DATE =?, " +
                " OFFENDER_ID =?, " +
                " OFFENCE_TYPE =?, " +
                " DESCRIPTION_OF_OFFENCE =?, " +
                " REPITITION_OF_OFFENCE =?, " +
                " REQUESTED_MEASURE_TO_BE_TAKEN =?, " +
                " IS_DOCUMENT_ATTACHED =?, " +
                " STATUS =?, " +
                " RECOREDED_BY =?, " +
                " TIME_STAMP =?, " +
                " EMPLOYEE_STATUS =? " +
                " WHERE DISCIPLINE_PROBLEM_ID =? ";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            _ps.setString(1, requestModel.getRequesterType());
            _ps.setString(2, requestModel.getRequesterId());

            _ps.setString(3, requestModel.getDateOfOffence());
            _ps.setString(4, requestModel.getReportedDate());
            _ps.setString(5, requestModel.getOffenderId());

            _ps.setString(6, requestModel.getOffenceType());
            _ps.setString(7, requestModel.getDescriptionOfOffence());
            _ps.setInt(8, requestModel.getRepititionOfOffence());

            _ps.setString(9, requestModel.getRequestedMeasureToBeTaken());
            _ps.setString(10, requestModel.getDocumentReferenceNumber());
            _ps.setString(11, requestModel.getStatus());

            _ps.setString(12, requestModel.getRecordedBy());
            _ps.setString(13, requestModel.getTimeStamp());
            _ps.setString(14, requestModel.getEmployeeStatus());
            _ps.setInt(15, requestModel.getDisciplineProblemId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Deletes DisciplineRequest from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean deleteDisciplineRequest(int requestId) throws SQLException {
        String _deleteRequestQuery = "DELETE HR_LEAVE_REQUEST  WHERE LEAVE_REQUEST_ID=?";
        String _deleteDatesQuery = "DELETE HR_LEAVE_REQUEST_DATE_DURATION  WHERE REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteRequestQuery);
            _ps.setInt(1, requestId);
            _ps.executeUpdate();

            _ps = _con.prepareStatement(_deleteDatesQuery);
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
    public ResultSet selectDisciplineRequestFromId(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID,DI.REQUESTER_TYPE,DI.REQUESTER_ID," +
                " DI.OFFENCE_DATE,DI.REPORTED_DATE,DI.OFFENDER_ID,DI.OFFENCE_TYPE,DI.DESCRIPTION_OF_OFFENCE," +
                " DI.REQUESTED_MEASURE_TO_BE_TAKEN,DI.IS_DOCUMENT_ATTACHED,DI.REPITITION_OF_OFFENCE,DI.RECOREDED_BY," +
                " DI.TIME_STAMP,DI.STATUS,DI.REPORTER_ID,DI.REPORTER_FULLNAME,DI.REPORTER_DEPARTMENT,DI.REPORTER_POSITION,DI.EMPLOYEE_STATUS,PLT.PENALTY_TYPE_ID,PLT.MONETARY_PENALTY_DAYS,PLT.DEDUCTION_DURATION,PLT.PENALTY_NAME," +
                " DTR.PROCESS_NAME,DTR.PROCESS_TRANSFER,DTR.DURATION,DTR.DURATION_TRANSFER,DLT.DESCIPLINE_CATAGORY,DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI" +
                " inner join HR_DISCIPLINED_TYPE_REPITITION DTR on DI.OFFENCE_TYPE=DTR.DESCIPLINE_TYPE " +
                " inner join HR_LU_PENALTY_TYPE PLT on PLT.PENALTY_TYPE_ID=DTR.PENALTY " +
                " inner join HR_LU_DISCIPLINE_TYPE DLT on DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ? and DI.OFFENCE_TYPE= ? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    //=============================================This is for Manager Selection================================================
    public ResultSet selectDisciplineRequestFromIdForManager(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID, " +
                "  DI.REQUESTER_TYPE, " +
                "  DI.REQUESTER_ID, " +
                "  DI.OFFENCE_DATE, " +
                "  DI.REPORTED_DATE, " +
                "  DI.OFFENDER_ID, " +
                "  DI.OFFENCE_TYPE, " +
                "  DI.DESCRIPTION_OF_OFFENCE, " +
                "  DI.REQUESTED_MEASURE_TO_BE_TAKEN, " +
                "  DI.IS_DOCUMENT_ATTACHED, " +
                "  DI.REPITITION_OF_OFFENCE, " +
                "  DI.RECOREDED_BY, " +
                "  DI.TIME_STAMP, " +
                "  DI.STATUS, " +
                "  DI.REPORTER_ID, " +
                "  DI.REPORTER_FULLNAME, " +
                "  DI.REPORTER_DEPARTMENT, " +
                "  DI.REPORTER_POSITION," +
                "  DI.EMPLOYEE_STATUS, " +
                "  PLT.PENALTY_TYPE_ID, " +
                "  PLT.MONETARY_PENALTY_DAYS, " +
                "  PLT.DEDUCTION_DURATION, " +
                "  PLT.PENALTY_NAME, " +
                "  DTR.PROCESS_NAME, " +
                "  DTR.PROCESS_TRANSFER, " +
                "  DTR.DURATION, " +
                "  DTR.DURATION_TRANSFER," +
                "  DLT.DESCIPLINE_CATAGORY," +
                " DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI " +
                " INNER JOIN HR_DISCIPLINED_TYPE_REP_MAN DTR " +
                " ON DI.OFFENCE_TYPE=DTR.DESCIPLINE_TYPE " +
                " INNER JOIN HR_LU_MANAGEMENT_PENALTY_TYPE PLT " +
                " ON PLT.PENALTY_TYPE_ID =DTR.PENALTY " +
                " inner join HR_LU_MNG_DISCIPLINE_TYPE DLT on " +
                " DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ?" +
                " AND DI.OFFENCE_TYPE=? ";
    


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    //========================================This is the Manager Selection for the SecoundReputaion==================================================================
    public ResultSet selectDisciplineRequestFromIdSecondReputaionForManager(String offenceType, int requestId) throws SQLException {

        String _selectQuery = "SELECT DI.DISCIPLINE_PROBLEM_ID, " +
                "  DI.REQUESTER_TYPE, " +
                "  DI.REQUESTER_ID, " +
                "  DI.OFFENCE_DATE, " +
                "  DI.REPORTED_DATE, " +
                "  DI.OFFENDER_ID, " +
                "  DI.OFFENCE_TYPE, " +
                "  DI.DESCRIPTION_OF_OFFENCE, " +
                "  DI.REQUESTED_MEASURE_TO_BE_TAKEN, " +
                "  DI.IS_DOCUMENT_ATTACHED, " +
                "  DI.REPITITION_OF_OFFENCE, " +
                "  DI.RECOREDED_BY, " +
                "  DI.TIME_STAMP, " +
                "  DI.STATUS, " +
                "  DI.REPORTER_ID, " +
                "  DI.REPORTER_FULLNAME, " +
                "  DI.REPORTER_DEPARTMENT, " +
                "  DI.REPORTER_POSITION, " +
                "  DI.EMPLOYEE_STATUS, " +
                "  PLT.PENALTY_TYPE_ID, " +
                "  PLT.MONETARY_PENALTY_DAYS, " +
                "  PLT.DEDUCTION_DURATION, " +
                "  PLT.PENALTY_NAME, " +
                "  DTR2.PROCESS_NAME, " +
                "  DTR2.PROCESS_TRANSFER, " +
                "  DTR2.DURATION, " +
                "  DTR2.DURATION_TRANSFER " +
                "  DLT.DESCIPLINE_CATAGORY," +
                " DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI " +
                " INNER JOIN HR_DISCIP_TYPE_REPI_SECOND_MNG DTR2 " +
                " ON DI.OFFENCE_TYPE=DTR2.DESCIPLINE_TYPE " +
                " INNER JOIN HR_LU_MANAGEMENT_PENALTY_TYPE PLT " +
                " ON PLT.PENALTY_TYPE_ID=DTR2.PENALTY " +
                " inner join HR_LU_MNG_DISCIPLINE_TYPE DLT on " +
                " DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID=?" +
                " AND DI.OFFENCE_TYPE= ?";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=================================================================================================================================================================

    public ResultSet selectDisciplineRequestFromIdSecondReputaion(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID,DI.REQUESTER_TYPE,DI.REQUESTER_ID," +
                " DI.OFFENCE_DATE,DI.REPORTED_DATE,DI.OFFENDER_ID,DI.OFFENCE_TYPE,DI.DESCRIPTION_OF_OFFENCE," +
                " DI.REQUESTED_MEASURE_TO_BE_TAKEN,DI.IS_DOCUMENT_ATTACHED,DI.REPITITION_OF_OFFENCE,DI.RECOREDED_BY," +
                " DI.TIME_STAMP,DI.STATUS,DI.REPORTER_ID,DI.REPORTER_FULLNAME,DI.REPORTER_DEPARTMENT,DI.REPORTER_POSITION,DI.EMPLOYEE_STATUS,PLT.PENALTY_TYPE_ID,PLT.MONETARY_PENALTY_DAYS,PLT.DEDUCTION_DURATION,PLT.PENALTY_NAME," +
                " DTR2.PROCESS_NAME,DTR2.PROCESS_TRANSFER,DTR2.DURATION,DTR2.DURATION_TRANSFER,DLT.DESCIPLINE_CATAGORY,DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI" +
                " inner join HR_DISCIP_TYPE_REPI_SECOND DTR2 on DI.OFFENCE_TYPE=DTR2.DESCIPLINE_TYPE " +
                " inner join HR_LU_PENALTY_TYPE PLT on PLT.PENALTY_TYPE_ID=DTR2.PENALTY " +
                 " inner join HR_LU_DISCIPLINE_TYPE DLT on DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ? and DI.OFFENCE_TYPE= ? ";
     

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===========================================================================================================

    public ResultSet selectDisciplineRequestFromIdThiredReputaion(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID,DI.REQUESTER_TYPE,DI.REQUESTER_ID," +
                " DI.OFFENCE_DATE,DI.REPORTED_DATE,DI.OFFENDER_ID,DI.OFFENCE_TYPE,DI.DESCRIPTION_OF_OFFENCE," +
                " DI.REQUESTED_MEASURE_TO_BE_TAKEN,DI.IS_DOCUMENT_ATTACHED,DI.REPITITION_OF_OFFENCE,DI.RECOREDED_BY," +
                " DI.TIME_STAMP,DI.STATUS,DI.REPORTER_ID,DI.REPORTER_FULLNAME,DI.REPORTER_DEPARTMENT,DI.REPORTER_POSITION,DI.EMPLOYEE_STATUS,PLT.PENALTY_TYPE_ID,PLT.MONETARY_PENALTY_DAYS,PLT.DEDUCTION_DURATION,PLT.PENALTY_NAME," +
                " DTR3.PROCESS_NAME,DTR3.PROCESS_TRANSFER,DTR3.DURATION,DTR3.DURATION_TRANSFER,DLT.DESCIPLINE_CATAGORY,DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI" +
                " inner join HR_DISCIP_TYPE_REPI_THIRD DTR3 on DI.OFFENCE_TYPE=DTR3.DESCIPLINE_TYPE " +
                " inner join HR_LU_PENALTY_TYPE PLT on PLT.PENALTY_TYPE_ID=DTR3.PENALTY " +
                " inner join HR_LU_DISCIPLINE_TYPE DLT on DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ? and DI.OFFENCE_TYPE= ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //====================================================================================================================================================
    //======================================================This is the Manager Thired Reputaion===========================================================

    public ResultSet selectDisciplineRequestFromIdThiredReputaionForManager(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID, " +
                "  DI.REQUESTER_TYPE, " +
                "  DI.REQUESTER_ID, " +
                "  DI.OFFENCE_DATE, " +
                "  DI.REPORTED_DATE, " +
                "  DI.OFFENDER_ID, " +
                "  DI.OFFENCE_TYPE, " +
                "  DI.DESCRIPTION_OF_OFFENCE, " +
                "  DI.REQUESTED_MEASURE_TO_BE_TAKEN, " +
                "  DI.IS_DOCUMENT_ATTACHED, " +
                "  DI.REPITITION_OF_OFFENCE, " +
                "  DI.RECOREDED_BY, " +
                "  DI.TIME_STAMP, " +
                "  DI.STATUS, " +
                "  DI.REPORTER_ID, " +
                "  DI.REPORTER_FULLNAME, " +
                "  DI.REPORTER_DEPARTMENT, " +
                "  DI.REPORTER_POSITION, " +
                " DI.EMPLOYEE_STATUS," +
                "  PLT.PENALTY_TYPE_ID, " +
                "  PLT.MONETARY_PENALTY_DAYS, " +
                "  PLT.DEDUCTION_DURATION, " +
                "  PLT.PENALTY_NAME, " +
                "  DTR3.PROCESS_NAME, " +
                "  DTR3.PROCESS_TRANSFER, " +
                "  DTR3.DURATION, " +
                "  DTR3.DURATION_TRANSFER " +
                "  DLT.DESCIPLINE_CATAGORY," +
                " DLT.DISCIPLINE_SUBCATAGORY " +
                "FROM HR_DISCIPLINE_ISSUE DI " +
                "INNER JOIN HR_DISCIP_TYPE_REPI_THIRD_MNG DTR3 " +
                "ON DI.OFFENCE_TYPE=DTR3.DESCIPLINE_TYPE " +
                "INNER JOIN HR_LU_MANAGEMENT_PENALTY_TYPE PLT " +
                " ON PLT.PENALTY_TYPE_ID=DTR3.PENALTY " +
                " inner join HR_LU_MNG_DISCIPLINE_TYPE DLT on " +
                " DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                "WHERE DI.DISCIPLINE_PROBLEM_ID=? " +
                "AND DI.OFFENCE_TYPE=? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=====================================================================================================================================================

    public ResultSet selectDisciplineRequestFromIdForthReputaion(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID,DI.REQUESTER_TYPE,DI.REQUESTER_ID," +
                " DI.OFFENCE_DATE,DI.REPORTED_DATE,DI.OFFENDER_ID,DI.OFFENCE_TYPE,DI.DESCRIPTION_OF_OFFENCE," +
                " DI.REQUESTED_MEASURE_TO_BE_TAKEN,DI.IS_DOCUMENT_ATTACHED,DI.REPITITION_OF_OFFENCE,DI.RECOREDED_BY," +
                " DI.TIME_STAMP,DI.STATUS,DI.REPORTER_ID,DI.REPORTER_FULLNAME,DI.REPORTER_DEPARTMENT,DI.REPORTER_POSITION,DI.EMPLOYEE_STATUS,PLT.PENALTY_TYPE_ID,PLT.MONETARY_PENALTY_DAYS,PLT.DEDUCTION_DURATION,PLT.PENALTY_NAME," +
                " DTR4.PROCESS_NAME,DTR4.PROCESS_TRANSFER,DTR4.DURATION,DTR4.DURATION_TRANSFE,DLT.DESCIPLINE_CATAGORY,DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI" +
                " inner join HR_DISCIP_TYPE_REPI_FORTH DTR4 on DI.OFFENCE_TYPE=DTR4.DESCIPLINE_TYPE " +
                " inner join HR_LU_PENALTY_TYPE PLT on PLT.PENALTY_TYPE_ID=DTR4.PENALTY " +
                " inner join HR_LU_DISCIPLINE_TYPE DLT on DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ? and DI.OFFENCE_TYPE= ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=====================================================================================================================================================
    //===================================================This is the fourth Reputaion for the managers=====================================================

    public ResultSet selectDisciplineRequestFromIdForthReputaionForManager(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID, " +
                "  DI.REQUESTER_TYPE, " +
                "  DI.REQUESTER_ID, " +
                "  DI.OFFENCE_DATE, " +
                "  DI.REPORTED_DATE, " +
                "  DI.OFFENDER_ID, " +
                "  DI.OFFENCE_TYPE, " +
                "  DI.DESCRIPTION_OF_OFFENCE, " +
                "  DI.REQUESTED_MEASURE_TO_BE_TAKEN, " +
                "  DI.IS_DOCUMENT_ATTACHED, " +
                "  DI.REPITITION_OF_OFFENCE, " +
                "  DI.RECOREDED_BY, " +
                "  DI.TIME_STAMP, " +
                "  DI.STATUS, " +
                "  DI.REPORTER_ID, " +
                "  DI.REPORTER_FULLNAME, " +
                "  DI.REPORTER_DEPARTMENT, " +
                "  DI.REPORTER_POSITION, " +
                " DI.EMPLOYEE_STATUS," +
                "  PLT.PENALTY_TYPE_ID, " +
                "  PLT.MONETARY_PENALTY_DAYS, " +
                "  PLT.DEDUCTION_DURATION, " +
                "  PLT.PENALTY_NAME, " +
                "  DTR4.PROCESS_NAME, " +
                "  DTR4.PROCESS_TRANSFER, " +
                "  DTR4.DURATION, " +
                "  DTR4.DURATION_TRANSFER " +
                "  DLT.DESCIPLINE_CATAGORY," +
                "  DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI " +
                " INNER JOIN HR_DISCIP_TYPE_REPI_FORTH_MNG DTR4 " +
                " ON DI.OFFENCE_TYPE=DTR4.DESCIPLINE_TYPE " +
                " INNER JOIN HR_LU_MANAGEMENT_PENALTY_TYPE PLT " +
                " ON PLT.PENALTY_TYPE_ID =DTR4.PENALTY " +
                " inner join HR_LU_MNG_DISCIPLINE_TYPE DLT on " +
                " DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID=?" +
                " AND DI.OFFENCE_TYPE=? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //====================================================================================================================================================

    public ResultSet selectDisciplineRequestFromIdFivesReputaion(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID,DI.REQUESTER_TYPE,DI.REQUESTER_ID," +
                " DI.OFFENCE_DATE,DI.REPORTED_DATE,DI.OFFENDER_ID,DI.OFFENCE_TYPE,DI.DESCRIPTION_OF_OFFENCE," +
                " DI.REQUESTED_MEASURE_TO_BE_TAKEN,DI.IS_DOCUMENT_ATTACHED,DI.REPITITION_OF_OFFENCE,DI.RECOREDED_BY," +
                " DI.TIME_STAMP,DI.STATUS,DI.REPORTER_ID,DI.REPORTER_FULLNAME,DI.REPORTER_DEPARTMENT,DI.REPORTER_POSITION,DI.EMPLOYEE_STATUS,PLT.PENALTY_TYPE_ID,PLT.MONETARY_PENALTY_DAYS,PLT.DEDUCTION_DURATION,PLT.PENALTY_NAME," +
                " DTR5.PROCESS_NAME,DTR5.PROCESS_TRANSFER,DTR5.DURATION,DTR5.DURATION_TRANSFER,DLT.DESCIPLINE_CATAGORY,DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI" +
                " inner join HR_DISCIP_TYPE_REPI_FIVES DTR5 on DI.OFFENCE_TYPE=DTR5.DESCIPLINE_TYPE " +
                " inner join HR_LU_PENALTY_TYPE PLT on PLT.PENALTY_TYPE_ID=DTR5.PENALTY " +
                " inner join HR_LU_DISCIPLINE_TYPE DLT on DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                " WHERE DI.DISCIPLINE_PROBLEM_ID= ? and DI.OFFENCE_TYPE= ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //==========================================================================================================================================
    //===============================================FivesReputaionForManager===================================================================

    public ResultSet selectDisciplineRequestFromIdFivesReputaionForManager(String offenceType, int requestId) throws SQLException {

        String _selectQuery = " SELECT DI.DISCIPLINE_PROBLEM_ID, " +
                "  DI.REQUESTER_TYPE, " +
                "  DI.REQUESTER_ID, " +
                "  DI.OFFENCE_DATE, " +
                "  DI.REPORTED_DATE, " +
                "  DI.OFFENDER_ID, " +
                "  DI.OFFENCE_TYPE, " +
                "  DI.DESCRIPTION_OF_OFFENCE, " +
                "  DI.REQUESTED_MEASURE_TO_BE_TAKEN, " +
                "  DI.IS_DOCUMENT_ATTACHED, " +
                "  DI.REPITITION_OF_OFFENCE, " +
                "  DI.RECOREDED_BY, " +
                "  DI.TIME_STAMP, " +
                "  DI.STATUS, " +
                "  DI.REPORTER_ID, " +
                "  DI.REPORTER_FULLNAME, " +
                "  DI.REPORTER_DEPARTMENT, " +
                "  DI.REPORTER_POSITION, " +
                "  DI.EMPLOYEE_STATUS," +
                "  PLT.PENALTY_TYPE_ID, " +
                "  PLT.MONETARY_PENALTY_DAYS, " +
                "  PLT.DEDUCTION_DURATION, " +
                "  PLT.PENALTY_NAME, " +
                "  DTR5.PROCESS_NAME, " +
                "  DTR5.PROCESS_TRANSFER, " +
                "  DTR5.DURATION, " +
                "  DTR5.DURATION_TRANSFER " +
                "  DLT.DESCIPLINE_CATAGORY," +
                " DLT.DISCIPLINE_SUBCATAGORY " +
                " FROM HR_DISCIPLINE_ISSUE DI " +
                " INNER JOIN HR_DISCIP_TYPE_REPI_FIVES_MNG DTR5 " +
                " ON DI.OFFENCE_TYPE=DTR5.DESCIPLINE_TYPE " +
                " INNER JOIN HR_LU_MANAGEMENT_PENALTY_TYPE PLT " +
                " ON PLT.PENALTY_TYPE_ID=DTR5.PENALTY " +
                " inner join HR_LU_MNG_DISCIPLINE_TYPE DLT on " +
                " DLT.DESCIPLINE_TYPE_ID=DI.OFFENCE_TYPE  " +
                "WHERE DI.DISCIPLINE_PROBLEM_ID=? " +
                "AND DI.OFFENCE_TYPE=? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, offenceType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    //==========================================================================================================================================
    public ResultSet selectDisciplineTypes() throws SQLException {

        String _selectQuery = "SELECT * FROM HR_LU_DISCIPLINE_TYPE";

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
    //============================================================Selection For manager DisciplineType==================================================

    public ResultSet selectDisciplineTypesForManager() throws SQLException {

        String _selectQuery = "SELECT * FROM HR_LU_MNG_DISCIPLINE_TYPE ";

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

    //==================================================================================================================================================
    public ResultSet selectCurrentRequestId() throws SQLException {
        String _selectQuery = "SELECT MAX(DISCIPLINE_PROBLEM_ID) AS CURRENT_REQUEST_ID" +
                " FROM HR_DISCIPLINE_ISSUE";

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

    public ResultSet CheakPreviousPenality(String accusedEmployeeID, int reputaionCondition) throws SQLException {
        String _selectQuery = " SELECT HR_DISCIPLINE_ISSUE.OFFENDER_ID,HR_DISCIPLINE_ISSUE.REPITITION_OF_OFFENCE,OFFENCE_TYPE from HR_DISCIPLINE_ISSUE" +
                " where hr_discipline_issue.status like 'App%' " +
                " and HR_DISCIPLINE_ISSUE.OFFENDER_ID=? ";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, accusedEmployeeID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=======================================================NewlyAdded==============================================================================

    public ResultSet CheakPreviousPenalityNewlyAdded(String accusedEmployeeID, int reputaionCondition, int offenceType, int reputaion) throws SQLException {
//        String _selectQuery = " SELECT HR_DISCIPLINE_ISSUE.OFFENDER_ID,HR_DISCIPLINE_ISSUE.REPITITION_OF_OFFENCE,OFFENCE_TYPE,subStr(HR_DISCIPLINE_PROCESSED.TIME_STAMP,1,10)as approvedate from HR_DISCIPLINE_ISSUE,HR_DISCIPLINE_PROCESSED" +
//                " where hr_discipline_issue.status like 'App%' and HR_DISCIPLINE_ISSUE.DISCIPLINE_PROBLEM_ID=hr_discipline_processed.request_id " +
//                " and HR_DISCIPLINE_ISSUE.OFFENDER_ID=? " +
//                " and HR_DISCIPLINE_ISSUE.OFFENCE_TYPE=? " +
//                " and repitition_of_offence=? ";

        String _SqlQuerySelection = " SELECT HR_DISCIPLINE_ISSUE.OFFENDER_ID,HR_DISCIPLINE_ISSUE.REPITITION_OF_OFFENCE,OFFENCE_TYPE,subStr(HR_DISCIPLINE_PROCESSED.TIME_STAMP,1,10) as approvedate " +
                " from HR_DISCIPLINE_ISSUE,HR_DISCIPLINE_PROCESSED where hr_discipline_issue.status like 'App%' " +
                " and HR_DISCIPLINE_ISSUE.DISCIPLINE_PROBLEM_ID=hr_discipline_processed.request_id and HR_DISCIPLINE_ISSUE.OFFENCE_TYPE=?" +
                " and repitition_of_offence=? and HR_DISCIPLINE_ISSUE.OFFENDER_ID=? ";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_SqlQuerySelection);
            _ps.setInt(1, offenceType);
            _ps.setInt(2, reputaion);
            _ps.setString(3, accusedEmployeeID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================

    /**
     * returns ResultSet of descipline types.<br>
     * It returns a ResultSet of either a single row or with no row.
     * @param  requestId  primary key of the table.
     * @throws  SQLException
     */
    public ResultSet selectDisciplineReport(DisciplineRequestModel requestParameter) throws SQLException {
        String _selectQuery = "SELECT * FROM VW_DISCIPLINE_REPORT " +
                " WHERE " +
                " REQUESTER_ID <=? AND " +
                " REQUESTER_ID >=? AND " +
                " OFFENDER_ID <=? AND " +
                " OFFENDER_ID >=? AND " +
                " OFFENCE_DATE <=? AND " +
                " OFFENCE_DATE >=? AND " +
                " OFFENCE_TYPE <=? AND " +
                " OFFENCE_TYPE >=? AND " +
                " PENALTY_ID <=? AND " +
                " PENALTY_ID >=? AND " +
                //                " REPITITION_OF_OFFENCE <=? AND " +
                //                " REPITITION_OF_OFFENCE >=? " +
                //                " ";
                " AND  STATUS IN  (" + requestParameter.getStatus() + ")";
//                " AND " +
//                " DEPT IN (SELECT DEPT_ID " +
//                "   FROM TBL_DEPARTMENT  " +
//                "    START WITH DEPT_ID      = 1" +///substitute 1 by dept id of offender
//                "    CONNECT BY PRIOR DEPT_ID=BRANCH_ID )";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requestParameter.getRequesterId().equals("-1") ? "ZZ/99999" : requestParameter.getRequesterId());
            _ps.setString(2, requestParameter.getRequesterId().equals("-1") ? "AA/00000" : requestParameter.getRequesterId());
            _ps.setString(3, requestParameter.getOffenderId().equals("-1") ? "ZZ/99999" : requestParameter.getOffenderId());
            _ps.setString(4, requestParameter.getOffenderId().equals("-1") ? "AA/00000" : requestParameter.getOffenderId());
            _ps.setString(5, requestParameter.getDisciplineToDate().equals("-1") ? "9999-12-31" : requestParameter.getDisciplineToDate());
            _ps.setString(6, requestParameter.getDisciplineFromDate().equals("-1") ? "1900-01-01" : requestParameter.getDisciplineFromDate());
            //==========date and time=======================================
            _ps.setString(7, requestParameter.getOffenceType().equals("-1") ? "999999999999999" : requestParameter.getOffenceType());//-1 means any
            _ps.setString(8, requestParameter.getOffenceType().equals("-1") ? "0" : requestParameter.getOffenceType());//-1 means any
            _ps.setString(9, requestParameter.getPenalty().equals("-1") ? "999999999999999" : requestParameter.getPenalty());//-1 means any
            _ps.setString(10, requestParameter.getPenalty().equals("-1") ? "0" : requestParameter.getPenalty());//-1 means any
            _ps.setInt(11, requestParameter.getRepititionOfOffence() == -1 ? 999999999 : requestParameter.getRepititionOfOffence());//-1 means any
            _ps.setInt(12, requestParameter.getRepititionOfOffence() == -1 ? -1 : requestParameter.getRepititionOfOffence());//-1 means any
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * @param disciplineId the unique id of displine type
     * @param employeeId
     * @param referenceDate  referenceDate =current date  - phaseout time
     * The offence has to be committed after <b>referenceDate </b> given in the argument
     */
    public ResultSet selectPreviousCommiteedOffenceByEmployee(int disciplineId, String employeeId, String referenceDate) throws SQLException {
        String _selectQuery = " SELECT COUNT (DISCIPLINE_PROBLEM_ID) AS NUMBER_OF_OFFENCES  " +
                " FROM HR_DISCIPLINE_ISSUE " +
                " WHERE OFFENCE_TYPE=? AND OFFENDER_ID=? AND OFFENCE_DATE > ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineId);
            _ps.setString(2, employeeId);
            _ps.setString(3, referenceDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet of descipline types.<br>
     * It returns a ResultSet of either a single row or with no row.
     * @param  requestId  primary key of the table.
     * @throws  SQLException
     */
    public ResultSet selectRequestsByStatus(String status) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE WHERE STATUS = ? and CANBE_APPROVED='False' ORDER BY REPORTED_DATE DESC ";
        String _innerSelectQuery = "to refine employees from the department of the logged in employee";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, status);
            //_ps.setString(2,userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
//======================================================================CanBeApprovedHere============================================================

    public ResultSet selectRequestsByStatusCanBeApprovedHere(String status) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE WHERE STATUS = ? and CANBE_APPROVED='True' ORDER BY REPORTED_DATE DESC ";
        String _innerSelectQuery = "to refine employees from the department of the logged in employee";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, status);
            //_ps.setString(2,userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
//===================================================================================================================================================

    public ResultSet selectProcessedRequestsByRequester(String requesterId, String recorededBy) throws SQLException {

        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE" +
                "  WHERE STATUS not like " + DisciplineApproveManager.INITIAL_STATE_DISCIPLINE + " " +
                " AND ( REQUESTER_ID like ? or RECOREDED_BY like ? )" +
                " order by REPORTED_DATE desc";
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

    public ResultSet selectRequestsByAccusedAndStatus(String accusedEmployeeId, String userName, String status) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE " +
                " WHERE STATUS = ? " +
                //                " AND OFFENDER_ID=?" +
                " AND DISCIPLINE_PROBLEM_ID NOT IN (SELECT REQUEST_ID FROM HR_DISCIPLINE_ACCUSED_COMMENT)" +
                " AND ( OFFENDER_ID = ?  OR  RECOREDED_BY = ? )";
        String _innerSelectQuery = "to refine employees from the department of the loogged in employee";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, status);
            _ps.setString(2, accusedEmployeeId);
            _ps.setString(3, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectOffencesCommittedByEmployee(String employeeId) throws SQLException {
        String _selectQuery = " SELECT DISCIPLINE_PROBLEM_ID,REQUESTER_TYPE," +
                " REQUESTER_ID,OFFENCE_DATE,REPORTED_DATE," +
                " OFFENDER_ID,OFFENCE_TYPE,OFFENCE_NAME," +
                " DESCRIPTION_OF_OFFENCE,REQUESTED_MEASURE_TO_BE_TAKEN," +
                " IS_DOCUMENT_ATTACHED,REPITITION_OF_OFFENCE," +
                " RECOREDED_BY,TIME_STAMP,STATUS" +
                " FROM HR_DISCIPLINE_ISSUE,HR_LU_DISCIPLINE_TYPE" +
                " WHERE DESCIPLINE_TYPE_ID=OFFENCE_TYPE " +
                " AND  OFFENDER_ID=?";
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
}
