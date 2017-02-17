/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.HolydayBonesEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.HolydayBonesManager.HolydayBonesManager;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Kibrom
 */
public class HolydayBonesEntity extends ConnectionManager {

    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Connection _con = null;
    private int holydayID;
    private String holydayName;

    public HolydayBonesEntity() {
    }

    public int getHolydayID() {
        return holydayID;
    }

    public void setHolydayID(int holydayID) {
        this.holydayID = holydayID;
    }

    public String getHolydayName() {
        return holydayName;
    }

    public void setHolydayName(String holydayName) {
        this.holydayName = holydayName;
    }

    public HolydayBonesEntity(int holydayID, String holydayName) {
        this.holydayID = holydayID;
        this.holydayName = holydayName;
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

    public String bonesAmount() {

        String bonesAmount = "";
        String select = "SELECT DISTINCT HR_LU_HOLYDAYHONES.AMOUNT from HR_LU_HOLYDAYHONES";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = (ResultSet) _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            while (ocrs.next()) {

                bonesAmount = ocrs.getString("AMOUNT");
            }
            closePooledConnections(_con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return bonesAmount;
    }

    public ArrayList<HashMap> getHolydayBones(String religion, String addressCode) throws SQLException {

        ArrayList<HashMap> quesList = new ArrayList<HashMap>();

        String select = "SELECT DISTINCT TBL_DEPARTMENT.DEPT_ID, " +
                "  HR_EMPLOYEE_INFO.EMP_ID, " +
                "  hr_employee_info.first_name, " +
                "  hr_employee_info.middle_name, " +
                "  hr_employee_info.last_name, " +
                "  HR_EMPLOYEE_INFO.religion " +
                "FROM HR_EMPLOYEE_INFO , " +
                "  TBL_DEPARTMENT " +
                "WHERE religion LIKE '" + religion + "%' " +
                "AND hr_employee_info.department_id=TBL_DEPARTMENT.DEPT_ID " +
                "AND TBL_DEPARTMENT.ADDRESS_CODE LIKE '" + addressCode + "%'";

        quesList.addAll(buildList(select));
        return quesList;
    }
public ArrayList<HashMap> getHolydayBoneslistForApp(int requestId) throws SQLException {

        ArrayList<HashMap> quesList = new ArrayList<HashMap>();

        String select = "SELECT DISTINCT HR_EMPLOYEE_INFO.EMP_ID, " +
                "  hr_employee_info.first_name, " +
                "  hr_employee_info.middle_name, " +
                "  hr_employee_info.last_name, " +
                "  HR_EMPLOYEE_INFO.religion " +
                "FROM HR_EMPLOYEE_INFO , " +
                "  hr_holydaybones_emp " +
                "WHERE hr_holydaybones_emp.REQUEST_ID="+requestId+ " "+
                "AND hr_holydaybones_emp.EMP_ID      =HR_EMPLOYEE_INFO.EMP_ID";

        quesList.addAll(buildList(select));
        releaseResources();
        return quesList;
    }
    public ArrayList<HashMap> buildList(String select) {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("empId", ocrs.getString("EMP_ID"));
                hm.put("empName", ocrs.getString("FIRST_NAME") + " " + ocrs.getString("MIDDLE_NAME") + " " + ocrs.getString("LAST_NAME"));
                hm.put("religion", ocrs.getString("religion"));
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public boolean request(String religion, String addressCode, String amount, String requester, String reqstDate, String holydayName) {
        Connection con = null;
        PreparedStatement ps = null;
        boolean checkSave = false;
        String insert = "INSERT INTO HR_HOLYDAYBONES (RELIGION, BRANCH,AMOUT, REQUESTER,REQUESTDATE,HOLYDAYNAME)VALUES (?,?,?,?,?,?)";
        try {
            con = getConnection();
            ps = con.prepareStatement(insert);
            ps.setString(1, religion);
            ps.setString(2, addressCode);
            ps.setString(3, amount);
            ps.setString(4, requester);
            ps.setString(5, reqstDate);
            ps.setString(6, holydayName);

            ps.executeUpdate();
            checkSave = true;

            ps.close();
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;

    }

    public boolean request_emp(ArrayList<HolydayBonesManager> holydayBonesManagerList) {


        boolean checkSave = false;
        String _insertEmployeesListQuery = "INSERT INTO HR_HOLYDAYBONES_EMP (REQUEST_ID, EMP_ID) VALUES (SEQ_HR_HOLYDAYBONES.currval,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertEmployeesListQuery);
            int lengthOfList = holydayBonesManagerList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, holydayBonesManagerList.get(counter).getEmpId());
                _ps.addBatch();
            }
            checkSave = true;

            _ps.executeBatch();
            closePooledConnections(_con);
            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return checkSave;
        }

    }

    public ResultSet bonseRequst() {

        String _selectQuery = "SELECT * FROM HR_HOLYDAYBONES where status='0'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery(_selectQuery);
            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public HashMap readRequestInfo(int requestId) throws SQLException {
        String qry = "SELECT * FROM HR_HOLYDAYBONES WHERE HOLYDAYBONESID='" + requestId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("HOLYDAYBONESID", _rs.getString("HOLYDAYBONESID"));
                    data.put("RELIGION", _rs.getString("RELIGION"));
                    data.put("BRANCH", _rs.getString("BRANCH"));
                    data.put("AMOUT", _rs.getString("AMOUT"));
                    data.put("REQUESTDATE", _rs.getString("REQUESTDATE"));
                    data.put("HOLYDAYNAME", _rs.getString("HOLYDAYNAME"));
                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public boolean aprove(int requestId) {
        String _selectQuery = "UPDATE HR_HOLYDAYBONES SET status='1' WHERE HOLYDAYBONESID =" + requestId + "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery(_selectQuery);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }
public boolean reject(int requestId) {
        String _selectQuery = "UPDATE HR_HOLYDAYBONES SET status='2' WHERE HOLYDAYBONESID =" + requestId + "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery(_selectQuery);
            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            return false;

        }
    }
    public ArrayList<HolydayBonesEntity> readHolyday() {
        String readEva = "SELECT  * FROM  HR_LU_HOLIDAYS ";


        ArrayList<HolydayBonesEntity> resultList = new ArrayList<HolydayBonesEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                HolydayBonesEntity resultType = new HolydayBonesEntity(Integer.valueOf(_rs.getString("ID").toString()), _rs.getString("NAMEOFHOLIDAYS"));
                resultList.add(resultType);
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }
}