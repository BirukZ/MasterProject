
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.disciplineEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.disciplineManager.DisciplineRegistrationManager.DisciplineTypeModel;
import manager.disciplineManager.DisciplineRegistrationManager.ManagerDisciplineModel;
import manager.disciplineManager.PenaltyRegistrationManager.PenaltyTypeModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author BravoZulu
 */
public class DisciplinePenaltyRegistrationEntity
        extends ConnectionManager {

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
//========================================================================================================================================================

    public boolean insertDisciplinePenalities(ArrayList<DisciplineTypeModel> PenaltyOfDisciplineType) throws SQLException {
        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIPLINED_TYPE_REPITITION " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPITITION_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = PenaltyOfDisciplineType.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, PenaltyOfDisciplineType.get(counter).getDisciplineTypeId());
                _ps.setInt(2, PenaltyOfDisciplineType.get(counter).getRepitition());
                _ps.setString(3, PenaltyOfDisciplineType.get(counter).getPenaltyTypeId());
                _ps.setString(4, PenaltyOfDisciplineType.get(counter).getSuspendedFrom());
                _ps.setString(5, PenaltyOfDisciplineType.get(counter).getSuspendedDuration());
                _ps.setString(6, "Old");

                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }
//=================================================================================================================================================

    public boolean saveDisciplinePenaltyFirstreputaion(ArrayList<DisciplineTypeModel> toBeInsertedForFirstRepition) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIPLINED_TYPE_REPITITION " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FIRST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (DisciplineTypeModel currentPenalityList : toBeInsertedForFirstRepition) {
                _ps.setInt(1, currentPenalityList.getDisciplineTypeId());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3,currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
              
            }
            int cheak[] = _ps.executeBatch();
  System.out.println(_insertDisciplineProblemQuery);
            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================
    //=============================================This is the First Repuataion For The Manager======================================================

    public boolean saveDisciplinePenaltyFirstreputaionForManager(ArrayList<ManagerDisciplineModel> toBeInsertedForFirstRepition) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIPLINED_TYPE_REP_MAN " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FIRST_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (ManagerDisciplineModel currentPenalityList : toBeInsertedForFirstRepition) {
                _ps.setString(1, currentPenalityList.getDisciplineTypeCode());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================

    public boolean saveDisciplinePenaltySecondReputaion(ArrayList<DisciplineTypeModel> toBeInsertedForSecondRepution) throws SQLException {


        String _insertDisciplineProblemQuery = " INSERT INTO  HR_DISCIP_TYPE_REPI_SECOND " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_SECOND_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (DisciplineTypeModel currentPenalityList : toBeInsertedForSecondRepution) {

                _ps.setInt(1, currentPenalityList.getDisciplineTypeId());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");
                _ps.addBatch();
            }

            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //================================================================================================================================================
    //===============================================This is the Second Reputaion for the Manager=====================================================

    public boolean saveDisciplinePenaltySecondReputaionForManager(ArrayList<ManagerDisciplineModel> toBeInsertedForSecondRepution) throws SQLException {


        String _insertDisciplineProblemQuery = " INSERT INTO  HR_DISCIP_TYPE_REPI_SECOND_MNG " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_SECOND_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (ManagerDisciplineModel currentPenalityList : toBeInsertedForSecondRepution) {

                _ps.setString(1, currentPenalityList.getDisciplineTypeCode());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");
                _ps.addBatch();
            }

            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    //=================================================================================================================================================
    public boolean saveDisciplinePenaltyThiredReputaion(ArrayList<DisciplineTypeModel> toBeInsertedForThiredRepution) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_THIRD " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_THIRD_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);


            for (DisciplineTypeModel currentPenalityList : toBeInsertedForThiredRepution) {
                _ps.setInt(1, currentPenalityList.getDisciplineTypeId());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //===================================================This is the Thired Reputaion for the Manager===============================================

    public boolean saveDisciplinePenaltyThiredReputaionForManager(ArrayList<ManagerDisciplineModel> toBeInsertedForThiredRepution) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_THIRD_MNG " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_THIRD_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);


            for (ManagerDisciplineModel currentPenalityList : toBeInsertedForThiredRepution) {
                _ps.setString(1, currentPenalityList.getDisciplineTypeCode());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //==============================================================================================================================================
    //================================================================================================================================================

    public boolean saveDisciplinePenaltyForthReputaion(ArrayList<DisciplineTypeModel> toBeInsertedForForthReputaion) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_FORTH " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FORTH_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (DisciplineTypeModel currentPenalityList : toBeInsertedForForthReputaion) {
                _ps.setInt(1, currentPenalityList.getDisciplineTypeId());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");


                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //===========================================================FourthReputaionFormanager=======================================================================

    public boolean saveDisciplinePenaltyForthReputaionForManager(ArrayList<ManagerDisciplineModel> toBeInsertedForForthReputaion) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_FORTH_MNG " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FORTH_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (ManagerDisciplineModel currentPenalityList : toBeInsertedForForthReputaion) {
                _ps.setString(1, currentPenalityList.getDisciplineTypeCode());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");


                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //=============================================================================================================================================================

    public boolean saveDisciplinePenaltyFivesReputaion(ArrayList<DisciplineTypeModel> toBeInsertedForfivesReputaion) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_FIVES " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FIVES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (DisciplineTypeModel currentPenalityList : toBeInsertedForfivesReputaion) {
                _ps.setInt(1, currentPenalityList.getDisciplineTypeId());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //=============================================================================================================================================
    //============================================================Fives Reputaion for the Manager==================================================

    public boolean saveDisciplinePenaltyFivesReputaionFor(ArrayList<ManagerDisciplineModel> toBeInsertedForfivesReputaion) throws SQLException {

        String _insertDisciplineProblemQuery = "INSERT INTO HR_DISCIP_TYPE_REPI_FIVES_MNG " +
                " ( DISCIPLINED_TYPE_REPITITION_ID,DESCIPLINE_TYPE,REPITITION,PENALTY,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS )" +
                " VALUES(HR_DICIPLINED_REPI_FIVES_SEQ.NEXTVAL,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);

            for (ManagerDisciplineModel currentPenalityList : toBeInsertedForfivesReputaion) {
                _ps.setString(1, currentPenalityList.getDisciplineTypeCode());
                _ps.setInt(2, currentPenalityList.getRepitition());
                _ps.setString(3, currentPenalityList.getPenaltyTypeId());
                _ps.setString(4, currentPenalityList.getSuspendedFrom());
                _ps.setString(5, currentPenalityList.getSuspendedDuration());
                _ps.setString(6, currentPenalityList.getSuspendedTransfer());
                _ps.setString(7, currentPenalityList.getTransferDuration());
                _ps.setString(8, "Old");

                _ps.addBatch();
            }
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }
    //=============================================================================================================================================

    public boolean saveProcess(String processID, String processName, String processDescription) throws SQLException {
        String _insertProcessRegistrationQuery = "INSERT INTO HR_LU_PROCESS_TYPE " +
                " ( PROCESS_ID,PROCESS_CODE,PROCESS_NAME,PROCESS_DESC ) " +
                " VALUES(HR_PROCESS_SEQ.NEXTVAL,?,?,?)";


        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertProcessRegistrationQuery);
            _ps.setString(1, processID);
            _ps.setString(2, processName);
            _ps.setString(3, processDescription);
            _ps.execute();
            return true;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllProcessType() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PROCESS_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    boolean tray = true;

    public boolean updateDisciplinePenalities(ArrayList<DisciplineTypeModel> toBeUpdate) throws SQLException {

        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIPLINED_TYPE_REPITITION  SET " +
                "PROCESS_NAME=?," +
                "DURATION=?, " +
                "PROCESS_TRANSFER =?," +
                "DURATION_TRANSFER =?" +
                "WHERE DISCIPLINED_TYPE_REPITITION_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (DisciplineTypeModel currentPenalityList : toBeUpdate) {
                _ps.setString(1, currentPenalityList.getSuspendedFrom());
                _ps.setString(2, currentPenalityList.getSuspendedDuration());
                _ps.setString(3, currentPenalityList.getSuspendedTransfer());
                _ps.setString(4, currentPenalityList.getTransferDuration());
                _ps.setInt(5, currentPenalityList.getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
//            _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {

                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplinePenalitiesReptionTwo(ArrayList<DisciplineTypeModel> toBeUPdateRep2) throws SQLException {
        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIP_TYPE_REPI_SECOND  SET " +
                "PROCESS_NAME=?," +
                "DURATION=?, " +
                "PROCESS_TRANSFER =?," +
                "DURATION_TRANSFER =?" +
                "WHERE DISCIPLINED_TYPE_REPITITION_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (DisciplineTypeModel currentPenalityList : toBeUPdateRep2) {
                _ps.setString(1, currentPenalityList.getSuspendedFrom());
                _ps.setString(2, currentPenalityList.getSuspendedDuration());
                _ps.setString(3, currentPenalityList.getSuspendedTransfer());
                _ps.setString(4, currentPenalityList.getTransferDuration());
                _ps.setInt(5, currentPenalityList.getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
//            _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {
                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplinePenalitiesReputaionFive(ArrayList<DisciplineTypeModel> toBeUPdateRep5) throws SQLException {
        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIP_TYPE_REPI_FIVES  SET " +
                "PROCESS_NAME=?," +
                "DURATION=?, " +
                "PROCESS_TRANSFER =?," +
                "DURATION_TRANSFER =?" +
                "WHERE DISCIPLINED_TYPE_REPITITION_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (DisciplineTypeModel currentPenalityList : toBeUPdateRep5) {
                _ps.setString(1, currentPenalityList.getSuspendedFrom());
                _ps.setString(2, currentPenalityList.getSuspendedDuration());
                _ps.setString(3, currentPenalityList.getSuspendedTransfer());
                _ps.setString(4, currentPenalityList.getTransferDuration());
                _ps.setInt(5, currentPenalityList.getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
//            _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {
                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplinePenalitiesReputaionFour(ArrayList<DisciplineTypeModel> toBeUPdateRep4) throws SQLException {
        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIP_TYPE_REPI_FORTH  SET " +
                "PROCESS_NAME=?," +
                "DURATION=?, " +
                "PROCESS_TRANSFER =?," +
                "DURATION_TRANSFER =?" +
                "WHERE DISCIPLINED_TYPE_REPITITION_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (DisciplineTypeModel currentPenalityList : toBeUPdateRep4) {
                _ps.setString(1, currentPenalityList.getSuspendedFrom());
                _ps.setString(2, currentPenalityList.getSuspendedDuration());
                _ps.setString(3, currentPenalityList.getSuspendedTransfer());
                _ps.setString(4, currentPenalityList.getTransferDuration());
                _ps.setInt(5, currentPenalityList.getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
//            _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {
                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplinePenalitiesReputaionThree(ArrayList<DisciplineTypeModel> toBeUPdateRep3) throws SQLException {
        String _insertOtherWitnessUpdate = " UPDATE HR_DISCIP_TYPE_REPI_THIRD  SET " +
                "PROCESS_NAME=?," +
                "DURATION=?, " +
                "PROCESS_TRANSFER =?," +
                "DURATION_TRANSFER =?" +
                "WHERE DISCIPLINED_TYPE_REPITITION_ID =?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertOtherWitnessUpdate);
            for (DisciplineTypeModel currentPenalityList : toBeUPdateRep3) {
                _ps.setString(1, currentPenalityList.getSuspendedFrom());
                _ps.setString(2, currentPenalityList.getSuspendedDuration());
                _ps.setString(3, currentPenalityList.getSuspendedTransfer());
                _ps.setString(4, currentPenalityList.getTransferDuration());
                _ps.setInt(5, currentPenalityList.getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
//            _ps.executeBatch();
//            return true;
//        } finally {
//            releaseResources();
            int cheak[] = _ps.executeBatch();

            for (int i : cheak) {
                if (i <= 0) {
                    tray = false;
                }
            }
            return tray;

        } finally {
            releaseResources();
        }
    }

    public boolean updatePenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "UPDATE HR_LU_PENALTY_TYPE  SET " +
                " PENALTY_CODE=?, " +
                " PENALTY_NAME=?, " +
                " MONETARY_PENALTY_DAYS=?, " +
                " DESCRIPTION=?, " +
                " ACTION_TAKER=? " +
                " WHERE PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getNumberOfPenalisedDays());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                _ps.setString(5, penaltyTypeList.get(counter).getActionTaker());
                _ps.setInt(6, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   INSERT INTO HR_LU_DISCIPLINE_TYPE " +
                "(DESCIPLINE_TYPE_ID,DISCIPLINE_CODE,OFFENCE_NAME, DESCIPLINE_CATAGORY,DESCRIPTION,PHASEOUT_PERIOD)" +
                "VALUES(HR_LU_DISCIPLINE_TYPES_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {

                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertPenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertPenaltyType = "   INSERT INTO HR_LU_PENALTY_TYPE " +
                "(PENALTY_TYPE_ID,PENALTY_CODE,PENALTY_NAME,MONETARY_PENALTY_DAYS, DESCRIPTION,ACTION_TAKER)" +
                "VALUES(HR_LU_PENALTY_TYPE_SEQ.NEXTVAL,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertPenaltyType);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, penaltyTypeList.get(counter).getPenaltyTypeCode());
                _ps.setString(2, penaltyTypeList.get(counter).getPenaltyName());
                _ps.setFloat(3, penaltyTypeList.get(counter).getNumberOfPenalisedDays());
                _ps.setString(4, penaltyTypeList.get(counter).getPenaltyDescription());
                _ps.setString(5, penaltyTypeList.get(counter).getActionTaker());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_DISCIPLINE_TYPE " +
                " where DESCIPLINE_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplineTypeList.get(counter).getDisciplineTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteDisciplinePenalty(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_DISCIPLINED_TYPE_REPITITION " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplineTypeList.get(counter).getDisciplineTypeRepititionId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deletePenaltyTypes(ArrayList<PenaltyTypeModel> penaltyTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   DELETE HR_LU_PENALTY_TYPE " +
                " where PENALTY_TYPE_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = penaltyTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, penaltyTypeList.get(counter).getPenaltyTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateDisciplineTypes(ArrayList<DisciplineTypeModel> disciplineTypeList) throws SQLException {
        String _insertDisciplineProblemQuery = "   UPDATE HR_LU_DISCIPLINE_TYPE " +
                " SET DISCIPLINE_CODE=?,OFFENCE_NAME=?,DESCIPLINE_CATAGORY=?,DESCRIPTION=?,PHASEOUT_PERIOD=? " +
                " WHERE DESCIPLINE_TYPE_ID=?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplineTypeList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setString(1, disciplineTypeList.get(counter).getDisciplineTypeCode());
                _ps.setString(2, disciplineTypeList.get(counter).getDisciplineName());
                _ps.setString(3, disciplineTypeList.get(counter).getDisciplineCatagory());
                _ps.setString(4, disciplineTypeList.get(counter).getDescription());
                _ps.setString(5, disciplineTypeList.get(counter).getPhaseoutPeriod());
                _ps.setInt(6, disciplineTypeList.get(counter).getDisciplineTypeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllDisciplineTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_DISCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectAllProcessTypes() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PROCESS_TYPE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllPenaltyType() throws SQLException {
        String _selectQuery = " SELECT * FROM HR_LU_PENALTY_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    public ResultSet selectPenaltyOfOffence(String disciplineType, int repitition) throws SQLException {
        String _selectQuery = "SELECT PENALTY_NAME, DESCRIPTION " +
                "FROM HR_LU_PENALTY_TYPE " +
                "WHERE PENALTY_TYPE_ID IN " +
                "  (SELECT PENALTY " +
                "  FROM HR_DISCIPLINED_TYPE_REPITITION " +
                "  WHERE DESCIPLINE_TYPE=? " +
                "  AND REPITITION       =? " +
                "  )";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setString(1, disciplineType);
            _ps.setInt(2, repitition);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    /**
     *
     */
    public ResultSet selectAllPenaltyTypesDetail() throws SQLException {

        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS, " +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIPLINED_TYPE_REPITITION,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE hr_DISCIPLINED_TYPE_REPITITION.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIPLINED_TYPE_REPITITION.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //================================================First Selection For Manager=====================================================================

    public ResultSet selectAllPenaltyTypesDetailFitstForManager() throws SQLException {

        String _selectQuery = "SELECT DISCIPLINED_TYPE_REPITITION_ID, " +
                "  REPITITION, " +
                "  PENALTY, " +
                "  DESCIPLINE_TYPE, " +
                "  PROCESS_NAME, " +
                "  DURATION, " +
                "  PROCESS_TRANSFER, " +
                "  DURATION_TRANSFER, " +
                "  SAVED_SATUS, " +
                "  PENALTY_CODE, " +
                "  PENALTY_NAME, " +
                "  ACTION_TAKER, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION , " +
                "  OFFENCE_NAME, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  DISCIPLINE_CODE " +
                "FROM HR_DISCIPLINED_TYPE_REP_MAN, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE, " +
                "  HR_LU_MANAGEMENT_PENALTY_TYPE " +
                "WHERE HR_DISCIPLINED_TYPE_REP_MAN.DESCIPLINE_TYPE=HR_LU_MNG_DISCIPLINE_TYPE.DISCIPLINE_CODE " +
                "AND HR_DISCIPLINED_TYPE_REP_MAN.PENALTY=HR_LU_MANAGEMENT_PENALTY_TYPE.PENALTY_CODE " +
                "ORDER BY DISCIPLINE_CODE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //================================================================================================================================================

    public ResultSet selectAllPenaltyTypesDetailFives() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS, " +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIP_TYPE_REPI_FIVES,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE HR_DISCIP_TYPE_REPI_FIVES.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIP_TYPE_REPI_FIVES.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===========================================================SelectionForFives=====================================================================

    public ResultSet selectAllPenaltyTypesDetailFivesForManager() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID, " +
                "  REPITITION, " +
                "  PENALTY, " +
                "  DESCIPLINE_TYPE, " +
                "  PROCESS_NAME, " +
                "  DURATION, " +
                "  PROCESS_TRANSFER, " +
                "  DURATION_TRANSFER, " +
                "  SAVED_SATUS, " +
                "  PENALTY_CODE, " +
                "  PENALTY_NAME, " +
                "  ACTION_TAKER, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION , " +
                "  OFFENCE_NAME, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  DISCIPLINE_CODE " +
                " FROM HR_DISCIP_TYPE_REPI_FIVES_MNG, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE, " +
                "  HR_LU_MANAGEMENT_PENALTY_TYPE " +
                " WHERE HR_DISCIP_TYPE_REPI_FIVES_MNG.DESCIPLINE_TYPE=HR_LU_MNG_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                " AND HR_DISCIP_TYPE_REPI_FIVES_MNG.PENALTY=HR_LU_MANAGEMENT_PENALTY_TYPE.PENALTY_TYPE_ID " +
                " ORDER BY DESCIPLINE_TYPE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=================================================================================================================================================

    public ResultSet selectAllPenaltyTypesDetailForth() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS, " +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIP_TYPE_REPI_FORTH,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE HR_DISCIP_TYPE_REPI_FORTH.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIP_TYPE_REPI_FORTH.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //====================================================SelectionFourthForManager======================================================================

    public ResultSet selectAllPenaltyTypesDetailForthForManager() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID, " +
                "  REPITITION, " +
                "  PENALTY, " +
                "  DESCIPLINE_TYPE, " +
                "  PROCESS_NAME, " +
                "  DURATION, " +
                "  PROCESS_TRANSFER, " +
                "  DURATION_TRANSFER, " +
                "  SAVED_SATUS, " +
                "  PENALTY_CODE, " +
                "  PENALTY_NAME, " +
                "  ACTION_TAKER, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  OFFENCE_NAME, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  DISCIPLINE_CODE " +
                "  FROM HR_DISCIP_TYPE_REPI_FORTH_MNG, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE, " +
                "  HR_LU_MANAGEMENT_PENALTY_TYPE " +
                " WHERE HR_DISCIP_TYPE_REPI_FORTH_MNG.DESCIPLINE_TYPE=HR_LU_MNG_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                " AND HR_DISCIP_TYPE_REPI_FORTH_MNG.PENALTY=HR_LU_MANAGEMENT_PENALTY_TYPE.PENALTY_TYPE_ID " +
                " ORDER BY DESCIPLINE_TYPE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===================================================================================================================================================

    public ResultSet selectAllPenaltyTypesDetailSecond() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS, " +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIP_TYPE_REPI_SECOND,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE HR_DISCIP_TYPE_REPI_SECOND.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIP_TYPE_REPI_SECOND.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //=============================================================SelectionForManagerSecond=========================================================

    public ResultSet selectAllPenaltyTypesDetailSecondForManager() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID, " +
                "  REPITITION, " +
                "  PENALTY, " +
                "  DESCIPLINE_TYPE, " +
                "  PROCESS_NAME, " +
                "  DURATION, " +
                "  PROCESS_TRANSFER, " +
                "  DURATION_TRANSFER, " +
                "  SAVED_SATUS, " +
                "  PENALTY_CODE, " +
                "  PENALTY_NAME, " +
                "  ACTION_TAKER, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION , " +
                "  OFFENCE_NAME, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  DISCIPLINE_CODE " +
                "  FROM HR_DISCIP_TYPE_REPI_SECOND_MNG, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE, " +
                "  HR_LU_MANAGEMENT_PENALTY_TYPE " +
                " WHERE HR_DISCIP_TYPE_REPI_SECOND_MNG.DESCIPLINE_TYPE=HR_LU_MNG_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                " AND HR_DISCIP_TYPE_REPI_SECOND_MNG.PENALTY=HR_LU_MANAGEMENT_PENALTY_TYPE.PENALTY_TYPE_ID " +
                " ORDER BY DESCIPLINE_TYPE ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================

    public ResultSet selectAllPenaltyTypesDetailThired() throws SQLException {
        String _selectQuery = " SELECT DISCIPLINED_TYPE_REPITITION_ID,REPITITION,PENALTY,DESCIPLINE_TYPE,PROCESS_NAME,DURATION,PROCESS_TRANSFER,DURATION_TRANSFER,SAVED_SATUS, " +//from DISCIPLINED_TYPE_REPITITION_ID
                "               PENALTY_CODE, PENALTY_NAME, ACTION_TAKER, HR_LU_DISCIPLINE_TYPE.DESCRIPTION  , " +//from HR_LU_PENALTY_TYPE
                "               OFFENCE_NAME,HR_LU_DISCIPLINE_TYPE.DESCRIPTION,DISCIPLINE_CODE    " +//from HR_LU_DISCIPLINE_TYPE
                "               FROM HR_DISCIP_TYPE_REPI_THIRD,HR_LU_DISCIPLINE_TYPE,HR_LU_PENALTY_TYPE" +
                "               WHERE HR_DISCIP_TYPE_REPI_THIRD.DESCIPLINE_TYPE=HR_LU_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "               AND HR_DISCIP_TYPE_REPI_THIRD.PENALTY=HR_LU_PENALTY_TYPE.PENALTY_TYPE_ID" +
                "               ORDER BY  DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================

    public ResultSet selectAllPenaltyTypesDetailThiredForManager() throws SQLException {
        String _selectQuery = "SELECT DISCIPLINED_TYPE_REPITITION_ID, " +
                "  REPITITION, " +
                "  PENALTY, " +
                "  DESCIPLINE_TYPE, " +
                "  PROCESS_NAME, " +
                "  DURATION, " +
                "  PROCESS_TRANSFER, " +
                "  DURATION_TRANSFER, " +
                "  SAVED_SATUS, " +
                "  PENALTY_CODE, " +
                "  PENALTY_NAME, " +
                "  ACTION_TAKER, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION , " +
                "  OFFENCE_NAME, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE.DESCRIPTION, " +
                "  DISCIPLINE_CODE " +
                "FROM HR_DISCIP_TYPE_REPI_THIRD_MNG, " +
                "  HR_LU_MNG_DISCIPLINE_TYPE, " +
                "  HR_LU_MANAGEMENT_PENALTY_TYPE " +
                "WHERE HR_DISCIP_TYPE_REPI_THIRD_MNG.DESCIPLINE_TYPE=HR_LU_MNG_DISCIPLINE_TYPE.DESCIPLINE_TYPE_ID " +
                "AND HR_DISCIP_TYPE_REPI_THIRD_MNG.PENALTY          =HR_LU_MANAGEMENT_PENALTY_TYPE.PENALTY_TYPE_ID " +
                "ORDER BY DESCIPLINE_TYPE";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //===============================================================================================================================================

    public ResultSet selectPenaltyOfOffence(int decisiontype, String repitition) throws SQLException {
        String _selectQuery = "SELECT * " +
                " FROM HR_DISCIPLINED_TYPE_REPITITION " +
                " WHERE DECISIONER_TYPE=? AND REPITITION=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);

            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
    //============================================================================================

    public boolean DeleteDisciplinePenalityRepOne(ArrayList<DisciplineTypeModel> disciplinePenaltyList) throws SQLException {
        String _insertDisciplineProblemQuery = " DELETE HR_DISCIPLINED_TYPE_REPITITION " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenaltyList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenaltyList.get(counter).getDisciplineTypeRepititionId());

            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
    //============================================================================================

    public boolean DeleteDisciplinePenalityRepTwo(ArrayList<DisciplineTypeModel> disciplinePenaltyList) throws SQLException {
        String _insertDisciplineProblemQuery = " DELETE HR_DISCIP_TYPE_REPI_SECOND " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenaltyList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenaltyList.get(counter).getDisciplineTypeRepititionId());

            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
    //=============================================================================================

    public boolean DeleteDisciplinePenalityRepThree(ArrayList<DisciplineTypeModel> disciplinePenaltyList) throws SQLException {
        String _insertDisciplineProblemQuery = " DELETE HR_DISCIP_TYPE_REPI_THIRD " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenaltyList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenaltyList.get(counter).getDisciplineTypeRepititionId());

            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
    //============================================================================================

    public boolean DeleteDisciplinePenalityRepFour(ArrayList<DisciplineTypeModel> disciplinePenaltyList) throws SQLException {
        String _insertDisciplineProblemQuery = " DELETE HR_DISCIP_TYPE_REPI_FORTH " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenaltyList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenaltyList.get(counter).getDisciplineTypeRepititionId());

            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    //===========================================================================================
    public boolean DeleteDisciplinePenalityRepFive(ArrayList<DisciplineTypeModel> disciplinePenaltyList) throws SQLException {
        String _insertDisciplineProblemQuery = " DELETE HR_DISCIP_TYPE_REPI_FIVES " +
                " where DISCIPLINED_TYPE_REPITITION_ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertDisciplineProblemQuery);
            int lengthOfList = disciplinePenaltyList.size();
            for (int counter = 0; counter < lengthOfList; counter++) {
                _ps.setInt(1, disciplinePenaltyList.get(counter).getDisciplineTypeRepititionId());

            }
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }
    //=========================================================================================
}

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */