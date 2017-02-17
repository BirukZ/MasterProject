/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.overTimeManager;

/**
 *
 * @author tomgenial
 */
public class OverTimeReportModel {

    String requesterId = null;
    String requesterFullName = null;
    String requesterDeptPath = null;
    String requesterJobDesc = null;
    String appliedDate = null;
    String startDate = null;
    String endDate = null;
    String startTime = null;
    String endTime = null;
    String reason = null;
    String employeeId = null;
    String employeeFullName = null;
    String employeeDeptPath = null;
    String employeeJobDesc = null;
    String officeOrShift = null;
    String deciderId = null;
    String deciderFullName = null;
    String deciderDeptPath = null;
    String deciderJobDesc = null;
    String timeStamp = null;
    String timeDifference = null;

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getEmployeeDeptPath() {
        return employeeDeptPath;
    }

    public void setEmployeeDeptPath(String employeeDeptPath) {
        this.employeeDeptPath = employeeDeptPath;
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

    public String getEmployeeJobDesc() {
        return employeeJobDesc;
    }

    public void setEmployeeJobDesc(String employeeJobDesc) {
        this.employeeJobDesc = employeeJobDesc;
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

    public String getOfficeOrShift() {
        return officeOrShift;
    }

    public void setOfficeOrShift(String officeOrShift) {
        this.officeOrShift = officeOrShift;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRequesterDeptPath() {
        return requesterDeptPath;
    }

    public void setRequesterDeptPath(String requesterDeptPath) {
        this.requesterDeptPath = requesterDeptPath;
    }

    public String getRequesterFullName() {
        return requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public String getRequesterJobDesc() {
        return requesterJobDesc;
    }

    public void setRequesterJobDesc(String requesterJobDesc) {
        this.requesterJobDesc = requesterJobDesc;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getDeciderDeptPath() {
        return deciderDeptPath;
    }

    public void setDeciderDeptPath(String deciderDeptPath) {
        this.deciderDeptPath = deciderDeptPath;
    }

    public String getDeciderFullName() {
        return deciderFullName;
    }

    public void setDeciderFullName(String deciderFullName) {
        this.deciderFullName = deciderFullName;
    }

    public String getDeciderId() {
        return deciderId;
    }

    public void setDeciderId(String deciderId) {
        this.deciderId = deciderId;
    }

    public String getDeciderJobDesc() {
        return deciderJobDesc;
    }

    public void setDeciderJobDesc(String deciderJobDesc) {
        this.deciderJobDesc = deciderJobDesc;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTimeDifference() {
        return timeDifference;
    }

    public void setTimeDifference(String timeDifference) {
        this.timeDifference = timeDifference;
    }

    

    public OverTimeReportModel(){

    }
    public OverTimeReportModel(String requesterId, String requesterFullName, String requesterDeptPath, String requesterJobDesc,
            String appliedDate, String startDate, String endDate , String startTime, String endTime, String reason,
            String employeeId, String employeeFullName, String employeeDeptPath, String employeeJobDesc, String officeOrShift){

    this.requesterId = requesterId;
    this.requesterFullName = requesterFullName;
    this.requesterDeptPath = requesterDeptPath;
    this.requesterJobDesc = requesterJobDesc;
    this.appliedDate = appliedDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.reason = reason;
    this.employeeId = employeeId;
    this.employeeFullName = employeeFullName;
    this.employeeDeptPath = employeeDeptPath;
    this.employeeJobDesc = employeeJobDesc;
    this.officeOrShift = officeOrShift;
    }

    public OverTimeReportModel(String requesterId, String requesterFullName, String requesterDeptPath, String requesterJobDesc,
            String appliedDate, String startDate, String endDate , String startTime, String endTime, String timeDifference, String reason,
            String employeeId, String employeeFullName, String employeeDeptPath, String employeeJobDesc, String officeOrShift){

    this.requesterId = requesterId;
    this.requesterFullName = requesterFullName;
    this.requesterDeptPath = requesterDeptPath;
    this.requesterJobDesc = requesterJobDesc;
    this.appliedDate = appliedDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.timeDifference = timeDifference;
    this.reason = reason;
    this.employeeId = employeeId;
    this.employeeFullName = employeeFullName;
    this.employeeDeptPath = employeeDeptPath;
    this.employeeJobDesc = employeeJobDesc;
    this.officeOrShift = officeOrShift;
    }

    public OverTimeReportModel(String requesterId, String requesterFullName, String requesterDeptPath, String requesterJobDesc,
            String appliedDate, String startDate, String endDate , String startTime, String endTime, String reason,
            String employeeId, String employeeFullName, String employeeDeptPath, String employeeJobDesc,
            String officeOrShift, String deciderId, String deciderFullName, String deciderDeptPath, String decideJobDesc, String timeStamp){

    this.requesterId = requesterId;
    this.requesterFullName = requesterFullName;
    this.requesterDeptPath = requesterDeptPath;
    this.requesterJobDesc = requesterJobDesc;
    this.appliedDate = appliedDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.reason = reason;
    this.employeeId = employeeId;
    this.employeeFullName = employeeFullName;
    this.employeeDeptPath = employeeDeptPath;
    this.employeeJobDesc = employeeJobDesc;
    this.officeOrShift = officeOrShift;
    this.deciderId = deciderId;
    this.deciderFullName = deciderFullName;
    this.deciderDeptPath = deciderDeptPath;
    this.deciderJobDesc = decideJobDesc;
    this.timeStamp = timeStamp;
    }

    public OverTimeReportModel(String requesterId, String requesterFullName, String requesterDeptPath, String requesterJobDesc,
            String appliedDate, String startDate, String endDate , String startTime, String endTime, String timeDifference, String reason,
            String employeeId, String employeeFullName, String employeeDeptPath, String employeeJobDesc,
            String officeOrShift, String deciderId, String deciderFullName, String deciderDeptPath, String decideJobDesc, String timeStamp){

    this.requesterId = requesterId;
    this.requesterFullName = requesterFullName;
    this.requesterDeptPath = requesterDeptPath;
    this.requesterJobDesc = requesterJobDesc;
    this.appliedDate = appliedDate;
    this.startDate = startDate;
    this.endDate = endDate;
    this.startTime = startTime;
    this.endTime = endTime;
    this.timeDifference = timeDifference;
    this.reason = reason;
    this.employeeId = employeeId;
    this.employeeFullName = employeeFullName;
    this.employeeDeptPath = employeeDeptPath;
    this.employeeJobDesc = employeeJobDesc;
    this.officeOrShift = officeOrShift;
    this.deciderId = deciderId;
    this.deciderFullName = deciderFullName;
    this.deciderDeptPath = deciderDeptPath;
    this.deciderJobDesc = decideJobDesc;
    this.timeStamp = timeStamp;
    }


}
