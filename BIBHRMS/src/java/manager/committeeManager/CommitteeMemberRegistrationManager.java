/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.committeeManager;

import entity.committeeEntity.CommitteeMemberRegistrationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Mugher
 */
public class CommitteeMemberRegistrationManager {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currentDay=dateFormat.format(new Date());
    CommitteeMemberRegistrationEntity committeeMemberRegistrationEntity = new CommitteeMemberRegistrationEntity();



    public boolean saveCommittteeMembers(ArrayList<CommitteeMemberModel> committeeList) {
        ArrayList<CommitteeMemberModel> toBeInserted = new ArrayList<CommitteeMemberModel>();
        ArrayList<CommitteeMemberModel> toBeUpdated = new ArrayList<CommitteeMemberModel>();
        ArrayList<CommitteeMemberModel> toBeDeleted = new ArrayList<CommitteeMemberModel>();
        try {
            for (CommitteeMemberModel currentCommitteeMember : committeeList) {
                if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(currentCommitteeMember);
                } else if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(currentCommitteeMember);
                } else if (currentCommitteeMember.getDatabaseStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(currentCommitteeMember);
                }
            }
            committeeMemberRegistrationEntity.insertCommitteeMembers(toBeInserted);
            committeeMemberRegistrationEntity.updateCommitteeMembers(toBeUpdated);
            committeeMemberRegistrationEntity.deleteCommitteeMembers(toBeDeleted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<CommitteeMemberModel> getAllCommitteeMembers(int committeeId) {
        ArrayList<CommitteeMemberModel> committeeList = new ArrayList<CommitteeMemberModel>();
        try {
            ResultSet _rs = committeeMemberRegistrationEntity.selectAllCommitteeMembers(committeeId);
            while (_rs.next()) {
                CommitteeMemberModel currentCommitteeMember = new CommitteeMemberModel();
                currentCommitteeMember.setCommitteeMemberId(_rs.getInt("COMMITTEE_MEMBER_ID"));//
                currentCommitteeMember.setCommitteeId(_rs.getInt("COMMITTEE_ID"));//
                currentCommitteeMember.setEmployeeId(_rs.getString("EMP_ID"));
                currentCommitteeMember.setEmployeeFullName(_rs.getString("FIRST_NAME")+""+_rs.getString("MIDDLE_NAME")+""+_rs.getString("LAST_NAME"));
                currentCommitteeMember.setMemberResponsibility(_rs.getString("RESPONSIBLITY"));//
                currentCommitteeMember.setMemberStatus(_rs.getString("STATUS"));//
                currentCommitteeMember.setPermanentOrTemporary(_rs.getString("PERM_OR_TEMP"));//
                currentCommitteeMember.setAssignedDate(_rs.getString("ASSIGNED_DATE"));//
                currentCommitteeMember.setRemark(_rs.getString("REMARK"));//
                currentCommitteeMember.setDatabaseStatus("Old");//
                currentCommitteeMember.setCommeentGivenDay(currentDay);
                committeeList.add(currentCommitteeMember);
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

     public int getAllCommiteeSize(int disciplineCommiteeId) {
        int sizeofmembers;
        int counter=0;
         ResultSet _rs=null;
        try {
            _rs = committeeMemberRegistrationEntity.getAllCommitee();

         while(_rs.next()){
           counter++;

         }
         sizeofmembers=counter;
         return sizeofmembers;
           } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }
 public int getAllEducatonCommiteeSize(int deciderCommitteeId) {
        int sizeofmembers;
        int counter=0;
         ResultSet _rs=null;
        try {
            _rs = committeeMemberRegistrationEntity.getAllEduacCommitee(deciderCommitteeId);

         while(_rs.next()){
           counter++;

         }
         sizeofmembers=counter;
         return sizeofmembers;
           } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }
    public ArrayList<CommitteeMemberModel> getActiveCommitteeMembersWithUserName(int committeeId) {
        ArrayList<CommitteeMemberModel> committeeList = new ArrayList<CommitteeMemberModel>();
        try {
            ResultSet _rs = committeeMemberRegistrationEntity.selectAllCommitteeMembers(committeeId);
            while (_rs.next()) {
                CommitteeMemberModel currentCommitteeMember = new CommitteeMemberModel();
                currentCommitteeMember.setCommitteeMemberId(_rs.getInt("COMMITTEE_MEMBER_ID"));//
                currentCommitteeMember.setCommitteeId(_rs.getInt("COMMITTEE_ID"));//
                currentCommitteeMember.setEmployeeId(_rs.getString("EMP_ID"));
                currentCommitteeMember.setEmployeeFullName(_rs.getString("EMP_ID"));
                currentCommitteeMember.setMemberResponsibility(_rs.getString("RESPONSIBLITY"));//
                currentCommitteeMember.setMemberStatus(_rs.getString("STATUS"));//
                currentCommitteeMember.setAssignedDate(_rs.getString("ASSIGNED_DATE"));//
                currentCommitteeMember.setRemark(_rs.getString("REMARK"));//
                currentCommitteeMember.setDatabaseStatus("Old");  //
                committeeList.add(currentCommitteeMember);
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getActiveCommitteesMembersSelectItem(int committeeId) {
        ArrayList<SelectItem> committeeList = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = committeeMemberRegistrationEntity.selectActiveCommitteeMembers(committeeId);
            while (_rs.next()) {
                committeeList.add(new SelectItem(_rs.getInt("COMMITTEE_MEMBER_ID"), _rs.getString("EMP_ID")));
            }
            _rs.close();
            return committeeList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

}
