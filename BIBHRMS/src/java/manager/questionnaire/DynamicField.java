/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import entity.questionnaire.QuestionnaireAnswerEntity;
import java.util.List;
import javax.faces.model.SelectItem;

/**
 *
 * @author Bini
 */
public class DynamicField {

    private Integer questColId;
    private Integer questionId;
    private Integer rowCounter;
    private String question;
    private String answer;
    private List<SelectItem> colItem1;
    private List<SelectItem> colItem2;
    private List<SelectItem> colItem3;
    private List<SelectItem> colItem4;
    private List<SelectItem> colItem5;
    private List<SelectItem> colItem6;
    private String colName1;
    private String colName2;
    private String colName3;
    private String colName4;
    private String colName5;
    private String colName6;
    private String colName7;
    private String colName8;
    private String colName9;
    private String colName10;
    private String answer1;
    private String answer2;
    private String answer3;
    private String answer4;
    private String answer5;
    private String answer6;
    private String answer7;
    private String answer8;
    private String answer9;
    private String answer10;
    private String answer11;
    private String answer12;
    private String[] selectedItems1;
    private String[] selectedItems2;
    private String[] selectedItems3;
    private String[] selectedItems4;
    private String[] selectedItems5;
    private String[] selectedItems6;
    private String[] selectedItems7;
    private String[] selectedItems8;
    private String[] selectedItems9;
    private String[] selectedItems10;
    private String[] selectedItems11;
    private String[] selectedItems12;
    private int questionnaireAnsId;
    private int questionnaireId;
    private String answeredBy;
    private String answeredOn;
    private int questionAnsId;
    private int tblQuestAnsId;
    private int tblQuestId;
    private String tblAnswer;
    private int questionType;
    private int sectionId;
    QuestionnaireAnswerEntity questAnswerEntity = new QuestionnaireAnswerEntity();

    public DynamicField() {
    }

    public DynamicField(Integer rowCounter) {
        this.rowCounter = rowCounter;
    }

    public DynamicField(Integer questionId, String answer) {
        this.questionId = questionId;
        this.answer = answer;
    }

    public DynamicField(String tblAnswer, int tblQuestAnsId) {
        this.tblQuestAnsId = tblQuestAnsId;
        this.tblAnswer = tblAnswer;
    }

    public DynamicField(int questionnaireId, String answeredBy, String answeredOn) {
        this.questionnaireId = questionnaireId;
        this.answeredBy = answeredBy;
        this.answeredOn = answeredOn;
    }

    public DynamicField(int questionnaireAnsId, Integer questionId, String answer, int sectionId, int questionType) {
        this.questionId = questionId;
        this.answer = answer;
        this.questionnaireAnsId = questionnaireAnsId;
        this.questionType = questionType;
        this.sectionId = sectionId;
    }

    public DynamicField(Integer questColId, int questionnaireAnsId) {
        this.questColId = questColId;
        this.questionnaireAnsId = questionnaireAnsId;
    }

    // <editor-fold defaultstate="collapsed" desc="  Getters and Setters   ">
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public int getSectionId() {
        return sectionId;
    }

    public void setSectionId(int sectionId) {
        this.sectionId = sectionId;
    }

    public int getQuestionType() {
        return questionType;
    }

    public void setQuestionType(int sectionId) {
        this.questionType = sectionId;
    }

    public List<SelectItem> getColItem1() {
        return colItem1;
    }

    public void setColItem1(List<SelectItem> colItem1) {
        this.colItem1 = colItem1;
    }

    public List<SelectItem> getColItem2() {
        return colItem2;
    }

    public void setColItem2(List<SelectItem> colItem2) {
        this.colItem2 = colItem2;
    }

    public List<SelectItem> getColItem3() {
        return colItem3;
    }

    public void setColItem3(List<SelectItem> colItem3) {
        this.colItem3 = colItem3;
    }

    public List<SelectItem> getColItem4() {
        return colItem4;
    }

