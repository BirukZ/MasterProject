/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.LeaveBalanceEntity;
import fphrms.Leave.BalancePage.EmoloyeeList;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author BravoZulu
 */
public class LeaveBalanceManager {

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private LeaveBalanceEntity leaveBalanceEntity = new LeaveBalanceEntity();

    public LeaveBalanceManager() {
    }

   



    public ArrayList<SelectItem> pysicalLeaveYear()
    {
        String date = jodanTimeCalender.currentDateFinder();
        ArrayList<SelectItem> listOfYear = new ArrayList<SelectItem>();
        int phisicalLeaveYear = StringDateManipulation.getYear(date);
        int month = StringDateManipulation.getMonth(date);
        if (month >= 11)
        {
            phisicalLeaveYear += 1;
        }
        try {
            for (int i = 1; i < 500; i++)
            {
                listOfYear.add(new SelectItem(Integer.toString(phisicalLeaveYear), Integer.toString(phisicalLeaveYear)));
                phisicalLeaveYear += 1;
            }
            listOfYear.add(0, new SelectItem(null, "-- Select Pysical Year --"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listOfYear;

    }
     public ArrayList<SelectItem> getPysicalLeaveYear() {
        String date = jodanTimeCalender.currentDateFinder();
        ArrayList<SelectItem> listOfYear = new ArrayList<SelectItem>();
        int phisicalLeaveYear = StringDateManipulation.getYear(date);
        int month = StringDateManipulation.getMonth(date);
        if (month >= 11) {
            phisicalLeaveYear += 2;
        }
        try {
            for (int i = 1; i < 3; i++) {
                listOfYear.add(new SelectItem(Integer.toString(phisicalLeaveYear), Integer.toString(phisicalLeaveYear)));
                phisicalLeaveYear -= 1;
            }
            listOfYear.add(0, new SelectItem(null, "-- Select Pysical Year --"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listOfYear;

    }

    public ArrayList<EmployeeLeaveMaster> EmployeeHireDate() 
                     {
              try
                {
        ArrayList<EmployeeLeaveMaster> listofEmployee=new ArrayList<EmployeeLeaveMaster>();

        ResultSet _rs= leaveBalanceEntity.SelectEmployeeHireDate();

         while(_rs.next())
         {

         listofEmployee.add(new EmployeeLeaveMaster(_rs.getString("emp_id"),_rs.getString("hire_date"),_rs.getString("BALANCE"),_rs.getString("totalEntitlement")));

         }
          return listofEmployee;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }



    public ArrayList<EmployeeLeaveMaster> EmployeeHireDateForLessThanOneYear()
                     {
              try
                {
        ArrayList<EmployeeLeaveMaster> listofEmployee=new ArrayList<EmployeeLeaveMaster>();

        ResultSet _rs= leaveBalanceEntity.SelectEmployeeHireDateForLessThanOneYear();

         while(_rs.next())
         {

         listofEmployee.add(new EmployeeLeaveMaster(_rs.getString("emp_id"),_rs.getString("hire_date"),_rs.getString("BALANCE"),_rs.getString("totalEntitlement")));

         }
          return listofEmployee;
        }  catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

       public ArrayList<SelectItem> getScheduleLeaveYear() {
        String date = jodanTimeCalender.currentDateFinder();
        ArrayList<SelectItem> listOfYear = new ArrayList<SelectItem>();
        int phisicalLeaveYear = StringDateManipulation.getYear(date);
        int month = StringDateManipulation.getMonth(date);
         phisicalLeaveYear += 1;
        try {
            for (int i = 1; i < 3; i++) {
                listOfYear.add(new SelectItem(Integer.toString(phisicalLeaveYear),
                        Integer.toString(phisicalLeaveYear)));
                phisicalLeaveYear -= 1;
            }
            listOfYear.add(0, new SelectItem(null, "-- Select Pysical Year --"));

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        return listOfYear;

    }

    public boolean saveLeaveBalance(ArrayList<HashMap> leaveBalance) {
        try {
            return leaveBalanceEntity.saveLeaveBalanceNewTransfer(leaveBalance);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
       public boolean PrepareLeaveForAsOfToday(String empID, float totalBalanceasofToday,float totalentiAsOfToday) {
         try {
            return leaveBalanceEntity.prepareLeaveAsofToday(empID,totalBalanceasofToday,totalentiAsOfToday);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public boolean SaveEmployeeLeaveBalanceLessOneYearExp(String employeeIDExpLessOne, int currentYear, float totalasofToday, int flag) {
         try {
            return leaveBalanceEntity.saveLeaveBalanceForExpiranceLessThanOne(employeeIDExpLessOne,currentYear,totalasofToday,flag);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
       public boolean saveLeaveBalanceINBank(ArrayList<HashMap> leaveBalance) {
        try {
            return leaveBalanceEntity.saveLeaveBalanceINBank(leaveBalance);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public ArrayList<EmoloyeeList> selectAllEmployee()
    {
        ArrayList<EmoloyeeList> employeeDate=new ArrayList<EmoloyeeList>();

            ResultSet _rs=leaveBalanceEntity.SelectAllEmployee();
        try {
            while (_rs.next())
            {
              employeeDate.add(new EmoloyeeList( _rs.getString("EMP_ID"),_rs.getString("HIRE_DATE")));
            }
       } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return employeeDate;


    }
     public ArrayList<EmoloyeeList> selectAllEmployeeExpiranceLessThanOneYear()
    {
        ArrayList<EmoloyeeList> employeeDate=new ArrayList<EmoloyeeList>();

            ResultSet _rs=leaveBalanceEntity.SelectAllEmployeeExpiranceLessThanOneYear();
        try {
            while (_rs.next())
            {
              employeeDate.add(new EmoloyeeList( _rs.getString("EMP_ID"),_rs.getString("HIRE_DATE"),_rs.getString("expirance")));
            }
       } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

        return employeeDate;


    }

    public boolean updateLeaveBalance(ArrayList<HashMap> leaveBalance) {
        try {
            return leaveBalanceEntity.updateLeaveBalanceNewTransfer(leaveBalance);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public boolean EmployeeLeaveRegister(String employeeIDExpLessOne)
     {
        try {
            boolean cheakCondition = false;
            ResultSet _rs = leaveBalanceEntity.CheackEmployeeLeaveStatus(employeeIDExpLessOne);
            if (_rs.next()) {
                cheakCondition = true;
            } else {
                cheakCondition = false;
            }
            return cheakCondition;
       } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }


    public boolean UPDateEmployeeLeaveBalanceLessOneYearExp(String employeeIDExpLessOne, int currentYear, float totalasofToday, int flag) {
         try {
            return leaveBalanceEntity.updateLeaveBalanceForExpiranceLessThanOne(employeeIDExpLessOne,currentYear,totalasofToday,flag);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployeeLeaveBalance(String leaveBalanceId) {
        try {
            return leaveBalanceEntity.deleteEmployeeLeaveBalance(leaveBalanceId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
      public boolean ClearAsOfToDayTable() {
          try {
            return leaveBalanceEntity.ClearAsOfToDayTable();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }


    public ArrayList<HashMap> listOfEmployeeLeaveBalance() {
        try {
            int year = 0;
            year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
            year -= 2;
            return leaveBalanceEntity.listOfEmployeeLeaveBalance(Integer.toString(year));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfEmployeeFromReserveLeave() {
        try {
            int year = 0;
            year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
            year -= 2;
            return leaveBalanceEntity.listOfEmployeeFromReserveLeave(Integer.toString(year));
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfEmployeeLeaveBalance(String employeeID) {
        try {
            int year = 0;
            //year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
            year = StringDateManipulation.getYear(StringDateManipulation.toDayInGc());
              //  JOptionPane.showMessageDialog(null, year+"Year Under LeveBlanceManager");
        return leaveBalanceEntity.listOfEmployeeLeaveBalance(Integer.toString(year), employeeID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfEmployeeFromReserveLeave(String employeeID) {
        try {

         

            int year = 0;
            year = StringDateManipulation.getYear(StringDateManipulation.toDayInEc());
             year = StringDateManipulation.getYear(StringDateManipulation.toDayInGc());
          //  year -= 2;
          //  return leaveBalanceEntity.listOfEmployeeFromReserveLeave(Integer.toString(year), employeeID);---Biruk

             return leaveBalanceEntity.listOfEmployeeLeaveBalance(Integer.toString(year), employeeID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfEmployee(String year) {
        try {
            return leaveBalanceEntity.listOfEmployee(year);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
      public ArrayList<HashMap> listOfEmployeeforRemaingLeave(String year) {
        try {
            return leaveBalanceEntity.listOfEmpRem(year);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public float readEmployeeLeaveBalance(String leaveYear, String employeeId) {
        try {
            return leaveBalanceEntity.readEmployeeLeaveBalanceAvilebelInTheYear(leaveYear, employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public boolean isRegisterThisYear(String leaveYear, String employeeId) {
        try {
            return leaveBalanceEntity.isRegisterThisYear(leaveYear, employeeId);
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public boolean saveLeaveSchdule(HashMap leaveBalance) {
        return leaveBalanceEntity.saveLeaveSchdule(leaveBalance);
    }

 

    public boolean delteLeaveSchduleEmployee(int scheduleId, String empID) {
        return leaveBalanceEntity.delteLeaveSchduleEmployee(scheduleId, empID);
    }

     public String getEmployeeStatus(String selectedId)
     {
          try {
         String empStatus=null;
       ResultSet _rs= leaveBalanceEntity.getEmployeeStatus(selectedId);

       while(_rs.next()){

       empStatus=_rs.getString("EMP_STATUS").toString();

       }
       return empStatus;
       } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



    public boolean approveLeaveSchedule(ArrayList<HashMap> leaveBalance, int status) {
        try {
            return leaveBalanceEntity.approveLeaveSchedule(leaveBalance, status);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }
     public float SelectLastBalanceOFEmployee(String selectedId) {
         ResultSet _rs=null;
         float leaveAmount=0;
        try {
           _rs=leaveBalanceEntity.selectLastEmployeeBalance(selectedId);

           while(_rs.next())
           {
           leaveAmount=Float.parseFloat(_rs.getString("LEAVEAMOUNT"));

           }
          
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
          return leaveAmount;
    }

      public String SelectLastBalanceOFEmployeeForLeaveWithOutPay(String selectedId) {
         ResultSet _rs=null;
         String leaveAmount=null;
        try {
           _rs=leaveBalanceEntity.selectLastEmployeeBalance(selectedId);

           while(_rs.next())
           {
           leaveAmount=(_rs.getString("LEAVEAMOUNT")+"-"+_rs.getString("USEDLEAVE")+"-"+_rs.getString("YEAR"));

           }

        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;
        }
          return leaveAmount;
    }
       public boolean SaveNewYearLeaveForEmployee(String empID, float newLeaAmount, int yearshoudbe) {
        return leaveBalanceEntity.saveLeaveBalanceForNewYear(empID,newLeaAmount,yearshoudbe);
    }

      public static class EmployeeLeaveMaster {

      String employeeID;
      String hireDate;
      String lastBalance;
      String totalEntitlment;

        public EmployeeLeaveMaster()
        {
        }
              private EmployeeLeaveMaster(String employeeID, String hireDate,String lastBalance,String entitlement) {
            this.employeeID=employeeID;
            this.hireDate=hireDate;
            this.lastBalance=lastBalance;
            this.totalEntitlment=entitlement;
        }

        public String getTotalEntitlment() {
            return totalEntitlment;
        }

        public void setTotalEntitlment(String totalEntitlment) {
            this.totalEntitlment = totalEntitlment;
        }

        public String getEmployeeID() {
            return employeeID;
        }

        public void setEmployeeID(String employeeID) {
            this.employeeID = employeeID;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getLastBalance() {
            return lastBalance;
        }

        public void setLastBalance(String lastBalance) {
            this.lastBalance = lastBalance;
        }



      }

}
