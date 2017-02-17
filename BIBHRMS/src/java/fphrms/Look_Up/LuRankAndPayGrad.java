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
import com.icesoft.faces.component.ext.HtmlGraphicImage;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.PopupBean;
import com.icesoft.faces.component.panelcollapsible.PanelCollapsible;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import fphrms.ApplicationBean1;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.globalUseManager.LookUpManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class LuRankAndPayGrad extends AbstractPageBean {

    LookUpManager lookUpManager = new LookUpManager();
    public ArrayList<SelectItem> number = new ArrayList<SelectItem>();
    ResourceBundle messageResource = null;
    FacesContext context = null;

    public ArrayList<SelectItem> getNumber() {
        return lookUpManager.assignNumber();
    }

    public void setNumber(ArrayList<SelectItem> number) {
        this.number = number;
    }
    //
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        colapCivil.addActionListener(new ActionListener() {

            public void processAction(ActionEvent ae) {
                colapCivil_processAction(ae);
            }
        });
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
    private PanelCollapsible colapCivil = new PanelCollapsible();

    public PanelCollapsible getColapCivil() {
        return colapCivil;
    }

    public void setColapCivil(PanelCollapsible pc) {
        this.colapCivil = pc;
    }
    private PanelLayout pnProfile = new PanelLayout();

    public PanelLayout getPnProfile() {
        return pnProfile;
    }

    public void setPnProfile(PanelLayout pl) {
        this.pnProfile = pl;
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
    private HtmlOutputText headMilitayAndCivil = new HtmlOutputText();

    public HtmlOutputText getHeadMilitayAndCivil() {
        return headMilitayAndCivil;
    }

    public void setHeadMilitayAndCivil(HtmlOutputText hot) {
        this.headMilitayAndCivil = hot;
    }
    private HtmlOutputText lblRankAndTitle = new HtmlOutputText();

    public HtmlOutputText getLblRankAndTitle() {
        return lblRankAndTitle;
    }

    public void setLblRankAndTitle(HtmlOutputText hot) {
        this.lblRankAndTitle = hot;
    }
    private HtmlCommandButton btnRank = new HtmlCommandButton();

    public HtmlCommandButton getBtnRank() {
        return btnRank;
    }

    public void setBtnRank(HtmlCommandButton hcb) {
        this.btnRank = hcb;
    }
    private HtmlInputText txtRank = new HtmlInputText();

    public HtmlInputText getTxtRank() {
        return txtRank;
    }

    public void setTxtRank(HtmlInputText hit) {
        this.txtRank = hit;
    }
    private HtmlInputText txtBigSalary = new HtmlInputText();

    public HtmlInputText getTxtBigSalary() {
        return txtBigSalary;
    }

    public void setTxtBigSalary(HtmlInputText hit) {
        this.txtBigSalary = hit;
    }
    private HtmlInputText txtMaxSalary = new HtmlInputText();

    public HtmlInputText getTxtMaxSalary() {
        return txtMaxSalary;
    }

    public void setTxtMaxSalary(HtmlInputText hit) {
        this.txtMaxSalary = hit;
    }
    private HtmlInputTextarea txtDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtDescription() {
        return txtDescription;
    }

    public void setTxtDescription(HtmlInputTextarea hit) {
        this.txtDescription = hit;
    }
    private HtmlSelectOneMenu drlStepNo = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlStepNo() {
        return drlStepNo;
    }

    public void setDrlStepNo(HtmlSelectOneMenu hsom) {
        this.drlStepNo = hsom;
    }
    private HtmlInputText txtSalary1 = new HtmlInputText();

    public HtmlInputText getTxtSalary1() {
        return txtSalary1;
    }

    public void setTxtSalary1(HtmlInputText hit) {
        this.txtSalary1 = hit;
    }
    private HtmlDataTable tblSalary = new HtmlDataTable();

    public HtmlDataTable getTblSalary() {
        return tblSalary;
    }

    public void setTblSalary(HtmlDataTable hdt) {
        this.tblSalary = hdt;
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
    private HtmlOutputText lblStatus = new HtmlOutputText();

    public HtmlOutputText getLblStatus() {
        return lblStatus;
    }

    public void setLblStatus(HtmlOutputText hot) {
        this.lblStatus = hot;
    }
    private PopupBean panelPopup1Bean = new PopupBean();

    public PopupBean getPanelPopup1Bean() {
        return panelPopup1Bean;
    }

    public void setPanelPopup1Bean(PopupBean pb) {
        this.panelPopup1Bean = pb;
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
    private HtmlOutputText lblPopUpMsgMainConf = new HtmlOutputText();

    public HtmlOutputText getLblPopUpMsgMainConf() {
        return lblPopUpMsgMainConf;
    }

    public void setLblPopUpMsgMainConf(HtmlOutputText hot) {
        this.lblPopUpMsgMainConf = hot;
    }
    private PanelPopup pnlPopUpMsgConf = new PanelPopup();

    public PanelPopup getPnlPopUpMsgConf() {
        return pnlPopUpMsgConf;
    }

    public void setPnlPopUpMsgConf(PanelPopup pp) {
        this.pnlPopUpMsgConf = pp;
    }
    private HtmlCommandButton btnOK = new HtmlCommandButton();

    public HtmlCommandButton getBtnOK() {
        return btnOK;
    }

    public void setBtnOK(HtmlCommandButton hcb) {
        this.btnOK = hcb;
    }
    private HtmlOutputText lblErrorMessage = new HtmlOutputText();

    public HtmlOutputText getLblErrorMessage() {
        return lblErrorMessage;
    }

    public void setLblErrorMessage(HtmlOutputText hot) {
        this.lblErrorMessage = hot;
    }
    private HtmlCommandButton btnOk = new HtmlCommandButton();

    public HtmlCommandButton getBtnOk() {
        return btnOk;
    }

    public void setBtnOk(HtmlCommandButton hcb) {
        this.btnOk = hcb;
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
    private HtmlGraphicImage imgConfirmation = new HtmlGraphicImage();

    public HtmlGraphicImage getImgConfirmation() {
        return imgConfirmation;
    }

    public void setImgConfirmation(HtmlGraphicImage hgi) {
        this.imgConfirmation = hgi;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public LuRankAndPayGrad() {
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
        imgConfirmation.setUrl("/Look_Up/images/edit-delete-icon.png");
        imgConfirmation.setValue("/Look_Up/images/edit-delete-icon.png");
        disableComponets();
        cleareComponets();
        btnAdd.setDisabled(true);
        btnUpdate.setDisabled(true);
        btnReset.setDisabled(true);
        btnDelete.setDisabled(true);
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
        txtBigSalary.setRequired(true);
        txtBigSalary.setRequiredMessage("Required");
        txtMaxSalary.setRequired(true);
        txtMaxSalary.setRequiredMessage("Required");
        drlStepNo.setRequired(true);
        drlStepNo.setRequiredMessage("Required");
        txtSalary1.setRequired(true);
        txtSalary1.setRequiredMessage("Required");
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

    public void colapCivil_processAction(ActionEvent ae) {
        colapCivil.setExpanded(true);
    }

    void cleareComponets() {
        editLinkClicked = false;
        txtBigSalary.setValue("");
        txtDescription.setValue("");
        txtMaxSalary.setValue("");
        txtSalary1.setValue("");
        drlStepNo.setValue("");
        this.getSessionBean1().getPayGradList().clear();
    }

    void disableComponets() {
        txtBigSalary.setDisabled(true);
        txtDescription.setDisabled(true);
        txtMaxSalary.setDisabled(true);
        txtSalary1.setDisabled(true);
        drlStepNo.setDisabled(true);

    }

    void enableComponets() {
        txtBigSalary.setDisabled(false);
        txtDescription.setDisabled(false);
        txtMaxSalary.setDisabled(false);
        txtRank.setDisabled(false);
        txtSalary1.setDisabled(false);
        drlStepNo.setDisabled(false);
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }
    String newOrEdit = "New";
    boolean dataOnEdit = false;
    boolean editLinkClicked = false;

    public String btnSave_action() {
        lblStatus.setRendered(false);
        if (btnSave.getValue().equals("New")) {
            newOrEdit = "New";
            btnSave.setValue("Save");
            cleareComponets();
            enableComponets();
            btnReset.setDisabled(false);
            btnAdd.setDisabled(false);
        } else {
            savePayeGrade();
        }
        return null;
    }

    void savePayeGrade() {
        if (tblSalary.getRowCount() > 0) {
            String rankID = null;
            String description = null;
            Double beginningSalary = 0.0;
            Double maxSalary = 0.0;
            String type = null;

            if (txtRank.getValue() != null) {
                rankID = txtRank.getValue().toString().trim();
            }
            if (txtBigSalary.getValue() != null) {
                beginningSalary = Double.parseDouble(txtBigSalary.getValue().toString().trim());
            }
            if (Double.parseDouble(txtMaxSalary.getValue().toString()) != 0.0) {
                maxSalary = Double.parseDouble(txtMaxSalary.getValue().toString().trim());
            }

            List payGrads = this.getSessionBean1().getPayGradList();
            //int i = 0;
            Iterator<LookUpManager> it = payGrads.iterator();
            int chackSave = 0;



            if (!this.readRank()) {
                lookUpManager.saveRank(rankID, description, beginningSalary, maxSalary, type);
                while (it.hasNext()) {
                    LookUpManager payGrad = it.next();
                    chackSave = lookUpManager.savePayGrad(rankID, Integer.toString(payGrad.getStepNo()), payGrad.getSalary());
                }
                if (chackSave == 1) {
                    lblFormMessage.setStyleClass("success");
                    lblFormMessage.setValue("Pay Grade Information Saved Successfully.");
                    showConformationMsg(getMessage().getStyleClass().toString());
                    btnAdd.setDisabled(true);
                    btnSave.setValue("New");
                    disableComponets();
                } else {
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("The attendance information is not updated.Please Try Agin?");
                    showConformationMsg(getMessage().getStyleClass().toString());

                }
            }
        } else {
            lblPopUpMsgMainConf.setRendered(true);
            pnlPopUpMsgConf.setRendered(true);
            btnPopUpYesConf.setRendered(false);
            btnPopUpNoConf.setRendered(false);
            btnOK.setRendered(true);
            lblPopUpMsgMainConf.setValue("Befor saving Rank information Please inset Pay grade ?");

        }

    }
    String databaseStatus = "Old";
    String payGradId = "-1";

    public String btnAdd_action() {
        //return null means stay on the same pageGood morning Lemma
        //
        if (editLinkClicked == true) {
            databaseStatus = "Edited";
            payGradId = "";
        } else {
            databaseStatus = "New";
        }
        int checkAvilabel = 0;
        try {
            lblErrorMessage.setRendered(false);
            lblStatus.setRendered(false);
            List payGrads = this.getSessionBean1().getPayGradList();
            Iterator<LookUpManager> it = payGrads.iterator();
            while (it.hasNext()) {
                LookUpManager payGrad = it.next();
                if (payGrad.getStepNo() == Integer.parseInt(drlStepNo.getValue().toString())) {
                    checkAvilabel = 1;
                    break;
                }
            }
            String rankID = null;
            int stepNo = 0;
            Double salary = 0.0;

            if (Double.valueOf(txtSalary1.getValue().toString()) != 0.0) {
                salary = Double.valueOf(txtSalary1.getValue().toString());
            }
            if (drlStepNo.getValue() != null) {
                stepNo = Integer.parseInt(drlStepNo.getValue().toString());
            }

            if (checkAvilabel != 1) {
                if (lookUpManager.checkPayGrade(txtRank.getValue().toString(), drlStepNo.getValue().toString()) == 0 || btnUpdate.getValue().equals("Update")) {
                    LookUpManager addToTable = new LookUpManager(databaseStatus, stepNo, salary);
                    this.getSessionBean1().addPayGradList(addToTable);
                    dataOnEdit = false;
                    editLinkClicked = false;
                } else {
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("This pay grade already available Please insert another one");
                    showConformationMsg(getMessage().getStyleClass().toString());
                }
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("This pay grade already available on the table Please insert another one");
                showConformationMsg(getMessage().getStyleClass().toString());
            }




        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public String btnReset_action() {
        //return null means stay on the same page
        lblStatus.setRendered(false);
        cleareComponets();
        txtRank.setValue("");
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");
        btnDelete.setDisabled(true);
        btnUpdate.setDisabled(true);
        disableComponets();

        return null;
    }

    public String linkEdit_action() {
        String data;
        txtSalary1.resetValue();
        int rowNumber = tblSalary.getRowIndex();
        LookUpManager payGrade = (LookUpManager) getSessionBean1().getPayGradList().get(rowNumber);
        payGradId=payGrade.getPayGradeId();
        getSessionBean1().getPayGradList().remove(rowNumber);
        editLinkClicked = true;
        if (btnSave.getValue().equals("New") && btnUpdate.getValue().equals("Edit")) {
            btnUpdate.setDisabled(false);
            btnDelete.setDisabled(false);
            btnAdd.setDisabled(true);
            drlStepNo.setDisabled(true);
            txtSalary1.setDisabled(true);
            disableComponets();
        //enableComponets();
        }
        //data = Double.toString(payGrade.getSalary());
        drlStepNo.setValue(payGrade.getStepNo());
        txtSalary1.setValue(payGrade.getSalary());
        return null;
    }
    String oldRankID;

    public String btnRank_action() {
        //return null means stay on the same page
        disableComponets();
        lblStatus.setRendered(false);
        btnUpdate.setDisabled(true);
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");
        btnAdd.setDisabled(true);
        cleareComponets();
        lodePayGrade(1);
        oldRankID = txtRank.getValue().toString().trim();
        return null;
    }

    void lodePayGrade(int perform) {
        HashMap list = null;
        list = lookUpManager.readRank(txtRank.getValue().toString().trim());
        try {
            // this.readRank()
            if (list != null) {
                txtBigSalary.setValue(list.get("BEGINNING_SALARY"));
                txtMaxSalary.setValue(list.get("MAX_SALARY"));
                txtDescription.setValue(list.get("RANK_DESCRIPTION"));
                btnReset.setDisabled(false);
                HashMap[] listpayGrade = null;
                listpayGrade = lookUpManager.readPayGrad(txtRank.getValue().toString().trim());
                btnUpdate.setDisabled(false);
                btnDelete.setDisabled(false);
                if (listpayGrade != null) {

                    for (int i = 0; i < listpayGrade.length; i++) {
                        LookUpManager addToTable = new LookUpManager(listpayGrade[i].get("ID_PAY_GRADE").toString(), listpayGrade[i].get("DATABASE_STATUS").toString(), Integer.parseInt(listpayGrade[i].get("STEP_NO").toString()), Double.parseDouble(listpayGrade[i].get("SALARY").toString()));
                        this.getSessionBean1().addPayGradList(addToTable);
                        drlStepNo.setValue(listpayGrade[0].get("STEP_NO").toString());
                        txtSalary1.setValue(listpayGrade[0].get("SALARY").toString());
                    }
                }
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("There is no Salary Scale by this Rank ID. Please insert another Rank Id and try again?");
                showConformationMsg(getMessage().getStyleClass().toString());


            }
        } catch (Exception ex) {
        }
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        if (btnUpdate.getValue().equals("Edit")) {
            btnUpdate.setValue("Update");
            this.enableComponets();
            btnAdd.setDisabled(false);
            newOrEdit = "Edit";
            dataOnEdit = false;
        } else {
            lblStatus.setRendered(false);
            String description = null;
            Double beginningSalary = 0.0;
            Double maxSalary = 0.0;
            String newRankID = null;
            int chekUpdate = 0;
            if (txtRank.getValue() != null) {
                newRankID = txtRank.getValue().toString().trim();
            }
            if (txtDescription.getValue() != null) {
                description = txtDescription.getValue().toString().trim();
            }
            if (Double.parseDouble(txtBigSalary.getValue().toString()) != 0.0) {
                beginningSalary = Double.parseDouble(txtBigSalary.getValue().toString().trim());
            }
            if (Double.parseDouble(txtMaxSalary.getValue().toString()) != 0.0) {
                maxSalary = Double.parseDouble(txtMaxSalary.getValue().toString().trim());
            }
            List payGrads = this.getSessionBean1().getPayGradList();
            Iterator<LookUpManager> it = payGrads.iterator();
            if (this.readRank()) {
//                lookUpManager.deletePayGrad(oldRankID);
//                 chekUpdate = lookUpManager.updateRank(oldRankID, newRankID, description, beginningSalary, maxSalary);
//                while (it.hasNext()) {
//                    LookUpManager payGrad = it.next();
//                    chekUpdate = lookUpManager.savePayGrad(newRankID, Integer.toString(payGrad.getStepNo()), payGrad.getSalary());
//                }
                chekUpdate = lookUpManager.updateRank(description, beginningSalary, maxSalary, "Office", oldRankID);
                for (LookUpManager current : (List<LookUpManager>) payGrads) {
                    if (current.getDatabaseStatus() != null && current.getDatabaseStatus().equals("Edited")) {
                        // (String rankID, String stepNumber, Double salary, String payGradeid) {
                        chekUpdate = lookUpManager.updatePayGrad(oldRankID, Integer.toString(current.getStepNo()), current.getSalary(), payGradId);
                    } else if (current.getDatabaseStatus() != null && current.getDatabaseStatus().equals("new")) {
                        chekUpdate = lookUpManager.savePayGrad(oldRankID, Integer.toString(current.getStepNo()), current.getSalary());
                    }
                }
                if (chekUpdate == 1) {
                    lblFormMessage.setStyleClass("success");
                    lblFormMessage.setValue("Pay Grade Information Updated Successfully .");
                    showConformationMsg(getMessage().getStyleClass().toString());
                    btnAdd.setDisabled(true);
                    disableComponets();
                } else {
                    lblFormMessage.setStyleClass("error");
                    lblFormMessage.setValue("Error occured in the updating. Please try again?");
                    showConformationMsg(getMessage().getStyleClass().toString());
                }

            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("The rank id not avilabel");
                showConformationMsg(getMessage().getStyleClass().toString());
            }

            btnUpdate.setValue("Edit");
        }

        return null;
    }

    private boolean readRank() {
        return lookUpManager.chekRank(oldRankID);
    }

    public String btnDelete_action() {
        //return null means stay on the same page
        disableComponets();
        btnAdd.setDisabled(true);
        btnSave.setValue("New");
        btnUpdate.setValue("Edit");
        lblPopUpMsgMainConf.setRendered(true);
        pnlPopUpMsgConf.setRendered(true);
        lblPopUpMsgMainConf.setValue("Are You Sure You Want to Delete");
        return null;
    }

    public void drlStepNo_processValueChange(ValueChangeEvent vce) {
    }

    public void panelGroupPopUpMsgBodyConf_processMyEvent(DragEvent de) {
    }

    public String btnPopUpYesConf_action() {
        //return null means stay on the same page
        int checkDelete = 0;
        if (this.readRank()) {
            oldRankID = txtRank.getValue().toString();
            checkDelete = lookUpManager.deletePayGrad(oldRankID);
            checkDelete = lookUpManager.deleteRank(oldRankID);
            if (checkDelete == 1) {
                lblFormMessage.setStyleClass("success");
                lblFormMessage.setValue("The Pay Grade Information Delete Susseccfully.");
                showConformationMsg(getMessage().getStyleClass().toString());
                cleareComponets();
                disableComponets();
            } else {
                lblFormMessage.setStyleClass("error");
                lblFormMessage.setValue("Error Occuer In Deleting.  Please Try agin?");
                showConformationMsg(getMessage().getStyleClass().toString());
            }

        } else {
            lblFormMessage.setStyleClass("error");
            lblFormMessage.setValue("This Rank id not avilabel.");
            showConformationMsg(getMessage().getStyleClass().toString());
        }

        pnlPopUpMsgConf.setRendered(false);
        return null;
    }

    public String btnPopUpNoConf_action() {
        pnlPopUpMsgConf.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public String btnOK_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(false);
        return null;
    }

    public String btnOk_action() {
        //return null means stay on the same page
        pnlPopUpMsgConf.setRendered(false);
        return null;
    }

    public String cmdPayGrade_action() {
        //return null means stay on the same page
        return "PayGrade";
    }

    public String cmdRegionAndZoneOrCity_action() {
        //return null means stay on the same page
        return "Region";
    }

    public String cmdWoreda_action() {
        //return null means stay on the same page
        return "Woreda";
    }

    public String cmdKebelle_action() {
        //return null means stay on the same page
        return "Kebelle";
    }

    public String cmdJobType_action() {
        //return null means stay on the same page
        return "JobType";
    }

    public String cmdjobAssignment_action() {
        //return null means stay on the same page
        return null;
    }

    public String cmdOrganizationStructur_action() {
        //return null means stay on the same page
        return "OrganizationStructure";
    }

    private void validateNumber(FacesContext context, UIComponent component, Object value) {
        try {
            String patternNumber = "^?[0-9]+(\\.[0-9]+)?$";//"^\\d+$+,+.";
            boolean matchStringText = Pattern.matches(patternNumber, (CharSequence) (value.toString()));
            if (matchStringText == false) {
                messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
                ((UIInput) component).setValid(false);
                error(component, messageResource.getString("salaryValidate"));
            }
        } catch (Exception ex) {
        }
    }

    public void txtBigSalary_validate(FacesContext context, UIComponent component, Object value) {
        validateNumber(context, component, value);
    }

    public void txtMaxSalary_validate(FacesContext context, UIComponent component, Object value) {
        validateNumber(context, component, value);
    }

    public void txtSalary1_validate(FacesContext context, UIComponent component, Object value) {
        validateNumber(context, component, value);
    }

    public void lySalaryCivil_processMyEvent(DragEvent de) {
    }

    public String button1_action() {
        //return null means stay on the same page
        return null;
    }
}

