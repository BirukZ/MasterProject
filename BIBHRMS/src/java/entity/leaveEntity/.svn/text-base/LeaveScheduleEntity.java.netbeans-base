/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class LeaveScheduleEntity extends ConnectionManager {

    public boolean saveLeaveSchduleEmployee(ArrayList<HashMap> listOfEmployeeSchedule) {
        String sql = "INSERT " +
                "INTO HR_LEAVE_EMP_SCHEDULE " +
                "  ( " +
                "    SCGEDULE_ID, " +
                "    MONTH, " +
                "    EMP_ID, " +
                "    REMARK," +
                "    DAYS," +
                "    LEAVEYEAR, " +
                "    SCHEDULEDATE" +
                "     " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?," +
                "    ?, " +
                "    ?, " +
                "    (SELECT TO_CHAR(sysdate,'YYYY-MM-DD') AS today FROM dual " +
                "    ) " +
                "  )";
        String delete = "DELETE FROM HR_LEAVE_EMP_SCHEDULE " +
                " WHERE SCGEDULE_ID=? AND EMP_ID=? ";
        boolean check = false;
        PreparedStatement _ps = null;
        PreparedStatement _psDelete = null;
        try {
            Connection _con = getConnection();
            _psDelete = _con.prepareStatement(delete);
            for (HashMap hm : listOfEmployeeSchedule) {
                _psDelete.setString(1, hm.get("year").toString());
                _psDelete.setString(2, hm.get("employeeId").toString());
                _psDelete.executeUpdate();
            }
            for (HashMap hm : listOfEmployeeSchedule) {
                _ps = _con.prepareStatement(sql);
                _ps.setString(1, hm.get("year").toString());
                _ps.setString(2, hm.get("month").toString());
                _ps.setString(3, hm.get("employeeId").toString());
                _ps.setString(4, hm.get("remark").toString());
                _ps.setString(5, hm.get("days").toString());
                _ps.setString(6, hm.get("leaveYear").toString());


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

    public boolean deleteLeaveSchduleEmployee(String employeeId, String year) {
        String delete = "DELETE FROM HR_LEAVE_EMP_SCHEDULE " +
                " WHERE SCGEDULE_ID=? AND EMP_ID=? ";
        PreparedStatement _ps = null;
        PreparedStatement _psDelete = null;
        try {
            Connection _con = getConnection();
            _psDelete = _con.prepareStatement(delete);
            _psDelete.setString(1, year);
            _psDelete.setString(2, employeeId);
            if (_psDelete.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        // _ps.close();
        // _con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<HashMap> listOfEmployeeLeaveBalance(String year) throws SQLException, SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAAME, " +
                "  LB.ID , " +
                "  LB.EMP_ID , " +
                "  LB.YEAR , " +
                "  LB.LEAVEAMOUNT , " +
                "  LB.STATUS , " +
                "  LB.USEDLEAVE," +
                "  LB.ACCUM_LEAVE," +
                "  LB.EXP_LEAVE " +
                "FROM HR_EMP_LEAVE_BANK LB, " +
                "  HR_EMPLOYEE_INFO EI " +
                "WHERE LB.EMP_ID           =EI.EMP_ID " +
                "AND TO_NUMBER(LEAVEAMOUNT)>TO_NUMBER(USEDLEAVE)" +
                "AND YEAR > '" + year + "' order by  LB.EMP_ID";
        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("leaveBlanceId", rs.getString("ID"));
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("physicalYear", rs.getString("YEAR"));
            hm.put("ACCUM_LEAVE", rs.getString("ACCUM_LEAVE"));
            hm.put("leaveAmount", rs.getString("LEAVEAMOUNT"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("EXP_LEAVE", rs.getString("EXP_LEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            listOfEmployeeLeave.add(hm);
        }

        return listOfEmployeeLeave;
    }

    public ArrayList<HashMap> listOfEmployeeLeaveBalanceDirectorate(String depId, String year) throws SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAAME, " +
                "  LB.ID , " +
                "  LB.EMP_ID ,       " +
                "  LB.YEAR ,         " +
                "  LB.LEAVEAMOUNT ,  " +
                "  LB.USEDLEAVE,     " +
                "  LB.ACCUM_LEAVE,   " +
                "  LB.EXP_LEAVE,     " +
                "  LE.MONTH,         " +
                "  LE.SCGEDULE_ID,   " +
                "  LE.STATUS ,       " +
                "  nvl(LE.REMARK, ' ') REMARK        " +
                " FROM HR_EMP_LEAVE_BANK LB            " +
                " INNER JOIN HR_LEAVE_SCHEDULE LS       " +
                " ON LB.YEAR=LS.YEAR                   " +
                " INNER JOIN HR_LEAVE_EMP_SCHEDULE LE   " +
                " ON LS.ID=LE.SCGEDULE_ID AND LB.EMP_ID=LE.EMP_ID   " +
                " INNER join HR_EMPLOYEE_INFO EI " +
                " On LB.EMP_ID   =EI.EMP_ID " +
                " INNER JOIN TBL_DEPARTMENT DEP" +
                " ON EI.DEPARTMENT_ID=DEP.DEPARTMENT_ID " +
                " where  " +
                " TO_NUMBER(LEAVEAMOUNT)>TO_NUMBER(USEDLEAVE)" +
                " AND DEP.DEPARTMENT_ID='" + depId + "' OR DEP.BRANCH_ID='" + depId + "'" +
                " AND LB.YEAR > '" + year + "' order by  LB.EMP_ID";
        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("leaveBlanceId", rs.getString("SCGEDULE_ID"));
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("physicalYear", rs.getString("YEAR"));
            hm.put("ACCUM_LEAVE", rs.getString("ACCUM_LEAVE"));
            hm.put("leaveAmount", rs.getString("LEAVEAMOUNT"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("EXP_LEAVE", rs.getString("EXP_LEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            hm.put("MONTH", rs.getString("MONTH"));
            hm.put("REMARK", rs.getString("REMARK"));
            hm.put("STATUS", rs.getString("STATUS"));
            listOfEmployeeLeave.add(hm);
        }

        return listOfEmployeeLeave;
    }

    public HashMap listOfEmployeeLeaveBalance(String empId, String year) {
        HashMap listOfEmployeeLeave = new HashMap();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = " SELECT    LS.ID SCHID, " +
                "           LB.LEAVEAMOUNT ,  " +
                "           LB.USEDLEAVE,     " +
                "           LB.ACCUM_LEAVE ,  " +
                "           LB.EXP_LEAVE,     " +
                "           LS.END_DATE,      " +
                "           LS.START_DATE,    " +
                "           LE.MONTH,         " +
                "           LE.REMARK         " +
                "           FROM HR_EMP_LEAVE_BANK LB            " +
                "           LEFT JOIN HR_LEAVE_SCHEDULE LS      " +
                "           ON LB.YEAR=LS.YEAR                   " +
                "           LEFT JOIN HR_LEAVE_EMP_SCHEDULE LE   " +
                "           ON LS.ID=LE.SCGEDULE_ID              " +
                "           AND LB.EMP_ID=LE.EMP_ID              " +
                "           WHERE TO_NUMBER(LEAVEAMOUNT)>TO_NUMBER(USEDLEAVE)     " +
                "           AND LB.EMP_ID  ='" + empId + "'     " +
                "           AND LB.YEAR ='" + year + "'      ";
        try {
            Connection _con = getConnection();
            ps = _con.prepareStatement(sql);
            rs = ps.executeQuery();
            if (rs.next()) {
                listOfEmployeeLeave.put("MONTH", rs.getString("MONTH"));
                listOfEmployeeLeave.put("REMARK", rs.getString("REMARK"));
                listOfEmployeeLeave.put("leaveAmount", rs.getString("LEAVEAMOUNT"));
                listOfEmployeeLeave.put("USEDLEAVE", rs.getString("USEDLEAVE"));
                listOfEmployeeLeave.put("leaveSchId", rs.getString("SCHID"));
                listOfEmployeeLeave.put("EXP_LEAVE", rs.getString("EXP_LEAVE"));
                listOfEmployeeLeave.put("ACCUM_LEAVE", rs.getString("ACCUM_LEAVE"));
                listOfEmployeeLeave.put("START_DATE", rs.getString("START_DATE"));
                listOfEmployeeLeave.put("END_DATE", rs.getString("END_DATE"));
            }
        } catch (SQLException ex) {
        }
        return listOfEmployeeLeave;
    }

    public ArrayList<HashMap> listOfemployeeLeaveSecadule(String employeeId) {
        ArrayList<HashMap> listOfSecadule = new ArrayList<HashMap>();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT SCGEDULE_ID, " +
                "  MONTH, " +
                "  NVL(REMARK,'not register') AS REMARK, " +
                "  NVL(days,'not register') AS days, " +
                "  NVL(LEAVEYEAR,'not register') AS LEAVEYEAR, " +
                "  ID " +
                "FROM HR_LEAVE_EMP_SCHEDULE " +
                "WHERE EMP_ID     ='" + employeeId + "' " +
                "AND SCHEDULEDATE = " +
                "  (SELECT MAX(SCHEDULEDATE) FROM HR_LEAVE_EMP_SCHEDULE WHERE EMP_ID ='" + employeeId + "' " +
                "  )";

        try {
            String list[] = null;
            String day[] = null;
            int index = 0;
            Connection _con = getConnection();
            ps = _con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                index = rs.getString("MONTH").indexOf(",");
                if (index > 0) {
                    list = rs.getString("MONTH").toString().split(",");
                    day= rs.getString("days").toString().split(",");

                    for (int i = 0; i < list.length; i++) {
                        HashMap hm = new HashMap();
                        hm.put("SCGEDULEYEAR", rs.getString("SCGEDULE_ID"));
                        hm.put("MONTH", list[i]);
                        hm.put("REMARK", rs.getString("REMARK"));
                        hm.put("ID", rs.getString("ID"));
                        hm.put("days",day[i]);
                        hm.put("LEAVEYEAR", rs.getString("LEAVEYEAR"));
                        listOfSecadule.add(hm);
                    }

                } else {
                    HashMap hm = new HashMap();
                    hm.put("SCGEDULEYEAR", rs.getString("SCGEDULE_ID"));
                    hm.put("MONTH", rs.getString("MONTH"));
                    hm.put("REMARK", rs.getString("REMARK"));
                    hm.put("ID", rs.getString("ID"));
                    hm.put("days", rs.getString("days"));
                    hm.put("LEAVEYEAR", rs.getString("LEAVEYEAR"));
                    listOfSecadule.add(hm);
                }

            }
            return listOfSecadule;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
