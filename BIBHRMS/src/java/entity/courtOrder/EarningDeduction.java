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
public class EarningDeduction extends ConnectionManager {
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
    private String description;
    private String type;
    private String taxable;
    private int category;
   // private connectionManager connMgr = new connectionManager();

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getTaxable() {
        return taxable;
    }

    public void setTaxable(String taxable) {
        this.taxable = taxable;
    }

    public int getCategory() {
        return category;
    }

    public void setCategory(int category) {
        this.category = category;
    }

    public boolean save() throws SQLException {
        _con =getConnection();
        String sql = "INSERT INTO HR_FMS_EARNING_DEDUCTION (CODE,DESCRIPTION,TYPE,TAXABLE,CATEGORY)VALUES (?,?,?,?,?)";
        PreparedStatement _ps = _con.prepareStatement(sql);
        _ps.setString(1, getCode());
        _ps.setString(2, getDescription());
        _ps.setString(3, getType());
        _ps.setString(4, getTaxable());
        _ps.setInt(5, getCategory());
        _ps.executeUpdate();
        return true;
    }

    public boolean update() throws SQLException {
       
        _con =getConnection();
        String sql = "UPDATE HR_FMS_EARNING_DEDUCTION SET DESCRIPTION=?,TYPE=?,TAXABLE=?,CATEGORY=? WHERE CODE=?";
        _ps = _con.prepareStatement(sql);
        _ps.setString(1, getDescription());
        _ps.setString(2, getType());
        _ps.setString(3, getTaxable());
        _ps.setInt(4, getCategory());
        _ps.setString(5, getCode());
        _ps.executeUpdate();
        return true;
    }

    public boolean delete() throws SQLException {
       
        _con =getConnection();
        String sql = "DELETE HR_FMS_EARNING_DEDUCTION WHERE CODE=?";
        _ps = _con.prepareStatement(sql);
        _ps.setString(1, getCode());
        _ps.executeUpdate();
        return true;
    }

    public ResultSet search() throws SQLException {
       _rs = null;
      
       _con =getConnection();
        String sql = "SELECT * FROM HR_FMS_EARNING_DEDUCTION ORDER BY to_number(CODE)";
      _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet searchCompED() throws SQLException {
        ResultSet _rs = null;
       
        _con =getConnection();
        String sql = "SELECT * FROM TBL_COMP_ED WHERE CODE NOT IN(4,10,18,20,25,26,32,55,56,70,51,31,39,12,17,16,29,28,35,54,15,36)ORDER BY to_number(CODE)";
         _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet searchCompEDComp() throws SQLException {
      _rs = null;
      
          _con =getConnection();
        String sql = "SELECT * FROM TBL_COMP_ED WHERE CODE IN(32,56,69,31,39,17,16,29,28,35,54,15,12,36)ORDER BY to_number(CODE)";
     _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet searchPayroll() throws SQLException {
       _rs = null;
       
        _con =getConnection();
        String sql = "SELECT distinct PAYROLL_CODE FROM FMS_PAYROLL";
        _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet searchOrderByName() throws SQLException {
      _rs = null;
     
         _con =getConnection();
        String sql = "SELECT * FROM HR_FMS_EARNING_DEDUCTION ORDER BY DESCRIPTION";
      _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet searchAbsentCode() throws SQLException {
        _rs = null;

         _con =getConnection();
        String sql = "SELECT * FROM HR_FMS_EARNING_DEDUCTION WHERE CODE='2'";
        _ps = _con.prepareStatement(sql);
        _rs = _ps.executeQuery();
        return _rs;

    }

    public ResultSet search(String code) throws SQLException {
      _rs = null;
       
        setCode(code);
        _con =getConnection();
        String sql = "SELECT * FROM HR_FMS_EARNING_DEDUCTION WHERE CODE=?";
        _ps = _con.prepareStatement(sql);
        _ps.setString(1, getCode());
        _rs = _ps.executeQuery();
        return _rs;

    }
}