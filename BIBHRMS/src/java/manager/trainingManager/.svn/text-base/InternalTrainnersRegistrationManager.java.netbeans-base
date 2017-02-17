/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.InternalTrainnersRegistrationEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class InternalTrainnersRegistrationManager {

    InternalTrainnersModel internalTrainnersModel;
    InternalTrainnersRegistrationEntity internalTrainnersRegistrationEntity;//= new InternalTrainnersRegistrationEntity();



    public ArrayList<InternalTrainnersModel> getAllTrainnerMembers(int trainnerGroupId) {
        internalTrainnersRegistrationEntity = new InternalTrainnersRegistrationEntity();
        ArrayList<InternalTrainnersModel> trainnersList = new ArrayList<InternalTrainnersModel>();
        try {
            ResultSet _rs = internalTrainnersRegistrationEntity.selectTrainnerMembers(trainnerGroupId);
            while (_rs.next()) {
               int trainnerMemberId = _rs.getInt("MEMBER_ID");
                String employeeId = _rs.getString("EMPLOYEE_ID");
                String employeeFullName = _rs.getString("FIRST_NAME")+" "+_rs.getString("MIDDLE_NAME")+" "+" "+_rs.getString("LAST_NAME");
                String employeeResponsibility = _rs.getString("RESPONSIBLITY");
                String assignedDate=  _rs.getString("ASSIGNED_DATE");
                String memberStatus= _rs.getString("STATUS");
                String databaseStatus = "Old";
                internalTrainnersModel = new InternalTrainnersModel ( trainnerGroupId,  trainnerMemberId,  employeeId,  assignedDate,  memberStatus,  employeeFullName,  employeeResponsibility,  databaseStatus) ;
                trainnersList.add(internalTrainnersModel);
            }
            _rs.close();
            return trainnersList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    public ArrayList<SelectItem> getAllTrrainnerGroups() {
        internalTrainnersRegistrationEntity = new InternalTrainnersRegistrationEntity();
        ArrayList<SelectItem> trainnersList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = internalTrainnersRegistrationEntity.selectAllInternalTrainnerGroups();
            trainnersList.add(new SelectItem("-1", "--SELECT INTERNAL_TRAINER--"));
            while (_rs.next()) {
                SelectItem currentTrainner = new SelectItem(_rs.getString("INSTITUTION_ID"), _rs.getString("INSTITUTION_NAME"));
                trainnersList.add(currentTrainner);
            }
            _rs.close();
            return trainnersList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

//    public InternalTrainnersModel getTrainnerGroupDetail(int trainnerGroupId) {
//        internalTrainnersRegistrationEntity = new InternalTrainnersRegistrationEntity();
//        try {
//            ResultSet _rs = internalTrainnersRegistrationEntity.selectInternalTrainnerGroup(trainnerGroupId);
//            if (_rs.next()) {
//                String trainnerGroupName = _rs.getString("TRAINNER_GROUP_NAME");
//                String trainnerGroupStatus = _rs.getString("STATUS");
//                String description = _rs.getString("DESCRIPTION");
//                String trainingCategory = _rs.getString("TRAINING_CATEGORY");
//                internalTrainnersModel = new InternalTrainnersModel(trainnerGroupId, trainnerGroupName, trainnerGroupStatus, description, trainingCategory);
//            } else {
//                internalTrainnersModel = new InternalTrainnersModel(-1);
//            }
//            _rs.close();
//            return internalTrainnersModel;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }
//
    public InternalTrainnersModel getTrainnerGroupDetail(int trainnerGroupId) {
        internalTrainnersRegistrationEntity = new InternalTrainnersRegistrationEntity();
        try {
            ResultSet _rs = internalTrainnersRegistrationEntity.selectInternalTrainnerGroup(trainnerGroupId);
            if (_rs.next()) {
                String trainnerGroupName = _rs.getString("NSTITUTION_NAME");
                String trainnerGroupStatus = _rs.getString("STATUS");
                String description = _rs.getString("NSTITUTION_DESCRIPTION");
                String trainingCategory = _rs.getString("LOCATION_CATEGORY");
                internalTrainnersModel = new InternalTrainnersModel(trainnerGroupId, trainnerGroupName, trainnerGroupStatus, description, trainingCategory);
            } else {
                internalTrainnersModel = new InternalTrainnersModel(-1);
            }
            _rs.close();
            return internalTrainnersModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public boolean saveTrainners(InternalTrainnersModel trainnerGroupAttribute, ArrayList<InternalTrainnersModel> trainnersList) {
        try {
            if (internalTrainnersRegistrationEntity.insertTrainnerGroupAttribute(trainnerGroupAttribute)) {
                internalTrainnersRegistrationEntity.insertTrainners(trainnersList);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public boolean updateTrainners(InternalTrainnersModel trainnerGroupAttribute, ArrayList<InternalTrainnersModel> trainnersList) {
        ArrayList<InternalTrainnersModel> toBeInserted = new ArrayList<InternalTrainnersModel>();
        ArrayList<InternalTrainnersModel> toBeUpdated = new ArrayList<InternalTrainnersModel>();
        ArrayList<InternalTrainnersModel> toBeDeleted = new ArrayList<InternalTrainnersModel>();
        try {

            if (internalTrainnersRegistrationEntity.updateTrainnerGroupAttribute(trainnerGroupAttribute)) {
                for (InternalTrainnersModel currentTrainner : trainnersList) {
                    if (currentTrainner.getDatabaseStatus().equalsIgnoreCase("New")) {
                        toBeInserted.add(currentTrainner);
                    } else if (currentTrainner.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                        toBeUpdated.add(currentTrainner);
                    } else if (currentTrainner.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                        toBeDeleted.add(currentTrainner);
                    }
                    internalTrainnersRegistrationEntity.insertTrainners(toBeInserted);
                    internalTrainnersRegistrationEntity.updateTrainners(toBeUpdated);
                    internalTrainnersRegistrationEntity.deleteTrainners(toBeDeleted);
                }
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
}
