/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.securityGuardManager;

import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.securityGuardEntity.DeciplnEentity;

/**
 *
 * @author Admin
 */
public class DiciplineMnager {

    DeciplnEentity reportEntity = new DeciplnEentity();

    public ArrayList<HashMap> getDisciplineInfo() {
        try {
            ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = reportEntity.readAllDiscipline();
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("Offender_ID", ocrs.getString("OFFENDER_ID"));
                resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                resultInfo.put("approvedDate", ocrs.getString("approvedDate"));

                disciplineReportList.add(resultInfo);
            }
            return disciplineReportList;
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        } finally {
            try {
            } catch (Exception ex) {
            }
        }

    }
}
