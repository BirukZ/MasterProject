/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.benefitManager;

import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.sun.webui.jsf.model.Option;
import entity.benefitEntity.BenefitTypeEntity;
import fphrms.DeviceList;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author aa
 */
public class BenefitTypesManager {

    BenefitTypeEntity benefitTypeEntity = new BenefitTypeEntity();

    public ArrayList<Option> getBenefitGivenInterval() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option("-1", "--SELECT TERM--"));
        categoryList.add(new Option("Daily", "Daily"));
        categoryList.add(new Option("Weekly", "Weekly"));
        categoryList.add(new Option("Monthly", "Monthly"));
        categoryList.add(new Option("Three_Month", "Three Month"));
        categoryList.add(new Option("SixMonth", "Six Month"));
        categoryList.add(new Option("Yearly", "Yearly"));
        categoryList.add(new Option("WhenUsedUp", "When used up"));
        return categoryList;
    }

    public ArrayList<Option> getSaftyDeviceNot() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option("-1", "--SELECT Type--"));
        categoryList.add(new Option("Yes", "Yes"));
        categoryList.add(new Option("No", "No"));
        return categoryList;
    }

    public boolean saveBenefitTypes(ArrayList<BenefitTypeModel> benefitLists) {
        ArrayList<BenefitTypeModel> toBeInserted = new ArrayList<BenefitTypeModel>();
        ArrayList<BenefitTypeModel> toBeDeleted = new ArrayList<BenefitTypeModel>();
        ArrayList<BenefitTypeModel> toBeUpdated = new ArrayList<BenefitTypeModel>();
//        for (int counter = 0; counter < benefitLists.size(); counter++) {
//            BenefitTypeModel currentBenefit = benefitLists.get(counter);
//            s.print(" saveBenefitTypes  " + currentBenefit.getDataBaseStatus());
//            if (currentBenefit.getDataBaseStatus().equals("New")) {
//                toBeInserted.add(currentBenefit);
//            } else if (currentBenefit.getDataBaseStatus().equals("Deleted")) {
//                toBeDeleted.add(currentBenefit);
//            } else if (currentBenefit.getDataBaseStatus().equals("Edited")) {
//                toBeUpdated.add(currentBenefit);
//            }
//        }
        for (BenefitTypeModel currentBenefit : benefitLists) {
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
                benefitTypeEntity.insertBenefitTypes(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {
                benefitTypeEntity.deleteBenefitTypes(toBeDeleted);
            }
            if (toBeUpdated.size() > 0) {
                benefitTypeEntity.updateBenefitTypes(toBeUpdated);
            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<Option> getAllBenefitTypesOption() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectAllBenefitTypes();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("BENEFIT_TYPE_ID") + "--" + _rs.getString("BENEFIT_NAME"), _rs.getString("BENEFIT_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO BENEFIT TYPE"));
            } else {
                benefitTypes.add(0, new Option("-1", "SELECT BENEFIT TYPE"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

     public ArrayList<Option> getLocations() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectLocations();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("LOCTION_ID") + "--" + _rs.getString("LOCATION_NAME"), _rs.getString("LOCATION_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO LOCATION"));
            } else {
                benefitTypes.add(0, new Option("-1", "SELECT LOCATION"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
 public ArrayList<Option> getAllMaterials() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectAllBenefitTypes();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("BENEFIT_TYPE_ID") + "--" + _rs.getString("BENEFIT_NAME"), _rs.getString("BENEFIT_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO BENEFIT TYPE"));
            } else {
                benefitTypes.add(0, new Option("-1", "SELECT BENEFIT TYPE"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
    public ArrayList<Option> getPostions() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectAllPostions();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("job_Code"), _rs.getString("JOB_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO POSTIONS "));
            } else {
                benefitTypes.add(0, new Option("-1", "--SELECT POSTIONS--"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<Option> getBenifinNames() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectAllBenefitTypes();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("BENEFIT_TYPE_ID"), _rs.getString("BENEFIT_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO BENEFIT TYPE"));
            } else {
                benefitTypes.add(0, new Option("-1", "SELECT BENEFIT TYPE"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
 public ArrayList<Option> getBenifinLocations() {
        ArrayList<Option> benefitTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = benefitTypeEntity.selectLocations();
            while (_rs.next()) {
                benefitTypes.add(new Option(_rs.getInt("LOCTION_ID"), _rs.getString("LOCATION_NAME")));
            }
            if (benefitTypes.size() == 0) {
                benefitTypes.add(new Option("-1", "NO LOCATION"));
            } else {
                benefitTypes.add(0, new Option("-1", "SELECT LOCATION_NAME"));
            }
            _rs.close();
            return benefitTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
    public ArrayList<BenefitTypeModel> getAllBenefitTypes() {
        ArrayList<BenefitTypeModel> benefitTypes = new ArrayList<BenefitTypeModel>();
        try {
            ResultSet _rs = benefitTypeEntity.selectAllBenefitTypes();
            while (_rs.next()) {
                BenefitTypeModel benefitTypeModel = new BenefitTypeModel();
                benefitTypeModel.setBenefitId(_rs.getInt("BENEFIT_TYPE_ID"));
                benefitTypeModel.setBenefitName(_rs.getString("BENEFIT_NAME"));
                benefitTypeModel.setBenefitDescription(_rs.getString("DESCRIPTION"));
                benefitTypeModel.setBenefitTermLength(_rs.getString("BENEFIT_DURATION"));
                 benefitTypeModel.setSaftyDevices(_rs.getString("SAFTEY_DEVICE"));
                benefitTypeModel.setBenefitType(_rs.getString("BENEFIT_VALUE"));
                benefitTypeModel.setBenefitCatagory(_rs.getString("BENEFIT_VALUE"));
               // benefitTypeModel.setMonetaryOrNonmonetary(_rs.getString("MONETARY").equals("YES"));
                benefitTypeModel.setPercentOrNot(_rs.getString("IN_PERCENT").equals("YES"));
               // benefitTypeModel.setMoneyValue(_rs.getFloat("MONETARY_VALUE"));
                benefitTypeModel.setPercrnt(_rs.getInt("PERCENT"));
                benefitTypeModel.setDataBaseStatus("Old");
                DefaultSelectedData defaultSelectedData = new DefaultSelectedData();
                defaultSelectedData.setSelectedItem(_rs.getString("BENEFIT_DURATION"));
                benefitTypeModel.setSelectedBenefitTermLength(defaultSelectedData);
//                DefaultSelectedData defaultSelectedDatas = new DefaultSelectedData();
                benefitTypeModel.setSaftyDevices(_rs.getString("SAFTEY_DEVICE"));
//                benefitTypeModel.setSelectedSafty(defaultSelectedDatas);
                benefitTypes.add(benefitTypeModel);
            }
            _rs.close();
            return benefitTypes;
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
        DefaultSelectedData selectedSafty;
        String benefitTermLength;
        String benefitCatagory;
        String status;
        String dataBaseStatus;
        int positionId;
        String positionName;
        int quantity;
        String remark;
        boolean selected;
        float moneyValue;
        int percrnt;
        boolean percentOrNot;
        boolean saftyDevice;
        String saftyDevices;
        public BenefitTypeModel(int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String status, boolean rendered) {
            this.benefitId = benefitId;
            this.benefitName = benefitName;
            this.positionId = positionId;
            this.positionName = positionName;
            this.quantity = quantity;
            this.remark = remark;
            this.status = status;
            this.selected = rendered;
        }

        public BenefitTypeModel(String benefitName, String benefitType, String benefitDescription, String benefitCatagory, String benefitTermLength, String dataBaseStatus, boolean rendered, int percrnt, boolean percentOrNot, String saftyDevices) {
             this.benefitName = benefitName;
            this.benefitType = benefitType;
            this.benefitDescription = benefitDescription;
            this.benefitCatagory = benefitCatagory;
            this.benefitTermLength = benefitTermLength;
            this.dataBaseStatus = dataBaseStatus;
            this.selected = rendered;
            this.percrnt = percrnt;
            this.percentOrNot = percentOrNot;
            this.saftyDevices=saftyDevices;

        }

        public BenefitTypeModel(String benefitName, boolean monetaryOrNonmonetary, String benefitType, String benefitDescription, String benefitCatagory, String benefitTermLength, String dataBaseStatus, boolean rendered, float moneyValue, int percrnt, boolean percentOrNot,String saftyDevice) {
            this.benefitName = benefitName;
            this.benefitType = benefitType;
            this.benefitDescription = benefitDescription;
            this.benefitCatagory = benefitCatagory;
            this.benefitTermLength = benefitTermLength;
            this.dataBaseStatus = dataBaseStatus;
            this.selected = rendered;
            this.monetaryOrNonmonetary = monetaryOrNonmonetary;
            this.moneyValue = moneyValue;
            this.percrnt = percrnt;
            this.percentOrNot = percentOrNot;
            this.saftyDevices=saftyDevice;

        }

        public BenefitTypeModel(int benefitPositionId, int benefitId, String benefitName, int positionId, String positionName, int quantity, String remark, String status, boolean rendered) {
            this(benefitId, benefitName, positionId, positionName, quantity, remark, status, rendered);
            this.benefitPositionId = benefitPositionId;
        }

        public BenefitTypeModel(String benefitName, String benefitType, String benefitDescription, String benefitCatagory, String benefitTermLength, String dataBaseStatus, boolean rendered) {
            this.benefitName = benefitName;
            this.benefitType = benefitType;
            this.benefitDescription = benefitDescription;
            this.benefitCatagory = benefitCatagory;
            this.benefitTermLength = benefitTermLength;
            this.dataBaseStatus = status;
            this.selected = rendered;
        }

        public BenefitTypeModel() {
        }

        public String getBenefitDescription() {
            return benefitDescription;
        }

        public void setBenefitDescription(String benefitDescription) {
            this.benefitDescription = benefitDescription;
        }

        public int getBenefitId() {
            return benefitId;
        }

        public boolean isMonetaryOrNonmonetary() {
            return monetaryOrNonmonetary;
        }

        public String getDataBaseStatus() {
            return dataBaseStatus;
        }

        public void setDataBaseStatus(String dataBaseStatus) {
            this.dataBaseStatus = dataBaseStatus;
        }

        public DefaultSelectedData getSelectedBenefitTermLength() {
            return selectedBenefitTermLength;
        }

        public boolean isSaftyDevice() {
            return saftyDevice;
        }

        public void setSaftyDevice(boolean saftyDevice) {
            this.saftyDevice = saftyDevice;
        }

        public void setSelectedBenefitTermLength(DefaultSelectedData selectedBenefitTermLength) {
            this.selectedBenefitTermLength = selectedBenefitTermLength;
        }

        public float getMoneyValue() {
            return moneyValue;
        }

        public void setMoneyValue(float moneyValue) {
            this.moneyValue = moneyValue;
        }

        public String getSaftyDevices() {
            return saftyDevices;
        }

        public void setSaftyDevices(String saftyDevices) {
            this.saftyDevices = saftyDevices;
        }

        public boolean isPercentOrNot() {
            return percentOrNot;
        }

        public void setPercentOrNot(boolean percentOrNot) {
            this.percentOrNot = percentOrNot;
        }

        public int getPercrnt() {
            return percrnt;
        }

        public void setPercrnt(int percrnt) {
            this.percrnt = percrnt;
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

        public DefaultSelectedData getSelectedSafty() {
            return selectedSafty;
        }

        public void setSelectedSafty(DefaultSelectedData selectedSafty) {
            this.selectedSafty = selectedSafty;
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
    public HashMap readDeviceBasicInfo(String deviceCode) {
        try {
            return benefitTypeEntity.readDeviceBasicInfoFromId(deviceCode);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    public ArrayList<DeviceList> benefitNameForAutoList(String benfiteName){
              try {

            ResultSet rs = benefitTypeEntity.searchBenefitNametoAuto(benfiteName);
            ArrayList<DeviceList> jobListAr = new ArrayList<DeviceList>();
            while (rs.next()) {
                DeviceList empMgt = new DeviceList(rs.getString("ITEM_CODE"),
                        rs.getString("ITEM_NAME"));
                jobListAr.add(empMgt);

            }
            return jobListAr;
        } catch (Exception ex) {
            ex.printStackTrace();
//             ex.getMessage());

            ErrorLogWriter.writeError(ex);
        }
        return null;
    }

}

