/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.trainingEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import manager.trainingManager.InternalTrainnersModel;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author mekete
 */
public class InternalTrainnersRegistrationEntity extends ConnectionManager {

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

    public boolean insertTrainnerGroupAttribute(InternalTrainnersModel trainnerGroupAttribute) throws SQLException {
        String _insertQuery = "INSERT INTO  HR_TRAIN_INTERNAL_TRAINNER " +
                " ( TRAINNER_GROUP_ID,TRAINNER_GROUP_NAME,TRAINING_CATEGORY,DESCRIPTION, " +
                " STATUS, USER_NAME, TIME_STAMP )" +
                " VALUES(HR_TRAIN_INTERNAL_TRAINNER_SEQ.NEXTVAL,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            _ps.setString(1, trainnerGroupAttribute.getTrainnerGroupName());
            _ps.setString(2, trainnerGroupAttribute.getTrainingCategory());
            _ps.setString(3, trainnerGroupAttribute.getDescription());
            _ps.setString(4, trainnerGroupAttribute.getTrainnerGroupStatus());
            _ps.setString(5, trainnerGroupAttribute.getUserName());
            _ps.setString(6, trainnerGroupAttribute.getTimeStamp());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainnerGroupAttribute(InternalTrainnersModel trainnerGroupAttribute) throws SQLException {
        String _updateQuery = "UPDATE   HR_TRAIN_INTERNAL_TRAINNER " +
                " SET  TRAINNER_GROUP_NAME = ? ," +
                " TRAINING_CATEGORY = ? , " +
                " DESCRIPTION =? , " +
                " STATUS =? ," +
                " USER_NAME = ? ," +
                " TIME_STAMP = ? " +
                " WHERE TRAINNER_GROUP_ID= ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            _ps.setString(1, trainnerGroupAttribute.getTrainnerGroupName());
            _ps.setString(2, trainnerGroupAttribute.getTrainingCategory());
            _ps.setString(3, trainnerGroupAttribute.getDescription());
            _ps.setString(4, trainnerGroupAttribute.getTrainnerGroupStatus());
            _ps.setString(5, trainnerGroupAttribute.getUserName());
            _ps.setString(6, trainnerGroupAttribute.getTimeStamp());
            _ps.setInt(7, trainnerGroupAttribute.getTrainnerGroupId());
            _ps.executeUpdate();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean insertTrainners(ArrayList<InternalTrainnersModel> trainnerList) throws SQLException {
        String _insertQuery = " INSERT INTO  HR_TRAIN_TRAINNER_EMPLOYEES " +
                " ( MEMBER_ID,EMPLOYEE_ID,RESPONSIBLITY,ASSIGNED_DATE, " +
                " STATUS, GROUP_ID, USER_NAME, TIME_STAMP )" +
                " VALUES(TRIAN_TRAINNER_EMPLOYEES_SEQ.NEXTVAL,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insertQuery);
            for (InternalTrainnersModel currentMemnber : trainnerList) {
                _ps.setString(1, currentMemnber.getEmployeeId());
                _ps.setString(2, currentMemnber.getEmployeeResponsibility());
                _ps.setString(3, currentMemnber.getAssignedDate());
                _ps.setString(4, currentMemnber.getMemberStatus());
                _ps.setInt(5, currentMemnber.getTrainnerGroupId());
                _ps.setString(6, currentMemnber.getUserName());
                _ps.setString(7, currentMemnber.getTimeStamp());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean updateTrainners(ArrayList<InternalTrainnersModel> trainnerList) throws SQLException {
        String _updateQuery = " UPDATE  HR_TRAIN_TRAINNER_EMPLOYEES " +
                " SET EMPLOYEE_ID= ? ,RESPONSIBLITY= ? ,ASSIGNED_DATE= ? , " +
                " STATUS = ? , USER_NAME= ? , TIME_STAMP = ? , " +
                " WHERE  MEMBER_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (InternalTrainnersModel currentMemnber : trainnerList) {
                _ps.setString(1, currentMemnber.getEmployeeId());
                _ps.setString(2, currentMemnber.getEmployeeResponsibility());
                _ps.setString(3, currentMemnber.getAssignedDate());
                _ps.setString(4, currentMemnber.getMemberStatus());
                _ps.setString(5, currentMemnber.getUserName());
                _ps.setString(6, currentMemnber.getTimeStamp());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    public boolean deleteTrainners(ArrayList<InternalTrainnersModel> trainnerList) throws SQLException {
        String _updateQuery = " DELETE  HR_TRAIN_TRAINNER_EMPLOYEES " +
                " WHERE  EMPLOYEE_ID = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_updateQuery);
            for (InternalTrainnersModel currentMemnber : trainnerList) {
                _ps.setString(1, currentMemnber.getEmployeeId());
                _ps.addBatch();
            }
            _ps.executeBatch();
            return true;
        } finally {
            releaseResources();
        }
    }

    //for select item
    public ResultSet selectAllInternalTrainnerGroups() throws SQLException {
        String _selectQuery = "SELECT * " +
                "FROM HR_LU_EDUC_INSTITUTION " +
                "WHERE LOCATION_CATEGORY = 'BIB' AND " +
                "EDUCATION_OR_TRAINING = 'BIB'";//either training or both
//                " SELECT * FROM HR_EDUC_INSTITUTION " +
//                " WHERE LOCATION_CATEGORY = 'MCE' AND EDUCATION_OR_TRAINING = 'TRAI'";//ACCREDITED_OR_NOT ='AC' AND  
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
    // for detail

//    public ResultSet selectInternalTrainnerGroup(int trainnerGroupId) throws SQLException {
//        String _selectQuery = " SELECT * FROM HR_TRAIN_INTERNAL_TRAINNER " +
//                " WHERE TRAINNER_GROUP_ID = ? " +
//                " ORDER BY TRAINNER_GROUP_NAME ";
//        try {
//            _con = getConnection();
//            _ps = _con.prepareStatement(_selectQuery);
//            _ps.setInt(1, trainnerGroupId);
//            _rs = _ps.executeQuery();
//            OracleCachedRowSet ocrs = new OracleCachedRowSet();
//            ocrs.populate(_rs);
//            return (ResultSet) ocrs;
//        } finally {
//            releaseResources();
//        }
//    }
//
    public ResultSet selectInternalTrainnerGroup(int trainnerGroupId) throws SQLException {
        String _selectQuery = " SELECT * FROM HR_EDUC_INSTITUTION " +
                " WHERE NSTITUTION_ID = ? " +
                " ORDER BY NSTITUTION_NAME ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, trainnerGroupId);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }

    //for data table
    public ResultSet selectTrainnerMembers(int trainnerGroupId) throws SQLException {
        String _selectQuery = "SELECT HR_TRAIN_TRAINNER_EMPLOYEES.*, " +
                "  FIRST_NAME, " +
                "  MIDDLE_NAME, " +
                "  LAST_NAME " +
                "FROM HR_TRAIN_TRAINNER_EMPLOYEES, " +
                "  VW_EMPLOYEE_BY_DEPARTMENT_LIST " +
                "WHERE VW_EMPLOYEE_BY_DEPARTMENT_LIST. EMP_ID = HR_TRAIN_TRAINNER_EMPLOYEES.EMPLOYEE_ID " +
                "AND HR_TRAIN_TRAINNER_EMPLOYEES.GROUP_ID     = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_selectQuery);
            _ps.setInt(1, trainnerGroupId);
            _rs = _ps.executeQuery();

            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            return (ResultSet) ocrs;
        } finally {
            releaseResources();
        }
    }
}
