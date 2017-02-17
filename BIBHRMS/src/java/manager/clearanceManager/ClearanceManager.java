/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.clearanceManager;

import com.sun.webui.jsf.model.Option;
import entity.clearanceEntity.ClearanceEntity;
import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

import java.util.List;
import javax.faces.model.SelectItem;
import javax.swing.JOptionPane;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author DPClone
 */
public class ClearanceManager {

    public ClearanceManager() {
    }
    ClearanceEntity clearanceEntity = new ClearanceEntity();
    private ArrayList<SelectItem> clearanceRequest;

    public ArrayList<SelectItem> getClearanceRequest() {
        return clearanceRequest;
    }

    public void setClearanceRequest(ArrayList<SelectItem> clearanceRequest) {
        this.clearanceRequest = clearanceRequest;
    }

    public static class ItemListModel implements Serializable {

        private int itemId;
        private String dept_Id;
        private String itemName;
        private double price;
        private String description;
        private boolean selected;
        private String dataBaseStatus;
        private String clearingDepartmentId;
        private String clearingEmployeeId;

        public ItemListModel(String itemName, double price, String description, boolean selected, String dataBaseStatus, String clearingDepartmentId, String clearingEmployeeId) {
            this.itemName = itemName;
            this.price = price;
            this.description = description;
            this.selected = selected;
            this.dataBaseStatus = dataBaseStatus;
            this.dept_Id = clearingDepartmentId;
            this.clearingEmployeeId = clearingEmployeeId;
        }

        public ItemListModel(String itemName, double price, String description, String dataBaseStatus, String clearingDepartmentId, String clearingEmployeeId) {
            this.itemName = itemName;
            this.price = price;
            this.description = description;

            this.dataBaseStatus = dataBaseStatus;
            this.dept_Id = clearingDepartmentId;
            this.clearingEmployeeId = clearingEmployeeId;
        }

        public ItemListModel() {
        }

        public String getDescription() {
            return description;
        }

        public String getClearingDepartmentId() {
            return clearingDepartmentId;
        }

        public void setClearingDepartmentId(String clearingDepartmentId) {
            this.clearingDepartmentId = clearingDepartmentId;
        }

        public String getClearingEmployeeId() {
            return clearingEmployeeId;
        }

        public void setClearingEmployeeId(String clearingEmployeeId) {
            this.clearingEmployeeId = clearingEmployeeId;
        }

        public String getDept_Id() {
            return dept_Id;
        }

        public void setDept_Id(String dept_Id) {
            this.dept_Id = dept_Id;
        }

        public int getItemId() {
            return itemId;
        }

        public void setItemId(int itemId) {
            this.itemId = itemId;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getItemName() {
            return itemName;
        }

        public void setItemName(String itemName) {
            this.itemName = itemName;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getDataBaseStatus() {
            return dataBaseStatus;
        }

        public void setDataBaseStatus(String dataBaseStatus) {
            this.dataBaseStatus = dataBaseStatus;
        }
    }

    public ArrayList<SelectItem> loadClearanceRequests() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ArrayList<SelectItem> clearanceRequestList = new ArrayList<SelectItem>();
            ocrs = clearanceEntity.readClearanceRequests();
            if (ocrs.next()) {
                do {
                    clearanceRequestList.add(new Option(ocrs.getString("EMP_ID"), ocrs.getString("EMP_ID")));
                } while (ocrs.next());
            } else {
                clearanceRequestList.add(0, new Option(null, "No Request Found"));
            }
            return clearanceRequestList;
        } catch (Exception ex) {
            return null;
        }

    }

