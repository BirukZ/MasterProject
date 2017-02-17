/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.CourtOrder;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.HtmlSelectOneRadio;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.courtOrder.CourtOrderManager;
import manager.courtOrder.CourtOrderManager.CourtModel;
import manager.courtOrder.CourtOrderManager.DeductTime;
import manager.courtOrder.CourtOrderManager.PersonOrFamily;
import manager.employeeManager.EmployeeManage;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class CourtOrderPayment extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private HtmlCommandButton btn_new = new HtmlCommandButton();

    public HtmlCommandButton getBtn_new() {
        return btn_new;
    }

    public void setBtn_new(HtmlCommandButton hcb) {
        this.btn_new = hcb;
    }
    private HtmlCommandButton btn_save = new HtmlCommandButton();

    public HtmlCommandButton getBtn_save() {
        return btn_save;
    }

    public void setBtn_save(HtmlCommandButton hcb) {
        this.btn_save = hcb;
    }
    private HtmlCommandButton btn_reset = new HtmlCommandButton();
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public HtmlCommandButton getBtn_reset() {
        return btn_reset;
    }

    public void setBtn_reset(HtmlCommandButton hcb) {
        this.btn_reset = hcb;
    }
    private HtmlInputText txtRequesterDepartment = new HtmlInputText();

    public HtmlInputText getTxtRequesterDepartment() {
        return txtRequesterDepartment;
    }

    public void setTxtRequesterDepartment(HtmlInputText hit) {
        this.txtRequesterDepartment = hit;
    }
    private HtmlInputText txtRequesterPosition = new HtmlInputText();

    public HtmlInputText getTxtRequesterPosition() {
        return txtRequesterPosition;
    }

    public void setTxtRequesterPosition(HtmlInputText hit) {
        this.txtRequesterPosition = hit;
    }
    private HtmlInputText txtRequesterId = new HtmlInputText();

    public HtmlInputText getTxtRequesterId() {
        return txtRequesterId;
    }

    public void setTxtRequesterId(HtmlInputText hit) {
        this.txtRequesterId = hit;
    }
    private HtmlCommandButton btnSearchRequester = new HtmlCommandButton();

    public HtmlCommandButton getBtnSearchRequester() {
        return btnSearchRequester;
    }

    public void setBtnSearchRequester(HtmlCommandButton hcb) {
        this.btnSearchRequester = hcb;
    }
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
    }
    private PanelPopup pnlPopupSuccessOrFailureOther = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailureOther() {
        return pnlPopupSuccessOrFailureOther;
    }
    private SelectInputDate calOffenceDate = new SelectInputDate();

    public SelectInputDate getCalOffenceDate() {
        return calOffenceDate;
    }

    public void setCalOffenceDate(SelectInputDate calOffenceDate) {
        this.calOffenceDate = calOffenceDate;
    }
    private SelectInputDateBean calOffenceDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalOffenceDateBean() {
        return calOffenceDateBean;
    }
    private SelectInputDateBean calReportedDateBean = new SelectInputDateBean();

    public SelectInputDateBean getCalReportedDateBean() {
        return calReportedDateBean;
    }

    public void setCalReportedDateBean(SelectInputDateBean calReportedDateBean) {
        this.calReportedDateBean = calReportedDateBean;
    }

    public void setCalOffenceDateBean(SelectInputDateBean calOffenceDateBean) {
        this.calOffenceDateBean = calOffenceDateBean;
    }
    private SelectInputDate calReportedDate = new SelectInputDate();

    public SelectInputDate getCalReportedDate() {
        return calReportedDate;
    }

    public void setCalReportedDate(SelectInputDate calReportedDate) {
        this.calReportedDate = calReportedDate;
    }

    public void setPnlPopupSuccessOrFailureOther(PanelPopup pp) {
        this.pnlPopupSuccessOrFailureOther = pp;
    }
    private PanelLayout pnlMessageBodyOther = new PanelLayout();
    private HtmlOutputLabel lblSuccessOrErrorMessageOther = new HtmlOutputLabel();

    public PanelLayout getPnlMessageBodyOther() {
        return pnlMessageBodyOther;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessageOther() {
        return lblSuccessOrErrorMessageOther;
    }

    public void setLblSuccessOrErrorMessageOther(HtmlOutputLabel lblSuccessOrErrorMessageOther) {
        this.lblSuccessOrErrorMessageOther = lblSuccessOrErrorMessageOther;
    }

    public void setPnlMessageBodyOther(PanelLayout pl) {
        this.pnlMessageBodyOther = pl;
    }
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }
    private HtmlPanelGroup panelGroupMessageOther = new HtmlPanelGroup();

    public HtmlPanelGroup getPanelGroupMessageOther() {
        return panelGroupMessageOther;
    }

    public void setPanelGroupMessageOther(HtmlPanelGroup hpg) {
        this.panelGroupMessageOther = hpg;
    }
    private HtmlCommandLink btnClosePopupSuccessOrFailureOther = new HtmlCommandLink();

    public HtmlCommandLink getBtnClosePopupSuccessOrFailureOther() {
        return btnClosePopupSuccessOrFailureOther;
    }

    public void setBtnClosePopupSuccessOrFailureOther(HtmlCommandLink hcl) {
        this.btnClosePopupSuccessOrFailureOther = hcl;
    }
    private HtmlPanelGroup pnlgridpnMessageOther = new HtmlPanelGroup();

    public HtmlPanelGroup getPnlgridpnMessageOther() {
        return pnlgridpnMessageOther;
    }

    public void setPnlgridpnMessageOther(HtmlPanelGroup hpg) {
        this.pnlgridpnMessageOther = hpg;
    }
    private HtmlCommandLink lnkRegisterEyeWitnessOther = new HtmlCommandLink();

    public HtmlCommandLink getLnkRegisterEyeWitnessOther() {
        return lnkRegisterEyeWitnessOther;
    }

    public void setLnkRegisterEyeWitnessOther(HtmlCommandLink hcl) {
        this.lnkRegisterEyeWitnessOther = hcl;
    }
    private HtmlSelectOneRadio radioGroupApplierType = new HtmlSelectOneRadio();

    public HtmlSelectOneRadio getRadioGroupApplierType() {
        return radioGroupApplierType;
    }

    public void setRadioGroupApplierType(HtmlSelectOneRadio hsor) {
        this.radioGroupApplierType = hsor;
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
    private DefaultSelectionItems selectOneMenu2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu2DefaultItems() {
        return selectOneMenu2DefaultItems;
    }

    public void setSelectOneMenu2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu2DefaultItems = dsi;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlSelectOneMenu drl_relationType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_relationType() {
        return drl_relationType;
    }

    public void setDrl_relationType(HtmlSelectOneMenu hsom) {
        this.drl_relationType = hsom;
    }
    private HtmlInputText txt_full_Name = new HtmlInputText();

    public HtmlInputText getTxt_full_Name() {
        return txt_full_Name;
    }

    public void setTxt_full_Name(HtmlInputText hit) {
        this.txt_full_Name = hit;
    }
    private HtmlInputText txt_Personal_Address = new HtmlInputText();

    public HtmlInputText getTxt_Personal_Address() {
        return txt_Personal_Address;
    }

    public void setTxt_Personal_Address(HtmlInputText hit) {
        this.txt_Personal_Address = hit;
    }
    private HtmlSelectOneMenu drl_sex = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_sex() {
        return drl_sex;
    }

    public void setDrl_sex(HtmlSelectOneMenu hsom) {
        this.drl_sex = hsom;
    }
    private HtmlInputText txt_age = new HtmlInputText();

    public HtmlInputText getTxt_age() {
        return txt_age;
    }

    public void setTxt_age(HtmlInputText hit) {
        this.txt_age = hit;
    }
    private HtmlOutputText lbl_relation = new HtmlOutputText();

    public HtmlOutputText getLbl_relation() {
        return lbl_relation;
    }

    public void setLbl_relation(HtmlOutputText hot) {
        this.lbl_relation = hot;
    }
    private HtmlOutputText lbl_fullName = new HtmlOutputText();

    public HtmlOutputText getLbl_fullName() {
        return lbl_fullName;
    }

    public void setLbl_fullName(HtmlOutputText hot) {
        this.lbl_fullName = hot;
    }
    private HtmlOutputText lbl_addressPer = new HtmlOutputText();

    public HtmlOutputText getLbl_addressPer() {
        return lbl_addressPer;
    }

    public void setLbl_addressPer(HtmlOutputText hot) {
        this.lbl_addressPer = hot;
    }
    private HtmlOutputText lbl_sex = new HtmlOutputText();

    public HtmlOutputText getLbl_sex() {
        return lbl_sex;
    }

    public void setLbl_sex(HtmlOutputText hot) {
        this.lbl_sex = hot;
    }
    private HtmlOutputText lbl_age = new HtmlOutputText();

    public HtmlOutputText getLbl_age() {
        return lbl_age;
    }

    public void setLbl_age(HtmlOutputText hot) {
        this.lbl_age = hot;
    }
    private HtmlDataTable dataTable_Personal = new HtmlDataTable();

    public HtmlDataTable getDataTable_Personal() {
        return dataTable_Personal;
    }

    public void setDataTable_Personal(HtmlDataTable hdt) {
        this.dataTable_Personal = hdt;
    }
    private HtmlCommandButton btn_add = new HtmlCommandButton();

    public HtmlCommandButton getBtn_add() {
        return btn_add;
    }

    public void setBtn_add(HtmlCommandButton hcb) {
        this.btn_add = hcb;
    }
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
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
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private HtmlOutputText out_txt_OrgType = new HtmlOutputText();

    public HtmlOutputText getOut_txt_OrgType() {
        return out_txt_OrgType;
    }

    public void setOut_txt_OrgType(HtmlOutputText hot) {
        this.out_txt_OrgType = hot;
    }
    private HtmlOutputText out_txt_OrgName = new HtmlOutputText();

    public HtmlOutputText getOut_txt_OrgName() {
        return out_txt_OrgName;
    }

    public void setOut_txt_OrgName(HtmlOutputText hot) {
        this.out_txt_OrgName = hot;
    }
    private HtmlOutputText out_txt_addressper = new HtmlOutputText();

    public HtmlOutputText getOut_txt_addressper() {
        return out_txt_addressper;
    }

    public void setOut_txt_addressper(HtmlOutputText hot) {
        this.out_txt_addressper = hot;
    }
    private HtmlOutputText out_txt_orgPhone = new HtmlOutputText();

    public HtmlOutputText getOut_txt_orgPhone() {
        return out_txt_orgPhone;
    }

    public void setOut_txt_orgPhone(HtmlOutputText hot) {
        this.out_txt_orgPhone = hot;
    }
    private HtmlSelectOneMenu drl_org_Type = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_org_Type() {
        return drl_org_Type;
    }

    public void setDrl_org_Type(HtmlSelectOneMenu hsom) {
        this.drl_org_Type = hsom;
    }
    private HtmlInputText txt_OrgName = new HtmlInputText();

    public HtmlInputText getTxt_OrgName() {
        return txt_OrgName;
    }

    public void setTxt_OrgName(HtmlInputText hit) {
        this.txt_OrgName = hit;
    }
    private HtmlInputText txt_org_address = new HtmlInputText();

    public HtmlInputText getTxt_org_address() {
        return txt_org_address;
    }

    public void setTxt_org_address(HtmlInputText hit) {
        this.txt_org_address = hit;
    }
    private HtmlInputText txt_org_Phone = new HtmlInputText();

    public HtmlInputText getTxt_org_Phone() {
        return txt_org_Phone;
    }

    public void setTxt_org_Phone(HtmlInputText hit) {
        this.txt_org_Phone = hit;
    }
    private HtmlDataTable dataTable_Organization = new HtmlDataTable();

    public HtmlDataTable getDataTable_Organization() {
        return dataTable_Organization;
    }

    public void setDataTable_Organization(HtmlDataTable hdt) {
        this.dataTable_Organization = hdt;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drl_chargeType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrl_chargeType() {
        return drl_chargeType;
    }

    public void setDrl_chargeType(HtmlSelectOneMenu hsom) {
        this.drl_chargeType = hsom;
    }
    private HtmlInputText txt_CourtName = new HtmlInputText();

    public HtmlInputText getTxt_CourtName() {
        return txt_CourtName;
    }

    public void setTxt_CourtName(HtmlInputText hit) {
        this.txt_CourtName = hit;
    }
    private HtmlInputText txt_DeductionAmount = new HtmlInputText();

    public HtmlInputText getTxt_DeductionAmount() {
        return txt_DeductionAmount;
    }

    public void setTxt_DeductionAmount(HtmlInputText hit) {
        this.txt_DeductionAmount = hit;
    }
    private HtmlInputText txt_StartDate = new HtmlInputText();

    public HtmlInputText getTxt_StartDate() {
        return txt_StartDate;
    }

    public void setTxt_StartDate(HtmlInputText hit) {
        this.txt_StartDate = hit;
    }
    private HtmlInputText txt_endDate = new HtmlInputText();

    public HtmlInputText getTxt_endDate() {
        return txt_endDate;
    }

    public void setTxt_endDate(HtmlInputText hit) {
        this.txt_endDate = hit;
    }
    private HtmlInputTextarea txtArea_Reasoun = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtArea_Reasoun() {
        return txtArea_Reasoun;
    }

    public void setTxtArea_Reasoun(HtmlInputTextarea hit) {
        this.txtArea_Reasoun = hit;
    }
    private HtmlInputText txt_DocRef = new HtmlInputText();

    public HtmlInputText getTxt_DocRef() {
        return txt_DocRef;
    }

    public void setTxt_DocRef(HtmlInputText hit) {
        this.txt_DocRef = hit;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems1 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems1 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private HtmlOutputLabel percent_value = new HtmlOutputLabel();

    public HtmlOutputLabel getPercent_value() {
        return percent_value;
    }

    public void setPercent_value(HtmlOutputLabel hol) {
        this.percent_value = hol;
    }
    private HtmlInputText txt_percentValue = new HtmlInputText();

    public HtmlInputText getTxt_percentValue() {
        return txt_percentValue;
    }

    public void setTxt_percentValue(HtmlInputText hit) {
        this.txt_percentValue = hit;
    }
    private HtmlOutputText dedct_amout = new HtmlOutputText();

    public HtmlOutputText getDedct_amout() {
        return dedct_amout;
    }

    public void setDedct_amout(HtmlOutputText hot) {
        this.dedct_amout = hot;
    }
    private HtmlOutputLabel percent = new HtmlOutputLabel();

    public HtmlOutputLabel getPercent() {
        return percent;
    }

    public void setPercent(HtmlOutputLabel hol) {
        this.percent = hol;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private HtmlCommandButton btn_EndDate = new HtmlCommandButton();

    public HtmlCommandButton getBtn_EndDate() {
        return btn_EndDate;
    }

    public void setBtn_EndDate(HtmlCommandButton hcb) {
        this.btn_EndDate = hcb;
    }
    private PanelLayout panelLayoutFamily = new PanelLayout();

    public PanelLayout getPanelLayoutFamily() {
        return panelLayoutFamily;
    }

    public void setPanelLayoutFamily(PanelLayout pl) {
        this.panelLayoutFamily = pl;
    }
    private DefaultTableDataModel dataTable1Model3 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model3() {
        return dataTable1Model3;
    }

    public void setDataTable1Model3(DefaultTableDataModel dtdm) {
        this.dataTable1Model3 = dtdm;
    }
    private HtmlDataTable dataTable1Family = new HtmlDataTable();

    public HtmlDataTable getDataTable1Family() {
        return dataTable1Family;
    }

    public void setDataTable1Family(HtmlDataTable hdt) {
        this.dataTable1Family = hdt;
    }
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public void setPnlPopupSuccessOrFailure(PanelPopup pp) {
        this.pnlPopupSuccessOrFailure = pp;
    }
    private HtmlInputText intxt_TotalDeduction = new HtmlInputText();

    public HtmlInputText getIntxt_TotalDeduction() {
        return intxt_TotalDeduction;
    }

    public void setIntxt_TotalDeduction(HtmlInputText hit) {
        this.intxt_TotalDeduction = hit;
    }
   
    private HtmlOutputText out_txt_TotalDeductionAmount = new HtmlOutputText();

    public HtmlOutputText getOut_txt_TotalDeductionAmount() {
        return out_txt_TotalDeductionAmount;
    }

    public void setOut_txt_TotalDeductionAmount(HtmlOutputText hot) {
        this.out_txt_TotalDeductionAmount = hot;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chk_TotalDecution = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChk_TotalDecution() {
        return chk_TotalDecution;
    }

    public void setChk_TotalDecution(HtmlSelectBooleanCheckbox hsbc) {
        this.chk_TotalDecution = hsbc;
    }
    private HtmlOutputText out_txt_amountTotal = new HtmlOutputText();

    public HtmlOutputText getOut_txt_amountTotal() {
        return out_txt_amountTotal;
    }

    public void setOut_txt_amountTotal(HtmlOutputText hot) {
        this.out_txt_amountTotal = hot;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public CourtOrderPayment() {
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
    String saveOrEditOrUpdateLabel = "Save";
    EmployeeManage employeeManager = new EmployeeManage();
    CourtOrderManager courtManager = new CourtOrderManager();
    String requesterId = null; //REQUESTER_ID
    String startDate;
    String endDate;
    String selectionCondition;
    String deductionSelectioCon;
    String deductionSelectionTime;
    String currentID;
    String inputType="Montly";

    int sizeOfMember;
    public String requestID;
    public String EMPLOYEE = CourtOrderManager.TAKER_TYPE_PERSON;
    public String ORGANAZATION = CourtOrderManager.TAKER_TYPE_ORGANAZATION;
    public String PERCENT = CourtOrderManager.PERCENT;
    public String MONEY = CourtOrderManager.MONEY;
    public String YES = CourtOrderManager.YES;
    public String NO = CourtOrderManager.NO;
    CourtModel personModel = new CourtModel();
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Option> sex = courtManager.SelectSex();
    ArrayList<Option> orgType = courtManager.SelectOrganazationType();
    ArrayList<Option> relationType = courtManager.SelectRelationType();
    ArrayList<PersonOrFamily> familyOrPerson = new ArrayList<PersonOrFamily>();
    ArrayList<CourtModel> courtDeductForPerson = new ArrayList<CourtModel>();
    ArrayList<CourtModel> courtDeductForOrganazation = new ArrayList<CourtModel>();
    ArrayList<DeductTime> deductTime = new ArrayList<DeductTime>();
    ArrayList<Option> chargeType = courtManager.getAllCharge();
    int selectedCourtTypeRow = -1;
    public static String newRequestId;

    public String getInputType() {
        return inputType;
    }

    public void setInputType(String inputType) {
        this.inputType = inputType;
    }

    public ArrayList<PersonOrFamily> getFamilyOrPerson() {
        return familyOrPerson;
    }

    public void setFamilyOrPerson(ArrayList<PersonOrFamily> familyOrPerson) {
        this.familyOrPerson = familyOrPerson;
    }

    public int getSizeOfMember() {
        return sizeOfMember;
    }

    public void setSizeOfMember(int sizeOfMember) {
        this.sizeOfMember = sizeOfMember;
    }

    public String getDeductionSelectionTime() {
        return deductionSelectionTime;
    }

    public void setDeductionSelectionTime(String deductionSelectionTime) {
        this.deductionSelectionTime = deductionSelectionTime;
    }

    public ArrayList<DeductTime> getDeductTime() {
        return deductTime;
    }

    public void setDeductTime(ArrayList<DeductTime> deductTime) {
        this.deductTime = deductTime;
    }

    public String getRequestID() {
        return requestID;
    }

    public void setRequestID(String requestID) {
        this.requestID = requestID;
    }

    public String getDeductionSelectioCon() {
        return deductionSelectioCon;
    }

    public void setDeductionSelectioCon(String deductionSelectioCon) {
        this.deductionSelectioCon = deductionSelectioCon;
    }

    public String getNO() {
        return NO;
    }

    public void setNO(String NO) {
        this.NO = NO;
    }

    public String getYES() {
        return YES;
    }

    public void setYES(String YES) {
        this.YES = YES;
    }

    public String getMONEY() {
        return MONEY;
    }

    public void setMONEY(String MONEY) {
        this.MONEY = MONEY;
    }

    public String getPERCENT() {
        return PERCENT;
    }

    public void setPERCENT(String PERCENT) {
        this.PERCENT = PERCENT;
    }

    public String getCurrentID() {
        return currentID;
    }

    public void setCurrentID(String currentID) {
        this.currentID = currentID;
    }

    public ArrayList<Option> getChargeType() {
        return chargeType;
    }

    public void setChargeType(ArrayList<Option> chargeType) {
        this.chargeType = chargeType;
    }

    public ArrayList<CourtModel> getCourtDeductForOrganazation() {
        return courtDeductForOrganazation;
    }

    public void setCourtDeductForOrganazation(ArrayList<CourtModel> courtDeductForOrganazation) {
        this.courtDeductForOrganazation = courtDeductForOrganazation;
    }

    public ArrayList<CourtModel> getCourtDeductForPerson() {
        return courtDeductForPerson;
    }

    public void setCourtDeductForPerson(ArrayList<CourtModel> courtDeductForPerson) {
        this.courtDeductForPerson = courtDeductForPerson;
    }

    public ArrayList<Option> getRelationType() {
        return relationType;
    }

    public void setRelationType(ArrayList<Option> relationType) {
        this.relationType = relationType;
    }

    public String getSelectionCondition() {
        return selectionCondition;
    }

    public void setSelectionCondition(String selectionCondition) {
        this.selectionCondition = selectionCondition;
    }

    public String getEMPLOYEE() {
        return EMPLOYEE;
    }

    public void setEMPLOYEE(String EMPLOYEE) {
        this.EMPLOYEE = EMPLOYEE;
    }

    public String getORGANAZATION() {
        return ORGANAZATION;
    }

    public void setORGANAZATION(String ORGANAZATION) {
        this.ORGANAZATION = ORGANAZATION;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }

    public ArrayList<Option> getSex() {
        return sex;
    }

    public void setSex(ArrayList<Option> sex) {
        this.sex = sex;
    }

    public ArrayList<Option> getOrgType() {
        return orgType;
    }

    public void setOrgType(ArrayList<Option> orgType) {
        this.orgType = orgType;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay, int durationInSecond) {
        //lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessageOther.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        //  lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessageOther.setValue(messageToDisplay);
        //   lblSuccessOrErrorMessage.setVisible(true);
        lblSuccessOrErrorMessageOther.setVisible(true);
        pnlPopupSuccessOrFailureOther.setRendered(true);

        String val = "message";
        String fadeTime = Integer.toString(durationInSecond * 1000);//(success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        int fadeTime = success ? 3000 : 8000;
        // lnkRecordEyeWitnesses.setRendered(false);
        showSuccessOrFailureMessage(success, messageToDisplay, fadeTime);
    }

    public void showSuccessOrFailureMessageNew(boolean success, String messageToDisplay, int durationInSecond) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = Integer.toString(durationInSecond * 1000);//(success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    private boolean populateRequesterTextComponents(String employeeID) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeID);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(true, "NO EMPLOYEE FOUND WITH ID : " + employeeID);
                return false;
            } else {
                requesterId = empInfoHashMap.get("employeeId").toString();
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeID);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                requestID = courtManager.getCurrentIdOfCourtOrderPayment();
                return true;
            }
        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    public void ClearFunction() {
        txt_full_Name.resetValue();
        txt_age.resetValue();
        txt_Personal_Address.resetValue();
        drl_sex.resetValue();

    }

    public void calOffenceDate_processValueChange(ValueChangeEvent vce) {
        txt_StartDate.setValue(dateFormat.format(calOffenceDate.getValue()));
        startDate = dateFormat.format(calOffenceDate.getValue());
        calOffenceDate.setRendered(false);
    }

    public void calReportedDate_processValueChange(ValueChangeEvent vce) {
        txt_endDate.setValue(dateFormat.format(calReportedDate.getValue()));
        endDate = dateFormat.format(calReportedDate.getValue());
        calReportedDate.setRendered(false);
    }

    public void rowSelector1FamilyRelationType_processMyEvent(RowSelectorEvent rse) {
        if (selectedCourtTypeRow != rse.getRow()) {//when new row selected
            selectedCourtTypeRow = rse.getRow();
            familyOrPerson.get(selectedCourtTypeRow).setSelected(true);
            this.ClearFunction();
            txt_full_Name.setValue(familyOrPerson.get(selectedCourtTypeRow).getFullName());
            drl_sex.setValue(familyOrPerson.get(selectedCourtTypeRow).getSex());
            txt_age.setValue(familyOrPerson.get(selectedCourtTypeRow).getAge());
            txt_Personal_Address.setValue(familyOrPerson.get(selectedCourtTypeRow).getAddress());
        } else {//keep it selected
            familyOrPerson.get(selectedCourtTypeRow).setSelected(true);
        }
    }

    private void RenderTruePersonalComponet() {
        lbl_relation.setRendered(true);
        lbl_fullName.setRendered(true);
        lbl_age.setRendered(true);
        lbl_addressPer.setRendered(true);
        lbl_sex.setRendered(true);
        dataTable_Personal.setRendered(true);
        txt_Personal_Address.setRendered(true);
        txt_full_Name.setRendered(true);
        txt_age.setRendered(true);
        drl_relationType.setRendered(true);
        drl_sex.setRendered(true);
        btn_add.setRendered(true);

    }

    private void RenderFalsePersonalComponet() {
        lbl_relation.setRendered(false);
        lbl_fullName.setRendered(false);
        lbl_age.setRendered(false);
        lbl_addressPer.setRendered(false);
        lbl_sex.setRendered(false);
        dataTable_Personal.setRendered(false);
        txt_Personal_Address.setRendered(false);
        txt_full_Name.setRendered(false);
        txt_age.setRendered(false);
        drl_relationType.setRendered(false);
        drl_sex.setRendered(false);
        btn_add.setRendered(false);

    }

    private void RenderTrueOrganazationComponet() {
        out_txt_OrgName.setRendered(true);
        out_txt_OrgType.setRendered(true);
        out_txt_addressper.setRendered(true);
        out_txt_orgPhone.setRendered(true);
        drl_org_Type.setRendered(true);
        txt_org_Phone.setRendered(true);
        txt_org_address.setRendered(true);
        txt_OrgName.setRendered(true);
        dataTable_Organization.setRendered(true);
        btn_add.setRendered(true);
    }

    private void RenderFalseOrganazationComponet() {
        out_txt_OrgName.setRendered(false);
        out_txt_OrgType.setRendered(false);
        out_txt_addressper.setRendered(false);
        out_txt_orgPhone.setRendered(false);
        drl_org_Type.setRendered(false);
        txt_org_Phone.setRendered(false);
        txt_org_address.setRendered(false);
        txt_OrgName.setRendered(false);


        dataTable_Organization.setRendered(false);
        btn_add.setRendered(false);


    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
        txtArea_Reasoun.setValue(null);
        txt_CourtName.setValue(null);
        txt_DeductionAmount.setValue(null);
        txt_DocRef.setValue(null);
        txt_OrgName.setValue(null);
        txt_Personal_Address.setValue(null);
        txt_Personal_Address.setValue(null);
        txt_StartDate.setValue(null);
        txt_age.setValue(null);
        txt_endDate.setValue(null);
        txt_full_Name.setValue(null);
        requesterId = null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null) {
            requesterId = txtRequesterId.getValue().toString();
            if (!populateRequesterTextComponents(requesterId)) {
                requesterId = null;
            }
        }
        return null;

    }

    public void PopulateRelationText() {
        txt_full_Name.setValue(personModel.getNameOfTaker());
        txt_age.setValue(personModel.getTakerAge());
        drl_sex.setValue(personModel.getTakerSex());
        txt_Personal_Address.setValue(personModel.getTakerAddress());

    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    public void radioGroupApplierType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals(EMPLOYEE)) {
            RenderFalseOrganazationComponet();
            RenderTruePersonalComponet();
            selectionCondition = "Person";
        } else if (vce.getNewValue().toString().equals(ORGANAZATION)) {
            RenderFalsePersonalComponet();
            RenderTrueOrganazationComponet();
            selectionCondition = "Orgnazation";
        }
    }

    public String button1_action() {
        calOffenceDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String button2_action() {
        calReportedDate.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void drl_relationType_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String relType = drl_relationType.getValue().toString();
            String empID = txtRequesterId.getValue().toString();
            //  courtDeductForPerson=courtManager.getAllPersonUnderRelationShip(empID,relType);
            if (relType.equalsIgnoreCase("�?ጅ")) {
                familyOrPerson = courtManager.getAllPersonUnderRelationShip(empID, relType);
                dataTable1Family.setRendered(true);

            } else {
                personModel = courtManager.getAllPersonRelationShip(empID, relType);

                PopulateRelationText();

            }

        }

    }

    public String getCurrentCourtDeductionID() {
        currentID = courtManager.getCurrentIdOfCourtOrderPayment();
        return currentID;
    }

    public String btn_add_action() {
        CourtModel currentmemberList = new CourtModel();
        String currentDateAndTime = new Timestamp((new Date()).getTime()).toString();
        String requestIdRep = requestID;
        String fullName;
        String id;
        String department;
        String position;
        String relType;
        String nameOfTaker;
        String takerAddress;
        String takerSex;
        int takerAge = 0;
        String organazationType;
        String organazationName;
        String organazationAddress;
        String organazationPhone;
        String charType;
        String courtName;
        String deductionType;
        String backDeduction;
        double totalDeductionAmount=0.0;
        int totalPercentDeductionAmount=0;
        double deductionAmount = 0.0;
        String percentValu = null;
        String starDate;
        String enDate;
        String reasoun;
        String docRef;

        if (selectionCondition.equalsIgnoreCase("Person")) {


            fullName = txtRequesterFullName.getValue().toString();
            id = txtRequesterId.getValue().toString();
            department = txtRequesterDepartment.getValue().toString();
            position = txtRequesterPosition.getValue().toString();
            relType = drl_relationType.getValue().toString();
            nameOfTaker = txt_full_Name.getValue().toString();
            takerAddress = txt_Personal_Address.getValue().toString();
            takerSex = drl_sex.getValue().toString();
            takerAge = Integer.parseInt(txt_age.getValue().toString());
            charType = drl_chargeType.getValue().toString();
            courtName = txt_CourtName.getValue().toString();
            deductionType = deductionSelectioCon;
            if (deductionSelectioCon.equalsIgnoreCase("Percent"))
            {
                percentValu = (txt_percentValue.getValue().toString());
              //  totalPercentDeductionAmount=Integer.parseInt(intxt_TotalDeductionPercent.getValue().toString());
                totalDeductionAmount=0.0;
                deductionAmount = 0.0;
            } else if (deductionSelectioCon.equalsIgnoreCase("Money"))
            {
                deductionAmount = Double.parseDouble(txt_DeductionAmount.getValue().toString());
                if(chk_TotalDecution.isSelected()){
                totalDeductionAmount=Double.parseDouble(intxt_TotalDeduction.getValue().toString());
                inputType="Total";
                }else{
                totalDeductionAmount=0.0;
                }
                
                totalPercentDeductionAmount=0;
                percentValu = null;
            }

            backDeduction = deductionSelectionTime;
            starDate = txt_StartDate.getValue().toString();
            enDate = txt_endDate.getValue().toString();
            reasoun = txtArea_Reasoun.getValue().toString();
            docRef = txt_DocRef.getValue().toString();

            courtDeductForPerson.add(0, new CourtModel(requestID, fullName, id, department, position, selectionCondition, relType, nameOfTaker, takerAddress, takerSex, takerAge, charType, courtName,
                    deductionType, deductionAmount, percentValu, starDate, enDate, reasoun, docRef, currentDateAndTime,totalDeductionAmount,inputType));

        } else if (selectionCondition.equalsIgnoreCase("Orgnazation"))
        {
            fullName = txtRequesterFullName.getValue().toString();
            id = txtRequesterId.getValue().toString();
            department = txtRequesterDepartment.getValue().toString();
            position = txtRequesterPosition.getValue().toString();
            organazationType = drl_org_Type.getValue().toString();
            organazationName = txt_OrgName.getValue().toString();
            organazationAddress = txt_org_address.getValue().toString();
            organazationPhone = txt_org_Phone.getValue().toString();
            charType = drl_chargeType.getValue().toString();
            courtName = txt_CourtName.getValue().toString();
            deductionType = deductionSelectioCon;
            if (deductionSelectioCon.equalsIgnoreCase("Percent")) {
                percentValu = (txt_percentValue.getValue().toString());
             //   totalPercentDeductionAmount=Integer.parseInt(intxt_TotalDeductionPercent.getValue().toString());
                totalDeductionAmount=0.0;
                deductionAmount = 0.0;
            } else if (deductionSelectioCon.equalsIgnoreCase("Money")) {
                deductionAmount = Double.parseDouble(txt_DeductionAmount.getValue().toString());

              if(chk_TotalDecution.isSelected()){
                totalDeductionAmount=Double.parseDouble(intxt_TotalDeduction.getValue().toString());
                inputType="Total";
                }else{
                totalDeductionAmount=0.0;
                }
                percentValu = null;
            }

            backDeduction = deductionSelectionTime;
            starDate = txt_StartDate.getValue().toString();
            enDate = txt_endDate.getValue().toString();
            reasoun = txtArea_Reasoun.getValue().toString();
            docRef = txt_DocRef.getValue().toString();
            courtDeductForOrganazation.add(0, new CourtModel(requestID, fullName, id, department, position, selectionCondition, organazationType, organazationName, organazationAddress, organazationPhone, charType, courtName,
                    deductionType, deductionAmount, percentValu, starDate, enDate, reasoun, docRef, currentDateAndTime,totalDeductionAmount,inputType));
        }
        return null;

    }

    public void selectOneRadioDeducationType_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals(PERCENT)) {
            dedct_amout.setRendered(false);
            txt_DeductionAmount.setRendered(false);
            percent_value.setRendered(true);
            txt_percentValue.setRendered(true);
            percent.setRendered(true);
            intxt_TotalDeduction.setRendered(false);
            out_txt_TotalDeductionAmount.setRendered(false);
          //  intxt_TotalDeductionPercent.setRendered(true);
           // out_txt_TotalPercent.setRendered(true);
            chk_TotalDecution.setRendered(false);
            out_txt_amountTotal.setRendered(false);
            intxt_TotalDeduction.setRendered(false);
            deductionSelectioCon = "Percent";
        } else if (vce.getNewValue().toString().equals(MONEY)) {
            percent_value.setRendered(false);
            txt_percentValue.setRendered(false);
            percent.setRendered(false);
            intxt_TotalDeduction.setRendered(true);
            out_txt_TotalDeductionAmount.setRendered(true);
            dedct_amout.setRendered(true);
            txt_DeductionAmount.setRendered(true);
             chk_TotalDecution.setRendered(true);
            out_txt_amountTotal.setRendered(true);
           // intxt_TotalDeductionPercent.setRendered(false);
           // out_txt_TotalPercent.setRendered(false);
            deductionSelectioCon = "Money";
        }



    }

    public boolean validateAndInitializeCourtOrderPaymentRequest() {

        return true;
    }

    public void selectOneRadioYesOrNo_processValueChange(ValueChangeEvent vce) {
//        if (vce.getNewValue().toString().equals(YES)) {
//            //  dataTable1DeductTime.setRendered(true);
//            // btn_add_DedutTime.setRendered(true);
//            deductionSelectionTime = "Yes";
//            btn_EndDate.setDisabled(true);
//        } else if (vce.getNewValue().toString().equals(NO)) {
//            //  dataTable1DeductTime.setRendered(false);
//            // btn_add_DedutTime.setRendered(false);
//            btn_EndDate.setDisabled(false);
//            deductionSelectionTime = "No";
//        }
    }

    public String btn_add_DedutTime_action() {
        double deductionAmount = 0;
        String deductionType = "";
        String deductionTime = "";
        if (deductionSelectionTime.equalsIgnoreCase("Yes")) {
            deductionType = deductionSelectioCon;
            deductionTime = txt_StartDate.getValue().toString();
            if (deductionSelectioCon.equalsIgnoreCase("Percent")) {
                deductionAmount = Double.parseDouble(txt_percentValue.getValue().toString());

            } else if (deductionSelectioCon.equalsIgnoreCase("Money")) {
                deductionAmount = Double.parseDouble(txt_DeductionAmount.getValue().toString());

            }
            deductTime.add(0, new DeductTime(deductionType, deductionAmount, deductionTime));

        }

        return null;
    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
    }

    public String btn_save_action() {

        if (saveOrEditOrUpdateLabel.equalsIgnoreCase("Save")) {
            if (validateAndInitializeCourtOrderPaymentRequest()) {
                if (selectionCondition.equalsIgnoreCase("Person")) {

                    if (courtManager.SaveCourtDeductionModelForPerson(courtDeductForPerson)) {
                        showSuccessOrFailureMessageNew(true, "Saving Is Successful:", 40);
                    } else {
                        showSuccessOrFailureMessageNew(false, "Saving Is Failed: ", 40);

                    }

                } else if (selectionCondition.equalsIgnoreCase("Orgnazation")) {
                   
                    if (courtManager.SaveCourtDeductionModelForOrganazation(courtDeductForOrganazation)) {
                        showSuccessOrFailureMessageNew(true, "Saving Is Successful:", 40);
                    } else {
                        showSuccessOrFailureMessageNew(false, "Saving Is Failed: ", 40);

                    }
                }
            }

        }

        return null;
    }

    public String txt_endDate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnClosePopupSuccessOrFailure_action() {
        // TODO: Replace with your code
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }

    public String btn_reset_action() {
        //return null means stay on the same page
        clearRequesterTextComponents();
        return null;
    }

    public void chk_TotalDecution_processValueChange(ValueChangeEvent vce) {

      intxt_TotalDeduction.setDisabled(false);

    }
}

