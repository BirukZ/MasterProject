/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import control.HolidaysManager;
import entity.leaveEntity.HolidayEntity;
import entity.leaveEntity.LeaveSettlementEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.Gcalendar;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author ONEJAVA
 */
public class LeaveSettlementManager {

    HashMap leaveRequestInfo;
    HashMap leaveYear;
    HashMap leaveRequestInfo2;
    private HolidayEntity holidayEntity = new HolidayEntity();
    private LeaveSettlementEntity leaveSettlementEntity = new LeaveSettlementEntity();

    public HashMap getLeaveRequestInfo2() {
        return leaveRequestInfo2;
    }

    public void setLeaveRequestInfo2(HashMap leaveRequestInfo2) {
        this.leaveRequestInfo2 = leaveRequestInfo2;
    }

    public HashMap getLeaveRequestInfo() {
        return leaveRequestInfo;
    }

    public void setLeaveRequestInfo(HashMap leaveRequestInfo) {
        this.leaveRequestInfo = leaveRequestInfo;
    }

    public HashMap getLeaveYear() {
        return leaveYear;
    }

    public void setLeaveYear(HashMap leaveYear) {
        this.leaveYear = leaveYear;
    }

    public LeaveSettlementManager() {
    }

    public LeaveSettlementManager(HashMap leaveRequestInfo,
            HashMap leaveYear) {
        this.leaveRequestInfo = leaveRequestInfo;
        this.leaveYear = leaveYear;
    }

    public LeaveSettlementManager(HashMap leaveRequestInfo, HashMap leaveRequestInfo2,
            HashMap leaveYear) {
        this.leaveRequestInfo = leaveRequestInfo;
        this.leaveRequestInfo2 = leaveRequestInfo2;
        this.leaveYear = leaveYear;
    }

    public ArrayList<SelectItem> employessOnLeave() {
        try {
            return leaveSettlementEntity.listOfEmployeeOnLeave();
                   } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> readUsedEmployeeLeave(String employeeId) {
        ArrayList<HashMap> usedLeve = null;//leaveEntity.readUsedEmployeeLeave(employeeId);
        try {
            return usedLeve;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public boolean chengeLeaveType(HashMap leaveInformation) {
        try {
            return false;// leaveEntity.chengeLeaveType(leaveInformation);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean chengeLeaveType(LeaveSettlementManager leaveSettlementManager) {
        try {
//            Leave_Entity leaveRequestInformation = new Leave_Entity(
//                    leaveManager.getLeaveRequestInfo(),
//                    leaveManager.getLeaveYear());
            return false;//leaveEntity.chengeLeaveType(leaveRequestInformation);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeUsedLeaveType(HashMap leaveInformation1, HashMap leaveInformation2) {
        try {
            return false;// leaveEntity.changeUsedLeaveType(leaveInformation1, leaveInformation2);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean changeUsedLeaveType(LeaveSettlementManager leaveSettlementManager) {
        try {
//            Leave_Entity leave_Entity = new Leave_Entity(leaveManager.getLeaveRequestInfo(),
//                    leaveManager.getLeaveRequestInfo2(), leaveManager.getLeaveYear());
            return false;// leaveEntity.changeUsedLeaveType(leave_Entity);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap readEmployeeLeaveWithProfile(String employeeId) {
        return null;//leaveEntity.readEmployeeLeaveWithProfile(employeeId);
    }

    public int calculatAnualLeaveDate(String startDate, String endDate) {
        boolean islastDate = false;
        String nextDate = startDate;
        //boolean found = false;
        int saturdayCounter = 0;
        int holidayCounter = 0;
        //int numberOfWorkingDay = 0;
        int numberOFDays = 1; //StringDateManipulation.compareDateDifference(startDate, endDate);
        try {
            do {
                nextDate = StringDateManipulation.nextDayInEC(nextDate);
                if (nextDate.equals(endDate)) {
                    islastDate = false;
                    numberOFDays += 1;
                } else {
                    numberOFDays += 1;
                    islastDate = true;
                }
            } while (islastDate);
            Gcalendar gc = new Gcalendar();
            ArrayList<HashMap> hilidayList = holidayEntity.holidayList(startDate, endDate);
            nextDate = startDate;
            for (int i = 0; i <= numberOFDays; i++) {
                if (!HolidaysManager.getNameOfTheDay(gc.getDiff(nextDate)).equals("Saturday")) {
                    if (!HolidaysManager.getNameOfTheDay(gc.getDiff(nextDate)).equals("Sunday")) {
                        for (HashMap hm : hilidayList) {
                            if (hm.get("holidayDate").toString().equals(nextDate)) {
                                holidayCounter += 1;
                            }
                        }
                    } else {
                        holidayCounter++;
                    }

                } else {
                    saturdayCounter += 1;
                }
                nextDate = StringDateManipulation.nextDayInEC(nextDate);
            }
            saturdayCounter /= 2;
            numberOFDays -= holidayCounter;
            numberOFDays -= saturdayCounter;
            return numberOFDays;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }

    }

    public boolean settlementLeaveInformation(LeaveSettlementManager leaveSettlementManager) {
        try {
            LeaveSettlementEntity leaveSettlement = new LeaveSettlementEntity(leaveSettlementManager.getLeaveRequestInfo(),
                    leaveSettlementManager.getLeaveRequestInfo2(), leaveSettlementManager.getLeaveYear());
            return leaveSettlementEntity.settlementLeaveInformation(leaveSettlement);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean checkRequestStatus(String leaveRequesId) {
        return leaveSettlementEntity.checkRequestStatus(leaveRequesId);
    }
}