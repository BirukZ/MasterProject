/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.overTimeManager;

import entity.overTimeEntity.ShiftRegistrationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class ShiftRegistrationManager {

    ShiftRegistrationEntity shftentity = new ShiftRegistrationEntity();

    public ArrayList<HashMap> selectShiftRegistration(String dept_id) throws SQLException {
        ArrayList<HashMap> list_emp = new ArrayList<HashMap>();
        try {
            ResultSet _rs2 = shftentity.selectShiftRegistration(dept_id);

            while (_rs2.next()) {
                HashMap hm = new HashMap();
                hm.put("FIRST_NAME", _rs2.getString("FIRST_NAME"));
                hm.put("MIDDLE_NAME", _rs2.getString("MIDDLE_NAME"));
                hm.put("LAST_NAME", _rs2.getString("LAST_NAME"));
                hm.put("EMP_ID", _rs2.getString("EMP_ID"));
                hm.put("JOB_DESCRIPTION", _rs2.getString("JOB_DESCRIPTION"));
                hm.put("shift_type", _rs2.getString("shift_type"));
                hm.put("start_date", _rs2.getString("start_date"));
                hm.put("end_date", _rs2.getString("end_date"));
                list_emp.add(hm);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_emp;
    }

    //####################Update Shift#################################
    public int update_shift(String shift, String id, String startDate, String endDate) throws SQLException {

        int result = 0;
        try {

            result = shftentity.update_shift(shift, id, startDate, endDate);

            return result;

        } catch (Exception ex) {

            ex.printStackTrace();
            return 0;
        }
    }
}
