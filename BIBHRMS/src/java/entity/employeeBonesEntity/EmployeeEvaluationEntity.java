/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeBonesEntity;

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
public class EmployeeEvaluationEntity extends ConnectionManager {

    public ArrayList<HashMap> listOfEmployee(String deprtmentId) {
        String query = "SELECT EMP_ID, " +
                "  FIRST_NAME " +
                "  ||' ' " +
                "  || MIDDLE_NAME " +
                "  ||' ' " +
                "  || LAST_NAME AS FULL_NAME " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE " +
                " DEPARTMENT_ID='" + deprtmentId + "'" +
                " order by FULL_NAME";

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

    public ArrayList<HashMap> listofEmployeeEvaluation(String eaveluationDate, String evaluaterId) {

        String query = "SELECT EVA.ID, " +
                "  EVA.EMP_ID, " +
                "  EVA.EVALUATER_ID, " +
                "  EVA.RESULT, " +
                "  EVA.EVALUATIONDATE, " +
                "  nvl(EVA.REMARK,'Not Remark') AS REMARK, " +
                "  EVA.TIME_STAMP, " +
                "  EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME , " +
                "  EVA.EVALUATIONFROM, " +
                "  EVA.EVALUATIONTO " +
                " FROM HR_EMP_EVALUATION EVA, " +
                "  HR_EMPLOYEE_INFO EI " +
                " WHERE EVA.EMP_ID      =EI.EMP_ID " +
                " AND EVA.EVALUATER_ID=? " +
                " AND EVA.EVALUATIONDATE=? " +
                " order by  FULLNAME ";

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            ps.setString(1, evaluaterId);
            ps.setString(2, eaveluationDate);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULLNAME"));
                hm.put("ID", rs.getString("ID"));
                hm.put("EVALUATER_ID", rs.getString("EVALUATER_ID"));
                hm.put("RESULT", rs.getString("RESULT"));
                hm.put("EVALUATIONDATE", rs.getString("EVALUATIONDATE"));
                hm.put("REMARK", rs.getString("REMARK"));
                hm.put("TIME_STAMP", rs.getString("TIME_STAMP"));
                hm.put("EVALUATIONFROM", rs.getString("EVALUATIONFROM"));
                hm.put("EVALUATIONTO", rs.getString("EVALUATIONTO"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveEmployeeEvaluation(ArrayList<HashMap> listOfEmployee) {
        try {

            String insert = "INSERT " +
                    "INTO HR_EMP_EVALUATION " +
                    "  ( " +
                    "    EMP_ID, " +
                    "    EVALUATER_ID, " +
                    "    RESULT, " +
                    "    EVALUATIONDATE, " +
                    "    REMARK," +
                    "    EVALUATIONFROM," +
                    "    EVALUATIONTO," +
                    "    TIME_STAMP " +
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
                    "    CURRENT_TIMESTAMP " +
                    "  )";



            boolean checkStatus = false;
            Connection con = null;
            con = getConnection();
            con.setAutoCommit(false);
            Savepoint spt = con.setSavepoint("svpt");
            PreparedStatement ps = null;

            ps = con.prepareStatement(insert);
            for (HashMap hm : listOfEmployee) {

                ps.setString(1, hm.get("employeeId").toString());
                ps.setString(2, hm.get("evaluaterId").toString());
                ps.setString(3, hm.get("result").toString());
                ps.setString(4, hm.get("evaluationDate").toString());
                ps.setString(5, hm.get("remark").toString());
                ps.setString(6, hm.get("evaluationFrom").toString());
                ps.setString(7, hm.get("evaluationTO").toString());
                ps.addBatch();
            }
            int get[] = ps.executeBatch();
            for (int i : get) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    con.rollback(spt);
                    return false;
                }
                checkStatus = true;
            }
            if (checkStatus) {
                con.commit();
                return true;

            } else {
                con.rollback(spt);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployeeEvaluation(ArrayList<HashMap> listofEval) {
        try {
            String insert = "UPDATE HR_EMP_EVALUATION " +
                    " SET RESULT = ? , REMARK = ? " +
                    " WHERE ID = ?";


            boolean checkStatus = false;
            Connection con = null;
            con = getConnection();
            con.setAutoCommit(false);
            Savepoint spt = con.setSavepoint("svpt");
            PreparedStatement ps = null;

            ps = con.prepareStatement(insert);
            for (HashMap hm : listofEval) {
                ps.setString(1, hm.get("result").toString());
                ps.setString(2, hm.get("remark").toString());
                ps.setString(3, hm.get("evaid").toString());
                ps.addBatch();
            }
            int get[] = ps.executeBatch();
            for (int i : get) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    con.rollback(spt);
                    return false;
                }
                checkStatus = true;
            }
            if (checkStatus) {
                con.commit();
                return true;

            } else {
                con.rollback(spt);
                return false;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }






















    }

    public boolean deleteEmployeeEvaluation(ArrayList<HashMap> lsitOf) {
        try {
            String query = "  ";
            int i = 0;
            for (HashMap hm : lsitOf) {
                if (i == 0) {
                    query += " ID = " + hm.get("evaid");
                } else {
                    query += " OR ID = " + hm.get("evaid");
                }
                i++;
            }
            String deleteQuery = "DELETE FROM HR_EMP_EVALUATION WHERE " + query + "";
            Connection con = null;
            con = getConnection();
            PreparedStatement ps = null;
            ps = con.prepareStatement(deleteQuery);
            if (ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HashMap> listofEvaluationDate(String evaluaterId) {
        String query = "SELECT DISTINCT EVALUATIONDATE " +
                " FROM HR_EMP_EVALUATION WHERE EVALUATER_ID='" + evaluaterId + "'";
        ArrayList<HashMap> listofEval = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EVALUATIONDATE", rs.getString("EVALUATIONDATE"));
                listofEval.add(hm);
            }
            return listofEval;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
