/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeBonesManager;

import entity.employeeBonesEntity.EmployeeEvaluationEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author Administrator
 */
public class EmployeeEvaluationManager {

    private String employeeName;
    private String emp_id;
    private String result;
    private String remark;
    private String evaId;
    private boolean selected;
    private EmployeeEvaluationEntity employeeEvaluationEntity = null;

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public String getEvaId() {
        return evaId;
    }

    public void setEvaId(String evaId) {
        this.evaId = evaId;
    }

    public String getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(String emp_id) {
        this.emp_id = emp_id;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public EmployeeEvaluationManager() {
    }

    public EmployeeEvaluationManager(String employeeName, String emp_id, String result, String remark, String evaId) {
        this.employeeName = employeeName;
        this.emp_id = emp_id;
        this.result = result;
        this.remark = remark;
        this.evaId = evaId;
    }

    public ArrayList<HashMap> listoFEmployee(String deprtmentId) {
        isNull();
        return employeeEvaluationEntity.listOfEmployee(deprtmentId);
    }

    public ArrayList<HashMap> listofEmployeeEvaluation(String eaveluationDate, String evaluaterId) {
        isNull();
        return employeeEvaluationEntity.listofEmployeeEvaluation(eaveluationDate, evaluaterId);
    }

    void isNull() {
        if (employeeEvaluationEntity == null) {
            employeeEvaluationEntity = new EmployeeEvaluationEntity();
        }
    }

    public boolean seaveEmployeeEvaluation(ArrayList<HashMap> listOfEvaluation) {
        isNull();
        return employeeEvaluationEntity.saveEmployeeEvaluation(listOfEvaluation);
    }

    public boolean updateEmployeeEvaluation(ArrayList<HashMap> listOfEvaluation) {
        isNull();
        return employeeEvaluationEntity.updateEmployeeEvaluation(listOfEvaluation);
    }
    /*<editor-folder>*/

    public ArrayList<SelectItem> listofEvaluationDate(String evaluaterId) {
        isNull();
        ArrayList<SelectItem> listOfEva = new ArrayList<SelectItem>();
        ArrayList<HashMap> listOfDate = employeeEvaluationEntity.listofEvaluationDate(evaluaterId);
        if (listOfDate.size() > 0) {
            listOfEva.add(new SelectItem(null,
                    "Select Evaluation Date"));

            for (HashMap hm : listOfDate) {
                listOfEva.add(new SelectItem(hm.get("EVALUATIONDATE").toString(),
                        hm.get("EVALUATIONDATE").toString()));
            }
        } else {
            listOfEva.add(new SelectItem(null,
                    "Data not Avileble"));
        }
        return listOfEva;
    }

    public boolean deleteEmployeeEvaluation(ArrayList<HashMap> evalId) {
        isNull();
        return employeeEvaluationEntity.deleteEmployeeEvaluation(evalId);
    }

    /*</editer-folder>*/
}
