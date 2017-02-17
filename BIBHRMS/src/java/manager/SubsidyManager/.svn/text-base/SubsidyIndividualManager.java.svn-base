/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.SubsidyManager;

import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;
import java.util.ArrayList;
import entity.employeeEntity.EmployeeEntityOld;
import entity.terminationEntity.TerminationEntity;
import fphrms.SessionBean1;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Set;
import javax.faces.model.SelectItem;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DPClone
 */
public class SubsidyIndividualManager {

    private EmployeeEntityOld employeeEntity = new EmployeeEntityOld();
    private TerminationEntity terminationEntity = new TerminationEntity();
    private SessionBean1 sessionBean1 = new SessionBean1();
    private Option[] employeeResignationRequest;
    private Option[] optPaymentCenter;
    private ArrayList<SelectItem> selPaymentCenter;
    private Option[] employeeProcessedResignationRequest;
    private String employeePostId;
    private String terminationType;
    private String resignationDateRequested;
    private String resignationDescription;
    private String resignationTypeDescription;
    private String empResignId = null;
    private String empStatetype;
    private String employeeIdResignedRequested;
    private String stateStatus;
    private String state;
    private String commentId;
    private String activeEmployee;
    private String empTerminationRequestId;
    private String empTerminationType;
    private String empTerminationRequestedDate;
    private String empTerminationDescription;
    private String empTerminationStatus;

    public SubsidyIndividualManager(String TerminationID) {
        this.TerminationID = TerminationID;
    }

    public SubsidyIndividualManager() {
    }
    private String TerminationID;

    public String getTerminationID() {
        return TerminationID;
    }

    public void setTerminationID(String TerminationID) {
        this.TerminationID = TerminationID;
    }

    public String getActiveEmployee() {
        return activeEmployee;
    }

    public void setActiveEmployee(String activeEmployee) {
        this.activeEmployee = activeEmployee;
    }
    private String checkId;

    public String getCheckId() {
        return checkId;
    }

    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    public String getEmpTerminationDescription() {
        return empTerminationDescription;
    }

    public void setEmpTerminationDescription(String empTerminationDescription) {
        this.empTerminationDescription = empTerminationDescription;
    }

    public String getEmpTerminationRequestId() {
        return empTerminationRequestId;
    }

    public void setEmpTerminationRequestId(String empTerminationRequestId) {
        this.empTerminationRequestId = empTerminationRequestId;
    }

    public String getEmpTerminationRequestedDate() {
        return empTerminationRequestedDate;
    }

    public void setEmpTerminationRequestedDate(String empTerminationRequestedDate) {
        this.empTerminationRequestedDate = empTerminationRequestedDate;
    }

    public String getEmpTerminationStatus() {
        return empTerminationStatus;
    }

    public void setEmpTerminationStatus(String empTerminationStatus) {
        this.empTerminationStatus = empTerminationStatus;
    }

    public String getEmpTerminationType() {
        return empTerminationType;
    }

    public void setEmpTerminationType(String empTerminationType) {
        this.empTerminationType = empTerminationType;
    }

    public EmployeeEntityOld getEmployeeEntity() {
        return employeeEntity;
    }

    public void setEmployeeEntity(EmployeeEntityOld employeeEntity) {
        this.employeeEntity = employeeEntity;
    }

    public TerminationEntity getTerminationEntity() {
        return terminationEntity;
    }

    public void setTerminationEntity(TerminationEntity terminationEntity) {
        this.terminationEntity = terminationEntity;
    }
    private String commentedBy;

    public String getCommentedBy() {
        return commentedBy;
    }

    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    String employeeId;
    String comment;
    String commentDate;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Option[] getEmployeeProcessedResignationRequest() {
        return employeeProcessedResignationRequest;
    }

    public void setEmployeeProcessedResignationRequest(Option[] employeeProcessedResignationRequest) {
        this.employeeProcessedResignationRequest = employeeProcessedResignationRequest;
    }

