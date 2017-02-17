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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author DPClone
 */
public class FeeEntity extends ConnectionManager{
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


    private String feeId;
    private String trainerSpecializationId;
    private String paymentMethod;
    private float amount = 0;
    private String date;
    private boolean isWorking;
    private String remark;
    private String trainer;
    private String trainingType;
    private String duration;
   
    

    /**
     *
     */
    public FeeEntity() {
    }

    /**
     *
     * @param feeId
     */
    public FeeEntity(String feeId) {
        this.feeId = feeId;
    }

    /**
     *
     * @param feeId
     * @param trainerSpecializationId
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param duration
     * @param remark
     */
    public FeeEntity(String feeId, String trainerSpecializationId,
            String paymentMethod, float amount, String date, boolean isWorking,
            String duration, String remark) {
        this.feeId = feeId;
        this.trainerSpecializationId = trainerSpecializationId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.isWorking = isWorking;
        this.duration = duration;
        this.remark = remark;

    }
//    feeId, trainer, trainingType, paymentMethod, amount, date, isWorking, duration, remark, newOrOld

    /**
     *
     * @param feeId
     * @param trainer
     * @param trainingType
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param remark
     * @param duration
     */
    public FeeEntity(String feeId, String trainer, String trainingType,
            String paymentMethod, float amount, String date, boolean isWorking,
            String remark, String duration)
    {
        this.feeId = feeId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.isWorking = isWorking;
        this.remark = remark;
        this.trainer = trainer;
        this.trainingType = trainingType;
        this.duration = duration;
    }

    /**
     *
     * @param feeId
     * @param trainerSpecializationId
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param duration
     * @param remark
     * @param trainer
     * @param trainingType
     */
    public FeeEntity(String feeId, String trainerSpecializationId, String
            paymentMethod, float amount, String date, boolean isWorking,
            String duration, String remark, String trainer, String trainingType)
    {
        this.feeId = feeId;
        this.trainerSpecializationId = trainerSpecializationId;
        this.paymentMethod = paymentMethod;
        this.amount = amount;
        this.date = date;
        this.isWorking = isWorking;
        this.duration = duration;
        this.remark = remark;
        this.trainer = trainer;
        this.trainingType = trainingType;

    }

