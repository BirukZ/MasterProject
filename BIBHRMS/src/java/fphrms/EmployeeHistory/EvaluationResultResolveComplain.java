/*
 * Page1.java
 *
 * Created on Feb 26, 2010, 7:48:31 AM
 * Copyright DavePro
 */
package fphrms.EmployeeHistory;

import com.icesoft.faces.component.ext.ColumnGroup;
import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.ext.UIColumn;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import com.sun.webui.jsf.model.Option;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ValueChangeEvent;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeManager.EmployeeManage;
import java.util.List;
import javax.faces.context.FacesContext;
import manager.globalUseManager.ErrorLogWriter;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EvaluationResultResolveComplain extends AbstractPageBean {

    /**
     * @return the selectedId
     */

    private PanelPopup pnMessage = new PanelPopup();

    public PanelPopup getPnMessage() {
        return pnMessage;
    }

    public void setPnMessage(PanelPopup pp) {
        this.pnMessage = pp;
    }
    private HtmlOutputLabel lblFormMessage1 = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage1() {
        return lblFormMessage1;
    }

    public void setLblFormMessage1(HtmlOutputLabel hol) {
        this.lblFormMessage1 = hol;
    }


    public static String getSelectedId() {
        return selectedId;
    }

    /**
     * @param aSelectedId the selectedId to set
     */
    public static void setSelectedId(String aSelectedId) {
        selectedId = aSelectedId;
    }

    /**
     * @return the selectedSessionId
     */
    public static String getSelectedSessionId() {
        return selectedSessionId;
    }

    /**
     * @param aSelectedSessionId the selectedSessionId to set
     */
    public static void setSelectedSessionId(String aSelectedSessionId) {
        selectedSessionId = aSelectedSessionId;
    }

    /**
     * @return the selectedSessionId1
     */
    public static String getSelectedSessionId1() {
        return selectedSessionId1;
    }

    /**
     * @param aSelectedSessionId1 the selectedSessionId1 to set
     */
    public static void setSelectedSessionId1(String aSelectedSessionId1) {
        selectedSessionId1 = aSelectedSessionId1;
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
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultSelectedData defaultSelectedData5 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData5() {
        return defaultSelectedData5;
    }

    public void setDefaultSelectedData5(DefaultSelectedData dsd) {
        this.defaultSelectedData5 = dsd;
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
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems5() {
        return selectOneRadio1DefaultItems5;
    }

    public void setSelectOneRadio1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems6() {
        return selectOneRadio1DefaultItems6;
    }

    public void setSelectOneRadio1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems6 = dsia;
    }
    private DefaultSelectedData defaultSelectedDataUserD = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataUserD() {
        return defaultSelectedDataUserD;
    }

    public void setDefaultSelectedDataUserD(DefaultSelectedData dsd) {
        this.defaultSelectedDataUserD = dsd;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
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
    private HtmlDataTable dataTableEvaResult = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaResult() {
        return dataTableEvaResult;
    }

    public void setDataTableEvaResult(HtmlDataTable hdt) {
        this.dataTableEvaResult = hdt;
    }
    private HtmlSelectOneMenu selectOneMenuEvaResult = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaResult() {
        return selectOneMenuEvaResult;
    }

    public void setSelectOneMenuEvaResult(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaResult = hsom;
    }
    private UISelectItems selectOneMenu1selectItemsEvaResult = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsEvaResult() {
        return selectOneMenu1selectItemsEvaResult;
    }

    public void setSelectOneMenu1selectItemsEvaResult(UISelectItems uisi) {
        this.selectOneMenu1selectItemsEvaResult = uisi;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    private static String selectedSessionId;
    private static String selectedSessionId1;
    private Option[] sessionResultHistory;
    int selectedEvaResultRow = -1;
    int buttonIndicator = 0;
    int resolveUpdateIndicator = 0;
    int manResolveIndicator = 0;
    private static String selectedId;
    EmployeeManage employeeManager = new EmployeeManage();
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    ArrayList<EvaluationResultManager> evaSessionResultMList = new ArrayList<EvaluationResultManager>();
    private List evaResultOPt = new ArrayList<EvaluationResultManager>();
    private List evaResultOPtOther = new ArrayList<EvaluationResultManager>();
    private Option[] resultPurposeForDisplay;
    private Option[] resultDateForDisplay;
    private Option[] resultResolver;
    String identifyPurposeDisplay = "";
    String sessionIdResolve = "";
    private List evaResultOPtAverage = new ArrayList<EvaluationResultManager>();

    public List getEvaResultOPtAverage() {
        return evaResultOPtAverage;
    }


    public void setEvaResultOPtAverage(List evaResultOPtAverage) {
        this.evaResultOPtAverage = evaResultOPtAverage;
    }

    public Option[] getResultResolver() {
        return resultResolver;
    }

    public void setResultResolver(Option[] resultResolver) {
        this.resultResolver = resultResolver;
    }

    public List getEvaResultOPtOther() {
        return evaResultOPtOther;
    }

    public void setEvaResultOPtOther(List evaResultOPtOther) {
        this.evaResultOPtOther = evaResultOPtOther;
    }

    public Option[] getResultDateForDisplay() {
        return resultDateForDisplay;
    }

    public void setResultDateForDisplay(Option[] resultDateForDisplay) {
        this.resultDateForDisplay = resultDateForDisplay;
    }

    public Option[] getResultPurposeForDisplay() {
        return resultPurposeForDisplay;
    }

    public void setResultPurposeForDisplay(Option[] resultPurposeForDisplay) {
        this.resultPurposeForDisplay = resultPurposeForDisplay;
    }

    public List getEvaResultOPt() {
        return evaResultOPt;
    }

    public void setEvaResultOPt(List evaResultOPt) {
        this.evaResultOPt = evaResultOPt;
    }

    public ArrayList<EvaluationResultManager> getFileAttachment() {
        return evaSessionResultMList;
    }

    public void setFileAttachment(ArrayList<EvaluationResultManager> evaSessionResultMList) {
        this.evaSessionResultMList = evaSessionResultMList;
    }

    public void selectOneMenuEvaResult_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("SelectPurp")) {
            String sessionPurpose[] = vce.getNewValue().toString().split("-");
            evaResultManObject.setPurpIdentifiyer(sessionPurpose[0]);
            resultDateForDisplay = evaResultManObject.readDateForDisplay();
            selectOneMenu1SelectDate.setDisabled(false);

        }
    }

    public void selectOneMenu1SelectDate_processValueChange(ValueChangeEvent vce) {
        this.sessionIdResolve = vce.getNewValue().toString();
        this.selectOneMenu1EvaluatorName.setDisabled(false);
        this.resultResolver = evaResultManObject.readEvaluatorToResolve(vce.getNewValue().toString(), this.getSessionBean1().getEmployeeId());


    }

    private void loadSessionResultDetail(String sessionId) {
        this.outputTextEvaResultAutorizedAnswer.setValue(null);
        this.outputTextEvaResultEndingDateAnswer.setValue(null);
        this.outputTextEvaResultStartingDateAnswer.setValue(null);
        this.inputTextEvaResultSessionID.setValue(null);

        try {
            evaResultManObject.loadSessionResultDit(sessionId);
            this.outputTextEvaResultAutorizedAnswer.setValue(evaResultManObject.getEmpName());
            this.outputTextEvaResultEndingDateAnswer.setValue(evaResultManObject.getEndDate());
            this.outputTextEvaResultStartingDateAnswer.setValue(evaResultManObject.getStartDate());
            this.inputTextEvaResultSessionID.setValue(sessionId);


        } catch (Exception ex) {
        }
    }
    private SelectInputText txtSearchByNameEvaResult = new SelectInputText();

    public SelectInputText getTxtSearchByNameEvaResult() {
        return txtSearchByNameEvaResult;
    }

    public void setTxtSearchByNameEvaResult(SelectInputText sit) {
        this.txtSearchByNameEvaResult = sit;
    }
    private DefaultTableDataModel dataTable1Model1 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model1() {
        return dataTable1Model1;
    }

    public void setDataTable1Model1(DefaultTableDataModel dtdm) {
        this.dataTable1Model1 = dtdm;
    }
    private UISelectItems selectOneMenu1selectItemsEvaResultTable = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsEvaResultTable() {
        return selectOneMenu1selectItemsEvaResultTable;
    }

    public void setSelectOneMenu1selectItemsEvaResultTable(UISelectItems uisi) {
        this.selectOneMenu1selectItemsEvaResultTable = uisi;
    }
    private HtmlSelectOneMenu selectOneMenuEvaResultTable = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaResultTable() {
        return selectOneMenuEvaResultTable;
    }

    public void setSelectOneMenuEvaResultTable(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaResultTable = hsom;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems4 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems4 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private HtmlSelectOneMenu selectOneMenuEvaSessionTblResult = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuEvaSessionTblResult() {
        return selectOneMenuEvaSessionTblResult;
    }

    public void setSelectOneMenuEvaSessionTblResult(HtmlSelectOneMenu hsom) {
        this.selectOneMenuEvaSessionTblResult = hsom;
    }
    private UISelectItems selectOneMenu1selectItemsEvaSessionTblResult = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsEvaSessionTblResult() {
        return selectOneMenu1selectItemsEvaSessionTblResult;
    }

    public void setSelectOneMenu1selectItemsEvaSessionTblResult(UISelectItems uisi) {
        this.selectOneMenu1selectItemsEvaSessionTblResult = uisi;
    }
    private PanelLayout panelLayoutTableControllerEvaResult = new PanelLayout();

    public PanelLayout getPanelLayoutTableControllerEvaResult() {
        return panelLayoutTableControllerEvaResult;
    }

    public void setPanelLayoutTableControllerEvaResult(PanelLayout pl) {
        this.panelLayoutTableControllerEvaResult = pl;
    }
    private javax.faces.component.html.HtmlSelectOneMenu dropdown1 = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDropdown1() {
        return dropdown1;
    }

    public void setDropdown1(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.dropdown1 = hsom;
    }
    private ColumnGroup columnGroup1 = new ColumnGroup();

    public ColumnGroup getColumnGroup1() {
        return columnGroup1;
    }

    public void setColumnGroup1(ColumnGroup cg) {
        this.columnGroup1 = cg;
    }
    private ColumnGroup columnGroup2 = new ColumnGroup();

    public ColumnGroup getColumnGroup2() {
        return columnGroup2;
    }

    public void setColumnGroup2(ColumnGroup cg) {
        this.columnGroup2 = cg;
    }
    private HtmlOutputText outputTextEvaResultStartingDateAnswer = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaResultStartingDateAnswer() {
        return outputTextEvaResultStartingDateAnswer;
    }

    public void setOutputTextEvaResultStartingDateAnswer(HtmlOutputText hot) {
        this.outputTextEvaResultStartingDateAnswer = hot;
    }
    private HtmlOutputText outputTextEvaResultAutorizedAnswer = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaResultAutorizedAnswer() {
        return outputTextEvaResultAutorizedAnswer;
    }

    public void setOutputTextEvaResultAutorizedAnswer(HtmlOutputText hot) {
        this.outputTextEvaResultAutorizedAnswer = hot;
    }
    private HtmlOutputText outputTextEvaResultEndingDateAnswer = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaResultEndingDateAnswer() {
        return outputTextEvaResultEndingDateAnswer;
    }

    public void setOutputTextEvaResultEndingDateAnswer(HtmlOutputText hot) {
        this.outputTextEvaResultEndingDateAnswer = hot;
    }
    private HtmlOutputText outputTextEvaRSessionEmpName = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaRSessionEmpName() {
        return outputTextEvaRSessionEmpName;
    }

    public void setOutputTextEvaRSessionEmpName(HtmlOutputText hot) {
        this.outputTextEvaRSessionEmpName = hot;
    }
    private HtmlOutputText outputTextEvaRSessionEmpDepartment = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaRSessionEmpDepartment() {
        return outputTextEvaRSessionEmpDepartment;
    }

    public void setOutputTextEvaRSessionEmpDepartment(HtmlOutputText hot) {
        this.outputTextEvaRSessionEmpDepartment = hot;
    }
    private ColumnGroup columnGroup3 = new ColumnGroup();

    public ColumnGroup getColumnGroup3() {
        return columnGroup3;
    }

    public void setColumnGroup3(ColumnGroup cg) {
        this.columnGroup3 = cg;
    }
    private javax.faces.component.html.HtmlSelectOneMenu dropdownEvaRResult = new javax.faces.component.html.HtmlSelectOneMenu();

    public javax.faces.component.html.HtmlSelectOneMenu getDropdownEvaRResult() {
        return dropdownEvaRResult;
    }

    public void setDropdownEvaRResult(javax.faces.component.html.HtmlSelectOneMenu hsom) {
        this.dropdownEvaRResult = hsom;
    }
    private UISelectItems selectOneMenu1selectItemsEvaRResult = new UISelectItems();

    public UISelectItems getSelectOneMenu1selectItemsEvaRResult() {
        return selectOneMenu1selectItemsEvaRResult;
    }

    public void setSelectOneMenu1selectItemsEvaRResult(UISelectItems uisi) {
        this.selectOneMenu1selectItemsEvaRResult = uisi;
    }
    private HtmlCommandButton buttonEvaResultSave = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultSave() {
        return buttonEvaResultSave;
    }

    public void setButtonEvaResultSave(HtmlCommandButton hcb) {
        this.buttonEvaResultSave = hcb;
    }
    private HtmlCommandButton buttonEvaResultEdit = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultEdit() {
        return buttonEvaResultEdit;
    }

    public void setButtonEvaResultEdit(HtmlCommandButton hcb) {
        this.buttonEvaResultEdit = hcb;
    }
    private HtmlCommandButton buttonEvaResultUpdate = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultUpdate() {
        return buttonEvaResultUpdate;
    }

    public void setButtonEvaResultUpdate(HtmlCommandButton hcb) {
        this.buttonEvaResultUpdate = hcb;
    }
    private HtmlCommandButton buttonEvaResultDelete = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultDelete() {
        return buttonEvaResultDelete;
    }

    public void setButtonEvaResultDelete(HtmlCommandButton hcb) {
        this.buttonEvaResultDelete = hcb;
    }
    private HtmlCommandButton buttonEvaResultCancel = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultCancel() {
        return buttonEvaResultCancel;
    }

    public void setButtonEvaResultCancel(HtmlCommandButton hcb) {
        this.buttonEvaResultCancel = hcb;
    }
    private HtmlInputText inputTextEvaResultSessionID = new HtmlInputText();

    public HtmlInputText getInputTextEvaResultSessionID() {
        return inputTextEvaResultSessionID;
    }

    public void setInputTextEvaResultSessionID(HtmlInputText hit) {
        this.inputTextEvaResultSessionID = hit;
    }
    private HtmlInputText inputTextEvaResultSessionEmpID = new HtmlInputText();

    public HtmlInputText getInputTextEvaResultSessionEmpID() {
        return inputTextEvaResultSessionEmpID;
    }

    public void setInputTextEvaResultSessionEmpID(HtmlInputText hit) {
        this.inputTextEvaResultSessionEmpID = hit;
    }
    private HtmlInputTextarea inputTextareaEvaSessionRemark = new HtmlInputTextarea();

    public HtmlInputTextarea getInputTextareaEvaSessionRemark() {
        return inputTextareaEvaSessionRemark;
    }

    public void setInputTextareaEvaSessionRemark(HtmlInputTextarea hit) {
        this.inputTextareaEvaSessionRemark = hit;
    }
    private HtmlOutputText outputTextEvaaResultT = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaaResultT() {
        return outputTextEvaaResultT;
    }

    public void setOutputTextEvaaResultT(HtmlOutputText hot) {
        this.outputTextEvaaResultT = hot;
    }
    private HtmlOutputText outputTextEvaaResultActual = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaaResultActual() {
        return outputTextEvaaResultActual;
    }

    public void setOutputTextEvaaResultActual(HtmlOutputText hot) {
        this.outputTextEvaaResultActual = hot;
    }
    private HtmlInputText inputTextEvaaResult = new HtmlInputText();

    public HtmlInputText getInputTextEvaaResult() {
        return inputTextEvaaResult;
    }

    public void setInputTextEvaaResult(HtmlInputText hit) {
        this.inputTextEvaaResult = hit;
    }
    private HtmlOutputLabel lblevaResultFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblevaResultFormMessage() {
        return lblevaResultFormMessage;
    }

    public void setLblevaResultFormMessage(HtmlOutputLabel hol) {
        this.lblevaResultFormMessage = hol;
    }
    private PanelLayout pnevaResultMessage = new PanelLayout();

    public PanelLayout getPnevaResultMessage() {
        return pnevaResultMessage;
    }

    public void setPnevaResultMessage(PanelLayout pl) {
        this.pnevaResultMessage = pl;
    }
    private DefaultSelectedData selectOneListbox1BeanEvaResult = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox1BeanEvaResult() {
        return selectOneListbox1BeanEvaResult;
    }

    public void setSelectOneListbox1BeanEvaResult(DefaultSelectedData dsd) {
        this.selectOneListbox1BeanEvaResult = dsd;
    }
    private PanelLayout panelLayoutEvaSessionResult = new PanelLayout();

    public PanelLayout getPanelLayoutEvaSessionResult() {
        return panelLayoutEvaSessionResult;
    }

    public void setPanelLayoutEvaSessionResult(PanelLayout pl) {
        this.panelLayoutEvaSessionResult = pl;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
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
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
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
    private HtmlSelectOneListbox selectOneListbox1 = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectOneListbox1() {
        return selectOneListbox1;
    }

    public void setSelectOneListbox1(HtmlSelectOneListbox hsol) {
        this.selectOneListbox1 = hsol;
    }
    private DefaultTableDataModel dataTable1Model2 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model2() {
        return dataTable1Model2;
    }

    public void setDataTable1Model2(DefaultTableDataModel dtdm) {
        this.dataTable1Model2 = dtdm;
    }
    private HtmlDataTable dataTableEvaSessionResultDisplay = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaSessionResultDisplay() {
        return dataTableEvaSessionResultDisplay;
    }

    public void setDataTableEvaSessionResultDisplay(HtmlDataTable hdt) {
        this.dataTableEvaSessionResultDisplay = hdt;
    }
    private RowSelector rowSelectorEvaResult = new RowSelector();

    public RowSelector getRowSelectorEvaResult() {
        return rowSelectorEvaResult;
    }

    public void setRowSelectorEvaResult(RowSelector rs) {
        this.rowSelectorEvaResult = rs;
    }
    private UIColumn columnEvaResultCName1 = new UIColumn();

    public UIColumn getColumnEvaResultCName1() {
        return columnEvaResultCName1;
    }

    public void setColumnEvaResultCName1(UIColumn uic) {
        this.columnEvaResultCName1 = uic;
    }
    private UIColumn columnEvaResultResult2 = new UIColumn();

    public UIColumn getColumnEvaResultResult2() {
        return columnEvaResultResult2;
    }

    public void setColumnEvaResultResult2(UIColumn uic) {
        this.columnEvaResultResult2 = uic;
    }
    private UIColumn columnEvaResultRemark3 = new UIColumn();

    public UIColumn getColumnEvaResultRemark3() {
        return columnEvaResultRemark3;
    }

    public void setColumnEvaResultRemark3(UIColumn uic) {
        this.columnEvaResultRemark3 = uic;
    }
    private HtmlInputTextarea inputTextAreaEvaSessionResultR = new HtmlInputTextarea();

    public HtmlInputTextarea getInputTextAreaEvaSessionResultR() {
        return inputTextAreaEvaSessionResultR;
    }

    public void setInputTextAreaEvaSessionResultR(HtmlInputTextarea hit) {
        this.inputTextAreaEvaSessionResultR = hit;
    }
    private HtmlInputText inputTextEvaSessionResultR = new HtmlInputText();

    public HtmlInputText getInputTextEvaSessionResultR() {
        return inputTextEvaSessionResultR;
    }

    public void setInputTextEvaSessionResultR(HtmlInputText hit) {
        this.inputTextEvaSessionResultR = hit;
    }
    private HtmlOutputText outputTextEvaResultCName7 = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaResultCName7() {
        return outputTextEvaResultCName7;
    }

    public void setOutputTextEvaResultCName7(HtmlOutputText hot) {
        this.outputTextEvaResultCName7 = hot;
    }
    private PanelPopup evaResultPopUpMsg = new PanelPopup();

    public PanelPopup getEvaResultPopUpMsg() {
        return evaResultPopUpMsg;
    }

    public void setEvaResultPopUpMsg(PanelPopup pp) {
        this.evaResultPopUpMsg = pp;
    }
    private HtmlCommandButton btnevaResultPopUpYes = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaResultPopUpYes() {
        return btnevaResultPopUpYes;
    }

    public void setBtnevaResultPopUpYes(HtmlCommandButton hcb) {
        this.btnevaResultPopUpYes = hcb;
    }
    private HtmlCommandButton btnevaResultPopUpNo = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaResultPopUpNo() {
        return btnevaResultPopUpNo;
    }

    public void setBtnevaResultPopUpNo(HtmlCommandButton hcb) {
        this.btnevaResultPopUpNo = hcb;
    }
    private HtmlOutputText lblevaResultPopUpMsgMain = new HtmlOutputText();

    public HtmlOutputText getLblevaResultPopUpMsgMain() {
        return lblevaResultPopUpMsgMain;
    }

    public void setLblevaResultPopUpMsgMain(HtmlOutputText hot) {
        this.lblevaResultPopUpMsgMain = hot;
    }
    private HtmlCommandButton buttonEvaResultNew = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultNew() {
        return buttonEvaResultNew;
    }

    public void setButtonEvaResultNew(HtmlCommandButton hcb) {
        this.buttonEvaResultNew = hcb;
    }
    private HtmlOutputLabel lblevaResultFormMessageInfo = new HtmlOutputLabel();

    public HtmlOutputLabel getLblevaResultFormMessageInfo() {
        return lblevaResultFormMessageInfo;
    }

    public void setLblevaResultFormMessageInfo(HtmlOutputLabel hol) {
        this.lblevaResultFormMessageInfo = hol;
    }
    private PanelLayout pnevaResultMessageInfo = new PanelLayout();

    public PanelLayout getPnevaResultMessageInfo() {
        return pnevaResultMessageInfo;
    }

    public void setPnevaResultMessageInfo(PanelLayout pl) {
        this.pnevaResultMessageInfo = pl;
    }
    private HtmlOutputText outputTextevaSessionEvaResultSerarch = new HtmlOutputText();

    public HtmlOutputText getOutputTextevaSessionEvaResultSerarch() {
        return outputTextevaSessionEvaResultSerarch;
    }

    public void setOutputTextevaSessionEvaResultSerarch(HtmlOutputText hot) {
        this.outputTextevaSessionEvaResultSerarch = hot;
    }
    private HtmlOutputText outputTextselectOneMenuEvaResult = new HtmlOutputText();

    public HtmlOutputText getOutputTextselectOneMenuEvaResult() {
        return outputTextselectOneMenuEvaResult;
    }

    public void setOutputTextselectOneMenuEvaResult(HtmlOutputText hot) {
        this.outputTextselectOneMenuEvaResult = hot;
    }
    private HtmlSelectOneMenu selectOneMenu1Try = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1Try() {
        return selectOneMenu1Try;
    }

    public void setSelectOneMenu1Try(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1Try = hsom;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi1 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi1() {
        return checkbox1hi1;
    }

    public void setCheckbox1hi1(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi1 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi2 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi2() {
        return checkbox1hi2;
    }

    public void setCheckbox1hi2(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi2 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi3 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi3() {
        return checkbox1hi3;
    }

    public void setCheckbox1hi3(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi3 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi4 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi4() {
        return checkbox1hi4;
    }

    public void setCheckbox1hi4(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi4 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi5 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi5() {
        return checkbox1hi5;
    }

    public void setCheckbox1hi5(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi5 = hsbc;
    }
    private HtmlOutputText outputTextValueHolder = new HtmlOutputText();

    public HtmlOutputText getOutputTextValueHolder() {
        return outputTextValueHolder;
    }

    public void setOutputTextValueHolder(HtmlOutputText hot) {
        this.outputTextValueHolder = hot;
    }
    private HtmlInputText inputTextSelectedValue = new HtmlInputText();

    public HtmlInputText getInputTextSelectedValue() {
        return inputTextSelectedValue;
    }

    public void setInputTextSelectedValue(HtmlInputText hit) {
        this.inputTextSelectedValue = hit;
    }
    private HtmlDataTable dataTableEvaResultOther = new HtmlDataTable();

    public HtmlDataTable getDataTableEvaResultOther() {
        return dataTableEvaResultOther;
    }

    public void setDataTableEvaResultOther(HtmlDataTable hdt) {
        this.dataTableEvaResultOther = hdt;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi1Other = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi1Other() {
        return checkbox1hi1Other;
    }

    public void setCheckbox1hi1Other(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi1Other = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi2Other = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi2Other() {
        return checkbox1hi2Other;
    }

    public void setCheckbox1hi2Other(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi2Other = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi3Other = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi3Other() {
        return checkbox1hi3Other;
    }

    public void setCheckbox1hi3Other(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi3Other = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi4Other = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi4Other() {
        return checkbox1hi4Other;
    }

    public void setCheckbox1hi4Other(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi4Other = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi5Other = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi5Other() {
        return checkbox1hi5Other;
    }

    public void setCheckbox1hi5Other(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi5Other = hsbc;
    }
    private HtmlInputText inputTextSelectedValueOther = new HtmlInputText();

    public HtmlInputText getInputTextSelectedValueOther() {
        return inputTextSelectedValueOther;
    }

    public void setInputTextSelectedValueOther(HtmlInputText hit) {
        this.inputTextSelectedValueOther = hit;
    }
    private PanelLayout panelLayoutTableControllerEvaResultOther = new PanelLayout();

    public PanelLayout getPanelLayoutTableControllerEvaResultOther() {
        return panelLayoutTableControllerEvaResultOther;
    }

    public void setPanelLayoutTableControllerEvaResultOther(PanelLayout pl) {
        this.panelLayoutTableControllerEvaResultOther = pl;
    }
    private HtmlOutputText lblStatusEvaluatorValue = new HtmlOutputText();

    public HtmlOutputText getLblStatusEvaluatorValue() {
        return lblStatusEvaluatorValue;
    }

    public void setLblStatusEvaluatorValue(HtmlOutputText hot) {
        this.lblStatusEvaluatorValue = hot;
    }
    private HtmlOutputText outputTextEvaResultPurposeFor = new HtmlOutputText();

    public HtmlOutputText getOutputTextEvaResultPurposeFor() {
        return outputTextEvaResultPurposeFor;
    }

    public void setOutputTextEvaResultPurposeFor(HtmlOutputText hot) {
        this.outputTextEvaResultPurposeFor = hot;
    }
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private HtmlSelectOneMenu selectOneMenu1SelectDate = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1SelectDate() {
        return selectOneMenu1SelectDate;
    }

    public void setSelectOneMenu1SelectDate(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1SelectDate = hsom;
    }
    private HtmlCommandButton buttonEvaResultComplain = new HtmlCommandButton();

    public HtmlCommandButton getButtonEvaResultComplain() {
        return buttonEvaResultComplain;
    }

    public void setButtonEvaResultComplain(HtmlCommandButton hcb) {
        this.buttonEvaResultComplain = hcb;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems7 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems7() {
        return selectOneMenu1DefaultItems7;
    }

    public void setSelectOneMenu1DefaultItems7(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems7 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems8 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems8() {
        return selectOneMenu1DefaultItems8;
    }

    public void setSelectOneMenu1DefaultItems8(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems8 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems9 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems9() {
        return selectOneMenu1DefaultItems9;
    }

    public void setSelectOneMenu1DefaultItems9(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems9 = dsia;
    }
    private HtmlSelectOneMenu selectOneMenu1EvaluatorName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenu1EvaluatorName() {
        return selectOneMenu1EvaluatorName;
    }

    public void setSelectOneMenu1EvaluatorName(HtmlSelectOneMenu hsom) {
        this.selectOneMenu1EvaluatorName = hsom;
    }
    private HtmlOutputText outputText43ComplainApprove = new HtmlOutputText();

    public HtmlOutputText getOutputText43ComplainApprove() {
        return outputText43ComplainApprove;
    }

    public void setOutputText43ComplainApprove(HtmlOutputText hot) {
        this.outputText43ComplainApprove = hot;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi4ComplainApprove = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi4ComplainApprove() {
        return checkbox1hi4ComplainApprove;
    }

    public void setCheckbox1hi4ComplainApprove(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi4ComplainApprove = hsbc;
    }
    private HtmlInputTextarea inputTextareaEvaSessionComplainRemarkOther = new HtmlInputTextarea();

    public HtmlInputTextarea getInputTextareaEvaSessionComplainRemarkOther() {
        return inputTextareaEvaSessionComplainRemarkOther;
    }

    public void setInputTextareaEvaSessionComplainRemarkOther(HtmlInputTextarea hit) {
        this.inputTextareaEvaSessionComplainRemarkOther = hit;
    }
    private HtmlInputTextarea inputTextareaEvaSessionResolverRemarkOther = new HtmlInputTextarea();

    public HtmlInputTextarea getInputTextareaEvaSessionResolverRemarkOther() {
        return inputTextareaEvaSessionResolverRemarkOther;
    }

    public void setInputTextareaEvaSessionResolverRemarkOther(HtmlInputTextarea hit) {
        this.inputTextareaEvaSessionResolverRemarkOther = hit;
    }

    public EvaluationResultResolveComplain() {
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
        super.init();
        buttonIndicator = 0;
        resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
        disableComponents();
        disableButtons();
        this.evaResultOPt.clear();
        this.buttonEvaResultNew.setDisabled(false);
        this.dataTableEvaSessionResultDisplay.setRendered(false);
        this.dataTableEvaResult.setRendered(true);
        lblStatusEvaluatorValue.setValue(this.getSessionBean1().getEmployeeName() + "--" + this.getSessionBean1().getEmployeeId());
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
    @Override
    public void prerender() {
        txtSearchByNameEvaResult.setRequired(true);
        txtSearchByNameEvaResult.setRequiredMessage("Requred");
        selectOneMenuEvaResult.setRequired(true);
        selectOneMenuEvaResult.setRequiredMessage("Requred");
        lblStatusEvaluatorValue.setValue(this.getSessionBean1().getEmployeeName() + "--" + this.getSessionBean1().getEmployeeId());
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

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblFormMessage1.setStyle(success ? "color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle");
        lblFormMessage1.setValue(messageToDisplay);
        lblFormMessage1.setRendered(true);
        pnMessage.setAutoCentre(true);
        pnMessage.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "15000" : "15000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" +
                "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
        return null;
    }

    public void clearComponents() {
        this.selectOneMenuEvaResult.setValue("SelectPurp");
        this.txtSearchByNameEvaResult.setValue("");
        this.outputTextEvaRSessionEmpDepartment.setValue("");
        this.outputTextEvaRSessionEmpName.setValue("");
        this.outputTextEvaResultAutorizedAnswer.setValue("");
        this.outputTextEvaResultEndingDateAnswer.setValue("");
        this.outputTextEvaResultStartingDateAnswer.setValue("");
        this.selectOneMenu1EvaluatorName.setValue("SelectPurp");
    }

    public void disableComponents() {
        this.txtSearchByNameEvaResult.setDisabled(true);
        //this.selectOneMenuEvaResult.setDisabled(true);
        selectOneMenu1SelectDate.setDisabled(true);
        this.selectOneMenu1EvaluatorName.setDisabled(true);

    }

    public void enableComponents() {
        this.txtSearchByNameEvaResult.setDisabled(false);
        this.selectOneMenuEvaResult.setDisabled(false);
        this.selectOneListbox1.setDisabled(false);

    }

    public void populateResultTable(int sessionID) {
        //disableComponents();
        //disableButtons();
        panelLayoutTableControllerEvaResultOther.setRendered(true);
        //panelLayoutTableControllerEvaResult.setRendered(true);
        this.dataTableEvaResultOther.setRendered(true);
        //this.dataTableEvaResult.setRendered(true);
        this.evaResultOPt.clear();
        //this.buttonEvaResultNew.setDisabled(false);
        int count = evaResultManObject.countEvaResult(sessionID);
        try {
            if (count > 0) {
                HashMap[] evaResultList = evaResultManObject.readEvaResultTbl(sessionID);
                for (int i = 0; i < evaResultList.length; i++) {
                    EvaluationResultManager addToTable = new EvaluationResultManager(evaResultList[i].get("EVALUATION_PARA_CODE").hashCode(), evaResultList[i].get("NAME").toString(), evaResultList[i].get("CATEGORY").toString());
                    this.evaResultOPt.add(addToTable);
                }
            } else {
                this.dataTableEvaResult.setRendered(true);
            //disableButtons();
            // this.columncevaCid.setRendered(false);
            //this.buttonNewEC.setDisabled(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            ErrorLogWriter.writeError(ex);
        }

    }

    public String txtSearchByNameEvaResult_action() {
        setSelectedId(ApplicationBean1.getSelectedEmployeeId());
        this.loadEmployeeProfileDetail(getSelectedId());
        //return null means stay on the same page
        return null;
    }

    private void loadEmployeeProfileDetail(String empId) {
        this.outputTextEvaRSessionEmpName.setValue(null);
        this.inputTextEvaResultSessionEmpID.resetValue();


        try {
            employeeManager.loadEmpoyeeProfile(empId);
            this.outputTextEvaRSessionEmpName.setValue(employeeManager.getTitle() + " " + employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            this.outputTextEvaRSessionEmpDepartment.setValue(employeeManager.getJobDescription());
            this.inputTextEvaResultSessionEmpID.setValue(empId);

        } catch (Exception ex) {
        }
    }

    private void showConformationMsg(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    public String buttonEvaResultSave_action() {
        int chekSave = 0;
        int checkId = 0;
        int checkAuthorizer = 0;
        String evaluatorID[] = this.lblStatusEvaluatorValue.getValue().toString().split("--");

        buttonIndicator = 2;
        if (this.inputTextEvaResultSessionID.getValue().toString().equals("0") || selectOneMenuEvaResult.getValue().equals("0")) {
            outputTextselectOneMenuEvaResult.setValue("Requred");
            outputTextselectOneMenuEvaResult.setRendered(true);
        } else {
            if (this.inputTextEvaResultSessionEmpID.getValue() == null || this.inputTextEvaResultSessionEmpID.getValue().toString().equals("")) {
                outputTextevaSessionEvaResultSerarch.setRendered(true);
                outputTextevaSessionEvaResultSerarch.setValue("Requred");
            } else {

                checkId = evaResultManObject.serEvaSessionSearchId(this.inputTextEvaResultSessionEmpID.getValue().toString(), Integer.parseInt(this.inputTextEvaResultSessionID.getValue().toString()));
                checkAuthorizer = evaResultManObject.serEvaSessionSearchIdA(this.inputTextEvaResultSessionEmpID.getValue().toString(), Integer.parseInt(this.inputTextEvaResultSessionID.getValue().toString()));
                if (checkId >= 1) {
                    lblevaResultFormMessageInfo.setValue(this.outputTextEvaRSessionEmpName.getValue() + " Can't Evaluated two times on the same Session!!!");
                    showConformationMsg(pnevaResultMessageInfo.getStyleClass().toString());

                } else if (checkAuthorizer >= 1) {
                    lblevaResultFormMessageInfo.setValue(this.outputTextEvaRSessionEmpName.getValue() + " Can't Evaluate One Self!!!");
                    showConformationMsg(pnevaResultMessageInfo.getStyleClass().toString());


                } else {
                    List evaSessionResult = this.evaResultOPt;
                    Iterator<EvaluationResultManager> ittEvaSessionResult = evaSessionResult.iterator();
                    while (ittEvaSessionResult.hasNext()) {
                        EvaluationResultManager evaSResult = ittEvaSessionResult.next();
                        chekSave = evaResultManObject.addEvaSessionResult(evaSResult.getSelectedValue().toString(), evaSResult.getEvaCrtCode(), this.inputTextEvaResultSessionEmpID.getValue().toString(), Integer.valueOf(this.inputTextEvaResultSessionID.getValue().toString()), evaSResult.getRemark(), evaluatorID[1]);
                    }
                    if (chekSave == 1) {
                        lblevaResultFormMessage.setValue("The Evaluation Result Saved successfully!!!");
                        showConformationMsg(pnevaResultMessage.getStyleClass().toString());
                        sessionResultHistory = evaResultManObject.loadSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
                        clearComponents();
                        disableButtons();
                        this.txtSearchByNameEvaResult.resetValue();
                        this.outputTextEvaRSessionEmpDepartment.setValue("");
                        this.outputTextEvaRSessionEmpName.setValue("");
                        this.inputTextEvaResultSessionEmpID.setValue("");
                        this.buttonEvaResultNew.setDisabled(false);
                        outputTextevaSessionEvaResultSerarch.setValue("");
                        // this.inputTextEvaResultSessionID.setValue("0");
                        resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
                        this.evaResultOPt.clear();
                        resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
                        disableComponents();

                    } else {
                        lblevaResultFormMessage.setValue("Error Occured during saving .Please Try Again?");
                        showConformationMsg(pnevaResultMessage.getStyleClass().toString());
//            clearComponents();
//            populateTable();
                    }
                }
            }
        }
        //return null means stay on the same page
        return null;

    }

    public void dropdownEvaRResult_processValueChange(ValueChangeEvent vce1) {

        selectedSessionId1 = vce1.getNewValue().toString();
        this.inputTextEvaaResult.setValue(selectedSessionId1);
    }

    /**
     * @return the sessionResultHistory
     */
    public Option[] getSessionResultHistory() {
        return sessionResultHistory;
    }

    /**
     * @param sessionResultHistory the sessionResultHistory to set
     */
    public void setSessionResultHistory(Option[] sessionResultHistory) {
        this.sessionResultHistory = sessionResultHistory;
    }

    public void disableTableComponents() {
        this.inputTextEvaSessionResultR.setDisabled(true);
        this.inputTextAreaEvaSessionResultR.setDisabled(true);
    }

    public void enableTableComponents() {
        this.inputTextEvaSessionResultR.setDisabled(false);
        this.inputTextAreaEvaSessionResultR.setDisabled(false);
    }

    public void disableButtons() {
        this.buttonEvaResultCancel.setDisabled(true);
        this.buttonEvaResultDelete.setDisabled(true);
        this.buttonEvaResultEdit.setDisabled(true);
        this.buttonEvaResultNew.setDisabled(true);
        this.buttonEvaResultSave.setDisabled(true);
        this.buttonEvaResultUpdate.setDisabled(true);

    }

    public void enableButtons() {
        this.buttonEvaResultCancel.setDisabled(false);
        this.buttonEvaResultDelete.setDisabled(false);
        this.buttonEvaResultEdit.setDisabled(false);
        this.buttonEvaResultNew.setDisabled(false);
        this.buttonEvaResultSave.setDisabled(false);
        this.buttonEvaResultUpdate.setDisabled(false);

    }
     public double roundTo(double number) {
        int decimalPlaces = 1;
        BigDecimal roundNo = new BigDecimal(number);
        roundNo = roundNo.setScale(decimalPlaces, BigDecimal.ROUND_HALF_UP);
        return roundNo.doubleValue();
    }


    public void selectOneListbox1_processValueChange(ValueChangeEvent vce2) {
        buttonIndicator = 3;
        manResolveIndicator = 0;
        this.resolveUpdateIndicator = 0;
        double sum =0.0;
        double average = 0.0;
        double sumTotal=0.0;
        double totalValue=0.0;
         double percent=0.0;
        checkbox1hi4ComplainApprove.setDisabled(false);
        inputTextareaEvaSessionResolverRemarkOther.setDisabled(false);
        buttonEvaResultComplain.setDisabled(false);
        if (vce2.getNewValue() == null || vce2.getNewValue().toString().trim().equals("0")) {
            disableButtons();
            evaResultOPtOther.clear();
            panelLayoutTableControllerEvaResultOther.setRendered(true);
            this.dataTableEvaResultOther.setRendered(true);
            this.buttonEvaResultNew.setDisabled(false);
        } else {
            evaResultOPtOther.clear();
            panelLayoutTableControllerEvaResultOther.setRendered(true);
            this.dataTableEvaResultOther.setRendered(true);
            String str[] = vce2.getNewValue().toString().split("---");
            this.loadSessionResultDetail(str[2]);

            int count = evaResultManObject.countEvaSessionResult(str[2], str[1]);

            try {
                if (count > 0) {
                    enableButtons();
                    disableComponents();
                    disableTableComponents();
                    evaResultOPtOther.clear();
                    this.buttonEvaResultEdit.setDisabled(false);
                    this.buttonEvaResultSave.setDisabled(true);
                    this.buttonEvaResultNew.setDisabled(false);
                    this.buttonEvaResultCancel.setDisabled(false);

                    HashMap[] evaSessionResultList = evaResultManObject.readEvaSessionResultComplainTbl(str[2], str[1]);

                    for (int i = 0; i < evaSessionResultList.length; i++) {
                        if (evaSessionResultList[i].get("MANAGER_COMP").toString().equals("2")) {
                            manResolveIndicator = 1;
                            i = evaSessionResultList.length;
                        }
                    }

                    for (int i = 0; i < evaSessionResultList.length; i++) {
                        if (evaSessionResultList[i].get("EVALUATOR_COMP").toString().equals("1")) {
                            this.resolveUpdateIndicator = 1;
                            i = evaSessionResultList.length;
                        }
                    }

                    if (manResolveIndicator == 1) {

                        for (int i = 0; i < evaSessionResultList.length; i++) {
                            EvaluationResultManager addToEvaSessionTable = new EvaluationResultManager(
                                    evaSessionResultList[i].get("EVALUATION_RESULT_ID").hashCode(),
                                    evaSessionResultList[i].get("EVALUATION_PARA_CODE").hashCode(),
                                    evaSessionResultList[i].get("EVALUATION_SESSION_ID").hashCode(),
                                    evaSessionResultList[i].get("EMP_ID").toString(),
                                    evaSessionResultList[i].get("RESULT").toString(),
                                    evaSessionResultList[i].get("REMARK").toString(),
                                    evaSessionResultList[i].get("NAME").toString(),
                                    evaSessionResultList[i].get("FULL_NAME").toString(),
                                    evaSessionResultList[i].get("JOB_NAME").toString(),
                                    evaSessionResultList[i].get("EMP_COMP").toString(),
                                    evaSessionResultList[i].get("MANAGER_COMP").toString(),
                                    evaSessionResultList[i].get("EMP_REMARK").toString(),
                                    evaSessionResultList[i].get("RESOLVER_REMARK").toString());
                            this.evaResultOPtOther.add(addToEvaSessionTable);
                        }
                        if(this.resolveUpdateIndicator == 1){
                            checkbox1hi4ComplainApprove.setDisabled(true);
                            inputTextareaEvaSessionResolverRemarkOther.setDisabled(true);
                            buttonEvaResultComplain.setDisabled(true);
                        }
                    } else if (manResolveIndicator == 0) {
                        for (int i = 0; i < evaSessionResultList.length; i++) {


                            EvaluationResultManager addToEvaSessionTable = new EvaluationResultManager(
                                    evaSessionResultList[i].get("EVALUATION_RESULT_ID").hashCode(),
                                    evaSessionResultList[i].get("EVALUATION_PARA_CODE").hashCode(),
                                    evaSessionResultList[i].get("EVALUATION_SESSION_ID").hashCode(),
                                    evaSessionResultList[i].get("EMP_ID").toString(),
                                    evaSessionResultList[i].get("RESULT").toString(),
                                    evaSessionResultList[i].get("REMARK").toString(),
                                    evaSessionResultList[i].get("NAME").toString(),
                                    evaSessionResultList[i].get("FULL_NAME").toString(),
                                    evaSessionResultList[i].get("JOB_NAME").toString(),
                                    evaSessionResultList[i].get("EMP_COMP").toString(),
                                    evaSessionResultList[i].get("EMP_REMARK").toString(),
                                    evaSessionResultList[i].get("RESOLVER_REMARK").toString(),0);
                            this.evaResultOPtOther.add(addToEvaSessionTable);

                        }
                    }
                    outputTextEvaRSessionEmpName.setValue(evaSessionResultList[0].get("FULL_NAME").toString());
                    this.outputTextEvaRSessionEmpDepartment.setValue(evaSessionResultList[0].get("JOB_NAME").toString());

                    /*
                     * this function calculates the sum and average of evaluation resul
                     */
                    for (int i = 0; i < evaSessionResultList.length; i++) {
                          sum = sum + Double.valueOf(evaSessionResultList[i].get("RESULT").toString());
                    }
                       sumTotal=sum*100;
                        totalValue=evaSessionResultList.length*5;
                        percent=sumTotal/totalValue;
                        double finalPercent= this.roundTo(percent);
                    average = sum /evaSessionResultList.length;
                    EvaluationResultManager sumAverage  = new EvaluationResultManager(sum, average,finalPercent);
                    this.evaResultOPtAverage.add(sumAverage);


                    /*
                     *
                     */

                } else {
                    disableButtons();
                    evaResultOPtOther.clear();
                    this.buttonEvaResultNew.setDisabled(false);

                }
            } catch (Exception ex) {
                ex.printStackTrace();
                ErrorLogWriter.writeError(ex);
            }
        }
    }

    public void rowSelectorEvaResult_processMyEvent(RowSelectorEvent rse) {
        selectedEvaResultRow = rse.getRow();
    }

    public String buttonEvaResultEdit_action() {
        buttonIndicator = 4;
        enableTableComponents();
        enableButtons();
        this.buttonEvaResultEdit.setDisabled(true);
        this.buttonEvaResultSave.setDisabled(true);
        this.selectOneListbox1.setDisabled(true);
        //return null means stay on the same page
        return null;
    }

    public String buttonEvaResultUpdate_action() {
        int chekUpdate = 0;
        List evaSessionResultUpdate = this.getSessionBean1().getEvaSessionResultOPt();
        Iterator<EvaluationResultManager> ittEvaSessionResultUpdate = evaSessionResultUpdate.iterator();
        while (ittEvaSessionResultUpdate.hasNext()) {
            EvaluationResultManager evaSResultUpdate = ittEvaSessionResultUpdate.next();
            chekUpdate = evaResultManObject.addEvaSessionResultUpdate(evaSResultUpdate.getEvaResultId(), evaSResultUpdate.getResult(), evaSResultUpdate.getEvaCrtCode(), evaSResultUpdate.getEmpId(), evaSResultUpdate.getEvaSessionCode(), evaSResultUpdate.getRemark(),7);
        }
        if (chekUpdate == 1) {
            lblevaResultFormMessage.setValue("The Evaluation Result Updated successfully!!!");
            showConformationMsg(pnevaResultMessage.getStyleClass().toString());
            disableButtons();

            this.buttonEvaResultNew.setDisabled(false);


        } else {
            lblevaResultFormMessage.setValue("Error Occured during Updating the Record .Please Try Again?");
            showConformationMsg(pnevaResultMessage.getStyleClass().toString());
//            clearComponents();
//            populateTable();
        }
        //return null means stay on the same page
        return null;
    }

    public String buttonEvaResultDelete_action() {
        if (getSessionBean1().getEvaSessionResultOPt().isEmpty() == true) {
            lblevaResultFormMessage.setValue("The Table is Empty!");
            showConformationMsg(pnevaResultMessage.getStyleClass().toString());

        } else {
            lblevaResultPopUpMsgMain.setValue("Are you shure You want to delete this record?");
            evaResultPopUpMsg.setRendered(true);
            btnevaResultPopUpNo.setRendered(true);
            btnevaResultPopUpYes.setRendered(true);
        }
        //return null means stay on the same page
        return null;
    }

    public String btnevaResultPopUpYes_action() {
        evaResultPopUpMsg.setRendered(false);
        int chekDelete = 0;
        List evaSessionResultDelete = this.getSessionBean1().getEvaSessionResultOPt();
        Iterator<EvaluationResultManager> ittEvaSessionResultDelete = evaSessionResultDelete.iterator();
        while (ittEvaSessionResultDelete.hasNext()) {
            EvaluationResultManager evaSResultDelete = ittEvaSessionResultDelete.next();
            chekDelete = evaResultManObject.addEvaSessionResultDelete(evaSResultDelete.getEvaResultId());
        }
        this.getSessionBean1().getEvaSessionResultOPt().clear();
        sessionResultHistory = evaResultManObject.loadSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
        disableButtons();

        this.buttonEvaResultNew.setDisabled(false);

        //return null means stay on the same page
        return null;
    }

    public String btnevaResultPopUpNo_action() {
        evaResultPopUpMsg.setRendered(false);

        //return null means stay on the same page
        return null;

    }

    public String buttonEvaResultNew_action() {
        init();
        buttonIndicator = 1;
        this.outputTextEvaRSessionEmpDepartment.setValue("");
        this.outputTextEvaRSessionEmpName.setValue("");
        enableComponents();
        disableButtons();
        clearComponents();
        this.buttonEvaResultNew.setDisabled(true);
        this.buttonEvaResultCancel.setDisabled(false);
        this.buttonEvaResultSave.setDisabled(false);
        this.inputTextEvaResultSessionID.resetValue();
        this.inputTextEvaResultSessionID.setValue("0");
        resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
        //return null means stay on the same page
        return null;
    }

    public String buttonEvaResultCancel_action() {
        if (buttonIndicator == 1) {
            init();
        } else if (buttonIndicator == 3) {
            init();
        } else if (buttonIndicator == 4) {
            buttonIndicator = 3;
            getSessionBean1().getEvaSessionResultOPt().clear();
            disableTableComponents();
            disableButtons();
            disableComponents();
            this.buttonEvaResultEdit.setDisabled(true);
            this.buttonEvaResultSave.setDisabled(true);
            this.buttonEvaResultNew.setDisabled(false);
            this.buttonEvaResultCancel.setDisabled(false);

        }
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {

        //return null means stay on the same page
        return "EvaluationCriterias";
    }

    public String commandLink2_action() {
        //return null means stay on the same page
        return "EvaluationResult";
    }

    public String commandLink3_action() {
        //return null means stay on the same page
        return "EvaluationSession";
    }

    public String commandLink4_action() {
        //return null means stay on the same page
        return "EvaluationResultDisplay";
    }

    public String commandLink5_action() {
        //return null means stay on the same page
        return "EvaluationResultResolveComplain";
    }

    public String commandLink6_action() {
        //return null means stay on the same page
        return "EvaluationNavigation";
    }

    public void selectOneMenu1Try_processValueChange(ValueChangeEvent vce) {
    }

    public void checkbox1hi1_processValueChange(ValueChangeEvent vce) {
        if (checkbox1hi1.isSelected()) {
            this.inputTextSelectedValue.setValue("1");
            checkbox1hi2.setSelected(false);
            checkbox1hi3.setSelected(false);
            checkbox1hi4.setSelected(false);
            checkbox1hi5.setSelected(false);
        } else {
            this.inputTextSelectedValue.setValue("");
        }

    }

    public void checkbox1hi2_processValueChange(ValueChangeEvent vce) {
        if (checkbox1hi2.isSelected()) {
            this.inputTextSelectedValue.setValue("2");
            checkbox1hi1.setSelected(false);
            checkbox1hi3.setSelected(false);
            checkbox1hi4.setSelected(false);
            checkbox1hi5.setSelected(false);
        } else {
            this.inputTextSelectedValue.setValue("");
        }
    }

    public void checkbox1hi3_processValueChange(ValueChangeEvent vce) {
        if (checkbox1hi3.isSelected()) {
            this.inputTextSelectedValue.setValue("3");
            checkbox1hi2.setSelected(false);
            checkbox1hi1.setSelected(false);
            checkbox1hi4.setSelected(false);
            checkbox1hi5.setSelected(false);
        } else {
            this.inputTextSelectedValue.setValue("");
        }
    }

    public void checkbox1hi4_processValueChange(ValueChangeEvent vce) {
        if (checkbox1hi4.isSelected()) {
            this.inputTextSelectedValue.setValue("4");
            checkbox1hi2.setSelected(false);
            checkbox1hi3.setSelected(false);
            checkbox1hi1.setSelected(false);
            checkbox1hi5.setSelected(false);
        } else {
            this.inputTextSelectedValue.setValue("");
        }
    }

    public void checkbox1hi5_processValueChange(ValueChangeEvent vce) {
        if (checkbox1hi5.isSelected()) {
            this.inputTextSelectedValue.setValue("5");
            checkbox1hi2.setSelected(false);
            checkbox1hi3.setSelected(false);
            checkbox1hi4.setSelected(false);
            checkbox1hi1.setSelected(false);
        } else {
            this.inputTextSelectedValue.setValue("");
        }
    }

    public String buttonEvaResultComplain_action() {
        int chekSave = 0;
        List evaSessionResultComp = this.evaResultOPtOther;
        Iterator<EvaluationResultManager> ittEvaSessionResult = evaSessionResultComp.iterator();
        while (ittEvaSessionResult.hasNext()) {
            EvaluationResultManager evaSResult = ittEvaSessionResult.next();
            chekSave = evaResultManObject.resolveComplainResult(evaSResult.isSelectedAppComp(), evaSResult.getResolverRemark(), String.valueOf(evaSResult.getEvaResultId()));
        }
        if (chekSave == 1) {
            this.showSuccessOrFailureMessage(true, "This Complain successfuly Resolved!!!");
            sessionResultHistory = evaResultManObject.loadSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
            clearComponents();
            disableButtons();
            this.txtSearchByNameEvaResult.resetValue();
            this.outputTextEvaRSessionEmpDepartment.setValue("");
            this.outputTextEvaRSessionEmpName.setValue("");
            this.inputTextEvaResultSessionEmpID.setValue("");
            this.buttonEvaResultNew.setDisabled(false);
            outputTextevaSessionEvaResultSerarch.setValue("");
            // this.inputTextEvaResultSessionID.setValue("0");
            resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
            this.evaResultOPt.clear();
            resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
            disableComponents();

        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");

        }

        //return null means stay on the same page
        return null;
    }

    public void selectOneMenu1EvaluatorName_processValueChange(ValueChangeEvent vce) {
        outputTextevaSessionEvaResultSerarch.setValue("");
        outputTextselectOneMenuEvaResult.setValue("");
        this.outputTextEvaRSessionEmpDepartment.setValue("");
        this.outputTextEvaRSessionEmpName.setValue("");
        this.inputTextEvaResultSessionEmpID.setValue("");

        if (vce.getNewValue() == null) {
            this.selectOneListbox1.setDisabled(false);
        } else {
            this.selectOneListbox1.setDisabled(false);
            selectedSessionId = vce.getNewValue().toString();
            sessionResultHistory = evaResultManObject.loadSessionResultsComplainedResolver(this.sessionIdResolve, selectedSessionId);
        }
    }
}

