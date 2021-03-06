/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.PenaltyRegistrationEntity;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Mekete VS BravoZulu
 */
public class PenaltyRegistrationManager {

    PenaltyRegistrationEntity disciplineRegistrationEntity = new PenaltyRegistrationEntity();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static final String EMPLOYEE = "EM";
    public static final String MANAGER = "MN";

    public ArrayList<Option> getDeciderTypes() {
        ArrayList<Option> deciderList = new ArrayList<Option>();
        deciderList.add(new Option(-1, "--SELECT DECIDER--"));
        deciderList.add(new Option(1, "Immediate Boss "));
        deciderList.add(new Option(2, "HR Manager"));
         deciderList.add(new Option(3, "Discipline Committee "));
      //  deciderList.add(new Option(4, "Corporate Manager"));

        return deciderList;
    }

    public ArrayList<Option> getForWhomDecide() {
        ArrayList<Option> ForWhomDecide = new ArrayList<Option>();
        ForWhomDecide.add(new Option(0, "--SELECT DECID--"));
        ForWhomDecide.add(new Option(1, "Managers"));
        ForWhomDecide.add(new Option(2, "Employee"));
        return ForWhomDecide;
    }
     public ArrayList<Option> getPenalityFor() {
        ArrayList<Option> penalityFor=new ArrayList<Option>();
        penalityFor.add(new Option(-1, "---SELECT TYPE---"));
        penalityFor.add(new Option(1, "Top Mgr"));
        penalityFor.add(new Option(2, "Employee"));
        return penalityFor;
    }
    /*   public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetail() {

    ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
    try {
    ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetail();
    int counter = 0;
    while (_rs.next()) {

    DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
    currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
    currentdesciplineType.setCounter(++counter);
    currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
    currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
    currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
    currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
    currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
    currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
    currentdesciplineType.setStatus("Old");  //
    currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
    desciplineTypes.add(currentdesciplineType);
    }
    _rs.close();
    return desciplineTypes;
    } catch (Exception ex) {
    ex.printStackTrace();
    ErrorLogWriter.writeError(ex);
    return null;
    }
    }
     */

