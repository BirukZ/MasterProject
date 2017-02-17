/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.overTimeManager;

import entity.overTimeEntity.OverTimeRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class OverTimeRequestManager {

    OverTimeRequestEntity overTimeRequestEntity = new OverTimeRequestEntity();
    OverTimeRequestModel overTimeRequestAttributes = new OverTimeRequestModel();
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;
//===========================================================================================
    public static final String DATABASE_STATUS_NEW = "New";
    public static final String DATABASE_STATUS_OLD = "Old";
    public static final String DATABASE_STATUS_OLDEDITED = "Edited";
    public static final String DATABASE_STATUS_OLDDELETED = "Deleted";
    public static final String HOLIDAY = "HOLIDAY";
    public static final String SUNDAY = "SUNDAY";
    public static final String SATURDAY = "SATURDAY";
    public static final String NORMAL = "NORMAL";
    //===========================================================================================

    public ArrayList<SelectItem> getOverTimeFactor() {
        ArrayList<SelectItem> overTimeFactorList = new ArrayList<SelectItem>();
        overTimeFactorList.add(new SelectItem("-1", "--SELECT--"));
        overTimeFactorList.add(new SelectItem("1.25", "1.25 (25% Added)"));
        overTimeFactorList.add(new SelectItem("1.50", "1.50 (50% Added)"));
        overTimeFactorList.add(new SelectItem("2.00", "2.00 (100% Added)"));
        overTimeFactorList.add(new SelectItem("2.50", "2.50 (150% Added)"));
        overTimeFactorList.add(new SelectItem("3.00", "3.00 (200% Added)"));
        return overTimeFactorList;
    }

//    public boolean saveOrUpdateOverTimeRequest(int oveTimeRequestId, String requesterId, String appliedDate, String reason, String addressCode, double overTimeFactor, String docReferenceNumber, ArrayList<OverTimeRequestModel> requestModelList) {
//        if (oveTimeRequestId == -1) {
//            return saveOverTimeRequest(requesterId, appliedDate, reason, addressCode, overTimeFactor, docReferenceNumber, requestModelList);
//        } else {
//            return updateOverTimeRequest(oveTimeRequestId, requesterId, appliedDate, reason, addressCode, overTimeFactor, docReferenceNumber, requestModelList);
//        }
//    }
    public boolean saveOverTimeRequest(String requesterId, String appliedDate, int reasonSummary, String reason, String addressCode, double overTimeFactor, String docReferenceNumber, ArrayList<OverTimeRequestModel> requestModelList, String loggedInEmployeeId) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();

        overTimeRequestAttributes = new OverTimeRequestModel(
                requesterId,
                appliedDate,
                reasonSummary,
                reason,
                addressCode,
                overTimeFactor,
                docReferenceNumber,
                OverTimeApproveManager.INITIAL_STATE_OVERTIME,
                recorededDateAndTime, userName);
        try {
            overTimeRequestEntity.insertOverTimeRequest(overTimeRequestAttributes, requestModelList, loggedInEmployeeId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateOverTimeRequest(int overTimeRequestId, String requesterId, String appliedDate, String reason, String addressCode, double overTimeFactor, String docReferenceNumber, ArrayList<OverTimeRequestModel> requestModelList) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        overTimeRequestAttributes = new OverTimeRequestModel(requesterId, appliedDate, reason, addressCode, overTimeFactor, docReferenceNumber, OverTimeApproveManager.INITIAL_STATE_OVERTIME, recorededDateAndTime, userName);
        ArrayList<OverTimeRequestModel> toBeInserted = new ArrayList<OverTimeRequestModel>();
        ArrayList<OverTimeRequestModel> toBeUpdated = new ArrayList<OverTimeRequestModel>();
        ArrayList<OverTimeRequestModel> toBeDeleted = new ArrayList<OverTimeRequestModel>();
        for (OverTimeRequestModel currentModel : requestModelList) {
            if (currentModel.getDatabaseStatus().equals(DATABASE_STATUS_NEW)) {
                toBeInserted.add(currentModel);
            } else if (currentModel.getDatabaseStatus().equals(DATABASE_STATUS_OLDEDITED)) {
                toBeUpdated.add(currentModel);
            } else if (currentModel.getDatabaseStatus().equals(DATABASE_STATUS_OLDDELETED)) {
                toBeDeleted.add(currentModel);
            }
        }
        overTimeRequestAttributes = new OverTimeRequestModel(overTimeRequestId, requesterId, appliedDate, reason, addressCode, overTimeFactor, docReferenceNumber, OverTimeApproveManager.INITIAL_STATE_OVERTIME, recorededDateAndTime, userName);

        try {
            overTimeRequestEntity.updateOverTimeRequestAttributes(overTimeRequestAttributes);
            overTimeRequestEntity.insertOverTimeRequestAttendants(overTimeRequestId, toBeInserted);
            overTimeRequestEntity.updateOverTimeRequestAttendants(toBeUpdated);
            overTimeRequestEntity.deleteOverTimeRequestAttendants(toBeDeleted);

        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<OverTimeRequestModel> getEmployeeAndOverTimeList(int overTimeRequestId) {
        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectEmployeeAndOverTimeList(overTimeRequestId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setOverTimeEmployeeId(_rs.getInt("OVER_TIME_EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setDepartmentName(_rs.getString("DEPARTMENT_NAME"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                // overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(_rs.getString("STATUS").equals("NO") ? false : true);
                overTimeRequestAttributes.setDatabaseStatus(DATABASE_STATUS_OLD);
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<OverTimeRequestModel> getOverTimeReport(String requesterId, String participantId, String addressCode, String statusList,
            String startDate, String startTime, String endDate, String endTime, double overTimeFactor) {

        String statusResultSets = AuthorizationManager.getProcessStates(statusList, AuthorizationManager.PROCESS_OVERTIME);
        //status.replaceFirst("'103'", "103'");

        overTimeRequestAttributes = new OverTimeRequestModel(requesterId, participantId, addressCode, statusResultSets,
                startDate, startTime, endDate, endTime, overTimeFactor);
        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectRequestsReport(overTimeRequestAttributes);
            int counter = 0;
            int overTimeEmplyeeId = 0;
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setOverTimeEmployeeId(_rs.getInt("OVER_TIME_EMPLOYEE_ID"));
                if (!(overTimeEmplyeeId == overTimeRequestAttributes.getOverTimeEmployeeId())) {//remove duplicates
                    overTimeEmplyeeId = overTimeRequestAttributes.getOverTimeEmployeeId();
                    overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                    overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    overTimeRequestAttributes.setDepartmentName(_rs.getString("DEPARTMENT_NAME"));
                    overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                    overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                    overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                    overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                    overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                    overTimeRequestAttributes.setSelected(_rs.getString("STATUS").equals("NO") ? false : true);
                    overTimeRequestAttributes.setDatabaseStatus(Integer.toString(++counter));
                    requestLists.add(overTimeRequestAttributes);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyRequestsHistory() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectMyRequestsHistory(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE") + " - " + _rs.getString("STATUS"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyRequestsHistory(int requestId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectMyRequestsHistory(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getOverTimeReasonsList() {
        ArrayList<SelectItem> reasonLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectAllOverTimeReasons();
            while (_rs.next()) {
                SelectItem currentReason = new SelectItem(_rs.getString("REASON_ID"), _rs.getString("REASON_NAME"));
                reasonLists.add(currentReason);
            }
            reasonLists.add(0, new SelectItem("-1", "--SELECT REASON--"));
            _rs.close();
            return reasonLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getPendingRequests() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeRequestEntity.selectPendingRequests(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> getTableHour() {
        ArrayList<HashMap> currentTimeList = new ArrayList<HashMap>();
        for (int hour = 0; hour < 24; hour++) {
            String displayedHour;
            if (hour < 10) {
                displayedHour = "0" + Integer.toString(hour);
            } else {
                displayedHour = Integer.toString(hour);
            }
            HashMap currentTime = new HashMap();
            for (int minute = 0; minute < 60; minute += 10) {
                String displayedMinute;
                if (minute < 10) {
                    displayedMinute = "0" + Integer.toString(minute);
                } else {
                    displayedMinute = Integer.toString(minute);
                }
                String columnId = "col" + displayedMinute;

                String displayedTime = displayedHour + ":" + displayedMinute;
                currentTime.put(columnId, displayedTime);
            }
            currentTimeList.add(currentTime);
        }
        return currentTimeList;
    }

    public OverTimeRequestModel getRequestAttributes(int overTimeRequestId) {
        overTimeRequestAttributes = new OverTimeRequestModel();
        try {
            ResultSet _rs = overTimeRequestEntity.selectRequestAttributes(overTimeRequestId);
            if (_rs.next()) {
                overTimeRequestAttributes.setOverTimeRequestId(_rs.getInt("OVER_TIME_REQUEST_ID"));
                overTimeRequestAttributes.setAppliedDate(_rs.getString("APPLIED_DATE"));
                overTimeRequestAttributes.setReasonDescription(_rs.getString("REASON"));
                overTimeRequestAttributes.setAddressCode(_rs.getString("ADDRESS_CODE"));
                overTimeRequestAttributes.setDocReferenceNumber(_rs.getString("DOC_REFERENCE_NUMBER"));
                overTimeRequestAttributes.setReasonSummary(_rs.getInt("REASON_SUMMARY"));
                overTimeRequestAttributes.setOtRequestUserName(_rs.getString("user_name"));

            } else {
                overTimeRequestAttributes.setOverTimeRequestId(-1);
            }
            return overTimeRequestAttributes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public double hourToDecimal(String hour) {
        return Double.parseDouble(hour.split(":")[0]) + (Double.parseDouble(hour.split(":")[1]) * (100 / 60));
    }

    /**
     * <br> if hourOne = hourTwo return 0
     * <br> if hourOne is before hourTwo return 1
     * <br> if hourOne is after hourTwo return -1
     */
    public int compareTimes(String hourOne, String hourTwo) {
        try {
            if (hourToDecimal(hourOne) == hourToDecimal(hourTwo)) {
                return 0;
            } else if (hourToDecimal(hourOne) < hourToDecimal(hourTwo)) {
                return 1;
            } else if (hourToDecimal(hourOne) > hourToDecimal(hourTwo)) {
                return -1;
            }
        } catch (Exception ex) {
        }
        return -100;
    }

    public String getLoginId(int overTimeRequestId) {
        String LoginId = null;
        try {
            ResultSet _rs = overTimeRequestEntity.selectLoginId(overTimeRequestId);
            while (_rs.next()) {
                LoginId = _rs.getString("LOGIN_PERSON_ID");



            }
            _rs.close();
            return LoginId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static void main(String arg[]) {
        OverTimeRequestManager obj = new OverTimeRequestManager();
        obj.compareTimes("", "");

    }
    // <editor-fold defaultstate="collapsed" desc="OverTimeRequestModel">

    public static class OverTimeRequestModel {

        int overTimeRequestId;//       OVER_TIME_REQUEST_ID
        int overTimeEmployeeId; //OVER_TIME_EMPLOYEE_ID
        String requesterId;//REQUESTER_ID
        String startDate;//START_DATE
        String startTime;//START_TIME
        String attendanceDate;//ATTENDANCE_TIME
        String endDate;//END_DATE
        String endTime;//END_TIME
        String appliedDate;//APPLIED_DATE
        String addressCode;//ADDRESS_CODE
        double overTimeFactor;//OVER_TIME_PERIOD
        String displayedOverTimeFactor;//OVER_TIME_PERIOD
        int numberOfEmployee;//NUMBER_OF_EMPLOYEE
        String reasonDescription;//REASON
        int reasonSummary;//REASON
        String status;//STATUS
        String timeStamp;//TIME_STAMP
        String userName;//USER_NAME
        String participantId;//from OVER_TIME_EMPLOYEE table
        String employeeFullName;//
        String departmentId;
        String departmentPath;//
        String departmentName;//
        String docReferenceNumber;//
        String databaseStatus;
        boolean selected;
        String dayType;
        private String otRequestUserName;

        public String getOtRequestUserName() {
            return otRequestUserName;
        }

        public void setOtRequestUserName(String otRequestUserName) {
            this.otRequestUserName = otRequestUserName;
        }

        public OverTimeRequestModel() {
        }

        public OverTimeRequestModel(String requesterId, String appliedDate, String reason, String addressCode, double overTimeFactor, String docReferenceNumber, String status, String timeStamp, String userName) {
            this.requesterId = requesterId;
            this.appliedDate = appliedDate;
            this.reasonDescription = reason;
            this.addressCode = addressCode;
            this.overTimeFactor = overTimeFactor;
            this.docReferenceNumber = docReferenceNumber;
            this.status = status;
            this.timeStamp = timeStamp;
            this.userName = userName;
        }

        public OverTimeRequestModel(String requesterId,
                String appliedDate,
                int reasonSummary,
                String reasonDescription,
                String addressCode, double overTimeFactor, String docReferenceNumber, String status, String timeStamp, String userName) {
            this(requesterId, appliedDate, reasonDescription, addressCode, overTimeFactor, docReferenceNumber, status, timeStamp, userName);
            this.reasonSummary = reasonSummary;
        }

        public OverTimeRequestModel(String requesterId, String participantId, String addressCode, String status,
                String startDate, String startTime, String endDate, String endTime, double overTimeFactor) {
            this.requesterId = requesterId;
            this.participantId = participantId;
            this.startDate = startDate;
            this.startTime = startTime;
            this.endDate = endDate;
            this.endTime = endTime;
            this.addressCode = addressCode;
            this.overTimeFactor = overTimeFactor;
            this.status = status;
        }

        public OverTimeRequestModel(int overTimeRequestId, String requesterId, String appliedDate, String reason, String addressCode, double overTimeFactor, String docReferenceNumber, String status, String timeStamp, String userName) {
            this(requesterId, appliedDate, reason, addressCode, overTimeFactor, docReferenceNumber, status, timeStamp, userName);
            this.overTimeRequestId = overTimeRequestId;
        }

        public OverTimeRequestModel(String employeeId, String employeeFullName, String departmentName, double overTimeFactor, String startDate, String startTime, String endDate, String endTime, boolean selected) {
            this(employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime);
            this.overTimeFactor = overTimeFactor;
            this.selected = selected;
        }

        public OverTimeRequestModel(int overTimeRequestId, String employeeId, String employeeFullName, String departmentName, double overTimeFactor, String startDate, String startTime, String endDate, String endTime, boolean selected) {
        }

        public OverTimeRequestModel(String employeeId, String employeeFullName, String departmentName, String startDate, String startTime, String endDate, String endTime) {
            this.participantId = employeeId;
            this.employeeFullName = employeeFullName;
            this.departmentName = departmentName;
            this.startDate = startDate;
            this.startTime = startTime;
            this.endDate = endDate;
            this.endTime = endTime;
        }

        public OverTimeRequestModel(String employeeId, String employeeFullName, String departmentName, String startDate, String startTime, String endDate, String endTime, double overTimeFactor) {
            this(employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime);
            this.overTimeFactor = overTimeFactor;
        }

        public OverTimeRequestModel(String employeeId, String employeeFullName, String departmentName, String startDate, String startTime, String endDate, String endTime, double overTimeFactor, String databaseStatus) {
            this(employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime, overTimeFactor);
            this.databaseStatus = databaseStatus;
        }

        public OverTimeRequestModel(String employeeId,
                String employeeFullName,
                String departmentName,
                String startDate,
                String startTime,
                String endDate,
                String endTime,
                double overTimeFactor,
                String dayType,
                String databaseStatus) {
            this(employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime, overTimeFactor);
            this.dayType = dayType;
            this.databaseStatus = databaseStatus;
        }

        public OverTimeRequestModel(String requesterId, String reason, String employeeId, String employeeFullName, String departmentName, String startDate, String startTime, String endDate, String endTime) {
            this(employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime);
            this.requesterId = requesterId;
            this.reasonDescription = reason;
        }

        public OverTimeRequestModel(int overTimeRequestId, String requesterId, String reason, String employeeId, String employeeFullName, String departmentName, String startDate, String startTime, String endDate, String endTime) {
            this(requesterId, reason, employeeId, employeeFullName, departmentName, startDate, startTime, endDate, endTime);
            this.overTimeRequestId = overTimeRequestId;
        }

        public String getDayTipe() {
            return dayType;
        }

        public void setDayTipe(String dayTipe) {
            this.dayType = dayTipe;
        }

        public String getAddressCode() {
            return addressCode;
        }

        public String getDatabaseStatus() {
            return databaseStatus;
        }

        public void setDatabaseStatus(String databaseStatus) {
            this.databaseStatus = databaseStatus;
        }

        public void setAddressCode(String addressCode) {
            this.addressCode = addressCode;
        }

        public String getAppliedDate() {
            return appliedDate;
        }

        public String getDocReferenceNumber() {
            return docReferenceNumber;
        }

        public String getDisplayedOverTimeFactor() {
            return displayedOverTimeFactor;
        }

        public void setDisplayedOverTimeFactor(String displayedOverTimeFactor) {
            this.displayedOverTimeFactor = displayedOverTimeFactor;
        }

        public int getOverTimeRequestId() {
            return overTimeRequestId;
        }

        public String getAttendanceDate() {
            return attendanceDate;
        }

        public void setAttendanceDate(String attendanceDate) {
            this.attendanceDate = attendanceDate;
        }

        public void setOverTimeRequestId(int overTimeRequestId) {
            this.overTimeRequestId = overTimeRequestId;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public void setDocReferenceNumber(String docReferenceNumber) {
            this.docReferenceNumber = docReferenceNumber;
        }

        public void setAppliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
        }

        public String getEmployeeId() {
            return participantId;
        }

        public int getOverTimeEmployeeId() {
            return overTimeEmployeeId;
        }

        public void setOverTimeEmployeeId(int overTimeEmployeeId) {
            this.overTimeEmployeeId = overTimeEmployeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.participantId = employeeId;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getNumberOfEmployee() {
            return numberOfEmployee;
        }

        public void setNumberOfEmployee(int numberOfEmployee) {
            this.numberOfEmployee = numberOfEmployee;
        }

        public int getoverTimeRequestId() {
            return overTimeRequestId;
        }

        public String getDepartmentName() {
            return departmentName;
        }

        public void setDepartmentName(String departmentName) {
            this.departmentName = departmentName;
        }

        public void setoverTimeRequestId(int overTimeRequestId) {
            this.overTimeRequestId = overTimeRequestId;
        }

        public double getOverTimeFactor() {
            return overTimeFactor;
        }

        public void setOverTimeFactor(double overTimeFactor) {
            this.overTimeFactor = overTimeFactor;
        }

        public String getReasonDescription() {
            return reasonDescription;
        }

        public void setReasonDescription(String reason) {
            this.reasonDescription = reason;
        }

        public String getParticipantId() {
            return participantId;
        }

        public void setParticipantId(String participantId) {
            this.participantId = participantId;
        }

        public int getReasonSummary() {
            return reasonSummary;
        }

        public void setReasonSummary(int reasonSummary) {
            this.reasonSummary = reasonSummary;
        }

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
        }

        public String getDepartmentId() {
            return departmentId;
        }

        public void setDepartmentId(String departmentId) {
            this.departmentId = departmentId;
        }

        public String getDepartmentPath() {
            return departmentPath;
        }

        public void setDepartmentPath(String departmentPath) {
            this.departmentPath = departmentPath;
        }

        public String getEmployeeFullName() {
            return employeeFullName;
        }

        public void setEmployeeFullName(String employeeFullName) {
            this.employeeFullName = employeeFullName;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="All Getters and Setters">

    public OverTimeRequestModel getOverTimeRequestAttributes() {
        return overTimeRequestAttributes;
    }

    public void setOverTimeRequestAttributes(OverTimeRequestModel overTimeRequestAttributes) {
        this.overTimeRequestAttributes = overTimeRequestAttributes;
    }

    public OverTimeRequestEntity getOverTimeRequestEntity() {
        return overTimeRequestEntity;
    }

    public void setOverTimeRequestEntity(OverTimeRequestEntity overTimeRequestEntity) {
        this.overTimeRequestEntity = overTimeRequestEntity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getLoggedInDepartmentId() {
        return loggedInDepartmentId;
    }

    public void setLoggedInDepartmentId(String loggedInDepartmentId) {
        this.loggedInDepartmentId = loggedInDepartmentId;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }
    // </editor-fold >
}
