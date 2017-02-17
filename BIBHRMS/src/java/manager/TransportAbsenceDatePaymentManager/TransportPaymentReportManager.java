/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.TransportAbsenceDatePaymentManager;

import entity.TransportAbsenceDatePaymentEntity.TransportPaymentReportEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Henok
 */
public class TransportPaymentReportManager {

    TransportPaymentReportEntity transportPaymentRequestEntity = new TransportPaymentReportEntity();

    public ArrayList<TransportPaymentModel> getTransportPaymentRequests() {
        ArrayList<TransportPaymentModel> transportPaymentRequestLists = new ArrayList<TransportPaymentModel>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {
        try {
            ResultSet _rs = transportPaymentRequestEntity.readAllTransportPaymentApprovedByMonth(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String serviceAbsentDate = _rs.getString("S_ABSENT_DATE");
                String employeeAbsentDate = _rs.getString("E_ABSENT_DATE");
                String tarifPerDay = _rs.getString("TARIF_PER_DAY");
                String paymentForserviceAbsent = _rs.getString("PAYMENT_FOR_S_ABSENT");
                String daysInMonth = _rs.getString("DAYS_IN_MONTH");
                String totalEmployeeAbsentDays = _rs.getString("TOTAL_E_ABSENT_DAYS");
                String extraPaymentPerDay = _rs.getString("EXTRA_PAYMENT_PER_DAY");
                String totalExtraPayment = _rs.getString("TOTAL_EXTRA_PAYMENT");
                String totalPayment = _rs.getString("TOTAL_PAYMENT");
                String departmentPath = _rs.getString("department_path");
                String jobDescription = _rs.getString("job_description");
                String appliedDate = _rs.getString("REQUEST_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                TransportPaymentModel transportPaymentModel = new TransportPaymentModel(employeeId,fullName, sex, serviceAbsentDate, employeeAbsentDate, tarifPerDay, paymentForserviceAbsent,
                        daysInMonth, totalEmployeeAbsentDays, extraPaymentPerDay, totalExtraPayment, totalPayment, departmentPath, jobDescription, appliedDate, startDate, endDate);
                transportPaymentRequestLists.add(transportPaymentModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly"))
               {
        try {
            ResultSet _rs = transportPaymentRequestEntity.readAllTransportPaymentApprovedByQuarter(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String serviceAbsentDate = _rs.getString("S_ABSENT_DATE");
                String employeeAbsentDate = _rs.getString("E_ABSENT_DATE");
                String tarifPerDay = _rs.getString("TARIF_PER_DAY");
                String paymentForserviceAbsent = _rs.getString("PAYMENT_FOR_S_ABSENT");
                String daysInMonth = _rs.getString("DAYS_IN_MONTH");
                String totalEmployeeAbsentDays = _rs.getString("TOTAL_E_ABSENT_DAYS");
                String extraPaymentPerDay = _rs.getString("EXTRA_PAYMENT_PER_DAY");
                String totalExtraPayment = _rs.getString("TOTAL_EXTRA_PAYMENT");
                String totalPayment = _rs.getString("TOTAL_PAYMENT");
                String departmentPath = _rs.getString("department_path");
                String jobDescription = _rs.getString("job_description");
                String appliedDate = _rs.getString("REQUEST_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                TransportPaymentModel transportPaymentModel = new TransportPaymentModel(employeeId,fullName, sex, serviceAbsentDate, employeeAbsentDate, tarifPerDay, paymentForserviceAbsent,
                        daysInMonth, totalEmployeeAbsentDays, extraPaymentPerDay, totalExtraPayment, totalPayment, departmentPath, jobDescription, appliedDate, startDate, endDate);
                transportPaymentRequestLists.add(transportPaymentModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually"))
               {
        try {
            ResultSet _rs = transportPaymentRequestEntity.readAllTransportPaymentApprovedBySimiannual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String serviceAbsentDate = _rs.getString("S_ABSENT_DATE");
                String employeeAbsentDate = _rs.getString("E_ABSENT_DATE");
                String tarifPerDay = _rs.getString("TARIF_PER_DAY");
                String paymentForserviceAbsent = _rs.getString("PAYMENT_FOR_S_ABSENT");
                String daysInMonth = _rs.getString("DAYS_IN_MONTH");
                String totalEmployeeAbsentDays = _rs.getString("TOTAL_E_ABSENT_DAYS");
                String extraPaymentPerDay = _rs.getString("EXTRA_PAYMENT_PER_DAY");
                String totalExtraPayment = _rs.getString("TOTAL_EXTRA_PAYMENT");
                String totalPayment = _rs.getString("TOTAL_PAYMENT");
                String departmentPath = _rs.getString("department_path");
                String jobDescription = _rs.getString("job_description");
                String appliedDate = _rs.getString("REQUEST_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                TransportPaymentModel transportPaymentModel = new TransportPaymentModel(employeeId,fullName, sex, serviceAbsentDate, employeeAbsentDate, tarifPerDay, paymentForserviceAbsent,
                        daysInMonth, totalEmployeeAbsentDays, extraPaymentPerDay, totalExtraPayment, totalPayment, departmentPath, jobDescription, appliedDate, startDate, endDate);
                transportPaymentRequestLists.add(transportPaymentModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually"))
               {
        try {
            ResultSet _rs = transportPaymentRequestEntity.readAllTransportPaymentApprovedByAnnual(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String serviceAbsentDate = _rs.getString("S_ABSENT_DATE");
                String employeeAbsentDate = _rs.getString("E_ABSENT_DATE");
                String tarifPerDay = _rs.getString("TARIF_PER_DAY");
                String paymentForserviceAbsent = _rs.getString("PAYMENT_FOR_S_ABSENT");
                String daysInMonth = _rs.getString("DAYS_IN_MONTH");
                String totalEmployeeAbsentDays = _rs.getString("TOTAL_E_ABSENT_DAYS");
                String extraPaymentPerDay = _rs.getString("EXTRA_PAYMENT_PER_DAY");
                String totalExtraPayment = _rs.getString("TOTAL_EXTRA_PAYMENT");
                String totalPayment = _rs.getString("TOTAL_PAYMENT");
                String departmentPath = _rs.getString("department_path");
                String jobDescription = _rs.getString("job_description");
                String appliedDate = _rs.getString("REQUEST_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                TransportPaymentModel transportPaymentModel = new TransportPaymentModel(employeeId,fullName, sex, serviceAbsentDate, employeeAbsentDate, tarifPerDay, paymentForserviceAbsent,
                        daysInMonth, totalEmployeeAbsentDays, extraPaymentPerDay, totalExtraPayment, totalPayment, departmentPath, jobDescription, appliedDate, startDate, endDate);
                transportPaymentRequestLists.add(transportPaymentModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily"))
               {
        try {
            ResultSet _rs = transportPaymentRequestEntity.readAllTransportPaymentApprovedByDays(ReportCriteraManager.getParametrsForDay(), ReportCriteraManager.getEmployeeId(), ReportCriteraManager.isAllEmployee());
            while (_rs.next()) {
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String fullName = _rs.getString("FULL_NAME");
                String sex = _rs.getString("SEX");
                String serviceAbsentDate = _rs.getString("S_ABSENT_DATE");
                String employeeAbsentDate = _rs.getString("E_ABSENT_DATE");
                String tarifPerDay = _rs.getString("TARIF_PER_DAY");
                String paymentForserviceAbsent = _rs.getString("PAYMENT_FOR_S_ABSENT");
                String daysInMonth = _rs.getString("DAYS_IN_MONTH");
                String totalEmployeeAbsentDays = _rs.getString("TOTAL_E_ABSENT_DAYS");
                String extraPaymentPerDay = _rs.getString("EXTRA_PAYMENT_PER_DAY");
                String totalExtraPayment = _rs.getString("TOTAL_EXTRA_PAYMENT");
                String totalPayment = _rs.getString("TOTAL_PAYMENT");
                String departmentPath = _rs.getString("department_path");
                String jobDescription = _rs.getString("job_description");
                String appliedDate = _rs.getString("REQUEST_DATE");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                TransportPaymentModel transportPaymentModel = new TransportPaymentModel(employeeId,fullName, sex, serviceAbsentDate, employeeAbsentDate, tarifPerDay, paymentForserviceAbsent,
                        daysInMonth, totalEmployeeAbsentDays, extraPaymentPerDay, totalExtraPayment, totalPayment, departmentPath, jobDescription, appliedDate, startDate, endDate);
                transportPaymentRequestLists.add(transportPaymentModel);
            }
            _rs.close();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
       }

        return transportPaymentRequestLists;
    }

}
