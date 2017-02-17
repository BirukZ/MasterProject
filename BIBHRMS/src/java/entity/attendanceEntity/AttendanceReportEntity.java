/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class AttendanceReportEntity extends ConnectionManager {

    PreparedStatement ps = null;
    Connection con = null;
    ResultSet rs = null;

    public ArrayList<HashMap> listOfEmployeeonDepartment(int departemntId) throws Exception {
        String selectQuery = "SELECT Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Full_Name, " +
                "  Ei.Emp_Id, " +
                "  EI.OFFICE_OR_SHIFT, " +
                "  ei.department_id " +
                "FROM Hr_Employee_Info Ei " +
                "WHERE ei.department_id=" + departemntId + " " +
                "OR ei.department_id   =" + departemntId + " ";

        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        try {
            con = getConnection();
            ps = con.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("Full_Name", rs.getString("Full_Name"));
                hm.put("Emp_Id", rs.getString("Emp_Id"));
                hm.put("OFFICE_OR_SHIFT", rs.getString("OFFICE_OR_SHIFT"));

                listOfEmployee.add(hm);
            }
            return listOfEmployee;
        } finally {
        }


    }

    public ArrayList<HashMap> readEmployeeAndAbsent(String startDate, String endDate, int departemntId) throws Exception {

        ArrayList<HashMap> listOfAbsent = new ArrayList<HashMap>();
        String sql = "SELECT Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Full_Name, " +
                "  Ei.Emp_Id, " +
                "  Att.Absentamount, " +
                "  Att.Attendancetakendate, " +
                "  ATT.ABSENTTYPE " +
                "FROM HR_EMPLOYEE_INFO EI " +
                "INNER JOIN HR_EMP_ATTENDANCE ATT " +
                "ON Ei.Emp_Id=Att.Emp_Id " +
                "WHERE Attendancetakendate BETWEEN  '" + startDate + "' " +
                "AND '" + endDate + "'  " +
                " AND STATUS='CERTIFY' " +
                " AND Ei.department_id=" + departemntId + " " +
                "ORDER BY Att.Emp_Id";
        try {
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("Full_Name", rs.getString("Full_Name"));
                hm.put("Emp_Id", rs.getString("Emp_Id"));
                hm.put("Absentamount", rs.getString("Absentamount"));
                hm.put("AttendanceDate", rs.getString("Attendancetakendate"));
                hm.put("ABSENTTYPE", rs.getString("ABSENTTYPE"));
                listOfAbsent.add(hm);
            }

            return listOfAbsent;
        } finally {
        }





    }
}
