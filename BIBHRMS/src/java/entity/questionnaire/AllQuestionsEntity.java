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
public class AllQuestionsEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTION)
    @Column(QUESTION_ID,QUESTION,QUESTION_SECTION_ID,QUESTION_TYPE_ID
    TABLE_FORM,QUESTION_NUMBER,OPTION_GROUP_ID)
     */
    /*
    @Table(HR_QUESTION_TABLE)
    @Column(QUEST_TBL_ID,QUESTION_ID,COLUMN_NAME,COLUMN_TYPE,QUESTION_TYPE,
    OPTION_GROUP_ID,ORDER_NO)
     */
    /*
    @Table(HR_QUESTION_COLUMN)QUESTION_ID
    @Column(QUEST_COL_ID,QUEST_TBL_ID,QUESTION)
     */

    private int questionId;
    private String question;
    private int questionSection;
    private int questionType;
    private int tableForm;
    private int questionNo;
    private int optionGroupId;
    private int questTblId;
    private String columnName;
    private int columnType;
    private int orderNo;
    private int questColumnId;
    private String optionGroupDesc;
    private int defQuesId;
    private String defQuesName;

    public AllQuestionsEntity() {
    }

    public AllQuestionsEntity(int questionId, String question, int questionSection, int questionType, int tableForm, int questionNo, int optionGroupId, int defQuesId) {
        this.questionId = questionId;
        this.question = question;
        this.questionSection = questionSection;
        this.questionType = questionType;
        this.tableForm = tableForm;
        this.questionNo = questionNo;
        this.optionGroupId = optionGroupId;
        this.defQuesId = defQuesId;
    }

    public AllQuestionsEntity(int questionId, String question, int questionSection, int questionType, int tableForm, int questionNo, int optionGroupId, String optionGroupDesc, int defQuesId) {
        this.questionId = questionId;
        this.question = question;
        this.questionSection = questionSection;
        this.questionType = questionType;
        this.tableForm = tableForm;
        this.questionNo = questionNo;
        this.optionGroupId = optionGroupId;
        this.optionGroupDesc = optionGroupDesc;
        this.defQuesId = defQuesId;
    }

    public AllQuestionsEntity(int questTblId, String columnName, int columnType, int questionType, int optionGroupId, int orderNo, String optionGroupDesc) {
        this.questTblId = questTblId;
        this.columnName = columnName;
        this.columnType = columnType;
        this.questionType = questionType;
        this.optionGroupId = optionGroupId;
        this.orderNo = orderNo;
        this.optionGroupDesc = optionGroupDesc;
    }

    public AllQuestionsEntity(int questTblId, String columnName, int columnType, int questionType, int optionGroupId, int orderNo) {
        this.questTblId = questTblId;
        this.columnName = columnName;
        this.columnType = columnType;
        this.questionType = questionType;
        this.optionGroupId = optionGroupId;
        this.orderNo = orderNo;
    }

    public AllQuestionsEntity(int questTblId, int questColumnId, String question, String columnName) {
        this.questTblId = questTblId;
        this.questColumnId = questColumnId;
        this.question = question;
        this.columnName = columnName;
    }

    public AllQuestionsEntity(int questColumnId, String question) {
        this.question = question;
        this.questColumnId = questColumnId;
    }

    // <editor-fold defaultstate="collapsed" desc="   Getters and Setters    ">
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public int getColumnType() {
        return columnType;
    }

    public void setColumnType(int columnType) {
        this.columnType = columnType;
    }

    public int getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(int optionGroupId) {
        this.optionGroupId = optionGroupId;
    }

    public int getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(int orderNo) {
        this.orderNo = orderNo;
    }

    public int getQuestColumnId() {
        return questColumnId;
    }

    public void setQuestColumnId(int questColumnId) {
        this.questColumnId = questColumnId;
    }

    public int getQuestTblId() {
        return questTblId;
    }

    public void setQuestTblId(int questTblId) {
        this.questTblId = questTblId;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionNo() {
        return questionNo;
    }

    public void setQuestionNo(int questionNo) {
        this.questionNo = questionNo;
    }

    public int getQuestionSection() {
        return questionSection;
    }

    public void setQuestionSection(int questionSection) {
        this.questionSection = questionSection;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int questionType) {
        this.questionType = questionType;
    }

    public int getTableForm() {
        return tableForm;
    }

    public void setTableForm(int tableForm) {
        this.tableForm = tableForm;
    }

    public String getOptionGroupDesc() {
        return optionGroupDesc;
    }

    public void setOptionGroupDesc(String optionGroupDesc) {
        this.optionGroupDesc = optionGroupDesc;
    }
    //</editor-fold>

    public boolean insertAllQuestion(AllQuestionsEntity questionEntity, ArrayList<AllQuestionsEntity> questionTableList, ArrayList<AllQuestionsEntity> questionColumnList) {
        boolean checkQuestion = false;
        boolean checkQuestionTable = false;
        Connection con = null;
        Savepoint savePoint = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint = con.setSavepoint("SAVEPOINT1");
            checkQuestion = insertQuestion(questionEntity, con);
            if (checkQuestion) {
                if (questionEntity.getTableForm() == 1) {
                    for (AllQuestionsEntity tblEntity : questionTableList) {
                        checkQuestionTable = insertQuestionTable(tblEntity, con);
                        if (checkQuestionTable && tblEntity.getColumnType() == 0) {
                            for (AllQuestionsEntity colQuestion : questionColumnList) {
                                if (tblEntity.getColumnName().equalsIgnoreCase(colQuestion.getColumnName())) {
                                    if (!insertQuestionColumn(colQuestion, con)) {
                                        con.rollback(savePoint);
                                        return false;
                                    }
                                }
                            }
                        } else if (!checkQuestionTable) {
                            con.rollback(savePoint);
                            return false;
                        }
                    }
                }
                con.commit();
                closePooledConnections(con);
            }
            return checkQuestion;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                closePooledConnections(con);
            } catch (Exception e) {
            }
        }
    }

    public boolean updateAllQuestion(AllQuestionsEntity questionEntity, ArrayList<AllQuestionsEntity> questionTableList, ArrayList<AllQuestionsEntity> questionColumnList) {
        boolean checkQuestion = false;
        boolean checkInsertTable = false;
        boolean checkUpdateTable = false;
        Connection con = null;
        Savepoint savePoint = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint = con.setSavepoint("SAVEPOINT1");
            checkQuestion = updateQuestion(questionEntity, con);
            if (checkQuestion) {
                if (questionEntity.getTableForm() == 1) {
                    for (AllQuestionsEntity tblEntity : questionTableList) {
                        if (tblEntity.getQuestTblId() > 0) {
                            checkUpdateTable = updateQuestionTable(tblEntity, con);
                        } else {
                            tblEntity.setQuestionId(questionEntity.getQuestionId());
                            checkInsertTable = insertQuestionTableOnUpdate(tblEntity, con);
                        }
                        if (checkInsertTable && tblEntity.getColumnType() == 0) {
                            for (AllQuestionsEntity colQuestion : questionColumnList) {
                                if (tblEntity.getColumnName().equalsIgnoreCase(colQuestion.getColumnName())) {
                                    if (!insertQuestionColumn(colQuestion, con)) {
                                        con.rollback(savePoint);
                                        return false;
                                    }
                                }
                            }
                        } else if (checkUpdateTable && tblEntity.getColumnType() == 0) {
                            for (AllQuestionsEntity colQuestion : questionColumnList) {
                                if (tblEntity.getColumnName().equalsIgnoreCase(colQuestion.getColumnName())) {
                                    if (colQuestion.getQuestColumnId() > 0) {
                                        if (!updateQuestionColumn(colQuestion, con)) {
                                            con.rollback(savePoint);
                                            return false;
                                        }
                                    } else if (!insertQuestionColumnOnUpdate(colQuestion, con)) {
                                        con.rollback(savePoint);
                                        return false;
                                    }
                                }
                            }
                        } else if (!checkInsertTable && !checkUpdateTable) {
                            con.rollback(savePoint);
                            return false;
                        }
                    }
                }
                con.commit();
                closePooledConnections(con);
            }
            return checkQuestion;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                closePooledConnections(con);
            } catch (Exception e) {
            }
        }
    }

    private boolean insertQuestion(AllQuestionsEntity questionEntity, Connection con) {
        boolean checkSave = false;
        PreparedStatement psInsertQuestion = null;
        String insertQuestion = "INSERT INTO HR_QUESTION " +
                "(QUESTION,QUESTION_SECTION_ID,QUESTION_TYPE_ID, " +
                "TABLE_FORM,QUESTION_NUMBER,OPTION_GROUP_ID, DEF_QUES_ID) VALUES(?,?,?,?,?,?,?) ";
        try {
            psInsertQuestion = con.prepareStatement(insertQuestion);
            String option = (questionEntity.getOptionGroupId() == 0) ? null : String.valueOf(questionEntity.getOptionGroupId());
            psInsertQuestion.setString(1, questionEntity.getQuestion());
            psInsertQuestion.setInt(2, questionEntity.getQuestionSection());
            psInsertQuestion.setInt(3, questionEntity.getQuestionType());
            psInsertQuestion.setInt(4, questionEntity.getTableForm());
            psInsertQuestion.setInt(5, questionEntity.getQuestionNo());
            psInsertQuestion.setString(6, option);
            psInsertQuestion.setInt(7, questionEntity.getDefQuesId());
            if (psInsertQuestion.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsertQuestion.close();
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionTable(AllQuestionsEntity questionTable, Connection con) {
        boolean checkSave = false;
        PreparedStatement psInsertQuestionTable = null;
        String insertQuestionTable = "INSERT INTO HR_QUESTION_TABLE " +
                "(QUESTION_ID,COLUMN_NAME,COLUMN_TYPE,QUESTION_TYPE, " +
                "OPTION_GROUP_ID,ORDER_NO) VALUES(SEQ_HR_QUESTION.CURRVAL,?,?,?,?,?) ";
        try {
            String option = (questionTable.getOptionGroupId() == 0) ? null : String.valueOf(questionTable.getOptionGroupId());
            psInsertQuestionTable = con.prepareStatement(insertQuestionTable);
            psInsertQuestionTable.setString(1, questionTable.getColumnName());
            psInsertQuestionTable.setInt(2, questionTable.getColumnType());
            psInsertQuestionTable.setInt(3, questionTable.getQuestionType());
            psInsertQuestionTable.setString(4, option);
            psInsertQuestionTable.setInt(5, questionTable.getOrderNo());
            if (psInsertQuestionTable.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsertQuestionTable.close();
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionTableOnUpdate(AllQuestionsEntity questionTable, Connection con) {
        boolean checkSave = false;
        PreparedStatement psInsertQuestionTable = null;
        String insertQuestionTable = "INSERT INTO HR_QUESTION_TABLE " +
                "(QUESTION_ID,COLUMN_NAME,COLUMN_TYPE,QUESTION_TYPE, " +
                "OPTION_GROUP_ID,ORDER_NO) VALUES(?,?,?,?,?,?) ";
        try {
            psInsertQuestionTable = con.prepareStatement(insertQuestionTable);
            psInsertQuestionTable.setInt(1, questionTable.getQuestionId());
            psInsertQuestionTable.setString(2, questionTable.getColumnName());
            psInsertQuestionTable.setInt(3, questionTable.getColumnType());
            psInsertQuestionTable.setInt(4, questionTable.getQuestionType());
            psInsertQuestionTable.setInt(5, questionTable.getOptionGroupId());
            psInsertQuestionTable.setInt(6, questionTable.getOrderNo());
            if (psInsertQuestionTable.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsertQuestionTable.close();
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionColumn(AllQuestionsEntity questionColumn, Connection con) {
        boolean checkSave = false;
        PreparedStatement psInsertQuestionColumn = null;
        String insertQuestionColumn = "INSERT INTO HR_QUESTION_COLUMN " +
                "(QUEST_TBL_ID,QUESTION) VALUES(SEQ_HR_QUESTION_TABLE.CURRVAL,?) ";
        try {
            psInsertQuestionColumn = con.prepareStatement(insertQuestionColumn);
            psInsertQuestionColumn.setString(1, questionColumn.getQuestion());
            if (psInsertQuestionColumn.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsertQuestionColumn.close();
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionColumnOnUpdate(AllQuestionsEntity questionColumn, Connection con) {
        boolean checkSave = false;
        PreparedStatement psInsertQuestionColumn = null;
        String insertQuestionColumn = "INSERT INTO HR_QUESTION_COLUMN " +
                "(QUEST_TBL_ID,QUESTION) VALUES(?,?) ";
        try {
            psInsertQuestionColumn = con.prepareStatement(insertQuestionColumn);
            psInsertQuestionColumn.setInt(1, questionColumn.getQuestTblId());
            psInsertQuestionColumn.setString(2, questionColumn.getQuestion());
            if (psInsertQuestionColumn.executeUpdate() > 0) {
                checkSave = true;
            }
            psInsertQuestionColumn.close();
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean updateQuestion(AllQuestionsEntity questionEntity, Connection con) {
        boolean checkUpdate = false;
        PreparedStatement psUpdateQuestion = null;
        String updateQuestion = "UPDATE HR_QUESTION SET " +
                "QUESTION=?,QUESTION_SECTION_ID=?,QUESTION_TYPE_ID=?, " +
                "TABLE_FORM=?,QUESTION_NUMBER=?,OPTION_GROUP_ID=?, DEF_QUES_ID=?  " +
                "WHERE QUESTION_ID=?";
        try {
            psUpdateQuestion = con.prepareStatement(updateQuestion);
            psUpdateQuestion.setString(1, questionEntity.getQuestion());
            psUpdateQuestion.setInt(2, questionEntity.getQuestionSection());
            psUpdateQuestion.setInt(3, questionEntity.getQuestionType());
            psUpdateQuestion.setInt(4, questionEntity.getTableForm());
            psUpdateQuestion.setInt(5, questionEntity.getQuestionNo());
            psUpdateQuestion.setInt(6, questionEntity.getOptionGroupId());
            psUpdateQuestion.setInt(7, questionEntity.getDefQuesId());
            psUpdateQuestion.setInt(8, questionEntity.getQuestionId());
            if (psUpdateQuestion.executeUpdate() > 0) {
                checkUpdate = true;
            }
            psUpdateQuestion.close();
            return checkUpdate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean updateQuestionTable(AllQuestionsEntity questionTable, Connection con) {
        boolean checkUpdate = false;
        PreparedStatement psUpdateQuestionTable = null;
        String updateQuestionTable = "UPDATE HR_QUESTION_TABLE SET " +
                "COLUMN_NAME=?,COLUMN_TYPE=?,QUESTION_TYPE=?, " +
                "OPTION_GROUP_ID=?,ORDER_NO=? WHERE QUEST_TBL_ID=? ";
        try {
            psUpdateQuestionTable = con.prepareStatement(updateQuestionTable);
            psUpdateQuestionTable.setString(1, questionTable.getColumnName());
            psUpdateQuestionTable.setInt(2, questionTable.getColumnType());
            psUpdateQuestionTable.setInt(3, questionTable.getQuestionType());
            psUpdateQuestionTable.setInt(4, questionTable.getOptionGroupId());
            psUpdateQuestionTable.setInt(5, questionTable.getOrderNo());
            psUpdateQuestionTable.setInt(6, questionTable.getQuestTblId());
            if (psUpdateQuestionTable.executeUpdate() > 0) {
                checkUpdate = true;
            }
            psUpdateQuestionTable.close();
            return checkUpdate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean updateQuestionColumn(AllQuestionsEntity questionColumn, Connection con) {
        boolean checkUpdate = false;
        PreparedStatement psUpdateQuestionColumn = null;
        String updateQuestionColumn = "UPDATE HR_QUESTION_COLUMN SET " +
                "QUESTION=? WHERE QUEST_COL_ID=? ";
        try {
            psUpdateQuestionColumn = con.prepareStatement(updateQuestionColumn);
            psUpdateQuestionColumn.setString(1, questionColumn.getQuestion());
            psUpdateQuestionColumn.setInt(2, questionColumn.getQuestColumnId());
            if (psUpdateQuestionColumn.executeUpdate() > 0) {
                checkUpdate = true;
            }
            psUpdateQuestionColumn.close();
            return checkUpdate;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteQuestion(int questionId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE HR_QUESTION " +
                "WHERE QUESTION_ID='" + questionId + "' ";
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

    public boolean deleteQuestionTable(int questTblId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE  HR_QUESTION_TABLE " +
                "WHERE QUESTION_ID= '" + questTblId + "' ";
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

    public boolean deleteQuestionTableByQuestionId(int questionId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE  HR_QUESTION_TABLE " +
                "WHERE QUEST_TBL_ID= '" + questionId + "' ";
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

    public boolean deleteQuestionColumn(int questColumnId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement psDelete = null;
        String delete = "DELETE HR_QUESTION_COLUMN " +
                "WHERE QUEST_COL_ID= '" + questColumnId + "' ";
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

    public ArrayList<AllQuestionsEntity> selectAllQuestion(int defQuesId) {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT QUESTION_ID,QUESTION," +
                " QUESTION_SECTION_ID,QUESTION_TYPE_ID,TABLE_FORM, DEF_QUES_ID, " +
                " GROUP_DESC,QUESTION_NUMBER,nvl(OPTION_GROUP_ID,'0') OPTION_GROUP_ID " +
                " FROM HR_QUESTION LEFT JOIN " +
                " HR_OPTION_GROUP ON OPTION_GROUP_ID=GROUP_ID ";
        if (defQuesId != 0) {
            selectDetail += " WHERE DEF_QUES_ID = '" + defQuesId + "'" +
                    " ORDER BY QUESTION_SECTION_ID,QUESTION_NUMBER ";
        } else {
            selectDetail += " ORDER BY QUESTION_SECTION_ID,QUESTION_NUMBER ";
        }
        ArrayList<AllQuestionsEntity> allQuestionsEntity = new ArrayList<AllQuestionsEntity>();
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            while (ocrs.next()) {
                allQuestionsEntity.add(new AllQuestionsEntity(
                        ocrs.getInt("QUESTION_ID"),
                        ocrs.getString("QUESTION"),
                        ocrs.getInt("QUESTION_SECTION_ID"),
                        ocrs.getInt("QUESTION_TYPE_ID"),
                        ocrs.getInt("TABLE_FORM"),
                        ocrs.getInt("QUESTION_NUMBER"),
                        ocrs.getInt("OPTION_GROUP_ID"),
                        ocrs.getString("GROUP_DESC"),
                        ocrs.getInt("DEF_QUES_ID")));
            }
            psDetail.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

        return allQuestionsEntity;
    }

    public ArrayList<AllQuestionsEntity> selectTblFormQuestion(int questionId) {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT QUEST_TBL_ID,COLUMN_NAME,COLUMN_TYPE," +
                "QUESTION_TYPE,nvl(OPTION_GROUP_ID, '0') OPTION_GROUP_ID,ORDER_NO,GROUP_DESC " +
                "FROM HR_QUESTION_TABLE LEFT JOIN " +
                "HR_OPTION_GROUP ON OPTION_GROUP_ID=GROUP_ID " +
                "WHERE QUESTION_ID='" + questionId + "' " +
                "ORDER BY ORDER_NO,COLUMN_NAME";
        ArrayList<AllQuestionsEntity> allQuestionsEntity = new ArrayList<AllQuestionsEntity>();
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            int i = 0;
            while (ocrs.next()) {
                allQuestionsEntity.add(new AllQuestionsEntity(
                        ocrs.getInt("QUEST_TBL_ID"),
                        ocrs.getString("COLUMN_NAME"),
                        ocrs.getInt("COLUMN_TYPE"),
                        ocrs.getInt("QUESTION_TYPE"),
                        ocrs.getInt("OPTION_GROUP_ID"),
                        ocrs.getInt("ORDER_NO"),
                        ocrs.getString("GROUP_DESC")));
            }
            psDetail.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

        return allQuestionsEntity;
    }

    public int numberOfColumn(int questColId) {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT count(QUEST_TBL_ID) as NUM   " +
                "FROM HR_QUESTION_TABLE WHERE QUESTION_ID=  " +
                "(SELECT distinct tbl.QUESTION_ID FROM  " +
                "HR_QUESTION_TABLE tbl INNER JOIN   " +
                "HR_QUESTION_COLUMN clm ON  " +
                "clm.QUEST_TBL_ID=tbl.QUEST_TBL_ID " +
                "WHERE clm.QUEST_COL_ID='" + questColId + "') ";
        int count = 0;
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            if (ocrs.next()) {
                count = ocrs.getInt("NUM");
            }
            psDetail.close();
            closePooledConnections(con);
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int numberOfColumn(int questColId, Connection con) {
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT count(QUEST_TBL_ID) as NUM   " +
                "FROM HR_QUESTION_TABLE WHERE QUESTION_ID=  " +
                "(SELECT distinct tbl.QUESTION_ID FROM  " +
                "HR_QUESTION_TABLE tbl INNER JOIN   " +
                "HR_QUESTION_COLUMN clm ON  " +
                "clm.QUEST_TBL_ID=tbl.QUEST_TBL_ID " +
                "WHERE clm.QUEST_COL_ID='" + questColId + "') ";
        int count = 0;
        try {
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            if (ocrs.next()) {
                count = ocrs.getInt("NUM");
            }
            psDetail.close();
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public ArrayList<AllQuestionsEntity> selectColumnQuestion(int questionId) {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT clm.QUEST_TBL_ID,QUEST_COL_ID,QUESTION,COLUMN_NAME " +
                "FROM HR_QUESTION_COLUMN clm INNER JOIN " +
                "HR_QUESTION_TABLE tbl " +
                "ON clm.QUEST_TBL_ID=tbl.QUEST_TBL_ID " +
                "WHERE tbl.QUESTION_ID='" + questionId + "'";
        ArrayList<AllQuestionsEntity> allQuestionsEntity = new ArrayList<AllQuestionsEntity>();
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            while (ocrs.next()) {
                allQuestionsEntity.add(new AllQuestionsEntity(
                        ocrs.getInt("QUEST_TBL_ID"),
                        ocrs.getInt("QUEST_COL_ID"),
                        ocrs.getString("QUESTION"),
                        ocrs.getString("COLUMN_NAME")));
            }
            psDetail.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return allQuestionsEntity;
    }

    public ArrayList<AllQuestionsEntity> selectColumnQuestionByTblId(int questTblId) {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT QUEST_COL_ID,QUESTION " +
                "FROM HR_QUESTION_COLUMN " +
                "WHERE QUEST_TBL_ID='" + questTblId + "' ";
        ArrayList<AllQuestionsEntity> allQuestionsEntity = new ArrayList<AllQuestionsEntity>();
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            while (ocrs.next()) {
                allQuestionsEntity.add(new AllQuestionsEntity(
                        ocrs.getInt("QUEST_COL_ID"),
                        ocrs.getString("QUESTION")));
            }
            psDetail.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return allQuestionsEntity;
    }

    public int countTableFormQuestion() {
        Connection con = null;
        PreparedStatement psDetail = null;
        ResultSet rs = null;
        String selectDetail = "SELECT Count(QUESTION_ID) as  NUM " +
                "FROM HR_QUESTION WHERE TABLE_FORM=1 ";
        int count = 0;
        try {
            con = getConnection();
            psDetail = con.prepareStatement(selectDetail);
            rs = psDetail.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            while (ocrs.next()) {
                count = ocrs.getInt("NUM");
            }
            psDetail.close();
            closePooledConnections(con);
            return count;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     * @return the defQuesId
     */
    public int getDefQuesId() {
        return defQuesId;
    }

    /**
     * @param defQuesId the defQuesId to set
     */
    public void setDefQuesId(int defQuesId) {
        this.defQuesId = defQuesId;
    }

    /**
     * @return the defQuesName
     */
    public String getDefQuesName() {
        return defQuesName;
    }

    /**
     * @param defQuesName the defQuesName to set
     */
    public void setDefQuesName(String defQuesName) {
        this.defQuesName = defQuesName;
    }
}
