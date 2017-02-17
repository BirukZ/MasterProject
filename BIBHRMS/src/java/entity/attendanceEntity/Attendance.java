/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.attendanceEntity;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Preferred Customer
 */
public class Attendance extends ConnectionManager {

    private String attendanceID;
    private String absenteeEmpId;
    private String absenteeReportedBy;
    private String absenteeDate;
    private String absenteeDescription;
    private String recordedBy;
    private String recordedDate;
    private String attendanceState;
    private String approvedBy;
    private String approvedDate;
    private String certifiedBy;
    private String certifiedDate;
    private String forDepartment;
    private String approveStatus;
    private String certifyStatus;
    String val1, val2, val3, val4;
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

    public String getVal1() {
        return val1;
    }

    public void setVal1(String val1) {
        this.val1 = val1;
    }

    public String getVal2() {
        return val2;
    }

    public void setVal2(String val2) {
        this.val2 = val2;
    }

    public String getVal3() {
        return val3;
    }

    public void setVal3(String val3) {
        this.val3 = val3;
    }

    public String getVal4() {
        return val4;
    }

    public void setVal4(String val4) {
        this.val4 = val4;
    }

    public String getForDepartment() {
        return forDepartment;
    }

    public void setForDepartment(String forDepartment) {
        this.forDepartment = forDepartment;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getCertifyStatus() {
        return certifyStatus;
    }

    public void setCertifyStatus(String certifyStatus) {
        this.certifyStatus = certifyStatus;
    }

    // <editor-fold defaultstate="collapsed" desc="Constructors And Gaiter/ Setter ">
    /**
     * the default constructor without parameters
     */
    public Attendance() {
    }

    public Attendance(String val1, String val2) {
        this.val1 = val1;
        this.val2 = val2;
    }

    public Attendance(String val1, String val2, String val3, String val4) {
        this.val1 = val1;
        this.val2 = val2;
        this.val3 = val3;
        this.val4 = val4;
    }

    /**
     * The constructor with the specified parameters
     * @param attendanceID the attendance identifier
     * @param absenteeReportedBy the employee who reported the attendance
     * @param absenteeDate the date the attendance is taken
     * @param absenteeDescription the description
     * @param recordedBy the employee who made the record
     * @param recordedDate the date the record is made
     */
    public Attendance(String attendanceID, String absenteeReportedBy, String absenteeDate, String absenteeDescription, String recordedBy, String recordedDate) {
        this.attendanceID = attendanceID;
        //this.absenteeEmpId = absenteeEmpId;
        this.absenteeReportedBy = absenteeReportedBy;
        this.absenteeDate = absenteeDate;
        this.absenteeDescription = absenteeDescription;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
    //this.attendanceState = state;
    }

    /**
     * The constructor with the specified parameters
     * @param attendanceID the attendance identifier
     * @param absenteeReportedBy the employee who reported the attendance
     * @param absenteeDate the date the attendance is taken
     * @param absenteeDescription the description
     * @param recordedBy the employee who made the record
     * @param recordedDate the date the record is made
     */
    public Attendance(String absenteeReportedBy, String absenteeDate, String absenteeDescription, String recordedBy, String recordedDate) {
        //this.absenteeEmpId = absenteeEmpId;
        this.absenteeReportedBy = absenteeReportedBy;
        this.absenteeDate = absenteeDate;
        this.absenteeDescription = absenteeDescription;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
    //this.attendanceState = state;
    }

    /**
     * The constructor with the specified parameters
     * @param absenteeReportedBy the employee who reported the attendance
     * @param absenteeDate the date the attendance is taken
     * @param absenteeDescription the description
     * @param recordedBy the employee who made the record
     * @param recordedDate the date the record is made
     * @param attendanceState
     * @param approvedBy
     * @param approvedDate
     * @param certifiedBy
     * @param certifiedDate
     */
    public Attendance(String absenteeReportedBy, String absenteeDate,
            String absenteeDescription, String recordedBy, String recordedDate,
            String approvedBy, String approvedDate, String certifiedBy, String certifiedDate, String forDepartment, String approveStatus, String certifyStatus) {
        this.absenteeReportedBy = absenteeReportedBy;
        this.absenteeDate = absenteeDate;
        this.absenteeDescription = absenteeDescription;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.certifiedBy = certifiedBy;
        this.certifiedDate = certifiedDate;
        this.forDepartment = forDepartment;
        this.approveStatus = approveStatus;
        this.certifyStatus = certifyStatus;
    }

    /**
     * The constructor with the specified parameters
     * @param attendanceID the attendance identifier
     * @param absenteeReportedBy the employee who reported the attendance
     * @param absenteeDate the date the attendance is taken
     * @param absenteeDescription the description
     * @param recordedBy the employee who made the record
     * @param recordedDate the date the record is made
     * @param attendanceState
     * @param approvedBy
     * @param approvedDate
     * @param certifiedBy
     * @param certifiedDate
     */
    public Attendance(String attendanceID, String absenteeReportedBy, String absenteeDate,
            String absenteeDescription, String recordedBy, String recordedDate,
            String approvedBy, String approvedDate, String certifiedBy, String certifiedDate, String forDepartment, String approveStatus, String certifyStatus) {
        this.attendanceID = attendanceID;
        this.absenteeReportedBy = absenteeReportedBy;
        this.absenteeDate = absenteeDate;
        this.absenteeDescription = absenteeDescription;
        this.recordedBy = recordedBy;
        this.recordedDate = recordedDate;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.certifiedBy = certifiedBy;
        this.certifiedDate = certifiedDate;
        this.forDepartment = forDepartment;
        this.approveStatus = approveStatus;
        this.certifyStatus = certifyStatus;
    }

    /**
     * @return the attendanceID
     */
    public String getAttendanceID() {
        return attendanceID;
    }

    /**
     * @param attendanceID the attendanceID to set
     */
    public void setAttendanceID(String attendanceID) {
        this.attendanceID = attendanceID;
    }

    /**
     * @return the absenteeEmpId
     */
    public String getAbsenteeEmpId() {
        return absenteeEmpId;
    }

    /**
     * @param absenteeEmpId the absenteeEmpId to set
     */
    public void setAbsenteeEmpId(String absenteeEmpId) {
        this.absenteeEmpId = absenteeEmpId;
    }

    /**
     * @return the absenteeReportedBy
     */
    public String getAbsenteeReportedBy() {
        return absenteeReportedBy;
    }

    /**
     * @param absenteeReportedBy the absenteeReportedBy to set
     */
    public void setAbsenteeReportedBy(String absenteeReportedBy) {
        this.absenteeReportedBy = absenteeReportedBy;
    }

    /**
     * @return the absenteeDate
     */
    public String getAbsenteeDate() {
        return absenteeDate;
    }

    /**
     * @param absenteeDate the absenteeDate to set
     */
    public void setAbsenteeDate(String absenteeDate) {
        this.absenteeDate = absenteeDate;
    }

    /**
     * @return the absenteeDescription
     */
    public String getAbsenteeDescription() {
        return absenteeDescription;
    }

    /**
     * @param absenteeDescription the absenteeDescription to set
     */
    public void setAbsenteeDescription(String absenteeDescription) {
        this.absenteeDescription = absenteeDescription;
    }

    /**
     * @return the recordedBy
     */
    public String getRecordedBy() {
        return recordedBy;
    }

    /**
     * @param recordedBy the recordedBy to set
     */
    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    /**
     * @return the recordedDate
     */
    public String getRecordedDate() {
        return recordedDate;
    }

    /**
     * @param recordedDate the recordedDate to set
     */
    public void setRecordedDate(String recordedDate) {
        this.recordedDate = recordedDate;
    }

    /**
     * @return the attendanceState
     */
    public String getAttendanceState() {
        return attendanceState;
    }

    /**
     * @param attendanceState the attendanceState to set
     */
    public void setAttendanceState(String attendanceState) {
        this.attendanceState = attendanceState;
    }
    // </editor-fold>

    public ResultSet ReadEmployeeFromDepartment(String departmentID) {
        String qry = "SELECT *FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST WHERE DEPARTMENT_ID='" + departmentID + "'";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<HashMap> readAbsenceEmployee(String attendanceTakenDate, String requestId) {
        ArrayList<HashMap> listOfAbsent = new ArrayList<HashMap>();
        String qry = "SELECT ID, " +
                "  ATE.ATTENDANCETAKENDATE, " +
                "  ATE.ABSENTAMOUNT, " +
                "  ATE.ABSENTTYPE, " +
                "  ATE.STATUS, " +
                "  ATE.REGISTERDATE, " +
                "  ATE.REMARK, " +
                "  ATE.EMP_ID, " +
                "  ATE.DAYDESCRIPTION, " +
                "  ATE.TIMEKEEPERID, " +
                "  ATE.IMMEDIATEBOSSID, " +
                "  ATE.IMMEDIATEBOSSREMARK, " +
                "  ATE.HRAPPROVERID, " +
                "  EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.middle_Name " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAME " +
                "FROM HR_EMP_ATTENDANCE ATE, " +
                "  HR_EMPLOYEE_INFO EI " +
                "WHERE ATE.EMP_ID=EI.EMP_ID" +
                " AND ATE.ATTENDANCETAKENDATE=?" +
                " AND ATE.TIMEKEEPERID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _ps.setString(1, attendanceTakenDate);
            _ps.setString(2, requestId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("absenceId", _rs.getString("ID"));
                hm.put("ATTENDANCETAKENDATE", _rs.getString("ATTENDANCETAKENDATE"));
                hm.put("ABSENTAMOUNT", _rs.getString("ABSENTAMOUNT"));
                hm.put("ABSENTTYPE", _rs.getString("ABSENTTYPE"));
                hm.put("STATUS", _rs.getString("STATUS"));
                hm.put("REGISTERDATE", _rs.getString("REGISTERDATE"));
                hm.put("REMARK", _rs.getString("REMARK"));
                hm.put("DAYDESCRIPTION", _rs.getString("DAYDESCRIPTION"));
                hm.put("EMP_ID", _rs.getString("EMP_ID"));
                hm.put("FULLNAME", _rs.getString("FULLNAME"));
                listOfAbsent.add(hm);
            }
            return listOfAbsent;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    /**
     * Fetches all data from the hr_attendance and hr_employee_info tables to have
     * a complete information about the attendance and absentees based on the
     * attendance identifier
     * @param attendanceId the attendance identifier
     * @return a <code>ResultSet</code> object rs with active attendance record
     */
    public ResultSet readAttendance(String attendanceId) throws Exception {
        _con = getConnection();

        String str = "SELECT ALL hr_attendance.`attendance_Id`,   " +
                "hr_attendance.`absentee_Description`,   " +
                "hr_attendance.`absentee_Reported_By`,   " +
                "hr_attendance.`absentee_Date`,   " +
                "hr_attendance.`recorded_By`,   " +
                "hr_attendance.`recorded_Date`,   " +
                "hr_attendance.`certifiedBy`,   " +
                "(SELECT CONCAT(hr_employee_info.`first_Name`," +
                " hr_employee_info.`middle_Name`,hr_employee_info.`last_Name`)" +
                "FROM hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`certifiedBy`) as certName,   " +
                "(SELECT tbl_department.`description`   " +
                "FROM tbl_department, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`certifiedBy` AND hr_employee_info.`department_id` = tbl_department.`department_id`) as certDept,   " +
                "(SELECT hr_lu_title.`title_description`   " +
                "FROM hr_lu_title, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`certifiedBy` AND hr_employee_info.`title` = hr_lu_title.`title_id`) as certTitle,   " +
                "(SELECT hr_lu_job_type.`description`   " +
                "FROM hr_lu_job_type, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`certifiedBy` AND hr_employee_info.`job_Code` = hr_lu_job_type.`job_Code`) as certJob,   " +
                "hr_attendance.`approvedBy`,   " +
                "(SELECT CONCAT(hr_employee_info.`first_Name`,hr_employee_info.`middle_Name`,hr_employee_info.`last_Name`)   " +
                "FROM hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`approvedBy`) as appName,   " +
                "(SELECT tbl_department.`description`   " +
                "FROM tbl_department, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`approvedBy` AND hr_employee_info.`department_id` = tbl_department.`department_id`) as appDept,   " +
                "(SELECT hr_lu_title.`title_description`   " +
                "FROM hr_lu_title, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`approvedBy` AND hr_employee_info.`title` = hr_lu_title.`title_id`) as appTitle,   " +
                "(SELECT hr_lu_job_type.`description`   " +
                "FROM hr_lu_job_type, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`approvedBy` AND hr_employee_info.`job_Code` = hr_lu_job_type.`job_Code`) as appJob,   " +
                "hr_employee_info.`first_Name`,   " +
                "hr_employee_info.`middle_Name`,   " +
                "hr_employee_info.`last_Name`,   " +
                "hr_employee_info.`department_id`,   " +
                "(SELECT tbl_department.`description`   " +
                "FROM tbl_department, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`absentee_Reported_By` AND hr_employee_info.`department_id` = tbl_department.`department_id`) as reporterDept,   " +
                "(SELECT hr_lu_title.`title_description`   " +
                "FROM hr_lu_title, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`absentee_Reported_By` AND hr_employee_info.`title` = hr_lu_title.`title_id`) as reporterTitle,    " +
                "(SELECT hr_lu_job_type.`description`   " +
                "FROM hr_lu_job_type, hr_employee_info   " +
                "WHERE hr_employee_info.`emp_Id` = hr_attendance.`absentee_Reported_By` AND hr_employee_info.`job_Code` = hr_lu_job_type.`job_Code`) as reprterJob   " +
                "FROM hr_attendance, hr_employee_info   " +
                "WHERE hr_attendance.`absentee_Reported_By` = hr_employee_info.`emp_Id`   " +
                "AND hr_attendance.`attendance_Id` = ?";
        try {
            _ps = _con.prepareStatement(str);
            _ps.setString(1, attendanceId);

            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Fetches all data from the hr_attendance and hr_employee_info tables to have
     * a complete information about the attendance and absentees based on the specified
     * employee identifier
     * @param empId the employee identifier
     * @return a <code>ResultSet</code> object rs with active attendance record
     */
    public ResultSet readAttendanceByReporter(String empId, String type) throws Exception {
        _con = getConnection();

        String str = null;
        if (type.equalsIgnoreCase("all")) {

            str = "SELECT ALL hr_attendance.`attendance_Id`, " +
                    "hr_attendance.`absentee_Description`, " +
                    "hr_attendance.`absentee_Reported_By`, " +
                    "hr_attendance.`absentee_Date`, " +
                    "hr_attendance.`recorded_By`, " +
                    "hr_attendance.`recorded_Date`," +
                    "hr_employee_info.`first_Name`, " +
                    "hr_employee_info.`middle_Name`, " +
                    "hr_employee_info.`last_Name`, " +
                    "hr_employee_info.`department_id` " +
                    "FROM hr_attendance, hr_employee_info " +
                    "WHERE hr_attendance.`absentee_Reported_By` = hr_employee_info.`emp_Id` " +
                    "AND hr_attendance.`absentee_Reported_By` = '" + empId + "'";
        } else if (type.equalsIgnoreCase("reported")) {

            str = "SELECT ALL hr_attendance.`attendance_Id`, " +
                    "hr_attendance.`absentee_Description`, " +
                    "hr_attendance.`absentee_Reported_By`, " +
                    "hr_attendance.`absentee_Date`, " +
                    "hr_attendance.`recorded_By`, " +
                    "hr_attendance.`recorded_Date`," +
                    "hr_employee_info.`first_Name`, " +
                    "hr_employee_info.`middle_Name`, " +
                    "hr_employee_info.`last_Name`, " +
                    "hr_employee_info.`department_id` " +
                    "FROM hr_attendance, hr_employee_info " +
                    "WHERE hr_attendance.`absentee_Reported_By` = hr_employee_info.`emp_Id` " +
                    "AND hr_attendance.approvedBy is null";
        } else if (type.equalsIgnoreCase("approved")) {

            str = "SELECT ALL hr_attendance.`attendance_Id`, " +
                    "hr_attendance.`absentee_Description`, " +
                    "hr_attendance.`absentee_Reported_By`, " +
                    "hr_attendance.`absentee_Date`, " +
                    "hr_attendance.`recorded_By`, " +
                    "hr_attendance.`recorded_Date`," +
                    "hr_employee_info.`first_Name`, " +
                    "hr_employee_info.`middle_Name`, " +
                    "hr_employee_info.`last_Name`, " +
                    "hr_employee_info.`department_id` " +
                    "FROM hr_attendance, hr_employee_info " +
                    "WHERE hr_attendance.`absentee_Reported_By` = hr_employee_info.`emp_Id` " +
                    "AND hr_attendance.approvedBy is not null AND hr_attendance.certifiedBy is null";
        }

        _ps = _con.prepareStatement(str);
//            ps.setString(1, empId);

        _rs = _ps.executeQuery();
        return _rs;

    }

    /**
     * Fetches all data from the hr_attendance and hr_employee_info tables to have
     * a complete information about the attendance and absentees
     * @param absenceDate the attendance date
     * @return a <code>ResultSet</code> object rs with active attendance record
     */
    public ResultSet readAttendanceByDateAndDepartment(String val1, String val2) {

        String str = "SELECT *FROM HR_ATTENDANCE WHERE ABSENTEE_DATE= '" + val1 + "' AND FOR_DEPARTMENT='" + val2 + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet readAttendanceCheck() {

        String str = "SELECT ABSENTEE_DATE,FOR_DEPARTMENT FROM HR_ATTENDANCE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *  The method fetches attendance records, all columns, from the hr_attendance
     * table based on the given employee identifier and the date
     * @param attendanceEmpId the attendance identifier
     * @param attendanceDate the attendance date
     * @return a <code>ResultSet</code> object rs with active attendance record
     */
    public ResultSet readActiveAttendance(String attendanceEmpId, String attendanceDate) throws Exception {
        _con = getConnection();

        String str = "SELECT * FROM hr_attendance WHERE state='Active' AND " +
                "absentee_Emp_Id =? AND absentee_Date =?";

        try {
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The method fetches attendance records, all rows and columns, from the
     * hr_attendance table
     * @return a <code>ResultSet</code> object rs with attendance record
     */
    public ResultSet readAttendance() throws Exception {
        _con = getConnection();

        String str = "SELECT * FROM hr_attendance";

        try {
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The method inserts a row of attendance rocords into the hr_attendance table
     * in the database.
     * @return a <code>ResultSet</code> object that contains the data produced by the
     *         second query, the last inserted attendanceId; never <code>null</code>
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public ResultSet insertAttendance() throws Exception {
        String str = "INSERT INTO HR_ATTENDANCE (ATTENDANCE_ID, ABSENTEE_REPORTED_BY, ABSENTEE_DATE, " +
                " ABSENTEE_DESCRIPTION, RECORDED_BY, RECORDED_DATE,APPROVEDBY,APPROVEDDATE,CERTIFYBY,CERTIFYDATE,FOR_DEPARTMENT,APPROVE_STATUS,CERTIFY_STATUS) " +
                "values(SEQ_HR_ATTENDANCE.NEXTVAL, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        String str2 = "SELECT SEQ_HR_ATTENDANCE.CURRVAL AS ATTENDANCE_ID FROM  DUAL ";
        Savepoint a = null;
        ResultSet attendanceId = null;
        _con = getConnection();
        _con.setAutoCommit(false);
        a = _con.setSavepoint("savepoint_1");
        _ps = _con.prepareStatement(str);
        _ps.setString(1, getAbsenteeReportedBy());
        _ps.setString(2, getAbsenteeDate());
        _ps.setString(3, getAbsenteeDescription());
        _ps.setString(4, getRecordedBy());
        _ps.setString(5, getRecordedDate());
        _ps.setString(6, getApprovedBy());
        _ps.setString(7, getApprovedDate());
        _ps.setString(8, getCertifiedBy());
        _ps.setString(9, getCertifiedDate());
        _ps.setString(10, getForDepartment());
        _ps.setString(11, getApproveStatus());
        _ps.setString(12, getCertifyStatus());
        int row1 = _ps.executeUpdate();
        if (row1 == 1) {
            _con.commit();
            _con.setAutoCommit(true);
            PreparedStatement ps2 = _con.prepareStatement(str2);
            attendanceId = ps2.executeQuery();
            return attendanceId;

        } else {
            _con.rollback(a);
            _con.setAutoCommit(true);
            return null;
        }
    }

    /**
     * The method makes changes in the hr_attendance table in the database
     * @return either (1) the row count for SQL UPDATE statement
     *         or (2) 0 if the SQL UPDATE statement returns nothing
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int approveAttendance() throws Exception {
        _con = getConnection();
        _con.setAutoCommit(true);
        String str = "UPDATE HR_ATTENDANCE SET APPROVEDBY = ?, APPROVEDDATE = ?, APPROVE_STATUS = ? WHERE ATTENDANCE_ID = ? ";
        _ps = _con.prepareStatement(str);
        _ps.setString(1, getVal2());
        _ps.setString(2, getVal3());
        _ps.setString(3, getVal4());
        _ps.setString(4, getVal1());
        int row = _ps.executeUpdate();
        return row;
    }

    public int certifyAttendance() throws Exception {
        _con = getConnection();
        _con.setAutoCommit(true);
        String str = "UPDATE HR_ATTENDANCE SET CERTIFYBY = ?, CERTIFYDATE = ?, CERTIFY_STATUS = ? WHERE ATTENDANCE_ID = ? ";
        _ps = _con.prepareStatement(str);
        _ps.setString(1, getVal2());
        _ps.setString(2, getVal3());
        _ps.setString(3, getVal4());
        _ps.setString(4, getVal1());
        int row = _ps.executeUpdate();
        return row;
    }

    /**
     * The method removes a row of data, attendace record, from the hr_attendance
     * table based on the attendance identifier
     * @param attendanceId the unique attendance record identifier
     * @return either true or false, based on the value of the executeUpdate method
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public boolean deleteAttendance(String attendanceID) throws Exception {
        _con = getConnection();

        String str = "DELETE FROM HR_EMP_ATTENDANCE WHERE ID=?";

        _ps = _con.prepareStatement(str);
        _ps.setString(1, attendanceID);

        if (_ps.executeUpdate() != 0) {
            return true;
        }
        return false;

    }

    /**
     * @return the approvedBy
     */
    public String getApprovedBy() {
        return approvedBy;
    }

    /**
     * @param approvedBy the approvedBy to set
     */
    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    /**
     * @return the approvedDate
     */
    public String getApprovedDate() {
        return approvedDate;
    }

    /**
     * @param approvedDate the approvedDate to set
     */
    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    /**
     * @return the certifiedBy
     */
    public String getCertifiedBy() {
        return certifiedBy;
    }

    /**
     * @param certifiedBy the certifiedBy to set
     */
    public void setCertifiedBy(String certifiedBy) {
        this.certifiedBy = certifiedBy;
    }

    /**
     * @return the certifiedDate
     */
    public String getCertifiedDate() {
        return certifiedDate;
    }

    /**
     * @param certifiedDate the certifiedDate to set
     */
    public void setCertifiedDate(String certifiedDate) {
        this.certifiedDate = certifiedDate;
    }

    public ArrayList<Attendance> readAttendanceRequests() {
        String _select = " SELECT HR_ATTENDANCE.ABSENTEE_DATE,HR_ATTENDANCE.FOR_DEPARTMENT AS DEPARTMENT_ID,TBL_DEPARTMENT.DEP_DESCRIPTION AS DEPARTMENT" +
                " FROM HR_ATTENDANCE INNER JOIN TBL_DEPARTMENT ON HR_ATTENDANCE.FOR_DEPARTMENT=TBL_DEPARTMENT.DEPT_ID WHERE APPROVE_STATUS='01' OR CERTIFY_STATUS='01'";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        ArrayList<Attendance> attendances = new ArrayList<Attendance>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                Attendance attendancesList = new Attendance(_rs.getString("ABSENTEE_DATE"), _rs.getString("DEPARTMENT_ID"), _rs.getString("ABSENTEE_DATE"), _rs.getString("DEPARTMENT"));
                attendances.add(attendancesList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                getConnection();
            } catch (Exception ignore) {
            }
        }
        return attendances;
    }

    public ArrayList<Attendance> readAttendanceProcessed() {
        String _select = " SELECT HR_ATTENDANCE.ABSENTEE_DATE,HR_ATTENDANCE.FOR_DEPARTMENT AS DEPARTMENT_ID,TBL_DEPARTMENT.DEP_DESCRIPTION AS DEPARTMENT" +
                " FROM HR_ATTENDANCE INNER JOIN TBL_DEPARTMENT ON HR_ATTENDANCE.FOR_DEPARTMENT=TBL_DEPARTMENT.DEPT_ID WHERE APPROVE_STATUS='02' AND CERTIFY_STATUS='02'";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        ArrayList<Attendance> attendances = new ArrayList<Attendance>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                Attendance attendancesList = new Attendance(_rs.getString("ABSENTEE_DATE"), _rs.getString("DEPARTMENT_ID"), _rs.getString("ABSENTEE_DATE"), _rs.getString("DEPARTMENT"));
                attendances.add(attendancesList);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                getConnection();
            } catch (Exception ignore) {
            }
        }
        return attendances;
    }

    public boolean saveAttendance(ArrayList<HashMap> listOfAbsent,
            String timekeeper) throws Exception {
        try {
            boolean checkStatus = false;
            String insertQuery = "INSERT " +
                    "INTO HR_EMP_ATTENDANCE " +
                    "  ( " +
                    "    ATTENDANCETAKENDATE, " +
                    "    ABSENTAMOUNT, " +
                    "    ABSENTTYPE, " +
                    "    STATUS, " +
                    "    REGISTERDATE, " +
                    "    EMP_ID," +
                    "   DAYDESCRIPTION," +
                    "   TIMEKEEPERID " +
                    "  ) " +
                    "  VALUES " +
                    "  ( " +
                    "    ?, " +
                    "    ?, " +
                    "    ?, " +
                    "    'Req', " +
                    "    CURRENT_TIMESTAMP, " +
                    "    ?," +
                    "    ?," +
                    "    ? " +
                    "  )";
            _con = getConnection();
            _ps = _con.prepareStatement(insertQuery);
            for (HashMap hm : listOfAbsent) {
                _ps.setString(1, hm.get("absentDate").toString());
                _ps.setString(2, hm.get("AbsentAmout").toString());
                _ps.setString(3, hm.get("AbsentType").toString());
                _ps.setString(4, hm.get("employeeId").toString());
                _ps.setString(5, hm.get("DayDescription").toString());
                _ps.setString(6, timekeeper);
                if (_ps.executeUpdate() <= 0) {
                    return false;
                }
                checkStatus = true;
            }
            if (checkStatus) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            releaseResources();
        }
    }

    public boolean updateAttendance(HashMap attendanceInfo, String timeKeeperId) throws Exception {
        _con = getConnection();
        String strQuery = "UPDATE HR_EMP_ATTENDANCE " +
                "SET ATTENDANCETAKENDATE = ?, " +
                "  ABSENTAMOUNT          = ?, " +
                "  ABSENTTYPE            = ?, " +
                "  DAYDESCRIPTION        =?, " +
                "  TIMEKEEPERID          =? " +
                "WHERE ID                = ?";
        _con = getConnection();
        _ps = _con.prepareStatement(strQuery);
        _ps.setString(1, attendanceInfo.get("absentDate").toString());
        _ps.setString(2, attendanceInfo.get("AbsentAmout").toString());
        _ps.setString(3, attendanceInfo.get("AbsentType").toString());
        _ps.setString(4, attendanceInfo.get("DayDescription").toString());
        _ps.setString(5, timeKeeperId);
        _ps.setString(6, attendanceInfo.get("absentId").toString());
        if (_ps.executeUpdate() > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean saveMonthlyWorkingDate(String month, String startDate,
            String endDate) throws Exception {
        try {

            String insertQuery = "INSERT " +
                    "INTO HR_MONTHLY_ABSENTDATE " +
                    "  ( " +
                    "    MONTH, " +
                    "    DATEFROM, " +
                    "    DATETO ," +
                    "    YEAR" +
                    "  ) " +
                    "  VALUES " +
                    "  ( " +
                    "    ?, " +
                    "    ?, " +
                    "    ?," +
                    "    ? " +
                    "  )";
            _con = getConnection();
            _ps = _con.prepareStatement(insertQuery);
            _ps.setString(1, month);
            _ps.setString(2, startDate);
            _ps.setString(3, endDate);
            _ps.setString(4, endDate.substring(0, 4));
            if (_ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        } finally {
            releaseResources();
        }
    }
}
