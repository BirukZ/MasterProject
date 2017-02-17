/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

/**
 *
 * @author ONEJAVA
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.leaveEntity.HolidayEntity;
import entity.leaveEntity.LeaveControlEntity;
import entity.leaveEntity.OrganizationCalendarEntity;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Iterator;
import javax.faces.model.SelectItem;
import manager.globalUseManager.JodanTimeCalender;

/**
 *
 * @author Solo
 */
public class LeaveControl {

    public static final String DATE_FORMAT_NOW = "yyyy-MM-dd";
    private HolidayEntity holidayEntity = new HolidayEntity();
    private OrganizationCalendarEntity organizationCalendarEntity = new OrganizationCalendarEntity();
    ArrayList<OrganizationCalendarEntity> organizationCalendarList = new ArrayList<OrganizationCalendarEntity>();
    private LeaveControlEntity leaveControlEntity = new LeaveControlEntity();
    private HashMap holidayLis = new HashMap();

    public HashMap getHolidayLis() {
        return holidayLis;
    }

    public void setHolidayLis(HashMap holidayLis) {
        this.holidayLis = holidayLis;
    }

    // <editor-fold defaultstate="collapsed" desc="Organization Calendar">
    boolean holidayButNotWeekendIsCalled = false;
    String days[] = {"mon", "thu", "wed", "thr", "fri", "sat", "sun"};
    Integer leaveDys = 0;

    public ArrayList<OrganizationCalendarEntity> getOrganizationCalendarList() {
        return organizationCalendarList;
    }

    public void setOrganizationCalendarList(ArrayList<OrganizationCalendarEntity> organizationCalendarList) {
        this.organizationCalendarList = organizationCalendarList;
    }

//    public boolean grantLeave(List leaveGrantedList, int newOrOld, int noOfDays, String status) {
//        return getLeaveEntity().grantLeave(leaveGrantedList, newOrOld, noOfDays, status);
//    }
//
//    public ArrayList<LeaveEntity> readApprovedLeaveRequest() {
//        return getLeaveEntity().readApprovedLeaveRequest();
//    }
    /**
     *  this method returns the next date of the given date
     * @param date
     * @return
     */
    public String getNextDate(String date) {
        String yy = date.substring(0, 4);
        String mm = date.substring(5, 7);
        String dd = date.substring(8, 10);
        String nextDate = null;



        if (Integer.parseInt(date.substring(5, 7)) < 13) {
            if (Integer.parseInt(date.substring(8, 10)) < 30) {
                dd = String.valueOf(Integer.parseInt(date.substring(8, 10)) + 1);
            } else if (Integer.parseInt(date.substring(8, 10)) == 30) {
                mm = String.valueOf(Integer.parseInt(date.substring(5, 7)) + 1);
                dd = String.valueOf(1);
            }
        } else if (Integer.parseInt(date.substring(5, 7)) == 13) {
            if ((Integer.parseInt(date.substring(0, 4)) % 4) == 3) {
                if (Integer.parseInt(date.substring(8, 10)) < 6) {
                    dd = String.valueOf(Integer.parseInt(date.substring(8, 10)) + 1);
                } else if (Integer.parseInt(date.substring(8, 10)) == 6) {
                    yy = String.valueOf(Integer.parseInt(date.substring(0, 4)) + 1);
                    mm = String.valueOf(1);
                    dd = String.valueOf(1);
                }
            } else {
                if (Integer.parseInt(date.substring(8, 10)) < 5) {
                    dd = String.valueOf(Integer.parseInt(date.substring(8, 10)) + 1);
                } else if (Integer.parseInt(date.substring(8, 10)) == 5) {
                    yy = String.valueOf(Integer.parseInt(date.substring(0, 4)) + 1);
                    mm = String.valueOf(1);
                    dd = String.valueOf(1);
                }
            }
        }
        if (mm.length() == 1) {
            mm = '0' + mm;
        }
        if (dd.length() == 1) {
            dd = '0' + dd;
        }
        nextDate = yy + "-" + mm + "-" + dd;


        return nextDate;
    }

