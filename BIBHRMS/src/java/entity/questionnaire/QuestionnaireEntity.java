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
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Bini
 */
public class QuestionnaireEntity extends ConnectionManager {
    /*
    @Table(HR_QUESTIONAIRE)
    @Column(QUESTIONNAIRE_ID,PROP_JOB_CODE,QUES_DESCRIPTION,
    FROM_DATE,TO_DATE,PREPARED_BY,PREPARED_ON,ACTIVE )
     */

    private int questionnaireId;
    private String jobCode;
    private String questDescription;
    private String fromDate;
    private String toDate;
    private int active;
    private String preparedBy;
    private String preparedOn;
    private String defQuesId;

    public QuestionnaireEntity() {
    }

    public QuestionnaireEntity(int questionnaireId, String jobCode, String questDescription, String fromDate, String toDate, String preparedBy, String preparedOn, String defQuesId) {
        this.questionnaireId = questionnaireId;
        this.jobCode = jobCode;
        this.questDescription = questDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.preparedBy = preparedBy;
        this.preparedOn = preparedOn;
        this.defQuesId = defQuesId;
    }

    // <editor-fold defaultstate="collapsed" desc="    Getters and Setters    ">
    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getPreparedOn() {
        return preparedOn;
    }

    public void setPreparedOn(String preparedOn) {
        this.preparedOn = preparedOn;
    }

    public String getQuestDescription() {
        return questDescription;
    }

    public void setQuestDescription(String questDescription) {
        this.questDescription = questDescription;
    }

    public int getQuestionnaireId() {
        return questionnaireId;
    }

