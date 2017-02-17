/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeBonesEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class EmployeeBonesEntity extends ConnectionManager {

    private ResultSet rs = null;
    private PreparedStatement ps = null;
    private Connection con;

    public OracleCachedRowSet selectEmployeeYearlyBones(String location, String budgetYear) throws Exception {
        try {
            String sql = "SELECT Id, " +
                    "  Yr.Emp_Id       AS Employeeid, " +
                    "  Yr.Amountinbirr AS BONES , " +
                    "  Yr.Expriance    AS EXPERIENCE, " +
                    "  Yr.Salary       AS JUNESALARY, " +
                    "  Ei.First_Name " +
                    "  || ' ' " +
                    "  || Ei.Middle_Name " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS EMPLOYEEFULLNAME " +
                    "FROM Hr_Emp_Yearly_Bones YR " +
                    "INNER JOIN Hr_Bones_Request Br " +
                    "ON Yr.Bonesid=Br.Bonesid " +
                    "INNER JOIN Hr_Employee_Info Ei " +
                    "ON Yr.Emp_Id       =Ei.Emp_Id " +
                    "WHERE Br.Preparefor='" + location + "' " +
                    "AND Br.Year        ='" + budgetYear + "' " +
                    "AND YR.STATUS LIKE 'App%' ";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return ocrs;

        } finally {
        }
    }

    public OracleCachedRowSet selectEmployeeHolidayBones(String location, String budgetYear, String holidayName) throws Exception {
        try {
            String sql = "SELECT Hb.Emp_Id AS EMPLOYEEID, " +
                    "  Ei.First_Name " +
                    "  || ' ' " +
                    "  || Ei.Middle_Name " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS EMPLOYEEFULLNAME, " +
                    "  AMOUT           AS BONES " +
                    "FROM Hr_Holydaybones Ho " +
                    "INNER JOIN Hr_Holydaybones_Emp HB " +
                    "ON Ho.Holydaybonesid=HB.Holy_Id " +
                    "INNER JOIN Hr_Employee_Info Ei " +
                    "ON HB.EMP_ID=EI.EMP_ID";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return ocrs;

        } finally {
        }
    }
}
