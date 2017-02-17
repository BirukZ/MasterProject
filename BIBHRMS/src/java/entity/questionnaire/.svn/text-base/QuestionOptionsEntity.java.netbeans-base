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
public class QuestionOptionsEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTION_OPTIONS)
    @Column(OPTION_ID,OPTION_NAME,VALUE,GROUP_ID)
     */
    /*
    @Table(HR_OPTION_GROUP)
    @Column(GROUP_ID,GROUP_DESC)

     */

    private int optionId;
    private String optionName;
    private int value;
    private int groupId;
    private String groupDesc;

    public QuestionOptionsEntity() {
    }

    public QuestionOptionsEntity(int optionId, String optionName, int value, int groupId) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.value = value;
        this.groupId = groupId;
    }

    public QuestionOptionsEntity(int optionId, String optionName, int value, int groupId, String groupDesc) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.value = value;
        this.groupId = groupId;
        this.groupDesc = groupDesc;
    }

    public QuestionOptionsEntity(int groupId, String groupDesc) {
        this.groupId = groupId;
        this.groupDesc = groupDesc;
    }

    public QuestionOptionsEntity(String optionName, int value) {
        this.optionName = optionName;
        this.value = value;
    }

    // <editor-fold defaultstate="collapsed" desc="   Getters and Setters    ">
    public String getGroupDesc() {
        return groupDesc;
    }

    public void setGroupDesc(String groupDesc) {
        this.groupDesc = groupDesc;
    }

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public int getOptionId() {
        return optionId;
    }

    public void setOptionId(int optionId) {
        this.optionId = optionId;
    }

    public String getOptionName() {
        return optionName;
    }

    public void setOptionName(String optionName) {
        this.optionName = optionName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    //</editor-fold>

    public boolean insertOptionGroup(String groupDesc) {
        boolean checkSave = false;
        PreparedStatement psInsert = null;
        String insert = "INSERT INTO HR_OPTION_GROUP " +
                "(GROUP_DESC) VALUES('" + groupDesc + "') ";
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

    public boolean updateOptionGroup(int groupId, String groupDesc) {
        boolean checkUpdate = false;
        Connection con = null;
        PreparedStatement psUpdate = null;
        String update = "Update HR_OPTION_GROUP SET " +
                "GROUP_DESC='" + groupDesc + "'" +
                "WHERE GROUP_ID='" + groupId + "' ";
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

    public boolean insertUpdateQuestionOption(ArrayList<QuestionOptionsEntity> optionEntityList) {
        boolean checkSave = false;
        int counter = 0;
        Connection con = null;
        PreparedStatement psInsert = null;
        PreparedStatement psUpdate = null;
        Savepoint savePoint = null;
        String insert = "INSERT INTO HR_QUESTION_OPTIONS " +
                "(OPTION_NAME,VALUE,GROUP_ID) VALUES(?,?,?) ";
        String update = "UPDATE HR_QUESTION_OPTIONS " +
                "SET OPTION_NAME=?,VALUE=?,GROUP_ID=? " +
                "WHERE OPTION_ID=?   ";
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint = con.setSavepoint("SAVEPOINT1");
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
                if (optionEntity.getOptionId() > 0) {
                    
                    psUpdate = con.prepareStatement(update);
                    psUpdate.setString(1, optionEntity.getOptionName());
                    psUpdate.setInt(2, optionEntity.getValue());
                    psUpdate.setInt(3, optionEntity.getGroupId());
                    psUpdate.setInt(4, optionEntity.getOptionId());
                    if (psUpdate.executeUpdate() > 0) {
                        counter++;
                    }
//                    psUpdate.close();
                } else {
                    psInsert = con.prepareStatement(insert);
                    psInsert.setString(1, optionEntity.getOptionName());
                    psInsert.setInt(2, optionEntity.getValue());
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

    public ArrayList<QuestionOptionsEntity> readQuestionOptions() {
        String _select = "SELECT OPTION_ID,OPTION_NAME," +
                "VALUE,grp.GROUP_ID,GROUP_DESC " +
                "FROM HR_QUESTION_OPTIONS opt " +
                "INNER JOIN HR_OPTION_GROUP grp ON " +
                "opt.GROUP_ID=grp.GROUP_ID " +
                "order by GROUP_ID,GROUP_DESC,VALUE asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<QuestionOptionsEntity> readQuetOption = new ArrayList<QuestionOptionsEntity>();
        try {
             int optId = -1;
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {

                readQuetOption.add(new QuestionOptionsEntity(
                        ocrs.getInt("OPTION_ID"),
                        ocrs.getString("OPTION_NAME"),
                        ocrs.getInt("VALUE"),
                        ocrs.getInt("GROUP_ID"),
                        ocrs.getString("GROUP_DESC")));
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

    public ArrayList<QuestionOptionsEntity> readOptionsGroup() {
        String _select = "SELECT GROUP_ID,GROUP_DESC FROM " +
                "HR_OPTION_GROUP order by GROUP_DESC asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<QuestionOptionsEntity> readQuetOption = new ArrayList<QuestionOptionsEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                readQuetOption.add(new QuestionOptionsEntity(
                        ocrs.getInt("GROUP_ID"),
                        ocrs.getString("GROUP_DESC")));
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

    public ArrayList<QuestionOptionsEntity> getQuestionOptions(int groupId) {
        String _select = "SELECT OPTION_NAME,VALUE  " +
                "FROM HR_QUESTION_OPTIONS    " +
                "WHERE GROUP_ID= '" + groupId + "' " +
                "order by VALUE asc";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        ArrayList<QuestionOptionsEntity> readQuetOption = new ArrayList<QuestionOptionsEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                readQuetOption.add(new QuestionOptionsEntity(
                        ocrs.getString("OPTION_NAME"),
                        ocrs.getInt("VALUE")));
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
        String _select = "SELECT OPTION_NAME,VALUE  " +
                "FROM HR_QUESTION_OPTIONS    " +
                "WHERE GROUP_ID= '" + groupId + "' " +
                "order by VALUE asc";
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
                bufferName.append(ocrs.getString("OPTION_NAME"));
                bufferName.append("\t");
                bufferValue.append(ocrs.getInt("VALUE"));
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
