/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import com.sun.webui.jsf.model.Option;
import entity.terminationEntity.TerminationApproveEntity;
import entity.terminationEntity.TerminationRequestEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import entity.employeeEntity.EmployeeEntity;

/**
 *
 * @author mekete
 */
public class TerminationRequestManager {

    TerminationRequestEntity terminationRequestEntity = new TerminationRequestEntity();
    TerminationApproveEntity terminationApproveEntity = new TerminationApproveEntity();
    TerminationApproveManager terminationApproveManager = new TerminationApproveManager();
    TerminationRequestModel terminationRequestModel = new TerminationRequestModel();
    EmployeeEntity employeeEntity = new EmployeeEntity();
    String userName;//logged in employee user name, initialized when a user logges in
    String department;//logged in employee department,  initialized when a user logges in
    String loggedinEmployeeId;
    public static final String REQUERSTER_TYPE_IMMEDIATEBOSS = "IB";
    public static final String REQUERSTER_TYPE_ANOTHEREMPLOYEE = "ME";

    public boolean saveTerminationRequestInformation(String requesterId, int terminationCatagory, int terminationType, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String requesterType, String terminatorId) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        terminationRequestModel = new TerminationRequestModel(requesterId, terminationCatagory, terminationType, TerminationApproveManager.INITIAL_STATE_TERMINATION, appliedDate, terminationDate, description, documentReferenceNumber, userName, recorededDateAndTime, requesterType, terminatorId);
        try {
            int x = terminationRequestEntity.insertTerminationRequest(terminationRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateTerminationRequestInformation(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String requesterType, String terminator, double penalityPay,String hasSuccesioser) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        terminationRequestModel = new TerminationRequestModel(terminationRequestId, requesterId, terminationCatagory, terminationType, appliedDate, terminationDate, description, documentReferenceNumber, requesterType, terminator, penalityPay, terminationApproveManager.INITIAL_STATE_TERMINATION, recorededDateAndTime, userName,hasSuccesioser);

        try {
            terminationRequestEntity.updateTerminationRequest(terminationRequestModel);
            return true;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deletePowerDeligationRequest(int terminationRequestId) {
        try {
            return terminationRequestEntity.deletePowerDeligationRequest(terminationRequestId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<Option> getTerminationCatagories() {
        ArrayList<Option> requestLists = new ArrayList<Option>();
        if (requestLists.equals(null)) {
            requestLists.add(new Option(null, "--Select Termination Category--"));
            return requestLists;
        } else {
        try {
            ResultSet _rs = terminationRequestEntity.selectcategoey();

            while (_rs.next()) {
                requestLists.add(new Option(_rs.getInt("ID"), _rs.getString("CATEGORY_NAME")));
            }
            if (requestLists.size() == 0) {
                requestLists.add(new Option(null, "NO TERMINATION CATEGORY"));
            } else {
                requestLists.add(0, new Option(null, "--Select Termination Category--"));
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

    public ArrayList<Option> getTerminationTypes(int terminationCatagory) {

        ArrayList<Option> terminationCatagories = new ArrayList<Option>();
        if (terminationCatagory == 0) {
            terminationCatagories.add(new Option(null, "Select Catagory First"));
            return terminationCatagories;
        } else {

            try {
                ResultSet _rs = terminationRequestEntity.selectTerminationTypes(terminationCatagory);
                while (_rs.next()) {
                    terminationCatagories.add(new Option(_rs.getInt("TERMINATION_TYPE_ID"), _rs.getString("TERMINATION_TYPE_NAME")));
                }
                if (terminationCatagories.size() == 0) {
                    terminationCatagories.add(new Option(null, "NO TERMINATION TYPE"));
                } else {
                    terminationCatagories.add(0, new Option(null, "SELECT TERMINATION TYPE"));
                }
                _rs.close();
                return terminationCatagories;
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return null;
            }
        }
    }

    public String getTypeOFTeminationType(int institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = terminationRequestEntity.selectTerminationTypes(institiId);
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
public String getTypeOFTeminationTypeOne(int institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = terminationRequestEntity.selectTerminationTypesOne(institiId);
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

    public TerminationRequestModel getTerminationrequestInformation(int terminationRequestId) {
        terminationRequestModel = new TerminationRequestModel();
        try {
            ResultSet _rs = terminationRequestEntity.selectTerminationRequestByRequestId(terminationRequestId);
            terminationRequestModel = new TerminationRequestModel();
            if (_rs.next()) {

                terminationRequestModel.setTerminationRequestId(terminationRequestId);
                terminationRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                terminationRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                terminationRequestModel.setTerminationCatagory(_rs.getInt("TERMINATION_CATAGORY"));
                terminationRequestModel.setTerminationType(_rs.getInt("TERMINATION_TYPE"));
                terminationRequestModel.setRequestStatus(_rs.getString("REQUEST_STATUS"));
                terminationRequestModel.setTerminationDate(_rs.getString("TERMINATION_DATE"));
                terminationRequestModel.setDescription(_rs.getString("DESCRIPTION"));
                terminationRequestModel.setRequesterType(_rs.getString("REQUESTER_TYPE"));
                terminationRequestModel.setDocumeentReferenceNumber(_rs.getString("IS_DOCUMEENT_ATTACHED"));
                terminationRequestModel.setPenalityPay(_rs.getDouble("PENALITY_PAYMENT"));
                terminationRequestModel.setHasSuccesioser(_rs.getString("HAS_ASUCCESIOR"));
            } else {
                terminationRequestModel.setTerminationRequestId(-1);
            }
            _rs.close();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return terminationRequestModel;
    }

    /**
     * Auser can give decision on a request only if he/she is assigned to a role
     * which can make decision.
     */
    public ArrayList<SelectItem> getPendingTerminationRequests() {
        ResultSet _rs = null;
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            _rs = terminationRequestEntity.selectPendingTerminationRequests(loggedinEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String terminatorID = _rs.getString("TREMINATOR_ID");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + terminatorID;
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
            _rs = terminationRequestEntity.selectHistoryTerminationRequests(loggedinEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("REQUEST_STATUS");
                    String terminatorID = _rs.getString("TREMINATOR_ID");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + appliedDate + "--" + status + "--" + terminatorID;
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

            _rs = terminationRequestEntity.selectApprovableTerminationRequests(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("TERMINATION_REQUEST_ID");
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
            ResultSet _rs = terminationRequestEntity.selectEmployeeLatestTerminationRequest(employeeId);
            int termReqId = -1;
            if (_rs.next()) {
                termReqId = _rs.getInt("TERMINATION_REQUEST_ID");
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

    public static class TerminationRequestModel implements Serializable {

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

        public TerminationRequestModel() {
        }

        public TerminationRequestModel(String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documeentReferenceNumber, String recordedBy, String recorededDateAndTime, String requesterType, String terminatorId, double penalityPay) {

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

        public TerminationRequestModel(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documeentReferenceNumber, String recordedBy, String recorededDateAndTime, String requesterType, String terminatorId, double penalityPay) {
            this(requesterId, terminationCatagory, terminationType, requestStatus, appliedDate, terminationDate, description, documeentReferenceNumber, recordedBy, recorededDateAndTime, requesterType, terminatorId, penalityPay);
            this.terminationRequestId = terminationRequestId;
        }

        private TerminationRequestModel(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String requesterType, String terminator, double penalityPay, String requestStatus, String recorededDateAndTime, String userName,String hasSuccesioser) {
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
            this.hasSuccesioser=hasSuccesioser;
        }

        private TerminationRequestModel(String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documentReferenceNumber, String userName, String recorededDateAndTime, String requesterType, String terminatorId) {
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

//        private TerminationRequestModel(int terminationRequestId, String requesterId, int terminationCatagory, int terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String documeentAttached, String requestType, String userName, String recorededDateAndTime,  String terminatorId, double penalityPay) {
//            this.terminationRequestId=terminationRequestId;
//            this.requesterId=requesterId;
//            this.terminationCatagory=terminationCatagory;
//            this.terminationType=terminationType;
//             this.requestStatus = requestStatus;
//            this.appliedDate = appliedDate;
//            this.terminationDate = terminationDate;
//            this.description = description;
//            this.documeentReferenceNumber = documeentAttached;
//            this.recordedBy = userName;
//            this.recorededDateAndTime = recorededDateAndTime;
//            this.requesterType=requestType;
//            this.terminatorId=terminatorId;
//            this.penalityPay=penalityPay;
//        }
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
            ResultSet _rs = terminationRequestEntity.selectEmployeeStatu(empId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("EMP_STATUS");

            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return typeOFAccredated;
    }
}
