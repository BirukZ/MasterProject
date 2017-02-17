<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
           <f:loadBundle basename="Localization.HR_Localization_Training" var="msgTraining"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .message2 {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 13px 13px 13px 52px;
                        background-position: 13px 5px;
                        border: solid 1px #BD8;                                                                                                                                                border: solid 1px #BD8;
                    }
                    .success{
                        color: #336600;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .error{
                        color: red;
                        font-size: 12px;
                        font-weight: bold;
                        text-align: center;
                        vertical-align: middle;
                        top:5px;left: 0px;
                        position: absolute;
                        width: 100%
                    }
                    .success1{
                        color: #336600;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                    .error1{
                        color: red;
                        font-size: 11px;
                        font-weight: bold;
                        height: 16px;
                        left: 5px;
                        top: 2px;
                        position: absolute;
                        text-align: left;
                        width: 391px
                    }
                </style>
                <script language="javascript" type="text/javascript">
                    var $j=jQuery.noConflict();
                    function TrainingNameRegistrationPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$ActionPlanCost.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$ActionPlanCost.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$ActionPlanCost.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$ActionPlanCost.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$ActionPlanCost.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
                                                        <ice:outputText id="outputText19" value=""/>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li></li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup dragListener="#{Training$ActionPlanCost.status_Group_processMyEvent}" id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Training$ActionPlanCost.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Training$ActionPlanCost.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Training$ActionPlanCost.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Training$ActionPlanCost.pendingRequestList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%"/>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Action Plan Cost"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 24px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Training$ActionPlanCost.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 718px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 710px; left: 21px; top: 30px; position: absolute; width: 737px">
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 619px; margin-left: 15px; left: 9px; top: 0px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:panelLayout id="pnlLayputTableParticipants"
                                                                style="height: 157px; margin-left: 15px; left: 9px; top: 120px; overflow: auto; position: absolute; width: 644px" styleClass="insideContainerMain">
                                                                <ice:dataTable id="dataTableParticipantLists"
                                                                    style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                    value="#{Training$ActionPlanCost.trainingParticipantsList}" var="currentRow" width="665">
                                                                    <ice:column id="colNumber">
                                                                        <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['fullName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextFullName"  value="#{msgTraining.FullName}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colFullName">
                                                                        <ice:outputText id="optTxtForColumnDeparmentName" value="#{currentRow['departmentName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDeparmentName"  value="#{msgTraining.FullName}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRepitition">
                                                                        <ice:outputText id="optTxtForColumnJobTitleName" value="#{currentRow['jobTitleName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextJobTitleName"  value="#{msgTraining.JobTitle}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="pnlLayputCostTypes"
                                                                style="height: 153px; margin-left: 15px; left: 9px; top: 456px; overflow: auto; position: absolute; width: 645px" styleClass="insideContainerMain">
                                                                <ice:outputLabel id="lblTutationFee" rendered="false"
                                                                style="height: 19px; left: 234px; top: 0px; position: absolute"  value="#{msgTraining.Total}"/>
                                                                <ice:dataTable id="dataAdminstrativeCost"
                                                                    style="height: 8px; left: 16px; top: 16px; position: absolute; width: 600px"
                                                                    value="#{Training$ActionPlanCost.trainingCostList}" var="currentRow">
                                                                    <ice:column id="colAdmoinsCostType" style="width: 50px">
                                                                        <ice:selectOneMenu id="drlCostCategoriesTable" partialSubmit="true" style="width: 50px" value="#{currentRow['costTypeCategory']}">
                                                                            <f:selectItems id="selectOneMenu1selectItemsTable" value="#{Training$ActionPlanCost.costCategoryList}"/>
                                                                        </ice:selectOneMenu>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostType"  value="#{msgTraining.CostType}"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$ActionPlanCost.rowSelector_processMyEvent}"/>
                                                                    </ice:column>
                                                                    <ice:column id="colCostName" style="width: 100px">
                                                                        <ice:inputText id="txtCostNameTable" style="width: 150px" value="#{currentRow['costTypeName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostNametable"  value="#{msgTraining.CostName}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colUnitCost" style="width: 50px">
                                                                        <ice:inputText id="optTxtForColumnUnitCost" style="width: 50px" value="#{currentRow['unitCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextUnitCost"  value="#{msgTraining.UnitCost}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colQuantity">
                                                                        <ice:inputText id="optTxtForColumnQuantity" style="width: 50px" value="#{currentRow['quantityOrAmount']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit" value="#{msgTraining.Quantity}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="coTotal" style="width: 50px">
                                                                        <ice:inputText disabled="true" id="txtcolTotal" style="width: 50px" value="#{currentRow['totalCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextTotal"  value="#{msgTraining.Total}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEdit" style="width: 30px">
                                                                        <ice:commandLink action="#{Training$ActionPlanCost.cmdLnkOk_action}" id="cmdLnkOk"
                                                                            style="width: 30px" value="Ok"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEdit"  value="#{msgTraining.Edit}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRemove" style="width: 30px">
                                                                        <ice:commandLink action="#{Training$ActionPlanCost.cmdLnkRemove_action}"
                                                                            id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" style="width: 30px" value="Remove"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRemove"  value="#{msgTraining.Remove}"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:selectOneMenu binding="#{Training$ActionPlanCost.drlInstitution}" id="drlInstitution"
                                                                immediate="true" partialSubmit="true"
                                                                style="left: 122px; top: 38px; position: absolute; width: 193px"
                                                                value="#{Training$ActionPlanCost.defaultSelectedDataInstitution.selectedObject}" valueChangeListener="#{Training$ActionPlanCost.drlInstitution_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Training$ActionPlanCost.institutionList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$ActionPlanCost.drlBudjetyear}" id="drlBudjetyear"
                                                                partialSubmit="true" style="left: 122px; top: 8px; position: absolute; width: 193px"
                                                                value="#{Training$ActionPlanCost.defaultSelectedDataBudjetYear.selectedObject}" valueChangeListener="#{Training$ActionPlanCost.drlBudjetyear_processValueChange}">
                                                                <f:selectItems id="selectOneMenuBudjetyear" value="#{Training$ActionPlanCost.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$ActionPlanCost.drlAssignedTrainings}"
                                                                id="drlAssignedTrainings" partialSubmit="true"
                                                                style="left: 122px; top: 70px; position: absolute; width: 193px"
                                                                value="#{Training$ActionPlanCost.defaultSelectedData5.selectedObject}" valueChangeListener="#{Training$ActionPlanCost.drlAssignedTrainings_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Training$ActionPlanCost.trainingsList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblRefNumber" style="left: 24px; top: 360px; position: absolute" value="#{msgTraining.DocRefNo}"/>
                                                            <ice:outputLabel id="lblCostName" style="left: 24px; top: 336px; position: absolute"  value="#{msgTraining.Name}"/>
                                                            <ice:outputLabel id="lblFactor" style="left: 384px; top: 336px; position: absolute"  value="#{msgTraining.FactorQtty}"/>
                                                            <ice:outputLabel id="lblTrainingTitle" style="left: 48px; top: 72px; position: absolute"  value="#{msgTraining.Training}"/>
                                                            <ice:outputLabel id="lblBudjetYear" style="left: 45px; top: 8px; position: absolute"  value="#{msgTraining.BudjeYear}"/>
                                                            <ice:outputLabel id="lblInstitution" style="left: 45px; top: 38px; position: absolute"  value="#{msgTraining.Institution}"/>
                                                            <ice:inputText action="#{Training$ActionPlanCost.txtReferenceNumber_action}"
                                                                binding="#{Training$ActionPlanCost.txtReferenceNumber}" id="txtReferenceNumber"
                                                                style="left: 118px; top: 358px; position: absolute; width: 131px" value="0000"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtCostName}" id="txtCostName" style="left: 118px; top: 334px; position: absolute; width: 131px"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtFactor}" id="txtFactor" style="left: 454px; top: 334px; position: absolute; width: 63px"/>
                                                            <ice:outputLabel id="lblCostCategory" style="left: 24px; top: 312px; position: absolute"  value="#{msgTraining.CostCategory}"/>
                                                            <ice:outputLabel id="lblUnitCost" style="left: 384px; top: 312px; position: absolute"  value="#{msgTraining.UnitCost}"/>
                                                            <ice:inputText action="#{Training$ActionPlanCost.txtUnitCost_action}"
                                                                binding="#{Training$ActionPlanCost.txtUnitCost}" id="txtUnitCost" style="left: 454px; top: 310px; position: absolute; width: 62px"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtTotalCost}" disabled="true" id="txtTotalCost"
                                                                style="left: 454px; top: 358px; position: absolute; width: 63px" value="0.00"/>
                                                            <ice:selectOneMenu binding="#{Training$ActionPlanCost.drlCostCategories}" id="drlCostCategories"
                                                                partialSubmit="true" style="left: 118px; top: 310px; position: absolute; width: 171px"
                                                                value="#{Training$ActionPlanCost.defaultSelectedDataCostCategories.selectedObject}" valueChangeListener="#{Training$ActionPlanCost.drlCostCategories_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Training$ActionPlanCost.costCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectInputDate id="calAssignedDate" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Committee$CommitteeMemberRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Committee$CommitteeMemberRegistrationPage.calAssignedDate_processValueChange}"/>
                                                            <ice:outputLabel id="lblRemark" style="left: 24px; top: 384px; position: absolute"  value="#{msgTraining.Remark}"/>
                                                            <ice:inputTextarea binding="#{Training$ActionPlanCost.txtaRemark}" id="txtaRemark" style="height: 36px; left: 94px; top: 388px; position: absolute; width: 491px"/>
                                                            <ice:commandButton action="#{Training$ActionPlanCost.btnAddToTable_action}" id="btnAddToTable"
                                                                style="left: 456px; top: 422px; position: absolute" value="Add to table"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtOnOff}" disabled="true" id="txtOnOff" style="left: 574px; top: 334px; position: absolute; width: 52px"/>
                                                            <ice:outputLabel id="lblOnOff" style="left: 576px; top: 312px; position: absolute" value="On/Off Work"/>
                                                            <ice:commandButton action="#{Training$ActionPlanCost.button1_action}" id="button1"
                                                                style="left: 368px; top: 350px; position: absolute" value="Total Cost"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtStartDate}" id="txtStartDate" style="left: 522px; top: 8px; position: absolute; width: 100px"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtEndDate}" id="txtEndDate" style="left: 522px; top: 40px; position: absolute; width: 100px"/>
                                                            <ice:inputText binding="#{Training$ActionPlanCost.txtNoOfDays}" id="txtNoOfDays" style="left: 522px; top: 70px; position: absolute; width: 50px"/>
                                                            <ice:outputLabel id="lblStartDate" style="left: 450px; top: 8px; position: absolute" value="#{msgTraining.StartDate}"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 450px; top: 40px; position: absolute"  value="#{msgTraining.EndDate}"/>
                                                            <ice:outputLabel id="lblNoOfDays" style="left: 450px; top: 70px; position: absolute" value="#{msgTraining.NoOfDays}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: 9px; top: 624px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$ActionPlanCost.btnSaveOrUpdate_action}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Training$ActionPlanCost.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Training$ActionPlanCost.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                            <ice:commandButton action="#{Training$ActionPlanCost.btnDelete_action}" id="btnDelete"
                                                                rendered="false" style="left: 468px; top: 0px; position: absolute; width: 71px" value="Delete"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Training$ActionPlanCost.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$ActionPlanCost.btnClosePopupSuccessOrFailure_action}" id="btnClosePopupSuccessOrFailure"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$ActionPlanCost.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$ActionPlanCost.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$ActionPlanCost.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$ActionPlanCost.pnlPopupConfirmDelete}" draggable="true" id="pnlPopupConfirmDelete"
                            modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna Bank HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$ActionPlanCost.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$ActionPlanCost.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$ActionPlanCost.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$ActionPlanCost.pnlPopupStationaryCost}" draggable="true"
                            id="pnlPopupStationaryCost" modal="true" rendered="false" style="height: 207px; left: 419px; top: 246px; overflow: auto; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid2" style="display:block;width:380px;height:20px;">
                                    <ice:commandButton action="#{Training$ActionPlanCost.btnCloseStationaryCost_action}" id="btnCloseStationaryCost"
                                        immediate="true" partialSubmit="true"
                                        style="left:372px; font-size: 11px; border-color: red; color:red; margin-top: 0px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                    <ice:outputText id="otxtStationaryCostPopupHeader" value="            STATIONARY COST"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutPopupStationaryCostBody">
                                    <ice:dataTable id="dataTable1" value="#{Training$ActionPlanCost.stationaryCostList}" var="currentRow" width="397">
                                        <ice:column id="column1">
                                            <ice:outputText id="outputText1" value="#{currentRow['stationaryName']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText2" value="Stationary Name"/>
                                            </f:facet>
                                            <ice:rowSelector id="rowSelector1" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$ActionPlanCost.rowSelector1_processMyEvent}"/>
                                        </ice:column>
                                        <ice:column id="column2">
                                            <ice:outputText id="outputText3" value="#{currentRow['price']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText4" value="Price"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column3">
                                            <h:commandLink action="#{Training$ActionPlanCost.linkAction1_action}" id="linkAction1" value="Add"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText6" value="Add"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$ActionPlanCost.pnlPopupSalary}" draggable="true"
                            id="pnlPopupSalary" modal="true" rendered="false" style="height: 207px; left: 419px; top: 246px; overflow: auto; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid3" style="display:block;width:380px;height:20px;">
                                    <ice:commandButton action="#{Training$ActionPlanCost.btnCloseSalary_action}" id="btnCloseSalary"
                                        immediate="true" partialSubmit="true"
                                        style="left:372px; font-size: 11px; border-color: red; color:red; margin-top: 0px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                    <ice:outputText id="otxtSalaryPopupHeader" value="            SALARY"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutPopupSalaryBody">
                                    <ice:dataTable id="dataTable2" value="#{Training$ActionPlanCost.salaryList}" var="currentRow" width="397">
                                        <ice:column id="column1">
                                            <ice:outputText id="outputText1" value="#{currentRow['stationaryName']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText2" value="Employee Rank"/>
                                            </f:facet>
                                            <ice:rowSelector id="rowSelector2" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$ActionPlanCost.rowSelector2_processMyEvent}"/>
                                        </ice:column>
                                        <ice:column id="column2">
                                            <ice:outputText id="outputText3" value="#{currentRow['price']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText4" value="Salary"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column3">
                                            <h:commandLink action="#{Training$ActionPlanCost.linkAction2_action}" id="linkAction2" value="Calculate"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText6" value="Allowance"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$ActionPlanCost.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna Bank HRMS - View request status "/>
                                    <ice:commandLink action="#{Training$ActionPlanCost.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$ActionPlanCost.decisionsMadeOnRequest}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecisionGiven">
                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpId">
                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId"  value="#{msgTraining.employeeid}"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName"  value="#{msgTraining.FullName}"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="#{msgTraining.Comment}"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDate">
                                                <ice:outputText id="optTxtForDate" value="#{currentRow['decidedDateAndTIme']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="Date"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
