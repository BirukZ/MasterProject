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
 * @author Administrator
 */
public class LeaveReportEntity extends ConnectionManager {

    ResultSet rs = null;
    PreparedStatement ps = null;
    Connection con = null;

    public OracleCachedRowSet getEmployeeRemainingLeave(String departemntId) throws Exception {
        try {

            String sql = "SELECT EI.EMP_ID AS EMPLOYEEID," +
                    " EI.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EI.MIDDLE_NAME " +
                    "  || ' ' " +
                    "  || EI.LAST_NAME AS EMPFULLNAME, " +               
                    "  Lb.REMAININGAMOUNT as LASTYEAR, " +
                    "  PRV.PREVIOUSLEAVEGAMOUNT AS SECONDYEAR, " +
                    "  PRV.Year                   AS PREVIOUSYEAR, " +
                    "  NVL(Rl.Transferamount,'0') AS FIRSTYEAR " +
                    "FROM HR_EMPLOYEE_INFO Ei, " +
                    "  (SELECT EMP_ID, " +
                    "    YEAR, " +
                    "    LEAVEAMOUNT -USEDLEAVE AS PREVIOUSLEAVEGAMOUNT " +
                    "  FROM HR_EMP_LEAVE_BANK " +
                    "  WHERE YEAR                ='2004' " +
                    "  AND To_Number(Leaveamount)>To_Number(Usedleave) " +
                    "  )PRV, " +
                    "  (SELECT EMP_ID, " +
                    "    YEAR, " +
                    "    LEAVEAMOUNT -USEDLEAVE AS REMAININGAMOUNT " +
                    "  FROM HR_EMP_LEAVE_BANK " +
                    "  WHERE YEAR                ='2005' " +
                    "  AND To_Number(Leaveamount)>To_Number(Usedleave) " +
                    "  )LB, " +
                    "  (SELECT LB.RESERVELAVEID , " +
                    "    LB.EMP_ID , " +
                    "    Lb.Leaveyear , " +
                    "    LB.AVAILABLELEAVENUMBER -LB.USEDLEAVE AS transferAmount, " +
                    "    LB.STATUS " +
                    "  FROM HR_RESERVE_LEAVE LB " +
                    "  WHERE To_Number(Availableleavenumber)>To_Number(Usedleave) " +
                    "  AND ( To_Date(Enddate,'yyyy-MM-dd')  >To_Date(TO_CHAR(Sysdate,'yyyy-MM-dd'),'yyyy-MM-dd') ) " +
                    "  ORDER BY Lb.Emp_Id " +
                    "  )Rl " +
                    "WHERE Ei.Emp_Id      =Lb.Emp_Id(+) " +
                    "AND Ei.Emp_Id        =PRV.Emp_Id(+) " +
                    "AND Ei.Emp_Id        = Rl.Emp_Id(+) " +
                    "AND ei.department_id ='" + departemntId + "' " +
                    "ORDER BY Lb.Emp_Id, " +
                    "  Lb.Year";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return ocrs;

        } finally {
        }

    }

