/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.organizationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.organizationManager.JobTypeQualificationModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class JobTypeQualificationEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    // Savepoint _sp;

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

    public boolean insertEducationLevelExperience(ArrayList<JobTypeQualificationModel> educationLevelExperienceList) throws SQLException {

        String _insertQuery = "INSERT INTO  HR_LU_JOBTYPE_EDUCLEVEL_EXPER " +
                " ( JOBTYPE_EDUCLEVEL_EXPER_ID,JOBTYPE_ID,EDUCLEVEL_ID,EXPERIENCE)" +
                " VALUES(JOB_TYPE_EDUC_LEVEL_SEQ.NEXTVAL,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationLevelExperienceList) {
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeId());
                _ps.setInt(2, currentEducLevelAndExp.getLevelOfEducationId());
                _ps.setDouble(3, currentEducLevelAndExp.getExperienceNeeded());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateEducationLevelExperience(ArrayList<JobTypeQualificationModel> educationLevelExperienceList) throws SQLException {
        String _updateQuery = "UPDATE HR_LU_JOBTYPE_EDUCLEVEL_EXPER " +
                " SET  JOBTYPE_ID =? , EDUCLEVEL_ID = ?, EXPERIENCE =? " +
                " WHERE JOBTYPE_EDUCLEVEL_EXPER_ID =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationLevelExperienceList) {
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeId());
                _ps.setInt(2, currentEducLevelAndExp.getLevelOfEducationId());
                _ps.setDouble(3, currentEducLevelAndExp.getExperienceNeeded());
                _ps.setInt(4, currentEducLevelAndExp.getJobTypeEducLevelAndExperienceId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteEducationLevelExperience(ArrayList<JobTypeQualificationModel> educationLevelExperienceList) throws SQLException {
        String _deleteQuery = "DELETE HR_LU_JOBTYPE_EDUCLEVEL_EXPER " +
                " WHERE JOBTYPE_EDUCLEVEL_EXPER_ID =? ";
        try {
            int counter = 1;
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationLevelExperienceList) {
                counter++;
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeEducLevelAndExperienceId());
                _ps.addBatch();

            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEducationLevelExperience(int jobTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM VW_JOBTYPE_EDUCLEVEL_EXPR " +
                " WHERE JOBTYPE_ID = ?" +
                " ORDER BY EDUC_RANK ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, jobTypeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean insertEducationTypes(ArrayList<JobTypeQualificationModel> educationTypeList) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_LU_JOBTYPE_EDUCTYPE " +
                " ( JOBTYPE_EDUCTYPE_ID,JOBTYPE_ID,EDUCTYPE_ID)" +
                " VALUES(JOBTYPE_EDUCTYPE_SEQ.NEXTVAL,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationTypeList) {
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeId());
                _ps.setInt(2, currentEducLevelAndExp.getEducationTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateEducationTypes(ArrayList<JobTypeQualificationModel> educationTypeList) throws SQLException {
        String _updateQuery = "UPDATE HR_LU_JOBTYPE_EDUCTYPE " +
                " JOBTYPE_ID = ? ,EDUCTYPE_ID = ? " +
                " WHERE JOBTYPE_EDUCTYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationTypeList) {
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeId());
                _ps.setInt(2, currentEducLevelAndExp.getEducationTypeId());
                _ps.setInt(4, currentEducLevelAndExp.getJobTypeEducTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteEducationTypes(ArrayList<JobTypeQualificationModel> educationTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_LU_JOBTYPE_EDUCTYPE " +
                " WHERE JOBTYPE_EDUCTYPE_ID =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            for (JobTypeQualificationModel currentEducLevelAndExp : educationTypeList) {
                _ps.setInt(1, currentEducLevelAndExp.getJobTypeEducTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEducationTypes(int jobTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM VW_JOBTYPE_EDUCTYPE " +
                " WHERE JOBTYPE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, Integer.toString(jobTypeId));
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    ////=============================to be deleted =============================
    public ResultSet selectAllEducationLevels() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_EDUC_LEVEL" +
                " ORDER BY RANK ";
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

    public ResultSet selectAllEducationTypeCategories() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_EDUC_TYPE_CATEGORY ";
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

    public ResultSet selectAllJobTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOB_TYPE ";
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

    public ResultSet selectEducationTypeByCategory(String category) throws SQLException {
        String _selectQuery;
        if (category == null || category.equals("-1")) {
            _selectQuery = " SELECT * FROM HR_LU_EDUC_TYPE ";
        } else {
            _selectQuery = " SELECT * FROM HR_LU_EDUC_TYPE " +
                    " WHERE  CATEGORY = '" + category + "'";
        }
 
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



    //===========================================

    }

    public Connection get_con() {
        return _con;
    }

    public void set_con(Connection _con) {
        this._con = _con;
    }

    public PreparedStatement get_ps() {
        return _ps;
    }

    public void set_ps(PreparedStatement _ps) {
        this._ps = _ps;
    }

    public ResultSet get_rs() {
        return _rs;
    }

    public void set_rs(ResultSet _rs) {
        this._rs = _rs;
    }
}
