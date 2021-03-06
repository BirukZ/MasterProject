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
import manager.disciplineManager.DisciplineRegistrationManager.DisciplineTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class DisciplineRegistrationEntity
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

    public boolean insertDisciplinePenalities(ArrayList<DisciplineTypeModel> PenaltyOfDisciplineType) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_DISCIPLINED_TYPE_REPITITION " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE, REPITITION,PENALTY )" +
                " VALUES(HR_DICIPLINED_REPITITION_SEQ.NEXTVAL,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = PenaltyOfDisciplineType.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, PenaltyOfDisciplineType.get(counter).getDisciplineTypeId());
                _ps.setInt(2, PenaltyOfDisciplineType.get(counter).getRepitition());
                _ps.setString(3, PenaltyOfDisciplineType.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplinePenalities(ArrayList<DisciplineTypeModel> disciplinePenalityList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE HR_DISCIPLINED_TYPE_REPITITION " +
                " SET " +
                " DESCIPLINE_TYPE =?, " +
                " PENALTY =? ," +
                " REPITITION=? " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenalityList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenalityList.get(counter).getDisciplineTypeId());
                _ps.setString(2, disciplinePenalityList.get(counter).getPenaltyTypeId());
                _ps.setInt(3, disciplinePenalityList.get(counter).getRepitition());
                _ps.setInt(4, disciplinePenalityList.get(counter).getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO HR_LU_DISCIPLINE_TYPE " +
                "(DESCIPLINE_TYPE_ID,DISCIPLINE_CODE,OFFENCE_NAME, DESCIPLINE_CATAGORY,DESCRIPTION,PHASEOUT_PERIOD,DISCIPLINE_SUBCATAGORY)" +
                "VALUES(HR_LU_DISCIPLINE_TYPES_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.setString(6, disciplineTypeList.get(counter).getDisciplineSubCatagory());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //================================================================DisciplineTypeForManager=============================================
      public boolean insertDisciplineTypesForManager(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   INSERT INTO HR_LU_MNG_DISCIPLINE_TYPE " +
                "(DESCIPLINE_TYPE_ID,DISCIPLINE_CODE,OFFENCE_NAME, DESCIPLINE_CATAGORY,DESCRIPTION,PHASEOUT_PERIOD,DISCIPLINE_SUBCATAGORY)" +
                "VALUES(HR_LU_DISCIPLINE_TYPES_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.setString(6,disciplineTypeList.get(counter).getDisciplineSubCatagory());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //======================================================================================================================================

    public boolean deleteDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_DISCIPLINE_TYPE " +
                " where DESCIPLINE_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplineTypeList.get(counter).getDisciplineTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //=================================================================================================================================
     public boolean deleteDisciplineTypesManager(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_MNG_DISCIPLINE_TYPE " +
                " where DESCIPLINE_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplineTypeList.get(counter).getDisciplineTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //=================================================================================================================================

    public boolean deleteDisciplinePenalty(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_DISCIPLINED_TYPE_REPITITION " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplineTypeList.get(counter).getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   UPDATE HR_LU_DISCIPLINE_TYPE " +
                " SET DISCIPLINE_CODE=?,OFFENCE_NAME=?,DESCIPLINE_CATAGORY=?,DESCRIPTION=?,PHASEOUT_PERIOD=? " +
                " WHERE DESCIPLINE_TYPE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.setInt(6, disciplineTypeList.get(counter).getDisciplineTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //==============================================================ForManagerRegistraton===================================
     public boolean updateDisciplineTypesForManager(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   UPDATE HR_LU_MNG_DISCIPLINE_TYPE " +
                " SET DISCIPLINE_CODE=?,OFFENCE_NAME=?,DESCIPLINE_CATAGORY=?,DESCRIPTION=?,PHASEOUT_PERIOD=?,DISCIPLINE_SUBCATAGORY=? " +
                " WHERE DESCIPLINE_TYPE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.setString(6, disciplineTypeList.get(counter).getDisciplineSubCatagory());
                _ps.setInt(7, disciplineTypeList.get(counter).getDisciplineTypeId());

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    //======================================================================================================================

    /**
     *
     */
    public ResultSet selectAllDisciplineTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_DISCIPLINE_TYPE order by discipline_code";
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
    //-----------------------------------------------DisciplineForTheManager-------------------------------------------
     public ResultSet selectAllDisciplineTypesForManger() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_MNG_DISCIPLINE_TYPE order by discipline_code";
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
    //-----------------------------------------------------------------------------------------------------------------

    public ResultSet selectDisciplineType(String disciplineTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_DISCIPLINE_TYPE" +
                " WHERE DESCIPLINE_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, disciplineTypeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectDisciplineTypeForManager(String disciplineTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_MNG_DISCIPLINE_TYPE" +
                " WHERE DESCIPLINE_TYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, disciplineTypeId);
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
    public ResultSet selectAllPenaltyType() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PENALTY_TYPE";
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
        String _selectQuery = "SELECT PENALTY_NAME, DESCRIPTION " +
                "FROM HR_LU_PENALTY_TYPE " +
                "WHERE PENALTY_TYPE_ID IN " +
                "  (SELECT PENALTY " +
                "  FROM HR_DISCIPLINED_TYPE_REPITITION " +
                "  WHERE DESCIPLINE_TYPE=? " +
                "  AND REPITITION       =? " +
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
