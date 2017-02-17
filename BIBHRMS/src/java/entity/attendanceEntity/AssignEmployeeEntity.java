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
import java.util.Set;
import javax.faces.model.SelectItem;

/**
 *
 * @author Dereje
 */
public class AssignEmployeeEntity extends ConnectionManager {

    public ArrayList<HashMap> listOFEmployeeByLoCation(String bossId) {
        String query = "SELECT " +
                "  EMP.EMP_STATUS, " +
                "  GR.EMP_ID, " +
                "  GR.ID, " +
                "  GR.BOSSID, " +
                "  EMP.FIRST_NAME " +
                "  || ' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO EMP, " +
                "  HR_EMP_IMMEDIATE_BOSS GR " +
                "WHERE EMP.EMP_ID =GR.EMP_ID " +
                "AND GR.BOSSID='" + bossId + "'" +
                " order by EMP.FIRST_NAME " +
                "  || ' ' " +
                "  || EMP.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EMP.LAST_NAME ";

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
                hm.put("BOSSID", rs.getString("BOSSID"));
                hm.put("ID", rs.getString("ID"));
                hm.put("EMP_STATUS", rs.getString("EMP_STATUS"));
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
                "  ( SELECT EMP_ID FROM HR_EMP_IMMEDIATE_BOSS " +
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

    public ArrayList<SelectItem> getlistBoss() {
        String query = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID IN " +
                "  ( SELECT DISTINCT bossid FROM HR_EMP_IMMEDIATE_BOSS " +
                "  ) " +
                "ORDER BY FIRST_NAME";

        ArrayList<SelectItem> listofBos = new ArrayList<SelectItem>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                listofBos.add(new SelectItem(rs.getString("EMP_ID"),
                       rs.getString("FULL_NAME") ));

            }
            return listofBos;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOFEmployeeInDepartment(String deprtmentId) {
        String query = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO " +
                " where DEPARTMENT_ID='" + deprtmentId + "'" +
                " order by FIRST_NAME ";

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

    public boolean deleteEmployeeFromImmediateBoss(String bossId) {
        String _delete = "DELETE FROM HR_EMP_IMMEDIATE_BOSS WHERE BOSSID ='" + bossId + "'";
        try {
            Connection _con = getConnection();
            PreparedStatement _ps = _con.prepareStatement(_delete);
            int rowAffected = _ps.executeUpdate();
            _ps.close();
            if (rowAffected > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean saveEmployeeInBoss(String bossId, Set<HashMap> listOfEmployee) {
        try {
            String insert = "INSERT " +
                    "INTO HR_EMP_IMMEDIATE_BOSS " +
                    "  ( " +
                    "    ID,EMP_ID, " +
                    "    BOSSID " +
                    "  ) " +
                    "  VALUES " +
                    "  ( HR_EMP_IMMEDIATE_BOS.NEXTVAL," +
                    "    ?, " +
                    "    ? " +
                    "  )";
            boolean checkStatus = false;
            Connection con = null;
            con = getConnection();
            for (HashMap hm : listOfEmployee) {
                PreparedStatement ps = con.prepareStatement(insert);
                ps.setString(1, hm.get("employeeid").toString());
                ps.setString(2, bossId);

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
                "  ( SELECT EMP_ID FROM HR_EMP_IMMEDIATE_BOSS " +
                "  ) ORDER BY FIRST_NAME";

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
}
