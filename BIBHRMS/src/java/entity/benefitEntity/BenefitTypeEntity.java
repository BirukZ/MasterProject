/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.benefitEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.benefitManager.BenefitTypesManager.BenefitTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author aa
 */
public class BenefitTypeEntity extends ConnectionManager {

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

    public ResultSet selectAllBenefitTypes() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_BENEFIT_TYPES";
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

    public ResultSet selectLocations() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_BENEFIT_LOCATION";
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

    public ResultSet selectAllMaterials() throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_BENEFIT_TYPES";
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

    public ResultSet selectAllPostions() throws SQLException {
//        String _selectQuery = "SELECT DISTINCT hr_lu_job_type.job_Code, " +
//                "  hr_lu_job_type.job_description " +
//                "FROM (hr_dept_job " +
//                "INNER JOIN TBL_DEPARTMENT " +
//                "ON TBL_DEPARTMENT.DEPT_ID = hr_dept_job.DEPT_ID) " +
//                "INNER JOIN hr_lu_job_type " +
//                "ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE";

        String _selectQuery = "SELECT DISTINCT hr_lu_job_type.job_Code, " +
                "  hr_lu_job_type.JOB_NAME " +
                "FROM (hr_dept_job " +
                "INNER JOIN TBL_DEPT_BUNNA " +
                "ON TBL_DEPT_BUNNA.DEPT_ID = hr_dept_job.DEPT_ID) " +
                "INNER JOIN hr_lu_job_type " +
                "ON hr_dept_job.JOB_CODE = hr_lu_job_type.JOB_CODE";


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

    public boolean insertBenefitTypes(ArrayList<BenefitTypeModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_LU_BENEFIT_TYPES " +
                " (BENEFIT_TYPE_ID,  BENEFIT_NAME,BENEFIT_VALUE,BENEFIT_DURATION, DESCRIPTION,IN_PERCENT,PERCENT,SAFTEY_DEVICE )" +
                " VALUES(HR_LU_BENEFIT_TYPE_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getBenefitName());
                _ps.setString(2, benefitLists.get(counter).getBenefitCatagory());
                _ps.setString(3, benefitLists.get(counter).getBenefitTermLength());
                _ps.setString(4, benefitLists.get(counter).getBenefitDescription());
                _ps.setString(5, benefitLists.get(counter).isPercentOrNot() ? "YES" : "NO");

                _ps.setInt(6, benefitLists.get(counter).getPercrnt());
                _ps.setString(7, benefitLists.get(counter).getSaftyDevices());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateBenefitTypes(ArrayList<BenefitTypeModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE  HR_LU_BENEFIT_TYPES " +
                " SET BENEFIT_NAME=?,BENEFIT_VALUE=?,BENEFIT_DURATION=?, DESCRIPTION =?,PERCENT=?,SAFTEY_DEVICE=?" +
                " WHERE   BENEFIT_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getBenefitName());
                _ps.setString(2, benefitLists.get(counter).getBenefitType());
                _ps.setString(3, benefitLists.get(counter).getBenefitTermLength());
                _ps.setString(4, benefitLists.get(counter).getBenefitDescription());

                _ps.setInt(5, benefitLists.get(counter).getPercrnt());
                _ps.setString(6, benefitLists.get(counter).getSaftyDevices());
                _ps.setInt(7, benefitLists.get(counter).getBenefitId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteBenefitTypes(ArrayList<BenefitTypeModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_LU_BENEFIT_TYPES " +
                " where BENEFIT_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getBenefitId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public HashMap readDeviceBasicInfoFromId(String deviceCode) throws SQLException {
        String qry = "SELECT MATERIAL_CODE,DESCRIPTION FROM MMS.MMS_MATERIAL WHERE MATERIAL_CODE='" + deviceCode + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("deviceCode", _rs.getString("MATERIAL_CODE"));
                    data.put("DESCRIPTION", _rs.getString("DESCRIPTION"));

                } else {
                    data.put("deviceCode", "");
                    data.put("DESCRIPTION", "");

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

    public ResultSet searchBenefitNametoAuto(
            String device_Name) {
        String qry = "SELECT ITEM_CODE,ITEM_NAME FROM BPSMS.PSMS_ITEM" +
                " WHERE upper(ITEM_NAME) like'" + device_Name.toUpperCase() + "%'" +
                " AND rownum <=10";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            return _rs;
        } catch (Exception e) {
            return null;
        }
    }
}
