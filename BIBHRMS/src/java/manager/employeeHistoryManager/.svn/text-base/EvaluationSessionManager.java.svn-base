/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeHistoryManager;

import entity.employeeHistoryEntity.EvaluationSession;
import java.util.ArrayList;
import java.util.HashMap;
import com.sun.webui.jsf.model.Option;
import javax.faces.model.SelectItem;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author user
 */
public class EvaluationSessionManager {

    private int evaSessionId;
    private String startDate;
    private String endDate;
    private String start_new_Date;

    public void setEnd_new_Date(String end_new_Date) {
        this.end_new_Date = end_new_Date;
    }

    public void setStart_new_Date(String start_new_Date) {
        this.start_new_Date = start_new_Date;
    }
    private String end_new_Date;

    public String getEnd_new_Date() {
        return end_new_Date;
    }

    public String getStart_new_Date() {
        return start_new_Date;
    }
    private String referenceNo;
    private String referenceDate;
    private String authorizedEmpID;
    private String purpose;
    private boolean selected;
    EvaluationSession evaSessionEntity = new EvaluationSession();
    private Option[] sessionAuthorRequest;

    /**
     * @return the sessionAuthorRequest
     */
    public Option[] getSessionAuthorRequest() {
        return sessionAuthorRequest;
    }

    /**
     * @param sessionAuthorRequest the sessionAuthorRequest to set
     */
    public void setSessionAuthorRequest(Option[] sessionAuthorRequest) {
        this.sessionAuthorRequest = sessionAuthorRequest;
    }

    /**
     * @return the evaId
     */
    public int getEvaSessionId() {
        return evaSessionId;
    }

