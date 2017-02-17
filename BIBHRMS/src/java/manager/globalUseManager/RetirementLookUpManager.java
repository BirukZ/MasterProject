/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.globalUseManager;

import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;
import java.util.ArrayList;
import entity.globalUseEntity.RetirementLookUpEntity;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author DPClone
 */
public class RetirementLookUpManager {

    RetirementLookUpEntity retirementLookUpEmtity = new RetirementLookUpEntity();
    private String resignTypeID;

    public String getResignTypeID() {
        return resignTypeID;
    }

    public void setResignTypeID(String resignTypeID) {
        this.resignTypeID = resignTypeID;
    }
    private String resignType;

    public String getResignType() {
        return resignType;
    }

    public void setResignType(String resignType) {
        this.resignType = resignType;
    }
    private Option[] resignTypesList;

    public Option[] getResignTypesList() {
        return resignTypesList;
    }

    public void setResignTypesList(Option[] resignTypesList) {
        this.resignTypesList = resignTypesList;
    }
    private String resignationDescription;

    public String getResignationDescription() {
        return resignationDescription;
    }

    public void setResignationDescription(String resignationDescription) {
        this.resignationDescription = resignationDescription;
    }

    public ArrayList<RetirementLookUpEntity> readResignTypes(String val) {
        try {
            return retirementLookUpEmtity.readResignType(val);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Option[] loadTerminationTypesToDropdownList(String val) {
        try {
            Option firstIndexFound = new Option("-- Select Resign Type --");
            Option firstIndexNo = new Option("-- No Resign type was found --");
            ArrayList<RetirementLookUpEntity> resignationTypes = this.readResignTypes(val);
            if (resignationTypes.size() > 0) {
                resignTypesList = new Option[resignationTypes.size() + 1];
                resignTypesList[0] = firstIndexFound;
                for (int i = 0; i < resignationTypes.size(); i++) {
                    retirementLookUpEmtity = resignationTypes.get(i);
                    Option resign = new Option(retirementLookUpEmtity.getResignTypeId(), retirementLookUpEmtity.getResignsTypeList());
                    resignTypesList[i + 1] = resign;
                }
            } else {
                resignTypesList[0] = firstIndexNo;
            }
            return resignTypesList;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return null;
        }
    }

    public HashMap readResignationTypeDetails(String _resignId) {

        try {
            RetirementLookUpEntity _rs = null;
            _rs = retirementLookUpEmtity.readResignationTypeDetails(_resignId);
            if (_rs != null) {
                HashMap data = new HashMap();
                data.put("resignTypeId", _rs.getResignTypeId());
                data.put("resignName", _rs.getResignType());
                data.put("resignDescription", _rs.getResignationDescription());
                data.put("resignGroup", _rs.getGroup_setting());
                return data;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }

    }

    public HashMap readRetireTypeDetails(String _resignId) {
        try {
            RetirementLookUpEntity _rs = null;
            _rs = retirementLookUpEmtity.readRetireTypeDetails(_resignId);
            if (_rs != null) {
                HashMap data = new HashMap();
                data.put("resignTypeId", _rs.getResignTypeId());
                data.put("resignName", _rs.getResignType());
                data.put("resignDescription", _rs.getResignationDescription());
                return data;
            } else {
                return null;
            }
        } catch (Exception ex) {
            return null;
        }
    }

    public int addNewTerminationType(String _resignationName, String _resignationDescription, String group_Setting) {
        try {
            RetirementLookUpEntity _newResignationType = new RetirementLookUpEntity();
            _newResignationType.addNewTerminationType(_resignationName, _resignationDescription, group_Setting);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public int addNewRetireType(String _resignationName, String _resignationDescription) {
        try {
            RetirementLookUpEntity _newResignationType = new RetirementLookUpEntity();
            _newResignationType.addNewRetireType(_resignationName, _resignationDescription);
            return 1;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return 0;
        }

    }

    public void updateTerminationType(String _resignID, String _resignationType, String _resignationDescription, String group_Setting) {
        try {
            RetirementLookUpEntity _updateResignationType = new RetirementLookUpEntity();
            _updateResignationType.updateResignationType(_resignID, _resignationType, _resignationDescription, group_Setting);
        } catch (Exception ex) {
        }
    }

    public void updateRetireType(String _resignID, String _resignationType, String _resignationDescription) {
        try {
            RetirementLookUpEntity _updateResignationType = new RetirementLookUpEntity();
            _updateResignationType.updateRetireType(_resignID, _resignationType, _resignationDescription);
        } catch (Exception ex) {
        }
    }

    public void DeleteTerminationType(String _resignID) {
        try {
            RetirementLookUpEntity _deleteResignationType = new RetirementLookUpEntity(_resignID);
            _deleteResignationType.deleteResignationType(_resignID);
        } catch (Exception ex) {
        }
    }

    public void DeleteRetireType(String _resignID) {
        try {
            RetirementLookUpEntity _deleteResignationType = new RetirementLookUpEntity(_resignID);
            _deleteResignationType.deleteRetireType(_resignID);
        } catch (Exception ex) {
        }
    }
}
