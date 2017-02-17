/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.benefitManager;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.webui.jsf.model.Option;
import entity.benefitEntity.BenefitTypeEntity;
import entity.benefitEntity.PositionBenefitTypeEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author aa
 */
public class PositionBenefitTypesManager {

    PositionBenefitTypeEntity positionBenefitTypeEntity = new PositionBenefitTypeEntity();

    public ArrayList<Option> getBenefitGivenInterval() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option(-1, "--SELECT TERM--"));
        categoryList.add(new Option("1--Daily", "Daily"));
        categoryList.add(new Option("2--Weekly", "Weekly"));
        categoryList.add(new Option("3--Monthly", "Monthly"));
        categoryList.add(new Option("4--Three_Month", "Three Month"));
        categoryList.add(new Option("5--Six_Month", "Six Month"));
        categoryList.add(new Option("6--Yearly", "Yearly"));
        categoryList.add(new Option("7--When_Used_Up", "When used up"));
        return categoryList;
    }

    public boolean savePositionBenefits(ArrayList<BenefitTypeModel> benefitLists, String recorededDateAndTim) {
        int counter = 0;
        ArrayList<BenefitTypeModel> toBeInserted = new ArrayList<BenefitTypeModel>();
        ArrayList<BenefitTypeModel> toBeDeleted = new ArrayList<BenefitTypeModel>();
        ArrayList<BenefitTypeModel> toBeUpdated = new ArrayList<BenefitTypeModel>();
        for (counter = 0; counter < benefitLists.size(); counter++) {
            BenefitTypeModel currentBenefit = benefitLists.get(counter);
            if (currentBenefit.getDataBaseStatus().equals("New")) {
                toBeInserted.add(currentBenefit);
            } else if (currentBenefit.getDataBaseStatus().equals("Deleted")) {
                toBeDeleted.add(currentBenefit);
            } else if (currentBenefit.getDataBaseStatus().equals("Edited")) {
                toBeUpdated.add(currentBenefit);
            }
        }
        try {
            if (toBeInserted.size() > 0) {
                positionBenefitTypeEntity.insertPositionBenefits(toBeInserted, recorededDateAndTim);
            }
            if (toBeDeleted.size() > 0) {
                positionBenefitTypeEntity.deletePositionBenefits(toBeDeleted);
            }
            if (toBeUpdated.size() > 0) {
                positionBenefitTypeEntity.updatePositionBenefits(toBeUpdated, recorededDateAndTim);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
        return true;
    }

    public ArrayList<BenefitTypeModel> getAllpositionBenefits() {
        ArrayList<BenefitTypeModel> positionBenefitList = new ArrayList<BenefitTypeModel>();
        try {
            ResultSet _rs = positionBenefitTypeEntity.selectAllPositionBenefits();
            while (_rs.next()) {
                BenefitTypeModel currentBenefit = new BenefitTypeModel();
                currentBenefit.setBenefitPositionId(_rs.getInt("BENEFIT_POSITION_ID"));
                currentBenefit.setBenefitId(_rs.getInt("BENEFIT_TYPE_ID"));
                 currentBenefit.setLocation(_rs.getInt("location"));
                currentBenefit.setBenefitType(_rs.getString("BENEFIT_VALUE"));
                currentBenefit.setPositionId(_rs.getInt("POSITION_ID"));
                currentBenefit.setQuantity(_rs.getInt("QUANTITY"));
                currentBenefit.setRemark(_rs.getString("REMARK"));
                currentBenefit.setBenefitName(_rs.getString("BENEFIT_NAME"));
                currentBenefit.setPositionName(_rs.getString("POSITION_NAME"));
                currentBenefit.setMoneyValue(_rs.getFloat("AMOUNT_OF_BIRR"));
                //currentBenefit.setAmountOfTax(_rs.getFloat("AMOUN_OF_TAX"));
                DefaultSelectedData defaultSelectedData = new DefaultSelectedData();
                defaultSelectedData.setSelectedItem(_rs.getString("location"));
                currentBenefit.setSelectedlocation(defaultSelectedData);
                currentBenefit.setDataBaseStatus("Old");

                positionBenefitList.add(currentBenefit);
            }

            _rs.close();
            return positionBenefitList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public static class BenefitTypeModel implements Serializable {

        int benefitId;
        int benefitPositionId;
        boolean monetaryOrNonmonetary;
        String benefitName;
        String benefitType;
        String benefitDescription;
        DefaultSelectedData selectedBenefitTermLength;
        DefaultSelectedData selectedlocation;
        String benefitTermLength;
        String benefitCatagory;
        String status;
        String dataBaseStatus;
        int positionId;
        String positionName;
        int quantity;
        String remark;
        boolean selected;
        float amountOfTax;
        boolean taxableOrNot;
        String  isMonetery;
        float moneyValue;
        int location;

 public BenefitTypeModel(int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String dataBaseStatus, boolean rendered) {
            this.benefitId = benefitId;
            this.benefitName = benefitName;
            this.positionId = positionId;
            this.positionName = positionName;
            this.quantity = quantity;
            this.remark = remark;
            this.dataBaseStatus = dataBaseStatus;
            this.selected = rendered;
        }

        public BenefitTypeModel(int benefitPositionId, int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String status, boolean rendered) {
            this(benefitId, benefitName, positionId, positionName, quantity, remark, status, rendered);
            this.benefitPositionId = benefitPositionId;
        }

        public BenefitTypeModel(String benefitName, String benefitType, String benefitDescription, String benefitCatagory, String benefitTermLength, String status, boolean rendered) {
            this.benefitName = benefitName;
            this.benefitType = benefitType;
            this.benefitDescription = benefitDescription;
            this.benefitCatagory = benefitCatagory;
            this.benefitTermLength = benefitTermLength;
            this.status = status;
            this.selected = rendered;
        }

        public BenefitTypeModel(String benefitName, boolean monetaryOrNonmonetary, String benefitType, String benefitDescription, String benefitCatagory, String benefitTermLength, String status, boolean rendered) {
            this(benefitName, benefitType, benefitDescription, benefitCatagory, benefitTermLength, status, rendered);
            this.monetaryOrNonmonetary = monetaryOrNonmonetary;
        }

        public BenefitTypeModel() {
        }

        public BenefitTypeModel(int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String dataBaseStatus, boolean rendered, boolean taxableOrNot, String  isMonetery,float moneyValue) {
            this.benefitId = benefitId;
            this.benefitName = benefitName;
            this.positionId = positionId;
            this.positionName = positionName;
            this.quantity = quantity;
            this.remark = remark;
            this.dataBaseStatus = dataBaseStatus;
            this.selected = rendered;
           // this.amountOfTax = amountOfTax;
            this.taxableOrNot = taxableOrNot;
            this. isMonetery=isMonetery;
            this.moneyValue=moneyValue;
        }

        public BenefitTypeModel(int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String dataBaseStatus, boolean rendered, boolean taxableOrNot, String monetery, float moneyValue, int locations) {
             this.benefitId = benefitId;
            this.benefitName = benefitName;
            this.positionId = positionId;
            this.positionName = positionName;
            this.quantity = quantity;
            this.remark = remark;
            this.dataBaseStatus = dataBaseStatus;
            this.selected = rendered;
           // this.amountOfTax = amountOfTax;
            this.taxableOrNot = taxableOrNot;
            this. isMonetery=monetery;
            this.moneyValue=moneyValue;
            this.location=locations;
        }

        public String getBenefitDescription() {
            return benefitDescription;
        }

        public void setBenefitDescription(String benefitDescription) {
            this.benefitDescription = benefitDescription;
        }

        public float getAmountOfTax() {
            return amountOfTax;
        }

        public void setAmountOfTax(float amountOfTax) {
            this.amountOfTax = amountOfTax;
        }

        public boolean isTaxableOrNot() {
            return taxableOrNot;
        }

        public void setTaxableOrNot(boolean taxableOrNot) {
            this.taxableOrNot = taxableOrNot;
        }

        public float getMoneyValue() {
            return moneyValue;
        }

        public DefaultSelectedData getSelectedlocation() {
            return selectedlocation;
        }

        public void setSelectedlocation(DefaultSelectedData selectedlocation) {
            this.selectedlocation = selectedlocation;
        }

        public int getLocation() {
            return location;
        }

        public void setLocation(int location) {
            this.location = location;
        }

        public void setMoneyValue(float moneyValue) {
            this.moneyValue = moneyValue;
        }

        public String getIsMonetery() {
            return isMonetery;
        }

        public void setIsMonetery(String isMonetery) {
            this.isMonetery = isMonetery;
        }

        public int getBenefitId() {
            return benefitId;
        }

        public boolean isMonetaryOrNonmonetary() {
            return monetaryOrNonmonetary;
        }

        public DefaultSelectedData getSelectedBenefitTermLength() {
            return selectedBenefitTermLength;
        }

        public void setSelectedBenefitTermLength(DefaultSelectedData selectedBenefitTermLength) {
            this.selectedBenefitTermLength = selectedBenefitTermLength;
        }

        public void setMonetaryOrNonmonetary(boolean monetaryOrNonmonetary) {
            this.monetaryOrNonmonetary = monetaryOrNonmonetary;
        }

        public void setBenefitId(int benefitId) {
            this.benefitId = benefitId;
        }

        public String getBenefitName() {
            return benefitName;
        }

        public void setBenefitName(String benefitName) {
            this.benefitName = benefitName;
        }

        public String getBenefitTermLength() {
            return benefitTermLength;
        }

        public void setBenefitTermLength(String benefitTermLength) {
            this.benefitTermLength = benefitTermLength;
        }

        public String getBenefitType() {
            return benefitType;
        }

        public void setBenefitType(String benefitType) {
            this.benefitType = benefitType;
        }

        public String getPositionName() {
            return positionName;
        }

        public void setPositionName(String positionName) {
            this.positionName = positionName;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDataBaseStatus() {
            return dataBaseStatus;
        }

        public void setDataBaseStatus(String dataBaseStatus) {
            this.dataBaseStatus = dataBaseStatus;
        }

        public String getBenefitCatagory() {
            return benefitCatagory;
        }

        public void setBenefitCatagory(String benefitCatagory) {
            this.benefitCatagory = benefitCatagory;
        }

        public int getBenefitPositionId() {
            return benefitPositionId;
        }

        public void setBenefitPositionId(int benefitPositionId) {
            this.benefitPositionId = benefitPositionId;
        }

        public int getPositionId() {
            return positionId;
        }

        public void setPositionId(int positionId) {
            this.positionId = positionId;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }
    }
}

