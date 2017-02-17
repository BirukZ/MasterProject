/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author thecode
 */
public class LeaveControlEntity extends ConnectionManager {

    public ArrayList<HashMap> selectEmployeeOnLeave() {
        String selectStatment = "SELECT DISTINCT EMP.EMP_ID, " +
                "  EMP.FIRST_NAME " +
                "  ||' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME AS FULLNAME , " +
                "  LEVE.REQUESTED_TO_DATE , " +
                "  LEVE.LEAVE_TYPE, " +
                "  LEVE.LEAVE_ID " +
                "FROM HR_EMPLOYEE_INFO EMP, " +
                "  HR_EMP_LEAVE LEVE " +
                "WHERE EMP.EMP_STATUS        ='02' " +
                "AND EMP.EMP_ID              =LEVE.EMP_ID " +
                "AND LEVE.REQUESTED_TO_DATE IN " +
                "  (SELECT request.REQUESTED_TO_DATE " +
                "  FROM " +
                "    (SELECT DISTINCT EMP_ID, " +
                "      MAX(REQUESTED_TO_DATE) AS REQUESTED_TO_DATE " +
                "    FROM hr_emp_leave " +
                "    GROUP BY EMP_ID " +
                "    ORDER BY emp_id " +
                "    )request " +
                "  ) " +
                "AND To_Date(Leve.Requested_To_Date,'YYYY-MM-DD') >= To_Date(TO_CHAR(Sysdate, 'YYYY-MM-DD'),'YYYY-MM-DD') " +
                "AND LEVE.LEAVE_TYPE                              <>'19' " +
                "AND ACTUALRETURNDATE                                   IS NULL " +
                "ORDER BY EMP.EMP_ID DESC  ";
        ArrayList<HashMap> employeeOnLeave = new ArrayList<HashMap>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("LEAVETYPE", ocrs.getString("LEAVE_TYPE"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                employeeOnLeave.add(hm);
            }
            return employeeOnLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public ArrayList<HashMap> employeeOnAnnualLeave() {
        String selectStatment = "SELECT DISTINCT EMP.EMP_ID, " +
                "  EMP.FIRST_NAME " +
                "  ||' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME AS FULLNAME , " +
                "  LEVE.REQUESTED_TO_DATE , " +
                "  LEVE.LEAVE_TYPE, " +
                "  LEVE.LEAVE_ID " +
                "FROM HR_EMPLOYEE_INFO EMP, " +
                "  HR_EMP_LEAVE LEVE " +
                "WHERE EMP.EMP_STATUS        ='02' " +
                "AND EMP.EMP_ID              =LEVE.EMP_ID " +
                "AND LEVE.REQUESTED_TO_DATE IN " +
                "  (SELECT request.REQUESTED_TO_DATE " +
                "  FROM " +
                "    (SELECT DISTINCT EMP_ID, " +
                "      MAX(REQUESTED_TO_DATE) AS REQUESTED_TO_DATE " +
                "    FROM hr_emp_leave " +
                "    GROUP BY EMP_ID " +
                "    ORDER BY emp_id " +
                "    )request " +
                "  ) " +
                "AND To_Date(Leve.Requested_To_Date,'YYYY-MM-DD') >= To_Date(TO_CHAR(Sysdate, 'YYYY-MM-DD'),'YYYY-MM-DD') " +
                "AND LEVE.LEAVE_TYPE                               ='5' " +
                "AND ACTUALRETURNDATE                             IS NULL";
        ArrayList<HashMap> employeeOnLeave = new ArrayList<HashMap>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("LEAVETYPE", ocrs.getString("LEAVE_TYPE"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                employeeOnLeave.add(hm);
            }
            return employeeOnLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public ArrayList<HashMap> selectEmployeeOnTwoHoursLeave() {
        String selectStatment = "SELECT DISTINCT EMP.EMP_ID, " +
                "  EMP.FIRST_NAME " +
                "  ||' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME AS FULLNAME , " +
                "  LEVE.REQUESTED_TO_DATE , " +
                "  LEVE.LEAVE_TYPE, " +
                "  LEVE.LEAVE_ID " +
                "FROM HR_EMPLOYEE_INFO EMP, " +
                "  HR_EMP_LEAVE LEVE " +
                "WHERE EMP.EMP_STATUS        ='02' " +
                "AND LEVE.LEAVE_TYPE         ='19' " +
                "AND ACTUALRETURNDATE             IS NULL " +
                "AND EMP.EMP_ID              =LEVE.EMP_ID " +
                "AND LEVE.REQUESTED_TO_DATE IN " +
                "  (SELECT request.REQUESTED_TO_DATE " +
                "  FROM " +
                "    (SELECT DISTINCT EMP_ID, " +
                "      MAX(REQUESTED_TO_DATE) AS REQUESTED_TO_DATE " +
                "    FROM hr_emp_leave " +
                "    GROUP BY EMP_ID " +
                "    ORDER BY emp_id " +
                "    )request " +
                "  ) " +
                "AND TO_DATE(LEVE.REQUESTED_TO_DATE,'YYYY-MM-DD') >= TO_DATE(TO_CHAR(sysdate, 'YYYY-MM-DD'),'YYYY-MM-DD') " +
                "ORDER BY EMP.EMP_ID DESC";






        ArrayList<HashMap> employeeOnLeave = new ArrayList<HashMap>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("LEAVETYPE", ocrs.getString("LEAVE_TYPE"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                employeeOnLeave.add(hm);
            }
            return employeeOnLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public ArrayList<HashMap> selectEmployeeNotReturnOnTimeFromLeave() {
        String selectStatment = "SELECT EMP.EMP_ID, " +
                "  EMP.FIRST_NAME " +
                "  ||' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || Emp.Last_Name AS Fullname, " +
                "  Request.Requested_To_Date, " +
                "  request.LEAVE_ID " +
                "FROM Hr_Employee_Info Emp, " +
                "  (SELECT Lev.Emp_Id, " +
                "    Lev.Requested_To_Date, " +
                "    HR_EMP_LEAVE.LEAVE_ID " +
                "  FROM " +
                "    (SELECT Emp_Id, " +
                "      REQUESTED_TO_DATE " +
                "    FROM " +
                "      (SELECT DISTINCT EMP_ID, " +
                "        MAX(Requested_To_Date) AS Requested_To_Date " +
                "      FROM hr_emp_leave " +
                "      WHERE To_Date(Requested_To_Date,'YYYY-MM-DD') < To_Date(TO_CHAR(Sysdate, 'YYYY-MM-DD'),'YYYY-MM-DD') " +
                "      AND LEAVE_TYPE                               <> '19' " +
                "      AND ACTUALRETURNDATE IS NULL " +
                "      GROUP BY Emp_Id " +
                "      ) " +
                "    )Lev, " +
                "    Hr_Emp_Leave " +
                "  WHERE Lev.Requested_To_Date=Hr_Emp_Leave.Requested_To_Date " +
                "  AND Lev.Emp_Id             =Hr_Emp_Leave.Emp_Id " +
                "  ORDER BY Lev.Emp_Id " +
                "  )request " +
                "WHERE Emp.Emp_Status ='02' " +
                "AND Emp.Emp_Id       =Request.Emp_Id " +
                "ORDER BY EMP.EMP_ID DESC";
        ArrayList<HashMap> employeeOnLeave = new ArrayList<HashMap>();
        try {
            Connection conn = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("employeeId", ocrs.getString("EMP_ID"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                employeeOnLeave.add(hm);
            }
            return employeeOnLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public int updateEmployeeStatus(String employeeId, String employeeStatus) {
        String _update = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + employeeStatus +
                "' WHERE EMP_ID='" + employeeId + "'";
        Connection _con = null;
        PreparedStatement _ps = null;
        int rowAffect = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }
}
