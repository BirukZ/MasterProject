/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.powerDeligationManager;

import com.sun.webui.jsf.model.Option;
import entity.powerDeligationEntity.PowerDeligationRequestEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import manager.authorizationManager.AuthorizationManager;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.StringDateManipulation;

/**
 *
 * @author mekete VS BravoZulu
 */
public class PowerDeligationRequestManager {



    PowerDeligationRequestEntity deligationRequestEntity = new PowerDeligationRequestEntity();
    PowerDeligationRequestModel deligationRequestModel = new PowerDeligationRequestModel();
    PowerDeligationTakenModel deligationTakenModel = new PowerDeligationTakenModel();
    ArrayList<PowerDeligationRequestModel> listOfPowerDeligationRequestModel = new ArrayList<PowerDeligationRequestModel>();
    EmployeeManage employeeManager = new EmployeeManage();
    AuthorizationManager authorizationManager = new AuthorizationManager();
    String userName = "";
    String logedID="";
   

//<editor-fold defaultstate="collapsed" desc="All Getters and Setters" >
    public ArrayList<PowerDeligationRequestModel> getListOfPowerDeligationRequestModel() {
        return listOfPowerDeligationRequestModel;
    }

    public AuthorizationManager getAuthorizationManager() {
        return authorizationManager;
    }

    public void setAuthorizationManager(AuthorizationManager authorizationManager) {
        this.authorizationManager = authorizationManager;
    }

    public void setListOfPowerDeligationRequestModel(ArrayList<PowerDeligationRequestModel> listOfPowerDeligationRequestModel) {
        this.listOfPowerDeligationRequestModel = listOfPowerDeligationRequestModel;
    }

    public PowerDeligationRequestModel getDeligationRequestEntity() {
        return deligationRequestModel;
    }

