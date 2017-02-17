/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.employeeEntity;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Dereje
 */
public class EmployeeChartEntity extends ConnectionManager {

    public EmployeeChartEntity() {
    }

    public int countInActiveEmployees() {
        int count = 0;
        String _select = "SELECT count(EMP_ID) AS COUNTED FROM HR_EMPLOYEE_INFO WHERE EMP_STATUS !='01' AND EMP_STATUS !='02'";
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            ResultSet _rs = _ps.executeQuery();
            if (_rs.next()) {
                count = _rs.getInt("COUNTED");
            }
            _ps.close();

            return count;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        }
    }

    public int countActiveEmployees() {
        int count = 0;
        String _select = "SELECT count(EMP_ID) AS COUNTED FROM HR_EMPLOYEE_INFO WHERE EMP_STATUS='01'";
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            ResultSet _rs = _ps.executeQuery();
            if (_rs.next()) {
                count = _rs.getInt("COUNTED");
            }
            _ps.close();

            return count;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        }
    }

    public int countOnLeaveEmployees() {
        int count = 0;
        String _select = "SELECT count(EMP_ID) AS COUNTED FROM HR_EMPLOYEE_INFO WHERE EMP_STATUS='02'";
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            ResultSet _rs = _ps.executeQuery();
            if (_rs.next()) {
                count = _rs.getInt("COUNTED");
            }
            _ps.close();

            return count;

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        }
    }
}

