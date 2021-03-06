/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author Administrator
 */
public class AssignEmployeeInLocationEntity extends ConnectionManager {

    public int deleteEmployeeFromLocation(String locationId) {
        String _delete = "DELETE FROM HR_EMP_LOCATION WHERE LOCATIONID ='" + locationId + "'";
        try {
            Connection _con = getConnection();
            PreparedStatement _ps = _con.prepareStatement(_delete);
            int rowAffected = _ps.executeUpdate();
            _ps.close();
            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public boolean saveEmployeeInLocation(String locationId, Set<HashMap> listOfEmployee) {
        try {
            String insert = "INSERT " +
                    "INTO HR_EMP_LOCATION " +
                    "  ( " +
                    "    EMP_ID, " +
                    "    LOCATIONID " +
                    "  ) " +
                    "  VALUES " +
                    "  ( " +
                    "    ?, " +
                    "    ? " +
                    "  )";
            boolean checkStatus = false;
            Connection con = null;
            con = getConnection();
            for (HashMap hm : listOfEmployee) {
                PreparedStatement ps = con.prepareStatement(insert);
                ps.setString(1, hm.get("employeeid").toString());
                ps.setString(2, locationId);

                if (ps.executeUpdate() <= 0) {
                    return false;

                }
                checkStatus = true;
            }
            if (checkStatus) {
                return true;

            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HashMap> listOFEmployeeNotAssign() {
        String query = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID NOT IN " +
                "  ( SELECT EMP_ID FROM HR_EMP_LOCATION " +
                "  ) ORDER BY FIRST_NAME" ;

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULL_NAME"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOFEmployee(String deprtmentId) {
        String query = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID NOT IN " +
                "  ( SELECT EMP_ID FROM HR_EMP_LOCATION " +
                "  ) " +
                "AND DEPARTMENT_ID='" + deprtmentId + "'";
        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULL_NAME"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOFEmployeeByLoCation(String locationId) {
        String query = "SELECT EMP.EMP_ID, " +
                "  EMP.EMP_STATUS, " +
                "  GR.EMPLOCATIONID, " +
                "  GR.LOCATIONID, " +
                "  EMP.FIRST_NAME " +
                "  || ' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO EMP, " +
                "  HR_EMP_LOCATION GR " +
                "WHERE EMP.EMP_ID =GR.EMP_ID " +
                "AND GR.LOCATIONID='" + locationId + "'";

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULL_NAME"));
                hm.put("EMPLOCATIONID", rs.getString("EMPLOCATIONID"));
                hm.put("EMP_STATUS", rs.getString("EMP_STATUS"));
                hm.put("LOCATIONID", rs.getString("LOCATIONID"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfLocation() {
        String query = "SELECT LOCATION_ID, ACTUAL_LOCATION FROM HR_LU_LOCATION";

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("LOCATION_ID", rs.getString("LOCATION_ID"));
                hm.put("ACTUAL_LOCATION", rs.getString("ACTUAL_LOCATION"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
