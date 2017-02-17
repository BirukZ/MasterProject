/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import com.sun.webui.jsf.model.Option;
import entity.Transfer.TransferEntity;
import entity.terminationEntity.TransferApproveEntity;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.HRUtilities;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleCachedRowSet;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author kibrom
 */
public class TransferApproveManager {

    public static final String TRANSFER_DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String TRANSFER_DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String TRANSFER_DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String TRANSFER_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String TRANSFER_DECISION_NONE = "-1";
    TransferEntity transferEntity = new TransferEntity();
    private EmployeeManage employeeManage = new EmployeeManage();
    private DepartmentManage departmentManage = new DepartmentManage();
    TransferApproveEntity transferApproveEntity = new TransferApproveEntity();
    EmployeeManage employeeManager = new EmployeeManage();
    public static final String PROCESS_TRANSFER = AuthorizationManager.PROCESS_TRANSFER;//"8"
    public static final String FINAL_STATE_TRANSFER = AuthorizationManager.readFinalState(PROCESS_TRANSFER);
    public static final String INITIAL_STATE_TRANSFER = AuthorizationManager.readInitialState(PROCESS_TRANSFER);
    String userName = "";
    String requesterId;
    String reasonForTransfer;
    int transferProcessType;
    private static String fromDepartment = null;
    private static String toDepartment = null;



    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public EmployeeManage getEmployeeManage() {
        return employeeManage;
    }

    public void setEmployeeManage(EmployeeManage employeeManage) {
        this.employeeManage = employeeManage;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public static String getFromDepartment() {
        return fromDepartment;
    }

    public static void setFromDepartment(String fromDepartment) {
        TransferApproveManager.fromDepartment = fromDepartment;
    }

    public static String getToDepartment() {
        return toDepartment;
    }

    public static void setToDepartment(String toDepartment) {
        TransferApproveManager.toDepartment = toDepartment;
    }

    public TransferApproveEntity getTransferApproveEntity() {
        return transferApproveEntity;
    }

    public void setTransferApproveEntity(TransferApproveEntity transferApproveEntity) {
        this.transferApproveEntity = transferApproveEntity;
    }

    public TransferEntity getTransferEntity() {
        return transferEntity;
    }

    public void setTransferEntity(TransferEntity transferEntity) {
        this.transferEntity = transferEntity;
    }


    public String getReasonForTransfer() {
        return reasonForTransfer;
    }

    public void setReasonForTransfer(String reasonForTransfer) {
        this.reasonForTransfer = reasonForTransfer;
    }

    public int getTransferProcessType() {
        return transferProcessType;
    }

    public void setTransferProcessType(int transferProcessType) {
        this.transferProcessType = transferProcessType;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }
    public boolean  UpdateEmployeeStatus(String toPosition, String toRank, String toSalary, String requesterID, String payGrade, String depID, String positionName, String effectiveFrom)
    {
        return transferApproveEntity.UpdateEmployeeInfo(toPosition,toRank,toSalary,requesterID,payGrade,depID,positionName,effectiveFrom);
    }



    public boolean UpdateEmployeeStatusNew(String toPosition, String toRank, String toSalary, String requester_id, String payGrade, String id, String updatedPosition, String effectiveDate)
    {
        return transferApproveEntity.UpdateEmployeeInfoAndStatus(toPosition,toRank,toSalary,requester_id,payGrade,id,updatedPosition,effectiveDate);
    }

    public boolean saveTransferDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_TRANSFER, decision);
        String strTransferId = null;
        String strEmployeeId = null;
        String strRank = null;
        String strPaygrade = null;
        String strSalary = null;
        String strEmployeeType = null;
        String strEmployementType = null;
        String strFromDepartment = null;
        String strToDepartment = null;
        String toPosition=null;
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        strTransferId = String.valueOf(requestId);
                                    employeeManage = new EmployeeManage();
                                    employeeManage.loadEmpoyeeProfile(requesterId);
                                    strEmployeeId = requesterId;
                                    strRank = employeeManage.getRankId();
                                    strPaygrade = employeeManage.getDrlPayGrade();
                                    strSalary = employeeManage.getSalary();
                                    strEmployeeId = requesterId;
                                    strEmployeeType = employeeManage.getPermanentOrContract();
                                    strEmployeeId = requesterId;
                                   
