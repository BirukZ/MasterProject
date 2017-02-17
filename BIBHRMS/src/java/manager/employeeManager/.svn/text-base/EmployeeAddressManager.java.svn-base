/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EmployeeAddressEntity;
import java.sql.ResultSet;
import java.util.ArrayList;
import manager.globalUseManager.ErrorLogWriter;

/**
 *
 * @author user
 */
public class EmployeeAddressManager {

    ArrayList<EmployeeAddressModel> employeeAddressLists = new ArrayList<EmployeeAddressModel>();
    EmployeeAddressModel employeeAddressModel = new EmployeeAddressModel();
    EmployeeAddressEntity employeeAddressEntity=new EmployeeAddressEntity();

    public ArrayList<EmployeeAddressModel> getEmployeeAddresses(String employeeId) {
        try {
            ResultSet _rs = employeeAddressEntity.selectAddressByEmployeeId(employeeId);
            while (_rs.next()) {
                employeeAddressModel = new EmployeeAddressModel();
                employeeAddressModel.empId = _rs.getString("EMP_ID");
                employeeAddressModel.addressId = _rs.getInt("EMP_ADDRESS_ID");
                employeeAddressModel.addressType = _rs.getString("ADDRESS_TYPE");
                employeeAddressModel.region = _rs.getString("REGION");
                employeeAddressModel.zoneOrSubcity = _rs.getString("ZONE_OR_SUBCITY");
                employeeAddressModel.woreda = _rs.getString("WOREDA");
                employeeAddressModel.kebele = _rs.getString("KEBELE");
                employeeAddressModel.houseNumber = _rs.getString("HOUSE_NUMBER");
                employeeAddressModel.telephoneHome = _rs.getString("TELEPHONE_HOME");
                employeeAddressModel.telephoneOffice = _rs.getString("TELEPHONE_OFFICE");
                employeeAddressModel.telephoneMobile = _rs.getString("TELEPHONE_MOBILE");
                employeeAddressModel.email = _rs.getString("EMAIL");
                employeeAddressModel.pOBox = _rs.getString("P_O_BOX");
                employeeAddressLists.add(employeeAddressModel);
            }
            return employeeAddressLists;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }
        return null;
    }
//<editor-fold defaultstate="collapsed" desc=" EmployeeAddressModel ">

    public class EmployeeAddressModel {

        int addressId;//ADDRESS_ID
        String empId;//EMP_ID
        String addressType;//ADDRESS_TYPE
        String region;//REGION
        String zoneOrSubcity;//ZONE_OR_SUBCITY
        String woreda;//WOREDA
        String kebele;//KEBELE
        String houseNumber;//HOUSE_NUMBER
        String telephoneHome;//TELEPHONE_HOME
        String telephoneOffice;//TELEPHONE_OFFICE
        String telephoneMobile;//TELEPHONE_MOBILE
        String email;//EMAIL
        String pOBox;//P_O_BOX

        public EmployeeAddressModel() {
        }

        public EmployeeAddressModel(String addressType, String region, String zoneOrSubcity, String woreda, String kebele, String houseNumber, String telephoneHome, String telephoneMobile) {
            this.addressType = addressType;
            this.region = region;
            this.zoneOrSubcity = zoneOrSubcity;
            this.woreda = woreda;
            this.kebele = kebele;
            this.houseNumber = houseNumber;
            this.telephoneHome = telephoneHome;
            this.telephoneMobile = telephoneMobile;
        }

        public EmployeeAddressModel(String empId, String addressType, String region, String zoneOrSubcity, String woreda, String kebele, String houseNumber, String telephoneHome, String telephoneMobile) {
            this(addressType, region, zoneOrSubcity, woreda, kebele, houseNumber, telephoneHome, telephoneMobile);
            this.empId = empId;
        }

        public EmployeeAddressModel(String empId, String addressType, String region, String zoneOrSubcity, String woreda, String kebele, String houseNumber, String telephoneHome, String telephoneOffice, String telephoneMobile, String email, String pOBox) {
            this(empId, addressType, region, zoneOrSubcity, woreda, kebele, houseNumber, telephoneHome, telephoneMobile);
            this.email = email;
            this.pOBox = pOBox;
        }

        public EmployeeAddressModel(int addressId, String empId, String addressType, String region, String zoneOrSubcity, String woreda, String kebele, String houseNumber, String telephoneHome, String telephoneOffice, String telephoneMobile, String email, String pOBox) {
            this(empId, addressType, region, zoneOrSubcity, woreda, kebele, houseNumber, telephoneHome, telephoneOffice, telephoneMobile, email, pOBox);
            this.addressId = addressId;
        }

        public int getAddressId() {
            return addressId;
        }

        public String getAddressType() {
            return addressType;
        }

        public String getEmail() {
            return email;
        }

        public String getEmpId() {
            return empId;
        }

        public String getHouseNumber() {
            return houseNumber;
        }

        public String getKebele() {
            return kebele;
        }

        public String getPOBox() {
            return pOBox;
        }

        public String getRegion() {
            return region;
        }

        public String getTelephoneHome() {
            return telephoneHome;
        }

        public String getTelephoneMobile() {
            return telephoneMobile;
        }

        public String getTelephoneOffice() {
            return telephoneOffice;
        }

        public String getWoreda() {
            return woreda;
        }

        public String getZoneOrSubcity() {
            return zoneOrSubcity;
        }
    }
    //</editor-fold >
}
