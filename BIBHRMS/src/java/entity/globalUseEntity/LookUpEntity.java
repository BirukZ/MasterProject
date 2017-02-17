/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import com.sun.webui.jsf.model.Option;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class LookUpEntity extends ConnectionManager {

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

    public LookUpEntity() {
    }
    Option[] nationalit;
    String titleCode;

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
    }

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }
    String titleDescription;

    LookUpEntity(String titleCode, String titleDescription) {
        this.titleCode = titleCode;
        this.titleDescription = titleDescription;
    }

    public Option[] getNationality() {
        return nationalit;
    }

    public void setNationality(Option[] nationality) {
        this.nationalit = nationality;
    }

    public ResultSet readNationalityName() {
        String _select = "SELECT nationalityID,nationalityDescription FROM hr_lu_nationality";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet selectNations() throws SQLException {
        try {
            String _select = "SELECT * FROM hr_lu_nation";
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<LookUpEntity> readNation() throws SQLException {
        String _select = "SELECT * FROM hr_lu_nation";
        ArrayList<LookUpEntity> nation = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {
                this.titleCode = _rs.getString("NATION_CODE");
                this.titleDescription = _rs.getString("description");
                LookUpEntity nationEntity = new LookUpEntity(titleCode, titleDescription);
                nation.add(nationEntity);
            }
            return nation;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }

    }


    //////////////////////////////////////////////////////////////////////////////

     public boolean insertInsatiutaitonType(String instiutationName)
                        {


        String _insert = "INSERT INTO HR_LU_EDUC_INSTITUTION " +
                "(INSTITUTION_ID,INSTITUTION_NAME,INSTITUTION_DESCRIPTION,EDUCATION_OR_TRAINING,LOCATION_DESCRIPTION)" +
                " VALUES (HR_EDUC_INSTITUTION_SEQ.NEXTVAL,?,?,?,?)";
       // JOptionPane.showMessageDialog(null, HR_EDUC_INSTITUTION_SEQ.NEXTVAL);
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
             _ps.setString(1, instiutationName);
            _ps.setString(2, "Addis Ababa");
            _ps.setString(3, "TRAI");
            _ps.setString(4, "IN");
          //  System.out.println(_insert);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


//////////////////////////////////////////////////////////////////////////////////////////////

       public boolean insertLocationType(String LocationName)
                        {

        String _insert = "INSERT INTO HR_LU_EMP_ADDRESS " +
                "(ID,NAME)" +
                " VALUES (HR_LU_EMP_ADDRESS_SEQ.NEXTVAL,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, LocationName);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    //////////////////////////////////////////////////////////////////////////////

    public boolean insertLanguageType(String languageName) {
        String _insert = "INSERT INTO HR_LU_LANGUAGE " +
                "(LANGUAGE_CODE,DESCRIPTION)" +
                " VALUES (HR_LU_LANGUAGE_SEQ.NEXTVAL,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, languageName);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<LookUpEntity> readTitle() throws SQLException {
        String _select = "SELECT * FROM hr_lu_title ";
        ArrayList<LookUpEntity> title = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {

                this.titleCode = _rs.getString("title_id");
                this.titleDescription = _rs.getString("title_description");
                LookUpEntity titleEntity = new LookUpEntity(titleCode, titleDescription);
                title.add(titleEntity);

            }
            return title;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }

    }

    public ArrayList<HashMap> readTitleDesc() throws SQLException {
        String _select = "SELECT * FROM hr_lu_title ";
        ArrayList<HashMap> title = new ArrayList<HashMap>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("TITLE_ID", _rs.getString("TITLE_ID"));
                hm.put("TITLE_DESCRIPTION", _rs.getString("TITLE_DESCRIPTION"));
                hm.put("TYPE", _rs.getString("TYPE"));
                title.add(hm);

            }
            return title;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }

    }

    public String readTitleName(String titleID) {
        String _select = "SELECT TITLE_DESCRIPTION FROM hr_lu_title where title_id=?";
        String TITLE_DESCRIPTION;
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, titleID);
            _rs = (ResultSet) _ps.executeQuery();
            if (_rs.next()) {
                TITLE_DESCRIPTION = _rs.getString("TITLE_DESCRIPTION");
                return TITLE_DESCRIPTION;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<LookUpEntity> readJobRank() {

        String _select = "SELECT * FROM hr_lu_rank";
        ArrayList<LookUpEntity> title = new ArrayList<LookUpEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {

                this.titleCode = _rs.getString("rank_Id");
                this.titleDescription = _rs.getString("RANK_DESCRIPTION");
                LookUpEntity titleEntity = new LookUpEntity(titleCode, titleDescription);
                title.add(titleEntity);

            }
            return title;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String readRankOfJob(String jobCode) throws SQLException {
        String _select = "SELECT RANK_ID FROM HR_LU_JOB_TYPE where JOB_CODE=?";
        String _rankId = "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, jobCode);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                _rankId = _rs.getString("RANK_ID");
            }
            return _rankId;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String readGenderOfTitle(String title) throws SQLException {
        String _select = "SELECT TYPE FROM HR_LU_TITLE where TITLE_ID=?";
        String _gender = "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, title);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                _gender = _rs.getString("TYPE");
            }
            return _gender;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<LookUpEntity> readTitle(String type) {
        String _select = "SELECT * FROM hr_lu_title where type=?";
        ArrayList<LookUpEntity> title = new ArrayList<LookUpEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, type);
            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {

                this.titleCode = _rs.getString("title_id");
                this.titleDescription = _rs.getString("title_description");
                LookUpEntity titleEntity = new LookUpEntity(titleCode, titleDescription);
                title.add(titleEntity);

            }
            return title;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<LookUpEntity> readJobRank(String type) {

        String _select = "SELECT * FROM hr_lu_rank Where type=? ";
        ArrayList<LookUpEntity> title = new ArrayList<LookUpEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, type);
            _rs = (ResultSet) _ps.executeQuery();
            while (_rs.next()) {

                this.titleCode = _rs.getString("rank_Id");
                this.titleDescription = _rs.getString("RANK_DESCRIPTION");
                LookUpEntity titleEntity = new LookUpEntity(titleCode, titleDescription);
                title.add(titleEntity);

            }
            return title;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
//    public ArrayList<LookUpEntity> readJobRank(String type) {
//
//        String _select = "SELECT * FROM hr_lu_rank Where type=? ";
//        ArrayList<LookUpEntity> title = new ArrayList<LookUpEntity>();
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_select);
//            _ps.setString(1, type);
//            _rs = (ResultSet) _ps.executeQuery();
//            while (_rs.next()) {
//
//                this.titleCode = _rs.getString("rank_Id");
//                this.titleDescription = _rs.getString("RANK_DESCRIPTION");
//                LookUpEntity titleEntity = new LookUpEntity(titleCode, titleDescription);
//                title.add(titleEntity);
//
//            }
//            return title;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            return null;
//        }
//         finally{
//            try {
//                releaseResources();
//            } catch (SQLException ex) {
//                 ex.printStackTrace();
//            }
//         }
//    }

    public ArrayList<LookUpEntity> readAllRegion() {
        String _select = "SELECT * FROM hr_lu_region";
        ArrayList<LookUpEntity> regionList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                LookUpEntity regionType = new LookUpEntity(_rs.getString("region_Id"), _rs.getString("region_Name"));
                regionList.add(regionType);
            }
        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return regionList;
    }

    public ArrayList<LookUpEntity> readZoneOrCityInARegion(String regionId) {

        ArrayList<LookUpEntity> zoneOrCityList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_zone_or_city WHERE region_Id=?");
            _ps.setString(1, regionId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity zoneOrCityType = new LookUpEntity(_rs.getString("zone_Or_City_Id"), _rs.getString("zone_Or_City_Name"));
                zoneOrCityList.add(zoneOrCityType);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return zoneOrCityList;
    }

    public ArrayList<LookUpEntity> readKebelleInAWoredaOrSubCity(String woredaOrSubCityId) {

        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_woreda_or_sub_city where zone_Or_City_Id=?");
            _ps.setString(1, woredaOrSubCityId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("woreda_Or_SubCity_Id"), _rs.getString("woreda_Or_SubCity_Name"));
                kebelleList.add(KebelleType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ArrayList<LookUpEntity> readKebelleInSubCity(String subCity) {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_kebelle where woreda_Or_SubCity_Id=?");
            _ps.setString(1, subCity);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("kebelle_Id"), _rs.getString("kebelle_Name"));
                kebelleList.add(KebelleType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ArrayList<LookUpEntity> readEducationLevel() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM HR_LU_EDUC_LEVEL");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("EDUC_LEVEL_CODE"), _rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ResultSet readEducationLevelResultSet() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_educ_level");
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public ArrayList<LookUpEntity> readEducationTypes() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_educ_type ");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("educ_type_code"), _rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ArrayList<LookUpEntity> readLanguageType() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_language");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("language_Code"), _rs.getString("description"));
                kebelleList.add(KebelleType);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public String readRegionDescrption(String regionID) {
        String select = "select REGION_NAME FROM HR_LU_REGION where REGION_ID=?";
        String REGION_NAME = "not registered";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, regionID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                REGION_NAME = _rs.getString("REGION_NAME");
            }
            return REGION_NAME;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public String readZoneDescrption(String zoneID) {
        String select = "select * from hr_lu_zone_or_city WHERE  ZONE_OR_CITY_ID=?";
        String zone_OR_CITY_NAME = "not registered";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, zoneID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                zone_OR_CITY_NAME = _rs.getString("ZONE_OR_CITY_NAME");
            }
            return zone_OR_CITY_NAME;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String readWoredaDescrption(String zoneID) {
        String select = "select WOREDA_OR_SUBCITY_NAME FROM HR_LU_WOREDA_OR_SUB_CITY where WOREDA_OR_SUBCITY_ID=?";
        String woreda_name = "not registered";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, zoneID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                woreda_name = _rs.getString("WOREDA_OR_SUBCITY_NAME");
            }
            return woreda_name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public String readKebelleDescrption(String kebelleID) {
        String select = "select KEBELLE_NAME FROM HR_LU_KEBELLE where KEBELLE_ID=?";
        String keblle_Name = "not registered";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, kebelleID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                keblle_Name = _rs.getString("KEBELLE_NAME");
            }
            return keblle_Name;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<LookUpEntity> readEducationForJob() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            PreparedStatement zoneOrCityPs = _con.prepareStatement("SELECT * FROM hr_lu_educ_type");
            _rs = zoneOrCityPs.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("DESCRIPTION"), _rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
            }
            zoneOrCityPs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ArrayList<LookUpEntity> readEducationCategoryForJob(String category) {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        String _select = "";// = "SELECT * FROM hr_lu_educ_type";
        if ((category == null || category.equals("-1"))) {
            _select = "SELECT * FROM hr_lu_educ_type";
        } else {
            _select = "SELECT * FROM hr_lu_educ_type where category = '" + category + "'";
        }
        try {
            _con = getConnection();
            PreparedStatement zoneOrCityPs = _con.prepareStatement(_select);
            _rs = zoneOrCityPs.executeQuery();
            while (_rs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(_rs.getString("educ_type_code"), _rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
            }
            zoneOrCityPs.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return kebelleList;
    }

    public ResultSet selectEducationCategoryForJob(String category) {
        String _select = "";// = "SELECT * FROM hr_lu_educ_type";
        if ((category == null || category.equals("-1"))) {
            _select = "SELECT * FROM hr_lu_educ_type";
        } else {
            _select = "SELECT * FROM hr_lu_educ_type where category = '" + category + "'";
        }
        try {
            _con = getConnection();
            PreparedStatement zoneOrCityPs = _con.prepareStatement(_select);
            _rs = zoneOrCityPs.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }

    public ResultSet readEducationCataegories() throws SQLException {
        String _select = "SELECT DISTINCT CATEGORY_ID," +
                "  CATEGORY_NAME FROM HR_LU_EDUC_TYPE_CATEGORY";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<LookUpEntity> readEducationLevelMod() {
        ArrayList<LookUpEntity> kebelleList = new ArrayList<LookUpEntity>();
        try {
            _con = getConnection();
            PreparedStatement zoneOrCityPs = _con.prepareStatement("SELECT * FROM hr_lu_educ_level order by rank");
            _rs = zoneOrCityPs.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                LookUpEntity KebelleType = new LookUpEntity(ocrs.getString("EDUC_LEVEL_CODE") + "--" + ocrs.getString("DESCRIPTION"), ocrs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
            }
            return kebelleList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }
    }

    public ArrayList<HashMap> getAllPayGrade() throws Exception {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        String sql = "SELECT STEP_NO, " +
                "  SALARY, " +
                "  RANK_ID " +
                "FROM HR_LU_PAY_GRAD " +
                "ORDER BY to_number(RANK_ID), " +
                "  to_number(STEP_NO)";
        try {
            _ps = _con.prepareStatement(sql);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("rank", _rs.getString("RANK_ID"));
                hm.put("stepno", _rs.getString("STEP_NO"));
                hm.put("salary", _rs.getString("SALARY"));
                list.add(hm);
            }

            return list;
        } finally {
            releaseResources();
        }

    }
}