    public String getStateStatus() {
        return stateStatus;
    }

    public void setStateStatus(String stateStatus) {
        this.stateStatus = stateStatus;
    }

    public String getEmployeeIdResignedRequested() {
        return employeeIdResignedRequested;
    }

    public void setEmployeeIdResignedRequested(String employeeIdResignedRequested) {
        this.employeeIdResignedRequested = employeeIdResignedRequested;
    }

    public String getEmpResignId() {
        return empResignId;
    }

    public void setEmpResignId(String empResignId) {
        this.empResignId = empResignId;
    }

    public String getEmpStatetype() {
        return empStatetype;
    }

    public void setEmpStatetype(String empStatetype) {
        this.empStatetype = empStatetype;
    }

    public String getResignationTypeDescription() {
        return resignationTypeDescription;
    }

    public void setResignationTypeDescription(String resignationTypeDescription) {
        this.resignationTypeDescription = resignationTypeDescription;
    }

    public String getEmployeePostId() {
        return employeePostId;
    }

    public void setEmployeePostId(String employeePostId) {
        this.employeePostId = employeePostId;
    }

    public String getResignationDateRequested() {
        return resignationDateRequested;
    }

    public void setResignationDateRequested(String resignationDateRequested) {
        this.resignationDateRequested = resignationDateRequested;
    }

    public String getResignationDescription() {
        return resignationDescription;
    }

    public void setResignationDescription(String resignationDescription) {
        this.resignationDescription = resignationDescription;
    }

    public String getTerminationType() {
        return terminationType;
    }

    public void setTerminationType(String terminationType) {
        this.terminationType = terminationType;
    }

    public Option[] getEmployeeResignationRequest() {
        return employeeResignationRequest;
    }

    public void setEmployeeResignationRequest(Option[] employeeResignationRequest) {
        this.employeeResignationRequest = employeeResignationRequest;
    }

    /**
     * The method reads the employs services hired date and calculates the total service
     * in days.
     * @param empId the employee identofier
     * @return an integer indicating the total service months
     * @throws java.sql.Exception if a database access error occurs
     * or this method is called on a closed connection
     */
    public int calculateEmpServiceDays(String currentDate, String terminateDate) {
        int serviceInDays = 0;
        if (terminateDate.length() >= 1) {
            serviceInDays = StringDateManipulation.compareDateDifference(currentDate, terminateDate);
            return serviceInDays;
        } else {
          //  s.println("Bad Date Formatt");
        }

        return serviceInDays;
    }

    public int postNewTerminationRequest(HashMap requestInfo, HashMap itemInfo, HashMap itemOwnerInfo, Set<HashMap> supportiveInfo, HashMap itemHistoryInfo) {
        try {
            if (terminationEntity.addNewPost(requestInfo, itemInfo, itemOwnerInfo, supportiveInfo, itemHistoryInfo) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public String ReadDepartmentDescrption(String empId) {
        try {
            return terminationEntity.ReadDepartmentDescrption(empId);
        } catch (Exception ex) {
            return null;
        }
    }

    public String ReadUserID(String empId) {
        try {
            return terminationEntity.ReadUserID(empId);
        } catch (Exception ex) {
            return null;
        }
    }

    public String ReadOwnerGroupIDByUserID(String userID) {
        try {
            return terminationEntity.ReadOwnerGroupIDByUserID(userID);
        } catch (Exception ex) {
            return null;
        }
    }

    public String ReadEmployeeIDByRequestID(String requestId) {
        try {
            return terminationEntity.ReadEmployeeIDByRequestID(requestId);
        } catch (Exception ex) {
            return null;
        }
    }

    public String CheckStateStatus(int workflowId, int ownerGroupId) {
        try {
            if (terminationEntity.CheckStateStatus(workflowId, ownerGroupId) == null) {
                return "0";
            } else {
                return "1";
            }

        } catch (Exception ex) {
            return null;
        }
    }

    public int CurrentStateSequence(int workflowId, int ownerGroupId) {
        try {
            return terminationEntity.CurrentStateSequence(workflowId, ownerGroupId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public HashMap CurrentStateInformation(int workflowId, int sequence) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.CurrentStateInformation(workflowId, sequence);
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("stateId", ocrs.getString("WF_STATE_ID"));
                data.put("stateName", ocrs.getString("WF_STATE_NAME"));
                data.put("ownerGroupId", ocrs.getString("WF_OWNER_GROUP_ID"));
                return data;
            } else {
                return null;
            }
        } catch (Exception ex) {

            return null;
        }
    }

    public HashMap ReadLastTerminationRequestID() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadLastTerminatinRequestID();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("terminationId", ocrs.getString("REQUEST_ID"));
                return data;

            } else {
                return null;
            }
        } catch (Exception ex) {

            return null;
        }
    }

