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
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class EvaluationResult extends ConnectionManager {

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
    private String empId;
    private String evaCrtCode;
    private String evaSessionCode;
    private String result;
    private String comment;
    private String evaCrtName;
    private String evaResultId;
    private String startDate;
    private String endDate;
    private String empName;
    private int resultID;
    private String evaluatorID;

    public String getEvaluatorID() {
        return evaluatorID;
    }

    public void setEvaluatorID(String evaluatorID) {
        this.evaluatorID = evaluatorID;
    }

    public EvaluationResult() {
    }

    /**
     * @return the resultID
     */
    public int getResultID() {
        return resultID;
    }

    /**
     * @param resultID the resultID to set
     */
    public void setResultID(int resultID) {
        this.resultID = resultID;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     *
     * The constructor instatiates the class with the following parameters.
     * @param empId the unique identifier of the employee
     * @param evaResultId the unique identifier of the evaluation result id
     * @param evaSessionCode the evaluation session id
     * @param evaCrtCode the evaluation criteria
     * @param result the evaluation result
     * @param comment the remark given
     */
    public EvaluationResult(String empId, String evaResultId, String evaSessionCode, String result, String evaCrtCode, String comment) {
        this.empId = empId;
        this.evaResultId = evaResultId;
        this.evaSessionCode = evaSessionCode;
        this.evaCrtCode = evaCrtCode;
        this.result = result;
        this.comment = comment;
    }

    public EvaluationResult(String empId, String evaResultId, String evaSessionCode, String result, String evaCrtCode, String comment, String evaluatorID) {
        this.empId = empId;
        this.evaResultId = evaResultId;
        this.evaSessionCode = evaSessionCode;
        this.evaCrtCode = evaCrtCode;
        this.result = result;
        this.comment = comment;
        this.evaluatorID = evaluatorID;
    }

    /**
     * The method instatiates the class with evaCrtCode and evaCrtName
     * @param evaCrtCode the evaluation criteria code
     * @param evaCrtName the evaluation criteria name
     */
    public EvaluationResult(String evaSessionCode, String empId) {
        this.evaSessionCode = evaSessionCode;
        this.empId = empId;
    }

    public EvaluationResult(String empId, String evaSessionCode, String sessionID) {
        this.evaResultId = evaSessionCode;
        this.empId = empId;
        this.evaSessionCode = sessionID;
    }

    /**
     * The constructor instatiates the class with the  following parameters
     * The constructor instatiates the class with the following parameters.
     * @param empId the unique identifier of the employee
     * @param evaCrtCode the evaluation criteria
     * @param evaSessionCode the evaluation session id
     * @param result the evaluation result
     * @param comment the remark given
     */
    public EvaluationResult(String empId, String evaCrtCode, String evaSessionCode, String result, String comment) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.result = result;
        this.comment = comment;
    }

    public EvaluationResult(int evaResultId, String result, int evaCrtCode, String empId, int evaSessionCode, String remark) {
        this.empId = empId;
        this.evaCrtCode = String.valueOf(evaCrtCode);
        this.evaSessionCode = String.valueOf(evaSessionCode);
        this.result = result;
        this.comment = remark;
        this.resultID = evaResultId;
    }

    /**
     * The constructor instatiates the class with the following parameters.
     * @param empId the unique identifier of the employee
     * @param evaSessionCode the evaluation session id
     * @param evaCrtCode the evaluation criteria
     * @param result the evaluation result
     */
    public EvaluationResult(String empId, String evaSessionCode, String evaCrtCode, String result) {
        this.empId = empId;
        this.evaSessionCode = evaSessionCode;
        this.evaCrtCode = evaCrtCode;
        this.result = result;
    }

    /**
     * The method fetches evaluation sessions authorised by the employee in empId
     * @param empId
     * @return <code>ResultSet</code> object evaRs
     * @throws SQLException if a database access error occurs
     * or this method is called on a closed connection
     */
    public int countEvaResult(int sessionID) {

        HashMap[] list = null;
        String str = "SELECT Max(rownum) as num FROM hr_lu_evaluation_parameter, HR_EVALUATION_SESSION " +
                " WHERE  HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + sessionID + " ' AND hr_lu_evaluation_parameter.CATEGORY = HR_EVALUATION_SESSION.PURPOSE ";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaResultTbl(int sessionID) {

        HashMap[] list = null;
        int i = 0;

        String str = "SELECT hr_lu_evaluation_parameter.EVALUATION_PARA_CODE , " +
                "hr_lu_evaluation_parameter.DESCRIPTION , " +
                "hr_lu_evaluation_parameter.NAME , " +
                "hr_lu_evaluation_parameter.CATEGORY , " +
                "HR_EVALUATION_SESSION.PURPOSE , " +
                "HR_EVALUATION_SESSION.EVALUATION_SESSION_ID " +
                " FROM hr_lu_evaluation_parameter, HR_EVALUATION_SESSION " +
                " WHERE  HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + sessionID + " ' AND hr_lu_evaluation_parameter.CATEGORY = HR_EVALUATION_SESSION.PURPOSE ";

        try {
            list = new HashMap[this.countEvaResult(sessionID)];
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("EVALUATION_PARA_CODE", _rs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("NAME", _rs.getString("NAME"));
                list[i].put("CATEGORY", _rs.getString("CATEGORY"));

                i++;
            }
            return list;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
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
     * @return the evaCrtCode
     */
    public String getEvaCrtCode() {
        return evaCrtCode;
    }

    /**
     * @param evaCrtCode the evaCrtCode to set
     */
    public void setEvaCrtCode(String evaCrtCode) {
        this.evaCrtCode = evaCrtCode;
    }

    /**
     * @return the evaSessionCode
     */
    public String getEvaSessionCode() {
        return evaSessionCode;
    }

    /**
     * @param evaSessionCode the evaSessionCode to set
     */
    public void setEvaSessionCode(String evaSessionCode) {
        this.evaSessionCode = evaSessionCode;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the comment
     */
    public String getComment() {
        return comment;
    }

    /**
     * @param comment the comment to set
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     * @return the evaCrtName
     */
    public String getEvaCrtName() {
        return evaCrtName;
    }

    /**
     * @param evaCrtName the evaCrtName to set
     */
    public void setEvaCrtName(String evaCrtName) {
        this.evaCrtName = evaCrtName;
    }

    /**
     * @return the evaResultId
     */
    public String getEvaResultId() {
        return evaResultId;
    }

    /**
     * @param evaResultId the evaResultId to set
     */
    public void setEvaResultId(String evaResultId) {
        this.evaResultId = evaResultId;
    }

    public ArrayList<EvaluationResult> readAllResult(String toDayInEc) {

        String readEva = "SELECT  hr_evaluation_session.evaluation_Session_Id, " +
                "hr_evaluation_session.start_Date, " +
                "hr_evaluation_session.end_Date, " +
                "hr_evaluation_session.reference_No, " +
                "hr_evaluation_session.reference_Date, " +
                "hr_evaluation_session.authorized_emp_Id, " +
                "hr_evaluation_session.purpose, " +
                "hr_employee_info.first_Name, " +
                "hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name " +
                " FROM hr_evaluation_session, hr_employee_info WHERE '" + toDayInEc + "' " +
                " BETWEEN hr_evaluation_session.start_Date AND hr_evaluation_session.end_Date AND hr_evaluation_session. " +
                "authorized_emp_Id = hr_employee_info.emp_Id";


        ArrayList<EvaluationResult> resultList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationResult resultType = new EvaluationResult(_rs.getString("evaluation_Session_Id"), "For  " + _rs.getString("purpose") + " By  " + _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name"));
                resultList.add(resultType);
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }


    }

    public EvaluationResult searchBySessionID(String sessionID1) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        EvaluationResult searchResultSession = null;

        String strSession = "SELECT  hr_evaluation_session.evaluation_Session_Id, " +
                "hr_evaluation_session.start_Date, " +
                "hr_evaluation_session.end_Date, " +
                "hr_evaluation_session.reference_No, " +
                "hr_evaluation_session.reference_Date, " +
                "hr_evaluation_session.authorized_emp_Id, " +
                "hr_evaluation_session.purpose, " +
                "hr_employee_info.first_Name, " +
                "hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name " +
                "FROM hr_evaluation_session, hr_employee_info WHERE hr_evaluation_session.evaluation_Session_Id = '" + sessionID1 + "' " +
                " AND hr_evaluation_session. " +
                "authorized_emp_Id = hr_employee_info.emp_Id";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strSession);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                this.empName = _rs.getString("first_Name") + " " + _rs.getString("middle_Name") + " " + _rs.getString("last_Name");
                this.startDate = _rs.getString("start_Date");
                this.endDate = _rs.getString("end_Date");
                this.evaSessionCode = _rs.getString("evaluation_Session_Id");
                this.empId = _rs.getString("authorized_emp_Id");

                searchResultSession = new EvaluationResult(startDate, endDate, empName);
            }
            return searchResultSession;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int serEvaSessionResultSearch(String empId, int evaSessionCode) {

        this.setEmpId(empId);
        this.evaSessionCode = String.valueOf(evaSessionCode);

        return this.searchEvaResult(empId, this.evaSessionCode);
    }

    public int serEvaSessionResultSearchA(String empId, int evaSessionCode) {

        this.setEmpId(empId);
        this.evaSessionCode = String.valueOf(evaSessionCode);

        return this.searchEvaResultA(empId, this.evaSessionCode);
    }

    public int addEvaSessionResult(String result, int evaCrtCode, String empId, int evaSessionCode, String comment, String evaluatorID) {
        if (result.equals(null)) {
            this.setResult("5");
        } else {
            this.setResult(result);
        }
        this.setEvaluatorID(evaluatorID);
        this.evaCrtCode = String.valueOf(evaCrtCode);
        this.setEmpId(empId);
        this.evaSessionCode = String.valueOf(evaSessionCode);
        if (comment.equals(null) || comment.equals("")) {
            this.setComment("no Remark");
        } else {
            this.setComment(comment);
        }

        return this.insertEvaResult();
    }

    public int addEvaSessionResult(String result, int evaCrtCode, String empId, int evaSessionCode, String comment, String evaluatorID, boolean invalid) {
        if (invalid == false) {
            if (result.equals(null)) {
                this.setResult("5");
            } else {
                this.setResult(result);
            }
            this.setEvaluatorID(evaluatorID);
            this.evaCrtCode = String.valueOf(evaCrtCode);
            this.setEmpId(empId);
            this.evaSessionCode = String.valueOf(evaSessionCode);
            if (comment.equals(null) || comment.equals("")) {
                this.setComment("no Remark");
            } else {
                this.setComment(comment);
            }

            return this.insertEvaResult();
        }
        return 1;

    }

    public int insertComplainResult(boolean empComp, String complainRemark, String resultID) {
        int empCompVal = 0;
        String compRemark = "no remark";
        if (empComp == true) {
            empCompVal = 2;
        } else {
            empCompVal = 1;
        }

        if (complainRemark != null && !complainRemark.equals("")) {
            compRemark = complainRemark;
        } else {
            compRemark = "no remark";
        }

        return this.insertComplainResult(empCompVal, compRemark, resultID);
    }

    public int resolveComplainResult(boolean compApp, String resolveRemark, String resultID) {
        int empCompValResolve = 0;
        String manRemark = "no remark";
        if (compApp == true) {
            empCompValResolve = 2;
        } else {
            empCompValResolve = 1;
        }
        if (resolveRemark != null && !resolveRemark.equals("")) {
            manRemark = resolveRemark;
        } else {
            manRemark = "no remark";
        }
        return this.resolveComplainResult(empCompValResolve, manRemark, resultID);
    }

    public int addEvaSessionResultUpdate(int evaResultId, String result, int evaCrtCode, String empId, int evaSessionCode, String remark, int btnIndc) {
        this.setResult(result);
        this.evaCrtCode = String.valueOf(evaCrtCode);
        this.setEmpId(empId);
        this.evaSessionCode = String.valueOf(evaSessionCode);
        if (remark.equals(null) || remark.equals("")) {
            this.setComment("no Remark");
        } else {
            this.setComment(remark);
        }

        this.setResultID(evaResultId);


        return this.updateEvaResult(evaResultId, btnIndc);
    }

    public int addEvaSessionResultDelete(int evaResultId) {

        this.setResultID(evaResultId);


        return this.deleteEvaResult(evaResultId);
    }

    /**
     * The method inserts data into hr_emp_evaluation_result table
     * (Note: the setter method of the class must be called before calling this method.)
     * @return either (1) the row count for the result of insert statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    private int searchEvaResultA(String empId, String evaSessionCode) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strSearchEvaResult = "SELECT * FROM HR_EVALUATION_SESSION " +
                " WHERE HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + empId + "' " +
                " AND " +
                " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + evaSessionCode + "' ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strSearchEvaResult);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    private int searchEvaResult(String empId, String evaSessionCode) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strSearchEvaResult = "SELECT * FROM HR_EVALUATION_RESULT " +
                " WHERE HR_EVALUATION_RESULT.EMP_ID = '" + empId + "' AND HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + evaSessionCode + "' ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strSearchEvaResult);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    private int insertEvaResult() 
           {

        String resultGivenDate = StringDateManipulation.toDayInEc();
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strInserEvaResult = "INSERT INTO HR_EVALUATION_RESULT " +
                "(result, evaluation_Para_Code, emp_Id, evaluation_Session_Id, remark, EVALUATOR_ID, EVA_RESULT_TAKEN_DATE) " +
                "VALUES (?, ?, ?, ?, ?, ?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strInserEvaResult);
            _ps.setString(1, this.getResult());
            _ps.setInt(2, Integer.valueOf(this.getEvaCrtCode()));
            _ps.setString(3, this.getEmpId());
            _ps.setInt(4, Integer.valueOf(this.getEvaSessionCode()));
            _ps.setString(5, this.getComment());
            _ps.setString(6, this.getEvaluatorID());
            _ps.setString(7, resultGivenDate);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }
     public int insertEvaluationPercentValue(String evaluaterID, String evaluatedEmpID, double lastAveValue, double lastPercentValue, double lastResult, String sessionID, String currentDate) {
         PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strInserEvaResult = "INSERT INTO HR_EVALUATION_PERCENT_VALUE " +
                "(VALUE_ID, SESSION_ID, EVALUATOR_EMP_ID, EVALUTED_EMP_ID,PERCENT_VALUE, TOTAL_VALUE,AVERAGE_VALUE,RESULT_SAVED_DATE) " +
                "VALUES (HR_EVALU_PERCENT_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strInserEvaResult);
            _ps.setString(1, sessionID);
            _ps.setString(2, evaluaterID);
            _ps.setString(3, evaluatedEmpID);
            _ps.setDouble(4,lastPercentValue);
            _ps.setDouble(5, lastResult);
            _ps.setDouble(6, lastAveValue);
            _ps.setString(7, currentDate);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    private int updateEvaResult(int resultId, int btnIndc) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        int evaluatorComp = 0;

        String strUpdateEvaResult = "UPDATE HR_EVALUATION_RESULT " +
                " SET " +
                " result = ? , " +
                " evaluation_Para_Code = ? , " +
                " emp_Id = ? , " +
                " evaluation_Session_Id = ? , " +
                " remark = ?," +
                " evaluator_comp = ? " +
                " WHERE " +
                " HR_EVALUATION_RESULT.EVALUATION_RESULT_ID = '" + resultId + "' ";

        if (btnIndc == 8) {
            evaluatorComp = 1;
        }


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strUpdateEvaResult);
            _ps.setString(1, this.getResult());
            _ps.setInt(2, Integer.valueOf(this.getEvaCrtCode()));
            _ps.setString(3, this.getEmpId());
            _ps.setInt(4, Integer.valueOf(this.getEvaSessionCode()));
            _ps.setString(5, this.getComment());
            _ps.setInt(6, evaluatorComp);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    private int deleteEvaResult(int resultId) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strUpdateEvaResult = "DELETE FROM HR_EVALUATION_RESULT  " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_RESULT_ID = '" + resultId + "' ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strUpdateEvaResult);


            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<EvaluationResult> readIndividualSessionResults(String sessionId, String empID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = " SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                " hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " hr_evaluation_session.EVALUATION_SESSION_ID, HR_EVALUATION_RESULT.evaluation_Session_Id AS evaResultSID " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                " HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                " hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                " hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + empID + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id") + "---" + _rs.getString("evaResultSID"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readAllIndividualSessionResults(String evaluatorID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = " SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                " hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " hr_evaluation_session.EVALUATION_SESSION_ID, HR_EVALUATION_RESULT.evaluation_Session_Id AS evaResultSID " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                " HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                " hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + evaluatorID + "' ";


        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id") + "---" + _rs.getString("evaResultSID"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readSessionResults(String sessionId, String evaluatorID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = " SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                " hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " hr_evaluation_session.EVALUATION_SESSION_ID " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                " HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                " hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                " hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + evaluatorID + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id") + "---" + _rs.getString("EVALUATION_SESSION_ID"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readSessionResultsEvaluatee(String sessionId, String evaluatorID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = "SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                "HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                "hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                "hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.evaluator_id = '" + evaluatorID + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readEvaluationResultsUsingEvaluator(String evaluatorID, String sessionID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = " SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                " hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " hr_evaluation_session.evaluation_Session_Id " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session " +
                " WHERE " +
                " HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id " +
                " AND " +
                " hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id " +
                " AND " +
                " hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATOR_ID = '" + evaluatorID + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id"), _rs.getString("evaluation_Session_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readSessionResultsComplained(String sessionId, String evaluatorID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = "SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP,hr_evaluation_session.evaluation_Session_Id " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                "HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                "hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                "hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + evaluatorID + "'" +
                " AND EMP_COMP = '" + 2 + "' AND MANAGER_COMP = '" + 2 + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id") + "---" + _rs.getString("evaluation_Session_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readSessionResultsComplainedResolver(String sessionId, String evaluatorID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = "SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP,hr_evaluation_session.evaluation_Session_Id " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                "HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                "hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                "hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + evaluatorID + "'" +
                " AND EMP_COMP = '" + 2 + "'";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id") + "---" + _rs.getString("evaluation_Session_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readSessionResultsResolve(String sessionId, String resolverID) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = "SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                "HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                "hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                "hr_evaluation_session.EVALUATION_SESSION_ID = '" + sessionId + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = '" + resolverID + "'" +
                " AND EMP_COMP = '" + 1 + "' AND MANAGER_COMP = '" + 1 + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public int countEvaSessionResult(String counter, String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String str = "SELECT Max(rownum) as num FROM HR_EVALUATION_RESULT  WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + counter + "'  AND HR_EVALUATION_RESULT.EMP_ID = '" + empid + "' ";
        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("num");
            }
            return 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaSessionResultTbl(String sessionID, String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        HashMap[] list = null;
        int i = 0;

        String str = " SELECT HR_EVALUATION_RESULT.EVALUATION_RESULT_ID, HR_EVALUATION_RESULT.RESULT, " +
                " HR_EVALUATION_RESULT.EVALUATION_PARA_CODE, HR_EVALUATION_RESULT.EMP_ID, " +
                " HR_EVALUATION_RESULT.EVALUATOR_ID, HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, " +
                " HR_EVALUATION_RESULT.REMARK, HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP, " +
                " HR_EVALUATION_RESULT.EMP_REMARK, " +
                " HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE, " +
                " HR_LU_EVALUATION_PARAMETER.NAME, HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME, " +
                " hr_employee_info.job_Code, hr_lu_job_type.JOB_NAME, hr_lu_job_type.job_Code " +
                " FROM HR_EMPLOYEE_INFO, HR_EVALUATION_RESULT, HR_LU_EVALUATION_PARAMETER, hr_lu_job_type " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND HR_EVALUATION_RESULT.EMP_ID = '" + empid + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE " +
                " AND HR_EMPLOYEE_INFO.EMP_ID = '" + empid + "' AND hr_lu_job_type.job_Code = hr_employee_info.job_Code ";

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
                list[i].put("EVALUATION_RESULT_ID", ocrs.getInt("EVALUATION_RESULT_ID"));
                list[i].put("RESULT", ocrs.getString("RESULT"));
                list[i].put("EVALUATION_PARA_CODE", ocrs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                list[i].put("EVALUATION_SESSION_ID", ocrs.getInt("EVALUATION_SESSION_ID"));
                list[i].put("REMARK", ocrs.getString("REMARK"));
                list[i].put("NAME", ocrs.getString("NAME"));
                list[i].put("FULL_NAME", ocrs.getString("FIRST_NAME") + ocrs.getString("MIDDLE_NAME") + ocrs.getString("LAST_NAME"));
                list[i].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                list[i].put("EVALUATOR_ID", ocrs.getString("EVALUATOR_ID"));
                list[i].put("EMP_COMP", ocrs.getString("EMP_COMP"));
                list[i].put("MANAGER_COMP", ocrs.getString("MANAGER_COMP"));
                list[i].put("EMP_REMARK", ocrs.getString("EMP_REMARK"));

                i++;
            }

            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public String readEvaluatorFullName(String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        String list = "";


        String str = " SELECT HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME " +
                " FROM HR_EMPLOYEE_INFO " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = '" + empid + "' ";

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();


            while (ocrs.next()) {

                list = ocrs.getString("FIRST_NAME") + ocrs.getString("MIDDLE_NAME") + ocrs.getString("LAST_NAME");

            }

            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<EvaluationResult> readAllEvaluatieeInfo(String empId) {

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        String _select = "SELECT DISTINCT hr_employee_info.first_Name, hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name , HR_EVALUATION_RESULT.EMP_ID " +
                " FROM  HR_EVALUATION_RESULT , hr_employee_info, hr_evaluation_session WHERE " +
                "HR_EVALUATION_RESULT.emp_Id = hr_employee_info.emp_Id AND " +
                "hr_evaluation_session.evaluation_Session_Id = HR_EVALUATION_RESULT.evaluation_Session_Id AND " +
                "hr_evaluation_session.EVALUATION_SESSION_ID = '" + empId + "' ";

        ArrayList<EvaluationResult> evalualuatedEmp = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                EvaluationResult terEntity = new EvaluationResult(_rs.getString("emp_Id"), _rs.getString("first_Name") + "  " + _rs.getString("middle_Name") + "  " + _rs.getString("last_Name") + "---" + _rs.getString("emp_Id"));
                evalualuatedEmp.add(terEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }
        }
        return evalualuatedEmp;
    }

    public ArrayList<EvaluationResult> readAllPurposeForResultDisplay() {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String readResultPurp = "SELECT  Distinct hr_evaluation_session.evaluation_Session_Id, " +
                " hr_evaluation_session.PURPOSE, " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID " +
                " FROM hr_evaluation_session, HR_EVALUATION_RESULT WHERE " +
                " hr_evaluation_session.EVALUATION_SESSION_ID = HR_EVALUATION_RESULT.EVALUATION_SESSION_ID";



        ArrayList<EvaluationResult> resultList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readResultPurp);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationResult resultType = new EvaluationResult(_rs.getString("purpose") + "-" + _rs.getString("evaluation_Session_Id"), _rs.getString("purpose"));
                resultList.add(resultType);
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }

    }

    public ArrayList<EvaluationResult> readAllDateForResultDisplay(String purposeDisp) {
        

        String readResultPurp = " SELECT  Distinct hr_evaluation_session.evaluation_Session_Id, " +
                " hr_evaluation_session.PURPOSE, " +
                " hr_evaluation_session.START_DATE, " +
                " hr_evaluation_session.END_DATE, " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID " +
                " FROM hr_evaluation_session, HR_EVALUATION_RESULT WHERE " +
                " hr_evaluation_session.EVALUATION_SESSION_ID = HR_EVALUATION_RESULT.EVALUATION_SESSION_ID " +
                " AND hr_evaluation_session.PURPOSE like '" + purposeDisp +"--%'";
        // LIKE '" + list.get("year") + "-%" +
               // = '" + purposeDisp + "'";


        ArrayList<EvaluationResult> resultList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readResultPurp);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationResult resultType = new EvaluationResult(_rs.getString("evaluation_Session_Id"), _rs.getString("START_DATE") + "---" + _rs.getString("END_DATE"));
                resultList.add(resultType);
            }

            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }

    }

    public ArrayList<EvaluationResult> readEvaluatorToResolve(String sessionId, String resolverID) {

        PreparedStatement _ps1 = null;
        ResultSet _rs1 = null;
        String structHolder = "";


        String readEmpOrgStracture = " SELECT  HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.department_id " +
                " FROM HR_EMPLOYEE_INFO " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = '" + resolverID + "'";

        String readResultPurp = " SELECT DISTINCT  HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, " +
                " HR_EMPLOYEE_INFO.MIDDLE_NAME, " +
                " HR_EMPLOYEE_INFO.LAST_NAME, " +
                " HR_EVALUATION_RESULT.EVALUATOR_ID, " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID" +
                " FROM HR_EMPLOYEE_INFO, HR_EVALUATION_RESULT " +
                " WHERE " +
                "  HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionId + "'" +
                " AND HR_EVALUATION_RESULT.EVALUATOR_ID = HR_EMPLOYEE_INFO.EMP_ID";


        ArrayList<EvaluationResult> resultList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps1 = _con.prepareStatement(readEmpOrgStracture);
            _rs = _ps1.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            while (ocrs.next()) {
                if (ocrs.getString("department_id") != null) {
                    structHolder = ocrs.getString("department_id");

                }

            }
            _ps = _con.prepareStatement(readResultPurp);
            //_ps.setString(1, structHolder);
//            _ps.setString(1, sessionId);

            _rs1 = _ps.executeQuery();
            OracleCachedRowSet ocrs1 = new OracleCachedRowSet();
            ocrs1.populate(_rs1);
            _rs1.close();

            while (ocrs1.next()) {
                EvaluationResult resultType = new EvaluationResult(ocrs1.getString("EMP_ID"), ocrs1.getString("FIRST_NAME") + " " + ocrs1.getString("MIDDLE_NAME") + " " + ocrs1.getString("LAST_NAME"));
                resultList.add(resultType);
            }
            return resultList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return null;
        } 
        finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    private int insertComplainResult(int compVal, String complainRemark, String resultId) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strInserEvaResult = " UPDATE HR_EVALUATION_RESULT " +
                " SET EMP_COMP = ?, EMP_REMARK = ? " +
                " WHERE EVALUATION_RESULT_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strInserEvaResult);
            _ps.setInt(1, compVal);
            _ps.setString(2, complainRemark);
            _ps.setString(3, resultId);


            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    private int resolveComplainResult(int compVal, String resolveRemark, String resultId) {
        String resultGivenDate = StringDateManipulation.toDayInEc();

        String strInserEvaResult = " UPDATE HR_EVALUATION_RESULT " +
                " SET MANAGER_COMP = ?, RESOLVER_REMARK = ? " +
                " WHERE EVALUATION_RESULT_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strInserEvaResult);
            _ps.setInt(1, compVal);
            _ps.setString(2, resolveRemark);
            _ps.setString(3, resultId);


            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaSessionResultComplainTbl(String sessionID, String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        HashMap[] list = null;
        int i = 0;

        String str = " SELECT HR_EVALUATION_RESULT.EVALUATION_RESULT_ID, HR_EVALUATION_RESULT.RESULT," +
                " HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP, HR_EVALUATION_RESULT.EVALUATOR_COMP, " +
                " HR_EVALUATION_RESULT.EVALUATION_PARA_CODE, HR_EVALUATION_RESULT.EMP_ID, " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, " +
                " HR_EVALUATION_RESULT.EMP_REMARK, " +
                " HR_EVALUATION_RESULT.RESOLVER_REMARK, " +
                " HR_EVALUATION_RESULT.REMARK, HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE, " +
                " HR_LU_EVALUATION_PARAMETER.NAME, HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME, " +
                " hr_employee_info.job_Code, hr_lu_job_type.JOB_NAME, hr_lu_job_type.job_Code " +
                " FROM HR_EMPLOYEE_INFO, HR_EVALUATION_RESULT, HR_LU_EVALUATION_PARAMETER, hr_lu_job_type " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND HR_EVALUATION_RESULT.EMP_ID = '" + empid + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE " +
                " AND HR_EMPLOYEE_INFO.EMP_ID = '" + empid + "' AND hr_lu_job_type.job_Code = hr_employee_info.job_Code ";

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
                list[i].put("EVALUATION_RESULT_ID", ocrs.getInt("EVALUATION_RESULT_ID"));
                list[i].put("RESULT", ocrs.getString("RESULT"));
                list[i].put("EVALUATION_PARA_CODE", ocrs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                list[i].put("EVALUATION_SESSION_ID", ocrs.getInt("EVALUATION_SESSION_ID"));
                list[i].put("REMARK", ocrs.getString("REMARK"));
                list[i].put("NAME", ocrs.getString("NAME"));
                list[i].put("FULL_NAME", ocrs.getString("FIRST_NAME") + ocrs.getString("MIDDLE_NAME") + ocrs.getString("LAST_NAME"));
                list[i].put("JOB_NAME", ocrs.getString("JOB_NAME"));
                list[i].put("EMP_COMP", ocrs.getString("EMP_COMP"));
                list[i].put("MANAGER_COMP", ocrs.getString("MANAGER_COMP"));
                list[i].put("EVALUATOR_COMP", ocrs.getString("EVALUATOR_COMP"));
                list[i].put("EMP_REMARK", ocrs.getString("EMP_REMARK"));
                list[i].put("RESOLVER_REMARK", ocrs.getString("RESOLVER_REMARK"));

                i++;
            }

            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaSessionResultComplainTblSingle(String sessionID, String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        HashMap[] list = null;
        int i = 0;

        String str = " SELECT HR_EVALUATION_RESULT.EVALUATION_RESULT_ID, HR_EVALUATION_RESULT.RESULT," +
                " HR_EVALUATION_RESULT.EVALUATION_PARA_CODE, HR_EVALUATION_RESULT.EMP_ID, " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, " +
                " HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE, " +
                " HR_EMPLOYEE_INFO.EMP_ID, " +
                " hr_employee_info.job_Code, hr_lu_job_type.job_Code " +
                " FROM HR_EMPLOYEE_INFO, HR_EVALUATION_RESULT, HR_LU_EVALUATION_PARAMETER, hr_lu_job_type " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND HR_EVALUATION_RESULT.EMP_ID = '" + empid + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE " +
                " AND HR_EMPLOYEE_INFO.EMP_ID = '" + empid + "' " +
                " AND hr_lu_job_type.job_Code = hr_employee_info.job_Code ";

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
                list[i].put("RESULT", ocrs.getString("RESULT"));

                i++;
            }

            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap[] readEvaSessionResultComplainToEvaluatorTbl(String sessionID, String empid) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        HashMap[] list = null;
        int i = 0;

        String str = " SELECT HR_EVALUATION_RESULT.EVALUATION_RESULT_ID, HR_EVALUATION_RESULT.RESULT, " +
                " HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP, " +
                " HR_EVALUATION_RESULT.EVALUATION_PARA_CODE, " +
                " HR_EVALUATION_RESULT.EMP_REMARK, " +
                " HR_EVALUATION_RESULT.RESOLVER_REMARK, " +
                " HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, " +
                " HR_EVALUATION_RESULT.REMARK, HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE, " +
                " HR_LU_EVALUATION_PARAMETER.NAME, HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME, " +
                " hr_employee_info.job_Code, hr_lu_job_type.JOB_NAME, hr_lu_job_type.job_Code " +
                " FROM HR_EMPLOYEE_INFO, HR_EVALUATION_RESULT, HR_LU_EVALUATION_PARAMETER, hr_lu_job_type " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND HR_EVALUATION_RESULT.EMP_ID = '" + empid + "' " +
                " AND HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE " +
                " AND HR_EMPLOYEE_INFO.EMP_ID = '" + empid + "' AND hr_lu_job_type.job_Code = hr_employee_info.job_Code ";

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
                list[i].put("EVALUATION_RESULT_ID", ocrs.getInt("EVALUATION_RESULT_ID"));
                list[i].put("RESULT", ocrs.getString("RESULT"));
                list[i].put("EVALUATION_PARA_CODE", ocrs.getInt("EVALUATION_PARA_CODE"));
                list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                list[i].put("EVALUATION_SESSION_ID", ocrs.getInt("EVALUATION_SESSION_ID"));
                list[i].put("REMARK", ocrs.getString("REMARK"));
                list[i].put("NAME", ocrs.getString("NAME"));
                list[i].put("FULL_NAME", ocrs.getString("FIRST_NAME") + ocrs.getString("MIDDLE_NAME") + ocrs.getString("LAST_NAME"));
                list[i].put("JOB_DESCRIPTION", ocrs.getString("JOB_DESCRIPTION"));
                list[i].put("EMP_COMP", ocrs.getString("EMP_COMP"));
                list[i].put("MANAGER_COMP", ocrs.getString("MANAGER_COMP"));
                list[i].put("EMP_REMARK", ocrs.getString("EMP_REMARK"));
                list[i].put("RESOLVER_REMARK", ocrs.getString("RESOLVER_REMARK"));

                i++;
            }

            return list;
        } catch (SQLException ex) {

            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<EvaluationResult> readAllSessionsResultsGivenTo() {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strReadSessionDate = " SELECT HR_EVALUATION_SESSION.EVALUATION_SESSION_ID," +
                " HR_EVALUATION_SESSION.START_DATE," +
                " HR_EVALUATION_SESSION.END_DATE" +
                " FROM HR_EVALUATION_SESSION ";
        ArrayList<EvaluationResult> resultSessionList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strReadSessionDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            while (ocrs.next()) {
                EvaluationResult evaResultForSession = new EvaluationResult(ocrs.getString("EVALUATION_SESSION_ID"), "From  " + ocrs.getString("START_DATE") + "  To  " + ocrs.getString("END_DATE"));
                resultSessionList.add(evaResultForSession);
            }



            return resultSessionList;


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<EvaluationResult> readAllSessionsResultsGivenToPromotion() {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        String purpose = "Promotion";

        String strReadSessionDate = " SELECT HR_EVALUATION_SESSION.EVALUATION_SESSION_ID," +
                " HR_EVALUATION_SESSION.START_DATE," +
                " HR_EVALUATION_SESSION.END_DATE" +
                " FROM HR_EVALUATION_SESSION " +
                " WHERE" +
                " HR_EVALUATION_SESSION.PURPOSE = '" + purpose + "'";
        ArrayList<EvaluationResult> resultSessionList = new ArrayList<EvaluationResult>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strReadSessionDate);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            while (ocrs.next()) {
                EvaluationResult evaResultForSession = new EvaluationResult(ocrs.getString("EVALUATION_SESSION_ID"), "From  " + ocrs.getString("START_DATE") + "  To  " + ocrs.getString("END_DATE"));
                resultSessionList.add(evaResultForSession);
            }



            return resultSessionList;


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int indicatorOfCreiteriaUsage(int paraCode) {

        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String strSearchEvaResult = "SELECT HR_EVALUATION_RESULT.EVALUATION_PARA_CODE FROM HR_EVALUATION_RESULT " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = '" + paraCode + "' ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strSearchEvaResult);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int indicatorOfSessionUsage(int sessionID) {

        PreparedStatement _ps = null;
        Connection _con = null;

        String strSearchEvaResult = "SELECT HR_EVALUATION_RESULT.EVALUATION_SESSION_ID FROM HR_EVALUATION_RESULT " +
                " WHERE HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strSearchEvaResult);

            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            //ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public OracleCachedRowSet loadEvaluationReportToTable(String strSearch) {
        String _select = " SELECT DISTINCT " +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME," +
                " HR_EMPLOYEE_INFO.LAST_NAME, HR_EMPLOYEE_INFO.SEX, HR_EMPLOYEE_INFO.PAY_GRADE, " +
                " HR_EMPLOYEE_INFO.RANK_ID,HR_EMPLOYEE_INFO.JOB_CODE, HR_EMPLOYEE_INFO.TITLE," +
                " HR_EMPLOYEE_INFO.TITLE, HR_EMPLOYEE_INFO.EMP_STATUS, HR_EMPLOYEE_INFO.DEPARTMENT_ID, " +
                " HR_EMPLOYEE_INFO.DIRECTORATE, HR_EMPLOYEE_INFO.DIVISION, HR_EMPLOYEE_INFO.MASTEBABRIYA," +
                " HR_EMPLOYEE_INFO.TEAM, " +
                " HR_LU_RANK.RANK_ID, NVL(HR_LU_RANK.RANK_DESCRIPTION, '') AS RDESCR," +
                " HR_LU_TITLE.TITLE_ID, HR_LU_TITLE.TITLE_DESCRIPTION " +
                " FROM " +
                " HR_EMPLOYEE_INFO, HR_LU_EVALUATION_PARAMETER, HR_EVALUATION_SESSION, HR_EVALUATION_RESULT," +
                " HR_LU_RANK, HR_LU_TITLE, HR_EVA_PURPOSE " +
                " WHERE " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_LU_EVALUATION_PARAMETER.CATEGORY " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATION_PARA_CODE = HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE " +
                " AND " +
                " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = HR_EVALUATION_RESULT.EVALUATION_SESSION_ID " +
                " AND " +
                " HR_EVALUATION_SESSION.PURPOSE = HR_LU_EVALUATION_PARAMETER.CATEGORY " +
                " AND " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EVALUATION_RESULT.EMP_ID" +
                " AND " +
                " HR_LU_RANK.RANK_ID_SEQ = HR_EMPLOYEE_INFO.RANK_ID" +
                " AND " +
                " HR_LU_TITLE.TITLE_ID = HR_EMPLOYEE_INFO.TITLE " +
                " AND " +
                " " + strSearch + " ";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
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

    public OracleCachedRowSet loadEvaluationReport(String strSearch, String empID) {
        String _select = " SELECT " +
                " HR_EMPLOYEE_INFO.EMP_ID, HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME," +
                " HR_EMPLOYEE_INFO.LAST_NAME, HR_EMPLOYEE_INFO.SEX, HR_EMPLOYEE_INFO.PAY_GRADE, " +
                " HR_EMPLOYEE_INFO.RANK_ID,HR_EMPLOYEE_INFO.JOB_CODE, HR_EMPLOYEE_INFO.TITLE," +
                " HR_EMPLOYEE_INFO.TITLE, HR_EMPLOYEE_INFO.EMP_STATUS, HR_EMPLOYEE_INFO.DEPARTMENT_ID, " +
                " HR_EMPLOYEE_INFO.DIRECTORATE, HR_EMPLOYEE_INFO.DIVISION, HR_EMPLOYEE_INFO.MASTEBABRIYA," +
                " HR_EMPLOYEE_INFO.TEAM, HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE," +
                " HR_LU_EVALUATION_PARAMETER.CATEGORY, HR_LU_EVALUATION_PARAMETER.NAME AS CRITERIA_NAME, " +
                " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID, HR_EVALUATION_SESSION.START_DATE, HR_EVALUATION_SESSION.END_DATE," +
                " HR_EVALUATION_SESSION.PURPOSE, HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID, " +
                " HR_EVALUATION_RESULT.EVALUATION_RESULT_ID, HR_EVALUATION_RESULT.RESULT, HR_EVALUATION_RESULT.EVALUATION_PARA_CODE," +
                " HR_EVALUATION_RESULT.EMP_ID, HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, HR_EVALUATION_RESULT.EVA_RESULT_TAKEN_DATE," +
                " HR_EVALUATION_RESULT.EVALUATOR_ID, HR_EVALUATION_RESULT.EMP_COMP, HR_EVALUATION_RESULT.MANAGER_COMP," +
                " HR_EVALUATION_RESULT.EVALUATOR_COMP, HR_EVALUATION_RESULT.EMP_REMARK, HR_EVALUATION_RESULT.RESOLVER_REMARK, " +
                " HR_LU_RANK.RANK_ID, NVL(HR_LU_RANK.RANK_DESCRIPTION, '') AS RDESCR," +
                " HR_LU_TITLE.TITLE_ID, HR_LU_TITLE.TITLE_DESCRIPTION " +
                " FROM " +
                " HR_EMPLOYEE_INFO, HR_LU_EVALUATION_PARAMETER, HR_EVALUATION_SESSION, HR_EVALUATION_RESULT," +
                " HR_LU_RANK, HR_LU_TITLE " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = HR_EVALUATION_RESULT.EMP_ID" +
                " AND " +
                " HR_LU_EVALUATION_PARAMETER.EVALUATION_PARA_CODE = HR_EVALUATION_RESULT.EVALUATION_PARA_CODE " +
                " AND " +
                " HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = HR_EVALUATION_RESULT.EVALUATION_SESSION_ID " +
                " AND " +
                " HR_LU_RANK.RANK_ID_SEQ = HR_EMPLOYEE_INFO.RANK_ID" +
                " AND " +
                " HR_LU_TITLE.TITLE_ID = HR_EMPLOYEE_INFO.TITLE " +
                " AND " +
                " " + strSearch + " ";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
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

    public OracleCachedRowSet loadDeptDetail(String empID) {
        String _select = " SELECT " +
                " HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.DEPARTMENT_ID, " +
                " HR_EMPLOYEE_INFO.DIRECTORATE, HR_EMPLOYEE_INFO.DIVISION, " +
                " HR_EMPLOYEE_INFO.MASTEBABRIYA, HR_EMPLOYEE_INFO.TEAM, " +
                " TBL_DEPARTMENT.DEPT_ID, TBL_DEPARTMENT.DEP_DESCRIPTION " +
                " FROM " +
                " HR_EMPLOYEE_INFO, TBL_DEPARTMENT " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = '" + empID + "' " +
                " AND " +
                " (TBL_DEPARTMENT.DEPT_ID = HR_EMPLOYEE_INFO.DEPARTMENT_ID " +
                "  OR " +
                "  TBL_DEPARTMENT.DEPT_ID = HR_EMPLOYEE_INFO.DIRECTORATE " +
                "  OR " +
                "  TBL_DEPARTMENT.DEPT_ID = HR_EMPLOYEE_INFO.DIVISION " +
                "  OR " +
                "  TBL_DEPARTMENT.DEPT_ID = HR_EMPLOYEE_INFO.MASTEBABRIYA" +
                "  OR " +
                "  TBL_DEPARTMENT.DEPT_ID = HR_EMPLOYEE_INFO.TEAM )";
        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
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

    public OracleCachedRowSet loadEvaluatorsDetail(String empID) {
        String _select = " SELECT " +
                " HR_EMPLOYEE_INFO.EMP_ID, " +
                " HR_EMPLOYEE_INFO.FIRST_NAME, " +
                " HR_EMPLOYEE_INFO.MIDDLE_NAME," +
                " HR_EMPLOYEE_INFO.LAST_NAME, " +
                " HR_EMPLOYEE_INFO.SEX " +
                " FROM " +
                " HR_EMPLOYEE_INFO " +
                " WHERE " +
                " HR_EMPLOYEE_INFO.EMP_ID = '" + empID + "' ";

        ResultSet _rs = null;
        Connection _con = null;
        PreparedStatement _ps = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
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
}
