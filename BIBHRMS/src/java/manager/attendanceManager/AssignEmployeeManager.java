/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.attendanceManager;

import entity.attendanceEntity.AssignEmployeeEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class AssignEmployeeManager {

    private AssignEmployeeEntity assignEmployeeEntity = null;

    public ArrayList<HashMap> listOFEmployeeByImmediateBoss(String employeeId) {
        isNull();
        return assignEmployeeEntity.listOFEmployeeByLoCation(employeeId);
    }

    public ArrayList<SelectItem> getListOfBoss() {
         isNull();
         return assignEmployeeEntity.getlistBoss();
    }

    public ArrayList<HashMap> listOFEmployee(String deprtmentId) {
        isNull();
        return assignEmployeeEntity.listOFEmployee(deprtmentId);
    }

    public ArrayList<HashMap> listOFEmployeeInDepartment(String deprtmentId) {
        isNull();
        return assignEmployeeEntity.listOFEmployeeInDepartment(deprtmentId);
    }

    public boolean saveEmployeeInUnderBoss(String bossId, Set<HashMap> listOfEmployee) {
        try {
            // delete all employee group
            isNull();
            if (bossId != null) {
                if (listOfEmployee.size() > 0) {
                    assignEmployeeEntity.deleteEmployeeFromImmediateBoss(bossId);
                    return assignEmployeeEntity.saveEmployeeInBoss(bossId, listOfEmployee);
                } else {
                    return assignEmployeeEntity.deleteEmployeeFromImmediateBoss(bossId);
                }

            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<HashMap> listOFEmployeeNotAssign() {
        isNull();
        return assignEmployeeEntity.listOFEmployeeNotAssign();
    }

    private void isNull() {
        if (assignEmployeeEntity == null) {
            assignEmployeeEntity = new AssignEmployeeEntity();
        }
    }
}
