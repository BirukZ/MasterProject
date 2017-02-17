/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import fphrms.Leave.BalancePage.EmoloyeeList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravZulu
 */
public class LeaveBalanceEntity extends ConnectionManager {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public LeaveBalanceEntity() {
    }

  

    public boolean saveLeaveBalanceForExpiranceLessThanOne(String employeeIDExpLessOne, int currentYear, float totalasofToday, int flag) {
        String sql =
                " INSERT INTO " +
                " HR_EMP_LEAVE_BANK ( " +
                " LEAVEAMOUNT , " +
                " EMP_ID, " +
                " YEAR," +
                " USEDLEAVE,FLAG ) VALUES(?,?,?,?,?)";

        int checkSave;
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            _ps.setFloat(1, totalasofToday);
            _ps.setString(2, employeeIDExpLessOne);
            _ps.setInt(3, currentYear);
            _ps.setString(4, "0");
            _ps.setInt(5, flag);

            checkSave = _ps.executeUpdate();
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean saveLeaveBalanceForNewYear(String empID, float newLeaAmount, int yearshoudbe) {
        String sql =
                " INSERT INTO " +
                " HR_EMP_LEAVE_BANK ( " +
                " LEAVEAMOUNT , " +
                " EMP_ID, " +
                " YEAR," +
                " USEDLEAVE ) VALUES(?,?,?,?)";

        int checkSave;
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            _ps.setFloat(1, newLeaAmount);
            _ps.setString(2, empID);
            _ps.setInt(3, yearshoudbe);
            _ps.setString(4, "0");
            checkSave = _ps.executeUpdate();
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean saveLeaveBalanceINBank(ArrayList<HashMap> leaveBalance) {
        String sql =
                "INSERT INTO " +
                " HR_EMP_LEAVE_BANK ( " +
                " LEAVEAMOUNT , " +
                " EMP_ID  , " +
                " YEAR," +
                " USEDLEAVE ) VALUES(?,?,?,?)";

        int checkSave[] = new int[leaveBalance.size()];
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            for (HashMap hm : leaveBalance) {
                _ps.setString(1, hm.get("leaveAmount").toString());
                _ps.setString(2, hm.get("employeeId").toString());
                _ps.setString(3, hm.get("physicalYear").toString());
                _ps.setString(4, hm.get("usedLeaveAmount").toString());
                checkSave[i] = _ps.executeUpdate();
                i++;
            }
            checkSave = _ps.executeBatch();
            for (int n : checkSave) {
                if (n <= 0) {
                    check = false;
                }
            }
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean saveLeaveBalanceNewTransfer(ArrayList<HashMap> leaveBalance) {
        String sql =
                "UPDATE " +
                " HR_EMP_LEAVE_BANK " +
                "SET LEAVEAMOUNT=? , " +
                "  YEARLYGIVEN  =? " +
                "WHERE EMP_ID   =? " +
                "AND YEAR       =?";

        int checkSave[] = new int[leaveBalance.size()];
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            for (HashMap hm : leaveBalance) {
                _ps.setString(1, hm.get("leaveAmount").toString());
                _ps.setString(2, hm.get("yearlyGiven").toString());
                _ps.setString(3, hm.get("employeeId").toString());
                _ps.setString(4, hm.get("physicalYear").toString());
                checkSave[i] = _ps.executeUpdate();
                i++;
            }
            checkSave = _ps.executeBatch();
            for (int n : checkSave) {
                if (n <= 0) {
                    check = false;
                }
            }
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean prepareLeaveAsofToday(String empID, float totalBalanceasofToday, float asTotalEntitlement) {
        String currentDate = currentDate = dateFormat.format(new Date());
        String sql =
                " INSERT INTO " +
                " HR_LEAVE_BALANCE_AS_OF_DAY ( " +
                " EMP_ID , " +
                " AS_OF_BALANCE, " +
                " AS_OF_DATE,AS_OF_ENTITLMENT)" +
                " VALUES(?,?,?,?)";

        int checkSave;
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            _ps.setString(1, empID);
            _ps.setFloat(2, totalBalanceasofToday);
            _ps.setString(3, currentDate);
            _ps.setFloat(4, asTotalEntitlement);
            checkSave = _ps.executeUpdate();
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean updateLeaveBalanceForExpiranceLessThanOne(String employeeIDExpLessOne, int currentYear, float totalasofToday, int flag) {
        String sql =
                "UPDATE " +
                " HR_EMP_LEAVE_BANK " +
                "SET LEAVEAMOUNT=? , " +
                "  YEARLYGIVEN  =? " +
                "WHERE EMP_ID   =? " +
                "AND FLAG       ='1'";

        // int checkSave[] = new int[leaveBalance.size()];
        boolean check = true;
        PreparedStatement _ps = null;
        int checkSave = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);

            _ps.setFloat(1, totalasofToday);
            _ps.setInt(2, currentYear);
            _ps.setString(3, employeeIDExpLessOne);
            // _ps.setString(4, hm.get("physicalYear").toString());
            _ps.executeUpdate();
            checkSave = _ps.executeUpdate();

            if (checkSave == 1) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean updateLeaveBalanceNewTransfer(ArrayList<HashMap> leaveBalance) {
        String sql = "UPDATE HR_EMP_LEAVE_BANK " +
                "  SET " +
                "    EMP_ID=?, " +
                "    YEAR=?, " +
                "    LEAVEAMOUNT=?, " +
                "    USEDLEAVE=?," +
                "    STATUS=? " +
                "  WHERE ID=? ";
        String sql2 = "UPDATE HR_RESERVE_LEAVE " +
                "SET " +
                "  EMP_ID              =?, " +
                "  LEAVEYEAR           =?, " +
                "  AVAILABLELEAVENUMBER=?, " +
                "  USEDLEAVE           =?, " +
                "  STATUS              =? " +
                "WHERE RESERVELAVEID   =? ";
        int checkSave[] = new int[leaveBalance.size()];
        boolean check = true;
        PreparedStatement _ps = null;
        String leaveSatus = "UNUSED";
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");

            for (HashMap hm : leaveBalance) {
                if (hm.get("isFromReserveLeave").toString().equals("NO")) {
                    _ps = _con.prepareStatement(sql);
                    if (Float.parseFloat(hm.get("usedLeaveAmount").toString()) ==
                            Float.parseFloat(hm.get("leaveAmount").toString())) {
                        leaveSatus = "USED";
                    } else {
                        leaveSatus = "UNUSED";
                    }
                    _ps.setString(1, hm.get("employeeId").toString());
                    _ps.setString(2, hm.get("physicalYear").toString());
                    _ps.setString(3, hm.get("leaveAmount").toString());
                    _ps.setString(4, hm.get("usedLeaveAmount").toString());
                    _ps.setString(5, leaveSatus);
                    _ps.setString(6, hm.get("balanceId").toString());
                    checkSave[i] = _ps.executeUpdate();
                    i++;
                } else {
                    _ps = _con.prepareStatement(sql2);
                    if (Integer.parseInt(hm.get("usedLeaveAmount").toString()) ==
                            Integer.parseInt(hm.get("leaveAmount").toString())) {
                        leaveSatus = "USED";
                    } else {
                        leaveSatus = "UNUSED";
                    }
                    _ps.setString(1, hm.get("employeeId").toString());
                    _ps.setString(2, hm.get("physicalYear").toString());
                    _ps.setString(3, hm.get("leaveAmount").toString());
                    _ps.setString(4, hm.get("usedLeaveAmount").toString());
                    _ps.setString(5, leaveSatus);
                    _ps.setString(6, hm.get("balanceId").toString());
                    checkSave[i] = _ps.executeUpdate();
                    i++;
                }

            }


            checkSave = _ps.executeBatch();
            for (int n : checkSave) {
                if (n <= 0) {
                    check = false;
                }
            }
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public ArrayList<HashMap> listOfEmployeeLeaveBalance(String year) throws SQLException {
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
                "  LB.USEDLEAVE " +
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
            hm.put("leaveAmount", rs.getString("LEAVEAMOUNT"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            listOfEmployeeLeave.add(hm);
        }
        return listOfEmployeeLeave;
    }

    public ArrayList<HashMap> listOfEmployeeFromReserveLeave(String year) throws SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAAME, " +
                "  LB.RESERVELAVEID , " +
                "  LB.EMP_ID , " +
                "  LB.LEAVEYEAR , " +
                "  LB.AVAILABLELEAVENUMBER , " +
                "  LB.STATUS , " +
                "  LB.USEDLEAVE " +
                "FROM HR_RESERVE_LEAVE LB, " +
                "  HR_EMPLOYEE_INFO EI " +
                "WHERE LB.EMP_ID                    =EI.EMP_ID " +
                "AND TO_NUMBER(AVAILABLELEAVENUMBER)>TO_NUMBER(USEDLEAVE) " +
                "ORDER BY LB.EMP_ID";
        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("leaveBlanceId", rs.getString("RESERVELAVEID"));
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("physicalYear", rs.getString("LEAVEYEAR"));
            hm.put("leaveAmount", rs.getString("AVAILABLELEAVENUMBER"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            listOfEmployeeLeave.add(hm);
        }
        return listOfEmployeeLeave;
    }

    public ArrayList<HashMap> listOfEmployeeLeaveBalance(String year, String employeeID) throws SQLException {
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
                "  LB.USEDLEAVE " +
                "FROM HR_EMP_LEAVE_BANK LB, " +
                "  HR_EMPLOYEE_INFO EI " +
                "WHERE LB.EMP_ID           =EI.EMP_ID " +
                "AND TO_NUMBER(LEAVEAMOUNT)>TO_NUMBER(USEDLEAVE)" +
                //  "AND YEAR < = '" + year + "' " +
                "AND LB.EMP_ID  = '" + employeeID + "'   order by  LB.EMP_ID";
        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("leaveBlanceId", rs.getString("ID"));
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("physicalYear", rs.getString("YEAR"));
            hm.put("leaveAmount", rs.getString("LEAVEAMOUNT"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            listOfEmployeeLeave.add(hm);
        }
        return listOfEmployeeLeave;
    }

    public ArrayList<HashMap> listOfEmployeeFromReserveLeave(String year, String employeeID) throws SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAAME, " +
                "  LB.RESERVELAVEID , " +
                "  LB.EMP_ID , " +
                "  LB.LEAVEYEAR , " +
                "  LB.AVAILABLELEAVENUMBER , " +
                "  LB.STATUS , " +
                "  LB.USEDLEAVE " +
                "FROM HR_RESERVE_LEAVE LB, " +
                "  HR_EMPLOYEE_INFO EI " +
                "WHERE LB.EMP_ID                    =EI.EMP_ID " +
                "AND TO_NUMBER(AVAILABLELEAVENUMBER)>TO_NUMBER(USEDLEAVE) " +
                "AND LB.EMP_ID  = '" + employeeID + "'" +
                "ORDER BY LB.EMP_ID";
        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("leaveBlanceId", rs.getString("RESERVELAVEID"));
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("physicalYear", rs.getString("LEAVEYEAR"));
            hm.put("leaveAmount", rs.getString("AVAILABLELEAVENUMBER"));
            hm.put("USEDLEAVE", rs.getString("USEDLEAVE"));
            hm.put("FULLNAAME", rs.getString("FULLNAAME"));
            listOfEmployeeLeave.add(hm);
        }
        return listOfEmployeeLeave;
    }

    public boolean deleteEmployeeLeaveBalance(String leaveBalanceId) {
        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            String sql = "DELETE HR_EMP_LEAVE_BANK WHERE ID=? ";
            ps = conn.prepareStatement(sql);
            ps.setString(1, leaveBalanceId);
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

    public boolean ClearAsOfToDayTable() {
        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            String sql = "delete from HR_LEAVE_BALANCE_AS_OF_DAY";
            ps = conn.prepareStatement(sql);

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

    /**
     * used to read Avileble employee anual leave
     * @param employeeId
     * @param year
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<HashMap> readEmployeeAvaileAnualLeave(String employeeId,
            String year) throws Exception {

        String sql = "SELECT LEAVEAMOUNT, " +
                "  USEDLEAVE, " +
                "  YEAR, " +
                "  ID, " +
                "  NVL(USEDLEAVEBYHOURE,'0') AS USEDLEAVEBYHOURE " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE emp_id             ='" + employeeId + "'" +
                "AND YEAR                <=  '" + year + "'   " +
                "AND TO_NUMBER(usedleave) < TO_NUMBER(leaveamount) " +
                "ORDER BY YEAR";



        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            ArrayList<HashMap> listOfAnualLeave = new ArrayList<HashMap>();
            float availeLeave = 0.0f;
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("leaveamount", ocrs.getString("leaveamount"));
                hm.put("id", ocrs.getString("id"));
                hm.put("year", ocrs.getString("year"));
                hm.put("usedleave", ocrs.getString("usedleave"));
                availeLeave = Float.parseFloat(ocrs.getString("leaveamount")) -
                        (Float.parseFloat(ocrs.getString("usedleave")) +
                        Float.parseFloat(ocrs.getString("USEDLEAVEBYHOURE")));
                hm.put("availeLeave", Float.toString(availeLeave));
                listOfAnualLeave.add(hm);
            }
            return listOfAnualLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ResultSet CheackEmployeeLeaveStatus(String employeeIDExpLessOne) {
        String sql = " Select flag from HR_EMP_LEAVE_BANK where emp_id=? ";

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeIDExpLessOne);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


      public ResultSet getEmployeeStatus(String selectedId) {
         String sql = " select emp_status from hr_employee_info where emp_id=? ";

        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, selectedId);
            rs = ps.executeQuery();
            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet SelectEmployeeHireDate() {
        String currentDate = currentDate = dateFormat.format(new Date());

        String sql = "SELECT exp.EMP_ID, " +
                "  exp.HIRE_DATE, " +
                "  CC.BALANCE, " +
                "  EE.totalEntitlement " +
                "FROM " +
                "  (SELECT EMP_ID, " +
                "    HIRE_DATE, " +
                "    TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE,1,4)                                    AS expirance, " +
                "    MONTHS_BETWEEN(TO_DATE(?,'YYYY-MM-DD'),TO_DATE(HR_EMPLOYEE_INFO.HIRE_DATE, 'yyyy-MM-DD')) AS MONTHDIFF " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  ) exp , " +
                "  (SELECT emp_id FROM HR_EMPLOYEE_INFO " +
                "  )bb, " +
                "  (SELECT EMP_ID, " +
                "    SUM(LEAVEAMOUNT)-SUM(USEDLEAVE) AS BALANCE " +
                "  FROM HR_EMP_LEAVE_BANK " +
                "  WHERE EMP_ID IN " +
                "    (SELECT emp_id FROM hr_emp_leave_bank " +
                "    ) " +
                "  GROUP BY EMP_ID " +
                "  )CC, " +
                "  (SELECT EMP_ID, " +
                "    SUM(LEAVEAMOUNT)AS totalEntitlement " +
                "  FROM HR_EMP_LEAVE_BANK " +
                "  WHERE EMP_ID IN " +
                "    (SELECT emp_id FROM hr_emp_leave_bank " +
                "    ) " +
                "  GROUP BY EMP_ID " +
                "  )EE " +
                "WHERE MONTHDIFF >='12' " +
                "AND exp.EMP_ID   =bb.emp_id " +
                "AND exp.EMP_ID   =CC.EMP_ID " +
                "AND EXP.EMP_ID   =EE.EMP_ID " +
                "AND exp.emp_id  IN " +
                "  (SELECT emp_id FROM hr_emp_leave_bank " +
                "  )";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, currentDate);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            return ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet SelectEmployeeHireDateForLessThanOneYear() {
        String currentDate = currentDate = dateFormat.format(new Date());

        String sql = "SELECT exp.EMP_ID, " +
                "  exp.HIRE_DATE, " +
                "  CC.BALANCE, " +
                "  EE.totalEntitlement " +
                "FROM " +
                "  (SELECT EMP_ID, " +
                "    HIRE_DATE, " +
                "    TO_CHAR(SYSDATE, 'YYYY') - SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE,1,4)                         AS expirance, " +
                "    MONTHS_BETWEEN(TO_DATE(?,'YYYY-MM-DD'),TO_DATE(HR_EMPLOYEE_INFO.HIRE_DATE, 'yyyy-MM-DD')) AS MONTHDIFF " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  ) exp , " +
                "  (SELECT emp_id FROM HR_EMPLOYEE_INFO " +
                "  )bb, " +
                "  (SELECT EMP_ID, " +
                "    SUM(LEAVEAMOUNT)-SUM(USEDLEAVE) AS BALANCE " +
                "  FROM HR_EMP_LEAVE_BANK " +
                "  WHERE EMP_ID IN " +
                "    (SELECT emp_id FROM hr_emp_leave_bank " +
                "    ) " +
                "  GROUP BY EMP_ID " +
                "  )CC, " +
                "  (SELECT EMP_ID, " +
                "    SUM(LEAVEAMOUNT)AS totalEntitlement " +
                "  FROM HR_EMP_LEAVE_BANK " +
                "  WHERE EMP_ID IN " +
                "    (SELECT emp_id FROM hr_emp_leave_bank " +
                "    ) " +
                "  GROUP BY EMP_ID " +
                "  )EE " +
                "WHERE MONTHDIFF <='12' " +
                "AND exp.EMP_ID   =bb.emp_id " +
                "AND exp.EMP_ID   =CC.EMP_ID " +
                "AND EXP.EMP_ID   =EE.EMP_ID " +
                "AND exp.emp_id  IN " +
                "  (SELECT emp_id FROM hr_emp_leave_bank " +
                "  )";
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, currentDate);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            return ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public float readEmployeeLeaveBalance(String employeeId, String year, float totalYear, float workedDay) {

        String sql = "SELECT LEAVEAMOUNT, " +
                "  USEDLEAVE, " +
                "  YEAR, " +
                "  ID, " +
                "  NVL(USEDLEAVEBYHOURE,'0') AS USEDLEAVEBYHOURE " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE EMP_ID              =? " +
                "AND YEAR                 >= '" + year + "' " +
                "AND TO_NUMBER(USEDLEAVE) < TO_NUMBER(LEAVEAMOUNT) " +
                "ORDER BY YEAR";

        int yearCal = Integer.parseInt(year);
        yearCal += 1;

        float leaveBalnce = 0;
        float leaveAmout = 0;
        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                if (rs.getString("YEAR").equals(Integer.toString(yearCal))) {
                    leaveAmout = (Float.parseFloat(rs.getString("leaveamount")) * workedDay) / totalYear;
                    leaveAmout -= (Float.parseFloat(rs.getString("usedleave")) +
                            Float.parseFloat(rs.getString("USEDLEAVEBYHOURE")));
                    leaveBalnce += leaveAmout;
                } else {
                    leaveBalnce += (Float.parseFloat(rs.getString("leaveamount")) -
                            (Float.parseFloat(rs.getString("usedleave")) +
                            Float.parseFloat(rs.getString("USEDLEAVEBYHOURE"))));
                }

            }
            return leaveBalnce;

        } catch (Exception e) {
            e.printStackTrace();
            return leaveBalnce;
        }
    }

    public float readEmployeeLeaveBalance(String employeeId, String year) {

//JOptionPane.showMessageDialog(null, year+"LeaveBalnaceGezachew");
//        String sql = "SELECT LEAVEAMOUNT, " +
//                "  USEDLEAVE, " +
//                "  YEAR, " +
//                "  ID, " +
//                "  NVL(USEDLEAVEBYHOURE,'0') AS USEDLEAVEBYHOURE " +
//                "FROM HR_EMP_LEAVE_BANK " +
//                "WHERE EMP_ID              =? " +
//                "AND YEAR                 >= '" + year + "' " +
//                "AND TO_NUMBER(USEDLEAVE) < TO_NUMBER(LEAVEAMOUNT) " +
//                "ORDER BY YEAR";

        String sql = "SELECT SUM(LEAVEAMOUNT)-SUM(USEDLEAVE) AS BALANCE " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE EMP_ID =?";

        int yearCal = Integer.parseInt(year);
        yearCal += 1;

        float leaveBalnce = 0;
        float leaveAmout = 0;
        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            while (rs.next()) {
//
//                leaveBalnce += (Float.parseFloat(rs.getString("leaveamount")) -
//                        (Float.parseFloat(rs.getString("usedleave"))
//                        ));
                leaveBalnce = rs.getFloat("BALANCE");


            }

            return leaveBalnce;

        } catch (Exception e) {
            e.printStackTrace();
            return leaveBalnce;
        }
    }

    public ArrayList<HashMap> readEmployeeAnnualLeaveBalance(String employeeId, String year) {
        ArrayList<HashMap> listOfAnnualLeave = new ArrayList<HashMap>();
        String sql = "SELECT LEAVEAMOUNT, " +
                "  USEDLEAVE, " +
                "  YEAR, " +
                "  ID, " +
                "  (TO_NUMBER(LEAVEAMOUNT) - TO_NUMBER(USEDLEAVE)) AS AVAILABLELEAVEAMOUNT " +
                "FROM hr_emp_leave_bank " +
                "WHERE emp_id             =? " +
                "AND YEAR                >= '" + year + "' " +
                "AND TO_NUMBER(USEDLEAVE) < TO_NUMBER(leaveamount) " +
                "ORDER BY YEAR";


        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("YEAR", rs.getString("YEAR"));
                hm.put("AVAILABLELEAVEAMOUNT", rs.getString("AVAILABLELEAVEAMOUNT"));
                listOfAnnualLeave.add(hm);
            }
            return listOfAnnualLeave;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean isRegisterThisYear(String leaveYear, String employeeId) throws Exception {
        String sql = "SELECT * " +
                " FROM hr_emp_leave_bank " +
                " WHERE emp_id             ='" + employeeId + "' " +
                " AND YEAR                = '" + leaveYear + "' ";
        PreparedStatement ps = null;
        Connection conn = getConnection();
        ResultSet rs = null;
        ps = conn.prepareStatement(sql);
        // ps.setString(1, employeeId);
        rs = ps.executeQuery();
        if (rs.next()) {
            return false;
        } else {
            return true;
        }
    }

    public float readEmployeeLeaveBalanceAvilebelInTheYear(String employeeId, String year) {

        String sql = "SELECT leaveamount, " +
                "  usedleave, " +
                "  YEAR, " +
                "  id " +
                " FROM hr_emp_leave_bank " +
                " WHERE emp_id             ='" + employeeId + "' " +
                " AND YEAR                = '" + year + "' " +
                " AND TO_NUMBER(usedleave) < TO_NUMBER(leaveamount) " +
                " ORDER BY YEAR";


        float leaveBalnce = 0;
        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            // ps.setString(1, employeeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                leaveBalnce = (Float.parseFloat(rs.getString("leaveamount")) -
                        Float.parseFloat(rs.getString("usedleave")));
                return leaveBalnce;
            } else {
                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<HashMap> listOfEmployee(String year) throws SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EMP_ID, " +
                "  HIRE_DATE, " +
                "  LEAVESTARTFROM " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE UPPER(EMP_ID) NOT IN " +
                "(SELECT EMP_ID FROM HR_EMP_LEAVE_BANK WHERE YEAR =" + year + ") " +
                "  ORDER BY EMP_ID ";

        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("hireDate", rs.getString("HIRE_DATE"));
            hm.put("startLeaveFrom", rs.getString("LEAVESTARTFROM"));
            listOfEmployeeLeave.add(hm);
        }

        return listOfEmployeeLeave;
    }

    /**
     * employee have remaining  unregister leave amount 
     * @param year
     * @return
     * @throws java.sql.SQLException
     */
    public ArrayList<HashMap> listOfEmpRem(String year) throws SQLException {
        ArrayList<HashMap> listOfEmployeeLeave = new ArrayList<HashMap>();
        Connection _con = getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "SELECT EI.EMP_ID, " +
                "  EI.HIRE_DATE, " +
                "  EI.LEAVESTARTFROM, " +
                "  LEAVEAMOUNT " +
                "FROM HR_EMPLOYEE_INFO EI, " +
                "  HR_EMP_LEAVE_BANK LB " +
                "WHERE EI.EMP_ID=LB.EMP_ID " +
                "AND YEAR        ='" + year + "'" +
                "AND YEARLYGIVEN='notall' " +
                "ORDER BY EMP_ID";











        ps = _con.prepareStatement(sql);
        rs = ps.executeQuery();
        while (rs.next()) {
            HashMap hm = new HashMap();
            hm.put("employeeId", rs.getString("EMP_ID"));
            hm.put("hireDate", rs.getString("HIRE_DATE"));
            hm.put("startLeaveFrom", rs.getString("LEAVESTARTFROM"));
            hm.put("LEAVEAMOUNT", rs.getString("LEAVEAMOUNT"));
            listOfEmployeeLeave.add(hm);
        }

        return listOfEmployeeLeave;
    }

    ///////////
    public void checkEmpBalance(Connection _con, String year, String empId) {
        String delete = "DELETE FROM HR_EMP_LEAVE_BANK " +
                " WHERE YEAR=? AND EMP_ID=? ";
        PreparedStatement _psDelete = null;
        try {
            _psDelete = _con.prepareStatement(delete);
            _psDelete.setString(1, year);
            _psDelete.setString(1, empId);
            _psDelete.executeUpdate();
            _psDelete.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public boolean saveLeaveSchdule(HashMap leaveBalance) {
        String sql = "INSERT INTO HR_LEAVE_SCHEDULE " +
                "  ( YEAR, " +
                "    START_DATE, " +
                "    END_DATE," +
                "    STATUS " +
                "  ) " +
                "  VALUES (?,?,?,?)";
        String delete = "DELETE FROM HR_LEAVE_SCHEDULE " +
                " WHERE YEAR=? ";
        boolean check = true;
        PreparedStatement _ps = null;
        PreparedStatement _psDelete = null;
        try {
            Connection _con = getConnection();
            _psDelete = _con.prepareStatement(delete);
            _psDelete.setString(1, leaveBalance.get("year").toString());
            _psDelete.executeUpdate();
            _ps = _con.prepareStatement(sql);
            _ps.setString(1, leaveBalance.get("year").toString());
            _ps.setString(2, leaveBalance.get("startDate").toString());
            _ps.setString(3, leaveBalance.get("endDate").toString());
            _ps.setString(4, leaveBalance.get("status").toString());
            if (_ps.executeUpdate() == 1) {
                check = true;
            }
            _ps.close();
            _con.close();
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }

    public boolean delteLeaveSchduleEmployee(int scheduleId, String empID) {
        String delete = "DELETE FROM HR_LEAVE_EMP_SCHEDULE " +
                " WHERE SCGEDULE_ID=? AND EMP_ID=? ";
        boolean check = true;
        PreparedStatement _psDelete = null;
        try {
            Connection _con = getConnection();
            _psDelete = _con.prepareStatement(delete);
            _psDelete.setInt(1, scheduleId);
            _psDelete.setString(2, empID);
            if (_psDelete.executeUpdate() == 1) {
                check = true;
            }
            _psDelete.close();
            _con.close();
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean approveLeaveSchedule(ArrayList<HashMap> leaveBalance, int status) {
        String sql = "UPDATE HR_LEAVE_EMP_SCHEDULE " +
                "  SET " +
                "  STATUS=? " +
                "  WHERE SCGEDULE_ID=? ";
        int checkSave[] = new int[leaveBalance.size()];
        boolean check = true;
        PreparedStatement _ps = null;
        int i = 0;
        try {
            Savepoint spOne = null;
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(sql);
            for (HashMap hm : leaveBalance) {
                _ps.setInt(1, status);
                _ps.setString(2, hm.get("balanceId").toString());
                checkSave[i] = _ps.executeUpdate();
                i++;
            }
            checkSave = _ps.executeBatch();
            for (int n : checkSave) {
                if (n <= 0) {
                    check = false;
                }
            }
            if (check) {
                _con.commit();//save the all informations
                return true;
            } else {
                _con.rollback(spOne);
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
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

    public ArrayList<HashMap> getTransferLeaveAmount(String employeeId, String beforSixMonth) {
        ArrayList<HashMap> transferLeaveAmount = new ArrayList<HashMap>();
        String selectQuery = "SELECT AVAILABLELEAVENUMBER - USEDLEAVE AS LEAVEAMOUNT , " +
                "  EMP_ID, " +
                "  RESERVELAVEID, " +
                "  RL.LEAVEYEAR " +
                "FROM HR_RESERVE_LEAVE RL, " +
                "  HR_LEAVE_TRANSFER_PROCESSED LP, " +
                "  BIB.TBL_PERMISSION PR " +
                "WHERE EMP_ID                        ='" + employeeId + "' " +
                "AND RL.RESERVELAVEID                =LP.REQUEST_ID " +
                "AND TO_NUMBER(AVAILABLELEAVENUMBER) > TO_NUMBER(USEDLEAVE) " +
                "AND STATUS LIKE 'App%' " +
                "AND LP.DECISION                                       =PR.CODE " +
                "AND PR.PERMISSION_NAME                                ='Approve' " +
                "AND TO_DATE(SUBSTR(LP.TIME_STAMP,1,10),'YYYY-MM-DD') >= TO_DATE('" + beforSixMonth + "','YYYY-MM-DD')";
        PreparedStatement ps;
        Connection conn;
        ResultSet rs;
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("LEAVEAMOUNT", rs.getString("LEAVEAMOUNT"));
                hm.put("LEAVEYEAR", rs.getString("LEAVEYEAR"));
                transferLeaveAmount.add(hm);
            }
            return transferLeaveAmount;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readAnnualLeaveBalance(String employeeId, String year) {
        String sql = "SELECT (LEAVEAMOUNT-USEDLEAVE) AS REAM, " +
                "  YEAR " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE EMP_ID             =? " +
                "AND YEAR              >= '" + year + "' " +
                "AND TO_NUMBER(USEDLEAVE) < TO_NUMBER(LEAVEAMOUNT) " +
                "ORDER BY YEAR";
        String leaveAmout = "";

        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            while (rs.next()) {
                leaveAmout += "[" + rs.getString("YEAR") + "==>" + rs.getString("REAM") + "]";
            }
            return leaveAmout;

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public String transferdLeaveBalance(String employeeId) {
        String sql = "SELECT SUM(AVAILABLELEAVENUMBER) - SUM(USEDLEAVE) AS COUNTLEAVE , " +
                "  LEAVEYEAR " +
                "FROM HR_RESERVE_LEAVE " +
                "WHERE EMP_ID                        =? " +
                "AND TO_NUMBER(AVAILABLELEAVENUMBER) > TO_NUMBER(USEDLEAVE) " +
                "AND STATUS LIKE 'App%' " +
                "GROUP BY LEAVEYEAR " +
                "ORDER BY LEAVEYEAR";
        try {
            String leaveAmout = "";
            Connection con = getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, employeeId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                leaveAmout += "[" + rs.getString("LEAVEYEAR") + "==>" + rs.getString("COUNTLEAVE") + "]";
            }
            return leaveAmout;
        } catch (Exception e) {
            return null;
        }

    }

    public String readAnnualLeaveGiven(String employeeId, String year) {
        String sql = "SELECT LEAVEAMOUNT " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE EMP_ID   =? " +
                "AND YEAR       = '" + year + "' " +
                "AND YEARLYGIVEN='notall' " +
                "ORDER BY YEAR";

        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sql);
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("LEAVEAMOUNT");
            }
            return "0";

        } catch (Exception e) {
            e.printStackTrace();
            return "0";
        }
    }

    public ResultSet selectLastEmployeeBalance(String selectedId) {

        String sqlOne = " SELECT * " +
                "FROM HR_EMP_LEAVE_BANK " +
                "WHERE EMP_ID=? " +
                "AND YEAR = " +
                "  (SELECT MAX(YEAR) FROM HR_EMP_LEAVE_BANK WHERE EMP_ID= ? " +
                "  ) ";

        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sqlOne);
            ps.setString(1, selectedId);
            ps.setString(2, selectedId);

            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet SelectAllEmployee() {

        String sqlOne = "SELECT emp.EMP_ID, " +
                "  expirance, " +
                "  emp.HIRE_DATE " +
                "FROM " +
                "  (SELECT EMP_ID, " +
                "    HIRE_DATE , " +
                "    TO_CHAR(sysdate, 'YYYY') - SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE,1,4) AS expirance " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  WHERE EMP_ID IN " +
                "    (SELECT emp_id FROM hr_emp_leave_bank where EMP_TERMINATION_STATUS <>'Y' " +
                "    ) " +
                "  )emp, " +
                "  (SELECT emp_id FROM HR_EMPLOYEE_INFO " +
                "  )bb " +
                "WHERE expirance >='1' " +
                "AND emp.EMP_ID   =bb.emp_id ";

        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sqlOne);
            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ResultSet SelectAllEmployeeExpiranceLessThanOneYear() {
        String currentDate = currentDate = dateFormat.format(new Date());
        String sqlOne = "SELECT exp.EMP_ID, " +
                "  expirance, " +
                "  MONTHDIFF, " +
                "  exp.HIRE_DATE " +
                "FROM " +
                "  (SELECT EMP_ID, " +
                "    HIRE_DATE, " +
                "    TO_CHAR(sysdate, 'YYYY') - SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE,1,4)                                    AS expirance, " +
                "    MONTHS_BETWEEN(TO_DATE(?,'YYYY-MM-DD'),TO_DATE(HR_EMPLOYEE_INFO.HIRE_DATE, 'yyyy-MM-DD')) AS MONTHDIFF " +
                "  FROM HR_EMPLOYEE_INFO " +
                "  ) exp , " +
                "  (SELECT emp_id FROM HR_EMPLOYEE_INFO where emp_status<>'03' " +
                "  )bb " +
                "WHERE MONTHDIFF <='12' " +
                "AND exp.EMP_ID =bb.emp_id";

        try {
            PreparedStatement ps = null;
            Connection conn = getConnection();
            ResultSet rs = null;
            ps = conn.prepareStatement(sqlOne);
            ps.setString(1, currentDate);
            rs = ps.executeQuery();
            return rs;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
