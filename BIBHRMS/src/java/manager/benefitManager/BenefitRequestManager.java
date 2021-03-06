/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.benefitManager;

import com.sun.webui.jsf.model.Option;
import entity.benefitEntity.BenefitRequestApproveEntity;
import entity.benefitEntity.BenefitRequestEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import entity.employeeEntity.EmployeeEntity;
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class BenefitRequestManager {

    BenefitRequestEntity benefitRequestEntity = new BenefitRequestEntity();
    BenefitRequestApproveEntity terminationApproveEntity = new BenefitRequestApproveEntity();
    BenefitREquestApproveManager terminationApproveManager = new BenefitREquestApproveManager();
    EmployeeMilkModel subSidiyRequestModel = new EmployeeMilkModel();
    EmployeeEntity employeeEntity = new EmployeeEntity();
    String userName;//logged in employee user name, initialized when a user logges in
    String department;//logged in employee department,  initialized when a user logges in
    String loggedinEmployeeId;
    public static final String REQUERSTER_TYPE_IMMEDIATEBOSS = "IB";
    public static final String REQUERSTER_TYPE_ANOTHEREMPLOYEE = "ME";
    String recorededDateAndTime;

    public boolean saveTerminationRequestInformation(String empId,
            String fullName, boolean rendered, String databaseStatus,
            String remark, int deptId, int attendance, float rate,
            int benefitID, float totalAmount, String startDate,
            String endDate, String appliedDate, String avilablity,
            String requestType, String requesterID, String description) {
        recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        subSidiyRequestModel = new EmployeeMilkModel(empId,
                fullName, rendered, databaseStatus, remark, deptId, attendance, rate, benefitID, totalAmount, startDate, endDate, appliedDate, avilablity, requestType, requesterID, BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY, userName, recorededDateAndTime, description);
        try {

            int x = benefitRequestEntity.insertTerminationRequest(subSidiyRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean saveempList(ArrayList<EmployeeMilkModel> employeeList, int deptId) {
        ArrayList<EmployeeMilkModel> Insereted = new ArrayList<EmployeeMilkModel>();
        // String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            for (EmployeeMilkModel employee : employeeList) {

                Insereted.add(employee);
            }
            benefitRequestEntity.insertCourseTakingList(Insereted, recorededDateAndTime, deptId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean UpdateRequestInformation(int requestID, String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, float rate, int benefitID, float totalAmount, String startDate, String endDate, String appliedDate, String avilablity, String requestType, String requesterID, String description) {
        recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        subSidiyRequestModel = new EmployeeMilkModel(requestID, empId, fullName, rendered, databaseStatus, remark, deptId, attendance, rate, benefitID, totalAmount, startDate, endDate, appliedDate, avilablity, requestType, requesterID, BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY, userName, description);
        try {

            int x = benefitRequestEntity.UpadateRequest(subSidiyRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean UpadteempList(ArrayList<EmployeeMilkModel> employeeList, int deptId) {
        ArrayList<EmployeeMilkModel> Insereted = new ArrayList<EmployeeMilkModel>();

        try {
            for (EmployeeMilkModel employee : employeeList) {

                Insereted.add(employee);
            }
            benefitRequestEntity.insertCourseTakingList(Insereted, recorededDateAndTime, deptId);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateTerminationRequestInformation(int subsidyId, String empId, String fullName, boolean rendered, String databaseStatus, String remark, int deptId, int attendance, int rate, int benefitID, float totalAmount, String startDate, String endDate, String appliedDate, String avilablity, String requestType, String requesterID, String description) {
        recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        subSidiyRequestModel = new EmployeeMilkModel(subsidyId, empId, fullName, rendered, databaseStatus, remark, deptId, attendance, rate, benefitID, totalAmount, startDate, endDate, appliedDate, avilablity, requestType, requesterID, BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY, userName, recorededDateAndTime, description);

        try {
            benefitRequestEntity.updateTerminationRequest(subSidiyRequestModel);
            return true;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deletePowerDeligationRequest(int subsidyId) {
        try {
            return benefitRequestEntity.deletePowerDeligationRequest(subsidyId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteempListRequest(ArrayList<EmployeeMilkModel> benefitLists, int deptId) {
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
                benefitRequestEntity.insertCourseTakingList(toBeInserted, recorededDateAndTime, deptId);
            }
            if (toBeDeleted.size() > 0) {
                benefitRequestEntity.deleteemplistRequest(toBeDeleted);

            }
            if (toBeUpdated.size() > 0) {
                benefitRequestEntity.updateBenefitTypes(toBeUpdated);
            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deleteAllempListRequest(String time, int deptID) {
        try {
            return benefitRequestEntity.deleteAllemplistRequest(time, deptID);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Option> getTerminationCatagories() {
        ArrayList<Option> requestLists = new ArrayList<Option>();
        if (requestLists.equals(null)) {
            requestLists.add(new Option(null, "--Select Request Type--"));
            return requestLists;
        } else {
            try {
                ResultSet _rs = benefitRequestEntity.selectcategoey();

                while (_rs.next()) {
                    requestLists.add(new Option(_rs.getInt("ID"), _rs.getString("REQUEST_TYPE")));
                }
                if (requestLists.size() == 0) {
                    requestLists.add(new Option(null, "NO Request Type"));
                } else {
                    requestLists.add(0, new Option(null, "--Select Request Type --"));
                }

                _rs.close();

                return requestLists;
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return null;
            }
        }
    }

    public String getselectDeptName(int institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = benefitRequestEntity.selectDeptName(institiId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("DEP_DESCRIPTION");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public String getTypeOFTeminationTypeOne(int institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = benefitRequestEntity.selectTerminationTypesOne(institiId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("TERMINATION_TYPE_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public EmployeeMilkModel getTerminationrequestInformation(int subsidyId) {
        subSidiyRequestModel = new EmployeeMilkModel();
        try {
            ResultSet _rs = benefitRequestEntity.selectTerminationRequestByRequestId(subsidyId);
            subSidiyRequestModel = new EmployeeMilkModel();
            if (_rs.next()) {

                subSidiyRequestModel.setRequestId(subsidyId);
                subSidiyRequestModel.setRequestType(_rs.getString("REQUET_TYPE"));
                subSidiyRequestModel.setStartDate(_rs.getString("START_DATE"));
                subSidiyRequestModel.setEndDate(_rs.getString("END_DATE"));
                // subSidiyRequestModel.setNumberOfDate(_rs.getString("TOTALAMOUNT"));
                subSidiyRequestModel.setRemark(_rs.getString("REMARK"));
                subSidiyRequestModel.setRequesterID(_rs.getString("REQUESTER_ID"));
                subSidiyRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
                subSidiyRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                subSidiyRequestModel.setUserName(_rs.getString("RECORDED_BY"));
                subSidiyRequestModel.setDatabasStatus("Old");

            } else {
                subSidiyRequestModel.setRequestId(-1);
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return subSidiyRequestModel;
    }

    /**
     * Auser can give decision on a request only if he/she is assigned to a role
     * which can make decision.
     */
    public ArrayList<SelectItem> getPendingTerminationRequests() {
        ResultSet _rs = null;
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            _rs = benefitRequestEntity.selectPendingTerminationRequests(loggedinEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("REQUEST_ID");

                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String time = _rs.getString("RECOREDED_DATE_TIME");
                    int dept_id = _rs.getInt("DEPT_ID");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + time + "--" + dept_id;
                    String OptionDesc = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<SelectItem> getHistorryTerminationRequests() {
        ResultSet _rs = null;
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            _rs = benefitRequestEntity.selectHistoryTerminationRequests(loggedinEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String time = _rs.getString("RECOREDED_DATE_TIME");
                    int dept_id = _rs.getInt("DEPT_ID");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + time + "--" + dept_id;
                    String OptionDesc = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    /**
     * Auser can give decision on a request only if he/she is assigned to a role
     * which can make decision.
     */
    public ArrayList<Option> getApprovableTerminationRequests() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {

            _rs = benefitRequestEntity.selectApprovableTerminationRequests(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
//                    String terminationCatagory = _rs.getString("TERMINATION_CATAGORY");
//                    String terminationType = _rs.getString("TERMINATION_TYPE");
//                    String requestStatus = _rs.getString("REQUEST_STATUS");
//                    String terminationDate = _rs.getString("TERMINATION_DATE");
//                    String description = _rs.getString("DESCRIPTION");
//                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + terminationCatagory + "--" + terminationType + "--" + requestStatus + "--" + appliedDate + "--" + terminationDate + "--" + description;
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId;
                    String OptionDesc = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    /**
     * Returns (1) the laterst request or  <br>
     *         (2)-1 if no requset mage by the employee
     * @param  employeeId  id of employee who requested termination
     */
    public int getEmplyeeLatestTerminationRequestId(String employeeId) {
        try {
            ResultSet _rs = benefitRequestEntity.selectEmployeeLatestTerminationRequest(employeeId);
            int termReqId = -1;
            if (_rs.next()) {
                termReqId = _rs.getInt("REQUEST_ID");
                //if no record foound max of "TERMINATION_REQUEST_ID" is assigned zero
                if (termReqId == 0) {
                    termReqId = -1;
                }
            }
            _rs.close();
            return termReqId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
    }

    public static class SubSidiyRequestModel implements Serializable {

        private int terminationRequestId;//@Column(name = "TERMINATION_REQUEST_ID")
        private String requesterId;// @Column(name = "REQUESTER_ID")
        private int terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
        private int terminationType;// @Column(name = "TERMINATION_TYPE")
        private String requestStatus;// @Column(name = "REQUEST_STATUS")
        private String appliedDate;//@Column(name = "APPLIED_DATE")
        private String terminationDate;//  @Column(name = "TERMINATION_DATE")
        private String description;// @Column(name = "DESCRIPTION")
        private String documeentReferenceNumber;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
        private String recordedBy;// @Column(name = "RECORDED_BY")
        private String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")
        private String requesterType;
        private String terminatorId;
        private double penalityPay;
        private String hasSuccesioser;
        private String Location;
        private String month;
        private String subSidyType;
        private double totalAmount;
        private int subsidyID;

        public SubSidiyRequestModel() {
        }

        public SubSidiyRequestModel(String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documeentReferenceNumber, String recordedBy, String recorededDateAndTime, String requesterType, String terminatorId, double penalityPay) {

            this.requesterId = requesterId;
            this.terminationCatagory = terminationCatagory;
            this.terminationType = terminationType;
            this.requestStatus = requestStatus;
            this.appliedDate = appliedDate;
            this.terminationDate = terminationDate;
            this.description = description;
            this.documeentReferenceNumber = documeentReferenceNumber;
            this.recordedBy = recordedBy;
            this.recorededDateAndTime = recorededDateAndTime;
            this.requesterType = requesterType;
            this.terminatorId = terminatorId;
            this.penalityPay = penalityPay;
        //this.hasSuccesioser=hasSuccesioser
        }

        public SubSidiyRequestModel(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documeentReferenceNumber, String recordedBy, String recorededDateAndTime, String requesterType, String terminatorId, double penalityPay) {
            this(requesterId, terminationCatagory, terminationType, requestStatus, appliedDate, terminationDate, description, documeentReferenceNumber, recordedBy, recorededDateAndTime, requesterType, terminatorId, penalityPay);
            this.terminationRequestId = terminationRequestId;
        }

        private SubSidiyRequestModel(String requesterId, String location, String month, String requestStatus, String description, String documentReferenceNumber, String userName, String recorededDateAndTime, double amountOfBirr, String appliedDate) {
            this.requesterId = requesterId;
            this.Location = location;
            this.month = month;
            this.requestStatus = requestStatus;
            this.description = description;
            this.documeentReferenceNumber = documentReferenceNumber;
            this.recordedBy = userName;
            this.recorededDateAndTime = recorededDateAndTime;
            this.totalAmount = amountOfBirr;
            this.appliedDate = appliedDate;
        }

        private SubSidiyRequestModel(int subsidyId, String requesterId, String location, String month, String requestStatus, String description, String documentReferenceNumber, String userName, String recorededDateAndTime, double amountOfBirr, String appliedDate) {
            this.subsidyID = subsidyId;
            this.requesterId = requesterId;
            this.Location = location;
            this.month = month;
            this.requestStatus = requestStatus;
            this.description = description;
            this.documeentReferenceNumber = documentReferenceNumber;
            this.recordedBy = userName;
            this.recorededDateAndTime = recorededDateAndTime;
            this.totalAmount = amountOfBirr;
            this.appliedDate = appliedDate;
        }

        private SubSidiyRequestModel(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String requesterType, String terminator, double penalityPay, String requestStatus, String recorededDateAndTime, String userName, String hasSuccesioser) {
            this.terminationRequestId = terminationRequestId;
            this.requesterId = requesterId;
            this.terminationCatagory = terminationCatagory;
            this.terminationType = terminationType;
            this.requestStatus = requestStatus;
            this.appliedDate = appliedDate;
            this.terminationDate = terminationDate;
            this.description = description;
            this.documeentReferenceNumber = documentReferenceNumber;
            this.recordedBy = userName;
            this.requesterType = requesterType;
            this.terminatorId = terminator;
            this.penalityPay = penalityPay;
            this.requestStatus = requestStatus;
            this.recorededDateAndTime = recorededDateAndTime;
            this.hasSuccesioser = hasSuccesioser;
        }

        private SubSidiyRequestModel(String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String userName, String recorededDateAndTime, String requesterType, String terminatorId) {
            this.requesterId = requesterId;
            this.terminationCatagory = terminationCatagory;
            this.terminationType = terminationType;
            this.requestStatus = requestStatus;
            this.appliedDate = appliedDate;
            this.terminationDate = terminationDate;
            this.description = description;
            this.documeentReferenceNumber = documentReferenceNumber;
            this.recordedBy = userName;
            this.recorededDateAndTime = recorededDateAndTime;
            this.requesterType = requesterType;
            this.terminatorId = terminatorId;
//            this.penalityPay = penalityPay;
//            this.hasSuccesioser = hasSuccesioser;
        }

        public String getLocation() {
            return Location;
        }

        public void setLocation(String Location) {
            this.Location = Location;
        }

        public String getMonth() {
            return month;
        }

        public void setMonth(String month) {
            this.month = month;
        }

        public String getSubSidyType() {
            return subSidyType;
        }

        public void setSubSidyType(String subSidyType) {
            this.subSidyType = subSidyType;
        }

        public int getSubsidyID() {
            return subsidyID;
        }

        public void setSubsidyID(int subsidyID) {
            this.subsidyID = subsidyID;
        }

        public double getTotalAmount() {
            return totalAmount;
        }

        public void setTotalAmount(double totalAmount) {
            this.totalAmount = totalAmount;
        }

//
        public String getAppliedDate() {
            return appliedDate;
        }

        public void setAppliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRequesterType() {
            return requesterType;
        }

        public void setRequesterType(String requesterType) {
            this.requesterType = requesterType;
        }

        public String getTerminatorId() {
            return terminatorId;
        }

        public double getPenalityPay() {
            return penalityPay;
        }

        public void setPenalityPay(double penalityPay) {
            this.penalityPay = penalityPay;
        }

        public void setTerminatorId(String terminatorId) {
            this.terminatorId = terminatorId;
        }

        public String getDocumeentReferenceNumber() {
            return documeentReferenceNumber;
        }

        public void setDocumeentReferenceNumber(String documeentReferenceNumber) {
            this.documeentReferenceNumber = documeentReferenceNumber;
        }

        public String getHasSuccesioser() {
            return hasSuccesioser;
        }

        public void setHasSuccesioser(String hasSuccesioser) {
            this.hasSuccesioser = hasSuccesioser;
        }

        public String getRecordedBy() {
            return recordedBy;
        }

        public void setRecordedBy(String recordedBy) {
            this.recordedBy = recordedBy;
        }

        public String getRecorededDateAndTime() {
            return recorededDateAndTime;
        }

        public void setRecorededDateAndTime(String recorededDateAndTime) {
            this.recorededDateAndTime = recorededDateAndTime;
        }

        public String getRequestStatus() {
            return requestStatus;
        }

        public void setRequestStatus(String requestStatus) {
            this.requestStatus = requestStatus;
        }

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

        public int getTerminationCatagory() {
            return terminationCatagory;
        }

        public void setTerminationCatagory(int terminationCatagory) {
            this.terminationCatagory = terminationCatagory;
        }

        public int getTerminationType() {
            return terminationType;
        }

        public void setTerminationType(int terminationType) {
            this.terminationType = terminationType;
        }

        public String getTerminationDate() {
            return terminationDate;
        }

        public void setTerminationDate(String terminationDate) {
            this.terminationDate = terminationDate;
        }

        public int getTerminationRequestId() {
            return terminationRequestId;
        }

        public void setTerminationRequestId(int terminationRequestId) {
            this.terminationRequestId = terminationRequestId;
        }
    }

    public String getLoggedinEmployeeId() {
        return loggedinEmployeeId;
    }

    public void setLoggedinEmployeeId(String loggedinEmployeeId) {
        this.loggedinEmployeeId = loggedinEmployeeId;
    }

    public HashMap readEmployeeBasicInfo(String employeeId) {
        try {
            return employeeEntity.readEmployeeBasicInfoFrom(employeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getEmployeeStatus(String empId) {
        String typeOFAccredated = null;
        try {
            ResultSet _rs = benefitRequestEntity.selectEmployeeStatu(empId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("EMP_STATUS");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return typeOFAccredated;
    }

    private void isNull() {
        if (benefitRequestEntity == null) {
            benefitRequestEntity = new BenefitRequestEntity();
        }
    }

    public ArrayList<HashMap> listOFEmployee(String deprtmentId, String startDate, String endDate) {
        isNull();
        return benefitRequestEntity.listOFEmployee(deprtmentId, startDate, endDate);
    }

    public ArrayList<HashMap> listOFRegisteredEmployee(String deprtmentId, String startDate, String endDate) {
        isNull();
        return benefitRequestEntity.listOFRegisteredEmployee(deprtmentId, startDate, endDate);
    }

    public String readMilkRate() {
        try {
            return benefitRequestEntity.readMilkRate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
public String readSepecialBenefitRate() {
        try {
            return benefitRequestEntity.readSepecialRequestRate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public String readSubsidyRate() {
        try {
            return benefitRequestEntity.readSubsidyRate();
        } catch (Exception ex) {
            ex.printStackTrace();
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
                benefitRequestEntity.insertBenefitTypes(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {

                benefitRequestEntity.deleteBenefitTypes(toBeDeleted);

            }
            if (toBeUpdated.size() > 0) {

                benefitRequestEntity.updateBenefitTypes(toBeUpdated);

            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<HashMap> getTableInfo(int departmentID, String date) {
        try {
            ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = benefitRequestEntity.readAllTableInfo(departmentID, date);
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("EMP_ID", ocrs.getString("EMP_ID"));
                resultInfo.put("ATTENDANCE", ocrs.getString("ATTENDANCE"));
                resultInfo.put("RATE", ocrs.getString("RATE"));
                resultInfo.put("TOTAL_AMOUNT", ocrs.getString("TOTAL_AMOUNT"));
                resultInfo.put("LIST_ID", ocrs.getString("LIST_ID"));
                resultInfo.put("DEPT_ID", ocrs.getString("DEPT_ID"));
                resultInfo.put("APPLIDE_TIME", ocrs.getString("APPLIDE_TIME"));

                IntSuccLists.add(resultInfo);
            }
            return IntSuccLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }

    public ArrayList<HashMap> loadSubsidyPaymentForReport() {


        try {

            if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
                return benefitRequestEntity.loadSubsidyPaymentForReport(ReportCriteraManager.getParametrsForDay());
            }
            else{
            return null;
            }
        } catch (Exception ex) {
            return null;
        }

    }

    public ArrayList<HashMap> loadMilkPaymentForReport(String startDate, String endDate) {


        try {
           
                return benefitRequestEntity.loadMilkPaymentForReport(startDate, endDate);
            
            
        } catch (Exception ex) {
            return null;
        }

    }
}
