/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.dailyWorkerManager;

import com.sun.webui.jsf.model.Option;
import entity.dailyWorkerEntity.DailyWorkerAttendanceApproveEntity;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author Administrator
 */
public class DailyWorkerAttendanceApproveManager {
private DailyWorkerAttendanceApproveEntity dilyWorkerAttManager=null;
    public ArrayList<SelectItem> getMonthList() {

        ArrayList<SelectItem> monthList = new ArrayList<SelectItem>();
        DateFormatSymbols dfs = new DateFormatSymbols();
        String[] months = dfs.getMonths();
        monthList.add(new SelectItem(null, " Select Month "));
        for (int i = 0; i < 12; i++) {
            monthList.add(new SelectItem(months[i].toUpperCase(), months[i].toUpperCase()));
        }

        return monthList;
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String userName) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName);
        return decisionLists;
    }

    public ArrayList<HashMap> getListOfDailyWorkerAttendace(String month) {
        try {
            checkObject();

            return dilyWorkerAttManager.getListOfApproveAbsent(month);
        } catch (Exception e) {
             return null;
        }
    }
    private void checkObject(){
        if(dilyWorkerAttManager==null){
             dilyWorkerAttManager=new DailyWorkerAttendanceApproveEntity();
        }
    }
}
