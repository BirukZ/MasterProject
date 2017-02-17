/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.recruitmentManager;

import entity.recruitmentEntity.RecruitmentEntity;
import java.sql.SQLException;
import java.util.ArrayList;
import com.sun.webui.jsf.model.Option;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import javax.print.PrintException;
import javax.swing.JOptionPane;
import manager.committeeManager.CommitteeRegistrationManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author BravoZulu
 */
public class RecruitmentManager {

    RecruitmentEntity recruitmentEntity = new RecruitmentEntity();
    Option bachcode[];
    String recruitmentRequestDate;
    String requiredJobType;
    String numberRequiredEmployee;
    String requirementType;
    String employeeId;
    String workingPlace;
    static String searchID;
    String batchCode;
    int committeeId;
    String approvedBy;
    String approvedDate;
    String noOfEmployeeApproved;
    String status;
    String recruitmentRequestId;
    String remark;
    private String jobCode;
    private Option[] gender;
    private String minQual;
    private String minExp;
    private String minRespon;
    private String addSkill;
    private boolean selected;
    private boolean selectedAdvert;
    private String advertType;
    private String educLevel;
    private String salary;
    private String runk;
    String approved;
    String  reject;

    public String getApproved() {
        return approved;
    }

    public void setApproved(String approved) {
        this.approved = approved;
    }

    public String getReject() {
        return reject;
    }

    public void setReject(String reject) {
        this.reject = reject;
    }




   // private String selected;

   

    public String getRunk() {
        return runk;
    }



