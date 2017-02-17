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
import manager.organizationManager.JobTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class JobTypeRegistrationEntity extends ConnectionManager {

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

    public boolean insertJobTypes(ArrayList<JobTypeModel> jobTypesList) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_LU_JOB_TYPE " +
                " ( JOB_NAME , JOB_DESCRIPTION , MIN_RESPONSIBILITY ," +
                " ADDITIONALSKILL, RANK_ID , SHIFT_OR_NORMAL )" +
                " VALUES(HR_JOB_TYPE_SEQ.NEXTVAL,?,?,?,?,?)";
         try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (JobTypeModel currentJobType : jobTypesList) {
                _ps.setString(1, currentJobType.getJobName());
                _ps.setString(2, currentJobType.getJobDescription());
                _ps.setString(3, currentJobType.getResponsiblity());
                _ps.setString(4, currentJobType.getAdditionalSkillsNeeded());
                _ps.setString(5, currentJobType.getRankId());
                _ps.setString(6, currentJobType.getShiftOrNormal());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    public boolean updateCommitteesJobTypes(ArrayList<JobTypeModel> jobTypesList) throws SQLException {
        String _updateQuery = "UPDATE  HR_LU_JOB_TYPE SET " +
                " JOB_NAME = ? ," +
                " JOB_DESCRIPTION =? ," +
                " MIN_RESPONSIBILITY =? ," +
                " ADDITIONALSKILL = ? ," +
                " RANK_ID = ? " +
                " SHIFT_OR_NORMAL = ?" +
                " WHERE JOB_CODE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (JobTypeModel currentJobType : jobTypesList) {
                _ps.setString(1, currentJobType.getJobName());
                _ps.setString(2, currentJobType.getJobDescription());
                _ps.setString(3, currentJobType.getResponsiblity());
                _ps.setString(4, currentJobType.getAdditionalSkillsNeeded());
                _ps.setString(5, currentJobType.getRankId());
                _ps.setString(6, currentJobType.getShiftOrNormal());

                _ps.setInt(4, currentJobType.getJobId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteJobTypes(ArrayList<JobTypeModel> jobTypesList) throws SQLException {
        String _deleteQuery = "   DELETE  HR_LU_JOB_TYPE " +
                " WHERE JOB_CODE = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            for (JobTypeModel currentJobType : jobTypesList) {
                _ps.setInt(1, currentJobType.getJobId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllJobTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOB_TYPE ORDER BY JOB_CODE ";
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
 public ResultSet selecJobTypeLevels() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_JOB_TYPE_LEVEL ORDER BY RANK ";
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



}
