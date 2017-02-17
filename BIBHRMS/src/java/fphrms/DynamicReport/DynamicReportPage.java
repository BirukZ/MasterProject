/*
 * DynamicReportPage.java
 *
 * Created on Jul 26, 2012, 3:44:27 PM
 * Copyright tomgenial
 */
package fphrms.DynamicReport;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.context.ViewListener;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import javax.faces.FacesException;
import fphrms.ApplicationBean1;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import java.util.ArrayList;
import javax.faces.model.SelectItem;
import fphrms.PowerDeligation.PowerDelegationRequestFinalReport;
import fphrms.PowerDeligation.PowerDelegationApproveReport;
import java.util.HashMap;
import java.util.List;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import lookUps.DynamicReportLookUp;
import manager.dynamicReport_Manager.DynamicReportManager;
import unitTest.CellKey;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class DynamicReportPage extends AbstractPageBean {

    ArrayList<String> columns = new ArrayList<String>();
    ArrayList<String> empitiedTableList = null;
    ArrayList<String[]> _data;
    private HashMap cellMap = new HashMap();
    private int rows = 0;
    private DataModel rowDataModel;
    private DataModel columnDataModel;

    public DataModel getColumnDataModel() {
        return columnDataModel;
    }

    public void setColumnDataModel(DataModel columnDataModel) {
        this.columnDataModel = columnDataModel;
    }

    public DataModel getRowDataModel() {
        return rowDataModel;
    }

    public void setRowDataModel(DataModel rowDataModel) {
        this.rowDataModel = rowDataModel;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
    DynamicReportLookUp luManager = new DynamicReportLookUp();
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">
    private int __placeholder;
    private ArrayList<SelectItem> viewList = new ArrayList<SelectItem>();
    private DynamicReportManager dynamicReportManager = new DynamicReportManager();

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        setViewList(dynamicReportManager.getViewName());
        drlViewName.setRendered(true);
        btnDisplay.setRendered(true);
    }
    private DefaultSelectedData ddnSelectViewBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return ddnSelectViewBean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.ddnSelectViewBean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private HtmlSelectOneMenu drlViewName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlViewName() {
        return drlViewName;
    }

    public void setDrlViewName(HtmlSelectOneMenu hsom) {
        this.drlViewName = hsom;
    }
    private HtmlCommandButton btnDisplay = new HtmlCommandButton();

    public HtmlCommandButton getBtnDisplay() {
        return btnDisplay;
    }

    public void setBtnDisplay(HtmlCommandButton hcb) {
        this.btnDisplay = hcb;
    }
    private HtmlDataTable tableReport = new HtmlDataTable();

    public HtmlDataTable getTableReport() {
        return tableReport;
    }

    public void setTableReport(HtmlDataTable hdt) {
        this.tableReport = hdt;
    }
    private HtmlInputText txtHeader = new HtmlInputText();

    public HtmlInputText getTxtHeader() {
        return txtHeader;
    }

    public void setTxtHeader(HtmlInputText hit) {
        this.txtHeader = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public DynamicReportPage() {
    }

    public ArrayList<SelectItem> getViewList() {
        return viewList;
    }

    public void setViewList(ArrayList<SelectItem> viewList) {
        this.viewList = viewList;
    }

//    ArrayList<SelectItem> reasonLists = new ArrayList<SelectItem>();
//    ViewList.add(0, new SelectItem("-1", "--SELECT REASON--"));
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
            log("DynamicReportPage Initialization Failure", e);
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
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
    protected PowerDelegationRequestFinalReport getPowerDeligation$PowerDelegationRequestFinalReport() {
        return (PowerDelegationRequestFinalReport) getBean("PowerDeligation$PowerDelegationRequestFinalReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected PowerDelegationApproveReport getPowerDeligation$PowerDelegationApproveReport() {
        return (PowerDelegationApproveReport) getBean("PowerDeligation$PowerDelegationApproveReport");
    }

    public String button7_action() {
        //int cursor = rse.getRow();

        //  getBtnNew().setDisabled(false) //return null means stay on the same page
        return null;
    }

    private void populateTblData(String selectedTbl) {

        columns = luManager.getColumns(selectedTbl, "HRMS");
        HashMap tableInfo = new HashMap();
        tableInfo.put("name", selectedTbl);
        tableInfo.put("noColumn", columns.size());
//        lblPopTitle.setValue(selectedTbl);


        if (luManager.selectData(tableInfo) == null) {

            rows = 0;
        } else {
            _data = luManager.selectData(tableInfo);
            rows = _data.size();

        }
        generateDataModels();
    }

    private void generateDataModels() {
        // Generate rowDataModel
        List rowList = new ArrayList();
        for (int i = 1; i <= rows; i++) {
            rowList.add(String.valueOf(i));
        }
        rowDataModel = new ListDataModel(rowList);
        // Generate columnDataModel
        columnDataModel = new ListDataModel(columns);
    }

    public String getCellValue() {
        tableReport.setRendered(true);
        if (rowDataModel.isRowAvailable() && columnDataModel.isRowAvailable() && _data != null) {
            // get the index of the row and column for this cell
            String row = (String) rowDataModel.getRowData();
            int currentRow = Integer.parseInt(row);
            Object column = columnDataModel.getRowData();
            int currentColumn = ((ArrayList) columnDataModel.getWrappedData()).indexOf(column);
            // return the element at this location
            Object key = new CellKey(row, column);

            if (!cellMap.containsKey(key)) {
                cellMap.put(key, _data.get(currentRow - 1)[currentColumn]);
            }

            return (String) cellMap.get(key);

        }
        return null;
    }

    public String btnDisplay_action() {
        tableReport.setRendered(true);
        String selectedTbl = drlViewName.getValue().toString();
        populateTblData(selectedTbl);
        drlViewName.setRendered(false);
        btnDisplay.setRendered(false);
        txtHeader.setRendered(true);
        //return null means stay on the same page
        return null;
    }
}