    /**
     *
     * @param day
     * @return
     */
    public String getDay(String day) {
        int yy = Integer.parseInt(day.toString().substring(0, 4));
        int mm = Integer.parseInt(day.toString().substring(5, 7));
        int dd = Integer.parseInt(day.toString().substring(8, 10));

        int dateNumber = 0;
        String refDate = "1900-01-01";
        int refYY = Integer.parseInt(refDate.toString().substring(0, 4));
        int refMM = Integer.parseInt(refDate.toString().substring(5, 7));
        int refDD = Integer.parseInt(refDate.toString().substring(8, 10));

        if (((yy - 1) % 4) == 3) {
            dateNumber = (((yy - refYY) + 1 + ((mm - refMM) * 2) + (dd - refDD)) % 7) + 8;
        } else {
            dateNumber = (((yy - refYY) + ((mm - refMM) * 2) + (dd - refDD)) % 7) + 8;
        }

        if (dateNumber > 7) {
            dateNumber = dateNumber % 7;
        }
        switch (dateNumber) {
            case 1:
                return days[0];
            case 2:
                return days[1];
            case 3:
                return days[2];
            case 4:
                return days[3];
            case 5:
                return days[4];
            case 6:
                return days[5];
            default:
                return days[6];

        }
    }

    /**
     * this method calculates the number of leave days between
     * leave start and end dates
     * @param dateFrom
     * @param dateTo
     * @return the number of leave days
     */
    public String numberOfDays(String dateFrom, String dateTo) {
        if ((dateTo.substring(0, 7)).equalsIgnoreCase(dateFrom.substring(0, 7))) {
            leaveDys = ((Integer.parseInt(dateTo.substring(8, 10)) - Integer.parseInt(dateFrom.substring(8, 10)) + 1));
        } else if ((dateTo.substring(0, 4)).equalsIgnoreCase(dateFrom.substring(0, 4))) {
            int monthDifference = (Integer.parseInt(dateTo.substring(5, 7))) - (Integer.parseInt(dateFrom.substring(5, 7)));
            int dateDifference = ((Integer.parseInt(dateTo.substring(8, 10)) - Integer.parseInt(dateFrom.substring(8, 10))) + 1);
            leaveDys = ((monthDifference * 30) + dateDifference);
        } else {
            int yearDifference = (Integer.parseInt(dateTo.substring(0, 4))) - (Integer.parseInt(dateFrom.substring(0, 4)));
            int monthDifference = (Integer.parseInt(dateTo.substring(5, 7))) - (Integer.parseInt(dateFrom.substring(5, 7)));
            int dateDifference = ((Integer.parseInt(dateTo.substring(8, 10)) - Integer.parseInt(dateFrom.substring(8, 10))) + 1);

            if (Integer.parseInt(dateFrom.substring(0, 4)) % 4 == 3) {
                leaveDys = ((yearDifference * 366) + (monthDifference * 30) + dateDifference);
            } else {
                leaveDys = ((yearDifference * 365) + (monthDifference * 30) + dateDifference);
            }
        }
        return String.valueOf(leaveDys);
    }

    /**
     * this method returns number of weekends between leave start and end dates
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public int getWeekend(String dateFrom, String dateTo) {
        String myDay = null;
        int weekends = 0;
        int numberOfDays = Integer.parseInt(this.numberOfDays(dateFrom, dateTo));
        for (int i = 1; i <= numberOfDays; i++) {
            myDay = this.getDay(dateFrom);
            if (myDay.equalsIgnoreCase("sat") || myDay.equalsIgnoreCase("sun")) {
                weekends += 1;
            }
            dateFrom = this.getNextDate(dateFrom);
        }
        return weekends;
    }

    /**
     *  checks wether the given date value is a weekend or not
     * @param myDate
     * @return true if the date is weekend or false otherwise
     */
    public boolean isWeekend(String myDate) {
        String myDay;
        myDay = this.getDay(myDate);
        if (myDay.equalsIgnoreCase("sat") || myDay.equalsIgnoreCase("sun")) {
            return true;
        }
        return false;
    }

