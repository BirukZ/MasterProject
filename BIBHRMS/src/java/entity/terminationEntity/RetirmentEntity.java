/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class RetirmentEntity extends ConnectionManager {

    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Connection _con = null;

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

    public RetirmentEntity() {
    }
    private int id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    private String selDeps;

    public String getSelDeps() {
        return selDeps;
    }

    public void setSelDeps(String selDeps) {
        this.selDeps = selDeps;
    }
    String terminationId;
    String employeeId;
    String code;

    public Connection get_con() {
        return _con;
    }

    public void set_con(Connection _con) {
        this._con = _con;
    }

    public PreparedStatement get_ps() {
        return _ps;
    }

    public void set_ps(PreparedStatement _ps) {
        this._ps = _ps;
    }

    public ResultSet get_rs() {
        return _rs;
    }

    public void set_rs(ResultSet _rs) {
        this._rs = _rs;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }
    String description;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTerminationId() {
        return terminationId;
    }

    public void setTerminationId(String terminationId) {
        this.terminationId = terminationId;
    }

    public RetirmentEntity(String selDeps) {
        this.selDeps = selDeps;
    }

    public RetirmentEntity(String terminationId, String employeeId) {
        this.terminationId = terminationId;
        this.employeeId = employeeId;
    }

    public RetirmentEntity(String experianceId, String code, String description) {
        // this.experianceId = experianceId;
        this.code = code;
        this.description = description;
    }

    public int UpdateClearDepartments(String _depId, String _status) {
        String _update = "UPDATE TBL_DEPARTMENT SET REQUIRE_CLEARANCE='" + _status + "' WHERE DEPT_ID='" + _depId + "'";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            int row = _ps.executeUpdate();
//            closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                _ps.close();
            } catch (Exception ignore) {
            }
        }
    }

    public OracleCachedRowSet readClearedDepartmentDetail(String employeeId, int clearanceType, int departmentId) {
        String _select = "SELECT CLEARED_ID," +
                "                CLEARED_BY," +
                "                CLEARED_DATE " +
                "         FROM HR_TERMINATION_CLEARED " +
                "         WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "' AND CLEARED_DEPARTMENT='" + departmentId + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readClearedDepartmentDetailHistory(String clearedId) {
        String _select = "SELECT RETURNED_YES," +
                "                RETURNED_NO," +
                "                RETURNED_REMARK " +
                "         FROM HR_TERMINATION_CLEARED_HISTORY " +
                "         WHERE CLEARED_ID='" + clearedId + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readClearanceRequests() {
        String _select = "SELECT EMP_ID FROM HR_TERMINATION_CLEARANCE WHERE CLEARANCE_STATUS=0";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readClearanceRequestsCleared() {
        String _select = "SELECT EMP_ID FROM HR_TERMINATION_CLEARANCE WHERE CLEARANCE_STATUS=1";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readClearancRequests() {
        String _select = "SELECT EMP_ID FROM HR_TERMINATION_CLEARANCE WHERE CLEARANCE_STATUS=0";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet checkEmployeeClearance(String employeeId, String departmentId) {
        String _select = "SELECT  * FROM HR_TERMINATION_CLEARED WHERE EMP_ID='" + employeeId + "' AND CLEARED_DEPARTMENT='" + departmentId + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readRequestsDetails(String employeeId) {
        String _select = "SELECT  * FROM HR_TERMINATION_CLEARANCE WHERE EMP_ID='" + employeeId + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public OracleCachedRowSet readRequestsDetailsHistory(int clearedId) {
        String _select = "SELECT  * FROM  HR_TERMINATION_CLEARED_HISTORY WHERE CLEARED_ID='" + clearedId + "'";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public OracleCachedRowSet loadClearedDepartmentsReport(String employeeId, int type) {
        String _select = "SELECT " +
                "       C.CLEARED_BY, " +
                "       C.CLEARED_DATE," +
                "       C.CLEARED_DEPARTMENT," +
                "       H.RETURNED_YES," +
                "       H.RETURNED_NO," +
                "       H.RETURNED_REMARK" +
                " FROM HR_TERMINATION_CLEARED C INNER JOIN HR_TERMINATION_CLEARED_HISTORY H" +
                " ON C.CLEARED_ID=H.CLEARED_ID WHERE C.EMP_ID='" + employeeId + "' AND C.CLEARANCE_TYPE='" + type + "' ORDER BY C.CLEARED_ID ASC";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _ps.close();
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int saveEmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, int clearanceType, int yes, int no, String remark) {
        String _check = "SELECT COUNT(EMP_ID) AS EMP_COUNT" +
                "         FROM HR_TERMINATION_CLEARED " +
                "         WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "' AND CLEARED_DEPARTMENT='" + clearedDepartment + "'";

        String _insert = "INSERT INTO HR_TERMINATION_CLEARED" +
                "         (EMP_ID, " +
                "         CLEARED_BY," +
                "         CLEARED_DATE," +
                "         CLEARED_DEPARTMENT," +
                "         CLEARANCE_TYPE) " +
                "   VALUES ('" + employeeId + "'," +
                "           '" + clearedBy + "' ," +
                "           '" + clearedDate + "', " +
                "           '" + Integer.valueOf(clearedDepartment) + "', " +
                "           '" + clearanceType + "')";

        String _selectLastRowInsertedCleared = "SELECT CLEARED_ID FROM HR_TERMINATION_CLEARED WHERE CLEARED_ID=(SELECT max(CLEARED_ID) FROM HR_TERMINATION_CLEARED)";

        String _insertInToClearedHistory = "INSERT INTO HR_TERMINATION_CLEARED_HISTORY (" +
                "         CLEARED_ID, " +
                "         RETURNED_YES, " +
                "         RETURNED_NO, " +
                "         RETURNED_REMARK)" +
                "         VALUES ( ?," +
                "                  ?," +
                "                  ?," +
                "                  ? )";


        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        PreparedStatement _ps4 = null;

        ResultSet _rs2 = null;
        int clearedId = 0;
        int row1 = 0;
        int row2 = 0;
        int rowCheck = -1;
        Savepoint spOne = null;
        try {
            _con = getConnection();
            _ps1 = _con.prepareStatement(_check);
            _rs = _ps1.executeQuery();
            if (_rs.next()) {
                rowCheck = Integer.valueOf(_rs.getInt("EMP_COUNT"));
            }
            if (rowCheck == 0) {

                _con = getConnection();
                _con.setAutoCommit(false);
                spOne = _con.setSavepoint("SAVE_POINT_1");//save poin one----------------------------------------------------------
                _ps2 = _con.prepareStatement(_insert);
                row1 = _ps2.executeUpdate();

                _ps3 = _con.prepareStatement(_selectLastRowInsertedCleared);
                _rs2 = _ps3.executeQuery();
                if (_rs2.next()) {
                    clearedId = _rs2.getInt("CLEARED_ID");
                }
                _ps4 = _con.prepareStatement(_insertInToClearedHistory);
                _ps4.setInt(1, clearedId);
                _ps4.setInt(2, yes);
                _ps4.setInt(3, no);
                _ps4.setString(4, remark);
                row2 = _ps4.executeUpdate();

                if (row2 != 0) {
                    row1 = 1;
                    _con.commit();

                } else {
                    row1 = 0;
                    _con.rollback(spOne);
                }
//                closePooledConnections(_con);
                return row1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            try {
                _con.rollback(spOne);
            } catch (SQLException ex1) {
            }
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int finalizeClerance(String employeeId, int clearanceType, String finalizedBy, String finalizedDate) {


        String updateCleared = "UPDATE HR_TERMINATION_CLEARED SET CLEARED_CLOSED='1' WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "'";

        String updateClearance = "UPDATE HR_TERMINATION_CLEARANCE SET CLEARANCE_STATUS='1', " +
                "                                                     FINAL_CLEARED_BY='" + finalizedBy + "'," +
                "                                                     FINAL_CLEARED_DATE='" + finalizedDate + "'  " +
                "WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "'";


        int row1 = 0;
        int row2 = 0;

        Savepoint spOne = null;
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;

        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");

            _ps1 = _con.prepareStatement(updateCleared);
            row1 = _ps1.executeUpdate();

            _ps2 = _con.prepareStatement(updateClearance);
            row2 = _ps2.executeUpdate();
            if (row1 > 0 && row2 > 0) {
                _con.commit();
                return 1;
            } else {
                _con.rollback(spOne);
                return 0;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            try {
                _con.rollback(spOne);

            } catch (SQLException ex1) {
            }

            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int deleteEmployeeClearance(String employeeId, int clearanceType, int departmentId) {

        String _select = "DELETE FROM HR_TERMINATION_CLEARED WHERE (EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "') AND (CLEARED_DEPARTMENT='" + departmentId + "' AND CLEARED_CLOSED=0)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            int row = _ps.executeUpdate();
            _ps.close();
//            closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readAvailableDepartment(String date, int deptId) {
        String _select = "SELECT info.first_name " +
                "  || info.middle_name " +
                "  || info.last_name AS fullNme, " +
                "  info.date_of_birth, " +
                "  info.hire_date, " +
                "  info.retirement_no, emp.department_name, emp.JOB_NAME " +
                "FROM vw_employee_by_department_list emp " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id                                =emp.emp_id " +
                "WHERE emp.department_id                       =? " +
                "AND to_date(info.date_of_birth,'yyyy-mm-dd') <= to_date(?,'yyyy-mm-dd') order by fullNme asc";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setInt(1, deptId);
            _ps.setString(2, date);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
/////////==========================================================

    public OracleCachedRowSet readAllAvailableDepartment(String date) {
        String _select = "SELECT info.first_name " +
                "  || info.middle_name " +
                "  || info.last_name AS fullNme, " +
                "  info.date_of_birth, " +
                "  info.hire_date, " +
                "  info.retirement_no, " +
                "  emp.department_name , emp.JOB_NAME " +
                "FROM vw_employee_by_department_list emp " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id = emp.emp_id " +
                "WHERE to_date(info.date_of_birth,'yyyy-mm-dd') <= to_date(?,'yyyy-mm-dd') order by fullNme asc ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _ps.setString(1, date);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readAvailableDepartment(String sector) {
        String _select = "SELECT DEPT_ID,DEP_DESCRIPTION,REQUIRE_CLEARANCE FROM TBL_DEPARTMENT";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readSelectedDepartment() {
        String _select = "SELECT  DEPT_ID,DEP_DESCRIPTION FROM TBL_DEPARTMENT ";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
//            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<RetirmentEntity> readDepartment() {
        String _select = "SELECT dept_Id,DEP_DESCRIPTION FROM TBL_DEPARTMENT ";
        ArrayList<RetirmentEntity> department = new ArrayList<RetirmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {
                this.code = ocrs.getString("dept_Id");
                this.description = ocrs.getString("DEP_DESCRIPTION");
                RetirmentEntity departmentEntity = new RetirmentEntity(code, description);
                department.add(departmentEntity);
            }
            _rs.close();
            _ps.close();

            return department;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}