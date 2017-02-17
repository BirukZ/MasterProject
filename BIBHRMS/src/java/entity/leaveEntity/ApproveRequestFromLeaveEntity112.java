/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.leaveEntity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author 
 */
@Entity
@Table(name = "HR_RETURN_FROM_LEAVE_PROCESSED")
@NamedQueries({@NamedQuery(name = "HrReturnFromLeaveProcessed.findAll", query = "SELECT h FROM HrReturnFromLeaveProcessed h"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByLeaveProcessedId", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.leaveProcessedId = :leaveProcessedId"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByRequestId", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.requestId = :requestId"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByProcessedBy", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.processedBy = :processedBy"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByCommentGiven", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.commentGiven = :commentGiven"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByDecision", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.decision = :decision"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByRecordedBy", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.recordedBy = :recordedBy"), @NamedQuery(name = "HrReturnFromLeaveProcessed.findByTimeStamp", query = "SELECT h FROM HrReturnFromLeaveProcessed h WHERE h.timeStamp = :timeStamp")})
public class ApproveRequestFromLeaveEntity112 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LEAVE_PROCESSED_ID")
    private BigDecimal leaveProcessedId;
    @Basic(optional = false)
    @Column(name = "REQUEST_ID")
    private BigInteger requestId;
    @Column(name = "PROCESSED_BY")
    private String processedBy;
    @Column(name = "COMMENT_GIVEN")
    private String commentGiven;
    @Basic(optional = false)
    @Column(name = "DECISION")
    private String decision;
    @Column(name = "RECORDED_BY")
    private String recordedBy;
    @Column(name = "TIME_STAMP")
    private String timeStamp;
   

    public ApproveRequestFromLeaveEntity112() {
    }

    public ApproveRequestFromLeaveEntity112(BigDecimal leaveProcessedId) {
        this.leaveProcessedId = leaveProcessedId;
    }

    public ApproveRequestFromLeaveEntity112(BigDecimal leaveProcessedId, BigInteger requestId, String decision) {
        this.leaveProcessedId = leaveProcessedId;
        this.requestId = requestId;
        this.decision = decision;
    }

    public BigDecimal getLeaveProcessedId() {
        return leaveProcessedId;
    }

    public void setLeaveProcessedId(BigDecimal leaveProcessedId) {
        this.leaveProcessedId = leaveProcessedId;
    }

    public BigInteger getRequestId() {
        return requestId;
    }

    public void setRequestId(BigInteger requestId) {
        this.requestId = requestId;
    }

    public String getProcessedBy() {
        return processedBy;
    }

    public void setProcessedBy(String processedBy) {
        this.processedBy = processedBy;
    }

    public String getCommentGiven() {
        return commentGiven;
    }

    public void setCommentGiven(String commentGiven) {
        this.commentGiven = commentGiven;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRecordedBy() {
        return recordedBy;
    }

    public void setRecordedBy(String recordedBy) {
        this.recordedBy = recordedBy;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leaveProcessedId != null ? leaveProcessedId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ApproveRequestFromLeaveEntity112)) {
            return false;
        }
        ApproveRequestFromLeaveEntity112 other = (ApproveRequestFromLeaveEntity112) object;
        if ((this.leaveProcessedId == null && other.leaveProcessedId != null) || (this.leaveProcessedId != null && !this.leaveProcessedId.equals(other.leaveProcessedId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Localization.HrReturnFromLeaveProcessed[leaveProcessedId=" + leaveProcessedId + "]";
    }
}