    public ArrayList<PenaltyTypeModel> getAllPenaltyTypes() {
        ArrayList<PenaltyTypeModel> penaltyTypes = new ArrayList<PenaltyTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyType();
            int counter = 0;
            while (_rs.next()) {
                PenaltyTypeModel currentPenaltyType = new PenaltyTypeModel();
                currentPenaltyType.setCounter(++counter);
                currentPenaltyType.setPenaltyTypeId(_rs.getInt("PENALTY_TYPE_ID"));//
                currentPenaltyType.setPenaltyDescription(_rs.getString("DESCRIPTION"));
                currentPenaltyType.setPenaltyName(_rs.getString("PENALTY_NAME"));//
                currentPenaltyType.setPenaltyTypeCode(_rs.getString("PENALTY_CODE"));//
                currentPenaltyType.setNumberOfPenalisedDays(_rs.getInt("MONETARY_PENALTY_DAYS"));
                currentPenaltyType.setPenalityFor(_rs.getString("PENALITY_FOR"));//
                currentPenaltyType.setActionTaker(_rs.getString("ACTION_TAKER"));//
                currentPenaltyType.setActionTaken(_rs.getString("ACTION_TAKEN"));
                currentPenaltyType.setDeductionDuration(Integer.parseInt(_rs.getString("DEDUCTION_DURATION")));
                currentPenaltyType.setStatus("Old");  //
                penaltyTypes.add(currentPenaltyType);
            }
            _rs.close();
            return penaltyTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

     public ArrayList<ManagerPenality> getAllManagerPenaltyTypes() {
        ArrayList<ManagerPenality> penaltyTypes = new ArrayList<ManagerPenality>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllManagementPenaltyType();
            int counter = 0;
            while (_rs.next()) {
                ManagerPenality currentPenaltyType = new ManagerPenality();
                currentPenaltyType.setCounter(++counter);
                currentPenaltyType.setPenaltyTypeId(_rs.getInt("PENALTY_TYPE_ID"));//
                currentPenaltyType.setPenaltyDescription(_rs.getString("DESCRIPTION"));
                currentPenaltyType.setPenaltyName(_rs.getString("PENALTY_NAME"));//
                currentPenaltyType.setPenaltyTypeCode(_rs.getString("PENALTY_CODE"));//
                currentPenaltyType.setNumberOfPenalisedDays(_rs.getInt("MONETARY_PENALTY_DAYS"));
                currentPenaltyType.setPenalityFor(_rs.getString("PENALITY_FOR"));//
                currentPenaltyType.setActionTaker(_rs.getString("ACTION_TAKER"));//
                currentPenaltyType.setActionTaken(_rs.getString("ACTION_TAKEN"));
                currentPenaltyType.setDeductionDuration(Integer.parseInt(_rs.getString("DEDUCTION_DURATION")));
                currentPenaltyType.setStatus("Old");  //
                penaltyTypes.add(currentPenaltyType);
            }
            _rs.close();
            return penaltyTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<Option> getAllPenaltyTypesOption() {
        ArrayList<Option> penaltyTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyType();
            while (_rs.next()) {
                //penaltyTypes.add(new Option(_rs.getInt("PENALTY_TYPE_ID") + "--" + _rs.getString("PENALTY_NAME") + "--" + "DECIDER FILLED", _rs.getString("PENALTY_CODE") + " : " + _rs.getString("PENALTY_NAME")) +" : "+_rs.getString("") );
                penaltyTypes.add(new Option(_rs.getInt("PENALTY_TYPE_ID")+ "--" +_rs.getString("PENALTY_NAME")+ "--" +_rs.getString("PENALTY_CODE")+ "--" +_rs.getString("ACTION_TAKER"),_rs.getString("PENALTY_CODE") + " : " + _rs.getString("PENALTY_NAME") + " : "+_rs.getString("PENALITY_FOR")));
            }
            if (penaltyTypes.size() == 0) {
                penaltyTypes.add(new Option("-1", "NO PENALTY TYPE"));
            } else {
                penaltyTypes.add(0, new Option("-1", "SELECT PENALTY TYPE"));
            }
            _rs.close();
            return penaltyTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }
    //====================================================PenalityListOptionForManager==============================================================
     public ArrayList<Option> getAllPenaltyTypesOptionForManager() {
        ArrayList<Option> penaltyTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllManagementPenaltyType();
            while (_rs.next()) {
                 penaltyTypes.add(new Option(_rs.getString("PENALTY_CODE")+ "--" +_rs.getString("PENALTY_NAME")+"--"+_rs.getString("ACTION_TAKER"),_rs.getString("PENALTY_CODE") +"--"+ _rs.getString("PENALTY_NAME")));
                

              //penaltyTypes.add(new Option(_rs.getString("PENALTY_NAME")+ "--" +_rs.getInt("PENALTY_TYPE_ID")+ "--" +_rs.getInt("ACTION_TAKER"), _rs.getString("PENALTY_CODE") + "--" + _rs.getString("PENALTY_NAME")));
             //penaltyTypes.add(new Option(_rs.getInt("PENALTY_TYPE_ID")+ "--" +_rs.getString("PENALTY_NAME")+ "--" +"DECIDER FILLED",_rs.getString("PENALTY_CODE") + " : " + _rs.getString("PENALTY_NAME") + " : "+_rs.getString("PENALITY_FOR")));
            }
            if (penaltyTypes.size() == 0) {
                penaltyTypes.add(new Option("-1", "NO PENALTY TYPE"));
            } else {
                penaltyTypes.add(0, new Option("-1", "SELECT PENALTY TYPE"));
            }
            _rs.close();
            return penaltyTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

    //==============================================================================================================================================

    public ArrayList<Option> getPenaltyTypesOption() {
        ArrayList<Option> penaltyTypes = new ArrayList<Option>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyType();
            while (_rs.next()) {
                penaltyTypes.add(new Option(_rs.getString("PENALTY_NAME")+"-"+_rs.getInt("PENALTY_TYPE_ID"), _rs.getString("PENALTY_TYPE_ID") + " - " + _rs.getString("PENALTY_NAME")));
            }
            if (penaltyTypes.size() == 0) {
                penaltyTypes.add(new Option("-1", "NO PENALTY TYPE"));
            } else {
                penaltyTypes.add(0, new Option("-1", "SELECT PENALTY TYPE"));
            }
            _rs.close();
            return penaltyTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }

    }

     public PenaltyTypeModel getPenalityType(int penalityID)
           {
   
    PenaltyTypeModel penalityTypes = new PenaltyTypeModel();
            try {
    ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypes(penalityID);

    while (_rs.next()) {

   
    penalityTypes.setPenaltyTypeId(_rs.getInt("PENALTY_TYPE_ID"));
    penalityTypes.setPenaltyName(_rs.getString("PENALTY_NAME"));
    penalityTypes.setPenaltyDescription(_rs.getString("DESCRIPTION"));
    penalityTypes.setPenalityFor(_rs.getString("PENALITY_FOR"));//
    penalityTypes.setNumberOfPenalisedDays(_rs.getInt("MONETARY_PENALTY_DAYS"));//
    penalityTypes.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));//
    
    }
    _rs.close();
    return penalityTypes;
    } catch (Exception ex) {
    ex.printStackTrace();
    ErrorLogWriter.writeError(ex);
    return null;
    }
     
    }
     //=======================================================================PenalitySelectionForManager==================================================
      public PenaltyTypeModel getPenalityTypeForManger(int penalityID)
           {

    PenaltyTypeModel penalityTypes = new PenaltyTypeModel();
            try {
    ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesFormanager(penalityID);

    while (_rs.next()) {


    penalityTypes.setPenaltyTypeId(_rs.getInt("PENALTY_TYPE_ID"));
    penalityTypes.setPenaltyName(_rs.getString("PENALTY_NAME"));
    penalityTypes.setPenaltyDescription(_rs.getString("DESCRIPTION"));
    penalityTypes.setPenalityFor(_rs.getString("PENALITY_FOR"));//
    penalityTypes.setNumberOfPenalisedDays(_rs.getInt("MONETARY_PENALTY_DAYS"));//
    penalityTypes.setDeductionDuration(_rs.getInt("DEDUCTION_DURATION"));//

    }
    _rs.close();
    return penalityTypes;
    } catch (Exception ex) {
    ex.printStackTrace();
    ErrorLogWriter.writeError(ex);
    return null;
    }

    }
     //====================================================================================================================================================


