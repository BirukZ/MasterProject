/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EmployeeWillEntity;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class EmployeeWillManager {

    EmployeeWillEntity employeeWillEntity = new EmployeeWillEntity();
    private String employeeId;
    private String willId;
    private String willFirstName;
    private String willMiddleName;
    private String willLastName;
    private String willsalry;
    private String willregionid;
    private String willzoneorcity;
    private String willworedaorsubcity;
    private String willkebelle;
    private String willhousenumber;
    private String willworkingin;
    private String mobile;
    private String willworkingphonenumber;
    private String willresidencephonenumber;
    private String title;
    private String registrationDate;

    public boolean saveEmployeeWill(ArrayList<HashMap> employeeWillList) {
        return employeeWillEntity.saveEmployeeWill(employeeWillList);
    }

    public boolean updateEmployeeWill(ArrayList<HashMap> employeeWillList) {
        return false;
    }

    public boolean saveEmployeeWill(EmployeeWillManager employeeWillManager) {
        try {
            EmployeeWillEntity saveEmployeeWillEntity = new EmployeeWillEntity();
            saveEmployeeWillEntity.setEmployeeId(employeeWillManager.getEmployeeId());
            saveEmployeeWillEntity.setWillFirstName(employeeWillManager.getWillFirstName());
            saveEmployeeWillEntity.setWillMiddleName(employeeWillManager.getWillMiddleName());
            saveEmployeeWillEntity.setWillLastName(employeeWillManager.getWillMiddleName());
            saveEmployeeWillEntity.setWillsalry(employeeWillManager.getWillsalry());
            saveEmployeeWillEntity.setWillregionid(employeeWillManager.getWillregionid());
            saveEmployeeWillEntity.setWillzoneorcity(employeeWillManager.getWillzoneorcity());
            saveEmployeeWillEntity.setWillworedaorsubcity(employeeWillManager.getWillworedaorsubcity());
            saveEmployeeWillEntity.setWillkebelle(employeeWillManager.getWillkebelle());
            saveEmployeeWillEntity.setWillhousenumber(employeeWillManager.getWillhousenumber());
            saveEmployeeWillEntity.setWillworkingin(employeeWillManager.getWillworkingin());
            saveEmployeeWillEntity.setWillLastName(employeeWillManager.getWillMiddleName());
            saveEmployeeWillEntity.setMobile(employeeWillManager.getMobile());
            saveEmployeeWillEntity.setWillworkingphonenumber(employeeWillManager.getWillworkingphonenumber());
            saveEmployeeWillEntity.setWillresidencephonenumber(employeeWillManager.getWillresidencephonenumber());
            saveEmployeeWillEntity.setTitle(employeeWillManager.getTitle());
            return employeeWillEntity.saveEmployeeWill(saveEmployeeWillEntity);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateEmployeeWill(HashMap willUpdatedList) {
        try {
            return employeeWillEntity.updateEmployeeWill(willUpdatedList);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteEmployeeWill(String willId) {
        return employeeWillEntity.deleteEmployeeWill(willId);
    }

    public ArrayList<HashMap> getEmployeeWill(String employeeId) {
        return employeeWillEntity.getEmployeeWill(employeeId);
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(String registrationDate) {
        this.registrationDate = registrationDate;
    }
}
