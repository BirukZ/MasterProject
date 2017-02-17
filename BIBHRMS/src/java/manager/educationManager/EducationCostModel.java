/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

/**
 *
 * @author mekete
 */
public class EducationCostModel {

    String costTypeId;
    String costTypeCategory;
    String costTypeName;
    String budjetYear;
    int trainingId;
    int quantityOrAmount;
    double unitCost;
    double totalCost;
    String batchCode;
    String recieptNumber;
    String documentReferenceNumber;
    String paymentDate;
    String databaseStatus;
    String userName;
    String timeStamp;
    String remark;

    String stationaryName = null;
    double price = 0.0;

    public EducationCostModel() {
    }

    public EducationCostModel(String costTypeId, String costTypeCategory, String costTypeName, String budjetYear, int trainingId, int quantityOrAmount, double unitCost, double totalCost, String recieptNumber, String paymentDate, String databaseStatus) {
        this.costTypeId = costTypeId;
        this.costTypeCategory = costTypeCategory;
        this.costTypeName = costTypeName;
        this.budjetYear = budjetYear;
        this.trainingId = trainingId;
        this.quantityOrAmount = quantityOrAmount;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.recieptNumber = recieptNumber;
        this.paymentDate = paymentDate;
        this.databaseStatus = databaseStatus;
    }

    public EducationCostModel(String costTypeId, String costTypeCategory, String costTypeName, String budjetYear, int trainingId, int quantityOrAmount, double unitCost, double totalCost, String documentReferenceNumber, String databaseStatus) {
        this.costTypeId = costTypeId;
        this.costTypeCategory = costTypeCategory;
        this.costTypeName = costTypeName;
        this.budjetYear = budjetYear;
        this.trainingId = trainingId;
        this.quantityOrAmount = quantityOrAmount;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.documentReferenceNumber = documentReferenceNumber;
        this.databaseStatus = databaseStatus;
    }

    public EducationCostModel(String costTypeId, String costTypeCategory, String costTypeName, String budjetYear, int trainingId, String batchCode, int quantityOrAmount, double unitCost, double totalCost, String documentReferenceNumber, String databaseStatus) {
        this.costTypeId = costTypeId;
        this.costTypeCategory = costTypeCategory;
        this.costTypeName = costTypeName;
        this.budjetYear = budjetYear;
        this.trainingId = trainingId;
        this.quantityOrAmount = quantityOrAmount;
        this.unitCost = unitCost;
        this.totalCost = totalCost;
        this.batchCode = batchCode;
        this.documentReferenceNumber = documentReferenceNumber;
        this.databaseStatus = databaseStatus;
    }
    public EducationCostModel(String stationaryName, double price){
        this.stationaryName = stationaryName;
        this.price = price;
    }


    public String getStationaryName() {
        return stationaryName;
    }

    public void setStationaryName(String stationaryName) {
        this.stationaryName = stationaryName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getUnitCost() {
        return unitCost;
    }

    public void setUnitCost(double unitCost) {
        this.unitCost = unitCost;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public String getDocumentReferenceNumber() {
        return documentReferenceNumber;
    }

    public void setDocumentReferenceNumber(String documentReferenceNumber) {
        this.documentReferenceNumber = documentReferenceNumber;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getUserName() {
        return userName;
    }

    public String getBatchCode() {
        return batchCode;
    }

    public void setBatchCode(String batchCode) {
        this.batchCode = batchCode;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCostTypeName() {
        return costTypeName;
    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public String getPaymentDate() {
        return paymentDate;
    }

    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getRecieptNumber() {
        return recieptNumber;
    }

    public void setRecieptNumber(String recieptNumber) {
        this.recieptNumber = recieptNumber;
    }

    public void setCostTypeName(String costTypeName) {
        this.costTypeName = costTypeName;
    }

    public String getCostTypeCategory() {
        return costTypeCategory;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
    }

    public void setCostTypeCategory(String costTypeCategory) {
        this.costTypeCategory = costTypeCategory;
    }

    public String getCostTypeId() {
        return costTypeId;
    }

    public void setCostTypeId(String costTypeId) {
        this.costTypeId = costTypeId;
    }

    public int getQuantityOrAmount() {
        return quantityOrAmount;
    }

    public void setQuantityOrAmount(int quantityOrAmount) {
        this.quantityOrAmount = quantityOrAmount;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }
}
