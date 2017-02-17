/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.employeeEntity;

import connectionProvider.ConnectionManager;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;


import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.ErrorLogWriter;
import oracle.jdbc.OracleResultSetMetaData;

/**
 *
 * @author Administrator
 */
public class AddressEntity extends ConnectionManager {

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

    public AddressEntity() {
    }
    String kebelle;

    public String getKebelle() {
        return kebelle;
    }

    public String getTelNumberHome() {
        return telNumberHome;
    }

    public String getTelNumberMobile() {
        return telNumberMobile;
    }

    public String getTelNumberOffice() {
        return telNumberOffice;
    }

    public String getZoneCity() {
        return zoneCity;
    }
    String telNumberHome;
    String telNumberOffice;
    String telNumberMobile;
    String zoneCity;
    String woredaSubCity;
    String empId;
    String region;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getPobox() {
        return pobox;
    }

    public void setPobox(String pobox) {
        this.pobox = pobox;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }
    String houseNumber;

    public AddressEntity(String kebelle, String telNumberHome, String telNumberOffice,
            String telNumberMobile, String zoneCity, String woredaSubCity,
            String empId, String region, String houseNumber, String pobox,
            String email, String addressType,String sefere, String iD) {
        this.kebelle = kebelle;
        this.telNumberHome = telNumberHome;
        this.telNumberOffice = telNumberOffice;
        this.telNumberMobile = telNumberMobile;
        this.zoneCity = zoneCity;
        this.woredaSubCity = woredaSubCity;
        this.empId = empId;
        this.region = region;
        this.houseNumber = houseNumber;
        this.pobox = pobox;
        this.email = email;
        this.addressType = addressType;
        this.sefere=sefere;
        this.iD = iD;
    }
    String pobox;
    String email;
    String addressType;
    String iD;
    String sefere;

    public String getSefere() {
        return sefere;
    }

    public void setSefere(String sefere) {
        this.sefere = sefere;
    }

    public String getID() {
        return iD;
    }

    public void setID(String iD) {
        this.iD = iD;
    }

    public String getAddressType() {
        return addressType;
    }

