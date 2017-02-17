/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EmployeeEntity;
import java.sql.ResultSet;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class EmployeeManager {

    EmployeeEntity employeeEntity;
    EmployeeModel employeeModel;

    public EmployeeModel getEmployeeProfile(String employeeId) {
        employeeEntity = new EmployeeEntity();
        employeeModel = new EmployeeModel();
        try {
            ResultSet _rs =null; //employeeEntity.selectEmployeeProfile(employeeId);
            if (_rs.next()) {
                employeeModel.setTitle(_rs.getString("TITLE"));
                employeeModel.setFirstName(_rs.getString("FIRST_NAME"));
                employeeModel.setMiddleName(_rs.getString("MIDDLE_NAME"));
                employeeModel.setLastName(_rs.getString("LAST_NAME"));
                employeeModel.setFullName(_rs.getString("FIRST_NAME") + "  " + _rs.getString("MIDDLE_NAME") + "  " + _rs.getString("LAST_NAME"));
                employeeModel.setGender(_rs.getString("GENDER"));
                employeeModel.setBirthDate(_rs.getString("BIRTH_DATE"));
                employeeModel.setDepartmentId(_rs.getString("DEPARTMENT_ID"));
                employeeModel.setJobTitleId(_rs.getString("JOB_TITLE_ID"));
                employeeModel.setRecruitmentDate(_rs.getString("RECRUITMENT_DATE"));
                employeeModel.setPensionNumber(_rs.getString("PENSION_NUMBER"));
                employeeModel.setTinNumber(_rs.getString("TIN_NUMBER"));
                employeeModel.setPermanentOrContract(_rs.getString("ERMANENT_OR_CONTRACT"));
                employeeModel.setShiftOrNormal(_rs.getString("SHIFT_OR_NORMAL"));
                employeeModel.setMartialStatus(_rs.getString("MARTIAL_STATUS"));
                employeeModel.setSalary(_rs.getString("SALARY"));
                employeeModel.setRank(_rs.getString("RANK"));
                employeeModel.setPayGrade(_rs.getString("PAY_GRADE"));
                employeeModel.setNationality(_rs.getString("NATIONALITY"));
                employeeModel.setNation(_rs.getString("NATION"));
                employeeModel.setReligion(_rs.getString("RELIGION"));
                employeeModel.setEmploymentStatus(_rs.getString("EMPLOYMENT_STATUS"));
                employeeModel.setUserName(_rs.getString("USER_NAME"));
                employeeModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                employeeModel.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
            }
            _rs.close();
            return employeeModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
