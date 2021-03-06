/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.TrainingProgressCostEntity;
import fphrms.Training.TrainingProgressCost;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.educationManager.EducationCostModel;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Mugher
 */
public class TrainingProgressCostManger {
    double trainingCostId = 0.0;
    double trainingFee = 0.0;
    double intertainmentFee = 0.0;
    double transportFee = 0.0;
    double feeForTrainer = 0.0;
    double allowanceFee = 0.0;
    double stationaryFee = 0.0;
    double otherFee = 0.0;
    double costPerPerson = 0.0;
    String trainingType = null;
    String startDate = null;
    String endDate = null;

    public TrainingProgressCostManger(){

    }
    public TrainingProgressCostManger(double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFee,double otherFee,double costPerPerson){
        this.trainingFee = trainingFee;
        this.intertainmentFee = intertainmentFee;
        this.trainingFee = transportFee;
        this.feeForTrainer = feeForTrainer;
        this.allowanceFee = allowanceFee;
        this.stationaryFee = stationaryFee;
        this.otherFee = otherFee;
        this.costPerPerson = costPerPerson;
    }

    public TrainingProgressCostManger(double trainingCostId,String trainingType,double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFee,double otherFee,double costPerPerson,String startDate,String endDate){
        this.trainingCostId = trainingCostId;
        this.trainingType = trainingType;
        this.trainingFee = trainingFee;
        this.intertainmentFee = intertainmentFee;
        this.trainingFee = transportFee;
        this.feeForTrainer = feeForTrainer;
        this.allowanceFee = allowanceFee;
        this.stationaryFee = stationaryFee;
        this.otherFee = otherFee;
        this.costPerPerson = costPerPerson;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public double getAllowanceFee() {
        return allowanceFee;
    }

    public void setAllowanceFee(double allowanceFee) {
        this.allowanceFee = allowanceFee;
    }

    public double getCostPerPerson() {
        return costPerPerson;
    }

    public void setCostPerPerson(double costPerPerson) {
        this.costPerPerson = costPerPerson;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public double getFeeForTrainer() {
        return feeForTrainer;
    }

    public void setFeeForTrainer(double feeForTrainer) {
        this.feeForTrainer = feeForTrainer;
    }

    public double getIntertainmentFee() {
        return intertainmentFee;
    }

    public void setIntertainmentFee(double intertainmentFee) {
        this.intertainmentFee = intertainmentFee;
    }

    public double getOtherFee() {
        return otherFee;
    }

    public void setOtherFee(double otherFee) {
        this.otherFee = otherFee;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public double getStationaryFee() {
        return stationaryFee;
    }

    public void setStationaryFee(double stationaryFee) {
        this.stationaryFee = stationaryFee;
    }

    public double getTrainingCostId() {
        return trainingCostId;
    }

    public void setTrainingCostId(double trainingCostId) {
        this.trainingCostId = trainingCostId;
    }

    public double getTrainingFee() {
        return trainingFee;
    }

    public void setTrainingFee(double trainingFee) {
        this.trainingFee = trainingFee;
    }

    public String getTrainingType() {
        return trainingType;
    }

    public void setTrainingType(String trainingType) {
        this.trainingType = trainingType;
    }

    public double getTransportFee() {
        return transportFee;
    }

    public void setTransportFee(double transportFee) {
        this.transportFee = transportFee;
    }
    

    TrainingProgressCostEntity trainingProgressCostEntity = new TrainingProgressCostEntity();

    public ArrayList<EducationCostModel> getTrainingCosts(String budjetYear,  int trainingId, String batchCode) {
        ArrayList<EducationCostModel> costLists = new ArrayList<EducationCostModel>();
        try {
            ResultSet _rs = trainingProgressCostEntity.selectTrainingCosts( budjetYear,   trainingId,  batchCode);
            while (_rs.next()) {
                String costTypeId = _rs.getString("TRAINING_PROGRESS_COST_ID");
                String costTypeCategory = _rs.getString("COST_CATEGORY_ID");
                String costTypeName = _rs.getString("COST_NAME");
                int quantityOrAmount = _rs.getInt("FACTOR");
                double unitCost = _rs.getDouble("UNIT_COST");
//                double totalCost = unitCost * quantityOrAmount;
                double totalCost = _rs.getDouble("TOTAL");
                String documentReferenceNumber = _rs.getString("DOC_REF_NUMBER");
                String databaseStatus = "Edited";
                EducationCostModel educationCostModel = new EducationCostModel(costTypeId, costTypeCategory, costTypeName, budjetYear, trainingId, quantityOrAmount, unitCost, totalCost, documentReferenceNumber, databaseStatus);
                costLists.add(educationCostModel);
            }
            _rs.close();
            return costLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<EducationCostModel> getStationaryCosts() {
        ArrayList<EducationCostModel> costLists = new ArrayList<EducationCostModel>();
        try {
            ResultSet _rs = trainingProgressCostEntity.selectStationaryCosts();
            while (_rs.next()) {
                String stationaryName = _rs.getString("DESCRIPTION");
                double price = _rs.getDouble("PRICE");
                EducationCostModel educationCostModel = new EducationCostModel(stationaryName, price);
                costLists.add(educationCostModel);
            }
            _rs.close();
            return costLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<EducationCostModel> getAllowance(ArrayList<TrainingParticipantModel> trainingParticipantList) {
        ArrayList<EducationCostModel> costLists = new ArrayList<EducationCostModel>();
        try {
            for(TrainingParticipantModel obj:trainingParticipantList){
            ResultSet _rs = trainingProgressCostEntity.selectAllowance(obj.getEmployeeId());
            while (_rs.next()) {
                String rankId = _rs.getString("RANK_ID");
                double salary = _rs.getDouble("SALARY");
                EducationCostModel educationCostModel = new EducationCostModel(rankId, salary);
                costLists.add(educationCostModel);
            }
            _rs.close();
            }
            return costLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public double getRate(double salary) {
        ArrayList<EducationCostModel> costLists = new ArrayList<EducationCostModel>();
        double allowance = 0.0;
        try {
//            for(TrainingParticipantModel obj:trainingParticipantList){
            ResultSet _rs = trainingProgressCostEntity.selectRate();
            while (_rs.next()) {
                double bigenSalary = _rs.getDouble("BEGINING_SALARY");
                double endSalary = _rs.getDouble("END_SALARY");
                double rate = _rs.getDouble("RATE");
                if((salary >=bigenSalary) && (salary <=endSalary)) {
                    allowance = rate;
                }
//                EducationCostModel educationCostModel = new EducationCostModel(fullName, salary);
//                costLists.add(educationCostModel);
            }
            _rs.close();
//            }
            return allowance;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0.0;
        }
    }

    public double getRateByRank(String rankId) {
        try {
            double rate = 0.0;
//            for(TrainingParticipantModel obj:trainingParticipantList){
            ResultSet _rs = trainingProgressCostEntity.selectRateByRank(rankId);
            while (_rs.next()) {
                rate = _rs.getDouble("RATE");
//                EducationCostModel educationCostModel = new EducationCostModel(fullName, salary);
//                costLists.add(educationCostModel);
            }
            _rs.close();
//            }
            return rate;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0.0;
        }
    }

    public EducationCostModel getTrainingProgressAttributes(String budjetYear,  int trainingId, String batchCode) {
        EducationCostModel progressCostAttributes = new EducationCostModel();
        try {
            ResultSet _rs = trainingProgressCostEntity.selectTrainingCosts( budjetYear,   trainingId,  batchCode);
            if (_rs.next()) {
                String costTypeId = _rs.getString("TRAINING_PROGRESS_COST_ID");
                String costTypeCategory = _rs.getString("COST_CATEGORY_ID");
                String costTypeName = _rs.getString("COST_NAME");
                int quantityOrAmount = _rs.getInt("FACTOR");
                double unitCost = _rs.getDouble("UNIT_COST");
                double totalCost = unitCost * quantityOrAmount;
                String documentReferenceNumber = _rs.getString("DOC_REF_NUMBER");
                String databaseStatus = "Old";
                EducationCostModel educationCostModel = new EducationCostModel(costTypeId, costTypeCategory, costTypeName, budjetYear, trainingId, quantityOrAmount, unitCost, totalCost, documentReferenceNumber, databaseStatus);
            }
            _rs.close();
            return progressCostAttributes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveTrainingCosts(ArrayList<EducationCostModel> trainingCostList) {
        ArrayList<EducationCostModel> toBeInserted = new ArrayList<EducationCostModel>();
        ArrayList<EducationCostModel> toBeUpdated = new ArrayList<EducationCostModel>();
        ArrayList<EducationCostModel> toBeDeleted = new ArrayList<EducationCostModel>();
        try {
            for (EducationCostModel currentCost : trainingCostList) {
                if (currentCost.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCost);
                } else if (currentCost.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCost);
                } else if (currentCost.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCost);
                }
            }
                trainingProgressCostEntity.insertTrainingCosts(toBeInserted);
                trainingProgressCostEntity.updateTrainingCosts(toBeUpdated);
                trainingProgressCostEntity.deleteTrainingCosts(toBeDeleted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveTrainingCostPerPerson(ArrayList<TrainingParticipantModel> participants, String trainingType, String startDate, String endTime, double costPerPerson, String startMonth, String startYear, String assignedInstitutionId){
        try {
        boolean checkSave = trainingProgressCostEntity.insertTrainingCostPerPerson(participants,trainingType,startDate,endTime,costPerPerson,startMonth,startYear,assignedInstitutionId);
        if(checkSave)
        return true;
        else
            return false;
         } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean saveDetailTrainingCostPerPerson(ArrayList<TrainingParticipantModel> participants,String trainingType,double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFee,double otherFee,double costPerPerson,String startDate, String endDate, String budjetYear){
        try {
        boolean checkSave = trainingProgressCostEntity.insertDetailTrainingCostPerPerson(participants,trainingType,trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, stationaryFee, otherFee, costPerPerson, startDate, endDate, budjetYear);
        if(checkSave)
        return true;
        else
            return false;
         } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    
    public boolean updateTrainingCostPerPerson(ArrayList<TrainingProgressModel> participants, String trainingType, String startDate, String endTime, double costPerPerson, String startMonth, String startYear){
        try {
        boolean checkSave = trainingProgressCostEntity.updateTrainingCostPerPerson(participants,trainingType,startDate,endTime,costPerPerson,startMonth,startYear);
        if(checkSave)
        return true;
        else
            return false;
         } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateDetailTrainingCostPerPerson(ArrayList<TrainingProgressCostManger> participants,String trainingType,double trainingFee,double intertainmentFee,double transportFee,double feeForTrainer,double allowanceFee,double stationaryFee,double otherFee,double costPerPerson,String startDate, String endDate, String budjetYear){
        try {
        boolean checkSave = trainingProgressCostEntity.updateDetailTrainingCostPerPerson(participants,trainingType,trainingFee, intertainmentFee, transportFee, feeForTrainer, allowanceFee, stationaryFee, otherFee, costPerPerson, startDate, endDate, budjetYear);
        if(checkSave)
        return true;
        else
            return false;
         } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }


    public ArrayList<TrainingProgressModel> checkSaved(String trainingType, String startDate, String endDate){
         ArrayList<TrainingProgressModel> trainingLists = new ArrayList<TrainingProgressModel>();
        try {
            ResultSet _rs = trainingProgressCostEntity.checkTrainingCostPerPerson(trainingType,startDate,endDate);
            while (_rs.next()) {
                int id = _rs.getInt("ID");
                String trainingTypeCategory = _rs.getString("TRAININGORCOURSE_NAME");
                String startDates = _rs.getString("START_DATE");
                String endDates = _rs.getString("END_DATE");
                String paymentForTraining = _rs.getString("PAYMENT_FOR_TRAINING");       
                TrainingProgressModel educationCostModel = new TrainingProgressModel(id,trainingTypeCategory,startDates,endDates, paymentForTraining);
                trainingLists.add(educationCostModel);
            }
            _rs.close();
            return trainingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<TrainingProgressCostManger> checkDetailCostSaved(String trainingType, String startDate, String endDate){
         ArrayList<TrainingProgressCostManger> trainingLists = new ArrayList<TrainingProgressCostManger>();
        try {
            ResultSet _rs = trainingProgressCostEntity.checkDetailedTrainingCostPerPerson(trainingType,startDate,endDate);
            while (_rs.next()) {
                double id = _rs.getDouble("HR_LU_TRAINING_COST_DETAIL_ID");
                String trainingTypeCategory = _rs.getString("TRAINING_NAME");
                String startDates = _rs.getString("START_DATE");
                String endDates = _rs.getString("END_DATE");
                double paymentForTraining = _rs.getDouble("COSTPERPERSON");
                double training = _rs.getDouble("TRAINING_FEE");
                double intertainment = _rs.getDouble("INTERTAINMENT_FEE");
                double transport = _rs.getDouble("TRANSPORT_FEE");
                double forTrainer = _rs.getDouble("FEE_FOR_TRAINER");
                double allowance = _rs.getDouble("ALLOWANCE_FEE");
                double stationary = _rs.getDouble("STATIONARY_FEE");
                double other = _rs.getDouble("OTHER_FEES");
                TrainingProgressCostManger trainingProgressCostManager = new TrainingProgressCostManger(id,trainingTypeCategory,training,intertainment,transport,forTrainer,allowance,stationary,other,paymentForTraining,startDates,endDates);
                trainingLists.add(trainingProgressCostManager);
            }
            _rs.close();
            return trainingLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public String gettrainingCategoryName(String costCategoryId) {
        String currentCostTypeName = new String();
        try {
            ResultSet _rs = trainingProgressCostEntity.selectTrainingCategoryName(costCategoryId);
            if (_rs.next()) {

                currentCostTypeName = _rs.getString("COST_TYPE_NAME");//

            } else {
                currentCostTypeName = "NONE";//
            }
            _rs.close();
            return currentCostTypeName;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//        boolean checkSave = false;
//        try {
//        ResultSet checkSavedTraining = trainingProgressCostEntity.checkTrainingCostPerPerson(trainingType,startDate,endDate);
//        while (checkSavedTraining.next()){
//            checkSave = true;
//        }
//
//            return checkSave;
//         } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return false;
//        }
    
}
