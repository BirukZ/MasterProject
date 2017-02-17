/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import java.util.ArrayList;
import java.util.Iterator;
import entity.organizationEntity.OrganizationReportEntity;

/**
 *
 * @author MekaneHiwot Fisseha
 */
public class OrganizationReportManager {

    private String departmentId;
    private String jobId;
    private String departmentName;
    private String jobName;
    private int numberOfEmp;
    private int requiredNumber;
    private int vacantPossession;
    private String team;
    private String rank;
    private String dept;
    private String loaction;
    private String educLevel;
    private String educType;
    private String expiriance;
    private String skill;
    private double intialSalary;
    private double finalSalary;
    private String seraAsfetsami;
    private String addtionalSkill;
    private double minSalary;
    private double maxSalary;

    public String getDepartmentId() {
        return departmentId;
    }

    public String getSeraAsfetsami() {
        return seraAsfetsami;
    }

    public String getAddtionalSkill() {
        return addtionalSkill;
    }

    public void setAddtionalSkill(String addtionalSkill) {
        this.addtionalSkill = addtionalSkill;
    }

    public void setMaxSalary(double maxSalary) {
        this.maxSalary = maxSalary;
    }

    public void setMinSalary(double minSalary) {
        this.minSalary = minSalary;
    }

    public void setSeraAsfetsami(String seraAsfetsami) {
        this.seraAsfetsami = seraAsfetsami;
    }

    public OrganizationReportEntity getOrganizationReportEntity() {
        return organizationReportEntity;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getEducType() {
        return educType;
    }

    public void setEducType(String educType) {
        this.educType = educType;
    }

    public String getExpiriance() {
        return expiriance;
    }

    public void setExpiriance(String expiriance) {
        this.expiriance = expiriance;
    }

   

    public double getFinalSalary() {
        return finalSalary;
    }

    public void setFinalSalary(double finalSalary) {
        this.finalSalary = finalSalary;
    }

    public double getIntialSalary() {
        return intialSalary;
    }

    public void setIntialSalary(double intialSalary) {
        this.intialSalary = intialSalary;
    }

    public String getLoaction() {
        return loaction;
    }

    public void setLoaction(String loaction) {
        this.loaction = loaction;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public void setOrganizationReportEntity(OrganizationReportEntity organizationReportEntity) {
        this.organizationReportEntity = organizationReportEntity;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public int getNumberOfEmp() {
        return numberOfEmp;
    }

    public void setNumberOfEmp(int numberOfEmp) {
        this.numberOfEmp = numberOfEmp;
    }

    public double getMaxSalary() {
        return maxSalary;
    }

    public double getMinSalary() {
        return minSalary;
    }

    public int getRequiredNumber() {
        return requiredNumber;
    }

    public void setRequiredNumber(int requiredNumber) {
        this.requiredNumber = requiredNumber;
    }

    public int getVacantPossession() {
        return vacantPossession;
    }

    public void setVacantPossession(int vacantPossession) {
        this.vacantPossession = vacantPossession;
    }
    OrganizationReportEntity organizationReportEntity = new OrganizationReportEntity();

    public ArrayList<OrganizationReportManager> readVacanceSpaces() {
        try {
            ArrayList<OrganizationReportManager> allocatedJobForDep = new ArrayList<OrganizationReportManager>();
            //ArrayList<OrganizationReportManager> buffer = new ArrayList<OrganizationReportManager>();
            allocatedJobForDep = this.readaAlocatedJobForDep();

            return allocatedJobForDep;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<OrganizationReportManager> readEduExpriance()
    {
        ArrayList<OrganizationReportManager> allocatedJobForDep = new ArrayList<OrganizationReportManager>();
        ArrayList<OrganizationReportManager> educLevExpriance = new ArrayList<OrganizationReportManager>();
        allocatedJobForDep = this.readaAlocatedJobForDep();
        Iterator<OrganizationReportManager> it = allocatedJobForDep.iterator();
        while (it.hasNext()) {
            OrganizationReportManager initiateManager = it.next();
            educLevExpriance = this.readDepartementPath(initiateManager.getJobId());
            if (educLevExpriance != null) {
                initiateManager.setEducLevel(initiateManager.getEducLevel());
                initiateManager.setEducType(initiateManager.getEducType());
                // initiateManager.setExpiriance(initiateManager.getExpiriance());
                //initiateManager.setAddtionalSkill(initiateManager.getAddtionalSkill());
                educLevExpriance.add(initiateManager);
            }
        }
        return educLevExpriance;
    }

    private int readNumberOfEmployees(String departmentId, String jobId) {
        return organizationReportEntity.readNumberOfEmployees(departmentId, jobId);
    }

    private ArrayList<OrganizationReportManager> readEducLevAndEprinance(String jobcode) {

        return organizationReportEntity.readDepartementPath(jobcode);
    }

    private String readExriance(String jobcode) {

        return organizationReportEntity.readEducationExpri(jobcode);
    }

    private ArrayList<OrganizationReportManager> readaAlocatedJobForDep() {

        return organizationReportEntity.readaAlocatedJobForDep();

    }

    private ArrayList<OrganizationReportManager> readDepartementPath(String jobcode) {
        return organizationReportEntity.readDepartementPath(jobcode);

    }
}
