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
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import javax.faces.FacesException;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LuAddressRegionAndZoneOrCity extends AbstractPageBean {

    boolean chekSave = true;
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private HtmlInputText txtRegionId = new HtmlInputText();

    public HtmlInputText getTxtRegionId() {
        return txtRegionId;
    }

    public void setTxtRegionId(HtmlInputText hit) {
        this.txtRegionId = hit;
    }
    private HtmlInputText txtRegionName = new HtmlInputText();

    public HtmlInputText getTxtRegionName() {
        return txtRegionName;
    }

    public void setTxtRegionName(HtmlInputText hit) {
        this.txtRegionName = hit;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
    }
    private HtmlInputText txtZoneCityId = new HtmlInputText();

    public HtmlInputText getTxtZoneCityId() {
        return txtZoneCityId;
    }

    public void setTxtZoneCityId(HtmlInputText hit) {
        this.txtZoneCityId = hit;
    }
    private HtmlInputText txtZoneCityName = new HtmlInputText();

    public HtmlInputText getTxtZoneCityName() {
        return txtZoneCityName;
    }

    public void setTxtZoneCityName(HtmlInputText hit) {
        this.txtZoneCityName = hit;
    }
    private HtmlInputTextarea txtZoneCityDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtZoneCityDescription() {
        return txtZoneCityDescription;
    }

    public void setTxtZoneCityDescription(HtmlInputTextarea hit) {
        this.txtZoneCityDescription = hit;
    }
    private UIColumn column2 = new UIColumn();

    public UIColumn getColumn2() {
        return column2;
    }

    public void setColumn2(UIColumn uic) {
        this.column2 = uic;
    }
    private HtmlDataTable tblZoneCity = new HtmlDataTable();

    public HtmlDataTable getTblZoneCity() {
        return tblZoneCity;
    }

    public void setTblZoneCity(HtmlDataTable hdt) {
        this.tblZoneCity = hdt;
    }
    private HtmlCommandButton btnAddZoneCity = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddZoneCity() {
        return btnAddZoneCity;
    }

    public void setBtnAddZoneCity(HtmlCommandButton hcb) {
        this.btnAddZoneCity = hcb;
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
    private HtmlCommandLink linkEdit = new HtmlCommandLink();

    public HtmlCommandLink getLinkEdit() {
        return linkEdit;
    }

    public void setLinkEdit(HtmlCommandLink hcl) {
        this.linkEdit = hcl;
    }
    private HtmlCommandButton btnPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpYes() {
        return btnPopUpYes;
    }

    public void setBtnPopUpYes(HtmlCommandButton hcb) {
        this.btnPopUpYes = hcb;
    }
    private HtmlCommandButton btnPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpNo() {
        return btnPopUpNo;
    }

    public void setBtnPopUpNo(HtmlCommandButton hcb) {
        this.btnPopUpNo = hcb;
    }
    private HtmlOutputText lblPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMain() {
        return lblPopUpMsgMain;
    }

    public void setLblPopUpMsgMain(HtmlOutputText hot) {
        this.lblPopUpMsgMain = hot;
    }
    private PanelPopup pnlPopUpMsg = new PanelPopup();

    public PanelPopup getPnlPopUpMsg() {
        return pnlPopUpMsg;
    }

    public void setPnlPopUpMsg(PanelPopup pp) {
        this.pnlPopUpMsg = pp;
    }
    private HtmlCommandButton btnPopUpOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnPopUpOk() {
        return btnPopUpOk;
    }

    public void setBtnPopUpOk(HtmlCommandButton hcb) {
        this.btnPopUpOk = hcb;
    }
    private HtmlOutputText lblErrorMessage = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessage() {
        return lblErrorMessage;
    }

    public void setLblErrorMessage(HtmlOutputText hot) {
        this.lblErrorMessage = hot;
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


    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LuAddressRegionAndZoneOrCity() {
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
        disableComponents();
        clearComponents();
        linkEdit.setDisabled(true);
        btnAddZoneCity.setDisabled(true);

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

        txtRegionName.setRendered(true);
        txtRegionName.setRequiredMessage("Requred");
        txtZoneCityId.setRendered(true);
        txtZoneCityId.setRequiredMessage("Requred");
        txtZoneCityName.setRendered(true);
        txtZoneCityName.setRequiredMessage("Requred");
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
    LookUpManager lookUpManager = new LookUpManager();

    public void page_display_processMyEvent(DragEvent de) {
    }

    public String btnAddZoneCity_action() {
        //return null means stay on the same page
        int checkAvilabel = 0;
        List zoneOrCity = this.getSessionBean1().getZoneOrCityList();
        Iterator<LookUpManager> it = zoneOrCity.iterator();
        while (it.hasNext()) {
            LookUpManager zoneIt = it.next();
            if (zoneIt.getId().equals(txtZoneCityId.getValue().toString())) {
                checkAvilabel = 1;
                break;
            }
        }
        if (checkAvilabel != 1) {
            if (lookUpManager.checkZoneAvilabel(txtRegionId.getValue().toString(), txtZoneCityId.getValue().toString()) == 0 || btnUpdate.getValue().equals("Update")) {

                LookUpManager addToTable = new LookUpManager(txtZoneCityId.getValue().toString(),
                        txtZoneCityName.getValue().toString(), txtZoneCityDescription.getValue().toString());
                this.getSessionBean1().zoneOrCityList.add(addToTable);
                linkEdit.setDisabled(false);
//               
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("This Zone/City  already registered Please insert another one");
                showConformationMsg(getMessage().getStyleClass().toString());
            }
        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("This Zone/City  already available on the table Please insert another one");
            showConformationMsg(getMessage().getStyleClass().toString());
        }


        return null;
    }

    public String linkEdit_action() {
        //return null means stay on the same page
        int rowNumber = tblZoneCity.getRowIndex();
        LookUpManager zoneOzity = (LookUpManager) getSessionBean1().getZoneOrCityList().get(rowNumber);
        getSessionBean1().getZoneOrCityList().remove(rowNumber);
        txtZoneCityId.setValue(zoneOzity.getId());
        txtZoneCityName.setValue(zoneOzity.getName());
        txtZoneCityDescription.setValue(zoneOzity.getDescription());
        txtZoneCityId.setDisabled(false);
        txtZoneCityName.setDisabled(false);
        txtZoneCityDescription.setDisabled(false);
        btnAddZoneCity.setDisabled(false);
        return null;
    }

    void clearComponents() {
        txtZoneCityId.setValue("");
        txtZoneCityName.setValue("");
        txtZoneCityDescription.setValue("");
        txtRegionName.setValue("");
        txtDescription.setValue("");
        getSessionBean1().zoneOrCityList.clear();

    }

    void disableComponents() {
        txtZoneCityId.setDisabled(true);
        txtZoneCityName.setDisabled(true);
        txtZoneCityDescription.setDisabled(true);
        // txtRegionId.setDisabled(true);
        txtRegionName.setDisabled(true);
        txtDescription.setDisabled(true);
    }

    void enableComponents() {
        txtZoneCityId.setDisabled(false);
        txtZoneCityName.setDisabled(false);
        txtZoneCityDescription.setDisabled(false);
        //txtRegionId.setDisabled(false);
        txtRegionName.setDisabled(false);
        txtDescription.setDisabled(false);
    }

    public String btnSave_action() {
        //return null means stay on the same page
        if (btnSave.getValue().equals("New")) {
            enableComponents();
            clearComponents();
            btnSave.setValue("Save");
            btnAddZoneCity.setDisabled(false);
        } else {
            if (txtRegionId.getValue() != null) {
                saveRegionAndZoneOrCity();
            } else {

                lblErrorMessage.setRendered(true);
                lblErrorMessage.setValue("Requred");
            }
        }
        return null;
    }

    void saveRegionAndZoneOrCity() {
        String regionID = null;
        String regionName = null;
        String regionDescription = null;
        int checkSave = 1;

        if (txtRegionId.getValue() != null) {
            regionID = txtRegionId.getValue().toString().trim();
        }
        if (txtRegionName.getValue() != null) {
            regionName = txtRegionName.getValue().toString().trim();
        }
        if (txtDescription.getValue() != null) {
            regionDescription = txtDescription.getValue().toString().trim();
        }


        if (!this.readRegion(regionID)) {
            checkSave = lookUpManager.addRegion(regionID, regionName, regionDescription);
        }
        if (checkSave == 1) {
            List zoneOrCitys = this.getSessionBean1().getZoneOrCityList();
            Iterator<LookUpManager> it = zoneOrCitys.iterator();
            while (it.hasNext()) {
                LookUpManager zoneOrCity = it.next();
                checkSave = lookUpManager.addZoneOrCity(regionID, zoneOrCity.getId(), zoneOrCity.getName(), zoneOrCity.getDescription());
                if (checkSave == 0) {
                    break;
                }
            }
            if (checkSave == 1) {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("Region and Zone/City Information Saved Successfully.");
                showConformationMsg(getMessage().getStyleClass().toString());
//                lblPopUpMsgMain.setValue("Region Zone/City Saved Successfully");
//                pnlPopUpMsg.setRendered(true);
//                btnPopUpNo.setRendered(false);
//                btnPopUpYes.setRendered(false);
//                btnPopUpOk.setRendered(true);
                btnSave.setValue("New");
                btnAddZoneCity.setDisabled(false);
                disableComponents();

            } else {
                lblPopUpMsgMain.setValue("Not Saved Please Try Agin");
                pnlPopUpMsg.setRendered(true);
                btnPopUpNo.setRendered(false);
                btnPopUpYes.setRendered(false);
                btnPopUpOk.setRendered(true);
            }
        } else {
        }


    }

    private boolean readRegion(String regionID) {
        if (lookUpManager.countRegion(regionID) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public String btnUpdate_action() {

        //return null means stay on the same page
        if (txtRegionId.getValue() != null) {
            if (btnUpdate.getValue().equals("Edit")) {
                enableComponents();
                btnUpdate.setValue("Update");
                if (tblZoneCity.getRowCount() > 0) {
                    txtZoneCityId.setDisabled(true);
                    txtZoneCityName.setDisabled(true);
                    txtZoneCityDescription.setDisabled(true);
                    linkEdit.setDisabled(false);
                } else {
                    btnAddZoneCity.setDisabled(false);
                }

            } else if (btnUpdate.getValue().equals("Update")) {

                if (tblZoneCity.getRowCount() > 0) {
                    txtZoneCityId.setRendered(false);
                    txtZoneCityName.setRendered(false);
                    updateRegionAndZoneOrCity();
                } else {
                    String regionID = null;
                    String regionName = null;
                    String regionDescription = null;
                    if (txtRegionId.getValue() != null) {
                        regionID = txtRegionId.getValue().toString().trim();
                    }

                    if (txtRegionName.getValue() != null) {
                        regionName = txtRegionName.getValue().toString().trim();
                    }

                    if (txtDescription.getValue() != null) {
                        regionDescription = txtDescription.getValue().toString().trim();
                    }
                    if (lookUpManager.updateRegion(regionID, regionName, regionDescription) == 1) {
                        lblFormMessage.setStyleClass("success");
                        lblFormMessage.setValue("Region  information updated Successfully");
                         showConformationMsg(getMessage().getStyleClass().toString());
                         disableComponents();
                    } else {
                        lblFormMessage.setStyleClass("error");
                        lblFormMessage.setValue("Region  information not updated ");
                         showConformationMsg(getMessage().getStyleClass().toString());

                    }

                }

            }
        } else {
        }

        return null;
    }

    void updateRegionAndZoneOrCity() {
        String regionID = null;
        String regionName = null;
        String regionDescription = null;
        int chekUpdate = 0;

        if (txtRegionId.getValue() != null) {
            regionID = txtRegionId.getValue().toString().trim();
        }

        if (txtRegionName.getValue() != null) {
            regionName = txtRegionName.getValue().toString().trim();
        }

        if (txtDescription.getValue() != null) {
            regionDescription = txtDescription.getValue().toString().trim();
        }

        List zoneOrCitys = this.getSessionBean1().getZoneOrCityList();
        Iterator<LookUpManager> it = zoneOrCitys.iterator();

        if (lookUpManager.deleteZoneOrCity(regionID) == 1 || lookUpManager.checkZoneAvilabel(txtRegionId.getValue().toString()) == 0) {
            if (lookUpManager.updateRegion(regionID, regionName, regionDescription) == 1) {
                while (it.hasNext()) {
                    LookUpManager zoneOrCity = it.next();
                    chekUpdate = lookUpManager.addZoneOrCity(regionID, zoneOrCity);
                }
                if (chekUpdate == 1) {
                    lblFormMessage.setStyleClass("success");
                    lblFormMessage.setValue("Region and  Zone/City information updated Successfully");
                    showConformationMsg(getMessage().getStyleClass().toString());
//                    lblPopUpMsgMain.setValue("Region Zone/City Modified Successfully");
//                    pnlPopUpMsg.setRendered(true);
//                    btnPopUpNo.setRendered(false);
//                    btnPopUpYes.setRendered(false);
//                    btnPopUpOk.setRendered(true);
                    btnUpdate.setValue("Edit");
                    btnAddZoneCity.setDisabled(true);
                    disableComponents();
                    linkEdit.setDisabled(true);

                } else {
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("Error occur while Updating Region Zone/City. Please Try Again?");
                    showConformationMsg(getMessage().getStyleClass().toString());


//                    lblPopUpMsgMain.setValue("Error occur while Updating Region Zone/City. Please Try Again?");
//                    pnlPopUpMsg.setRendered(true);
//                    btnPopUpNo.setRendered(false);
//                    btnPopUpYes.setRendered(false);
//                    btnPopUpOk.setRendered(true);

                }
            }
        }

    }

    public String btnReset_action() {
        //return null means stay on the same page
        clearComponents();
        disableComponents();
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        txtRegionId.setValue("");
        return null;
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        lblPopUpMsgMain.setValue("Are you sure you want to delete?");
        pnlPopUpMsg.setRendered(true);
        btnPopUpNo.setRendered(true);
        btnPopUpYes.setRendered(true);
        btnPopUpOk.setRendered(false);
        return null;
    }

    public String btnPopUpYes_action() {
        //return null means stay on the same page
        if (lookUpManager.deleteZoneOrCity(txtRegionId.getValue().toString().trim()) == 1) {
            if (lookUpManager.deleteRegion(txtRegionId.getValue().toString().trim()) == 1) {

                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("City  and Region Information Successfully deleted");
                showConformationMsg(getMessage().getStyleClass().toString());

                clearComponents();
                disableComponents();


            } else {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("Region Information Successfully deleted");
                showConformationMsg(getMessage().getStyleClass().toString());
            }

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("City  and Region Information not deleted. please try agin?");
            showConformationMsg(getMessage().getStyleClass().toString());

        }
        return null;
    }

    public String btnPopUpNo_action() {
        //return null means stay on the same page
        pnlPopUpMsg.setRendered(false);
        return null;
    }

    public String btnPopUpOk_action() {
        //return null means stay on the same page
        pnlPopUpMsg.setRendered(false);
        return null;
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    public String button1_action() {
        //return null means stay on the same page
        disableComponents();
        clearComponents();
        btnUpdate.setDisabled(true);
        btnDelete.setDisabled(true);
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");
        // btnAdd.setDisabled(true);
        this.loadeRegion(txtRegionId.getValue().toString());
        return null;
    }

    void loadeRegion(String regionId) {

        HashMap regdate = lookUpManager.readRegion(regionId);
        if (regdate != null) {
            txtDescription.setValue(regdate.get("REGION_DESCRIPTION"));
            txtRegionName.setValue(regdate.get("REGION_NAME"));
            int count = lookUpManager.CoutZoneOrCity(regionId);
            btnDelete.setDisabled(false);
            btnUpdate.setDisabled(false);
            if (count > 0) {

                HashMap[] list = lookUpManager.readZoneOrCity(regionId);
                for (int i = 0; i < count; i++) {
                    try {

                        LookUpManager addTotabele = new LookUpManager(
                                list[i].get("ZONE_OR_CITY_ID").toString(),
                                list[i].get("ZONE_OR_CITY_NAME").toString(), list[i].get("ZONE_OR_CITY_DESCRIPTION").toString());
                        this.getSessionBean1().addZoneOrCityList(addTotabele);

                    } catch (Exception ex) {
                        ex.printStackTrace();
                        ex.getMessage();
                    }

                }
                txtZoneCityId.setValue(list[0].get("ZONE_OR_CITY_ID"));
                txtZoneCityName.setValue(list[0].get("ZONE_OR_CITY_NAME"));
                txtZoneCityDescription.setValue(list[0].get("ZONE_OR_CITY_DESCRIPTION"));

            }
        } else {

            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("There is no Region by this Id. Please insert another Region Id and try again?");
            showConformationMsg(getMessage().getStyleClass().toString());

        }


    }

    public String txtRegionId_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnPopUpNoConf_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnOK_action() {
        //return null means stay on the same page
        pnlPopUpMsg.setRendered(false);

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

    public void button1_processAction(ActionEvent ae) {
    }
}