    public void setColItem4(List<SelectItem> colItem4) {
        this.colItem4 = colItem4;
    }

    public List<SelectItem> getColItem5() {
        return colItem5;
    }

    public void setColItem5(List<SelectItem> colItem5) {
        this.colItem5 = colItem5;
    }

    public List<SelectItem> getColItem6() {
        return colItem6;
    }

    public void setColItem6(List<SelectItem> colItem6) {
        this.colItem6 = colItem6;
    }

    public String getColName1() {
        return colName1;
    }

    public void setColName1(String colName1) {
        this.colName1 = colName1;
    }

    public String getColName2() {
        return colName2;
    }

    public void setColName2(String colName2) {
        this.colName2 = colName2;
    }

    public String getColName3() {
        return colName3;
    }

    public void setColName3(String colName3) {
        this.colName3 = colName3;
    }

    public String getColName4() {
        return colName4;
    }

    public void setColName4(String colName4) {
        this.colName4 = colName4;
    }

    public String getColName5() {
        return colName5;
    }

    public void setColName5(String colName5) {
        this.colName5 = colName5;
    }

    public String getColName6() {
        return colName6;
    }

    public void setColName6(String colName6) {
        this.colName6 = colName6;
    }

    public String getColName7() {
        return colName7;
    }

    public void setColName7(String colName7) {
        this.colName7 = colName7;
    }

    public String getColName8() {
        return colName8;
    }

    public void setColName8(String colName8) {
        this.colName8 = colName8;
    }

    public String getColName9() {
        return colName9;
    }

    public void setColName9(String colName9) {
        this.colName9 = colName9;
    }

    public Integer getQuestColId() {
        return questColId;
    }

    public void setQuestColId(Integer questColId) {
        this.questColId = questColId;
    }

    public Integer getRowCounter() {
        return rowCounter;
    }

    public void setRowCounter(Integer rowCounter) {
        this.rowCounter = rowCounter;
    }

    public String getColName10() {
        return colName10;
    }

    public void setColName10(String colName10) {
        this.colName10 = colName10;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
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

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer10() {
        return answer10;
    }

    public void setAnswer10(String answer10) {
        this.answer10 = answer10;
    }

    public String getAnswer11() {
        return answer11;
    }

    public void setAnswer11(String answer11) {
        this.answer11 = answer11;
    }

    public String getAnswer12() {
        return answer12;
    }

    public void setAnswer12(String answer12) {
        this.answer12 = answer12;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getAnswer5() {
        return answer5;
    }

    public void setAnswer5(String answer5) {
        this.answer5 = answer5;
    }

    public String getAnswer6() {
        return answer6;
    }

    public void setAnswer6(String answer6) {
        this.answer6 = answer6;
    }

    public String getAnswer7() {
        return answer7;
    }

    public void setAnswer7(String answer7) {
        this.answer7 = answer7;
    }

    public String getAnswer8() {
        return answer8;
    }

    public void setAnswer8(String answer8) {
        this.answer8 = answer8;
    }

    public String getAnswer9() {
        return answer9;
    }

    public void setAnswer9(String answer9) {
        this.answer9 = answer9;
    }

    public String[] getSelectedItems1() {
        return selectedItems1;
    }

    public void setSelectedItems1(String[] selectedItems1) {
        if (selectedItems1 != null && selectedItems1.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems1[0]);
            for (int i = 1; i < selectedItems1.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems1[i]);
            }
            setAnswer1(buffer.toString());
        }
        this.selectedItems1 = selectedItems1;
    }

    public String[] getSelectedItems10() {
        return selectedItems10;
    }

