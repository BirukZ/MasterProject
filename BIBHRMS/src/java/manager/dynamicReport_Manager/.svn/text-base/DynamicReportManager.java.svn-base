/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.dynamicReport_Manager;

import entity.dynamicReport_Entity.DynamicReportEntity;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author tomgenial
 */
public class DynamicReportManager {
private DynamicReportEntity  dynamicReportEntity=new DynamicReportEntity();

public ArrayList<SelectItem> getViewName(){
    ArrayList<SelectItem> listOfView=new ArrayList<SelectItem>();
    ArrayList<HashMap> listOfViewName=dynamicReportEntity.getViewName();
    try {
        for(HashMap hm:listOfViewName){
            listOfView.add(new SelectItem(hm.get("VIEW_NAME").toString(),
                    hm.get("VIEW_NAME").toString() ));
        }

            listOfView.add(new SelectItem(null,
                    "SELECT VIEW" ));
        return listOfView;
    } catch (Exception e) {
        e.printStackTrace();
        return null;
    }
}
}
