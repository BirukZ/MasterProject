/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.globalUseManager.ErrorLogWriter;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Preferred Customer
 */
public class Region extends ConnectionManager implements Serializable {

    private String regionId;
    private String regionName;
    private String regionDescription;
    int check;
    PreparedStatement _Ps = null;
        ResultSet rs = null;
        Connection _con=null;
        public void releaseResources() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (_Ps != null) {
            _Ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }
    /**
     *
     */
    public Region() {
    }

    /**
     *
     * @param regionId
     * @param regionName
     * @param regionDescription
     */
    public Region(String regionId, String regionName, String regionDescription) {
        this.regionId = regionId;
        this.regionName = regionName;
        this.regionDescription = regionDescription;
    }

    /**
     * @return the regionId
     */
    public String getRegionId() {
        return regionId;
    }

    /**
     * @param regionId the regionId to set
     */
    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    /**
     * @return the regionName
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * @param regionName the regionName to set
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * @return the regionDescription
     */
    public String getRegionDescription() {
        return regionDescription;
    }

    /**
     * @param regionDescription the regionDescription to set
     */
    public void setRegionDescription(String regionDescription) {
        this.regionDescription = regionDescription;
    }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @return
     */
    public ArrayList<Region> readAllRegion() {

        

        ArrayList<Region> regionList = new ArrayList<Region>();
        try {
            _con = getConnection();
            _Ps = _con.prepareStatement("SELECT * FROM hr_lu_region");
            rs = _Ps.executeQuery();
            while (rs.next()) {
                Region regionType = new Region(rs.getString("region_Id"), rs.getString("region_Name"), rs.getString("region_Description"));
                regionList.add(regionType);
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
        return regionList;
    }

    /**
     *
     * @param regionID
     * @return
     */
    public HashMap readRegion(String regionID) {

        
        
        
        HashMap list = new HashMap();
        String str = "SELECT * FROM hr_lu_region WHERE region_Id=?";

        try {
            _con = getConnection();
            _Ps = _con.prepareStatement(str);
            _Ps.setString(1, regionID);
            rs = _Ps.executeQuery();
            if (rs.next()) {
                list.put("REGION_ID", rs.getString("REGION_ID"));
                list.put("REGION_NAME", rs.getString("REGION_NAME"));
                list.put("REGION_DESCRIPTION", rs.getString("REGION_DESCRIPTION"));
                    return list;
            } else {

                return null;
            }
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

    public int countRegion(String regionID) {
        
        
        
        String str = "SELECT max(rownum) as num FROM hr_lu_region WHERE region_Id=?";
        int rownum;
        try {
            _con = getConnection();
            _Ps = _con.prepareStatement(str);
            _Ps.setString(1, regionID);
            rs = _Ps.executeQuery();
            if (rs.next()) {
                rownum = rs.getInt("num");

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
     * @param regionName
     * @param regionDescription
     */
    public void addRegion(String regionID, String regionName, String regionDescription) {
        this.setRegionId(regionID);
        this.setRegionName(regionName);
        this.setRegionDescription(regionDescription);

    }

    /**
     *
     */
    public int insertRegion() {
        
        
        
        String str = "INSERT INTO hr_lu_region (region_Id,region_Name,region_Description) values(?,?,?)";
        try {
            _con = getConnection();
            _Ps = _con.prepareStatement(str);
            _Ps.setString(1, getRegionId());
            _Ps.setString(2, getRegionName());
            _Ps.setString(3, getRegionDescription());
            check = _Ps.executeUpdate();
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

    /**
     *
     * @param regionID
     * @param regionName
     * @param regionDescription
     */
    public int addForUpdateRegion(String regionID, String regionName, String regionDescription) {
        this.setRegionId(regionID);
        this.setRegionName(regionName);
        this.setRegionDescription(regionDescription);
        return this.updateRegion();
    }

    private int updateRegion() {
        
        
        

        String str = "UPDATE hr_lu_region set region_Name=?, region_Description=? WHERE region_Id=?";

        try {
            _con = getConnection();
            _Ps = _con.prepareStatement(str);
            _Ps.setString(1, getRegionName());
            _Ps.setString(2, getRegionDescription());
            _Ps.setString(3, getRegionId());
            check = _Ps.executeUpdate();
            
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

    /**
     *
     * @param regionID
     */
    public int deleteRegion(String regionID) {
        
        
        

        String str = "DELETE FROM hr_lu_region WHERE region_Id=?";

        try {
            _con = getConnection();
            _Ps = _con.prepareStatement(str);
            _Ps.setString(1, regionID);
            check = _Ps.executeUpdate();
            
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
