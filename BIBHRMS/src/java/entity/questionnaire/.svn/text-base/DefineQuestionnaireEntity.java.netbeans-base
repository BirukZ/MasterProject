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
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Bini
 */
public class DefineQuestionnaireEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTION_OPTIONS)
    @Column(OPTION_ID,OPTION_NAME,VALUE,GROUP_ID)
     */
    /*
    @Table(HR_OPTION_GROUP)
    @Column(GROUP_ID,GROUP_DESC)

     */

    private int defQuesId;
    private String defQuesName;
    private String defQuesDescription;
    private int purposeId;
    private String defQuesPurposeDesc;

    public DefineQuestionnaireEntity() {
    }

    public DefineQuestionnaireEntity(int defQuesId, String defQuesName, String defQuesDescription, int purposeId) {
        this.defQuesId = defQuesId;
        this.defQuesName = defQuesName;
        this.defQuesDescription = defQuesDescription;
        this.purposeId = purposeId;
    }

    public DefineQuestionnaireEntity(int defQuesId, String defQuesName, String defQuesDescription, int purposeId, String defQuesPurposeDesc) {
        this.defQuesId = defQuesId;
        this.defQuesName = defQuesName;
        this.defQuesDescription = defQuesDescription;
        this.purposeId = purposeId;
        this.defQuesPurposeDesc = defQuesPurposeDesc;
    }

    public DefineQuestionnaireEntity(int groupId, String groupDesc) {
        this.purposeId = groupId;
        this.defQuesPurposeDesc = groupDesc;
    }

    public DefineQuestionnaireEntity(int defQuesId, String defQuesName, String defQuesDesc) {
        this.defQuesId = defQuesId;
        this.defQuesName = defQuesName;
        this.defQuesDescription = defQuesDesc;
    }

    public DefineQuestionnaireEntity(String defQuesName, String defQuesDescription) {
        this.defQuesName = defQuesName;
        this.defQuesDescription = defQuesDescription;
    }

    // <editor-fold defaultstate="collapsed" desc="   Getters and Setters    ">
    public String getGroupDesc() {
        return defQuesPurposeDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.defQuesPurposeDesc = groupDesc;
    }

    public int getGroupId() {
        return purposeId;
    }

    public void setGroupId(int groupId) {
        this.purposeId = groupId;
    }

    public int getQuesId() {
        return defQuesId;
    }

    public void setDefQuesId(int defQuesId) {
        this.defQuesId = defQuesId;
    }

    public String getQuesName() {
        return defQuesName;
    }

    public void setQuesName(String optionName) {
        this.defQuesName = optionName;
    }

    public String getDefQuesDesc() {
        return defQuesDescription;
    }

    public void setDefQuesDesc(String defQuesDescription) {
        this.defQuesDescription = defQuesDescription;
    }
    //</editor-fold>

    public boolean insertQuestDefPupose(String purposeDesc) {
        boolean checkSave = false;
        PreparedStatement psInsert = null;
        String insert = "INSERT INTO HR_QUES_PURPOSE " +
                "(PURPOSE_DESC) VALUES('" + purposeDesc + "') ";
        Connection con = null;
        try {
            con = getConnection();
            psInsert = con.prepareStatement(insert);
            if (psInsert.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsert.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    public boolean updateQuesPurpose(int purposeId, String purposeDesc) {
        boolean checkUpdate = false;
        Connection con = null;
        PreparedStatement psUpdate = null;
        String update = "Update HR_QUES_PURPOSE SET " +
                "PURPOSE_DESC='" + purposeDesc + "'" +
                "WHERE PURPOSE_ID='" + purposeId + "' ";
        try {
            con = getConnection();
            psUpdate = con.prepareStatement(update);
            if (psUpdate.executeUpdate() > 0) {
                checkUpdate = true;
            }
            psUpdate.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkUpdate;
    }

    public boolean insertUpdateQuestionnaireDefinition(ArrayList<DefineQuestionnaireEntity> optionEntityList) {
        boolean checkSave = false;
        int counter = 0;
        Connection con = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        Savepoint savePoint = null;
        String insert = "INSERT INTO HR_QUESTIONNAIRE_DEF " +
                "(DEF_QUEST_DESC, DEF_QUEST_TITLE, DEF_QUEST_PURPOSE) VALUES(?,?,?) ";
        String update = "UPDATE HR_QUESTIONNAIRE_DEF " +
                "SET DEF_QUEST_DESC=?, DEF_QUEST_TITLE=?, DEF_QUEST_PURPOSE=? " +
                "WHERE DEF_QUEST_ID=?   ";
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint = con.setSavepoint("SAVEPOINT1");
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                if (optionEntity.getQuesId() > 0) {

                    psUpdate = con.prepareStatement(update);
                    psUpdate.setString(1, optionEntity.getQuesName());
                    psUpdate.setString(2, optionEntity.getDefQuesDesc());
                    psUpdate.setInt(3, optionEntity.getGroupId());
                    psUpdate.setInt(4, optionEntity.getQuesId());
                    if (psUpdate.executeUpdate() > 0) {
                        counter++;
                    }
//                    psUpdate.close();
                } else {
                    psInsert = con.prepareStatement(insert);
                    psInsert.setString(1, optionEntity.getQuesName());
                    psInsert.setString(2, optionEntity.getDefQuesDesc());
                    psInsert.setInt(3, optionEntity.getGroupId());
                    if (psInsert.executeUpdate() > 0) {
                        counter++;
                    }
//                    psInsert.close();
                }
            }
            if (counter == optionEntityList.size()) {
                con.commit();
                checkSave = true;
            } else {
                con.rollback(savePoint);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    public boolean deleteQuestionOption(int optionId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE HR_QUESTION_OPTIONS " +
                "WHERE OPTION_ID='" + optionId + "' ";
        try {
            con = getConnection();
            psDelete = con.prepareStatement(delete);
            if (psDelete.executeUpdate() > 0) {
                checkDelete = true;
            }
            psDelete.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkDelete;
    }

    public boolean deleteOptiongroup(int groupId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE HR_OPTION_GROUP " +
                "WHERE GROUP_ID='" + groupId + "' ";
        try {
            con = getConnection();
            psDelete = con.prepareStatement(delete);
            if (psDelete.executeUpdate() > 0) {
                checkDelete = true;
            }
            psDelete.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkDelete;
    }

    public ArrayList<DefineQuestionnaireEntity> readQuestionOptions() {
        String _select = "SELECT PURPOSE_ID, PURPOSE_DESC, DEF_QUEST_ID, " +
                "DEF_QUEST_TITLE, DEF_QUEST_DESC   " +
                "FROM HR_QUESTIONNAIRE_DEF opt   " +
                "INNER JOIN HR_QUES_PURPOSE grp ON   " +
                "opt.DEF_QUEST_PURPOSE=grp.PURPOSE_ID   " +
                "order by PURPOSE_ID, DEF_QUEST_TITLE, DEF_QUEST_DESC asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<DefineQuestionnaireEntity> readQuetOption = new ArrayList<DefineQuestionnaireEntity>();
        try {
            int optId = -1;
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {

                readQuetOption.add(new DefineQuestionnaireEntity(
                        ocrs.getInt("DEF_QUEST_ID"),
                        ocrs.getString("DEF_QUEST_DESC"),
                        ocrs.getString("DEF_QUEST_TITLE"),
                        ocrs.getInt("PURPOSE_ID"),
                        ocrs.getString("PURPOSE_DESC")));
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return readQuetOption;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<DefineQuestionnaireEntity> readQuestionnairePurposes() {
        String _select = "SELECT PURPOSE_ID, PURPOSE_DESC FROM " +
                "HR_QUES_PURPOSE order by PURPOSE_DESC asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<DefineQuestionnaireEntity> readQuetOption = new ArrayList<DefineQuestionnaireEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                readQuetOption.add(new DefineQuestionnaireEntity(
                        ocrs.getInt("PURPOSE_ID"),
                        ocrs.getString("PURPOSE_DESC")));
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return readQuetOption;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<DefineQuestionnaireEntity> readDefinedQuestionnaireTitles() {
        String _select = "SELECT DEF_QUEST_ID, DEF_QUEST_TITLE, DEF_QUEST_DESC, DEF_QUEST_PURPOSE FROM " +
                "HR_QUESTIONNAIRE_DEF order by DEF_QUEST_ID asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<DefineQuestionnaireEntity> readQuetOption = new ArrayList<DefineQuestionnaireEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                readQuetOption.add(new DefineQuestionnaireEntity(
                        ocrs.getInt("DEF_QUEST_ID"),
                        ocrs.getString("DEF_QUEST_DESC"),
                        ocrs.getString("DEF_QUEST_TITLE"),
                        ocrs.getInt("DEF_QUEST_PURPOSE")));
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return readQuetOption;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<DefineQuestionnaireEntity> getQuestionnaireDef(int groupId) {
        String _select = "SELECT DEF_QUEST_ID, DEF_QUEST_TITLE, DEF_QUEST_DESC  " +
                "FROM HR_QUESTIONNAIRE_DEF    " +
                "WHERE DEF_QUEST_PURPOSE= '" + groupId + "' " +
                "order by DEF_QUEST_TITLE asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<DefineQuestionnaireEntity> readQuetOption = new ArrayList<DefineQuestionnaireEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                readQuetOption.add(new DefineQuestionnaireEntity(
                        ocrs.getString("DEF_QUEST_TITLE"),
                        ocrs.getString("DEF_QUEST_DESC")));
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return readQuetOption;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getQuestionOptionsLabel(int groupId) {
        String _select = "SELECT DEF_QUEST_TITLE,DEF_QUEST_DESC  " +
                "FROM HR_QUESTIONNAIRE_DEF    " +
                "WHERE DEF_QUEST_PURPOSE= '" + groupId + "' " +
                "order by DEF_QUEST_DESC asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        StringBuffer bufferName = new StringBuffer();
        StringBuffer bufferValue = new StringBuffer();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                bufferName.append(ocrs.getString("DEF_QUEST_TITLE"));
                bufferName.append("\t");
                bufferValue.append(ocrs.getInt("DEF_QUEST_DESC"));
                bufferValue.append("\t");
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
//            bufferValue.append("&#8194;&#8194;&#8194;&#8194;&#8194;&#8194;&#8194;");
//            bufferName.append("\n");
//            bufferName.append(bufferValue);
//            bufferName.append("\n");
            return bufferName.toString();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
