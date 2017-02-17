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
public class TrainingRequestApprovedEntity extends ConnectionManager {
    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    private String trainingRequest;
    private String fromDate;
    private String toDate;
    private int numberOfTrainee = 0;

    public String getTrainingRequest() {
        return trainingRequest;
    }

    public void setTrainingRequest(String trainingRequest) {
        this.trainingRequest = trainingRequest;
    }


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


   
    public TrainingRequestApprovedEntity() {
    }

    /**
     *
     * @param trainingRequest
     * @param fromDate
     * @param toDate
     */
    public TrainingRequestApprovedEntity(String trainingRequest, String fromDate, String toDate) {
        this.trainingRequest = trainingRequest;
        this.fromDate = fromDate;
        this.toDate = toDate;

    }

    /**
     * @return the fromDate
     */
    public String getFromDate() {
        return fromDate;
    }

    /**
     *
     * @param requesterId
     * @return
     */
    public ArrayList<TrainingRequestApprovedEntity> readApprovedTraining(String requesterId) {
        return this.readAll(requesterId);
    }

    /**
     * @param fromDate the fromDate to set
     */
    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    /**
     * @return the toDate
     */
    public String getToDate() {
        return toDate;
    }

    /**
     * @param toDate the toDate to set
     */
    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    /**
     * @return the numberOfTrainee
     */
    public int getNumberOfTrainee() {
        return numberOfTrainee;
    }

    /**
     * @param numberOfTrainee the numberOfTrainee to set
     */
    public void setNumberOfTrainee(int numberOfTrainee) {
        this.numberOfTrainee = numberOfTrainee;
    }

    /**
     * @return the trainingRequest
     */
    

    private ArrayList<TrainingRequestApprovedEntity> readAll(String requesterId) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

}
