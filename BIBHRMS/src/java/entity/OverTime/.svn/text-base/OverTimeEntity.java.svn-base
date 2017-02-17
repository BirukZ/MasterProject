/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.OverTime;

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
public class OverTimeEntity extends ConnectionManager{

    private String overTimeId;
    private String requesterEmployeeId;
    private String requesterFullName;
    private String requestedDate;
    private String workPlace;
    private String workingDate;
    private String reason;
    private String status;
    private ArrayList<OverTimeWorkerEntity> workers;
    private ArrayList<ApprovedOverTimeEntity> approvedOverTime;
    private String userName;
    private String timeStamp;
    
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

    public OverTimeEntity() {
    }

    public OverTimeEntity(String overTimeId, String requesterEmployeeId, String requesterFullName, String requestedDate, String workPlace, String workingDate, String reason, String status, ArrayList<OverTimeWorkerEntity> workers, ArrayList<ApprovedOverTimeEntity> approvedOverTime, String userName, String timeStamp) {
        this.overTimeId = overTimeId;
        this.requesterEmployeeId = requesterEmployeeId;
        this.requesterFullName = requesterFullName;
        this.requestedDate = requestedDate;
        this.workPlace = workPlace;
        this.workingDate = workingDate;
        this.reason = reason;
        this.status = status;
        this.workers = workers;
        this.approvedOverTime = approvedOverTime;
        this.userName = userName;
        this.timeStamp = timeStamp;
    }

    /**
     * @return the overTimeId
     */
    public String getOverTimeId() {
        return overTimeId;
    }

    /**
     * @param overTimeId the overTimeId to set
     */
    public void setOverTimeId(String overTimeId) {
        this.overTimeId = overTimeId;
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
     * @return the requesterFullName
     */
    public String getRequesterFullName() {
        return requesterFullName;
    }

    /**
     * @param requesterFullName the requesterFullName to set
     */
    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    /**
     * @return the workPlace
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * @param workPlace the workPlace to set
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
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
     * @return the workingDate
     */
    public String getWorkingDate() {
        return workingDate;
    }

    /**
     * @param workingDate the workingDate to set
     */
    public void setWorkingDate(String workingDate) {
        this.workingDate = workingDate;
    }

    /**
     * @return the reason
     */
    public String getReason() {
        return reason;
    }

    /**
     * @param reason the reason to set
     */
    public void setReason(String reason) {
        this.reason = reason;
    }

    /**
     * @return the status
     */
    public String getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * @return the workers
     */
    public ArrayList<OverTimeWorkerEntity> getWorkers() {
        return workers;
    }

    /**
     * @param workers the workers to set
     */
    public void setWorkers(ArrayList<OverTimeWorkerEntity> workers) {
        this.workers = workers;
    }

    /**
     * @return the approvedOverTime
     */
    public ArrayList<ApprovedOverTimeEntity> getApprovedOverTime() {
        return approvedOverTime;
    }

    /**
     * @param approvedOverTime the approvedOverTime to set
     */
    public void setApprovedOverTime(ArrayList<ApprovedOverTimeEntity> approvedOverTime) {
        this.approvedOverTime = approvedOverTime;
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
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }
    // </editor-fold >

    public ArrayList<String> readHistory(String user) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<String> readApproveableLists(String states) {
        ArrayList<String> myReturn = new ArrayList<String>();
        stm = "select OVERTIME_REQ_ID,REQUESTER_EMP_ID from tbl_overTime_request where STATUS='" + states + "'";

        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
           _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {

                    String returnValue = "";
                    returnValue =_rs.getString("REQUESTER_EMP_ID") + "#" +_rs.getString("OVERTIME_REQ_ID");
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

    public void readOverTimeRequest(String overTimeId) {

        stm = "select  tbl_overTime_request.OVERTIME_REQ_ID, tbl_overTime_request.REQUESTER_EMP_ID, hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName , tbl_overTime_request.REQUESTED_DATE,  " +
                "tbl_overTime_request.WORKING_PLACE,  tbl_overTime_request.WORKING_DATE, tbl_overTime_request.REASON, " +
                " tbl_overTime_request.STATUS,tbl_overTime_request.USER_NAME, tbl_overTime_request.TIME_STAMP from tbl_overTime_request  LEFT OUTER JOIN hr_employee_info on  tbl_overTime_request.REQUESTER_EMP_ID=hr_employee_info.EMP_ID where   tbl_overTime_request.OVERTIME_REQ_ID='" + overTimeId + "'";
        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
           _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    this.overTimeId =_rs.getString("OVERTIME_REQ_ID");
                    this.requesterEmployeeId =_rs.getString("REQUESTER_EMP_ID");
                    this.requesterFullName =_rs.getString("fulName");
                    this.requestedDate =_rs.getString("REQUESTED_DATE");
                    this.workPlace =_rs.getString("WORKING_PLACE");
                    this.workingDate =_rs.getString("WORKING_DATE");
                    this.reason =_rs.getString("REASON");
                    this.status =_rs.getString("STATUS");
                    this.userName =_rs.getString("USER_NAME");
                    this.timeStamp =_rs.getString("TIME_STAMP");
                }

            }
            this.setWorkers(this.readWorkers(overTimeId));
            this.setApprovedOverTime(readApproved(overTimeId));
        } catch (SQLException ex) {
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }


    }