    public void setSelectedItems10(String[] selectedItems10) {
        if (selectedItems10 != null && selectedItems10.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems10[0]);
            for (int i = 1; i < selectedItems10.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems10[i]);
            }
            setAnswer10(buffer.toString());
        }
        this.selectedItems10 = selectedItems10;
    }

    public String[] getSelectedItems11() {
        return selectedItems11;
    }

    public void setSelectedItems11(String[] selectedItems11) {
        if (selectedItems12 != null && selectedItems12.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems11[0]);
            for (int i = 1; i < selectedItems11.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems11[i]);
            }
            setAnswer11(buffer.toString());
        }
        this.selectedItems11 = selectedItems11;
    }

    public String[] getSelectedItems12() {
        return selectedItems12;
    }

    public void setSelectedItems12(String[] selectedItems12) {
        if (selectedItems12 != null && selectedItems12.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems12[0]);
            for (int i = 1; i < selectedItems12.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems12[i]);
            }
            setAnswer12(buffer.toString());
        }
        this.selectedItems12 = selectedItems12;
    }

    public String[] getSelectedItems2() {
        return selectedItems2;
    }

    public void setSelectedItems2(String[] selectedItems2) {
        if (selectedItems2 != null && selectedItems2.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems2[0]);
            for (int i = 1; i < selectedItems2.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems2[i]);
            }
            setAnswer2(buffer.toString());
        }
        this.selectedItems2 = selectedItems2;
    }

    public String[] getSelectedItems3() {
        return selectedItems3;
    }

    public void setSelectedItems3(String[] selectedItems3) {
        if (selectedItems3 != null && selectedItems3.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems3[0]);
            for (int i = 1; i < selectedItems3.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems3[i]);
            }
            setAnswer3(buffer.toString());
        }
        this.selectedItems3 =selectedItems3;
    }

    public String[] getSelectedItems4() {
        return selectedItems4;
    }

    public void setSelectedItems4(String[] selectedItems4) {
        if (selectedItems4 != null && selectedItems4.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems4[0]);
            for (int i = 1; i < selectedItems4.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems4[i]);
            }
            setAnswer4(buffer.toString());
        }
        this.selectedItems4 = selectedItems4;
    }

    public String[] getSelectedItems5() {
        return selectedItems5;
    }

    public void setSelectedItems5(String[] selectedItems5) {
        if (selectedItems5 != null && selectedItems5.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems5[0]);
            for (int i = 1; i < selectedItems5.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems5[i]);
            }
            setAnswer5(buffer.toString());
        }
        this.selectedItems5 = selectedItems5;
    }

    public String[] getSelectedItems6() {
        return selectedItems6;
    }

    public void setSelectedItems6(String[] selectedItems6) {
        if (selectedItems6 != null && selectedItems6.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems6[0]);
            for (int i = 1; i < selectedItems6.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems6[i]);
            }
            setAnswer6(buffer.toString());
        }
        this.selectedItems6 = selectedItems6;
    }

    public String[] getSelectedItems7() {
        return selectedItems7;
    }

    public void setSelectedItems7(String[] selectedItems7) {
        if (selectedItems7 != null && selectedItems7.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems1[0]);
            for (int i = 1; i < selectedItems7.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems7[i]);
            }
            setAnswer7(buffer.toString());
        }
        this.selectedItems7 = selectedItems7;
    }

    public String[] getSelectedItems8() {
        return selectedItems8;
    }

    public void setSelectedItems8(String[] selectedItems8) {
        if (selectedItems8 != null && selectedItems8.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems8[0]);
            for (int i = 1; i < selectedItems8.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems8[i]);
            }
            setAnswer8(buffer.toString());
        }
        this.selectedItems8 = selectedItems8;
    }

    public String[] getSelectedItems9() {
        return selectedItems9;
    }

    public void setSelectedItems9(String[] selectedItems9) {
        if (selectedItems9 != null && selectedItems9.length > 0) {
            StringBuffer buffer = new StringBuffer();
            buffer.append(selectedItems9[0]);
            for (int i = 1; i < selectedItems9.length; i++) {
                buffer.append(",");
                buffer.append(selectedItems9[i]);
            }
            setAnswer9(buffer.toString());
        }
        this.selectedItems9 = selectedItems9;
    }

    // </editor-fold>
}

