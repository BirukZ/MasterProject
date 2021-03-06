/*
 * ApplicationBean1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms;

import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.web.ui.appbase.AbstractApplicationBean;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletContext;
import manager.departmentManage.DepartmentManage;

/**
 * <p>Application scope data bean for your application.  Create properties
 *  here to represent cached data that should be made available to all users
 *  and pages in the application.</p>
 *
 * <p>An instance of this class will be created for you automatically,
 * the first time your application evaluates a value binding expression
 * or method binding expression that references a managed bean using
 * this class.</p>
 */
public class ApplicationBean1 extends AbstractApplicationBean {

    private ArrayList<SelectItem> lookupTypes = new ArrayList<SelectItem>();
    //private Option[] jobOpt;
    ArrayList<SelectItem> jobOpt = new ArrayList<SelectItem>();

    public ArrayList<SelectItem> getJobOpt() {
        return departmentManage.readAllJob();
    }

    public ArrayList<SelectItem> getLookupTypesOption() {
        this.setLookupTypes(new ArrayList<SelectItem>());
        return this.getLookupTypes();
    }

    public void setJobOpt(ArrayList<SelectItem> jobOpt) {
        this.jobOpt = jobOpt;
    }

//    public Option[] getJobOpt() {
//        return jobOpt;
//    }
//
//    public void setJobOpt(Option[] jobOpt) {
//        this.jobOpt = jobOpt;
//    }

// <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    private void _init() throws Exception {

        AutoCompleteDictionary.init();
        CandidateDictionery.init();
        AutoCompleteDictionary_ForEmployeePage.init();

    }
