/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.educationManager;

import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.educationEntity.AprovedEduReportEnity;
import manager.ReportCritera.ReportCriteraManager;

/**
 *
 * @author Admin
 */
public class ApprovedEducReportMnager {

    AprovedEduReportEnity reportEntity = new AprovedEduReportEnity();

    public ArrayList<HashMap> getApprovedEduc() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
        //=============================================Monthly=================================
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {
                // OracleCachedRowSet ocrs = reportEntity.readApprovedEduc();
                OracleCachedRowSet ocrs = reportEntity.readApprovedEducMOnthly(ReportCriteraManager.getParametrsForDay());
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
                    resultInfo.put("applied_date", ocrs.getString("applied_date"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    resultInfo.put("start_date", ocrs.getString("start_date"));
                    resultInfo.put("end_date", ocrs.getString("end_date"));
                    resultInfo.put("total_admin_costs", ocrs.getString("total_admin_costs"));
                    resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    resultInfo.put("Total_amount", ocrs.getString("Total_amount"));
                    //resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    IntSuccLists.add(resultInfo);
                }
            // return IntSuccLists;
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
                // OracleCachedRowSet ocrs = reportEntity.readApprovedEduc();
                OracleCachedRowSet ocrs = reportEntity.readApprovedEducQuarterly(ReportCriteraManager.getParametrsForDay());
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
                    resultInfo.put("applied_date", ocrs.getString("applied_date"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    resultInfo.put("start_date", ocrs.getString("start_date"));
                    resultInfo.put("end_date", ocrs.getString("end_date"));
                    resultInfo.put("total_admin_costs", ocrs.getString("total_admin_costs"));
                    resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    resultInfo.put("Total_amount", ocrs.getDouble("Total_amount"));
                    IntSuccLists.add(resultInfo);
                }
            // return IntSuccLists;
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
                // OracleCachedRowSet ocrs = reportEntity.readApprovedEduc();
                OracleCachedRowSet ocrs = reportEntity.readApprovedEducSemiAnnualy(ReportCriteraManager.getParametrsForDay());
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
                    resultInfo.put("applied_date", ocrs.getString("applied_date"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    resultInfo.put("start_date", ocrs.getString("start_date"));
                    resultInfo.put("end_date", ocrs.getString("end_date"));
                    resultInfo.put("total_admin_costs", ocrs.getString("total_admin_costs"));
                    resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    resultInfo.put("Total_amount", ocrs.getDouble("Total_amount"));
                    IntSuccLists.add(resultInfo);
                }
            // return IntSuccLists;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")) {
            try {
                // OracleCachedRowSet ocrs = reportEntity.readApprovedEduc();
                OracleCachedRowSet ocrs = reportEntity.readApprovedEducAnnualy(ReportCriteraManager.getParametrsForDay());
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
                    resultInfo.put("applied_date", ocrs.getString("applied_date"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    resultInfo.put("start_date", ocrs.getString("start_date"));
                    resultInfo.put("end_date", ocrs.getString("end_date"));
                    resultInfo.put("total_admin_costs", ocrs.getString("total_admin_costs"));
                    resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    resultInfo.put("Total_amount", ocrs.getDouble("Total_amount"));
                    IntSuccLists.add(resultInfo);
                }
            // return IntSuccLists;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                }
            }
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")) {
            try {
                OracleCachedRowSet ocrs = reportEntity.readApprovedEducDaily(ReportCriteraManager.getParametrsForDay());
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
                    resultInfo.put("applied_date", ocrs.getString("applied_date"));
                    resultInfo.put("accredited_or_not", ocrs.getString("accredited_or_not"));
                    resultInfo.put("EDUCATION_SHIFT_CATEGORY", ocrs.getString("EDUCATION_SHIFT_CATEGORY"));
                    resultInfo.put("start_date", ocrs.getString("start_date"));
                    resultInfo.put("end_date", ocrs.getString("end_date"));
                    resultInfo.put("total_admin_costs", ocrs.getString("total_admin_costs"));
                    resultInfo.put("document_reference_number", ocrs.getString("document_reference_number"));
                    resultInfo.put("Total_amount", ocrs.getDouble("Total_amount"));
                    IntSuccLists.add(resultInfo);
                }
            // return IntSuccLists;
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
