/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.benefitManager;

import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.benefitEntity.benefitReport;
import manager.ReportCritera.ReportCriteraManager;

/**
 *
 * @author Admin
 */
public class benefitManager {

    benefitReport benefitReportt = new benefitReport();

    public ArrayList<HashMap> getBenefit() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();

//        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {
                OracleCachedRowSet ocrs = benefitReportt.readAllBenefit();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("benefit_name", ocrs.getString("benefit_name"));
                    resultInfo.put("benefit_value", ocrs.getString("benefit_value"));
                     resultInfo.put("saftey_device", ocrs.getString("saftey_device"));
                    resultInfo.put("monetary", ocrs.getString("monetary"));
                    resultInfo.put("description", ocrs.getString("description"));
                    resultInfo.put("benefit_duration", ocrs.getString("benefit_duration"));
                    resultInfo.put("dep_description", ocrs.getString("dep_description"));
                    resultInfo.put("job_description", ocrs.getString("job_description"));
                    resultInfo.put("type", ocrs.getString("type"));
                    resultInfo.put("quantity", ocrs.getString("quantity"));
                    resultInfo.put("amount_of_birr", ocrs.getString("amount_of_birr"));
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
//        }
//         else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly")) {
//
//            try {
//                OracleCachedRowSet ocrs = benefitReportt.readAllBenefitQuarterly(ReportCriteraManager.getParametrsForDay());
//                while (ocrs.next()) {
//                    HashMap resultInfo = new HashMap();
//                    resultInfo.put("benefit_name", ocrs.getString("benefit_name"));
//                    resultInfo.put("benefit_value", ocrs.getString("benefit_value"));
//                    resultInfo.put("monetary", ocrs.getString("monetary"));
//                    resultInfo.put("description", ocrs.getString("description"));
//                    resultInfo.put("benefit_duration", ocrs.getString("benefit_duration"));
//                    resultInfo.put("dep_description", ocrs.getString("dep_description"));
//                    resultInfo.put("job_description", ocrs.getString("job_description"));
//                    resultInfo.put("type", ocrs.getString("type"));
//                    resultInfo.put("quantity", ocrs.getString("quantity"));
//                    IntSuccLists.add(resultInfo);
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                return null;
//            } finally {
//                try {
//                } catch (Exception ex) {
//                }
//            }
//        }
//       else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually")) {
//            try {
//                OracleCachedRowSet ocrs = benefitReportt.readAllBenefitSemiAnnually(ReportCriteraManager.getParametrsForDay());
//                while (ocrs.next()) {
//                    HashMap resultInfo = new HashMap();
//                    resultInfo.put("benefit_name", ocrs.getString("benefit_name"));
//                    resultInfo.put("benefit_value", ocrs.getString("benefit_value"));
//                    resultInfo.put("monetary", ocrs.getString("monetary"));
//                    resultInfo.put("description", ocrs.getString("description"));
//                    resultInfo.put("benefit_duration", ocrs.getString("benefit_duration"));
//                    resultInfo.put("dep_description", ocrs.getString("dep_description"));
//                    resultInfo.put("job_description", ocrs.getString("job_description"));
//                    resultInfo.put("type", ocrs.getString("type"));
//                    resultInfo.put("quantity", ocrs.getString("quantity"));
//                    IntSuccLists.add(resultInfo);
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                return null;
//            } finally {
//                try {
//                } catch (Exception ex) {
//                }
//            }
//        }
//          else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")) {
//
//            try {
//                OracleCachedRowSet ocrs = benefitReportt.readAllBenefitSemiAnnually(ReportCriteraManager.getParametrsForDay());
//                while (ocrs.next()) {
//                    HashMap resultInfo = new HashMap();
//                    resultInfo.put("benefit_name", ocrs.getString("benefit_name"));
//                    resultInfo.put("benefit_value", ocrs.getString("benefit_value"));
//                    resultInfo.put("monetary", ocrs.getString("monetary"));
//                    resultInfo.put("description", ocrs.getString("description"));
//                    resultInfo.put("benefit_duration", ocrs.getString("benefit_duration"));
//                    resultInfo.put("dep_description", ocrs.getString("dep_description"));
//                    resultInfo.put("job_description", ocrs.getString("job_description"));
//                    resultInfo.put("type", ocrs.getString("type"));
//                    resultInfo.put("quantity", ocrs.getString("quantity"));
//                    IntSuccLists.add(resultInfo);
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                return null;
//            } finally {
//                try {
//                } catch (Exception ex) {
//                }
//            }
//        }
//       else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")) {
//            try {
//                OracleCachedRowSet ocrs = benefitReportt.readAllBenefitDaily(ReportCriteraManager.getParametrsForDay());
//                while (ocrs.next()) {
//                    HashMap resultInfo = new HashMap();
//                    resultInfo.put("benefit_name", ocrs.getString("benefit_name"));
//                    resultInfo.put("benefit_value", ocrs.getString("benefit_value"));
//                    resultInfo.put("monetary", ocrs.getString("monetary"));
//                    resultInfo.put("description", ocrs.getString("description"));
//                    resultInfo.put("benefit_duration", ocrs.getString("benefit_duration"));
//                    resultInfo.put("dep_description", ocrs.getString("dep_description"));
//                    resultInfo.put("job_description", ocrs.getString("job_description"));
//                    resultInfo.put("type", ocrs.getString("type"));
//                    resultInfo.put("quantity", ocrs.getString("quantity"));
//                    IntSuccLists.add(resultInfo);
//                }
//
//            } catch (Exception ex) {
//                ex.printStackTrace();
//                return null;
//            } finally {
//                try {
//                } catch (Exception ex) {
//                }
//            }
//        }
        return IntSuccLists;
    }
}
