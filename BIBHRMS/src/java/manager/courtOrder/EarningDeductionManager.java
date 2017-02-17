/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.courtOrder;
import manager.courtOrder.FMS_Utility;
import entity.courtOrder.EarningDeduction;
import entity.courtOrder.EarningDeductionConstant;
//import errorWriter.ErrorLogWriter;
import entity.courtOrder.EarningDeduction;
import entity.courtOrder.EarningDeductionConstant;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
public class EarningDeductionManager {
 public static int BASED_ON_PERCENT = 0;
    public static int BASED_ON_LUMP_SUM = 1;
    public static int BASED_ON_PER_WORKING_DAYS = 2;
    public static int BASED_ON_QUOTA = 3;

    public static int BASIC_SALARY_TAXABLE_CODE = 4;
    public static int INCOME_TAX_CODE = 5;
    public static int HOLIDAY_OVERTIME_CODE = 6;
    public static int SUNDAY_OVERTIME_CODE = 7;
    public static int WORKING_DAY_OT_B_EIGHT = 8;
    public static int WORKING_DAY_OT_A_EIGHT = 9;
    public static int MILK_CODE = 11;
    public static int MILK_RATE = 12;
    public static int SATURDAY_OVERTIME_CODE = 13;
    public static int FUEL_CODE_QUOTA = 14;
    public static int FUEL_RATE = 15;
    public static int HARDSHIP_ALLOWANCE_NT_30_CODE = 16;
    public static int HARDSHIP_ALLOWANCE_NT_10_CODE = 17;
    public static int ABSENT_CODE = 18;
    public static int BASIC_SALARY_NON_TAXABLE_CODE = 19;
    public static int TRANSPORT_ALLOWANCE_TAXABLE = 20;
    public static int TRANSPORT_ALLOWANCE_NON_TAXABLE = 21;
    public static int PENSION_CODE = 22;
    public static int PENSION_RATE = 23;
    public static int SAVING_CODE = 24;
    public static int SAVING_RATE_PERCENT = 25;
    public static int SAVING_RATE_CONSTANT = 26;
    public static int HARDSHIP_ALLOWANCE_TAXABLE_10_CODE = 27;
    public static int COMPENSATION_CODE = 28;
    public static int HARDSHIP_ALLOWANCE_NT_30_RATE = 29;
    public static int HARDSHIP_ALLOWANCE_NT_10_RATE = 30;
    public static int HARDSHIP_ALLOWANCE_TAXABLE_10_RATE = 31;

