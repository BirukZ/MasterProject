/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceEntity;

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
public class AttendanceCertifyEntity extends ConnectionManager {

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

    public boolean saveCertifyAttendanceRecord(ArrayList<HashMap> listOfAbsent,
            String reamark, String decisionerId, String decision, String month) throws Exception {
        boolean checkStatus = false;
        String updateStatusQuery = "UPDATE HR_ATTENDANCE_STATUS " +
                "SET Status      = ?, " +
                "  Certifydate   = CURRENT_TIMESTAMP, " +
                "  Certifyid     = ?, " +
                "  Certifyremark = ? " +
                " WHERE EMP_ID    = ? " +
                " AND MONTH       = ?";

        String updateQuery = "UPDATE HR_EMP_ATTENDANCE " +
                "SET STATUS = ? " +
                "WHERE ATTENDANCETAKENDATE BETWEEN " +
                "  (SELECT DATEFROM FROM Hr_Monthly_Absentdate WHERE MONTH='" + month + "' " +
                "  ) " +
                "AND (SELECT DATETO FROM Hr_Monthly_Absentdate WHERE MONTH='" + month + "') " +
                "AND EMP_ID = ?";
        con = getConnection();
        con.setAutoCommit(false);
        Savepoint atten = con.setSavepoint("attSavePoint");
        try {

            _ps = con.prepareStatement(updateStatusQuery);
            for (HashMap hm : listOfAbsent) {
                _ps.setString(1, decision);
                _ps.setString(2, decisionerId);
                _ps.setString(3, reamark);
                _ps.setString(4, hm.get("EMP_ID").toString());
                _ps.setString(5, month);  
                if (_ps.executeUpdate() <= 0) {
                    return false;
                }
                checkStatus = true;
            }
            if (checkStatus) {
                ps = con.prepareStatement(updateQuery);
                for (HashMap hm : listOfAbsent) {
                    ps.setString(1, decision);             
                    ps.setString(2, hm.get("EMP_ID").toString());
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