    public int DeleteAttachedDocument(String docId) {
        try {
            return terminationEntity.DeleteAttachedDocument(docId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    /**
     *
     * @param employeePostId
     * @param terminationType
     * @param currentDate
     * @param terminationDescription
     * @param terminationDate
     * @param terminationTypeSelected
     * @return
     */
    public int UpdateTerminationRequest(String requestId, String requestTypeId, String terminationDate, String description, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        try {

            if (terminationEntity.UpdateTerminationRequest(requestId, requestTypeId, terminationDate, description, supportiveInfo, deletedFile) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int ResubmiteTerminationRequest(String requestId, String requestTypeId, String terminationDate, String description, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile, int workflowId, int stateId, HashMap itemHistory) {
        try {

            if (terminationEntity.ResubmiteTerminationRequest(requestId, requestTypeId, terminationDate, description, supportiveInfo, deletedFile, workflowId, stateId, itemHistory) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int UpdateEmployeeStatus(String employeeId, String employeeStatus) {
        try {
            return terminationEntity.UpdateEmployeeStatus(employeeId, employeeStatus);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int UpdateWorkflowItemInformation(int workflowId, int requestId, int itemId, int ownerGroupId, int fromStateId, int toStateId, String remark, String insertedDate, String insertedBy, String actionTaken, int fromOwner, int toOwner) {
        try {
            return terminationEntity.UpdateWorkflowItemInformation(workflowId, requestId, itemId, ownerGroupId, fromStateId, toStateId, remark, insertedDate, insertedBy, actionTaken, fromOwner, toOwner);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * <p>Read the current selected state id.</p>
     * @param stateName
     * @param workflowId
     * @param workflowOwnerId
     * @return state id.
     */
    public int ReadStateID(String stateName, int workflowId, int workflowOwnerId) {
        try {
            return terminationEntity.ReadStateId(stateName, workflowId, workflowOwnerId);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * <p>Read  approve state id.</p>
     * @param stateName
     * @param workflowId
     * @param workflowOwnerId
     * @return state id.
     */
    public int ReadApproveStateId(String stateName, int workflowId, int workflowOwnerId) {
        try {
            return terminationEntity.ReadApproveStateId(stateName, workflowId, workflowOwnerId);
        } catch (Exception ex) {
            return 0;
        }
    }

    /**
     * <p>Read  Reject state id.</p>
     * @param stateName
     * @param workflowId
     * @param workflowOwnerId
     * @return state id.
     */
    public int ReadRejectStateId(String stateName, int workflowId, int workflowOwnerId) {
        try {
            return terminationEntity.ReadRejectStateId(stateName, workflowId, workflowOwnerId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public ArrayList<TerminationEntity> readTerminationRequests() {
        try {
            TerminationEntity termEntity = new TerminationEntity();
            return termEntity.readResignRequests();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] loadTerminationRequests() {

        TerminationEntity termEntity = new TerminationEntity();
        ArrayList<TerminationEntity> resignationRequests = this.readTerminationRequests();
        employeeResignationRequest = new Option[resignationRequests.size()];
        for (int i = 0; i < resignationRequests.size(); i++) {
            termEntity = resignationRequests.get(i);
            Option resign = new Option(termEntity.getEmployeeResignPostId(), termEntity.getEmployeeResignPostId());
            employeeResignationRequest[i] = resign;
        }
        return employeeResignationRequest;
    }

    public ArrayList<TerminationEntity> readProcessedTerminationRequests() {
        try {
            TerminationEntity terEnt = new TerminationEntity();
            return terEnt.readProcessedResignRequests();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] loadProcessedTerminationRequests() {
        TerminationEntity terEntity = new TerminationEntity();
        ArrayList<TerminationEntity> terminationProcessedRequests = this.readProcessedTerminationRequests();
        employeeProcessedResignationRequest = new Option[terminationProcessedRequests.size()];
        for (int i = 0; i < terminationProcessedRequests.size(); i++) {
            terEntity = terminationProcessedRequests.get(i);
            Option resign = new Option(terEntity.getEmployeeResignPostId(), terEntity.getEmployeeResignPostId());
            employeeProcessedResignationRequest[i] = resign;
        }
        return employeeProcessedResignationRequest;
    }

    public ArrayList<TerminationEntity> searchEmployeeTerminationRequestById(String id) {

        return terminationEntity.searchEmployeeResignationRequestsById(id);
    }

    public void searchEmpResignationRequestById(String resignId) {
        try {
            this.searchEmployeeTerminationRequestById(resignId);
            this.employeePostId = terminationEntity.getEmployeePostId();
            this.terminationType = terminationEntity.getTerminationType();
            this.resignationDateRequested = terminationEntity.getTerminationDateRequested();
            this.resignationDescription = terminationEntity.getTerminationDescription();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public HashMap readEmployeeTerminationRequestsHistory(String id) {
        try {
            ResultSet _rs = terminationEntity.readEmployeeTerminationRequestsHistory(id);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("terEmpRequestID", ocrs.getString("EMP_ID"));
                data.put("terRequestType", ocrs.getString("TERMINATION_TYPE_ID"));
                data.put("terRequestDate", ocrs.getString("DATEREQUESTED"));
                data.put("terTerminationDate", ocrs.getString("DATETERMINATION"));
                data.put("terRequestDescription", ocrs.getString("DESCRIPTION"));
                data.put("terrequestStatus", ocrs.getInt("STATE"));
                data.put("terRequestId", ocrs.getString("TERMINATION_ID"));
                data.put("groupSetting", ocrs.getString("GROUP_SETTING"));
                data.put("terminationTypeSelected", ocrs.getString("TERMINATIONTYPE"));
                data.put("commentStatus", ocrs.getString("COMMENT_STATUS"));
                data.put("finalCommentStatus", ocrs.getString("FINAL_COMMENT_STATUS"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("terEmpRequestID", "");
                dataNull.put("terRequestType", "");
                dataNull.put("terRequestDate", "");
                dataNull.put("terRequestDescription", "");
                dataNull.put("terrequestStatus", 0);
                dataNull.put("terRequestId", "");
                dataNull.put("groupSetting", "");
                dataNull.put("terminationTypeSelected", "");
                dataNull.put("commentStatus", "0");
                dataNull.put("finalCommentStatus", "0");
                return dataNull;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> ReadSupportiveInfo(String requestId) {
        try {
            ArrayList<HashMap> _list = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadSupportiveInfo(requestId);
            while (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("docId", ocrs.getString("DOCUMENT_ID"));
                data.put("docName", ocrs.getString("DOCUMENT_ATTACHED_NAME"));
                data.put("docPath", ocrs.getBlob("DOCUMENT_PATH"));
                _list.add(data);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readAttachedDocuments(String docId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.readDocumentsAttached(docId);
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("docId1", ocrs.getString("DOCUMENT_ID"));
                data.put("docName", ocrs.getString("DOCUMENT_ATTACHED_NAME"));
                data.put("docPath", ocrs.getBlob("DOCUMENT_PATH"));
                return data;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * <p>Check for privious request made.</p>
     * @param checkId the id of the employeee.
     * @return 1 if exist else 0.
     */
    public int CheckIDFoundInRequestHistory(String checkId) {
        try {
            return terminationEntity.CheckIDFoundInRequestHistory(checkId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    /**
     * <p>Check for employee id registered.</p>
     * @param checkId the id of the employeee.
     * @return 1 if exist else 0.
     */
    public int CheckEmployeeId(String checkId) {
        try {
            return terminationEntity.CheckEmployeeId(checkId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }
//

    public HashMap readEmployeeTerminationRequest(String id) {
        try {
            ResultSet _rs = terminationEntity.readEmployeeTerminationRequestsHistory(id);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("terEmpRequestID", ocrs.getString("EMP_ID"));
                data.put("terRequestType", ocrs.getString("TERMINATION_TYPE"));
                data.put("terRequestDate", ocrs.getString("DATEREQUESTED"));
                data.put("terTerminationDate", ocrs.getString("DATETERMINATION"));
                data.put("terRequestDescription", ocrs.getString("DESCRIPTION"));
                data.put("terrequestStatus", ocrs.getInt("STATE"));
                data.put("terRequestId", ocrs.getString("TERMINATION_ID"));
                data.put("groupSetting", ocrs.getString("GROUP_SETTING"));
                data.put("terminationTypeSelected", ocrs.getString("TERMINATIONTYPE"));
                data.put("commentStatus", ocrs.getString("COMMENT_STATUS"));
                data.put("finalCommentStatus", ocrs.getString("FINAL_COMMENT_STATUS"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("terEmpRequestID", "");
                dataNull.put("terRequestType", "");
                dataNull.put("terRequestDate", "");
                dataNull.put("terRequestDescription", "");
                dataNull.put("terrequestStatus", 0);
                dataNull.put("terRequestId", "");
                dataNull.put("groupSetting", "");
                dataNull.put("terminationTypeSelected", "");
                dataNull.put("commentStatus", "0");
                dataNull.put("finalCommentStatus", "0");
                return dataNull;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public HashMap readEmployeeTerminationRequestComments(String id) {
        try {
            ResultSet _rs = terminationEntity.readEmployeeResignationRequestsComment(id);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("commentedDate", ocrs.getString("COMMENT_DATE"));
                data.put("commentedBy", ocrs.getString("EMP_ID"));
                data.put("terminationRequestId", ocrs.getString("TERMINATION_ID"));
                data.put("commentDescription", ocrs.getString("EMP_COMMENT"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("commentedDate", "");
                dataNull.put("commentedBy", "");
                dataNull.put("terminationRequestId", "");
                dataNull.put("commentDescription", "");
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap ReadEmployeeTerminationRequestProcessed(String id) {
        try {
            ResultSet _rs = terminationEntity.readEmployeeResignationRequestsProcessed(id);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("processedDate", ocrs.getString("PROCESSED_DATE"));
                data.put("processedBy", ocrs.getString("EMP_ID"));
                data.put("terminationRequestId", ocrs.getString("TERMINATION_ID"));
                data.put("processedDescription", ocrs.getString("EMP_PROCESSED_COMMENT"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("processedDate", "");
                dataNull.put("processedBy", "");
                dataNull.put("terminationRequestId", "");
                dataNull.put("processedDescription", "");
                return dataNull;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap ReadEmployeeTerminationRequestPaymentCenter(String id) {
        try {
            ResultSet _rs = terminationEntity.ReadEmployeeResignationRequestsPymentCenter(id);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("paymentID", ocrs.getInt("PAYMENT_ID"));
                data.put("terminationID", ocrs.getString("TERMINATION_ID"));
                data.put("paymentType", ocrs.getString("PAYMENT_TYPE"));
                data.put("paymentCenter", ocrs.getString("PAYMENT_CENTER"));
                data.put("description", ocrs.getString("DESCRIPTION"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("paymentID", 0);
                dataNull.put("terminationID", 0);
                dataNull.put("paymentType", 0);
                dataNull.put("paymentCenter", 0);
                dataNull.put("description", "");
                return dataNull;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap ReadTerminationDateSetting() {
        try {
            TerminationEntity _rs = null;
            _rs = terminationEntity.ReadTerminationDateSettings();

            if (_rs != null) {
                HashMap data = new HashMap();
                data.put("ddID", _rs.getDateDefferenceId());
                data.put("ddV", _rs.getDateDefference());
                data.put("ddD", _rs.getDateDefferenceDescription());
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("ddID", "");
                dataNull.put("ddV", "");
                dataNull.put("ddD", "");
                return dataNull;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int SearchByStateStatus(String empId, int _state) {
        try {
            if (terminationEntity.SearchState(empId, _state) == 1) {
                this.TerminationID = terminationEntity.getLoadTerminationID();
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int CheckEmployeeTerminationID(String empId) {
        try {
            if (terminationEntity.readEmployeeIDTerminationRequest(empId) != null) {
                return 1;
            } else {
                return 0;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int readResignationDetailsByState(String empId, String _resignState) {

        try {
            terminationEntity.readResignationDetailsByState(empId, _resignState);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int loadEmployeeResignationRequestState(String empId, String _resignState) {
        try {
            this.readResignationDetailsByState(empId, _resignState);
            this.empResignId = terminationEntity.getEmpResignId();
            this.empStatetype = terminationEntity.getEmpStatetype();
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int commentTerminationRequest(String commentDate, String comment, String employeeId, String terminationID) {
        try {
            TerminationEntity terminationComment = new TerminationEntity();
            terminationComment.addComment(commentDate, comment, employeeId, terminationID);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int updateTerminationCommented(String commentedDate, String terminationComment, String commentedBy, String _terminationID) {
        try {
            TerminationEntity _updateTerminationCommeted = new TerminationEntity(commentedDate, terminationComment, commentedBy, _terminationID);
            if (_updateTerminationCommeted.updateTerminationCommented(commentedDate, terminationComment, commentedBy, _terminationID) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int updateTerminationDecision(String approveDate, String employeeId, String approveComment, String terminationID, int terminationState, int paymentCenter, int paymentType, String selPaymentCenterList, String descriptionForPayment) {
        try {
            TerminationEntity _updateTerminationProcessed = new TerminationEntity();
            if (_updateTerminationProcessed.updateTerminationDecision(approveDate, employeeId, approveComment, terminationID, terminationState, paymentCenter, paymentType, selPaymentCenterList, descriptionForPayment) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int ApproveTerminationRequest(String approveDate, String approveComment, String employeeId, String terminationID, int terminationState, int paymentCenter, int paymentType, String selPaymentCenterList, String descriptionForPayment) {
        try {
            TerminationEntity terminationComment = new TerminationEntity();
            if (terminationComment.addApprove(approveDate, approveComment, employeeId, terminationID, terminationState, paymentCenter, paymentType, selPaymentCenterList, descriptionForPayment) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     * This method updates the date defference setting on the database,by recieving the value from the end user.
     * @param val
     * @param val2
     * @param val3
     * @return 1 if the update information is success or 0 if the update information is faild.
     */
    public int UpdateDateDefferenceSetting(String val, String val2, String val3) {
        try {
            TerminationEntity update = new TerminationEntity();
            if (update.UpdateDateDefferenceSetting(val, val2, val3) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int SavePaymentCenterInformation(String paymentCenterName, String reqion, String zone, String woreda, String kebele, String description) {
        try {
            TerminationEntity paymentCenter = new TerminationEntity();
            return paymentCenter.SavePaymentCenterInformation(paymentCenterName, reqion, zone, woreda, kebele, description);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public ArrayList<TerminationEntity> LoadPaymentCenter() {
        try {
            TerminationEntity termEntity = new TerminationEntity();
            return termEntity.ReadPaymentCenter();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] LoadPaymentCenterToSelectOneOption() {

        TerminationEntity termEntity = new TerminationEntity();
        ArrayList<TerminationEntity> resignationRequests = this.LoadPaymentCenter();
        optPaymentCenter = new Option[resignationRequests.size()];
        for (int i = 0; i < resignationRequests.size(); i++) {
            termEntity = resignationRequests.get(i);
            Option resign = new Option(termEntity.getEmployeeResignRequestId(), termEntity.getEmployeeResignPostId());
            optPaymentCenter[i] = resign;
        }
        return optPaymentCenter;
    }

    public ArrayList<SelectItem> ReadTerminationTypes() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadTerminationTypes();
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("TERMINATION_TYPE_ID"), ocrs.getString("TERMINATION_TYPE")));
                } while (ocrs.next());
                paymentCenterList.add(0, new Option(null, "-- Select Termination Type --"));
            } else {
                paymentCenterList.add(0, new Option(null, "No Termination Type Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadRetireTypes() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadRetireTypesToList();
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("TERMINATION_TYPE_ID"), ocrs.getString("TERMINATION_TYPE")));
                } while (ocrs.next());
                paymentCenterList.add(0, new Option(null, "-- Select Termination Type --"));
            } else {
                paymentCenterList.add(0, new Option(null, "No Termination Type Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadTerminationTypesToList() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadTerminationTypes();
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("TERMINATION_TYPE_ID"), ocrs.getString("TERMINATION_TYPE")));
                } while (ocrs.next());
            } else {
                paymentCenterList.add(0, new Option(null, "No Termination Type Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadRetireTypesToList() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadRetireTypesToList();
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("TERMINATION_TYPE_ID"), ocrs.getString("TERMINATION_TYPE")));
                } while (ocrs.next());
            } else {
                paymentCenterList.add(0, new Option(null, "No Termination Type Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadStateListByOwnerGroupId(int ownerGroupId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadStateListByOwnerGroupId(ownerGroupId);
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();

            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("WF_STATE_NAME"), ocrs.getString("WF_STATE_NAME")));
                } while (ocrs.next());
                paymentCenterList.add(0, new Option(null, "-- Select State Transition --"));
            } else {
                paymentCenterList.add(0, new Option(null, "No State Transition Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadRequestsList(String employeeId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadRequestsList(employeeId);
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("REQUEST_ID"), ocrs.getString("TERMINATION_TYPE")));
                } while (ocrs.next());
            } else {
                paymentCenterList.add(0, new Option(null, "No Request Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> ReadRequestsListByOwnerGroup(int ownerGroupId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadRequestsListByOwnerGroup(ownerGroupId);
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("REQUEST_ID"), ocrs.getString("REQUESTER_ID")));
                } while (ocrs.next());
            } else {
                paymentCenterList.add(0, new Option(null, "No Request Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int ReadInitialStateByOwnerGroup(int workflowId, int ownerGroupId) {
        try {
            return terminationEntity.ReadInitialStateByOwnerGroup(workflowId, ownerGroupId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public HashMap ReadRequestsInfo(String requestId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.ReadRequestsInfo(requestId);
            if (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("itemId", ocrs.getString("WF_ITEM_ID"));
                hm.put("stateId", ocrs.getString("WF_STATE_ID"));
                hm.put("stateName", ocrs.getString("WF_STATE_NAME"));
                hm.put("stateProperty", ocrs.getString("PROPERTY"));
                hm.put("ownerId", ocrs.getString("WF_OWNER_GROUP_ID"));
                hm.put("ownerName", ocrs.getString("OWNER_GROUP_NAME"));
                hm.put("workflowId", ocrs.getString("WORKFLOW_ID"));
                hm.put("workflowName", ocrs.getString("WORKFLOW_NAME"));
                hm.put("requesttypeId", ocrs.getString("REQUEST_TYPE"));
                hm.put("requesttypeName", ocrs.getString("TERMINATION_TYPE"));
                hm.put("requesterId", ocrs.getString("REQUESTER_ID"));
                hm.put("description", ocrs.getString("DESCRIPTION"));
                hm.put("dateRequested", ocrs.getString("DATE_REQUEST"));
                hm.put("dateTermination", ocrs.getString("DATE_TERMINATION"));
                return hm;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> LoadPaymentCenterToSelectOneMenu() throws SQLException {
        try {
            ResultSet _rs = terminationEntity.ReadPaymentCenterList();
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("PAYMENT_CENTER_ID"), ocrs.getString("PAYMENT_CENTER_NAME")));
                } while (ocrs.next());
                paymentCenterList.add(0, new Option(null, "-- Select Payment Center --"));
            } else {
                paymentCenterList.add(0, new Option(null, "No Payment Center Found"));
            }
            return paymentCenterList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap ReadPaymentCenterInformation(String val) {
        try {
            ResultSet _rs = terminationEntity.ReadPaymentCenterInformation(val);
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                HashMap data = new HashMap();
                data.put("paymentCenterID", ocrs.getString("PAYMENT_CENTER_ID"));
                data.put("paymentCenterName", ocrs.getString("PAYMENT_CENTER_NAME"));
                data.put("paymentCenterRegion", ocrs.getString("PAYMENT_CENTER_REGION"));
                data.put("paymentCenterZone", ocrs.getString("PAYMENT_CENTER_ZONE"));
                data.put("paymentCenterWoreda", ocrs.getString("PAYMENT_CENTER_WOREDA"));
                data.put("paymentCenterKebele", ocrs.getString("PAYMENT_CENTER_KEBELE"));
                data.put("paymentCenterDescription", ocrs.getString("DESCRIPTION"));
                return data;
            } else {
                HashMap dataNull = new HashMap();
                dataNull.put("paymentCenterID", "");
                dataNull.put("paymentCenterName", "");
                dataNull.put("paymentCenterRegion", "");
                dataNull.put("paymentCenterZone", "");
                dataNull.put("paymentCenterWoreda", "");
                dataNull.put("paymentCenterKebele", "");
                dataNull.put("paymentCenterDescription", "");
                return dataNull;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int UpdatePaymentCenterInformation(int paymentCenterID, String paymentCenteName, String paymentCenterReqion, String paymentZone, String paymentWoreda, String paymentCenterKebele, String paymentCenterDescription) {
        try {
            TerminationEntity update = new TerminationEntity();
            if (update.UpdatePaymentCenterInformation(paymentCenterID, paymentCenteName, paymentCenterReqion, paymentZone, paymentWoreda, paymentCenterKebele, paymentCenterDescription) == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int DeletePaymentCenterInformation(int val) {
        try {
            return terminationEntity.DeletePaymentCenterInformation(val);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     * <p>This method loads the state and state owner group <br/>
     * that is associated with the current workflow.</p>
     * @param wfId-the current workflow selected.
     * @return initial state with ouner of the state.
     */
    public HashMap LoadStateAndOwner(String wfId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = terminationEntity.LoadStateAndOwner(wfId);
            if (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("stateId", ocrs.getString("WF_STATE_ID"));
                hm.put("stateName", ocrs.getString("WF_STATE_NAME"));
                hm.put("ownerId", ocrs.getString("WF_OWNER_GROUP_ID"));
                hm.put("ownerName", ocrs.getString("OWNER_GROUP_NAME"));
                return hm;
            } else {
                return null;
            }

        } catch (Exception ex) {
            return null;
        }
    }

    public String InsertedBy() {
        return sessionBean1.getEmployee_id().toString();
    }

    public String InsertedDate() {
        return StringDateManipulation.toDayInEc();
    }

    public String UpdatedBy() {
        return sessionBean1.getEmployee_id().toString();
    }

    public String UpdatedDate() {
        return StringDateManipulation.toDayInEc();
    }
}
