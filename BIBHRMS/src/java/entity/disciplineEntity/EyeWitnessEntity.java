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
import java.util.ArrayList;
import manager.disciplineManager.EyeWitnessManager.EyeWitnessModel;
import manager.disciplineManager.EyeWitnessManager.FileUpLoad;
import manager.disciplineManager.EyeWitnessManager.OtherEyeWitnessFileUpLoad;
import manager.disciplineManager.EyeWitnessManager.OtherMemberEyeWitnessModel;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class EyeWitnessEntity extends ConnectionManager {

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

    public boolean SaveOtherEyeWitness(ArrayList<OtherMemberEyeWitnessModel> toBeInserted) throws SQLException {
        String _insertOtherWitnessQuery = "INSERT INTO HR_DISCIPLINE_OTHER_WITNESS  (OTHER_WINESS_ID," +
                "DISCIPLINE_PROBLEM_ID, WITNESS_FULL_NAME," +
                "WITNESS_SEX,WITNESS_AGE, WITNESS_REGION," +
                " WITNESS_ZONE, WITNESS_WOREDA, WITNESS_KEBELE," +
                " WITNESS_HOUSE_NUMBER, WITNESS_PO_BOX,  WITNESS_MOBILE," +
                " WITNESS_EMAILE," +
                "  WITNESS_TELE_OFFICE, WITNESS_TELE_HOME," +
                " DATABASE_STATUS )  " +
                "VALUES (HR_DISCIPLINE_OTHERWITNESS_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessQuery);
            for (OtherMemberEyeWitnessModel currentotherEyewitness : toBeInserted) {
                _ps.setInt(1, currentotherEyewitness.getDisciplineProblemID());
                _ps.setString(2, currentotherEyewitness.getOtherwitnessFullName());
                _ps.setString(3, currentotherEyewitness.getOtherwitnesSsex());
                _ps.setInt(4, currentotherEyewitness.getOtherwitnessAge());
                _ps.setString(5, currentotherEyewitness.getOtherwitnessRegion());
                _ps.setString(6, currentotherEyewitness.getOtherwitnessZone());
                _ps.setString(7, currentotherEyewitness.getOtherwitnessWoreda());
                _ps.setString(8, currentotherEyewitness.getOtherwitnessKebele());
                _ps.setString(9, currentotherEyewitness.getOtherwitnessHouseNumber());
                _ps.setString(10, currentotherEyewitness.getOtherwitnessPobox());
                _ps.setInt(11, currentotherEyewitness.getOtherwitnessMobile());
                _ps.setString(12, currentotherEyewitness.getOtherwitnessEmail());
                _ps.setInt(13, currentotherEyewitness.getOtherwitnessTeleOffice());
                _ps.setInt(14, currentotherEyewitness.getOtherwitnessTeleHome());
                _ps.setString(15, "Old");
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }

    }

    public boolean UpdateOtherEyeWitness(ArrayList<OtherMemberEyeWitnessModel> toBeUpdate) throws SQLException {

        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIPLINE_OTHER_WITNESS  SET " +
                "WITNESS_FULL_NAME =?," +
                "WITNESS_SEX =?," +
                "WITNESS_AGE = ?," +
                "WITNESS_REGION =?,WITNESS_ZONE=?,WITNESS_WOREDA=?," +
                "WITNESS_KEBELE=?,WITNESS_HOUSE_NUMBER=?, " +
                "WITNESS_PO_BOX=?, WITNESS_MOBILE=?," +
                "WITNESS_TELE_OFFICE=?,WITNESS_TELE_HOME=? " +
                "WHERE OTHER_WINESS_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (OtherMemberEyeWitnessModel currentEyeWitness : toBeUpdate) {
                _ps.setString(1, currentEyeWitness.getOtherwitnessFullName());
                _ps.setString(2, currentEyeWitness.getOtherwitnesSsex());
                _ps.setInt(3, currentEyeWitness.getOtherwitnessAge());
                _ps.setString(4, currentEyeWitness.getOtherwitnessRegion());
                _ps.setString(5, currentEyeWitness.getOtherwitnessZone());
                _ps.setString(6, currentEyeWitness.getOtherwitnessWoreda());
                _ps.setString(7, currentEyeWitness.getOtherwitnessKebele());
                _ps.setString(8, currentEyeWitness.getOtherwitnessHouseNumber());
                _ps.setString(9, currentEyeWitness.getOtherwitnessPobox());
                _ps.setInt(10, currentEyeWitness.getOtherwitnessMobile());
                _ps.setInt(11, currentEyeWitness.getOtherwitnessTeleOffice());
                _ps.setInt(12, currentEyeWitness.getOtherwitnessTeleHome());
                _ps.setInt(13, currentEyeWitness.getOtherWitnessID());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean DeleteOtherEyeWitness(ArrayList<OtherMemberEyeWitnessModel> toBeDeleted) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean insertEyeWitnesses(ArrayList<EyeWitnessModel> eyeWitnessList, int disciplineID, String witnessCondition) {

        String _insertDisciplineProblemQuery = " INSERT INTO HR_DISCIPLINE_EYE_WITNESS " +
                " (EYE_WITNESS_ID," +
                " DISCIPLINE_REQUEST_ID," +
                " WITNESS_ID," +
                " POINTED_BY_REQUESTER," +
                " POINTED_BY_ACCUSED, " +
                " SUMMARY, " +
                " EVENT_DESCRIPTION, " +
                " USER_NAME, " +
                " TIME_STAMP," +
                " WITNESS_CONDITION)" +
                " VALUES (HR_DISCIPLINE_EYE_WITNESS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?,? )";

        //  try {
        try {
            _con = getConnection();


            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (EyeWitnessModel currentEyeWitness : eyeWitnessList) {
                _ps.setInt(1, currentEyeWitness.getDisciplineRequestId());
                _ps.setString(2, currentEyeWitness.getWitnessId());
                _ps.setString(3, currentEyeWitness.getPointedByRequester());
                _ps.setString(4, currentEyeWitness.getPointedByAccused());
                _ps.setString(5, currentEyeWitness.getSummary());
                _ps.setString(6, currentEyeWitness.getEventDescription());
                _ps.setString(7, currentEyeWitness.getUserName());
                _ps.setString(8, currentEyeWitness.getTimeStamp());
                _ps.setString(9, currentEyeWitness.getWitnessCondition());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
//                _con.rollback(firstSavePoint);
            return false;
        }


    }

    public boolean deletOtherEyeWitnessesWord(int deletedId) throws SQLException {

        String _deleteEyeWitnessQuery = " DELETE HR_OTHER_EYEWITNESS_WORD " +
                " WHERE OTHER_EYE_WITNESS_ID = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteEyeWitnessQuery);
            _ps.setInt(1, deletedId);


//            for (OtherMemberEyeWitnessModel currentEyeWitness : toBeDeleted) {
//                _ps.setInt(1, currentEyeWitness.getOther_Eye_Witnessword_ID());
//                _ps.addBatch();
//            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertOtherEyeWitnessesWord(ArrayList<OtherMemberEyeWitnessModel> othereyeWitnessList, int disciplineProblemId, String condition, String time_Stamp) {
        String _insertDisciplineProblemQuery = " INSERT INTO HR_OTHER_EYEWITNESS_WORD " +
                " (OTHER_EYE_WITNESS_ID," +
                " DISCIPLINE_REQUEST_ID," +
                " WITNESS_ID," +
                " POINTED_BY," +
                " SUMMARY, " +
                " EVENT_DESCRIPTION, " +
                " TIME_STAMP," +
                " WITNESS_CONDITION,WITNESS_FULL_NAME,DOC_REFERANCE" +
                " )" +
                " VALUES (HR_DISCIPLINE_EYE_WITNESS_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        //  try {
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (OtherMemberEyeWitnessModel currentEyeWitness : othereyeWitnessList) {
                _ps.setInt(1, currentEyeWitness.getDisciplineProblemID());
                _ps.setInt(2, currentEyeWitness.getOtherWitnessID());
                _ps.setString(3, currentEyeWitness.getPointedBy());
                _ps.setString(4, currentEyeWitness.getSummary());
                _ps.setString(5, currentEyeWitness.getEventDescription());
                _ps.setString(6, time_Stamp);
                _ps.setString(7, "Other");
                _ps.setString(8, currentEyeWitness.getOtherwitnessFullName());
                _ps.setString(9, currentEyeWitness.getDocRefNumber());


                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
//                _con.rollback(firstSavePoint);
            return false;
        }
    }

    public ResultSet selectDocumentAttrbutie(int disciplineProblemId) {
          String qry = null;
        qry =" SELECT * FROM HR_DISCIPLINE_EYEWITNESS_FILE WHERE REQUEST_ID ='" + disciplineProblemId + "'and FILE_NAME='Commentes'";
        try {
           _con = getConnection();
            _ps = _con.prepareStatement( qry);
           _rs =  _ps.executeQuery();
           OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public ResultSet selectDocumentAttrbutieOther(int disciplineProblemId) {
          String qry = null;



        qry =" SELECT * FROM HR_DIS_OTHER_EYEWITNESS_FILE WHERE REQUEST_ID ='" + disciplineProblemId + "'and FILE_NAME='Commentes'";

        try {
           _con = getConnection();
            _ps = _con.prepareStatement( qry);
           _rs =  _ps.executeQuery();
           OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public OracleSerialBlob select_Document(int documentId) {
        String qry = null;

        qry =" SELECT ATTACHED_FILE FROM HR_DISCIPLINE_EYEWITNESS_FILE WHERE FILE_ID ='" + documentId + "'";
        try {
           _con = getConnection();
            _ps = _con.prepareStatement(qry);
           _rs =  _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
           if(ocrs.next()){
            return (OracleSerialBlob) ocrs.getBlob("ATTACHED_FILE");
           }else{
               return null;
           }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public OracleSerialBlob select_Document_Other(int documentId) {
        String qry = null;
        qry =" SELECT ATTACHED_FILE FROM HR_DIS_OTHER_EYEWITNESS_FILE WHERE FILE_ID ='" + documentId + "'";
        try {
           _con = getConnection();
            _ps = _con.prepareStatement(qry);
           _rs =  _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
           if(ocrs.next()){

            return (OracleSerialBlob) ocrs.getBlob("ATTACHED_FILE");
           }else{
               return null;
           }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean upDateIssue(int disciplineProblemId, String witnessConditoin) throws SQLException {
        String _updateQuery = " UPDATE HR_DISCIPLINE_ISSUE " +
                " SET WITNESS_TYPE= ? WHERE DISCIPLINE_PROBLEM_ID= ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, "Employee");
            _ps.setInt(2, disciplineProblemId);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
//                _con.rollback(firstSavePoint);
            return false;
        }
    }

    public boolean upDateIssueOther(int disciplineProblemId, String witnessConditoin) throws SQLException {
        String _updateQuery = " UPDATE HR_DISCIPLINE_ISSUE " +
                " SET WITNESS_TYPE_OTHER= ? WHERE DISCIPLINE_PROBLEM_ID= ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, "Other");
            _ps.setInt(2, disciplineProblemId);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
//                _con.rollback(firstSavePoint);
            return false;
        }
    }

    public ResultSet selectOtherEyeWitnesses(int disciplineRequestId) throws SQLException {
        String _selectQuery = "SELECT OTHER_WINESS_ID,WITNESS_FULL_NAME, " +
                "WITNESS_SEX, WITNESS_AGE " +
                ", WITNESS_REGION, WITNESS_ZONE," +
                " WITNESS_WOREDA,WITNESS_KEBELE," +
                "WITNESS_HOUSE_NUMBER,WITNESS_PO_BOX, " +
                "WITNESS_MOBILE, WITNESS_EMAILE," +
                "WITNESS_TELE_OFFICE," +
                " WITNESS_TELE_HOME,DATABASE_STATUS " +
                "FROM HR_DISCIPLINE_OTHER_WITNESS " +
                "WHERE HR_DISCIPLINE_OTHER_WITNESS.DISCIPLINE_PROBLEM_ID= ?" +
                " AND HR_DISCIPLINE_OTHER_WITNESS.DATABASE_STATUS='Old'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineRequestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectOtherEyeWitnessesWord(int disciplineRequestId) throws SQLException {

        String _selectQuery = " SELECT owi.*,owd.other_eye_witness_id,owd.POINTED_BY,owd.SUMMARY,owd.EVENT_DESCRIPTION,owd.time_stamp,owd.DOC_REFERANCE" +
                " FROM HR_DISCIPLINE_OTHER_WITNESS owi " +
                "left join HR_OTHER_EYEWITNESS_WORD owd on owd.discipline_request_id=OWI.DISCIPLINE_PROBLEM_ID  " +
                " WHERE owi.DATABASE_STATUS='Old' and owi.discipline_problem_id= ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, disciplineRequestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean updateEyeWitnesses(ArrayList<EyeWitnessModel> eyeWitnessList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE HR_DISCIPLINE_EYE_WITNESS " +
                " SET " +
                " DISCIPLINE_REQUEST_ID = ? ," +
                " WITNESS_ID = ? ," +
                " POINTED_BY_REQUESTER = ? ," +
                " POINTED_BY_ACCUSED = ? ," +
                " SUMMARY = ? ," +
                " EVENT_DESCRIPTION = ? ," +
                " REPORTED_DATE = ? , " +
                " DOC_REF_NUMBER = ? ," +
                " USER_NAME = ? ," +
                " TIME_STAMP = ? " +
                //   " STATUS " +
                " WHERE EYE_WITNESS_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (EyeWitnessModel currentEyeWitness : eyeWitnessList) {
                _ps.setInt(1, currentEyeWitness.getDisciplineRequestId());
                _ps.setString(2, currentEyeWitness.getWitnessId());
                _ps.setString(3, currentEyeWitness.getPointedByRequester());
                _ps.setString(4, currentEyeWitness.getPointedByAccused());
                _ps.setString(5, currentEyeWitness.getSummary());
                _ps.setString(6, currentEyeWitness.getEventDescription());
                _ps.setString(7, currentEyeWitness.getReportedDate());
                _ps.setString(8, currentEyeWitness.getDocRefNumber());
                _ps.setString(9, currentEyeWitness.getUserName());
                _ps.setString(10, currentEyeWitness.getTimeStamp());
                // _ps.setString(10, currentDateAndTime);
                _ps.setInt(11, currentEyeWitness.getDisciplineEyeWitnessId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deletEyeWitnesses(int deletedID) throws SQLException {
        String _deleteEyeWitnessQuery = "DELETE HR_DISCIPLINE_EYE_WITNESS " +
                " WHERE EYE_WITNESS_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteEyeWitnessQuery);
            _ps.setInt(1, deletedID);
            _ps.executeUpdate();
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEyeWitnesses(int disciplineRequestId) throws SQLException {
//        String _selectQuery = " SELECT HR_DISCIPLINE_EYE_WITNESS.*, " +
//                "  FIRST_NAME, " +
//                "  MIDDLE_NAME, " +
//                "  LAST_NAME , " +
//                "  DEPARTMENT_NAME " +
//                "FROM HR_DISCIPLINE_EYE_WITNESS, " +
//                "  VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
//                "WHERE HR_DISCIPLINE_EYE_WITNESS.DISCIPLINE_REQUEST_ID = ? " +
//                "AND HR_DISCIPLINE_EYE_WITNESS.WITNESS_ID = VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID";

        String _sqlUpdated = "SELECT DW .*, " +
                "  vw.FIRST_NAME, " +
                "  vw.MIDDLE_NAME, " +
                "  vw.LAST_NAME , " +
                "  vw.DEPARTMENT_NAME, " +
                "  EF.FILE_TYPE, " +
                "  EF.ATTACHED_FILE, " +
                "  EF.FILE_NAME " +
                "FROM HR_DISCIPLINE_EYE_WITNESS DW " +
                "LEFT JOIN HR_DISCIPLINE_EYEWITNESS_FILE EF " +
                "ON dw.witness_id=EF.WITNESS_ID " +
                "INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_LIST vw " +
                "ON dw.witness_id =vw.emp_id " +
                "WHERE dw.discipline_request_id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_sqlUpdated);
            _ps.setInt(1, disciplineRequestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    boolean tray = true;

    public boolean updateOtherEyeWitnessesWord(ArrayList<OtherMemberEyeWitnessModel> toBeUpdated) throws SQLException {

        String _insertDisciplineProblemQuery = " UPDATE HR_OTHER_EYEWITNESS_WORD " +
                " SET " +
                " POINTED_BY=?, " +
                " SUMMARY =? , " +
                " EVENT_DESCRIPTION =? ," +
                " TIME_STAMP =? , " +
                " DOC_REFERANCE =? " +
                " WHERE OTHER_EYE_WITNESS_ID =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (OtherMemberEyeWitnessModel currentEyeWitness : toBeUpdated) {

                _ps.setString(1, currentEyeWitness.getPointedBy());
                _ps.setString(2, currentEyeWitness.getSummary());
                _ps.setString(3, currentEyeWitness.getEventDescription());
                _ps.setString(4, currentEyeWitness.getTime_Stamp());
                _ps.setString(5, currentEyeWitness.getDocRefNumber());
                _ps.setInt(6, currentEyeWitness.getOther_Eye_Witnessword_ID());
                _ps.addBatch();
            }
            _ps.executeBatch();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public int insertFile(FileUpLoad UpLoad, String witness_ID) throws SQLException {
        String _insertAccusedFileAttacheCommentes = " INSERT INTO HR_DISCIPLINE_EYEWITNESS_FILE (FILE_ID,FILE_NAME,FILE_TYPE,FILE_EXTENSTION,REQUEST_ID,ATTACHED_FILE,WITNESS_ID)" +
                " VALUES (HR_DISCIPLINE_WITNESS_FILE_SEQ.NEXTVAL,?,?,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
            //_ps.setInt(1, fileUpLoad.getFileID());
            _ps.setString(1, UpLoad.getFileName());
            _ps.setString(2, UpLoad.getFileType());
            _ps.setString(3, UpLoad.getExtention());
            _ps.setInt(4, UpLoad.getRequestID());
            _ps.setBytes(5, UpLoad.getAttachedFile());
            _ps.setString(6, witness_ID);
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }


     public int insertFileOtherEyeWitness(OtherEyeWitnessFileUpLoad UpLoad, int witness_ID) throws SQLException {
        String _insertAccusedFileAttacheCommentes = " INSERT INTO HR_DIS_OTHER_EYEWITNESS_FILE (FILE_ID,FILE_NAME,FILE_TYPE,FILE_EXTENSTION,REQUEST_ID,ATTACHED_FILE,WITNESS_ID)" +
                " VALUES (HR_DISOTHER_WITNESS_FILE_SEQ.NEXTVAL,?,?,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
            //_ps.setInt(1, fileUpLoad.getFileID());
            _ps.setString(1, UpLoad.getFileName());
            _ps.setString(2, UpLoad.getFileType());
            _ps.setString(3, UpLoad.getExtention());
            _ps.setInt(4, UpLoad.getRequestID());
            _ps.setBytes(5, UpLoad.getAttachedFile());
            _ps.setInt(6, witness_ID);
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }
}
