/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package unitTest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author Administrator
 */
public class LeaveRequest {

    public static void main(String args[]) {
        LeaveRequest difference = new LeaveRequest();
        System.out.println(difference.com(2012));
    }

    public int com(int year) {
        long now = System.currentTimeMillis();
        // build Calendar object
        Calendar c = Calendar.getInstance();
        c.set(year, 7, 1);
        long then = c.getTimeInMillis();
        long milli = now - then;
        int nbDays = (int) (milli / (24 * 60 * 60 * 1000));
        return nbDays;
    }

    LeaveRequest() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        System.out.println(dateFormat.format(cal.getTime()));
//        Calendar cal1 = new GregorianCalendar();
//        Calendar cal2 = new GregorianCalendar();
//
////        cal1.set(2012,7 , 1);
////        cal2.set(2013, 3, 26);
//        cal1.set(2012, 7, 1);
//        cal2.set(2013, 6, 31);
//        System.out.println("Days= " + daysBetween(cal1.getTime(), cal2.getTime()));
    }

    public float daysBetween(Date d1, Date d2) {
        return (float) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }
}
