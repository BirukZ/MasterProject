/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.overTimeManager;

import entity.overTimeEntity.OverTimeAttendanceEntity;
import entity.overTimeEntity.OverTimeRequestEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import manager.overTimeManager.OverTimeRequestManager.OverTimeRequestModel;

/**
 *
 * @author mekete
 */
public class OverTimeAttendanceManager {

    OverTimeRequestEntity overTimeRequestEntity = new OverTimeRequestEntity();
    OverTimeAttendanceModel overTimeAttendanceModel = new OverTimeAttendanceModel();
    OverTimeRequestModel overTimeRequestAttributes = new OverTimeRequestModel();
    OverTimeAttendanceEntity overTimeAttendanceEntity = new OverTimeAttendanceEntity();
    String userName;
    String loggedInEmployeeId;
    String loggedInDepartmentId;

    public boolean saveOverTimeAttendance(
            ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists,
            int requestId, String attendaceDate) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            if (overTimeAttendanceEntity.insertOverTimeAttendance(overTimeAttendanceEmployeeLists, requestId, userName, recorededDateAndTime, attendaceDate)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveOverTimeAttendance(ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists, String userNames, int requestId, String attendaceDate) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            if (overTimeAttendanceEntity.insertOverTimeAttendance(overTimeAttendanceEmployeeLists, requestId, userNames, recorededDateAndTime, attendaceDate)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateOverTimeAttendance(ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists, int requestId) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            //for database efficiency only
//            for (OverTimeRequestModel current : overTimeAttendanceEmployeeLists) {
//                if (current.getDatabaseStatus() == null || !current.getDatabaseStatus().equals(OverTimeRequestManager.DATABASE_STATUS_OLDDELETED)) {
//                    overTimeAttendanceEmployeeLists.remove(current);
//                }
//            }

            if (overTimeAttendanceEntity.updateOverTimeAttendanceEmployee(overTimeAttendanceEmployeeLists)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateOverTimeAttendanceApprov(ArrayList<OverTimeRequestModel> overTimeAttendanceEmployeeLists, int APoverTimeAttendanceId, int overTimeRequestId) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            if (overTimeAttendanceEntity.updateOverTimeAttendanceEmployeeApproov(overTimeAttendanceEmployeeLists, APoverTimeAttendanceId)) {

                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<OverTimeRequestModel> getAttendedEmployeeAndTimeList(int overTimeAttendanceId) {

        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendedEmployeeAndTimeList(overTimeAttendanceId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setOverTimeEmployeeId(_rs.getInt("OT_ATTENDANCE_EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                // overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                //overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setAttendanceDate(_rs.getString("ATTENDANCE_DATE"));
                overTimeRequestAttributes.setDisplayedOverTimeFactor(_rs.getString("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(_rs.getString("ATTENDED").equals("YES"));
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<OverTimeRequestModel> getAttendedEmployeeForApprove(int overTimeAttendanceId) {

        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendedEmployeeForApprove(overTimeAttendanceId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setOverTimeEmployeeId(_rs.getInt("OT_ATTENDANCE_EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                // overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                //overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setAttendanceDate(_rs.getString("ATTENDANCE_DATE"));
                overTimeRequestAttributes.setDisplayedOverTimeFactor(_rs.getString("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(false);
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<OverTimeRequestModel> getAttendedEmployeeHistory(int overTimeAttendanceId) {

        ArrayList<OverTimeRequestModel> requestLists = new ArrayList<OverTimeRequestModel>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendedEmployeeForApprove(overTimeAttendanceId);
            while (_rs.next()) {
                overTimeRequestAttributes = new OverTimeRequestModel();
                overTimeRequestAttributes.setOverTimeEmployeeId(_rs.getInt("OT_ATTENDANCE_EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                overTimeRequestAttributes.setEmployeeFullName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                // overTimeRequestAttributes.setStartDate(_rs.getString("START_DATE"));
                overTimeRequestAttributes.setStartTime(_rs.getString("START_TIME"));
                //overTimeRequestAttributes.setEndDate(_rs.getString("END_DATE"));
                overTimeRequestAttributes.setEndTime(_rs.getString("END_TIME"));
                overTimeRequestAttributes.setOverTimeFactor(_rs.getDouble("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setAttendanceDate(_rs.getString("ATTENDANCE_DATE"));
                overTimeRequestAttributes.setDisplayedOverTimeFactor(_rs.getString("OVER_TIME_FACTOR"));
                overTimeRequestAttributes.setSelected(true);
                requestLists.add(overTimeRequestAttributes);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAttendanceHistorys() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendanceHistoryEmployee(userName);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("ATTENDANCE_DATE"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAttendanceHistorysApprove() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectApprovedOverTimeRequestsAttendance(loggedInEmployeeId, userName);
            String as = "";
            while (_rs.next()) {

                if (!as.equalsIgnoreCase(_rs.getString("OVER_TIME_REQUEST_ID"))) {
                    SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("ATTENDANCE_DATE"));
                    requestLists.add(currentItem);
                }
                as = _rs.getString("OVER_TIME_REQUEST_ID");
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAttendanceApprove() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectApprovedAttendance(loggedInEmployeeId, userName);
            String as = "";

            while (_rs.next()) {

                if (!as.equalsIgnoreCase(_rs.getString("OVER_TIME_REQUEST_ID"))) {
                    SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("ATTENDANCE_DATE"));
                    requestLists.add(currentItem);
                }
                as = _rs.getString("OVER_TIME_REQUEST_ID");
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAttendanceToBeTakenDaysList() {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendanceHistoryEmployee(userName);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("ATTENDANCE_DATE") + "  Taken");
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAttendanceHistorys(int requestId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = overTimeAttendanceEntity.selectAttendanceHistoryEmployee(requestId);
            while (_rs.next()) {
                SelectItem currentItem = new SelectItem(_rs.getString("OVER_TIME_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("ATTENDANCE_DATE") + "--" + _rs.getString("HR_OVER_TIME_ATTENDANCE_ID"), _rs.getString("REQUESTER_ID") + " on " + _rs.getString("ATTENDANCE_DATE"));
                requestLists.add(currentItem);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
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

    public OverTimeAttendanceModel getOverTimeAttendanceModel() {
        return overTimeAttendanceModel;
    }

    public void setOverTimeAttendanceModel(OverTimeAttendanceModel overTimeAttendanceModel) {
        this.overTimeAttendanceModel = overTimeAttendanceModel;
    }

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

    public static class OverTimeAttendanceModel implements Serializable {

        int overTimeAttendanceId;
        int overTimeRequestId;
        int overTimeApproveId;
        String employeeId;
        String employeeFullName;
        String attendanceDate;
        String startTime;
        String endTime;
        double overTimeFactor;
        String dataBaseStatus;
        String status;
        String docReferenceNumber;
        String timeStamp;//TIME_STAMP
        String userName;//USER_NAME

        public OverTimeAttendanceModel() {
        }

        public OverTimeAttendanceModel(String employeeId, String employeeFullName, String attendanceDate, String startTime, String endTime, double overTimeFactor) {
            this.employeeId = employeeId;
            this.employeeFullName = employeeFullName;
            this.attendanceDate = attendanceDate;
            this.startTime = startTime;
            this.endTime = endTime;
            this.overTimeFactor = overTimeFactor;
        }

//        public OverTimeAttendanceModel(String employeeId, String employeeFullName, String attendanceDate, String startTime, String endTime, double overTimeFactor) {
//            this.employeeId = employeeId;
//            this.employeeFullName = employeeFullName;
//            this.attendanceDate = attendanceDate;
//            this startDate = startDate;
//            this.startTime = startTime;
//            this endDate = endDate;
//            this.endTime = endTime;
//            this.overTimeFactor = overTimeFactor;
//            this attendaceDate = attendaceDate;
//            this.overTimeFactor = overTimeFactor;
//        }

        public String getAttendanceDate() {
            return attendanceDate;
        }

        public void setAttendanceDate(String attendanceDate) {
            this.attendanceDate = attendanceDate;
        }

        public String getDataBaseStatus() {
            return dataBaseStatus;
        }

        public void setDataBaseStatus(String dataBaseStatus) {
            this.dataBaseStatus = dataBaseStatus;
        }

        public String getDocReferenceNumber() {
            return docReferenceNumber;
        }

        public void setDocReferenceNumber(String docReferenceNumber) {
            this.docReferenceNumber = docReferenceNumber;
        }

        public String getEmployeeFullName() {
            return employeeFullName;
        }

        public void setEmployeeFullName(String employeeFullName) {
            this.employeeFullName = employeeFullName;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getEndTime() {
            return endTime;
        }

        public void setEndTime(String endTime) {
            this.endTime = endTime;
        }

        public int getOverTimeApproveId() {
            return overTimeApproveId;
        }

        public void setOverTimeApproveId(int overTimeApproveId) {
            this.overTimeApproveId = overTimeApproveId;
        }

        public int getOverTimeAttendanceId() {
            return overTimeAttendanceId;
        }

        public void setOverTimeAttendanceId(int overTimeAttendanceId) {
            this.overTimeAttendanceId = overTimeAttendanceId;
        }

        public double getOverTimeFactor() {
            return overTimeFactor;
        }

        public void setOverTimeFactor(double overTimeFactor) {
            this.overTimeFactor = overTimeFactor;
        }

        public int getOverTimeRequestId() {
            return overTimeRequestId;
        }

        public void setOverTimeRequestId(int overTimeRequestId) {
            this.overTimeRequestId = overTimeRequestId;
        }

        public String getStartTime() {
            return startTime;
        }

        public void setStartTime(String startTime) {
            this.startTime = startTime;
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
}
