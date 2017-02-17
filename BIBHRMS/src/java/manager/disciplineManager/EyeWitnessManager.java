/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.EyeWitnessEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import manager.disciplineManager.EyeWitnessManager.OtherMemberEyeWitnessModel;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleSerialBlob;

/**
 *
 * @author mekete
 */
public class EyeWitnessManager {

    EyeWitnessEntity eyeWitnessEntity = new EyeWitnessEntity();
    EyeWitnessModel eyeWitnessModel = new EyeWitnessModel();
    OtherMemberEyeWitnessModel othereyeWitnessModel = new OtherMemberEyeWitnessModel();
    String userName;
    String loggedInEmployeeId;
    private boolean OtherMemberEyeWitnessModel;

    public ArrayList<Option> getEyeWitnessSummaryTypes() {
        ArrayList<Option> witnessSummaryTypes = new ArrayList<Option>();
        witnessSummaryTypes.add(new Option("-1", "--SELECT--"));
        witnessSummaryTypes.add(new Option("REQR", "Requester is correct"));
        witnessSummaryTypes.add(new Option("ACCD", "Accused is correct"));
        witnessSummaryTypes.add(new Option("BOTH", "Both are correct"));
        witnessSummaryTypes.add(new Option("NONE", "Both are not correct"));
        witnessSummaryTypes.add(new Option("UNKN", "I haven't seen"));
        return witnessSummaryTypes;
    }

    public ArrayList<Option> getEyeWitnessPointedByTypes() {
        ArrayList<Option> witnessPointedCondition = new ArrayList<Option>();
        witnessPointedCondition.add(new Option("-1", "--SELECT--"));
        witnessPointedCondition.add(new Option("REQR", "Pointed By Requester"));
        witnessPointedCondition.add(new Option("ACCD", "Pointed By Accused "));
        return witnessPointedCondition;
    }

