/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.reporterManager;

/**
 *
 * @author jone
 */
import entity.reporterEntity.employeePersonalReport.EmployeePersonalReportEntity;
import java.io.InputStream;
import entity.reporterEntity.employeeProfileReportEntity.EmployeeProfileReportEntity;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.GregorianCalendarManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class EmployeePersonalInfo {

    EmployeePersonalReportEntity employeeProfileReportEntity = new EmployeePersonalReportEntity();

    public ArrayList<HashMap> loadEmployeeInformationForReport()
    {
  ArrayList<HashMap> employeeInfo = new ArrayList<HashMap>();

            try {

                OracleCachedRowSet ocrs = employeeProfileReportEntity.loadEmployeeInfoForReport();
                while (ocrs.next()) {
                    HashMap hm = new HashMap();
                    hm.put("EMPLOYEEID", ocrs.getString("EMP_ID"));
                    hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                    hm.put("AGE", ocrs.getString("AGE"));
                    hm.put("SEX", ocrs.getString("SEX"));
                    hm.put("NATION", ocrs.getString("NATIONALITY"));
                    hm.put("DATEOFBIRTH", ocrs.getString("DATE_OF_BIRTH"));
                    hm.put("HIREDATE", ocrs.getString("HIRE_DATE"));
                    hm.put("EDUCATIONLEVEL", ocrs.getString("EDUCATIONLEAVE"));
                    hm.put("EDUCATIONTYPE", ocrs.getString("EDUCATIONTYPE"));
                    hm.put("RELIGION", ocrs.getString("RELIGION"));        //
                    hm.put("MARITAL_STATUS", ocrs.getString("MARITAL_STATUS"));
                    hm.put("RETIREMENT_NO", ocrs.getString("RETIREMENT_NO"));
                    hm.put("TIN_NUMBER", ocrs.getString("TIN_NUMBER"));
                    hm.put("EXPRIANCEINBIB", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("OTHEREXPRIANCE", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                    hm.put("RANK", ocrs.getString("RANK_ID"));
                    hm.put("DEPARTMENT", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("TEAM", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("WORKPLACE", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("INTIALSALARY", ocrs.getString("SALARY"));
                    hm.put("CURRENTSALARY", ocrs.getString("SALARY"));
                    employeeInfo.add(hm);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
    
         return employeeInfo;
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public ArrayList<HashMap> loadEmployeeProbationInformationForReport()
    {

  ArrayList<HashMap> employeeInfo = new ArrayList<HashMap>();

            try {

                OracleCachedRowSet ocrs = employeeProfileReportEntity.loadProbationEmployeeForManagementInfoForReport();
                while (ocrs.next()) {
                    HashMap hm = new HashMap();
                    hm.put("EMPLOYEEID", ocrs.getString("EMP_ID"));
                    hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                    hm.put("AGE", ocrs.getString("AGE"));
                    hm.put("SEX", ocrs.getString("SEX"));
                    hm.put("HIREDATE", ocrs.getString("HIRE_DATE"));
                  //  hm.put("EDUCATIONLEVEL", ocrs.getString("EDUCATIONLEAVE"));
                    hm.put("JOB_LEVEL", ocrs.getString("JOB_LEVEL"));
                    hm.put("EXPRIANCEINBIB", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("INSIDEeXPRIANCE", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("RANK", ocrs.getString("RANK_ID"));
                    hm.put("DEPARTMENT", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("TEAM", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("WORKPLACE", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("CURRENTSALARY", ocrs.getString("SALARY"));
                    employeeInfo.add(hm);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

         return employeeInfo;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

      public ArrayList<HashMap> loadEmployeeProbationForNonClericalInformationForReport()
    {

  ArrayList<HashMap> employeeInfo = new ArrayList<HashMap>();

            try {

                OracleCachedRowSet ocrs = employeeProfileReportEntity.loadProbationEmployeeForManagementInfoForReport();
                while (ocrs.next()) {
                    HashMap hm = new HashMap();
                    hm.put("EMPLOYEEID", ocrs.getString("EMP_ID"));
                    hm.put("FULLNAME", ocrs.getString("FULLNAME"));
                    hm.put("AGE", ocrs.getString("AGE"));
                    hm.put("SEX", ocrs.getString("SEX"));
                    hm.put("HIREDATE", ocrs.getString("HIRE_DATE"));
                  //  hm.put("EDUCATIONLEVEL", ocrs.getString("EDUCATIONLEAVE"));
                    hm.put("JOB_LEVEL", ocrs.getString("JOB_LEVEL"));
                    hm.put("EXPRIANCEINBIB", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("INSIDEeXPRIANCE", ocrs.getString("INSIDEeXPRIANCE"));
                    hm.put("RANK", ocrs.getString("RANK_ID"));
                    hm.put("DEPARTMENT", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("TEAM", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("WORKPLACE", ocrs.getString("DEP_DESCRIPTION"));
                    hm.put("CURRENTSALARY", ocrs.getString("SALARY"));
                    employeeInfo.add(hm);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

         return employeeInfo;
    }





     ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public static class PersonalReportModel {
        String empID;
        String empFullName;
        int age;
        String empSex;
        String nation;
        String dataOfBirth;
        String hireDate;
        String eudcationLevel;
        String educationType;
        String religion;
        String maritalStatus;
        String retirimentNumber;
        String tinNumber;
        String insideExpirance;
        String otherExpirance;
        String jobName;
        String jobDescription;
        String rank;
        String department;
        String workPlace;
        String initilaSalary;
        String currentSalary;

        public PersonalReportModel(String empID, String empFullName, int age, String empSex, String nation, String dataOfBirth, String hireDate, String eudcationLevel, String educationType, String religion, String maritalStatus, String retirimentNumber, String tinNumber, String insideExpirance, String otherExpirance, String jobName, String jobDescription, String rank, String department, String workPlace, String initilaSalary, String currentSalary) {
            this.empID=empID;
            this.empFullName=empFullName;
            this.age=age;
            this.empSex=empSex;
            this.nation=nation;
            this.dataOfBirth=dataOfBirth;
            this.hireDate=hireDate;
            this.eudcationLevel=eudcationLevel;
            this.educationType=educationType;
            this.religion=religion;
            this.maritalStatus=maritalStatus;
            this.retirimentNumber=retirimentNumber;
            this.tinNumber=tinNumber;
            this.insideExpirance=insideExpirance;
            this.otherExpirance=otherExpirance;
            this.jobName=jobName;
            this.jobDescription=jobDescription;
            this.rank=rank;
            this.department=department;
            this.workPlace=workPlace;
            this.initilaSalary=initilaSalary;
            this.currentSalary=currentSalary;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCurrentSalary() {
            return currentSalary;
        }

        public void setCurrentSalary(String currentSalary) {
            this.currentSalary = currentSalary;
        }

        public String getDataOfBirth() {
            return dataOfBirth;
        }

        public void setDataOfBirth(String dataOfBirth) {
            this.dataOfBirth = dataOfBirth;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEducationType() {
            return educationType;
        }

        public void setEducationType(String educationType) {
            this.educationType = educationType;
        }

        public String getEmpFullName() {
            return empFullName;
        }

        public void setEmpFullName(String empFullName) {
            this.empFullName = empFullName;
        }

        public String getEmpID() {
            return empID;
        }

        public void setEmpID(String empID) {
            this.empID = empID;
        }

        public String getEmpSex() {
            return empSex;
        }

        public void setEmpSex(String empSex) {
            this.empSex = empSex;
        }

        public String getEudcationLevel() {
            return eudcationLevel;
        }

        public void setEudcationLevel(String eudcationLevel) {
            this.eudcationLevel = eudcationLevel;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getInitilaSalary() {
            return initilaSalary;
        }

        public void setInitilaSalary(String initilaSalary) {
            this.initilaSalary = initilaSalary;
        }

        public String getInsideExpirance() {
            return insideExpirance;
        }

        public void setInsideExpirance(String insideExpirance) {
            this.insideExpirance = insideExpirance;
        }

        public String getJobDescription() {
            return jobDescription;
        }

        public void setJobDescription(String jobDescription) {
            this.jobDescription = jobDescription;
        }

        public String getJobName() {
            return jobName;
        }

        public void setJobName(String jobName) {
            this.jobName = jobName;
        }

        public String getMaritalStatus() {
            return maritalStatus;
        }

        public void setMaritalStatus(String maritalStatus) {
            this.maritalStatus = maritalStatus;
        }

        public String getNation() {
            return nation;
        }

        public void setNation(String nation) {
            this.nation = nation;
        }

        public String getOtherExpirance() {
            return otherExpirance;
        }

        public void setOtherExpirance(String otherExpirance) {
            this.otherExpirance = otherExpirance;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getReligion() {
            return religion;
        }

        public void setReligion(String religion) {
            this.religion = religion;
        }

        public String getRetirimentNumber() {
            return retirimentNumber;
        }

        public void setRetirimentNumber(String retirimentNumber) {
            this.retirimentNumber = retirimentNumber;
        }

        public String getTinNumber() {
            return tinNumber;
        }

        public void setTinNumber(String tinNumber) {
            this.tinNumber = tinNumber;
        }

        public String getWorkPlace() {
            return workPlace;
        }

        public void setWorkPlace(String workPlace) {
            this.workPlace = workPlace;
        }

        public PersonalReportModel() {
        }





    }
}


