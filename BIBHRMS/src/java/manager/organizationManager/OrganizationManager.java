/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.organizationManager;

import entity.organizationEntity.Department;
import entity.organizationEntity.OrganizationEntity;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class OrganizationManager {

    public OrganizationManager() {
    }
    int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public OrganizationManager(String deptCode, String deptDescription, String deptMission, String estDate, String branchID, int level) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
        this.estDate = estDate;
        this.branchID = branchID;
        this.level = level;
    }
    OrganizationEntity organizationEntity = new OrganizationEntity();

    public ArrayList<OrganizationManager> readAllOrganizations() {
        ArrayList<Department> organizationlist = organizationEntity.readAllOrganization();
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {

            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public OrganizationManager readRoot() {
        Department dep = organizationEntity.readRoot();
        OrganizationManager myReturn = new OrganizationManager(dep.getDeptCode(), dep.getDeptDescription(), dep.getDeptMission(), dep.getEstDate(), dep.getBranchID());
        return myReturn;
    }

    public ArrayList<String> readDepartment() {
        return organizationEntity.readNationality();
    }
    String deptCode;

    public OrganizationManager(String deptCode, String deptDescription, String deptMission, String estDate, String branchID) {
        this.deptCode = deptCode;
        this.deptDescription = deptDescription;
        this.deptMission = deptMission;
        this.estDate = estDate;
        this.branchID = branchID;
    }

    public String getDeptCode() {
        return deptCode;
    }

    public void setDeptCode(String deptCode) {
        this.deptCode = deptCode;
    }

    public String getDeptDescription() {
        return deptDescription;
    }

    public void setDeptDescription(String deptDescription) {
        this.deptDescription = deptDescription;
    }

    public String getDeptMission() {
        return deptMission;
    }

    public void setDeptMission(String deptMission) {
        this.deptMission = deptMission;
    }

    public String getEstDate() {
        return estDate;
    }

    public void setEstDate(String estDate) {
        this.estDate = estDate;
    }
    String deptDescription;
    String branchID;

    public String getBranchID() {
        return branchID;
    }

    public void setBranchID(String branchID) {
        this.branchID = branchID;
    }
    String deptMission;
    String estDate;

    public ArrayList<String> readHead() {
        return organizationEntity.readHead();
    }

    public ArrayList<OrganizationManager> readOrganization() {

        ArrayList<Department> organizationlist = organizationEntity.readOrganization(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {

            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public ArrayList<OrganizationManager> readBranch() {
        ArrayList<Department> organizationlist = organizationEntity.readBranch(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public ArrayList<OrganizationManager> readDeptment() {
        ArrayList<Department> organizationlist = organizationEntity.readDeptment(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public ArrayList<OrganizationManager> readSection() {
        ArrayList<Department> organizationlist = organizationEntity.readSection(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public ArrayList<OrganizationManager> readSSection() {
        ArrayList<Department> organizationlist = organizationEntity.readSSection(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;
    }

    public ArrayList<OrganizationManager> readSSSection() {
        ArrayList<Department> organizationlist = organizationEntity.readSSSection(null);
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID());
            organizationList.add(subBra);
        }
        return organizationList;

    }

    public ArrayList<OrganizationManager> readAllDepartments() {
        ArrayList<Department> organizationlist = organizationEntity.readAllDepartments();
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID(), organizationlist.get(i).getLevel());
            organizationList.add(subBra);
        }
        return organizationList;
    }
    ///////////////////////////////////////////////////Selection/////////////////////////////////////////////////////////////////////////////////////
     public ArrayList<OrganizationManager> readAllDepartmentsNew() {
        ArrayList<Department> organizationlist = organizationEntity.readAllDepartmentsNew();
        ArrayList<OrganizationManager> organizationList = new ArrayList<OrganizationManager>();
        for (int i = 0; i < organizationlist.size(); i++) {
            OrganizationManager subBra = new OrganizationManager(organizationlist.get(i).getDeptCode(), organizationlist.get(i).getDeptDescription(), organizationlist.get(i).getDeptMission(), organizationlist.get(i).getEstDate(), organizationlist.get(i).getBranchID(), organizationlist.get(i).getLevel());
            organizationList.add(subBra);
        }
        return organizationList;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
}