    public ArrayList<EyeWitnessModel> getEyeWitnessesList(int requestId) {
        ArrayList<EyeWitnessModel> eyeWitnessLists = new ArrayList<EyeWitnessModel>();
        try {
            ResultSet _rs = eyeWitnessEntity.selectEyeWitnesses(requestId);
            while (_rs.next()) {
                eyeWitnessModel = new EyeWitnessModel();
                eyeWitnessModel.setDisciplineRequestId(requestId);
                eyeWitnessModel.setDisciplineEyeWitnessId(_rs.getInt("EYE_WITNESS_ID"));
                eyeWitnessModel.setWitnessId(_rs.getString("WITNESS_ID"));
                eyeWitnessModel.setWitnessFullName(_rs.getString("FIRST_NAME") + "  " + _rs.getString("MIDDLE_NAME") + "  " + _rs.getString("LAST_NAME"));
                eyeWitnessModel.setWitnessDepartment(_rs.getString("DEPARTMENT_NAME"));
                eyeWitnessModel.setPointedByRequester(_rs.getString("POINTED_BY_REQUESTER") == null ? "" : _rs.getString("POINTED_BY_REQUESTER"));
                eyeWitnessModel.setPointedByAccused(_rs.getString("POINTED_BY_ACCUSED") == null ? "" : _rs.getString("POINTED_BY_ACCUSED"));
                eyeWitnessModel.setSummary(_rs.getString("SUMMARY") == null ? "" : _rs.getString("SUMMARY"));
                eyeWitnessModel.setEventDescription(_rs.getString("EVENT_DESCRIPTION") == null ? "" : _rs.getString("EVENT_DESCRIPTION"));
                eyeWitnessModel.setDocRefNumber(_rs.getString("DOC_REF_NUMBER") == null ? "" : _rs.getString("DOC_REF_NUMBER"));
                eyeWitnessModel.setTimeStamp(_rs.getString("TIME_STAMP") == null ? "" : _rs.getString("TIME_STAMP"));
                eyeWitnessModel.setUserName(_rs.getString("USER_NAME") == null ? "" : _rs.getString("USER_NAME"));
                eyeWitnessModel.setDatabaseStatus("Old");
                eyeWitnessModel.setFileName("FILE_NAME");
                eyeWitnessLists.add(eyeWitnessModel);
            }
            _rs.close();
            return eyeWitnessLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<OtherMemberEyeWitnessModel> getOtherEyeWitnessList(int requestId) {
        ArrayList<OtherMemberEyeWitnessModel> OthereyeWitnessLists = new ArrayList<OtherMemberEyeWitnessModel>();
        try {
            ResultSet _rs = eyeWitnessEntity.selectOtherEyeWitnesses(requestId);
            while (_rs.next()) {
                othereyeWitnessModel = new OtherMemberEyeWitnessModel();
                othereyeWitnessModel.setDisciplineProblemID(requestId);
                othereyeWitnessModel.setOtherwitnessFullName(_rs.getString("WITNESS_FULL_NAME"));
                othereyeWitnessModel.setOtherwitnesSsex(_rs.getString("WITNESS_SEX"));
                othereyeWitnessModel.setOtherwitnessAge(_rs.getInt("WITNESS_AGE"));
                othereyeWitnessModel.setOtherwitnessRegion(_rs.getString("WITNESS_REGION"));
                othereyeWitnessModel.setOtherwitnessZone(_rs.getString("WITNESS_ZONE"));
                othereyeWitnessModel.setOtherwitnessWoreda(_rs.getString("WITNESS_WOREDA"));
                othereyeWitnessModel.setOtherwitnessKebele(_rs.getString("WITNESS_KEBELE"));
                othereyeWitnessModel.setOtherwitnessHouseNumber(_rs.getString("WITNESS_HOUSE_NUMBER"));
                othereyeWitnessModel.setOtherwitnessPobox(_rs.getString("WITNESS_PO_BOX"));
                othereyeWitnessModel.setOtherwitnessMobile(_rs.getInt("WITNESS_MOBILE"));
                othereyeWitnessModel.setOtherwitnessEmail(_rs.getString("WITNESS_EMAILE"));
                othereyeWitnessModel.setOtherwitnessTeleOffice(_rs.getInt("WITNESS_TELE_OFFICE"));
                othereyeWitnessModel.setOtherwitnessTeleHome(_rs.getInt("WITNESS_TELE_HOME"));
                othereyeWitnessModel.setDatabaseStatus(_rs.getString("DATABASE_STATUS"));
                othereyeWitnessModel.setOtherWitnessID(_rs.getInt("OTHER_WINESS_ID"));

                OthereyeWitnessLists.add(othereyeWitnessModel);
            }
            _rs.close();
            return OthereyeWitnessLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<OtherMemberEyeWitnessModel> getOtherEyeWitnessWord(int requestId) {
        ArrayList<OtherMemberEyeWitnessModel> OthereyeWitnessWord = new ArrayList<OtherMemberEyeWitnessModel>();
        try {
            ResultSet _rs = eyeWitnessEntity.selectOtherEyeWitnessesWord(requestId);
            while (_rs.next()) {
                othereyeWitnessModel = new OtherMemberEyeWitnessModel();
                othereyeWitnessModel.setDisciplineProblemID(requestId);
                othereyeWitnessModel.setOtherwitnessFullName(_rs.getString("WITNESS_FULL_NAME"));
                othereyeWitnessModel.setOtherwitnesSsex(_rs.getString("WITNESS_SEX"));
                othereyeWitnessModel.setOtherwitnessAge(_rs.getInt("WITNESS_AGE"));
                othereyeWitnessModel.setOtherwitnessRegion(_rs.getString("WITNESS_REGION"));
                othereyeWitnessModel.setOtherwitnessZone(_rs.getString("WITNESS_ZONE"));
                othereyeWitnessModel.setOtherwitnessWoreda(_rs.getString("WITNESS_WOREDA"));
                othereyeWitnessModel.setOtherwitnessKebele(_rs.getString("WITNESS_KEBELE"));
                othereyeWitnessModel.setOtherwitnessHouseNumber(_rs.getString("WITNESS_HOUSE_NUMBER"));
                othereyeWitnessModel.setOtherwitnessPobox(_rs.getString("WITNESS_PO_BOX"));
                othereyeWitnessModel.setOtherwitnessMobile(_rs.getInt("WITNESS_MOBILE"));
                othereyeWitnessModel.setOtherwitnessEmail(_rs.getString("WITNESS_EMAILE"));
                othereyeWitnessModel.setOtherwitnessTeleOffice(_rs.getInt("WITNESS_TELE_OFFICE"));
                othereyeWitnessModel.setOtherwitnessTeleHome(_rs.getInt("WITNESS_TELE_HOME"));
                othereyeWitnessModel.setDatabaseStatus(_rs.getString("DATABASE_STATUS"));
                othereyeWitnessModel.setOtherWitnessID(_rs.getInt("OTHER_WINESS_ID"));
                othereyeWitnessModel.setEventDescription(_rs.getString("EVENT_DESCRIPTION"));
                othereyeWitnessModel.setSummary(_rs.getString("SUMMARY"));
                othereyeWitnessModel.setPointedBy(_rs.getString("POINTED_BY"));
                othereyeWitnessModel.setTime_Stamp(_rs.getString("TIME_STAMP"));
                othereyeWitnessModel.setDocRefNumber(_rs.getString("DOC_REFERANCE"));
                othereyeWitnessModel.setOther_Eye_Witnessword_ID(_rs.getInt("other_eye_witness_id"));
                OthereyeWitnessWord.add(othereyeWitnessModel);
            }
            _rs.close();
            return OthereyeWitnessWord;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<Option> getSex() {
        ArrayList<Option> otherMemberSex = new ArrayList<Option>();
        otherMemberSex.add(new Option(-1, "--SELECT SEX--"));
        otherMemberSex.add(new Option("Male", "MALE"));
        otherMemberSex.add(new Option("Female", "FEMALE"));
        return otherMemberSex;
    }

    public boolean DeletedEyeWitnessword(int deleredId) {
        try {
            eyeWitnessEntity.deletEyeWitnesses(deleredId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean DeletedEmployeeEyeWitnessword(int deleredId) {
        try {
            eyeWitnessEntity.deletEyeWitnesses(deleredId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean UpdatedeyewitnesWord(ArrayList<OtherMemberEyeWitnessModel> eyeWitnessesListOtherWord) {
        try {
            eyeWitnessEntity.updateOtherEyeWitnessesWord(eyeWitnessesListOtherWord);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean UpdateEmployeeEyeWitnessWord(ArrayList<EyeWitnessModel> eyeWitnessesList) {
        try {
            eyeWitnessEntity.updateEyeWitnesses(eyeWitnessesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveEyeWitnessesWordOther(ArrayList<OtherMemberEyeWitnessModel> eyeWitnessesListOtherWord, int disciplineProblemId, String condition) {
        ArrayList<OtherMemberEyeWitnessModel> toBeInserted = new ArrayList<OtherMemberEyeWitnessModel>();
        ArrayList<OtherMemberEyeWitnessModel> toBeUpdated = new ArrayList<OtherMemberEyeWitnessModel>();
        ArrayList<OtherMemberEyeWitnessModel> toBeDeleted = new ArrayList<OtherMemberEyeWitnessModel>();
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();

        try {
            for (OtherMemberEyeWitnessModel currentWitness : eyeWitnessesListOtherWord) {
                if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Old")) {

                    toBeInserted.add(currentWitness);

                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Edited")) {

                    toBeUpdated.add(currentWitness);

                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Deleted")) {

                    toBeDeleted.add(currentWitness);
                }
            }
            if (toBeUpdated.size() > 0) {

                eyeWitnessEntity.updateOtherEyeWitnessesWord(toBeUpdated);

            }
            if (toBeInserted.size() > 0) {


                eyeWitnessEntity.insertOtherEyeWitnessesWord(toBeInserted, disciplineProblemId, condition, currentDateAndTime);

            }
            if (toBeDeleted.size() > 0) {
                //eyeWitnessEntity.deletOtherEyeWitnessesWord(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }


    public boolean saveOtherEyeWitnesses(ArrayList<OtherMemberEyeWitnessModel> otherEyeWitnessesList) {
        ArrayList<OtherMemberEyeWitnessModel> toBeInserted = new ArrayList<OtherMemberEyeWitnessModel>();
        ArrayList<OtherMemberEyeWitnessModel> toBeUpdate = new ArrayList<OtherMemberEyeWitnessModel>();
        ArrayList<OtherMemberEyeWitnessModel> toBeDeleted = new ArrayList<OtherMemberEyeWitnessModel>();
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            for (OtherMemberEyeWitnessModel currentotherEyewitness : otherEyeWitnessesList) {
                if (currentotherEyewitness.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getDatabaseStatus().equalsIgnoreCase("Update")) {
                    toBeUpdate.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getDatabaseStatus().equalsIgnoreCase("Delete")) {
                    toBeDeleted.add(currentotherEyewitness);
                }
                if (toBeInserted.size() > 0) {
                }
                eyeWitnessEntity.SaveOtherEyeWitness(toBeInserted);
            }
            if (toBeUpdate.size() > 0) {
                eyeWitnessEntity.UpdateOtherEyeWitness(toBeUpdate);
            }
            if (toBeDeleted.size() > 0) {
                eyeWitnessEntity.DeleteOtherEyeWitness(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveEyeWitnesses(ArrayList<EyeWitnessModel> eyeWitnessesList, int discipline_Id, String witnessCondition) {
        ArrayList<EyeWitnessModel> toBeInserted = new ArrayList<EyeWitnessModel>();
        ArrayList<EyeWitnessModel> toBeUpdated = new ArrayList<EyeWitnessModel>();
        ArrayList<EyeWitnessModel> toBeDeleted = new ArrayList<EyeWitnessModel>();
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();

        try {
            for (EyeWitnessModel currentWitness : eyeWitnessesList) {
                currentWitness.setTimeStamp(currentDateAndTime);
                currentWitness.setUserName(userName);
                if (currentWitness.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentWitness);
                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Edite")) {
                    toBeUpdated.add(currentWitness);
                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentWitness);
                }
            }
            if (toBeUpdated.size() > 0) {
                eyeWitnessEntity.updateEyeWitnesses(toBeUpdated);

            }
            if (toBeInserted.size() > 0) {

                eyeWitnessEntity.insertEyeWitnesses(toBeInserted, discipline_Id, witnessCondition);
            }
            if (toBeDeleted.size() > 0) {
                // eyeWitnessEntity.deletEyeWitnesses(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveEyeWitnessesWord(ArrayList<EyeWitnessModel> eyeWitnessesList, int discipline_Id, String witnessCondition, byte[] fileAttache) {
        ArrayList<EyeWitnessModel> toBeInserted = new ArrayList<EyeWitnessModel>();
        ArrayList<EyeWitnessModel> toBeUpdated = new ArrayList<EyeWitnessModel>();
        ArrayList<EyeWitnessModel> toBeDeleted = new ArrayList<EyeWitnessModel>();
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();

        try {
            for (EyeWitnessModel currentWitness : eyeWitnessesList) {
                currentWitness.setTimeStamp(currentDateAndTime);
                currentWitness.setUserName(userName);
                if (currentWitness.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentWitness);
                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Old")) {
                    toBeUpdated.add(currentWitness);
                } else if (currentWitness.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentWitness);
                }
            }
            if (toBeUpdated.size() > 0) {
                eyeWitnessEntity.updateEyeWitnesses(toBeUpdated);

            }
            if (toBeInserted.size() > 0) {
                eyeWitnessModel.setFileAttached(fileAttache);

                eyeWitnessEntity.insertEyeWitnesses(toBeInserted, discipline_Id, witnessCondition);

            }
            if (toBeDeleted.size() > 0) {
                  eyeWitnessEntity.deletEyeWitnesses(discipline_Id);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public byte[] singleSelect(int documentId) {
         try {
            byte[] bytePicture = null;
             OracleSerialBlob blo = eyeWitnessEntity.select_Document(documentId);
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
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////
     public byte[] singleSelectForOther(int documentId) {
         try {
            byte[] bytePicture = null;
             OracleSerialBlob blo = eyeWitnessEntity.select_Document_Other(documentId);
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


    ///////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean uPDateIssue(int disciplineProblemId, String witnessConditoin) {
        try {
            if (eyeWitnessEntity.upDateIssue(disciplineProblemId, witnessConditoin)) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean uPDateIssueOther(int disciplineProblemId, String witnessConditoin) {
        try {
            if (eyeWitnessEntity.upDateIssueOther(disciplineProblemId, witnessConditoin)) {
                return true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }


      public boolean saveFile(FileUpLoad UpLoad,String witnessID) {
        try {
           eyeWitnessEntity.insertFile(UpLoad,witnessID);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
       public boolean saveFileOtherEyeWitness(OtherEyeWitnessFileUpLoad UpLoad,int witnessID) {
        try {
           eyeWitnessEntity.insertFileOtherEyeWitness(UpLoad,witnessID);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }


        public FileUpLoad setValues(int disciplineProblemId) {
        FileUpLoad fileUpLoad = new FileUpLoad();
        try {
            ResultSet _rs = eyeWitnessEntity.selectDocumentAttrbutie(disciplineProblemId);
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
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        public OtherEyeWitnessFileUpLoad setValuesOtherEyeWitness(int disciplineProblemId) {
        OtherEyeWitnessFileUpLoad fileUpLoad = new OtherEyeWitnessFileUpLoad();
        try {
            ResultSet _rs = eyeWitnessEntity.selectDocumentAttrbutieOther(disciplineProblemId);
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




        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


    public static class OtherMemberEyeWitnessModel {

        int otherWitnessID;
        String otherwitnessFullName;
        String otherwitnesSsex;
        String otherwitnessRegion;
        String otherwitnessWoreda;
        String otherwitnessZone;
        String otherwitnessKebele;
        String otherwitnessHouseNumber;
        String otherwitnessPobox;
        String otherwitnessEmail;
        String databaseStatus;
        String eventDescription;
        String docRefNumber;
        int other_Eye_Witnessword_ID;
        String summary;
        String pointedBy;
        String WitnessCondition;
        String time_Stamp;
        int otherwitnessAge;
        int otherwitnessMobile;
        int otherwitnessTeleOffice;
        int otherwitnessTeleHome;
        int disciplineProblemID;
       String fileName="AttachedFile";

        public OtherMemberEyeWitnessModel(int otherWitnessID, String databaseStatus, int disciplineProblemID, String otherwitnessFullName, String otherwitnesSsex, String otherwitnessRegion, String otherwitnessWoreda, String otherwitnessZone, String otherwitnessKebele, String otherwitnessHouseNumber, String otherwitnessPobox, String otherwitnessEmail, int otherwitnessAge, int otherwitnessMobile, int otherwitnessTeleOffice, int otherwitnessTeleHome) {
            this.otherWitnessID = otherWitnessID;
            this.databaseStatus = databaseStatus;
            this.disciplineProblemID = disciplineProblemID;
            this.otherwitnessFullName = otherwitnessFullName;
            this.otherwitnesSsex = otherwitnesSsex;
            this.otherwitnessRegion = otherwitnessRegion;
            this.otherwitnessWoreda = otherwitnessWoreda;
            this.otherwitnessZone = otherwitnessZone;
            this.otherwitnessKebele = otherwitnessKebele;
            this.otherwitnessHouseNumber = otherwitnessHouseNumber;
            this.otherwitnessPobox = otherwitnessPobox;
            this.otherwitnessEmail = otherwitnessEmail;
            this.otherwitnessAge = otherwitnessAge;
            this.otherwitnessMobile = otherwitnessMobile;
            this.otherwitnessTeleOffice = otherwitnessTeleOffice;
            this.otherwitnessTeleHome = otherwitnessTeleHome;
        }

        public OtherMemberEyeWitnessModel(String dataBaseStatus, int disciplineProblemID, String fullName, String sex, int age, String region, String woreda, String zone, String kebele, String houseNumber, String poBox, int mobile, String eMail, int teleOffice, int teleHome) {
            this.databaseStatus = dataBaseStatus;
            this.disciplineProblemID = disciplineProblemID;
            this.otherwitnessFullName = fullName;
            this.otherwitnesSsex = sex;
            this.otherwitnessAge = age;
            this.otherwitnessRegion = region;
            this.otherwitnessWoreda = woreda;
            this.otherwitnessZone = zone;
            this.otherwitnessKebele = kebele;
            this.otherwitnessHouseNumber = houseNumber;
            this.otherwitnessPobox = poBox;
            this.otherwitnessMobile = mobile;
            this.otherwitnessEmail = eMail;
            this.otherwitnessTeleOffice = teleOffice;
            this.otherwitnessTeleHome = teleHome;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

     public int getOther_Eye_Witnessword_ID() {
            return other_Eye_Witnessword_ID;
        }

        public void setOther_Eye_Witnessword_ID(int other_Eye_Witnessword_ID) {
            this.other_Eye_Witnessword_ID = other_Eye_Witnessword_ID;
        }

        public String getTime_Stamp() {
            return time_Stamp;
        }

        public void setTime_Stamp(String time_Stamp) {
            this.time_Stamp = time_Stamp;
        }

        public String getWitnessCondition() {
            return WitnessCondition;
        }

        public void setWitnessCondition(String WitnessCondition) {
            this.WitnessCondition = WitnessCondition;
        }

        public String getPointedBy() {
            return pointedBy;
        }

        public void setPointedBy(String pointedBy) {
            this.pointedBy = pointedBy;
        }

        public String getDocRefNumber() {
            return docRefNumber;
        }

        public void setDocRefNumber(String docRefNumber) {
            this.docRefNumber = docRefNumber;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getOtherWitnessID() {
            return otherWitnessID;
        }

        public void setOtherWitnessID(int otherWitnessID) {
            this.otherWitnessID = otherWitnessID;
        }

        public OtherMemberEyeWitnessModel() {
        }

        public String getDatabaseStatus() {
            return databaseStatus;
        }

        public void setDatabaseStatus(String databaseStatus) {
            this.databaseStatus = databaseStatus;
        }

        public int getDisciplineProblemID() {
            return disciplineProblemID;
        }

        public void setDisciplineProblemID(int disciplineProblemID) {
            this.disciplineProblemID = disciplineProblemID;
        }

        public String getOtherwitnesSsex() {
            return otherwitnesSsex;
        }

        public void setOtherwitnesSsex(String otherwitnesSsex) {
            this.otherwitnesSsex = otherwitnesSsex;
        }

        public int getOtherwitnessAge() {
            return otherwitnessAge;
        }

        public void setOtherwitnessAge(int otherwitnessAge) {
            this.otherwitnessAge = otherwitnessAge;
        }

        public String getOtherwitnessEmail() {
            return otherwitnessEmail;
        }

        public void setOtherwitnessEmail(String otherwitnessEmail) {
            this.otherwitnessEmail = otherwitnessEmail;
        }

        public String getOtherwitnessFullName() {
            return otherwitnessFullName;
        }

        public void setOtherwitnessFullName(String otherwitnessFullName) {
            this.otherwitnessFullName = otherwitnessFullName;
        }

        public String getOtherwitnessHouseNumber() {
            return otherwitnessHouseNumber;
        }

        public void setOtherwitnessHouseNumber(String otherwitnessHouseNumber) {
            this.otherwitnessHouseNumber = otherwitnessHouseNumber;
        }

        public String getOtherwitnessKebele() {
            return otherwitnessKebele;
        }

        public void setOtherwitnessKebele(String otherwitnessKebele) {
            this.otherwitnessKebele = otherwitnessKebele;
        }

        public int getOtherwitnessMobile() {
            return otherwitnessMobile;
        }

        public void setOtherwitnessMobile(int otherwitnessMobile) {
            this.otherwitnessMobile = otherwitnessMobile;
        }

        public String getOtherwitnessPobox() {
            return otherwitnessPobox;
        }

        public void setOtherwitnessPobox(String otherwitnessPobox) {
            this.otherwitnessPobox = otherwitnessPobox;
        }

        public String getOtherwitnessRegion() {
            return otherwitnessRegion;
        }

        public void setOtherwitnessRegion(String otherwitnessRegion) {
            this.otherwitnessRegion = otherwitnessRegion;
        }

        public int getOtherwitnessTeleHome() {
            return otherwitnessTeleHome;
        }

        public void setOtherwitnessTeleHome(int otherwitnessTeleHome) {
            this.otherwitnessTeleHome = otherwitnessTeleHome;
        }

        public int getOtherwitnessTeleOffice() {
            return otherwitnessTeleOffice;
        }

        public void setOtherwitnessTeleOffice(int otherwitnessTeleOffice) {
            this.otherwitnessTeleOffice = otherwitnessTeleOffice;
        }

        public String getOtherwitnessWoreda() {
            return otherwitnessWoreda;
        }

        public void setOtherwitnessWoreda(String otherwitnessWoreda) {
            this.otherwitnessWoreda = otherwitnessWoreda;
        }

        public String getOtherwitnessZone() {
            return otherwitnessZone;
        }

        public void setOtherwitnessZone(String otherwitnessZone) {
            this.otherwitnessZone = otherwitnessZone;
        }
    }

    public static class EyeWitnessModel implements Serializable {

        int disciplineEyeWitnessId;
        int disciplineRequestId;
        String witnessId;
        String witnessFullName;
        String witnessDepartment;
        String pointedByRequester;
        String pointedByAccused;
        String summary;
        String eventDescription;
        String reportedDate;
        String docRefNumber;
        String userName;
        String timeStamp;
        String status;
        String databaseStatus;
        String witnessCondition;
        byte[] fileAttached;
        String fileName;


        public EyeWitnessModel(String witnessId, String witnessFullName, String witnessDepartment, String databaseStatus) {
            this.witnessId = witnessId;
            this.witnessFullName = witnessFullName;
            this.witnessDepartment = witnessDepartment;
            this.databaseStatus = databaseStatus;
        }

        public EyeWitnessModel(int disciplineRequestId, String witnessId, String witnessFullName, String witnessDepartment, String databaseStatus,
                String pointedByRequester, String pointedByAccused, String witnessCondition) {
            this.disciplineRequestId = disciplineRequestId;
            this.witnessId = witnessId;
            this.witnessFullName = witnessFullName;
            this.witnessDepartment = witnessDepartment;
            this.databaseStatus = databaseStatus;
            this.pointedByRequester = pointedByRequester;
            this.pointedByAccused = pointedByAccused;
            this.witnessCondition = witnessCondition;
        }

        public String getFileName() {
            return fileName;
        }

        public void setFileName(String fileName) {
            this.fileName = fileName;
        }

        public byte[] getFileAttached() {
            return fileAttached;
        }

        public void setFileAttached(byte[] fileAttached) {
            this.fileAttached = fileAttached;
        }

        public String getWitnessCondition() {
            return witnessCondition;
        }

        public void setWitnessCondition(String witnessCondition) {
            this.witnessCondition = witnessCondition;
        }

        public EyeWitnessModel() {
        }

        public String getDatabaseStatus() {
            return databaseStatus;
        }

        public void setDatabaseStatus(String databaseStatus) {
            this.databaseStatus = databaseStatus;
        }

        public String getEventDescription() {
            return eventDescription;
        }

        public String getDocRefNumber() {
            return docRefNumber;
        }

        public void setDocRefNumber(String docRefNumber) {
            this.docRefNumber = docRefNumber;
        }

        public void setEventDescription(String eventDescription) {
            this.eventDescription = eventDescription;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public int getDisciplineEyeWitnessId() {
            return disciplineEyeWitnessId;
        }

        public void setDisciplineEyeWitnessId(int disciplineEyeWitnessId) {
            this.disciplineEyeWitnessId = disciplineEyeWitnessId;
        }

        public int getDisciplineRequestId() {
            return disciplineRequestId;
        }

        public void setDisciplineRequestId(int disciplineRequestId) {
            this.disciplineRequestId = disciplineRequestId;
        }

        public String getWitnessDepartment() {
            return witnessDepartment;
        }

        public void setWitnessDepartment(String witnessDepartment) {
            this.witnessDepartment = witnessDepartment;
        }

        public String getWitnessFullName() {
            return witnessFullName;
        }

        public void setWitnessFullName(String witnessFullName) {
            this.witnessFullName = witnessFullName;
        }

        public String getPointedByAccused() {
            return pointedByAccused;
        }

        public void setPointedByAccused(String pointedByAccused) {
            this.pointedByAccused = pointedByAccused;
        }

        public String getPointedByRequester() {
            return pointedByRequester;
        }

        public void setPointedByRequester(String pointedByRequester) {
            this.pointedByRequester = pointedByRequester;
        }

        public String getReportedDate() {
            return reportedDate;
        }

        public void setReportedDate(String reportedDate) {
            this.reportedDate = reportedDate;
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

        public String getWitnessId() {
            return witnessId;
        }

        public void setWitnessId(String witnessId) {
            this.witnessId = witnessId;
        }
    }

    public EyeWitnessEntity getEyeWitnessEntity() {
        return eyeWitnessEntity;
    }

    public void setEyeWitnessEntity(EyeWitnessEntity eyeWitnessEntity) {
        this.eyeWitnessEntity = eyeWitnessEntity;
    }

    public EyeWitnessModel getEyeWitnessModel() {
        return eyeWitnessModel;
    }

    public void setEyeWitnessModel(EyeWitnessModel eyeWitnessModel) {
        this.eyeWitnessModel = eyeWitnessModel;
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
     public static class AccusedFileUpLoad{
    int fileID;
    String fileName;
    String fileType;
    int requestID;
    byte[]attachedFile;
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
    public static class FileUpLoad{
     int fileID;
    String fileName;
    String fileType;
    int requestID;
    byte[]attachedFile;
    String extention;

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

        public int getFileID() {
            return fileID;
        }

        public void setFileID(int fileID) {
            this.fileID = fileID;
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
    
    }
     public static class OtherEyeWitnessFileUpLoad{
    int fileID;
    String fileName;
    String fileType;
    int requestID;
    byte[]attachedFile;
    String extention;

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

        public int getFileID() {
            return fileID;
        }

        public void setFileID(int fileID) {
            this.fileID = fileID;
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

    }
}