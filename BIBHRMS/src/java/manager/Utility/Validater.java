/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.Utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Abushu
 */
public class Validater {

    public static String NAME = "name";
    public static String EMAIL = "email";
    public static String WOREDA = "woreda";
    public static String PASSPORT = "passport";
    public static String NUMBER = "number";
    public static String WEBSITE = "website";
    public static String POBOX = "pobox";
    public static String HOUSENUMBER = "houseNumber";
    public static String KEBELE = "kebele";
    public static String DECIMAL = "decimal";
    public static String DAY = "day";
    public static String YEAR = "year";
    public static String DATE = "Date";
    public static String ALPHA_NUMERIC = "ALPHA_NUMERIC";
    public static String TIME = "TIME";

    public static int isDataValid(Object dataToValidate, String type, boolean allowNull) {
        int result = 0;
        String value;
        if (dataToValidate != null) {
            value = dataToValidate.toString();
        } else {
            value = "";
        }

        value = value.trim();
        if (value == null || value.equalsIgnoreCase("NL")) {
            value = "";
        }
        if (type.equals("") && value.equals("") && allowNull == false) {
            result = 1;
        } else if (type.equals("") == false) {
            if (value.equals("") && allowNull == false) {
                result = 1;
            } else {
                if (!value.equals("")) {
                    if (!value.matches(getFormatOfType(type))) {
                        result = 2;
                    } else {
                        if (type.equalsIgnoreCase("Date")) {
                            int date = 0;
                            int month = 0;
                            month = Integer.parseInt(value.substring(5, 7));
                            date = Integer.parseInt(value.substring(8, 10));
                            if (date <= 0 || date > 31 || month <= 0 || month > 12) {
                                result = 2;
                            }
                        }
                    }
                }
            }
        }
        return result;
    }
///////////////////////////////////////////////////////////

    private static String getFormatOfType(String type) {
        String format = "";
        if (type.equalsIgnoreCase("Name")) {
//            format = "[A-Za-z-\\.\\&\\/ ]{1,30}";
            format = "^[A-Za-z-\\.\\&\\/ ]{1,1000}$|^[ሀ-ፖ\\.\\&\\/ ]{1,1000}$";
        } else if (type.equalsIgnoreCase("Email")) {
            format = "[a-zA-Z0-9-\\.]+@[a-zA-Z]{2,5}+\\.[a-zA-Z ]{3}+$|^[a-zA-Z0-9-\\.]+@[a-zA-Z]+\\.[a-zA-Z]{2,5}+\\.[a-zA-Z ]{3}";
        } else if (type.equalsIgnoreCase("phone") || type.equalsIgnoreCase("Fax")) {
            format = "^\\+?251\\-?\\-?[1-9][0-9]{2}\\-?[0-9]{6}|$|" +
                    "^[0][1-9][0-9]{2}\\-?[0-9]{6}|$|" +
                    "^\\+?[0-9]{1,3}\\-\\?\\-?[0-9]{3}\\-?[0-9]{6}$";
        } else if (type.equalsIgnoreCase("Woreda")) {
            format = "[A-Za-z- ]{1,25}";
        } else if (type.equalsIgnoreCase("Passport")) {
            format = "^[0-9]{1,15}+$";
        } else if (type.equalsIgnoreCase("Number")) {
            format = "^[0-9\\. ]+$";
        } else if (type.equalsIgnoreCase("website")) {
            format = "^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,10}+\\.[a-zA-Z ]{2}+$|^[w]{3}+\\.[a-zA-Z0-9-]+\\.[a-zA-Z ]{2,10}+$";
        } else if (type.equalsIgnoreCase("pobox")) {
            format = "^[0-9]{1,16}+[a-zA-Z]{1,20}+[0-9 ]+$|^[0-9 ]+$";
        } else if (type.equalsIgnoreCase("HouseNumber")) {
            format = "^[0-9 ]+$|^[0-9]+/[0-9a-zA-Z ]+$";
        } else if (type.equalsIgnoreCase("Kebele")) {
            format = "^[0-9 ]+$|^[0-9]+/[0-9a-zA-Z ]+$";
        } else if (type.equalsIgnoreCase("ID")) {
            format = "^[a-zA-Z]{2,10}+\\_[0-9]+$|^[a-zA-Z]{2,10}+\\_[a-zA-Z]{2,10}+\\_[0-9]+$";
        } else if (type.equalsIgnoreCase("Decimal")) {
            format = "^[0-9 ]+\\.[0-9]+$|^[0-9]+$";
        } else if (type.equalsIgnoreCase("Day")) {
            format = "^[a-zA-Z ]+$|^[0-9 ]+$";
        } else if (type.equalsIgnoreCase("Year")) {
            format = "[0-9]{4}";
        } else if (type.equalsIgnoreCase("Date")) {
            format = "[0-9]{4}+\\-[0-1]{1}[0-9]{1}+\\-[0-3]{1}[0-9]{1}";
        } else if (type.equalsIgnoreCase("ALPHA_NUMERIC")) {
//            format="^[a-zA-Z0-9]+\\-\\/\\.\\_";
            format = "[a-zA-Z0-9ሀ-ፖ \\-\\_\\/\\.\\& ]{1,1000}$";
        } else if (type.equalsIgnoreCase("TIME")) {
//            format="^[a-zA-Z0-9]+\\-\\/\\.\\_";
            format = "[0-2]{1}[0-9]{1}:[0-5]{1}[0-9]{1}";
        } else {
//            format="";
        }

        return format;
    }

    public static int compareDates(String date1, String date2) throws Exception {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date toDay = new Date();//current Date
        Date dateOne = dateFormat.parse(date1);
        Date dateTwo = dateFormat.parse(date2);
        int x=0;
        //===========================================================
         //if today =dateOne=dateTwo
        if(toDay.equals(dateOne) && dateOne.equals(dateTwo)) x=1;
        //===========================================================
         //if today =dateOne<dateTwo
        if(toDay.equals(dateOne) && dateOne.before(dateTwo)) x=1;
         //if today <dateOne=dateTwo
        if(toDay.before(dateOne) && dateOne.equals(dateTwo)) x=1;
         //if today <dateOne<dateTwo
        if(toDay.before(dateOne) && dateOne.before(dateTwo)) x=1;

        //===========================================================
         //if toDay<dateOne<dateTwo
        else if (toDay.before(dateTwo) && dateTwo.before(dateOne)) x=-1;
           //if toDay<dateOne<dateTwo
        else if (toDay.before(dateTwo) && dateTwo.before(dateOne)) x=-1;
           //if toDay<dateOne<dateTwo
        else if (toDay.before(dateTwo) && dateTwo.before(dateOne)) x=-1;
        //===========================================================
          //if toDay<dateTwo<dateTwo
        else if (dateOne.before(toDay) && toDay.before(dateTwo)) x=1;
          //if dateOne<dateTwo<dateOne
        else if (dateOne.before(dateTwo) && dateTwo.before(dateOne)) x=1;
        //if dateTwo<toDay<dateTwo
        else if (dateTwo.before(toDay) && toDay.before(dateTwo)) x=1;
        //if dateTwo<today<dateOne
         else if (dateTwo.before(dateTwo) && dateTwo.before(dateOne)) x=1;

        else if (dateOne.after(dateTwo)) x=-1;
        return 0;
    }
}
