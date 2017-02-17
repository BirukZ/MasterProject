/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import entity.globalUseEntity.LookUpEntity;
import entity.organizationEntity.JobTypeQualificationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.LookUpManager;

/**
 *
 * @author mekete
 */
public class JobTypeQualificationManager {

    LookUpManager lookUpManager = new LookUpManager();
    LookUpEntity lookUpEntity = new LookUpEntity();
    JobTypeQualificationEntity jobTypeQualificationEntity = new JobTypeQualificationEntity();

    public boolean saveQualificationsForJob(ArrayList<JobTypeQualificationModel> educationLevelAndExperienceList,
            ArrayList<JobTypeQualificationModel> educationTypeList) {
        try {
//            jobTypeQualificationEntity.get_con().setAutoCommit(false);
//            jobTypeQualificationEntity.get_con().setSavepoint("A");
            if (saveEducationLevelExperience(educationLevelAndExperienceList)) {
                if (saveEducationType(educationTypeList)) {
//                    jobTypeQualificationEntity.get_con().setAutoCommit(true);
                    return true;
                } else {
//                    jobTypeQualificationEntity.get_con().rollback();
//                    jobTypeQualificationEntity.get_con().setAutoCommit(true);
                    return false;
                }
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<JobTypeQualificationModel> getEducationLevelExperience(int jobTypeId) {
        ArrayList<JobTypeQualificationModel> committeeList = new ArrayList<JobTypeQualificationModel>();
        try {
            ResultSet _rs = jobTypeQualificationEntity.selectEducationLevelExperience(jobTypeId);
            while (_rs.next()) {
                JobTypeQualificationModel currentCommittee = new JobTypeQualificationModel();
                currentCommittee.setJobTypeEducLevelAndExperienceId(_rs.getInt("JOBTYPE_EDUCLEVEL_EXPER_ID"));
                currentCommittee.setJobTypeId(_rs.getInt("JOBTYPE_ID"));//
                currentCommittee.setLevelOfEducationId(_rs.getInt("EDUCLEVEL_ID"));//
                currentCommittee.setLevelOfEducationName(_rs.getString("EDUC_NAME"));//
                currentCommittee.setExperienceNeeded(_rs.getDouble("EXPERIENCE"));//
                currentCommittee.setDatabaseStatus("Old");
                committeeList.add(currentCommittee);
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveEducationLevelExperience(ArrayList<JobTypeQualificationModel> committeeList) {
        ArrayList<JobTypeQualificationModel> toBeInserted = new ArrayList<JobTypeQualificationModel>();
        ArrayList<JobTypeQualificationModel> toBeDeleted = new ArrayList<JobTypeQualificationModel>();
        try {
            for (JobTypeQualificationModel currentFieldOfStyudyExperience : committeeList) {
                if (currentFieldOfStyudyExperience.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentFieldOfStyudyExperience);
                } else if (currentFieldOfStyudyExperience.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentFieldOfStyudyExperience);
                }
            }
            if (toBeInserted.size() > 0) {
                jobTypeQualificationEntity.insertEducationLevelExperience(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {
                jobTypeQualificationEntity.deleteEducationLevelExperience(toBeDeleted);
            }
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<JobTypeQualificationModel> getEducationType(int jobTypeId) {
        ArrayList<JobTypeQualificationModel> committeeList = new ArrayList<JobTypeQualificationModel>();
        try {
            ResultSet _rs = jobTypeQualificationEntity.selectEducationTypes(jobTypeId);
            while (_rs.next()) {
                JobTypeQualificationModel currentCommittee = new JobTypeQualificationModel();
                currentCommittee.setJobTypeId(_rs.getInt("JOBTYPE_ID"));
                currentCommittee.setEducationTypeId(_rs.getInt("EDUCTYPE_ID"));
                currentCommittee.setEducationTypeName(_rs.getString("EDUC_NAME"));//
                currentCommittee.setJobTypeEducTypeId(_rs.getInt("JOBTYPE_EDUCTYPE_ID"));//
                currentCommittee.setDatabaseStatus("Old");  //
                committeeList.add(currentCommittee);
            }
            _rs.close();
            return committeeList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveEducationType(ArrayList<JobTypeQualificationModel> eduactionLevelList) {
        ArrayList<JobTypeQualificationModel> toBeInserted = new ArrayList<JobTypeQualificationModel>();
        ArrayList<JobTypeQualificationModel> toBeDeleted = new ArrayList<JobTypeQualificationModel>();
        try {
            for (JobTypeQualificationModel currentFieldOdStyudyExperience : eduactionLevelList) {
                if (currentFieldOdStyudyExperience.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentFieldOdStyudyExperience);
                } else if (currentFieldOdStyudyExperience.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentFieldOdStyudyExperience);
                }
            }
            if (toBeInserted.size() > 0) {
                jobTypeQualificationEntity.insertEducationTypes(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {
                jobTypeQualificationEntity.deleteEducationTypes(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    //==========================to be deleted======================================

    public ArrayList<SelectItem> getAllEducationCategories() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeQualificationEntity.selectAllEducationTypeCategories();
            committeeList.add(new SelectItem("-1", "--Select category--"));
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getString("CATEGORY_ID"), _rs.getString("CATEGORY_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getEducationTypesByCategory(String category) {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {

            ResultSet _rs = jobTypeQualificationEntity.selectEducationTypeByCategory(category);
            committeeList.add(new SelectItem("-1", "--Select Type--"));
            while (_rs.next()) {
                String id = _rs.getString("EDUC_TYPE_CODE") + "--" + _rs.getString("DESCRIPTION");
                committeeList.add(new SelectItem(id, _rs.getString("DESCRIPTION")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllEducationLevels() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeQualificationEntity.selectAllEducationLevels();
            committeeList.add(new SelectItem("-1", "--Select Level--"));
            while (_rs.next()) {
                String id = _rs.getString("EDUC_LEVEL_CODE") + "--" + _rs.getString("DESCRIPTION");
                committeeList.add(new SelectItem(id, _rs.getString("DESCRIPTION")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllJobTypes() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeQualificationEntity.selectAllEducationLevels();
            while (_rs.next()) {
                String id = _rs.getString("JOB_CODE") + "--" + _rs.getString("JOB_NAME");
                committeeList.add(new SelectItem(id, _rs.getString("JOB_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