    /**
     *
     * @param trainerId
     * @param trainingType
     * @return
     */
    public ArrayList<FeeEntity> search(String trainerId, String trainingType) {
        ResultSet rs = null;
        ArrayList<FeeEntity> fees = new ArrayList<FeeEntity>();
        try {
            _con = getConnection();
            String selectTrainee = "SELECT t.`training_fee_id`, " +
                    "t.`trainer_specialization_id`, t.`payment_method_id`, " +
                    "t.`amount`, t.`fee_date`, t.`isworking`, t.`duration`, " +
                    "t.`remark` FROM tbl_training_fee t WHERE t;";
            PreparedStatement ps =_con.prepareStatement(selectTrainee);
            rs = (ResultSet) ps.executeQuery();

            while (rs.next()) {
                FeeEntity trainee = new FeeEntity(rs.getString("training_fee_id"), rs.getString("trainer_specialization_id"),
                        rs.getString("payment_method_id"), rs.getFloat("amount"), rs.getString("fee_date"),
                        rs.getBoolean("isworking"), rs.getString("duration"), rs.getString("remark"));
                fees.add(trainee);
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
        return fees;
    }

    /**
     *
     * @return
     */
    public FeeEntity read() {
        ResultSet rs = null;
        FeeEntity trainee = null;
        try {
            _con = getConnection();
            String selectTrainee = "SELECT t.`training_fee_id`, t.`trainer_specialization_id`, t.`payment_method_id`, t.`amount`, t.`fee_date`, " +
                    "t.`isworking`, t.`duration`, t.`remark` FROM tbl_training_fee t;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = (ResultSet) ps.executeQuery();
            while (rs.next()) {
                FeeEntity traineeEntiry = new FeeEntity(rs.getString("training_fee_id"), rs.getString("trainer_specialization_id"),
                        rs.getString("payment_method_id"), rs.getFloat("amount"), rs.getString("fee_date"),
                        rs.getBoolean("isworking"), rs.getString("duration"), rs.getString("remark"));
                trainee = traineeEntiry;
            }
            return trainee;
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
    public List<FeeEntity> readAll() {
        ResultSet rs = null;
        ArrayList<FeeEntity> fees = new ArrayList<FeeEntity>();
        try {
            _con = getConnection();
            String selectTrainee = "SELECT t.`training_fee_id`, " +
                    "t.`trainer_specialization_id`, t.`payment_method_id`, " +
                    "t.`amount`, t.`fee_date`, t.`isworking`, t.`duration`, " +
                    "t.`remark` FROM tbl_training_fee t WHERE t;";
            PreparedStatement ps =_con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();

            while (rs.next()) {
                FeeEntity trainee = new FeeEntity(rs.getString("training_fee_id"), rs.getString("trainer_specialization_id"),
                        rs.getString("payment_method_id"), rs.getFloat("amount"), rs.getString("fee_date"),
                        rs.getBoolean("isworking"), rs.getString("duration"), rs.getString("remark"));
                fees.add(trainee);
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
        return fees;
    }

    /**
     *
     * @param newOrOld
     */
    public void add(String newOrOld) {
        if (newOrOld.equalsIgnoreCase("new")) {
            this.addFee(this);
        } else if (newOrOld.equalsIgnoreCase("old")) {
            this.updateFee(this);
        }
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return this.deleteFee(feeId);
    }

    /**
     * @return the amount
     */
    public float getAmount() {
        return amount;
    }

    /**
     * @param amount the amount to set
     */
    public void setAmount(float amount) {
        this.amount = amount;
    }

    /**
     * @return the date
     */
    public String getDate() {
        return date;
    }

    /**
     * @param date the date to set
     */
    public void setDate(String date) {
        this.date = date;
    }

    /**
     * @return the isActive
     */
    public boolean isIsWorking() {
        return isWorking;
    }

    /**
     * @param isWorking
     */
    public void setIsWorking(boolean isWorking) {
        this.isWorking = isWorking;
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

    /**
     * @return the feeId
     */
    public String getFeeId() {
        return feeId;
    }

    /**
     * @param feeId the feeId to set
     */
    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    /**
     * @return the trainerSpecializationId
     */
    public String getTrainerSpecializationId() {
        return trainerSpecializationId;
    }

    /**
     * @param trainerSpecializationId the trainerSpecializationId to set
     */
    public void setTrainerSpecializationId(String trainerSpecializationId) {
        this.trainerSpecializationId = trainerSpecializationId;
    }

    /**
     * @return the payMentMethod
     */
    public String getPaymentMethod() {
        return paymentMethod;
    }

    /**
     * @param paymentMethod
     */
    public void setPayMentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    /**
     * @return the trainer
     */
    public String getTrainer() {
        return trainer;
    }

    /**
     * @param trainer the trainer to set
     */
    public void setTrainer(String trainer) {
        this.trainer = trainer;
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
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    private void addFee(FeeEntity fee) {
        String str = "INSERT INTO tbl_training_fee (training_fee_id, trainer_specialization_id, payment_method_id, " +
                "amount, fee_date, isworking, duration, remark) " +
                "values(?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, fee.getFeeId());
            ps.setString(2, fee.getTrainerSpecializationId());
            ps.setString(3, fee.getPaymentMethod());
            ps.setDouble(4, fee.getAmount());
            ps.setString(5, fee.getDate());
            ps.setBoolean(6, fee.isIsWorking());
            ps.setString(7, fee.getDuration());
            ps.setString(8, fee.getRemark());

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

    private boolean deleteFee(String feeId) {
        boolean deleted = false;


        String str = "DELETE FROM tbl_training_fee WHERE training_fee_id=?";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, feeId);
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

    private void updateFee(FeeEntity fee) {
        String str = "UPDATE tbl_training_fee SET training_fee_id = ?, trainer_specialization_id = ?, payment_method_id = ?, " +
                "amount = ?, fee_date = ?, isworking = ?, duration = ?, remark =  ? " +
                "WHERE training_fee_id = ?";
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, fee.getFeeId());
            ps.setString(2, fee.getTrainerSpecializationId());
            ps.setString(3, fee.getPaymentMethod());
            ps.setDouble(4, fee.getAmount());
            ps.setString(5, fee.getDate());
            ps.setBoolean(6, fee.isIsWorking());
            ps.setString(7, fee.getDuration());
            ps.setString(8, fee.getRemark());

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

    /**
     * Fetches maximum of a row from tbl_training_fee table
     * which is identifed by _id
     * @training_fee_id the id of the row
     * @return <b>ResultSet</b> object on successful completion of the tasks,
     * throws an SQLException otherwise
     */
    public ResultSet readNextTrainingFeeId() {

        Statement st = null;
        ResultSet rs = null;
        try {
            _con = getConnection();
            st = (Statement)_con.createStatement();
            st.executeQuery("SELECT MAX(training_fee_id) as maxFeeId " +
                    "FROM tbl_training_fee");
            rs = (ResultSet) st.getResultSet();

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
        return rs;
    }
}