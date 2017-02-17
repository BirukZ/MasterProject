/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import entity.recruitmentEntity.InitiateEntity;
import java.util.ArrayList;
import java.util.Iterator;


/**
 *
 * @author kibrom
 */
public class InitiateManager {

    private String departmentId;
    private String jobId;
    private String departmentName;
    private String jobName;
    private int numberOfEmp;
    private int requiredNumber;
    private int vacantPossession;


    private InitiateEntity initiateEntity=new InitiateEntity();
    public InitiateManager() {
    }

    public InitiateManager(String departmentId, String jobId, String departmentName, String jobName, int numberOfEmp, int requiredNumber,int vacantPossession) {
        this.departmentId = departmentId;
        this.jobId = jobId;
        this.departmentName = departmentName;
        this.jobName = jobName;
        this.numberOfEmp = numberOfEmp;
        this.requiredNumber = requiredNumber;
        this.vacantPossession = vacantPossession;

    }

    /**
     * @return the departmentId
     */
    public String getDepartmentId() {
        return departmentId;
    }

    /**
     * @param departmentId the departmentId to set
     */
    public void setDepartmentId(String departmentId) {
        this.departmentId = departmentId;
    }

    public InitiateEntity getInitiateEntity() {
        return initiateEntity;
    }

    public void setInitiateEntity(InitiateEntity initiateEntity) {
        this.initiateEntity = initiateEntity;
    }

    public int getVacantPossession() {
        return vacantPossession;
    }

    public void setVacantPossession(int vacantPossession) {
        this.vacantPossession = vacantPossession;
    }

    /**
     * @return the jobId
     */
    public String getJobId() {
        return jobId;
    }

    /**
     * @param jobId the jobId to set
     */
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    /**
     * @return the departmentName
     */
    public String getDepartmentName() {
        return departmentName;
    }

    /**
     * @param departmentName the departmentName to set
     */
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    /**
     * @return the jobName
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * @param jobName the jobName to set
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * @return the numberOfEmp
     */
    public int getNumberOfEmp() {
        return numberOfEmp;
    }

    /**
     * @param numberOfEmp the numberOfEmp to set
     */
    public void setNumberOfEmp(int numberOfEmp) {
        this.numberOfEmp = numberOfEmp;
    }

    /**
     * @return the requiredNumber
     */
    public int getRequiredNumber() {
        return requiredNumber;
    }

    /**
     * @param requiredNumber the requiredNumber to set
     */
    public void setRequiredNumber(int requiredNumber) {
        this.requiredNumber = requiredNumber;
    }

    public ArrayList<InitiateManager> readVacanceSpaces() {
        ArrayList<InitiateManager> allocatedJobForDep = new ArrayList<InitiateManager>();
        ArrayList<InitiateManager> buffer = new ArrayList<InitiateManager>();
        allocatedJobForDep = this.readaAlocatedJobForDep();
        Iterator<InitiateManager> it = allocatedJobForDep.iterator();
        while (it.hasNext()) {
            InitiateManager initiateManager = it.next();
            int numberOfEmployees = this.readNumberOfEmployees(initiateManager.getDepartmentId(), initiateManager.getJobId());
//            if (initiateManager.getRequiredNumber() > numberOfEmployees) {
                initiateManager.setNumberOfEmp(numberOfEmployees);
                initiateManager.setVacantPossession(initiateManager.getRequiredNumber()-numberOfEmployees);
                buffer.add(initiateManager);
//            }

        }
        return buffer;

    }

    private int readNumberOfEmployees(String departmentId, String jobId) {

        return  initiateEntity.readNumberOfEmployees(departmentId,jobId);
    }

    private ArrayList<InitiateManager> readaAlocatedJobForDep() {
     return  initiateEntity.readaAlocatedJobForDep();
        //elect  tbl_department.DEPT_ID,hr_dept_job.JOB_CODE, hr_dept_job.NUMBER_OF_EMPLOYEE  from tbl_department,hr_dept_job where tbl_department.DEPT_ID=hr_dept_job.DEPT_ID
    }
}
