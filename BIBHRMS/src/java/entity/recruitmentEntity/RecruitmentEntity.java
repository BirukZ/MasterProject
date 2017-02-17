/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

/**
 *
 * @author Administrator
 */
import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class RecruitmentEntity extends ConnectionManager {

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
    String bachCode;
    String numberRequiredEmployee;
    String requirementType;
    String employeeID;
    int committeeId;
    String requestStatus;
    String approvedBy;
    String approveDate;
    String numberOfApprovedEmp;
    String description;
    String recruitmentRequestDate;
    String requiredJobType;
    String remark;
    String workingPlace;
    String code;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static int start,  end;

    public static int getEnd() {
        return end;
    }

    public static void setEnd(int end) {
        RecruitmentEntity.end = end;
    }

    public static int getStart() {
        return start;
    }

    public static void setStart(int start) {
        RecruitmentEntity.start = start;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public String getApproveDate() {
        return approveDate;
    }

    public void setApproveDate(String approveDate) {
        this.approveDate = approveDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getBachCode() {
        return bachCode;
    }

    public void setBachCode(String bachCode) {
        this.bachCode = bachCode;
    }

    public String getNumberOfApprovedEmp() {
        return numberOfApprovedEmp;
    }

    public void setNumberOfApprovedEmp(String numberOfApprovedEmp) {
        this.numberOfApprovedEmp = numberOfApprovedEmp;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int action) {
        this.committeeId = action;
    }

    public RecruitmentEntity(String bachCode, String approvedBy, String approveDate, String numberOfApprovedEmp, String employeeID, int committeeId) {
        this.bachCode = bachCode;
        this.approvedBy = approvedBy;
        this.approveDate = approveDate;
        this.numberOfApprovedEmp = numberOfApprovedEmp;
        this.employeeID = employeeID;
        this.committeeId = committeeId;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public RecruitmentEntity() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public RecruitmentEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getNumberRequiredEmployee() {
        return numberRequiredEmployee;
    }

    public void setNumberRequiredEmployee(String numberRequiredEmployee) {
        this.numberRequiredEmployee = numberRequiredEmployee;
    }

    public String getRecruitmentRequestDate() {
        return recruitmentRequestDate;
    }

    public void setRecruitmentRequestDate(String recruitmentRequestDate) {
        this.recruitmentRequestDate = recruitmentRequestDate;
    }

    public String getRequiredJobType() {
        return requiredJobType;
    }

    public void setRequiredJobType(String requiredJobType) {
        this.requiredJobType = requiredJobType;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public RecruitmentEntity(String recruitmentRequestDate, String requiredJobType, String numberRequiredEmployee, String requirementType, String employeeID, String remark, String workingPlace, String requestStatus) {

        this.recruitmentRequestDate = recruitmentRequestDate;
        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;
        this.employeeID = employeeID;
        this.remark = remark;
        this.workingPlace = workingPlace;
        this.requestStatus = requestStatus;

    }

    public int saveRecruitmentRequest(RecruitmentEntity saveRequest) {
        // String _selectDullu=    "SELECT HR_SEQ_REQREQ.NEXTVAL FROM dual";

        String _select = "INSERT INTO hr_recruitment_request" +
                "(RECRUIT_REQUEST_ID,recruit_Request_Ref_Date,recruit_Request_Type,num_Of_Emps,job_Code,requester_Id,REMARK,DEPARTMENT_ID,REQUEST_STATUS)" +
                " VALUES (HR_RECURITMENT_SEQ.NEXTVAL,'" + saveRequest.getRecruitmentRequestDate() + "','" + saveRequest.getRequirementType() + "','" + saveRequest.getNumberRequiredEmployee() + "','" + saveRequest.getRequiredJobType() + "','" +
                saveRequest.getEmployeeID() + "','" + saveRequest.getRemark() + "','" + saveRequest.getWorkingPlace() + "','" + saveRequest.getRequestStatus() + "')";
        String reqStatus = " INSERT INTO HR_RECRUITMENT_REQUEST_STATUS " +
                " (REC_REQ_STATUS_ID,REQUEST,APPROVE,ADVERTISE,REJECT,RECRUIT_REQUEST_ID) " +
                " VALUES(HR_SEQ_REQREQ.NEXTVAL,'" + 1 + "','" + 0 + "','" + 0 + "','" + 0 + "',HR_RECURITMENT_SEQ.currval)";

//         String reqStatus = " INSERT INTO HR_RECRUITMENT_REQUEST_STATUS " +
//                " (RECRUIT_REQUEST_ID,REQUEST,APPROVE,ADVERTISE,REJECT) " +
//                " VALUES(HR_RECURITMENT_SEQ.currval,'" + 1 + "','" + 0 + "','" + 0 + "','" + 0 + "')" ;




        //HR_SEQ_REQREQ.NEXTVAL
        //HR_SEQ_REQREQ.currval

        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        int checkSave;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            // _ps2=_con.prepareStatement(_selectDullu);
            _ps = _con.prepareStatement(_select);
            // checkSave=_ps2.executeUpdate();

            checkSave = _ps.executeUpdate();

            if (checkSave != 0) {
                _ps1 = _con.prepareStatement(reqStatus);
                System.out.println(reqStatus);
                checkSave = _ps1.executeUpdate();

                if (checkSave == 1) {
                    _con.commit();
                    return checkSave;

                } else {
                    return checkSave;
                }
            }

            return checkSave;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps1.close();
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public int deleteRecruitmentRequest(String RecruitmentRequestid) {

        String _select = "delete from hr_recruitment_request where recruit_Request_Id ='" + RecruitmentRequestid + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public int updateCandidateStatus(int candidateID) {
        String _select = " UPDATE HR_CANDIDATE " +
                " set APPROVE='Approved' where CANDIDATE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setInt(1, candidateID);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public int updateCandidateStatusBeforExam(int candidateID) {

        String _select = " UPDATE HR_CANDIDATE " +
                " set FOR_EXAM='1' where CANDIDATE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setInt(1, candidateID);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public int updateRecruitmentRequest(RecruitmentEntity saveRequest, String recruitmentRequestId) {

        String _select = " UPDATE hr_recruitment_request" +
                " set recruit_Request_Ref_Date=?,recruit_Request_Type=?,num_Of_Emps=?,job_Code=?,requester_Id=?,REMARK=?,DEPARTMENT_ID=? where RECRUIT_REQUEST_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, saveRequest.getRecruitmentRequestDate());
            _ps.setString(2, saveRequest.getRequirementType());
            _ps.setString(3, saveRequest.getNumberRequiredEmployee());
            _ps.setString(4, saveRequest.getRequiredJobType());
            _ps.setString(5, saveRequest.getEmployeeID());
            _ps.setString(6, saveRequest.getRemark());
            _ps.setString(7, saveRequest.getWorkingPlace());
            _ps.setString(8, recruitmentRequestId);


            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public ArrayList<RecruitmentEntity> newRecruitmentRequests() {

        String _select = "SELECT * FROM" +
                " hr_recruitment_request , hr_lu_job_type, HR_RECRUITMENT_REQUEST_STATUS " +
                " WHERE hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID order by recruit_request_ref_date desc ";
//                " AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE ='0' AND HR_RECRUITMENT_REQUEST_STATUS.REJECT ='0' ";

        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("recruit_Request_Id"), _rs.getString("JOB_NAME")+"-ON-"+_rs.getString("recruit_request_ref_date"));
                requests.add(read);
            }
            return requests;
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

    public ArrayList<RecruitmentEntity> approvedRecruitmentRequests() {

        String _select = "SELECT * FROM" +
                " hr_recruitment_request , hr_lu_job_type, HR_RECRUITMENT_REQUEST_STATUS " +
                " WHERE hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID " +
                " AND (HR_RECRUITMENT_REQUEST_STATUS.APPROVE ='1' OR HR_RECRUITMENT_REQUEST_STATUS.REJECT ='1') ";

        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("recruit_Request_Id"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newRecruitmentResponsenotGiven() {

        String _select1 = "SELECT * FROM" +
                " hr_recruitment_request , hr_lu_job_type, HR_RECRUITMENT_REQUEST_STATUS " +
                " WHERE hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID " +
                " AND (HR_RECRUITMENT_REQUEST_STATUS.APPROVE ='0' AND HR_RECRUITMENT_REQUEST_STATUS.REJECT ='0') ";

        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("recruit_Request_Id"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionRequestes() {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, HR_ADVERTISEMENT.STATUS, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE " +
                " hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.STATUS = '" + 0 + "' ";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("ADVERT_ID"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<String> readRecruitmentRequest(String recruitmentRequestId) {

        ArrayList<String> requests = new ArrayList<String>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT hr_recruitment_request.recruit_Request_Id, " +
                    " hr_recruitment_request.recruit_Request_Ref_Date, " +
                    " hr_recruitment_request.recruit_Request_Type, " +
                    " hr_recruitment_request.department_id, " +
                    " hr_recruitment_request.num_Of_Emps, " +
                    " hr_recruitment_request.REMARK, " +
                    " hr_recruitment_request.status, " +
                    " hr_recruitment_request.requester_Id, " +
                    " hr_employee_info.first_Name, " +
                    " hr_employee_info.middle_Name, " +
                    " hr_employee_info.last_Name, " +
                    " hr_lu_job_type.job_Code, " +
                    " hr_lu_job_type.job_description, " +
                    " hr_lu_job_type.min_Required_Qualification, " +
                    " hr_lu_job_type.min_Required_Experience, " +
                    " hr_lu_job_type.min_Responsibility, " +
                    " hr_lu_job_type.additionalSkill " +
                    " FROM hr_recruitment_request, hr_lu_job_type, hr_employee_info " +
                    " WHERE  hr_recruitment_request.requester_Id = hr_employee_info.emp_Id" +
                    " AND hr_recruitment_request.job_Code= hr_lu_job_type.job_Code " +
                    " AND recruit_Request_Id= '" + recruitmentRequestId + "' ");
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                requests.add(_rs.getString("recruit_Request_Id"));
                requests.add(_rs.getString("recruit_Request_Ref_Date"));
                requests.add(_rs.getString("recruit_Request_Type"));
                requests.add(_rs.getString("num_Of_Emps"));
                requests.add(_rs.getString("requester_Id"));
                requests.add(_rs.getString("first_Name"));
                requests.add(_rs.getString("middle_Name"));
                requests.add(_rs.getString("last_Name"));
                requests.add(_rs.getString("JOB_DESCRIPTION"));
                requests.add(_rs.getString("min_Required_Qualification"));
                requests.add(_rs.getString("min_Required_Experience"));
                requests.add(_rs.getString("min_Responsibility"));
                requests.add(_rs.getString("additionalSkill"));
                requests.add(_rs.getString("JOB_CODE"));
                requests.add(_rs.getString("REMARK"));
                return requests;
            } else {
                return null;
            }

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

    public ArrayList<String> readRecruitmentRequests(String recruitmentRequestId) {
        String status = "";
        String _select = "SELECT hr_recruitment_request.recruit_Request_Id, " +
                "  hr_recruitment_request.recruit_Request_Ref_Date, " +
                "  hr_recruitment_request.recruit_Request_Type, " +
                "  hr_recruitment_request.REMARK, " +
                "  hr_recruitment_request.num_Of_Emps, " +
                "  hr_recruitment_request.job_Code AS job_Code, " +
                "  hr_recruitment_request.status, " +
                "  hr_recruitment_request.requester_Id, " +
                "  hr_employee_info.first_Name, " +
                "  hr_employee_info.middle_Name, " +
                "  hr_employee_info.last_Name, " +
                "  hr_lu_job_type.JOB_DESCRIPTION, " +
                "  hr_lu_job_type.min_Responsibility, " +
                "  hr_lu_job_type.additionalSkill, " +
                "  HR_LU_EDUC_TYPE.DESCRIPTION          AS EDUCATION_LEVEL, " +
                "  VW_JOBTYPE_EDUCLEVEL_EXPR.EXPERIENCE AS MIN_EXPERIENCE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION " +
                "FROM hr_lu_job_type, " + "  VW_JOBTYPE_EDUCTYPE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION, " + "  HR_LU_EDUC_TYPE, " +
                "  VW_JOBTYPE_EDUCLEVEL_EXPR, " + "  HR_RECRUITMENT_REQUEST_STATUS, " +
                "  HR_RECRUITMENT_REQUEST, " + "  HR_EMPLOYEE_INFO " +
                "WHERE hr_recruitment_request.requester_Id     = hr_employee_info.emp_Id " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                   = VW_JOBTYPE_EDUCTYPE.JOBTYPE_ID(+) " +
                "AND HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = VW_JOBTYPE_EDUCTYPE.EDUCTYPE_ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                   = VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE(+) " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                   = VW_JOBTYPE_EDUCLEVEL_EXPR.JOBTYPE_ID " +
                "AND hr_recruitment_request.recruit_Request_Id = '" + recruitmentRequestId + "' " +
                "AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID";





//                "SELECT hr_recruitment_request.recruit_Request_Id, " +
//                "  hr_recruitment_request.recruit_Request_Ref_Date, " +
//                "  hr_recruitment_request.recruit_Request_Type, " +
//                "  hr_recruitment_request.REMARK, " +
//                "  hr_recruitment_request.num_Of_Emps, " +
//                "  hr_recruitment_request.job_Code AS job_Code, " +
//                "  hr_recruitment_request.status, " +
//                "  hr_recruitment_request.requester_Id, " +
//                "  hr_employee_info.first_Name, " +
//                "  hr_employee_info.middle_Name, " +
//                "  hr_employee_info.last_Name, " +
//                "  hr_lu_job_type.JOB_DESCRIPTION, " +
//                "  hr_lu_job_type.job_Code, " +
//                "  hr_lu_job_type.min_Responsibility, " +
//                "  hr_lu_job_type.additionalSkill, " +
//                "  HR_LU_EDUC_TYPE.DESCRIPTION              AS EDUCATION_LEVEL, " +
//                "  HR_LU_JOBTYPE_EDUCLEVEL_EXPER.EXPERIENCE AS MIN_EXPERIENCE, " +
//                "  HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION, " +
//                "  HR_RECRUITMENT_REQUEST_STATUS.APPROVE, " +
//                "  HR_RECRUITMENT_REQUEST_STATUS.REJECT, " +
//                "  HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE, " +
//                "  HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID " +
//                "FROM hr_lu_job_type, " +
//                "  HR_LU_JOBTYPE_EDUCTYPE, " +
//                "  HR_LU_JOB_TYPE_QUALIFICATION, " +
//                "  HR_LU_PAY_GRAD, " +
//                "  HR_LU_EDUC_TYPE, " +
//                "  HR_LU_JOBTYPE_EDUCLEVEL_EXPER, " +
//                "  HR_RECRUITMENT_REQUEST_STATUS, " +
//                "  HR_RECRUITMENT_REQUEST, " +
//                "  HR_EMPLOYEE_INFO " +
//                "WHERE  hr_recruitment_request.requester_Id = hr_employee_info.emp_Id  " +
//                "AND HR_LU_JOB_TYPE.JOB_CODE                 = HR_LU_JOBTYPE_EDUCTYPE.JOBTYPE_ID(+) " +
//                "AND to_number(HR_LU_EDUC_TYPE.EDUC_TYPE_CODE) = HR_LU_JOBTYPE_EDUCTYPE.EDUCTYPE_ID " +
//                "AND HR_LU_JOB_TYPE.JOB_CODE                   = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE(+) " +
//                "AND HR_LU_PAY_GRAD.RANK_ID                    = HR_LU_JOB_TYPE.RANK_ID " +
//                "AND HR_LU_JOB_TYPE.JOB_CODE                   = HR_LU_JOBTYPE_EDUCLEVEL_EXPER.JOBTYPE_ID " +
//                "AND hr_recruitment_request.recruit_Request_Id = '" + recruitmentRequestId + "' " +
//                "AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID";




        ArrayList<String> requests = new ArrayList<String>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                requests.add(_rs.getString("recruit_Request_Id"));
                requests.add(_rs.getString("recruit_Request_Ref_Date"));
                requests.add(_rs.getString("recruit_Request_Type"));
                requests.add(_rs.getString("num_Of_Emps"));
                requests.add(_rs.getString("requester_Id"));
                requests.add(_rs.getString("first_Name"));
                requests.add(_rs.getString("middle_Name"));
                requests.add(_rs.getString("last_Name"));
                requests.add(_rs.getString("JOB_DESCRIPTION"));
                requests.add(_rs.getString("Qualification"));
                requests.add(_rs.getString("min_Experience"));
                requests.add(_rs.getString("min_Responsibility"));
                requests.add(_rs.getString("additionalSkill"));
                requests.add(_rs.getString("JOB_CODE"));
                requests.add(_rs.getString("REMARK"));
//                if (_rs.getString("APPROVE").equals("1")) {
//                    status = "APPROVED";
//                }
//                if (_rs.getString("REJECT").equals("1")) {
//                    status = "REJECTED";
//                }
                requests.add(status);
            }


            return requests;
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

    public ArrayList<RecruitmentEntity> readRecruitmentRequestByEmployeeId(String empId) {

        String _select = "SELECT hr_recruitment_request.recruit_Request_Id,hr_lu_job_type.JOB_DESCRIPTION FROM" +
                " hr_recruitment_request INNER JOIN hr_lu_job_type ON hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " where hr_recruitment_request.REQUESTER_ID ='" + empId + "'";
        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("recruit_Request_Id"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public int addRecruitment(RecruitmentEntity recruitmentEntity) {

        PreparedStatement ps1 = null;

        String approveReq = " UPDATE HR_RECRUITMENT_REQUEST SET " +
                " RECRUIT_BATCH_CODE = ?, APPROVED_BY=?, RECRUIT_APPROVED_DATE=?, " +
                " NUM_OF_EMPS_APPROVED = ?, " +
                " FORWARDED_TO_COMMITTEE = ? " +
                " WHERE RECRUIT_REQUEST_ID=?";

        String appStatus = " UPDATE HR_RECRUITMENT_REQUEST_STATUS SET " +
                " APPROVE = '" + 1 + "' " +
                " WHERE  RECRUIT_REQUEST_ID = '" + Integer.parseInt(recruitmentEntity.getEmployeeID()) + "' ";
        try {
            int saveCheck;

            _con = getConnection();
            _con.setAutoCommit(false);
            _ps = _con.prepareStatement(approveReq);
            _ps.setString(1, recruitmentEntity.getBachCode());
            _ps.setString(2, recruitmentEntity.getApprovedBy());
            _ps.setString(3, recruitmentEntity.getApproveDate());
            _ps.setInt(4, Integer.parseInt(recruitmentEntity.getNumberOfApprovedEmp()));
            _ps.setInt(5, recruitmentEntity.getCommitteeId());
            _ps.setInt(6, Integer.parseInt(recruitmentEntity.getEmployeeID()));


            if (_ps.executeUpdate() != 0) {
                ps1 = _con.prepareStatement(appStatus);
                saveCheck = ps1.executeUpdate();
                if (saveCheck == 1) {
                    _con.commit();
                    return saveCheck;

                } else {
                    return saveCheck;
                }


            } else {
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {

                ps1.close();
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int rejectRecruitment(RecruitmentEntity recruitmentEntity) {

        PreparedStatement ps1 = null;
        String approveReq = " UPDATE HR_RECRUITMENT_REQUEST SET " +
                " RECRUIT_BATCH_CODE = ?, APPROVED_BY=?, RECRUIT_APPROVED_DATE=?, " +
                " NUM_OF_EMPS_APPROVED = ? " +
                " WHERE RECRUIT_REQUEST_ID=?";

        String appStatus = " UPDATE HR_RECRUITMENT_REQUEST_STATUS SET " +
                " REJECT = '" + 1 + "' " +
                " WHERE  RECRUIT_REQUEST_ID = '" + Integer.parseInt(recruitmentEntity.getEmployeeID()) + "' ";
        try {
            int saveCheck;

            _con = getConnection();
            _con.setAutoCommit(false);
            _ps = _con.prepareStatement(approveReq);
            _ps.setString(1, recruitmentEntity.getBachCode());
            _ps.setString(2, recruitmentEntity.getApprovedBy());
            _ps.setString(3, recruitmentEntity.getApproveDate());
            _ps.setInt(4, Integer.parseInt(recruitmentEntity.getNumberOfApprovedEmp()));

            _ps.setInt(5, Integer.parseInt(recruitmentEntity.getEmployeeID()));

            if (_ps.executeUpdate() != 0) {
                ps1 = _con.prepareStatement(appStatus);
                saveCheck = ps1.executeUpdate();
                if (saveCheck == 1) {
                    _con.commit();
                    return saveCheck;

                } else {
                    return saveCheck;
                }


            } else {
                return 0;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                ps1.close();
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * The method is used to make changes in the hr_recruitment_request table based
     * on the given parameters
     * @param recruitmentRequestId the request identifier
     * @param actionTaken the specified action
     * @param batchCode the batch code
     * @return either (1) the row count for the result of update statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int updateRecruitmentRequest(String recruitmentRequestId, String Status) {

        String str = ("UPDATE hr_recruitment_request set status = ? " +
                " where recruit_Request_Id = ?");
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, Status);
            _ps.setString(2, recruitmentRequestId);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] buildRecruitmentList() {
        HashMap[] _list = null;
        int i = 0;

        String select = "  SELECT hr_recruitment.APPROVED_BY," +
                " hr_recruitment.approved_Date, " +
                " hr_recruitment.num_Of_Emps_Approved, " +
                " hr_recruitment.status, " +
                " hr_recruitment_request.recruit_Request_Id, " +
                " hr_recruitment_request.recruit_Request_Ref_Date, " +
                " hr_recruitment_request.recruit_Request_Type, " +
                " hr_recruitment_request.num_Of_Emps, " +
                " hr_recruitment_request.job_Code, " +
                " hr_recruitment_request.status, " +
                " hr_recruitment_request.recruit_Batch_Code, " +
                " hr_recruitment_request.REQUESTER_ID, " +
                " hr_lu_job_type.JOB_CODE, " +
                " hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM hr_recruitment_request INNER JOIN hr_recruitment ON hr_recruitment_request.recruit_Request_Id = hr_recruitment.recruit_Request_Id " +
                " INNER JOIN hr_lu_job_type ON hr_recruitment_request.JOB_CODE = hr_lu_job_type.JOB_CODE  " +
                " WHERE   hr_recruitment.status <> 'Advertiseannounced'";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleResultSetMetaData count = (OracleResultSetMetaData) _rs.getMetaData();
            _list = new HashMap[count.getColumnCount()];
            while (_rs.next()) {
                _list[i] = new HashMap();
                _list[i].put("recruit_Request_Id", _rs.getString("recruit_Request_Id"));
                _list[i].put("approved_Date", _rs.getString("APPROVED_DATE"));
                _list[i].put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                _list[i].put("JOB_DESCRIPTION", _rs.getString("JOB_DESCRIPTION"));

                i++;


            }
            return _list;
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

    public String readDepartment(String id) {
        String select = " select TBL_DEPT_BUNNA.DEP_DESCRIPTION from   hr_employee_info INNER JOIN TBL_DEPT_BUNNA ON TBL_DEPT_BUNNA.dept_Id=hr_employee_info.department_id where EMP_ID='" + id + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            _rs.next();
            return _rs.getString("DEP_DESCRIPTION");
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

    public int count() {
        String select = " SELECT count(hr_recruitment.APPROVED_BY) as num" +
                " FROM hr_recruitment_request INNER JOIN hr_recruitment ON hr_recruitment_request.recruit_Request_Id = hr_recruitment.recruit_Request_Id " +
                " INNER JOIN hr_lu_job_type ON hr_recruitment_request.JOB_CODE = hr_lu_job_type.JOB_CODE  " +
                "  WHERE   hr_recruitment.status <> 'Advertiseannounced'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            _rs.next();
            return _rs.getInt("num");
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<String> readListOfBachCode() {
        ArrayList<String> arrayListBatchSearchObj = new ArrayList<String>();
        String type = "Outside";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT " +
                    "            Distinct  hr_recruitment_request.recruit_batch_code ,hr_recruitment_request.RECRUIT_REQUEST_ID" +
                    "   FROM    " +
                    "           hr_recruitment_request , " +
                    "           HR_RECRUITMENT_REQUEST_STATUS," +
                    "           HR_ADVERTISEMENT " +
                    "   WHERE" +
                    "         hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID AND" +
                    "        HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=1 AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1" +
                    "        AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = hr_recruitment_request.RECRUIT_REQUEST_ID AND " +
                    "        HR_ADVERTISEMENT.ADVERTISEMENT_TYPE = '" + type + "' " +
                    "  AND hr_recruitment_request.recuritment_condition is null");
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                arrayListBatchSearchObj.add(_rs.getString("RECRUIT_BATCH_CODE") + "--" + _rs.getString("RECRUIT_REQUEST_ID"));
            }
            return arrayListBatchSearchObj;
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


    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<String> readListOfBachCodeOld() {
        ArrayList<String> arrayListBatchSearchObj = new ArrayList<String>();
        String type = "Outside";
        try {
            String query = "SELECT DISTINCT hr_recruitment_request.recruit_batch_code , " +
                    "  hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                    "  hr_recruitment_request.recuritment_condition " +
                    "FROM hr_recruitment_request, " +
                    "  HR_RECRUITMENT_REQUEST_STATUS, " +
                    "  HR_ADVERTISEMENT " +
                    "WHERE hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID " +
                    "AND HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE     =1 " +
                    "AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE       =1 " +
                    "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID         = hr_recruitment_request.RECRUIT_REQUEST_ID " +
                    "AND HR_ADVERTISEMENT.ADVERTISEMENT_TYPE         = 'Outside' " +
                    "AND hr_recruitment_request.recuritment_condition LIKE 'CLOSED'";
            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                arrayListBatchSearchObj.add(_rs.getString("RECRUIT_BATCH_CODE") + "--" + _rs.getString("RECRUIT_REQUEST_ID"));
            }
            return arrayListBatchSearchObj;
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<String> readListOfBachCodeForCnd() {
        ArrayList<String> arrayListBatchSearchObj = new ArrayList<String>();
        String type = "Outside";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT " +
                    "            Distinct  hr_recruitment_request.recruit_batch_code " +
                    "   FROM    " +
                    "           hr_recruitment_request , " +
                    "           HR_RECRUITMENT_REQUEST_STATUS," +
                    "           HR_ADVERTISEMENT " +
                    "   WHERE" +
                    "         hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID AND" +
                    "        HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=1 AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1" +
                    "        AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = hr_recruitment_request.RECRUIT_REQUEST_ID AND " +
                    "        HR_ADVERTISEMENT.ADVERTISEMENT_TYPE = '" + type + "' ");
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                arrayListBatchSearchObj.add(_rs.getString("RECRUIT_BATCH_CODE"));
            }
            return arrayListBatchSearchObj;
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

    public ArrayList<HashMap> readListOfBachCodeForEmployee() {
        String sqlStatment = "SELECT DISTINCT hr_recruitment_request.recruit_batch_code , " +
                "  hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_NAME " +
                "FROM hr_recruitment_request , " +
                "  HR_RECRUITMENT_REQUEST_STATUS, " +
                "  HR_ADVERTISEMENT, " +
                "  HR_LU_JOB_TYPE " +
                "WHERE hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID " +
                "AND HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE     =1 " +
                "AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE       =1 " +
                " AND HR_RECRUITMENT_REQUEST.RECURITMENT_CONDITION ='CLOSED' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID         = hr_recruitment_request.RECRUIT_REQUEST_ID " +
                "AND HR_ADVERTISEMENT.ADVERTISEMENT_TYPE         = 'Outside' " +
                "AND HR_RECRUITMENT_REQUEST.JOB_CODE             =HR_LU_JOB_TYPE.JOB_CODE";
        ArrayList<HashMap> arrayListBatchSearchObj = new ArrayList<HashMap>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(sqlStatment);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("RECRUIT_INFO", _rs.getString("RECRUIT_BATCH_CODE") + "--" + _rs.getString("JOB_NAME"));
                hm.put("RECRUIT_BATCH_CODE", _rs.getString("RECRUIT_BATCH_CODE"));
                arrayListBatchSearchObj.add(hm);
            }
            return arrayListBatchSearchObj;
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

    public ArrayList<String> readListOfBachCodeForflilter() {
        ArrayList<String> arrayListBatchSearchObj = new ArrayList<String>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(" SELECT " +
                    "            Distinct  hr_recruitment_request.recruit_batch_code ,hr_recruitment_request.RECRUIT_REQUEST_ID" +
                    "   FROM    " +
                    "           hr_recruitment_request , " +
                    "           HR_RECRUITMENT_REQUEST_STATUS," +
                    "           HR_ADVERTISEMENT " +
                    "   WHERE" +
                    "         hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID AND" +
                    "        HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=1 AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1" +
                    "        AND HR_RECRUITMENT_REQUEST_STATUS.FILTERCANDIDATEFOREXAM=0 " +
                    "        AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = hr_recruitment_request.RECRUIT_REQUEST_ID AND " +
                    "        HR_ADVERTISEMENT.ADVERTISEMENT_TYPE = 'Outside' ");
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                arrayListBatchSearchObj.add(_rs.getString("RECRUIT_BATCH_CODE") + "--" + _rs.getString("RECRUIT_REQUEST_ID"));
            }
            return arrayListBatchSearchObj;
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

    public ArrayList<RecruitmentEntity> newPromotionRequestesFilterByDate(String date1, String date2) {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE hr_recruitment_request.job_Code = hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_FROM = '" + date1 + "'" +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO = '" + date2 + "'" +
                " AND " +
                "  HR_ADVERTISEMENT.ADVERTISEMENT_TYPE='Inside'";
        // " HR_ADVERTISEMENT.STATUS = '" + 0 + "' ";

        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("ADVERT_ID"), ocrs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> readCandidateName(String bachCode) {
        String selectStatment = "SELECT CANDIDATE_F_NAME " +
                "  || ' ' " +
                "  || CANDIDATE_M_NAME " +
                "  ||' ' " +
                "  || CANDIDATE_L_NAME " +
                "  ||'   ' " +
                "  || CANDIDATE_ID AS CandidateFullName , " +
                "  CANDIDATE_ID " +
                "FROM HR_CANDIDATE " +
                "WHERE RECRUIT_BATCH_CODE=? " +
                "AND nvl(STATUS,0)='Employee' " +
                "AND CERTIFY             ='certify'";
        // "AND nvl(STATUS,0)             <>'Employee' " +

        ArrayList<RecruitmentEntity> candidateList = new ArrayList<RecruitmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectStatment);
            _ps.setString(1, bachCode);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(
                        _rs.getString("CANDIDATE_ID"),
                        _rs.getString("CandidateFullName"));
                candidateList.add(read);
            }
            return candidateList;
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

    public ArrayList<RecruitmentEntity> readRecruitmentRequestHistory(String date1, String date2, String requesterID) {


        String _select = "SELECT hr_recruitment_request.recruit_Request_Id," +
                " hr_lu_job_type.JOB_NAME " +
                " FROM " +
                " hr_recruitment_request INNER JOIN hr_lu_job_type ON hr_recruitment_request.job_Code = hr_lu_job_type.job_Code" +
                " WHERE  " +
                " RECRUIT_REQUEST_REF_DATE < = '" + date2 + "' " +
                " AND RECRUIT_REQUEST_REF_DATE >= '" + date1 + "' " +
                " AND hr_recruitment_request.REQUESTER_ID = '" + requesterID + "'";

        ArrayList<RecruitmentEntity> recruitRequeHist = new ArrayList<RecruitmentEntity>();

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("recruit_Request_Id"), ocrs.getString("JOB_NAME"));
                recruitRequeHist.add(read);
            }
            return recruitRequeHist;

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap[] readCandidateList(String requestID) {
        HashMap[] list = null;
        int i = 0;
        String _select = "SELECT DISTINCT CC.CANDIDATE_ID, " +
                "  NVL(CA.WRITTENPERCENTAGE,'0') AS WRITTENPERCENTAGE, " +
                "  NVL(CA.INTERVIEWRESULT,'0')   AS INTERVIEWRESULT, " +
                "  NVL(CA.PRACTICALRESULT,'0')   AS PRACTICALRESULT, " +
                "  CC.CANDIDATE_F_NAME, " +
                "  CC.CANDIDATE_M_NAME, " +
                "  CC.CANDIDATE_L_NAME, " +
                "  CC.GENDER,CC.RECRUIT_BATCH_CODE, " +
                "  WRITTENPERCENTAGE + INTERVIEWRESULT + PRACTICALRESULT AS TOTAL " +
                "  FROM HR_EXAM_PERCENTAGE CA, " +
                "  HR_CANDIDATE CC " +
                "  WHERE CA.BATCHCODE=CC.CANDIDATE_ID " +
                "   AND CC.RECRUIT_BATCH_CODE='" + requestID + "' order by TOTAL desc ";
        try {


            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("CANDIDATE_ID", ocrs.getString("CANDIDATE_ID"));
                list[i].put("WRITTENPERCENTAGE", ocrs.getString("WRITTENPERCENTAGE"));
                list[i].put("INTERVIEWRESULT", ocrs.getString("INTERVIEWRESULT"));
                list[i].put("PRACTICALRESULT", ocrs.getString("PRACTICALRESULT"));
                list[i].put("CANDIDATE_FULL_NAME", ocrs.getString("CANDIDATE_F_NAME") + " " + ocrs.getString("CANDIDATE_M_NAME") + " " + ocrs.getString("CANDIDATE_L_NAME"));
                list[i].put("GENDER", ocrs.getString("GENDER"));
                list[i].put("TOTAL", ocrs.getString("TOTAL"));
                list[i].put("RECRUIT_BATCH_CODE", ocrs.getString("RECRUIT_BATCH_CODE"));
                i++;
            }
            return list;

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }

    }
     public ResultSet readSingleRecRequestNew(String requestID)
     {
          String _select = " SELECT  vedexpr.experience AS MIN_EXPERIENCE, " +
                "  vedexpr.educ_name, " +
                "  lujb.job_name, " +
                "  trim(lujb.job_code) as job_code, " +
                "  lujb.min_responsibility, " +
                "  lujb.additionalskill, " +
                "  qual.qualification, " +
                "  edl.education_level_id as EDUCATION_LEVEL, " +
                "  qual.category, " +
                "  plg.rank_id, " +
                "  reqr.RECRUIT_REQUEST_ID, " +
                "  reqr.JOB_CODE, " +
                "  reqr.RECRUIT_REQUEST_TYPE, " +
                "  reqr.NUM_OF_EMPS, " +
                "  reqr.REMARK, " +
                "  reqr.REQUESTER_ID, " +
                "  reqr.RECRUIT_REQUEST_REF_DATE, " +
                "  reqr.DEPARTMENT_ID, " +
                "  reqsta.APPROVE, " +
                "  reqsta.REJECT, " +
                "  reqsta.advertise, " +
                "  reqsta.recruit_request_id, " +
                "  plg.SALARY " +
                " FROM hr_recruitment_request reqr " +
                " INNER JOIN vw_lu_job_type_educ_level edl " +
                " ON edl.job_code=reqr.job_code " +
                " INNER JOIN vw_jobtype_educlevel_expr vedexpr " +
                " ON vedexpr.jobtype_id=reqr.job_code " +
                " INNER JOIN hr_recruitment_request_status reqsta " +
                " ON reqr.recruit_request_id=reqsta.recruit_request_id " +
                " INNER JOIN hr_lu_job_type lujb " +
                " ON lujb.job_code=reqr.job_code " +
                " INNER JOIN HR_LU_PAY_GRAD plg " +
                " ON plg.rank_id=lujb.rank_id " +
                " INNER JOIN vw_lu_job_type_qualification qual " +
                " ON qual.job_code=lujb.job_code " +
                " WHERE reqr.recruit_request_id='" + requestID + "' " +
                " AND reqsta.RECRUIT_REQUEST_ID='" + requestID + "' " +
                " AND plg.step_no= '0'";
           try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            System.out.println(_select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }
}

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public HashMap[] readSingleRecRequest(String requestID) {


        HashMap[] list = null;
        int i = 0;
        String _select = " SELECT vedexpr.experience AS MIN_EXPERIENCE, " +
                "  vedexpr.educ_name, " +
                "  lujb.job_name, " +
                "  lujb.job_code, " +
                "  lujb.min_responsibility, " +
                "  lujb.additionalskill, " +
                "  qual.qualification, " +
                "  edl.education_level_id as EDUCATION_LEVEL, " +
                "  qual.category, " +
                "  plg.rank_id, " +
                "  reqr.RECRUIT_REQUEST_ID, " +
                "  reqr.JOB_CODE, " +
                "  reqr.RECRUIT_REQUEST_TYPE, " +
                "  reqr.NUM_OF_EMPS, " +
                "  reqr.REMARK, " +
                "  reqr.REQUESTER_ID, " +
                "  reqr.RECRUIT_REQUEST_REF_DATE, " +
                "  reqr.DEPARTMENT_ID, " +
                "  reqsta.APPROVE, " +
                "  reqsta.REJECT, " +
                "  reqsta.advertise, " +
                "  reqsta.recruit_request_id, " +
                "  plg.SALARY " +
                " FROM hr_recruitment_request reqr " +
                " INNER JOIN vw_lu_job_type_educ_level edl " +
                " ON edl.job_code=reqr.job_code " +
                " INNER JOIN vw_jobtype_educlevel_expr vedexpr " +
                " ON vedexpr.jobtype_id=reqr.job_code " +
                " INNER JOIN hr_recruitment_request_status reqsta " +
                " ON reqr.recruit_request_id=reqsta.recruit_request_id " +
                " INNER JOIN hr_lu_job_type lujb " +
                " ON lujb.job_code=reqr.job_code " +
                " INNER JOIN HR_LU_PAY_GRAD plg " +
                " ON plg.rank_id=lujb.rank_id " +
                " INNER JOIN vw_lu_job_type_qualification qual " +
                " ON qual.job_code=lujb.job_code " +
                " WHERE reqr.recruit_request_id='" + requestID + "' " +
                " AND reqsta.RECRUIT_REQUEST_ID='" + requestID + "' " +
                " AND plg.step_no= '0'";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
          //  _rs.close();
            list = new HashMap[ocrs.size()];
            while (ocrs.next())
            {
                list[i] = new HashMap();
                list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                list[i].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                list[i].put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                list[i].put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                list[i].put("REMARK", ocrs.getString("REMARK"));
                list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                list[i].put("SALARY", ocrs.getString("SALARY"));
                list[i].put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                list[i].put("RECRUIT_REQUEST_REF_DATE", ocrs.getString("RECRUIT_REQUEST_REF_DATE"));
                list[i].put("APPROVE", ocrs.getString("APPROVE"));
                list[i].put("REJECT", ocrs.getString("REJECT"));
                list[i].put("ADVERTISE", ocrs.getString("ADVERTISE"));
                list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                i++;
            }
            return list;

        } catch (Exception ex) {

            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }

    }

    public HashMap[] readRecRequestForAdvert(String requestID, String batchCode, String jobCode) {

        HashMap[] list = null;
        int i = 0;

        String str = "SELECT hr_lu_job_type.JOB_CODE as JOB_CODE , hr_lu_job_type.JOB_DESCRIPTION, hr_lu_job_type.MIN_REQUIRED_QUALIFICATION," +
                " hr_lu_job_type.MIN_REQUIRED_EXPERIENCE, hr_lu_job_type.MIN_RESPONSIBILITY, HR_RECRUITMENT_REQUEST.JOB_CODE, " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                " HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED " +
                " FROM  " +
                " hr_lu_job_type, HR_RECRUITMENT_REQUEST " +
                " WHERE " +
                " hr_lu_job_type.JOB_CODE = '" + jobCode + "'" +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_RECRUITMENT_REQUEST.JOB_CODE " +
                " AND " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID = '" + requestID + "' ";
        try {


            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];

            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                list[i].put("MIN_REQUIRED_QUALIFICATION", ocrs.getString("MIN_REQUIRED_QUALIFICATION"));
                list[i].put("MIN_REQUIRED_EXPERIENCE", ocrs.getString("MIN_REQUIRED_EXPERIENCE"));
                list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                list[i].put("JOB_CODE", ocrs.getString("RECRUIT_REQUEST_ID"));


                i++;
            }
            return list;
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

    public HashMap[] readRecRequestForAdvert(String batchCode) {

        HashMap[] list = null;
        int i = 0;

        String str = "SELECT hr_lu_job_type.JOB_CODE as JOB_CODE , hr_lu_job_type.JOB_DESCRIPTION, " +
                " hr_lu_job_type.MIN_RESPONSIBILITY, HR_RECRUITMENT_REQUEST.JOB_CODE, " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID, HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                " HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED, HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID," +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE, HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE,HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION," +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " FROM  " +
                " hr_lu_job_type, HR_RECRUITMENT_REQUEST, HR_RECRUITMENT_REQUEST_STATUS, HR_LU_JOB_TYPE_EDUC_LEVEL, HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE " +
                " (HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE = '" + batchCode + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_RECRUITMENT_REQUEST.JOB_CODE " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE " +
                " AND" +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE = '" + 1 + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE = '" + 0 + "' )" +
                " ORDER BY JOB_DESCRIPTION ASC , qualification ASC ";
        try {


            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];

            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));


                i++;
            }
            return list;
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

    public HashMap[] readRecRequestForAdvertPreviouslyAdvert(String batchCode) {

        HashMap[] list = null;
        int i = 0;

        String str = "SELECT hr_lu_job_type.JOB_CODE as JOB_CODE , hr_lu_job_type.JOB_DESCRIPTION, " +
                " hr_lu_job_type.MIN_RESPONSIBILITY, HR_RECRUITMENT_REQUEST.JOB_CODE, " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID, HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                " HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED, HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID," +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE, HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE, " +
                " HR_ADVERTISEMENT.ADVERT_ID AS ADVERT_ID, HR_ADVERTISEMENT.PREPARED_DATE, HR_ADVERTISEMENT.ADVERT_DATE_FROM," +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO, HR_ADVERTISEMENT.RECRUIT_BATCH_CODE, HR_ADVERTISEMENT.PREPAREDBY," +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION," +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " FROM  " +
                " hr_lu_job_type, HR_RECRUITMENT_REQUEST, HR_RECRUITMENT_REQUEST_STATUS, HR_ADVERTISEMENT," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL, HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE = '" + batchCode + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_RECRUITMENT_REQUEST.JOB_CODE " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE " +
                " AND" +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE = '" + 1 + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE = '" + 1 + "' " +
                " AND " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                " ORDER BY JOB_DESCRIPTION ASC , qualification ASC ";

        try {


            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];

            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                list[i].put("PREPARED_DATE", ocrs.getString("PREPARED_DATE"));
                list[i].put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                list[i].put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                list[i].put("RECRUIT_BATCH_CODE", ocrs.getString("RECRUIT_BATCH_CODE"));
                list[i].put("PREPAREDBY", ocrs.getString("PREPAREDBY"));
                list[i].put("ADVERTISEMENT_TYPE", ocrs.getString("ADVERTISEMENT_TYPE"));



                i++;
            }
            return list;
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

    public ArrayList<RecruitmentEntity> newPromotionRequestApproveFilterByDate(String date1, String date2) {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE hr_recruitment_request.job_Code = hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_FROM = '" + date1 + "'" +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO = '" + date2 + "'" +
                " AND " +
                // " HR_ADVERTISEMENT.STATUS = '" + 1 + "'";
                "HR_ADVERTISEMENT.ADVERTISEMENT_TYPE = 'Inside'";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("ADVERT_ID"), ocrs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionResponseAproveFilterByDate(String date1, String date2) {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, hr_lu_job_type.JOB_NAME " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE hr_recruitment_request.job_Code = hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_FROM = '" + date1 + "'" +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO = '" + date2 + "'" +
                " AND " +
                // " HR_ADVERTISEMENT.STATUS = '" + 2 + "' ";
                "HR_ADVERTISEMENT.ADVERTISEMENT_TYPE = 'Inside'";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("ADVERT_ID"), ocrs.getString("JOB_NAME"));
                requests.add(read);
            }

            return requests;
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

    public HashMap[] readNoResponseGivenAdvert(String batchCode) {

        HashMap[] list = null;
        int i = 0;

        String str = "SELECT hr_lu_job_type.JOB_CODE as JOB_CODE , hr_lu_job_type.JOB_DESCRIPTION, " +
                " hr_lu_job_type.MIN_RESPONSIBILITY, HR_RECRUITMENT_REQUEST.JOB_CODE, " +
                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID, HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                " HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED, HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID," +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE, HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE,HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE," +
                " HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION," +
                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " FROM  " +
                " hr_lu_job_type, HR_RECRUITMENT_REQUEST, HR_RECRUITMENT_REQUEST_STATUS, HR_LU_JOB_TYPE_EDUC_LEVEL, HR_LU_JOB_TYPE_QUALIFICATION " +
                " WHERE " +
                " (HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE = '" + batchCode + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_RECRUITMENT_REQUEST.JOB_CODE " +
                " AND " +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE " +
                " AND" +
                " hr_lu_job_type.JOB_CODE = HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.APPROVE = '" + 1 + "' " +
                " AND " +
                " HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE = '" + 1 + "' )" +
                " ORDER BY JOB_DESCRIPTION ASC , qualification ASC ";
        try {


            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            list = new HashMap[ocrs.size()];

            while (ocrs.next()) {
                list[i] = new HashMap();
                list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                list[i].put("MIN_RESPONSIBILITY", ocrs.getString("MIN_RESPONSIBILITY"));
                list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));


                i++;
            }
            return list;
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

    public ArrayList<RecruitmentEntity> noneResponsedVacancies() {
        String currentDate = dateFormat.format(new Date());
        //String currentDate = StringDateManipulation.toDayInEc();

        String _select1 = "SELECT DISTINCT " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO, HR_ADVERTISEMENT.RECRUIT_BATCH_CODE," +
                " HR_PROMOTION_REQUEST.ADVERT_ID " +
                " FROM " +
                " HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE " +
                " ADVERTISEMENT_TYPE = '" + "Inside" + "'" +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_ID != HR_PROMOTION_REQUEST.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO < '" + currentDate + "'";



        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();
        PreparedStatement _ps = null;
        Connection _con = null;
        ResultSet _rs;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("ADVERT_ID") + "----" + ocrs.getString("RECRUIT_BATCH_CODE"), ocrs.getString("RECRUIT_BATCH_CODE"));
                requests.add(read);
            }

            return requests;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int readCommitteeId(int recruitmentRequestId) {
        int committee = -1;
        ArrayList<RecruitmentEntity> candidateList = new ArrayList<RecruitmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT FORWARDED_TO_COMMITTEE from HR_RECRUITMENT_REQUEST where RECRUIT_REQUEST_ID='" + recruitmentRequestId + "'");
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                committee = _rs.getInt("FORWARDED_TO_COMMITTEE");
            }
            return committee;
        } catch (SQLException ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return committee;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int promotionCommitteeId(String recruitmentRequestId) {
        int committee = -1;
        ArrayList<RecruitmentEntity> candidateList = new ArrayList<RecruitmentEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT distinct FORWARDED_TO_COMMITTEE from HR_PROMOTION_REQUEST where ADVERT_ID='" + recruitmentRequestId + "'");
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                committee = _rs.getInt("FORWARDED_TO_COMMITTEE");
            }
            return committee;
        } catch (SQLException ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return committee;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<RecruitmentEntity> newPromotionResponseFilterByDate(String date1, String date2) {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE hr_recruitment_request.job_Code = hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_FROM = '" + date1 + "'" +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO = '" + date2 + "'" +
                " AND " +
                " (HR_ADVERTISEMENT.STATUS = '" + 1 + "' OR  HR_ADVERTISEMENT.STATUS = '" + 2 + "')";

        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(ocrs.getString("ADVERT_ID"), ocrs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionResponse() {

        String _select1 = " SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, HR_ADVERTISEMENT.STATUS, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE " +
                " hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " (HR_ADVERTISEMENT.STATUS = '" + 1 + "' OR HR_ADVERTISEMENT.STATUS = '" + 2 + "') ";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("ADVERT_ID"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionRequestesDates() {

        String _select1 = " SELECT AD.RECRUIT_REQUEST_ID, " +
                "  AD.ADVERT_ID, " +
                "  AD.ADVERT_DATE_FROM, " +
                "  AD.ADVERT_DATE_TO, " +
                "  RQ.RECRUIT_BATCH_CODE " +
                " FROM HR_ADVERTISEMENT AD, " +
                "  HR_RECRUITMENT_REQUEST RQ " +
                " WHERE ADVERTISEMENT_TYPE = 'Inside' " +
                " AND AD.RECRUIT_REQUEST_ID=RQ.RECRUIT_REQUEST_ID";



        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(
                        ocrs.getString("ADVERT_ID") + "----" +
                        ocrs.getString("ADVERT_DATE_FROM") + " ---- " +
                        ocrs.getString("ADVERT_DATE_TO") + " ---- " +
                        ocrs.getString("RECRUIT_BATCH_CODE"),
                        ocrs.getString("ADVERT_DATE_FROM") + " ---- " +
                        ocrs.getString("ADVERT_DATE_TO"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionRequestApprove() {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, HR_ADVERTISEMENT.STATUS, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE " +
                " hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.STATUS = '" + 1 + "'";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("ADVERT_ID"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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

    public ArrayList<RecruitmentEntity> newPromotionResponseApprove() {

        String _select1 = "SELECT DISTINCT " +
                " hr_recruitment_request.job_Code, hr_lu_job_type.job_Code," +
                " hr_recruitment_request.RECRUIT_REQUEST_ID, " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_PROMOTION_REQUEST.ADVERT_ID," +
                " HR_ADVERTISEMENT.ADVERT_ID, HR_ADVERTISEMENT.STATUS, hr_lu_job_type.JOB_DESCRIPTION " +
                " FROM " +
                " hr_recruitment_request , hr_lu_job_type, HR_ADVERTISEMENT, HR_PROMOTION_REQUEST " +
                " WHERE " +
                " hr_recruitment_request.job_Code= hr_lu_job_type.job_Code" +
                " AND " +
                " hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                " AND " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = HR_ADVERTISEMENT.ADVERT_ID " +
                " AND " +
                " HR_ADVERTISEMENT.STATUS = '" + 2 + "' ";


        ArrayList<RecruitmentEntity> requests = new ArrayList<RecruitmentEntity>();

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select1);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                RecruitmentEntity read = new RecruitmentEntity(_rs.getString("ADVERT_ID"), _rs.getString("JOB_DESCRIPTION"));
                requests.add(read);
            }

            return requests;
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
