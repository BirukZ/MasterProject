/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeBonesEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class ApproveYearlyBonesEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    PreparedStatement ps = null;
    ResultSet _rs = null;

    public ArrayList<HashMap> getListOfRequest() throws Exception {
        ArrayList<HashMap> requestList = new ArrayList<HashMap>();
        String query = "SELECT PREPAREFOR,BONESID, YEAR,REQUSTDATE " +
                " FROM HR_BONES_REQUEST WHERE STATUS='Req'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("PREPAREFOR", _rs.getString("PREPAREFOR") + "-" +
                        _rs.getString("YEAR") +
                        "-" + _rs.getString("REQUSTDATE"));
                hm.put("BONESID", _rs.getString("BONESID"));
                requestList.add(hm);
            }
            return requestList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }
    }

    /**
     * get employee who is requested bones
     * @param requestId
     * @return
     * @throws java.lang.Exception
     */
    public HashMap getReqfuesterInformation(String requestId) throws Exception {

        HashMap requesInfo = new HashMap();
        String query = "SELECT EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  EI.EMP_ID, " +
                "  BR.EFFECTIVEDATE, " +
                "  BR.GRANTBONUS, " +
                "  BR.PREPAREFOR, " +
                "  BR.YEAR, " +
                "  BR.REQUSTDATE," +
                "  BONESID " +
                "FROM HR_EMPLOYEE_INFO EI, " +
                "  HR_BONES_REQUEST BR " +
                "WHERE EI.EMP_ID=BR.REQUSTERID " +
                "AND BR.BONESID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _ps.setString(1, requestId);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                requesInfo.put("FULLNAME", _rs.getString("FULLNAME"));
                requesInfo.put("EMP_ID", _rs.getString("EMP_ID"));
                requesInfo.put("EFFECTIVEDATE", _rs.getString("EFFECTIVEDATE"));
                requesInfo.put("GRANTBONUS", _rs.getString("GRANTBONUS"));
                requesInfo.put("PREPAREFOR", _rs.getString("PREPAREFOR"));
                requesInfo.put("YEAR", _rs.getString("YEAR"));
                requesInfo.put("REQUSTDATE", _rs.getString("REQUSTDATE"));
                requesInfo.put("BONESID", _rs.getString("BONESID"));
                return requesInfo;
            } else {
                return null;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }


    }

    /**
     * get employee list they can to get bones
     * @param requestId
     * @return
     * @throws java.lang.Exception
     */
    public ArrayList<HashMap> getReqfuestedInformation(String requestId) throws Exception {

        ArrayList<HashMap> requesInfo = new ArrayList<HashMap>();
        String query = "SELECT EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  EI.EMP_ID, " +
                "  YB.ACQUIREPERCENTAGE, " +
                "  YB.AMOUNTINBIRR, " +
                "  YB.EVALUATIONRESULT, " +
                "  YB.EXPRIANCE, " +
                "  YB.ID, " +
                "  YB.SALARY " +
                "FROM HR_EMPLOYEE_INFO EI, " +
                "  HR_EMP_YEARLY_BONES YB " +
                "WHERE EI.EMP_ID=YB.EMP_ID " +
                "AND YB.BONESID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _ps.setString(1, requestId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("FULLNAME", _rs.getString("FULLNAME"));
                hm.put("EMP_ID", _rs.getString("EMP_ID"));
                hm.put("ACQUIREPERCENTAGE", _rs.getString("ACQUIREPERCENTAGE"));
                hm.put("AMOUNTINBIRR", _rs.getString("AMOUNTINBIRR"));
                hm.put("EVALUATIONRESULT", _rs.getString("EVALUATIONRESULT"));
                hm.put("EXPRIANCE", _rs.getString("EXPRIANCE"));
                hm.put("ID", _rs.getString("ID"));
                hm.put("SALARY", _rs.getString("SALARY"));
                requesInfo.add(hm);

            }
            return requesInfo;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }


    }

    public boolean saveeBonesRequestDecision(ArrayList<HashMap> approveList,
            String approverId, String bonesId, String destion, String remark) throws Exception {
        boolean checkStatus = false;
        String query = "UPDATE HR_BONES_REQUEST " +
                "SET APPROVERID  = ?, " +
                " STATUS      = ?, " +
                " APPROVERREMARK      = ?, " +
                " APPROVEDATE = CURRENT_TIMESTAMP " +
                " WHERE BONESID   = ? ";
        String updateQuery = "UPDATE HR_EMP_YEARLY_BONES SET  STATUS = ? WHERE ID = ?";

        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint spApproveBoness = _con.setSavepoint("AppBone");
            ps = _con.prepareStatement(query);
            ps.setString(1, approverId);
            ps.setString(2, destion);
            ps.setString(3, remark);
            ps.setString(4, bonesId);
            if (ps.executeUpdate() > 0) {
                _ps = _con.prepareStatement(updateQuery);
                for (HashMap hm : approveList) {
                    _ps.setString(1, destion);
                    _ps.setString(2, hm.get("bonesId").toString());
                    if (_ps.executeUpdate() < 0) {
                        _con.rollback(spApproveBoness);
                        return false;
                    }
                    checkStatus = true;
                }
            } else {
                _con.rollback(spApproveBoness);
                return false;
            }
            _con.commit();
            return checkStatus;



        } finally {
            releaseResources();
        }


    }

    /**
     * 
     * @throws java.lang.Exception
     */
    public void releaseResources() throws Exception {
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
}
