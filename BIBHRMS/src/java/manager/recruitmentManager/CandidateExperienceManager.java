/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import com.sun.webui.jsf.model.Option;
import entity.recruitmentEntity.CandidateExperienceEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import javax.faces.model.SelectItem;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;

/**
 *
 * @author BravoZulu
 */
public class CandidateExperienceManager {

    String institution;
    String terminationReason;
    String rank;
    String startDate;
    String copletionDate;
    String salary;
    String job_Code;
    String id;
    String job_description;
    int equvalentJobCode;
    String experiencePrivateOrGovernmental;
    String experienceContractOrPrtmanent;
    CandidateExperienceEntity candidateExperience = new CandidateExperienceEntity();
    String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
    String candidateId;
    private String expRelationType;
    private boolean selectedExperance;
    int expYear;
    int expMonth;
    int expDay;
    String  years;
    String dates;
    String months;

   


    public CandidateExperienceManager() {
    }

//    public CandidateExperienceManager(String candidateId, String salary,
//            String institution, String rank, String job_Code, String startDate,
//            String copletionDate, String terminationReason, String experiencePrivateOrGovernmental,
//            String experienceContractOrPrtmanent, String experianceId,
//            String job_description, int equvalentJobCode, String expRelationType,int  year,int  months,int  dates)
//    {
//        this.candidateId = candidateId;
//        this.salary = salary;
//        this.institution = institution;
//        this.rank = rank;
//        this.job_Code = job_Code;
//        this.startDate = startDate;
//        this.copletionDate = copletionDate;
//        this.terminationReason = terminationReason;
//        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
//        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
//        this.id = experianceId;
//        this.equvalentJobCode = equvalentJobCode;
//        this.expRelationType = expRelationType;
//        this.years=year;
//        this.months=months;
//        this.dates=dates;
//
//    }

//    public CandidateExperienceManager(String candidateId, String salary, String institution, String rank, String JobType, String startDate, String copletionDate, String terminationReason, String experiencePrivateOrGovernmental, String experienceContractOrPrtmanent, String experianceId, String job_Discripton, int equvalentJobCode, String relationType, String totExpirance, int month, int day) {
//        throw new UnsupportedOperationException("Not yet implemented");
//    }

    public CandidateExperienceManager(String candidateId, String salary,
            String institution, String rank, String job_Code, String startDate,
            String copletionDate, String terminationReason, String experiencePrivateOrGovernmental,
            String experienceContractOrPrtmanent, String experianceId,
            String job_description, int equvalentJobCode, String expRelationType,String  year,String  months,String  dates) {
        this.candidateId = candidateId;
        this.salary = salary;
        this.institution = institution;
        this.rank = rank;
        this.job_Code = job_Code;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.terminationReason = terminationReason;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.id = experianceId;
        this.equvalentJobCode = equvalentJobCode;
        this.expRelationType = expRelationType;
        this.years=year;
        this.months=months;
        this.dates=dates;
        
       
    }

    public CandidateExperienceManager(String candidateId,
            String salary,
            String institution,
            String rank,
            String job_Code,
            String startDate,
            String copletionDate,
            String terminationReason,
            String experiencePrivateOrGovernmental,
            String experienceContractOrPrtmanent,
            String job_description,
            int equvalentJobCode,
            String experianceId,
            String expRelationType,
            String years,
            String month,
            String dates) {
        this.candidateId = candidateId;
        this.salary = salary;
         this.institution = institution;
        this.rank = rank;
        this.job_Code = job_Code;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.terminationReason = terminationReason;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.equvalentJobCode = equvalentJobCode;
        this.job_description=job_description;
         this.id = experianceId;
         this.expRelationType = expRelationType;
        this.years=years;
        this.months=month;
        this.dates=dates;
    }

    public CandidateExperienceManager(String institution, String terminationReason, String rank, String startDate, String copletionDate, String salary, String candidateId, String job_Code, String id,
            String experiencePrivateOrGovernmental, String experienceContractOrPrtmanent, String employeeId) {
        this.institution = institution;
        this.terminationReason = terminationReason;
        this.rank = rank;
        this.startDate = startDate;
        this.copletionDate = copletionDate;
        this.salary = salary;
        this.candidateId = candidateId;
        this.job_Code = job_Code;
        this.id = id;
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
        this.candidateId = employeeId;

    }






