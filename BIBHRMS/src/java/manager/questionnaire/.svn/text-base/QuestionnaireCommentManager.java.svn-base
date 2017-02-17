/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import entity.questionnaire.QuestionnaireCommentEntity;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class QuestionnaireCommentManager {

    private int commentId;
    private int sectionId;
    private String sectionDesc;
    private String remark;
    private int commentType;
    private int questAnsId;
    private String reviwedBy;
    private String reviwedOn;
    private String supervisedBy;
    private String supervisedOn;
    QuestionnaireCommentEntity commentEntity = new QuestionnaireCommentEntity();

    public QuestionnaireCommentManager() {
    }

    public QuestionnaireCommentManager(int sectionId, String sectionDesc, String remark) {
        this.sectionId = sectionId;
        this.sectionDesc = sectionDesc;
        this.remark = remark;
    }

    public QuestionnaireCommentManager(int commentId, int sectionId, String remark) {
        this.commentId = commentId;
        this.sectionId = sectionId;
        this.remark = remark;
    }

    public QuestionnaireCommentManager(int sectionId, String remark, int commentType, int questAnsId) {
        this.sectionId = sectionId;
        this.remark = remark;
        this.commentType = commentType;
        this.questAnsId = questAnsId;
    }

    public QuestionnaireCommentManager(String supervisedBy, String supervisedOn, int questAnsId) {
        this.questAnsId = questAnsId;
        this.supervisedBy = supervisedBy;
        this.supervisedOn = supervisedOn;
    }

    public String getReviwedBy() {
        return reviwedBy;
    }

    public void setReviwedBy(String reviwedBy) {
        this.reviwedBy = reviwedBy;
    }

    public String getReviwedOn() {
        return reviwedOn;
    }

    public void setReviwedOn(String reviwedOn) {
        this.reviwedOn = reviwedOn;
    }

    public String getSupervisedBy() {
        return supervisedBy;
    }

    public void setSupervisedBy(String supervisedBy) {
        this.supervisedBy = supervisedBy;
    }

    public String getSupervisedOn() {
        return supervisedOn;
    }

    public void setSupervisedOn(String supervisedOn) {
        this.supervisedOn = supervisedOn;
    }
    // <editor-fold defaultstate="collapsed" desc="    Getters and Setters    ">

    public int getCommentId() {
        return commentId;
    }

    public void setCommentId(int commentId) {
        this.commentId = commentId;
    }

    public int getCommentType() {
        return commentType;
    }

    public void setCommentType(int commentType) {
        this.commentType = commentType;
    }

    public int getQuestAnsId() {
        return questAnsId;
    }

    public void setQuestAnsId(int questAnsId) {
        this.questAnsId = questAnsId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public QuestionnaireCommentEntity getCommentEntity() {
        return commentEntity;
    }

    public void setCommentEntity(QuestionnaireCommentEntity commentEntity) {
        this.commentEntity = commentEntity;
    }

    public String getSectionDesc() {
        return sectionDesc;
    }

    public void setSectionDesc(String sectionDesc) {
        this.sectionDesc = sectionDesc;
    }

// </editor-fold>
    public boolean saveSupervisorComment(QuestionnaireCommentManager commentManager, ArrayList<QuestionnaireCommentManager> commentManagerList) {
        ArrayList<QuestionnaireCommentEntity> commentEntitylist = new ArrayList<QuestionnaireCommentEntity>();
        QuestionnaireCommentEntity _commentEntity = new QuestionnaireCommentEntity(
                commentManager.getSupervisedBy(),
                commentManager.getSupervisedOn(),
                commentManager.getQuestAnsId());
        for (QuestionnaireCommentManager comment : commentManagerList) {
            commentEntitylist.add(new QuestionnaireCommentEntity(
                    comment.getSectionId(),
                    comment.getRemark(),
                    comment.getCommentType(),
                    comment.getQuestAnsId()));
        }
        return commentEntity.insertSupervisorComment(_commentEntity, commentEntitylist);
    }

    public boolean saveReviwerComment(QuestionnaireCommentManager commentManager, ArrayList<QuestionnaireCommentManager> commentManagerList) {
        ArrayList<QuestionnaireCommentEntity> commentEntitylist = new ArrayList<QuestionnaireCommentEntity>();
        QuestionnaireCommentEntity _commentEntity = new QuestionnaireCommentEntity(
                commentManager.getSupervisedBy(),
                commentManager.getSupervisedOn(),
                commentManager.getQuestAnsId());
        for (QuestionnaireCommentManager comment : commentManagerList) {
            commentEntitylist.add(new QuestionnaireCommentEntity(
                    comment.getSectionId(),
                    comment.getRemark(),
                    comment.getCommentType(),
                    comment.getQuestAnsId()));
        }
        return commentEntity.insertReviwerComment(_commentEntity, commentEntitylist);
    }

    public boolean updateQuestionnaireComment(ArrayList<QuestionnaireCommentManager> commentManagerList) {
        ArrayList<QuestionnaireCommentEntity> commentEntitylist = new ArrayList<QuestionnaireCommentEntity>();
        for (QuestionnaireCommentManager commentManager : commentManagerList) {
            commentEntitylist.add(new QuestionnaireCommentEntity(
                    commentManager.getCommentId(),
                    commentManager.getSectionId(),
                    commentManager.getRemark()));
        }
        return commentEntity.updateQuestionnaireComment(commentEntitylist);
    }

    public boolean deleteQuestionnaireComment(int commentId) {
        return commentEntity.deleteQuestionnaireComment(commentId);
    }

//    public ArrayList<QuestionnaireCommentManager> selectQuestionnaire(int questAnsId) {
//        ArrayList<QuestionnaireCommentManager> commentManagerList = new ArrayList<QuestionnaireCommentManager>();
//        ArrayList<HashMap> commentEntityList = commentEntity.selectQuestionnaireComment(questAnsId);
//        try {
//            for (HashMap hm : commentEntityList) {
//                commentManagerList.add(new QuestionnaireCommentManager(
//                        Integer.valueOf(hm.get("commentId").toString()),
//                        Integer.valueOf(hm.get("sectionId").toString()),
//                        hm.get("remark").toString()));
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//        }
//        return commentManagerList;
//    }

    public ArrayList<HashMap> selectQuestionnaire(int questAnsId) {
        return commentEntity.selectQuestionnaireComment(questAnsId);
    }
}
