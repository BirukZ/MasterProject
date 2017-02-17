/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
//import java.util.ArrayList;
//import manager.educationManager.EducationCostModel;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class TrainingReportEntity extends ConnectionManager {

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
    //String budjetYear, int institutionId, int trainingId

    public ResultSet selectTrainingRequests() throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  levl.DESCRIPTION, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "LEFT JOIN HR_EMP_EDUCATION educ " +
                "ON educ.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bku " +
                "ON bku.emp_id=req.employee_id " +
                "LEFT JOIN HR_LU_EDUC_LEVEL levl " +
                "ON levl.educ_level_code=educ.educ_level_code " +
                "WHERE lists.REQUEST_STATUS NOT LIKE 'App-%'";


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRequestByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS NOT LIKE 'App-%' AND lists.REQUEST_STATUS NOT LIKE 'Rej-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";

        if (!selectCriteria) {
//            _selectQuery += " AND info.EMP_ID         ='" + employeeId + "' " +
//                    " ORDER BY info.EMP_ID";
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
//            _selectQuery += " ORDER BY EP.EMP_ID desc";
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRequestByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS NOT LIKE 'App-%' AND lists.REQUEST_STATUS NOT LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRequestByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS NOT LIKE 'App-%' AND lists.REQUEST_STATUS NOT LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRequestBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS NOT LIKE 'App-%' AND lists.REQUEST_STATUS NOT LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRequestByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = " SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.job_name, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                " FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                " INNER JOIN hr_employee_info info " +
                " ON info.emp_id=req.employee_id " +
                " INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                " ON req.request_id=lists.need_assessement_request_id " +
                " INNER JOIN vw_employee_by_department_list vw " +
                " ON vw.emp_id=req.employee_id " +
                " INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                " ON catego.category_id=lists.training_category " +
                " INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                " ON inst.institution_id=lists.proposed_institution_or_place " +
                " WHERE lists.REQUEST_STATUS NOT LIKE 'App-%' AND lists.REQUEST_STATUS NOT LIKE 'Rej-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%-%'";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
//            return _rs;
        } //        catch (Exception e) {
        //            e.printStackTrace();
        //            return null;
        //        }
        finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRejectByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.job_name, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS  LIKE 'Rej-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";

        if (!selectCriteria) {
//            _selectQuery += " AND info.EMP_ID         ='" + employeeId + "' " +
//                    " ORDER BY info.EMP_ID";
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
//            _selectQuery += " ORDER BY EP.EMP_ID desc";
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRejectByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS  LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRejectByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS  LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRejectBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS  LIKE 'Rej-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingRejectByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  info.SEX, " +
                "  lists.TRAINING_NAME, " +
                "  lists.NUMBER_OF_EMPLOYEES, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  (select levl.DESCRIPTION from HR_LU_EDUC_LEVEL levl where levl.educ_level_code= (select max (educ.educ_level_code) from HR_EMP_EDUCATION educ where educ.emp_id=req.employee_id)) as EDUCATION_LEVEL, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.TENTATIVE_START_DATE, " +
                "  lists.TENTATIVE_END_DATE " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS  LIKE 'Rej-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%-%'";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
//            return _rs;
        } //        catch (Exception e) {
        //            e.printStackTrace();
        //            return null;
        //        }
        finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingApproved() throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "LEFT JOIN HR_EMP_EDUCATION educ " +
                "ON educ.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "INNER JOIN VW_EMPLOYEE_BY_DEPARTMENT_BKU bku " +
                "ON bku.emp_id=req.employee_id " +
                "LEFT JOIN HR_LU_EDUC_LEVEL levl " +
                "ON levl.educ_level_code=educ.educ_level_code " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%'";


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingApprovedByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingApprovedByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingApprovedByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingApprovedBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%' AND   to_date(subStr(lists.TIME_STAMP,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingApprovedByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT req.EMPLOYEE_ID, " +
                "  info.FIRST_NAME " +
                "  ||info.MIDDLE_NAME " +
                "  ||info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  catego.CATEGORY_NAME, " +
                "  lists.TRAINING_NAME, " +
                "  lists.APPLIED_DATE, " +
                "  lists.tentative_start_date, " +
                "  lists.tentative_end_date, " +
                "  lists.no_of_days, " +
                "  lists.award, " +
                "  inst.INSTITUTION_NAME, " +
                "  lists.trainer_name " +
                "FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=req.employee_id " +
                "INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
                "ON req.request_id=lists.need_assessement_request_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=req.employee_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
                "ON catego.category_id=lists.training_category " +
                "INNER JOIN HR_LU_EDUC_INSTITUTION inst " +
                "ON inst.institution_id=lists.proposed_institution_or_place " +
                "WHERE lists.REQUEST_STATUS LIKE 'App-%' AND lists.TIME_STAMP LIKE '" + list.get("year") + "-%-%'";
        if (!selectCriteria) {
            _selectQuery += " AND req.EMPLOYEE_ID         ='" + employeeId + "' " +
                    " ORDER BY req.EMPLOYEE_ID";
        } else {
            _selectQuery += " ORDER BY req.EMPLOYEE_ID desc";
        }


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingCosts() throws SQLException {
        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  (SELECT SUM(trainingcost.total) " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='2012' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='2012' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE costdetail.budjet_year   ='2012'";


//                "SELECT costdetail.emp_id, " +
//"  info.FIRST_NAME " +
//"  || info.MIDDLE_NAME " +
//"  || info.LAST_NAME AS FULL_NAME, " +
//"  vw.DEPARTMENT_NAME, " +
//"  vw.JOB_NAME, " +
//"  trainingcategory.category_name, " +
//"  costdetail.TRAINING_NAME, " +
//"  costdetail.training_fee, " +
//"  costdetail.intertainment_fee, " +
//"  costdetail.transport_fee, " +
//"  costdetail.fee_for_trainer, " +
//"  costdetail.allowance_fee, " +
//"  costdetail.stationary_fee, " +
//"  costdetail.other_fees, " +
//"  costdetail.costperperson, " +
//"  costdetail.budjet_year " +
//"FROM hr_lu_training_cost_detail costdetail " +
//"INNER JOIN hr_employee_info info " +
//"ON info.emp_id=costdetail.emp_id " +
//"INNER JOIN vw_employee_by_department_list vw " +
//"ON vw.emp_id=costdetail.emp_id " +
//"INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
//"ON trainingtype.traininig_name=costdetail.training_name " +
//"INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
//"ON trainingcategory.category_id=trainingtype.training_category";


//                "SELECT req.EMPLOYEE_ID, " +
//"  info.FIRST_NAME " +
//"  || info.MIDDLE_NAME " +
//"  || info.LAST_NAME AS FULL_NAME, " +
//"  vw.DEPARTMENT_NAME, " +
//"  vw.JOB_NAME, " +
//"  catego.CATEGORY_NAME, " +
//"  lists.TRAINING_NAME, " +
//"  costdetail.training_fee, " +
//"  costdetail.intertainment_fee, " +
//"  costdetail.transport_fee, " +
//"  costdetail.fee_for_trainer, " +
//"  costdetail.allowance_fee, " +
//"  costdetail.stationary_fee, " +
//"  costdetail.other_fees, " +
//"  costdetail.costperperson " +
//"FROM HR_TRAIN_NEED_ASSMT_EMP_LIST req " +
//"INNER JOIN hr_employee_info info " +
//"ON info.emp_id=req.employee_id " +
//"INNER JOIN HR_TRAIN_NEED_ASSESSEMENT_REQ lists " +
//"ON req.request_id=lists.need_assessement_request_id " +
//"INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY catego " +
//"ON catego.category_id=lists.training_category " +
//"INNER JOIN vw_employee_by_department_list vw " +
//"ON vw.emp_id=req.employee_id " +
//"INNER JOIN hr_lu_training_cost_detail costdetail " +
//"ON costdetail.emp_id=req.employee_id";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingCostsByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  ROUND ((SELECT  nvl(SUM(trainingcost.total),'0') " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='" + list.get("year") + "' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT nvl(SUM(trainreq.number_of_employees),'1') " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='" + list.get("year") + "' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ),2) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE costdetail.START_DATE   LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'";
        if (!selectCriteria) {
            _selectQuery += " AND costdetail.emp_id         ='" + employeeId + "' " +
                    " ORDER BY costdetail.emp_id";
        } else {
            _selectQuery += " ORDER BY costdetail.emp_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingCostsByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  ROUND ((SELECT  nvl(SUM(trainingcost.total),'0') " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='" + list.get("year") + "' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT nvl(SUM(trainreq.number_of_employees),'1') " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='" + list.get("year") + "' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ),2) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE to_date(subStr(costdetail.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND costdetail.emp_id         ='" + employeeId + "' " +
                    " ORDER BY costdetail.emp_id";
        } else {
            _selectQuery += " ORDER BY costdetail.emp_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingCostsByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  ROUND ((SELECT  nvl(SUM(trainingcost.total),'0') " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='" + list.get("year") + "' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT nvl(SUM(trainreq.number_of_employees),'1') " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='" + list.get("year") + "' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ),2) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE to_date(subStr(costdetail.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND costdetail.emp_id         ='" + employeeId + "' " +
                    " ORDER BY costdetail.emp_id";
        } else {
            _selectQuery += " ORDER BY costdetail.emp_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingCostsBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  ROUND ((SELECT  nvl(SUM(trainingcost.total),'0') " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='" + list.get("year") + "' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT nvl(SUM(trainreq.number_of_employees),'1') " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='" + list.get("year") + "' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ),2) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE to_date(subStr(costdetail.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') ";
        if (!selectCriteria) {
            _selectQuery += " AND costdetail.emp_id         ='" + employeeId + "' " +
                    " ORDER BY costdetail.emp_id";
        } else {
            _selectQuery += " ORDER BY costdetail.emp_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
//SUM(trainreq.number_of_employees)

    public ResultSet readAllTrainingCostsByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT costdetail.emp_id, " +
                "  info.FIRST_NAME " +
                "  || info.MIDDLE_NAME " +
                "  || info.LAST_NAME AS FULL_NAME, " +
                "  vw.DEPARTMENT_NAME, " +
                "  vw.JOB_NAME, " +
                "  trainingcategory.category_name, " +
                "  costdetail.TRAINING_NAME, " +
                "  ROUND ((SELECT  nvl(SUM(trainingcost.total),'0') " +
                "  FROM HR_TRAIN_TRAINING_COSTS trainingcost " +
                "  WHERE trainingcost.BUDJET_YEAR='" + list.get("year") + "' " +
                "  AND trainingcost.traininig_id =trainingtype.training_type_id " +
                "  )/ " +
                "  (SELECT nvl(SUM(trainreq.number_of_employees),'1') " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year  ='" + list.get("year") + "' " +
                "  AND trainreq.training_name=costdetail.training_name " +
                "  ),2) AS Individual_cost_plan, " +
                "  costdetail.training_fee, " +
                "  costdetail.intertainment_fee, " +
                "  costdetail.transport_fee, " +
                "  costdetail.fee_for_trainer, " +
                "  costdetail.allowance_fee, " +
                "  costdetail.stationary_fee, " +
                "  costdetail.other_fees, " +
                "  costdetail.costperperson, " +
                "  costdetail.budjet_year " +
                "FROM hr_lu_training_cost_detail costdetail " +
                "INNER JOIN hr_employee_info info " +
                "ON info.emp_id=costdetail.emp_id " +
                "INNER JOIN vw_employee_by_department_list vw " +
                "ON vw.emp_id=costdetail.emp_id " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_TYPES trainingtype " +
                "ON trainingtype.traininig_name=costdetail.training_name " +
                "INNER JOIN HR_LU_TRAIN_TRAINING_CATEGORY trainingcategory " +
                "ON trainingcategory.category_id=trainingtype.training_category " +
                "WHERE costdetail.START_DATE   LIKE '" + list.get("year") + "-%-%'";   //'" + list.get("year") + "'
        if (!selectCriteria) {
            _selectQuery += " AND costdetail.emp_id         ='" + employeeId + "' " +
                    " ORDER BY costdetail.emp_id";
        } else {
            _selectQuery += " ORDER BY costdetail.emp_id desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectTrainingStatistics() throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR < '2012' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '2012' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE TR.PAYMENT_PAYE_BY LIKE 'BIB%' " +
                "GROUP BY TR.TRAININGORCOURSE_NAME";


//                "SELECT TRAININGORCOURSE_NAME, " +
//"  COUNT(TRAININGORCOURSE_NAME) AS NUMBER_OF_TRAINEE, " +
//"  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST " +
//"FROM hr_emp_training " +
//"GROUP BY TRAININGORCOURSE_NAME";


        //req.EMPLOYEE_ID,info.FIRST_NAME ||info.MIDDLE_NAME ||info.LAST_NAME AS FULL_NAME,info.SEX,lists.TRAINING_NAME,lists.NUMBER_OF_EMPLOYEES," +
        //"vw.DEPARTMENT_NAME,vw.JOB_NAME,catego.CATEGORY_NAME,levl.DESCRIPTION,inst.INSTITUTION_NAME,lists.APPLIED_DATE,lists.TENTATIVE_START_DATE,lists.TENTATIVE_END_DATE>
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingStatisticsByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN (TR.START_YEAR < '" + list.get("year") + "') OR (TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH < '" + list.get("month") + "') " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE TR.PAYMENT_PAYE_BY LIKE 'BIB%' AND TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH = '" + list.get("month") + "'" +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

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

    public ResultSet readAllTrainingStatisticsByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN (TR.START_YEAR < '" + list.get("year") + "') OR (TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH < '" + list.get("month") + "') " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE (to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD'))  AND (TR.PAYMENT_PAYE_BY LIKE 'BIB%') AND TR.START_YEAR = '" + list.get("year") + "'" +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingStatisticsByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN (TR.START_YEAR < '" + list.get("year") + "') OR (TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH < '" + list.get("month") + "') " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE (to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD'))  AND (TR.PAYMENT_PAYE_BY LIKE 'BIB%') AND TR.START_YEAR = '" + list.get("year") + "'" +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingStatisticsBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN (TR.START_YEAR < '" + list.get("year") + "') OR (TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH < '" + list.get("month") + "') " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE (to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD'))  AND (TR.PAYMENT_PAYE_BY LIKE 'BIB%') AND TR.START_YEAR = '" + list.get("year") + "' " +
                "GROUP BY (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

//    public ResultSet readAllTrainingStatisticsByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
//        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
//                "  COUNT( " +
//                "  CASE " +
//                "    WHEN TR.START_YEAR < '" + list.get("year") + "' " +
//                "    THEN 'dd' " +
//                "    ELSE NULL " +
//                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
//                "  COUNT( " +
//                "  CASE " +
//                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
//                "    THEN 'dd' " +
//                "    ELSE NULL " +
//                "  END) NUMBER_OF_TRAINEE, " +
//                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST, " +
//                "  DECODE (ROWNUM, COUNT(*) OVER(), SUM( SUM(PAYMENT_FOR_TRAINING)) OVER(), 0) Total_amount " +
//                "FROM HR_EMP_TRAINING TR " +
//                "WHERE TR.PAYMENT_PAYE_BY LIKE 'BIB%' " +
//                "GROUP BY TR.TRAININGORCOURSE_NAME";
//        if (!selectCriteria) {
//             _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
//
//        } else {
//             _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
//        }
//
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
    public ResultSet readAllTrainingStatisticsByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
//        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
//                "  COUNT( " +
//                "  CASE " +
//                "    WHEN TR.START_YEAR < '2012' " +
//                "    THEN 'dd' " +
//                "    ELSE NULL " +
//                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
//                "  COUNT( " +
//                "  CASE " +
//                "    WHEN TR.START_YEAR = '2012' " +
//                "    THEN 'dd' " +
//                "    ELSE NULL " +
//                "  END) NUMBER_OF_TRAINEE, " +
//                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
//                "FROM HR_EMP_TRAINING TR " +
//                "WHERE TR.PAYMENT_PAYE_BY LIKE 'BIB%' AND TR.START_YEAR = '" + list.get("year") + "' " +
//                "GROUP BY (TRAININGORCOURSE_NAME)";


          String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR < '2012' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE_BEFORE, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR ='" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) NUMBER_OF_TRAINEE, " +
                "  SUM(PAYMENT_FOR_TRAINING) TOTAL_COST " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE TR.PAYMENT_PAYE_BY LIKE 'BIB%' AND TR.START_YEAR = '" + list.get("year") + "' " +
                "GROUP BY (TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

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

    public ResultSet selectTrainingPlanComparison() throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='2012' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '2012' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '2012' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='2012' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE TR.START_YEAR='2012' " +
                "GROUP BY TR.TRAININGORCOURSE_NAME";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainingId);
//            _ps.setString(2, budjetYear);
//            _ps.setInt(3, institutionId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingPlanComparisonByMonth(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                //"    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    WHEN TR.START_DATE LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                //"    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    WHEN TR.START_DATE LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                //"WHERE TR.START_DATE LIKE '" + list.get("year") + "-%" + list.get("month") + "-%'" +
                "WHERE TR.PAYMENT_PAYE_BY = 'BIB' AND TR.START_YEAR = '" + list.get("year") + "' AND TR.START_MONTH = '" + list.get("month") + "'" +
                " GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

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

    public ResultSet readAllTrainingPlanComparisonByQuarter(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year;
        if (Integer.parseInt(list.get("quarterType").toString()) == 1) {
            year = list.get("year").toString();
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-03-31";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 2) {
            year = list.get("year").toString();
            startDay = "" + year + "-04-01";
            endDay = "" + year + "-06-30";

        } else if (Integer.parseInt(list.get("quarterType").toString()) == 3) {
            year = list.get("year").toString();
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-09-30";
        } else if (Integer.parseInt(list.get("quarterType").toString()) == 4) {
            year = list.get("year").toString();
            startDay = "" + year + "-10-01";
            endDay = "" + year + "-12-31";
        }

        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') " +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingPlanComparisonByDays(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') " +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, list.get("StartDay").toString());
            _ps.setString(2, list.get("endDate").toString());
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingPlanComparisonBySimiannual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {

        String startDay = "";
        String endDay = "";
        String year = list.get("year").toString();
        String[] FinalYear = year.split("_");
        String currentBudjuetYear = FinalYear[0];
        String nextBudjuetYear = FinalYear[1];
        if (Integer.parseInt(list.get("simiannualType").toString()) == 1) {
            year = currentBudjuetYear;
            startDay = "" + year + "-07-01";
            endDay = "" + year + "-12-31";
        } else if (Integer.parseInt(list.get("simiannualType").toString()) == 2) {
            year = nextBudjuetYear;
            startDay = "" + year + "-01-01";
            endDay = "" + year + "-06-30";

        }

        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                "WHERE to_date(subStr(TR.START_DATE,1,10),'YYYY-MM-DD')" +
                " BETWEEN TO_DATE(? ,'YYYY-MM-DD') " +
                " AND TO_DATE(? ,'YYYY-MM-DD') " +
                "GROUP BY  (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, startDay);
            _ps.setString(2, endDay);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet readAllTrainingPlanComparisonByAnnual(HashMap list, String employeeId, boolean selectCriteria) throws SQLException {
        String _selectQuery = "SELECT TR.TRAININGORCOURSE_NAME, " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ) AS PLAN_FOR_THE_YEAR, " +
                "  COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END) AS NUMBER_OF_TRAINEE_STILL_NOW, " +
                "  (COUNT( " +
                "  CASE " +
                "    WHEN TR.START_YEAR = '" + list.get("year") + "' " +
                "    THEN 'dd' " +
                "    ELSE NULL " +
                "  END)/ " +
                "  (SELECT SUM(trainreq.number_of_employees) " +
                "  FROM HR_TRAIN_NEED_ASSESSEMENT_REQ trainreq " +
                "  WHERE trainreq.request_status LIKE 'App-%' " +
                "  AND trainreq.budjet_year   ='" + list.get("year") + "' " +
                "  AND trainreq.training_name = tr.trainingorcourse_name " +
                "  ))*100                    AS PLAN_FULFILLED_BY_PERCENT, " +
                "  SUM(PAYMENT_FOR_TRAINING) AS TOTAL_COST_STILL_NOW " +
                "FROM HR_EMP_TRAINING TR " +
                //"WHERE trainreq.budjet_year   ='" + list.get("year") + "' " +
                "WHERE TR.PAYMENT_PAYE_BY = 'BIB' AND TR.START_YEAR = '" + list.get("year") + "'" +
                "GROUP BY (TR.TRAININGORCOURSE_NAME)";
        if (!selectCriteria) {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";

        } else {
            _selectQuery += " ORDER BY TR.TRAININGORCOURSE_NAME desc";
        }

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
}
