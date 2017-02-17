/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.attendanceManager;

import entity.attendanceEntity.AttendanceReportEntity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import manager.globalUseManager.JodanTimeCalender;
import manager.leaveManager.LeaveControl;

/**
 *
 * @author Administrator
 */
public class AttendanceReportManager {

    private AttendanceReportEntity attendanceReportEntity = null;
    private LeaveControl leaveControl = null;

    public ArrayList<HashMap> listOfAbsent(Date startDate, Date endDate,int departemntId) {
        ArrayList<HashMap> absentRerport = new ArrayList<HashMap>();
        Calendar startCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endDateCal.setTime(endDate);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");

        int counter = 1;
        int reportCounter = 1;
        boolean cheker = false;
        String absentAmount = "";
        checkObject();
        try {

            // float dayCounter = 0;
            float countWastedhour = 0;

            ArrayList<HashMap> listEmployee = attendanceReportEntity.listOfEmployeeonDepartment(departemntId);
            ArrayList<HashMap> listAbsntEmployee = attendanceReportEntity.readEmployeeAndAbsent(
                    dateformatter.format(startDate), dateformatter.format(endDate),departemntId);
            float shiftWorkingDay = LeaveControl.calculateWorkingDateShiftWorker(startDate, endDate);
            float officeWorkingDay = LeaveControl.calculateWorkingDateOfficeWorker(startDate, endDate);

            for (HashMap le : listEmployee) {
                startCal.setTime(startDate);
                endDateCal.setTime(endDate);
                HashMap list = new HashMap();
                list.put("EMPLOYEEFULLNAME", le.get("Full_Name").toString());
                list.put("EMPLOYEEID", le.get("Emp_Id").toString());
                reportCounter = 1;
                countWastedhour = 0;
                while (!startCal.after(endDateCal)) {
                    counter++;
                    absentAmount = ".";
                    for (HashMap hm : listAbsntEmployee) {
                        if (hm.get("AttendanceDate").equals(dateformatter.format(startCal.getTime())) && le.get("Emp_Id").equals(hm.get("Emp_Id"))
                              &&   !leaveControl.getHoliday(dateformatter.format(startCal.getTime()))) {
                            if (hm.get("Absentamount").toString().equals("1")) {
                                if (le.get("OFFICE_OR_SHIFT").toString().equals("Shift") && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                                    countWastedhour += 8;
                                    absentAmount = "8" + hm.get("ABSENTTYPE").toString();
                                } else {
                                    if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                                        countWastedhour += 4.5;
                                        absentAmount = "4.5" + hm.get("ABSENTTYPE").toString();
                                    } else if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                                        absentAmount = "8" + hm.get("ABSENTTYPE").toString();
                                        countWastedhour += 8;
                                    }
                                }
                            } else {
                                if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
                                    countWastedhour += 4.5;
                                    absentAmount = "4.5" + hm.get("ABSENTTYPE").toString();
                                }


                            }
                            cheker = true;
                            break;
                        }
                    }
                    if (cheker) {
                        cheker = false;
                    }


                    list.put("ABSENTAMOUNT" + reportCounter, absentAmount);
                    reportCounter++;
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                }
                if (le.get("OFFICE_OR_SHIFT").toString().equals("Shift")) {
                    list.put("MothlyWorkingHour", shiftWorkingDay);
                    list.put("HoursWorked", shiftWorkingDay - countWastedhour);
                } else {
                    list.put("MothlyWorkingHour", officeWorkingDay);
                    list.put("HoursWorked",officeWorkingDay - countWastedhour);
                }
                list.put("HoursWasted", countWastedhour);

                absentRerport.add(list);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


        return absentRerport;
    }

    private void checkObject() {
        if (attendanceReportEntity == null) {
            attendanceReportEntity = new AttendanceReportEntity();
        }
        if (leaveControl == null) {
            leaveControl = new LeaveControl();
        }
    }

  
}
