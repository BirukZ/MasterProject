/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import com.sun.webui.jsf.model.Option;

import entity.trainingEntity.ApprovedRequestsEntity;
import entity.trainingEntity.FeeEntity;
import entity.trainingEntity.PaymentMethodEntity;
import entity.trainingEntity.TraineeEntity;
import entity.trainingEntity.TrainerEntity;
import entity.trainingEntity.TrainerSpecializationEntity;
import entity.trainingEntity.TrainingApprovalEntity;
import entity.trainingEntity.TrainingAwardEntity;
import entity.trainingEntity.TrainingRequestApprovedEntity;
import entity.trainingEntity.TrainingRequestEntity;
import entity.trainingEntity.TrainingTypeEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DPClone
 */
public class TrainingContoller {

    private String txtfFromDate;
    private String txtfToDate;
    private String txtfTrainingTypea;
    private String txtfStartDateSearch;
    private String txtfEndDateSearch;
    private ApprovedRequestsEntity approvedRequestsEntity = new ApprovedRequestsEntity();
    private TrainingRequestEntity trainingRequestEntity = new TrainingRequestEntity();
    private TraineeEntity traineeEntity = new TraineeEntity();
    private TraineeEntity traineStatusEntity = new TraineeEntity();
    private TrainingApprovalEntity trainingApprovalEntity = new TrainingApprovalEntity();
    private TrainingRequestApprovedEntity trainingRequestApprovedEntity = new TrainingRequestApprovedEntity();
    private TrainerEntity trainerEntity = new TrainerEntity();
    private TrainerSpecializationEntity trainerSpecializationEntity = new TrainerSpecializationEntity();
    private FeeEntity feeEntity = new FeeEntity();
    private TrainingTypeEntity trainingTypeEntity = new TrainingTypeEntity();
    PaymentMethodEntity paymentMethodEntity = new PaymentMethodEntity();
    TrainingAwardEntity trainingAwardEntity = new TrainingAwardEntity();
    private Option[] employeeTrainingRequest;

    public ArrayList<SelectItem> PriortyTypes() {
        ArrayList<SelectItem> priortyTypes = new ArrayList<SelectItem>();
        priortyTypes.add(0, new Option(null, "--Select Prioty --"));
        priortyTypes.add(1, new Option("1", "High"));
        priortyTypes.add(2, new Option("2", "Medium"));
        priortyTypes.add(3, new Option("3", "Low"));
        return priortyTypes;
    }

    public ArrayList<SelectItem> getAllGradingSystems() {
        ArrayList<SelectItem> priortyTypes = new ArrayList<SelectItem>();
        priortyTypes.add(0, new Option("-1", "Select"));
        priortyTypes.add(1, new Option("0", " P/Fl"));
        priortyTypes.add(2, new Option("4", "  4.0 "));
        priortyTypes.add(3, new Option("5", "  5.0 "));
        priortyTypes.add(4, new Option("6", "  6.0 "));
        priortyTypes.add(5, new Option("10", " 10.0 "));
        priortyTypes.add(6, new Option("100", "100.0 "));
        return priortyTypes;
    }

    public ArrayList<SelectItem> TeamTypes() {
        ArrayList<SelectItem> teamTypes = new ArrayList<SelectItem>();
        teamTypes.add(0, new Option(null, "--Select Tearm --"));
        teamTypes.add(1, new Option("1", "Short"));
        teamTypes.add(2, new Option("2", "Long"));
        return teamTypes;
    }

    /**
     *
     * @return
     */
    public ArrayList<PaymentMethodEntity> readAllPaymentMethod() {
        return paymentMethodEntity.readAll();
    }

    /**
     *
     * @return
     */
    public ArrayList<TrainingAwardEntity> readAllTrainingAward() {
        return trainingAwardEntity.readAll();
    }

    /**
     *
     * @return
     */
    public TrainerSpecializationEntity getTrainerSpecializationEntity() {
        return trainerSpecializationEntity;
    }

