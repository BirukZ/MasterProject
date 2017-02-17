/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package fphrms.Questionnaire;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.paneltabset.PanelTab;
import com.icesoft.faces.component.paneltabset.PanelTabSet;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlInputText;
import javax.faces.component.html.HtmlInputTextarea;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import manager.questionnaire.AllQuestionsManager;
import manager.questionnaire.QuestionOptionsManager;
import manager.questionnaire.DynamicFiledList;
import javax.faces.component.html.HtmlPanelGroup;
import javax.faces.component.html.HtmlSelectManyCheckbox;
import javax.faces.component.html.HtmlSelectOneMenu;
import javax.faces.component.html.HtmlSelectOneRadio;
import javax.faces.event.PhaseId;
import javax.faces.model.SelectItem;
import manager.employeeManager.EmployeeManage;
import manager.questionnaire.DynamicField;
import manager.questionnaire.QuestionnaireAnswerManager;
import manager.questionnaire.QuestionnaireCommentManager;
import manager.questionnaire.QuestionnaireManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 *
 * @version Questionnaire_1.java
 * @version Created on Feb 20, 2012, 4:56:38 PM
 * @author Bini
 */
public class GenerateQuestionnairs extends AbstractPageBean {

    AllQuestionsManager allQuestionsManager = new AllQuestionsManager();
    QuestionOptionsManager optionManager = new QuestionOptionsManager();
    QuestionnaireAnswerManager answerManager = new QuestionnaireAnswerManager();
    QuestionnaireManager questionnaireManager = new QuestionnaireManager();
    QuestionnaireCommentManager commentManager = new QuestionnaireCommentManager();
    DynamicFiledList dynamicFiledList = new DynamicFiledList(allQuestionsManager.countTableFormQuestion());
    EmployeeManage employeeManage = new EmployeeManage();
    DynamicField dynamicFiled = new DynamicField();
    ArrayList<QuestionnaireCommentManager> supervisorComment = new ArrayList<QuestionnaireCommentManager>();
    ArrayList<QuestionnaireCommentManager> reviwerComment = new ArrayList<QuestionnaireCommentManager>();
    private ArrayList<SelectItem> activeQuestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> answerList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> sectionList = new ArrayList<SelectItem>();
    SimpleDateFormat datFormat = new SimpleDateFormat("yyyy-MM-dd");
    private String loggedInUserId = null;
    boolean canReview = true;
    private boolean load = false;
    private static int defQuesId = 0;

    public ArrayList<SelectItem> getActiveQuestList() {
        return questionnaireManager.selectActiveQuestionnaire();
    }

    public void setActiveQuestList(ArrayList<SelectItem> activeQuestList) {
        this.activeQuestList = activeQuestList;
    }

    public ArrayList<SelectItem> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(ArrayList<SelectItem> answerList) {
        this.answerList = answerList;
    }

    public ArrayList<QuestionnaireCommentManager> getReviwerComment() {
        return reviwerComment;
    }

    public void setReviwerComment(ArrayList<QuestionnaireCommentManager> reviwerComment) {
        this.reviwerComment = reviwerComment;
    }

    public ArrayList<QuestionnaireCommentManager> getSupervisorComment() {
        return supervisorComment;
    }

    public void setSupervisorComment(ArrayList<QuestionnaireCommentManager> supervisorComment) {
        this.supervisorComment = supervisorComment;
    }

    public ArrayList<SelectItem> getSectionList() {
        return allQuestionsManager.getQuestionSectionList();
    }

    public void setSectionList(ArrayList<SelectItem> sectionList) {
        this.sectionList = sectionList;
    }


    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox2Bean() {
        return selectOneListbox2Bean;
    }

    public void setSelectOneListbox2Bean(DefaultSelectedData dsd) {
        this.selectOneListbox2Bean = dsd;
    }
    private PanelLayout pnlSectionOne = new PanelLayout();

    public PanelLayout getPnlSectionOne() {
        return pnlSectionOne;
    }

    public void setPnlSectionOne(PanelLayout pl) {
        this.pnlSectionOne = pl;
    }
    private PanelLayout pnlSectionTwo = new PanelLayout();

    public PanelLayout getPnlSectionTwo() {
        return pnlSectionTwo;
    }

