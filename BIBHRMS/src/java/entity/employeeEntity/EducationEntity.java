/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class EducationEntity extends ConnectionManager {

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

    public EducationEntity() {
    }
    String startDate;

    public String getAward() {
        return award;
    }

  

    public void setAward(String award) {
        this.award = award;
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

    public int getGradingScale() {
        return gradingScale;
    }

    public void setGradingScale(int gradingScale) {
        this.gradingScale = gradingScale;
    }

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getInstuation() {
        return instuation;
    }

    public void setInstuation(String instuation) {
        this.instuation = instuation;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTypesOfEducation() {
        return typesOfEducation;
    }

    public void setTypesOfEducation(String typesOfEducation) {
        this.typesOfEducation = typesOfEducation;
    }
    String copletionDate;
    String award;
    String result;
    String levelOfEducation;
    String typesOfEducation;
    String instuation;
    String employeeId;
    String id;
    String educationTypeDescrption;
    int gradingScale;

    public String getEducationTypeDescrption() {
        return educationTypeDescrption;
    }

    public void setEducationTypeDescrption(String educationTypeDescrption) {
        this.educationTypeDescrption = educationTypeDescrption;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public EducationEntity(String instuation, String startDate, String copletionDate, String award, String result, String levelOfEducation, String typesOfEducation, String employeeId, String id) {
        this.instuation = instuation;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.award = award;
        this.result = result;
        this.levelOfEducation = levelOfEducation;
        this.typesOfEducation = typesOfEducation;
        this.employeeId = employeeId;
        this.id = id;
    }

    public EducationEntity(String instuation, String startDate, String copletionDate, String award, String result, String levelOfEducation, String typesOfEducation, String employeeId, String id, int gradingScale) {
        this(instuation, startDate, copletionDate, award, result, levelOfEducation, typesOfEducation, employeeId, id);
        this.gradingScale = gradingScale;
    }

    public ResultSet selectEmployeeEducation(String empID) throws SQLException {
        String select = "SELECT HR_EMP_EDUCATION.EMP_ID , " +
                "  HR_EMP_EDUCATION.INSTITUTION, " +
                "  HR_EMP_EDUCATION.EDUC_LEVEL_CODE , " +
                "  HR_EMP_EDUCATION.EDUCATION_TYPE , " +
                "  HR_EMP_EDUCATION.STARTING_DATE , " +
                "  HR_EMP_EDUCATION.COMPLETION_DATE , " +
                "  HR_EMP_EDUCATION.AWARD , " +
                "  HR_EMP_EDUCATION.RESULT , " +
                "  HR_EMP_EDUCATION.PAYMENT_PAYE_BY , " +
                "  HR_EMP_EDUCATION.ID , " +
                "  HR_EMP_EDUCATION.GRADING_SYSTEM, " +
                "  hr_lu_educ_level.DESCRIPTION AS educ_level, " +
                "  HR_LU_EDUC_TYPE.DESCRIPTION  AS EDUC_TYPE " +
                " FROM HR_LU_EDUC_TYPE " +
                " INNER JOIN (hr_lu_educ_level " +
                " INNER JOIN HR_EMP_EDUCATION " +
                " ON hr_lu_educ_level.EDUC_LEVEL_CODE=HR_EMP_EDUCATION.EDUC_LEVEL_CODE) " +
                " ON HR_LU_EDUC_TYPE.EDUC_TYPE_CODE  =HR_EMP_EDUCATION.EDUCATION_TYPE   WHERE emp_Id=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public HashMap[] readEducation(String empID) {
        int i = 0;
        HashMap[] _list = null;
        String select = "SELECT HR_EMP_EDUCATION.EMP_ID , " +
                "  HR_EMP_EDUCATION.INSTITUTION, " +
                "  HR_EMP_EDUCATION.EDUC_LEVEL_CODE , " +
                "  HR_EMP_EDUCATION.EDUCATION_TYPE , " +
                "  HR_EMP_EDUCATION.STARTING_DATE , " +
                "  HR_EMP_EDUCATION.COMPLETION_DATE , " +
                "  HR_EMP_EDUCATION.AWARD , " +
                "  HR_EMP_EDUCATION.RESULT , " +
                "  HR_EMP_EDUCATION.PAYMENT_PAYE_BY , " +
                "  HR_EMP_EDUCATION.ID , " +
                "  HR_EMP_EDUCATION.GRADING_SYSTEM, " +
                "  hr_lu_educ_level.DESCRIPTION AS educ_level, " +
                "  HR_LU_EDUC_TYPE.DESCRIPTION  AS EDUC_TYPE " +
                " FROM HR_LU_EDUC_TYPE " +
                " INNER JOIN (hr_lu_educ_level " +
                " INNER JOIN HR_EMP_EDUCATION " +
                " ON hr_lu_educ_level.EDUC_LEVEL_CODE=HR_EMP_EDUCATION.EDUC_LEVEL_CODE) " +
                " ON HR_LU_EDUC_TYPE.EDUC_TYPE_CODE  =HR_EMP_EDUCATION.EDUCATION_TYPE   WHERE emp_Id=?";

        try {
            String satrt_Date = "start";
            String end_Date = "End";
            String instituation = "Instituation";
            String award = "Award";
            String result = "result";

            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _list = new HashMap[ocrs.size()];
//            this.setSize(empID);
            while (ocrs.next()) {

                _list[i] = new HashMap();
                if (ocrs.getString("INSTITUTION") != null) {
                    _list[i].put("INSTITUTION", ocrs.getString("INSTITUTION"));
                } else {
                    _list[i].put("INSTITUTION", "Unknown");
                }

                if (ocrs.getString("STARTING_DATE") != null) {
                    _list[i].put("STARTING_DATE", ocrs.getString("STARTING_DATE"));
                } else {
                    _list[i].put("STARTING_DATE", "Unknown");
                }

                if (ocrs.getString("COMPLETION_DATE") != null) {
                    _list[i].put("COMPLETION_DATE", ocrs.getString("COMPLETION_DATE"));
                } else {
                    _list[i].put("COMPLETION_DATE", "Unknown");
                }

                if (ocrs.getString("AWARD") != null) {
                    _list[i].put("AWARD", ocrs.getString("AWARD"));
                } else {
                    _list[i].put("AWARD", "Unknown");
                }

                if (ocrs.getString("RESULT") != null) {
                    _list[i].put("RESULT", ocrs.getString("RESULT"));
                } else {
                    _list[i].put("RESULT", "Unknown");
                }
                if (ocrs.getString("EDUC_LEVEL_CODE") != null) {
                    _list[i].put("EDUC_LEVEL_CODE", ocrs.getString("EDUC_LEVEL_CODE"));
                } else {
                    _list[i].put("EDUC_LEVEL_CODE", "Unknown");
                }


                if (ocrs.getString("EDUCATION_TYPE") != null) {
                    _list[i].put("EDUCATION_TYPE", ocrs.getString("EDUCATION_TYPE"));
                } else {
                    _list[i].put("EDUCATION_TYPE", "Unknown");
                }

                if (ocrs.getString("EDUC_TYPE") != null) {
                    _list[i].put("EDUC_TYPE", ocrs.getString("EDUC_TYPE"));
                } else {
                    _list[i].put("EDUC_TYPE", "Unknown");
                }

                if (ocrs.getString("EMP_ID") != null) {
                    _list[i].put("EMP_ID", ocrs.getString("EMP_ID"));
                } else {
                    _list[i].put("EMP_ID", "Unknown");
                }

                if (ocrs.getString("ID") != null) {
                    _list[i].put("ID", ocrs.getString("ID"));
                } else {
                    _list[i].put("ID", "Unknown");
                }
                if (ocrs.getString("educ_level") != null) {
                    _list[i].put("educ_level", ocrs.getString("educ_level"));
                } else {
                    _list[i].put("educ_level", "Unknown");
                }

                _list[i].put("DATABASE_STATUS", "Old");
                i++;
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

    public int saveEmployeeEducation(EducationEntity employeeEntity) {
        int check;
        String _select = "INSERT INTO hr_emp_education " +
                "(emp_Id,INSTITUTION,EDUC_LEVEL_CODE,EDUCATION_TYPE,STARTING_DATE,COMPLETION_DATE,AWARD,RESULT,GRADING_SYSTEM)" +
                " VALUES ('" + employeeEntity.getEmployeeId() + "','" + employeeEntity.getInstuation() + "','" + employeeEntity.getLevelOfEducation() + "','" +
                employeeEntity.getTypesOfEducation() + "','" + employeeEntity.getStartDate() + "','" +
                "" + employeeEntity.getCopletionDate() + "','" + employeeEntity.getAward() + "','" + employeeEntity.getResult() + "'," + employeeEntity.getGradingScale() + ")";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
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

    public int updateEmployeeEducation(EducationEntity employeeEntity) {
        String update = "UPDATE HR_EMP_EDUCATION " +
                "SET INSTITUTION   = ?, " +
                "  EDUC_LEVEL_CODE = ?, " +
                "  EDUCATION_TYPE  = ?, " +
                "  STARTING_DATE   = ?, " +
                "  COMPLETION_DATE = ?, " +
                "  AWARD           = ?, " +
                "  RESULT          = ? " +             
                "WHERE ID          = ?";
        int check;
        try { 
            _con = getConnection();
            _ps = _con.prepareStatement(update);
            _ps.setString(1, employeeEntity.getInstuation());
            _ps.setString(2, employeeEntity.getLevelOfEducation());
            _ps.setString(3, employeeEntity.getTypesOfEducation());
            _ps.setString(4, employeeEntity.getStartDate());
            _ps.setString(5, employeeEntity.getCopletionDate());
            _ps.setString(6, employeeEntity.getAward());
            _ps.setString(7, employeeEntity.getResult());
            _ps.setInt(8, Integer.parseInt(employeeEntity.getId()));
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ex.printStackTrace();
           // ErrorLogWriter.writeError(ex);
            return 0;
        }


    }


      public ResultSet selectAllLocationLu() throws SQLException
      {

         String _selectQuery = " SELECT * FROM HR_LU_EMP_ADDRESS" ;

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
          //  _ps.setString(1, CommitteeType);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
      }


    public int countEmployeeEducation(String empID) {
        String count = "SELECT Max(rownum)as num  from hr_emp_education WHERE emp_Id=?";
        ResultSet rsFamily;
        int rownum;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(count);
            _ps.setString(1, empID);
            rsFamily = _ps.executeQuery();
            rsFamily.next();
            rownum = rsFamily.getInt("num");

            return rownum;
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

        return 0;
    }

    public int deleteEmployeeEducation(String id) {
        String _deletet = "DELETE FROM hr_emp_education WHERE ID=?";
        int check;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deletet);
            _ps.setString(1, id);
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

    public String readEducationDescription(String educationID) {
        String select = "select * FROM hr_lu_educ_level where EDUC_LEVEL_CODE=?";
        String description;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, educationID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                description = _rs.getString("DESCRIPTION");
                return description;
            } else {
                return null;
            }
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

    public String readTypeDescription(String educationID) {
        String select = "select DESCRIPTION FROM HR_LU_EDUC_TYPE where EDUC_TYPE_CODE=?";
        String description = "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setString(1, educationID);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                description = _rs.getString("DESCRIPTION");
                return description;
            } else {
                return null;
            }
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

    public int countTypeOfEducation() {
        HashMap[] list = null;
        int rownum;
        String str = "SELECT Max(rownum) as num FROM hr_lu_educ_type ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                rownum = _rs.getInt("num");
                return rownum;
            }
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int addNewTitle(String educationTypeDesc) {
        this.setEducationTypeDescrption(educationTypeDesc);
        return this.insertNewTitle();
    }

    public int insertNewEducationType(String educationType, String category) {
        int check;
        String insEvaCrt = "INSERT INTO hr_lu_educ_type (EDUC_TYPE_CODE,DESCRIPTION,CATEGORY)  " +
                " VALUES (HR_LU_EDUC_TYPE_SEQ.NEXTVAL,?,?) ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, educationType);
            _ps.setString(2, category);
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
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

    private int insertNewTitle() {
        int check;
        String insEvaCrt = "INSERT INTO hr_lu_educ_type (EDUC_TYPE_CODE,DESCRIPTION,CATEGORY)  VALUES (HR_LU_EDUC_TYPE_SEQ.NEXTVAL,?,'Uncatagorized') ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(insEvaCrt);
            _ps.setString(1, this.getEducationTypeDescrption());
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
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

    public int deleteEducationType(String educationCode) {
        String _deletet = "DELETE FROM hr_lu_educ_type WHERE educ_type_code=?";
        int check;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deletet);
            _ps.setString(1, educationCode);
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
}
