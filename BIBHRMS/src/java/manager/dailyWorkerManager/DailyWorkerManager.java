/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.dailyWorkerManager;

import entity.dailyWorkerEntity.DailyWorkerEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author Administrator
 */
public class DailyWorkerManager {

    private DailyWorkerEntity dailyWorkerEntity = null;

    public boolean saveRequritementType(HashMap list) {
        try {
            checkObject();
            return dailyWorkerEntity.saveRequritementType(list);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean saveDailyWorkerInformation(ArrayList<HashMap> listOfDailyWorker) {
        try {
            checkObject();
            return dailyWorkerEntity.saveDailyWorkerInformation(listOfDailyWorker);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateDailyWorkerInformation(HashMap listOfDailyWorker) {
        try {
            checkObject();
            return dailyWorkerEntity.updateDailyWorkerInformation(listOfDailyWorker);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteDailyWorkerInformation(String dailyWorkerId) {
        try {
            checkObject();
            return dailyWorkerEntity.deleteDailyWorkerInformation(dailyWorkerId);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean updateRequritementType(HashMap list) {
        try {
            checkObject();
            return dailyWorkerEntity.updateRequritementType(list);
        } catch (Exception e) {
            return false;
        }
    }

    public ArrayList<SelectItem> listOfRequriment() {
        try {
            checkObject();
            ArrayList<SelectItem> listOfRequment = new ArrayList<SelectItem>();
            ArrayList<HashMap> list = dailyWorkerEntity.listOfRequrment();
            listOfRequment.add(new SelectItem(null, "Select Avilebel Job"));
            for (HashMap hm : list) {
                listOfRequment.add(new SelectItem(hm.get("ID"), hm.get("job_description").toString() + "-(" +
                        hm.get("STARTDATE").toString() + "--" + hm.get("ENDDATE").toString() + ")"));
            }
            return listOfRequment;
        } catch (Exception e) {
            return null;
        }
    }

    public ArrayList<HashMap> getListODayilyWorker(String jobId) {
        try {
            checkObject();
            return dailyWorkerEntity.listOfDailyWorker(jobId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
        public ArrayList<HashMap> getListODayilyWorkerForAttendance(String jobId) {
        try {
            checkObject();
            return dailyWorkerEntity.listOfDailyWorkerforAttendance(jobId);

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void checkObject() {
        if (dailyWorkerEntity == null) {
            dailyWorkerEntity = new DailyWorkerEntity();
        }
    }

    public static void main(String arg[]) {
        DailyWorkerManager obj = new DailyWorkerManager();
        obj.getListODayilyWorker(null);
    }
}
