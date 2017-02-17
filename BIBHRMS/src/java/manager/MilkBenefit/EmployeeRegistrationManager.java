/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.MilkBenefit;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.webui.jsf.model.Option;
import entity.MilkBenefitEntity.EmployeeRegistrationEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Admin
 */
public class EmployeeRegistrationManager {

    EmployeeRegistrationEntity employeeRegistrationEntity = new EmployeeRegistrationEntity();

    public static class EmployeeMilkModel implements Serializable {

        int benefitID;
        String empId;
        String type;
        int amount;
        String remark;
        String fullName;
        String databasStatus;
        DefaultSelectedData selectedtype;
        boolean rendered;
        float amountInCash;
        int deptId;
        float rate;
        int attendance;
        float totalAmount;
        String startDate;
        String endDate;
        String numberOfDate;
        String availablity;
        String appliedDate;
        String requestType;
        String requesterID;
        String userName;
        String recoredTime;
        String requestStatus;
        int requestId;
        int listId;

        public EmployeeMilkModel() {

        }
        public EmployeeMilkModel(String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;

        }

        public EmployeeMilkModel(String empID, String empName, int attendance, int rate, float totalAmounts, int departmentID, boolean rendered, String databaseStatus) {
             this.empId = empID;
            this.fullName = empName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.attendance = attendance;
            this.deptId = departmentID;
            this.rate=rate;
            this.totalAmount=totalAmounts;
        }
        public EmployeeMilkModel(String empID, String empName, int attendance, float rate, float totalAmounts, int departmentID, boolean rendered, String databaseStatus,int listId) {
             this.empId = empID;
            this.fullName = empName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.attendance = attendance;
            this.deptId = departmentID;
            this.rate=rate;
            this.totalAmount=totalAmounts;
            this.listId=listId;
        }

        public EmployeeMilkModel(String empId, String fullName, boolean rendered, String databaseStatus, int deptId, float rate, String remark, int attendance, float totalAmount) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.rate = rate;
            this.attendance = attendance;
            this.totalAmount = totalAmount;
        }

        public EmployeeMilkModel(String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int benefitID) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.benefitID = benefitID;

        }

        public EmployeeMilkModel(String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, float rate, int benefitID, float totalAmount) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.benefitID = benefitID;
            this.rate = rate;
            this.attendance = attendance;
            this.totalAmount = totalAmount;
        }

        public EmployeeMilkModel(int reqestId,String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, int rate, int benefitID, float totalAmount,String startDate,String endDate,String appliedDate, String avilablity,String requestType,String requesterID,String requestStatus, String userName,String recorededDateAndTime,String description) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.benefitID = benefitID;
            this.rate = rate;
            this.attendance = attendance;
            this.totalAmount = totalAmount;
            this.startDate=startDate;
            this.endDate=endDate;
            this.requestType=requestType;
            this.availablity=avilablity;
            this.requesterID=requesterID;
            this.remark=description;
            this.recoredTime=recorededDateAndTime;
            this.userName=userName;
            this.requestStatus=requestStatus;
            this.appliedDate=appliedDate;
            this.requestId=reqestId;

        }
         public EmployeeMilkModel(int reqestId,String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, float rate, int benefitID, float totalAmount,String startDate,String endDate,String appliedDate, String avilablity,String requestType,String requesterID,String requestStatus, String userName,String description) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.benefitID = benefitID;
            this.rate = rate;
            this.attendance = attendance;
            this.totalAmount = totalAmount;
            this.startDate=startDate;
            this.endDate=endDate;
            this.requestType=requestType;
            this.availablity=avilablity;
            this.requesterID=requesterID;
            this.remark=description;

            this.userName=userName;
            this.requestStatus=requestStatus;
            this.appliedDate=appliedDate;
            this.requestId=reqestId;

        }
 public EmployeeMilkModel(String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, float rate, int benefitID, float totalAmount,String startDate,String endDate,String appliedDate, String avilablity,String requestType,String requesterID,String requestStatus, String userName,String recorededDateAndTime,String description) {
            this.empId = empId;
            this.fullName = fullName;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
            this.remark = remark;
            this.deptId = deptId;
            this.benefitID = benefitID;
            this.rate = rate;
            this.attendance = attendance;
            this.totalAmount = totalAmount;
            this.startDate=startDate;
            this.endDate=endDate;
            this.requestType=requestType;
            this.availablity=avilablity;
            this.requesterID=requesterID;
            this.remark=description;
            this.recoredTime=recorededDateAndTime;
            this.userName=userName;
            this.requestStatus=requestStatus;
            this.appliedDate=appliedDate;


        }
        public EmployeeMilkModel(String requesterId, String type, int amount, String remark, boolean rendered, String databaseStatus) {
            this.empId = requesterId;
            this.type = type;
            this.amount = amount;
            this.remark = remark;
            this.rendered = rendered;
            this.databasStatus = databaseStatus;
        }