    public String getPenaltyOfOffence(String disciplineType, int repitition) {
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectPenaltyOfOffence(disciplineType, repitition);
            String penalty = "";
            if (_rs.next()) {
                penalty = _rs.getString("PENALTY_TYPE_ID") + ":::" + _rs.getString("PENALTY_NAME") + ":::" + _rs.getString("DESCRIPTION");
            } else {
                penalty = "-1" + ":::" + "-1" + ":::" + "No penalty registered for this offence";
            }
            _rs.close();
            return penalty;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return "Exception occured. So, penalty not visible";
        }
    }

    public boolean savePenaltyType(ArrayList<PenaltyTypeModel> disciplineTypeList) {
        ArrayList<PenaltyTypeModel> toBeInserted = new ArrayList<PenaltyTypeModel>();
        ArrayList<PenaltyTypeModel> toBeUpdated = new ArrayList<PenaltyTypeModel>();
        ArrayList<PenaltyTypeModel> toBeDeleted = new ArrayList<PenaltyTypeModel>();
        int size = disciplineTypeList.size();
        try {
            for (int counter = 0; counter < size; counter++) {
                if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(disciplineTypeList.get(counter));
                }
            }
            disciplineRegistrationEntity.updatePenaltyTypes(toBeUpdated);
            disciplineRegistrationEntity.deletePenaltyTypes(toBeDeleted);
            disciplineRegistrationEntity.insertPenaltyTypes(toBeInserted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    public boolean savePenaltyTypeForManager(ArrayList<ManagerPenality> disciplineTypeList) {
        ArrayList<ManagerPenality> toBeInserted = new ArrayList<ManagerPenality>();
        ArrayList<ManagerPenality> toBeUpdated = new ArrayList<ManagerPenality>();
        ArrayList<ManagerPenality> toBeDeleted = new ArrayList<ManagerPenality>();
        int size = disciplineTypeList.size();
        try {
            for (int counter = 0; counter < size; counter++) {
                if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(disciplineTypeList.get(counter));
                }
            }
            disciplineRegistrationEntity.updatePenaltyTypesForManager(toBeUpdated);
            disciplineRegistrationEntity.deletePenaltyTypesForManager(toBeDeleted);
            disciplineRegistrationEntity.insertPenaltyTypesForManager(toBeInserted);

            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    public static class PenaltyTypeModel {

        int counter;
        int penaltyTypeId;
        float numberOfPenalisedDays;
        int deductionDuration;
        String penaltyTypeCode;
        String penaltyName;
        String penaltyDescription;
        String actionTaker;
        String penalityFor;
        String status;
        boolean selected;
        String actionTaken;
        double amountTaken;

        public PenaltyTypeModel() {
        }

        public PenaltyTypeModel(String PenaltyTypeCode, String PenaltyName, String description, String actionTaker, String status,String actionTaken) {
            this.penaltyTypeCode = PenaltyTypeCode;
            this.penaltyName = PenaltyName;
            this.penaltyDescription = description;
            this.actionTaker = actionTaker;
            this.status = status;
            this.actionTaken=actionTaken;
        }

        public PenaltyTypeModel(int counter, String penaltyTypeCode, String penaltyName, String description, String actionTaker, String status, String actionTaken) {
            this(penaltyTypeCode, penaltyName, description, actionTaker, status,actionTaken);
            this.counter = counter;
        }

        public PenaltyTypeModel(int counter, String penaltyTypeCode, String penaltyName, String description, String actionTaker, String status, boolean selected,String actionTaken) {
            this(penaltyTypeCode, penaltyName, description, actionTaker, status,actionTaken);
            this.counter = counter;
            this.selected = selected;
        }

        public PenaltyTypeModel(int counter, String penaltyTypeCode, String penaltyName, float numberOfPenalisedDays, String penaltyDescription, String penalityFor, String actionTaker, String status, boolean selected, String actionTaken,int deductionDuration) {
           this.counter=counter;
           this.penaltyTypeCode=penaltyTypeCode;
           this.penaltyName=penaltyName;
           this.numberOfPenalisedDays=numberOfPenalisedDays;
           this.penaltyDescription=penaltyDescription;
           this.penalityFor=penalityFor;
           this.actionTaker=actionTaker;
           this.status=status;
           this.actionTaken=actionTaken;
           this.selected=selected;
           this.deductionDuration=deductionDuration;

        }

        public PenaltyTypeModel(int counter, int deductionduration ,String penaltyTypeCode, String penaltyName, float numberOfPenalisedDays, String description,String penalityFor, String actionTaker, String status, boolean selected,String actionTaken) {
            this(penaltyTypeCode, penaltyName, description, actionTaker, status,actionTaken);
            this.deductionDuration=deductionduration;
            this.penalityFor=penalityFor;
            this.counter = counter;
            this.selected = selected;
            this.numberOfPenalisedDays = numberOfPenalisedDays;
        }



        public double getAmountTaken() {
            return amountTaken;
        }

        public void setAmountTaken(double amountTaken) {
            this.amountTaken = amountTaken;
        }

        public int getDeductionDuration() {
            return deductionDuration;
        }

        public void setDeductionDuration(int deductionDuration) {
            this.deductionDuration = deductionDuration;
        }

        public String getPenalityFor() {
            return penalityFor;
        }

        public void setPenalityFor(String penalityFor) {
            this.penalityFor = penalityFor;
        }

        public String getActionTaker() {
            return actionTaker;
        }

        public void setActionTaker(String actionTaker) {
            this.actionTaker = actionTaker;
        }

        public float getNumberOfPenalisedDays() {
            return numberOfPenalisedDays;
        }

        public void setNumberOfPenalisedDays(float numberOfPenalisedDays) {
            this.numberOfPenalisedDays = numberOfPenalisedDays;
        }

        
        public void setNumberOfPenalisedDays(int numberOfPenalisedDays) {
            this.numberOfPenalisedDays = numberOfPenalisedDays;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getPenaltyDescription() {
            return penaltyDescription;
        }

        public void setPenaltyDescription(String penaltyDescription) {
            this.penaltyDescription = penaltyDescription;
        }

        public String getPenaltyName() {
            return penaltyName;
        }

        public void setPenaltyName(String penaltyName) {
            this.penaltyName = penaltyName;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getActionTaken() {
            return actionTaken;
        }

        public void setActionTaken(String actionTaken) {
            this.actionTaken = actionTaken;
        }

        public String getPenaltyTypeCode() {
            return penaltyTypeCode;
        }

        public void setPenaltyTypeCode(String penaltyTypeCode) {
            this.penaltyTypeCode = penaltyTypeCode;
        }

        public int getPenaltyTypeId() {
            return penaltyTypeId;
        }

        public void setPenaltyTypeId(int penaltyTypeId) {
            this.penaltyTypeId = penaltyTypeId;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
   
    public static class ProcessType {

   
    String processTypeID;
    String ProcessName;
    String ProcessDescription;
    
    public ProcessType() {
    }

    public ProcessType( String processID, String processName, String processDescription) {
    this.processTypeID = processID;
    this.ProcessName = processName;
    this.ProcessDescription = processDescription;
        }

        public String getProcessDescription() {
            return ProcessDescription;
        }

        public void setProcessDescription(String ProcessDescription) {
            this.ProcessDescription = ProcessDescription;
        }

        public String getProcessName() {
            return ProcessName;
        }

        public void setProcessName(String ProcessName) {
            this.ProcessName = ProcessName;
        }

        public String getProcessTypeID() {
            return processTypeID;
        }

        public void setProcessTypeID(String processTypeID) {
            this.processTypeID = processTypeID;
        }

    
    }
    public static class ManagerPenality{
        int counter;
        int penaltyTypeId;
        float numberOfPenalisedDays;
        int deductionDuration;
        String penaltyTypeCode;
        String penaltyName;
        String penaltyDescription;
        String actionTaker;
        String penalityFor;
        String status;
        boolean selected;
        String actionTaken;
        double amountTaken;
        float deductionAmount;

        public ManagerPenality(int counter, String penaltyTypeCode, String penaltyName, float deductionamount, String penaltyDescription, String penalityFor, String actionTaker, String status, boolean b, String actionTaken, int deductionduration) {
            this.counter=counter;
            this.penaltyTypeCode=penaltyTypeCode;
            this.penaltyName=penaltyName;
            this.deductionAmount=deductionamount;
            this.penaltyDescription=penaltyDescription;
            this.penalityFor=penalityFor;
            this.actionTaker=actionTaker;
            this.status=status;
            this.actionTaken=actionTaken;
            this.deductionDuration=deductionduration;
        }

        public ManagerPenality() {
        }

        public float getDeductionAmount() {
            return deductionAmount;
        }

        public void setDeductionAmount(float deductionAmount) {
            this.deductionAmount = deductionAmount;
        }


      
        public String getActionTaken() {
            return actionTaken;
        }

        public void setActionTaken(String actionTaken) {
            this.actionTaken = actionTaken;
        }

        public String getActionTaker() {
            return actionTaker;
        }

        public void setActionTaker(String actionTaker) {
            this.actionTaker = actionTaker;
        }

        public double getAmountTaken() {
            return amountTaken;
        }

        public void setAmountTaken(double amountTaken) {
            this.amountTaken = amountTaken;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public int getDeductionDuration() {
            return deductionDuration;
        }

        public void setDeductionDuration(int deductionDuration) {
            this.deductionDuration = deductionDuration;
        }

        public float getNumberOfPenalisedDays() {
            return numberOfPenalisedDays;
        }

        public void setNumberOfPenalisedDays(float numberOfPenalisedDays) {
            this.numberOfPenalisedDays = numberOfPenalisedDays;
        }

      

        public String getPenalityFor() {
            return penalityFor;
        }

        public void setPenalityFor(String penalityFor) {
            this.penalityFor = penalityFor;
        }

        public String getPenaltyDescription() {
            return penaltyDescription;
        }

        public void setPenaltyDescription(String penaltyDescription) {
            this.penaltyDescription = penaltyDescription;
        }

        public String getPenaltyName() {
            return penaltyName;
        }

        public void setPenaltyName(String penaltyName) {
            this.penaltyName = penaltyName;
        }

        public String getPenaltyTypeCode() {
            return penaltyTypeCode;
        }

        public void setPenaltyTypeCode(String penaltyTypeCode) {
            this.penaltyTypeCode = penaltyTypeCode;
        }

        public int getPenaltyTypeId() {
            return penaltyTypeId;
        }

        public void setPenaltyTypeId(int penaltyTypeId) {
            this.penaltyTypeId = penaltyTypeId;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

    

    }
    //</editor-fold>
}
