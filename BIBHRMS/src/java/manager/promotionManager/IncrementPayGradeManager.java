/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.promotionManager;

import entity.Promotion.IncrementPayGradeEntity;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;


import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.LookUpManager;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author Up
 */
public class IncrementPayGradeManager {

    private String empId;
    private String empName;
    private String deptId;
    private String deptDesc;
    private String hiredDate;
    private String lastIncrementDate;
    private String currentPayGrade;
    private String currentSalary;
    private String nextPayGrade;
    private String nextSalary;
    private String incPercentage;
    private boolean selected;
    public static int totalEmployee;

    public static int getTotalEmployee() {
        return totalEmployee;
    }

    public static void setTotalEmployee(int totalEmployee) {
        IncrementPayGradeManager.totalEmployee = totalEmployee;
    }
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private ArrayList<HashMap> payGrade = new ArrayList<HashMap>();
    LookUpManager lookUpManager = null;

    public ArrayList<HashMap> getPayGrade() {
        return payGrade;
    }

    public void setPayGrade(ArrayList<HashMap> payGrade) {
        this.payGrade = payGrade;
    }

    public IncrementPayGradeManager() {
        if (getPayGrade().size() <= 0) {
            isNotNull();
            try {
                setPayGrade(lookUpManager.getAllPayGrade());
            } catch (Exception e) {
            }


        }
    }

    public IncrementPayGradeManager(String empId, String empName, String deptId,
            String deptDesc, String hiredDate, String lastIncrementDate,
            String currentPayGrade, String currentSalary, String nextPayGrade,
            String nextSalary, String incPerc, boolean selected) {
        this.empId = empId;
        this.empName = empName;
        this.deptId = deptId;
        this.deptDesc = deptDesc;
        this.hiredDate = hiredDate;
        this.lastIncrementDate = lastIncrementDate;
        this.currentPayGrade = currentPayGrade;
        this.currentSalary = currentSalary;
        this.nextPayGrade = nextPayGrade;
        this.nextSalary = nextSalary;
        this.incPercentage = incPerc;
        this.selected = selected;
    }
    GregorianCalendarManipulation gregClnd = new GregorianCalendarManipulation();
    IncrementPayGradeEntity incPayGradeEntity = new IncrementPayGradeEntity();
    JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();

    public boolean saveUpdatePayGradeInc(String incDate, String incDesc, ArrayList<IncrementPayGradeManager> incrementPayGradeManagerList) {
        IncrementPayGradeEntity incEntity = null;
        boolean saved = false;
        for (IncrementPayGradeManager inc : incrementPayGradeManagerList) {
            incEntity = new IncrementPayGradeEntity(inc.getEmpId(),
                    inc.getEmpName(), inc.getDeptId(), inc.getDeptDesc(), inc.getHiredDate(), inc.getLastIncrementDate(),
                    inc.getCurrentPayGrade(), inc.getCurrentSalary(), inc.getNextPayGrade(), inc.getNextSalary());
            saved = incPayGradeEntity.saveUpdatePayGradeInc(incDate, incDesc, incEntity);
        }
        return saved;
    }

