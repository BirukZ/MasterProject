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
public class TrainerEntity extends ConnectionManager {
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
    private String trainerId;
    private String name;
    private String contactPerson;
    private String remark;
  
    
// <editor-fold defaultstate="collapsed" desc="Getter and Setter methods">

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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the contactPerson
     */
    public String getContactPerson() {
        return contactPerson;
    }

    /**
     * @param contactPerson the contactPerson to set
     */
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
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
    // </editor-fold>

    /**
     *
     */
    public TrainerEntity() {
    }

    /**
     *
     * @param trainerId
     */
    public TrainerEntity(String trainerId) {
        this.trainerId = trainerId;
    }

    /**
     *
     * @param name
     * @param contactPerson
     * @param remark
     */
    public TrainerEntity(String name, String contactPerson, String remark) {
        this.name = name;
        this.contactPerson = contactPerson;
        this.remark = remark;
    }

    /**
     *
     * @param trainerId
     * @param name
     * @param contactPerson
     * @param remark
     */
    public TrainerEntity(String trainerId, String name, String contactPerson, String remark) {
        this.trainerId = trainerId;
        this.name = name;
        this.contactPerson = contactPerson;
        this.remark = remark;
    }

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public TrainerEntity read() throws SQLException {
        ResultSet rs = null;
        TrainerEntity trainee = null;
        _con = getConnection();

        String selectTrainee = "SELECT t.trainer_id, t.name, t.contact_person, t.remark FROM tbl_trainer t " +
                "WHERE t.trainer_id = '" + this.getTrainerId() + "'";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        rs = ps.executeQuery();
        while (rs.next()) {
            TrainerEntity traineeEntiry = new TrainerEntity(rs.getString("trainer_id"), rs.getString("name"),
                    rs.getString("contact_person"), rs.getString("remark"));
            trainee = traineeEntiry;
        }
        return trainee;
    }

    /**
     *
     * @return
     * @throws SQLException
     */
    public ArrayList<TrainerEntity> readAll() throws SQLException {
        ResultSet rs = null;
        _con = getConnection();
        ArrayList<TrainerEntity> triners = new ArrayList<TrainerEntity>();

        String selectTrainee = "SELECT t.trainer_id, t.name, t.contact_person, t.remark FROM tbl_trainer t;";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        rs = ps.executeQuery();

        while (rs.next()) {
            TrainerEntity trainee = new TrainerEntity(rs.getString("trainer_id"), rs.getString("name"),
                    rs.getString("contact_person"), rs.getString("remark"));
            triners.add(trainee);
        }
        rs.close();

        return triners;
    }

    /**
     *
     * @param newOrOld
     * @throws java.sql.SQLException
     */
//    public int add(String newOrOld) throws SQLException {
//        int transactionStatus = 0;
//        if (newOrOld.equalsIgnoreCase("new")) {
//            if (this.addTrainer(this) == 1) {
//                transactionStatus = 1;
//            }
//        } else if (newOrOld.equalsIgnoreCase("old")) {
//            if (this.updateTrainer(this) == 1) {
//                transactionStatus = 1;
//            }
//        }
//        return transactionStatus;
//    }

    /**
     *
     * @param trainerId
     * @return
     * @throws java.sql.SQLException
     */
    public boolean delete(String trainerId) throws SQLException {
        return this.deleteTrainer(trainerId);
    }

    /**
     * Fetches data from <b>tbl_trainer</b> table based on trainer names,
     * with the name prefix given.
     * @param trainerPrefix
     * @return a <code>ResultSet</code> object rs
     * @throws java.sql.SQLException
     */
    public ResultSet searchTrainer(String trainerPrefix) throws SQLException {
        _con = getConnection();
        PreparedStatement psSearchEmployee = null;
        ResultSet rs = null;
        psSearchEmployee = _con.prepareStatement("SELECT t.trainer_id, " +
                "t.name, t.contact_person, t.remark FROM tbl_trainer t " +
                "WHERE t.name LIKE ?");
        psSearchEmployee.setString(1, trainerPrefix + "%");
        rs = psSearchEmployee.executeQuery();
        return rs;
    }

