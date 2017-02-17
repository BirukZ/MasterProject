/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.clearanceEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;
import manager.clearanceManager.ClearanceManager.ItemListModel;

/**
 *
 * @author 
 */
public class ClearanceEntity extends ConnectionManager {

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

    public ClearanceEntity() {
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

    public ClearanceEntity(String selDeps) {
        this.selDeps = selDeps;
    }

    public ClearanceEntity(String terminationId, String employeeId) {
        this.terminationId = terminationId;
        this.employeeId = employeeId;
    }

    public int UpdateClearDepartments(String _depId, String _status) {
        String _update = "UPDATE TBL_DEPT_BUNNA SET REQUIRE_CLEARANCE='" + _status + "' WHERE DEPT_ID='" + _depId + "'";


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

    public OracleCachedRowSet readClearedDepartmentDetail(String employeeId, String clearanceType, int departmentId) {
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
        String _select = "SELECT EMP_ID " +
                "FROM HR_TERMINATION_CLEARANCE cl " +
                "INNER JOIN HR_TERMINATION_REQUEST req " +
                "ON req.treminator_id  =cl.emp_id " +
                "WHERE CLEARANCE_STATUS=0 " +
                "AND req.request_status LIKE 'App%'";
        
        
        
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
public ResultSet selectTerminationTypes(int terminationCatagory) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_TERMINATION_CATEGORY WHERE ID= '" + terminationCatagory + "'";
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
    public OracleCachedRowSet readTreminRequestsDetails(String employeeId) {
        String _select = "SELECT  * FROM HR_TERMINATION_REQUEST WHERE TREMINATOR_ID='" + employeeId + "'";



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

    public OracleCachedRowSet loadClearedDepartmentsReport(String employeeId, String type) {
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

    public int saveEmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, String clearanceType, int yes, int no, String remark) {
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
public int saveYesEmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, String clearanceType, int yes, int no, String remark) {
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
    public int finalizeClerance(String employeeId, String clearanceType, String finalizedBy, String finalizedDate) {

 
        String updateCleared = "UPDATE HR_TERMINATION_CLEARED SET CLEARED_CLOSED='1' WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "'";

        String updateClearance = "UPDATE HR_TERMINATION_CLEARANCE SET CLEARANCE_STATUS='1', " +
                "                                                     FINAL_CLEARED_BY='" + finalizedBy + "'," +
                "                                                     FINAL_CLEARED_DATE='" + finalizedDate + "'  " +
                " WHERE EMP_ID='" + employeeId + "' AND CLEARANCE_TYPE='" + clearanceType + "'";


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

    public int deleteEmployeeClearance(String employeeId, String clearanceType, int departmentId) {

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
 public int deleteEmployeeClearanceItem(String employeeId, String departmentId) {

        String _select = "DELETE FROM HR_CLERANCE_LEFT_ITEMS WHERE (EMP_ID='" + employeeId + "' AND DEP_ID='"+ departmentId + "')";


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

    public OracleCachedRowSet readAvailableDepartment() {
        String _select = "SELECT DEPT_ID,DEP_DESCRIPTION,REQUIRE_CLEARANCE FROM TBL_DEPT_BUNNA";



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

    public OracleCachedRowSet readAvailableDepartmentRequireclreance() {

         String _select = "SELECT DEPT_ID, " +
"  DEP_DESCRIPTION , " +
"  REQUIRE_CLEARANCE " +
"FROM TBL_DEPT_BUNNA " +
"WHERE REQUIRE_CLEARANCE='true' ";



//        String _select = "SELECT DEPT_ID, " +
//"  DEP_DESCRIPTION , " +
//"  REQUIRE_CLEARANCE " +
//"FROM TBL_DEPT_BUNNA " +
//"WHERE REQUIRE_CLEARANCE='true' " +
//"UNION " +
//"SELECT clear_dep_id, DEP_NAME, require_clerance FROM hr_lu_clearing_department";



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

    public OracleCachedRowSet readAvailableDepartment(String sector) {
        String _select = "SELECT DEPT_ID,DEP_DESCRIPTION,REQUIRE_CLEARANCE FROM TBL_DEPT_BUNNA";



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
        String _select = "SELECT  DEPT_ID,DEP_DESCRIPTION FROM TBL_DEPT_BUNNA WHERE REQUIRE_CLEARANCE='" + "true" + "'";



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
public boolean insertBenefitTypes(ArrayList<ItemListModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_CLERANCE_LEFT_ITEMS " +
                " (ID,DEP_ID,EMP_ID,ITEM_NAME,PRICE, DESCRIPTION)" +
                " VALUES(HR_LEFT_ITEMSQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, benefitLists.get(counter).getDept_Id());
                _ps.setString(2, benefitLists.get(counter).getClearingEmployeeId());
                _ps.setString(3, benefitLists.get(counter).getItemName());
                _ps.setDouble(4, benefitLists.get(counter).getPrice());
                _ps.setString(5, benefitLists.get(counter).getDescription());
                
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateBenefitTypes(ArrayList<ItemListModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE  HR_CLERANCE_LEFT_ITEMS " +
                " SET ITEM_NAME=?,PRICE=?,DESCRIPTION=?" +
                " WHERE   ID=? and DEP_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getItemName());
                _ps.setDouble(2, benefitLists.get(counter).getPrice());
                _ps.setString(3, benefitLists.get(counter).getDescription());
                _ps.setInt(4, benefitLists.get(counter).getItemId());
                _ps.setString(5, benefitLists.get(counter).getDept_Id());
               
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteBenefitTypes(ArrayList<ItemListModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_CLERANCE_LEFT_ITEMS " +
                " where ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getItemId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
     public ResultSet selectAllBenefitTypes(String clearingDepartmentId,String clearingEmployeeId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_CLERANCE_LEFT_ITEMS WHERE DEP_ID='" + clearingDepartmentId + "' and EMP_ID='" + clearingEmployeeId + "'";
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