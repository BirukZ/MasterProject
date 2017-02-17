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
public class ApprovedOverTimeEntity extends ConnectionManager {

    private String approvedOverTimeId;
    private String approverEmployeeId;
    private String approverFulName;
    private String action;
    private String approvedDate;
    private String stateName;
    private String timeStamp;
    private String userName;
    private String remark;
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

    public ApprovedOverTimeEntity() {
    }

    public ApprovedOverTimeEntity(String approvedOverTimeId, String approverEmployeeId, String approverFulName, String action, String approvedDate,  String stateName, String timeStamp, String userName, String remark) {
        this.approvedOverTimeId = approvedOverTimeId;
        this.approverEmployeeId = approverEmployeeId;
        this.approverFulName = approverFulName;
        this.action = action;
        this.approvedDate = approvedDate;
               this.stateName = stateName;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.remark = remark;
    }

    /**
     * @return the approvedOverTimeId
     */
    public String getApprovedOverTimeId() {
        return approvedOverTimeId;
    }

    /**
     * @param approvedOverTimeId the approvedOverTimeId to set
     */
    public void setApprovedOverTimeId(String approvedOverTimeId) {
        this.approvedOverTimeId = approvedOverTimeId;
    }

    /**
     * @return the approverEmployeeId
     */
    public String getApproverEmployeeId() {
        return approverEmployeeId;
    }

    /**
     * @param approverEmployeeId the approverEmployeeId to set
     */
    public void setApproverEmployeeId(String approverEmployeeId) {
        this.approverEmployeeId = approverEmployeeId;
    }

    /**
     * @return the approverFulName
     */
    public String getApproverFulName() {
        return approverFulName;
    }

    /**
     * @param approverFulName the approverFulName to set
     */
    public void setApproverFulName(String approverFulName) {
        this.approverFulName = approverFulName;
    }

    /**
     * @return the action
     */
    public String getAction() {
        return action;
    }

    /**
     * @param action the action to set
     */
    public void setAction(String action) {
        this.action = action;
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
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
   


  // </editor-fold >

}