    public void setDeligationRequestEntity(PowerDeligationRequestModel deligationRequestEntity) {
        this.deligationRequestModel = deligationRequestEntity;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getLogedID() {
        return logedID;
    }

    public void setLogedID(String logedID) {
        this.logedID = logedID;
    }
    
    //</editor-fold >

    public HashMap getPowerDeligationInformation(int requestId) {
        try {
            HashMap data = null;
            ResultSet _rs = deligationRequestEntity.selectPowerDeligationRequestFromId(requestId);
            if (_rs.next()) {
                data.put("powDelReqId", _rs.getInt("POW_DEL_REQ_ID"));
                data.put("startDate", _rs.getString("START_DATE"));
                data.put("endDate", _rs.getString("END_DATE"));
                data.put("deligatedPosition", _rs.getInt("POW_DEL_REQ_ID"));
                data.put("deligationStatus", _rs.getInt("DELIGATION_STATUS"));
                data.put("registeredBy", _rs.getInt("REGISTERED_BY"));
                data.put("registeredDate", _rs.getInt("REGISTERED_DATE"));
                data.put("deligationReason", _rs.getInt("DELIGATION_REASON"));
                data.put("deligatorId", _rs.getInt("DELIGATOR_ID"));
                data.put("delegateeId", _rs.getInt("DELEGATEE_ID"));
                _rs.close();
                return data;
            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<Option> getPowerDeligationInformation(String deligator, String deligatee) {

        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            _rs = deligationRequestEntity.selectPowerDeligationRequestFromDeligatorIdAndDeligateeId(deligator, deligatee, userName);
            while (_rs.next()) {

                int powDelReqId = _rs.getInt("POW_DEL_REQ_ID");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String deligatedPosition = _rs.getString("DELIGATED_POSITION");
                String deligationStatus = _rs.getString("DELIGATION_STATUS");
                String deligatorId = _rs.getString("DELIGATOR_ID");
                String delegateeId = _rs.getString("DELEGATEE_ID");
                String deligationReason = _rs.getString("DELIGATION_REASON");
                String optionId = Integer.toString(powDelReqId) + "--" + deligationStatus + "--" + deligatorId + "--" + delegateeId + "--" + startDate + "--" + endDate + "--" + deligationReason;
                String OptionDesc = deligatedPosition + " ON " + startDate;
                Option data = new Option(optionId, OptionDesc);
                requestLists.add(data);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    /**
     * choices to select from. States are not as they are stored in the database
     */
    public ArrayList<Option> getPowerDeligationStatusTypes() {
        ArrayList<Option> powerDeligationStatusList = new ArrayList<Option>();
        powerDeligationStatusList.add(new Option(-1, "--SELECT STATUS--"));
        powerDeligationStatusList.add(new Option("PENDING", " PENDING"));
        powerDeligationStatusList.add(new Option("ONPROGRESS", " ON PROGRESS"));
        powerDeligationStatusList.add(new Option("APPROVED", " APPROVED"));
        powerDeligationStatusList.add(new Option("REJECTED", " REJECTED"));
        powerDeligationStatusList.add(new Option("TOBERESUBMITTED", " RESUBMIT"));
        return powerDeligationStatusList;
    }

    ///////////////////////////////////
    //not needed use the following function getApprovableRequests() {
    ////////////////////////////////////////////
    public ArrayList<Option> getPowerDeligationInformationByStatus(String status) {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            if (status.equals("PENDING")) {
                _rs = deligationRequestEntity.selectPowerDeligationRequestByStatus(Integer.parseInt(PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION), userName);
            } else if (status.equals("APPROVED")) {
                _rs = deligationRequestEntity.selectPowerDeligationRequestByStatus(Integer.parseInt(PowerDeligationApproveManager.FINAL_STATE_POWER_DELIGATION), userName);
            } else if (status.equals("ONPROGRESS")) {
                _rs = deligationRequestEntity.selectPowerDeligationRequestsOnProgress(userName);
            } else if (status.equals("REJECTED")) {
                _rs = deligationRequestEntity.selectRejectedPowerDeligationRequests();
            } else if (status.equals("TOBERESUBMITTED")) {
                _rs = deligationRequestEntity.selectPowerDeligationRequestsToBeResubmitted();
            }
            if (_rs != null) {
                int counter = 1;
                while (_rs.next()) {
                    int powDelReqId = _rs.getInt("POW_DEL_REQ_ID");
                    String startDate = _rs.getString("START_DATE");
                    String endDate = _rs.getString("END_DATE");
                    String deligatedPosition = _rs.getString("DELIGATED_POSITION");
                    String deligationStatus = _rs.getString("DELIGATION_STATUS");
                    String deligatorId = _rs.getString("DELIGATOR_ID");
                    String delegateeId = _rs.getString("DELEGATEE_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String deligationReason = _rs.getString("DELIGATION_REASON");
                    String optionId = Integer.toString(powDelReqId) + "--" + deligationStatus + "--" + deligatorId + "--" + delegateeId + "--" + requesterId + "--" + startDate + "--" + endDate + "--" + deligationReason;
                    String OptionDesc = deligatedPosition + " ON " + startDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                    ++counter;
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<Option> getPendingRequests() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = deligationRequestEntity.selectRequestsByStatus(PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("POW_DEL_REQ_ID") + "--" + _rs.getString("DELIGATOR_ID") + "--" + _rs.getString("DELEGATEE_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("DELIGATION_STATUS") + "--" + _rs.getString("HR_NEWDEPARTMET_NAME") + "--" + _rs.getString("HR_NEWDEPARTMENT_POSITION")+ "--" + _rs.getString("DELIGATED_POSITION"), _rs.getString("DELIGATOR_ID") + " =>" + _rs.getString("DELEGATEE_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean checkDelegator(String delegator_id) {
        boolean checker = false;
        try {
            checker = deligationRequestEntity.checkDelegator(delegator_id);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return checker;
    }
    public boolean cheakDisciplineAutontication(String requesterID){
    boolean checker=false;
      ResultSet _rs=null;
      int rank=0;
       String startDate;
       String endDate;
        //dateDifference = StringDateManipulation.compareDateDifference(txtStartDate.getValue().toString(), txtEndDate.getValue().toString());
           try {
               _rs=deligationRequestEntity.cheakDisciplineAutontication(requesterID);
               while(_rs.next()){
               rank=_rs.getInt("rank_id");
                      }
             if(rank>=14)
             {
             checker=true;

             }else {
             checker=false;
             }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return checker;




    }

    public int getWieght(int delegationWeight) {
        int wieght = 0;
        try {

   wieght= deligationRequestEntity.getWieghtOfPosition(delegationWeight);
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return wieght;
    }

    public int getDelegatorRank(String requster_id) {
        int checker = 0;
        try {
            checker = deligationRequestEntity.getEmployeeRank(requster_id);

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return checker;
    }

    public ArrayList<Option> getApprovableRequests() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            //_rs = deligationRequestModel.selectPowerDeligationRequestsOnProgress(userName);
            _rs = deligationRequestEntity.selectPowerDeligationRequestsOnProgress(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int powDelReqId = _rs.getInt("POW_DEL_REQ_ID");
                    String startDate = _rs.getString("START_DATE");
                    String endDate = _rs.getString("END_DATE");
                    String deligatedPosition = _rs.getString("DELIGATED_POSITION");
                    String deligationStatus = _rs.getString("DELIGATION_STATUS");
                    String deligatorId = _rs.getString("DELIGATOR_ID");
                    String delegateeId = _rs.getString("DELEGATEE_ID");
                    String deligationReason = _rs.getString("DELIGATION_REASON");
                    String optionId = Integer.toString(powDelReqId) + "--" + deligationStatus + "--" + deligatorId + "--" + delegateeId + "--" + startDate + "--" + endDate + "--" + deligationReason;
                    String OptionDesc = deligatedPosition + " ON " + startDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

  public ArrayList<Option> getMyRequests() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
       
        try {
            _rs = deligationRequestEntity.selectMyPowerDeligationRequests(userName,logedID );
            if (_rs != null) {
                while (_rs.next()) {
                    int powDelReqId = _rs.getInt("POW_DEL_REQ_ID");
                    String startDate = _rs.getString("START_DATE");
                    String deligatedPosition = _rs.getString("DELIGATED_POSITION");
                    String deligationStatus = _rs.getString("DELIGATION_STATUS");
                    String deligatorId = _rs.getString("DELIGATOR_ID");
                    String delegateeId = _rs.getString("DELEGATEE_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String newdepartmentNew = _rs.getString("HR_NEWDEPARTMET_NAME");
                    String newdepartmentPosition = _rs.getString("HR_NEWDEPARTMENT_POSITION");
                   // int delegatedPositionID=Integer.parseInt(_rs.getString("DELIGATED_POSITION"));
                    String optionId = Integer.toString(powDelReqId) + "--" + deligatorId + "--" + delegateeId + "--" + requesterId + "---" + deligationStatus + "---" + newdepartmentNew + "---" + newdepartmentPosition+"---"+deligatedPosition;
                    //String OptionDesc = deligatedPosition + " ON " + startDate;
                     String OptionDesc = delegateeId + " ON " + startDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

 public ArrayList<Option> getPowerDeligationInformationByStatus(int status) {

        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            _rs = deligationRequestEntity.selectPowerDeligationRequestByStatus(status, userName);
            while (_rs.next()) {

                int powDelReqId = _rs.getInt("POW_DEL_REQ_ID");
                String startDate = _rs.getString("START_DATE");
                String endDate = _rs.getString("END_DATE");
                String deligatedPosition = _rs.getString("DELIGATED_POSITION");
                String deligationStatus = _rs.getString("DELIGATION_STATUS");
                String deligatorId = _rs.getString("DELIGATOR_ID");
                String delegateeId = _rs.getString("DELEGATEE_ID");
                String deligationReason = _rs.getString("DELIGATION_REASON");

                String optionId = Integer.toString(powDelReqId) + "--" + deligationStatus + "--" + deligatorId + "--" + delegateeId + "--" + startDate + "--" + endDate + "--" + deligationReason;
                String OptionDesc = deligatedPosition + " ON " + startDate;
                Option data = new Option(optionId, OptionDesc);
                requestLists.add(data);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
    //startDate, endDate, deligatedPosition, registeredBy, registeredDate, deligationReason, delegatorId, delegateeId, requesterId

    public boolean savePowerDeligationInformation(String startDate, String endDate, String deligatedPosition, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId,boolean external,int wieght,String docRef) {
        //(String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId)
           deligationRequestModel = new PowerDeligationRequestModel(startDate, endDate, deligatedPosition, PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId, requesterId,wieght,docRef);
        try {
            deligationRequestEntity.insertPowerDeligationRequest(deligationRequestModel, external);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean savePowerDeligationInformationNew(String startDate, String endDate, String deligatedPosition, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId, boolean external, String newDelegatedPosition, String newDelegatedDepartment, int delegationWieght,String docRef) {
        //(String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId)
        deligationRequestModel = new PowerDeligationRequestModel(startDate, endDate, deligatedPosition, PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId, requesterId, newDelegatedPosition, newDelegatedDepartment, delegationWieght,docRef);
        try {
            deligationRequestEntity.insertPowerDeligationRequest(deligationRequestModel, external);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
    public boolean checkDept(String dept_id, String delegateeDept) {

        try {
            return deligationRequestEntity.checkDelegateeDept(dept_id, delegateeDept);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return true;
        }
    }

    public boolean checkEmpRank(String delegator_Id) {

        try {
            return deligationRequestEntity.checkEmployeeRank(delegator_Id);

        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return true;
        }
    }

    public boolean chechRole(String userName) {

        try {
            return deligationRequestEntity.checkRole(userName);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return true;
        }
    }
    public boolean updatePowerDeligationInformation(int powerDeligationId, String startDate, String endDate, String deligatedPosition, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId,String docref) {
        deligationRequestModel = new PowerDeligationRequestModel(powerDeligationId, startDate, endDate, deligatedPosition, PowerDeligationApproveManager.INITIAL_STATE_POWER_DELIGATION, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId,requesterId,docref);
        try {
            deligationRequestEntity.updatePowerDeligationRequest(deligationRequestModel);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean deletePowerDeligationRequest(int requestId) {
        try {
            return deligationRequestEntity.deletePowerDeligationRequest(requestId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean savePowerDeligationTakenHistory(int requestId, String takenStartDate, String takenEndDate, String deligateePrevPosition, String status) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        deligationTakenModel = new PowerDeligationTakenModel(requestId, takenStartDate, takenEndDate, deligateePrevPosition, "Revoked", timeStamp, userName);
        try {
          
            deligationRequestEntity.insertPowerDeligationTakenHistory(deligationTakenModel);
            //update employee status
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }


    public boolean updatePowerDeligationTakenHistory( int requestID ,int takenHistoryId, String takenStartDate, String takenEndDate, String deligateePrevPosition, String status) {
        String timeStamp = new Timestamp((new Date()).getTime()).toString();
        if (!(takenEndDate == null || takenEndDate.toString().equals(""))) {
            status = "Extend";
        }

        deligationTakenModel = new PowerDeligationTakenModel(requestID, takenHistoryId, -1, takenStartDate, takenEndDate, deligateePrevPosition, status, timeStamp, userName);
        try {

            deligationRequestEntity.updatePowerDeligationTakenHistory(deligationTakenModel);
//            if (!(takenEndDate == null || takenEndDate.equals(""))) {//returned surely
//            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public PowerDeligationRequestModel getPowerDeligationDetail(int requestId) {
        deligationRequestModel = new PowerDeligationRequestModel();
        try {
            ResultSet _rs = deligationRequestEntity.selectPowerDeligationRequestFromId(requestId);
            if (_rs.next()) {
                deligationRequestModel.setPowDelReqId(_rs.getInt("POW_DEL_REQ_ID"));
                deligationRequestModel.setDeligatorId(_rs.getString("DELIGATOR_ID"));//
                deligationRequestModel.setDeligateeId(_rs.getString("DELEGATEE_ID"));//
                deligationRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));//
                deligationRequestModel.setStartDate(_rs.getString("START_DATE"));//
                deligationRequestModel.setEndDate(_rs.getString("END_DATE"));//
                deligationRequestModel.setDeligationStatus("DELIGATION_STATUS");  //
                deligationRequestModel.setDeligationReason(_rs.getString("DELIGATION_REASON"));//
                deligationRequestModel.setDelegationWieght(_rs.getInt("RATE"));//
                deligationRequestModel.setDocRefeNumber(_rs.getString("DOC_REFERANCE"));

            } else {
                deligationRequestModel.setPowDelReqId(-1);
            }
            _rs.close();

            return deligationRequestModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public PowerDeligationTakenModel getTakenRevokedHistoryDetail(int requestId) {
        deligationTakenModel = new PowerDeligationTakenModel();
        try {
            ResultSet _rs = deligationRequestEntity.selectPowerDeligationTakenHistory(requestId);
            if (_rs.next()) {
                deligationTakenModel.setTakenHistoryId(_rs.getInt("TAKEN_HISTORY_ID"));
                deligationTakenModel.setRequestId(_rs.getInt("REQUEST_ID"));
                deligationTakenModel.setTakenStartDate(_rs.getString("TAKEN_START_DATE"));//
                deligationTakenModel.setTakenEndDate(_rs.getString("TAKEN_END_DATE"));//
                deligationTakenModel.setDeligateePrevPosition(_rs.getString("DELIGATEE_PREV_POSITION"));//
                deligationTakenModel.setStatus(_rs.getString("STATUS"));//
                deligationTakenModel.setTimeStamp("TIME_STAMP");  //
                deligationTakenModel.setUserName(_rs.getString("USER_NAME"));//
            } else {
                deligationTakenModel.setTakenHistoryId(-1);
            }
            _rs.close();
            return deligationTakenModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public static class PowerDeligationTakenModel implements Serializable {

        private int takenHistoryId;//     @Column(name = "TAKEN_HISTORY_ID")
        private int requestId;//     @Column(name = "TAKEN_HISTORY_ID")
        private String takenStartDate;//    @Column(name = "TAKEN_START_DATE")
        private String takenEndDate;//    @Column(name = "TAKEN_END_DATE")
        private String deligateePrevPosition;//    @Column(name = "DELIGATEE_PREV_POSITION")
        private String status;//    @Column(name = "STATUS")
        private String timeStamp;//    @Column(name = "TIME_STAMP")
        private String userName;//    @Column(name = "USER_NAME")

        public PowerDeligationTakenModel() {
        }

        public PowerDeligationTakenModel(int requestID, int takenHistoryId, int requestId, String takenStartDate, String takenEndDate, String deligateePrevPosition, String status, String timeStamp, String userName) {
            this.requestId=requestID;
            this.takenHistoryId = takenHistoryId;
            this.takenStartDate = takenStartDate;
            this.takenEndDate = takenEndDate;
            this.deligateePrevPosition = deligateePrevPosition;
            this.status = status;
            this.timeStamp = timeStamp;
            this.userName = userName;
        }

        public PowerDeligationTakenModel(int requestId, String takenStartDate, String takenEndDate, String deligateePrevPosition, String status, String timeStamp, String userName) {
            this.requestId = requestId;
            this.takenStartDate = takenStartDate;
            this.takenEndDate = takenEndDate;
            this.deligateePrevPosition = deligateePrevPosition;
            this.status = status;
            this.timeStamp = timeStamp;
            this.userName = userName;
        }

        public String getDeligateePrevPosition() {
            return deligateePrevPosition;
        }

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
        }

        public void setDeligateePrevPosition(String deligateePrevPosition) {
            this.deligateePrevPosition = deligateePrevPosition;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getTakenEndDate() {
            return takenEndDate;
        }

        public void setTakenEndDate(String takenEndDate) {
            this.takenEndDate = takenEndDate;
        }

        public int getTakenHistoryId() {
            return takenHistoryId;
        }

        public void setTakenHistoryId(int takenHistoryId) {
            this.takenHistoryId = takenHistoryId;
        }

        public String getTakenStartDate() {
            return takenStartDate;
        }

        public void setTakenStartDate(String takenStartDate) {
            this.takenStartDate = takenStartDate;
        }

        public String getTimeStamp() {
            return timeStamp;
        }

        public void setTimeStamp(String timeStamp) {
            this.timeStamp = timeStamp;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

    }

    /*
    POW_DEL_REQ_ID
    DELIGATOR_ID
    DELEGATEE_ID
    START_DATE
    END_DATE
    DELIGATED_POSITION
    DELIGATION_STATUS
    REGISTERED_BY
    TIME_STAMP
    DELIGATION_REASON*/

    public static class PowerDeligationRequestModel implements Serializable {

        /////////////////////////////////////////
        private int powDelReqId;//     @Column(name = "POW_DEL_REQ_ID")
        private String startDate;//    @Column(name = "START_DATE")
        private String endDate;//    @Column(name = "END_DATE")
        private String deligatedPosition;//    @Column(name = "DELIGATED_POSITION")
        private String deligationStatus;//    @Column(name = "DELIGATION_STATUS")
        private String registeredBy;//    @Column(name = "REGISTERED_BY")
        private String registeredDate;//    @Column(name = "REGISTERED_DATE")
        private String deligationReason;//    @Column(name = "DELIGATION_REASON")
        private String deligatorId;//    @JoinColumn(name = "DELIGATOR_ID", referencedColumnName = "EMP_ID")
        private String deligateeId;//    @JoinColumn(name = "DELEGATEE_ID", referencedColumnName = "EMP_ID")
        private String requesterId;//
        private String newDepartmentPosition;
        private String newDepartmentName;
        private Integer delegationWieght;
        private String docRefeNumber;

        public String getDocRefeNumber() {
            return docRefeNumber;
        }

        public void setDocRefeNumber(String docRefeNumber) {
            this.docRefeNumber = docRefeNumber;
        }

        public Integer getDelegationWieght() {
            return delegationWieght;
        }

        public void setDelegationWieght(Integer delegationWieght) {
            this.delegationWieght = delegationWieght;
        }

        public String getNewDepartmentName() {
            return newDepartmentName;
        }

        public void setNewDepartmentName(String newDepartmentName) {
            this.newDepartmentName = newDepartmentName;
        }

        public String getNewDepartmentPosition() {
            return newDepartmentPosition;
        }

        public void setNewDepartmentPosition(String newDepartmentPosition) {
            this.newDepartmentPosition = newDepartmentPosition;
        }

//<editor-fold defaultstate="collapsed" desc="All Getters and Setters" >
        public String getDeligatedPosition() {
            return deligatedPosition;
        }

        public void setDeligatedPosition(String deligatedPosition) {
            this.deligatedPosition = deligatedPosition;
        }

        public String getDelegateeId() {
            return deligateeId;
        }

        public void setDelegateeId(String delegateeId) {
            this.deligateeId = delegateeId;
        }

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

        public String getDeligationReason() {
            return deligationReason;
        }

        public void setDeligationReason(String deligationReason) {
            this.deligationReason = deligationReason;
        }

        public String getDeligationStatus() {
            return deligationStatus;
        }

        public void setDeligationStatus(String deligationStatus) {
            this.deligationStatus = deligationStatus;
        }

        public String getDeligatorId() {
            return deligatorId;
        }

        public void setDeligatorId(String deligatorId) {
            this.deligatorId = deligatorId;
        }

        public String getDeligateeId() {
            return deligateeId;
        }

        public void setDeligateeId(String deligateeId) {
            this.deligateeId = deligateeId;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public int getPowDelReqId() {
            return powDelReqId;
        }

        public void setPowDelReqId(int powDelReqId) {
            this.powDelReqId = powDelReqId;
        }

        public String getRegisteredBy() {
            return registeredBy;
        }

        public void setRegisteredBy(String registeredBy) {
            this.registeredBy = registeredBy;
        }

        public String getRegisteredDate() {
            return registeredDate;
        }

        public void setRegisteredDate(String registeredDate) {
            this.registeredDate = registeredDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }
        //</editor-fold>

        public PowerDeligationRequestModel() {
        }

        public PowerDeligationRequestModel(String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId) {
            this.startDate = startDate;
            this.endDate = endDate;
            this.deligatedPosition = deligatedPosition;
            this.deligationStatus = deligationStatus;
            this.registeredBy = registeredBy;
            this.registeredDate = registeredDate;
            this.deligationReason = deligationReason;
            this.deligatorId = deligatorId;
            this.deligateeId = delegateeId;
        }

        public PowerDeligationRequestModel(String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId, String newDepartmentPoition, String newDeprtmentName, int delegationWieght,String docRef) {
            this(startDate, endDate, deligatedPosition, deligationStatus, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId);
            this.requesterId = requesterId;
            this.newDepartmentPosition = newDepartmentPoition;
            this.newDepartmentName = newDeprtmentName;
            this.delegationWieght = delegationWieght;
            this.docRefeNumber=docRef;
        }
         public PowerDeligationRequestModel(String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId, String requesterId,int wieght,String docRef) {
            this(startDate, endDate, deligatedPosition, deligationStatus, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId);
            this.requesterId = requesterId;
            this.delegationWieght = wieght;
            this.docRefeNumber=docRef;
//            this.newDepartmentPosition=newDepartmentPoition;
//            this.newDepartmentName=newDeprtmentName;
        }

        public PowerDeligationRequestModel(int powDelReqId, String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId) {
            this(startDate, endDate, deligatedPosition, deligationStatus, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId);
            this.powDelReqId = powDelReqId;
        }
         public PowerDeligationRequestModel(int powDelReqId, String startDate, String endDate, String deligatedPosition, String deligationStatus, String registeredBy, String registeredDate, String deligationReason, String deligatorId, String delegateeId,String requesterId,String docRef) {
            this(startDate, endDate, deligatedPosition, deligationStatus, registeredBy, registeredDate, deligationReason, deligatorId, delegateeId);
            this.powDelReqId = powDelReqId;
            this.requesterId = requesterId;
            this.docRefeNumber=docRef;
        }
        /////////////////////////////////////////////////////////////
    }
    //<editor-fold >

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }





    public int delegatedEmployeLevel(String employeeId) {
        try {
            return deligationRequestEntity.delegatedEmployeLevel(employeeId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
   

    //</editor-fold >
}
