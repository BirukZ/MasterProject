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
public class PaymentMethodEntity
extends ConnectionManager{
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


  private String id;
    private String description;
    private String remark;
  
    

    /**
     *
     */
    public PaymentMethodEntity() {
    }

    /**
     *
     * @param id
     */
    public PaymentMethodEntity(String id) {
        this.id = id;
    }

    /**
     *
     * @param id
     * @param description
     * @param remark
     */
    public PaymentMethodEntity(String id, String description, String remark) {
        this.id = id;
        this.description = description;
        this.remark = remark;
    }

    /**
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return
     */
    public String getId() {
        return id;
    }

    /**
     *
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     *
     * @return
     */
    public String getRemark() {
        return remark;
    }

    /**
     *
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     *
     * @return
     */
    public PaymentMethodEntity read() {
        ResultSet rs = null;
        PaymentMethodEntity paymentMethod = null;
        try {
             _con = getConnection();
            String selectTrainee = "SELECT l.`payment_method_id`, l.`description`, l.`remark` FROM lu_payment_method l;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
            while (rs.next()) {
                PaymentMethodEntity paymentMtd = new PaymentMethodEntity(rs.getString("payment_method_id"), rs.getString("description"),
                        rs.getString("remark"));
                paymentMethod = paymentMtd;
            }
            return paymentMethod;
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
    public ArrayList<PaymentMethodEntity> readAll() {
        ResultSet rs = null;
        ArrayList<PaymentMethodEntity> paymentMethods = new ArrayList<PaymentMethodEntity>();
        try {
             _con = getConnection();
            String selectTrainee = "SELECT l.`payment_method_id`, l.`description`, l.`remark` FROM lu_payment_method l;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();

            while (rs.next()) {
                PaymentMethodEntity paymentMethod = new PaymentMethodEntity(rs.getString("payment_method_id"), rs.getString("description"),
                        rs.getString("remark"));
                paymentMethods.add(paymentMethod);
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
        return paymentMethods;
    }

    /**
     *
     * @param newOrOld
     */
    public void add(String newOrOld) {
        if (newOrOld.equalsIgnoreCase("new")) {
            this.addPaymentMethod(this);
        } else if (newOrOld.equalsIgnoreCase("old")) {
            this.updatePaymentMethod(this);
        }
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return this.deletePaymentMethod(id);
    }

    private void addPaymentMethod(PaymentMethodEntity paymentMethod) {
        String str = "INSERT INTO lu_payment_method (payment_method_id, description, remark) " +
                "values(?, ?, ?)";
        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, paymentMethod.getId());
            ps.setString(2, paymentMethod.getDescription());
            ps.setString(3, paymentMethod.getRemark());

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

    private boolean deletePaymentMethod(String id) {
        boolean deleted = false;

        String str = "DELETE FROM lu_payment_method WHERE payment_method_id=?";

        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, id);
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

    private void updatePaymentMethod(PaymentMethodEntity paymentMethod) {
        String str = "UPDATE lu_payment_method SET payment_method_id = ?, description = ?, remark =  ? " +
                "WHERE payment_method_id = ?";
        try {
             _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, paymentMethod.getId());
            ps.setString(2, paymentMethod.getDescription());
            ps.setString(3, paymentMethod.getRemark());

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
