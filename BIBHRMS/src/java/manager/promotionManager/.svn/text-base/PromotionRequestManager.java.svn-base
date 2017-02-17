/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.promotionManager;

import entity.Promotion.PromotionEntity;
import entity.documentEntity.DocumentApproveEntity;
import entity.employeeEntity.ExperianceEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author HRMS
 */
public class PromotionRequestManager {

    DocumentApproveEntity documentApproveEntity = new DocumentApproveEntity();
    EmployeeManage employeeManager = new EmployeeManage();
    ExperianceEntity employeeExperianceEntity = new ExperianceEntity();
    PromotionEntity promotionEntity = new PromotionEntity();

    public DocumentApproveEntity getDocumentApproveEntity() {
        return documentApproveEntity;
    }

    public void setDocumentApproveEntity(DocumentApproveEntity documentApproveEntity) {
        this.documentApproveEntity = documentApproveEntity;
    }

    public ExperianceEntity getEmployeeExperianceEntity() {
        return employeeExperianceEntity;
    }

    public void setEmployeeExperianceEntity(ExperianceEntity employeeExperianceEntity) {
        this.employeeExperianceEntity = employeeExperianceEntity;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public ArrayList<EmployeeExperienceHistroyModel> getEmpExperienceHistory(String empId) {
        try {
            ResultSet _rs = promotionEntity.selectEmployeeExperience(empId);
            ArrayList<EmployeeExperienceHistroyModel> empExpHistroy = new ArrayList<EmployeeExperienceHistroyModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String empName = empId;
                String serviceYr = "";

                String jobCode = _rs.getString("PREV_JOB_POSITION");
                String jobDesc = _rs.getString("OLDJOBDESC");
                String rank = _rs.getString("PREV_RANK");
                String salary = _rs.getString("PREV_SALARY");
                String endDate = _rs.getString("PROMOTION_DATE");
                String startDate = "";
                int i = _rs.getRow();
                _rs.absolute(i - 1);
                startDate = _rs.getString("PROMOTION_DATE");

                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId, empName,
                        serviceYr, jobCode, jobDesc, rank, salary, startDate, endDate, false));

                _rs.absolute(i);
            }
            _rs = promotionEntity.readExperiance(empId);
            while (_rs.next()) {
                counter++;
                String empName = empId;
                String serviceYr = "";
                String jobCode = _rs.getString("JOB_TITLE");
                String jobDesc = _rs.getString("JOB_TITLE");
                String rank = _rs.getString("RANK");
                String salary = _rs.getString("SALARY");
                String endDate = _rs.getString("END_DATE");
                String startDate = _rs.getString("START_DATE");
                int i = _rs.getRow();
                _rs.absolute(i - 1);
                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId, empName, serviceYr, jobCode, jobDesc, rank, salary, startDate, endDate, false));
                _rs.absolute(i);
            }
            promotionEntity.saveExper(empExpHistroy);
            return empExpHistroy;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
