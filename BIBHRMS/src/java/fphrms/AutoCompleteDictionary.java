package fphrms;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.faces.model.SelectItem;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import manager.employeeManager.EmployeeManage;

/**
 * Application-scope bean used to store static lookup information for
 * AutoComplete (selectInputText) example. Statically referenced by
 * AutoCompleteBean as the dictionary is rather large.
 *
 * @see AutoCompleteBean
 */
public class AutoCompleteDictionary {

    private static Log log = LogFactory.getLog(AutoCompleteDictionary.class);

    // list of cities.
    public static List dictionary;
    //static List empList = null;
    static List empList = new ArrayList<List>();
    public static String componentID;
    public static String componentValueID;

    public static List getEmpList() {
        return empList;
    }

    public static void setEmpList(List empList) {
        AutoCompleteDictionary.empList = empList;
    }
    static EmployeeManage empMgt = new EmployeeManage();

    public static List getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List dictionary) {
        AutoCompleteDictionary.dictionary = dictionary;
    }

    public AutoCompleteDictionary()
    {
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
        // get the xml stream and decode it.
        try {
            empList = empMgt.EmployeeNametoAutoList();
//            if (componentID != null && componentValueID != null) {
//                empList = empMgt.EmployeeNametoAutoList(componentID, componentValueID);
//            }
        } catch (ArrayIndexOutOfBoundsException e) {
            return;
        } catch (Exception e) {
            return;
        }

        try {
            if (empList != null) {
                dictionary = new ArrayList(empList.size());
                EmployeeList tmpCity;
                for (int i = 0, max = empList.size(); i < max; i++) {
                    tmpCity = (EmployeeList) empList.get(i);
                    if (tmpCity != null && tmpCity.getFullName() != null) {
                        dictionary.add(new SelectItem(tmpCity, tmpCity.getFullName()));
                    }
                }
                empList.clear();
                // finally sort the list
                Collections.sort(dictionary, LABEL_COMPARATOR);

            }
        } catch (Exception ex) {
        }
    }

    public void init(String employeeName, String component_ID, String componentValue_ID) {
        // Raw list of xml cities.
        // get the xml stream and decode it.
        try {
            if (component_ID != null && componentValue_ID != null) {
                getEmpList().clear();
                empMgt = new EmployeeManage();
                setEmpList(empMgt.EmployeeNametoAutoList(employeeName));
            }
        } catch (ArrayIndexOutOfBoundsException e) {

            return;
        } catch (Exception e) {

            return;
        }

        try {
            if (getEmpList() != null) {
                dictionary = new ArrayList(getEmpList().size());
                EmployeeList tmpCity;
                for (int i = 0, max = getEmpList().size(); i < max; i++) {
                    tmpCity = (EmployeeList) getEmpList().get(i);
                    if (tmpCity != null && tmpCity.getFullName() != null) {
                        dictionary.add(new SelectItem(tmpCity, tmpCity.getFullName()));
                    }
                }
                getEmpList().clear();
                // finally sort the list
                Collections.sort(dictionary, LABEL_COMPARATOR);
            }
        } catch (Exception ex) {
            ex.getMessage();

        }
    }
}