    /**
     * The method prepares a list of employees that must get a salary increment
     * If the employee works for n months which are less than 12, the salary will be
     * n/12th ofthe initial paygrade times . And upon next increment the salary will
     * be incremented by the difference between the next and previous paygrades
     * @return
     */
    public ArrayList<IncrementPayGradeManager> selectEmpForInc() {
        ArrayList<IncrementPayGradeManager> incrementPaygrade = new ArrayList<IncrementPayGradeManager>();
        double percentage;
        double nextSalery;
        double currentSalary;
        double dayDiff;
        double monthDiff;
        double yearDiff;
        try {
            ArrayList<HashMap> incPaygrade = incPayGradeEntity.getEmployeesForPayGradeInc();

            for (HashMap hm : incPaygrade) {
                String incDate = null;
                String hirdDate = null;

                if (hm.get("hiredDate") != null) {
                    hirdDate = hm.get("hiredDate").toString();
                }
                Calendar hDate = GregorianCalendarManipulation.convertDateToCalendar(hirdDate);
                String currentDate = "2013-07-23";
                //jodanTimeCalender.currentForeignersDateFinder();
                Calendar cDate = GregorianCalendarManipulation.convertDateToCalendar(currentDate);
                dayDiff = GregorianCalendarManipulation.calaculateDateDifference(hDate, cDate);
                monthDiff = GregorianCalendarManipulation.calaculateMonthDifference(hDate, cDate);
                yearDiff = GregorianCalendarManipulation.calaculateYearDifference(hDate, cDate);
                if (hm.get("lastIncreamentDate") != null) {
                    incDate = hm.get("lastIncreamentDate").toString();
                }
                currentSalary = Double.parseDouble(hm.get("currentSalary").toString());
                nextSalery = Double.parseDouble(hm.get("nextSalary").toString());
                double diffInSalary = nextSalery - currentSalary;
                if (monthDiff == 12) {
                    percentage = 100;
                    nextSalery = Double.parseDouble(hm.get("nextSalary").toString());
                } else if (monthDiff < 12) {
                    //dayDiff = dayDiff - (yearDiff*365.25);
                    percentage = (dayDiff / 360) * 100;
                    nextSalery = currentSalary + (diffInSalary * (percentage / 100));

                } else {
//                    monthDiff = monthDiff - (yearDiff *12);
                    percentage = 10;
                    nextSalery = (Double.parseDouble(hm.get("currentSalary").toString()) + Double.parseDouble(hm.get("currentSalary").toString()) * 0.1);
                }

                incrementPaygrade.add(new IncrementPayGradeManager(
                        hm.get("empId").toString(),
                        hm.get("empName").toString(),
                        hm.get("deptId").toString(),
                        hm.get("deptDesc").toString(),
                        hirdDate,
                        incDate,
                        hm.get("currentPayGrade").toString(),
                        hm.get("currentSalary").toString(),
                        hm.get("nextPayGrade").toString(),
                        String.format("%1g%n", nextSalery),
                        String.valueOf(percentage) + "%", true));
//                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return incrementPaygrade;
    }

    /**
     * The method prepares a list of employees that must get a salary increment for report
     *
     * @return ArrayList of IncrementPayGradeManager
     */
    public ArrayList<IncrementPayGradeManager> selectEmpForIncReport() {
        ArrayList<IncrementPayGradeManager> incrementPaygrade = new ArrayList<IncrementPayGradeManager>();
        double percentage = 0;
        double nextSalery = 0;
        double currentSalary;
        double dayDiff;
        double monthDiff;
        double yearDiff;
        try {
            ArrayList<HashMap> incPaygrade = incPayGradeEntity.getEmployeesForPayGradeIncREport();

            for (HashMap hm : incPaygrade) {
                String incDate = null;
                String hirdDate = null;
                incrementPaygrade.add(new IncrementPayGradeManager(
                        hm.get("empId").toString(),
                        hm.get("empName").toString(),
                        hm.get("deptId").toString(),
                        hm.get("deptDesc").toString(),
                        hirdDate,
                        incDate,
                        hm.get("currentPayGrade").toString(),
                        hm.get("currentSalary").toString(),
                        hm.get("nextPayGrade").toString(),
                        String.format("%1g%n", nextSalery),
                        String.valueOf(percentage) + "%", true));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return incrementPaygrade;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the deptId
     */
    public String getDeptId() {
        return deptId;
    }

    /**
     * @param deptId the deptId to set
     */
    public void setDeptId(String deptId) {
        this.deptId = deptId;
    }

    /**
     * @return the deptDesc
     */
    public String getDeptDesc() {
        return deptDesc;
    }

    /**
     * @param deptDesc the deptDesc to set
     */
    public void setDeptDesc(String deptDesc) {
        this.deptDesc = deptDesc;
    }

    /**
     * @return the hiredDate
     */
    public String getHiredDate() {
        return hiredDate;
    }

    /**
     * @param hiredDate the hiredDate to set
     */
    public void setHiredDate(String hiredDate) {
        this.hiredDate = hiredDate;
    }

    /**
     * @return the lastIncrementDate
     */
    public String getLastIncrementDate() {
        return lastIncrementDate;
    }

    /**
     * @param lastIncrementDate the lastIncrementDate to set
     */
    public void setLastIncrementDate(String lastIncrementDate) {
        this.lastIncrementDate = lastIncrementDate;
    }

    /**
     * @return the currentPayGrade
     */
    public String getCurrentPayGrade() {
        return currentPayGrade;
    }

    /**
     * @param currentPayGrade the currentPayGrade to set
     */
    public void setCurrentPayGrade(String currentPayGrade) {
        this.currentPayGrade = currentPayGrade;
    }

    /**
     * @return the currentSalary
     */
    public String getCurrentSalary() {
        return currentSalary;
    }

    /**
     * @param currentSalary the currentSalary to set
     */
    public void setCurrentSalary(String currentSalary) {
        this.currentSalary = currentSalary;
    }

    /**
     * @return the nextPayGrade
     */
    public String getNextPayGrade() {
        return nextPayGrade;
    }

    /**
     * @param nextPayGrade the nextPayGrade to set
     */
    public void setNextPayGrade(String nextPayGrade) {
        this.nextPayGrade = nextPayGrade;
    }

    /**
     * @return the nextSalary
     */
    public String getNextSalary() {
        return nextSalary;
    }

    /**
     * @param nextSalary the nextSalary to set
     */
    public void setNextSalary(String nextSalary) {
        this.nextSalary = nextSalary;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the incPercentage
     */
    public String getIncPercentage() {
        return incPercentage;
    }

    /**
     * @param incPercentage the incPercentage to set
     */
    public void setIncPercentage(String incPercentage) {
        this.incPercentage = incPercentage;
    }

    private float workedDayes(String hireDate, String incremntDate, int pass) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String currentDate = dateFormat.format(cal.getTime());
        int year = StringDateManipulation.getYear(incremntDate);
        if (pass == 1) {            
            year = StringDateManipulation.getYear(currentDate);
            year -= 1;
           
        }
        cal1.set(year, 7, 1);

        cal2.set(StringDateManipulation.getYear(hireDate), StringDateManipulation.getMonth(hireDate), StringDateManipulation.getDate(hireDate));
        return daysBetween(cal2.getTime(), cal1.getTime());

    }

    private float daysBetween(Date d1, Date d2) {
        return (float) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    private HashMap getNextPayGrade(String rank, String payGrade) {
        HashMap list = new HashMap();
        for (HashMap hm : getPayGrade()) {
            if (hm.get("RANK_ID").equals(rank) && hm.get("STEP_NO").equals(payGrade)) {
                list.put("RANK_ID", rank);
                list.put("STEP_NO", payGrade);
                list.put("SALARY", hm.get("SALARY"));
                return list;
            }

        }
        return null;

    }

    public ArrayList<HashMap> calculateEmployeeIncremant(String incremntDay) {
        ArrayList<HashMap> listOfCalculation = new ArrayList<HashMap>();
        float persentage;
        float newSalaryValue;
        float newSalary;
        float oldSalary;
        float month;
        int newPaygrade;
        float newSalaryDiffOld;
        boolean addtoList = false;
        try {
            DecimalFormat df = new DecimalFormat("#.##");
            ArrayList<HashMap> listOfEmp = incPayGradeEntity.getEmployeesForPayGradeIncm();
            float year = workedDayes(incremntDay, incremntDay, 1);

            year *= -1;
             //  System.out.println(year);
            for (HashMap hm : listOfEmp) {
                HashMap list = new HashMap();
                list.put("EMP_ID", hm.get("EMP_ID").toString());
                list.put("FULLNAME", hm.get("FULLNAME").toString());
                list.put("HIRE_DATE", hm.get("HIRE_DATE").toString());
                list.put("currentSalary", hm.get("SALARY").toString());
                list.put("currentPayGrade", hm.get("PAY_GRADE").toString());
                newPaygrade = Integer.parseInt(hm.get("PAY_GRADE").toString()) + 1;
                if (workedDayes(hm.get("HIRE_DATE").toString(), incremntDay, 0) >= year) {
                    newPaygrade = Integer.parseInt(hm.get("PAY_GRADE").toString()) + 1;
                    HashMap h = getNextPayGrade(hm.get("RANK_ID").toString(), Integer.toString(newPaygrade));
                    if (h != null) {
                        addtoList = true;
                        newSalary = Float.parseFloat(h.get("SALARY").toString());
                        oldSalary = Float.parseFloat(hm.get("SALARY").toString());
                        newSalaryValue = newSalary - oldSalary;
                        persentage = newSalaryValue * 100 / oldSalary;
                        list.put("nextPayGrade", newPaygrade);
                        list.put("newSalary", newSalary);
                        list.put("oldSalary", oldSalary);
                        list.put("persentage", df.format(persentage).toString());
                    }
                } else {

                    HashMap h = getNextPayGrade(hm.get("RANK_ID").toString(), Integer.toString(newPaygrade));
                    if (h != null) {
                        addtoList = true;
                        newSalary = Float.parseFloat(h.get("SALARY").toString());
                        oldSalary = Float.parseFloat(hm.get("SALARY").toString());
                        newSalaryDiffOld = newSalary - oldSalary;
                        
                        float workingDay = workedDayes(hm.get("HIRE_DATE").toString(), incremntDay, 0);
                       
                        month = (workingDay * 12) / year;
                        newSalaryValue = newSalaryDiffOld / 12;//(12 * month);
                        newSalaryValue *= month;
                           persentage = newSalaryValue * 100 / oldSalary;
                        newSalaryValue += oldSalary;
                   

                        //    oldSalary += newSalaryValue;
                        list.put("nextPayGrade", newPaygrade);
                        list.put("newSalary", df.format(newSalaryValue).toString());
                        list.put("oldSalary", oldSalary);
                        list.put("persentage", df.format(persentage).toString());
                  
                     
                    }
                }
                if (addtoList) {
                    listOfCalculation.add(list);
                    addtoList = false;
                }

            }
            setTotalEmployee(listOfEmp.size());

            return listOfCalculation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void isNotNull() {
        if (lookUpManager == null) {
            lookUpManager = new LookUpManager();

        }
    }

    public static void main(String arfg[]) {
        IncrementPayGradeManager obj = new IncrementPayGradeManager();
        obj.calculateEmployeeIncremant("2013-07-01");
    }
}
