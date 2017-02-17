/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.OverTime;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kibrom
 */
public class OverTimeWorkerEntity extends ConnectionManager {

    private String overTimeWorkerId;
    private String workerEmployeeId;
    private String workerFulName;
    private String jobPosition;
    private String reason;
    private String fromTime;
    private String toTime;
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

    // <editor-fold defaultstate="collapsed" desc="Constractor, getters and setters">
    public OverTimeWorkerEntity() {
    }

    public OverTimeWorkerEntity(String overTimeWorkerId, String workerEmployeeId, String workerFulName, String jobPosition, String reason, String fromTime, String toTime) {
        this.overTimeWorkerId = overTimeWorkerId;
        this.workerEmployeeId = workerEmployeeId;
        this.workerFulName = workerFulName;
        this.jobPosition = jobPosition;
        this.reason = reason;
        this.fromTime = fromTime;
        this.toTime = toTime;
    }

    /**
     * @return the overTimeWorkerId
     */
    public String getOverTimeWorkerId() {
        return overTimeWorkerId;
    }

    /**
     * @param overTimeWorkerId the overTimeWorkerId to set
     */
    public void setOverTimeWorkerId(String overTimeWorkerId) {
        this.overTimeWorkerId = overTimeWorkerId;
    }

    /**
     * @return the workerEmployeeId
     */
    public String getWorkerEmployeeId() {
        return workerEmployeeId;
    }

    /**
     * @param workerEmployeeId the workerEmployeeId to set
     */
    public void setWorkerEmployeeId(String workerEmployeeId) {
        this.workerEmployeeId = workerEmployeeId;
    }

    /**
     * @return the workerFulName
     */
    public String getWorkerFulName() {
        return workerFulName;
    }

    /**
     * @param workerFulName the workerFulName to set
     */
    public void setWorkerFulName(String workerFulName) {
        this.workerFulName = workerFulName;
    }

    /**
     * @return the jobPosition
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * @param jobPosition the jobPosition to set
     */
    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
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
     * @return the fromTime
     */
    public String getFromTime() {
        return fromTime;
    }

    /**
     * @param fromTime the fromTime to set
     */
    public void setFromTime(String fromTime) {
        this.fromTime = fromTime;
    }

    /**
     * @return the toTime
     */
    public String getToTime() {
        return toTime;
    }

    /**
     * @param toTime the toTime to set
     */
    public void setToTime(String toTime) {
        this.toTime = toTime;
    }
    // </editor-fold>
}
