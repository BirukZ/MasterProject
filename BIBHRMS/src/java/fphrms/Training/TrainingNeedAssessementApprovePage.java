/*
 * TrainingNeedAssessementRequest.java
 *
 * Created on Feb 26, 2012, 7:48:31 AM
 * Copyright mekete
 */
package fphrms.Training;

import com.icesoft.faces.component.ext.HtmlCommandButton;
import com.icesoft.faces.component.ext.HtmlCommandLink;
import com.icesoft.faces.component.ext.HtmlInputText;
import com.icesoft.faces.component.ext.HtmlInputTextarea;
import com.icesoft.faces.component.ext.HtmlOutputLabel;
import com.icesoft.faces.component.ext.HtmlOutputText;
import com.icesoft.faces.component.ext.HtmlPanelGroup;
import com.icesoft.faces.component.ext.HtmlSelectBooleanCheckbox;
import com.icesoft.faces.component.ext.HtmlSelectOneListbox;
import com.icesoft.faces.component.ext.HtmlSelectOneMenu;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectedData;
import com.icesoft.faces.component.jsfcl.data.DefaultSelectionItems;
import com.icesoft.faces.component.jsfcl.data.SelectInputDateBean;
import com.icesoft.faces.component.selectinputdate.SelectInputDate;
import com.icesoft.faces.component.selectinputtext.SelectInputText;
import com.sun.rave.faces.data.DefaultSelectItemsArray;
import fphrms.*;
import com.icesoft.faces.component.jsfcl.data.BorderLayoutBean;
import com.icesoft.faces.component.panellayout.PanelLayout;
import com.icesoft.faces.component.panelpopup.PanelPopup;
import com.icesoft.faces.context.effects.JavascriptContext;
import com.sun.rave.web.ui.appbase.AbstractPageBean;
import com.sun.webui.jsf.model.Option;
import java.text.SimpleDateFormat;
import javax.faces.FacesException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;
import manager.authorizationManager.AuthorizationManager.RequestHistoryModel;
import manager.disciplineManager.DisciplineRequestManager.DisciplineRequestModel;
import manager.employeeManager.EmployeeManage;
import manager.trainingManager.TrainingLookupManger;
import manager.trainingManager.TrainingNeedAssessementModel;
import manager.trainingManager.TrainingNeedAssessementRequestManager;
import manager.trainingManager.TrainingNeedAssessementApproveManager;
import fphrms.EmployeeHistory.EvaluationResultPage;
import fphrms.Report.MainReport;
import fphrms.Termination.RetireRequestPage;
import fphrms.Organization.OrganizationTreePage;
import fphrms.Recruitment.ExamQuestions;
import fphrms.Termination.RetireApprovalPage;
import fphrms.Help.Template;
import fphrms.EmployeeHistory.ComplaintPage1;
import manager.departmentManage.DepartmentManage;
import manager.educationManager.InstitutionRegistrationManager;
import manager.globalUseManager.StringDateManipulation;
import manager.trainingManager.TrainingNeedAssessementApproveManager;
import manager.trainingManager.TrainingParticipantModel;

/**
 * <p>Page bean that corresponds to a similarly named JSP page.  This
 * class contains component definitions (and initialization code) for
 * all components that you have defined on this page, as well as
 * lifecycle methods and event handlers where you may add behavior
 * to respond to incoming events.</p>
 */
public class TrainingNeedAssessementApprovePage extends AbstractPageBean {
// <editor-fold defaultstate="collapsed" desc="Alll">
    // <editor-fold defaultstate="collapsed" desc="init prerender...">

    /**
     * <p>Automatically managed component initialization.  <strong>WARNING:</strong>
     * This method is automatically generated, so any user-specified code inserted
     * here is subject to being replaced.</p>
     */
    private void _init() throws Exception {
        userName = getSessionBean1().getUserName();
        loggedInEmployeeId = getSessionBean1().getEmployeeId();
        populateApproverTextComponents(loggedInEmployeeId);
        trainingNeedAssessementRequestManager.setUserName(userName);
        trainingNeedAssessementRequestManager.setLoggedInEmployeeId(loggedInEmployeeId);
        trainingNeedAssessementApproveManager.setUserName(userName);
        trainingNeedAssessementApproveManager.setLoggedInEmployeeId(loggedInEmployeeId);
//        pendingRequestList = trainingNeedAssessementApproveManager.getRequestsToBeProcessed();
//        requestHistoryList = trainingNeedAssessementApproveManager.getMyDecisionsOnRequests();
    }
    private BorderLayoutBean panelBorder1Bean = new BorderLayoutBean();

    public BorderLayoutBean getPanelBorder1Bean() {
        return panelBorder1Bean;
    }

    public void setPanelBorder1Bean(BorderLayoutBean blb) {
        this.panelBorder1Bean = blb;
    }
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
    private DefaultSelectedData defaultSelectedData3 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData3() {
        return defaultSelectedData3;
    }

    public void setDefaultSelectedData3(DefaultSelectedData dsd) {
        this.defaultSelectedData3 = dsd;
    }
    private DefaultSelectedData defaultSelectedData4 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData4() {
        return defaultSelectedData4;
    }

    public void setDefaultSelectedData4(DefaultSelectedData dsd) {
        this.defaultSelectedData4 = dsd;
    }

    public ArrayList<SelectItem> getBudjetYearList() {
        return budjetYearList;
    }

    public void setBudjetYearList(ArrayList<SelectItem> budjetYearList) {
        this.budjetYearList = budjetYearList;
    }

    public ArrayList<SelectItem> getDurationCategoryList() {
        return durationCategoryList;
    }

    public void setDurationCategoryList(ArrayList<SelectItem> durationCategoryList) {
        this.durationCategoryList = durationCategoryList;
    }

    public ArrayList<SelectItem> getInstitutionOrPlaceList() {
        return institutionOrPlaceList;
    }

    public void setInstitutionOrPlaceList(ArrayList<SelectItem> institutionOrPlaceList) {
        this.institutionOrPlaceList = institutionOrPlaceList;
    }

    public ArrayList<SelectItem> getPriorityList() {
        return priorityList;
    }

    public void setPriorityList(ArrayList<SelectItem> priorityList) {
        this.priorityList = priorityList;
    }

    public DefaultSelectedData getSelectedObjectOfBudjetYearList() {
        return selectedObjectOfBudjetYearList;
    }

    public void setSelectedObjectOfBudjetYearList(DefaultSelectedData selectedObjectOfBudjetYearList) {
        this.selectedObjectOfBudjetYearList = selectedObjectOfBudjetYearList;
    }

    public DefaultSelectedData getSelectedObjectOfDurationCategoryList() {
        return selectedObjectOfDurationCategoryList;
    }

    public void setSelectedObjectOfDurationCategoryList(DefaultSelectedData selectedObjectOfDurationCategoryList) {
        this.selectedObjectOfDurationCategoryList = selectedObjectOfDurationCategoryList;
    }

    public DefaultSelectedData getSelectedObjectOfInstitutionOrPlaceList() {
        return selectedObjectOfInstitutionOrPlaceList;
    }

    public void setSelectedObjectOfInstitutionOrPlaceList(DefaultSelectedData selectedObjectOfInstitutionOrPlaceList) {
        this.selectedObjectOfInstitutionOrPlaceList = selectedObjectOfInstitutionOrPlaceList;
    }

    public DefaultSelectedData getSelectedObjectOfPriorityList() {
        return selectedObjectOfPriorityList;
    }

    public void setSelectedObjectOfPriorityList(DefaultSelectedData selectedObjectOfPriorityList) {
        this.selectedObjectOfPriorityList = selectedObjectOfPriorityList;
    }

    public DefaultSelectedData getSelectedObjectOfTrainerTypeList() {
        return selectedObjectOfTrainerTypeList;
    }

    public void setSelectedObjectOfTrainerTypeList(DefaultSelectedData selectedObjectOfTrainerTypeList) {
        this.selectedObjectOfTrainerTypeList = selectedObjectOfTrainerTypeList;
    }

    public ArrayList<SelectItem> getTrainerTypeList() {
        return trainerTypeList;
    }

    public void setTrainerTypeList(ArrayList<SelectItem> trainerTypeList) {
        this.trainerTypeList = trainerTypeList;
    }
    private HtmlSelectOneListbox selectMyRequestLists = new HtmlSelectOneListbox();

    public HtmlSelectOneListbox getSelectMyRequestLists() {
        return selectMyRequestLists;
    }

    public void setSelectMyRequestLists(HtmlSelectOneListbox hsol) {
        this.selectMyRequestLists = hsol;
    }
    private SelectInputText txtRequesterFullName = new SelectInputText();

    public SelectInputText getTxtRequesterFullName() {
        return txtRequesterFullName;
    }

    public void setTxtRequesterFullName(SelectInputText sit) {
        this.txtRequesterFullName = sit;
    }

