/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class PayGrad extends ConnectionManager {

    Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

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

    public PayGrad() {
    }
    private String rankID;

    public String getPayGrad() {
        return payGrad;
    }

    public void setPayGrad(String payGrad) {
        this.payGrad = payGrad;
    }

    public String getRankID() {
        return rankID;
    }

    public void setRankID(String rankID) {
        this.rankID = rankID;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public int checkPayGrad(String rankID, String payGrad) {


        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_pay_grad WHERE RANK_ID=? and STEP_NO=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            _ps.setString(2, payGrad);
            rs = _ps.executeQuery();
            if (rs.next()) {

                return 1;
            } else {

                return 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int checkZoneAvilabel(String regionID, String ZoneID) {


        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_zone_or_city WHERE region_Id=? and zone_or_city_id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            _ps.setString(2, ZoneID);
            rs = _ps.executeQuery();
            if (rs.next()) {

                return 1;
            } else {

                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int checkZoneAvilabel(String regionID) {


        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_zone_or_city WHERE region_Id=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, regionID);
            rs = _ps.executeQuery();
            if (rs.next()) {

                return 1;
            } else {

                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
//    public int checkZoneID(String zoneID) {
//        
//        
//        ResultSet rs = null;
//        String str = "SELECT * FROM hr_lu_zone_or_city WHERE zone_or_city_id=? ";
//        try {
//            _con=getConnection();
//            _ps=_con.prepareStatement(str);
//            _ps.setString(1, zoneID);
//            rs=_ps.executeQuery();
//            if(rs.next()){
//                return 1;
//            }
//            else{
//                return 0;
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//            return 0;
//        }
//
//    }

    public int addPayGrad(String rankID, String payGrad, Double salary) {
        this.setRankID(rankID);
        this.setPayGrad(payGrad);
        this.setSalary(salary);
        return this.insertPayGrad();
    }

    public int updatePayGrad(String payGradeid, String rankID, String stepNumber, Double salary) {
        this.setRankID(rankID);
        this.setPayGrad(payGrad);
        this.setSalary(salary);
        return this.insertPayGrad();
    }

    public PayGrad(String rankID, String payGrad, Double salary) {
        this.rankID = rankID;
        this.payGrad = payGrad;
        this.salary = salary;
    }
    private String payGrad;
    private Double salary;

    public String readSalary(String randkID, String payGradeID) {


        ResultSet rs = null;
        String salary;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select SALARY from hr_lu_pay_grad where rank_id=? and STEP_NO=?");
            _ps.setString(1, rankID);
            _ps.setString(2, payGradeID);
            rs = _ps.executeQuery();
            if (rs.next()) {
                salary = rs.getString("SALARY");

                return salary;
            }

        } catch (Exception e) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return "0.0";
    }

    public ArrayList<PayGrad> readPayGradList(String rankID) {


        ResultSet rs = null;

        ArrayList<PayGrad> payGradList = new ArrayList<PayGrad>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_pay_grad where rank_id=?");
            _ps.setString(1, rankID);
            rs = _ps.executeQuery();

            while (rs.next()) {
                PayGrad payGradType = new PayGrad(rs.getString("rank_Id"), rs.getString("step_No"), rs.getDouble("salary"));
                payGradList.add(payGradType);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return payGradList;
    }

    /**
     *
     */
    /**
     *
     * @param rankID
     * @param payGrad
     */
    public PayGrad(String rankID, String payGrad) {
        this.rankID = rankID;
        this.payGrad = payGrad;
    }

    /**
     *
     * @param rankID
     * @param stepNo
     * @param salary
     */
    /**
     * @return the rankID
     */
    /**
     * @param rankID the rankID to set
     */
    /**
     * @return the payGrad


    /**
     * @param payGrad the payGrad to set
     */
    /**
     * @return the salary
     */
    /**
     * @param salary the salary to set
     */
////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    /**
     *
     * @param object
     * @return
     */
    public ArrayList<PayGrad> readPayGradList(Object object) {


        ResultSet rs = null;

        ArrayList<PayGrad> payGradList = new ArrayList<PayGrad>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("select * from hr_lu_pay_grad");

            rs = _ps.executeQuery();

            while (rs.next()) {
                PayGrad payGradType = new PayGrad(rs.getString("rank_Id"), rs.getString("step_No"), rs.getDouble("salary"));
                payGradList.add(payGradType);
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return payGradList;
    }

    /**
     *
     * @param rankID
     * @return
     */
    public int countPayGrade(String rankID) {


        ResultSet rs = null;
        //Edited to
        String str = "SELECT max(rownum) as num FROM hr_lu_pay_grad WHERE rank_Id=?";
        int rownum;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            rs = _ps.executeQuery();
            if (rs.next()) {
                rownum = rs.getInt("num");

                return rownum;
            }

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public HashMap[] readPayGrade(String rankID) {


        ResultSet rs = null;
        HashMap[] list = null;
        int i = 0;

        String str = "SELECT ID_PAY_GRADE,STEP_NO,SALARY,rank_Id FROM hr_lu_pay_grad WHERE rank_Id=? ORDER BY STEP_NO ASC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = _ps.executeQuery();
            ocrs.populate(rs);
            list = new HashMap[ocrs.size()];//this.countPayGrade(rankID)];
            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("ID_PAY_GRADE", ocrs.getString("ID_PAY_GRADE"));
                list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                list[i].put("STEP_NO", ocrs.getString("STEP_NO"));
                list[i].put("SALARY", ocrs.getString("SALARY"));
                list[i].put("DATABASE_STATUS", "Old");
                i++;
            }
            if (list != null) {

                return list;
            } else {

                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<HashMap> readPayGradeList(String rankID) {
        ResultSet rs = null;
        int i = 0;
        ArrayList<HashMap> listOfPayGrade = new ArrayList<HashMap>();
        String str = "SELECT ID_PAY_GRADE, " +
                "  STEP_NO, " +
                "  SALARY, " +
                "  rank_Id " +
                "FROM HR_LU_PAY_GRAD " +
                "WHERE rank_Id=? " +
                "ORDER BY CAST(STEP_NO AS NUMBER) ASC";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = _ps.executeQuery();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("ID_PAY_GRADE", ocrs.getString("ID_PAY_GRADE"));
                hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                hm.put("STEP_NO", ocrs.getString("STEP_NO"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("DATABASE_STATUS", "Old");
                listOfPayGrade.add(hm);
            }
            return listOfPayGrade;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param rankID
     * @param payGrad
     * @return
     */
    public ResultSet readPayGrade(String rankID, String payGrad) {


        ResultSet rs = null;
        //Edited to
        String str = "SELECT * FROM hr_lu_pay_grad WHERE rank_Id=? AND step_No=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, rankID);
            _ps.setString(2, payGrad);

            rs = _ps.executeQuery();

            return rs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param rankID
     * @param payGrad
     * @param salary
     */
    private int insertPayGrad() {


        ResultSet rs = null;
        int check;
        String strPayGrad = "INSERT INTO hr_lu_pay_grad (" +
                " ID_PAY_GRADE," +
                "rank_Id," +
                "step_No," +
                "salary) " +
                "values(hr_lu_pay_grad_SEQ.NEXTVAL ,?,?,?)";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strPayGrad);
            _ps.setString(1, getRankID());
            _ps.setString(2, getPayGrad());
            _ps.setDouble(3, getSalary());
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int updatePayGrad(String rankID, String stepNumber, Double salary, String payGradeid) {
        ResultSet rs = null;
        int check;
        String strPayGrad = " UPDATE " +
                " hr_lu_pay_grad  " +
                " set rank_Id = ? ," +
                " step_No = ? ," +
                " salary = ? " +
                " WHERE ID_PAY_GRADE = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strPayGrad);
            _ps.setString(1, rankID);
            _ps.setString(2, stepNumber);
            _ps.setDouble(3, salary);
            _ps.setString(4, payGradeid);
            check = _ps.executeUpdate();

            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    /**
     *
     * @param rankID
     * @param payGrad
     * @param salary
     */
    public void updatePayGrade(String rankID, String payGrad, Double salary) {
        this.setRankID(rankID);
        this.setPayGrad(payGrad);
        this.setSalary(salary);
        this.insertPayGrad();
    }

    /**
     *
     * @param rankID
     */
    public int deletePayGrad(String rankID) {


        ResultSet rs = null;
        int check;
        String strPayGrade = "DELETE FROM hr_lu_pay_grad WHERE rank_Id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strPayGrade);
            _ps.setString(1, rankID);
            check = _ps.executeUpdate();

            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int deletePayGradWith(String payGradId) {


        ResultSet rs = null;
        int check;
        String strPayGrade = "DELETE FROM HR_LU_PAY_GRAD WHERE ID_PAY_GRADE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strPayGrade);
            _ps.setString(1, payGradId);
            check = _ps.executeUpdate();

            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList<HashMap> getAllPayGrade() throws Exception {
        ArrayList<HashMap> listOfPayGrade = new ArrayList<HashMap>();
        String sql = "SELECT STEP_NO, " +
                "  SALARY, " +
                "  RANK_ID " +
                "FROM HR_LU_PAY_GRAD " +
                "ORDER BY to_number(rank_id), " +
                "  to_number(step_no)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(sql);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("STEP_NO", _rs.getString("STEP_NO"));
                hm.put("SALARY", _rs.getString("SALARY"));
                hm.put("RANK_ID", _rs.getString("RANK_ID"));
                listOfPayGrade.add(hm);

            }
            return listOfPayGrade;
        } finally {
        }
    }
}
