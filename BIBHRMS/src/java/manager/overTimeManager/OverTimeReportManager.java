/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.overTimeManager;
import entity.overTimeEntity.OverTimeReportEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Mugher
 */
public class OverTimeReportManager {

    OverTimeReportEntity overTimeReportEntity = new OverTimeReportEntity();
    public ArrayList<OverTimeReportModel> getOverTimeRequests() {
        ArrayList<OverTimeReportModel> overTimeRequestLists = new ArrayList<OverTimeReportModel>();
        String startHour = null;
        String startMin = null;
        String endHour = null;
        String endMin = null;
        int hourDifference = 0;
        int minDifference = 0;
        String timeDifference = null;
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeRequestsByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");

                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeRequestsByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");

                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeRequestsBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");

                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeRequestsByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");

                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeRequestsByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");

                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return overTimeRequestLists;
    }

    public ArrayList<OverTimeReportModel> getOverTimeApproved() {
        ArrayList<OverTimeReportModel> overTimeRequestLists = new ArrayList<OverTimeReportModel>();
        String startHour = null;
        String startMin = null;
        String endHour = null;
        String endMin = null;
        int hourDifference = 0;
        int minDifference = 0;
        String timeDifference = null;
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeApprovedByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");
                String deciderId = _rs.getString("PROCESSED_BY");
                String deciderFullName = _rs.getString("DECIDER_FULL_NAME");
                String deciderDeptPath = _rs.getString("DECIDER_DEPT_PATH");
                String deciderJobDesc = _rs.getString("DECIDER_JOB_DESC");
                String timeStamp = _rs.getString("TIME_STAMP");
                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift,deciderId,deciderFullName,deciderDeptPath,deciderJobDesc,timeStamp);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeApprovedByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");
                String deciderId = _rs.getString("PROCESSED_BY");
                String deciderFullName = _rs.getString("DECIDER_FULL_NAME");
                String deciderDeptPath = _rs.getString("DECIDER_DEPT_PATH");
                String deciderJobDesc = _rs.getString("DECIDER_JOB_DESC");
                String timeStamp = _rs.getString("TIME_STAMP");
                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift,deciderId,deciderFullName,deciderDeptPath,deciderJobDesc,timeStamp);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeApprovedBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");
                String deciderId = _rs.getString("PROCESSED_BY");
                String deciderFullName = _rs.getString("DECIDER_FULL_NAME");
                String deciderDeptPath = _rs.getString("DECIDER_DEPT_PATH");
                String deciderJobDesc = _rs.getString("DECIDER_JOB_DESC");
                String timeStamp = _rs.getString("TIME_STAMP");
                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift,deciderId,deciderFullName,deciderDeptPath,deciderJobDesc,timeStamp);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeApprovedByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");
                String deciderId = _rs.getString("PROCESSED_BY");
                String deciderFullName = _rs.getString("DECIDER_FULL_NAME");
                String deciderDeptPath = _rs.getString("DECIDER_DEPT_PATH");
                String deciderJobDesc = _rs.getString("DECIDER_JOB_DESC");
                String timeStamp = _rs.getString("TIME_STAMP");
                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift,deciderId,deciderFullName,deciderDeptPath,deciderJobDesc,timeStamp);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = overTimeReportEntity.readAllOverTimeApprovedByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String requesterId = _rs.getString("REQUESTER_ID");
                String requesterFullName = _rs.getString("REQUESTER_FULL_NAME");
                String requesterDeptPath = _rs.getString("REQUESTER_DEPT_PATH");
                String requesterJobDesc = _rs.getString("REQUESTER_JOB_DESC");
                String appliedDate = _rs.getString("APPLIED_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String startTime = _rs.getString("START_TIME");
                String endTime = _rs.getString("END_TIME");
                startHour = startTime.substring(0,2);
                startMin = startTime.substring(3,5);
                endHour = endTime.substring(0,2);
                endMin = endTime.substring(3,5);
                hourDifference = Integer.parseInt(endHour) - Integer.parseInt(startHour);
                if(Integer.parseInt(endMin) >= Integer.parseInt(startMin)){
                minDifference = Integer.parseInt(endMin) - Integer.parseInt(startMin);
                } else {
                hourDifference = hourDifference - 1;
                minDifference = Integer.parseInt(startMin) + Integer.parseInt(endMin);
                }
                timeDifference = hourDifference+":"+minDifference;
                String reason = _rs.getString("REASON");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("EMPLOYEE_FULL_NAME");
                String employeeDeptPath = _rs.getString("EMPLOYEE_DEPT_PATH");
                String employeeJobDesc = _rs.getString("EMPLOYEE_JOB_DESC");
                String officeOrShift = _rs.getString("OFFICE_OR_SHIFT");
                String deciderId = _rs.getString("PROCESSED_BY");
                String deciderFullName = _rs.getString("DECIDER_FULL_NAME");
                String deciderDeptPath = _rs.getString("DECIDER_DEPT_PATH");
                String deciderJobDesc = _rs.getString("DECIDER_JOB_DESC");
                String timeStamp = _rs.getString("TIME_STAMP");
                OverTimeReportModel overTimeRequestModel = new OverTimeReportModel(requesterId,requesterFullName, requesterDeptPath, requesterJobDesc, appliedDate, startDate, endDate,
                        startTime, endTime, timeDifference, reason, employeeId, employeeFullName, employeeDeptPath,employeeJobDesc,officeOrShift,deciderId,deciderFullName,deciderDeptPath,deciderJobDesc,timeStamp);
                overTimeRequestLists.add(overTimeRequestModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }
        return overTimeRequestLists;
    }

}
