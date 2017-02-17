/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.globalUseManager;

import entity.globalUseEntity.AssignEmployeeInLocationEntity;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import javax.faces.model.SelectItem;

/**
 *
 * @author Administrator
 */
public class AssignEmployeeInLocationManager {

    private String locationId;
    private String employeeId;
    private String employeeLocationID;
    private AssignEmployeeInLocationEntity assLocationEntity = null;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeLocationID() {
        return employeeLocationID;
    }

    public void setEmployeeLocationID(String employeeLocationID) {
        this.employeeLocationID = employeeLocationID;
    }

    public String getLocationId() {
        return locationId;
    }

    public void setLocationId(String locationId) {
        this.locationId = locationId;
    }

    public boolean saveEmployeeInLocation(String locationId, Set<HashMap> listOfEmployee) {
        try {
            // delete all employee group
            callObject();
            if (locationId != null) {
                assLocationEntity.deleteEmployeeFromLocation(locationId);
                return assLocationEntity.saveEmployeeInLocation(locationId, listOfEmployee);
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private void callObject() {
        if (assLocationEntity == null) {
            assLocationEntity = new AssignEmployeeInLocationEntity();
        }
    }

    public ArrayList<HashMap> listOFEmployee(String deprtmentId) {
        callObject();
        return assLocationEntity.listOFEmployee(deprtmentId);
    }

    public ArrayList<HashMap> listOFEmployeeNotAssign() {
        callObject();
        return assLocationEntity.listOFEmployeeNotAssign();
    }

    public ArrayList<HashMap> listOFEmployeeByLoCation(String locationId) {
        callObject();
        return assLocationEntity.listOFEmployeeByLoCation(locationId);
    }

    public ArrayList<HashMap> listOfLocation() {
        callObject();
        return assLocationEntity.listOFEmployeeByLoCation(locationId);
    }

    public ArrayList<SelectItem> locationList() {
        callObject();
        ArrayList<HashMap> lsit = assLocationEntity.listOfLocation();
        ArrayList<SelectItem> listOfLocations = new ArrayList<SelectItem>();
        if (lsit != null) {
            listOfLocations.add(new SelectItem(null,
                    "Select Location"));
            for (HashMap li : lsit) {
                listOfLocations.add(new SelectItem(li.get("LOCATION_ID").toString(),
                        li.get("ACTUAL_LOCATION").toString()));
            }
        } else {
            listOfLocations.add(new SelectItem(null,
                    "Location Not Avilebel"));
        }
        return listOfLocations;
    }
}
