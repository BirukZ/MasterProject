/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.Transfer;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author kibrom
 */
public class TransferEntity extends ConnectionManager{

    private String transferId;
    private String requesterEmployeeId;
    private String employeeFulName;
    private String workingPlace;
    private String requestedDate;
    private String Status;
    private String timeStamp;
    private String userName;
    private ArrayList<TransfereeEntity> transferees = new ArrayList<TransfereeEntity>();
    private ArrayList<ApprovedTransfer> approvedTransfers = new ArrayList<ApprovedTransfer>();
    
    String stm, stm1, stm2;
    

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

    // <editor-fold defaultstate="collapsed" desc="Constractor, getters and setters">
    public TransferEntity() {
    }

    public TransferEntity(String transferId, String requesterEmployeeId, String employeeFulName, String workingPlace, String requestedDate, String Status, String timeStamp, String userName, ArrayList<TransfereeEntity> transferees, ArrayList<ApprovedTransfer> approvedTransfers) {
        this.transferId = transferId;
        this.requesterEmployeeId = requesterEmployeeId;
        this.employeeFulName = employeeFulName;
        this.workingPlace = workingPlace;
        this.requestedDate = requestedDate;
        this.Status = Status;
        this.timeStamp = timeStamp;
        this.userName = userName;
        this.transferees = transferees;
        this.approvedTransfers = approvedTransfers;
    }

    /**
     * @return the transferId
     */
    public String getTransferId() {
        return transferId;
    }

    /**
     * @param transferId the transferId to set
     */
    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    /**
     * @return the requesterEmployeeId
     */
    public String getRequesterEmployeeId() {
        return requesterEmployeeId;
    }

    /**
     * @param requesterEmployeeId the requesterEmployeeId to set
     */
    public void setRequesterEmployeeId(String requesterEmployeeId) {
        this.requesterEmployeeId = requesterEmployeeId;
    }

    /**
     * @return the employeeFulName
     */
    public String getEmployeeFulName() {
        return employeeFulName;
    }

    /**
     * @param employeeFulName the employeeFulName to set
     */
    public void setEmployeeFulName(String employeeFulName) {
        this.employeeFulName = employeeFulName;
    }

    /**
     * @return the workingPlace
     */
    public String getWorkingPlace() {
        return workingPlace;
    }

    /**
     * @param workingPlace the workingPlace to set
     */
    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    /**
     * @return the requestedDate
     */
    public String getRequestedDate() {
        return requestedDate;
    }