    public ArrayList<HashMap> getLeaveSecaduleReport(String departemntId) throws Exception {
        ArrayList<HashMap> listOfSecadule = new ArrayList<HashMap>();
        String[] listOfMonth = {
            "January",
            "February",
            "March",
            "April",
            "May",
            "June",
            "July",
            "Augest",
            "September",
            "October",
            "November",
            "December"};
        try {
            String sql = "SELECT First_Name " +
                    "  ||'  ' " +
                    "  || Middle_Name " +
                    "  ||'  ' " +
                    "  || LAST_NAME AS EMPFULLNAME, " +
                    "  MONTH, " +
                    "  NVL(Days,'not register')                               AS Days, " +
                    "  ( REMAININGAMOUNT+PREVIOUSLEAVEGAMOUNT+Transferamount) AS remaingLeave " +
                    "FROM Hr_Leave_Emp_Schedule " +
                    "INNER JOIN Hr_Employee_Info " +
                    "ON Hr_Leave_Emp_Schedule.Emp_Id=Hr_Employee_Info.Emp_Id " +
                    "LEFT JOIN " +
                    "  (SELECT Lb.EMP_ID, " +
                    "    Lb.REMAININGAMOUNT , " +
                    "    PRV.PREVIOUSLEAVEGAMOUNT , " +
                    "    NVL(Rl.Transferamount,'0') AS Transferamount " +
                    "  FROM HR_EMPLOYEE_INFO Ei, " +
                    "    (SELECT EMP_ID, " +
                    "      YEAR, " +
                    "      LEAVEAMOUNT -USEDLEAVE AS PREVIOUSLEAVEGAMOUNT " +
                    "    FROM HR_EMP_LEAVE_BANK " +
                    "    WHERE YEAR                ='2004' " +
                    "    AND To_Number(Leaveamount)>To_Number(Usedleave) " +
                    "    )PRV, " +
                    "    (SELECT EMP_ID, " +
                    "      YEAR, " +
                    "      LEAVEAMOUNT -USEDLEAVE AS REMAININGAMOUNT " +
                    "    FROM HR_EMP_LEAVE_BANK " +
                    "    WHERE YEAR                ='2005' " +
                    "    AND To_Number(Leaveamount)>To_Number(Usedleave) " +
                    "    )LB, " +
                    "    (SELECT LB.RESERVELAVEID , " +
                    "      LB.EMP_ID , " +
                    "      Lb.Leaveyear , " +
                    "      LB.AVAILABLELEAVENUMBER -LB.USEDLEAVE AS transferAmount, " +
                    "      LB.STATUS " +
                    "    FROM HR_RESERVE_LEAVE LB " +
                    "    WHERE To_Number(Availableleavenumber)>To_Number(Usedleave) " +
                    "    AND ( To_Date(Enddate,'yyyy-MM-dd')  >To_Date(TO_CHAR(Sysdate,'yyyy-MM-dd'),'yyyy-MM-dd') ) " +
                    "    ORDER BY Lb.Emp_Id " +
                    "    )Rl " +
                    "  WHERE Ei.Emp_Id =Lb.Emp_Id(+) " +
                    "  AND Ei.Emp_Id   =Prv.Emp_Id(+) " +
                    "  AND Ei.Emp_Id   = Rl.Emp_Id(+) " +
                    "  )Lea " +
                    "ON HR_LEAVE_EMP_SCHEDULE.EMP_ID=Lea.EMP_ID";


            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

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
                    day = rs.getString("days").toString().split(",");
                    HashMap hm = new HashMap();
                    hm.put("EMPFULLNAME", rs.getString("EMPFULLNAME"));
                    hm.put("AvilebelLeave", rs.getString("remaingLeave"));
                    for (int i = 0; i < list.length; i++) {
                        hm.put(listOfMonth[Integer.parseInt(list[i])], day[i]);
                    }
                    listOfSecadule.add(hm);

                } else {
                    HashMap hm = new HashMap();
                    hm.put("EMPFULLNAME", rs.getString("EMPFULLNAME"));
                    hm.put("AvilebelLeave", rs.getString("remaingLeave"));
                    hm.put(listOfMonth[Integer.parseInt(rs.getString("MONTH"))], rs.getString("days"));



                    listOfSecadule.add(hm);
                }

            }









            return listOfSecadule;

        } finally {
        }

    }

    public ResultSet getLeaveStaticReport() throws Exception {
        try {
            String sql = "SELECT " +
                    "  CASE " +
                    "    WHEN Sumofusedleave<0 " +
                    "    THEN Sumofusedleave*-1 " +
                    "    ELSE Sumofusedleave " +
                    "  END AS sumOfleave, " +
                    "  Leavetype " +
                    "FROM " +
                    "  (SELECT SUM(El.Leave_Days) AS Sumofusedleave , " +
                    "    LT.DESCRIPTION           AS LEAVETYPE " +
                    "  FROM HR_EMP_LEAVE EL " +
                    "  INNER JOIN HR_LU_LEAVE_TYPE LT " +
                    "  ON El.Leave_Type=Lt.Leave_Type_Code " +
                    "  GROUP BY LT.DESCRIPTION " +
                    "  )";
            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return ocrs;

        } finally {
        }

    }

    public OracleCachedRowSet getLeaveStaticReportSum() throws Exception {
        try {
            String sql = "SELECT " +
                    "  CASE " +
                    "    WHEN Sumofusedleave<0 " +
                    "    THEN Sumofusedleave*-1 " +
                    "    ELSE Sumofusedleave " +
                    "  END AS USEDLEAVEAMOUNT, " +
                    "  LEAVETYPE " +
                    "FROM " +
                    "  (SELECT SUM(El.Leave_Days) AS Sumofusedleave , " +
                    "    LT.DESCRIPTION           AS LEAVETYPE " +
                    "  FROM HR_EMP_LEAVE EL " +
                    "  INNER JOIN HR_LU_LEAVE_TYPE LT " +
                    "  ON El.Leave_Type=Lt.Leave_Type_Code " +
                    "  GROUP BY LT.DESCRIPTION " +
                    "  )";

            con = getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return ocrs;

        } finally {
        }

    }

    public OracleCachedRowSet getFullName() throws Exception {
        try {
            String sql = "SELECT FIRST_NAME " +
                    "  ||'  ' " +
                    "  || MIDDLE_NAME " +
                    "  ||'  ' " +
                    "  ||LAST_NAME AS FULLNAME " +
                    "FROM HR_EMPLOYEE_INFO " +
                    "WHERE EMP_ID='AZ/01328'";

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
