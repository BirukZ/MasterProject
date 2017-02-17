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
import manager.educationManager.EducationPostPaymentApproveManager;
import manager.educationManager.EducationPaymentModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class EducationPostPaymentRequestEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    PreparedStatement _ps2 = null;
    ResultSet _rs2 = null;
    Connection _con2 = null;

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

    /**
     * Inserts PowereducationPaymentRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int insertEducationPaymentRequest(EducationPaymentModel educationPaymentRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_EDUC_POST_PAY_REQUEST " +
                " (EDUCATION_REQUEST_ID," +
                "  PAYMENT_PRE_OR_POST, ACADEMIC_YEAR,SEMESTER_OR_TERM, APPLIED_DATE, " +
                " ISSUE_DATE, REMARK, DOC_REFERENCE_NUMBER, " +
                " RECEIPT_NUMBER, REQUEST_STATUS, TIME_STAMP, USER_NAME, TOTAL_COST,REQUESTER_ID) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, educationPaymentRequestModel.getEducationRequestId());
            _ps.setString(2, educationPaymentRequestModel.getPaymentPreOrPost());
            _ps.setString(3, educationPaymentRequestModel.getAcademicYear());
            _ps.setString(4, educationPaymentRequestModel.getSemesterOrTerm());

            _ps.setString(5, educationPaymentRequestModel.getAppliedDate());
            _ps.setString(6, educationPaymentRequestModel.getIssueDate());
            _ps.setString(7, educationPaymentRequestModel.getRemark());
            _ps.setString(8, educationPaymentRequestModel.getDocumentReferenceNumber());
            _ps.setString(9, educationPaymentRequestModel.getReceiptNumber());
            _ps.setString(10, educationPaymentRequestModel.getRequestStatus());

            _ps.setString(11, educationPaymentRequestModel.getTimeStamp());
            _ps.setString(12, educationPaymentRequestModel.getUserName());

            _ps.setDouble(13, educationPaymentRequestModel.getTotalCost());
            // _ps.setFloat(14, educationPaymentRequestModel.getCumlativeGPA());
            _ps.setString(14, educationPaymentRequestModel.getRequesterId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public boolean insertEducationAdminstrat(ArrayList<EducationPaymentModel> adminstrativeCostLists, String Date) throws SQLException {
        String _insertQuery = "INSERT INTO HR_ADMINSTRATIVE_COST " +
                " (AMINSTRATIVE_COST_TYPE, UNIT_COST," +
                "  TOTAL_COST, REQUESTER_ID,EDUC_REQ_ID,APPLIDE_DATE) " +
                " VALUES (?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationPaymentModel currentadminstrativeCostLists : adminstrativeCostLists) {
                _ps.setString(1, currentadminstrativeCostLists.getAdminstraticeCostType());
                _ps.setDouble(2, currentadminstrativeCostLists.getUnitCost());
                _ps.setDouble(3, currentadminstrativeCostLists.getTotalCost());
                _ps.setString(4, currentadminstrativeCostLists.getRequesterId());
                _ps.setInt(5, currentadminstrativeCostLists.getEducationRequestId());
                _ps.setString(6, Date);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean UpdteEducationAdminstrat(ArrayList<EducationPaymentModel> adminstrativeCostLists, int adminId) throws SQLException {
        String _insertQuery = "UPDATE HR_ADMINSTRATIVE_COST " +
                " SET AMINSTRATIVE_COST_TYPE=?, UNIT_COST=?," +
                " QUANTITY=?, TOTAL_COST=?, REQUESTER_ID=?,EDUC_REQ_ID=? " +
                " WHERE ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationPaymentModel currentadminstrativeCostLists : adminstrativeCostLists) {
                _ps.setString(1, currentadminstrativeCostLists.getAdminstraticeCostType());
                _ps.setDouble(2, currentadminstrativeCostLists.getUnitCost());
                _ps.setDouble(3, currentadminstrativeCostLists.getQuantity());
                _ps.setDouble(4, currentadminstrativeCostLists.getTotalCost());
                _ps.setString(5, currentadminstrativeCostLists.getRequesterId());
                _ps.setInt(6, currentadminstrativeCostLists.getEducationRequestId());
                _ps.setInt(7, adminId);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertCourseTakingList(ArrayList<EducationPaymentModel> courseTakingList,String appliedDate) throws SQLException {
        String _insertQuery = "INSERT INTO HR_COURSE_PERSEMISTER " +
                " (COURSE_CODE,EDUC_REQ_ID," +
                " CGPA,GRADE_PT,SEMISTER,REQUESTER_ID,ACADAMIC_YEAR,CREDIT_HOUR,APPLIDE_DATE,INSTITUTION_NAME,STATUS) " +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationPaymentModel currentCOurseLists : courseTakingList) {
                _ps.setString(1, currentCOurseLists.getCourseCode());
                _ps.setInt(2, currentCOurseLists.getEducationRequestId());
                _ps.setFloat(3, currentCOurseLists.getCumlativeGPA());
                _ps.setString(4, currentCOurseLists.getGradept());
                _ps.setString(5, currentCOurseLists.getSemesterOrTerm());
                _ps.setString(6, currentCOurseLists.getRequesterId());
                _ps.setString(7, currentCOurseLists.getAcademicYear());
                _ps.setInt(8, Integer.valueOf(currentCOurseLists.getCreditHr()));
                _ps.setString(9, appliedDate);
                _ps.setString(10, currentCOurseLists.getInstName());
                _ps.setString(11, currentCOurseLists.getDatabaseStatus());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean UpadetCourseTakingList(ArrayList<EducationPaymentModel> courseTakingList, int courseID) throws SQLException {
        String _insertQuery = "Update HR_COURSE_PERSEMISTER " +
                " set SEMISTER=?, COURSE_CODE=?," +
                " CREDIT_HOUR=?,REQUESTER_ID=?,EDUC_REQ_ID=?,CGPA=? " +
                " where id=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EducationPaymentModel currentCOurseLists : courseTakingList) {
                _ps.setString(1, currentCOurseLists.getSemesterOrTerm());
                _ps.setString(2, currentCOurseLists.getCourseCode());
                _ps.setString(3, currentCOurseLists.getCreditHr());
                _ps.setString(4, currentCOurseLists.getRequesterId());
                _ps.setInt(5, currentCOurseLists.getEducationRequestId());
                _ps.setFloat(6, currentCOurseLists.getCumlativeGPA());
                _ps.setInt(7, courseID);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean UpadetCoursePostTakingList(ArrayList<EducationPaymentModel> courseTakingList) throws SQLException {
        String _insertQuery = "Update HR_COURSE_PERSEMISTER set " +
                " CGPA=?, GRADE_PT=?" +
                " where ID=? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            int lengthOfList = courseTakingList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setFloat(1, courseTakingList.get(counter).getCumlativeGPA());
                _ps.setString(2, courseTakingList.get(counter).getGradept());
                _ps.setInt(3, courseTakingList.get(counter).getCourseId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * Inserts PowereducationPaymentRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int updateEducationPaymentRequest(EducationPaymentModel educationPaymentRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_EDUC_POST_PAY_REQUEST " +
                " SET EDUCATION_REQUEST_ID= ? , " +
                " TOTAL_COST= ? , CGPA=?,REQUESTER_ID=? " +
                " PAYMENT_PRE_OR_POST= ? ,  ACADEMIC_YEAR= ? ,  SEMESTER_OR_TERM= ? ,  " +
                " APPLIED_DATE= ? ,  ISSUE_DATE= ? ,  REMARK= ? ,  RECEIPT_NUMBER= ? ,  DOC_REFERENCE_NUMBER= ? ,  " +
                " REQUEST_STATUS= ? ,  TIME_STAMP= ? ,  USER_NAME = ? " +
                " WHERE EDUC_PAYMENT_REQUEST_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setInt(1, educationPaymentRequestModel.getEducationRequestId());
            _ps.setDouble(2, educationPaymentRequestModel.getTotalCost());
            _ps.setFloat(3, educationPaymentRequestModel.getCumlativeGPA());
            _ps.setString(4, educationPaymentRequestModel.getRequesterId());
            _ps.setString(5, educationPaymentRequestModel.getPaymentPreOrPost());
            _ps.setString(6, educationPaymentRequestModel.getAcademicYear());
            _ps.setString(7, educationPaymentRequestModel.getSemesterOrTerm());
            _ps.setString(8, educationPaymentRequestModel.getAppliedDate());
            _ps.setString(9, educationPaymentRequestModel.getIssueDate());
            _ps.setString(10, educationPaymentRequestModel.getRemark());

            _ps.setString(11, educationPaymentRequestModel.getReceiptNumber());
            _ps.setString(12, educationPaymentRequestModel.getDocumentReferenceNumber());

            _ps.setString(13, educationPaymentRequestModel.getRequestStatus());
            _ps.setString(14, educationPaymentRequestModel.getTimeStamp());
            _ps.setString(15, educationPaymentRequestModel.getUserName());
            _ps.setInt(16, educationPaymentRequestModel.getEducationPaymentId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int updateEducationAdminstrativecost(EducationPaymentModel educationPaymentRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_ADMINSTRATIVE_COST " +
                " SET  AMINSTRATIVE_COST_TYPE= ? ,  UNIT_COST= ? , " +
                " QUANTITY= ? ,  TOTAL_COST= ? ,  REQUESTER_ID= ? " +
                " WHERE ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, educationPaymentRequestModel.getAdminstraticeCostType());
            _ps.setDouble(2, educationPaymentRequestModel.getUnitCost());
            _ps.setDouble(3, educationPaymentRequestModel.getQuantity());
            _ps.setDouble(4, educationPaymentRequestModel.getTotalCost());
            _ps.setString(5, educationPaymentRequestModel.getRequesterId());
            _ps.setString(6, educationPaymentRequestModel.getRequesterId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Inserts PowereducationPaymentRequestModel attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    public int deleteEducationPaymentRequest(int educationRequestId) throws SQLException {
        String _deleteQuery = "DELETE HR_EDUC_POST_PAY_REQUEST" +
                " WHERE EDUC_POS_PAYMENT_REQ_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educationRequestId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int deleteAdminstrativeCostRequest(int educationRequestId) throws SQLException {
        String _deleteQuery = "DELETE HR_ADMINSTRATIVE_COST " +
                " WHERE EDUC_REQ_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educationRequestId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int deleteCourseRequest(int educationRequestId) throws SQLException {
        String _deleteQuery = "DELETE HR_COURSE_PERSEMISTER " +
                " WHERE EDUC_REQ_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educationRequestId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int deleteCourseBasicLevel(int educationRequestId) throws SQLException {
        String _deleteQuery = "DELETE HR_BASIC_LEVEL_RESULT " +
                " WHERE EDU_REQ_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, educationRequestId);
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public boolean deleteCoursePosRequest(ArrayList<EducationPaymentModel> courseTakingList) throws SQLException {
        String _deleteQuery = "DELETE HR_COURSE_PERSEMISTER " +
                " WHERE ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = courseTakingList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, courseTakingList.get(counter).getCourseId());
                _ps.addBatch();
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectEducationPaymentRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_EDUC_POST_PAY_REQUEST" +
                " WHERE EDUC_POS_PAYMENT_REQ_ID = ?";
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

    public ResultSet selectEducationpOSPaymentRequest(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_EDUC_POST_PAY_REQUEST " +
                " WHERE EDUC_POS_PAYMENT_REQ_ID = ?";
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

    public ResultSet selectEducationpOSResultRequest(int requestId, String appliedDate) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_BASIC_LEVEL_RESULT " +
                " WHERE EDU_REQ_ID = ? and APPLIED_DATE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestId);
            _ps.setString(2, appliedDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPendingEducationPaymentRequests(String userName) throws SQLException {
        String _selectQuery = "SELECT * " + "FROM HR_EDUC_POST_PAY_REQUEST " + "WHERE REQUEST_STATUS LIKE " + EducationPostPaymentApproveManager.INITIAL_STATE_EDUCATION_POST_PAYMENT +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " + "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " + "ORDER BY EDUC_POS_PAYMENT_REQ_ID DESC";
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

    public ResultSet selectPendingEducationpOSPaymentRequests(String userName) throws SQLException {
        String _selectQuery = "SELECT * " + "FROM HR_EDUC_POST_PAY_REQUEST " + "WHERE REQUEST_STATUS LIKE " + EducationPostPaymentApproveManager.INITIAL_STATE_EDUCATION_POST_PAYMENT +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " + "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " + "ORDER BY APPLIED_DATE DESC";
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

    public ResultSet selectEducationPaymentRequestHistory(String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUC_POST_PAY_REQUEST " +
                "WHERE REQUEST_STATUS NOT LIKE  " + EducationPostPaymentApproveManager.INITIAL_STATE_EDUCATION_POST_PAYMENT +
                " and payment_pre_or_post       ='PRE'" +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " +
                "ORDER BY EDUC_POS_PAYMENT_REQ_ID DESC";
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

    public ResultSet selectEducationPosPaymentRequestHistory(String userName) throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_EDUC_POST_PAY_REQUEST " +
                "WHERE REQUEST_STATUS NOT LIKE  " + EducationPostPaymentApproveManager.INITIAL_STATE_EDUCATION_POST_PAYMENT +
                "AND (USER_NAME   ='" + userName + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM MUGHER.TBL_USERS WHERE USER_NAME='" + userName + "' " +
                "  ) ) " +
                "ORDER BY APPLIED_DATE DESC";
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
    public ResultSet selectProcessedEducationPaymentRequest(int requestId) throws SQLException {
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
                "ORDER BY TIME_STAMP desc";
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

    public ResultSet selectAdminstrativeCost() throws SQLException {
        String _selectQuery = "SELECT ADMINSTRATIVE_COST_ID,ADMINSTRATIVE_COST_TYPE " +
                "FROM HR_LU_ADMINSTRATIVE_COST ";

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

    public ResultSet selectProgramName(String categoryID) throws SQLException {
        String _selectQuery = "SELECT EDU_TYPE_NAME FROM HR_LU_EDUC_TYPE_CATEGORY WHERE CATEGORY_ID ='" + categoryID + "'";
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

    public HashMap readEmployeeCourseInfo(String employeeId, String courseCode) throws SQLException {
        String qry = "SELECT COURSE_CODE,REQUESTER_ID FROM HR_COURSE_PERSEMISTER WHERE REQUESTER_ID='" + employeeId + "' AND COURSE_CODE='" + courseCode + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("REQUESTER_ID"));
                    data.put("courseCode", _rs.getString("COURSE_CODE"));
                } else {
                    data.put("employeeId", "");
                    data.put("courseCode", "");

                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public OracleCachedRowSet readAllTableInfo(int requestID, String date) throws SQLException {

        String _selectQuery = "select * from HR_ADMINSTRATIVE_COST where EDUC_REQ_ID=? and APPLIDE_DATE=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, requestID);
            _ps.setString(2, date);
            _rs = _ps.executeQuery();
//
            OracleCachedRowSet ocrs = new OracleCachedRowSet();

            ocrs.populate(_rs);
//
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllCourse(int requestID, String date) throws SQLException {


        String select = "select * from HR_COURSE_PERSEMISTER where EDUC_REQ_ID=? and APPLIDE_DATE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, requestID);
            _ps.setString(2, date);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public OracleCachedRowSet readAllCoursePos(String acadamicYaer, String semister, String requesterId) throws SQLException {


        String select = "select * from HR_COURSE_PERSEMISTER where ACADAMIC_YEAR=? and SEMISTER=? and requester_id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, acadamicYaer);
            _ps.setString(2, semister);
            _ps.setString(3, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }

    }

    public HashMap readEducationInfo(String employeeId) throws SQLException {
        String qry = "SELECT EDUCATION_REQUEST_ID,REQUESTER_ID,INSTITUTION_NAME,EDUCATION_PROGRAM_NAME,EDUCATION_LEVEL_CATEGORY,DOCUMENT_REFERENCE_NUMBER,EDU_LEVEL_ID,CHANGE_INSTITUTION FROM HR_EDUCATION_REQUEST WHERE REQUESTER_ID='" + employeeId + "'" +
                "AND REQUEST_STATUS NOT LIKE '" + EducationApproveManager.INITIAL_STATE_EDUCATION + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("employeeId", _rs.getString("REQUESTER_ID"));
                    data.put("educRequestId", _rs.getString("EDUCATION_REQUEST_ID"));
                    data.put("institutionNAme", _rs.getString("INSTITUTION_NAME"));
                    data.put("educProgramName", _rs.getString("EDUCATION_PROGRAM_NAME"));
                    data.put("educLevelCategort", _rs.getString("EDUCATION_LEVEL_CATEGORY"));
                    data.put("docReference", _rs.getString("DOCUMENT_REFERENCE_NUMBER"));
                    data.put("docReference", _rs.getString("DOCUMENT_REFERENCE_NUMBER"));
                    data.put("levelId", _rs.getString("EDU_LEVEL_ID"));
                     data.put("CHANGE_INSTITUTION", _rs.getString("CHANGE_INSTITUTION"));

                } else {
                    data.put("employeeId", "");
                    data.put("educRequestId", "");
                    data.put("institutionNAme", "");
                    data.put("educProgramName", "");
                    data.put("docReference", "");
                    data.put("educLevelCategort", "");
                     data.put("CHANGE_INSTITUTION", "");
                }
                return data;
            } else {
                return null;
            }

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int insertBasic(EducationPaymentModel educationPaymentRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_BASIC_LEVEL_RESULT " +
                "(EDU_REQ_ID, REQUSTER_ID,GRADE,PASS_FAIL,RESULT,APPLIED_DATE)" +
                " VALUES (?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setInt(1, educationPaymentRequestModel.getEducationRequestId());
            _ps.setString(2, educationPaymentRequestModel.getRequesterId());
            _ps.setString(3, educationPaymentRequestModel.getGradeBasic());
            _ps.setString(4, educationPaymentRequestModel.getResultBasic());
            _ps.setDouble(5, educationPaymentRequestModel.getScore());
            _ps.setString(6, educationPaymentRequestModel.getAppliedDate());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet checkPrePaid(String acadamicYaer, String semister, String requesterId) throws SQLException {
        String select = "select * from HR_EDUC_PAYMENT_REQUEST where ACADEMIC_YEAR=? and SEMESTER_OR_TERM=? and REQUESTER_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, acadamicYaer);
            _ps.setString(2, semister);
            _ps.setString(3, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet checkPostPaid(String acadamicYaer, String semister, String requesterId) throws SQLException {
        String select = "select * from HR_EDUC_POST_PAY_REQUEST where ACADEMIC_YEAR=? and SEMESTER_OR_TERM=? and REQUESTER_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, acadamicYaer);
            _ps.setString(2, semister);
            _ps.setString(3, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet checkPrePaidReceipt(String requesterId) throws SQLException {
        String select = "select RECEIPT_NUMBER from HR_EDUC_PAYMENT_REQUEST where REQUESTER_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, requesterId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet checkPrePaid(int requestId) throws SQLException {
        String select = "select REQUESTER_ID from HR_EDUC_PAYMENT_REQUEST where EDUCATION_REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, requestId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet checkEnrolled(String requesterId, String programName) throws SQLException {
        String select = "SELECT EDUCATIONAL_STATUS " +
                "FROM HR_EDUCATION_REQUEST " +
                "WHERE REQUESTER_ID         =? " +
                "AND EDUCATION_PROGRAM_NAME=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, requesterId);
            _ps.setString(2, programName);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
    }
}
