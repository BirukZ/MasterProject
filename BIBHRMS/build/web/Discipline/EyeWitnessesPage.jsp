<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
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
                    function EyeWitnessesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$EyeWitnessesPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$EyeWitnessesPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$EyeWitnessesPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$EyeWitnessesPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$EyeWitnessesPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="Discipline Issue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="Discipline Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkAccusedDefence_action}"
                                                                id="lnkAccusedDefence" style="color:#306682;font-weight:bold" value="Accused Defence"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkEyeWitness_action}" id="lnkEyeWitness"
                                                                style="color:#306682;font-weight:bold" value="Eye Witness"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkDisciplineType_action}"
                                                                id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="Discipline Type"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkPenaltyType_action}" id="lnkPenaltyType"
                                                                style="color:#306682;font-weight:bold" value="Penalty Type"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="Discipline Penalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkCommittee_action}" id="lnkCommittee"
                                                                style="color:#306682;font-weight:bold" value="Committees"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$EyeWitnessesPage.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#306682;font-weight:bold" value="Committee Members"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 187px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectPendingRequests" partialSubmit="true" size="2"
                                                                style="height: 168px; width: 168px"
                                                                value="#{Discipline$EyeWitnessesPage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Discipline$EyeWitnessesPage.selectPendingRequests_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Discipline$EyeWitnessesPage.pendingRequestLists}"/>
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
                                                <ice:outputLabel value="Manage Eye Witness Word"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 660px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 650px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 636px; top: 0px; position: absolute; width: 756px">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 128px; margin-left: 15px; left: 20px; top: 10px; position: absolute; width: 706px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgsDecipline.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" partialSubmit="true" style="height: 23px; left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutEmployee" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 126px; margin-left: 15px; left: 20px; top: 150px; position: absolute; width: 706px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtEmployeeFullName}" disabled="true"
                                                                id="txtEmployeeFullName" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblAccused" style="left: 10px; top: 4px; position: absolute" value="#{msgsDecipline.Accused}"/>
                                                            <ice:outputLabel id="lblEmployeeDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblEmployeeId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtEmployeeDepartment}" disabled="true"
                                                                id="txtEmployeeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtEmployeeId}" disabled="true"
                                                                id="txtEmployeeId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblEmployeeFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblEmployeePosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$EyeWitnessesPage.txtEmployeePosition}" disabled="true"
                                                                id="txtEmployeePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDataTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 213px; margin-left: 15px; left: 9px; top: 360px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{Discipline$EyeWitnessesPage.dataTableEyeWitnesses}"
                                                                id="dataTableEyeWitnesses" rendered="false"
                                                                style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                                value="#{Discipline$EyeWitnessesPage.eyeWitnessesList}" var="currentRow">
                                                                <ice:column id="colStatus">
                                                                    <ice:outputText id="optTxtForColumnStatus" value="#{currentRow['databaseStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatus" value="Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colWitnessId">
                                                                    <ice:outputText id="optTxtForColumnWitnessId" value="#{currentRow['witnessId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextNumber" value="Witness Id"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDecisionWitnessName">
                                                                    <ice:outputText id="optTxtForColumnWitnessName" value="#{currentRow['witnessFullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextWitnessName" value="Witness Name"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorDisciplinePenalty" multiple="false"
                                                                        preStyleOnSelection="true" selectionListener="#{Discipline$EyeWitnessesPage.rowSelectorDisciplinePenalty_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colEventDesscription">
                                                                    <ice:inputTextarea id="optTxtForColumnEventDesscription" value="#{currentRow['eventDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEventDesscription" value="Event Desscription"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column binding="#{Discipline$EyeWitnessesPage.colSummary}" id="colSummary">
                                                                    <ice:selectOneMenu id="drlSummaryOfWitness" partialSubmit="true" value="#{currentRow['summary']}">
                                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$EyeWitnessesPage.summaryList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEmpId" value="Summary"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDocRefNumber">
                                                                    <ice:inputText id="optTxtForColumnDocRefNumber" value="#{currentRow['docRefNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDocRefNumber" value="DocRefNumber"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemoveEntry">
                                                                    <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmdLnkEdit_action}" id="cmdLnkEdit" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDeleteEntryEmplyee">
                                                                    <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmdLnkDeleteEmployee_action}"
                                                                        id="cmdLnkDeleteEmployee" value="Delete"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDeleteEmployee" value="Delete"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <ice:dataTable binding="#{Discipline$EyeWitnessesPage.dataTableEyeWitnessesOther}"
                                                                id="dataTableEyeWitnessesOther" rendered="false"
                                                                style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                                                value="#{Discipline$EyeWitnessesPage.eyeWitnessesListOther}" var="currentRow">
                                                                <ice:column id="colStatusOther">
                                                                    <ice:outputText id="optTxtForColumnStatusOther" value="#{currentRow['databaseStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatusOther" value="Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colWitnessIdOther">
                                                                    <ice:outputText id="optTxtForColumnWitnessIdOther" value="#{currentRow['otherWitnessID']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextNumberOther" value="Witness Id Other"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorEyeWitnessOther" multiple="false" preStyleOnSelection="true" selectionListener="#{Discipline$EyeWitnessesPage.rowSelectorEyeWitness_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colDecisionWitnessNameOther">
                                                                    <ice:outputText id="optTxtForColumnWitnessNameOther" value="#{currentRow['otherwitnessFullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextWitnessNameOther" value="Other Witness Name"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorEyeWitness" multiple="false" preStyleOnSelection="true" selectionListener="#{Discipline$EyeWitnessesPage.rowSelectorEyeWitness_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colEventDesscriptionOther">
                                                                    <ice:inputTextarea id="optTxtForColumnEventDesscriptionOther" value="#{currentRow['eventDescription']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEventDesscriptionOther" value="Event Desscription"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEmpIdOther">
                                                                    <ice:selectOneMenu binding="#{Discipline$EyeWitnessesPage.drlSummaryOfWitness}"
                                                                        id="drlSummaryOfWitnessOther" partialSubmit="true" value="#{currentRow['summary']}">
                                                                        <f:selectItems id="selectOneMenu1selectItemsOther" value="#{Discipline$EyeWitnessesPage.summaryList}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEmpIdOther" value="Summary"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEmpIdOtherPointed">
                                                                    <ice:selectOneMenu binding="#{Discipline$EyeWitnessesPage.drlWitnessPointedCondition}"
                                                                        id="drlPointedOfWitnessOther" partialSubmit="true" value="#{currentRow['pointedBy']}">
                                                                        <f:selectItems id="selectOneMenu1selectItemsOtherPointed" value="#{Discipline$EyeWitnessesPage.pointdBy}"/>
                                                                    </ice:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEmpIdOtherPointed" value="Pointed By"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDocRefNumberOther">
                                                                    <ice:inputText id="optTxtForColumnDocRefNumberOther" value="#{currentRow['docRefNumber']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDocRefNumberOther" value="DocRefNumber"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemoveEntryOther">
                                                                    <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmdLnkEditOther_action}"
                                                                        id="cmdLnkEdit" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemoveOther" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDeleteEntryOther">
                                                                    <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmdLnkDeleteOther_action}"
                                                                        id="cmdLnkDelete" value="Delete"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDeleteOther" value="Delete"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:commandButton action="#{Discipline$EyeWitnessesPage.btnSave_action}" id="btnSave"
                                                            style="left: 312px; top: 590px; position: absolute; width: 119px" value="#{msgsDecipline.Save}"/>
                                                        <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmd_EmployeeWitness_action}"
                                                            binding="#{Discipline$EyeWitnessesPage.cmd_EmployeeWitness}" id="cmd_EmployeeWitness"
                                                            style="left: 120px; top: 336px; position: absolute" value="#{msgsDecipline.EmployeeWitness}"/>
                                                        <ice:commandLink action="#{Discipline$EyeWitnessesPage.cmd_Other_Witness_action}"
                                                            binding="#{Discipline$EyeWitnessesPage.cmd_Other_Witness}" id="cmd_Other_Witness"
                                                            style="left: 312px; top: 336px; position: absolute" value="#{msgsDecipline.otherEyeWitness}"/>
                                                        <ice:panelLayout id="panelLayout_upLoadFile" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 45px; margin-left: 15px; left: 20px; top: 288px; position: absolute; width: 706px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="outputLabel1" style="position: absolute; left: 66px; top: 5px" value="#{msgsDecipline .uploadfile}"/>
                                                            <ice:inputFile actionListener="#{Discipline$EyeWitnessesPage.inputFile_EyeWitness_processAction}"
                                                                id="inputFile_EyeWitness" style="background-color: rgb(242, 246, 240); left: 192px; top: 10px; position: absolute"/>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$EyeWitnessesPage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$EyeWitnessesPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$EyeWitnessesPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$EyeWitnessesPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$EyeWitnessesPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
