/*
 * Page2.java
 *
 * Created on May 26, 2010, 4:18:41 AM
 * Copyright Administrator
 */
package fphrms.Look_Up;

import com.icesoft.faces.component.dragdrop.DragEvent;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import manager.globalUseManager.ErrorLogWriter;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LuAddressWoredaOrSubCityAndKebelle extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    boolean modification = false;
    private int __placeholder;

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
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
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
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    LookUpManager lookUpManager = new LookUpManager();
    Option[] region;
    Option[] optZoneCityType;
    Option[] optWoredaCity;
    String keblleID;

    public String getKeblleID() {
        return keblleID;
    }

    public void setKeblleID(String keblleID) {
        this.keblleID = keblleID;
    }

    public Option[] getOptWoredaCity() {
        return optWoredaCity;
    }

    public void setOptWoredaCity(Option[] optWoredaCity) {
        this.optWoredaCity = optWoredaCity;
    }

    public Option[] getOptZoneCityType() {
        return optZoneCityType;
    }

    public void setOptZoneCityType(Option[] optZoneCityType) {
        this.optZoneCityType = optZoneCityType;
    }

    public Option[] getRegion() {
        return region;
    }

    public void setRegion(Option[] region) {
        this.region = region;
    }
    private HtmlSelectOneMenu drlZoneOrCity = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlZoneOrCity() {
        return drlZoneOrCity;
    }

    public void setDrlZoneOrCity(HtmlSelectOneMenu hsom) {
        this.drlZoneOrCity = hsom;
    }
    private HtmlSelectOneMenu drlWoreda = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlWoreda() {
        return drlWoreda;
    }

    public void setDrlWoreda(HtmlSelectOneMenu hsom) {
        this.drlWoreda = hsom;
    }
    private HtmlSelectOneMenu drlReligon = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlReligon() {
        return drlReligon;
    }

    public void setDrlReligon(HtmlSelectOneMenu hsom) {
        this.drlReligon = hsom;
    }
    private HtmlInputText txtkebeleName = new HtmlInputText();

    public HtmlInputText getTxtkebeleName() {
        return txtkebeleName;
    }

    public void setTxtkebeleName(HtmlInputText hit) {
        this.txtkebeleName = hit;
    }
    private HtmlInputTextarea txtKabeleDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtKabeleDescription() {
        return txtKabeleDescription;
    }

    public void setTxtKabeleDescription(HtmlInputTextarea hit) {
        this.txtKabeleDescription = hit;
    }
    private HtmlOutputText lblStatus = new HtmlOutputText();

    public HtmlOutputText getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(HtmlOutputText hot) {
        this.lblStatus = hot;
    }
    private HtmlCommandButton btnAdd = new HtmlCommandButton();

    public HtmlCommandButton getBtnAdd() {
        return btnAdd;
    }

    public void setBtnAdd(HtmlCommandButton hcb) {
        this.btnAdd = hcb;
    }
    private HtmlCommandButton btnSave = new HtmlCommandButton();

    public HtmlCommandButton getBtnSave() {
        return btnSave;
    }

    public void setBtnSave(HtmlCommandButton hcb) {
        this.btnSave = hcb;
    }
    private PanelLayout panelLayout3 = new PanelLayout();

    public PanelLayout getPanelLayout3() {
        return panelLayout3;
    }

    public void setPanelLayout3(PanelLayout pl) {
        this.panelLayout3 = pl;
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
    private HtmlDataTable tblWoreda = new HtmlDataTable();

    public HtmlDataTable getTblWoreda() {
        return tblWoreda;
    }

    public void setTblWoreda(HtmlDataTable hdt) {
        this.tblWoreda = hdt;
    }
    private HtmlCommandLink linkEdit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEdit() {
        return linkEdit;
    }

    public void setLinkEdit(HtmlCommandLink hcl) {
        this.linkEdit = hcl;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
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
    private HtmlCommandButton btnPopUpNoConf = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpNoConf() {
        return btnPopUpNoConf;
    }

    public void setBtnPopUpNoConf(HtmlCommandButton hcb) {
        this.btnPopUpNoConf = hcb;
    }
    private HtmlCommandButton btnOK = new HtmlCommandButton();

    public HtmlCommandButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(HtmlCommandButton hcb) {
        this.btnOK = hcb;
    }
    private PanelLayout panelLayout1 = new PanelLayout();

    public PanelLayout getPanelLayout1() {
        return panelLayout1;
    }

    public void setPanelLayout1(PanelLayout pl) {
        this.panelLayout1 = pl;
    }
    private HtmlOutputText lblErrorMessageForReligion = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForReligion() {
        return lblErrorMessageForReligion;
    }

    public void setLblErrorMessageForReligion(HtmlOutputText hot) {
        this.lblErrorMessageForReligion = hot;
    }
    private HtmlOutputText lblErrorMessageforZone = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageforZone() {
        return lblErrorMessageforZone;
    }

    public void setLblErrorMessageforZone(HtmlOutputText hot) {
        this.lblErrorMessageforZone = hot;
    }
    private HtmlOutputText lblErrorMessageForWoreda = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessageForWoreda() {
        return lblErrorMessageForWoreda;
    }

    public void setLblErrorMessageForWoreda(HtmlOutputText hot) {
        this.lblErrorMessageForWoreda = hot;
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

    public LuAddressWoredaOrSubCityAndKebelle() {
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
        region = lookUpManager.readRegionOption();
        clearComponents();
        disableComponents();

        txtkebeleName.setRendered(true);

        txtkebeleName.setRequiredMessage("Requred");
        btnAdd.setDisabled(true);
        linkEdit.setDisabled(true);
        btnDelete.setDisabled(true);
        btnUpdate.setDisabled(true);
        lblStatus.setRendered(false);
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


        txtkebeleName.setRequired(true);
        txtkebeleName.setRequiredMessage("Requred");
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

    public void drlReligon_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForReligion.setRendered(false);
        try {
            clearComponents();
            optZoneCityType = lookUpManager.readZoneOrCityInARegionOptions(vce.getNewValue().toString());
            drlZoneOrCity.setDisabled(false);
        } catch (Exception ex) {
        }

    }

    public void drlZoneOrCity_processValueChange(ValueChangeEvent vce) {
        try {
            lblErrorMessageforZone.setRendered(false);
            clearComponents();
            optWoredaCity = lookUpManager.readKebelleInAWoredaOrSubCity(vce.getNewValue().toString());
            drlWoreda.setDisabled(false);

        } catch (Exception ex) {
        }


    }

    public String button1_action() {
        //return null means stay on the same page
        String id = null;
        String name = null;
        String description = null;


        if (txtkebeleName.getValue() != null) {
            name = txtkebeleName.getValue().toString().trim();
        }
        if (txtKabeleDescription.getValue() != null) {
            description = txtKabeleDescription.getValue().toString().trim();
        }


        LookUpManager addToTable = new LookUpManager(id, name, description);
        this.getSessionBean1().addKebele(addToTable);



//        txtfKebelleID.setText(null);
//        txtfKebelleName.setText(null);
//        txtaKebelleDescription.setValue(null);
        return null;
    }

    void clearComponents() {

        txtKabeleDescription.setValue("");

        txtkebeleName.setValue("");
        getSessionBean1().optKebele.clear();
    }

    void disableComponents() {
        txtKabeleDescription.setDisabled(true);

        txtkebeleName.setDisabled(true);
        btnAdd.setDisabled(true);
        drlWoreda.setDisabled(true);
        drlZoneOrCity.setDisabled(true);
    }

    void enableComponents() {
        txtKabeleDescription.setDisabled(false);
        txtkebeleName.setDisabled(false);
        btnAdd.setDisabled(false);
    }

    public String btnSave_action() {
        //return null means stay on the same page
        lblStatus.setRendered(false);
        if (btnSave.getValue().equals("New")) {
            btnSave.setValue("Save");
            btnUpdate.setValue("Edit");
            clearComponents();
            enableComponents();
            btnReset.setDisabled(false);
            btnAdd.setDisabled(false);
            btnUpdate.setDisabled(true);
            btnDelete.setDisabled(true);

        } else {
            if (tblWoreda.getRowCount() > 0) {
                saveKebele();
            } else {
                lblStatus.setRendered(true);
                lblStatus.setValue("Before saving the kebelle information inset kebelle information into the table ");
            }
        }
        return null;
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    void saveKebele() {

        String regionID = null;
        String zoneOrCityID = null;
        String woredaOrSubCityID = null;
        int chekSave = 0;

        if (drlReligon.getValue() != null) {
            regionID = drlReligon.getValue().toString().trim();
        }
        if (drlZoneOrCity.getValue() != null) {
            zoneOrCityID = drlZoneOrCity.getValue().toString().trim();
        }
        if (drlWoreda.getValue() != null) {
            woredaOrSubCityID = drlWoreda.getValue().toString().trim();
        }

        List kebelles = this.getSessionBean1().getOptKebele();
        Iterator<LookUpManager> it = kebelles.iterator();
        if (this.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID)) {
            while (it.hasNext()) {
                LookUpManager kebelle = it.next();
                if (lookUpManager.checkKebelleAvilabel(regionID, zoneOrCityID, woredaOrSubCityID, kebelle.getId()) != 1) {
                    chekSave = lookUpManager.addkebelle(woredaOrSubCityID, kebelle.getId(), kebelle.getName(), kebelle.getDescription());
                } else {

                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("There is already kebelle available by this ID!");
                    showConformationMsg(getMessage().getStyleClass().toString());

                    break;
                }
            }

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("Error occured while saving kebelle.Please try again.");
            showConformationMsg(getMessage().getStyleClass().toString());
        }
        if (chekSave == 1) {
            lblFormMessage.setStyleClass("success");
            lblFormMessage.setValue("kebelle" + txtkebeleName.getValue().toString() + " Saved Successfully  !");
            showConformationMsg(getMessage().getStyleClass().toString());
//            lblStatus.setRendered(true);
//            lblStatus.setValue("kebelle" + txtkebeleName.getValue().toString() + " Saved Successfully  !");
            disableComponents();
            btnSave.setValue("New");
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("kebelle" + txtkebeleName.getValue().toString() + " Saved Successfully  !");
            showConformationMsg(getMessage().getStyleClass().toString());
//            lblStatus.setRendered(true);
//            lblStatus.setValue("Error Occured during saving .Please Try Again?");
        }
    }

    public boolean readWoredaOrSubCity(String regionID, String zoneOrCityID, String woredaOrSubCityID) {

        try {
            if (lookUpManager.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID) == 1) {
                return true;
            }
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
            return false;
        }
    }

    private boolean readkebelle(String regionID, String zoneOrCityID, String woredaOrSubCityID, String kebelleID) {
        try {
            if (lookUpManager.readkebelle(regionID, zoneOrCityID, woredaOrSubCityID, kebelleID) == 1) {
                return true;
            }
            return false;
        } catch (Exception ex) {

            return false;
        }

    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        int chekUpdate = 0;
        if (btnUpdate.getValue().equals("Edit")) {
            btnUpdate.setValue("Update");
            this.enableComponents();
            enableComponents();
            txtkebeleName.setDisabled(true);
            txtKabeleDescription.setDisabled(true);
            linkEdit.setDisabled(false);
            btnAdd.setDisabled(true);


        } else {
            String regionID = null;
            String zoneOrCityID = null;
            String woredaOrSubCityID = null;

            if (drlReligon.getValue() != null) {
                regionID = drlReligon.getValue().toString().trim();
            }
            if (drlZoneOrCity.getValue() != null) {
                zoneOrCityID = drlZoneOrCity.getValue().toString().trim();
            }
            if (drlWoreda.getValue() != null) {
                woredaOrSubCityID = drlWoreda.getValue().toString().trim();
            }

            List kebelles = this.getSessionBean1().getOptKebele();
            Iterator<LookUpManager> it = kebelles.iterator();

            if (this.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID)) {


                while (it.hasNext()) {
                    LookUpManager kebelle = it.next();
                    lookUpManager.deletekebelle(kebelle.getId());
                    chekUpdate = lookUpManager.addkebelle(woredaOrSubCityID, kebelle.getId(), kebelle.getName(), kebelle.getDescription());
                    if (chekUpdate == 0) {
                        break;
                    }

                }
            } else {
            }
            if (chekUpdate == 1) {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("kebelle Information Updated Successfully!");
                showConformationMsg(getMessage().getStyleClass().toString());
//                lblStatus.setRendered(true);
//                lblStatus.setValue("kebelle Information Updated Successfully!");
                disableComponents();
                btnUpdate.setValue("Edit");
                linkEdit.setDisabled(true);

            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("Error Occured during Updating .Please Try Again?");
                showConformationMsg(getMessage().getStyleClass().toString());
//                lblStatus.setRendered(true);
//                lblStatus.setValue("Error Occured during Updating .Please Try Again?");
            }

        }
        return null;
    }

    public void drlWoreda_processValueChange(ValueChangeEvent vce) {
        lblErrorMessageForWoreda.setRendered(false);
        clearComponents();
        String regionID = null;
        String zoneOrCityID = null;
        String woredaOrSubCityID = null;

        if (btnSave.getValue().equals("New")) {
            if (drlReligon.getValue() != null) {
                regionID = drlReligon.getValue().toString().trim();
            }
            if (drlZoneOrCity.getValue() != null) {
                zoneOrCityID = drlZoneOrCity.getValue().toString().trim();
            }

            woredaOrSubCityID = (String) vce.getNewValue();

            //lookUpManager.readWoredaOrSubCity(regionID, zoneOrCityID, woredaOrSubCityID);

            int count = lookUpManager.countKebelleUsing(regionID, zoneOrCityID, woredaOrSubCityID);


            try {
                if (count > 0) {
                    btnUpdate.setDisabled(false);
                    btnDelete.setDisabled(false);
                    HashMap[] kebelleList = lookUpManager.readKebelle(regionID, zoneOrCityID, woredaOrSubCityID);
                    //                this.txtfWoredaOrSubCityName.setText(rsWoredaOrSubCity.getString("woreda_Or_Sub_City_Name"));
////                this.txtaWoredaOrSubCityDescription.setText(rsWoredaOrSubCity.getString("woreda_Or_Sub_City_Description"));

//                this.getSessionBean1().getOptKebele().clear();



                    for (int i = 0; i < count; i++) {
                        LookUpManager addToTable = new LookUpManager(kebelleList[i].get("KEBELLE_ID").toString(), kebelleList[i].get("KEBELLE_NAME").toString(), kebelleList[i].get("KEBELLE_DESCRIPTION").toString());
                        this.getSessionBean1().addKebele(addToTable);
                    }
                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
        }
    }

    public String linkEdit_action() {
        //return null means stay on the same page
        int rowNumber = tblWoreda.getRowIndex();
        LookUpManager kebelle = (LookUpManager) getSessionBean1().getOptKebele().get(rowNumber);
        getSessionBean1().getOptKebele().remove(rowNumber);
        this.setKeblleID(kebelle.getId());
        txtkebeleName.setValue(kebelle.getName());
        txtKabeleDescription.setValue(kebelle.getDescription());

        txtkebeleName.setDisabled(false);
        txtKabeleDescription.setDisabled(false);
        btnAdd.setDisabled(false);
        modification = true;
        return null;
    }

    public void page_display_processMyEvent(DragEvent de) {
    }

    public String btnReset_action() {
        //return null means stay on the same page
        clearComponents();
        drlReligon.setValue("");
        drlWoreda.setValue("");
        drlZoneOrCity.setValue("");
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(true);
        btnPopUpNoConf.setRendered(true);
        btnPopUpYesConf.setRendered(true);
        btnOK.setRendered(false);
        lblPopUpMsgMainConf.setValue("Are You Sure You Want to Delete");
        return null;
    }

    public void panelGroupPopUpMsgBodyConf_processMyEvent(DragEvent de) {
    }

    public String btnPopUpYesConf_action() {
        //return null means stay on the same page
        int chekSave = 0;
        List kebelles = this.getSessionBean1().getOptKebele();
        Iterator<LookUpManager> it = kebelles.iterator();

        while (it.hasNext()) {
            LookUpManager kebelle = it.next();
            chekSave = lookUpManager.deletekebelle(kebelle.getId());
        }
        if (chekSave == 1) {
            pnlPopUpMsgConf.setRendered(true);
            btnPopUpNoConf.setRendered(false);
            btnPopUpYesConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue(" Woreda/ Sub City " + drlWoreda.getValue().toString() + "Information Successfully Deleted");
            clearComponents();
            disableComponents();

        } else {
            btnPopUpNoConf.setRendered(false);
            btnPopUpYesConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue("Error Occured during Deleting .Please Try Again?");
            pnlPopUpMsgConf.setRendered(true);
            pnlPopUpMsgConf.setRendered(true);
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

    public String btnAdd_action() {
        //return null means stay on the same page

        String name = null;
        String description = null;


        if (txtkebeleName.getValue() != null) {
            name = txtkebeleName.getValue().toString().trim();
        }
        if (txtKabeleDescription.getValue() != null) {
            description = txtKabeleDescription.getValue().toString().trim();
        }

        if (!drlReligon.getValue().equals("0")) {
            lblErrorMessageForReligion.setRendered(false);
            if (!drlZoneOrCity.getValue().equals("0")) {
                if (!drlWoreda.getValue().equals("0")) {
                    if (lookUpManager.checkKebelleAvilabel(drlReligon.getValue().toString(), drlZoneOrCity.getValue().toString(), drlWoreda.getValue().toString(), this.getKeblleID()) != 1 || modification) {
                        modification = false;
                        lblErrorMessageForWoreda.setRendered(false);
                        lblErrorMessageforZone.setRendered(false);
                        LookUpManager addToTable = new LookUpManager(this.getKeblleID(), name, description);
                        this.getSessionBean1().addKebele(addToTable);
                    } else {
                        lblStatus.setRendered(true);
                        lblStatus.setValue("There is already kebelle available by this ID!");
                    }
                } else {
                    lblErrorMessageForWoreda.setValue("Requred");
                    lblErrorMessageForWoreda.setRendered(true);
                }
            } else {
                lblErrorMessageforZone.setValue("Requred");
                lblErrorMessageforZone.setRendered(true);

            }
//            this.getSessionBean1().addKebelleList(luCtrl.addKebelleObj(id, name, description));
        } else {
            lblErrorMessageForReligion.setValue("Requred");
            lblErrorMessageForReligion.setRendered(true);
        }

//        txtfKebelleID.setText(null);
//        txtfKebelleName.setText(null);
//        txtaKebelleDescription.setValue(null);
        return null;
    }

    public String linkDelete_action() {
        //return null means stay on the same page
        int checkDelete = 0;
        int rowNumber = tblWoreda.getRowIndex();
        LookUpManager kebelle = (LookUpManager) getSessionBean1().getOptKebele().get(rowNumber);

        // txtKebele.setValue(kebelle.getId());
        checkDelete = lookUpManager.deletekebelle(kebelle.getId());
        if (checkDelete == 1) {
            getSessionBean1().getOptKebele().remove(rowNumber);
        } else {
        }
        return null;
    }

    public String cmdRegionAndZoneOrCity_action() {
        //return null means stay on the same page
        return "Region";
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

