/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.TransportAbsenceDatePaymentManager;

import entity.TransportAbsenceDatePaymentEntity.TransportAbsenceDateRegistrationEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Henok
 */
public class TransportAbsenceDateRegistrationManager {

    TransportAbsenceDateRegistrationEntity transportAbsenceEntity = new TransportAbsenceDateRegistrationEntity();
    TransportPaymentsModel transportAbsenceDatePaymentModel = new TransportPaymentsModel();
    public static final String DATABASE_STATUS_NEW = "New";
    public static final String DATABASE_STATUS_OLD = "Old";
    public static final String DATABASE_STATUS_OLDDELETED = "Deleted";

    public ArrayList<SelectItem> getServiceList() {
        ArrayList<SelectItem> reasonLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = transportAbsenceEntity.selectAllServiceList();
            while (_rs.next()) {
                SelectItem currentReason = new SelectItem(
                        _rs.getString("ID") + "-" +
                        _rs.getString("SERVICE_DESTINATION"),
                        _rs.getString("SERVICE_DESTINATION"));
                reasonLists.add(currentReason);
            }
            reasonLists.add(0, new SelectItem(null, "--Select Service--"));
            _rs.close();
            return reasonLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> selectInOut() {
        ArrayList<SelectItem> list_emp = new ArrayList<SelectItem>();
        try {
            list_emp.add(new SelectItem(null, "--Select day part---"));
            list_emp.add(new SelectItem("IN", "In"));
            list_emp.add(new SelectItem("OUT", "Out"));
            list_emp.add(new SelectItem("BOTH", "Both"));


        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list_emp;
    }

    public boolean saveTransportAbsenceDate(List transportAbsenceDateList) {
//        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            ArrayList<TransportPaymentsModel> toBeInsert = new ArrayList<TransportPaymentsModel>();
            //  ArrayList<TransportAbsenceDatePaymentModel> toBeDeleted = new ArrayList<TransportAbsenceDatePaymentModel>();
            Iterator<TransportPaymentsModel> iter = transportAbsenceDateList.iterator();
            while (iter.hasNext()) {
                TransportPaymentsModel currentModel = iter.next();
                toBeInsert.add(currentModel);

            }
            transportAbsenceEntity.insertTransportAbsenceDate(toBeInsert);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean updateTransportAbsentDates(List transportAbsenceDateList) {
        ArrayList<TransportPaymentsModel> toBeUpdated = new ArrayList<TransportPaymentsModel>();
        try {
            Iterator<TransportPaymentsModel> iter = transportAbsenceDateList.iterator();
            while (iter.hasNext()) {
                TransportPaymentsModel currentModel = iter.next();
                toBeUpdated.add(currentModel);
            }

            return transportAbsenceEntity.updateTransportAbsenceDate(toBeUpdated);

        } catch (Exception ex) {

            ex.printStackTrace();
            return false;
        }

    }

    public ArrayList<TransportPaymentsModel> getTransportAbsenceDates() {
        ArrayList<TransportPaymentsModel> transportAbsenceDateLists = new ArrayList<TransportPaymentsModel>();
        try {
            ResultSet _rs = transportAbsenceEntity.selectTransportAbsenceDates();
            String temp = null;
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setAbsenceId(_rs.getInt("ABSENCE_ID"));
//                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
                // temp = _rs.getString("SERVICE_ID");
//                ResultSet _rs2 = transportAbsenceDateRegistrationEntity.selectDestnationName(temp);
//                while (_rs2.next()) {
//
//                }
                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
                transportAbsenceDatePaymentModel.setShift(_rs.getString("SHIFT"));
                transportAbsenceDatePaymentModel.setInOut(_rs.getString("INOROUT"));
                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ABSENCE_DATE"));
                transportAbsenceDatePaymentModel.setStatus("Old");
                transportAbsenceDatePaymentModel.setServiceName(_rs.getString("SERVICE_DESTINATION"));

                transportAbsenceDateLists.add(transportAbsenceDatePaymentModel);
            }
            return transportAbsenceDateLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TransportPaymentsModel> getAllTransportAbsenteDateList(String serviceId, String shift, String date) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {

            ResultSet _rs = transportAbsenceEntity.selectTransportAbsentDayList(serviceId, shift, date);
            String temp = null;
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setAbsenceId(_rs.getInt("ABSENCE_ID"));
//                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
                temp = _rs.getString("SERVICE_ID");
                ResultSet _rs2 = transportAbsenceEntity.selectDestnationName(temp);
                while (_rs2.next()) {
                    transportAbsenceDatePaymentModel.setServiceName(_rs2.getString("SERVICE_DESTINATION"));
                }
                transportAbsenceDatePaymentModel.setShift(_rs.getString("SHIFT"));
                transportAbsenceDatePaymentModel.setInOut(_rs.getString("INOROUT"));
                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ABSENCE_DATE"));
                transportAbsenceDatePaymentModel.setStatus("Old");
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getAllWorkWithoutShift(String empId, int actualShift, String date) {
//        ArrayList<TransportAbsenceDatePaymentModel> requestLists = new ArrayList<TransportAbsenceDatePaymentModel>();
        try {

            ResultSet _rs = transportAbsenceEntity.selectUNShiftWork(empId, actualShift, date);
            String tempShift = "NO";
            while (_rs.next()) {
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel();

                tempShift = _rs.getString("TEMPORARY_SHIFT");

            }
            return tempShift;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int getAllsundayOrHolyday(String empId, String date) {
//        ArrayList<TransportAbsenceDatePaymentModel> requestLists = new ArrayList<TransportAbsenceDatePaymentModel>();
        try {

            ResultSet _rs = transportAbsenceEntity.selectsundayOrHolyday(empId, date);
            int otWork = 0;
            while (_rs.next()) {
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel();

                otWork = 1;

            }
            return otWork;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }
    public boolean deleteAbsence(int absentId){
        try {
         return   transportAbsenceEntity.deleteTransportAbsentDates(absentId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}