    public String getSaveOrUpdateLabel() {
        return saveOrUpdateLabel;
    }

    public void setSaveOrUpdateLabel(String saveOrUpdateLabel) {
        this.saveOrUpdateLabel = saveOrUpdateLabel;
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
    private DefaultSelectedData selectOneMenu1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu1Bean() {
        return selectOneMenu1Bean;
    }

    public void setSelectOneMenu1Bean(DefaultSelectedData dsd) {
        this.selectOneMenu1Bean = dsd;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems4() {
        return selectOneMenu1DefaultItems4;
    }

    public void setSelectOneMenu1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems4 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems5 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems5() {
        return selectOneMenu1DefaultItems5;
    }

    public void setSelectOneMenu1DefaultItems5(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems5 = dsia;
    }
    private DefaultSelectedData defaultSelectedData6 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData6() {
        return defaultSelectedData6;
    }

    public void setDefaultSelectedData6(DefaultSelectedData dsd) {
        this.defaultSelectedData6 = dsd;
    }
    private DefaultSelectedData selectOneMenu2Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneMenu2Bean() {
        return selectOneMenu2Bean;
    }

    public void setSelectOneMenu2Bean(DefaultSelectedData dsd) {
        this.selectOneMenu2Bean = dsd;
    }
    private HtmlSelectOneMenu drlPriority = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlPriority() {
        return drlPriority;
    }

    public void setDrlPriority(HtmlSelectOneMenu hsom) {
        this.drlPriority = hsom;
    }
    private HtmlSelectOneMenu drlBudgetYear = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlBudgetYear() {
        return drlBudgetYear;
    }

    public void setDrlBudgetYear(HtmlSelectOneMenu hsom) {
        this.drlBudgetYear = hsom;
    }
    private HtmlSelectOneMenu drlDurationCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDurationCategory() {
        return drlDurationCategory;
    }

    public void setDrlDurationCategory(HtmlSelectOneMenu hsom) {
        this.drlDurationCategory = hsom;
    }
    private HtmlSelectOneMenu drlTrainerType = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainerType() {
        return drlTrainerType;
    }

    public void setDrlTrainerType(HtmlSelectOneMenu hsom) {
        this.drlTrainerType = hsom;
    }
    private HtmlSelectOneMenu drlInstitutionOrPlace = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlInstitutionOrPlace() {
        return drlInstitutionOrPlace;
    }

    public void setDrlInstitutionOrPlace(HtmlSelectOneMenu hsom) {
        this.drlInstitutionOrPlace = hsom;
    }
    private HtmlSelectOneMenu drlTrainingCategory = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingCategory() {
        return drlTrainingCategory;
    }

    public void setDrlTrainingCategory(HtmlSelectOneMenu hsom) {
        this.drlTrainingCategory = hsom;
    }
    private HtmlSelectBooleanCheckbox ckbPlanned = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbPlanned() {
        return ckbPlanned;
    }

    public void setCkbPlanned(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbPlanned = hsbc;
    }
    private HtmlSelectBooleanCheckbox ckbUnplanned = new HtmlSelectBooleanCheckbox();

    public HtmlSelectBooleanCheckbox getCkbUnplanned() {
        return ckbUnplanned;
    }

    public void setCkbUnplanned(HtmlSelectBooleanCheckbox hsbc) {
        this.ckbUnplanned = hsbc;
    }
    private HtmlSelectOneMenu drlNeedSource = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlNeedSource() {
        return drlNeedSource;
    }
    private DefaultSelectedData defaultSelectedDataPlanned = new DefaultSelectedData();
    private DefaultSelectedData defaultSelectedDataUnplanned = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedDataPlanned() {
        return defaultSelectedDataPlanned;
    }

    public void setDefaultSelectedDataPlanned(DefaultSelectedData defaultSelectedDataPlanned) {
        this.defaultSelectedDataPlanned = defaultSelectedDataPlanned;
    }

    public DefaultSelectedData getDefaultSelectedDataUnplanned() {
        return defaultSelectedDataUnplanned;
    }

    public void setDefaultSelectedDataUnplanned(DefaultSelectedData defaultSelectedDataUnplanned) {
        this.defaultSelectedDataUnplanned = defaultSelectedDataUnplanned;
    }

    public void setDrlNeedSource(HtmlSelectOneMenu hsom) {
        this.drlNeedSource = hsom;
    }
    private HtmlSelectOneMenu drlTrainingName = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlTrainingName() {
        return drlTrainingName;
    }

    public void setDrlTrainingName(HtmlSelectOneMenu hsom) {
        this.drlTrainingName = hsom;
    }
    private HtmlInputText txtUnavailableTrainingTitle = new HtmlInputText();

    public HtmlInputText getTxtUnavailableTrainingTitle() {
        return txtUnavailableTrainingTitle;
    }

    public void setTxtUnavailableTrainingTitle(HtmlInputText hit) {
        this.txtUnavailableTrainingTitle = hit;
    }
    private HtmlInputText txtTentativeStartDate = new HtmlInputText();

    public HtmlInputText getTxtTentativeStartDate() {
        return txtTentativeStartDate;
    }

    public void setTxtTentativeStartDate(HtmlInputText hit) {
        this.txtTentativeStartDate = hit;
    }
    private HtmlInputText txtTentativeEndDate = new HtmlInputText();

    public HtmlInputText getTxtTentativeEndDate() {
        return txtTentativeEndDate;
    }

    public void setTxtTentativeEndDate(HtmlInputText hit) {
        this.txtTentativeEndDate = hit;
    }
    private HtmlInputText txtCostPerPerson = new HtmlInputText();

    public HtmlInputText getTxtCostPerPerson() {
        return txtCostPerPerson;
    }

    public void setTxtCostPerPerson(HtmlInputText hit) {
        this.txtCostPerPerson = hit;
    }
    private HtmlInputText txtOtherTotalCost = new HtmlInputText();

    public HtmlInputText getTxtOtherTotalCost() {
        return txtOtherTotalCost;
    }

    public void setTxtOtherTotalCost(HtmlInputText hit) {
        this.txtOtherTotalCost = hit;
    }
    private HtmlInputText txtAppliedDate = new HtmlInputText();

    public HtmlInputText getTxtAppliedDate() {
        return txtAppliedDate;
    }

    public void setTxtAppliedDate(HtmlInputText hit) {
        this.txtAppliedDate = hit;
    }
    private HtmlInputTextarea txtaGeneralComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaGeneralComment() {
        return txtaGeneralComment;
    }

    public void setTxtaGeneralComment(HtmlInputTextarea hit) {
        this.txtaGeneralComment = hit;
    }
    private HtmlCommandButton btnPostDecision = new HtmlCommandButton();

    public HtmlCommandButton getBtnPostDecision() {
        return btnPostDecision;
    }

    public void setBtnPostDecision(HtmlCommandButton hcb) {
        this.btnPostDecision = hcb;
    }
    private SelectInputDateBean selectInputDate1Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate1Bean() {
        return selectInputDate1Bean;
    }

    public void setSelectInputDate1Bean(SelectInputDateBean sidb) {
        this.selectInputDate1Bean = sidb;
    }
    private SelectInputDateBean selectInputDateBean2 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean2() {
        return selectInputDateBean2;
    }

    public void setSelectInputDateBean2(SelectInputDateBean sidb) {
        this.selectInputDateBean2 = sidb;
    }
    private SelectInputDateBean selectInputDateBean3 = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDateBean3() {
        return selectInputDateBean3;
    }

    public void setSelectInputDateBean3(SelectInputDateBean sidb) {
        this.selectInputDateBean3 = sidb;
    }
    private SelectInputDateBean selectInputDate2Bean = new SelectInputDateBean();

    public SelectInputDateBean getSelectInputDate2Bean() {
        return selectInputDate2Bean;
    }

    public void setSelectInputDate2Bean(SelectInputDateBean sidb) {
        this.selectInputDate2Bean = sidb;
    }
    private SelectInputDate calTentativeEndDate = new SelectInputDate();

    public SelectInputDate getCalTentativeEndDate() {
        return calTentativeEndDate;
    }

    public void setCalTentativeEndDate(SelectInputDate sid) {
        this.calTentativeEndDate = sid;
    }
    private SelectInputDate calAppliedDate = new SelectInputDate();

    public SelectInputDate getCalAppliedDate() {
        return calAppliedDate;
    }

    public void setCalAppliedDate(SelectInputDate sid) {
        this.calAppliedDate = sid;
    }
    private SelectInputDate calTentativeStartDate = new SelectInputDate();

    public SelectInputDate getCalTentativeStartDate() {
        return calTentativeStartDate;
    }

    public void setCalTentativeStartDate(SelectInputDate sid) {
        this.calTentativeStartDate = sid;
    }
    private SelectInputText txtParticipantFullName = new SelectInputText();

    public SelectInputText getTxtParticipantFullName() {
        return txtParticipantFullName;
    }

    public void setTxtParticipantFullName(SelectInputText sit) {
        this.txtParticipantFullName = sit;
    }
    private HtmlInputText txtParticipantDepartment = new HtmlInputText();

    public HtmlInputText getTxtParticipantDepartment() {
        return txtParticipantDepartment;
    }

    public void setTxtParticipantDepartment(HtmlInputText hit) {
        this.txtParticipantDepartment = hit;
    }
    private HtmlInputText txtParticipantPosition = new HtmlInputText();

    public HtmlInputText getTxtParticipantPosition() {
        return txtParticipantPosition;
    }

    public void setTxtParticipantPosition(HtmlInputText hit) {
        this.txtParticipantPosition = hit;
    }
    private HtmlInputText txtParticipantId = new HtmlInputText();

    public HtmlInputText getTxtParticipantId() {
        return txtParticipantId;
    }

    public void setTxtParticipantId(HtmlInputText hit) {
        this.txtParticipantId = hit;
    }
    private DefaultSelectedData defaultSelectedData7 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData7() {
        return defaultSelectedData7;
    }

    public void setDefaultSelectedData7(DefaultSelectedData dsd) {
        this.defaultSelectedData7 = dsd;
    }
    private DefaultSelectedData defaultSelectedData8 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData8() {
        return defaultSelectedData8;
    }

    public void setDefaultSelectedData8(DefaultSelectedData dsd) {
        this.defaultSelectedData8 = dsd;
    }
    private DefaultSelectionItems selectOneMenu1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneMenu1DefaultItems2() {
        return selectOneMenu1DefaultItems2;
    }

    public void setSelectOneMenu1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneMenu1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems3() {
        return selectOneMenu1DefaultItems3;
    }

    public void setSelectOneMenu1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneMenu1DefaultItems6 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneMenu1DefaultItems6() {
        return selectOneMenu1DefaultItems6;
    }

    public void setSelectOneMenu1DefaultItems6(DefaultSelectItemsArray dsia) {
        this.selectOneMenu1DefaultItems6 = dsia;
    }
    private DefaultSelectedData selectOneRadio1Bean = new DefaultSelectedData();

    public DefaultSelectedData getSelectOneRadio1Bean() {
        return selectOneRadio1Bean;
    }

    public void setSelectOneRadio1Bean(DefaultSelectedData dsd) {
        this.selectOneRadio1Bean = dsd;
    }
    private DefaultSelectionItems selectOneRadio1DefaultItems2 = new DefaultSelectionItems();

    public DefaultSelectionItems getSelectOneRadio1DefaultItems2() {
        return selectOneRadio1DefaultItems2;
    }

    public void setSelectOneRadio1DefaultItems2(DefaultSelectionItems dsi) {
        this.selectOneRadio1DefaultItems2 = dsi;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems3 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems3() {
        return selectOneRadio1DefaultItems3;
    }

    public void setSelectOneRadio1DefaultItems3(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems3 = dsia;
    }
    private DefaultSelectItemsArray selectOneRadio1DefaultItems4 = new DefaultSelectItemsArray();

    public DefaultSelectItemsArray getSelectOneRadio1DefaultItems4() {
        return selectOneRadio1DefaultItems4;
    }

    public void setSelectOneRadio1DefaultItems4(DefaultSelectItemsArray dsia) {
        this.selectOneRadio1DefaultItems4 = dsia;
    }
    private HtmlInputText txtDeciderDepartment = new HtmlInputText();

    public HtmlInputText getTxtDeciderDepartment() {
        return txtDeciderDepartment;
    }

    public void setTxtDeciderDepartment(HtmlInputText hit) {
        this.txtDeciderDepartment = hit;
    }
    private HtmlInputText txtDeciderId = new HtmlInputText();

    public HtmlInputText getTxtDeciderId() {
        return txtDeciderId;
    }

    public void setTxtDeciderId(HtmlInputText hit) {
        this.txtDeciderId = hit;
    }
    private HtmlSelectOneMenu drlDecision = new HtmlSelectOneMenu();

    public HtmlSelectOneMenu getDrlDecision() {
        return drlDecision;
    }

    public void setDrlDecision(HtmlSelectOneMenu hsom) {
        this.drlDecision = hsom;
    }
    private HtmlInputTextarea txtaDeciderComment = new HtmlInputTextarea();

    public HtmlInputTextarea getTxtaDeciderComment() {
        return txtaDeciderComment;
    }

    public void setTxtaDeciderComment(HtmlInputTextarea hit) {
        this.txtaDeciderComment = hit;
    }
    private HtmlInputText txtDeciderFullName = new HtmlInputText();

    public HtmlInputText getTxtDeciderFullName() {
        return txtDeciderFullName;
    }

    public void setTxtDeciderFullName(HtmlInputText hit) {
        this.txtDeciderFullName = hit;
    }
    private HtmlInputText txtDeciderPosition = new HtmlInputText();

    public HtmlInputText getTxtDeciderPosition() {
        return txtDeciderPosition;
    }

    public void setTxtDeciderPosition(HtmlInputText hit) {
        this.txtDeciderPosition = hit;
    }
    private HtmlCommandLink lnkViewPrevieousDecisions = new HtmlCommandLink();

    public HtmlCommandLink getLnkViewPrevieousDecisions() {
        return lnkViewPrevieousDecisions;
    }

    public void setLnkViewPrevieousDecisions(HtmlCommandLink hcl) {
        this.lnkViewPrevieousDecisions = hcl;
    }
    private HtmlInputText txtNoOfDays = new HtmlInputText();

    public HtmlInputText getTxtNoOfDays() {
        return txtNoOfDays;
    }

    public void setTxtNoOfDays(HtmlInputText hit) {
        this.txtNoOfDays = hit;
    }
    private HtmlInputText txtAward = new HtmlInputText();

    public HtmlInputText getTxtAward() {
        return txtAward;
    }

    public void setTxtAward(HtmlInputText hit) {
        this.txtAward = hit;
    }
    private HtmlInputText txtNameOfTrainer = new HtmlInputText();

    public HtmlInputText getTxtNameOfTrainer() {
        return txtNameOfTrainer;
    }

    public void setTxtNameOfTrainer(HtmlInputText hit) {
        this.txtNameOfTrainer = hit;
    }
    private DefaultSelectedData defaultSelectedData10 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData10() {
        return defaultSelectedData10;
    }

    public void setDefaultSelectedData10(DefaultSelectedData dsd) {
        this.defaultSelectedData10 = dsd;
    }
    private DefaultSelectedData defaultSelectedData11 = new DefaultSelectedData();

    public DefaultSelectedData getDefaultSelectedData11() {
        return defaultSelectedData11;
    }

    public void setDefaultSelectedData11(DefaultSelectedData dsd) {
        this.defaultSelectedData11 = dsd;
    }
    private HtmlInputText txtLoginId = new HtmlInputText();

    public HtmlInputText getTxtLoginId() {
        return txtLoginId;
    }

    public void setTxtLoginId(HtmlInputText hit) {
        this.txtLoginId = hit;
    }
    private HtmlInputText txtFullName = new HtmlInputText();

    public HtmlInputText getTxtFullName() {
        return txtFullName;
    }

    public void setTxtFullName(HtmlInputText hit) {
        this.txtFullName = hit;
    }
    private HtmlInputText txtDepartment = new HtmlInputText();

    public HtmlInputText getTxtDepartment() {
        return txtDepartment;
    }

    public void setTxtDepartment(HtmlInputText hit) {
        this.txtDepartment = hit;
    }
    private HtmlInputText txtPosition = new HtmlInputText();

    public HtmlInputText getTxtPosition() {
        return txtPosition;
    }

    public void setTxtPosition(HtmlInputText hit) {
        this.txtPosition = hit;
    }
    private HtmlInputText txtTrainerProfession = new HtmlInputText();

    public HtmlInputText getTxtTrainerProfession() {
        return txtTrainerProfession;
    }

    public void setTxtTrainerProfession(HtmlInputText hit) {
        this.txtTrainerProfession = hit;
    }

    // </editor-fold>
    /**
     * <p>Construct a new Page bean instance.</p>
     */
    public TrainingNeedAssessementApprovePage() {
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
    public void prerender() {
        if(needSourceList  .isEmpty()){
           needSourceList = trainingLookupManger.getAllTrainingNeedSourceTypes();// new ArrayList<SelectItem>();
        }else{
        }
        if(priorityList   .isEmpty()){
           priorityList = trainingLookupManger.getAllPriorityCategories();// new ArrayList<SelectItem>();
        }else{
        }
        if(durationCategoryList    .isEmpty()){
           durationCategoryList = trainingLookupManger.getAllDurationCategories();// new ArrayList<SelectItem>();
        }else{
        }
        if(pendingRequestList    .isEmpty()){
           pendingRequestList = trainingNeedAssessementApproveManager.getRequestsToBeProcessed();// new ArrayList<SelectItem>();
        }else{
        }
        if(requestHistoryList    .isEmpty()){
           requestHistoryList = trainingNeedAssessementApproveManager.getMyDecisionsOnRequests();// new ArrayList<SelectItem>();
        }else{
        }

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

    public String lnkConfirm_action() {
        return null;
    }

    public ArrayList<DisciplineRequestModel> getAllCommittedOffencesOfEmployee() {
        return allCommittedOffencesOfEmployee;
    }

    public ArrayList<SelectItem> getPendingRequestList() {
        return pendingRequestList;
    }

    public void setPendingRequestList(ArrayList<SelectItem> pendingRequestList) {
        this.pendingRequestList = pendingRequestList;
    }

    public ArrayList<SelectItem> getRequestHistoryList() {
        return requestHistoryList;
    }

    public void setRequestHistoryList(ArrayList<SelectItem> requestHistoryList) {
        this.requestHistoryList = requestHistoryList;
    }

    public void setAllCommittedOffencesOfEmployee(ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee) {
        this.allCommittedOffencesOfEmployee = allCommittedOffencesOfEmployee;
    }

    public DefaultSelectedData getSelectedRequestFromHistoryList() {
        return selectedRequestFromHistoryList;
    }

    public void setSelectedRequestFromHistoryList(DefaultSelectedData selectedRequestFromHistoryList) {
        this.selectedRequestFromHistoryList = selectedRequestFromHistoryList;
    }

    public DefaultSelectedData getSelectedRequestFromMyRequestList() {
        return selectedRequestFromMyRequestList;
    }

    public void setSelectedRequestFromMyRequestList(DefaultSelectedData selectedRequestFromMyRequestList) {
        this.selectedRequestFromMyRequestList = selectedRequestFromMyRequestList;
    }

    public EmployeeManage getEmployeeManager() {
        return employeeManager;
    }

    public ArrayList<SelectItem> getNeedSourceList() {
        return needSourceList;
    }

    public void setNeedSourceList(ArrayList<SelectItem> needSourceList) {
        this.needSourceList = needSourceList;
    }

    public String getAppliedDate() {
        return appliedDate;
    }

    public void setAppliedDate(String appliedDate) {
        this.appliedDate = appliedDate;
    }

    public String getBudjetYear() {
        return budjetYear;
    }

    public void setBudjetYear(String budjetYear) {
        this.budjetYear = budjetYear;
    }
//
//    public double getCostPerPerson() {
//        return costPerPerson;
//    }
//
//    public void setCostPerPerson(double costPerPerson) {
//        this.costPerPerson = costPerPerson;
//    }

    public String getDatabaseStatus() {
        return databaseStatus;
    }

    public void setDatabaseStatus(String databaseStatus) {
        this.databaseStatus = databaseStatus;
    }

    public SimpleDateFormat getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(SimpleDateFormat dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDurationCategory() {
        return durationCategory;
    }

    public void setDurationCategory(String durationCategory) {
        this.durationCategory = durationCategory;
    }

    public String getGeneralComment() {
        return generalComment;
    }

    public void setGeneralComment(String generalComment) {
        this.generalComment = generalComment;
    }

    public String getInstitutionOrPlace() {
        return institutionOrPlace;
    }

    public void setInstitutionOrPlace(String institutionOrPlace) {
        this.institutionOrPlace = institutionOrPlace;
    }

    public String getLoggedInEmployeeId() {
        return loggedInEmployeeId;
    }

    public void setLoggedInEmployeeId(String loggedInEmployeeId) {
        this.loggedInEmployeeId = loggedInEmployeeId;
    }

    public TrainingNeedAssessementModel getNeedAssessementModel() {
        return needAssessementModel;
    }

    public void setNeedAssessementModel(TrainingNeedAssessementModel needAssessementModel) {
        this.needAssessementModel = needAssessementModel;
    }

    public String getNeedSource() {
        return needSource;
    }

    public void setNeedSource(String needSource) {
        this.needSource = needSource;
    }

    public int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public void setNumberOfEmployees(int numberOfEmployees) {
        this.numberOfEmployees = numberOfEmployees;
    }

//    public double getOtherEstimatedCosts() {
//        return otherEstimatedCosts;
//    }
//
//    public void setOtherEstimatedCosts(double otherEstimatedCosts) {
//        this.otherEstimatedCosts = otherEstimatedCosts;
//    }

    public String getPriorityCategory() {
        return priorityCategory;
    }

    public void setPriorityCategory(String priorityCategory) {
        this.priorityCategory = priorityCategory;
    }

    public String getRecordedDateAndTime() {
        return recordedDateAndTime;
    }

    public void setRecordedDateAndTime(String recordedDateAndTime) {
        this.recordedDateAndTime = recordedDateAndTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }

    public ArrayList<TrainingNeedAssessementModel> getRequestedTrainingNeedTypesList() {
        return requestedTrainingNeedTypesList;
    }

    public void setRequestedTrainingNeedTypesList(ArrayList<TrainingNeedAssessementModel> requestedTrainingNeedTypesList) {
        this.requestedTrainingNeedTypesList = requestedTrainingNeedTypesList;
    }

    public DefaultSelectedData getSelectedObjectOfNeedSourcesList() {
        return selectedObjectOfNeedSourcesList;
    }

    public void setSelectedObjectOfNeedSourcesList(DefaultSelectedData selectedObjectOfNeedSourcesList) {
        this.selectedObjectOfNeedSourcesList = selectedObjectOfNeedSourcesList;
    }

    public String getSelectedOrNot() {
        return selectedOrNot;
    }

    public void setSelectedOrNot(String selectedOrNot) {
        this.selectedOrNot = selectedOrNot;
    }

    public String getTentativeEndDate() {
        return tentativeEndDate;
    }

    public void setTentativeEndDate(String tentativeEndDate) {
        this.tentativeEndDate = tentativeEndDate;
    }

    public String getTentativeStartDate() {
        return tentativeStartDate;
    }

    public void setTentativeStartDate(String tentativeStartDate) {
        this.tentativeStartDate = tentativeStartDate;
    }

    public String getTrainerType() {
        return trainerType;
    }

    public void setTrainerType(String trainerType) {
        this.trainerType = trainerType;
    }

    public String getTrainingCategory() {
        return trainingCategory;
    }

    public void setTrainingCategory(String trainingCategory) {
        this.trainingCategory = trainingCategory;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getJobTitleName() {
        return jobTitleName;
    }

    public void setJobTitleName(String jobTitleName) {
        this.jobTitleName = jobTitleName;
    }

    public String getParticipantFullName() {
        return participantFullName;
    }

    public void setParticipantFullName(String participantFullName) {
        this.participantFullName = participantFullName;
    }

    public String getPlanedOrUnplanned() {
        return planedOrUnplanned;
    }

    public void setPlanedOrUnplanned(String planedOrUnplanned) {
        this.planedOrUnplanned = planedOrUnplanned;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public TrainingNeedAssessementModel getTrainingAttributes() {
        return trainingAttributes;
    }

    public void setTrainingAttributes(TrainingNeedAssessementModel trainingAttributes) {
        this.trainingAttributes = trainingAttributes;
    }

    public int getTrainingParticipantId() {
        return trainingParticipantId;
    }

    public void setTrainingParticipantId(int trainingParticipantId) {
        this.trainingParticipantId = trainingParticipantId;
    }

    public TrainingLookupManger getTrainingLookupManger() {
        return trainingLookupManger;
    }

    public void setTrainingLookupManger(TrainingLookupManger trainingLookupManger) {
        this.trainingLookupManger = trainingLookupManger;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public TrainingNeedAssessementRequestManager getTrainingNeedAssessementRequestManager() {
        return trainingNeedAssessementRequestManager;
    }

    public void setTrainingNeedAssessementRequestManager(TrainingNeedAssessementRequestManager trainingNeedAssessementRequestManager) {
        this.trainingNeedAssessementRequestManager = trainingNeedAssessementRequestManager;
    }


    public int getTrainingNeedAttributesId() {
        return trainingNeedAttributesId;
    }

    public void setTrainingNeedAttributesId(int trainingNeedAttributesId) {
        this.trainingNeedAttributesId = trainingNeedAttributesId;
    }

    public int getTrainingNeedRequestId() {
        return trainingNeedRequestId;
    }

    public void setTrainingNeedRequestId(int trainingNeedRequestId) {
        this.trainingNeedRequestId = trainingNeedRequestId;
    }

    public String getTrainingTitle() {
        return trainingTitle;
    }

    public void setTrainingTitle(String trainingTitle) {
        this.trainingTitle = trainingTitle;
    }

    public String getUnavailableTrainingTitle() {
        return unavailableTrainingTitle;
    }

    public void setUnavailableTrainingTitle(String unavailableTrainingTitle) {
        this.unavailableTrainingTitle = unavailableTrainingTitle;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public DefaultSelectedData getSelectedObjectOfTrainingCategoryList() {
        return selectedObjectOfTrainingCategoryList;
    }

    public void setSelectedObjectOfTrainingCategoryList(DefaultSelectedData selectedObjectOfTrainingCategoryList) {
        this.selectedObjectOfTrainingCategoryList = selectedObjectOfTrainingCategoryList;
    }

    public ArrayList<SelectItem> getTrainingCategoryList() {
        return trainingCategoryList;
    }

    public void setTrainingCategoryList(ArrayList<SelectItem> trainingCategoryList) {
        this.trainingCategoryList = trainingCategoryList;
    }

    public void setEmployeeManager(EmployeeManage employeeManager) {
        this.employeeManager = employeeManager;
    }

    public HtmlOutputLabel getLblSuccessOrErrorMessage() {
        return lblSuccessOrErrorMessage;
    }

    public void setLblSuccessOrErrorMessage(HtmlOutputLabel lblSuccessOrErrorMessage) {
        this.lblSuccessOrErrorMessage = lblSuccessOrErrorMessage;
    }

    public HtmlPanelGroup getPanelGroupMessage() {
        return panelGroupMessage;
    }

    public void setPanelGroupMessage(HtmlPanelGroup panelGroupMessage) {
        this.panelGroupMessage = panelGroupMessage;
    }

    public DefaultSelectedData getSelectedObjectOfNeedTariningNameList() {
        return selectedObjectOfNeedTariningNameList;
    }

    public void setSelectedObjectOfNeedTariningNameList(DefaultSelectedData selectedObjectOfNeedTariningNameList) {
        this.selectedObjectOfNeedTariningNameList = selectedObjectOfNeedTariningNameList;
    }

    public ArrayList<SelectItem> getTariningNameList() {
        return tariningNameList;
    }

    public void setTariningNameList(ArrayList<SelectItem> tariningNameList) {
        this.tariningNameList = tariningNameList;
    }

    public PanelLayout getPnlMessageBody() {
        return pnlMessageBody;
    }

    public void setPnlMessageBody(PanelLayout pnlMessageBody) {
        this.pnlMessageBody = pnlMessageBody;
    }

    public PanelPopup getPnlPopupSuccessOrFailure() {
        return pnlPopupSuccessOrFailure;
    }

    public ArrayList<RequestHistoryModel> getDecisionsMadeOnRequest() {
        return decisionsMadeOnRequest;
    }

    public void setDecisionsMadeOnRequest(ArrayList<RequestHistoryModel> decisionsMadeOnRequest) {
        this.decisionsMadeOnRequest = decisionsMadeOnRequest;
    }

    public ArrayList<RequestHistoryModel> getPreviousTrainingRequest() {
        return previousTrainingRequest;
    }

    public void setPreviousTrainingRequest(ArrayList<RequestHistoryModel> previousTrainingRequest) {
        this.previousTrainingRequest = previousTrainingRequest;
    }



    public PanelPopup getPnlPopupViewPrevieousDecisions() {
        return pnlPopupViewPrevieousDecisions;
    }

    public void setPnlPopupViewPrevieousDecisions(PanelPopup pnlPopupViewPrevieousDecisions) {
        this.pnlPopupViewPrevieousDecisions = pnlPopupViewPrevieousDecisions;
    }

    public PanelPopup getPnlPopupViewPrevieousTrainings() {
        return pnlPopupViewPrevieousTrainings;
    }

    public void setPnlPopupViewPrevieousTrainings(PanelPopup pnlPopupViewPrevieousTrainings) {
        this.pnlPopupViewPrevieousTrainings = pnlPopupViewPrevieousTrainings;
    }


    public void setPnlPopupSuccessOrFailure(PanelPopup pnlPopupSuccessOrFailure) {
        this.pnlPopupSuccessOrFailure = pnlPopupSuccessOrFailure;
    }

    public String getRequesterId() {
        return requesterId;
    }

    public DepartmentManage getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(DepartmentManage departmentManager) {
        this.departmentManager = departmentManager;
    }

    public InstitutionRegistrationManager getInstitutionRegistrationManager() {
        return institutionRegistrationManager;
    }

    public void setInstitutionRegistrationManager(InstitutionRegistrationManager institutionRegistrationManager) {
        this.institutionRegistrationManager = institutionRegistrationManager;
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public ArrayList<TrainingParticipantModel> getParticipantLists() {
        return participantLists;
    }

    public TrainingParticipantModel getTrainingParticipantModel() {
        return trainingParticipantModel;
    }

    public void setParticipantLists(ArrayList<TrainingParticipantModel> participantLists) {
        this.participantLists = participantLists;
    }

    public void setTrainingParticipantModel(TrainingParticipantModel trainingParticipantModel) {
        this.trainingParticipantModel = trainingParticipantModel;
    }

    public void setRequesterId(String requesterId) {
        this.requesterId = requesterId;
    }
    private DefaultSelectedData selectedObjectOneMenuDecisionType = new DefaultSelectedData();

    public DefaultSelectedData getSelectedObjectOneMenuDecisionType() {
        return selectedObjectOneMenuDecisionType;
    }

    public void setSelectedObjectOneMenuDecisionType(DefaultSelectedData selectedObjectOneMenuDecisionType) {
        this.selectedObjectOneMenuDecisionType = selectedObjectOneMenuDecisionType;
    }

    public ArrayList<Option> getAvailableDecisionsToMakeList() {
        return availableDecisionsToMakeList;
    }

    public void setAvailableDecisionsToMakeList(ArrayList<Option> availableDecisionsToMakeList) {
        this.availableDecisionsToMakeList = availableDecisionsToMakeList;
    }

    public TrainingNeedAssessementApproveManager getTrainingNeedAssessementApproveManager() {
        return trainingNeedAssessementApproveManager;
    }

    public void setTrainingNeedAssessementApproveManager(TrainingNeedAssessementApproveManager trainingNeedAssessementApproveManager) {
        this.trainingNeedAssessementApproveManager = trainingNeedAssessementApproveManager;
    }

    public HtmlOutputText getOutputTextConfirmDelete() {
        return outputTextConfirmDelete;
    }

    public void setOutputTextConfirmDelete(HtmlOutputText outputTextConfirmDelete) {
        this.outputTextConfirmDelete = outputTextConfirmDelete;
    }

    public String btnCalAppliedDate_action() {
        calAppliedDate.setRendered(true);
        return null;
    }

    public String btnCalStartDate_action() {
        calTentativeStartDate.setRendered(true);
        return null;
    }

    public String btnCalEndDate_action() {
        calTentativeEndDate.setRendered(true);
        return null;
    }

    public void calTentativeStartDate_processValueChange(ValueChangeEvent vce) {
        txtTentativeStartDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTentativeStartDate.setRendered(false);
    }

    public void calAppliedDate_processValueChange(ValueChangeEvent vce) {
        txtAppliedDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calAppliedDate.setRendered(false);
    }

    public void calTentativeEndDate_processValueChange(ValueChangeEvent vce) {
        txtTentativeEndDate.setValue(dateFormat.format((Date) vce.getNewValue()));
        calTentativeEndDate.setRendered(false);
    }

    public PanelPopup getPnlPopupConfirmDelete() {
        return pnlPopupConfirmDelete;
    }

    public void setPnlPopupConfirmDelete(PanelPopup pnlPopupConfirmDelete) {
        this.pnlPopupConfirmDelete = pnlPopupConfirmDelete;
    }
    private PanelPopup pnlPopupConfirmDelete = new PanelPopup();
    HtmlOutputText outputTextConfirmDelete = new HtmlOutputText();
    private PanelPopup pnlPopupViewPrevieousDecisions = new PanelPopup();
    private PanelPopup pnlPopupViewPrevieousTrainings = new PanelPopup();

    public String btnCloseViewPreviesDecisions_action() {
        pnlPopupViewPrevieousDecisions.setRendered(false);
        return null;
    }

    public String btnCloseViewPreviesTrainings_action() {
        pnlPopupViewPrevieousTrainings.setRendered(false);
        return null;
    }

    public String btnDelete_action() {
        pnlPopupConfirmDelete.setRendered(true);
        return null;
    }

    public String lnkViewPrevieousDecisions_action() {
        populateDecisionHistory(trainingNeedRequestId);//requestId
        pnlPopupViewPrevieousDecisions.setRendered(true);
        return null;
    }

    public String btnPopupOkDelete_action() {
//         if (requestManager.deleteSalaryDelegationRequest(salaryDelegationRequestId)) {
        if (true) {
            showSuccessOrFailureMessage(true, "DELETE SUCCESSFULL");
            clearAllComponenets();
            pendingRequestList = null;// requestManager.getPendingRequests();
        } else {
            showSuccessOrFailureMessage(false, "CAN NOT DELETE THE REQUEST\n PLEASE TRY AGAIN");
        }
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }

    public String btnPopupCancelDelete_action() {
        pnlPopupConfirmDelete.setRendered(false);
        return null;
    }
    // <editor-fold defaultstate="collapsed" desc="Managed Component Initialization">

    private void clearAllComponenets() {
        clearRequesterTextComponents();
        clearCommonComponents();
        clearTrainingComponents();
        participantLists.clear();
    }

    private void clearRequesterTextComponents() {
        txtRequesterId.setValue(null);
        txtRequesterDepartment.setValue(null);
        txtRequesterFullName.setValue(null);
        txtRequesterPosition.setValue(null);
    }

    private void clearParticipantTextComponents() {
        txtParticipantId.setValue(null);
        txtParticipantDepartment.setValue(null);
        txtParticipantFullName.setValue(null);
        txtParticipantPosition.setValue(null);
        participantId = null;
    }

    private void clearCommonComponents() {
        txtAppliedDate.setValue(null);
        txtaGeneralComment.setValue(null);
        txtAward.setValue(null);
        txtNameOfTrainer.setValue(null);
        txtNoOfDays.setValue(null);
        selectedObjectOfBudjetYearList.setSelectedObject(null);
    }

    private void clearTrainingComponents() {
//        txtCostPerPerson.setValue(null);
//        txtOtherTotalCost.setValue("0.00");
        txtUnavailableTrainingTitle.setValue(null);
        selectedObjectOfDurationCategoryList.setSelectedObject(null);
        selectedObjectOfInstitutionOrPlaceList.setSelectedObject(null);
        selectedObjectOfNeedSourcesList.setSelectedObject(null);
        selectedObjectOfTrainingCategoryList.setSelectedObject(null);
        selectedObjectOfNeedTariningNameList.setSelectedObject(null);
        selectedObjectOfTrainerTypeList.setSelectedObject(null);
        selectedObjectOfBudjetYearList.setSelectedObject(null);
        selectedObjectOfPriorityList.setSelectedObject(null);
    }

    public String txtRequesterFullName_action() {
        clearRequesterTextComponents();
        requesterId = ApplicationBean1.getSelectedEmployeeId();
        populateRequesterTextComponents(requesterId);
        return null;
    }

    public String txtParticipantFullName_action() {
        clearParticipantTextComponents();
        participantId = ApplicationBean1.getSelectedEmployeeId();
        populateParticipantTextComponents(participantId);
        return null;
    }

    public String btnSearchRequester_action() {
        if (txtRequesterId.getValue() != null && !txtRequesterId.getValue().toString().equals("")) {
            requesterId = txtRequesterId.getValue().toString();
            if (populateRequesterTextComponents(requesterId)) {
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtRequesterId.getValue().toString());
                requesterId = null;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    public String btnSearchParticipant_action() {
        if (txtParticipantId.getValue() != null && !txtParticipantId.getValue().toString().equals("")) {
            participantId = txtParticipantId.getValue().toString();
            if (populateRequesterTextComponents(participantId)) {
            } else {
                showSuccessOrFailureMessage(false, "NO EMPLOYEE IS FOUND WITH ID : " + txtParticipantId.getValue().toString());
                participantId = null;
            }
        } else {
            participantId = null;
            showSuccessOrFailureMessage(false, "EMPLOYEE ID IS NOT FILLED");
        }
        return null;
    }

    private boolean populateRequesterTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {          
                requesterId = employeeId;
                txtRequesterDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtRequesterFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtRequesterId.setValue(employeeId);
                txtRequesterPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

    private boolean populateLoginTextComponents(String loginId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(loginId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + loginId);
                requesterId = null;
                return false;
            } else {
//                requesterId = employeeId;
                txtDepartment.setValue(empInfoHashMap.get("employeeDepartmentPath"));
                txtFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtLoginId.setValue(loginId);
                txtPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }

//    private String getLoginId(String  trainingNeedRequestId){
//
//        return employeeManager.
//    }

    private boolean populateParticipantTextComponents(String employeeId) {

        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(employeeId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + employeeId);
                participantId = null;
                return false;
            } else {
                txtParticipantDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtParticipantFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtParticipantPosition.setValue(empInfoHashMap.get("employeePosition"));
                txtParticipantId.setValue(requesterId);

                participantId = employeeId;
                participantFullName = empInfoHashMap.get("employeeFullName").toString();
                departmentName = empInfoHashMap.get("employeeDepartmentName").toString();
                jobTitleName = empInfoHashMap.get("employeePosition").toString();

                return true;
            }
        } else {
            requesterId = null;
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }
    }
    //====================================================================================================================

    private void makePageReadyForUpdate() {
        saveOrUpdateLabel = "Update";
        btnPostDecision.setDisabled(false);
    }
    //====================================================================================================================

    private void makePageReadyForSave() {
        saveOrUpdateLabel = "Save";
        btnPostDecision.setDisabled(false);
    }
    //====================================================================================================================

    private void makePageReadyForView() {
        saveOrUpdateLabel = "Save";
        btnPostDecision.setDisabled(true);
        txtRequesterId.setDisabled(true);
        txtRequesterFullName.setDisabled(true);
        drlTrainingCategory.setDisabled(true);
        drlTrainingName.setDisabled(true);
        txtaGeneralComment.setDisabled(true);
        drlBudgetYear.setDisabled(true);
        drlTrainerType.setDisabled(true);
        drlInstitutionOrPlace.setDisabled(true);
        txtAppliedDate.setDisabled(true);
        drlNeedSource.setDisabled(true);
        drlPriority.setDisabled(true);
        drlDurationCategory.setDisabled(true);
        ckbPlanned.setDisabled(true);
        ckbUnplanned.setDisabled(true);
        txtUnavailableTrainingTitle.setDisabled(true);
        drlDecision.setDisabled(true);
        txtTentativeStartDate.setDisabled(true);
        txtTentativeEndDate.setDisabled(true);
        txtNoOfDays.setDisabled(true);
        txtAward.setDisabled(true);
        txtNameOfTrainer.setDisabled(true);
        txtTrainerProfession.setDisabled(true);
    }

    private void makePendingReadyForView() {
        saveOrUpdateLabel = "Save";
        drlDecision.setDisabled(false);
        btnPostDecision.setDisabled(false);
        txtRequesterId.setDisabled(true);
        txtRequesterFullName.setDisabled(true);
        drlTrainingCategory.setDisabled(true);
        drlTrainingName.setDisabled(true);
        txtaGeneralComment.setDisabled(true);
        drlBudgetYear.setDisabled(true);
        drlTrainerType.setDisabled(true);
        drlInstitutionOrPlace.setDisabled(true);
        txtAppliedDate.setDisabled(true);
        drlNeedSource.setDisabled(true);
        drlPriority.setDisabled(true);
        drlDurationCategory.setDisabled(true);
        txtTentativeStartDate.setDisabled(false);
        txtTentativeEndDate.setDisabled(false);
        txtNoOfDays.setDisabled(false);
        txtAward.setDisabled(false);
        txtNameOfTrainer.setDisabled(false);
        txtTrainerProfession.setDisabled(false);
        ckbPlanned.setDisabled(true);
        ckbUnplanned.setDisabled(true);
        txtUnavailableTrainingTitle.setDisabled(true);
    }

    //====================================================================================================================
    // <editor-fold defaultstate="collapsed" desc="MessagepOPUP">
    private HtmlOutputLabel lblSuccessOrErrorMessage = new HtmlOutputLabel();
    private PanelLayout pnlMessageBody = new PanelLayout();
    private HtmlPanelGroup panelGroupMessage = new HtmlPanelGroup();
    private PanelPopup pnlPopupSuccessOrFailure = new PanelPopup();

    public void showSuccessOrFailureMessage(boolean success, String messageToDisplay) {
        lblSuccessOrErrorMessage.setStyle(success ? "color: green; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle" : "color: red; font-size: 12px; font-weight: bold;text-align: center; vertical-align: middle");
        lblSuccessOrErrorMessage.setValue(messageToDisplay);
        lblSuccessOrErrorMessage.setVisible(true);
        pnlPopupSuccessOrFailure.setAutoCentre(true);
        pnlPopupSuccessOrFailure.setRendered(true);
        String val = "message";
        String fadeTime = (success ? "3000" : "8000");
        String javaScriptText = "$j(document).ready(function(){ $j('." + val + "').show();" +
                " $j('." + val + "').fadeOut(" + fadeTime + ");" + "});";
        JavascriptContext.addJavascriptCall(FacesContext.getCurrentInstance(), javaScriptText);
    }

    public String btnClosePopupSuccessOrFailure_action() {
        pnlPopupSuccessOrFailure.setRendered(false);
        return null;
    }
    // </editor-fold>
    // </editor-fold >
    // </editor-fold >
    DepartmentManage departmentManager = new DepartmentManage();
//    StringDateManipulation stringDateManipulation = new StringDateManipulation();
    TrainingParticipantModel trainingParticipantModel = new manager.trainingManager.TrainingParticipantModel();
    EmployeeManage employeeManager = new EmployeeManage();
    TrainingNeedAssessementModel trainingAttributes = new TrainingNeedAssessementModel();
    TrainingNeedAssessementModel needAssessementModel = new TrainingNeedAssessementModel();
    InstitutionRegistrationManager institutionRegistrationManager = new InstitutionRegistrationManager();
    ArrayList<TrainingNeedAssessementModel> requestedTrainingNeedTypesList = new ArrayList<TrainingNeedAssessementModel>();
    TrainingNeedAssessementRequestManager trainingNeedAssessementRequestManager = new TrainingNeedAssessementRequestManager();
    TrainingNeedAssessementApproveManager trainingNeedAssessementApproveManager = new TrainingNeedAssessementApproveManager();
    TrainingLookupManger trainingLookupManger = new TrainingLookupManger();
    ArrayList<TrainingParticipantModel> participantLists = new ArrayList<TrainingParticipantModel>();
    //====================================================================================================================
    ArrayList<DisciplineRequestModel> allCommittedOffencesOfEmployee = new ArrayList<DisciplineRequestModel>();
    ArrayList<RequestHistoryModel> decisionsMadeOnRequest = new ArrayList<RequestHistoryModel>();
    ArrayList<RequestHistoryModel> previousTrainingRequest = new ArrayList<RequestHistoryModel>();
    //====================================================================================================================
//    ArrayList<SelectItem> priorityList = trainingLookupManger.getAllPriorityCategories();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> priorityList = new ArrayList<SelectItem>();
//    ArrayList<SelectItem> durationCategoryList = trainingLookupManger.getAllDurationCategories();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> durationCategoryList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> budjetYearList = trainingLookupManger.getAllBudgetYears();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> trainerTypeList = trainingLookupManger.getAllTrainerCategories();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> trainingCategoryList = trainingLookupManger.getAllTrainingCategories();// new ArrayList<SelectItem>();
//    ArrayList<SelectItem> needSourceList = trainingLookupManger.getAllTrainingNeedSourceTypes();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> needSourceList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> tariningNameList = trainingLookupManger.getAllTrainingNames();//new ArrayList<SelectItem>();
    ArrayList<SelectItem> institutionOrPlaceList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> pendingRequestList = new ArrayList<SelectItem>();
    ArrayList<SelectItem> requestHistoryList = new ArrayList<SelectItem>();
    //====================================================================================================================
    DefaultSelectedData selectedObjectOfPriorityList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfDurationCategoryList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfBudjetYearList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfTrainerTypeList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfInstitutionOrPlaceList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfTrainingCategoryList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfNeedSourcesList = new DefaultSelectedData();
    DefaultSelectedData selectedObjectOfNeedTariningNameList = new DefaultSelectedData();
    //====================================================================================================================
    String saveOrUpdateLabel = "Save";
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private DefaultSelectedData selectedRequestFromMyRequestList = new DefaultSelectedData();
    private DefaultSelectedData selectedRequestFromHistoryList = new DefaultSelectedData();
    //====================================================================================================================
    String userName;
    String loggedInEmployeeId;
    //====================================================================================================================
    int trainingParticipantId;
    String employeeId;
    String participantFullName;
    String departmentName;
    String jobTitleName;
    String databaseStatus;
    String status;
    //====================================================================================================================
    int trainingNeedRequestId;
    String requesterId;
    String participantId;
    String appliedDate;
    String recordedDateAndTime;
    String generalComment;
    String requestStatus;
    String remark;
    String budjetYear;
    String planedOrUnplanned;
    //============================
    int trainingNeedAttributesId;
    String trainingCategory;
    String trainingTitle;
    String unavailableTrainingTitle;
    String description;
    String trainingName;
    String trainerType;
    String institutionOrPlace;
    String durationCategory;
    String tentativeStartDate;
    String tentativeEndDate;
    String needSource;
    String priorityCategory;
    int numberOfEmployees;
//    double costPerPerson;
//    double otherEstimatedCosts;
    String selectedOrNot;
    //====================================================================================================================
    ArrayList<Option> availableDecisionsToMakeList = new ArrayList<Option>();

    public void selectMyRequestLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String attributes[] = vce.getNewValue().toString().split("--");
            trainingNeedRequestId = Integer.parseInt(attributes[0]);
            requesterId = attributes[1];
            requestStatus = attributes[2];
            String loginId = trainingNeedAssessementApproveManager.getLoginId(trainingNeedRequestId);
            populateRequesterTextComponents(requesterId);
            populateLoginTextComponents(loginId);
            populateParticipantList(trainingNeedRequestId);
            populateRequestAttributes(trainingNeedRequestId);
            populateAvailableDecisionsToMake(requestStatus);
            makePageReadyForSave();
            makePendingReadyForView();

        }
    }
    //==========================================================================================================================

    public void selectMyHistoryLists_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            String attributes[] = vce.getNewValue().toString().split("--");
            trainingNeedRequestId = Integer.parseInt(attributes[0]);
            requesterId = attributes[1];
            requestStatus = attributes[2];
            String loginId = trainingNeedAssessementApproveManager.getLoginId(trainingNeedRequestId);
            populateRequesterTextComponents(requesterId);
            populateLoginTextComponents(loginId);
            populateParticipantList(trainingNeedRequestId);
            populateRequestAttributes(trainingNeedRequestId);
            makePageReadyForView();
        }

    }


    //====================================================================================================================
    public void populateParticipantList(int trainingNeedRequestId) {
        participantLists = trainingNeedAssessementRequestManager.getParticipantEmployeesList(trainingNeedRequestId);       
    }

    public void populateAvailableDecisionsToMake(String requestStatus) {
        availableDecisionsToMakeList = trainingNeedAssessementApproveManager.getAvailableDecisionsToMake(requestStatus);
    }

    private boolean populateApproverTextComponents(String approverId) {
        HashMap empInfoHashMap = employeeManager.readEmployeeBasicInfo(approverId);
        if (empInfoHashMap != null) {
            if (empInfoHashMap.get("employeeId").toString().equals("")) {//if no resultset found
                approverId = null;
                showSuccessOrFailureMessage(false, "NO EMPLOYEE FOUND WITH ID : " + approverId);
                txtDeciderId.setDisabled(false);
                return false;
            } else {
                approverId = empInfoHashMap.get("employeeId").toString();
                txtDeciderDepartment.setValue(empInfoHashMap.get("employeeDepartmentName"));
                txtDeciderFullName.setValue(empInfoHashMap.get("employeeFullName"));
                txtDeciderId.setValue(empInfoHashMap.get("employeeId"));
                txtDeciderPosition.setValue(empInfoHashMap.get("employeePosition"));
                return true;
            }

        } else {
            showSuccessOrFailureMessage(false, "EXCEPTION OCCURED");
            return false;
        }

    }
//====================================================================================================================

    public void populateRequestAttributes(int trainingNeedRequestId) {
        try {
            TrainingNeedAssessementModel trainingNeedAssessement = trainingNeedAssessementRequestManager.getRequestAttributes(trainingNeedRequestId);
            drlDurationCategory.setValue(trainingNeedAssessement.getDurationCategory());
            tariningNameList = trainingLookupManger.getAllTrainingNames(trainingNeedAssessement.getTrainingCategory());//new ArrayList<SelectItem>();}
            txtaGeneralComment.setValue(trainingNeedAssessement.getGeneralComment());
            txtAppliedDate.setValue(trainingNeedAssessement.getAppliedDate());
            drlBudgetYear.setValue(trainingNeedAssessement.getBudjetYear());//   int trainingNeedAttributesId;
            drlTrainingCategory.setValue(trainingNeedAssessement.getTrainingCategory());
            drlTrainingName.setValue(trainingNeedAssessement.getTrainingId() + "--" + trainingNeedAssessement.getTrainingName());
            drlPriority.setValue(trainingNeedAssessement.getPriorityCategory());
            txtUnavailableTrainingTitle.setValue(trainingNeedAssessement.getTrainingName());
            txtTentativeStartDate.setValue(trainingNeedAssessement.getTentativeStartDate());
            txtTentativeEndDate.setValue(trainingNeedAssessement.getTentativeEndDate());
            drlTrainerType.setValue(trainingNeedAssessement.getTrainerType());
            txtNoOfDays.setValue(trainingNeedAssessement.getNoOfDays());
            txtAward.setValue(trainingNeedAssessement.getAward());
            txtNameOfTrainer.setValue(trainingNeedAssessement.getTrainerName());
            txtTrainerProfession.setValue(trainingNeedAssessement.getTrainerProfession());
//            txtCostPerPerson.setValue(trainingNeedAssessement.getCostPerPerson());
//            txtOtherTotalCost.setValue(trainingNeedAssessement.getOtherEstimatedCosts());
            // =================================================================
            String trainingReasonId = trainingNeedAssessement.getNeedSource();
            String trainingReasonName = trainingNeedAssessementRequestManager.gettrainingReasonName(trainingReasonId);
            drlNeedSource.setValue(trainingReasonId + "-" + trainingReasonName);
//            drlNeedSource.setValue(trainingNeedAssessement.getNeedSource());
            if (trainingNeedAssessement.getTrainerType().equals("ME")) {//mugher employee
                institutionOrPlaceList = departmentManager.getAddressCode();
                drlInstitutionOrPlace.setValue(trainingNeedAssessement.getInstitutionOrPlace());
            } else {// institution, external
                institutionOrPlaceList = institutionRegistrationManager.getActiveTrainingInstitutions();
                drlInstitutionOrPlace.setValue(trainingNeedAssessement.getInstitutionOrPlace());
            }
            // =================================================================
            if (trainingNeedAssessement.getPlanedOrUnplanned().equals("PL")) {
                ckbPlanned.setSelected(true);
                ckbUnplanned.setSelected(false);
            } else {
                ckbPlanned.setSelected(false);
                ckbUnplanned.setSelected(true);
            }
        } catch (NullPointerException npe) {
            npe.printStackTrace();
        }
    }

//====================================================================================================================
    private void populateDecisionHistory(int overTimeRequestId) {
        decisionsMadeOnRequest = trainingNeedAssessementApproveManager.getRequestHistory(overTimeRequestId);
    }

//    private void populatePreviousTrainings(String employeeId) {
//        TrainingNeedAssessementApproveManager needAssessementApproveManager = new TrainingNeedAssessementApproveManager();
//        previousTrainingRequest = needAssessementApproveManager.getPreviousTrainings(employeeId);
////        if (decisionsMadeOnRequest.size() > 0) {
////            lnkViewPrevieousDecisions.setRendered(true);
////        } else {
////            lnkViewPrevieousDecisions.setRendered(false);
////            makePageReadyForUpdate();
////        }
//    }

    private void populatePreviousTrainings(ArrayList<TrainingParticipantModel> participantList) {
        TrainingNeedAssessementApproveManager needAssessementApproveManager = new TrainingNeedAssessementApproveManager();
        previousTrainingRequest = needAssessementApproveManager.getPreviousTrainingsOnApprove(participantList);
//        if (decisionsMadeOnRequest.size() > 0) {
//            lnkViewPrevieousDecisions.setRendered(true);
//        } else {
//            lnkViewPrevieousDecisions.setRendered(false);
//            makePageReadyForUpdate();
//        }
    }
    //====================================================================================================================

    public void drlTrainingName_processValueChange(ValueChangeEvent vce) {
        if (vce.getNewValue() != null) {
            if (!vce.getNewValue().toString().equals("-1")) {
                txtUnavailableTrainingTitle.setDisabled(true);
                txtUnavailableTrainingTitle.setValue(vce.getNewValue().toString().split("--")[1]);
            } else {
                txtUnavailableTrainingTitle.setDisabled(false);
                txtUnavailableTrainingTitle.setValue("");
            }
        }
    }

    public String txtRequesterPosition_action() {
        //return null means stay on the same page
        return null;
    }

    public String btnReset_action() {
        clearAllComponenets();
        return null;
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected EvaluationResultPage getEmployeeHistory$EvaluationResultPage() {
        return (EvaluationResultPage) getBean("EmployeeHistory$EvaluationResultPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template_1 getTemplate_1() {
        return (Template_1) getBean("Template_1");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected MainReport getReport$MainReport() {
        return (MainReport) getBean("Report$MainReport");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireRequestPage getTermination$RetireRequestPage() {
        return (RetireRequestPage) getBean("Termination$RetireRequestPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected OrganizationTreePage getOrganization$OrganizationTreePage() {
        return (OrganizationTreePage) getBean("Organization$OrganizationTreePage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ExamQuestions getRecruitment$ExamQuestions() {
        return (ExamQuestions) getBean("Recruitment$ExamQuestions");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected RetireApprovalPage getTermination$RetireApprovalPage() {
        return (RetireApprovalPage) getBean("Termination$RetireApprovalPage");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected Template getHelp$Template() {
        return (Template) getBean("Help$Template");
    }

    /**
     * <p>Return a reference to the scoped data bean.</p>
     *
     * @return reference to the scoped data bean
     */
    protected ComplaintPage1 getEmployeeHistory$ComplaintPage1() {
        return (ComplaintPage1) getBean("EmployeeHistory$ComplaintPage1");
    }

    public void drlTrainerType_processValueChange(ValueChangeEvent vce) {
        if (vce != null) {
            if (vce.getNewValue().toString().equals("ME")) {//mugher employee
                institutionOrPlaceList = departmentManager.getAddressCode();
            } else if (vce.getNewValue().toString().equals("IN")) {// institution, external
                institutionOrPlaceList = institutionRegistrationManager.getActiveTrainingInstitutions();
            } else if (vce.getNewValue().toString().equals("UK")) {//unknown
                institutionOrPlaceList = trainingNeedAssessementRequestManager.getDefaultInstitutionOrPlace();
            }
        }
    }

    private boolean validateDecision() {
        if (drlDecision.getValue().toString().equals(TrainingNeedAssessementApproveManager.DECISION_NONE)) {
            showSuccessOrFailureMessage(false, "SELECT DECISION FIRST");
            return false;
        } else if (drlDecision.getValue().toString().equals(TrainingNeedAssessementApproveManager.DECISION_REJECT) && (txtaDeciderComment.getValue() == null || txtaDeciderComment.getValue().toString().equals(""))) {
            showSuccessOrFailureMessage(false, "TO REJECT, YOU NEED TO SUPPLY COMMENT");
            return false;
        } else if (trainingNeedRequestId == -1) {
            showSuccessOrFailureMessage(false, "FIRST SELECT THE TERMINATION TO DECIDE");
            return false;
        }
        return true;
    }

    public boolean saveDecision() {
        String comment = txtaDeciderComment.getValue() == null ? "" : txtaDeciderComment.getValue().toString();
      
        return trainingNeedAssessementApproveManager.saveDecision(trainingNeedRequestId, txtDeciderId.getValue().toString(), drlDecision.getValue().toString(), requestStatus, comment, participantLists, txtTentativeStartDate.getValue().toString(), txtTentativeEndDate.getValue().toString(),
               // txtNoOfDays.getValue().toString(), txtAward.getValue().toString(), txtNameOfTrainer.getValue().toString(), txtTrainerProfession.getValue().toString());
          txtNoOfDays.getValue().toString(), null,null, null);

    }

    public String btnPostDecision_action() {
        if (validateDecision())
        {
            if (saveDecision()) {
                clearAllComponenets();
                participantLists.clear();
                showSuccessOrFailureMessage(true, "SAVING SUCCESSFUL");
                pendingRequestList = trainingNeedAssessementRequestManager.getPendingRequests();
                requestHistoryList = trainingNeedAssessementRequestManager.getMyRequestsHistory();
            } else {
                showSuccessOrFailureMessage(false, "SAVING FAILED");
            }
        }
        return null;
    }

    public String btnCalcNoOfDays_action() {
//        try {


//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
//        Date selectedAppliedDate = (Date) sdf.parse(txtTentativeStartDate.getValue().toString());
        //return null means stay on the same page
//        txtTentativeStartDate.setValue(dateFormat.format(txtTentativeStartDate));
//        txtTentativeEndDate.setValue(dateFormat.format(txtTentativeEndDate));
//        Date selectedTerminationDate = (Date) sdf.parse(txtTentativeEndDate.getValue().toString());
//        long dateDifference = (selectedTerminationDate.getTime() - selectedAppliedDate.getTime()) / (1000 * 60 * 60 * 24);
        int noOfDays =StringDateManipulation.compareDateDifference(txtTentativeStartDate.getValue().toString(),txtTentativeEndDate.getValue().toString());
        txtNoOfDays.setValue(noOfDays);
//        txtNoOfDays.setValue(dateDifference);
//        } catch (Exception e) {
//        }
        return null;
    }


    public String lnkPreviousTraining_action() {
        populatePreviousTrainings(participantLists);
        pnlPopupViewPrevieousTrainings.setRendered(true);
        //return null means stay on the same page
        return null;
    }

//    public String lnkPreviousTraining_action() {
////        populatePreviousTrainings(txtEmployeeId.getValue().toString());
//        pnlPopupViewPrevieousTrainings.setRendered(true);
//        //return null means stay on the same page
//        return null;
//    }

//    public String btnFindTraining_action() {
////        if (!(txtEmployeeId.getValue().toString().isEmpty())) {
//         populatePreviousTrainings(txtEmployeeId.getValue().toString());
////        } else {}
//        //return null means stay on the same page
//        return null;
//    }

//    public String button1_action() {
//        populatePreviousTrainings(txtEmployeeId.getValue().toString());
//        //return null means stay on the same page
//        return null;
//    }

//    public String btnFindTraining_action() {
//        populatePreviousTrainings(txtEmployeeId.getValue().toString());
//        //return null means stay on the same page
//        return null;
//    }

    
}