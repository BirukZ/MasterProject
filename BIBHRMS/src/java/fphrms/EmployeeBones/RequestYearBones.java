/*
 * EmployeeYearBones.java
 *
 * Created on Dec 18, 2012, 2:26:45 PM
 * Copyright Administrator
 */
package fphrms.EmployeeBones;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.RequestBean1;
import fphrms.SessionBean1;
import fphrms.ApplicationBean1;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import lookUps.BonesLookup;
import manager.employeeBonesManager.RequestYearBonesManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class RequestYearBones extends AbstractPageBean {
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
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();
    private ArrayList<RequestYearBonesManager> listOfEmployee = new ArrayList<RequestYearBonesManager>();
    private ArrayList<SelectItem> prerviousRequestList = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listOfLocation = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listOfBones = new ArrayList<SelectItem>();
    private ArrayList<SelectItem> listOfYear = new ArrayList<SelectItem>();
    private RequestYearBonesManager requestYearBonesManager = null;
    private String requesterId;
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    private int selectedBonesRequest = -1;

    public ArrayList<SelectItem> getPrerviousRequestList() {

        return prerviousRequestList;
    }

    public void setPrerviousRequestList(ArrayList<SelectItem> prerviousRequestList) {
        this.prerviousRequestList = prerviousRequestList;
    }

    public ArrayList<SelectItem> getListOfYear() {
        return listOfYear;
    }

    public void setListOfYear(ArrayList<SelectItem> listOfYear) {
        this.listOfYear = listOfYear;
    }

    public ArrayList<SelectItem> getListOfBones() {
        return listOfBones;
    }

    public void setListOfBones(ArrayList<SelectItem> listOfBones) {
        this.listOfBones = listOfBones;
    }

    public ArrayList<SelectItem> getListOfLocation() {
        return listOfLocation;
    }

    public void setListOfLocation(ArrayList<SelectItem> listOfLocation) {
        this.listOfLocation = listOfLocation;
    }

    public ArrayList<RequestYearBonesManager> getListOfEmployee() {
        return listOfEmployee;
    }

    public void setListOfEmployee(ArrayList<RequestYearBonesManager> listOfEmployee) {
        this.listOfEmployee = listOfEmployee;
    }

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private BonesLookup places = null;
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectedData selectOneMenu4Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu4Bean() {
        return selectOneMenu4Bean;
    }

    public void setSelectOneMenu4Bean(DefaultSelectedData dsd) {
        this.selectOneMenu4Bean = dsd;
    }
    private HtmlSelectOneMenu drlPrepareIn = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPrepareIn() {
        return drlPrepareIn;
    }

    public void setDrlPrepareIn(HtmlSelectOneMenu hsom) {
        this.drlPrepareIn = hsom;
    }
    private HtmlOutputText txtEmployeeNumber = new HtmlOutputText();

    public HtmlOutputText getTxtEmployeeNumber() {
        return txtEmployeeNumber;
    }

    public void setTxtEmployeeNumber(HtmlOutputText hot) {
        this.txtEmployeeNumber = hot;
    }
    private HtmlSelectOneMenu drlBonesAmount = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBonesAmount() {
        return drlBonesAmount;
    }

    public void setDrlBonesAmount(HtmlSelectOneMenu hsom) {
        this.drlBonesAmount = hsom;
    }
    private HtmlInputText txtEvaluationTo = new HtmlInputText();

    public HtmlInputText getTxtEvaluationTo() {
        return txtEvaluationTo;
    }

    public void setTxtEvaluationTo(HtmlInputText hit) {
        this.txtEvaluationTo = hit;
    }
    private HtmlCommandButton btnUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnUpdate() {
        return btnUpdate;
    }

    public void setBtnUpdate(HtmlCommandButton hcb) {
        this.btnUpdate = hcb;
    }
    private HtmlSelectOneMenu drlBonusYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBonusYear() {
        return drlBonusYear;
    }

    public void setDrlBonusYear(HtmlSelectOneMenu hsom) {
        this.drlBonusYear = hsom;
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
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }
    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputText lblDecider_Department = new HtmlOutputText();

    public HtmlOutputText getLblDecider_Department() {
        return lblDecider_Department;
    }

    public void setLblDecider_Department(HtmlOutputText hot) {
        this.lblDecider_Department = hot;
    }
    private HtmlOutputText lblEmployeeFullName = new HtmlOutputText();

    public HtmlOutputText getLblEmployeeFullName() {
        return lblEmployeeFullName;
    }

    public void setLblEmployeeFullName(HtmlOutputText hot) {
        this.lblEmployeeFullName = hot;
    }
    private HtmlOutputText lblDeciderPosition = new HtmlOutputText();

    public HtmlOutputText getLblDeciderPosition() {
        return lblDeciderPosition;
    }

    public void setLblDeciderPosition(HtmlOutputText hot) {
        this.lblDeciderPosition = hot;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private DefaultSelectedData defaultSelectedData2 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData2() {
        return defaultSelectedData2;
    }

    public void setDefaultSelectedData2(DefaultSelectedData dsd) {
        this.defaultSelectedData2 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlCommandButton btnRequest = new HtmlCommandButton();

    public HtmlCommandButton getBtnRequest() {
        return btnRequest;
    }

    public void setBtnRequest(HtmlCommandButton hcb) {
        this.btnRequest = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDate calEvaluationFrom = new SelectInputDate();

    public SelectInputDate getCalEvaluationFrom() {
        return calEvaluationFrom;
    }

    public void setCalEvaluationFrom(SelectInputDate sid) {
        this.calEvaluationFrom = sid;
    }
    private SelectInputDate calEvaluationTo = new SelectInputDate();

    public SelectInputDate getCalEvaluationTo() {
        return calEvaluationTo;
    }

    public void setCalEvaluationTo(SelectInputDate sid) {
        this.calEvaluationTo = sid;
    }
    private HtmlInputText txtEvaluationFrom = new HtmlInputText();

    public HtmlInputText getTxtEvaluationFrom() {
        return txtEvaluationFrom;
    }

    public void setTxtEvaluationFrom(HtmlInputText hit) {
        this.txtEvaluationFrom = hit;
    }
    private HtmlCommandButton bntRemove = new HtmlCommandButton();

    public HtmlCommandButton getBntRemove() {
        return bntRemove;
    }

    public void setBntRemove(HtmlCommandButton hcb) {
        this.bntRemove = hcb;
    }

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public RequestYearBones() {
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
//        ResponseStateManager rsm = FacesContext.getCurrentInstance().getRenderKit().getResponseStateManager();
//        if (rsm.isPostback(FacesContext.getCurrentInstance())) {
        callObj();
        setListOfLocation(places.listOfPlace());
        setListOfBones(places.listOfBonesAmout());
        setListOfYear(places.listOfBonesYear());
        requesterId = getSessionBean1().getEmployeeId();
        bntRemove.setDisabled(true);
//        }
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
            log("EmployeeYearBones Initialization Failure", e);
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

    private void callObj() {
        if (places == null) {
            places = new BonesLookup();
        }
    }

    public void drlPrepareIn_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
////              hm.put("EMP_ID", _rs.getString("EMP_ID"));
////                hm.put("FULLNAME", _rs.getString("FULLNAME"));
////                hm.put("DEPT_NAME", _rs.getString("DEPT_NAME"));
////                hm.put("EXPRIANCE", _rs.getString("EXPRIANCE"));
////                hm.put("CURRENT_SALARY", _rs.getString("CURRENT_SALARY"));
//            try {
//                checkObject();
//                ArrayList<HashMap> list = requestYearBonesManager.listOfEmployee(vce.getNewValue().toString(), "");
//                txtEmployeeNumber.setValue(list.size());
//                getListOfEmployee().clear();
//                for (HashMap hm : list) {
//
//                    getListOfEmployee().add(new RequestYearBonesManager(
//                            hm.get("EMP_ID").toString(),
//                            hm.get("FULLNAME").toString(),
//                            0,
//                            0,
//                            0,
//                            hm.get("EXPRIANCE").toString(),
//                            hm.get("CURRENT_SALARY").toString()));
//
        }
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
    //  vce.getNewValue().toString().tr

    }

    private void checkObject() {
        if (requestYearBonesManager == null) {
            requestYearBonesManager = new RequestYearBonesManager();
        }
    }

    public String btnCalculateEmpBonees_action() {
        try {
            checkObject();
            bntRemove.setDisabled(true);
            ArrayList<HashMap> listCalculation = requestYearBonesManager.bonesCalculation(
                    drlPrepareIn.getValue().toString(),
                    drlBonusYear.getValue().toString(),
                    txtEvaluationFrom.getValue().toString(),
                    txtEvaluationTo.getValue().toString(),
                    Integer.parseInt(drlBonesAmount.getValue().toString()));
            txtEmployeeNumber.setValue(listCalculation.size());
            getListOfEmployee().clear();
            for (HashMap hm : listCalculation) {
                getListOfEmployee().add(new RequestYearBonesManager(
                        hm.get("EMP_ID").toString(),
                        hm.get("FULLNAME").toString(),
                        Float.parseFloat(hm.get("EVALUATIONRESULT").toString()),
                        Float.parseFloat(hm.get("PERCENTAGE").toString()),
                        Float.parseFloat(hm.get("allowedBones").toString()),
                        hm.get("EXPRIANCE").toString(),
                        hm.get("CURRENT_SALARY").toString()));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        //return null means stay on the same page
        return null;
    }

    private HashMap listOfRequest() {
        HashMap hm = new HashMap();
        hm.put("prepareIn", drlPrepareIn.getValue().toString());
        hm.put("bonusYear", drlBonusYear.getValue().toString());
        hm.put("bugetEndDate", txtEvaluationTo.getValue().toString());
        hm.put("bonesAmount", drlBonesAmount.getValue().toString());

        hm.put("requester", requesterId);
        return hm;
    }

    private ArrayList<HashMap> listOfEmployee() {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        list.clear();
        for (RequestYearBonesManager obj : getListOfEmployee()) {
            HashMap hm = new HashMap();
            hm.put("empId", obj.getEmployeeId());
            hm.put("evaluationResult", obj.getEvaluationResult());
            hm.put("bonesAmount", obj.getAmountInBirr());

            hm.put("acquireMonth", obj.getAcquireMonth());
            hm.put("exprience", obj.getExprience());
            hm.put("salary", obj.getSalary());
            list.add(hm);
        }
        return list;
    }

    public String btnRequest_action() {
        checkObject();
        if (requestYearBonesManager.saveBonesRequest(listOfRequest(), listOfEmployee())) {
            showSuccessOrFailureMessage(true, "Yearly Bonus Request Successful Requested !");
        } else {
            showSuccessOrFailureMessage(false, "Error Occur During Request Yearly Bonus. Please Try Again?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnUpdate_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnRemove_action() {
        //return null means stay on the same page
        return null;
    }

    public String lnkEvaluationResultPage_action() {
        // TODO: Replace with your code
        return null;
    }

    public String lnkApproveYearlyBonusPage_action() {
        // TODO: Replace with your code
        return null;
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        // TODO: Replace with your code
        return null;
    }

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public void chkPerviousRequestList_processValueChange(ValueChangeEvent vce) {
    }

    public String button2_action() {
        //return null means stay on the same page
        return null;
    }

    public void calEvaluationFrom_processValueChange(ValueChangeEvent vce) {
        txtEvaluationFrom.setValue(sdf.format(vce.getNewValue()));
        calEvaluationFrom.setRendered(false);
    }

    public void calEvaluationTo_processValueChange(ValueChangeEvent vce) {
        txtEvaluationTo.setValue(sdf.format(vce.getNewValue()));
        calEvaluationTo.setRendered(false);
    }

    public String button4_action() {
        calEvaluationFrom.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String button5_action() {
        calEvaluationTo.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public void rowSelectorBonessRequest_processMyEvent(RowSelectorEvent rse) {
        selectedBonesRequest = rse.getRow();
        bntRemove.setDisabled(false);
    }

    public String bntRemove_action() {
        if (selectedBonesRequest > -1) {
            getListOfEmployee().remove(selectedBonesRequest);
            selectedBonesRequest = -1;
        } else {
            showSuccessOrFailureMessage(true, "Please First Select  Employee Information from the table?");
        }
        //return null means stay on the same page
        return null;
    }




}

