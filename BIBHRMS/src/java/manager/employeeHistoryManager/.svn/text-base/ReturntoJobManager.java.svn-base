/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

/**
 *
 * @author thecode
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
import entity.employeeHistoryEntity.ReturnToJobEntity;
import manager.globalUseManager.ErrorLogWriter;
import java.util.HashMap;
import manager.globalUseManager.GregorianCalendarManipulation;

/**
 *
 * @author insa
 */
public class ReturntoJobManager {

    private String employeeId;
    private String returnDate;
    private String reason;
    private String requestedDate;
    private String requestReason;
    ReturnToJobEntity returnToJobEntity = new ReturnToJobEntity();

    public ReturntoJobManager(String requestDate, String requestReason) {
        this.requestedDate = requestDate;
        this.requestReason = requestReason;

    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public ReturntoJobManager() {
    }

    public boolean saveReturnToJobInformation(
            String employeeId, String returnDate, String leaveRequestId, String leaveStartDate) {
        //int newLeaveYear = GregorianCalendarManipulation.calaculateMonthDifference(returnDate, leaveStartDate);
        try {
            return returnToJobEntity.updateEmployeeInformation(employeeId, returnDate, leaveRequestId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

        public boolean updateEmployeeReturnLeaveInformation(
            String employeeId, String returnDate, String leaveRequestId) {
        try {
            return returnToJobEntity.updateEmployeeReturnLeaveInformation(employeeId, returnDate, leaveRequestId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }



    public boolean saveReturnToJobAndAnualLeaveInformation(
            String employeeId, String returnDate,
            String leaveRequestId,
            String leaveStartDate,
            String employeementType,
            String workIn) {
//        if (employeementType.equals("Shift")) {
//
//        } else if (employeementType.equals("Office") && workIn.equals("Mugher")) {
//
//        } else if (employeementType.equals("Office") && workIn.equals("AddisAbeba")) {
//
//        }
        //int newLeaveYear = GregorianCalendarManipulation.calaculateMonthDifference(returnDate, leaveStartDate);
        try {
            return returnToJobEntity.updateEmployeeInformation(
                    employeeId,
                    returnDate,
                    leaveRequestId
                    );
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public HashMap readEmpLeaveInfo(String leaveId) {
        return returnToJobEntity.readEmpLeaveInfo(leaveId);
    }
}

