/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.ActionPlanEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import manager.educationManager.InstitutionRegistrationManager;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class ActionPlanManager {

    ActionPlanEntity actionPlanEntity = new ActionPlanEntity();
    InstitutionRegistrationManager institutionRegistrationManager;

    public boolean saveActionPlanChanges(int institutionTrainingId, String budgetYear, int institutionId, ArrayList<SelectItem> assignedList, ArrayList<SelectItem> notAssignedList, String onOrOffWork, String startDate, String endDate) {
        try {
            actionPlanEntity.updateActionPlan(budgetYear, institutionId, assignedList, notAssignedList, onOrOffWork, startDate, endDate);
            if (institutionTrainingId == -1) {
                actionPlanEntity.updateActionPlan(budgetYear, institutionId, assignedList, notAssignedList, onOrOffWork, startDate, endDate);
            }
//            else {//if (institutionTrainingId==-1) {
//                actionPlanEntity.updateActionPlan(budgetYear, institutionId, assignedList, notAssignedList);
//            }
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public ArrayList<SelectItem> getApprovedNeedRequests2(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {

            ResultSet _rs = actionPlanEntity.selectApprovedNeedRequests(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }

            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedNeedRequest(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        requestLists.add(new SelectItem("-1", "-- SELECT --"));
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedNeedRequests(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("REQUESTER_ID") + " " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedNeedRequestForDropDown(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        requestLists.add(new SelectItem("-1", "-- SELECT --"));
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedNeedRequests(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("REQUESTER_ID") + " " + _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedTrainingTypes(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        requestLists.add(new SelectItem("-1", "-- SELECT --"));
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedTrainingTypes(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRAINING_ID")+"-"+_rs.getString("TRAINING_NAME"), _rs.getString("TRAINING_NAME"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getAssignedNeedRequests(String budjetYear, int institutionId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = actionPlanEntity.selectAssignedNeedRequests(budjetYear, institutionId);
            if (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedAndAssignedNeedRequests2(String budjetYear, int institutionId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedAndAssignedNeedRequests(budjetYear, institutionId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedAndAssignedNeedRequest(String budjetYear, int institutionId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedAndAssignedNeedRequests(budjetYear, institutionId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRAINING_TYPE_ID"), _rs.getString("TRAININIG_NAME"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getStartDate(String budjetYear, int institutionId, ArrayList<SelectItem> selectedTrainingId) {
        String requestLists = null;
        try {
            ResultSet _rs = actionPlanEntity.selectStartDate(budjetYear, institutionId, selectedTrainingId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TENTATIVE_START_DATE"));
                requestLists = currentRequest.getValue().toString();
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public String getEndDate(String budjetYear, int institutionId, ArrayList<SelectItem> selectedTrainingId) {
        String requestLists = null;
        try {
            ResultSet _rs = actionPlanEntity.selectEndDate(budjetYear, institutionId, selectedTrainingId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TENTATIVE_END_DATE"));
                requestLists = currentRequest.getValue().toString();
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedAndAssignedNeedRequestForDropDown(String budjetYear, int institutionId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        requestLists.add(new SelectItem("-1", "--SELECT--"));
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedAndAssignedNeedRequests(budjetYear, institutionId);
//                    " getApprovedAndAssignedNeedRequestForDropDown(String budjetYear, int institutionId) { ");
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRAINING_TYPE_ID"), _rs.getString("TRAININIG_NAME"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedButNotAssignedNeedRequest(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedAndNotAssignedNeedRequests(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("NEED_ASSESSEMENT_REQUEST_ID"), _rs.getString("APPLIED_DATE"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<SelectItem> getApprovedButNotAssignedNeedRequests(String budjetYear) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = actionPlanEntity.selectApprovedAndNotAssignedNeedRequests(budjetYear);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRAINING_TYPE_ID"), _rs.getString("TRAININIG_NAME"));
                requestLists.add(currentRequest);
            }
            _rs.close();
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
}
