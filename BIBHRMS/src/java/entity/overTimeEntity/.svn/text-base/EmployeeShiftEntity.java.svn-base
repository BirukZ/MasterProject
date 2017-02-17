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
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import sun.print.PSPrinterJob;

/**
 *
 * @author BravoZulu
 */
public class EmployeeShiftEntity extends ConnectionManager {

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
      public ResultSet selectAllShiftType() throws SQLException {

        String _selectQuery = " SELECT * FROM HR_LU_SHIFT_TYPES ";
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
        public HashMap readEmployeeShifet(String selectMonth, String selectYear, String empID) throws SQLException {

       String qry= " select * from HR_SHIFT_REGISTRATION where emp_id='" + empID + "' and start_date LIKE '" + selectYear + "-%" + selectMonth + "-%'";
           

        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            System.out.println(qry);
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("EMP_ID"));
                    data.put("shifetType", _rs.getString("SHIFT_TYPE"));
                    data.put("startDate", _rs.getString("START_DATE"));
                    data.put("endDate", _rs.getString("END_DATE"));
            
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

      public boolean SaveUPdatedShift(String empID, String preShiftStartDate, String preShiftEndDate, String preShiftName, String changedShiftName, String shiftChanagedDate,String newShiftStartDate,String newShiftEndDate) throws SQLException {

          String _insertPenaltyType = "INSERT INTO HR_CHANGED_SHIFT " +
                "(SHIFET_CHANGED_ID,EMP_ID,PRE_SHIFT_START_DATE,PRE_SHIFT_END_DATE,PRE_SHIFT_NAME,SHIFT_CHANGED_DATE,NEW_SHIFT,NEW_SHIFT_START_DATE,NEW_SHIFT_END_DATE)" +
                " VALUES(HR_CHANGED_SHIFT_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
               _con = getConnection();
                _ps = _con.prepareStatement(_insertPenaltyType);
                _ps.setString(1,empID );
                _ps.setString(2, preShiftStartDate);
                _ps.setString(3,preShiftEndDate);
                _ps.setString(4, preShiftName);
                _ps.setString(5, shiftChanagedDate);
                _ps.setString(6, changedShiftName);
                 _ps.setString(7, newShiftStartDate);
                  _ps.setString(8, newShiftEndDate);
             
                _ps.execute();
            }


       finally {
            releaseResources();
        }
         return true;
    }



}
