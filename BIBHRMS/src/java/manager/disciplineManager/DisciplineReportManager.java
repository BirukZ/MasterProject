/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import entity.disciplineEntity.ReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import manager.ReportCritera.ReportCriteraManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Biruk
 */
public class DisciplineReportManager {

    ReportEntity reportEntity = new ReportEntity();

    public ArrayList<HashMap> getDisciplineInfo() {
        try {
        ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
            OracleCachedRowSet ocrs = reportEntity.readAllDiscipline();
            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                resultInfo.put("offence_date", ocrs.getString("offence_date"));
                resultInfo.put("offence_name", ocrs.getString("offence_name"));
                resultInfo.put("reported_date", ocrs.getString("reported_date"));
                resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                resultInfo.put("witness_type", ocrs.getString("witness_type"));
                resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
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

    public ArrayList<HashMap> getDisciplineInfoByMonth() {


        ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();

        if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Monthly"))
               {

            try {
             OracleCachedRowSet ocrs = reportEntity.readAllDisciplineByMonth(ReportCriteraManager.getParametrsForDay());
   
                while (ocrs.next())
                {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                    resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                    resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                    resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                    resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                    resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                    resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                    resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                    resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                    resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                    resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                    resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                    resultInfo.put("offence_date", ocrs.getString("offence_date"));
                    resultInfo.put("offence_name", ocrs.getString("offence_name"));
                    resultInfo.put("reported_date", ocrs.getString("reported_date"));
                    resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                    resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                    resultInfo.put("witness_type", ocrs.getString("witness_type"));
                    resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                    resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                    resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                    resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                    resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                    resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                    resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
                    resultInfo.put("approvedDate", ocrs.getString("approvedDate"));
                    disciplineReportList.add(resultInfo);
                }

              } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Quarterly")) {

            try {
                OracleCachedRowSet ocrs = reportEntity.readAllDisciplineByQuarter(ReportCriteraManager.getParametrsForDay());

                //  ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                    resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                    resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                    resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                    resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                    resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                    resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                    resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                    resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                    resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                    resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                    resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                    resultInfo.put("offence_date", ocrs.getString("offence_date"));
                    resultInfo.put("offence_name", ocrs.getString("offence_name"));
                    resultInfo.put("reported_date", ocrs.getString("reported_date"));
                    resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                    resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                    resultInfo.put("witness_type", ocrs.getString("witness_type"));
                    resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                    resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                    resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                    resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                    resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                    resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                    resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
                    resultInfo.put("approvedDate", ocrs.getString("approvedDate"));
                    disciplineReportList.add(resultInfo);
                }

               // return disciplineReportList;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Semiannually")) {


            try {
                OracleCachedRowSet ocrs = reportEntity.readAllDisciplineBySimiannual(ReportCriteraManager.getParametrsForDay());
                //   ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                    resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                    resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                    resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                    resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                    resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                    resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                    resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                    resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                    resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                    resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                    resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                    resultInfo.put("offence_date", ocrs.getString("offence_date"));
                    resultInfo.put("offence_name", ocrs.getString("offence_name"));
                    resultInfo.put("reported_date", ocrs.getString("reported_date"));
                    resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                    resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                    resultInfo.put("witness_type", ocrs.getString("witness_type"));
                    resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                    resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                    resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                    resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                    resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                    resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                    resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
                    resultInfo.put("approvedDate", ocrs.getString("approvedDate"));
                    disciplineReportList.add(resultInfo);
                }

               // return disciplineReportList;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Annually")) {

            try {
                OracleCachedRowSet ocrs = reportEntity.readAllDisciplineByAnnual(ReportCriteraManager.getParametrsForDay());
                //  ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                    resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                    resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                    resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                    resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                    resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                    resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                    resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                    resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                    resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                    resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                    resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                    resultInfo.put("offence_date", ocrs.getString("offence_date"));
                    resultInfo.put("offence_name", ocrs.getString("offence_name"));
                    resultInfo.put("reported_date", ocrs.getString("reported_date"));
                    resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                    resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                    resultInfo.put("witness_type", ocrs.getString("witness_type"));
                    resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                    resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                    resultInfo.put("ForwardToCommittee", ocrs.getString("ForwardToCommittee"));
                    resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                    resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                    resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                    resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
                    resultInfo.put("approvedDate", ocrs.getString("approvedDate"));
                    disciplineReportList.add(resultInfo);
                }

               // return disciplineReportList;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }

        } else if (ReportCriteraManager.getParametrsForDay().get("selectedCodition").toString().equalsIgnoreCase("Daily")) {
           
            try {
                OracleCachedRowSet ocrs = reportEntity.readAllDisciplineByDays(ReportCriteraManager.getParametrsForDay());
                //   ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
                while (ocrs.next()) {
                    HashMap resultInfo = new HashMap();
                    resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                    resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                    resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                    resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                    resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                    resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                    resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                    resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                    resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                    resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                    resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                    resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                    resultInfo.put("offence_date", ocrs.getString("offence_date"));
                    resultInfo.put("offence_name", ocrs.getString("offence_name"));
                    resultInfo.put("reported_date", ocrs.getString("reported_date"));
                    resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                    resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                    resultInfo.put("witness_type", ocrs.getString("witness_type"));
                    resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                    resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                    resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                    resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                    resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                    resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                    resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
                    resultInfo.put("approvedDate", ocrs.getString("approvedDate"));
                    disciplineReportList.add(resultInfo);
                }

               // return disciplineReportList;
            } catch (Exception ex) {
                ex.printStackTrace();
                return null;
            } finally {
                try {
                } catch (Exception ex) {
                    ex.printStackTrace();
                }

            }

        }
        return disciplineReportList;
    }
    //=====================================================================================

    public ArrayList<HashMap> getDisciplineInfoByDays() {
        ArrayList<HashMap> disciplineReportList = new ArrayList<HashMap>();
        try {
            OracleCachedRowSet ocrs = reportEntity.readAllDisciplineByDays(ReportCriteraManager.getParametrsForDay());

            while (ocrs.next()) {
                HashMap resultInfo = new HashMap();
                resultInfo.put("Requester_ID", ocrs.getString("Requester_ID"));
                resultInfo.put("first_name", ocrs.getString("Requester_First_Name"));
                resultInfo.put("middle_name", ocrs.getString("Requester_Middle_Name"));
                resultInfo.put("last_name", ocrs.getString("Requester_Last_Name"));
                resultInfo.put("department_name", ocrs.getString("Requester_Department"));
                resultInfo.put("job_name", ocrs.getString("Requester_Job_Position"));
                resultInfo.put("Offender_ID", ocrs.getString("Offender_ID"));
                resultInfo.put("Offender_First_Name", ocrs.getString("OffenderFirst_Name"));
                resultInfo.put("OffenderMiddle_Name", ocrs.getString("OffenderMiddle_Name"));
                resultInfo.put("OffenderLast_Name", ocrs.getString("OffenderLast_Name"));
                resultInfo.put("Offender_Department", ocrs.getString("Offender_Department"));
                resultInfo.put("Offender_JobTitle", ocrs.getString("Offender_JobTitle"));
                resultInfo.put("offence_date", ocrs.getString("offence_date"));
                resultInfo.put("offence_name", ocrs.getString("offence_name"));
                resultInfo.put("reported_date", ocrs.getString("reported_date"));
                resultInfo.put("description_of_offence", ocrs.getString("description_of_offence"));
                resultInfo.put("OffenderInterst", ocrs.getString("OffenderInterst"));
                resultInfo.put("witness_type", ocrs.getString("witness_type"));
                resultInfo.put("requested_measure_to_be_taken", ocrs.getString("requested_measure_to_be_taken"));
                resultInfo.put("witness_type_other", ocrs.getString("witness_type_other"));
                resultInfo.put("forwarded_to_committee", ocrs.getString("forwarded_to_committee"));
                resultInfo.put("CommentesGiven", ocrs.getString("CommentesGiven"));
                resultInfo.put("approved_penality", ocrs.getString("approved_penality"));
                resultInfo.put("approved_deduct", ocrs.getString("approved_deduct"));
                resultInfo.put("approved_duration", ocrs.getString("approved_duration"));
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
                ex.printStackTrace();
            }
        }

    }

    //=====================================================================================
}
