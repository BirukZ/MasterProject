/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.docreport;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Up
 */
public class DocReportEntity extends ConnectionManager {

    private String requesterId;
    private String requesterFullName;
    private String requesterJob;
    private String requesterDept;
    private String requestedDocType;
    private String requestedDate;
    private String requestedDocNum;
    private String reason;
    private String issuedDate;
    private String approverId;
    private String approverFullName;
    private String approverJob;
    private String approverDept;

    /**
     * @return the requesterId
     */
    public String getRequesterId() {
        return requesterId;
    }

    /**
     * @param requesterId the requesterId to set
     */
    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    /**
     * @return the requesterFullName
     */
    public String getRequesterFullName() {
        return requesterFullName;
    }

    /**
     * @param requesterFullName the requesterFullName to set
     */
    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    /**
     * @return the requesterJob
     */
    public String getRequesterJob() {
        return requesterJob;
    }

    /**
     * @param requesterJob the requesterJob to set
     */
    public void setRequesterJob(String requesterJob) {
        this.requesterJob = requesterJob;
    }

    /**
     * @return the requesterDept
     */
    public String getRequesterDept() {
        return requesterDept;
    }

    /**
     * @param requesterDept the requesterDept to set
     */
    public void setRequesterDept(String requesterDept) {
        this.requesterDept = requesterDept;
    }

    /**
     * @return the requestedDocType
     */
    public String getRequestedDocType() {
        return requestedDocType;
    }

    /**
     * @param requestedDocType the requestedDocType to set
     */
    public void setRequestedDocType(String requestedDocType) {
        this.requestedDocType = requestedDocType;
    }

    /**
     * @return the requestedDate
     */
    public String getRequestedDate() {
        return requestedDate;
    }

    /**
     * @param requestedDate the requestedDate to set
     */
    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    /**
     * @return the requestedDocNum
     */
    public String getRequestedDocNum() {
        return requestedDocNum;
    }

