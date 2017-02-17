/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package manager.recruitmentManager;
import entity.recruitmentEntity.JasperReportEntity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import javax.swing.JOptionPane;
import manager.ReportCritera.ReportCriteraManager;

/**
 *
 * @author BravoZulu
 */
public class JasperReport {

     JasperReportEntity jasperEntiyt=new JasperReportEntity();
     ArrayList<HashMap> expirance=new ArrayList<HashMap>();
     public static HashMap parametrsForDay = new HashMap();
     public ArrayList<HashMap> loadCandidateInformationForReport()
     {


        try {
         
                return jasperEntiyt.loadCandidateInformationForReport(ReportCriteraManager.getParametrsCandiateSelection());

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }

    }

    public Collection loadEmployeeInformationForReport(String empID) {
         try {

           return jasperEntiyt.loadEmployeeInformationForReport(empID);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////

     public Collection loadEmployeeEducationInformationForReport(String empID) {
         try {

           return jasperEntiyt.loadEmployeeEducationInformationForReport(empID);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////


     public Collection loadEmployeeExoiranceInforamrionForReport(String empID) {
         try {

           return jasperEntiyt.loadEmployeeExpiranceReport(empID);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }

      public Collection loadEmployeeTrainigInforamrionForReport(String empID) {
         try {

           return jasperEntiyt.loadEmployeeTrainingReport(empID);

        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
    }



}
