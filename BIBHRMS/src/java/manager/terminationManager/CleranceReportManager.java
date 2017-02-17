/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import java.util.ArrayList;
import java.util.HashMap;
import entity.terminationEntity.ClearanceReport;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Admin
 */
public class CleranceReportManager {

    ClearanceReport clearanceReport = new ClearanceReport();

    public ArrayList<HashMap> getcleranceReport() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();

        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {

                OracleCachedRowSet ocrs = clearanceReport.readAllClearnceMOnthly(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_name", ocrs.getString("job_name"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                    resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
                    resultInfo.put("final_cleared_date", ocrs.getString("final_cleared_date"));
                    resultInfo.put("clearance_status", ocrs.getString("clearance_status"));

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

                OracleCachedRowSet ocrs = clearanceReport.readAllClearnceQuarterly(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_name", ocrs.getString("job_name"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                    resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
                    resultInfo.put("final_cleared_date", ocrs.getString("final_cleared_date"));
                    resultInfo.put("clearance_status", ocrs.getString("clearance_status"));

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

                OracleCachedRowSet ocrs = clearanceReport.readAllClearnceSemiAnnually(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_name", ocrs.getString("job_name"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                    resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
                    resultInfo.put("final_cleared_date", ocrs.getString("final_cleared_date"));
                    resultInfo.put("clearance_status", ocrs.getString("clearance_status"));

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

                OracleCachedRowSet ocrs = clearanceReport.readAllClearnceAnnually(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_name", ocrs.getString("job_name"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                    resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
                    resultInfo.put("final_cleared_date", ocrs.getString("final_cleared_date"));
                    resultInfo.put("clearance_status", ocrs.getString("clearance_status"));

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

                OracleCachedRowSet ocrs = clearanceReport.readAllClearnceDays(ReportCriteraManager.getParametrsForDay());
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_name", ocrs.getString("job_name"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                    resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
                    resultInfo.put("final_cleared_date", ocrs.getString("final_cleared_date"));
                    resultInfo.put("clearance_status", ocrs.getString("clearance_status"));

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
