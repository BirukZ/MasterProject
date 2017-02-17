/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dailyWorkerEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class DailyWorkerEntity extends ConnectionManager {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean saveRequritementType(HashMap list) throws Exception {
        String sql = "INSERT " +
                "INTO HR_DAILYWORKER_REQURI_TYPE " +
                "  ( " +
                "    DEPATEMNT, " +
                "    JOBPOSTION, " +
                "    STARTDATE, " +
                "    ENDDATE, " +
                "    DAILYPAYMENT, " +
                "    REMARK " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, list.get("departemnt").toString());
            ps.setString(2, list.get("job").toString());
            ps.setString(3, list.get("startDate").toString());
            ps.setString(4, list.get("endDate").toString());
            ps.setString(5, list.get("dailyPayment").toString());
            ps.setString(6, list.get("description").toString());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            releaseResources();
        }
    }

    public boolean saveDailyWorkerInformation(ArrayList<HashMap> listOfDailyWorker) throws Exception {
        String sql = "INSERT " +
                "INTO HR_DAILWORKER_INFO " +
                "  ( " +
                "    FIRSTNAME, " +
                "    MIDDELNAME, " +
                "    LASTNAMEC, " +
                "    REGISTRATIONDATE, " +
                "    GENDER, " +
                "    REGION, " +
                "    Woreda, " +
                "    HOUSENUMBER, " +
                "    ZONEORCITY, " +
                "    KEBELE, " +
                "    REQUID " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        try {



            conn = getConnection();
            ps = conn.prepareStatement(sql);
            for (HashMap list : listOfDailyWorker) {
                ps.setString(1, list.get("firstName").toString());
                ps.setString(2, list.get("middleName").toString());
                ps.setString(3, list.get("lastName").toString());
                ps.setString(4, list.get("registrationDate").toString());
                ps.setString(5, list.get("gender").toString());
                ps.setString(6, list.get("region").toString());
                ps.setString(7, list.get("woredaorSubCity").toString());
                ps.setString(8, list.get("houseNumber").toString());
                ps.setString(9, list.get("zoneorCity").toString());
                ps.setString(10, list.get("kebele").toString());
                ps.setString(11, list.get("jobId").toString());
                ps.addBatch();
            }
            int confirmation[] = ps.executeBatch();
            for (int i : confirmation) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    return false;
                }
            }
            return true;


        } finally {
            releaseResources();
        }
    }

    public boolean updateDailyWorkerInformation(HashMap list) throws Exception {
        String sql = "UPDATE Hr_Dailworker_Info " +
                "SET Title_Id       = ?, " +
                "  FIRSTNAME        = ?, " +
                "  MIDDELNAME       = ?, " +
                "  LASTNAMEC        = ?, " +
                "  REGISTRATIONDATE = ?, " +
                "  GENDER           = ?, " +
                "  REGION           = ?, " +
                "  WOREDA           = ?, " +
                "  HOUSENUMBER      = ?, " +
                "  ZONEORCITY       = ?, " +
                "  Kebele           = ?, " +
                "  Requid           =? " +
                "WHERE ID           = ?";
        try {



            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, list.get("titleId").toString());
            ps.setString(2, list.get("firstName").toString());
            ps.setString(3, list.get("middleName").toString());
            ps.setString(4, list.get("lastName").toString());
            ps.setString(5, list.get("registrationDate").toString());
            ps.setString(6, list.get("gender").toString());
            ps.setString(7, list.get("region").toString());
            ps.setString(8, list.get("woredaorSubCity").toString());
            ps.setString(9, list.get("houseNumber").toString());
            ps.setString(10, list.get("zoneorCity").toString());
            ps.setString(11, list.get("kebele").toString());
            ps.setString(12, list.get("jobId").toString());
            ps.setString(13, list.get("dilyWorkerId").toString());

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }



        } finally {
            releaseResources();
        }
    }

    public boolean deleteDailyWorkerInformation(String dailyWorkerId) throws Exception {
        String sql = "DELETE FROM Hr_Dailworker_Info WHERE ID = ?";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, dailyWorkerId);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            releaseResources();
        }
    }

    public boolean updateRequritementType(HashMap list) throws Exception {
        String sql = "";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, list.get("").toString());
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> listOfRequrment() throws Exception {
        ArrayList<HashMap> listOfJob = new ArrayList<HashMap>();
        String sql = "SELECT dt.ID, " +
                "  dt.DEPATEMNT, " +
                "  dt.JOBPOSTION, " +
                "  dt.STARTDATE, " +
                "  dt.ENDDATE, " +
                "  dt.DAILYPAYMENT, " +
                "  dt.REMARK, " +
                "  jt.job_description " +
                "FROM Hr_Dailyworker_Requri_Type dt " +
                "INNER JOIN hr_lu_job_type jt " +
                "ON dt.jobpostion=to_number(jt.job_code)";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("ID", rs.getString("ID"));
                hm.put("JOBPOSTION", rs.getString("JOBPOSTION"));
                hm.put("STARTDATE", rs.getString("STARTDATE"));
                hm.put("ENDDATE", rs.getString("ENDDATE"));
                hm.put("job_description", rs.getString("job_description"));

                listOfJob.add(hm);
            }
            return listOfJob;

        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> listOfDailyWorker(String jobId) throws Exception {
        ArrayList<HashMap> dailyWorkerList = new ArrayList<HashMap>();
        String sql = "SELECT DISTINCT Id," +
                "  FIRSTNAME," +
                "  Middelname," +
                "  LASTNAME," +
                "  FIRSTNAME " +
                "  ||' ' " +
                "  || Middelname " +
                "  ||' ' " +
                "  || LASTNAME AS fullname, " +
                "  REGISTRATIONDATE, " +
                "  Gender, " +
                "  NVL(Region,'Not Register')                                           AS Region, " +
                "  NVL(Woreda,'Not Register')                                           AS Woreda, " +
                "  NVL(Housenumber,'Not Register')                                      AS Housenumber, " +
                "  NVL(Zoneorcity,'Not Register')                                       AS Zoneorcity, " +
                "  NVL(Kebele,'Not Register')                                           AS KEBELLE, " +
                "  NVL(Hr_Lu_Kebelle.KEBELLE_NAME,'Not Register')                       AS KEBELLE_NAME, " +
                "  NVL( Hr_Lu_Region.Region_Name,'Not Register')                        AS Region_Name, " +
                "  NVL( Hr_Lu_Woreda_Or_Sub_City.Woreda_Or_Subcity_Name,'Not Register') AS Woreda_Or_Subcity_Name, " +
                "  NVL( Hr_Lu_Zone_Or_City.Zone_Or_City_Name,'Not Register')            AS Zone_Or_City_Name, " +
                "  Requid " +
                "FROM Hr_Dailworker_Info " +
                "LEFT JOIN Hr_Lu_Zone_Or_City " +
                "ON Hr_Dailworker_Info.Zoneorcity=Hr_Lu_Zone_Or_City.REGION_ID " +
                "LEFT JOIN Hr_Lu_Woreda_Or_Sub_City " +
                "ON Hr_Dailworker_Info.Woreda=Hr_Lu_Woreda_Or_Sub_City.ZONE_OR_CITY_ID " +
                "LEFT JOIN Hr_Lu_Region " +
                "ON Hr_Dailworker_Info.Region = Hr_Lu_Region.Region_Id " +
                "LEFT JOIN Hr_Lu_Kebelle " +
                "ON hr_dailworker_info.kebele=Hr_Lu_Kebelle.KEBELLE_ID";
   

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("ID", rs.getString("ID"));
                hm.put("FULLNAME", rs.getString("fullname"));
                hm.put("FIRSTNAME", rs.getString("FIRSTNAME"));
                hm.put("Middelname", rs.getString("Middelname"));
                hm.put("LASTNAME", rs.getString("LASTNAME"));
                hm.put("REGISTRATIONDATE", rs.getString("REGISTRATIONDATE"));
                hm.put("Region", rs.getString("Region"));
                hm.put("Region_Name", rs.getString("Region_Name"));
                hm.put("Woreda", rs.getString("Woreda"));
                hm.put("Woreda_Or_Subcity_Name", rs.getString("Woreda_Or_Subcity_Name"));
                hm.put("Zoneorcity", rs.getString("Zoneorcity"));
                hm.put("Kebele", rs.getString("KEBELLE"));
                hm.put("Housenumber", rs.getString("Housenumber"));
                hm.put("GENDER", rs.getString("GENDER"));
                hm.put("Zone_Or_City_Name", rs.getString("Zone_Or_City_Name"));
                hm.put("KEBELLE_NAME", rs.getString("KEBELLE_NAME"));
                dailyWorkerList.add(hm);
            }
            return dailyWorkerList;

        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> listOfDailyWorkerforAttendance(String jobId) throws Exception {
        ArrayList<HashMap> dailyWorkerList = new ArrayList<HashMap>();
        String sql = "SELECT DISTINCT Id, " +
                "  FIRSTNAME, " +
                "  Middelname, " +
                "  LASTNAME, " +
                "  FIRSTNAME " +
                "  ||' ' " +
                "  || Middelname " +
                "  ||' ' " +
                "  || LASTNAME AS fullname, " +
                "  REGISTRATIONDATE, " +
                "  Gender " +
                "FROM Hr_Dailworker_Info";
    

        try {
            conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("ID", rs.getString("ID"));
                hm.put("FULLNAME", rs.getString("fullname"));         
                dailyWorkerList.add(hm);
            }
            return dailyWorkerList;

        } finally {
            releaseResources();
        }
    }

    public void releaseResources() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (conn != null) {
            closePooledConnections(conn);
        }
    }

    public static void main(String arg[]) {
        DailyWorkerEntity obj = new DailyWorkerEntity();
        try {
            obj.listOfDailyWorker(null);
        } catch (Exception e) {
        }

    }
}
