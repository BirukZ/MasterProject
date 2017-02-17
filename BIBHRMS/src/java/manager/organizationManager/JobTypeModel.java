/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

/**
 *
 * @author mekete
 */
public class JobTypeModel {

    int jobId;
    String jobName;
    String jobDescription;
    String responsiblity;
    String additionalSkillsNeeded;
    String shiftOrNormal;
    String rankId;
    String level;
    String databaseStatus;

    public JobTypeModel() {
    }

    public JobTypeModel(String jobName, String jobDescription, String responsiblity, String additionalSkillsNeeded, String shiftOrNormal, String rankId, String level) {
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.responsiblity = responsiblity;
        this.additionalSkillsNeeded = additionalSkillsNeeded;
        this.shiftOrNormal = shiftOrNormal;
        this.rankId = rankId;
        this.level = level;

    }

    public JobTypeModel(int jobId, String jobName, String jobDescription, String responsiblity, String additionalSkillsNeeded, String shiftOrNormal, String rankId, String level) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.responsiblity = responsiblity;
        this.additionalSkillsNeeded = additionalSkillsNeeded;
        this.shiftOrNormal = shiftOrNormal;
        this.rankId = rankId;
        this.level = level;

    }

    public JobTypeModel(int jobId, String jobName, String jobDescription, String responsiblity, String additionalSkillsNeeded, String shiftOrNormal, String rankId, String level, String databaseStatus) {
        this.jobId = jobId;
        this.jobName = jobName;
        this.jobDescription = jobDescription;
        this.responsiblity = responsiblity;
        this.additionalSkillsNeeded = additionalSkillsNeeded;
        this.shiftOrNormal = shiftOrNormal;
        this.rankId = rankId;
        this.level = level;
        this.databaseStatus = databaseStatus;
    }

    public String getAdditionalSkillsNeeded() {
        return additionalSkillsNeeded;
    }

    public void setAdditionalSkillsNeeded(String additionalSkillsNeeded) {
        this.additionalSkillsNeeded = additionalSkillsNeeded;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getRankId() {
        return rankId;
    }

    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getResponsiblity() {
        return responsiblity;
    }

    public void setResponsiblity(String responsiblity) {
        this.responsiblity = responsiblity;
    }

    public String getShiftOrNormal() {
        return shiftOrNormal;
    }

    public void setShiftOrNormal(String shiftOrNormal) {
        this.shiftOrNormal = shiftOrNormal;
    }
}
