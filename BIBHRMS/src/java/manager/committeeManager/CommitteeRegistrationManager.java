/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.committeeManager;

import entity.committeeEntity.CommitteeRegistrationEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class CommitteeRegistrationManager {

    CommitteeRegistrationEntity committeeRegistrationEntity = new CommitteeRegistrationEntity();

    public boolean saveCommitttees(ArrayList<CommitteeModel> committeeList) {
        ArrayList<CommitteeModel> toBeInserted = new ArrayList<CommitteeModel>();
        ArrayList<CommitteeModel> toBeUpdated = new ArrayList<CommitteeModel>();
        ArrayList<CommitteeModel> toBeDeleted = new ArrayList<CommitteeModel>();
        try {
            for (CommitteeModel currentCommittee : committeeList) {
                if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCommittee);
                } else if (currentCommittee.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCommittee);
                }
                committeeRegistrationEntity.insertCommittees(toBeInserted);
                committeeRegistrationEntity.updateCommittees(toBeUpdated);
                committeeRegistrationEntity.deleteCommittees(toBeDeleted);
            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }



    public ArrayList<CommitteeModel> getAllActiveCommittees() {
        ArrayList<CommitteeModel> committeeList = new ArrayList<CommitteeModel>();
        try {
            ResultSet _rs = committeeRegistrationEntity.selectActiveCommittees();
            while (_rs.next()) {
                CommitteeModel currentCommittee = new CommitteeModel();
                currentCommittee.setCommitteeId(_rs.getInt("COMMITTEE_ID"));//
                currentCommittee.setCommitteeName(_rs.getString("COMMITTEE_NAME"));
                currentCommittee.setCommitteeStatus(_rs.getString("STATUS"));//
                currentCommittee.setCommitteeType(_rs.getString("COMMITTEE_TYPE"));//
                currentCommittee.setDescription(_rs.getString("DESCRIPTION"));//
                currentCommittee.setEstablishedDate(_rs.getString("ESTABLISHED_DATE"));//
                currentCommittee.setNumberOfmembers(_rs.getInt("NUMBER_OF_MEMBERS"));//
                currentCommittee.setResponsiblity(_rs.getString("RESPONSIBLITY"));//
                currentCommittee.setParentId(_rs.getInt("PARENT_ID"));//
                currentCommittee.setDatabaseStatus("Old");  //
                currentCommittee.setFormerName(_rs.getString("FORMER_NAME"));  //
                currentCommittee.setFormerDepartment(_rs.getString("FORMER_DEPARTMENT"));  //
                currentCommittee.setFormerPosition(_rs.getString("FORMER_POSITION"));  //
                committeeList.add(currentCommittee);
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllActiveCommitteesSelectItem() {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = committeeRegistrationEntity.selectActiveCommittees();
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_TYPE_CODE"), _rs.getString("COMMITEE_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllCommittees(String committeeType) {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = committeeRegistrationEntity.selectAllCommittees(committeeType);
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_ID"), _rs.getString("COMMITTEE_NAME")));
            }
            if (committeeList.size() > 0) {
                committeeList.add(0, new SelectItem(-1, "--SELECT COMMITTEE--"));
            } else {
                committeeList.add(0, new SelectItem(-1, "--NO COMMITTEE--"));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAllCommittees(String committeeType, String Status) {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = committeeRegistrationEntity.selectAllCommittees(committeeType);
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_TYPE_CODE"), _rs.getString("COMMITEE_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

     public boolean saveCommiteeType(String commiteeName, String committeeDescribtion) {
         try{
         committeeRegistrationEntity.insertCommityName(commiteeName,committeeDescribtion);
         return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    
    public ArrayList<SelectItem> getAllCommitteesTypeForLu()
    {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = committeeRegistrationEntity.selectAllCommitteesFromLu();
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_TYPE_CODE"), _rs.getString("COMMITEE_NAME")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }



    public ArrayList<SelectItem> getCommitteeTypes() {
        ArrayList<SelectItem> committeeTypes = new ArrayList<SelectItem>();
        try {
            committeeTypes.add(new SelectItem("-1", "Select"));
            committeeTypes.add(new SelectItem("Discipline", "Discipline"));
            committeeTypes.add(new SelectItem("Purchasing", "Purchasing"));
            committeeTypes.add(new SelectItem("Xxxx", "Xxxx"));
            committeeTypes.add(new SelectItem("Education Request", "Education Request"));
            committeeTypes.add(new SelectItem("PromotionCommittee", "Promotion Committee"));
            return committeeTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getCommitteeStatus() {
        ArrayList<SelectItem> committeeStatus = new ArrayList<SelectItem>();
        try {
            committeeStatus.add(new SelectItem("-1", "Select"));
            committeeStatus.add(new SelectItem("Active", "Active"));
            committeeStatus.add(new SelectItem("Inactive", "Inactive"));
            return committeeStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getMemberPermanentContract() {
        ArrayList<SelectItem> committeeStatus = new ArrayList<SelectItem>();
        try {
            committeeStatus.add(new SelectItem("-1", "Select"));
            committeeStatus.add(new SelectItem("Perm", "Permanent"));
            committeeStatus.add(new SelectItem("Temp", "Temporary"));
            return committeeStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
