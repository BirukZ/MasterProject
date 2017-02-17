/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.DefaultTree;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.PanelTab;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.component.selectinputtext.TextChangeEvent;
import com.icesoft.faces.component.tree.Tree;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.component.UISelectItems;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.globalUseManager.StringDateManipulation;
import manager.recruitmentManager.RecruitmentManager;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;


import javax.swing.tree.DefaultTreeModel;
import manager.organizationManager.LoadTree;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RecruitmentRequest extends AbstractPageBean {

    ResourceBundle messageResource = null;
    FacesContext context = null;
    public static String requesterId;
    DepartmentManage departmentManage = new DepartmentManage();
    private ArrayList<Option> readJob = new ArrayList<Option>();//= departmentManage.readAllJobBYO();
    public Option[] recritmentType = departmentManage.recuitmentType();
    EmployeeManage employeeManage = new EmployeeManage();
    RecruitmentManager recruitmentManager = new RecruitmentManager();
    //RecruitmentManager managerFroRec=new RecruitmentManager();
    Option[] requests = recruitmentManager.selectRecruitmentRequests();
    Option[] recruitmentList;
    Option[] oldRequest;
    static String employeeId;
    private List recruitRecuestList = new ArrayList<RecruitmentManager>();
    int selectedRecruitmentRow = -1;
    int selectedSelectOneMenuRow = -1;
    private Option[] selectOneRecruitmentHistory;
    private Option[] requestsUsingDate;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String currenTDateToSet = "fromDate";
    String today = dateFormat.format(new Date());
    private DefaultTree tree1Model = new DefaultTree();
    private PanelLayout pnlLayoutTree = new PanelLayout();
    private DefaultTree defaultTreeModel = new DefaultTree();
    private Tree treeOrgStructure = new Tree();
    private DefaultTree treeModel = new DefaultTree();
    ArrayList<SelectItem> perofation = new ArrayList<SelectItem>();
    private DepartmentManage departmentManager = new DepartmentManage();
    public String approveStatus;
    public String rejectStatus;
    public String requestID;

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getApproveStatus() {
        return approveStatus;
    }

    public void setApproveStatus(String approveStatus) {
        this.approveStatus = approveStatus;
    }

    public String getRejectStatus() {
        return rejectStatus;
    }

    public void setRejectStatus(String rejectStatus) {
        this.rejectStatus = rejectStatus;
    }

    public DefaultTree getTree1Model() {
        return tree1Model;
    }

    public void setTree1Model(DefaultTree dt) {
        this.tree1Model = dt;
    }
    private Tree tree1 = new Tree();

    public Tree getTree1() {
        return tree1;
    }

    public void setTree1(Tree t) {
        this.tree1 = t;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public ArrayList<SelectItem> getPerofation() {
        return perofation;
    }

    public void setPerofation(ArrayList<SelectItem> perofation) {
        this.perofation = perofation;
    }

    public DefaultTree getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTree treeModel) {
        this.treeModel = treeModel;
    }

    public PanelLayout getPnlLayoutTree() {
        return pnlLayoutTree;
    }

    public void setPnlLayoutTree(PanelLayout pl) {
        this.pnlLayoutTree = pl;
    }

    public Tree getTreeOrgStructure() {
        return treeOrgStructure;
    }

    public void setTreeOrgStructure(Tree treeOrgStructure) {
        this.treeOrgStructure = treeOrgStructure;
    }

    public DefaultTree getDefaultTreeModel() {
        return defaultTreeModel;
    }

    public void setDefaultTreeModel(DefaultTree defaultTreeModel) {
        this.defaultTreeModel = defaultTreeModel;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public Option[] getSelectOneRecruitmentHistory() {
        return selectOneRecruitmentHistory;
    }

    public Option[] getRequestsUsingDate() {
        return requestsUsingDate;
    }

    public void setRequestsUsingDate(Option[] requestsUsingDate) {
        this.requestsUsingDate = requestsUsingDate;
    }

    public void setSelectOneRecruitmentHistory(Option[] selectOneRecruitmentHistory) {
        this.selectOneRecruitmentHistory = selectOneRecruitmentHistory;
    }

    public List getRecruitRecuestList() {
        return recruitRecuestList;
    }

    public void setRecruitRecuestList(List recruitRecuestList) {
        this.recruitRecuestList = recruitRecuestList;
    }

    public Option[] getOldRequest() {
        return oldRequest;
    }

    public void setOldRequest(Option[] oldRequest) {
        this.oldRequest = oldRequest;
    }

    public Option[] getRecruitmentList() {
        return recruitmentList;
    }

    public void setRecruitmentList(Option[] recruitmentList) {
        this.recruitmentList = recruitmentList;
    }

    public Option[] getRequests() {
        return requests;
    }

    public void setRequests(Option[] requests) {
        this.requests = requests;
    }

    public Option[] getRecritmentType() {
        return recritmentType;
    }

    public void setRecritmentType(Option[] recritmentType) {
        this.recritmentType = recritmentType;
    }

    public ArrayList<Option> getReadJob() {
        return readJob;
    }

    public void setReadJob(ArrayList<Option> readJob) {
        this.readJob = readJob;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

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
    private PanelCollapsible panelCollapsible2 = new PanelCollapsible();

    public PanelCollapsible getPanelCollapsible2() {
        return panelCollapsible2;
    }

    public void setPanelCollapsible2(PanelCollapsible pc) {
        this.panelCollapsible2 = pc;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    String photoPath;
    String photoName;
    private HtmlInputTextarea txtARemark = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtARemark() {
        return txtARemark;
    }

    public void setTxtARemark(HtmlInputTextarea hit) {
        this.txtARemark = hit;
    }
    private HtmlInputText txtRequester = new HtmlInputText();

    public HtmlInputText getTxtRequester() {
        return txtRequester;
    }

    public void setTxtRequester(HtmlInputText hit) {
        this.txtRequester = hit;
    }
    private HtmlSelectOneMenu drlRequiredJobType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRequiredJobType() {
        return drlRequiredJobType;
    }

    public void setDrlRequiredJobType(HtmlSelectOneMenu hsom) {
        this.drlRequiredJobType = hsom;
    }
    private HtmlInputText txtMinQualifcation = new HtmlInputText();

    public HtmlInputText getTxtMinQualifcation() {
        return txtMinQualifcation;
    }

    public void setTxtMinQualifcation(HtmlInputText hit) {
        this.txtMinQualifcation = hit;
    }
    private HtmlInputText txtMinExperiance = new HtmlInputText();

    public HtmlInputText getTxtMinExperiance() {
        return txtMinExperiance;
    }

    public void setTxtMinExperiance(HtmlInputText hit) {
        this.txtMinExperiance = hit;
    }
    private HtmlInputText txtMinResponsiblity = new HtmlInputText();

    public HtmlInputText getTxtMinResponsiblity() {
        return txtMinResponsiblity;
    }

    public void setTxtMinResponsiblity(HtmlInputText hit) {
        this.txtMinResponsiblity = hit;
    }
    private HtmlInputText txtAdditionalskill = new HtmlInputText();

    public HtmlInputText getTxtAdditionalskill() {
        return txtAdditionalskill;
    }

    public void setTxtAdditionalskill(HtmlInputText hit) {
        this.txtAdditionalskill = hit;
    }
    private HtmlInputText txtNumberOfEmployee = new HtmlInputText();

    public HtmlInputText getTxtNumberOfEmployee() {
        return txtNumberOfEmployee;
    }

    public void setTxtNumberOfEmployee(HtmlInputText hit) {
        this.txtNumberOfEmployee = hit;
    }
    private HtmlSelectOneMenu drlEmployeeMentType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlEmployeeMentType() {
        return drlEmployeeMentType;
    }

    public void setDrlEmployeeMentType(HtmlSelectOneMenu hsom) {
        this.drlEmployeeMentType = hsom;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlCommandButton btnReset = new HtmlCommandButton();

    public HtmlCommandButton getBtnReset() {
        return btnReset;
    }

    public void setBtnReset(HtmlCommandButton hcb) {
        this.btnReset = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlOutputText txtConfirmation = new HtmlOutputText();

    public HtmlOutputText getTxtConfirmation() {
        return txtConfirmation;
    }

    public void setTxtConfirmation(HtmlOutputText hot) {
        this.txtConfirmation = hot;
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private HtmlOutputText lblFullNameAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblFullNameAutoComplete() {
        return lblFullNameAutoComplete;
    }

    public void setLblFullNameAutoComplete(HtmlOutputText hot) {
        this.lblFullNameAutoComplete = hot;
    }
    private HtmlOutputText lblEmployeeIdAutoComplete = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeIdAutoComplete() {
        return lblEmployeeIdAutoComplete;
    }

    public void setLblEmployeeIdAutoComplete(HtmlOutputText hot) {
        this.lblEmployeeIdAutoComplete = hot;
    }
    private DefaultSelectedData selectOneListbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1Bean() {
        return selectOneListbox1Bean;
    }

    public void setSelectOneListbox1Bean(DefaultSelectedData dsd) {
        this.selectOneListbox1Bean = dsd;
    }
    private HtmlSelectOneListbox listboxNewRecruitmentRequests = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListboxNewRecruitmentRequests() {
        return listboxNewRecruitmentRequests;
    }

    public void setListboxNewRecruitmentRequests(HtmlSelectOneListbox hsol) {
        this.listboxNewRecruitmentRequests = hsol;
    }
    private HtmlInputText txtApprovedNumberofEmployee = new HtmlInputText();

    public HtmlInputText getTxtApprovedNumberofEmployee() {
        return txtApprovedNumberofEmployee;
    }

    public void setTxtApprovedNumberofEmployee(HtmlInputText hit) {
        this.txtApprovedNumberofEmployee = hit;
    }
    private DefaultSelectedData defaultSelectedData1 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData1() {
        return defaultSelectedData1;
    }

    public void setDefaultSelectedData1(DefaultSelectedData dsd) {
        this.defaultSelectedData1 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private HtmlSelectOneMenu drlRecruitmentRequest = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRecruitmentRequest() {
        return drlRecruitmentRequest;
    }

    public void setDrlRecruitmentRequest(HtmlSelectOneMenu hsom) {
        this.drlRecruitmentRequest = hsom;
    }
    private HtmlInputText txtApprovedBy = new HtmlInputText();

    public HtmlInputText getTxtApprovedBy() {
        return txtApprovedBy;
    }

    public void setTxtApprovedBy(HtmlInputText hit) {
        this.txtApprovedBy = hit;
    }
    private HtmlInputText txtBachCode = new HtmlInputText();

    public HtmlInputText getTxtBachCode() {
        return txtBachCode;
    }

    public void setTxtBachCode(HtmlInputText hit) {
        this.txtBachCode = hit;
    }
    private HtmlCommandButton btnApproved = new HtmlCommandButton();

    public HtmlCommandButton getBtnApproved() {
        return btnApproved;
    }

    public void setBtnApproved(HtmlCommandButton hcb) {
        this.btnApproved = hcb;
    }
    private HtmlCommandButton btnReject = new HtmlCommandButton();

    public HtmlCommandButton getBtnReject() {
        return btnReject;
    }

    public void setBtnReject(HtmlCommandButton hcb) {
        this.btnReject = hcb;
    }
    private PanelTab tabinbox = new PanelTab();

    public PanelTab getTabinbox() {
        return tabinbox;
    }

    public void setTabinbox(PanelTab pt) {
        this.tabinbox = pt;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private PanelLayout lyApproved = new PanelLayout();

    public PanelLayout getLyApproved() {
        return lyApproved;
    }

    public void setLyApproved(PanelLayout pl) {
        this.lyApproved = pl;
    }
    private SelectInputText txtSearByName = new SelectInputText();

    public SelectInputText getTxtSearByName() {
        return txtSearByName;
    }

    public void setTxtSearByName(SelectInputText sit) {
        this.txtSearByName = sit;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlOutputText lblErrorMessageRequired = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageRequired() {
        return lblErrorMessageRequired;
    }

    public void setLblErrorMessageRequired(HtmlOutputText hot) {
        this.lblErrorMessageRequired = hot;
    }
    private HtmlOutputText lblErrorMessageForEmployeeType = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForEmployeeType() {
        return lblErrorMessageForEmployeeType;
    }

    public void setLblErrorMessageForEmployeeType(HtmlOutputText hot) {
        this.lblErrorMessageForEmployeeType = hot;
    }
    private HtmlSelectOneMenu drlPreviousRequest = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPreviousRequest() {
        return drlPreviousRequest;
    }

    public void setDrlPreviousRequest(HtmlSelectOneMenu hsom) {
        this.drlPreviousRequest = hsom;
    }
    private PanelLayout message = new PanelLayout();

    public PanelLayout getMessage() {
        return message;
    }

    public void setMessage(PanelLayout pl) {
        this.message = pl;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlCommandButton btnAddTable = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddTable() {
        return btnAddTable;
    }

    public void setBtnAddTable(HtmlCommandButton hcb) {
        this.btnAddTable = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private RowSelector rowSelectorRecruitmentRequest = new RowSelector();

    public RowSelector getRowSelectorRecruitmentRequest() {
        return rowSelectorRecruitmentRequest;
    }

    public void setRowSelectorRecruitmentRequest(RowSelector rs) {
        this.rowSelectorRecruitmentRequest = rs;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
    }
    private DefaultSelectionItems selectOneListbox1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox1DefaultItems1() {
        return selectOneListbox1DefaultItems1;
    }

    public void setSelectOneListbox1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneListbox1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems2() {
        return selectOneListbox1DefaultItems2;
    }

    public void setSelectOneListbox1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneListbox1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneListbox1DefaultItems3() {
        return selectOneListbox1DefaultItems3;
    }

    public void setSelectOneListbox1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneListbox1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlCommandButton btnCalenderRecTo = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderRecTo() {
        return btnCalenderRecTo;
    }

    public void setBtnCalenderRecTo(HtmlCommandButton hcb) {
        this.btnCalenderRecTo = hcb;
    }
    private HtmlCommandButton btnCalenderRecF = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderRecF() {
        return btnCalenderRecF;
    }

    public void setBtnCalenderRecF(HtmlCommandButton hcb) {
        this.btnCalenderRecF = hcb;
    }
    private HtmlCommandButton btnAddSearchRecHist = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddSearchRecHist() {
        return btnAddSearchRecHist;
    }

    public void setBtnAddSearchRecHist(HtmlCommandButton hcb) {
        this.btnAddSearchRecHist = hcb;
    }
    private HtmlInputText inputTextSearchHist = new HtmlInputText();

    public HtmlInputText getInputTextSearchHist() {
        return inputTextSearchHist;
    }

    public void setInputTextSearchHist(HtmlInputText hit) {
        this.inputTextSearchHist = hit;
    }
    private HtmlInputText inputTextSearchHistTo = new HtmlInputText();

    public HtmlInputText getInputTextSearchHistTo() {
        return inputTextSearchHistTo;
    }

    public void setInputTextSearchHistTo(HtmlInputText hit) {
        this.inputTextSearchHistTo = hit;
    }
    private HtmlSelectOneListbox selectOneListboxRecHist = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListboxRecHist() {
        return selectOneListboxRecHist;
    }

    public void setSelectOneListboxRecHist(HtmlSelectOneListbox hsol) {
        this.selectOneListboxRecHist = hsol;
    }
    private UISelectItems selectOneListbox1selectItemsRecHist = new UISelectItems();

    public UISelectItems getSelectOneListbox1selectItemsRecHist() {
        return selectOneListbox1selectItemsRecHist;
    }

    public void setSelectOneListbox1selectItemsRecHist(UISelectItems uisi) {
        this.selectOneListbox1selectItemsRecHist = uisi;
    }
    private HtmlCommandButton btnAddSearchRecHistAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddSearchRecHistAll() {
        return btnAddSearchRecHistAll;
    }

    public void setBtnAddSearchRecHistAll(HtmlCommandButton hcb) {
        this.btnAddSearchRecHistAll = hcb;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private PanelPopup RecRequestPopUpMsg = new PanelPopup();

    public PanelPopup getRecRequestPopUpMsg() {
        return RecRequestPopUpMsg;
    }

    public void setRecRequestPopUpMsg(PanelPopup pp) {
        this.RecRequestPopUpMsg = pp;
    }
    private HtmlPanelGroup panelGroupRecRequestPopUpMsgBody = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupRecRequestPopUpMsgBody() {
        return panelGroupRecRequestPopUpMsgBody;
    }

    public void setPanelGroupRecRequestPopUpMsgBody(HtmlPanelGroup hpg) {
        this.panelGroupRecRequestPopUpMsgBody = hpg;
    }
    private HtmlOutputText lblRecRequestPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblRecRequestPopUpMsgMain() {
        return lblRecRequestPopUpMsgMain;
    }

    public void setLblRecRequestPopUpMsgMain(HtmlOutputText hot) {
        this.lblRecRequestPopUpMsgMain = hot;
    }
    private HtmlCommandButton btnRecRequestPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnRecRequestPopUpYes() {
        return btnRecRequestPopUpYes;
    }

    public void setBtnRecRequestPopUpYes(HtmlCommandButton hcb) {
        this.btnRecRequestPopUpYes = hcb;
    }
    private HtmlCommandButton btnRecRequestPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnRecRequestPopUpNo() {
        return btnRecRequestPopUpNo;
    }

    public void setBtnRecRequestPopUpNo(HtmlCommandButton hcb) {
        this.btnRecRequestPopUpNo = hcb;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
    }
    private PanelPopup panelPopupRecruitRequest = new PanelPopup();

    public PanelPopup getPanelPopupRecruitRequest() {
        return panelPopupRecruitRequest;
    }

    public void setPanelPopupRecruitRequest(PanelPopup pp) {
        this.panelPopupRecruitRequest = pp;
    }
    private HtmlCommandButton btnRecruitRequestPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnRecruitRequestPopUpNo() {
        return btnRecruitRequestPopUpNo;
    }

    public void setBtnRecruitRequestPopUpNo(HtmlCommandButton hcb) {
        this.btnRecruitRequestPopUpNo = hcb;
    }
    private HtmlCommandButton btnRecruitRequestPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnRecruitRequestPopUpYes() {
        return btnRecruitRequestPopUpYes;
    }

    public void setBtnRecruitRequestPopUpYes(HtmlCommandButton hcb) {
        this.btnRecruitRequestPopUpYes = hcb;
    }
    private HtmlOutputText lblRecruitRequestPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblRecruitRequestPopUpMsgMain() {
        return lblRecruitRequestPopUpMsgMain;
    }

    public void setLblRecruitRequestPopUpMsgMain(HtmlOutputText hot) {
        this.lblRecruitRequestPopUpMsgMain = hot;
    }
    private PanelLayout panelLayoutRecruitRequestImageHolder = new PanelLayout();

    public PanelLayout getPanelLayoutRecruitRequestImageHolder() {
        return panelLayoutRecruitRequestImageHolder;
    }

    public void setPanelLayoutRecruitRequestImageHolder(PanelLayout pl) {
        this.panelLayoutRecruitRequestImageHolder = pl;
    }
    private HtmlOutputText lblAdvertisementValue = new HtmlOutputText();

    public HtmlOutputText getLblAdvertisementValue() {
        return lblAdvertisementValue;
    }

    public void setLblAdvertisementValue(HtmlOutputText hot) {
        this.lblAdvertisementValue = hot;
    }
    private HtmlOutputText lblStatusValue = new HtmlOutputText();

    public HtmlOutputText getLblStatusValue() {
        return lblStatusValue;
    }

    public void setLblStatusValue(HtmlOutputText hot) {
        this.lblStatusValue = hot;
    }
    private HtmlCommandButton btnAdvertise = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdvertise() {
        return btnAdvertise;
    }

    public void setBtnAdvertise(HtmlCommandButton hcb) {
        this.btnAdvertise = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDate calFromDate = new SelectInputDate();

    public SelectInputDate getCalFromDate() {
        return calFromDate;
    }

    public void setCalFromDate(SelectInputDate sid) {
        this.calFromDate = sid;
    }
    private HtmlInputText txtWorkingPlace = new HtmlInputText();

    public HtmlInputText getTxtWorkingPlace() {
        return txtWorkingPlace;
    }

    public void setTxtWorkingPlace(HtmlInputText hit) {
        this.txtWorkingPlace = hit;
    }
    private HtmlInputText txtPlaceWorking = new HtmlInputText();

    public HtmlInputText getTxtPlaceWorking() {
        return txtPlaceWorking;
    }

    public void setTxtPlaceWorking(HtmlInputText hit) {
        this.txtPlaceWorking = hit;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
    }
    private HtmlInputText txtRunk = new HtmlInputText();

    public HtmlInputText getTxtRunk() {
        return txtRunk;
    }

    public void setTxtRunk(HtmlInputText hit) {
        this.txtRunk = hit;
    }
    private HtmlInputText txtSalary = new HtmlInputText();

    public HtmlInputText getTxtSalary() {
        return txtSalary;
    }

    public void setTxtSalary(HtmlInputText hit) {
        this.txtSalary = hit;
    }

    public RecruitmentRequest() {
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
        // Perform initializations inherited from our superclass
        this.componetDisable();
        txtConfirmation.setRendered(true);
        txtConfirmation.setValue("To day   " + StringDateManipulation.toDayInEc());
        this.setReadJob(departmentManage.onDisplayJobs());
        txtApprovedBy.setValue(getSessionBean1().getEmployeeName());
        btnApproved.setRendered(true);
        btnReject.setRendered(true);
        super.init();
        employeeManage.loadEmpoyeeProfile(this.getSessionBean1().getEmployeeId());
        txtRequester.setValue(this.getSessionBean1().getEmployeeName());

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
        this.getRecruitmentList();
        txtNumberOfEmployee.setRequired(true);
        txtNumberOfEmployee.setRequiredMessage("Requred");
//        drlEmployeeMentType.setRequired(true);
//        drlEmployeeMentType.setRequiredMessage("Requred");
//        txtConfirmation.setRendered(false);
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

    public void panelBorder1north_processMyEvent(DragEvent de) {
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

    public void enableComponents() {
        this.txtNumberOfEmployee.setDisabled(false);
        this.drlEmployeeMentType.setDisabled(false);
        this.txtARemark.setDisabled(false);
        drlRequiredJobType.setDisabled(false);
        btnEdit.setDisabled(false);

    }

    public void disableComponents() {
        this.txtNumberOfEmployee.setDisabled(true);
        this.drlEmployeeMentType.setDisabled(true);
        this.txtARemark.setDisabled(true);
        this.btnEdit.setDisabled(true);
        this.drlRequiredJobType.setDisabled(true);
        this.txtPlaceWorking.setDisabled(true);
        this.txtRunk.setDisabled(true);
        this.txtMinQualifcation.setDisabled(true);
        this.txtMinResponsiblity.setDisabled(true);
        this.txtSalary.setDisabled(true);
        this.txtMinExperiance.setDisabled(true);
        this.txtAdditionalskill.setDisabled(true);
        this.btnDelete.setDisabled(true);
        this.btnSave.setDisabled(true);


    }

    private void dateValidator(FacesContext context, UIComponent component, Object value) {
        try {
            String datePatern = "(19[0-9]{2}|20[0-9]{2})\\-(0[1-9]|1[0-3])\\-(0[1-9]|[1-2][0-9]|30)";
            //messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", FacesContext.getCurrentInstance().getViewRoot().getLocale());
            ResourceBundle messageResource = null;
            // FacesContext context = null;
            if (!Pattern.matches(datePatern, value.toString().subSequence(0, value.toString().length()))) {
                ((UIInput) component).setValid(false);
                error(component, ("Invalid Date Format"));
            }
            if (value.toString().split("-")[1].equalsIgnoreCase("13")) {
                int year = Integer.parseInt(value.toString().split("-")[0]);
                int day = Integer.parseInt(value.toString().split("-")[2]);
                if ((year % 4 == 0) && (year % 100 != 0) || (year % 400 == 0)) {
                    if (day > 6) {
                        ((UIInput) component).setValid(false);
                        error(component, ("Invalid Date Format"));
                    }
                } else if (day > 5) {
                    ((UIInput) component).setValid(false);
                    error(component, ("Invalid Date Format"));
                }

            }
        } catch (Exception ex) {
        }
    }

    public void addRecruitmentRequest() {
        int checkSave = 0;
        String employeeid = this.getSessionBean1().getEmployeeId();
        if (getApplicationBean1().getSelectedEmployeeId() != null) {
            employeeid = getApplicationBean1().getSelectedEmployeeId();
        }
        List itterateTable = this.recruitRecuestList;
        Iterator<RecruitmentManager> ittRecValues = itterateTable.iterator();
        while (ittRecValues.hasNext())
        {
            RecruitmentManager singleVal = ittRecValues.next();

            checkSave = recruitmentManager.saveRequirementRequest(singleVal);
        }
        if (checkSave == 1)
        {
            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("Recruitment  Request Is Successfully Requested.And Need To Be Viewed By  Authorized Person ");
            showConformationMsg(getMessage().getStyleClass().toString());
            this.componetDisable();
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error Occured While Posting Recruitment Request.Please Try Again?");
            showConformationMsg(getMessage().getStyleClass().toString());
        }
    }

    public String btnNew_action() {
        txtConfirmation.setRendered(false);
        this.cleareComponets();
        this.componetEnable();
        this.getRecruitRecuestList().clear();
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        txtConfirmation.setRendered(false);
        if (btnSave.getValue().equals("Save")) {
            if (!drlRequiredJobType.getValue().equals("0")) {
                if (!drlEmployeeMentType.getValue().equals("---- Recuitment Type ----")) {
                    this.addRecruitmentRequest();
                } else {
                    lblErrorMessageForEmployeeType.setRendered(true);
                    lblErrorMessageForEmployeeType.setValue("Requred");
                }
            } else {
                lblErrorMessageRequired.setRendered(true);
                lblErrorMessageRequired.setValue("Requred");
            }

        }
        //return null means stay on the same page
        return null;
    }

    public void inputFile1_processAction(ActionEvent ae) {
    }

    public void drlRequiredJobType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            lblErrorMessageRequired.setRendered(false);
            txtConfirmation.setRendered(false);
            txtMinQualifcation.setValue("");
            txtMinExperiance.setValue("");
            txtMinResponsiblity.setValue("");
            txtAdditionalskill.setValue("");
            txtRunk.resetValue();
//        HashMap[] recruitRequestList = departmentManage.readJobDescription(vce.getNewValue().toString());
            HashMap recruitRequestList = departmentManage.selectJobDetaille(vce.getNewValue().toString().split("--")[0]);

            if (recruitRequestList != null) {
                try {

                    txtMinQualifcation.setValue(recruitRequestList.get("MIN_REQUIRED_QUALIFICATION").toString());
                    txtMinExperiance.setValue(recruitRequestList.get("MIN_EXPERIENCE").toString());
                    txtMinResponsiblity.setValue(recruitRequestList.get("MIN_RESPONSIBILITY").toString());
                    txtAdditionalskill.setValue(recruitRequestList.get("ADDITIONALSKILL").toString());
                    txtSalary.setValue(recruitRequestList.get("INITIAL_SALARY").toString());
                    txtRunk.setValue(recruitRequestList.get("RANK_ID").toString());

                } catch (Exception ex) {
                    ex.printStackTrace();

                }
            } else {
            }
        }
    }

    private void componetDisable() {
        txtARemark.setDisabled(true);
        txtNumberOfEmployee.setDisabled(true);
        drlRequiredJobType.setDisabled(true);
        drlEmployeeMentType.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);
        btnApproved.setDisabled(true);
        btnReject.setDisabled(true);
        txtApprovedBy.setDisabled(true);
        txtBachCode.setDisabled(true);
        txtApprovedNumberofEmployee.setDisabled(true);


    }

    private void componetEnable() {
        txtARemark.setDisabled(false);
        txtNumberOfEmployee.setDisabled(false);
        drlRequiredJobType.setDisabled(false);
        drlEmployeeMentType.setDisabled(false);
        btnReset.setDisabled(false);

    }

    public void btnApproved_processAction(ActionEvent ae) {

        RecruitmentManager approved = new RecruitmentManager(txtBachCode.getValue().toString(), this.getSessionBean1().getEmployeeId(), dateFormat.format((Date) calFromDate.getValue()), txtNumberOfEmployee.getValue().toString(), requesterId, 1);
        if (recruitmentManager.approvedRecruitmentRequests(approved) == 1) {

//            txtConfirmation.setRendered(true);
//            txtConfirmation.setValue("Approved Successfully   ");

            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("Recruitment  Request Successfully Approved ");
            showConformationMsg(getMessage().getStyleClass().toString());

            txtBachCode.setDisabled(true);
            txtApprovedNumberofEmployee.setDisabled(true);
            btnReject.setDisabled(true);
            btnApproved.setDisabled(true);

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error occured while Approve Recruitment Request. Please try again? ");
            showConformationMsg(getMessage().getStyleClass().toString());

//            txtConfirmation.setRendered(true);
//            txtConfirmation.setValue("Error occured while Approve Recruitment Request. Please try again?");
        }
    }

    public String txtSearchByName_action() {
        //return null means stay on the same page
        this.getSessionBean1().setEmployee_id(ApplicationBean1.getSelectedEmployeeId());
        employeeManage.loadEmpoyeeProfile(this.getSessionBean1().getEmployee_id());
        recruitmentList = null;

        recruitmentList = recruitmentManager.readRecruitmentRequestByRequester(this.getSessionBean1().getEmployee_id());
        if (recruitmentList != null) {

            drlRecruitmentRequest.setRendered(true);

        } else {
            drlRecruitmentRequest.setVisible(false);
        }

//        String employeeName = employeeManage.getFirst_Name() + "   " + employeeManage.getMiddle_Name() + "   " + employeeManage.getLast_Name();
//        txtRequester.setValue(employeeName);
        return null;
    }

    public void listboxNewRecruitmentRequests_processValueChange(ValueChangeEvent vce) {
        txtConfirmation.setRendered(false);
        cleareComponets();
        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(vce.getNewValue().toString());
        try {
            if (unApprovedRequest != null) {


                txtRequester.setValue(unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7));
                txtMinQualifcation.setValue(unApprovedRequest.get(9));
                txtAdditionalskill.setValue(unApprovedRequest.get(12));
                txtARemark.setValue(unApprovedRequest.get(14));
                txtMinExperiance.setValue(unApprovedRequest.get(10));
                txtMinResponsiblity.setValue(unApprovedRequest.get(11));
                txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
                drlEmployeeMentType.setValue(unApprovedRequest.get(2));
                drlRequiredJobType.setValue(unApprovedRequest.get(13));
                txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
                requesterId = unApprovedRequest.get(0);
                btnUpdate.setDisabled(true);
                btnUpdate.setDisabled(true);
                txtBachCode.setDisabled(false);
                txtApprovedNumberofEmployee.setDisabled(false);
                btnReject.setDisabled(false);
                btnApproved.setDisabled(false);




            } else {
            }
        } catch (Exception ex) {
        }
    }

    private void cleareComponets() {

        txtWorkingPlace.setValue("");
        txtMinQualifcation.setValue("");
        txtAdditionalskill.setValue("");
        txtARemark.setValue("");
        txtMinExperiance.setValue("");
        txtMinResponsiblity.setValue("");
        txtSalary.setValue("");
        txtRunk.setValue("");
//        txtNumberOfEmployee.setValue("");

        drlEmployeeMentType.setValue("");
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnReset.setDisabled(true);

    }

    public void btnReset_processAction(ActionEvent ae) {
        txtConfirmation.setRendered(false);
        this.cleareComponets();
        this.getRecruitRecuestList().clear();
        componetDisable();
    }

    public void drlRecruitmentRequest_processValueChange(ValueChangeEvent vce) {
        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(vce.getNewValue().toString());
        if (unApprovedRequest != null) {
            String employeeName = unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7);
            txtRequester.setValue(employeeName);
            txtMinQualifcation.setValue(unApprovedRequest.get(9));
            txtAdditionalskill.setValue(unApprovedRequest.get(12));
            txtARemark.setValue(unApprovedRequest.get(14));
            txtMinExperiance.setValue(unApprovedRequest.get(10));
            txtMinResponsiblity.setValue(unApprovedRequest.get(11));
            txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
            drlEmployeeMentType.setValue(unApprovedRequest.get(2));
            drlRequiredJobType.setValue(unApprovedRequest.get(13));
            txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));


        } else {
        }
    }

    public void btnReject_processAction(ActionEvent ae) {
        RecruitmentManager approved = new RecruitmentManager(txtBachCode.getValue().toString(), txtApprovedBy.getValue().toString(), dateFormat.format((Date) calFromDate.getValue()), txtNumberOfEmployee.getValue().toString(), requesterId, 0);
        recruitmentManager.approvedRecruitmentRequests(approved);
        if (recruitmentManager.approvedRecruitmentRequests(approved) == 1) {
            txtConfirmation.setValue("Reject Successfully  ");
        } else {
            txtConfirmation.setValue("Try Again");
        }

    }

    public void updateRecruitmentRequest() {
        int checkUpdate = 0;
        String employeeid = this.getSessionBean1().getEmployeeId();
        if (getApplicationBean1().getSelectedEmployeeId() != null)
        {
            employeeid = getApplicationBean1().getSelectedEmployeeId();
        }
        List itterateTable = this.recruitRecuestList;
        recruitmentManager.setWorkingPlace(txtPlaceWorking.getValue().toString());
        Iterator<RecruitmentManager> ittRecValues = itterateTable.iterator();
        while (ittRecValues.hasNext())
        {
           
            RecruitmentManager singleVal = ittRecValues.next();
            checkUpdate = recruitmentManager.updateRequirementRequest(singleVal, requestID);
        }
        if (checkUpdate == 1) {
            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("Your request has been successfully updated.");
            showConformationMsg(getMessage().getStyleClass().toString());
            this.componetDisable();

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error occured while updating your request.Please try again?");
            showConformationMsg(getMessage().getStyleClass().toString());
        }
    }

    public void btnUpdate_processAction(ActionEvent ae)
    {
        txtConfirmation.setRendered(false);
        if (btnUpdate.getValue().equals("Edit"))
        {
            btnUpdate.setValue("Update");
            this.componetEnable();
        } else {
            this.updateRecruitmentRequest();
        }
    }

    public void btnDelete_processAction(ActionEvent ae)
    {
        txtConfirmation.setRendered(false);
        if (selectedRecruitmentRow == -1) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("You have to select a record from the table!!! .");
            showConformationMsg(getMessage().getStyleClass().toString());
        } else if (recruitRecuestList.isEmpty() == true && selectedRecruitmentRow != -1) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("The Table is Empty!");
            showConformationMsg(getMessage().getStyleClass().toString());

        } else {
            lblRecruitRequestPopUpMsgMain.setValue("Are you shure You want to delete this record?");
            panelPopupRecruitRequest.setRendered(true);
            btnRecruitRequestPopUpNo.setRendered(true);
            btnRecruitRequestPopUpYes.setRendered(true);
        }
    }

    public void txtSearchByName_processValueChange(ValueChangeEvent vce) {
        ArrayList<String> unApprovedRequest = recruitmentManager.readRecuitmentRequest(vce.getNewValue().toString());
        if (unApprovedRequest != null) {

            String employeeName = unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7);
            txtRequester.setValue(employeeName);
            txtMinQualifcation.setValue(unApprovedRequest.get(9));
            txtAdditionalskill.setValue(unApprovedRequest.get(12));
            txtARemark.setValue(unApprovedRequest.get(14));
            txtMinExperiance.setValue(unApprovedRequest.get(10));
            txtMinResponsiblity.setValue(unApprovedRequest.get(11));
            txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
            drlEmployeeMentType.setValue(unApprovedRequest.get(2));
            drlRequiredJobType.setValue(unApprovedRequest.get(13));
            txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
            requesterId = unApprovedRequest.get(0);
            btnUpdate.setDisabled(true);
            btnUpdate.setDisabled(true);
            txtBachCode.setDisabled(false);
            txtApprovedNumberofEmployee.setDisabled(false);
            btnReject.setDisabled(false);
            btnApproved.setDisabled(false);


        } else {
        }
    }

    public void txtSearByName_processValueChange(ValueChangeEvent vce) {
    }

    public String txtSearByName_action() {
        txtConfirmation.setRendered(false);
        cleareComponets();
        employeeId = getApplicationBean1().getSelectedEmployeeId();
        oldRequest = recruitmentManager.readRecruitmentRequestByRequester(getApplicationBean1().getSelectedEmployeeId());
        employeeManage.loadEmpoyeeProfile(ApplicationBean1.getSelectedEmployeeId());
        txtRequester.setValue(employeeManage.getFirst_Name() + " " + employeeManage.getMiddle_Name() + " " + employeeManage.getLast_Name());
        return null;
    }

    public void txtSearByName_processMyEvent(TextChangeEvent tce) {
    }

    public String btnApproved_action() {
        return null;
    }

    public void drlPreviousRequest_processValueChange(ValueChangeEvent vce) {
        txtConfirmation.setRendered(false);
        try {
            if (!drlPreviousRequest.getValue().equals("Previous")) {
                ArrayList<String> unApprovedRequest = recruitmentManager.readRecruitmentRequest(vce.getNewValue().toString());

                txtRequester.setValue(unApprovedRequest.get(5) + "   " + unApprovedRequest.get(6) + "   " + unApprovedRequest.get(7));
                txtMinQualifcation.setValue(unApprovedRequest.get(9));
                txtAdditionalskill.setValue(unApprovedRequest.get(12));
                txtARemark.setValue(unApprovedRequest.get(14));
                txtMinExperiance.setValue(unApprovedRequest.get(10));
                txtMinResponsiblity.setValue(unApprovedRequest.get(11));
                txtNumberOfEmployee.setValue(unApprovedRequest.get(3));
                drlEmployeeMentType.setValue(unApprovedRequest.get(2));
                drlRequiredJobType.setValue(unApprovedRequest.get(13));
                txtApprovedNumberofEmployee.setValue(unApprovedRequest.get(3));
                requesterId = unApprovedRequest.get(0);


                txtBachCode.setDisabled(false);
                txtApprovedNumberofEmployee.setDisabled(false);
                btnUpdate.setDisabled(false);
                btnDelete.setDisabled(false);
            } else {
                cleareComponets();
            }
        } catch (Exception ex) {
            txtConfirmation.setRendered(true);
            txtConfirmation.setValue("Error on loade previous request ");


        }
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
         this.updateRecruitmentRequest();
        return null;
    }

    public void drlEmployeeMentType_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForEmployeeType.setRendered(false);
        txtConfirmation.setRendered(false);
    }

    private void validateNumber(FacesContext context, UIComponent component, Object value) {
        try {
            String patternNumber = "^\\d+$";
            boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (value.toString()));
            if (matchStringText == false) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("salaryValidate"));
            }
        } catch (Exception ex) {
        }
    }

    public void txtNumberOfEmployee_validate(FacesContext context, UIComponent component, Object value) {
        this.validateNumber(context, component, value);
    }

    public void txtApprovedNumberofEmployee_validate(FacesContext context, UIComponent component, Object value) {
        this.validateNumber(context, component, value);
    }

    public String cmdRecruitmentApproval_action() {
        //return null means stay on the same page
        return "RecruitmentApprove";
    }

    public String cmdVacancyNotice_action() {
        //return null means stay on the same page
        return "MaintainAdvertisement";
    }

    public String cmdFilterCandidates_action() {
        //return null means stay on the same page
        return "FilterCandidates";
    }

    public String cmdRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    public String btnAddTable_action() {
        if (!drlEmployeeMentType.getValue().equals("---- Recuitment Type ----")) {
            txtPlaceWorking.setRequired(true);
            txtPlaceWorking.setRequiredMessage("Requred");
            String employeeid = this.getSessionBean1().getEmployeeId();
            String requiredJobType=drlRequiredJobType.getValue().toString();
             RecruitmentManager recruitmentRequest = new RecruitmentManager(
                    employeeid,
                    today,
                    drlRequiredJobType.getValue().toString().split("--")[0],
                    txtNumberOfEmployee.getValue().toString(),
                    drlEmployeeMentType.getValue().toString(),
                    txtARemark.getValue().toString(),
                    this.txtMinQualifcation.getValue().toString(),
                    this.txtMinExperiance.getValue().toString(),
                    this.txtMinResponsiblity.getValue().toString(),
                    this.txtAdditionalskill.getValue().toString(),
                    txtPlaceWorking.getValue().toString().split("==")[0]);
            this.recruitRecuestList.add(recruitmentRequest);
        } else {
            lblErrorMessageForEmployeeType.setRendered(true);
            lblErrorMessageForEmployeeType.setValue("Requred");
        }

        return null;
    }

    public void rowSelectorRecruitmentRequest_processMyEvent(RowSelectorEvent rse) {
        selectedRecruitmentRow = rse.getRow();
    }

    public String btnAddSearchRecHist_action() {
        this.selectedSelectOneMenuRow = 0;
        this.requestsUsingDate = recruitmentManager.selectRecruitmentRequestsUsingDate(this.inputTextSearchHist.getValue().toString(), this.inputTextSearchHistTo.getValue().toString(), this.getSessionBean1().getEmployeeId());
        return null;
    }

    public String btnAddSearchRecHistAll_action() {
        this.selectedSelectOneMenuRow = 1;
        this.requestsUsingDate = recruitmentManager.selectRecruitmentRequests();
        return null;
    }

    public int calculateEmpServiceDays(String currentDate, String terminateDate) {
        int serviceInDays = 0;
        if (terminateDate.length() >= 1) {
            serviceInDays = StringDateManipulation.compareDateDifference(currentDate, terminateDate);
            return serviceInDays;
        } else {
        }

        return serviceInDays;
    }

    public void inputTextSearchHist_validate(FacesContext context, UIComponent component, Object value) {
//        dateValidator(context, component, value);
//        String currDate = StringDateManipulation.toDayInEc();
//        int dateDefference = this.calculateEmpServiceDays(currDate, this.inputTextSearchHist.getValue().toString());
//        if (dateDefference < 0) {
//            ((UIInput) component).setValid(false);
//            error(component, ("Invalid Date"));
//        }
    }

    public void inputTextSearchHistTo_validate(FacesContext context, UIComponent component, Object value) {
//        dateValidator(context, component, value);
//        String currDate = StringDateManipulation.toDayInEc();
//        int dateDefference = this.calculateEmpServiceDays(currDate, this.inputTextSearchHistTo.getValue().toString());
//        if (dateDefference < 0) {
//            ((UIInput) component).setValid(false);
//            error(component, ("Invalid Date"));
//        }
    }

    public void selectOneListboxRecHist_processValueChange(ValueChangeEvent vce)
    {
      //  this.recruitRecuestList.clear();
        ArrayList<RecruitmentManager> addToTableNew=new ArrayList<RecruitmentManager>();
        this.btnDelete.setDisabled(false);
        int deptID=0;
        try {
            requestID=vce.getNewValue().toString();
           
             addToTableNew=recruitmentManager.readSingleRecRequestNewTest(vce.getNewValue().toString());
             
            if(addToTableNew.size()>0)
            {
             
             txtPlaceWorking.setValue(addToTableNew.get(0).getWorkingPlace());
             drlRequiredJobType.setValue(addToTableNew.get(0).getJobCode());
             txtRunk.setValue(addToTableNew.get(0).getRunk());
             txtMinQualifcation.setValue(addToTableNew.get(0).getMinQual());
             txtMinResponsiblity.setValue(addToTableNew.get(0).getAddSkill());
             txtSalary.setValue(addToTableNew.get(0).getSalary());
             txtMinExperiance.setValue(addToTableNew.get(0).getMinExp());
             txtAdditionalskill.setValue(addToTableNew.get(0).getAddSkill());
             drlEmployeeMentType.setValue(addToTableNew.get(0).getRequirementType());
             txtARemark.setValue(addToTableNew.get(0).getRemark());
             this.approveStatus=addToTableNew.get(0).getApproved();
             this.rejectStatus=addToTableNew.get(0).getReject();
              String [] department=txtPlaceWorking.getValue().toString().split("==");
              deptID=Integer.parseInt(department[0]);
            if(Integer.parseInt(this.approveStatus)==1)
             {
             lblFormMessage.setStyleClass("error");
             lblFormMessage.setValue("The Recoured Is Alrady Approved You can't Update or Delete!!!");
             showConformationMsg(getMessage().getStyleClass().toString());
             this.disableComponents();
             }
             else if (Integer.parseInt(this.approveStatus)==0||Integer.parseInt(this.rejectStatus)==0)
                  {
               if (deptID != 0)
            {
                enableComponents();
                 setReadJob(departmentManager.readJobCodeOption(String.valueOf(deptID)));
//                this.setPerofation(departmentManage.readJobCode(String.valueOf(departmentId)));
            } else {
                this.setReadJob(departmentManage.onDisplayJobs());
            }
              this.btnUpdate.setDisabled(false);

             }
         
            }
        

        } catch (Exception ex) {
            ex.getMessage();
        }
    }

    public String btnEdit_action()
    {

        enableComponents();

        return null;
    }

    public String btnRecruitRequestPopUpNo_action() {
        panelPopupRecruitRequest.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnRecruitRequestPopUpYes_action() {
        panelPopupRecruitRequest.setRendered(false);
        int chekDelete = 0;
        chekDelete = recruitmentManager.deleteRequirementRequest(requestID);
        if (chekDelete == 1)
        {
         
            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("The Request Successfully Deleted .");
            showConformationMsg(getMessage().getStyleClass().toString());
            cleareComponets();
            componetDisable();
        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("The Request Not Deleted.Please try agin?");
            showConformationMsg(getMessage().getStyleClass().toString());
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAdvertise_action() {
        if (this.selectedRecruitmentRow == -1) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("You have to select a record from the table!!!");
            showConformationMsg(getMessage().getStyleClass().toString());
        } else if (recruitRecuestList.isEmpty() == true && selectedRecruitmentRow != -1) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("The Table is Empty!");
            showConformationMsg(getMessage().getStyleClass().toString());
        } else {

            return "MaintainAdvertisement";
        }

        //return null means stay on the same page
        return null;
    }

    public String btnCalenderRecF_action() {
        currenTDateToSet = "fromDate";
        calFromDate.setRendered(true);
        return null;
    }

    public void calFromDate_processValueChange(ValueChangeEvent vce) {

        String selectedDate = dateFormat.format((Date) calFromDate.getValue());
        //txtLeaveStartDate.setValue(dateFormat.format(calLeaveStartDate.getValue()));

        if (currenTDateToSet.equalsIgnoreCase("fromDate")) {
            //inputTextSearchHist.setValue(dateFormat.format(calFromDate.getValue()));
            inputTextSearchHist.setValue(dateFormat.format(calFromDate.getValue()));

        } else if (currenTDateToSet.equalsIgnoreCase("toDate")) {
            inputTextSearchHistTo.setValue(dateFormat.format(calFromDate.getValue()));

        //inputTextSearchHistTo.setValue(selectedDate);
        }
        calFromDate.setRendered(false);
    }

    public String btnCalenderRecTo_action() {
        currenTDateToSet = "toDate";
        calFromDate.setRendered(true);
        return null;
    }

    public void button1_processAction(ActionEvent ae) {
    }

    public void cmdLnkTree_processAction(ActionEvent ae)
    {
        String departmentName;
        int departmentId;
        String department = treeOrgStructure.getCurrentNode().toString();//.substring(0, 2);
        String _department[] = department.split("#");
        if (_department.length > 1) {
            departmentName = _department[0];
            departmentId = Integer.parseInt(_department[1].trim());
            txtPlaceWorking.setValue(departmentId + "==" + departmentName);
            if (departmentId != 0)
            {
                setReadJob(departmentManager.readJobCodeOption(String.valueOf(departmentId)));
//                this.setPerofation(departmentManage.readJobCode(String.valueOf(departmentId)));
            } else {
                this.setReadJob(departmentManage.onDisplayJobs());
            }
            pnlLayoutTree.setRendered(false);
        }
    }

    public String button1_action() {
        LoadTree loadTree = new LoadTree();
        treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        // treeModel.setModel(OrganizationTreePage.getTreeModel());
        pnlLayoutTree.setRendered(true);
        return null;
    }

    public String cmdExamQuestions_action() {
        //return null means stay on the same page
        return "FilterCandidateForExam";
    }

    public String btnTree_action() {
        LoadTree loadTree = new LoadTree();
        treeModel.setModel(new DefaultTreeModel(loadTree.populateNodes()));
        pnlLayoutTree.setRendered(true);


        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
  
          if(Integer.parseInt(this.approveStatus)==1)
             {
             lblFormMessage.setStyleClass("error");
             lblFormMessage.setValue("The Recoured Is Alrady Approved You can't Delete it!!!");
             showConformationMsg(getMessage().getStyleClass().toString());
             this.disableComponents();
             }
             else if (Integer.parseInt(this.approveStatus)==0||Integer.parseInt(this.rejectStatus)==0)
                  {
            lblRecruitRequestPopUpMsgMain.setValue("Are you shure You want to delete this record?");
            panelPopupRecruitRequest.setRendered(true);
            btnRecruitRequestPopUpNo.setRendered(true);
            btnRecruitRequestPopUpYes.setRendered(true);

                 }
         return null;
    }
}

