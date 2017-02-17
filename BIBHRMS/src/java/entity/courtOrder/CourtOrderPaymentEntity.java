/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.courtOrder;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.courtOrder.CourtOrderManager.CourtModel;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;


/**
 *
 * @author Administrator
 */
public class CourtOrderPaymentEntity extends ConnectionManager {
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

    public ResultSet selectAllChargeType()throws SQLException  {


        String _selectQuery = " SELECT * FROM HR_LU_CHARGE_TYPE";
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

    public ResultSet selectMemeberList(String empID,String relation) throws SQLException {
          String _selectQuery = " SELECT * FROM HR_EMP_FAMILY WHERE EMP_ID=? AND RELATION_TYPE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, empID);
            _ps.setString(2, relation);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
      public ResultSet selectCurrentSequenceTitle() throws SQLException {
        String _selectQuery = "SELECT  HR_COURT_DEDU_SEQ.NEXTVAL AS CURRENT_ID FROM DUAL";
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

       public String getCurrentIdOfCourtDeduction() {
        ResultSet _rs;
        String currentId = "";
        try {
            _rs = selectCurrentSequenceTitle();
            if (_rs.next()) {
                currentId =  _rs.getString("CURRENT_ID");
            }

           _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return "";
        }
        return currentId;
    }
        public int SaveCourtDeductionModelForPerson(ArrayList<CourtModel> courtDeductForPerson) throws SQLException {

         String _insertCourtDecutionQuery = " INSERT INTO HR_COURT_DEDUCTION " +
                " (REQUEST_ID,EMP_ID,DEDUCTED_FOR," +
                " REPORTED_DATE,CHARGE_TYPE,COURT_NAME," +
                " DEDUCTION_TYPE,MONTHLY_PERCENT_VALUE,MONTHLY_DEDUCTION_AMOUNT," +
                " ISTHERBACK_DEDUCTON,REASOUN," +
                " DOC_REFERANCE_NO,START_DATE,END_DATE,TOTAL_DEDUCTION_AMOUNT,INPUT_TYPE)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

        String _insertCourtDeductionForPerson = " INSERT INTO HR_COURT_DEDUCTION_PERSON " +
                " (REQUEST_ID,RELATION_TYPE,FULL_NAME, " +
                " SEX,AGE,ADDRESS)" +
                " VALUES (?,?,?,?,?,?)";
         String _insertCourtDeductionForOrganazation = " INSERT INTO HR_COURT_DEDUCTION_ORG " +
                " REQUEST_ID,ORGANAZATION_TYPE,ORGANAZATION_NAME, " +
                " ORGANAZATION_ADDRESS,ORGANAZATION_PHONE" +
                " VALUES(?,?,?,?,?)";

           try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertCourtDecutionQuery);
            int lengthOfList = courtDeductForPerson.size();
           // int lengthOfBackDeduction=courtDeductForPerson.size();
            for (int counter = 0; counter <lengthOfList; counter++)
            {
          _ps.setString(1, courtDeductForPerson.get(counter).getRequestID());
          _ps.setString(2, courtDeductForPerson.get(counter).getID());
          _ps.setString(3, courtDeductForPerson.get(counter).getDeductionFor());
          _ps.setString(4, courtDeductForPerson.get(counter).getReporteDate());
          _ps.setString(5, courtDeductForPerson.get(counter).getChargeType());
          _ps.setString(6, courtDeductForPerson.get(counter).getCourtName());
          _ps.setString(7, courtDeductForPerson.get(counter).getDeductionType());
          _ps.setString(8,  courtDeductForPerson.get(counter).getPercentValue());
          _ps.setDouble(9, courtDeductForPerson.get(counter).getDeductionAmount());
          _ps.setString(10, courtDeductForPerson.get(counter).getIsThereBackDedu());
          _ps.setString(11, courtDeductForPerson.get(counter).getReasoun());
          _ps.setString(12, courtDeductForPerson.get(counter).getDocRef());
          _ps.setString(13, courtDeductForPerson.get(counter).getStartDate());
          _ps.setString(14, courtDeductForPerson.get(counter).getEndDate());
          _ps.setDouble(15, courtDeductForPerson.get(counter).getTotalDeductionAmount());
          _ps.setString(16, courtDeductForPerson.get(counter).getInputType());
         _ps.executeUpdate();
         _ps = _con.prepareStatement(_insertCourtDeductionForPerson);
          for(int deduction=0; deduction<lengthOfList; deduction++)
          {
         _ps.setString(1, courtDeductForPerson.get(deduction).getRequestID());
         _ps.setString(2, courtDeductForPerson.get(deduction).getRelationType());
         _ps.setString(3, courtDeductForPerson.get(deduction).getNameOfTaker());
         _ps.setString(4, courtDeductForPerson.get(deduction).getTakerSex());
         _ps.setInt(5, courtDeductForPerson.get(deduction).getTakerAge());
         _ps.setString(6, courtDeductForPerson.get(deduction).getTakerAddress());
         _ps.executeUpdate();
          }
          }
     
           return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
        }

          public int SaveCourtDeductionModelForOrganazation(ArrayList<CourtModel> courtDeductForPerson) throws SQLException {

//         String _insertCourtDecutionQuery = "INSERT INTO HR_COURT_DEDUCTION " +
//                " (REQUEST_ID,EMP_ID,DEDUCTED_FOR," +
//                " REPORTED_DATE,CHARGE_TYPE,COURT_NAME," +
//                " DEDUCTION_TYPE,MONTHLY_DEDUCTION_AMOUNT,MONTHLY_PERCENT_VALUE," +
//                " ISTHERBACK_DEDUCTON,REASOUN," +
//                " DOC_REFERANCE_NO,START_DATE,END_DATE,TOTAL_DEDUCTION_AMOUNT,INPUT_TYPE)" +
//                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                String _insertCourtDecutionQuery = " INSERT INTO HR_COURT_DEDUCTION " +
                " (REQUEST_ID,EMP_ID,DEDUCTED_FOR," +
                " REPORTED_DATE,CHARGE_TYPE,COURT_NAME," +
                " DEDUCTION_TYPE,MONTHLY_PERCENT_VALUE,MONTHLY_DEDUCTION_AMOUNT," +
                " ISTHERBACK_DEDUCTON,REASOUN," +
                " DOC_REFERANCE_NO,START_DATE,END_DATE,TOTAL_DEDUCTION_AMOUNT,INPUT_TYPE)" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        String _insertCourtDeductionForPerson = " INSERT INTO HR_COURT_DEDUCTION_PERSON " +
                " (REQUEST_ID,RELATION_TYPE,FULL_NAME, " +
                " SEX,AGE,ADDRESS)" +
                " VALUES (?,?,?,?,?,?)";
         String _insertCourtDeductionForOrganazation = " INSERT INTO HR_COURT_DEDUCTION_ORG " +
                " (REQUEST_ID,ORGANAZATION_TYPE,ORGANAZATION_NAME, " +
                " ORGANAZATION_ADDRESS,ORGANAZATION_PHONE )" +
                " VALUES(?,?,?,?,?)";
//         String _insertCourtBackDeduction = " INSERT INTO HR_COURT_DEDUCTION_BACKDED " +
//                " (REQUEST_ID,BACK_DEDUCTION_DATE,DEDUCTION_TYPE," +
//                " DEDUCTION_AMOUNT,PERCENT_AMOUNT )" +
//                " VALUES (?,?,?,?,?)";
           try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertCourtDecutionQuery);
            int lengthOfList = courtDeductForPerson.size();
            for (int counter = 0; counter <lengthOfList; counter++)
            {
            _ps.setString(1, courtDeductForPerson.get(counter).getRequestID());
          _ps.setString(2, courtDeductForPerson.get(counter).getID());
          _ps.setString(3, courtDeductForPerson.get(counter).getDeductionFor());
          _ps.setString(4, courtDeductForPerson.get(counter).getReporteDate());
          _ps.setString(5, courtDeductForPerson.get(counter).getChargeType());
          _ps.setString(6, courtDeductForPerson.get(counter).getCourtName());
          _ps.setString(7, courtDeductForPerson.get(counter).getDeductionType());
          _ps.setString(8,  courtDeductForPerson.get(counter).getPercentValue());
          _ps.setDouble(9, courtDeductForPerson.get(counter).getDeductionAmount());
          _ps.setString(10, courtDeductForPerson.get(counter).getIsThereBackDedu());
          _ps.setString(11, courtDeductForPerson.get(counter).getReasoun());
          _ps.setString(12, courtDeductForPerson.get(counter).getDocRef());
          _ps.setString(13, courtDeductForPerson.get(counter).getStartDate());
          _ps.setString(14, courtDeductForPerson.get(counter).getEndDate());
          _ps.setDouble(15, courtDeductForPerson.get(counter).getTotalDeductionAmount());
          _ps.setString(16, courtDeductForPerson.get(counter).getInputType());
         _ps.executeUpdate();

          _ps = _con.prepareStatement(_insertCourtDeductionForOrganazation);
          for(int deduction=0; deduction<lengthOfList; deduction++)
          {
         _ps.setString(1, courtDeductForPerson.get(deduction).getRequestID());
         _ps.setString(2, courtDeductForPerson.get(deduction).getOrganazationType());
         _ps.setString(3, courtDeductForPerson.get(deduction).getOrganazationName());
         _ps.setString(4, courtDeductForPerson.get(deduction).getOrganazationAddress());
         _ps.setString(5, courtDeductForPerson.get(deduction).getOrganazationPhone());
         _ps.executeUpdate();
          }
          }

           return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
        }


}
