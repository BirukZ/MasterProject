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
import manager.disciplineManager.PenaltyRegistrationManager.ManagerPenality;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class PenaltyRegistrationEntity
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


    public boolean updatePenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE HR_LU_PENALTY_TYPE  SET " +
                " PENALTY_CODE=?, " +
                " PENALTY_NAME=?, " +
                " MONETARY_PENALTY_DAYS=?, " +
                " DESCRIPTION=?, " +
                " ACTION_TAKER=?,DEDUCTION_DURATION=?" +
                " WHERE PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getNumberOfPenalisedDays());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                _ps.setString(5, penaltyTypeList.get(counter).getActionTaker());
                _ps.setInt(6, penaltyTypeList.get(counter).getDeductionDuration());
                _ps.setInt(7, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //------------------------------------------------------Penality Update For Manager------------------------------------------------------------------
     public boolean updatePenaltyTypesForManager(ArrayList<ManagerPenality> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE HR_LU_MANAGEMENT_PENALTY_TYPE  SET " +
                " PENALTY_CODE=?, " +
                " PENALTY_NAME=?, " +
                " MONETARY_PENALTY_DAYS=?, " +
                " DESCRIPTION=?, " +
                " ACTION_TAKER=? " +
                " WHERE PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getDeductionAmount());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                _ps.setString(5, penaltyTypeList.get(counter).getActionTaker());
                _ps.setInt(6, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //-------------------------------------------------------Penality For the Manager--------------------------------------------------------------------
       public boolean insertPenaltyTypesForManager(ArrayList<ManagerPenality> penaltyTypeList) throws SQLException {
        String _insertPenaltyType = "   INSERT INTO HR_LU_MANAGEMENT_PENALTY_TYPE " +
                "(PENALTY_TYPE_ID,PENALTY_CODE,PENALTY_NAME,MONETARY_PENALTY_DAYS,DESCRIPTION,ACTION_TAKEN,PENALITY_FOR,ACTION_TAKER,DEDUCTION_DURATION)" +
                "VALUES(HR_LU_PENALTY_TYPE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertPenaltyType);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getDeductionAmount());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                 _ps.setString(5, penaltyTypeList.get(counter).getActionTaken());
                _ps.setString(6, penaltyTypeList.get(counter).getPenalityFor());
                _ps.setString(7, penaltyTypeList.get(counter).getActionTaker());
                _ps.setInt(8, penaltyTypeList.get(counter).getDeductionDuration());

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean insertPenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertPenaltyType = "   INSERT INTO HR_LU_PENALTY_TYPE " +
                "(PENALTY_TYPE_ID,PENALTY_CODE,PENALTY_NAME,MONETARY_PENALTY_DAYS,DESCRIPTION,ACTION_TAKEN,PENALITY_FOR,ACTION_TAKER,DEDUCTION_DURATION)" +
                "VALUES(HR_LU_PENALTY_TYPE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertPenaltyType);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getNumberOfPenalisedDays());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                 _ps.setString(5, penaltyTypeList.get(counter).getActionTaken());
                _ps.setString(6, penaltyTypeList.get(counter).getPenalityFor());
                _ps.setString(7, penaltyTypeList.get(counter).getActionTaker());
                _ps.setInt(8, penaltyTypeList.get(counter).getDeductionDuration());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //--------------------------------------------------PenalityForManagerDelete-----------------------------------------------------------------------------
     public boolean deletePenaltyTypesForManager(ArrayList<ManagerPenality> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_MANAGEMENT_PENALTY_TYPE " +
                " where PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //--------------------------------------------------------------------------------------------------------------------------------------------------

    public boolean deletePenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_PENALTY_TYPE " +
                " where PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllDisciplineTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_DISCIPLINE_TYPE order by DISCIPLINE_CODE ";
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

    public ResultSet selectAllPenaltyTypes(int penalityID) throws SQLException {
     

         String _selectQuery = " SELECT * FROM HR_LU_PENALTY_TYPE WHERE PENALTY_TYPE_ID ='"+ penalityID +"'";
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
    //=======================================================PenalityForManager==========================================================================
     public ResultSet selectAllPenaltyTypesFormanager(int penalityID) throws SQLException
                 {
        
         String _selectQuery = "SELECT * FROM HR_LU_MANAGEMENT_PENALTY_TYPE WHERE PENALTY_TYPE_ID ='"+ penalityID +"'";
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

    //===================================================================================================================================================


    /**
     *
     */
    public ResultSet selectAllPenaltyType() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PENALTY_TYPE order by penalty_code ";
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
     public ResultSet selectAllManagementPenaltyType() throws SQLException
        {
        String _selectQuery = " SELECT * FROM HR_LU_MANAGEMENT_PENALTY_TYPE order by PENALTY_CODE ";
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

    public ResultSet selectPenaltyOfOffence(String disciplineType, int repitition) throws SQLException {

        

        String _selectQuery = "SELECT PENALTY_TYPE_ID, PENALTY_NAME, DESCRIPTION " +
                "FROM HR_LU_PENALTY_TYPE " +
                "WHERE PENALTY_TYPE_ID IN " +
                "  (SELECT PENALTY " +
                "  FROM HR_DISCIPLINED_TYPE_REPITITION " +
                "  WHERE DESCIPLINE_TYPE = ? " +
                "  AND REPITITION        = ? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, disciplineType);
            _ps.setInt(2, repitition);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllPenaltyTypesDetail() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE," +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIPLINED_TYPE_REPITITION,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE hr_DISCIPLINED_TYPE_REPITITION.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIPLINED_TYPE_REPITITION.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
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

    public ResultSet selectPenaltyOfOffence(int decisiontype, String repitition) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_DISCIPLINED_TYPE_REPITITION " +
                " WHERE DECISIONER_TYPE=? AND REPITITION=?";
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
