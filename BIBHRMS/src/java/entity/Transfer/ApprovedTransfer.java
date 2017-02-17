/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.Transfer;
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author kibrom
 */
public class ApprovedTransfer extends ConnectionManager {
    private String approvedTransferId;
    private String approverEmployeeId;
    private String employeeFulName;
    private String stateName;
   private String action;
    private String approvedDate;
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
    public ApprovedTransfer() {
    }

    public ApprovedTransfer(String approvedTransferId, String approverEmployeeId, String employeeFulName, String stateName,  String action, String approvedDate, String timeStamp, String userName, String remark) {
        this.approvedTransferId = approvedTransferId;
        this.approverEmployeeId = approverEmployeeId;
        this.employeeFulName = employeeFulName;
        this.stateName = stateName;
      
        this.action = action;
        this.approvedDate = approvedDate;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.remark = remark;
    }

    /**
     * @return the approvedTransferId
     */
    public String getApprovedTransferId() {
        return approvedTransferId;
    }

    /**
     * @param approvedTransferId the approvedTransferId to set
     */
    public void setApprovedTransferId(String approvedTransferId) {
        this.approvedTransferId = approvedTransferId;
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
     * @return the employeeFulName
     */
    public String getEmployeeFulName() {
        return employeeFulName;
    }

    /**
     * @param employeeFulName the employeeFulName to set
     */
    public void setEmployeeFulName(String employeeFulName) {
        this.employeeFulName = employeeFulName;
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
