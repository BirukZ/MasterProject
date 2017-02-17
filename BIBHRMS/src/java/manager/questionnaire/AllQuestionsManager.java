/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import com.sun.webui.jsf.model.Option;
import entity.questionnaire.AllQuestionsEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class AllQuestionsManager {

    private int questionId;
    private String question;
    private int questionSection;
    private String questionSectionDesc;
    private int questionType;
    private String questionTypeDesc;
    private boolean tableForm;
    private int questionNo;
    private int optionGroupId;
    private String optionGroupDesc;
    private int questTblId;
    private String columnName;
    private int columnType;
    private String columnTypeDesc;
    private int orderNo;
    private int questColumnId;
    private boolean selected;
    private int defQuesId;
    private String defQuesName;
    private List<SelectItem> neww;

    public List<SelectItem> getNeww() {
        return neww;
    }

    public void setNeww(List<SelectItem> neww) {
        this.neww = neww;
    }
    AllQuestionsEntity allQuestionsEntity = new AllQuestionsEntity();

    public AllQuestionsManager() {
    }

    public AllQuestionsManager(int questionId, String question, int questionSection, String questionSectionDesc, int questionType, String questionTypeDesc, boolean tableForm, int questionNo, int optionGroupId, String optionGroupDesc, int defQuesId) {
        this.questionId = questionId;
        this.question = question;
        this.questionSection = questionSection;
        this.questionSectionDesc = questionSectionDesc;
        this.questionType = questionType;
        this.questionTypeDesc = questionTypeDesc;
        this.tableForm = tableForm;
        this.questionNo = questionNo;
        this.optionGroupId = optionGroupId;
        this.optionGroupDesc = optionGroupDesc;
        this.defQuesId = defQuesId;
    }

    public AllQuestionsManager(int questionId, String question, int questionSection, int questionType, boolean tableForm, int questionNo, int optionGroupId, int defQuesId) {
        this.questionId = questionId;
        this.question = question;
        this.questionSection = questionSection;
        this.questionType = questionType;
        this.tableForm = tableForm;
        this.questionNo = questionNo;
        this.optionGroupId = optionGroupId;
        this.defQuesId = defQuesId;
    }

    public AllQuestionsManager(int questTblId, int questColumnId, String question, String columnName) {
        this.questTblId = questTblId;
        this.question = question;
        this.columnName = columnName;
        this.questColumnId = questColumnId;
    }

    public AllQuestionsManager(int questTblId, String columnName, int columnType, String columnTypeDesc, int questionType, String questionTypeDesc, int optionGroupId, String optionGroupDesc, int orderNo) {
        this.questTblId = questTblId;
        this.columnName = columnName;
        this.columnType = columnType;
        this.columnTypeDesc = columnTypeDesc;
        this.questionType = questionType;
        this.questionTypeDesc = questionTypeDesc;
        this.optionGroupId = optionGroupId;
        this.optionGroupDesc = optionGroupDesc;
        this.orderNo = orderNo;
    }

    private AllQuestionsManager(int questColumnId, String question) {
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

    public String getColumnTypeDesc() {
        return columnTypeDesc;
    }

    public void setColumnTypeDesc(String columnTypeDesc) {
        this.columnTypeDesc = columnTypeDesc;
    }

    public int getOptionGroupId() {
        return optionGroupId;
    }

    public void setOptionGroupId(int optionGroupId) {
        this.optionGroupId = optionGroupId;
    }

    public String getOptionGroupDesc() {
        return optionGroupDesc;
    }

    public void setOptionGroupDesc(String optionGroupDesc) {
        this.optionGroupDesc = optionGroupDesc;
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

    public String getQuestionTypeDesc() {
        return questionTypeDesc;
    }

    public void setQuestionTypeDesc(String questionTypeDesc) {
        this.questionTypeDesc = questionTypeDesc;
    }

    public boolean getTableForm() {
        return tableForm;
    }

    public void setTableForm(boolean tableForm) {
        this.tableForm = tableForm;
    }

    public String getQuestionSectionDesc() {
        return questionSectionDesc;
    }

    public void setQuestionSectionDesc(String questionSectionDesc) {
        this.questionSectionDesc = questionSectionDesc;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    //</editor-fold>
    public boolean saveAllQuestion(AllQuestionsManager questManager, ArrayList<AllQuestionsManager> questTableList,
            ArrayList<AllQuestionsManager> questColumnList) {
        ArrayList<AllQuestionsEntity> questTblEnt = new ArrayList<AllQuestionsEntity>();
        ArrayList<AllQuestionsEntity> questColEnt = new ArrayList<AllQuestionsEntity>();
        AllQuestionsEntity questEntity = new AllQuestionsEntity(
                questManager.getQuestionId(),
                questManager.getQuestion(),
                questManager.getQuestionSection(),
                questManager.getQuestionType(),
                (questManager.getTableForm()) ? 1 : 0,
                questManager.getQuestionNo(),
                questManager.getOptionGroupId(),
                questManager.getDefQuesId());
        for (AllQuestionsManager tblManager : questTableList) {
            questTblEnt.add(new AllQuestionsEntity(
                    tblManager.getQuestTblId(),
                    tblManager.getColumnName(),
                    tblManager.getColumnType(),
                    tblManager.getQuestionType(),
                    tblManager.getOptionGroupId(),
                    tblManager.getOrderNo()));
        }
        for (AllQuestionsManager colManager : questColumnList) {
            questColEnt.add(new AllQuestionsEntity(
                    colManager.getQuestTblId(),
                    colManager.getQuestColumnId(),
                    colManager.getQuestion(),
                    colManager.getColumnName()));
        }
        return allQuestionsEntity.insertAllQuestion(questEntity, questTblEnt, questColEnt);
    }

    public boolean updateAllQuestion(AllQuestionsManager questManager, ArrayList<AllQuestionsManager> questTableList,
            ArrayList<AllQuestionsManager> questColumnList) {
        ArrayList<AllQuestionsEntity> questTblEnt = new ArrayList<AllQuestionsEntity>();
        ArrayList<AllQuestionsEntity> questColEnt = new ArrayList<AllQuestionsEntity>();
        AllQuestionsEntity questEntity = new AllQuestionsEntity(
                questManager.getQuestionId(),
                questManager.getQuestion(),
                questManager.getQuestionSection(),
                questManager.getQuestionType(),
                (questManager.getTableForm()) ? 1 : 0,
                questManager.getQuestionNo(),
                questManager.getOptionGroupId(),
                questManager.getDefQuesId());
        for (AllQuestionsManager tblManager : questTableList) {
            questTblEnt.add(new AllQuestionsEntity(
                    tblManager.getQuestTblId(),
                    tblManager.getColumnName(),
                    tblManager.getColumnType(),
                    tblManager.getQuestionType(),
                    tblManager.getOptionGroupId(),
                    tblManager.getOrderNo()));
        }
        for (AllQuestionsManager colManager : questColumnList) {
            questColEnt.add(new AllQuestionsEntity(
                    colManager.getQuestTblId(),
                    colManager.getQuestColumnId(),
                    colManager.getQuestion(),
                    colManager.getColumnName()));
        }
        return allQuestionsEntity.updateAllQuestion(questEntity, questTblEnt, questColEnt);
    }

    public boolean deleteQuestion(int questionId) {
        return allQuestionsEntity.deleteQuestion(questionId);
    }

    public boolean deleteQuestionTable(int questTblId) {
        return allQuestionsEntity.deleteQuestionTable(questTblId);
    }

    public boolean deleteQuestionTableByQuestionId(int questionId) {
        return allQuestionsEntity.deleteQuestionTableByQuestionId(questionId);
    }

    public boolean deleteQuestionColumn(int questColumnId) {
        return allQuestionsEntity.deleteQuestionColumn(questColumnId);
    }

    public ArrayList<AllQuestionsManager> readAllQuestions(int defQuesId) {
        ArrayList<AllQuestionsManager> readQuestions = new ArrayList<AllQuestionsManager>();
        try {
            ArrayList<AllQuestionsEntity> questionListEnt = allQuestionsEntity.selectAllQuestion(defQuesId);
            for (AllQuestionsEntity questionEnt : questionListEnt) {
                readQuestions.add(new AllQuestionsManager(
                        questionEnt.getQuestionId(),
                        questionEnt.getQuestion(),
                        questionEnt.getQuestionSection(),
                        getItemLabel(getQuestionSectionList(), String.valueOf(questionEnt.getQuestionSection())),
                        questionEnt.getQuestionType(),
                        getItemLabel(getQuestionTypeList(), String.valueOf(questionEnt.getQuestionType())),
                        (questionEnt.getTableForm() == 1) ? true : false,
                        questionEnt.getQuestionNo(),
                        questionEnt.getOptionGroupId(),
                        questionEnt.getOptionGroupDesc(),
                        questionEnt.getDefQuesId()));
            }
            return readQuestions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<AllQuestionsManager> readTableFormQuestions(int questionId) {
        ArrayList<AllQuestionsManager> readQuestions = new ArrayList<AllQuestionsManager>();
        try {
            ArrayList<AllQuestionsEntity> questionListEnt = allQuestionsEntity.selectTblFormQuestion(questionId);
            for (AllQuestionsEntity questionEnt : questionListEnt) {
                readQuestions.add(new AllQuestionsManager(
                        questionEnt.getQuestTblId(),
                        questionEnt.getColumnName(),
                        questionEnt.getColumnType(),
                        getItemLabel(getColumnTypeList(), String.valueOf(questionEnt.getColumnType())),
                        questionEnt.getQuestionType(),
                        getItemLabel(getQuestionTypeList(), String.valueOf(questionEnt.getQuestionType())),
                        questionEnt.getOptionGroupId(),
                        questionEnt.getOptionGroupDesc(),
                        questionEnt.getOrderNo()));
            }

            return readQuestions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<AllQuestionsManager> readColumnQuestions(int questionId) {
        ArrayList<AllQuestionsManager> readQuestions = new ArrayList<AllQuestionsManager>();
        try {
            ArrayList<AllQuestionsEntity> questionListEnt = allQuestionsEntity.selectColumnQuestion(questionId);
            for (AllQuestionsEntity questionEnt : questionListEnt) {
                readQuestions.add(new AllQuestionsManager(
                        questionEnt.getQuestTblId(),
                        questionEnt.getQuestColumnId(),
                        questionEnt.getQuestion(),
                        questionEnt.getColumnName()));
            }
            return readQuestions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<AllQuestionsManager> readColumnQuestionByTblId(int questTblId) {
        ArrayList<AllQuestionsManager> readQuestions = new ArrayList<AllQuestionsManager>();
        try {
            ArrayList<AllQuestionsEntity> questionListEnt = allQuestionsEntity.selectColumnQuestionByTblId(questTblId);
            for (AllQuestionsEntity questionEnt : questionListEnt) {
                readQuestions.add(new AllQuestionsManager(
                        questionEnt.getQuestColumnId(),
                        questionEnt.getQuestion()));
            }
            return readQuestions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int countTableFormQuestion() {
        return allQuestionsEntity.countTableFormQuestion();
    }

    public ArrayList<SelectItem> getQuestionSectionList() {
        ArrayList<SelectItem> questSection = new ArrayList<SelectItem>();
        questSection.add(new Option(null, " --Select Section-- "));
        questSection.add(new Option(String.valueOf(1), "Section One"));
        questSection.add(new Option(String.valueOf(2), "Section Two"));
        questSection.add(new Option(String.valueOf(3), "Section Three"));
        questSection.add(new Option(String.valueOf(4), "Section Four"));
        questSection.add(new Option(String.valueOf(5), "Section Five"));
        return questSection;
    }

    public ArrayList<SelectItem> getColumnTypeList() {
        ArrayList<SelectItem> colType = new ArrayList<SelectItem>();
        colType.add(new Option(String.valueOf(0), "Question Column"));
        colType.add(new Option(String.valueOf(1), "Answer Column"));
        return colType;
    }

    public ArrayList<SelectItem> getQuestionTypeList() {
        ArrayList<SelectItem> colType = new ArrayList<SelectItem>();
        colType.add(new Option(null, " --Select Option Group-- "));
        colType.add(new Option(String.valueOf(1), "Descriptive single line"));
        colType.add(new Option(String.valueOf(2), "Descriptive many line"));
        colType.add(new Option(String.valueOf(3), "Multiple choise one answer"));
        colType.add(new Option(String.valueOf(4), "Multiple choise many answer"));
        return colType;
    }

    public String getItemLabel(ArrayList<SelectItem> list, Object object) {
        if (object == null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null) {
                    return list.get(i).getLabel();
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (object.equals(list.get(i).getValue())) {
                    return list.get(i).getLabel();
                }
            }
        }
        return null;
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
