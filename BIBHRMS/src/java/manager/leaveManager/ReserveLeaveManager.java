/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.leaveManager;

import entity.leaveEntity.ReserveLeave;

import com.sun.webui.jsf.model.Option;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpServletRequest;
import manager.authorizationManager.AuthorizationManager;
import manager.globalUseManager.ErrorLogWriter;
import manager.globalUseManager.GregorianCalendarManipulation;
import manager.globalUseManager.JodanTimeCalender;
import manager.globalUseManager.StringDateManipulation;
import manager.userManagement.SiteSecurityManager;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class ReserveLeaveManager {

    public static final String PROCESS_LEAVE_TRANSFER = AuthorizationManager.PROCESS_LEAVE_TRANSFER;//"8"
    public static final String FINAL_STATE_LEAVE_TRANSFER = AuthorizationManager.readFinalState(PROCESS_LEAVE_TRANSFER);
    public static final String INITIAL_STATE_LEAVE_TRANSFER = AuthorizationManager.readInitialState(PROCESS_LEAVE_TRANSFER);
    public static final String LEAVE_TRANSFER_DECISION_NONE = "-1";
    public static final String LEAVE_TRANSFER_DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    private ReserveLeave reserveLeaveEntity = new ReserveLeave();
    private JodanTimeCalender jodanTimeCalender = new JodanTimeCalender();
    private String userName = "";
    String loggedInEmployeeId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<SelectItem> recommendedYear() {
        ArrayList<SelectItem> listOFRecommendedYear = new ArrayList<SelectItem>();
      //  String dateOftoday = jodanTimeCalender.currentDateFinder();
        String dateOftoday = dateFormat.format(new Date());
        int yearOftoday = StringDateManipulation.getYear(dateOftoday);
        try {
             listOFRecommendedYear.add(new SelectItem(null, "---Select Year----"));
            for (int i = yearOftoday - 13; i <=
                    yearOftoday ; i++) {
                listOFRecommendedYear.add(new SelectItem(Integer.toString(i), Integer.toString(i)));

            }

           
            return listOFRecommendedYear;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    /**
     * the method using employeeid return reserve unused employee leave
     * @param employeeId
     * @return
     */
    public ArrayList<HashMap> readReserveLeave(String employeeId) {
        return reserveLeaveEntity.readReserveLeave(employeeId);
    }

    public boolean saveReserveLeave(ArrayList<HashMap> reserveList, String requestDate) {
        String expiredDate = GregorianCalendarManipulation.addtionGregorianMonth(6);
        return reserveLeaveEntity.saveReserveLeave(
                reserveList,
                requestDate,
                INITIAL_STATE_LEAVE_TRANSFER,
                expiredDate);
    }

    public boolean updatReserveLeave(String leaveYear,
            String avilbelLevelDay,
            String employeeId,
            String leaveId,
            String status,
            String startDate,
            String endDate,
            String remark) {
        try {
            return reserveLeaveEntity.updatReserveLeave(
                    leaveYear,
                    avilbelLevelDay,
                    employeeId,
                    leaveId,
                    status,
                    startDate,
                    endDate,
                    remark  );



        }  catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }

    }

    public boolean deleteReserveLeave(String employeeId, String leaveID) {
        try {
            return reserveLeaveEntity.deleteReserveLeave(employeeId, leaveID);
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }

        return false;
    }

    public ArrayList<SelectItem> selectLeaveTransferRequests(String employeeID) {
        try {
            String status = "";
            int index = 0;
            ArrayList<HashMap> readRequests = reserveLeaveEntity.requestedLeaveTransferLists(employeeID); //recruitmentEntity.newRecruitmentRequests();
            ArrayList<SelectItem> leaveRequest = new ArrayList<SelectItem>();
            if (readRequests != null) {
                leaveRequest.add(new SelectItem(0,
                        "Leave Transfer Requestes"));
                for (HashMap hm : readRequests) {
                    index = hm.get("STATUS").toString().indexOf("-");
                    if (index > 0) {
                        status = hm.get("STATUS").toString().substring(0, index);
                        if (status.equals("Res")) {
                            status = "RESUBMIT";
                        } else if (status.equals("Rej")) {
                            status = "REJECT";
                        } else if (status.equals("App")) {
                            status = "APPROVE";
                        }
                    } else {
                        status = "WAITE";
                    }
                    leaveRequest.add(new SelectItem(String.valueOf(hm.get("REQUEST_DATE")) +
                            "=" + hm.get("STATUS").toString() + "=" + String.valueOf(hm.get("EMP_ID")),
                            String.valueOf(hm.get("REQUEST_DATE").toString()) + "  " + status));
                }

            } else {
                leaveRequest.add(new SelectItem(null,
                        "Leave Transfer Request Not Availabel"));
            }

            return leaveRequest;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public ArrayList<SelectItem> getRequestsToBeProcessed() {
        ArrayList<SelectItem> pendingRequests = new ArrayList<SelectItem>();
        try {
            OracleCachedRowSet _rs = reserveLeaveEntity.selectApprovabLeaveTransferRequest(userName);
        
            while (_rs.next()) {
                
                pendingRequests.add(new SelectItem(_rs.getString("EMP_ID") + "--" +
                        _rs.getString("STATUS") + "--" +
                        _rs.getString("REQUEST_DATE") + "--" +
                        _rs.getString("RESERVELAVEID"),
                        _rs.getString("EMP_ID") + " ON " +
                        _rs.getString("REQUEST_DATE")));
            }
            _rs.close();
            return pendingRequests;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String processState) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName, processState);
        return decisionLists;
    }

    public ArrayList<HashMap> getEmployeeLeaveTransferRequest(String employeeId,
            String leaveRequestStatus,
            String requesedDate) {
        return reserveLeaveEntity.readEmployeeLeaveTransferRequest(employeeId,
                leaveRequestStatus,
                requesedDate);
    }

    public boolean saveleaveLeaveTransferDecision(ArrayList<HashMap> listOfRequest,
            String decision, String currentState) {
        String nextState = AuthorizationManager.readNextState(currentState,
                PROCESS_LEAVE_TRANSFER, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        return reserveLeaveEntity.saveleaveLeaveTransferDecision(
                listOfRequest,
                decision,
                nextState,
                loggedInEmployeeId,
                recorededDateAndTime);
    }

    public ArrayList<HashMap> readEmployeeLeaveTransferRequest(String employeeId, String date, String status) {
        try {
            return reserveLeaveEntity.readEmployeeLeaveTransferRequest(employeeId, status, date);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public ArrayList<HashMap> getLeaveRequestHistory(int requestId) {
        try {
            ResultSet _rs = reserveLeaveEntity.selectProcessedLeaveRequest(requestId);
            ArrayList<HashMap> requestHistoryList = new ArrayList<HashMap>();

            while (_rs.next()) {

                HashMap hm = new HashMap();
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");

                String givenDecision = _rs.getString("PERMISSION_NAME");

                hm.put("deciderEmployeeId", deciderEmployeeId);
                hm.put("deciderFullName", deciderFullName);
                hm.put("givenDecision", givenDecision);
                hm.put("timeStamp", timeStamp);
                hm.put("commentGiven", commentGiven);
                requestHistoryList.add(hm);
            }
            return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public boolean checkLeaveTransferStatus(String employeeId) {
        try {
            return reserveLeaveEntity.checkLeaveTransferStatus(employeeId);
        } catch (Exception e) {
            return true;
        }

    }

    public boolean isRquestBythis(String employeeId, String year) {
        try {
            return reserveLeaveEntity.isRquestBythis(employeeId, year);
        } catch (Exception e) {
            return true;
        }

    }
}