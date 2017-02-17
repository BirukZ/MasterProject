/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.reporterManager.employeeProfileReportManager;

import java.io.InputStream;
import entity.reporterEntity.employeeProfileReportEntity.EmployeeProfileReportEntity;
import java.io.File;
import java.io.FileInputStream;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.ReportCritera.ReportCriteraManager;
import manager.globalUseManager.GregorianCalendarManipulation;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class EmployeeProfileReportManager {

    EmployeeProfileReportEntity employeeProfileReportEntity = new EmployeeProfileReportEntity();
    String strLocation = "F:\\ProjectBackUP\\BunnaAfterPresentationBackUp\\FINALBUNNA\\BIBHRMS\\web\\resources\\images\\LOGO_2_1";
    File logoLogcation = new File(strLocation);
    byte[] FPLOGO = null;//variable to hold the image byte information
    byte[] photobinary;//variable to hold the image byte information when a method is called.

    public EmployeeProfileReportManager(byte[] photobinary) {
        this.FPLOGO = photobinary;
    }

    public EmployeeProfileReportManager() {
    }

    public static byte[] extractByteArray(File file) {//read the byte information of the image.
        FileInputStream fileInputStream = null;
        byte[] byteFile = null;
        try {

            int len = 0;
            fileInputStream = new FileInputStream(file);
            InputStream inputStream = fileInputStream;
            len = inputStream.available();
            byteFile = new byte[len];
            inputStream.read(byteFile, 0, len);

        } catch (Exception ex) {
        } finally {
            try {
                fileInputStream.close();
            } catch (Exception ex) {
            }
        }
        return byteFile;
    }

    public ArrayList<HashMap> selectEmployeeProfile() {
        return employeeProfileReportEntity.selectEmployeeProfile();
    }

    public ArrayList<HashMap> selectEmployeeEducationList() {
        return employeeProfileReportEntity.selectEmployeeEducationList();
    }

    public ArrayList<HashMap> selectEmployeeEducationDetileList() {
        return employeeProfileReportEntity.selectEmployeeEducationDetileList(
                ReportCriteraManager.getEmployeeId(),
                ReportCriteraManager.isAllEmployee());
    }

    public ArrayList<HashMap> selectEmployeeTraining() {
        return employeeProfileReportEntity.selectEmployeeTraining();
    }

    public ArrayList<HashMap> selectEmployeeFamily() {
        return employeeProfileReportEntity.selectEmployeeFamily(ReportCriteraManager.getEmployeeId());
    }

    public Collection loadEmployeeInformationForReport(String departmentID, String employeeType, String employeeGender, String sortBY) {

        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        try {
            ResultSet data = null;
            data = employeeProfileReportEntity.loadEmployeeInfoForReport(departmentID, employeeType, employeeGender, sortBY);
            while (data.next()) {
                HashMap hm = new HashMap();
                hm.put("EMPLOYEEID", data.getString("EMP_ID"));
                hm.put("FULLNAME", data.getString("FULLNAME"));
                hm.put("AGE", data.getString("AGE"));
                hm.put("SEX", data.getString("SEX"));
                hm.put("NATION", data.getString("NATIONALITY"));
                hm.put("DATEOFBIRTH", data.getString("DATE_OF_BIRTH"));
                hm.put("HIREDATE", data.getString("HIRE_DATE"));
                hm.put("EDUCATIONLEVEL", data.getString("EDUCATIONLEAVE"));
                hm.put("EDUCATIONTYPE", data.getString("EDUCATIONTYPE"));
                hm.put("RELIGION", data.getString("RELIGION"));        //
                hm.put("MARITAL_STATUS", data.getString("MARITAL_STATUS"));
                hm.put("RETIREMENT_NO", data.getString("RETIREMENT_NO"));
                hm.put("TIN_NUMBER", data.getString("TIN_NUMBER"));
                hm.put("EXPRIANCEINMUGER", data.getString("INSIDEeXPRIANCE"));
                hm.put("OTHEREXPRIANCE", data.getString("INSIDEeXPRIANCE"));
                hm.put("JOBDESCRIPTION", data.getString("JOB_DESCRIPTION"));
                hm.put("RANK", data.getString("RANK_ID"));
                hm.put("SECTION", data.getString("DEP_DESCRIPTION"));
                hm.put("TEAM", data.getString("DEP_DESCRIPTION"));
                hm.put("WORKPLACE", data.getString("DEP_DESCRIPTION"));
                hm.put("INTIALSALARY", data.getString("SALARY"));
                hm.put("CURRENTSALARY", data.getString("SALARY"));


                results.add(hm);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    public ArrayList<SelectItem> employeeRepartSortCriteria() {
        ArrayList<SelectItem> sortCriteria = new ArrayList<SelectItem>();
        // for (int i = 0; i < 3; i++) {

        sortCriteria.add(new SelectItem(String.valueOf("Salary"),
                String.valueOf("Employee Salary")));
        sortCriteria.add(new SelectItem(String.valueOf("ID"),
                String.valueOf("Employee ID")));
        sortCriteria.add(new SelectItem(String.valueOf("Name"),
                String.valueOf("Employee Name")));
        //}

        sortCriteria.add(0, new SelectItem(null, "--Select Sort Criteria--"));
        return sortCriteria;
    }

    
    public List<EmployeeProfileReportManager> loadCompanyLogo() {//load the image information and pass as list object to the interface
        List list = new ArrayList();
        try {
            setFPLOGO(extractByteArray(logoLogcation));
            EmployeeProfileReportManager logo = new EmployeeProfileReportManager(getFPLOGO());
            list.add(logo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return list;
    }

    public byte[] getFPLOGO() {
        return FPLOGO;
    }

    public void setFPLOGO(byte[] FPLOGO) {
        this.FPLOGO = FPLOGO;
    }

    public Collection loadEmployeeExprianceForReport() {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        try {

            ArrayList<HashMap> data = employeeProfileReportEntity.loadEmployeeExprianceReport();
            for (HashMap hm : data) {
                HashMap list = new HashMap();
                list.put("EMPLOYEEID", hm.get("EMP_ID"));
                list.put("FULLNAME", hm.get("FULLNAME"));
                if (hm.get("PRI_OR_GV").equals("Gvt")) {
                    if (hm.get("PER_OR_CON").equals("Perm")) {
                        list.put("OTHEREXPRIANCEGOVPER", "(" + hm.get("START_DATE") + ")-(" + hm.get("END_DATE") + ")");
                        list.put("OTHEREXPRIANCEGOVTOTAL",
                                Integer.toString(GregorianCalendarManipulation.calaculateYearDifference(hm.get("START_DATE").toString(),
                                hm.get("END_DATE").toString())));
                    } else if (hm.get("PER_OR_CON").equals("Cont")) {
                        list.put("OTHEREXPRIANCEGOVCON", "(" + hm.get("START_DATE") + ")-(" + hm.get("END_DATE") + ")");
                        list.put("OTHEREXPRIANCEGOVCONTOTAL", Integer.toString(GregorianCalendarManipulation.calaculateYearDifference(hm.get("START_DATE").toString(),
                                hm.get("END_DATE").toString())));
                    }
                } else if ((hm.get("PRI_OR_GV").equals("Pvt"))) {
                    if (hm.get("PER_OR_CON").equals("Perm")) {
                        list.put("OTHEREXPRIANCEPLCPER", "(" + hm.get("START_DATE") + ")-(" + hm.get("END_DATE") + ")");
                        list.put("OTHEREXPRIANCEPLCTOTAL",
                                Integer.toString(GregorianCalendarManipulation.calaculateYearDifference(hm.get("START_DATE").toString(),
                                hm.get("END_DATE").toString())));
                    } else if (hm.get("PER_OR_CON").equals("Cont")) {
                        list.put("OTHEREXPRIANCEPLCCON", "(" + hm.get("START_DATE") + ")-(" + hm.get("END_DATE") + ")");
                        list.put("OTHEREXPRIANCEPLCCONTOTAL", Integer.toString(GregorianCalendarManipulation.calaculateYearDifference(hm.get("START_DATE").toString(),
                                hm.get("END_DATE").toString())));
                    }
                }

                results.add(list);
            }


//            while (data.next()) {
//                HashMap hm = new HashMap();
//                hm.put("EMPLOYEEID", data.getString("EMP_ID"));
//                hm.put("FULLNAME", data.getString("FULLNAME"));
//                hm.put("AGE", data.getString("AGE"));
//
//                hm.put("SEX", data.getString("SEX"));
//                hm.put("NATION", data.getString("NATIONALITY"));
//                hm.put("DATEOFBIRTH", data.getString("DATE_OF_BIRTH"));
//                hm.put("HIREDATE", data.getString("HIRE_DATE"));
//                hm.put("EDUCATIONLEVEL", data.getString("EDUCATIONLEAVE"));
//                hm.put("EDUCATIONTYPE", data.getString("EDUCATIONTYPE"));
//                hm.put("RELIGION", data.getString("RELIGION"));        //
//                hm.put("MARITAL_STATUS", data.getString("MARITAL_STATUS"));
//                hm.put("RETIREMENT_NO", data.getString("RETIREMENT_NO"));
//                hm.put("TIN_NUMBER", data.getString("TIN_NUMBER"));
//                hm.put("EXPRIANCEINMUGER", data.getString("INSIDEeXPRIANCE"));
//                hm.put("OTHEREXPRIANCE", data.getString("INSIDEeXPRIANCE"));
//                hm.put("JOBDESCRIPTION", data.getString("JOB_DESCRIPTION"));
//                hm.put("RANK", data.getString("RANK_ID"));
//                hm.put("SECTION", data.getString("DEP_DESCRIPTION"));
//                hm.put("TEAM", data.getString("DEP_DESCRIPTION"));
//                hm.put("WORKPLACE", data.getString("DEP_DESCRIPTION"));
//                hm.put("INTIALSALARY", data.getString("SALARY"));
//                hm.put("CURRENTSALARY", data.getString("SALARY"));
//
//
//                results.add(hm);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return results;

    }

    public ArrayList<HashMap> loadEmployeeFamilyInformationForReport(String employeeId) {

        if (employeeId != null) {
            try {

                return employeeProfileReportEntity.readFamilyForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }


    }

    public ArrayList<HashMap> loadEmployeeEducationInformationForReport(String employeeId) {
        if (employeeId != null) {
            try {

                return employeeProfileReportEntity.readEducationForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }


    }

    public ArrayList<HashMap> loadEmployeeAddressInformationForReport(String employeeId) {

        if (employeeId != null) {
            try {

                return employeeProfileReportEntity.readAddressForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }


    }

    public ArrayList<HashMap> loadEmployeeExperianceInformationForReport(String employeeId) {

        if (employeeId != null) {
            try {
                return employeeProfileReportEntity.readExperianceForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }

    }

    public ArrayList<HashMap> loadEmployeeTrainingInformationForReport(String employeeId) {

        if (employeeId != null) {
            try {
                return employeeProfileReportEntity.readTrainingeForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }

    }

    public ArrayList<HashMap> loadEmployeeLanguageInformationForReport(String employeeId) {
        if (employeeId != null) {
            try {
                return employeeProfileReportEntity.readLanguageForReport(employeeId);
            } catch (Exception ex) {
                return null;
            }
        } else {
            return null;
        }
    }

    public Collection readGnderForReport() {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        float value;
        ArrayList<HashMap> list = employeeProfileReportEntity.readGnderForReport();
        for (HashMap hm1 : list) {
            HashMap hm = new HashMap();
            hm.put("sex", hm1.get("SEX"));
            hm.put("sum_sex", Float.parseFloat(hm1.get("COUNTS").toString()));
            value = (Float.parseFloat(hm1.get("COUNTS").toString()) * 100) /
                    Float.parseFloat(hm1.get("TOTAL").toString());
            hm.put("percentage", value);
            results.add(hm);
        }
        return results;
    }

    public Collection readLeaveSceduleForReport() {
        List<HashMap> results = null;
        results = new ArrayList<HashMap>();
        String value[];
        ArrayList<HashMap> list = employeeProfileReportEntity.readEmployeeLeaveScedule();
        for (HashMap hm1 : list) {
            HashMap hm = new HashMap();
           
            hm.put("FULLNAME", hm1.get("FULLNAME"));
            hm.put("SCGEDULE_ID", hm1.get("SCGEDULE_ID"));
            hm.put("EMP_ID", hm1.get("EMP_ID"));
            hm.put("REMARK", hm1.get("REMARK"));
            hm.put("SCHEDULEDATE", hm1.get("SCHEDULEDATE"));
            value = hm1.get("MONTH").toString().split(",");
            for (String s : value) {
                if (s.equalsIgnoreCase("1")) {
                    hm.put("1", Float.parseFloat(s) );
                } else {
                    hm.put("2", 0);
                }
                if (s.equalsIgnoreCase("2")) {
                    hm.put("3",  Float.parseFloat(s) );
                } else {
                    hm.put("4", 0);
                }
                if (s.equalsIgnoreCase("3")) {
                    hm.put("5",  Float.parseFloat(s) );
                } else {
                    hm.put("6", 0);
                }
                if (s.equalsIgnoreCase("4")) {
                    hm.put("7",  Float.parseFloat(s) );
                } else {
                    hm.put("8",0);
                }
                if (s.equalsIgnoreCase("5")) {
                    hm.put("9",  Float.parseFloat(s) );
                } else {
                    hm.put("10", 0);
                }
                if (s.equalsIgnoreCase("6")) {
                    hm.put("11", Float.parseFloat(s) );
                } else {
                    hm.put("12", 0);
                }
                if (s.equalsIgnoreCase("7")) {
                    hm.put("13",  Float.parseFloat(s) );
                } else {
                    hm.put("14", 0);
                }
                if (s.equalsIgnoreCase("8")) {
                    hm.put("15",  Float.parseFloat(s) );
                } else {
                    hm.put("16", 0);
                }
                if (s.equalsIgnoreCase("9")) {
                    hm.put("17", s);
                } else {
                    hm.put("18", 0);
                }
                if (s.equalsIgnoreCase("10")) {
                    hm.put("19",  Float.parseFloat(s) );
                } else {
                    hm.put("20", 0);
                }
                if (s.equalsIgnoreCase("11")) {
                    hm.put("21",  Float.parseFloat(s) );
                } else {
                    hm.put("22", 0);
                }
                if (s.equalsIgnoreCase("12")) {
                    hm.put("23",  Float.parseFloat(s) );
                } else {
                    hm.put("24", 0);
                }
            }
            results.add(hm);
        }
        return results;
    }

  public OracleCachedRowSet getPromoteList(){
      return employeeProfileReportEntity.getPromoteList();
  }
}
