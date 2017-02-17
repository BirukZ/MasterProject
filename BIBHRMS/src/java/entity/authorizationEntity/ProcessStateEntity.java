/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.authorizationEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author 
 */
public class ProcessStateEntity extends ConnectionManager{

    private String processStateId;
    private String processId;
    private String processName;
    private String stateName;
    private int sequenceNumbr;
    private String previous_processState_id;
    private String userName;
    private String timeStamp;
    private boolean isFinalState;
    
    String stm, stm1;

    Connection _con = null;
    PreparedStatement _ps = null;
    ResultSet _rs = null;

    public void releaseResources() throws SQLException {
        if (_rs != null) {
            _rs.close();
        }
        if (_ps != null) {
            _ps.close();
        }
        if (_con != null) {
         closePooledConnections(_con);
        }
    }

    public ProcessStateEntity() {
    }

    public ProcessStateEntity(String processStateId, String processId, String processName, String stateName, int sequenceNumbr, String previous_processState_id, String userName, String timeStamp, boolean isFinalState) {
        this.processStateId = processStateId;
        this.processId = processId;
        this.processName = processName;
        this.stateName = stateName;
        this.sequenceNumbr = sequenceNumbr;
        this.previous_processState_id = previous_processState_id;
        this.userName = userName;
        this.timeStamp = timeStamp;
        this.isFinalState = isFinalState;
    }

    /**
     * @return the processStateId
     */
    public String getProcessStateId() {
        return processStateId;
    }

    /**
     * @param processStateId the processStateId to set
     */
    public void setProcessStateId(String processStateId) {
        this.processStateId = processStateId;
    }

    /**
     * @return the processId
     */
    public String getProcessId() {
        return processId;
    }

    /**
     * @param processId the processId to set
     */
    public void setProcessId(String processId) {
        this.processId = processId;
    }

    /**
     * @return the processId
     */
    public String getProcessName() {
        return processName;
    }

    /**
     * @param processId the processId to set
     */
    public void setProcessName(String processName) {
        this.processName = processName;
    }

    /**
     * @return the stateName
     */
    public String getStateName() {
        return stateName;
    }

    /**
     * @param stateName the stateName to set
     */
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    /**
     * @return the sequenceNumbr
     */
    public int getSequenceNumbr() {
        return sequenceNumbr;
    }

    /**
     * @param sequenceNumbr the sequenceNumbr to set
     */
    public void setSequenceNumbr(int sequenceNumbr) {
        this.sequenceNumbr = sequenceNumbr;
    }

    /**
     * @return the previous_processState_id
     */
    public String getPrevious_processState_id() {
        return previous_processState_id;
    }

    /**
     * @param previous_processState_id the previous_processState_id to set
     */
    public void setPrevious_processState_id(String previous_processState_id) {
        this.previous_processState_id = previous_processState_id;
    }

    /**
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the timeStamp
     */
    public String getTimeStamp() {
        return timeStamp;
    }

    /**
     * @param timeStamp the timeStamp to set
     */
    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    /**
     * @return the isFinalState
     */
    public boolean isIsFinalState() {
        return isFinalState;
    }

    /**
     * @param isFinalState the isFinalState to set
     */
    public void setIsFinalState(boolean isFinalState) {
        this.isFinalState = isFinalState;
    }

    public boolean save() {
        boolean myReturn = false;
        stm = "insert into BIB.TBL_PROCESS_STATE (PROCESS_STATE_ID,PROCESS_ID,STATE_NAME,SEQUENCE_NUMBER,PREVIES_PROCESS_STATE_ID,CAN_BE_FINAL) values ( sq_process_state.nextval,?,?,?,?,?)";
        try {
          

           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, this.getProcessId());
           _ps.setString(2, this.getStateName());
           _ps.setInt(3, this.getSequenceNumbr());
           _ps.setString(4, this.getPrevious_processState_id());
           _ps.setString(5, String.valueOf(this.isIsFinalState()));
           _ps.executeUpdate();
            myReturn = true;
        } catch (SQLException ex) {

            myReturn = false;
        }

          finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;

    }

    public boolean saveState(String processId, String stateName,String canItBeFinal) {
        stm = "insert into BIB.TBL_PROCESS_STATE (PROCESS_STATE_ID,PROCESS_ID,STATE_NAME,CAN_BE_FINAL) values ( BIB.TBL_PROCESS_STATE_SEQ.nextval,?,?,?)";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _ps.setString(1, processId);
           _ps.setString(2, stateName);
           _ps.setString(3, canItBeFinal);
           _ps.executeUpdate();
            return true;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }

          finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public boolean update() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<String> readProcessStatsIdList() {
        ArrayList<String> myReturn = new ArrayList<String>();
        //  stm = "select BIB.TBL_PROCESS_STATE.PROCESS_STATE_ID,BIB.TBL_PROCESS_STATE.STATE_NAME,tbl_process.PROCESS_NAME from BIB.TBL_PROCESS_STATE,tbl_process where BIB.TBL_PROCESS_STATE.PROCESS_ID=tbl_process.PROCESS_ID";
        stm = "select PROCESS_STATE_ID,STATE_NAME from BIB.TBL_PROCESS_STATE";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {

                    String returnValue = "";
                    // returnValue =_rs.getString("PROCESS_STATE_ID") + "#" +_rs.getString("PROCESS_NAME") + "-" +_rs.getString("STATE_NAME");
                    returnValue =_rs.getString("PROCESS_STATE_ID") + "#" + "   " + "-" +_rs.getString("STATE_NAME");
                    myReturn.add(returnValue);
                }
            }

        } catch (SQLException ex) {
            myReturn = null;
        }
          finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public ArrayList<String> readPreviosProcessStates(String processId) {
        ArrayList<String> myReturn = new ArrayList<String>();
        //  stm = "select BIB.TBL_PROCESS_STATE.PROCESS_STATE_ID,BIB.TBL_PROCESS_STATE.STATE_NAME,tbl_process.PROCESS_NAME from BIB.TBL_PROCESS_STATE,tbl_process where BIB.TBL_PROCESS_STATE.PROCESS_ID=tbl_process.PROCESS_ID and BIB.TBL_PROCESS_STATE.PROCESS_ID='" + processId + "'";
        stm = "select BIB.TBL_PROCESS_STATE.PROCESS_STATE_ID,BIB.TBL_PROCESS_STATE.STATE_NAME from BIB.TBL_PROCESS_STATE where  BIB.TBL_PROCESS_STATE.PROCESS_ID='" + processId + "'";

        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
           _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    String returnValue = "";
                    returnValue =_rs.getString("PROCESS_STATE_ID") + "#" + processId + "-" +_rs.getString("STATE_NAME");
                    myReturn.add(returnValue);
                }
            }

        } catch (SQLException ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            myReturn = null;
        }

         finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }

    public String getInitialState(String processId) {

        String myReturn = new String();
        String stm = "select PROCESS_STATE_ID from BIB.TBL_PROCESS_STATE where PREVIES_PROCESS_STATE_ID=0 and PROCESS_ID='" + processId + "'";
        try {
           _con = getConnection();
           _ps =_con.prepareStatement(stm);
            _rs =_ps.executeQuery();
            if (_rs == null) {
            } else {
                while (_rs.next()) {
                    myReturn =_rs.getString("PROCESS_STATE_ID");
                }
            }
        } catch (SQLException ex) {
        }

        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return myReturn;
    }
}
