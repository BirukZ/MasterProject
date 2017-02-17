/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;

import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.AutoCompleteDictionary;
import fphrms.EmployeeList;
import fphrms.SessionBean1;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import manager.recruitmentManager.CandidateManager;
import fphrms.RequestBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

//import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
//import javax.swing.JOptionPane;
import javax.faces.model.SelectItem;
//import javax.swing.JOptionPane;
import manager.globalUseManager.LookUpManager;
import manager.recruitmentManager.CandidateExperienceManager.CandidateEducationManager;



/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CandidateEducation extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private PanelLayout canEducationall = new PanelLayout();

    public PanelLayout getCanEducationall() {
        return canEducationall;
    }

    public void setCanEducationall(PanelLayout pl) {
        this.canEducationall = pl;
    }
    private HtmlSelectOneMenu drlLevelOfEducation = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlLevelOfEducation() {
        return drlLevelOfEducation;
    }

    public void setDrlLevelOfEducation(HtmlSelectOneMenu hsom) {
        this.drlLevelOfEducation = hsom;
    }
    private HtmlInputText txtCGPA = new HtmlInputText();

    public HtmlInputText getTxtCGPA() {
        return txtCGPA;
    }

    public void setTxtCGPA(HtmlInputText hit) {
        this.txtCGPA = hit;
    }
    private HtmlInputText txt_Instution = new HtmlInputText();

    public HtmlInputText getTxt_Instution() {
        return txt_Instution;
    }

    public void setTxt_Instution(HtmlInputText hit) {
        this.txt_Instution = hit;
    }
    private HtmlInputText txtGraduatedby = new HtmlInputText();

    public HtmlInputText getTxtGraduatedby() {
        return txtGraduatedby;
    }

    public void setTxtGraduatedby(HtmlInputText hit) {
        this.txtGraduatedby = hit;
    }
    private HtmlInputText txtYearOfGraduation = new HtmlInputText();

    public HtmlInputText getTxtYearOfGraduation() {
        return txtYearOfGraduation;
    }

    public void setTxtYearOfGraduation(HtmlInputText hit) {
        this.txtYearOfGraduation = hit;
    }
    private HtmlCommandButton btnCalenderYearOfGraduation = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderYearOfGraduation() {
        return btnCalenderYearOfGraduation;
    }

    public void setBtnCalenderYearOfGraduation(HtmlCommandButton hcb) {
        this.btnCalenderYearOfGraduation = hcb;
    }
    private HtmlCommandButton btn_edu_new = new HtmlCommandButton();

    public HtmlCommandButton getBtn_edu_new() {
        return btn_edu_new;
    }

    public void setBtn_edu_new(HtmlCommandButton hcb) {
        this.btn_edu_new = hcb;
    }
    private HtmlCommandButton btn_AddEduc = new HtmlCommandButton();

    public HtmlCommandButton getBtn_AddEduc() {
        return btn_AddEduc;
    }

    public void setBtn_AddEduc(HtmlCommandButton hcb) {
        this.btn_AddEduc = hcb;
    }
    private HtmlCommandButton btn_SaveEducation = new HtmlCommandButton();

    public HtmlCommandButton getBtn_SaveEducation() {
        return btn_SaveEducation;
    }

    public void setBtn_SaveEducation(HtmlCommandButton hcb) {
        this.btn_SaveEducation = hcb;
    }
    private HtmlCommandButton btn_Educedit = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educedit() {
        return btn_Educedit;
    }

    public void setBtn_Educedit(HtmlCommandButton hcb) {
        this.btn_Educedit = hcb;
    }
    private HtmlCommandButton btn_Educupdate = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educupdate() {
        return btn_Educupdate;
    }

    public void setBtn_Educupdate(HtmlCommandButton hcb) {
        this.btn_Educupdate = hcb;
    }
    private HtmlCommandButton btn_Educdelete = new HtmlCommandButton();

    public HtmlCommandButton getBtn_Educdelete() {
        return btn_Educdelete;
    }

    public void setBtn_Educdelete(HtmlCommandButton hcb) {
        this.btn_Educdelete = hcb;
    }
    private SelectInputDate calDateOfGraduation = new SelectInputDate();

    public SelectInputDate getCalDateOfGraduation() {
        return calDateOfGraduation;
    }

    public void setCalDateOfGraduation(SelectInputDate calDateOfGraduation) {
        this.calDateOfGraduation = calDateOfGraduation;
    }
 private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData defaultSelectedData8) {
        this.defaultSelectedData8 = defaultSelectedData8;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean selectInputDateBean1) {
        this.selectInputDateBean1 = selectInputDateBean1;
    }
    private PanelLayout pnl_NameSearch = new PanelLayout();

    public PanelLayout getPnl_NameSearch() {
        return pnl_NameSearch;
    }

    public void setPnl_NameSearch(PanelLayout pl) {
        this.pnl_NameSearch = pl;
    }
    private SelectInputText txtSearchCandidate = new SelectInputText();

    public SelectInputText getTxtSearchCandidate() {
        return txtSearchCandidate;
    }

    public void setTxtSearchCandidate(SelectInputText sit) {
        this.txtSearchCandidate = sit;
    }
 
    // </editor-fold>

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CandidateEducation() {
    }

    /**
     * <p>Callback method that is called whenever a page is navigated to,
     * either directly via a URL, or indirectly via page navigation.
     * Customize this method to acquire resources that will be needed
     * for event handlers and lifecycle methods, whether or not this
     * page is performing post back processing.</p>
     * 
     * <p>Note that, if the current request is a postback, the property
     * values of the components do <strong>not</strong> represent any
     * values submitted with this request.  Instead, they represent the
     * property values that were saved for this view when it was rendered.</p>
     */
    @Override
    public void init() {
        // Perform initializations inherited from our superclass
        super.init();
        // Perform application initialization that must complete
        // *before* managed components are initialized
        // TODO - add your own initialiation code here
            
        // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">
        // Initialize automatically managed components
        // *Note* - this logic should NOT be modified
        try {
            _init();
        } catch (Exception e) {
            log("Page2 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e: new FacesException(e);
        }
        
        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
    }

    /**
     * <p>Callback method that is called after the component tree has been
     * restored, but before any event processing takes place.  This method
     * will <strong>only</strong> be called on a postback request that
     * is processing a form submit.  Customize this method to allocate
     * resources that will be required in your event handlers.</p>
     */
    @Override
    public void preprocess() {
    }

    /**
     * <p>Callback method that is called just before rendering takes place.
     * This method will <strong>only</strong> be called for the page that
     * will actually be rendered (and not, for example, on a page that
     * handled a postback and then navigated to a different page).  Customize
     * this method to allocate resources that will be required for rendering
     * this page.</p>
     */
    @Override
    public void prerender() {
    }

    /**
     * <p>Callback method that is called after rendering is completed for
     * this request, if <code>init()</code> was called (regardless of whether
     * or not this was the page that was actually rendered).  Customize this
     * method to release resources acquired in the <code>init()</code>,
     * <code>preprocess()</code>, or <code>prerender()</code> methods (or
     * acquired during execution of an event handler).</p>
     */
    @Override
    public void destroy() {
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    
    AutoCompleteDictionary autoCompleteDictionary = new AutoCompleteDictionary();
    LookUpManager lookUpManager = new LookUpManager();
    ArrayList<SelectItem> educLevelOpt = new ArrayList<SelectItem>();
    ArrayList<CandidateEducationManager> candidateEducationList = new ArrayList<CandidateEducationManager>();
    CandidateManager candidateManager = new CandidateManager();
    private String selectedEmployeeId;
    int selectedEducatuon = -1;
    public String leaveOfEducation;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public String status;
    public String candidateId = null;
    public   int educatiobnID;
    public   int educationID;
    EmployeeList currentEmployeeCandidate = new EmployeeList("", "0", null);
    int tableSize;
    List matchesList = new ArrayList<SelectItem>();


    public List getList() {
        return matchesList;
    }

    public List getMatchesList()
    {
        return matchesList;
    }

    public void setMatchesList(List matchesList) {
        this.matchesList = matchesList;
    }
    public List listOfEducation = new ArrayList<CandidateEducationManager>();
//    ArrayList<CandidateEducationManager> candidateEducationList = new ArrayList<CandidateEducationManager>();

    public ArrayList<CandidateEducationManager> getCandidateEducationList() {
        return candidateEducationList;
    }

    public void setCandidateEducationList(ArrayList<CandidateEducationManager> candidateEducationList) {
        this.candidateEducationList = candidateEducationList;
    }
    public void rowSelectorCandidateEducation_processMyEvent(RowSelectorEvent rse) {
        selectedEducatuon = rse.getRow();
    }

    public ArrayList<SelectItem> getEducLevelOpt()
    {
        return lookUpManager.readEducationLevel();
    }

    public void setEducLevelOpt(ArrayList<SelectItem> educLevelOpt) {
        this.educLevelOpt = educLevelOpt;
    }

    public EmployeeList getcurrentEmployeeCandidate() {
        return currentEmployeeCandidate;
    }

    public void setCurrentEmployee1(EmployeeList currentEmployeeCandidate) {
        this.currentEmployeeCandidate = currentEmployeeCandidate;
    }

    public String getSelectedEmployeeId() {
        return selectedEmployeeId;
    }

    public void setSelectedEmployeeId(String selectedEmployeeId) {
        this.selectedEmployeeId = selectedEmployeeId;
    }

       public void drlLevelOfEducation_processValueChange(ValueChangeEvent vce) {
        String[] leveOfEduc = vce.getNewValue().toString().split("-");
        leaveOfEducation = leveOfEduc[1];

    }
          public String btnCalenderYearOfGraduation_action() {
        calDateOfGraduation.setRendered(true);
        return null;
    }
   public void calDateOfGraduation_processValueChange(ValueChangeEvent vce) {
        txtYearOfGraduation.setValue(dateFormat.format(calDateOfGraduation.getValue()));
        calDateOfGraduation.setRendered(false);

    }

    public String btn_edu_new_action()
    {
        //return null means stay on the same page
         status="New";
        drlLevelOfEducation.setDisabled(false);
        txtGraduatedby.setDisabled(false);
        txtCGPA.setDisabled(false);
        txt_Instution.setDisabled(false);
        txtGraduatedby.setDisabled(false);
        txtYearOfGraduation.setDisabled(false);
        btnCalenderYearOfGraduation.setDisabled(false);
        candidateEducationList.clear();
        this.btn_AddEduc.setDisabled(false);
        this.btn_SaveEducation.setDisabled(false);

        return null;

    }

    public String btn_AddEduc_action() {
        //return null means stay on the same page
         status="New";
         btn_SaveEducation.setDisabled(false);
        String candidateID;
        String recuritmentBatch;
        String instiution;
        String cgpa;
        String filedOfStudy;
        String filedOfCatagory;
        String leaveOfEduc = null;
        String graduationYear;
        leaveOfEduc = leaveOfEducation;
        cgpa = txtCGPA.getValue().toString();
        filedOfStudy = txtGraduatedby.getValue().toString();
        graduationYear = txtYearOfGraduation.getValue().toString();
        instiution = txt_Instution.getValue().toString();
        candidateID = candidateId;

               CandidateEducationManager addEducation= new CandidateEducationManager(status,
                leaveOfEducation, cgpa, filedOfStudy,
                graduationYear, instiution, candidateID,educationID);
        candidateEducationList.add(0,new CandidateEducationManager(status, leaveOfEducation, cgpa, filedOfStudy, graduationYear, instiution, candidateID,educationID));
        this.listOfEducation.add(addEducation);
        return null;

    }

    void loadCandidateEducation() {
        candidateEducationList.clear();
        HashMap[] list = candidateManager.readEmployeeEducation(candidateId);
        CandidateEducationManager addTotabele = null;
        try {
            tableSize = candidateManager.countExperiance(candidateId);

            if (tableSize > 0) {

                for (int i = 0; i < tableSize; i++) {
                    addTotabele = new CandidateEducationManager(list[i].get("STATUS").toString(),
                            list[i].get("CANDIDATE_ID").toString(),
                            list[i].get("INSTUTION").toString(),
                            list[i].get("CGPA").toString(),
                            list[i].get("FILED_OF_STUDY").toString(),
                            list[i].get("CAN_EDUC_ID").toString(),
                            list[i].get("GRADUATION_YEAR").toString(),
                            list[i].get("FILED_OF_CATAGORY").toString(),
                            Integer.parseInt( list[i].get("Education_ID").toString()));
                    this.candidateEducationList.add(addTotabele);
                // this.listOfExperience.add(addTotabele);
                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }

     public String txtSearchCandidate_action() {
              //lblMesageConfirm.setVisible(false);
            candidateId = ApplicationBean1.getSelectedEmployeeId();
           
           // loadCandidateEducation();

     return null;
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


    private void setMatches(ValueChangeEvent event)
            {
        Object searchWord = event.getNewValue();
      
        int maxMatches = ((SelectInputText) event.getComponent()).getRows();
        List matchList = new ArrayList(maxMatches);
        try {
            int insert = Collections.binarySearch(autoCompleteDictionary.dictionary, searchWord, autoCompleteDictionary.LABEL_COMPARATOR);
            // less then zero if wer have a partial match
            if (insert < 0) {
                insert = Math.abs(insert) - 1;
            }
            for (int i = 0; i < maxMatches; i++) {
                // quit the match list creation if the index is larger then
                // max entries in the dictionary if we have added maxMatches.
                if ((insert + i) >= autoCompleteDictionary.dictionary.size() || i >= maxMatches) {
                    break;
                }
                matchList.add(autoCompleteDictionary.dictionary.get(insert + i));
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


    public void updateList(ValueChangeEvent event) {
        try {
            // get a new list of matches.
            setMatches(event);
            // Get the auto complete component from the event and assing
            if (event.getComponent() instanceof SelectInputText) {
                SelectInputText autoComplete1 = (SelectInputText) event.getComponent();
                // if no selected item then return the previously selected item.
                if (autoComplete1.getSelectedItem() != null) {
                    currentEmployeeCandidate = (EmployeeList) autoComplete1.getSelectedItem().getValue();
                    setSelectedEmployeeId(currentEmployeeCandidate.getEmpIdentification());
                } // otherwise if there is a selected item get the value from the match list
                else {
                    EmployeeList tempData = getMatch(autoComplete1.getValue().toString());
                    if (tempData != null) {
                        currentEmployeeCandidate = tempData;
                    }

                }
            }
        } catch (Exception ex) {
        }
    }

//        public void changeList(ValueChangeEvent event) {
//        try {
////        // get a new list of matches.
//            setCandidateMatches(event);
//            // Get the auto complete component from the event and assing
//            if (event.getComponent() instanceof SelectInputText) {
//                SelectInputText autoComplete = (SelectInputText) event.getComponent();
//                // if no selected item then return the previously selected item.
//                if (autoComplete.getSelectedItem() != null) {
//                    currentEmployee = (EmployeeList) autoComplete.getSelectedItem().getValue();
//                    setSelectedEmployeeId(currentEmployee.getEmpIdentification());
//                } // otherwise if there is a selected item get the value from the match list
//                else {
//                    EmployeeList tempCity = getMatch(autoComplete.getValue().toString());
//                    if (tempCity != null) {
//                        currentEmployee = tempCity;
//                    }
//                }
//            }
//        } catch (Exception ex) {
//        }
//    }





}

