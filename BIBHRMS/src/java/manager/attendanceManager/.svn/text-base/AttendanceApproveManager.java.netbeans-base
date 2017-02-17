
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.attendanceManager;

import com.sun.webui.jsf.model.Option;
import entity.attendanceEntity.AttendanceApproveEntity;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.servlet.http.HttpServletRequest;
import manager.globalUseManager.StringDateManipulation;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author Administrator
 */
public class AttendanceApproveManager {

    private AttendanceApproveEntity attendanceApproveEntity = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<HashMap> listOfAbset(String bossId) {
        check();
        try {
            DateFormatSymbols dfs = new DateFormatSymbols();
            int month = StringDateManipulation.getMonth(sdf.format(new Date()));
            month -= 1;
            return attendanceApproveEntity.getListOfAbset(bossId, dfs.getMonths()[month].toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
      public ArrayList<HashMap> listOfAbset(String bossId,String month) {
        check();
        try {
            return attendanceApproveEntity.getListOfAbset(bossId, month);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void check() {
        if (attendanceApproveEntity == null) {
            attendanceApproveEntity = new AttendanceApproveEntity();
        }
    }

//    public ArrayList<SelectItem> getListOfDecision() {
//        ArrayList<SelectItem> listOfDecision = new ArrayList<SelectItem>();
//        listOfDecision.add(new SelectItem(null, "Select Decision"));
//        listOfDecision.add(new SelectItem("Approve", "Approve"));
//        listOfDecision.add(new SelectItem("Resubmit", "Resubmit"));
//        listOfDecision.add(new SelectItem("Reject", "Reject"));
//
//        return listOfDecision;
//    }

    public boolean saveApproveAttendanceRecord(ArrayList<HashMap> listOfAbsent,
            String reamark, String decisionerId, String decision) {
        check();
        try {
            return attendanceApproveEntity.saveApproveAttendanceRecord(listOfAbsent,
                    reamark, decisionerId, decision);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
   public ArrayList<Option> getAvailableDecisionsToMake(String userName) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName);
        return decisionLists;
    }

   

   
}
