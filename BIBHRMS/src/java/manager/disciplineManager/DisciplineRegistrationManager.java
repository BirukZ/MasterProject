/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.DisciplineRegistrationEntity;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class DisciplineRegistrationManager {

    DisciplineRegistrationEntity disciplineRegistrationEntity = new DisciplineRegistrationEntity();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void IsPenalityCanBeApproved(int i) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public ArrayList<Option> getDisciplineCategories() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option(-1, "--SELECT CATEGORY--"));
        categoryList.add(new Option("High", "High"));
        categoryList.add(new Option("Medium", "Medium"));
        categoryList.add(new Option("Low", "Low"));
        return categoryList;
    }
      public ArrayList<Option> getDisciplineSubCategories() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option(-1, "--SELECT SUBCATEGORY--"));
        categoryList.add(new Option("A", "A"));
        categoryList.add(new Option("B", "B"));
        categoryList.add(new Option("C", "C"));
        return categoryList;
    }


    public boolean saveDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) {
        ArrayList<DisciplineTypeModel> toBeInserted = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUpdated = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeDeleted = new ArrayList<DisciplineTypeModel>();

        try {
            for (int counter = 0; counter < disciplineTypeList.size(); counter++) {
                if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(disciplineTypeList.get(counter));
                }
            }
            disciplineRegistrationEntity.updateDisciplineTypes(toBeUpdated);
            disciplineRegistrationEntity.insertDisciplineTypes(toBeInserted);
            disciplineRegistrationEntity.deleteDisciplineTypes(toBeDeleted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    //-------------------------------------DisciplineTypeRegistration------------------------------------------------------
     public boolean saveDisciplineTypesForManager(ArrayList<DisciplineTypeModel> disciplineTypeList) {
        ArrayList<DisciplineTypeModel> toBeInserted = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUpdated = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeDeleted = new ArrayList<DisciplineTypeModel>();

        try {
            for (int counter = 0; counter < disciplineTypeList.size(); counter++) {
                if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("New")) {
                    toBeInserted.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Edited")) {
                    toBeUpdated.add(disciplineTypeList.get(counter));
                } else if (disciplineTypeList.get(counter).getStatus().equalsIgnoreCase("Deleted")) {
                    toBeDeleted.add(disciplineTypeList.get(counter));
                }
            }
            disciplineRegistrationEntity.updateDisciplineTypesForManager(toBeUpdated);
            disciplineRegistrationEntity.insertDisciplineTypesForManager(toBeInserted);
            disciplineRegistrationEntity.deleteDisciplineTypesManager(toBeDeleted);
            return true;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }
    //---------------------------------------------------------------------------------------------------------------------

    public ArrayList<Option> getAllDesciplineTypesOption() {
        ArrayList<Option> desciplineTypes = new ArrayList<Option>();

        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllDisciplineTypes();
            while (_rs.next()) {
                desciplineTypes.add(new Option(_rs.getString("DESCIPLINE_TYPE_ID") + "--" + _rs.getString("DISCIPLINE_CODE") + "--" + _rs.getString("OFFENCE_NAME") + "--" + _rs.getString("DESCRIPTION"), _rs.getString("DISCIPLINE_CODE") + " : " + _rs.getString("OFFENCE_NAME")));
            }
            if (desciplineTypes.size() == 0) {
                desciplineTypes.add(new Option("-1", "NO DISCIPLINE TYPE"));
            } else {
                desciplineTypes.add(0, new Option("-1", "SELECT DISCIPLINE TYPE"));
            }
            _rs.close();
            return desciplineTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //==============================================DisciplineForManager=========================================================================
      public ArrayList<Option> getAllDesciplineTypesOptionForManager() {
        ArrayList<Option> desciplineTypes = new ArrayList<Option>();

        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllDisciplineTypesForManger();
            while (_rs.next()) {
                desciplineTypes.add(new Option(_rs.getString("DESCIPLINE_TYPE_ID") + "--" + _rs.getString("DISCIPLINE_CODE") + "--" + _rs.getString("OFFENCE_NAME") + "--" + _rs.getString("DESCRIPTION"), _rs.getString("DISCIPLINE_CODE") + " -- " + _rs.getString("OFFENCE_NAME")));
           

            }
            if (desciplineTypes.size() == 0) {
                desciplineTypes.add(new Option("-1", "NO DISCIPLINE TYPE"));
            } else {
                desciplineTypes.add(0, new Option("-1", "SELECT DISCIPLINE TYPE"));
            }
            _rs.close();
            return desciplineTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }
    //===========================================================================================================================================

    public String getDisciplineName(String disciplineTypeId,String employeeStatus) {
        String disciplineName = "";
         ResultSet _rs=null;
        try {
            if(employeeStatus.equalsIgnoreCase("Normal")){
             _rs = disciplineRegistrationEntity.selectDisciplineType(disciplineTypeId);
            }else if(employeeStatus.equalsIgnoreCase("Manager")){
             _rs = disciplineRegistrationEntity.selectDisciplineTypeForManager(disciplineTypeId);
            }
            while (_rs.next()) {
                disciplineName = _rs.getString("OFFENCE_NAME");
            }
            _rs.close();
            return disciplineName;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public ArrayList<DisciplineTypeModel> getAllDesciplineTypes() {

        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllDisciplineTypes();
            int counter = 0;
            while (_rs.next()) {
                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE_ID"));//
                currentdesciplineType.setDisciplineCatagory(_rs.getString("DESCIPLINE_CATAGORY"));//
                currentdesciplineType.setStatus("Old");  //DESCIPLINE_CATAGORY
                currentdesciplineType.setPhaseoutPeriod(_rs.getString("PHASEOUT_PERIOD"));//
                currentdesciplineType.setDisciplineSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));//

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
    //------------------------------------------------DisciplineTypeListForTheManager-------------------------------------------------
      public ArrayList<DisciplineTypeModel> getAllDesciplineTypesForManger() {

        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllDisciplineTypesForManger();
            int counter = 0;
            while (_rs.next()) {
                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));//Descripiton of the discipline problem
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//Discipline Name
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE_ID"));//
                currentdesciplineType.setDisciplineCatagory(_rs.getString("DESCIPLINE_CATAGORY"));//
                currentdesciplineType.setStatus("Old");  //DESCIPLINE_CATAGORY
                currentdesciplineType.setPhaseoutPeriod(_rs.getString("PHASEOUT_PERIOD"));//Phase out time
                currentdesciplineType.setDisciplineSubCatagory(_rs.getString("DISCIPLINE_SUBCATAGORY"));//
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
    //---------------------------------------------------------------------------------------------------------------------------------

    public static class DisciplineTypeModel {

        int counter;
        int disciplineTypeId;
        String penaltyTypeId;
        String disciplineTypeCode;
        int disciplineTypeRepititionId;
        String disciplineName;
        int repitition;
        String disciplineSubCatagory;
        String savedStatus;
        String penalty;
        String penaltyName;
        String description;
        String phaseoutPeriod;
        String decisionGiverType;
        String status;
        String disciplineCatagory;
        String suspendedFrom;
        String suspendedDuration;
        String suspendedTransfer;
        String transferDuration;
        boolean selected;

        public DisciplineTypeModel() {
        }

        public DisciplineTypeModel(String savedStaus,int counter, int disciplineTypeId,String disciplineCode, String disciplineName, String penaltyTypeId, String penaltyName, int repitition, String status, boolean selected, String process, String duration, String suspendTransfer,String tranDuration)
                 {
            this.savedStatus=savedStaus;
            this.status=status;
            this.counter = counter;
            this.disciplineTypeId = disciplineTypeId;
           this.disciplineTypeCode=disciplineCode;
            this.disciplineName = disciplineName;
            this.penaltyTypeId = penaltyTypeId;
            this.penaltyName = penaltyName;
            this.repitition = repitition;
            this.status = status;
            this.selected = selected;
            this.suspendedFrom = process;
            this.suspendedDuration = duration;
            this.suspendedTransfer = suspendTransfer;
            this.transferDuration = tranDuration;
            

        }

        public DisciplineTypeModel(int counter, String disciplineName, String disciplineTypeCode, String description, String phaseoutPeriod, String status) {
            this.counter = counter;
            this.disciplineName = disciplineName;
            this.disciplineTypeCode = disciplineTypeCode;
            this.description = description;
            this.phaseoutPeriod = phaseoutPeriod;
            this.status = status;
        }

        public DisciplineTypeModel(int counter, String disciplineName, String disciplineTypeCode, String description, String phaseoutPeriod, String status, boolean selected) {
            this(counter, disciplineName, disciplineTypeCode, description, phaseoutPeriod, status);
            this.selected = selected;
        }

        public DisciplineTypeModel(int counter, String disciplineName, String disciplineTypeCode, String description, String phaseoutPeriod, String status, String disciplineCatagory,String disciplienSubCatagory, boolean selected) {
            this(counter, disciplineName, disciplineTypeCode, description, phaseoutPeriod, status);
            this.selected = selected;
            this.disciplineCatagory = disciplineCatagory;
            this.disciplineSubCatagory=disciplienSubCatagory;
        }

        public DisciplineTypeModel(int counter, int disciplineTypeId, String disciplineName, String disciplineTypeCode, String description, String phaseoutPeriod, String status) {
            this(counter, disciplineName, disciplineTypeCode, description, phaseoutPeriod, status);
            this.disciplineTypeId = disciplineTypeId;
        }

        public DisciplineTypeModel(int counter, int disciplineTypeId, String disciplineName, int repitition, String penalty, String decisionGiverType, String status) {
            this.counter = counter;
            this.disciplineTypeId = disciplineTypeId;
            this.disciplineName = disciplineName;
            this.repitition = repitition;
            this.penalty = penalty;
            this.decisionGiverType = decisionGiverType;
            this.status = status;
        }

        public DisciplineTypeModel(int counter, int disciplineTypeId, String disciplineName, int repitition, String penality, String decisionGiverType, String status, boolean selected) {
            this(counter, disciplineTypeId, disciplineName, repitition, penality, decisionGiverType, status);
            this.selected = selected;
        }

        public String getDisciplineSubCatagory() {
            return disciplineSubCatagory;
        }

        public void setDisciplineSubCatagory(String disciplineSubCatagory) {
            this.disciplineSubCatagory = disciplineSubCatagory;
        }

        public String getSavedStatus() {
            return savedStatus;
        }

        public void setSavedStatus(String savedStatus) {
            this.savedStatus = savedStatus;
        }

        public String getSuspendedTransfer() {
            return suspendedTransfer;
        }

        public void setSuspendedTransfer(String suspendedTransfer) {
            this.suspendedTransfer = suspendedTransfer;
        }

        public String getTransferDuration() {
            return transferDuration;
        }

        public void setTransferDuration(String transferDuration) {
            this.transferDuration = transferDuration;
        }

     
        public String getSuspendedDuration() {
            return suspendedDuration;
        }

        public void setSuspendedDuration(String suspendedDuration) {
            this.suspendedDuration = suspendedDuration;
        }

        public String getSuspendedFrom() {
            return suspendedFrom;
        }

        public void setSuspendedFrom(String suspendedFrom) {
            this.suspendedFrom = suspendedFrom;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public int getCounter() {
            return counter;
        }

        public String getPenaltyTypeId() {
            return penaltyTypeId;
        }

        public void setPenaltyTypeId(String penaltyTypeId) {
            this.penaltyTypeId = penaltyTypeId;
        }

      

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getDisciplineName() {
            return disciplineName;
        }

        public String getDisciplineCatagory() {
            return disciplineCatagory;
        }

        public void setDisciplineCatagory(String disciplineCatagory) {
            this.disciplineCatagory = disciplineCatagory;
        }

        public void setDisciplineName(String disciplineName) {
            this.disciplineName = disciplineName;
        }

        public int getDisciplineTypeId() {
            return disciplineTypeId;
        }

        public void setDisciplineTypeId(int disciplineTypeId) {
            this.disciplineTypeId = disciplineTypeId;
        }

        public int getRepitition() {
            return repitition;
        }

        public void setRepitition(int repitition) {
            this.repitition = repitition;
        }

        public String getPenalty() {
            return penalty;
        }

        public void setPenalty(String penalty) {
            this.penalty = penalty;
        }

        public String getPenaltyName() {
            return penaltyName;
        }

        public void setPenaltyName(String penaltyName) {
            this.penaltyName = penaltyName;
        }

        public String getDecisionGiverType() {
            return decisionGiverType;
        }

        public void setDecisionGiverType(String decisionGiverType) {
            this.decisionGiverType = decisionGiverType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getPhaseoutPeriod() {
            return phaseoutPeriod;
        }

        public void setPhaseoutPeriod(String phaseoutPeriod) {
            this.phaseoutPeriod = phaseoutPeriod;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getDisciplineTypeCode() {
            return disciplineTypeCode;
        }

        public void setDisciplineTypeCode(String disciplineTypeCode) {
            this.disciplineTypeCode = disciplineTypeCode;
        }

        public int getDisciplineTypeRepititionId() {
            return disciplineTypeRepititionId;
        }

        public void setDisciplineTypeRepititionId(int disciplineTypeRepititionId) {
            this.disciplineTypeRepititionId = disciplineTypeRepititionId;
        }
    }
    public static class ManagerDisciplineModel{
         int counter;
        int disciplineTypeId;
        String penaltyTypeId;
        String disciplineTypeCode;
        int disciplineTypeRepititionId;
        String disciplineName;
        int repitition;
        String disciplineSubCatagory;
        String savedStatus;
        String penalty;
        String penaltyName;
        String description;
        String phaseoutPeriod;
        String decisionGiverType;
        String status;
        String disciplineCatagory;
        String suspendedFrom;
        String suspendedDuration;
        String suspendedTransfer;
        String transferDuration;
        boolean selected;

        public ManagerDisciplineModel(String savedStaus, int counter, int disciplineTypeId,String disciplineCode, String disciplineName, String penaltyTypeId, String penaltyName, int repitition, String status, boolean selected, String process, String duration, String suspendTransfer, String tranDuration) {
            this.savedStatus=savedStaus;
            this.status=status;
            this.counter = counter;
            this.disciplineTypeId = disciplineTypeId;
            this.disciplineTypeCode=disciplineCode;
            this.disciplineName = disciplineName;
            this.penaltyTypeId = penaltyTypeId;
            this.penaltyName = penaltyName;
            this.repitition = repitition;
           this.selected = selected;
            this.suspendedFrom = process;
            this.suspendedDuration = duration;
            this.suspendedTransfer = suspendTransfer;
            this.transferDuration = tranDuration;
        }

        public int getCounter() {
            return counter;
        }

        public void setCounter(int counter) {
            this.counter = counter;
        }

        public String getDecisionGiverType() {
            return decisionGiverType;
        }

        public void setDecisionGiverType(String decisionGiverType) {
            this.decisionGiverType = decisionGiverType;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getDisciplineCatagory() {
            return disciplineCatagory;
        }

        public void setDisciplineCatagory(String disciplineCatagory) {
            this.disciplineCatagory = disciplineCatagory;
        }

        public String getDisciplineName() {
            return disciplineName;
        }

        public void setDisciplineName(String disciplineName) {
            this.disciplineName = disciplineName;
        }

        public String getDisciplineSubCatagory() {
            return disciplineSubCatagory;
        }

        public void setDisciplineSubCatagory(String disciplineSubCatagory) {
            this.disciplineSubCatagory = disciplineSubCatagory;
        }

        public String getDisciplineTypeCode() {
            return disciplineTypeCode;
        }

        public void setDisciplineTypeCode(String disciplineTypeCode) {
            this.disciplineTypeCode = disciplineTypeCode;
        }

        public int getDisciplineTypeId() {
            return disciplineTypeId;
        }

        public void setDisciplineTypeId(int disciplineTypeId) {
            this.disciplineTypeId = disciplineTypeId;
        }

        public int getDisciplineTypeRepititionId() {
            return disciplineTypeRepititionId;
        }

        public void setDisciplineTypeRepititionId(int disciplineTypeRepititionId) {
            this.disciplineTypeRepititionId = disciplineTypeRepititionId;
        }

        public String getPenalty() {
            return penalty;
        }

        public void setPenalty(String penalty) {
            this.penalty = penalty;
        }

        public String getPenaltyName() {
            return penaltyName;
        }

        public void setPenaltyName(String penaltyName) {
            this.penaltyName = penaltyName;
        }

        public String getPenaltyTypeId() {
            return penaltyTypeId;
        }

        public void setPenaltyTypeId(String penaltyTypeId) {
            this.penaltyTypeId = penaltyTypeId;
        }

     

        public String getPhaseoutPeriod() {
            return phaseoutPeriod;
        }

        public void setPhaseoutPeriod(String phaseoutPeriod) {
            this.phaseoutPeriod = phaseoutPeriod;
        }

        public int getRepitition() {
            return repitition;
        }

        public void setRepitition(int repitition) {
            this.repitition = repitition;
        }

        public String getSavedStatus() {
            return savedStatus;
        }

        public void setSavedStatus(String savedStatus) {
            this.savedStatus = savedStatus;
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

        public String getSuspendedDuration() {
            return suspendedDuration;
        }

        public void setSuspendedDuration(String suspendedDuration) {
            this.suspendedDuration = suspendedDuration;
        }

        public String getSuspendedFrom() {
            return suspendedFrom;
        }

        public void setSuspendedFrom(String suspendedFrom) {
            this.suspendedFrom = suspendedFrom;
        }

        public String getSuspendedTransfer() {
            return suspendedTransfer;
        }

        public void setSuspendedTransfer(String suspendedTransfer) {
            this.suspendedTransfer = suspendedTransfer;
        }

        public String getTransferDuration() {
            return transferDuration;
        }

        public void setTransferDuration(String transferDuration) {
            this.transferDuration = transferDuration;
        }

        public ManagerDisciplineModel() {
        }



    }
    //</editor-fold>
}
