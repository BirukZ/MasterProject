/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.securityGuardManager;

import java.util.ArrayList;
import java.util.HashMap;
import entity.securityGuardEntity.terminatedEntity;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Admin
 */
public class terminatedManger {

    terminatedEntity clearanceReport = new terminatedEntity();

    public ArrayList<HashMap> getcleranceReport() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
      
            try {
                OracleCachedRowSet ocrs = clearanceReport.readAllClearnce();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("emp_id", ocrs.getString("emp_id"));
                    resultInfo.put("ClerName", ocrs.getString("ClerName"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                   // resultInfo.put("salary", ocrs.getString("salary"));
                   // resultInfo.put("rank_description", ocrs.getString("rank_description"));
                    resultInfo.put("department_name", ocrs.getString("department_name"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                   // resultInfo.put("description", ocrs.getString("description"));
                   // resultInfo.put("reqDate", ocrs.getString("reqDate"));
                    resultInfo.put("CLEARED_DATE", ocrs.getString("CLEARED_DATE"));
                   // resultInfo.put("clearance_reason", ocrs.getString("clearance_reason"));
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
       
        return IntSuccLists;
    }
}
