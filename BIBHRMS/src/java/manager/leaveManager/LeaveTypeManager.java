/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.employeeHistoryEntity.LeaveTypeEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Administrator
 */
public class LeaveTypeManager {

    public static final String LEAVE_TYPE_ANNUALLEAVE = "1";
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
   
    public static final String LEAVE_TYPE_GETPASS = "19";
    //======================================= end old========================================================================
    public static final String EXAM_LEAVE = "1";
     public static final String LEAVE_TYPE_MARRIAGE = "18";
    public static final String DEATH_OF_RELATIVE = "21";
    public static final String ACCIDENT_LEAVE = "3";
    public static final String DEATH_OF_FAMILY = "20";
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
    private LeaveTypeEntity leaveTypeEntity = new LeaveTypeEntity();

    public static ArrayList<SelectItem> getLeveTypes() {
        ArrayList<SelectItem> leaveTypeList = new ArrayList<SelectItem>();
        leaveTypeList.add(new SelectItem(EXAM_LEAVE, "EXAM LEAVE"));
        leaveTypeList.add(new SelectItem(DEATH_OF_RELATIVE, "DEATH OF RELATIVE"));
        leaveTypeList.add(new SelectItem(ACCIDENT_LEAVE, "ACCIDENT LEAVE"));
        leaveTypeList.add(new SelectItem(DEATH_OF_FAMILY, "DEATH OF FAMILY"));
        leaveTypeList.add(new SelectItem(ANUAL_LEAVE, "ANUAL LEAVE"));
        leaveTypeList.add(new SelectItem(MATERNITY_LEAVE, "MATERNITY LEAVE"));
        leaveTypeList.add(new SelectItem(PRENATAL_LEAVE, "PRENATAL LEAVE"));
        leaveTypeList.add(new SelectItem(POSTNATAL_LEAVE, "POSTNATAL LEAVE"));
        leaveTypeList.add(new SelectItem(PATERNITY_LEAVE, "PATERNITY LEAVE"));
        leaveTypeList.add(new SelectItem(SICK_LEAVE, "SICK LEAVE"));
        leaveTypeList.add(new SelectItem(TRAINING_LEAVE, "TRAINING LEAVE"));
        leaveTypeList.add(new SelectItem(LEAVE_FOR_PERSONAL_MATTERS, "LEAVE FOR PERSONAL MATTERS"));
        leaveTypeList.add(new SelectItem(SPECIAL_LEAVE_WITH_PAY, "SPECIAL LEAVE WITH PAY"));
        leaveTypeList.add(new SelectItem(SPECIAL_LEAVE_WITHOUT_PAY, "SPECIAL LEAVE WITHOUT PAY"));
        leaveTypeList.add(new SelectItem(GETPASS_LEAVE_TYPE, "TWO HOUR GET PASS LEAVE"));
        leaveTypeList.add(new SelectItem(LEAVE_TYPE_MARRIAGE, "WEEDDING"));

        leaveTypeList.add(new SelectItem(OTHER, "OTHER"));
        leaveTypeList.add(0, new SelectItem(-1, " SELECT LEAVE TYPE "));
        return leaveTypeList;
    }

    public LeaveTypeEntity getLeaveTypeEntity() {
        return leaveTypeEntity;
    }

    public void setLeaveTypeEntity(LeaveTypeEntity leaveTypeEntity) {
        this.leaveTypeEntity = leaveTypeEntity;
    }

    public ArrayList<HashMap> leaveTypeListInformation() {
        try {
            OracleCachedRowSet rs = leaveTypeEntity.leaveTypeInformation();
            ArrayList<HashMap> trainerInfo = new ArrayList<HashMap>();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("LEAVETYPEID", rs.getString("LEAVE_TYPE_CODE"));
                hm.put("LEAVETYPENAME", rs.getString("DESCRIPTION"));
                hm.put("MINIUMDAYS", rs.getString("MIN_NUM_OF_DAYS"));
                hm.put("MAXIMUMDAYS", rs.getString("MAX_NUM_OF_DAYS"));
                hm.put("FORGENDER", rs.getString("GENDER"));
                hm.put("LEAVE_TYPE", rs.getString("LEAVE_TYPE"));
                hm.put("FOREMPLOYMENTTYPE", rs.getString("FOREMPLOYMENTTYPE"));
                hm.put("REMARK", rs.getString("REMARK"));
                trainerInfo.add(hm);
            }
            return trainerInfo;

        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public int addLeaveType(Set<HashMap> leaveTypeInfo) {
        int transactionStatus = 0;
        try {
            if (leaveTypeInfo.size() > 0) {
                for (HashMap hm : leaveTypeInfo) {
                    setLeaveTypeEntity(new LeaveTypeEntity(
                            Integer.parseInt(hm.get("leaveTypeId").toString()),
                            hm.get("leaveTypeName").toString(),
                            hm.get("leaveType").toString(),
                            hm.get("minimumDays").toString(),
                            hm.get("maximumDays").toString(),
                            hm.get("forGender").toString(),
                            hm.get("forPostion").toString(),
                            hm.get("remark").toString()));
                    if (getLeaveTypeEntity().add() == 1) {
                        transactionStatus = 1;
                    }
                }
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int updateLeaveType(
            int leaveTypeId,
            String leaveTypeName,
            String leaveType,
            String minimumDays,
            String maximumDays,
            String forGender,
            String forPostion,
            String remark) {
        int transactionStatus = 0;
        try {
            setLeaveTypeEntity(new LeaveTypeEntity(leaveTypeId,
                    leaveTypeName,
                    leaveType,
                    minimumDays,
                    maximumDays,
                    forGender,
                    forPostion,
                    remark));
            if (getLeaveTypeEntity().update() == 1) {
                transactionStatus = 1;
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public int deleteLeaveType(int leveTypeId) {
        int transactionStatus = 0;
        try {
            if (leaveTypeEntity.delete(leveTypeId) == true) {
                transactionStatus = 1;
            }
            return transactionStatus;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
    }

    public String readLeaveTypeDesc(String leaveTypdId) {
        return leaveTypeEntity.readLeaveTypeDesc(leaveTypdId);
    }
}
