/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EmployeeTraining_Entity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author ONEQAZ
 */
public class EmployeeTrainingManager {

    private String trainingName;
    private String institutionId;
    private String institution;
    private String period;
    private String employeeId;
    private String trainingId;
    private boolean selectedTraining;
    private String startDate;
    private String endDate;
    private String sponsoredBy;
    private String duration;
    private EmployeeTraining_Entity employeeTrainingEntity = new EmployeeTraining_Entity();

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getInstitutionId() {
        return institutionId;
    }

    public void setInstitutionId(String institutionId) {
        this.institutionId = institutionId;
    }

    public String getSponsoredBy() {
        return sponsoredBy;
    }

    public void setSponsoredBy(String sponsoredBy) {
        this.sponsoredBy = sponsoredBy;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(String trainingId) {
        this.trainingId = trainingId;
    }

    public boolean isSelectedTraining() {
        return selectedTraining;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public void setSelectedTraining(boolean selectedTraining) {
        this.selectedTraining = selectedTraining;
    }

    /**
     * The default constructor
     */
    public EmployeeTrainingManager() {
    }

    /**
     *  The constructor instatiates the class with the specified parameters
     * @param trainingName
     * @param institution
     * @param address
     * @param period
     * @param employeeId
     * @param trainingId
     */
    public EmployeeTrainingManager(String trainingName,
            String institution,
            String startDate,
            String endDate,
            String employeeId,
            String trainingId,
            String sponsoredBy,
            String institutionId,
            String duration) {
        this.trainingName = trainingName;
        this.institution = institution;
        this.startDate = startDate;
        this.endDate = endDate;
        this.employeeId = employeeId;
        this.trainingId = trainingId;
        this.sponsoredBy = sponsoredBy;
        this.institutionId = institutionId;
        this.duration = duration;
    }

    /**
     *
     * @param employeeTrainingManager
     * @return if save training seccessfully return 1 else 0
     *
     */
    public int saveEmployeeTraining(EmployeeTrainingManager employeeTrainingManager) {
        EmployeeTraining_Entity employeeTraining = new EmployeeTraining_Entity(
                employeeTrainingManager.getTrainingName(),
                employeeTrainingManager.getInstitutionId(),
                employeeTrainingManager.getStartDate(),
                employeeTrainingManager.getEndDate(),
                employeeTrainingManager.getEmployeeId(),
                employeeTrainingManager.getTrainingId(),
                employeeTrainingManager.getSponsoredBy(),
                employeeTrainingManager.getDuration());
        return employeeTrainingEntity.saveEmployeeTraining(employeeTraining);
    }

    public int updateEmployeeTraining(EmployeeTrainingManager employeeTrainingManager) {
        EmployeeTraining_Entity employeeTraining = new EmployeeTraining_Entity(
                employeeTrainingManager.getTrainingName(),
                employeeTrainingManager.getInstitutionId(),
                employeeTrainingManager.getStartDate(),
                employeeTrainingManager.getEndDate(),
                employeeTrainingManager.getEmployeeId(),
                employeeTrainingManager.getTrainingId(),
                employeeTrainingManager.getSponsoredBy(),
                employeeTrainingManager.getDuration());
        return employeeTrainingEntity.updateEmployeeTraining(employeeTraining);
    }

    public ArrayList<SelectItem> getListOfSponsored() {
        ArrayList<SelectItem> listOfSponsore = new ArrayList<SelectItem>();
        listOfSponsore.add(new SelectItem(null, "-- Select Sponsored By --"));
        listOfSponsore.add(new SelectItem("SELF", "SELF"));
        listOfSponsore.add(new SelectItem("BIB", "BIB"));
        listOfSponsore.add(new SelectItem("OTHER", "OTHER"));

        return listOfSponsore;
    }

    public ArrayList<HashMap> readEmployeeTraining(String employeeId) {
        return employeeTrainingEntity.readEmployeeTraining(employeeId);
    }

    public int deleteEmployeeTraining(String empTraId) {
        return employeeTrainingEntity.deleteEmployeeTraining(empTraId);
    }
}

