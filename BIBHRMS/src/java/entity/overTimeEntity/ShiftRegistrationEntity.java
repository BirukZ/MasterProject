/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.overTimeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author user
 */
public class ShiftRegistrationEntity extends ConnectionManager {

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

    public ResultSet selectShiftRegistration(String dept_id) throws SQLException {
        String select_employees = "SELECT em.FIRST_NAME AS FIRST_NAME, " +
                "  em.MIDDLE_NAME     AS MIDDLE_NAME, " +
                "  em.LAST_NAME       AS LAST_NAME, " +
                "  JT.JOB_DESCRIPTION AS JOB_DESCRIPTION, " +
                "  em.EMP_ID          AS EMP_ID, " +
                "  OFFICE_OR_SHIFT    AS shift,nvl(sh.shift_type,'Norm') as shift_type,  NVL(sh.start_date,'Not Registerd')as start_date , NVL(sh.end_date,'Not Registerd')as end_date " +
                "FROM hr_employee_info em " +
                "INNER JOIN HR_LU_JOB_TYPE JT " +
                "ON em.JOB_CODE=JT.JOB_CODE " +
                "LEFT JOIN hr_shift_registration sh " +
                "ON sh.emp_id       =em.emp_id " +
                "WHERE  em.DEPARTMENT_ID='" + dept_id + "' " +
                "AND em.OFFICE_OR_SHIFT= 'Shift'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select_employees);

            ResultSet _rs1 = _ps.executeQuery();



            return _rs1;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }


    //##################Update hr_employee_info ###############################################
    public int update_shift(String shift, String id, String startDate, String endDate) throws SQLException {

        String query = "INSERT INTO HR_SHIFT_REGISTRATION (SHIFT_REG_ID,EMP_ID,SHIFT_TYPE,START_DATE,END_DATE) VALUES(HR_SHIFT_REG_SQ.NEXTVAL,?,?,?,?)";
        String delete = "DELETE FROM HR_SHIFT_REGISTRATION " +
                " WHERE EMP_ID=? AND START_DATE=? and END_DATE=? ";
        int result = 0;
        try {

            _con = getConnection();

            PreparedStatement _psDelete = null;

            _psDelete = _con.prepareStatement(delete);
            _psDelete.setString(1, id);
            _psDelete.setString(2, startDate);
            _psDelete.setString(3, endDate);
            _psDelete.executeUpdate();
            _ps = _con.prepareStatement(query);
            _ps.setString(1, id);
            _ps.setString(2, shift);
            _ps.setString(3, startDate);
            _ps.setString(4, endDate);
            
            if (_ps.executeUpdate() > 0) {
                result = 1;
            }
           // result = _ps.executeUpdate();
            return result;

        } catch (Exception ex) {

            ex.printStackTrace();
            return 0;
        }
    }
}