        try {
            boolean transferReturn=false;
            transferApproveEntity = new TransferApproveEntity(requestId, processedBy, decision, nextState, commentGiven, userName, recorededDateAndTime);
            if (transferApproveEntity.insertTransferDecision())
            {
              transferReturn=true;


            }

            return transferReturn;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean TakeBackUpOfTransfere(int requestID, String requesterID, String approvedID, String backUpTakenDateAndTime, String prevPos, String toPosition, String prevSalary, String toSalary, String prevDeptID, String dpid)
    {
       return transferApproveEntity.TakeBackUpOfTransfere( requestID,  requesterID,  approvedID,  backUpTakenDateAndTime,  prevPos,  toPosition,  prevSalary,  toSalary,  prevDeptID,  dpid);
    }

    public String getPositionName(String toPosition)
    {
        try
        {
       ResultSet _rs=transferApproveEntity.getPositionName(toPosition);
       String positionName=null;

       while(_rs.next()){

       positionName=_rs.getString("job_name");

       }
       return positionName;
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }



    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();

        decisionLists =
                new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<Option> getRequestsToBeProcessed() {
        ArrayList<Option> pendingRequests = new ArrayList<Option>();
        try {
            ResultSet _rs = transferApproveEntity.selectApprovableRequest(userName);
            while (_rs.next()) {
                pendingRequests.add(new Option(_rs.getString("TRANSFER_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("DESCRIPTION"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("DATE_REQUEST")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * returns all decision made on a request
     * basically intended to show history of a request on a datatable
     * @param requestId the id of the request
     */
    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
          try {
            ResultSet _rs = transferApproveEntity.selectProcessedLeaveRequest(requestId);
            ArrayList<RequestHistoryModel> requestHistoryList = new ArrayList<RequestHistoryModel>();
            int counter = 0;
            while (_rs.next()) {
                counter++;
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!userName.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }

                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 9);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "" : _rs.getString("COMMENT_GIVEN");
                String givenDecision = _rs.getString("PERMISSION_NAME");
                requestHistoryList.add(new RequestHistoryModel(counter, deciderEmployeeId, deciderFullName, givenDecision, timeStamp, commentGiven));
            }

            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> readApproveableLists(String states) {
        ArrayList<String> strings = transferApproveEntity.readApproveableLists(states);
        ArrayList<SelectItem> approableLists = new ArrayList<SelectItem>();
        for (int i = 0; i <
                strings.size(); i++) {
            String[] datas = strings.get(i).split("#");
            approableLists.add(new SelectItem(datas[0], datas[1]));
        }

        return approableLists;
    }
//<editor-fold >

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

   public byte[] singleSelect(int documentId) {


        try {
           // OracleCachedRowSet ocrs = new OracleCachedRowSet();
            byte[] bytePicture = null;
          OracleSerialBlob blo =  transferApproveEntity.select_Document(documentId);

        //    if (ocrs.next()) {
              bytePicture = blo.getBytes(0, (int) blo.length());

              //  bytePicture = ocrs.getBlob("DOCUMENT_PATH").getBytes(1, (int) ocrs.getBlob("DOCUMENT_PATH").length());
                return bytePicture;
          //  }
        } catch (Exception ex) {
            ex.printStackTrace();


        }
        return null;
    }
   //
//     try {
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs = transferEntity.readDocumentsAttached(docId);
//            if (ocrs.next()) {
//                HashMap data = new HashMap();
//                data.put("docId1", ocrs.getString("DOCUMENT_ID"));
//                data.put("docName", ocrs.getString("DOCUMENT_ATTACHED_NAME"));
//                data.put("docPath", ocrs.getBlob("DOCUMENT_PATH"));
//                return data;
//            } else {
//                return null;
//            }
//
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }

   //
//</editor-fold >
}
