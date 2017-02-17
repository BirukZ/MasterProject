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
import manager.organizationManager.JobTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class JobTypeEntity extends ConnectionManager {

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

    public boolean insertJobType(JobTypeModel jobType) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_LU_JOB_TYPE " +
                " ( JOB_NAME , JOB_DESCRIPTION , MIN_RESPONSIBILITY ," +
                //                " ADDITIONALSKILL, RANK_ID , SHIFT_OR_NORMAL , JOB_LEVEL )" +
                " ADDITIONALSKILL, RANK_ID , JOB_CODE, JOB_LEVEL )" +
                " VALUES(?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, jobType.getJobName());
            _ps.setString(2, jobType.getJobDescription());
            _ps.setString(3, jobType.getResponsiblity());
            _ps.setString(4, jobType.getAdditionalSkillsNeeded());
            _ps.setString(5, jobType.getRankId());
            _ps.setInt(6, jobType.getJobId());
            _ps.setString(7, jobType.getLevel());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateJobType(JobTypeModel jobType) throws SQLException {
        String _updateQuery = "UPDATE  HR_LU_JOB_TYPE SET " +
                " JOB_NAME = ? ," +
                " JOB_DESCRIPTION = ? ," +
                " MIN_RESPONSIBILITY = ? ," +
                " ADDITIONALSKILL = ? ," +
                " RANK_ID = ? ," +
                //                " SHIFT_OR_NORMAL = ? ," +
                " JOB_LEVEL = ? " +
                " WHERE JOB_CODE = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, jobType.getJobName());
            _ps.setString(2, jobType.getJobDescription());
            _ps.setString(3, jobType.getResponsiblity());
            _ps.setString(4, jobType.getAdditionalSkillsNeeded());
            _ps.setString(5, jobType.getRankId());
//            _ps.setString(6, jobType.getShiftOrNormal());
            _ps.setString(6, jobType.getLevel());
            _ps.setInt(7, jobType.getJobId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteJobType(JobTypeModel jobTypes) throws SQLException {
        String _deleteQuery = "   DELETE  HR_LU_JOB_TYPE " +
                " WHERE JOB_CODE = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, jobTypes.getJobId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet selectAllJobTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOB_TYPE ORDER BY to_number(JOB_CODE)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return  ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllJobLevels() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOBTYPE_LEVELS ORDER BY RANK ";
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

    public ResultSet selectJobTypeDetail(int jobTypeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOB_TYPE WHERE JOB_CODE = ? ORDER BY JOB_CODE ";
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

    public String readJobIDAndDescription(String jobCode) {
        try {
            String _selectQuery = "SELECT * FROM HR_LU_JOB_TYPE WHERE JOB_CODE = ?";
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, jobCode);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getString("JOB_CODE") + "--" +
                        _rs.getString("JOB_NAME");

            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet searchJobNametoAuto(
            String job_Name) {
        String qry = null;
        qry =  "SELECT JOB_CODE, " +
                "  JOB_DESCRIPTION " +
                "FROM HR_LU_JOB_TYPE " +
                "WHERE JOB_DESCRIPTION LIKE '"+job_Name+"%' " +
                "AND rownum <=10";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception e) {
            return null;
        }
    }
}
