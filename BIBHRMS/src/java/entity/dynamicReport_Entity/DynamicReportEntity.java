/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entity.dynamicReport_Entity;

import connectionProvider.ConnectionManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author tomgenial
 */
public class DynamicReportEntity extends ConnectionManager {

    private PreparedStatement ps;
    private ResultSet rs;
    private Connection conn;

    public DynamicReportEntity() {
    }

    public ArrayList<HashMap> getViewName() {
        String selectQuery = "SELECT * FROM DBA_VIEWS WHERE OWNER= 'HRMS'";
        try {
            conn = getConnection();
            ps = conn.prepareStatement(selectQuery);
            rs = ps.executeQuery();
            ArrayList<HashMap> listNameOfView = new ArrayList<HashMap>();
            while (rs.next()) {
                HashMap hm = new HashMap();
                hm.put("VIEW_NAME", rs.getString("VIEW_NAME"));
                listNameOfView.add(hm);
            }
            return listNameOfView;
        } catch (Exception e) {
            return null;
        }

    }
}
