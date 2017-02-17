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
public class EntityemployeeShiftViewer extends ConnectionManager{
      Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

     public ResultSet selectShiftsEmployee(String emp_id) throws SQLException {
        String select_employee = "select OFFICE_OR_SHIFT from HR_EMPLOYEE_INFO where EMP_ID= '"+emp_id+"'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select_employee);
            ResultSet _rs1 = _ps.executeQuery();
            return _rs1;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }
 public ResultSet selectShiftTime(String shiftCode,String address) throws SQLException {
        String select_employee = "select * from SHIFT_TIME_REGISTRATION where SHIFT_CODE= '"+shiftCode+"'"+
                " and ADDRESS_CODE='"+address+"'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select_employee);

            ResultSet _rs1 = _ps.executeQuery();



            return _rs1;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }

 public ResultSet selectAllshifts(String address) throws SQLException {
        String select_employee = "select * from SHIFT_TIME_REGISTRATION where ADDRESS_CODE='"+address+"'";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(select_employee);

            ResultSet _rs1 = _ps.executeQuery();



            return _rs1;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }
  public ResultSet selectAllshifts() throws SQLException {
        String select_employee = "select * from SHIFT_TIME_REGISTRATION";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(select_employee);

            ResultSet _rs1 = _ps.executeQuery();



            return _rs1;

        } catch (Exception ex) {

            ex.printStackTrace();
            return null;
        }
    }
}
