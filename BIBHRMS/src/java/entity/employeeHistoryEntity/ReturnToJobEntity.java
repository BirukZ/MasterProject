/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

/**
 *
 * @author thecode
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author insa
 */
public class ReturnToJobEntity extends ConnectionManager {

    private Connection _con = null;
    private ResultSet _rs = null;
    private PreparedStatement _ps = null;
    private PreparedStatement ps = null;

    public ReturnToJobEntity() {
    }

    public boolean updateEmployeeInformation(
            String employeeId,
            String returnDate,
            String leaveRequestId) {

        String _update = "UPDATE HR_EMPLOYEE_INFO " +
                " SET EMP_STATUS='01' WHERE EMP_ID='" + employeeId + "'";
        String _updateLeave = "UPDATE HR_EMP_LEAVE " +
                "SET ACTUALRETURNDATE = '" + returnDate + "'" +
                "WHERE LEAVE_ID        = '" + leaveRequestId + "'" +
                "AND EMP_ID            = '" + employeeId + "'";
        try {


            _con = getConnection();
            _con.setAutoCommit(false);
            _ps = _con.prepareStatement(_update);
            System.out.println(_update+_ps.executeUpdate() );
            if (_ps.executeUpdate() > 0)
            {
                ps = _con.prepareStatement(_updateLeave);
                System.out.println(_updateLeave);
              //  ps.setString(1, returnDate);
              //  ps.setString(2, leaveRequestId);
              //  ps.setString(3, employeeId);
             //   ps=_con.prepareStatement(_updateLeave);
                System.out.println(_updateLeave);
                if (ps.executeUpdate() > 0)
                {
                    _con.commit();
                    _ps.close();
                    ps.close();
                    return true;
                } else {
                    _con.rollback();
                    _ps.close();
                    ps.close();
                    return false;
                }
            } else {
                _con.rollback();
                _ps.close();
                ps.close();
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean updateEmployeeReturnLeaveInformation(
            String employeeId,
            String returnDate,
            String returnRequestId) {

        String _update = "UPDATE HR_EMPLOYEE_INFO " +
                " SET EMP_STATUS='01' WHERE EMP_ID='" + employeeId + "'";
        String _updateLeave = "UPDATE HR_EMP_REQUEST_FROM_LEAVE " +
                " SET ACTUAL_RETURN_DATE = ?, " +
                " PAYMENT_STATUS='0' " +
                " WHERE REQUEST_ID        = ? ";

        try {


            _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint svpt = _con.setSavepoint("leaveSavePoint");
            _ps = _con.prepareStatement(_update);
            if (_ps.executeUpdate() > 0) {
                ps = _con.prepareStatement(_updateLeave);
                ps.setString(1, returnDate);
                ps.setString(2, returnRequestId);
                if (ps.executeUpdate() > 0) {
                    _con.commit();
                    _ps.close();
                    ps.close();
                    return true;
                } else {
                    _con.rollback(svpt);
                    _ps.close();
                    ps.close();
                    return false;
                }
            } else {
                _con.rollback();
                _ps.close();
                ps.close();
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            _con.close();
        }
    }

    public HashMap readEmpLeaveInfo(String leaveId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = null;
        HashMap list = null;
        String selectStatment =
                "SELECT REQUESTED_DATE, " +
                "  REQUESTED_FROM_DATE, " +
                "  REQUESTED_TO_DATE, " +
                "  REQUESTING_REASON, " +
                "  LEAVE_DAYS, " +
                "  EL.LEAVE_ID, " +
                "  LT.DESCRIPTION, " +
                "  nvl(EL.STARTTIME,'Not Necessary') AS STARTTIME, " +
                "  NVL(EL.ENDTIME ,'Not Necessary') AS ENDTIME " +
                " FROM HR_EMP_LEAVE EL, " +
                "  HR_LU_LEAVE_TYPE LT " +
                " WHERE  EL.LEAVE_TYPE=LT.LEAVE_TYPE_CODE " +
                " AND leave_id     = ?";
     


        try {
            con = getConnection();
            ps = con.prepareStatement(selectStatment);
            ps.setString(1, leaveId);

            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            if (ocrs.next()) {
                list = new HashMap();
                list.put("REQUESTED_FROM_DATE", ocrs.getString("REQUESTED_FROM_DATE"));
                list.put("REQUESTED_TO_DATE", ocrs.getString("REQUESTED_TO_DATE"));
                list.put("LEAVE_DAYS", ocrs.getString("LEAVE_DAYS"));
                list.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                list.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                list.put("STARTTIME", ocrs.getString("STARTTIME"));
                list.put("ENDTIME", ocrs.getString("ENDTIME"));


                return list;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
}

