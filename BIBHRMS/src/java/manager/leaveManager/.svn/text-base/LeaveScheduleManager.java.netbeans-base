/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.LeaveBalanceEntity;
import entity.leaveEntity.LeaveScheduleEntity;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author Administrator
 */
public class LeaveScheduleManager {

    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private LeaveBalanceEntity leaveBalanceEntity = new LeaveBalanceEntity();
    private LeaveScheduleEntity leaveScheduleEntity = new LeaveScheduleEntity();

    public String readEmployeeLeaveBalance(String employeeId) {
        try {
            String date = dateFormat.format(new Date());
            String availableAnnualLeave = null;
            date = jodanTimeCalender.ChangeDateToEthiopic(date);
            int month = 0;
            int year = 0;
            month = StringDateManipulation.getMonth(date);
            year = StringDateManipulation.getYear(date);
            if (month < 10) {
                year -= 1;
            }

            ArrayList<HashMap> listOfAvilebelLeave = leaveBalanceEntity.readEmployeeAnnualLeaveBalance(
                    employeeId,
                    Integer.toString(year));
            if (listOfAvilebelLeave.size() > 0) {
                availableAnnualLeave = "  ";

                for (HashMap hm : listOfAvilebelLeave) {
                    availableAnnualLeave = availableAnnualLeave + "[" +
                            hm.get("YEAR").toString() + " ----> " +
                            hm.get("AVAILABLELEAVEAMOUNT").toString() + " ]  ";
                }
                return availableAnnualLeave;
            } else {
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getTransferLeaveAmount(String employeeId) {
        try {

            String date = GregorianCalendarManipulation.subtractGregorianMonth(6);
            String availableAnnualLeave = "  ";
            ArrayList<HashMap> listOfAvilebelLeave = leaveBalanceEntity.getTransferLeaveAmount(
                    employeeId,
                    date);
            if (listOfAvilebelLeave.size() > 0) {
                for (HashMap hm : listOfAvilebelLeave) {
                    availableAnnualLeave = availableAnnualLeave + "[" +
                            hm.get("LEAVEYEAR").toString() + " ----> " +
                            hm.get("LEAVEAMOUNT").toString() + "]  ";
                }
                return availableAnnualLeave;
            } else {
                return null;
            }
        // leaveBalance += leaveRequestEntity.countReserveLeave(employeeId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean saveLeaveSchduleEmployee(ArrayList<HashMap> listOfEmployeeSchedule) {
        return leaveScheduleEntity.saveLeaveSchduleEmployee(listOfEmployeeSchedule);
    }

    public boolean deleteLeaveSchduleEmployee(String employeeId, String year) {
        return leaveScheduleEntity.deleteLeaveSchduleEmployee(employeeId, year);
    }

    public ArrayList<HashMap> listOfemployeeLeaveSecadule(String employeeId) {
        return leaveScheduleEntity.listOfemployeeLeaveSecadule(employeeId);
    }

    public static void main(String args[]) {
        try {


        String s[] = new String[1];
        s[0] = "PATH=C:\\Program Files\\Microsoft Office\\Office12";
        (Runtime.getRuntime()).exec("WINWORD", s);
          } catch (Exception e) {
              e.printStackTrace();
        }
    }
}
