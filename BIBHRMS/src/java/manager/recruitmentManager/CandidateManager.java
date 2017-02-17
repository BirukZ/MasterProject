/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;
import entity.recruitmentEntity.CandidateEntity;
import fphrms.EmployeeList;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
import manager.recruitmentManager.CandidateExperienceManager.CandidateEducationManager;

/**
 *
 * @author BravoZulu;
 */
public class CandidateManager {

    public CandidateManager() {
    }
    CandidateEntity candidateEntity = new CandidateEntity();
    String date;
    String approved;
    String certified;
    boolean certifedCandidate;
    private boolean selectedCandidate;
    String levelOfEducation;
    int candidateID;
    String fullName;
    boolean selected;
    boolean pass;

    public CandidateManager(int candidateID, String fullName, String totalResult, boolean chek,String batchJob) {
        this.candidateID=candidateID;
        this.fullName=fullName;
        this.totalResult=totalResult;
        this.selected=chek;
        this.batchCode=batchJob;
    }

    public boolean UpdateCandidateEducation(CandidateEducationManager saveExperiance)
    {
               CandidateEntity canEducation =new CandidateEntity(saveExperiance.getLeavelOFEducation(),
                saveExperiance.getCgpa(),saveExperiance.getInstiution(),
                saveExperiance.getFiledOfStudy(),
                saveExperiance.getGraduationYear(),saveExperiance.getCandidateID(),saveExperiance.getCanEducID());
             return candidateEntity.UpdateCandidateEducation(canEducation);

    }

    public boolean  deleteCandidateEducation(int educationID) {
     return  candidateEntity.DeleteCandidateEducation(educationID);

    }



    public boolean isPass() {
        return pass;
    }

    public void setPass(boolean pass) {
        this.pass = pass;
    }

    public CandidateManager(int candidateID) {
       this.candidateID=candidateID;
    }

    public CandidateManager(int candidateID, String fullName, String writenExam, String interview, String PracticalRe, float totalResult, String geneder) {

        this.candidateID=candidateID;
        this.fullName=fullName;
        this.writtenExam=writenExam;
        this.interview=interview;
        this.practical=PracticalRe;
        this.total=totalResult;
        this.gender=geneder;


    }

    public CandidateManager(String candidateID, String fullName, String writneExam, String interviewResult, String practicalResult, float totalResult, String gender) {
        this.candidateID=Integer.parseInt(candidateID);
        this.fullName=fullName;
        this.writtenExam=writneExam;
        this.interview=interviewResult;
        this.practical=practicalResult;
        this.total=totalResult;
        this.gender=gender;
    }

    public CandidateManager(String fullName, String candidateID, String gender, String writneExam, String interviewResult, String practicalResult, String totalResult ,boolean app,String batchJob) {
        this.candidateID=Integer.parseInt(candidateID);
        this.fullName=fullName;
        this.writtenExam=writneExam;
        this.interview=interviewResult;
        this.practical=practicalResult;
        this.totalResult=totalResult;
        this.gender=gender;
        this.pass=app;
        this.batchCode=batchJob;
    }
/////////////////////////////////////////////////////////////// Biruk//////////////////////////////////////
    public CandidateManager(int count, String levelOfEducation, String writtenExamResult, String interviewExamResult, String practicalExamResult, float total, String cgpa, String experience, int canId, String gender, int age, boolean selected, String status, String approve, String certifie, boolean certifedCandidate) {
        this.count = count;
        this.writtenExam = writtenExamResult;
        this.practical = practicalExamResult;
        this.interview = interviewExamResult;
        this.total = total;
        this.cgpa = cgpa;
        this.experience = experience;
        this.candidateID = canId;
        this.gender = gender;
        this.age = age;
        this.certifedCandidate = certifedCandidate;
        this.selected = selected;
        this.satus = status;
        this.approved = approve;
        this.certified = certifie;
        this.levelOfEducation = levelOfEducation;
    }

