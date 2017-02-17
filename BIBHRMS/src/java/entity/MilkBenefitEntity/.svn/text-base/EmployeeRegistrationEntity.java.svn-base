/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.MilkBenefitEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;

/**
 *
 * @author Admin
 */
public class EmployeeRegistrationEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }

    public ResultSet selectEmployeeStatu(String empId) throws SQLException {
        String _selectQuery = "SELECT EMP_STATUS FROM  HR_EMPLOYEE_INFO where EMP_ID='" + empId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllEmployees() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_MILKBENEFIT_EMPLOYEE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAtendanaceEmployees() throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_MILKBENEFIT_EMPLOYEE " +
                "WHERE emp_id NOT IN " +
                "  ( SELECT emp_id FROM HR_EMP_ATTENDANCE WHERE absentamount NOT LIKE '1' " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean insertBenefitTypes(ArrayList<EmployeeMilkModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_MILKBENEFIT_EMPLOYEE " +
                " (ID,EMP_ID,DEP_ID, REMARK)" +
                " VALUES(HR_MILK_SQ.NEXTVAL,?,?,?)";
        String delete = "DELETE FROM HR_MILKBENEFIT_EMPLOYEE " +
                " WHERE DEP_ID=? AND EMP_ID=? ";
        boolean check = false;
        _ps = null;
        PreparedStatement _psDelete = null;
        try {
            _con = getConnection();
            _psDelete = _con.prepareStatement(delete);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _psDelete.setInt(1, benefitLists.get(counter).getDeptId());
                _psDelete.setString(2, benefitLists.get(counter).getEmpId());
                _psDelete.executeUpdate();
            }
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
                _ps.setString(1, benefitLists.get(counter).getEmpId());
                _ps.setInt(2, benefitLists.get(counter).getDeptId());
                _ps.setString(3, benefitLists.get(counter).getRemark());

                if (_ps.executeUpdate() > 0) {
                    check = true;
                }
            }
            // _ps.close();
            // _con.close();
            return check;

        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateBenefitTypes(ArrayList<EmployeeMilkModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE  HR_MILKBENEFIT_EMPLOYEE " +
                " SET EMP_ID=?,DEP_ID=?, REMARK=? " +
                " WHERE ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getEmpId());
                _ps.setInt(2, benefitLists.get(counter).getDeptId());
                _ps.setString(3, benefitLists.get(counter).getRemark());
                _ps.setInt(4, benefitLists.get(counter).getBenefitID());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteBenefitTypes(ArrayList<EmployeeMilkModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_MILKBENEFIT_EMPLOYEE " +
                " where ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getBenefitID());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
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
                "WHERE DEPARTMENT_ID='" + deprtmentId + " '";

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

    public ArrayList<HashMap> listOFRegisteredEmployee(String deptId) {
        String query = "SELECT info.EMP_ID, " +
                "  info.FIRST_NAME " +
                "  ||' ' " +
                "  || info.MIDDLE_NAME " +
                "  ||' ' " +
                "  || info.LAST_NAME AS FULL_NAME,mil.remark,mil.id " +
                "FROM HR_MILKBENEFIT_EMPLOYEE mil " +
                "INNER JOIN hr_employee_info info " +
                "ON mil.emp_id   =info.emp_id " +
                "WHERE mil.dep_id='" + deptId + "'";

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
                hm.put("remark", rs.getString("remark"));
                hm.put("id", rs.getString("id"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