    public boolean isSunday(String myDate) {
        String myDay;
        myDay = this.getDay(myDate);
        if (myDay.equalsIgnoreCase("sun")) {
            return true;
        }
        return false;
    }

    public boolean isSaturday(String myDate) {
        String myDay;
        myDay = this.getDay(myDate);
        if (myDay.equalsIgnoreCase("sat")) {
            return true;
        }
        return false;
    }

    /**
     *  checks wether the given date value is a holiday but not aweekend
     * @param variableDate
     * @return true if the date is a holiday but not weekend or false otherwise
     */
    public boolean isHolidayButNotWeekend(String variableDate) {

        boolean myReturn = false;
        if (!holidayButNotWeekendIsCalled) {
            getHolidayButNotWeekend();
        }
        OrganizationCalendarEntity organizationCalendar = new OrganizationCalendarEntity();
        Iterator<OrganizationCalendarEntity> it = organizationCalendarList.iterator();
        while (it.hasNext()) {
            organizationCalendar = it.next();

            if (variableDate.equalsIgnoreCase(organizationCalendar.getDate())) {
                myReturn = true;
            }
        }
        return myReturn;
    }

    public void getHolidayButNotWeekend() {
        OrganizationCalendarEntity organizationCalendar = new OrganizationCalendarEntity();
        ArrayList<OrganizationCalendarEntity> organizationCalendars = this.readOrganizationCalendar();
        Iterator<OrganizationCalendarEntity> it = organizationCalendars.iterator();
        while (it.hasNext()) {
            organizationCalendar = it.next();
            organizationCalendarList.add(organizationCalendar);
        }
        holidayButNotWeekendIsCalled = true;
    }

    /**
     *
     * @param dateFrom
     * @param dateTo
     * @return
     */
    public String getHolidayButNotWeekend(String dateFrom, String dateTo) {
        int holidayButNotWeekend = 0;
        String myDate = null;
        String weekEndId = null;
        int numberOfDays = Integer.parseInt(this.numberOfDays(dateFrom, dateTo));
        OrganizationCalendarEntity organizationCalendar = new OrganizationCalendarEntity();
        ArrayList<OrganizationCalendarEntity> organizationCalendars = organizationCalendarEntity.readOrganizationCalendar();
        Iterator<OrganizationCalendarEntity> it = organizationCalendars.iterator();
        while (it.hasNext()) {
            organizationCalendar = it.next();
            myDate = dateFrom;
            for (int i = 1; i <= numberOfDays; i++) {
                if (myDate.equalsIgnoreCase(organizationCalendar.getDate())) {
                    weekEndId = this.getDay(myDate);
                    if (!weekEndId.equalsIgnoreCase("sat") && !weekEndId.equalsIgnoreCase("sun")) {
                        holidayButNotWeekend += 1;
                    }
                }
                myDate = this.getNextDate(myDate);
            }
        }
        return String.valueOf(holidayButNotWeekend);
    }