    public void setQuestionnaireId(int questionnaireId) {
        this.questionnaireId = questionnaireId;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    // </editor-fold>
    public boolean insertQuestionnaire(QuestionnaireEntity questEntity) {
        boolean checkSave = false;
        Connection con = null;
        PreparedStatement ps = null;

        String insert = "INSERT INTO HR_QUESTIONAIRE (" +
                "EDUC_CODE,QUES_DESCRIPTION,FROM_DATE,TO_DATE," +
                "PREPARED_BY,PREPARED_ON, DEF_QUES_ID) VALUES(?,?,?,?,?,?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, questEntity.getJobCode());
            ps.setString(2, questEntity.getQuestDescription());
            ps.setString(3, questEntity.getFromDate());
            ps.setString(4, questEntity.getToDate());
            ps.setString(5, questEntity.getPreparedBy());
            ps.setString(6, questEntity.getPreparedOn());
            ps.setString(7, questEntity.getDefQuesId());

            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    public boolean updateQuestionnaire(QuestionnaireEntity questEntity) {
        boolean checkUpdate = false;
        Connection con = null;
        PreparedStatement ps = null;

        String update = "UPDATE HR_QUESTIONAIRE SET " +
                "QUES_DESCRIPTION=?,FROM_DATE=?,TO_DATE=?, DEF_QUES_ID=? " +
                "WHERE QUESTIONNAIRE_ID=?";
        try {
            con = getConnection();
            ps = con.prepareStatement(update);
            ps.setString(1, questEntity.getQuestDescription());
            ps.setString(2, questEntity.getFromDate());
            ps.setString(3, questEntity.getToDate());
            ps.setInt(4, questEntity.getQuestionnaireId());
            ps.setString(5, questEntity.getDefQuesId());

            if (ps.executeUpdate() > 0) {
                checkUpdate = true;
            }
            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkUpdate;
    }

    public boolean deleteQuestionnaire(int questionnaireId) {
        boolean checkDelete = false;
        Connection con = null;
        PreparedStatement ps = null;

        String update = "DELETE HR_QUESTIONAIRE " +
                "WHERE QUESTIONNAIRE_ID='" + questionnaireId + "'";
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

    public HashMap selectQuestionnaire(int questionnaireId) {

        HashMap hm = new HashMap();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT QUS.EDUC_CODE, TRNG.NEED_ASSESSEMENT_REQUEST_ID AS EventId, TRNG.TRAINING_NAME AS EVENT, " +
                "QUS.QUES_DESCRIPTION, QUS.FROM_DATE, QUS.TO_DATE, QUS.PREPARED_BY, QUS.PREPARED_ON, QUS.DEF_QUES_ID,   " +
                "(emp.FIRST_NAME ||' '|| emp.MIDDLE_NAME  ||' '||   " +
                " emp.LAST_NAME  ) AS FULL_NAME   " +
                "FROM HR_QUESTIONAIRE QUS   " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ TRNG  " +
                "ON TRNG.NEED_ASSESSEMENT_REQUEST_ID= qus.EDUC_CODE  " +
                "INNER JOIN HR_EMPLOYEE_INFO emp   " +
                "ON qus.PREPARED_BY=emp.EMP_ID   " +
                "WHERE QUESTIONNAIRE_ID='" + questionnaireId + "'";
        String select2 = "SELECT QUS.EDUC_CODE, TR.TERMINATION_REQUEST_ID as EventId, " +
                "(E.FIRST_NAME || ' ' || E.MIDDLE_NAME || ' ' || E.LAST_NAME || ' ON ' || TR.APPLIED_DATE) as EVENT,  " +
                "QUS.QUES_DESCRIPTION, QUS.FROM_DATE, QUS.TO_DATE, QUS.PREPARED_BY, QUS.PREPARED_ON, QUS.DEF_QUES_ID,      " +
                "(E.FIRST_NAME ||' '|| E.MIDDLE_NAME  ||' '||      " +
                " E.LAST_NAME  ) AS FULL_NAME      " +
                "FROM HR_QUESTIONAIRE QUS      " +
                "INNER JOIN HR_TERMINATION_REQUEST TR     " +
                "ON TR.TERMINATION_REQUEST_ID=qus.EDUC_CODE   " +
                "INNER JOIN HR_EMPLOYEE_INFO E      " +
                "ON QUS.PREPARED_BY=E.EMP_ID      " +
                "WHERE QUESTIONNAIRE_ID='" + questionnaireId + "'";
        hm = this.buildQuestionnaires(select);
        if(hm.get("propJobCode").equals("Note Found")){
            hm = this.buildQuestionnaires(select2);
        }
        return hm;
    }

    public ArrayList<HashMap> selectQuestionnaire() {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();

        String select = "SELECT QUS.QUESTIONNAIRE_ID, QUS.EDUC_CODE, " +
                "TRNG.NEED_ASSESSEMENT_REQUEST_ID, (TRNG.TRAINING_NAME  || ' ' || " +
                "TRNG.TENTATIVE_START_DATE  || ' ' || TRNG.TENTATIVE_END_DATE) EVENT, " +
                "QUS.QUES_DESCRIPTION, QUS.FROM_DATE, QUS.TO_DATE, QUS.PREPARED_BY, " +
                "QUS.PREPARED_ON, QUS.DEF_QUES_ID     " +
                "FROM HR_QUESTIONAIRE QUS       " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ TRNG      " +
                "ON TRNG.NEED_ASSESSEMENT_REQUEST_ID = QUS.EDUC_CODE    ";
        String select2 = "SELECT QUS.QUESTIONNAIRE_ID, QUS.EDUC_CODE, " +
                "TR.TERMINATION_REQUEST_ID, (E.FIRST_NAME || ' ' || " +
                "E.MIDDLE_NAME || ' ' || E.LAST_NAME || ' ON ' || TR.APPLIED_DATE) EVENT,     " +
                "QUS.QUES_DESCRIPTION, QUS.FROM_DATE, QUS.TO_DATE, QUS.PREPARED_BY, " +
                "QUS.PREPARED_ON, QUS.DEF_QUES_ID       " +
                "FROM HR_QUESTIONAIRE QUS          " +
                "INNER JOIN HR_TERMINATION_REQUEST TR   " +
                "ON TR.TERMINATION_REQUEST_ID = QUS.EDUC_CODE       " +
                "INNER JOIN HR_EMPLOYEE_INFO E       " +
                "ON E.EMP_ID = TR.REQUESTER_ID";
        quesList = buildDefQuestionnaires(select);
        quesList.addAll(buildDefQuestionnaires(select2));
        return quesList;
    }

    public HashMap buildQuestionnaires(String select) {
        HashMap hm = new HashMap();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            if (ocrs.next()) {
                hm.put("propJobCode", ocrs.getString("EventId"));
                hm.put("propJobTitle", ocrs.getString("EVENT"));
                hm.put("quesDesc", ocrs.getString("QUES_DESCRIPTION"));
                hm.put("fromDate", ocrs.getString("FROM_DATE"));
                hm.put("toDate", ocrs.getString("TO_DATE"));
                hm.put("preparedBy", ocrs.getString("PREPARED_BY"));
                hm.put("preparedOn", ocrs.getString("PREPARED_ON"));
                hm.put("fullName", ocrs.getString("FULL_NAME"));
                hm.put("quesDefId", ocrs.getString("DEF_QUES_ID"));
            }else{
                hm.put("propJobCode", "Note Found");
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return hm;
    }

    public ArrayList<HashMap> buildDefQuestionnaires(String select) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
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
                hm.put("questionnaireId", ocrs.getString("QUESTIONNAIRE_ID"));
                hm.put("propJobCode", ocrs.getString("EDUC_CODE"));
                hm.put("propJobTitle", ocrs.getString("EVENT"));
                hm.put("quesDesc", ocrs.getString("QUES_DESCRIPTION"));
                hm.put("fromDate", ocrs.getString("FROM_DATE"));
                hm.put("toDate", ocrs.getString("TO_DATE"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public static void main(String ar[]) {
        String answer2 = "";
        String[] ans = answer2.split(",");
        if (ans.length > 0) {
        }
    }

    /**
     * @return the defQuesId
     */
    public String getDefQuesId() {
        return defQuesId;
    }

    /**
     * @param defQuesId the defQuesId to set
     */
    public void setDefQuesId(String defQuesId) {
        this.defQuesId = defQuesId;
    }
}
