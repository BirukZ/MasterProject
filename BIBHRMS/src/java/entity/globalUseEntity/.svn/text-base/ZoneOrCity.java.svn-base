/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class ZoneOrCity extends ConnectionManager {

    String id;
    String name;
    String description;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ZoneOrCity(String id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */

    /**
     *
     * @author Preferred Customer
     */
    /**
     * The default constructor is used to instatiate the class without parameters
     */
    public ZoneOrCity() {
    }

    /**
     * The constructor is used to intatiate the class with the following parameters
     * @param id the zone or city identifier
     * @param name the zone or city name
     * @param description the zone or city further description


    /**
     * @return the id
     */
    /**
     * @param id the id to set
     */
    /**
     * @return the name
     */
    /**
     * @param name the name to set
     */
    /**
     * @return the description
     */
    /**
     * @param description the description to set
     */
    /**
     * Fetches all columns from hr_lu_zone_or_city and adds the
     * <code>ResultSet</code> object to an <code>ArrayList</code> object
     * @return an ArrayList object zoneOrCityList
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ArrayList<ZoneOrCity> readZoneOrCity() {
        ResultSet rs = null;
        ArrayList<ZoneOrCity> zoneOrCityList = new ArrayList<ZoneOrCity>();
        Connection _con;
        PreparedStatement ps;
        try {
            _con = getConnection();
            ps = _con.prepareStatement("select * from hr_lu_zone_or_city");
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                ZoneOrCity zoneOrCityType = new ZoneOrCity(ocrs.getString("zone_Or_City_Id"), ocrs.getString("zone_Or_City_Name"), ocrs.getString("zone_Or_City_Description"));
                zoneOrCityList.add(zoneOrCityType);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return zoneOrCityList;
    }

    /**
     *Fetches all columns from hr_lu_zone_or_city which are in specified region
     * and adds the <code>ResultSet</code> object to an <code>ArrayList</code>
     * object
     * @param regionId the region identifier
     * @return an ArrayList object zoneOrCityList
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ArrayList<ZoneOrCity> readZoneOrCityInARegion(String regionId) {
        Connection _con;
        PreparedStatement ps;
        ResultSet rs = null;

        ArrayList<ZoneOrCity> zoneOrCityList = new ArrayList<ZoneOrCity>();
        try {
            _con = getConnection();
            PreparedStatement zoneOrCityPs = _con.prepareStatement("select * from hr_lu_zone_or_city WHERE region_Id=?");
            zoneOrCityPs.setString(1, regionId);

            rs = zoneOrCityPs.executeQuery();

            while (rs.next()) {
                ZoneOrCity zoneOrCityType = new ZoneOrCity(rs.getString("zone_Or_City_Id"), rs.getString("zone_Or_City_Name"), rs.getString("zone_Or_City_Description"));
                zoneOrCityList.add(zoneOrCityType);
            }

        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return zoneOrCityList;
    }

    /**
     * Fetches all columns in the hr_lu_zone_or_city table
     * which are in specified region
     * @param regionID the region identifier
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public HashMap[] readZoneOrCity(String regionID) {

        Connection _con;
        PreparedStatement ps;
        ResultSet rs = null;
        HashMap[] listZone = null;
        int i = 0;
        String str = "SELECT * FROM hr_lu_zone_or_city WHERE region_Id=?";
        listZone = new HashMap[this.countZoneOrCity(regionID)];
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);

            ps.setString(1, regionID);
            rs = ps.executeQuery();
            while (rs.next()) {
                listZone[i] = new HashMap();
                listZone[i].put("ZONE_OR_CITY_ID", rs.getString("ZONE_OR_CITY_ID"));
                listZone[i].put("ZONE_OR_CITY_NAME", rs.getString("ZONE_OR_CITY_NAME"));
                listZone[i].put("ZONE_OR_CITY_DESCRIPTION", rs.getString("ZONE_OR_CITY_DESCRIPTION"));
                i++;
            }

            return listZone;
        } catch (Exception ex) {
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public int countZoneOrCity(String regionID) {

        Connection _con;
        PreparedStatement ps;
        ResultSet rs = null;
        HashMap[] listZone = null;
        int i = 0;
        int rownum;
        String str = "SELECT max(rownum) as num FROM hr_lu_zone_or_city WHERE region_Id=?";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, regionID);
            rs = ps.executeQuery();
            if (rs.next()) {
                rownum = rs.getInt("num");
                return rownum;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    /**
     * Fetches all columns in the hr_lu_zone_or_city table
     * which are in specified hr_lu_region.region_Id and hr_lu_zone_or_city.zone_Or_City_Id
     * @param regionID the region identifier
     * @param zoneOrCityID the zone or city identifier
     * @return a <code>ResultSet</code> object rs
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int readZoneOrCity(String regionID, String zoneOrCityID) {
        Connection _con;
        PreparedStatement ps;
        ResultSet rs = null;

        String str = "SELECT max(rownum) as num FROM hr_lu_zone_or_city INNER JOIN hr_lu_region " +
                "ON hr_lu_zone_or_city.REGION_ID = hr_lu_region.REGION_ID " +
                "WHERE hr_lu_region.region_Id = ? AND hr_lu_zone_or_city.zone_Or_City_Id = ?";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, regionID);
            ps.setString(2, zoneOrCityID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * Adds the data value in the parameters into hr_lu_zone_or_city
     * @param regionID the region identifier
     * @param id the zone or city identifier
     * @param name the zone or city name
     * @param description the zone or city further description
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int insertZoneOrCity(String regionID, String id, String name, String description) {
        Connection _con;
        String str = null;
        PreparedStatement ps = null;
        int check;
        try {

            str = "INSERT INTO hr_lu_zone_or_city (region_Id, zone_Or_City_Id, " +
                    "zone_Or_City_Name, zone_Or_City_Description) values(?,?,?,?)";
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, regionID);
            ps.setString(2, id);
            ps.setString(3, name);
            ps.setString(4, description);
            check = ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Removes a record from hr_lu_zone_or_city based on region_Id
     * @param regionID the region identifier
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int deleteZoneOrCity(String regionID) {
        Connection _con;
        PreparedStatement ps;
        int check;

        String str = "DELETE FROM hr_lu_zone_or_city WHERE region_Id=?";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, regionID);
            check = ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Removes a record from hr_lu_zone_or_city based on region_Id and zoneOrCityID
     * @param regionID the region identifier
     * @param zoneOrCityID the zone or city identifier
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int deleteZoneOrCity(String regionID, String zoneOrCityID) {
        Connection _con;
        PreparedStatement ps;
        int check;

        String str = "DELETE FROM hr_lu_zone_or_city WHERE zone_Or_City_Id=? ";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, zoneOrCityID);
            check = ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int deleteWoreda(String regionID, String zoneOrCityID) {
        Connection _con;
        PreparedStatement ps;
        int check;

        String str = "DELETE FROM hr_lu_woreda_or_sub_city WHERE zone_Or_City_Id=? and woreda_or_subcity_id=?";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, zoneOrCityID);
            ps.setString(2, regionID);
            check = ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Fetches all columns in the hr_lu_zone_or_city table
     * which are in specified region given by region_Id
     * @param regionID the region identifier
     * @return an ArrayList object zoneOrCityList
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ArrayList<ZoneOrCity> readZoneOrCityByReagion(String regionID) {
        Connection _con;
        PreparedStatement ps;
        ResultSet rs = null;

        ArrayList<ZoneOrCity> zoneOrCityList = new ArrayList<ZoneOrCity>();
        try {
            _con = getConnection();
            ps = _con.prepareStatement("select * from hr_lu_zone_or_city WHERE region_Id=?");
            ps.setString(1, regionID);
            rs =
                    ps.executeQuery();

            while (rs.next()) {
                ZoneOrCity zoneOrCityType = new ZoneOrCity(rs.getString("zone_Or_City_Id"), rs.getString("zone_Or_City_Name"), rs.getString("zone_Or_City_Description"));
                zoneOrCityList.add(zoneOrCityType);
            }
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return zoneOrCityList;
    }
}