    public boolean getHoliday(String dateFrom) {

        if (getHolidayLis() != null) {
            setHolidayLis(holidayEntity.getHolidayList());
        }

        try {
            if (getHolidayLis().get(dateFrom).equals(dateFrom)) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public String getLeaveDays(String dateFrom, String dateTo) {
        int numberOfDays = Integer.parseInt(this.numberOfDays(dateFrom, dateTo));
        String numberOfDayss = null;
        int weekend = this.getWeekend(dateFrom, dateTo);
        int holidayButNotWeekend = Integer.parseInt(this.getHolidayButNotWeekend(dateFrom, dateTo));
//         String weekendsAndHolydays = this.getToDate(dateFrom, numberOfDays);

        //numberOfDays -= (Integer.parseInt(weekendsAndHolydays.substring(11, 14))+ Integer.parseInt(weekendsAndHolydays.substring(15, 17)));
        numberOfDays -= (weekend + holidayButNotWeekend);
        if (numberOfDays < 10) {
            numberOfDayss = "00" + String.valueOf(numberOfDays);
        } else if (numberOfDays < 100) {
            numberOfDayss = "0" + String.valueOf(numberOfDays);
        } else {
            numberOfDayss = String.valueOf(numberOfDays);
        }
        return numberOfDayss + "-" + String.valueOf(weekend) + "-" + String.valueOf(holidayButNotWeekend);
    }

    public String getToDate(String dateFrom, int noDays) {
        String variableDate = dateFrom;
        int weekend = 0;
        int holyday = 0;
        String weekends = null;
        String holydays = null;

        if (isWeekend(variableDate)) {
            weekend++;
        } else if (isHolidayButNotWeekend(variableDate)) {
            holyday++;
        }

        int i = 0;
        while (i < noDays) {
            variableDate = this.getNextDate(variableDate);

            if (isWeekend(variableDate)) {
                weekend++;
            } else if (isHolidayButNotWeekend(variableDate)) {
                holyday++;
            } else {
                i++;
            }
        }

        if (weekend < 10) {
            weekends = "00" + String.valueOf(weekend);
        } else if (weekend < 100) {
            weekends = '0' + String.valueOf(weekend);
        }
        if (holyday < 10) {
            holydays = '0' + String.valueOf(holyday);
        }
        return variableDate + "-" + weekends + "-" + holydays;
    }

    public ArrayList<OrganizationCalendarEntity> readOrganizationCalendar() {
        return organizationCalendarEntity.readOrganizationCalendar();
    }
    //</editor-fold>

    //<editor-fold defaultstate="Collapsed" desc="Setter,Getter">
    /**
     * @return the leaveEntity
     */
    /**
     * @return the holidayEntity
     */
    public HolidayEntity getHolidayEntity() {
        return holidayEntity;
    }

    /**
     * @param holidayEntity the holidayEntity to set
     */
    public void setHolidayEntity(HolidayEntity holidayEntity) {
        this.holidayEntity = holidayEntity;
    }
    //</editor-fold>

    public ArrayList<HolidayEntity> readAllHolidays(String forYear) {
        return getHolidayEntity().readAll(forYear);
    }

    public static String calculateWorkingLastDate(Date startDate, int duration) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                date = startCal;
                strDate = dateformatter.format(date.getTime());
                while (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                        startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                        leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateformatter.format(startCal.getTime());
    }

    public static String calculateWorkingLastDateIncluDingSaturday(Date startDate, int duration) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {

            String strDate = dateformatter.format(date.getTime());
            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                date = startCal;
                strDate = dateformatter.format(date.getTime());
                while (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                        leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateformatter.format(startCal.getTime());
    }

    public static String calculateLeaveDayesExcludeHolidays(Date startDate, int duration) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                date = startCal;
                strDate = dateformatter.format(date.getTime());
                while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateformatter.format(startCal.getTime());
    }

    public static String calculateLeaveDayesIncludeHolidays(Date startDate, int duration) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                date = startCal;
                strDate = dateformatter.format(date.getTime());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return dateformatter.format(startCal.getTime());
    }

    public static String calculatLeaveDateForAddisOfficeWorker(Date startDate, int duration, boolean noteHalfDay) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        int counter = 0;
        int workingDays = 0;
        float saturdayCounter = 0;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());

            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                counter++;
                date = startCal;
                strDate = dateformatter.format(date.getTime());
                if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && !leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                    saturdayCounter += 0.5;
                }
                if (saturdayCounter == 1) {
                    counter++;
                    workingDays += 1;
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                    saturdayCounter = 0;
                }
                while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                        startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    counter++;
                    strDate = dateformatter.format(date.getTime());
                }
            }
            if (saturdayCounter == 1) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
                saturdayCounter = 0;
                while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                        startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                }
            } else if (noteHalfDay && saturdayCounter == 0.5) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
                saturdayCounter = 0;
                while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                        startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                }
            }