    /**
     * @param evaId the evaId to set
     */
    public void setEvaSessionId(int evaSessionId) {
        this.evaSessionId = evaSessionId;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate the startDate to set
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate the endDate to set
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the referenceNo
     */
    public String getReferenceNo() {
        return referenceNo;
    }

    /**
     * @param referenceNo the referenceNo to set
     */
    public void setReferenceNo(String referenceNo) {
        this.referenceNo = referenceNo;
    }

    /**
     * @return the referenceDate
     */
    public String getReferenceDate() {
        return referenceDate;
    }

    /**
     * @param referenceDate the referenceDate to set
     */
    public void setReferenceDate(String referenceDate) {
        this.referenceDate = referenceDate;
    }

    /**
     * @return the authorizedEmpID
     */
    public String getAuthorizedEmpID() {
        return authorizedEmpID;
    }

    /**
     * @param authorizedEmpID the authorizedEmpID to set
     */
    public void setAuthorizedEmpID(String authorizedEmpID) {
        this.authorizedEmpID = authorizedEmpID;
    }

    /**
     * @return the purpose
     */
    public String getPurpose() {
        return purpose;
    }

    /**
     * @param purpose the purpose to set
     */
    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    /**
     * @return the selected
     */
    public boolean isSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public EvaluationSessionManager() {
    }

    public EvaluationSessionManager(String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose, String new_start_date, String new_end_date) {
        this.startDate = evaStartDate;
        this.endDate = evaEndDate;
        this.referenceNo = refNo;
        this.referenceDate = refDate;
        this.authorizedEmpID = authorizedEmpID;
        this.purpose = purpose;
        this.start_new_Date = new_start_date;
        this.end_new_Date = new_end_date;
    }

    public EvaluationSessionManager(int evaSessionId, String evaStartDate, String evaEndDate, String refNo, String refDate, String purpose, String authorizedEmpID, String new_start_date, String new_end_date) {
        this.evaSessionId = evaSessionId;
        this.startDate = evaStartDate;
        this.endDate = evaEndDate;
        this.referenceNo = refNo;
        this.referenceDate = refDate;
        this.authorizedEmpID = authorizedEmpID;
        this.purpose = purpose;
        this.start_new_Date = new_start_date;
        this.end_new_Date = new_end_date;
    }

    public int addEvaSessionManager(String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose, String new_start_date, String new_end_date) {
        return evaSessionEntity.addEvaSessionEntity(evaStartDate, evaEndDate, refNo, refDate, authorizedEmpID, purpose, new_start_date, new_end_date);
    }

    /**
    used to count the number of rows that are exist in the requierd table
     */
    public int countEvaSession(String sessionID) {
        return evaSessionEntity.countEvaSession(sessionID);
    }

    public HashMap[] readEvaSessionRenderd(String sessionID) {
        return evaSessionEntity.readEvaSessionRenderd(sessionID);
    }

    public int updateEvaSession(int evaSessionId, String evaStartDate, String evaEndDate, String refNo, String refDate, String authorizedEmpID, String purpose,String new_start_date,String new_end_date) {
        return evaSessionEntity.UpdateEvaSession(evaSessionId, evaStartDate, evaEndDate, refNo, refDate, authorizedEmpID, purpose,new_start_date,new_end_date);
    }

    public int deleteEvaSession(int evaSessionID) {
        return evaSessionEntity.deleteEvaSession(evaSessionID);
    }

    public Option[] loadSessionAuthorizer(String empId) {

        EvaluationSession authorEntity = new EvaluationSession();
        ArrayList<EvaluationSession> evaSessionRequests = this.readSessionAuthor(empId);
        sessionAuthorRequest = new Option[evaSessionRequests.size() + 1];
        Option startedSessionFirst = new Option("0", "-----Session History----");
        sessionAuthorRequest[0] = startedSessionFirst;
        for (int i = 0; i < evaSessionRequests.size(); i++) {
            authorEntity = evaSessionRequests.get(i);
            Option startedSession = new Option(authorEntity.getEvaId(), authorEntity.getPurpose());
            sessionAuthorRequest[i + 1] = startedSession;
        }
        return sessionAuthorRequest;
    }

    public ArrayList<EvaluationSession> readSessionAuthor(String empId) {

        try {

            EvaluationSession evaSessionAuthReq = new EvaluationSession();
            return evaSessionAuthReq.readSessionAuthorizerHistory(empId);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }


    }

    public ArrayList<SelectItem> readEvaSession() {
        try {
            ArrayList<SelectItem> readSession = new ArrayList<SelectItem>();
            ArrayList<EvaluationSession> purposeTypes = evaSessionEntity.readAllSessionPurpose();
            for (int i = 0; i < purposeTypes.size(); i++) {
                evaSessionEntity = purposeTypes.get(i);
                readSession.add(new SelectItem(evaSessionEntity.getPurpID(), evaSessionEntity.getPurpName()));

            }

            return readSession;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Option[] readEvaSessionPurp() {
        try {
            Option[] purposeOpt = null;
            ArrayList<EvaluationSession> purposeTypes = evaSessionEntity.readAllSessionPurpose();
            purposeOpt = new Option[purposeTypes.size() + 1];

            Option purposeOptFirst = new Option("0", "-----Select Purpose----");
            purposeOpt[0] = purposeOptFirst;
            for (int i = 0; i < purposeTypes.size(); i++) {
                evaSessionEntity = purposeTypes.get(i);
                Option optRegionType = new Option(evaSessionEntity.getPurpID(), evaSessionEntity.getPurpName());
                purposeOpt[i + 1] = optRegionType;
            }

            return purposeOpt;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public String readSinglePurpose(int purpID) {
        String strPurpose = evaSessionEntity.readSinglePurpose(purpID);
        return strPurpose;
    }

    public Option[] readManagedSessions(String authorizerID, String purposeID, String empID) {
        Option[] purposeOpt = null;
        ArrayList<EvaluationSession> purposeTypes = null;
        if (empID != null && !empID.equals("")) {
            purposeTypes = evaSessionEntity.readManagedSession(authorizerID, purposeID, empID);
        } else {
            purposeTypes = evaSessionEntity.readManagedSession(authorizerID, purposeID, null);
        }
        purposeOpt = new Option[purposeTypes.size() + 1];
        Option purposeOptFirst = new Option("0", "-----Select Date----");
        purposeOpt[0] = purposeOptFirst;
        for (int i = 0; i < purposeTypes.size(); i++) {
            evaSessionEntity = purposeTypes.get(i);
            Option optRegionType = new Option(evaSessionEntity.getSessionID(), evaSessionEntity.getStartDate() + " --- " + evaSessionEntity.getEndDate());
            purposeOpt[i + 1] = optRegionType;
        }

        return purposeOpt;
    }

    public Option[] readSessionAutorizer(String purposeID, String empID) {
        Option[] purposeOpt = null;
        int i = 0;
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            if (empID != null && !empID.equals("")) {
                data = evaSessionEntity.readSessionAutorizer(purposeID, empID);
            } else {
                data = evaSessionEntity.readSessionAutorizer(purposeID, null);
            }

            purposeOpt = new Option[data.size() + 1];
            Option purposeOptFirst = new Option("0", "-----Select Autorizer----");
            purposeOpt[i] = purposeOptFirst;
            while (data.next()) {
                Option optSessionAuthorizer = new Option(data.getString("AUTHORIZED_EMP_ID"), data.getString("FIRST_NAME") + " " + data.getString("MIDDLE_NAME") + " " + data.getString("LAST_NAME"));
                purposeOpt[i + 1] = optSessionAuthorizer;
                i++;
            }
        } catch (Exception ex) {
        }

        return purposeOpt;
    }

    public Option[] readEvaluatorInfo(String sessionID, String purposeID, String empID) {
        Option[] purposeOpt = null;
        int i = 0;
        try {
            OracleCachedRowSet data = new OracleCachedRowSet();
            if (empID != null && !empID.equals("")) {
                data = evaSessionEntity.readEvaluatorInfo(sessionID, purposeID, empID);
            } else {
                data = evaSessionEntity.readEvaluatorInfo(sessionID, purposeID, null);
            }
            purposeOpt = new Option[data.size() + 1];
            Option purposeOptFirst = new Option("0", "-----Select Evaluator----");
            purposeOpt[i] = purposeOptFirst;
            while (data.next()) {
                Option optSessionAuthorizer = new Option(data.getString("EVALUATOR_ID"), data.getString("FIRST_NAME") + " " + data.getString("MIDDLE_NAME") + " " + data.getString("LAST_NAME"));
                purposeOpt[i + 1] = optSessionAuthorizer;
                i++;
            }
        } catch (Exception ex) {
        }

        return purposeOpt;
    }
}
