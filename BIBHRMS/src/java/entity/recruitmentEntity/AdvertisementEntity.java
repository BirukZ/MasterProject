/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.SQLException;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Savepoint;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class AdvertisementEntity extends ConnectionManager {

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
    String advertisementDateFrom;
    String preparedDate;
    String advrtId;
    String occurrence;
    public static int countRequest;
    String mediaTypes;
    String advertisementDateTo;
    String preparedBy;
    String status;
    String recruitmentBatchCode;
    String descrption;
    private String recRequestID;
    private String empID;
    private float interviewResult;
    private float writtenResult;
    private float presentationResult;
    private float other;
    private float interviewPercentage;
    private float writtenPercentage;
    private float presentationPercentage;
    private float otherPercentage;
    private String promotionRequestId;
    private float employeeDisciplineResult;
    private float performanceValue;
    private float examPercentage;
    private float totalResult;
    private float disciplinePercentage;
    private float promotionPercentage;

    public float getPromotionPercentage() {
        return promotionPercentage;
    }

    public void setPromotionPercentage(float promotionPercentage) {
        this.promotionPercentage = promotionPercentage;
    }

    public float getDisciplinePercentage() {
        return disciplinePercentage;
    }

    public void setDisciplinePercentage(float disciplinePercentage) {
        this.disciplinePercentage = disciplinePercentage;
    }

    public float getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(float totalResult) {
        this.totalResult = totalResult;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public float getEmployeeDisciplineResult() {
        return employeeDisciplineResult;
    }

    public void setEmployeeDisciplineResult(float employeeDisciplineResult) {
        this.employeeDisciplineResult = employeeDisciplineResult;
    }

    public float getExamPercentage() {
        return examPercentage;
    }

    public void setExamPercentage(float examPercentage) {
        this.examPercentage = examPercentage;
    }

    public float getInterviewPercentage() {
        return interviewPercentage;
    }

    public void setInterviewPercentage(float interviewPercentage) {
        this.interviewPercentage = interviewPercentage;
    }

    public float getInterviewResult() {
        return interviewResult;
    }

    public void setInterviewResult(float interviewResult) {
        this.interviewResult = interviewResult;
    }

    public float getOther() {
        return other;
    }

    public void setOther(float other) {
        this.other = other;
    }

    public float getOtherPercentage() {
        return otherPercentage;
    }

    public void setOtherPercentage(float otherPercentage) {
        this.otherPercentage = otherPercentage;
    }

    public float getPerformanceValue() {
        return performanceValue;
    }

    public void setPerformanceValue(float performanceValue) {
        this.performanceValue = performanceValue;
    }

    public float getPresentationPercentage() {
        return presentationPercentage;
    }

    public void setPresentationPercentage(float presentationPercentage) {
        this.presentationPercentage = presentationPercentage;
    }

    public float getPresentationResult() {
        return presentationResult;
    }

    public void setPresentationResult(float presentationResult) {
        this.presentationResult = presentationResult;
    }

    public String getPromotionRequestId() {
        return promotionRequestId;
    }

    public void setPromotionRequestId(String promotionRequestId) {
        this.promotionRequestId = promotionRequestId;
    }

    public float getWrittenPercentage() {
        return writtenPercentage;
    }

    public void setWrittenPercentage(float writtenPercentage) {
        this.writtenPercentage = writtenPercentage;
    }

    public float getWrittenResult() {
        return writtenResult;
    }

    public void setWrittenResult(float writtenResult) {
        this.writtenResult = writtenResult;
    }

    public String getRecRequestID() {
        return recRequestID;
    }

    public void setRecRequestID(String recRequestID) {
        this.recRequestID = recRequestID;
    }

    public static int getCountRequest() {
        return countRequest;
    }

    public static void setCountRequest(int countRequest) {
        AdvertisementEntity.countRequest = countRequest;
    }

    public String getMediaTypes() {
        return mediaTypes;
    }

    public void setMediaTypes(String mediaTypes) {
        this.mediaTypes = mediaTypes;
    }

    public String getOccurrence() {
        return occurrence;
    }

    public void setOccurrence(String occurrence) {
        this.occurrence = occurrence;
    }

    public AdvertisementEntity(String occurrence, String mediaTypes, String adver) {
        this.occurrence = occurrence;
        this.mediaTypes = mediaTypes;
        this.advrtId = adver;
    }

    public AdvertisementEntity(String occurrence, String mediaTypes) {
        this.occurrence = occurrence;
        this.mediaTypes = mediaTypes;
    }

    public String getAdvrtId() {
        return advrtId;
    }

    public void setAdvrtId(String advrtId) {
        this.advrtId = advrtId;
    }

    public AdvertisementEntity(
            String empID,
            String promotionRequestId,
            String advrtId,
            float examPercentage,
            float disciplinePercentage,
            float promotionPercentage) {
        this.empID = empID;
        this.promotionRequestId = promotionRequestId;
        this.advrtId = advrtId;
        this.examPercentage = examPercentage;
        this.disciplinePercentage = disciplinePercentage;
        this.promotionPercentage = promotionPercentage;
    }

    public AdvertisementEntity(
            String empID,
            String promotionRequestId,
            float interviewResult,
            float writtenResult,
            float presentationResult,
            float other,
            float employeeDisciplineResult,
            float performanceValue,
            float examPercentage,
            float totalResult) {
        this.empID = empID;
        this.interviewResult = interviewResult;
        this.writtenResult = writtenResult;
        this.presentationResult = presentationResult;
        this.other = other;
        this.totalResult = interviewPercentage;
        this.totalResult = totalResult;
        this.promotionRequestId = promotionRequestId;
        this.employeeDisciplineResult = employeeDisciplineResult;
        this.performanceValue = performanceValue;
        this.examPercentage = examPercentage;
    }

    public AdvertisementEntity(
            String advertisementDateFrom,
            String preparedDate,
            String advertisementDateTo,
            String preparedBy,
            String status,
            String recruitmentBatchCode) {
        this.advertisementDateFrom = advertisementDateFrom;
        this.preparedDate = preparedDate;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.status = status;
        this.recruitmentBatchCode = recruitmentBatchCode;
    }

    public boolean insertMediyaInfo(ArrayList<HashMap> mediInformantion, String advertisementID) {

        String insertMediInformantion = " INSERT INTO hr_lu_media(" +
                " advert_Id," +
                " media_Type_Code," +
                " occurrence)" +
                "  VALUES(?,?,?)";
        Connection _con = null;
        PreparedStatement ps = null;
        boolean checkSave = true;
        try {

            _con = getConnection();


            if (mediInformantion.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                for (HashMap hm : mediInformantion) {//loop over the attached file
//                    insertMediInformantion = " INSERT INTO hr_media(" +
//                " advert_Id," +
//                " media_Type_Code," +
//                " occurrence)" +
//                "  VALUES("+advertisementID+","+ hm.get("mediaType").toString()+","+hm.get("occurrence").toString()+")";
                    ps = _con.prepareStatement(insertMediInformantion);
                    ps.setString(1, advertisementID);
                    ps.setString(2, hm.get("mediaType").toString());
                    ps.setString(3, hm.get("occurrence").toString());

                    if (ps.executeUpdate() != 1) {
                        checkSave = false;
                        break;
                    }
                }

                return checkSave;


            }
//            ps.executeUpdate();
////            if (ps.executeUpdate() == 1) {
////                if (_ps.executeUpdate() == 1) {
////                    _con.releaseSavepoint(a);
////                    _ps.close();
////                    ps.close();
////                    return 1;
////                } else {
////                    _con.rollback(a);
////                    _con.releaseSavepoint(a);
////                }
////
////            } else {
////                _con.rollback(a);
////                _con.releaseSavepoint(a);
////            }
//
//            String select = "select MAX(advert_Id)as max from  hr_advertisement ";
//            ps = _con.prepareStatement(select);
//            ResultSet rsAdvertId = ps.executeQuery();
//            if (rsAdvertId.next()) {
//                setAdvrtId(rsAdvertId.getString("max"));
//                _con.commit();
//                return 1;
//            }
            return false;
//
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public int updateAdvertisementInfo(HashMap advertismentInf) {
        String update = "UPDATE hr_advertisement set " +
                "advert_Date_From=?,advert_Date_To=? " +
                " WHERE recruit_batch_code=?";
        Connection _con = null;
        PreparedStatement ps = null;
        try {
            _con = getConnection();
            ps = _con.prepareStatement(update);
            ps.setString(1, advertismentInf.get("advertDateFrom").toString());
            ps.setString(2, advertismentInf.get("advertDateTO").toString());
            ps.setString(3, advertismentInf.get("batchCode").toString());
            return ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }


    }

    public AdvertisementEntity(
            String advertisementDateFrom,
            String preparedDate,
            String advertisementDateTo,
            String preparedBy,
            String recruitmentBatchCode,
            String occurrence,
            String mediaTypes,
            String requestID) {
        this.advertisementDateFrom = advertisementDateFrom;
        this.preparedDate = preparedDate;
        this.advertisementDateTo = advertisementDateTo;
        this.preparedBy = preparedBy;
        this.recruitmentBatchCode = recruitmentBatchCode;
        this.occurrence = occurrence;
        this.mediaTypes = mediaTypes;
        this.recRequestID = requestID;
    }

    public String getAdvertisementDateFrom() {
        return advertisementDateFrom;
    }

    public void setAdvertisementDateFrom(String advertisementDateFrom) {
        this.advertisementDateFrom = advertisementDateFrom;
    }

    public String getAdvertisementDateTo() {
        return advertisementDateTo;
    }

    public void setAdvertisementDateTo(String advertisementDateTo) {
        this.advertisementDateTo = advertisementDateTo;
    }

    public String getPreparedBy() {
        return preparedBy;
    }

    public void setPreparedBy(String preparedBy) {
        this.preparedBy = preparedBy;
    }

    public String getPreparedDate() {
        return preparedDate;
    }

    public void setPreparedDate(String preparedDate) {
        this.preparedDate = preparedDate;
    }

    public String getRecruitmentBatchCode() {
        return recruitmentBatchCode;
    }

    public void setRecruitmentBatchCode(String recruitmentBatchCode) {
        this.recruitmentBatchCode = recruitmentBatchCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDescrption() {
        return descrption;
    }

    public void setDescrption(String descrption) {
        this.descrption = descrption;
    }

    public AdvertisementEntity(String descrption, int mediaType) {
        this.descrption = descrption;
        this.mediaType = mediaType;
    }
    int mediaType;

    public int getMediaType() {
        return mediaType;
    }

    public void setMediaType(int mediaType) {
        this.mediaType = mediaType;
    }

    public AdvertisementEntity() {
    }

    public ArrayList<AdvertisementEntity> readMeadiaType() {
        //to populate drop down List 'media type'


        Connection _con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String str = "SELECT * FROM hr_lu_media_type";
        ArrayList<AdvertisementEntity> mediaTypeArrayListObj = new ArrayList<AdvertisementEntity>();

        try {
            _con = getConnection();
            ps = (PreparedStatement) _con.prepareStatement(str);
            rs = (ResultSet) ps.executeQuery();

            while (rs.next()) {
                this.descrption = rs.getString("description");
                this.mediaType = rs.getInt("media_Type_Code");
                AdvertisementEntity mediaTypeObject = new AdvertisementEntity(descrption, mediaType);
                mediaTypeArrayListObj.add(mediaTypeObject);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

        return mediaTypeArrayListObj;

    }

    public ArrayList<String> reedRecruitment(String batchCode) {

        Connection _con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT   hr_recruitment.approved_By," +
                "hr_recruitment.approved_Date," +
                "hr_recruitment.num_Of_Emps_Approved," +
                "hr_recruitment.status," +
                "hr_recruitment_request.recruit_Request_Id," +
                "hr_recruitment_request.REQUESTER_ID," +
                "hr_recruitment_request.recruit_Request_Ref_Date," +
                "hr_recruitment_request.recruit_Request_Type," +
                "hr_recruitment_request.num_Of_Emps," +
                "hr_recruitment_request.job_Code," +
                "hr_recruitment_request.status," +
                "hr_recruitment.recruit_Batch_Code," +
                "hr_lu_job_type.JOB_DESCRIPTION  " +
                " FROM hr_recruitment " +
                "  INNER JOIN hr_recruitment_request ON hr_recruitment_request.RECRUIT_REQUEST_ID = hr_recruitment.RECRUIT_REQUEST_ID  " +
                " INNER JOIN hr_lu_job_type ON hr_recruitment_request.job_Code = hr_lu_job_type.job_Code  " +
                "WHERE  hr_recruitment_request.recruit_Request_Id = ?";
        ArrayList<String> recruitment = new ArrayList<String>();

        try {

            _con = getConnection();
            ps = _con.prepareStatement(select);
            ps.setString(1, batchCode);
            rs = ps.executeQuery();

            if (rs.next()) {
                recruitment.add(rs.getString("recruit_Batch_Code"));
                recruitment.add(rs.getString("JOB_DESCRIPTION"));
                recruitment.add(rs.getString("recruit_Request_Ref_Date"));
                recruitment.add(rs.getString("recruit_Request_Type"));
                recruitment.add(rs.getString("num_Of_Emps"));
                recruitment.add(rs.getString("approved_Date"));
                recruitment.add(rs.getString("REQUESTER_ID"));
                recruitment.add(rs.getString("APPROVED_BY"));
                return recruitment;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return null;



    }

    public ArrayList<String> readRequesterName(String empId) {

        Connection _con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT ALL hr_employee_info .FIRST_NAME," +
                "hr_employee_info.MIDDLE_NAME," +
                "hr_employee_info.LAST_NAME," +
                "TBL_DEPT_BUNNA.DEP_DESCRIPTION " +
                " FROM hr_employee_info  " +
                "  INNER JOIN TBL_DEPT_BUNNA ON TBL_DEPT_BUNNA.DEPT_ID = hr_employee_info.DEPARTMENT_ID  " +
                "WHERE  hr_employee_info.EMP_ID = ?";
        ArrayList<String> recruitment = new ArrayList<String>();

        try {
            _con = getConnection();
            ps = _con.prepareStatement(select);
            ps.setString(1, empId);
            rs = ps.executeQuery();

            while (rs.next()) {
                recruitment.add(rs.getString("FIRST_NAME"));
                recruitment.add(rs.getString("MIDDLE_NAME"));
                recruitment.add(rs.getString("LAST_NAME"));
                recruitment.add(rs.getString("DEP_DESCRIPTION"));
            }
            return recruitment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }



    }

    public ArrayList<String> readAdvertisementInfo(String name) {


        Connection _con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT * FROM hr_advertisement " +
                "WHERE recruit_batch_code=?";
        ArrayList<String> recruitment = new ArrayList<String>();
        try {
            _con = getConnection();
            ps = (PreparedStatement) _con.prepareStatement(select);
            ps.setString(1, name);
            rs = (ResultSet) ps.executeQuery();

            if (rs.next()) {
                recruitment.add(rs.getString("advert_id"));
                recruitment.add(rs.getString("prepared_date"));
                recruitment.add(rs.getString("advert_date_from"));
                recruitment.add(rs.getString("advert_date_to"));
                recruitment.add(rs.getString("status"));
                recruitment.add(rs.getString("preparedby"));
            }
            if (recruitment == null) {
                return null;
            } else {
                return recruitment;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }



    }

    public ArrayList<String> readApprovedByName(String name) {

        Connection _con = null;

        PreparedStatement ps = null;
        ResultSet rs = null;
        String select = "SELECT ALL hr_employee_info .FIRST_NAME," +
                "hr_employee_info.MIDDLE_NAME," +
                "hr_employee_info.LAST_NAME" +
                " FROM hr_employee_info  " +
                "WHERE  hr_employee_info.EMP_ID = ?";
        ArrayList<String> recruitment = new ArrayList<String>();

        try {
            _con = getConnection();
            ps = (PreparedStatement) _con.prepareStatement(select);
            ps.setString(1, name);
            rs = (ResultSet) ps.executeQuery();

            while (rs.next()) {
                recruitment.add(rs.getString("FIRST_NAME"));
                recruitment.add(rs.getString("MIDDLE_NAME"));
                recruitment.add(rs.getString("LAST_NAME"));
            }
            return recruitment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }



    }

    public int updateMediaType(AdvertisementEntity updateMedia) {
        //accepts values from 'Advertisement List Table' in the interface
        //and inserts them into the database

        Connection _con = null;
        PreparedStatement _ps = null;
        String update = "UPDATE hr_lu_media SET media_Type_Code=" + updateMedia.getMediaTypes() + " ,occurrence=" + updateMedia.getOccurrence() + " WHERE MEDIID=" + updateMedia.getAdvrtId() + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(update);
            return _ps.executeUpdate();

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return 0;
        }
    }

    public ArrayList<AdvertisementEntity> readRecruitmentBatchCodeSearch() {
        String select = "select hr_recruitment.recruit_batch_code,hr_lu_job_type.job_description from " +
                "hr_lu_job_type INNER JOIN(hr_recruitment_request INNER JOIN hr_recruitment ON " +
                "hr_recruitment_request.recruit_request_id=hr_recruitment.recruit_request_id) " +
                "ON hr_lu_job_type.job_code=hr_recruitment_request.job_code";
        Connection _con;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = new ArrayList<AdvertisementEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                AdvertisementEntity recBatchCodeSearchObj = new AdvertisementEntity(_rs.getString(1), _rs.getString(2));
                arrayListBatchSearchObj.add(recBatchCodeSearchObj);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return arrayListBatchSearchObj;
    }

    /**
     * This function read new approved requitment requests
     * @return
     */
    public ArrayList<AdvertisementEntity> newRequitmentAppoved() {
        String select = "SELECT " +
                " distinct hr_recruitment_request.recruit_batch_code  " +
                " FROM " +
                "       hr_recruitment_request," +
                "       hr_recruitment_request_status " +
                " where " +
                "       hr_recruitment_request.recruit_Request_Id = hr_recruitment_request_status.recruit_request_id " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1 " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=0 " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.REJECT=0";

        Connection _con;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = new ArrayList<AdvertisementEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                AdvertisementEntity recBatchCodeSearchObj = new AdvertisementEntity(_rs.getString("recruit_batch_code"), _rs.getString("recruit_batch_code"));
                arrayListBatchSearchObj.add(recBatchCodeSearchObj);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return arrayListBatchSearchObj;
    }
     public ArrayList<AdvertisementEntity> newRequitmentAppovedBatchCode() {
        String select = "SELECT " +
                " distinct hr_recruitment_request.recruit_batch_code  " +
                " FROM " +
                "       hr_recruitment_request," +
                "       hr_recruitment_request_status " +
                " where " +
                "       hr_recruitment_request.recruit_Request_Id = hr_recruitment_request_status.recruit_request_id " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1 " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=0 " +
                "  AND HR_RECRUITMENT_REQUEST_STATUS.REJECT=0";

        Connection _con;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = new ArrayList<AdvertisementEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                AdvertisementEntity recBatchCodeSearchObj = new AdvertisementEntity(_rs.getString("recruit_batch_code"), _rs.getString("recruit_batch_code"));
                arrayListBatchSearchObj.add(recBatchCodeSearchObj);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return arrayListBatchSearchObj;
    }

    public ArrayList<AdvertisementEntity> previousRequitmentAppoved() {
        String select = " SELECT  " +
                "               distinct    hr_recruitment_request.recruit_batch_code" +
                "         FROM      " +
                "                     hr_recruitment_request," +
                "                     hr_recruitment_request_status      " +
                "        WHERE   " +
                "                     hr_recruitment_request.recruit_request_id=hr_recruitment_request_status.recruit_request_id AND" +
                "                    hr_recruitment_request_status.advertise='1' ";
        Connection _con;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        ArrayList<AdvertisementEntity> arrayListBatchSearchObj = new ArrayList<AdvertisementEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                AdvertisementEntity recBatchCodeSearchObj = new AdvertisementEntity(_rs.getString("recruit_batch_code"), _rs.getString("recruit_batch_code"));

                arrayListBatchSearchObj.add(recBatchCodeSearchObj);
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return arrayListBatchSearchObj;
    }

    public HashMap[] readApprovedRecruitments(String batchCode) {
        HashMap[] approvedRecruitmentList = null;
        PreparedStatement _ps;
        ResultSet rs;
        Connection _con;
        String select = "SELECT " +
                "               hr_recruitment_request.approved_By, " +
                "               hr_recruitment_request.RECRUIT_APPROVED_DATE, " +
                "               hr_lu_job_type.JOB_NAME," +
                "               hr_recruitment_request.num_Of_Emps_Approved, " +
                "               hr_recruitment_request.status, " +
                "               hr_recruitment_request.recruit_Request_Id, " +
                "               hr_recruitment_request.recruit_Request_Ref_Date, " +
                "               hr_recruitment_request.recruit_Request_Type, " +
                "               hr_recruitment_request.num_Of_Emps, " +
                "               hr_recruitment_request.job_Code, " +
                "               hr_recruitment_request.recruit_Batch_Code, " +
                "               hr_employee_info.first_name," +
                "               hr_employee_info.middle_name," +
                "               hr_employee_info.last_name," +
                "               hr_recruitment_request_status.advertise," +
                "               hr_recruitment_request_status.approve," +
                "               hr_recruitment_request_status.reject," +
                "               hr_recruitment_request.requester_id,    " +
                "               requester.first_name as requesterName," +
                "               requester.middle_name as requesterMiddleName," +
                "               requester.last_name as requesterLastName     " +
                " FROM          hr_recruitment_request ," +
                "               hr_recruitment_request_status," +
                "               hr_lu_job_type," +
                "               hr_employee_info requester   ," +
                "               hr_employee_info " +
                " WHERE         hr_recruitment_request.job_code=hr_lu_job_type.job_code  AND" +
                "               hr_recruitment_request.APPROVED_BY=hr_employee_info.emp_id AND" +
                "               hr_recruitment_request.recruit_request_id=hr_recruitment_request_status.recruit_request_id AND" +
                "               hr_recruitment_request_status.approve=1 AND " +
                "               hr_recruitment_request_status.advertise=0 AND" +
                "               hr_recruitment_request_status.reject=0 AND " +
                "               hr_recruitment_request.recruit_batch_code='" + batchCode + "' AND " +
                "               hr_recruitment_request.requester_id=requester.emp_id ";
        try {
            int i = 0;
            int number = 1;
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            rs = _ps.executeQuery();
            _rs.populate(rs);
            approvedRecruitmentList = new HashMap[_rs.size()];
            setCountRequest(_rs.size());
            while (_rs.next()) {

                approvedRecruitmentList[i] = new HashMap();
                approvedRecruitmentList[i].put("Batch_Code", _rs.getString("recruit_Batch_Code"));
                approvedRecruitmentList[i].put("JOB_NAME", _rs.getString("JOB_NAME"));
                approvedRecruitmentList[i].put("recruit_Request_Date", _rs.getString("recruit_Request_Ref_Date"));
                approvedRecruitmentList[i].put("first_name", _rs.getString("first_name"));
                approvedRecruitmentList[i].put("middle_name", _rs.getString("middle_name"));
                approvedRecruitmentList[i].put("last_name", _rs.getString("last_name"));
                approvedRecruitmentList[i].put("type", _rs.getString("recruit_Request_Type"));
                approvedRecruitmentList[i].put("num_Of_Emps", _rs.getString("num_Of_Emps_Approved"));
                approvedRecruitmentList[i].put("approved_By", _rs.getString("approved_By"));
                approvedRecruitmentList[i].put("approved_Date", _rs.getString("RECRUIT_APPROVED_DATE"));

                approvedRecruitmentList[i].put("recruit_Request_Id", _rs.getString("recruit_Request_Id"));
                approvedRecruitmentList[i].put("recruit_Request_Date", _rs.getString("recruit_Request_Ref_Date"));
                approvedRecruitmentList[i].put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                approvedRecruitmentList[i].put("requesterName", _rs.getString("requesterName"));
                approvedRecruitmentList[i].put("requesterMiddleName", _rs.getString("requesterMiddleName"));
                approvedRecruitmentList[i].put("requesterLastName", _rs.getString("requesterLastName"));
                approvedRecruitmentList[i].put("number", number);
                number++;
                i++;

            }
            return approvedRecruitmentList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<HashMap> readPreviousAdvertisement(String bachCode) {
        ArrayList<HashMap> approvedRecruitmentList = new ArrayList<HashMap>();
        PreparedStatement _ps;
        ResultSet _rs;
        Connection _con;
        String select = "SELECT HR_ADVERTISEMENT.ADVERT_DATE_FROM," +
                "               HR_ADVERTISEMENT.ADVERT_DATE_TO," +
                "               HR_ADVERTISEMENT.ADVERT_ID," +
                "               HR_ADVERTISEMENT.PREPARED_DATE," +
                "               HR_ADVERTISEMENT.PREPAREDBY," +
                "               HR_ADVERTISEMENT.RECRUIT_BATCH_CODE," +
                "               HR_ADVERTISEMENT.RECRUIT_REQUEST_ID," +
                "               HR_ADVERTISEMENT.STATUS," +
                "               HR_EMPLOYEE_INFO.FIRST_NAME as advFIRST_NAME," +
                "               HR_EMPLOYEE_INFO.MIDDLE_NAME as advMIDDLE_NAME," +
                "               HR_EMPLOYEE_INFO.LAST_NAME as advLAST_NAME," +
                "               HR_RECRUITMENT_REQUEST.JOB_CODE," +
                "               hr_recruitment_request.recruit_request_type,  " +
                "               HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, " +
                "               HR_LU_JOB_TYPE.JOB_NAME," +
                "               hr_recruitment_request.num_of_emps    " +
                "        FROM   HR_ADVERTISEMENT," +
                "               HR_EMPLOYEE_INFO," +
                "               HR_RECRUITMENT_REQUEST," +
                "               HR_LU_JOB_TYPE  " +
                "        WHERE HR_ADVERTISEMENT.RECRUIT_BATCH_CODE='" + bachCode + "' AND" +
                "              hr_employee_info.emp_id=hr_advertisement.preparedby AND" +
                "              HR_LU_JOB_TYPE.JOB_CODE=HR_RECRUITMENT_REQUEST.JOB_CODE AND" +
                "               HR_ADVERTISEMENT.RECRUIT_REQUEST_ID=hr_recruitment_request.recruit_request_id";
        try {

            OracleCachedRowSet rs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            rs.populate(_rs);
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("ADVERT_DATE_FROM", rs.getString("ADVERT_DATE_FROM"));
                hm.put("ADVERT_DATE_TO", rs.getString("ADVERT_DATE_TO"));
                hm.put("ADVERT_ID", rs.getString("ADVERT_ID"));
                hm.put("PREPARED_DATE", rs.getString("PREPARED_DATE"));
                hm.put("PREPAREDBY", rs.getString("PREPAREDBY"));
                hm.put("RECRUIT_BATCH_CODE", rs.getString("RECRUIT_BATCH_CODE"));
                hm.put("RECRUIT_REQUEST_ID", rs.getString("RECRUIT_REQUEST_ID"));
                hm.put("STATUS", rs.getString("STATUS"));
                hm.put("advFIRST_NAME", rs.getString("advFIRST_NAME"));
                hm.put("advMIDDLE_NAME", rs.getString("advMIDDLE_NAME"));
                hm.put("advLAST_NAME", rs.getString("advLAST_NAME"));
                hm.put("JOB_CODE", rs.getString("JOB_CODE"));
                hm.put("JOB_NAME", rs.getString("JOB_NAME"));
                hm.put("ADVERTISEMENT_TYPE", rs.getString("ADVERTISEMENT_TYPE"));
                hm.put("recruit_request_type", rs.getString("recruit_request_type"));
                hm.put("num_of_emps", rs.getString("num_of_emps"));
                approvedRecruitmentList.add(hm);
            }
            return approvedRecruitmentList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public HashMap[] readAdvertisemen(String advertisementId) {
        HashMap[] _list = null;
        int i = 0;

        String select = "SELECT * FROM hr_media_type " +
                "WHERE advert_Id=?";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleResultSetMetaData count = (OracleResultSetMetaData) _rs.getMetaData();
            _list = new HashMap[count.getColumnCount()];
            while (_rs.next()) {
                _list[i] = new HashMap();
                _list[i].put("media_Type_Code", _rs.getString("media_Type_Code"));
                _list[i].put("description", _rs.getString("description"));
                _list[i].put("occurrence", _rs.getString("occurrence"));
                i++;
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return _list;
        }

    }

    public ResultSet selectRequesterID(String advertId) {
        String select = "SELECT REQUESTER_ID FROM HR_PROMOTION_REQUEST " +
                "WHERE advert_Id='" + advertId + "'";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();

            return _rs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return _rs;
        }
    }

//    public HashMap[] readVacancy() {
//        HashMap[] _list = null;
//        int i = 0;
//
//        String select = " select hr_advertisement.advert_date_from,hr_advertisement.advert_date_to," +
//                        " hr_advertisement.recruit_batch_code," +
//                        " hr_lu_job_type.JOB_DESCRIPTION FROM(hr_advertisement " +
//                        " INNER JOIN hr_recruitment_request ON hr_advertisement.RECRUIT_BATCH_CODE=hr_recruitment_request.RECRUIT_BATCH_CODE) " +
//                        " INNER JOIN hr_lu_job_type ON hr_recruitment_request.JOB_CODE=hr_lu_job_type.job_code";
//
//        Connection _con = null;
//        ResultSet _rs = null;
//        PreparedStatement _ps = null;
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(select);
//            _ps.executeQuery();
//            _rs = _ps.getResultSet();
//            OracleResultSetMetaData count = (OracleResultSetMetaData) _rs.getMetaData();
//            _list = new HashMap[count.getColumnCount()];
//            while (_rs.next()) {
//                _list[i] = new HashMap();
//                _list[i].put("advert_date_from", _rs.getString("advert_date_from"));
//                _list[i].put("advert_date_to", _rs.getString("advert_date_to"));
//                _list[i].put("recruit_batch_code", _rs.getString("recruit_batch_code"));
//                _list[i].put("JOB_DESCRIPTION", _rs.getString("JOB_DESCRIPTION"));
//                i++;
//            }
//            return _list;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return _list;
//        }
//
//    }
    public HashMap[] readVacancy() {
        HashMap[] _list = null;
        int i = 0;
        String type = "Inside";
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String currentDate = dateFormat.format(new Date());
        String select = "SELECT hr_lu_job_type.rank_id, " +
                "  hr_advertisement.ADVERT_ID, " +
                "  hr_advertisement.advert_date_from, " +
                "  hr_advertisement.advert_date_to, " +
                "  HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, " +
                "  hr_advertisement.recruit_batch_code, " +
                "  hr_advertisement.RECRUIT_REQUEST_ID, " +
                "  hr_lu_job_type.JOB_NAME, " +
                "  hr_lu_job_type.job_code AS JOB_CODE, " +
                "  hr_recruitment_request.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION " +
                "FROM hr_advertisement, " +
                " hr_recruitment_request,  hr_lu_job_type,HR_LU_JOB_TYPE_QUALIFICATION, VW_LU_JOB_TYPE_QUALIFICATION, VW_LU_JOB_TYPE_EDUC_LEVEL " +
                "WHERE( '" + currentDate + "' BETWEEN hr_advertisement.advert_date_from AND hr_advertisement.advert_date_to " +
                "AND hr_advertisement.RECRUIT_REQUEST_ID   = hr_recruitment_request.RECRUIT_REQUEST_ID " +
                "AND hr_recruitment_request.JOB_CODE       = hr_lu_job_type.job_code " +
                "AND VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = hr_lu_job_type.job_code " +
                "AND VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE = hr_lu_job_type.job_code " +
                "AND HR_ADVERTISEMENT.ADVERTISEMENT_TYPE   = 'Inside' ) " +
                "ORDER BY recruit_batch_code ASC , " +
                "  qualification ASC, " +
                "  EDUCATION_LEVEL ASC";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("advert_date_from", ocrs.getString("advert_date_from"));
                _list[i].put("advert_date_to", ocrs.getString("advert_date_to"));
                _list[i].put("recruit_batch_code", ocrs.getString("recruit_batch_code"));
                _list[i].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                _list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                _list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                _list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                _list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                _list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                _list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                i++;
            }
            return _list;
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

    public int countVacancy() {
        String select = "select MAX(rownum) as num FROM(hr_advertisement " +
                " INNER JOIN hr_recruitment_request ON hr_advertisement.RECRUIT_BATCH_CODE=hr_recruitment_request.RECRUIT_BATCH_CODE) " +
                " INNER JOIN hr_lu_job_type ON hr_recruitment_request.JOB_CODE=hr_lu_job_type.job_code";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();



            if (_rs.next()) {
                return _rs.getInt("num");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return 0;
    }

    public HashMap readAdvertisement(String bachCode) {
        String select = "SELECT ADVERT_ID," +
                "               PREPARED_DATE," +
                "               ADVERT_DATE_FROM," +
                "               ADVERT_DATE_TO," +
                "               RECRUIT_BATCH_CODE," +
                "               PREPAREDBY," +
                "               hr_employee_info.first_name || ' ' || hr_employee_info.middle_name || ' ' || hr_employee_info.last_name as fullName" +
                "        FROM   hr_advertisement," +
                "               hr_employee_info" +
                "        WHERE  recruit_batch_code='" + bachCode + "' AND" +
                "               hr_employee_info.emp_id=hr_advertisement.preparedby";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        HashMap list = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                list.put("ADVERT_ID", _rs.getString("ADVERT_ID"));
                list.put("PREPARED_DATE", _rs.getString("PREPARED_DATE"));
                list.put("ADVERT_DATE_FROM", _rs.getString("ADVERT_DATE_FROM"));
                list.put("ADVERT_DATE_TO", _rs.getString("ADVERT_DATE_TO"));
                list.put("RECRUIT_BATCH_CODE", _rs.getString("RECRUIT_BATCH_CODE"));
                list.put("PREPAREDBY", _rs.getString("PREPAREDBY"));
                list.put("fullName", _rs.getString("fullName"));

            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }
        return null;
    }

    public boolean registerVacancyInformation(ArrayList<HashMap> vacancyInformation, ArrayList<HashMap> mediInformantion, ArrayList<HashMap> recruitemntInfo) {

        PreparedStatement insertVac = null;
        PreparedStatement insertMediType = null;
        PreparedStatement updateRecruti = null;
        Savepoint savePoint = null;
        Connection _con = null;
        boolean checkSave = true;
        int saveVacantInfo = 0;
        String inseretVacancyInfo = "INSERT INTO    HR_ADVERTISEMENT " +
                " (ADVERT_ID,PREPARED_DATE, " +
                "  ADVERT_DATE_FROM, " +
                "  ADVERT_DATE_TO," +
                " RECRUIT_BATCH_CODE," +
                " PREPAREDBY," +
                " RECRUIT_REQUEST_ID," +
                " ADVERTISEMENT_TYPE)" +
                " VALUES(HR_ADVERTISEMENT_SEQ.NEXTVAL,?,?,?,?,?,?,?) ";
             String insertMediInformantion;
//        String insertMediInformantion = " INSERT INTO hr_lu_media(" +
//                " advert_Id," +
//                " media_Type_Code," +
//                " media_name," +
//                " occurrence)" +
//                "  VALUES(HR_ADVERTISEMENT_0.carrval,?,?,?,)";

        String updateStatus = " UPDATE  " +
                " HR_RECRUITMENT_REQUEST_STATUS SET ADVERTISE=1 WHERE RECRUIT_REQUEST_ID=?";
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            savePoint = _con.setSavepoint("SAVE_POINT");
            for (HashMap hm : vacancyInformation) {
                insertVac = _con.prepareStatement(inseretVacancyInfo);
                insertVac.setString(1, hm.get("advertDateFrom").toString());
                insertVac.setString(2, hm.get("advertDateFrom").toString());
                insertVac.setString(3, hm.get("advertDateTO").toString());
                insertVac.setString(4, hm.get("batchCode").toString());
                insertVac.setString(5, hm.get("prepredeBY").toString());
                insertVac.setString(6, hm.get("recruitmentID").toString());
                insertVac.setString(7, hm.get("advertisementType").toString());
                saveVacantInfo = insertVac.executeUpdate();

            }
            if (saveVacantInfo > 0) {
                if (mediInformantion.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    _con.setAutoCommit(false);
                    for (HashMap hm : mediInformantion) {//loop over the attached file
                        insertMediInformantion = " INSERT INTO HR_LU_MEDIA(" +
                                " media_Type_Code," +
                                " MEDIA_NAME," +
                                " occurrence," +
                                "  advert_Id,MEDIID)" +
                                "  VALUES(" + hm.get("mediaType").toString() + ",'" + hm.get("mediaName").toString() + "'," + hm.get("occurrence").toString() + ",HR_ADVERTISEMENT_SEQ.NEXTVAL,HR_ADVERTISEMENT_SEQ.currval)";
                        insertMediType = _con.prepareStatement(insertMediInformantion);
                        if (insertMediType.executeUpdate() != 1) {
                            checkSave = false;
                            break;
                        }
                    }
                    if (checkSave) {
                        for (HashMap hm : recruitemntInfo) {//loop over the attached file
                            updateRecruti = _con.prepareStatement(updateStatus);
                            updateRecruti.setString(1, hm.get("recruitRequestId").toString());
                            if (updateRecruti.executeUpdate() != 1) {
                                checkSave = false;
                                break;
                            }
                        }

                    }
                }
            } else {

                checkSave = false;
            }
            if (checkSave) {
                _con.commit();
            } else {
                _con.rollback(savePoint);
            }
            return checkSave;


        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
        }
        return false;

    }

    public boolean updateVacancyInformation(ArrayList<HashMap> vacancyInformation, ArrayList<HashMap> mediInformantion, ArrayList<HashMap> recruitemntInfo, HashMap adverAndBachCode) {
        PreparedStatement insertVac = null;
        PreparedStatement insertMediType = null;
        PreparedStatement updateRecruti = null;
        PreparedStatement deleteVacntInfo = null;
        Savepoint savePoint = null;
        Connection _con = null;
        boolean checkSave = true;
        int saveVacantInfo = 0;
        String deleteVacancyInfo = "DELETE FROM HR_ADVERTISEMENT WHERE RECRUIT_BATCH_CODE=?";
        String deleteMediaInfo = "DELETE FROM hr_lu_media WHERE advert_Id=?";
        String updateReStatus = " UPDATE  HR_RECRUITMENT_REQUEST_STATUS  " +
                "               SET ADVERTISE=0 WHERE RECRUIT_REQUEST_ID=?";

        String inseretVacancyInfo = "INSERT INTO    HR_ADVERTISEMENT " +
                " (PREPARED_DATE, " +
                "  ADVERT_DATE_FROM, " +
                "  ADVERT_DATE_TO," +
                " RECRUIT_BATCH_CODE," +
                " PREPAREDBY," +
                " RECRUIT_REQUEST_ID," +
                " ADVERTISEMENT_TYPE)" +
                " VALUES(?,?,?,?,?,?,?) ";
        String insertMediInformantion = " INSERT INTO hr_lu_media(" +
                " advert_Id," +
                " media_Type_Code," +
                " occurrence)" +
                "  VALUES(HR_ADVERTISEMENT_0.currval,?,?)";

        String updateStatus = "UPDATE  HR_RECRUITMENT_REQUEST_STATUS  " +
                "               SET ADVERTISE=1 WHERE RECRUIT_REQUEST_ID=?";
        try {
            // CacheConnection.setVerbose(true);
            Connection connection;// = CacheConnection.checkOut();
            _con = getConnection();
            _con.setAutoCommit(false);
            savePoint = _con.setSavepoint("SAVE_POINT");
            for (HashMap hm : vacancyInformation) {
                updateRecruti = _con.prepareStatement(updateReStatus);

                updateRecruti.setString(1, hm.get("recruitRequestId").toString());

                if (updateRecruti.executeUpdate() <= 0) {
                    checkSave = false;
                    break;
                }
            }
            if (checkSave) {
                deleteVacntInfo = _con.prepareStatement(deleteMediaInfo);

                deleteVacntInfo.setString(1, adverAndBachCode.get("advertisementID").toString());

                if (deleteVacntInfo.executeUpdate() > 0) {
                    deleteVacntInfo = _con.prepareStatement(deleteVacancyInfo);
                    deleteVacntInfo.setString(1, adverAndBachCode.get("bachcode").toString());
                    if (deleteVacntInfo.executeUpdate() > 0) {
                        for (HashMap hm : vacancyInformation) {
                            insertVac = _con.prepareStatement(inseretVacancyInfo);
                            insertVac.setString(1, hm.get("advertDateFrom").toString());
                            insertVac.setString(2, hm.get("advertDateFrom").toString());
                            insertVac.setString(3, hm.get("advertDateTO").toString());
                            insertVac.setString(4, hm.get("batchCode").toString());
                            insertVac.setString(5, hm.get("prepredeBY").toString());
                            insertVac.setString(6, hm.get("recruitmentID").toString());
                            insertVac.setString(7, hm.get("advertisementType").toString());
                            saveVacantInfo = insertVac.executeUpdate();
                        }
                        if (saveVacantInfo > 0) {

                            if (mediInformantion.size() > 0) {
                                for (HashMap hm : mediInformantion) {

                                    insertMediInformantion = " INSERT INTO HR_LU_MEDIA(" +
                                            " media_Type_Code," +
                                            " occurrence," +
                                            "  advert_Id)" +
                                            "  VALUES(" + hm.get("mediaType").toString() + "," +
                                            hm.get("occurrence").toString() + ",HR_ADVERTISEMENT_0.currval)";
                                    insertMediType = _con.prepareStatement(insertMediInformantion);
                                    if (insertMediType.executeUpdate() != 1) {
                                        checkSave = false;
                                        break;
                                    }
                                }
                                if (checkSave) {
                                    for (HashMap hm : recruitemntInfo) {//loop over the attached file
                                        updateRecruti = _con.prepareStatement(updateStatus);
                                        updateRecruti.setString(1, hm.get("recruitRequestId").toString());
                                        if (updateRecruti.executeUpdate() != 1) {
                                            checkSave = false;
                                            break;
                                        }
                                    }
                                }
                            } else {
                                _con.rollback(savePoint);
                            }
                        } else {
                            checkSave = false;
                        }
                        if (checkSave) {
                            _con.commit();
                        } else {
                            _con.rollback(savePoint);
                        }
                        return checkSave;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }
            } else {
                return false;
            }

        } catch (Exception e) {
            try {
                _con.rollback(savePoint);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return false;

        }






    }

    public HashMap[] readAdvertisementInformantion(String batchCode) {
        HashMap[] approvedRecruitmentList = null;
        PreparedStatement _ps;
        ResultSet rs;
        Connection _con;
        String select = "SELECT " +
                "               hr_recruitment_request.approved_By, " +
                "               hr_recruitment_request.RECRUIT_APPROVED_DATE, " +
                "               hr_lu_job_type.job_description," +
                "               hr_recruitment_request.num_Of_Emps_Approved, " +
                "               hr_recruitment_request.status, " +
                "               hr_recruitment_request.recruit_Request_Id, " +
                "               hr_recruitment_request.recruit_Request_Ref_Date, " +
                "               hr_recruitment_request.recruit_Request_Type, " +
                "               hr_recruitment_request.num_Of_Emps, " +
                "               hr_recruitment_request.job_Code, " +
                "               hr_recruitment_request.recruit_Batch_Code, " +
                "               hr_employee_info.first_name," +
                "               hr_employee_info.middle_name," +
                "               hr_employee_info.last_name," +
                "               NVL(requester.DEPARTMENT_ID,'0') as DEPARTMENT_ID ," +
                "               NVL(requester.DIRECTORATE,'DIRECTORATE') as DIRECTORATE," +
                "               NVL(requester.DIVISION,'DIVISION') as DIVISION," +
                "               NVL(requester.MASTEBABRIYA,'MASTEBABRIYA') as MASTEBABRIYA," +
                "               NVL(requester.TEAM,'TEAM') as TEAM," +
                "               hr_recruitment_request_status.advertise," +
                "               hr_recruitment_request_status.approve," +
                "               hr_recruitment_request_status.reject," +
                "               hr_recruitment_request.requester_id,    " +
                "               requester.first_name as requesterName," +
                "               requester.middle_name as requesterMiddleName," +
                "               requester.last_name as requesterLastName     " +
                " FROM          hr_recruitment_request ," +
                "               hr_recruitment_request_status," +
                "               hr_lu_job_type," +
                "               hr_employee_info requester   ," +
                "               hr_employee_info " +
                " WHERE         hr_recruitment_request.job_code=hr_lu_job_type.job_code  AND" +
                "               hr_recruitment_request.APPROVED_BY=hr_employee_info.emp_id AND" +
                "               hr_recruitment_request.recruit_request_id=hr_recruitment_request_status.recruit_request_id AND" +
                "               hr_recruitment_request_status.approve=1 AND " +
                "               hr_recruitment_request_status.advertise=1 AND" +
                "               hr_recruitment_request_status.reject=0 AND " +
                "               hr_recruitment_request.recruit_batch_code='" + batchCode + "' AND " +
                "               hr_recruitment_request.requester_id=requester.emp_id ";
        try {

            int i = 0;
            int number = 1;
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            rs = _ps.executeQuery();
            _rs.populate(rs);
            approvedRecruitmentList = new HashMap[_rs.size()];
            setCountRequest(_rs.size());
            while (_rs.next()) {

                approvedRecruitmentList[i] = new HashMap();
                approvedRecruitmentList[i].put("Batch_Code", _rs.getString("recruit_Batch_Code"));
                approvedRecruitmentList[i].put("job_description", _rs.getString("job_description"));
                approvedRecruitmentList[i].put("recruit_Request_Date", _rs.getString("recruit_Request_Ref_Date"));
                approvedRecruitmentList[i].put("first_name", _rs.getString("first_name"));
                approvedRecruitmentList[i].put("middle_name", _rs.getString("middle_name"));
                approvedRecruitmentList[i].put("last_name", _rs.getString("last_name"));
                approvedRecruitmentList[i].put("type", _rs.getString("recruit_Request_Type"));
                approvedRecruitmentList[i].put("num_Of_Emps", _rs.getString("num_Of_Emps_Approved"));
                approvedRecruitmentList[i].put("approved_By", _rs.getString("approved_By"));
                approvedRecruitmentList[i].put("approved_Date", _rs.getString("RECRUIT_APPROVED_DATE"));

                approvedRecruitmentList[i].put("DEPARTMENT_ID", _rs.getString("DEPARTMENT_ID"));
                approvedRecruitmentList[i].put("DIRECTORATE", _rs.getString("DIRECTORATE"));
                approvedRecruitmentList[i].put("DIVISION", _rs.getString("DIVISION"));
                approvedRecruitmentList[i].put("MASTEBABRIYA", _rs.getString("MASTEBABRIYA"));
                approvedRecruitmentList[i].put("TEAM", _rs.getString("TEAM"));

                approvedRecruitmentList[i].put("recruit_Request_Id", _rs.getString("recruit_Request_Id"));
                approvedRecruitmentList[i].put("recruit_Request_Date", _rs.getString("recruit_Request_Ref_Date"));
                approvedRecruitmentList[i].put("REQUESTER_ID", _rs.getString("REQUESTER_ID"));
                approvedRecruitmentList[i].put("requesterName", _rs.getString("requesterName"));
                approvedRecruitmentList[i].put("requesterMiddleName", _rs.getString("requesterMiddleName"));
                approvedRecruitmentList[i].put("requesterLastName", _rs.getString("requesterLastName"));
                approvedRecruitmentList[i].put("number", number);
                number++;
                i++;

            }
            return approvedRecruitmentList;
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public HashMap[] readAdvertizmentMediaInformantion(String advertismentID) {
        String select = " SELECT hr_lu_media.media_type_code as media_type," +
                "              hr_lu_media.mediid as mediid," +
                "              hr_lu_media.media_name as mediaName," +
                "              hr_lu_media.occurrence as meoccurrence," +
                "              hr_lu_media_type.description as med_description     " +
                "      FROM   hr_lu_media," +
                "             hr_lu_media_type" +
                "    WHERE hr_lu_media.media_type_code=hr_lu_media_type.media_type_code" +
                "           AND  hr_lu_media.advert_id=" + advertismentID + "";

        Connection _con = null;
        ResultSet _rs = null;
        int i = 0;
        PreparedStatement _ps = null;
        HashMap[] list = null; //new HashMap();
        try {
            OracleCachedRowSet orcs = new OracleCachedRowSet();
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            // _ps.setString(1, advertismentID);
            _rs = _ps.getResultSet();
            orcs.populate(_rs);
            _rs.close();
            list = new HashMap[orcs.size()];
            while (orcs.next()) {
                list[i] = new HashMap();
                list[i].put("media_type_code", orcs.getString("media_type"));
                list[i].put("mediid", orcs.getString("mediid"));
                list[i].put("mediaName", orcs.getString("mediaName"));
                list[i].put("occurrence", orcs.getString("meoccurrence"));
                list[i].put("description", orcs.getString("med_description"));
                i++;
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }

        return null;
    }

    public boolean deleteRecruitmentRequest(String mediID) {
        String _select = "delete from hr_lu_media where MEDIID =" + mediID + "";
        PreparedStatement _ps = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            if (_ps.executeUpdate() == 1) {
                return true;
            }
            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }

    }

    public boolean deleteAdvertismentRequest(String adverID, ArrayList<HashMap> recruit_requestID) {

        String deleteMedia = "delete hr_lu_media where ADVERT_ID =?";
        String updateStatus = "UPDATE HR_RECRUITMENT_REQUEST_STATUS SET ADVERTISE=0 WHERE RECRUIT_REQUEST_ID=?";
        String deletAdvertisment = "DELETE HR_ADVERTISEMENT WHERE ADVERT_ID=?";
        PreparedStatement _psMedia = null;
        PreparedStatement _psAdvertismewnt = null;
        PreparedStatement _psStatus = null;
        Connection _con = null;
        boolean checkSave = true;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            // deleteMedia = "delete hr_lu_media where ADVERT_ID ="+adverID+"";
            _psMedia = _con.prepareStatement(deleteMedia);
            _psMedia.setString(1, adverID);
            if (_psMedia.executeUpdate() != 0) {

                for (HashMap hm : recruit_requestID) {//loop over the attached file
                    _psStatus = _con.prepareStatement(updateStatus);
                    _psStatus.setString(1, hm.get("recruitRequestId").toString());

                    if (_psStatus.executeUpdate() != 1) {
                        checkSave = false;
                        break;
                    }
                }
                if (checkSave) {
                    _psAdvertismewnt = _con.prepareStatement(deletAdvertisment);
                    _psAdvertismewnt.setString(1, adverID);
                    if (_psAdvertismewnt.executeUpdate() == 1) {
                        _con.commit();
                        return true;
                    }
                }
            }

            return false;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return false;
        }
//        finally {
//            try {
//                _psMedia.close();
//                _con.close();
//            } catch (Exception ignore) {
//            }
//
//        }

    }

    public String[] readRequesterJobCode(String requesterID) {
        String _list[] = null;

        String select = "SELECT  HR_EMPLOYEE_INFO.EMP_ID," +
                "  HR_EMPLOYEE_INFO.JOB_CODE AS JOB_CODE , HR_LU_JOB_TYPE.JOB_CODE," +
                "  HR_LU_JOB_TYPE.JOB_DESCRIPTION" +
                "  FROM " +
                "  HR_EMPLOYEE_INFO, HR_LU_JOB_TYPE " +
                "  WHERE " +
                "  HR_EMPLOYEE_INFO.EMP_ID = '" + requesterID + "' " +
                "  AND " +
                "  HR_EMPLOYEE_INFO.JOB_CODE = HR_LU_JOB_TYPE.JOB_CODE ";



        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new String[2];
            while (ocrs.next()) {
                _list[0] = ocrs.getString("JOB_CODE");
                _list[1] = ocrs.getString("JOB_DESCRIPTION");
            }
            return _list;
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

    public HashMap[] readVacancyForValidation(String jobCode) {
        HashMap[] _list = null;
        int i = 0;
        String select = " SELECT hr_lu_job_type.JOB_DESCRIPTION, " +
                "  hr_lu_job_type.job_code AS JOB_CODE, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION, " +
                "  HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_LU_EDUC_LEVEL.RANK " +
                "FROM hr_lu_job_type, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION, " +
                "  HR_LU_EDUC_LEVEL " +
                "WHERE VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE      = hr_lu_job_type.job_code " +
                "AND VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE     = hr_lu_job_type.job_code " +
                "AND hr_lu_job_type.job_code                  = '" + jobCode + "' " +
                "AND VW_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL = HR_LU_EDUC_LEVEL.DESCRIPTION " +
                "ORDER BY RANK DESC";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                _list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                _list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("RANK", ocrs.getString("RANK"));
                i++;
            }
            return _list;
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

    public HashMap[] readPersonEducHist(String requesterID) {
        HashMap[] _list = null;
        int i = 0;

        String select = " SELECT HR_EMP_EDUCATION.EMP_ID," +
                " HR_EMP_EDUCATION.INSTITUTION, HR_EMP_EDUCATION.EDUC_LEVEL_CODE," +
                " HR_EMP_EDUCATION.EDUCATION_TYPE, HR_EMP_EDUCATION.STARTING_DATE, HR_EMP_EDUCATION.COMPLETION_DATE, " +
                " HR_EMP_EDUCATION.AWARD, HR_EMP_EDUCATION.RESULT," +
                " HR_EMP_EDUCATION.ID, HR_EMPLOYEE_INFO.EMP_ID AS EMP_ID , HR_EMPLOYEE_INFO.HIRE_DATE," +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE AS TRUECODE, HR_LU_EDUC_LEVEL.DESCRIPTION, HR_LU_EDUC_LEVEL.RANK," +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE, HR_LU_EDUC_TYPE.DESCRIPTION AS Educ_DESCRIPTION " +
                " FROM " +
                " HR_EMP_EDUCATION, HR_EMPLOYEE_INFO, HR_LU_EDUC_LEVEL, HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = '" + requesterID + "' " +
                " AND " +
                " HR_EMP_EDUCATION.EMP_ID =  HR_EMPLOYEE_INFO.EMP_ID " +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_EMP_EDUCATION.EDUC_LEVEL_CODE " +
                " AND" +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_EMP_EDUCATION.EDUCATION_TYPE" +
                " ORDER BY RANK ASC ";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];

            while (ocrs.next()) {
                _list[i] = new HashMap();

                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("INSTITUTION", ocrs.getString("INSTITUTION"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                _list[i].put("STARTING_DATE", ocrs.getString("STARTING_DATE"));
                _list[i].put("COMPLETION_DATE", ocrs.getString("COMPLETION_DATE"));
                _list[i].put("AWARD", ocrs.getString("AWARD"));
                _list[i].put("RESULT", ocrs.getString("RESULT"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("TRUECODE", ocrs.getString("TRUECODE"));
                _list[i].put("RANK", ocrs.getString("RANK"));
                _list[i].put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                _list[i].put("Educ_DESCRIPTION", ocrs.getString("Educ_DESCRIPTION"));

                i++;
            }

            return _list;
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

    public HashMap[] readVacancyPromoRequesterTotalServiceYear(String advertID) {
        HashMap[] _list = null;
        int i = 0;

        String select = " select HR_PROMOTION_REQUEST.ADVERT_ID, HR_PROMOTION_REQUEST.REQUESTER_ID, HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID," +
                " HR_PROMOTION_REQUEST.ID, hr_lu_job_type.JOB_DESCRIPTION, HR_EMPLOYEE_INFO.HIRE_DATE, hr_lu_job_type.job_code," +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME," +
                " HR_EMPLOYEE_INFO.JOB_CODE AS JOB_CODE, HR_EMP_EDUCATION.EMP_ID AS EMP_ID, HR_EMP_EDUCATION.EDUC_LEVEL_CODE, HR_EMP_EDUCATION.EDUCATION_TYPE," +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE, HR_LU_EDUC_LEVEL.DESCRIPTION AS EDUC_LEVEL_DISC," +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE, HR_LU_EDUC_TYPE.DESCRIPTION AS EDUC_TYPE_DISC " +
                " FROM " +
                " HR_PROMOTION_REQUEST, hr_lu_job_type, HR_EMPLOYEE_INFO, HR_EMP_EDUCATION, HR_LU_EDUC_LEVEL,HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = '" + advertID + "'" +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                " AND " +
                " HR_EMPLOYEE_INFO.JOB_CODE = hr_lu_job_type.job_code " +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EMP_EDUCATION.EMP_ID" +
                " AND " +
                " HR_PROMOTION_REQUEST.ID = HR_EMP_EDUCATION.ID " +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_EMP_EDUCATION.EDUC_LEVEL_CODE" +
                " AND " +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_EMP_EDUCATION.EDUCATION_TYPE " +
                " ORDER BY HIRE_DATE ASC ";



        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                _list[i].put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                _list[i].put("LAST_NAME", ocrs.getString("LAST_NAME"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("EDUC_LEVEL_DISC", ocrs.getString("EDUC_LEVEL_DISC"));
                _list[i].put("EDUC_TYPE_DISC", ocrs.getString("EDUC_TYPE_DISC"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                i++;
            }
            return _list;
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

    public HashMap[] readVacancyPromoRequesterEducationLevel(String advertID) {
        HashMap[] _list = null;
        int i = 0;

        String select = "select HR_PROMOTION_REQUEST.ADVERT_ID,HR_PROMOTION_REQUEST.ADVERT_ID, HR_PROMOTION_REQUEST.REQUESTER_ID, HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID," +
                " HR_PROMOTION_REQUEST.ID, hr_lu_job_type.JOB_DESCRIPTION, HR_EMPLOYEE_INFO.HIRE_DATE, hr_lu_job_type.job_code," +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME," +
                " HR_EMPLOYEE_INFO.JOB_CODE AS JOB_CODE, HR_EMP_EDUCATION.EMP_ID AS EMP_ID, HR_EMP_EDUCATION.EDUC_LEVEL_CODE, HR_EMP_EDUCATION.EDUCATION_TYPE," +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE, HR_LU_EDUC_LEVEL.DESCRIPTION AS EDUC_LEVEL_DISC, HR_LU_EDUC_LEVEL.RANK," +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE, HR_LU_EDUC_TYPE.DESCRIPTION AS EDUC_TYPE_DISC " +
                " FROM " +
                " HR_PROMOTION_REQUEST, hr_lu_job_type, HR_EMPLOYEE_INFO, HR_EMP_EDUCATION, HR_LU_EDUC_LEVEL,HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = '" + advertID + "'" +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                " AND " +
                " HR_EMPLOYEE_INFO.JOB_CODE = hr_lu_job_type.job_code " +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EMP_EDUCATION.EMP_ID" +
                " AND " +
                " HR_PROMOTION_REQUEST.ID = HR_EMP_EDUCATION.ID " +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_EMP_EDUCATION.EDUC_LEVEL_CODE" +
                " AND " +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_EMP_EDUCATION.EDUCATION_TYPE " +
                " ORDER BY RANK ASC ";



        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                _list[i].put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                _list[i].put("LAST_NAME", ocrs.getString("LAST_NAME"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("EDUC_LEVEL_DISC", ocrs.getString("EDUC_LEVEL_DISC"));
                _list[i].put("EDUC_TYPE_DISC", ocrs.getString("EDUC_TYPE_DISC"));
                _list[i].put("RANK", ocrs.getString("RANK"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                i++;
            }
            return _list;
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

    public HashMap[] readVacancyPromoRequest(String advertID) {
        HashMap[] _list = null;
        int i = 0;

        String select = " SELECT hr_advertisement.ADVERT_ID, " +
                "  hr_advertisement.advert_date_from, " +
                "  hr_advertisement.advert_date_to, " +
                "  HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, " +
                "  hr_advertisement.recruit_batch_code, " +
                "  hr_advertisement.RECRUIT_REQUEST_ID, " +
                "  hr_lu_job_type.JOB_NAME, " +
                "  hr_lu_job_type.job_code AS JOB_CODE, " +
                "  hr_recruitment_request.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE, " +
                "  hr_lu_job_type.RANK_ID, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  VW_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION " +
                "FROM VW_LU_JOB_TYPE_QUALIFICATION, " +
                "  VW_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  hr_advertisement, " +
                "  hr_recruitment_request, " +
                "  hr_lu_job_type " +
                "WHERE( hr_advertisement.RECRUIT_REQUEST_ID = hr_recruitment_request.RECRUIT_REQUEST_ID " +
                "AND hr_recruitment_request.JOB_CODE        = hr_lu_job_type.job_code " +
                "AND VW_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE     = hr_lu_job_type.job_code " +
                "AND VW_LU_JOB_TYPE_QUALIFICATION.JOB_CODE  = hr_lu_job_type.job_code " +
                "AND HR_ADVERTISEMENT.ADVERT_ID             = '" + advertID + "') " +
                "ORDER BY JOB_DESCRIPTION ASC , " +
                "  qualification ASC, " +
                "  EDUCATION_LEVEL ASC";


//
//
//
//
//                "select hr_advertisement.ADVERT_ID, hr_advertisement.advert_date_from, " +
//                " hr_advertisement.advert_date_to, HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, " +
//                " hr_advertisement.recruit_batch_code, hr_advertisement.RECRUIT_REQUEST_ID, hr_lu_job_type.JOB_DESCRIPTION," +
//                " hr_lu_job_type.job_code as JOB_CODE, hr_recruitment_request.JOB_CODE, HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE," +
//                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE, " +
//                " hr_lu_job_type.RANK_ID, " +
//                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID AS RECRUIT_REQUEST_ID," +
//                " HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_TYPE, HR_RECRUITMENT_REQUEST.NUM_OF_EMPS_APPROVED," +
//                " HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL," +
//                " HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, HR_LU_JOB_TYPE_QUALIFICATION.QUALIFICATION " +
//                " FROM " +
//                " hr_advertisement, hr_recruitment_request, hr_lu_job_type,HR_LU_JOB_TYPE_EDUC_LEVEL,HR_LU_JOB_TYPE_QUALIFICATION " +
//                " WHERE( " +
//                " hr_advertisement.RECRUIT_REQUEST_ID = hr_recruitment_request.RECRUIT_REQUEST_ID " +
//                " AND " +
//                " hr_recruitment_request.JOB_CODE = hr_lu_job_type.job_code " +
//                " AND" +
//                " HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE = hr_lu_job_type.job_code " +
//                " AND" +
//                " HR_LU_JOB_TYPE_QUALIFICATION.JOB_CODE = hr_lu_job_type.job_code" +
//                " AND " +
//                " HR_ADVERTISEMENT.ADVERT_ID = '" + advertID + "')" +
//                " ORDER BY JOB_DESCRIPTION ASC , qualification ASC, EDUCATION_LEVEL ASC";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("advert_date_from", ocrs.getString("advert_date_from"));
                _list[i].put("advert_date_to", ocrs.getString("advert_date_to"));
                _list[i].put("recruit_batch_code", ocrs.getString("recruit_batch_code"));
                _list[i].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                _list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                _list[i].put("RECRUIT_REQUEST_TYPE", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                _list[i].put("NUM_OF_EMPS_APPROVED", ocrs.getString("NUM_OF_EMPS_APPROVED"));
                _list[i].put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                _list[i].put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                _list[i].put("QUALIFICATION", ocrs.getString("QUALIFICATION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("RANK_ID", ocrs.getString("RANK_ID"));
                i++;
            }
            return _list;
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

    public HashMap[] readVacancyPromoRequester(String advertID) {
        HashMap[] _list = null;
        int i = 0;
        String promotionQuerry = " SELECT ei.department_id,NVL(CAST (EXPERIENCE AS INT),0) as EXPERIENCE , " +
                "  EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  PR.ADVERT_ID, " +
                "  EI.JOB_CODE, " +
                "  EI.EMP_ID, " +
                "  PR.STATUS, " +
                "  PR.ID, " +
                "  EI.HIRE_DATE, " +
                "  NVL(PA.INTERVIEW_EXAM_RESULT,'0.0')     AS INTERVIEW_EXAM_RESULT, " +
                "  NVL(PA.OTHER_RESULT,'0.0')              AS OTHER_RESULT, " +
                "  NVL(PA.PRESENTATION_EXAM_RESULT ,'0.0') AS PRESENTATION_EXAM_RESULT, " +
                "  PA.PROMOTION_ASSESSMENT_ID, " +
                "  PR.PROMOTION_REQUEST_ID, " +
                "  PA.RECOMMENDATION, " +
                "  PA.REMARK, " +
                "  PA.STATUS, " +
                "  NVL(PA.WRITTEN_EXAM_RESULT,'0.0') AS WRITTEN_EXAM_RESULT, " +
                "  JT.JOB_DESCRIPTION " +
                " FROM HR_PROMOTION_REQUEST PR, " +
                "  HR_EMPLOYEE_INFO EI, " +
                "  HR_PROMOTION_ASSESSMENT PA, " +
                "  HR_LU_JOB_TYPE JT " +
                " WHERE PR.ID      =PA.PROMOTION_REQUEST_ID(+) " +
                " AND EI.EMP_ID    =PR.REQUESTER_ID " +
                " AND EI.JOB_CODE  =JT.JOB_CODE " +
                " AND PR.ADVERT_ID = '" + advertID + "' " +
                " And PR.status='0'"+
                " ORDER BY EXPERIENCE ASC";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(promotionQuerry);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("EXPERIENCE", ocrs.getString("EXPERIENCE"));
                _list[i].put("FULLNAME", ocrs.getString("FULLNAME"));
                _list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                _list[i].put("EDUC_LEVEL_CODE", "not necessary");
                _list[i].put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                _list[i].put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                _list[i].put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                _list[i].put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                _list[i].put("EDUCATION_TYPE", "not necessary");
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("STATUS", "STATUS");
                _list[i].put("EDUC_TYPE_DISC", "not necessary");
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("PROMOTION_REQUEST_ID", ocrs.getString("PROMOTION_REQUEST_ID"));
                i++;
            }
            return _list;
        } catch (Exception ex) {
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
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public HashMap[] readVacancyPromoRequesterFinalPromotion(String advertID) {
        HashMap[] _list = null;
        int i = 0;
        String promotionQuerry = " SELECT ei.department_id,NVL(CAST (EXPERIENCE AS INT),0) as EXPERIENCE , " +
                "  EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  PR.ADVERT_ID, " +
                "  EI.JOB_CODE, " +
                "  EI.EMP_ID, " +
                "  PR.STATUS, " +
                "  PR.ID, " +
                "  EI.HIRE_DATE, " +
                "  NVL(PA.INTERVIEW_EXAM_RESULT,'0.0')     AS INTERVIEW_EXAM_RESULT, " +
                "  NVL(PA.OTHER_RESULT,'0.0')              AS OTHER_RESULT, " +
                "  NVL(PA.PRESENTATION_EXAM_RESULT ,'0.0') AS PRESENTATION_EXAM_RESULT, " +
                "  PA.PROMOTION_ASSESSMENT_ID, " +
                "  PR.PROMOTION_REQUEST_ID, " +
                "  PA.RECOMMENDATION, " +
                "  PA.REMARK, " +
                "  PA.STATUS, " +
                "  NVL(PA.WRITTEN_EXAM_RESULT,'0.0') AS WRITTEN_EXAM_RESULT, " +
                "  JT.JOB_DESCRIPTION " +
                " FROM HR_PROMOTION_REQUEST PR, " +
                "  HR_EMPLOYEE_INFO EI, " +
                "  HR_PROMOTION_ASSESSMENT PA, " +
                "  HR_LU_JOB_TYPE JT " +
                " WHERE PR.ID      =PA.PROMOTION_REQUEST_ID(+) " +
                " AND EI.EMP_ID    =PR.REQUESTER_ID " +
                " AND EI.JOB_CODE  =JT.JOB_CODE " +
                " AND PR.ADVERT_ID = '" + advertID + "' " +
                " AND PR.status='1' "+
                " ORDER BY EXPERIENCE ASC ";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(promotionQuerry);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("EXPERIENCE", ocrs.getString("EXPERIENCE"));
                _list[i].put("FULLNAME", ocrs.getString("FULLNAME"));
                _list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                _list[i].put("EDUC_LEVEL_CODE", "not necessary");
                _list[i].put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                _list[i].put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                _list[i].put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                _list[i].put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                _list[i].put("EDUCATION_TYPE", "not necessary");
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("STATUS", "STATUS");
                _list[i].put("EDUC_TYPE_DISC", "not necessary");
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("PROMOTION_REQUEST_ID", ocrs.getString("PROMOTION_REQUEST_ID"));
                i++;
            }
            return _list;
        } catch (Exception ex) {
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
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

        public HashMap[] readVacancyPromoRequesterFinalPromotionJustForPromotion(String advertID) {
        HashMap[] _list = null;
        int i = 0;
        String promotionQuerry = " SELECT ei.department_id,NVL(CAST (EXPERIENCE AS INT),0) as EXPERIENCE , " +
                "  EI.FIRST_NAME " +
                "  ||' ' " +
                "  || EI.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  PR.ADVERT_ID, " +
                "  EI.JOB_CODE, " +
                "  EI.EMP_ID, " +
                "  PR.STATUS, " +
                "  PR.ID, " +
                "  EI.HIRE_DATE, " +
                "  NVL(PA.INTERVIEW_EXAM_RESULT,'0.0')     AS INTERVIEW_EXAM_RESULT, " +
                "  NVL(PA.OTHER_RESULT,'0.0')              AS OTHER_RESULT, " +
                "  NVL(PA.PRESENTATION_EXAM_RESULT ,'0.0') AS PRESENTATION_EXAM_RESULT, " +
                "  PA.PROMOTION_ASSESSMENT_ID, " +
                "  PR.PROMOTION_REQUEST_ID, " +
                "  PA.RECOMMENDATION, " +
                "  PA.REMARK, " +
                "  PA.STATUS, " +
                "  NVL(PA.WRITTEN_EXAM_RESULT,'0.0') AS WRITTEN_EXAM_RESULT, " +
                "  JT.JOB_DESCRIPTION " +
                " FROM HR_PROMOTION_REQUEST PR, " +
                "  HR_EMPLOYEE_INFO EI, " +
                "  HR_PROMOTION_ASSESSMENT PA, " +
                "  HR_LU_JOB_TYPE JT " +
                " WHERE PR.ID      =PA.PROMOTION_REQUEST_ID(+) " +
                " AND EI.EMP_ID    =PR.REQUESTER_ID " +
                " AND EI.JOB_CODE  =JT.JOB_CODE " +
                " AND PR.ADVERT_ID = '" + advertID + "' " +
                " AND PR.status='2' "+
                " ORDER BY EXPERIENCE ASC ";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(promotionQuerry);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("EXPERIENCE", ocrs.getString("EXPERIENCE"));
                _list[i].put("FULLNAME", ocrs.getString("FULLNAME"));
                _list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                _list[i].put("EDUC_LEVEL_CODE", "not necessary");
                _list[i].put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                _list[i].put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                _list[i].put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                _list[i].put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                _list[i].put("EDUCATION_TYPE", "not necessary");
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("STATUS", "STATUS");
                _list[i].put("EDUC_TYPE_DISC", "not necessary");
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("PROMOTION_REQUEST_ID", ocrs.getString("PROMOTION_REQUEST_ID"));
                i++;
            }
            return _list;
        } catch (Exception ex) {
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






    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public HashMap[] readVacancyPromoRequesterBasedOnPerformance(String advertID) {
        HashMap[] _list = null;
        int i = 0;

        String select = "select HR_PROMOTION_REQUEST.ADVERT_ID, HR_PROMOTION_REQUEST.REQUESTER_ID, HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID," +
                " HR_PROMOTION_REQUEST.ID, hr_lu_job_type.JOB_DESCRIPTION, HR_EMPLOYEE_INFO.HIRE_DATE, hr_lu_job_type.job_code," +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME," +
                " HR_EMPLOYEE_INFO.JOB_CODE AS JOB_CODE, HR_EMP_EDUCATION.EMP_ID AS EMP_ID, HR_EMP_EDUCATION.EDUC_LEVEL_CODE, HR_EMP_EDUCATION.EDUCATION_TYPE," +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE, HR_LU_EDUC_LEVEL.DESCRIPTION AS EDUC_LEVEL_DISC, HR_LU_EDUC_LEVEL.RANK," +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE, HR_LU_EDUC_TYPE.DESCRIPTION AS EDUC_TYPE_DISC " +
                " FROM " +
                " HR_PROMOTION_REQUEST, hr_lu_job_type, HR_EMPLOYEE_INFO, HR_EMP_EDUCATION, HR_LU_EDUC_LEVEL, HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = '" + advertID + "'" +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                " AND " +
                " HR_EMPLOYEE_INFO.JOB_CODE = hr_lu_job_type.job_code " +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EMP_EDUCATION.EMP_ID" +
                " AND " +
                " HR_PROMOTION_REQUEST.ID = HR_EMP_EDUCATION.ID " +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_EMP_EDUCATION.EDUC_LEVEL_CODE" +
                " AND " +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_EMP_EDUCATION.EDUCATION_TYPE " +
                " ORDER BY RANK ASC ";




        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                _list[i].put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                _list[i].put("LAST_NAME", ocrs.getString("LAST_NAME"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("EDUC_TYPE_DISC", ocrs.getString("EDUC_TYPE_DISC"));
                _list[i].put("EDUC_LEVEL_DISC", ocrs.getString("EDUC_LEVEL_DISC"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("RANK", ocrs.getString("RANK"));
                i++;
            }
            return _list;
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

    public HashMap[] readVacancyPromoRequesterTotalServiceYearEducationLevel(String advertID) {
        HashMap[] _list = null;
        int i = 0;

        String select = "select HR_PROMOTION_REQUEST.ADVERT_ID, HR_PROMOTION_REQUEST.REQUESTER_ID, HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID," +
                " HR_PROMOTION_REQUEST.ID, hr_lu_job_type.JOB_DESCRIPTION, HR_EMPLOYEE_INFO.HIRE_DATE, hr_lu_job_type.job_code," +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME," +
                " HR_EMPLOYEE_INFO.JOB_CODE AS JOB_CODE, HR_EMP_EDUCATION.EMP_ID AS EMP_ID, HR_EMP_EDUCATION.EDUC_LEVEL_CODE, HR_EMP_EDUCATION.EDUCATION_TYPE," +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE, HR_LU_EDUC_LEVEL.DESCRIPTION AS EDUC_LEVEL_DISC, HR_LU_EDUC_LEVEL.RANK," +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE, HR_LU_EDUC_TYPE.DESCRIPTION AS EDUC_TYPE_DISC " +
                " FROM " +
                " HR_PROMOTION_REQUEST, hr_lu_job_type, HR_EMPLOYEE_INFO, HR_EMP_EDUCATION, HR_LU_EDUC_LEVEL, HR_LU_EDUC_TYPE " +
                " WHERE " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = '" + advertID + "'" +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                " AND " +
                " HR_EMPLOYEE_INFO.JOB_CODE = hr_lu_job_type.job_code " +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EMP_EDUCATION.EMP_ID" +
                " AND " +
                " HR_PROMOTION_REQUEST.ID = HR_EMP_EDUCATION.ID " +
                " AND " +
                " HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE = HR_EMP_EDUCATION.EDUC_LEVEL_CODE" +
                " AND " +
                " HR_LU_EDUC_TYPE.EDUC_TYPE_CODE = HR_EMP_EDUCATION.EDUCATION_TYPE " +
                " ORDER BY HIRE_DATE ASC ";



        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list[i].put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                _list[i].put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                _list[i].put("LAST_NAME", ocrs.getString("LAST_NAME"));
                _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("EDUC_LEVEL_DISC", ocrs.getString("EDUC_LEVEL_DISC"));
                _list[i].put("EDUC_TYPE_DISC", ocrs.getString("EDUC_TYPE_DISC"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("RANK", ocrs.getString("RANK"));
                i++;
            }
            return _list;
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

    public boolean addPromotionRequest(ArrayList<HashMap> listOfEvaluation, int committeeId) {
        PreparedStatement _ps = null;
        PreparedStatement _ps1 = null;
        Connection _con = null;
        String advertismentId = null;
        String status = null;
        boolean savingStatus = true;
        boolean firstTime = true;
        int n = 0;
        int check[] = new int[listOfEvaluation.size()];
        try {
            String updatePromoValue = "UPDATE HR_PROMOTION_REQUEST " +
                    " SET STATUS             =?, " +
                    "  EXAMPERCENTAGE        =?, " +
                    "  DISCIPLINEPERCENTAGE  =?, " +
                    "  PERFORMANCEPERCENTAGE =?, " +
                    "  TOTALRESULT           =?,  " +
                    "  DISCIPLINERESULT      =?,  " +
                    "  TOALEXAMRESULT        =?,  " +
                    "  FORWARDED_TO_COMMITTEE        =?,  " +
                    "  PERFORMANCEVALUE      =?  " +
                    " WHERE REQUESTER_ID     =?  " +
                    " AND ADVERT_ID          =?  ";




            String updateAdvert = " UPDATE HR_ADVERTISEMENT SET " +
                    " STATUS = ? " +
                    " WHERE " +
                    " ADVERT_ID = ? ";
            _con = getConnection();
            _con.setAutoCommit(false);
            for (HashMap hm : listOfEvaluation) {
                _ps = _con.prepareStatement(updatePromoValue);
                _ps.setInt(1, 1);
                _ps.setString(2, hm.get("EXAMPERCENTAGE").toString());
                _ps.setString(3, hm.get("DisciplinePercentage").toString());
                _ps.setString(4, hm.get("PromotionPercentage").toString());
                _ps.setString(5, hm.get("PercentTotal").toString());
                _ps.setString(6, hm.get("DisciplineResult").toString());
                _ps.setString(7, hm.get("ToalExamResult").toString());
                _ps.setInt(8, committeeId);
                _ps.setString(9, hm.get("PerformanceValue").toString());
                _ps.setString(10, hm.get("employeeId").toString());
                _ps.setString(11, hm.get("advertID").toString());
                check[n] = _ps.executeUpdate();
                if (firstTime) {
                    advertismentId = hm.get("advertID").toString();
                    status = hm.get("STATUS").toString();
                    firstTime = false;
                }
                n++;
            }
            for (int chek : check) {
                if (chek <= 0) {
                    savingStatus = false;
                    break;
                }
            }
            if (savingStatus) {
                _ps1 = _con.prepareStatement(updateAdvert);
                _ps1.setString(1, "1");
                _ps1.setString(2, advertismentId);
                if (_ps1.executeUpdate() > 0) {
                    _con.commit();
                    return true;
                } else {
                    _con.rollback();
                    return false;
                }
            } else {
                _con.rollback();
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public int addPromotionRequest(String adverID, String empID, String experience, String edulLevel, String educType,
            double expP, double perP, double educLP, double traiP) {

        PreparedStatement _ps = null;
        PreparedStatement _ps1 = null;
        Connection _con = null;

        String updatePromoValue = " UPDATE HR_PROMOTION_REQUEST " +
                " SET EDUC_LEVEL_CODE = ?, EDUC_TYPE_CODE =?, EXPERIENCE =?, STATUS = ?," +
                " PERCENT_EL = ?, PERCENT_EX = ?, PERCENT_PR = ?, PERCENT_TR = ?" +
                " WHERE" +
                " ADVERT_ID = ?" +
                " AND " +
                " REQUESTER_ID = ? ";
        String updateAdvert = " UPDATE HR_ADVERTISEMENT SET " +
                " STATUS = ? " +
                " WHERE " +
                " ADVERT_ID = ? ";
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            _ps =
                    _con.prepareStatement(updatePromoValue);
            _ps.setString(1, edulLevel);
            _ps.setString(2, educType);
            _ps.setString(3, experience);
            _ps.setInt(4, 1);
            _ps.setString(5, String.valueOf(educLP));
            _ps.setString(6, String.valueOf(expP));
            _ps.setString(7, String.valueOf(perP));
            _ps.setString(8, String.valueOf(traiP));
            _ps.setString(9, adverID);
            _ps.setString(10, empID);
            _ps1 =
                    _con.prepareStatement(updateAdvert);
            _ps1.setString(1, "1");
            _ps1.setString(2, adverID);
            if (_ps.executeUpdate() != 0 && _ps1.executeUpdate() != 0) {
                _con.commit();
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            return 0;
        } finally {
            try {
                _ps.close();
                _ps1.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int approvePromotionRequest(String adverID, String empID) {

        PreparedStatement _ps = null;
        PreparedStatement _ps1 = null;
        Connection _con = null;

        String insEvaCrt = " UPDATE HR_PROMOTION_REQUEST " +
                " SET  STATUS = ?" +
                " WHERE " +
                " ADVERT_ID = ?" +
                " AND " +
                " REQUESTER_ID = ? ";

        String updateAdvert = " UPDATE HR_ADVERTISEMENT SET " +
                " STATUS = ? " +
                " WHERE " +
                " ADVERT_ID = ? ";

        try {
            _con = getConnection();
            _con.setAutoCommit(false);


            _ps =
                    _con.prepareStatement(insEvaCrt);
            _ps.setInt(1, 2);
            _ps.setString(2, adverID);
            _ps.setString(3, empID);

            _ps1 =
                    _con.prepareStatement(updateAdvert);

            _ps1.setString(1, "2");
            _ps1.setString(2, adverID);


            if (_ps.executeUpdate() != 0 && _ps1.executeUpdate() != 0) {
                _con.commit();
                return 1;

            } else {
                return 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            return 0;
        } finally {
            try {
                _ps.close();
                _ps1.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int rejectPromotionRequest(String adverID, String empID) {

        PreparedStatement _ps = null;
        PreparedStatement _ps1 = null;
        ResultSet _rs = null;
        Connection _con = null;

        String insEvaCrt = " UPDATE HR_PROMOTION_REQUEST " +
                " SET  STATUS = ?" +
                " WHERE" +
                " ADVERT_ID = ?" +
                " AND " +
                " REQUESTER_ID = ? ";

        String updateAdvert = " UPDATE HR_ADVERTISEMENT SET " +
                " STATUS = ? " +
                " WHERE " +
                " ADVERT_ID = ? ";

        try {
            _con = getConnection();
            _con.setAutoCommit(false);

            _ps =
                    _con.prepareStatement(insEvaCrt);
            _ps.setInt(1, 3);
            _ps.setString(2, adverID);
            _ps.setString(3, empID);

            _ps1 =
                    _con.prepareStatement(updateAdvert);

            _ps1.setString(1, "3");
            _ps1.setString(2, adverID);


            if (_ps.executeUpdate() != 0 && _ps1.executeUpdate() != 0) {
                _con.commit();
                return 1;

            } else {
                return 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readPromotionRequestsList(String advertID) {
        HashMap[] _list = null;
        int i = 0;
        String select = "SELECT HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "  HR_PROMOTION_REQUEST.REQUESTER_ID," +
                "nvl(HR_PROMOTION_REQUEST.EXPERIENCE,'0') as EXPERIENCE ,  " +
                "  HR_PROMOTION_REQUEST.ID, " +
                "  HR_PROMOTION_REQUEST.EXAMPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.TOTALRESULT, " +
                "  HR_EMPLOYEE_INFO.HIRE_DATE, " +
                "  HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID, " +
                "  HR_PROMOTION_REQUEST.STATUS, " +
                "  HR_EMPLOYEE_INFO.DEPARTMENT_ID as dep, " +
                "  HR_PROMOTION_REQUEST.PERCENT_TR, " +
                "  HR_EMPLOYEE_INFO.EMP_ID, " +
                "  HR_LU_JOB_TYPE.JOB_DESCRIPTION, " +
                "  HR_EMPLOYEE_INFO.FIRST_NAME " +
                "  || ' ' " +
                "  || HR_EMPLOYEE_INFO.MIDDLE_NAME " +
                "  || ' ' " +
                "  || HR_EMPLOYEE_INFO.LAST_NAME AS FULLNAME, " +
                "  HR_PROMOTION_ASSESSMENT.INTERVIEW_EXAM_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.OTHER_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.PRESENTATION_EXAM_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.WRITTEN_EXAM_RESULT, " +
                "  hr_recruitment_request.department_id, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                          AS EXAMEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                    AS DISCIPLINEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                   AS PERFORMANCEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + " +
                "  ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + " +
                "  ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                " FROM HR_PROMOTION_REQUEST, " +
                "  HR_EMPLOYEE_INFO, " +
                "  HR_ADVERTISEMENT, " +
                "  HR_RECRUITMENT_REQUEST , " +
                "  HR_PROMOTION_ASSESSMENT, " +
                "  HR_LU_JOB_TYPE " +
                "WHERE HR_PROMOTION_REQUEST.ADVERT_ID            = '" + advertID + "' " +
                "AND HR_EMPLOYEE_INFO.EMP_ID                     = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                "AND HR_PROMOTION_REQUEST.ADVERT_ID              =HR_ADVERTISEMENT.ADVERT_ID " +
                "AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE         =HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE " +
                "AND HR_PROMOTION_ASSESSMENT.PROMOTION_REQUEST_ID=HR_PROMOTION_REQUEST.ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                     =HR_EMPLOYEE_INFO.JOB_CODE " +
                "ORDER BY EMPLOYEETOTALRESULT DESC";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("EXAMPERCENTAGE", ocrs.getString("EXAMPERCENTAGE"));
                _list[i].put("DISCIPLINEPERCENTAGE", ocrs.getString("DISCIPLINEPERCENTAGE"));
                _list[i].put("PERFORMANCEPERCENTAGE", ocrs.getString("PERFORMANCEPERCENTAGE"));
                _list[i].put("TOTALRESULT", ocrs.getString("TOTALRESULT"));
                _list[i].put("EXPERIENCE", ocrs.getString("HIRE_DATE"));
                _list[i].put("EXPERIENCEREL", ocrs.getString("EXPERIENCE"));
                _list[i].put("PROMOTION_REQUEST_ID", ocrs.getString("PROMOTION_REQUEST_ID"));
                _list[i].put("STATUS", ocrs.getString("STATUS"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("FULLNAME", ocrs.getString("FULLNAME"));
                _list[i].put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                _list[i].put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                _list[i].put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                _list[i].put("department_id", ocrs.getString("department_id"));
                _list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                _list[i].put("EXAMEPERCENTAGERESULT", ocrs.getString("EXAMEPERCENTAGERESULT"));
                _list[i].put("DISCIPLINEPERCENTAGERESULT", ocrs.getString("DISCIPLINEPERCENTAGERESULT"));
                _list[i].put("PERFORMANCEPERCENTAGERESULT", ocrs.getString("PERFORMANCEPERCENTAGERESULT"));
                _list[i].put("EMPLOYEETOTALRESULT", ocrs.getString("EMPLOYEETOTALRESULT"));
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                i++;
            }
            return _list;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }

        }

    }

    public HashMap[] readPromotionRequestsForApprovement(String advertID) {
        HashMap[] _list = null;
        boolean checkResult = false;
        boolean firstTime = true;
        int i = 0;
        String select = "SELECT HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "  HR_PROMOTION_REQUEST.REQUESTER_ID, " +
                "  HR_PROMOTION_REQUEST.ID, " +
                "  HR_PROMOTION_REQUEST.EXAMPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE, " +
                "  HR_PROMOTION_REQUEST.TOTALRESULT, " +
                "  HR_EMPLOYEE_INFO.HIRE_DATE, " +
                "  HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID, " +
                "  HR_PROMOTION_REQUEST.STATUS, " +
                "  HR_EMPLOYEE_INFO.DEPARTMENT_ID as dep, " +
                "  HR_PROMOTION_REQUEST.PERCENT_TR, " +
                "  HR_EMPLOYEE_INFO.EMP_ID, " +
                "  HR_LU_JOB_TYPE.JOB_DESCRIPTION, " +
                "  HR_EMPLOYEE_INFO.FIRST_NAME " +
                "  || ' ' " +
                "  || HR_EMPLOYEE_INFO.MIDDLE_NAME " +
                "  || ' ' " +
                "  || HR_EMPLOYEE_INFO.LAST_NAME AS FULLNAME, " +
                "  HR_PROMOTION_ASSESSMENT.INTERVIEW_EXAM_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.OTHER_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.PRESENTATION_EXAM_RESULT, " +
                "  HR_PROMOTION_ASSESSMENT.WRITTEN_EXAM_RESULT, " +
                "  hr_recruitment_request.department_id, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                          AS EXAMEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                    AS DISCIPLINEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                   AS PERFORMANCEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + " +
                "  ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + " +
                "  ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                " FROM HR_PROMOTION_REQUEST, " +
                "  HR_EMPLOYEE_INFO, " +
                "  HR_ADVERTISEMENT, " +
                "  HR_RECRUITMENT_REQUEST , " +
                "  HR_PROMOTION_ASSESSMENT, " +
                "  HR_LU_JOB_TYPE " +
                "WHERE HR_PROMOTION_REQUEST.ADVERT_ID            = '" + advertID + "' " +
                "AND HR_EMPLOYEE_INFO.EMP_ID                     = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                "AND HR_PROMOTION_REQUEST.ADVERT_ID              =HR_ADVERTISEMENT.ADVERT_ID " +
                "AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE         =HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE " +
                "AND HR_PROMOTION_ASSESSMENT.PROMOTION_REQUEST_ID=HR_PROMOTION_REQUEST.ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE                     =HR_EMPLOYEE_INFO.JOB_CODE " +
                "ORDER BY EMPLOYEETOTALRESULT DESC";

        String selectQueary = "SELECT PROMOTION.* " +
                "FROM " +
                "  (SELECT HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "    HR_PROMOTION_REQUEST.REQUESTER_ID, " +
                "    HR_PROMOTION_REQUEST.ID, " +
                "    HR_PROMOTION_REQUEST.EXAMPERCENTAGE, " +
                "    HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE, " +
                "    HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE, " +
                "    HR_PROMOTION_REQUEST.TOTALRESULT, " +
                "    HR_EMPLOYEE_INFO.HIRE_DATE, " +
                "    HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID, " +
                "    HR_PROMOTION_REQUEST.STATUS, " +
                "    HR_EMPLOYEE_INFO.DEPARTMENT_ID AS dep, " +
                "    HR_PROMOTION_REQUEST.PERCENT_TR, " +
                "    HR_EMPLOYEE_INFO.EMP_ID, " +
                "    HR_LU_JOB_TYPE.JOB_DESCRIPTION, " +
                "    HR_EMPLOYEE_INFO.FIRST_NAME " +
                "    || ' ' " +
                "    || HR_EMPLOYEE_INFO.MIDDLE_NAME " +
                "    || ' ' " +
                "    || HR_EMPLOYEE_INFO.LAST_NAME AS FULLNAME, " +
                "    HR_PROMOTION_ASSESSMENT.INTERVIEW_EXAM_RESULT, " +
                "    HR_PROMOTION_ASSESSMENT.OTHER_RESULT, " +
                "    HR_PROMOTION_ASSESSMENT.PRESENTATION_EXAM_RESULT, " +
                "    HR_PROMOTION_ASSESSMENT.WRITTEN_EXAM_RESULT, " +
                "    hr_recruitment_request.department_id, " +
                "    HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "    ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                          AS EXAMEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                    AS DISCIPLINEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                   AS PERFORMANCEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                "  FROM HR_PROMOTION_REQUEST, " +
                "    HR_EMPLOYEE_INFO, " +
                "    HR_ADVERTISEMENT, " +
                "    HR_RECRUITMENT_REQUEST , " +
                "    HR_PROMOTION_ASSESSMENT, " +
                "    HR_LU_JOB_TYPE " +
                "  WHERE HR_PROMOTION_REQUEST.ADVERT_ID            = '" + advertID + "' " +
                "  AND HR_EMPLOYEE_INFO.EMP_ID                     = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                "  AND HR_PROMOTION_REQUEST.ADVERT_ID              =HR_ADVERTISEMENT.ADVERT_ID " +
                "  AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE         =HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE " +
                "  AND HR_PROMOTION_ASSESSMENT.PROMOTION_REQUEST_ID=HR_PROMOTION_REQUEST.ID " +
                "  AND HR_LU_JOB_TYPE.JOB_CODE                     =HR_EMPLOYEE_INFO.JOB_CODE " +
                "  ORDER BY EMPLOYEETOTALRESULT DESC " +
                "  ) PROMOTION " +
                "WHERE PROMOTION.EMPLOYEETOTALRESULT >= 50";

        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        ResultSet _rs1 = null;
        PreparedStatement _ps1 = null;
        try {
            _con = getConnection();
            _ps1 = _con.prepareStatement(select);
            _rs1 = _ps1.executeQuery();
            if (_rs1.next()) {
                checkResult = true;
            }
            _ps1.close();
            _rs1.close();
            _ps = _con.prepareStatement(selectQueary);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                checkResult = false;
                _list[i] = new HashMap();
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                _list[i].put("ID", ocrs.getString("ID"));
                _list[i].put("EXAMPERCENTAGE", ocrs.getString("EXAMPERCENTAGE"));
                _list[i].put("DISCIPLINEPERCENTAGE", ocrs.getString("DISCIPLINEPERCENTAGE"));
                _list[i].put("PERFORMANCEPERCENTAGE", ocrs.getString("PERFORMANCEPERCENTAGE"));
                _list[i].put("TOTALRESULT", ocrs.getString("TOTALRESULT"));
                _list[i].put("EXPERIENCE", ocrs.getString("HIRE_DATE"));
                _list[i].put("PROMOTION_REQUEST_ID", ocrs.getString("PROMOTION_REQUEST_ID"));
                _list[i].put("STATUS", ocrs.getString("STATUS"));
                _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                _list[i].put("FULLNAME", ocrs.getString("FULLNAME"));
                _list[i].put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                _list[i].put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                _list[i].put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                _list[i].put("department_id", ocrs.getString("department_id"));
                _list[i].put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                _list[i].put("EXAMEPERCENTAGERESULT", ocrs.getString("EXAMEPERCENTAGERESULT"));
                _list[i].put("DISCIPLINEPERCENTAGERESULT", ocrs.getString("DISCIPLINEPERCENTAGERESULT"));
                _list[i].put("PERFORMANCEPERCENTAGERESULT", ocrs.getString("PERFORMANCEPERCENTAGERESULT"));
                _list[i].put("EMPLOYEETOTALRESULT", ocrs.getString("EMPLOYEETOTALRESULT"));
                _list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                _list[i].put("HIRE_DATE", ocrs.getString("HIRE_DATE"));
                _list[i].put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                if (firstTime) {
                    _list[i].put("result", "Found");
                    firstTime = false;
                }
                i++;
            }
            if (!checkResult) {
                return _list;
            } else {
                _list = new HashMap[1];
                _list[i] = new HashMap();
                if (checkResult) {
                    _list[i] = new HashMap();
                    _list[i].put("result", "NoOneIsQualified");
                    return _list;
                } else {
                    _list[i] = new HashMap();
                    _list[i].put("result", "notFound");
                    return _list;
                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
                ignore.printStackTrace();
            }

        }

    }

    public HashMap readPersonalInfoForPromotion(String empID, String departmentId) {
        HashMap _list = new HashMap();
        int i = 0;
        String select = "SELECT HR_EMPLOYEE_INFO.EMP_ID, " +
                "  HR_EMPLOYEE_INFO.JOB_CODE, " +
                "  HR_EMPLOYEE_INFO.RANK_ID, " +
                "  HR_EMPLOYEE_INFO.PAY_GRADE, " +
                "  HR_LU_JOB_TYPE.JOB_CODE AS JOB_CODE , " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_RANK.RANK_ID AS RANK_ID, " +
                "  HR_LU_RANK.RANK_DESCRIPTION, " +
                "  HR_LU_PAY_GRAD.ID_PAY_GRADE, " +
                "  HR_LU_PAY_GRAD.STEP_NO, " +
                "  HR_LU_PAY_GRAD.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_EMPLOYEE_INFO.DEPARTMENT_ID, " +
                "  (SELECT sys_connect_by_path( TBL_DEPT_BUNNA.DEP_DESCRIPTION,'[' ) AS DESCRIPTION " +
                "  FROM TBL_DEPT_BUNNA " +
                "  WHERE DEPT_ID                            =" + departmentId + " " +
                "    START WITH TBL_DEPT_BUNNA.DEPT_ID      =1 " +
                "    CONNECT BY PRIOR TBL_DEPT_BUNNA.DEPT_ID=BRANCH_ID " +
                "  ) AS department " +
                "FROM HR_EMPLOYEE_INFO, " +
                "  HR_LU_JOB_TYPE, " +
                "  HR_LU_RANK, " +
                "  HR_LU_PAY_GRAD " +
                "WHERE HR_EMPLOYEE_INFO.EMP_ID  = '" + empID + "' " +
                "AND HR_EMPLOYEE_INFO.JOB_CODE  = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_EMPLOYEE_INFO.RANK_ID   = HR_LU_RANK.RANK_ID " +
                "AND HR_EMPLOYEE_INFO.PAY_GRADE = HR_LU_PAY_GRAD.STEP_NO " +
                "AND HR_LU_RANK.RANK_ID         = HR_LU_PAY_GRAD.RANK_ID";


        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                _list.put("JOB_CODE", ocrs.getString("JOB_CODE"));
                _list.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                _list.put("RANK_ID", ocrs.getString("RANK_ID"));
                _list.put("RANK_DESCRIPTION", ocrs.getString("RANK_DESCRIPTION"));
                _list.put("ID_PAY_GRADE", ocrs.getString("ID_PAY_GRADE"));
                _list.put("STEP_NO", ocrs.getString("STEP_NO"));
                _list.put("SALARY", ocrs.getString("SALARY"));
                _list.put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                _list.put("department", ocrs.getString("department"));
                return _list;
            } else {
                return null;
            }



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

    public int insertAdvertisementInfo(AdvertisementEntity saveAdvertisement, int idicator, String requestID) {
        String insert = "INSERT INTO hr_advertisement(prepared_Date," +
                " advert_Date_From, advert_Date_To, recruit_Batch_Code, PREPAREDBY, RECRUIT_REQUEST_ID) VALUES(?,?,?,?,?,?)";
        String update = "update HR_RECRUITMENT_REQUEST_STATUS SET ADVERTISE='1' where RECRUIT_REQUEST_ID='" + requestID + "'";
        String insertMinfo = "INSERT INTO hr_media_type(media_Type_Code,occurrence,advert_Id)" +
                " VALUES(?,?,HR_ADVERTISEMENT_0.currval)";
        String insertMinfoSec = "INSERT INTO hr_media_type(media_Type_Code,occurrence,advert_Id)" +
                " VALUES(?,?,?)";
        String max = "SELECT MAX(ADVERT_ID) AS advert_Id " +
                " FROM HR_ADVERTISEMENT";


        Connection _con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        PreparedStatement ps3 = null;
        PreparedStatement ps4 = null;
        ResultSet maxIDReturned = null;
        int saveCheck = 0;

        String maxID = "";
        try {

            _con = getConnection();

            if (idicator == 0) {

                _con.setAutoCommit(false);
                ps =
                        _con.prepareStatement(insert);
                ps1 =
                        _con.prepareStatement(update);
                ps.setString(1, saveAdvertisement.getPreparedDate());
                ps.setString(2, saveAdvertisement.getAdvertisementDateFrom());
                ps.setString(3, saveAdvertisement.getAdvertisementDateTo());
                ps.setString(4, saveAdvertisement.getRecruitmentBatchCode());
                ps.setString(5, saveAdvertisement.getPreparedBy());
                ps.setInt(6, Integer.valueOf(requestID));

                if (ps.executeUpdate() != 0 && ps1.executeUpdate() != 0) {
                    ps2 = _con.prepareStatement(insertMinfo);
                    ps2.setString(1, saveAdvertisement.getMediaTypes());
                    ps2.setString(2, saveAdvertisement.getOccurrence());
                    saveCheck =
                            ps2.executeUpdate();
                    if (saveCheck == 1) {
                        _con.commit();
                        return saveCheck;

                    } else {
                        return saveCheck;
                    }

                }


            } else if (idicator > 0) {

                _con.setAutoCommit(false);
                ps3 =
                        _con.prepareStatement(max);
                maxIDReturned =
                        ps3.executeQuery();
                if (maxIDReturned.next()) {
                    maxID = maxIDReturned.getString("advert_Id");
                }

                if (ps3.executeUpdate() != 0) {
                    ps4 = _con.prepareStatement(insertMinfoSec);
                    ps4.setString(3, maxID);
                    ps4.setString(1, saveAdvertisement.getMediaTypes());
                    ps4.setString(2, saveAdvertisement.getOccurrence());
                    saveCheck =
                            ps4.executeUpdate();
                    if (saveCheck == 1) {

                        _con.commit();
                        return saveCheck;

                    } else {
                        return saveCheck;
                    }

                }


            }
            return saveCheck;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                maxIDReturned.close();
                ps.close();
                ps1.close();
                ps2.close();
                ps3.close();
                ps4.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int insertInsideAdvertisementInfo(String preparedDate, String advertisementDateFrom, String advertisementDateTo, String preparedBy, String recruitmentBatchCode, String advertType, String requestID) {
        String insert = "INSERT INTO hr_advertisement(prepared_Date," +
                " advert_Date_From, advert_Date_To, recruit_Batch_Code, PREPAREDBY, RECRUIT_REQUEST_ID, ADVERTISEMENT_TYPE) VALUES(?,?,?,?,?,?,?)";
        String update = "update HR_RECRUITMENT_REQUEST_STATUS SET ADVERTISE='1' where RECRUIT_REQUEST_ID='" + requestID + "'";

        Connection _con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;

        int saveCheck = 0;


        try {

            _con = getConnection();
            _con.setAutoCommit(false);
            ps =
                    _con.prepareStatement(insert);
            ps1 =
                    _con.prepareStatement(update);
            ps.setString(1, preparedDate);
            ps.setString(2, advertisementDateFrom);
            ps.setString(3, advertisementDateTo);
            ps.setString(4, recruitmentBatchCode);
            ps.setString(5, preparedBy);
            ps.setInt(6, Integer.valueOf(requestID));
            ps.setString(7, advertType);

            if (ps.executeUpdate() != 0 && ps1.executeUpdate() != 0) {
                saveCheck = 1;
                if (saveCheck == 1) {
                    _con.commit();
                    return saveCheck;
                }

            }

            return saveCheck;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {

                ps.close();
                ps1.close();

                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readAdverisementMediaDetail(String recruitmentID, String advertType) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        HashMap[] list = null;
        int i = 0;
        String str = "SELECT DISTINCT HR_ADVERTISEMENT.ADVERT_ID AS ADVERT_ID, HR_ADVERTISEMENT.PREPARED_DATE, HR_ADVERTISEMENT.ADVERT_DATE_FROM," +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO, HR_ADVERTISEMENT.RECRUIT_BATCH_CODE, HR_ADVERTISEMENT.PREPAREDBY," +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_ADVERTISEMENT.ADVERTISEMENT_TYPE, HR_MEDIA_TYPE.MEDIA_TYPE_ID, " +
                " HR_MEDIA_TYPE.MEDIA_TYPE_CODE AS MEDIA_TYPE_CODE, HR_MEDIA_TYPE.OCCURRENCE," +
                " HR_MEDIA_TYPE.ADVERT_ID, HR_LU_MEDIA_TYPE.MEDIA_TYPE_CODE AS MEDIA_TYPE_CODE1, HR_LU_MEDIA_TYPE.DESCRIPTION " +
                " FROM  " +
                " HR_RECRUITMENT_REQUEST, HR_ADVERTISEMENT, HR_MEDIA_TYPE, HR_LU_MEDIA_TYPE " +
                " WHERE " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = '" + recruitmentID + "' " +
                " AND " +
                " HR_ADVERTISEMENT.ADVERT_ID = HR_MEDIA_TYPE.ADVERT_ID " +
                " AND " +
                " HR_MEDIA_TYPE.MEDIA_TYPE_CODE = HR_LU_MEDIA_TYPE.DESCRIPTION ";

        String str1 = "SELECT DISTINCT HR_ADVERTISEMENT.ADVERT_ID AS ADVERT_ID, HR_ADVERTISEMENT.PREPARED_DATE, HR_ADVERTISEMENT.ADVERT_DATE_FROM," +
                " HR_ADVERTISEMENT.ADVERT_DATE_TO, HR_ADVERTISEMENT.RECRUIT_BATCH_CODE, HR_ADVERTISEMENT.PREPAREDBY," +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID, HR_ADVERTISEMENT.ADVERTISEMENT_TYPE " +
                " FROM  " +
                " HR_RECRUITMENT_REQUEST, HR_ADVERTISEMENT " +
                " WHERE " +
                " HR_ADVERTISEMENT.RECRUIT_REQUEST_ID = '" + recruitmentID + "' ";
        try {
            _con = getConnection();
            if (advertType.equals("Outside")) {
                _ps = _con.prepareStatement(str);
                _rs =
                        _ps.executeQuery();
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                _rs.close();
                list = new HashMap[ocrs.size()];
                while (ocrs.next()) {
                    list[i] = new HashMap();
                    list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                    list[i].put("PREPARED_DATE", ocrs.getString("PREPARED_DATE"));
                    list[i].put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    list[i].put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    list[i].put("RECRUIT_BATCH_CODE", ocrs.getString("RECRUIT_BATCH_CODE"));
                    list[i].put("PREPAREDBY", ocrs.getString("PREPAREDBY"));
                    list[i].put("MEDIA_TYPE_ID", ocrs.getString("MEDIA_TYPE_ID"));
                    list[i].put("MEDIA_TYPE_CODE", ocrs.getString("MEDIA_TYPE_CODE"));
                    list[i].put("OCCURRENCE", ocrs.getString("OCCURRENCE"));
                    list[i].put("MEDIA_TYPE_CODE1", ocrs.getString("MEDIA_TYPE_CODE1"));
                    list[i].put("ADVERTISEMENT_TYPE", ocrs.getString("ADVERTISEMENT_TYPE"));
                    i++;
                }
            } else if (advertType.equals("Inside")) {
                _ps = _con.prepareStatement(str1);
                _rs = _ps.executeQuery();
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                _rs.close();
                list = new HashMap[ocrs.size()];
                while (ocrs.next()) {
                    list[i] = new HashMap();
                    list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                    list[i].put("PREPARED_DATE", ocrs.getString("PREPARED_DATE"));
                    list[i].put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    list[i].put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    list[i].put("RECRUIT_BATCH_CODE", ocrs.getString("RECRUIT_BATCH_CODE"));
                    list[i].put("PREPAREDBY", ocrs.getString("PREPAREDBY"));
                    list[i].put("ADVERTISEMENT_TYPE", ocrs.getString("ADVERTISEMENT_TYPE"));
                    i++;
                }
            }
            return list;
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

    public int UpdateAdvertisementInfo(AdvertisementEntity saveAdvertisement, String mediaID, String advertID) {
        String update = "UPDATE hr_advertisement SET prepared_Date = ?," +
                " advert_Date_From = ?," +
                " advert_Date_To = ?," +
                " recruit_Batch_Code =  ?, " +
                " PREPAREDBY = ? " +
                " WHERE ADVERT_ID = '" + advertID + "' ";

        String insertMinfo = "UPDATE hr_media_type " +
                " SET media_Type_Code = ?, " +
                " occurrence = ? " +
                " WHERE MEDIA_TYPE_ID = '" + mediaID + "' ";
        Connection _con = null;
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        ResultSet maxIDReturned = null;
        int saveCheck = 0;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            ps = _con.prepareStatement(update);
            ps.setString(1, saveAdvertisement.getPreparedDate());
            ps.setString(2, saveAdvertisement.getAdvertisementDateFrom());
            ps.setString(3, saveAdvertisement.getAdvertisementDateTo());
            ps.setString(4, saveAdvertisement.getRecruitmentBatchCode());
            ps.setString(5, saveAdvertisement.getPreparedBy());
            if (ps.executeUpdate() != 0) {
                ps1 = _con.prepareStatement(insertMinfo);
                ps1.setString(1, saveAdvertisement.getMediaTypes());
                ps1.setString(2, saveAdvertisement.getOccurrence());
                saveCheck = ps1.executeUpdate();
                if (saveCheck == 1) {
                    _con.commit();
                    return saveCheck;

                } else {
                    return saveCheck;
                }

            }
            return saveCheck;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                maxIDReturned.close();
                ps.close();
                ps1.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readPromotionRequestsStat(String advertID) {
        HashMap[] _list = null;
        int i = 0;
        String select = " SELECT * " +
                " FROM " +
                " HR_ADVERTISEMENT " +
                " WHERE " +
                " ADVERT_ID = '" + advertID + "'";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps =
                    _con.prepareStatement(select);
            _ps.executeQuery();
            _rs =
                    _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _list = new HashMap[ocrs.size()];
            while (ocrs.next()) {
                _list[i] = new HashMap();
                _list[i].put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list[i].put("STATUS", ocrs.getString("STATUS"));
                i++;
            }


            return _list;
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

    public boolean checkRequestFPromotion(String advertID, String requesterID) {
        String select = " Select * " +
                " FROM " +
                " HR_PROMOTION_REQUEST" +
                " WHERE " +
                " HR_PROMOTION_REQUEST.ADVERT_ID = '" + advertID + "' " +
                " AND" +
                " HR_PROMOTION_REQUEST.REQUESTER_ID = '" + requesterID + "'";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps =
                    _con.prepareStatement(select);
            _ps.executeQuery();
            _rs =
                    _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            if (ocrs.size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }

    }

    public boolean checkPromotedEmp(String advertID, String empID) {

        String select = " Select * " +
                " FROM " +
                " HR_EMP_PROMOTION" +
                " WHERE " +
                " HR_EMP_PROMOTION.ADVERT_ID = '" + advertID + "' " +
                " AND" +
                " HR_EMP_PROMOTION.EMP_ID = '" + empID + "'";



        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            if (ocrs.size() > 0) {
                return true;
            } else {
                return false;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;


        }

    }

    public int educLevelEmp(String emp_Id) {
        String select = "SELECT  max(to_number(EDUC_LEVEL_CODE))as EDUC_LEVEL_CODE from hrms.hr_emp_education where emp_id = '" + emp_Id + "'";
        int educLevel = -1;
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                educLevel = ocrs.getInt("EDUC_LEVEL_CODE");
            }
            return educLevel;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return educLevel;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int educLevelEducLevelresult(String rank_id, int educLevelId) {
        String select = "select EDUC_RESULT from hr_lu_promotion where rank=" + rank_id + " and EDUC_LEVEL=" + educLevelId + "";
        int educLevel = -1;
        int rank = Integer.parseInt(rank_id);
        if (rank > 12) {
            educLevel = 30;
        } else if (rank > 7) {
            educLevel = 25;
        } else if (rank > 1) {
            educLevel = 20;
        }
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            while (ocrs.next()) {
                educLevel = ocrs.getInt("EDUC_RESULT");
            }
            return educLevel;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return educLevel;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ResultSet selectPerformanceValueByEmployee(String requesterIDforDiscipline) throws SQLException {
        String _selectQuery = " SELECT SESSION_ID, " +
                "  EVALUATOR_EMP_ID, " +
                "  EVALUTED_EMP_ID, " +
                "  PERCENT_VALUE, " +
                "  TOTAL_VALUE, " +
                "  AVERAGE_VALUE, " +
                "  RESULT_SAVED_DATE " +
                " FROM HR_EVALUATION_PERCENT_VALUE " +
                " WHERE EVALUTED_EMP_ID= ?";

                    try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, requesterIDforDiscipline);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
