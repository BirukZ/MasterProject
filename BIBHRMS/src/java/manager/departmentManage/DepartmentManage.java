/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.departmentManage;

import com.sun.webui.jsf.model.Option;
import entity.departmentEntity.DepartmentEntity;
import entity.organizationEntity.Department;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class DepartmentManage {

    String allowedJobCOde;
    boolean selectedJob;
    String allowedJobName;
    String deptJobCode;
    String oldID;
    int avilabelOnDb;
    int numberOfEmployee;
    String dataBaseStatus;
    String position;
    public Option[] department;
    String jobName;
    String responsiblity;
    String rank;
    String qualifcation;
    String additionalSkill;
    String minimumExperiance;
    private String levelOfEducation;
    private String levelOfEducationID;
    private String jobQualificationID;
    private boolean selected1;
    private boolean selected;
    int NUmberOfYear;
    String type;
    String jobCode;
    Option[] job;
    Option[] allJob;
    DepartmentEntity departmentEntity = new DepartmentEntity();

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public boolean isSelected1() {
        return selected1;
    }

    public void setSelected1(boolean selected1) {
        this.selected1 = selected1;
    }

    public String getDataBaseStatus() {
        return dataBaseStatus;
    }

    public void setDataBaseStatus(String dataBaseStatus) {
        this.dataBaseStatus = dataBaseStatus;
    }

    public String getJobQualificationID() {
        return jobQualificationID;
    }

    public void setJobQualificationID(String jobQualificationID) {
        this.jobQualificationID = jobQualificationID;
    }

    public String getLevelOfEducationID() {
        return levelOfEducationID;
    }

    public void setLevelOfEducationID(String levelOfEducationID) {
        this.levelOfEducationID = levelOfEducationID;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public DepartmentManage(String qualifcation, String minimumExp, String levelOfEducation) {
        this.qualifcation = qualifcation;
        this.minimumExperiance = minimumExp;
        this.levelOfEducation = levelOfEducation;
    }

    public DepartmentManage(String jobCode, String deptJobCode, String allowedJobName, long rowType, int avilabelOnDb) {
        this.allowedJobCOde = jobCode;
        this.allowedJobName = allowedJobName;
        this.deptJobCode = deptJobCode;
        this.rowType = rowType;
        this.avilabelOnDb = avilabelOnDb;
    }

    public DepartmentManage(String jobCode, String deptJobCode, String allowedJobName, long rowType, int avilabelOnDb, int numberOfEmployee) {
        this(jobCode, deptJobCode, allowedJobName, rowType, avilabelOnDb);
        this.numberOfEmployee = numberOfEmployee;
    }
    //(jobId, jobCode, jobName, departmentId, this.getAvilabelOnDb(), numberOfEmployee, "New");

    public DepartmentManage(String jobCode, String deptJobCode, String allowedJobName, long rowType, int avilabelOnDb, int numberOfEmployee, String dataBaseStatus) {
        this(jobCode, deptJobCode, allowedJobName, rowType, avilabelOnDb, numberOfEmployee);
        this.dataBaseStatus = dataBaseStatus;
    }

    public DepartmentManage(String position, int NUmberOfYear, String type, String jobCode) {
        this.position = position;
        this.NUmberOfYear = NUmberOfYear;
        this.type = type;
        this.jobCode = jobCode;
    }

    public DepartmentManage(String jobName, String responsiblity, String rank, String qualifcation, String additionalSkill, String minimumExperiance, String type) {
        this.jobName = jobName;
        this.responsiblity = responsiblity;
        this.rank = rank;
        this.qualifcation = qualifcation;
        this.additionalSkill = additionalSkill;
        this.minimumExperiance = minimumExperiance;
        this.type = type;
    }

    public DepartmentManage(String jobName, String responsiblity, String rank, String additionalSkill, String type) {
        this.jobName = jobName;
        this.responsiblity = responsiblity;
        this.rank = rank;
        this.additionalSkill = additionalSkill;
        this.type = type;
    }

    public DepartmentManage(String qualification) {
        this.qualifcation = qualification;


    }

    public DepartmentManage(String educLevel, String minimumExperiance) {
        this.levelOfEducation = educLevel;
        this.minimumExperiance = minimumExperiance;

    }

    public DepartmentManage(String levelOfEducationID, String levelOfEducation, String minimumExp, int x) {
        this.levelOfEducationID = levelOfEducationID;
        this.minimumExperiance = minimumExp;
        this.levelOfEducation = levelOfEducation;
    }

    public DepartmentManage(String levelOfEducationID, String levelOfEducation, String minimumExp, int x, String dataBaseStatus) {
        this.levelOfEducationID = levelOfEducationID;
        this.minimumExperiance = minimumExp;
        this.levelOfEducation = levelOfEducation;
        this.dataBaseStatus = dataBaseStatus;
    }

    public int updateJobType(DepartmentManage savejobOb, DepartmentManage updateEducLevel, DepartmentManage updateQualification, String jobid) {

        DepartmentEntity jobTypeDetail = new DepartmentEntity(
                savejobOb.getJobName(),
                savejobOb.getResponsiblity(),
                savejobOb.getRank(),
                savejobOb.getQualifcation(),
                savejobOb.getAdditionalSkill(),
                savejobOb.getMinimumExperiance(), savejobOb.getType());

        if (updateEducLevel == null && updateQualification != null) {

            DepartmentEntity jobTypeQualDetail = new DepartmentEntity(
                    updateQualification.getQualifcation());

            return departmentEntity.updateJob(null, null, jobTypeQualDetail, jobid);
        } else if (updateEducLevel != null && updateQualification == null) {

            DepartmentEntity jobTypeEducDetail = new DepartmentEntity(
                    updateEducLevel.getLevelOfEducationID(),
                    updateEducLevel.getLevelOfEducation(),
                    updateEducLevel.getMinimumExperiance(), 0);


            return departmentEntity.updateJob(null, jobTypeEducDetail, null, jobid);
        }

        return 0;

    }

    public ArrayList<HashMap[]> selectJobdetail1(String batchCode) {
        return departmentEntity.selectJobdetail1(batchCode);
    }

    public DepartmentManage(String jobQualificationID, String qualification, int x) {
        this.jobQualificationID = jobQualificationID;
        this.qualifcation = qualification;

    }

    public DepartmentManage(String jobQualificationID, String qualification, int x, String dataBaseStatus) {
        this.jobQualificationID = jobQualificationID;
        this.qualifcation = qualification;
        this.dataBaseStatus = dataBaseStatus;

    }

//    public ArrayList<SelectItem> getAddressCode() {
//        ArrayList<SelectItem> addressList = new ArrayList<SelectItem>();
//        addressList.add(new SelectItem("-1", "--SELECT--"));
//        addressList.add(new SelectItem("MU", "Mugher"));
//        addressList.add(new SelectItem("AA", "Addis Ababa"));
//        addressList.add(new SelectItem("DR", "Derba"));
//        addressList.add(new SelectItem("NZ", "Nazareth"));
//        return addressList;
//    }

    public ArrayList<SelectItem> getAddressCode() {
        ArrayList<SelectItem> addressList = new ArrayList<SelectItem>();
        addressList.add(new SelectItem("-1", "--SELECT--"));
        addressList.add(new SelectItem("AA", "Addis Ababa"));
        addressList.add(new SelectItem("OT", "Out Side Addiss Ababa"));
//        addressList.add(new SelectItem("AA", "Addis Ababa"));
//        addressList.add(new SelectItem("DR", "Derba"));
//        addressList.add(new SelectItem("NZ", "Nazareth"));
        return addressList;
    }

    public String getAllowedJobCOde() {
        return allowedJobCOde;
    }

    public Option[] getDepartment() {
        return department;
    }

    public void setDepartment(Option[] department) {
        this.department = department;
    }

    public int getNumberOfEmployee() {
        return numberOfEmployee;
    }

    public void setNumberOfEmployee(int numberOfEmployee) {
        this.numberOfEmployee = numberOfEmployee;
    }

    public void setAllowedJobCOde(String allowedJobCOde) {
        this.allowedJobCOde = allowedJobCOde;
    }

    public String getAllowedJobName() {
        return allowedJobName;
    }

    public void setAllowedJobName(String allowedJobName) {
        this.allowedJobName = allowedJobName;
    }

    public String getDeptJobCode() {
        return deptJobCode;
    }

    public void setDeptJobCode(String deptJobCode) {
        this.deptJobCode = deptJobCode;
    }

    public int getAvilabelOnDb() {
        return avilabelOnDb;
    }

    public void setAvilabelOnDb(int avilabelOnDb) {
        this.avilabelOnDb = avilabelOnDb;
    }

    public String getOldID() {
        return oldID;
    }

    public void setOldID(String oldID) {
        this.oldID = oldID;
    }
    long rowType;

    public long getRowType() {
        return rowType;
    }

    public void setRowType(long rowType) {
        this.rowType = rowType;
    }

    public int getNUmberOfYear() {
        return NUmberOfYear;
    }

    public void setNUmberOfYear(int NUmberOfYear) {
        this.NUmberOfYear = NUmberOfYear;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAdditionalSkill() {
        return additionalSkill;
    }

    public void setAdditionalSkill(String additionalSkill) {
        this.additionalSkill = additionalSkill;
    }

    public DepartmentEntity getDepartmentEntity() {
        return departmentEntity;
    }

    public void setDepartmentEntity(DepartmentEntity departmentEntity) {
        this.departmentEntity = departmentEntity;
    }

    public Option[] getJob() {
        return job;
    }

    public void setJob(Option[] job) {
        this.job = job;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public String getJobName() {
        return jobName;
    }

    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    public String getMinimumExperiance() {
        return minimumExperiance;
    }

    public void setMinimumExperiance(String minimumExperiance) {
        this.minimumExperiance = minimumExperiance;
    }

    public String getQualifcation() {
        return qualifcation;
    }

    public void setQualifcation(String qualifcation) {
        this.qualifcation = qualifcation;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getResponsiblity() {
        return responsiblity;
    }

    public void setResponsiblity(String responsiblity) {
        this.responsiblity = responsiblity;
    }

    public int saveJobType(DepartmentManage savejobOb) {

        DepartmentEntity jobTypeDetail = new DepartmentEntity(
                savejobOb.getJobName(),
                savejobOb.getResponsiblity(),
                savejobOb.getRank(),
                savejobOb.getQualifcation(),
                savejobOb.getAdditionalSkill(),
                savejobOb.getMinimumExperiance(), savejobOb.getType());


        return departmentEntity.insertJob(jobTypeDetail);
    }

    public int updateJobType(DepartmentManage savejobOb, String jobid) {

        DepartmentEntity jobTypeDetail = new DepartmentEntity(
                savejobOb.getJobName(),
                savejobOb.getResponsiblity(),
                savejobOb.getRank(),
                savejobOb.getQualifcation(),
                savejobOb.getAdditionalSkill(),
                savejobOb.getMinimumExperiance(), savejobOb.getType());


        return departmentEntity.updateJob(jobTypeDetail, jobid);
    }

    public DepartmentManage() {
    }

    public Option[] getAllJob() {
        return allJob;
    }

    public void setAllJob(Option[] allJob) {
        this.allJob = allJob;
    }

    public HashMap readDepartmentId(String departmentName) {
        return departmentEntity.readDepartmenIDNew(departmentName);
    }

     public HashMap readDepartmentIdNew(String departmentName) {
        return departmentEntity.readDepartmenIDNew(departmentName);
    }

    public int readDept(String deptID) {
        return departmentEntity.readDept(Integer.parseInt(deptID));
    }

    public ArrayList<SelectItem> getDepartmentName() {
        try {
            ArrayList<DepartmentEntity> depart = departmentEntity.readDepartment();
            ArrayList<SelectItem> readDepartment = new ArrayList<SelectItem>();
            if (depart.size() > 0) {
                for (int i = 0; i < depart.size(); i++) {
                    departmentEntity = depart.get(i);
                    readDepartment.add(new Option(String.valueOf(departmentEntity.getCode()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                readDepartment.add(0, new Option(null, "-- Select Department --"));
            } else {
                readDepartment.add(0, new Option(null, "No Department Record Avilabel"));
            }
            return readDepartment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getDepartmentNameForTerm() {
        try {
            ArrayList<DepartmentEntity> depart = departmentEntity.readDepartmentTerm();
            ArrayList<SelectItem> readDepartment = new ArrayList<SelectItem>();
            if (depart.size() > 0) {
                for (int i = 0; i < depart.size(); i++) {
                    departmentEntity = depart.get(i);
                    readDepartment.add(new Option(String.valueOf(departmentEntity.getCode()) + "-" + String.valueOf(departmentEntity.getDescription()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                readDepartment.add(0, new Option(null, "-- Select Department --"));
            } else {
                readDepartment.add(0, new Option(null, "No Department Record Avilabel"));
            }
            return readDepartment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> readJobCodeOption(String department) {
        try {
            ArrayList<DepartmentEntity> deptEntityList = departmentEntity.readJob(department);
            ArrayList<Option> jobList = new ArrayList<Option>();

            if (deptEntityList.size() > 0) {
                for (int i = 0; i < deptEntityList.size(); i++) {
                    departmentEntity = deptEntityList.get(i);
                    jobList.add(new Option(String.valueOf(departmentEntity.getCode()) + "--" + String.valueOf(departmentEntity.getDescription()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                jobList.add(0, new Option(null, "-- Select Job --"));
            } else {
                jobList.add(0, new Option(null, "No Job Record Avilabel"));
            }
            return jobList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getZerfName(String departmentID) {
        try {
            ArrayList<DepartmentEntity> depart = departmentEntity.readZerf(departmentID);
            ArrayList<SelectItem> readDepartment = new ArrayList<SelectItem>();
            if (depart.size() > 0) {
                for (int i = 0; i < depart.size(); i++) {
                    departmentEntity = depart.get(i);
                    readDepartment.add(new Option(String.valueOf(departmentEntity.getCode()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                readDepartment.add(0, new Option(null, "-- Select --"));
            } else {
                readDepartment.add(0, new Option(null, "No Record Avilabel"));
            }
//            ArrayList<SelectItem> listArray = new ArrayList<SelectItem>(questionlist.size());
//            questionlist.add(listArray);
//            return listArray;
            return readDepartment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }

    public ArrayList<SelectItem> getDivisionName(String departmentID) {
        try {
            ArrayList<DepartmentEntity> depart = departmentEntity.readZerf(departmentID);
            ArrayList<SelectItem> readDepartment = new ArrayList<SelectItem>();
            if (depart.size() > 0) {
                for (int i = 0; i < depart.size(); i++) {
                    departmentEntity = depart.get(i);
                    readDepartment.add(new Option(String.valueOf(departmentEntity.getCode()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                readDepartment.add(0, new Option(null, "-- Select Department --"));
            } else {
                readDepartment.add(0, new Option(null, "No Department Record Avilabel"));
            }
//            ArrayList<SelectItem> listArray = new ArrayList<SelectItem>(questionlist.size());
//            questionlist.add(listArray);
//            return listArray;
            return readDepartment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }

    public Option[] readDpartmentToListBox() {
        ArrayList<DepartmentEntity> depart = departmentEntity.readDepartment();
        department = new Option[depart.size()];
//        for (String read : depart) {
        for (int i = 0; i < depart.size(); i++) {
            departmentEntity = depart.get(i);

            Option assign = new Option(departmentEntity.getCode(), departmentEntity.getDescription());

            department[i] = assign;


        }
        return department;
    }

    public ArrayList<SelectItem> onDisplayJob() {
        ArrayList<SelectItem> firstList = new ArrayList<SelectItem>();
        firstList.add(0, new Option(null, "Select Job"));
        return firstList;
    }

       public ArrayList<Option> onDisplayJobs() {
        ArrayList<Option> firstList = new ArrayList<Option>();
        firstList.add(0, new Option(null, "Select Job"));
        return firstList;
    }

    public Option[] onDisplayJobExperiance() {
        Option startNationality[] = new Option[21];
        Option n = new Option("--Select Number Of Years--");
        startNationality[0] = n;
        for (int i = 0; i < 20; i++) {
            Option m = new Option(i);
            startNationality[i + 1] = m;
        }


        return startNationality;
    }

    public ArrayList<SelectItem> readJobCode(String department) {
        try {
            ArrayList<DepartmentEntity> jobCode = departmentEntity.readJob(department);
            ArrayList<SelectItem> jobList = new ArrayList<SelectItem>();

            if (jobCode.size() > 0) {
                for (int i = 0; i < jobCode.size(); i++) {
                    departmentEntity = jobCode.get(i);
                    jobList.add(new Option(String.valueOf(departmentEntity.getCode()),
                            String.valueOf(departmentEntity.getDescription())));
                }
                jobList.add(0, new Option(null, "-- Select Job --"));
            } else {
                jobList.add(0, new Option(null, "No Job Record Avilabel"));
            }
//            ArrayList<SelectItem> listArray = new ArrayList<SelectItem>(questionlist.size());
//            questionlist.add(listArray);
//            return listArray;
            return jobList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }
    //===================================NewlyAdded======================================

    public ArrayList<SelectItem> readJobCodeNew(String department) {
        try {
            ArrayList<DepartmentEntity> jobCode = departmentEntity.readJob(department);
            ArrayList<SelectItem> jobList = new ArrayList<SelectItem>();

            if (jobCode.size() > 0) {
                for (int i = 0; i < jobCode.size(); i++) {
                    departmentEntity = jobCode.get(i);
                    jobList.add(new Option(String.valueOf(departmentEntity.getCode()) + "-" + String.valueOf(departmentEntity.getDescription())));

                }
                jobList.add(0, new Option(null, "-- Select Job --"));
            } else {
                jobList.add(0, new Option(null, "No Job Record Avilabel"));
            }
//            ArrayList<SelectItem> listArray = new ArrayList<SelectItem>(questionlist.size());
//            questionlist.add(listArray);
//            return listArray;
            return jobList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }


    }


    //===========================================================================
    public Option[] readAllJobBYO() {
        try {
            ArrayList<DepartmentEntity> jobCode = departmentEntity.readAllJob();
            allJob = new Option[jobCode.size() + 1];
            Option startAddJob = new Option("0", "------Select Job------");
            allJob[0] = startAddJob;
            for (int i = 0; i < jobCode.size(); i++) {
                departmentEntity = jobCode.get(i);
                Option assign = new Option(departmentEntity.getCode(), departmentEntity.getCode() + "--" + departmentEntity.getDescription());
                allJob[i + 1] = assign;
            }
            return allJob;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SelectItem> readAllJobBY() {
        try {
            ArrayList<DepartmentEntity> jobCodeList = departmentEntity.readAllJob();
            ArrayList<SelectItem> listOfJob = new ArrayList<SelectItem>();
            listOfJob.add(new SelectItem("0", "------Select Job------"));
            for (int i = 0; i < jobCodeList.size(); i++) {
                departmentEntity = jobCodeList.get(i);
                listOfJob.add(new SelectItem(departmentEntity.getCode() + "-" + departmentEntity.getDescription(),
                        departmentEntity.getDescription() + "--" + departmentEntity.getCode()));
            }
            return listOfJob;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SelectItem> readAllJob() {
        ArrayList<SelectItem> allJobList = new ArrayList<SelectItem>();
        try {
            ArrayList<DepartmentEntity> jobCode = departmentEntity.readAllJob();
            allJob = new Option[jobCode.size() + 1];

            for (int i = 0; i < jobCode.size(); i++) {
                departmentEntity = jobCode.get(i);
                allJobList.add(new Option(String.valueOf(departmentEntity.getCode()),
                        String.valueOf(departmentEntity.getCode()) + "-" +
                        String.valueOf(departmentEntity.getDescription())));
            }
            allJobList.add(0, new Option(null, "-- Select Job --"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allJobList;
    }

    public Option[] readExperianceJob() {
        int n = 0;
        try {
            String minPostionwithExpe;
            ArrayList<DepartmentEntity> jobExperiacne = departmentEntity.readExperienceJob();
            allJob = new Option[jobExperiacne.size() + 3];
            Option startJobExperiance = new Option("------Select Min Experiance------");
            Option hederJobExperiance = new Option("Postion.............Number Of Years");
            allJob[0] = startJobExperiance;
            allJob[1] = hederJobExperiance;
            for (int i = 0; i < jobExperiacne.size(); i++) {
                departmentEntity = jobExperiacne.get(i);
                minPostionwithExpe = departmentEntity.getCode() + "..............." + departmentEntity.getExperianceId();
                n = i + 2;
                Option assign = new Option(departmentEntity.getCode(), minPostionwithExpe);
                allJob[n] = assign;

            }
            Option foterJobExperiance = new Option("Other");
            allJob[n + 1] = foterJobExperiance;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allJob;
    }

    public Option[] recuitmentType() {
        Option type[] = new Option[3];
        Option onDispay = new Option("---- Recuitment Type ----");
        Option permant = new Option("Permanent");
        Option conterat = new Option("Contract");
        type[0] = onDispay;
        type[1] = permant;
        type[2] = conterat;


        return type;
    }

    public ArrayList<String> selectJobdetail(String job_code) {
        ArrayList<String> jobdetil = null;
        try {
            jobdetil = departmentEntity.selectJobdetail(job_code);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return jobdetil;
    }

    public HashMap[] readJobDescription(String jobCode) {
        return departmentEntity.selectJobDescription(jobCode);
    }

    public HashMap selectJobDetaille(String jobCode) {
        return departmentEntity.selectJobDetaille(jobCode);
    }

    public int saveMinimumExperience(DepartmentManage saveMinExp) {


        DepartmentEntity minExp = new DepartmentEntity(saveMinExp.getPosition(), saveMinExp.getJobCode(), saveMinExp.getNUmberOfYear(), saveMinExp.getType());

        return departmentEntity.saveMinimumExperience(minExp);
    }

    public int deleteJobType(String jobid) {
        try {
            return departmentEntity.deleteJobType(jobid);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int deleteJobDetail(String jobid, int id) {
        try {
            return departmentEntity.deleteJobDetail(jobid, id);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    public int addDept(String deptId, String deptName, String mission, String vision, String est_Date, String branch_id, String addressCode) {
        return departmentEntity.addDept(deptId, deptName, mission, vision, est_Date, branch_id, addressCode);
    }

    public int updateDepartment(String deptId, String deptName, String mission, String vision, String est_Date, String adds_code) {
        return departmentEntity.updateDepartment(deptId, deptName, mission, vision, est_Date, adds_code);
    }

    public int addDeptJob(String deptId, String jobCode, int numberOfEmployee) {
        try {
            return departmentEntity.addDeptJob(deptId, jobCode, numberOfEmployee);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int deleteDept(long deptId) {
        return departmentEntity.deleteDept(deptId);
    }

    public boolean isSelectedJob() {
        return selectedJob;
    }

    public void setSelectedJob(boolean selectedJob) {
        this.selectedJob = selectedJob;
    }

    public int maintainDepartmentAddress(int type, String deptCode, String region,
            String zone, String woreda, String kebelle, String floor, String block, String officeNumber, String telMobile, String telOffice,
            String telOfficeExt, String email) {
        DepartmentEntity deptAddress = new DepartmentEntity(deptCode, region, zone, woreda,
                kebelle, floor, block, officeNumber, telOffice, telOfficeExt, telMobile, email);
        try {
            if (type == 1) {
                if (departmentEntity.saveDeptAddress(deptAddress) == 1) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                if (departmentEntity.updateDeptAddress(deptAddress) == 1) {
                    return 1;
                } else {
                    return 0;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }
        return 0;
    }

    public String getDepartmentAddressDescription(int departmentId) {
        try {
            ResultSet _rs = departmentEntity.selectDepartmentAddress(departmentId);
            String address = "";
            if (_rs.next()) {
                address += _rs.getString("REGION_ID") + "=> " + _rs.getString("ZONE_OR_CITY") + "=> " + _rs.getString("WOREDA_OR_SUBCITY");
            //address += _rs.getString("REGION_NAME") + "=> " + _rs.getString("ZONE_OR_CITY_NAME") + "=> " + _rs.getString("WOREDA_OR_SUBCITY_NAME");
            } else {
                address = "Not Registered ";
            }
            _rs.close();
            return address;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readDepartmentAddress(int departmentId) {
        return departmentEntity.readDepartmentId(departmentId);

    }

//    public HashMap readDepartmentJob(int departmentId) {
//        return departmentEntity.readDepartmentId(departmentId);
//
//    }
    public boolean deleteAddressDept(String sELECTED_ORG_ID) {

        if (departmentEntity.deleteDeptAddress(sELECTED_ORG_ID) != 0) {
            return true;
        } else {
            return false;
        }

    }

    public HashMap[] readDepartmentJob(long departmentId) {
        return departmentEntity.readDeptJOb(departmentId);
    }
      public HashMap[] readDepartmentJobNew(long departmentId) {
        return departmentEntity.readDeptJObNew(departmentId);
    }


    public int countDepartmentJob(int departmentId) {
        return departmentEntity.countDeptJOb(departmentId);
    }

    public int deleteDeptUsingID(String departmentID, String jobCode) {
        return departmentEntity.deleteDeptUsingID(departmentID, jobCode);
    }

    public int deleteDeptJob(String departmentID) {
        return departmentEntity.deleteDeptJob(departmentID);
    }

    public int deleteDeptJob(String departmentID, String jobCode) {
        return departmentEntity.deleteDeptJob(departmentID, jobCode);
    }

    public String readDepartmentDescrption(String departmentID) {
        return departmentEntity.readDepartmentDescrption(departmentID);
    }

   public  String readDepartmentNameBiruk(String departmentID){
     try {
            return departmentEntity.traceDepartemttNameBiruk(departmentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String traceDepartemnt(String departmentID) {
        try {
            return departmentEntity.traceDepartemttNameBiruk(departmentID);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public int saveJobType(DepartmentManage savejobOb, DepartmentManage educLevel, DepartmentManage qualification, int saveIndicator, String jobID) {

        if (educLevel != null && qualification != null) {
            DepartmentEntity jobTypeDetail = new DepartmentEntity(
                    savejobOb.getJobName(),
                    savejobOb.getResponsiblity(),
                    savejobOb.getRank(),
                    savejobOb.getAdditionalSkill(),
                    savejobOb.getType());
            DepartmentEntity jobTypeEducDetail = new DepartmentEntity(
                    educLevel.getLevelOfEducation(),
                    educLevel.getMinimumExperiance(), 0);
            DepartmentEntity jobTypeQualDetail = new DepartmentEntity(
                    qualification.getQualifcation());

            return departmentEntity.insertJob(jobTypeDetail, jobTypeEducDetail, jobTypeQualDetail, saveIndicator, jobID);
        } else if (educLevel == null && qualification != null) {
            DepartmentEntity jobTypeDetail = new DepartmentEntity(
                    savejobOb.getJobName(),
                    savejobOb.getResponsiblity(),
                    savejobOb.getRank(),
                    savejobOb.getAdditionalSkill(),
                    savejobOb.getType());
            DepartmentEntity jobTypeQualDetail = new DepartmentEntity(
                    qualification.getQualifcation());

            return departmentEntity.insertJob(jobTypeDetail, null, jobTypeQualDetail, saveIndicator, jobID);
        } else if (educLevel != null && qualification == null) {
            DepartmentEntity jobTypeDetail = new DepartmentEntity(
                    savejobOb.getJobName(),
                    savejobOb.getResponsiblity(),
                    savejobOb.getRank(),
                    savejobOb.getAdditionalSkill(),
                    savejobOb.getType());
            DepartmentEntity jobTypeEducDetail = new DepartmentEntity(
                    educLevel.getLevelOfEducation(),
                    educLevel.getMinimumExperiance(), 0);


            return departmentEntity.insertJob(jobTypeDetail, jobTypeEducDetail, null, saveIndicator, jobID);
        } else {
            DepartmentEntity jobTypeDetail = new DepartmentEntity(
                    savejobOb.getJobName(),
                    savejobOb.getResponsiblity(),
                    savejobOb.getRank(),
                    savejobOb.getAdditionalSkill(),
                    savejobOb.getType());

            return departmentEntity.insertJob(jobTypeDetail, null, null, -1, "");

        }
    }

    public ArrayList<SelectItem> readAllJob(String Dept_Id) {
        ArrayList<SelectItem> allJobList = new ArrayList<SelectItem>();
        try {
            ArrayList<DepartmentEntity> jobCode = departmentEntity.readAllJob(Dept_Id);
            allJob = new Option[jobCode.size() + 1];

            for (int i = 0; i < jobCode.size(); i++) {
                departmentEntity = jobCode.get(i);
                allJobList.add(new Option(String.valueOf(departmentEntity.getCode()),
                        String.valueOf(departmentEntity.getDescription())));
            }
            allJobList.add(0, new Option(null, "-- Select Job --"));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return allJobList;
    }

    public String readDepartmentPath(String deptId) {
        try {
            String path = "";
            ResultSet rs = (new Department()).readParentDepartments(deptId);
            if (rs.next()) {
                path = rs.getString("PATH_BY_NAME");
            }
            rs.close();
            return path;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String traceDepartemtnId(String departmentId) {
        return departmentEntity.traceDepartemtnId(departmentId);
    }

  
}
