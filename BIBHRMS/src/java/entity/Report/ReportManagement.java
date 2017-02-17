/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entity.Report;

import connectionProvider.ConnectionManager;
import java.io.Serializable;
import java.sql.Blob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import manager.globalUseManager.ErrorLogWriter;
/*import mmsManager.common.ErrorLogWriter*/;
//----------------yyy
/**
 *t
 * @author yodit
 */

public class ReportManagement implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;

    private byte[] code;

    private String description;

    public ReportManagement() {
    }

    public ReportManagement(Integer id) {
        this.id = id;
    }

    public ReportManagement(Integer id, byte[] code, String description) {
        this.id = id;
        this.code = code;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public byte[] getCode() {
        return code;
    }

    public void setCode(byte[] code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
        if (!(object instanceof ReportManagement)) {
            return false;
        }
        ReportManagement other = (ReportManagement) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "mms1Entity.ReportManagement[id=" + id + "]";
    }

    /**reads the code (jrxml content) of the report for specific record
     * identified by _reportId
     * @param _reportId the id of the report for which the code is needed
     * @return return the report code as string object
     */
    public static Blob getReportCode(String _reportId){
         ConnectionManager _con=new ConnectionManager();
        String sql = "SELECT code FROM mms_report_management1 " +
                " WHERE id = '" + _reportId + "'";
        Blob _code = null;
        PreparedStatement _ps = null;
        try{
            ResultSet _rs = null;

                   _ps= _con.getConnection().prepareStatement(sql);
            _rs = _ps.executeQuery();
            _rs.next();
            _code = _rs.getBlob("code");
        }catch(Exception ex){
            ErrorLogWriter.writeError(ex);
        }
        return _code;
    }
    /**reads the code (jrxml content) of the report for specific record
     * identified by _reportId
     *
     * @param _reportId the id of the report for which the code is needed
     * @return return the report code as string object
     */
    public static Blob getReportFile(int _reportId) {
        ConnectionManager _con=new ConnectionManager();

        String _reportCode = "SELECT code FROM hr_report_management1 WHERE id = ? ";
        Blob _code = null;
        try {
            ResultSet _rs = null;

            PreparedStatement _ps = _con.getConnection().prepareStatement(_reportCode);
            _ps.setInt(1, _reportId);
            _rs = _ps.executeQuery();

            _rs.next();
            _code = _rs.getBlob("code");
        } catch (Exception ex) {
            ErrorLogWriter.writeError(ex);
        }

        return _code;
    }

}
