/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.faces.model.SelectItem;

/**
 *
 * @author ONEJAVA
 */
public class LeaveSettlementEntity extends ConnectionManager {

    private HashMap leaveRequestInfo;
    private HashMap leaveRequestInfo2;
    private HashMap leaveYear;

    public HashMap getLeaveRequestInfo() {
        return leaveRequestInfo;
    }

    public void setLeaveRequestInfo(HashMap leaveRequestInfo) {
        this.leaveRequestInfo = leaveRequestInfo;
    }

    public HashMap getLeaveRequestInfo2() {
        return leaveRequestInfo2;
    }

    public void setLeaveRequestInfo2(HashMap leaveRequestInfo2) {
        this.leaveRequestInfo2 = leaveRequestInfo2;
    }

    public HashMap getLeaveYear() {
        return leaveYear;
    }

    public void setLeaveYear(HashMap leaveYear) {
        this.leaveYear = leaveYear;
    }

    public LeaveSettlementEntity() {
    }

    public LeaveSettlementEntity(HashMap leaveRequestInfo,
            HashMap leaveRequestInfo2,
            HashMap leaveYear) {
        this.leaveRequestInfo = leaveRequestInfo;
        this.leaveRequestInfo2 = leaveRequestInfo2;
        this.leaveYear = leaveYear;
    }

    public boolean settlementLeaveInformation(LeaveSettlementEntity leaveSettlementEntity) {
        try {
            int insertStatus = 0;
            String inseret = " INSERT INTO HR_EMP_LEAVE ( emp_Id, " +
                    " leave_Type, " +
                    " requested_From_Date, " +
                    " requested_To_Date, " +
                    " requesting_Reason, " +
                    " requested_Date, " +
                    " STATUS," +
                    " LEAVE_DAYS," +
                    " LEVETYPE )" +
                    " values(?,?,?,?,?,?,?,?,?) ";
            String delete = " DELETE FROM HR_EMP_LEAVE WHERE LEAVE_ID=? ";
            String insertLeaveYear = " INSERT INTO  HR_EMP_LEAVE_STATUS(LEAVE_ID," +
                    " PHYSICAL_YEAR,LEAVE_DAYS,LEVETYPE)" +
                    " VALUES (SEQ_HR_REQUESTS.currval , ? , ?, ? )";
            Connection con = getConnection();
            con.setAutoCommit(false);
            Savepoint sPoint = con.setSavepoint();
            PreparedStatement forInsert = null;
            PreparedStatement forDelete = null;
            PreparedStatement leaveYearPr = null;
            forDelete = con.prepareCall(delete);
            forDelete.setString(1, leaveSettlementEntity.getLeaveRequestInfo().get("leaveId").toString());
            if (forDelete.executeUpdate() > 0) {
                forInsert = con.prepareCall(inseret);
                forInsert.setString(1, leaveSettlementEntity.getLeaveRequestInfo().get("employeeId").toString());
                forInsert.setString(2, leaveSettlementEntity.getLeaveRequestInfo().get("LeaveType").toString());
                forInsert.setString(3, leaveSettlementEntity.getLeaveRequestInfo().get("startDate").toString());
                forInsert.setString(4, leaveSettlementEntity.getLeaveRequestInfo().get("endDate").toString());
                forInsert.setString(5, leaveSettlementEntity.getLeaveRequestInfo().get("reason").toString());
                forInsert.setString(6, leaveSettlementEntity.getLeaveRequestInfo().get("requestDate").toString());
                forInsert.setString(7, "1");
                forInsert.setString(8, leaveSettlementEntity.getLeaveRequestInfo().get("leaveDay").toString());
                forInsert.setString(9, "1");
                if (forInsert.executeUpdate() > 0) {
                    leaveYearPr = con.prepareCall(insertLeaveYear);
                    for (Iterator iter = leaveSettlementEntity.getLeaveYear().keySet().iterator(); iter.hasNext();) {
                        String key = (String) iter.next();
                        int value = ((Integer) leaveSettlementEntity.getLeaveYear().get(key)).intValue();
                        leaveYearPr.setString(1, key);
                        leaveYearPr.setInt(2, value);
                        leaveYearPr.setString(3, "1");
                        insertStatus = leaveYearPr.executeUpdate();
                    }
                    if (insertStatus > 0) {
                        con.commit();
                        return true;
                    } else {
                        con.rollback(sPoint);
                        return false;
                    }
                } else {
                    con.rollback(sPoint);
                    return false;
                }
            } else {
                con.rollback(sPoint);
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<SelectItem> listOfEmployeeOnLeave() {
        ArrayList<SelectItem> listOfOnLeave = new ArrayList<SelectItem>();
        String selectStatmant = "SELECT DISTINCT EMP.EMP_ID, " +
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
                "AND ACTUALRETURNDATE                             IS NULL " +
                "ORDER BY EMP.EMP_ID DESC";

        try {
            Connection con = getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement(selectStatmant);
            rs = ps.executeQuery();
            while (rs.next()) {
                listOfOnLeave.add(new SelectItem( rs.getString("EMP_ID")+"="+rs.getString("LEAVE_ID"),
                        rs.getString("FULLNAME")));

               
            }
            return listOfOnLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean checkRequestStatus(String leaveRequesId) {
        try {
            String selectStatment = "SELECT COUNT(LEAVEREQUESTID) AS COUNT " +
                    "FROM HR_EMP_REQUEST_FROM_LEAVE " +
                    "WHERE LEAVEREQUESTID=?";

            Connection con = getConnection();
            PreparedStatement ps = null;
            ResultSet rs = null;
            ps = con.prepareStatement(selectStatment);
            ps.setString(1, leaveRequesId);
            rs = ps.executeQuery();
            if (rs.next()) {
                if (rs.getInt("COUNT") > 0) {
                    return false;
                } else {
                    return true;
                }

            } else {
                return true;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }
}
