/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import entity.recruitmentEntity.VacancyNoticeListEntity;

/**
 *
 * @author kibrom
 */
public class VacancyNoticeListManager {

    VacancyNoticeListEntity vacancyNoticeListEntity = new VacancyNoticeListEntity();
    private String promotionRequestID;
    private String advertID;
    private String requesterID;
    private String educID;

    public String getEducID() {
        return educID;
    }

    public void setEducID(String educID) {
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

    public VacancyNoticeListManager() {
    }

    public VacancyNoticeListManager(String advertId, String requesterID, String educID) {
        this.advertID = advertId;
        this.requesterID = requesterID;
        this.educID = educID;
    }

    public int addNewRequestPromotion(String advertId, String requesterID, int educID) {
        VacancyNoticeListEntity saveAdvertisment = new VacancyNoticeListEntity(advertId, requesterID, educID);

        return vacancyNoticeListEntity.addNewRequestPromotion(saveAdvertisment);
    }
}
