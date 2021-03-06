/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.organizationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.organizationManager.OrganizationReportManager;

/**
 *
 * @author 
 */
public class OrganizationReportEntity extends ConnectionManager {

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
    String stm, stm1;

    public int readNumberOfEmployees(String departmentId, String jobId) {
        int myReturn = 0;

        stm = "select count(EMP_ID) as number_of_employees from hr_employee_info  where JOB_CODE='" + jobId + "' and DEPARTMENT_ID='" + departmentId + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    myReturn = _rs.getInt("number_of_employees");
                }
            }

        } catch (SQLException ex) {
            myReturn = 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }

        return myReturn;
    }

    public ArrayList<OrganizationReportManager> readaAlocatedJobForDep() {
        ArrayList<OrganizationReportManager> myReturn = new ArrayList<OrganizationReportManager>();

        stm = "Select * from VW_ORGANIZATION_REPORT";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {

                    OrganizationReportManager initiateManager = new OrganizationReportManager();
                    initiateManager.setDepartmentId(_rs.getString("DEPT_ID"));
                    initiateManager.setJobId(_rs.getString("job_code"));
                    initiateManager.setJobName(_rs.getString("JOB_NAME"));
                    initiateManager.setRequiredNumber(_rs.getInt("NUMBER_OF_EMPLOYEE"));
                    initiateManager.setNumberOfEmp(_rs.getInt("EMP_ID"));
                    initiateManager.setVacantPossession(_rs.getInt("vacantPostion"));
                    initiateManager.setRank(_rs.getString("rank_description"));
                    initiateManager.setEducLevel(_rs.getString("SUBJECTS_LIST"));
                    initiateManager.setExpiriance(_rs.getString("MIN_EXPERIENCE_LIST"));
                    initiateManager.setEducType(_rs.getString("QUALIFICATION_LIST"));
                    initiateManager.setAddtionalSkill(_rs.getString("additionalskill"));
                    initiateManager.setMinSalary(_rs.getDouble("BEGINNING_SALARY"));
                    initiateManager.setMaxSalary(_rs.getDouble("MAX_SALARY"));
                    initiateManager.setSeraAsfetsami(_rs.getString("serasefetsami"));
                    initiateManager.setDept(_rs.getString("departement"));
                    initiateManager.setTeam(_rs.getString("team"));
                    myReturn.add(initiateManager);

                }
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            myReturn = null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }


        return myReturn;
    }

    public ArrayList<OrganizationReportManager> readDepartementPath(String jobCode) {
        ArrayList<OrganizationReportManager> myReturn = new ArrayList<OrganizationReportManager>();
        stm = "SELECT DISTINCT job_code, " +
                "  RTRIM(REPLACE(REPLACE(XMLAgg(XMLElement(\"x\", education_level) " +
                "ORDER BY education_level), '<x>'), '</x>', '/')) AS education_levels, " +
                "  RTRIM(REPLACE(REPLACE(XMLAgg(XMLElement(\"x\", MIN_EXPERIENCE) " +
                "ORDER BY MIN_EXPERIENCE), '<x>'), '</x>', '/')) AS MIN_EXPERIENCEs " +
                "FROM hr_lu_job_type_educ_level " +
                "WHERE job_code='" + jobCode + "'" +
                "GROUP BY job_code";



        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {

                    //myReturn = _rs.getString("number_of_employees");
                    OrganizationReportManager initiateManager = new OrganizationReportManager();
                    initiateManager.setEducLevel(_rs.getString("education_levels"));
                    initiateManager.setExpiriance(_rs.getString("MIN_EXPERIENCEs"));
//                    initiateManager.setEducType(_rs.getString("qualification"));
//                    initiateManager.setAddtionalSkill(_rs.getString("additionalskill"));
                    myReturn.add(initiateManager);
                }
            }

        } catch (SQLException ex) {
            myReturn = null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }


        return myReturn;
    }

    public String readEducationExpri(String jobCode) {
        String myReturn = null;
        stm = "SELECT DISTINCT lev.education_level, " +
                "  lev.min_experience, " +
                "  lev.educ_level_id, " +
                "  qual.qualification, " +
                "  qual.job_code, " +
                "  lev.job_code, " +
                "  jobty.additionalskill " +
                "FROM hr_lu_job_type_educ_level lev " +
                "INNER JOIN hr_lu_job_type_qualification qual " +
                "ON QUAL.JOB_CODE =lev.job_code " +
                "INNER JOIN hr_lu_job_type jobty " +
                "ON jobty.job_code =lev.job_code " +
                "WHERE lev.job_code='" + jobCode + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {

                    myReturn = _rs.getString("number_of_employees");
//                    OrganizationReportManager initiateManager = new OrganizationReportManager();
//                    initiateManager.setEducLevel(_rs.getString("education_level"));
//                    initiateManager.setExpiriance(_rs.getInt("min_experience"));
//                    initiateManager.setEducType(_rs.getString("qualification"));
//                    initiateManager.setAddtionalSkill(_rs.getString("additionalskill"));
//                    myReturn.add(initiateManager);
                }
            }

        } catch (SQLException ex) {
            myReturn = null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }


        return myReturn;
    }
}
