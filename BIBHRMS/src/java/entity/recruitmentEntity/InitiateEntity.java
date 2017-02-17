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
import manager.recruitmentManager.InitiateManager;

/**
 *
 * @author 
 */
public class InitiateEntity extends ConnectionManager {

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
        }
        finally{ try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }

        return myReturn;
    }

    public ArrayList<InitiateManager> readaAlocatedJobForDep() {
        ArrayList<InitiateManager> myReturn = new ArrayList<InitiateManager>();

        stm = "select  TBL_DEPT_BUNNA.DEPT_ID,TBL_DEPT_BUNNA.dep_description,hr_dept_job.JOB_CODE,hr_lu_job_type.JOB_NAME, hr_dept_job.NUMBER_OF_EMPLOYEE  from TBL_DEPT_BUNNA,hr_dept_job,hr_lu_job_type where TBL_DEPT_BUNNA.DEPT_ID=hr_dept_job.DEPT_ID and hr_lu_job_type.JOB_CODE=hr_dept_job.JOB_CODE";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(stm);
            _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    InitiateManager initiateManager = new InitiateManager();
                    initiateManager.setDepartmentId(_rs.getString("DEPT_ID"));
                    initiateManager.setDepartmentName(_rs.getString("dep_description"));
                    initiateManager.setJobId(_rs.getString("JOB_CODE"));
                    initiateManager.setJobName(_rs.getString("JOB_NAME"));
                    initiateManager.setRequiredNumber(_rs.getInt("NUMBER_OF_EMPLOYEE"));
                    myReturn.add(initiateManager);
                }
            }

        } catch (SQLException ex) {
            myReturn = null;
        }
        finally{ try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }


        return myReturn;
    }
}
