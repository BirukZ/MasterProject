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
public class DailyWorkerAttendanceApproveEntity extends ConnectionManager{
    PreparedStatement ps = null;
    PreparedStatement _ps = null;
    ResultSet rs = null;
    Connection con;

    public ArrayList<HashMap> getListOfApproveAbsent(String month) throws Exception {
        ArrayList<HashMap> listApproveAbsent = new ArrayList<HashMap>();
        String selectQuery = "SELECT Ei.emp_id, " +
                "  Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Full_Name, " +
                "  Attt.Absent_Amount, " +
                "  Attt.Absenttype " +
                "FROM Hr_Employee_Info Ei " +
                "INNER JOIN " +
                "  (SELECT Att.Emp_Id, " +
                "    SUM( " +
                "    CASE " +
                "      WHEN Absentamount='1/2' " +
                "      THEN " +
                "        (SELECT 0.5 FROM Dual " +
                "        ) " +
                "      ELSE To_Number(Absentamount) " +
                "    END ) Absent_Amount, " +
                "    Absenttype " +
                "  FROM Hr_Emp_Attendance Att " +
                "  WHERE Status='App' " +
                "  AND ATTENDANCETAKENDATE BETWEEN " +
                "    (SELECT DATEFROM FROM Hr_Monthly_Absentdate WHERE MONTH='" + month + "' " +
                "    ) " +
                "  AND (SELECT DATETO FROM Hr_Monthly_Absentdate WHERE MONTH='" + month + "') " +
                "  GROUP BY Att.Emp_Id, " +
                "    Absenttype " +
                "  )Attt " +
                "ON Ei.Emp_Id =Attt.Emp_Id";
        try {
            con = getConnection();
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("Full_Name", rs.getString("Full_Name"));
                hm.put("Absent_Amount", rs.getString("Absent_Amount"));
                hm.put("Absenttype", rs.getString("Absenttype"));
                hm.put("EmployeeId", rs.getString("emp_id"));
                hm.put("Month", month);
                listApproveAbsent.add(hm);
            }
            return listApproveAbsent;
        } finally {
            releaseResources();
        }
    }
       public ArrayList<HashMap> readrDailyWorkerAttendance(String attendanceTakenDate, String requestId)throws Exception {
        ArrayList<HashMap> listOfAbsent = new ArrayList<HashMap>();
        String qry = "SELECT EI.ID, " +
                "  EI.FIRSTNAME " +
                "  || ' ' " +
                "  || EI.MIDDELNAME " +
                "  || ' ' " +
                "  || Ei.Lastname AS Fullname, " +
                "  Att.Dailyworkerid, " +
                "  ATT.Totalworkinghour " +
                "FROM Hr_Dailworker_Info Ei " +
                "INNER JOIN " +
                "  (SELECT SUM(Dayvalue) AS Totalworkinghour, " +
                "    DAILYWORKERID " +
                "  FROM Hr_Dailyworker_Attendance Ate " +
                "  WHERE Status='Req' " +
                "  AND Attendacedate BETWEEN " +
                "    (SELECT DATEFROM FROM Hr_Monthly_Absentdate WHERE MONTH='JANUARY' " +
                "    ) " +
                "  AND (SELECT Dateto FROM Hr_Monthly_Absentdate WHERE MONTH='JANUARY') " +
                "  GROUP BY DAILYWORKERID " +
                "  )ATT " +
                "ON Att.Dailyworkerid =Ei.Id " +
                "ORDER BY Att.Dailyworkerid";

        try {
            con = getConnection();
            ps = con.prepareStatement(qry);
            ps.setString(1, attendanceTakenDate);
            ps.setString(2, requestId);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("absenceId", rs.getString("ID"));
                hm.put("ATTENDANCEAMOUNT", rs.getString("Totalworkinghour"));
                hm.put("Dailyworkerid", rs.getString("Dailyworkerid"));
                hm.put("FULLNAME", rs.getString("Fullname"));
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

    public void releaseResources() throws SQLException {
        if (rs != null) {
            rs.close();
        }
        if (ps != null) {
            ps.close();
        }
        if (con != null) {
            closePooledConnections(con);
        }
    }
}
