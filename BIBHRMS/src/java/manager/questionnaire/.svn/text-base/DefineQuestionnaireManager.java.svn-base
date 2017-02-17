/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import com.sun.webui.jsf.model.Option;
import entity.questionnaire.DefineQuestionnaireEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class DefineQuestionnaireManager {

    private int defQuesId;
    private String defQuesName;
    private String defQuesDescription;
    private int purposeId;
    private String defQuesPurposeDesc;
    private boolean selected;
    DefineQuestionnaireEntity defQuestEntity = new DefineQuestionnaireEntity();

    public DefineQuestionnaireManager() {
    }

    public DefineQuestionnaireManager(String quesName, String defQuesDesc, int groupId, String groupDesc) {
        this.defQuesName = quesName;
        this.defQuesDescription = defQuesDesc;
        this.purposeId = groupId;
        this.defQuesPurposeDesc = groupDesc;
    }

    public DefineQuestionnaireManager(int quesId, String quesName, String defQuesDesc, int groupId, String groupDesc) {
        this.defQuesId = quesId;
        this.defQuesName = quesName;
        this.defQuesDescription = defQuesDesc;
        this.purposeId = groupId;
        this.defQuesPurposeDesc = groupDesc;
    }

    public DefineQuestionnaireManager(int groupId, String groupDesc) {
        this.purposeId = groupId;
        this.defQuesPurposeDesc = groupDesc;
    }

    // <editor-fold defaultstate="collapsed" desc="   Getters and Setters    ">
    public String getDefQuesPurposeDesc() {
        return defQuesPurposeDesc;
    }


    public void setDefQuesPurposeDesc(String defQuesPurposeDesc) {
        this.defQuesPurposeDesc = defQuesPurposeDesc;
    }

    public int getPurposeId() {
        return purposeId;
    }

    public void setPurposeId(int purposeId) {
        this.purposeId = purposeId;
    }

    public int getQuesId() {
        return defQuesId;
    }

    public void setQuesId(int optionId) {
        this.defQuesId = optionId;
    }

    public String getDefQuesName() {
        return defQuesName;
    }

    public void setDefQuesName(String defQuesName) {
        this.defQuesName = defQuesName;
    }

    public String getDefQuesDescription() {
        return defQuesDescription;
    }

    public void setDefQuesDescription(String quesDesc) {
        this.defQuesDescription = quesDesc;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    //</editor-fold>

    public boolean saveUpdateQuestionOption(ArrayList<DefineQuestionnaireManager> optionManagerList) {
        ArrayList<DefineQuestionnaireEntity> optionEntitysList = new ArrayList<DefineQuestionnaireEntity>();
        for (DefineQuestionnaireManager optionManager : optionManagerList) {
            optionEntitysList.add(new DefineQuestionnaireEntity(
                    optionManager.getQuesId(),
                    optionManager.getDefQuesName(),
                    optionManager.getDefQuesDescription(),
                    optionManager.getPurposeId(),
                    optionManager.getDefQuesPurposeDesc()));
        }
        return defQuestEntity.insertUpdateQuestionnaireDefinition(optionEntitysList);
    }

    public boolean saveOptionGroup(String groupDesc) {
        return defQuestEntity.insertQuestDefPupose(groupDesc);
    }

    public boolean updateOptionGroup(int groupId, String groupDesc) {
        return defQuestEntity.updateQuesPurpose(groupId, groupDesc);
    }

    public boolean deleteQuestionOption(int optionId) {
        return defQuestEntity.deleteQuestionOption(optionId);
    }

    public boolean deleteOptiongroup(int groupNo) {
        return defQuestEntity.deleteOptiongroup(groupNo);
    }

    public ArrayList<DefineQuestionnaireManager> readQuestionOptions() {
        ArrayList<DefineQuestionnaireManager> readOptions = new ArrayList<DefineQuestionnaireManager>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.readQuestionOptions();
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                readOptions.add(new DefineQuestionnaireManager(
                        optionEntity.getQuesId(),
                        optionEntity.getQuesName(),
                        optionEntity.getDefQuesDesc(),
                        optionEntity.getGroupId(),
                        optionEntity.getGroupDesc()));
            }
            return readOptions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getQuestionnairePurpose() {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.readQuestionnairePurposes();
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        String.valueOf(optionEntity.getGroupId()),
                        String.valueOf(optionEntity.getGroupDesc())));
            }
            readOptions.add(0, new Option(null, "--Select Option --"));
            return readOptions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getQuestionnaireTitles() {
        ArrayList<SelectItem> questionnaireTitleList = new ArrayList<SelectItem>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.readDefinedQuestionnaireTitles();
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                questionnaireTitleList.add(new Option(
                        String.valueOf(optionEntity.getQuesId()),
                        String.valueOf(optionEntity.getQuesName()),
                        String.valueOf(optionEntity.getGroupId())));
            }
            questionnaireTitleList.add(0, new Option(null, "--Select Questionnaire --"));
            return questionnaireTitleList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }


    public ArrayList<SelectItem> getQuestionOptions() {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.readQuestionOptions();
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getDefQuesDesc(),
                        optionEntity.getQuesName()));
            }
            readOptions.add(0, new Option(null, "--Select Option --"));
            return readOptions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getQuestionOptions(int groupId) {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.getQuestionnaireDef(groupId);
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getDefQuesDesc(),
                        optionEntity.getQuesName()));
            }
            return readOptions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public List<SelectItem> getQuestionOptionsList(int groupId) {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<DefineQuestionnaireEntity> optionEntityList = defQuestEntity.getQuestionnaireDef(groupId);
            for (DefineQuestionnaireEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getDefQuesDesc(),
                        optionEntity.getQuesName()+"&#8194;&#8194;&#8194;"));
            // "&#8194;&#8194;&#8194;&#8194;&#8194;&#8194;&#8194;"));
            }
            return readOptions;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getQuestionOptionsLabel(int groupId) {
        String label = "";
        try {
            label = defQuestEntity.getQuestionOptionsLabel(groupId);
            return label;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return label;
        }
    }
}
