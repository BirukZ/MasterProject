/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.terminationEntity;

//import connectionProvider.ConnectionInfo;
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
 * @author DPClone
 */
public class TerminationEntity extends ConnectionManager {

    Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

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
    ConnectionManager connectionManager;// = new ConnectionManager();
    String employeePostId;
    String terminationType;
    String terminationDateRequested;
    String terminationDescription;
    String employeerequestId;
    String employeeResignPostId;
    String resignationTypeDescription;
    String employeeResignRequestId;
    int state;
    String terminationTypeSelected;
    String empResignId;
    String employeeIdResignedRequested = null;
    String stateStatus;
    String stateEmp;
    String commentId;
    String terminationID;
    String terminationDate;
//
    String dateDefferenceId;
    String dateDefference;
    String dateDefferenceDescription;
    private byte[] relativePhoto = null;

    /**
     *
     * @return
     */
    public byte[] getRelativePhoto() {
        return relativePhoto;
    }

    /**
     *
     * @param relativePhoto
     */
    public void setRelativePhoto(byte[] relativePhoto) {
        this.relativePhoto = relativePhoto;
    }

    /**
     *
     * @return
     */
    public String getDateDefference() {
        return dateDefference;
    }

    /**
     *
     * @return
     */
    public String getTerminationTypeSelected() {
        return terminationTypeSelected;
    }

    /**
     *
     * @param terminationTypeSelected
     */
    public void setTerminationTypeSelected(String terminationTypeSelected) {
        this.terminationTypeSelected = terminationTypeSelected;
    }

    /**
     *
     * @param dateDefference
     */
    public void setDateDefference(String dateDefference) {
        this.dateDefference = dateDefference;
    }

    /**
     *
     * @return
     */
    public String getDateDefferenceDescription() {
        return dateDefferenceDescription;
    }

    /**
     *
     * @param dateDefferenceDescription
     */
    public void setDateDefferenceDescription(String dateDefferenceDescription) {
        this.dateDefferenceDescription = dateDefferenceDescription;
    }

    /**
     *
     * @return
     */
    public String getDateDefferenceId() {
        return dateDefferenceId;
    }

    /**
     *
     * @param dateDefferenceId
     */
    public void setDateDefferenceId(String dateDefferenceId) {
        this.dateDefferenceId = dateDefferenceId;
    }
    //

    /**
     *
     * @return
     */
    public String getTerminationDate() {
        return terminationDate;
    }

    /**
     *
     * @param terminationDate
     */
    public void setTerminationDate(String terminationDate) {
        this.terminationDate = terminationDate;
    }
    private String checkId;
    private String activeEmployee;
    private String loadTerminationID;
    private String group_Setting;

    /**
     *
     * @return
     */
    public String getGroup_Setting() {
        return group_Setting;
    }

    /**
     *
     * @param group_Setting
     */
    public void setGroup_Setting(String group_Setting) {
        this.group_Setting = group_Setting;
    }

    /**
     *
     * @return
     */
    public String getLoadTerminationID() {
        return loadTerminationID;
    }

    /**
     *
     * @param loadTerminationID
     */
    public void setLoadTerminationID(String loadTerminationID) {
        this.loadTerminationID = loadTerminationID;
    }

    /**
     *
     * @return
     */
    public String getActiveEmployee() {
        return activeEmployee;
    }

    /**
     *
     * @param activeEmployee
     */
    public void setActiveEmployee(String activeEmployee) {
        this.activeEmployee = activeEmployee;
    }
    private String terminationRequestID;

    /**
     *
     * @return
     */
    public String getTerminationRequestID() {
        return terminationRequestID;
    }

    /**
     *
     * @param terminationRequestID
     */
    public void setTerminationRequestID(String terminationRequestID) {
        this.terminationRequestID = terminationRequestID;
    }

    /**
     *
     * @return
     */
    public String getCheckId() {
        return checkId;
    }

    /**
     *
     * @param checkId
     */
    public void setCheckId(String checkId) {
        this.checkId = checkId;
    }

    /**
     *
     * @return
     */
    public String getTerminationID() {
        return terminationID;
    }

    /**
     *
     * @param terminationID
     */
    public void setTerminationID(String terminationID) {
        this.terminationID = terminationID;
    }

    /**
     *
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     *
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }

    /**
     *
     * @return
     */
    public String getCommentDate() {
        return commentDate;
    }

    /**
     *
     * @param commentDate
     */
    public void setCommentDate(String commentDate) {
        this.commentDate = commentDate;
    }

    /**
     *
     * @return
     */
    public String getCommentId() {
        return commentId;
    }

    /**
     *
     * @param commentId
     */
    public void setCommentId(String commentId) {
        this.commentId = commentId;
    }

    /**
     *
     * @return
     */
    public String getCommentedBy() {
        return commentedBy;
    }

    /**
     *
     * @param commentedBy
     */
    public void setCommentedBy(String commentedBy) {
        this.commentedBy = commentedBy;
    }
    String commentedBy;
    String comment;
    String commentDate;

    /**
     *
     * @return
     */
    public String getStateEmp() {
        return stateEmp;
    }

    /**
     *
     * @param stateEmp
     */
    public void setStateEmp(String stateEmp) {
        this.stateEmp = stateEmp;
    }

    /**
     *
     * @return
     */
    public String getStateStatus() {
        return stateStatus;
    }

    /**
     *
     * @param stateStatus
     */
    public void setStateStatus(String stateStatus) {
        this.stateStatus = stateStatus;
    }

    /**
     *
     * @return
     */
    public String getEmployeeIdResignedRequested() {
        return employeeIdResignedRequested;
    }

    /**
     *
     * @param employeeIdResignedRequested
     */
    public void setEmployeeIdResignedRequested(String employeeIdResignedRequested) {
        this.employeeIdResignedRequested = employeeIdResignedRequested;
    }

    /**
     *
     * @return
     */
    public String getEmpResignId() {
        return empResignId;
    }

    /**
     *
     * @param empResignId
     */
    public void setEmpResignId(String empResignId) {
        this.empResignId = empResignId;
    }

    /**
     *
     * @return
     */
    public String getEmpStatetype() {
        return empStatetype;
    }

    /**
     *
     * @param empStatetype
     */
    public void setEmpStatetype(String empStatetype) {
        this.empStatetype = empStatetype;
    }
    String empStatetype;

    /**
     *
     * @return
     */
    public int getState() {
        return state;
    }

    /**
     *
     * @param state
     */
    public void setState(int state) {
        this.state = state;
    }

    /**
     *
     * @return
     */
    public String getEmployeeResignRequestId() {
        return employeeResignRequestId;
    }

    /**
     *
     * @param employeeResignRequestId
     */
    public void setEmployeeResignRequestId(String employeeResignRequestId) {
        this.employeeResignRequestId = employeeResignRequestId;
    }

    /**
     *
     * @return
     */
    public String getResignationTypeDescription() {
        return resignationTypeDescription;
    }

    /**
     *
     * @param resignationTypeDescription
     */
    public void setResignationTypeDescription(String resignationTypeDescription) {
        this.resignationTypeDescription = resignationTypeDescription;
    }

    /**
     *
     * @return
     */
    public String getEmployeeResignPostId() {
        return employeeResignPostId;
    }

    /**
     *
     * @param employeeResignPostId
     */
    public void setEmployeeResignPostId(String employeeResignPostId) {
        this.employeeResignPostId = employeeResignPostId;
    }

    /**
     *
     * @return
     */
    public String getEmployeerequestId() {
        return employeerequestId;
    }

    /**
     *
     * @param employeerequestId
     */
    public void setEmployeerequestId(String employeerequestId) {
        this.employeerequestId = employeerequestId;
    }