    public ArrayList<SelectItem> getAllCanidateNameList(String batchCode) {
       try {
            ArrayList<CandidateExperienceEntity> pageEntity = candidateExperience.selectAllCandidateNameOnSelectedBatch(batchCode);

            ArrayList<SelectItem> candidatNameList = new ArrayList<SelectItem>();

            for (int i = 0; i < pageEntity.size(); i++) {

                candidateExperience = pageEntity.get(i);
                candidatNameList.add(new Option(String.valueOf(candidateExperience.getCandidatNameList())+"-"+candidateExperience.getCandidateID()));
            }
            candidatNameList.add(0, new Option(null, "--Select Candidate Name--"));
            return candidatNameList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<SelectItem> getAllCanidateNameListForFinalSelection(String batchCode) {
       try {
            ArrayList<CandidateExperienceEntity> pageEntity = candidateExperience.selectAllCandidateNameForEinalSelection(batchCode);

            ArrayList<SelectItem> candidatNameList = new ArrayList<SelectItem>();

            for (int i = 0; i < pageEntity.size(); i++) {

                candidateExperience = pageEntity.get(i);
                candidatNameList.add(new Option(String.valueOf(candidateExperience.getCandidatNameList())+"--"+candidateExperience.getCandidateID()));
            }
            candidatNameList.add(0, new Option(null, "--Select Candidate Name--"));
            return candidatNameList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    // <editor-fold defaultstate="collapsed" desc="get & set ">
    public CandidateExperienceEntity getCandidateExperience() {
        return candidateExperience;
    }



    public void setCandidateExperience(CandidateExperienceEntity candidateExperience) {
        this.candidateExperience = candidateExperience;
    }

    public int getEquvalentJobCode() {
        return equvalentJobCode;
    }

    public void setEquvalentJobCode(int job_code) {
        this.equvalentJobCode = job_code;
    }

    public String getJob_description() {
        return job_description;
    }

    public void setJob_description(String job_description) {
        this.job_description = job_description;
    }

    public String getCurrentDateAndTime() {
        return currentDateAndTime;
    }

    public void setCurrentDateAndTime(String currentDateAndTime) {
        this.currentDateAndTime = currentDateAndTime;
    }

    public boolean isSelectedExperance() {
        return selectedExperance;
    }

    public void setSelectedExperance(boolean selectedExperance) {
        this.selectedExperance = selectedExperance;
    }

    public String getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(String candidateId) {
        this.candidateId = candidateId;
    }

    public String getCopletionDate() {
        return copletionDate;
    }

    public void setCopletionDate(String copletionDate) {
        this.copletionDate = copletionDate;
    }

    public String getExperienceContractOrPrtmanent() {
        return experienceContractOrPrtmanent;
    }

    public void setExperienceContractOrPrtmanent(String experienceContractOrPrtmanent) {
        this.experienceContractOrPrtmanent = experienceContractOrPrtmanent;
    }

    public String getExperiencePrivateOrGovernmental() {
        return experiencePrivateOrGovernmental;
    }

    public void setExperiencePrivateOrGovernmental(String experiencePrivateOrGovernmental) {
        this.experiencePrivateOrGovernmental = experiencePrivateOrGovernmental;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getJob_Code() {
        return job_Code;
    }

    public void setJob_Code(String job_Code) {
        this.job_Code = job_Code;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getTerminationReason() {
        return terminationReason;
    }

    public void setTerminationReason(String terminationReason) {
        this.terminationReason = terminationReason;
    }
    // </editor-fold>

    public int saveCandidatExperiance(CandidateExperienceManager saveExperiance, int perform) {
        CandidateExperienceEntity candidateExperienceEntity = new CandidateExperienceEntity(saveExperiance.getInstitution(),
                saveExperiance.getTerminationReason(),
                saveExperiance.getStartDate(),
                saveExperiance.getCopletionDate(),
                saveExperiance.getSalary(),
                saveExperiance.getCandidateId(),
                saveExperiance.getJob_Code(),
                saveExperiance.getRank(),
                saveExperiance.getExperiencePrivateOrGovernmental(),
                saveExperiance.getExperienceContractOrPrtmanent(),
                saveExperiance.getId(),
                saveExperiance.getJob_description(),
                saveExperiance.getEquvalentJobCode(),
                saveExperiance.getExpRelationType(),
                saveExperiance.getYears(),saveExperiance.getMonths(),
                saveExperiance.getDates()
                );
        if (perform == 1)
        {
            return candidateExperienceEntity.saveCandidateExperience(candidateExperienceEntity);
        } else {
            
            return candidateExperienceEntity.updateCandidateExperience(candidateExperienceEntity);
        }


    }
   public int SaveTotalExpirance(String birukTotal, String candidateId,String status) {
       int result= candidateExperience.SaveCandidateExpiranceTotal(birukTotal,candidateId,status);
        return result;
    }
      public int SaveTotalExpiranceUpdate(String birukTotal, String candidateId, String status) {
        int result= candidateExperience.SaveCandidateExpiranceTotalUpdate(birukTotal,candidateId,status);
        return result;
    }

     public int selectServYeartotale(String candidateId)
     {
        int result= candidateExperience.SelectCandidateExpirance(candidateId);
        return result;

     }

    public int CheckExistanceOfCandidate(String candidateId) {
        int result =candidateExperience.CheckExistanceOfCandidate(candidateId);
        return result;
    }

    public int getExpDay() {
        return expDay;
    }

    public void setExpDay(int expDay) {
        this.expDay = expDay;
    }

    public int getExpMonth() {
        return expMonth;
    }

    public void setExpMonth(int expMonth) {
        this.expMonth = expMonth;
    }

    public int getExpYear() {
        return expYear;
    }

    public void setExpYear(int expYear) {
        this.expYear = expYear;
    }

    public String getDates() {
        return dates;
    }

    public void setDates(String dates) {
        this.dates = dates;
    }

    public String getMonths() {
        return months;
    }

    public void setMonths(String months) {
        this.months = months;
    }

    public String getYears() {
        return years;
    }

    public void setYears(String years) {
        this.years = years;
    }



    public ArrayList<CandidateExperienceManager> readEmployeeExperianceNew(String candidateId)
    {
        ArrayList<CandidateExperienceManager> canExpirance=new ArrayList<CandidateExperienceManager>();
      CandidateExperienceManager canExp=null;
       ResultSet rsExper=null;
         try {
    rsExper  =candidateExperience.readExperianceNew(candidateId);
       
       while(rsExper.next())
                   {

                canExp = new CandidateExperienceManager(
                           rsExper.getString("CANDIDATE_ID").toString(),
                           rsExper.getString("SALARY")== null ? "" : rsExper.getString("SALARY"),
                            rsExper.getString("INSTITUION")== null ? "" : rsExper.getString("INSTITUION"),
                            rsExper.getString("RANK")== null ? "" : rsExper.getString("RANK"),
                            rsExper.getString("JOB_TITLE")== null ? "" : rsExper.getString("JOB_TITLE"),
                            rsExper.getString("START_DATE")== null ? "" : rsExper.getString("START_DATE"),
                            rsExper.getString("END_DATE")==null ? "" :rsExper.getString("END_DATE"),
                            rsExper.getString("REASON_FOR_TERMINATION") == null ? "" : rsExper.getString("REASON_FOR_TERMINATION"),
                            rsExper.getString("PRIVATE_OR_GVTAL")== null ? "" : rsExper.getString("PRIVATE_OR_GVTAL"),
                            rsExper.getString("PERMANENT_OR_CONTRACT").toString(),
                            rsExper.getString("EQUVALENTJOBCODE").toString(),
                            Integer.parseInt(rsExper.getString("EQUVALENTJOBCODE").toString()),
                            rsExper.getString("EXP_RELATION_TYPE").toString(),
                            rsExper.getString("EXPERIENCE_ID").toString(),
                            rsExper.getString("EXPDETAIL").toString(),
                            rsExper.getString("EXP_MONTH").toString(),
                            rsExper.getString("EXP_DAY").toString());
                            canExpirance.add(canExp);
       }
       return canExpirance;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
               // releaseResources();
            } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
    }


//
//    public HashMap[] readEmployeeExperiance(String candidateId) {
//        return candidateExperience.readExperiance(candidateId);
//    }

    public int countExperiance(String candidateId) {
        return candidateExperience.countExperiance(candidateId);
    }

    public int deleteCandidateExperiance(String id) {
        return candidateExperience.deleteCandidateExperiance(id);
    }

    /**
     * @return the expRelationType
     */
    public String getExpRelationType() {
        return expRelationType;
    }

    /**
     * @param expRelationType the expRelationType to set
     */
    public void setExpRelationType(String expRelationType) {
        this.expRelationType = expRelationType;
    }
    public static class CandidateEducationManager{
        String candidateID;
        String recuritmentBatch;
        String instiution;
        String cgpa;
        String filedOfStudy;
        String filedOfCatagory;
        String graduationYear;
        String leavelOFEducation;
        String status;
        boolean  selectedEducatuon;
        int canEducID;

        public CandidateEducationManager(String status,String leaveOfEducation, String cgpa, String filedOfStudy, String graduationYear, String instiution, String candidateID,int educationID) {
            this.status=status;
            this.leavelOFEducation=leaveOfEducation;
            this.cgpa=cgpa;
            this.filedOfStudy=filedOfStudy;
            this.graduationYear=graduationYear;
            this.instiution=instiution;
            this.candidateID=candidateID;
            this.canEducID=educationID;
        }

        public CandidateEducationManager(String status,String candidate_ID, String instiution, String cgpa, String filedOfStudy, String filedOfCatagory, String graduationYear, String leaveOfEduc,int canEducID) {
            this.status=status;
            this.candidateID=candidate_ID;
            this.instiution=instiution;
            this.cgpa=cgpa;
            this.filedOfStudy=filedOfStudy;
            this.filedOfCatagory=filedOfCatagory;
            this.graduationYear=graduationYear;
            this.leavelOFEducation=leaveOfEduc;
            this.canEducID=canEducID;
        }

        public int getCanEducID() {
            return canEducID;
        }

        public void setCanEducID(int canEducID) {
            this.canEducID = canEducID;
        }

        public boolean isSelectedEducatuon() {
            return selectedEducatuon;
        }

        public void setSelectedEducatuon(boolean selectedEducatuon) {
            this.selectedEducatuon = selectedEducatuon;
        }

       

        public String getLeavelOFEducation() {
            return leavelOFEducation;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public void setLeavelOFEducation(String leavelOFEducation) {
            this.leavelOFEducation = leavelOFEducation;
        }

        public String getCandidateID() {
            return candidateID;
        }

        public void setCandidateID(String candidateID) {
            this.candidateID = candidateID;
        }

        public String getCgpa() {
            return cgpa;
        }

        public void setCgpa(String cgpa) {
            this.cgpa = cgpa;
        }

        public String getFiledOfCatagory() {
            return filedOfCatagory;
        }

        public void setFiledOfCatagory(String filedOfCatagory) {
            this.filedOfCatagory = filedOfCatagory;
        }

        public String getFiledOfStudy() {
            return filedOfStudy;
        }

        public void setFiledOfStudy(String filedOfStudy) {
            this.filedOfStudy = filedOfStudy;
        }

        public String getGraduationYear() {
            return graduationYear;
        }

        public void setGraduationYear(String graduationYear) {
            this.graduationYear = graduationYear;
        }

        public String getInstiution() {
            return instiution;
        }

        public void setInstiution(String instiution) {
            this.instiution = instiution;
        }

        public String getRecuritmentBatch() {
            return recuritmentBatch;
        }

        public void setRecuritmentBatch(String recuritmentBatch) {
            this.recuritmentBatch = recuritmentBatch;
        }
        

    }
}
