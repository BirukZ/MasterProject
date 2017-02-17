/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeBonesManager;

import entity.employeeBonesEntity.ApproveYearlyBonesEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author Dereje
 */
public class ApproveYearlyBonesManager {

    private ApproveYearlyBonesEntity approveYearlyBonesEntity = null;
    private String employeeId;
    private String employeeName;
    private String evaluationResult;
    private String acquireMonth;
    private String amountInBirr;
    private String exprience;
    private String salary;
    private boolean selectList;
    private boolean selected;
    private String employeeEvaluation;
    private String bonesId;

    public ArrayList<SelectItem> getListOfRequest() {
        checkObject();
        ArrayList<SelectItem> requestList = new ArrayList<SelectItem>();

        try {
            ArrayList<HashMap> list = approveYearlyBonesEntity.getListOfRequest();
            if (list.size() > 0) {
                requestList.add(new SelectItem(null,
                        "Select Bones Request"));
                for (HashMap hm : list) {
                    requestList.add(new SelectItem(hm.get("BONESID"),
                            hm.get("PREPAREFOR").toString()));
                }
            } else {
                requestList.add(new SelectItem(null,
                        "There is no new Request"));
            }
            return requestList;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public HashMap getReqfuesterInformation(String requestId) {
        try {
            checkObject();
            return approveYearlyBonesEntity.getReqfuesterInformation(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> getReqfuestedInformation(String requestId) {
        try {
            checkObject();
            return approveYearlyBonesEntity.getReqfuestedInformation(requestId);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<SelectItem> getListOfDecision() {
        ArrayList<SelectItem> decisionList = new ArrayList<SelectItem>();
        decisionList.add(new SelectItem(null, " Select Decision"));
        decisionList.add(new SelectItem("App", "APPROVE"));
        decisionList.add(new SelectItem("RE", "RESUBMIT"));
        return decisionList;
    }

    public boolean saveeBonesRequestDecision(ArrayList<HashMap> approveList,
            String approverId, String bonesId, String destion, String remark) {
        checkObject();
        try {
            return approveYearlyBonesEntity.saveeBonesRequestDecision(approveList,
                    approverId, bonesId, destion, remark);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void checkObject() {
        if (approveYearlyBonesEntity == null) {
            approveYearlyBonesEntity = new ApproveYearlyBonesEntity();

        }
    }

    public String getAcquireMonth() {
        return acquireMonth;
    }

    public void setAcquireMonth(String acquireMonth) {
        this.acquireMonth = acquireMonth;
    }

    public String getAmountInBirr() {
        return amountInBirr;
    }

    public void setAmountInBirr(String amountInBirr) {
        this.amountInBirr = amountInBirr;
    }

    public ApproveYearlyBonesEntity getApproveYearlyBonesEntity() {
        return approveYearlyBonesEntity;
    }

    public void setApproveYearlyBonesEntity(ApproveYearlyBonesEntity approveYearlyBonesEntity) {
        this.approveYearlyBonesEntity = approveYearlyBonesEntity;
    }

    public String getEmployeeEvaluation() {
        return employeeEvaluation;
    }

    public void setEmployeeEvaluation(String employeeEvaluation) {
        this.employeeEvaluation = employeeEvaluation;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEvaluationResult() {
        return evaluationResult;
    }

    public void setEvaluationResult(String evaluationResult) {
        this.evaluationResult = evaluationResult;
    }

    public String getExprience() {
        return exprience;
    }

    public void setExprience(String exprience) {
        this.exprience = exprience;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isSelectList() {
        return selectList;
    }

    public void setSelectList(boolean selectList) {
        this.selectList = selectList;
    }

    public ApproveYearlyBonesManager() {
    }

    public String getBonesId() {
        return bonesId;
    }

    public void setBonesId(String bonesId) {
        this.bonesId = bonesId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public ApproveYearlyBonesManager(String employeeId,
            String employeeName,
            String evaluationResult,
            String acquireMonth,
            String amountInBirr,
            String exprience,
            String salary,
            String employeeEvaluation,
            String bonesId,
            boolean selected) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.evaluationResult = evaluationResult;
        this.acquireMonth = acquireMonth;
        this.amountInBirr = amountInBirr;
        this.exprience = exprience;
        this.salary = salary;
        this.employeeEvaluation = employeeEvaluation;
        this.bonesId = bonesId;
        this.selected = selected;
    }
}
