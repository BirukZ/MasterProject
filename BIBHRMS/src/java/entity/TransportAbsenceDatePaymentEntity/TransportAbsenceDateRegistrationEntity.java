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
import manager.TransportAbsenceDatePaymentManager.TransportPaymentsModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Henok
 */
public class TransportAbsenceDateRegistrationEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

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

    public ResultSet selectAllServiceList() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_TRANSPORT_SERVIVE ";
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

    public int insertTransportAbsenceDate(ArrayList<TransportPaymentsModel> transportAbsentDateList) throws SQLException {

        String _insertEmployeesListQuery = "INSERT INTO HR_TRANSPORT_ABSENCE_DATE " +
                //" (OVER_TIME_EMPLOYEE_ID,REQUEST_ID,EMPLOYEE_ID,START_DATE,START_TIME,END_DATE,END_TIME,OVER_TIME_FACTOR)" +
                " (ABSENCE_ID,SERVICE_ID,SHIFT,INOROUT,ABSENCE_DATE)" +
                " VALUES (HR_OVER_TIME_EMPLOYEE_SEQ.NEXTVAL," +
                " ?,?,?,?) ";
        try {
            //////////////////////////////////
            _con = getConnection();
            PreparedStatement _ps2 = _con.prepareStatement(_insertEmployeesListQuery);
            int lengthOfList = transportAbsentDateList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps2.setString(1, transportAbsentDateList.get(counter).getServiceId());
//                _ps2.setString(2, employeeAndTimeList.get(counter).getServiceName());
                _ps2.setString(2, transportAbsentDateList.get(counter).getShift());
                _ps2.setString(3, transportAbsentDateList.get(counter).getInOut());
                _ps2.setString(4, transportAbsentDateList.get(counter).getAbsenceDate());
                //   _ps2.setDouble(6, employeeAndTimeList.get(counter).getOverTimeFactor());
                _ps2.addBatch();
            }
            _ps2.executeBatch();
            _ps2.clearBatch();
            _ps2.close();
            return 1;

        } finally {
            releaseResources();
        }
    }

    public boolean updateTransportAbsenceDate(ArrayList<TransportPaymentsModel> transportAbsentDateList) throws SQLException {

        String sql = "UPDATE HR_TRANSPORT_ABSENCE_DATE " +
                "SET SERVICE_ID  =?, " +
                "  SHIFT         =?, " +
                "  INOROUT       =?, " +
                "  ABSENCE_DATE  =? " +
                "WHERE ABSENCE_ID=?";
        try {

            _con = getConnection();
            PreparedStatement _ps2 = _con.prepareStatement(sql);
            ArrayList<TransportPaymentsModel> updateListOfAbsent = transportAbsentDateList;
            for (TransportPaymentsModel obj : updateListOfAbsent) {
                _ps2.setString(1, obj.getServiceId());
                _ps2.setString(2, obj.getShift());
                _ps2.setString(3, obj.getInOut());
                _ps2.setString(4, obj.getAbsenceDate());
                _ps2.setInt(5, obj.getAbsenceId());
                _ps2.addBatch();
            }
            int check[] = _ps2.executeBatch();
            for (int i : check) {
                if (i == PreparedStatement.EXECUTE_FAILED) {
                    _ps2.clearBatch();
                    _ps2.close();
                    return false;
                }
            }
            _ps2.clearBatch();
            _ps2.close();
            return true;

        } finally {
            releaseResources();
        }
    }

    public boolean deleteTransportAbsentDates(int absentId) throws SQLException {
        String _deleteQuery = "DELETE HR_TRANSPORT_ABSENCE_DATE " +
                " where ABSENCE_ID =? ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, absentId);
            if(_ps.executeUpdate()>0){
                return true;
            }else{
               return false;
            }


        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTransportAbsenceDates() throws SQLException {
        String _selectQuery = "SELECT TA.ABSENCE_ID, " +
                "  TA.SERVICE_ID, " +
                "  TA.SHIFT, " +
                "  TA.INOROUT, " +
                "  TA.ABSENCE_DATE, " +
                "  TS.SERVICE_DESTINATION " +
                "FROM HR_TRANSPORT_ABSENCE_DATE TA " +
                "INNER JOIN HR_LU_TRANSPORT_SERVIVE TS " +
                "ON TA.SERVICE_ID=TS.ID";

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

    public ResultSet selectUNShiftWork(String empId, int actualShift, String date) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_LU_WORK_WITHOUT_SHIFT  " +
                " WHERE   EMP_ID= '" + empId + "'" +
                " and ACTUAL_SHIFT= " + actualShift + "" +
                " and WORK_DATE= '" + date + "'";
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

        public ResultSet selectServiceNotWorkingDay(String from, String to) throws SQLException {
        String _selectQuery = " SELECT * " +
                " FROM HR_LU_WORK_WITHOUT_SHIFT  " +
                " WHERE   EMP_ID= '" + from + "'" +
                " and ACTUAL_SHIFT= " + to + "" ;
                //" and WORK_DATE= '" + date + "'";
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
    public ResultSet selectsundayOrHolyday(String empId, String date) throws SQLException {

        String _selectQuery = " SELECT * " +
                " FROM HR_OVER_TIME_ATTEND_EMPLOYEE  " +
                " WHERE   EMPLOYEE_ID= '" + empId + "'" +
                " and ATTENDED LIKE 'YES' " +
                " and OT_APPROVED LIKE 'YES' " +
                " and OT_ATTENDANCE_ID IN " +
                "  (SELECT HR_OVER_TIME_ATTENDANCE_ID " +
                "  FROM HR_OVER_TIME_ATTENDANCE " +
                "  WHERE ATTENDANCE_DATE ='" + date + "'" +
                "  )";

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
        String _selectQuery = " SELECT SERVICE_DESTINATION " +
                //  " SELECT OVER_TIME_EMPLOYEE_ID, REQUEST_ID, EMPLOYEE_ID, START_DATE, START_TIME, END_DATE, END_TIME, OVER_TIME_FACTOR,STATUS, " +
                " FROM HR_LU_TRANSPORT_SERVIVE  " +
                " WHERE ID = " + serviceId;

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
}
