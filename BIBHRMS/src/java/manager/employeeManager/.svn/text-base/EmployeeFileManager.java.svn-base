/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.employeeManager;

import entity.employeeEntity.EmployeeFileEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author ONEQAZ
 */
public class EmployeeFileManager {

    private String fileType;
    private String fileId;
    private String fileName;
    private String remark;
    private byte[] file;
    private String employeeId;
    private boolean selected;
    private String fileExtension;

    public String getFileExtension() {
        return fileExtension;
    }

    public void setFileExtension(String fileExtension) {
        this.fileExtension = fileExtension;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public byte[] getFile() {
        return file;
    }

    public void setFile(byte[] file) {
        this.file = file;
    }

    public String getFileId() {
        return fileId;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public EmployeeFileManager() {
    }

    public EmployeeFileManager(String fileType, String fileId,
            String fileName, String remark, byte[] file, String employeeId,
            String fileExtension) {
        this.fileType = fileType;
        this.fileId = fileId;
        this.fileName = fileName;
        this.remark = remark;
        this.file = file;
        this.employeeId = employeeId;
        this.fileExtension = fileExtension;

    }

    public EmployeeFileManager(String fileType, String fileId,
            String fileName, String remark, String employeeId) {
        this.fileType = fileType;
        this.fileId = fileId;
        this.fileName = fileName;
        this.remark = remark;

        this.employeeId = employeeId;
    }
    private EmployeeFileEntity employeeFileEntity = new EmployeeFileEntity();

    public ArrayList<SelectItem> readFileType() {
        String fileTypelist[] = {"Expectancy", "Medical", "Education","Relase", "Other"};
        ArrayList<SelectItem> listFileType = new ArrayList<SelectItem>();
        try {
            for (String str : fileTypelist) {
                listFileType.add(new SelectItem(str, str));
            }
            listFileType.add(0, new SelectItem(null, "Select File Type"));
            return listFileType;


        } catch (Exception e) {
            return null;
        }
    }

    public boolean saveEmployeeFile(EmployeeFileManager employeeFileManager) {
        EmployeeFileEntity fileEntity = new EmployeeFileEntity(
                employeeFileManager.getFileType(),
                employeeFileManager.getFileName(),
                employeeFileManager.getRemark(),
                employeeFileManager.getEmployeeId(),
                employeeFileManager.getFileId(),
                employeeFileManager.getFile(),
                employeeFileManager.getFileExtension());
        if (employeeFileEntity.saveEmployeeFile(fileEntity) > 0) {
            return true;
        } else {
            return false;
        }

    }

    public boolean updateEmployeeFile(EmployeeFileManager employeeFileManager) {
        try {
            EmployeeFileEntity fileEntity = new EmployeeFileEntity(
                    employeeFileManager.getFileType(),
                    employeeFileManager.getFileName(),
                    employeeFileManager.getRemark(),
                    employeeFileManager.getEmployeeId(),
                    employeeFileManager.getFileId(),
                    employeeFileManager.getFile(),
                    employeeFileManager.getFileExtension());
            if (employeeFileEntity.updateEmployeeFile(fileEntity) > 0) {
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

    public ArrayList<HashMap> readEmployeeFile(String employeeId) {
        return employeeFileEntity.readEmployeeFile(employeeId);
    }

    public int deleteEmployeeFile(String fileId) {
        return employeeFileEntity.deleteEmployeeFile(fileId);
    }
}

