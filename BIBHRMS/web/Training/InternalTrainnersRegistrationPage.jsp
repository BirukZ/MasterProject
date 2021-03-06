<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Template
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
                        <ice:panelBorder id="whole_page" renderCenter="#{Training$InternalTrainnersRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Training$InternalTrainnersRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Training$InternalTrainnersRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Training$InternalTrainnersRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Training$InternalTrainnersRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 789px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 777px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                        <li>
                                                            <ice:commandLink id="lnkGovernmentDeductions" style="color:#306682;font-weight:bold" value="Workflow Transition Page"/>
                                                        </li>
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
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Training$InternalTrainnersRegistrationPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Training$InternalTrainnersRegistrationPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Training$InternalTrainnersRegistrationPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Training$InternalTrainnersRegistrationPage.pendingRequestList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
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
                                                <ice:outputLabel value="Manage Payroll List and assign a dedecated person"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Training$InternalTrainnersRegistrationPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 686px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style=" top:0px; width: 100%; position: absolute; height: 100%;">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 200px; margin-left: 15px; left: 12px; top: 29px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectOneMenu binding="#{Training$InternalTrainnersRegistrationPage.drlTrainingDuration}"
                                                                id="drlTrainingDuration" partialSubmit="true"
                                                                style="left: 526px; top: 60px; position: absolute; width: 151px" value="#{Training$InternalTrainnersRegistrationPage.selectedObjectOfDurationsList.selectedObject}">
                                                                <f:selectItems id="selectOneMenuTrainingDuration" value="#{Training$InternalTrainnersRegistrationPage.tariningDurationsList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Training$InternalTrainnersRegistrationPage.drlTrainingCategory}"
                                                                id="drlTrainingCategory" partialSubmit="true"
                                                                style="left: 118px; top: 60px; position: absolute; width: 242px" value="#{Training$InternalTrainnersRegistrationPage.selectedObjectOfTrainingCategoryList.selectedObject}">
                                                                <f:selectItems id="selectOneMenuTrainnerCategory" value="#{Training$InternalTrainnersRegistrationPage.tariningCategoriesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Training$InternalTrainnersRegistrationPage.txtTrainingName}"
                                                                id="txtTrainingName" style="left: 35px; top: 32px; position: absolute; width: 393px"/>
                                                            <ice:inputTextarea binding="#{Training$InternalTrainnersRegistrationPage.txtaDescription}"
                                                                id="txtaDescription" style="height: 50px; left: 526px; top: 94px; position: absolute; width: 151px"/>
                                                            <ice:inputTextarea binding="#{Training$InternalTrainnersRegistrationPage.txtaExpectedOutcome}"
                                                                id="txtaExpectedOutcome" style="height: 50px; left: 118px; top: 118px; position: absolute; width: 242px"/>
                                                            <ice:commandButton action="#{Training$InternalTrainnersRegistrationPage.btnAddToTable_action}"
                                                                id="btnAddToTable" style="left: 459px; top: 156px; position: absolute" value="Add to Table"/>
                                                            <ice:outputLabel id="lblTrainingCategory"
                                                                style="height: 53px; left: 34px; top: 60px; position: absolute; width: 83px" value="#{msgTraining.TrainingCategory}"/>
                                                            <ice:outputLabel id="lblDuration" style="left: 432px; top: 60px; position: absolute; width: 94px" value="#{msgTraining.Duration}"/>
                                                            <ice:outputLabel id="lblDescription"
                                                                style="height: 53px; left: 34px; top: 120px; position: absolute; width: 83px" value="#{msgTraining.ExpectedOutcome}"/>
                                                            <ice:outputLabel id="lblComment" style="left: 432px; top: 110px; position: absolute; width: 94px" value="#{msgTraining.Description}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 356px; margin-left: 15px; left: 10px; top: 242px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableAllCommittedOffencesOfEmployee"
                                                                style="left: 20px; top: 0px; height:8px; width:720px; position: absolute"
                                                                value="#{Training$InternalTrainnersRegistrationPage.trainingTypesList}" var="currentRow">
                                                                <ice:column id="colTrainingCategory">
                                                                    <ice:selectOneMenu id="drlTrainingDurationTable" partialSubmit="true"
                                                                        style="left: 434px; top: 60px; position: absolute; width: 242px" value="#{currentRow['trainingCategory']}">
                                                                        <f:selectItems id="selectOneMenuTrainnerCategoryTable" value="#{Training$InternalTrainnersRegistrationPage.tariningCategoriesList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextTrainingCategory" value="#{msgTraining.Category}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colTrainingName">
                                                                    <ice:inputTextarea id="optTxtForColumnTrainingName" value="#{currentRow['trainingName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextTrainingName" value="#{msgTraining.TrainingName}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDescription">
                                                                    <ice:inputTextarea id="optTxtForColumnDescription" value="#{currentRow['description']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDescription" value="#{msgTraining.Description}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDurationCategory">
                                                                    <ice:selectOneMenu id="drlDurationCategoryTable" partialSubmit="true"
                                                                        style="left: 434px; top: 60px; position: absolute; width: 242px" value="#{currentRow['durationCategory']}">
                                                                        <f:selectItems id="selectOneMenuDurationCategoryTable" value="#{Training$InternalTrainnersRegistrationPage.tariningDurationsList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDurationCategory" value="#{msgTraining.Duration}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colExpectedOutput">
                                                                    <ice:inputText id="optTxtForColumnExpectedOutput" value="#{currentRow['expectedOutput']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextExpectedOutput" value="#{msgTraining.ExpectedOutcome}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEdit">
                                                                    <ice:commandLink action="#{Training$InternalTrainnersRegistrationPage.cmdLnkOk_action}"
                                                                        id="cmdLnkOk" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEdit" value="#{msgTraining.Edit}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemove">
                                                                    <ice:commandLink action="#{Training$InternalTrainnersRegistrationPage.cmdLnkRemove_action}"
                                                                        id="cmdLnkRemove" panelConfirmation="pnlConfirmForDelete" value="#{msgTraining.Remove}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="#{msgTraining.Remove}"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <ice:commandLink
                                                                action="#{Training$InternalTrainnersRegistrationPage.lnkViewPrevieousDecisions_action}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color:#306682;font-weight:bold; left: 480px; top: 360px; position: absolute" value="View status of  this request"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 54px; margin-left: 15px; left: 8px; top: 617px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Training$InternalTrainnersRegistrationPage.btnSaveOrUpdate_action}"
                                                                id="btnSaveOrUpdate" style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Training$InternalTrainnersRegistrationPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Training$InternalTrainnersRegistrationPage.btnReset_action}"
                                                                id="btnReset" style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Training$InternalTrainnersRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Training$InternalTrainnersRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Training$InternalTrainnersRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Training$InternalTrainnersRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Training$InternalTrainnersRegistrationPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Training$InternalTrainnersRegistrationPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value=" Bunna Bank HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Training$InternalTrainnersRegistrationPage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Training$InternalTrainnersRegistrationPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Training$InternalTrainnersRegistrationPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
