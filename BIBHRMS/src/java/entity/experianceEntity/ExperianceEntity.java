/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.experianceEntity;

/**
 *
 * @author Administrator
 */
import connectionProvider.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.driver.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

public class ExperianceEntity extends ConnectionManager {

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;
    private String experienceValidForLeave;
    private String experienceRelationinInMugherJobCode;

    public String getExperienceRelationinInMugherJobCode() {
        return experienceRelationinInMugherJobCode;
    }

    public void setExperienceRelationinInMugherJobCode(String experienceRelationinInMugherJobCode) {
        this.experienceRelationinInMugherJobCode = experienceRelationinInMugherJobCode;
    }

    public String getExperienceValidForLeave() {
        return experienceValidForLeave;
    }

    public void setExperienceValidForLeave(String experienceValidForLeave) {
        this.experienceValidForLeave = experienceValidForLeave;
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

    public ExperianceEntity() {
    }
    String institution;
    int check;

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getEmploeeId() {
        return emploeeId;
    }

    public void setEmploeeId(String emploeeId) {
        this.emploeeId = emploeeId;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }
    String terminationReason;
    String rank;
    String startDate;
    String copletionDate;
    String salary;
    String emploeeId;
    String job_Code;
    String remark;
    String id;
    String experiencePrivateOrGovernmental;
    String experienceContractOrPrtmanent;

    public String getId() {
        return id;
    }

    public Connection get_con() {
        return _con;
    }

    public void set_con(Connection _con) {
        this._con = _con;
    }

    public PreparedStatement get_ps() {
        return _ps;
    }

    public void set_ps(PreparedStatement _ps) {
        this._ps = _ps;
    }

    public ResultSet get_rs() {
        return _rs;
    }

    public void set_rs(ResultSet _rs) {
        this._rs = _rs;
    }

    public int getCheck() {
        return check;
    }

    public void setCheck(int check) {
        this.check = check;
    }

    public String getExperienceContractOrPrtmanent() {
        return experienceContractOrPrtmanent;
    }

    public void setExperienceContractOrPrtmanent(String experienceContractOrPrtmanent) {
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
    }

    public String getExperiencePrivateOrGovernmental() {
        return experiencePrivateOrGovernmental;
    }

    public void setExperiencePrivateOrGovernmental(String experiencePrivateOrGovernmental) {
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ExperianceEntity(
            String institution,
            String terminationReason,
            String id,
            String startDate,
            String copletionDate,
            String salary,
            String emploeeId,
            String job_Code,
            String rank) {
        this.institution = institution;
        this.terminationReason = terminationReason;
        this.id = id;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.salary = salary;
        this.emploeeId = emploeeId;
        this.job_Code = job_Code;
        this.rank = rank;
    }

    public ExperianceEntity(
            String institution,
            String terminationReason,
            String id,
            String startDate,
            String copletionDate,
            String salary,
            String emploeeId,
            String job_Code,
            String rank,
            String experiencePrivateOrGovernmental,
            String experienceContractOrPrtmanent,
            String experienceRelationinInMugherJobCode,
            String experienceValidForLeave) {
        this.institution = institution;
        this.terminationReason = terminationReason;
        this.id = id;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.salary = salary;
        this.emploeeId = emploeeId;
        this.job_Code = job_Code;
        this.rank = rank;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.experienceValidForLeave = experienceValidForLeave;
        this.experienceRelationinInMugherJobCode = experienceRelationinInMugherJobCode;
    }

    public int saveEmployeeExperiance(ExperianceEntity experianceEntity) {
        int checkSave = 0;
        String _select = "INSERT " +
                "INTO hr_emp_experience " +
                "  ( " +
                "    emp_Id, " +
                "    INSTITUION, " +
                "    START_DATE, " +
                "    END_DATE, " +
                "    SALARY, " +
                "    JOB_TITLE, " +
                "    RANK, " +
                "    REASON_FOR_TERMINATION, " +
                "    PERMANENT_OR_CONTRACT, " +
                "    PRIVATE_OR_GVTAL, " +
                "    PROFESSIONINMUGHER, " +
                "    USETHISEXPERIENCEFORLEAVE " +
                "  )" +
                " VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, experianceEntity.getEmploeeId());
            _ps.setString(2, experianceEntity.getInstitution());
            _ps.setString(3, experianceEntity.getStartDate());
            _ps.setString(4, experianceEntity.getCopletionDate());
            _ps.setString(5, experianceEntity.getSalary());
            _ps.setString(6, experianceEntity.getJob_Code());
            _ps.setString(7, experianceEntity.getRank());
            _ps.setString(8, experianceEntity.getTerminationReason());
            _ps.setString(9, experianceEntity.getExperienceContractOrPrtmanent());
            _ps.setString(10, experianceEntity.getExperiencePrivateOrGovernmental());
            _ps.setString(11, experianceEntity.getExperienceRelationinInMugherJobCode());
            _ps.setString(12, experianceEntity.getExperienceValidForLeave());
            checkSave = _ps.executeUpdate();
            return checkSave;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return checkSave;
    }

    public int updateEmployeeExperiance(ExperianceEntity experianceEntity) {

        String _select = "UPDATE hr_emp_experience " +
                "SET INSTITUION              =?, " +
                "  START_DATE                =?, " +
                "  END_DATE                  =?, " +
                "  SALARY                    =?, " +
                "  JOB_TITLE                 =?, " +
                "  RANK                      =?, " +
                "  REASON_FOR_TERMINATION    =?, " +
                "  PERMANENT_OR_CONTRACT     =? , " +
                "  PRIVATE_OR_GVTAL          =?, " +
                "  USETHISEXPERIENCEFORLEAVE =?, " +
                "  PROFESSIONINMUGHER        =?  " +
                "WHERE ID                    =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);

            _ps.setString(1, experianceEntity.getInstitution());
            _ps.setString(2, experianceEntity.getStartDate());
            _ps.setString(3, experianceEntity.getCopletionDate());
            _ps.setInt(4, Integer.parseInt(experianceEntity.getSalary()));
            _ps.setString(5, experianceEntity.getJob_Code());
            _ps.setString(6, experianceEntity.getRank());
            _ps.setString(7, experianceEntity.getTerminationReason());
            _ps.setString(8, experianceEntity.getExperienceContractOrPrtmanent());
            _ps.setString(9, experianceEntity.getExperiencePrivateOrGovernmental());
            _ps.setString(10, experianceEntity.getExperienceValidForLeave());
            _ps.setString(11, experianceEntity.getExperienceRelationinInMugherJobCode());
            _ps.setInt(12, Integer.parseInt(experianceEntity.getId()));

            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public ArrayList<HashMap> readExperiance(String empID) {
        Connection _conn;
        ResultSet rsExper;
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        String select = "SELECT EX.EMP_ID, " +
                "  EX.INSTITUION, " +
                "  EX.START_DATE, " +
                "  EX.END_DATE, " +
                "  EX.JOB_TITLE, " +
                "  NVL(EX.RESPONSIBILITY,'not register') AS RESPONSIBILITY , " +
                "  EX.SALARY, " +
                "  NVL(EX.REASON_FOR_TERMINATION ,'not register') AS REASON_FOR_TERMINATION, " +
                "  EX.RANK, " +
                "  EX.ID, " +
                "  NVL(EX.PRIVATE_OR_GVTAL ,'not register')          AS PRIVATE_OR_GVTAL, " +
                "  NVL(EX.PERMANENT_OR_CONTRACT ,'not register')     AS PERMANENT_OR_CONTRACT, " +
                "  NVL(EX.USETHISEXPERIENCEFORLEAVE ,'not register') AS USETHISEXPERIENCEFORLEAVE, " +
                "  NVL(EX.PROFESSIONINMUGHER ,'not register')        AS PROFESSIONINMUGHER , " +
                "  NVL(JT.JOB_NAME ,'not register')           AS JOB_NAME " +
                "FROM HR_EMP_EXPERIENCE EX, " +
                "  HR_LU_JOB_TYPE JT " +
                "WHERE EX.EMP_ID          =? " +
                "AND EX.PROFESSIONINMUGHER=JT.JOB_CODE(+)";
        try {
            _conn = getConnection();
            _ps = _conn.prepareStatement(select);
            _ps.setString(1, empID);
            rsExper = _ps.executeQuery();
            while (rsExper.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", rsExper.getString("EMP_ID"));
                hm.put("RANK", rsExper.getString("RANK") == null ? "" : rsExper.getString("RANK"));
                hm.put("INSTITUION", rsExper.getString("INSTITUION") == null ? "" : rsExper.getString("INSTITUION"));
                hm.put("PRIVATE_OR_GVTAL", rsExper.getString("PRIVATE_OR_GVTAL"));
                hm.put("START_DATE", rsExper.getString("START_DATE") == null ? "" : rsExper.getString("START_DATE"));
                hm.put("END_DATE", rsExper.getString("END_DATE"));
                hm.put("JOB_TITLE", rsExper.getString("JOB_TITLE") == null ? "" : rsExper.getString("JOB_TITLE"));
                hm.put("PERMANENT_OR_CONTRACT", rsExper.getString("PERMANENT_OR_CONTRACT"));
                hm.put("SALARY", rsExper.getString("SALARY") == null ? "" : rsExper.getString("SALARY"));
                hm.put("REASON_FOR_TERMINATION", rsExper.getString("REASON_FOR_TERMINATION") == null ? "" : rsExper.getString("REASON_FOR_TERMINATION"));
                hm.put("ID", Integer.toString(rsExper.getInt("ID")));
                hm.put("USETHISEXPERIENCEFORLEAVE", rsExper.getString("USETHISEXPERIENCEFORLEAVE"));
                hm.put("PROFESSIONINMUGHER", rsExper.getString("PROFESSIONINMUGHER"));
                hm.put("JOB_NAME", rsExper.getString("JOB_NAME"));
                _list.add(hm);
            }

            return _list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int deleteEmployeeExperiance(String expId) {
        String _deletet = "DELETE FROM hr_emp_experience WHERE ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deletet);
            _ps.setInt(1, Integer.parseInt(expId));
            check = _ps.executeUpdate();
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

//    public int countEmployeeExperiance(String empID) {
//        String count = "SELECT Max(rownum)as num  from hr_emp_experience WHERE emp_Id=?";
//        Connection _conn;
//        ResultSet rsFamily;
//        int rownum;
//
//        try {
//            _conn = getConnection();
//            _ps = _conn.prepareStatement(count);
//            _ps.setString(1, empID);
//            rsFamily = _ps.executeQuery();
//            rsFamily.next();
//            rownum = rsFamily.getInt("num");
//            return rownum;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//        } finally {
//            try {
//                releaseResources();
//            } catch (SQLException ex) {
//                ex.printStackTrace();
//            }
//        }
//        return 0;
//    }
    public ResultSet searchEmployeeNametoAuto() {



        String qry = "SELECT FIRST_NAME,MIDDLE_NAME,LAST_NAME,EMP_ID from HR_EMPLOYEE_INFO";
        try {
            _con = getConnection();
            _ps = _con.prepareCall(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    public ArrayList<HashMap> readEmployeeExprianceForLeave(String emploeeID) {
        String sql = "SELECT START_DATE, " +
                "  END_DATE," +
                "  USETHISEXPERIENCEFORLEAVE, " +
                "  EMP_ID " +
                "FROM HR_EMP_EXPERIENCE " +
                "WHERE USETHISEXPERIENCEFORLEAVE='YES' " +
                "AND EMP_ID        =? ";
        ArrayList<HashMap> listOfExpriance = new ArrayList<HashMap>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, emploeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("startDate", rs.getString("START_DATE"));
                hm.put("endDate", rs.getString("END_DATE"));
                listOfExpriance.add(hm);
            }
            return listOfExpriance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> readEmployeeExpriance(String emploeeID) {
        String sql = "SELECT START_DATE, " +
                "  END_DATE," +
                "  EMP_ID " +
                "FROM HR_EMP_EXPERIENCE " +
                "WHERE  EMP_ID        =? ";
        ArrayList<HashMap> listOfExpriance = new ArrayList<HashMap>();
        try {
            PreparedStatement ps = null;
            ResultSet rs = null;
            Connection conn = getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, emploeeID);
            rs = ps.executeQuery();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("startDate", rs.getString("START_DATE").toString());
                hm.put("endDate", rs.getString("END_DATE").toString());
                listOfExpriance.add(hm);
            }
            return listOfExpriance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