// </editor-fold>
    /**
     * <p>Construct a new application data bean instance.</p>
     */
    DepartmentManage departmentManage = new DepartmentManage();

    public ApplicationBean1() {
    }

    /**
     * <p>This method is called when this bean is initially added to
     * application scope.  Typically, this occurs as a result of evaluating
     * a value binding or method binding expression, which utilizes the
     * managed bean facility to instantiate this bean and store it into
     * application scope.</p>
     *
     * <p>You may customize this method to initialize and cache application wide
     * data values (such as the lists of valid options for dropdown list
     * components), or to allocate resources that are required for the
     * lifetime of the application.</p>
     */
    public void init() {
        super.init();
        ServletContext theApplicationsServletContext = (ServletContext) this.getExternalContext().getContext();
        //  jobOpt =
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("ApplicationBean1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

// </editor-fold>
// Perform application initialization that must complete
// *after* managed components are initialized
// TODO - add your own initialization code here
    }

    /**
     * <p>This method is called when this bean is removed from
     * application scope.  Typically, this occurs as a result of
     * the application being shut down by its owning container.</p>
     *
     * <p>You may customize this method to clean up resources allocated
     * during the execution of the <code>init()</code> method, or
     * at any later time during the lifetime of the application.</p>
     */
    public void destroy() {
    }

    /**
     * <p>Return an appropriate character encoding based on the
     * <code>Locale</code> defined for the current JavaServer Faces
     * view.  If no more suitable encoding can be found, return
     * "UTF-8" as a general purpose default.</p>
     *
     * <p>The default implementation uses the implementation from
     * our superclass, <code>AbstractApplicationBean</code>.</p>
     */
    public String getLocaleCharacterEncoding() {
        return super.getLocaleCharacterEncoding();
    }
    private static String selectedTrainerId;

    public static String getSelectedTrainerId() {
        return selectedTrainerId;
    }

    public static void setSelectedTrainerId(String selectedTrainerId) {
        ApplicationBean1.selectedTrainerId = selectedTrainerId;
    }
    private static String selectedEmployeeId;
    private static String selectedEmployeeName;

    public static String getSelectedEmployeeName() {
        return selectedEmployeeName;
    }

    public static void setSelectedEmployeeName(String selectedEmployeeName) {
        ApplicationBean1.selectedEmployeeName = selectedEmployeeName;
    }
    //private static String selectedDeviceCode;

    public static String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public static void setSelectedEmployeeId(String selectedEmployeeId) {
        ApplicationBean1.selectedEmployeeId = selectedEmployeeId;
    }

    public int get__placeholder() {
        return __placeholder;
    }

    public void set__placeholder(int __placeholder) {
        this.__placeholder = __placeholder;
    }

    public DeviceList getCurrentDevice() {
        return currentDevice;
    }

    public void setCurrentDevice(DeviceList currentDevice) {
        this.currentDevice = currentDevice;
    }

    public DepartmentManage getDepartmentManage() {
        return departmentManage;
    }

    public void setDepartmentManage(DepartmentManage departmentManage) {
        this.departmentManage = departmentManage;
    }

    public List getMatchesList() {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }

    public List getMatchesTrainerList() {
        return matchesTrainerList;
    }

    public void setCurrentEmployee(EmployeeList currentEmployee) {
        this.currentEmployee = currentEmployee;
    }

    public String[][] getEncoding() {
        return encoding;
    }

    public void setEncoding(String[][] encoding) {
        this.encoding = encoding;
    }

    public void setMatchesTrainerList(List matchesTrainerList) {
        this.matchesTrainerList = matchesTrainerList;
    }

//    public static String getSelectedDeviceCode() {
//        return selectedDeviceCode;
//    }
//
//    public static void setSelectedDeviceCode(String selectedDeviceCode) {
//        ApplicationBean1.selectedDeviceCode = selectedDeviceCode;
//    }
    EmployeeList currentEmployee = new EmployeeList("", "0");
    DeviceList currentDevice = new DeviceList("", "");

    public EmployeeList getCurrentEmployee() {
        return currentEmployee;
    }
    List matchesTrainerList = new ArrayList<SelectItem>();

    public List getTrainerList() {
        return matchesTrainerList;
    }
    List matchesList = new ArrayList<SelectItem>();
    List devicematchesList = new ArrayList<SelectItem>();
    List candidateMatchList=new ArrayList<SelectItem>();

    public List getCandidateMatchList() {
        return candidateMatchList;
    }

    public void setCandidateMatchList(List candidateMatchList) {
        this.candidateMatchList = candidateMatchList;
    }

    public List getList() {
        return matchesList;
    }

    public void updateList(ValueChangeEvent event) {
        try {
            // get a new list of matches.
            setMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null)
                {
                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
                    setSelectedEmployeeName(currentEmployee.getFullName());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempData = getMatch(autoComplete.getValue().toString());
                    if (tempData != null) {
                        currentEmployee = tempData;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    public void updateDeviseList(ValueChangeEvent event) {
        try {
            // get a new list of matches.
            setDeviceMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null) {
                    currentDevice = (DeviceList) autoComplete.getSelectedItem().getValue();
                // setSelectedDeviceCode(currentDevice.getDiviceCode());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    DeviceList tempData = getDeviceMatch(autoComplete.getValue().toString());
                    if (tempData != null) {
                        currentDevice = tempData;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    private EmployeeList getMatch(String value) {
        EmployeeList result = null;
        if (matchesList != null) {
            SelectItem si;
            Iterator iter = matchesList.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (EmployeeList) si.getValue();
                }
            }
        }
        return result;
    }

    private DeviceList getDeviceMatch(String value) {
        DeviceList result = null;
        if (matchesList != null) {
            SelectItem si;
            Iterator iter = matchesList.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (DeviceList) si.getValue();
                }
            }
        }
        return result;
    }

    private void setMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(AutoCompleteDictionary_ForEmployeePage.dictionary, searchWord, AutoCompleteDictionary_ForEmployeePage.LABEL_COMPARATOR);

            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary_ForEmployeePage.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(AutoCompleteDictionary_ForEmployeePage.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesList != null) {
            this.matchesList.clear();
            this.matchesList = null;
        }
        this.matchesList = matchList;
    }

    private void setDeviceMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(AutoCompleteDictionary.dictionary, searchWord, AutoCompleteDictionary.LABEL_COMPARATOR);

            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(AutoCompleteDictionary.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesList != null) {
            this.matchesList.clear();
            this.matchesList = null;
        }
        this.matchesList = matchList;
    }

    public void changeList(ValueChangeEvent event) {
        try {
//        // get a new list of matches.
            setCandidateMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null) {
                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempCity = getMatch(autoComplete.getValue().toString());
                    if (tempCity != null) {
                        currentEmployee = tempCity;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }
//////////////////////////////////////////////////////////////////////////////////
     public void changeListForCandidateEducation(ValueChangeEvent event) {
        try {
//        // get a new list of matches.
            setCandidateMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null) {
                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempCity = getMatch(autoComplete.getValue().toString());
                    if (tempCity != null) {
                        currentEmployee = tempCity;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    ////////////////////////////////////////////////////////////////////////////////////
    private void setCandidateMatches(ValueChangeEvent event)
         {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(CandidateDictionery.dictionary, searchWord, CandidateDictionery.LABEL_COMPARATOR);
//             less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }
            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= CandidateDictionery.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(CandidateDictionery.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesList != null) {
            this.matchesList.clear();
            this.matchesList = null;
        }
        this.matchesList = matchList;
    }
    private List evaSessionMatchesList = new ArrayList<SelectItem>();

    public List getEvaSessionMatchesList() {
        return evaSessionMatchesList;
    }

    public void setEvaSessionMatchesList(List evaSessionMatchesList) {
        this.evaSessionMatchesList = evaSessionMatchesList;
    }

    public void evaSessionUpdateList(ValueChangeEvent event) {

        try {
//        // get a new list of matches.
            setEvaSessionMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null) {
                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempCity = getEvaSessionMatch(autoComplete.getValue().toString());
                    if (tempCity != null) {
                        currentEmployee = tempCity;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    private EmployeeList getEvaSessionMatch(String value) {
        EmployeeList result = null;
        if (evaSessionMatchesList != null) {
            SelectItem si;
            Iterator iter = evaSessionMatchesList.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (EmployeeList) si.getValue();
                }
            }
        }
        return result;
    }

    private void setEvaSessionMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);

        try {
            int insert = Collections.binarySearch(AutoCompleteDictionary_ForEmployeePage.dictionary, searchWord, AutoCompleteDictionary_ForEmployeePage.LABEL_COMPARATOR);

            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary_ForEmployeePage.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(AutoCompleteDictionary_ForEmployeePage.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.evaSessionMatchesList != null) {
            this.evaSessionMatchesList.clear();
            this.evaSessionMatchesList = null;
        }
        this.evaSessionMatchesList = matchList;
    }
    private List matchesListResult = new ArrayList<SelectItem>();

    /**
     * @return the matchesListResult
     */
    public List getMatchesListResult() {
        return matchesListResult;
    }

    /**
     * @param matchesListResult the matchesListResult to set
     */
    public void setMatchesListResult(List matchesListResult) {
        this.matchesListResult = matchesListResult;
    }

    public void evaResultUpdateList(ValueChangeEvent event) {

        try {
//        // get a new list of matches.
            setEvaResultMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete.getSelectedItem() != null) {
                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempCity = getEvaSessionMatch(autoComplete.getValue().toString());
                    if (tempCity != null) {
                        currentEmployee = tempCity;
                    }
                }
            }
        } catch (Exception ex) {
        }
    }

    private EmployeeList getEvaResultMatch(String value) {
        EmployeeList result = null;
        if (matchesListResult != null) {
            SelectItem si;
            Iterator iter = matchesListResult.iterator();
            while (iter.hasNext()) {
                si = (SelectItem) iter.next();
                if (value.equals(si.getLabel())) {
                    result = (EmployeeList) si.getValue();
                }
            }
        }
        return result;
    }

    private void setEvaResultMatches(ValueChangeEvent event) {
        Object searchWord = event.getNewValue();
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);

        try {


            int insert = Collections.binarySearch(AutoCompleteDictionary_ForEmployeePage.dictionary, searchWord, AutoCompleteDictionary_ForEmployeePage.LABEL_COMPARATOR);

            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }

            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= AutoCompleteDictionary_ForEmployeePage.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(AutoCompleteDictionary_ForEmployeePage.dictionary.get(insert + i));
            }
        } catch (Throwable e) {
        }
        // assign new matchList
        if (this.matchesListResult != null) {
            this.matchesListResult.clear();
            this.matchesListResult = null;
        }
        this.matchesListResult = matchList;
    }

    /**
     * @return the lookupTypes
     */
    public ArrayList<SelectItem> getLookupTypes() {
        return lookupTypes;
    }

    /**
     * @param lookupTypes the lookupTypes to set
     */
    public void setLookupTypes(ArrayList<SelectItem> lookupTypes) {
        this.lookupTypes = lookupTypes;
    }
}