    /**
     * @param requestedDate the requestedDate to set
     */
    public void setRequestedDate(String requestedDate) {
        this.requestedDate = requestedDate;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
//        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
//        timeStamp=recorededDateAndTime;
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the Transferees
     */
    public ArrayList<TransfereeEntity> getTransferees() {
        return transferees;
    }

    /**
     * @param Transferees the Transferees to set
     */
    public void setTransferees(ArrayList<TransfereeEntity> transferees) {
        this.transferees = transferees;
    }

    /**
     * @return the approvedTransfers
     */
    public ArrayList<ApprovedTransfer> getApprovedTransfers() {
        return approvedTransfers;
    }

    /**
     * @param approvedTransfers the approvedTransfers to set
     */
    public void setApprovedTransfers(ArrayList<ApprovedTransfer> approvedTransfers) {
        this.approvedTransfers = approvedTransfers;
    }

    /**
     * @return the Status
     */
    public String getStatus() {
        return Status;
    }

    /**
     * @param Status the Status to set
     */
    public void setStatus(String Status) {
        this.Status = Status;
    }

    // </editor-fold >
    public boolean saveTransferRequest() {
        boolean myReturn = false;
        stm = "insert into TBL_TRANSFER_REQ(TRANSFER_REQ_ID,REQUESTER_EMP_ID,REQUESTED_DATE,STATUS,USERNAME,TIMESTAMP) values(sq_transfer_req.nextval ,?,?,?,?,?)";
        stm1 = "insert into TBL_TRANSFEREES (TRANSFEREE_ID,TRANSFER_REQ_ID,TRANSFEREE_EMP_ID,REQUESTED_PLACE,REQUESTED_JOB_POSITION,TRANSFER_TYPE,REASON,TIMESTAMP,USERNAME) values(sq_transferee.nextval,sq_transfer_req.CURRVAL,?,?,?,?,?,?,?)";
        String state = this.getInitialState();
        try {
            _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, this.getRequesterEmployeeId());
           _ps.setString(2, this.getRequestedDate());
           _ps.setString(3, state);
           _ps.setString(4, this.getUserName());
           _ps.setString(5, this.getTimeStamp());
           _ps.executeUpdate();
           _ps.clearParameters();
           _ps =_con.prepareStatement(stm1);

            Iterator<TransfereeEntity> it = this.transferees.iterator();
            while (it.hasNext()) {
                TransfereeEntity transfereeEntity = it.next();
               _ps.setString(1, transfereeEntity.getTransfereeEmployeeId());
               _ps.setString(2, transfereeEntity.getRequestedPlace());
               _ps.setString(3, transfereeEntity.getRequestedJobPosition());
               _ps.setString(4, transfereeEntity.getTransferType());
               _ps.setString(5, transfereeEntity.getReason());
               _ps.setString(6, this.getTimeStamp());
               _ps.setString(7, this.getUserName());
               _ps.executeUpdate();
               _ps.clearParameters();

            }
            myReturn = true;
        } catch (SQLException ex) {
            myReturn = false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public boolean updateTransferRequest() {

        boolean myReturn = false;
        stm = "update  TBL_TRANSFER_REQ  set REQUESTER_EMP_ID=?,REQUESTED_DATE=?,STATUS=?,USERNAME=?,TIMESTAMP=? where  TRANSFER_REQ_ID=?";

        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, this.getRequesterEmployeeId());
           _ps.setString(2, this.getRequestedDate());
           _ps.setString(3, this.getStatus());
           _ps.setString(4, this.getUserName());
           _ps.setString(5, this.getTimeStamp());
           _ps.setString(6, this.getTransferId());
           _ps.executeUpdate();
           _ps.clearParameters();
           _ps =_con.prepareStatement(stm1);

            myReturn = true;
        } catch (SQLException ex) {
            myReturn = false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;

    }

    public boolean cancelTransferRequest(String transferId) {
        boolean myReturn = false;
        stm = "delete from TBL_TRANSFER_REQ where TRANSFER_REQ_ID='" + transferId + "'";
        stm1 = "delete from TBL_TRANSFEREES where TRANSFER_REQ_ID='" + transferId + "'";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.executeUpdate(stm);
           _ps =_con.prepareStatement(stm1);
           _ps.executeUpdate(stm1);

            myReturn = true;
        } catch (SQLException ex) {
            myReturn = false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;

    }

    public ArrayList<String> readApproveableLists(String states) {


        ArrayList<String> myReturn = new ArrayList<String>();
        stm = "select TRANSFER_REQ_ID,REQUESTER_EMP_ID from TBL_TRANSFER_REQ where STATUS='" + states + "'";

        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                int i = 0;
                while (_rs.next()) {
                    i++;
                    String returnValue = "";
                    returnValue =_rs.getString("REQUESTER_EMP_ID") + "#" +_rs.getString("TRANSFER_REQ_ID");
                    myReturn.add(returnValue);
                }
            }

        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public TransferEntity readTransferRequest(String transferRequestId) {
        stm = "select  TBL_TRANSFER_REQ.TRANSFER_REQ_ID,TBL_TRANSFER_REQ.REQUESTER_EMP_ID,hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName ,hr_employee_info.DEPARTMENT_ID,hr_employee_info.JOB_CODE,TBL_TRANSFER_REQ.REQUESTED_DATE,TBL_TRANSFER_REQ.STATUS from TBL_TRANSFER_REQ left outer join hr_employee_info on  TBL_TRANSFER_REQ.REQUESTER_EMP_ID= hr_employee_info.EMP_ID  where  TBL_TRANSFER_REQ.TRANSFER_REQ_ID='" + transferRequestId + "'";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    this.transferId = transferRequestId;
                    this.requesterEmployeeId =_rs.getString("REQUESTER_EMP_ID");
                    this.employeeFulName =_rs.getString("fulName");
                    this.workingPlace =_rs.getString("DEPARTMENT_ID");
                    this.requestedDate =_rs.getString("REQUESTED_DATE");
                    this.Status =_rs.getString("STATUS");
                }
                this.setTransferees(this.readTransferees(transferRequestId));
                this.setApprovedTransfers(readApprovedTransfer(transferRequestId));
            }


        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return this;

    }

    public boolean approveTransfer(ApprovedTransfer approvedTransfer) {
        boolean myReturn = false;
        stm = "update  TBL_TRANSFER_REQ  set STATUS=? where  TRANSFER_REQ_ID=?";
        stm1 = "insert into  tbl_approved_transfer (APPROVED_TRANSFER_ID,TRANSFER_REQ_ID,APPROVER_EMP_ID,APPROVED_DATE,ACTION,STATE_NAME,TIME_STAMP,USER_NAME,REMARK) values (sq_approveTransfer.nextval,?,?,?,?,?,?,?,?)";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, this.getStatus());
           _ps.setString(2, this.getTransferId());
           _ps.executeUpdate();
           _ps.clearParameters();
           _ps =_con.prepareStatement(stm1);
           _ps.setString(1, this.getTransferId());
           _ps.setString(2, approvedTransfer.getApproverEmployeeId());
           _ps.setString(3, approvedTransfer.getApprovedDate());
           _ps.setString(4, approvedTransfer.getAction());
           _ps.setString(5, approvedTransfer.getStateName());
           _ps.setString(6, approvedTransfer.getTimeStamp());
           _ps.setString(7, approvedTransfer.getUserName());
           _ps.setString(8, approvedTransfer.getRemark());
           _ps.executeUpdate();
            myReturn = true;
        } catch (SQLException ex) {
            myReturn = false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public ArrayList<String> readHistory(String user) {
        return null;
    }

    private ArrayList<ApprovedTransfer> readApprovedTransfer(String transferRequestId) {
        ArrayList<ApprovedTransfer> myReturn = new ArrayList<ApprovedTransfer>();
        stm = "select  tbl_approved_transfer.APPROVED_TRANSFER_ID,tbl_approved_transfer.APPROVER_EMP_ID,hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName ,hr_employee_info.DEPARTMENT_ID,hr_employee_info.JOB_CODE,tbl_approved_transfer.APPROVED_DATE,tbl_approved_transfer.ACTION, tbl_process_state.STATE_NAME,tbl_approved_transfer.TIME_STAMP,tbl_approved_transfer.USER_NAME,tbl_approved_transfer.REMARK  from  tbl_process_state, tbl_approved_transfer left outer join hr_employee_info on tbl_approved_transfer.APPROVER_EMP_ID=hr_employee_info.EMP_ID  where   tbl_approved_transfer.STATE_NAME=tbl_process_state.PROCESS_STATE_ID and tbl_approved_transfer.TRANSFER_REQ_ID='" + transferRequestId + "' ";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    ApprovedTransfer approvedTransfer = new ApprovedTransfer(_rs.getString("APPROVED_TRANSFER_ID"),_rs.getString("APPROVER_EMP_ID"),_rs.getString("fulName"),_rs.getString("STATE_NAME"),_rs.getString("ACTION"),_rs.getString("APPROVED_DATE"),_rs.getString("TIME_STAMP"),_rs.getString("USER_NAME"),_rs.getString("REMARK"));
                    myReturn.add(approvedTransfer);
                }
            }

        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    private ArrayList<TransfereeEntity> readTransferees(String transferRequestId) {
        ArrayList<TransfereeEntity> myReturn = new ArrayList<TransfereeEntity>();
        stm = "select  tbl_transferees.TRANSFEREE_ID,TRANSFER_REQ_ID,TRANSFEREE_EMP_ID,hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName ,hr_employee_info.DEPARTMENT_ID,hr_employee_info.JOB_CODE,REQUESTED_PLACE,REQUESTED_JOB_POSITION,TRANSFER_TYPE,REASON from tbl_transferees left outer join hr_employee_info on tbl_transferees.TRANSFEREE_EMP_ID= hr_employee_info.EMP_ID where tbl_transferees.TRANSFER_REQ_ID='" + transferRequestId + "'";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    TransfereeEntity transfereeEntity = new TransfereeEntity(_rs.getString("TRANSFEREE_EMP_ID"),_rs.getString("fulName"),_rs.getString("DEPARTMENT_ID"),_rs.getString("JOB_CODE"),_rs.getString("REQUESTED_PLACE"),_rs.getString("REQUESTED_JOB_POSITION"),_rs.getString("TRANSFER_TYPE"),_rs.getString("REASON"));
                    myReturn.add(transfereeEntity);
                }
            }

        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public String getInitialState() {

        String myReturn = new String();
        stm2 = "select PROCESS_STATE_ID from BIB.tbl_process_state where PREVIES_PROCESS_STATE_ID=0 and PROCESS_ID='10'";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm2);
            _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    myReturn =_rs.getString("PROCESS_STATE_ID");
                }
            }

        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }
  
}