    public void setRunk(String runk) {
        this.runk = runk;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getAdvertType() {
        return advertType;
    }

    public void setAdvertType(String advertType) {
        this.advertType = advertType;
    }

    public boolean isSelectedAdvert() {
        return selectedAdvert;
    }

    public void setSelectedAdvert(boolean selectedAdvert) {
        this.selectedAdvert = selectedAdvert;
    }

    public String getJobCode() {
        return jobCode;
    }

    public void setJobCode(String jobCode) {
        this.jobCode = jobCode;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

  


    public String getMinQual() {
        return minQual;
    }

    public void setMinQual(String minQual) {
        this.minQual = minQual;
    }

    public String getMinExp() {
        return minExp;
    }

    public void setMinExp(String minExp) {
        this.minExp = minExp;
    }

    public String getMinRespon() {
        return minRespon;
    }

    public void setMinRespon(String minRespon) {
        this.minRespon = minRespon;
    }

    public String getAddSkill() {
        return addSkill;
    }

    public void setAddSkill(String addSkill) {
        this.addSkill = addSkill;
    }

    public Option[] getBachcode() {
        return bachcode;
    }

    public void setBachcode(Option[] bachcode) {
        this.bachcode = bachcode;
    }

    public String getSearchID() {
        return searchID;
    }

    public void setSearchID(String searchID) {
        this.searchID = searchID;
    }

    public RecruitmentManager() {
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getNumberRequiredEmployee() {
        return numberRequiredEmployee;
    }

    public void setNumberRequiredEmployee(String numberRequiredEmployee) {
        this.numberRequiredEmployee = numberRequiredEmployee;
    }

    public String getRecruitmentRequestDate() {
        return recruitmentRequestDate;
    }

    public void setRecruitmentRequestDate(String recruitmentRequestDate) {
        this.recruitmentRequestDate = recruitmentRequestDate;
    }

    public String getRequiredJobType() {
        return requiredJobType;
    }

    public void setRequiredJobType(String requiredJobType) {
        this.requiredJobType = requiredJobType;
    }

    public int getCommitteeId() {
        return committeeId;
    }

    public void setCommitteeId(int action) {
        this.committeeId = action;
    }

    public RecruitmentManager(String batchCode, String approvedBy, String approvedDate, String noOfEmployeeApproved, String recruitmentRequestId, int committeeId) {
        this.batchCode = batchCode;
        this.approvedBy = approvedBy;
        this.approvedDate = approvedDate;
        this.noOfEmployeeApproved = noOfEmployeeApproved;
        this.recruitmentRequestId = recruitmentRequestId;
        this.committeeId = committeeId;

    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getNoOfEmployeeApproved() {
        return noOfEmployeeApproved;
    }

    public void setNoOfEmployeeApproved(String noOfEmployeeApproved) {
        this.noOfEmployeeApproved = noOfEmployeeApproved;
    }

    public String getRecruitmentRequestId() {
        return recruitmentRequestId;
    }

    public void setRecruitmentRequestId(String recruitmentRequestId) {
        this.recruitmentRequestId = recruitmentRequestId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public RecruitmentManager(String employeeId, String recruitmentRequestDate, String requiredJobType, String numberRequiredEmployee, String requirementType, String remark) {
        this.employeeId = employeeId;
        this.recruitmentRequestDate = recruitmentRequestDate;
        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;
        this.remark = remark;

    }

    public RecruitmentManager(String employeeId, String recruitmentRequestDate, String requiredJobType, String numberRequiredEmployee, String requirementType, String remark, String minQual, String minExp, String minRespo, String addSkill) {
        this.employeeId = employeeId;
        this.recruitmentRequestDate = recruitmentRequestDate;
        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;
        this.remark = remark;
        this.minQual = minQual;
        this.minExp = minExp;
        this.minRespon = minRespo;
        this.addSkill = addSkill;
    }

    public RecruitmentManager(String employeeId, String recruitmentRequestDate, String requiredJobType, String numberRequiredEmployee, String requirementType, String remark, String minQual, String minExp, String minRespo, String addSkill, String workingPlace)
    {
        this(employeeId, recruitmentRequestDate, requiredJobType, numberRequiredEmployee, requirementType, remark, minQual, minExp, minRespo, addSkill);
        this.workingPlace = workingPlace;
    }

 

    public RecruitmentManager(String employeeId, String recruitmentRequestDate, String requiredJobType,
            String numberRequiredEmployee, String requirementType, String remark,
            String minQual, String educLevel, String minExp, String minRespo, String addSkill,
            String jobCode, String recruitmentRequestId, String workingPlace, String salary, String rank) {
        this.employeeId = employeeId;
        this.recruitmentRequestDate = recruitmentRequestDate;
        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;
        this.remark = remark;
        this.minQual = minQual;
        this.educLevel = educLevel;
        this.minExp = minExp;
        this.minRespon = minRespo;
        this.addSkill = addSkill;
        this.jobCode = jobCode;
        this.recruitmentRequestId = recruitmentRequestId;
        this.workingPlace = workingPlace;
        this.salary = salary;
        this.runk = rank;
    }

    public RecruitmentManager(String requiredJobType, String numberRequiredEmployee,
            String requirementType, String minQual, String minExp,
            String minRespo, String jobCode, String recruitmentRequestId) {

        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;

        this.minQual = minQual;
        this.minExp = minExp;
        this.minRespon = minRespo;

        this.jobCode = jobCode;
        this.recruitmentRequestId = recruitmentRequestId;
    }

    public RecruitmentManager(String requiredJobType, String numberRequiredEmployee,
            String requirementType, String minQual, String minExp,
            String minRespo, String jobCode, String recruitmentRequestId, String advertType) {

        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;

        this.minQual = minQual;
        this.minExp = minExp;
        this.minRespon = minRespo;

        this.jobCode = jobCode;
        this.recruitmentRequestId = recruitmentRequestId;
        this.advertType = advertType;
    }

    public RecruitmentManager(String requiredJobType, String numberRequiredEmployee,
            String requirementType, String minQual, String minExp,
            String minRespo, String jobCode, String recruitmentRequestId,
            String advertID, String prepardDate, String advertFrom,
            String advertTo, String batchCode, String preparedBy,
            String mediaTypeId, String mediaTypeCode, String occurence) {

        this.requiredJobType = requiredJobType;
        this.numberRequiredEmployee = numberRequiredEmployee;
        this.requirementType = requirementType;

        this.minQual = minQual;
        this.minExp = minExp;
        this.minRespon = minRespo;

        this.jobCode = jobCode;
        this.recruitmentRequestId = recruitmentRequestId;
    }

    public String getRequirementType() {
        return requirementType;
    }

    public void setRequirementType(String requirementType) {
        this.requirementType = requirementType;
    }

    public String getRemark() {
        return remark;
    }

    public Option[] getGender() {
        return gender;
    }

    public void setGender(Option[] gender) {
        this.gender = gender;
    }

    public RecruitmentEntity getRecruitmentEntity() {
        return recruitmentEntity;
    }

    public void setRecruitmentEntity(RecruitmentEntity recruitmentEntity) {
        this.recruitmentEntity = recruitmentEntity;
    }

    public String getWorkingPlace() {
        return workingPlace;
    }

    public void setWorkingPlace(String workingPlace) {
        this.workingPlace = workingPlace;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int saveRequirementRequest(RecruitmentManager saveRequest) {
        RecruitmentEntity inserRequest = new RecruitmentEntity(
                saveRequest.getRecruitmentRequestDate(),
                saveRequest.getRequiredJobType(),
                saveRequest.getNumberRequiredEmployee(),
                saveRequest.getRequirementType(),
                saveRequest.getEmployeeId(),
                saveRequest.getRemark(),
                saveRequest.getWorkingPlace(),
                RecruitmentApproveManager.INITIAL_STATE_RECRUITMENT);
        return recruitmentEntity.saveRecruitmentRequest(inserRequest);
    }

    public int deleteRequirementRequest(String Recruitmentid) {

        return recruitmentEntity.deleteRecruitmentRequest(Recruitmentid);
    }

    public int updateRequirementRequest(RecruitmentManager saveRequest, String recruitmentRequestid) {
        RecruitmentEntity inserRequest = new RecruitmentEntity(saveRequest.getRecruitmentRequestDate(), saveRequest.getRequiredJobType(), saveRequest.getNumberRequiredEmployee(), saveRequest.getRequirementType(), saveRequest.getEmployeeId(), saveRequest.getRemark(), saveRequest.getWorkingPlace(), RecruitmentApproveManager.INITIAL_STATE_RECRUITMENT);
        return recruitmentEntity.updateRecruitmentRequest(inserRequest, recruitmentRequestid);
    }

    public Option[] selectRecruitmentRequests() {

        ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newRecruitmentRequests();
        Option[] requritment = new Option[readRecruitmentRequests.size()];

        for (int i = 0; i < readRecruitmentRequests.size(); i++) {
            recruitmentEntity = readRecruitmentRequests.get(i);
            Option assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
            requritment[i] = assign;

        }

        return requritment;


    }

    public Option[] selectRecruitmentResponses() {

        ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newRecruitmentResponsenotGiven();
        Option[] requritment = new Option[readRecruitmentRequests.size()];

        for (int i = 0; i < readRecruitmentRequests.size(); i++) {
            recruitmentEntity = readRecruitmentRequests.get(i);
            Option assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
            requritment[i] = assign;

        }

        return requritment;


    }

    public Option[] newPromotionRequests() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionRequestes();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (requritment.length > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] selectRecruitmentResponsesGiven() {

        ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.approvedRecruitmentRequests();
        Option[] requritment = new Option[readRecruitmentRequests.size()];

        for (int i = 0; i < readRecruitmentRequests.size(); i++) {
            recruitmentEntity = readRecruitmentRequests.get(i);
            Option assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
            requritment[i] = assign;

        }

        return requritment;


    }

    public Option[] selectRecruitmentRequestsUsingDate(String date1, String date2, String requesterID) {

        ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.readRecruitmentRequestHistory(date1, date2, requesterID);
        Option[] requritment = new Option[readRecruitmentRequests.size()];

        for (int i = 0; i < readRecruitmentRequests.size(); i++) {
            recruitmentEntity = readRecruitmentRequests.get(i);
            Option assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
            requritment[i] = assign;

        }

        return requritment;


    }

    public HashMap[] readSingleRecRequest(String requestID) {
        return recruitmentEntity.readSingleRecRequest(requestID);
    }

       public HashMap[] readCandidateList(String requestID) {
        return recruitmentEntity.readCandidateList(requestID);
    }
         public ArrayList<RecruitmentManager> readSingleRecRequestNewTest(String requestID)
         {
              ArrayList<RecruitmentManager> singleRequest=new  ArrayList<RecruitmentManager>();
              RecruitmentManager managerFroRec=new RecruitmentManager();
                 try {
           
                      ResultSet _rs;
             _rs= recruitmentEntity.readSingleRecRequestNew(requestID);
        
                while (_rs.next())
                       {
                    
                             managerFroRec.setEmployeeId(_rs.getString("REQUESTER_ID"));
                          //   managerFroRec.setSelected(false);
                             managerFroRec.setRecruitmentRequestDate(_rs.getString("RECRUIT_REQUEST_REF_DATE").toString());
                             managerFroRec.setRequiredJobType((_rs.getString("job_code").toString()));
                             managerFroRec.setNumberRequiredEmployee(_rs.getString("NUM_OF_EMPS").toString());
                            // managerFroRec.setRequirementType(_rs.getString("MIN_RESPONSIBILITY").toString());
                             managerFroRec.setRemark(_rs.getString("REMARK").toString());
                             managerFroRec.setMinQual(_rs.getString("qualification").toString());
                             managerFroRec.setMinExp(_rs.getString("MIN_EXPERIENCE").toString());
                             managerFroRec.setMinRespon(_rs.getString("DEPARTMENT_ID").toString());
                             managerFroRec.setAddSkill(_rs.getString("additionalskill").toString());
                             managerFroRec.setWorkingPlace(_rs.getString("DEPARTMENT_ID").toString());
                             managerFroRec.setRunk(_rs.getString("RANK_ID").toString());
                             managerFroRec.setSalary(_rs.getString("SALARY").toString());
                             managerFroRec.setApproved(_rs.getString("APPROVE").toString());
                             managerFroRec.setReject(_rs.getString("REJECT").toString());
                           //  managerFroRec.setSelected(null);
                             singleRequest.add(managerFroRec);
                                    }
                          return singleRequest;
                 } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

      // return singleRequest;

    }






    public ArrayList<String> readRecruitmentRequest(String recruitmentRequestId) {

        return recruitmentEntity.readRecruitmentRequest(recruitmentRequestId);

    }

    public ArrayList<String> readRecuitmentRequest(String recruitmentReqid) {
        return recruitmentEntity.readRecruitmentRequests(recruitmentReqid);

    }

    public Option[] readRecruitmentRequestByRequester(String empId) {
        ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.readRecruitmentRequestByEmployeeId(empId);
        if (readRecruitmentRequests != null) {
            Option[] requester = new Option[readRecruitmentRequests.size() + 1];
            Option first = new Option("Previous", "Previous Request");
            requester[0] = first;
            for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                recruitmentEntity = readRecruitmentRequests.get(i);
                Option assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                requester[i + 1] = assign;

            }

            return requester;
        } else {
            return null;
        }

    }

    public HashMap[] buildRecruitmentList() {
        return recruitmentEntity.buildRecruitmentList();
    }

    public int approvedRecruitmentRequests(RecruitmentManager recruitmentManager) {
        RecruitmentEntity approvedRequests = new RecruitmentEntity(recruitmentManager.getBatchCode(), recruitmentManager.getApprovedBy(), recruitmentManager.getApprovedDate(), recruitmentManager.getNoOfEmployeeApproved(), recruitmentManager.getRecruitmentRequestId(), recruitmentManager.getCommitteeId());
        return recruitmentEntity.addRecruitment(approvedRequests);
    }

    public String readDepartment(String id) {
        return recruitmentEntity.readDepartment(id);
    }

    public int count() {
        return recruitmentEntity.count();
    }

    public ArrayList<SelectItem> candidateName(String bachCode) {
        ArrayList<SelectItem> passedCandidateName = new ArrayList<SelectItem>();
        ArrayList<RecruitmentEntity> bachCodeList = recruitmentEntity.readCandidateName(bachCode);
        //    passedCandidateName = new Option[bachCodeList.size() + 1];
        passedCandidateName.add(new SelectItem(null, "Select", "Select Candidate List"));
        for (int i = 0; i < bachCodeList.size(); i++) {
            recruitmentEntity = bachCodeList.get(i);
            passedCandidateName.add(new SelectItem(
                    recruitmentEntity.getCode(),
                    recruitmentEntity.getDescription()));
//             passedCandidateName.add(new SelectItem(
//                    recruitmentEntity.getCode()+"--"+
//                    recruitmentEntity.getDescription()));

        }
        return passedCandidateName;
    }

    public Option[] assignGender() {
        gender = new Option[]{new Option("SelcetGender", "Selct Gender"),
                    new Option("Male", "Male"),
                    new Option("Female", "Female")};
        return gender;
    }

    public Option[] reedEmployeeType() {
        gender = new Option[]{new Option("CandidateType", "Selct"),
                    new Option("Permant", "Permant"),
                    new Option("Contrat", "Contrat")};
        return gender;
    }

    public Option[] readBachCode() {
        ArrayList<String> bachCodeList = recruitmentEntity.readListOfBachCode();
        bachcode = new Option[bachCodeList.size() + 1];
        bachcode[0] = new Option("BachCode", "Select Batch Code");
        for (int i = 0; i < bachCodeList.size(); i++) {
            bachcode[i + 1] = new Option(bachCodeList.get(i), bachCodeList.get(i));

        }
        return bachcode;
    }
     public Option[] readListOfBachCodeForCnd() {
        ArrayList<String> bachCodeList = recruitmentEntity.readListOfBachCodeForCnd();
        bachcode = new Option[bachCodeList.size() + 1];
        bachcode[0] = new Option("BachCode", "Select Batch Code");
        for (int i = 0; i < bachCodeList.size(); i++) {
            bachcode[i + 1] = new Option(bachCodeList.get(i), bachCodeList.get(i));

        }
        return bachcode;
    }

    public ArrayList<SelectItem> readBachCodeForEmployeement() {
        try {
            ArrayList<HashMap> bachCodeList = recruitmentEntity.readListOfBachCodeForEmployee();
            ArrayList<SelectItem> bachCode = new ArrayList<SelectItem>();
            bachCode.add(new SelectItem(null, "BachCode", "Select Batch Code"));
            for (HashMap hm : bachCodeList) {
                bachCode.add(new SelectItem(hm.get("RECRUIT_BATCH_CODE").toString(),
                        hm.get("RECRUIT_INFO").toString()));

            }
            return bachCode;
        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<SelectItem> readBachCodeBySelect() {
        try {
            ArrayList<String> bachCodeList = recruitmentEntity.readListOfBachCode();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (bachCodeList.size() > 0) {
                for (int i = 0; i < bachCodeList.size(); i++) {

                    questionlist.add(new Option(String.valueOf(bachCodeList.get(i)),
                            String.valueOf(bachCodeList.get(i))));
                }
                questionlist.add(0, new Option(null, "Select Batch Code"));
            } else {
                questionlist.add(0, new Option(null, "Batch code is not avilabel"));
            }

            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<SelectItem> readBachCodeBySelectOld() {
        try {
            ArrayList<String> bachCodeList = recruitmentEntity.readListOfBachCodeOld();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (bachCodeList.size() > 0) {
                for (int i = 0; i < bachCodeList.size(); i++) {

                    questionlist.add(new Option(String.valueOf(bachCodeList.get(i)),
                            String.valueOf(bachCodeList.get(i))));
                }
                questionlist.add(0, new Option(null, "Select Batch Code"));
            } else {
                questionlist.add(0, new Option(null, "Batch code is not avilabel"));
            }

            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }
    /////////////////////////////////////////////////////////////////////////////////////

    public ArrayList<SelectItem> readBachCodeBy() {
        try {
            ArrayList<String> bachCodeList = recruitmentEntity.readListOfBachCodeForflilter();
            ArrayList<SelectItem> questionlist = new ArrayList<SelectItem>();
            if (bachCodeList.size() > 0) {
                for (int i = 0; i < bachCodeList.size(); i++) {

                    questionlist.add(new Option(String.valueOf(bachCodeList.get(i)),
                            String.valueOf(bachCodeList.get(i))));
                }
                questionlist.add(0, new Option(null, "Select Batch Code"));
            } else {
                questionlist.add(0, new Option(null, "Batch code is not avilabel"));
            }

            return questionlist;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Option[] newPromotionRequestsFilterdByDate(String date1, String date2) {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionRequestesFilterByDate(date1, date2);
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionResponseFilterdByDate(String date1, String date2) {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionResponseFilterByDate(date1, date2);
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionRequestsDates() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionRequestesDates();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Date");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionResponse() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionResponse();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (requritment.length > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionRequestApprove() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionRequestApprove();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (requritment.length > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionResponseAprove() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionResponseApprove();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (requritment.length > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionRequestApproveFilterdByDate(String date1, String date2) {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionRequestApproveFilterByDate(date1, date2);
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] noneResponsedVacancies() {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.noneResponsedVacancies();
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Non Responsed Vacancies");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;




    }

    public Option[] newPromotionResponseAproveFilterdByDate(String date1, String date2) {
        try {
            ArrayList<RecruitmentEntity> readRecruitmentRequests = recruitmentEntity.newPromotionResponseAproveFilterByDate(date1, date2);
            Option[] requritment = new Option[readRecruitmentRequests.size() + 1];

            Option assign = new Option("00", "Select Job Discription");
            requritment[0] = assign;

            if (readRecruitmentRequests.size() > 0) {
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    recruitmentEntity = readRecruitmentRequests.get(i);
                    assign = new Option(recruitmentEntity.getCode(), recruitmentEntity.getDescription());
                    requritment[i + 1] = assign;

                }
            }
            return requritment;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public ArrayList<SelectItem> getActiveRecruitmentCommittees() {
        ArrayList<SelectItem> committeeList = (new CommitteeRegistrationManager()).getAllCommittees("Recruitment", "Active");
        committeeList.add(0, new SelectItem("-1", "--SELECT COMMITTEE--"));
        // return (new CommitteeRegistrationManager()).getAllCommittees("Discipline", "Active");
        return committeeList;
    }
     public int UpdateCandidate(int candidateID) {

      return  recruitmentEntity.updateCandidateStatus(candidateID);
    }
      public int UpdateCandidateBeforExam(int candidateID) {

      return  recruitmentEntity.updateCandidateStatusBeforExam(candidateID);
    }


    public int readCommitteeId(int recruitmentRequestId) {
        return recruitmentEntity.readCommitteeId(recruitmentRequestId);
    }

    public int promotionCommitteeId(String recruitmentRequestId) {
        return recruitmentEntity.promotionCommitteeId(recruitmentRequestId);
    }
}
