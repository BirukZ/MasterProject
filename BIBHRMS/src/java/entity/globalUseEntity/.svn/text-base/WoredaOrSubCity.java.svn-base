/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class WoredaOrSubCity extends ConnectionManager {
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Preferred Customer
     */
     Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

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
    private String id;
    private String name;
    private String description;
    int check;

    /**
     *
     */
    public WoredaOrSubCity() {
    }
    /**
     *
     * @param id
     * @param name
     * @param description
     */
    private int woredaSubCityID;

    public String getWoredaSubCityDescription() {
        return woredaSubCityDescription;
    }

    public void setWoredaSubCityDescription(String woredaSubCityDescription) {
        this.woredaSubCityDescription = woredaSubCityDescription;
    }

    public int getWoredaSubCityID() {
        return woredaSubCityID;
    }

    public void setWoredaSubCityID(int woredaSubCityID) {
        this.woredaSubCityID = woredaSubCityID;
    }

    public String getWoredaSubCityName() {
        return woredaSubCityName;
    }

    public void setWoredaSubCityName(String woredaSubCityName) {
        this.woredaSubCityName = woredaSubCityName;
    }
    private String woredaSubCityName;
    private String woredaSubCityDescription;

    public WoredaOrSubCity(int woredaSubCityID, String woredaSubCityName, String woredaSubCityDescription) {
        this.woredaSubCityID = woredaSubCityID;
        this.woredaSubCityName = woredaSubCityName;
        this.woredaSubCityDescription = woredaSubCityDescription;
    }

    public WoredaOrSubCity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @return
     */
    public HashMap[] readWoredaOrSubCity(String regionID, String zoneOrCityID) {

        
        ResultSet _rs = null;
        

        // String stro = "SELECT * FROM hr_lu_woreda_or_sub_city WHERE region_Id=? AND zone_Or_City_Id=?";
        //String str = "SELECT * FROM hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id` INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_zone_or_city.`zone_Or_City_Id` = ?  AND hr_lu_region.`region_Id` = ?";
        HashMap[] _list = null;
        int i = 0;
        String str = "SELECT * FROM hr_lu_woreda_or_sub_city INNER JOIN " +
                "hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.zone_or_city_id = " +
                " hr_lu_zone_or_city.zone_or_city_id " +
                " INNER JOIN hr_lu_region ON " +
                "hr_lu_zone_or_city.region_id = hr_lu_region.region_id" +
                "  WHERE hr_lu_region.region_Id =? AND " +
                " hr_lu_zone_or_city.zone_Or_City_Id =?";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            OracleCachedRowSet ocrs=new OracleCachedRowSet();            
            _rs = _ps.executeQuery();
            ocrs.populate(_rs);
           _list = new HashMap[ocrs.size()];
              while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("WOREDA_OR_SUBCITY_ID", ocrs.getString("WOREDA_OR_SUBCITY_ID"));
                _list[i].put("WOREDA_OR_SUBCITY_NAME", ocrs.getString("WOREDA_OR_SUBCITY_NAME"));
                if (ocrs.getString("WOREDA_OR_SUBCITY_DESCRIPTION") != null) {
                    _list[i].put("WOREDA_OR_SUBCITY_DESCRIPTION", ocrs.getString("WOREDA_OR_SUBCITY_DESCRIPTION"));
                } else {
                    _list[i].put("WOREDA_OR_SUBCITY_DESCRIPTION", "Description not available");
                }
                i++;
            }

            return _list;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countWoredaOrSubCity(String regionID, String zoneOrCityID) {

        
        ResultSet __rs = null;
        
        // String stro = "SELECT * FROM hr_lu_woreda_or_sub_city WHERE region_Id=? AND zone_Or_City_Id=?";
        //String str = "SELECT * FROM hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id` INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_zone_or_city.`zone_Or_City_Id` = ?  AND hr_lu_region.`region_Id` = ?";
        HashMap[] _list = null;
        int rownum;
        int i = 0;
        String str = "SELECT max(rownum) as num FROM hr_lu_woreda_or_sub_city INNER JOIN  " +
                "hr_lu_zone_or_city ON  hr_lu_woreda_or_sub_city.zone_or_city_id = " +
                "hr_lu_zone_or_city.zone_or_city_id " +
                " INNER JOIN hr_lu_region ON hr_lu_zone_or_city.region_id = hr_lu_region.region_id " +
                " WHERE hr_lu_region.region_Id =? AND " +
                "hr_lu_zone_or_city.zone_Or_City_Id =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            __rs = _ps.executeQuery();
            OracleResultSetMetaData count = (OracleResultSetMetaData) __rs.getMetaData();
            _list = new HashMap[count.getColumnCount()];
            if (__rs.next()) {
                rownum = __rs.getInt("num");

                return rownum;
            } else {

                return 0;
            }




        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @param woredaO_rsubCityID
     * @return
     */
    public ResultSet readWoredaO_rsubCity(String regionID, String zoneOrCityID, String woredaO_rsubCityID) {
        
        ResultSet __rs = null;
        


        //String stro = "SELECT * FROM hr_lu_woreda_or_sub_city WHERE region_Id=? AND zone_Or_City_Id=? AND woreda_Or_Sub_City_Id=?";
        String str = "SELECT * FROM hr_lu_woreda_or_subcity INNER JOIN " +
                "hr_lu_zone_or_city ON hr_lu_woreda_or_subcity.`zone_Or_City_Code` " +
                "= hr_lu_zone_or_city.`zone_Or_City_Code` WHERE " +
                "hr_lu_zone_or_city.`zone_Or_City_Id` = ? " +
                "AND hr_lu_woreda_or_subcity.`woreda_Or_SubCity_Id` = ?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, zoneOrCityID);
            // ps.setString(2, regionID);
            _ps.setString(2, woredaO_rsubCityID);

            __rs = _ps.executeQuery();

            return __rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param zoneOrCityId
     * @return
     */
    public ArrayList<WoredaOrSubCity> readWoredaSubCityInAZone(String zoneOrCityId) {
        
        
        

        ArrayList<WoredaOrSubCity> woredaSubCityList = new ArrayList<WoredaOrSubCity>();
        try {
            _con = getConnection();
            _ps = _con.prepareCall("select* from hr_lu_woreda_or_sub_city where zone_Or_City_Id='" + zoneOrCityId + "'");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                WoredaOrSubCity woredaSubCityType = new WoredaOrSubCity(_rs.getInt("woreda_Or_SubCity_Id"), _rs.getString("woreda_Or_SubCity_Name"), _rs.getString("woreda_Or_SubCity_Description"));
                woredaSubCityList.add(woredaSubCityType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return woredaSubCityList;
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @return
     */
    public ArrayList<WoredaOrSubCity> readWoredaO_rsubCityByZoneOrCityAndByReagion(String regionID, String zoneOrCityID) {
        
        
        

        ArrayList<WoredaOrSubCity> woredaO_rsubCityList = new ArrayList<WoredaOrSubCity>();
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement("SELECT * FROM hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id` INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_region.`region_Id` = ? AND hr_lu_zone_or_city.`zone_Or_City_Id` = ?");
            ps.setString(1, regionID);
            ps.setString(2, zoneOrCityID);

            _rs = ps.executeQuery();

            while (_rs.next()) {
                WoredaOrSubCity woredaO_rsubCityType = new WoredaOrSubCity(_rs.getString("woreda_Or_Sub_City_Id"), _rs.getString("woreda_Or_Sub_City_Name"), _rs.getString("woreda_Or_Sub_City_Description"));
                woredaO_rsubCityList.add(woredaO_rsubCityType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return woredaO_rsubCityList;
    }

    /**
     *
     * @param zoneOrCityID
     * @param id
     * @param name
     * @param description
     */
    public void addWoredaO_rsubCity(String zoneOrCityID, String id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);

        this.insertWoredaO_rsubCity(zoneOrCityID);
    }

    /**
     *
     * @param zoneOrCityID
     */
    public void insertWoredaO_rsubCity(String zoneOrCityID) {
        
        
        
        String str = "INSERT INTO hr_lu_woreda_or_sub_city (zone_Or_City_Id,woreda_Or_Sub_City_Id, woreda_Or_Sub_City_Name,woreda_Or_Sub_City_Description) values(?,?,?,?)";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, zoneOrCityID);
            ps.setString(2, getId());
            ps.setString(3, getName());
            ps.setString(4, getDescription());

            ps.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param regionID
     * @param zoneOrCity
     */
    public void deleteWoredaO_rsubCity(String regionID, String zoneOrCity) {
        
        
        

        String str = "DELETE FROM hr_lu_woreda_or_sub_city WHERE zone_Or_City_Id=?";
        //String str = "DELETE FROM hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id`INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_region.`region_Id` = ? AND hr_lu_zone_or_city.`zone_Or_City_Id` = ?";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            //ps.setString(1, regionID);
            ps.setString(1, zoneOrCity);

            ps.executeUpdate();


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @return
     */
    public ResultSet getWoredaO_rsubCityCode() {
        
        
        

        String str = "SELECT * FROM hr_lu_woreda_or_subcity";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            _rs = ps.executeQuery();
             OracleCachedRowSet ocrs=new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet)ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int addWoredaOrSubCity(String zoneOrCityID, String id, String name, String description) {
        this.setId(id);
        this.setName(name);
        this.setDescription(description);
        return this.insertWoredaOrSubCity(zoneOrCityID);
    }

    /**
     *
     * @param zoneOrCityID
     */
    public int insertWoredaOrSubCity(String zoneOrCityID) {
        Connection _conn;
        ResultSet rs = null;
        PreparedStatement ps;
        String str = "INSERT INTO hr_lu_woreda_or_sub_city (ZONE_OR_CITY_ID,WOREDA_OR_SUBCITY_ID, WOREDA_OR_SUBCITY_NAME,WOREDA_OR_SUBCITY_DESCRIPTION) values(?,?,?,?)";

        try {
            _conn = getConnection();
            ps = _conn.prepareStatement(str);
            ps.setString(1, zoneOrCityID);
            ps.setString(2, getId());
            ps.setString(3, getName());
            ps.setString(4, getDescription());
            check = ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int readWoredaOrSubCity(String regionID, String zoneOrCityID, String woredaOrSubCityID) {
        
        
        

        //String stro = "SELECT * FROM hr_lu_woreda_or_sub_city WHERE region_Id=? AND zone_Or_City_Id=? AND woreda_Or_Sub_City_Id=?";
        String str = "select * from hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON " +
                " hr_lu_woreda_or_sub_city.zone_or_city_id=hr_lu_zone_or_city.zone_or_city_id where  hr_lu_zone_or_city.zone_Or_City_Id =?" +
                " AND hr_lu_woreda_or_sub_city.woreda_or_subcity_id = ?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, zoneOrCityID);
            _ps.setString(2, woredaOrSubCityID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                return 1;
            } else {

                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
    }

    public int deleteWoredaOrSubCity(String regionID, String zoneOrCity) {
        
        
        

        String str = "DELETE FROM hr_lu_woreda_or_sub_city WHERE zone_Or_City_Id=?";
        //String str = "DELETE FROM hr_lu_woreda_or_sub_city INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id`INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_region.`region_Id` = ? AND hr_lu_zone_or_city.`zone_Or_City_Id` = ?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            //ps.setString(1, regionID);
            _ps.setString(1, zoneOrCity);
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}
