/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.questionnaire;

import connectionProvider.ConnectionManager;
import entity.employeeEntity.EmployeeEntity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import manager.questionnaire.DynamicField;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Bini
 */
public class QuestionnaireAnswerEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTIONNAIRE_ANSWER)
    @Column(QUESTIONNAIRE_ANS_ID,ANSWERED_BY,ANSWERED_ON,REVIEWDED_BY,
    REVIEWED_ON,SUPERVISOR,SUPERVISED_ON,STATUS,QUESTONNAIRE_ID)
     */
    /*
    @Table(HR_QUESTION_ANSWER)
    @Column(QUESTION_ANS_ID,QUESTION_ID,ANSWER,QUESTIONNAIRE_ANS_ID)
     */
    /*
    @Table(HR_QUESTION_TABLE_ANSWER)
    @Column(TBL_QUES_ANS_ID,TBL_QUES_ID,ANSWER,QUESTIONNAIRE_ANS_ID)
     */

    private int questionnaireAnsId;
    private int questionnaireId;
    private String answeredBy;
    private String answeredOn;
    private int questionAnsId;
    private int questionId;
    private String answer;
    private int tblQuestAnsId;
    private int tblQuestId;
    private String tblAnswer;
    AllQuestionsEntity allQuestionsEntity = new AllQuestionsEntity();
    EmployeeEntity employeeEntity = new EmployeeEntity();

    public QuestionnaireAnswerEntity() {
    }

    public QuestionnaireAnswerEntity(int questionnaireId, String answeredBy, String answeredOn) {
        this.questionnaireId = questionnaireId;
        this.answeredBy = answeredBy;
        this.answeredOn = answeredOn;
    }

    public QuestionnaireAnswerEntity(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public QuestionnaireAnswerEntity(String tblAnswer, int tblQuestId) {
        this.tblQuestId = tblQuestId;
        this.tblAnswer = tblAnswer;
    }

    // <editor-fold defaultstate="collapsed" desc="    Getters and Setters    ">
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnsweredBy() {
        return answeredBy;
    }

    public void setAnsweredBy(String answeredBy) {
        this.answeredBy = answeredBy;
    }

    public String getAnsweredOn() {
        return answeredOn;
    }

    public void setAnsweredOn(String answeredOn) {
        this.answeredOn = answeredOn;
    }

    public int getQuestionAnsId() {
        return questionAnsId;
    }

    public void setQuestionAnsId(int questionAnsId) {
        this.questionAnsId = questionAnsId;
    }

    public int getQuestionId() {
        return questionId;
    }

    public void setQuestionId(int questionId) {
        this.questionId = questionId;
    }

    public int getQuestionnaireAnsId() {
        return questionnaireAnsId;
    }

    public void setQuestionnaireAnsId(int questionnaireAnsId) {
        this.questionnaireAnsId = questionnaireAnsId;
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getTblAnswer() {
        return tblAnswer;
    }

    public void setTblAnswer(String tblAnswer) {
        this.tblAnswer = tblAnswer;
    }

    public int getTblQuestAnsId() {
        return tblQuestAnsId;
    }

    public void setTblQuestAnsId(int tblQuestAnsId) {
        this.tblQuestAnsId = tblQuestAnsId;
    }

    public int getTblQuestId() {
        return tblQuestId;
    }

    public void setTblQuestId(int tblQuestId) {
        this.tblQuestId = tblQuestId;
    }
    // </editor-fold>

    public boolean saveQuestionnaireAnswer(DynamicField answerEntity,
            ArrayList<DynamicField> answerList, ArrayList<DynamicField>[] tblAnswerList) {
        boolean checkSave = false;
        Connection con = null;
        Savepoint savePoint = null;
        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint = con.setSavepoint("SAVEPOINT1");
            if (insertQuestionnaireAnswer(answerEntity, con)) {
                if (insertQuestionAnswer(answerList, con)) {
//                    if (insertQuestionAnswerTable(tblAnswerList, con)) {
                        con.commit();
                        checkSave = true;
//                    } else {
//                        con.rollback(savePoint);
//                        checkSave = false;
//                    }
                } else {
                    con.rollback(savePoint);
                    checkSave = false;
                }
            } else {
                checkSave = false;
            }

            closePooledConnections(con);
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionnaireAnswer(DynamicField answerEntity, Connection con) {
        boolean checkSave = false;
        PreparedStatement ps = null;
        String insert = "INSERT INTO HR_QUESTIONNAIRE_ANSWER " +
                " (QUESTIONNAIRE_ANS_ID, ANSWERED_BY,ANSWERED_ON,QUESTIONNAIRE_ID)" +
                " VALUES(SEQ_HR_QUESTIONNAIRE_ANSWER.NEXTVAL, ?,?,?) ";
        try {
            ps = con.prepareStatement(insert);
            ps.setString(1, answerEntity.getAnsweredBy());
            ps.setString(2, answerEntity.getAnsweredOn());
            ps.setInt(3, answerEntity.getQuestionnaireId());
            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    private boolean insertQuestionAnswer(ArrayList<DynamicField> answerList, Connection con) {
        PreparedStatement ps = null;
        String insert = "INSERT INTO HR_QUESTION_ANSWER " +
                "(QUESTION_ID,ANSWER, QUESTIONNAIRE_ANS_ID)VALUES(?, ?, SEQ_HR_QUESTIONNAIRE_ANSWER.CURRVAL) ";

        try {
            if (answerList != null && !answerList.isEmpty()) {
                for (DynamicField answerEntity : answerList) {
                    ps = con.prepareStatement(insert);
                    ps.setInt(1, answerEntity.getQuestionId());
                    ps.setString(2, answerEntity.getAnswer());

                    if (ps.executeUpdate() < 1) {
                        return false;
                    }
                }
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean insertQuestionAnswerTable(ArrayList<DynamicField>[] tblAnswerList, Connection con) {
        PreparedStatement ps = null;
        String insert = "INSERT INTO HR_QUESTION_TABLE_ANSWER " +
                "(QUESTIONNAIRE_ANS_ID,TBL_QUES_ID,ANSWER)VALUES(SEQ_HR_QUESTION_ANSWER.CURRVAL,?,?) ";
        String _answer = "";
        try {
            for (int i = 0; i < tblAnswerList.length; i++) {
                for (DynamicField answerEntity : tblAnswerList[i]) {
                    int count = allQuestionsEntity.numberOfColumn(answerEntity.getQuestColId(), con);
                    StringBuffer buffer = new StringBuffer();
                    for (int j = 1; j <= count; j++) {
                        if (j == 1) {
                            buffer.append(answerEntity.getAnswer1());
                            buffer.append("@@");
                        } else if (j == 2) {
                            buffer.append(answerEntity.getAnswer2());
                            buffer.append("@@");
                        } else if (j == 3) {
                            buffer.append(answerEntity.getAnswer3());
                            buffer.append("@@");
                        } else if (j == 4) {
                            buffer.append(answerEntity.getAnswer4());
                            buffer.append("@@");
                        } else if (j == 5) {
                            buffer.append(answerEntity.getAnswer5());
                            buffer.append("@@");
                        } else if (j == 6) {
                            buffer.append(answerEntity.getAnswer6());
                            buffer.append("@@");
                        } else if (j == 7) {
                            buffer.append(answerEntity.getAnswer7());
                            buffer.append("@@");
                        } else if (j == 8) {
                            buffer.append(answerEntity.getAnswer8());
                            buffer.append("@@");
                        } else if (j == 9) {
                            buffer.append(answerEntity.getAnswer9());
                            buffer.append("@@");
                        } else if (j == 10) {
                            buffer.append(answerEntity.getAnswer10());
                            buffer.append("@@");
                        } else if (j == 11) {
                            buffer.append(answerEntity.getAnswer11());
                            buffer.append("@@");
                        } else if (j == 12) {
                            buffer.append(answerEntity.getAnswer12());
                            buffer.append("@@");
                        }
                    }
                    _answer = buffer.substring(0, buffer.lastIndexOf("@@"));
                    ps = con.prepareStatement(insert);
                    ps.setInt(1, answerEntity.getQuestColId());
                    ps.setString(2, _answer);
                    if (ps.executeUpdate() < 1) {
                        return false;
                    }
                    ps.close();
                }
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<HashMap> selectAllQuestionnaireAnswer(int questionnaireId) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT DISTINCT (  " +
                "emp.FIRST_NAME ||' '||    " +
                "emp.MIDDLE_NAME  ||' '||    " +
                "emp.LAST_NAME ) AS FULL_NAME,    " +
                "TRNG.NEED_ASSESSEMENT_REQUEST_ID AS EVENTID, " +
                "TRNG.TRAINING_NAME AS EVENT, ans.QUESTIONNAIRE_ANS_ID    " +
                "FROM HR_QUESTIONNAIRE_ANSWER ans    " +
                "INNER JOIN HR_QUESTIONAIRE qus     " +
                "ON ans.QUESTIONNAIRE_ID=qus.QUESTIONNAIRE_ID    " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ TRNG    " +
                "ON TRNG.NEED_ASSESSEMENT_REQUEST_ID=qus.educ_code    " +
                "INNER JOIN HR_EMPLOYEE_INFO emp    " +
                "ON ans.ANSWERED_BY= emp.EMP_ID    " +
                "WHERE ans.QUESTIONNAIRE_ID='" + questionnaireId + "'";
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
                hm.put("queAnsId", ocrs.getInt("QUESTIONNAIRE_ANS_ID"));
                hm.put("fullName", ocrs.getString("FULL_NAME"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return quesList;
    }

    public HashMap selectQuestionnaireAnswerDetail(int questionnaireAnsId) {
        HashMap quesList = new HashMap();
        HashMap appendquesList = new HashMap();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT (emp.FIRST_NAME ||' '||     " +
                "EMP.MIDDLE_NAME  ||' '||        " +
                "EMP.LAST_NAME ) AS FULL_NAME, EMP.RANK_ID,    " +
                "D.DEPT_ID, D.DEP_DESCRIPTION,    " +
                "J.JOB_CODE, J.JOB_DESCRIPTION,   " +
                "ANSWERED_BY,ANSWERED_ON,REVIEWDED_BY,    " +
                "REVIEWDED_ON,SUPERVISOR,SUPERVISED_ON,STATUS      " +
                "FROM HR_QUESTIONNAIRE_ANSWER     " +
                "INNER JOIN HR_EMPLOYEE_INFO EMP   " +
                "ON ANSWERED_BY= EMP.EMP_ID   " +
                "INNER JOIN TBL_DEPARTMENT D   " +
                "ON EMP.DEPARTMENT_ID = D.DEPT_ID   " +
                "INNER JOIN HR_LU_JOB_TYPE J   " +
                "ON J.JOB_CODE = EMP.JOB_CODE   " +
                "WHERE QUESTIONNAIRE_ANS_ID='"+questionnaireAnsId+"'";
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            
            if (ocrs.next()) {
   
                quesList.put("name", ocrs.getString("FULL_NAME"));
                quesList.put("job", ocrs.getString("JOB_DESCRIPTION"));
                quesList.put("dep", ocrs.getString("DEP_DESCRIPTION"));
                quesList.put("rank", ocrs.getString("RANK_ID"));
                quesList.put("answeredBy", ocrs.getString("ANSWERED_BY"));
                quesList.put("answeredOn", ocrs.getString("ANSWERED_ON"));
//                quesList.put("reviwedBy", ocrs.getString("REVIEWDED_BY"));
//                quesList.put("reviwedOn", ocrs.getString("REVIEWEDED_ON"));
                quesList.put("superviser", ocrs.getString("SUPERVISOR"));
                quesList.put("supervisedOn", ocrs.getString("SUPERVISED_ON"));
                quesList.put("status", ocrs.getInt("STATUS"));

                if (ocrs.getString("ANSWERED_BY") != null) {
                    appendquesList = employeeEntity.readEmployeeBasicInfoFromId(ocrs.getString("ANSWERED_BY"));
                    quesList.putAll(appendquesList);
                }
//                if (ocrs.getString("REVIEWDED_BY") != null) {
//                    appendquesList = employeeEntity.readEmployeeBasicInfoFromId(ocrs.getString("REVIEWDED_BY"));
//                    quesList.putAll(appendquesList);
//                }
                if (ocrs.getString("SUPERVISOR") != null) {
                    appendquesList = employeeEntity.readEmployeeBasicInfoFromId(ocrs.getString("SUPERVISOR"));
                    quesList.putAll(appendquesList);
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return quesList;
    }

    public ArrayList<HashMap> selectQuestionsAnswer(int questionnaireAnsId) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT QUESTION_ANS_ID,ans.QUESTION_ID,ANSWER, " +
                "QUESTION_SECTION_ID,QUESTION_TYPE_ID " +
                "FROM HR_QUESTION_ANSWER ans " +
                "INNER JOIN HR_QUESTION que " +
                "ON ans.QUESTION_ID=que.QUESTION_ID " +
                "WHERE QUESTIONNAIRE_ANS_ID='" + questionnaireAnsId + "'";
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
                hm.put("queAnsId", ocrs.getInt("QUESTION_ANS_ID"));
                hm.put("quesId", ocrs.getInt("QUESTION_ID"));
                hm.put("answer", ocrs.getString("ANSWER"));
                hm.put("sectionId", ocrs.getInt("QUESTION_SECTION_ID"));
                hm.put("typeId", ocrs.getInt("QUESTION_TYPE_ID"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return quesList;
    }

    public ArrayList<HashMap> selectTableQuestionsAnswer(int questionnaireAnsId) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        /*
        @Table(HR_QUESTION_TABLE_ANSWER)
        @Column(TBL_QUES_ANS_ID,TBL_QUES_ID,ANSWER,QUESTIONNAIRE_ANS_ID)
         */
        String select = "SELECT TBL_QUES_ANS_ID,TBL_QUES_ID,ANSWER  " +
                "FROM HR_QUESTION_TABLE_ANSWER " +
                "WHERE QUESTIONNAIRE_ANS_ID='" + questionnaireAnsId + "'";
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
                hm.put("queAnsId", ocrs.getInt("TBL_QUES_ANS_ID"));
                hm.put("tblQuesId", ocrs.getInt("TBL_QUES_ID"));
                hm.put("answer", ocrs.getString("ANSWER"));
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
