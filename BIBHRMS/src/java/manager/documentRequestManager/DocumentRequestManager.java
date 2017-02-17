/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.documentRequestManager;

import com.sun.webui.jsf.model.Option;
import entity.documentEntity.DocumentRequestEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class DocumentRequestManager {

    public DocumentRequestManager() {
    }
    DocumentRequestEntity documentRequestEntity = new DocumentRequestEntity();
    DocumentRequestModel documentRequestModel = new DocumentRequestModel();
    String userName;
    String loggedInEmployeeId;

    public ArrayList<Option> getDocumentCatagories() {
        ArrayList<Option> terminationCatagories = new ArrayList<Option>();
        terminationCatagories.add(new Option("-1", "Select Catagory"));
        terminationCatagories.add(new Option("1", "Work Experience"));
        terminationCatagories.add(new Option("2", "Current Status"));
        terminationCatagories.add(new Option("3", "Guarantee"));
        return terminationCatagories;
    }

    public ArrayList<Option> getDocumentReturn() {
        ArrayList<Option> docReturn = new ArrayList<Option>();
        docReturn.add(new Option("1", "Document Returned"));
        docReturn.add(new Option("2", "Document Not Returned"));
        return docReturn;
    }

    public boolean saveTerminationRequestInformation(String requesterId,
            String documentCatagory, String description, String reason,
            String appliedDate, String issueDate, String docReferenceNumber,
            String reqType, String reqOrgId, String reqOrgName, String reqOrgDept,
            String reqOrdAddress, String reqOrgLetterNo, String reqOrgLetterDate) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        documentRequestModel = new DocumentRequestModel(requesterId, documentCatagory,
                description, reason, appliedDate, issueDate, docReferenceNumber,
                DocumentApproveManager.INITIAL_STATE_DOCUMENTREQUEST, userName,
                recorededDateAndTime, reqType, reqOrgId, reqOrgName, reqOrgDept,
                reqOrdAddress, reqOrgLetterNo, reqOrgLetterDate);
        try {
            return documentRequestEntity.insertDocumentRequest(documentRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateTerminationRequestInformation(int documentRequestId,
            String requesterId, String documentCatagory, String description,
            String reason, String appliedDate, String issueDate, String docReferenceNumber,
            String reqType, String reqOrgId, String reqOrgName, String reqOrgDept,
            String reqOrdAddress, String reqOrgLetterNo, String reqOrgLetterDate) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        documentRequestModel = new DocumentRequestModel(documentRequestId,
                requesterId, documentCatagory, description, reason, appliedDate,
                issueDate, docReferenceNumber, DocumentApproveManager.INITIAL_STATE_DOCUMENTREQUEST,
                userName, recorededDateAndTime, reqType, reqOrgId,
                reqOrgName, reqOrgDept, reqOrdAddress, reqOrgLetterNo, reqOrgLetterDate);
        try {
            return documentRequestEntity.updateDocumentRequest(documentRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean deleteDocumentrequest(int documentRequestId) {
        try {
            return documentRequestEntity.deleteDocumentRequest(documentRequestModel);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public DocumentRequestModel getDocumentRequest(int documentRequestId) {
        documentRequestModel = new DocumentRequestModel();
        try {
            ResultSet _rs = documentRequestEntity.selectDocumentRequest(documentRequestId);
            if (_rs.next()) {
                documentRequestModel.setDocumentRequestId(documentRequestId);
                documentRequestModel.setDescription(_rs.getString("DESCRIPTION"));
                documentRequestModel.setRequesterId(_rs.getString("REQUESTER_ID"));
                documentRequestModel.setDocReferenceNumber(_rs.getString("DOC_REFERENCE_NUMBER"));
                documentRequestModel.setDocumentCatagory(_rs.getString("DOCUMENT_CATAGORY"));
                documentRequestModel.setAppliedDate(_rs.getString("APPLIED_DATE"));
                documentRequestModel.setIssueDate(_rs.getString("ISSUE_DATE"));
                documentRequestModel.setReason(_rs.getString("REASON"));
                documentRequestModel.setStatus(_rs.getString("STATUS"));
                documentRequestModel.setUserName(_rs.getString("USER_NAME"));
                documentRequestModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                documentRequestModel.setReq_type(_rs.getString("REQUESTER_TYPE"));
                documentRequestModel.setReqOrgId(_rs.getString("REQ_ORG_ID"));
                documentRequestModel.setReqOrgName(_rs.getString("REQ_ORG_NAME"));
                documentRequestModel.setReqOrgDept(_rs.getString("REQ_ORG_DEP"));
                documentRequestModel.setReqOrgAddress(_rs.getString("REQ_ORG_LETTER_PURPOSE"));
                documentRequestModel.setReqOrgLetterNo(_rs.getString("REQ_ORG_LETTER_NO"));
                documentRequestModel.setReqOrgLetterDate(_rs.getString("REQ_ORG_LETTER_DATE"));
            } else {
                documentRequestModel.setDocumentRequestId(-1);
            }
            _rs.close();
            return documentRequestModel;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<Option> geMyPendingDocumentRequests() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            _rs = documentRequestEntity.selectMyPendingDocumentRequests(loggedInEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("DOCUMENT_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("STATUS");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + status;
                    String OptionDescriptiom = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDescriptiom);
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

    public ArrayList<Option> geMyDocumentRequestHistory() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            _rs = documentRequestEntity.selectMyDocumentRequestHistory(loggedInEmployeeId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int terminationRequestId = _rs.getInt("DOCUMENT_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String status = _rs.getString("STATUS");
                    String docCategory = _rs.getString("DOCUMENT_CATAGORY");
                    String optionId = Integer.toString(terminationRequestId) + "--" + requesterId + "--" + status;
                    String OptionDescriptiom = requesterId + " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDescriptiom);
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

    public String geEmpDocumentRequestHistory(String reqterId) {
        ResultSet _rs = null;
        String docCategory = null;
        String docReturnStatus = null;
        try {
            _rs = documentRequestEntity.selectEmpDocumentRequestHistory(reqterId);
            if (_rs != null) {
                while (_rs.next()) {
                    docCategory = _rs.getString("DOCUMENT_CATAGORY");
                    docReturnStatus = _rs.getString("GUARANTEE_DOC_STATUS");
                }
            }
            return docCategory + "/" + docReturnStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DocumentRequestEntity getDocumentRequestEntity() {
        return documentRequestEntity;
    }

    public void setDocumentRequestEntity(DocumentRequestEntity documentRequestEntity) {
        this.documentRequestEntity = documentRequestEntity;
    }

    public DocumentRequestModel getDocumentRequestModel() {
        return documentRequestModel;
    }

    public void setDocumentRequestModel(DocumentRequestModel documentRequestModel) {
        this.documentRequestModel = documentRequestModel;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public static class DocumentRequestModel implements Serializable {

        int documentRequestId;//   DOCUMENT_REQUEST_ID
        String requesterId;//REQUESTER_ID
        String documentCatagory;//DOCUMENT_CATAGORY
        String description;//DESCRIPTION
        String reason;//REASON
        String appliedDate;//APPLIED_DATE
        String issueDate;//ISSUE_DATE
        String docReferenceNumber;//DOC_REFERENCE_NUMBER
        String status;//STATUS
        String userName;//USER_NAME
        String timeStamp;//TIME_STAMP
        private String req_type;
        private String reqOrgId;//Id of external organization requesting document
        private String reqOrgName;//Name of external organization requesting document
        private String reqOrgDept;//Department of external organization requesting document
        private String reqOrgAddress;//Department of external organization requesting document
        private String reqOrgLetterNo = null;//Address of external organization requesting document
        private //Address of external organization requesting document
                String reqOrgLetterDate = null;

        public DocumentRequestModel() {
        }

        public DocumentRequestModel(String requesterId, String documentCatagory,
                String description, String reason, String appliedDate,
                String issueDate, String docReferenceNumber, String status,
                String userName, String timeStamp, String reqType, String reqOrgId,
                String reqOrgName, String reqOrgDept, String reqOrdAddress,
                String reqOrgLetterNo, String reqOrgLetterDate) {
            this.requesterId = requesterId;
            this.documentCatagory = documentCatagory;
            this.description = description;
            this.reason = reason;
            this.appliedDate = appliedDate;
            this.issueDate = issueDate;
            this.docReferenceNumber = docReferenceNumber;
            this.status = status;
            this.userName = userName;
            this.timeStamp = timeStamp;
            this.req_type = reqType;
            this.reqOrgId = reqOrgId;
            this.reqOrgName = reqOrgName;
            this.reqOrgDept = reqOrgDept;
            this.reqOrgAddress = reqOrdAddress;
            this.reqOrgLetterNo = reqOrgLetterNo;
            this.reqOrgLetterDate = reqOrgLetterDate;
        }

        public DocumentRequestModel(int documentRequestId, String requesterId,
                String documentCatagory, String description, String reason,
                String appliedDate, String issueDate, String docReferenceNumber,
                String status, String userName, String timeStamp, String reqType, String reqOrgId,
                String reqOrgName, String reqOrgDept, String reqOrdAddress,
                String reqOrgLetterNo, String reqOrgLetterDate) {
            this(requesterId, documentCatagory, description, reason, appliedDate,
                    issueDate, docReferenceNumber, status, userName, timeStamp,
                    reqType, reqOrgId, reqOrgName, reqOrgDept, reqOrdAddress,
                    reqOrgLetterNo, reqOrgLetterDate);
            this.documentRequestId = documentRequestId;
        }

        public String getAppliedDate() {
            return appliedDate;
        }

        public void setAppliedDate(String appliedDate) {
            this.appliedDate = appliedDate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDocReferenceNumber() {
            return docReferenceNumber;
        }

        public void setDocReferenceNumber(String docReferenceNumber) {
            this.docReferenceNumber = docReferenceNumber;
        }

        public String getDocumentCatagory() {
            return documentCatagory;
        }

        public void setDocumentCatagory(String documentCatagory) {
            this.documentCatagory = documentCatagory;
        }

        public int getDocumentRequestId() {
            return documentRequestId;
        }

        public void setDocumentRequestId(int documentRequestId) {
            this.documentRequestId = documentRequestId;
        }

        public String getIssueDate() {
            return issueDate;
        }

        public void setIssueDate(String issueDate) {
            this.issueDate = issueDate;
        }

        public String getReason() {
            return reason;
        }

        public void setReason(String reason) {
            this.reason = reason;
        }

        public String getRequesterId() {
            return requesterId;
        }

        public void setRequesterId(String requesterId) {
            this.requesterId = requesterId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
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

        /**
         * @return the reqOrgId
         */
        public String getReqOrgId() {
            return reqOrgId;
        }

        /**
         * @param reqOrgId the reqOrgId to set
         */
        public void setReqOrgId(String reqOrgId) {
            this.reqOrgId = reqOrgId;
        }

        /**
         * @return the reqOrgName
         */
        public String getReqOrgName() {
            return reqOrgName;
        }

        /**
         * @param reqOrgName the reqOrgName to set
         */
        public void setReqOrgName(String reqOrgName) {
            this.reqOrgName = reqOrgName;
        }

        /**
         * @return the reqOrgDept
         */
        public String getReqOrgDept() {
            return reqOrgDept;
        }

        /**
         * @param reqOrgDept the reqOrgDept to set
         */
        public void setReqOrgDept(String reqOrgDept) {
            this.reqOrgDept = reqOrgDept;
        }

        /**
         * @return the req_type
         */
        public //TIME_STAMP
                String getReq_type() {
            return req_type;
        }

        /**
         * @param req_type the req_type to set
         */
        public void setReq_type(String req_type) {
            this.req_type = req_type;
        }

        /**
         * @return the reqOrgAddress
         */
        public String getReqOrgAddress() {
            return reqOrgAddress;
        }

        /**
         * @param reqOrgAddress the reqOrgAddress to set
         */
        public void setReqOrgAddress(String reqOrgAddress) {
            this.reqOrgAddress = reqOrgAddress;
        }

        /**
         * @return the reqOrgLetterNo
         */
        public String getReqOrgLetterNo() {
            return reqOrgLetterNo;
        }

        /**
         * @param reqOrgLetterNo the reqOrgLetterNo to set
         */
        public void setReqOrgLetterNo(String reqOrgLetterNo) {
            this.reqOrgLetterNo = reqOrgLetterNo;
        }

        /**
         * @return the reqOrgLetterDate
         */
        public String getReqOrgLetterDate() {
            return reqOrgLetterDate;
        }

        /**
         * @param reqOrgLetterDate the reqOrgLetterDate to set
         */
        public void setReqOrgLetterDate(String reqOrgLetterDate) {
            this.reqOrgLetterDate = reqOrgLetterDate;
        }
    }
}
