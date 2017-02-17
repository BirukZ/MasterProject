/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package manager.promotionManager;

import entity.Promotion.PromoteReportEntity;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.model.SelectItem;

/**
 *
 * @author thecode
 */
public class PromoteReportManager {

    private PromoteReportEntity promoteReportEntity = new PromoteReportEntity();

    public ArrayList<SelectItem> promotionBachCodeList() {
        try {

            ArrayList<SelectItem> bachCodeList = new ArrayList<SelectItem>();
            ArrayList<PromoteReportEntity> readRecruitmentRequests = promoteReportEntity.promotionBachCodeList();
            if (readRecruitmentRequests.size() > 0) {
                bachCodeList.add(new SelectItem(null, "Select Bach Code"));
                for (int i = 0; i < readRecruitmentRequests.size(); i++) {
                    promoteReportEntity = readRecruitmentRequests.get(i);
                    bachCodeList.add(new SelectItem(promoteReportEntity.getBachCode(), promoteReportEntity.getBachCode()));
                }

                return bachCodeList;
            } else {
                bachCodeList.add(new SelectItem(null, "Promotion  Bach Code Not Available "));
                return null;
            }

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public ArrayList<HashMap> employeePromotionReport(String bachCode) {
        try {
            return promoteReportEntity.promotionExapResultReport(bachCode);

        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<HashMap> promotedEmployeeExamResultReport(String bachCode) {
        try {
            return promoteReportEntity.promotedEmployeeExamResultReport(bachCode);

        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<HashMap> promotionReportByDate(String promotionDate, String promotionEndDate) {
        try {
            return promoteReportEntity.promotionReportByDate(promotionDate, promotionEndDate);

        } catch (Exception e) {
            return null;
        }

    }

    public ArrayList<HashMap> promotionReportByDate(String bachCode) {
        try {
            return promoteReportEntity.promotionReportByDate(bachCode);

        } catch (Exception e) {
            return null;
        }

    }
}