    public static ArrayList<SelectItem> getEarningDeductionCodeList() {
        ArrayList<SelectItem> earningDeductionCodeList = new ArrayList<SelectItem>();
        ResultSet _rs = null;
        EarningDeduction earnDeduct = new EarningDeduction();
        try {
            _rs = earnDeduct.search();
            if (_rs.next()) {
                earningDeductionCodeList.add(new SelectItem(null, "--SELECT--"));
                do {
                    earningDeductionCodeList.add(new SelectItem(_rs.getString("CODE") + "_" + _rs.getString("DESCRIPTION"), _rs.getString("DESCRIPTION")));
                } while (_rs.next());
                earningDeductionCodeList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
            } else {
                earningDeductionCodeList.add(new SelectItem(null, "...NO DATA..."));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return earningDeductionCodeList;

    }
      public static ArrayList<SelectItem> transactionType() {
        ArrayList<SelectItem> type = new ArrayList<SelectItem>();
        type.add(new SelectItem("Earning", "Earning"));
        type.add(new SelectItem("Deduction", "Deduction"));
        return type;
    }
   public static ArrayList<SelectItem> basedOn() {
        ArrayList<SelectItem> base = new ArrayList<SelectItem>();
        base.add(0, new SelectItem(null, "--SELECT--"));
        base.add(new SelectItem("0", "Monthly"));
        base.add(new SelectItem("1", "Yearly"));
        base.add(new SelectItem("2", "Daily"));
        base.add(new SelectItem("3", "LumpSum"));
        return base;
    }

    public static ArrayList<SelectItem> getPayrollGroupList() {
        ArrayList<SelectItem> searchResult = new ArrayList<SelectItem>();
        searchResult.add(new SelectItem(null, "--SELECT--"));
        searchResult.add(new SelectItem("HR-DEPT", "HR-DEPT"));
        searchResult.add(new SelectItem("FINANCE-DEPT", "FINANCE-DEPT"));
        searchResult.add(new SelectItem("TECHNIC-DEPT", "TECHNIC-DEPT"));
        searchResult.add(new SelectItem("MARKETING-DEPT", "MARKETING-DEPT"));
        return searchResult;
    }


    public static ArrayList<SelectItem> getEarningDeductionCodeListWithOutDesc() {
        ArrayList<SelectItem> earningDeductionCodeList = new ArrayList<SelectItem>();
        ResultSet _rs = null;
        EarningDeduction earnDeduct = new EarningDeduction();
        try {
            _rs = earnDeduct.search();
            if (_rs.next()) {
                earningDeductionCodeList.add(new SelectItem(null, "--SELECT--"));
                do {
                    earningDeductionCodeList.add(new SelectItem(_rs.getString("CODE"), _rs.getString("DESCRIPTION")));
                } while (_rs.next());
                earningDeductionCodeList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
            } else {
                earningDeductionCodeList.add(new SelectItem(null, "...NO DATA..."));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return earningDeductionCodeList;

    }
public static ArrayList<SelectItem> getCompEarningDeductionCodeList() {
        ArrayList<SelectItem> earningDeductionCodeList = new ArrayList<SelectItem>();
        ResultSet _rs = null;
        EarningDeduction earnDeduct = new EarningDeduction();
        try {
            _rs = earnDeduct.searchCompED();
            if (_rs.next()) {
                earningDeductionCodeList.add(new SelectItem(null, "--SELECT--"));
                do {
                    earningDeductionCodeList.add(new SelectItem(_rs.getString("CODE") + "_" + _rs.getString("DESCRIPTION"), _rs.getString("DESCRIPTION")));
                } while (_rs.next());
                earningDeductionCodeList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
            } else {
                earningDeductionCodeList.add(new SelectItem(null, "...NO DATA..."));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return earningDeductionCodeList;

    }
public static ArrayList<SelectItem> getCompEarningDeductionCodeListComp() {
        ArrayList<SelectItem> earningDeductionCodeList = new ArrayList<SelectItem>();
        ResultSet _rs = null;
        EarningDeduction earnDeduct = new EarningDeduction();
        try {
            _rs = earnDeduct.searchCompEDComp();
            if (_rs.next()) {
                earningDeductionCodeList.add(new SelectItem(null, "--SELECT--"));
                do {
                    earningDeductionCodeList.add(new SelectItem(_rs.getString("CODE") + "_" + _rs.getString("DESCRIPTION"), _rs.getString("DESCRIPTION")));
                } while (_rs.next());
                earningDeductionCodeList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
            } else {
                earningDeductionCodeList.add(new SelectItem(null, "...NO DATA..."));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return earningDeductionCodeList;

    }
public static ArrayList<SelectItem> getPayrollList() {
        ArrayList<SelectItem> payrollList = new ArrayList<SelectItem>();
        ResultSet _rs = null;
        EarningDeduction earnDeduct = new EarningDeduction();
        try {
            _rs = earnDeduct.searchPayroll();
            if (_rs.next()) {
                payrollList.add(new SelectItem(null, "--SELECT PREVIOUS PAYROLL--"));
                do {
                    payrollList.add(new SelectItem(_rs.getString("PAYROLL_CODE"), _rs.getString("PAYROLL_CODE")));
                } while (_rs.next());
                payrollList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
            } else {
                payrollList.add(new SelectItem(null, "...NO DATA..."));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return payrollList;

    }
    public boolean saveEarningDeduction(String code, String description, String type, String taxable, int category) {
        boolean successful = false;
        EarningDeduction earnDed = new EarningDeduction();
        earnDed.setCode(code);
        earnDed.setDescription(description);
        earnDed.setType(type);
        earnDed.setTaxable(taxable);
        earnDed.setCategory(category);
        try {
            successful = earnDed.save();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }

        return successful;
    }

    public boolean updateEarningDeduction(String code, String description, String type, String taxable, int category) {
        boolean successful = false;
        EarningDeduction earnDed = new EarningDeduction();
        earnDed.setCode(code);
        earnDed.setDescription(description);
        earnDed.setType(type);
        earnDed.setTaxable(taxable);
        earnDed.setCategory(category);
        try {
            successful = earnDed.update();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }

        return successful;
    }

    public boolean deleteEarningDeduction(String code) {
        boolean successful = false;
        EarningDeduction earnDed = new EarningDeduction();
        earnDed.setCode(code);
        try {
            successful = earnDed.delete();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return successful;
    }

    public ArrayList<HashMap> searchEarningDeduction(String code) {
        ArrayList<HashMap> searchResult = new ArrayList<HashMap>();
        ResultSet _rs = null;
        try {
            EarningDeduction earnDed = new EarningDeduction();
            if (code.equals(FMS_Utility.SELECT_ALL)) {
                _rs = earnDed.search();
            } else {
                _rs = earnDed.search(code);
            }
            if (_rs.next()) {
                do {
                    HashMap temp = new HashMap();
                    temp.put("CODE", _rs.getString("CODE"));
                    temp.put("DESCRIPTION", _rs.getString("DESCRIPTION"));
                    temp.put("TYPE", _rs.getString("TYPE"));
                    temp.put("TAXABLE", _rs.getString("TAXABLE"));
                    temp.put("CATEGORY", _rs.getString("CATEGORY"));
                    searchResult.add(temp);
                } while (_rs.next());
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return searchResult;
    }

    public boolean saveEarningDeductionConstant(String code, double value, String startingDate, String endingDate, int dataType) {
        boolean successful = false;
        EarningDeductionConstant earningDeductionConstant = new EarningDeductionConstant();
        try {
            earningDeductionConstant.setCode(code);
            earningDeductionConstant.setEndingDate(endingDate);
            earningDeductionConstant.setStartingDate(startingDate);
            earningDeductionConstant.setValue(value);
            earningDeductionConstant.setDataType(dataType);
            successful = earningDeductionConstant.save();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return successful;
    }

    public boolean updateEarningDeductionConstant(int idNumber, double value, String startingDate, String endingDate) {
        boolean successful = false;
        EarningDeductionConstant earningDeductionConstant = new EarningDeductionConstant();
        try {
            earningDeductionConstant.setIdNumber(idNumber);
            earningDeductionConstant.setEndingDate(endingDate);
            earningDeductionConstant.setStartingDate(startingDate);
            earningDeductionConstant.setValue(value);
            successful = earningDeductionConstant.update();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return successful;
    }

    public boolean deleteEarningDeductionConstant(int idNumber) {
        boolean successful = false;
        EarningDeductionConstant earningDeductionConstant = new EarningDeductionConstant();

        try {
            earningDeductionConstant.setIdNumber(idNumber);
            successful = earningDeductionConstant.delete();
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return successful;
    }

    public HashMap getCurrentEarningDeductionConstant() {
        HashMap currentEarningDeduction = new HashMap();
        EarningDeductionConstant earningDeductionConstant = new EarningDeductionConstant();
        ResultSet _rs = null;
        try {
            _rs = earningDeductionConstant.search();
            if (_rs.next()) {
                currentEarningDeduction.put("BasicSalaryCode", _rs.getString("BASIC_SALARY_CODE"));
                currentEarningDeduction.put("IncomeTaxCode", _rs.getString("INCOME_TAX_CODE"));
                currentEarningDeduction.put("HolidayOvertimeCode", _rs.getString("HOLIDAY_OVERTIME_CODE"));
                currentEarningDeduction.put("SundayOvertimeCode", _rs.getString("SUNDAY_OVERTIME_CODE"));
                currentEarningDeduction.put("WorkingDayOtBeforeEight", _rs.getString("WORKING_DAY_OT_B_EIGHT"));
                currentEarningDeduction.put("WorkingDayOtAfterEight", _rs.getString("WORKING_DAY_OT_A_EIGHT"));
                currentEarningDeduction.put("RecordDate", _rs.getString("RECORD_DATE"));
                currentEarningDeduction.put("SaturdayOvertimeCode", _rs.getString("SATURDAY_OVERTIME_CODE"));
                currentEarningDeduction.put("Milk_Code", _rs.getString("MILK_CODE"));
                currentEarningDeduction.put("Milk_Rate", _rs.getString("MILK_RATE"));
            }
        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return currentEarningDeduction;
    }

    public static ArrayList<SelectItem> isTaxableCodeList() {
        ArrayList<SelectItem> isTaxableList = new ArrayList<SelectItem>();
        isTaxableList.add(new SelectItem(FMS_Utility.YES, "YES"));
        isTaxableList.add(new SelectItem(FMS_Utility.NO, "NO"));
        isTaxableList.add(new SelectItem(FMS_Utility.NOT_APPLICABLE, "N/A"));
        return isTaxableList;
    }

    public static ArrayList<SelectItem> earningDeductionCategory() {
        ArrayList<SelectItem> category = new ArrayList<SelectItem>();
        category.add(new SelectItem(BASED_ON_LUMP_SUM, "LUMP_SUM"));
        category.add(new SelectItem(BASED_ON_PERCENT, "PERCENT"));
        category.add(new SelectItem(BASED_ON_PER_WORKING_DAYS, "WORKING_DAYS"));
        category.add(new SelectItem(BASED_ON_QUOTA, "QUOTA"));
        return category;
    }

    public static ArrayList<SelectItem> getEarningDeductionConstant() {
        ArrayList<SelectItem> codeList = new ArrayList<SelectItem>();
        codeList.add(new SelectItem(null, "--SELECT--"));
        codeList.add(new SelectItem(BASIC_SALARY_TAXABLE_CODE, "BASIC_SALARY_TAXABLE_CODE"));
        codeList.add(new SelectItem(INCOME_TAX_CODE, "INCOME_TAX_CODE"));
        codeList.add(new SelectItem(HOLIDAY_OVERTIME_CODE, "HOLIDAY_OVERTIME_CODE"));
        codeList.add(new SelectItem(SUNDAY_OVERTIME_CODE, "SUNDAY_OVERTIME_CODE"));
        codeList.add(new SelectItem(WORKING_DAY_OT_B_EIGHT, "WORKING_DAY_OT_B_EIGHT"));
        codeList.add(new SelectItem(WORKING_DAY_OT_A_EIGHT, "WORKING_DAY_OT_A_EIGHT"));
        codeList.add(new SelectItem(MILK_CODE, "MILK_CODE"));
        codeList.add(new SelectItem(MILK_RATE, "MILK_RATE"));
        codeList.add(new SelectItem(FUEL_CODE_QUOTA, "FUEL_CODE_QUOTA"));
        codeList.add(new SelectItem(FUEL_RATE, "FUEL_RATE"));
        codeList.add(new SelectItem(ABSENT_CODE, "ABSENT_CODE"));
        codeList.add(new SelectItem(BASIC_SALARY_NON_TAXABLE_CODE, "BASIC_SALARY_NON_TAXABLE_CODE"));
        codeList.add(new SelectItem(TRANSPORT_ALLOWANCE_TAXABLE, "TRANSPORT_ALLOWANCE_TAXABLE"));
        codeList.add(new SelectItem(TRANSPORT_ALLOWANCE_NON_TAXABLE, "TRANSPORT_ALLOWANCE_NON_TAXABLE"));
        codeList.add(new SelectItem(PENSION_CODE, "PENSION_CODE"));
        codeList.add(new SelectItem(PENSION_RATE, "PENSION_RATE"));
        codeList.add(new SelectItem(SAVING_CODE, "SAVING_CODE"));
        codeList.add(new SelectItem(SAVING_RATE_PERCENT, "SAVING_RATE_PERCENT"));
        codeList.add(new SelectItem(SAVING_RATE_CONSTANT, "SAVING_RATE_CONSTANT"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_NT_30_CODE, "HARDSHIP_ALLOWANCE_NT_30_CODE"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_NT_30_RATE, "HARDSHIP_ALLOWANCE_NT_30_RATE"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_NT_10_CODE, "HARDSHIP_ALLOWANCE_NT_10_CODE"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_NT_10_RATE, "HARDSHIP_ALLOWANCE_NT_10_RATE"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_TAXABLE_10_CODE, "HARDSHIP_ALLOWANCE_TAXABLE_10_CODE"));
        codeList.add(new SelectItem(HARDSHIP_ALLOWANCE_TAXABLE_10_RATE, "HARDSHIP_ALLOWANCE_TAXABLE_10_RATE"));
        codeList.add(new SelectItem(COMPENSATION_CODE, "COMPENSATION_CODE"));
        codeList.add(new SelectItem(FMS_Utility.SELECT_ALL, "...ALL..."));
        return codeList;
    }

    public static ArrayList<SelectItem> effectType() {
        ArrayList<SelectItem> type = new ArrayList<SelectItem>();
        type.add(new SelectItem(0, "BEFORE_TAX"));
        type.add(new SelectItem(1, "AFTER_TAX"));
        return type;
    }

    public static ArrayList<SelectItem> dataType() {
        ArrayList<SelectItem> type = new ArrayList<SelectItem>();
        type.add(new SelectItem(1, "RATE"));
        type.add(new SelectItem(0, "CONSTANT"));
        return type;
    }

    public ArrayList<HashMap> searchEarningDeductionConstant(String code) {
        ArrayList<HashMap> searchResult = new ArrayList<HashMap>();
        ResultSet _rs = null;
        try {
            EarningDeductionConstant earnDedConst = new EarningDeductionConstant();
            if (code.equals(FMS_Utility.SELECT_ALL)) {
                _rs = earnDedConst.search();
            } else {
                _rs = earnDedConst.search(code);
            }
            if (_rs.next()) {
                do {
                    HashMap temp = new HashMap();
                    temp.put("CODE", _rs.getString("CODE"));
                    temp.put("COR_VALUE", _rs.getString("COR_VALUE"));
                    temp.put("STARTING_DATE", _rs.getString("STARTING_DATE"));
                    temp.put("ENDING_DATE", _rs.getString("ENDING_DATE"));
                    temp.put("ID", _rs.getString("ID"));
                    temp.put("DATA_TYPE", _rs.getString("DATA_TYPE"));
                    temp.put("ED_DESCRIPTION", _rs.getString("ED_DESCRIPTION"));
                    searchResult.add(temp);
                } while (_rs.next());
            }


        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
        }
        return searchResult;
    }
}
