/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import com.sun.webui.jsf.model.Option;
import entity.questionnaire.QuestionnaireEntity;
import entity.trainingEntity.TrainingRequestEntity;
import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class QuestionnaireManager implements Serializable {

    private int questionnaireId;
    private String eventCode;
    private String jobTitle;
    private String questDescription;
    private String fromDate;
    private String toDate;
    private boolean active;
    private String preparedBy;
    private String preparedOn;
    private boolean selected;
    private String defQuesId;
    QuestionnaireEntity questionnaireEntity = new QuestionnaireEntity();

    public QuestionnaireManager() {
    }

    public QuestionnaireManager(String eventCode, String questDescription, String fromDate, String toDate, String preparedBy, String preparedOn, String defQuesId) {
        this.eventCode = eventCode;
        this.questDescription = questDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.preparedBy = preparedBy;
        this.preparedOn = preparedOn;
        this.defQuesId = defQuesId;
    }

    public QuestionnaireManager(int questionnaireId, String jobCode, String jobTitle, String questDescription, String fromDate, String toDate, boolean active) {
        this.questionnaireId = questionnaireId;
        this.eventCode = jobCode;
        this.jobTitle = jobTitle;
        this.questDescription = questDescription;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.active = active;
    }

    // <editor-fold defaultstate="collapsed" desc="    Getters and Setters    ">
    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getJobCode() {
        return eventCode;
    }

    public void setJobCode(String jobCode) {
        this.eventCode = jobCode;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    // </editor-fold>
    public boolean saveQuestionnaire(QuestionnaireManager quesManager) {
        QuestionnaireEntity quesEntity = new QuestionnaireEntity(
                quesManager.getQuestionnaireId(),
                quesManager.getJobCode(),
                quesManager.getQuestDescription(),
                quesManager.getFromDate(),
                quesManager.getToDate(),
                quesManager.getPreparedBy(),
                quesManager.getPreparedOn(), quesManager.getDefQuesId());
        return questionnaireEntity.insertQuestionnaire(quesEntity);
    }

    public boolean updateQuestionnaire(QuestionnaireManager quesManager) {
        QuestionnaireEntity quesEntity = new QuestionnaireEntity(
                quesManager.getQuestionnaireId(),
                quesManager.getJobCode(),
                quesManager.getQuestDescription(),
                quesManager.getFromDate(),
                quesManager.getToDate(),
                quesManager.getPreparedBy(),
                quesManager.getPreparedOn(), String.valueOf(quesManager.getQuestionnaireId()));
        return questionnaireEntity.updateQuestionnaire(quesEntity);
    }

    public boolean deleteQuestionnaire(int questionnaireId) {
        return questionnaireEntity.deleteQuestionnaire(questionnaireId);
    }

    public ArrayList<QuestionnaireManager> selectQuestionnaire() {
        ArrayList<QuestionnaireManager> questManagerList = new ArrayList<QuestionnaireManager>();
        ArrayList<HashMap> questEntityList = questionnaireEntity.selectQuestionnaire();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (HashMap hm : questEntityList) {
                questManagerList.add(new QuestionnaireManager(
                        Integer.valueOf(hm.get("questionnaireId").toString()),
                        hm.get("propJobCode").toString(),
                        hm.get("propJobTitle").toString(),
                        hm.get("quesDesc").toString(),
                        hm.get("fromDate").toString(),
                        hm.get("toDate").toString(),
                        (format.parse(hm.get("toDate").toString())).after(date)));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return questManagerList;
    }

    public ArrayList<SelectItem> selectActiveQuestionnaire() {
        ArrayList<SelectItem> questManagerList = new ArrayList<SelectItem>();
        ArrayList<HashMap> questEntityList = questionnaireEntity.selectQuestionnaire();
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            for (HashMap hm : questEntityList) {
                if ((format.parse(hm.get("toDate").toString())).after(date)) {
                    
                    questManagerList.add(new Option(
                            Integer.valueOf(hm.get("questionnaireId").toString()),
                            hm.get("propJobTitle").toString()));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return questManagerList;
    }

    public HashMap selectQuestionnaire(int questionnaireId) {
        return questionnaireEntity.selectQuestionnaire(questionnaireId);
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

    public String getItemDesc(ArrayList<SelectItem> list, Object object) {
        if (object == null) {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i) == null) {
                    return list.get(i).getDescription();
                }
            }
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (object.equals(list.get(i).getValue())) {
                    return list.get(i).getDescription();
                }
            }
        }
        return null;
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

    public ArrayList<TrainingRequestEntity> readEmployeeTrainingRequests() {
        try {
            TrainingRequestEntity termEntity = new TrainingRequestEntity();
            return termEntity.readEmployeeTrainingRequests();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
