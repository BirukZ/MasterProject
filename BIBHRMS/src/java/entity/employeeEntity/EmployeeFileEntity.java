/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.rowset.OracleCachedRowSet;

/**
 *
 * @author ONEQAZ
 */
public class EmployeeFileEntity extends ConnectionManager {

    private String fileType;
    private String fileName;
    private String remark;
    private String employeeId;
    private String fileId;
    private String fileLocation;
    private String fileExtension;
    private byte[] file;

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileLocation() {
        return fileLocation;
    }

    public void setFileLocation(String fileLocation) {
        this.fileLocation = fileLocation;
    }

    public EmployeeFileEntity() {
    }

    public EmployeeFileEntity(String fileType, String fileName, String remark,
            String employeeId, String fileId, byte[] file, String fileExtension) {
        this.fileType = fileType;
        this.fileName = fileName;
        this.remark = remark;
        this.employeeId = employeeId;
        this.fileId = fileId;
        this.file = file;
        this.fileExtension = fileExtension;
    }

    public int saveEmployeeFile(EmployeeFileEntity employeeFileEntity) {
        int checkSave = 0;
        String _select = "INSERT INTO HR_EMP_FILE " +
                "  ( " +
                "    FILENAME, " +
                "    FILETYPE," +
                "    EMP_ID, " +
                "    REMARK, " +
                "    EMPFILE," +
                "    FILEEXTENSION" +
                "  ) " +
                "  VALUES (?,?,?,?,?,?) ";
        PreparedStatement _ps = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeFileEntity.getFileName());
            _ps.setString(2, employeeFileEntity.getFileType());
            _ps.setString(3, employeeFileEntity.getEmployeeId());
            _ps.setString(4, employeeFileEntity.getRemark());
            _ps.setBytes(5, employeeFileEntity.getFile());
            _ps.setString(6, employeeFileEntity.getFileExtension());
            checkSave = _ps.executeUpdate();
            _ps.close();
            closePooledConnections(_con);
            return checkSave;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return checkSave;
    }

    public int updateEmployeeFile(EmployeeFileEntity employeeFileEntity) {
        int checkSave = 0;
        String _select = "UPDATE  HR_EMP_FILE " +
                "   SET " +
                "    FILENAME=?,              " +
                "    FILETYPE=?,              " +
                "    EMP_ID=?,                " +
                "    REMARK=?,                " +
                "    EMPFILE=?,               " +
                "    FILEEXTENSION=?          " +
                "  WHERE ID=?                 ";

        PreparedStatement _ps = null;
        Connection _con = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeFileEntity.getFileName());
            _ps.setString(2, employeeFileEntity.getFileType());
            _ps.setString(3, employeeFileEntity.getEmployeeId());
            _ps.setString(4, employeeFileEntity.getRemark());
            _ps.setBytes(5, employeeFileEntity.getFile());
            _ps.setString(6, employeeFileEntity.getFileExtension());
            _ps.setString(7, employeeFileEntity.getFileId());
            checkSave = _ps.executeUpdate();
            _ps.close();
            closePooledConnections(_con);
            return checkSave;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return checkSave;
    }

    public ArrayList<HashMap> readEmployeeFile(String employeeId) {
        ArrayList<HashMap> listEmployeeFile = new ArrayList<HashMap>();
        String _select = "SELECT " +
                " ID," +
                " FILETYPE," +
                " nvl(REMARK,'no remark') REMARK," +
                " FILENAME," +
                " EMPFILE," +
                " EMP_ID," +
                " FILEEXTENSION FROM HR_EMP_FILE " +
                "  WHERE EMP_ID=?";

        PreparedStatement _ps = null;
        Connection _con = null;
        ResultSet rs = null;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeId);
            rs = _ps.executeQuery();
            OracleCachedRowSet ocrs = new OracleCachedRowSet();
            ocrs.populate(rs);
            while (ocrs.next()) {
                HashMap hm = new HashMap();

                hm.put("ID", ocrs.getString("ID"));
                hm.put("FILETYPE", ocrs.getString("FILETYPE"));
                hm.put("REMARK", ocrs.getString("REMARK"));
                hm.put("FILENAME", ocrs.getString("FILENAME"));
                hm.put("EMPFILE", ocrs.getBlob("EMPFILE"));
                hm.put("EMP_ID", ocrs.getString("EMP_ID"));
                hm.put("FILEEXTENSION", ocrs.getString("FILEEXTENSION"));
                listEmployeeFile.add(hm);
            }
            rs.close();
            _ps.close();
            closePooledConnections(_con);
            return listEmployeeFile;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();
        }
        return null;
    }



    /**
     * The method removes a row of data from the hr_employee_info table using
     * the refernceId
     * @param refernceId
     * @return either (1) the row count for SQL Data Manipulation Language (DML) statements
     *         or (2) 0 for SQL statements that return nothing
     */
    public int deleteEmployeeFile(String fileId) {
        String _deletet = "DELETE FROM HR_EMP_FILE WHERE ID=?";
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        Connection _con = null;
        int check;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, fileId);
            check = ps.executeUpdate();
            ps.close();
            closePooledConnections(_con);
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        }

        return 0;
    }
}
