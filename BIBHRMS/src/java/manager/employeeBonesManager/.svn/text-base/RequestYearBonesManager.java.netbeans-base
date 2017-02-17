/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeBonesManager;

import entity.employeeBonesEntity.RequestYearBonesEntity;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.DateConverter;

/**
 *
 * @author Administrator
 */
public class RequestYearBonesManager {

    private String employeeId;
    private String employeeName;
    private float evaluationResult;
    private float acquireMonth;
    private float amountInBirr;
    private String exprience;
    private String salary;
    private boolean selectList;
    private boolean employeeEvaluation;
    private RequestYearBonesEntity requestYearBonesEntity = null;

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public boolean isEmployeeEvaluation() {
        return employeeEvaluation;
    }

    public void setEmployeeEvaluation(boolean employeeEvaluation) {
        this.employeeEvaluation = employeeEvaluation;
    }

    public String getExprience() {
        return exprience;
    }

    public void setExprience(String exprience) {
        this.exprience = exprience;
    }

    public boolean isSelectList() {
        return selectList;
    }

    public void setSelectList(boolean selectList) {
        this.selectList = selectList;
    }

    public float getAcquireMonth() {
        return acquireMonth;
    }

    public void setAcquireMonth(float acquireMonth) {
        this.acquireMonth = acquireMonth;
    }

    public float getAmountInBirr() {
        return amountInBirr;
    }

    public void setAmountInBirr(float amountInBirr) {
        this.amountInBirr = amountInBirr;
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

    public float getEvaluationResult() {
        return evaluationResult;
    }

    public void setEvaluationResult(float evaluationResult) {
        this.evaluationResult = evaluationResult;
    }

    public RequestYearBonesManager() {
    }

    public RequestYearBonesManager(String employeeId,
            String employeeName,
            float evaluationResult,
            float acquireMonth,
            float amountInBirr,
            String exprience,
            String salary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.evaluationResult = evaluationResult;
        this.acquireMonth = acquireMonth;
        this.amountInBirr = amountInBirr;
        this.exprience = exprience;
        this.salary = salary;
    }

    public ArrayList<HashMap> listOfEmployee(String location, String endOfBugerYear) {
        try {
            checkObject();
            return requestYearBonesEntity.listOfEmployee(location, endOfBugerYear);
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    private void checkObject() {
        if (requestYearBonesEntity == null) {
            requestYearBonesEntity = new RequestYearBonesEntity();
        }
    }

    public ArrayList<HashMap> bonesCalculation(
            String location,
            String bugerYear,
            String evaluationStart,
            String evaluationEnd,
            int allowdMonth) {
        String exp[] = null;
        float evaResult = 0;
        float empSalary = 0;
        float month = 0;
        float day = 0;
        String year;
        String extractMonth;
        String extractDay;
        float pesentage = 0;
        float allowedBones = 0;
        checkObject();
        boolean expectBonessFor = false;


        try {
            String bonusYear = DateConverter.fromECToGC(""+bugerYear+"-10-30");//
            ArrayList<HashMap> calculation = requestYearBonesEntity.listOfCalculation();
            ArrayList<HashMap> listOfEmp = requestYearBonesEntity.listOfEmployeeBonesCalculation(
                    location, evaluationStart, evaluationEnd,bonusYear);
            ArrayList<HashMap> listOfCal = new ArrayList<HashMap>();
            for (HashMap hm : listOfEmp) {
                evaResult = Float.parseFloat(hm.get("EVALUATIONRESULT").toString());
                expectBonessFor = false;
                for (HashMap cal : calculation) {
                    if (evaResult >= Float.parseFloat(cal.get("start").toString()) && evaResult <= Float.parseFloat(cal.get("end").toString())) {
                        pesentage = Float.parseFloat(cal.get("PERCENTAGE").toString());
                        expectBonessFor = true;
                        break;

                    }
                }
                if (expectBonessFor) {
                    HashMap h = new HashMap();
                    exp = hm.get("EXPRIANCE").toString().split("&");
                    h.put("EMP_ID", hm.get("EMP_ID").toString());
                    h.put("FULLNAME", hm.get("FULLNAME").toString());
                    h.put("EXPRIANCE", hm.get("EXPRIANCE").toString());
                    h.put("EVALUATIONRESULT", hm.get("EVALUATIONRESULT").toString());
                    h.put("CURRENT_SALARY", hm.get("CURRENT_SALARY").toString());

                    empSalary = Float.parseFloat(hm.get("CURRENT_SALARY").toString());
                    year = exp[0];
                    h.put("PERCENTAGE", Float.toString(pesentage));
                    year = year.replaceAll("[^\\d.]", "");
                    if (Integer.parseInt(year) > 0) {

                        empSalary *= allowdMonth;
                        allowedBones = (empSalary * pesentage) / 100;

                        DecimalFormat df = new DecimalFormat("#.##");
                        h.put("allowedBones", df.format(allowedBones));
                    } else {
                        allowedBones = (empSalary * pesentage) / 100;
                        extractMonth = exp[1];
                        extractMonth = extractMonth.replaceAll("[^\\d.]", "");
                        extractDay = exp[2];
                        extractDay = extractDay.replaceAll("[^\\d.]", "");
                        month = Float.parseFloat(extractMonth);
                        day = Float.parseFloat(extractDay);
                        allowedBones = (empSalary / 12 * month + (empSalary / 12 / 30 * day)) * allowdMonth;
                        allowedBones = (allowedBones * pesentage) / 100;
                        DecimalFormat df = new DecimalFormat("#.##");
                        h.put("allowedBones", df.format(allowedBones).toString());

                    }
                    pesentage = 0;
                    listOfCal.add(h);
                }

            }
            return listOfCal;
        } catch (Exception e) {
            e.printStackTrace();

        }



        return null;

    }

    public boolean saveBonesRequest(HashMap listOfRequest, ArrayList<HashMap> listOfEmployee) {
        try {
            return requestYearBonesEntity.saveBonesRequest(listOfRequest, listOfEmployee);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
