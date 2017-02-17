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
import java.util.ArrayList;

/**
 *
 * @author DPClone
 */
public class ApprovedRequestsEntity extends ConnectionManager {
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


 private String startDate;
    private String endDate;
    private String trainingType;

    /**
     *
     */
    public ApprovedRequestsEntity() {
    }

    /**
     *
     * @param trainingType
     * @param startDate
     * @param endDate
     */
    public ApprovedRequestsEntity(String trainingType, String startDate, String endDate) {
        this.trainingType = trainingType;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    /**
     *
     * @param empId
     * @param processId
     * @return
     */
    public ArrayList<ApprovedRequestsEntity> selectApprovedRequests(String empId, String processId) {
        return this.selectApprovedRequests(empId, processId);
    }

    /**
     * @return the trainingType
     */
    public String getTrainingType() {
        return trainingType;
    }

    /**
     * @param trainingType the trainingType to set
     */
    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}

