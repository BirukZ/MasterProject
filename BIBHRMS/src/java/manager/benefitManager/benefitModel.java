/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.benefitManager;

/**
 *
 * @author Admin
 */
public class benefitModel {
 String benefiName;
    String benefitTyppe;
    String moneybenefit;
    String description;
    String benefitDuration;
    String department;
    String team;
    String safetyDevice;
    String deptType;
    String deptQuantity;
    double amountOfMoney;
 public benefitModel(){

 }
    public benefitModel(String benefiName, String benefitTyppe, String moneybenefit, String description, String benefitDuration, String department, String team, String deptType, String deptQuantity, double amountOfMoney,String safetyDevice) {

        this.benefiName=benefiName;
        this.benefitTyppe=benefitTyppe;
        this.moneybenefit=moneybenefit;
        this.description=description;
        this.benefitDuration=benefitDuration;
        this.department=department;
        this.team=team;
        this.deptType=deptType;
        this.deptQuantity=deptQuantity;
        this.amountOfMoney=amountOfMoney;
        this.safetyDevice=safetyDevice;

    }

    public String getBenefiName() {
        return benefiName;
    }

    public void setBenefiName(String benefiName) {
        this.benefiName = benefiName;
    }

    public String getBenefitDuration() {
        return benefitDuration;
    }

    public void setBenefitDuration(String benefitDuration) {
        this.benefitDuration = benefitDuration;
    }

    public String getBenefitTyppe() {
        return benefitTyppe;
    }

    public void setBenefitTyppe(String benefitTyppe) {
        this.benefitTyppe = benefitTyppe;
    }

    public String getDepartment() {
        return department;
    }

    public String getSafetyDevice() {
        return safetyDevice;
    }

    public void setSafetyDevice(String safetyDevice) {
        this.safetyDevice = safetyDevice;
    }

    public double getAmountOfMoney() {
        return amountOfMoney;
    }

    public void setAmountOfMoney(double amountOfMoney) {
        this.amountOfMoney = amountOfMoney;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDeptQuantity() {
        return deptQuantity;
    }

    public void setDeptQuantity(String deptQuantity) {
        this.deptQuantity = deptQuantity;
    }

    public String getDeptType() {
        return deptType;
    }

    public void setDeptType(String deptType) {
        this.deptType = deptType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMoneybenefit() {
        return moneybenefit;
    }

    public void setMoneybenefit(String moneybenefit) {
        this.moneybenefit = moneybenefit;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }




}
