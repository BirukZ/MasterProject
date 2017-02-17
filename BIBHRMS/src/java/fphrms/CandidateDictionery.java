/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms;

/**
 *
 * @author Administrator
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import manager.recruitmentManager.CandidateManager;

/**
 * Application-scope bean used to store static lookup information for
 * AutoComplete (selectInputText) example. Statically referenced by
 * AutoCompleteBean as the dictionary is rather large.
 *
 * @see AutoCompleteBean
 */
public class CandidateDictionery {

    private static Log log = LogFactory.getLog(CandidateDictionery.class);

    // list of cities.
    public static List dictionary;

    public static List getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List dictionary) {
        CandidateDictionery.dictionary = dictionary;
    }

    public CandidateDictionery() {
        // initialize the ditionary
        try {
            log.info("initializing dictionary");
            init();
        } catch (Exception e) {
            if (log.isErrorEnabled()) {
                log.error("Error initializtin sorting list");
            }
        }
    }
    /**
     * Comparator utility for sorting city names.
     */
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

    public static void init() {
        // Raw list of xml cities.
        List cityList = null;
        CandidateManager empMgt = new CandidateManager();
        // get the xml stream and decode it.
        try {
            cityList = empMgt.EmployeeNametoAutoList();

        } catch (ArrayIndexOutOfBoundsException e) {

            return;
        } catch (Exception e) {

            return;
        }

        try {
            if (cityList != null) {
                dictionary = new ArrayList(cityList.size());
                EmployeeList tmpCity;
                for (int i = 0, max = cityList.size(); i < max; i++) {
                    tmpCity = (EmployeeList) cityList.get(i);
                    if (tmpCity != null && tmpCity.getFullName() != null) {
                        dictionary.add(new SelectItem(tmpCity, tmpCity.getFullName()));
                    }
                }
                cityList.clear();
                // finally sort the list
                Collections.sort(dictionary, LABEL_COMPARATOR);
            }
        } catch (Exception ex) {
        }
    }
}
