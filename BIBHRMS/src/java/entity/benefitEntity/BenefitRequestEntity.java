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
import manager.MilkBenefit.EmployeeRegistrationManager.EmployeeMilkModel;
import manager.benefitManager.BenefitRequestManager;
import manager.benefitManager.BenefitREquestApproveManager;
import manager.benefitManager.BenefitRequestManager.SubSidiyRequestModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class BenefitRequestEntity
        extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public int insertTerminationRequest(EmployeeMilkModel terminationRequestModel) throws SQLException {
        String _insertQuery = "INSERT INTO HR_MILK_SUBSIDY_REQUEST " +
                " (REQUEST_ID,REQUET_TYPE, REQUESTER_ID," +
                " START_DATE,END_DATE," +
                " REQUEST_STATUS, APPLIED_DATE,RECORDED_BY,RECOREDED_DATE_TIME,REMARK,DEPT_ID)" +
                " VALUES (HR_MILK_SQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?) ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, terminationRequestModel.getRequestType());
            _ps.setString(2, terminationRequestModel.getRequesterID());
            _ps.setString(3, terminationRequestModel.getStartDate());
            _ps.setString(4, terminationRequestModel.getEndDate());
            _ps.setString(5, terminationRequestModel.getRequestStatus());
            _ps.setString(6, terminationRequestModel.getAppliedDate());
            _ps.setString(7, terminationRequestModel.getUserName());
            _ps.setString(8, terminationRequestModel.getRecoredTime());
            _ps.setString(9, terminationRequestModel.getRemark());
            _ps.setInt(10, terminationRequestModel.getDeptId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public int UpadateRequest(EmployeeMilkModel terminationRequestModel) throws SQLException {
        String _insertQuery = "UPDATE HR_MILK_SUBSIDY_REQUEST " +
                " SET REQUET_TYPE=?, REQUESTER_ID=?," +
                " START_DATE=?,END_DATE=?," +
                " REQUEST_STATUS=?, APPLIED_DATE=?,RECORDED_BY=?,REMARK=?,DEPT_ID=?" +
                " WHERE REQUEST_ID=? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, terminationRequestModel.getRequestType());
            _ps.setString(2, terminationRequestModel.getRequesterID());
            _ps.setString(3, terminationRequestModel.getStartDate());
            _ps.setString(4, terminationRequestModel.getEndDate());
            _ps.setString(5, terminationRequestModel.getRequestStatus());
            _ps.setString(6, terminationRequestModel.getAppliedDate());
            _ps.setString(7, terminationRequestModel.getUserName());

            _ps.setString(8, terminationRequestModel.getRemark());
            _ps.setInt(9, terminationRequestModel.getDeptId());
            _ps.setInt(10, terminationRequestModel.getRequestId());

            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    public boolean insertCourseTakingList(ArrayList<EmployeeMilkModel> employeeList, String recorededDateAndTime, int deptId) throws SQLException {
        String _insertQuery = "INSERT INTO HR_MILK_SUB_REQ_EMP_LIST " +
                " (LIST_ID," +
                " EMP_ID,ATTENDANCE,RATE,TOTAL_AMOUNT,APPLIDE_TIME,DEPT_ID) " +
                " VALUES (HR_EMP_LIST.NEXTVAL,?,?,?,?,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (EmployeeMilkModel employeregLists : employeeList) {
                _ps.setString(1, employeregLists.getEmpId());
                _ps.setInt(2, employeregLists.getAttendance());
                _ps.setFloat(3, employeregLists.getRate());
                _ps.setFloat(4, employeregLists.getTotalAmount());
                _ps.setString(5, recorededDateAndTime);
                _ps.setInt(6, deptId);
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
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
    private int terminationRequestId;//@Column(name = "TERMINATION_REQUEST_ID")
    private String requesterId;// @Column(name = "REQUESTER_ID")
    private String terminationCatagory;// @Column(name = "TERMINATION_CATAGORY")
    private String terminationType;// @Column(name = "TERMINATION_TYPE")
    private String requestStatus;// @Column(name = "REQUEST_STATUS")
    private String appliedDate;//@Column(name = "APPLIED_DATE")
    private String terminationDate;//  @Column(name = "TERMINATION_DATE")
    private String description;// @Column(name = "DESCRIPTION")
    private String isDocumeentAttached;//  @Column(name = "IS_DOCUMEENT_ATTACHED")
    private String recordedBy;// @Column(name = "RECORDED_BY")
    private String recorededDateAndTime;// @Column(name = "RECOREDED_DATE_AND_TIME")

    public BenefitRequestEntity(int terminationRequestId, String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
        this(requesterId, terminationCatagory, terminationType, requestStatus, appliedDate, terminationDate, description, isDocumeentAttached, recordedBy, recorededDateAndTime);
        this.terminationRequestId = terminationRequestId;
    }

    public BenefitRequestEntity(String requesterId, String terminationCatagory, String terminationType, String requestStatus, String appliedDate, String terminationDate, String description, String isDocumeentAttached, String recordedBy, String recorededDateAndTime) {
        this.requesterId = requesterId;
        this.terminationCatagory = terminationCatagory;
        this.terminationType = terminationType;
        this.requestStatus = requestStatus;
        this.appliedDate = appliedDate;
        this.terminationDate = terminationDate;
        this.description = description;
        this.isDocumeentAttached = isDocumeentAttached;
        this.recordedBy = recordedBy;
        this.recorededDateAndTime = recorededDateAndTime;
    }

    public BenefitRequestEntity() {
    }

    /**
     * Inserts PowerDeligationRequest attribute to the database.<br>
     * The constructor with full argument, must be called before this method
     */
    /**
     * Updates Termintion Request attribute of the database.<br>
     * The constructor with full argument must be called before this method
     * @see
     * @throws  SQLException
     */
    public int updateTerminationRequest(EmployeeMilkModel terminationRequestModel) throws SQLException {
        String _updateQuery = "UPDATE HR_MILK_SUBSIDY_REQUEST " +
                " SET  REQUET_TYPE=?,     REQUESTER_ID=?,      START_DATE=?," +
                " END_DATE=?, REMARK=?, REQUEST_STATUS=?," +
                " APPLIED_DATE=?, RECOREDED_DATE_TIME=?,  RECORDED_BY=?" +
                " where REQUEST_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);

            _ps.setString(1, terminationRequestModel.getRequestType());
            _ps.setString(2, terminationRequestModel.getRequesterID());
            _ps.setString(3, terminationRequestModel.getStartDate());
            _ps.setString(4, terminationRequestModel.getEndDate());
            _ps.setString(5, terminationRequestModel.getRemark());
            _ps.setString(6, terminationRequestModel.getRequestStatus());
            _ps.setString(7, terminationRequestModel.getAppliedDate());
            _ps.setString(8, terminationRequestModel.getRecoredTime());
            _ps.setString(9, terminationRequestModel.getUserName());
            _ps.setInt(10, terminationRequestModel.getRequestId());
            return _ps.executeUpdate();
        } finally {
            releaseResources();
        }
    }

    /**
     * Deletes PowerDeligationRequest from  the database.<br>
     * @return boolean true upon successful excution
     * @param  requestId the value of primary key of the request table
     * @throws SQLException
     */
    public boolean deletePowerDeligationRequest(int requestId) throws SQLException {
        String _deleteQuery = "DELETE HR_MILK_SUBSIDY_REQUEST  WHERE REQUEST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setInt(1, requestId);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteemplistRequest(ArrayList<EmployeeMilkModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_MILK_SUB_REQ_EMP_LIST  WHERE LIST_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getListId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteAllemplistRequest(String time, int dept) throws SQLException {
        String _deleteQuery = "DELETE HR_MILK_SUB_REQ_EMP_LIST  WHERE APPLIDE_TIME=? and DEPT_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            _ps.setString(1, time);
            _ps.setInt(2, dept);
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     * returns ResultSet object of a request with the given id.<br>
     * It returns a ResultSet of either a single row or with no row.
     * @param  requestId  primary key of the table.
     * @throws  SQLException
     */
    public ResultSet selectTerminationRequestFromId(int requestId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_TERMINATION_REQUEST WHERE TERMINATION_REQUEST_ID= " + requestId;
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
     * returns ResultSet object of a request Termination Types.<br>
     * For the termination catagory  passed as an argument
     * @param  terminationCatagory it is either resign or retirement
     * @throws  SQLException
     */
    public ResultSet selectDeptName(int terminationCatagory) throws SQLException {
        String _selectQuery = "SELECT * FROM TBL_DEPARTMENT WHERE DEPT_ID= '" + terminationCatagory + "'";
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

    public ResultSet selectTerminationTypesOne(int terminationCatagory) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_LU_TERMINATION_TYPES WHERE TERMINATION_TYPE_ID= '" + terminationCatagory + "'";
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
     * @return  ResultSet of termination requsts with the given requester.
     * @param requesterId  of employee to whom the request is made
     * @param userName  the user name of the employee who logged in to the system
     * @throws SQLException
     */
    public ResultSet selectTerminationRequestByRequesterId(String requesterId, String userName) throws SQLException {

        //select process possible states for that user in the process termination
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + BenefitREquestApproveManager.PROCESS_MILK_SUBSIDY + "'))";

        String _selectQuery = " SELECT * FROM HR_MILK_SUBSIDY_REQUEST WHERE REQUESTER_ID= '" + requesterId + "'" +
                " AND REQUEST_STATUS IN(" + _innerSelectQuery + ")";
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
     * returns ResultSet object of requests which are not in their final state, nor rejected
     * @param userName  the user name of the employee who logged in to the system
     * @throws  SQLException
     */
    public ResultSet selectApprovableTerminationRequests(String userName) throws SQLException {

        //select process possible states accessible to the user in the process Power deligation
        String _innerSelectQuery = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PROCESS_STATE_ID" +
                " in  ( select PROCESS_STATE_ID from BIB.tbl_authorization " +
                "       where ROLE_NAME in(select ROLE_ID from BIB.TBL_ROLE_USER   " +
                "           where USER_ID=(select USER_ID from BIB.tbl_users where USER_NAME='" + userName + "')) " +
                "           and PROCESS_STATE_ID in (select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE " +
                "               where  PROCESS_ID='" + BenefitREquestApproveManager.PROCESS_MILK_SUBSIDY + "'))";

        String _selectQuery = "SELECT * FROM HR_MILK_SUBSIDY_REQUEST " +
                " WHERE REQUEST_STATUS NOT LIKE 'App-%' " +//not on pending
                " AND REQUEST_STATUS NOT LIKE 'Rej-%' " +//not rejected
                //                " AND REQUEST_STATUS <> '" + SubsidyIndividualApproveManager.INITIAL_STATE_TERMINATION + "' " +//not initial state
                //                " AND REQUEST_STATUS <> '" + SubsidyIndividualApproveManager.FINAL_STATE_TERMINATION + "' " +//not in final state
                " AND REQUEST_STATUS IN(" + _innerSelectQuery + ")";//the user is authorized to access the result
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

    public ResultSet selectPendingTerminationRequests(String requesterId, String recorededBy) throws SQLException {
//        String _selectQuery = "SELECT * FROM HR_MILK_SUBSIDY_REQUEST " +
//                " WHERE " +
//                //   " REQUEST_STATUS = " + BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY + " AND " +
//                " ( RECORDED_BY='" + recorededBy + "' " +
//                "       OR REQUESTER_ID IN (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + recorededBy + "'))";

        String _selectQuery = "SELECT * " + "FROM HR_MILK_SUBSIDY_REQUEST " + "WHERE REQUEST_STATUS LIKE " + BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY +
                "AND (RECORDED_BY   ='" + recorededBy + "' " +
                "OR REQUESTER_ID IN " + "  (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + recorededBy + "' " +
                "  ) ) " + "ORDER BY APPLIED_DATE DESC";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setString(1, requesterId);
//            _ps.setString(2, recorededBy);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectHistoryTerminationRequests(String requesterId, String recorededBy) throws SQLException {

        String _selectQuery = "SELECT * " +
                "FROM HR_MILK_SUBSIDY_REQUEST " +
                "WHERE REQUEST_STATUS NOT LIKE  " + BenefitREquestApproveManager.INITIAL_STATE_MILK_SUBSIDY +
                "AND (RECORDED_BY   ='" + recorededBy + "' " +
                "OR REQUESTER_ID IN " +
                "  (SELECT EMPLOYEE_ID FROM BIB.TBL_USERS WHERE USER_NAME='" + recorededBy + "' " +
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
     * returns ResultSet object of termination request of an employee<br>
     * It returns either single or no row result set.
     * @param  requesterId  id of employee who requested termination
     * @throws  SQLException
     */
    public ResultSet selectEmployeeLatestTerminationRequest(String requesterId) throws SQLException {
        String _selectQuery = "SELECT MAX(SUBSIDY_ID)  AS SUBSIDY_ID FROM HR_SUBSIDY_REQUEST WHERE REQUESTER_ID='" + requesterId + "'";
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
     * returns ResultSet object of termination request of an employee<br>
     * It returns either single or no row result set.
     * @param  requesterId  id of employee who requested termination
     * @throws  SQLException
     */
    public ResultSet selectTerminationRequestByRequestId(int subsidyId) throws SQLException {
        String _selectQuery = "SELECT * FROM HR_MILK_SUBSIDY_REQUEST WHERE REQUEST_ID=" + subsidyId + "";
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

    public ResultSet selectcategoey() throws SQLException {
        String _selectQuery = "SELECT ID,REQUEST_TYPE " +
                "FROM HR_LU_BENEFIT_REQUEST ";

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

    public ResultSet selectEmployeeStatu(String empId) throws SQLException {
        String _selectQuery = "SELECT EMP_STATUS FROM  HR_EMPLOYEE_INFO where EMP_ID='" + empId + "'";
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

    public ArrayList<HashMap> listOFEmployee(String deprtmentId, String startDate, String endDate) {
        String query = "SELECT info.EMP_ID, " +
                "  info.FIRST_NAME " +
                "  ||' ' " +
                "  || info.MIDDLE_NAME " +
                "  ||' ' " +
                "  || info.LAST_NAME               AS FULL_NAME, " +
                "  COUNT( NVL(Atte.absentamount,0))AS AbcentDate " +
                "FROM Hr_Employee_Info Info , " +
                "  (SELECT Absentamount, " +
                "    Emp_Id " +
                "  FROM hr_emp_attendance Att " +
                "  WHERE Att.Attendancetakendate BETWEEN '" + startDate + "' AND '" + endDate + "' " +
                "  )Atte " +
                "WHERE Info.Emp_Id      = Atte.Emp_Id " +
                "AND info.DEPARTMENT_ID ='" + deprtmentId + "' " +
                "GROUP BY info.EMP_ID, " +
                "  info.FIRST_NAME " +
                "  ||' ' " +
                "  || info.MIDDLE_NAME " +
                "  ||' ' " +
                "  || info.LAST_NAME";

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULL_NAME"));
                hm.put("AbcentDate", rs.getString("AbcentDate"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOFRegisteredEmployee(String deptId, String startDate, String endDate) {
        String query = "SELECT info.EMP_ID, " +
                "  info.FIRST_NAME " +
                "  ||' ' " +
                "  || info.MIDDLE_NAME " +
                "  ||' ' " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  Mil.Remark, " +
                "  Mil.Id, " +
                "  NVL(Atte.Absentamount,0)AS Abcentdate " +
                "FROM HR_MILKBENEFIT_EMPLOYEE mil " +
                "INNER JOIN Hr_Employee_Info Info " +
                "ON Mil.Emp_Id =Info.Emp_Id " +
                "LEFT JOIN " +
                "  (SELECT COUNT(NVL(Absentamount,0))AS Absentamount, " +
                "    EMP_ID " +
                "  FROM hr_emp_attendance Att " +
                "  WHERE Att.Attendancetakendate BETWEEN '" + startDate + "'  AND '" + endDate + "'  " +
                "  GROUP BY EMP_ID " +
                "  )Atte " +
                "ON Mil.Emp_Id            = Atte.Emp_Id " +
                "WHERE info.DEPARTMENT_ID ='" + deptId + "' ";

        ArrayList<HashMap> listofEmp = new ArrayList<HashMap>();
        try {
            Connection con = null;
            PreparedStatement ps = null;
            ResultSet rs = null;
            con = getConnection();
            ps = con.prepareStatement(query);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", rs.getString("EMP_ID"));
                hm.put("FULL_NAME", rs.getString("FULL_NAME"));
                hm.put("remark", rs.getString("remark"));
                hm.put("id", rs.getString("id"));
                hm.put("AbcentDate", rs.getString("AbcentDate"));
                listofEmp.add(hm);
            }
            return listofEmp;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readMilkRate() {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        int i = 0;
        String str = "SELECT  RATES FROM  HR_LU_MILK_RATE ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                return _rs.getString("RATES");
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
 public String readSepecialRequestRate() {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        int i = 0;
        String str = "SELECT  RATE FROM  HR_LU_SEPECIAL_BENEFIT_RATE ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                return _rs.getString("RATE");
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    public String readSubsidyRate() {

        int i = 0;
        String str = "SELECT  RATE FROM  HR_LU_SUBSIDY_RATE ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                return _rs.getString("RATE");
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertBenefitTypes(ArrayList<EmployeeMilkModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO  HR_MILKBENEFIT_EMPLOYEE " +
                " (ID,EMP_ID,DEP_ID, REMARK)" +
                " VALUES(HR_MILK_SQ.NEXTVAL,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getEmpId());
                _ps.setInt(2, benefitLists.get(counter).getDeptId());
                _ps.setString(3, benefitLists.get(counter).getRemark());


                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateBenefitTypes(ArrayList<EmployeeMilkModel> benefitLists) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE  HR_MILK_SUB_REQ_EMP_LIST " +
                " SET EMP_ID=?,ATTENDANCE=?, RATE=?,TOTAL_AMOUNT=?,APPLIDE_TIME=?,DEPT_ID=? " +
                " WHERE LIST_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            int lengthOfList = benefitLists.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, benefitLists.get(counter).getEmpId());
                _ps.setInt(2, benefitLists.get(counter).getAttendance());
                _ps.setDouble(3, benefitLists.get(counter).getRate());
                _ps.setFloat(4, benefitLists.get(counter).getTotalAmount());
                _ps.setString(5, benefitLists.get(counter).getRecoredTime());
                _ps.setInt(6, benefitLists.get(counter).getDeptId());
                _ps.setInt(7, benefitLists.get(counter).getListId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteBenefitTypes(ArrayList<EmployeeMilkModel> benefitTypeList) throws SQLException {
        String _deleteQuery = "DELETE HR_MILKBENEFIT_EMPLOYEE " +
                " where ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deleteQuery);
            int lengthOfList = benefitTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, benefitTypeList.get(counter).getBenefitID());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public OracleCachedRowSet readAllTableInfo(int requestID, String date) throws SQLException {

        String _selectQuery = "select * from HR_MILK_SUB_REQ_EMP_LIST where DEPT_ID='" + requestID + "' and APPLIDE_TIME='" + date + "' ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
//
            return ocrs;
        } finally {
            releaseResources();
        }
    }

    public ArrayList<HashMap> loadSubsidyPaymentForReport(HashMap list) {
        String select = "SELECT info.emp_id, " +
                "  info.first_name " +
                "  ||info.middle_name " +
                "  || info.last_name AS EMPLOYEEFULLNAME, " +
                "  req.applied_date, " +
                "  list.attendance, " +
                "  list.rate, " +
                "  list.total_amount, " +
                "  dep.dep_description " +
                "FROM hr_milk_subsidy_request req " +
                "INNER JOIN hr_milk_subsidy_processed pro " +
                "ON req.request_id=pro.request_id " +
                "INNER JOIN HR_MILK_SUB_REQ_EMP_LIST list " +
                "ON list.applide_time=req.recoreded_date_time " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id= list.emp_id " +
                "INNER JOIN tbl_department dep " +
                "ON list.dept_id=dep.dept_id " +
                "WHERE Req.RECOREDED_DATE_TIME LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                "AND req.request_status LIKE 'App-%' " +
                "AND list.dept_id   =req.dept_id " +
                "AND req.requet_type=3";
        ArrayList<HashMap> readSubsidyPayment = new ArrayList<HashMap>();
        ResultSet rsFamily;
        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            //ps.setString(1, employeeID);
            rsFamily = ps.executeQuery();
            ocrs.populate(rsFamily);
            rsFamily.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEFULLNAME", ocrs.getString("EMPLOYEEFULLNAME"));
                hm.put("DATE", ocrs.getString("applied_date"));
                hm.put("ATTENDANCE", Double.parseDouble(ocrs.getString("attendance")));
                hm.put("RATE", Double.parseDouble(ocrs.getString("rate")));
                hm.put("TOTALPAYMENT", Double.parseDouble(ocrs.getString("total_amount")));
                hm.put("DEPARTMENT", ocrs.getString("dep_description"));
                readSubsidyPayment.add(hm);
            }
           
            return readSubsidyPayment;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> loadMilkPaymentForReport(String startDate, String endDate) {
        String select = "SELECT info.emp_id, " +
                "  info.first_name " +
                "  ||info.middle_name " +
                "  || info.last_name AS EMPLOYEEFULLNAME, " +
                "  req.applied_date, " +
                "  list.attendance, " +
                "  (list.attendance/2) AS litter, " +
                "  list.rate, " +
                "  ( (list.attendance/2)* list.rate) AS total_amount, " +
                "  dep.dep_description, " +
                "  REQ.START_DATE, " +
                "  req.end_date " +
                "FROM hr_milk_subsidy_request req " +
                "INNER JOIN hr_milk_subsidy_processed pro " +
                "ON req.request_id=pro.request_id " +
                "INNER JOIN HR_MILK_SUB_REQ_EMP_LIST list " +
                "ON list.applide_time=req.recoreded_date_time " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id= list.emp_id " +
                "INNER JOIN tbl_department dep " +
                "ON list.dept_id=dep.dept_id " +
                "WHERE req.start_date LIKE '" + startDate + "' " +
                "AND req.end_date LIKE '" + endDate + "' " +
                "AND req.request_status LIKE 'App-%' " +
                "AND list.dept_id   =req.dept_id " +
                "AND req.requet_type=2 " +
                "OR req.requet_type =1";
        ArrayList<HashMap> readSubsidyPayment = new ArrayList<HashMap>();
        ResultSet rsFamily;
        int i = 0;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            //ps.setString(1, employeeID);
            rsFamily = ps.executeQuery();
            ocrs.populate(rsFamily);
            rsFamily.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEFULLNAME", ocrs.getString("EMPLOYEEFULLNAME"));
                hm.put("DATE", ocrs.getString("applied_date"));
                hm.put("ATTENDANCE", Double.parseDouble(ocrs.getString("attendance")));
                hm.put("RATE", Double.parseDouble(ocrs.getString("rate")));
                hm.put("TOTALPAYMENT", Double.parseDouble(ocrs.getString("total_amount")));
                hm.put("DEPARTMENT", ocrs.getString("dep_description"));
                hm.put("AMOUNLITTER", Double.parseDouble(ocrs.getString("litter")));
               // hm.put("STARTDATE", ocrs.getString("START_DATE"));
               // hm.put("ENDDATE", ocrs.getString("end_date"));
                readSubsidyPayment.add(hm);
            }
            closePooledConnections(_conn);
            return readSubsidyPayment;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
