/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.Promotion;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.documentRequestManager.DocumentApproveManager.EmployeeExperienceHistroyModel;
import manager.promotionManager.PromotionRequestManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class PromotionEntity extends ConnectionManager {

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
    public void saveExper(ArrayList<PromotionRequestManager.EmployeeExperienceHistroyModel> empExpHistroy) {

        String _insertEmployeesListQuery = "INSERT INTO HR_PROMOTION_EXPERIENCE " +
                "(EMPID,JOB_TITLE,START_DATE,END_DATE) VALUES(?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertEmployeesListQuery);
            int lengthOfList = empExpHistroy.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, empExpHistroy.get(counter).getEmpId());
                _ps.setString(2, empExpHistroy.get(counter).getJobDesc());
                _ps.setString(3, empExpHistroy.get(counter).getStartDate());
                _ps.setString(4, empExpHistroy.get(counter).getEndDate());
                _ps.addBatch();
            }
            _ps.executeBatch();
           
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
            finally {
            

        }
    }

    public ResultSet selectEmployeeExperience(String empId) throws SQLException {
        String selectSql = "SELECT P.PREV_JOB_POSITION, J.JOB_DESCRIPTION AS OLDJOBDESC, P.PREV_RANK, R.RANK_DESCRIPTION AS OLDRANKDESC,  " +
                "P.PREV_SALARY, P.PROMOTION_DATE, E.JOB_CODE as newJob, JF.JOB_DESCRIPTION as newJobDesc, E.RANK_ID as newRank, E.SALARY as newSalary, E.HIRE_DATE    " +
                "FROM HR_PROMOTION_HISTORY P, HR_EMPLOYEE_INFO E, HR_LU_JOB_TYPE J,  " +
                "HR_LU_JOB_TYPE JF, HR_LU_RANK R  " +
                "WHERE P.EMPLOYEE_ID = '"+empId+"' AND P.EMPLOYEE_ID = E.EMP_ID   " +
                "AND J.JOB_CODE = P.PREV_JOB_POSITION AND R.RANK_ID = P.PREV_RANK AND JF.JOB_CODE = E.JOB_CODE  " +
                "ORDER BY P.PROMOTION_DATE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectSql, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return (ResultSet) ocrs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }
    }

    public ResultSet getEmpExperienceHistoryPromotion(String empId) throws SQLException {
        String selectSql = "SELECT * FROM HR_PROMOTION_EXPERIENCE where EMPID='" + empId + "' ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectSql, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return (ResultSet) ocrs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readExperiance(String empId) throws SQLException {
        String selectSql = "SELECT EMP_ID, " +
                "  INSTITUION, " +
                "  START_DATE, " +
                "  END_DATE, " +
                "  JOB_TITLE, " +
                "  NVL(RESPONSIBILITY,'not register') AS RESPONSIBILITY , " +
                "  SALARY, " +
                "  NVL(REASON_FOR_TERMINATION ,'not register') AS REASON_FOR_TERMINATION, " +
                "  RANK, " +
                "  ID, " +
                "  NVL(PRIVATE_OR_GVTAL ,'not register')          AS PRIVATE_OR_GVTAL, " +
                "  NVL(PERMANENT_OR_CONTRACT ,'not register')     AS PERMANENT_OR_CONTRACT, " +
                "  NVL(USETHISEXPERIENCEFORLEAVE ,'not register') AS USETHISEXPERIENCEFORLEAVE, " +
                "  NVL(PROFESSIONINMUGHER ,'not register')        AS PROFESSIONINMUGHER , " +
                "  NVL(JT.JOB_DESCRIPTION ,'not register')        AS JOB_DESCRIPTION " +
                "FROM HR_EMP_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE JT " +
                "WHERE EMP_ID                            ='"+empId+"' " +
                "AND HR_EMP_EXPERIENCE.PROFESSIONINMUGHER=JT.JOB_CODE(+)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectSql, ResultSet.TYPE_SCROLL_SENSITIVE);
            ResultSet rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            return (ResultSet) ocrs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } finally {
            releaseResources();
        }
    }
}
