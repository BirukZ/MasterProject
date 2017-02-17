/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.AccusedDefenceEntity;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class AccusedDefenceManager {

    String loggedInEmployeeId;
    String userName;
    int accusedCommentId;//ACCUSED_COMMENT_ID;
    AccusedDefenceEntity accusedDefenceEntity = new AccusedDefenceEntity();
    AccusedDefenceModel accusedDefenceModel = new AccusedDefenceModel();

    public boolean saveAccusedDefence(int requestId, String acceptAccusation, String acceptPenalty, String descriptionOfAccusation, String descriptionOfPenalty, String docReferenceNumber, byte[] commentes, byte[] interst) {
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            accusedDefenceModel = new AccusedDefenceModel(requestId, acceptAccusation, acceptPenalty, descriptionOfAccusation, descriptionOfPenalty, "Status", userName, currentDateAndTime, docReferenceNumber, commentes, interst);
            accusedDefenceEntity.insertAccusedComment(accusedDefenceModel);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<Option> getPendingRequestsByAccused(String accusedEmployeeId) {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = accusedDefenceEntity.selectAccusedCommentFromAccusedId(loggedInEmployeeId, userName);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("DESCRIPTION_OF_OFFENCE"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public AccusedDefenceModel getDisciplineIssued(int accusedCommentId) {
        try {
            ResultSet _rs = accusedDefenceEntity.selectAccusedComment(accusedCommentId);
            accusedDefenceModel = new AccusedDefenceModel();
            if (_rs.next()) {
                accusedDefenceModel.setAccusedCommentId(accusedCommentId);
                accusedDefenceModel.setRequestId(_rs.getInt("REQUEST_ID"));
                accusedDefenceModel.setAcceptAccusation(_rs.getString("ACCEPT_ACCUSATION"));
                accusedDefenceModel.setAcceptPenalty(_rs.getString("ACCEPT_PENALITY"));
                accusedDefenceModel.setDescriptionOfAccusation(_rs.getString("DESCRIPTION_ON_ACCUSATION"));
                accusedDefenceModel.setDescriptionOfPenalty(_rs.getString("DESCRIPTION_ON_PENALTY"));
                accusedDefenceModel.setStatus(_rs.getString("STATUS"));
                accusedDefenceModel.setIsDocumentAttached(_rs.getString("IS_DOCUMENT_ATTACHED"));
                accusedDefenceModel.setUserName(_rs.getString("RECOREDED_BY"));
                accusedDefenceModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                _rs.close();
                return accusedDefenceModel;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

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

    public static byte[] extractByteArrayForInterset(File file) {
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
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
            }
        }

        return byteFile;
    }

    public boolean FileAttached(int disciplineProblemId) {
        boolean fileAttached = false;
        try {
            ResultSet _rs = accusedDefenceEntity.selectFileAttache(disciplineProblemId);
            while (_rs.next()) {
                byte[] commeentes = _rs.getBytes("COMMEENTS_FILE");

                if (commeentes.length > 0) {
                    fileAttached = true;
                } else {
                    fileAttached = false;
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return fileAttached;
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean interserFileAttached(int disciplineProblemId) {
        boolean intersetFileAttached = false;
        try {
            ResultSet _rs = accusedDefenceEntity.interserSelectFileAttache(disciplineProblemId);
            while (_rs.next()) {
                byte[] interset = _rs.getBytes("INTERSET_FILE");

                if (interset.length > 0) {
                    intersetFileAttached = true;
                } else {
                    intersetFileAttached = false;
                }

            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return intersetFileAttached;
    }

    public boolean saveFile(AccusedFileUpLoad fileUpLoad, FileUpLoadForInterset fileUpLoadInterset) {
        try {
            accusedDefenceEntity.insertFile(fileUpLoad, fileUpLoadInterset);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }


    //////////////////////////////////////////////////////////////////////////////////////////////////
    public ArrayList<Option> getMyCommentedRequests() {
        try {
            ArrayList<Option> pendingLists = new ArrayList<Option>();
            ResultSet _rs = accusedDefenceEntity.selectAccusedCommentFromAccusedId(loggedInEmployeeId, userName);
            while (_rs.next()) {
                pendingLists.add(new Option(_rs.getString("DISCIPLINE_PROBLEM_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("STATUS") + "--" + _rs.getString("OFFENCE_TYPE") + "--" + _rs.getString("EMPLOYEE_STATUS"), _rs.getString("REQUESTER_ID") + " =>" + _rs.getString("OFFENDER_ID")));
            }
            _rs.close();
            return pendingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public AccusedFileUpLoad setValues(int disciplineProblemId) {
        AccusedFileUpLoad fileUpLoad = new AccusedFileUpLoad();
        try {
            ResultSet _rs = accusedDefenceEntity.selectDocumentAttrbutie(disciplineProblemId);
            if (_rs.next()) {


                fileUpLoad.setFileID(_rs.getInt("FILE_ID"));
                fileUpLoad.setFileName(_rs.getString("FILE_NAME"));
                fileUpLoad.setFileType(_rs.getString("FILE_TYPE"));
                fileUpLoad.setExtention(_rs.getString("FILE_EXTENSTION"));
                fileUpLoad.setRequestID(_rs.getInt("REQUEST_ID"));
                fileUpLoad.setAttachedFile(_rs.getBytes("ATTACHED_FILE"));
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
    /////////////////////////////////////////////////////////////////////////////////////////////////////

     public FileUpLoadForInterset setValuesForInterset(int disciplineProblemId) {
        FileUpLoadForInterset fileUpLoad = new FileUpLoadForInterset();
        try {
            ResultSet _rs = accusedDefenceEntity.selectDocumentAttrbutieForInterset(disciplineProblemId);
            if (_rs.next()) {


                fileUpLoad.setFileIDInterest(_rs.getInt("FILE_ID"));
                fileUpLoad.setFileNameInterset(_rs.getString("FILE_NAME"));
                fileUpLoad.setFileTypeInterset(_rs.getString("FILE_TYPE"));
                fileUpLoad.setExtentionInterset(_rs.getString("FILE_EXTENSTION"));
                fileUpLoad.setRequestIDInterset(_rs.getInt("REQUEST_ID"));
                fileUpLoad.setAttachedFileInterset(_rs.getBytes("ATTACHED_FILE"));
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////

    public byte[] singleSelect(int documentId) {
        try {
            byte[] bytePicture = null;
             OracleSerialBlob blo = accusedDefenceEntity.select_Document(documentId);
//            ResultSet rs = accusedDefenceEntity.selectDocument(documentId);

           // if (rs.next()) {
                bytePicture = blo.getBytes(0, (int) blo.length());

                      //  rs.getBlob("ATTACHED_FILE").getBytes(1, (int) rs.getBlob("ATTACHED_FILE").length());
                return bytePicture;
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////////////////////
      public byte[] singleSelectInterst(int documentId) {
        try {
            byte[] bytePicture = null;
             OracleSerialBlob blo = accusedDefenceEntity.select_Document(documentId);
//            ResultSet rs = accusedDefenceEntity.selectDocument(documentId);

           // if (rs.next()) {
                bytePicture = blo.getBytes(0, (int) blo.length());

                      //  rs.getBlob("ATTACHED_FILE").getBytes(1, (int) rs.getBlob("ATTACHED_FILE").length());
                return bytePicture;
            //}
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }


    /////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<AccusedDefenceModel> getDisciplineIssuedFromRequestId(int requestId) {
        try {
            ArrayList<AccusedDefenceModel> accusedDefenceModelList = new ArrayList<AccusedDefenceModel>();
            ResultSet _rs = accusedDefenceEntity.selectAccusedCommentFromRequestId(requestId);
            if (_rs.next()) {
                accusedDefenceModel = new AccusedDefenceModel();
                accusedDefenceModel.setAccusedCommentId(_rs.getInt("ACCUSED_COMMENT_ID"));
                accusedDefenceModel.setRequestId(requestId);
                accusedDefenceModel.setAcceptAccusation(_rs.getString("ACCEPT_ACCUSATION"));
                accusedDefenceModel.setAcceptPenalty(_rs.getString("ACCEPT_PENALITY"));
                accusedDefenceModel.setDescriptionOfAccusation(_rs.getString("DESCRIPTION_ON_ACCUSATION"));
                accusedDefenceModel.setDescriptionOfPenalty(_rs.getString("DESCRIPTION_ON_PENALTY"));
                accusedDefenceModel.setStatus(_rs.getString("STATUS"));
                accusedDefenceModel.setIsDocumentAttached(_rs.getString("IS_DOCUMENT_ATTACHED"));
                accusedDefenceModel.setUserName(_rs.getString("USER_NAME"));
                accusedDefenceModel.setTimeStamp(_rs.getString("TIME_STAMP"));
                accusedDefenceModelList.add(accusedDefenceModel);
            }
            _rs.close();
            return accusedDefenceModelList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public int getAccusedCommentId() {
        return accusedCommentId;
    }

    public void setAccusedCommentId(int accusedCommentId) {
        this.accusedCommentId = accusedCommentId;
    }

    public AccusedDefenceEntity getAccusedDefenceEntity() {
        return accusedDefenceEntity;
    }

    public void setAccusedDefenceEntity(AccusedDefenceEntity accusedDefenceEntity) {
        this.accusedDefenceEntity = accusedDefenceEntity;
    }

    public AccusedDefenceModel getAccusedDefenceModel() {
        return accusedDefenceModel;
    }

    public void setAccusedDefenceModel(AccusedDefenceModel accusedDefenceModel) {
        this.accusedDefenceModel = accusedDefenceModel;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    //<editor-fold defaultstate="collapsed" desc="inner class AccusedDefenceModel">
    public static class AccusedDefenceModel {

        int accusedCommentId;//ACCUSED_COMMENT_ID;
        int requestId;//REQUEST_ID;
        String acceptAccusation;//ACCEPT_ACCUSATION;
        String acceptPenalty;//ACCEPT_PENALITY;
        String descriptionOfAccusation;//DESCRIPTION_ON_ACCUSATION;
        String descriptionOfPenalty;//DESCRIPTION_ON_PENALTY;
        String status;//STATUS;
        String userName;//USER_NAME;
        String timeStamp;//TIME_STAMP;
        String isDocumentAttached;//IS_DOCUMENT_ATTACHED;
        byte[] commeentsFile;
        byte[] intersetFile;

        public AccusedDefenceModel() {
        }

        public AccusedDefenceModel(int requestId, String acceptAccusation, String acceptPenalty, String descriptionOfAccusation, String descriptionOfPenalty) {
            this.requestId = requestId;
            this.acceptAccusation = acceptAccusation;
            this.acceptPenalty = acceptPenalty;
            this.descriptionOfAccusation = descriptionOfAccusation;
            this.descriptionOfPenalty = descriptionOfPenalty;
        }

        public AccusedDefenceModel(int accusedCommentId, int requestId, String acceptAccusation, String acceptPenalty, String descriptionOfAccusation, String descriptionOfPenalty) {
            this(requestId, acceptAccusation, acceptPenalty, descriptionOfAccusation, descriptionOfPenalty);
            this.accusedCommentId = accusedCommentId;
        }

        public AccusedDefenceModel(int requestId, String acceptAccusation, String acceptPenalty, String descriptionOfAccusation, String descriptionOfPenalty, String status, String userName, String timeStamp, String documentAttached, byte[] commentes, byte[] interest) {
            this(requestId, acceptAccusation, acceptPenalty, descriptionOfAccusation, descriptionOfPenalty);
            this.status = status;
            this.userName = userName;
            this.timeStamp = timeStamp;
            this.isDocumentAttached = documentAttached;
            this.commeentsFile = commentes;
            this.intersetFile = interest;
        }

        public byte[] getIntersetFile() {
            return intersetFile;
        }

        public void setIntersetFile(byte[] intersetFile) {
            this.intersetFile = intersetFile;
        }

        public byte[] getCommeentsFile() {
            return commeentsFile;
        }

        public void setCommeentsFile(byte[] commeentsFile) {
            this.commeentsFile = commeentsFile;
        }

        public String getAcceptAccusation() {
            return acceptAccusation;
        }

        public void setAcceptAccusation(String acceptAccusation) {
            this.acceptAccusation = acceptAccusation;
        }

        public String getAcceptPenalty() {
            return acceptPenalty;
        }

        public void setAcceptPenalty(String acceptPenalty) {
            this.acceptPenalty = acceptPenalty;
        }

        public int getAccusedCommentId() {
            return accusedCommentId;
        }

        public void setAccusedCommentId(int accusedCommentId) {
            this.accusedCommentId = accusedCommentId;
        }

        public String getDescriptionOfPenalty() {
            return descriptionOfPenalty;
        }

        public void setDescriptionOfPenalty(String descriptionOfPenalty) {
            this.descriptionOfPenalty = descriptionOfPenalty;
        }

        public String getIsDocumentAttached() {
            return isDocumentAttached;
        }

        public void setIsDocumentAttached(String isDocumentAttached) {
            this.isDocumentAttached = isDocumentAttached;
        }

        public String getDescriptionOfAccusation() {
            return descriptionOfAccusation;
        }

        public void setDescriptionOfAccusation(String descriptionOfAccusation) {
            this.descriptionOfAccusation = descriptionOfAccusation;
        }

        public int getRequestId() {
            return requestId;
        }

        public void setRequestId(int requestId) {
            this.requestId = requestId;
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
    }

    public static class AccusedFileUpLoad {

        int fileID;
        String fileName;
        String fileType;
        int requestID;
        byte[] attachedFile;
        String extention;

        public int getFileID() {
            return fileID;
        }

        public void setFileID(int fileID) {
            this.fileID = fileID;
        }

        public byte[] getAttachedFile() {
            return attachedFile;
        }

        public void setAttachedFile(byte[] attachedFile) {
            this.attachedFile = attachedFile;
        }

        public String getExtention() {
            return extention;
        }

        public void setExtention(String extention) {
            this.extention = extention;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }

        public int getRequestID() {
            return requestID;
        }

        public void setRequestID(int requestID) {
            this.requestID = requestID;
        }

        public AccusedFileUpLoad() {
        }
    }

    public static class FileUpLoadForInterset {

        int fileIDInterest;
        String fileNameInterset;
        String fileTypeInterset;
        int requestIDInterset;
        byte[] attachedFileInterset;
        String extentionInterset;

        public int getFileIDInterest() {
            return fileIDInterest;
        }

        public void setFileIDInterest(int fileIDInterest) {
            this.fileIDInterest = fileIDInterest;
        }

        public byte[] getAttachedFileInterset() {
            return attachedFileInterset;
        }

        public void setAttachedFileInterset(byte[] attachedFileInterset) {
            this.attachedFileInterset = attachedFileInterset;
        }

        public String getExtentionInterset() {
            return extentionInterset;
        }

        public void setExtentionInterset(String extentionInterset) {
            this.extentionInterset = extentionInterset;
        }

        public String getFileNameInterset() {
            return fileNameInterset;
        }

        public void setFileNameInterset(String fileNameInterset) {
            this.fileNameInterset = fileNameInterset;
        }

        public String getFileTypeInterset() {
            return fileTypeInterset;
        }

        public void setFileTypeInterset(String fileTypeInterset) {
            this.fileTypeInterset = fileTypeInterset;
        }

        public int getRequestIDInterset() {
            return requestIDInterset;
        }

        public void setRequestIDInterset(int requestIDInterset) {
            this.requestIDInterset = requestIDInterset;
        }

        public FileUpLoadForInterset() {
        }
    }
    //</editor-fold>
}
