/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.powerDeligationManager;

/**
 *
 * @author Biruk
 */
public class PowerDelegationModel {
    String requesterID;
    String requesterFullName;
    String requesterPosition;
    String requesterDepartment;
    String requesterRank;
    String delegateID;
    String delegateFullName;
    String delegatePosition;
    String delegateDepartment;
    String delegateRank;
    String delegatedPosition;
    String delegatedRank;
    String delegatedSatrtDay;
    String delegateEndDay;
    String delegationReasoun;
    String delegtorID;
    String delegatorFullName;
    String delegtorRank;
    String delegtorDepartment;
    String delegtorPosition;


    public PowerDelegationModel(String requesterID, String requesterFullName, String requesterDepartment, String requesterPosition, String requesterRank, String delegateFullName, String delegateID, String delegatePosition, String delegateDepartment,String delegateRank, String delegatedSatrtDay, String delegateEndDay, String delegatedPosition, String delegatedRank, String delegationReasoun,String delegatorID,String delegatorFullName,String delegatorDepartment,
            String delegatorPosition,String delegatorRank) {
        this.requesterID=requesterID;
        this.requesterFullName=requesterFullName;
        this.requesterDepartment=requesterDepartment;
        this.requesterPosition=requesterPosition;
        this.requesterRank=requesterRank;
        this.delegateID=delegateID;
        this.delegateFullName=delegateFullName;
        this.delegatePosition=delegatePosition;
        this.delegateDepartment=delegateDepartment;
        this.delegateRank=delegateRank;
        this.delegtorID=delegatorID;
        this.delegateFullName=requesterFullName;
        this.delegatorFullName=delegatorFullName;
        this.delegtorDepartment=delegatorDepartment;
        this.delegtorPosition=delegatorPosition;
        this.delegtorRank=delegatorRank;
        this.delegatedPosition=delegatorPosition;
        this.delegatedRank=delegatorRank;
        this.delegatedSatrtDay=delegatedSatrtDay;
        this.delegateEndDay=delegateEndDay;
        this.delegationReasoun=delegationReasoun;

    }

    public String getDelegatorFullName() {
        return delegatorFullName;
    }

    public void setDelegatorFullName(String delegatorFullName) {
        this.delegatorFullName = delegatorFullName;
    }

    public String getDelegtorDepartment() {
        return delegtorDepartment;
    }

    public void setDelegtorDepartment(String delegtorDepartment) {
        this.delegtorDepartment = delegtorDepartment;
    }

    public String getDelegtorID() {
        return delegtorID;
    }

    public void setDelegtorID(String delegtorID) {
        this.delegtorID = delegtorID;
    }

    public String getDelegtorPosition() {
        return delegtorPosition;
    }

    public void setDelegtorPosition(String delegtorPosition) {
        this.delegtorPosition = delegtorPosition;
    }

    public String getDelegtorRank() {
        return delegtorRank;
    }

    public void setDelegtorRank(String delegtorRank) {
        this.delegtorRank = delegtorRank;
    }

    public String getDelegateDepartment() {
        return delegateDepartment;
    }

    public void setDelegateDepartment(String delegateDepartment) {
        this.delegateDepartment = delegateDepartment;
    }

    public String getDelegateEndDay() {
        return delegateEndDay;
    }

    public void setDelegateEndDay(String delegateEndDay) {
        this.delegateEndDay = delegateEndDay;
    }

    public String getDelegateFullName() {
        return delegateFullName;
    }

    public void setDelegateFullName(String delegateFullName) {
        this.delegateFullName = delegateFullName;
    }

    public String getDelegateID() {
        return delegateID;
    }

    public void setDelegateID(String delegateID) {
        this.delegateID = delegateID;
    }

    public String getDelegatePosition() {
        return delegatePosition;
    }

    public void setDelegatePosition(String delegatePosition) {
        this.delegatePosition = delegatePosition;
    }

    public String getDelegateRank() {
        return delegateRank;
    }

    public void setDelegateRank(String delegateRank) {
        this.delegateRank = delegateRank;
    }

    public String getDelegatedPosition() {
        return delegatedPosition;
    }

    public void setDelegatedPosition(String delegatedPosition) {
        this.delegatedPosition = delegatedPosition;
    }

    public String getDelegatedRank() {
        return delegatedRank;
    }

    public void setDelegatedRank(String delegatedRank) {
        this.delegatedRank = delegatedRank;
    }

    public String getDelegatedSatrtDay() {
        return delegatedSatrtDay;
    }

    public void setDelegatedSatrtDay(String delegatedSatrtDay) {
        this.delegatedSatrtDay = delegatedSatrtDay;
    }

    public String getDelegationReasoun() {
        return delegationReasoun;
    }

    public void setDelegationReasoun(String delegationReasoun) {
        this.delegationReasoun = delegationReasoun;
    }

    public String getRequesterDepartment() {
        return requesterDepartment;
    }

    public void setRequesterDepartment(String requesterDepartment) {
        this.requesterDepartment = requesterDepartment;
    }

    public String getRequesterFullName() {
        return requesterFullName;
    }

    public void setRequesterFullName(String requesterFullName) {
        this.requesterFullName = requesterFullName;
    }

    public String getRequesterID() {
        return requesterID;
    }

    public void setRequesterID(String requesterID) {
        this.requesterID = requesterID;
    }

    public String getRequesterPosition() {
        return requesterPosition;
    }

    public void setRequesterPosition(String requesterPosition) {
        this.requesterPosition = requesterPosition;
    }

