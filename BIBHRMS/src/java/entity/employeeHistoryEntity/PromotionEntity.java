/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class PromotionEntity extends ConnectionManager {

    private int promotionId;
    private String empFullName;
    private String empId;
    private String promotionDate;
    private String promotionType;
    private String rankFrom;
    private String rankTo;
    private String stepFrom;
    private String stepTo;
    private String salaryFrom;
    private String salaryTo;
    private String refNo;
    private String refDate;
    private String reason;
    private String promoterID;
    private String jobCodeFrom;
    private String jobCodeTo;
    private int adverID;
    private String department = null;
    private String departmentFrom;
    private String departmentTo;

    public String getDepartmentFrom() {
        return departmentFrom;
    }

    public void setDepartmentFrom(String departmentFrom) {
        this.departmentFrom = departmentFrom;
    }

    public String getDepartmentTo() {
        return departmentTo;
    }

    public void setDepartmentTo(String departmentTo) {
        this.departmentTo = departmentTo;
    }

    public String getDirectorate() {
        return department;
    }

    public void setDirectorate(String directorate) {
        this.department = directorate;
    }

    /**
     * @return the adverID
     */
    public int getAdverID() {
        return adverID;
    }

    /**
     * @param adverID the adverID to set
     */
    public void setAdverID(int adverID) {
        this.adverID = adverID;
    }

    /**
     * @return the promoterID
     */
    public String getPromoterID() {
        return promoterID;
    }

    /**
     * @param promoterID the promoterID to set
     */
    public void setPromoterID(String promoterID) {
        this.promoterID = promoterID;
    }

    /**
     * @return the jobCodeFrom
     */
    public String getJobCodeFrom() {
        return jobCodeFrom;
    }

    /**
     * @param jobCodeFrom the jobCodeFrom to set
     */
    public void setJobCodeFrom(String jobCodeFrom) {
        this.jobCodeFrom = jobCodeFrom;
    }

    /**
     * @return the jobCodeTo
     */
    public String getJobCodeTo() {
        return jobCodeTo;
    }

    /**
     * @param jobCodeTo the jobCodeTo to set
     */
    public void setJobCodeTo(String jobCodeTo) {
        this.jobCodeTo = jobCodeTo;
    }

    /**
     * @return the promotionId
     */
    public int getPromotionId() {
        return promotionId;
    }

    /**
     * @param promotionId the promotionId to set
     */
    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    /**
     * @return the empFullName
     */
    public String getEmpFullName() {
        return empFullName;
    }

    /**
     * @param empFullName the empFullName to set
     */
    public void setEmpFullName(String empFullName) {
        this.empFullName = empFullName;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the promotionDate
     */
    public String getPromotionDate() {
        return promotionDate;
    }

    /**
     * @param promotionDate the promotionDate to set
     */
    public void setPromotionDate(String promotionDate) {
        this.promotionDate = promotionDate;
    }

    /**
     * @return the promotionType
     */
    public String getPromotionType() {
        return promotionType;
    }

    /**
     * @param promotionType the promotionType to set
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }

    /**
     * @return the rankFrom
     */
    public String getRankFrom() {
        return rankFrom;
    }

    /**
     * @param rankFrom the rankFrom to set
     */
    public void setRankFrom(String rankFrom) {
        this.rankFrom = rankFrom;
    }

    /**
     * @return the rankTo
     */
    public String getRankTo() {
        return rankTo;
    }

    /**
     * @param rankTo the rankTo to set
     */
    public void setRankTo(String rankTo) {
        this.rankTo = rankTo;
    }

    /**
     * @return the stepFrom
     */
    public String getStepFrom() {
        return stepFrom;
    }

    /**
     * @param stepFrom the stepFrom to set
     */
    public void setStepFrom(String stepFrom) {
        this.stepFrom = stepFrom;
    }

    /**
     * @return the stepTo
     */
    public String getStepTo() {
        return stepTo;
    }

    /**
     * @param stepTo the stepTo to set
     */
    public void setStepTo(String stepTo) {
        this.stepTo = stepTo;
    }

    /**
     * @return the salaryFrom
     */
    public String getSalaryFrom() {
        return salaryFrom;
    }

    /**
     * @param salaryFrom the salaryFrom to set
     */
    public void setSalaryFrom(String salaryFrom) {
        this.salaryFrom = salaryFrom;
    }

    /**
     * @return the salaryTo
     */
    public String getSalaryTo() {
        return salaryTo;
    }

    /**
     * @param salaryTo the salaryTo to set
     */
    public void setSalaryTo(String salaryTo) {
        this.salaryTo = salaryTo;
    }

    /**
     * @return the refNo
     */
    public String getRefNo() {
        return refNo;
    }

    /**
     * @param refNo the refNo to set
     */
    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    /**
     * @return the refDate
     */
    public String getRefDate() {
        return refDate;
    }

    /**
     * @param refDate the refDate to set
     */
    public void setRefDate(String refDate) {
        this.refDate = refDate;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    public PromotionEntity() {
    }

    public PromotionEntity(int promotionId, String empFullName) {
        this.promotionId = promotionId;
        this.empFullName = empFullName;

    }

    public PromotionEntity(String empID) {
        this.empId = empID;
    }

    /**
     * A constructor to instantiate a promotion object.
     * @param promotionId the unique promotion identifier
     * @param empId the employee identifier
     * @param promotionDate the promotion date
     * @param promotionType the promotion type
     * @param rankFrom the previous rank
     * @param rankTo the promoted rank
     * @param stepFrom the previous step
     * @param stepTo the promoted step
     * @param salaryFrom the previous salary
     * @param salaryTo the promoted salary
     * @param refNo the reference number
     * @param refDate the reference date
     * @param reason the reason of the promotion
     */
    public PromotionEntity(int promotionId, String empId, String promotionDate, String promotionType, String rankFrom, String rankTo, String stepFrom, String stepTo, String salaryFrom, String salaryTo, String refNo, String refDate, String reason) {
        this.promotionId = promotionId;
        this.empId = empId;
        this.promotionDate = promotionDate;
        this.promotionType = promotionType;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = refNo;
        this.refDate = refDate;
        this.reason = reason;
    }
    /*
     *
     * (PM.empId, PM.promoterID, PM.jobCodeFrom, PM.jobCodeTo,  PM.refDate, PM.refNo,
    PM.salaryFrom, PM.salaryTo, PM.stepFrom, PM.stepTo,    PM.rankFrom,
    PM.rankTo, PM.promotionDate, PM.advertID)
     */

    public PromotionEntity(
            String empID,
            String promoterID,
            String jobCodeFrom,
            String jobCodeTo,
            String refrenceDate,
            String referenceNo,
            String salaryFrom,
            String salaryTo,
            String stepFrom,
            String stepTo,
            String rankFrom,
            String rankTo,
            String promotionDate,
            int advertID,
            String department,
            String departmentFrom,
            String departmentTo) {
        this.promoterID = promoterID;
        this.empId = empID;
        this.jobCodeFrom = jobCodeFrom;
        this.jobCodeTo = jobCodeTo;
        this.promotionDate = promotionDate;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = referenceNo;
        this.refDate = refrenceDate;
        this.adverID = advertID;
        this.department = department;
        this.departmentFrom = departmentFrom;
        this.departmentTo = departmentTo;
    }

    public PromotionEntity(
            String empID,
            String promoterID,
            String jobCodeFrom,
            String jobCodeTo,
            String refrenceDate,
            String referenceNo,
            String salaryFrom,
            String salaryTo,
            String stepFrom,
            String stepTo,
            String rankFrom,
            String rankTo,
            String promotionDate,
            int advertID,
            String directorate,
            int promotionID) {
        this.promotionId = promotionID;
        this.promoterID = promoterID;
        this.empId = empID;
        this.jobCodeFrom = jobCodeFrom;
        this.jobCodeTo = jobCodeTo;
        this.promotionDate = promotionDate;
        this.rankFrom = rankFrom;
        this.rankTo = rankTo;
        this.stepFrom = stepFrom;
        this.stepTo = stepTo;
        this.salaryFrom = salaryFrom;
        this.salaryTo = salaryTo;
        this.refNo = referenceNo;
        this.refDate = refrenceDate;
        this.adverID = advertID;
        this.department = directorate;
    }

    /**
     * The method uses the promotion object and getter methods to access the data
     * from the current promotion instance. The data is then inserted into the
     * hr_emp_promotion table in the database.
     * @throws Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int insertPromotion(PromotionEntity prom) {
        boolean flag = false;
        String strInsrtProm = " INSERT INTO hr_emp_promotion (" +
                " emp_Id, " +
                " promotion_Date, " +
                " rank_From, " +
                " rank_To, " +
                " step_From, " +
                " step_To, " +
                " salary_From, " +
                " salary_To," +
                " reference_No, " +
                " reference_Date, " +
                " JOB_CODE_FROM, " +
                " JOB_CODE_TO, " +
                " PROMOTER_ID, " +
                " STATUS, " +
                " ADVERT_ID," +
                " DEPARTMENTFROM," +
                " DEPARTMENTTO ) " +
                " VALUES( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?)";
        String insrtPromEmpHistory = " UPDATE HR_EMPLOYEE_INFO SET " +
                " JOB_CODE = ?, " +
                " RANK_ID = ?, " +
                " PAY_GRADE = ?, " +
                " SALARY = ?," +
                " DEPARTMENT_ID=?" +
                " WHERE " +
                " EMP_ID = ? ";

         String insrtPromRequestHistroy = " UPDATE HR_PROMOTION_REQUEST SET STATUS = '3' WHERE REQUESTER_ID = ? ";

        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        PreparedStatement ps2 = null;
        Connection _con = null;

        try {


            _con = getConnection();
            _con.setAutoCommit(false);
            ps = _con.prepareStatement(strInsrtProm);
            ps.setString(1, prom.getEmpId());
            ps.setString(2, prom.getPromotionDate());
            ps.setString(3, prom.getRankFrom());
            ps.setString(4, prom.getRankTo());
            ps.setString(5, prom.getStepFrom());
            ps.setString(6, prom.getStepTo());
            ps.setString(7, prom.getSalaryFrom());
            ps.setString(8, prom.getSalaryTo());
            ps.setString(9, prom.getRefNo());
            ps.setString(10, prom.getRefDate());
            ps.setString(11, prom.getJobCodeFrom());
            ps.setString(12, prom.getJobCodeTo());
            ps.setString(13, prom.getPromoterID());
            ps.setString(14, "1");
            ps.setInt(15, prom.getAdverID());
            ps.setString(16, prom.getDepartmentFrom());
            ps.setString(17, prom.getDepartmentTo());
            if(ps.executeUpdate()>0)
            {
            ps2= _con.prepareStatement(insrtPromRequestHistroy);
            ps2.setString(1, prom.getEmpId());
            
            if (ps2.executeUpdate() > 0) {
                ps1 = _con.prepareStatement(insrtPromEmpHistory);
                ps1.setString(1, prom.getJobCodeTo());
                ps1.setString(2, prom.getRankTo());
                ps1.setString(3, prom.getStepTo());
                ps1.setString(4, prom.getSalaryTo());
                ps1.setString(5, prom.getDepartmentTo());
                ps1.setString(6, prom.getEmpId());
                if (ps1.executeUpdate() > 0) {
                    flag = true;
                }
            }
            }

            if (flag) {
                _con.commit();
                return 1;
            } else {
                _con.rollback();
                return 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            return 0;
        } finally {
            try {
                ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * The method updates the hr_emp_promotion table with promotion data.
     * @param prom PromotionEntity object
     * @return
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int saveExper(String requester_ID, int proRequestId, double year) {
        String strUpdateProm = "UPDATE HR_PROMOTION_REQUEST set EXPERIENCE=? " +
                "WHERE ID=? and REQUESTER_ID=?";

        try {
            PreparedStatement ps = getConnection().prepareStatement(strUpdateProm);
            ps.setInt(1, (int) year);
            ps.setInt(2, proRequestId);
            ps.setString(3, requester_ID);
            return ps.executeUpdate();
        } catch (SQLException ex) {
            return 0;
        }
    }

    public int upDateEmployeeStatus(String requesterIDforDiscipline) throws SQLException {
        String strUpdateProm = "UPDATE HR_PROMOTION_REQUEST set STATUS='2' " +
                             " WHERE REQUESTER_ID='" + requesterIDforDiscipline + "'";
         PreparedStatement ps = getConnection().prepareStatement(strUpdateProm);
          return ps.executeUpdate();
    }

    public int updateProm(PromotionEntity prom) throws Exception {

        String strUpdateProm = "UPDATE hr_emp_promotion set promotioin_Id=?, " +
                "emp_Id=?, promotion_Date=?, promotion_Type=?, rank_From=?, rank_To = ?, " +
                "step_From = ?, step_To = ?, salary_From = ?, salary_To = ?, reference_No = ?, reference_Date = ?, reason = ?" +
                " WHERE promotioin_Id='" + promotionId + "'";

        PreparedStatement ps = getConnection().prepareStatement(strUpdateProm);
        ps.setInt(1, prom.getPromotionId());
        ps.setString(2, prom.getEmpId());
        ps.setString(3, prom.getPromotionDate());
        ps.setString(4, prom.getPromotionType());
        ps.setString(5, prom.getRankFrom());
        ps.setString(6, prom.getRankTo());
        ps.setString(7, prom.getStepFrom());
        ps.setString(8, prom.getStepTo());
        ps.setString(9, prom.getSalaryFrom());
        ps.setString(10, prom.getSalaryTo());
        ps.setString(11, prom.getRefNo());
        ps.setString(12, prom.getRefDate());
        ps.setString(13, prom.getReason());

        return ps.executeUpdate();
    }

    public boolean saveExp(ArrayList<HashMap> exper, double year) {

        Connection _con = null;
        PreparedStatement _ps = null;
        int i = 0;
        String update = "";
        try {
            if (exper.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                for (HashMap hm : exper) {//loop over the attached file
                    update = "UPDATE HR_PROMOTION_EXPERIENCE set RELATED='YES' where EXP_ID='" + hm.get("Ex_Id") + "'";
                    _ps = getConnection().prepareStatement(update);
                    _ps.executeUpdate();
                }
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<PromotionEntity> readPromotedEmployees(String advertID) {

        String _select1 = " SELECT HR_EMP_PROMOTION.PROMOTIOIN_ID, " +
                " HR_EMP_PROMOTION.EMP_ID, " +
                " HR_EMP_PROMOTION.ADVERT_ID," +
                " HR_EMP_PROMOTION.STATUS, " +
                " HR_EMPLOYEE_INFO.EMP_ID AS EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, " +
                " HR_EMPLOYEE_INFO.MIDDLE_NAME, " +
                " HR_EMPLOYEE_INFO.LAST_NAME " +
                " FROM " +
                " HR_EMP_PROMOTION," +
                " HR_EMPLOYEE_INFO " +
                " WHERE" +
                " HR_EMP_PROMOTION.EMP_ID =  HR_EMPLOYEE_INFO.EMP_ID " +
                " AND " +
                " HR_EMP_PROMOTION.ADVERT_ID = '" + advertID + "'" +
                " AND " +
                " HR_EMP_PROMOTION.STATUS = '" + 1 + "'";


        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity(
                        ocrs.getInt("PROMOTIOIN_ID"),
                        ocrs.getString("FIRST_NAME") + "--" +
                        ocrs.getString("MIDDLE_NAME") + "--" +
                        ocrs.getString("LAST_NAME") + "--" +
                        ocrs.getString("EMP_ID"));
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

    public ArrayList<PromotionEntity> employeePromoteList(String advertID) {

        String _select1 = " SELECT * from HR_EMP_PROMOTION where emp_id='" + advertID + "'";


        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity(ocrs.getInt("PROMOTIOIN_ID"),
                        ocrs.getString("PROMOTION_DATE"));
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

    public ArrayList<PromotionEntity> listOfPromotionSegestion() {
        return null;
//        EmployeeEntity employeeEntity = new EmployeeEntity();
//        String _select1 = "";// " SELECT * from HR_EMP_PROMOTION where emp_id='" + advertID + "'";
//
//
//        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
//        PreparedStatement _ps = null;
//        Connection _con = null;
//        ResultSet _rs;
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_select1);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            _rs.close();
//            while (ocrs.next()) {
//                PromotionEntity read = new PromotionEntity(ocrs.getInt("PROMOTIOIN_ID"),
//                        ocrs.getString("PROMOTION_DATE"));
//                requests.add(read);
//            }
//
//            return requests;
//        } catch (SQLException ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        } finally {
//            try {
//                _ps.close();
//                _con.close();
//            } catch (Exception ignore) {
//            }
//
//        }
    }

    public HashMap readPromotionIndividualDetail(String promotionID) {
        String select = "SELECT HR_EMP_PROMOTION.EMP_ID, " +
                "  HR_EMP_PROMOTION.PROMOTIOIN_ID, " +
                "  HR_EMP_PROMOTION.PROMOTION_DATE, " +
                "  HR_EMP_PROMOTION.JOB_CODE_TO, " +
                "  HR_EMP_PROMOTION.RANK_FROM, " +
                "  HR_EMP_PROMOTION.RANK_TO, " +
                "  HR_EMP_PROMOTION.STEP_FROM, " +
                "  HR_EMP_PROMOTION.STEP_TO, " +
                "  HR_EMP_PROMOTION.SALARY_FROM, " +
                "  HR_EMP_PROMOTION.SALARY_TO, " +
                "  HR_EMP_PROMOTION.REFERENCE_NO, " +
                "  HR_EMP_PROMOTION.REFERENCE_DATE, " +
                "  HR_EMP_PROMOTION.JOB_CODE_FROM, " +
                "  HR_EMP_PROMOTION.PROMOTER_ID, " +
                "  HR_EMP_PROMOTION.STATUS, " +
                "  HR_EMP_PROMOTION.ADVERT_ID, " +
                "  HR_EMPLOYEE_INFO.EMP_ID, " +
                "  HR_EMPLOYEE_INFO.FIRST_NAME, " +
                "  HR_EMPLOYEE_INFO.MIDDLE_NAME, " +
                "  HR_EMPLOYEE_INFO.LAST_NAME, " +
                "  HR_EMP_PROMOTION.DEPARTMENTFROM, " +
                "  HR_EMP_PROMOTION.DEPARTMENTTO, " +
                "  HR_LU_JOB_TYPE.JOB_DESCRIPTION " +
                "FROM HR_EMP_PROMOTION, " +
                "  HR_EMPLOYEE_INFO, " +
                "  HR_LU_JOB_TYPE " +
                "WHERE HR_EMP_PROMOTION.PROMOTIOIN_ID = '2' " +
                "AND HR_EMPLOYEE_INFO.EMP_ID          = HR_EMP_PROMOTION.EMP_ID " +
                "AND HR_LU_JOB_TYPE.JOB_CODE          =HR_EMP_PROMOTION.JOB_CODE_TO";
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
                HashMap _list = new HashMap();
                _list.put("PROMOTIOIN_ID", ocrs.getString("PROMOTIOIN_ID"));
                _list.put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                _list.put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                _list.put("LAST_NAME", ocrs.getString("LAST_NAME"));
                _list.put("PROMOTION_DATE", ocrs.getString("PROMOTION_DATE"));
                _list.put("JOB_CODE_TO", ocrs.getString("JOB_CODE_TO"));
                _list.put("RANK_FROM", ocrs.getString("RANK_FROM"));
                _list.put("RANK_TO", ocrs.getString("RANK_TO"));
                _list.put("STEP_FROM", ocrs.getString("STEP_FROM"));
                _list.put("STEP_TO", ocrs.getString("STEP_TO"));
                _list.put("SALARY_FROM", ocrs.getString("SALARY_FROM"));
                _list.put("SALARY_TO", ocrs.getString("SALARY_TO"));
                _list.put("REFERENCE_NO", ocrs.getString("REFERENCE_NO"));
                _list.put("REFERENCE_DATE", ocrs.getString("REFERENCE_DATE"));
                _list.put("JOB_CODE_FROM", ocrs.getString("JOB_CODE_FROM"));
                _list.put("PROMOTER_ID", ocrs.getString("PROMOTER_ID"));
                _list.put("STATUS", ocrs.getString("STATUS"));
                _list.put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                _list.put("EMP_ID", ocrs.getString("EMP_ID"));
                _list.put("DEPARTMENTFROM", ocrs.getString("DEPARTMENTFROM"));
                _list.put("DEPARTMENTTO", ocrs.getString("DEPARTMENTTO"));
                _list.put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
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
                ignore.printStackTrace();


            }

        }

    }

    public HashMap readPromotionHistory(String promotionID) {
        String selectPromotion = "SELECT * FROM HR_EMP_PROMOTION WHERE promotioin_id='" + promotionID + "'";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        HashMap promotionHistory = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectPromotion);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                promotionHistory.put("promotionId", ocrs.getString("PROMOTIOIN_ID"));
                promotionHistory.put("promotionDate", ocrs.getString("PROMOTION_DATE"));
                promotionHistory.put("rank", ocrs.getString("RANK_TO"));
                promotionHistory.put("payGrade", ocrs.getString("STEP_TO"));
                promotionHistory.put("jobCode", ocrs.getString("JOB_CODE_TO"));
                promotionHistory.put("salary", ocrs.getString("SALARY_TO"));
                promotionHistory.put("title", ocrs.getString("TITLETO"));
                promotionHistory.put("PROMOTION_DATE", ocrs.getString("PROMOTION_DATE"));


            }
            return promotionHistory;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public HashMap readPromotionRequestInformation(String promotionRequestId) {
        String selectPromotion = "SELECT DISTINCT HR_RECRUITMENT_REQUEST.job_Code, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_RECRUITMENT_REQUEST.department_id, " +
                "  HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "  HR_LU_JOB_TYPE.JOB_NAME , " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_RANK.BEGINNING_SALARY " +
                "FROM HR_RECRUITMENT_REQUEST , " +
                "  HR_LU_JOB_TYPE, " +
                "  HR_ADVERTISEMENT, " +
                "  HR_PROMOTION_REQUEST, " +
                "  HR_LU_RANK " +
                "WHERE hr_recruitment_request.job_Code         = hr_lu_job_type.job_Code " +
                "AND hr_recruitment_request.RECRUIT_REQUEST_ID = HR_ADVERTISEMENT.RECRUIT_REQUEST_ID " +
                "AND HR_PROMOTION_REQUEST.ADVERT_ID            = HR_ADVERTISEMENT.ADVERT_ID " +
                "AND HR_LU_RANK.RANK_ID                        =HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_PROMOTION_REQUEST.PROMOTION_REQUEST_ID =" + promotionRequestId + "";
        Connection _con = null;
        ResultSet _rs = null;
        PreparedStatement _ps = null;
        HashMap promotionHistory = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(selectPromotion);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                promotionHistory.put("JOB_CODE", ocrs.getString("JOB_CODE"));
                promotionHistory.put("RECRUIT_REQUEST_ID", ocrs.getString("RECRUIT_REQUEST_ID"));
                promotionHistory.put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                promotionHistory.put("ADVERT_ID", ocrs.getString("ADVERT_ID"));
                promotionHistory.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                promotionHistory.put("RANK_ID", ocrs.getString("RANK_ID"));
                promotionHistory.put("SALARY", ocrs.getString("BEGINNING_SALARY"));
                return promotionHistory;
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;

    }

    public boolean saveWithoutAdvertismentPromotion(HashMap leaveRequestInfo) {
        PreparedStatement _ps = null;
        PreparedStatement updateProfile = null;

//
        String strInsrtProm = " INSERT INTO hr_emp_promotion (emp_Id, " +
                "                               promotion_Date, " +
                "                               rank_From, " +
                "                               rank_To, " +
                "                               step_From, " +
                "                               step_To, " +
                "                               salary_From, " +
                "                               salary_To," +
                "                               JOB_CODE_FROM," +
                "                               JOB_CODE_TO," +
                "                               STATUS," +
                "                               TITLEFROM," +
                "                               TITLETO," +
                "                               PROMO_STATUS) " +
                "          VALUES(  ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";

        String insrtPromEmpHistory = " UPDATE HR_EMPLOYEE_INFO SET " +
                " JOB_CODE = ?, " +
                " RANK_ID = ?," +
                " PAY_GRADE = ?, " +
                " SALARY = ?," +
                " DEPARTMENT_ID=?," +
                " directorate=?," +
                " division=?," +
                " mastebabriya=?," +
                " team=?," +
                " TITLE=? " +
                " WHERE  EMP_ID = ? ";
        try {
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint spOne = null;
            _ps = _con.prepareStatement(strInsrtProm);
            _ps.setString(1, leaveRequestInfo.get("employeeId").toString());
            _ps.setString(2, leaveRequestInfo.get("promotionDate").toString());
            _ps.setString(3, leaveRequestInfo.get("rankFrom").toString());
            _ps.setString(4, leaveRequestInfo.get("rank").toString());
            _ps.setString(5, leaveRequestInfo.get("payGradefrom").toString());
            _ps.setString(6, leaveRequestInfo.get("payGrade").toString());
            _ps.setString(7, leaveRequestInfo.get("salaryFrome").toString());
            _ps.setString(8, leaveRequestInfo.get("salary").toString());
            _ps.setString(9, leaveRequestInfo.get("professionFrome").toString());
            _ps.setString(10, leaveRequestInfo.get("profession").toString());
            _ps.setString(11, "1");
            _ps.setString(12, leaveRequestInfo.get("titleFrome").toString());
            _ps.setString(13, leaveRequestInfo.get("title").toString());
            _ps.setString(14, leaveRequestInfo.get("promotionStatus").toString());

            if (_ps.executeUpdate() > 0) {
                updateProfile = _con.prepareStatement(insrtPromEmpHistory);
                updateProfile.setString(1, leaveRequestInfo.get("profession").toString());
                updateProfile.setString(2, leaveRequestInfo.get("rank").toString());
                updateProfile.setString(3, leaveRequestInfo.get("payGrade").toString());
                updateProfile.setString(4, leaveRequestInfo.get("salary").toString());
                updateProfile.setString(5, leaveRequestInfo.get("zerf").toString());
                updateProfile.setString(6, leaveRequestInfo.get("directorate").toString());
                updateProfile.setString(7, leaveRequestInfo.get("division").toString());
                updateProfile.setString(8, leaveRequestInfo.get("mastebaberia").toString());
                updateProfile.setString(9, leaveRequestInfo.get("team").toString());
                updateProfile.setString(10, leaveRequestInfo.get("title").toString());
                updateProfile.setString(11, leaveRequestInfo.get("employeeId").toString());
                if (updateProfile.executeUpdate() > 0) {
                    _con.commit();
                    return true;

                } else {
                    _con.rollback(spOne);
                    return false;
                }

            } else {
                _con.rollback(spOne);
                return false;
            }



        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }







    }

    public boolean updateWithoutAdvertismentPromotion(HashMap leaveRequestInfo) {
        PreparedStatement _ps = null;
        PreparedStatement updateProfile = null;

//
        String strInsrtProm = " UPDATE hr_emp_promotion set  " +
                "                               rank_To=?, " +
                "                               step_To=?, " +
                "                               salary_To=?," +
                "                               JOB_CODE_TO=?," +
                "                               TITLETO=?" +
                "                WHERE promotioin_id=? ";


        String insrtPromEmpHistory = " UPDATE HR_EMPLOYEE_INFO SET " +
                " JOB_CODE = ?," +
                " RANK_ID = ?, " +
                " PAY_GRADE = ?, " +
                " SALARY = ?," +
                " DEPARTMENT_ID=?," +
                " directorate=?," +
                " division=?," +
                " mastebabriya=?," +
                " team=?," +
                " TITLE=? " +
                " WHERE  EMP_ID = ? ";
        try {
            Connection _con = getConnection();
            _con.setAutoCommit(false);
            Savepoint spOne = null;
            _ps = _con.prepareStatement(strInsrtProm);
            _ps.setString(1, leaveRequestInfo.get("rank").toString());
            _ps.setString(2, leaveRequestInfo.get("payGrade").toString());
            _ps.setString(3, leaveRequestInfo.get("salary").toString());
            _ps.setString(4, leaveRequestInfo.get("profession").toString());
            _ps.setString(5, leaveRequestInfo.get("title").toString());
            _ps.setString(6, leaveRequestInfo.get("promotioin_id").toString());
            if (_ps.executeUpdate() > 0) {
                updateProfile = _con.prepareStatement(insrtPromEmpHistory);
                updateProfile.setString(1, leaveRequestInfo.get("profession").toString());
                updateProfile.setString(2, leaveRequestInfo.get("rank").toString());
                updateProfile.setString(3, leaveRequestInfo.get("payGrade").toString());
                updateProfile.setString(4, leaveRequestInfo.get("salary").toString());
                updateProfile.setString(5, leaveRequestInfo.get("zerf").toString());
                updateProfile.setString(6, leaveRequestInfo.get("directorate").toString());
                updateProfile.setString(7, leaveRequestInfo.get("division").toString());
                updateProfile.setString(8, leaveRequestInfo.get("mastebaberia").toString());
                updateProfile.setString(9, leaveRequestInfo.get("team").toString());
                updateProfile.setString(10, leaveRequestInfo.get("title").toString());
                updateProfile.setString(11, leaveRequestInfo.get("employeeId").toString());
                if (updateProfile.executeUpdate() > 0) {
                    _con.commit();
                    return true;

                } else {
                    _con.rollback(spOne);
                    return false;
                }

            } else {
                _con.rollback(spOne);
                return false;
            }



        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }







    }

    public ArrayList<PromotionEntity> qulifiedIndividualsForPromo(String num, String identifier) {
        String currentDate = StringDateManipulation.toDayInEc();
        String _select1 = "";
        if (identifier.equals("0")) {
            String criteria[] = num.split("---");
            if (criteria[0].equals("0")) {
                _select1 = " SELECT " +
                        " HR_EMPLOYEE_INFO.EMP_ID AS EMP_ID, HR_EMPLOYEE_INFO.HIRE_DATE, HR_EMP_PROMOTION.EMP_ID " +
                        " FROM " +
                        " HR_EMPLOYEE_INFO , HR_EMP_PROMOTION " +
                        " WHERE " +
                        " HR_EMPLOYEE_INFO.EMP_ID != HR_EMP_PROMOTION.EMP_ID" +
                        " AND " +
                        " (TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4))) > '" + criteria[1] + "' ";
            } else if (Integer.valueOf(criteria[0]) > 0) {
                _select1 = " SELECT HR_EMP_PROMOTION.EMP_ID " +
                        " FROM  " +
                        " HR_EMP_PROMOTION " +
                        " WHERE " +
                        " SUBSTR(EMP_ID, 1,2) = 'FP'" +
                        " AND " +
                        " PROMO_STATUS = '" + criteria[0] + "'" +
                        " AND " +
                        " ((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4))) - (TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))) > '" + criteria[1] + "'";

            }
        } else if (identifier.equals("1")) {
            int serviceYear = Integer.valueOf(num) * 360;
            _select1 = " SELECT " +
                    " HR_EMPLOYEE_INFO.EMP_ID AS EMP_ID, HR_EMPLOYEE_INFO.HIRE_DATE " +
                    " FROM " +
                    " HR_EMPLOYEE_INFO " +
                    " WHERE " +
                    " SUBSTR(EMP_ID, 1,2) = 'FP'" +
                    " AND " +
                    " (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    " + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    " + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + serviceYear + "'";

        }
        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity(ocrs.getString("EMP_ID"));
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

    public ArrayList<PromotionEntity> qulifiedIndividualsForPromo(String val1, String val2, String val3, String identifier) {
        int serviceYear = Integer.valueOf(val1) * 360;
        int date = Integer.valueOf(val3) * 360;
        int discipline = 0;
        String currentDate = StringDateManipulation.toDayInEc();
        String _select1 = "";
        int promoFreq = Integer.valueOf(val2);
        if (identifier.equals("0")) {
            discipline = Integer.valueOf(val3) * 360;
            promoFreq = Integer.valueOf(val1);
            date = Integer.valueOf(val2) * 360;
            _select1 = " SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO, HR_DISCIPLINE_ISSUE " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.OFFENDER_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + discipline + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.STATUS like 'App%'";
        } else if (identifier.equals("1")) {
            _select1 = " SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + serviceYear + "'";

        }
        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity(ocrs.getString("EMP_ID"));
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

    public ArrayList<PromotionEntity> qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String identifier) {
        int serviceYear = Integer.valueOf(val1) * 360;
        int date = Integer.valueOf(val2) * 360;
        String currentDate = StringDateManipulation.toDayInEc();
        int discipline = 0;
        String _select1 = "";
        int promoFreq = Integer.valueOf(val1);
        if (identifier.equals("0")) {
            discipline = Integer.valueOf(val4) * 360;
            promoFreq = Integer.valueOf(val2);
            date = Integer.valueOf(val3) * 360;
            _select1 = " SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO, HR_DISCIPLINE_ISSUE " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + serviceYear + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.OFFENDER_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + discipline + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.STATUS like 'App%'";
        } else if (identifier.equals("1")) {
            _select1 = " SELECT  HR_EVALUATION_RESULT.EMP_ID, AVG(HR_EVALUATION_RESULT.RESULT) AS aver" +
                    " FROM" +
                    " HR_EVALUATION_RESULT" +
                    " WHERE" +
                    " HR_EVALUATION_RESULT.EMP_ID IN" +
                    "         (SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "')" +
                    "          AND " +
                    "          HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + val4 + "'" +
                    "          GROUP BY HR_EVALUATION_RESULT.EMP_ID ";

        }
        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity();
                if (identifier.equals("1")) {
                    if (ocrs.getInt("aver") > (Integer.valueOf(val3) / 20)) {
                        read = new PromotionEntity(ocrs.getString("EMP_ID"));
                    }
                } else {
                    read = new PromotionEntity(ocrs.getString("EMP_ID"));
                }
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

    public ArrayList<PromotionEntity> qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String val5, String identifier) {
        int serviceYear = Integer.valueOf(val1) * 360;
        int date = Integer.valueOf(val3) * 360;
        int discipline = 0;
        String currentDate = StringDateManipulation.toDayInEc();
        String _select1 = "";
        int promoFreq = Integer.valueOf(val2);
        if (identifier.equals("0")) {
            discipline = Integer.valueOf(val5) * 360;
            promoFreq = Integer.valueOf(val1);
            date = Integer.valueOf(val2) * 360;
            _select1 = " SELECT  HR_EVALUATION_RESULT.EMP_ID, AVG(HR_EVALUATION_RESULT.RESULT) AS aver" +
                    " FROM" +
                    " HR_EVALUATION_RESULT" +
                    " WHERE" +
                    " HR_EVALUATION_RESULT.EMP_ID IN" +
                    "         (SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO, HR_DISCIPLINE_ISSUE " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.OFFENDER_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 9,2)))) > '" + discipline + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.STATUS like 'App%')" +
                    "          AND " +
                    "          HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + val4 + "'" +
                    "          GROUP BY HR_EVALUATION_RESULT.EMP_ID ";
        } else if (identifier.equals("1")) {
            _select1 = " SELECT  HR_EVALUATION_RESULT.EMP_ID, AVG(HR_EVALUATION_RESULT.RESULT) AS aver" +
                    " FROM" +
                    " HR_EVALUATION_RESULT" +
                    " WHERE" +
                    " HR_EVALUATION_RESULT.EMP_ID IN" +
                    "         (SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO, HR_DISCIPLINE_ISSUE " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + serviceYear + "')" +
                    "          AND " +
                    "          HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + val5 + "'" +
                    "          GROUP BY HR_EVALUATION_RESULT.EMP_ID ";


        }
        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity();
                if (identifier.equals("1")) {
                    if (ocrs.getInt("aver") > (Integer.valueOf(val4) / 20)) {
                        read = new PromotionEntity(ocrs.getString("EMP_ID"));
                    }
                } else {
                    read = new PromotionEntity(ocrs.getString("EMP_ID"));
                    if (ocrs.getInt("aver") > (Integer.valueOf(val3) / 20)) {
                        read = new PromotionEntity(ocrs.getString("EMP_ID"));
                    }
                }
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

    public ArrayList<PromotionEntity> qulifiedIndividualsForPromo(String val1, String val2, String val3, String val4, String val5, String val6, String identifier) {

        int serviceYear = Integer.valueOf(val1) * 360;
        int date = Integer.valueOf(val3) * 360;
        int discipline = Integer.valueOf(val6) * 360;
        String currentDate = StringDateManipulation.toDayInEc();
        String _select1 = "";
        int promoFreq = Integer.valueOf(val2);
        if (identifier.equals("0")) {
        } else if (identifier.equals("1")) {
            _select1 = " SELECT  HR_EVALUATION_RESULT.EMP_ID, AVG(HR_EVALUATION_RESULT.RESULT) AS aver" +
                    " FROM" +
                    " HR_EVALUATION_RESULT" +
                    " WHERE" +
                    " HR_EVALUATION_RESULT.EMP_ID IN" +
                    "         (SELECT HR_EMPLOYEE_INFO.EMP_ID " +
                    "          FROM  " +
                    "          HR_EMP_PROMOTION, HR_EMPLOYEE_INFO, HR_DISCIPLINE_ISSUE " +
                    "          WHERE " +
                    "          SUBSTR(HR_EMPLOYEE_INFO.EMP_ID, 1,2) = 'FP'" +
                    "          AND " +
                    "          HR_EMP_PROMOTION.EMP_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          PROMO_STATUS = '" + promoFreq + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(PROMOTION_DATE, 9,2)))) > '" + date + "'" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_EMPLOYEE_INFO.HIRE_DATE, 9,2)))) > '" + serviceYear + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.OFFENDER_ID = HR_EMPLOYEE_INFO.EMP_ID" +
                    "          AND " +
                    "          (((((TO_NUMBER(SUBSTR('" + currentDate + "', 1,4)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 1,4)))*'12')" +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 6,2)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 6,2))))*'30') " +
                    "          + (TO_NUMBER(SUBSTR('" + currentDate + "', 9,2)) - TO_NUMBER(SUBSTR(HR_DISCIPLINE_ISSUE.OFFENCE_DATE, 9,2)))) > '" + discipline + "'" +
                    "          AND " +
                    "          HR_DISCIPLINE_ISSUE.STATUS like 'App%')" +
                    "          AND " +
                    "          HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + val5 + "'" +
                    "          GROUP BY HR_EVALUATION_RESULT.EMP_ID ";


        }
        ArrayList<PromotionEntity> requests = new ArrayList<PromotionEntity>();
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
                PromotionEntity read = new PromotionEntity();
                if (ocrs.getInt("aver") > (Integer.valueOf(val4) / 20)) {
                    read = new PromotionEntity(ocrs.getString("EMP_ID"));
                }
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

    public int updatePromotion(PromotionEntity prom) {
        boolean flag = false;
        String strUpdateProm = " UPDATE hr_emp_promotion SET " +
                " emp_Id=?," +
                " promotion_Date=?, " +
                " rank_From=?, " +
                " rank_To=?, " +
                " step_From=?," +
                " step_To=?," +
                " salary_From=?, " +
                " salary_To=?," +
                " reference_No=?," +
                " reference_Date=?," +
                " JOB_CODE_FROM=?," +
                " JOB_CODE_TO=?," +
                " PROMOTER_ID=?, " +
                " STATUS=? " +
                " WHERE PROMOTIOIN_ID=? ";

        String insrtPromEmpHistory = " UPDATE HR_EMPLOYEE_INFO SET " +
                " JOB_CODE = ?, " +
                " RANK_ID = ?, " +
                " PAY_GRADE = ?, " +
                " SALARY = ?," +
                " DEPARTMENT_ID=?" +
                " WHERE " +
                " EMP_ID = ? ";
        PreparedStatement ps = null;
        PreparedStatement ps1 = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            ps = _con.prepareStatement(strUpdateProm);
            ps.setString(1, prom.getEmpId());
            ps.setString(2, prom.getPromotionDate());
            ps.setString(3, prom.getRankFrom());
            ps.setString(4, prom.getRankTo());
            ps.setString(5, prom.getStepFrom());
            ps.setString(6, prom.getStepTo());
            ps.setString(7, prom.getSalaryFrom());
            ps.setString(8, prom.getSalaryTo());
            ps.setString(9, prom.getRefNo());
            ps.setString(10, prom.getRefDate());
            ps.setString(11, prom.getJobCodeFrom());
            ps.setString(12, prom.getJobCodeTo());
            ps.setString(13, prom.getPromoterID());
            ps.setString(14, "1");
            ps.setInt(15, prom.getPromotionId());
            if (ps.executeUpdate() > 0) {
                ps1 = _con.prepareStatement(insrtPromEmpHistory);
                ps1.setString(1, prom.getJobCodeTo());
                ps1.setString(2, prom.getRankTo());
                ps1.setString(3, prom.getStepTo());
                ps1.setString(4, prom.getSalaryTo());
                ps1.setString(5, prom.getDirectorate());
                ps1.setString(6, prom.getEmpId());
                if (ps1.executeUpdate() > 0) {
                    flag = true;
                }
            }

            if (flag) {
                //    _con.commit();
                return 1;
            } else {
                return 0;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();

            return 0;
        } finally {
            try {
                ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    /**
     * promotion report selection
     * @param promotionId
     * @return
     */
    public OracleCachedRowSet promotionReport(String promotionId) {
        String _select = "SELECT   HR_EMP_PROMOTION.EMP_ID,                   " +
                "                  HR_EMP_PROMOTION.JOB_CODE_FROM," +
                "                  HR_EMP_PROMOTION.JOB_CODE_TO," +
                "                  HR_EMP_PROMOTION.PROMOTION_DATE," +
                "                  HR_EMP_PROMOTION.RANK_FROM," +
                "                  HR_EMP_PROMOTION.RANK_TO," +
                "                  HR_EMP_PROMOTION.SALARY_FROM," +
                "                  HR_EMP_PROMOTION.SALARY_TO," +
                "                  HR_EMP_PROMOTION.STEP_FROM," +
                "                  HR_EMP_PROMOTION.STEP_TO," +
                "                  HR_EMP_PROMOTION.TITLEFROM," +
                "                  HR_EMP_PROMOTION.TITLETO" +
                "        FROM     HR_EMP_PROMOTION" +
                "       WHERE   PROMOTIOIN_ID=? ";//promotion
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, promotionId);
            _rs = _ps.executeQuery();

            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public int readPromotionStatus(String employeeId) {
        String select = "  SELECT  MAX(PROMO_STATUS) AS STATUS FROM HR_EMP_PROMOTION WHERE  EMP_ID=?";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();

            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            if (ocrs.next()) {
                return ocrs.getInt("STATUS");
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;

        }
    }

    public ArrayList<HashMap> readPromotionForReport(String employeeId) {
        String select = " SELECT   hr_emp_promotion.promotion_Date , " +
                "          hr_emp_promotion.rank_From , " +
                "          hr_emp_promotion.rank_To , " +
                "          hr_emp_promotion.step_From , " +
                "          hr_emp_promotion.step_To , " +
                "          hr_emp_promotion.salary_From , " +
                "          hr_emp_promotion.salary_To  " +
                " FROM   hr_emp_promotion  " +
                " WHERE emp_id=?";
        ArrayList<HashMap> readPromotionInfiormation = new ArrayList<HashMap>();
        ResultSet rs;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeId);
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("promotion_Date", ocrs.getString("promotion_Date"));
                hm.put("rank_From", ocrs.getString("rank_From"));
                hm.put("rank_To", ocrs.getString("rank_To"));
                hm.put("step_From", ocrs.getString("step_From"));
                hm.put("step_To", ocrs.getString("step_To"));
                hm.put("salary_From", ocrs.getString("salary_From"));
                hm.put("salary_To", ocrs.getString("salary_To"));
                readPromotionInfiormation.add(hm);
            }

            closePooledConnections(_conn);
            return readPromotionInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> promotionGroupReport(String promotionSelectionCriteria) {

        String select = " SELECT CONCAT (CONCAT(hr_employee_info.first_Name || ' ' ," +
                "       hr_employee_info.middle_Name ||' ')," +
                "       hr_employee_info.last_Name) AS hr_employee_info_Full_Name," +
                "       hr_emp_promotion.promotion_Date ,  " +
                "       hr_emp_promotion.promotion_Type ,  " +
                "       hr_emp_promotion.rank_From ," +
                "       HR_EMP_PROMOTION.EMP_ID,                    " +
                "       hr_emp_promotion.rank_To ,  " +
                "       hr_emp_promotion.step_From ,  " +
                "       hr_emp_promotion.step_To ,  " +
                "       hr_emp_promotion.salary_From ,  " +
                "       hr_emp_promotion.salary_To," +
                "       hr_emp_promotion.titlefrom," +
                "       hr_emp_promotion.titleto                    " +
                " FROM hr_employee_info hr_employee_info INNER JOIN hr_emp_promotion hr_emp_promotion ON hr_employee_info.emp_Id = hr_emp_promotion.emp_Id" +
                " WHERE hr_emp_promotion.promotion_Date " + promotionSelectionCriteria + "";
        ArrayList<HashMap> readPromotionInfiormation = new ArrayList<HashMap>();
        ResultSet rs;
        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("fullName", ocrs.getString("hr_employee_info_Full_Name"));
                hm.put("promotion_Date", ocrs.getString("promotion_Date"));
                hm.put("rank_From", ocrs.getString("rank_From"));
                hm.put("rank_To", ocrs.getString("rank_To"));
                hm.put("step_From", ocrs.getString("step_From"));
                hm.put("step_To", ocrs.getString("step_To"));
                hm.put("salary_From", ocrs.getString("salary_From"));
                hm.put("salary_To", ocrs.getString("salary_To"));
                hm.put("titlefrom", ocrs.getString("titlefrom"));
                hm.put("titleto", ocrs.getString("titleto"));
                readPromotionInfiormation.add(hm);
            }

            closePooledConnections(_conn);
            return readPromotionInfiormation;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String getLastPromotion(String employeeId) {
        try {
            ResultSet rs;
            Connection _conn;
            String select = "";
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            rs = ps.executeQuery();
            ocrs.populate(rs);
            rs.close();
            ps.close();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean insertPromotionAssessmentPrecentage(HashMap promotionAssessmentPrecentage) {
        boolean checkSave = false;
        Connection _con;
        PreparedStatement ps = null;
        String str = "INSERT INTO HR_PROMOTION_ASS_PERCENTAGE (" +
                "WRITTEN_PERCENTAGE, " +
                "INTERVIEW_PERCENTAGE, " +
                "PRESENTATION_PERCENTAGE," +
                "OTHER_PERCENTAGE," +
                "BATCH_CODE ) " +
                "values(?,?,?,?,?)";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, promotionAssessmentPrecentage.get("writtenpercentage").toString());
            ps.setString(2, promotionAssessmentPrecentage.get("interviewpercentage").toString());
            ps.setString(3, promotionAssessmentPrecentage.get("presentationpercentage").toString());
            ps.setString(4, promotionAssessmentPrecentage.get("otherpercentage").toString());
            ps.setString(5, promotionAssessmentPrecentage.get("batchCode").toString());
            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(_con);
            return checkSave;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updatePromotionAssessmentPrecentage(HashMap promotionAssessmentPrecentage) {
        boolean checkUpdate = false;
        Connection _con;
        PreparedStatement ps = null;
        String str = "UPDATE HR_PROMOTION_ASS_PERCENTAGE " +
                "  SET " +
                "  WRITTEN_PERCENTAGE =?, " +
                "  INTERVIEW_PERCENTAGE=?, " +
                "  PRESENTATION_PERCENTAGE=?," +
                "  OTHER_PERCENTAGE=? " +
                "  WHERE BATCH_CODE=? ";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, promotionAssessmentPrecentage.get("writtenpercentage").toString());
            ps.setString(2, promotionAssessmentPrecentage.get("interviewpercentage").toString());
            ps.setString(3, promotionAssessmentPrecentage.get("presentationpercentage").toString());
            ps.setString(4, promotionAssessmentPrecentage.get("otherpercentage").toString());
            ps.setString(5, promotionAssessmentPrecentage.get("batchCode").toString());
            if (ps.executeUpdate() > 0) {
                checkUpdate = true;
            }
            ps.close();
            closePooledConnections(_con);
            return checkUpdate;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return checkUpdate;
        }
    }

    public HashMap selectPromotionAssessmentPrecentage(String batchCode) {
        ResultSet rs = null;
        Connection con = null;
        PreparedStatement ps = null;
        HashMap readPromotionAssessmentPrecentage = null;
        String qry = "SELECT " +
                " nvl(WRITTEN_PERCENTAGE,'0.0') as WRITTEN_PERCENTAGE," +
                " nvl(INTERVIEW_PERCENTAGE,'0.0') as INTERVIEW_PERCENTAGE," +
                " nvl(PRESENTATION_PERCENTAGE,'0.0') as PRESENTATION_PERCENTAGE," +
                " nvl(OTHER_PERCENTAGE,'0.0') as OTHER_PERCENTAGE ," +
                " BATCH_CODE " +
                " FROM HR_PROMOTION_ASS_PERCENTAGE " +
                " WHERE BATCH_CODE='" + batchCode + "'";

        try {
            con = getConnection();
            ps = con.prepareStatement(qry);
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            if (ocrs.next()) {
                readPromotionAssessmentPrecentage = new HashMap();
                readPromotionAssessmentPrecentage.put("writtenpercentage", ocrs.getString("WRITTEN_PERCENTAGE"));
                readPromotionAssessmentPrecentage.put("interviewpercentage", ocrs.getString("INTERVIEW_PERCENTAGE"));
                readPromotionAssessmentPrecentage.put("presentationpercentage", ocrs.getString("PRESENTATION_PERCENTAGE"));
                readPromotionAssessmentPrecentage.put("otherpercentage", ocrs.getString("OTHER_PERCENTAGE"));
                readPromotionAssessmentPrecentage.put("batchCode", ocrs.getString("BATCH_CODE"));
                ps.close();
                rs.close();
                closePooledConnections(con);
                return readPromotionAssessmentPrecentage;
            } else {
                ps.close();
                rs.close();
                closePooledConnections(con);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        }
    }

    public boolean deletePromotionAssessmentPrecentage(String batchCode) {
        boolean checkSave = false;
        Connection con = null;
        PreparedStatement ps = null;
        String select = "DELETE HR_PROMOTION_ASS_PERCENTAGE WHERE BATCH_CODE='" + batchCode + "'";
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(con);
            return checkSave;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    public boolean insertPromotionAssessmentResult(int proRequestId, HashMap assessmentResult) {
        boolean checkSave = false;
        Connection con = null;
        PreparedStatement psInsert = null;
        Savepoint savePoint1 = null;
        String insert = "INSERT INTO HR_PROMOTION_ASSESSMENT (PROMOTION_ASSESSMENT_ID, INTERVIEW_EXAM_RESULT, WRITTEN_EXAM_RESULT, " +
                " PRESENTATION_EXAM_RESULT, OTHER_RESULT, RECOMMENDATION, REMARK, PROMOTION_REQUEST_ID) " +
                " VALUES (SEQ_PROMOTION_ASSESMENT.NEXTVAL, ?, ?, ?, ?, ?, ?, ?) ";

        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint1 = con.setSavepoint("SAVEPOINT1");
            psInsert = con.prepareStatement(insert);
            psInsert.setString(1, assessmentResult.get("interview").toString());
            psInsert.setString(2, assessmentResult.get("written").toString());
            psInsert.setString(3, assessmentResult.get("presentation").toString());
            psInsert.setString(4, assessmentResult.get("other").toString());
            psInsert.setString(5, assessmentResult.get("recommendation").toString());
            psInsert.setString(6, assessmentResult.get("remark").toString());
            psInsert.setInt(7, proRequestId);
            if (psInsert.executeUpdate() > 0) {
                con.commit();
                checkSave = true;
            } else {
                con.rollback(savePoint1);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkSave;
    }

    public boolean updatePromotionAssessmentResult(int promotionAssessmentId, HashMap assessmentResult) {
        boolean checkUpdate = false;
        Connection con = null;
        PreparedStatement psUpdate = null;
        Savepoint savePoint1 = null;
        String insert = "UPDATE HR_PROMOTION_ASSESSMENT " +
                "   SET INTERVIEW_EXAM_RESULT=?, WRITTEN_EXAM_RESULT=?, " +
                "   PRESENTATION_EXAM_RESULT=?, OTHER_RESULT=?, RECOMMENDATION=?, REMARK=? " +
                "   WHERE PROMOTION_ASSESSMENT_ID = ? ";

        try {
            con = getConnection();
            con.setAutoCommit(false);
            savePoint1 = con.setSavepoint("SAVEPOINT1");
            psUpdate = con.prepareStatement(insert);
            psUpdate.setString(1, assessmentResult.get("interview").toString());
            psUpdate.setString(2, assessmentResult.get("written").toString());
            psUpdate.setString(3, assessmentResult.get("presentation").toString());
            psUpdate.setString(4, assessmentResult.get("other").toString());
            psUpdate.setString(5, assessmentResult.get("recommendation").toString());
            psUpdate.setString(6, assessmentResult.get("remark").toString());
            psUpdate.setInt(7, promotionAssessmentId);
            if (psUpdate.executeUpdate() > 0) {
                con.commit();
                checkUpdate = true;
            } else {
                con.rollback(savePoint1);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return checkUpdate;
    }

    public HashMap readPromotionAssessmentResultForUpdate(int proRequestId) {
        String select = "SELECT empInfo.FIRST_NAME, " +
                "  empInfo.MIDDLE_NAME, " +
                "  empInfo.LAST_NAME, " +
                "  empInfo.Emp_Id, " +
                "  proAss.PROMOTION_ASSESSMENT_ID, " +
                "  proAss.WRITTEN_EXAM_RESULT, " +
                "  proAss.INTERVIEW_EXAM_RESULT, " +
                "  proAss.PRESENTATION_EXAM_RESULT, " +
                "  proAss.OTHER_RESULT, " +
                "  proAss.RECOMMENDATION, " +
                "  proAss.REMARK " +
                "FROM HR_PROMOTION_ASSESSMENT proAss " +
                "INNER JOIN HR_PROMOTION_REQUEST proReq " +
                "ON proReq.ID = proAss.PROMOTION_REQUEST_ID " +
                "INNER JOIN HR_EMPLOYEE_INFO empInfo " +
                "ON Empinfo.Emp_Id = Proreq.Requester_Id " +
                "WHERE proReq.ID = '" + proRequestId + "'";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            HashMap hm = new HashMap();
            if (ocrs.next()) {
                hm.put("FIRST_NAME", ocrs.getString("FIRST_NAME"));
                hm.put("MIDDLE_NAME", ocrs.getString("MIDDLE_NAME"));
                hm.put("LAST_NAME", ocrs.getString("LAST_NAME"));
                hm.put("PROMOTION_ASSESSMENT_ID", ocrs.getString("PROMOTION_ASSESSMENT_ID"));
                hm.put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                hm.put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                hm.put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                hm.put("OTHER_RESULT", ocrs.getString("OTHER_RESULT"));
                hm.put("RECOMMENDATION", ocrs.getString("RECOMMENDATION"));
                hm.put("REMARK", ocrs.getString("REMARK"));
                hm.put("Emp_Id", ocrs.getString("Emp_Id"));
            }
            _rs.close();
            _ps.close();
            closePooledConnections(_con);
            return hm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public int countDisciplineCase(String employeeId, String date) {
        String sqlStatment = "SELECT COUNT(REQUESTER_ID) AS DISCIPLINECOUNTER " +
                "FROM HR_DISCIPLINE_ISSUE " +
                "WHERE OFFENDER_ID     =?      " +
                " AND SUBSTR(STATUS,1,3)                          ='APP' " +
                "AND to_date(SUBSTR(TIME_STAMP,1,10),'yyyy-mm-dd') > to_date('" + date + "','yyyy-mm-dd')";
        try {
            PreparedStatement _ps = null;
            ResultSet _rs = null;
            Connection _con;
            _con = getConnection();
            _ps = _con.prepareStatement(sqlStatment);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("DISCIPLINECOUNTER");
            } else {
                return 0;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public float evaluationResult(String employeeId, String date) {
        int counter = 0;
        float count = 0.0f;
        float result = 0.0f;
        float addingOne = 1;
        /////////////////////////////////////////the First Quary///////////////////////////////////////////////
//        String sqlStatment = "SELECT SUM(ER.RESULT) AS RESULT, " +
//                "  ER.EVALUATION_SESSION_ID " +
//                "FROM HR_EVALUATION_RESULT ER, " +
//                "  HR_EVALUATION_SESSION ES " +
//                "WHERE ER.EVALUATION_SESSION_ID        =ES.EVALUATION_SESSION_ID " +
//                "AND TO_DATE(ES.END_DATE,'YYYY,MM,DD') > TO_DATE('" + date + "','YYYY,MM,DD') " +
//                "AND trim (ER.EMP_ID)                          ='" + employeeId + "' " +
//                "GROUP BY ER.EVALUATION_SESSION_ID";
        ///////////////////////////////////////////////////////////////////////////////////////////////////////////

        String sqlStatment = "SELECT SUM(ER.PERCENT_VALUE) AS RESULT, " +
                "  ER.SESSION_ID " +
                "FROM HR_EVALUATION_PERCENT_VALUE ER, " +
                "  HR_EVALUATION_SESSION ES " +
                "WHERE ER.SESSION_ID                   =ES.EVALUATION_SESSION_ID " +
                "AND TO_DATE(ES.END_DATE,'YYYY,MM,DD') > TO_DATE('" + date + "','YYYY,MM,DD') " +
                "AND trim (ER.EVALUTED_EMP_ID)         ='" + employeeId + "' " +
                "GROUP BY ER.SESSION_ID";



        try {
            PreparedStatement _ps = null;
            ResultSet _rs = null;
            Connection _con;
            _con = getConnection();
            _ps = _con.prepareStatement(sqlStatment);
           // _ps.setString(1, date);
             // _ps.setString(2, employeeId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                result += _rs.getFloat("RESULT");
                count += addingOne;
                counter++;
            }
            if (counter > 0) {
               // result /= count;
               
                return result;
            } else {
                return 0.0f;
            }


        } catch (Exception e) {
            e.printStackTrace();
            return 0.0f;
        }
    }

    public String checkLastTimeExamResult(String employeeId, String date) throws Exception {
        String sqlStatment = "SELECT HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "  HR_PROMOTION_REQUEST.REQUESTER_ID, " +
                "  HR_PROMOTION_REQUEST.PROMOTION_REQUEST_DATE, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                          AS EXAMEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                    AS DISCIPLINEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                   AS PERFORMANCEPERCENTAGERESULT, " +
                "  ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100) + " +
                " ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + " +
                " ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                " FROM HR_PROMOTION_REQUEST " +
                " WHERE to_date(HR_PROMOTION_REQUEST.PROMOTION_REQUEST_DATE, 'yyyy-mm-dd')>=to_date('" + date + "', 'yyyy-mm-dd') " +
                " AND HR_PROMOTION_REQUEST.REQUESTER_ID                                    ='" + employeeId + "'";
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection con = getConnection();
        ps = con.prepareStatement(sqlStatment);
        rs = ps.executeQuery();
        if (rs.next()) {
            return rs.getString("EMPLOYEETOTALRESULT");
        } else {
            return null;
        }



    }
}
