package entity.committeeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.committeeManager.CommitteeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class CommitteeRegistrationEntity extends ConnectionManager {

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

    public boolean insertCommittees(ArrayList<CommitteeModel> committeeList) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_COMMITTEE " +
                " ( COMMITTEE_ID,COMMITTEE_NAME,COMMITTEE_TYPE,DESCRIPTION," +
                "NUMBER_OF_MEMBERS,ESTABLISHED_DATE,STATUS,RESPONSIBLITY,PARENT_ID,FORMER_NAME,FORMER_DEPARTMENT,FORMER_POSITION)" +
                " VALUES(HR_COMMITTEE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            for (CommitteeModel currentCommittee : committeeList) {
                _ps.setString(1, currentCommittee.getCommitteeName());
                _ps.setString(2, currentCommittee.getCommitteeType());
                _ps.setString(3, currentCommittee.getDescription());
                _ps.setInt(4, currentCommittee.getNumberOfmembers());
                _ps.setString(5, currentCommittee.getEstablishedDate());
                _ps.setString(6, currentCommittee.getCommitteeStatus());
                _ps.setString(7, currentCommittee.getResponsiblity());
                _ps.setInt(8, currentCommittee.getParentId());
                _ps.setString(9, currentCommittee.getFormerName());
                _ps.setString(10, currentCommittee.getFormerDepartment());
                _ps.setString(11, currentCommittee.getFormerPosition());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateCommittees(ArrayList<CommitteeModel> committeeList) throws SQLException {
        String _updateCommitteeQuery = "UPDATE  HR_COMMITTEE " +
                " SET  COMMITTEE_NAME =? , COMMITTEE_TYPE =? ,DESCRIPTION =? ," +
                " NUMBER_OF_MEMBERS =? ,ESTABLISHED_DATE =? ,STATUS =? ,RESPONSIBLITY =? ,PARENT_ID =? ,FORMER_NAME=? ,FORMER_DEPARTMENT=? ,FORMER_POSITION=? " +
                " WHERE COMMITTEE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateCommitteeQuery);
            for (CommitteeModel currentCommittee : committeeList) {
                _ps.setString(1, currentCommittee.getCommitteeName());
                _ps.setString(2, currentCommittee.getCommitteeType());
                _ps.setString(3, currentCommittee.getDescription());
                _ps.setInt(4, currentCommittee.getNumberOfmembers());
                _ps.setString(5, currentCommittee.getEstablishedDate());
                _ps.setString(6, currentCommittee.getCommitteeStatus());
                _ps.setString(7, currentCommittee.getResponsiblity());
                _ps.setInt(8, currentCommittee.getParentId());
                _ps.setString(9, currentCommittee.getFormerName());
                _ps.setString(10, currentCommittee.getFormerDepartment());
                _ps.setString(11, currentCommittee.getFormerPosition());
                _ps.setInt(12, currentCommittee.getCommitteeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteCommittees(ArrayList<CommitteeModel> committeeList) throws SQLException {
        String _deleteCommitteeQuery = "   DELETE  HR_COMMITTEE " +
                " WHERE COMMITTEE_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteCommitteeQuery);
            for (CommitteeModel currentCommittee : committeeList) {
                _ps.setInt(1, currentCommittee.getCommitteeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllCommittees() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_COMMITTEE ";
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

    public ResultSet selectAllCommittees(String CommitteeType) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_COMMITTEE_TYPE " +
                " WHERE STATUS = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, "Active");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }


       public ResultSet selectAllCommitteesFromLu() throws SQLException
       {
        String _selectQuery = " SELECT * FROM HR_LU_COMMITTEE_TYPE" ;

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
          //  _ps.setString(1, CommitteeType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllCommittees(String CommitteeType, String status) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_COMMITTEE " +
                " WHERE COMMITTEE_TYPE = ? " +
                " AND STSTUS =? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, CommitteeType);
            _ps.setString(2, status);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectActiveCommittees() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_COMMITTEE_TYPE WHERE STATUS='Active' ORDER BY commitee_name";
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

    public ResultSet selectCommittee(int committeeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_COMMITTEE WHERE COMMITTEE_ID = ? ";
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

    public boolean insertCommityName(String commiteeName, String committeeDescribtion) throws SQLException {

       String _insertDisciplineProblemQuery = " INSERT INTO  HR_LU_COMMITTEE_TYPE " +
                " ( COMMITTEE_TYPE_CODE,DESCRIPTION,COMMITEE_NAME)"+
                " VALUES(HR_COMMITTEE_NAME.NEXTVAL,?,?)";
       
         try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
           _ps.setString(1, committeeDescribtion);
           _ps.setString(2, commiteeName);
         
           _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }

       }
}
