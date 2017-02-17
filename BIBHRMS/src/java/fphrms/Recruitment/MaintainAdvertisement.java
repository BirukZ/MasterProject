/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Recruitment;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;

import manager.departmentManage.DepartmentManage;
import manager.employeeManager.EmployeeManage;
import manager.recruitmentManager.AdvertisementManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class MaintainAdvertisement extends AbstractPageBean {

    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //this.lodeAAdvertisement();
    }
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
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
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }

    // </editor-fold>
    AdvertisementManager advertisementManager = new AdvertisementManager();
    private RowSelector rowSelectorAdvertisment = new RowSelector();
    public List mediaTypeList = new ArrayList<AdvertisementManager>();
    List listOfJobType = new ArrayList<AdvertisementManager>();
    public List UpdatemediaTypeList = new ArrayList<AdvertisementManager>();
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();
    EmployeeManage employeeManage = new EmployeeManage();
    Option[] number = advertisementManager.getNumber();
    Option[] mediType = advertisementManager.mediaType();
    String empId;
    Option[] recruitmentBatchCodeSearchOpt = null;
    int selectedAdvertismentRow = -1;
    DepartmentManage departmentManage = new DepartmentManage();
    static String bachcode;
    static String advertisementID = null;
    int selectedMediRow = -1;
    int buttonIdentifier = 0;
    int mediTableSize = 0;
    int mediID = 1;
    boolean deleteVacancy = false;
    Option[] previousRecruitmentAdvertise = null;
    boolean updateData = false;
    int countAddMedi = 0;
    String currenTDateToSet = "fromDate";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    String today = dateFormat.format(new Date());

    public static String getAdvertisementID() {
        return advertisementID;
    }

    public static void setAdvertisementID(String advertisementID) {
        MaintainAdvertisement.advertisementID = advertisementID;
    }

    public List getUpdatemediaTypeList() {
        return UpdatemediaTypeList;
    }

    public void setUpdatemediaTypeList(List UpdatemediaTypeList) {
        this.UpdatemediaTypeList = UpdatemediaTypeList;
    }

    public Option[] getRecruitmentBatchCodeSearchOpt() {
        recruitmentBatchCodeSearchOpt = advertisementManager.recruitmentBatchCodeApp();
        return recruitmentBatchCodeSearchOpt;
    }

    public void setRecruitmentBatchCodeSearchOpt(Option[] recruitmentBatchCodeSearchOpt) {
        this.recruitmentBatchCodeSearchOpt = recruitmentBatchCodeSearchOpt;
    }

    public Option[] getPreviousRecruitmentAdvertise() {
        previousRecruitmentAdvertise = advertisementManager.previouesAdvertisment();
        return previousRecruitmentAdvertise;
    }

    public void setPreviousRecruitmentAdvertise(Option[] previousRecruitmentAdvertise) {
        this.previousRecruitmentAdvertise = previousRecruitmentAdvertise;
    }

    public static String getBachcode() {
        return bachcode;
    }

    public static void setBachcode(String bachcode) {
        MaintainAdvertisement.bachcode = bachcode;
    }

    public List getMediaTypeList() {
        return mediaTypeList;
    }

    public void setMediaTypeList(List mediaTypeList) {
        this.mediaTypeList = mediaTypeList;
    }

    public List getListOfJobType() {
        return listOfJobType;
    }

    public void setListOfJobType(List listOfJobType) {
        this.listOfJobType = listOfJobType;
    }

    public Option[] getMediType() {
        return mediType;
    }

    public void setMediType(Option[] mediType) {
        this.mediType = mediType;
    }

    public Option[] getNumber() {
        return number;
    }

    public void setNumber(Option[] number) {
        this.number = number;
    }
    private HtmlSelectOneMenu drlMediType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlMediType() {
        return drlMediType;
    }

    public void setDrlMediType(HtmlSelectOneMenu hsom) {
        this.drlMediType = hsom;
    }
    private HtmlSelectOneMenu drlOccurrence = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlOccurrence() {
        return drlOccurrence;
    }

    public void setDrlOccurrence(HtmlSelectOneMenu hsom) {
        this.drlOccurrence = hsom;
    }

    private HtmlOutputText lblErrorMessageForMediaType = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForMediaType() {
        return lblErrorMessageForMediaType;
    }

    public void setLblErrorMessageForMediaType(HtmlOutputText hot) {
        this.lblErrorMessageForMediaType = hot;
    }
    private HtmlOutputText lblErrorMessageForOccurrence = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForOccurrence() {
        return lblErrorMessageForOccurrence;
    }

    public void setLblErrorMessageForOccurrence(HtmlOutputText hot) {
        this.lblErrorMessageForOccurrence = hot;
    }
    private HtmlInputText txtBachCode = new HtmlInputText();

    public HtmlInputText getTxtBachCode() {
        return txtBachCode;
    }

    public void setTxtBachCode(HtmlInputText hit) {
        this.txtBachCode = hit;
    }
    private HtmlInputText txtRequestedBy1 = new HtmlInputText();

    public HtmlInputText getTxtRequestedBy1() {
        return txtRequestedBy1;
    }

    public void setTxtRequestedBy1(HtmlInputText hit) {
        this.txtRequestedBy1 = hit;
    }
    private HtmlInputText txtBachCode1 = new HtmlInputText();

    public HtmlInputText getTxtBachCode1() {
        return txtBachCode1;
    }

    public void setTxtBachCode1(HtmlInputText hit) {
        this.txtBachCode1 = hit;
    }
    private HtmlInputText txtRequestedDate = new HtmlInputText();

    public HtmlInputText getTxtRequestedDate() {
        return txtRequestedDate;
    }

    public void setTxtRequestedDate(HtmlInputText hit) {
        this.txtRequestedDate = hit;
    }
    private HtmlInputText txtApprovedBy = new HtmlInputText();

    public HtmlInputText getTxtApprovedBy() {
        return txtApprovedBy;
    }

    public void setTxtApprovedBy(HtmlInputText hit) {
        this.txtApprovedBy = hit;
    }
    private HtmlInputText txtApprovedDate = new HtmlInputText();

    public HtmlInputText getTxtApprovedDate() {
        return txtApprovedDate;
    }

    public void setTxtApprovedDate(HtmlInputText hit) {
        this.txtApprovedDate = hit;
    }
    private HtmlInputText txtPreparedDate = new HtmlInputText();

    public HtmlInputText getTxtPreparedDate() {
        return txtPreparedDate;
    }

    public void setTxtPreparedDate(HtmlInputText hit) {
        this.txtPreparedDate = hit;
    }
    private HtmlInputText txtAdvertDateTO = new HtmlInputText();

    public HtmlInputText getTxtAdvertDateTO() {
        return txtAdvertDateTO;
    }

    public void setTxtAdvertDateTO(HtmlInputText hit) {
        this.txtAdvertDateTO = hit;
    }
    private HtmlInputText txtPreparedBy = new HtmlInputText();

    public HtmlInputText getTxtPreparedBy() {
        return txtPreparedBy;
    }

    public void setTxtPreparedBy(HtmlInputText hit) {
        this.txtPreparedBy = hit;
    }
    private HtmlInputText txtAdvertDate_From = new HtmlInputText();

    public HtmlInputText getTxtAdvertDate_From() {
        return txtAdvertDate_From;
    }

    public void setTxtAdvertDate_From(HtmlInputText hit) {
        this.txtAdvertDate_From = hit;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlCommandButton btnNew = new HtmlCommandButton();

    public HtmlCommandButton getBtnNew() {
        return btnNew;
    }

    public void setBtnNew(HtmlCommandButton hcb) {
        this.btnNew = hcb;
    }
    private HtmlCommandButton btnRest = new HtmlCommandButton();

    public HtmlCommandButton getBtnRest() {
        return btnRest;
    }

    public void setBtnRest(HtmlCommandButton hcb) {
        this.btnRest = hcb;
    }
    private HtmlCommandButton btnDelete = new HtmlCommandButton();

    public HtmlCommandButton getBtnDelete() {
        return btnDelete;
    }

    public void setBtnDelete(HtmlCommandButton hcb) {
        this.btnDelete = hcb;
    }
    private HtmlCommandLink cmdEdit = new HtmlCommandLink();

    public HtmlCommandLink getCmdEdit() {
        return cmdEdit;
    }

    public void setCmdEdit(HtmlCommandLink hcl) {
        this.cmdEdit = hcl;
    }
    private HtmlCommandButton btnEdit = new HtmlCommandButton();

    public HtmlCommandButton getBtnEdit() {
        return btnEdit;
    }

    public void setBtnEdit(HtmlCommandButton hcb) {
        this.btnEdit = hcb;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private HtmlSelectOneMenu drlNewRecruitmentApproval = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNewRecruitmentApproval() {
        return drlNewRecruitmentApproval;
    }

    public void setDrlNewRecruitmentApproval(HtmlSelectOneMenu hsom) {
        this.drlNewRecruitmentApproval = hsom;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlOutputText lblReqesterDepartemnt = new HtmlOutputText();

    public HtmlOutputText getLblReqesterDepartemnt() {
        return lblReqesterDepartemnt;
    }

    public void setLblReqesterDepartemnt(HtmlOutputText hot) {
        this.lblReqesterDepartemnt = hot;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private PanelPopup popupRequestDetail = new PanelPopup();

    public PanelPopup getPopupRequestDetail() {
        return popupRequestDetail;
    }

    public void setPopupRequestDetail(PanelPopup pp) {
        this.popupRequestDetail = pp;
    }

    public RowSelector getRowSelectorAdvertisment() {
        return rowSelectorAdvertisment;
    }

    public void setRowSelectorAdvertisment(RowSelector rs) {
        this.rowSelectorAdvertisment = rs;
    }
    private HtmlDataTable tblRequritmentList = new HtmlDataTable();

    public HtmlDataTable getTblRequritmentList() {
        return tblRequritmentList;
    }

    public void setTblRequritmentList(HtmlDataTable hdt) {
        this.tblRequritmentList = hdt;
    }
    private HtmlInputText txtJobTypeDes = new HtmlInputText();

    public HtmlInputText getTxtJobTypeDes() {
        return txtJobTypeDes;
    }

    public void setTxtJobTypeDes(HtmlInputText hit) {
        this.txtJobTypeDes = hit;
    }
    private HtmlInputText txtNumberOfEmployeeDes = new HtmlInputText();

    public HtmlInputText getTxtNumberOfEmployeeDes() {
        return txtNumberOfEmployeeDes;
    }

    public void setTxtNumberOfEmployeeDes(HtmlInputText hit) {
        this.txtNumberOfEmployeeDes = hit;
    }
    private HtmlInputText txtRecruitmentTypeDes = new HtmlInputText();

    public HtmlInputText getTxtRecruitmentTypeDes() {
        return txtRecruitmentTypeDes;
    }

    public void setTxtRecruitmentTypeDes(HtmlInputText hit) {
        this.txtRecruitmentTypeDes = hit;
    }
   
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlDataTable tblMediaInformation = new HtmlDataTable();

    public HtmlDataTable getTblMediaInformation() {
        return tblMediaInformation;
    }

    public void setTblMediaInformation(HtmlDataTable hdt) {
        this.tblMediaInformation = hdt;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private HtmlSelectBooleanCheckbox choMediInformation = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoMediInformation() {
        return choMediInformation;
    }

    public void setChoMediInformation(HtmlSelectBooleanCheckbox hsbc) {
        this.choMediInformation = hsbc;
    }
    private PanelPopup pnConfirmationMessage = new PanelPopup();

    public PanelPopup getPnConfirmationMessage() {
        return pnConfirmationMessage;
    }

    public void setPnConfirmationMessage(PanelPopup pp) {
        this.pnConfirmationMessage = pp;
    }
    private PanelLayout pnlConfirmationMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationMessageBody() {
        return pnlConfirmationMessageBody;
    }

    public void setPnlConfirmationMessageBody(PanelLayout pl) {
        this.pnlConfirmationMessageBody = pl;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage4 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage4() {
        return lblFormMessage4;
    }

    public void setLblFormMessage4(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage4 = hol;
    }
    private PanelLayout pnlConfirmationDleteMessageBody = new PanelLayout();

    public PanelLayout getPnlConfirmationDleteMessageBody() {
        return pnlConfirmationDleteMessageBody;
    }

    public void setPnlConfirmationDleteMessageBody(PanelLayout pl) {
        this.pnlConfirmationDleteMessageBody = pl;
    }
    private PanelPopup pnRequestConfirmationDleteMessage = new PanelPopup();

    public PanelPopup getPnRequestConfirmationDleteMessage() {
        return pnRequestConfirmationDleteMessage;
    }

    public void setPnRequestConfirmationDleteMessage(PanelPopup pp) {
        this.pnRequestConfirmationDleteMessage = pp;
    }
    private javax.faces.component.html.HtmlOutputLabel lblFormMessage45 = new javax.faces.component.html.HtmlOutputLabel();

    public javax.faces.component.html.HtmlOutputLabel getLblFormMessage45() {
        return lblFormMessage45;
    }

    public void setLblFormMessage45(javax.faces.component.html.HtmlOutputLabel hol) {
        this.lblFormMessage45 = hol;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox2Bean() {
        return selectBooleanCheckbox2Bean;
    }

    public void setSelectBooleanCheckbox2Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox2Bean = dsd;
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
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectedData selectBooleanCheckbox3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox3Bean() {
        return selectBooleanCheckbox3Bean;
    }

    public void setSelectBooleanCheckbox3Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox3Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox choOutsideAdvertise = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOutsideAdvertise() {
        return choOutsideAdvertise;
    }

    public void setChoOutsideAdvertise(HtmlSelectBooleanCheckbox hsbc) {
        this.choOutsideAdvertise = hsbc;
    }
    private HtmlSelectBooleanCheckbox choJobToAdvertise = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoJobToAdvertise() {
        return choJobToAdvertise;
    }

    public void setChoJobToAdvertise(HtmlSelectBooleanCheckbox hsbc) {
        this.choJobToAdvertise = hsbc;
    }
    private HtmlSelectBooleanCheckbox choInsideAdvertise = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoInsideAdvertise() {
        return choInsideAdvertise;
    }

    public void setChoInsideAdvertise(HtmlSelectBooleanCheckbox hsbc) {
        this.choInsideAdvertise = hsbc;
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
    private HtmlSelectOneListbox listPreviousAdvertisement = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getListPreviousAdvertisement() {
        return listPreviousAdvertisement;
    }

    public void setListPreviousAdvertisement(HtmlSelectOneListbox hsol) {
        this.listPreviousAdvertisement = hsol;
    }
    private HtmlCommandLink cmdPreview = new HtmlCommandLink();

    public HtmlCommandLink getCmdPreview() {
        return cmdPreview;
    }

    public void setCmdPreview(HtmlCommandLink hcl) {
        this.cmdPreview = hcl;
    }
    private HtmlSelectBooleanCheckbox choInside = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoInside() {
        return choInside;
    }

    public void setChoInside(HtmlSelectBooleanCheckbox hsbc) {
        this.choInside = hsbc;
    }
    private HtmlSelectBooleanCheckbox choOutside = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChoOutside() {
        return choOutside;
    }

    public void setChoOutside(HtmlSelectBooleanCheckbox hsbc) {
        this.choOutside = hsbc;
    }
    private HtmlCommandButton btnCalender = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalender() {
        return btnCalender;
    }

    public void setBtnCalender(HtmlCommandButton hcb) {
        this.btnCalender = hcb;
    }
    private HtmlCommandButton btnCalenderTO = new HtmlCommandButton();

    public HtmlCommandButton getBtnCalenderTO() {
        return btnCalenderTO;
    }

    public void setBtnCalenderTO(HtmlCommandButton hcb) {
        this.btnCalenderTO = hcb;
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
    private HtmlInputText txtMediName = new HtmlInputText();

    public HtmlInputText getTxtMediName() {
        return txtMediName;
    }

    public void setTxtMediName(HtmlInputText hit) {
        this.txtMediName = hit;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public MaintainAdvertisement() {
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

        this.getMediaTypeList().clear();
        this.disableComponets();
        mediTableSize = 0;
        btnAdd.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnRest.setDisabled(true);
        btnDelete.setDisabled(true);
        btnNew.setDisabled(true);
        choJobToAdvertise.setDisabled(true);

        txtPreparedBy.setValue(this.getSessionBean1().getEmployeeName());
         txtPreparedDate.setValue(dateFormat.format(new Date()));
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
        txtAdvertDate_From.setRequired(true);
        txtAdvertDateTO.setRequired(true);
//        txtAdvertDate_From.setRequiredMessage("Requred");
//        txtAdvertDateTO.setRequiredMessage("Requred");
        if (!isPostBack()) {
            empId = this.getSessionBean1().getEmployeeId();
            txtPreparedBy.setValue(getSessionBean1().getEmployeeName());
        }




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

    public String btnAdd_action() {
        String occurrence = null;
        String mediaType = null;
        String mediaID = null;
        String mediaName=null;
        String occurrenceID = null;
        lblErrorMessageForMediaType.setRendered(false);
        if (!drlMediType.getValue().equals("Select Media Type")) {
            if (!drlOccurrence.getValue().equals("Occurrence")) {
                String media_ID = null;
                mediaID = drlMediType.getValue().toString();
                occurrenceID = drlOccurrence.getValue().toString();
                mediaName=txtMediName.getValue().toString();
                Option[] readJobOpt = this.getMediType();
                int selectedRow = readJobOpt.length;
                media_ID = this.drlMediType.getValue().toString();
                for (int i = 0; i < readJobOpt.length; i++) {
                    if (this.drlMediType.getValue().toString().equalsIgnoreCase(readJobOpt[i].getValue().toString())) {
                        selectedRow = i;
                    }
                }
                mediaType = readJobOpt[selectedRow].getLabel();
                Option[] readoccurrenceOpt = this.getNumber();
                selectedRow = readoccurrenceOpt.length;
                mediaID = this.drlOccurrence.getValue().toString();
                for (int i = 0; i < readoccurrenceOpt.length; i++) {
                    if (this.drlOccurrence.getValue().toString().equalsIgnoreCase(readoccurrenceOpt[i].getValue().toString())) {
                        selectedRow = i;
                    }
                }
                occurrence = readoccurrenceOpt[selectedRow].getLabel();
                if (buttonIdentifier == 0) {
                    AdvertisementManager advertisementManager = new AdvertisementManager(
                            occurrenceID,
                            media_ID,
                            occurrence,
                            mediaType,
                            1,
                            mediaName);
                    this.getMediaTypeList().add(advertisementManager);
                    countAddMedi += 1;
                } else if (buttonIdentifier == 3) {
                    AdvertisementManager advertisementManager = new AdvertisementManager(occurrenceID, media_ID, occurrence, mediaType, mediID,mediaName);
                    this.mediaTypeList.add(this.selectedMediRow, advertisementManager);
                    this.UpdatemediaTypeList.add(advertisementManager);
                    this.btnEdit.setDisabled(false);
                    this.btnUpdate.setDisabled(false);
                    btnDelete.setDisabled(false);
                    btnAdd.setDisabled(true);
                    mediID = 1;

                }


            } else {
                lblErrorMessageForOccurrence.setValue("Requred");
                lblErrorMessageForOccurrence.setRendered(true);
            }
        } else {
            lblErrorMessageForMediaType.setValue("Requred");
            lblErrorMessageForMediaType.setRendered(true);

        }
        //return null means stay on the same page
        return null;
    }

    void lodeAAdvertisement() {

        ArrayList<String> adert = advertisementManager.lodeRecruitment();
        try {
            if (adert != null) {
                txtBachCode.setValue(adert.get(0).toString());
                txtRequestedBy1.setValue(adert.get(1));
                //  txtRequestedDate2.setValue(adert.get(2));
                txtApprovedBy.setValue(adert.get(3));
                txtApprovedDate.setValue(adert.get(4));
                //  txtApprovedDate1.setValue(adert.get(5));
                ArrayList<String> name = advertisementManager.readRequesterName(adert.get(6));
                txtRequestedDate.setValue(name.get(0) + "  " + name.get(1) + "   " + name.get(2));
                txtBachCode1.setValue(name.get(3));
                name = advertisementManager.readApprovedBy(adert.get(7));
                // txtApprovedBy2.setValue(name.get(0) + "  " + name.get(1) + "   " + name.get(2));
                txtPreparedDate.setValue(dateFormat.format(new Date()));

                txtPreparedBy.setValue(this.getSessionBean1().getEmployeeName());
            // cmdSave.setDisabled(false);
            } else {
                //   txtPreparedBy.setValue(this.getSessionBean1().getEmployeeName());
                //   cmdSave.setDisabled(true);
                txtPreparedDate.setValue(dateFormat.format(new Date()));
            }
        } catch (Exception ex) {
        }


    }

    public void drlNewRecruitmentApproval_processValueChange(ValueChangeEvent vce) {
        mediTableSize = 0;
      if (vce.getNewValue() != null) {
            this.getListOfJobType().clear();
            clearComponets();
            getMediaTypeList().clear();
            HashMap[] approvedList = advertisementManager.readApprovedRequests(vce.getNewValue().toString());
            bachcode = vce.getNewValue().toString();
            for (int i = 0; i < advertisementManager.countRequest(); i++) {
                AdvertisementManager addTOtable = new AdvertisementManager(
                        approvedList[i].get("approved_By").toString(),
                        approvedList[i].get("Batch_Code").toString(),
                        approvedList[i].get("JOB_NAME").toString(),
                        approvedList[i].get("recruit_Request_Date").toString(),
                        approvedList[i].get("first_name").toString() + " " + approvedList[i].get("middle_name").toString() + " " + approvedList[i].get("last_name").toString(),
                        approvedList[i].get("type").toString(),
                        approvedList[i].get("num_Of_Emps").toString(),
                        approvedList[i].get("approved_Date").toString(), "", "", "", "", "",
                        approvedList[i].get("recruit_Request_Id").toString(),
                        approvedList[i].get("recruit_Request_Date").toString(),
                        approvedList[i].get("requesterName").toString() + " " + approvedList[i].get("requesterMiddleName").toString() + " " + approvedList[i].get("requesterLastName").toString(),
                        approvedList[i].get("REQUESTER_ID").toString(),
                        Integer.parseInt(approvedList[i].get("number").toString()),
                        false,
                        "unknown");
                this.getListOfJobType().add(addTOtable);
            }
            choJobToAdvertise.setDisabled(false);
            btnAdd.setDisabled(true);
            btnSave.setDisabled(true);
            btnEdit.setDisabled(true);
            btnUpdate.setDisabled(true);
            btnRest.setDisabled(true);
            btnDelete.setDisabled(true);
            btnNew.setDisabled(false);
            updateData = false;
            choInside.setDisabled(false);
            choOutside.setDisabled(false);
        }
    }

    private void disableComponets() {
        txtPreparedBy.setDisabled(true);
        txtAdvertDate_From.setDisabled(true);
        txtPreparedDate.setDisabled(true);
        txtAdvertDateTO.setDisabled(true);
        txtMediName.setDisabled(true);
        drlMediType.setDisabled(true);
        drlOccurrence.setDisabled(true);
        btnCalender.setDisabled(true);
        btnCalenderTO.setDisabled(true);
    }

    private void clearComponets() {
        txtAdvertDate_From.setValue("");
        txtAdvertDateTO.setValue("");
        drlMediType.setValue("");
        drlOccurrence.setValue("");
        txtMediName.setValue("");

    }

    private void clearRequestComponets() {
        txtBachCode.setValue("");
        txtRequestedBy1.setValue("");
        txtApprovedBy.setValue("");
        txtApprovedDate.setValue("");
    // txtApprovedDate1.setValue("");
    }

    private void enableComponets() {
        txtAdvertDate_From.setDisabled(false);
        txtAdvertDateTO.setDisabled(false);
        txtMediName.setDisabled(false);
        drlMediType.setDisabled(false);
        drlOccurrence.setDisabled(false);
        btnCalender.setDisabled(false);
        btnCalenderTO.setDisabled(false);
    }

    public String btnNew_action() {
        buttonIdentifier = 0;
        btnAdd.setDisabled(false);
        btnSave.setDisabled(false);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnRest.setDisabled(false);
        btnDelete.setDisabled(true);
        btnNew.setDisabled(true);
        choInside.setDisabled(false);
        choOutside.setDisabled(false);
        if (updateData) {
            drlMediType.setDisabled(false);
            drlOccurrence.setDisabled(false);
            drlMediType.setValue("");
            drlOccurrence.setValue("");
            choMediInformation.setDisabled(true);
        } else {
            this.clearComponets();
            this.enableComponets();

        }

        //return null means stay on the same page
        return null;
    }

    public String btnRest_action() {
        this.clearComponets();
        this.disableComponets();
        this.getMediaTypeList().clear();
        clearRequestComponets();
        btnAdd.setDisabled(true);
        btnSave.setDisabled(true);
        btnEdit.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnRest.setDisabled(true);
        btnDelete.setDisabled(true);
        btnNew.setDisabled(false);
        choMediInformation.setDisabled(false);
        //return null means stay on the same page
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        popupRequestDetail.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    private void dispalyDetaileAboutRequest() {

        if (this.selectedAdvertismentRow != -1 && this.listOfJobType.isEmpty() == true) {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("The Table is Empty!");
        //   showConformationMsg(getMessage().getStyleClass().toString());

        } else {

            AdvertisementManager recruitemntList = (AdvertisementManager) this.listOfJobType.get(this.selectedAdvertismentRow);
            txtBachCode1.setValue(recruitemntList.getBatchCode());
            txtRequestedBy1.setValue(recruitemntList.getRequesterName());
            txtRequestedDate.setValue(recruitemntList.getRecruitRequestDate());
            txtApprovedBy.setValue(recruitemntList.getEmployeeName());
            txtApprovedDate.setValue(recruitemntList.getApproved_Date());
            txtJobTypeDes.setValue(recruitemntList.getJob_description());
            txtRecruitmentTypeDes.setValue(recruitemntList.getRecruitment_Type());
            txtNumberOfEmployeeDes.setValue(recruitemntList.getNum_Of_Emps());
            if (!recruitemntList.getDepartmentID().equals("0")) {
                if (!recruitemntList.getDirectorate().equals("DIRECTORATE")) {
                    if (!recruitemntList.getDivision().equals("DIVISION")) {
                        if (!recruitemntList.getMastebabriya().equals("MASTEBABRIYA")) {
                            if (!recruitemntList.getTeam().equals("TEAM")) {
                                lblReqesterDepartemnt.setValue(departmentManage.traceDepartemnt(recruitemntList.getTeam()));
                            } else {

                                lblReqesterDepartemnt.setValue(departmentManage.traceDepartemnt(recruitemntList.getMastebabriya()));
                            }

                        } else {

                            lblReqesterDepartemnt.setValue(departmentManage.traceDepartemnt(recruitemntList.getDivision()));
                        }
                    } else {

                        lblReqesterDepartemnt.setValue("" + departmentManage.traceDepartemnt(recruitemntList.getDirectorate()));
                    }
                } else {
                    lblReqesterDepartemnt.setValue("" + departmentManage.traceDepartemnt(recruitemntList.getDepartmentID()));


                }

            }

//          this.familyInformation.remove(this.selectedFamilyRow);
//
//            txtFamilyFirstName.setValue(employeeFamily.getFamily_FirstName());
        }
        popupRequestDetail.setRendered(true);

    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    private ArrayList<HashMap> recruitemntInformation() {
        try {


            ArrayList<HashMap> recruitemntList = new ArrayList<HashMap>();
            if (tblRequritmentList.getRowCount() > 0) {
                List recruitemntInformationList = this.getListOfJobType();
                Iterator<AdvertisementManager> iter = recruitemntInformationList.iterator();
                while (iter.hasNext()) {
                    AdvertisementManager iterate = iter.next();
                    HashMap _list = new HashMap();
                    _list.put("recruitRequestId", iterate.getRecruitRequestId());
                    recruitemntList.add(_list);
                }
            }
            return recruitemntList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private HashMap adverAndBachCode() {
        try {
            HashMap hm = new HashMap();
            hm.put("bachcode", getBachcode());
            hm.put("advertisementID", getAdvertisementID());
            return hm;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    private ArrayList<HashMap> mediaInformation() {
        try {
            ArrayList<HashMap> mediList = new ArrayList<HashMap>();
            if (mediaTypeList.size() > 0) {
                List mediaInformationList = this.getMediaTypeList();
                Iterator<AdvertisementManager> iter = mediaInformationList.iterator();
                while (iter.hasNext()) {
                    AdvertisementManager iterate = iter.next();
                    HashMap _list = new HashMap();
                    _list.put("mediaType", iterate.getMediaType());
                    _list.put("mediaName", iterate.getMediaName());
                    _list.put("occurrence", iterate.getOccurrence());
                    mediList.add(_list);
                }
            }
            return mediList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<HashMap> updateMediaInformation() {
        try {
            ArrayList<HashMap> mediList = new ArrayList<HashMap>();
            if (tblMediaInformation.getRowCount() > 0) {
                List mediaInformationList = this.getMediaTypeList();
                Iterator<AdvertisementManager> iter = mediaInformationList.iterator();
                while (iter.hasNext()) {
                    AdvertisementManager iterate = iter.next();
                    HashMap _list = new HashMap();
                    _list.put("mediaType", iterate.getMediaType());
                    _list.put("mediaName", iterate.getMediaName());
                    _list.put("occurrence", iterate.getOccurrence());
                    mediList.add(_list);
                }

            }
            return mediList;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private ArrayList<HashMap> readVacancyInformation() {
        try {


            ArrayList<HashMap> vacncy_Information = new ArrayList<HashMap>();
            List vacncyInformation = this.getListOfJobType();
            Iterator<AdvertisementManager> iter = listOfJobType.iterator();
            while (iter.hasNext()) {
                AdvertisementManager saveVacancyInformation = iter.next();
                HashMap hm = new HashMap();
                if (saveVacancyInformation.isJobAdvertisment()) {
                    hm.put("advertDateFrom", txtAdvertDate_From.getValue().toString());
                    hm.put("advertDateTO", txtAdvertDateTO.getValue().toString());
                    hm.put("prepredeBY", getSessionBean1().getEmployeeId());
                    hm.put("preparationDate", dateFormat.format(new Date()));
                    hm.put("jobAdvertisment", saveVacancyInformation.isJobAdvertisment());

                    vacncy_Information.add(hm);
                }
            }

            return vacncy_Information;
        } catch (Exception e) {

            return null;
        }
    }

    private ArrayList<HashMap> vacancyInformation() {
        try {


            Iterator<AdvertisementManager> advertismantRegister = this.listOfJobType.iterator();
            ArrayList<HashMap> VacantInformation = new ArrayList<HashMap>();
            while (advertismantRegister.hasNext()) {
                AdvertisementManager adverSingleVal = advertismantRegister.next();
                if (adverSingleVal.isJobAdvertisment()) {
                    HashMap vacInformation = new HashMap();
                    vacInformation.put("advertDateFrom", txtAdvertDate_From.getValue().toString());
                    vacInformation.put("advertDateTO", txtAdvertDateTO.getValue().toString());
                    vacInformation.put("prepredeBY",getSessionBean1().getEmployeeId());
                    vacInformation.put("preparationDate", dateFormat.format(new Date()));
                    vacInformation.put("batchCode", getBachcode());
                    vacInformation.put("recruitmentID", adverSingleVal.getRecruitRequestId());
                    vacInformation.put("recruitRequestId", adverSingleVal.getRecruitRequestId());
                    if (choInside.isSelected()) {
                        vacInformation.put("advertisementType", "Inside");
                    } else if (choOutside.isSelected()) {
                        vacInformation.put("advertisementType", "Outside");
                    }

                    VacantInformation.add(vacInformation);
                }
            }


            return VacantInformation;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

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

    public String btnSave_action() {

        if (!updateData) {
          
            if (advertisementManager.registerVacancy(vacancyInformation(), mediaInformation(), recruitemntInformation())) {
                showSuccessOrFailureMessage(true, "Advertisement  information Successfully Saved ");
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(false);
                btnNew.setDisabled(false);
                choMediInformation.setDisabled(false);
                dispalyPreviousVacancy(bachcode);
                disableComponets();
                countAddMedi = 0;

            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("Advertisement  information Not  Saved.Please try again ? ");

            }
        } else {
            if (advertisementManager.saveMediyaInformation(mediaInformation(), advertisementID)) {
                //lblFormMessage.setStyleClass("success");
                showSuccessOrFailureMessage(true, "Advertisement  information Successfully Saved ");
                //  showConformationMsg(getMessage().getStyleClass().toString());
                dispalyPreviousVacancy(bachcode);
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(false);
                btnNew.setDisabled(false);
                choMediInformation.setDisabled(false);
            } else {
                // lblFormMessage.setStyleClass("error");
                showSuccessOrFailureMessage(false, "Advertisement  information Not  Saved.Please try again ? ");
            // showConformationMsg(getMessage().getStyleClass().toString());
            }
        }
        //return null means stay on the same page
        return null;
    }

    private void dispalyPreviousVacancy(String batchCode) {
         try {
            txtPreparedBy.setDisabled(false);
            txtPreparedBy.setValue("PREPARED_DATE");
            mediTableSize = 0;
            if (batchCode != null) {
                choJobToAdvertise.setDisabled(true);
                // boolean advertismentInformation = false;
                this.getListOfJobType().clear();
                getMediaTypeList().clear();
                int no = 1;
                //HashMap[] approvedList = advertisementManager.readAdvertisementInformantion(batchCode);
                ArrayList<HashMap> readPreviousAdver = advertisementManager.readPreviousAdvertisement(batchCode);
                for (HashMap hm : readPreviousAdver) {
                    AdvertisementManager addTOtable = new AdvertisementManager(
                            no,
                            hm.get("JOB_NAME").toString(),
                            hm.get("JOB_CODE").toString(),
                            hm.get("advFIRST_NAME").toString() + " " + hm.get("advMIDDLE_NAME").toString() + " " + hm.get("advLAST_NAME").toString(),
                            hm.get("RECRUIT_REQUEST_ID").toString(),
                            hm.get("RECRUIT_BATCH_CODE").toString(),
                            hm.get("PREPAREDBY").toString(),
                            hm.get("PREPARED_DATE").toString(),
                            hm.get("ADVERT_ID").toString(),
                            hm.get("recruit_request_type").toString(),
                            hm.get("ADVERT_DATE_TO").toString(),
                            hm.get("ADVERT_DATE_FROM").toString(),
                            hm.get("ADVERTISEMENT_TYPE").toString(),
                            hm.get("num_of_emps").toString(),
                            true);
                    if (hm.get("ADVERTISEMENT_TYPE").toString().equals("Outside")) {
                        choInside.setSelected(false);
                        choOutside.setSelected(true);
                    } else {
                        choInside.setSelected(true);
                        choOutside.setSelected(false);
                    }

                    no += 1;
                    this.getListOfJobType().add(addTOtable);
                    bachcode = hm.get("RECRUIT_BATCH_CODE").toString();

                }


                choMediInformation.setDisabled(false);
                HashMap advertisement = advertisementManager.readAdvertisment(batchCode);
                txtAdvertDate_From.setValue(advertisement.get("ADVERT_DATE_FROM"));
                txtAdvertDateTO.setValue(advertisement.get("ADVERT_DATE_TO"));
                txtPreparedDate.setValue(advertisement.get("PREPARED_DATE"));
                txtPreparedBy.setValue(advertisement.get("fullName"));
                setAdvertisementID(advertisement.get("ADVERT_ID").toString());

                HashMap[] mediInformationList = advertisementManager.readAdvertizmentMediaInformantion(this.getAdvertisementID());
                mediTableSize = mediInformationList.length;
                for (int i = 0; i < mediTableSize; i++) {
                    AdvertisementManager advertisementManager = new AdvertisementManager(mediInformationList[i].get("occurrence").toString(),
                            mediInformationList[i].get("media_type_code").toString(),
                            mediInformationList[i].get("occurrence").toString() + " Day",
                            mediInformationList[i].get("description").toString(),
                            Integer.parseInt(mediInformationList[i].get("mediid").toString()),mediInformationList[i].get("mediaName").toString());
                    this.getMediaTypeList().add(advertisementManager);
                }
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(false);
                btnNew.setDisabled(false);
                updateData = true;



            }
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public void drlPreviousVacancy_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            this.dispalyPreviousVacancy(vce.getNewValue().toString());
        }


    }

    public void rowSelectorEmployeeMediInformation_processMyEvent(RowSelectorEvent rse) {
        selectedMediRow = rse.getRow();
    }

    public String btnEdit_action() {

        try {
            int listSize = 0;
            mediID = 1;
            if (!choMediInformation.isSelected()) {
                if (selectedMediRow == -1) {
                    // lblFormMessage.setStyleClass("error");
                    showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
                // showConformationMsg(getMessage().getStyleClass().toString());
                } else if (this.mediaTypeList.isEmpty()) {
                    // lblFormMessage.setStyleClass("error");
                    showSuccessOrFailureMessage(false, "The Table is Empty!");
                //showConformationMsg(getMessage().getStyleClass().toString());

                } else {
                    buttonIdentifier = 3;
                    AdvertisementManager mediList = (AdvertisementManager) this.mediaTypeList.get(this.selectedMediRow);
                    this.mediaTypeList.remove(this.selectedMediRow);
                    drlMediType.setValue(mediList.getMediaType());
                    drlOccurrence.setValue(mediList.getOccurrence());
                    txtMediName.setValue(mediList.getMediaName());
                    txtMediName.setDisabled(false);
                    drlMediType.setDisabled(false);
                    drlOccurrence.setDisabled(false);
                    btnAdd.setDisabled(false);
                    choMediInformation.setDisabled(true);                    
                    mediID = mediList.getMediaID();
                }
            } else {
                txtAdvertDate_From.setDisabled(false);
                txtAdvertDateTO.setDisabled(false);
                choMediInformation.setDisabled(true);
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(true);
                btnUpdate.setDisabled(false);
                btnRest.setDisabled(false);
                btnDelete.setDisabled(true);
                btnNew.setDisabled(true);
                choJobToAdvertise.setDisabled(false);
                btnCalender.setDisabled(false);
                btnCalenderTO.setDisabled(false);

            }



//                drlAddressType.setValue(employeeAddressList.getAddressType());
//                drlRegion.setValue(employeeAddressList.getRegion());
//                this.setZoneCityType(lookUpManager.readZoneOrCityInARegion(employeeAddressList.getRegion()));
//                drlWoreda.setValue(employeeAddressList.getWoredaSubCity());
//                setWoredaAndZone(lookUpManager.readWoredaAndZone(drlWoreda.getValue().toString()));
//                kebelleTypes = lookUpManager.readKebelleInAWoredaOrSubCity(drlWoreda.getValue().toString());
//                drlZone.setValue(employeeAddressList.getZoneCity());
//                optKebele = lookUpManager.readKebelleInSubCity(drlZone.getValue().toString());
//                drlKebele.setValue(employeeAddressList.getKebelle());
//                txtHouseNumber.setValue(employeeAddressList.getHouseNumber());
//                if (employeeAddressList.getPobox().equals("Not Register")) {
//                    txtPobox.setValue("");
//                } else {
//                    txtPobox.setValue(employeeAddressList.getPobox());
//                }
//                if (employeeAddressList.getEmail().equals("Not Register")) {
//                    txtEmail.setValue("");
//                } else {
//                    txtEmail.setValue(employeeAddressList.getEmail());
//                }
//                if (employeeAddressList.getTelNumberHome().equals("Not Register")) {
//                    txtTelHome.setValue("");
//                } else {
//                    txtTelHome.setValue(employeeAddressList.getTelNumberHome());
//                }
//                if (employeeAddressList.getTelNumberOffice().equals("Not Register")) {
//                    txtTelOffice.setValue("");
//                } else {
//                    txtTelOffice.setValue(employeeAddressList.getTelNumberOffice());
//                }
//                if (employeeAddressList.getTelNumberMobile().equals("Not Register")) {
//                    txtMobile.setValue("");
//                } else {
//                    txtMobile.setValue(employeeAddressList.getTelNumberMobile());
//                }
//                addressId = employeeAddressList.getId();
//                this.enableAddressComponents();
//                btnAddAddress.setDisabled(false);
//                btnAddAddress.setDisabled(false);
//                avilabelOnDb = 1;
//                if (selectedAddressRow >= adressTableSize) {
//                    addressButtonIdentifier = 2;
//                    countAdress--;
//                }



        } catch (Exception e) {
        }













        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        int chkSave = 0;
        if (!choMediInformation.isSelected()) {
            List mediInformationList = this.getUpdatemediaTypeList();
            Iterator<AdvertisementManager> iter = mediInformationList.iterator();
            while (iter.hasNext()) {
                AdvertisementManager updateMediaInformation = iter.next();
                chkSave = advertisementManager.updateAdvertisementInfo(updateMediaInformation);
            }
            if (chkSave == 1) {
                showSuccessOrFailureMessage(true, "Advertisement  information Successfully Updated ");
                dispalyPreviousVacancy(bachcode);
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(false);
                btnNew.setDisabled(false);
                choMediInformation.setDisabled(false);
                disableComponets();

            } else {
                showSuccessOrFailureMessage(false, "Advertisement  information not Updated ");

            }

        } else {

            if (advertisementManager.updateVacancy(vacancyInformation(), updateMediaInformation(), recruitemntInformation(), adverAndBachCode())) {
                showSuccessOrFailureMessage(true, "Advertisement  information Successfully Updated ");
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(false);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(false);
                btnNew.setDisabled(false);
                choMediInformation.setDisabled(false);
            } else {
                showSuccessOrFailureMessage(false, "Advertisement  Information Not Updated ");
            }

        }
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {

        if (!choMediInformation.isSelected()) {
            if (selectedMediRow == -1) {
                //  lblFormMessage.setStyleClass("error");
                showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");
            //showConformationMsg(getMessage().getStyleClass().toString());
            } else if (this.mediaTypeList.isEmpty()) {
                // lblFormMessage.setStyleClass("error");
                showSuccessOrFailureMessage(false, "The Table is Empty!");
            //showConformationMsg(getMessage().getStyleClass().toString());

            } else {
                pnRequestConfirmationDleteMessage.setRendered(true);
                lblFormMessage45.setValue("Are you sure you want to delete?");
                deleteVacancy = true;
            }
        } else {

            pnRequestConfirmationDleteMessage.setRendered(true);
            lblFormMessage45.setValue("Are you sure you want to delete?");
            deleteVacancy = false;

        }
        //return null means stay on the same page
        return null;
    }

    public String lnkRetireApprove_action() {
        //return null means stay on the same page
        return "RecruitmentApprove";
    }

    public String lnkRegisterCandidate_action() {
        //return null means stay on the same page
        return "CandidatesPage";
    }

    public String cmdConfirmationCloseMesssage_action() {
        pnConfirmationMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String cmdConfirmationDleteCloseMesssage_action() {
        pnRequestConfirmationDleteMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnNoDelete_action() {
        pnRequestConfirmationDleteMessage.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnYesDelete_action() {
        pnRequestConfirmationDleteMessage.setRendered(false);
        //return null means stay on the same page
        if (deleteVacancy) {
            AdvertisementManager mediatype = (AdvertisementManager) getMediaTypeList().get(selectedMediRow);
            if (advertisementManager.deleteMediyaInformation(Integer.toString(mediatype.getMediaID()))) {
                // lblFormMessage.setStyleClass("success");
                choMediInformation.setSelected(false);

                showSuccessOrFailureMessage(true, "The media information deleted successfully !");

                // showConformationMsg(getMessage().getStyleClass().toString());
                disableComponets();
                getMediaTypeList().remove(selectedMediRow);
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnNew.setDisabled(false);
                if (getMediaTypeList().size() > 0) {
                    btnDelete.setDisabled(false);
                    btnEdit.setDisabled(false);
                } else {
                    btnDelete.setDisabled(true);
                    btnEdit.setDisabled(true);

                }

            } else {
                //  lblFormMessage.setStyleClass("success");
                showSuccessOrFailureMessage(false, "The media information not deleted.please try agin?");
            // showConformationMsg(getMessage().getStyleClass().toString());

            }
        } else {
            if (advertisementManager.deleteAdvertismdntInformation(advertisementID, recruitemntInformation())) {
                //  lblFormMessage.setStyleClass("success");
                showSuccessOrFailureMessage(true, "Advertisement  information deleted successfully !");
                this.getListOfJobType().clear();
                //showConformationMsg(getMessage().getStyleClass().toString());
                this.clearComponets();

                this.getMediaTypeList().clear();
                clearRequestComponets();
//                txtAdvertDate_From.setDisabled(false);
//                txtAdvertDateTO.setDisabled(false);
//                choMediInformation.setDisabled(true);
                btnAdd.setDisabled(true);
                btnSave.setDisabled(true);
                btnEdit.setDisabled(true);
                btnUpdate.setDisabled(true);
                btnRest.setDisabled(true);
                btnDelete.setDisabled(true);
                btnNew.setDisabled(true);
                this.disableComponets();
            } else {
                //  lblFormMessage.setStyleClass("error");
                showSuccessOrFailureMessage(false, "Advertisement  information Not  Deleted.Please try again ? ");
            //  showConformationMsg(getMessage().getStyleClass().toString());
            }
        }

        return null;
    }

    public void panelBorder1north_processMyEvent(DragEvent de) {
    }

    public void listPreviousAdvertisement_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            this.dispalyPreviousVacancy(vce.getNewValue().toString());
        }
    }

    public void choInside_processValueChange(ValueChangeEvent vce) {
        choOutside.setSelected(false);
    }

    public void choOutside_processValueChange(ValueChangeEvent vce) {
        choInside.setSelected(false);
    }

    public String cmdPreview_action() {
        //return null means stay on the same page
        selectedAdvertismentRow = tblRequritmentList.getRowIndex();
        dispalyDetaileAboutRequest();
        return null;
    }

    public String cmdRecruitment_action() {
        //return null means stay on the same page
        return "RequirementRequest";
    }

    public String cmdrecApproval_action() {
        //return null means stay on the same page
        return null;
    }



    public String cmdfilterCandidate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnCalender_action() {
        currenTDateToSet = "fromDate";
        calFromDate.setRendered(true);
        return null;

    }

    public String btnCalenderTO_action() {
        currenTDateToSet = "toDate";
        calFromDate.setRendered(true);
        return null;
    }

    public void calFromDate_processValueChange(ValueChangeEvent vce) {
        String selectedDate = dateFormat.format((Date) calFromDate.getValue());
        //txtLeaveStartDate.setValue(dateFormat.format(calLeaveStartDate.getValue()));

        if (currenTDateToSet.equalsIgnoreCase("fromDate")) {
            //inputTextSearchHist.setValue(dateFormat.format(calFromDate.getValue()));
            txtAdvertDate_From.setValue(dateFormat.format(calFromDate.getValue()));

        } else if (currenTDateToSet.equalsIgnoreCase("toDate")) {
            txtAdvertDateTO.setValue(dateFormat.format(calFromDate.getValue()));
        //inputTextSearchHistTo.setValue(selectedDate);
        }
        calFromDate.setRendered(false);
    }
    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
}

