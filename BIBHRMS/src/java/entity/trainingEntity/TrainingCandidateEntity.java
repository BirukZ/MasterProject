/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DP
 */
public class TrainingCandidateEntity extends ConnectionManager{

    
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

    public ResultSet ReadEmployeeFromDepartment(String departmentID) {
        String qry = "SELECT * FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST WHERE DEPARTMENT_ID='" + departmentID + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs=new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet)ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

}
