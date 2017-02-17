/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.ExtendLeaveEntity;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ExtendLeaveManager {

    ExtendLeaveEntity extendLeaveEntity = null;

    public boolean extendAnnualLeave(HashMap sickLeave, HashMap annualLeave) {
        try {
            initObject();
            return extendLeaveEntity.extnedLeave(sickLeave, annualLeave);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    private void initObject() {
        if (extendLeaveEntity == null) {
            extendLeaveEntity = new ExtendLeaveEntity();
        }
    }
}