    private ArrayList<OverTimeWorkerEntity> readWorkers(String overTimeId) {
        ArrayList<OverTimeWorkerEntity> myReturn = new ArrayList<OverTimeWorkerEntity>();
        stm = "select tbl_overTime_worker.OVERTIME_WORKER_ID,tbl_overTime_worker.OVERTIME_REQ_ID,tbl_overTime_worker.WORKER_EMP_ID, hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName , hr_employee_info.DEPARTMENT_ID,hr_employee_info.JOB_CODE,tbl_overTime_worker.REASON,FROM_TIME,tbl_overTime_worker.TO_TIME from  tbl_overTime_worker LEFT OUTER JOIN hr_employee_info on tbl_overTime_worker.WORKER_EMP_ID=hr_employee_info.EMP_ID where  tbl_overTime_worker.OVERTIME_REQ_ID='" + overTimeId + "'";
        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
           _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    myReturn.add(new OverTimeWorkerEntity(_rs.getString("OVERTIME_WORKER_ID"),_rs.getString("WORKER_EMP_ID"),_rs.getString("fulName"),_rs.getString("JOB_CODE"),_rs.getString("REASON"),_rs.getString("FROM_TIME"),_rs.getString("TO_TIME")));
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

    private ArrayList<ApprovedOverTimeEntity> readApproved(String overTimeId) {
        ArrayList<ApprovedOverTimeEntity> myReturn = new ArrayList<ApprovedOverTimeEntity>();
        stm = "select tbl_approved_leave.APPROVE_LEAVE_ID,tbl_approved_leave.APPROVER_EMP_ID,hr_employee_info.FIRST_NAME  ||'  '||   hr_employee_info.MIDDLE_NAME  ||'  '||  hr_employee_info.LAST_NAME as fulName ,tbl_approved_leave.APPROVED_DATE,tbl_approved_leave.ACTION,tbl_approved_leave.APPROVED_NUMBER_OF_DAYS,FROM_DATE,TO_DATE,STATE_NAME,USER_NAME,TIME_STAMP from tbl_approved_leave left outer join hr_employee_info on  tbl_approved_leave.APPROVER_EMP_ID= HR_employee_info.EMP_ID  where LEAVE_REQUEST_ID='" + overTimeId + "'";
        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
           _rs = _ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    myReturn.add(new ApprovedOverTimeEntity(_rs.getString("APPROVED_OVERTIME_ID"),_rs.getString("APPROVER_EMP_ID"),_rs.getString("fulName"),_rs.getString("ACTION"),_rs.getString("APPROVED_DATE"), _rs.getString("STATE_NAME"),_rs.getString("USERNAME"),_rs.getString("TIMESTAMP"),_rs.getString("REMARK")));
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

    public boolean saveOverTimeRequest() {
        boolean myReturn = false;
         String initialState=this.getInitialState();
    
        stm = "insert into tbl_overtime_request (OVERTIME_REQ_ID, REQUESTER_EMP_ID,REQUESTED_DATE,WORKING_PLACE,WORKING_DATE,REASON,STATUS,USER_NAME,TIME_STAMP,IS_CLOSED) values (sq_overTIme_req.nextval,?,?,?,?,?,?,?,?,'false')";
        stm1 = "insert into tbl_overtime_worker  (OVERTIME_WORKER_ID,OVERTIME_REQ_ID,WORKER_EMP_ID,REASON,FROM_TIME,TO_TIME) values (sq_overTime_workers.nextval,sq_overTIme_req.currval,?,?,?,?)";

        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
            _ps.setString(1, this.getRequesterEmployeeId());
            _ps.setString(2, this.getRequestedDate());
            _ps.setString(3, this.getWorkPlace());
            _ps.setString(4, this.getWorkingDate());
            _ps.setString(5, this.getReason());
            _ps.setString(6,initialState);
            _ps.setString(7, this.getUserName());
            _ps.setString(8, this.getTimeStamp());

            _ps.executeUpdate();
            _ps.clearParameters();
            _ps =_con.prepareStatement(stm1);

            Iterator<OverTimeWorkerEntity> it = this.getWorkers().iterator();
            while (it.hasNext()) {
                OverTimeWorkerEntity overTimeWorkerEntity = it.next();
                _ps.setString(1, overTimeWorkerEntity.getWorkerEmployeeId());
                _ps.setString(2, overTimeWorkerEntity.getReason());
                _ps.setString(3, overTimeWorkerEntity.getFromTime());
                _ps.setString(4, overTimeWorkerEntity.getToTime());
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

    public boolean updateOverTimeRequest() {
        boolean myReturn = false;
        stm = "update  TBL_OverTime_request  set REQUESTER_EMP_ID=?,REQUESTED_DATE=?,WORKING_PLACE=?,WORKING_DATE=?,REASON=? ,USER_NAME=?,TIME_STAMP=? where  OVERTIME_REQ_ID=?";

        try {
           _con = getConnection();
            _ps =_con.prepareStatement(stm);
            _ps.setString(1, this.getRequesterEmployeeId());
            _ps.setString(2, this.getRequestedDate());
            _ps.setString(3, this.getWorkPlace());
            _ps.setString(4, this.getWorkingDate());
            _ps.setString(5, this.getReason());
            _ps.setString(6, this.getUserName());
            _ps.setString(7, this.getTimeStamp());
            _ps.setString(8, this.getOverTimeId());


            _ps.executeUpdate();
            _ps.clearParameters();
            _ps =_con.prepareStatement(stm1);

//            Iterator<TransfereeEntity> it = this.transferees.iterator();
//            while (it.hasNext()) {
//                TransfereeEntity transfereeEntity = it.next();
//               _ps.setString(1, transfereeEntity.getTransfereeEmployeeId());
//               _ps.setString(2, transfereeEntity.getRequestedPlace());
//               _ps.setString(3, transfereeEntity.getRequestedJobPosition());
//               _ps.setString(4, transfereeEntity.getTransferType());
//               _ps.setString(5, transfereeEntity.getReason());
//               _ps.setString(6, this.getTimeStamp());
//               _ps.setString(7, this.getUserName());
//               _ps.executeUpdate();
//               _ps.clearParameters();
//
//            }
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

    public boolean cancelOverTimeRequest() {

        boolean myReturn = false;
        stm = "delete from TBL_OverTime_request where OVERTIME_REQ_ID='" + this.getOverTimeId() + "'";
        stm1 = "delete from tbl_overTime_worker where OVERTIME_REQ_ID='" + this.getOverTimeId() + "'";
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

    public boolean approve(ApprovedOverTimeEntity approvedOverTimeEntity) {
        boolean myReturn = false;
        stm = "update  TBL_OverTime_request  set STATUS=? where  OVERTIME_REQ_ID=?";
        stm1 = "insert into tbl_Approved_overtime  (APPROVED_OVERTIME_ID,OVERTIME_REQUEST_ID,APPROVER_EMP_ID,APPROVED_DATE,ACTION,STATE_NAME,USERNAME,TIMESTAMP,REMARK) values (sq_approved_overTime.nextval,?,?,?,?,?,?,?,?)";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, this.getStatus());
           _ps.setString(2, this.getOverTimeId());
           _ps.executeUpdate();
           _ps.clearParameters();
           _ps =_con.prepareStatement(stm1);
           _ps.setString(1, this.getOverTimeId());
           _ps.setString(2, approvedOverTimeEntity.getApproverEmployeeId());
           _ps.setString(3, approvedOverTimeEntity.getApprovedDate());
           _ps.setString(4, approvedOverTimeEntity.getAction());
           _ps.setString(5, approvedOverTimeEntity.getStateName());
           _ps.setString(6, approvedOverTimeEntity.getUserName());
           _ps.setString(7, approvedOverTimeEntity.getTimeStamp());
           _ps.setString(8, approvedOverTimeEntity.getRemark());
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
    public  String getInitialState() {

        String myReturn = new String();
         stm2 = "select PROCESS_STATE_ID from mugher.tbl_process_state where PREVIES_PROCESS_STATE_ID='0' and PROCESS_ID='1'";
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
