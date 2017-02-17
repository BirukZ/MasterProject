/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.dailyWorkerManager;

import entity.dailyWorkerEntity.DailyWorkerAttendanceEntity;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author Administrator
 */
public class DailyWorkerAttendanceManager {

    private DailyWorkerAttendanceEntity dailyWorkerAttendanceEntity = null;

    public boolean saveDailyworkerAttendance(ArrayList<HashMap> listOfDailyWork) {
        try {
            checkObject();
            return dailyWorkerAttendanceEntity.saveDailyworkerAttendance(listOfDailyWork);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public ArrayList<HashMap> readDailyWorkerAttendance(String attendanceTakenDate, String job) {
        try {
            checkObject();
            return dailyWorkerAttendanceEntity.readrDailyWorkerAttendance(attendanceTakenDate, job);
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public boolean deleteWorkerAttendance(String attendanceTakenDate, String job) {
        try {
            checkObject();
            return dailyWorkerAttendanceEntity.deleteWorkerAttendance(attendanceTakenDate);
        } catch (Exception ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private void checkObject() {
        if (dailyWorkerAttendanceEntity == null) {
            dailyWorkerAttendanceEntity = new DailyWorkerAttendanceEntity();
        }
    }
}
