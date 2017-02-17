/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.LeaveBalanceEntity;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author ONEJAVA
 */
public class AnnualLeaveManager {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private LeaveBalanceManager leaveBalanceManager = new LeaveBalanceManager();
    private EmployeeManage employeeManager = new EmployeeManage();
    private ArrayList<HashMap> listOfEmployeeNewLeave = new ArrayList<HashMap>();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private LeaveBalanceEntity leaveBalanceEntity = new LeaveBalanceEntity();

    public ArrayList<HashMap> getListOfEmployeeNewLeave() {
        return listOfEmployeeNewLeave;
    }

    public void setListOfEmployeeNewLeave(ArrayList<HashMap> listOfEmployeeNewLeave) {
        this.listOfEmployeeNewLeave = listOfEmployeeNewLeave;
    }

    public boolean saveEmployeeAnnualLeave(String year) {
        try {
            int serviceYear = 0;
            getListOfEmployeeNewLeave().clear();
            String date = jodanTimeCalender.currentDateFinder();
            int phisicalLeaveYear = StringDateManipulation.getYear(date);
            int month = StringDateManipulation.getMonth(date);
            boolean isTheNotSameYear = false;
            if (month >= 11) {
                phisicalLeaveYear += 1;
            }
            if (phisicalLeaveYear != Integer.parseInt(year)) {
                isTheNotSameYear = true;
                phisicalLeaveYear -= Integer.parseInt(year);
            } else {
                phisicalLeaveYear = 0;
            }
          
            ArrayList<HashMap> employeeList = leaveBalanceManager.listOfEmployee(year);
            for (HashMap hm : employeeList) {
                serviceYear = employeeManager.calculateEmployeeExperianceServiceYear(hm.get("employeeId").toString());
                if (isTheNotSameYear)
                {
                    serviceYear -= phisicalLeaveYear;
                }

                serviceYear += employeeManager.calculateServiceYear(hm.get("employeeId").toString());
                if (serviceYear >= 0) {
                    addEmployeeLeave(
                            serviceYear,
                            hm.get("employeeId").toString(),
                            hm.get("startLeaveFrom").toString(),
                            year,
                            hm.get("hireDate").toString());
                }
            }

            if (leaveBalanceManager.saveLeaveBalanceINBank(getListOfEmployeeNewLeave())) {
                return true;
            } else {
                return false;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void addEmployeeLeave(int serviceYear, String employeeId,
            String leaveAllowed, String year, String hireDate) {

        if (serviceYear > 0)
        {

            HashMap hm = new HashMap();
            hm.put("employeeId", employeeId);
            hm.put("physicalYear", year);

            hm.put("usedLeaveAmount", "0");
            if (leaveAllowed.equals("NORMAL"))
            {


                if (serviceYear < 19) {
                    for (HashMap list : allowedLeaveNormalWorker())
                    {
                        hm.put("leaveAmount", list.get(Integer.toString(serviceYear)));
                        listOfEmployeeNewLeave.add(hm);
                        break;
                    }
                } else {
                    hm.put("leaveAmount", "50");
                    listOfEmployeeNewLeave.add(hm);
                }
            } else {
                if (serviceYear < 11) {
                    for (HashMap list : allowedLeave()) {
                        hm.put("leaveAmount", list.get(Integer.toString(serviceYear)));
                        listOfEmployeeNewLeave.add(hm);
                        break;
                    }
                } else {
                    hm.put("leaveAmount", "50");
                    listOfEmployeeNewLeave.add(hm);
                }
            }

        } else {
            DecimalFormat df = new DecimalFormat("#.##");

            float givenLeaveAmount = 0;
            HashMap hm = new HashMap();
            hm.put("employeeId", employeeId);
            hm.put("physicalYear", year);
            hm.put("usedLeaveAmount", "0");
            if (leaveAllowed.equals("NORMAL")) {
                givenLeaveAmount = remsiningWorkingDayes(hireDate) * 14 / totalYearDay();

                if (givenLeaveAmount > 0) {
                    hm.put("leaveAmount", df.format(givenLeaveAmount).toString());
                    listOfEmployeeNewLeave.add(hm);
                }
            } else {
                givenLeaveAmount = remsiningWorkingDayes(hireDate) * 30 / totalYearDay();
                if (givenLeaveAmount > 0) {
                    hm.put("leaveAmount", df.format(givenLeaveAmount).toString());
                    listOfEmployeeNewLeave.add(hm);
                }

            }
        }
    }

    private void addEmployeeLeaveAmount(int serviceYear, String employeeId,
            String leaveAllowed, String year, String hireDate, String privousGiven) {
        float pervious = Float.parseFloat(privousGiven);
        float newValue = 0;

        if (serviceYear > 0) {
            HashMap hm = new HashMap();
            hm.put("employeeId", employeeId);
            hm.put("physicalYear", year);
            hm.put("yearlyGiven", "all");
            if (leaveAllowed.equals("NORMAL")) {
                if (serviceYear < 19) {
                    for (HashMap list : allowedLeaveNormalWorker()) {
                        hm.put("leaveAmount", list.get(Integer.toString(serviceYear)).toString());
                        listOfEmployeeNewLeave.add(hm);
                        break;
                    }
                } else {
                    hm.put("leaveAmount", "50.0");
                    listOfEmployeeNewLeave.add(hm);
                }
            } else {
                if (serviceYear < 11) {
                    for (HashMap list : allowedLeave()) {
                        String gienAmout = list.get(Integer.toString(serviceYear)).toString();
                        newValue = Float.parseFloat(gienAmout);
                        newValue -= pervious;
                        hm.put("leaveAmount", pervious);
                        listOfEmployeeNewLeave.add(hm);
                        break;
                    }
                } else {
                    String gienAmout = "50.0";
                    newValue = Float.parseFloat(gienAmout);
                    newValue -= pervious;
                    listOfEmployeeNewLeave.add(hm);





                }
            }

        } else {

            //to give employee leave by month
            int monthDiffrence = GregorianCalendarManipulation.calaculateMonthDifference(hireDate,
                    jodanTimeCalender.currentForeignersDateFinder());
            float givenLeaveAmount = 0;
            if (monthDiffrence > 0) {

                if (leaveAllowed.equals("NORMAL")) {
                    givenLeaveAmount = (monthDiffrence * 12) / 14;
                    newValue = givenLeaveAmount;
                    newValue -= pervious;
                    if (newValue > 0) {
                        HashMap hm = new HashMap();
                        hm.put("employeeId", employeeId);
                        hm.put("physicalYear", year);
                        hm.put("yearlyGiven", "notall");
                        hm.put("leaveAmount", Float.toString(givenLeaveAmount += pervious));
                        listOfEmployeeNewLeave.add(hm);
                    }
                } else {
                    givenLeaveAmount = (monthDiffrence * 12) / 30;
                    newValue = givenLeaveAmount;
                    newValue -= pervious;
                    if (givenLeaveAmount > 0) {
                        HashMap hm = new HashMap();
                        hm.put("employeeId", employeeId);
                        hm.put("physicalYear", year);
                        hm.put("yearlyGiven", "notall");
                        hm.put("leaveAmount", Float.toString(givenLeaveAmount += pervious));
                        listOfEmployeeNewLeave.add(hm);
                    }
                }
            }
        }
    }

    public ArrayList<HashMap> allowedLeaveNormalWorker() {
        ArrayList<HashMap> allowedLeaveNumber = new ArrayList<HashMap>();
        HashMap leaveNumber = new HashMap();
        leaveNumber.put("1", "16");
        leaveNumber.put("2", "17");
        leaveNumber.put("3", "18");
        leaveNumber.put("4", "19");
        leaveNumber.put("5", "20");
        leaveNumber.put("6", "21");
        leaveNumber.put("7", "22");
        leaveNumber.put("8", "23");
        leaveNumber.put("9", "24");
        leaveNumber.put("10", "25");
        leaveNumber.put("11", "26");
        leaveNumber.put("12", "27");
        leaveNumber.put("13", "28");
        leaveNumber.put("14", "29");
        leaveNumber.put("15", "30");
        leaveNumber.put("16", "31");
        leaveNumber.put("17", "32");
        leaveNumber.put("18", "33");
        allowedLeaveNumber.add(leaveNumber);
        return allowedLeaveNumber;
    }

    public ArrayList<HashMap> allowedLeave() {
        ArrayList<HashMap> allowedLeaveNumber = new ArrayList<HashMap>();
        HashMap leaveNumber = new HashMap();
        leaveNumber.put("1", "16");
        leaveNumber.put("2", "17");
        leaveNumber.put("3", "18");
        leaveNumber.put("4", "19");
        leaveNumber.put("5", "20");
        leaveNumber.put("6", "21");
        leaveNumber.put("7", "22");
        leaveNumber.put("8", "23");
        leaveNumber.put("9", "24");
        leaveNumber.put("10", "25");
        allowedLeaveNumber.add(leaveNumber);
        return allowedLeaveNumber;
    }

    private ArrayList<HashMap> calculateEmployeeAnualLeave(String requestDate, String employeeId) {
        try {
            LeaveRequestManager leaveRequestManager = new LeaveRequestManager();
            String usedYear = "";
            String leaveFrom = "";
            String leaveFromId = "";
            float requestLeave = Float.parseFloat(requestDate);
            float availeLeave = 0;
            float usedleave = 0;
            float oldAmount = 0;
            float leavereq = requestLeave;
            ArrayList<HashMap> useleve = new ArrayList<HashMap>();
            float reserveLeaveQuantity = leaveRequestManager.countReserveLeave(employeeId);
            if (reserveLeaveQuantity == 0) {

                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Float.parseFloat(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    usedYear += "[" + hm.get("year").toString() + "==>" + usedleave + "]";
                    useleve.add(list);
                }
                return useleve;
            } else if (reserveLeaveQuantity > requestLeave) {
                ArrayList<HashMap> listOfReserve = leaveRequestManager.readReserveLeave(employeeId);
                for (HashMap hm : listOfReserve) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    if (usedleave > 0) {
                        oldAmount = Float.parseFloat(hm.get("USEDLEAVE").toString()) + usedleave;
                        list.put("uesedLeave", Float.toString(usedleave));
                        list.put("oldLeaveAmount", Float.toString(oldAmount));
                        list.put("id", hm.get("reservelaveid").toString());
                        list.put("year", hm.get("leaveyear").toString());
                        list.put("leaveFrom", "reserveLeave");
                        leaveFrom = leaveFrom + "--reserveLeave";
                        leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                        usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                        useleve.add(list);

                    } else {
                        if (usedYear == null) {
                            usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                        }
                        return useleve;
                    }

                }
                return useleve;
            } else {

                for (HashMap hm : leaveRequestManager.readReserveLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Float.parseFloat(hm.get("USEDLEAVE").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("reservelaveid").toString());
                    list.put("year", hm.get("leaveyear").toString());
                    list.put("leaveFrom", "reserveLeave");
                    leaveFrom = leaveFrom + "--reserveLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("reservelaveid").toString();
                    usedYear += "[" + hm.get("leaveyear").toString() + "==>" + usedleave + "]";
                    useleve.add(list);

                }
                for (HashMap hm : leaveRequestManager.readEmployeeAvaileAnualLeave(employeeId)) {
                    HashMap list = new HashMap();
                    availeLeave = Float.parseFloat(hm.get("availeLeave").toString());
                    usedleave += availeLeave;
                    leavereq -= availeLeave;
                    if (leavereq >= 0) {
                        requestLeave -= availeLeave;
                        usedleave = availeLeave;
                    } else {
                        usedleave = requestLeave;
                        requestLeave -= requestLeave;
                    }
                    oldAmount = Integer.parseInt(hm.get("usedleave").toString()) + usedleave;
                    list.put("uesedLeave", Float.toString(usedleave));
                    list.put("oldLeaveAmount", Float.toString(oldAmount));
                    list.put("id", hm.get("id").toString());
                    list.put("year", hm.get("year").toString());
                    list.put("leaveFrom", "anualLeave");
                    leaveFrom = leaveFrom + "--anualLeave";
                    leaveFromId = leaveFromId + "--" + hm.get("id").toString();
                    usedYear += "[" + hm.get("year").toString() + "==>" + usedleave + "]";
                    useleve.add(list);

                }
                return useleve;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;
    }

    private float totalYearDay() {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String currentDate = dateFormat.format(cal.getTime());
        int year = StringDateManipulation.getYear(currentDate);
        cal1.set(year - 1, 7, 1);
        cal2.set(year, 6, 31);
        return daysBetween(cal1.getTime(), cal2.getTime());

    }

    private float remsiningWorkingDayes(String hireDate) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String currentDate = dateFormat.format(cal.getTime());
        int year = StringDateManipulation.getYear(currentDate);
        cal2.set(year, 7, 1);
        cal1.set(year, StringDateManipulation.getMonth(hireDate), StringDateManipulation.getDate(hireDate));
        return daysBetween(cal2.getTime(), cal1.getTime());

    }

    private float daysBetween(Date d1, Date d2) {
        return (float) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

  
}

