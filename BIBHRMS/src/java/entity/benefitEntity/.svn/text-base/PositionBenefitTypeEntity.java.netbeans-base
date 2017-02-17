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
import manager.benefitManager.PositionBenefitTypesManager.BenefitTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author aa
 */
public class PositionBenefitTypeEntity extends ConnectionManager {

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

    public ResultSet selectAllPositionBenefits() throws SQLException {
        String _selectQuery = "SELECT HR_LU_BENEFIT_POSITION.BENEFIT_TYPE_ID, " +
"  HR_LU_BENEFIT_POSITION.BENEFIT_POSITION_ID, " +
"  HR_LU_BENEFIT_POSITION.POSITION_ID, " +
"  HR_LU_BENEFIT_POSITION.QUANTITY, " +
"  HR_LU_BENEFIT_POSITION.AMOUNT_OF_BIRR, " +
"  hr_lu_benefit_types.benefit_value, " +
"  REMARK,  hr_lu_benefit_types.benefit_name, " +
"  HR_LU_JOB_TYPE.JOB_NAME AS POSITION_NAME, " +
"  hr_lu_benefit_position.location " +
"FROM HR_LU_BENEFIT_POSITION, " +
"  HR_LU_JOB_TYPE , " +
"  hr_lu_benefit_types " +
"WHERE POSITION_ID                         =HR_LU_JOB_TYPE.JOB_CODE " +
"AND HR_LU_BENEFIT_POSITION.BENEFIT_TYPE_ID=hr_lu_benefit_types.BENEFIT_TYPE_ID";
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

    public boolean insertPositionBenefits(ArrayList<BenefitTypeModel> benefitLists, String recorededDateAndTim) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_LU_BENEFIT_POSITION " +
                " (BENEFIT_POSITION_ID,BENEFIT_TYPE_ID, POSITION_ID,QUANTITY,REMARK,TIME_STAMP,IS_TAXABLE,MONETARY,AMOUNT_OF_BIRR,LOCATION)" +
                " VALUES(HR_LU_BENEFIT_POSITION_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitLists.get(counter).getBenefitId());
                _ps.setInt(2, benefitLists.get(counter).getPositionId());
                _ps.setInt(3, benefitLists.get(counter).getQuantity());
                _ps.setString(4, benefitLists.get(counter).getRemark());
                _ps.setString(5, recorededDateAndTim);
                _ps.setString(6, benefitLists.get(counter).isTaxableOrNot() ? "YES" : "NO");
                _ps.setString(7, benefitLists.get(counter).getIsMonetery());
                _ps.setFloat(8, benefitLists.get(counter).getMoneyValue());
                 _ps.setInt(9, benefitLists.get(counter).getLocation());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
    public boolean updatePositionBenefits(ArrayList<BenefitTypeModel> benefitLists, String recorededDateAndTim) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE  HR_LU_BENEFIT_POSITION " +
                " SET  BENEFIT_TYPE_ID =?, POSITION_ID =?, QUANTITY =?,TIME_STAMP=?,MONETARY=?,AMOUNT_OF_BIRR=?,LOCATION=?" +
                " WHERE BENEFIT_POSITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitLists.get(counter).getBenefitId());
                _ps.setInt(2, benefitLists.get(counter).getPositionId());
                _ps.setInt(3, benefitLists.get(counter).getQuantity());
                _ps.setString(4, recorededDateAndTim);
                _ps.setString(5, benefitLists.get(counter).getIsMonetery());
                _ps.setFloat(6, benefitLists.get(counter).getMoneyValue());
                _ps.setInt(7, benefitLists.get(counter).getLocation());
                _ps.setInt(8, benefitLists.get(counter).getBenefitPositionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deletePositionBenefits(ArrayList<BenefitTypeModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "   DELETE HR_LU_BENEFIT_POSITION " +
                " where BENEFIT_POSITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getBenefitPositionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
}
