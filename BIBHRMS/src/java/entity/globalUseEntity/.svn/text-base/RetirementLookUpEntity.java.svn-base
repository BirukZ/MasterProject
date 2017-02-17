/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.globalUseEntity;

import connectionProvider.ConnectionManager;
import connectionProvider.ConnectionManager;
import java.util.logging.Level;
import java.util.logging.Logger;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author DPClone
 */
public class RetirementLookUpEntity extends ConnectionManager {

    static {
        try {
            //ConnectionManager.setDB(ConnectionManager.getConnectionInfo("fpdba", "fpinsa"));
        } catch (Exception ex) {
        }
    }
    Connection _con = null;
    ResultSet _rs = null;
    PreparedStatement _ps = null;

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
    ConnectionManager connectionManager;// = new ConnectionManager();
    private String resignTypeId;

    public String getResignTypeId() {
        return resignTypeId;
    }

    public void setResignTypeId(String resignTypeId) {
        this.resignTypeId = resignTypeId;
    }
    private String resignType;

    public String getResignType() {
        return resignType;
    }

    public void setResignType(String resignType) {
        this.resignType = resignType;
    }
    private String resignationDescription;

    public String getResignationDescription() {
        return resignationDescription;
    }

    public void setResignationDescription(String resignationDescription) {
        this.resignationDescription = resignationDescription;
    }
    private String resignsTypeList;

    public String getResignsTypeList() {
        return resignsTypeList;
    }

    public void setResignsTypeList(String resignsTypeList) {
        this.resignsTypeList = resignsTypeList;
    }
    private String group_setting;

    public String getGroup_setting() {
        return group_setting;
    }

    public void setGroup_setting(String group_setting) {
        this.group_setting = group_setting;
    }

    public RetirementLookUpEntity() {
    }

    public RetirementLookUpEntity(String _resignTypeId) {
        this.resignTypeId = _resignTypeId;
    }

    public RetirementLookUpEntity(String _resignTypeId, String _resignsTypeList) {
        this.resignTypeId = _resignTypeId;
        this.resignsTypeList = _resignsTypeList;
    }

    public RetirementLookUpEntity(String _resignTypeId, String _resignType, String _resignTypeDescription, String group_Setting) {
        this.resignTypeId = _resignTypeId;
        this.resignType = _resignType;
        this.resignationDescription = _resignTypeDescription;
        this.group_setting = group_Setting;
    }

    public RetirementLookUpEntity(String _resignTypeId, String _resignType, String _resignTypeDescription) {
        this.resignTypeId = _resignTypeId;
        this.resignType = _resignType;
        this.resignationDescription = _resignTypeDescription;
    }

    public ArrayList<RetirementLookUpEntity> readResignType(String val) {
        String _select = "SELECT termination_Type_ID,termination_Type FROM hr_termination_settings where group_setting='" + val + "'";
       
        
        
        ArrayList<RetirementLookUpEntity> resignationType = new ArrayList<RetirementLookUpEntity>();
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(_select);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                this.resignTypeId = _rs.getString("termination_Type_ID");
                this.resignsTypeList = _rs.getString("termination_Type");
                RetirementLookUpEntity userEntity = new RetirementLookUpEntity(resignTypeId, resignsTypeList);
                resignationType.add(userEntity);
            }
            _rs.close();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return resignationType;
    }

    public RetirementLookUpEntity readResignationTypeDetails(String _resignID) {
        String qry = "SELECT *FROM HR_TERMINATION_RESIGN_TYPES WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
       
        
        
        RetirementLookUpEntity retirementLookUpEntity = null;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                retirementLookUpEntity = new RetirementLookUpEntity(_rs.getString("TERMINATION_TYPE_ID"),
                        _rs.getString("TERMINATION_TYPE"),
                        _rs.getString("DESCRIPTION"),
                        _rs.getString("GROUP_TYPE"));

            }
            _rs.close();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
            return retirementLookUpEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public RetirementLookUpEntity readRetireTypeDetails(String _resignID) {
        String qry = "SELECT *FROM HR_TERMINATION_RETIRE_TYPES WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
       
        
        
        RetirementLookUpEntity retirementLookUpEntity = null;
        try {
            _con = connectionManager.getConnection();
            _ps = _con.prepareStatement(qry);
            _rs = _ps.executeQuery();
            if (_rs.next()) {
                retirementLookUpEntity = new RetirementLookUpEntity(_rs.getString("TERMINATION_TYPE_ID"),
                        _rs.getString("TERMINATION_TYPE"),
                        _rs.getString("DESCRIPTION"));

            }
            _rs.close();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
            return retirementLookUpEntity;
        } catch (Exception ex) {
            ex.printStackTrace();
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

    public int addNewTerminationType(String _resignationName, String _resignationDescription, String group_setting) {
        String qry = "INSERT INTO HR_TERMINATION_RESIGN_TYPES(TERMINATION_TYPE,DESCRIPTION,GROUP_TYPE) " +
                " VALUES('" + _resignationName + "', '" + _resignationDescription + "', '" + group_setting + "') ";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.executeUpdate();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 1;
    }

    public int addNewRetireType(String _resignationName, String _resignationDescription)  {
        String qry = "INSERT INTO HR_TERMINATION_RETIRE_TYPES(TERMINATION_TYPE,DESCRIPTION) " +
                " VALUES('" + _resignationName + "', '" + _resignationDescription + "') ";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.executeUpdate();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 1;
    }

    public int updateResignationType(String _resignID, String _resignationType, String _resignationDescription, String group_Setting) {
        String qry = "UPDATE HR_TERMINATION_RESIGN_TYPES SET TERMINATION_TYPE='" + _resignationType + "', DESCRIPTION='" + _resignationDescription + "',GROUP_TYPE='" + group_Setting + "' WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.executeUpdate();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
               ex.printStackTrace();
            }
        }
        return 1;
    }

    public int updateRetireType(String _resignID, String _resignationType, String _resignationDescription) {
        String qry = "UPDATE HR_TERMINATION_RETIRE_TYPES SET TERMINATION_TYPE='" + _resignationType + "', DESCRIPTION='" + _resignationDescription + "' WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.executeUpdate();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 1;
    }

    public boolean deleteResignationType(String _resignID) {
        String qry = "DELETE FROM HR_TERMINATION_RESIGN_TYPES WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.execute();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    public boolean deleteRetireType(String _resignID) {
        String qry = "DELETE FROM HR_TERMINATION_RETIRE_TYPES WHERE TERMINATION_TYPE_ID = '" + _resignID + "'";
        try {
            
            _con = connectionManager.getConnection();
            PreparedStatement _ps = _con.prepareStatement(qry);
            _ps.execute();
            _ps.close();
           // connectionManager.closePooledConnections(_con);
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
        finally{
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }
}
