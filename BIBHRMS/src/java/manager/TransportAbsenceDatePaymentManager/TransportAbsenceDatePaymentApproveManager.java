/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.TransportAbsenceDatePaymentManager;

import entity.TransportAbsenceDatePaymentEntity.TransportAbsenceDatePaymentApproveEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import com.sun.webui.jsf.model.Option;
import java.sql.Timestamp;
import java.util.Date;
import manager.authorizationManager.AuthorizationManager;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.globalUseManager.ErrorLogWriter;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author Henok
 */
public class TransportAbsenceDatePaymentApproveManager {

    public static final String DECISION_APPROVE = SiteSecurityManager.Permission_Approve;
    public static final String DECISION_FORWARD = SiteSecurityManager.Permission_Forward;
    public static final String DECISION_RESUBMIT = SiteSecurityManager.Permission_Resubmit;
    public static final String DECISION_REJECT = SiteSecurityManager.Permission_Reject;
    public static final String DECISION_NONE = "-1";
    public static final String PROCESS_REQUEST_TRANSPORT_PAYMENT = AuthorizationManager.REQUEST_TRANSPORT_PAYMENT;//"8"
    public static final String INITIAL_STATE_TRANSPORT_PAYMENT = AuthorizationManager.readInitialState(PROCESS_REQUEST_TRANSPORT_PAYMENT);
    TransportAbsenceDatePaymentApproveEntity TransportAbsenceDatePaymentApproveEntity = new TransportAbsenceDatePaymentApproveEntity();
    private TransportPaymentsModel transportAbsenceDatePaymentModel;
    String userName = "";


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public ArrayList<RequestHistoryModel> getRequestHistory(int requestId) {
        try {
            ResultSet _rs = TransportAbsenceDatePaymentApproveEntity.selectProcessedTransportPaymentRequest(requestId);
            ArrayList<RequestHistoryModel> requestHistoryList = new ArrayList<RequestHistoryModel>();
            int counter = 0;
            while (_rs.next()) {

                counter++;
                String deciderEmployeeId = _rs.getString("PROCESSED_BY");
                String recorderEmployeeId = _rs.getString("RECORDED_BY_ID");
                String deciderFullName = _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME");
                if (!deciderEmployeeId.equals(recorderEmployeeId)) {//
                    deciderFullName = deciderFullName + " (Rec. by " + recorderEmployeeId + ")";
                }
                String timeStamp = _rs.getString("TIME_STAMP").substring(0, 10);
                String commentGiven = _rs.getString("COMMENT_GIVEN") == null ? "No comment given." : _rs.getString("COMMENT_GIVEN");
                String givenDecision = _rs.getString("PERMISSION_NAME");
                requestHistoryList.add(new RequestHistoryModel(counter, deciderEmployeeId, deciderFullName, givenDecision, timeStamp, commentGiven));
            }
           return requestHistoryList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    public ArrayList<SelectItem> getPendingRequests(String loggedInEmployeeId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = TransportAbsenceDatePaymentApproveEntity.selectPendingRequests(loggedInEmployeeId);
            while (_rs.next()) {
                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE"));
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

    public ArrayList<SelectItem> getMyRequestsHistory(String loggedInEmployeeId) {
        ArrayList<SelectItem> requestLists = new ArrayList<SelectItem>();
        try {
            ResultSet _rs = TransportAbsenceDatePaymentApproveEntity.selectMyRequestsHistory(loggedInEmployeeId);
            while (_rs.next()) {
//                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE")+ " - " + _rs.getString("REQUEST_STATUS"));
                SelectItem currentRequest = new SelectItem(_rs.getString("TRANSPORT_PAYMENT_REQUEST_ID") + "--" + _rs.getString("REQUESTER_ID") + "--" + _rs.getString("REQUEST_STATUS"), _rs.getString("REQUESTER_ID") + " ON " + _rs.getString("REQUEST_DATE"));
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

    public ArrayList<TransportPaymentsModel> getEmployeeAndTransportPaymentList(int transportPaymentRequestId) {
        ArrayList<TransportPaymentsModel> requestLists = new ArrayList<TransportPaymentsModel>();
        try {
            ResultSet _rs = TransportAbsenceDatePaymentApproveEntity.selectEmployeeAndTransportPaymentList(transportPaymentRequestId);
            while (_rs.next()) {
                transportAbsenceDatePaymentModel = new TransportPaymentsModel();
                transportAbsenceDatePaymentModel.setTransportPaymentId(_rs.getInt("TRANSPORT_PAYMENT_EMP_ID"));
                transportAbsenceDatePaymentModel.setActualLocation(_rs.getString("SERVICE_DESTINATION"));
                transportAbsenceDatePaymentModel.setEmployeeId(_rs.getString("EMPLOYEE_ID"));
                transportAbsenceDatePaymentModel.setEmployeeName(_rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                transportAbsenceDatePaymentModel.setServiceAbsenteDate(_rs.getDouble("S_ABSENT_DATE"));
                transportAbsenceDatePaymentModel.setEmployeeAbsenteDate(_rs.getDouble("E_ABSENT_DATE"));
                transportAbsenceDatePaymentModel.setTarifPerDay(_rs.getDouble("TARIF_PER_DAY"));
                transportAbsenceDatePaymentModel.setPaymentForSAbsence(_rs.getDouble("PAYMENT_FOR_S_ABSENT"));
                transportAbsenceDatePaymentModel.setDaysInMonth(_rs.getInt("DAYS_IN_MONTH"));
                transportAbsenceDatePaymentModel.setTotalEAbsenteDays(_rs.getInt("TOTAL_E_ABSENT_DAYS"));
                transportAbsenceDatePaymentModel.setExtraPaymentPerDay(_rs.getDouble("EXTRA_PAYMENT_PER_DAY"));
                transportAbsenceDatePaymentModel.setPaymentForNoTransport(_rs.getDouble("TOTAL_EXTRA_PAYMENT"));
                transportAbsenceDatePaymentModel.setTotalPayment(_rs.getDouble("TOTAL_PAYMENT"));
                requestLists.add(transportAbsenceDatePaymentModel);
            }
            return requestLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public TransportPaymentsModel getRequestAttributes(int transportPaymentRequestId) {
        transportAbsenceDatePaymentModel = new TransportPaymentsModel();
        try {
            ResultSet _rs = TransportAbsenceDatePaymentApproveEntity.selectRequestAttributes(transportPaymentRequestId);
            if (_rs.next()) {
                transportAbsenceDatePaymentModel.setTransportPaymentId(_rs.getInt("TRANSPORT_PAYMENT_REQUEST_ID"));
                transportAbsenceDatePaymentModel.setRequestDate(_rs.getString("REQUEST_DATE"));
                transportAbsenceDatePaymentModel.setStartDate(_rs.getString("START_DATE"));
                transportAbsenceDatePaymentModel.setEndDate(_rs.getString("END_DATE"));
            } else {
                transportAbsenceDatePaymentModel.setTransportPaymentId(-1);
            }
            return transportAbsenceDatePaymentModel;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String processState, String un) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), un, processState);
        return decisionLists;
    }

    public boolean saveDecision(int requestId, String processedBy, String decision, String currentState, String commentGiven, ArrayList<TransportPaymentsModel> requestModelList, String startDate, String endDate, String un) {
        String nextState = AuthorizationManager.readNextState(currentState, PROCESS_REQUEST_TRANSPORT_PAYMENT, decision);
        String recorededDateAndTime = new Timestamp((new Date()).getTime()).toString();
        try {
            TransportPaymentsModel descisionModel = new TransportPaymentsModel(requestId, processedBy, decision, nextState, commentGiven, un, recorededDateAndTime);
            if (TransportAbsenceDatePaymentApproveEntity.insertDecision(descisionModel,startDate,endDate)) {//if successful
//                TransportAbsenceDatePaymentApproveEntity.updateSelectedEmployeeStatus(requestModelList);
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
}
