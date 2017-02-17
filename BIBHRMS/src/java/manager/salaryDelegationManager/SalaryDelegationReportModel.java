/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.salaryDelegationManager;

/**
 *
 * @author Biruk
 */
public class SalaryDelegationReportModel {

    String delegatorId;
    String delegatorFullName;
    String delegatorDepartment;
    String delegateId;
    String delegateFullName;
    String delegateDepartment;
    String delegationStartDate;
    String delegationEndDate;
    String delegationTypeSalary;
    String delegationTypeOther;
    String delegationReasoun;

    public SalaryDelegationReportModel(String delegatorId, String delegatorFullName, String delegatorDepartment, String delegateId, String delegateDepartment, String delegateFullName, String delegationStartDate, String delegationEndDate, String delegationReasoun, String delegationType) {
      this.delegatorId=delegatorId;
      this.delegatorFullName=delegatorFullName;
      this.delegatorDepartment=delegatorDepartment;
      this.delegateId=delegateId;
      this.delegateDepartment=delegateDepartment;
      this.delegateFullName=delegateFullName;
      this.delegationStartDate=delegationStartDate;
      this.delegationEndDate=delegationEndDate;
      this.delegationReasoun=delegationReasoun;
      this.delegationTypeSalary=delegationType;

    }

    public String getDelegationTypeOther() {
        return delegationTypeOther;
    }

    public void setDelegationTypeOther(String delegationTypeOther) {
        this.delegationTypeOther = delegationTypeOther;
    }

    public String getDelegationTypeSalary() {
        return delegationTypeSalary;
    }

    public void setDelegationTypeSalary(String delegationTypeSalary) {
        this.delegationTypeSalary = delegationTypeSalary;
    }

    public String getDelegateDepartment() {
        return delegateDepartment;
    }

    public void setDelegateDepartment(String delegateDepartment) {
        this.delegateDepartment = delegateDepartment;
    }

    public String getDelegateFullName() {
        return delegateFullName;
    }

    public void setDelegateFullName(String delegateFullName) {
        this.delegateFullName = delegateFullName;
    }

    public String getDelegateId() {
        return delegateId;
    }

    public void setDelegateId(String delegateId) {
        this.delegateId = delegateId;
    }

    public String getDelegationEndDate() {
        return delegationEndDate;
    }

    public void setDelegationEndDate(String delegationEndDate) {
        this.delegationEndDate = delegationEndDate;
    }

    public String getDelegationReasoun() {
        return delegationReasoun;
    }

    public void setDelegationReasoun(String delegationReasoun) {
        this.delegationReasoun = delegationReasoun;
    }

    public String getDelegationStartDate() {
        return delegationStartDate;
    }

    public void setDelegationStartDate(String delegationStartDate) {
        this.delegationStartDate = delegationStartDate;
    }

    public String getDelegatorDepartment() {
        return delegatorDepartment;
    }

    public void setDelegatorDepartment(String delegatorDepartment) {
        this.delegatorDepartment = delegatorDepartment;
    }

    public String getDelegatorFullName() {
        return delegatorFullName;
    }

    public void setDelegatorFullName(String delegatorFullName) {
        this.delegatorFullName = delegatorFullName;
    }

    public String getDelegatorId() {
        return delegatorId;
    }

    public void setDelegatorId(String delegatorId) {
        this.delegatorId = delegatorId;
    }

    public SalaryDelegationReportModel() {
    }
    

}
