/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.questionnaire;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Bini
 */
public class QuestionnaireCommentEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTIONNAIRE_ANSWER)
    @Column(QUESTIONNAIRE_ANS_ID,ANSWERED_BY,ANSWERED_ON,REVIEWDED_BY,
    REVIEWED_ON,SUPERVISOR,SUPERVISED_ON,STATUS,QUESTONNAIRE_ID)
     */
    /*
    @Table(HR_QUESTIONNAIRE_COMMENT)
    @Column(COMMENT_ID,SECTION_ID,REMARK,QUESTIONNAIRE_ANS_ID,TYPE)
     */

    private int commentId;
    private int sectionId;
    private String remark;
    private int commentType;
    private int questAnsId;
    private String reviwedBy;
    private String reviwedOn;
    private String supervisedBy;
    private String supervisedOn;

    public QuestionnaireCommentEntity() {
    }

    public QuestionnaireCommentEntity(String supervisedBy, String supervisedOn, int questAnsId) {
        this.questAnsId = questAnsId;
        this.supervisedBy = supervisedBy;
        this.supervisedOn = supervisedOn;
    }

    public QuestionnaireCommentEntity(int commentId, int sectionId, String remark) {
        this.commentId = commentId;
        this.sectionId = sectionId;
        this.remark = remark;
    }

    public QuestionnaireCommentEntity(int sectionId, String remark, int commentType, int questAnsId) {
        this.sectionId = sectionId;
        this.remark = remark;
        this.commentType = commentType;
        this.questAnsId = questAnsId;
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

// </editor-fold>
    public boolean insertSupervisorComment(QuestionnaireCommentEntity commentEntity, ArrayList<QuestionnaireCommentEntity> commentEntityList) {
        boolean checkSave = false;
        Connection con = null;
        Savepoint savepoint1 = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psInsert = null;
        String update = "UPDATE HR_QUESTIONNAIRE_ANSWER SET " +
                "SUPERVISOR=?,SUPERVISED_ON=?,STATUS=? " +
                "WHERE QUESTIONNAIRE_ANS_ID=? ";
        String insert = "INSERT INTO HR_QUESTIONNAIRE_COMMENT ( " +
                "SECTION_ID,REMARK,QUESTIONNAIRE_ANS_ID,TYPE) " +
                " VALUES(?,?,?,?)";
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savepoint1 = con.setSavepoint("savePoint");
            psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, commentEntity.getSupervisedBy());
            psUpdate.setString(2, commentEntity.getSupervisedOn());
            psUpdate.setInt(3, 1);
            psUpdate.setInt(4, commentEntity.getQuestAnsId());
            if (psUpdate.executeUpdate() > 0) {
                for (QuestionnaireCommentEntity comment : commentEntityList) {
                    psInsert = con.prepareStatement(insert);
                    psInsert.setInt(1, comment.getSectionId());
                    psInsert.setString(2, comment.getRemark());
                    psInsert.setInt(3, commentEntity.getQuestAnsId());
                    psInsert.setInt(4, 0);
                    if (psInsert.executeUpdate() < 1) {
                        con.rollback(savepoint1);
                        return false;
                    }
                    psInsert.close();
                }
                psUpdate.close();
                con.commit();
                checkSave = true;
            }
            closePooledConnections(con);
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean insertReviwerComment(QuestionnaireCommentEntity commentEntity, ArrayList<QuestionnaireCommentEntity> commentEntityList) {
        boolean checkSave = false;
        Connection con = null;
        Savepoint savepoint1 = null;
        PreparedStatement psUpdate = null;
        PreparedStatement psInsert = null;
        String update = "UPDATE HR_QUESTIONNAIRE_ANSWER SET " +
                "REVIEWDED_BY=?,REVIEWED_ON=?,STATUS=? " +
                "WHERE QUESTIONNAIRE_ANS_ID=? ";
        String insert = "INSERT INTO HR_QUESTIONNAIRE_COMMENT ( " +
                "SECTION_ID,REMARK,QUESTIONNAIRE_ANS_ID,TYPE) " +
                " VALUES(?,?,?,?)";
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savepoint1 = con.setSavepoint("savePoint");
            psUpdate = con.prepareStatement(update);
            psUpdate.setString(1, commentEntity.getSupervisedBy());
            psUpdate.setString(2, commentEntity.getSupervisedOn());
            psUpdate.setInt(3, 2);
            psUpdate.setInt(4, commentEntity.getQuestAnsId());
            if (psUpdate.executeUpdate() > 0) {
                for (QuestionnaireCommentEntity comment : commentEntityList) {
                    psInsert = con.prepareStatement(insert);
                    psInsert.setInt(1, comment.getSectionId());
                    psInsert.setString(2, comment.getRemark());
                    psInsert.setInt(3, commentEntity.getQuestAnsId());
                    psInsert.setInt(4, 1);
                    if (psInsert.executeUpdate() < 1) {
                        con.rollback(savepoint1);
                        return false;
                    }
                    psInsert.close();
                }
                psUpdate.close();
                con.commit();
                checkSave = true;
            }
            closePooledConnections(con);
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateQuestionnaireComment(ArrayList<QuestionnaireCommentEntity> commentEntityList) {
        Connection con = null;
        Savepoint savepoint1 = null;
        PreparedStatement ps = null;

        String insert = "UPDATE HR_QUESTIONNAIRE_COMMENT" +
                "SET SECTION_ID=?,REMARK=? " +
                "WHERE COMMENT_ID=?";
        try {
            con = getConnection();
            savepoint1 = con.setSavepoint("savePoint");
            con.setAutoCommit(false);
            for (QuestionnaireCommentEntity commentEntity : commentEntityList) {
                ps = con.prepareStatement(insert);
                ps.setInt(1, commentEntity.getSectionId());
                ps.setString(2, commentEntity.getRemark());
                ps.setInt(3, commentEntity.getCommentId());
                if (ps.executeUpdate() < 1) {
                    con.rollback(savepoint1);
                    return false;
                }
                ps.close();
            }
            con.commit();
            closePooledConnections(con);
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteQuestionnaireComment(int commentId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement ps = null;

        String update = "DELETE HR_QUESTIONNAIRE_COMMENT " +
                "WHERE COMMENT_ID='" + commentId + "'";
        try {
            con = getConnection();
            ps = con.prepareStatement(update);

            if (ps.executeUpdate() > 0) {
                checkDelete = true;
            }
            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkDelete;
    }

    public ArrayList<HashMap> selectQuestionnaireComment(int questAnsId) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT COMMENT_ID,SECTION_ID,REMARK,TYPE " +
                "FROM HR_QUESTIONNAIRE_COMMENT " +
                "WHERE QUESTIONNAIRE_ANS_ID='" + questAnsId + "' " +
                "ORDER BY SECTION_ID asc";
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("commentId", ocrs.getInt("COMMENT_ID"));
                hm.put("sectionId", ocrs.getInt("SECTION_ID"));
                hm.put("type", ocrs.getInt("TYPE"));
                hm.put("remark", ocrs.getString("REMARK"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return quesList;
    }
}
