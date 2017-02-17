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
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import javax.faces.component.UISelectItems;
import javax.faces.component.html.HtmlOutputLabel;
import javax.faces.event.ValueChangeEvent;
import manager.employeeHistoryManager.EvaluationResultManager;
import manager.employeeManager.EmployeeManage;
import java.util.List;
import javax.faces.context.FacesContext;
//import javax.swing.JOptionPane;


/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class EvaluationResult extends AbstractPageBean {

    /**
     * @return the selectedId
     */
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
    private Option[] sessionResultHistoryComplained;
    public double lastResult;
    public double lastPercentValue;
    public double lastAveValue;
    public String evaluatedEmpID;
    public String sessionID;
    public String evaluaterID;
    public String currentDate;
    int selectedEvaResultRow = -1;
    int buttonIndicator = 0;
    int updateDeleteIndicator = 0;
    int updateDeleteIndicatorBtn = 0;
    int resultIdHolderForResolve = 0;
    Option[] resultPurpose;
    private static String selectedId;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    EmployeeManage employeeManager = new EmployeeManage();
    EvaluationResultManager evaResultManObject = new EvaluationResultManager();
    ArrayList<EvaluationResultManager> evaSessionResultMList = new ArrayList<EvaluationResultManager>();
    private List evaResultOPtOther = new ArrayList<EvaluationResultManager>();
    private List evaResultOPtCompResolvePop = new ArrayList<EvaluationResultManager>();
    private Option[] resultPurposeForDisplay;
    private Option[] toFilterEmployeesBy;
    private Option[] toFilterResultUsingSession;
    private Option[] allEmpToBeEvaluated;
    private List evaResultOPtAverage = new ArrayList<EvaluationResultManager>();

    public String getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(String currentDate) {
        this.currentDate = currentDate;
    }

    public String getEvaluaterID() {
        return evaluaterID;
    }

    public void setEvaluaterID(String evaluaterID) {
        this.evaluaterID = evaluaterID;
    }

    public String getSessionID() {
        return sessionID;
    }

    public void setSessionID(String sessionID) {
        this.sessionID = sessionID;
    }

    public Option[] getToFilterResultUsingSession() {
        return toFilterResultUsingSession;
    }

    public void setToFilterResultUsingSession(Option[] toFilterResultUsingSession) {
        this.toFilterResultUsingSession = toFilterResultUsingSession;
    }

    public Option[] getToFilterEmployeesBy() {
        return toFilterEmployeesBy;
    }

    public void setToFilterEmployeesBy(Option[] toFilterEmployeesBy) {
        this.toFilterEmployeesBy = toFilterEmployeesBy;
    }

    public List getEvaResultOPtAverage() {
        return evaResultOPtAverage;
    }

    public void setEvaResultOPtAverage(List evaResultOPtAverage) {
        this.evaResultOPtAverage = evaResultOPtAverage;
    }

    public List getEvaResultOPtCompResolvePop() {
        return evaResultOPtCompResolvePop;
    }

    public void setEvaResultOPtCompResolvePop(List evaResultOPtCompResolvePop) {
        this.evaResultOPtCompResolvePop = evaResultOPtCompResolvePop;
    }

    public Option[] getSessionResultHistoryComplained() {
        return sessionResultHistoryComplained;
    }

    public void setSessionResultHistoryComplained(Option[] sessionResultHistoryComplained) {
        this.sessionResultHistoryComplained = sessionResultHistoryComplained;
    }

    public Option[] getAllEmpToBeEvaluated() {
        return allEmpToBeEvaluated;
    }

    public void setAllEmpToBeEvaluated(Option[] allEmpToBeEvaluated) {
        this.allEmpToBeEvaluated = allEmpToBeEvaluated;
    }

    public List getEvaResultOPtOther() {
        return evaResultOPtOther;
    }

    public void setEvaResultOPtOther(List evaResultOPtOther) {
        this.evaResultOPtOther = evaResultOPtOther;
    }

    public Option[] getResultPurposeForDisplay() {
        return resultPurposeForDisplay;
    }

    public void setResultPurposeForDisplay(Option[] resultPurposeForDisplay) {
        this.resultPurposeForDisplay = resultPurposeForDisplay;
    }

    public ArrayList<EvaluationResultManager> getFileAttachment() {
        return evaSessionResultMList;
    }

    public void setFileAttachment(ArrayList<EvaluationResultManager> evaSessionResultMList) {
        this.evaSessionResultMList = evaSessionResultMList;
    }

    public String getEvaluatedEmpID() {
        return evaluatedEmpID;
    }

    public void setEvaluatedEmpID(String evaluatedEmpID) {
        this.evaluatedEmpID = evaluatedEmpID;
    }

    public double getLastAveValue() {
        return lastAveValue;
    }

    public void setLastAveValue(double lastAveValue) {
        this.lastAveValue = lastAveValue;
    }

    public double getLastPercentValue() {
        return lastPercentValue;
    }

    public void setLastPercentValue(double lastPercentValue) {
        this.lastPercentValue = lastPercentValue;
    }

    public double getLastResult() {
        return lastResult;
    }

    public void setLastResult(double lastResult) {
        this.lastResult = lastResult;
    }

    public void selectOneMenuEvaResult_processValueChange(ValueChangeEvent vce) {

        selectOneListbox1.resetValue();
        enableTableComponents();
        columnEvaSessionResult3InValid.setRendered(true);
        checkbox1hi4Invalid.setRendered(true);
        columnEvaSessionComplainRemarkOther.setRendered(false);
        columnEvaSessionResolverRemarkOther.setRendered(false);
        rowSelectorEvaResult.setRendered(false);
        outputTextevaSessionEvaResultSerarch.setValue("");
        outputTextselectOneMenuEvaResult.setValue("");
        this.outputTextEvaRSessionEmpDepartment.setValue("");
        this.outputTextEvaRSessionEmpName.setValue("");
        this.inputTextEvaResultSessionEmpID.setValue("");
        if (vce.getNewValue() == null && vce.getNewValue().toString().equals("0")) {
            this.selectOneListbox1.setDisabled(true);
        } else {

            this.selectOneListbox1.setDisabled(false);
            selectedSessionId = vce.getNewValue().toString();
            this.loadSessionResultDetail(selectedSessionId);
            sessionResultHistory = evaResultManObject.loadIndividualSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
            sessionResultHistoryComplained = evaResultManObject.loadSessionResultsComplained(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
            populateResultTable(Integer.valueOf(this.inputTextEvaResultSessionID.getValue().toString()));
        }

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

    public Option[] getResultPurpose() {
        return resultPurpose;
    }

    public void setResultPurpose(Option[] resultPurpose) {
        this.resultPurpose = resultPurpose;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectedData selectOneListbox2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneListbox2Bean() {
        return selectOneListbox2Bean;
    }

    public void setSelectOneListbox2Bean(DefaultSelectedData dsd) {
        this.selectOneListbox2Bean = dsd;
    }
    private DefaultSelectionItems selectOneListbox2DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneListbox2DefaultItems() {
        return selectOneListbox2DefaultItems;
    }

    public void setSelectOneListbox2DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneListbox2DefaultItems = dsi;
    }
    private UIColumn columnEvaSessionResult3Complain = new UIColumn();

    public UIColumn getColumnEvaSessionResult3Complain() {
        return columnEvaSessionResult3Complain;
    }

    public void setColumnEvaSessionResult3Complain(UIColumn uic) {
        this.columnEvaSessionResult3Complain = uic;
    }
    private UIColumn columnEvaSessionResult3ComplainApprove = new UIColumn();

    public UIColumn getColumnEvaSessionResult3ComplainApprove() {
        return columnEvaSessionResult3ComplainApprove;
    }

    public void setColumnEvaSessionResult3ComplainApprove(UIColumn uic) {
        this.columnEvaSessionResult3ComplainApprove = uic;
    }
    private HtmlSelectOneMenu selectOneMenuToBeEvaluated = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuToBeEvaluated() {
        return selectOneMenuToBeEvaluated;
    }

    public void setSelectOneMenuToBeEvaluated(HtmlSelectOneMenu hsom) {
        this.selectOneMenuToBeEvaluated = hsom;
    }
    private HtmlOutputText outputTextselectOneMenuEvaResultEvaluatee = new HtmlOutputText();

    public HtmlOutputText getOutputTextselectOneMenuEvaResultEvaluatee() {
        return outputTextselectOneMenuEvaResultEvaluatee;
    }

    public void setOutputTextselectOneMenuEvaResultEvaluatee(HtmlOutputText hot) {
        this.outputTextselectOneMenuEvaResultEvaluatee = hot;
    }
    private UIColumn columnEvaSessionResult1 = new UIColumn();

    public UIColumn getColumnEvaSessionResult1() {
        return columnEvaSessionResult1;
    }

    public void setColumnEvaSessionResult1(UIColumn uic) {
        this.columnEvaSessionResult1 = uic;
    }
    private UIColumn columnEvaSessionResult2Other = new UIColumn();

    public UIColumn getColumnEvaSessionResult2Other() {
        return columnEvaSessionResult2Other;
    }

    public void setColumnEvaSessionResult2Other(UIColumn uic) {
        this.columnEvaSessionResult2Other = uic;
    }
    private UIColumn columnEvaSessionResult3Other = new UIColumn();

    public UIColumn getColumnEvaSessionResult3Other() {
        return columnEvaSessionResult3Other;
    }

    public void setColumnEvaSessionResult3Other(UIColumn uic) {
        this.columnEvaSessionResult3Other = uic;
    }
    private UIColumn columnEvaSessionResult4Other = new UIColumn();

    public UIColumn getColumnEvaSessionResult4Other() {
        return columnEvaSessionResult4Other;
    }

    public void setColumnEvaSessionResult4Other(UIColumn uic) {
        this.columnEvaSessionResult4Other = uic;
    }
    private UIColumn columnEvaSessionCriteria = new UIColumn();

    public UIColumn getColumnEvaSessionCriteria() {
        return columnEvaSessionCriteria;
    }

    public void setColumnEvaSessionCriteria(UIColumn uic) {
        this.columnEvaSessionCriteria = uic;
    }
    private UIColumn columnEvaSessionResult = new UIColumn();

    public UIColumn getColumnEvaSessionResult() {
        return columnEvaSessionResult;
    }

    public void setColumnEvaSessionResult(UIColumn uic) {
        this.columnEvaSessionResult = uic;
    }
    private UIColumn columnEvaSessionResult2 = new UIColumn();

    public UIColumn getColumnEvaSessionResult2() {
        return columnEvaSessionResult2;
    }

    public void setColumnEvaSessionResult2(UIColumn uic) {
        this.columnEvaSessionResult2 = uic;
    }
    private UIColumn columnEvaSessionResult3 = new UIColumn();

    public UIColumn getColumnEvaSessionResult3() {
        return columnEvaSessionResult3;
    }

    public void setColumnEvaSessionResult3(UIColumn uic) {
        this.columnEvaSessionResult3 = uic;
    }
    private UIColumn columnEvaSessionResult4 = new UIColumn();

    public UIColumn getColumnEvaSessionResult4() {
        return columnEvaSessionResult4;
    }

    public void setColumnEvaSessionResult4(UIColumn uic) {
        this.columnEvaSessionResult4 = uic;
    }
    private UIColumn columnEvaSessionResultR = new UIColumn();

    public UIColumn getColumnEvaSessionResultR() {
        return columnEvaSessionResultR;
    }

    public void setColumnEvaSessionResultR(UIColumn uic) {
        this.columnEvaSessionResultR = uic;
    }
    private UIColumn columnEvaSessionRemark = new UIColumn();

    public UIColumn getColumnEvaSessionRemark() {
        return columnEvaSessionRemark;
    }

    public void setColumnEvaSessionRemark(UIColumn uic) {
        this.columnEvaSessionRemark = uic;
    }
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
    private DefaultTableDataModel dataTable1Model3 = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model3() {
        return dataTable1Model3;
    }

    public void setDataTable1Model3(DefaultTableDataModel dtdm) {
        this.dataTable1Model3 = dtdm;
    }
    private PanelPopup evaResultPopUpResolveComp = new PanelPopup();

    public PanelPopup getEvaResultPopUpResolveComp() {
        return evaResultPopUpResolveComp;
    }

    public void setEvaResultPopUpResolveComp(PanelPopup pp) {
        this.evaResultPopUpResolveComp = pp;
    }
    private HtmlCommandButton btnevaResultPopUpResolveCompUpdate = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaResultPopUpResolveCompUpdate() {
        return btnevaResultPopUpResolveCompUpdate;
    }

    public void setBtnevaResultPopUpResolveCompUpdate(HtmlCommandButton hcb) {
        this.btnevaResultPopUpResolveCompUpdate = hcb;
    }
    private HtmlCommandButton btnevaResultPopUpResolveCompCancel = new HtmlCommandButton();

    public HtmlCommandButton getBtnevaResultPopUpResolveCompCancel() {
        return btnevaResultPopUpResolveCompCancel;
    }

    public void setBtnevaResultPopUpResolveCompCancel(HtmlCommandButton hcb) {
        this.btnevaResultPopUpResolveCompCancel = hcb;
    }
    private UIColumn column2Sel1 = new UIColumn();

    public UIColumn getColumn2Sel1() {
        return column2Sel1;
    }

    public void setColumn2Sel1(UIColumn uic) {
        this.column2Sel1 = uic;
    }
    private UIColumn column3Sel2 = new UIColumn();

    public UIColumn getColumn3Sel2() {
        return column3Sel2;
    }

    public void setColumn3Sel2(UIColumn uic) {
        this.column3Sel2 = uic;
    }
    private UIColumn column3Sel3 = new UIColumn();

    public UIColumn getColumn3Sel3() {
        return column3Sel3;
    }

    public void setColumn3Sel3(UIColumn uic) {
        this.column3Sel3 = uic;
    }
    private UIColumn column3Sel4 = new UIColumn();

    public UIColumn getColumn3Sel4() {
        return column3Sel4;
    }

    public void setColumn3Sel4(UIColumn uic) {
        this.column3Sel4 = uic;
    }
    private UIColumn column3Sel5 = new UIColumn();

    public UIColumn getColumn3Sel5() {
        return column3Sel5;
    }

    public void setColumn3Sel5(UIColumn uic) {
        this.column3Sel5 = uic;
    }
    private UIColumn column3SelR = new UIColumn();

    public UIColumn getColumn3SelR() {
        return column3SelR;
    }

    public void setColumn3SelR(UIColumn uic) {
        this.column3SelR = uic;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox outputText9PopSel1 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getOutputText9PopSel1() {
        return outputText9PopSel1;
    }

    public void setOutputText9PopSel1(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.outputText9PopSel1 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox outputText11PopSel2 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getOutputText11PopSel2() {
        return outputText11PopSel2;
    }

    public void setOutputText11PopSel2(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.outputText11PopSel2 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox outputText11PopSel3 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getOutputText11PopSel3() {
        return outputText11PopSel3;
    }

    public void setOutputText11PopSel3(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.outputText11PopSel3 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox outputText11PopSel4 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getOutputText11PopSel4() {
        return outputText11PopSel4;
    }

    public void setOutputText11PopSel4(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.outputText11PopSel4 = hsbc;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox outputText11PopSel5 = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getOutputText11PopSel5() {
        return outputText11PopSel5;
    }

    public void setOutputText11PopSel5(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.outputText11PopSel5 = hsbc;
    }
    private HtmlInputText outputText11PopSelR = new HtmlInputText();

    public HtmlInputText getOutputText11PopSelR() {
        return outputText11PopSelR;
    }

    public void setOutputText11PopSelR(HtmlInputText hit) {
        this.outputText11PopSelR = hit;
    }
    private com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox checkbox1hi4Invalid = new com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox();

    public com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox getCheckbox1hi4Invalid() {
        return checkbox1hi4Invalid;
    }

    public void setCheckbox1hi4Invalid(com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox hsbc) {
        this.checkbox1hi4Invalid = hsbc;
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
    private UIColumn columnEvaSessionResolverRemarkOther = new UIColumn();

    public UIColumn getColumnEvaSessionResolverRemarkOther() {
        return columnEvaSessionResolverRemarkOther;
    }

    public void setColumnEvaSessionResolverRemarkOther(UIColumn uic) {
        this.columnEvaSessionResolverRemarkOther = uic;
    }
    private UIColumn columnEvaSessionComplainRemarkOther = new UIColumn();

    public UIColumn getColumnEvaSessionComplainRemarkOther() {
        return columnEvaSessionComplainRemarkOther;
    }

    public void setColumnEvaSessionComplainRemarkOther(UIColumn uic) {
        this.columnEvaSessionComplainRemarkOther = uic;
    }
    private UIColumn columnEvaSessionResult3InValid = new UIColumn();

    public UIColumn getColumnEvaSessionResult3InValid() {
        return columnEvaSessionResult3InValid;
    }

    public void setColumnEvaSessionResult3InValid(UIColumn uic) {
        this.columnEvaSessionResult3InValid = uic;
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
    private PanelLayout panelLOutTOBeEvaluated = new PanelLayout();

    public PanelLayout getPanelLOutTOBeEvaluated() {
        return panelLOutTOBeEvaluated;
    }

    public void setPanelLOutTOBeEvaluated(PanelLayout pl) {
        this.panelLOutTOBeEvaluated = pl;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems() {
        return selectOneMenu1DefaultItems;
    }

    public void setSelectOneMenu1DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems = dsi;
    }
    private HtmlSelectOneMenu selectOneMenuSessionResultFilter = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getSelectOneMenuSessionResultFilter() {
        return selectOneMenuSessionResultFilter;
    }

    public void setSelectOneMenuSessionResultFilter(HtmlSelectOneMenu hsom) {
        this.selectOneMenuSessionResultFilter = hsom;
    }
    private HtmlCommandButton btn_percent_Save = new HtmlCommandButton();

    public HtmlCommandButton getBtn_percent_Save() {
        return btn_percent_Save;
    }

    public void setBtn_percent_Save(HtmlCommandButton hcb) {
        this.btn_percent_Save = hcb;
    }

    public EvaluationResult() {
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
        resultPurpose = evaResultManObject.readResultOption();
        resultPurposeForDisplay = evaResultManObject.readPurposeForDisplay();
        disableComponents();
        disableButtons();
        this.toFilterResultUsingSession = evaResultManObject.readAllSessionsResultsGivenTo();
        this.toFilterEmployeesBy = evaResultManObject.optionToFilterEmployee();
        this.evaResultOPtOther.clear();
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
        selectOneMenuToBeEvaluated.setRequired(true);
        selectOneMenuToBeEvaluated.setRequiredMessage("Requred");
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

    public void clearComponents() {
        this.selectOneMenuEvaResult.setValue(0);
        this.txtSearchByNameEvaResult.setValue("");
        this.outputTextEvaRSessionEmpDepartment.setValue("");
        this.outputTextEvaRSessionEmpName.setValue("");
        this.outputTextEvaResultAutorizedAnswer.setValue("");
        this.outputTextEvaResultEndingDateAnswer.setValue("");
        this.outputTextEvaResultStartingDateAnswer.setValue("");
    }

    public void disableComponents() {
        this.txtSearchByNameEvaResult.setDisabled(true);
        this.selectOneMenuEvaResult.setDisabled(true);
        this.selectOneMenuSessionResultFilter.setDisabled(true);

    }

    public void enableComponents() {
        this.btn_percent_Save.setDisabled(false);
        this.txtSearchByNameEvaResult.setDisabled(false);
        this.selectOneMenuEvaResult.setDisabled(false);
        this.selectOneListbox1.setDisabled(false);
        this.selectOneMenuSessionResultFilter.setDisabled(false);
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

    public void populateResultTable(int sessionID) {
        this.evaResultOPtOther.clear();
        columnEvaSessionComplainRemarkOther.setRendered(false);
        columnEvaSessionResolverRemarkOther.setRendered(false);
        columnEvaSessionResult3Complain.setRendered(false);
        columnEvaSessionResult3ComplainApprove.setRendered(false);
        int count = evaResultManObject.countEvaResult(sessionID);
        try {
            if (count > 0) {
                HashMap[] evaResultList = evaResultManObject.readEvaResultTbl(sessionID);
                for (int i = 0; i < evaResultList.length; i++) {
                    EvaluationResultManager addToTable = new EvaluationResultManager(evaResultList[i].get("EVALUATION_PARA_CODE").hashCode(), evaResultList[i].get("NAME").toString(), evaResultList[i].get("CATEGORY").toString());
                    this.evaResultOPtOther.add(addToTable);
                }
            } else {
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        ////(null, ex.getMessage());
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
            this.outputTextEvaRSessionEmpName.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            this.outputTextEvaRSessionEmpDepartment.setValue(employeeManager.getJobName());
            this.inputTextEvaResultSessionEmpID.setValue(empId);

        } catch (Exception ex) {
        }
    }

    public String buttonEvaResultSave_action() {
        int chekSave = 0;
        int checkId = 0;
        String evaluatorID[] = this.lblStatusEvaluatorValue.getValue().toString().split("--");
        buttonIndicator = 2;
        if (inputTextEvaResultSessionID.getValue().toString().equals("0") || selectOneMenuEvaResult.getValue().equals("0")) {
            outputTextselectOneMenuEvaResult.setValue("Requred");
            outputTextselectOneMenuEvaResult.setRendered(true);
        } else {
            if (this.inputTextEvaResultSessionEmpID.getValue() == null ||
                    this.inputTextEvaResultSessionEmpID.getValue().toString().equals("") || selectOneMenuToBeEvaluated.getValue().toString().equals("0")) {
                outputTextselectOneMenuEvaResultEvaluatee.setRendered(true);
                outputTextselectOneMenuEvaResultEvaluatee.setValue("Requred");
            } else {

                checkId = evaResultManObject.serEvaSessionSearchId(this.inputTextEvaResultSessionEmpID.getValue().toString(), Integer.parseInt(this.inputTextEvaResultSessionID.getValue().toString()));

                if (checkId >= 1) {

                    this.showSuccessOrFailureMessage(false, this.outputTextEvaRSessionEmpName.getValue() + " Can't Evaluated two times on the same Session!!!");

                } else if (selectOneMenuToBeEvaluated.getValue().toString().equals(this.getSessionBean1().getEmployeeId())) {

                    this.showSuccessOrFailureMessage(false, this.outputTextEvaRSessionEmpName.getValue() + " Can't Evaluate One Self!!!");


                } else {
                    int indicate = 1;
                    if (!this.evaResultOPtOther.isEmpty() && this.evaResultOPtOther != null)
                    {
                        List evaSessionResult = this.evaResultOPtOther;
                        Iterator<EvaluationResultManager> ittEvaSessionResult1 = evaSessionResult.iterator();
                        while (ittEvaSessionResult1.hasNext()) {
                            EvaluationResultManager evaSResult = ittEvaSessionResult1.next();

                            if (evaSResult.getSelectedValue() == null && evaSResult.isInvalid() == false) {
                                indicate = 0;
                            }
                        }
                        Iterator<EvaluationResultManager> ittEvaSessionResult = evaSessionResult.iterator();
                        if (indicate == 1) {
                            while (ittEvaSessionResult.hasNext()) {
                                EvaluationResultManager evaSResult = ittEvaSessionResult.next();
                                if (evaSResult.isInvalid() == true) {
                                } else {
                                    chekSave = evaResultManObject.addEvaSessionResult(evaSResult.getSelectedValue().toString(), evaSResult.getEvaCrtCode(), this.inputTextEvaResultSessionEmpID.getValue().toString(), Integer.valueOf(this.inputTextEvaResultSessionID.getValue().toString()), evaSResult.getRemark(), evaluatorID[1], evaSResult.isInvalid());
                                }
                            }
                            if (chekSave == 1) {
                                this.showSuccessOrFailureMessage(true, "The Evaluation Result Saved successfully!!!");
                                sessionResultHistory = evaResultManObject.loadIndividualSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
                                clearComponents();
                                disableButtons();
                                this.txtSearchByNameEvaResult.resetValue();
                                this.outputTextEvaRSessionEmpDepartment.setValue("");
                                this.outputTextEvaRSessionEmpName.setValue("");
                                this.inputTextEvaResultSessionEmpID.setValue("");
                                this.buttonEvaResultNew.setDisabled(false);
                                outputTextevaSessionEvaResultSerarch.setValue("");
                                selectOneMenuToBeEvaluated.setValue("0");
                                resultPurpose = evaResultManObject.readResultOption();
                                this.evaResultOPtOther.clear();
                                resultPurpose = evaResultManObject.readResultOption();
                                disableComponents();

                            } else {
                                this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
                            }
                        } else {
                            this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
                        }
                    } else {
                        this.showSuccessOrFailureMessage(false, "Error Occured during saving .Please Try Again?");
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
        inputTextSelectedValue.setDisabled(true);
        checkbox1hi1.setDisabled(true);
        checkbox1hi2.setDisabled(true);
        checkbox1hi3.setDisabled(true);
        checkbox1hi4.setDisabled(true);
        checkbox1hi5.setDisabled(true);
        checkbox1hi4Invalid.setDisabled(true);
        inputTextareaEvaSessionRemark.setDisabled(true);


    }

    public void enableTableComponents() {
        this.inputTextEvaSessionResultR.setDisabled(false);
        this.inputTextAreaEvaSessionResultR.setDisabled(false);
        inputTextSelectedValue.setDisabled(false);
        checkbox1hi1.setDisabled(false);
        checkbox1hi2.setDisabled(false);
        checkbox1hi3.setDisabled(false);
        checkbox1hi4.setDisabled(false);
        checkbox1hi5.setDisabled(false);
        checkbox1hi4Invalid.setDisabled(false);
        inputTextareaEvaSessionRemark.setDisabled(false);


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

    public void selectOneListbox1_processValueChange(ValueChangeEvent vce) {
        buttonIndicator = 3;
        updateDeleteIndicator = 0;
        updateDeleteIndicatorBtn = 1;
        double sum = 0.0;
        double sumTotal=0.0;
        double totalValue=0.0;
        double average = 0.0;
        double percent=0.0;
        rowSelectorEvaResult.setRendered(false);
        evaResultOPtOther.clear();
        this.evaResultOPtAverage.clear();
        columnEvaSessionResult3Complain.setRendered(false);
        columnEvaSessionResult3ComplainApprove.setRendered(false);
        columnEvaSessionResult3InValid.setRendered(false);
        columnEvaSessionComplainRemarkOther.setRendered(false);
        columnEvaSessionResolverRemarkOther.setRendered(false);
        checkbox1hi4Invalid.setRendered(true);
        try {
            if (vce.getNewValue() == null || vce.getNewValue().toString().trim().equals("0")) {
                evaResultOPtOther.clear();
                disableButtons();
                if (this.allEmpToBeEvaluated == null) {
                    this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "1");
                } else {
                    selectOneMenuToBeEvaluated.resetValue();
                    selectOneMenuToBeEvaluated.setValue("0");
                }
                outputTextEvaRSessionEmpName.setValue("");
                this.outputTextEvaRSessionEmpDepartment.setValue("");
                this.buttonEvaResultNew.setDisabled(false);
                this.buttonEvaResultUpdate.setDisabled(true);

            } else {

                evaResultOPtOther.clear();
                String str[] = vce.getNewValue().toString().split("---");
                int count = evaResultManObject.countEvaSessionResult(str[2], str[1]);
                if (this.allEmpToBeEvaluated == null) {
                    this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "1");
                } else {
                    selectOneMenuToBeEvaluated.resetValue();
                    selectOneMenuToBeEvaluated.setValue(str[1]);
                }

                this.loadSessionResultDetail(str[2]);
                try {
                    if (count > 0) {
                        enableButtons();
                        disableComponents();
                        disableTableComponents();
                        this.buttonEvaResultEdit.setDisabled(false);
                        this.buttonEvaResultSave.setDisabled(true);
                        this.buttonEvaResultNew.setDisabled(false);
                        this.buttonEvaResultCancel.setDisabled(false);
                        this.buttonEvaResultUpdate.setDisabled(true);


                        HashMap[] evaSessionResultList = evaResultManObject.readEvaSessionResultComplainTbl(str[2], str[1]);

                        for (int i = 0; i < evaSessionResultList.length; i++) {
                            if (evaSessionResultList[i].get("EMP_COMP").toString().equals("1")) {
                                updateDeleteIndicator = 1;
                                i = evaSessionResultList.length;
                            }
                        }

                        for (int i = 0; i < evaSessionResultList.length; i++) {
                            this.sessionID=evaSessionResultList[i].get("EVALUATION_SESSION_ID").toString();
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
                                    evaSessionResultList[i].get("EMP_COMP").toString());
                            this.evaResultOPtOther.add(addToEvaSessionTable);

                        }
                        outputTextEvaRSessionEmpName.setValue(evaSessionResultList[0].get("FULL_NAME").toString());
                        this.outputTextEvaRSessionEmpDepartment.setValue(evaSessionResultList[0].get("JOB_NAME").toString());
                        this.evaluatedEmpID=evaSessionResultList[0].get("EMP_ID").toString();


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
                      
                        average = sum / evaSessionResultList.length;
                        EvaluationResultManager sumAverage = new EvaluationResultManager(sum, average,finalPercent);
                       this.evaResultOPtAverage.add(sumAverage);
                       this.lastResult=sum;
                       this.lastPercentValue=finalPercent;
                       this.lastAveValue=average;
                       this.evaluaterID= this.getSessionBean1().getEmployeeId();
                       currentDate=dateFormat.format(new Date());

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

                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }

    public void rowSelectorEvaResult_processMyEvent(RowSelectorEvent rse) {
        selectedEvaResultRow = rse.getRow();
    }

    public String buttonEvaResultEdit_action() {
        buttonIndicator = 4;
        if (updateDeleteIndicator == 1 && updateDeleteIndicatorBtn == 1) {
            this.showSuccessOrFailureMessage(true, "You Don't have an authorization to Edit!!!");
        } else if (updateDeleteIndicatorBtn == 2) {
            if (this.selectedEvaResultRow == -1) {
                this.showSuccessOrFailureMessage(false, "You have to select a record from the table!!!");

            } else if (this.evaResultOPtOther.isEmpty() == true && selectedEvaResultRow != -1) {
                this.showSuccessOrFailureMessage(false, "The Table is Empty!");
            } else if (updateDeleteIndicator == 2) {
                EvaluationResultManager evaResult = (EvaluationResultManager) evaResultOPtOther.get(selectedEvaResultRow);

                if (evaResult.isSelectedAppComp() == true) {
                    resultIdHolderForResolve = evaResult.getEvaResultId();
                    this.evaResultOPtCompResolvePop.clear();
                    this.evaResultOPtCompResolvePop.add(evaResult);
                    evaResultPopUpResolveComp.setRendered(true);
                } else {
                    this.showSuccessOrFailureMessage(false, "You can't Edit this Record Because your manager does not Approve it.");
                }


            } else {
                this.showSuccessOrFailureMessage(true, "You Don't have an authorization to Edit!!!");
            }
        } else {
            enableTableComponents();
            enableButtons();
            this.buttonEvaResultEdit.setDisabled(true);
            this.buttonEvaResultSave.setDisabled(true);
//        this.selectOneListbox1.setDisabled(true);
        }
        //return null means stay on the same page
        return null;
    }

    public String buttonEvaResultUpdate_action() {
        int chekUpdate = 0;
        this.buttonIndicator = 7;
        List evaSessionResultUpdate = this.evaResultOPtOther;
        Iterator<EvaluationResultManager> ittEvaSessionResultUpdate = evaSessionResultUpdate.iterator();
        while (ittEvaSessionResultUpdate.hasNext()) {
            EvaluationResultManager evaSResultUpdate = ittEvaSessionResultUpdate.next();
            chekUpdate = evaResultManObject.addEvaSessionResultUpdate(evaSResultUpdate.getEvaResultId(), evaSResultUpdate.getSelectedValue(), evaSResultUpdate.getEvaCrtCode(), evaSResultUpdate.getEmpId(), evaSResultUpdate.getEvaSessionCode(), evaSResultUpdate.getRemark(), this.buttonIndicator);
        }
        if (chekUpdate == 1) {
            this.showSuccessOrFailureMessage(true, "The Evaluation Result Updated successfully!!!");
            disableButtons();
            this.buttonEvaResultNew.setDisabled(false);


        } else {
            this.showSuccessOrFailureMessage(false, "Error Occured during Updating the Record .Please Try Again?");
        }
        //return null means stay on the same page
        return null;
    }

    public String buttonEvaResultDelete_action() {
        if (this.evaResultOPtOther.isEmpty() == true) {
            this.showSuccessOrFailureMessage(false, "The Table is Empty!");
        } else if (updateDeleteIndicator == 1 && updateDeleteIndicatorBtn == 1) {
            this.showSuccessOrFailureMessage(true, "You Don't have an authorization to Edit!!!");
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
        List evaSessionResultDelete = this.getEvaResultOPtOther();
        Iterator<EvaluationResultManager> ittEvaSessionResultDelete = evaSessionResultDelete.iterator();
        while (ittEvaSessionResultDelete.hasNext()) {
            EvaluationResultManager evaSResultDelete = ittEvaSessionResultDelete.next();
            chekDelete = evaResultManObject.addEvaSessionResultDelete(evaSResultDelete.getEvaResultId());
        }
        this.evaResultOPtOther.clear();
        sessionResultHistory = evaResultManObject.loadIndividualSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
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
        this.evaResultOPtOther.clear();
        this.buttonEvaResultNew.setDisabled(true);
        this.buttonEvaResultCancel.setDisabled(false);
        this.buttonEvaResultSave.setDisabled(false);
        this.buttonEvaResultUpdate.setDisabled(true);
        this.inputTextEvaResultSessionID.resetValue();
        this.inputTextEvaResultSessionID.setValue("0");
        if (selectOneMenuToBeEvaluated.getValue() != null) {
            selectOneMenuToBeEvaluated.setValue("0");
        }

        resultPurpose = evaResultManObject.readResultOption();
        sessionResultHistory = evaResultManObject.loadIndividualSessionResults(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());
        sessionResultHistoryComplained = evaResultManObject.loadSessionResultsComplained(this.inputTextEvaResultSessionID.getValue().toString(), this.getSessionBean1().getEmployeeId());

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

    public String modalPnlCloseMesssage_action() {
        pnMessage.setRendered(false);
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

    public void selectOneMenuToBeEvaluated_processValueChange(ValueChangeEvent vce) {
        employeeManager.loadEmpoyeeProfile(vce.getNewValue().toString());
        if (!vce.getNewValue().toString().equals("0") && vce.getNewValue() != null) {
            this.outputTextEvaRSessionEmpName.setValue(employeeManager.getTitleDes() + " " + employeeManager.getFirst_Name() + " " + employeeManager.getMiddle_Name() + " " + employeeManager.getLast_Name());
            this.outputTextEvaRSessionEmpDepartment.setValue(employeeManager.getDepartmentDescription());
            this.inputTextEvaResultSessionEmpID.setValue(vce.getNewValue().toString());
            outputTextselectOneMenuEvaResultEvaluatee.setRendered(false);
        } else {
            this.outputTextEvaRSessionEmpName.setValue("");
            this.outputTextEvaRSessionEmpDepartment.setValue("");
            this.inputTextEvaResultSessionEmpID.setValue("");
            outputTextselectOneMenuEvaResultEvaluatee.setRendered(false);
        }
    }

    public void selectOneListbox2ResultComplain_processValueChange(ValueChangeEvent vce) {
        buttonIndicator = 3;
        updateDeleteIndicatorBtn = 2;
        updateDeleteIndicator = 0;
        double sum = 0.0;
        double average = 0.0;

        double sumTotal=0.0;
        double totalValue=0.0;
       
        double percent=0.0;
        rowSelectorEvaResult.setRendered(true);
        columnEvaSessionResult3Complain.setRendered(true);
        columnEvaSessionResult3ComplainApprove.setRendered(true);
        columnEvaSessionResolverRemarkOther.setRendered(true);
        checkbox1hi4Invalid.setRendered(false);
        columnEvaSessionResult3InValid.setRendered(false);
        columnEvaSessionComplainRemarkOther.setRendered(true);
        inputTextareaEvaSessionComplainRemarkOther.setRendered(true);
        inputTextareaEvaSessionResolverRemarkOther.setRendered(true);
        this.evaResultOPtAverage.clear();

        if (vce.getNewValue() == null || vce.getNewValue().toString().trim().equals("0")) {
            disableButtons();
            evaResultOPtOther.clear();

            selectOneMenuToBeEvaluated.resetValue();
            selectOneMenuToBeEvaluated.setValue("0");
            this.buttonEvaResultNew.setDisabled(false);

        } else {
            evaResultOPtOther.clear();

            this.buttonEvaResultNew.setDisabled(false);
            String str[] = vce.getNewValue().toString().split("---");

            int count = evaResultManObject.countEvaSessionResult(str[2], str[1]);
            selectOneMenuToBeEvaluated.resetValue();
            selectOneMenuToBeEvaluated.setValue(str[1]);
            this.loadSessionResultDetail(str[2]);

            try {
                if (count > 0) {
                    disableButtons();
                    disableComponents();
                    disableTableComponents();
                    evaResultOPtOther.clear();
                    this.buttonEvaResultEdit.setDisabled(false);
                    this.buttonEvaResultNew.setDisabled(false);
                    this.buttonEvaResultCancel.setDisabled(false);

                    HashMap[] evaSessionResultList = evaResultManObject.readEvaSessionResultComplainToEvaluaterTbl(str[2], str[1]);

                    for (int i = 0; i < evaSessionResultList.length; i++) {
                        if (evaSessionResultList[i].get("MANAGER_COMP").toString().equals("2")) {
                            updateDeleteIndicator = 2;
                            i = evaSessionResultList.length;
                        }
                    }

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
                                evaSessionResultList[i].get("RESOLVER_REMARK").toString(), 0);
                        this.evaResultOPtOther.add(addToEvaSessionTable);

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
                        
                    average = sum / evaSessionResultList.length;
                    EvaluationResultManager sumAverage = new EvaluationResultManager(sum, average,finalPercent);
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

            }
        }
    }

    public String btnevaResultPopUpResolveCompUpdate_action() {
        int chekUpdate = 0;
        this.buttonIndicator = 8;

        List evaSessionResultUpdate = this.evaResultOPtCompResolvePop;
        Iterator<EvaluationResultManager> ittEvaSessionResultUpdate = evaSessionResultUpdate.iterator();
        while (ittEvaSessionResultUpdate.hasNext()) {
            EvaluationResultManager evaSResultUpdate = ittEvaSessionResultUpdate.next();
            chekUpdate = evaResultManObject.addEvaSessionResultUpdate(evaSResultUpdate.getEvaResultId(), evaSResultUpdate.getSelectedValue(), evaSResultUpdate.getEvaCrtCode(), evaSResultUpdate.getEmpId(), evaSResultUpdate.getEvaSessionCode(), evaSResultUpdate.getRemark(), this.buttonIndicator);
        }
        if (chekUpdate == 1) {
            this.evaResultOPtCompResolvePop.clear();
            evaResultPopUpResolveComp.setRendered(false);
            this.showSuccessOrFailureMessage(true, "The Evaluation Result Updated successfully!!!");
            disableButtons();
            this.buttonEvaResultNew.setDisabled(false);


        } else {
            this.evaResultOPtCompResolvePop.clear();
            evaResultPopUpResolveComp.setRendered(false);
            this.showSuccessOrFailureMessage(false, "Error Occured during Updating the Record .Please Try Again?");
        }
        //return null means stay on the same page
        return null;
    }

    public String btnevaResultPopUpResolveCompCancel_action() {
        this.evaResultOPtCompResolvePop.clear();
        evaResultPopUpResolveComp.setRendered(false);
        //return null means stay on the same page
        return null;
    }

    public void outputText9PopSel1_processValueChange(ValueChangeEvent vce) {
        if (outputText9PopSel1.isSelected()) {
            this.outputText11PopSelR.setValue("1");
            outputText11PopSel2.setSelected(false);
            outputText11PopSel3.setSelected(false);
            outputText11PopSel4.setSelected(false);
            outputText11PopSel5.setSelected(false);
        } else {
            this.outputText11PopSelR.setValue("");
        }
    }

    public void outputText11PopSel2_processValueChange(ValueChangeEvent vce) {
        if (outputText11PopSel2.isSelected()) {
            this.outputText11PopSelR.setValue("2");
            outputText9PopSel1.setSelected(false);
            outputText11PopSel3.setSelected(false);
            outputText11PopSel4.setSelected(false);
            outputText11PopSel5.setSelected(false);
        } else {
            this.outputText11PopSelR.setValue("");
        }
    }

    public void outputText11PopSel3_processValueChange(ValueChangeEvent vce) {
        if (outputText11PopSel3.isSelected()) {
            this.outputText11PopSelR.setValue("3");
            outputText9PopSel1.setSelected(false);
            outputText11PopSel2.setSelected(false);
            outputText11PopSel4.setSelected(false);
            outputText11PopSel5.setSelected(false);
        } else {
            this.outputText11PopSelR.setValue("");
        }
    }

    public void outputText11PopSel4_processValueChange(ValueChangeEvent vce) {
        if (outputText11PopSel4.isSelected()) {
            this.outputText11PopSelR.setValue("4");
            outputText9PopSel1.setSelected(false);
            outputText11PopSel2.setSelected(false);
            outputText11PopSel3.setSelected(false);
            outputText11PopSel5.setSelected(false);
        } else {
            this.outputText11PopSelR.setValue("");
        }
    }

    public void outputText11PopSel5_processValueChange(ValueChangeEvent vce) {
        if (outputText11PopSel5.isSelected()) {
            this.outputText11PopSelR.setValue("5");
            outputText9PopSel1.setSelected(false);
            outputText11PopSel2.setSelected(false);
            outputText11PopSel4.setSelected(false);
            outputText11PopSel3.setSelected(false);
        } else {
            this.outputText11PopSelR.setValue("");
        }
    }

    public void checkbox1hi4Invalid_processValueChange(ValueChangeEvent vce) {
        this.outputText11PopSelR.setValue("6");
        outputText11PopSel3.setSelected(true);
    }

//    public void selectOneMenu1Filter_processValueChange(ValueChangeEvent vce) {
//        if (vce.getNewValue().toString().equals("0")) {
//
//        } else if (vce.getNewValue().toString().equals("1")) {
//            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmpId(), "1");
//        } else if (vce.getNewValue().toString().equals("2")) {
//            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmpId(), "2");
//        } else if (vce.getNewValue().toString().equals("3")) {
//            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmpId(), "3");
//        }
//    }

    public void selectOneMenu1Filter_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue().toString().equals("0")) {
        } else if (vce.getNewValue().toString().equals("1")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "1", this.getSessionBean1().getEmpDeptId());
        } else if (vce.getNewValue().toString().equals("2")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "2", this.getSessionBean1().getEmpDeptId());
        } else if (vce.getNewValue().toString().equals("3")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "3", this.getSessionBean1().getEmpDeptId());
        }else if (vce.getNewValue().toString().equals("4")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "4", this.getSessionBean1().getEmpDeptId());
        }else if (vce.getNewValue().toString().equals("5")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "5", this.getSessionBean1().getEmpDeptId());
        }else if (vce.getNewValue().toString().equals("6")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "6", this.getSessionBean1().getEmpDeptId());
        }else if (vce.getNewValue().toString().equals("7")) {
            this.allEmpToBeEvaluated = evaResultManObject.readAllEmpToBeEvauated(this.getSessionBean1().getEmployeeId(), "7", this.getSessionBean1().getEmpDeptId());
        }
    }

    public void selectOneMenuSessionResultFilter_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null && !vce.getNewValue().toString().equals("0")) {
            sessionResultHistory = evaResultManObject.loadIndividualSessionResults(vce.getNewValue().toString(), this.getSessionBean1().getEmployeeId());
            sessionResultHistoryComplained = evaResultManObject.loadSessionResultsComplained(vce.getNewValue().toString(), this.getSessionBean1().getEmployeeId());

        }
    }

    public String button1_action() {
        //return null means stay on the same page
       

   int chkPoint=evaResultManObject.savePercentValueOfEvaluation(evaluaterID,evaluatedEmpID,lastAveValue,lastPercentValue,lastResult,sessionID,currentDate);
       
             if(chkPoint==1){
      this.showSuccessOrFailureMessage(true, "The Evaluation Percent Result Saved successfully!!!");

             }else{
       this.showSuccessOrFailureMessage(false, "Error Occured during Saving Percent Result.Please Try Again!!!");

             }
        return null;
    }
}

