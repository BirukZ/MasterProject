/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.disciplineManager;

import com.sun.webui.jsf.model.Option;
import entity.disciplineEntity.DisciplinePenaltyRegistrationEntity;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.disciplineManager.DisciplineRegistrationManager.DisciplineTypeModel;
import manager.disciplineManager.DisciplineRegistrationManager.ManagerDisciplineModel;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import manager.disciplineManager.PenaltyRegistrationManager.ProcessType;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author mekete
 */
public class DisciplinePenaltyRegistrationManager {

    DisciplinePenaltyRegistrationEntity disciplineRegistrationEntity = new DisciplinePenaltyRegistrationEntity();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");



    public ArrayList<Option> getPossibleRepitions() {
        ArrayList<Option> repitionList = new ArrayList<Option>();
        repitionList.add(new Option(-1, "--SELECT REPITITIONN--"));
        repitionList.add(new Option(1, "FIRST"));
        repitionList.add(new Option(2, "SECOND"));
        repitionList.add(new Option(3, "THIRD"));
        repitionList.add(new Option(4, "FOURTH"));
        repitionList.add(new Option(5, "FIFTH"));

        return repitionList;
    }

    public ArrayList<Option> getPossibleRepitionsForSerach() {
        ArrayList<Option> repitionListnew = new ArrayList<Option>();
        repitionListnew.add(new Option(-1, "--SELECT REPITITIONN--"));
        repitionListnew.add(new Option(1, "FIRST"));
        repitionListnew.add(new Option(2, "SECOND"));
        repitionListnew.add(new Option(3, "THIRD"));
        repitionListnew.add(new Option(4, "FOURTH"));
        repitionListnew.add(new Option(5, "FIFTH"));

        return repitionListnew;
    }

    public ArrayList<Option> getDisciplineCategories() {
        ArrayList<Option> categoryList = new ArrayList<Option>();
        categoryList.add(new Option(-1, "--SELECT Category--"));
        categoryList.add(new Option("1--High", "High"));
        categoryList.add(new Option("2--Medium", "Medium"));
        categoryList.add(new Option("3--Low", "Low"));
        return categoryList;
    }

    public ArrayList<Option> getDeciderTypes() {
        ArrayList<Option> deciderList = new ArrayList<Option>();
        deciderList.add(new Option(-1, "--SELECT DECIDER--"));
        deciderList.add(new Option(1, "Top Mgr"));
        deciderList.add(new Option(2, "Imm Boss"));
        deciderList.add(new Option(3, "Discipline committe"));
        return deciderList;
    }

