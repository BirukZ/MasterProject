/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import entity.employeeHistoryEntity.EvaluationResult;
import java.util.HashMap;
import com.sun.webui.jsf.model.Option;
import entity.employeeEntity.EmployeeEntityOld;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
//import javax.swing.JOptionPane;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author user
 */
public class EvaluationResultManager {

    EmployeeEntityOld employeeEntity = new EmployeeEntityOld();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private double totalRsult = 0.0;
    private double percentValue=0.0;
    private double averageResult = 0.0;
    private String empId;
    private int evaCrtCode;
    private int evaSessionCode;
    private String result;
    private String remark;
    private String evaCrtName;
    private int evaResultId;
    private String evaCrtCategory;
    private String startDate;
    private String endDate;
    private String empName;
    private String selectedValue;
    private String jobDescription;
    private boolean selectedComp;
    private boolean selectedAppComp;
    public boolean selected;
    private boolean selected1;
    private boolean selected2;
    private boolean selected3;
    private boolean selected4;
    private boolean selected5;
    private boolean invalid;
    private String complainRemark;
    private String resolverRemark;
    Option[] resultResult = readEvaRresult();
    EvaluationResult evaResultEntity = new EvaluationResult();
    private Option[] sessionResultRequest;
    private String purpIdentifiyer = "";
    private ArrayList<HashMap> filteredData = new ArrayList<HashMap>();

    public double getPercentValue() {
        return percentValue;
    }



    public void setPercentValue(double percentValue) {
        this.percentValue = percentValue;
    }

    public ArrayList<HashMap> getFilteredData() {
        return filteredData;
    }

    public void setFilteredData(ArrayList<HashMap> filteredData) {
        this.filteredData = filteredData;
    }

     public String getResolverRemark() {
        return resolverRemark;
    }


    public void setResolverRemark(String resolverRemark) {
        this.resolverRemark = resolverRemark;
    }

    public double getTotalRsult() {
        return totalRsult;
    }

    public boolean isInvalid() {
        return invalid;
    }

    public void setInvalid(boolean invalid) {
        this.invalid = invalid;
    }

    public void setTotalRsult(double totalRsult) {
        this.totalRsult = totalRsult;
    }

    public double getAverageResult() {
        return averageResult;
    }

    public void setAverageResult(double averageResult) {
        this.averageResult = averageResult;
    }

    public String getComplainRemark() {
        return complainRemark;
    }

    public void setComplainRemark(String complainRemark) {
        this.complainRemark = complainRemark;
    }

    public boolean isSelectedAppComp() {
        return selectedAppComp;
    }

    public void setSelectedAppComp(boolean selectedAppComp) {
        this.selectedAppComp = selectedAppComp;
    }

    public String getPurpIdentifiyer() {
        return purpIdentifiyer;
    }

    public void setPurpIdentifiyer(String purpIdentifiyer) {
        this.purpIdentifiyer = purpIdentifiyer;
    }

    public boolean isSelectedComp() {
        return selectedComp;
    }

    public void setSelectedComp(boolean selectedComp) {
        this.selectedComp = selectedComp;
    }

