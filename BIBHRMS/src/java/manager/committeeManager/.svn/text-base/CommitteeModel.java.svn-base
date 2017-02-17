/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.committeeManager;

import java.io.Serializable;

/**
 *
 * @author Mugher
 */

    public  class CommitteeModel implements Serializable {

        /*COMMITTEE_ID
        COMMITTEE_NAME
        COMMITTEE_TYPE
        DESCRIPTION
        NUM_OF_MEMBERS
        ESTABLISHED_DATE
        STATUS
        RESPONSIBLITY
        PARENT_ID*/
        int committeeId;
        String committeeName;
        String committeeType;
        String committeeStatus;
        String description;
        String responsiblity;
        String establishedDate;
        int parentId;
        String databaseStatus;
        int numberOfmembers;
        String formerName;
        String formerDepartment;
        String formerPosition;

        public CommitteeModel() {
        }

        public CommitteeModel(String committeeName, String committeeType, String committeeStatus, String description, String responsiblity, String establishedDate, String databaseStatus,String formerName,String formerDepartment,String formerPosition) {
            this.committeeName = committeeName;
            this.committeeType = committeeType;
            this.committeeStatus = committeeStatus;
            this.description = description;
            this.responsiblity = responsiblity;
            this.establishedDate = establishedDate;
            this.databaseStatus = databaseStatus;
            this.formerName=formerName;
            this.formerDepartment=formerDepartment;
            this.formerPosition=formerPosition;
        }

        public CommitteeModel(int committeeId, String committeeName, String committeeType, String committeeStatus, String description, String responsiblity, String establishedDate, String databaseStatus,String formerName,String formerDepartment,String formerPosition) {
            this(committeeName, committeeType, committeeStatus, description, responsiblity, establishedDate, databaseStatus,formerName,formerDepartment,formerPosition);
            this.committeeId = committeeId;
            this.formerName=formerName;
            this.formerDepartment=formerDepartment;
            this.formerPosition=formerPosition;
        }

    public String getFormerDepartment() {
        return formerDepartment;
    }

    public void setFormerDepartment(String formerDepartment) {
        this.formerDepartment = formerDepartment;
    }

    public String getFormerName() {
        return formerName;
    }

    public void setFormerName(String formerName) {
        this.formerName = formerName;
    }

    public String getFormerPosition() {
        return formerPosition;
    }

    public void setFormerPosition(String formerPosition) {
        this.formerPosition = formerPosition;
    }

        public String getCommitteeType() {
            return committeeType;
        }

        public void setCommitteeType(String committeeType) {
            this.committeeType = committeeType;
        }

        public String getCommitteeName() {
            return committeeName;
        }

        public String getDatabaseStatus() {
            return databaseStatus;
        }

        public void setCommitteeName(String committeeName) {
            this.committeeName = committeeName;
        }

        public int getCommitteeId() {
            return committeeId;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public void setCommitteeId(int committeeId) {
            this.committeeId = committeeId;
        }

        public String getCommitteeStatus() {
            return committeeStatus;
        }

        public void setCommitteeStatus(String committeeStatus) {
            this.committeeStatus = committeeStatus;
        }

        public void setDatabaseStatus(String databaseStatus) {
            this.databaseStatus = databaseStatus;
        }

        public String getResponsiblity() {
            return responsiblity;
        }

        public void setResponsiblity(String responsiblity) {
            this.responsiblity = responsiblity;
        }

        public String getEstablishedDate() {
            return establishedDate;
        }

        public void setEstablishedDate(String establishedDate) {
            this.establishedDate = establishedDate;
        }

        public int getNumberOfmembers() {
            return numberOfmembers;
        }

        public void setNumberOfmembers(int numberOfmembers) {
            this.numberOfmembers = numberOfmembers;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }
