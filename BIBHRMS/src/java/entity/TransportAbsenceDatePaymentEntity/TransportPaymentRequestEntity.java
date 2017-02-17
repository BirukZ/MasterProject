/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.TransportAbsenceDatePaymentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.TransportAbsenceDatePaymentManager.TransportAbsenceDatePaymentApproveManager;
import manager.TransportAbsenceDatePaymentManager.TransportPaymentsModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Henok
 */
public class TransportPaymentRequestEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    private String employeeId;
    private String employeeLocationId;
    private String locationId;
    private String emplopyeeFullName;
    private String extraTarife;
    private String workingTime;
    private String locationName;
    private String location;
    private String tarif;

    public String getEmplopyeeFullName() {
        return emplopyeeFullName;
    }

    public void setEmplopyeeFullName(String emplopyeeFullName) {
        this.emplopyeeFullName = emplopyeeFullName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLocationId() {
        return employeeLocationId;
    }

    public void setEmployeeLocationId(String employeeLocationId) {
        this.employeeLocationId = employeeLocationId;
    }

    public String getExtraTarife() {
        return extraTarife;
    }

    public void setExtraTarife(String extraTarife) {
        this.extraTarife = extraTarife;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getTarif() {
        return tarif;
    }

    public void setTarif(String tarif) {
        this.tarif = tarif;
    }

    public String getWorkingTime() {
        return workingTime;
    }

    public void setWorkingTime(String workingTime) {
        this.workingTime = workingTime;
    }

    public TransportPaymentRequestEntity() {
    }

    public TransportPaymentRequestEntity(String employeeId,
            String employeeLocationId,
            String locationId,
            String emplopyeeFullName,
            String extraTarife,
            String workingTime,
            String locationName,
            String location,
            String tarif) {
        this.employeeId = employeeId;
        this.employeeLocationId = employeeLocationId;
        this.locationId = locationId;
        this.emplopyeeFullName = emplopyeeFullName;
        this.extraTarife = extraTarife;
        this.workingTime = workingTime;
        this.locationName = locationName;
        this.location = location;
        this.tarif = tarif;
    }

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
            closePooledConnections(_con);
        }
    }

    public ResultSet selectTransportAbsenceDates() throws SQLException {
        String _selectQuery = " SELECT ABSENCE_ID, SERVICE_ID, SHIFT, ABSENCE_DATE " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FROM HR_TRANSPORT_ABSENCE_DATE  ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectDestnationName(String serviceId) throws SQLException {
        String _selectQuery = " SELECT SERVICE_DESTINATION_NAME " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FROM HR_LU_TRANSPORT_SERVIVE  " +
                " WHERE SERVICE_ID = '" + serviceId + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTransportPayment(ArrayList<TransportPaymentsModel> transportPaymentList, String requesterId, String appliedDate,
            String startDate, String endDate, String status, String recorededDateAndTime, String userName) throws SQLException {

        String _insertAttributesQuery = "INSERT " +
                "INTO HR_TRANSPORT_PAYMENT_REQUEST " +
                "  ( " +
                "    TRANSPORT_PAYMENT_REQUEST_ID, " +
                "    REQUESTER_ID, " +
                "    REQUEST_DATE, " +
                "    START_DATE, " +
                "    END_DATE, " +
                "    REQUEST_STATUS, " +
                "    TIME_STAMP, " +
                "    USER_NAME " +
                "  )" +
                " VALUES( HR_TRANSPORT_PAYMENT_SEQ.NEXTVAL,?,?,?,?,?,?,? )";

        String _insertParticipantsListQuery = "INSERT INTO HR_TRANSPORT_PAYMENT_EMP_LIST " +
                "  ( " +
                "    TRANSPORT_PAYMENT_EMP_ID, " +
                "    TRANSPORT_PAYMENT_REQUEST_ID, " +
                "    EMPLOYEE_ID, " +
                "    S_ABSENT_DATE, " +
                "    E_ABSENT_DATE, " +
                "    TARIF_PER_DAY, " +
                "    PAYMENT_FOR_S_ABSENT, " +
                "    DAYS_IN_MONTH, " +
                "    TOTAL_E_ABSENT_DAYS, " +
                "    EXTRA_PAYMENT_PER_DAY, " +
                "    TOTAL_EXTRA_PAYMENT, " +
                "    TOTAL_PAYMENT, " +
                "    SERVICE_DESTINATION " +
                "  ) " +
                "  VALUES " +
                "  ( HR_TRANSPORT_PAYMENT_EMP_SEQ.NEXTVAL, HR_TRANSPORT_PAYMENT_SEQ.CURRVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertAttributesQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, appliedDate);
            _ps.setString(3, startDate);
            _ps.setString(4, endDate);
            _ps.setString(5, status);
            _ps.setString(6, recorededDateAndTime);
            _ps.setString(7, userName);
            _ps.executeQuery();
            //============
            _ps = _con.prepareStatement(_insertParticipantsListQuery);
            for (TransportPaymentsModel currentRequest : transportPaymentList) {
                _ps.setString(1, currentRequest.getEmployeeId());
                _ps.setDouble(2, currentRequest.getServiceAbsenteDate());
                _ps.setDouble(3, currentRequest.getEmployeeAbsenteDate());
                _ps.setDouble(4, currentRequest.getTarifPerDay());
                _ps.setDouble(5, currentRequest.getPaymentForSAbsence());
                _ps.setDouble(6, currentRequest.getDaysInMonth());
                _ps.setDouble(7, currentRequest.getTotalEAbsenteDays());
                _ps.setDouble(8, currentRequest.getExtraPaymentPerDay());
                _ps.setDouble(9, currentRequest.getPaymentForNoTransport());
                _ps.setDouble(10, currentRequest.getTotalPayment());
                _ps.setString(11, currentRequest.getActualLocation());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEmployeeAndTransportPaymentList(int requestId) throws SQLException {
        String _selectQuery = " SELECT TRANSPORT_PAYMENT_EMP_ID, TRANSPORT_PAYMENT_REQUEST_ID, EMPLOYEE_ID, S_ABSENT_DATE, E_ABSENT_DATE, TARIF_PER_DAY, PAYMENT_FOR_S_ABSENT, DAYS_IN_MONTH, TOTAL_E_ABSENT_DAYS, EXTRA_PAYMENT_PER_DAY, TOTAL_EXTRA_PAYMENT, TOTAL_PAYMENT, SERVICE_DESTINATION, " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FIRST_NAME,MIDDLE_NAME,LAST_NAME, DEPARTMENT_NAME " +
                " FROM VW_EMPLOYEE_BY_DEPARTMENT_LIST  , HR_TRANSPORT_PAYMENT_EMP_LIST  " +
                " WHERE   EMPLOYEE_ID=EMP_ID" +
                " and TRANSPORT_PAYMENT_REQUEST_ID= " + requestId + " " +
                " ORDER BY SERVICE_DESTINATION ASC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllEmployeeLocationList() throws SQLException {
        String _selectQuery = "SELECT Emplocationid, " +
                "  LOCATIONID, " +
                "  Ei.Emp_Id, " +
                "  Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Fullname, " +
                "  Lu.Extra_Tarif, " +
                "  Ei.Location, " +
                "  Ei.Office_Or_Shift , " +
                "  Lu.Actual_Location, " +
                "  TS.TARIF " +
                "FROM Hr_Emp_Location LC " +
                "INNER JOIN Hr_Employee_Info Ei " +
                "ON Lc.Emp_Id=Ei.Emp_Id " +
                "INNER JOIN Hr_Lu_Location Lu " +
                "ON Lc.Locationid=Lu.Location_Id " +
                "INNER JOIN Hr_Lu_Transport_Servive Ts " +
                "ON LU.SERVICE_DESTINATIONS=TS.ID " +
                "WHERE EI.LOCATION         ='Addis Ababa' " +
                "AND EI.EMP_STATUS        IN('01','07') " +
                "ORDER BY LOCATIONID ASC";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<TransportPaymentRequestEntity> getEmployeeList() throws SQLException {
        ArrayList<TransportPaymentRequestEntity> listOfEmplouee = new ArrayList<TransportPaymentRequestEntity>();
        String _selectQuery = "SELECT Emplocationid, " +
                "  LOCATIONID, " +
                "  Ei.Emp_Id, " +
                "  Ei.First_Name " +
                "  ||' ' " +
                "  || Ei.Middle_Name " +
                "  ||' ' " +
                "  || Ei.Last_Name AS Fullname, " +
                "  Lu.Extra_Tarif, " +
                "  Ei.Location, " +
                "  Ei.Office_Or_Shift , " +
                "  Lu.Actual_Location, " +
                "  TS.TARIF " +
                "FROM Hr_Emp_Location LC " +
                "INNER JOIN Hr_Employee_Info Ei " +
                "ON Lc.Emp_Id=Ei.Emp_Id " +
                "INNER JOIN Hr_Lu_Location Lu " +
                "ON Lc.Locationid=Lu.Location_Id " +
                "INNER JOIN Hr_Lu_Transport_Servive Ts " +
                "ON LU.SERVICE_DESTINATIONS=TS.ID " +
                " WHERE EI.LOCATION         ='Addis Ababa' " +
                " AND EI.EMP_STATUS        IN('01','07') " +
                " ORDER BY LOCATIONID ASC ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                listOfEmplouee.add(new TransportPaymentRequestEntity(
                        _rs.getString("Emp_Id"),
                        _rs.getString("Emplocationid"),
                        _rs.getString("LOCATIONID"),
                        _rs.getString("Fullname"),
                        _rs.getString("Extra_Tarif"),
                        _rs.getString("Office_Or_Shift"),
                        _rs.getString("Actual_Location"),
                        _rs.getString("Location"),
                        _rs.getString("TARIF")));
            }
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
            return listOfEmplouee;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTransportAbsentDayList(String serviceId, String shift, String date) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_TRANSPORT_ABSENCE_DATE  " +
                " WHERE   SERVICE_ID= '" + serviceId + "'" +
                " and SHIFT= '" + shift + "'" +
                " and ABSENCE_DATE= '" + date + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEmployeeAbsentDayList(String empId, String date) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_EMP_ATTENDANCE  " +
                " WHERE   EMP_ID= '" + empId + "'" +
                " and ATTENDANCETAKENDATE= '" + date + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEmployeeAbsentDay(String strDate, String enddate) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EMP_ATTENDANCE " +
                "WHERE Attendancetakendate BETWEEN '" + strDate + "' AND '" + enddate + "' " +
                "ORDER BY EMP_ID, " +
                " Attendancetakendate";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectServiceInformation(int locationId) throws SQLException {
        String _selectQuery = " SELECT SERVICE_DESTINATIONS, EXTRA_TARIF, ACTUAL_LOCATION " +
                " FROM HR_LU_LOCATION  " +
                " WHERE   LOCATION_ID= " + locationId + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTarif(int serviceId) throws SQLException {
        String _selectQuery = " SELECT TARIF " +
                " FROM HR_LU_TRANSPORT_SERVIVE  " +
                " WHERE   ID= " + serviceId + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

//    public ResultSet selectEmpDept(String empId) throws SQLException {
//        String _selectQuery = "SELECT de.dept_name " +
//                "FROM hr_employee_info EI, " +
//                "  tbl_department DE " +
//                "WHERE EI.DEPARTMENT_ID=DE.DEPT_ID " +
//                "AND EI.EMP_ID         = '"+empId+"'";
////                "AND (DE.DEPT_NAME LIKE '%Mugher%' " +
////                "OR DE.DEPT_NAME LIKE '%???%' )";
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }
    public ResultSet selectEmpLocation(String empId) throws SQLException {
        String _selectQuery = "SELECT LOCATION " +
                "FROM HR_EMPLOYEE_INFO " +
                "WHERE EMP_ID         = '" + empId + "'";
//                "AND (DE.DEPT_NAME LIKE '%Mugher%' " +
//                "OR DE.DEPT_NAME LIKE '%???%' )";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingRequests(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE  (REQUESTER_ID= ?" +
                " OR USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID=? ))" +
                " AND  REQUEST_STATUS = ? " +
                " ORDER BY TRANSPORT_PAYMENT_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _ps.setString(3, TransportAbsenceDatePaymentApproveManager.INITIAL_STATE_TRANSPORT_PAYMENT);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectMyRequestsHistory(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE " +
                " ( REQUESTER_ID like ?  OR  USER_NAME IN (select USER_NAME from mugher.tbl_users where EMPLOYEE_ID  like ?  ) ) " +
                " AND REQUEST_STATUS not like " + TransportAbsenceDatePaymentApproveManager.INITIAL_STATE_TRANSPORT_PAYMENT +
                " ORDER BY TRANSPORT_PAYMENT_REQUEST_ID DESC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _ps.setString(2, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectRequestAttributes(int requestId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_TRANSPORT_PAYMENT_REQUEST " +
                " WHERE TRANSPORT_PAYMENT_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
//    public static void main(String arg[]){
//        try {
//            TransportPaymentRequestEntity boj =new TransportPaymentRequestEntity();
//            boj.selectEmpDept("AT/00029");
//        } catch (Exception e) {
//            e.printStackTrace();
//
//        }
//    }
}
