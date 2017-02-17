/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Look_Up;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.event.ValueChangeEvent;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LuAddressZoneOrCityAndWoredORSubCity extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    LookUpManager read = new LookUpManager();
    private Option[] regionOpt = read.readRegionOption();
    boolean modification=false;
//    ArrayList<SelectItem> regionOpt = new ArrayList<SelectItem>();
//
//    public ArrayList<SelectItem> getRegionOpt() {
//        return read.readRegion();
//    }
//
//    public void setRegionOpt(ArrayList<SelectItem> regionOpt) {
//        this.regionOpt = regionOpt;
//    }
    Option[] optZoneCityType = null;

    public Option[] getOptZoneCityType() {
        return optZoneCityType;
    }

    public void setOptZoneCityType(Option[] optZoneCityType) {
        this.optZoneCityType = optZoneCityType;
    }

    public Option[] getRegionOpt() {
        return regionOpt;
    }

    public void setRegionOpt(Option[] regionOpt) {
        this.regionOpt = regionOpt;
    }

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
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
    private HtmlSelectOneMenu drlRegion = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlRegion() {
        return drlRegion;
    }

    public void setDrlRegion(HtmlSelectOneMenu hsom) {
        this.drlRegion = hsom;
    }
    private HtmlSelectOneMenu drlZoneCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneCity() {
        return drlZoneCity;
    }

    public void setDrlZoneCity(HtmlSelectOneMenu hsom) {
        this.drlZoneCity = hsom;
    }
    private HtmlInputText txtWoredaName = new HtmlInputText();

    public HtmlInputText getTxtWoredaName() {
        return txtWoredaName;
    }

    public void setTxtWoredaName(HtmlInputText hit) {
        this.txtWoredaName = hit;
    }
    private HtmlInputText txtWoredaId = new HtmlInputText();

    public HtmlInputText getTxtWoredaId() {
        return txtWoredaId;
    }

    public void setTxtWoredaId(HtmlInputText hit) {
        this.txtWoredaId = hit;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
    }
    private HtmlDataTable tblWoreda = new HtmlDataTable();

    public HtmlDataTable getTblWoreda() {
        return tblWoreda;
    }

    public void setTblWoreda(HtmlDataTable hdt) {
        this.tblWoreda = hdt;
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
    private PanelPopup pnlPopUpMsgConf = new PanelPopup();

    public PanelPopup getPnlPopUpMsgConf() {
        return pnlPopUpMsgConf;
    }

    public void setPnlPopUpMsgConf(PanelPopup pp) {
        this.pnlPopUpMsgConf = pp;
    }
    private HtmlOutputText lblPopUpMsgMainConf = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMainConf() {
        return lblPopUpMsgMainConf;
    }

    public void setLblPopUpMsgMainConf(HtmlOutputText hot) {
        this.lblPopUpMsgMainConf = hot;
    }
    private HtmlCommandButton btnPopUpYesConf = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYesConf() {
        return btnPopUpYesConf;
    }

    public void setBtnPopUpYesConf(HtmlCommandButton hcb) {
        this.btnPopUpYesConf = hcb;
    }
    private HtmlCommandButton btnOK = new HtmlCommandButton();

    public HtmlCommandButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(HtmlCommandButton hcb) {
        this.btnOK = hcb;
    }
    private HtmlCommandButton btnPopUpNoConf = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpNoConf() {
        return btnPopUpNoConf;
    }

    public void setBtnPopUpNoConf(HtmlCommandButton hcb) {
        this.btnPopUpNoConf = hcb;
    }
    private HtmlOutputText lblErrorMassageRegion = new HtmlOutputText();

    public HtmlOutputText getLblErrorMassageRegion() {
        return lblErrorMassageRegion;
    }

    public void setLblErrorMassageRegion(HtmlOutputText hot) {
        this.lblErrorMassageRegion = hot;
    }
    private HtmlOutputText lblErrormessageForZone = new HtmlOutputText();

    public HtmlOutputText getLblErrormessageForZone() {
        return lblErrormessageForZone;
    }

    public void setLblErrormessageForZone(HtmlOutputText hot) {
        this.lblErrormessageForZone = hot;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlCommandLink linkEdit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEdit() {
        return linkEdit;
    }

    public void setLinkEdit(HtmlCommandLink hcl) {
        this.linkEdit = hcl;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LuAddressZoneOrCityAndWoredORSubCity() {
    }
    LookUpManager lookUpManager = new LookUpManager();

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
        
        clearComponents();
        disableComponents();
        btnAdd.setDisabled(true);
        linkEdit.setDisabled(true);
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
        txtWoredaId.setRequired(true);
        txtWoredaId.setRequiredMessage("Requred");
        txtWoredaName.setRequired(true);
        txtWoredaName.setRequiredMessage("Requred");
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
        //return null means stay on the same page
        if (!drlRegion.getValue().equals("0")) {
            if (!drlZoneCity.getValue().equals("0")) {
                if (!this.readWoredaOrSubCity(drlRegion.getValue().toString(), drlZoneCity.getValue().toString(), txtWoredaId.getValue().toString())||modification) {
//                    if()
                    modification=false;
                    LookUpManager addToTable = new LookUpManager(txtWoredaId.getValue().toString(),
                            txtWoredaName.getValue().toString(), txtDescription.getValue().toString());
                    this.getSessionBean1().woredaOrSubCityList.add(addToTable);
                } else {
                    pnlPopUpMsgConf.setRendered(true);
                    btnPopUpNoConf.setRendered(false);
                    btnPopUpYesConf.setRendered(false);
                    btnOK.setRendered(true);
                    lblPopUpMsgMainConf.setValue("These woreda already  Registerd.");
                }

            } else {
                lblErrormessageForZone.setValue("Requred");
                lblErrormessageForZone.setRendered(true);

            }
        } else {
            lblErrorMassageRegion.setValue("Requred");
            lblErrorMassageRegion.setRendered(true);
        }
        return null;
    }

    public String linkEdit_action() {
        //return null means stay on the same page
        int rowNumber = tblWoreda.getRowIndex();
        LookUpManager woreda = (LookUpManager) getSessionBean1().getWoredaOrSubCityList().get(rowNumber);
        getSessionBean1().getWoredaOrSubCityList().remove(rowNumber);
        txtWoredaId.setValue(woreda.getId());
        txtWoredaName.setValue(woreda.getName());
        txtDescription.setValue(woreda.getDescription());
        btnAdd.setDisabled(false);
        txtDescription.setDisabled(false);
        txtWoredaId.setDisabled(false);
        txtWoredaName.setDisabled(false);
        modification=true;

        return null;
    }

    public String linkDelete_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(true);
        lblPopUpMsgMainConf.setValue("Are you sure you want to delete");

        return null;
    }

    void clearComponents() {
        txtWoredaId.setValue("");
        txtWoredaName.setValue("");
        txtDescription.setValue("");
        drlRegion.setValue("");
        drlZoneCity.setValue("");
        getSessionBean1().woredaOrSubCityList.clear();

    }

    void disableComponents() {
        txtWoredaId.setDisabled(true);
        txtWoredaName.setDisabled(true);
        txtDescription.setDisabled(true);
        // txtRegionId.setDisabled(true);
        drlZoneCity.setDisabled(true);

    }

    void enableComponents() {
        txtWoredaId.setDisabled(false);
        txtWoredaName.setDisabled(false);
        txtDescription.setDisabled(false);
    //txtRegionId.setDisabled(false);
    //drlZoneCity.setDisabled(false);
    }

    public String btnSave_action() {
        //return null means stay on the same page
        if (btnSave.getValue().equals("New")) {
            enableComponents();
            clearComponents();
            btnSave.setValue("Save");
            btnAdd.setDisabled(false);
        } else {
            addZoneOrCityAndWoredaOrSubCity();
        }
        return null;
    }

    void addZoneOrCityAndWoredaOrSubCity() {
        String regionID = null;
        String zoneOrCityID = null;
        int checkSave = 0;

        if (drlRegion.getValue() != null) {
            regionID = drlRegion.getValue().toString().trim();
        }
        if (drlZoneCity.getValue() != null) {
            zoneOrCityID = drlZoneCity.getValue().toString().trim();
        }

        List woredaOrSubCitys = this.getSessionBean1().getWoredaOrSubCityList();
        Iterator<LookUpManager> it = woredaOrSubCitys.iterator();

        if (this.readZoneOrCity(regionID, zoneOrCityID)) {
//
            while (it.hasNext()) {
                LookUpManager woredaOrSubCity = it.next();
                if (!this.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCity.getId())) {
                    // getWoredaOrSubCityCode();
                    checkSave = lookUpManager.addWoredaOrSubCity(zoneOrCityID, woredaOrSubCity.getId(), woredaOrSubCity.getName(), woredaOrSubCity.getDescription());
                } else {
                    //  layoutPanelWoredaOrSubCityDuplication.setVisible(true);
                    //layoutPanelWoredaOrSubCityDuplication_pop.setVisible(true);
                    break;
                }
            }
            //this.regionAndZoneOrCityReset();
            if (checkSave == 1) {
                pnlPopUpMsgConf.setRendered(true);
                btnPopUpNoConf.setRendered(false);
                btnPopUpYesConf.setRendered(false);
                btnOK.setRendered(true);
                lblPopUpMsgMainConf.setValue("Woreda Registerd Successfully");
                disableComponents();
                btnAdd.setDisabled(true);
                btnSave.setValue("New");
            } else {
                pnlPopUpMsgConf.setRendered(true);
                btnPopUpNoConf.setRendered(false);
                btnPopUpYesConf.setRendered(false);
                btnOK.setRendered(true);
                lblPopUpMsgMainConf.setValue("Error occurs during woreda registration. Please try again?");
            }
        } else {
            //layoutPanelZoneOrCityIsNotFound.setVisible(true);
            pnlPopUpMsgConf.setRendered(true);
            btnPopUpNoConf.setRendered(false);
            btnPopUpYesConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue("Zone/City not Avilabel");
        }

    }

    public boolean readWoredaOrSubCity(String regionID, String zoneOrCityID, String woredaOrSubCityID) {

        if (lookUpManager.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID) == 1) {
            return true;
        } else {
            return false;
        }

    }

    public void drlRegion_processValueChange(ValueChangeEvent vce) {
        try {
            this.setOptZoneCityType(read.readZoneOrCityInARegionOptions(vce.getNewValue().toString()));
//       optZoneCityType = read.readZoneOrCityInARegion(vce.getNewValue().toString());
            drlZoneCity.setDisabled(false);
        } catch (Exception ex) {
        }
    }

    public void drlZoneCity_processValueChange(ValueChangeEvent vce) {

        int count = 0;
        count = read.coutWoredaOrSubCity(drlRegion.getValue().toString(), drlZoneCity.getValue().toString());
        if (count > 0) {

            HashMap[] listOfWoreda = read.readWoredaOrSubCity(drlRegion.getValue().toString(), drlZoneCity.getValue().toString());
            for (int i = 0; i < count; i++) {
                try {
                    LookUpManager addToTable = new LookUpManager(listOfWoreda[i].get("WOREDA_OR_SUBCITY_ID").toString(),
                            listOfWoreda[i].get("WOREDA_OR_SUBCITY_NAME").toString(), listOfWoreda[i].get("WOREDA_OR_SUBCITY_DESCRIPTION").toString());
                    this.getSessionBean1().woredaOrSubCityList.add(addToTable);
                } catch (Exception ex) {
                }
            }
        }
    }

    public boolean readZoneOrCity(String regionID, String zoneOrCityId) {
        if (lookUpManager.readZoneOrCity(regionID, zoneOrCityId) == 1) {
            return true;
        } else {
            return false;

        }
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        if (btnUpdate.getValue().equals("Edit")) {
            enableComponents();
            txtWoredaId.setDisabled(true);
            txtWoredaName.setDisabled(true);
            txtDescription.setDisabled(true);
            linkEdit.setDisabled(false);
            btnUpdate.setValue("Update");
        } else {
            String regionID = null;
            String zoneOrCity = null;
            int checkSave = 0;
            if (drlRegion.getValue() != null) {
                regionID = drlRegion.getValue().toString().trim();
            }
            if (drlZoneCity.getValue() != null) {
                zoneOrCity = drlZoneCity.getValue().toString().trim();
            }

            List woredaOrSubCitys = this.getSessionBean1().getWoredaOrSubCityList();
            Iterator<LookUpManager> it = woredaOrSubCitys.iterator();

            if (this.readZoneOrCity(regionID, zoneOrCity)) {
                lookUpManager.deleteWoredaOrSubCity(regionID, zoneOrCity);
                while (it.hasNext()) {
                    LookUpManager woredaOrSubCity = it.next();
                    checkSave = lookUpManager.addWoredaOrSubCity(zoneOrCity, woredaOrSubCity.getId(), woredaOrSubCity.getName(), woredaOrSubCity.getDescription());
                    if (checkSave != 1) {
                        checkSave = 0;
                        break;
                    }
                }
            } else {
                pnlPopUpMsgConf.setRendered(true);
                btnPopUpNoConf.setRendered(false);
                btnPopUpYesConf.setRendered(false);
                btnOK.setRendered(true);
                lblPopUpMsgMainConf.setValue("Zone id not avilabel");
            }
            if (checkSave == 1) {
                pnlPopUpMsgConf.setRendered(true);
                btnPopUpNoConf.setRendered(false);
                btnPopUpYesConf.setRendered(false);
                btnOK.setRendered(true);
                lblPopUpMsgMainConf.setValue("Woreda date updated successfully .");
                disableComponents();
                btnUpdate.setValue("Edit");
                btnAdd.setDisabled(true);
                linkEdit.setDisabled(true);
            } else {
                pnlPopUpMsgConf.setRendered(true);
                btnPopUpNoConf.setRendered(false);
                btnPopUpYesConf.setRendered(false);
                btnOK.setRendered(true);
                lblPopUpMsgMainConf.setValue("Error occured while updating woreda.Please try again ?");
            }



        }
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
        clearComponents();
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(true);
        btnPopUpNoConf.setRendered(true);
        btnPopUpYesConf.setRendered(true);
        btnOK.setRendered(false);
        lblPopUpMsgMainConf.setValue("Are you sure you want to delete?");
        return null;
    }

    public String btnPopUpYesConf_action() {
        //return null means stay on the same page
        String regionID = null;
        String zoneOrCityID = null;
        int chekDeltion = 0;
        pnlPopUpMsgConf.setRendered(false);
        if (drlRegion.getValue() != null) {
            regionID = drlRegion.getValue().toString().trim();
        }
        if (drlZoneCity.getValue() != null) {
            zoneOrCityID = drlZoneCity.getValue().toString().trim();
        }

        chekDeltion = lookUpManager.deleteWoreda(txtWoredaId.getValue().toString().trim(), zoneOrCityID);
        if (chekDeltion == 1) {
            pnlPopUpMsgConf.setRendered(true);
            btnPopUpYesConf.setRendered(false);
            btnPopUpNoConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue("The Request deleted successflly");
        } else {
            pnlPopUpMsgConf.setRendered(true);
            btnPopUpNoConf.setRendered(false);
            btnPopUpNoConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue("The Request not deleted Please try agin?");
        }
        return null;
    }

    public String btnPopUpNoConf_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(false);

        return null;
    }

    public String btnOK_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(false);
        return null;
    }

    public String cmdEmployeeProfile_action() {
        //return null means stay on the same page
        return "Woreda";
    }

    public String cmdKebelle_action() {
        //return null means stay on the same page
        return "Kebelle";
    }

    public String cmdRank_action() {
        //return null means stay on the same page
        return "PayGrade";
    }
}