    public String getRequesterRank() {
        return requesterRank;
    }

    public void setRequesterRank(String requesterRank) {
        this.requesterRank = requesterRank;
    }

    public PowerDelegationModel() {
    }
    public static class PowerDegationApproveModel{

    String requesterID;
    String requesterFullName;
    String requesterPosition;
    String requesterDepartment;
    String requesterRank;
    String delegateID;
    String delegateFullName;
    String delegatePosition;
    String delegateDepartment;
    String delegateRank;
    String delegatedPosition;
    String delegatedRank;
    String delegatedSatrtDay;
    String delegateEndDay;
    String delegationReasoun;
    String delegationApproveDay;
    String approverID;
    String approverFullName;
    String approverDepartment;
    String approverPosition;


        public PowerDegationApproveModel(String requesterID, String requesterFullName,String requesterDepartment, String requesterPosition,String requesterRank, String delegateFullName, String delegateID, String delegatePosition, String delegateDepartment, String delegatedSatrtDay, String delegateEndDay, String delegatedPosition, String delegatedRank, String delegationReasoun, String delegationApproveDay, String approverID, String approverFullName, String approverDepartment, String approverPosition) {

            this.requesterID=requesterID;
            this.requesterFullName=requesterFullName;
            this.requesterDepartment=requesterDepartment;
            this.requesterPosition=requesterPosition;
            this.requesterRank=requesterRank;
            this.delegateID=delegateID;
            this.delegateFullName=delegateFullName;
            this.delegatePosition=delegatePosition;
            this.delegateDepartment=delegateDepartment;
            this.delegatedSatrtDay=delegatedSatrtDay;
            this.delegateEndDay=delegateEndDay;
            this.delegatedPosition=delegatedPosition;
            this.delegatedRank=delegatedRank;
            this.delegationReasoun=delegationReasoun;
            this.delegationApproveDay=delegationApproveDay;
            this.approverID=approverID;
            this.approverFullName=approverFullName;
            this.approverDepartment=approverDepartment;
            this.approverPosition=approverPosition;

        }


        public String getApproverDepartment() {
            return approverDepartment;
        }

        public void setApproverDepartment(String approverDepartment) {
            this.approverDepartment = approverDepartment;
        }

        public String getApproverFullName() {
            return approverFullName;
        }

        public void setApproverFullName(String approverFullName) {
            this.approverFullName = approverFullName;
        }

        public String getApproverID() {
            return approverID;
        }

        public void setApproverID(String approverID) {
            this.approverID = approverID;
        }

        public String getApproverPosition() {
            return approverPosition;
        }

        public void setApproverPosition(String approverPosition) {
            this.approverPosition = approverPosition;
        }

        public String getDelegationApproveDay() {
            return delegationApproveDay;
        }

        public void setDelegationApproveDay(String delegationApproveDay) {
            this.delegationApproveDay = delegationApproveDay;
        }

        public String getDelegateDepartment() {
            return delegateDepartment;
        }

        public void setDelegateDepartment(String delegateDepartment) {
            this.delegateDepartment = delegateDepartment;
        }

        public String getDelegateEndDay() {
            return delegateEndDay;
        }

        public void setDelegateEndDay(String delegateEndDay) {
            this.delegateEndDay = delegateEndDay;
        }

        public String getDelegateFullName() {
            return delegateFullName;
        }

        public void setDelegateFullName(String delegateFullName) {
            this.delegateFullName = delegateFullName;
        }

        public String getDelegateID() {
            return delegateID;
        }

        public void setDelegateID(String delegateID) {
            this.delegateID = delegateID;
        }

        public String getDelegatePosition() {
            return delegatePosition;
        }

        public void setDelegatePosition(String delegatePosition) {
            this.delegatePosition = delegatePosition;
        }

        public String getDelegateRank() {
            return delegateRank;
        }

        public void setDelegateRank(String delegateRank) {
            this.delegateRank = delegateRank;
        }

        public String getDelegatedPosition() {
            return delegatedPosition;
        }

        public void setDelegatedPosition(String delegatedPosition) {
            this.delegatedPosition = delegatedPosition;
        }

        public String getDelegatedRank() {
            return delegatedRank;
        }

        public void setDelegatedRank(String delegatedRank) {
            this.delegatedRank = delegatedRank;
        }

        public String getDelegatedSatrtDay() {
            return delegatedSatrtDay;
        }

        public void setDelegatedSatrtDay(String delegatedSatrtDay) {
            this.delegatedSatrtDay = delegatedSatrtDay;
        }

        public String getDelegationReasoun() {
            return delegationReasoun;
        }

        public void setDelegationReasoun(String delegationReasoun) {
            this.delegationReasoun = delegationReasoun;
        }

        public String getRequesterDepartment() {
            return requesterDepartment;
        }

        public void setRequesterDepartment(String requesterDepartment) {
            this.requesterDepartment = requesterDepartment;
        }

        public String getRequesterFullName() {
            return requesterFullName;
        }

        public void setRequesterFullName(String requesterFullName) {
            this.requesterFullName = requesterFullName;
        }

        public String getRequesterID() {
            return requesterID;
        }

        public void setRequesterID(String requesterID) {
            this.requesterID = requesterID;
        }

        public String getRequesterPosition() {
            return requesterPosition;
        }

        public void setRequesterPosition(String requesterPosition) {
            this.requesterPosition = requesterPosition;
        }

        public String getRequesterRank() {
            return requesterRank;
        }

        public void setRequesterRank(String requesterRank) {
            this.requesterRank = requesterRank;
        }


    }

}
