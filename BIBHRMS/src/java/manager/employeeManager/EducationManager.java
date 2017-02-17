/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EducationEntity;
import entity.globalUseEntity.LookUpEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class EducationManager {

    private boolean selectedEducation;
    String educationTypeCode;
    private boolean selected;

    public ArrayList<SelectItem> getAllLocation()
    {
         ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = educationEntity.selectAllLocationLu();
            while (_rs.next()) {
                committeeList.add(new SelectItem( _rs.getString("NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEducationTypeCode() {
        return educationTypeCode;
    }

    public void setEducationTypeCode(String educationTypeCode) {
        this.educationTypeCode = educationTypeCode;
    }
    String description;

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    String category;

    public EducationManager(String educationTypeCode, String description) {
        this.educationTypeCode = educationTypeCode;
        this.description = description;
    }

    public EducationManager(String educationTypeCode, String description, String category) {
        this.educationTypeCode = educationTypeCode;
        this.description = description;
        this.category = category;
    }

    public EducationManager(String description) {
        this.description = description;
    }

    public boolean isSelectedEducation() {
        return selectedEducation;
    }

    public void setSelectedEducation(boolean selectedEducation) {
        this.selectedEducation = selectedEducation;
    }
    EducationEntity educationEntity = new EducationEntity();

    public EducationManager() {
    }
    String levelOfEducation;

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstuation() {
        return instuation;
    }

    public void setInstuation(String instuation) {
        this.instuation = instuation;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public EducationEntity getEducationEntity() {
        return educationEntity;
    }

    public void setEducationEntity(EducationEntity educationEntity) {
        this.educationEntity = educationEntity;
    }

    public int getGradingSystem() {
        return gradingSystem;
    }

    public void setGradingSystem(int gradingSystem) {
        this.gradingSystem = gradingSystem;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTypesOfEducation() {
        return typesOfEducation;
    }

    public void setTypesOfEducation(String typesOfEducation) {
        this.typesOfEducation = typesOfEducation;
    }
    String typesOfEducation;
    String instuation;
    String startDate;
    String copletionDate;
    String award;
    String result;
    String empId;
    String id;
    int new_old;
    int gradingSystem;
    int databaseStatus;
    //===============================
    static int new_inserted = 0;
    static int new_removed = 1;
    static int old_not_cahanged = 2;
    static int old_edited = 3;
    static int old_deleted = 4;
    //===============================

    public int getNew_old() {
        return new_old;
    }

    public int getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(int databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public void setNew_old(int new_old) {
        this.new_old = new_old;
    }
    String educationLevelDescription;
    String educationTypeDescription;

    public String getEducationLevelDescription() {
        return educationLevelDescription;
    }

    public void setEducationLevelDescription(String educationLevelDescription) {
        this.educationLevelDescription = educationLevelDescription;
    }

    public String getEducationTypeDescription() {
        return educationTypeDescription;
    }

    public void setEducationTypeDescription(String educationTypeDescription) {
        this.educationTypeDescription = educationTypeDescription;
    }

    public EducationManager(String levelOfEducation, String typesOfEducation,
            String instuation, String startDate, String copletionDate, String award, String result, String empId, String id, int new_old, String educationLevelDescription,
            String educationTypeDescription) {
        this.levelOfEducation = levelOfEducation;
        this.typesOfEducation = typesOfEducation;
        this.instuation = instuation;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.award = award;
        this.result = result;
        this.empId = empId;
        this.id = id;
        this.new_old = new_old;
        this.educationLevelDescription = educationLevelDescription;
        this.educationTypeDescription = educationTypeDescription;

    }

    public EducationManager(String levelOfEducation, String typesOfEducation, String instuation, String startDate, String copletionDate, String award, String result, String empId, String id, int new_old, String educationLevelDescription,
            String educationTypeDescription, int gradingSystem) {
        this(levelOfEducation, typesOfEducation, instuation, startDate, copletionDate, award, result, empId, id, new_old, educationLevelDescription, educationTypeDescription);
        this.gradingSystem = gradingSystem;

    }

    public EducationManager(String levelOfEducation, String typesOfEducation, String instuation, String startDate, String copletionDate,
            String award, String result, String empId, String id, int new_old, String educationLevelDescription,
            String educationTypeDescription, int gradingSystem, int databaseStatus) {
        this(levelOfEducation, typesOfEducation, instuation, startDate, copletionDate, award, result, empId, id, new_old, educationLevelDescription, educationTypeDescription);
        this.gradingSystem = gradingSystem;
        this.databaseStatus = databaseStatus;
    }

    public int saveEmployeeEducation(EducationManager employeeManager, int perform) {

        EducationEntity employeeEducation = new EducationEntity(employeeManager.getInstuation(),
                employeeManager.getStartDate(),
                employeeManager.getCopletionDate(),
                employeeManager.getAward(),
                employeeManager.getResult(),
                // Double.toString(Double.parseDouble(employeeManager.getResult()) * 100/(double) employeeManager.getGradingSystem()),
                employeeManager.getLevelOfEducation(),
                employeeManager.getTypesOfEducation(),
                employeeManager.getEmpId(),
                employeeManager.getId(),
                employeeManager.getGradingSystem());
        if (perform == 1) {
            return educationEntity.saveEmployeeEducation(employeeEducation);
        } else if (perform == 2) {
            return educationEntity.updateEmployeeEducation(employeeEducation);
        } else {
            // return educationEntity.saveEmployeeEducation(employeeEducation);
            return 0;
        }
    }

    public ArrayList<HashMap> getEmployeeEducation(String employeeID) {
        ArrayList<HashMap> educationList = new ArrayList<HashMap>();
        try {

            ResultSet ocrs = educationEntity.selectEmployeeEducation(employeeID);
            while (ocrs.next()) {
                HashMap currentEducation = new HashMap();
                currentEducation = new HashMap();
                if (ocrs.getString("INSTITUTION") != null) {
                    currentEducation.put("INSTITUTION", ocrs.getString("INSTITUTION"));
                } else {
                    currentEducation.put("INSTITUTION", "Unknown");
                }
                if (ocrs.getString("STARTING_DATE") != null) {
                    currentEducation.put("STARTING_DATE", ocrs.getString("STARTING_DATE"));
                } else {
                    currentEducation.put("STARTING_DATE", "Unknown");
                }
                if (ocrs.getString("COMPLETION_DATE") != null) {
                    currentEducation.put("COMPLETION_DATE", ocrs.getString("COMPLETION_DATE"));
                } else {
                    currentEducation.put("COMPLETION_DATE", "Unknown");
                }

                if (ocrs.getString("AWARD") != null) {
                    currentEducation.put("AWARD", ocrs.getString("AWARD"));
                } else {
                    currentEducation.put("AWARD", "Unknown");
                }

                if (ocrs.getString("RESULT") != null) {
                    currentEducation.put("RESULT", ocrs.getString("RESULT"));
                } else {
                    currentEducation.put("RESULT", "Unknown");
                }

                if (ocrs.getString("EDUC_LEVEL_CODE") != null)
                {
                    currentEducation.put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                } else {
                    currentEducation.put("EDUC_LEVEL_CODE", "Unknown");
                }

                if (ocrs.getString("EDUCATION_TYPE") != null) {
                    currentEducation.put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                } else {
                    currentEducation.put("EDUCATION_TYPE", "Unknown");
                }

                if (ocrs.getString("EDUC_TYPE") != null) {
                    currentEducation.put("EDUC_TYPE", ocrs.getString("EDUC_TYPE"));
                } else {
                    currentEducation.put("EDUC_TYPE", "Unknown");
                }

                if (ocrs.getString("EMP_ID") != null) {
                    currentEducation.put("EMP_ID", ocrs.getString("EMP_ID"));
                } else {
                    currentEducation.put("EMP_ID", "Unknown");
                }
                if (ocrs.getString("ID") != null) {
                    currentEducation.put("ID", ocrs.getString("ID"));
                } else {
                    currentEducation.put("ID", "Unknown");
                }
                if (ocrs.getString("educ_level") != null) {
                    currentEducation.put("educ_level", ocrs.getString("educ_level"));
                } else {
                    currentEducation.put("educ_level", "Unknown");
                }
                if (ocrs.getString("GRADING_SYSTEM") != null) {
                    currentEducation.put("GRADING_SYSTEM", ocrs.getString("GRADING_SYSTEM"));
                } else {
                    currentEducation.put("GRADING_SYSTEM", "0");
                }
                currentEducation.put("databaseStatus", old_not_cahanged);
                educationList.add(currentEducation);
            }
            return educationList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return educationList;
        }
    }

    public HashMap[] readEmployeeEducation(String employeeID) {
        return educationEntity.readEducation(employeeID);
    }

    public String readEducationDescription(String educationID)
    {
        
        return educationEntity.readEducationDescription(educationID);
    }

    public String readTypeDescription(String typeID) {
        return educationEntity.readTypeDescription(typeID);
    }

    public int countEmployeeEducation(String employeeID) {
        return educationEntity.countEmployeeEducation(employeeID);

    }

    public int deleteEmployeeEducation(String educationId) {
        return educationEntity.deleteEmployeeEducation(educationId);
    }

    public int countTypeOfEducation() {
        return educationEntity.countTypeOfEducation();
    }

    public HashMap[] readEducationType() {
        try {
            HashMap[] list = null;
            LookUpEntity lookupEntity = new LookUpEntity();
            ArrayList<LookUpEntity> eduTypeList = lookupEntity.readEducationTypes();
            list = new HashMap[eduTypeList.size()];
            if (eduTypeList.size() > 0) {
                for (int i = 0; i < eduTypeList.size(); i++) {
                    lookupEntity = eduTypeList.get(i);
                    list[i] = new HashMap();
                    list[i].put("EDUC_TYPE_CODE", lookupEntity.getTitleCode());
                    list[i].put("DESCRIPTION", lookupEntity.getTitleDescription());

                }
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int addNewEducationType(String educationType, String category) {
        return educationEntity.insertNewEducationType(educationType, category);
    }

    public int addNewTitle(String titleDesc) {
        return educationEntity.addNewTitle(titleDesc);
    }

    public static int getNew_inserted() {
        return new_inserted;
    }

    public static void setNew_inserted(int new_inserted) {
        EducationManager.new_inserted = new_inserted;
    }

    public static int getNew_removed() {
        return new_removed;
    }

    public static void setNew_removed(int new_removed) {
        EducationManager.new_removed = new_removed;
    }

    public static int getOld_deleted() {
        return old_deleted;
    }

    public static void setOld_deleted(int old_deleted) {
        EducationManager.old_deleted = old_deleted;
    }

    public static int getOld_edited() {
        return old_edited;
    }

    public static void setOld_edited(int old_edited) {
        EducationManager.old_edited = old_edited;
    }

    public static int getOld_not_cahanged() {
        return old_not_cahanged;
    }

    public static void setOld_not_cahanged(int old_not_cahanged) {
        EducationManager.old_not_cahanged = old_not_cahanged;
    }

    public int deleteEducationType(String educationCode) {

        return educationEntity.deleteEducationType(educationCode);
    }
}