    /**
     * @param requestedDocNum the requestedDocNum to set
     */
    public void setRequestedDocNum(String requestedDocNum) {
        this.requestedDocNum = requestedDocNum;
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
     * @return the issuedDate
     */
    public String getIssuedDate() {
        return issuedDate;
    }

    /**
     * @param issuedDate the issuedDate to set
     */
    public void setIssuedDate(String issuedDate) {
        this.issuedDate = issuedDate;
    }

    /**
     * @return the approverId
     */
    public String getApproverId() {
        return approverId;
    }

    /**
     * @param approverId the approverId to set
     */
    public void setApproverId(String approverId) {
        this.approverId = approverId;
    }

    /**
     * @return the approverFullName
     */
    public String getApproverFullName() {
        return approverFullName;
    }

    /**
     * @param approverFullName the approverFullName to set
     */
    public void setApproverFullName(String approverFullName) {
        this.approverFullName = approverFullName;
    }

    /**
     * @return the approverJob
     */
    public String getApproverJob() {
        return approverJob;
    }

    /**
     * @param approverJob the approverJob to set
     */
    public void setApproverJob(String approverJob) {
        this.approverJob = approverJob;
    }

    /**
     * @return the approverDept
     */
    public String getApproverDept() {
        return approverDept;
    }

    /**
     * @param approverDept the approverDept to set
     */
    public void setApproverDept(String approverDept) {
        this.approverDept = approverDept;
    }

    public DocReportEntity() {
    }

    public DocReportEntity(
            String requesterId,
            String requesterFullName,
            String requesterJob,
            String requesterDept,
            String requestedDocType,
            String requestedDate,
            String requestedDocNum,
            String reason, String issuedDate,
            String approverId,
            String approverFullName,
            String approverJob,
            String approverDept) {
        this.requesterId = requesterId;
        this.requesterFullName = requesterFullName;
        this.requesterJob = requesterJob;
        this.requesterDept = requesterDept;
        this.requestedDocType = requestedDocType;
        this.requestedDate = requestedDate;
        this.requestedDocNum = requestedDocNum;
        this.reason = reason;
        this.issuedDate = issuedDate;
        this.approverId = approverId;
        this.approverFullName = approverFullName;
        this.approverJob = approverJob;
        this.approverDept = approverDept;
    }

    public ArrayList<HashMap> getDocRequesteReportDate(ArrayList<HashMap> reportParameters) throws SQLException {
        ArrayList<HashMap> docRequestReportData = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT DR.REQUESTER_ID, E.FIRST_NAME, E.MIDDLE_NAME, E.LAST_NAME, E.DEPARTMENT_ID, " +
                "D.DEP_DESCRIPTION, E.JOB_CODE, J.JOB_DESCRIPTION,  " +
                "DR.DOCUMENT_CATAGORY, DR.APPLIED_DATE, DR.DOC_REFERENCE_NUMBER, " +
                "DR.REASON, DR.ISSUE_DATE, DRP.PROCESSED_BY, (SELECT (EMP.FIRST_NAME || ' ' || " +
                "EMP.MIDDLE_NAME || ' ' || EMP.LAST_NAME) FROM HR_EMPLOYEE_INFO EMP " +
                "WHERE EMP.EMP_ID = DRP.PROCESSED_BY) AS APPFULLNAME , " +
                "(SELECT AJ.JOB_DESCRIPTION FROM HR_EMPLOYEE_INFO EMP, " +
                "HR_LU_JOB_TYPE AJ WHERE EMP.EMP_ID = DRP.PROCESSED_BY " +
                "AND AJ.JOB_CODE = EMP.JOB_CODE) AS APPJOB, " +
                "(SELECT AD.DEP_DESCRIPTION FROM HR_EMPLOYEE_INFO EMP, " +
                "TBL_DEPARTMENT AD WHERE EMP.EMP_ID = DRP.PROCESSED_BY " +
                "AND AD.DEPT_ID = EMP.DEPARTMENT_ID) as appDept " +
                "FROM HR_EMPLOYEE_INFO E, HR_DOCUMENT_REQUEST DR,  " +
                "TBL_DEPARTMENT D, HR_LU_JOB_TYPE J, HR_DOCUMENT_REQUEST_PROCESSED DRP " +
                "WHERE E.EMP_ID = DR.REQUESTER_ID AND D.DEPT_ID = E.DEPARTMENT_ID AND J.JOB_CODE " +
                "= E.JOB_CODE AND DRP.REQUEST_ID = DR.DOCUMENT_REQUEST_ID AND DR.STATUS LIKE 'App%'";
        if (reportParameters != null) {
            for (HashMap hm : reportParameters) {
                select += " AND DR.APPLIED_DATE BETWEEN " + hm.get("startDate".toString()) + " AND " +
                        hm.get("endDate".toString());
            }
        }
        con = getConnection();
        ps = con.prepareStatement(select);
        rs = (ResultSet) ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(rs);
//            rs.close();
//            ps.close();
        while (ocrs.next()) {
            HashMap hm = new HashMap();
            hm.put("requesterId", ocrs.getString("REQUESTER_ID"));
            hm.put("requesterFullName", ocrs.getString("FIRST_NAME") + " " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME"));
            hm.put("deptId", ocrs.getString("DEPARTMENT_ID"));
            hm.put("requesterDept", ocrs.getString("DEP_DESCRIPTION"));
            hm.put("jobId", ocrs.getString("JOB_CODE"));
            hm.put("requesterJob", ocrs.getString("JOB_DESCRIPTION"));
            hm.put("requestedDocType", ocrs.getString("DOCUMENT_CATAGORY"));
            hm.put("requestedDate", ocrs.getString("APPLIED_DATE"));
            hm.put("requestedDocNum", ocrs.getString("DOC_REFERENCE_NUMBER"));
            hm.put("reason", ocrs.getString("REASON"));
            hm.put("issuedDate", ocrs.getString("ISSUE_DATE"));
            hm.put("approverId", ocrs.getString("PROCESSED_BY"));
            hm.put("approverFullName", ocrs.getString("APPFULLNAME"));
            hm.put("approverDept", ocrs.getString("appDept"));
            hm.put("approverJob", ocrs.getString("APPJOB"));

            docRequestReportData.add(hm);
        }
        closePooledConnections(con);
        return docRequestReportData;
    }
}