//            if (isSaturdayUse && hafeDay) {
//                startCal.add(Calendar.DAY_OF_MONTH, -1);
//            }
//            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
//                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
//                startCal.add(Calendar.DAY_OF_MONTH, 1);
//                strDate = dateformatter.format(date.getTime());
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());
    }

    public static String addDaysForAddisAbeba(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }

    public static String addDaysForShiftWorker(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }

    public static String addDaysForMugherOfficeWorker(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }

    public static String sayDayName(
            Date d) {
        DateFormat f = new SimpleDateFormat("EEEE");
        try {
            return f.format(d);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String now() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
        return sdf.format(cal.getTime());

    }

    public boolean isLeaveDateValid(String str_date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            Date date = (Date) sdf.parse(str_date);
            if (sdf.format(date).compareTo(now()) > 0 || sdf.format(date).compareTo(now()) == 0 ||
                    sdf.format(date).compareTo(now()) >= -25) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;

        }
    }

    public boolean isLeaveDateIsGrate(String str_date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
            Date date = (Date) sdf.parse(str_date);
            if (sdf.format(date).compareTo(now()) > 0) {
                return true;
            } else if (sdf.format(date).compareTo(now()) == 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            return false;

        }
    }

    public ArrayList<SelectItem> selectEmployeeOnLeave() {
        ArrayList<HashMap> employeeOnLeave = leaveControlEntity.selectEmployeeOnLeave();
        ArrayList<SelectItem> employeeOnLeaveList = new ArrayList<SelectItem>();
        try {
            if (employeeOnLeave != null) {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Employee On Leave"));
                for (HashMap hm : employeeOnLeave) {
                    employeeOnLeaveList.add(new SelectItem(
                            hm.get("employeeId") + "-" +
                            hm.get("LEAVETYPE") + "-" +
                            hm.get("LEAVE_ID"),
                            hm.get("employeeId").toString() + "  " +
                            hm.get("FULLNAME").toString()));
                }
            } else {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Not Available"));
            }

            return employeeOnLeaveList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public ArrayList<SelectItem> getEmployeeOnAnnualLeave() {

        try {
            ArrayList<HashMap> employeeOnLeave = leaveControlEntity.employeeOnAnnualLeave();
            ArrayList<SelectItem> employeeOnLeaveList = new ArrayList<SelectItem>();
            if (employeeOnLeave != null) {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Employee On Leave"));
                for (HashMap hm : employeeOnLeave) {
                    employeeOnLeaveList.add(new SelectItem(
                            hm.get("employeeId") + "-" +
                            hm.get("LEAVETYPE") + "-" +
                            hm.get("LEAVE_ID"),
                            hm.get("employeeId").toString() + "  " +
                            hm.get("FULLNAME").toString()));
                }
            } else {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Not Available"));
            }

            return employeeOnLeaveList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public ArrayList<SelectItem> selectEmployeeOnTwoHoursLeave() {
        ArrayList<HashMap> employeeOnLeave = leaveControlEntity.selectEmployeeOnTwoHoursLeave();
        ArrayList<SelectItem> employeeOnLeaveList = new ArrayList<SelectItem>();
        try {
            if (employeeOnLeave != null) {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Employee On Leave"));
                for (HashMap hm : employeeOnLeave) {

                    employeeOnLeaveList.add(new SelectItem(
                            hm.get("employeeId") + "#" +
                            hm.get("LEAVETYPE") + "#" +
                            hm.get("LEAVE_ID"),
                            hm.get("employeeId").toString() + "  " +
                            hm.get("FULLNAME").toString()));
                }
            } else {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Not Available"));
            }

            return employeeOnLeaveList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public ArrayList<SelectItem> selectEmployeeNotReturnOnTimeFromLeave() {
        ArrayList<HashMap> employeeOnLeave = leaveControlEntity.selectEmployeeNotReturnOnTimeFromLeave();
        ArrayList<SelectItem> employeeOnLeaveList = new ArrayList<SelectItem>();
        try {
            if (employeeOnLeave != null) {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Employee Not Return On Time"));
                for (HashMap hm : employeeOnLeave) {
                    employeeOnLeaveList.add(new SelectItem(hm.get("LEAVE_ID") + "-" +
                            hm.get("employeeId").toString(),
                            hm.get("employeeId").toString() + "  " +
                            hm.get("FULLNAME").toString()));
                }
            } else {
                employeeOnLeaveList.add(new SelectItem(null,
                        "Not Available"));
            }

            return employeeOnLeaveList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public int updateEmployeeStatus(String employeeId, String employeeStatus) {
        try {
            return leaveControlEntity.updateEmployeeStatus(employeeId, employeeStatus);
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }

    }

    public int coutWorkingLastDateIncluDingSaturday(Date startDate, int duration) {
        int count = 0;
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            for (int i = 1; i < duration; i++) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                date = startCal;
                strDate = dateformatter.format(date.getTime());
                while (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                        leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                    startCal.add(Calendar.DAY_OF_MONTH, 1);
                    strDate = dateformatter.format(date.getTime());
                    count++;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return count;
    }

    public static int countWorkingDateIncluDingSaturday(Date startDate, Date endDate) {
        Calendar startCal;
        Calendar endCal;
        startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int workDays = 0;
        LeaveControl leaveControl = new LeaveControl();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            String strDate = dateformatter.format(startCal.getTime());
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
                    !leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

        return workDays;
    }

    public static int countWorkingDate(Date startDate, Date endDate) {
        Calendar startCal;
        Calendar endCal;
        startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int workDays = 0;
        LeaveControl leaveControl = new LeaveControl();
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }

        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
            startCal.setTime(endDate);
            endCal.setTime(startDate);
        }

        do {
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            String strDate = dateformatter.format(startCal.getTime());
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
                    !leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate))) {
                ++workDays;
            }
        } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());

        return workDays;
    }

    public boolean isSundayInGerigorian(String startDate, String location, String working) {
        try {
            Calendar startCal = Calendar.getInstance();
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(startDate);
            startCal.setTime(date);
            if (location != null && working != null) {
                if (location.equals("AddisAbeba") || (location.equals("Mugher") && working.equals("Shift"))) {
                    if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                        return true;
                    } else {
                        return false;
                    }
                } else if (location.equals("Mugher") && working.equals("Office")) {
                    if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            return true;

        }
    }

    public boolean isSaturdayInGerigorian(String startDate) {
        try {
            Calendar startCal = Calendar.getInstance();
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(startDate);
            startCal.setTime(date);

            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    /**
     * accepts a valid String of format <b>yyyy-MM-DD</b>
     * and creates a corresponding GregorianCalendar object
     * @return The corresponding GregorianCalendar object for the String <b>date</b>
     */
    public Calendar convertDateToCalendar(String date) {
        try {
            String dateParameters[] = date.split("-");
            int year = Integer.parseInt(dateParameters[0]);
            int month = Integer.parseInt(dateParameters[1]);
            int day = Integer.parseInt(dateParameters[2]);
            return new GregorianCalendar(year, month, day);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int getWorkingDaysBetweenTwoDates(Date startDate, Date endDate) {
        Calendar startCal;
        Calendar endCal;
        startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endCal = Calendar.getInstance();
        endCal.setTime(endDate);
        int workDays = 0;
//        //Return 0 if start and end are the same
        if (startCal.getTimeInMillis() == endCal.getTimeInMillis()) {
            return 0;
        }
//        if (startCal.getTimeInMillis() > endCal.getTimeInMillis()) {
//            startCal.setTime(endDate);
//            endCal.setTime(startDate);
//        }

        while (startCal.getTimeInMillis() < endCal.getTimeInMillis()) {
            startCal.add(Calendar.DAY_OF_MONTH, 1);
//            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) {
//                ++workDays;
//            }
            if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                ++workDays;
            }
        }

        return workDays;
    }

    /**
     * add one day and return next working day for addis
     * abeba employees
     * @param arag
     */
    public static String nextAddisWorkingDay(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }

    /**
     * add one day and return next working day for Mugher
     *  employees
     * @param arag
     */
    public static String nextMugherWorkingDay(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ||
                    startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }





 
    /**
     * add one day and return next working day for Mugher
     *  employees
     * @param arag
     */
    public static String nextShiftWorkingDay(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }
     public static String checkAddisWorkingDay(Date startDate) {
        //String dateFr, String leaveDays) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        Calendar startCal = Calendar.getInstance();
        LeaveControl leaveControl = new LeaveControl();
        startCal.setTime(startDate);
        Calendar date = startCal;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            String strDate = dateformatter.format(date.getTime());
            while (leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(strDate)) ||startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY ) {
                startCal.add(Calendar.DAY_OF_MONTH, 1);
                strDate = dateformatter.format(date.getTime());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateformatter.format(startCal.getTime());

    }

    public static float calculateWorkingDateOfficeWorker(Date startDate, Date endDate) {
        LeaveControl leaveControl = new LeaveControl();
        float workingDays = 0;
        Calendar startCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endDateCal.setTime(endDate);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        endDateCal.add(Calendar.DAY_OF_MONTH, 1);
        try {
            while (startCal.before(endDateCal)) {
                if ((startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) &&
                        !leaveControl.getHoliday(dateformatter.format(startCal.getTime()))) {
                    if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
                        workingDays += 8;
                    } else {
                        workingDays += 4.5;
                    }
                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public static float calculateWorkingDateShiftWorker(Date startDate, Date endDate) {
        LeaveControl leaveControl = new LeaveControl();
        float workingDays = 0;
        Calendar startCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endDateCal.setTime(endDate);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        endDateCal.add(Calendar.DAY_OF_MONTH, 1);
        try {
            while (startCal.before(endDateCal)) {
                if ((startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY) &&
                        !leaveControl.getHoliday(dateformatter.format(startCal.getTime()))) {

                    workingDays += 8;

                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public static int calculateWorkingDateShifteWorker(Date startDate, Date endDate) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        LeaveControl leaveControl = new LeaveControl();
        int workingDays = 0;
        Calendar startCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endDateCal.setTime(endDate);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            while (!startCal.after(endDateCal)) {
                int day = startCal.get(Calendar.DAY_OF_WEEK);
                if ((day != Calendar.SUNDAY) && !leaveControl.isHolidayButNotWeekend(
                        jodanTimeCalender.ChangeDateToEthiopic(dateformatter.format(startCal.getTime())))) {
                    workingDays++;
                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public static int calculateWorkingDate(Date startDate, Date endDate) {
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        LeaveControl leaveControl = new LeaveControl();
        int workingDays = 0;
        Calendar startCal = Calendar.getInstance();
        Calendar endDateCal = Calendar.getInstance();
        startCal.setTime(startDate);
        endDateCal.setTime(endDate);
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            while (!startCal.after(endDateCal)) {
                int day = startCal.get(Calendar.DAY_OF_WEEK);
                if ((day != Calendar.SUNDAY) && !leaveControl.isHolidayButNotWeekend(
                        jodanTimeCalender.ChangeDateToEthiopic(dateformatter.format(startCal.getTime())))) {
                    workingDays++;
                }
                startCal.add(Calendar.DAY_OF_MONTH, 1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return workingDays;
    }

    public static String wrkingDaysBetweenTwoDates(Date startDate, int requestLeaveAmout) {
        Calendar startCal;
        JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
        LeaveControl leaveControl = new LeaveControl();
        startCal = Calendar.getInstance();
        startCal.setTime(startDate);
        int wrkingDays = 0;
        float saturDayCounter = 0;
        SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
        do {
            if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY &&
                    startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY && !leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(dateformatter.format(startCal.getTime())))) {
                wrkingDays += 1;
            } else if (startCal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY && !leaveControl.isHolidayButNotWeekend(jodanTimeCalender.ChangeDateToEthiopic(dateformatter.format(startCal.getTime())))) {
                saturDayCounter += 0.5;
            }
            if (saturDayCounter == 1) {
                wrkingDays += 1;
                saturDayCounter = 0;
            }

            startCal.add(Calendar.DAY_OF_MONTH, 1);
        } while (wrkingDays < requestLeaveAmout);
        startCal.add(Calendar.DAY_OF_MONTH, -1);
        return dateformatter.format(startCal.getTime());
    }
}
