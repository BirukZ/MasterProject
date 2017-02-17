/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

/**
 *
 * @author Dereje
 */
import connectionProvider.ConnectionManager;
import java.sql.*;
import java.sql.SQLException;
import manager.globalUseManager.ErrorLogWriter;

public class ContractEmployeeEntity extends ConnectionManager {

    int check;
    private String contractTermiDate;
    private String contractTermiRemark;
    private String contratId;
    private String employeeId;

    public String getContratId() {
        return contratId;
    }

    public void setContratId(String contratId) {
        this.contratId = contratId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getContractTermiDate() {
        return contractTermiDate;
    }

    public void setContractTermiDate(String contractTermiDate) {
        this.contractTermiDate = contractTermiDate;
    }

    public String getContractTermiRemark() {
        return contractTermiRemark;
    }

    public void setContractTermiRemark(String contractTermiRemark) {
        this.contractTermiRemark = contractTermiRemark;
    }

    public ContractEmployeeEntity(
            String contractTermiDate,
            String contractTermiRemark,
            String contratId,
            String employeeId) {
        this.contractTermiDate = contractTermiDate;
        this.contractTermiRemark = contractTermiRemark;
        this.contratId = contratId;
        this.employeeId = employeeId;
    }

    public ContractEmployeeEntity() {
    }

    /**
     * The method inserts contract employees contract agreement data into the hr_emp_contract
     * table.
     * @param emp_Id the uniques contract employee identifier
     * @param start_Date the contract start date
     * @param end_Date the contract ending date
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public boolean addContract(String emp_Id, String start_Date, String end_Date) throws SQLException {

        String insertContarat = "INSERT INTO hr_emp_contract(date_from, date_to, status, emp_id) " +
                "values(?,?,?,?)";
        Connection _con = getConnection();
        PreparedStatement ps;
        ps = _con.prepareStatement(insertContarat);
        ps.setString(1, start_Date);
        ps.setString(2, end_Date);
        ps.setString(3, "0");
        ps.setString(4, emp_Id);
        check = ps.executeUpdate();
        if (check == 1) {
            ps.close();

            return true;
        } else {
            ps.close();

            return false;
        }

    }

    /**
     * The method makes updates on contract employees contract agreement data in
     * the hr_emp_contract table.
     * @param emp_Id the uniques contract employee identifier
     * @param start_Date the contract start date
     * @param end_Date the contract ending date
     * @throws java.sql.SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public boolean updateContract(String emp_Id, String start_Date, String end_Date) throws SQLException {


        String updateContarat = ("UPDATE hr_emp_contract set date_from=?, " +
                "date_to=?, emp_id=?, status=? where emp_id=?");
        Connection _con = getConnection();
        PreparedStatement ps;
        ps = _con.prepareStatement(updateContarat);
        ps.setString(1, start_Date);
        ps.setString(2, end_Date);
        ps.setString(3, emp_Id);
        ps.setString(4, "1");
        ps.setString(5, emp_Id);
        check = ps.executeUpdate();
        if (check == 1) {
            ps.close();

            return true;
        } else {
            ps.close();

            return false;
        }
    }

    /**
     * This method acept as argument employeeID
     * then rade employee cantract agremmnt from  hr_emp_contract
     * table
     * @param employeeID
     * @return
     */
    public String[] readContractStatus(String employeeID) {

        Connection _conn;
        ResultSet rs;
        String[] _list;              // declares an array of String
        _list = new String[6];
        String select = "SELECT * FROM hr_emp_contract WHERE EMP_ID=?";
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            ps.setString(1, employeeID);
            rs = ps.executeQuery();
            if (rs.next()) {
                _list[0] = rs.getString("DATE_FROM");
                _list[1] = rs.getString("DATE_TO");
                _list[2] = rs.getString("STATUS");
                _list[3] = rs.getString("EMP_ID");
                _list[4] = rs.getString("CONTRACTID");
                _list[5] = rs.getString("TERMINATIONDATE");
            }
            rs.close();
            ps.close();

            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }
        return null;
    }

    public boolean saveEmployeeContractTermination(ContractEmployeeEntity contractEmployeeEntity) {
        try {
            String updateContarat = "UPDATE HR_EMP_CONTRACT " +
                    " SET TERMINATIONDATE=?, " +
                    "  TERMINATIONREMARK=? " +
                    " WHERE " +
                    "  CONTRACTID       =?";
            String strUpdateEmp = "UPDATE hr_employee_info set emp_Status='08' " +
                    "WHERE emp_Id=?";
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            PreparedStatement ps;
            PreparedStatement ps_update;
            ps = _con.prepareStatement(updateContarat);
            ps.setString(1, contractEmployeeEntity.getContractTermiDate());
            ps.setString(2, contractEmployeeEntity.getContractTermiRemark());
            ps.setString(3, contractEmployeeEntity.getContratId());
            if (ps.executeUpdate() > 0) {
                ps_update = _con.prepareStatement(strUpdateEmp);
                ps_update.setString(1, contractEmployeeEntity.getEmployeeId());
                if (ps_update.executeUpdate() > 0) {
                    _con.commit();
                    return true;

                } else {
                    _con.rollback();
                    return false;
                }
            } else {
                _con.rollback();
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
