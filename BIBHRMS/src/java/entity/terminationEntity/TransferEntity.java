/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

import connectionProvider.ConnectionManager;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class TransferEntity extends ConnectionManager {

    private byte[] relativePhoto = null;

  

    public byte[] getRelativePhoto() {
        return relativePhoto;
    }

    public ResultSet selectDocumentAttrbutie(int requestId) {
         String qry = null;


        qry =" SELECT * FROM HR_TRANSFER_ATTACHMENT WHERE REQUEST_ID ='" + requestId +"'";
       

        try {
           _con = getConnection();
            _ps = _con.prepareStatement( qry);
           _rs =  _ps.executeQuery();
           OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


      public ResultSet getJobName(String jobCode) {
         String qry = null;


        qry =" select job_name from hr_lu_job_type where job_code ='" + jobCode +"'";


        try {
           _con = getConnection();
            _ps = _con.prepareStatement( qry);
           _rs =  _ps.executeQuery();
           OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    /**
     *
     * @param relativePhoto
     */
    public void setRelativePhoto(byte[] relativePhoto) {
        this.relativePhoto = relativePhoto;
    }

    public TransferEntity() {
    }
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

    /**
     *
     * @param file
     * @return
     */
    public static byte[] extractByteArray(File file) {
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {

            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);

        } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
//Logger.getLogger(EimsUtility.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return byteFile;
    }

    public OracleCachedRowSet readAvailableDepartment() {
        String _select = "SELECT DEPT_ID,DEP_DESCRIPTION,REQUIRE_CLEARANCE FROM TBL_DEPT_BUNNA";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param empId
     * @return
     */
    public String readDepartmentDescrption(String empId) 
        
        {

        ResultSet rs = null;
        String departmentDescrption;
           try {
            _con = getConnection();
            _ps = _con.prepareStatement("SELECT DEP.DEP_DESCRIPTION,DEP.DEPT_ID,EMP.EMP_ID FROM" +
                    " HR_EMPLOYEE_INFO EMP INNER JOIN " +
                    " TBL_DEPT_BUNNA DEP ON EMP.DEPARTMENT_ID=DEP.DEPT_ID" +
                    "  WHERE EMP.EMP_ID='" + empId + "'");
            rs = _ps.executeQuery();
            rs.next();
            departmentDescrption = rs.getString("DEP_DESCRIPTION")+"--"+ rs.getString("DEPT_ID");
            rs.close();
            //closePooledConnections(_con);
            return departmentDescrption;
        } catch (Exception ex)
        {
            ex.printStackTrace();
            return null;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }


    }

    public OracleCachedRowSet readTransferType() {
        String _select = "SELECT TRANSFER_TYPE_ID,TRANSFER_TYPE FROM HR_TRANSFER_TYPES";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
           // _rs.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param checkId
     * @return
     */
    public int CheckIDFoundInRequestHistory(String checkId) {
        String _select = "SELECT DISTINCT REQUESTER_ID FROM HR_TRANSFER_REQUESTS WHERE REQUESTER_ID='" + checkId + "'";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            int row = _ps.executeUpdate();
            _ps.close();
            //closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            return 0;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param checkId
     * @return
     */
    public int CheckEmployeeId(String checkId) {
        String _select = "SELECT DISTINCT EMP_ID FROM HR_EMPLOYEE_INFO WHERE EMP_ID='" + checkId + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            int row = _ps.executeUpdate();
            _ps.close();
            //closePooledConnections(_con);
            return row;
        } catch (Exception ex) {
            return 0;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param employeeId
     * @return
     */
    public OracleCachedRowSet readRequestsList(String employeeId) {
        String _select = "SELECT " +
                "       RE.TRANSFER_ID," +
                "       RT.TRANSFER_TYPE" +
                "       FROM HR_TRANSFER_REQUESTS RE" +
                "       INNER JOIN HR_TRANSFER_TYPES RT ON RT.TRANSFER_TYPE_ID=RE.TRANSFER_TYPE WHERE RE.REQUESTER_ID='" + employeeId + "' AND RE.STATUS='50'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }


    public OracleCachedRowSet ReadRequestsInfo(String requestId) {
        String _select = " SELECT " +
                "       TRANSFER_TYPE," +
                "       REQUESTER_ID," +
                "       TRANSFER_TYPE," +
                "       DESCRIPTION," +
                "       DATE_REQUEST, " +
                "       TRANSFER_FROM," +
                "       TRANSFER_TO," +
                "       TRANSFER_PROCESS_TYPE," +
                "       STATUS," +
                "       NEW_POSITION," +
                "       NEW_RANKID," +
                "       NEW_PAYGRADE," +
                "       NEW_SALARY," +
                "       SALARY_CHANGED," +
                "       EFFECTIVE_FROM," +
                "       PROMOTED" +
                "       FROM  HR_TRANSFER_REQUESTS" +
                "       WHERE TRANSFER_ID='" + requestId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param requestId
     * @return
     */
    public OracleCachedRowSet ReadSupportiveInfo(String requestId) {
        String _select = "SELECT DOCUMENT_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH FROM HR_TRANSFER_ATTACHMENT WHERE REQUEST_ID='" + requestId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     *
     * @param docId
     * @return
     */
    public OracleCachedRowSet readDocumentsAttached(String docId)
    {
        String _select = "SELECT  DOCUMENT_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH FROM HR_TRANSFER_ATTACHMENT WHERE DOCUMENT_ID='" + docId + "'";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            //closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int updateRequest(int committeeId, int requestId) {

        String _update = "UPDATE HR_TRANSFER_REQUESTS SET committee_Id='" + committeeId + "' WHERE TRANSFER_ID='" + requestId + "'";


        int rowAffect = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int updateTerminationRequest(HashMap RequestInfo, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        String updateRequest = "UPDATE HR_TRANSFER_REQUESTS SET TRANSFER_TYPE=?, DATE_REQUEST=?, TRANSFER_FROM=?, TRANSFER_TO=?, DESCRIPTION=?, TRANSFER_PROCESS_TYPE=?,NEW_POSITION=?," +
                     "NEW_RANKID=?,NEW_PAYGRADE=?,NEW_SALARY=?,SALARY_CHANGED=?,EFFECTIVE_FROM=?   WHERE TRANSFER_ID =?";
        String updateAttachedFile = "INSERT INTO HR_TRANSFER_ATTACHMENT (REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH) VALUES(?, ?, ?)";
        String deleteAttachedFile = "DELETE FROM HR_TRANSFER_ATTACHMENT  WHERE DOCUMENT_ID =?";

        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int rowAffected = 0;
        Savepoint spOne = null;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps1 = _con.prepareStatement(updateRequest);
            _ps1.setString(1, RequestInfo.get("transferType").toString());
            _ps1.setString(2, RequestInfo.get("dateRequest").toString());
            _ps1.setString(3, RequestInfo.get("fromDepartment").toString());
            _ps1.setString(4, RequestInfo.get("toDepartment").toString());
            _ps1.setString(5, RequestInfo.get("description").toString());
            _ps1.setString(6, RequestInfo.get("transferProcessType").toString());
            _ps1.setString(7, RequestInfo.get("newPosition").toString());
            _ps1.setString(8, RequestInfo.get("newRankId").toString());
            _ps1.setString(9, RequestInfo.get("newPayGrade").toString());
            _ps1.setString(10, RequestInfo.get("newSalary").toString());
            _ps1.setString(11, RequestInfo.get("salaryChanged").toString());
            _ps1.setString(12, RequestInfo.get("effectiveFrom").toString());
            _ps1.setString(13, RequestInfo.get("transferRequestId").toString());
           
            row1 = _ps1.executeUpdate();
            if (row1 == 1) {
                if (supportiveInfo.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    for (HashMap hm : supportiveInfo) {//loop over the attached file
                        try {
                            setRelativePhoto(extractByteArray(new File(hm.get("attachedPath").toString())));//extract the attached image file to byte of array information
                        } catch (Exception ex) {
                        }
                        _ps2 = _con.prepareStatement(updateAttachedFile);
                        _ps2.setString(1, RequestInfo.get("transferRequestId").toString());
                        _ps2.setString(2, hm.get("attachedName").toString());
                        _ps2.setBytes(3, getRelativePhoto());
                        row2 = _ps2.executeUpdate();
                    }
                } else {
                    row2 = 1;
                }
                if (deletedFile.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    for (HashMap hm : deletedFile) {//loop over the attached file
                        _ps3 = _con.prepareStatement(deleteAttachedFile);
                        _ps3.setInt(1, Integer.valueOf(hm.get("deleted").toString()));
                        row3 = _ps3.executeUpdate();
                    }
                } else {
                    row3 = 1;
                }
                if (row2 == 1 && row3 == 1) {
                    _con.commit();
                    rowAffected = 1;
                } else {
                    _con.rollback(spOne);
                    rowAffected = 0;
                }

            } else {
                _con.rollback(spOne);
                rowAffected = 0;
            }

            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        } finally {
            try {
                _ps1.close()  ;
                _ps2.close()  ;
                _ps3.close()  ;
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param requestId
     * @param requestTypeId
     * @param terminationDate
     * @param description
     * @param supportiveInfo
     * @param deletedFile
     * @return
     */
    public int updateTerminationRequest(String requestId, String requestTypeId, String requestedDate, String transferFrom, String transferTo, String description, String processType, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        String updateRequest = "UPDATE HR_TRANSFER_REQUESTS SET TRANSFER_TYPE=?, DATE_REQUEST=?, TRANSFER_FROM=?, TRANSFER_TO=?, DESCRIPTION=?, TRANSFER_PROCESS_TYPE=?   WHERE TRANSFER_ID =?";
        String updateAttachedFile = "INSERT INTO HR_TRANSFER_ATTACHMENT (REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH) VALUES(?, ?, ?)";
        String deleteAttachedFile = "DELETE FROM HR_TRANSFER_ATTACHMENT  WHERE DOCUMENT_ID =?";

        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int rowAffected = 0;
        Savepoint spOne = null;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps1 = _con.prepareStatement(updateRequest);
            _ps1.setInt(1, Integer.valueOf(requestTypeId));
            _ps1.setString(2, requestedDate);
            _ps1.setString(3, transferFrom);
            _ps1.setString(4, transferTo);
            _ps1.setString(5, description);
            _ps1.setString(6, processType);
            _ps1.setInt(7, Integer.valueOf(requestId));
            row1 = _ps1.executeUpdate();
            if (row1 == 1) {
                if (supportiveInfo.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    for (HashMap hm : supportiveInfo) {//loop over the attached file
                        try {
                            setRelativePhoto(extractByteArray(new File(hm.get("attachedPath").toString())));//extract the attached image file to byte of array information
                        } catch (Exception ex) {
                        }
                        _ps2 = _con.prepareStatement(updateAttachedFile);
                        _ps2.setInt(1, Integer.valueOf(requestId));
                        _ps2.setString(2, hm.get("attachedName").toString());
                        _ps2.setBytes(3, getRelativePhoto());
                        row2 = _ps2.executeUpdate();
                    }
                } else {
                    row2 = 1;
                }
                if (deletedFile.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    for (HashMap hm : deletedFile) {//loop over the attached file
                        _ps3 = _con.prepareStatement(deleteAttachedFile);
                        _ps3.setInt(1, Integer.valueOf(hm.get("deleted").toString()));
                        row3 = _ps3.executeUpdate();
                    }
                } else {
                    row3 = 1;
                }
                if (row2 == 1 && row3 == 1) {
                    _con.commit();
                    rowAffected = 1;
                } else {
                    _con.rollback(spOne);
                    rowAffected = 0;
                }

            } else {
                _con.rollback(spOne);
                rowAffected = 0;
            }

            return rowAffected;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        } finally {
            try {
                _ps1.close()  ;
                _ps2.close()  ;
                _ps3.close()  ;
                releaseResources();
            } catch (Exception ex) {
            }
        }

    }




    public String readEmployeeIDByRequestID(String requestId) {
        PreparedStatement ps = null;

        ResultSet rs = null;
        String requestid = "";
        try {
            _con = getConnection();
            ps = _con.prepareStatement("SELECT DISTINCT REQUESTER_ID FROM HR_TRANSFER_REQUESTS WHERE TRANSFER_ID='" + requestId + "'");
            rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            if (ocrs.next()) {
                requestid = ocrs.getString("REQUESTER_ID");
            }
            rs.close();
            ps.close();
            //closePooledConnections(_con);
            return requestid;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }


    public String readUserID(String empId) {
        PreparedStatement ps = null;
        String userId = null;
        try {
            _con = getConnection();
            ps = _con.prepareStatement("SELECT DISTINCT USER_ID FROM BIB.TBL_USERS  WHERE EMPLOYEE_ID='" + empId + "'");
            _rs = ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            if (ocrs.next()) {
                userId = ocrs.getString("USER_ID");
            }
            _rs.close();
            ps.close();
            return userId;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }



    public int updateEmployeeStatus(String employeeId, String employeeStatus) {
        String _update = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + employeeStatus + "' WHERE EMP_ID='" + employeeId + "'";


        int rowAffect = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            //closePooledConnections(_con);
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }



    public int addNewTransfer(HashMap requestInfo, Set<HashMap> supportiveInfo) throws SQLException {

        String inseretIntoRequest = "INSERT INTO HR_TRANSFER_REQUESTS (TRANSFER_ID,REQUESTER_ID, TRANSFER_TYPE, DATE_REQUEST,TRANSFER_FROM,TRANSFER_TO,DESCRIPTION,TRANSFER_PROCESS_TYPE,STATUS,NEW_POSITION,NEW_RANKID,NEW_PAYGRADE,NEW_SALARY,SALARY_CHANGED,EFFECTIVE_FROM,PROMOTED)" +
                " VALUES(HR_TRANSFER_REQ_SEQ.NEXTVAL,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?) ";
        String selectLastRowInsertedRequest = "SELECT TRANSFER_ID FROM HR_TRANSFER_REQUESTS WHERE TRANSFER_ID=(SELECT max(TRANSFER_ID) FROM HR_TRANSFER_REQUESTS)";
        String inseretAttachement = "INSERT INTO HR_TRANSFER_ATTACHMENT (DOCUMENT_ID,REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH)" +
                " VALUES(SEQ_HR_TRANSFER_ATTACHEMENT.NEXTVAL, ?, ?, ?)";
        Savepoint savePoint1 = null;
        String requestId = null;
        int row1 = 0;
        int row2 = 0;
        int rowAffeted = 0;
        //result sets
        ResultSet _rs1 = null;
        PreparedStatement _ps2 = null;

        try {
       
            _con = getConnection();
            _con.setAutoCommit(false);
            //    savePoint1 = _con.setSavepoint("SAVE_POINT_1");///save poin one----------------------------------------------------------
            _ps = _con.prepareStatement(inseretIntoRequest);
            _ps.setString(1, requestInfo.get("requesterId").toString());
            _ps.setString(2, requestInfo.get("transferType").toString());
            _ps.setString(3, requestInfo.get("dateRequest").toString());
            _ps.setString(4, requestInfo.get("fromDepartment").toString());
            _ps.setString(5, requestInfo.get("toDepartment").toString());
            _ps.setString(6, requestInfo.get("description").toString());
            _ps.setString(7, requestInfo.get("transferProcessType").toString());
            _ps.setString(8, requestInfo.get("status").toString());
            _ps.setString(9, requestInfo.get("newPosition").toString());
            _ps.setString(10, requestInfo.get("newRankId").toString());
            _ps.setString(11, requestInfo.get("newPayGrade").toString());
            _ps.setString(12, requestInfo.get("newSalary").toString());
             _ps.setString(13, requestInfo.get("salaryChanged").toString());
            _ps.setString(14, requestInfo.get("effectiveFrom").toString());
            _ps.setString(15, requestInfo.get("Promoted").toString());
              
             row1 = _ps.executeUpdate();

            if (row1 == 1)
            {
                _ps2 = _con.prepareStatement(selectLastRowInsertedRequest);
                _rs1 = _ps2.executeQuery();
                if (_rs1.next()) {
                    requestId = _rs1.getString("TRANSFER_ID");
                }
                if (supportiveInfo.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                    for (HashMap hm : supportiveInfo) {//loop over the attached file
                        try {
                            setRelativePhoto(extractByteArray(new File(hm.get("attachedPath").toString())));//extract the attached image file to byte of array information
                        } catch (Exception ex) {
                        }
                        _ps2 = _con.prepareStatement(inseretAttachement);
                        _ps2.setInt(1, Integer.valueOf(requestId));
                        _ps2.setString(2, hm.get("attachedName").toString());
                        _ps2.setBytes(3, getRelativePhoto());
                        row2 = _ps2.executeUpdate();
                    }
                    if (row2 == 1) {
                        rowAffeted = 1;//set the return type
                        _con.commit();//save the all informations
                    } else {
                        _con.rollback(savePoint1);//roll back to the save point one if there is any error while saving the required informations.
                    }
                } else {
                    rowAffeted = 1;//set the return type
                    _con.commit();//save the all informations
                }

            } else {
                _con.rollback(savePoint1);//roll back to the save point one if there is any error while saving the required informations.
            }

            return rowAffeted;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;

        } finally {
            try {
                _ps2.close();
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }
}
