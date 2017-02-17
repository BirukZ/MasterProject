/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package fphrms;



import java.util.HashMap;
import manager.employeeManager.EmployeeChartManager;

/**
 *
 * @author Dereje
 */
public class EmployeeChartData {

    //holds the the counted employees
    private EmployeeChartManager employeeChartManager = new EmployeeChartManager();
    //hashMap of the employee data
    protected HashMap masterEmployees = new HashMap();
    //count employees
    private float countEmployees;
    //employees status
    private String labelStatus;
    // active employees
    private int activeEmployeesCount=employeeChartManager.countActiveEmployees();
    //inactive employees
    private int inActiveEmployeesCount= employeeChartManager.countInActiveEmployees();
    //onleave employees
    private int onLeaveEmployeesCount =employeeChartManager.countOnLeaveEmployees();



    public float getCountEmployees() {
        return countEmployees;
    }

    public void setCountEmployees(float countEmployees) {
        this.countEmployees = countEmployees;
    }

    public String getLabelStatus() {
        return labelStatus;
    }

    public void setLabelStatus(String labelStatus) {
        this.labelStatus = labelStatus;
    }

    public HashMap getMasterEmployees() {
        masterEmployees = createMap();
        return masterEmployees;
    }

    public EmployeeChartData(float count, String labelStatus) {
        this.countEmployees = count;
        this.labelStatus = labelStatus;
    }

    public EmployeeChartData() {
    }

    /**
     * <p>The following method round two decimal places of the given number. </p>
     * @return temp/p
     */
    public float Round(float Rval, int Rpl) {
        float p = (float) Math.pow(10, Rpl);
        Rval = Rval * p;
        float tmp = Math.round(Rval);
        return (float) tmp / p;
    }

    /**
     * Method to create the hash map from the employees from different status
     *
     * @return HasMap
     */
    @SuppressWarnings("unchecked")
    public HashMap createMap() {
        HashMap hp = new HashMap();

        float total = 0;
        float active = 0;
        float inActive = 0;
        float onLeave = 0;

        active = activeEmployeesCount;
        inActive = inActiveEmployeesCount;
        onLeave = onLeaveEmployeesCount;

        total = active + inActive + onLeave;

        hp.put("Active", new EmployeeChartData(active, "Active-" + Round(Float.valueOf((active / total) * 100), 2) + " %"));

        hp.put("InActive", new EmployeeChartData(inActive, "InActive-" + Round(Float.valueOf((inActive / total) * 100), 2) + " %"));

        hp.put("OnLeave", new EmployeeChartData(onLeave, "OnLeave-" + Round(Float.valueOf((onLeave / total) * 100), 2) + " %"));

        return hp;
    }
}