    public EvaluationResultManager() {
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    /**
     * @return the selected1
     */
    public boolean isSelected1() {
        return selected1;
    }

    /**
     * @param selected1 the selected1 to set
     */
    public void setSelected1(boolean selected1) {
        this.selected1 = selected1;
    }

    /**
     * @return the selected2
     */
    public boolean isSelected2() {
        return selected2;
    }

    /**
     * @param selected2 the selected2 to set
     */
    public void setSelected2(boolean selected2) {
        this.selected2 = selected2;
    }

    /**
     * @return the selected3
     */
    public boolean isSelected3() {
        return selected3;
    }

    /**
     * @param selected3 the selected3 to set
     */
    public void setSelected3(boolean selected3) {
        this.selected3 = selected3;
    }

    /**
     * @return the selected4
     */
    public boolean isSelected4() {
        return selected4;
    }

    /**
     * @param selected4 the selected4 to set
     */
    public void setSelected4(boolean selected4) {
        this.selected4 = selected4;
    }

    /**
     * @return the selected5
     */
    public boolean isSelected5() {
        return selected5;
    }

    /**
     * @param selected5 the selected5 to set
     */
    public void setSelected5(boolean selected5) {
        this.selected5 = selected5;
    }

    /**
     * @return the selectedValue
     */
    public String getSelectedValue() {
        return selectedValue;
    }

    /**
     * @param selectedValue the selectedValue to set
     */
    public void setSelectedValue(String selectedValue) {
        this.selectedValue = selectedValue;
    }

    /**
     * @return the sessionResultRequest
     */
    public Option[] getSessionResultRequest() {
        return sessionResultRequest;
    }

    /**
     * @param sessionResultRequest the sessionResultRequest to set
     */
    public void setSessionResultRequest(Option[] sessionResultRequest) {
        this.sessionResultRequest = sessionResultRequest;
    }

    public Option[] getResultResult() {
        return resultResult;
    }

    public void setResultResult(Option[] resultResult) {
        this.resultResult = readEvaRresult();
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the empName
     */
    public String getEmpName() {
        return empName;
    }

    /**
     * @param empName the empName to set
     */
    public void setEmpName(String empName) {
        this.empName = empName;
    }

    /**
     * @return the empId
     */
    public String getEmpId() {
        return empId;
    }

    /**
     * @return the evaCrtCategory
     */
    public String getEvaCrtCategory() {
        return evaCrtCategory;
    }

    /**
     * @param evaCrtCategory the evaCrtCategory to set
     */
    public void setEvaCrtCategory(String evaCrtCategory) {
        this.evaCrtCategory = evaCrtCategory;
    }

    /**
     * @param empId the empId to set
     */
    public void setEmpId(String empId) {
        this.empId = empId;
    }

    /**
     * @return the evaCrtCode
     */
    public int getEvaCrtCode() {
        return evaCrtCode;
    }

    /**
     * @param evaCrtCode the evaCrtCode to set
     */
    public void setEvaCrtCode(int evaCrtCode) {
        this.evaCrtCode = evaCrtCode;
    }

    /**
     * @return the evaSessionCode
     */
    public int getEvaSessionCode() {
        return evaSessionCode;
    }

    /**
     * @param evaSessionCode the evaSessionCode to set
     */
    public void setEvaSessionCode(int evaSessionCode) {
        this.evaSessionCode = evaSessionCode;
    }

    /**
     * @return the result
     */
    public String getResult() {
        return result;
    }

    /**
     * @param result the result to set
     */
    public void setResult(String result) {
        this.result = result;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    /**
     * @return the evaCrtName
     */
    public String getEvaCrtName() {
        return evaCrtName;
    }

    /**
     * @param evaCrtName the evaCrtName to set
     */
    public void setEvaCrtName(String evaCrtName) {
        this.evaCrtName = evaCrtName;
    }

    /**
     * @return the evaResultId
     */
    public int getEvaResultId() {
        return evaResultId;
    }

    /**
     * @param evaResultId the evaResultId to set
     */
    public void setEvaResultId(int evaResultId) {
        this.evaResultId = evaResultId;
    }

    public EvaluationResultManager(String startDate, String endDate, String empName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.empName = empName;



    }

    public EvaluationResultManager(int evaCrtCode, String evaCrtName, String evaCrtCategory) {
        this.evaCrtCode = evaCrtCode;
        this.evaCrtName = evaCrtName;
        this.evaCrtCategory = evaCrtCategory;

    }

    public EvaluationResultManager(int evaCrtCode, String evaCrtName, String evaCrtCategory, String Remark) {
        this.evaCrtCode = evaCrtCode;
        this.evaCrtName = evaCrtName;
        this.evaCrtCategory = evaCrtCategory;
        this.remark = Remark;

    }

    public EvaluationResultManager(String result, int evaCrtCode, String empId, int evaSessionCode, String remark) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.result = result;
        this.remark = remark;

    }

    public EvaluationResultManager(String empId, int evaCrtCode, int evaSessionCode, String result, String remark, String evaCrtName) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.result = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;

    }

    public EvaluationResultManager(int evaResultId, String result, int evaCrtCode, String empId, int evaSessionCode, String remark) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.result = result;
        this.remark = remark;
        this.evaResultId = evaResultId;

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription) {

        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut,
            String complainRemark, String resolveRemark, int x) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.complainRemark = complainRemark;
        this.resolverRemark = resolveRemark;
        this.jobDescription = jobDescription;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut, String complainRemark,int x) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.complainRemark = complainRemark;
        this.jobDescription = jobDescription;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut,
            String resolveStatus) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

        if (resolveStatus.equals("2")) {
            this.setSelectedAppComp(true);
        } else if (resolveStatus.equals("1") || resolveStatus.equals("0")) {
            this.setSelectedAppComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut,
            String resolveStatus, String complainRemark, String resolverRemark, int x) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        this.complainRemark = complainRemark;
        this.resolverRemark = resolverRemark;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

        if (resolveStatus.equals("2")) {
            this.setSelectedAppComp(true);
        } else if (resolveStatus.equals("1") || resolveStatus.equals("0")) {
            this.setSelectedAppComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut,
            String resolveStatus, String complainRemark, String resolveRemark) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        this.complainRemark = complainRemark;
        this.resolverRemark = resolveRemark;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

        if (resolveStatus.equals("2")) {
            this.setSelectedAppComp(true);
        } else if (resolveStatus.equals("1") || resolveStatus.equals("0")) {
            this.setSelectedAppComp(false);
        }

    }

    public EvaluationResultManager(int evaResultId, int evaCrtCode, int evaSessionCode, String empId,
            String result, String remark,
            String evaCrtName,
            String empName, String jobDescription, String compStut,
            String resolveStatus, String complainRemark) {
        this.empId = empId;
        this.evaCrtCode = evaCrtCode;
        this.evaSessionCode = evaSessionCode;
        this.selectedValue = result;
        this.remark = remark;
        this.evaCrtName = evaCrtName;
        this.evaResultId = evaResultId;
        this.empName = empName;
        this.jobDescription = jobDescription;
        this.complainRemark = complainRemark;
        if (this.selectedValue.equals("1")) {
            this.selected1 = true;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("2")) {
            this.selected1 = false;
            this.selected2 = true;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("3")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = true;
            this.selected4 = false;
            this.selected5 = false;
        } else if (this.selectedValue.equals("4")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = true;
            this.selected5 = false;
        } else if (this.selectedValue.equals("5")) {
            this.selected1 = false;
            this.selected2 = false;
            this.selected3 = false;
            this.selected4 = false;
            this.selected5 = true;
        }

        if (compStut.equals("2")) {
            this.setSelectedComp(true);
        } else if (compStut.equals("1") || compStut.equals("0")) {
            this.setSelectedComp(false);
        }

        if (resolveStatus.equals("2")) {
            this.setSelectedAppComp(true);
        } else if (resolveStatus.equals("1") || resolveStatus.equals("0")) {
            this.setSelectedAppComp(false);
        }

    }

    public int countEvaResult(int sessionID) {
        return evaResultEntity.countEvaResult(sessionID);
    }

    public int countEvaSessionResult(String counter, String empid) {
        return evaResultEntity.countEvaSessionResult(counter, empid);
    }

    public HashMap[] readEvaResultTbl(int sessionID) {
        return evaResultEntity.readEvaResultTbl(sessionID);
    }

    public HashMap[] readEvaSessionResultTbl(String sessionID, String empid) {
        return evaResultEntity.readEvaSessionResultTbl(sessionID, empid);
    }

    public String readEvaluatorFullName(String empid) {
        return evaResultEntity.readEvaluatorFullName(empid);
    }

    public HashMap[] readEvaSessionResultComplainTbl(String sessionID, String empid) {
        return evaResultEntity.readEvaSessionResultComplainTbl(sessionID, empid);
    }
    public HashMap[] readEvaSessionResultComplainTblSingle(String sessionID, String empid) {
        return evaResultEntity.readEvaSessionResultComplainTblSingle(sessionID, empid);
    }

    public EvaluationResultManager(double tResult, double aResult,double totalPercent) {
        this.totalRsult = tResult;
        this.averageResult = aResult;
        this.percentValue=totalPercent;

    }

    public HashMap[] readEvaSessionResultComplainToEvaluaterTbl(String sessionID, String empid) {
        return evaResultEntity.readEvaSessionResultComplainToEvaluatorTbl(sessionID, empid);
    }

    public Option[] readResultOption() {
        Option[] regionOpt = null;
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readAllResult(dateFormat.format(new Date()));
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select Session----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;
        }
        return regionOpt;
    }

    public int loadSessionResultDit(String sessionId) {

        try {

            if (this.searchBySessionId(sessionId) == 1) {
                this.startDate = evaResultEntity.getStartDate();
                this.endDate = evaResultEntity.getEndDate();
                this.empName = evaResultEntity.getEmpName();
                this.evaSessionCode = evaResultEntity.getEvaSessionCode().hashCode();
                this.empId = evaResultEntity.getEmpId();

                return 1;

            }

        } catch (Exception ex) {
            ex.printStackTrace();

        }
        return 0;

    }

    private int searchBySessionId(String sessionId) {
        EvaluationResult lode = null;
        try {
            evaResultEntity.setEvaSessionCode(sessionId);
            
            lode = evaResultEntity.searchBySessionID(sessionId);
            if (lode == null) {
                return 0;
            }
        } catch (Exception ex) {
        }
        return 1;
    }

    public int serEvaSessionSearchId(String empId, int evaSessionCode) {
        return evaResultEntity.serEvaSessionResultSearch(empId, evaSessionCode);
    }

    public int serEvaSessionSearchIdA(String empId, int evaSessionCode) {
        return evaResultEntity.serEvaSessionResultSearchA(empId, evaSessionCode);
    }

    public int addEvaSessionResult(String result, int evaCrtCode, String empId, int evaSessionCode, String comment, String evaluatorID) {
        return evaResultEntity.addEvaSessionResult(result, evaCrtCode, empId, evaSessionCode, comment, evaluatorID);
    }

    public int addEvaSessionResult(String result, int evaCrtCode, String empId, int evaSessionCode, String comment, String evaluatorID, boolean invalid) {
        return evaResultEntity.addEvaSessionResult(result, evaCrtCode, empId, evaSessionCode, comment, evaluatorID, invalid);
    }

    public int insertComplainResult(boolean compVal, String complainRemark, String resultID) {
        return evaResultEntity.insertComplainResult(compVal, complainRemark, resultID);
    }

    public int resolveComplainResult(boolean compVal, String resolveRemark, String resultID) {
        return evaResultEntity.resolveComplainResult(compVal,resolveRemark, resultID);
    }

    public int addEvaSessionResultUpdate(int evaResultId, String result, int evaCrtCode, String empId, int evaSessionCode, String remark, int btnIndc) {
        return evaResultEntity.addEvaSessionResultUpdate(evaResultId, result, evaCrtCode, empId, evaSessionCode, remark, btnIndc);
    }

    public int addEvaSessionResultDelete(int evaResultId) {
        return evaResultEntity.addEvaSessionResultDelete(evaResultId);
    }

    public Option[] readEvaRresult() {
        Option[] resultOpt = null;
        resultOpt = new Option[5];
        resultOpt[0] = new Option("1", "1");
        resultOpt[1] = new Option("2", "2");
        resultOpt[2] = new Option("3", "3");
        resultOpt[3] = new Option("4", "4");
        resultOpt[4] = new Option("5", "5");

        return resultOpt;
    }

    public Option[] loadIndividualSessionResults(String sessionId, String empID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readIndividualSessionResults(sessionId, empID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "Given---Results");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadAllIndividualSessionResults(String empID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readAllIndividualSessionResults(empID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "Given---Results");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }



    public Option[] loadSessionResults(String sessionId, String evaluatorID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readSessionResults(sessionId, evaluatorID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "Given---Results");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadSessionResultsEvaluatee(String sessionId, String evaluatorID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readSessionResultsEvaluatee(sessionId, evaluatorID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "Given---Results");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadResultUsingEvaluator(String evaluatorID, String sessionID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readEvaluationResultsUsingEvaluator(evaluatorID, sessionID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "Given---Results");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId() + "--" + termEntity.getEvaSessionCode(), termEntity.getEvaResultId());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadSessionResultsComplained(String sessionId, String evaluatorID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readSessionResultsComplained(sessionId, evaluatorID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "---Complains---");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadSessionResultsComplainedResolver(String sessionId, String evaluatorID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readSessionResultsComplainedResolver(sessionId, evaluatorID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "---Complains---");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public Option[] loadSessionResultsResolve(String sessionId, String evaluatorID) {

        EvaluationResult termEntity = new EvaluationResult();
        ArrayList<EvaluationResult> evaSessionRequests = this.readSessionResultsComplained(sessionId, evaluatorID);
        sessionResultRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "---Complains---");
        sessionResultRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            termEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(termEntity.getEmpId(), termEntity.getEmpName());
            sessionResultRequest[i + 1] = startedSession;
        }
        return sessionResultRequest;
    }

    public ArrayList<EvaluationResult> readIndividualSessionResults(String sessionId, String empID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readIndividualSessionResults(sessionId, empID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<EvaluationResult> readAllIndividualSessionResults(String empID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readAllIndividualSessionResults(empID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }



    public ArrayList<EvaluationResult> readSessionResults(String sessionId, String evaluatorID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readSessionResults(sessionId, evaluatorID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<EvaluationResult> readSessionResultsEvaluatee(String sessionId, String evaluatorID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readSessionResultsEvaluatee(sessionId, evaluatorID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<EvaluationResult> readEvaluationResultsUsingEvaluator(String evaluatorID, String sessionID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readEvaluationResultsUsingEvaluator(evaluatorID, sessionID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<EvaluationResult> readSessionResultsComplained(String sessionId, String evaluatorID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readSessionResultsComplainedResolver(sessionId, evaluatorID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<EvaluationResult> readSessionResultsComplainedResolver(String sessionId, String evaluatorID) {
        try {

            EvaluationResult evaSessionReq = new EvaluationResult();
            return evaSessionReq.readSessionResultsComplainedResolver(sessionId, evaluatorID);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Option[] readPurposeForDisplay() {
        Option regionOpt[] = null;
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readAllPurposeForResultDisplay();
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("SelectPurp", "-----Select Purpose----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;

        }

        return regionOpt;
    }

    public Option[] readDateForDisplay() {
        Option[] regionOpt = null;
       
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readAllDateForResultDisplay(this.purpIdentifiyer);
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select Session Date----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public Option[] readEvaluatorToResolve(String sessionID, String resolverID) {
        Option[] regionOpt = null;
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readEvaluatorToResolve(sessionID, resolverID);
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select Evaluator----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public Option[] optionToFilterEmployee() {
        Option[] regionOpt = null;
        regionOpt = new Option[8];
        Option regionOptFirst = new Option("0", "-----Select Criteria to Filter----");
        Option regionOptSecond = new Option("1", "-----All Employees----");
        Option regionOptThird = new Option("2", "-----Employees worked for only 3 month----");
        Option regionOptForth = new Option("3", "-----Employees worked for only 6 month----");
         Option regionOptFivize = new Option("4", "-----Employees worked for only 20 Days----");
          Option regionOptSixze = new Option("5", "-----Employees worked for only 40 Days----");
           Option regionOptSeveneze = new Option("6", "-----Employees worked for only  1 Month----");
           Option regionOptEightze = new Option("7", "-----Employees worked for only  2 Month----");
          
        regionOpt[0] = regionOptFirst;
        regionOpt[1] = regionOptSecond;
        regionOpt[2] = regionOptThird;
        regionOpt[3] = regionOptForth;
      //  regionOpt[4] = regionOptForth;
        regionOpt[4] = regionOptFivize;
        regionOpt[5] = regionOptSixze;
        regionOpt[6] = regionOptSeveneze;
        regionOpt[7] = regionOptEightze;

        return regionOpt;
    }



    public Option[] readAllEmpToBeEvauated(String empID, String filter) {
        Option[] regionOpt = null;
        ArrayList<EmployeeEntityOld> regionTypes = employeeEntity.readAllEmpToBeEvaluated(empID, filter);
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select Employee To Evaluate----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            employeeEntity = regionTypes.get(i);
            Option optRegionType = new Option(employeeEntity.getcode(), employeeEntity.getDescription());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public Option[] readAllEmpToBeEvauated(String empID, String filter, String dept_id) {
        Option[] regionOpt = null;
        
        ArrayList<EmployeeEntityOld> regionTypes = employeeEntity.readAllEmpToBeEvaluated(empID, filter, dept_id);
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select Employee To Evaluate----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            employeeEntity = regionTypes.get(i);
            Option optRegionType = new Option(employeeEntity.getcode(), employeeEntity.getDescription());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public Option[] readAllSessionsResultsGivenTo() {
        Option[] regionOpt = null;
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readAllSessionsResultsGivenTo();
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select a session date----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public Option[] readAllSessionsResultsGivenToPromotion() {
        Option[] regionOpt = null;
        ArrayList<EvaluationResult> regionTypes = evaResultEntity.readAllSessionsResultsGivenToPromotion();
        regionOpt = new Option[regionTypes.size() + 1];
        Option regionOptFirst = new Option("0", "-----Select a session date----");
        regionOpt[0] = regionOptFirst;
        for (int i = 0; i < regionTypes.size(); i++) {
            evaResultEntity = regionTypes.get(i);
            Option optRegionType = new Option(evaResultEntity.getEvaSessionCode(), evaResultEntity.getEmpId());
            regionOpt[i + 1] = optRegionType;
        }

        return regionOpt;
    }

    public int indicatorOfCreiteriaUsage(int paraCode){
        return evaResultEntity.indicatorOfCreiteriaUsage(paraCode);
    }

    public int indicatorOfSessionUsage(int sessionID){
        return evaResultEntity.indicatorOfSessionUsage(sessionID);
    }

    public ArrayList<HashMap> loadEvaluationReportToTable(String strSearch) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = evaResultEntity.loadEvaluationReportToTable(strSearch);
            ArrayList<HashMap> resignedList = new ArrayList<HashMap>();
            while (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("EMP_ID", ocrs.getString("EMP_ID"));
                hm.put("EMPLOYEEFULLNAME", ocrs.getString("TITLE_DESCRIPTION").toString() + " " + ocrs.getString("FIRST_NAME").toString() + " " + ocrs.getString("MIDDLE_NAME").toString() + " " + ocrs.getString("LAST_NAME").toString());
                resignedList.add(hm);

            }
            return resignedList;
        } catch (Exception ex) {
            return null;
        }
    }

    public Collection loadEvaluationReport(String strSearch, String empID) {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();

        if (empID != null) {
            try {
                int sno = 1;
                double sum = 0;
                double average = 0.0;
                allEvaluatedEmployeeslist(strSearch, empID);
                for (HashMap dHashMap : filteredData) {
                    HashMap hm = new HashMap();
                    hm.put("SNO", String.valueOf(sno));
                    hm.put("EMP_ID", dHashMap.get("EMP_ID"));
                    hm.put("FIRST_NAME", dHashMap.get("FIRST_NAME"));
                    hm.put("MIDDLE_NAME", dHashMap.get("MIDDLE_NAME"));
                    hm.put("LAST_NAME", dHashMap.get("LAST_NAME"));
                    hm.put("JOB_CODE", dHashMap.get("JOB_CODE"));
                    hm.put("DIVISION", dHashMap.get("DIVISION"));
                    hm.put("START_DATE", dHashMap.get("START_DATE"));
                    hm.put("END_DATE", dHashMap.get("END_DATE"));
                    hm.put("CRITERIA_NAME", dHashMap.get("CRITERIA_NAME"));
                    hm.put("RANK", dHashMap.get("RDESCR"));
                    hm.put("EVALUATOR_FNAME", dHashMap.get("EVALUATOR_FNAME"));

                    if (dHashMap.get("RESULT").equals("1")) {
                        hm.put("R1", "✓");
                    } else if (dHashMap.get("RESULT").equals("2")) {
                        hm.put("R2", "✓");
                    } else if (dHashMap.get("RESULT").equals("3")) {
                        hm.put("R3", "✓");
                    } else if (dHashMap.get("RESULT").equals("4")) {
                        hm.put("R4", "✓");
                    } else if (dHashMap.get("RESULT").equals("5")) {
                        hm.put("R5", "✓");
                    }
                    results.add(hm);
                    sum = (sum + Double.valueOf(dHashMap.get("RESULT").toString()));
                    sno++;
                }
                
                average = sum / (sno-1);
                this.setTotalRsult(sum);
                this.setAverageResult(average);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return results;

    }
    public int savePercentValueOfEvaluation(String evaluaterID, String evaluatedEmpID, double lastAveValue, double lastPercentValue, double lastResult, String sessionID, String currentDate) {
        return evaResultEntity.insertEvaluationPercentValue(evaluaterID,evaluatedEmpID,lastAveValue,lastPercentValue,lastResult,sessionID,currentDate);
    }

    private ArrayList<HashMap> allEvaluatedEmployeeslist(String strSearch, String empID) {
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            OracleCachedRowSet data1 = new OracleCachedRowSet();
            OracleCachedRowSet data2 = new OracleCachedRowSet();
            data = evaResultEntity.loadEvaluationReport(strSearch, empID);
            ArrayList<HashMap> hmArray = new ArrayList<HashMap>();
            String DeptDesc = "";
            while (data.next()) {
                HashMap hashMap = new HashMap();
                data1 = evaResultEntity.loadDeptDetail(empID);
                data2 = evaResultEntity.loadEvaluatorsDetail(data.getString("EVALUATOR_ID"));

/////////////////////////////////--- Used to get Department where the employee is belong -----//////////////////////////////////////////////////////////////////////////////////////////////////////////

                while (data1.next()) {
                    if (data1.getString("TEAM") != null && data1.getString("DEPT_ID").equals(data1.getString("TEAM"))) {
                        DeptDesc = DeptDesc + "[" + data1.getString("DEP_DESCRIPTION") + "] ";
                    }
                    if (data1.getString("MASTEBABRIYA") != null && data1.getString("DEPT_ID").equals(data1.getString("MASTEBABRIYA"))) {
                        DeptDesc = DeptDesc + "[" + data1.getString("DEP_DESCRIPTION") + "] ";
                    }
                    if (data1.getString("DIVISION") != null && data1.getString("DEPT_ID").equals(data1.getString("DIVISION"))) {
                        DeptDesc = DeptDesc + "[" + data1.getString("DEP_DESCRIPTION") + "] ";
                    }
                    if (data1.getString("DIRECTORATE") != null && data1.getString("DEPT_ID").equals(data1.getString("DIRECTORATE"))) {
                        DeptDesc = DeptDesc + "[" + data1.getString("DEP_DESCRIPTION") + "] ";
                    }
                    if (data1.getString("DEPARTMENT_ID") != null && data1.getString("DEPT_ID").equals(data1.getString("DEPARTMENT_ID"))) {
                        DeptDesc = DeptDesc + "[" + data1.getString("DEP_DESCRIPTION") + "] ";
                    }
                }

///////////////////////////////--- Used to get Evaluators name -----///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                while (data2.next()) {
                    hashMap.put("EVALUATOR_FNAME", data2.getString("FIRST_NAME") + " " + data2.getString("MIDDLE_NAME") + " " + data2.getString("LAST_NAME"));
                }
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
                hashMap.put("DIVISION", DeptDesc);
                hashMap.put("EMP_ID", data.getString("EMP_ID"));
                hashMap.put("FIRST_NAME", data.getString("TITLE_DESCRIPTION") + "  " + data.getString("FIRST_NAME"));
                hashMap.put("MIDDLE_NAME", data.getString("MIDDLE_NAME"));
                hashMap.put("LAST_NAME", data.getString("LAST_NAME"));
                hashMap.put("JOB_CODE", data.getString("JOB_CODE"));
                hashMap.put("PAY_GRADE", data.getString("PAY_GRADE"));
                hashMap.put("START_DATE", data.getString("START_DATE"));
                hashMap.put("END_DATE", data.getString("END_DATE"));
                hashMap.put("CRITERIA_NAME", data.getString("CRITERIA_NAME"));
                hashMap.put("RDESCR", data.getString("RDESCR"));
                hashMap.put("RESULT", data.getString("RESULT"));

                hmArray.add(hashMap);
            }
            filteredData = hmArray;
            return filteredData;

        } catch (Exception ex) {
            return null;
        }
    }

}
