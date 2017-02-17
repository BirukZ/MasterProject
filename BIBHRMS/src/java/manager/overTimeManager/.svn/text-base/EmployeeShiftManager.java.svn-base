/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.overTimeManager;
import com.sun.webui.jsf.model.Option;
import entity.overTimeEntity.EmployeeShiftEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
/**
 *
 * @author BravoZulu
 */
public class EmployeeShiftManager {
    EmployeeShiftEntity employeeShfitEntity=new EmployeeShiftEntity();


       public ArrayList<Option> getShiftList() {
          ArrayList<Option> reportPageTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = employeeShfitEntity.selectAllShiftType();

            while (_rs.next()) {

                reportPageTypes.add(new Option(_rs.getString("SHIFT_TYPE_ID"), _rs.getString("SHIFT_NAME")));

            }
            if (reportPageTypes.size() == 0) {
                reportPageTypes.add(new Option("-1", "NO SHIFT TYPE"));
            } else {
                reportPageTypes.add(0, new Option("-1", "SELECT SHIFT TYPE"));
            }
            _rs.close();
            return reportPageTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
       public ArrayList<Option> getMonthList() {
        ArrayList<Option> monthType = new ArrayList<Option>();
        monthType.add(new Option(null, "--SELECT MONTH --"));
        monthType.add(new Option(9, "September"));
        monthType.add(new Option(10, "October"));
        monthType.add(new Option(11, "November"));
        monthType.add(new Option(12, "December"));
        monthType.add(new Option(01, "January"));
        monthType.add(new Option(02, "February"));
        monthType.add(new Option(03, "March"));
        monthType.add(new Option(04, "April"));
        monthType.add(new Option(05, "May "));
        monthType.add(new Option(06, "Jun"));
        monthType.add(new Option(07, "July"));
        monthType.add(new Option(8, "August"));
        return monthType;
    }

    public HashMap readEmployeeShift(String selectMonth, String selectYear, String empID) {
         try {
           
            return employeeShfitEntity.readEmployeeShifet(selectMonth,selectYear,empID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

     public boolean SaveUPdatedShift(String empID, String preShiftStartDate, String preShiftEndDate, String preShiftName, String changedShiftName, String shiftChanagedDate,String newShiftStartDate,String newShiftEndDate) {
         try {
            return employeeShfitEntity.SaveUPdatedShift(empID, preShiftStartDate, preShiftEndDate, preShiftName, changedShiftName, shiftChanagedDate,newShiftStartDate,newShiftEndDate);
          } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
           return false;
        }
    }
  

}


    

