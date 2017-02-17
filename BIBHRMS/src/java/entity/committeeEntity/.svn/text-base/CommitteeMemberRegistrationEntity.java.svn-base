package entity.committeeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.committeeManager.CommitteeMemberModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class CommitteeMemberRegistrationEntity extends ConnectionManager {

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

    public boolean insertCommitteeMembers(ArrayList<CommitteeMemberModel> committeeMemberList) throws SQLException {
        String _insertCommitteeMemberQuery = "INSERT INTO  HR_COMMITTEE_MEMBER " +
                " ( COMMITTEE_MEMBER_ID,COMMITTEE_ID,EMP_ID,RESPONSIBLITY,STATUS,PERM_OR_TEMP,ASSIGNED_DATE,REMARK)" +
                " VALUES(HR_COMMITTEE_MEMBER_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertCommitteeMemberQuery);
            for (CommitteeMemberModel currentCommitteeMember : committeeMemberList) {
                _ps.setInt(1, currentCommitteeMember.getCommitteeId());
                _ps.setString(2, currentCommitteeMember.getEmployeeId());
                _ps.setString(3, currentCommitteeMember.getResponsiblity());
                _ps.setString(4, currentCommitteeMember.getMemberStatus());
                _ps.setString(5, currentCommitteeMember.getPermanentOrTemporary());
                _ps.setString(6, currentCommitteeMember.getAssignedDate());
                _ps.setString(7, currentCommitteeMember.getRemark());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateCommitteeMembers(ArrayList<CommitteeMemberModel> committeeMemberList) throws SQLException {
        String _updateCommitteeMemberQuery = "UPDATE  HR_COMMITTEE_MEMBER " +
                " SET  COMMITTEE_ID =? ,EMP_ID =? ,RESPONSIBLITY =? ,STATUS =? ,PERM_OR_TEMP =?, ASSIGNED_DATE =? ,REMARK =?  " +
                " WHERE COMMITTEE_MEMBER_ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateCommitteeMemberQuery);
            for (CommitteeMemberModel currentCommitteeMember : committeeMemberList) {
                _ps.setInt(1,    currentCommitteeMember.getCommitteeId());
                _ps.setString(2, currentCommitteeMember.getEmployeeId());
                _ps.setString(3, currentCommitteeMember.getResponsiblity());
                _ps.setString(4, currentCommitteeMember.getMemberStatus());
                _ps.setString(5, currentCommitteeMember.getPermanentOrTemporary());
                _ps.setString(6, currentCommitteeMember.getAssignedDate());
                _ps.setString(7, currentCommitteeMember.getRemark());
                _ps.setInt(8,    currentCommitteeMember.getCommitteeMemberId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteCommitteeMembers(ArrayList<CommitteeMemberModel> committeeList) throws SQLException {
      
        String _deleteCommitteeQuery = " DELETE  HR_COMMITTEE_MEMBER " +
                " WHERE COMMITTEE_MEMBER_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteCommitteeQuery);
            for (CommitteeMemberModel currentCommittee : committeeList) {
                
                _ps.setInt(1, currentCommittee.getCommitteeMemberId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllCommitteeMembers(int committeeId) throws SQLException {
        String _selectQuery = " SELECT HR_COMMITTEE_MEMBER.*, " +
                " FIRST_NAME,MIDDLE_NAME,LAST_NAME, PERM_OR_TEMP,RESPONSIBLITY,REMARK " +
                " FROM HR_COMMITTEE_MEMBER , VW_EMPLOYEE_BY_DEPARTMENT_LIST  " +
                " WHERE VW_EMPLOYEE_BY_DEPARTMENT_LIST.EMP_ID = HR_COMMITTEE_MEMBER.EMP_ID " +
                " AND COMMITTEE_ID = ? ";
       

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, committeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getAllCommitee() throws SQLException {
        String _selectQuery=" Select HR_COMMITTEE_MEMBER.* from HR_COMMITTEE_MEMBER where COMMITTEE_ID='5' ";
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
 public ResultSet getAllEduacCommitee(int deciderCommitteeId) throws SQLException {
        String _selectQuery="Select HR_COMMITTEE_MEMBER.* from HR_COMMITTEE_MEMBER where COMMITTEE_ID='" +deciderCommitteeId +"' ";
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

    public ResultSet selectActiveCommitteeMembers(int committeeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_COMMITTEE_MEMBER " +
                " WHERE COMMITTEE_MEMBER_ID = ? " +
                " AND STATUS = 'Active'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, committeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectActiveCommitteeMembersWithUserName(int committeeId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_COMMITTEE_MEMBER " +
                " WHERE COMMITTEE_MEMBER_ID = ? " +
                " AND STATUS = 'Active'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, committeeId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
