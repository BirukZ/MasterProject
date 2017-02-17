/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import entity.organizationEntity.JobTypeEntity;
import fphrms.JobList;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.departmentManage.DepartmentManage;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class JobTypeManager {

    JobTypeModel jobTypeModel = new JobTypeModel();
    JobTypeEntity jobTypeRegistrationEntity = new JobTypeEntity();
    DepartmentManage departmentManager = new DepartmentManage();

    public ArrayList<SelectItem> getLevelTypes() {
        ArrayList<SelectItem> jobLevelList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobLevels();
            jobLevelList.add(new SelectItem("-1", "--SELECT--"));
            while (_rs.next()) {
                jobLevelList.add(new SelectItem(_rs.getString("LEVEL_ID"), _rs.getString("LEVEL_NAME")));
            }
            _rs.close();
            return jobLevelList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveJobType(JobTypeModel jobType) {
        try {
            jobTypeRegistrationEntity.insertJobType(jobType);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateJobType(JobTypeModel jobType) {
        try {
            jobTypeRegistrationEntity.updateJobType(jobType);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean deleteJobType(JobTypeModel jobType) {
        try {
            jobTypeRegistrationEntity.deleteJobType(jobType);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getAllJobTypesSelectItem() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            OracleCachedRowSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            if (_rs.next()) {
                jobsList.add(new SelectItem(null, "SELECT JOB"));
                jobsList.add(new SelectItem(_rs.getString("JOB_CODE") + "--" +
                        _rs.getString("JOB_NAME"), _rs.getString("JOB_CODE") +
                        "--" + _rs.getString("JOB_NAME")));
                while (_rs.next()) {
                    jobsList.add(new SelectItem(_rs.getString("JOB_CODE") + "--" +
                            _rs.getString("JOB_NAME"), _rs.getString("JOB_CODE") +
                            "--" + _rs.getString("JOB_NAME")));
                }

                return jobsList;
            } else {
                jobsList.add(new SelectItem(null, "JOB NOT FOUND"));
                return jobsList;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllJobTypes() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("JOB_CODE") + "--" +
                        _rs.getString("JOB_NAME"), _rs.getString("JOB_NAME") +
                        "--" + _rs.getString("JOB_CODE")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllJobTypesForPromotion() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("JOB_CODE") + "--" +
                        _rs.getString("JOB_NAME"),
                        _rs.getString("JOB_NAME") + "--" + _rs.getString("JOB_CODE")));
            }
            _rs.close();
            return jobsList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllJob() {
        ArrayList<SelectItem> jobsList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = jobTypeRegistrationEntity.selectAllJobTypes();
            while (_rs.next()) {
                jobsList.add(new SelectItem(_rs.getString("JOB_CODE"), _rs.getString("JOB_NAME")));
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
                currentJobType.setLevel(_rs.getString("JOB_LEVEL"));//
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

    public String readJobIDAndDescription(String jobCode) {
        return jobTypeRegistrationEntity.readJobIDAndDescription(jobCode);
    }

    public ArrayList<JobList> jobNameForAutoList(String jobName) {

        try {

            ResultSet rs = jobTypeRegistrationEntity.searchJobNametoAuto(jobName);
            ArrayList<JobList> jobListAr = new ArrayList<JobList>();
            while (rs.next()) {

                JobList empMgt = new JobList(rs.getString("JOB_CODE"), rs.getString("JOB_DESCRIPTION"));
                jobListAr.add(empMgt);

            }
            return jobListAr;
        } catch (Exception ex) {
            ex.printStackTrace();
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
}
