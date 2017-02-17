/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DPClone
 */
public class TrainingApprovalEntity extends ConnectionManager{
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

    private String trainingApprovalId;
    private String approved_by;
    private String trainingRequestId;
    private String approved_date;
    private String approvedFromDate;
    private String approvedToDate;
    private String remark;
    

    /**
     *
     */
    public TrainingApprovalEntity() {
    }

    /**
     *
     * @param approved_by
     * @param trainingRequestId
     * @param approved_date
     * @param approvedFromDate
     * @param approvedToDate
     * @param remark
     */
    private int requestId;//@Column(name = "REQUEST_ID")
    private String processedBy;//    @Column(name = "PROCESSED_BY")
    private String decision;//@Column(name = "DECISION")
    private String commentGiven;//@Column(name = "COMMENT_GIVEN")
    private String recordedBy;//@Column(name = "RECORDED_BY")
    private String timeStamp;//@Column(name = "RECORDED_DATE_AND_TIME")
    private String status;


    public TrainingApprovalEntity(String approved_by, String trainingRequestId, String approved_date, String approvedFromDate, String approvedToDate, String remark) {
        this.approved_by = approved_by;
        this.trainingRequestId = trainingRequestId;
        this.approved_date = approved_date;
        this.approvedFromDate = approvedFromDate;
        this.approvedToDate = approvedToDate;
        this.remark = remark;
    }

    /**
     *
     * @param approved_by
     * @param approved_date
     * @param approved_from_date
     * @param approved_to_date
     * @param request_id
     * @param remark
     * @throws java.sql.SQLException
     */
    public void addTrainingModification(String approved_by, String approved_date,
            String approved_from_date, String approved_to_date, String request_id, String remark) throws SQLException {
        this.setApproved_by(approved_by);
        this.setApproved_date(approved_date);
        this.setApprovedFromDate(approved_from_date);
        this.setApprovedToDate(approved_to_date);
        this.setTrainingRequestId(request_id);
        this.setRemark(remark);
        insertTrainingModification();
    }
 public TrainingApprovalEntity(int requestId, String processedBy, String decision, String requestStatus, String comment,String recorededDateAndTime) {
     this.requestId=requestId;
     this.processedBy=processedBy;
     this.decision=decision;
     this.status=requestStatus;
     this.commentGiven=comment;
     this.timeStamp=recorededDateAndTime;

    }



    /**
     * @return the trainingApprovalId
     */
    public String getTrainingApprovalId() {
        return trainingApprovalId;
    }

    /**
     * @param trainingApprovalId the trainingApprovalId to set
     */
    public void setTrainingApprovalId(String trainingApprovalId) {
        this.trainingApprovalId = trainingApprovalId;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the approved_by
     */
    public String getApproved_by() {
        return approved_by;
    }

    /**
     * @param approved_by the approved_by to set
     */
    public void setApproved_by(String approved_by) {
        this.approved_by = approved_by;
    }

    /**
     * @return the trainingRequestId
     */
    public String getTrainingRequestId() {
        return trainingRequestId;
    }

    /**
     * @param trainingRequestId the trainingRequestId to set
     */
    public void setTrainingRequestId(String trainingRequestId) {
        this.trainingRequestId = trainingRequestId;
    }

    /**
     * @return the approved_date
     */
    public String getApproved_date() {
        return approved_date;
    }

    /**
     * @param approved_date the approved_date to set
     */
    public void setApproved_date(String approved_date) {
        this.approved_date = approved_date;
    }

    /**
     * @return the approvedFromDate
     */
    public String getApprovedFromDate() {
        return approvedFromDate;
    }

    /**
     * @param approvedFromDate the approvedFromDate to set
     */
    public void setApprovedFromDate(String approvedFromDate) {
        this.approvedFromDate = approvedFromDate;
    }

    /**
     * @return the approvedToDate
     */
    public String getApprovedToDate() {
        return approvedToDate;
    }

    /**
     * @param approvedToDate the approvedToDate to set
     */
    public void setApprovedToDate(String approvedToDate) {
        this.approvedToDate = approvedToDate;
    }

    private void insertTrainingModification() throws SQLException {
        _con = getConnection();
        String str = "INSERT INTO TBL_TRAINING_MODIFICATION (APPROVED_BY, APPROVED_DATE,APPROVED_FROM_DATE, APPROVED_TO_DATE,REQUEST_ID, REMARK) values(?,?,?,?,?,?)";
        String str1 = "UPDATE TBL_TRAINING_REQUEST SET PENDING='2' WHERE TRAINING_REQUES_ID='" + getTrainingRequestId() + "'";
        PreparedStatement ps = _con.prepareStatement(str);
        
        ps.setString(1, this.getApproved_by());
        ps.setString(2, this.getApproved_date());
        ps.setString(3, this.getApprovedFromDate());
        ps.setString(4, this.getApprovedToDate());
        ps.setInt(5, 3);//String(5, this.getTrainingRequestId());
        ps.setString(6, this.getRemark());
        ps.executeUpdate();
        ps.clearParameters();
        ps = _con.prepareStatement(str1);
        ps.executeUpdate();
        ps.clearParameters();
    }
    public boolean insertTransferDecision() throws SQLException {

        String _insertQuery = "INSERT INTO TBL_TRAINING_PROCESSED " +
                " (REQUEST_ID, PROCESSED_BY,DECISION, " +
                " COMMENT_GIVEN, RECORDED_BY, TIME_STAMP)" +
                " VALUES (?,?,?,?,?,?) ";
        String _updateQuery = "UPDATE TBL_TRAINING_REQUEST SET PENDING=? WHERE TRAINING_REQUES_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            //(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime)
            _ps.setInt(1, requestId);
            _ps.setString(2, processedBy);
            _ps.setString(3, decision);//decision inserted to HR_LEAVE_PROCESSED table
            _ps.setString(4, commentGiven);
            _ps.setString(5, recordedBy);
            _ps.setString(6, timeStamp);
            try {
                _ps.executeUpdate();
                _ps = _con.prepareStatement(_updateQuery);
                _ps.setString(1, status); //status inserted to HR_LEAVE_REQUEST table
                _ps.setInt(2, requestId);
                _ps.executeUpdate();
                _con.setAutoCommit(true);
            } catch (SQLException ex) {
                // _con.rollback(firstSavePoint);
            }
            return true;
        } finally {
            releaseResources();
        }
    }
}