    public ArrayList<SelectItem> loadClearanceRequestsCleared() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ArrayList<SelectItem> clearanceRequestList = new ArrayList<SelectItem>();
            ocrs = clearanceEntity.readClearanceRequestsCleared();
            if (ocrs.next()) {
                do {
                    clearanceRequestList.add(new Option(ocrs.getString("EMP_ID"), ocrs.getString("EMP_ID")));
                } while (ocrs.next());
            } else {
                clearanceRequestList.add(0, new Option(null, "No Request Found"));
            }
            return clearanceRequestList;
        } catch (Exception ex) {
            return null;
        }

    }

    public ArrayList<HashMap> readAvailableDpartment() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = clearanceEntity.readAvailableDepartment();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("depID", _rs.getInt("DEPT_ID"));
                list.put("description", _rs.getString("DEP_DESCRIPTION"));
                list.put("depStatus", _rs.getString("REQUIRE_CLEARANCE"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> readAvailableDpartmentRequirecl() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = clearanceEntity.readAvailableDepartmentRequireclreance();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("depID", _rs.getInt("DEPT_ID"));
                list.put("description", _rs.getString("DEP_DESCRIPTION"));
                list.put("depStatus", _rs.getString("REQUIRE_CLEARANCE"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<HashMap> readAvailableDpartment(String sector) {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = clearanceEntity.readAvailableDepartment();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("depID", _rs.getInt("DEPT_ID"));
                list.put("description", _rs.getString("DEP_DESCRIPTION"));
                list.put("depStatus", _rs.getString("REQUIRE_CLEARANCE"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readTerminRequestsDetails(String employeeId) {
        try {
            HashMap list = new HashMap();
            OracleCachedRowSet _rs = clearanceEntity.readTreminRequestsDetails(employeeId);
            if (_rs.next()) {
                list.put("TREMINATOR_ID", _rs.getString("TREMINATOR_ID"));
                list.put("TERMINATION_CATAGORY", _rs.getString("TERMINATION_CATAGORY"));
                list.put("TERMINATION_TYPE", _rs.getString("TERMINATION_TYPE"));
                list.put("TERMINATION_DATE", _rs.getString("TERMINATION_DATE"));
                list.put("DESCRIPTION", _rs.getString("DESCRIPTION"));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readRequestsDetails(String employeeId) {
        try {
            HashMap list = new HashMap();
            OracleCachedRowSet _rs = clearanceEntity.readRequestsDetails(employeeId);
            if (_rs.next()) {
                list.put("EMP_ID", _rs.getString("EMP_ID"));
                list.put("CLEARANCE_REASON", _rs.getString("CLEARANCE_REASON"));
                list.put("CLEARANCE_TYPE", _rs.getString("CLEARANCE_TYPE"));
                list.put("CLEARANCE_STATUS", _rs.getString("CLEARANCE_STATUS"));
                list.put("DATE_TERMINATED", _rs.getString("DATE_TERMINATED"));
                list.put("FINAL_CLEARED_BY", _rs.getString("FINAL_CLEARED_BY"));
                list.put("FINAL_CLEARED_DATE", _rs.getString("FINAL_CLEARED_DATE"));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getTypeOFTeminationType(int institiId) {
        String typeOFAccredated = null;

        try {
            ResultSet _rs = clearanceEntity.selectTerminationTypes(institiId);
            while (_rs.next()) {
                typeOFAccredated = _rs.getString("CATEGORY_NAME");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
//
        return typeOFAccredated;

    }

    public HashMap checkEmployeeClearance(String employeeId, String departmentId) {

        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            HashMap list = new HashMap();
            _rs = clearanceEntity.checkEmployeeClearance(employeeId, departmentId);
            if (_rs.next()) {
                list.put("CLEARED_ID", _rs.getInt("CLEARED_ID"));
                list.put("EMP_ID", _rs.getString("EMP_ID"));
                list.put("CLEARED_BY", _rs.getString("CLEARED_BY"));
                list.put("CLEARED_DATE", _rs.getString("CLEARED_DATE"));
                list.put("CLEARED_DEPARTMENT", _rs.getString("CLEARED_DEPARTMENT"));
                list.put("CLEARED_CLOSED", _rs.getString("CLEARED_CLOSED"));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readClearedDepartmentDetail(String employeeId, String clearanceType, int departmentId) {

        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            HashMap list = new HashMap();
            _rs = clearanceEntity.readClearedDepartmentDetail(employeeId, clearanceType, departmentId);
            if (_rs.next()) {
                list.put("CLEARED_ID", _rs.getInt("CLEARED_ID"));
                list.put("CLEARED_BY", _rs.getString("CLEARED_BY"));
                list.put("CLEARED_DATE", _rs.getString("CLEARED_DATE"));
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readClearedDepartmentDetailHistory(String clearedId) {

        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            HashMap list = new HashMap();
            _rs = clearanceEntity.readClearedDepartmentDetailHistory(clearedId);
            if (_rs.next()) {
                list.put("RETURNED_YES", _rs.getInt("RETURNED_YES"));
                list.put("RETURNED_NO", _rs.getInt("RETURNED_NO"));
                if (_rs.getString("RETURNED_REMARK").toString().equalsIgnoreCase("NO")) {
                    list.put("RETURNED_REMARK", "");
                } else {
                    list.put("RETURNED_REMARK", _rs.getString("RETURNED_REMARK"));
                }
            }
            return list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int finalizeClerance(String employeeId, String clearanceType, String finalizedBy, String finalizedDate) {
        try {
            
            return clearanceEntity.finalizeClerance(employeeId, clearanceType, finalizedBy, finalizedDate);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int saveEmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, String clearanceType, int yes, int no, String remark) {
        try {
            return clearanceEntity.saveEmployeeClearance(employeeId, clearedBy, clearedDate, clearedDepartment, clearanceType, yes, no, remark);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int saveYesmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, String clearanceType, int yes, int no, String remark) {
        try {
            return clearanceEntity.saveYesEmployeeClearance(employeeId, clearedBy, clearedDate, clearedDepartment, clearanceType, yes, no, remark);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int deleteEmployeeClearance(String employeeId, String clearanceType, int departmentId) {
        try {
            return clearanceEntity.deleteEmployeeClearance(employeeId, clearanceType, departmentId);
        } catch (Exception ex) {
            return 0;
        }
    }
public int deleteEmployeeClearanceItem(String employeeId, String departmentId) {
        try {
            return clearanceEntity.deleteEmployeeClearanceItem(employeeId, departmentId);
        } catch (Exception ex) {
            return 0;
        }
    }
    public ArrayList<HashMap> readSelectedDpartment() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            _rs = clearanceEntity.readSelectedDepartment();
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("depID1", _rs.getInt("DEPT_ID"));
                list.put("description1", _rs.getString("DEP_DESCRIPTION"));
                _list.add(list);
            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public int UpdateClearDepartments(String _dep_id, String _status) {
        try {
            return clearanceEntity.UpdateClearDepartments(_dep_id, _status);
        } catch (Exception ex) {
            return 0;
        }

    }

    public Collection loadClearedDepartmentsReport(String employeeId, String type) {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        int intNum = 0;
        EmployeeManage employeeManage = new EmployeeManage();
        if (employeeId != null && type != null) {
            try {
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs = clearanceEntity.loadClearedDepartmentsReport(employeeId, type);
                while (ocrs.next()) {
                    intNum += 1;
                    HashMap hm = new HashMap();
                    employeeManage = new EmployeeManage();
                    employeeManage.loadEmpoyeeProfile(ocrs.getString("CLEARED_BY").toString());
                    hm.put("BOSSID", ocrs.getString("CLEARED_BY"));
                    hm.put("BOSSFULLNAME", employeeManage.getTitleDes() + " " + employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                    hm.put("BOSSCLEAREDDATE", ocrs.getString("CLEARED_DATE"));
                    hm.put("NUM", intNum);
                    if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("0")) {
                        hm.put("CLEARINGDEPARTMENTS", "ሲሰሩበት የነበረው ክፍል");
                    } else if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("1")) {
                        hm.put("CLEARINGDEPARTMENTS", "ፋይናንስ መምሪያ");
                    } else if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("2")) {
                        hm.put("CLEARINGDEPARTMENTS", "ሎጀስቲክስ አስ/መምሪያ");
                    } else if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("3")) {
                        hm.put("CLEARINGDEPARTMENTS", "ቤተ መፃህፍት");
                    } else if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("4")) {
                        hm.put("CLEARINGDEPARTMENTS", "ሪከርድ ማህደር አገልግሎት");
                    } else if (ocrs.getString("CLEARED_DEPARTMENT").toString().equalsIgnoreCase("5")) {
                        hm.put("CLEARINGDEPARTMENTS", "የሰው ሃይል አስተዳደር");
                    }
                    if (ocrs.getString("RETURNED_YES").equalsIgnoreCase("0")) {
                        hm.put("YES", "");
                    } else {
                        hm.put("YES", "x");
                    }
                    if (ocrs.getString("RETURNED_NO").equalsIgnoreCase("0")) {
                        hm.put("NO", "");
                    } else {
                        hm.put("NO", "x");
                    }
                    if (ocrs.getString("RETURNED_REMARK").equalsIgnoreCase("NO")) {
                        hm.put("EVIDENCE", "");
                    } else {
                        hm.put("EVIDENCE", ocrs.getString("RETURNED_REMARK"));
                    }
                    results.add(hm);
                }
            } catch (Exception ex) {
            }
        }
        return results;

    }

    public boolean saveBenefitTypes(ArrayList<ItemListModel> benefitLists) {
        ArrayList<ItemListModel> toBeInserted = new ArrayList<ItemListModel>();
        ArrayList<ItemListModel> toBeDeleted = new ArrayList<ItemListModel>();
        ArrayList<ItemListModel> toBeUpdated = new ArrayList<ItemListModel>();

        for (ItemListModel currentBenefit : benefitLists) {
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
                clearanceEntity.insertBenefitTypes(toBeInserted);
            }
            if (toBeDeleted.size() > 0) {
                clearanceEntity.deleteBenefitTypes(toBeDeleted);
            }
            if (toBeUpdated.size() > 0) {
                clearanceEntity.updateBenefitTypes(toBeUpdated);
            }
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public ArrayList<ItemListModel> getAllBenefitTypes(String clearingDepartmentId, String clearingEmployeeId) {
        ArrayList<ItemListModel> benefitTypes = new ArrayList<ItemListModel>();
        try {
            ResultSet _rs = clearanceEntity.selectAllBenefitTypes(clearingDepartmentId, clearingEmployeeId);
            while (_rs.next()) {
                ItemListModel benefitTypeModel = new ItemListModel();
                benefitTypeModel.setItemId(_rs.getInt("ID"));
                benefitTypeModel.setDept_Id(_rs.getString("DEP_ID"));
                benefitTypeModel.setItemName(_rs.getString("ITEM_NAME"));
                benefitTypeModel.setPrice(_rs.getDouble("PRICE"));
                benefitTypeModel.setDescription(_rs.getString("DESCRIPTION"));
                benefitTypeModel.setDescription(_rs.getString("EMP_ID"));
                benefitTypeModel.setDataBaseStatus("Old");
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
}