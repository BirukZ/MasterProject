/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.globalUseManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
//import javax.swing.JOptionPane;
import org.joda.time.DateTime;

/**
 *
 * @author 
 */
public class GregorianCalendarManipulation {

    /**
     * @return <b>0</b> if the two dates are equal,
     *<br> <b>1</b> if dateTwo is after  dateOne,
     *<br> <b>-1</b> if dateTwo is before  dateOne
     */
    public static int compareDates(String dateOne, String dateTwo) {
        return compareDates(convertDateToCalendar(dateOne), convertDateToCalendar(dateTwo));
    }

    /**
     * @return <b>0</b> if the two dates are equal,
     *<br> <b>1</b> if dateTwo is after  dateOne,
     *<br> <b>-1</b> if dateTwo is before  dateOne
     */
    public static int compareDates(Calendar dateOne, Calendar dateTwo) {
        if (dateOne.before(dateTwo)) {
            return 1;
        } else if (dateOne.after(dateTwo)) {
            return -1;
        } else {//if they equal
            return 0;
        }
    }

    /**
     * accepts a valid String of format <b>yyyy-MM-DD</b>
     * and creates a corresponding GregorianCalendar object
     * @return The corresponding GregorianCalendar object for the String <b>date</b>
     */
    public static Calendar convertDateToCalendar(String date) {
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

    /**
     * Accepts a Calendarand creates a corresponding String Object of format <b>yyyy-MM-DD</b>
     * @return The corresponding String of format <b>yyyy-MM-DD</b> <b>date</b>
     */
    public static String convertCalendarToString(Calendar date) {
        return Integer.toString(date.get(Calendar.YEAR)) + "-" + Integer.toString(date.get(Calendar.MONTH + 1)) + "-" + Integer.toString(date.get(Calendar.DATE));
    }

    public static int calaculateYearDifference(String startDate) {
        Calendar todayCal = new GregorianCalendar();
        Calendar startDateCal = convertDateToCalendar(startDate);
        return calaculateYearDifference(startDateCal, todayCal);
    }

    public static int calaculateYearDifference(Calendar startDateCal) {
        Calendar todayCal = new GregorianCalendar();
        return calaculateYearDifference(startDateCal, todayCal);
    }

    public static int calaculateYearDifference(String startDate, String endDate) {
        Calendar startDateCal = convertDateToCalendar(startDate);
        Calendar endDateCal = convertDateToCalendar(endDate);
        return calaculateYearDifference(startDateCal, endDateCal);

    }

    public static int calaculateYearDifference(Calendar startDate, Calendar endDate) {
        int differenceInYear = endDate.get(Calendar.YEAR) - startDate.get(Calendar.YEAR);
        if ((startDate.get(Calendar.MONTH) > endDate.get(Calendar.MONTH)) ||
                ((startDate.get(Calendar.MONTH) == endDate.get(Calendar.MONTH) &&
                startDate.get(Calendar.DAY_OF_MONTH) > endDate.get(Calendar.DAY_OF_MONTH)))) {
            differenceInYear = differenceInYear - 1;
        }
        return differenceInYear;
    }

    public static int calaculateMonthDifference(String startDate, String endDate) {
        return calaculateMonthDifference(convertDateToCalendar(startDate), convertDateToCalendar(endDate));
    }

    public static int calaculateMonthDifference(Calendar startDate) {
        return calaculateMonthDifference(startDate, new GregorianCalendar());
    }

    public static Calendar addDaysToGivenDate(Calendar startDate, int daysToAdd) {
        startDate.add(Calendar.DATE, daysToAdd);
        return startDate;//
    }

    /**
     * Calculates the number of months between two dates
     * @return the month difference between <b>endDate</b> and <b>startDate</b>.
     * <br> If endDate is before startDate, the returned value is negative integer.
     * <br> If function floors the difference; it does not approximate.
     * @param <b>endDate</b> end date
     * @param <b>startDate</b> start date
     */
    public static int calaculateMonthDifference(Calendar startDate, Calendar endDate) {
        int yearDifference = calaculateYearDifference(startDate, endDate);
        return yearDifference * 12 + (int) Math.abs(startDate.get(Calendar.MONTH) - endDate.get(Calendar.MONTH));
    }

    /**
     * Calculates the number of days between two dates
     * @return the date difference between <b>endDate</b> and <b>startDate</b>.<br> If endDate is before startDate, the returned value is negative integer.
     * @param <b>endDate</b> end date
     * @param <b>startDate</b> start date
     */
    public static int calaculateDateDifference(String startDate, String endDate) {
        return calaculateDateDifference(convertDateToCalendar(startDate), convertDateToCalendar(endDate));
    }

    /**
     * Calculates the number of days between startDate and the current date
     * @return the date difference between <b>endDate</b> and <b>startDate</b>.<br> If the date is before startDate, the returned value is negative integer.
     * @param <b>startDate</b> the date to be compared with today
     */
    public static int calaculateDateDifference(Calendar startDate) {
        return calaculateDateDifference(startDate, new GregorianCalendar());
    }

    /**
     * Calculates the number of days between two dates
     * @return the date difference between <b>endDate</b> and <b>startDate</b>.
     * <br> If <b>endDate</b> is before <b>startDate</b>, the returned value is negative integer.
     * @param <b>endDate</b> end date
     * @param <b>startDate</b> start date
     */
    public static int calaculateDateDifference(Calendar startDate, Calendar endDate) {
        long milliSecondDiffrence = (endDate.getTime()).getTime() - (startDate.getTime()).getTime();
        return (int) (milliSecondDiffrence / (1000 * 60 * 60 * 24));
    }

    /**
     * converts Gregorian to Ethiopian date
     * @param gregDate date to be converted
     * @return the corresponding Ethiopian date in String format
     */
    public static String gregorianToEthiopian(String gregDate) {
        return StringDateManipulation.todayInEC(gregDate);
    }

    /**
     * converts ethiopian date to Gregorian
     * @param ethDate date to be converted
     * @return the corresponding Gregorian date in String format
     */
    public static String ethiopianToGregorian(String ethDate) {
        return DateConverter.fromECToGC(ethDate);
    }

    /**
     * used for sutract Gregorian year
     * @param year
     * @return
     */
    public static String subtractGregorianYear(int year) {
        Calendar now = Calendar.getInstance();
        Calendar calendar = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
        //"Before Subtracting date is: ");
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMMM-yyyy hh:mm");
        // subtract 2 Year
        calendar.add(Calendar.YEAR, -year);
        //"After Subtracting date is: ");
        formatter = new SimpleDateFormat("yyyy-MM-dd");  // ("d-MMMM-yyyy hh:mm");
        return formatter.format(calendar.getTime());
    }

    public static String subtractGregorianYearandAge(int year, String date)
    {

        Calendar now = convertDateToCalendar(date);
        Calendar calendar = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
        //"Before Subtracting date is: ");
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMMM-yyyy hh:mm");
        // subtract 2 Year
        calendar.add(Calendar.YEAR, -year);
        //"After Subtracting date is: ");
        formatter = new SimpleDateFormat("yyyy-MM-dd");  // ("d-MMMM-yyyy hh:mm");
        return formatter.format(calendar.getTime());
    }

    public static String subtractGregorianMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, -month);
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd ");
        return simpleFormatter.format(cal.getTime());
    }

    public static String addtionGregorianMonth(int month) {
        Calendar cal = Calendar.getInstance();
        cal = Calendar.getInstance();
        cal.add(Calendar.MONTH, +month);
        SimpleDateFormat simpleFormatter = new SimpleDateFormat("yyyy-MM-dd ");
        return simpleFormatter.format(cal.getTime());
    }

    public static String addGregorianYearandAge(int month, String date) {

        Calendar now = convertDateToCalendar(date);
        Calendar calendar = new GregorianCalendar(now.get(Calendar.YEAR), now.get(Calendar.MONTH), now.get(Calendar.DATE));
        //"Before adding date is: ");
        SimpleDateFormat formatter = new SimpleDateFormat("d-MMMM-yyyy hh:mm");
        calendar.add(Calendar.MONTH, +month);
        //"After adding month is: ");
        formatter = new SimpleDateFormat("yyyy-MM-dd");  // ("d-MMMM-yyyy hh:mm");
        return formatter.format(calendar.getTime());
    }

    public static String getDuration(int month, int day, int year) throws Exception {
        /* input calendar date */
        month--; // following the 0-based rule
        Calendar cal = new GregorianCalendar(year, month, day);

        /* date today */
        java.util.Date today = new java.util.Date();

        /* year now */
        SimpleDateFormat sdfYear = new SimpleDateFormat("yyyy");
        int intYear = Integer.parseInt(sdfYear.format(today));

        /* month now */
        SimpleDateFormat sdfMonth = new SimpleDateFormat("MM");
        int intMonth = Integer.parseInt(sdfMonth.format(today));
        intMonth--; // following the 0-based rule

        /* day now */
        SimpleDateFormat sdfDay = new SimpleDateFormat("dd");
        int intDay = Integer.parseInt(sdfDay.format(today));

        /* calendar date now */
        Calendar now = new GregorianCalendar(intYear, intMonth, intDay);

        /* years duration */
        int yyyy = intYear - year;

        /* array of days in 12 months */
        int[] months = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        /*
         * an indicator if given date has already occurred. (-1) - if given date
         * is greater than the current date; 0 - if given date has not yet
         * occurred or if it's equal to the current date.
         */
        int factor = 0;

        int mm = 0; // month duration

        int dd = 0; // day duration

        /* determine if given date is greater than or equal to the current date */
        if ((month > intMonth) || (month == intMonth && day > intDay)) {
            factor = -1;
            yyyy += factor;
        }

        /* throw if any of the following exceptions occur */
        if (month > 12) {
            throw new Exception("Invalid input month");
        } else if (day > months[month]) {
            throw new Exception("Invalid input day");
        } else if (yyyy < 0) {
            throw new Exception("Invalid input date");
        }

        /*
         * if the given date has already passed or if it's equal to the current
         * date
         */
        if (factor == 0) {
            // compute for days in between the given and the current date
            dd = now.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR);
            /* determine if the current year is a leap year */
            if ((intYear % 4) == 0) {
                months[1]++; // increment the days in February by 1
            }
            /*
             * compute for day duration and month duration between the given
             * date and the given day of the current month
             */
            for (int i = month; i <= intMonth; i++) {
                if (dd >= months[i]) {
                    dd -= months[i];
                    mm++;
                }
            }
            /*
             * if computed month duration is more than 12, finalize values for
             * year and month duration
             */
            if (mm >= 12) {
                yyyy += (mm / 12);
                mm %= 12;
            }
        } else { // if the given date is greater than the current date
            intYear--; // derive previous year
                /* set Calendar date for December 31 of the previous year */
            Calendar prev = new GregorianCalendar(intYear, 11, 31);
            /*
             * compute the days in between the given date last year and the
             * current date
             */
            dd = (prev.get(Calendar.DAY_OF_YEAR) - cal.get(Calendar.DAY_OF_YEAR)) + now.get(Calendar.DAY_OF_YEAR);
            /* determine if previous year is a leap year */
            if ((intYear % 4) == 0) {
                months[1]++; // increment the days in February by 1
            }
            /*
             * compute for day duration and month duration between the given
             * date and the given day in December of the previous year
             */
            for (int i = month; i <= 11; i++) {
                if (dd >= months[i]) {
                    dd -= months[i];
                    mm++;
                }
            }
            intYear++; // set the value back to the current year
                /* determine if current year is a leap year */
            if ((intYear % 4) == 0) {
                months[1]++; // increment the days in February by 1
            }
            /*
             * compute for day duration and month duration between the given day
             * in January of the current year and the current date
             */
            for (int i = 0; i <= intMonth; i++) {
                if (dd >= months[i]) {
                    dd -= months[i];
                    mm++;
                }
            }
            /*
             * if computed month duration is more than 12, finalize values for
             * year and month duration
             */
            if (mm >= 12) {
                yyyy += (mm / 12);
                mm %= 12;
            }
        }

        /* computed duration in years, months and days */
        return yyyy + " Year(s), " + mm + " Month(s), and " + dd + " Day(s) ";
    }

    public static int calculateExpriance(String date) {
        return JodanTimeCalender.yearDiffrenceStartingFromNow(date);
    }

    public static double monthsBetween(Calendar date1, Calendar date2) {
        double monthsBetween = 0;
        //difference in month for years
        monthsBetween = (date1.get(Calendar.YEAR) - date2.get(Calendar.YEAR)) * 12;
        //difference in month for months
        monthsBetween += date1.get(Calendar.MONTH) - date2.get(Calendar.MONTH);
        //difference in month for days
        if (date1.get(Calendar.DAY_OF_MONTH) != date1.getActualMaximum(Calendar.DAY_OF_MONTH) && date1.get(Calendar.DAY_OF_MONTH) != date1.getActualMaximum(Calendar.DAY_OF_MONTH)) {
            monthsBetween += ((date1.get(Calendar.DAY_OF_MONTH) - date2.get(Calendar.DAY_OF_MONTH)) / 31d);
        }
        return monthsBetween;
    }

    /////////////////////////////////////BirukTestForYearMonthAndDateCalculation////////////////////////////////////////////
    public static int[] getDateDifferenceInDDMMYYYY(Date date1, Date date2) {

        int[] monthDay = {31, -1, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        Calendar fromDate;
        Calendar toDate;
        int increment = 0;
        int[] ageDiffArr = new int[3];

        int year;
        int month;
        int day;

        Calendar d1 = GregorianCalendar.getInstance();
        d1.setTime(date1);

        Calendar d2 = GregorianCalendar.getInstance();
        d2.setTime(date2);

        if (d1.getTime().getTime() > d2.getTime().getTime()) {
            fromDate = d2;
            toDate = d1;
        } else {

            fromDate = d1;
            toDate = d2;
             
        }
    

        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH))
        {
            increment = monthDay[fromDate.get(Calendar.MONTH)];
            
        }

        GregorianCalendar cal = new GregorianCalendar();
        boolean isLeapYear = cal.isLeapYear(fromDate.get(Calendar.YEAR));

        if (increment == -1)
        {
            if (isLeapYear)
            {
                increment = 29;
            } else {
                increment = 28;
            }
        }
        

