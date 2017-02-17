/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.globalUseManager;

/**
 *
 * @author Dereje
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

public class Gcalendar {

    private int Gday;
    private int Gmnz;
    private int Gyr;
    private int Gwkday;
    private int Eday;
    private int Emnz;
    private int Eyr;
    private int Ewkday;
    private final int Gd = 29;
    private final int Gm = 2;
    private final int Gy = 1980;
    private final int Gw = 5;
    private final int Ed = 21;
    private final int Em = 6;
    private final int Ey = 1972;
    private String errMsg;

    public Gcalendar(String ddmmyy) {
        String[] dt = ddmmyy.split("-");
//receives the input string and extracts the date from it.
        if (dt.length == 3) {
            this.Eday = Integer.parseInt(dt[0]);
            this.Emnz = Integer.parseInt(dt[1]);
            this.Eyr = Integer.parseInt(dt[2]);
        } else {
            errMsg = "Invalid date input.";
        }
    }

    public Gcalendar() {
    }
    String strx;
    /**
     * The method conver ethiopian calender date to gerigorian calender
     * @param ddmmyy daye of in ethiopian calender
     * @param ddmmyy refers dd=day , mm=month, yy =year format
     * @return the gerigorian calnder date
     */
    public String getDiff(String ddmmyy) {
        String[] dt = ddmmyy.split("-");
//receives the input string and extracts the date from it.
        if (dt.length == 3) {
            this.Eday = Integer.parseInt(dt[2]);
            this.Emnz = Integer.parseInt(dt[1]);
            this.Eyr = Integer.parseInt(dt[0]);
        } else {
            errMsg = "Invalid date input.";
        }
        //int a = this.Gday, b = this.Gmnz, c = this.Gyr;
        //  int a1 = this.Gd, b1 = this.Gm, c1 = this.Gy;
        int diff = 0, flag = 0, cs = 4;
        //if standard date is equal to the input
        if (Ey == Eyr && Em == Emnz && Ey == Eyr) {
            cs = 0;
            diff = 0;
        //if standard is greater by yr, month or date respectivly
        } else if ((Ey > Eyr) || (Ey == Eyr && Em > Emnz) || (Ey == Eyr && Em == Emnz && Ed > Eday)) {
            cs = 1;
            strx = Eday + "/" + Emnz + "/" + Eyr;

            while (!strx.equals("21/6/1972")) {
                strx = EdayPlus(strx);
                diff++;
            }
        //if standard is lesser by yr, month or date respectivly
        } else if ((Eyr > Ey) || (Ey == Eyr && Emnz > Em) || (Ey == Gyr && Em == Emnz && Eday > Ed)) {
            cs = 2;
            strx = Ed + "/" + Em + "/" + Ey;
            while (!strx.equals(Eday + "/" + Emnz + "/" + Eyr)) {
                strx = EdayPlus(strx);
                diff++;
            }
        }

        String r = "";
        if (cs == 2) {
            r = GdayPlus("29/2/1980", diff);
        } else if (cs == 0) {
            r = "29/2/1980";
        } else if (cs == 1) {
            r = GdayMinus("29/2/1980", diff);
        }
        String day[] = r.split("/");
        String dayes = day[0];
        String month = day[1];
        if (Integer.parseInt(month) < 10) {
            month = "0" + month;
        }
        if (Integer.parseInt(dayes) < 10) {
            dayes = "0" + dayes;
        }

        r = day[2] + "-" + month + "-" + dayes;
        return r;
    }

    public String EdayMinus(String str, int i) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);
        for (int k = 0; k < i; k++) {
            temp = 2;//getEmd(m, y);
            if (d < temp) {
                //d += 1;
                if (m > 1) {
                    m--;
                    d = getEmd(m, y);
                } else {
                    m = 13;
                    y--;
                    d = getEmd(m, y);
                }

            } else {
                d--;
            }

        }
        return d + "/" + m + "/" + y;

    }

    public String EdayPlus(String str) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);

        temp = getEmd(m, y);
        if (d < temp) {
            d += 1;
        } else {
            if (m < 13) {
                m += 1;
                d = 1;
            } else {
                m = 1;
                d = 1;
                y += 1;
            }
        }
        return d + "/" + m + "/" + y;
    }

    public String EdayPlus(String str, int i) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);
        for (int k = 0; k < i; k++) {
            temp = getEmd(m, y);
            if (d < temp) {
                d += 1;
            } else {
                if (m < 13) {
                    m += 1;
                    d = 1;
                } else {
                    m = 1;
                    d = 1;
                    y += 1;
                }
            }

        }
        return d + "/" + m + "/" + y;

    }

    private int getEmd(int i, int j) {
        int d = 0;
        if (i != 13) {
            d = 30;
        } else {
            if (isEleap(j)) {
                d = 6;
            } else {
                d = 5;
            }
        }
        return d;
    }

    private String GdayPlus(String str) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);

        temp = getGmd(m, y);
        if (d < temp) {
            d += 1;
        } else {
            if (m < 12) {
                m += 1;
                d = 1;
            } else {
                m = 1;
                d = 1;
                y += 1;
            }
        }
        return d + "/" + m + "/" + y;

    }

    private String GdayPlus(String str, int df) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);
        for (int i = 0; i < df; i++) {
            temp = getGmd(m, y);
            if (d < temp) {
                d += 1;
            } else {
                if (m < 12) {
                    m += 1;
                    d = 1;
                } else {
                    m = 1;
                    d = 1;
                    y += 1;
                }
            }
        }
        return d + "/" + m + "/" + y;

    }

    private String GdayMinus(String str) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);

        temp = getGmd(m, y);
        if (d > 1) {
            d -= 1;

        } else {
            if (m > 1) {
                d -= 1;
            //m -= 1;
            } else {
                if (m > 1) {
                    d = getGmd(m - 1, y);
                    m = m - 1;
                } else {
                    m = 12;
                    y = y - 1;
                    d = getGmd(m, y);
                }

            }
        }

        return d + "/" + m + "/" + y;

    }

    private String GdayMinus(String str, int df) {
        String s[] = str.split("/");
        int d = 0, m = 0, y = 0, temp = 0;
        d = Integer.parseInt(s[0]);
        m = Integer.parseInt(s[1]);
        y = Integer.parseInt(s[2]);
        for (int i = 0; i < df; i++) {
            // temp = getGmd(m, y);
            if (d > 1) {
                d -= 1;
            } else {
                if (m > 1) {
                    d = getGmd(m - 1, y);
                    m -= 1;
                } else {

                    m = 12;
                    y = y - 1;
                    d = getGmd(12, y);

                }
            }
        }
        return d + "/" + m + "/" + y;
    }

    private String getGWkday(int i) {
        String str = "";
        switch (i) {
            case 1:
                str = "Monday";
                break;
            case 2:
                str = "Tuesday";
                break;
            case 3:
                str = "Wedensday";
                break;
            case 4:
                str = "Thursday";
                break;
            case 5:
                str = "Friday";
                break;
            case 6:
                str = "Saturday";
                break;
            case 7:
                str = "Sunday";
                break;
        }

        return str;
    }

    private int getGmd(int i, int j) {
        int ds = 0;
        switch (i) {
            case 1:
                ds = 31;
                break;
            case 2:
                if (isGleap(j)) {
                    ds = 29;
                } else {
                    ds = 28;
                }
                break;
            case 3:
                ds = 31;
                break;
            case 4:
                ds = 30;
                break;
            case 5:
                ds = 31;
                break;
            case 6:
                ds = 30;
                break;
            case 7:
                ds = 31;
                break;
            case 8:
                ds = 31;
                break;
            case 9:
                ds = 30;
                break;
            case 10:
                ds = 31;
                break;
            case 11:
                ds = 30;
                break;
            case 12:
                ds = 31;
                break;
        }

        return ds;
    }

    private boolean isEleap(int yr) {
        boolean b = false;
        int yrdiff = 0;
        if (yr > 1999) {
            yrdiff = (yr - 1999) % 4;
            if (yrdiff == 0) {
                b = true;
            } else {
                b = false;
            }
        } else if (yr < 1999) {
            yrdiff = (1999 - yr) % 4;
            if (yrdiff == 0) {
                b = true;
            } else {
                b = false;
            }
        } else {
            b = true;
        }
        return b;
    }

    private boolean isGleap(int yr) {
        boolean b = false;
        int d1 = 0;
        int d2 = 0;
        int d3 = 0;
        d1 = yr % 4;
        d2 = yr % 100;
        d3 = yr % 400;
        if ((d1 == 0 && d2 != 0)) {
            b = true;
        } else if (d1 == 0 && d2 == 0 && d3 == 0) {
            b = true;
        }

        return b;
    }

 

}
