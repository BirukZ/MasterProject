/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.trainingManager;

import entity.trainingEntity.TrainingCandidateEntity;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author DP
 */
public class TrainingCandidateManager {

    TrainingCandidateEntity trainingCandidateEntity = new TrainingCandidateEntity();

    public Set<HashMap> ReadEmployeeFromDepartment(String departmentID) {
        ResultSet _rs = null;
        Set<HashMap> _list = new HashSet<HashMap>();
        try {
            _rs = trainingCandidateEntity.ReadEmployeeFromDepartment(departmentID);
            if (_rs != null) {
                while (_rs.next()) {
                    
                    HashMap data = new HashMap();
                    data.put("employeeID", _rs.getString("EMP_ID"));
                    data.put("employeeFullName", _rs.getString("FIRST_NAME") + " " + _rs.getString("MIDDLE_NAME") + " " + _rs.getString("LAST_NAME"));
                    data.put("employeeTitle", _rs.getString("TITLE_DESCRIPTION"));
                    data.put("employeeRank", _rs.getString("RANK_ID"));
                    data.put("employeePosition", _rs.getString("JOB_DESCRIPTION"));
                    _list.add(data);
                }
                return _list;
            } else {
                HashMap data = new HashMap();
                data.put("employeeID", "");
                data.put("employeeFullName", "");
                data.put("employeeTitle", "");
                data.put("employeeRank", "");
                data.put("employeePosition", "");
                _list.add(data);
                return _list;
            }

        } catch (Exception ex) {
            ex.printStackTrace();

            return null;
        }
    }

    public int UpdateCandidateList() {
        try {
            return 1;
        } catch (Exception ex) {
            return 0;
        }
    }
}
