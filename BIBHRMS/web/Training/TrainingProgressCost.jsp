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
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$TrainingProgressCost.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$TrainingProgressCost.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$TrainingProgressCost.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$TrainingProgressCost.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$TrainingProgressCost.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
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
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
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
                                                    <ice:panelGroup dragListener="#{Training$TrainingProgressCost.status_Group_processMyEvent}"
                                                        id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Training$TrainingProgressCost.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Training$TrainingProgressCost.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Training$TrainingProgressCost.pendingRequestList}"/>
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
                                                <ice:outputLabel value="Manage Training Progress Cost"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 718px">
                                                    <ice:panelLayout id="panelLayout1" style="height: 689px; left: 21px; top: 20px; position: absolute; width: 737px">
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 581px; margin-left: 15px; left: 1px; top: 16px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:panelLayout id="pnlLayputTableParticipants"
                                                                style="height: 131px; margin-left: 15px; left: 15px; top: 107px; overflow: auto; position: absolute; width: 644px" styleClass="insideContainerMain">
                                                                <ice:dataTable id="dataTableParticipantLists"
                                                                    style="height: 8px; left: 20px; top: 0px; position: absolute"
                                                                    value="#{Training$TrainingProgressCost.trainingParticipantsList}" var="currentRow" width="665">
                                                                    <ice:column id="colNumber">
                                                                        <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['fullName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colFullName">
                                                                        <ice:outputText id="optTxtForColumnDeparmentName" value="#{currentRow['departmentName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDeparmentName" value="Deparment"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRepitition">
                                                                        <ice:outputText id="optTxtForColumnJobTitleName" value="#{currentRow['jobTitleName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextJobTitleName" value="Job Title "/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="pnlLayputCostTypes"
                                                                style="height: 153px; margin-left: 15px; left: 11px; top: 400px; overflow: auto; position: absolute; width: 645px" styleClass="insideContainerMain">
                                                                <ice:outputLabel id="lblTutationFee" rendered="false"
                                                                    style="height: 19px; left: 234px; top: 0px; position: absolute" value="Total Cost Is"/>
                                                                <ice:dataTable id="dataAdminstrativeCost"
                                                                    style="height: 8px; left: 16px; top: 16px; position: absolute; width: 600px"
                                                                    value="#{Training$TrainingProgressCost.trainingCostList}" var="currentRow">
                                                                    <ice:column id="colAdmoinsCostType" style="width: 50px">
                                                                        <ice:selectOneMenu id="drlCostCategoriesTable" partialSubmit="true" style="width: 50px" value="#{currentRow['costTypeCategory']}">
                                                                            <f:selectItems id="selectOneMenu1selectItemsTable" value="#{Training$TrainingProgressCost.costCategoryList}"/>
                                                                        </ice:selectOneMenu>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostType" value="Cost Type"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$TrainingProgressCost.rowSelector_processMyEvent}"/>
                                                                    </ice:column>
                                                                    <ice:column id="colCostName" style="width: 100px">
                                                                        <ice:inputText id="txtCostNameTable" style="width: 150px" value="#{currentRow['costTypeName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostNametable" value="Cost Name"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colUnitCost" style="width: 50px">
                                                                        <ice:inputText id="optTxtForColumnUnitCost" style="width: 50px" value="#{currentRow['unitCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextUnitCost" value="Unit Cost"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colQuantity">
                                                                        <ice:inputText id="optTxtForColumnQuantity" style="width: 50px" value="#{currentRow['quantityOrAmount']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit" value="Quantity"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="coTotal" style="width: 50px">
                                                                        <ice:inputText disabled="true" id="txtcolTotal" style="width: 50px" value="#{currentRow['totalCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextTotal" value="Total"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEdit" style="width: 30px">
                                                                        <ice:commandLink action="#{Training$TrainingProgressCost.cmdLnkOk_action}" id="cmdLnkOk"
                                                                            style="width: 30px" value="Ok"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRemove" style="width: 30px">
                                                                        <ice:commandLink action="#{Training$TrainingProgressCost.cmdLnkRemove_action}"
                                                                            id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" style="width: 30px" value="Remove"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:selectOneMenu binding="#{Training$TrainingProgressCost.drlBatch}" id="drlBatch"
                                                                immediate="true" partialSubmit="true"
                                                                style="left: 123px; top: 71px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingProgressCost.defaultSelectedDataBatch.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.drlBatch_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Training$TrainingProgressCost.batchList}"/>
                                                            </ice:selectOneMenu>
                                                            <!-- <ice:selectOneMenu id="drlBudjetYear" partialSubmit="true"
                                                                style="left: 122px; top: 8px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingProgressCost.selectOneMenu11Bean.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.drlBudjetYear_processValueChange}">
                                                                <f:selectItems id="selectOneMenuBudjetyear" value="#{Training$TrainingProgressCost.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            -->
                                                            <ice:selectOneMenu binding="#{Training$TrainingProgressCost.drlTrainings}" id="drlTrainings"
                                                                immediate="true" partialSubmit="true"
                                                                style="left: 122px; top: 41px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingProgressCost.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.drlTrainings_processValueChange}">
                                                                <f:selectItems id="selectOneMenu2selectItems" value="#{Training$TrainingProgressCost.trainingsList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblProgress" style="left: 429px; top: 1px; position: absolute" value="#{msgTraining.Progress}"/>
                                                            <ice:outputLabel id="lblStartDate" style="left: 427px; top: 26px; position: absolute" value="#{msgTraining.StartDate}"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 428px; top: 50px; position: absolute" value="#{msgTraining.EndDate}"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingProgressCost.drlProgressStatus}" disabled="true"
                                                                id="drlProgressStatus" immediate="true" partialSubmit="true"
                                                                style="left: 538px; top: 4px; position: absolute; width: 136px" value="#{Training$TrainingProgressPage.selectedRequestFromProgressList.selectedObject}">
                                                                <f:selectItems id="selectOneMenuProgress" value="#{Training$TrainingProgressPage.progressList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="left: 537px; top: 30px; position: absolute; width: 113px"/>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtEndDate}" disabled="true" id="txtEndDate" style="left: 536px; top: 58px; position: absolute; width: 112px"/>
                                                            <ice:outputLabel id="lblRefNumber" style="left: 24px; top: 336px; position: absolute" value="#{msgTraining.DocRefNo }"/>
                                                            <ice:outputLabel id="lblCostName" style="left: 24px; top: 312px; position: absolute" value="#{msgTraining.Name}"/>
                                                            <ice:outputLabel id="lblFactor" style="left: 380px; top: 274px; position: absolute" value="#{msgTraining.FactorQtty}"/>
                                                            <ice:outputLabel id="lblTrainingTitle" style="left: 51px; top: 37px; position: absolute" value="#{msgTraining.Training}"/>
                                                            <ice:outputLabel id="lblBudjetYear" style="left: 45px; top: 8px; position: absolute" value="#{msgTraining.BudjeYear}"/>
                                                            <ice:outputLabel id="lblBatch" style="left: 46px; top: 71px; position: absolute" value="#{msgTraining.Batch}"/>
                                                            <ice:inputText action="#{Training$TrainingProgressCost.txtReferenceNumber_action}"
                                                                binding="#{Training$TrainingProgressCost.txtReferenceNumber}" id="txtReferenceNumber"
                                                                style="left: 118px; top: 334px; position: absolute; width: 131px" value="0000"/>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtCostName}" id="txtCostName" style="left: 118px; top: 310px; position: absolute; width: 131px"/>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtFactor}" id="txtFactor" style="left: 456px; top: 275px; position: absolute; width: 62px"/>
                                                            <ice:outputLabel id="lblCostCategory" style="left: 24px; top: 288px; position: absolute" value="#{msgTraining.CostCategory}"/>
                                                            <ice:outputLabel id="lblUnitCost" style="left: 385px; top: 248px; position: absolute" value="#{msgTraining.UnitCost}"/>
                                                            <ice:inputText action="#{Training$TrainingProgressCost.txtUnitCost_action}"
                                                                binding="#{Training$TrainingProgressCost.txtUnitCost}" id="txtUnitCost" style="left: 455px; top: 246px; position: absolute; width: 62px"/>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtTotalCost}" disabled="true"
                                                                id="txtTotalCost" style="left: 455px; top: 303px; position: absolute; width: 63px" value="0.00"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingProgressCost.drlCostCategories}"
                                                                id="drlCostCategories" partialSubmit="true"
                                                                style="left: 118px; top: 286px; position: absolute; width: 171px"
                                                                value="#{Training$TrainingProgressCost.defaultSelectedDataCostCategories.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.drlCostCategories_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Training$TrainingProgressCost.costCategoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectBooleanCheckbox binding="#{Training$TrainingProgressCost.chkDaily}" id="chkDaily"
                                                                partialSubmit="true" style="left: 630px; top: 250px; position: absolute"
                                                                value="#{Training$TrainingProgressCost.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{Training$TrainingProgressCost.chkDaily_processValueChange}"/>
                                                            <ice:selectInputDate id="calAssignedDate" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Committee$CommitteeMemberRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{Committee$CommitteeMemberRegistrationPage.calAssignedDate_processValueChange}"/>
                                                            <ice:outputLabel id="lblRemark" style="left: 24px; top: 360px; position: absolute" value="#{msgTraining.Remark}"/>
                                                            <ice:inputTextarea binding="#{Training$TrainingProgressCost.txtaRemark}" id="txtaRemark" style="height: 36px; left: 94px; top: 358px; position: absolute; width: 350px"/>
                                                            <ice:commandButton action="#{Training$TrainingProgressCost.btnAddToTable_action}" id="btnAddToTable"
                                                                style="left: 528px; top: 350px; position: absolute" value="Add to table"/>
                                                            <ice:selectOneMenu binding="#{Training$TrainingProgressCost.drlBudjetYear}" id="drlBudjetYear"
                                                                partialSubmit="true" style="left: 122px; top: 8px; position: absolute; width: 193px"
                                                                value="#{Training$TrainingProgressCost.selectOneMenu11Bean.selectedObject}" valueChangeListener="#{Training$TrainingProgressCost.drlBudjetYear_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Training$TrainingProgressCost.budjetYearList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Training$TrainingProgressCost.txtNoOfDays}" disabled="true"
                                                                id="txtNoOfDays" style="left: 536px; top: 84px; position: absolute; width: 50px"/>
                                                            <ice:outputLabel id="lblDays" style="left: 428px; top: 75px; position: absolute" value="#{msgTraining.NoOfDays}"/>
                                                            <ice:commandButton action="#{Training$TrainingProgressCost.button1_action}" id="button1"
                                                                style="left: 376px; top: 294px; position: absolute" value="Total Cost"/>
                                                            <ice:outputLabel id="lblDaily" style="left: 555px; top: 248px; position: absolute" value="#{msgTraining.DailyCost}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: 9px; top: 624px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$TrainingProgressCost.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Training$TrainingProgressCost.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Training$TrainingProgressCost.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                            <ice:commandButton action="#{Training$TrainingProgressCost.btnDelete_action}" id="btnDelete"
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
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingProgressCost.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$TrainingProgressCost.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$TrainingProgressCost.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$TrainingProgressCost.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$TrainingProgressCost.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingProgressCost.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$TrainingProgressCost.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$TrainingProgressCost.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$TrainingProgressCost.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingProgressCost.pnlPopupStationaryCost}" draggable="true"
                            id="pnlPopupStationaryCost" modal="true" rendered="false" style="height: 199px; left: 419px; top: 446px; overflow: auto; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid2" style="display:block;width:380px;height:20px;">
                                    <ice:commandButton action="#{Training$TrainingProgressCost.btnCloseStationaryCost_action}" id="btnCloseStationaryCost"
                                        immediate="true" partialSubmit="true"
                                        style="left:372px; font-size: 11px; border-color: red; color:red; margin-top: 0px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                    <ice:outputText id="otxtStationaryCostPopupHeader" value="            STATIONARY COST"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutPopupStationaryCostBody" style="position: absolute; width: 406px">
                                    <ice:dataTable id="dataTable1" value="#{Training$TrainingProgressCost.stationaryCostList}" var="currentRow" width="397">
                                        <ice:column id="column1">
                                            <ice:outputText id="outputText1" value="#{currentRow['stationaryName']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText2" value="Stationary Name"/>
                                            </f:facet>
                                            <ice:rowSelector id="rowSelector1" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$TrainingProgressCost.rowSelector1_processMyEvent}"/>
                                        </ice:column>
                                        <ice:column id="column2">
                                            <ice:outputText id="outputText3" value="#{currentRow['price']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText4" value="Price"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column3">
                                            <h:commandLink action="#{Training$TrainingProgressCost.linkAction1_action}" id="linkAction1" value="Add"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText6" value="Add"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingProgressCost.pnlPopupSalary}" draggable="true" id="pnlPopupSalary"
                            modal="true" rendered="false" style="height: 199px; left: 419px; top: 446px; overflow: auto; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid3" style="display:block;width:380px;height:20px;">
                                    <ice:commandButton action="#{Training$TrainingProgressCost.btnCloseSalary_action}" id="btnCloseSalary" immediate="true"
                                        partialSubmit="true"
                                        style="left:372px; font-size: 11px; border-color: red; color:red; margin-top: 0px; position: absolute; visibility: visible; height:25px; width:25px" value="x"/>
                                    <ice:outputText id="otxtSalaryPopupHeader" value="            ALLOWANCE"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutPopupSalaryBody" style="position: absolute; width: 406px">
                                    <ice:dataTable id="dataTable2" value="#{Training$TrainingProgressCost.salaryList}" var="currentRow" width="397">
                                        <ice:column id="column1">
                                            <ice:outputText id="outputText1" value="#{currentRow['stationaryName']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText2" value="Employee Rank"/>
                                            </f:facet>
                                            <ice:rowSelector id="rowSelector2" multiple="false" preStyleOnSelection="true" selectionListener="#{Training$TrainingProgressCost.rowSelector2_processMyEvent}"/>
                                        </ice:column>
                                        <ice:column id="column2">
                                            <ice:outputText id="outputText3" value="#{currentRow['price']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText4" value="Salary"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column3">
                                            <h:commandLink action="#{Training$TrainingProgressCost.linkAction2_action}" id="linkAction2" value="Calculate"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText6" value="Allowance"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$TrainingProgressCost.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA BANK HRMS - View request status "/>
                                    <ice:commandLink action="#{Training$TrainingProgressCost.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Training$TrainingProgressCost.decisionsMadeOnRequest}" var="currentRow">
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
                                                    <ice:outputText id="headerTextEmpId" value="EmpId"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="Comment Given"/>
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
