/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.courtOrder;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Administrator
 */
public class EarningDeductionConstant extends ConnectionManager {
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
  private String code;
    private double value;
    private String startingDate;
    private String endingDate;
    private int idNumber;
    private int dataType;


   

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getDataType() {
        return dataType;
    }

    public void setDataType(int dataType) {
        this.dataType = dataType;
    }

    public boolean save() throws SQLException {
        _con =getConnection();
        String sql = "INSERT INTO TBL_PAYROLL_CONSTANT" +
                "(CODE,COR_VALUE,STARTING_DATE,ENDING_DATE,DATA_TYPE)VALUES(?,?,?,?,?)";
      _ps = _con.prepareStatement(sql);
        _ps.setString(1, getCode());
        _ps.setDouble(2, getValue());
        _ps.setString(3, getStartingDate());
        _ps.setString(4, getEndingDate());
        _ps.setInt(5, getDataType());
        _ps.execute();

        return true;
    }

    public boolean update() throws SQLException {
    _con =getConnection();
        String sql = "UPDATE TBL_PAYROLL_CONSTANT SET  COR_VALUE=?,STARTING_DATE=? ,ENDING_DATE=? WHERE ID=?";
       _ps = _con.prepareStatement(sql);
        _ps.setDouble(1, getValue());
        _ps.setString(2, getStartingDate());
        _ps.setString(3, getEndingDate());
        _ps.setInt(4, getIdNumber());
        _ps.execute();
        return true;
    }

    public boolean delete() throws SQLException {
       _con = getConnection();
        String sql = "UPDATE TBL_PAYROLL_CONSTANT WHERE ID=?";
       _ps = _con.prepareStatement(sql);
        _ps.setInt(1, getIdNumber());
        _ps.execute();
        return true;
    }

    public ResultSet search() throws SQLException {

       _con = getConnection();
        String sql = "SELECT PC.CODE, " +
                "  PC.COR_VALUE, " +
                "  PC.STARTING_DATE, " +
                "  PC.ENDING_DATE, " +
                "  PC.ID , " +
                "  PC.DATA_TYPE, " +
                "  NVL(ED.DESCRIPTION,' ') ED_DESCRIPTION " +
                "FROM TBL_PAYROLL_CONSTANT PC " +
                "LEFT JOIN FMS_EARNING_DEDUCTION ED " +
                "ON ED.CODE=PC.COR_VALUE";
        _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;
    }

    public ResultSet search(String code) throws SQLException {
        ResultSet _rs = null;
       _con = getConnection();
        String sql = "SELECT PC.CODE, " +
                "  PC.COR_VALUE, " +
                "  PC.STARTING_DATE, " +
                "  PC.ENDING_DATE, " +
                "  PC.ID , " +
                "  PC.DATA_TYPE, " +
                "  NVL(ED.DESCRIPTION,' ') ED_DESCRIPTION " +
                "FROM TBL_PAYROLL_CONSTANT PC " +
                "LEFT JOIN FMS_EARNING_DEDUCTION ED " +
                "ON ED.CODE=PC.COR_VALUE WHERE PC.CODE=?";
        _ps = _con.prepareStatement(sql);
        _ps.setString(1, code);
        _rs = _ps.executeQuery();
        return _rs;
    }
}
