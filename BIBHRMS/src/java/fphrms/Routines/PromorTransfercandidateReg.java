/*
 * PromorTransfercandidateReg.java
 *
 * Created on Jul 25, 2012, 10:31:38 AM
 * Copyright HRMS
 */
package fphrms.Routines;

import com.sun.rave.faces.data.DefaultTableDataModel;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import manager.recruitmentManager.RecruitmentReport;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PromorTransfercandidateReg extends AbstractPageBean {



    RecruitmentReport promotionFilterCandidateReport = new RecruitmentReport();
    private ArrayList<RecruitmentReport> promotionFilterReportList = new ArrayList<RecruitmentReport>();

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PromorTransfercandidateReg() {
    }

    public RecruitmentReport getPromotionFilterCandidateReport() {
        return promotionFilterCandidateReport;
    }

    public void setPromotionFilterCandidateReport(RecruitmentReport promotionFilterCandidateReport) {
        this.promotionFilterCandidateReport = promotionFilterCandidateReport;
    }


    public ArrayList<RecruitmentReport> getPromotionFilterReportList() {
        return promotionFilterReportList;
    }

    public void setPromotionFilterReportList(ArrayList<RecruitmentReport> promotionFilterReportList) {
        this.promotionFilterReportList = promotionFilterReportList;
    }



    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
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
            log("Page1 Initialization Failure", e);
            throw e instanceof FacesException ? (FacesException) e : new FacesException(e);
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
      populatePromotionComponent();
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }
    private void  populateParticipantTable()
    {
   //  recurReport.promotionFilterCandidate();

    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected DocumentRequestReport getRoutines$DocumentRequestReport() {
        return (DocumentRequestReport) getBean("Routines$DocumentRequestReport");
    }
    RecruitmentReport recuRepot=new RecruitmentReport();
      String jobType;
       String rank;
        String salary;
        String directorate;
        String empID;
        String sex;
        int age;
        String rank_id;
        String jobTypee;
        String toReasult;
        String interviewExam;
        String perforamcneValue;
        String educLevel;
        String educType;
        String experience;
        String advertDateFrom;
        String advertDateTo;
        String refNo;
        String promotionReasoun;
        String fullName;
        String approvDate;

      ArrayList<RecruitmentReport> promtionReport= new ArrayList<RecruitmentReport>();

    public String getAdvertDateFrom() {
        return advertDateFrom;
    }

    public void setAdvertDateFrom(String advertDateFrom) {
        this.advertDateFrom = advertDateFrom;
    }

    public String getAdvertDateTo() {
        return advertDateTo;
    }

    public void setAdvertDateTo(String advertDateTo) {
        this.advertDateTo = advertDateTo;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getApprovDate() {
        return approvDate;
    }

    public void setApprovDate(String approvDate) {
        this.approvDate = approvDate;
    }

    public String getDirectorate() {
        return directorate;
    }

    public void setDirectorate(String directorate) {
        this.directorate = directorate;
    }

    public String getEducLevel() {
        return educLevel;
    }

    public void setEducLevel(String educLevel) {
        this.educLevel = educLevel;
    }

    public String getEducType() {
        return educType;
    }

    public void setEducType(String educType) {
        this.educType = educType;
    }

    public String getEmpID() {
        return empID;
    }

    public void setEmpID(String empID) {
        this.empID = empID;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getInterviewExam() {
        return interviewExam;
    }

    public void setInterviewExam(String interviewExam) {
        this.interviewExam = interviewExam;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public String getJobTypee() {
        return jobTypee;
    }

    public void setJobTypee(String jobTypee) {
        this.jobTypee = jobTypee;
    }

    public String getPerforamcneValue() {
        return perforamcneValue;
    }

    public void setPerforamcneValue(String perforamcneValue) {
        this.perforamcneValue = perforamcneValue;
    }

    public String getPromotionReasoun() {
        return promotionReasoun;
    }

    public void setPromotionReasoun(String promotionReasoun) {
        this.promotionReasoun = promotionReasoun;
    }

    public ArrayList<RecruitmentReport> getPromtionReport() {
        return promtionReport;
    }

    public void setPromtionReport(ArrayList<RecruitmentReport> promtionReport) {
        this.promtionReport = promtionReport;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String getRank_id() {
        return rank_id;
    }

    public void setRank_id(String rank_id) {
        this.rank_id = rank_id;
    }

    public RecruitmentReport getRecuRepot() {
        return recuRepot;
    }

    public void setRecuRepot(RecruitmentReport recuRepot) {
        this.recuRepot = recuRepot;
    }

    public String getRefNo() {
        return refNo;
    }

    public void setRefNo(String refNo) {
        this.refNo = refNo;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getToReasult() {
        return toReasult;
    }

    public void setToReasult(String toReasult) {
        this.toReasult = toReasult;
    }


     private boolean populatePromotionComponent() {

         int tableSize;

         ArrayList<HashMap> paromotedHashMap = recuRepot.promotionFilterCandidate();
        if (paromotedHashMap != null) {
            tableSize = 0;

            for (HashMap hmDl : paromotedHashMap) {
                jobType = hmDl.get("JOB_NAME").toString();
                rank = hmDl.get("RANK_ID").toString();
                salary = hmDl.get("SALARY").toString();
                directorate = hmDl.get("dept_name").toString();
                empID = hmDl.get("EMP_ID").toString();
                sex = hmDl.get("SEX").toString();
                age = Integer.parseInt(hmDl.get("AGE").toString());
                rank_id = hmDl.get("RANK_ID").toString();
                jobTypee = hmDl.get("JOB_NAME").toString();
                toReasult = hmDl.get("TOTALRESULT").toString();
                interviewExam = hmDl.get("EXAMPERCENTAGE").toString();
                perforamcneValue = hmDl.get("performancevalue").toString();
                educLevel=hmDl.get("EDUCATIONLEAVE").toString();
                educType = hmDl.get("EDUCATIONTYPE").toString();
                experience = hmDl.get("INSIDEeXPRIANCE").toString();
                advertDateFrom = hmDl.get("ADVERT_DATE_FROM").toString();
                advertDateTo = hmDl.get("ADVERT_DATE_TO").toString();
                refNo = hmDl.get("request_letter_number").toString();
                promotionReasoun=hmDl.get("reason").toString();
                fullName=hmDl.get("FULLNAME").toString();
                approvDate = hmDl.get("completed_date").toString();
                promtionReport.add(new RecruitmentReport(jobType, rank, salary , directorate, empID, sex, age,rank_id,jobTypee,toReasult,interviewExam,perforamcneValue, educLevel, educType,experience,advertDateFrom, advertDateTo,refNo,promotionReasoun,fullName,approvDate));
                tableSize++;
                    }
            return true;
        } else {

            return false;
        }
    }
}