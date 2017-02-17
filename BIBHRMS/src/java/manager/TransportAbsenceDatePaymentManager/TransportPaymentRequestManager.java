/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.TransportAbsenceDatePaymentManager;

import entity.TransportAbsenceDatePaymentEntity.TransportPaymentRequestEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Henok
 */
public class TransportPaymentRequestManager {
//    String userName;

    private TransportPaymentsModel transportAbsenceDatePaymentModel;
    TransportPaymentRequestEntity transportPaymentRequestEntity = new TransportPaymentRequestEntity();
    ArrayList<TransportPaymentsModel> employeeAbsent;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<TransportPaymentsModel> getEmployeeAbsent() {
        return employeeAbsent;
    }

    public void setEmployeeAbsent(ArrayList<TransportPaymentsModel> employeeAbsent) {
        this.employeeAbsent = employeeAbsent;
    }

//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }

//    public ArrayList<TransportAbsenceDatePaymentModel> getTransportAbsenceDates() {
//        ArrayList<TransportAbsenceDatePaymentModel> transportAbsenceDateLists = new ArrayList<TransportAbsenceDatePaymentModel>();
//        try {
//            ResultSet _rs = transportPaymentRequestEntity.selectTransportAbsenceDates();
//            String temp = null;
//            while (_rs.next()) {
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel();
//                 transportAbsenceDatePaymentModel.setAbsenceId(_rs.getInt("ABSENCE_ID"));
////                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
//                 temp = _rs.getString("SERVICE_ID");
//                 ResultSet _rs2 = transportPaymentRequestEntity.selectDestnationName(temp);
//                 while (_rs2.next()) {
//                transportAbsenceDatePaymentModel.setServiceName(_rs2.getString("SERVICE_DESTINATION_NAME")); }
//                transportAbsenceDatePaymentModel.setShift(_rs.getString("SHIFT"));
//                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ABSENCE_DATE"));
//                transportAbsenceDatePaymentModel.setStatus("Old");
//                transportAbsenceDateLists.add(transportAbsenceDatePaymentModel);
//            }
//            return transportAbsenceDateLists;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
    public boolean saveTransportPayment(ArrayList<TransportPaymentsModel> transportPaymentList, String requesterId, String appliedDate, String startDate, String endDate, String userName) {
//        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
            String status = TransportAbsenceDatePaymentApproveManager.INITIAL_STATE_TRANSPORT_PAYMENT;
            transportPaymentRequestEntity.insertTransportPayment(transportPaymentList, requesterId, appliedDate, startDate, endDate, status, recorededDateAndTime, userName);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<TransportPaymentsModel> getEmployeeAndTransportPaymentList(int transportPaymentRequestId) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {
            ResultSet _rs = transportPaymentRequestEntity.selectEmployeeAndTransportPaymentList(transportPaymentRequestId);
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setTransportPaymentId(_rs.getInt("TRANSPORT_PAYMENT_EMP_ID"));
                transportAbsenceDatePaymentModel.setActualLocation(_rs.getString("SERVICE_DESTINATION"));
                transportAbsenceDatePaymentModel.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                transportAbsenceDatePaymentModel.setEmployeeName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                transportAbsenceDatePaymentModel.setServiceAbsenteDate(_rs.getDouble("S_ABSENT_DATE"));
                transportAbsenceDatePaymentModel.setEmployeeAbsenteDate(_rs.getDouble("E_ABSENT_DATE"));
                transportAbsenceDatePaymentModel.setTarifPerDay(_rs.getDouble("TARIF_PER_DAY"));
                transportAbsenceDatePaymentModel.setPaymentForSAbsence(_rs.getDouble("PAYMENT_FOR_S_ABSENT"));
                transportAbsenceDatePaymentModel.setDaysInMonth(_rs.getInt("DAYS_IN_MONTH"));
                transportAbsenceDatePaymentModel.setTotalEAbsenteDays(_rs.getInt("TOTAL_E_ABSENT_DAYS"));
                transportAbsenceDatePaymentModel.setExtraPaymentPerDay(_rs.getDouble("EXTRA_PAYMENT_PER_DAY"));
                transportAbsenceDatePaymentModel.setPaymentForNoTransport(_rs.getDouble("TOTAL_EXTRA_PAYMENT"));
                transportAbsenceDatePaymentModel.setTotalPayment(_rs.getDouble("TOTAL_PAYMENT"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TransportPaymentsModel> getAllEmployeeLocationList() {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {
            ResultSet _rs = transportPaymentRequestEntity.selectAllEmployeeLocationList();
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setEmpLocationId(_rs.getInt("EMPLOCATIONID"));
                transportAbsenceDatePaymentModel.setEmpId(_rs.getString("EMP_ID"));
                transportAbsenceDatePaymentModel.setLocationId(_rs.getInt("LOCATIONID"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TransportPaymentsModel> getEmployeeList(String strDate, String endDate) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {
            SimpleDateFormat dateformatter = new SimpleDateFormat("yyyy-MM-dd");
            Calendar startCal;
            Calendar endCal;
            double extraTariffs = 0;
            DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            Date startDate = (Date) formatter.parse(strDate);
            Date end_Date = (Date) formatter.parse(endDate);
            startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            endCal = Calendar.getInstance();
            endCal.setTime(end_Date);
            ArrayList<TransportPaymentRequestEntity> obj = transportPaymentRequestEntity.getEmployeeList();
            ArrayList<TransportPaymentsModel> employeeAbsent = getAllEmployeeAbseDateList(strDate, endDate);
            int counter = 0;
            Date x;

            //   ResultSet _rs = transportPaymentRequestEntity.selectAllEmployeeLocationList();
            for (TransportPaymentRequestEntity tpre : obj) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setEmployeeName(tpre.getEmplopyeeFullName());
                transportAbsenceDatePaymentModel.setLocationName(tpre.getLocationName());
                transportAbsenceDatePaymentModel.setTarifPerDay(Double.parseDouble(tpre.getTarif()));
                do {

                    extraTariffs += Double.parseDouble(tpre.getExtraTarife());
                    startCal.add(Calendar.DATE, 1);
                    x = dateformatter.parse(dateformatter.format(startCal.getTime()));
                } while (end_Date.after(x));            //startCal.getTimeInMillis() != endCal.getTimeInMillis());
                startCal.setTime(startDate);
                transportAbsenceDatePaymentModel.setExtraPaymentPerDay(extraTariffs);
                extraTariffs = 0;
                counter = 0;
                requestLists.add(transportAbsenceDatePaymentModel);


            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            // ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//    public int getAllTransportAbsenteDateList(String serviceId, String shift, String date) {
//        int exist = 0;
//        try {
//
//            ResultSet _rs = transportPaymentRequestEntity.selectTransportAbsentDayList(serviceId, shift, date);
//            while (_rs.next()) {
//                exist = 1;
//            }
//            return exist;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return 0;
//        }
//    }

//    public ArrayList<TransportAbsenceDatePaymentModel> getAllTransportAbsenteDateList(String serviceId, String shift, String date) {
//        ArrayList<TransportAbsenceDatePaymentModel> requestLists = new ArrayList<TransportAbsenceDatePaymentModel>();
//        try {
//
//            ResultSet _rs = transportPaymentRequestEntity.selectTransportAbsentDayList(serviceId, shift, date);
//            String temp = null;
//            while (_rs.next()) {
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel();
//                transportAbsenceDatePaymentModel = new TransportAbsenceDatePaymentModel();
//                 transportAbsenceDatePaymentModel.setAbsenceId(_rs.getInt("ABSENCE_ID"));
////                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
//                 temp = _rs.getString("SERVICE_ID");
//                 ResultSet _rs2 = transportAbsenceDateRegistrationEntity.selectDestnationName(temp);
//                 while (_rs2.next()) {
//                transportAbsenceDatePaymentModel.setServiceName(_rs2.getString("SERVICE_DESTINATION_NAME")); }
//                transportAbsenceDatePaymentModel.setShift(_rs.getString("SHIFT"));
//                transportAbsenceDatePaymentModel.setInOut(_rs.getString("INOROUT"));
//                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ABSENCE_DATE"));
//                transportAbsenceDatePaymentModel.setStatus("Old");
//                requestLists.add(transportAbsenceDatePaymentModel);
//            }
//            return requestLists;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }

//    public int getAllEmployeeAbsenteDateList(String empId,  String date) {
//        int exist = 0;
//        try {
//
//            ResultSet _rs = transportPaymentRequestEntity.selectEmployeeAbsentDayList(empId,  date);
//            while (_rs.next()) {
//                exist = 1;
//            }
//            return exist;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return 0;
//        }
//    }
    public ArrayList<TransportPaymentsModel> getAllEmployeeAbsenteDateList(String empId, String date) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {

            ResultSet _rs = transportPaymentRequestEntity.selectEmployeeAbsentDayList(empId, date);
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("ID"));
//                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
                transportAbsenceDatePaymentModel.setServiceName(_rs.getString("EMP_ID"));
                transportAbsenceDatePaymentModel.setShift(_rs.getString("ATTENDANCETAKENDATE"));
                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ABSENTAMOUNT"));
                transportAbsenceDatePaymentModel.setStatus(_rs.getString("DAYDESCRIPTION"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TransportPaymentsModel> getAllEmployeeAbseDateList(String strDate, String endDate) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {

            ResultSet _rs = transportPaymentRequestEntity.selectEmployeeAbsentDay(strDate, endDate);
            String temp = null;
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("ID"));
//                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_ID"));
                transportAbsenceDatePaymentModel.setEmployeeId(_rs.getString("EMP_ID"));
                transportAbsenceDatePaymentModel.setAbsenceDate(_rs.getString("ATTENDANCETAKENDATE"));
                transportAbsenceDatePaymentModel.setAbsentAmount(_rs.getString("ABSENTAMOUNT"));
                transportAbsenceDatePaymentModel.setStatus(_rs.getString("DAYDESCRIPTION"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TransportPaymentsModel> getServiceInformation(int locationId) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();

        try {

            ResultSet _rs = transportPaymentRequestEntity.selectServiceInformation(locationId);
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setServiceId(_rs.getString("SERVICE_DESTINATIONS"));
                transportAbsenceDatePaymentModel.setExtraPaymentPerDay(_rs.getDouble("EXTRA_TARIF"));
                transportAbsenceDatePaymentModel.setActualLocation(_rs.getString("ACTUAL_LOCATION"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public double getTarif(int serviceId) {
        double requestLists = 0.0;

        try {

            ResultSet _rs = transportPaymentRequestEntity.selectTarif(serviceId);
            while (_rs.next()) {

                requestLists = _rs.getDouble("TARIF");

            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

//    public String getEmpDept(String empId) {
//        String deptName = null;
//        try {
//
//            ResultSet _rs = transportPaymentRequestEntity.selectEmpDept(empId);
//            while (_rs.next()) {
//                deptName = _rs.getString("dept_name");
//            }
//            return deptName;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
    public String getEmpLocation(String empId) {
        String locationName = null;
        try {

            ResultSet _rs = transportPaymentRequestEntity.selectEmpLocation(empId);
            while (_rs.next()) {
                locationName = _rs.getString("LOCATION");
            }
            return locationName;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getPendingRequests(String loggedInEmployeeId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = transportPaymentRequestEntity.selectPendingRequests(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMyRequestsHistory(String loggedInEmployeeId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = transportPaymentRequestEntity.selectMyRequestsHistory(loggedInEmployeeId);
            while (_rs.next()) {
//                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE")+ " - " + _rs.getString("REQUEST_STATUS"));
                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public TransportPaymentsModel getRequestAttributes(int transportPaymentRequestId) {
        transportAbsenceDatePaymentModel = new TransportPaymentsModel();
        try {
            ResultSet _rs = transportPaymentRequestEntity.selectRequestAttributes(transportPaymentRequestId);
            if (_rs.next()) {
                transportAbsenceDatePaymentModel.setTransportPaymentId(_rs.getInt("TRANSPORT_PAYMENT_REQUEST_ID"));
                transportAbsenceDatePaymentModel.setRequestDate(_rs.getString("REQUEST_DATE"));
                transportAbsenceDatePaymentModel.setStartDate(_rs.getString("START_DATE"));
                transportAbsenceDatePaymentModel.setEndDate(_rs.getString("END_DATE"));
            } else {
                transportAbsenceDatePaymentModel.setTransportPaymentId(-1);
            }
            return transportAbsenceDatePaymentModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    int checkEmployeeAbsent(String employeeId, String serDate) {
        for (TransportPaymentsModel obj : getEmployeeAbsent()) {
            if (obj.getEmployeeId().equals(employeeId) && obj.getAbsenceDate().equals(serDate)) {
                return Integer.parseInt(obj.getAbsentAmount());
            }
        }
        return 0;
    }

    int checkServiceAbsent(String employeeId, String serDate) {
        for (TransportPaymentsModel obj : getEmployeeAbsent()) {
            if (obj.getEmployeeId().equals(employeeId) && obj.getAbsenceDate().equals(serDate)) {
                return Integer.parseInt(obj.getAbsentAmount());
            }
        }
        return 0;
    }

    public ArrayList<TransportPaymentsModel> getListOfEmployeeTransportPayment(String from, String to) {
        ArrayList<TransportPaymentsModel> list = new ArrayList<TransportPaymentsModel>();
        try {
            Date startDate;
            Date endDate;
//        String start = txtStartDate.getValue().toString();
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            startDate = (Date) formatter.parse(from);
            endDate = (Date) formatter.parse(to);
            Calendar startCal;
            Calendar endCal;
            startCal = Calendar.getInstance();
            startCal.setTime(startDate);
            endCal = Calendar.getInstance();
            endCal.setTime(endDate);
            ArrayList<TransportPaymentRequestEntity> employeeWithList = transportPaymentRequestEntity.getEmployeeList();

            int i = 0;
            ArrayList<TransportPaymentsModel> list1 = null;
            //i = 0;
            list1 = getAllEmployeeAbseDateList(from, to);
            for (TransportPaymentRequestEntity obj : employeeWithList) {

                do {

                    for (TransportPaymentsModel obj2 : list1) {
                        if (obj2.getAbsenceDate().equals(formatter.format(startCal.getTime()))) {
                            System.out.println("employee ID--" + i + " ---" + obj2.getEmployeeId());//obj2.getServiceId());
                            i++;
                            break;
                        }

                    }
                    startCal.add(Calendar.DAY_OF_MONTH, 1);

                } while (startCal.getTimeInMillis() < endCal.getTimeInMillis());
                TransportPaymentsModel transportPayment = new TransportPaymentsModel(
                        1,
                        "serviceDestination",
                        obj.getEmployeeId(),
                        obj.getEmplopyeeFullName(),
                        0.0, //"transportAbsenteDate",
                        0.0, //  "employeeAbsenteDate",
                        0.0, //  "tarif",
                        0.0, //"paymentForSAbsenceRound",
                        0.0, //"daysInMonth",
                        0.0, //  "totalEmpAbesntDays",
                        0.0, //"extraTarif",
                        0.0, // "paymentForNoTransportRound",
                        0.0);// "totalPaymentRound");

                list.add(transportPayment);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;

    }

    public static void main(String arg[]) {
        TransportPaymentRequestManager obj = new TransportPaymentRequestManager();
        obj.getListOfEmployeeTransportPayment("2012-12-02", "2013-02-02");
    }
}
