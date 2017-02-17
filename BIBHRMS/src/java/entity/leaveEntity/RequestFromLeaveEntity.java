/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author D
 */
@Entity
@Table(name = "HR_EMP_REQUEST_FROM_LEAVE")
@NamedQueries({@NamedQuery(name = "EmployeeRequestFromAnualLeave.findAll", query = "SELECT e FROM EmployeeRequestFromAnualLeave e"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByRequestId", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.requestId = :requestId"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByEmpId", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.empId = :empId"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByReturndate", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.returndate = :returndate"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByReason", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.reason = :reason"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByRequestStatus", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.requestStatus = :requestStatus"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByRequestBy", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.requestBy = :requestBy"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByTimeStamp", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.timeStamp = :timeStamp"), @NamedQuery(name = "EmployeeRequestFromAnualLeave.findByLeavetransferto", query = "SELECT e FROM EmployeeRequestFromAnualLeave e WHERE e.leavetransferto = :leavetransferto")})
public class RequestFromLeaveEntity extends ConnectionManager {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "REQUEST_ID")
    private String requestId;
    @Basic(optional = false)
    @Column(name = "emp_id")
    private String empId;
    @Column(name = "Return_date")
    private String returndate;
    @Column(name = "REASON")
    private String reason;
    @Basic(optional = false)
    @Column(name = "REQUEST_STATUS")
    private String requestStatus;
    @Column(name = "REQUEST_BY")
    private String requestBy;
    @Column(name = "TIME_STAMP")
    private String timeStamp;
    private String leaveRequestId;

    public RequestFromLeaveEntity() {
    }

    public RequestFromLeaveEntity(String requestId) {
        this.requestId = requestId;
    }

    public RequestFromLeaveEntity(
            String empId,
            String returndate,
            String reason,
            String requestStatus,
            String requestBy,
            String leaveRequestId) {
        this.empId = empId;
        this.returndate = returndate;
        this.reason = reason;
        this.requestStatus = requestStatus;
        this.requestBy = requestBy;
        this.leaveRequestId = leaveRequestId;
    }

    public RequestFromLeaveEntity(String requestId, String empId, String requestStatus) {
        this.requestId = requestId;
        this.empId = empId;
        this.requestStatus = requestStatus;
    }

    public RequestFromLeaveEntity(
            String requestId,
            String empId,
            String returndate,
            String reason,
            String requestStatus,
            String requestBy,
            String timeStamp) {
        this.requestId = requestId;
        this.empId = empId;
        this.returndate = returndate;
        this.reason = reason;
        this.requestStatus = requestStatus;
        this.requestBy = requestBy;
        this.timeStamp = timeStamp;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getReturndate() {
        return returndate;
    }

    public void setReturndate(String returndate) {
        this.returndate = returndate;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getTimeStamp() {
        return timeStamp();
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (requestId != null ? requestId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RequestFromLeaveEntity)) {
            return false;
        }
        RequestFromLeaveEntity other = (RequestFromLeaveEntity) object;
        if ((this.requestId == null && other.requestId != null) || (this.requestId != null && !this.requestId.equals(other.requestId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.leaveEntity.EmployeeRequestFromAnualLeave[requestId=" + requestId + "]";
    }

    public HashMap readEmployeeLeaveWithProfile(String leaveId) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HashMap hm = new HashMap();
            String sqlStatment = "SELECT EM.FIRST_NAME " +
                    "  || ' ' " +
                    "  || EM.MIDDLE_NAME " +
                    "  || '' " +
                    "  || EM.LAST_NAME AS FULLNAME, " +
                    "  EM.EMP_ID, " +
                    "  EM.JOB_CODE, " +
                    "  Em.Sex, " +
                    "  DE.DEP_DESCRIPTION, " +
                    "  JT.JOB_NAME, " +
                    "  LR.LEAVE_DAYS, " +
                    "  LR.LEAVE_ID, " +
                    "  LR.REQUESTED_FROM_DATE, " +
                    "  LR.REQUESTED_TO_DATE, " +
                    "  LR.REQUESTING_REASON , " +
                    "  LR.LEAVE_TYPE, " +
                    "  LT.DESCRIPTION, " +
                    "  NVL(LR.PHYSICALYEAR,'not register') AS PHYSICALYEAR, " +
                    "  Em.Photo " +
                    "FROM HR_EMPLOYEE_INFO EM, " +
                    "  HR_EMP_LEAVE LR, " +
                    "  Hr_Lu_Leave_Type Lt, " +
                    "  Hr_Lu_Job_Type Jt, " +
                    "  TBL_DEPT_BUNNA DE " +
                    "WHERE EM.EMP_ID     =LR.EMP_ID " +
                    "AND LR.LEAVE_TYPE   =LT.LEAVE_TYPE_CODE " +
                    "AND Em.Job_Code     =Jt.Job_Code " +
                    "AND Em.Department_Id=De.Dept_Id " +
                    "AND LR.LEAVE_ID     =?";

            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(1, leaveId);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            if (ocrs.next()) {
                hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                hm.put("EMP_ID", ocrs.getString("EMP_ID"));
                hm.put("JOB_CODE", ocrs.getString("JOB_CODE"));
                hm.put("SEX", ocrs.getString("SEX"));
                hm.put("DEPARTMENT_ID", ocrs.getString("DEP_DESCRIPTION"));
                hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                hm.put("REQUESTED_FROM_DATE", ocrs.getString("REQUESTED_FROM_DATE"));
                hm.put("REQUESTED_TO_DATE", ocrs.getString("REQUESTED_TO_DATE"));
                hm.put("REQUESTING_REASON", ocrs.getString("REQUESTING_REASON"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                hm.put("LEAVE_DAYS", ocrs.getString("LEAVE_DAYS"));
                hm.put("LEAVE_ID", ocrs.getString("LEAVE_ID"));
                hm.put("PHOTO", ocrs.getBlob("PHOTO"));
                hm.put("PHYSICALYEAR", ocrs.getString("PHYSICALYEAR"));
                return hm;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public boolean saveRequestInformation(RequestFromLeaveEntity requestInformation) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HashMap hm = new HashMap();
            String sqlStatment = "INSERT " +
                    "INTO HR_EMP_REQUEST_FROM_LEAVE " +
                    "  ( " +
                    "    EMP_ID, " +
                    "    REQUEST_RETURN_DATE, " +
                    "    REASON, " +
                    "    REQUEST_STATUS, " +
                    "    REQUEST_BY, " +
                    "    REQUESTED_DATE," +
                    "    LEAVEREQUESTID " +
                    "  ) " +
                    "  VALUES " +
                    "  ( " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?," +
                    "    ? " +
                    "  )";

            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(1, requestInformation.getEmpId());
            ps.setString(2, requestInformation.getReturndate());
            ps.setString(3, requestInformation.getReason());
            ps.setString(4, requestInformation.getRequestStatus());
            ps.setString(5, requestInformation.getRequestBy());
            ps.setString(6, getTimeStamp());
            ps.setString(7, requestInformation.getLeaveRequestId());
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

    public boolean saveRequestPaymentRequest(RequestFromLeaveEntity requestInformation) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HashMap hm = new HashMap();
            String sqlStatment = "INSERT " +
                    "INTO HR_EMP_LEAVE_PAYMENT_REQUEST " +
                    "  ( " +
                    "    EMP_ID, " +
                    "    REQUEST_BY, " +
                    "    PAYMENT_STATUS, " +
                    "    RETURNFROMLEAVEID, " +
                    "    ACTUAL_RETURN_DATE, " +
                    "    REASON_PAYMENT, " +
                    "    PAYMENT_REQUESTED_DATE" +
                    "  ) " +
                    "  VALUES " +
                    "  ( " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    ?" +
                    "  )";
            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(1, requestInformation.getEmpId());
            ps.setString(2, requestInformation.getRequestBy());
            ps.setString(3, requestInformation.getRequestStatus());
            ps.setString(4, requestInformation.getLeaveRequestId());
            ps.setString(5, requestInformation.getReturndate());
            ps.setString(6, requestInformation.getReason());
            ps.setString(7, getTimeStamp());
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

    public boolean updateRequestInformation(RequestFromLeaveEntity requestInformation) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HashMap hm = new HashMap();
            String sqlStatment = "UPDATE HR_EMP_REQUEST_FROM_LEAVE " +
                    "SET RETURN_DATE  = ?, " +
                    "  REASON         = ?, " +
                    "  REQUEST_STATUS = ?, " +
                    "  REQUEST_BY     = ? " +
                    "WHERE REQUEST_ID = ?";
            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(1, requestInformation.getReason());
            ps.setString(2, requestInformation.getRequestStatus());
            ps.setString(3, requestInformation.getRequestBy());
            ps.setString(4, requestInformation.getRequestId());
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

    public boolean deleteRequestInformation(RequestFromLeaveEntity requestInformation) {
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            HashMap hm = new HashMap();
            String sqlStatment = "DELETE FROM HR_EMP_REQUEST_FROM_LEAVE WHERE REQUEST_ID = ?";
            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            ps.setString(4, requestInformation.getRequestId());
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

    public ArrayList<HashMap> readRequesteToReturnFromLeaveEmployeeAndReturn() {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sqlStatment = "SELECT RFL.EMP_ID, " +
                "  RFL.REQUEST_RETURN_DATE, " +
                "  RFL.REQUEST_BY, " +
                "  RFL.REQUEST_ID, " +
                "  RFL.REQUEST_STATUS, " +
                "  RFL.REQUESTED_DATE , " +
                "  NVL(Lpr.Payment_Status,'NotRequest') Payment_Status " +
                "FROM HR_EMP_REQUEST_FROM_LEAVE RFL, " +
                "  HR_EMP_LEAVE_PAYMENT_REQUEST LPR " +
                "WHERE SUBSTR(RFL.REQUEST_STATUS,1,3)='App' " +
                "AND Rfl.Request_Id                  =Lpr.Returnfromleaveid(+) " +
                "AND LPR.Payment_Status             IS NULL";

        try {

            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("RETURN_DATE", rs.getString("REQUEST_RETURN_DATE"));
                hm.put("REQUEST_BY", rs.getString("REQUEST_BY"));
                hm.put("REQUEST_ID", rs.getString("REQUEST_ID"));
                hm.put("STATUS", rs.getString("REQUEST_STATUS"));
                hm.put("REQUESTED_DATE", rs.getString("REQUESTED_DATE"));
                hm.put("PAYMENT_STATUS", rs.getString("PAYMENT_STATUS"));
                listOfEmployee.add(hm);
            }
            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> readEmployeeRequesteToReturnFromLeave() {
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

//        String sqlStatment = "SELECT EMP_ID, " +
//                "  REQUEST_RETURN_DATE, " +
//                "  REQUEST_BY, " +
//                "  REQUEST_ID, " +
//                "  REQUEST_STATUS, " +
//                "  REQUESTED_DATE, " +
//                "  leaverequestid " +
//                "FROM HR_EMP_REQUEST_FROM_LEAVE " +
//                "WHERE SUBSTR(REQUEST_STATUS,1,3)='App' " +
//                "AND (PAYMENT_STATUS            IS NULL " +
//                "OR PAYMENT_STATUS               ='')";

        String sqlStatment = "SELECT erl.EMP_ID, " +
                "  erl.REQUEST_RETURN_DATE, " +
                "  erl.REQUEST_BY, " +
                "  erl.REQUEST_ID, " +
                "  erl.REQUEST_STATUS, " +
                "  erl.REQUESTED_DATE, " +
                "  erl.leaverequestid , " +
                "  EL.leave_id, " +
                "  empf.emp_id, " +
                "  empf.emp_status " +
                "FROM HR_EMP_REQUEST_FROM_LEAVE erl , " +
                "  hr_emp_leave EL, " +
                "  hr_employee_info empf " +
                "WHERE SUBSTR(REQUEST_STATUS,1,3)='App' " +
                "AND (PAYMENT_STATUS            IS NULL " +
                "AND EL.leave_id                 =erl.leaverequestid " +
                "AND empf.emp_id                 = erl.EMP_ID " +
                "AND empf.emp_status             ='02' " +
                "OR PAYMENT_STATUS               ='')";
        try {

            con = getConnection();
            ps = con.prepareStatement(sqlStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("leaverequestid", rs.getString("leaverequestid"));
                hm.put("RETURN_DATE", rs.getString("REQUEST_RETURN_DATE"));
                hm.put("REQUEST_BY", rs.getString("REQUEST_BY"));
                hm.put("REQUEST_ID", rs.getString("REQUEST_ID"));
                hm.put("STATUS", rs.getString("REQUEST_STATUS"));
                hm.put("REQUESTED_DATE", rs.getString("REQUESTED_DATE"));
                listOfEmployee.add(hm);
            }
            return listOfEmployee;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(String leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    String timeStamp() {
        Date date = new Date();
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(date.getTime());
        return dateNow;
    }

    public static void main(String args[]) {
        // Instantiate a Date object
        Date date = new Date();
        SimpleDateFormat formatter =
                new SimpleDateFormat("yyyy-MM-dd");
        String dateNow = formatter.format(date.getTime());
    // display time and date using toString()
    }
}