    public boolean PusheCandidateForExam(ArrayList<CandidateListForExam> finalSelectedCandidate) {
        return candidateEntity.PusheCandidateForExam(finalSelectedCandidate);
    }

//    public boolean PusheCandidateForExam(String canID, String fullName, String batchID) {
//        return candidateEntity.PusheCandidateForExam(canID,fullName,batchID);
//    }

    public boolean SaveCandidateForExam(ArrayList<CandidateListForExam> readApprovedCandidateList) {
        return candidateEntity.saveCandidateForExam(readApprovedCandidateList);
    }

    public HashMap SelectFiliterCritirea(String bachID) {

       try {
            return candidateEntity.readSelectionParameter(bachID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public HashMap SelectFinalCandidate(String cribatchId, String cricgpa, String criworkexp, String crigender, String crineededNo, String criageMin, String criageMax, String criorderBY) {
        try {
            return candidateEntity.readFinalSelectedCandidate(cribatchId,cricgpa,criworkexp,crigender,crineededNo,criageMin,criageMax,criorderBY);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
     public boolean PusheCandidateForEmployement(ArrayList<CandidateManager> lastSelectedCandiate) {
     return  candidateEntity.pusheCandidtaForEmployement(lastSelectedCandiate);
    }

    public ArrayList<CandidateListForExam> getAllCandidateForExam(String bachID) {
        try{
        ArrayList<CandidateListForExam> canadidateList=new ArrayList<CandidateListForExam>();
        ResultSet _rs=null;
        _rs=candidateEntity.readAllCandidateList(bachID);
         while (_rs.next())
         {

       CandidateListForExam candidateListForExam= new CandidateListForExam();
       candidateListForExam.setCandidateName(_rs.getString("CANDIDATE_F_NAME")+" "+_rs.getString("CANDIDATE_M_NAME")+" "+_rs.getString("CANDIDATE_L_NAME"));
       candidateListForExam.setCandidateID(_rs.getString("CANDIDATE_ID"));
       candidateListForExam.setSex(_rs.getString("GENDER"));
       canadidateList.add(candidateListForExam);

         }
        _rs.close();
         return canadidateList;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public ArrayList<CandidateListForExam> getAllEducationBack(int newCandidateID) {
         try{
        ArrayList<CandidateListForExam> canadidateList=new ArrayList<CandidateListForExam>();
        ResultSet _rs=null;
        _rs=candidateEntity.readAllEducationBackGround(newCandidateID);
         while (_rs.next())
         {

       CandidateListForExam candidateListForExam= new CandidateListForExam();
       candidateListForExam.setCandidateName(_rs.getString("CANDIDATE_F_NAME")+" "+_rs.getString("CANDIDATE_M_NAME")+" "+_rs.getString("CANDIDATE_L_NAME"));
       candidateListForExam.setCandidateID(_rs.getString("CANDIDATE_ID"));
       candidateListForExam.setCanEducationLevel(_rs.getString("FILED_OF_CATAGORY"));
       candidateListForExam.setCanEducationType(_rs.getString("FILED_OF_STUDY"));
       candidateListForExam.setCgpa((_rs.getFloat("CGPA")));
       candidateListForExam.setInstiutation(_rs.getString("INSTUTION"));
       candidateListForExam.setYearOfGraduation(_rs.getString("GRADUATION_YEAR"));
       canadidateList.add(candidateListForExam);

         }
        _rs.close();
         return canadidateList;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<CandidateListForExam> getAllExpiranceBack(int newCandidateID) {
          int  year= 0;
         
         try{
               int totalYear=0;
        ArrayList<CandidateListForExam> canadidateList=new ArrayList<CandidateListForExam>();
        ResultSet _rs=null;
       _rs=candidateEntity.readAllExpiranceBackGround(newCandidateID);
         
         
         while (_rs.next())
         {

       CandidateListForExam candidateListForExam= new CandidateListForExam();
       candidateListForExam.setCandidateName(_rs.getString("CANDIDATE_F_NAME")+" "+_rs.getString("CANDIDATE_M_NAME")+" "+_rs.getString("CANDIDATE_L_NAME"));
       candidateListForExam.setCandidateID(_rs.getString("CANDIDATE_ID"));
       candidateListForExam.setExpYear(_rs.getString("EXPDETAIL"));
       candidateListForExam.setExpMonth(_rs.getString("EXP_MONTH"));
       candidateListForExam.setExpDay(_rs.getString("EXP_DAY"));
       candidateListForExam.setOrgName(_rs.getString("INSTITUION"));
       candidateListForExam.setPosition(_rs.getString("JOB_TITLE"));
       candidateListForExam.setStartDate(_rs.getString("START_DATE"));
       candidateListForExam.setEndDate(_rs.getString("END_DATE"));
       candidateListForExam.setRelation(_rs.getString("EXP_RELATION_TYPE"));
       canadidateList.add(candidateListForExam);
                }
       _rs.close();
       
         return canadidateList;
        }catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    public int getCandidateID() {
        return candidateID;
    }

   
    public void setCandidateID(int candidateID) {
        this.candidateID = candidateID;
    }

    public boolean isSelectedCandidate() {
        return selectedCandidate;
    }

    public void setSelectedCandidate(boolean selectedCandidate) {
        this.selectedCandidate = selectedCandidate;
    }

    public CandidateEntity getCandidateEntity() {
        return candidateEntity;
    }

    public void setCandidateEntity(CandidateEntity candidateEntity) {
        this.candidateEntity = candidateEntity;
    }

    public boolean isCertifedCandidate() {
        return certifedCandidate;
    }

    public void setCertifedCandidate(boolean certifedCandidate) {
        this.certifedCandidate = certifedCandidate;
    }

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getCertified() {
        return certified;
    }

    public void setCertified(String certified) {
        this.certified = certified;
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

    public String getCanidateId() {
        return canidateId;
    }

    public void setCanidateId(String canidateId) {
        this.canidateId = canidateId;
    }

    public String getCgpa() {
        return cgpa;
    }

    public void setCgpa(String cgpa) {
        this.cgpa = cgpa;
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

    public String getSatus() {
        return satus;
    }

    public void setSatus(String satus) {
        this.satus = satus;
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
    String dateOfBirth;
    String email;
    String experience;
    String firstName;
    String interview;
    String lastName;
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
    String satus;
    float total;
    String totalResult;
    int age;
    int count;
   // boolean selected;

 
    public String getTotalResult() {
        return totalResult;
    }

    public void setTotalResult(String totalResult) {
        this.totalResult = totalResult;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public CandidateManager(String date,
            String dateOfBirth,
            String email,
            String experience,
            String firstName,
            String interview,
            String lastName,
            String levelOfEducation,
            String midelName,
            String mobile,
            String oficeTelephone,
            String practical,
            String recommendation,
            String telResidence,
            String batchCode,
            String gender,
            String candidateType,
            String other,
            String noPage,
            String writtenExam,
            String cgpa,
            String canidateId,
            String satus) {
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
        this.satus = satus;

    }
   // public boolean selected;

    public boolean isSelected() {
        return selected;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * <b>CandidateManager</b> It holds list of  candidate result
     * @param writtenExamResult
     * @param interviewExamResult
     * @param practicalExamResult
     * @param total
     * @param cgpa
     * @param experience
     * @param canId
     * @param gender
     * @param age
     * @param selected
     */
    public CandidateManager(int count, String levelOfEducation, String writtenExamResult, String interviewExamResult, String practicalExamResult, float total, String cgpa, String experience, String candidateId, String gender, int age, boolean selected, String status, String approve, String certifie, boolean certifedCandidate) {
        this.count = count;
        this.writtenExam = writtenExamResult;
        this.practical = practicalExamResult;
        this.interview = interviewExamResult;
        this.total = total;
        this.cgpa = cgpa;
        this.experience = experience;
        this.canidateId = candidateId;
        this.gender = gender;
        this.age = age;
        this.certifedCandidate = certifedCandidate;
        this.selected = selected;
        this.satus = status;
        this.approved = approve;
        this.certified = certifie;
        this.levelOfEducation = levelOfEducation;
    }

    public CandidateManager(String levelOfEducation, String writtenExamResult, String interviewExamResult, String practicalExamResult, float total, String cgpa, String experience, String canId, String gender, int age, boolean selected, String status, String approve, String certifie, boolean certifedCandidate) {
        this.writtenExam = writtenExamResult;
        this.practical = practicalExamResult;
        this.interview = interviewExamResult;
        this.total = total;
        this.cgpa = cgpa;
        this.experience = experience;
        this.canidateId = canId;
        this.gender = gender;
        this.age = age;
        this.certifedCandidate = certifedCandidate;
        this.selected = selected;
        this.satus = status;
        this.approved = approve;
        this.certified = certifie;
        this.levelOfEducation = levelOfEducation;
    }

    public CandidateManager(String levelOfEducation, String cgpa, String experience, String canId, String gender, int age, String certifie, boolean certifedCandidate) {

        this.cgpa = cgpa;
        this.experience = experience;
        this.canidateId = canId;
        this.gender = gender;
        this.age = age;
        this.selected = certifedCandidate;
        this.certified = certifie;
        this.levelOfEducation = levelOfEducation;
    }

    public CandidateManager(int count, String levelOfEducation, String cgpa, String experience, String canId, String gender, int age, String certifie, boolean certifedCandidate) {
        this.count = count;
        this.cgpa = cgpa;
        this.experience = experience;
        this.canidateId = canId;
        this.gender = gender;
        this.age = age;
        this.selected = certifedCandidate;
        this.certified = certifie;
        this.levelOfEducation = levelOfEducation;
    }

    public int grantCandidate(String candidateId) {
        return candidateEntity.selectCandidateInf(candidateId);
    }

    public boolean approveCandidate(ArrayList<HashMap> candidateInfo, String approvedBy) {
        return candidateEntity.approveCadidateInfo(candidateInfo, approvedBy);
    }

    public boolean selectCandidate(ArrayList<HashMap> candidateInfo, String approvedBy, int recruitmentRequestId) {

        if (candidateEntity.selectCadidateInfo(candidateInfo, approvedBy)) {
            candidateEntity.updateRequestStatus(recruitmentRequestId);
            return true;
        } else {
            return false;
        }
    }

    public boolean certifyCandidate(ArrayList<HashMap> candidateInfo, String certifyBy) {
        return candidateEntity.certifyCadidateInfo(candidateInfo, certifyBy);
    }

    public int UpdateCandidateInformation(HashMap updateList)
    {

        return candidateEntity.updateCandidateInfo(updateList);


    }

    public int updateCandidate(String candidateId, String employeeID) {
        return candidateEntity.updateCandidate(candidateId, employeeID);
    }

    public int deleteCandidate(String candidateId) {
        return candidateEntity.deleteCandidate(candidateId);
    }

    public HashMap selectCandidate(String Id) {
        return candidateEntity.selectCandidate(Id);
    }

    public HashMap readCandidateForRegistration(String id) {
        return candidateEntity.readCandidateForRegistration(id);
    }

    public ArrayList<EmployeeList> EmployeeNametoAutoList() {

        try {
            byte[] bytePicture = null;
            ResultSet rs = candidateEntity.searchEmployeeNametoAuto();
            ArrayList<EmployeeList> proformaoption = new ArrayList<EmployeeList>();
            while (rs.next()) {
                EmployeeList empMgt = new EmployeeList(rs.getString("CANDIDATE_F_NAME") + " " + rs.getString("CANDIDATE_M_NAME") + " " + rs.getString("CANDIDATE_L_NAME"), rs.getString("CANDIDATE_ID"));
                proformaoption.add(empMgt);

            }
            return proformaoption;
        } catch (Exception ex) {

            ErrorLogWriter.writeError(ex);

        }
        return null;
    }

    public HashMap[] readCandidateList(String bachCodeId ) 
    {
         HashMap[] listOfCandidate =null;
        try{

        ResultSet _rs=candidateEntity.readCandidateList(bachCodeId);
        int i=0;
        while(_rs.next())
        {


         listOfCandidate[i].put("WRITTENPERCENTAGE", _rs.getString("WRITTENPERCENTAGE"));
         listOfCandidate[i].put("INTERVIEWRESULT", _rs.getString("INTERVIEWRESULT"));
         listOfCandidate[i].put("PRACTICALRESULT", _rs.getString("PRACTICALRESULT"));
         listOfCandidate[i].put("CANDIDATE_F_NAME", _rs.getString("CANDIDATE_F_NAME")+" "+ _rs.getString("CANDIDATE_M_NAME")+" "+_rs.getString("CANDIDATE_L_NAME"));
         listOfCandidate[i].put("CANDIDATE_M_NAME", _rs.getString("CANDIDATE_M_NAME"));
         listOfCandidate[i].put("CANDIDATE_L_NAME", _rs.getString("CANDIDATE_L_NAME"));
         listOfCandidate[i].put("GENDER", _rs.getString("GENDER"));
         i++;
           }


        }catch (Exception ex) {

            ErrorLogWriter.writeError(ex);

        }

       return listOfCandidate;
    }

    public HashMap[] readCandidateForExam(String bachCodeId, String reqId, String sql) {
        return candidateEntity.readCandidateListForExame(bachCodeId, reqId, sql);
    }

    public HashMap readCandidateExamResult(String candidateID) {
        return candidateEntity.readCandidateExamResult(candidateID);
    }

    public int counrtCandidate(String bachCoudeId, String sql) {
        return candidateEntity.countCandidate(bachCoudeId, sql);
    }

    public int saveCandidateInformation(HashMap candidateInformation) {
        return candidateEntity.insertCandidateInfo(candidateInformation);
    }
      public boolean SaveCandidateEducation(ArrayList<CandidateEducationManager> candidateEducationList)
      {
         return candidateEntity.insertCandidateEducation(candidateEducationList);
       }


//       public boolean UpdateCandidateEducation(ArrayList<CandidateEducationManager> candidateEducationList)
//        {
//         return candidateEntity.UpdateCandidateEducation(candidateEducationList);
//        }


    public ArrayList<SelectItem> readJobType(String batchCode) {
        ArrayList<CandidateEntity> jobTypeList = candidateEntity.selectJobType(batchCode);
        ArrayList<SelectItem> jobList = new ArrayList<SelectItem>();
        for (int i = 0; i < jobTypeList.size(); i++) {
            candidateEntity = jobTypeList.get(i);
            jobList.add(new Option(String.valueOf(candidateEntity.getCode()),
                    String.valueOf(candidateEntity.getDescription())));
        }
        jobList.add(0, new Option(null, "Select Job Type"));
        return jobList;

    }

    public int saveCandidateExameResult(HashMap examResult) {
        return candidateEntity.saveCandidateExamResult(examResult);

    }


    public int SetCriteraOfSelection(String bachID, String cgpa, String gender, String workExp, int noOfCandidates, String ageMin, String ageMax, String orderBy) {
        return candidateEntity.saveSelectionCrtira(bachID,cgpa,gender,workExp,noOfCandidates,ageMin,ageMax,orderBy);
    }


    public boolean insertRecrutmentAssessmentPrecentage(HashMap recAssessmentPercentage) {
        return candidateEntity.insertExamPresentage(recAssessmentPercentage);
    }


//    public int saveExamPercentage(HashMap examPercentage) {
//        return candidateEntity.insertExamPresentage(examPercentage);
//
//    }
    public HashMap selectExamPresentage(String batchCode) {
        return candidateEntity.selectExamPresentage(batchCode);
    }

    public int updateExamPercentage(HashMap examPercentage) {
        return candidateEntity.updateExamPresentage(examPercentage);

    }

    public int deleteExamPercentage(String batchCode) {
        return candidateEntity.deleteExamPresentage(batchCode);//deleteExamPresentage(examPercentage);

    }

    public float maximumeCandidateGpa(String bachCode, String sql) {
        return candidateEntity.maximumeCandidateGpa(bachCode, sql);
    }

    public HashMap[] readCandidateForExam(String bachCodeId, String sql) {
        return candidateEntity.readCandidateListForExame(bachCodeId, sql);
    }

     public HashMap[] readEmployeeEducation(String candidateId) {
        return candidateEntity.readEducation(candidateId);
    }
      public int countExperiance(String candidateId) {
         return candidateEntity.countEducation(candidateId);
    }

       public static class  CandidateListForExam{

       String candidateID;
       String candidateName;
       String canEducationType;
       String canEducationLevel;
       String expYear;
       String  expMonth;
       String  expDay;
       String startDate;
       String endDate;
       String relation;
       String orgName;
       String position;
       float cgpa;
       String instiutation;
       String yearOfGraduation;
       int age;
       String sex;
       String totla;
       boolean selected;
       String batchId;
       String status;

        public CandidateListForExam(String candidateName, String candidateID, String sex) {
            this.candidateName=candidateName;
            this.candidateID=candidateID;
            this.sex=sex;
        }

        public CandidateListForExam(String fullName, String canID, String batchID, String candidateId) {
            this.candidateName=fullName;
            this.candidateID=canID;
            this.batchId=batchID;
            this.candidateID=candidateId;
        }




        public CandidateListForExam(String canID, String candidateName, String candidateSex, String batch,String status) {
            this.batchId=batch;
            this.candidateName=candidateName;
            this.sex=candidateSex;
            this.candidateID=canID;
            this.status=status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getBatchId() {
            return batchId;
        }

        public void setBatchId(String batchId) {
            this.batchId = batchId;
        }

        public String getTotla() {
            return totla;
        }

        public void setTotla(String totla) {
            this.totla = totla;
        }

        public String getRelation() {
            return relation;
        }

        public void setRelation(String relation) {
            this.relation = relation;
        }

        public String getEndDate() {
            return endDate;
        }

        public void setEndDate(String endDate) {
            this.endDate = endDate;
        }

        public String getStartDate() {
            return startDate;
        }

        public void setStartDate(String startDate) {
            this.startDate = startDate;
        }

        public float getCgpa() {
            return cgpa;
        }

        public void setCgpa(float cgpa) {
            this.cgpa = cgpa;
        }

        public String getInstiutation() {
            return instiutation;
        }

        public void setInstiutation(String instiutation) {
            this.instiutation = instiutation;
        }

        public String getYearOfGraduation() {
            return yearOfGraduation;
        }

        public void setYearOfGraduation(String yearOfGraduation) {
            this.yearOfGraduation = yearOfGraduation;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }
  
        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public String getCanEducationLevel() {
            return canEducationLevel;
        }

        public void setCanEducationLevel(String canEducationLevel) {
            this.canEducationLevel = canEducationLevel;
        }

        public String getCanEducationType() {
            return canEducationType;
        }

        public void setCanEducationType(String canEducationType) {
            this.canEducationType = canEducationType;
        }

        public String getCandidateID() {
            return candidateID;
        }

        public void setCandidateID(String candidateID) {
            this.candidateID = candidateID;
        }

        public String getCandidateName() {
            return candidateName;
        }

        public void setCandidateName(String candidateName) {
            this.candidateName = candidateName;
        }

        public String getExpDay() {
            return expDay;
        }

        public void setExpDay(String expDay) {
            this.expDay = expDay;
        }

        public String getExpMonth() {
            return expMonth;
        }

        public void setExpMonth(String expMonth) {
            this.expMonth = expMonth;
        }

        public String getExpYear() {
            return expYear;
        }

        public void setExpYear(String expYear) {
            this.expYear = expYear;
        }

       


        public String getOrgName() {
            return orgName;
        }

        public void setOrgName(String orgName) {
            this.orgName = orgName;
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            this.position = position;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public CandidateListForExam() {
        }


    
    }



}
