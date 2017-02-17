/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.reporterEntity.employeeLeaveReportEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author  BravoZulu
 */
public class LeaveReportEntity extends ConnectionManager {

    PreparedStatement ps;
    ResultSet rs;
    Connection _conn;

    public LeaveReportEntity() {
    }

    public ArrayList<HashMap> lisOfRequestLeave(String employeeId, boolean selectCriteria) {
        ArrayList<HashMap> listOfRequest = new ArrayList<HashMap>();
        String selectQuerry = "SELECT EP.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||'' " +
                "  || EP.MIDDLE_NAME " +
                "  ||'' " +
                "  || EP.LAST_NAME AS FULLNAME, " +
                "  EP.SEX, " +
                "  EP.JOB_CODE, " +
                "  EP.OFFICE_OR_SHIFT, " +
                "  LE.STATUS, " +
                "  LT.DESCRIPTION AS LEAVETYPE, " +
                "  LE.REQUESTED_DATE, " +
                "  LE.REQUESTED_FROM_DATE " +
                "  || ' ' " +
                "  || 'To' " +
                "  || ' ' " +
                "  || LE.REQUESTED_TO_DATE AS FROMTO, " +
                "  LE.LEAVE_DAYS, " +
                "  LE.REQUESTING_REASON, " +
                "  departmentName, " +
                "  jobName " +
                "FROM HR_EMPLOYEE_INFO EP , " +
                "  HR_EMP_LEAVE LE, " +
                "  HR_LU_LEAVE_TYPE LT, " +
                "  (SELECT epf.emp_id, " +
                "    AD.DEPT_NAME AS departmentName, " +
                "    ATE.JOB_NAME AS jobName " +
                "  FROM hr_employee_info epf " +
                "  INNER JOIN tbl_dept_bunna AD " +
                "  ON AD.DEPT_ID=epf.department_id " +
                "  INNER JOIN hr_lu_job_type ATE " +
                "  ON ATE.JOB_CODE=epf.job_code " +
                "  )TR " +
                "WHERE EP.EMP_ID       =TR.EMP_ID(+) " +
                "AND LE.EMP_ID         =EP.EMP_ID " +
                "AND LT.LEAVE_TYPE_CODE=LE.LEAVE_TYPE " +
                "AND LE.STATUS LIKE 'App%' ";
        if (!selectCriteria) {
            selectQuerry += " AND EP.EMP_ID         ='" + employeeId + "' " +
                    " ORDER BY EP.EMP_ID";
        } else {
            selectQuerry += " ORDER BY EP.EMP_ID desc";
        }
        try {
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("OFFICE_OR_SHIFT", rs.getString("OFFICE_OR_SHIFT"));
                //  hm.put("ADDRESSTYPE", rs.getString("ADDRESSTYPE"));
                hm.put("departmentName", rs.getString("departmentName"));
                hm.put("jobName", rs.getString("jobName"));
                // hm.put("TELEPHONE_RESIDENCE", rs.getString("TELEPHONE_RESIDENCE"));
                //hm.put("WOREDA_OR_SUBCITY_ID", rs.getString("WOREDA_OR_SUBCITY_ID"));
                hm.put("STATUS", rs.getString("STATUS"));
                hm.put("LEAVETYPE", rs.getString("LEAVETYPE"));
                hm.put("FROMTO", rs.getString("FROMTO"));
                hm.put("LEAVE_DAYS", rs.getString("LEAVE_DAYS"));
                hm.put("REQUESTED_DATE", rs.getString("REQUESTED_DATE"));
                hm.put("REQUESTING_REASON", rs.getString("REQUESTING_REASON"));

                listOfRequest.add(hm);
            }
            return listOfRequest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap[] lisOfEmployeetLeaveBalance(String employeeId, boolean selectAll) {
        HashMap listOfRequest[];
        int counter = 0;
        String selectQuerry = "SELECT LB.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||' ' " +
                "  || EP.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EP.LAST_NAME AS FULLNAME, " +
                "  EP.SEX, " +
                "  'ANNUAL LEAVE'                 AS LEAVETYPE, " +
                "  NVL(LEAVEAMOUNT-USEDLEAVE,'0') AS AVILEBELLEAVEAMOUNT, " +
                "  YEAR " +
                "FROM HR_EMP_LEAVE_BANK LB, " +
                "  HR_EMPLOYEE_INFO EP " +
                "WHERE YEAR   >= '2004' " +
                "AND EP.EMP_ID =LB.EMP_ID ";

        if (selectAll) {
            selectQuerry += " ORDER BY LB.EMP_ID, " +
                    "  YEAR";
        } else {
            selectQuerry += "AND LB.EMP_ID='" + employeeId + "' " +
                    " ORDER BY LB.EMP_ID, " +
                    "  YEAR";
        }
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            listOfRequest = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                listOfRequest[counter] = new HashMap();
                listOfRequest[counter].put("EMPLOYEEID", ocrs.getString("EMP_ID"));
                listOfRequest[counter].put("FULLNAME", ocrs.getString("FULLNAME"));
                listOfRequest[counter].put("SEX", ocrs.getString("SEX"));
                listOfRequest[counter].put("LEAVETYPE", ocrs.getString("LEAVETYPE"));
                listOfRequest[counter].put("AVILEBELLEAVEAMOUNT", ocrs.getString("AVILEBELLEAVEAMOUNT"));
                listOfRequest[counter].put("YEAR", ocrs.getString("YEAR"));
                counter++;
            }
            return listOfRequest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> lisOfEmployeetLeave(String employeeId, boolean selectAll)
    {
        ArrayList<HashMap> listOfRequest = new ArrayList<HashMap>();
        String selectQuerry = " SELECT DISTINCT FULLNAME, " +
                "  epf.emp_id, " +
                "  epf.HIRE_DATE, " +
                "  epf.SALARY, " +
                "  epf.dep_description, " +
                "  epf.job_name, " +
                "  usedLeaveBalance, " +
                "  balance " +
                " FROM " +
                "  (SELECT DISTINCT ep.FIRST_NAME " +
                "    ||' ' " +
                "    || ep.MIDDLE_NAME " +
                "    ||' ' " +
                "    || ep.LAST_NAME AS FULLNAME, " +
                "    ep.emp_id , " +
                "    ep.HIRE_DATE, " +
                "    ep.SALARY, " +
                "    tbd.dep_description, " +
                "    hlj.job_name " +
                "  FROM hr_employee_info ep " +
                "  INNER JOIN tbl_dept_bunna tbd " +
                "  ON tbd.dept_id=ep.department_id " +
                "  INNER JOIN hr_lu_job_type hlj " +
                "  ON hlj.job_code=ep.job_code " +
                "  )EPF, " +
                "  (SELECT PR.emp_id, " +
                "    NVL(PR.LEAVEAMOUNT-PR.USEDLEAVE,'0') AS AVILEBELLEAVEAMOUNT " +
                "  FROM HR_EMP_LEAVE_BANK PR " +
                "  ) pr, " +
                "  (SELECT emp_id, " +
                "    SUM(usedleave)           AS usedLeaveBalance, " +
                "    SUM(AVILEBELLEAVEAMOUNT) AS balance " +
                "  FROM ( " +
                "    (SELECT PR.emp_id, " +
                "      pr.usedleave, " +
                "      NVL(PR.LEAVEAMOUNT-PR.USEDLEAVE,'0') AS AVILEBELLEAVEAMOUNT " +
                "    FROM HR_EMP_LEAVE_BANK PR " +
                "    ) PR) " +
                "  GROUP BY emp_id " +
                "  )bb " +
                "WHERE epf.emp_id=pr.emp_id " +
                "AND epf.emp_id  =bb.emp_id ";

        if (selectAll) {
            selectQuerry += " ORDER BY FULLNAME ";
        } else {
            selectQuerry += "AND epf.EMP_ID='" + employeeId + "' " +
                    " ORDER BY FULLNAME ";
        }
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", ocrs.getString("emp_id"));
                hm.put("HIREDATE", ocrs.getString("HIRE_DATE"));
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("DEPARTMENTNAME", ocrs.getString("dep_description"));
                hm.put("JOBNAME", ocrs.getString("job_name"));
                hm.put("USEDLEAVEBALANCE", ocrs.getString("usedLeaveBalance"));
                hm.put("TOTALBALANCE", ocrs.getString("balance"));
                listOfRequest.add(hm);
            }
            return listOfRequest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> lisOfEmployeeLeaveTransfer(String employeeId, boolean selectCriteria) {
        ArrayList<HashMap> listOfRequest = new ArrayList<HashMap>();
        String selectQuerry =
                "SELECT EP.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||' ' " +
                "  || EP.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EP.LAST_NAME AS FULLNAME, " +
                "  EP.SEX, " +
                "  'ANNUAL LEAVE'                                                                             AS LEAVETYPE, " +
                "  NVL(pYear.AVILEBELLEAVEAMOUN, 0)                                                           AS perviousLeaveAmount, " +
                "  NVL(prYear.AVILEBELLEAVEAMOUNT,0)                                                          AS presentLeaveAmount, " +
                "  to_number(NVL(pYear.AVILEBELLEAVEAMOUN, 0)) + to_number(NVL(prYear.AVILEBELLEAVEAMOUNT,0)) AS REMINGLEAVEAMOUNT, " +
                "  TR.REQUEST_DATE , " +
                "  TR.AVAILABLELEAVENUMBER       AS TRANSFERAMOUNT, " +
                "  NVL(TR.FROMTO,'Not Register') AS FROMTO, " +
                "  NVL(TR.REMARK,'Not Register') AS REMARK " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  (SELECT PR.EMP_ID, " +
                "    NVL(PR.LEAVEAMOUNT-PR.USEDLEAVE,'0') AS AVILEBELLEAVEAMOUNT, " +
                "    PR.YEAR " +
                "  FROM HR_EMP_LEAVE_BANK PR " +
                "  WHERE PR.YEAR = '2004' " +
                "  )prYear, " +
                "  (SELECT EMP_ID                   AS employeeId, " +
                "    NVL(LEAVEAMOUNT-USEDLEAVE,'0') AS AVILEBELLEAVEAMOUN, " +
                "    YEAR                           AS physicalYear " +
                "  FROM HR_EMP_LEAVE_BANK " +
                "  WHERE YEAR = '2005' " +
                "  )pYear, " +
                "  (SELECT RL.EMP_ID, " +
                "    RL.REQUEST_DATE, " +
                "    RL.RESERVELAVEID, " +
                "    RL.STARTDATE " +
                "    || '--' " +
                "    || RL.ENDDATE AS FROMTO, " +
                "    RL.REMARK, " +
                "    RL.LEAVEYEAR, " +
                "    RL.AVAILABLELEAVENUMBER " +
                "  FROM HR_RESERVE_LEAVE RL " +
                "  WHERE RL.STATUS LIKE 'App%' " +
                "  )TR " +
                "WHERE EP.EMP_ID=prYear.EMP_ID(+) " +
                "AND EP.EMP_ID  =pYear.employeeId(+) " +
                "AND EP.EMP_ID  =TR.EMP_ID ";
        if (!selectCriteria) {
            selectQuerry += "AND EP.EMP_ID='" + employeeId + "' " +
                    " ORDER BY EP.EMP_ID ";
        } else {
            selectQuerry += " ORDER BY EP.EMP_ID ";


        }



        try {
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("SEX", rs.getString("SEX"));
                hm.put("LEAVETYPE", rs.getString("LEAVETYPE"));
                hm.put("REQUEST_DATE", rs.getString("REQUEST_DATE"));
                hm.put("AVAILABLELEAVENUMBER", rs.getString("TRANSFERAMOUNT"));
                hm.put("REMINGLEAVEAMOUNT", rs.getString("REMINGLEAVEAMOUNT"));
                hm.put("perviousLeaveAmount", rs.getString("perviousLeaveAmount"));
                hm.put("presentLeaveAmount", rs.getString("presentLeaveAmount"));
                hm.put("FROMTO", rs.getString("FROMTO"));
                hm.put("REMARK", rs.getString("REMARK"));
                hm.put("TRANSFERAMOUNT", rs.getString("TRANSFERAMOUNT"));

                listOfRequest.add(hm);
            }
            return listOfRequest;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap avilebleAnualeLeave(String employeeId) {
        String selectQuerry = "SELECT NVL(LEAVEAMOUNT-USEDLEAVE,'0') AS AVILEBELLEAVEAMOUNT, " +
                "  YEAR " +
                "FROM HR_EMP_LEAVE_BANK LB " +
                "WHERE YEAR   >= '2004' " +
                "AND (LB.EMP_ID='TW/00483') " +
                "ORDER BY YEAR";
        try {
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            rs = ps.executeQuery();
            HashMap listOfLeave = new HashMap();
            boolean secondTime = false;
            while (rs.next()) {
                if (secondTime) {
                    listOfLeave.put("secondPhisicalYear", rs.getString("AVILEBELLEAVEAMOUNT"));
                    secondTime = false;
                } else {
                    listOfLeave.put("firstPhisicalYear", rs.getString("AVILEBELLEAVEAMOUNT"));
                }
                secondTime = true;
            }
            listOfLeave.put("secondPhisicalYear", "0");
            return listOfLeave;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String leaveTransferApproveDate(String transferRequestID) {
        String selectQuerry = "SELECT NVL(SUBSTR(LT.TIME_STAMP,0,10),'NOT APPORVED') AS APPROVERDATE " +
                "FROM HR_LEAVE_TRANSFER_PROCESSED LT, " +
                "  MUGHER.TBL_PERMISSION PR " +
                "WHERE REQUEST_ID      =? " +
                "AND PR.CODE           =LT.DECISION " +
                "AND PR.PERMISSION_NAME='Approve'";
        try {
            _conn = getConnection();
            ps = _conn.prepareStatement(selectQuerry);
            ps.setString(1, transferRequestID);
            rs = ps.executeQuery();
            if (rs.next()) {
                return rs.getString("APPROVERDATE");
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
