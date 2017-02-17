/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.overTimeManager;

import entity.overTimeEntity.EntityemployeeShiftViewer;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author user
 */
public class MgrEmployeeShiftViewer {

    EntityemployeeShiftViewer shftentity = new EntityemployeeShiftViewer();

    public HashMap selectShiftRegistration(String emp_id) throws SQLException {
        HashMap hm = new HashMap();
        try {
            ResultSet _rs2 = shftentity.selectShiftsEmployee(emp_id);

            while (_rs2.next()) {

                hm.put("Shift", _rs2.getString("OFFICE_OR_SHIFT").toString());


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return hm;
    }

    public String selectShiftRegistrations(String emp_id) throws SQLException {
//        HashMap hm = new HashMap();
        String shift = null;
        try {
            ResultSet _rs2 = shftentity.selectShiftsEmployee(emp_id);

            while (_rs2.next()) {

                 shift = _rs2.getString("OFFICE_OR_SHIFT");


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return shift;
    }

    //#########################shift Viewer#################################################
    public HashMap selectShifts(String shiftCode,String address) throws SQLException {
        HashMap list_emp = new HashMap();
        try {
            ResultSet _rs2 = shftentity.selectShiftTime(shiftCode,address);

            if (_rs2.next()) {

                list_emp.put("START_TIME", _rs2.getString("START_TIME"));
                list_emp.put("END_TIME", _rs2.getString("END_TIME"));
                list_emp.put("SHIFT_CODE", _rs2.getString("SHIFT_CODE"));
                list_emp.put("REGISTERED_DATE", _rs2.getString("REGISTERED_DATE"));


            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_emp;
    }

    public ArrayList<HashMap> selectAllShifts(String address) throws SQLException {
        ArrayList<HashMap> list_emp = new ArrayList<HashMap>();
        try {
            ResultSet _rs2 = shftentity.selectAllshifts(address);

            while (_rs2.next()) {
                HashMap hm = new HashMap();
                hm.put("START_TIME", _rs2.getString("START_TIME"));
                hm.put("END_TIME", _rs2.getString("END_TIME"));
                hm.put("SHIFT_CODE", _rs2.getString("SHIFT_CODE"));
                hm.put("REGISTERED_DATE", _rs2.getString("REGISTERED_DATE"));
                 hm.put("ADDRESS_CODE", _rs2.getString("ADDRESS_CODE"));
                list_emp.add(hm);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_emp;
    }
    public ArrayList<HashMap> selectAllShifts() throws SQLException {
        ArrayList<HashMap> list_emp = new ArrayList<HashMap>();
        try {
            ResultSet _rs2 = shftentity.selectAllshifts();

            while (_rs2.next()) {
                HashMap hm = new HashMap();
                hm.put("SHIFT_TIME_REG_ID", _rs2.getString("SHIFT_TIME_REG_ID"));
                hm.put("START_TIME", _rs2.getString("START_TIME"));
                hm.put("END_TIME", _rs2.getString("END_TIME"));
                hm.put("SHIFT_CODE", _rs2.getString("SHIFT_CODE"));
                hm.put("REGISTERED_DATE", _rs2.getString("REGISTERED_DATE"));
                 hm.put("ADDRESS_CODE", _rs2.getString("ADDRESS_CODE"));
                list_emp.add(hm);

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_emp;
    }
}
