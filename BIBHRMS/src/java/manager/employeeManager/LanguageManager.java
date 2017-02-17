/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.globalUseEntity.LookUpEntity;
import entity.languageEntity.LanguageEntity;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class LanguageManager {

    public LanguageManager() {
    }
    String listening;
    String speaking;
    String reading;
    String writing;
    String languageType;
    String empId;
    String id;
    boolean selectedLanguage;

    public boolean isSelectedLanguage() {
        return selectedLanguage;
    }

    public void setSelectedLanguage(boolean selectedLanguage) {
        this.selectedLanguage = selectedLanguage;
    }
    int avilbleLanguage;

    public int getAvilbleLanguage() {
        return avilbleLanguage;
    }

    public void setAvilbleLanguage(int avilbleLanguage) {
        this.avilbleLanguage = avilbleLanguage;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
    public String language_description;

    public String getLanguage_description() {
        return language_description;
    }

    public void setLanguage_description(String language_description) {
        this.language_description = language_description;
    }

    public LanguageManager(String listening, String speaking, String reading, String writing, String languageType, String empId, String id, String language_description) {
        this.listening = listening;
        this.speaking = speaking;
        this.reading = reading;
        this.writing = writing;
        this.languageType = languageType;
        this.empId = empId;
        this.id = id;
        this.language_description = language_description;
    }
    LanguageEntity languageEntity = new LanguageEntity();

    public int saveEmployeeLanguage(LanguageManager languageManager, int perform) {

        LanguageEntity employeeLanguage = new LanguageEntity(languageManager.getListening(),
                languageManager.getSpeaking(),
                languageManager.getReading(),
                languageManager.getWriting(),
                languageManager.getLanguageType(),
                languageManager.getEmpId(), languageManager.getId());
        if (perform == 1) {
            return languageEntity.saveEmployeeLanguage(employeeLanguage);
        } else {
            return languageEntity.updateEmployeeLanguage(employeeLanguage);
        }

    }
    LookUpEntity lookUpEntity = new LookUpEntity();

    public boolean saveLanguageType(String languageName) {
        return lookUpEntity.insertLanguageType(languageName);
    }

      public boolean saveInstiutationType(String InstiutioanName)
    {

        return lookUpEntity.insertInsatiutaitonType(InstiutioanName);
    }


       public boolean saveLocationType(String LocationName)
    {

        return lookUpEntity.insertLocationType(LocationName);
    }



    public HashMap[] readEmployeeLanguage(String employeeID) {
        return languageEntity.readLanguage(employeeID);
    }

    public int countEmployeeLanguage(String employeeID) {
        return languageEntity.countEmployeeLanguage(employeeID);

    }

    public int deleteEmployeeLanguage(String educationId) {
        return languageEntity.deleteEmployeeLanguage(educationId);
    }

    public String readLanguageName(String languageCode) {
        return languageEntity.readLanguageName(languageCode);
    }
}
