/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import com.sun.webui.jsf.model.Option;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.terminationEntity.RetirmentEntity;

/**
 *
 * @author DPClone
 */
public class RetirmentManager {

    public RetirmentManager() {
    }
    RetirmentEntity RetirmentEntity = new RetirmentEntity();
    private ArrayList<SelectItem> clearanceRequest;

    public ArrayList<SelectItem> getClearanceRequest() {
        return clearanceRequest;
    }

    public void setClearanceRequest(ArrayList<SelectItem> clearanceRequest) {
        this.clearanceRequest = clearanceRequest;
    }

    public static class AvilableDepartmentDataModel {

        private int depID;
        private String description;
        private boolean status;
        private boolean selected;
        private String fullName;
        private String hireDate;
        private String dateOfBirth;
        private String retirmentNo;
        int age;
        String postion;

        public boolean getSelected() {
            return selected;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }

        public String getFullName() {
            return fullName;
        }

        public String getPostion() {
            return postion;
        }

        public void setPostion(String postion) {
            this.postion = postion;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public String getHireDate() {
            return hireDate;
        }

        public void setHireDate(String hireDate) {
            this.hireDate = hireDate;
        }

        public String getRetirmentNo() {
            return retirmentNo;
        }

        public void setRetirmentNo(String retirmentNo) {
            this.retirmentNo = retirmentNo;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilableDepartmentDataModel() {
        }

        public boolean getStatus() {

            return status;
        }

        public void setStatus(boolean status) {
            this.status = status;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getDepID() {
            return depID;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public void setDepID(int depID) {
            this.depID = depID;
        }

        public AvilableDepartmentDataModel(String fullName, String hireDate, String dateOfBirth, String retirmentNO, String departememnt, int yearsOld,String postion) {
            this.fullName = fullName;
            this.hireDate = hireDate;
            this.dateOfBirth = dateOfBirth;
            this.retirmentNo = retirmentNO;
            this.description = departememnt;
            this.age = yearsOld;
            this.postion=postion;
        }
    }

    public ArrayList<SelectItem> loadClearanceRequests() {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ArrayList<SelectItem> clearanceRequestList = new ArrayList<SelectItem>();
            ocrs = RetirmentEntity.readClearanceRequests();
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
            ocrs = RetirmentEntity.readClearanceRequestsCleared();
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

    public ArrayList<HashMap> readAvailableDpartment(String date, int deptId) {
        try {
            ArrayList<HashMap> _list = new ArrayList<HashMap>();
            OracleCachedRowSet _rs = RetirmentEntity.readAvailableDepartment(date, deptId);
        //    if (_rs != null) {
                while (_rs.next()) {
                    HashMap list = new HashMap();
                    list.put("fullNme", _rs.getString("fullNme"));
                    list.put("date_of_birth", _rs.getString("date_of_birth"));
                    list.put("hire_date", _rs.getString("hire_date"));
                    list.put("retirement_no", _rs.getString("retirement_no"));
                    list.put("department_name", _rs.getString("department_name"));
                    list.put("JOB_NAME", _rs.getString("JOB_NAME"));
                    _list.add(list);

                }
                return _list;
//            } else {
//                return null;
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }
    }
//==============================================

    public ArrayList<HashMap> readAllAvailableDpartment(String date) {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = RetirmentEntity.readAllAvailableDepartment(date);
            while (_rs.next()) {
                HashMap list = new HashMap();
                list.put("fullNme", _rs.getString("fullNme"));
                list.put("date_of_birth", _rs.getString("date_of_birth"));
                list.put("hire_date", _rs.getString("hire_date"));
                list.put("retirement_no", _rs.getString("retirement_no"));
                list.put("department_name", _rs.getString("department_name"));
                  list.put("JOB_NAME", _rs.getString("JOB_NAME"));
                _list.add(list);

            }
            return _list;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
//    public ArrayList<HashMap> readAvailableDpartment(String sector) {
//        ArrayList<HashMap> _list = new ArrayList<HashMap>();
//        try {
//            OracleCachedRowSet _rs = RetirmentEntity.readAvailableDepartment();
//            while (_rs.next()) {
//                HashMap list = new HashMap();
//                list.put("depID", _rs.getInt("DEPT_ID"));
//                list.put("description", _rs.getString("DEP_DESCRIPTION"));
//                list.put("depStatus", _rs.getString("REQUIRE_CLEARANCE"));
//                _list.add(list);
//            }
//            return _list;
//        } catch (Exception ex) {
//            ex.printStackTrace();
//            ErrorLogWriter.writeError(ex);
//            return null;
//        }
//    }

    public HashMap readRequestsDetails(String employeeId) {
        try {
            HashMap list = new HashMap();
            OracleCachedRowSet _rs = RetirmentEntity.readRequestsDetails(employeeId);
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

    public HashMap checkEmployeeClearance(String employeeId, String departmentId) {

        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            HashMap list = new HashMap();
            _rs = RetirmentEntity.checkEmployeeClearance(employeeId, departmentId);
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

    public HashMap readClearedDepartmentDetail(String employeeId, int clearanceType, int departmentId) {

        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            HashMap list = new HashMap();
            _rs = RetirmentEntity.readClearedDepartmentDetail(employeeId, clearanceType, departmentId);
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
            _rs = RetirmentEntity.readClearedDepartmentDetailHistory(clearedId);
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

    public int finalizeClerance(String employeeId, int clearanceType, String finalizedBy, String finalizedDate) {
        try {
            return RetirmentEntity.finalizeClerance(employeeId, clearanceType, finalizedBy, finalizedDate);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int saveEmployeeClearance(String employeeId, String clearedBy, String clearedDate, String clearedDepartment, int clearanceType, int yes, int no, String remark) {
        try {
            return RetirmentEntity.saveEmployeeClearance(employeeId, clearedBy, clearedDate, clearedDepartment, clearanceType, yes, no, remark);
        } catch (Exception ex) {
            return 0;
        }
    }

    public int deleteEmployeeClearance(String employeeId, int clearanceType, int departmentId) {
        try {
            return RetirmentEntity.deleteEmployeeClearance(employeeId, clearanceType, departmentId);
        } catch (Exception ex) {
            return 0;
        }
    }

    public ArrayList<HashMap> readSelectedDpartment() {
        ArrayList<HashMap> _list = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet _rs = new OracleCachedRowSet();
            _rs = RetirmentEntity.readSelectedDepartment();
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
            return RetirmentEntity.UpdateClearDepartments(_dep_id, _status);
        } catch (Exception ex) {
            return 0;
        }

    }

    public Collection loadClearedDepartmentsReport(String employeeId, int type) {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        int intNum = 0;
        EmployeeManage employeeManage = new EmployeeManage();
        if (employeeId != null && type >= 0) {
            try {
                OracleCachedRowSet ocrs = new OracleCachedRowSet();
                ocrs = RetirmentEntity.loadClearedDepartmentsReport(employeeId, type);
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

    public ArrayList<SelectItem> getDepartmentName() {
        try {
            ArrayList<RetirmentEntity> depart = RetirmentEntity.readDepartment();
            ArrayList<SelectItem> readDepartment = new ArrayList<SelectItem>();
            if (depart.size() > 0) {
                for (int i = 0; i < depart.size(); i++) {
                    RetirmentEntity = depart.get(i);
                    readDepartment.add(new Option(String.valueOf(RetirmentEntity.getCode()) + "-" + String.valueOf(RetirmentEntity.getDescription()),
                            String.valueOf(RetirmentEntity.getDescription())));
                }
                readDepartment.add(0, new Option(null, "-- Select Department --"));
            } else {
                readDepartment.add(0, new Option(null, "No Department Record Avilabel"));
            }

            return readDepartment;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}