       private int addTrainer(TrainerEntity trainer) throws SQLException {
        _con = getConnection();
        String str = "INSERT INTO tbl_trainer (name, contact_person, " +
                "remark) values(?, ?, ?)";
         try {
        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, trainer.getName());
        ps.setString(2, trainer.getContactPerson());
        ps.setString(3, trainer.getRemark());
        return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    private boolean deleteTrainer(String trainerId) throws SQLException {
        boolean deleted = false;
        _con = getConnection();

        String str = "DELETE FROM tbl_trainer WHERE trainer_id=?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, trainerId);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            deleted = true;
        }
        return deleted;
    }

    private int updateTrainer(TrainerEntity trainer) throws Exception {
        _con = getConnection();
        String str = "UPDATE tbl_trainer SET name = ?, contact_person = ?, " +
                "remark = ? WHERE trainer_id = ?";

        PreparedStatement ps = _con.prepareStatement(str);
        ps.setString(1, trainer.getName());
        ps.setString(2, trainer.getContactPerson());
        ps.setString(3, trainer.getRemark());
        ps.setString(4, trainer.getTrainerId());
        return ps.executeUpdate();
    }

    /**
     * Fetches all columns of a row from tbl_trainer
     * which is identifed by _id
     * @trainer_id the id of the row
     * @return <b>ResultSet</b> object on successful completion of the tasks,
     * throws an SQLException otherwise
     * @throws SQLException
     */
    public ResultSet selectAllTrainer() throws SQLException {
        _con = getConnection();
        String sql = "SELECT t.trainer_id, t.name, t.contact_person, " +
                "t.remark FROM tbl_trainer t";
        PreparedStatement _psSelect = null;
        ResultSet _resultSet = null;

        _psSelect = _con.prepareStatement(sql);

        _resultSet = _psSelect.executeQuery();

        return _resultSet;
    }//End of Function

    /**
     * Fetches all columns of a row from tbl_trainer,tbl_trainer_specialization
     * and tbl_training_type
     * which is identifed by _id
     * @trainer_id the id of the row
     * @return <b>ResultSet</b> object on successful completion of the tasks,
     * throws an SQLException otherwise
     * @throws SQLException
     */
    public ResultSet selectTrainingType(String trainerId) throws SQLException {
        _con = getConnection();
        String sql = "SELECT ALL tbl_trainer.trainer_id," +
                "                    tbl_trainer.name, " +
                "                    tbl_trainer.contact_person," +
                "                    tbl_trainer.remark, " +
                "   tbl_trainer.trainer_location," +
                "   tbl_trainer_specialization.trainer_specialization_id, " +
                "   tbl_trainer_specialization.trainer_id, " +
                "   tbl_trainer_specialization.training_type_id, " +
                "   tbl_trainer_specialization.min_no_of_trainees," +
                "                    tbl_trainer_specialization.isactive, " +
                "                    tbl_trainer_specialization.remark, " +
                "                    tbl_training_type.training_type_id, " +
                "                    tbl_training_type.description," +
                "                    tbl_training_type.awared_id," +
                "                    tbl_training_type.remark," +
                "                    tbl_training_type.parent_training_type" +
                " FROM tbl_trainer" +
                "    INNER JOIN tbl_trainer_specialization ON " +
                " tbl_trainer_specialization.trainer_id = " +
                " tbl_trainer.trainer_id" +
                "          INNER JOIN tbl_training_type ON " +
                " tbl_trainer_specialization.training_type_id = " +
                " tbl_training_type.training_type_id" +
                " WHERE tbl_trainer.trainer_id=?";
        PreparedStatement _psSelect = null;
        ResultSet _resultSet = null;

        _psSelect = _con.prepareStatement(sql);
        _psSelect.setString(1, trainerId);
        _resultSet = _psSelect.executeQuery();

        return _resultSet;
    }//End of Function