//        public EmployeeMilkModel(int requestID, String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, int rate, int benefitID, float totalAmount, String startDate, String endDate, String appliedDate, String avilablity, String requestType, String requesterID, String requestStatus, String userName, String recorededDateAndTime, String description) {
//              this.empId = empId;
//            this.fullName = fullName;
//            this.rendered = rendered;
//            this.databasStatus = databaseStatus;
//            this.remark = remark;
//            this.deptId = deptId;
//            this.benefitID = benefitID;
//            this.rate = rate;
//            this.attendance = attendance;
//            this.totalAmount = totalAmount;
//            this.startDate=startDate;
//            this.endDate=endDate;
//            this.requestType=requestType;
//            this.availablity=avilablity;
//            this.requesterID=requesterID;
//            this.remark=description;
//            this.recoredTime=recorededDateAndTime;
//            this.userName=userName;
//            this.requestStatus=requestStatus;
//            this.requestId=requestID;
//        }

        

        public int getAmount() {
            return amount;
        }

        public boolean isRendered() {
            return rendered;
        }

        public String getFullName() {
            return fullName;
        }

        public String getRequestType() {
            return requestType;
        }

        public int getRequestId() {
            return requestId;
        }

        public int getListId() {
            return listId;
        }

        public void setListId(int listId) {
            this.listId = listId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public void setRequestType(String requestType) {
            this.requestType = requestType;
        }

        public String getRequesterID() {
            return requesterID;
        }

        public void setRequesterID(String requesterID) {
            this.requesterID = requesterID;
        }

        public int getDeptId() {
            return deptId;
        }

        public String getAvailablity() {
            return availablity;
        }

        public void setAvailablity(String availablity) {
            this.availablity = availablity;
        }

        public String getRecoredTime() {
            return recoredTime;
        }

        public void setRecoredTime(String recoredTime) {
            this.recoredTime = recoredTime;
        }

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

      

        public String getAppliedDate() {
            return appliedDate;
        }

        public void setAppliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getNumberOfDate() {
            return numberOfDate;
        }

        public void setNumberOfDate(String numberOfDate) {
            this.numberOfDate = numberOfDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public void setDeptId(int deptId) {
            this.deptId = deptId;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public int getAttendance() {
            return attendance;
        }

        public void setAttendance(int attendance) {
            this.attendance = attendance;
        }

        public float getRate() {
            return rate;
        }

        public void setRate(float rate) {
            this.rate = rate;
        }

        

        public void setRate(int rate) {
            this.rate = rate;
        }

        public float getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(float totalAmount) {
            this.totalAmount = totalAmount;
        }

        public void setRendered(boolean rendered) {
            this.rendered = rendered;
        }

        public DefaultSelectedData getSelectedtype() {
            return selectedtype;
        }

        public float getAmountInCash() {
            return amountInCash;
        }

        public void setAmountInCash(float amountInCash) {
            this.amountInCash = amountInCash;
        }

        public void setSelectedtype(DefaultSelectedData selectedtype) {
            this.selectedtype = selectedtype;
        }

        public String getDatabasStatus() {
            return databasStatus;
        }

        public void setDatabasStatus(String databasStatus) {
            this.databasStatus = databasStatus;
        }

        public int getBenefitID() {
            return benefitID;
        }

        public void setBenefitID(int benefitID) {
            this.benefitID = benefitID;
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        public String getEmpId() {
            return empId;
        }

        public void setEmpId(String empId) {
            this.empId = empId;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public EmployeeMilkModel(String empId, String type, int amount, String remark, String databasStatus, DefaultSelectedData selectedtype) {
            this.empId = empId;
            this.type = type;
            this.amount = amount;
            this.remark = remark;
            this.databasStatus = databasStatus;
            this.selectedtype = selectedtype;
        }

        public EmployeeMilkModel(int benefitID, String empId, String type, int amount, String remark, String databasStatus, DefaultSelectedData selectedtype) {
            this.benefitID = benefitID;
            this.empId = empId;
            this.type = type;
            this.amount = amount;
            this.remark = remark;
            this.databasStatus = databasStatus;
            this.selectedtype = selectedtype;
        }
    }

    public ArrayList<Option> getType() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option("SELECTType", "SELECT Type"));
        categoryList.add(new Option("InKind", "In Kind"));
        categoryList.add(new Option("InCash", "In Cash"));
        return categoryList;
    }

    public String getEmployeeStatus(String empId) {
        String typeOFAccredated = null;
        try {
            ResultSet _rs = employeeRegistrationEntity.selectEmployeeStatu(empId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("EMP_STATUS");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return typeOFAccredated;
    }

    public ArrayList<EmployeeMilkModel> getAllEmployeeList() {
        ArrayList<EmployeeMilkModel> benefitTypes = new ArrayList<EmployeeMilkModel>();
        try {
            ResultSet _rs = employeeRegistrationEntity.selectAllEmployees();
            while (_rs.next()) {
                EmployeeMilkModel benefitTypeModel = new EmployeeMilkModel();
                benefitTypeModel.setBenefitID(_rs.getInt("ID"));
                benefitTypeModel.setEmpId(_rs.getString("EMP_ID"));
                benefitTypeModel.setAmount(_rs.getInt("AMOUNT"));
                benefitTypeModel.setType(_rs.getString("TYPE_OF_BENEFIT"));
                benefitTypeModel.setRemark(_rs.getString("REMARK"));
                benefitTypeModel.setDatabasStatus("Old");
                DefaultSelectedData defaultSelectedData = new DefaultSelectedData();
                defaultSelectedData.setSelectedItem(_rs.getString("TYPE_OF_BENEFIT"));
                benefitTypeModel.setSelectedtype(defaultSelectedData);
                benefitTypes.add(benefitTypeModel);
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<EmployeeMilkModel> getAtendedEmployeeList() {
        ArrayList<EmployeeMilkModel> benefitTypes = new ArrayList<EmployeeMilkModel>();
        try {
            ResultSet _rs = employeeRegistrationEntity.selectAtendanaceEmployees();
            while (_rs.next()) {
                EmployeeMilkModel benefitTypeModel = new EmployeeMilkModel();
                benefitTypeModel.setBenefitID(_rs.getInt("ID"));
                benefitTypeModel.setEmpId(_rs.getString("EMP_ID"));
                benefitTypeModel.setAmount(_rs.getInt("AMOUNT"));
                benefitTypeModel.setType(_rs.getString("TYPE_OF_BENEFIT"));
                benefitTypeModel.setRemark(_rs.getString("REMARK"));
                benefitTypeModel.setDatabasStatus("Old");
                benefitTypeModel.setAmountInCash(0);
                DefaultSelectedData defaultSelectedData = new DefaultSelectedData();
                defaultSelectedData.setSelectedItem(_rs.getString("TYPE_OF_BENEFIT"));
                benefitTypeModel.setSelectedtype(defaultSelectedData);
                benefitTypes.add(benefitTypeModel);
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean saveBenefitTypes(ArrayList<EmployeeMilkModel> benefitLists) {
        ArrayList<EmployeeMilkModel> toBeInserted = new ArrayList<EmployeeMilkModel>();
        ArrayList<EmployeeMilkModel> toBeDeleted = new ArrayList<EmployeeMilkModel>();
        ArrayList<EmployeeMilkModel> toBeUpdated = new ArrayList<EmployeeMilkModel>();

        for (EmployeeMilkModel currentBenefit : benefitLists) {
            if (currentBenefit.getDatabasStatus().equals("New")) {
                toBeInserted.add(currentBenefit);
            } else if (currentBenefit.getDatabasStatus().equals("Deleted")) {
                toBeDeleted.add(currentBenefit);
            } else if (currentBenefit.getDatabasStatus().equals("Edited")) {
                toBeUpdated.add(currentBenefit);
            }
        }
        try {
            if (toBeInserted.size() > 0) {
                employeeRegistrationEntity.insertBenefitTypes(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {

                employeeRegistrationEntity.deleteBenefitTypes(toBeDeleted);

            }
            if (toBeUpdated.size() > 0) {

                employeeRegistrationEntity.updateBenefitTypes(toBeUpdated);

            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    private void isNull() {
        if (employeeRegistrationEntity == null) {
            employeeRegistrationEntity = new EmployeeRegistrationEntity();
        }
    }

    public ArrayList<HashMap> listOFEmployee(String deprtmentId) {
        isNull();
        return employeeRegistrationEntity.listOFEmployee(deprtmentId);
    }

    public ArrayList<HashMap> listOFRegisteredEmployee(String deprtmentId) {
        isNull();
        return employeeRegistrationEntity.listOFRegisteredEmployee(deprtmentId);
    }
}
