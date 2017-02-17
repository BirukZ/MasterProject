/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.ContractEmployeeEntity;
import java.sql.SQLException;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Dereje
 */
public class ContractEmployeeManager {

    private String contractTermiDate;
    private String contractTermiRemark;
    private String contratId;
    private String employeeId;

    public ContractEmployeeManager() {
    }

    public ContractEmployeeManager(String contractTermiDate, String contractTermiRemark, String contratId, String employeeId) {
        this.contractTermiDate = contractTermiDate;
        this.contractTermiRemark = contractTermiRemark;
        this.contratId = contratId;
        this.employeeId = employeeId;
    }
    ContractEmployeeEntity contratEmp = new ContractEmployeeEntity();

    /**
     *
     * @param emp_Id
     * @param start_Date
     * @param end_Date
     * @param newOrOld
     */
    public boolean saveContract(String emp_Id, String start_Date, String end_Date, String newOrOld) {
        try {
            if (newOrOld.equals("1")) {
                return contratEmp.addContract(emp_Id, start_Date, end_Date);
            } else {
                return contratEmp.updateContract(emp_Id, start_Date, end_Date);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return false;
        }
    }

    public boolean saveContractTermination(ContractEmployeeManager contractEmployeeManager) {
        try {
            ContractEmployeeEntity contractEmployeeEntity = new ContractEmployeeEntity();
            contractEmployeeEntity.setContractTermiDate(contractEmployeeManager.getContractTermiDate());
            contractEmployeeEntity.setContractTermiRemark(contractEmployeeManager.getContractTermiRemark());
            contractEmployeeEntity.setContratId(contractEmployeeManager.getContratId());
            contractEmployeeEntity.setEmployeeId(contractEmployeeManager.getEmployeeId());
            return contratEmp.saveEmployeeContractTermination(contractEmployeeEntity);

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

            return false;
        }
    }

    /**
     * this method acept employee Id as argument
     * and send to  ContractEmployeeEntity class and return hashmap of
     * employee contract date and status
     * @param employeeID
     * @return
     */
    public String[] readContractDate(String employeeID) {
        return contratEmp.readContractStatus(employeeID);
    }

    public String getContractTermiDate() {
        return contractTermiDate;
    }

    public void setContractTermiDate(String contractTermiDate) {
        this.contractTermiDate = contractTermiDate;
    }

    public String getContractTermiRemark() {
        return contractTermiRemark;
    }

    public void setContractTermiRemark(String contractTermiRemark) {
        this.contractTermiRemark = contractTermiRemark;
    }

    public ContractEmployeeEntity getContratEmp() {
        return contratEmp;
    }

    public void setContratEmp(ContractEmployeeEntity contratEmp) {
        this.contratEmp = contratEmp;
    }

    public String getContratId() {
        return contratId;
    }

    public void setContratId(String contratId) {
        this.contratId = contratId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
}
