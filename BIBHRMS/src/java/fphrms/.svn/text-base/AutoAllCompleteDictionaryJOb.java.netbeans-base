/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.faces.model.SelectItem;
import manager.organizationManager.JobTypeManager;

/**
 *
 * @author Administrator
 */
public class AutoAllCompleteDictionaryJOb {

      public static List dictionary;

    public static void init(String jobName) {
        // Raw list of xml cities.
        List jobList = null;
        List cityListMP = null;
        JobTypeManager empJob = new JobTypeManager();
        // get the xml stream and decode it.
        try {

            jobList = empJob.jobNameForAutoList(jobName);

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            if (jobList != null) {
                dictionary = new ArrayList(jobList.size());
                JobList tmpCity;
                for (int i = 0, max = jobList.size(); i < max; i++) {
                    tmpCity = (JobList) jobList.get(i);
                    if (tmpCity != null && tmpCity.getJobName() != null) {
                        dictionary.add(new SelectItem(tmpCity, tmpCity.getJobName()));
                    }
                }
                jobList.clear();
                // finally sort the list
                Collections.sort(dictionary, LABEL_COMPARATOR);
            }
//            if (cityListMP != null) {
//                dictionary1 = new ArrayList(cityListMP.size());
//                EmployeeList tmpCity;
//                for (int i = 0, max = cityListMP.size(); i < max; i++) {
//                    tmpCity = (EmployeeList) cityListMP.get(i);
//                    if (tmpCity != null && tmpCity.getFullName() != null) {
//                        dictionary1.add(new SelectItem(tmpCity, tmpCity.getFullName()));
//                    }
//                }
//                cityListMP.clear();
//                // finally sort the list
//                Collections.sort(dictionary1, LABEL_COMPARATOR);
//            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

      public static final Comparator LABEL_COMPARATOR = new Comparator() {

        String s1;
        String s2;

        // compare method for city entries.
        public int compare(Object o1, Object o2) {

            if (o1 instanceof SelectItem) {
                s1 = ((SelectItem) o1).getLabel();
            } else {
                s1 = o1.toString();
            }

            if (o2 instanceof SelectItem) {
                s2 = ((SelectItem) o2).getLabel();
            } else {
                s2 = o2.toString();
            }
            // compare ingnoring case, give the user a more automated feel when typing
            return s1.compareToIgnoreCase(s2);
        }
    };


    public static List getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List dictionary) {
        AutoAllCompleteDictionaryJOb.dictionary = dictionary;
    }


}
