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
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author DPClone
 */
public class TrainingAwardEntity extends ConnectionManager{
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

private String awardId;
    private String description;
  
    

    /**
     *
     */
    public TrainingAwardEntity() {
    }

    /**
     *
     * @param awardId
     * @param description
     */
    public TrainingAwardEntity(String awardId, String description) {
        this.awardId = awardId;
        this.description = description;
    }

    /**
     * @return the awardId
     */
    public String getAwardId() {
        return awardId;
    }

    /**
     * @param awardId the awardId to set
     */
    public void setAwardId(String awardId) {
        this.awardId = awardId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public TrainingAwardEntity read() {
        ResultSet rs = null;
        TrainingAwardEntity trainingAward = null;

        try {
             _con = getConnection();
            String selectTrainee = "SELECT l.`payment_method_id`, l.`description`, l.`remark` FROM lu_payment_method l;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
            while (rs.next()) {
                TrainingAwardEntity trainingAwd = new TrainingAwardEntity(rs.getString("payment_method_id"), rs.getString("description"));
                trainingAward = trainingAwd;
            }
            return trainingAward;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace(); ErrorLogWriter.writeError(ex);
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    /**
     *
     * @return
     */
    public ArrayList<TrainingAwardEntity> readAll() {
        ResultSet rs = null;
        ArrayList<TrainingAwardEntity> trainingAwards = new ArrayList<TrainingAwardEntity>();
        try {
             _con = getConnection();
            String selectTrainee = "SELECT l.`payment_method_id`, l.`description`, l.`remark` FROM lu_payment_method l;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();

            while (rs.next()) {
                TrainingAwardEntity trainingAward = new TrainingAwardEntity(rs.getString("payment_method_id"), rs.getString("description"));
                trainingAwards.add(trainingAward);
            }
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return trainingAwards;
    }

    /**
     *
     * @param newOrOld
     */
    public void add(String newOrOld) {
        if (newOrOld.equalsIgnoreCase("new")) {
            this.addTrainingAward(this);
        } else if (newOrOld.equalsIgnoreCase("old")) {
            this.updateTrainingAward(this);
        }
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return this.deleteTrainingAward(awardId);
    }

    private void addTrainingAward(TrainingAwardEntity paymentMethod) {

        String str = "INSERT INTO lu_traiining_awared (awared_id, description) " +
                "values(?, ?)";
        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, paymentMethod.getAwardId());
            ps.setString(2, paymentMethod.getDescription());

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(); ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    private boolean deleteTrainingAward(String awardId) {
        boolean deleted = false;


        String str = "DELETE FROM lu_traiining_awared WHERE awared_id = ?";

        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, awardId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                deleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace(); ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return deleted;
    }

    private void updateTrainingAward(TrainingAwardEntity paymentMethod) {

        String str = "UPDATE lu_traiining_awared SET awared_id = ?, description = ? " +
                "WHERE awared_id = ?";
        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, paymentMethod.getAwardId());
            ps.setString(2, paymentMethod.getDescription());

            ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace(); ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }
}