public ArrayList<EmployeeExperienceHistroyModel> getEmpExperienceForReq(String empId) {
        try {
            ResultSet _rs = promotionEntity.selectEmployeeExperience(empId);
            ArrayList<EmployeeExperienceHistroyModel> empExpHistroy = new ArrayList<EmployeeExperienceHistroyModel>();
            int counter = 0;

            _rs = promotionEntity.readExperiance(empId);
            while (_rs.next()) {
                counter++;
                String empName = empId;
                String serviceYr = "";
                String jobCode = _rs.getString("JOB_TITLE");
                String jobDesc = _rs.getString("JOB_TITLE");
                String rank = _rs.getString("RANK");
                String salary = _rs.getString("SALARY");
                String endDate = _rs.getString("END_DATE");
                String startDate = _rs.getString("START_DATE");
                int i = _rs.getRow();
                _rs.absolute(i - 1);
                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId, empName, serviceYr, jobCode, jobDesc, rank, salary, startDate, endDate, false));
                _rs.absolute(i);
            }
            return empExpHistroy;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
    public ArrayList<EmployeeExperienceHistroyModel> getEmpExperienceHistoryPromotion(String empId) {
        try {
            ResultSet _rs = promotionEntity.getEmpExperienceHistoryPromotion(empId);
            ArrayList<EmployeeExperienceHistroyModel> empExpHistroy = new ArrayList<EmployeeExperienceHistroyModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String empName = empId;
                String serviceYr = "";
                boolean is_Select = false;
                String expID = _rs.getString("EXP_ID");
                String jobDesc = _rs.getString("JOB_TITLE");
                String endDate = _rs.getString("END_DATE");
                String startDate = "";
                int i = _rs.getRow();
                _rs.absolute(i - 1);
                startDate = _rs.getString("START_DATE");

                if (!(_rs.getString("RELATED")).equalsIgnoreCase("NO")) {
                    is_Select = true;
                }
                empExpHistroy.add(new EmployeeExperienceHistroyModel(counter, empId,
                        expID, jobDesc, startDate, endDate, is_Select));

                _rs.absolute(i);
            }
            return empExpHistroy;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static class EmployeeExperienceHistroyModel implements Serializable {

        private int counter;
        private String empId;
        private String empName;
        private String serviceYr;
        private String jobCode;
        private String jobDesc;
        private String rank;
        private String salary;
        private String startDate;
        private String endDate;
        private boolean related;
        private String expID;

        public String getExpID() {
            return expID;
        }

        public void setExpID(String expID) {
            this.expID = expID;
        }

        public boolean isRelated() {
            return related;
        }

        public void setRelated(boolean related) {
            this.related = related;
        }

        /**
         * @return the empId
         */
        public String getEmpId() {
            return empId;
        }

        /**
         * @param empId the empId to set
         */
        public void setEmpId(String empId) {
            this.empId = empId;
        }

        /**
         * @return the empName
         */
        public String getEmpName() {
            return empName;
        }

        /**
         * @param empName the empName to set
         */
        public void setEmpName(String empName) {
            this.empName = empName;
        }

        /**
         * @return the serviceYr
         */
        public String getServiceYr() {
            return serviceYr;
        }

        /**
         * @param serviceYr the serviceYr to set
         */
        public void setServiceYr(String serviceYr) {
            this.serviceYr = serviceYr;
        }

        /**
         * @return the jobCode
         */
        public String getJobCode() {
            return jobCode;
        }

        /**
         * @param jobCode the jobCode to set
         */
        public void setJobCode(String jobCode) {
            this.jobCode = jobCode;
        }

        /**
         * @return the jobDesc
         */
        public String getJobDesc() {
            return jobDesc;
        }

        /**
         * @param jobDesc the jobDesc to set
         */
        public void setJobDesc(String jobDesc) {
            this.jobDesc = jobDesc;
        }

        /**
         * @return the rank
         */
        public String getRank() {
            return rank;
        }

        /**
         * @param rank the rank to set
         */
        public void setRank(String rank) {
            this.rank = rank;
        }

        /**
         * @return the salary
         */
        public String getSalary() {
            return salary;
        }

        /**
         * @param salary the salary to set
         */
        public void setSalary(String salary) {
            this.salary = salary;
        }

        /**
         * @return the startDate
         */
        public String getStartDate() {
            return startDate;
        }

        /**
         * @param startDate the startDate to set
         */
        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        /**
         * @return the endDate
         */
        public String getEndDate() {
            return endDate;
        }

        /**
         * @param endDate the endDate to set
         */
        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        /**
         * @return the counter
         */
        public int getCounter() {
            return counter;
        }

        /**
         * @param counter the counter to set
         */
        public void setCounter(int counter) {
            this.counter = counter;
        }

        public EmployeeExperienceHistroyModel(int counter, String empId,
                String empName, String serviceYr, String jobCode, String jobDesc,
                String rank, String salary, String startDate, String endDate, boolean related) {
            this.counter = counter;
            this.empId = empId;
            this.empName = empName;
            this.serviceYr = serviceYr;
            this.jobCode = jobCode;
            this.jobDesc = jobDesc;
            this.rank = rank;
            this.salary = salary;
            this.startDate = startDate;
            this.endDate = endDate;
            this.related = related;
        }

        public EmployeeExperienceHistroyModel(int counter, String empId,
                String expID, String jobDesc,
                String startDate, String endDate, boolean related) {
            this.counter = counter;
            this.empId = empId;
            this.expID = expID;
            this.jobDesc = jobDesc;
            this.startDate = startDate;
            this.endDate = endDate;
            this.related = related;
        }
    }
}
