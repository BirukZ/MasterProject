/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.reporterManager.leaveReportManager;

import entity.reporterEntity.employeeLeaveReportEntity.LeaveReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;

/**
 *
 * @author PROJECT
 */
public class LeaveReportManager {

    private LeaveReportEntity leaveReportEntity = new LeaveReportEntity();
    private ArrayList<TableDataModele> listOfEmployeeLeaveRequest = new ArrayList<TableDataModele>();

    public ArrayList<TableDataModele> getListOfEmployeeLeaveRequest() {
        return listOfEmployeeLeaveRequest;
    }

    public void setListOfEmployeeLeaveRequest(ArrayList<TableDataModele> listOfEmployeeLeaveRequest) {
        this.listOfEmployeeLeaveRequest = listOfEmployeeLeaveRequest;
    }

    public LeaveReportManager() {
    }

    public ArrayList<HashMap> getEmployeeLeaveRequest() {
        return leaveReportEntity.lisOfRequestLeave(
                ReportCriteraManager.getEmployeeId(),
                ReportCriteraManager.isAllEmployee());
    }

    public HashMap[] getEmployeeLeaveBalance() {
        return leaveReportEntity.lisOfEmployeetLeaveBalance(
                ReportCriteraManager.getEmployeeId(), true);
    //ReportCriteraManager.getEmployeeId()
    //ReportCriteraManager.isAllEmployee());
    }

    public ArrayList<HashMap> getEmployeeLeaveBalancee() {
        return leaveReportEntity.lisOfEmployeetLeave(
                ReportCriteraManager.getEmployeeId(),
                ReportCriteraManager.isAllEmployee());
    }

    public ArrayList<HashMap> getEmployeeLeaveTransfer() {
        return leaveReportEntity.lisOfEmployeeLeaveTransfer(
                ReportCriteraManager.getEmployeeId(),
                ReportCriteraManager.isAllEmployee());
    }

    public HashMap avilebleAnualeLeave(String employeeId) {
        return leaveReportEntity.avilebleAnualeLeave(employeeId);
    }

    public String getLeaveTransferApproveDate(String transferRequestID) {
        return leaveReportEntity.leaveTransferApproveDate(transferRequestID);
    }

    private void loadReport() {
//                String organizationHead,
//                String department, String team,
//                int
        String year = "";
        String fullName = "";
        String sex = "";
        String leaveType = "";
        String leaveAmount = "";
        String newYear = "";
        String oldYear = "";
        try {
            float totalAvilabelLeave = 0;
            HashMap[] listOfLeaveRequest = this.getEmployeeLeaveBalance();
//            getListOfEmployeeLeaveRequest().clear();
            int listSize = listOfLeaveRequest.length;
            listSize -= 1;
            String employeeId = "";
            boolean isFirst = true;
            for (int i = listSize; i >= 0; i--) {

                if (!listOfLeaveRequest[i].get("EMPLOYEEID").toString().equals(employeeId)) {
                    fullName = listOfLeaveRequest[i].get("FULLNAME").toString();
                    sex = listOfLeaveRequest[i].get("SEX").toString();
                    leaveType = listOfLeaveRequest[i].get("LEAVETYPE").toString();
                    year = listOfLeaveRequest[i].get("YEAR").toString();
                    employeeId = listOfLeaveRequest[i].get("EMPLOYEEID").toString();
                    if (listOfLeaveRequest[i].get("YEAR").toString().equals("2005")) {
                        newYear = listOfLeaveRequest[i].get("AVILEBELLEAVEAMOUNT").toString();
                    } else {
                        oldYear = listOfLeaveRequest[i].get("AVILEBELLEAVEAMOUNT").toString();

                    }
                } else {
                    oldYear = listOfLeaveRequest[i].get("AVILEBELLEAVEAMOUNT").toString();
                    getListOfEmployeeLeaveRequest().add(new TableDataModele(
                            year,
                            employeeId,
                            fullName,
                            sex,
                            leaveType,
                            "",
                            newYear,
                            newYear));

                }




            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String arg[]) {
        LeaveReportManager leaveReportManager = new LeaveReportManager();
        leaveReportManager.loadReport();
    }

    public static class TableDataModele {

        private String year;
        private String employeeId;
        private String fullName;
        private String sex;
        private String leaveType;
        private String leaveAmount;
        private String newYear;
        private String oldYear;

        public TableDataModele(
                String year,
                String employeeId,
                String fullName,
                String sex,
                String leaveType,
                String leaveAmount,
                String newYear,
                String oldYear) {
            this.year = year;
            this.employeeId = employeeId;
            this.fullName = fullName;
            this.sex = sex;
            this.leaveType = leaveType;
            this.leaveAmount = leaveAmount;
            this.newYear = newYear;
            this.oldYear = oldYear;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getLeaveAmount() {
            return leaveAmount;
        }

        public void setLeaveAmount(String leaveAmount) {
            this.leaveAmount = leaveAmount;
        }

        public String getLeaveType() {
            return leaveType;
        }

        public void setLeaveType(String leaveType) {
            this.leaveType = leaveType;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getYear() {
            return year;
        }

        public void setYear(String year) {
            this.year = year;
        }

        public String getNewYear() {
            return newYear;
        }

        public void setNewYear(String newYear) {
            this.newYear = newYear;
        }

        public String getOldYear() {
            return oldYear;
        }

        public void setOldYear(String oldYear) {
            this.oldYear = oldYear;
        }
        ////////////////////////////////get&set/////////////////////////////////////////////
    }
}
