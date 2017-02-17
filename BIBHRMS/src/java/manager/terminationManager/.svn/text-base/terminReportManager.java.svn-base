/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.terminationManager;

import java.util.ArrayList;
import java.util.HashMap;
import oracle.jdbc.rowset.OracleCachedRowSet;
import entity.terminationEntity.terminReportEntity;
import manager.ReportCritera.ReportCriteraManager;

/**
 *
 * @author Admin
 */
public class terminReportManager {

    terminReportEntity termintEntity = new terminReportEntity();

    public ArrayList<HashMap> getTrmination() {
        ArrayList<HashMap> IntSuccLists = new ArrayList<HashMap>();
        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly")) {
            try {
                OracleCachedRowSet ocrs = termintEntity.readAllTerminationMonthly(ReportCriteraManager.getParametrsForDay());

                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("ReqID", ocrs.getString("ReqID"));
                    resultInfo.put("Requester_Name", ocrs.getString("Requester_Name"));
                    resultInfo.put("Requester_Department", ocrs.getString("Requester_Department"));
                    resultInfo.put("Requester_JobTitle", ocrs.getString("Requester_JobTitle"));
                    resultInfo.put("TermID", ocrs.getString("TermID"));
                    resultInfo.put("requester_appdate", ocrs.getString("requester_appdate"));
                    resultInfo.put("Terminator_Name", ocrs.getString("Terminator_Name"));
                    resultInfo.put("Terminator_JobTitle", ocrs.getString("Terminator_JobTitle"));
                    resultInfo.put("Terminator_Department", ocrs.getString("Terminator_Department"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("terminatr_appdate", ocrs.getString("terminatr_appdate"));
                    resultInfo.put("terminationDate", ocrs.getString("terminationDate"));
                    resultInfo.put("penality_payment", ocrs.getString("penality_payment"));
                    resultInfo.put("termination_catagory", ocrs.getString("termination_catagory"));
                    resultInfo.put("termination_type", ocrs.getString("termination_type"));
                    resultInfo.put("request_status", ocrs.getString("request_status"));
                    resultInfo.put("approver_id", ocrs.getString("approver_id"));
                    resultInfo.put("Approver_Last_Name", ocrs.getString("Approver_Last_Name"));
                    resultInfo.put("Approver_Department", ocrs.getString("Approver_Department"));
                    resultInfo.put("decision", ocrs.getString("decision"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("ApprovedDate", ocrs.getString("ApprovedDate"));
                    IntSuccLists.add(resultInfo);
                }
                return IntSuccLists;
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
                OracleCachedRowSet ocrs = termintEntity.readAllTerminationQuarterly(ReportCriteraManager.getParametrsForDay());

                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("ReqID", ocrs.getString("ReqID"));
                    resultInfo.put("Requester_Name", ocrs.getString("Requester_Name"));
                    resultInfo.put("Requester_Department", ocrs.getString("Requester_Department"));
                    resultInfo.put("Requester_JobTitle", ocrs.getString("Requester_JobTitle"));
                    resultInfo.put("Terminator_Department", ocrs.getString("Terminator_Department"));
                    resultInfo.put("TermID", ocrs.getString("TermID"));
                    resultInfo.put("requester_appdate", ocrs.getString("requester_appdate"));
                    resultInfo.put("Terminator_Name", ocrs.getString("Terminator_Name"));
                    resultInfo.put("Terminator_JobTitle", ocrs.getString("Terminator_JobTitle"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("terminatr_appdate", ocrs.getString("terminatr_appdate"));
                    resultInfo.put("terminationDate", ocrs.getString("terminationDate"));
                    resultInfo.put("penality_payment", ocrs.getString("penality_payment"));
                    resultInfo.put("termination_catagory", ocrs.getString("termination_catagory"));
                    resultInfo.put("termination_type", ocrs.getString("termination_type"));
                    resultInfo.put("request_status", ocrs.getString("request_status"));
                    resultInfo.put("approver_id", ocrs.getString("approver_id"));
                    resultInfo.put("Approver_Last_Name", ocrs.getString("Approver_Last_Name"));
                    resultInfo.put("Approver_Department", ocrs.getString("Approver_Department"));
                    resultInfo.put("decision", ocrs.getString("decision"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("ApprovedDate", ocrs.getString("ApprovedDate"));
                    IntSuccLists.add(resultInfo);
                }
                return IntSuccLists;
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
                OracleCachedRowSet ocrs = termintEntity.readAllTerminationSemiAnnualy(ReportCriteraManager.getParametrsForDay());

                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("ReqID", ocrs.getString("ReqID"));
                    resultInfo.put("Requester_Name", ocrs.getString("Requester_Name"));
                    resultInfo.put("Requester_Department", ocrs.getString("Requester_Department"));
                     resultInfo.put("Terminator_Department", ocrs.getString("Terminator_Department"));
                    resultInfo.put("Requester_JobTitle", ocrs.getString("Requester_JobTitle"));
                    resultInfo.put("TermID", ocrs.getString("TermID"));
                    resultInfo.put("requester_appdate", ocrs.getString("requester_appdate"));
                    resultInfo.put("Terminator_Name", ocrs.getString("Terminator_Name"));
                    resultInfo.put("Terminator_JobTitle", ocrs.getString("Terminator_JobTitle"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("terminatr_appdate", ocrs.getString("terminatr_appdate"));
                    resultInfo.put("terminationDate", ocrs.getString("terminationDate"));
                    resultInfo.put("penality_payment", ocrs.getString("penality_payment"));
                    resultInfo.put("termination_catagory", ocrs.getString("termination_catagory"));
                    resultInfo.put("termination_type", ocrs.getString("termination_type"));
                    resultInfo.put("request_status", ocrs.getString("request_status"));
                    resultInfo.put("approver_id", ocrs.getString("approver_id"));
                    resultInfo.put("Approver_Last_Name", ocrs.getString("Approver_Last_Name"));
                    resultInfo.put("Approver_Department", ocrs.getString("Approver_Department"));
                    resultInfo.put("decision", ocrs.getString("decision"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("ApprovedDate", ocrs.getString("ApprovedDate"));
                    IntSuccLists.add(resultInfo);
                }
                return IntSuccLists;
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
                OracleCachedRowSet ocrs = termintEntity.readAllTerminationAnnualy(ReportCriteraManager.getParametrsForDay());

                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("ReqID", ocrs.getString("ReqID"));
                    resultInfo.put("Requester_Name", ocrs.getString("Requester_Name"));
                    resultInfo.put("Requester_Department", ocrs.getString("Requester_Department"));
                    resultInfo.put("Terminator_Department", ocrs.getString("Terminator_Department"));
                    resultInfo.put("Requester_JobTitle", ocrs.getString("Requester_JobTitle"));
                    resultInfo.put("TermID", ocrs.getString("TermID"));
                    resultInfo.put("requester_appdate", ocrs.getString("requester_appdate"));
                    resultInfo.put("Terminator_Name", ocrs.getString("Terminator_Name"));
                    resultInfo.put("Terminator_JobTitle", ocrs.getString("Terminator_JobTitle"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("terminatr_appdate", ocrs.getString("terminatr_appdate"));
                    resultInfo.put("terminationDate", ocrs.getString("terminationDate"));
                    resultInfo.put("penality_payment", ocrs.getString("penality_payment"));
                    resultInfo.put("termination_catagory", ocrs.getString("termination_catagory"));
                    resultInfo.put("termination_type", ocrs.getString("termination_type"));
                    resultInfo.put("request_status", ocrs.getString("request_status"));
                    resultInfo.put("approver_id", ocrs.getString("approver_id"));
                    resultInfo.put("Approver_Last_Name", ocrs.getString("Approver_Last_Name"));
                    resultInfo.put("Approver_Department", ocrs.getString("Approver_Department"));
                    resultInfo.put("decision", ocrs.getString("decision"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("ApprovedDate", ocrs.getString("ApprovedDate"));
                    IntSuccLists.add(resultInfo);
                }
                return IntSuccLists;
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
                OracleCachedRowSet ocrs = termintEntity.readAllTerminationDaily(ReportCriteraManager.getParametrsForDay());

                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("ReqID", ocrs.getString("ReqID"));
                    resultInfo.put("Requester_Name", ocrs.getString("Requester_Name"));
                    resultInfo.put("Requester_Department", ocrs.getString("Requester_Department"));
                    resultInfo.put("Requester_JobTitle", ocrs.getString("Requester_JobTitle"));
                    resultInfo.put("TermID", ocrs.getString("TermID"));
                    resultInfo.put("requester_appdate", ocrs.getString("requester_appdate"));
                    resultInfo.put("Terminator_Name", ocrs.getString("Terminator_Name"));
                    resultInfo.put("Terminator_Department", ocrs.getString("Terminator_Department"));
                    resultInfo.put("Terminator_JobTitle", ocrs.getString("Terminator_JobTitle"));
                    resultInfo.put("sex", ocrs.getString("sex"));
                    resultInfo.put("AGE", ocrs.getString("AGE"));
                    resultInfo.put("salary", ocrs.getString("salary"));
                    resultInfo.put("hire_date", ocrs.getString("hire_date"));
                    resultInfo.put("terminatr_appdate", ocrs.getString("terminatr_appdate"));
                    resultInfo.put("terminationDate", ocrs.getString("terminationDate"));
                    resultInfo.put("penality_payment", ocrs.getString("penality_payment"));
                    resultInfo.put("termination_catagory", ocrs.getString("termination_catagory"));
                    resultInfo.put("termination_type", ocrs.getString("termination_type"));
                    resultInfo.put("request_status", ocrs.getString("request_status"));
                    resultInfo.put("approver_id", ocrs.getString("approver_id"));
                    resultInfo.put("Approver_Last_Name", ocrs.getString("Approver_Last_Name"));
                    resultInfo.put("Approver_Department", ocrs.getString("Approver_Department"));
                    resultInfo.put("decision", ocrs.getString("decision"));
                    resultInfo.put("comment_given", ocrs.getString("comment_given"));
                    resultInfo.put("ApprovedDate", ocrs.getString("ApprovedDate"));
                    IntSuccLists.add(resultInfo);
                }
                return IntSuccLists;
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
