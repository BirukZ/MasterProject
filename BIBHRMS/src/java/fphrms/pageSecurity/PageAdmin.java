/*
 * PageAdmin.java
 *
 * Created on Jan 14, 2010, 9:36:49 AM
 * Copyright Bravozulu
 */
package fphrms.pageSecurity;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlDataTable;
import com.icesoft.faces.component.ext.HtmlInputSecret;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectManyListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.ext.RowSelector;
import com.icesoft.faces.component.ext.RowSelectorEvent;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.DefaultTableDataModel;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.component.paneltabset.PanelTabSet;
import com.icesoft.faces.component.paneltabset.TabChangeEvent;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.jsfcl.data.DefaultSelectItemsArray;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import javax.faces.FacesException;
import fphrms.SessionBean1;
import fphrms.RequestBean1;
import fphrms.ApplicationBean1;
import java.io.File;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import java.util.List;
import java.util.ResourceBundle;
import java.util.regex.Pattern;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import javax.faces.validator.DoubleRangeValidator;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import manager.employeeManager.EmployeeManage;
import manager.userManagement.SiteSecurityManager;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class PageAdmin extends AbstractPageBean {
    // <editor-fold defaultstate="collapsed" desc="Managed Component Definition">

    private int __placeholder;
    SiteSecurityManager securityManager = new SiteSecurityManager();
    String path = null;

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        //////////////////////////////////////////////////////////////////////
        FacesContext context = FacesContext.getCurrentInstance();
        ServletContext servletContext = (ServletContext) context.getExternalContext().getContext();
        path = servletContext.getRealPath("\\Web");

        int index = path.lastIndexOf("\\");
        availableResourcesFromFile = SiteSecurityManager.getResourceFromFile(
                new File(path.substring(0, index)));


        sortOptionArray(availableResourcesFromFile);
        getSessionBean1().getAvilableRoleResource().clear();
        getSessionBean1().getSelectedRoleResource().clear();

        availableResource = securityManager.getAvailableResources1();

        for (int i = 0; i < availableResource.size(); i++) {
            HashMap mapResourceData = availableResource.get(i);
            getSessionBean1().getAvilableRoleResource().add(new AvilableRoleDataModel(
                    Integer.valueOf(mapResourceData.get("id").toString()),
                    mapResourceData.get("name").toString()));
        }
        //////////////////////////////////////////////////////////////////////
        getSessionBean1().getAvilableUserRole().clear();
        getSessionBean1().getSelectedUserRole().clear();

        availableUserRole = securityManager.getAvailableRoles1();

        for (int i = 0; i < availableUserRole.size(); i++) {
            HashMap mapRoleData = availableUserRole.get(i);
            getSessionBean1().getAvilableUserRole().add(new AvilableUserDataModel(
                    mapRoleData.get("name").toString(),
                    mapRoleData.get("description").toString()));
        }



        ///////////////////////////////////////////////////////////////////////
        getSessionBean1().getAvilablePermission().clear();
        getSessionBean1().getSelectedPermission().clear();

        availablePermission = securityManager.getAvailablePermissions1();

        for (int i = 0; i < availablePermission.size(); i++) {
            HashMap mapPermissionData = availablePermission.get(i);
            getSessionBean1().getAvilablePermission().add(new AvilablePermissionDataModel(
                    mapPermissionData.get("code").toString(),
                    mapPermissionData.get("permission_name").toString()));
        }
        ///////////////////////////////////////////////////////////////////////
        loadUserList();
    }

    private void loadUserList() {
        getUserLIst().clear();
        ArrayList<HashMap> list = securityManager.getAvailableUsersList();
        for (HashMap hm : list) {
            getUserLIst().add(new SystemUser(
                    hm.get("user_name").toString(),
                    hm.get("fullname").toString(),
                    hm.get("emp_id").toString(),
                    hm.get("USER_ID").toString(),
                    false));

        }

    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
    ///////////////////////////////////////////////////////////////////////
    ArrayList<HashMap> availableResource = new ArrayList<HashMap>();
    ArrayList<HashMap> availableUserRole = new ArrayList<HashMap>();
    ArrayList<HashMap> availablePermission = new ArrayList<HashMap>();
    /////////////////////////////////////////////////////////////////
    private DefaultSelectedData selectOneRadio1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1DataBean() {
        return selectOneRadio1DataBean;
    }

    public void setSelectOneRadio1DataBean(DefaultSelectedData dsd) {
        this.selectOneRadio1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems1() {
        return selectOneRadio1DefaultItems1;
    }

    public void setSelectOneRadio1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems1 = dsia;
    }
    private DefaultSelectedData selectOneMenu1DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1DataBean() {
        return selectOneMenu1DataBean;
    }

    public void setSelectOneMenu1DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu1DataBean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems1 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems1() {
        return selectOneMenu1DefaultItems1;
    }

    public void setSelectOneMenu1DefaultItems1(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems1 = dsia;
    }
    private DefaultSelectedData defaultSelectedData9 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData9() {
        return defaultSelectedData9;
    }

    public void setDefaultSelectedData9(DefaultSelectedData dsd) {
        this.defaultSelectedData9 = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems2 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems2 = dsia;
    }
    private DefaultSelectedData selectOneMenu2DataBean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2DataBean() {
        return selectOneMenu2DataBean;
    }

    public void setSelectOneMenu2DataBean(DefaultSelectedData dsd) {
        this.selectOneMenu2DataBean = dsd;
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
    private DefaultSelectItemsArray selectOneMenu2DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems4() {
        return selectOneMenu2DefaultItems4;
    }

    public void setSelectOneMenu2DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems5() {
        return selectOneMenu2DefaultItems5;
    }

    public void setSelectOneMenu2DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems5 = dsia;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems6() {
        return selectOneMenu2DefaultItems6;
    }

    public void setSelectOneMenu2DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems6 = dsia;
    }
    private DefaultSelectedData defaultSelectedData12 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData12() {
        return defaultSelectedData12;
    }

    public void setDefaultSelectedData12(DefaultSelectedData dsd) {
        this.defaultSelectedData12 = dsd;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private DefaultSelectedData defaultSelectedData13 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData13() {
        return defaultSelectedData13;
    }

    public void setDefaultSelectedData13(DefaultSelectedData dsd) {
        this.defaultSelectedData13 = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu2DefaultItems7 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu2DefaultItems7() {
        return selectOneMenu2DefaultItems7;
    }

    public void setSelectOneMenu2DefaultItems7(DefaultSelectItemsArray dsia) {
        this.selectOneMenu2DefaultItems7 = dsia;
    }
    private DefaultSelectItemsArray lstResourcesAvailable1DefaultItems = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getLstResourcesAvailable1DefaultItems() {
        return lstResourcesAvailable1DefaultItems;
    }

    public void setLstResourcesAvailable1DefaultItems(DefaultSelectItemsArray dsia) {
        this.lstResourcesAvailable1DefaultItems = dsia;
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
    private DefaultSelectedData selectOneMenu3Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu3Bean() {
        return selectOneMenu3Bean;
    }

    public void setSelectOneMenu3Bean(DefaultSelectedData dsd) {
        this.selectOneMenu3Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu3DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu3DefaultItems() {
        return selectOneMenu3DefaultItems;
    }

    public void setSelectOneMenu3DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu3DefaultItems = dsi;
    }
    private DefaultSelectedData selectOneMenu5Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu5Bean() {
        return selectOneMenu5Bean;
    }

    public void setSelectOneMenu5Bean(DefaultSelectedData dsd) {
        this.selectOneMenu5Bean = dsd;
    }
    private DefaultSelectionItems selectOneMenu5DefaultItems = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu5DefaultItems() {
        return selectOneMenu5DefaultItems;
    }

    public void setSelectOneMenu5DefaultItems(DefaultSelectionItems dsi) {
        this.selectOneMenu5DefaultItems = dsi;
    }
    private HtmlSelectOneMenu dpdAvailableRoles = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDpdAvailableRoles() {
        return dpdAvailableRoles;
    }

    public void setDpdAvailableRoles(HtmlSelectOneMenu hsom) {
        this.dpdAvailableRoles = hsom;
    }
    private HtmlSelectOneMenu dpdEmployee = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDpdEmployee() {
        return dpdEmployee;
    }

    public void setDpdEmployee(HtmlSelectOneMenu hsom) {
        this.dpdEmployee = hsom;
    }
    private HtmlSelectOneMenu lstResourcesAvailable = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getLstResourcesAvailable() {
        return lstResourcesAvailable;
    }

    public void setLstResourcesAvailable(HtmlSelectOneMenu hsom) {
        this.lstResourcesAvailable = hsom;
    }
    private HtmlSelectManyListbox selectManyListbox5 = new HtmlSelectManyListbox();

    public HtmlSelectManyListbox getSelectManyListbox5() {
        return selectManyListbox5;
    }

    public void setSelectManyListbox5(HtmlSelectManyListbox hsml) {
        this.selectManyListbox5 = hsml;
    }
    private HtmlInputTextarea txtResourceDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtResourceDescription() {
        return txtResourceDescription;
    }

    public void setTxtResourceDescription(HtmlInputTextarea hit) {
        this.txtResourceDescription = hit;
    }
    private HtmlInputText txtResourceName = new HtmlInputText();

    public HtmlInputText getTxtResourceName() {
        return txtResourceName;
    }

    public void setTxtResourceName(HtmlInputText hit) {
        this.txtResourceName = hit;
    }
    private HtmlInputText txtUserName = new HtmlInputText();

    public HtmlInputText getTxtUserName() {
        return txtUserName;
    }

    public void setTxtUserName(HtmlInputText hit) {
        this.txtUserName = hit;
    }
    private HtmlInputSecret txtPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtPassword() {
        return txtPassword;
    }

    public void setTxtPassword(HtmlInputSecret his) {
        this.txtPassword = his;
    }
    private HtmlInputSecret txtConfirmPassword = new HtmlInputSecret();

    public HtmlInputSecret getTxtConfirmPassword() {
        return txtConfirmPassword;
    }

    public void setTxtConfirmPassword(HtmlInputSecret his) {
        this.txtConfirmPassword = his;
    }
    private DefaultTableDataModel dataTable1Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable1Model() {
        return dataTable1Model;
    }

    public void setDataTable1Model(DefaultTableDataModel dtdm) {
        this.dataTable1Model = dtdm;
    }
    private DefaultTableDataModel dataTable2Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable2Model() {
        return dataTable2Model;
    }

    public void setDataTable2Model(DefaultTableDataModel dtdm) {
        this.dataTable2Model = dtdm;
    }
    private RowSelector rowSelector1 = new RowSelector();

    public RowSelector getRowSelector1() {
        return rowSelector1;
    }

    public void setRowSelector1(RowSelector rs) {
        this.rowSelector1 = rs;
    }
    private HtmlCommandButton btnAddAvilablePermission = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAvilablePermission() {
        return btnAddAvilablePermission;
    }

    public void setBtnAddAvilablePermission(HtmlCommandButton hcb) {
        this.btnAddAvilablePermission = hcb;
    }
    private HtmlCommandButton btnRemoveAvilablePermission = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemoveAvilablePermission() {
        return btnRemoveAvilablePermission;
    }

    public void setBtnRemoveAvilablePermission(HtmlCommandButton hcb) {
        this.btnRemoveAvilablePermission = hcb;
    }
    private HtmlDataTable dataTable1 = new HtmlDataTable();

    public HtmlDataTable getDataTable1() {
        return dataTable1;
    }

    public void setDataTable1(HtmlDataTable hdt) {
        this.dataTable1 = hdt;
    }
    private HtmlDataTable dataTable2 = new HtmlDataTable();

    public HtmlDataTable getDataTable2() {
        return dataTable2;
    }

    public void setDataTable2(HtmlDataTable hdt) {
        this.dataTable2 = hdt;
    }
    private HtmlCommandButton btnAddAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddAll() {
        return btnAddAll;
    }

    public void setBtnAddAll(HtmlCommandButton hcb) {
        this.btnAddAll = hcb;
    }
    private HtmlCommandButton btnRemoveAll = new HtmlCommandButton();

    public HtmlCommandButton getBtnRemoveAll() {
        return btnRemoveAll;
    }

    public void setBtnRemoveAll(HtmlCommandButton hcb) {
        this.btnRemoveAll = hcb;
    }
    private HtmlCommandButton btnAddRole = new HtmlCommandButton();

    public HtmlCommandButton getBtnAddRole() {
        return btnAddRole;
    }

    public void setBtnAddRole(HtmlCommandButton hcb) {
        this.btnAddRole = hcb;
    }
    private HtmlInputText txtRoleName = new HtmlInputText();

    public HtmlInputText getTxtRoleName() {
        return txtRoleName;
    }

    public void setTxtRoleName(HtmlInputText hit) {
        this.txtRoleName = hit;
    }
    private HtmlInputTextarea txtRoleDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtRoleDescription() {
        return txtRoleDescription;
    }

    public void setTxtRoleDescription(HtmlInputTextarea hit) {
        this.txtRoleDescription = hit;
    }
    private HtmlSelectOneMenu cmbAvailableRoles1 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCmbAvailableRoles1() {
        return cmbAvailableRoles1;
    }

    public void setCmbAvailableRoles1(HtmlSelectOneMenu hsom) {
        this.cmbAvailableRoles1 = hsom;
    }
    private HtmlInputText txtPermissionName = new HtmlInputText();

    public HtmlInputText getTxtPermissionName() {
        return txtPermissionName;
    }

    public void setTxtPermissionName(HtmlInputText hit) {
        this.txtPermissionName = hit;
    }
    private HtmlInputTextarea txtPermissionDescription = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtPermissionDescription() {
        return txtPermissionDescription;
    }

    public void setTxtPermissionDescription(HtmlInputTextarea hit) {
        this.txtPermissionDescription = hit;
    }
    private HtmlSelectOneMenu cmbAvailableRoles2 = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCmbAvailableRoles2() {
        return cmbAvailableRoles2;
    }

    public void setCmbAvailableRoles2(HtmlSelectOneMenu hsom) {
        this.cmbAvailableRoles2 = hsom;
    }
    private HtmlSelectOneMenu cmbAvailableTask = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getCmbAvailableTask() {
        return cmbAvailableTask;
    }

    public void setCmbAvailableTask(HtmlSelectOneMenu hsom) {
        this.cmbAvailableTask = hsom;
    }
    private DefaultSelectedData defaultSelectedData14 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData14() {
        return defaultSelectedData14;
    }

    public void setDefaultSelectedData14(DefaultSelectedData dsd) {
        this.defaultSelectedData14 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private com.sun.rave.faces.data.DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new com.sun.rave.faces.data.DefaultSelectItemsArray();

    public com.sun.rave.faces.data.DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(com.sun.rave.faces.data.DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private com.sun.rave.faces.data.DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new com.sun.rave.faces.data.DefaultSelectItemsArray();

    public com.sun.rave.faces.data.DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(com.sun.rave.faces.data.DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private HtmlSelectOneMenu dpResourcesAvailable = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDpResourcesAvailable() {
        return dpResourcesAvailable;
    }

    public void setDpResourcesAvailable(HtmlSelectOneMenu hsom) {
        this.dpResourcesAvailable = hsom;
    }

    // </editor-fold>
    private String resourcePath;
    private Option availableResourcesFromFile[];
    private ArrayList<SystemUser> userLIst = new ArrayList<SystemUser>();

    public ArrayList<SystemUser> getUserLIst() {
        return userLIst;
    }

    public void setUserLIst(ArrayList<SystemUser> userLIst) {
        this.userLIst = userLIst;
    }

    /**
     * sorts values of select items in alphabetic order
     */
    protected void sortArrayListOfSelectItem(ArrayList<SelectItem> selectItems) {
        Comparator<SelectItem> arrayListComparator = new Comparator<SelectItem>() {

            public int compare(SelectItem o1, SelectItem o2) {
                SelectItem c1 = (SelectItem) o1;
                SelectItem c2 = (SelectItem) o2;
                return (c1.getLabel().toString().toUpperCase()).compareTo((c2.getLabel().toString().toUpperCase()));
            }
        };
        Collections.sort((List) selectItems, arrayListComparator);
    }

    protected void sortOptionArray(Option[] optionArray) {
        Comparator<Option> optionComparator = new Comparator<Option>() {

            public int compare(Option o1, Option o2) {
                Option c1 = o1;
                Option c2 = o2;
                return (c1.getLabel().toString().toUpperCase()).compareTo((c2.getLabel().toString().toUpperCase()));
            }
        };
        Collections.sort(Arrays.asList(optionArray), optionComparator);
    }

    public Option[] getAvailableResourcesFromFile() {

        return availableResourcesFromFile;
    }
    // <editor-fold defaultstate="collapsed" desc="all getters and setters">

    public void setAvailableResourcesFromFile(Option[] availableResourcesFromFile) {
        this.availableResourcesFromFile = availableResourcesFromFile;
    }
    private PanelTabSet ptsManageResources = new PanelTabSet();

    public PanelTabSet getPtsManageResources() {
        return ptsManageResources;
    }

    public void setPtsManageResources(PanelTabSet pts) {
        this.ptsManageResources = pts;
    }
    private HtmlOutputLabel lblFormMessage = new HtmlOutputLabel();

    public HtmlOutputLabel getLblFormMessage() {
        return lblFormMessage;
    }

    public void setLblFormMessage(HtmlOutputLabel hol) {
        this.lblFormMessage = hol;
    }
    private DoubleRangeValidator doubleRangeValidator1 = new DoubleRangeValidator();

    public DoubleRangeValidator getDoubleRangeValidator1() {
        return doubleRangeValidator1;
    }

    public void setDoubleRangeValidator1(DoubleRangeValidator drv) {
        this.doubleRangeValidator1 = drv;
    }
    private PanelLayout pnlMessage = new PanelLayout();

    public PanelLayout getPnlMessage() {
        return pnlMessage;
    }

    public void setPnlMessage(PanelLayout pl) {
        this.pnlMessage = pl;
    }
    private DefaultTableDataModel dataTable7Model = new DefaultTableDataModel();

    public DefaultTableDataModel getDataTable7Model() {
        return dataTable7Model;
    }

    public void setDataTable7Model(DefaultTableDataModel dtdm) {
        this.dataTable7Model = dtdm;
    }
    private DefaultSelectedData selectBooleanCheckbox1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectBooleanCheckbox1Bean() {
        return selectBooleanCheckbox1Bean;
    }

    public void setSelectBooleanCheckbox1Bean(DefaultSelectedData dsd) {
        this.selectBooleanCheckbox1Bean = dsd;
    }
    private HtmlSelectBooleanCheckbox chkUser = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getChkUser() {
        return chkUser;
    }

    public void setChkUser(HtmlSelectBooleanCheckbox hsbc) {
        this.chkUser = hsbc;
    }
    private PanelPopup pnlUserList = new PanelPopup();

    public PanelPopup getPnlUserList() {
        return pnlUserList;
    }

    public void setPnlUserList(PanelPopup pp) {
        this.pnlUserList = pp;
    }
    // </editor-fold >

    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public PageAdmin() {
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
            e.printStackTrace();
            log("PageAdmin Initialization Failure", e);
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
        lblFormMessage.setVisible(false);
        messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
        txtPermissionName.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtResourceName.setRequiredMessage(messageResource.getString("requiredMsg"));
        dpResourcesAvailable.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtRoleName.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtUserName.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtUserName.setValidatorMessage(messageResource.getString("rangVal"));
        txtPassword.setRequiredMessage(messageResource.getString("requiredMsg"));
        txtConfirmPassword.setRequiredMessage(messageResource.getString("requiredMsg"));
        dpdEmployee.setRequiredMessage(messageResource.getString("requiredMsg"));
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
    protected ApplicationBean1 getApplicationBean1() {
        return (ApplicationBean1) getBean("ApplicationBean1");
    }
    //*****************************************Validation ********************************
    ResourceBundle messageResource = null;
    FacesContext context = null;

    private void validateName(FacesContext context, UIComponent component, Object value) {
        String patternName = "[a-zA-Z]*[//]?[a-zA-Z]*|^[ሀ-�?�\\\\]*[//]?[ሀ-�?�\\\\]*";
        boolean matchStringText = Pattern.matches(patternName, (CharSequence) (value.toString()));
        if (matchStringText == false) {
            messageResource = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            ((UIInput) component).setValid(false);
            error(component, messageResource.getString("nameValidate"));
        }
    }
    String resourceId;
    private ArrayList<SelectItem> availableRoles,  availableUsers,  assignedTask;
    private Option[] availableResources;

    public ArrayList<SelectItem> getAvailableRoles() {
        availableRoles = securityManager.getAvailableRoles();
        // sortSelectItem(availableRoles);
        return availableRoles;
    }

    public void setAvailableRoles(ArrayList<SelectItem> availableRoles) {
        this.availableRoles = availableRoles;
    }

    public Option[] getAvailableResources() {
        availableResources = securityManager.getAvailableResources();
        sortOptionArray(availableResources);
        return availableResources;
    }

    public void setAvailableResources(Option[] availableResources) {

        this.availableResources = availableResources;
    }

    public ArrayList<SelectItem> getAvailableUsers() {
        availableUsers = securityManager.getAvailableUsers();
        //  sortArrayListOfSelectItem(availableUsers);
        return availableUsers;
    }

    public void setAvailableUsers(ArrayList<SelectItem> availableUsers) {
        this.availableUsers = availableUsers;
    }

    public ArrayList<SelectItem> getAssignedTask() {
        return assignedTask;
    }

    public void setAssignedTask(ArrayList<SelectItem> assignedTask) {
        this.assignedTask = assignedTask;
    }

    public String btnAddResource_action() {
        if (SiteSecurityManager.addResource(
                txtResourceName.getValue().toString(),
                txtResourceDescription.getValue().toString(),
                dpResourcesAvailable.getValue().toString()) == 1) {
        } else {
        }
        //return null means stay on the same page
        return null;
    }
    EmployeeManage employeeManage = new EmployeeManage();
    ArrayList<SelectItem> employees = null;

    public ArrayList<SelectItem> getEmployees() {
        employees = employeeManage.employeeName();
        return employees;
    }

    public void setEmployees(ArrayList<SelectItem> employees) {
        this.employees = employees;
    }

    public String btnAddResource1_action() {
        try {
            resourcePath = "/HRMS" + resourcePath.substring(resourcePath.lastIndexOf("web") + 3);

            if (SiteSecurityManager.addResource(
                    txtResourceName.getValue().toString(),
                    txtResourceDescription.getValue().toString(),
                    resourcePath.toString()) == 1) {
                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Resource Saved Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
                txtResourceName.setValue(null);
                txtResourceDescription.setValue(null);
                dpResourcesAvailable.setValue("0");
            } else {
                lblFormMessage.setStyle("color: red;font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Resource Not Saved!");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            return null;
        }
        //return null means stay on the same page
        return null;
    }

    public String button6_action() {
        //return null means stay on the same page
        return null;
    }

    public String button8_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnAddRole_action() {
        if (SiteSecurityManager.addNewRole(txtRoleName.getValue().toString(),
                txtRoleDescription.getValue().toString()) == 1) {
            lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("Role Created Successfully !");

            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            txtRoleDescription.setValue(null);
            txtRoleName.setValue(null);
        } else {
            lblFormMessage.setStyle("color:red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("Role Is Not Created !");

            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAddUser_action()
                        {
        if (getTxtConfirmPassword().getValue().toString().compareTo(
                getTxtPassword().getValue().toString()) == 0) {
            if (SiteSecurityManager.addUser(getTxtUserName().getValue().toString(),
                    getTxtPassword().getValue().toString(),
                    this.dpdEmployee.getValue().toString()) == 1)
            {
                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Account Created Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
                dpdEmployee.setValue("0");
                txtUserName.setValue(null);
                txtPassword.setValue(null);
                txtConfirmPassword.setValue(null);
            } else {
                lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Faild To Create Account !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
            return null;
        } else {
            //getMsgConfirmPassword().
            return null;
        }
    }

    public String btnUpdatePermission_action() {
        String id = "";
        String _permissions[] = new String[getSessionBean1().getSelectedPermission().size()];
        for (int i = 0; i < getSessionBean1().getSelectedPermission().size(); i++) {
            id = String.valueOf(getSessionBean1().getSelectedPermission().get(i).code);
            _permissions[i] = new String(id);

        }
        if (getCmbAvailableRoles2().getValue() != null &&
                getCmbAvailableTask().getValue() != null) {
            if (SiteSecurityManager.grantPermissionToRoleResource(
                    getCmbAvailableRoles2().getValue().toString(),
                    getCmbAvailableTask().getValue().toString(),
                    _permissions) == true) {
                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Permission Granted To RoleResource Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            } else {
                lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Faild Permission Grant To RoleResource !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
        }

        //return null means stay on the same page
        return null;
    }

//    public String btnAddUser_action() {
//          if (getTxtConfirmPassword().getText().toString().compareTo(
//                getTxtPassword().getText().toString()) == 0) {
//            SiteSecurityManager.addUser(getTxtUserName().getValue().toString(),
//                    getTxtPassword().getText().toString(),
//                    this.cmbEmployee.getSelected().toString());
//            return null;
//        } else {
//            //getMsgConfirmPassword().
//            return null;
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="Selected Role DataModel">
    public static class SelectedRoleDataModel implements Serializable, Comparable<SelectedRoleDataModel> {

        int code;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public SelectedRoleDataModel(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int compareTo(SelectedRoleDataModel srrm) {
            int lastCmp = description.toUpperCase().compareTo(srrm.description.toUpperCase());
            return (lastCmp != 0 ? lastCmp : description.toUpperCase().compareTo(srrm.description.toUpperCase()));
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Avilable Role DataModel">
    public static class AvilableRoleDataModel implements Serializable, Comparable<AvilableRoleDataModel> {

        int code;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public int getCode() {
            return code;
        }

        public void setCode(int code) {
            this.code = code;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilableRoleDataModel(int code, String description) {
            this.code = code;
            this.description = description;
        }

        public int compareTo(AvilableRoleDataModel arm) {
            int lastCmp = description.toUpperCase().compareTo(arm.description.toUpperCase());
            return (lastCmp != 0 ? lastCmp : description.toUpperCase().compareTo(arm.description.toUpperCase()));
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Selected User DataModel">

    public static class SelectedUserDataModel implements Serializable, Comparable<SelectedUserDataModel> {

        String name;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public SelectedUserDataModel(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public int compareTo(SelectedUserDataModel sudm) {
            int lastCmp = description.compareTo(sudm.description);
            return (lastCmp != 0 ? lastCmp : description.compareTo(sudm.description));
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Avilable User DataModel">
    public static class AvilableUserDataModel implements Serializable, Comparable<AvilableUserDataModel> {

        String name;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilableUserDataModel(String name, String description) {
            this.name = name;
            this.description = description;
        }

        public int compareTo(AvilableUserDataModel audm) {
            int lastCmp = description.compareTo(audm.description);
            return (lastCmp != 0 ? lastCmp : description.compareTo(audm.description));
        }
    }
    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Selected Permission DataModel">

    public static class SelectedPermissionDataModel implements Serializable, Comparable<SelectedPermissionDataModel> {

        String code;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public SelectedPermissionDataModel(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public int compareTo(SelectedPermissionDataModel spdm) {
            int lastCmp = description.compareTo(spdm.description);
            return (lastCmp != 0 ? lastCmp : description.compareTo(spdm.description));
        }
    }

    // </editor-fold>
    // <editor-fold defaultstate="collapsed" desc="Avilable Permission DataModel">
    public static class AvilablePermissionDataModel implements Serializable, Comparable<AvilablePermissionDataModel> {

        String code;
        String description;
        private boolean selected;

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public AvilablePermissionDataModel(String code, String description) {
            this.code = code;
            this.description = description;
        }

        public int compareTo(AvilablePermissionDataModel apdm) {
            int lastCmp = description.compareTo(apdm.description);
            return (lastCmp != 0 ? lastCmp : description.compareTo(apdm.description));
        }
    }
    // </editor-fold>


    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector1_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();

    }

    /*selection listener is used when a row is selected on the data table component
     *@param e RowSelectorEvent */
    public void rowSelector2_processAction(RowSelectorEvent rse) {
        int selectedRowIndex = rse.getRow();
    }

    public String btnAddAvilablePermission_action() {
        for (int i = 0; i < getSessionBean1().getAvilablePermission().size();
                i++) {
            if (getSessionBean1().getAvilablePermission().get(i).isSelected()) {
                getSessionBean1().getSelectedPermission().add(new SelectedPermissionDataModel(
                        getSessionBean1().getAvilablePermission().
                        get(i).code,
                        getSessionBean1().getAvilablePermission().get(i).description));
                getSessionBean1().getAvilablePermission().remove(i);
                i--;
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRemoveAvilablePermission_action() {
        for (int i = 0; i < getSessionBean1().getSelectedPermission().size();
                i++) {
            if (getSessionBean1().getSelectedPermission().get(i).isSelected()) {
                getSessionBean1().getAvilablePermission().add(new AvilablePermissionDataModel(
                        getSessionBean1().getSelectedPermission().
                        get(i).code,
                        getSessionBean1().getSelectedPermission().get(i).description));
                getSessionBean1().getSelectedPermission().remove(i);
                i--;


            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAddAll_action() {
        for (int i = 0; i < getSessionBean1().getAvilablePermission().size(); i++) {
            getSessionBean1().getSelectedPermission().add(new SelectedPermissionDataModel(
                    getSessionBean1().getAvilablePermission().get(i).getCode(), getSessionBean1().getAvilablePermission().get(i).getDescription()));
            getSessionBean1().getAvilablePermission().remove(i);
            i--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRemoveAll_action() {
        for (int i = 0; i < getSessionBean1().getSelectedPermission().size();
                i++) {
            getSessionBean1().getAvilablePermission().add(new AvilablePermissionDataModel(
                    getSessionBean1().getSelectedPermission().
                    get(i).code,
                    getSessionBean1().getSelectedPermission().get(i).description));
            getSessionBean1().getSelectedPermission().remove(i);
            i--;

        }
        //return null means stay on the same page
        return null;
    }

    /**
     * This method differenciate avilable and selected resource for a given
     * role by accepting role value from dpdbAvailableRoles dropdown
     * @param vce
     */
    public void dpdAvailableRoles_processValueChange(ValueChangeEvent vce) {
        getSessionBean1().getAvilableRoleResource().clear();
        getSessionBean1().getSelectedRoleResource().clear();

        availableResource = securityManager.getAvailableResources1();
        for (int i = 0; i < availableResource.size(); i++) {
            HashMap mapLoanData = availableResource.get(i);
            getSessionBean1().getAvilableRoleResource().add(new AvilableRoleDataModel(
                    Integer.valueOf(mapLoanData.get("id").toString()),
                    mapLoanData.get("name").toString()));
        }

        resourceId = dpdAvailableRoles.getValue().toString();
        ArrayList<HashMap> assignedResources = new ArrayList<HashMap>();
        assignedResources = SiteSecurityManager.getAssignedResources1(resourceId);

        for (int i = 0; i < assignedResources.size(); i++) {
            HashMap mapLoanData = assignedResources.get(i);
            for (int j = 0; j < getSessionBean1().getAvilableRoleResource().
                    size(); j++) {
                if (getSessionBean1().getAvilableRoleResource().get(j).code ==
                        Integer.valueOf(mapLoanData.get("id").toString())) {
                    getSessionBean1().getAvilableRoleResource().remove(j);
                }

            }
            getSessionBean1().getSelectedRoleResource().add(new SelectedRoleDataModel(
                    Integer.valueOf(mapLoanData.get("id").toString()),
                    mapLoanData.get("name").toString()));
        }

    }

    /**
     * This method add permission by calling addPermission() method
     * From SiteSecurityManager
     * @return null so the page request itself
     */
    public String btnAddPermission_action() {
        try {
            if (SiteSecurityManager.addPermission(txtPermissionName.getValue().toString(), txtPermissionDescription.getValue().toString()) == 1) {
                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Permission Saved Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
                txtPermissionName.setValue(null);
                txtPermissionDescription.setValue(null);
            } else {
                lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Faild To Save Permission !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * The following methods add and removes data from MangeRoll Data Model
     * @return
     */
    public String btnAddManageRole_action() {
        for (int i = 0; i < getSessionBean1().getAvilableRoleResource().size();
                i++) {
            if (getSessionBean1().getAvilableRoleResource().get(i).isSelected()) {
                getSessionBean1().getSelectedRoleResource().add(new SelectedRoleDataModel(
                        Integer.valueOf(getSessionBean1().getAvilableRoleResource().
                        get(i).code),
                        getSessionBean1().getAvilableRoleResource().get(i).description));
                getSessionBean1().getAvilableRoleResource().remove(i);
                i--;
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRemoveManageRole_action() {
        for (int i = 0; i < getSessionBean1().getSelectedRoleResource().size();
                i++) {
            if (getSessionBean1().getSelectedRoleResource().get(i).isSelected()) {
                getSessionBean1().getAvilableRoleResource().add(new AvilableRoleDataModel(
                        Integer.valueOf(getSessionBean1().getSelectedRoleResource().
                        get(i).code),
                        getSessionBean1().getSelectedRoleResource().get(i).description));
                getSessionBean1().getSelectedRoleResource().remove(i);
                i--;
            }
        }
        //return null means stay on the same page
        return null;
    }

    public String btnAddAllMangeRole_action() {
        for (int i = 0; i < getSessionBean1().getAvilableRoleResource().size(); i++) {
            getSessionBean1().getSelectedRoleResource().add(new SelectedRoleDataModel(
                    Integer.valueOf(getSessionBean1().getAvilableRoleResource().
                    get(i).code),
                    getSessionBean1().getAvilableRoleResource().get(i).description));
            getSessionBean1().getAvilableRoleResource().remove(i);
            i--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnRemoveAllManageRole_action() {
        for (int i = 0; i < getSessionBean1().getSelectedRoleResource().size();
                i++) {
            getSessionBean1().getAvilableRoleResource().add(new AvilableRoleDataModel(
                    Integer.valueOf(getSessionBean1().getSelectedRoleResource().
                    get(i).code),
                    getSessionBean1().getSelectedRoleResource().get(i).description));
            getSessionBean1().getSelectedRoleResource().remove(i);
            i--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnSave_action() {
        String _ids[] = new String[getSessionBean1().getSelectedRoleResource().size()];
        String id = "";
        for (int i = 0; i < getSessionBean1().getSelectedRoleResource().
                size(); i++) {
            id = String.valueOf(getSessionBean1().getSelectedRoleResource().get(i).code);
            _ids[i] = new String(id);
        }

        if (dpdAvailableRoles.getValue() != null) {
            if (SiteSecurityManager.grantResourceToRole(
                    dpdAvailableRoles.getValue().toString(), _ids) == true) {
                //the ff one line added by mekete
                assignedTask = SiteSecurityManager.getAssignedTask1(cmbAvailableRoles2.getValue().toString());

                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Resource Granted To Role Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            //cmbAvailableTask.
            } else {
                lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Faild Resource Grant To Role !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
        }
        //return null means stay on the same page
        return null;
    }
    /*end of Role part*/

    public String btnAddUserPermission_action() {
        for (int i = 0; i < getSessionBean1().getAvilableUserRole().size(); i++) {
            if (getSessionBean1().getAvilableUserRole().get(i).isSelected()) {
                getSessionBean1().getSelectedUserRole().add(new SelectedUserDataModel(
                        getSessionBean1().getAvilableUserRole().get(i).name,
                        getSessionBean1().getAvilableUserRole().get(i).description));
                getSessionBean1().getAvilableUserRole().remove(i);
                i--;
            }
        }

        //return null means stay on the same page
        return null;
    }

    public String btnRemoveUserPermission_action() {
        for (int i = 0; i < getSessionBean1().getSelectedUserRole().size();
                i++) {
            if (getSessionBean1().getSelectedUserRole().get(i).isSelected()) {
                getSessionBean1().getAvilableUserRole().add(new AvilableUserDataModel(
                        getSessionBean1().getSelectedUserRole().
                        get(i).name,
                        getSessionBean1().getSelectedUserRole().get(i).description));
                getSessionBean1().getSelectedUserRole().remove(i);
                i--;
            }
        }

        //return null means stay on the same page
        return null;
    }

    public String btnAddAllUserPermission_action() {
        for (int i = 0; i < getSessionBean1().getAvilableUserRole().size(); i++) {
            getSessionBean1().getSelectedUserRole().add(new SelectedUserDataModel(
                    getSessionBean1().getAvilableUserRole().
                    get(i).name,
                    getSessionBean1().getAvilableUserRole().get(i).description));
            getSessionBean1().getAvilableUserRole().remove(i);
            i--;
        }

        //return null means stay on the same page
        return null;
    }

    public String btnRemoveAllUserPermission_action() {
        for (int i = 0; i < getSessionBean1().getSelectedUserRole().size();
                i++) {
            getSessionBean1().getAvilableUserRole().add(new AvilableUserDataModel(
                    getSessionBean1().getSelectedUserRole().
                    get(i).name,
                    getSessionBean1().getSelectedUserRole().get(i).description));
            getSessionBean1().getSelectedUserRole().remove(i);
            i--;
        }
        //return null means stay on the same page
        return null;
    }

    public String btnDelete_action() {
        String _userName = getCmbAvailableRoles1().getValue().toString();
        if (SiteSecurityManager.deleteUser(_userName) == true) {
            lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("User Removed From Role Successfully !");
            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
        } else {
            lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("Faild User To Remove From Role !");
            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
        }
        return null;
    }

    public String btnUpdate_action() {
        String _ids[] = new String[getSessionBean1().getSelectedUserRole().size()];
        String id = "";
        for (int i = 0; i < getSessionBean1().getSelectedUserRole().
                size(); i++) {
            id = String.valueOf(getSessionBean1().
                    getSelectedUserRole().get(i).name);
            _ids[i] = new String(id);
        }
        if (getCmbAvailableRoles1().getValue() != null)
        {
            if (SiteSecurityManager.grantRoleToUser(
                    getCmbAvailableRoles1().getValue().toString(),
                    _ids) == true) {
                lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Role Assigned To User Successfully !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            } else {
                lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
                lblFormMessage.setVisible(true);
                lblFormMessage.setValue("Faild Assign Role To User !");
                showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            }
        }

        //return null means stay on the same page
        return null;
    }

    public void cmbAvailableRoles1_processValueChange(ValueChangeEvent vce) {
        getSessionBean1().getAvilableUserRole().clear();
        getSessionBean1().getSelectedUserRole().clear();
        availableUserRole = securityManager.getAvailableRoles1();

        for (int i = 0; i < availableUserRole.size(); i++) {
            HashMap mapLoanData = availableUserRole.get(i);
            getSessionBean1().getAvilableUserRole().add(new AvilableUserDataModel(
                    mapLoanData.get("name").toString(),
                    mapLoanData.get("description").toString()));
        }
        ArrayList<HashMap> assignedRole = new ArrayList<HashMap>();
        assignedRole = SiteSecurityManager.getAssignedRoles1(Integer.valueOf(getCmbAvailableRoles1().getValue().toString()));

        for (int i = 0; i < assignedRole.size(); i++) {
            HashMap mapUserData = assignedRole.get(i);
            for (int j = 0; j < getSessionBean1().getAvilableUserRole().
                    size(); j++) {
                if (getSessionBean1().getAvilableUserRole().get(j).name.equals(
                        mapUserData.get("role_id").toString())) {
                    getSessionBean1().getAvilableUserRole().remove(j);
                }

            }
            getSessionBean1().getSelectedUserRole().add(new SelectedUserDataModel(
                    mapUserData.get("role_id").toString(),
                    mapUserData.get("role_id").toString()));
        }


    }

    public void cmbAvailableTask_processValueChange(ValueChangeEvent vce) {
        getSessionBean1().getAvilablePermission().clear();
        getSessionBean1().getSelectedPermission().clear();


        availablePermission = securityManager.getAvailablePermissions1();

        for (int i = 0; i < availablePermission.size(); i++) {
            HashMap mapPermission = availablePermission.get(i);
            getSessionBean1().getAvilablePermission().add(new AvilablePermissionDataModel(
                    mapPermission.get("code").toString(),
                    mapPermission.get("permission_name").toString()));
        }

        ArrayList<HashMap> assignedPermission = new ArrayList<HashMap>();
        assignedPermission = securityManager.getAssignedPermissions1(
                getCmbAvailableRoles2().getValue().toString(),
                getCmbAvailableTask().getValue().toString());

        for (int i = 0; i < assignedPermission.size(); i++) {
            HashMap mapPermissionData = assignedPermission.get(i);
            for (int j = 0; j < getSessionBean1().getAvilablePermission().
                    size(); j++) {
                if (getSessionBean1().getAvilablePermission().get(j).code.equals(
                        mapPermissionData.get("code").toString())) {
                    getSessionBean1().getAvilablePermission().remove(j);
                }

            }
            getSessionBean1().getSelectedPermission().add(new SelectedPermissionDataModel(
                    mapPermissionData.get("code").toString(),
                    mapPermissionData.get("permission_name").toString()));
        }


    }

    public void cmbAvailableRoles2_processValueChange(ValueChangeEvent vce) {
        selectOneMenu5Bean.setSelectedObject(null);
        assignedTask = SiteSecurityManager.getAssignedTask1(cmbAvailableRoles2.getValue().toString());

    }

    public String button2_action() {
        //return null means stay on the same page
        return null;
    }

    public void dpResourcesAvailable_processValueChange(ValueChangeEvent vce) {
        // currentFile=(FileInfo)vce.getSource();
        String path = vce.getNewValue().toString();
        path = path.replace("\\", "/");
        resourcePath = path;
        //by default, the resource name has to be the same as page name
        //the following code do this
        String path2 = path;
        String label[] = path2.split("/");
        String display = label[label.length - 1].replace(".jsp", "");
        //to show that it is a resource, a resource name has to end with "Page"
        if (!display.endsWith("Page") && !display.endsWith("page")) {
            display += "Page";
        }
        txtResourceName.setValue(display);
        txtResourceDescription.setValue("resource " + display + " represents the page \n " + display.replace("Page", ""));
    }

    public void btnAddResource1_processAction(ActionEvent ae) {
    }

    public void btnAddManageRole_processAction(ActionEvent ae) {
    }

    public void btnRemoveManageRole_processAction(ActionEvent ae) {
    }

    public void txtPermissionName_validate(FacesContext context, UIComponent component, Object value) {
        validateName(context, component, value);
    }

    public void txtResourceName_validate(FacesContext context, UIComponent component, Object value) {
        validateName(context, component, value);
    }

    public void txtUserName_validate(FacesContext context, UIComponent component, Object value) {
        //String pattern = "^[a-zA-Z\\_\\/\\@]+$|^[ሃ-�?�\\_\\/\\@]";
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-�?�0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorUserName");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public void txtPassword_validate(FacesContext context, UIComponent component, Object value) {
        String pattern = "^[a-zA-Z0-9\\_\\/\\@]+$|^[ሃ-�?�0-9\\_\\/\\@]";
        boolean matchFound = Pattern.matches(pattern, (CharSequence) (value.toString()));
        if (matchFound == false) {
            ResourceBundle rb = ResourceBundle.getBundle("Localization.HRLocalization_msg", context.getCurrentInstance().getViewRoot().getLocale());
            String messS = rb.getString("errorPassword");
            error(component, messS);
            ((UIInput) component).setValid(false);
        }
    }

    public void button2_processAction(ActionEvent ae) {
    }

    public void dpdEmployee_processValueChange(ValueChangeEvent vce) {
    }

    public void btnUpdatePermission_processAction(ActionEvent ae) {
    }

    /**
     *
     * @param val-the name of the style sheeet of the panel lay out.
     */
    private void showConformationMsgForPopUps(String val) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show(1000); $j('." + val + "').fadeOut(10000);});";
        JavascriptContext.addJavascriptCall(facesContext, javaScriptText);

    }

    public String lnkHome_action() {
        //return null means stay on the same page
        return "Home";
    }

    public String lnkLogOut_action() {
        //return null means stay on the same page
        FacesContext context = FacesContext.getCurrentInstance();
        HttpServletRequest httpReq = (HttpServletRequest) context.getExternalContext().getRequest();
        getSessionBean1().destroy();
        HttpSession session = (HttpSession) context.getExternalContext().getSession(false);
        session.invalidate();
        return "Home";
    }

    public void ptsManageResources_processTabChange(TabChangeEvent tce) {
    }

    private ArrayList<HashMap> readDelited() {
        ArrayList<HashMap> list = new ArrayList<HashMap>();
        for (SystemUser obj : getUserLIst()) {
            if (obj.isSelected()) {
                HashMap hm = new HashMap();
                hm.put("userId", obj.getUserId());
                list.add(hm);
            }

        }
        return list;
    }

    public static class SystemUser implements Serializable {

        private String userName;
        private String fullName;
        private String employeeId;
        private String userId;
        private boolean selected;

        public String getEmployeeId() {
            return employeeId;
        }

        public void setEmployeeId(String employeeId) {
            this.employeeId = employeeId;
        }

        public String getFullName() {
            return fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public boolean isSelected() {
            return selected;
        }

        public void setSelected(boolean selected) {
            this.selected = selected;
        }

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public SystemUser(String userName, String fullName, String employeeId, String userId, boolean selected) {
            this.userName = userName;
            this.fullName = fullName;
            this.employeeId = employeeId;
            this.userId = userId;
            this.selected = selected;
        }
    }

    public String cmdClose_action() {
        pnlUserList.setRendered(false);
        pnlUserList.setVisible(false);
        //return null means stay on the same page
        return null;
    }

    public String commandLink1_action() {
        pnlUserList.setRendered(true);
        //return null means stay on the same page
        return null;
    }

    public String btnDeleteUser_action() {
        if (securityManager.deleteUser(readDelited())) {
            lblFormMessage.setStyle("color: #336600; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("User information Deleted Successfully !");
            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            pnlUserList.setRendered(false);
            loadUserList();
        } else {
            lblFormMessage.setStyle("color: red; font-size: 11px; font-weight: bold;text-align: center; vertical-align: middle;width: 350px");
            lblFormMessage.setVisible(true);
            lblFormMessage.setValue("User information not Deleted.Please try again ?");
            showConformationMsgForPopUps(pnlMessage.getStyleClass().toString());
            pnlUserList.setRendered(false);
        }
        //return null means stay on the same page
        return null;
    }
}