    /**
     * Fetches all columns of a row from tbl_training_fee,
     * tbl_trainer_specialization and tbl_trainer
     * which is identifed by _id
     * @param trainerPrefix
     * @trainerPrefix the id of the row
     * @return <b>ResultSet</b> object on successful completion of the tasks,
     * throws an SQLException otherwise
     * @throws SQLException
     */
    public ResultSet selectAllTrainerForFee(String trainerPrefix) throws SQLException {
        _con = getConnection();
        String sql = "SELECT ALL tbl_training_fee.training_fee_id," +
                "   tbl_training_fee.trainer_specialization_id ," +
                "   tbl_trainer_specialization.trainer_specialization_id," +
                "                    tbl_trainer.trainer_id," +
                "                    tbl_trainer.name " +
                " FROM tbl_training_fee" +
                "          INNER JOIN tbl_trainer_specialization ON " +
                " tbl_training_fee.trainer_specialization_id = " +
                " tbl_trainer_specialization.trainer_specialization_id" +
                "          INNER JOIN tbl_trainer ON" +
                "  tbl_trainer_specialization.trainer_id = " +
                "  tbl_trainer.trainer_id WHERE name LIKE CONCAT(?,'%') " +
                " GROUP BY(name)";
        PreparedStatement _psSelect = null;
        ResultSet _resultSet = null;

        _psSelect = _con.prepareStatement(sql);
        _psSelect.setString(1, trainerPrefix);
        _resultSet = _psSelect.executeQuery();

        return _resultSet;
    }//End of Function

    /**
     * Fetches all columns of a row from tbl_training_fee,
     * tbl_trainer_specialization and tbl_trainer
     * which is identifed by _id
     * @param trainerName
     * @trainerPrefix the id of the row
     * @return <b>ResultSet</b> object on successful completion of the tasks,
     * throws an SQLException otherwise
     * @throws SQLException
     */
    public ResultSet selectAllTrainerFeeData(String trainerName) throws SQLException {
        _con = getConnection();
        String sql = "SELECT ALL tbl_training_fee.training_fee_id," +
                "                    tbl_training_fee.payment_method_id," +
                "                    tbl_training_fee.amount," +
                "                    tbl_training_fee.fee_date," +
                "   tbl_training_fee.isworking, " +
                "   tbl_training_fee.duration, " +
                "   tbl_training_fee.remark as training_fee_remark," +
                "   tbl_trainer_specialization.trainer_specialization_id," +
                "   tbl_trainer_specialization.training_type_id," +
                "   tbl_trainer_specialization.min_no_of_trainees," +
                "   tbl_trainer_specialization.isactive," +
                "   tbl_trainer_specialization.remark as " +
                " trainer_specialization_remark," +
                "                    tbl_trainer.trainer_id," +
                "                    tbl_trainer.name, " +
                "                    tbl_trainer.contact_person," +
                "                    tbl_trainer.remark as trainer_remark," +
                "                    tbl_trainer.trainer_location" +
                " FROM tbl_training_fee" +
                "          INNER JOIN tbl_trainer_specialization ON " +
                " tbl_training_fee.trainer_specialization_id = " +
                " tbl_trainer_specialization.trainer_specialization_id" +
                "          INNER JOIN tbl_trainer ON" +
                "  tbl_trainer_specialization.trainer_id = " +
                "  tbl_trainer.trainer_id WHERE tbl_trainer.trainer_id" +
                "  LIKE CONCAT(?,'%')";

        PreparedStatement _psSelect = null;
        ResultSet _resultSet = null;

        _psSelect = _con.prepareStatement(sql);
        _psSelect.setString(1, trainerName);
        _resultSet = _psSelect.executeQuery();

        return _resultSet;
    }
    //End of Function selectAllTrainerFeeData

 public int add() throws Exception {
        int transactionStatus = 0;
        if (this.addTrainer(this) == 1) {
            transactionStatus = 1;
        }
        return transactionStatus;
    }
   public int update() throws Exception {
        int transactionStatus = 0;
        if (this.updateTrainer(this) == 1) {
            transactionStatus = 1;
        }
        return transactionStatus;
    }
}