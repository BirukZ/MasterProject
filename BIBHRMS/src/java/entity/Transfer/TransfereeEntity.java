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
 * @author 
 */
public class TransfereeEntity extends ConnectionManager{
    private String transfereeEmployeeId;
    private String employeeFulName;
    private String currentWorkingPlace;
    private String currentJobPosition;
    private String requestedPlace;
    private String requestedJobPosition;
    private String transferType;
    private String reason;

  // <editor-fold defaultstate="collapsed" desc="Constractor, getters and setters">
    public TransfereeEntity() {
    }

    public TransfereeEntity(String transfereeEmployeeId, String employeeFulName, String currentWorkingPlace, String currentJobPosition, String requestedPlace, String requestedJobPosition, String transferType, String reason) {
        this.transfereeEmployeeId = transfereeEmployeeId;
        this.employeeFulName = employeeFulName;
        this.currentWorkingPlace = currentWorkingPlace;
        this.currentJobPosition = currentJobPosition;
        this.requestedPlace = requestedPlace;
        this.requestedJobPosition = requestedJobPosition;
        this.transferType = transferType;
        this.reason = reason;
    }

    /**
     * @return the transfereeEmployeeId
     */
    public String getTransfereeEmployeeId() {
        return transfereeEmployeeId;
    }

    /**
     * @param transfereeEmployeeId the transfereeEmployeeId to set
     */
    public void setTransfereeEmployeeId(String transfereeEmployeeId) {
        this.transfereeEmployeeId = transfereeEmployeeId;
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
     * @return the currentWorkingPlace
     */
    public String getCurrentWorkingPlace() {
        return currentWorkingPlace;
    }

    /**
     * @param currentWorkingPlace the currentWorkingPlace to set
     */
    public void setCurrentWorkingPlace(String currentWorkingPlace) {
        this.currentWorkingPlace = currentWorkingPlace;
    }

    /**
     * @return the currentJobPosition
     */
    public String getCurrentJobPosition() {
        return currentJobPosition;
    }

    /**
     * @param currentJobPosition the currentJobPosition to set
     */
    public void setCurrentJobPosition(String currentJobPosition) {
        this.currentJobPosition = currentJobPosition;
    }

    /**
     * @return the requestedPlace
     */
    public String getRequestedPlace() {
        return requestedPlace;
    }

    /**
     * @param requestedPlace the requestedPlace to set
     */
    public void setRequestedPlace(String requestedPlace) {
        this.requestedPlace = requestedPlace;
    }

    /**
     * @return the requestedJobPlace
     */
    public String getRequestedJobPosition() {
        return requestedJobPosition;
    }

    /**
     * @param requestedJobPlace the requestedJobPlace to set
     */
    public void setRequestedJobPosition(String requestedJobPosition) {
        this.requestedJobPosition = requestedJobPosition;
    }

    /**
     * @return the transferType
     */
    public String getTransferType() {
        return transferType;
    }

    /**
     * @param transferType the transferType to set
     */
    public void setTransferType(String transferType) {
        this.transferType = transferType;
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
   // </editor-fold >
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


}
