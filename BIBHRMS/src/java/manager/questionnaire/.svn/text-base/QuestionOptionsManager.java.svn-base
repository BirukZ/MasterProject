/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.questionnaire;

import com.sun.webui.jsf.model.Option;
import entity.questionnaire.QuestionOptionsEntity;
import java.util.ArrayList;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Bini
 */
public class QuestionOptionsManager {

    private int optionId;
    private String optionName;
    private int value;
    private int groupId;
    private String groupDesc;
    private boolean selected;
    QuestionOptionsEntity questOptionsEntity = new QuestionOptionsEntity();

    public QuestionOptionsManager() {
    }

    public QuestionOptionsManager(String optionName, int value, int groupId, String groupDesc) {
        this.optionName = optionName;
        this.value = value;
        this.groupId = groupId;
        this.groupDesc = groupDesc;
    }

    public QuestionOptionsManager(int optionId, String optionName, int value, int groupId, String groupDesc) {
        this.optionId = optionId;
        this.optionName = optionName;
        this.value = value;
        this.groupId = groupId;
        this.groupDesc = groupDesc;
    }

    public QuestionOptionsManager(int groupId, String groupDesc) {
        this.groupId = groupId;
        this.groupDesc = groupDesc;
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    //</editor-fold>

    public boolean saveUpdateQuestionOption(ArrayList<QuestionOptionsManager> optionManagerList) {
        ArrayList<QuestionOptionsEntity> optionEntitysList = new ArrayList<QuestionOptionsEntity>();
        for (QuestionOptionsManager optionManager : optionManagerList) {
            optionEntitysList.add(new QuestionOptionsEntity(
                    optionManager.getOptionId(),
                    optionManager.getOptionName(),
                    optionManager.getValue(),
                    optionManager.getGroupId()));
        }
        return questOptionsEntity.insertUpdateQuestionOption(optionEntitysList);
    }

    public boolean saveOptionGroup(String groupDesc) {
        return questOptionsEntity.insertOptionGroup(groupDesc);
    }

    public boolean updateOptionGroup(int groupId, String groupDesc) {
        return questOptionsEntity.updateOptionGroup(groupId, groupDesc);
    }

    public boolean deleteQuestionOption(int optionId) {
        return questOptionsEntity.deleteQuestionOption(optionId);
    }

    public boolean deleteOptiongroup(int groupNo) {
        return questOptionsEntity.deleteOptiongroup(groupNo);
    }

    public ArrayList<QuestionOptionsManager> readQuestionOptions() {
        ArrayList<QuestionOptionsManager> readOptions = new ArrayList<QuestionOptionsManager>();
        try {
            ArrayList<QuestionOptionsEntity> optionEntityList = questOptionsEntity.readQuestionOptions();
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
                readOptions.add(new QuestionOptionsManager(
                        optionEntity.getOptionId(),
                        optionEntity.getOptionName(),
                        optionEntity.getValue(),
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

    public ArrayList<SelectItem> getOptionsGroup() {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<QuestionOptionsEntity> optionEntityList = questOptionsEntity.readOptionsGroup();
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
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

    public ArrayList<SelectItem> getQuestionOptions() {
        ArrayList<SelectItem> readOptions = new ArrayList<SelectItem>();
        try {
            ArrayList<QuestionOptionsEntity> optionEntityList = questOptionsEntity.readQuestionOptions();
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getValue(),
                        optionEntity.getOptionName()));
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
            ArrayList<QuestionOptionsEntity> optionEntityList = questOptionsEntity.getQuestionOptions(groupId);
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getValue(),
                        optionEntity.getOptionName()));
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
            ArrayList<QuestionOptionsEntity> optionEntityList = questOptionsEntity.getQuestionOptions(groupId);
            for (QuestionOptionsEntity optionEntity : optionEntityList) {
                readOptions.add(new Option(
                        optionEntity.getValue(),
                        optionEntity.getOptionName()+"&#8194;&#8194;&#8194;"));
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
            label = questOptionsEntity.getQuestionOptionsLabel(groupId);
            return label;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return label;
        }
    }
}