    /**
     *
     * @return
     */
    public String getEmployeePostId() {
        return employeePostId;
    }

    /**
     *
     * @param employeePostId
     */
    public void setEmployeePostId(String employeePostId) {
        this.employeePostId = employeePostId;
    }

    /**
     *
     * @return
     */
    public String getTerminationDateRequested() {
        return terminationDateRequested;
    }

    /**
     *
     * @param terminationDateRequested
     */
    public void setTerminationDateRequested(String terminationDateRequested) {
        this.terminationDateRequested = terminationDateRequested;
    }

    /**
     *
     * @return
     */
    public String getTerminationDescription() {
        return terminationDescription;
    }

    /**
     *
     * @param terminationDescription
     */
    public void setTerminationDescription(String terminationDescription) {
        this.terminationDescription = terminationDescription;
    }

    /**
     *
     * @return
     */
    public String getTerminationType() {
        return terminationType;
    }

    /**
     *
     * @param terminationType
     */
    public void setTerminationType(String terminationType) {
        this.terminationType = terminationType;
    }

    /**
     *
     */
    public TerminationEntity() {
    }

    /**
     *
     * @param resignationTypeDescription
     */
    public TerminationEntity(String resignationTypeDescription) {
        this.resignationTypeDescription = resignationTypeDescription;
    }

    /**
     *
     * @param employeeResignRequestId
     * @param employeeResignPostId
     */
    public TerminationEntity(String employeeResignRequestId, String employeeResignPostId) {
        this.employeeResignRequestId = employeeResignRequestId;
        this.employeeResignPostId = employeeResignPostId;
    }

    /**
     *
     * @param dateId
     * @param date
     * @param dateDescription
     */
    public TerminationEntity(String dateId, String date, String dateDescription) {
        this.dateDefferenceId = dateId;
        this.dateDefference = date;
        this.dateDefferenceDescription = dateDescription;
    }

    /**
     *
     * @param commentDate
     * @param employeeId
     * @param terminationRequestID
     * @param comment
     */
    public TerminationEntity(String commentDate, String employeeId, String terminationRequestID, String comment) {
        this.commentDate = commentDate;
        this.commentedBy = employeeId;
        this.terminationRequestID = terminationRequestID;
        this.comment = comment;
    }

    /**
     *
     * @param employeePostId
     * @param resignationtypeId
     * @param resignationDateRequested
     * @param terminationDate
     * @param resignationDescription
     * @param state
     * @param terminationRequestID
     * @param group_Setting
     * @param terminationTypeSelected
     */
    public TerminationEntity(String employeePostId, String resignationtypeId, String resignationDateRequested, String terminationDate, String resignationDescription, int state, String terminationRequestID, String group_Setting, String terminationTypeSelected) {
        this.employeePostId = employeePostId;
        this.terminationType = resignationtypeId;
        this.terminationDateRequested = resignationDateRequested;
        this.terminationDate = terminationDate;
        this.terminationDescription = resignationDescription;
        this.state = state;
        this.terminationRequestID = terminationRequestID;
        this.group_Setting = group_Setting;
        this.terminationTypeSelected = terminationTypeSelected;
    }

    /**
     *
     * @param employeePostId
     * @param resignationtypeId
     * @param resignationDateRequested
     * @param resignationDescription
     * @param state
     */
    public TerminationEntity(String employeePostId, String resignationtypeId, String resignationDateRequested, String resignationDescription, int state) {
        this.employeePostId = employeePostId;
        this.terminationType = resignationtypeId;
        this.terminationDateRequested = resignationDateRequested;
        this.terminationDescription = resignationDescription;
        this.state = state;
    }

