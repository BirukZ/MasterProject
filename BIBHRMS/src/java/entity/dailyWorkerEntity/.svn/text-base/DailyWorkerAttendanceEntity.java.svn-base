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
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class DailyWorkerAttendanceEntity extends ConnectionManager {

    private Connection conn;
    private PreparedStatement ps;
    private ResultSet rs;

    public boolean saveDailyworkerAttendance(ArrayList<HashMap> listOfDailyWork) throws Exception {
        int confmation[];
        String insertsSql = "INSERT " +
                "INTO HR_DAILYWORKER_ATTENDANCE " +
                "  ( " +
                "    DAILYWORKERID, " +
                "    ATTENDACEDATE, " +
                "    DAYVALUE, " +
                "    Status, " +
                "    REGISTERDATE," +
                "    REGISTEREMP_ID " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    'Req', " +
                "    CURRENT_TIMESTAMP," +
                "    ?" +
                "     " +
                "  )";
        try {
            conn = getConnection();
            conn.setAutoCommit(false);
            Savepoint sp = conn.setSavepoint("sp");
            ps = conn.prepareStatement(insertsSql);
            for (HashMap hm : listOfDailyWork) {
                ps.setString(1, hm.get("dailyWorkerId").toString());
                ps.setString(2, hm.get("attendaceDate").toString());
                ps.setString(3, hm.get("absentAmout").toString());
                ps.setString(4, hm.get("emp_id").toString());
                ps.addBatch();
            }
            confmation = ps.executeBatch();
            for (int i : confmation) {
                if (i == ps.EXECUTE_FAILED) {
                    conn.rollback(sp);
                    return false;
                }
            }
            conn.commit();
            return true;
        } finally {
        }
    }

    public ArrayList<HashMap> readrDailyWorkerAttendance(String attendanceTakenDate, String requestId) throws Exception {
        ArrayList<HashMap> listOfAbsent = new ArrayList<HashMap>();
        String qry = "SELECT Att.ID, " +
                "  Att.status, " +
                "  EI.FIRSTNAME " +
                "  || ' ' " +
                "  || EI.MIDDELNAME " +
                "  || ' ' " +
                "  || Ei.Lastname AS Fullname, " +
                "  Att.Dailyworkerid, " +
                "  Att.Dayvalue, " +
                "  ATTENDACEDATE " +
                "FROM Hr_Dailworker_Info Ei " +
                "INNER JOIN Hr_Dailyworker_Attendance Att " +
                "ON Att.Dailyworkerid   =Ei.Id " +
                "WHERE ATT.ATTENDACEDATE='" + attendanceTakenDate + "'";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(qry);
            //  ps.setString(1, attendanceTakenDate);
            //  ps.setString(2, requestId);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("absenceId", rs.getString("ID"));
                hm.put("ATTENDANCEAMOUNT", rs.getString("Fullname"));
                hm.put("Dailyworkerid", rs.getString("Dailyworkerid"));
                hm.put("Dailyworkerid", rs.getString("Dailyworkerid"));
                hm.put("FULLNAME", rs.getString("Fullname"));
                hm.put("STATUS", rs.getString("STATUS"));

                listOfAbsent.add(hm);
            }
            return listOfAbsent;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {

            releaseResources();

        }

    }

    public boolean deleteWorkerAttendance(String attendanceId) throws Exception {

        String qry = "Delete Hr_Dailyworker_Attendance WHERE  Att.ID=?";

        try {
            conn = getConnection();
            ps = conn.prepareStatement(qry);
              ps.setString(1, attendanceId);

            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
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
}
