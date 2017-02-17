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
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Admin
 */
public class DeciplnEentity extends ConnectionManager {
  Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;
  //  ReportCriteraManager criteraManager=new ReportCriteraManager();
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

    public OracleCachedRowSet readAllDiscipline() throws SQLException, SQLException {

        String _selectquery = "SELECT NVL( dip.approved_penality,'.') AS approved_penality, " +
"  SUBSTR(dip.TIME_STAMP,1,10)          AS approvedDate, " +
"  epf.EMP_ID                           AS Offender_ID, " +
"  epf.FIRST_NAME                       AS OffenderFirst_Name, " +
"  epf.MIDDLE_NAME                      AS OffenderMiddle_Name, " +
"  epf.LAST_NAME                        AS OffenderLast_Name, " +
"  epf.department_name                  AS Offender_Department, " +
"  epf.job_description                  AS Offender_JobTitle " +
"FROM HR_DISCIPLINE_ISSUE dis " +
"LEFT JOIN HR_COMCHAIR_MAN_COMMEENTES chirman " +
"ON dis.discipline_problem_id=chirman.discipline_problem_id " +
"LEFT JOIN HR_DISCIPLINE_ACCUSED_COMMENT accd " +
"ON dis.discipline_problem_id=accd.request_id " +
"INNER JOIN vw_employee_by_department_list epf " +
"ON epf.EMP_ID =dis.OFFENDER_ID " +
"INNER JOIN vw_employee_by_department_bi bk " +
"ON bk.EMP_ID =dis.REQUESTER_ID " +
"INNER JOIN HR_DISCIPLINE_PROCESSED dip " +
"ON dis.discipline_problem_id =dip.REQUEST_ID " +
"INNER JOIN hr_disciplined_type_repitition dir " +
"ON dis.offence_type =dir.descipline_type " +
"INNER JOIN hr_lu_penalty_type plt " +
"ON dir.penalty =plt.penalty_type_id " +
"INNER JOIN hr_lu_discipline_type dil " +
"ON dis.offence_type =dil.descipline_type_id " +
"WHERE dis.status LIKE 'App%' and dip.approved_penality like '%-261'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectquery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    // return null;
    }
}
