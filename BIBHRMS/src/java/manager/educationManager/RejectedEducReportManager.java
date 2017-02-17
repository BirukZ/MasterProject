/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.educationManager;
import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.educationEntity.RejectedEducReportEntity;
import manager.ReportCritera.ReportCriteraManager;
/**
 *
 * @author Admin
 */
public class RejectedEducReportManager {
    RejectedEducReportEntity reportEntity = new RejectedEducReportEntity();
public ArrayList<HashMap> getRejectedRequest() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {
                //OracleCachedRowSet ocrs = reportEntity.readRejectedRequest();
                OracleCachedRowSet ocrs = reportEntity.readRejectedRequestMonthly(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("FullName", ocrs.getString("FullName"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("department_path", ocrs.getString("department_path"));
                    resultInfo.put("EducationProgram", ocrs.getString("EducationProgram"));
                    resultInfo.put("description", ocrs.getString("description"));
                    //resultInfo.put("result", ocrs.getString("result"));
                    resultInfo.put("education_program_name", ocrs.getString("education_program_name"));
                    resultInfo.put("education_level_category", ocrs.getString("education_level_category"));
                    resultInfo.put("institution_name", ocrs.getString("institution_name"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    IntSuccLists.add(resultInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly")) {
            try {
                //OracleCachedRowSet ocrs = reportEntity.readRejectedRequest();
                OracleCachedRowSet ocrs = reportEntity.readRejectedRequestQuarterly(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("FullName", ocrs.getString("FullName"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("department_path", ocrs.getString("department_path"));
                    resultInfo.put("EducationProgram", ocrs.getString("EducationProgram"));
                    resultInfo.put("description", ocrs.getString("description"));
                   // resultInfo.put("result", ocrs.getString("result"));
                    resultInfo.put("education_program_name", ocrs.getString("education_program_name"));
                    resultInfo.put("education_level_category", ocrs.getString("education_level_category"));
                    resultInfo.put("institution_name", ocrs.getString("institution_name"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    IntSuccLists.add(resultInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually")) {
            try {
                //OracleCachedRowSet ocrs = reportEntity.readRejectedRequest();
                OracleCachedRowSet ocrs = reportEntity.readRejectedRequestSemiAnnualy(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("FullName", ocrs.getString("FullName"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("department_path", ocrs.getString("department_path"));
                    resultInfo.put("EducationProgram", ocrs.getString("EducationProgram"));
                    resultInfo.put("description", ocrs.getString("description"));
                  //  resultInfo.put("result", ocrs.getString("result"));
                    resultInfo.put("education_program_name", ocrs.getString("education_program_name"));
                    resultInfo.put("education_level_category", ocrs.getString("education_level_category"));
                    resultInfo.put("institution_name", ocrs.getString("institution_name"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    IntSuccLists.add(resultInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        }
        else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")) {
            try {
                //OracleCachedRowSet ocrs = reportEntity.readRejectedRequest();
                OracleCachedRowSet ocrs = reportEntity.readRejectedRequestAnnualy(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("FullName", ocrs.getString("FullName"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("department_path", ocrs.getString("department_path"));
                    resultInfo.put("EducationProgram", ocrs.getString("EducationProgram"));
                    resultInfo.put("description", ocrs.getString("description"));
                  //  resultInfo.put("result", ocrs.getString("result"));
                    resultInfo.put("education_program_name", ocrs.getString("education_program_name"));
                    resultInfo.put("education_level_category", ocrs.getString("education_level_category"));
                    resultInfo.put("institution_name", ocrs.getString("institution_name"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    IntSuccLists.add(resultInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        }
        else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")) {
        try {
                //OracleCachedRowSet ocrs = reportEntity.readRejectedRequest();
                OracleCachedRowSet ocrs = reportEntity.readRejectedRequestDaily(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("FullName", ocrs.getString("FullName"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("department_path", ocrs.getString("department_path"));
                    resultInfo.put("EducationProgram", ocrs.getString("EducationProgram"));
                    resultInfo.put("description", ocrs.getString("description"));
                   // resultInfo.put("result", ocrs.getString("result"));
                    resultInfo.put("education_program_name", ocrs.getString("education_program_name"));
                    resultInfo.put("education_level_category", ocrs.getString("education_level_category"));
                    resultInfo.put("institution_name", ocrs.getString("institution_name"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    IntSuccLists.add(resultInfo);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
    }
            return IntSuccLists;

        }
}
