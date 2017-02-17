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
//import javax.swing.JOptionPane;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class Kebelle extends ConnectionManager{

    
    /*
     * To change this template, choose Tools | Templates
     * and open the template in the editor.
     */
    private String kebelleID;
    private String kebelleName;
    private String kebelleDescription;

    /**
     *
     */
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
    public Kebelle() {
    }

    /**
     *
     * @param kebelleID
     * @param kebelleName
     */
    public Kebelle(String kebelleID, String kebelleName) {
        this.kebelleID = kebelleID;
        this.kebelleName = kebelleName;
    }

    /**
     *
     * @param kebelleID
     * @param kebelleName
     * @param kebelleDescription
     */
    public Kebelle(String kebelleID, String kebelleName, String kebelleDescription) {
        this.kebelleID = kebelleID;
        this.kebelleName = kebelleName;
        this.kebelleDescription = kebelleDescription;
    }

////////////////    public ArrayList<Kebelle> readAll() {
////////////////        return Address.readKebelle(null);
////////////////    }
    /**
     * @return the kebelleDescription
     */
    public String getKebelleDescription() {
        return kebelleDescription;
    }

    /**
     * @param kebelleDescription the kebelleDescription to set
     */
    public void setKebelleDescription(String kebelleDescription) {
        this.kebelleDescription = kebelleDescription;
    }

    /**
     * @return the kebelleName
     */
    public String getKebelleName() {
        return kebelleName;
    }

    /**
     * @param kebelleName the kebelleName to set
     */
    public void setKebelleName(String kebelleName) {
        this.kebelleName = kebelleName;
    }

    /**
     * @return the kebelleID
     */
    public String getKebelleID() {
        return kebelleID;
    }

    /**
     * @param kebelleID the kebelleID to set
     */
    public void setKebelleID(String kebelleID) {
        this.kebelleID = kebelleID;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

    /**
     *
     * @param woredaOrSubCityId
     * @return
     */
    public ArrayList<Kebelle> readKebelleInAWoredaOrSubCity(String woredaOrSubCityId) {
        ArrayList<Kebelle> kebelleList = new ArrayList<Kebelle>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_kebelle where woreda_Or_SubCity_Id='" + woredaOrSubCityId + "'");
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                Kebelle KebelleType = new Kebelle(_rs.getString("kebelle_Id"), _rs.getString("kebelle_Name"), _rs.getString("kebelle_Description"));
                kebelleList.add(KebelleType);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    /**
     * This method is used to read all the kebles from the database
     * @return
     */
    public ArrayList<Kebelle> readAll()  {
       
       
       

        ArrayList<Kebelle> kebelleList = new ArrayList<Kebelle>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_kebelle");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                Kebelle KebelleType = new Kebelle(_rs.getString("kebelle_Id"), _rs.getString("kebelle_Name"));
                kebelleList.add(KebelleType);
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
        return kebelleList;
    }

    /**
     *
     * @param regionID
     * @param zoneOrCityID
     * @param woredaOrSubCityID
     * @return
     */
    public ArrayList<Kebelle> readKebelleByWoredaOrSubCityAndZoneOrCityAndByReagion(String regionID, String zoneOrCityID, String woredaOrSubCityID) {

        ResultSet rs = null;

        ArrayList<Kebelle> kebelleList = new ArrayList<Kebelle>();
        try {
            //   rs = this.readkebelle(regionID, zoneOrCityID, woredaOrSubCityID);
            while (rs.next()) {
                Kebelle kebelle = new Kebelle(rs.getString("kebelle_Id"), rs.getString("kebelle_Name"), rs.getString("kebelle_Description"));
                kebelleList.add(kebelle);
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
        return kebelleList;
    }

    /**
     * This method is used to save a new keble to the database
     * @param woredaOrSubCityID
     * @param kebelleID
     * @param kebelleName
     * @param kebelleDescription
     */
    public int addkebelle(String woredaOrSubCityID, String kebelleID, String kebelleName, String kebelleDescription) {
        this.setKebelleID(kebelleID);
        this.setKebelleName(kebelleName);
        this.setKebelleDescription(kebelleDescription);

        return this.insertKebelle(woredaOrSubCityID);
    }

    private int insertKebelle(String woredaOrSubCityID) {
       
      
       

      //  String str = "INSERT INTO hr_lu_kebelle (woreda_Or_SubCity_Id, kebelle_Name,kebelle_Description) values(HR_LU_KEBELLE_SEQ,?,?,?)";

        String str =  " INSERT INTO HR_LU_KEBELLE (KEBELLE_ID,KEBELLE_NAME,KEBELLE_DESCRIPTION,WOREDA_OR_SUBCITY_ID) values(HR_LU_KEBELLE_SEQ.NEXTVAL,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
           // _ps.setString(1, kebelleID);
            _ps.setString(1, getKebelleName());
            _ps.setString(2, getKebelleDescription());
            _ps.setString(3, woredaOrSubCityID);
             return _ps.executeUpdate();

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
     * @param zoneOrCityID
     * @param woredaOrSubCityID
     * @return
     */
    public HashMap[] readKebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID) {
       
       
       
        HashMap[] list = null;
        int i = 0;
        String description = "No Description";


        String str = "SELECT * FROM hr_lu_kebelle INNER JOIN " +
                "hr_lu_woreda_or_sub_city ON hr_lu_kebelle.woreda_Or_SubCity_Id = " +
                " hr_lu_woreda_or_sub_city.woreda_Or_SubCity_Id " +
                " INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city." +
                " zone_Or_City_Id = hr_lu_zone_or_city.zone_Or_City_Id " +
                " INNER JOIN hr_lu_region ON hr_lu_zone_or_city.region_Id = " +
                " hr_lu_region.region_Id WHERE hr_lu_region.region_Id =? " +
                " AND hr_lu_zone_or_city.zone_Or_City_Id = ? " +
                " AND hr_lu_woreda_or_sub_city.woreda_Or_SubCity_Id =? ";
        try {
            list = new HashMap[this.coutKebelleUsing(regionID, zoneOrCityID, woredaOrSubCityID)];
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            _ps.setString(3, woredaOrSubCityID);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("KEBELLE_ID", _rs.getString("KEBELLE_ID"));
                list[i].put("KEBELLE_NAME", _rs.getString("KEBELLE_NAME"));
                if (_rs.getString("KEBELLE_DESCRIPTION") != null) {
                    description = _rs.getString("KEBELLE_DESCRIPTION");
                }
                list[i].put("KEBELLE_DESCRIPTION", description);
                description = "No Description";
                i++;
            }
            return list;
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

    public int checkKebellAvilabelKebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelle) {
       
       
       
        String select = "SELECT   max(rownum) as num FROM ((hr_lu_region INNER JOIN hr_lu_zone_or_city ON hr_lu_region.region_id = hr_lu_zone_or_city.region_id)" +
                " INNER JOIN hr_lu_woreda_or_sub_city ON hr_lu_zone_or_city.zone_or_city_id = hr_lu_woreda_or_sub_city.zone_or_city_id) " +
                " INNER JOIN hr_lu_kebelle ON hr_lu_woreda_or_sub_city.woreda_or_subcity_id = hr_lu_kebelle.woreda_or_subcity_id " +
                " where hr_lu_kebelle.kebelle_id=? and HR_LU_REGION.REGION_ID=? and hr_lu_woreda_or_sub_city.woreda_or_subcity_id=? and   " +
                "hr_lu_zone_or_city.zone_or_city_id=?";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, kebelle);
            _ps.setString(2, regionID);
            _ps.setString(3, woredaOrSubCityID);
            _ps.setString(4, zoneOrCityID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
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

    public int coutKebelleUsing(String regionID, String zoneOrCityID, String woredaOrSubCityID) {
       
       
       
        HashMap[] list = null;
        String str = "SELECT Max(rownum) as num FROM hr_lu_kebelle INNER JOIN " +
                "hr_lu_woreda_or_sub_city ON hr_lu_kebelle.woreda_Or_SubCity_Id = " +
                "hr_lu_woreda_or_sub_city.woreda_Or_SubCity_Id " +
                "INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.zone_Or_City_Id = " +
                " hr_lu_zone_or_city.zone_Or_City_Id " +
                " INNER JOIN hr_lu_region ON hr_lu_zone_or_city.region_Id = " +
                "hr_lu_region.region_Id WHERE hr_lu_region.region_Id = ? " +
                " AND hr_lu_zone_or_city.zone_Or_City_Id = ? " +
                " AND hr_lu_woreda_or_sub_city.woreda_Or_SubCity_Id =? ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            _ps.setString(3, woredaOrSubCityID);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
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
     * @param woredaOrSubCityID
     * @param kebelleID
     * @return
     */
    public ResultSet readkebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelleID) {
       
       
       

        //String str = "SELECT * FROM hr_lu_kebelle WHERE region_Id=? AND zone_Or_City_Id=? AND woreda_Or_Sub_City_Id=? AND kebelle_Id=?";
        String str = "SELECT * FROM hr_lu_kebelle INNER JOIN hr_lu_woreda_or_sub_city ON hr_lu_kebelle.`woreda_Or_SubCity_Id` = hr_lu_woreda_or_sub_city.`woreda_Or_Sub_City_Id` INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id` INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_region.`region_Id` = ? AND hr_lu_zone_or_city.`zone_Or_City_Id` = ? AND hr_lu_woreda_or_sub_city.`woreda_Or_Sub_City_Id` = ? AND hr_lu_kebelle.`kebelle_Id` = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            _ps.setString(3, woredaOrSubCityID);
            _ps.setString(4, kebelleID);

            _rs = _ps.executeQuery();
             OracleCachedRowSet ocrs=new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet)ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int counkebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelleID) {
       
       
       

        //String str = "SELECT * FROM hr_lu_kebelle WHERE region_Id=? AND zone_Or_City_Id=? AND woreda_Or_Sub_City_Id=? AND kebelle_Id=?";
        String str = "SELECT MAX(rownum) as num FROM hr_lu_kebelle INNER JOIN hr_lu_woreda_or_sub_city ON hr_lu_kebelle.`woreda_Or_SubCity_Id` = hr_lu_woreda_or_sub_city.`woreda_Or_Sub_City_Id` INNER JOIN hr_lu_zone_or_city ON hr_lu_woreda_or_sub_city.`zone_Or_City_Id` = hr_lu_zone_or_city.`zone_Or_City_Id` INNER JOIN hr_lu_region ON hr_lu_zone_or_city.`region_Id` = hr_lu_region.`region_Id` WHERE hr_lu_region.`region_Id` = ? AND hr_lu_zone_or_city.`zone_Or_City_Id` = ? AND hr_lu_woreda_or_sub_city.`woreda_Or_Sub_City_Id` = ? AND hr_lu_kebelle.`kebelle_Id` = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, zoneOrCityID);
            _ps.setString(3, woredaOrSubCityID);
            _ps.setString(4, kebelleID);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
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
     * @param zoneOrCity
     * @param woredaOrSubCity
     */
    public int deletekebelle(String kebelleID) {
       
       
       

        String str = "DELETE FROM hr_lu_kebelle WHERE KEBELLE_ID=?";
        //String str = "DELETE FROM hr_lu_kebelle WHERE region_Id=? AND zone_Or_City_Id=? AND woreda_Or_Sub_City_Id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, kebelleID);
            return _ps.executeUpdate();
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
