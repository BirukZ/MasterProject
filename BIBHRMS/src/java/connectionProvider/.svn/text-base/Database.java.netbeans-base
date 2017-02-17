/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionProvider;

/**
 *
 * @author one1423
 */
import java.sql.*;
import java.util.*;

public class Database {

    private static boolean verbose = false;

    public static final Connection getConnection(String baseName) {
        Connection conn = null;
        String driver = null;
        String url = null;
        String username = null;
        String password = null;
        try {            //  ResourceBundle resb = ResourceBundle.getBundle(baseName);
            driver = "oracle.jdbc.driver.OracleDriver";
            url = "jdbc:oracle:thin:@192.168.60.100:1521:mugher";
            username = "hrms"; //resb.getString("database.username");
            password = "hrms";//resb.getString("database.password");
            Class.forName(driver);
        } catch (MissingResourceException e) {
            System.err.println("Missing Resource: " + e.getMessage());
            return conn;
        } catch (ClassNotFoundException e) {
            System.err.println("Class not found: " + e.getMessage());
            return conn;
        }
        try {
            if (verbose) {
                System.out.println("baseName=" + baseName);
                System.out.println("driver=" + driver);
                System.out.println("url=" + url);
                System.out.println("username=" + username);
                System.out.println("password=" + password);
            }
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            System.err.println(e.getMessage());
            System.err.println("in Database.getConnection");
            System.err.println("on getConnection");
            conn = null;
        } finally {
            return conn;
        }
    }

    public static void setVerbose(boolean v) {
        verbose = v;
    }

    public static void main(String arg[]) {
        try {
            ConnectionManager connectionManager = new ConnectionManager();
            connectionManager.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
//        String num;
//
//        num = "12345.0";
//        String numToken = "[+-]?[\\d,]+\\.?\\d+";
//        //"[\\p{Digit}&&[123456789\\.]]+";
//        if (num.matches(numToken)) {
//            System.out.println("you enter a VALID number format");
//        } else {
//            System.out.println("you enter a INVALID number format");
//        }


    }
}
