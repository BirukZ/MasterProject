/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ExtendLeaveEntity extends connectionProvider.ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    PreparedStatement _prs = null;
    ResultSet _rs = null;

    public boolean extnedLeave(HashMap sickLeave, HashMap annualLeave) throws SQLException {
        try {
            String insetQuery = "INSERT INTO HR_EMP_LEAVE ( " +
                    " emp_Id, " +
                    " leave_Type, " +
                    " requested_From_Date," +
                    " requested_To_Date, " +
                    " requesting_Reason, " +
                    " requested_Date, " +
                    " STATUS," +
                    " LEAVE_DAYS" +
                    ")" +
                    " values(?,?,?,?,?,SYSDATE,'App-',?)";
            String updateQuery = "UPDATE HR_EMP_LEAVE " +
                    "SET REQUESTED_TO_DATE = ?, " +
                    "  RETURNDATE          = ? " +
                    "WHERE LEAVE_ID        = ?";
            _con = getConnection();
            _con.setAutoCommit(false);
            _ps = _con.prepareStatement(insetQuery);
            _ps.setString(1, sickLeave.get("employeeId").toString());
            _ps.setString(2, sickLeave.get("leaveType").toString());
            _ps.setString(3, sickLeave.get("fromDate").toString());
            _ps.setString(4, sickLeave.get("toDate").toString());
            _ps.setString(5, sickLeave.get("reason").toString());
            _ps.setString(6, sickLeave.get("leaveDays").toString());;
            if (_ps.executeUpdate() > 0) {
                _prs = _con.prepareStatement(updateQuery);
                _prs.setString(1, annualLeave.get("toDate").toString());
                _prs.setString(2, annualLeave.get("returnDate").toString());
                _prs.setString(3, annualLeave.get("leaveId").toString());
                if(_prs.executeUpdate()>0){
                    _con.commit();
                   return true;
                }else{
                     return false;
                }

            } else {
                return false;
            }



        } finally {
        }
    }
}
