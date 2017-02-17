/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class AttendanceApproveEntity extends ConnectionManager {

    private PreparedStatement ps;
    private PreparedStatement _ps;
    private ResultSet rs;
    private Connection con;

    public ArrayList<HashMap> getListOfAbset(String bossId, String month) throws Exception {
        String selectQuery = "SELECT Ei.emp_id, " +
                "  Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Full_Name, " +
                "  Attt.Absent_Amount, " +
                "  leavetypedescription(Attt.Absenttype) AS Absenttype " +
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
                "  WHERE Status='Req' " +
                "  AND ATTENDANCETAKENDATE BETWEEN " +
                "    (SELECT DATEFROM FROM Hr_Monthly_Absentdate WHERE MONTH='"+month+"' " +
                "    ) " +
                "  AND (SELECT DATETO FROM Hr_Monthly_Absentdate WHERE MONTH='"+month+"') " +
                "  GROUP BY Att.Emp_Id, " +
                "    Absenttype " +
                "  )Attt " +
                "ON Ei.Emp_Id     =Attt.Emp_Id " +
                "WHERE Ei.Emp_id IN " +
                "  (SELECT EMP_ID " +
                "  FROM HR_EMP_IMMEDIATE_BOSS " +
                "    START WITH Bossid      ='GZ/00296' " +
                "    CONNECT BY prior EMP_ID=BOSSID) ";
        ArrayList<HashMap> listOfAbset = new ArrayList<HashMap>();
        try {
            con = getConnection();
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("Full_Name", rs.getString("Full_Name"));
                hm.put("Absent_Amount", rs.getString("Absent_Amount"));
                hm.put("Absenttype", rs.getString("Absenttype"));
                hm.put("emp_id", rs.getString("emp_id"));
                hm.put("month", month);

                listOfAbset.add(hm);
            }
            return listOfAbset;
        } finally {
        }
    }

    public boolean saveApproveAttendanceRecord(ArrayList<HashMap> listOfAbsent,
            String reamark, String decisionerId, String decision) throws Exception {
        boolean checkStatus = false;
        String insertQuery = "INSERT " +
                "INTO HR_ATTENDANCE_STATUS " +
                "  ( " +
                "    APRPOVEDATE, " +
                "    EMP_ID, " +
                "    STATUS, " +
                "    MONTH, " +
                "    APPROVERID, " +
                "    APPROVERREMARK " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    CURRENT_TIMESTAMP, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?" +
                "  )";

        String updateQuery = "UPDATE HR_EMP_ATTENDANCE " +
                "SET STATUS = 'App' " +
                "WHERE ATTENDANCETAKENDATE BETWEEN " +
                "  (SELECT DATEFROM FROM Hr_Monthly_Absentdate WHERE MONTH='JANUARY' " +
                "  ) " +
                "AND (SELECT DATETO FROM Hr_Monthly_Absentdate WHERE MONTH='JANUARY') " +
                "AND EMP_ID = ?";
        con = getConnection();
        con.setAutoCommit(false);
        Savepoint atten = con.setSavepoint();


        try {
            _ps = con.prepareStatement(updateQuery);
            for (HashMap hm : listOfAbsent) {
                _ps.setString(1, hm.get("EMP_ID").toString());
                if (_ps.executeUpdate() <= 0) {
                    return false;
                }
                checkStatus = true;
            }
            if (checkStatus) {
                ps = con.prepareStatement(insertQuery);
                for (HashMap hm : listOfAbsent) {
                    ps.setString(1, hm.get("EMP_ID").toString());
                    ps.setString(2, decision);
                    ps.setString(3, hm.get("month").toString());
                    ps.setString(4, decisionerId);
                    ps.setString(5, reamark);
                    if (ps.executeUpdate() <= 0) {
                        con.rollback(atten);
                        return false;
                    }
                    checkStatus = true;
                }
                if (checkStatus) {
                    con.commit();
                    return true;
                } else {
                    con.rollback(atten);
                    return false;
                }
            } else {
                con.rollback(atten);
                return false;
            }

        } finally {
        }
    }
}
