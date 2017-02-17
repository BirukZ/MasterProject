/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.securityGuardEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Admin
 */
public class terminatedEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;

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

    public OracleCachedRowSet readAllClearnce() throws SQLException {
        String select = null;
        select = "SELECT emp.emp_id, " +
"  emp.first_name " +
"  ||'' " +
"  || emp.middle_name " +
"  ||' ' " +
"  || EMP.LAST_NAME AS ClerName, " +
"  emp.sex, " +
"  TO_CHAR(sysdate, 'YYYY') - SUBSTR(emp.date_of_birth,1,4) AS AGE, " +
"  lst.department_name, " +
"  lst.job_description, " +
"  term.final_cleared_date, " +
"  term.clearance_status " +
"FROM HR_TERMINATION_CLEARED C " +
"INNER JOIN hr_employee_info emp " +
"ON emp.emp_id=c.emp_id " +
"INNER JOIN vw_employee_by_department_list lst " +
"ON lst.emp_id=c.emp_id " +
"INNER JOIN hr_termination_clearance term " +
"ON term.emp_id=c.emp_id " +
"INNER JOIN HR_TERMINATION_CLEARED_HISTORY H " +
"ON C.CLEARED_ID            =H.CLEARED_ID " +
"WHERE term.clearance_status='1'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    }
