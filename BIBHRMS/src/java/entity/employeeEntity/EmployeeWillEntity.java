/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author Administrator
 */
@Entity
@Table(name = "HR_EMPLOYEE_WILL")
@NamedQueries({@NamedQuery(name = "EmployeeWillEntity.findAll", query = "SELECT e FROM EmployeeWillEntity e"), @NamedQuery(name = "EmployeeWillEntity.findByWillId", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willId = :willId"), @NamedQuery(name = "EmployeeWillEntity.findByWillFirstName", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willFirstName = :willFirstName"), @NamedQuery(name = "EmployeeWillEntity.findByWillMiddleName", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willMiddleName = :willMiddleName"), @NamedQuery(name = "EmployeeWillEntity.findByWillLastName", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willLastName = :willLastName"), @NamedQuery(name = "EmployeeWillEntity.findByWillsalry", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willsalry = :willsalry"), @NamedQuery(name = "EmployeeWillEntity.findByWillregionid", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willregionid = :willregionid"), @NamedQuery(name = "EmployeeWillEntity.findByWillzoneorcity", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willzoneorcity = :willzoneorcity"), @NamedQuery(name = "EmployeeWillEntity.findByWillworedaorsubcity", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willworedaorsubcity = :willworedaorsubcity"), @NamedQuery(name = "EmployeeWillEntity.findByWillkebelle", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willkebelle = :willkebelle"), @NamedQuery(name = "EmployeeWillEntity.findByWillhousenumber", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willhousenumber = :willhousenumber"), @NamedQuery(name = "EmployeeWillEntity.findByWillworkingin", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willworkingin = :willworkingin"), @NamedQuery(name = "EmployeeWillEntity.findByMobile", query = "SELECT e FROM EmployeeWillEntity e WHERE e.mobile = :mobile"), @NamedQuery(name = "EmployeeWillEntity.findByWillworkingphonenumber", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willworkingphonenumber = :willworkingphonenumber"), @NamedQuery(name = "EmployeeWillEntity.findByWillresidencephonenumber", query = "SELECT e FROM EmployeeWillEntity e WHERE e.willresidencephonenumber = :willresidencephonenumber")})
public class EmployeeWillEntity extends ConnectionManager implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "WILL_ID")
    private String willId;
    @Column(name = "EMP_ID")
    private String employeeId;
    @Column(name = "WILL_FIRST_NAME")
    private String willFirstName;
    @Column(name = "WILL_MIDDLE_NAME")
    private String willMiddleName;
    @Column(name = "WILL_LAST_NAME")
    private String willLastName;
    @Column(name = "WILLSALRY")
    private String willsalry;
    @Column(name = "WILLREGIONID")
    private String willregionid;
    @Column(name = "WILLZONEORCITY")
    private String willzoneorcity;
    @Column(name = "WILLWOREDAORSUBCITY")
    private String willworedaorsubcity;
    @Column(name = "WILLKEBELLE")
    private String willkebelle;
    @Column(name = "WILLHOUSENUMBER")
    private String willhousenumber;
    @Column(name = "WILLWORKINGIN")
    private String willworkingin;
    @Column(name = "MOBILE")
    private String mobile;
    @Column(name = "WILLWORKINGPHONENUMBER")
    private String willworkingphonenumber;
    @Column(name = "WILLRESIDENCEPHONENUMBER")
    private String willresidencephonenumber;
    @Column(name = "TITLE")
    private String title;

    public EmployeeWillEntity() {
    }

    public EmployeeWillEntity(String willId) {
        this.willId = willId;
    }

    public String getWillId() {
        return willId;
    }

    public void setWillId(String willId) {
        this.willId = willId;
    }

    public String getWillFirstName() {
        return willFirstName;
    }

    public void setWillFirstName(String willFirstName) {
        this.willFirstName = willFirstName;
    }

    public String getWillMiddleName() {
        return willMiddleName;
    }

    public void setWillMiddleName(String willMiddleName) {
        this.willMiddleName = willMiddleName;
    }

    public String getWillLastName() {
        return willLastName;
    }

    public void setWillLastName(String willLastName) {
        this.willLastName = willLastName;
    }

    public String getWillsalry() {
        return willsalry;
    }

    public void setWillsalry(String willsalry) {
        this.willsalry = willsalry;
    }

    public String getWillregionid() {
        return willregionid;
    }

    public void setWillregionid(String willregionid) {
        this.willregionid = willregionid;
    }

    public String getWillzoneorcity() {
        return willzoneorcity;
    }

    public void setWillzoneorcity(String willzoneorcity) {
        this.willzoneorcity = willzoneorcity;
    }

    public String getWillworedaorsubcity() {
        return willworedaorsubcity;
    }

    public void setWillworedaorsubcity(String willworedaorsubcity) {
        this.willworedaorsubcity = willworedaorsubcity;
    }

    public String getWillkebelle() {
        return willkebelle;
    }

    public void setWillkebelle(String willkebelle) {
        this.willkebelle = willkebelle;
    }

    public String getWillhousenumber() {
        return willhousenumber;
    }

    public void setWillhousenumber(String willhousenumber) {
        this.willhousenumber = willhousenumber;
    }

    public String getWillworkingin() {
        return willworkingin;
    }

    public void setWillworkingin(String willworkingin) {
        this.willworkingin = willworkingin;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getWillworkingphonenumber() {
        return willworkingphonenumber;
    }

    public void setWillworkingphonenumber(String willworkingphonenumber) {
        this.willworkingphonenumber = willworkingphonenumber;
    }

    public String getWillresidencephonenumber() {
        return willresidencephonenumber;
    }

    public void setWillresidencephonenumber(String willresidencephonenumber) {
        this.willresidencephonenumber = willresidencephonenumber;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (willId != null ? willId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeWillEntity)) {
            return false;
        }
        EmployeeWillEntity other = (EmployeeWillEntity) object;
        if ((this.willId == null && other.willId != null) || (this.willId != null && !this.willId.equals(other.willId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.employeeEntity.EmployeeWillEntity[willId=" + willId + "]";
    }

    public boolean saveEmployeeWill(EmployeeWillEntity employeeWillEntity) {
        Connection _con = null;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        int check;
        String _insert = "INSERT " +
                "INTO HR_EMPLOYEE_WILL " +
                "  ( EMP_ID," +
                "    WILL_FIRST_NAME, " +
                "    WILL_MIDDLE_NAME, " +
                "    WILL_LAST_NAME, " +
                "    WILLSALRY, " +
                "    WILLREGIONID, " +
                "    WILLZONEORCITY, " +
                "    WILLWOREDAORSUBCITY, " +
                "    WILLKEBELLE, " +
                "    WILLHOUSENUMBER, " +
                "    WILLWORKINGIN, " +
                "    MOBILE, " +
                "    WILLWORKINGPHONENUMBER, " +
                "    WILLRESIDENCEPHONENUMBER," +
                "    TITLE " +
                "  ) " +
                "  VALUES " +
                "  (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";




        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, employeeWillEntity.getEmployeeId());
            _ps.setString(2, employeeWillEntity.getWillFirstName());
            _ps.setString(3, employeeWillEntity.getWillMiddleName());
            _ps.setString(4, employeeWillEntity.getWillLastName());
            _ps.setString(5, employeeWillEntity.getWillsalry());
            _ps.setString(6, employeeWillEntity.getWillregionid());
            _ps.setString(7, employeeWillEntity.getWillzoneorcity());
            _ps.setString(8, employeeWillEntity.getWillworedaorsubcity());
            _ps.setString(9, employeeWillEntity.getWillkebelle());
            _ps.setString(10, employeeWillEntity.getWillhousenumber());
            _ps.setString(11, employeeWillEntity.getWillworkingin());
            _ps.setString(12, employeeWillEntity.getMobile());
            _ps.setString(13, employeeWillEntity.getWillworkingphonenumber());
            _ps.setString(14, employeeWillEntity.getWillresidencephonenumber());
            _ps.setString(15, employeeWillEntity.getTitle());
            if (_ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }
        return false;


    }

    public boolean saveEmployeeWill(ArrayList<HashMap> employeeWillList) {
        Connection _con = null;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        boolean check = false;
        String _insert = "INSERT " +
                "INTO HR_EMPLOYEE_WILL " +
                "  ( EMP_ID," +
                "    WILL_FIRST_NAME, " +
                "    WILL_MIDDLE_NAME, " +
                "    WILL_LAST_NAME, " +
                "    WILLSALRY, " +
                "    WILLREGIONID, " +
                "    WILLZONEORCITY, " +
                "    WILLWOREDAORSUBCITY, " +
                "    WILLKEBELLE, " +
                "    WILLHOUSENUMBER, " +
                "    EXTERNALDOUMENTNO, " +
                "    INTERNALDOCUMENTNO, " +
                "    WILLSTATUS, " +
                "    TITLE " +
                "  ) " +
                "  VALUES " +
                "  (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            _con = getConnection();
            for (HashMap hm : employeeWillList) {
                _ps = _con.prepareStatement(_insert);
                _ps.setString(1, hm.get("employeeId").toString());
                _ps.setString(2, hm.get("willFirstName").toString());
                _ps.setString(3, hm.get("willMiddleName").toString());
                _ps.setString(4, hm.get("willLastName").toString());
                _ps.setString(5, hm.get("willSalary").toString());
                _ps.setString(6, hm.get("willRegion").toString());
                _ps.setString(7, hm.get("willZoneorCity").toString());
                _ps.setString(8, hm.get("willWoredaorSubCity").toString());
                _ps.setString(9, hm.get("willKebele").toString());
                _ps.setString(10, hm.get("willHouseNumber").toString());
                _ps.setString(11, hm.get("externalDoumentNo").toString());
                _ps.setString(12, hm.get("internalDocumentNo").toString());
                _ps.setString(13, hm.get("willStatus").toString());
                _ps.setString(14, hm.get("willTitle").toString());
                if (_ps.executeUpdate() > 0) {
                    return true;
                }
                check = true;
            }

            if (check) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }
        return false;


    }

    public boolean updateEmployeeWill(HashMap listOFEmployeeWill) {
        Connection _con = null;
        PreparedStatement _ps = null;
      
        String _insert = "UPDATE HR_EMPLOYEE_WILL " +
                "SET WILL_FIRST_NAME        = ?, " +
                "  WILL_MIDDLE_NAME         = ?, " +
                "  WILL_LAST_NAME           = ?, " +
                "  WILLSALRY                = ?, " +
                "  WILLREGIONID             = ?, " +
                "  WILLZONEORCITY           = ?, " +
                "  WILLWOREDAORSUBCITY      = ?, " +
                "  WILLKEBELLE              = ?, " +
                "  WILLHOUSENUMBER          = ?, " +
                "  EXTERNALDOUMENTNO        = ?, " +
                "  INTERNALDOCUMENTNO       = ?, " +
                "  WILLSTATUS               = ?, " +
                "  EMP_ID                   = ?, " +
                "  TITLE                    = ?, " +
                "  REGISTRATIONDATE         = ? " +
                "WHERE WILL_ID              = ?";

        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_insert);
            _ps.setString(1, listOFEmployeeWill.get("willFirstName").toString());
            _ps.setString(2, listOFEmployeeWill.get("willMiddleName").toString());
            _ps.setString(3, listOFEmployeeWill.get("willLastName").toString());
            _ps.setString(4, listOFEmployeeWill.get("willSalary").toString());
            _ps.setString(5, listOFEmployeeWill.get("willRegion").toString());
            _ps.setString(6, listOFEmployeeWill.get("willZoneorCity").toString());
            _ps.setString(7, listOFEmployeeWill.get("willWoredaorSubCity").toString());
            _ps.setString(8, listOFEmployeeWill.get("kebelle").toString());
            _ps.setString(9, listOFEmployeeWill.get("willHouseNumber").toString());
            _ps.setString(10, listOFEmployeeWill.get("externalDoumentNo").toString());
            _ps.setString(11, listOFEmployeeWill.get("internalDocumentNo").toString());
            _ps.setString(12, listOFEmployeeWill.get("willStatus").toString());
            _ps.setString(13, listOFEmployeeWill.get("employeeId").toString());
            _ps.setString(14, listOFEmployeeWill.get("willTitle").toString());
            _ps.setString(15, listOFEmployeeWill.get("registrationDate").toString());
            _ps.setString(16, listOFEmployeeWill.get("willId").toString());
            if (_ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }
        return false;


    }

    public boolean deleteEmployeeWill(String willId) {
        Connection _con = null;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        int check;
        String _delete = "DELETE FROM HR_EMPLOYEE_WILL WHERE WILL_ID = ?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_delete);
            _ps.setString(1, willId);
            if (_ps.executeUpdate() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {

            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);


        }
        return false;


    }

    public ArrayList<HashMap> getEmployeeWill(String employeeId) {
        String _select = "SELECT WILL_ID, " +
                "  WILL_FIRST_NAME, " +
                "  WILL_MIDDLE_NAME, " +
                "  WILL_LAST_NAME, " +
                "  WILLSALRY, " +
                "  WILLREGIONID, " +
                "  WILLZONEORCITY, " +
                "  WILLWOREDAORSUBCITY, " +
                "  WILLKEBELLE, " +
                "  WILLHOUSENUMBER, " +
                "  TITLE, " +
                " WILLSTATUS , " +
                "  EXTERNALDOUMENTNO, " +
                "  INTERNALDOCUMENTNO, " +
                "  nvl(REGISTRATIONDATE,'not register') as  REGISTRATIONDATE" +
                "  FROM HR_EMPLOYEE_WILL " +
                " WHERE EMP_ID=? ";
        Connection _con = null;
        PreparedStatement _ps = null;
        ResultSet _rs = null;
        ArrayList<HashMap> listOfEmployee = new ArrayList<HashMap>();
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeId);
            _rs = _ps.executeQuery();
            while (_rs.next()) {
                HashMap hm = new HashMap();
                hm.put("WILL_ID", _rs.getString("WILL_ID"));
                hm.put("WILL_FIRST_NAME", _rs.getString("WILL_FIRST_NAME"));
                hm.put("WILL_MIDDLE_NAME", _rs.getString("WILL_MIDDLE_NAME"));
                hm.put("WILL_LAST_NAME", _rs.getString("WILL_LAST_NAME"));
                hm.put("WILLSALRY", _rs.getString("WILLSALRY"));
                hm.put("WILLREGIONID", _rs.getString("WILLREGIONID"));
                hm.put("WILLZONEORCITY", _rs.getString("WILLZONEORCITY"));
                hm.put("WILLWOREDAORSUBCITY", _rs.getString("WILLWOREDAORSUBCITY"));
                hm.put("WILLKEBELLE", _rs.getString("WILLKEBELLE"));
                hm.put("WILLHOUSENUMBER", _rs.getString("WILLHOUSENUMBER"));
                hm.put("INTERNALDOCUMENTNO", _rs.getString("INTERNALDOCUMENTNO"));
                hm.put("EXTERNALDOUMENTNO", _rs.getString("EXTERNALDOUMENTNO"));
                hm.put("REGISTRATIONDATE", _rs.getString("REGISTRATIONDATE"));
                hm.put("TITLE", _rs.getString("TITLE"));
                hm.put("WILLSTATUS", _rs.getString("WILLSTATUS"));

                listOfEmployee.add(hm);
            }
            return listOfEmployee;
        } catch (Exception e) {
            e.printStackTrace();
            ErrorLogWriter.writeError(e);
            return null;
        }

    }
}