    /**
     *
     * @param employeePostId
     * @param resignationtypeId
     * @param resignationDateRequested
     * @param resignationDescription
     * @param state
     * @param terminationRequestID
     */
    public TerminationEntity(String employeePostId, String resignationtypeId, String resignationDateRequested, String resignationDescription, int state, String terminationRequestID) {
        this.employeePostId = employeePostId;
        this.terminationType = resignationtypeId;
        this.terminationDateRequested = resignationDateRequested;
        this.terminationDescription = resignationDescription;
        this.state = state;
        this.terminationRequestID = terminationRequestID;

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

    /**
     *<p>Post new request<p>.
     * @param requestInfo -the inforramyion of the request.
     * @param itemInfo -the new request item entry.
     * @param itemOwnerInfo -the owner of the request at the current item or state. 
     * @param supportiveInfo -any attached documents.
     * @return 1 if success or 0 on failure.
     * @throws SQLException
     */
    public int addNewPost(HashMap requestInfo, HashMap itemInfo, HashMap itemOwnerInfo, Set<HashMap> supportiveInfo, HashMap itemHistoryInfo) throws SQLException {


        String inseretIntoRequest = "INSERT INTO HR_TERMINATION_REQUESTS (REQUESTER_ID, REQUEST_TYPE, DATE_REQUEST,DATE_TERMINATION,DESCRIPTION,CANCELLED )" +
                " VALUES(?, ?, ?, ?, ?, ?) ";


        String insertTransitionInfo = "INSERT INTO HR_WORKFLOW_TRANSITION (WORKFLOW_ID, FROM_STATE_ID,TO_STATE_ID, REMARK, INSERT_DATE,INSERT_BY,REQUEST_ID,ACTION_TAKEN,FROM_OWNER,TO_OWNER)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";


        String inseretAttachement = "INSERT INTO HR_TERMINATION_ATTACHMENT (REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH)" +
                " VALUES(?, ?, ?)";


        String inseretIntoItems = "INSERT INTO HR_WORKFLOW_ITEM (WORKFLOW_ID, REQUEST_ID,CURRENT_STATE_ID )" +
                " VALUES(?, ?, ?) ";


        String inseretIntoItemsOwner = "INSERT INTO HR_WORKFLOW_ITEM_OWNER (WF_ITEM_ID, WF_OWNER_GROUP_ID)" +
                " VALUES(?, ?) ";

        String selectLastRowInsertedItem = "SELECT WF_ITEM_ID FROM HR_WORKFLOW_ITEM WHERE WF_ITEM_ID=(SELECT max(WF_ITEM_ID) FROM HR_WORKFLOW_ITEM)";



        String selectLastRowInsertedRequest = "SELECT REQUEST_ID FROM HR_TERMINATION_REQUESTS WHERE REQUEST_ID=(SELECT max(REQUEST_ID) FROM HR_TERMINATION_REQUESTS)";

        FileInputStream byteInfo = null;
        //local variables that can holed the row affected returned value for the next insertion.
        String requestId = null;
        String itemId = null;


        //current connection


        //row affected
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int row4 = 0;
        int row5 = 0;
        int rowAffeted = 0;
        //result sets
        ResultSet _rs1 = null;
        ResultSet _rs2 = null;

        //prepared statements
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        PreparedStatement _ps4 = null;
        PreparedStatement _ps5 = null;
        PreparedStatement _ps6 = null;
        PreparedStatement _ps7 = null;

        //save points
        Savepoint savePoint1 = null;
//        Savepoint savePoint2 = null;
//        Savepoint savePoint3 = null;
//        Savepoint savePoint4 = null;

        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            savePoint1 = _con.setSavepoint("SAVE_POINT_1");//save poin one----------------------------------------------------------

            _ps1 = _con.prepareStatement(inseretIntoRequest);
            _ps1.setString(1, requestInfo.get("requesterId").toString());
            _ps1.setString(2, requestInfo.get("terminationtype").toString());
            _ps1.setString(3, requestInfo.get("dateRequest").toString());
            _ps1.setString(4, requestInfo.get("dateTermination").toString());
            _ps1.setString(5, requestInfo.get("description").toString());
            _ps1.setInt(6, Integer.valueOf(requestInfo.get("cancelled").toString()));
            row1 = _ps1.executeUpdate();

            if (row1 == 1) {//check the termination request is successfully inserted.
                _ps2 = _con.prepareStatement(selectLastRowInsertedRequest);
                _rs1 = _ps2.executeQuery();
                if (_rs1.next()) {
                    requestId = _rs1.getString("REQUEST_ID");
                }
                _ps3 = _con.prepareStatement(inseretIntoItems);
                _ps3.setInt(1, Integer.valueOf(itemInfo.get("workflowId").toString()));
                _ps3.setString(2, requestId);
                _ps3.setInt(3, Integer.valueOf(itemInfo.get("currentState").toString()));
                row2 = _ps3.executeUpdate();
                if (row2 == 1) {
                    _ps4 = _con.prepareStatement(selectLastRowInsertedItem);
                    _rs2 = _ps4.executeQuery();
                    if (_rs2.next()) {
                        itemId = _rs2.getString("WF_ITEM_ID");
                    }
                    _ps5 = _con.prepareStatement(inseretIntoItemsOwner);
                    _ps5.setInt(1, Integer.valueOf(itemId));
                    _ps5.setInt(2, Integer.valueOf(itemOwnerInfo.get("workflowGroupId").toString()));
                    row3 = _ps5.executeUpdate();

                }
                _ps6 = _con.prepareStatement(insertTransitionInfo);
                _ps6.setInt(1, Integer.valueOf(itemHistoryInfo.get("workflowId").toString()));
                _ps6.setInt(2, Integer.valueOf(itemHistoryInfo.get("fromState").toString()));
                _ps6.setInt(3, Integer.valueOf(itemHistoryInfo.get("toState").toString()));
                _ps6.setString(4, itemHistoryInfo.get("remark").toString());
                _ps6.setString(5, itemHistoryInfo.get("insertedDate").toString());
                _ps6.setString(6, itemHistoryInfo.get("insertedBy").toString());
                _ps6.setInt(7, Integer.valueOf(requestId));
                _ps6.setString(8, itemHistoryInfo.get("action").toString());
                _ps6.setInt(9, Integer.valueOf(itemHistoryInfo.get("fromOwner").toString()));
                _ps6.setInt(10, Integer.valueOf(itemHistoryInfo.get("toOwner").toString()));
                row5 = _ps6.executeUpdate();


                if (row1 == 1 && row2 == 1 && row3 == 1 && row5 == 1) {


                    if (supportiveInfo.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                        for (HashMap hm : supportiveInfo) {//loop over the attached file
                            try {
                                setRelativePhoto(extractByteArray(new File(hm.get("attachedPath").toString())));//extract the attached image file to byte of array information
                            } catch (Exception ex) {
                            }
                            _ps6 = _con.prepareStatement(inseretAttachement);
                            _ps6.setInt(1, Integer.valueOf(requestId));
                            _ps6.setString(2, hm.get("attachedName").toString());
                            _ps6.setBytes(3, getRelativePhoto());


                            row4 = _ps6.executeUpdate();
                        }
                        if (row4 == 1) {
                            rowAffeted = 1;//set the return type
                            _con.commit();//save the all informations
                        } else {
                            _con.rollback(savePoint1);//roll back to the save point one if there is any error while saving the required informations.
//                    _con.rollback(savePoint2);//roll back to the save point two if there is any error while saving the required informations.
//                    _con.rollback(savePoint3);//roll back to the save point three if there is any error while saving the required informations.
//                    _con.rollback(savePoint4);//roll back to the save point four if there is any error while saving the required informations.
                        }
                    } else {
                        rowAffeted = 1;//set the return type
                        _con.commit();//save the all informations
                    }

                } else {
                    _con.rollback(savePoint1);//roll back to the save point one if there is any error while saving the required informations.
                }
            //    savePoint2 = _con.setSavepoint("SAVE_POINT_2");//save poin two----------------------------------------------------
            //     savePoint3 = _con.setSavepoint("SAVE_POINT_3");//save poin three----------------------------------------------------------
            //  savePoint4 = _con.setSavepoint("SAVE_POINT_4");//save poin four----------------------------------------------------------
            } else {
                _con.rollback(savePoint1);//roll back to the save point one if there is any error while saving the required informations.
            }
            return rowAffeted;
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
     * @return
     */
    public OracleCachedRowSet ReadLastTerminatinRequestID() {
        String _select = "   SELECT TERMINATION_ID FROM  HR_TERMINATION_REQUEST  " +
                "        WHERE TERMINATION_ID = (SELECT max(TERMINATION_ID) FROM  HR_TERMINATION_REQUEST )";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @param _docId
     * @return
     */
    public int DeleteAttachedDocument(String _docId) {
        String _update = "DELETE FROM HR_TERMINATION_ATTACHMENT WHERE DOCUMENT_ID='" + _docId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }

    }

    /**
     *
     * @param commentDate
     * @param commentDescription
     * @param commentedBy
     * @param requestId
     * @return
     * @throws java.lang.Exception
     */
    public int addComment(String commentDate, String commentDescription, String commentedBy, String requestId) throws Exception {
        PreparedStatement _ps2 = null;
        Savepoint spOne = null;
        Savepoint spTwo = null;
        try {
            String instertTerminationCommentStatus = "UPDATE HR_TERMINATION_REQUEST SET COMMENT_STATUS=1 WHERE TERMINATION_ID='" + requestId + "'";
            String inseret = "INSERT INTO hr_termination_comments (comment_Id,comment_Date,emp_comment,emp_Id,termination_Id) " +
                    " VALUES(SEQ_TERMINATION.NEXTVAL, '" + commentDate + "', '" + commentDescription + "', '" + commentedBy + "', '" + requestId + "')";
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps = _con.prepareStatement(inseret);
            int row1 = _ps.executeUpdate();
            spTwo = _con.setSavepoint("SAVE_POINT_TWO");
            _ps2 = _con.prepareStatement(instertTerminationCommentStatus);
            int row2 = _ps2.executeUpdate();
            if (row1 == 1 && row2 == 1) {
                _con.commit();
                return 1;
            } else {
                _con.rollback(spOne);
                _con.rollback(spTwo);
                return 0;
            }
        } catch (Exception ex) {
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
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
    public int UpdateTerminationRequest(String requestId, String requestTypeId, String terminationDate, String description, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile) {
        String updateRequest = "UPDATE HR_TERMINATION_REQUESTS SET REQUEST_TYPE=?, DATE_TERMINATION=?, DESCRIPTION=?  WHERE REQUEST_ID =?";
        String updateAttachedFile = "INSERT INTO HR_TERMINATION_ATTACHMENT (REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH) VALUES(?, ?, ?)";
        String deleteAttachedFile = "DELETE FROM HR_TERMINATION_ATTACHMENT  WHERE DOCUMENT_ID =?";
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int rowAffected = 0;
        Savepoint spOne = null;
        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps1 = _con.prepareStatement(updateRequest);
            _ps1.setInt(1, Integer.valueOf(requestTypeId));
            _ps1.setString(2, terminationDate);
            _ps1.setString(3, description);
            _ps1.setInt(4, Integer.valueOf(requestId));
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
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }

    }

    public int ResubmiteTerminationRequest(String requestId, String requestTypeId, String terminationDate, String description, Set<HashMap> supportiveInfo, ArrayList<HashMap> deletedFile, int workflowId, int stateId, HashMap itemHistoryInfo) {
        String updateRequest = "UPDATE HR_TERMINATION_REQUESTS SET REQUEST_TYPE=?, DATE_TERMINATION=?, DESCRIPTION=?  WHERE REQUEST_ID =?";
        String updateState = "UPDATE HR_WORKFLOW_ITEM SET CURRENT_STATE_ID=?  WHERE REQUEST_ID =? AND WORKFLOW_ID=?";
        String updateAttachedFile = "INSERT INTO HR_TERMINATION_ATTACHMENT (REQUEST_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH) VALUES(?, ?, ?)";
        String deleteAttachedFile = "DELETE FROM HR_TERMINATION_ATTACHMENT  WHERE DOCUMENT_ID =?";
        String insertTransitionInfo = "INSERT INTO FPDBA.HR_WORKFLOW_TRANSITION (WORKFLOW_ID, FROM_STATE_ID,TO_STATE_ID, REMARK, INSERT_DATE,INSERT_BY,REQUEST_ID,ACTION_TAKEN,FROM_OWNER,TO_OWNER)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ? )";
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        PreparedStatement _ps4 = null;
        PreparedStatement _ps5 = null;
        int row1 = 0;
        int row2 = 0;
        int row3 = 0;
        int row4 = 0;
        int row5 = 0;
        int rowAffected = 0;
        Savepoint spOne = null;
        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");
            _ps1 = _con.prepareStatement(updateRequest);
            _ps1.setInt(1, Integer.valueOf(requestTypeId));
            _ps1.setString(2, terminationDate);
            _ps1.setString(3, description);
            _ps1.setInt(4, Integer.valueOf(requestId));
            row1 = _ps1.executeUpdate();



            if (row1 == 1) {

                _ps4 = _con.prepareStatement(updateState);
                _ps4.setInt(1, Integer.valueOf(stateId));
                _ps4.setInt(2, Integer.valueOf(requestId));
                _ps4.setInt(3, Integer.valueOf(workflowId));
                row4 = _ps4.executeUpdate();

                _ps5 = _con.prepareStatement(insertTransitionInfo);
                _ps5.setInt(1, Integer.valueOf(itemHistoryInfo.get("workflowId").toString()));
                _ps5.setInt(2, Integer.valueOf(itemHistoryInfo.get("fromState").toString()));
                _ps5.setInt(3, Integer.valueOf(itemHistoryInfo.get("toState").toString()));
                _ps5.setString(4, itemHistoryInfo.get("remark").toString());
                _ps5.setString(5, itemHistoryInfo.get("insertedDate").toString());
                _ps5.setString(6, itemHistoryInfo.get("insertedBy").toString());
                _ps5.setInt(7, Integer.valueOf(requestId));
                _ps5.setString(8, itemHistoryInfo.get("action").toString());
                _ps5.setInt(9, Integer.valueOf(itemHistoryInfo.get("fromOwner").toString()));
                _ps5.setInt(10, Integer.valueOf(itemHistoryInfo.get("toOwner").toString()));
                row5 = _ps5.executeUpdate();


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
                if (row2 == 1 && row3 == 1 && row4 == 1 && row5 == 1) {
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
     * @param workflowId
     * @param requestId
     * @param itemId
     * @param ownerGroupId
     * @param fromStateId
     * @param toStateId
     * @param remark
     * @param insertedDate
     * @param insertedBy
     * @param actionTaken
     * @return
     */
    public int UpdateWorkflowItemInformation(int workflowId, int requestId, int itemId, int ownerGroupId, int fromStateId, int toStateId, String remark, String insertedDate, String insertedBy, String actionTaken, int fromOwner, int toOwner) {
        String updateItemInfo = "UPDATE HR_WORKFLOW_ITEM SET CURRENT_STATE_ID='" + toStateId + "' WHERE WORKFLOW_ID='" + workflowId + "' AND REQUEST_ID='" + requestId + "'";
        String updateItemOwnerGroupInfo = "UPDATE HR_WORKFLOW_ITEM_OWNER SET WF_OWNER_GROUP_ID='" + ownerGroupId + "' WHERE WF_ITEM_ID='" + itemId + "'";
        String insertTransitionInfo = "INSERT INTO FPDBA.HR_WORKFLOW_TRANSITION ( WORKFLOW_ID , FROM_STATE_ID ,TO_STATE_ID , REMARK , INSERT_DATE ,INSERT_BY , REQUEST_ID ,ACTION_TAKEN ,FROM_OWNER , TO_OWNER )" +
                "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";


        int row1 = 0;
        int row2 = 0;
        int row3 = 0;

        Savepoint spOne = null;
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            spOne = _con.setSavepoint("SAVE_POINT_ONE");

            _ps1 = _con.prepareStatement(updateItemInfo);
            row1 = _ps1.executeUpdate();

            _ps2 = _con.prepareStatement(updateItemOwnerGroupInfo);
            row2 = _ps2.executeUpdate();

            _ps3 = _con.prepareStatement(insertTransitionInfo);
            _ps3.setInt(1, Integer.valueOf(workflowId));
            _ps3.setInt(2, Integer.valueOf(fromStateId));
            _ps3.setInt(3, Integer.valueOf(toStateId));
            _ps3.setString(4, remark);
            _ps3.setString(5, insertedDate);
            _ps3.setString(6, insertedBy);
            _ps3.setInt(7, Integer.valueOf(requestId));
            _ps3.setString(8, actionTaken);
            _ps3.setInt(9, Integer.valueOf(fromOwner));
            _ps3.setInt(10, Integer.valueOf(toOwner));
            row3 = _ps3.executeUpdate();
            if (row1 == 1 && row2 == 1 && row3 == 1) {
                _con.commit();
                return 1;
            } else {
                _con.rollback(spOne);
                return 0;
            }

        } catch (Exception ex) {
            try {
                _con.rollback(spOne);

            } catch (SQLException ex1) {
            }

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

    /**
     *
     * @param empId
     * @return
     */
    public String ReadDepartmentDescrption(String empId) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String departmentDescrption;
        try {
            _con = connectionManager.getConnection();
            ps = _con.prepareStatement("SELECT DEP.DEP_DESCRIPTION,EMP.EMP_ID FROM" +
                    " HR_EMPLOYEE_INFO EMP INNER JOIN " +
                    " TBL_DEPARTMENT DEP ON EMP.DEPARTMENT_ID=DEP.DEPT_ID" +
                    "  WHERE EMP.EMP_ID='" + empId + "'");
            rs = ps.executeQuery();
            rs.next();
            departmentDescrption = rs.getString("DEP_DESCRIPTION");
            rs.close();
            // connectionManager.closePooledConnections(_con);
            return departmentDescrption;
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

    /**
     *
     * @param empId
     * @return
     */
    public String ReadUserID(String empId) {
        PreparedStatement ps = null;

        ResultSet rs = null;
        String departmentDescrption;
        try {
            _con = connectionManager.getConnection();
            ps = _con.prepareStatement("SELECT DISTINCT USER_ID FROM MUGHER.TBL_USERS  WHERE EMPLOYEE_ID='" + empId + "'");
            rs = ps.executeQuery();
            rs.next();
            departmentDescrption = rs.getString("USER_ID");
            rs.close();
            // connectionManager.closePooledConnections(_con);
            return departmentDescrption;
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

    /**
     *
     * @param userID
     * @return
     */
    public String ReadOwnerGroupIDByUserID(String userID) {
        PreparedStatement ps = null;
        ResultSet rs = null;
        String departmentDescrption = null;
        try {
            _con = connectionManager.getConnection();
            ps = _con.prepareStatement("SELECT DISTINCT WF_OWNER_GROUP_ID FROM HR_WORKFLOW_OWNER_GROUP_USERS WHERE USER_ID='" + userID + "'");
            rs = ps.executeQuery();
            if (rs.next()) {
                departmentDescrption = rs.getString("WF_OWNER_GROUP_ID");
            }
            rs.close();
            // connectionManager.closePooledConnections(_con);
            return departmentDescrption;
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
    public String ReadEmployeeIDByRequestID(String requestId) {
        PreparedStatement ps = null;

        ResultSet rs = null;
        String departmentDescrption;
        try {
            _con = connectionManager.getConnection();
            ps = _con.prepareStatement("SELECT DISTINCT REQUESTER_ID FROM HR_TERMINATION_REQUESTS WHERE REQUEST_ID='" + requestId + "'");
            rs = ps.executeQuery();
            rs.next();
            departmentDescrption = rs.getString("REQUESTER_ID");
            rs.close();
            // connectionManager.closePooledConnections(_con);
            return departmentDescrption;
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

    /**
     *
     * @param approveDate
     * @param employeeId
     * @param terminationID
     * @param approveComment
     * @param terminationState
     * @param paymentCenter
     * @param paymentType
     * @param selPaymentCenterList
     * @param descriptionForPayment
     * @return
     * @throws java.lang.Exception
     */
    public int addApprove(String approveDate, String employeeId, String terminationID, String approveComment, int terminationState, int paymentCenter, int paymentType, String selPaymentCenterList, String descriptionForPayment) throws Exception {

        Savepoint spOne = null;
        Savepoint spTwo = null;
        Savepoint spThree = null;
        Savepoint spFour = null;

        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        PreparedStatement _ps3 = null;
        String inseretApprove = "INSERT INTO hr_termination_processed (PROCESSED_ID,PROCESSED_DATE,EMP_ID,TERMINATION_ID,EMP_PROCESSED_COMMENT) " +
                " VALUES(SEQ_APPROVE.NEXTVAL, '" + approveDate + "', '" + employeeId + "', '" + terminationID + "', '" + approveComment + "')";
        String updateTerminationRequest = "UPDATE hr_termination_request set STATE='" + terminationState + "' WHERE termination_Id='" + terminationID + "'";
        String qryPaymentCenter = "INSERT INTO HR_TERMINATION_PAYMENT(PAYMENT_ID,TERMINATION_ID,PAYMENT_TYPE,PAYMENT_CENTER,DESCRIPTION)" +
                " VALUES(SEQ_HR_TERMINATION_PAYMENT.NEXTVAL, '" + terminationID + "', '" + paymentType + "', '" + selPaymentCenterList + "', '" + descriptionForPayment + "')";
        String instertTerminationCommentStatus = "UPDATE HR_TERMINATION_REQUEST SET FINAL_COMMENT_STATUS=1 WHERE TERMINATION_ID='" + terminationID + "'";

        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            if (paymentCenter == 2) {
                spOne = _con.setSavepoint("SAVE_POINT_ONE");
                _ps = _con.prepareStatement(inseretApprove);
                int row1 = _ps.executeUpdate();
                spTwo = _con.setSavepoint("SAVE_POINT_TWO");
                _ps1 = _con.prepareStatement(updateTerminationRequest);
                int row2 = _ps1.executeUpdate();
                spThree = _con.setSavepoint("SAVE_POINT_THREE");
                _ps2 = _con.prepareStatement(instertTerminationCommentStatus);
                int row3 = _ps2.executeUpdate();
                if (row1 == 1 && row2 == 1 && row3 == 1) {
                    _con.commit();
                    _con.setAutoCommit(true);
                    return 1;

                } else {
                    _con.rollback(spOne);
                    _con.rollback(spTwo);
                    _con.rollback(spThree);
                    _con.setAutoCommit(true);
                    return 0;
                }
            } else if (paymentCenter == 1) {
                spOne = _con.setSavepoint("SAVE_POINT_ONE");
                _ps = _con.prepareStatement(inseretApprove);
                int row1 = _ps.executeUpdate();
                spTwo = _con.setSavepoint("SAVE_POINT_TWO");
                _ps1 = _con.prepareStatement(updateTerminationRequest);
                int row2 = _ps1.executeUpdate();
                spThree = _con.setSavepoint("SAVE_POINT_THREE");
                _ps2 = _con.prepareStatement(instertTerminationCommentStatus);
                int row3 = _ps2.executeUpdate();
                spFour = _con.setSavepoint("SAVE_POINT_FOUR");
                _ps3 = _con.prepareStatement(qryPaymentCenter);
                int row4 = _ps3.executeUpdate();

                if (row1 == 1 && row2 == 1 && row3 == 1 && row4 == 1) {
                    _con.commit();
                    _con.setAutoCommit(true);
                    return 1;

                } else {
                    _con.rollback(spOne);
                    _con.rollback(spTwo);
                    _con.rollback(spThree);
                    _con.rollback(spFour);
                    _con.setAutoCommit(true);
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception ex) {
            _con.rollback(spOne);
            _con.rollback(spTwo);
            _con.rollback(spThree);
            _con.rollback(spFour);
            _con.setAutoCommit(true);
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
     * @param commentedDate
     * @param terminationComment
     * @param commentedBy
     * @param _terminationID
     * @return
     */
    public int updateTerminationCommented(String commentedDate, String terminationComment, String commentedBy, String _terminationID) {
        String qry = "UPDATE hr_termination_comments SET comment_Date='" + commentedDate + "',emp_comment='" + terminationComment + "',emp_Id='" + commentedBy + "'   WHERE TERMINATION_ID = '" + _terminationID + "'";
        try {

            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            _ps = _con.prepareStatement(qry);
            _ps.executeUpdate();
            _con.commit();
            _con.setAutoCommit(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
        return 1;
    }

    /**
     *
     * @param approveDate
     * @param employeeId
     * @param approveComment
     * @param terminationID
     * @param terminationState
     * @param paymentCenter
     * @param paymentType
     * @param selPaymentCenterList
     * @param descriptionForPayment
     * @return
     * @throws java.lang.Exception
     */
    public int updateTerminationDecision(String approveDate, String employeeId, String approveComment, String terminationID, int terminationState, int paymentCenter, int paymentType, String selPaymentCenterList, String descriptionForPayment) throws Exception {

        String updateApprove = "UPDATE hr_termination_processed SET PROCESSED_DATE='" + approveDate + "',EMP_ID='" + employeeId + "',EMP_PROCESSED_COMMENT='" + approveComment + "'   WHERE TERMINATION_ID = '" + terminationID + "'";
        String updateTerminationRequest = "UPDATE hr_termination_request set STATE='" + terminationState + "' WHERE termination_Id='" + terminationID + "'";
        String updatePaymentCenter = "UPDATE  HR_TERMINATION_PAYMENT SET PAYMENT_TYPE='" + paymentType + "', PAYMENT_CENTER= '" + selPaymentCenterList + "', DESCRIPTION='" + descriptionForPayment + "' WHERE TERMINATION_ID='" + terminationID + "'";

        Savepoint spOne = null;
        Savepoint spTwo = null;
        Savepoint spThree = null;
        PreparedStatement _ps1 = null;
        PreparedStatement _ps2 = null;
        try {
            _con = connectionManager.getConnection();
            _con.setAutoCommit(false);
            if (paymentCenter == 1) {
                spOne = _con.setSavepoint("SAVE_POINT_ONE");
                _ps = _con.prepareStatement(updateApprove);
                int row = _ps.executeUpdate();
                spTwo = _con.setSavepoint("SAVE_POINT_TWO");
                _ps1 = _con.prepareStatement(updateTerminationRequest);
                int row2 = _ps1.executeUpdate();
                spThree = _con.setSavepoint("SAVE_POINT_THREE");
                _ps2 = _con.prepareStatement(updatePaymentCenter);
                int row3 = _ps2.executeUpdate();
                if (row == 1 && row2 == 1 && row3 == 1) {
                    _con.commit();
                    _con.setAutoCommit(true);
                    return 1;
                } else {
                    _con.rollback(spOne);
                    _con.rollback(spTwo);
                    _con.rollback(spThree);
                    return 0;
                }

            } else if (paymentCenter == 2) {
                spOne = _con.setSavepoint("SAVE_POINT_ONE");
                _ps = _con.prepareStatement(updateApprove);
                int row = _ps.executeUpdate();
                spTwo = _con.setSavepoint("SAVE_POINT_TWO");
                _ps1 = _con.prepareStatement(updateTerminationRequest);
                int row2 = _ps1.executeUpdate();
                if (row == 1 && row2 == 1) {
                    _con.commit();
                    _con.setAutoCommit(true);
                    return 1;
                } else {
                    _con.rollback(spOne);
                    _con.rollback(spTwo);
                    return 0;
                }
            } else {
                return 0;
            }
        } catch (Exception ex) {
            _con.rollback(spOne);
            _con.rollback(spTwo);
            _con.rollback(spThree);
            _con.setAutoCommit(true);
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
     * @return
     */
    public ArrayList<TerminationEntity> readResignRequests() {
        String _select = "SELECT termination_ID,emp_Id FROM hr_termination_request WHERE STATE='" + 0 + "'";



        ArrayList<TerminationEntity> terminationEntity = new ArrayList<TerminationEntity>();
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                TerminationEntity userEntity = new TerminationEntity(_rs.getString("termination_ID"), _rs.getString("emp_Id"));
                terminationEntity.add(userEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
        return terminationEntity;
    }

    /**
     *
     * @return
     */
    public ArrayList<TerminationEntity> readProcessedResignRequests() {
        String _select = "SELECT termination_ID,emp_Id FROM hr_termination_request WHERE state!='" + 0 + "'";
        ArrayList<TerminationEntity> terminationEntity = new ArrayList<TerminationEntity>();
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                TerminationEntity userEntity = new TerminationEntity(_rs.getString("termination_ID"), _rs.getString("emp_Id"));
                terminationEntity.add(userEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
        return terminationEntity;
    }

    /**
     *
     * @param requestId
     * @return
     */
    public ArrayList<TerminationEntity> searchEmployeeResignationRequestsById(String requestId) {
        String _select = "SELECT *FROM vw_termination_request where emp_Id='" + requestId + "'";
        ArrayList<TerminationEntity> terminationEntity = new ArrayList<TerminationEntity>();
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                this.employeePostId = _rs.getString("emp_Id");
                this.terminationType = _rs.getString("termination_Type");
                this.terminationDateRequested = _rs.getString("dateRequested");
                this.terminationDescription = _rs.getString("description");
                this.state = _rs.getInt("state");
                this.terminationTypeSelected = _rs.getString("");
                TerminationRequest userEntity = new TerminationRequest(employeePostId, terminationType, terminationDateRequested, terminationDate, terminationDescription, state, terminationTypeSelected);
                terminationEntity.add(userEntity);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
        return terminationEntity;
    }

    /**
     *
     * @param empId
     * @return
     */
    public ResultSet readEmployeeTerminationRequestsHistory(String empId) {
        String _select = "SELECT * FROM VW_EMP_TERMINATION_REQUEST WHERE EMP_ID='" + empId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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

    /**
     *
     * @param requestId
     * @return
     */
    public OracleCachedRowSet ReadSupportiveInfo(String requestId) {
        String _select = "SELECT DOCUMENT_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH FROM HR_TERMINATION_ATTACHMENT WHERE REQUEST_ID='" + requestId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
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

    /**
     *
     * @param docId
     * @return
     */
    public OracleCachedRowSet readDocumentsAttached(String docId) {
        String _select = "SELECT  DOCUMENT_ID,DOCUMENT_ATTACHED_NAME,DOCUMENT_PATH FROM HR_TERMINATION_ATTACHMENT WHERE DOCUMENT_ID='" + docId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
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

    /**
     *
     * @param checkId
     * @return
     */
    public int CheckIDFoundInRequestHistory(String checkId) {
        String _select = "SELECT DISTINCT REQUESTER_ID FROM HR_TERMINATION_REQUESTS WHERE REQUESTER_ID='" + checkId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            return _ps.executeUpdate();
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
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            return _ps.executeUpdate();
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
    public OracleCachedRowSet ReadRequestsList(String employeeId) {
        String _select = "SELECT " +
                "       RE.REQUEST_ID," +
                "       RT.TERMINATION_TYPE" +
                "       FROM HR_TERMINATION_REQUESTS RE" +
                "       INNER JOIN HR_TERMINATION_RESIGN_TYPES RT ON RT.TERMINATION_TYPE_ID=RE.REQUEST_TYPE WHERE RE.REQUESTER_ID='" + employeeId + "'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
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

    /**
     * <p>Read request list by the owner of the request at the current state,
     * @param ownerGroupId  the owner geroup.
     * @return list of requests.
     */
    public OracleCachedRowSet ReadRequestsListByOwnerGroup(int ownerGroupId) {
        String _select = "SELECT RE.REQUEST_ID," +
                "                       RE.REQUESTER_ID," +
                "                       IT.WF_ITEM_ID," +
                "                       ITO.WF_OWNER_GROUP_ID " +
                "                       FROM (((HR_TERMINATION_REQUESTS RE INNER JOIN " +
                "                       HR_WORKFLOW_ITEM IT ON IT.REQUEST_ID=RE.REQUEST_ID) INNER JOIN " +
                "                       HR_WORKFLOW_ITEM_OWNER ITO ON ITO.WF_ITEM_ID=IT.WF_ITEM_ID) " +
                "                       INNER JOIN HR_WORKFLOW_STATE ST ON ST.WF_STATE_ID=IT.CURRENT_STATE_ID) " +
                "                       WHERE ITO.WF_OWNER_GROUP_ID='" + ownerGroupId + "' AND ST.INITIAL_STATE='1'";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
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

    /**
     * <p>Read the initial state of a the current workflow<br/>
     * and current workflow owner group.</p>
     * @param workflowId the id of the workflow currentlly under work.
     * @param ownerGroupId the owner group of the workflow
     * @return the initial state.
     */
    public int ReadInitialStateByOwnerGroup(int workflowId, int ownerGroupId) {
        String _select = "SELECT WF_STATE_ID " +
                "                FROM HR_WORKFLOW_STATE " +
                "                WHERE WORKFLOW_ID='" + workflowId + "' " +
                "                AND WF_OWNER_GROUP_ID='" + ownerGroupId + "' " +
                "                AND INITIAL_STATE='1'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                return _rs.getInt("WF_STATE_ID");
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        }
    }

    /**
     *
     * @param requestId
     * @return
     */
    public OracleCachedRowSet ReadRequestsInfo(String requestId) {
        String _select = " SELECT " +
                "       IT.WF_ITEM_ID," +
                "       WFS.WF_STATE_ID," +
                "       WFS.WF_STATE_NAME, " +
                "       WFS.PROPERTY, " +
                "       WFIO.WF_OWNER_GROUP_ID," +
                "       WFO.OWNER_GROUP_NAME," +
                "       WF.WORKFLOW_ID," +
                "       WF.WORKFLOW_NAME," +
                "       RE.REQUEST_TYPE," +
                "       RE.REQUESTER_ID," +
                "       RT.TERMINATION_TYPE," +
                "       RE.DESCRIPTION,RE.DATE_REQUEST, RE.DATE_TERMINATION" +
                "       FROM (((((((HR_WORKFLOW_ITEM WFI INNER JOIN HR_WORKFLOW_STATE WFS ON WFS.WF_STATE_ID= WFI.CURRENT_STATE_ID)" +
                "                                    INNER JOIN HR_WORKFLOWS WF ON WF.WORKFLOW_ID= WFI.WORKFLOW_ID)" +
                "                                    INNER JOIN HR_WORKFLOW_ITEM_OWNER WFIO ON WFIO.WF_ITEM_ID=WFI.WF_ITEM_ID)" +
                "                                    INNER JOIN HR_WORKFLOW_OWNER_GROUP WFO ON WFO.WF_OWNER_GROUP_ID= WFIO.WF_OWNER_GROUP_ID )" +
                "                                    INNER JOIN HR_TERMINATION_REQUESTS RE ON RE.REQUEST_ID=WFI.REQUEST_ID)" +
                "                                    INNER JOIN HR_TERMINATION_RESIGN_TYPES RT ON RT.TERMINATION_TYPE_ID=RE.REQUEST_TYPE )" +
                "                                    INNER JOIN HR_WORKFLOW_ITEM IT ON IT.REQUEST_ID=RE.REQUEST_ID)" +
                "                                    WHERE RE.REQUEST_ID='" + requestId + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
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
    public ResultSet readEmployeeTerminationRequests(String requestId) {
        String _select = "SELECT * FROM vw_emp_termination_request where termination_ID='" + requestId + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
    }

    /**
     *
     * @param requestId
     * @return
     */
    public ResultSet readEmployeeResignationRequestsComment(String requestId) {
        String _select = "SELECT * FROM HR_TERMINATION_COMMENTS WHERE TERMINATION_ID='" + requestId + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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
    public ResultSet readEmployeeResignationRequestsProcessed(String requestId) {
        String _select = "SELECT * FROM hr_termination_processed where termination_ID='" + requestId + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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
    public ResultSet ReadEmployeeResignationRequestsPymentCenter(String requestId) {
        String _select = "SELECT * FROM HR_TERMINATION_PAYMENT WHERE TERMINATION_ID='" + requestId + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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
     * @return
     */
    public TerminationEntity ReadTerminationDateSettings() {
        String _select = "SELECT * FROM HR_TERMINATION_DATE_SETTING";



        TerminationEntity terminationComment = null;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            _rs = _ps.getResultSet();
            if (_rs.next()) {
                terminationComment = new TerminationEntity(_rs.getString("TERMINATION_DATE_ID"),
                        _rs.getString("TERMINATION_DATE"),
                        _rs.getString("DESCRIPTION"));
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
        return terminationComment;
    }

    /**
     *
     * @param empId
     * @param _state
     * @return
     */
    public int SearchState(String empId, int _state) {
        String qry = "SELECT TERMINATION_ID FROM HR_TERMINATION_REQUEST WHERE EMP_ID = '" + empId + "'" +
                " AND STATE='" + _state + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs.next() && _rs != null) {
                this.loadTerminationID = _rs.getString("TERMINATION_ID");
                return 1;
            } else {
                return 0;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
    }

    /**
     *
     * @param empid
     * @return
     */
    public ResultSet readEmployeeIDTerminationRequest(String empid) {
        String qry = "SELECT emp_Id FROM vw_emp_termination_request WHERE emp_Id = '" + empid + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs.populate(_rs);
                return (ResultSet) ocrs;
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
    }

    /**
     *
     * @param empid
     * @param _resignState
     * @return
     */
    public int readResignationDetailsByState(String empid, String _resignState) {
        String qry = "SELECT *FROM vw_termination_request WHERE emp_Id = '" + empid + "'" +
                " AND state='" + _resignState + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                this.empResignId = _rs.getString("emp_Id");
                this.empStatetype = _rs.getString("state");
            }
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }

    }

    /**
     *
     * @param val
     * @param val2
     * @param val3
     * @return
     */
    public int UpdateDateDefferenceSetting(String val, String val2, String val3) {
        String qry = "UPDATE HR_TERMINATION_DATE_SETTING SET TERMINATION_DATE='" + val2 + "', DESCRIPTION='" + val3 + "' WHERE TERMINATION_DATE_ID='" + val + "'";


        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            return _ps.executeUpdate();
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

    /**
     *
     * @param paymentCenterName
     * @param reqion
     * @param zone
     * @param woreda
     * @param kebele
     * @param description
     * @return
     */
    public int SavePaymentCenterInformation(String paymentCenterName, String reqion, String zone, String woreda, String kebele, String description) {
        String inseretAttachement = "INSERT INTO HR_TERMINATION_PAYMENT_CENTER(PAYMENT_CENTER_ID, PAYMENT_CENTER_NAME, PAYMENT_CENTER_REGION, " +
                "PAYMENT_CENTER_ZONE,PAYMENT_CENTER_WOREDA,PAYMENT_CENTER_KEBELE,DESCRIPTION) " +
                " VALUES(SEQ_PAYMENT_CENTER.NEXTVAL, '" + paymentCenterName + "', '" + reqion + "','" + zone + "' ,'" + woreda + "','" + kebele + "','" + description + "')";


        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(inseretAttachement);
            return _ps.executeUpdate();
        } catch (Exception ex) {
            return 0;
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
     * @return
     */
    public ArrayList<TerminationEntity> ReadPaymentCenter() {
        String _select = "SELECT PAYMENT_CENTER_ID,PAYMENT_CENTER_NAME FROM HR_TERMINATION_PAYMENT_CENTER ";



        ArrayList<TerminationEntity> terminationEntity = new ArrayList<TerminationEntity>();
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                TerminationEntity userEntity = new TerminationEntity(_rs.getString("PAYMENT_CENTER_ID"), _rs.getString("PAYMENT_CENTER_NAME"));
                terminationEntity.add(userEntity);
            }
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
        return terminationEntity;
    }

    /**
     *
     * @return
     */
    public OracleCachedRowSet ReadTerminationTypes() {
        String _select = "SELECT TERMINATION_TYPE_ID,TERMINATION_TYPE FROM HR_TERMINATION_RESIGN_TYPES ";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
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

    public OracleCachedRowSet ReadRetireTypesToList() {
        String _select = "SELECT TERMINATION_TYPE_ID,TERMINATION_TYPE FROM HR_TERMINATION_RETIRE_TYPES ";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
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
     * @param ownerGroupId
     * @return
     */
    public OracleCachedRowSet ReadStateListByOwnerGroupId(int ownerGroupId) {
        String _select = "SELECT WF_STATE_ID,WF_STATE_NAME,SEQUENCE FROM HR_WORKFLOW_STATE WHERE WF_OWNER_GROUP_ID='" + ownerGroupId + "' AND INITIAL_STATE !='1' ORDER BY SEQUENCE";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
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
     * @return
     */
    public ResultSet ReadPaymentCenterList() {
        String _select = "SELECT PAYMENT_CENTER_ID,PAYMENT_CENTER_NAME FROM HR_TERMINATION_PAYMENT_CENTER ";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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
     * @param val
     * @return
     */
    public ResultSet ReadPaymentCenterInformation(String val) {
        String _select = "SELECT * FROM HR_TERMINATION_PAYMENT_CENTER WHERE PAYMENT_CENTER_ID='" + val + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
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
     * @param workflowId
     * @param ownerGroupId
     * @return
     */
    public String CheckStateStatus(int workflowId, int ownerGroupId) {
        String _select = "SELECT FINAL_STATE FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND WF_OWNER_GROUP_ID='" + ownerGroupId + "' AND FINAL_STATE='1'";



        String strState = null;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                strState = _rs.getString("FINAL_STATE");
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return strState;
            } else {
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return strState;
            }

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
     * @param workflowId
     * @param ownerGroupId
     * @return
     */
    public int CurrentStateSequence(int workflowId, int ownerGroupId) {
        String _select = "SELECT DISTINCT SEQUENCE FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND WF_OWNER_GROUP_ID='" + ownerGroupId + "'";



        int intState = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                intState = _rs.getInt("SEQUENCE");
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            } else {
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            }

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

    /**
     *
     * @param workflowId
     * @param sequence
     * @return
     */
    public OracleCachedRowSet CurrentStateInformation(int workflowId, int sequence) {
        String _select = "SELECT DISTINCT WF_OWNER_GROUP_ID,WF_STATE_ID,WF_STATE_NAME FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND INITIAL_STATE='1' AND SEQUENCE='" + sequence + "'";



        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
                //  rs.close();
                //ConnectionManager.closePooledConnections();
            } catch (Exception ex) {
            }
        }
    }

    /**
     *
     * @param paymentCenterID
     * @param paymentCenteName
     * @param paymentCenterReqion
     * @param paymentZone
     * @param paymentWoreda
     * @param paymentCenterKebele
     * @param paymentCenterDescription
     * @return
     */
    public int UpdatePaymentCenterInformation(int paymentCenterID, String paymentCenteName, String paymentCenterReqion, String paymentZone, String paymentWoreda, String paymentCenterKebele, String paymentCenterDescription) {
        String qry = "UPDATE HR_TERMINATION_PAYMENT_CENTER SET PAYMENT_CENTER_NAME='" + paymentCenteName + "', PAYMENT_CENTER_REGION='" + paymentCenterReqion + "', PAYMENT_CENTER_ZONE='" + paymentZone + "', " +
                " PAYMENT_CENTER_WOREDA='" + paymentWoreda + "', PAYMENT_CENTER_KEBELE='" + paymentCenterKebele + "', DESCRIPTION='" + paymentCenterDescription + "' WHERE PAYMENT_CENTER_ID='" + paymentCenterID + "'";


        int rowAffect = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return rowAffect;
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
     * @param val
     * @return
     */
    public int DeletePaymentCenterInformation(int val) {
        String _update = "DELETE FROM HR_TERMINATION_PAYMENT_CENTER WHERE PAYMENT_CENTER_ID='" + val + "'";


        int rowAffect = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return rowAffect;
        } catch (Exception ex) {
            ex.printStackTrace();
            return rowAffect;
        } finally {
            try {
                _ps.close();
            } catch (Exception ignore) {
            }
        }

    }

    /**
     *
     * @param stateName
     * @param workflowId
     * @param workflowOwnerId
     * @return
     */
    public int ReadStateId(String stateName, int workflowId, int workflowOwnerId) {
        String _update = "SELECT WF_STATE_ID FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND WF_OWNER_GROUP_ID='" + workflowOwnerId + "' AND WF_STATE_NAME='" + stateName + "'";
        int intState = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                intState = _rs.getInt("WF_STATE_ID");
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            } else {
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                _ps.close();

            } catch (Exception ignore) {
            }
        }
    }

    public int ReadApproveStateId(String stateName, int workflowId, int workflowOwnerId) {
        String _update = "SELECT WF_STATE_ID FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND WF_OWNER_GROUP_ID='" + workflowOwnerId + "' AND WF_STATE_NAME='" + stateName + "'";
        int intState = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                intState = _rs.getInt("WF_STATE_ID");
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            } else {
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }
    }

    public int UpdateEmployeeStatus(String employeeId, String employeeStatus) {
        String _update = "UPDATE HR_EMPLOYEE_INFO SET EMP_STATUS='" + employeeStatus + "' WHERE EMP_ID='" + employeeId + "'";
        int rowAffect = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            rowAffect = _ps.executeUpdate();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
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

    public int ReadRejectStateId(String stateName, int workflowId, int workflowOwnerId) {
        String _update = "SELECT WF_STATE_ID FROM HR_WORKFLOW_STATE WHERE WORKFLOW_ID='" + workflowId + "' AND WF_OWNER_GROUP_ID='" + workflowOwnerId + "' AND WF_STATE_NAME='" + stateName + "'";
        int intState = 0;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_update);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                intState = _rs.getInt("WF_STATE_ID");
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            } else {
                _rs.close();
                _ps.close();
                // connectionManager.closePooledConnections(_con);
                return intState;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
            }
        }
    }

    /**
     * <p>This method loads the state and state owner group <br/>
     * that is associated with the current workflow.</p>
     * @param wfId
     * @return initial state with ouner of the state.
     */
    public OracleCachedRowSet LoadStateAndOwner(String wfId) {
        String _select = "SELECT " +
                " ST.WF_STATE_ID AS WF_STATE_ID," +
                " ST.WF_STATE_NAME AS WF_STATE_NAME," +
                " WFO.OWNER_GROUP_NAME AS OWNER_GROUP_NAME," +
                " ST.WF_OWNER_GROUP_ID AS WF_OWNER_GROUP_ID," +
                " ST.INITIAL_STATE," +
                " WF.WORKFLOW_ID" +
                " FROM ((HR_WORKFLOWS WF RIGHT JOIN HR_WORKFLOW_STATE ST ON" +
                "                                     ST.WORKFLOW_ID= WF.WORKFLOW_ID)" +
                "                                     INNER JOIN HR_WORKFLOW_OWNER_GROUP WFO ON" +
                "                                     ST.WF_OWNER_GROUP_ID=WFO.WF_OWNER_GROUP_ID)     " +
                "                                     WHERE WF.WORKFLOW_ID='" + wfId + "' AND ST.INITIAL_STATE=1 AND ST.SEQUENCE=1";
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            _ps.close();
            // connectionManager.closePooledConnections(_con);
            return ocrs;
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

    public static class TerminationRequest extends TerminationEntity {

        /**
         *
         */
        public TerminationRequest() {
        }

        /**
         *
         * @param employeePostId
         * @param resignationtypeId
         * @param resignationDateRequested
         * @param terminationDate
         * @param resignationDescription
         * @param state
         * @param terminationTypeSelected
         */
        public TerminationRequest(String employeePostId, String resignationtypeId, String resignationDateRequested, String terminationDate, String resignationDescription, int state, String terminationTypeSelected) {
            this.employeePostId = employeePostId;
            this.terminationType = resignationtypeId;
            this.terminationDateRequested = resignationDateRequested;
            this.terminationDate = terminationDate;
            this.terminationDescription = resignationDescription;
            this.state = state;
            this.terminationTypeSelected = terminationTypeSelected;
        }

        /**
         *
         * @param employeePostId
         * @param resignationtypeId
         * @param resignationDateRequested
         * @param resignationDescription
         * @param terminationDate
         * @param terminationTypeSelected
         */
        public TerminationRequest(String employeePostId, String resignationtypeId, String resignationDateRequested, String resignationDescription, String terminationDate, String terminationTypeSelected) {
            this.employeePostId = employeePostId;
            this.terminationType = resignationtypeId;
            this.terminationDateRequested = resignationDateRequested;
            this.terminationDescription = resignationDescription;
            this.terminationDate = terminationDate;
            this.terminationTypeSelected = terminationTypeSelected;
        }
    }
}
