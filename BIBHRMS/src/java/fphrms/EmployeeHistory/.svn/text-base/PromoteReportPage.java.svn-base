/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.dragdrop.DropEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import control.ReportControl;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.ListIterator;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.ImageIcon;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.CommonValidation;
import manager.globalUseManager.LookUpManager;
import manager.departmentManage.DepartmentManage;
import manager.employeeHistoryManager.PromotionManager;
import manager.employeeManager.ReportManager;
import manager.globalUseManager.HRValidation;
import manager.promotionManager.PromoteReportManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PromoteReportPage extends AbstractPageBean {

    private PromotionManager promotionManager = new PromotionManager();
    private PromoteReportManager promoteReportManager = new PromoteReportManager();

    // <editor-fold defaultstate="collapsed" desc="Local Variables">
    private int __placeholder;
    private ArrayList<SelectItem> insideRecruitment = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> zerf = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> directorate = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> division = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> mastebaberia = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> team = new ArrayList<SelectItem>();
    private LookUpManager lookUpManager = new LookUpManager();
    private ReportControl reportControl = new ReportControl();
    private EmployeeManage employeeManage = new EmployeeManage();
    private DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<EmployeePromotion> promotionList = new ArrayList<EmployeePromotion>();
    private static String employeeId = null;
    private ImageIcon LOGO;
    private ImageIcon employeePicture;
    private byte[] bytEmployeePicture;
    private String employmentType = "";
    private String employeeGender = "";

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }

    public ArrayList<EmployeePromotion> getPromotionList() {
        return promotionList;
    }

    public void setPromotionList(ArrayList<EmployeePromotion> promotionList) {
        this.promotionList = promotionList;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox4Bean() {
        return selectBooleanCheckbox4Bean;
    }

    public void setSelectBooleanCheckbox4Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox4Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox5Bean() {
        return selectBooleanCheckbox5Bean;
    }

    public void setSelectBooleanCheckbox5Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox5Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox6Bean = new DefaultSelectedData();
    private DefaultSelectedData selectBooleanCheckbox625Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox625Bean() {
        return selectBooleanCheckbox625Bean;
    }

    public void setSelectBooleanCheckbox625Bean(DefaultSelectedData selectBooleanCheckbox625Bean) {
        this.selectBooleanCheckbox625Bean = selectBooleanCheckbox625Bean;
    }

    public DefaultSelectedData getSelectBooleanCheckbox6Bean() {
        return selectBooleanCheckbox6Bean;
    }

    public void setSelectBooleanCheckbox6Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox6Bean = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox7Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox7Bean() {
        return selectBooleanCheckbox7Bean;
    }

    public void setSelectBooleanCheckbox7Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox7Bean = dsd;
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

  
    private HtmlSelectBooleanCheckbox choPromotedEmployee = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoPromotedEmployee() {
        return choPromotedEmployee;
    }

    public void setChoPromotedEmployee(HtmlSelectBooleanCheckbox hsbc) {
        this.choPromotedEmployee = hsbc;
    }
    private HtmlSelectBooleanCheckbox choExamResult = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoExamResult() {
        return choExamResult;
    }

    public void setChoExamResult(HtmlSelectBooleanCheckbox hsbc) {
        this.choExamResult = hsbc;
    }
    private HtmlSelectOneMenu drlEmployeeTitle = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEmployeeTitle() {
        return drlEmployeeTitle;
    }

    public void setDrlEmployeeTitle(HtmlSelectOneMenu hsom) {
        this.drlEmployeeTitle = hsom;
    }
    private HtmlInputText txtFromDate = new HtmlInputText();

    public HtmlInputText getTxtFromDate() {
        return txtFromDate;
    }

    public void setTxtFromDate(HtmlInputText hit) {
        this.txtFromDate = hit;
    }
    private HtmlInputText txtToDate = new HtmlInputText();

    public HtmlInputText getTxtToDate() {
        return txtToDate;
    }

    public void setTxtToDate(HtmlInputText hit) {
        this.txtToDate = hit;
    }
    private HtmlCommandButton btnPreviewSelected = new HtmlCommandButton();

    public HtmlCommandButton getBtnPreviewSelected() {
        return btnPreviewSelected;
    }

    public void setBtnPreviewSelected(HtmlCommandButton hcb) {
        this.btnPreviewSelected = hcb;
    }
    private HtmlCommandButton btnSearch = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearch() {
        return btnSearch;
    }

    public void setBtnSearch(HtmlCommandButton hcb) {
        this.btnSearch = hcb;
    }

    public ArrayList<SelectItem> getInsideRecruitment() {
        return insideRecruitment;
    }

    public void setInsideRecruitmente(ArrayList<SelectItem> employeeTitle) {
        this.insideRecruitment = employeeTitle;
    }

    public ImageIcon getLOGO() {
        return LOGO;
    }

    public void setLOGO(ImageIcon LOGO) {
        this.LOGO = LOGO;
    }

    public ImageIcon getEmployeePicture() {
        return employeePicture;
    }

    public void setEmployeePicture(ImageIcon employeePicture) {
        this.employeePicture = employeePicture;
    }

    public byte[] getBytEmployeePicture() {
        return bytEmployeePicture;
    }

    public void setBytEmployeePicture(byte[] bytEmployeePicture) {
        this.bytEmployeePicture = bytEmployeePicture;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu2DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems1() {
        return selectOneMenu2DefaultItems1;
    }

    public void setSelectOneMenu2DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems2() {
        return selectOneMenu2DefaultItems2;
    }

    public void setSelectOneMenu2DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems3() {
        return selectOneMenu2DefaultItems3;
    }

    public void setSelectOneMenu2DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems3 = dsia;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu4DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu4DefaultItems() {
        return selectOneMenu4DefaultItems;
    }

    public void setSelectOneMenu4DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu4DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu5DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu5DefaultItems() {
        return selectOneMenu5DefaultItems;
    }

    public void setSelectOneMenu5DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu5DefaultItems = dsi;
    }

    public ArrayList<SelectItem> getZerf() {
        zerf = departmentManage.getDepartmentName();
        return zerf;
    }

    public void setZerf(ArrayList<SelectItem> zerf) {
        this.zerf = zerf;
    }

    public ArrayList<SelectItem> getDirectorate() {
        return directorate;
    }

    public void setDirectorate(ArrayList<SelectItem> directorate) {
        this.directorate = directorate;
    }

    public ArrayList<SelectItem> getDivision() {
        return division;
    }

    public void setDivision(ArrayList<SelectItem> division) {
        this.division = division;
    }

    public ArrayList<SelectItem> getMastebaberia() {
        return mastebaberia;
    }

    public void setMastebaberia(ArrayList<SelectItem> mastebaberia) {
        this.mastebaberia = mastebaberia;
    }

    public ArrayList<SelectItem> getTeam() {
        return team;
    }

    public void setTeam(ArrayList<SelectItem> team) {
        this.team = team;
    }
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }
    private HtmlPanelGroup panelConfirmationGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelConfirmationGroupMessage() {
        return panelConfirmationGroupMessage;
    }

    public void setPanelConfirmationGroupMessage(HtmlPanelGroup hpg) {
        this.panelConfirmationGroupMessage = hpg;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage4 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private HtmlSelectOneMenu drlBachCode = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBachCode() {
        return drlBachCode;
    }

    public void setDrlBachCode(HtmlSelectOneMenu hsom) {
        this.drlBachCode = hsom;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PromoteReportPage() {
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
    public void init() {
        setInsideRecruitmente(promoteReportManager.promotionBachCodeList());

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
    public void destroy() {
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

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected SessionBean1 getSessionBean1() {
        return (SessionBean1) getBean("SessionBean1");
    }

    public void loadEmployeePicture(byte[] employeePicture) {
        try {
            if (employeePicture != null) {
                this.employeePicture = new ImageIcon((byte[]) employeePicture);
            } else {
                this.employeePicture = new ImageIcon();
            }
        } catch (Exception ex) {
        }

    }

    public void LoadLOGO() {
        List data = null;
        ReportManager manager1 = new ReportManager();
        data = manager1.loadCompanyLogo();
        ListIterator<ReportManager> lstmb = data.listIterator();
        try {
            while (lstmb.hasNext()) {
                ReportManager mag = lstmb.next();
                if (mag.getFPLOGO() != null) {
                    LOGO = new ImageIcon((byte[]) mag.getFPLOGO());
                } else {
                    LOGO = new ImageIcon();
                }
            }
        } catch (Exception ex) {
        }

    }

    public static class EmployeePromotion implements Serializable {

        private String employeeId;
        private String fullName;
        private String department;
        private String dateTerminated;
        private boolean selected;
        private String promotion_Date;
        private String promotion_Type;
        private String rank_From;
        private String rank_To;
        private String step_From;
        private String step_To;
        private String salary_From;
        private String salary_To;
        private String titlefrom;
        private String titleto;
        private String titleFromDescription;
        private String titleToDescription;

        public String getTitleFromDescription() {
            return titleFromDescription;
        }

        public void setTitleFromDescription(String titleFromDescription) {
            this.titleFromDescription = titleFromDescription;
        }

        public String getTitleToDescription() {
            return titleToDescription;
        }

        public void setTitleToDescription(String titleToDescription) {
            this.titleToDescription = titleToDescription;
        }

        public String getPromotion_Date() {
            return promotion_Date;
        }

        public void setPromotion_Date(String promotion_Date) {
            this.promotion_Date = promotion_Date;
        }

        public String getPromotion_Type() {
            return promotion_Type;
        }

        public void setPromotion_Type(String promotion_Type) {
            this.promotion_Type = promotion_Type;
        }

        public String getRank_From() {
            return rank_From;
        }

        public void setRank_From(String rank_From) {
            this.rank_From = rank_From;
        }

        public String getRank_To() {
            return rank_To;
        }

        public void setRank_To(String rank_To) {
            this.rank_To = rank_To;
        }

        public String getSalary_From() {
            return salary_From;
        }

        public void setSalary_From(String salary_From) {
            this.salary_From = salary_From;
        }

        public String getSalary_To() {
            return salary_To;
        }

        public void setSalary_To(String salary_To) {
            this.salary_To = salary_To;
        }

        public String getStep_From() {
            return step_From;
        }

        public void setStep_From(String step_From) {
            this.step_From = step_From;
        }

        public String getStep_To() {
            return step_To;
        }

        public void setStep_To(String step_To) {
            this.step_To = step_To;
        }

        public String getTitlefrom() {
            return titlefrom;
        }

        public void setTitlefrom(String titlefrom) {
            this.titlefrom = titlefrom;
        }

        public String getTitleto() {
            return titleto;
        }

        public void setTitleto(String titleto) {
            this.titleto = titleto;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getDateTerminated() {
            return dateTerminated;
        }

        public void setDateTerminated(String dateTerminated) {
            this.dateTerminated = dateTerminated;
        }

        public String getDepartment() {
            return department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public EmployeePromotion(String employeeId, String fullName, String promotion_Date, String rank_From, String rank_To, String step_From, String step_To, String salary_From, String salary_To, String titlefrom, String titleto, String titleFromDescription, String titleToDescription) {
            this.employeeId = employeeId;
            this.fullName = fullName;
            this.promotion_Date = promotion_Date;
            this.rank_From = rank_From;
            this.rank_To = rank_To;
            this.step_From = step_From;
            this.step_To = step_To;
            this.salary_From = salary_From;
            this.salary_To = salary_To;
            this.titlefrom = titlefrom;
            this.titleto = titleto;
            this.titleFromDescription = titleFromDescription;
            this.titleToDescription = titleToDescription;
        }
    }

    public String btnSearch_action() {
        displayEmployeePromotion();
        //return null means stay on the same page
        return null;
    }

    private void displayEmployeePromotion() {
        String department = "";
        String titleFromDescription = "";
        String titleToDescription = "";
        String rankFromDescription = "";
        String rankToDescription = "";
        List promotionDataList = new ArrayList();
        Collection data = null; //
        String jasperLocation = "E:\\FEDERALREPORTS\\Promotion\\EmployeePromotionExamResult.jasper";
        String jasper_Location = "E:\\FEDERALREPORTS\\Promotion\\EmployeeGroupPromotionDetail.jasper";
        ArrayList<HashMap> employeePromotionList = new ArrayList<HashMap>();
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletResponse response = (HttpServletResponse) context.getExternalContext().getResponse();
        HttpServletRequest request = (HttpServletRequest) context.getExternalContext().getRequest();
        ServletOutputStream servletOutputStream = null;
        String reportName = "Promotion Repoart";
        HashMap param = new HashMap();
        try {
            if (choPromotedEmployee.isSelected() && choExamResult.isSelected()) {
                employeePromotionList = promoteReportManager.promotedEmployeeExamResultReport(drlBachCode.getValue().toString());
                data = employeePromotionList; //
                param.put("printedby", "name");
                servletOutputStream = response.getOutputStream();
                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
            } else if (choPromotedEmployee.isSelected()) {
                if (HRValidation.validateRequired(txtFromDate.getValue()) && HRValidation.validateRequired(txtToDate.getValue())) {
                    employeePromotionList = promoteReportManager.promotionReportByDate(txtFromDate.getValue().toString(), txtToDate.getValue().toString());
                    data = employeePromotionList; //
                    param.put("printedby", "name");
                    servletOutputStream = response.getOutputStream();
                    reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                } else {
                    if (HRValidation.validateRequired(drlBachCode.getValue())) {
                        employeePromotionList = promoteReportManager.promotionReportByDate(drlBachCode.getValue().toString());
                        data = employeePromotionList; //
                        param.put("printedby", "name");
                        servletOutputStream = response.getOutputStream();
                        reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);
                    }
                }
            } else if (choExamResult.isSelected()) {
                employeePromotionList = promoteReportManager.employeePromotionReport(drlBachCode.getValue().toString());
                data = employeePromotionList; //
                param.put("printedby", "name");
                servletOutputStream = response.getOutputStream();
                reportControl.getReport(jasperLocation, reportName, servletOutputStream, "html", response, request, param, data);

            } else if (choExamResult.isSelected()) {
            } //
            else {
                employeeGender = " AND (hr_employee_info.SEX='Female' OR hr_employee_info.SEX='Male')";
            }
            servletOutputStream.flush();
            servletOutputStream.close();
//                            // Stop resend
            FacesContext.getCurrentInstance().responseComplete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }





    public void chkPermanent_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                // chkContrat.setSelected(false);
            }
        }
    }

    public void chkContrat_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                //  chkPermanent.setSelected(false);
            }
        }
    }

    public void choExamResult_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                //choMale.setSelected(false);
            }
        }
    }

    public void choPromotedEmployee_processValueChange(ValueChangeEvent vce) {
        if (!CommonValidation.isUpdatePhase(vce)) {
            if (vce.getNewValue() != null) {
                //  choFemale.setSelected(false);
            }
        }
    }

    public String btnPreviewSelected_action() {

        return null;
    }



 

    public String lnkResignApprovePage_action() {
        //return null means stay on the same page
        return "PromoteWithoutVacancy";
    }

    public String lnkResignRequestPage_action() {
        //return null means stay on the same page
        return "PromotionReques";
    }

    public String btnPreviewAll_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage4.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage4.setValue(messageToDisplay);
        lblFormMessage4.setRendered(true);
        pnConfirmationMessage.setAutoCentre(true);
        pnConfirmationMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }
}
