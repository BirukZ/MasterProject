/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeHistoryEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class EvaluationSession extends ConnectionManager {

    PreparedStatement _ps = null;
    ResultSet _rs = null;
    Connection _con = null;

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
    private String evaId;
    private String startDate;
    private String endDate;
    private String referenceNo;
    private String referenceDate;
    private String authorizedEmpID;
    private String purpose;
    private int purpID;
    private String purpName;
    private String sessionID;
    private String new_start_date;

    public String getNew_end_date() {
        return new_end_date;
    }

    public String getNew_start_date() {
        return new_start_date;
    }

    public void setNew_end_date(String new_end_date) {
        this.new_end_date = new_end_date;
    }

    public void setNew_start_date(String new_start_date) {
        this.new_start_date = new_start_date;
    }
    private String new_end_date;

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    /**
     * @return the purpID
     */
    public int getPurpID() {
        return purpID;
    }

    /**
     * @param purpID the purpID to set
     */
    public void setPurpID(int purpID) {
        this.purpID = purpID;
    }

    /**
     * @return the purpName
     */
    public String getPurpName() {
        return purpName;
    }

    /**
     * @param purpName the purpName to set
     */
    public void setPurpName(String purpName) {
        this.purpName = purpName;
    }

    /**
     * The default constructor used to instatiate the class without a parameter.
     */
    public EvaluationSession() {
    }

    /**
     *
     * The constructor is used to instatiate the class with the specified parametrs.
     * @param evaStartDate the evaluation starting date
     * @param evaEndDate the evaluation ending date
     * @param refNo the reference no
     * @param refDate the reference date
     * @param authorizedBy the employee who authorised it
     */
    public EvaluationSession(int purpID, String purpName) {
        this.purpID = purpID;
        this.purpName = purpName;
    }

    public EvaluationSession(String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose) {
        this.startDate = evaStartDate;
        this.endDate = evaEndDate;
        this.referenceNo = refNo;
        this.referenceDate = refDate;
        this.authorizedEmpID = authorizedEmpID;
        this.purpose = purpose;
    }

    /**
     * The constructor is used to instatiate the class with the specified parametrs
     * @param evaId evaluation session id
     * @param startDate the evaluation starting date
     * @param endDate the evaluation ending date
     * @param referenceNo the reference no
     * @param referenceDate the reference date
     * @param authorizedBy the employee who authorised it
     */
    /**
     * @return the evaId
     */
    public EvaluationSession(String sessionID, String startingDate, String endingDate, int x) {
        this.startDate = startingDate;
        this.endDate = endingDate;
        this.sessionID = sessionID;
    }

    public String getEvaId() {
        return evaId;
    }

    /**
     * @param evaId the evaId to set
     */
    public void setEvaId(String evaId) {
        this.evaId = evaId;
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
     * @return the referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * @param referenceNo the referenceNo to set
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * @return the referenceDate
     */
    public String getReferenceDate() {
        return referenceDate;
    }

    /**
     * @param referenceDate the referenceDate to set
     */
    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    /**
     * @return the authorizedBy
     */
    public String getAuthorizedEmpID() {
        return authorizedEmpID;
    }

    /**
     * @param authorizedBy the authorizedBy to set
     */
    public void setAuthorizedEmpID(String authorizedEmpID) {
        this.authorizedEmpID = authorizedEmpID;
    }

    /**
     * @return the authoriserFullName
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param authoriserFullName the authoriserFullName to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public EvaluationSession(String evaId, String purpose) {
        this.evaId = evaId;
        this.purpose = purpose;
    }

    public EvaluationSession(String evaId, String startDate, String endDate, String referenceNo, String referenceDate, String authorizedEmpID, String purpose) {
        this.evaId = evaId;
        this.startDate = startDate;
        this.endDate = endDate;
        this.referenceNo = referenceNo;
        this.referenceDate = referenceDate;
        this.authorizedEmpID = authorizedEmpID;
        this.purpose = purpose;
    }

    /**
     * The constructor is used to instatiate the class with the specified parametrs
     * @param evaId evaluation session id
     * @param startDate the evaluation starting date
     * @param endDate the evaluation ending date
     * @param referenceNo the reference no
     * @param referenceDate the reference date
     * @param authorizedBy the employee who authorised it
     * @param authoriserFullName the full name of the employee who authorised the evaluation
     */
    public ArrayList<HashMap> readCurrentEva(String toDayInEc) {

        ArrayList<HashMap> eva = null;
        String readEva = "SELECT ALL hr_evaluation_session.`evaluation_Session_Id`, " +
                "hr_evaluation_session.start_Date, " +
                "hr_evaluation_session.end_Date, " +
                "hr_evaluation_session.reference_No, " +
                "hr_evaluation_session.reference_Date, " +
                "hr_evaluation_session.authorizedby_emp_Id, " +
                "hr_employee_info.first_Name, " +
                "hr_employee_info.middle_Name, " +
                "hr_employee_info.last_Name " +
                "FROM hr_evaluation_session " +
                "INNER JOIN hr_employee_info ON hr_evaluation_session. " +
                "authorizedby_emp_Id = hr_employee_info.`emp_Id`  WHERE '" + toDayInEc + "' " +
                "BETWEEN hr_evaluation_session.start_Date AND hr_evaluation_session.end_Date";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap data = new HashMap();
                data.put("session", _rs.getString("evaluation_Session_Id"));
                data.put("startDate", _rs.getString("start_Date"));
                data.put("endDate", _rs.getString("end_Date"));
                data.put("refNo", _rs.getString("reference_No"));
                data.put("refDate", _rs.getString("reference_Date"));
                data.put("authBy", _rs.getString("authorizedby_emp_Id"));
                data.put("fullName", _rs.getString("first_Name") + " " +
                        "" + _rs.getString("middle_Name") + " " +
                        "" + _rs.getString("last_Name"));
                eva.add(data);
            }
            return eva;
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

    /**
     * The method fetches evaluation session information from the hr_evaluation_session
     * table based on the evaluation session id
     * @param evaSession the unique identifier
     * @return a <code>ResultSet</code> object with information of the evaluation session
     */
    public ResultSet readEvaSession(String evaSession) {


        String readEva = "SELECT ALL hr_evaluation_session.`evaluation_Session_Id`,  " +
                "hr_evaluation_session.`start_Date`,   " +
                "hr_evaluation_session.`end_Date`,   " +
                "hr_evaluation_session.`reference_No`,   " +
                "hr_evaluation_session.`reference_Date`,   " +
                "hr_evaluation_session.`authorizedby_emp_Id`,   " +
                "hr_employee_info.`first_Name`,   " +
                "hr_employee_info.`middle_Name`,   " +
                "hr_employee_info.`last_Name`   " +
                "FROM hr_evaluation_session  " +
                "INNER JOIN hr_employee_info ON hr_evaluation_session.`authorizedby_emp_Id` = hr_employee_info.`emp_Id`  " +
                "WHERE hr_evaluation_session.`evaluation_Session_Id` = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _ps.setString(1, evaSession);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;

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

    /**
     * The method is used to insert an evaluation session into the hr_evaluation_session
     * table.
     * (Note: the classes setter methods or a constructor must be called before calling this method)
     * @param eva an object of the Evaluation class
     * @return either (1) the row count for the result of insert statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int addEvaSessionEntity(String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose, String new_start_date, String new_end_date) {
        this.setStartDate(evaStartDate);
        this.setEndDate(evaEndDate);
        this.setReferenceNo(refNo);
        this.setReferenceDate(refDate);
        this.setAuthorizedEmpID(authorizedEmpID);
        this.setPurpose(purpose);
        this.setNew_start_date(new_start_date);
        this.setNew_end_date(new_end_date);
        return this.insertEvaSession();

    }

    public int insertEvaSession() {



        String strInsertEva = "INSERT INTO HR_EVALUATION_SESSION (start_Date, end_Date, reference_No, reference_Date, authorized_emp_Id, purpose,new_start_date,new_end_date) VALUES (?, ?, ?, ?, ?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strInsertEva);
            _ps.setString(1, this.getStartDate());
            _ps.setString(2, this.getEndDate());
            _ps.setString(3, this.getReferenceNo());
            _ps.setString(4, this.getReferenceDate());
            _ps.setString(5, this.getAuthorizedEmpID());
            _ps.setString(6, this.getPurpose());
            _ps.setString(7, this.getNew_start_date());
            _ps.setString(8, this.getNew_end_date());
            return _ps.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * The method makes changes in the hr_evaluation_session table based on the
     * the value of the getter methods.
     * (Note: the classes setter methods or a constructor must be called before calling this method)
     * @param eva an object of the Evaluation class, entity
     * @return either (1) the row count for the result of insert statement in the method
     *         or (2) 0 for SQL statements that return nothing
     */
    public int UpdateEvaSession(int evaSessionId, String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose,
            String new_start_date, String new_end_date) {




        String strUpdateEva = ("UPDATE hr_evaluation_session set start_Date=?, end_Date=?, reference_No = ?, " +
                " reference_Date = ?, authorized_emp_Id = ?, purpose = ?,new_start_date=?, new_end_date=? WHERE evaluation_Session_Id = '" + evaSessionId + "'");

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(strUpdateEva);
            _ps.setString(1, evaStartDate);
            _ps.setString(2, evaEndDate);
            _ps.setString(3, refNo);
            _ps.setString(4, refDate);
            _ps.setString(5, authorizedEmpID);
            _ps.setString(6, purpose);
            _ps.setString(7, new_start_date);
            _ps.setString(8, new_end_date);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countEvaSession(String sessionID) {



        HashMap[] list = null;
        String str = "SELECT Max(rownum) as num FROM hr_evaluation_session WHERE HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + sessionID + "' ";
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
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public HashMap[] readEvaSessionRenderd(String sessionID) {



        HashMap[] list = null;
        int i = 0;

        String str = "SELECT * FROM hr_evaluation_session WHERE HR_EVALUATION_SESSION.EVALUATION_SESSION_ID = '" + sessionID + "'";
        try {
            list = new HashMap[this.countEvaSession(sessionID)];
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _rs = _ps.executeQuery();
            while (_rs.next()) {
                list[i] = new HashMap();
                list[i].put("EVALUATION_SESSION_ID", _rs.getInt("EVALUATION_SESSION_ID"));
                list[i].put("START_DATE", _rs.getString("START_DATE"));
                list[i].put("END_DATE", _rs.getString("END_DATE"));
                list[i].put("REFERENCE_NO", _rs.getString("REFERENCE_NO"));
                list[i].put("REFERENCE_DATE", _rs.getString("REFERENCE_DATE"));
                list[i].put("PURPOSE", _rs.getString("PURPOSE"));
                list[i].put("AUTHORIZED_EMP_ID", _rs.getString("AUTHORIZED_EMP_ID"));
                list[i].put("new_start_date", _rs.getString("new_start_date"));
                list[i].put("new_end_date", _rs.getString("new_end_date"));
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
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int deleteEvaSession(int evaSessionID) {




        String delEvaCrt = "DELETE FROM hr_evaluation_session WHERE evaluation_Session_Id = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(delEvaCrt);
            _ps.setInt(1, evaSessionID);

            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public ArrayList<EvaluationSession> readSessionAuthorizerHistory(String empID) {




        String _select = "SELECT  HR_EVALUATION_SESSION.EVALUATION_SESSION_ID ,  " +
                " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID ,   " +
                " HR_EVALUATION_SESSION.PURPOSE    " +
                " FROM HR_EVALUATION_SESSION WHERE  " +
                "HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + empID + "' ";

        ArrayList<EvaluationSession> authorizerHist = new ArrayList<EvaluationSession>();

        try {

            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();

            while (_rs.next()) {
                EvaluationSession terEntity = new EvaluationSession(_rs.getString("EVALUATION_SESSION_ID"), _rs.getString("purpose") + "---" + _rs.getString("EVALUATION_SESSION_ID"));
                authorizerHist.add(terEntity);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return authorizerHist;
    }

    public ArrayList<EvaluationSession> readAllSessionPurpose() {

        String readEva = "SELECT  * FROM  HR_EVA_PURPOSE ";
        ArrayList<EvaluationSession> resultList = new ArrayList<EvaluationSession>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationSession resultType = new EvaluationSession(Integer.valueOf(_rs.getString("PURPOSE_ID").toString()), _rs.getString("PURPOSE_NAME"));
                resultList.add(resultType);
            }
            return resultList;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public String readSinglePurpose(int purpID) {




        String readEva = "SELECT  * FROM  HR_EVA_PURPOSE WHERE HR_EVA_PURPOSE.PURPOSE_ID = '" + purpID + "' ";


        String resultList = "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(readEva);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                resultList = _rs.getString("PURPOSE_NAME").toString();
            }
            return resultList;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }


    }

    public ArrayList<EvaluationSession> readManagedSession(String authorizerID, String purposeID, String empID) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String readEvaGeneral = " SELECT DISTINCT  HR_EVALUATION_SESSION.EVALUATION_SESSION_ID, HR_EVALUATION_SESSION.START_DATE, " +
                " HR_EVALUATION_SESSION.END_DATE " +
                " FROM  " +
                " HR_EVA_PURPOSE, HR_EVALUATION_SESSION" +
                " WHERE" +
                " HR_EVA_PURPOSE.PURPOSE_ID = '" + purposeID + "' " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + authorizerID + "'";

        String readEvaSingle = " SELECT DISTINCT  HR_EVALUATION_SESSION.EVALUATION_SESSION_ID, HR_EVALUATION_SESSION.START_DATE, " +
                " HR_EVALUATION_SESSION.END_DATE " +
                " FROM  " +
                " HR_EVA_PURPOSE, HR_EVALUATION_SESSION, HR_EVALUATION_RESULT" +
                " WHERE" +
                " HR_EVA_PURPOSE.PURPOSE_ID = '" + purposeID + "' " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = '" + authorizerID + "'" +
                " AND " +
                " HR_EVALUATION_RESULT.EMP_ID = '" + empID + "' " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = HR_EVALUATION_SESSION.EVALUATION_SESSION_ID ";



        ArrayList<EvaluationSession> resultList = new ArrayList<EvaluationSession>();
        try {
            _con = getConnection();
            if (empID != null) {
                _ps = _con.prepareStatement(readEvaSingle);
            } else {
                _ps = _con.prepareStatement(readEvaGeneral);
            }

            _rs = _ps.executeQuery();

            while (_rs.next()) {
                EvaluationSession resultType = new EvaluationSession(_rs.getString("EVALUATION_SESSION_ID").toString(),
                        _rs.getString("START_DATE").toString(), _rs.getString("END_DATE").toString(), 1);
                resultList.add(resultType);
            }
            return resultList;

        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public OracleCachedRowSet readSessionAutorizer(String purposeID, String empID) {

        String readEvaSingle = " SELECT DISTINCT HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID," +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME " +
                " FROM  " +
                " HR_EVALUATION_SESSION, HR_EMPLOYEE_INFO, HR_EVA_PURPOSE, HR_EVALUATION_RESULT " +
                " WHERE " +
                " HR_EVA_PURPOSE.PURPOSE_ID = '" + purposeID + "' " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = HR_EMPLOYEE_INFO.EMP_ID " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = HR_EVALUATION_SESSION.EVALUATION_SESSION_ID " +
                " AND " +
                " HR_EVALUATION_RESULT.EMP_ID = '" + empID + "'";

        String readEvaGeneral = " SELECT DISTINCT HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID," +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME " +
                " FROM  " +
                " HR_EVALUATION_SESSION, HR_EMPLOYEE_INFO, HR_EVA_PURPOSE " +
                " WHERE " +
                " HR_EVA_PURPOSE.PURPOSE_ID = '" + purposeID + "' " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVALUATION_SESSION.AUTHORIZED_EMP_ID = HR_EMPLOYEE_INFO.EMP_ID";


        try {
            _con = getConnection();
            if (empID != null) {
                _ps = _con.prepareStatement(readEvaSingle);
            } else {
                _ps = _con.prepareStatement(readEvaGeneral);
            }

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);

            return ocrs;

        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public OracleCachedRowSet readEvaluatorInfo(String sessionID, String purposeID, String empID) {
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;

        String readEvaSingle = " SELECT  DISTINCT" +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, HR_EVALUATION_RESULT.EVALUATOR_ID," +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME" +
                " FROM  " +
                " HR_EVALUATION_RESULT, HR_EMPLOYEE_INFO, HR_EVA_PURPOSE, HR_EVALUATION_SESSION " +
                " WHERE" +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATOR_ID = HR_EMPLOYEE_INFO.EMP_ID " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_ID =  '" + purposeID + "'" +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE " +
                " AND " +
                " HR_EVALUATION_RESULT.EMP_ID = '" + empID + "'";

        String readEvaGeneral = " SELECT  DISTINCT" +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID, HR_EVALUATION_RESULT.EVALUATOR_ID," +
                " HR_EMPLOYEE_INFO.FIRST_NAME, HR_EMPLOYEE_INFO.MIDDLE_NAME, HR_EMPLOYEE_INFO.LAST_NAME" +
                " FROM  " +
                " HR_EVALUATION_RESULT, HR_EMPLOYEE_INFO, HR_EVA_PURPOSE, HR_EVALUATION_SESSION " +
                " WHERE" +
                " HR_EVALUATION_RESULT.EVALUATION_SESSION_ID = '" + sessionID + "' " +
                " AND " +
                " HR_EVALUATION_RESULT.EVALUATOR_ID = HR_EMPLOYEE_INFO.EMP_ID " +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_ID =  '" + purposeID + "'" +
                " AND " +
                " HR_EVA_PURPOSE.PURPOSE_NAME = HR_EVALUATION_SESSION.PURPOSE ";



        try {
            _con = getConnection();
            if (empID != null) {
                _ps = _con.prepareStatement(readEvaSingle);
            } else {
                _ps = _con.prepareStatement(readEvaGeneral);
            }

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);

            return ocrs;

        } catch (SQLException ex) {
            ex.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }
}
