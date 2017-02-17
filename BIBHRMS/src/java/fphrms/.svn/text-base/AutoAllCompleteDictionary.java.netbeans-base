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
import manager.employeeManager.EmployeeManage;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 *
 * @author Dereje
 */
public class AutoAllCompleteDictionary {

    private static Log log = LogFactory.getLog(AutoCompleteDictionary.class);

    // list of cities.
    public static List dictionary;
    public static List dictionary1;
    static List cityList = null;
    static List cityListMP = null;
    public static String componentID;
    public static String componentValueID;
    static EmployeeManage empMgt = new EmployeeManage();
    private List empList = new ArrayList<List>();
    private List empListMP = new ArrayList<List>();

    public List getEmpList() {
        return empList;
    }

    public void setEmpList(List empList) {
        this.empList.clear();
        this.empList = empList;
    }

    public List getEmpListMP() {
        return empListMP;
    }

    public void setEmpListMP(List empListMP) {
        this.empListMP.clear();
        this.empListMP = empListMP;
    }

    public static List getDictionary() {
        return dictionary;
    }

    public static void setDictionary(List dictionary) {
        AutoAllCompleteDictionary.dictionary = dictionary;
    }

    public static List getDictionary1() {
        return dictionary1;
    }

    public static void setDictionary1(List dictionary1) {
        AutoAllCompleteDictionary.dictionary1 = dictionary1;
    }

    public AutoAllCompleteDictionary() {
        // initialize the ditionary
        try {
            log.info("initializing dictionary");
        //  init();
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

    public static void init(String employeeName, boolean withPhoto) {
        // Raw list of xml cities.
        List employeeList = null;
        List cityListMP = null;
        EmployeeManage empMgt = new EmployeeManage();
        // get the xml stream and decode it.
        try {
            if (withPhoto) {
                employeeList = empMgt.employeeNametoAutoList(employeeName);
            } else {
                employeeList = empMgt.employeeNameWithOutPhoto(employeeName);
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        try {
            if (employeeList != null) {
                dictionary = new ArrayList(employeeList.size());
                EmployeeList tmpCity;
                for (int i = 0, max = employeeList.size(); i < max; i++) {
                    tmpCity = (EmployeeList) employeeList.get(i);
                    if (tmpCity != null && tmpCity.getFullName() != null) {
                        dictionary.add(new SelectItem(tmpCity, tmpCity.getFullName()));
                    }
                }
                employeeList.clear();
                // finally sort the list
                Collections.sort(dictionary, LABEL_COMPARATOR);
            }
            if (cityListMP != null) {
                dictionary1 = new ArrayList(cityListMP.size());
                EmployeeList tmpCity;
                for (int i = 0, max = cityListMP.size(); i < max; i++) {
                    tmpCity = (EmployeeList) cityListMP.get(i);
                    if (tmpCity != null && tmpCity.getFullName() != null) {
                        dictionary1.add(new SelectItem(tmpCity, tmpCity.getFullName()));
                    }
                }
                cityListMP.clear();
                // finally sort the list
                Collections.sort(dictionary1, LABEL_COMPARATOR);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void init(String spouseName) {
        // Raw list of xml cities.
        List cityList = null;
        List cityListMP = null;
        EmployeeManage empMgt = new EmployeeManage();
        // get the xml stream and decode it.
        try {
          //  cityList = empMgt.spouseName(spouseName);
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            return;
        } catch (Exception e) {
            e.printStackTrace();
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
            ex.printStackTrace();
        }
    }

//    public void init(String employeeName, String component_ID, String componentValue_ID) {
//        // Raw list of xml cities.
//        // get the xml stream and decode it.
//        try {
//
//            if (component_ID != null && componentValue_ID != null) {
//
//                getEmpList().clear();
//                getDictionary().clear();
//                empMgt = new EmployeeManage();
//                setEmpList(empMgt.EmployeeNametoAutoList(component_ID, componentValue_ID, employeeName));
//
//                getEmpListMP().clear();
//                getDictionary1().clear();
//                empMgt = new EmployeeManage();
//                setEmpListMP(empMgt.EmployeeNametoAutoList(component_ID, componentValue_ID, employeeName));
//            }
//        } catch (ArrayIndexOutOfBoundsException e) {
//
//            return;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return;
//        }
//
//        try {
//            if (getEmpList() != null) {
//                dictionary = new ArrayList(getEmpList().size());
//                EmployeeList tmpCity;
//                for (int i = 0, max = getEmpList().size(); i < max; i++) {
//                    tmpCity = (EmployeeList) getEmpList().get(i);
//                    if (tmpCity != null && tmpCity.getFullName() != null) {
//                        dictionary.add(new SelectItem(tmpCity, tmpCity.getFullName()));
//                    }
//                }
//                getEmpList().clear();
//                // finally sort the list
//                Collections.sort(dictionary, LABEL_COMPARATOR);
//
//            }
//
//            if (getEmpListMP() != null) {
//                dictionary1 = new ArrayList(getEmpListMP().size());
//                EmployeeList tmpCity;
//                for (int i = 0, max = getEmpListMP().size(); i < max; i++) {
//                    tmpCity = (EmployeeList) getEmpListMP().get(i);
//                    if (tmpCity != null && tmpCity.getFullName() != null) {
//                        dictionary1.add(new SelectItem(tmpCity, tmpCity.getFullName()));
//                    }
//                }
//                getEmpListMP().clear();
//                // finally sort the list
//                Collections.sort(dictionary1, LABEL_COMPARATOR);
//
//            }
//        } catch (Exception ex) {
//            ex.getMessage();
//
//        }
//    }
}
