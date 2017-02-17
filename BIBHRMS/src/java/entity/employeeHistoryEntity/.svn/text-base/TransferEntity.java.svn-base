/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

//import connectionProvider.ConnectionInfo;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class TransferEntity extends ConnectionManager {

    private int transferId;
    private String employeeId;
    private String fromDepartement;
    private String toDepartement;
    private String requesteDate;
    private String reason;
    private String letterNo;
    private String letterRefNo;
    private String checkedBy;
    private String checkedDate;
    private String approvedBy;
    private String approvalDate;
    private String status;
    private String approvalComment;
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

    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param employeeId the employee identifier
     * @param fromDepartement the current department of the employee
     * @param toDepartement the destination department
     * @param requesteDate the date the request is made
     * @param reason the reason for requesting transfer if there is any
     */
    public TransferEntity(String employeeId, String fromDepartement, String toDepartement, String requesteDate, String reason) {
        this.employeeId = employeeId;
        this.fromDepartement = fromDepartement;
        this.toDepartement = toDepartement;
        this.requesteDate = requesteDate;
        this.reason = reason;
    }

    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param transferid the unique transfer identifier
     * @param approvedBy the employee id who made the approval
     * @param approvalDate the date the approval is made
     * @param status the status of the transfer process
     * @param approvalComment the comment given to transfer
     */
    public TransferEntity(int transferid, String approvedBy, String approvalDate, String status, String approvalComment) {
        this.transferId = transferid;
        this.approvedBy = approvedBy;
        this.approvalDate = approvalDate;
        this.setStatus(status);
        this.setApprovalComment(approvalComment);
    }

    /**
     * The default constructor
     */
    public TransferEntity() {
    }

    /**
     * The constructor is used to instatiate the class with the specified parameters
     * @param transferId the unique transfer record identifier
     * @param employeeId the employee identifier
     * @param fromDepartement the current department of the employee
     * @param toDepartement the destination department
     * @param requesteDate the date the request is made
     * @param reason the reason for requesting transfer if there is any
     * @param checkedBy the employee who checked the request
     * @param checkedDate the date the request is checked
     * @param approvedBy the employee who approved the request
     * @param approvalDate the date the approval is made
     */
    public TransferEntity(int transferId, String employeeId, String fromDepartement, String toDepartement, String requesteDate, String reason, String checkedBy, String checkedDate, String approvedBy, String approvalDate) {
        this.transferId = transferId;
        this.employeeId = employeeId;
        this.fromDepartement = fromDepartement;
        this.toDepartement = toDepartement;
        this.requesteDate = requesteDate;
        this.reason = reason;
        this.checkedBy = checkedBy;
        this.checkedDate = checkedDate;
        this.approvedBy = approvedBy;
        this.approvalDate = approvalDate;
    }

    /**
     * The method fetches a complete transfer information from the hr_emp_transfer,
     * and tbl_department to find the source and destination department as well as
     * the requeter and the approver information.
     * @param transferId the unique transfer identifier
     * @return a <code>ResultSet</code> object with information of the transfer and
     * the envolved employees, either by requesting or approving.
     */
    public ResultSet readTransferRecods(String transferId) throws Exception {

        _ps = getConnection().prepareStatement("" +
                "SELECT ALL hr_emp_transfer.transfer_Id,  " +
                "hr_emp_transfer.APPROVED_DATE,   " +
                "hr_emp_transfer.transfered_From,   " +
                "hr_emp_transfer.transfered_To,   " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_From) as sourceDept,  " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_To) as destinationDept,  " +
                "hr_emp_transfer.reference_No,   " +
                "hr_emp_transfer.reference_Date,   " +
                "hr_emp_transfer.transfer_Date,   " +
                "hr_emp_transfer.request_Date,   " +
                "hr_emp_transfer.reason,   " +
                "hr_emp_transfer.APPROVED_BY, " +
                "(SELECT first_Name || ' ' || middle_Name || ' ' ||" +
                "last_Name FROM hr_employee_info  " +
                "WHERE hr_employee_info.emp_Id = hr_emp_transfer.APPROVED_BY) as actionByName,  " +
                "hr_emp_transfer.STATUS,   " +
                "hr_emp_transfer.CHECKED_DATE, " +
                "hr_employee_info.emp_Id,   " +
                "hr_employee_info.first_Name,  " +
                "hr_employee_info.middle_Name,   " +
                "hr_employee_info.last_Name,   " +
                "hr_employee_info.department_id,  " +
                "(SELECT HR_LU_JOB_TYPE.JOB_DESCRIPTION FROM  " +
                "HR_LU_JOB_TYPE WHERE  " +
                "HR_LU_JOB_TYPE.JOB_CODE = hr_employee_info.JOB_CODE) as empJob,  " +
                "(SELECT HR_LU_TITLE.TITLE_DESCRIPTION FROM  " +
                "HR_LU_TITLE WHERE  " +
                "HR_LU_TITLE.TITLE_ID = hr_employee_info.TITLE) as empTitle,  " +
                "hr_emp_transfer.emp_Id   " +
                "FROM hr_emp_transfer  " +
                "INNER JOIN hr_employee_info ON hr_emp_transfer.emp_Id =  " +
                "hr_employee_info.emp_Id  " +
                "WHERE hr_emp_transfer.transfer_Id = '" + transferId + "'");
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return (ResultSet) ocrs;
    }

    /**
     * The method fetches a complete transfer information from the hr_emp_transfer,
     * and tbl_department to find the source and destination department as well as
     * the requeter and the approver information.
     * @param empId the identifier of the employee who is transfered
     * @return a <code>ResultSet</code> object with information of the transfer and
     * the envolved employees, either by requesting or approving.
     */
    public ResultSet readTransferRecodsByEmpId(String empId) throws Exception {

        _ps = getConnection().prepareStatement("" +
                "SELECT ALL hr_emp_transfer.transfer_Id,  " +
                "hr_emp_transfer.APPROVED_DATE,   " +
                "hr_emp_transfer.transfered_From,   " +
                "hr_emp_transfer.transfered_To,   " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_From) as sourceDept,  " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_To) as destinationDept,  " +
                "hr_emp_transfer.reference_No,   " +
                "hr_emp_transfer.reference_Date,   " +
                "hr_emp_transfer.transfer_Date,   " +
                "hr_emp_transfer.request_Date,   " +
                "hr_emp_transfer.reason,   " +
                "hr_emp_transfer.APPROVED_BY, " +
                "(SELECT first_Name || ' ' || middle_Name || ' ' ||" +
                "last_Name FROM hr_employee_info  " +
                "WHERE hr_employee_info.emp_Id = hr_emp_transfer.APPROVED_BY) as actionByName,  " +
                "hr_emp_transfer.STATUS,   " +
                "hr_emp_transfer.CHECKED_DATE, " +
                "hr_employee_info.emp_Id,   " +
                "hr_employee_info.first_Name,  " +
                "hr_employee_info.middle_Name,   " +
                "hr_employee_info.last_Name,   " +
                "hr_employee_info.department_id,  " +
                "hr_emp_transfer.emp_Id   " +
                "FROM hr_emp_transfer  " +
                "INNER JOIN hr_employee_info ON hr_emp_transfer.emp_Id =  " +
                "hr_employee_info.emp_Id  " +
                "WHERE hr_emp_transfer.EMP_ID = '" + empId + "'");
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return (ResultSet) ocrs;
    }

    /**
     * The method fetches a complete transfer information from the hr_emp_transfer,
     * and tbl_department to find the source and destination department. Note
     * only new transfer and transfers that are left without without decisions are fetched.
     * @return a <code>ResultSet</code> object with information of the transfer and
     * the envolved employees, either by requesting or approving.
     */
    public ResultSet readNewTransferRecods() throws Exception {

        _ps = getConnection().prepareStatement("" +
                "SELECT ALL hr_emp_transfer.transfer_Id,  " +
                "hr_emp_transfer.APPROVED_DATE,   " +
                "hr_emp_transfer.transfered_From,   " +
                "hr_emp_transfer.transfered_To,   " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_From) as sourceDept,  " +
                "(SELECT tbl_department.DEP_DESCRIPTION FROM  " +
                "tbl_department WHERE  " +
                "tbl_department.DEPT_ID = hr_emp_transfer.transfered_To) as destinationDept,  " +
                "hr_emp_transfer.reference_No,   " +
                "hr_emp_transfer.reference_Date,   " +
                "hr_emp_transfer.transfer_Date,   " +
                "hr_emp_transfer.request_Date,   " +
                "hr_emp_transfer.reason,   " +
                "hr_emp_transfer.APPROVED_BY, " +
                "(SELECT first_Name || ' ' || middle_Name || ' ' ||" +
                "last_Name FROM hr_employee_info  " +
                "WHERE hr_employee_info.emp_Id = hr_emp_transfer.APPROVED_BY) as actionByName,  " +
                "hr_emp_transfer.STATUS,   " +
                "hr_emp_transfer.CHECKED_DATE, " +
                "hr_employee_info.emp_Id,   " +
                "hr_employee_info.first_Name,  " +
                "hr_employee_info.middle_Name,   " +
                "hr_employee_info.last_Name,   " +
                "hr_employee_info.department_id,  " +
                "hr_emp_transfer.emp_Id   " +
                "FROM hr_emp_transfer  " +
                "INNER JOIN hr_employee_info ON hr_emp_transfer.emp_Id =  " +
                "hr_employee_info.emp_Id  " +
                "WHERE hr_emp_transfer.STATUS = 0");
        _rs = _ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(_rs);
        return (ResultSet) ocrs;
    }

    /**
     * The method inserts a row of data into hr_emp_transfer table.
     * @param employeeid the unique employee identifier
     * @param requestdate the date the request is made
     * @param fromDepartment the source department
     * @param todepartement the destination department
     * @param reason the reason of transfer
     * @return  either (1) the row count for the result of INSERT statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int addTransferRequest(TransferEntity transferEntity) throws Exception {
        String str = "INSERT INTO hr_emp_transfer(TRANSFER_ID, emp_Id, request_Date, " +
                "transfered_From, transfered_To, reason) values(SEQ_HISTORY.NEXTVAL, ?, ?, ?, ?, ?)";

        _ps = getConnection().prepareStatement(str);
        _ps.setString(1, transferEntity.getEmployeeId());
        _ps.setString(2, transferEntity.getRequesteDate());
        _ps.setString(3, transferEntity.getFromDepartement());
        _ps.setString(4, transferEntity.getToDepartement());
        _ps.setString(5, transferEntity.getReason());

        int i = _ps.executeUpdate();
        return i;
    }

    /**
     * The method makes changes in the hr_emp_transfer table with the information
     * from the parameters.
     * @param empId the employee identifier.
     * @param requestDate the date the request is made.
     * @param reason the reason of the transfer.
     * @param toDepartement the destination department.
     */
    public int updateTransferRequest(TransferEntity transferEntity) throws Exception {
        String str = ("UPDATE hr_emp_transfer set emp_id = ?, request_Date=?, " +
                "reason=?, transfered_From=?, transfered_To_Dept=?, approved_By = ?, " +
                "approved_Date = ?, checked_By = ?, checked_Date = ?" +
                "WHERE transfer_Id = '" + transferEntity.getEmployeeId() + "'");

        _ps = getConnection().prepareStatement(str);
        _ps.setString(1, transferEntity.getEmployeeId());
        _ps.setString(2, transferEntity.getRequesteDate());
        _ps.setString(3, transferEntity.getReason());
        _ps.setString(4, transferEntity.getFromDepartement());
        _ps.setString(5, transferEntity.getToDepartement());
        _ps.setString(6, transferEntity.getApprovedBy());
        _ps.setString(7, transferEntity.getApprovalDate());
        _ps.setString(8, transferEntity.getCheckedBy());
        _ps.setString(9, transferEntity.getCheckedDate());
        return _ps.executeUpdate();
    }

    /**
     * The method removes a row of data from the hr_emp_transfer table
     * @param transferId the unique transfer identifier
     * @return either (1) the row count for the result of delete statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int deleteTransferRequest(String transferId) throws Exception {
        String str = "DELETE FROM hr_emp_transfer WHERE transfer_Id='" + transferId + "'";
        _ps = getConnection().prepareStatement(str);
        return _ps.executeUpdate();
    }

    /**
     * The method makes changes in the transfer request information by updating
     * the approval information.
     * @param empTransfer the employee making the transfer
     * @return either (1) the row count for the result of update statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int updateTransferApproval(TransferEntity empTransfer) throws Exception {
        String str = ("UPDATE hr_emp_transfer set STATUS=?, " +
                "APPROVER_COMMENT=?, approved_Date=?, approved_By=? " +
                "where transfer_Id='" + empTransfer.getTransferId() + "'");

        _ps = getConnection().prepareStatement(str);
        _ps.setString(1, empTransfer.getStatus());
        _ps.setString(2, empTransfer.getApprovalComment());
        _ps.setString(3, empTransfer.getApprovalDate());
        _ps.setString(4, empTransfer.getApprovedBy());
        return _ps.executeUpdate();
    }

    /**
     * @return the transferId
     */
    public int getTransferId() {
        return transferId;
    }

    /**
     * @param transferId the transferId to set
     */
    public void setTransferId(int transferId) {
        this.transferId = transferId;
    }

    /**
     * @return the employeeId
     */
    public String getEmployeeId() {
        return employeeId;
    }

    /**
     * @param employeeId the employeeId to set
     */
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * @return the fromDepartement
     */
    public String getFromDepartement() {
        return fromDepartement;
    }

    /**
     * @param fromDepartement the fromDepartement to set
     */
    public void setFromDepartement(String fromDepartement) {
        this.fromDepartement = fromDepartement;
    }

    /**
     * @return the toDepartement
     */
    public String getToDepartement() {
        return toDepartement;
    }

    /**
     * @param toDepartement the toDepartement to set
     */
    public void setToDepartement(String toDepartement) {
        this.toDepartement = toDepartement;
    }

    /**
     * @return the requesteDate
     */
    public String getRequesteDate() {
        return requesteDate;
    }

    /**
     * @param requesteDate the requesteDate to set
     */
    public void setRequesteDate(String requesteDate) {
        this.requesteDate = requesteDate;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the letterNo
     */
    public String getLetterNo() {
        return letterNo;
    }

    /**
     * @param letterNo the letterNo to set
     */
    public void setLetterNo(String letterNo) {
        this.letterNo = letterNo;
    }

    /**
     * @return the letterRefNo
     */
    public String getLetterRefNo() {
        return letterRefNo;
    }

    /**
     * @param letterRefNo the letterRefNo to set
     */
    public void setLetterRefNo(String letterRefNo) {
        this.letterRefNo = letterRefNo;
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
     * @return the approvalDate
     */
    public String getApprovalDate() {
        return approvalDate;
    }

    /**
     * @param approvalDate the approvalDate to set
     */
    public void setApprovalDate(String approvalDate) {
        this.approvalDate = approvalDate;
    }

    /**
     * @return the checkedBy
     */
    public String getCheckedBy() {
        return checkedBy;
    }

    /**
     * @param checkedBy the checkedBy to set
     */
    public void setCheckedBy(String checkedBy) {
        this.checkedBy = checkedBy;
    }

    /**
     * @return the checkedDate
     */
    public String getCheckedDate() {
        return checkedDate;
    }

    /**
     * @param checkedDate the checkedDate to set
     */
    public void setCheckedDate(String checkedDate) {
        this.checkedDate = checkedDate;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the approvalComment
     */
    public String getApprovalComment() {
        return approvalComment;
    }

    /**
     * @param approvalComment the approvalComment to set
     */
    public void setApprovalComment(String approvalComment) {
        this.approvalComment = approvalComment;
    }
}
