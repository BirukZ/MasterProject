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
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author Preferred Customer
 */
public class TrainingTypeEntity extends ConnectionManager{

    private String trainingTypeId;
    private String description;
    private String categoryID;
    private String parentTrainingType;
  
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

    public TrainingTypeEntity(String description, String remark) {
        this.description = description;
        this.remark = remark;

    }

    public TrainingTypeEntity(String trainingTypeId, String description, String remark) {
        this.description = description;
        this.remark = remark;
        this.trainingTypeId = trainingTypeId;
       

    }

    /**
     *
     * @param description
     * @param categoryID
     * @param parentTrainingType
     * @param remark
     */
    public TrainingTypeEntity(String trainingTypeId,String description, String remark,String categoryID) {
        this.trainingTypeId = trainingTypeId;
        this.description = description;
        this.remark = remark;
        this.categoryID = categoryID;
    }
    private String remark;

    /**
     *
     */
    public TrainingTypeEntity() {
    }

    /**
     *
     * @param trainingTypeId
     */
    public TrainingTypeEntity(String trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    /**
     *
     * @param trainingTypeId
     * @param description
     * @param categoryID
     * @param parentTrainingType
     * @param remark
     */
    public TrainingTypeEntity(String trainingTypeId, String description, String awardId, String parentTrainingType, String remark) {
        this.trainingTypeId = trainingTypeId;
        this.description = description;
        this.categoryID = awardId;
        this.parentTrainingType = parentTrainingType;
        this.remark = remark;
    }

    /**
     *
     * @return
     */
    public TrainingTypeEntity read() {
        ResultSet rs = null;
        TrainingTypeEntity trainingType = null;
        try {
            _con = getConnection();
            String selectTrainee = "SELECT t.trainer_id, t.name, t.contact_person, t.remark FROM tbl_trainer t;";
            PreparedStatement ps = _con.prepareStatement(selectTrainee);
            rs = ps.executeQuery();
            while (rs.next()) {
                TrainingTypeEntity traineeEntiry = new TrainingTypeEntity(rs.getString("trainer_id"), rs.getString("name"),
                        rs.getString("contact_person"), rs.getString("remark"));
                trainingType = traineeEntiry;
            }
            return trainingType;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    /**
     *
     * @return
     * @throws java.sql.SQLException
     */
    public ResultSet readAllTrainingTypes() throws SQLException {
        ResultSet rs = null;
        _con = getConnection();
        String selectTrainingType = "SELECT t.training_type_id, t.description, " +
                "t.remark " +
                " FROM tbl_training_type t";
        PreparedStatement ps = _con.prepareStatement(selectTrainingType);
        rs = ps.executeQuery();
        return rs;
    }

    public ResultSet readAllTrainingCategory() throws SQLException {
        ResultSet rs = null;
        _con = getConnection();
        String selectTrainingType = "SELECT t.category_id, t.name " +
                " FROM tbl_training_category t";
        PreparedStatement ps = _con.prepareStatement(selectTrainingType);
        rs = ps.executeQuery();
        return rs;
    }

       /**menawe tedarr yamewatlen almselashem
     * gen yat katama nwe yaleshew
     *
     * @return
     * @throws java.sql.SQLException
     */
    public OracleCachedRowSet search() throws Exception {
        ResultSet rs = null;
        _con = getConnection();
        String selectTrainee = "SELECT t.training_type_id, t.description, " +
                "t.remark, t.category " +
                "FROM tbl_training_type t WHERE t.training_type_id = ?";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        ps.setString(1, this.getTrainingTypeId());
        rs = ps.executeQuery();
        OracleCachedRowSet ocrs = new OracleCachedRowSet();
        ocrs.populate(rs);
        rs.close();
        closePooledConnections(_con);
        return ocrs;
    }

    public ResultSet searchCategory() throws SQLException {
        ResultSet rs = null;
        _con = getConnection();

        String selectTrainee = "SELECT t.category_id, t.name, " +
                "t.remark " +
                "FROM tbl_training_category t WHERE t.category_id = ?";
        PreparedStatement ps = _con.prepareStatement(selectTrainee);
        ps.setString(1, this.getTrainingTypeId());
        rs = ps.executeQuery();

        return rs;
    }

    /**
     *
     * @param newOrOld
     * @throws java.sql.SQLException
     */
    public int addTrainingType() {
        try {
            int returnType = 0;
            if (this.addTrainingType(this) == 1) {
                returnType = 1;
            }
            return returnType;
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public int updateTrainingType() {
        try {
            int returnType = 0;
            if (this.updateTrainingType(this) == 1) {
                returnType = 1;
            }
            return returnType;
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public int addCategory() {
        try {
            int returnType = 0;
            if (this.addTrainingCategory(this) == 1) {
                returnType = 1;
            }
            return returnType;
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    public int updateTrainingCategory() {
        try {
            int returnType = 0;
            if (this.updateTrainingCategory(this) == 1) {
                returnType = 1;
            }
            return returnType;
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
    }

    /**
     *
     * @return
     */
    public boolean delete() {
        return this.deleteTrainingType(trainingTypeId);
    }

    /**
     * @return the trainingTypeId
     */
    public String getTrainingTypeId() {
        return trainingTypeId;
    }

    /**
     * @param trainingTypeId the trainingTypeId to set
     */
    public void setTrainingTypeId(String trainingTypeId) {
        this.trainingTypeId = trainingTypeId;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(String categoryID) {
        this.categoryID = categoryID;
    }

   

    /**
     * @return the parentTrainingType
     */
    public String getParentTrainingType() {
        return parentTrainingType;
    }

    /**
     * @param parentTrainingType the parentTrainingType to set
     */
    public void setParentTrainingType(String parentTrainingType) {
        this.parentTrainingType = parentTrainingType;
    }

    /**
     * @return the remark
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark the remark to set
     */
    public void setRemark(String remark) {
        this.remark = remark;
    }

    private int addTrainingType(TrainingTypeEntity trainingType) {
        try {
            _con = getConnection();
//            String str = "INSERT INTO tbl_training_type (description, " +
//                    "remark,category) values(?, ?, ?)";

           String str = "INSERT INTO TBL_TRAINING_TYPE (DESCRIPTION,REMARK,CATEGORY) values(?,?,?)";

            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingType.getDescription());
            ps.setString(2, trainingType.getRemark());
            ps.setString(3, trainingType.getTrainingTypeId());
            return ps.executeUpdate();

        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }

    }

    private int addTrainingCategory(TrainingTypeEntity trainingType) {
        try {
            _con = getConnection();
            String str = "INSERT INTO TBL_TRAINING_CATEGORY (CATEGORY_ID,name,remark) values(TBL_TRAINING_CATEGORY_SEQ.NEXTVAL,?,?)";

            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingType.getDescription());
            ps.setString(2, trainingType.getRemark());
            return ps.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }

    }

    private boolean deleteTrainingType(String trainingTypeId) {
        boolean deleted = false;


        String str = "DELETE FROM tbl_training_type WHERE training_type_id=?";

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingTypeId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                deleted = true;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }
        return deleted;
    }

    private int updateTrainingType(TrainingTypeEntity trainingType) {
        try {
            _con = getConnection();
            String str = "UPDATE TBL_TRAINING_TYPE SET DESCRIPTION = ? ," +
                    " REMARK = ?, category= ? WHERE TRAINING_TYPE_ID = '" + trainingType.getTrainingTypeId() + "'";

            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1,  trainingType.getDescription());
            ps.setString(2,  trainingType.getRemark());
            ps.setString(3,trainingType.getCategoryID());

            return ps.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }

    }

    private int updateTrainingCategory(TrainingTypeEntity trainingcategory) {
        try {

            String str = "UPDATE TBL_TRAINING_CATEGORY SET NAME = ?, " +
                    " REMARK = ? WHERE CATEGORY_ID = '" + trainingcategory.getTrainingTypeId() + "'";
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingcategory.getDescription());
            ps.setString(2, trainingcategory.getRemark());

            return ps.executeUpdate();
        } catch (Exception ex) {
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
          }

    }

    /** Accepts the training type description prefix  Then Search
     * training type description that starts with trainingtypePrefix
     * @param trainingtypePrefix String
     * @return list of training type description ResultSet for sucessful
     * completion or  Null if not
     * @throws java.sql.SQLException
     */
    public ResultSet searchTrainingTypeDescription(String trainingtypePrefix) throws SQLException {
        _con = getConnection();
        PreparedStatement _psSelect = null;
        ResultSet _resultSet = null;

        String sql = " SELECT training_type_id, description FROM tbl_training_type " +
                " WHERE description LIKE ?";
        _psSelect = _con.prepareStatement(sql);
        _psSelect.setString(1, trainingtypePrefix + "%");
        _resultSet = _psSelect.executeQuery();

        return _resultSet;
    }
public int saveTrainingType(TrainingTypeEntity trainingType) {
        int rowAffected = 0;
        try {
            _con = getConnection();
            String str = "INSERT INTO tbl_training_type (description, " +
                    "remark,category) values(?, ?, ?)";

            PreparedStatement ps = _con.prepareStatement(str);
            ps.setString(1, trainingType.getDescription());
            ps.setString(2, trainingType.getRemark());
            ps.setString(3, trainingType.getTrainingTypeId());
            rowAffected = ps.executeUpdate();
            closePooledConnections(_con);
            return rowAffected;
        } catch (Exception ex) {
            return rowAffected;
        }

    }
  
}