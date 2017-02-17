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
import manager.disciplineManager.AccusedDefenceManager.AccusedDefenceModel;
import manager.disciplineManager.AccusedDefenceManager.AccusedFileUpLoad;
import manager.disciplineManager.AccusedDefenceManager.FileUpLoadForInterset;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class AccusedDefenceEntity
        extends ConnectionManager {

   

    AccusedDefenceModel accusedDefenceModel = new AccusedDefenceModel();
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

    public int insertAccusedComment(AccusedDefenceModel accusedDefenceModel) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIPLINE_ACCUSED_COMMENT " +
                " (ACCUSED_COMMENT_ID,REQUEST_ID,ACCEPT_ACCUSATION,ACCEPT_PENALITY," +
                " DESCRIPTION_ON_ACCUSATION,DESCRIPTION_ON_PENALTY," +
                " STATUS,IS_DOCUMENT_ATTACHED,USER_NAME,TIME_STAMP,COMMEENTS_FILE,INTERSET_FILE)" +
                " VALUES (HR_DISCIPLINE_ACCUSED_COMM_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            _ps.setInt(1, accusedDefenceModel.getRequestId());
            _ps.setString(2, accusedDefenceModel.getAcceptAccusation());
            _ps.setString(3, accusedDefenceModel.getAcceptPenalty());
            _ps.setString(4, accusedDefenceModel.getDescriptionOfAccusation());
            _ps.setString(5, accusedDefenceModel.getDescriptionOfPenalty());
            _ps.setString(6, accusedDefenceModel.getStatus());
            _ps.setString(7, accusedDefenceModel.getIsDocumentAttached());
            _ps.setString(8, accusedDefenceModel.getUserName());
            _ps.setString(9, accusedDefenceModel.getTimeStamp());
            _ps.setBytes(10, accusedDefenceModel.getCommeentsFile());
            _ps.setBytes(11, accusedDefenceModel.getIntersetFile());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

     public int insertFile(AccusedFileUpLoad fileUpLoad, FileUpLoadForInterset fileUpLoadInterset) throws SQLException {
        String _insertAccusedFileAttacheCommentes = " INSERT INTO HR_DISCIPLINE_ACCUSED_FILE (FILE_ID,FILE_NAME,FILE_TYPE,FILE_EXTENSTION,REQUEST_ID,ATTACHED_FILE)" +
                " VALUES(HR_DISCIPLINE_ACCUSED_FILE_SEQ.NEXTVAL,?,?,?,?,?)";
         String _insertAccusedFileAttacheInterest = " INSERT INTO HR_DISCIPLINE_ACCUSED_FILE (FILE_ID,FILE_NAME,FILE_TYPE,FILE_EXTENSTION,REQUEST_ID,ATTACHED_FILE)" +
                " VALUES(HR_DISCIPLINE_ACCUSED_FILE_SEQ.NEXTVAL,?,?,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheCommentes);
             //_ps.setInt(1, fileUpLoad.getFileID());
            _ps.setString(1, fileUpLoad.getFileName());
            _ps.setString(2, fileUpLoad.getFileType());
            _ps.setString(3, fileUpLoad.getExtention());
            _ps.setInt( 4,fileUpLoad.getRequestID());
            _ps.setBytes(5, fileUpLoad.getAttachedFile());
            _ps.executeUpdate();
            _ps = _con.prepareStatement(_insertAccusedFileAttacheInterest);
            //_ps.setInt(1, fileUpLoadInterset.getRequestIDInterset());
            _ps.setString(1, fileUpLoadInterset.getFileNameInterset());
            _ps.setString(2, fileUpLoadInterset.getFileTypeInterset());
            _ps.setString(3, fileUpLoadInterset.getExtentionInterset());
            _ps.setInt( 4,fileUpLoadInterset.getRequestIDInterset());
            _ps.setBytes(5, fileUpLoadInterset.getAttachedFileInterset());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }




    ///////////////////////////////////////////////////////////////////////////////////////////////////

    public ResultSet selectAccusedComment(int commentId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_DISCIPLINE_ACCUSED_COMMENT " +
                "   WHERE ACCUSED_COMMENT_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, commentId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAccusedCommentFromRequestId(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_DISCIPLINE_ACCUSED_COMMENT " +
                "   WHERE REQUEST_ID =?";
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

    public ResultSet selectAccusedCommentFromAccusedId(String accusedId, String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                " FROM HR_DISCIPLINE_ISSUE " +
                " WHERE OFFENDER_ID         = ? " +
                " OR DISCIPLINE_PROBLEM_ID IN " +
                "  ( SELECT REQUEST_ID FROM HR_DISCIPLINE_ACCUSED_COMMENT WHERE USER_NAME=? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, accusedId);
            _ps.setString(2, userName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllRequestsNotCommentedByAccused() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_DISCIPLINE_ACCUSED_COMMENT " +
                "   WHERE REQUEST_ID =?";
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

    public ResultSet selectFileAttache(int disciplineID) throws SQLException {
       
        String _selectQuery = " SELECT COMMEENTS_FILE " +
                              " FROM HR_DISCIPLINE_ACCUSED_COMMENT " +
                              " WHERE request_id=?";
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public ResultSet interserSelectFileAttache(int disciplineID) throws SQLException {

        String _selectQuery = " SELECT " +
                  "  INTERSET_FILE " +
                 " FROM HR_DISCIPLINE_ACCUSED_COMMENT " +
                " WHERE request_id=?";
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



    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ResultSet selectRequestNotCommentedByAccused(String accusedEmployeeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_DISCIPLINE_ISSUE " +
                " WHERE DISCIPLINE_PROBLEM_ID NOT IN (SELECT REQUEST_ID FROM HR_DISCIPLINE_ACCUSED_COMMENT)" +
                " AND  OFFENDER_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, accusedEmployeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }


//     public  ResultSet selectDocument(int documentId)
//     {
//       String qry = null;
//
//        qry =" SELECT ATTACHED_FILE FROM HR_DISCIPLINE_ACCUSED_FILE WHERE FILE_ID ='" + documentId + "'";
//
//        try {
//
//           _con = getConnection();
//            _ps = _con.prepareStatement( qry);
//           _rs =  _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//
//    }
       public  OracleSerialBlob select_Document(int documentId)     {
       String qry = null;
        qry =" SELECT ATTACHED_FILE FROM HR_DISCIPLINE_ACCUSED_FILE WHERE FILE_ID ='" + documentId + "'";
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






      public  ResultSet selectDocumentAttrbutie(int requestID) {
       String qry = null;
       
       
        qry =" SELECT * FROM HR_DISCIPLINE_ACCUSED_FILE WHERE REQUEST_ID ='" + requestID + "'and FILE_NAME='Commentes'";

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

      /////////////////////////////////////////////////////////////////////////////////////////


      public  ResultSet selectDocumentAttrbutieForInterset(int requestID) {
       String qry = null;


        qry =" SELECT * FROM HR_DISCIPLINE_ACCUSED_FILE WHERE REQUEST_ID ='" + requestID + "'and FILE_NAME='IntersetOfAccused'";

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
      /////////////////////////////////////////////////////////////////////////////////////////

}