    public ArrayList<Option> getAllProcessOption() {
        ArrayList<Option> processTypes = new ArrayList<Option>();

        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllProcessTypes();
            while (_rs.next()) {
                processTypes.add(new Option(_rs.getString("PROCESS_NAME"), _rs.getString("PROCESS_ID") + " : " + _rs.getString("PROCESS_NAME")));
            }
            if (processTypes.size() == 0) {
                processTypes.add(new Option("-1", "NO PROCESS TYPE"));
            } else {
                processTypes.add(0, new Option("-1", "SELECT PROCESS TYPE"));
            }
            _rs.close();
            return processTypes;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

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

    public ArrayList<ProcessType> getAllProcessDetaile() {
        ArrayList<ProcessType> ProcessTypes = new ArrayList<ProcessType>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllProcessType();
            int counter = 0;
            while (_rs.next()) {
                ProcessType currentdesciplineType = new ProcessType();
                currentdesciplineType.setProcessTypeID(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setProcessName(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setProcessDescription(_rs.getString("OFFENCE_NAME"));//

                ProcessTypes.add(currentdesciplineType);
            }
            _rs.close();
            return ProcessTypes;
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

    public String getPenaltyOfOffence(String disciplineType, int repitition) {
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectPenaltyOfOffence(disciplineType, repitition + 1);
            String penalty = "";
            if (_rs.next()) {
                penalty = (_rs.getString("DESCRIPTION"));
            } else {
                penalty = "No penalty registered for this offence";
            }
            _rs.close();
            return penalty;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return "Exception occured. So, penalty not visible";
        }
    }
    //========================================getAllpenalityTypeForDisciplineManager===========================================================================
    public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailForManager() {

        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailFitstForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //=========================================================================================================================================================

    public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetail() {

        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetail();
            int counter = 0;
            while (_rs.next()) {

                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //============================================This is the First Reputaion for the Manager==========================================================
     public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailFirstReputaionForManager() {

        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailFitstForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //=================================================================================================================================================



    public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetailFives() {
        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailFives();
            int counter = 0;
            while (_rs.next()) {

                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //====================================================This is the Fives Reputaion for Manager=============================================================
    public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailFivesForManager() {
        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailFivesForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //======================================================This is the second Reputaion for the Manager=====================================================
     public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailSecondReputaionForManager() {
        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailSecondForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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

    //========================================================================================================================================================

    public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetailForthreputaion() {
        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailForth();
            int counter = 0;
            while (_rs.next()) {

                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //========================================================For the fourth Reputaion For the Manager===========================================
    public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailForthreputaionForManager() {
        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailForthForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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

//================================================================================================================================================
    public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetailSecondReputaion() {
        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailSecond();
            int counter = 0;
            while (_rs.next()) {

                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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

    public ArrayList<DisciplineTypeModel> getAllPenaltyTypesDetailThiredReputaion() {
        ArrayList<DisciplineTypeModel> desciplineTypes = new ArrayList<DisciplineTypeModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailThired();
            int counter = 0;
            while (_rs.next()) {

                DisciplineTypeModel currentdesciplineType = new DisciplineTypeModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setPenaltyTypeId(_rs.getString("PENALTY_CODE"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //=================================================================================================================================================
      public ArrayList<ManagerDisciplineModel> getAllPenaltyTypesDetailThiredReputaionForManager() {
        ArrayList<ManagerDisciplineModel> desciplineTypes = new ArrayList<ManagerDisciplineModel>();
        try {
            ResultSet _rs = disciplineRegistrationEntity.selectAllPenaltyTypesDetailThiredForManager();
            int counter = 0;
            while (_rs.next()) {

                ManagerDisciplineModel currentdesciplineType = new ManagerDisciplineModel();
                currentdesciplineType.setDisciplineTypeRepititionId(_rs.getInt("DISCIPLINED_TYPE_REPITITION_ID"));
                currentdesciplineType.setCounter(++counter);
                currentdesciplineType.setSavedStatus(_rs.getString("SAVED_SATUS"));
                currentdesciplineType.setDescription(_rs.getString("DESCRIPTION"));
                currentdesciplineType.setDisciplineName(_rs.getString("OFFENCE_NAME"));//
                currentdesciplineType.setDisciplineTypeCode(_rs.getString("DISCIPLINE_CODE"));//
                currentdesciplineType.setDisciplineTypeId(_rs.getInt("DESCIPLINE_TYPE"));//
                currentdesciplineType.setPenalty(_rs.getString("PENALTY"));//
                currentdesciplineType.setPenaltyName(_rs.getString("PENALTY_NAME"));
                currentdesciplineType.setStatus("Old");  //
                currentdesciplineType.setRepitition(_rs.getInt("REPITITION"));//
                currentdesciplineType.setSuspendedFrom(_rs.getString("PROCESS_NAME"));//
                currentdesciplineType.setSuspendedDuration(_rs.getString("DURATION"));//
                currentdesciplineType.setSuspendedTransfer(_rs.getString("PROCESS_TRANSFER"));
                currentdesciplineType.setTransferDuration(_rs.getString("DURATION_TRANSFER"));
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
    //=================================================================================================================================================

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
                currentPenaltyType.setActionTaker(_rs.getString("ACTION_TAKER"));//
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
                penaltyTypes.add(new Option(_rs.getInt("PENALTY_TYPE_ID") + "--" + _rs.getString("PENALTY_NAME") + "--" + "DECIDER FILLED", _rs.getString("PENALTY_CODE") + " : " + _rs.getString("PENALTY_NAME")));
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

    public ArrayList<Option> getTerminationTypes(int decisionType, String terminationCatagory) {
        ArrayList<Option> terminationCatagories = new ArrayList<Option>();
        if (terminationCatagory.equals("-1")) {
            terminationCatagories.add(new Option("-1", "Select Catagory First"));
            return terminationCatagories;
        } else {
            try {
                ResultSet _rs = disciplineRegistrationEntity.selectPenaltyOfOffence(decisionType, terminationCatagory);
                while (_rs.next()) {
                    terminationCatagories.add(new Option(_rs.getInt("TERMINATION_TYPE_ID"), _rs.getString("TERMINATION_TYPE")));
                }
                if (terminationCatagories.size() == 0) {
                    terminationCatagories.add(new Option("-1", "NO TERMINATION TYPE"));
                } else {
                    terminationCatagories.add(0, new Option("-1", "SELECT TERMINATION TYPE"));
                }
                _rs.close();
                return terminationCatagories;
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
                return null;
            }
        }
    }

    public boolean saveDisciplinePenaltyFives(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        try {
            disciplineRegistrationEntity.saveDisciplinePenaltyFirstreputaion(disciplineTypesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveDisciplinePenaltyReputaionFirst(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        try {
            disciplineRegistrationEntity.saveDisciplinePenaltyFirstreputaion(disciplineTypesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveDisciplinePenaltyReputaionFourth(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        try {
            disciplineRegistrationEntity.saveDisciplinePenaltyForthReputaion(disciplineTypesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveDisciplinePenaltyReputaionSecond(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        try {
            disciplineRegistrationEntity.saveDisciplinePenaltySecondReputaion(disciplineTypesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveDisciplinePenaltyReputaionThird(ArrayList<DisciplineTypeModel> disciplineTypesList) {
        try {
            disciplineRegistrationEntity.saveDisciplinePenaltyThiredReputaion(disciplineTypesList);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
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

    public boolean DisciplinePenalityDetaile(ArrayList<DisciplineTypeModel> disciplinePenaltyList) {
        ArrayList<DisciplineTypeModel> toBeUPdateRep2 = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUpdateRep1 = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUPdateRep3 = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUPdateRep4 = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeUPdateRep5 = new ArrayList<DisciplineTypeModel>();
        try {
            for (DisciplineTypeModel currentotherEyewitness : disciplinePenaltyList) {
                if (currentotherEyewitness.getRepitition() == 1) {
                    toBeUpdateRep1.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getRepitition() == 2) {
                    toBeUPdateRep2.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getRepitition() == 3) {
                    toBeUPdateRep3.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getRepitition() == 4) {
                    toBeUPdateRep4.add(currentotherEyewitness);
                } else if (currentotherEyewitness.getRepitition() == 5) {
                    toBeUPdateRep5.add(currentotherEyewitness);
                }



                if (toBeUPdateRep2.size() > 0) {
                }
                disciplineRegistrationEntity.updateDisciplinePenalitiesReptionTwo(toBeUPdateRep2);
            }

            if (toBeUpdateRep1.size() > 0) {

                disciplineRegistrationEntity.updateDisciplinePenalities(toBeUpdateRep1);
            }
            if (toBeUPdateRep3.size() > 0) {
                disciplineRegistrationEntity.updateDisciplinePenalitiesReputaionThree(toBeUPdateRep3);
            }
            if (toBeUPdateRep4.size() > 0) {
                disciplineRegistrationEntity.updateDisciplinePenalitiesReputaionFour(toBeUPdateRep4);
            }
            if (toBeUPdateRep5.size() > 0) {
                disciplineRegistrationEntity.updateDisciplinePenalitiesReputaionFive(toBeUPdateRep5);
            }
        // return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }

    public boolean saveProcessType(String processID, String processName, String processDescription) {
        try {
            disciplineRegistrationEntity.saveProcess(processID, processName, processDescription);

        } catch (SQLException ex) {
            Logger.getLogger(DisciplinePenaltyRegistrationManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return true;
    }

    private boolean validateDisciplineIssued() {
        return true;
    }

    public boolean saveDisciplinePenalty(ArrayList<DisciplineTypeModel> disciplineTypeList) {
        //==========================================================================================================
        //  if(disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition())
        ArrayList<DisciplineTypeModel> toBeInsertedForFirstRepition = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeInsertedForSecondRepution = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeInsertedForThiredRepution = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeInsertedForForthReputaion = new ArrayList<DisciplineTypeModel>();
        ArrayList<DisciplineTypeModel> toBeInsertedForFiviseReputaion = new ArrayList<DisciplineTypeModel>();

        try {

            for (int counter = 0; counter < disciplineTypeList.size(); counter++) {

                if (disciplineTypeList.get(counter).getRepitition() == 1) {
                    toBeInsertedForFirstRepition.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 2) {
                    toBeInsertedForSecondRepution.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 3) {
                    toBeInsertedForThiredRepution.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 4) {
                    toBeInsertedForForthReputaion.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 5) {
                    toBeInsertedForFiviseReputaion.add(disciplineTypeList.get(counter));

                }

            }

         if (toBeInsertedForFirstRepition.size() > 0) {
            }
            disciplineRegistrationEntity.saveDisciplinePenaltyFirstreputaion(toBeInsertedForFirstRepition);

            if (toBeInsertedForSecondRepution.size() > 0) {

                disciplineRegistrationEntity.saveDisciplinePenaltySecondReputaion(toBeInsertedForSecondRepution);

            }
            if (toBeInsertedForThiredRepution.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyThiredReputaion(toBeInsertedForThiredRepution);

            }
            if (toBeInsertedForForthReputaion.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyForthReputaion(toBeInsertedForForthReputaion);

            }

            if (toBeInsertedForFiviseReputaion.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyFivesReputaion(toBeInsertedForFiviseReputaion);

            }
        // return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
    //====================================================SavingForManagement==========================================================
    public boolean saveDisciplinePenaltyForManager(ArrayList<ManagerDisciplineModel> disciplineTypeList) {

        //  if(disciplinePenaltyList.get(selectedRowDisciplinePenalty).getRepitition())
        ArrayList<ManagerDisciplineModel> toBeInsertedForFirstRepitionManager = new ArrayList<ManagerDisciplineModel>();
        ArrayList<ManagerDisciplineModel> toBeInsertedForSecondReputionManager = new ArrayList<ManagerDisciplineModel>();
        ArrayList<ManagerDisciplineModel> toBeInsertedForThiredReputionManager = new ArrayList<ManagerDisciplineModel>();
        ArrayList<ManagerDisciplineModel> toBeInsertedForForthReputaionManager = new ArrayList<ManagerDisciplineModel>();
        ArrayList<ManagerDisciplineModel> toBeInsertedForFiviseReputaionManager = new ArrayList<ManagerDisciplineModel>();

        try {

            for (int counter = 0; counter < disciplineTypeList.size(); counter++) {

                if (disciplineTypeList.get(counter).getRepitition() == 1) {
                    toBeInsertedForFirstRepitionManager.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 2) {
                    toBeInsertedForSecondReputionManager.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 3) {
                    toBeInsertedForThiredReputionManager.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 4) {
                    toBeInsertedForForthReputaionManager.add(disciplineTypeList.get(counter));

                } else if (disciplineTypeList.get(counter).getRepitition() == 5) {
                    toBeInsertedForFiviseReputaionManager.add(disciplineTypeList.get(counter));

                }

            }

         if (toBeInsertedForFirstRepitionManager.size() > 0) {
            }
            disciplineRegistrationEntity.saveDisciplinePenaltyFirstreputaionForManager(toBeInsertedForFirstRepitionManager);

            if (toBeInsertedForSecondReputionManager.size() > 0) {

                disciplineRegistrationEntity.saveDisciplinePenaltySecondReputaionForManager(toBeInsertedForSecondReputionManager);

            }
            if (toBeInsertedForThiredReputionManager.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyThiredReputaionForManager(toBeInsertedForThiredReputionManager);

            }
            if (toBeInsertedForForthReputaionManager.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyForthReputaionForManager(toBeInsertedForForthReputaionManager);

            }

            if (toBeInsertedForFiviseReputaionManager.size() > 0) {
                disciplineRegistrationEntity.saveDisciplinePenaltyFivesReputaionFor(toBeInsertedForFiviseReputaionManager);

            }
        // return true;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;
    }
    //=================================================================================================================================

    //==============================================================================================================
    public boolean UpdateDisciplinePenalty(ArrayList<DisciplineTypeModel> disciplinePenaltyList) {
        ArrayList<DisciplineTypeModel> update = new ArrayList<DisciplineTypeModel>();
        try {
            for (int counter = 0; counter < disciplinePenaltyList.size(); counter++) {
                update.add(disciplinePenaltyList.get(counter));
            }

            return disciplineRegistrationEntity.updateDisciplinePenalities(update);
        } catch (SQLException ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    //============================================================================================================================
     public boolean DeleteDiscipline(ArrayList<DisciplineTypeModel> disciplinePenaltyList) {
         try{

           for (int counter = 0; counter < disciplinePenaltyList.size(); counter++) {

            if (disciplinePenaltyList.get(counter).getRepitition()==1) {
            disciplineRegistrationEntity.DeleteDisciplinePenalityRepOne(disciplinePenaltyList);
            }else if(disciplinePenaltyList.get(counter).getRepitition()==2){
             disciplineRegistrationEntity.DeleteDisciplinePenalityRepTwo(disciplinePenaltyList);
            }else if(disciplinePenaltyList.get(counter).getRepitition()==3){
            disciplineRegistrationEntity.DeleteDisciplinePenalityRepThree(disciplinePenaltyList); 
            }else if(disciplinePenaltyList.get(counter).getRepitition()==4){
            disciplineRegistrationEntity.DeleteDisciplinePenalityRepFour(disciplinePenaltyList);
            }else if(disciplinePenaltyList.get(counter).getRepitition()==5){
                disciplineRegistrationEntity.DeleteDisciplinePenalityRepFive(disciplinePenaltyList);

           }

           }

           } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        return true;


    //===============================================================================================================================
    //</editor-fold>
}
}
