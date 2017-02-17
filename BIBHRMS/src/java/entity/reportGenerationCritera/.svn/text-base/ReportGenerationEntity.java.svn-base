/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.reportGenerationCritera;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.ReportCritera.ReportCriteraManager.ReportPageModle;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Biruk
 */
public class ReportGenerationEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public ReportGenerationEntity() {
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
    String pageName;

    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

//private ReportGenerationEntity
    public boolean insertPenaltyTypes(ArrayList<ReportPageModle> toBeInserted) throws SQLException {
        String _insertPenaltyType = "INSERT INTO HR_LU_REPORT_LIST_PAGE " +
                "(REPORT_PAGE_ID," +
                "REPORT_PAGE_NAME," +
                "REPORT_PAGE_DESCRIPTION," +
                "REPORT_CODE," +
                "REPORT_MODULE) " +
                " VALUES(HR_LU_REPORT_PAGES_SEQ.NEXTVAL,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertPenaltyType);
            int lengthOfList = toBeInserted.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, toBeInserted.get(counter).getReportPageName());
                _ps.setString(2, toBeInserted.get(counter).getReportPageDescription());
                _ps.setString(3, toBeInserted.get(counter).getReportPageID());
                _ps.setString(4, toBeInserted.get(counter).getModuleName());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllReportPaget() throws SQLException {

        String _selectQuery = " SELECT * FROM HR_LU_REPORT_LIST_PAGE ";
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
    //=======================================Selection Of Report Page List Based on the Selected Module==================================

    ReportGenerationEntity(String pageName) {
        this.pageName = pageName;
    }
    //====================================================================================================================================

    public ArrayList<ReportGenerationEntity> selectAllReportPageListBasedOnSelectedNew(String module) throws SQLException {
        String _selectQuery = "SELECT REPORT_PAGE_NAME FROM HR_LU_REPORT_LIST_PAGE where REPORT_MODULE=? ";
        ArrayList<ReportGenerationEntity> pageList = new ArrayList<ReportGenerationEntity>();
        try {
            _con = getConnection();

            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, module.trim());
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                ReportGenerationEntity List = new ReportGenerationEntity(_rs.getString("REPORT_PAGE_NAME"));
                pageList.add(List);
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
        return pageList;
    }
}
