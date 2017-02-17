/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.languageEntity;

import connectionProvider.ConnectionManager;
import manager.globalUseManager.ErrorLogWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import oracle.jdbc.driver.OracleResultSetMetaData;

/**
 *
 * @author Administrator
 */
public class LanguageEntity extends ConnectionManager {

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

    public LanguageEntity() {
    }
    String listening;
    String speaking;
    String reading;
    String writing;
    String languageType;
    String employeeId;
    String id;
    int check;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getLanguageType() {
        return languageType;
    }

    public void setLanguageType(String languageType) {
        this.languageType = languageType;
    }

    public String getListening() {
        return listening;
    }

    public void setListening(String listening) {
        this.listening = listening;
    }

    public String getReading() {
        return reading;
    }

    public void setReading(String reading) {
        this.reading = reading;
    }

    public String getSpeaking() {
        return speaking;
    }

    public void setSpeaking(String speaking) {
        this.speaking = speaking;
    }

    public String getWriting() {
        return writing;
    }

    public void setWriting(String writing) {
        this.writing = writing;
    }

    public LanguageEntity(String listening, String speaking, String reading, String writing, String languageType, String employeeId, String id) {
        this.listening = listening;
        this.speaking = speaking;
        this.reading = reading;
        this.writing = writing;
        this.languageType = languageType;
        this.employeeId = employeeId;
        this.id = id;
    }

    public LanguageEntity(String listening, String speaking, String reading, String writing, String languageType, String employeeId) {
        this.listening = listening;
        this.speaking = speaking;
        this.reading = reading;
        this.writing = writing;
        this.languageType = languageType;
        this.employeeId = employeeId;
    }

    public int saveEmployeeLanguage(LanguageEntity languageEntity) {
        int checkSave = 0;
        String _select = "INSERT INTO hr_emp_language " +
                "(emp_Id,LANGUAGE_CODE,LISTENING,WRITING,SPEAKING,READING)" +
                " VALUES ('" + languageEntity.getEmployeeId() + "','" + languageEntity.getLanguageType() + "','" + languageEntity.getListening() + "','" +
                languageEntity.getWriting() + "','" + languageEntity.getSpeaking() + "','" +
                "" + languageEntity.getReading() + "')";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            checkSave = _ps.executeUpdate();
            return checkSave;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return checkSave;

    }

    public int updateEmployeeLanguage(LanguageEntity languageEntity) {
        String _select = "update hr_emp_language set " +
                "emp_Id=?,LANGUAGE_CODE=?,LISTENING=?,WRITING=?,SPEAKING=?,READING=? where ID=?";




        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, languageEntity.getEmployeeId());
            _ps.setString(2, languageEntity.getLanguageType());
            _ps.setString(3, languageEntity.getListening());
            _ps.setString(4, languageEntity.getWriting());
            _ps.setString(5, languageEntity.getSpeaking());
            _ps.setString(6, languageEntity.getReading());
            _ps.setString(7, languageEntity.getId());
            check = _ps.executeUpdate();
            return check;
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
            ex.printStackTrace();

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;

    }

    public HashMap[] readLanguage(String empID) {

        Connection _conn;
        ResultSet rsFamily;
        int i = 0;
        HashMap[] _list = null;
        String select = "Select hr_emp_language.*, hr_lu_language.description From hr_emp_language " +
                " Join hr_lu_language on hr_lu_language.language_code  = hr_emp_language.language_code Where emp_id=?";

        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(select);
            ps.setString(1, empID);
            rsFamily = ps.executeQuery();
            OracleResultSetMetaData count = (OracleResultSetMetaData) rsFamily.getMetaData();

            _list = new HashMap[count.getColumnCount()];
            while (rsFamily.next()) {
                _list[i] = new HashMap();
                _list[i].put("LANGUAGE_CODE", rsFamily.getString("LANGUAGE_CODE"));
                _list[i].put("READING", rsFamily.getString("READING"));
                _list[i].put("WRITING", rsFamily.getString("WRITING"));
                _list[i].put("SPEAKING", rsFamily.getString("SPEAKING"));
                _list[i].put("LISTENING", rsFamily.getString("LISTENING"));
                _list[i].put("ID", rsFamily.getString("ID"));
                _list[i].put("EMP_ID", rsFamily.getString("EMP_ID"));
                _list[i].put("description", rsFamily.getString("description"));
                i++;
            }
            return _list;

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    public int countEmployeeLanguage(String empID) {
        String count = "SELECT Max(rownum)as num  from hr_emp_language WHERE emp_Id=?";
        Connection _conn;
        ResultSet rsFamily;
        int rownum;

        try {
            _conn = getConnection();
            PreparedStatement ps = _conn.prepareStatement(count);
            ps.setString(1, empID);
            rsFamily = ps.executeQuery();
            rsFamily.next();
            rownum = rsFamily.getInt("num");
            return rownum;
        } catch (Exception ex) {
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public int deleteEmployeeLanguage(String id) {
        String _deletet = "DELETE FROM hr_emp_language WHERE ID=?";



        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setInt(1, Integer.parseInt(id));
            check = ps.executeUpdate();
            return check;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);

        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return 0;
    }

    public String readLanguageName(String languageCode) {
        String _deletet = "select description FROM hr_lu_language WHERE language_code=?";



        String description;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(_deletet);
            ps.setString(1, languageCode);
            _rs = ps.executeQuery();
            _rs.next();
            description = _rs.getString("description");
            return description;

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return null;
    }
}
