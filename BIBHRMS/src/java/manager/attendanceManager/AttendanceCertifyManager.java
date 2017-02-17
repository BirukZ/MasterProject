/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.attendanceManager;

import com.sun.webui.jsf.model.Option;
import entity.attendanceEntity.AttendanceCertifyEntity;

import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import manager.globalUseManager.StringDateManipulation;
import manager.userManagement.SiteSecurityManager;

/**
 *
 * @author Administrator
 */
public class AttendanceCertifyManager {

    private AttendanceCertifyEntity attendanceCertifyEntity = null;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ArrayList<HashMap> listOfApproveAbsent() {
        check();
        try {
            DateFormatSymbols dfs = new DateFormatSymbols();
            int month = StringDateManipulation.getMonth(sdf.format(new Date()));
            month -= 1;
            return attendanceCertifyEntity.getListOfApproveAbsent(dfs.getMonths()[month].toUpperCase());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> listOfApproveAbsent(String month) {
        check();
        try {
            return attendanceCertifyEntity.getListOfApproveAbsent(month);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public ArrayList<Option> getAvailableDecisionsToMake(String userName) {
        ArrayList<Option> decisionLists = new ArrayList<Option>();
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        decisionLists = new SiteSecurityManager().getAvailableDecisions(request.getRequestURI(), userName);
        return decisionLists;
    }

    public boolean saveCertifyAttendanceRecord(ArrayList<HashMap> listOfAbsent,
            String reamark, String decisionerId, String decision, String month) {
        check();
        try {
            return attendanceCertifyEntity.saveCertifyAttendanceRecord(listOfAbsent,
                    reamark, decisionerId, decision,month);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private void check() {
        if (attendanceCertifyEntity == null) {
            attendanceCertifyEntity = new AttendanceCertifyEntity();

        }

    }
}
