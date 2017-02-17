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
import java.sql.Savepoint;
import java.util.ArrayList;

/**
 *
 * @author Preferred Customer
 */
public class TrainerSpecializationEntity extends ConnectionManager{
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
    private String specializationId;
    private String trainerId;
    private String trainingType;
    private int minNoOfTrainees;
    private String isActive;
    private String remark;
  
    

    /**
     *
     */
    public TrainerSpecializationEntity() {
    }

    /**
     *
     * @param specializationId
     */
    public TrainerSpecializationEntity(String specializationId) {
        this.specializationId = specializationId;
    }

    /**
     *
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     */
    public TrainerSpecializationEntity(String trainingType, int minNoOfTrainees, String isActive, String remark) {
        this.trainingType = trainingType;
        this.minNoOfTrainees = minNoOfTrainees;
        this.isActive = isActive;
        this.remark = remark;
    }

    /**
     *
     * @param specializationId
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     */
    public TrainerSpecializationEntity(String specializationId, String trainingType, int minNoOfTrainees, String isActive, String remark) {
        this.specializationId = specializationId;
        this.trainingType = trainingType;
        this.minNoOfTrainees = minNoOfTrainees;
        this.isActive = isActive;
        this.remark = remark;
    }

    /**
     *
     * @param specializationId
     * @param trainerId
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     */
    public TrainerSpecializationEntity(String specializationId, String trainerId, String trainingType, int minNoOfTrainees, String isActive, String remark) {
        this.specializationId = specializationId;
        this.trainerId = trainerId;
        this.trainingType = trainingType;
        this.minNoOfTrainees = minNoOfTrainees;
        this.isActive = isActive;
        this.remark = remark;
    }

    /**
     *
     * @param trainerId
     * @return
     */
    public ResultSet searchTrainerSpecialization(String trainerId) {
        ResultSet rs = null;
        try {
            _con = getConnection();
            String selectTrainee = "SELECT *FROM TBL_TRAINER_SPECIALIZATION WHERE TRAINER_ID='" + trainerId + "'";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
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
        return rs;
    }

    /**
     *
     * @param newOrOld
     * @throws java.sql.SQLException
     */
    public void add(String newOrOld) throws SQLException {
        if (newOrOld.equalsIgnoreCase("new")) {
            this.insert(this);
        } else if (newOrOld.equalsIgnoreCase("old")) {
            this.update(this);
        }

    }

    /**
     *
     */
    public void update() {
        this.updateTrainerSpecialization(this);
    }

    /**
     *
     * @return
     */
    public TrainerSpecializationEntity read() {
        return this.readTrainerSpecialization(this);
    }

    /**
     *
     * @return
     */
    public ArrayList<TrainerSpecializationEntity> readAll() {
        ResultSet rs = null;

        ArrayList<TrainerSpecializationEntity> trainerSpecialization = new ArrayList<TrainerSpecializationEntity>();
        try {
            _con = getConnection();
            String selectTrainee = "SELECT t.trainer_id, t.name, t.contact_person, t.remark FROM tbl_trainer t;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();

            while (rs.next()) {
                TrainerSpecializationEntity trainerSpc = new TrainerSpecializationEntity(rs.getString("trainer_id"), rs.getString("name"),
                        rs.getString("contact_person"), rs.getInt(""), rs.getString(""), rs.getString("remark"));
                trainerSpecialization.add(trainerSpc);
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
        return trainerSpecialization;
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return this.deleteTrainerSpecialization(specializationId);
    }

    /**
     * @return the specializationId
     */
    public String getSpecializationId() {
        return specializationId;
    }

    /**
     * @param specializationId the specializationId to set
     */
    public void setSpecializationId(String specializationId) {
        this.specializationId = specializationId;
    }

    /**
     * @return the trainerId
     */
    public String getTrainerId() {
        return trainerId;
    }

    /**
     * @param trainerId the trainerId to set
     */
    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
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
     * @return the minNoOfTrainees
     */
    public int getMinNoOfTrainees() {
        return minNoOfTrainees;
    }

    /**
     * @param minNoOfTrainees the minNoOfTrainees to set
     */
    public void setMinNoOfTrainees(int minNoOfTrainees) {
        this.minNoOfTrainees = minNoOfTrainees;
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

    private boolean deleteTrainerSpecialization(String specializationId) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void insert(TrainerSpecializationEntity trainerSpecialization) throws SQLException {
        ResultSet rs = null;
        Savepoint spOne = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        _con = getConnection();
        String qry = "SELECT TRAINER_ID FROM TBL_TRAINER WHERE TRAINER_ID =(SELECT max(TRAINER_ID) FROM TBL_TRAINER )";
        String str = "INSERT INTO tbl_trainer_specialization (trainer_id, " +
                "training_type_id, min_no_of_trainees, isactive, remark) " +
                "values(?, ?, ?, ?, ?)";
        _con.setAutoCommit(false);
        ps1 = _con.prepareStatement(qry);
        rs = ps1.executeQuery();
        if (rs.next()) {
            trainerSpecialization.setTrainerId(rs.getString("TRAINER_ID"));
        }
        spOne = _con.setSavepoint("SAVE_POINT_ONE");
        ps = _con.prepareStatement(str);
        ps.setString(1, trainerSpecialization.getTrainerId());
        ps.setString(2, trainerSpecialization.getTrainingType());
        ps.setInt(3, trainerSpecialization.getMinNoOfTrainees());
        ps.setString(4, trainerSpecialization.getIsActive());
        ps.setString(5, trainerSpecialization.getRemark());
        ps.executeUpdate();
        if (!trainerSpecialization.getTrainerId().equals("0")) {
            _con.commit();
            _con.setAutoCommit(true);
        } else {
            _con.rollback(spOne);
            _con.setAutoCommit(true);
        }
    }

    private TrainerSpecializationEntity readTrainerSpecialization(TrainerSpecializationEntity aThis) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    private void update(TrainerSpecializationEntity trainerSpecialization) throws SQLException {
        _con = getConnection();
        String str = "UPDATE tbl_trainer_specialization SET trainer_id = ?, training_type_id = ?, " +
                "min_no_of_trainees = ?, isactive = ?, remark = ? WHERE trainer_specialization_id = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, trainerSpecialization.getTrainerId());
        ps.setString(2, trainerSpecialization.getTrainingType());
        ps.setInt(3, trainerSpecialization.getMinNoOfTrainees());
        ps.setString(4, trainerSpecialization.getIsActive());
        ps.setString(5, trainerSpecialization.getRemark());

        ps.executeUpdate();
    }

    private void updateTrainerSpecialization(TrainerSpecializationEntity aThis) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * @return the isActive
     */
    public String getIsActive() {
        return isActive;
    }

    /**
     * @param isActive the isActive to set
     */
    public void setIsActive(String isActive) {
        this.isActive = isActive;
    }
}