    public void setPnlSectionTwo(PanelLayout pl) {
        this.pnlSectionTwo = pl;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlOutputText txtEmpName = new HtmlOutputText();

    public HtmlOutputText getTxtEmpName() {
        return txtEmpName;
    }

    public void setTxtEmpName(HtmlOutputText hot) {
        this.txtEmpName = hot;
    }
    private HtmlOutputText txtEmpJob = new HtmlOutputText();

    public HtmlOutputText getTxtEmpJob() {
        return txtEmpJob;
    }

    public void setTxtEmpJob(HtmlOutputText hot) {
        this.txtEmpJob = hot;
    }
    private HtmlOutputText txtSupName = new HtmlOutputText();

    public HtmlOutputText getTxtSupName() {
        return txtSupName;
    }

    public void setTxtSupName(HtmlOutputText hot) {
        this.txtSupName = hot;
    }
    private HtmlOutputText txtDirectorate = new HtmlOutputText();

    public HtmlOutputText getTxtDirectorate() {
        return txtDirectorate;
    }

    public void setTxtDirectorate(HtmlOutputText hot) {
        this.txtDirectorate = hot;
    }
    private HtmlOutputText txtGrade = new HtmlOutputText();

    public HtmlOutputText getTxtGrade() {
        return txtGrade;
    }

    public void setTxtGrade(HtmlOutputText hot) {
        this.txtGrade = hot;
    }
    private HtmlOutputText txtSupJob = new HtmlOutputText();

    public HtmlOutputText getTxtSupJob() {
        return txtSupJob;
    }

    public void setTxtSupJob(HtmlOutputText hot) {
        this.txtSupJob = hot;
    }
    private HtmlOutputText txtExperiance = new HtmlOutputText();

    public HtmlOutputText getTxtExperiance() {
        return txtExperiance;
    }

    public void setTxtExperiance(HtmlOutputText hot) {
        this.txtExperiance = hot;
    }
    private PanelLayout pnlSectionFive = new PanelLayout();

    public PanelLayout getPnlSectionFive() {
        return pnlSectionFive;
    }

    public void setPnlSectionFive(PanelLayout pl) {
        this.pnlSectionFive = pl;
    }
    private PanelLayout pnlSectionFour = new PanelLayout();

    public PanelLayout getPnlSectionFour() {
        return pnlSectionFour;
    }

    public void setPnlSectionFour(PanelLayout pl) {
        this.pnlSectionFour = pl;
    }
    private PanelLayout pnlSectionThree = new PanelLayout();

    public PanelLayout getPnlSectionThree() {
        return pnlSectionThree;
    }

    public void setPnlSectionThree(PanelLayout pl) {
        this.pnlSectionThree = pl;
    }
    private HtmlCommandButton btnPrevSecond = new HtmlCommandButton();

    public HtmlCommandButton getBtnPrevSecond() {
        return btnPrevSecond;
    }

    public void setBtnPrevSecond(HtmlCommandButton hcb) {
        this.btnPrevSecond = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlOutputText txtQuestionnaireId = new HtmlOutputText();

    public HtmlOutputText getTxtQuestionnaireId() {
        return txtQuestionnaireId;
    }

    public void setTxtQuestionnaireId(HtmlOutputText hot) {
        this.txtQuestionnaireId = hot;
    }
    private HtmlOutputText txtQuestJobCode = new HtmlOutputText();

    public HtmlOutputText getTxtQuestJobCode() {
        return txtQuestJobCode;
    }

    public void setTxtQuestJobCode(HtmlOutputText hot) {
        this.txtQuestJobCode = hot;
    }
    private HtmlOutputText txtToDate = new HtmlOutputText();

    public HtmlOutputText getTxtToDate() {
        return txtToDate;
    }

    public void setTxtToDate(HtmlOutputText hot) {
        this.txtToDate = hot;
    }
    private HtmlOutputText txtQuestJobTitle = new HtmlOutputText();

    public HtmlOutputText getTxtQuestJobTitle() {
        return txtQuestJobTitle;
    }

    public void setTxtQuestJobTitle(HtmlOutputText hot) {
        this.txtQuestJobTitle = hot;
    }
    private HtmlOutputText txtFromDate = new HtmlOutputText();

    public HtmlOutputText getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtFromDate(HtmlOutputText hot) {
        this.txtFromDate = hot;
    }
    private com.icesoft.faces.component.ext.HtmlInputTextarea txtDesc = new com.icesoft.faces.component.ext.HtmlInputTextarea();

    public com.icesoft.faces.component.ext.HtmlInputTextarea getTxtDesc() {
        return txtDesc;
    }

    public void setTxtDesc(com.icesoft.faces.component.ext.HtmlInputTextarea hit) {
        this.txtDesc = hit;
    }
    private HtmlSelectOneListbox lstActiveQuest = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstActiveQuest() {
        return lstActiveQuest;
    }

    public void setLstActiveQuest(HtmlSelectOneListbox hsol) {
        this.lstActiveQuest = hsol;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calAnswereOn = new SelectInputDate();

    public SelectInputDate getCalAnswereOn() {
        return calAnswereOn;
    }

    public void setCalAnswereOn(SelectInputDate sid) {
        this.calAnswereOn = sid;
    }
    private HtmlCommandButton btnCalAnswered = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalAnswered() {
        return btnCalAnswered;
    }

    public void setBtnCalAnswered(HtmlCommandButton hcb) {
        this.btnCalAnswered = hcb;
    }
    private com.icesoft.faces.component.ext.HtmlInputText txtAnsweredOn = new com.icesoft.faces.component.ext.HtmlInputText();

    public com.icesoft.faces.component.ext.HtmlInputText getTxtAnsweredOn() {
        return txtAnsweredOn;
    }

    public void setTxtAnsweredOn(com.icesoft.faces.component.ext.HtmlInputText hit) {
        this.txtAnsweredOn = hit;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems() {
        return selectOneListbox1DefaultItems;
    }

    public void setSelectOneListbox1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems = dsi;
    }
    private HtmlSelectOneListbox lstAnsweredQuest = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getLstAnsweredQuest() {
        return lstAnsweredQuest;
    }

    public void setLstAnsweredQuest(HtmlSelectOneListbox hsol) {
        this.lstAnsweredQuest = hsol;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private SelectInputDateBean selectInputDateBean1 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean1() {
        return selectInputDateBean1;
    }

    public void setSelectInputDateBean1(SelectInputDateBean sidb) {
        this.selectInputDateBean1 = sidb;
    }
    private SelectInputDate calSupDate = new SelectInputDate();

    public SelectInputDate getCalSupDate() {
        return calSupDate;
    }

    public void setCalSupDate(SelectInputDate sid) {
        this.calSupDate = sid;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDate calRevDate = new SelectInputDate();

    public SelectInputDate getCalRevDate() {
        return calRevDate;
    }

    public void setCalRevDate(SelectInputDate sid) {
        this.calRevDate = sid;
    }
    private com.icesoft.faces.component.ext.HtmlInputText txtSupDate = new com.icesoft.faces.component.ext.HtmlInputText();

    public com.icesoft.faces.component.ext.HtmlInputText getTxtSupDate() {
        return txtSupDate;
    }

    public void setTxtSupDate(com.icesoft.faces.component.ext.HtmlInputText hit) {
        this.txtSupDate = hit;
    }
    private HtmlOutputText txtSupDirectorate = new HtmlOutputText();

    public HtmlOutputText getTxtSupDirectorate() {
        return txtSupDirectorate;
    }

    public void setTxtSupDirectorate(HtmlOutputText hot) {
        this.txtSupDirectorate = hot;
    }
    private com.icesoft.faces.component.ext.HtmlSelectOneMenu ddnSupSection = new com.icesoft.faces.component.ext.HtmlSelectOneMenu();

    public com.icesoft.faces.component.ext.HtmlSelectOneMenu getDdnSupSection() {
        return ddnSupSection;
    }

    public void setDdnSupSection(com.icesoft.faces.component.ext.HtmlSelectOneMenu hsom) {
        this.ddnSupSection = hsom;
    }
    private com.icesoft.faces.component.ext.HtmlInputTextarea txtSupRemark = new com.icesoft.faces.component.ext.HtmlInputTextarea();

    public com.icesoft.faces.component.ext.HtmlInputTextarea getTxtSupRemark() {
        return txtSupRemark;
    }

    public void setTxtSupRemark(com.icesoft.faces.component.ext.HtmlInputTextarea hit) {
        this.txtSupRemark = hit;
    }
    private HtmlOutputText txtSupJob1 = new HtmlOutputText();

    public HtmlOutputText getTxtSupJob1() {
        return txtSupJob1;
    }

    public void setTxtSupJob1(HtmlOutputText hot) {
        this.txtSupJob1 = hot;
    }
    private HtmlOutputText txtSupName1 = new HtmlOutputText();

    public HtmlOutputText getTxtSupName1() {
        return txtSupName1;
    }

    public void setTxtSupName1(HtmlOutputText hot) {
        this.txtSupName1 = hot;
    }
    private HtmlOutputText txtRevName = new HtmlOutputText();

    public HtmlOutputText getTxtRevName() {
        return txtRevName;
    }

    public void setTxtRevName(HtmlOutputText hot) {
        this.txtRevName = hot;
    }
    private HtmlOutputText txtRevJob = new HtmlOutputText();

    public HtmlOutputText getTxtRevJob() {
        return txtRevJob;
    }

    public void setTxtRevJob(HtmlOutputText hot) {
        this.txtRevJob = hot;
    }
    private com.icesoft.faces.component.ext.HtmlSelectOneMenu ddnRevSection = new com.icesoft.faces.component.ext.HtmlSelectOneMenu();

    public com.icesoft.faces.component.ext.HtmlSelectOneMenu getDdnRevSection() {
        return ddnRevSection;
    }

    public void setDdnRevSection(com.icesoft.faces.component.ext.HtmlSelectOneMenu hsom) {
        this.ddnRevSection = hsom;
    }
    private HtmlOutputText txtRevDirectorate = new HtmlOutputText();

    public HtmlOutputText getTxtRevDirectorate() {
        return txtRevDirectorate;
    }

    public void setTxtRevDirectorate(HtmlOutputText hot) {
        this.txtRevDirectorate = hot;
    }
    private com.icesoft.faces.component.ext.HtmlInputText txtRevDate = new com.icesoft.faces.component.ext.HtmlInputText();

    public com.icesoft.faces.component.ext.HtmlInputText getTxtRevDate() {
        return txtRevDate;
    }

    public void setTxtRevDate(com.icesoft.faces.component.ext.HtmlInputText hit) {
        this.txtRevDate = hit;
    }
    private com.icesoft.faces.component.ext.HtmlInputTextarea txtRevRemark = new com.icesoft.faces.component.ext.HtmlInputTextarea();

    public com.icesoft.faces.component.ext.HtmlInputTextarea getTxtRevRemark() {
        return txtRevRemark;
    }

    public void setTxtRevRemark(com.icesoft.faces.component.ext.HtmlInputTextarea hit) {
        this.txtRevRemark = hit;
    }
    private PanelTabSet panelTabSet = new PanelTabSet();

    public PanelTabSet getPanelTabSet() {
        return panelTabSet;
    }

    public void setPanelTabSet(PanelTabSet pts) {
        this.panelTabSet = pts;
    }
    private HtmlCommandButton btnNextSec = new HtmlCommandButton();

    public HtmlCommandButton getBtnNextSec() {
        return btnNextSec;
    }

    public void setBtnNextSec(HtmlCommandButton hcb) {
        this.btnNextSec = hcb;
    }
    private HtmlCommandButton btnPrevFirst = new HtmlCommandButton();

    public HtmlCommandButton getBtnPrevFirst() {
        return btnPrevFirst;
    }

    public void setBtnPrevFirst(HtmlCommandButton hcb) {
        this.btnPrevFirst = hcb;
    }
    private HtmlCommandButton btnNextthird = new HtmlCommandButton();

    public HtmlCommandButton getBtnNextthird() {
        return btnNextthird;
    }

    public void setBtnNextthird(HtmlCommandButton hcb) {
        this.btnNextthird = hcb;
    }
    private PanelTab pnlTabPage1 = new PanelTab();

    public PanelTab getPnlTabPage1() {
        return pnlTabPage1;
    }

    public void setPnlTabPage1(PanelTab pt) {
        this.pnlTabPage1 = pt;
    }
    private PanelTab pnlTabPage2 = new PanelTab();

    public PanelTab getPnlTabPage2() {
        return pnlTabPage2;
    }

    public void setPnlTabPage2(PanelTab pt) {
        this.pnlTabPage2 = pt;
    }
    private PanelTab pnlTabPage3 = new PanelTab();

    public PanelTab getPnlTabPage3() {
        return pnlTabPage3;
    }

    public void setPnlTabPage3(PanelTab pt) {
        this.pnlTabPage3 = pt;
    }
    private PanelTab pnlTabRev = new PanelTab();

    public PanelTab getPnlTabRev() {
        return pnlTabRev;
    }

    public void setPnlTabRev(PanelTab pt) {
        this.pnlTabRev = pt;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public GenerateQuestionnairs() {
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
            log("Questionnaire_1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
        }

        // </editor-fold>
        // Perform application initialization that must complete
        // *after* managed components are initialized
        // TODO - add your own initialization code here
        loggedInUserId = this.getSessionBean1().getEmployeeId();
        if (loggedInUserId != null) {
            int hm = employeeManage.loadEmpoyeeProfile(loggedInUserId);
            if (hm != 0) {
                clearAll();
                txtEmpName.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
                txtEmpJob.setValue(employeeManage.getJobName());
                txtDirectorate.setValue(employeeManage.getDepartmentDescription());
                txtExperiance.setValue(employeeManage.getExperienceContractOrPrtmanent());
                txtGrade.setValue(employeeManage.getRankeDscription());
                txtSupJob.setValue(employeeManage.getJobName());
                txtSupName.setValue(employeeManage.getFullName());
            }
        }
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RequestBean1 getRequestBean1() {
        return (RequestBean1) getBean("RequestBean1");
    }

    public String cmdQuestions_action() {
        return "ManageQuestions";
    }

    public String cmdAssignQuestionnaire_action() {
        return "AssignQuestionnaire";
    }

    public String cmdAnalyzeReGrading_action() {
        return "AnalyzeReGradingRequest";
    }

    public String cmdAnalyzeGrading_action() {
        return "AnalyzeGradingRequest";
    }

    public void calAnswereOn_processValueChange(ValueChangeEvent vce) {
        txtAnsweredOn.setValue(datFormat.format((Date) vce.getNewValue()));
        calAnswereOn.setRendered(false);
    }

    public String btnCalAnswered_action() {
        calAnswereOn.setRendered(true);
        return null;
    }

    public void calSupDate_processValueChange(ValueChangeEvent vce) {
        txtSupDate.setValue(datFormat.format((Date) vce.getNewValue()));
        calSupDate.setRendered(false);
    }

    public void calRevDate_processValueChange(ValueChangeEvent vce) {
        txtRevDate.setValue(datFormat.format((Date) vce.getNewValue()));
        calRevDate.setRendered(false);
    }

    public String btnCalRevDate_action() {
        calRevDate.setRendered(true);
        return null;
    }

    public String btnCalSupDate_action() {
        calSupDate.setRendered(true);
        return null;
    }

    public void lstActiveQuest_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            String qid = vce.getNewValue().toString();
            //qid = qid.substring(0, qid.indexOf("--"));
            HashMap hm = questionnaireManager.selectQuestionnaire(Integer.valueOf(qid));
            if (hm != null) {
                txtQuestionnaireId.setValue(vce.getNewValue());
                txtQuestJobCode.setValue(hm.get("propJobCode"));
                txtQuestJobTitle.setValue(hm.get("propJobTitle"));
                txtFromDate.setValue(hm.get("fromDate"));
                txtToDate.setValue(hm.get("toDate"));
                txtDesc.setValue(hm.get("quesDesc"));
                defQuesId = Integer.parseInt(hm.get("quesDefId").toString());
                clearAllPage();
                generateDynamicPage();
                setAnswerList(answerManager.selectAllQuestionnaireAnswer(Integer.valueOf(vce.getNewValue().toString())));
            }

        }
    }

    public void lstAnsweredQuest_processValueChange(ValueChangeEvent vce) {
        
        if (vce.getNewValue() != null) {
            if (vce.getPhaseId().equals(PhaseId.ANY_PHASE)) {
                vce.setPhaseId(PhaseId.UPDATE_MODEL_VALUES);
                vce.queue();
            } else if (vce.getPhaseId().equals(PhaseId.UPDATE_MODEL_VALUES)) {
//                dynamicFiledList.loadAnswer(Integer.valueOf(vce.getNewValue().toString()));
                HashMap hm = answerManager.selectQuestionnaireAnswerDetail(Integer.valueOf(vce.getNewValue().toString()));
                if (hm != null) {
//                    int serviceInDays = StringDateManipulation.compareDateDifference(
//                            hm.get("hireDate").toString(), StringDateManipulation.toDayInEc());
                    txtEmpName.setValue(hm.get("name"));
                    txtEmpJob.setValue(hm.get("job"));
                    txtDirectorate.setValue(hm.get("dep"));
//                    txtExperiance.setValue(serviceInDays);
                    txtGrade.setValue(hm.get("rank"));
                    txtSupJob.setValue(hm.get("supervisorName"));
                    txtSupName.setValue(hm.get("supervisorJob"));
                    txtAnsweredOn.setValue(hm.get("answeredOn"));
                    txtSupName1.setValue(hm.get("supervisorName"));
                    txtSupDate.setValue(hm.get("supervisedOn"));
                    txtSupDirectorate.setValue(hm.get("supervisorDep"));
                    txtSupJob1.setValue(hm.get("supervisorJob"));
                    txtRevName.setValue(hm.get("reviewerName"));
                    txtRevDate.setValue(hm.get("reviwedOn"));
                    txtRevDirectorate.setValue(hm.get("reviewerDep"));
                    txtRevJob.setValue(hm.get("reviewerJob"));
                    if (Integer.valueOf(hm.get("status").toString()) > 0) {
                        fillCommentTables(Integer.valueOf(vce.getNewValue().toString()));
                    }

                }
                setAnswerOfQuestions(Integer.valueOf(vce.getNewValue().toString()));
            }
        }
    }

    private void fillCommentTables(int questAnsId) {
        getReviwerComment().clear();
        getSupervisorComment().clear();
        ArrayList<HashMap> commentList = commentManager.selectQuestionnaire(questAnsId);
        for (HashMap hm : commentList) {
            QuestionnaireCommentManager manager = new QuestionnaireCommentManager(
                    Integer.valueOf(hm.get("commentId").toString()),
                    allQuestionsManager.getItemLabel(getSectionList(), String.valueOf(hm.get("sectionId"))),
                    hm.get("remark").toString());

            if (Integer.valueOf(hm.get("type").toString()) == 1) {
                getReviwerComment().add(manager);
            } else {
                getSupervisorComment().add(manager);
            }
        }
    }

    public String btnNew_action() {
        return null;
    }

    public String btnSave_action() {
        answerManager.saveQuestionnaireAnswer(saveAnswerdBy(), saveAllAnswers(), dynamicFiledList.getDynamicDataList());
        return null;
    }

    public String btnEdit_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        return null;
    }

    private void clearAll() {
        txtEmpName.setValue(null);
        txtEmpJob.setValue(null);
        txtDirectorate.setValue(null);
        txtExperiance.setValue(null);
        txtGrade.setValue(null);
        txtSupJob.setValue(null);
        txtSupName.setValue(null);
    }

    private QuestionnaireCommentManager commentManager() {
        String date = txtSupDate.getValue().toString();
        if (true) {
            date = txtRevDate.getValue().toString();
        }
        QuestionnaireCommentManager manager = new QuestionnaireCommentManager(
                loggedInUserId,
                date,
                Integer.valueOf(lstAnsweredQuest.getValue().toString()));
        return manager;
    }

    public String btnAddReviwer_action() {
        QuestionnaireCommentManager manager = new QuestionnaireCommentManager(
                Integer.valueOf(ddnRevSection.getValue().toString()),
                allQuestionsManager.getItemLabel(getSectionList(), ddnRevSection.getValue()),
                txtRevRemark.getValue().toString());
        reviwerComment.add(manager);
        return null;
    }

    public String btnAddSupervisor_action() {
        QuestionnaireCommentManager manager = new QuestionnaireCommentManager(
                Integer.valueOf(ddnSupSection.getValue().toString()),
                allQuestionsManager.getItemLabel(getSectionList(), ddnSupSection.getValue()),
                txtSupRemark.getValue().toString());
        supervisorComment.add(manager);
        return null;
    }

    public String btnSaveComment_action() {
        if (false) {
            commentManager.saveSupervisorComment(commentManager(), getSupervisorComment());
        } else {
            commentManager.saveReviwerComment(commentManager(), getReviwerComment());
        }
        return null;
    }

    public String btnNextSec_action() {
        panelTabSet.setSelectedIndex(1);
//        pnlTabPage1.setDisabled(true);
//        pnlTabPage2.setDisabled(false);
//        pnlTabPage3.setDisabled(true);
        return null;
    }

    public String btnNextthird_action() {
        panelTabSet.setSelectedIndex(2);
//        pnlTabPage1.setDisabled(true);
//        pnlTabPage2.setDisabled(true);
//        pnlTabPage3.setDisabled(false);
        return null;
    }

    public String btnPrevFirst_action() {
        panelTabSet.setSelectedIndex(0);
//        pnlTabPage1.setDisabled(false);
//        pnlTabPage2.setDisabled(true);
//        pnlTabPage3.setDisabled(true);
        return null;
    }

    public String btnPrevSecond_action() {
        panelTabSet.setSelectedIndex(1);
//        pnlTabPage1.setDisabled(true);
//        pnlTabPage2.setDisabled(false);
//        pnlTabPage3.setDisabled(true);
        return null;
    }

    private void clearAllPage() {
        getPnlSectionOne().getChildren().clear();
        getPnlSectionTwo().getChildren().clear();
        getPnlSectionThree().getChildren().clear();
        getPnlSectionFour().getChildren().clear();
        getPnlSectionFive().getChildren().clear();
    }

    private void generateDynamicPage() {

        int top = 10;//top px of all components
        int left = 160;//left px of all components
        int left24 = 24;//left px of DataTable
        int tblIndex = 0;//index of table

        // Section one indexes
        int topSectionOne = top;//top px of section one components
        int indexSectionOne = 1;// normal increment for top px of section one components
        int tblHeightSectionOne = 0;// addtional increment for top px if table created in section one

        //section two indexes
        int topSectionTwo = top;
        int indexSectionTwo = 1;
        int tblHeightSectionTwo = 0;

        //section three indexes
        int topSectionThree = top;
        int indexSectionThree = 1;
        int tblHeightSectionThree = 0;

        //section four indexes
        int topSectionFour = top;
        int indexSectionFour = 1;
        int tblHeightSectionFour = 0;

        //section five indexes
        int topSectionFive = top;
        int indexSectionFive = 1;
        int tblHeightSectionFive = 0;
        //
        ArrayList<AllQuestionsManager> allQuestionList = allQuestionsManager.readAllQuestions(defQuesId);
        Iterator<AllQuestionsManager> questionIterator = allQuestionList.iterator();

        while (questionIterator.hasNext()) {
            AllQuestionsManager questionsManager = questionIterator.next();

            if (questionsManager.getQuestionSection() == 1) {

                topSectionOne = 24 * (indexSectionOne += 3) + tblHeightSectionOne;
                // add questions to section one
                int result = addQuestionsToPanelSetion(
                        getPnlSectionOne(), questionsManager, tblIndex, topSectionOne, left, left24);
                tblHeightSectionOne += result;
                tblIndex = (result > 0) ? tblIndex++ : tblIndex;

            } else if (questionsManager.getQuestionSection() == 2) {

                topSectionTwo = 24 * (indexSectionTwo+=3) + tblHeightSectionTwo;
                // add questions to section two
                int result = addQuestionsToPanelSetion(
                        getPnlSectionTwo(), questionsManager, tblIndex, topSectionTwo, left, left24);
                tblHeightSectionTwo += result;
                tblIndex = (result > 0) ? tblIndex++ : tblIndex;

            } else if (questionsManager.getQuestionSection() == 3) {

                topSectionThree = 24 * (indexSectionThree+=3) + tblHeightSectionThree;
                // add questions to section Three
                int result = addQuestionsToPanelSetion(
                        getPnlSectionThree(), questionsManager, tblIndex, topSectionThree, left, left24);
                tblHeightSectionThree += result;
                tblIndex = (result > 0) ? tblIndex++ : tblIndex;

            } else if (questionsManager.getQuestionSection() == 4) {

                topSectionFour = 24 * (indexSectionFour+=3) + tblHeightSectionFour;
                // add questions to section Four
                int result = addQuestionsToPanelSetion(
                        getPnlSectionFour(), questionsManager, tblIndex, topSectionFour, left, left24);
                tblHeightSectionFour += result;
                tblIndex = (result > 0) ? tblIndex++ : tblIndex;

            } else if (questionsManager.getQuestionSection() == 5) {

                topSectionFive = 24 * (indexSectionFive+=3) + tblHeightSectionFive;
                // add questions to section Five
                int result = addQuestionsToPanelSetion(
                        getPnlSectionFive(), questionsManager, tblIndex, topSectionFive, left, left24);
                tblHeightSectionFive += result;
                tblIndex = (result > 0) ? tblIndex++ : tblIndex;
            }
        }
    }

    private int addQuestionsToPanelSetion(PanelLayout pnlSection, AllQuestionsManager questionsManager, int tblIndex, int top, int left, int left24) {
        int tblHight = 0;
        //question label
       
        pnlSection.getChildren().add(
                dynamicFiledList.getHtmlOutputLabel(questionsManager.getQuestionId(), questionsManager.getQuestion(), top, left24));

        if (questionsManager.getTableForm()) {//question is in table form

            //add table to this section
            HtmlPanelGroup pnlTblGroup = dynamicFiledList.populateDynamicDataTable(
                    questionsManager.getQuestionId(), tblIndex, top + 24, left24, 300, 600);
            pnlSection.getChildren().add(pnlTblGroup);
            tblHight = 300;

        } else {//question is  not in table form


            if (questionsManager.getQuestionType() == 1) {

                // question need is single line answer add inputText
                pnlSection.getChildren().add(
                        dynamicFiledList.getHtmlInputText(questionsManager.getQuestionId(), top + 32, left));

            } else if (questionsManager.getQuestionType() == 2) {

                // question need is many lines answer add inputTeaxtArea
                pnlSection.getChildren().add(
                        dynamicFiledList.getHtmlInputTextArea(questionsManager.getQuestionId(), top + 32, left));
                tblHight = 30;
            } else if (questionsManager.getQuestionType() == 3) {

                // question has only one answer from list of choices  add raduiButton
                pnlSection.getChildren().add(
                        dynamicFiledList.getHtmlSelectOneRadio(questionsManager.getQuestionId(), top + 32, left, questionsManager.getOptionGroupId()));

            } else if (questionsManager.getQuestionType() == 4) {
                // question  have many answers  from list of choices  add selectManyCheckBox
                pnlSection.getChildren().add(
                        dynamicFiledList.getHtmlSelectManyCheckbox(questionsManager.getQuestionId(), top + 32, left, questionsManager.getOptionGroupId()));
            }
        }
        return tblHight;
    }

    private ArrayList<DynamicField> saveAnswersPnlSection(PanelLayout pnlSection) {
        ArrayList<DynamicField> dynamicFields = new ArrayList<DynamicField>();
        if (pnlSection != null) {
            for (UIComponent comp : pnlSection.getChildren()) {
                String id = "0";
                String value = "";
                if (comp instanceof HtmlInputText) {
                    HtmlInputText inputText = ((HtmlInputText) comp);
                    id = String.valueOf(inputText.getId());
                    value = String.valueOf(inputText.getValue());
                } else if (comp instanceof HtmlInputTextarea) {
                    HtmlInputTextarea inputTextarea = ((HtmlInputTextarea) comp);
                    id = String.valueOf(inputTextarea.getId());
                    value = String.valueOf(inputTextarea.getValue());
                } else if (comp instanceof HtmlSelectOneRadio) {
                    HtmlSelectOneRadio selectOneRadio = ((HtmlSelectOneRadio) comp);
                    id = String.valueOf(selectOneRadio.getId());
                    value = String.valueOf(selectOneRadio.getValue());
                } else if (comp instanceof HtmlSelectManyCheckbox) {
                    HtmlSelectManyCheckbox selectManyCheckbox = ((HtmlSelectManyCheckbox) comp);
                    id = String.valueOf(selectManyCheckbox.getId());
                    value = String.valueOf(selectManyCheckbox.getValue());
                } else if (comp instanceof HtmlSelectOneMenu) {
                    HtmlSelectOneMenu selectOneMenu = ((HtmlSelectOneMenu) comp);
                    id = String.valueOf(selectOneMenu.getId());
                    value = String.valueOf(selectOneMenu.getValue());
                }
                if (id.length() >= 6) {
                    dynamicFields.add(new DynamicField(
                            Integer.valueOf(id.substring(6, id.length())),
                            value));
                }
            }
        }
        return dynamicFields;
    }

    private DynamicField saveAnswerdBy() {
        DynamicField dynamicField = new DynamicField(
                Integer.valueOf(lstActiveQuest.getValue().toString()),
                loggedInUserId,
                txtFromDate.getValue().toString());
        return dynamicField;
    }

    private ArrayList<DynamicField> saveAllAnswers() {
        ArrayList<DynamicField> dynamicFields = new ArrayList<DynamicField>();
        dynamicFields.addAll(saveAnswersPnlSection(getPnlSectionOne()));
        dynamicFields.addAll(saveAnswersPnlSection(getPnlSectionTwo()));
        dynamicFields.addAll(saveAnswersPnlSection(getPnlSectionThree()));
        dynamicFields.addAll(saveAnswersPnlSection(getPnlSectionFour()));
        dynamicFields.addAll(saveAnswersPnlSection(getPnlSectionFive()));
        return dynamicFields;
    }

    private void setAnswerOfQuestions(int questionnaireAnsId) {
        ArrayList<DynamicField> answerlist = answerManager.selectQuestionsAnswer(questionnaireAnsId);
        for (DynamicField dynamicField : answerlist) {

            String id = "answer" + dynamicField.getQuestionId();
            if (dynamicField.getSectionId() == 1) {
                setAnswerValuetoComponentSectionOne(id, dynamicField.getAnswer(), dynamicField.getQuestionType());
            } else if (dynamicField.getSectionId() == 2) {
                setAnswerValuetoComponentSectionTwo(id, dynamicField.getAnswer(), dynamicField.getQuestionType());
            } else if (dynamicField.getSectionId() == 3) {
                setAnswerValuetoComponentSectionThree(id, dynamicField.getAnswer(), dynamicField.getQuestionType());
            } else if (dynamicField.getSectionId() == 4) {
                setAnswerValuetoComponentSectionFour(id, dynamicField.getAnswer(), dynamicField.getQuestionType());
            } else if (dynamicField.getSectionId() == 5) {
                setAnswerValuetoComponentSectionFive(id, dynamicField.getAnswer(), dynamicField.getQuestionType());
            }
        }
    }

    private void setAnswerValuetoComponentSectionOne(String id, String value, int questionType) {
        if (getPnlSectionOne().findComponent(id) != null) {
            if (questionType == 1) {
                ((HtmlInputText) getPnlSectionOne().findComponent(id)).setValue(value);
            } else if (questionType == 2) {
                ((HtmlInputText) getPnlSectionOne().findComponent(id)).setValue(value);
            } else if (questionType == 3) {
                ((HtmlSelectOneRadio) getPnlSectionOne().findComponent(id)).setValue(value);
            } else if (questionType == 4) {
                ((HtmlSelectManyCheckbox) getPnlSectionOne().findComponent(id)).setValue(value);
            }
        }
    }

    private void setAnswerValuetoComponentSectionTwo(String id, String value, int questionType) {
        if (getPnlSectionOne().findComponent(id) != null) {
            if (questionType == 1) {
                ((HtmlInputText) getPnlSectionTwo().findComponent(id)).setValue(value);
            } else if (questionType == 2) {
                ((HtmlInputText) getPnlSectionTwo().findComponent(id)).setValue(value);
            } else if (questionType == 3) {
                ((HtmlSelectOneRadio) getPnlSectionTwo().findComponent(id)).setValue(value);
            } else if (questionType == 4) {
                ((HtmlSelectManyCheckbox) getPnlSectionTwo().findComponent(id)).setValue(value);
            }
        }
    }

    private void setAnswerValuetoComponentSectionThree(String id, String value, int questionType) {
        if (getPnlSectionOne().findComponent(id) != null) {
            if (questionType == 1) {
                ((HtmlInputText) getPnlSectionThree().findComponent(id)).setValue(value);
            } else if (questionType == 2) {
                ((HtmlInputText) getPnlSectionThree().findComponent(id)).setValue(value);
            } else if (questionType == 3) {
                ((HtmlSelectOneRadio) getPnlSectionThree().findComponent(id)).setValue(value);
            } else if (questionType == 4) {
                ((HtmlSelectManyCheckbox) getPnlSectionThree().findComponent(id)).setValue(value);
            }
        }
    }

    private void setAnswerValuetoComponentSectionFour(String id, String value, int questionType) {
        if (getPnlSectionOne().findComponent(id) != null) {
            if (questionType == 1) {
                ((HtmlInputText) getPnlSectionFour().findComponent(id)).setValue(value);
            } else if (questionType == 2) {
                ((HtmlInputText) getPnlSectionFour().findComponent(id)).setValue(value);
            } else if (questionType == 3) {
                ((HtmlSelectOneRadio) getPnlSectionFour().findComponent(id)).setValue(value);
            } else if (questionType == 4) {
                ((HtmlSelectManyCheckbox) getPnlSectionFour().findComponent(id)).setValue(value);
            }
        }
    }

    private void setAnswerValuetoComponentSectionFive(String id, String value, int questionType) {
        if (getPnlSectionOne().findComponent(id) != null) {
            if (questionType == 1) {
                ((HtmlInputText) getPnlSectionFive().findComponent(id)).setValue(value);
            } else if (questionType == 2) {
                ((HtmlInputText) getPnlSectionFive().findComponent(id)).setValue(value);
            } else if (questionType == 3) {
                ((HtmlSelectOneRadio) getPnlSectionFive().findComponent(id)).setValue(value);
            } else if (questionType == 4) {
                ((HtmlSelectManyCheckbox) getPnlSectionFive().findComponent(id)).setValue(value);
            }
        }
    }

    public void panelCollapsible4_processAction(ActionEvent ae) {
    }

}
