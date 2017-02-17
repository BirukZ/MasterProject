/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;
import entity.employeeEntity.EmployeeEntityOld;
import entity.employeeHistoryEntity.TransferEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class TransferManager {

    private Option[] transferRecords;
    TransferEntity transfer = new TransferEntity();
    EmployeeEntityOld emp = new EmployeeEntityOld();

    /**
     * The method instatiates the TransferEntity class and calls the entity method
     * addTransferRequest with the instatiated object.
     * @param employeeId the employee identifier
     * @param requesteDate the date the request is made
     * @param fromDepartement the current department of the employee
     * @param toDepartement the destination department
     * @param reason the reason for requesting transfer if there is any
     * @return true upon successfull insertion, false otherwise
     */
    public boolean addTransferRequest(String employeeId, String requestDate, String fromDepartment, String toDepartement, String reason) {
        TransferEntity trainsferEntity = new TransferEntity(employeeId,
                fromDepartment, toDepartement, requestDate, reason);
        try {
            int i = transfer.addTransferRequest(trainsferEntity);
            if (i != 0) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * The method instatiates the TransferEntity class and calls the entity method
     * updateTransferRequest with the instatiated object.
     * @param transferId the unique transfer record identifier
     * @param employeeId the unique employee identifier
     * @param fromDepartement the current department of the employee
     * @param toDepartement the destination department
     * @param requesteDate the date the request is made
     * @param reason the reason for requesting transfer if there is any
     * @param checkedBy the employee who checked the request
     * @param checkedDate the date the request is checked
     * @param approvedBy the employee who approved the request
     * @param approvalDate the date the approval is made
     * @return true upon successfull insertion, false otherwise
     */
    public boolean updateTransferRequest(int transferId, String employeeId, String fromDepartement, String toDepartement, String requesteDate, String reason, String checkedBy, String checkedDate, String approvedBy, String approvalDate) {
        TransferEntity trainsferEntity = new TransferEntity(transferId, employeeId, fromDepartement, toDepartement, requesteDate, reason, checkedBy, checkedDate, approvedBy, approvalDate);
        try {
            int i = transfer.updateTransferRequest(trainsferEntity);
            if (i != 0) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    /**
     * The method uses the <code>ResultSet</code> object rs from the transfer
     * method and arranges the data into <code>HashMap</code> object which intern
     * is arranged into and <code>ArrayList</code> ot type <code>HashMap</code>
     * @param employeeid the unique employee identifier
     * @return an <code>ArrayList</code> of type <code>HashMap</code> with transfer data
     */
    public ArrayList<HashMap> readTransferRecods(String employeeid) {

        ResultSet rs;
        ArrayList<HashMap> transfers = new ArrayList<HashMap>();
        try {
            rs = transfer.readTransferRecodsByEmpId(employeeid);
            while (rs.next()) {
                HashMap data = new HashMap();
                data.put("transfer_Id", rs.getString("transfer_Id"));
                data.put("empId", rs.getString("emp_Id"));
                data.put("empName", rs.getString("first_Name") + " " + rs.getString("middle_Name") + " " + rs.getString("last_Name"));
                data.put("fromDept", rs.getString("transfered_From"));
                data.put("toDept", rs.getString("transfered_To"));
                data.put("reqDate", rs.getString("request_Date"));
                data.put("reason", rs.getString("reason"));

                transfers.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return transfers;
    }

    /**
     * The method uses the <code>ResultSet</code> object rs from the transfer
     * method and arranges the data into <code>HashMap</code> object which intern
     * is arranged into and <code>ArrayList</code> ot type <code>HashMap</code>
     * @return an <code>ArrayList</code> of type <code>HashMap</code> with transfer data
     */
    public ArrayList<HashMap> readNewTransferRecods() {
        ResultSet rs;
        ArrayList<HashMap> transfers = new ArrayList<HashMap>();
        try {
            rs = transfer.readNewTransferRecods();
            while (rs.next()) {
                HashMap data = new HashMap();
                data.put("transfer_Id", rs.getString("transfer_Id"));
                data.put("empId", rs.getString("emp_Id"));
                data.put("empName", rs.getString("first_Name") + " " + rs.getString("middle_Name") + " " + rs.getString("last_Name"));
                data.put("fromDept", rs.getString("transfered_From"));
                data.put("toDept", rs.getString("transfered_To"));
                data.put("reqDate", rs.getString("request_Date"));
                data.put("reason", rs.getString("reason"));

                transfers.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return transfers;
    }

    /**
     * The method reads transfer records made by the employee and arranges the result
     * into an <code>Option</code>
     * @param employeeID the employee identifier
     * @param forWhat indicates the status
     * @return an <code>Option</code> object that is a model bean that
     * represents a selectable choice in a selection component
     */
    public Option[] readTransferRecod(String employeeID) {
        ArrayList<HashMap> transferData = new ArrayList<HashMap>();
        try {
            transferData = this.readTransferRecods(employeeID);
            setTransferRecords(new Option[transferData.size() + 1]);
            getTransferRecords()[0] = new Option("0", "id" + "  " + ",Transfer Type,      Date");
            for (int i = 0; i < transferData.size(); i++) {
                Option leaveOpt = new Option(transferData.get(i).get("transfer_Id").toString(), transferData.get(i).get("transfer_Id").toString() + " " +
                        "" + transferData.get(i).get("toDept").toString() + " " +
                        "" + transferData.get(i).get("reqDate").toString());
                getTransferRecords()[i + 1] = leaveOpt;
            }
            return getTransferRecords();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * The method reads new transfer records made by the employee and arranges the result
     * into an <code>Option</code>
     * @param forWhat indicates the status
     * @return an <code>Option</code> object that is a model bean that
     * represents a selectable choice in a selection component
     */
    public Option[] readNewTransferRecod() {
        ArrayList<HashMap> transferData = new ArrayList<HashMap>();
        try {
            transferData = this.readNewTransferRecods();
            setTransferRecords(new Option[transferData.size() + 1]);
            getTransferRecords()[0] = new Option("0", "id" + "  " + ",Transfer Type,      Date");
            for (int i = 0; i < transferData.size(); i++) {
                Option leaveOpt = new Option(transferData.get(i).get("transfer_Id").toString(), transferData.get(i).get("transfer_Id").toString() + " " +
                        "" + transferData.get(i).get("toDept").toString() + " " +
                        "" + transferData.get(i).get("reqDate").toString());
                getTransferRecords()[i + 1] = leaveOpt;
            }
            return getTransferRecords();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * The method uses the <code>ResultSet</code> object rs from the transfer
     * method and arranges the data into <code>HashMap</code> object which intern
     * is arranged into and <code>ArrayList</code> ot type <code>HashMap</code>
     * @param transferId the unique transfer identifier
     * @return an <code>ArrayList</code> of type <code>HashMap</code> with transfer data
     */
    public ArrayList<HashMap> readTransferRecodsByTransferId(String transferId) {

        ResultSet rs;
        ArrayList<HashMap> transfers = new ArrayList<HashMap>();
        try {
            rs = transfer.readTransferRecods(transferId);
            while (rs.next()) {
                HashMap data = new HashMap();
                data.put("transfer_Id", rs.getString("transfer_Id"));
                data.put("empId", rs.getString("emp_Id"));
                data.put("empName", rs.getString("first_Name") + " " + rs.getString("middle_Name") + " " + rs.getString("last_Name"));
                data.put("empTitle", rs.getString("empTitle"));
                data.put("empJob", rs.getString("empJob"));
                data.put("fromDeptId", rs.getString("transfered_From"));
                data.put("fromDeptDesc", rs.getString("sourceDept"));
                data.put("toDeptId", rs.getString("transfered_To"));
                data.put("toDeptDesc", rs.getString("destinationDept"));
                data.put("reqDate", rs.getString("request_Date"));
                data.put("reason", rs.getString("reason"));
                data.put("status", rs.getString("STATUS"));
                transfers.add(data);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return transfers;
    }

    /**
     * The method makes changes in the transfer by calling updateTransferApproval
     * and in the employee profile by calling updateEmployeeDepartment
     * @param toDepartment the destination department
     * @param empId the emplooyee
     * @param transferid the unique transfer identifier
     * @param approvedBy the employee id who made the approval
     * @param approvalDate the date the approval is made
     * @param approve the status of the transfer process
     * @param commentApprove the comment given to transfer
     * @return true upon successfull updation, false otherwise
     */
    public boolean updateTransferApproval(String toDepartment, String empId, int transferid,
            String approve, String commentApprove, String approvedDate, String approvedBy) throws Exception {
        TransferEntity transferApproval = new TransferEntity(transferid,
                approvedBy, approvedDate, approve, commentApprove);
        try {
            if (transfer.updateTransferApproval(transferApproval) != 0) {
                emp.setDepartment_id(toDepartment);
                emp.setDepartmentid(toDepartment);
                if (emp.updateEmployeeDepartment(toDepartment, empId) != 0) {
                    return true;
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return false;
    }

    /**
     * @return the transferRecords
     */
    public Option[] getTransferRecords() {
        return transferRecords;
    }

    /**
     * @param transferRecords the transferRecords to set
     */
    public void setTransferRecords(Option[] transferRecords) {
        this.transferRecords = transferRecords;
    }
}
