/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class EmployeeTraining_Entity extends ConnectionManager {

    private String trainingName;
    private String institution;
    private String sponsoredBy;
    private String period;
    private String employeeId;
    private String trainingId;
    private String startDate;
    private String endDate;
    private String duration;

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getSponsoredBy() {
        return sponsoredBy;
    }

    public void setSponsoredBy(String sponsoredBy) {
        this.sponsoredBy = sponsoredBy;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * defulete constractore
     */
    public EmployeeTraining_Entity() {
    }

    /**
     *
     * @param trainingName
     * @param institution
     * @param startDate
     * @param endDate
     * @param employeeId
     * @param trainingId
     * @param sponsoredBy
     */
    public EmployeeTraining_Entity(String trainingName,
            String institution,
            String startDate,
            String endDate,
            String employeeId,
            String trainingId,
            String sponsoredBy,
            String duration) {
        this.trainingName = trainingName;
        this.institution = institution;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
        this.trainingId = trainingId;
        this.sponsoredBy = sponsoredBy;
        this.duration = duration;
    }

    /**
     *
     * @param employeeTrainingEntity
     * @return
     */
    public int saveEmployeeTraining(EmployeeTraining_Entity employeeTrainingEntity) {
        int check;

        String _insert = "INSERT INTO HR_EMP_TRAINING " +
                "  ( EMP_ID," +
                "    INSTITUTION, " +
                "    TRAININGORCOURSE_NAME," +
                "    START_DATE, " +
                "    END_DATE ," +
                "    PAYMENT_PAYE_BY," +
                "    DURATION" +
                "  ) " +
                " VALUES(?,?,?,?,?,?,?)";
        PreparedStatement _ps = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, employeeTrainingEntity.getEmployeeId());
            _ps.setString(2, employeeTrainingEntity.getInstitution());
            _ps.setString(3, employeeTrainingEntity.getTrainingName());
            _ps.setString(4, employeeTrainingEntity.getStartDate());
            _ps.setString(5, employeeTrainingEntity.getEndDate());
            _ps.setString(6, employeeTrainingEntity.getSponsoredBy());
            _ps.setString(7, employeeTrainingEntity.getDuration());

            check = _ps.executeUpdate();
            _ps.close();
            closePooledConnections(_con);
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return 0;

    }

    /**
     *
     * @param employeeTrainingEntity
     * @return
     */
    public int updateEmployeeTraining(EmployeeTraining_Entity employeeTrainingEntity) {
        String _update = "UPDATE HR_EMP_TRAINING " +
                "  SET " +
                "    INSTITUTION=?, " +
                "    TRAININGORCOURSE_NAME=?," +
                "    START_DATE=?, " +
                "    END_DATE =?," +
                "    PAYMENT_PAYE_BY=?," +
                "    DURATION=?   " +
                " WHERE ID=?  ";
        int check;
        PreparedStatement _ps = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, employeeTrainingEntity.getInstitution());
            _ps.setString(2, employeeTrainingEntity.getTrainingName());
            _ps.setString(3, employeeTrainingEntity.getStartDate());
            _ps.setString(4, employeeTrainingEntity.getEndDate());
            _ps.setString(5, employeeTrainingEntity.getSponsoredBy());
            _ps.setString(6, employeeTrainingEntity.getDuration());
            _ps.setString(7, employeeTrainingEntity.getTrainingId());
            check = _ps.executeUpdate();
            _ps.close();
            closePooledConnections(_con);
            return check;
        } catch (Exception ex) {
            // ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return 0;
    }

    /**
     *
     * @param employeeID
     * @return
     */
    public ArrayList<HashMap> readEmployeeTraining(String employeeID) {
        String select = "SELECT   NVL(HR_EMP_TRAINING.TRAININGORCOURSE_NAME,'Not Register') AS TRAININGORCOURSE_NAME, " +
                "  NVL(HR_EMP_TRAINING.START_DATE,'Not Register') AS START_DATE, " +
                "  NVL(HR_EMP_TRAINING.END_DATE,'Not Register')   AS END_DATE, " +
                "  HR_EMP_TRAINING.EMP_ID, " +
                "  HR_EMP_TRAINING.ID, " +
                "  NVL(HR_EMP_TRAINING.PAYMENT_PAYE_BY,'Not Register') AS PAYMENT_PAYE_BY, " +
                "  HR_EMP_TRAINING.INSTITUTION, " +
                "  NVL(HR_LU_EDUC_INSTITUTION.INSTITUTION_NAME,'Not Register') AS INSTITUTION_NAME, " +
                "  nvl(DURATION,'not register') as DURATION   " +
                "FROM HR_EMP_TRAINING " +
                "LEFT JOIN HR_LU_EDUC_INSTITUTION " +
                "ON HR_LU_EDUC_INSTITUTION.INSTITUTION_ID = HR_EMP_TRAINING.INSTITUTION " +
                "WHERE EMP_ID                          =?" ;
        ArrayList<HashMap> employeeTraining = new ArrayList<HashMap>();
        ResultSet rsEducation;

        Connection _conn;
        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ps.setString(1, employeeID);
            rsEducation = ps.executeQuery();
            ocrs.populate(rsEducation);
            rsEducation.close();
            ps.close();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("INSTITUTION", ocrs.getString("INSTITUTION"));
                hm.put("INSTITUTIONNAME", ocrs.getString("INSTITUTION_NAME"));
                hm.put("TRAININGNAME", ocrs.getString("TRAININGORCOURSE_NAME"));
                hm.put("SPONSORED_BY", ocrs.getString("PAYMENT_PAYE_BY"));
                hm.put("EMPLOYEEID", ocrs.getString("EMP_ID"));
                hm.put("EMP_TRA_ID", ocrs.getString("ID"));
                hm.put("START_DATE", ocrs.getString("START_DATE"));
                hm.put("END_DATE", ocrs.getString("END_DATE"));
                hm.put("DURATION", ocrs.getString("DURATION"));



                employeeTraining.add(hm);
            }
            closePooledConnections(_conn);
            return employeeTraining;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * The method removes a row of data from the HR_EMP_TRAINING table using
     * the TRAININGID
     * @param refernceId
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *         or (2) 0 for SQL statements that return nothing
     */
    public int deleteEmployeeTraining(String empTraId) {
        String _deletet = "DELETE FROM HR_EMP_TRAINING WHERE ID=?";
        Connection _con = null;
        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, empTraId);
            check = ps.executeUpdate();
            ps.close();
            closePooledConnections(_con);
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }

        return 0;
    }
}

