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
public class ShiftTimeRegEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public ResultSet selectShifts() throws SQLException {
        String select_employees = "select * from HR_LU_SHIFT_TYPES";
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

    public int insert_shift_time(String start_time, String end_time, String shift_code, String registered_date, String address) throws SQLException {
        String _insert = "insert into SHIFT_TIME_REGISTRATION(SHIFT_TIME_REG_ID,START_TIME,END_TIME,SHIFT_CODE,REGISTERED_DATE,ADDRESS_CODE)values(SEQSHIFTTIME.NEXTVAL,?,?,?,?,?)";
        int result = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, start_time);
            _ps.setString(2, end_time);
            _ps.setString(3, shift_code);
            _ps.setString(4, registered_date);
            _ps.setString(5, address);
            result = _ps.executeUpdate();
            return result;

        } catch (Exception ex) {

            ex.printStackTrace();
            return 0;
        }
    }

    public int update_shift_time(String shift_Time_Registration_Id, String start_time, String end_time, String shift_code, String registered_date) throws SQLException {
        String _update = "update SHIFT_TIME_REGISTRATION set START_TIME=?, END_TIME=?,REGISTERED_DATE=?,SHIFT_CODE=? where SHIFT_CODE='" + shift_code + "' AND SHIFT_TIME_REG_ID='" + shift_Time_Registration_Id + "'";
        int result = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, start_time);
            _ps.setString(2, end_time);
            _ps.setString(3, registered_date);
            _ps.setString(4, shift_code);
            result = _ps.executeUpdate();
            return result;

        } catch (Exception ex) {

            ex.printStackTrace();
            return 0;
        }
    }
}