    public boolean saveTrainingDecision(int requestId, String processedBy, String decision, String requestStatus, String comment) {
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {

            trainingApprovalEntity = new TrainingApprovalEntity(requestId, processedBy, decision,requestStatus, comment,recorededDateAndTime);


            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }


    /**
     *
     * @param trainerPrefix
     * @return
     */
    public ArrayList<Option> searchTrainer(String trainerPrefix) {
        try {
            ArrayList<Option> trainer = new ArrayList<Option>();
            ResultSet rsTrainer = trainerEntity.searchTrainer(trainerPrefix);
            while (rsTrainer.next()) {
                String trainerId = rsTrainer.getString("trainer_id");
                String trainerName = rsTrainer.getString("name");
                trainer.add(new Option(trainerId, trainerName));
            }
            return trainer;
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return null;
        }
    }

    /**
     *
     * @param trainerSpecializationEntity
     */
    public void setTrainerSpecializationEntity(TrainerSpecializationEntity trainerSpecializationEntity) {
        this.trainerSpecializationEntity = trainerSpecializationEntity;
    }

    public void addTrainerSpecialization(String trainerId, String trainingType, int minTraineeId, String isActive, String remark, String newOrOld) {
        try {
//        trainerSpecializationEntity.addTrainingType(idValue, specializationList, newOrOld);
            trainerSpecializationEntity = new TrainerSpecializationEntity(trainerId, trainingType, minTraineeId, isActive, remark);
            trainerSpecializationEntity.add(newOrOld);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public int updateTrainer(String trainerId, String companyName, String contactAddress, String remark) {
        int transactionStatus = 0;
        try {
            setTrainerEntity(new TrainerEntity(trainerId, companyName, contactAddress, remark));
            if (getTrainerEntity().update() == 1) {
                transactionStatus = 1;
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     *
     * @param specializationId
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     */
    public void updateTrainerSpecialization(String specializationId, String trainingType, int minNoOfTrainees, String isActive, String remark) {
        trainerSpecializationEntity = new TrainerSpecializationEntity(specializationId, trainingType, minNoOfTrainees, isActive, remark);
        trainerSpecializationEntity.update();
    }

    /**
     *
     * @param feeId
     * @param trainerSpecializationId
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param duration
     * @param remark
     * @param newOrOld
     */
    public void addFee(String feeId, String trainerSpecializationId, String paymentMethod, float amount, String date, boolean isWorking, String duration, String remark, String newOrOld) {
        setFeeEntity(new FeeEntity(feeId, trainerSpecializationId, paymentMethod, amount, date, isWorking, duration, remark));
        getFeeEntity().add(newOrOld);
    }

    /**
     *
     * @param feeId
     * @param trainingType
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param duration
     * @param remark
     * @param newOrOld
     */
    public void addNewFee(String feeId, String trainingType, String paymentMethod, float amount, String date, boolean isWorking, String duration, String remark, String newOrOld) {
        setFeeEntity(new FeeEntity(feeId, trainingType, paymentMethod, amount, date, isWorking, duration, remark));
        getFeeEntity().add(newOrOld);
    }

    /**
     *
     * @param description
     * @param awardId
     * @param parentTrainingType
     * @param remark
     * @param newOrOld
     */
    public void addTrainingType(String category, String description, String remark) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(category, description, remark));
            getTrainingTypeEntity().addTrainingType();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public void updateTrainingType(String trainigTypeID, String description, String remark, String category) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(trainigTypeID, description, remark, category));
            getTrainingTypeEntity().updateTrainingType();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public void addTrainingCategory(String description, String remark) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(description, remark));
            getTrainingTypeEntity().addCategory();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    public void updateTrainingCategory(String trainigCategoryID, String description, String remark) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(trainigCategoryID, description, remark));
            getTrainingTypeEntity().updateTrainingCategory();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    /**
     *
     * @param empid
     * @param processInstanceId
     * @return
     */
    public List<ApprovedRequestsEntity> selectApprovedRequests(String empid, String processInstanceId) {
        setApprovedRequestsEntity(new ApprovedRequestsEntity());
        return getApprovedRequestsEntity().selectApprovedRequests(empid, processInstanceId);
    }
 

    public boolean saveTrainingNeed(ArrayList<HashMap> trainingNeedList, int trainingTypeID, String fromDate, String toDate, int trainingTearm, int trainingInstitutionID, String requestRemark, int numEmp, String requesterID, int priority, String forDepartment, String requestDate, double costPerPerson, double total) throws SQLException {
        int insertTrainingRequest = 0;
        TraineeEntity trainingNeed = new TraineeEntity(trainingTypeID, fromDate, toDate, trainingTearm, trainingInstitutionID, requestRemark, numEmp, requesterID, priority, forDepartment, requestDate, costPerPerson, total);
        boolean ransaction = false;
        String trainingNeedId = null;
        try {
            insertTrainingRequest = getTraineeEntity().insert(trainingNeed);
            if (insertTrainingRequest == 1) {
                ResultSet _rs = getTraineeEntity().LastRowTrainingRequestID();
                if (_rs.next()) {
                    trainingNeedId = _rs.getString("TRAINING_REQUES_ID").toString();
                }
                if (trainingNeedList.size() > 0) {
                    for (int i = 0; i < trainingNeedList.size(); i++) {
                        HashMap data = trainingNeedList.get(i);
                        TrainingRequestEntity trainingRequest = new TrainingRequestEntity(
                                (data.get("empSelected").toString()), Integer.valueOf(trainingNeedId.toString()));
                        trainingRequest.insert(trainingRequest);
                    }
                }
                ransaction = true;
            } else {
                ransaction = false;
            }
            //end of for loop

            return ransaction;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return ransaction;
        }
    }//End of method saveTrainingNeed

    public boolean UpdateTrainingNeed(Set<HashMap> trainingNeedList, Set<HashMap> trainingNeedListDelete, int trainingTypeID, String fromDate, String toDate, int trainingTearm, int trainingInstitutionID, String requestRemark, int numEmp, String requesterID, int priority, String forDepartment, String requestDate, double costPerPerson, double total, String requestID) throws SQLException {
        int updateTrainingRequest = 0;
        TraineeEntity trainingNeed = new TraineeEntity(trainingTypeID, fromDate, toDate, trainingTearm, trainingInstitutionID, requestRemark, numEmp, requesterID, priority, forDepartment, requestDate, costPerPerson, total);
        boolean ransaction = false;
        try {
            updateTrainingRequest = getTraineeEntity().UpdateCandidate(trainingNeed, requestID);
            if (updateTrainingRequest == 1) {
                for (HashMap hp : trainingNeedList) {
                    TrainingRequestEntity trainingRequest = new TrainingRequestEntity(
                            (hp.get("commonEmployeeInsert").toString()), Integer.valueOf(requestID.toString()));
                    trainingRequest.insert(trainingRequest);
                }
                for (HashMap hp : trainingNeedListDelete) {//for each loop to iterate the employee list to be deleted
                    TrainingRequestEntity trainingRequest = new TrainingRequestEntity(hp.get("commonEmployeeDelete").toString());
                    trainingRequest.deleteEmployeesCandidate(trainingRequest);
                }
                ransaction = true;

            } else {

                ransaction = false;
            }
            //end of for loop

            return ransaction;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return ransaction;
        }
    }//End of method saveTrainingNeed

    public ArrayList<HashMap> LoadTrainingRequestsToList(String requestedDate, String forDepartment) {
        try {
            ResultSet _rs = null;
            ArrayList<HashMap> _list = new ArrayList<HashMap>();
            _rs = traineeEntity.LoadTrainingRequestsList(requestedDate, forDepartment);
            if (_rs != null) {
                while (_rs.next()) {
                    HashMap data = new HashMap();
                    data.put("trainingRequestID", _rs.getString("TRAINING_REQUES_ID"));
                    data.put("trainingForDepartment", _rs.getString("FOR_DEPARTMENT_ID"));
                    data.put("trainingRequestDate", _rs.getString("REQUEST_DATE"));
                    data.put("trainingEmpDepartment", _rs.getString("DEP_DESCRIPTION"));
                    _list.add(data);
                }

                return _list;
            } else {
                HashMap data = new HashMap();
                data.put("trainingRequestID", "");
                data.put("trainingForDepartment", "");
                data.put("trainingRequestDate", "");
                data.put("trainingEmpDepartment", "");
                _list.add(data);
                return _list;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public Set<HashMap> LoadTrainingRequests(String requestedID) {
        try {
            ResultSet _rs = null;
            Set<HashMap> _list = new HashSet<HashMap>();
            _rs = traineeEntity.LoadTrainingRequests(requestedID);
            if (_rs.next()) {
                HashMap data = new HashMap();
                data.put("trainingRequestID", _rs.getString("TRAINING_REQUES_ID"));
                data.put("trainingTypeID", _rs.getString("TRAINING_TYPE_ID"));
                data.put("trainingFromDate", _rs.getString("FROM_DATE"));
                data.put("trainingtoDate", _rs.getString("TO_DATE"));
                data.put("trainingTearmID", _rs.getString("TRAINING_TEARM_ID"));
                data.put("trainingInstitutionID", _rs.getString("INSTITUTION_ID"));
                data.put("trainingRemark", _rs.getString("REMARK"));
                data.put("trainingNumOfEmp", _rs.getString("NO_OF_TRAINEES"));
                data.put("trainingRequesterID", _rs.getString("REQUESTER_ID"));
                data.put("trainingPriorityID", _rs.getString("PRIORITY_ID"));
                data.put("trainingForDepartment", _rs.getString("FOR_DEPARTMENT_ID"));
                data.put("trainingRequestDate", _rs.getString("REQUEST_DATE"));
                data.put("trainingCostPerPerson", _rs.getString("COAST_PER_PERSON"));
                data.put("trainingTotalCoast", _rs.getString("TOTAL_COAST"));
                //  data.put("trainingStatus", _rs.getString("SATUS"));
                data.put("trainingEmpFirstName", _rs.getString("FIRST_NAME"));
                data.put("trainingEmpLastName", _rs.getString("LAST_NAME"));
                data.put("trainingEmpMiddleName", _rs.getString("MIDDLE_NAME"));
                data.put("trainingEmpDepartment", _rs.getString("DEP_DESCRIPTION"));
                data.put("trainingEmpJobPosition", _rs.getString("JOB_DESCRIPTION"));
                _list.add(data);
                return _list;
            } else {
                HashMap data = new HashMap();
                data.put("trainingRequestID", "");
                data.put("trainingTypeID", "");
                data.put("trainingFromDate", "");
                data.put("trainingtoDate", "");
                data.put("trainingTearmID", "");
                data.put("trainingInstitutionID", "");
                data.put("trainingRemark", "");
                data.put("trainingNumOfEmp", "");
                data.put("trainingRequesterID", "");
                data.put("trainingPriorityID", "");
                data.put("trainingForDepartment", "");
                data.put("trainingRequestDate", "");
                data.put("trainingCostPerPerson", "");
                data.put("trainingTotalCoast", "");
                data.put("trainingStatus", "");
                data.put("trainingEmpFirstName", "");
                data.put("trainingEmpLastName", "");
                data.put("trainingEmpMiddleName", "");
                data.put("trainingEmpDepartment", "");
                data.put("trainingEmpJobPosition", "");
                _list.add(data);
                return _list;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public Set<HashMap> LoadTrainingCandidateList(String requestedID) {
        try {
            ResultSet _rs = null;
            Set<HashMap> _list = new HashSet<HashMap>();
            _rs = traineeEntity.LoadTrainingCandidate(requestedID);
            if (_rs != null) {
                while (_rs.next()) {
                    HashMap data = new HashMap();
//                    data.put("candidateStatus", _rs.getString("STATUS"));
                    data.put("trainingCandidateID", _rs.getString("CANDIDATE_ID"));
                    data.put("trainingCandidateEmpID", _rs.getString("EMPLOYEE_ID"));
                    data.put("trainingRequestID", _rs.getString("REQUEST_ID"));
//                    data.put("trainingEmpFirstName", _rs.getString("FIRST_NAME"));
//                    data.put("trainingEmpLastName", _rs.getString("LAST_NAME"));
//                    data.put("trainingEmpMiddleName", _rs.getString("MIDDLE_NAME"));
//                    data.put("trainingEmpDepartment", _rs.getString("DEP_DESCRIPTION"));
//                    data.put("trainingEmpJobPosition", _rs.getString("JOB_DESCRIPTION"));
                    _list.add(data);
                }
                return _list;
            } else {
                HashMap data = new HashMap();
                data.put("trainingStatus", "");
                data.put("trainingCandidateID", "0");
                data.put("trainingCandidateEmpID", "0");
                data.put("trainingRequestID", "0");
                data.put("trainingEmpFirstName", "");
                data.put("trainingEmpLastName", "");
                data.put("trainingEmpMiddleName", "");
                data.put("trainingEmpDepartment", "");
                data.put("trainingEmpJobPosition", "");
                _list.add(data);
                return _list;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    /**
     *
     * @param trainingRequestId
     */
    public void deleteTrainingRequest(String trainingRequestId) {
        setTrainingRequestEntity(new TrainingRequestEntity(trainingRequestId));
        getTrainingRequestEntity().delete();
    }

    /**
     *
     * @param approved_by
     * @param approved_date
     * @param approved_from_date
     * @param approved_to_date
     * @param request_id
     * @param remark
     */
    public void addTrainingModification(String approved_by, String approved_date,
            String approved_from_date, String approved_to_date, String request_id, String remark) {
        try {
            getTrainingApprovalEntity().addTrainingModification(approved_by,
                    approved_date, approved_from_date, approved_to_date, request_id, remark);

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    /**
     * The method instatiates the entity TrainingRequestEntity and uses the setter
     * method. The method then calls the addTrainingType method.
     * @param employeeId
     * @param institutionName
     * @param fromDate
     * @param todate
     * @param trainingCost
     * @param trainingType
     * @param trainingCatagory
     * @param priority
     * @param remark
     * @param newOrOld
     */
    public void addTrainingNeedDetail(String employeeId, String institutionName,
            String fromDate, String todate,
            String trainingCost, String trainingType, String trainingCatagory, String priority,
            String remark, String newOrOld) {
        try {
            setTrainingRequestEntity(new TrainingRequestEntity(employeeId,
                    institutionName, fromDate, todate, trainingCost,
                    trainingType, trainingCatagory, priority, remark));
            getTrainingRequestEntity().add(newOrOld);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
    }

    /**
     *
     * @param traineeId
     */
    public void deleteTrainee(String traineeId) {
//        setTraineeEntity(new TraineeEntity(traineeId));
        getTraineeEntity().delete();
    }

    /**
     *
     * @return
     */
    public ArrayList<SelectItem> readTrainingTypeEntityList() {
        ResultSet rs = null;
        try {
            rs = getTrainingTypeEntity().readAllTrainingTypes();
            ArrayList<SelectItem> trainingTypeList = new ArrayList<SelectItem>();
            if (rs.next()) {
                do {
                    trainingTypeList.add(new Option(rs.getString("training_type_id"),
                            rs.getString("description")));
                } while (rs.next());
                trainingTypeList.add(0, new Option(null, "--Select Type--"));
                return trainingTypeList;
            } else {
                trainingTypeList.add(0, new Option(null, "--No training type--"));
                return trainingTypeList;
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TrainingRequestEntity> readProcessedEmployeeTrainingRequests() {
        try {
            TrainingRequestEntity termEntity = new TrainingRequestEntity();
            return termEntity.readProcessedEmployeeTrainingRequests();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] loadProcessedEmployeeTrainingRequests() {

        TrainingRequestEntity termEntity = new TrainingRequestEntity();
        ArrayList<TrainingRequestEntity> resignationRequests = this.readProcessedEmployeeTrainingRequests();
        employeeTrainingRequest = new Option[resignationRequests.size()];
        for (int i = 0; i < resignationRequests.size(); i++) {
            termEntity = resignationRequests.get(i);
            Option resign = new Option(termEntity.getTrainingRequestID(), termEntity.getTrainingRequestName());
            employeeTrainingRequest[i] = resign;
        }
        return employeeTrainingRequest;
    }

    public ArrayList<TrainingRequestEntity> readEmployeeTrainingRequests() {
        try {
            TrainingRequestEntity termEntity = new TrainingRequestEntity();
            return termEntity.readEmployeeTrainingRequests();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public Option[] loadEmployeeTrainingRequests() {

        TrainingRequestEntity termEntity = new TrainingRequestEntity();
        ArrayList<TrainingRequestEntity> resignationRequests = this.readEmployeeTrainingRequests();
        employeeTrainingRequest = new Option[resignationRequests.size()];
        for (int i = 0; i < resignationRequests.size(); i++) {
            termEntity = resignationRequests.get(i);
            Option resign = new Option(termEntity.getTrainingRequestID(), termEntity.getTrainingRequestName());
            employeeTrainingRequest[i] = resign;
        }
        return employeeTrainingRequest;
    }

    public ArrayList<SelectItem> readTrainingCategoryEntityList() {
        ResultSet rs = null;
        try {
            rs = getTrainingTypeEntity().readAllTrainingCategory();
            ArrayList<SelectItem> trainingTypeList = new ArrayList<SelectItem>();
            trainingTypeList.add(new Option(0, "--Select Category--"));
            while (rs.next()) {
//                TrainingTypeEntity trainee = new TrainingTypeEntity(rs.getString("description"), rs.getString("training_type_id"), rs.getString("remark"), rs.getString("parent_training_type"));
                trainingTypeList.add(new Option(rs.getString("category_id"),
                        rs.getString("name")));
            }
            return trainingTypeList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> readTrainingTypeList() {
        ResultSet rs = null;
        try {
            rs = getTrainingTypeEntity().readAllTrainingTypes();
            ArrayList<SelectItem> trainingTypeList = new ArrayList<SelectItem>();
            while (rs.next()) {
//                TrainingTypeEntity trainee = new TrainingTypeEntity(rs.getString("description"), rs.getString("training_type_id"), rs.getString("remark"), rs.getString("parent_training_type"));
                trainingTypeList.add(new Option(rs.getString("training_type_id"),
                        rs.getString("description")));
            }
            return trainingTypeList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> readTrainingCategoryList() {
        ResultSet rs = null;
        try {
            rs = getTrainingTypeEntity().readAllTrainingCategory();
            ArrayList<SelectItem> trainingTypeList = new ArrayList<SelectItem>();
            while (rs.next()) {
//                TrainingTypeEntity trainee = new TrainingTypeEntity(rs.getString("description"), rs.getString("training_type_id"), rs.getString("remark"), rs.getString("parent_training_type"));
                trainingTypeList.add(new Option(rs.getString("category_id"),
                        rs.getString("name")));
            }
            return trainingTypeList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<Option> readNewTrainingRequest() {
        ResultSet rs = null;
        try {
            rs = getTrainingRequestEntity().readNewTrainingRequest();
            ArrayList<Option> newTrainingRequestList = new ArrayList<Option>();
            while (rs.next()) {
                newTrainingRequestList.add(new Option(rs.getString("training_need_id"),
                        rs.getString("first_Name") + rs.getString("middle_Name") +
                        rs.getString("last_Name")));
            }
            return newTrainingRequestList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<TrainerEntity> readTrainerEntityList() {
        try {
            return getTrainerEntity().readAll();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @return
     */
    public ArrayList<TrainerSpecializationEntity> readTrainerSpecializationList() {
        return getTrainerSpecializationEntity().readAll();
    }
//
//    public String searchTrainer(String name) {
//        return getTrainerEntity().searchTrainer(name);
//    }

    /**
     *
     * @param trainerId
     * @return
     */
    public ArrayList<HashMap> searchTrainerSpecializationList(String trainerId) throws SQLException {
//        trainerSpecializationEntity = new TrainerSpecializationEntity(trainerId);
        ResultSet rs = trainerSpecializationEntity.searchTrainerSpecialization(trainerId);
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        while (rs.next()) {
            HashMap data = new HashMap();
            data.put("SpID", rs.getString("TRAINER_SPECIALIZATION_ID"));
            data.put("typeID", rs.getString("TRAINING_TYPE_ID"));
            data.put("minNum", rs.getString("MIN_NO_OF_TRAINEES"));
            data.put("isActive", rs.getString("ISACTIVE"));
            data.put("remark", rs.getString("REMARK"));
            _list.add(data);
        }
        return _list;
    }

    /**
     *
     * @param trainerId
     * @param trainingType
     * @return
     */
    public ArrayList<FeeEntity> searchFeeList(String trainerId, String trainingType) {
//        setFeeEntity(new FeeEntity(feeId));
        return getFeeEntity().search(trainerId, trainingType);
    }

    /**
     *
     * @param feeId
     * @param trainerSpecializationId
     * @param paymentMethod
     * @param amount
     * @param date
     * @param isWorking
     * @param remark
     * @param duration
     * @param trainer
     * @param trainingType
     * @return
     */
    public FeeEntity readFeeToTable(String feeId, String trainerSpecializationId, String paymentMethod, float amount, String date, boolean isWorking, String remark, String duration, String trainer, String trainingType) {
        return feeEntity = new FeeEntity(feeId, trainerSpecializationId, paymentMethod, amount, date, isWorking, remark, duration, trainer, trainingType);
    }

    /**
     *
     * @param trainingTypeId
     * @return
     */
    public OracleCachedRowSet searchTrainingTypeList(
            String trainingTypeId) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(trainingTypeId));
            return getTrainingTypeEntity().search();
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ResultSet searchTrainingCategoryList(String trainingCategoryId) {
        try {
            setTrainingTypeEntity(new TrainingTypeEntity(trainingCategoryId));
            return getTrainingTypeEntity().searchCategory();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @param specializationId
     * @param trainerId
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     * @return
     */
    public TrainerSpecializationEntity readTrainerSpecializationToTable(String specializationId, String trainerId, String trainingType, int minNoOfTrainees, String isActive, String remark) {
        return trainerSpecializationEntity = new TrainerSpecializationEntity(specializationId, trainerId, trainingType, minNoOfTrainees, isActive, remark);
    }

    /**
     *
     * @param description
     * @param awardId
     * @param parentTrainingType
     * @param remark
     * @return
     */
    public TrainingTypeEntity readTrainingTypeToTable(String description, String awardId, String parentTrainingType, String remark) {
        return trainingTypeEntity = new TrainingTypeEntity(description, awardId, parentTrainingType, remark);
    }

    /**
     *
     * @param specializationId
     * @param trainingType
     * @param minNoOfTrainees
     * @param isActive
     * @param remark
     * @return
     */
    public TrainerSpecializationEntity readTrainerSpecializationForFeeToTable(String specializationId, String trainingType, int minNoOfTrainees, String isActive, String remark) {
        return trainerSpecializationEntity = new TrainerSpecializationEntity(specializationId, trainingType, minNoOfTrainees, isActive, remark);
    }

    /**
     *
     * @param feeId
     * @return
     */
    public List<FeeEntity> readFeeList(String feeId) {
        setFeeEntity(new FeeEntity(feeId));
        return getFeeEntity().readAll();
    }

    /**
     *
     * @param trainerId
     * @return
     */
    public TrainerEntity readTrainerEntity(String trainerId) {
        try {
            setTrainerEntity(new TrainerEntity(trainerId));
            return getTrainerEntity().read();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @param specializationId
     * @return
     */
    public TrainerSpecializationEntity readTrainerSpecializationEntity(String specializationId) {
        setTrainerSpecializationEntity(new TrainerSpecializationEntity(specializationId));
        return getTrainerSpecializationEntity().read();
    }

    /**
     *
     * @param feeId
     * @return
     */
    public FeeEntity readFeeEntity(String feeId) {
        setFeeEntity(new FeeEntity(feeId));
        return getFeeEntity().read();
    }
//    public boolean deleteTrainer(String trainerId) {
//        setTrainerEntity(new TrainerEntity(trainerId));
//        return getTrainerEntity().delete(trainerId);
//    }

    /**
     *
     * @param trainerId
     * @return
     */
    public int deleteTrainer(String trainerId) {
        int transactionStatus = 0;
        try {
            setTrainerEntity(new TrainerEntity(trainerId));
            if (getTrainerEntity().delete(trainerId) == true) {
                transactionStatus = 1;
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    /**
     *
     * @param specializationId
     * @return
     */
    public boolean deleteTrainerSpecialization(String specializationId) {
        setTrainerSpecializationEntity(new TrainerSpecializationEntity(specializationId));
        return getTrainerSpecializationEntity().delete();
    }

    /**
     *
     * @param feeId
     * @return
     */
    public boolean deleteFee(String feeId) {
        setFeeEntity(new FeeEntity(feeId));
        return getFeeEntity().delete();
    }

    /**
     *
     * @param trainingTypeId
     * @return
     */
    public boolean deleteTrainingType(String trainingTypeId) {
        setTrainingTypeEntity(new TrainingTypeEntity(trainingTypeId));
        return getTrainingTypeEntity().delete();
    }

    /**
     * @return the traineeEntity
     */
    public TraineeEntity getTraineeEntity() {
        return traineeEntity;
    }

    /**
     *
     * @param requesterId
     * @return
     */
    public ArrayList<TrainingRequestApprovedEntity> readAllRequester(String requesterId) {
        return trainingRequestApprovedEntity.readApprovedTraining(requesterId);
    }

    /**
     *
     * @return
     */
    public ArrayList<TraineeEntity> readAllTrainee() {
        try {
            return getTraineeEntity().readAllTrainee();
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @param userName
     * @return
     */
    public ArrayList<TrainingRequestEntity> getTrainingRequest(String userName) {
        try {
            return getTrainingRequestEntity().requestedTraining(userName);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @param employeeId
     * @return
     */
    public ResultSet readAllTrainingRequest(String employeeId) {
        try {
            return trainingRequestEntity.readAllTrainingRequest(employeeId);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * The method calls the readAllTrainingRequest with the requester employee id as
     * a parameter and uses the result to arrange the data into an <code>ArrayList</code>
     * object of type <code>Option</code>.
     * @param empId the unique identifier of the employee
     * @return an <code>ArrayList</code> object of type <code>Option</code>
     */
    public ArrayList<Option> readTrainingNeed(String empId) {
        ResultSet trainingRequests = null;
        try {
            trainingRequests = trainingRequestEntity.readAllTrainingRequest(empId);
            ArrayList<Option> requestList = new ArrayList<Option>();
            if (trainingRequests.next()) {
                requestList.add(new Option(trainingRequests.getString("training_need_id"),
                        trainingRequests.getString("training_need_id")));
            }
            return requestList;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

//    public ArrayList<TraineeEntity> readEmployeeTraineeStatus(String empId) throws OrpException, SQLException, Exception {
//        return getTraineStatusEntity().readEmployeeTraineeStatus(empId);
//    }
    /**
     *
     * @param traineeId
     * @return
     */
    public TraineeEntity readTrainee(String traineeId) {
//        traineeEntity = new TraineeEntity(traineeId);
        return traineeEntity.readTrainee();
    }

//    public ArrayList<TraineeEntity> readTraineeTraineeStatus(String traineeId) throws OrpException, Exception {
//        return getTraineStatusEntity().readTraineeTraineeStatus(traineeId);
//    }
    /**
     * @param traineeEntity the traineeEntity to set
     */
    public void setTraineeEntity(TraineeEntity traineeEntity) {
        this.traineeEntity = traineeEntity;
    }

    /**
     * @return the traineStatusEntity
     */
    public TraineeEntity getTraineStatusEntity() {
        return traineStatusEntity;
    }

    /**
     * @param traineStatusEntity the traineStatusEntity to set
     */
    public void setTraineStatusEntity(TraineeEntity traineStatusEntity) {
        this.traineStatusEntity = traineStatusEntity;
    }

    /**
     * @return the trainingRequestEntity
     */
    public TrainingRequestEntity getTrainingRequestEntity() {
        return trainingRequestEntity;
    }

    /**
     * @param trainingRequestEntity the trainingRequestEntity to set
     */
    public void setTrainingRequestEntity(TrainingRequestEntity trainingRequestEntity) {
        this.trainingRequestEntity = trainingRequestEntity;
    }

    /**
     * @return the trainingApprovalEntity
     */
    public TrainingApprovalEntity getTrainingApprovalEntity() {
        return trainingApprovalEntity;
    }

    /**
     * @param trainingApprovalEntity the trainingApprovalEntity to set
     */
    public void setTrainingApprovalEntity(TrainingApprovalEntity trainingApprovalEntity) {
        this.trainingApprovalEntity = trainingApprovalEntity;
    }

    /**
     * @return the trainingRequestApprovedEntity
     */
    public TrainingRequestApprovedEntity getTrainingRequestApprovedEntity() {
        return trainingRequestApprovedEntity;
    }

    /**
     * @param trainingRequestApprovedEntity the trainingRequestApprovedEntity to set
     */
    public void setTrainingRequestApprovedEntity(TrainingRequestApprovedEntity trainingRequestApprovedEntity) {
        this.trainingRequestApprovedEntity = trainingRequestApprovedEntity;
    }

    /**
     * @return the txtfFromDate
     */
    public String getTxtfFromDate() {
        return txtfFromDate;
    }

    /**
     * @param txtfFromDate the txtfFromDate to set
     */
    public void setTxtfFromDate(String txtfFromDate) {
        this.txtfFromDate = txtfFromDate;
    }

    /**
     * @return the txtfToDate
     */
    public String getTxtfToDate() {
        return txtfToDate;
    }

    /**
     * @param txtfToDate the txtfToDate to set
     */
    public void setTxtfToDate(String txtfToDate) {
        this.txtfToDate = txtfToDate;
    }

    /**
     * @return the txtfTrainingTypea
     */
    public String getTxtfTrainingTypea() {
        return txtfTrainingTypea;
    }

    /**
     * @param txtfTrainingTypea the txtfTrainingTypea to set
     */
    public void setTxtfTrainingTypea(String txtfTrainingTypea) {
        this.txtfTrainingTypea = txtfTrainingTypea;
    }

    /**
     * @return the txtfStartDateSearch
     */
    public String getTxtfStartDateSearch() {
        return txtfStartDateSearch;
    }

    /**
     * @param txtfStartDateSearch the txtfStartDateSearch to set
     */
    public void setTxtfStartDateSearch(String txtfStartDateSearch) {
        this.txtfStartDateSearch = txtfStartDateSearch;
    }

    /**
     * @return the txtfEndDateSearch
     */
    public String getTxtfEndDateSearch() {
        return txtfEndDateSearch;
    }

    /**
     * @param txtfEndDateSearch the txtfEndDateSearch to set
     */
    public void setTxtfEndDateSearch(String txtfEndDateSearch) {
        this.txtfEndDateSearch = txtfEndDateSearch;
    }

    /**
     * @return the approvedRequestsEntity
     */
    public ApprovedRequestsEntity getApprovedRequestsEntity() {
        return approvedRequestsEntity;
    }

    /**
     * @param approvedRequestsEntity the approvedRequestsEntity to set
     */
    public void setApprovedRequestsEntity(ApprovedRequestsEntity approvedRequestsEntity) {
        this.approvedRequestsEntity = approvedRequestsEntity;
    }

    /**
     * @return the trainerEntity
     */
    public TrainerEntity getTrainerEntity() {
        return trainerEntity;
    }

    /**
     * @param trainerEntity the trainerEntity to set
     */
    public void setTrainerEntity(TrainerEntity trainerEntity) {
        this.trainerEntity = trainerEntity;
    }

    /**
     * @return the feeEntity
     */
    public FeeEntity getFeeEntity() {
        return feeEntity;
    }

    /**
     * @param feeEntity the feeEntity to set
     */
    public void setFeeEntity(FeeEntity feeEntity) {
        this.feeEntity = feeEntity;
    }

    /**
     * @return the trainingTypeEntity
     */
    public TrainingTypeEntity getTrainingTypeEntity() {
        return trainingTypeEntity;
    }

    /**
     * @param trainingTypeEntity the trainingTypeEntity to set
     */
    public void setTrainingTypeEntity(TrainingTypeEntity trainingTypeEntity) {
        this.trainingTypeEntity = trainingTypeEntity;
    }

    /**
     * <p style="margin-top: 0">
     * calls FmsEntities.TrainerEntity.selectAllTrainer() metod
     * and prepare array of Options from the returned resultset object
     * </p>
     * @return returns array of Option object
     */
    public ArrayList<Option> selectAllTrainer() {
        TrainerEntity trainer = new TrainerEntity();
        ResultSet rsTrainer = null;
        ArrayList<Option> trainersList = new ArrayList<Option>();

        try {
            rsTrainer = trainer.selectAllTrainer();
            trainersList.add(new Option(null, "--Select Trainer--"));
            if (rsTrainer.next()) {
                trainersList.add(new Option(rsTrainer.getString("trainer_id"),
                        rsTrainer.getString("name")));
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return trainersList;
    }

    /**
     * <p style="margin-top: 0">
     * calls Bean.Training.TrainerEntity.selectAllTrainer() metod
     * and prepare array of Options from the returned resultset object
     * </p>
     * @param trainerId
     * @return returns array of Option object
     */
    public ArrayList<Option> selectTrainingType(String trainerId) {
        TrainerEntity trainer = new TrainerEntity();
        ResultSet rsTrainingType = null;
        ArrayList<Option> trainers = new ArrayList<Option>();

        try {
            rsTrainingType = trainer.selectTrainingType(trainerId);
            trainers.add(new Option(null, "--Select--"));
            while (rsTrainingType.next()) {

                trainers.add(new Option(rsTrainingType.getString("training_type_id"),
                        rsTrainingType.getString("description")));
            }

        } catch (Exception ex) {

            ErrorLogWriter.writeError(ex);
        }
        return trainers;
    }

    /**
     * <p style="margin-top: 0">
     * calls Bean.Training.TrainingTypeEntity.searchTrainingTypeDescription()
     * metod and prepare array of Options from the returned resultset object
     * </p>
     * @param trainingTypePrefix
     * @return returns array of Option object
     */
    public static ArrayList<Option> searchTrainingTypeDescriptiuon(String trainingTypePrefix) {
        TrainingTypeEntity trainingType = new TrainingTypeEntity();
        ArrayList<Option> trainingTypes = new ArrayList<Option>();
        try {
            ResultSet rsTriningType = trainingType.searchTrainingTypeDescription(trainingTypePrefix);
            while (rsTriningType.next()) {
                String trainingTypeId = rsTriningType.getString("training_type_id");
                String description = rsTriningType.getString("description");
                trainingTypes.add(new Option(trainingTypeId, description));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();

        }
        return trainingTypes;
    }

    /**
     * <p style="margin-top: 0">
     * calls Bean.Training.TrainerEntity.selectAllTrainerForFee() metod
     * and prepare array of Options from the returned resultset object
     * </p>
     * @param trainerNamePrefix
     * @return returns array of Option object
     */
    public ArrayList<Option> searchTrinerForFee(String trainerNamePrefix) {
        TrainerEntity trainer = new TrainerEntity();
        ArrayList<Option> trainers = new ArrayList<Option>();
        try {
            ResultSet rsTrainer = trainer.selectAllTrainerForFee(trainerNamePrefix);
            while (rsTrainer.next()) {
                String trainerId = rsTrainer.getString("trainer_id");
                String trainerName = rsTrainer.getString("name");
                trainers.add(new Option(trainerId, trainerName));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return trainers;
    }

    /**
     *
     * @param trainerName
     * @return
     */
    public ArrayList<HashMap> getTrainerFee(String trainerName) {
        try {
            TrainerEntity trainerEntity1 = new TrainerEntity();
            ResultSet rs = trainerEntity1.selectAllTrainerFeeData(trainerName);
            ArrayList<HashMap> feeData = new ArrayList<HashMap>();

            while (rs.next()) {
                HashMap data = new HashMap();
                //payment_method_id, amount,isworking, duration,training_fee_remark
                data.put("training_type_id", rs.getString("training_type_id"));
                data.put("payment_method_id", rs.getString("payment_method_id"));
                data.put("amount", rs.getString("amount"));
                data.put("isworking", rs.getBoolean("isworking"));
                data.put("duration", rs.getString("duration"));
                data.put("training_fee_remark", rs.getString("training_fee_remark"));
                feeData.add(data);
            }
            return feeData;

        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     * The method calls the readTrainingNeeds entity method with the given
     * requestId and arranges the value of the <code>ResultSet</code> object rs
     * into an <code>ArrayList</code> of type <code>HashMap</code>.
     * @param requestId
     * @return <code>ArrayList</code> of type <code>HashMap</code>.
     */
    public ArrayList<HashMap> readTrainingRequests(String requestId) {
        String priority = null;
        ResultSet rs = trainingRequestEntity.readTrainingNeeds(requestId);
        ArrayList<HashMap> trainingData = new ArrayList<HashMap>();
        try {
            while (rs.next()) {
                HashMap data = new HashMap();
                data.put("training_need_id", rs.getString("training_need_id"));
                data.put("prepared_by", rs.getString("prepared_by"));
                data.put("confirmed_by", rs.getString("confirmed_by"));
                data.put("prepared_date", rs.getString("prepared_date"));
                data.put("confirmed_date", rs.getString("confirmed_date"));
                data.put("name", rs.getString("first_Name") + rs.getString("middle_Name") + rs.getString("last_Name"));
                data.put("department_id", rs.getString("department_id"));
                data.put("deptDesc", rs.getString("deptDesc"));
                data.put("training_type", rs.getString("training_type"));
                data.put("trainingTypeDesc", rs.getString("trainingTypeDesc"));
                data.put("training_category", rs.getString("training_category"));
                data.put("trainerName", rs.getString("trainerName"));
                data.put("training_start_date", rs.getString("training_start_date"));
                data.put("training_end_date", rs.getString("training_end_date"));
                data.put("trainer", rs.getString("trainer"));
                data.put("trainee_no", rs.getString("trainee_no"));
                data.put("cost_per_person", rs.getString("cost_per_person"));
                priority = rs.getString("priority");
                if (priority.equals("1")) {
                    priority = "High";
                } else if (priority.equals("2")) {
                    priority = "Above Normal";
                } else if (priority.equals("3")) {
                    priority = "Normal";
                } else if (priority.equals("4")) {
                    priority = "Below Normal";
                } else if (priority.equals("5")) {
                    priority = "Low";
                }
                data.put("priority", priority);
                data.put("remark", rs.getString("remark"));
                trainingData.add(data);
            }
            return trainingData;
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    /**
     *
     * @param requestId
     * @return
     */
    public ResultSet readTrainees(String requestId) {
        try {
            return traineeEntity.readTrainee(requestId);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<TrainerList> TrainerNametoAutoList() {

        try {
            ResultSet rs = traineeEntity.searchTrainerNametoAuto();
            ArrayList<TrainerList> proformaoption = new ArrayList<TrainerList>();
            while (rs.next()) {
                TrainerList taList = new TrainerList(rs.getString("NAME"), rs.getString("TRAINER_ID"));
                proformaoption.add(taList);

            }
            return proformaoption;
        } catch (Exception ex) {
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

    public ArrayList<SelectItem> TrainerNametoDDList() {

        try {
            ResultSet rs = traineeEntity.searchTrainerNametoAuto();
            ArrayList<SelectItem> proformaoption = new ArrayList<SelectItem>();
            if (rs.next()) {
                do {
                    proformaoption.add(new Option(rs.getString("TRAINER_ID"), rs.getString("NAME")));
                } while (rs.next());
                proformaoption.add(0, new Option(null, "-- Select Instutision --"));
                return proformaoption;
            } else {
                proformaoption.add(0, new Option(null, "No Inistutision was found"));
                return proformaoption;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> readTrainingRequestByDepartment(String departmentId) {
        try {

            return trainingRequestEntity.readTrainingRequestByDepartment(departmentId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> trainerInformation() {

        try {
            OracleCachedRowSet rs = traineeEntity.trainerInformation();
            ArrayList<HashMap> trainerInfo = new ArrayList<HashMap>();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("trainerId", rs.getString("TRAINER_ID"));
                hm.put("companyNane", rs.getString("NAME"));
                hm.put("contactAddress", rs.getString("CONTACT_PERSON"));
                hm.put("remark", rs.getString("REMARK"));
                trainerInfo.add(hm);
            }
            return trainerInfo;

        } catch (Exception ex) {
//             ex.getMessage());
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int saveTrainingType(String category, String description, String remark) {
        try {
            TrainingTypeEntity trType = new TrainingTypeEntity(category, description, remark);
            return trType.saveTrainingType(trType);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 1;
        }
    }

    public int addTrainer(Set<HashMap> trainerInfo) {
        int transactionStatus = 0;
        try {
            if (trainerInfo.size() > 0) {
                for (HashMap hm : trainerInfo) {
                    setTrainerEntity(new TrainerEntity(hm.get("companyName").toString(), hm.get("contactAddress").toString(), hm.get("remark").toString()));
                    if (getTrainerEntity().add() == 1) {
                        transactionStatus = 1;
                    }
                }
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }
   public Option[] decisionType() {
        Option type[] = new Option[4];
        Option onDispay = new Option("---- Decision ----");
        Option approve = new Option("Approve");
        Option postponed = new Option("Postponed");
        Option reject = new Option("Reject");
        type[0] = onDispay;
        type[1] = approve;
        type[2] = postponed;
        type[3] = reject;
        return type;
    }
}
