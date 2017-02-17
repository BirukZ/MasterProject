/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import entity.organizationEntity.JobTypeRegistrationEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class JobTypeRegistrationManager {

    JobTypeModel jobTypeModel = new JobTypeModel();
    JobTypeRegistrationEntity jobTypeRegistrationEntity = new JobTypeRegistrationEntity();
    DepartmentManage departmentManager = new DepartmentManage();

    public ArrayList<SelectItem> getJobTypeLevels() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selecJobTypeLevels();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("JOB_LEVEL_ID"), _rs.getString("JOB_LEVEL_NAME")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveJobTypes(ArrayList<JobTypeModel> jobTypeList) {
        ArrayList<JobTypeModel> toBeInserted = new ArrayList<JobTypeModel>();
        ArrayList<JobTypeModel> toBeUpdated = new ArrayList<JobTypeModel>();
        ArrayList<JobTypeModel> toBeDeleted = new ArrayList<JobTypeModel>();
        try {
            for (JobTypeModel currentCommittee : jobTypeList) {
                if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCommittee);
                }
                jobTypeRegistrationEntity.insertJobTypes(toBeInserted);
                jobTypeRegistrationEntity.updateCommitteesJobTypes(toBeUpdated);
                jobTypeRegistrationEntity.deleteJobTypes(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getAllJobTypes() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("JOB_CODE"),
                        _rs.getString("JOB_CODE") + "--" +
                        _rs.getString("JOB_NAME")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public JobTypeModel getJobTypeDetail(int jobTypeId) {
        JobTypeModel currentJobType = new JobTypeModel();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectJobTypeDetail(jobTypeId);
            if (_rs.next()) {
                currentJobType.setJobName(_rs.getString("JOB_NAME"));//
                currentJobType.setJobDescription(_rs.getString("JOB_DESCRIPTION"));
                currentJobType.setResponsiblity(_rs.getString("MIN_RESPONSIBILITY"));//
                currentJobType.setAdditionalSkillsNeeded(_rs.getString("ADDITIONALSKILL"));//
                currentJobType.setRankId(_rs.getString("RANK_ID"));//
                currentJobType.setShiftOrNormal(_rs.getString("SHIFT_OR_NORMAL"));//
                currentJobType.setJobId(jobTypeId);//
                currentJobType.setDatabaseStatus("Old");
            }
            _rs.close();
        } catch (Exception ex) {
            currentJobType.setJobId(-1);
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return currentJobType;
    }

    public ArrayList<JobTypeModel> getAllJobTypesDetail() {
        ArrayList<JobTypeModel> committeeList = new ArrayList<JobTypeModel>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            while (_rs.next()) {
                JobTypeModel currentCommittee = new JobTypeModel();
                currentCommittee.setJobName(_rs.getString("JOB_NAME"));//
                currentCommittee.setJobDescription(_rs.getString("JOB_DESCRIPTION"));
                currentCommittee.setResponsiblity(_rs.getString("MIN_RESPONSIBILITY"));//
                currentCommittee.setAdditionalSkillsNeeded(_rs.getString("ADDITIONALSKILL"));//
                currentCommittee.setRankId(_rs.getString("RANK_ID"));//
                currentCommittee.setShiftOrNormal(_rs.getString("SHIFT_OR_NORMAL"));//
                currentCommittee.setJobId(_rs.getInt("JOB_CODE"));//
                currentCommittee.setDatabaseStatus("Old");  //
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
}