    public void setAddressType(String addressType) {
        this.addressType = addressType;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getWoredaSubCity() {
        return woredaSubCity;
    }

    public void setWoredaSubCity(String woredaSubCity) {
        this.woredaSubCity = woredaSubCity;
    }

    public int updateEmployeeAddress(AddressEntity employeeEntity) {

        int checkSave = 0;
        String _select = "UPDATE hr_emp_address" +
                " set EMP_ID=?,WOREDA_OR_SUBCITY_ID=?,WOREDA_OR_SUBCITY=?," +
                " KEBELE=?,HOUSE_NUMBER=?,TELEPHONE_RESIDENCE=?," +
                " TELEPHONE_OFFICE=?,MOBILE=?," +
                " EMAIL=?,REGION_ID=?,P_O_BOX=?," +
                " ADDRESSTYPE=?,SEFERE=? where ID=?";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            _ps.setString(1, employeeEntity.getEmpId());
            _ps.setString(2, employeeEntity.getWoredaSubCity());
            _ps.setString(3, employeeEntity.getZoneCity());
            _ps.setString(4, employeeEntity.getKebelle());
            _ps.setString(5, employeeEntity.getHouseNumber());
            _ps.setString(6, employeeEntity.getTelNumberHome());
            _ps.setString(7, employeeEntity.getTelNumberOffice());
            _ps.setString(8, employeeEntity.getTelNumberMobile());
            _ps.setString(9, employeeEntity.getEmail());
            _ps.setString(10, employeeEntity.getRegion());
            _ps.setString(11, employeeEntity.getPobox());
            _ps.setString(12, employeeEntity.getAddressType());
            _ps.setString(13, employeeEntity.getSefere());
            _ps.setString(14, employeeEntity.getID());
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

    public HashMap[] readAddress(String empID) {
        int i = 0;
        HashMap[] _list = null;

        String select =
                "SELECT distinct HR_EMP_ADDRESS.*, HR_LU_REGION.REGION_NAME, HR_LU_WOREDA_OR_SUB_CITY.WOREDA_OR_SUBCITY_NAME, HR_LU_ZONE_OR_CITY.ZONE_OR_CITY_NAME " +
                " FROM HR_LU_ZONE_OR_CITY INNER JOIN (HR_LU_WOREDA_OR_SUB_CITY INNER JOIN (HR_LU_REGION INNER JOIN HR_EMP_ADDRESS " +
                "ON HR_LU_REGION.REGION_ID = HR_EMP_ADDRESS.REGION_ID) ON HR_LU_WOREDA_OR_SUB_CITY.WOREDA_OR_SUBCITY_ID = HR_EMP_ADDRESS.WOREDA_OR_SUBCITY_ID) " +
                "ON HR_LU_ZONE_OR_CITY.ZONE_OR_CITY_ID = HR_EMP_ADDRESS.WOREDA_OR_SUBCITY where emp_id=?";
        String poBox = null;
        String email = null;
        String telMobile = null;
        String telOffice = null;
        String telHome = null;
        String sefere=null;

        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(select);
            ps.setString(1, empID);
            _rs = ps.executeQuery();

            OracleResultSetMetaData count = (OracleResultSetMetaData) _rs.getMetaData();
            _list = new HashMap[count.getColumnCount()];
            while (_rs.next()) {
                _list[i] = new HashMap();
                if (_rs.getString("EMAIL") != null) {
                    email = _rs.getString("EMAIL");

                } else {
                    email = "Not Register";
                }
                if (_rs.getString("P_O_BOX") != null) {
                    poBox = _rs.getString("P_O_BOX");

                } else {
                    poBox = "Not Register";
                }
                if (_rs.getString("MOBILE") != null) {
                    telMobile = _rs.getString("MOBILE");

                } else {
                    telMobile = "Not Register";
                }
                  if (_rs.getString("SEFERE") != null) {
                    sefere = _rs.getString("SEFERE");

                } else {
                    sefere = "Not Register";
                }
                if (_rs.getString("TELEPHONE_OFFICE") != null) {
                    telOffice = _rs.getString("TELEPHONE_OFFICE");

                } else {
                    telOffice = "Not Register";
                }
                if (_rs.getString("TELEPHONE_RESIDENCE") != null) {
                    telHome = _rs.getString("TELEPHONE_RESIDENCE");

                } else {
                    telHome = "Not Register";
                }
                if (_rs.getString("KEBELE") != null) {
                    _list[i].put("KEBELE", _rs.getString("KEBELE"));
                } else {
                    _list[i].put("KEBELE", "Not Register");
                }
                if (_rs.getString("HOUSE_NUMBER") != null) {
                    _list[i].put("HOUSE_NUMBER", _rs.getString("HOUSE_NUMBER").toString());

                } else {
                    _list[i].put("HOUSE_NUMBER", "Not Register");
                }

                _list[i].put("WOREDA_OR_SUBCITY_ID", _rs.getString("WOREDA_OR_SUBCITY_ID"));
                _list[i].put("WOREDA_OR_SUBCITY", _rs.getString("WOREDA_OR_SUBCITY"));
                _list[i].put("TELEPHONE_RESIDENCE", telHome);
                _list[i].put("ADDRESSTYPE", _rs.getString("ADDRESSTYPE"));
                _list[i].put("TELEPHONE_OFFICE", telOffice);
                _list[i].put("ID", Integer.toString(_rs.getInt("ID")));
                _list[i].put("MOBILE", telMobile);
                _list[i].put("SEFERE", sefere);
                _list[i].put("EMAIL", email);
                _list[i].put("REGION_ID", _rs.getString("REGION_ID"));
                _list[i].put("P_O_BOX", poBox);
                _list[i].put("regionDescription", _rs.getString("REGION_NAME"));
                _list[i].put("woredaDiscretion", _rs.getString("WOREDA_OR_SUBCITY_NAME"));
                _list[i].put("zoneDescription", _rs.getString("ZONE_OR_CITY_NAME"));

                // _list[i].put("KEBELLE_DESCRIPTION", _rsAddress.getString("KEBELLE_DESCRIPTION"));
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

    public HashMap readEmployeeLeaveTimeAddrss(String empID) {
        HashMap _list = new HashMap();
        String select = "SELECT EMP_ID, " +
                "  WOREDA_OR_SUBCITY_ID, " +
                "  WOREDA_OR_SUBCITY, " +
                "  KEBELE, " +
                "  TELEPHONE_RESIDENCE, " +
                "  MOBILE, " +
                "  REGION_ID, " +
                "  ADDRESSTYPE, " +
                "  ID, " +
                "  HOUSE_NUMBER " +
                "FROM HR_EMP_ADDRESS " +
                "WHERE EMP_ID   =? " +
                "AND ADDRESSTYPE=? ";
        String telMobile = null;
        String telHome = null;
        try {
            _con = getConnection();
            PreparedStatement ps = _con.prepareStatement(select);
            ps.setString(1, empID);
            ps.setString(2, EmployeeManage.EMPLOYEE_LEAVETIME_ADDRESS);
            _rs = ps.executeQuery();

            if (_rs.next()) {
                if (_rs.getString("MOBILE") != null) {
                    telMobile = _rs.getString("MOBILE");
                } else {
                    telMobile = "Not Register";
                }
                if (_rs.getString("TELEPHONE_RESIDENCE") != null) {
                    telHome = _rs.getString("TELEPHONE_RESIDENCE");
                } else {
                    telHome = "Not Register";
                }
                if (_rs.getString("KEBELE") != null) {
                    _list.put("KEBELE", _rs.getString("KEBELE"));
                } else {
                    _list.put("KEBELE", "Not Register");
                }
                if (_rs.getString("HOUSE_NUMBER") != null) {
                    _list.put("HOUSE_NUMBER", _rs.getString("HOUSE_NUMBER").toString());

                } else {
                    _list.put("HOUSE_NUMBER", "Not Register");
                }

                _list.put("WOREDA_OR_SUBCITY_ID", _rs.getString("WOREDA_OR_SUBCITY_ID"));
                _list.put("WOREDA_OR_SUBCITY", _rs.getString("WOREDA_OR_SUBCITY"));
                _list.put("TELEPHONE_RESIDENCE", telHome);
                _list.put("ADDRESSTYPE", _rs.getString("ADDRESSTYPE"));
                _list.put("ID", Integer.toString(_rs.getInt("ID")));
                _list.put("MOBILE", telMobile);
                _list.put("REGION_ID", _rs.getString("REGION_ID"));

                return _list;

            } else {

                return null;
            }

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

    public int saveEmployeeAddress(AddressEntity employeeAddrss) {

        int check;
        String _select = "INSERT INTO hr_emp_address" +
                "(EMP_ID,WOREDA_OR_SUBCITY_ID,WOREDA_OR_SUBCITY," +
                " KEBELE,HOUSE_NUMBER," +
                " TELEPHONE_RESIDENCE,TELEPHONE_OFFICE,MOBILE," +
                " EMAIL,REGION_ID,P_O_BOX," +
                " ADDRESSTYPE,SEFERE)" +
                " VALUES ('" + employeeAddrss.getEmpId() + "','" + employeeAddrss.getWoredaSubCity() + "','" + employeeAddrss.getZoneCity() +
                "','" + employeeAddrss.getKebelle() + "','" + employeeAddrss.getHouseNumber() + "','" +
                "" + employeeAddrss.getTelNumberHome() + "','" + employeeAddrss.getTelNumberOffice() + "','" + employeeAddrss.getTelNumberMobile() + "','" +
                employeeAddrss.getEmail() + "','" + employeeAddrss.getRegion() + "','" +
                "" + employeeAddrss.getPobox() + "','" + employeeAddrss.getAddressType() + "','" + employeeAddrss.getSefere() + "')";
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_select);
            check = _ps.executeUpdate();
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

    public int getSize(String empID) {
        String count = "SELECT Max(rownum)as num  from hr_emp_address WHERE emp_Id=?";
        int number = 0;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(count);
            _ps.setString(1, empID);
            _rs = _ps.executeQuery();
            _rs.next();
            number = _rs.getInt("num");
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return number;
    }

    public int deleteEmployeeAddress(String empID) {
        String _deletet = "DELETE FROM hr_emp_address WHERE ID=?";
        int check;
        try {
            _con = getConnection();
            _ps = _con.prepareStatement(_deletet);
            _ps.setInt(1, Integer.parseInt(empID));
            check = _ps.executeUpdate();
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

    public boolean updateLeaveTimeAddress(String employeeId,
            String region,
            String zoneOrCity,
            String woreda,
            String kabele,
            String houseNumber,
            String telephoneHome,
            String telephoneMoblie,
            String addressId) {
        String updateStatment =
                " UPDATE " +
                "  HR_EMP_ADDRESS " +
                " SET " +
                "  REGION_ID            = ?, " +
                "  WOREDA_OR_SUBCITY_ID = ?, " +
                "  WOREDA_OR_SUBCITY    = ?, " +
                "  KEBELE               = ?, " +
                "  HOUSE_NUMBER         = ?, " +
                "  MOBILE               = ?, " +
                "  TELEPHONE_RESIDENCE  = ? " +
                " WHERE " +
                " EMP_ID        = ? " +
                " AND ADDRESSTYPE = ? " +
                " AND ID          = ?";
        String insertStatment = "INSERT " +
                "INTO HR_EMP_ADDRESS " +
                "  ( " +
                "    EMP_ID, " +
                "    WOREDA_OR_SUBCITY_ID, " +
                "    WOREDA_OR_SUBCITY, " +
                "    KEBELE, " +
                "    TELEPHONE_RESIDENCE, " +
                "    MOBILE, " +
                "    REGION_ID, " +
                "    ADDRESSTYPE, " +
                "    HOUSE_NUMBER " +
                "  ) " +
                "  VALUES " +
                "  ( " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ?, " +
                "    ? " +
                "  )";
        int check;
     
        try {
            _con = getConnection();
            if (addressId != null) {
                _ps = _con.prepareStatement(updateStatment);
                _ps.setString(1, region);
                _ps.setString(2, zoneOrCity);
                _ps.setString(3, woreda);
                _ps.setString(4, houseNumber);
                _ps.setString(5, telephoneHome);
                _ps.setString(6, telephoneMoblie);
                _ps.setString(7, employeeId);
                check = _ps.executeUpdate();
                if (check > 0) {
                    return true;
                } else {
                    return false;
                }
            } else {
                _ps = _con.prepareStatement(insertStatment);
                _ps.setString(1, employeeId);
                _ps.setString(2, zoneOrCity);
                _ps.setString(3, woreda);
                _ps.setString(4, kabele);
                _ps.setString(5, telephoneHome);
                _ps.setString(6, telephoneMoblie);
                _ps.setString(7, region);
                _ps.setString(8, EmployeeManage.EMPLOYEELEAVETYPEADDRESS);
                _ps.setString(9, houseNumber);
                check = _ps.executeUpdate();
                if (check > 0) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        } finally {
            try {
                releaseResources();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }
}
