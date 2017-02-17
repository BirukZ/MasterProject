/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author kibrom
 */
public class VacancyNoticeListEntity extends ConnectionManager {

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
    private String promotionRequestID;
    private String advertID;
    private String requesterID;
    private int educID;

    public int getEducID() {
        return educID;
    }

    public void setEducID(int educID) {
        this.educID = educID;
    }

    
    public String getPromotionRequestID() {
        return promotionRequestID;
    }

    public void setPromotionRequestID(String promotionRequestID) {
        this.promotionRequestID = promotionRequestID;
    }

    public String getAdvertID() {
        return advertID;
    }

    public void setAdvertID(String advertID) {
        this.advertID = advertID;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public VacancyNoticeListEntity() {
    }

    public VacancyNoticeListEntity(String advertId, String requesterID, int educID) {
        this.advertID = advertId;
        this.requesterID = requesterID;
        this.educID = educID;
    }

    public int addNewRequestPromotion(VacancyNoticeListEntity savePromotionRequest) {

        String insert = "INSERT INTO HR_PROMOTION_REQUEST(ADVERT_ID," +
                " REQUESTER_ID, EDUC_LEVEL_CODE) VALUES(?,?,?)";



        int saveCheck = 0;


        try {

            _con = getConnection();
            _ps = _con.prepareStatement(insert);

            _ps.setString(1, savePromotionRequest.getAdvertID());
            _ps.setString(2, savePromotionRequest.getRequesterID());
            _ps.setInt(3, Integer.valueOf(savePromotionRequest.getEducID()));

            saveCheck = _ps.executeUpdate();
            return saveCheck;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
               releaseResources();
            } catch (Exception ignore) {
            }

        }
    }
}
