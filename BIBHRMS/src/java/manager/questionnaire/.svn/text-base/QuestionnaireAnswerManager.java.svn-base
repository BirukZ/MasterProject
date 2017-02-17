/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import com.sun.webui.jsf.model.Option;
import entity.questionnaire.QuestionnaireAnswerEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class QuestionnaireAnswerManager {

    private int questionnaireAnsId;
    private int questionnaireId;
    private String answeredBy;
    private String answeredOn;
    private String reviwedBy;
    private String reviwedOn;
    private String supervisedBy;
    private String supervisedOn;
    private int questionAnsId;
    private int questionId;
    private String answer;
    private int tblQuestAnsId;
    private int tblQuestId;
    private String tblAnswer;
    QuestionnaireAnswerEntity questAnswerEntity = new QuestionnaireAnswerEntity();

    public QuestionnaireAnswerManager() {
    }

    public QuestionnaireAnswerManager(int questionnaireId, String answeredBy, String answeredOn) {
        this.questionnaireId = questionnaireId;
        this.answeredBy = answeredBy;
        this.answeredOn = answeredOn;
    }

    public QuestionnaireAnswerManager(int questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public QuestionnaireAnswerManager(String tblAnswer, int tblQuestId) {
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

    public boolean saveQuestionnaireAnswer(DynamicField answerManager,
            ArrayList<DynamicField> answerManagerList, ArrayList<DynamicField>[] tblManAnswerList) {

        return questAnswerEntity.saveQuestionnaireAnswer(answerManager, answerManagerList, tblManAnswerList);
    }

    public ArrayList<SelectItem> selectAllQuestionnaireAnswer(int questionnaireId) {
        ArrayList<SelectItem> answerManagerList = new ArrayList<SelectItem>();
        ArrayList<HashMap> answerEntityList = questAnswerEntity.selectAllQuestionnaireAnswer(questionnaireId);
        try {
            for (HashMap hm : answerEntityList) {
                answerManagerList.add(new Option(
                        Integer.valueOf(hm.get("queAnsId").toString()),
                        hm.get("fullName").toString()));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return answerManagerList;
    }

    public HashMap selectQuestionnaireAnswerDetail(int questionnaireAnsId) {
        return questAnswerEntity.selectQuestionnaireAnswerDetail(questionnaireAnsId);
    }

    public ArrayList<DynamicField> selectQuestionsAnswer(int questionnaireAnsId) {
        ArrayList<DynamicField> answerManagerList = new ArrayList<DynamicField>();
        ArrayList<HashMap> answerEntityList = questAnswerEntity.selectQuestionsAnswer(questionnaireAnsId);
        try {
            for (HashMap hm : answerEntityList) {
                answerManagerList.add(new DynamicField(
                        Integer.valueOf(hm.get("queAnsId").toString()),
                        Integer.valueOf(hm.get("quesId").toString()),
                        hm.get("answer").toString(),
                        Integer.valueOf(hm.get("sectionId").toString()),
                        Integer.valueOf(hm.get("typeId").toString())));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return answerManagerList;
    }

    public ArrayList<DynamicField> selectTableQuestionsAnswer(int questionnaireAnsId) {
        ArrayList<DynamicField> answerManagerList = new ArrayList<DynamicField>();
        ArrayList<HashMap> answerEntityList = questAnswerEntity.selectTableQuestionsAnswer(questionnaireAnsId);
        try {
            for (HashMap hm : answerEntityList) {
                DynamicField dynamicField = new DynamicField(
                        Integer.valueOf(hm.get("tblQuesId").toString()),
                        Integer.valueOf(hm.get("queAnsId").toString()));
                String[] _answer = hm.get("answer").toString().split("@@");
                for (int i = 1; i <= _answer.length; i++) {
                    if (i == 1) {
                        dynamicField.setAnswer1(_answer[0]);
                    } else if (i == 2) {
                        dynamicField.setAnswer2(_answer[1]);
                    } else if (i == 3) {
                        dynamicField.setAnswer3(_answer[2]);
                    } else if (i == 4) {
                        dynamicField.setAnswer4(_answer[3]);
                    } else if (i == 5) {
                        dynamicField.setAnswer5(_answer[4]);
                    } else if (i == 6) {
                        dynamicField.setAnswer6(_answer[5]);
                    } else if (i == 7) {
                        dynamicField.setAnswer7(_answer[6]);
                    } else if (i == 8) {
                        dynamicField.setAnswer8(_answer[7]);
                    } else if (i == 9) {
                        dynamicField.setAnswer9(_answer[8]);
                    } else if (i == 10) {
                        dynamicField.setAnswer10(_answer[9]);
                    } else if (i == 11) {
                        dynamicField.setAnswer11(_answer[10]);
                    } else if (i == 12) {
                        dynamicField.setAnswer12(_answer[11]);
                    }
                }
                answerManagerList.add(dynamicField);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return answerManagerList;
    }
}
