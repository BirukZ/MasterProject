/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import oracle.sql.BLOB;

/**
 *
 * @author DPClone
 */
public class EmployeeList {

    private String fullName;
    private String empIdentification;
    private byte[] employeePicture;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmpIdentification() {
        return empIdentification;
    }

    public void setEmpIdentification(String empIdentification) {
        this.empIdentification = empIdentification;
    }

    public byte[] getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(byte[] employeePicture) {
        this.employeePicture = employeePicture;
    }

    public EmployeeList() {
        this("", "", null);
    }

    public EmployeeList(String fullName, String empIdentification, byte[] employeePicture) {
        this.fullName = fullName;
        this.empIdentification = empIdentification;
        this.employeePicture = employeePicture;

    }
     public EmployeeList(String fullName,String empIdentification) {
        this.fullName = fullName;
        this.empIdentification = empIdentification;

    }
}
