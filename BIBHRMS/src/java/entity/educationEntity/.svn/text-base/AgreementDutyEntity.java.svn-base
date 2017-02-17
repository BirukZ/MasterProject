/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.educationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import manager.educationManager.AgreementAndDutyModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class AgreementDutyEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
            _rs = null;
        }
        if (_ps != null) {
            _ps.close();
            _ps = null;
        }
        if (_con != null) {
            _con.close();
            closePooledConnections(_con);
        }
    }

    public int insertInstitution(AgreementAndDutyModel institutionModel) throws SQLException {
        String _insertQuery = "INSERT " +
                "INTO HR_EDUC_AGREMENT_DUTY " +
                "  ( " +
                "    DUTY_ID, " +
                "    EDUC_REQU_ID, " +
                "    REQUESTER_ID, " +
                "    DUTY_SERVICE_YR, " +
                "    GRADUATION_DATE, " +
                "    CURRENT_DATE, " +
                "    APPROVE_DENY, " +
                "    REMARK, " +
                "    TIME_STAMP, " +
                "    USER_NAME )" +
                " VALUES (HR_EDUC_AGREE.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
         
            _ps.setInt(1, institutionModel.getEducRequestId());
            _ps.setString(2, institutionModel.getRequesterId());
            _ps.setInt(3, institutionModel.getServiceYear());
            _ps.setString(4, institutionModel.getGarduationDate());
            _ps.setString(5, institutionModel.getApplideDate());
            _ps.setString(6, institutionModel.getDeneyOrApprove());
            _ps.setString(7, institutionModel.getRemark());
            _ps.setString(8, institutionModel.getTimeStamp());
            _ps.setString(9, institutionModel.getUserName());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int updateInstitution(AgreementAndDutyModel institutionModel) throws SQLException {
        String _updateQuery = "UPDATE " +
                " HR_EDUC_AGREMENT_DUTY  SET  " +
                "    EDUC_REQU_ID = ? , " +
                "    REQUESTER_ID = ? , " +
                "    DUTY_SERVICE_YR = ? , " +
                "    GRADUATION_DATE = ? , " +
                "    CURRENT_DATE = ? , " +
                "    APPROVE_DENY = ? , " +
                "    REMARK = ? , " +
                "    TIME_STAMP = ? , " +
                "    USER_NAME = ?  " +
                " WHERE   DUTY_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setInt(1, institutionModel.getEducRequestId());
            _ps.setString(2, institutionModel.getRequesterId());
            _ps.setInt(3, institutionModel.getServiceYear());
            _ps.setString(4, institutionModel.getGarduationDate());
            _ps.setString(5, institutionModel.getApplideDate());
            _ps.setString(6, institutionModel.getDeneyOrApprove());
            _ps.setString(7, institutionModel.getRemark());
            _ps.setString(8, institutionModel.getTimeStamp());
            _ps.setString(9, institutionModel.getUserName());
            _ps.setInt(10, institutionModel.getDutyId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int deleteInstitution(int institutionId) throws SQLException {
        String _deleteQuery = "DELETE  HR_EDUC_AGREMENT_DUTY  " +
                " WHERE     DUTY_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, institutionId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectInstitution() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_EDUC_INSTITUTION ";
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

    public ResultSet selectEducationRequestHistory(String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUC_AGREMENT_DUTY " +
                "WHERE (USER_NAME ='" + userName + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " +
                "ORDER BY DUTY_ID DESC";
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

    public HashMap readEmployeeBasicInfoFromId(String employeeId) throws SQLException {
        String qry = "SELECT * FROM HR_EDUC_AGREMENT_DUTY WHERE REQUESTER_ID='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("REQUESTER_ID"));
                     data.put("DUTY_ID", _rs.getString("DUTY_ID"));
                    data.put("DUTY_SERVICE_YR", _rs.getString("DUTY_SERVICE_YR"));
                    data.put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                    data.put("GRADUATION_DATE", _rs.getString("GRADUATION_DATE"));
                    data.put("CURRENT_DATE", _rs.getString("CURRENT_DATE"));
                    data.put("APPROVE_DENY", _rs.getString("APPROVE_DENY"));
                    data.put("REMARK", _rs.getString("REMARK"));
                     data.put("EDUC_REQU_ID", _rs.getString("EDUC_REQU_ID"));
                   

                } else {
                    data.put("employeeId", "");
                    data.put("DUTY_SERVICE_YR", "");
                    data.put("REQUESTER_ID", "");
                    data.put("GRADUATION_DATE", "");
                    data.put("CURRENT_DATE", "");
                    data.put("APPROVE_DENY", "");
                    data.put("REMARK", "");
                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
    public ResultSet selectEducationRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_EDUC_AGREMENT_DUTY " +
                " WHERE DUTY_ID = ?";
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
}