// DAY CALCULATION
        if (increment != 0)
        {
            day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
            increment = 1;
        } else {
            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
        }
         

// MONTH CALCULATION
//        if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH))
//        {
//            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
//            increment = 1;
//            JOptionPane.showMessageDialog(null, month+"increment"+increment);
//        } else {
//            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
//            increment = 0;
//             JOptionPane.showMessageDialog(null, month+"increment"+increment);
//
//        }
         
         if ((fromDate.get(Calendar.MONTH) ) > toDate.get(Calendar.MONTH))
         {
            month = (toDate.get(Calendar.MONTH) ) - (fromDate.get(Calendar.MONTH));
            increment = 1;
        } else {
            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) );
            increment = 0;
        }

// YEAR CALCULATION
        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);

        ageDiffArr[0] = day;
        ageDiffArr[1] = month;
        ageDiffArr[2] = year;

        return ageDiffArr;      // RESULT AS DAY, MONTH AND YEAR in form of Array

    }
   ///////////////////////////////////////////////NewlAddedFunctionThatCalculateYearDayCalculation//////////////
     public static int getYear(String _date) {
        return Integer.parseInt(_date.substring(0, _date.indexOf('-')));
    }

    /**Extracts the month value from _date
     *@param _date a string date in yyyy-MM-dd format
     *@return returns the MM from yyyy-MM-dd as integer
     */
    public static int getMonth(String _date) {
        return Integer.parseInt(_date.substring(_date.indexOf('-') + 1, _date.lastIndexOf('-')));
    }
    public static int getDate(String _date) {
        return Integer.parseInt(_date.substring(_date.lastIndexOf('-') + 1));
    }

     public static int datesDifferenceInDays(String _date1, String _date2)
     {
        int yearDif = getYear(_date1) - getYear(_date2);
        int monthDif = (yearDif > 0) ? getMonth(_date1) - getMonth(_date2) : getMonth(_date2) - getMonth(_date1);
        int dayDif = (yearDif > 0) ? getDate(_date1) - getDate(_date2) : getDate(_date2) - getDate(_date1);
        int year = Math.abs(yearDif);
        int month = monthDif;
        int day = dayDif;
        if (day < 0) {
            day = 30 + day;
            month = month - 1;
        }
        if (month < 0) {
            month = 12 + month;
            year = year - 1;
        }
        if (year < 0) {
            if (monthDif < 0) {
                day = Math.abs(dayDif);
                month = Math.abs(monthDif);
            } else {
                month = 12 - month;
            }
            year = 0;
        }
        return year * 365 + month * 30 + day;
    }


    public static String calculateYearAndMonthAndDateDifference(String date1, String date2) {
        int difference = datesDifferenceInDays(date1, date2);
        return calculateYearAndMonthAndDateDifference(difference);
    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

       public static int [] calculateYearAndMonthAndDateDifferenceReturnTypeArrayListIntType(String date1, String date2) {
        int difference = datesDifferenceInDays(date1, date2);
        return calculateYearAndMonthAndDateDifferenceByArrayLIstInteger(difference);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public static String [] calculateYearAndMonthAndDateDifferenceReturnTypeArrayList(String date1, String date2) {
        int difference = datesDifferenceInDays(date1, date2);
       
        return calculateYearAndMonthAndDateDifferenceByArrayLIst(difference);
    }
    public static String [] calculateYearAndMonthAndDateDifferenceReturnTypeArrayListForLeave(String date1, String date2) {
        int difference = datesDifferenceInDays(date1, date2);
        return calculateYearAndMonthAndDateDifferenceByArrayLIstForLeave(difference);
    }

    public static String calculateYearAndMonthAndDateDifference(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (difference % 365) % 30;
         String [] ageDiffArr = new String [3];

        String years = (year == 1) ? year + " Year" : (year > 0) ? year + " Years " : "0 Years ";
        String months = (month == 1) ? month + " Month" : (month > 0) ? month + " Months " : "0 Months ";
        String dates = (date == 1) ? date + " Day " : (date > 0) ? date + " Days " : "0 Days ";
        String experiance = years + "---" + months + "---" + dates;
        return experiance;

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public static String calculateYearAndMonthAndDateDifferenceRecuritmentForOneExpirance(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (difference % 365) % 30;
         String [] ageDiffArr = new String [3];

        String years = (year == 1) ? year + " Year" : (year > 0) ? year + " Years " : "0 Years ";
        String months = (month == 1) ? month + " Month" : (month > 0) ? month + " Months " : "0 Months ";
        String dates = (date == 1) ? date + " Day " : (date > 0) ? date + " Days " : "0 Days ";

        String experiance = years + "---" + months + "---" + dates;
        return experiance;

    }


    ////////////////////////////////////////////////////BirukForRecuritmentExpirance//////////////////////////////////////

     public static String calculateYearAndMonthAndDateDifferenceRecuritment(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (((difference % 365) % 30));
         String [] ageDiffArr = new String [3];

        String years = (year == 1) ? year + " Year" : (year > 0) ? year + " Years " : "0 Years ";
        String months = (month == 1) ? month + " Month" : (month > 0) ? month + " Months " : "0 Months ";
        String dates = (date == 1) ? date + " Day " : (date > 0) ? date + " Days " : "0 Days ";

        String experiance = years + "---" + months + "---" + dates;
        return experiance;

    }

    ///////////////////////////////////////BirukInt////////////////////////////////////////////////////////


      public static int [] calculateYearAndMonthAndDateDifferenceByArrayLIstInteger(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (difference % 365) % 30;
        int [] ageDiffArr = new int [3];

        String years = (year == 1) ? year + " " : (year > 0) ? year + "" : "0";
        String months = (month == 1) ? month + " " : (month > 0) ? month + "" : "0  ";
        String dates = (date == 1) ? date + "" : (date > 0) ? date + "" : "0";
        String experiance = years + "-" + months + "-" + dates;
        ageDiffArr[0] = Integer.parseInt(dates);
        ageDiffArr[1] = Integer.parseInt(months);
        ageDiffArr[2] = Integer.parseInt(years);

        return ageDiffArr;

        //return experiance;

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////
      public static String [] calculateYearAndMonthAndDateDifferenceByArrayLIst(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (difference % 365) % 30;
         String [] ageDiffArr = new String [3];

        String years = (year == 1) ? year + " " : (year > 0) ? year + "" : "0";
        String months = (month == 1) ? month + " " : (month > 0) ? month + "" : "0  ";
        String dates = (date == 1) ? date + "" : (date > 0) ? date + "" : "0";
        String experiance = years + "-" + months + "-" + dates;
        ageDiffArr[0] = dates;
        ageDiffArr[1] = months;
        ageDiffArr[2] = years;

        return ageDiffArr;

        //return experiance;

    }
       public static String [] calculateYearAndMonthAndDateDifferenceByArrayLIstForLeave(int difference) {
        int year = (difference / 365);
        int month = (difference % 365) / 30;
        int date = (difference % 365) % 30;
         String [] ageDiffArr = new String [3];

        String years = (year == 1) ? year + "" : (year > 0) ? year + "" : "0";
        String months = (month == 1) ? month + "" : (month > 0) ? month + "" : "0";
        String dates = (date == 1) ? date + "" : (date > 0) ? date + "" : "0";
        String experiance = years + "-" + months + "-" + dates;
        ageDiffArr[0] = dates;
        ageDiffArr[1] = months;
        ageDiffArr[2] = years;

        return ageDiffArr;

        //return experiance;

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

              }
