/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.educationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.educationManager.EducationApproveManager;
import manager.educationManager.EducationRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class EducationRequestEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public EducationRequestEntity() {
    }

//    private EducationRequestEntity(String string) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }
    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
            _rs = null;
        }
        if (_ps != null) {
            _ps.close();
            _ps = null;
        }
        if (_con != null) {
            _con.close();
            closePooledConnections(_con);
        }
    }
    String titleDescription;
    String titleCode;

    public Connection get_con() {
        return _con;
    }

    public String getTitleCode() {
        return titleCode;
    }

    public void setTitleCode(String titleCode) {
        this.titleCode = titleCode;
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

    public String getTitleDescription() {
        return titleDescription;
    }

    public void setTitleDescription(String titleDescription) {
        this.titleDescription = titleDescription;
    }

    /**
     * Inserts PowereducationRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int insertEducationRequest(EducationRequestModel educationRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_EDUCATION_REQUEST " +
                " (EDUCATION_REQUEST_ID," +
                "  REQUESTER_ID," +
                "  EDUCATION_PROGRAM_NAME," +
                "  EDUCATION_LEVEL_CATEGORY," +
                "  EDUCATION_SHIFT_CATEGORY," +
                " START_DATE," +
                " APPLIED_DATE," +
                " DURATION_IN_YEAR," +
                " REASON_DESCRIPTION," +
                " INSTITUTION_NAME," +
                " COST_PER_CREDIT_HOUR," +
                " NUMBER_OF_CREDIT_HOURS," +
                " TOTAL_ADMIN_COSTS," +
                " DOCUMENT_REFERENCE_NUMBER," +
                " REQUEST_STATUS," +
                " TIME_STAMP," +
                " USER_NAME," +
                " EDUCATIONAL_STATUS," +
                " DATE_UPDATE_EDU_STATUS," +
                " END_DATE," +
                " EDU_LEVEL_ID," +
                " ALL_SEPECIFY_PROGRAM)" +
                " VALUES (HR_EDUCATION_REQUEST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, educationRequestModel.getRequesterId());

            _ps.setString(2, educationRequestModel.getEducationProgramName());
            _ps.setString(3, educationRequestModel.getEducationLevelCategory());
            _ps.setString(4, educationRequestModel.getEducationShiftCategory());
            _ps.setString(5, educationRequestModel.getStartDate());
            _ps.setString(6, educationRequestModel.getAppliedDate());
            _ps.setDouble(7, educationRequestModel.getDurationInYear());
            _ps.setString(8, educationRequestModel.getReasonDescription());
            _ps.setString(9, educationRequestModel.getInstitutionName());
//            _ps.setString(10, educationRequestModel.getInstitutionAccredited());
//            _ps.setString(11, educationRequestModel.getEthiopianInstitution());
//            _ps.setString(12, educationRequestModel.getInstitutionAddress());
            _ps.setDouble(10, educationRequestModel.getCostPerCreditHour());
            _ps.setInt(11, educationRequestModel.getNumberOfCreditHours());
            _ps.setDouble(12, educationRequestModel.getTotalAdminstrationCosts());
            _ps.setString(13, educationRequestModel.getDocumentReferenceNumber());
            _ps.setString(14, educationRequestModel.getRequestStatus());
            _ps.setString(15, educationRequestModel.getTimeStamp());
            _ps.setString(16, educationRequestModel.getUserName());
            _ps.setString(17, educationRequestModel.getEducatinalStatus());
            _ps.setString(18, educationRequestModel.getDateOfStatusUpdate());
            _ps.setString(19, educationRequestModel.getEndDate());
            _ps.setString(20, educationRequestModel.getLevelID());
            _ps.setString(21, educationRequestModel.getAllOrSecifyProgram());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Inserts PowereducationRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int updateEducationRequest(EducationRequestModel educationRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_EDUCATION_REQUEST " +
                " SET REQUESTER_ID = ?," +
                "  EDUCATION_PROGRAM_NAME = ?,EDUCATION_LEVEL_CATEGORY = ?,EDUCATION_SHIFT_CATEGORY = ?," +
                " START_DATE = ?, APPLIED_DATE = ?,DURATION_IN_YEAR = ?,REASON_DESCRIPTION = ?," +
                " INSTITUTION_NAME = ?," +
                " COST_PER_CREDIT_HOUR = ?,NUMBER_OF_CREDIT_HOURS = ?,TOTAL_ADMIN_COSTS = ?," +
                " DOCUMENT_REFERENCE_NUMBER = ?,REQUEST_STATUS = ?,TIME_STAMP = ?,USER_NAME =?,END_DATE=?,EDU_LEVEL_ID=?,ALL_SEPECIFY_PROGRAM=?" +
                " WHERE EDUCATION_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, educationRequestModel.getRequesterId());
            _ps.setString(2, educationRequestModel.getEducationProgramName());
            _ps.setString(3, educationRequestModel.getEducationLevelCategory());
            _ps.setString(4, educationRequestModel.getEducationShiftCategory());
            _ps.setString(5, educationRequestModel.getStartDate());
            _ps.setString(6, educationRequestModel.getAppliedDate());
            _ps.setDouble(7, educationRequestModel.getDurationInYear());
            _ps.setString(8, educationRequestModel.getReasonDescription());
            _ps.setString(9, educationRequestModel.getInstitutionName());
//            _ps.setString(10, educationRequestModel.getInstitutionAccredited());
//            _ps.setString(11, educationRequestModel.getEthiopianInstitution());
//            _ps.setString(12, educationRequestModel.getInstitutionAddress());
            _ps.setDouble(10, educationRequestModel.getCostPerCreditHour());
            _ps.setInt(11, educationRequestModel.getNumberOfCreditHours());
            _ps.setDouble(12, educationRequestModel.getTotalAdminstrationCosts());
            _ps.setString(13, educationRequestModel.getDocumentReferenceNumber());
            _ps.setString(14, educationRequestModel.getRequestStatus());
            _ps.setString(15, educationRequestModel.getTimeStamp());
            _ps.setString(16, educationRequestModel.getUserName());
            _ps.setString(17, educationRequestModel.getEndDate());
            _ps.setString(18, educationRequestModel.getLevelID());
             _ps.setString(19, educationRequestModel.getAllOrSecifyProgram());
            _ps.setInt(20, educationRequestModel.getEducationRequestId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int updateEducationStatus(EducationRequestModel educationRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_EDUCATION_REQUEST " +
                "SET EDUCATIONAL_STATUS     =?, " +
                "  DATE_UPDATE_EDU_STATUS   =?, REQUEST_STATUS=?, TIME_STAMP=?, USER_NAME=?,RESON_OF_CHANGING=?" +
                " WHERE EDUCATION_REQUEST_ID = ? " +
                " AND REQUESTER_ID           =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, educationRequestModel.getEducatinalStatus());
            _ps.setString(2, educationRequestModel.getDateOfStatusUpdate());
            _ps.setString(3, educationRequestModel.getRequestStatus());
            _ps.setString(4, educationRequestModel.getTimeStamp());
            _ps.setString(5, educationRequestModel.getUserName());
            _ps.setString(6, educationRequestModel.getReasonOfChang());
            _ps.setInt(7, educationRequestModel.getEducationRequestId());
            _ps.setString(8, educationRequestModel.getRequesterId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Inserts PowereducationRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int deleteEducationRequest(int educationRequestId) throws SQLException {
        String _deleteQuery = "DELETE HR_EDUCATION_REQUEST " +
                " WHERE  EDUCATION_REQUEST_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educationRequestId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEducationRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_EDUCATION_REQUEST " +
                " WHERE EDUCATION_REQUEST_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
//==========================================================================================================

    public ResultSet selectEducationChangeInsRequest(String requesterId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_EDUCATION_REQUEST " +
                " WHERE REQUESTER_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=========================================================

    public ResultSet selectPendingEducationRequests(String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUCATION_REQUEST " +
                "WHERE REQUEST_STATUS LIKE  " + EducationApproveManager.INITIAL_STATE_EDUCATION +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " +
                "ORDER BY EDUCATION_REQUEST_ID DESC";
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

    public ResultSet selectNameOfInstitution() throws SQLException {
        String _selectQuery = " SELECT INSTITUTION_ID,INSTITUTION_NAME " +
                "FROM HR_LU_EDUC_INSTITUTION ";

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

    public ResultSet selectEducationalStatus() throws SQLException {
        String _selectQuery = "SELECT EDUCATIONAL_STATUS FROM HR_LU_EDUCATIONAL_STATUS";

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

//    public ResultSet selectProgramName(String categoryID) throws SQLException {
//        String _selectQuery = "SELECT EDU_TYPE_NAME FROM HR_LU_EDUC_TYPE_CATEGORY WHERE CATEGORY_ID ='" + categoryID + "'";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }
    public ResultSet selectProgramCAtagory() throws SQLException {
        String _selectQuery = "SELECT EDUC_CATAGORY_ID,CATAGORY_NAME " +
                "FROM HR_LU_EDUC_CATAGORY ";

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

    public ResultSet selectInstitutionAdress(String institId) throws SQLException {
        String _selectQuery = "SELECT CONTACT_PERSON,PHONE_NUMBER,EMAIL_ADDRESS,FAX_NUMBER " +
                "FROM HR_EDUC_INSTITUTION where INSTITUTION_ID='" + institId + "'";

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

    public ResultSet selectTypeOFAccredated(String institId) throws SQLException {
        String _selectQuery = "SELECT ACCREDITED_OR_NOT,LOCATION_CATEGORY,INSTITUTION_NAME " +
                "FROM HR_EDUC_INSTITUTION where INSTITUTION_ID='" + institId + "'";
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

    public ResultSet selectDateoFbirth(String empId) throws SQLException {
        String _selectQuery = "SELECT DATE_OF_BIRTH FROM HR_EMPLOYEE_INFO where EMP_ID='" + empId + "'";
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

    public HashMap selectEducationDuty(String employeeId) throws SQLException {
        String qry = "SELECT nvl(GRADUATION_DATE ,'notRegister') as GRADUATION_DATE ,nvl(REQUESTER_ID ,'notRegister') as REQUESTER_ID,nvl(DUTY_SERVICE_YR ,0) as DUTY_SERVICE_YR ,nvl(APPROVE_DENY ,'notRegister') as APPROVE_DENY FROM  HR_EDUC_AGREMENT_DUTY where REQUESTER_ID='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();

            if (_rs != null) {
                if (_rs.next()) {

                    data.put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                    data.put("GRADUATION_DATE", _rs.getString("GRADUATION_DATE"));
                    data.put("DUTY_SERVICE_YR", _rs.getInt("DUTY_SERVICE_YR"));
                    data.put("APPROVE_DENY", _rs.getString("APPROVE_DENY"));
                    return data;
                } else {
                    return null;
                }


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

    public ResultSet selectEducaStatu(String educationRequest) throws SQLException {
        String _selectQuery = "SELECT EDUCATIONAL_STATUS FROM  HR_EDUCATION_REQUEST where REQUESTER_ID='" + educationRequest + "'";
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
 public ResultSet selectEducaChageInst(String educationRequest) throws SQLException {
        String _selectQuery = "SELECT CHANGE_INSTITUTION FROM  HR_EDUCATION_REQUEST where REQUESTER_ID='" + educationRequest + "'";
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
    public ResultSet selectHireDate(String empId) throws SQLException {
        String _selectQuery = "SELECT HIRE_DATE FROM HR_EMPLOYEE_INFO where EMP_ID='" + empId + "'";
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

    public ResultSet selectEducationRequestHistory(String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUCATION_REQUEST " +
                "WHERE REQUEST_STATUS NOT LIKE  " + EducationApproveManager.INITIAL_STATE_EDUCATION +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " +
                "ORDER BY EDUCATION_REQUEST_ID DESC";
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

    /**
     * returns ResultSet object of processed leave requests with their current status<br>
     * Basically intended to show the history of a  given leave request.
     * @param  the status of the request
     * @throws  SQLException*/
    public ResultSet selectProcessedSalaryDelegationRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT REQUEST_ID, " +
                "  mugher.TBL_USERS.EMPLOYEE_ID AS RECORDED_BY_ID, " +
                "  PROCESSED_BY , " +
                "  RECORDED_BY, " +
                //   "  NEXT_STATE AS DECISION, " +
                "  DECISION, " +
                "  TIME_STAMP, " +
                "  COMMENT_GIVEN, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME , " +
                "  PERMISSION_NAME " +
                "FROM HR_EDUCATION_PROCESSED , " +
                "  HR_EMPLOYEE_INFO , " +
                "  mugher.TBL_PERMISSION , " +
                "  mugher.TBL_USERS " +
                "WHERE REQUEST_ID              =" + requestId +
                "AND HR_EMPLOYEE_INFO.EMP_ID   =PROCESSED_BY " +
                "AND mugher.TBL_USERS.user_name=RECORDED_BY " +
                "AND mugher.TBL_PERMISSION.CODE=DECISION " +
                "ORDER BY TIME_STAMP";
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

    EducationRequestEntity(String titleDescription) {
        // this.titleCode = titleCode;
        this.titleDescription = titleDescription;
    }

    public ArrayList<EducationRequestEntity> readEducationLevel(int rank) {
        ArrayList<EducationRequestEntity> kebelleList = new ArrayList<EducationRequestEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_educ_level where rank < = '" + rank + "'");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                EducationRequestEntity KebelleType = new EducationRequestEntity(_rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
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
        return kebelleList;

    }

    public ArrayList<EducationRequestEntity> readDrivingLevel(int rank) {
        ArrayList<EducationRequestEntity> kebelleList = new ArrayList<EducationRequestEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_educ_level where rank  > '" + rank + "'");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                EducationRequestEntity KebelleType = new EducationRequestEntity(_rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
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
        return kebelleList;

    }

    public ArrayList<EducationRequestEntity> readHigherEducationLevel(int rank) {
        ArrayList<EducationRequestEntity> kebelleList = new ArrayList<EducationRequestEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT * FROM hr_lu_educ_level where rank > '" + rank + "'");
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                EducationRequestEntity KebelleType = new EducationRequestEntity(_rs.getString("DESCRIPTION"));
                kebelleList.add(KebelleType);
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
        return kebelleList;
    }

    public ResultSet selectEducationTypeByCategory(int deptId) throws SQLException {
        String _selectQuery = "SELECT DISTINCT lev.description " +
                "FROM hr_employee_info info " +
                "INNER JOIN hr_lu_job_type jobs " +
                "ON info.job_code = jobs.job_code " +
                "RIGHT JOIN hr_lu_jobtype_eductype ty " +
                "ON jobs.job_code=ty.jobtype_id " +
                "JOIN hr_lu_educ_type lev " +
                "ON ty.eductype_id        =lev.educ_type_code " +
                "WHERE info.department_id ='" + deptId + "' " +
                "ORDER BY lev.description DESC";

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

    public ResultSet selectAllEducationTypeByCategory() throws SQLException {
        String _selectQuery = "SELECT DISTINCT description FROM hr_lu_educ_type  ";

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

    public HashMap readEmployeeBasicInfoFromId(String employeeId) throws SQLException {
        String qry = "SELECT emp.emp_id, " +
                "  typ.description, " +
                "  leve.description AS \"levels\" " +
                "FROM hr_emp_education emp " +
                "INNER JOIN hr_lu_educ_level leve " +
                "ON emp.educ_level_code=leve.educ_level_code " +
                "INNER JOIN hr_lu_educ_type typ " +
                "ON typ.educ_type_code=emp.education_type " +
                "WHERE emp.emp_id     ='" + employeeId + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("emp_id"));
                    data.put("description", _rs.getString("description"));
                    data.put("levels", _rs.getString("levels"));
                } else {
                    data.put("employeeId", "");
                    data.put("description", "");
                    data.put("levels", "");
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
}
