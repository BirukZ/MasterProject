/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

/**
 *
 * @author mekete
 */
public class JobTypeQualificationModel {

    int jobTypeEducLevelAndExperienceId;
    int jobTypeEducTypeId;
    int jobTypeId;
    int levelOfEducationId;
    String levelOfEducationName;
    double experienceNeeded;
    String educationTypeName;
    int educationTypeId;
    String databaseStatus;
    boolean seledtJobList;

    public boolean isSeledtJobList() {
        return seledtJobList;
    }

    public void setSeledtJobList(boolean seledtJobList) {
        this.seledtJobList = seledtJobList;
    }

    public JobTypeQualificationModel() {
    }

    public JobTypeQualificationModel(int jobTypeEducLevelAndExperienceId, int jobTypeid, int levelOfEducationId, String levelOfEducationName, double experienceNeeded) {
        this.jobTypeEducLevelAndExperienceId = jobTypeEducLevelAndExperienceId;
        this.jobTypeId = jobTypeid;
        this.levelOfEducationId = levelOfEducationId;
        this.levelOfEducationName = levelOfEducationName;
        this.experienceNeeded = experienceNeeded;
    }

    public JobTypeQualificationModel(int jobTypeid, int levelOfEducationId, String levelOfEducationName, double experienceNeeded, String databaseStatus) {
        this.jobTypeId = jobTypeid;
        this.levelOfEducationId = levelOfEducationId;
        this.levelOfEducationName = levelOfEducationName;
        this.experienceNeeded = experienceNeeded;
        this.databaseStatus=databaseStatus;
    }

    public JobTypeQualificationModel(int jobTypeEducTypeId, int jobTypeid, int educationTypeId, String educationTypeName, String databaseStatus) {
        this.jobTypeEducTypeId = jobTypeEducTypeId;
        this.jobTypeId = jobTypeid;
        this.educationTypeName = educationTypeName;
        this.educationTypeId = educationTypeId;
        this.databaseStatus = databaseStatus;
    }

    public JobTypeQualificationModel(int jobTypeid, int educationTypeId, String educationTypeName, String databaseStatus) {
        this.jobTypeId = jobTypeid;
        this.educationTypeName = educationTypeName;
        this.educationTypeId = educationTypeId;
        this.databaseStatus = databaseStatus;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public int getEducationTypeId() {
        return educationTypeId;
    }

    public void setEducationTypeId(int educationTypeId) {
        this.educationTypeId = educationTypeId;
    }

    public String getEducationTypeName() {
        return educationTypeName;
    }

    public void setEducationTypeName(String educationTypeName) {
        this.educationTypeName = educationTypeName;
    }

    public double getExperienceNeeded() {
        return experienceNeeded;
    }

    public void setExperienceNeeded(double experienceNeeded) {
        this.experienceNeeded = experienceNeeded;
    }

    public int getJobTypeEducLevelAndExperienceId() {
        return jobTypeEducLevelAndExperienceId;
    }

    public void setJobTypeEducLevelAndExperienceId(int jobTypeEducLevelAndExperienceId) {
        this.jobTypeEducLevelAndExperienceId = jobTypeEducLevelAndExperienceId;
    }

    public int getJobTypeEducTypeId() {
        return jobTypeEducTypeId;
    }

    public void setJobTypeEducTypeId(int jobTypeEducTypeId) {
        this.jobTypeEducTypeId = jobTypeEducTypeId;
    }

    public int getJobTypeId() {
        return jobTypeId;
    }

    public void setJobTypeId(int jobTypeid) {
        this.jobTypeId = jobTypeid;
    }

    public int getLevelOfEducationId() {
        return levelOfEducationId;
    }

    public void setLevelOfEducationId(int levelOfEducationId) {
        this.levelOfEducationId = levelOfEducationId;
    }

    public String getLevelOfEducationName() {
        return levelOfEducationName;
    }

    public void setLevelOfEducationName(String levelOfEducationName) {
        this.levelOfEducationName = levelOfEducationName;
    }


}