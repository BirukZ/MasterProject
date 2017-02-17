/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import com.sun.webui.jsf.model.Option;
import entity.terminationEntity.TransferEntity;
import fphrms.Termination.TransferApprovePage.FileAttachmentModel;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DPClone
 */
public class TransferManager {

    private TransferEntity transferEntity = new TransferEntity();
    String userName = "";

    public TransferManager() {
    }



    public ArrayList<SelectItem> readFromDpartment() {
        try {
            OracleCachedRowSet _rs = transferEntity.readAvailableDepartment();
            ArrayList<SelectItem> _fromList = new ArrayList<SelectItem>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                do {
                    _fromList.add(new Option(ocrs.getString("DEPT_ID"), ocrs.getString("DEP_DESCRIPTION")));
                } while (ocrs.next());
                _fromList.add(0, new Option(null, "-- From Department --"));
            } else {
                _fromList.add(0, new Option(null, "No From Department Found"));
            }
            return _fromList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> readToDpartment() {
        try {
            OracleCachedRowSet _rs = transferEntity.readAvailableDepartment();
            ArrayList<SelectItem> _fromList = new ArrayList<SelectItem>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
         //   _rs.close();
            if (ocrs.next()) {
                do {
                    _fromList.add(new Option(ocrs.getString("DEPT_ID"), ocrs.getString("DEP_DESCRIPTION")));
                } while (ocrs.next());
                _fromList.add(0, new Option(null, "-- To Department --"));
            } else {
                _fromList.add(0, new Option(null, "No To Department Found"));
            }
            return _fromList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

        public ArrayList<SelectItem> readTransferTypeNew() {

        ArrayList<SelectItem> repitionList = new ArrayList<SelectItem>();
        repitionList.add(new Option(-1, "--SELECT REPITITIONN--"));
        repitionList.add(new Option(1, "Transfer"));
        repitionList.add(new Option(2, "Acting"));
        repitionList.add(new Option(3, "Promotion"));
        repitionList.add(new Option(4, "Relocation"));
        repitionList.add(new Option(5, "Hardship area"));

        return repitionList;

    }

            public String getJobName(String jobCode)
            {
                try{
                String jobName=null;
               ResultSet _rs= transferEntity.getJobName(jobCode);
              while (_rs.next())
            {

             jobName=_rs.getString("job_name");

                    }
              return jobName;
                }        catch (Exception ex) {
                         ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
               return null;
                }
            }



    public ArrayList<SelectItem> readTransferType() {
        try {
            ResultSet _rs = transferEntity.readTransferType();
            ArrayList<SelectItem> _fromList = new ArrayList<SelectItem>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
         //   ocrs.populate(_rs);
         //   _rs.close();
            if (_rs.next()) {
                do {
                    _fromList.add(new Option(_rs.getString("TRANSFER_TYPE_ID"), _rs.getString("TRANSFER_TYPE")));
                } while (_rs.next());
                _fromList.add(0, new Option(null, "-- Select Transfer Type --"));
            } else {
                _fromList.add(0, new Option(null, "No Transfer Type Found"));
            }
            return _fromList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String readDepartmentDescrption(String empId) {
        try {
            return transferEntity.readDepartmentDescrption(empId);
        } catch (Exception ex) {
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
            return transferEntity.CheckIDFoundInRequestHistory(checkId);
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
            return transferEntity.CheckEmployeeId(checkId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public ArrayList<SelectItem> readRequestsList(String employeeId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = transferEntity.readRequestsList(employeeId);
            ArrayList<SelectItem> paymentCenterList = new ArrayList<SelectItem>();
            if (ocrs.next()) {
                do {
                    paymentCenterList.add(new Option(ocrs.getString("TRANSFER_ID"), ocrs.getString("TRANSFER_TYPE")));
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


    public HashMap ReadRequestsInfo(String requestId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = transferEntity.ReadRequestsInfo(requestId);
            if (ocrs.next()) {
                HashMap hm = new HashMap();//
                hm.put("requesttypeId", ocrs.getString("TRANSFER_TYPE"));
                hm.put("requesttypeName", ocrs.getString("TRANSFER_TYPE"));
                hm.put("requesterId", ocrs.getString("REQUESTER_ID"));
                hm.put("description", ocrs.getString("DESCRIPTION"));
                hm.put("dateRequested", ocrs.getString("DATE_REQUEST"));
                hm.put("fromDepartment", ocrs.getString("TRANSFER_FROM"));
                hm.put("toDepartment", ocrs.getString("TRANSFER_TO"));
                hm.put("transferProcessType", ocrs.getString("TRANSFER_PROCESS_TYPE"));
                hm.put("status", ocrs.getString("STATUS"));
                hm.put("newPosition", ocrs.getString("NEW_POSITION"));
                hm.put("newRank", ocrs.getString("NEW_RANKID"));
                hm.put("newPayGrade", ocrs.getString("NEW_PAYGRADE"));
                hm.put("newSalary", ocrs.getString("NEW_SALARY"));
                hm.put("salaryChange", ocrs.getString("SALARY_CHANGED"));
                hm.put("effectiveFrom", ocrs.getString("EFFECTIVE_FROM"));
                hm.put("promoted", ocrs.getString("PROMOTED"));
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

    public ArrayList<HashMap> ReadSupportiveInfo(String requestId) {
        try {
            ArrayList<HashMap> _list = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = transferEntity.ReadSupportiveInfo(requestId);
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
            ocrs = transferEntity.readDocumentsAttached(docId);
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

    public FileAttachmentModel setValues(int requestId) {

         FileAttachmentModel fileUpLoad = new FileAttachmentModel();
        try {
            ResultSet _rs = transferEntity.selectDocumentAttrbutie(requestId);
            if (_rs.next()) {


                fileUpLoad.setFileID(_rs.getInt("DOCUMENT_ID"));
                fileUpLoad.setFileName(_rs.getString("DOCUMENT_ATTACHED_NAME"));
                fileUpLoad.setFileType(_rs.getString("DOCUMENT_FORMAT"));
                fileUpLoad.setExtention(_rs.getString("DOCUMENT_FORMAT"));
                fileUpLoad.setRequestID(_rs.getInt("REQUEST_ID"));
                fileUpLoad.setAttachedFile(_rs.getBytes("DOCUMENT_PATH"));
                return fileUpLoad;
            }
            _rs.close();
            return fileUpLoad;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public void updateRequest(int committeeId, int requestId) {
       // transferEntity.updateRequest(committeeId,requestId);
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
    public int updateTerminationRequest(String requestId, String requestTypeId, String requestedDate, String transferFrom, String transferTo, String description, String processType, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        try {

            if (transferEntity.updateTerminationRequest(requestId, requestTypeId, requestedDate, transferFrom, transferTo, description, processType, supportiveInfo, deletedFile) == 1) {
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
    
    
        public int updateTerminationRequest(HashMap RequestInfo, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        try {

            if (transferEntity.updateTerminationRequest(RequestInfo, supportiveInfo, deletedFile) == 1) 
            {
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

//     public int UpdateTransferRequest(HashMap RequestInfo)
//        {
//              try {
//
//            if (transferEntity.UpdateTransferRequest(RequestInfo) == 1)
//            {
//                return 1;
//            } else {
//                return 0;
//            }
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return 0;
//        }
//
//        }



    public String readEmployeeIDByRequestID(String requestId) {
        try {
            return transferEntity.readEmployeeIDByRequestID(requestId);
        } catch (Exception ex) {
            return null;
        }
    }

    public String readUserID(String empId) {
        try {
            return transferEntity.readUserID(empId);
        } catch (Exception ex) {
            return null;
        }
    }
    public int updateEmployeeStatus(String employeeId, String employeeStatus) {
        try {
            return transferEntity.updateEmployeeStatus(employeeId, employeeStatus);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int postNewTransferRequest(HashMap RequestInfo,Set<HashMap> supportiveInfo) {
       try {
            if (transferEntity.addNewTransfer(RequestInfo,supportiveInfo) == 1) {
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
     //<editor-fold >
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    //</editor-fold >

}
