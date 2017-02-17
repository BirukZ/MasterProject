/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.recruitmentEntity;

import com.sun.codemodel.JOp;
import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.util.ArrayList;
import java.util.HashMap;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.swing.JOptionPane;
import manager.recruitmentManager.CandidateExperienceManager.CandidateEducationManager;
import manager.recruitmentManager.CandidateManager;
import manager.recruitmentManager.CandidateManager.CandidateListForExam;
import oracle.jdbc.OracleResultSetMetaData;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class CandidateEntity extends ConnectionManager {

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

    public CandidateEntity() {
    }
    String candidateID;

    public String getCandidateID() {
        return candidateID;
    }
    String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    String description;

    public CandidateEntity(String code, String description) {
        this.code = code;
        this.description = description;
    }

    public void setCandidateID(String candidateID) {
        this.candidateID = candidateID;
    }

    public CandidateEntity(String candidateID) {
        this.candidateID = candidateID;
    }

    public CandidateEntity(String date, String dateOfBirth, String email, String experience, String firstName, String interview, String lastName, String levelOfEducation, String midelName, String mobile, String oficeTelephone, String practical, String recommendation, String telResidence, String batchCode, String gender, String candidateType, String other, String noPage, String writtenExam, String cgpa, String canidateId, String satus) {
        this.date = date;
        this.dateOfBirth = dateOfBirth;
        this.email = email;
        this.experience = experience;
        this.firstName = firstName;
        this.interview = interview;
        this.lastName = lastName;
        this.levelOfEducation = levelOfEducation;
        this.midelName = midelName;
        this.mobile = mobile;
        this.oficeTelephone = oficeTelephone;
        this.practical = practical;
        this.recommendation = recommendation;
        this.telResidence = telResidence;
        this.batchCode = batchCode;
        this.gender = gender;
        this.candidateType = candidateType;
        this.other = other;
        this.noPage = noPage;
        this.writtenExam = writtenExam;
        this.cgpa = cgpa;
        this.canidateId = canidateId;
        this.status = status;
    }
       public CandidateEntity(String leavelOFEducation, String cgpa, String instiution, String filedOfStudy, String graduationYear, String candidateID, int canEducID) {
        this.levelOfEducation=leavelOFEducation;
        this.cgpa=cgpa;
        this.instiutation=instiution;
        this.educationType=filedOfStudy;
        this.graducationYear=graduationYear;
        this.candidateID=candidateID;
        this.canEducaID=canEducID;
    }
    String date;
    String dateOfBirth;
    String email;
    String experience;
    String firstName;
    String interview;
    String lastName;
    String levelOfEducation;
    String midelName;
    String mobile;
    String oficeTelephone;
    String practical;
    String recommendation;
    String telResidence;
    String batchCode;
    String gender;
    String candidateType;
    String other;
    String noPage;
    String writtenExam;
    String cgpa;
    String canidateId;
    String status;
    String educationType;
    String educLevel;
    String instiutation;
    String graducationYear;
    int canEducaID;

    public int getCanEducaID() {
        return canEducaID;
    }

    public void setCanEducaID(int canEducaID) {
        this.canEducaID = canEducaID;
    }


    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getEducationType() {
        return educationType;
    }

    public void setEducationType(String educationType) {
        this.educationType = educationType;
    }

    public String getGraducationYear() {
        return graducationYear;
    }

    public void setGraducationYear(String graducationYear) {
        this.graducationYear = graducationYear;
    }

    public String getInstiutation() {
        return instiutation;
    }

    public void setInstiutation(String instiutation) {
        this.instiutation = instiutation;
    }



    public String getCanidateId() {
        return canidateId;
    }

    public void setCanidateId(String canidateId) {
        this.canidateId = canidateId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getCandidateType() {
        return candidateType;
    }

    public void setCandidateType(String candidateType) {
        this.candidateType = candidateType;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getInterview() {
        return interview;
    }

    public void setInterview(String interview) {
        this.interview = interview;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getLevelOfEducation() {
        return levelOfEducation;
    }

    public void setLevelOfEducation(String levelOfEducation) {
        this.levelOfEducation = levelOfEducation;
    }

    public String getMidelName() {
        return midelName;
    }

    public void setMidelName(String midelName) {
        this.midelName = midelName;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getNoPage() {
        return noPage;
    }

    public void setNoPage(String noPage) {
        this.noPage = noPage;
    }

    public String getOficeTelephone() {
        return oficeTelephone;
    }

    public void setOficeTelephone(String oficeTelephone) {
        this.oficeTelephone = oficeTelephone;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
    }

    public String getPractical() {
        return practical;
    }

    public void setPractical(String practical) {
        this.practical = practical;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }

    public String getTelResidence() {
        return telResidence;
    }

    public void setTelResidence(String telResidence) {
        this.telResidence = telResidence;
    }

    public String getWrittenExam() {
        return writtenExam;
    }

    public void setWrittenExam(String writtenExam) {
        this.writtenExam = writtenExam;
    }

    public boolean insertCandidateEducation(ArrayList<CandidateEducationManager> candidateEducationList) {
        String str = "INSERT " +
                "INTO HR_CANDIDATE_EDUCATION " +
                "  ( " +
                "    candidate_id, " +
                "    instution, " +
                "    cgpa, " +
                "    filed_of_study, " +
                "    filed_of_catagory, " +
                "    graduation_year, " +
                "    can_educ_id," +
                "    STATUS " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?," +
                "    HR_CAND_EDUCA_SEQ.NEXTVAL," +
                "  ? " +
                "  )";

        try {
            int size = candidateEducationList.size();
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            for (int counter = 0; counter < size; counter++) {
                _ps.setString(1, candidateEducationList.get(counter).getCandidateID());
                _ps.setString(2, candidateEducationList.get(counter).getInstiution());
                _ps.setString(3, candidateEducationList.get(counter).getCgpa());
                _ps.setString(4, candidateEducationList.get(counter).getFiledOfStudy());
                _ps.setString(5, candidateEducationList.get(counter).getLeavelOFEducation());
                _ps.setString(6, candidateEducationList.get(counter).getGraduationYear());
                _ps.setString(7, "SAVED");
                _ps.addBatch();
            }
            _ps.executeBatch();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    public boolean UpdateCandidateEducation(CandidateEntity candidateEducationList)
    {
        String str =" UPDATE HR_CANDIDATE_EDUCATION " +
                "  SET " +
                "  instution=?, " +
                "  cgpa=?," +
                "  filed_of_study=?, " +
                "  filed_of_catagory=?, " +
                "  graduation_year=? " +
                " WHERE HR_CAN_EDUC_ID=?";


        try {
           // int size = candidateEducationList.size();
            _con = getConnection();
            _ps = _con.prepareStatement(str);
                 _ps.setString(1, candidateEducationList.getInstiutation());
                _ps.setString(2, candidateEducationList.getCgpa());
                _ps.setString(3, candidateEducationList.getEducationType());
                _ps.setString(4, candidateEducationList.getLevelOfEducation());
                _ps.setString(5, candidateEducationList.getGraducationYear());
                _ps.setInt(6, candidateEducationList.getCanEducaID());    
              _ps.executeUpdate();
               return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }
    //////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public boolean pusheCandidtaForEmployement(ArrayList<CandidateManager> lastSelectedCandiate) {
        try {
            boolean condition3 = false;
            // int [] condition4 ;
            //   boolean condition5 = false;
            PreparedStatement _ps1 = null;
            PreparedStatement _ps2 = null;
            PreparedStatement _ps3 = null;
            PreparedStatement _ps4 = null;
            PreparedStatement _ps5 = null;
            PreparedStatement _ps6 = null;
            String str = " update hr_candidate SET status='Employee',CERTIFY='certify',RECURITMENT_STATUS='CLOSED' WHERE CANDIDATE_ID=?";
            String strquery = " update HR_RECRUITMENT_REQUEST SET RECURITMENT_CONDITION='CLOSED' WHERE RECRUIT_BATCH_CODE=?";
            String strClear = " DELETE " +
                    "FROM " +
                    "  (SELECT * " +
                    "  FROM hr_candidate " +
                    "  WHERE candidate_id NOT IN " +
                    "    (SELECT batchcode FROM hr_exam_percentage " +
                    "    ) " +
                    "  ) " +
                    "WHERE RECRUIT_BATCH_CODE=?";
            String strClearFromEducation = "DELETE " +
                    " FROM hr_candidate_education " +
                    " WHERE CANDIDATE_ID IN " +
                    "  (SELECT CANDIDATE_ID " +
                    "  FROM " +
                    "    (SELECT A.CANDIDATE_ID, " +
                    "      A.RECRUIT_BATCH_CODE " +
                    "    FROM " +
                    "      (SELECT * FROM HR_CANDIDATE " +
                    "      ) A, " +
                    "      (SELECT * " +
                    "      FROM hr_candidate_education " +
                    "      WHERE candidate_id NOT IN " +
                    "        (SELECT batchcode FROM hr_exam_percentage WHERE BATCHJOB=? " +
                    "        ) " +
                    "      ) B " +
                    "    WHERE A.CANDIDATE_ID=B.CANDIDATE_ID " +
                    "    AND A.RECRUIT_BATCH_CODE=? " +
                    "    )C " +
                    "  WHERE C.RECRUIT_BATCH_CODE=? " +
                    "  )";

            String strClearFromExpiracne = "DELETE " +
                    "FROM hr_candidate_experience " +
                    "WHERE CANDIDATE_ID IN " +
                    "  (SELECT CANDIDATE_ID " +
                    "  FROM " +
                    "    (SELECT A.CANDIDATE_ID, " +
                    "      A.RECRUIT_BATCH_CODE " +
                    "    FROM " +
                    "      (SELECT * FROM HR_CANDIDATE " +
                    "      ) A, " +
                    "      (SELECT * " +
                    "      FROM hr_candidate_experience " +
                    "      WHERE candidate_id NOT IN " +
                    "        (SELECT batchcode FROM hr_exam_percentage WHERE BATCHJOB=? " +
                    "        ) " +
                    "      ) B " +
                    "    WHERE A.CANDIDATE_ID    =B.CANDIDATE_ID " +
                    "    AND A.RECRUIT_BATCH_CODE=? " +
                    "    )C " +
                    "  WHERE C.RECRUIT_BATCH_CODE=? " +
                    "  )";
            String strClearFromCandidate = "DELETE " +
                    "FROM hr_candidate " +
                    "WHERE candidate_id NOT IN " +
                    "  (SELECT batchcode FROM hr_exam_percentage " +
                    "  ) " +
                    "AND RECRUIT_BATCH_CODE=?";
            String strClearFromTotalExpiracne = "DELETE " +
                    "FROM hr_can_total_expirance " +
                    "WHERE CAN_ID IN " +
                    "  (SELECT CANDIDATE_ID " +
                    "  FROM " +
                    "    (SELECT A.CANDIDATE_ID, " +
                    "      A.RECRUIT_BATCH_CODE " +
                    "    FROM " +
                    "      (SELECT * FROM HR_CANDIDATE " +
                    "      ) A, " +
                    "      (SELECT * " +
                    "      FROM hr_can_total_expirance " +
                    "      WHERE can_id NOT IN " +
                    "        (SELECT batchcode FROM hr_exam_percentage WHERE BATCHJOB=? " +
                    "        ) " +
                    "      ) B " +
                    "    WHERE A.CANDIDATE_ID    =B.CAN_ID " +
                    "    AND A.RECRUIT_BATCH_CODE=? " +
                    "    )C " +
                    "  WHERE C.RECRUIT_BATCH_CODE=? " +
                    "  )";

            int size = lastSelectedCandiate.size();
            _con = getConnection();
            _ps1 = _con.prepareStatement(str);
            for (int counter = 0; counter < size; counter++) {
                _ps1.setInt(1, lastSelectedCandiate.get(counter).getCandidateID());
                _ps1.addBatch();
            }
            int[] condition = _ps1.executeBatch();
            if (condition[0] < 0) {
                size = lastSelectedCandiate.size();
                _con = getConnection();
                _ps2 = _con.prepareStatement(strquery);
                for (int counter = 0; counter < size; counter++) {
                    _ps2.setString(1, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps2.addBatch();
                }
            //   _ps2.executeBatch();
            //  return true;
            }
            int[] conditionTwo = _ps2.executeBatch();
            if (conditionTwo[0] < 0) {
                _con = getConnection();
                _ps4 = _con.prepareStatement(strClearFromEducation);
                for (int counter = 0; counter < size; counter++) {
                    _ps4.setString(1, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps4.setString(2, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps4.setString(3, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps4.addBatch();
                }

            }
            int[] condition4 = _ps4.executeBatch();

            if (condition4[0] < 0) {
                _con = getConnection();
                _ps5 = _con.prepareStatement(strClearFromExpiracne);
                for (int counter = 0; counter < size; counter++) {
                    _ps5.setString(1, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps5.setString(2, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps5.setString(3, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps5.addBatch();

                }

            }
            int[] condition5 = _ps5.executeBatch();
            if (condition5[0] < 0) {
                _con = getConnection();
                _ps3 = _con.prepareStatement(strClearFromTotalExpiracne);
                for (int counter = 0; counter < size; counter++) {
                    _ps3.setString(1, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps3.setString(2, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps3.setString(3, lastSelectedCandiate.get(counter).getBatchCode());
                    _ps3.addBatch();
                }
                _ps3.executeBatch();
            }

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }


        }
    }

    public boolean PusheCandidateForExam(ArrayList<CandidateListForExam> finalSelectedCandidate) {
        String str = " INSERT INTO HR_CANDIDATE_FOR_EXAM(" +
                "CandidateID," +
                "CandidateName, " +
                "BatchCode,PASSID) " +
                "values(?,?,?,HR_CANDIDATE_FOR_EXAM_SEQ.NEXTVAL)";
        try {
            int size = finalSelectedCandidate.size();
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            for (int counter = 0; counter < size; counter++) {
                _ps.setString(1, finalSelectedCandidate.get(counter).getCandidateID());
                _ps.setString(2, finalSelectedCandidate.get(counter).getCandidateName());
                _ps.setString(3, finalSelectedCandidate.get(counter).getBatchId());
                _ps.addBatch();
            }

            _ps.executeBatch();
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }


        }

    }

//      public boolean PusheCandidateForExam(String canID, String fullName, String batchID) {
//        String str = " INSERT INTO HR_CANDIDATE_FOR_EXAM(" +
//                "CandidateID," +
//                "CandidateName, " +
//                "BatchCode,PASSID) " +
//                "values(?,?,?,HR_CANDIDATE_FOR_EXAM_SEQ.NEXTVAL)";
//
//
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(str);
//            _ps.setString(1, canID);
//            _ps.setString(2, fullName);
//            _ps.setString(3, batchID);
//
//            return _ps.execute();
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return false;
//        } finally {
//            try {
//                releaseResources();
//            } catch (Exception ignore) {
//            }
//
//        }
//
//    }
    public boolean saveCandidateForExam(ArrayList<CandidateListForExam> readApprovedCandidateList) {
        String str = " INSERT " +
                " INTO HR_CANDIDATE_FOR_EXAM " +
                "  ( " +
                "    BATCH_ID, " +
                "    CANDIDATE_ID, " +
                "    CANDIDATE_NAME, " +
                "    GENDER, " +
                "    STATUS, " +
                "    APPROVED_BY, " +
                "    APPROVED_DAY " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";

        try {
            int size = readApprovedCandidateList.size();

            _con = getConnection();
            _ps = _con.prepareStatement(str);

            for (int counter = 0; counter < size; counter++) {
                _ps.setString(1, readApprovedCandidateList.get(counter).getBatchId());
                _ps.setString(2, readApprovedCandidateList.get(counter).getCandidateID());
                _ps.setString(3, readApprovedCandidateList.get(counter).getCandidateName());
                _ps.setString(4, readApprovedCandidateList.get(counter).getSex());
                _ps.setString(5, "APP");
                _ps.setString(6, "BIRUK");
                _ps.setString(7, "TODAY");
                _ps.addBatch();
            }
            _ps.executeBatch();

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int insertCandidateInfo(HashMap candidateInformation) {

        String str = " INSERT INTO hr_candidate(" +
                "CANDIDATE_ID," +
                "candidate_F_Name, " +
                "candidate_M_Name, " +
                "candidate_L_Name," +
                "DATEOFBIRTH," +
                "GENDER," +
                "recruit_Batch_Code, " +
                "JOBTYPE, " +
                "email, " +
                "telephone_mobile, " +
                "officetelephone," +
                "telephoneresidence," +
                "residentialaddress," +
                "total_Number_Of_Pages )" +
                "values(CANDIDATE_SEQ.NEXTVAL,?,?,?,?,?,?,?,?,?,?,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);

            _ps.setString(1, candidateInformation.get("firstName").toString());
            _ps.setString(2, candidateInformation.get("midelName").toString());
            _ps.setString(3, candidateInformation.get("lastName").toString());
            _ps.setString(4, candidateInformation.get("dateOfBirth").toString());
            _ps.setString(5, candidateInformation.get("gender").toString());
            _ps.setString(6, candidateInformation.get("bachCode").toString());
            _ps.setString(7, candidateInformation.get("jobType").toString());
            _ps.setString(8, candidateInformation.get("email").toString());
            _ps.setString(9, candidateInformation.get("mobile").toString());
            _ps.setString(10, candidateInformation.get("officeTelephone").toString());
            _ps.setString(11, candidateInformation.get("telResidence").toString());
            _ps.setString(12, candidateInformation.get("residentialAddress").toString());
            _ps.setString(13, candidateInformation.get("noofPage").toString());
             return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public int saveSelectionCrtira(String bachID, String cgpa, String gender, String workExp, int noOfCandidates, String ageMin, String ageMax, String orderBy) {
        String sql = "INSERT " +
                "  INTO HR_CRITERIA_SET " +
                "  ( " +
                "    CRITERIA_ID, " +
                "    BATCH_ID, " +
                "    CGPA," +
                "    GENDER, " +
                "    WORK_EXP, " +
                "    NEEDED_NO, " +
                "    AGE_MIN, " +
                "    AGE_MAX, " +
                "    ORDER_BY " +
                "  ) " +
                "  VALUES " +
                "  ( HR_SETCRITERA_SEQ.NEXTVAL," +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(sql);
            _ps.setString(1, bachID);
            _ps.setString(2, cgpa);
            _ps.setString(3, gender);
            _ps.setString(4, workExp);
            _ps.setInt(5, noOfCandidates);
            _ps.setString(6, ageMin);
            _ps.setString(7, ageMax);
            _ps.setString(8, orderBy);
            return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public HashMap readSelectionParameter(String bachID) throws SQLException {
        String qry = "SELECT * FROM HR_CRITERIA_SET WHERE BATCH_ID='" + bachID + "'";
        HashMap data = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs != null) {
                data = new HashMap();
                if (_rs.next()) {
                    data.put("bachID", _rs.getString("BATCH_ID"));
                    data.put("cgpa", _rs.getString("CGPA"));
                    data.put("workexp", _rs.getString("WORK_EXP"));
                    data.put("gender", _rs.getString("GENDER"));
                    data.put("needNO", _rs.getString("NEEDED_NO"));
                    data.put("agemin", _rs.getString("AGE_MIN"));
                    data.put("ageMax", _rs.getString("AGE_MAX"));
                    data.put("orderBy", _rs.getString("ORDER_BY"));

                }

            }
            return data;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    public ResultSet readAllExpiranceBackGround(int newCandidateID) throws SQLException {

        String qry = "SELECT CE.*, " +
                "  CA.candidate_f_name, " +
                "  CA.candidate_m_name, " +
                "  CA.candidate_l_name " +
                "FROM HR_CANDIDATE_EXPERIENCE CE, " +
                "  hr_candidate CA " +
                "WHERE CE.CANDIDATE_ID='" + newCandidateID + "' " +
                "AND CA.candidate_id  =CE.CANDIDATE_ID " +
                "ORDER BY start_date asc";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;

        } finally {

            releaseResources();

        }
    }

    public ResultSet readAllEducationBackGround(int newCandidateID) throws SQLException {


        String qry = "SELECT CE.*, " +
                "  CA.candidate_f_name, " +
                "  CA.candidate_m_name, " +
                "  CA.candidate_l_name " +
                " FROM HR_CANDIDATE_EDUCATION CE, " +
                "  hr_candidate CA " +
                " WHERE CE.CANDIDATE_ID='" + newCandidateID + "' " +
                " AND CA.candidate_id  =CE.CANDIDATE_ID " +
                " ORDER BY GRADUATION_YEAR DESC";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;

        } finally {

            releaseResources();

        }
    }

    public ResultSet readAllCandidateList(String bachID) throws SQLException {
        String qry = " SELECT CANDIDATE_ID, " +
                "  CANDIDATE_F_NAME, " +
                "  CANDIDATE_M_NAME, " +
                "  CANDIDATE_L_NAME, " +
                "  GENDER " +
                " FROM HR_CANDIDATE " +
                " WHERE recruit_batch_code='" + bachID + "' order by CANDIDATE_F_NAME ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;

        } finally {

            releaseResources();

        }
    }

//biruk
    public int updateCandidateInfo(HashMap candidateInformation) {

        String str = "UPDATE " +
                "             hr_candidate " +
                "    SET    " +
                "           candidate_F_Name=?, " +
                "           candidate_M_Name=?, " +
                "           candidate_L_Name=?," +
                "           DATEOFBIRTH=?," +
                "           GENDER=?," +
                "           recruit_Batch_Code=?, " +
                "           JOBTYPE=?," +
                "           email=?," +
                "           telephone_mobile=?, " +
                "           officetelephone=?," +
                "           telephoneresidence=?," +
                "           residentialaddress=?," +
                "           total_Number_Of_Pages=?" +                             
                 "    WHERE  CANDIDATE_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, candidateInformation.get("firstName").toString());
            _ps.setString(2, candidateInformation.get("midelName").toString());
            _ps.setString(3, candidateInformation.get("lastName").toString());
            _ps.setString(4, candidateInformation.get("dateOfBirth").toString());
            _ps.setString(5, candidateInformation.get("gender").toString());
            _ps.setString(6, candidateInformation.get("bachCode").toString());
            _ps.setString(7, candidateInformation.get("jobType").toString());
            _ps.setString(8, candidateInformation.get("email").toString());
            _ps.setString(9, candidateInformation.get("mobile").toString());
            _ps.setString(10, candidateInformation.get("officeTelephone").toString());
            _ps.setString(11, candidateInformation.get("telResidence").toString());
            _ps.setString(12, candidateInformation.get("residentialAddress").toString());          
            _ps.setString(13, candidateInformation.get("noofPage").toString());
            _ps.setInt(14, Integer.parseInt(candidateInformation.get("candidateID").toString()));
            return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    /**
     * this function updated the satus of candidates
     * from employee status to PermanentEmployee
     * @param candidateId
     * @return
     */
    public int updateCandidate(String candidateId, String employeeID) {
        String select = "UPDATE hr_candidate set EMPLOYMENTID=" + employeeID + " where  CANDIDATE_ID =?";
        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(select);
//             _ps.setInt(1, Integer.parseInt(this.getCandidateID()));
//            _ps.setInt(1, Integer.parseInt(this.getCandidateID()));
            return 0;//_ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

        return 0;
    }

    public int deleteCandidate(String candidateId) {
        String select = "delete  from hr_candidate where  CANDIDATE_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, Integer.parseInt(candidateId));
            return _ps.executeUpdate();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

        return 0;
    }

    public boolean DeleteCandidateEducation(int educationID) {
         String select = "delete  from HR_CANDIDATE_EDUCATION where  HR_CAN_EDUC_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1,educationID);
            _ps.executeUpdate();
            return true;
        } catch (Exception ex) 
        {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

         //return true;

       
    }

    public HashMap readCandidateForRegistration(String id) {

        String select = "SELECT " +
                "                 hr_candidate.candidate_id," +
                "                 hr_candidate.candidate_f_name," +
                "                 hr_candidate.candidate_l_name," +
                "                 hr_candidate.candidate_m_name," +
                "                 hr_candidate.dateofbirth," +
                "                 hr_candidate.gender,                          " +
                "                 hr_candidate.jobtype," +
                "                 hr_candidate.recruit_batch_code," +
                "                 hr_lu_job_type.type," +
                "                 hr_recruitment_request.RECRUIT_REQUEST_TYPE ," +
                "                 hr_recruitment_request.requester_id   " +
                "    FROM         hr_candidate," +
                "                 hr_lu_job_type," +
                "                 hr_recruitment_request" +
                "    WHERE        CANDIDATE_ID=" + id + " " +
                "                 And hr_lu_job_type.job_code=hr_candidate.jobtype " +
                "                 And  hr_recruitment_request.recruit_batch_code=hr_candidate.recruit_batch_code";

        HashMap candidateList = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                candidateList.put("candidateFname", ocrs.getString("CANDIDATE_F_NAME"));
                candidateList.put("candidateMidelName", ocrs.getString("CANDIDATE_M_NAME"));
                candidateList.put("candidateLastName", ocrs.getString("CANDIDATE_L_NAME"));
                candidateList.put("gender", ocrs.getString("GENDER"));
                candidateList.put("dateofbirth", ocrs.getString("dateofbirth"));
                candidateList.put("jobtype", ocrs.getString("jobtype"));
                candidateList.put("type", ocrs.getString("type"));
                candidateList.put("recruitemntType", ocrs.getString("RECRUIT_REQUEST_TYPE"));
                candidateList.put("requester_id", ocrs.getString("requester_id"));


                return candidateList;
            } else {

                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap selectCandidate(String id) {
        String select = "select * from hr_candidate where CANDIDATE_ID='" + id + "'";
        HashMap candidateList = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            //  _ps.setInt(1, Integer.parseInt(id));
            _rs = _ps.executeQuery();
            if (_rs.next()) {

                candidateList.put("CANDIDATE_F_NAME", _rs.getString("CANDIDATE_F_NAME"));
                candidateList.put("CANDIDATE_M_NAME", _rs.getString("CANDIDATE_M_NAME"));
                candidateList.put("CANDIDATE_L_NAME", _rs.getString("CANDIDATE_L_NAME"));
                candidateList.put("TELEPHONE_MOBILE", _rs.getString("TELEPHONE_MOBILE")== null ? "Unknown" : _rs.getString("TELEPHONE_MOBILE"));
                candidateList.put("TELEPHONERESIDENCE", _rs.getString("TELEPHONERESIDENCE")== null ? "Unknown" : _rs.getString("TELEPHONERESIDENCE"));
                candidateList.put("EMAIL", _rs.getString("EMAIL")== null ? "Unknown" : _rs.getString("EMAIL"));
                candidateList.put("RECRUIT_BATCH_CODE", _rs.getString("RECRUIT_BATCH_CODE"));
                candidateList.put("TOTAL_NUMBER_OF_PAGES", _rs.getString("TOTAL_NUMBER_OF_PAGES")== null ? "Unknown" : _rs.getString("TOTAL_NUMBER_OF_PAGES"));
                candidateList.put("CGPA", _rs.getString("CGPA"));
                candidateList.put("EXPERIENCE", _rs.getString("EXPERIENCE")== null ? "Unknown" : _rs.getString("EXPERIENCE"));
                candidateList.put("GENDER", _rs.getString("GENDER")== null ? "Unknown" : _rs.getString("GENDER"));
                candidateList.put("DATEOFBIRTH", _rs.getString("DATEOFBIRTH")== null ? "Unknown" : _rs.getString("DATEOFBIRTH"));
                candidateList.put("LEVELOFEDUCATION", _rs.getString("LEVELOFEDUCATION"));
                candidateList.put("JOBTYPE", _rs.getString("JOBTYPE")== null ? "Unknown" : _rs.getString("JOBTYPE"));
                candidateList.put("OFFICETELEPHONE", _rs.getString("OFFICETELEPHONE")== null ? "Unknown" : _rs.getString("OFFICETELEPHONE"));
                candidateList.put("DATEOFBIRTH", _rs.getString("DATEOFBIRTH")== null ? "Unknown" : _rs.getString("DATEOFBIRTH"));
                candidateList.put("RESIDENTIALADDRESS", _rs.getString("RESIDENTIALADDRESS")== null ? "Unknown" : _rs.getString("RESIDENTIALADDRESS"));
                candidateList.put("YEAROFGRADUATION", _rs.getString("YEAROFGRADUATION"));
                candidateList.put("GRADUATEDBY", _rs.getString("GRADUATEDBY"));
               // candidateList.put("HR_CAN_EDUC_ID", _rs.getString("HR_CAN_EDUC_ID"));
                return candidateList;
            } else {
                return null;
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }


    }

    public HashMap selectCandidateForEmployemnt(String id) {
        String select = "select * from hr_candidate where CANDIDATE_ID='" + id + "'";
        HashMap candidateList = new HashMap();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            //  _ps.setInt(1, Integer.parseInt(id));
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                candidateList.put("CANDIDATE_F_NAME", _rs.getString("CANDIDATE_F_NAME"));
                candidateList.put("CANDIDATE_M_NAME", _rs.getString("CANDIDATE_M_NAME"));
                candidateList.put("CANDIDATE_L_NAME", _rs.getString("CANDIDATE_L_NAME"));
                candidateList.put("GENDER", _rs.getString("GENDER"));
                candidateList.put("DATEOFBIRTH", _rs.getString("DATEOFBIRTH"));
                candidateList.put("JOBTYPE", _rs.getString("JOBTYPE"));
                return candidateList;
            } else {

                return null;
            }


        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }


    }

    public ResultSet searchEmployeeNametoAuto() {



        String qry = "SELECT CANDIDATE_F_NAME,CANDIDATE_M_NAME,CANDIDATE_L_NAME,CANDIDATE_ID FROM HR_CANDIDATE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
          //  _rs.close();
            return ocrs;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap readCandidateExamResult(String candidateID) {



        HashMap readCandidateResult = new HashMap();
        String qry = "SELECT " +
                "           nvl(WRITTEN_EXAM_RESULT,'0') as WRITTEN_EXAM_RESULT ," +
                "           nvl(INTERVIEW_EXAM_RESULT,'0') as INTERVIEW_EXAM_RESULT ," +
                "           nvl(PRACTICAL_EXAM_RESULT ,'0') as PRACTICAL_EXAM_RESULT ," +
                "           nvl(OTHER,'0') as OTHER ," +
                "           nvl(RECOMMENDATION,'writer u remark Here') as RECOMMENDATION " +
                "     FROM " +
                "           HR_CANDIDATE " +
                "     WHERE  CANDIDATE_ID=" + candidateID + "";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
//            _ps.setString(1, candidateID);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            //_rs.close();

            if (ocrs.next()) {


                readCandidateResult.put("WRITTEN_EXAM_RESULT", ocrs.getString("WRITTEN_EXAM_RESULT"));
                readCandidateResult.put("INTERVIEW_EXAM_RESULT", ocrs.getString("INTERVIEW_EXAM_RESULT"));
                readCandidateResult.put("PRACTICAL_EXAM_RESULT", ocrs.getString("PRACTICAL_EXAM_RESULT"));
                readCandidateResult.put("OTHER", ocrs.getString("OTHER"));
                readCandidateResult.put("RECOMMENDATION", ocrs.getString("RECOMMENDATION"));

            }
            return readCandidateResult;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        }

    }

    public ResultSet readCandidateList(String batchCode) {
        try {

            //  HashMap[] candidateList = new HashMap[];
            String candidateId;
            int i = 0;
            String query = " SELECT DISTINCT CC.CANDIDATE_ID, " +
                    "  NVL(CA.WRITTENPERCENTAGE,'0') AS WRITTENPERCENTAGE, " +
                    "  NVL(CA.INTERVIEWRESULT,'0')   AS INTERVIEWRESULT, " +
                    "  NVL(CA.PRACTICALRESULT,'0')   AS PRACTICALRESULT, " +
                    "  CC.CANDIDATE_F_NAME, " +
                    "  CC.CANDIDATE_M_NAME, " +
                    "  CC.CANDIDATE_L_NAME, " +
                    "  CC.GENDER, " +
                    "  WRITTENPERCENTAGE+INTERVIEWRESULT+PRACTICALRESULT AS total " +
                    "  FROM HR_EXAM_PERCENTAGE CA, " +
                    "  HR_CANDIDATE CC " +
                    "  WHERE CA.BATCHCODE=CC.CANDIDATE_ID " +
                    "  AND CC.RECRUIT_BATCH_CODE=?";


            _con = getConnection();
            _ps = _con.prepareStatement(query);
            _ps.setString(1, batchCode);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            //  _rs.close();
            // candidateList = new HashMap[this.countCandidate(batchCode, sql)];

            return _rs;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {

                releaseResources();
            } catch (Exception ignore) {
            }

        }


    }

    public HashMap[] readCandidateListForExame(String batchCode, String reqId, String sql) {

        HashMap[] candidateList = null;
        String candidateId;
        int i = 0;
        //to populate the table based on the criteria selected from the drop down
        String str = "SELECT distinct " +
                "CA.CANDIDATE_ID, " +
                "LEVELOFEDUCATION,HR_LU_EDUC_LEVEL.DESCRIPTION, " +
                "CA.CGPA,     " +
                " NVL(CA.EXPERIENCE,'0') AS EXPERIENCE, " +
                "  NVL(CA.STATUS,'candidate') AS STATUS , " +
                "   CA.GENDER, " +
                "    CA.DATEOFBIRTH, " +
                "     NVL(CA.FOR_EXAM,'0') AS FOR_EXAM, " +
                "      CX.EXP_RELATION_TYPE " +
                "FROM " +
                "      HR_CANDIDATE CA, HR_CANDIDATE_EXPERIENCE CX,  " +
                "       HR_LU_EDUC_LEVEL  " +
                "WHERE  CA.LEVELOFEDUCATION=HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE AND CX.CANDIDATE_ID = CA.CANDIDATE_ID AND recruit_Batch_Code=? " + sql + " ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, batchCode);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();

            candidateList = new HashMap[this.countCandidate(batchCode, sql)];
            while (ocrs.next()) {
                candidateList[i] = new HashMap();
                candidateList[i].put("cgpa", ocrs.getString("CGPA"));
                candidateList[i].put("experience", ocrs.getString("experience"));
                candidateList[i].put("status", ocrs.getString("status"));
                candidateList[i].put("GENDER", ocrs.getString("GENDER"));
                candidateList[i].put("DATEOFBIRTH", ocrs.getString("DATEOFBIRTH"));
                candidateId = Integer.toString(ocrs.getInt("CANDIDATE_ID"));
                candidateList[i].put("CANDIDATE_ID", candidateId);
                candidateList[i].put("FOR_EXAM", ocrs.getString("FOR_EXAM"));
                candidateList[i].put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                i++;

            }
            return candidateList;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }
    }

    public int countCandidate(String bachCode, String sql) {
        int subPos = sql.indexOf("order by");
        if (subPos > 0) {
            sql = sql.substring(0, subPos);
        }

        String count = "SELECT max(rownum) as num from hr_candidate CA, HR_CANDIDATE_EXPERIENCE CX where  recruit_Batch_Code=? " + sql + "";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(count);
            _ps.setString(1, bachCode);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                return ocrs.getInt("num");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

        return 0;
    }

    public float maximumeCandidateGpa(String bachCode, String sql) {
        int subPos = sql.indexOf("order by");

        if (subPos > 0) {
            sql = sql.substring(0, subPos);
        }
        String count = "SELECT to_number(max(cgpa)) as num from hr_candidate CA, " +
                "HR_CANDIDATE_EXPERIENCE CX where  recruit_Batch_Code=? " + sql + "";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(count);
            _ps.setString(1, bachCode);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                return ocrs.getFloat("num");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

        return 0;
    }

    public boolean approveCadidateInfo(ArrayList<HashMap> candidateID, String approvedBY) {
        String update = "UPDATE hr_candidate set APPROVE='Approved' where CANDIDATE_ID=?";
        Savepoint savePoint = null;

        boolean checkSave = true;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            savePoint = _con.setSavepoint("SAVE_POINT");
            if (candidateID.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                for (HashMap hm : candidateID) {//loop over the attached file
                    update = "UPDATE hr_candidate   set APPROVE='Approved' , APPROVEBY=" + approvedBY + "" +
                            " where CANDIDATE_ID=" + Integer.parseInt(hm.get("canidateId").toString()) + "";
                    _ps = _con.prepareStatement(update);
                    //   ps.setString(1, hm.get("canidateId").toString());
                    if (_ps.executeUpdate() != 1) {
                        checkSave = false;
                        break;
                    }
                }
                if (checkSave) {
                    _con.commit();
                    return true;
                } else {
                    _con.rollback(savePoint);
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
        return false;

    }

    public boolean selectCadidateInfo(ArrayList<HashMap> candidateID, String approvedBY) {
        String update = "UPDATE hr_candidate set APPROVE='Approved' where CANDIDATE_ID=?";
        Savepoint savePoint = null;
        boolean checkSave = true;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            savePoint = _con.setSavepoint("SAVE_POINT");
            if (candidateID.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                for (HashMap hm : candidateID) {//loop over the attached file
                    update = "UPDATE hr_candidate   set FOR_EXAM='1' where CANDIDATE_ID='" + Integer.parseInt(hm.get("canidateId").toString()) + "'";
                    _ps = _con.prepareStatement(update);
                    if (_ps.executeUpdate() != 1) {
                        checkSave = false;
                        break;
                    }
                }
                if (checkSave) {
                    _con.commit();
                    return true;
                } else {
                    _con.rollback(savePoint);
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
        return false;

    }

    public boolean certifyCadidateInfo(ArrayList<HashMap> candidateID, String certifyBY) {
        String update = "UPDATE hr_candidate set APPROVE='Approved' where CANDIDATE_ID=?";

        Savepoint savePoint = null;

        boolean checkSave = true;
        try {
            _con = getConnection();
            _con.setAutoCommit(false);
            savePoint = _con.setSavepoint("SAVE_POINT");
            if (candidateID.size() > 0) {//check the supportive information attached have a value that is greater than 0.
                for (HashMap hm : candidateID) {//loop over the attached file
                    update = "UPDATE hr_candidate   set STATUS='Employee',CERTIFY='certify' , CERTIFYBY=" + certifyBY + "" +
                            " where CANDIDATE_ID=" + Integer.parseInt(hm.get("canidateId").toString()) + "";
                    _ps = _con.prepareStatement(update);
                    //   ps.setString(1, hm.get("canidateId").toString());
                    if (_ps.executeUpdate() == 0) {
                        checkSave = false;
                        break;
                    }
                }
                if (checkSave) {
                    _con.commit();
                    return true;
                } else {
                    _con.rollback(savePoint);
                    return false;
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
        return false;

    }

    public int selectCandidateInf(String canidateId) {

        String update = "UPDATE hr_candidate set STATUS='Employee' where CANDIDATE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(update);
            _ps.setInt(1, Integer.parseInt(canidateId));
            return _ps.executeUpdate();


        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }


    }

    public int saveCandidateExamResult(HashMap examResult) {
        String update = "UPDATE" +
                "     hr_candidate " +
                "SET " +
                "     WRITTEN_EXAM_RESULT=?, " +
                "     INTERVIEW_EXAM_RESULT=?, " +
                "     PRACTICAL_EXAM_RESULT=?, " +
                "     RECOMMENDATION=?, " +
                "     OTHER=? " +
                "where CANDIDATE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(update);
            _ps.setString(1, examResult.get("writtenExam").toString());
            _ps.setString(2, examResult.get("interview").toString());
            _ps.setString(3, examResult.get("practical").toString());
            _ps.setString(4, examResult.get("recommendation").toString());
            _ps.setString(5, examResult.get("other").toString());
            _ps.setInt(6, Integer.parseInt(examResult.get("candidateId").toString()));
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public ArrayList<CandidateEntity> readCandidateID() {
        String _select = "SELECT CANDIDATE_ID FROM hr_candidate";



        ArrayList<CandidateEntity> employeesID = new ArrayList<CandidateEntity>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.executeQuery();
            _rs = _ps.getResultSet();
            while (_rs.next()) {
                CandidateEntity empIDs = new CandidateEntity(Integer.toString(_rs.getInt("CANDIDATE_ID")));
                employeesID.add(empIDs);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
        return employeesID;
    }

    public String createNewCandidateID() {
        int maximum = 0;
        try {

            CandidateEntity candidatesPage = new CandidateEntity();
            ArrayList<CandidateEntity> employeeid = this.readCandidateID();
            if (employeeid != null) {
                int newemployeeid[] = new int[employeeid.size()];
                for (int i = 0; i < employeeid.size(); i++) {
                    candidatesPage = employeeid.get(i);
                    newemployeeid[i] = Integer.parseInt(candidatesPage.getCandidateID());
                }
                maximum = newemployeeid[0];   // start with the first value
                for (int i = 1; i < newemployeeid.length; i++) {
                    if (newemployeeid[i] > maximum) {
                        maximum = newemployeeid[i];   // new maximum
                    }
                }
                maximum += 1;

            } else {
                maximum = 1;
            }
            this.setCandidateID(Integer.toString(maximum));
            //end method max

            return Integer.toString(maximum);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;

        }
    }

    public ArrayList<CandidateEntity> selectJobType(String batchCode) {
        String _select = " SELECT " +
                "        hr_lu_job_type. job_Code," +
                "        hr_lu_job_type.JOB_NAME " +
                " FROM " +
                "        hr_recruitment_request , " +
                "        hr_lu_job_type," +
                "        HR_RECRUITMENT_REQUEST_STATUS " +
                " WHERE " +
                "        hr_recruitment_request.job_Code= hr_lu_job_type.job_Code  AND" +
                "        hr_recruitment_request.RECRUIT_REQUEST_ID = HR_RECRUITMENT_REQUEST_STATUS.RECRUIT_REQUEST_ID AND" +
                "        HR_RECRUITMENT_REQUEST_STATUS.ADVERTISE=1 AND HR_RECRUITMENT_REQUEST_STATUS.APPROVE=1 AND" +
                "        hr_recruitment_request.recruit_batch_code ='" + batchCode + "'";

        ArrayList<CandidateEntity> requests = new ArrayList<CandidateEntity>();


        ResultSet _rs;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                CandidateEntity read = new CandidateEntity(_rs.getString("job_Code"), _rs.getString("JOB_NAME"));
                requests.add(read);
            }

            return requests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public boolean insertExamPresentage(HashMap promotionAssessmentPrecentage) {
        boolean checkSave = false;
        Connection _con;
        PreparedStatement ps = null;
        String str = "INSERT INTO HR_EXAM_PERCENTAGE(" +
                "ID," +
                " WRITTENPERCENTAGE," +
                " INTERVIEWRESULT," +
                " PRACTICALRESULT," +
                " GPAPERCENTAGE, " +
                "BATCHCODE,BATCHJOB" +
                ")" +
                " values(HR_REQ_EXAM_SEQ.NEXTVAL," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?," +
                "?)";
        try {
            _con = getConnection();
            ps = _con.prepareStatement(str);
            ps.setString(1, promotionAssessmentPrecentage.get("writtenpercentage").toString());
            ps.setString(2, promotionAssessmentPrecentage.get("interviewpercentage").toString());
            ps.setString(3, promotionAssessmentPrecentage.get("presentationpercentage").toString());
            ps.setString(4, promotionAssessmentPrecentage.get("otherpercentage").toString());
            ps.setString(5, promotionAssessmentPrecentage.get("candidateID").toString());
            ps.setString(6, promotionAssessmentPrecentage.get("batchCode").toString());
            if (ps.executeUpdate() > 0) {
                checkSave = true;
            }
            ps.close();
            closePooledConnections(_con);
            return checkSave;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public int updateExamPresentage(HashMap examPresentage) {

        String str = "UPDATE HR_EXAM_PERCENTAGE   " +
                "              SET        " +
                "               WRITTENPERCENTAGE =?, " +
                "               PRACTICALPERCENTAGE=?, " +
                "               INTERVIEWPERCENTAGE=?," +
                "               GPAPERCENTAGE=? " +
                " WHERE         BATCHCODE=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, examPresentage.get("writtenprcentage").toString());
            _ps.setString(2, examPresentage.get("practicalpercentage").toString());
            _ps.setString(3, examPresentage.get("interviewpercentage").toString());
            _ps.setString(4, examPresentage.get("gpapercentage").toString());
            _ps.setString(5, examPresentage.get("batchCode").toString());
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {

                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    public HashMap selectExamPresentage(String batchCode) {



        HashMap readExamPresentage = null;
        String qry = "SELECT " +
                "          nvl(WRITTENPERCENTAGE,'0') as WRITTENPERCENTAGE," +
                "          nvl(PRACTICALRESULT,'0') as PRACTICALPERCENTAGE," +
                "           nvl(INTERVIEWRESULT,'0') as INTERVIEWPERCENTAGE," +
                "           nvl(GPAPERCENTAGE,'0') as GPAPERCENTAGE ," +
                "           BATCHCODE " +
                "     FROM " +
                "           HR_EXAM_PERCENTAGE " +
                "     WHERE  BATCHCODE='" + batchCode + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            if (ocrs.next()) {
                readExamPresentage = new HashMap();
                readExamPresentage.put("writtenprcentage", ocrs.getString("WRITTENPERCENTAGE"));
                readExamPresentage.put("practicalpercentage", ocrs.getString("PRACTICALRESULT"));
                readExamPresentage.put("interviewpercentage", ocrs.getString("INTERVIEWRESULT"));
                readExamPresentage.put("gpapercentage", ocrs.getString("GPAPERCENTAGE"));
                readExamPresentage.put("batchCode", ocrs.getString("BATCHCODE"));
                return readExamPresentage;
            } else {
                return null;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                _ps.close();
                _con.close();
            } catch (Exception ignore) {
            }

        }
    }

    public int deleteExamPresentage(String batchCode) {

        String select = "DELETE HR_EXAM_PERCENTAGE  WHERE  BATCHCODE='" + batchCode + "'";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }

    }

    /**
     * this function updated the satus of candidates
     * from employee status to PermanentEmployee
     * @param candidateId
     * @return
     */
    public int updateCandidateListStatus(String candidateId) {

        String select = "UPDATE hr_candidate set STATUS='Permanent' where  CANDIDATE_ID =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, Integer.parseInt(this.getCandidateID()));
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public int updateRequestStatus(int recruitmentRequestId) {

        String select = "UPDATE HR_RECRUITMENT_REQUEST_STATUS set FILTERCANDIDATEFOREXAM='2' where  REQUEST =?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(select);
            _ps.setInt(1, recruitmentRequestId);
            return _ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }

        }
    }

    public HashMap readFinalSelectedCandidate(String cribatchId, String cricgpa, String criworkexp, String crigender, String crineededNo, String criageMin, String criageMax, String criorderBY) {
        HashMap finCandidateList = new HashMap();
        return finCandidateList;
    }

    public HashMap[] readCandidateListForExame(String batchCode, String sql) {

        HashMap[] candidateList = null;
        String candidateId;
        int i = 0;
        //to populate the table based on the criteria selected from the drop down
        String str = "SELECT distinct " +
                "CA.CANDIDATE_ID, " +
                "LEVELOFEDUCATION,HR_LU_EDUC_LEVEL.DESCRIPTION AS DESCRIPTION, " +
                "CA.CGPA,     " +
                " NVL(CA.EXPERIENCE,'0') AS EXPERIENCE, " +
                "  NVL(CA.STATUS,'candidate') AS STATUS , " +
                "   CA.GENDER, " +
                "    CA.DATEOFBIRTH, " +
                "     NVL(CA.FOR_EXAM,'0') AS FOR_EXAM, " +
                "      CX.EXP_RELATION_TYPE " +
                "FROM " +
                "      HR_CANDIDATE CA, HR_CANDIDATE_EXPERIENCE CX,  " +
                "       HR_LU_EDUC_LEVEL  " +
                "WHERE  CA.LEVELOFEDUCATION=HR_LU_EDUC_LEVEL.EDUC_LEVEL_CODE AND CX.CANDIDATE_ID = CA.CANDIDATE_ID AND recruit_Batch_Code=? " + sql + " ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(str);
            _ps.setString(1, batchCode);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            candidateList = new HashMap[this.countCandidate(batchCode, sql)];
            while (ocrs.next()) {
                candidateList[i] = new HashMap();
                candidateList[i].put("cgpa", ocrs.getString("CGPA"));
                candidateList[i].put("experience", ocrs.getString("experience"));
                candidateList[i].put("status", ocrs.getString("status"));
                candidateList[i].put("GENDER", ocrs.getString("GENDER"));
                candidateList[i].put("DATEOFBIRTH", ocrs.getString("DATEOFBIRTH"));
                candidateId = Integer.toString(ocrs.getInt("CANDIDATE_ID"));
                candidateList[i].put("CANDIDATE_ID", candidateId);
                candidateList[i].put("FOR_EXAM", ocrs.getString("FOR_EXAM"));
                candidateList[i].put("DESCRIPTION", ocrs.getString("DESCRIPTION"));
                i++;

            }
            return candidateList;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ignore) {
            }
        }
    }

    public HashMap[] readEducation(String candidateId) {
        Connection _conn;
        ResultSet rsExper;
        int i = 0;
        HashMap[] _list = null;
        String select = " SELECT DISTINCT * FROM HR_CANDIDATE_EDUCATION WHERE CANDIDATE_ID=? ";
        try {
            _conn = getConnection();
            _ps = _conn.prepareStatement(select);
            _ps.setString(1, candidateId);
            rsExper = _ps.executeQuery();

            OracleResultSetMetaData count = (OracleResultSetMetaData) rsExper.getMetaData();
            _list = new HashMap[count.getColumnCount()];

            while (rsExper.next()) {
                _list[i] = new HashMap();
                _list[i].put("STATUS", rsExper.getString("STATUS"));
                _list[i].put("CANDIDATE_ID", rsExper.getString("CANDIDATE_ID"));
                _list[i].put("INSTUTION", rsExper.getString("INSTUTION") == null ? "" : rsExper.getString("INSTUTION"));
                _list[i].put("CGPA", rsExper.getString("CGPA") == null ? "" : rsExper.getString("CGPA"));
                _list[i].put("FILED_OF_STUDY", rsExper.getString("FILED_OF_STUDY"));
                _list[i].put("FILED_OF_CATAGORY", rsExper.getString("FILED_OF_CATAGORY") == null ? "" : rsExper.getString("FILED_OF_CATAGORY"));
                _list[i].put("GRADUATION_YEAR", rsExper.getString("GRADUATION_YEAR"));
                _list[i].put("CAN_EDUC_ID", rsExper.getString("CAN_EDUC_ID") == null ? "" : rsExper.getString("CAN_EDUC_ID"));
                _list[i].put("Education_ID", (rsExper.getInt("HR_CAN_EDUC_ID")));
                i++;
            }

            return _list;

        } catch (Exception e) {
            e.printStackTrace();

            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countEducation(String candidateId) {
        String count = " SELECT Max(rownum)as num  from HR_CANDIDATE_EDUCATION WHERE CANDIDATE_ID=? ";
        Connection _conn;
        ResultSet rsEducation;
        int rownum;

        try {
            _conn = getConnection();
            _ps = _conn.prepareStatement(count);
            _ps.setString(1, candidateId);
            rsEducation = _ps.executeQuery();
            rsEducation.next();
            rownum = rsEducation.getInt("num");
            return rownum;
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }
}
