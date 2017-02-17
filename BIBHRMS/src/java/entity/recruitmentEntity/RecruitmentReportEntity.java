/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author HRMS
 */
public class RecruitmentReportEntity extends ConnectionManager {

    PreparedStatement ps = null;
    ResultSet rs = null;
    Connection conn = null;
    PreparedStatement _ps = null;
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

    public ArrayList<HashMap> recRepuest() {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_REF_DATE , " +
                "  tbl_department.address_code , " +
                "  bk.department_path , " +
                "  SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) dept_id " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE  = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_PAY_GRAD.RANK_ID             = HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO             = '0' " +
                "AND tbl_department.dept_id             =SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code       IS NOT NULL";
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                String depPath[] = ocrs.getString("department_path").split(">>");
                int index = depPath.length;
                hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                hm.put("address_code", ocrs.getString("address_code"));
                hm.put("RECRUIT_REQUEST_REF_DATE", ocrs.getString("RECRUIT_REQUEST_REF_DATE"));
                hm.put("Chief", depPath[1]);
                hm.put("Directorate", depPath[index - 1]);
                hm.put("Process", depPath[index - 1]);
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> recApprove() {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  bk.department_path , " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_RECRUITMENT_REQUEST.DEPARTMENT_ID, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_REF_DATE, " +
                "  tbl_department.address_code , " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_APPROVED_DATE " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_LU_EDUC_LEVEL, " +
                "  HR_RECRUITMENT_REQUEST_STATUS , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE   = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_PAY_GRAD.RANK_ID               = HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO               = '0' " +
                "AND HR_RECRUITMENT_REQUEST.REQUEST_STATUS='App%' " +
                "AND tbl_department.dept_id               =SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code         IS NOT NULL";
        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                String depPath[] = ocrs.getString("department_path").split(">>");
                int index = depPath.length;
                hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("DEPARTMENT_ID", ocrs.getString("DEPARTMENT_ID"));
                hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                hm.put("RECRUIT_REQUEST_REF_DATE", ocrs.getString("RECRUIT_REQUEST_REF_DATE"));
                hm.put("RECRUIT_APPROVED_DATE", ocrs.getString("RECRUIT_APPROVED_DATE"));
                hm.put("address_code", ocrs.getString("address_code"));
                hm.put("Chief", depPath[1]);
                hm.put("Directorate", depPath[index - 2]);
                hm.put("Process", depPath[index - 1]);
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> internalVaccancy() {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bk bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE                                                                     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE                                                                    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID                                                                                =HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO                                                                                ='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID                                                                   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "AND tbl_department.dept_id                                                                                =SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code                                                                          IS NOT NULL";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                String depPath[] = ocrs.getString("department_path").split(">>");
                int index = depPath.length;
                HashMap hm = new HashMap();
                hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                hm.put("SALARY", ocrs.getString("SALARY"));
                hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                hm.put("address_code", ocrs.getString("address_code"));
                hm.put("Chief", depPath[1]);
                hm.put("Directorate", depPath[index - 2]);
                hm.put("Process", depPath[index - 1]);
                quesList.add(hm);
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertisment() {

        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertismentByMonth(HashMap list) {

        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT " +
                "HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "and HR_ADVERTISEMENT.PREPARED_DATE between '" + list.get("StartDay").toString() + "' and '" + list.get("endDate").toString() + "'" +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertismentByQuarter(HashMap Daylist) {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(Daylist.get("quarterType").toString()) == 1) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 2) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 3) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(Daylist.get("quarterType").toString()) == 4) {
            year = Daylist.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT " +
                "HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "and HR_ADVERTISEMENT.PREPARED_DATE between '" + startDay + "' and '" + endDay + "'" +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertismentBySimiannual(HashMap Daylist) {

        String startDay = "";
        String endDay = "";
        String year = Daylist.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(Daylist.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(Daylist.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT " +
                "HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "and HR_ADVERTISEMENT.PREPARED_DATE between '" + startDay + "' and '" + endDay + "'" +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertismentByDays(HashMap Daylist) {



        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT " +
                "HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                //                "and HR_ADVERTISEMENT.PREPARED_DATE between '"+Daylist.get("StartDay").toString()+"' and '"+Daylist.get("endDate").toString()+"'" +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> advertismentByAnnual(HashMap Daylist) {



        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT DISTINCT " +
                "HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_CODE, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  HR_LU_JOB_TYPE.RANK_ID, " +
                "  HR_LU_PAY_GRAD.SALARY, " +
                "  HR_RECRUITMENT_REQUEST.NUM_OF_EMPS, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.EDUCATION_LEVEL, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL.MIN_EXPERIENCE, " +
                "  HR_LU_JOB_TYPE.ADDITIONALSKILL, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "  tbl_department.address_code , " +
                "  HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
                "  bk.department_path " +
                "FROM HR_LU_JOB_TYPE, " +
                "  vw_employee_by_department_bi bk, " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_PAY_GRAD, " +
                "  HR_LU_JOB_TYPE_EDUC_LEVEL, " +
                "  HR_ADVERTISEMENT , " +
                "  HR_LU_EDUC_LEVEL , " +
                "  tbl_department " +
                "WHERE HR_RECRUITMENT_REQUEST.JOB_CODE     = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND HR_LU_JOB_TYPE_EDUC_LEVEL.JOB_CODE    = HR_LU_JOB_TYPE.JOB_CODE " +
                "AND SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) = bk.department_id " +
                "AND HR_LU_PAY_GRAD.RANK_ID=HR_LU_JOB_TYPE.RANK_ID " +
                "AND HR_LU_PAY_GRAD.STEP_NO='0' " +
                "AND HR_ADVERTISEMENT.RECRUIT_REQUEST_ID   =HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID " +
                "and HR_ADVERTISEMENT.PREPARED_DATE LIKE '" + Daylist.get("year") + "-%-%'" +
                "AND tbl_department.dept_id=SUBSTR(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,1,instr(HR_RECRUITMENT_REQUEST.DEPARTMENT_ID,'==',1,1)-1) " +
                "AND tbl_department.address_code  IS NOT NULL " +
                "ORDER BY RECRUIT_REQUEST_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {

                if (!(ocrs.getString("RECRUIT_REQUEST_ID").equals(reqID))) {

                    reqID = ocrs.getString("RECRUIT_REQUEST_ID");
                    educLavel = educLavel + ocrs.getString("EDUCATION_LEVEL");
                    String depPath[] = ocrs.getString("department_path").split(">>");
                    int index = depPath.length;
                    HashMap hm = new HashMap();
                    hm.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    hm.put("RANK_ID", ocrs.getString("RANK_ID"));
                    hm.put("SALARY", ocrs.getString("SALARY"));
                    hm.put("EDUCATION_LEVEL", ocrs.getString("EDUCATION_LEVEL"));
                    hm.put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                    hm.put("MIN_EXPERIENCE", ocrs.getString("MIN_EXPERIENCE"));
                    hm.put("ADDITIONALSKILL", ocrs.getString("ADDITIONALSKILL"));
                    hm.put("NUM_OF_EMPS", ocrs.getString("NUM_OF_EMPS"));
                    hm.put("ADDRESS_CODE", ocrs.getString("ADDRESS_CODE"));
                    hm.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                    hm.put("address_code", ocrs.getString("address_code"));
                    hm.put("Chief", depPath[0]);
                    hm.put("Directorate", depPath[index - 2]);
                    hm.put("Process", depPath[index - 1]);
                    quesList.add(hm);
                    educLavel = "";
                } else {
                    educLavel += ocrs.getString("EDUCATION_LEVEL") + " / ";
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> promotionFilter() {
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT PROMOTION.* " +
                "FROM " +
                "  (SELECT DISTINCT bk.department_path , " +
                "    HR_EMPLOYEE_INFO.RANK_ID, " +
                "    HR_PROMOTION_REQUEST.ADVERT_ID, " +
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
                "    HR_LU_JOB_TYPE.JOB_NAME, " +
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
                "    ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                          AS EXAMEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                    AS DISCIPLINEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                   AS PERFORMANCEPERCENTAGERESULT, " +
                "    (HR_PROMOTION_REQUEST.TOALEXAMRESULT)   + (HR_PROMOTION_REQUEST.DISCIPLINERESULT )+ (HR_PROMOTION_REQUEST.PERFORMANCEVALUE ) AS EMPLOYEETOTALRESULT " +
                "  FROM HR_PROMOTION_REQUEST, " +
                "    vw_employee_by_department_bk bk, " +
                "    HR_EMPLOYEE_INFO, " +
                "    HR_ADVERTISEMENT, " +
                "    HR_RECRUITMENT_REQUEST , " +
                "    HR_PROMOTION_ASSESSMENT, " +
                "    HR_LU_JOB_TYPE " +
                "  WHERE HR_EMPLOYEE_INFO.EMP_ID                   = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                "  AND HR_EMPLOYEE_INFO.DEPARTMENT_ID              = bk.department_id " +
                "  AND HR_PROMOTION_REQUEST.ADVERT_ID              =HR_ADVERTISEMENT.ADVERT_ID " +
                "  AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE         =HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE " +
                "  AND HR_PROMOTION_ASSESSMENT.PROMOTION_REQUEST_ID=HR_PROMOTION_REQUEST.ID " +
                "  AND HR_LU_JOB_TYPE.JOB_CODE                     =HR_EMPLOYEE_INFO.JOB_CODE " +
                "  ORDER BY EMPLOYEETOTALRESULT DESC " +
                "  ) PROMOTION " +
                "WHERE PROMOTION.EMPLOYEETOTALRESULT >= 0";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap candidateList = new HashMap();
                candidateList.put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                candidateList.put("EXAMPERCENTAGE", ocrs.getString("EXAMPERCENTAGE"));
                candidateList.put("DISCIPLINEPERCENTAGE", ocrs.getString("DISCIPLINEPERCENTAGE"));
                candidateList.put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                candidateList.put("TOTALRESULT", ocrs.getString("TOTALRESULT"));
                candidateList.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                candidateList.put("RANK_ID", ocrs.getString("RANK_ID"));
//                candidateList.put("PRACTICAL_EXAM_RESULT", ocrs.getString("PRACTICAL_EXAM_RESULT"));
//                candidateList.put("DISCIPLINEPERCENTAGE", ocrs.getString("DISCIPLINEPERCENTAGE"));
                candidateList.put("FULLNAME", ocrs.getString("FULLNAME"));
//
//
//
//
//
//
//
//
//                candidateList.put("RANK_ID", ocrs.getString("RANK_ID"));
//                candidateList.put("CANDIDATE_ID", ocrs.getString("CANDIDATE_ID"));
//                candidateList.put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                quesList.add(candidateList);






            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> promotionFilterCandidate() {
      
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = " SELECT PROMOTION.* " +
                "FROM " +
                "  (SELECT DISTINCT hr_employee_info.sex, " +
                "    bk.department_path , " +
                "    HR_EMPLOYEE_INFO.RANK_ID, " +
                "    tbl_department.address_code , " +
                "    hr_employee_info.job_code, " +
                "    hr_employee_info.date_of_birth, " +
                "    HR_PROMOTION_REQUEST.ADVERT_ID, " +
                "    HR_ADVERTISEMENT.ADVERT_DATE_FROM, " +
                "    HR_ADVERTISEMENT.ADVERT_DATE_TO, " +
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
                "    HR_LU_JOB_TYPE.JOB_NAME, " +
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
                "    ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)                                                                                                                                                                                         AS EXAMEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100)                                                                                                                                                                                   AS DISCIPLINEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100)                                                                                                                                                                                  AS PERFORMANCEPERCENTAGERESULT, " +
                "    ((HR_PROMOTION_REQUEST.TOALEXAMRESULT   * HR_PROMOTION_REQUEST.EXAMPERCENTAGE)/100)+ ((HR_PROMOTION_REQUEST.DISCIPLINERESULT * HR_PROMOTION_REQUEST.DISCIPLINEPERCENTAGE)/100) + ((HR_PROMOTION_REQUEST.PERFORMANCEVALUE * HR_PROMOTION_REQUEST.PERFORMANCEPERCENTAGE)/100) AS EMPLOYEETOTALRESULT " +
                "  FROM HR_PROMOTION_REQUEST, " +
                "    vw_employee_by_department_bi bk, " +
                "    HR_EMPLOYEE_INFO, " +
                "    tbl_department, " +
                "    HR_ADVERTISEMENT, " +
                "    HR_RECRUITMENT_REQUEST , " +
                "    HR_PROMOTION_ASSESSMENT, " +
                "    HR_LU_JOB_TYPE " +
                "  WHERE HR_EMPLOYEE_INFO.EMP_ID                   = HR_PROMOTION_REQUEST.REQUESTER_ID " +
                "  AND HR_EMPLOYEE_INFO.DEPARTMENT_ID              = bk.department_id " +
                "  AND tbl_department.dept_id                      = hr_employee_info.department_id " +
                "  AND HR_PROMOTION_REQUEST.ADVERT_ID              =HR_ADVERTISEMENT.ADVERT_ID " +
                "  AND HR_ADVERTISEMENT.RECRUIT_BATCH_CODE         =HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE " +
                "  AND HR_PROMOTION_ASSESSMENT.PROMOTION_REQUEST_ID=HR_PROMOTION_REQUEST.ID " +
                "  AND HR_LU_JOB_TYPE.JOB_CODE                     =HR_EMPLOYEE_INFO.JOB_CODE " +
                "  ORDER BY EMPLOYEETOTALRESULT DESC " +
                "  ) PROMOTION " +
                "WHERE PROMOTION.EMPLOYEETOTALRESULT >= 0";

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                String depPath[] = ocrs.getString("department_path").split(">>");
                int index = depPath.length;
                HashMap candidateList = new HashMap();
                candidateList.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                candidateList.put("RANK_ID", ocrs.getString("RANK_ID"));
                candidateList.put("SALARY", ocrs.getString("RANK_ID"));
                candidateList.put("Chief", depPath[1]);
                candidateList.put("Directorate", depPath[index - 2]);
                candidateList.put("Process", depPath[index - 1]);
                candidateList.put("address_code", ocrs.getString("address_code"));
                candidateList.put("REQUESTER_ID", ocrs.getString("REQUESTER_ID"));
                candidateList.put("SEX", ocrs.getString("SEX"));
                candidateList.put("date_of_birth", ocrs.getString("date_of_birth"));
                candidateList.put("RANK_ID", ocrs.getString("RANK_ID"));
                candidateList.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                candidateList.put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                candidateList.put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                candidateList.put("PRESENTATION_EXAM_RESULT", ocrs.getString("PRESENTATION_EXAM_RESULT"));
                candidateList.put("EMPLOYEETOTALRESULT", ocrs.getString("EMPLOYEETOTALRESULT"));
                candidateList.put("educlavel", ocrs.getString("RANK_ID"));
                candidateList.put("eductype", ocrs.getString("RANK_ID"));
                candidateList.put("cgpa", ocrs.getString("RANK_ID"));
                candidateList.put("exper", ocrs.getString("RANK_ID"));
                candidateList.put("eductype", ocrs.getString("RANK_ID"));
                candidateList.put("additionalsk", ocrs.getString("RANK_ID"));
                candidateList.put("ADVERT_DATE_FROM", ocrs.getString("ADVERT_DATE_FROM"));
                candidateList.put("ADVERT_DATE_TO", ocrs.getString("ADVERT_DATE_TO"));
                candidateList.put("refNo", ocrs.getString("ADVERT_ID"));
                candidateList.put("aproverCom", ocrs.getString("RANK_ID"));
                candidateList.put("approverdDate", ocrs.getString("RANK_ID"));
                candidateList.put("FULLNAME", ocrs.getString("FULLNAME"));
                quesList.add(candidateList);

            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }
    ////////////////////////////////////////////////////////////////PromotionRequest///////////////////////////////////////////////////////////////////
  Connection _con = null;
    ResultSet _rs = null;
    public OracleCachedRowSet promotionFilterCandidateNewBiruk() throws SQLException {
      
      
      
        String select = " SELECT DISTINCT EI.EMP_ID, " +
                "  EI.sex, " +
                "  EI.SALARY, " +
                "  EI.DATE_OF_BIRTH, " +
                "  tblb.dept_name , " +
                "  EI.RANK_ID, " +
                "  EI.job_code, " +
                "  EI.date_of_birth, " +
                "  PR.ADVERT_ID, " +
                "  HPA.ADVERT_DATE_FROM, " +
                "  HPA.ADVERT_DATE_TO, " +
                "  PR.REQUESTER_ID, " +
                "  PR.ID, " +
                "  PR.EXAMPERCENTAGE, " +
                "  PR.DISCIPLINEPERCENTAGE, " +
                "  PR.PERFORMANCEPERCENTAGE, " +
                "  NVL(PR.TOTALRESULT,'.') As TOTALRESULT,  " +
                "  EI.HIRE_DATE, " +
                "  PR.PROMOTION_REQUEST_ID, " +
                "  NVL(ET.DESCRIPTION,'not register')                     AS EDUCATIONTYPE, " +
                "  NVL(EL.DESCRIPTION,'not register')                     AS EDUCATIONLEAVE , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EI.HIRE_DATE,1,4)    AS INSIDEeXPRIANCE , " +
                "  TO_CHAR(sysdate, 'YYYY') - SUBSTR(EI.DATE_OF_BIRTH,1,4)AS AGE, " +
                "  PR.STATUS, " +
                "  PR.PERCENT_TR, " +
                "  JT.JOB_NAME, " +
                "  ebdl.job_name AS newPositon, " +
                "  HPR.NEW_JOB_POSITION, " +
                "  hpr.new_paygrade, " +
                "  hpr.new_rank, " +
                "  hpr.new_salary, " +
                "  hpr.prev_job_position, " +
                "  hpr.prev_paygrade, " +
                "  hpr.prev_rank, " +
                "  hpr.prev_salary, " +
                "  hpr.completed_date, " +
                "  hpr.reason, " +
                "  hpr.request_letter_number, " +
                "  EI.FIRST_NAME " +
                "  || ' ' " +
                "  || EI.MIDDLE_NAME " +
                "  || ' ' " +
                "  || EI.LAST_NAME AS FULLNAME, " +
                "  PR.PERFORMANCEPERCENTAGE, " +
                "   nvl( pr.performancevalue, '.') as performancevalue, " +
                "  ED.EDUC_LEVEL_CODE " +
                " FROM HR_PROMOTION_REQUEST PR " +
                " INNER JOIN hr_employee_info EI " +
                " ON ei.emp_id=pr.requester_id " +
                " INNER JOIN HR_ADVERTISEMENT HPA " +
                " ON HPA.ADVERT_ID=pr.advert_id " +
                " INNER JOIN HR_RECRUITMENT_REQUEST REQ " +
                " ON req.recruit_request_id=hpa.recruit_request_id " +
                " INNER JOIN tbl_dept_bunna tblb " +
                " ON tblb.dept_id=ei.department_id " +
                " INNER JOIN HR_LU_JOB_TYPE JT " +
                " ON JT.JOB_CODE=EI.JOB_CODE " +
                " INNER JOIN HR_PROMOTION_HISTORY HPR " +
                " ON HPR.EMPLOYEE_ID=ei.emp_id " +
                " INNER JOIN hr_lu_job_type ebdl " +
                " ON ebdl.job_code =hpr.new_job_position " +
                " INNER JOIN HR_EMP_EDUCATION ED " +
                " ON ED.EMP_ID=EI.EMP_ID " +
                " INNER JOIN HR_LU_EDUC_LEVEL EL " +
                " ON EL.EDUC_LEVEL_CODE=ED.EDUC_LEVEL_CODE " +
                " INNER JOIN HR_LU_EDUC_TYPE ET " +
                " ON ET.EDUC_TYPE_CODE =ED.EDUCATION_TYPE " +
                " WHERE HPR.EMPLOYEE_ID=EI.EMP_ID " +
                " AND HPA.STATUS = '1' " +
                " AND EI.EMP_ID = ED.EMP_ID ";
         try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return ocrs;
        } finally {
            releaseResources();
        }
       
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<HashMap> filtercandidate() {
        String reqID = "";
        String educLavel = "";
        ArrayList<HashMap> quesList = new ArrayList<HashMap>();
        String select = "SELECT CANDIDATE_ID, " +
                "  CGPA, " +
                "  NVL(experience,'0') AS experience, " +
                "  LEVELOFEDUCATION, " +
                "  HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "  GENDER, " +
                "  DATEOFBIRTH, " +
                "  NVL(WRITTEN_EXAM_RESULT,'0')   AS WRITTEN_EXAM_RESULT, " +
                "  NVL(INTERVIEW_EXAM_RESULT,'0') AS INTERVIEW_EXAM_RESULT, " +
                "  NVL(PRACTICAL_EXAM_RESULT,'0') AS PRACTICAL_EXAM_RESULT, " +
                "  LEVELOFEDUCATION, " +
                "  HR_RECRUITMENT_REQUEST.RECRUIT_REQUEST_ID, " +
                "  HR_LU_JOB_TYPE.JOB_NAME, " +
                "  hr_lu_job_type.rank_id " +
                "FROM hr_candidate , " +
                "  HR_RECRUITMENT_REQUEST, " +
                "  HR_LU_EDUC_LEVEL, " +
                "  HR_LU_JOB_TYPE " +
                "WHERE hr_candidate.LEVELOFEDUCATION          =HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE " +
                "AND HR_RECRUITMENT_REQUEST.RECRUIT_BATCH_CODE=hr_candidate.recruit_batch_code " +
                "AND HR_RECRUITMENT_REQUEST.JOB_CODE          = HR_LU_JOB_TYPE.JOB_CODE " +
                "ORDER BY CANDIDATE_ID DESC";

        Connection con = null;
        try {
            con = getConnection();
            ps = con.prepareStatement(select);
            rs = (ResultSet) ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                if (!(ocrs.getString("CANDIDATE_ID").equals(reqID))) {
                    HashMap candidateList = new HashMap();
                    candidateList.put("CGPA", ocrs.getString("CGPA"));
                    candidateList.put("experience", ocrs.getString("experience"));
                    candidateList.put("GENDER", ocrs.getString("GENDER"));
                    candidateList.put("DATEOFBIRTH", ocrs.getString("DATEOFBIRTH"));
                    candidateList.put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                    candidateList.put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                    candidateList.put("PRACTICAL_EXAM_RESULT", ocrs.getString("PRACTICAL_EXAM_RESULT"));
                    candidateList.put("LEVELOFEDUCATION", ocrs.getString("LEVELOFEDUCATION"));
                    candidateList.put("RANK_ID", ocrs.getString("RANK_ID"));
                    candidateList.put("CANDIDATE_ID", ocrs.getString("CANDIDATE_ID"));
                    candidateList.put("JOB_NAME", ocrs.getString("JOB_NAME"));
                    reqID = ocrs.getString("CANDIDATE_ID");
                    quesList.add(candidateList);
                } else {
                }
            }
            closePooledConnections(con);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        return quesList;
    }

    public ArrayList<HashMap> loadEmployeeExprianceReport(String empId) {
        ArrayList<HashMap> listOfEmployeeExpr = new ArrayList<HashMap>();
        String selectStatment = "SELECT EP.EMP_ID, " +
                "  EP.FIRST_NAME " +
                "  ||' ' " +
                "  || EP.MIDDLE_NAME " +
                "  ||' ' " +
                "  || EP.LAST_NAME AS FULLNAME, " +
                "  EX.START_DATE, " +
                "  EX.END_DATE, " +
                "  EX.PERMANENT_OR_CONTRACT, " +
                "  EX.PRIVATE_OR_GVTAL, " +
                "  EX.INSTITUION " +
                "FROM HR_EMPLOYEE_INFO EP, " +
                "  HR_EMP_EXPERIENCE EX " +
                "WHERE EP.EMP_ID=EX.EMP_ID " +
                "AND EP.EMP_ID  ='" + empId + "' " +
                "ORDER BY EP.EMP_ID, " +
                "  EX.PRIVATE_OR_GVTAL, " +
                "  EX.PERMANENT_OR_CONTRACT";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectStatment);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rs.getString("EMP_ID"));
                hm.put("FULLNAME", rs.getString("FULLNAME"));
                hm.put("START_DATE", rs.getString("START_DATE"));
                hm.put("END_DATE", rs.getString("END_DATE"));
                hm.put("PER_OR_CON", rs.getString("PERMANENT_OR_CONTRACT"));
                hm.put("PRI_OR_GV", rs.getString("PRIVATE_OR_GVTAL"));
                hm.put("INSTITUION", rs.getString("INSTITUION"));
                listOfEmployeeExpr.add(hm);
            }
            return listOfEmployeeExpr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
