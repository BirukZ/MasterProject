/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import com.sun.webui.jsf.model.Option;
import entity.employeeHistoryEntity.LeaveTypeEntity;
import entity.leaveEntity.LeaveApproveEntity;
import entity.leaveEntity.LeaveBalanceEntity;
import entity.leaveEntity.LeaveRequestEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.HolidaysManager;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class LeaveRequestManager {

    //===============================================================================================================
    private LeaveRequestEntity leaveRequestEntity = new LeaveRequestEntity();
    private LeaveControl leaveControl = new LeaveControl();
    private LeaveBalanceEntity leaveBalanceEntity = new LeaveBalanceEntity();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
//    private ReserveLeave reserveLeave = new ReserveLeave();
    LeaveApproveEntity leaveApproveEntity = new LeaveApproveEntity();
    LeaveApproveManager leaveApproveManager = new LeaveApproveManager();
    EmployeeManage employeeManager = new EmployeeManage();
    private LeaveTypeEntity leaveTypeObj = new LeaveTypeEntity();
    String userName;//logged in employee user name, initialized when a user logges in
    String department;//logged in employee department,  initialized when a user logges in
    //=======================================old========================================================================
    public static final String LEAVE_TYPE_ANNUALLEAVE = "5";
    public static final String LEAVE_TYPE_MATERNITYLEAVE = "2";
    public static final String LEAVE_TYPE_PRENATALLEAVE = "3";
    public static final String LEAVE_TYPE_POSTNATALLEAVE = "4";
    public static final String LEAVE_TYPE_PATERNITYLEAVE = "5";
    public static final String LEAVE_TYPE_ACCIDENTLEAVE = "6";
    public static final String LEAVE_TYPE_SICKLEAVE = "7";
    public static final String LEAVE_TYPE_SICKLEAVEWITHHALFPAY = "8";
    public static final String LEAVE_TYPE_SICKLEAVEWITHOUTPAY = "12";
    public static final String LEAVE_TYPE_TRAININGLEAVE = "10";
    public static final String LEAVE_TYPE_EXAMLEAVE = "11";
    public static final String LEAVE_TYPE_LEAVEFORPERSONALMATTERS = "12";
    public static final String LEAVE_TYPE_SPECIALLEAVEWITHPAY = "13";
    public static final String LEAVE_TYPE_SPECIALLEAVEWITHOUTPAY = "14";
    public static final String LEAVE_TYPE_DEATHOFPRIMARYFAMILY = "15";
    public static final String LEAVE_TYPE_DEATHOFSECONDARYFAMILY = "16";
    public static final String LEAVE_TYPE_OTHER = "17";
    public static final String LEAVE_TYPE_MARRIAGE = "18";
    public static final String LEAVE_TYPE_GETPASS = "19";
    //======================================= end old========================================================================
    public static final String EXAM_LEAVE = "1";
    public static final String DEATH_OF_RELATIVE = "2";
    public static final String ACCIDENT_LEAVE = "3";
    public static final String DEATH_OF_FAMILY = "4";
    public static final String ANUAL_LEAVE = "5";
    public static final String MATERNITY_LEAVE = "6";
    public static final String PRENATAL_LEAVE = "7";
    public static final String POSTNATAL_LEAVE = "8";
    public static final String PATERNITY_LEAVE = "9";
    public static final String SICK_LEAVE = "10";
    public static final String TRAINING_LEAVE = "11";
    public static final String LEAVE_FOR_PERSONAL_MATTERS = "12";
    public static final String SPECIAL_LEAVE_WITH_PAY = "13";
    public static final String SPECIAL_LEAVE_WITHOUT_PAY = "14";
    public static final String OTHER = "15";
    public static final String GETPASS_LEAVE_TYPE = "19";
    //===============================================================================================================
    public static final int MAX_PERYEAR_DEATHOFSECONDARYFAMILY = 7;
    public static final int MAX_PERYEAR_SICKLEAVE = 90;
    public static final int MAX_PERYEAR_SICKLEAVEWITHHALFPAY = 90;
    public static final int MAX_PERYEAR_SICKLEAVEWITHOUTPAY = 90;
    //===============================================================================================================
    private String reason;
    private String avilebelLeaveDayes;
    private String fromDate;
    private String toDate;
    private String leaveTypeDesc;
    private String leaveDays;
    private HashMap leaveRequestInfo;
    private HashMap leaveRequestInfo2;
    private ArrayList<HashMap> leaveYear;
    private EmployeeManage empManager = new EmployeeManage();
    private HashMap listOfReserLeave;
    private String leaveType;
    private String usedYear;
    private String returnDatet;
    private ArrayList<HashMap> listOfFamilyPassedAwaye;

    public ArrayList<HashMap> getListOfFamilyPassedAwaye() {
        return listOfFamilyPassedAwaye;
    }

    public void setListOfFamilyPassedAwaye(ArrayList<HashMap> listOfFamilyPassedAwaye) {
        this.listOfFamilyPassedAwaye = listOfFamilyPassedAwaye;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getReturnDatet() {
        return returnDatet;
    }

    public void setReturnDatet(String returnDatet) {
        this.returnDatet = returnDatet;
    }

    public String getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(String leaveType) {
        this.leaveType = leaveType;
    }

    public String getAvilebelLeaveDayes() {
        return avilebelLeaveDayes;
    }

    public void setAvilebelLeaveDayes(String avilebelLeaveDayes) {
        this.avilebelLeaveDayes = avilebelLeaveDayes;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getLeaveDays() {
        return leaveDays;
    }

    public void setLeaveDays(String leaveDays) {
        this.leaveDays = leaveDays;
    }

    public HashMap getLeaveRequestInfo() {
        return leaveRequestInfo;
    }

    public void setLeaveRequestInfo(HashMap leaveRequestInfo) {
        this.leaveRequestInfo = leaveRequestInfo;
    }

    public HashMap getLeaveRequestInfo2() {
        return leaveRequestInfo2;
    }

    public void setLeaveRequestInfo2(HashMap leaveRequestInfo2) {
        this.leaveRequestInfo2 = leaveRequestInfo2;
    }

    public ArrayList<HashMap> getLeaveYear() {
        return leaveYear;
    }

    public void setLeaveYear(ArrayList<HashMap> leaveYear) {
        this.leaveYear = leaveYear;
    }

    public HashMap getListOfReserLeave() {
        return listOfReserLeave;
    }

    public void setListOfReserLeave(HashMap listOfReserLeave) {
        this.listOfReserLeave = listOfReserLeave;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public LeaveRequestManager() {
    }

    public String getUsedYear() {
        return usedYear;
    }

    public void setUsedYear(String usedYear) {
        this.usedYear = usedYear;
    }

    public LeaveRequestManager(String reason,
            String avilebelLeaveDayes,
            String fromDate,
            String toDate,
            String leaveDays,
            String leaveType,
            ArrayList<HashMap> leaveYear,
            HashMap leaveRequestInfo,
            String leaveTypeDesc,
            String usedYear,
            String returnDatet) {
        this.reason = reason;
        this.avilebelLeaveDayes = avilebelLeaveDayes;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.leaveDays = leaveDays;
        this.leaveType = leaveType;
        this.leaveRequestInfo = leaveRequestInfo;
        this.leaveYear = leaveYear;
        this.leaveTypeDesc = leaveTypeDesc;
        this.usedYear = usedYear;
        this.returnDatet = returnDatet;
    }

    public LeaveRequestManager(HashMap leaveRequestInfo,
            ArrayList<HashMap> listOfFamilyPassedAwaye,
            String leaveTypeDesc,
            String returnDatet) {
        this.reason = leaveRequestInfo.get("reason").toString();
        this.avilebelLeaveDayes = leaveRequestInfo.get("leaveDays").toString();
        this.fromDate = leaveRequestInfo.get("fromDate").toString();
        this.toDate = leaveRequestInfo.get("toDate").toString();
        this.leaveDays = leaveRequestInfo.get("leaveDays").toString();
        this.leaveType = leaveRequestInfo.get("leaveType").toString();
        this.leaveRequestInfo = leaveRequestInfo;
        this.listOfFamilyPassedAwaye = listOfFamilyPassedAwaye;
        this.returnDatet = returnDatet;
        this.leaveTypeDesc = leaveTypeDesc;
    }

    public boolean deleteLeaveRequest(String leaveRequestId, String leaveType) {
        try {
            return leaveRequestEntity.deleteLeaveRequest(leaveRequestId, leaveType);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }
    //===============================================================================================================

    public ArrayList<Option> getLeaveTypes(String gender) {
        ArrayList<Option> leaveTypes = new ArrayList<Option>();
        if (leaveTypes != null) {
            try {
                ResultSet _rs = leaveRequestEntity.selectLeaveTypes(gender);
                while (_rs.next()) {
                    leaveTypes.add(new Option(_rs.getString("LEAVE_TYPE_CODE") + "--" + _rs.getString("MIN_NUM_OF_DAYS") + "--" + _rs.getString("MAX_NUM_OF_DAYS"), _rs.getString("DESCRIPTION")));
                }
                if (leaveTypes.size() != 0) {
                    leaveTypes.add(0, new Option("-1", "SELECT LEAVE TYPE"));
                } else {
                    leaveTypes.add(new Option("-1", "NO LEAVE TYPE"));
                }
                _rs.close();
                return leaveTypes;
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return null;
            }

        }
        return null;
    }
//==========================================================================================================================

    public ArrayList<Option> getLeaveInformation(String requesterId) {
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {
            ResultSet _rs = leaveRequestEntity.selectLeaveRequestByRequesterId(requesterId, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int leaveRequestId = _rs.getInt("LEAVE_REQUEST_ID");
                    String requestStatus = _rs.getString("REQUEST_STATUS");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String reason = _rs.getString("REASON");
                    String leaveType = _rs.getString("LEAVE_TYPE");
                    String optionId = Integer.toString(leaveRequestId) + "--" + requesterId + "--" + requestStatus + "--" + reason + "--" + leaveType;
                    String optionLabel = " ON " + appliedDate + " BY " + requesterId;
                    Option data = new Option(optionId, optionLabel);
                    requestLists.add(data);
                }

                if (requestLists.size() == 0) {//if no record foond
                    //requestLists.add(new Option("-1", "SELECT"));
                }
            } else {//if exception occured
                //requestLists.add(new Option("-1", "NO VIEW AVAILABLE NOW"));
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<Option> getRequestsByStatus(String status) {
        ArrayList<Option> requestLists = new ArrayList<Option>();
        //
        try {
            if (status.equals("Pen")) {
                status = LeaveApproveManager.INITIAL_STATE_LEAVE;
            }

            ResultSet _rs = leaveRequestEntity.selectLeaveRequestByStatus(status, userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int leaveRequestId = _rs.getInt("LEAVE_REQUEST_ID");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String requestStatus = _rs.getString("REQUEST_STATUS");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String leaveType = _rs.getString("LEAVE_TYPE");
                    //String reason = _rs.getString("REASON");
                    String optionId = Integer.toString(leaveRequestId) + "--" + requesterId + "--" + requestStatus + "--" + leaveType;
                    String optionLabel = " ON " + appliedDate + " BY " + requesterId;
                    Option data = new Option(optionId, optionLabel);
                    requestLists.add(data);
                }

                if (requestLists.size() == 0) {//if no record foond
                    //requestLists.add(new Option("-1", "SELECT"));
                }
            } else {//if exception occured
                //requestLists.add(new Option("-1", "NO VIEW AVAILABLE NOW"));
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
//==========================================================================================================================

    /**
     * Auser can give decision on a request only if he/she is assigned to a role
     * which can make decision.
     */
    public ArrayList<Option> getApprovableLeaveRequests() {
        ResultSet _rs = null;
        ArrayList<Option> requestLists = new ArrayList<Option>();
        try {

            _rs = leaveRequestEntity.selectActiveLeaveRequests(userName);
            if (_rs != null) {
                while (_rs.next()) {
                    int leaveRequestId = _rs.getInt("LEAVE_REQUEST_ID");
                    String leaveCatagory = _rs.getString("LEAVE_CATAGORY");
                    String requesterId = _rs.getString("REQUESTER_ID");
                    String leaveType = _rs.getString("LEAVE_TYPE");
                    String requestStatus = _rs.getString("REQUEST_STATUS");
                    String appliedDate = _rs.getString("APPLIED_DATE");
                    String leaveDate = _rs.getString("LEAVE_DATE");
                    String description = _rs.getString("DESCRIPTION");
                    String optionId = Integer.toString(leaveRequestId) + "--" +
                            requesterId + "--" +
                            leaveCatagory + "--" +
                            leaveType + "--" +
                            requestStatus + "--" +
                            appliedDate + "--" +
                            leaveDate + "--" +
                            description;
                    String OptionDesc = " ON " + appliedDate;
                    Option data = new Option(optionId, OptionDesc);
                    requestLists.add(data);
                }

            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

        return null;
    }
//==========================================================================================================================

    /**
     * Returns (1) the laterst request or  <br>
     *         (2)-1 if no requset mage by the employee
     * @param  employeeId  id of employee who requested leave
     */
    public int getEmplyeeLatestLeaveRequestId(String employeeId) {
        try {
            String referenceDate = "";
            Calendar leaveStartCalendar = new GregorianCalendar();
            ResultSet _rs = leaveRequestEntity.selectEmployeeLatestLeaveRequest(employeeId, referenceDate, userName);
            int leaveReqId = -1;
            if (_rs.next()) {
                leaveReqId = _rs.getInt("LEAVE_REQUEST_ID");
                //if no record foound max of "LEAVE_REQUEST_ID" is assigned zero
                if (leaveReqId == 0) {
                    leaveReqId = -1;
                }

            }
            _rs.close();
            return leaveReqId;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }

    }
//==========================================================================================================================

    /**
     * Maps parameters of request to a HashMap and returns the hashMap object
     * @param requestId the primary key of table <b>HR_LEAVE_REQUEST</b>
     */
    public HashMap getEmplyeeLatestLeaveRequest(
            int requestId) {
        try {
            ResultSet _rs = leaveRequestEntity.selectLeaveRequestFromId(requestId);
            HashMap requestInfo = new HashMap();
            if (_rs.next()) {
                requestInfo.put("leaveRequestId", requestId);
                requestInfo.put("requesterId", _rs.getString("REQUESTER_ID"));
                requestInfo.put("leaveType", _rs.getString("LEAVE_TYPE"));
                requestInfo.put("requestStatus", _rs.getString("REQUEST_STATUS"));
                requestInfo.put("appliedDate", _rs.getString("APPLIED_DATE"));
                requestInfo.put("leaveDate", _rs.getString("LEAVE_DATE"));
                requestInfo.put("description", _rs.getString("DESCRIPTION"));
            } else {
                requestInfo.put("requesterId", "");
                requestInfo.put("leaveRequestId", "");
                requestInfo.put("leaveCatagory", "");
                requestInfo.put("leaveType", "");
                requestInfo.put("requestStatus", "");
                requestInfo.put("appliedDate", "");
                requestInfo.put("leaveDate", "");
                requestInfo.put("description", "");
            }

            return requestInfo;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int calculateAllowedLeaveDays(int employeeServiceYear) {
        return 0;
    }

    public int getAvailableAnnualLeaveDays(String employeeId) {
        int employeeServiceYear = employeeManager.calculateEmployeeServiceYear(employeeId);
        int totalLeaveDays = calculateAllowedLeaveDays(employeeServiceYear);
        int totalLeavesTaken = 0;//from database
        int expiredAnnualLeaves = 0;//from database
        return totalLeaveDays - expiredAnnualLeaves - totalLeavesTaken;
    }

    public boolean isDayNationalHoliday(Calendar date) {
        try {

            ResultSet _rs = leaveRequestEntity.getNationalHoliday(date.MONTH + 1, date.DATE);//month starts from 0 not from 1
            if (_rs.next()) {
                return true;
            } else {
                return false;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public boolean isDayReligeousHoliday(Calendar date) {
//      if (HolidaysManager.getChristianHolidays(StringDateManipulation.todayInEC(convertCalendarToString(date))).equals("0") &&//not christian holiday
//                HolidaysManager.getIslamicHolidays(convertCalendarToString(date)).equals("0")) {//not islamic holiday
//            return false;
//        } else {
//            return true;
//        }
        return false;

    }
//==========================================================================================================================

    public boolean isDayHoliday(Calendar date) {
        if (!(HolidaysManager.getChristianHolidays(GregorianCalendarManipulation.convertCalendarToString(date)).equals("0")) && (HolidaysManager.getIslamicHolidays(GregorianCalendarManipulation.convertCalendarToString(date)).equals("0"))) {
            return true;
        } else {
            return false;
        }
    }
//==========================================================================================================================

    /**
     * calculates returning date
     */
    public String calculateReturningDate(Date startDate, int duration, String employeeType) {
        Calendar retDate = getReturningDate(GregorianCalendarManipulation.convertDateToCalendar(dateFormat.format(startDate)), duration, employeeType);
        return GregorianCalendarManipulation.convertCalendarToString(retDate);
    }
//==========================================================================================================================

    public int getLeaveForDeathOfRelativeTakenThisYear(String employeeId) {
        int leaveDaysTaken = 0;
        String currentYear = Integer.toString(new GregorianCalendar().get(Calendar.YEAR));
        try {
            leaveDaysTaken = leaveRequestEntity.selectLeaveTakenThisYear(employeeId, LEAVE_TYPE_DEATHOFSECONDARYFAMILY, currentYear);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
        return leaveDaysTaken;
    }
//==========================================================================================================================

    public int getSickLeaveTakenThisYear(String employeeId) {
        int leaveDaysTaken = 0;
        String currentYear = Integer.toString(new GregorianCalendar().get(Calendar.YEAR));
        try {
            leaveDaysTaken = leaveRequestEntity.selectLeaveTakenThisYear(employeeId, LEAVE_TYPE_SICKLEAVE, currentYear);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
        return leaveDaysTaken;
    }
//==========================================================================================================================

    public int getAvailableSickLeaveDaysWithHalfPay(String employeeId) {
        int leaveDaysTaken = 0;
        String currentYear = Integer.toString(new GregorianCalendar().get(Calendar.YEAR));
        try {
            leaveDaysTaken = leaveRequestEntity.selectLeaveTakenThisYear(employeeId, LEAVE_TYPE_SICKLEAVEWITHHALFPAY, currentYear);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
        return MAX_PERYEAR_SICKLEAVEWITHHALFPAY - leaveDaysTaken;
    }
//==========================================================================================================================

    public int getAvailableSickLeaveDaysWithoutPay(String employeeId) {
        int leaveDaysTaken = 0;
        String currentYear = Integer.toString(Calendar.YEAR);
        try {
            leaveDaysTaken = leaveRequestEntity.selectLeaveTakenThisYear(employeeId, LEAVE_TYPE_SICKLEAVEWITHHALFPAY, currentYear);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return -1;
        }
        return MAX_PERYEAR_SICKLEAVEWITHOUTPAY - leaveDaysTaken;
    }
//==========================================================================================================================

    public Calendar getReturningDate(Calendar startDate, int duration, String employeeType) {
        int numberOfSaturdays = 0;//saturday is half working day
        for (int counter = 0; counter <
                duration; counter++) {
            if (startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY || isDayHoliday(startDate)) {
                startDate.add(Calendar.DATE, 1);
            } else if (employeeType.equals(EmployeeManage.EMPLOYEE_TYPE_OFFICE) && startDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) {
                numberOfSaturdays++;
            }

            startDate.add(Calendar.DATE, 1);
        }

        startDate.add(Calendar.DATE, -numberOfSaturdays / 2);
        return startDate;
    }

    /**
     * The method calls the readAllLeaveTypes method and arranges the
     * <code>ArrayList</code> of type <code>LeaveType</code> result into an
     * <code>Option</code>, which is  * <p>Model bean that represents a selectable choice in a selection
     * component such as <code>Menu</code>, <code>RadioButtonGroup</code>, etc
     * @return an <code>Option</code> object
     */
    public ArrayList<SelectItem> loadLeaveTypes() {
        try {
            ArrayList<LeaveTypeEntity> leaveTypes = leaveTypeObj.readAllLeaveTypes();
            ArrayList<SelectItem> leaveList = new ArrayList<SelectItem>();
            if (leaveTypes.size() > 0) {
                for (int i = 0; i < leaveTypes.size(); i++) {
                    leaveTypeObj = leaveTypes.get(i);
                    leaveList.add(new Option(String.valueOf(leaveTypeObj.getLeave_Type_Code()),
                            String.valueOf(leaveTypeObj.getDescription())));
                }
                leaveList.add(0, new Option(null, "--Select Leave type--"));
            } else {
                leaveList.add(0, new Option(null, "Not Available Leave Type"));
            }

            return leaveList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    /**
     * The method calls the readAllLeaveTypes method and arranges the
     * <code>ArrayList</code> of type <code>LeaveType</code> result into an
     * <code>Option</code>, which is  * <p>Model bean that represents a selectable choice in a selection
     * component such as <code>Menu</code>, <code>RadioButtonGroup</code>, etc
     * @return an <code>Option</code> object
     */
    public ArrayList<SelectItem> loadLeaveTypes(String gender, String forPostion) {
        try {
            ArrayList<HashMap> leaveTypes = leaveTypeObj.readAllLeaveTypes(gender, forPostion);
            ArrayList<SelectItem> leaveList = new ArrayList<SelectItem>();
            if (leaveTypes.size() > 0) {
                for (HashMap hm : leaveTypes) {
                    leaveList.add(new SelectItem(hm.get("leaveTypeId").toString(),
                            hm.get("leaveTypeName").toString()));
                }
                leaveList.add(0, new SelectItem(null, "--Select Leave type--"));
            } else {
                leaveList.add(0, new SelectItem(null, "Not Available Leave Type"));
            }

            return leaveList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<SelectItem> notAvailableLeaveType() {
        try {
            ArrayList<SelectItem> leaveList = new ArrayList<SelectItem>();
            leaveList.add(0, new SelectItem(null, "Not Available Leave Type"));
            return leaveList;

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public HashMap readLeaveInformation(
            String leaveId) {
        try {
            return leaveRequestEntity.selectLeaveInformation(leaveId);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<HashMap> readEmployeeAvaileAnualLeave(String employeeId) {
        try {
            String date = dateFormat.format(new Date());
            
          //  date = jodanTimeCalender.ChangeDateToEthiopic(date);
            int month = 0;
            int year = 0;
           
            month = StringDateManipulation.getMonth(date);
           
            year = StringDateManipulation.getYear(date);
//           
//             if (month < 10) {
//                year -= 1;
//            }
            return leaveBalanceEntity.readEmployeeAvaileAnualLeave(employeeId, Integer.toString(year));
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);

            return null;
        }
    }

    private float totalYearDay() {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String currentDate = dateFormat.format(cal.getTime());
        int year = StringDateManipulation.getYear(currentDate);
        cal1.set(year - 1, 7, 1);
        cal2.set(year, 6, 31);
        return daysBetween(cal1.getTime(), cal2.getTime());

    }

    private float workedDayes() {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        String currentDate = dateFormat.format(cal.getTime());
        int year = StringDateManipulation.getYear(currentDate);
        cal1.set(year - 1, 7, 1);
        cal2.set(year, StringDateManipulation.getMonth(currentDate), StringDateManipulation.getDate(currentDate));
        return daysBetween(cal1.getTime(), cal2.getTime());

    }

    private float daysBetween(Date d1, Date d2) {
        return (float) ((d2.getTime() - d1.getTime()) / (1000 * 60 * 60 * 24));
    }

    public String readEmployeeAvailableAnualLeave(String employeeId) 
    {
        /////This is Biruk

        int year = jodanTimeCalender.currentYearOnlyFinder();//StringDateManipulation.getYear();
        year -= 1;
        float leaveBalance = leaveBalanceEntity.readEmployeeLeaveBalance(
                employeeId,
                Integer.toString(year), totalYearDay(), workedDayes());
       // leaveBalance += leaveRequestEntity.countReserveLeave(employeeId);
        DecimalFormat df = new DecimalFormat("#.##");
        return df.format(leaveBalance).toString();//Float.toString(leaveBalance);
    }

    public String readAnualLeave(String employeeId)
    
    {

      //Here Biruk

        String date = dateFormat.format(new Date());
       
      //  date = jodanTimeCalender.ChangeDateToEthiopic(date);
      //  date = jodanTimeCalender.ChangeDateToEthiopic(date);
       
        int month = 0;
        int year = 0;
        month = StringDateManipulation.getMonth(date);
        year = StringDateManipulation.getYear(date);
//        if (month < 10)
//        {
//           // year -= 1;
//          //  year;
//        }
       
        float leaveBalance = leaveBalanceEntity.readEmployeeLeaveBalance(
                employeeId,
                Integer.toString(year));
       // JOptionPane.showMessageDialog(null, leaveBalance+"Balance");
               return Float.toString(leaveBalance);
    }

    public boolean oldLeaverequest(String employeeID) {
        try {

            return leaveRequestEntity.oldLeaverequest(employeeID);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return false;
        }

    }

    public ArrayList<SelectItem> selectLeaveRequests(String employeeID) {
        try {
            String status = null;
            ArrayList<HashMap> readRequests = leaveRequestEntity.requestedLeaveLists(employeeID); //recruitmentEntity.newRecruitmentRequests();
            ArrayList<SelectItem> leaveRequest = new ArrayList<SelectItem>();
            for (int i = 0; i <
                    readRequests.size(); i++) {
                HashMap leaveData = readRequests.get(i);
                int index = leaveData.get("STATUS").toString().indexOf("-");
                if (index > 0) {
                    if (leaveData.get("STATUS").toString().substring(0,
                            index).equals("App")) {
                        status = "Approved";
                    } else if (leaveData.get("STATUS").toString().substring(0,
                            index).equals("Rej")) {
                        status = "Reject";
                    } else if (leaveData.get("STATUS").toString().substring(0,
                            index).equals("Res")) {
                        status = "Resubmit";
                    }
                } else {
                    status = "Waiting";
                }
                leaveRequest.add(new Option(String.valueOf(leaveData.get("LEAVE_ID")),
                        String.valueOf(leaveData.get("DESCRIPTION").toString().concat("   " +
                        leaveData.get("REQUESTED_DATE") + " " + status))));
                status = "";

            }
            leaveRequest.add(0, new SelectItem(null, "--Employee Leave History--"));
            return leaveRequest;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public float countReserveLeave(String employeeId) {
        try {
            float countEmployeeReserve = leaveRequestEntity.countReserveLeave(employeeId);
            return countEmployeeReserve;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<HashMap> listOfEmployeeRegisterLeave(String leaveId) {
        return leaveRequestEntity.getEmployeeRegisterLeave(leaveId);
    }

    public ArrayList<HashMap> readReserveLeave(String employeeId) {
        return leaveRequestEntity.reserveLeave(employeeId);
    }

    public ArrayList<HashMap> selectAnnualLeavesTaken(String employeeID) {
        return leaveRequestEntity.selectAnnualLeavesTaken(employeeID);
    }

    public ArrayList<HashMap> selectAnnualLeavesTakenByHour(String employeeID) {
        return leaveRequestEntity.selectAnnualLeavesTaken(employeeID);
    }

    public ArrayList<HashMap> allowedLeave() {
        ArrayList<HashMap> allowedLeaveNumber = new ArrayList<HashMap>();
        HashMap leaveNumber = new HashMap();
        leaveNumber.put("1", "14");
        leaveNumber.put("2", "16");
        leaveNumber.put("3", "18");
        leaveNumber.put("4", "20");
        leaveNumber.put("5", "22");
        leaveNumber.put("6", "24");
        leaveNumber.put("7", "26");
        leaveNumber.put("8", "28");
        leaveNumber.put("9", "30");
        leaveNumber.put("10", "32");
        leaveNumber.put("11", "34");
        leaveNumber.put("12", "36");
        leaveNumber.put("13", "38");
        leaveNumber.put("14", "40");
        leaveNumber.put("15", "42");
        leaveNumber.put("16", "44");
        leaveNumber.put("17", "46");
        leaveNumber.put("18", "48");
        leaveNumber.put("19", "50");

        allowedLeaveNumber.add(leaveNumber);
        return allowedLeaveNumber;
    }

    /**
     * The method instatiates the Leave class, calls the insertLeave() method
     * and finally checks the return of insertLeave() to make sure the success
     * of the insert operation
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param leaveDy the total leave days
     */
    public int saveEmployeeLeaveRequest(LeaveRequestManager leaveRequest, String registerby) {
        int checkValue = 0;
        if (leaveRequest.getLeaveRequestInfo().get("leaveType").equals("5"))
        {
            LeaveRequestEntity leaveRequestInformation = new LeaveRequestEntity(
                    leaveRequest.getReason(),
                    leaveRequest.getAvilebelLeaveDayes(),
                    leaveRequest.getFromDate(),
                    leaveRequest.getToDate(),
                    leaveRequest.getLeaveDays(),
                    leaveRequest.getLeaveType(),
                    leaveRequest.getLeaveRequestInfo(),
                    leaveRequest.getLeaveYear(),
                    leaveRequest.getListOfReserLeave(),
                    leaveRequest.getReturnDatet(),
                    leaveRequest.getUsedYear());
            checkValue = leaveRequestEntity.saveEmployeeAnualLeaveRequest(
                    leaveRequestInformation,
                    LeaveApproveManager.INITIAL_STATE_LEAVE,
                    registerby);
        } else if (leaveRequest.getLeaveRequestInfo().get("leaveType").equals("19"))
        {
            LeaveRequestEntity leaveRequestInformation = new LeaveRequestEntity(
                    leaveRequest.getLeaveRequestInfo(),
                    leaveRequest.getListOfFamilyPassedAwaye());
            checkValue = leaveRequestEntity.saveEmployeeGetPassLeaveRequest(leaveRequestInformation, registerby);
        } else {
            LeaveRequestEntity leaveRequestInformation = new LeaveRequestEntity(
                    leaveRequest.getLeaveRequestInfo(),
                    leaveRequest.getListOfFamilyPassedAwaye());
            checkValue = leaveRequestEntity.saveEmployeeLeaveRequest(leaveRequestInformation, registerby);
        }
        return checkValue;
    }

    /**
     * The method instatiates the Leave class, calls the insertLeave() method
     * and finally checks the return of insertLeave() to make sure the success
     * of the insert operation
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param leaveDy the total leave days
     */
    public boolean updateEmployeeLeaveRequest(LeaveRequestManager leaveRequest) {
        try {
            LeaveRequestEntity leaveRequestInformation = new LeaveRequestEntity(
                    leaveRequest.getLeaveRequestInfo(),
                    leaveRequest.getListOfFamilyPassedAwaye());
            return leaveRequestEntity.updateLeaveRequest(leaveRequestInformation);


        } catch (Exception e) {
            return false;
        }
    }

    /**
     * The method instatiates the Leave class, calls the insertLeave() method
     * and finally checks the return of insertLeave() to make sure the success
     * of the insert operation
     * @param employeeID the unique employee identifier
     * @param leaveType the type of leave
     * @param physicalYear the fiscal year
     * @param requestDateFrom the start date of the requested date
     * @param requestDateTo the end date of the requested date
     * @param requestingReason the reason of requesting leave
     * @param requestDate the date of the request
     * @param leaveDy the total leave days
     */
    public boolean updateEmployeeAnnualLeaveRequest(LeaveRequestManager leaveRequest) {
        try {
            LeaveRequestEntity leaveRequestInformation = new LeaveRequestEntity(
                    leaveRequest.getReason(),
                    leaveRequest.getAvilebelLeaveDayes(),
                    leaveRequest.getFromDate(),
                    leaveRequest.getToDate(),
                    leaveRequest.getLeaveDays(),
                    leaveRequest.getLeaveType(),
                    leaveRequest.getLeaveRequestInfo(),
                    leaveRequest.getLeaveYear(),
                    leaveRequest.getListOfReserLeave(),
                    null,
                    null);
            return leaveRequestEntity.updateEmployeeAnualLeaveRequest(leaveRequestInformation);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public HashMap readPreviousRequestsInfo(String requestId) {
        return leaveRequestEntity.readPreviousRequestsInfo(requestId);
    }

    public HashMap ReadRequestsInfo(
            String requestId) {
        try {
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs = leaveRequestEntity.ReadRequestsInfo(requestId);
            if (ocrs.next()) {
                HashMap hm = new HashMap();
                hm.put("itemId", ocrs.getString("WF_ITEM_ID"));
                hm.put("stateId", ocrs.getString("WF_STATE_ID"));
                hm.put("stateName", ocrs.getString("WF_STATE_NAME"));
                hm.put("stateProperty", ocrs.getString("PROPERTY"));
                hm.put("ownerId", ocrs.getString("WF_OWNER_GROUP_ID"));
                hm.put("ownerName", ocrs.getString("OWNER_GROUP_NAME"));
                hm.put("workflowId", ocrs.getString("WORKFLOW_ID"));
                hm.put("workflowName", ocrs.getString("WORKFLOW_NAME"));
                return hm;
            } else {
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public String calculatForAddisOfficeWorker(String dateFr, String leaveDays) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            return LeaveControl.wrkingDaysBetweenTwoDates(date, Integer.parseInt(leaveDays));
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String calculatLeaveDateForAddisOfficeWorker(String dateFr, String leaveDays) {
        int index = leaveDays.indexOf(".");

        boolean noteHalfDay = true;
        if (index > 0) {
            leaveDays = leaveDays.substring(0, index);
            noteHalfDay = false;
        }

        int ld = Integer.parseInt(leaveDays);
        try {
            DateFormat formatter;
            Date date;
            Date date1;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            String returnDate = LeaveControl.calculatLeaveDateForAddisOfficeWorker(
                    date, ld, noteHalfDay);
            if (index > 0) {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date1 = (Date) formatter.parse(returnDate);
                int saturdayCounter = LeaveControl.getWorkingDaysBetweenTwoDates(date, date1);
                if (saturdayCounter % 2 != 0) {
                    returnDate = LeaveControl.addDaysForAddisAbeba(date1);
                // Calendar startCal = Calendar.getInstance();
                //   startCal.setTime(date);
//                if (startCal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
//                  
//                }
                } else if (saturdayCounter == 0) {
                    returnDate = LeaveControl.addDaysForAddisAbeba(date1);
                }
                date1 = (Date) formatter.parse(returnDate);
                returnDate = LeaveControl.checkAddisWorkingDay(date1);
            }



            return returnDate;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String calculatLeaveDateForShifteWorker(String dateFr, String leaveDays) {
        int index = leaveDays.indexOf(".");
        if (index > 0) {
            leaveDays = leaveDays.substring(0, index);
        }
        int ld = Integer.parseInt(leaveDays);
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            String returnDate = LeaveControl.calculateWorkingLastDateIncluDingSaturday(date, ld);
            if (index > 0 && Integer.parseInt(leaveDays) > 0) {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = (Date) formatter.parse(returnDate);
                returnDate = LeaveControl.addDaysForMugherOfficeWorker(date);
            }
            return returnDate;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    public String calculatLeaveDateForBIBOfficeWorker(String dateFr, String leaveDays) {

        int index = leaveDays.indexOf(".");
        if (index > 0) {
            leaveDays = leaveDays.substring(0, index);
        }
        int ld = Integer.parseInt(leaveDays);
        try {
            //     this.calculateWorkingLastDate(ld, nextDate);
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            String returnDate = LeaveControl.calculateWorkingLastDate(date, ld);
            if (index > 0 && Integer.parseInt(leaveDays) > 0) {
                formatter = new SimpleDateFormat("yyyy-MM-dd");
                date = (Date) formatter.parse(returnDate);
                returnDate = LeaveControl.addDaysForShiftWorker(date);
            }
            return returnDate;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
//

    public HashMap readParametersOfLeaveType(String leaveId) {
        try {
            return leaveTypeObj.readParametersOfLeaveType(leaveId);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String calculateLeaveExcludeHolidays(String dateFr, String leaveDays) {
        int ld = Integer.parseInt(leaveDays);
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            return LeaveControl.calculateLeaveDayesExcludeHolidays(date, ld);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }


    }

    public String calculateLeaveIncludeHolidays(String dateFr, String leaveDays) {
        int ld = Integer.parseInt(leaveDays);
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            return LeaveControl.calculateLeaveDayesExcludeHolidays(date, ld);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String calculateLeaveHolidays(String dateFr, String leaveDays) {
        int ld = Integer.parseInt(leaveDays);
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(dateFr);
            return LeaveControl.calculateLeaveDayesIncludeHolidays(date, ld);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public boolean checkLeaveType(String employeeId, String leaveType) {
        return leaveRequestEntity.checkLeaveType(employeeId, leaveType);
    }

    public boolean checkLeaveGetPass(String employeeId, String leaveType) {
        String month = jodanTimeCalender.currentForeignersDateFinder();
        month = month.substring(0, 7);
        return leaveRequestEntity.checkGetLeavePass(employeeId, leaveType, month);
    }

    public int checkAvilbelLeaveDayes(String employeeId) {
        int takenDayes = 0;
        try {
            ArrayList<HashMap> leavesTakenList = leaveRequestEntity.selectSickLeaves(employeeId,
                    Integer.toString(StringDateManipulation.getYear(JodanTimeCalender.foreignersToday())));
            for (HashMap hm : leavesTakenList) {
                takenDayes += Integer.parseInt(hm.get("leave_days").toString());
            }
            return takenDayes;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }


    }

    public String nextAddisWorkingDay(String endDate) {
        try {


            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(endDate);
            return LeaveControl.nextAddisWorkingDay(date);
        } catch (Exception e) {

            return null;
        }
    }

    public String nextMugherWorkingDay(String endDate) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(endDate);
            return LeaveControl.nextMugherWorkingDay(date);
        } catch (Exception e) {

            return null;
        }
    }

    public String nextShiftWorkingDay(String endDate) {
        try {
            DateFormat formatter;
            Date date;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            date = (Date) formatter.parse(endDate);
            return LeaveControl.nextShiftWorkingDay(date);
        } catch (Exception e) {

            return null;
        }
    }

    public int checkDathOfRelative(String employeeId) {
        int takenDayes = 0;
        try {
            String date = dateFormat.format(new Date());
            int month = 0;
            int year = 0;
            month = StringDateManipulation.getMonth(date);
            year = StringDateManipulation.getYear(date);
            if (month < 7) {
                year -= 1;
            }
            ArrayList<HashMap> leavesTakenList = leaveRequestEntity.checkDathOfRelative(employeeId,
                    Integer.toString(year));
            for (HashMap hm : leavesTakenList) {
                takenDayes += Integer.parseInt(hm.get("leave_days").toString());
            }
            return takenDayes;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public ArrayList<HashMap> getLeaveRequestHistory(int requestId) {
        try {
            ResultSet _rs = leaveRequestEntity.selectProcessedLeaveRequest(requestId);
            ArrayList<HashMap> requestHistoryList = new ArrayList<HashMap>();

            while (_rs.next()) {

                HashMap hm = new HashMap();
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");

                String givenDecision = _rs.getString("PERMISSION_NAME");

                hm.put("deciderEmployeeId", deciderEmployeeId);
                hm.put("deciderFullName", deciderFullName);
                hm.put("givenDecision", givenDecision);
                hm.put("timeStamp", timeStamp);
                hm.put("commentGiven", commentGiven);
                requestHistoryList.add(hm);
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean isLeaveDateValid(String str_date) {
        return leaveControl.isLeaveDateValid(str_date);
    }

    public boolean isLeaveDateIsGrate(String str_date) {
        return leaveControl.isLeaveDateIsGrate(str_date);
    }

    public boolean updateLeaveBank(String leave, float usedLeave) {
        return leaveRequestEntity.updateLeaveBank(leave, usedLeave);
    }

    public boolean deleteAnnualLeaveRequest(String leaveRequestId) {
        try {
            return leaveRequestEntity.deleteAnnualLeaveRequest(leaveRequestId);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployeeAnualLeave(String leaveId) {
        try {
            boolean saveStatus = false;
            ArrayList<HashMap> listOfRegisterLeave = this.listOfEmployeeRegisterLeave(leaveId);
            int i = 0;
            boolean firstTime = true;
            for (HashMap hm : listOfRegisterLeave) {
                String[] useLeaveId = hm.get("LEAVEIDES").toString().split("--");
                String[] leaveUsedFrom = hm.get("FROMLEAVE").toString().split("--");
                if (firstTime) {
                    i = useLeaveId.length - 1;
                    firstTime = false;
                }
                if (leaveUsedFrom[i].equals("anualLeave")) {
                    if (this.updateLeaveBank(useLeaveId[i], Float.parseFloat(hm.get("PHYSICAL_YEAR").toString()))) {
                        saveStatus = true;
                    } else {
                        saveStatus = false;
                    }
                } else {
                    return false;

                }
                i--;
            }
            if (saveStatus) {
                if (this.deleteAnnualLeaveRequest(leaveId)) {
                    return true;
                } else {
                    return false;
                }
            } else {
                return false;
            }



        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    public String readAnnualLeaveBalance(String empId) {
        String date = dateFormat.format(new Date());
        date = jodanTimeCalender.ChangeDateToEthiopic(date);
        int month = 0;
        int year = 0;
        month = StringDateManipulation.getMonth(date);
        year = StringDateManipulation.getYear(date);
        if (month < 10) {
            year -= 1;
        }
        String leaveBalance = leaveBalanceEntity.transferdLeaveBalance(empId);
        leaveBalance += leaveBalanceEntity.readAnnualLeaveBalance(empId, Integer.toString(year));

        return leaveBalance;
    }

    public String getLeaveTypeDesc() {
        return leaveTypeDesc;
    }

    public void setLeaveTypeDesc(String leaveTypeDesc) {
        this.leaveTypeDesc = leaveTypeDesc;
    }

    public static int countWorkingDateIncluDingSaturday(String startDate, String end_Date) {
        try {
            DateFormat formatter;
            Date strDate;
            Date endDate;
            formatter = new SimpleDateFormat("yyyy-MM-dd");
            strDate = (Date) formatter.parse(startDate);
            endDate = (Date) formatter.parse(end_Date);
            return LeaveControl.countWorkingDateIncluDingSaturday(strDate, endDate);
        } catch (Exception e) {
            return -1;
        }
    }

    public String extendLeave(boolean officeWorker, boolean shiftWorker, boolean mugherWorker, boolean addisAbeba) {
        return null;


    }
}
