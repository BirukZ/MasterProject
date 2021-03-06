/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.userManagement.Entity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author 
 */
public class ResourcesEntity
        extends ConnectionManager {

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
    private static final long serialVersionUID = 1L;
    private Integer id;
    private String name,  newName;
    private String description;
    private String path;

    public ResourcesEntity() {
    }

    public ResourcesEntity(Integer id) {
        this.id = id;
    }

    public ResourcesEntity(Integer id, String name, String description, String path) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.path = path;
    }

    public ResourcesEntity(String name, String description, String path) {
        this.name = name;
        this.description = description;
        this.path = path;
    }

//    public static void main(String ar[]){
//        ResourcesEntity rs = new ResourcesEntity(1, "page1", "first page", "/page1") ;
//        rs.delete();
//        ResourcesEntity.getResourceFromFile(new File("./build/"));
//    }
//
    /**
     * Fetches all rows from tbl_resources
     * @return returns <b>ResultSet</b> object on successful completion
     * of the method, <b>null</b> otherwise
     */
    public ResultSet selectAllResources() {
        String _select = "SELECT resource_id, resource_name, resource_description, resource_path " +
                " FROM BIB.tbl_resources " +
                "  order by nlssort(resource_name,'NLS_SORT=BINARY_CI') ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE,    ResultSet.CONCUR_READ_ONLY);
            _rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(_rs);
            _rs.close();
            return ocrs;
        } catch (Exception _ex) {
            ErrorLogWriter.writeError(_ex);
            return null;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

    /**
     * Reads the value id attribute getting the resource path
     * @param _path the path of the resource
     * @return returns <b>id</b> as int positive integer on successful completion
     * of the method, <b>-1</b> otherwise
     */
    public int getId(String _path) {
        String _select = "SELECT resource_id FROM BIB.tbl_resources WHERE resource_path = ?";
        int _id = -1;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);//, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            _ps.setString(1, _path);
            _rs = _ps.executeQuery();
            _rs.next();
            if (_rs.getRow() > 0) {
                _id = _rs.getInt("resource_id");
            }
        } catch (Exception _ex) {
            ErrorLogWriter.writeError(_ex);
            return -1;

        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return _id;
    }

    /**
     * Updates row in tbl_resources identified by name
     * (Note: the caller must set id before calling this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     */
    public boolean update() {

        String _update = "UPDATE BIB.tbl_resources SET resource_name = ? , " +
                "resource_description = ?, path = ?" +
                " WHERE resource_id = ? ";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setString(1, getName());
            _ps.setString(2, getDescription());
            _ps.setString(3, getPath());
            _ps.setInt(4, getId());

            _ps.executeUpdate();
        } catch (Exception _ex) {
            ErrorLogWriter.writeError(_ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        return true;

    }

    /**
     * Adds a row into tbl_resources using name and description
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     */
    public int addNewResource(String name, String desc, String path) {
        //get hash value of the password and insert it

        String _insert = "INSERT INTO BIB.TBL_RESOURCES (RESOURCE_ID,RESOURCE_NAME, RESOURCE_DESCRIPTION, RESOURCE_PATH) " +
                " VALUES(BIB.TBL_RESOURCES_SEQ.NEXTVAL,'" + name + "','" + desc + "','" + path + "')";
        try {
            
          
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.executeUpdate();
            return 1;
        } catch (Exception _ex) {
            _ex.printStackTrace();
            ErrorLogWriter.writeError(_ex);
            return 0;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }


    }

    /**
     * Removes a row from tbl_resources identified by name
     * (Note: the caller should set id before calling
     * this method)
     * @return returns <b>true</b> object on successful completion
     * of the method, <b>false</b> otherwise
     */
    public boolean delete() {
        String _update = "DELETE FROM BIB.tbl_resources WHERE RESOURCE_id = ? ";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_update);
            _ps.setInt(1, getId());
            _ps.executeUpdate();
        } catch (Exception _ex) {
            ErrorLogWriter.writeError(_ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        return true;
    }

    //<editor-fold defaultstate="collapsed" desc="Getters, Setters and overides">
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNewName() {
        return newName;
    }

    public void setNewName(String newName) {
        this.newName = newName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ResourcesEntity)) {
            return false;
        }
        ResourcesEntity other = (ResourcesEntity) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Resources[id=" + id + "]";
    }
    //</editor-fold>
}