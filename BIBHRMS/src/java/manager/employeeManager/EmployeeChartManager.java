/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.employeeManager;

import entity.employeeEntity.EmployeeChartEntity;

/**
 *
 * @author Administrator
 */
public class EmployeeChartManager {
 private EmployeeChartEntity employeeChartEntity = new EmployeeChartEntity();

    public EmployeeChartManager() {
    }

    public int countInActiveEmployees() {
        return employeeChartEntity.countInActiveEmployees();
    }

    public int countActiveEmployees() {
        return employeeChartEntity.countActiveEmployees();
    }

    public int countOnLeaveEmployees() {
        return employeeChartEntity.countOnLeaveEmployees();
    }
}
