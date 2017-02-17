<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
    Author     : mekete VS Bravo Zulu 
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link HREF="./resources/images/header_icon.ico" REL="icon"/>
                <title>Descipline Types Registration Page</title>
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
                    function DisciplinePenaltyRegistrationPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png" style="left: 0px; top: 0px; position: absolute"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$DisciplinePenaltyRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$DisciplinePenaltyRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$DisciplinePenaltyRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$DisciplinePenaltyRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$DisciplinePenaltyRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                            <ice:commandLink
                                                                action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="DisciplineIssue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkAccusedDefence_action}"
                                                                id="lnkAccusedDefence" style="color:#306682;font-weight:bold" value="Accused Defence"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkEyeWitness_action}"
                                                                id="lnkEyeWitness" style="color:#306682;font-weight:bold" value="Eye Witness"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkDisciplineType_action}"
                                                                id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="DisciplineType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkPenaltyType_action}"
                                                                id="lnkPenaltyType" style="color:#306682;font-weight:bold" value="PenaltyType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkCommittee_action}"
                                                                id="lnkCommittee" style="color:#306682;font-weight:bold" value="Committees"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#306682;font-weight:bold" value="CommitteeMembers"/>
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
                                                        <ice:panelLayout id="StatusContainer" layout="flow" style="position: absolute;height: 187px; width: 100%">
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_view_Reptaion}"
                                                                id="drl_view_Reptaion" partialSubmit="true"
                                                                style="left: 24px; top: 50px; position: absolute; width: 155px" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.drl_view_Reptaion_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems6" value="#{Discipline$DisciplinePenaltyRegistrationPage.repititionTypesForSerach}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="outputText5" style="left: 26px; top: 26px; position: absolute" value="Select the Reputaion"/>
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
                                                <ice:outputLabel value="REGISTER Penalty OF OFFENCE"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 20px; position: absolute; width: 1000px">
                                                <ice:panelGroup dragListener="#{Discipline$DisciplinePenaltyRegistrationPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 790px; width: 760px" styleClass="filedset_border">
                                                    <ice:panelLayout id="disciplineReg" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 712px; margin-left: 15px; left: 0px; top: 20px; position: absolute; width: 732px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drlDisplineType}"
                                                            id="drlDisplineType" partialSubmit="true" rendered="true"
                                                            style="left: 166px; top: 60px; position: absolute; width: 183px"
                                                            value="#{Discipline$DisciplinePenaltyRegistrationPage.selectedDataOfDisciplineType.selectedObject}" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.drlDisplineType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplinePenaltyRegistrationPage.disciplineTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <!-- this is the point-->
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drlDisplineTypeForManager}"
                                                            id="drlDisplineTypeForManager" partialSubmit="true" rendered="false"
                                                            style="left: 166px; top: 60px; position: absolute; width: 183px"
                                                            value="#{Discipline$DisciplinePenaltyRegistrationPage.selectedDataOfDisciplineType.selectedObject}" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.drlDisplineTypeForManager_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItemsForManager" value="#{Discipline$DisciplinePenaltyRegistrationPage.disciplineTypesForManager}"/>
                                                        </ice:selectOneMenu>
                                                        <!-- this is the endiing-->
                                                        <ice:inputTextarea binding="#{Discipline$DisciplinePenaltyRegistrationPage.txtaDescription}"
                                                            disabled="true" id="txtaDescription" style="height: 60px; left: 154px; top: 90px; position: absolute; width: 534px"/>
                                                        <ice:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txtDisciplineCode}"
                                                            disabled="true" id="txtDisciplineCode" style="left: 526px; top: 46px; position: absolute; width: 156px"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drlRepitition}"
                                                            id="drlRepitition" partialSubmit="true"
                                                            style="left: 152px; top: 165px; position: absolute; width: 187px" value="#{Discipline$DisciplinePenaltyRegistrationPage.selectedDataOfRepition .selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Discipline$DisciplinePenaltyRegistrationPage.repititionTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDisciplineName" style="left: 24px; top: 60px; position: absolute; width: 93px" value="#{msgsDecipline.DisciplineName}"/>
                                                        <ice:outputLabel id="lblDescription" style="left: 24px; top: 120px; position: absolute" value="#{msgsDecipline.Description}"/>
                                                        <ice:outputLabel id="lblDisciplineCode" style="left: 432px; top: 48px; position: absolute" value="#{msgsDecipline.DisciplineCode}"/>
                                                        <ice:outputLabel id="lblRepitition" style="left: 24px; top: 168px; position: absolute" value="#{msgsDecipline.Repitition}"/>
                                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btnAddDisciplineType_action}"
                                                            id="btnAddDisciplineType" style="left: 360px; top: 50px; position: absolute" value="+"/>
                                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btnAddToTable_action}"
                                                            binding="#{Discipline$DisciplinePenaltyRegistrationPage.btnAddToTable}" id="btnAddToTable"
                                                            style="left: 600px; top: 254px; position: absolute" value="#{msgsDecipline.AddToTable}"/>
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 333px; margin-left: 15px; left: 0px; top: 310px; overflow: auto; position: absolute; width: 701px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{Discipline$DisciplinePenaltyRegistrationPage.dataTable}" id="dataTable"
                                                                rendered="false" style="left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                value="#{Discipline$DisciplinePenaltyRegistrationPage.disciplinePenaltyList}" var="currentRow">
                                                                <ice:column id="colStatus">
                                                                    <ice:outputText id="outputText1" value="#{currentRow['savedStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText3" value="Status"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector1" multiple="false" preStyleOnSelection="true"
                                                                        selectionListener="#{Discipline$DisciplinePenaltyRegistrationPage.rowSelectorDisciplinePenalty_processMyEvent}"
                                                                        toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                                <ice:column id="coldisciplineID">
                                                                    <ice:outputText id="disciplineIDoutputText1" value="#{currentRow['disciplineTypeCode']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="disciplineIDoutputText3" value="DisciplineID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDisciplimeName">
                                                                    <ice:outputText id="optTxtForColumnDisciplimeName" value="#{currentRow['disciplineName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDisciplimeName" value="DisciplineName"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRepitition">
                                                                    <ice:outputText id="optTxtForColumnRepitition" value="#{currentRow['repitition']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRepitition" value="Repitition"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPenalityID">
                                                                    <ice:outputText id="optTxtForColumnPenalityID" value="#{currentRow['penaltyTypeId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPenalityID" value="PenalityID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPenalty">
                                                                    <ice:outputText id="optTxtForColumnPenalty" value="#{currentRow['penaltyName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPenalty" value="Penalty"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSuspendedFrom">
                                                                    <h:selectOneMenu
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_suspendedPromotion}"
                                                                        id="drl_suspendedPromotion" value="#{currentRow['suspendedFrom']}">
                                                                        <f:selectItems id="selectOneMenu1selectItems5" value="#{Discipline$DisciplinePenaltyRegistrationPage.processTypes}"/>
                                                                    </h:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText2" value="Suspended From Promotion"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSuspendedDuration">
                                                                    <h:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_PromotionDuration}"
                                                                        id="txt_PromotionDuration" value="#{currentRow['suspendedDuration']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText4" value="Promotion Suspended Duration "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSusTransfer">
                                                                    <h:selectOneMenu
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_SuspededeTransfer}"
                                                                        id="drl_SuspededeTransfer" value="#{currentRow['suspendedTransfer']}">
                                                                        <f:selectItems id="selectOneMenu1selectItems4" value="#{Discipline$DisciplinePenaltyRegistrationPage.processTypes}"/>
                                                                    </h:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText6" value="Suspended From Tranansfer"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colTransferDuration">
                                                                    <h:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_transferDuration}"
                                                                        id="txt_transferDuration" value="#{currentRow['transferDuration']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText8" value="Transfer Suspended Duration"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemoveEntry">
                                                                    <h:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.btn_remove_action}"
                                                                        id="btn_remove" rendered="#{currentRow['selected']}" style="" value="Update"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Edite"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coldelete">
                                                                    <ice:commandLink
                                                                        action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkTxtPopupForColumnDelete_action}"
                                                                        id="lnkTxtPopupForColumnDelete" rendered="#{currentRow['selected']}" value="Delete"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText9" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <!--This is the point-->
                                                            <ice:dataTable binding="#{Discipline$DisciplinePenaltyRegistrationPage.dataTableForManager}"
                                                                id="dataTableForManager" rendered="false"
                                                                style="left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                value="#{Discipline$DisciplinePenaltyRegistrationPage.disciplinePenaltyListForManager}" var="currentRow">
                                                                <ice:column id="colStatus">
                                                                    <ice:outputText id="penalityIdForManageroutputText1" value="#{currentRow['savedStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText3" value="Status"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector1ForManager" multiple="false" preStyleOnSelection="true"
                                                                        selectionListener="#{Discipline$DisciplinePenaltyRegistrationPage.rowSelectorDisciplinePenaltyForManager_processMyEvent}"
                                                                        toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                                <ice:column id="colDiscineIDManager">
                                                                    <ice:outputText id="outputText1" value="#{currentRow['disciplineTypeCode']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="displineIDManageroutputText3" value="DisciplineID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDisciplimeNameForManager">
                                                                    <ice:outputText id="optTxtForColumnDisciplimeNameForManager" value="#{currentRow['disciplineName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextDisciplimeNameForManager" value="Discipline Name For Manager"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRepititionForManager">
                                                                    <ice:outputText id="optTxtForColumnRepititionForManager" value="#{currentRow['repitition']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRepititionForManager" value="Repitition"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPenaltyIDForManager">
                                                                    <ice:outputText id="optTxtForColumnPenaltyIDForManager" value="#{currentRow['penaltyTypeId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPenaltyIDForManager" value="PenaltyID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colPenaltyForManager">
                                                                    <ice:outputText id="optTxtForColumnPenaltyForManager" value="#{currentRow['penaltyName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextPenaltyForManager" value="Penalty"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSuspendedFromForManager">
                                                                    <h:selectOneMenu
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_suspendedPromotionForManager}"
                                                                        id="drl_suspendedPromotionForManager" value="#{currentRow['suspendedFrom']}">
                                                                        <f:selectItems id="selectOneMenu1selectItems5ForManager" value="#{Discipline$DisciplinePenaltyRegistrationPage.processTypes}"/>
                                                                    </h:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText2ForManager" value="Suspended From Promotion"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSuspendedDurationForManager">
                                                                    <h:inputText
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_PromotionDurationForManager}"
                                                                        id="txt_PromotionDurationForManager" value="#{currentRow['suspendedDuration']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText4ForManager" value="Promotion Suspended Duration "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSusTransferForManager">
                                                                    <h:selectOneMenu
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_SuspededeTransferForManager}"
                                                                        id="drl_SuspededeTransferForManager" value="#{currentRow['suspendedTransfer']}">
                                                                        <f:selectItems id="selectOneMenu1selectItems4ForManager" value="#{Discipline$DisciplinePenaltyRegistrationPage.processTypes}"/>
                                                                    </h:selectOneMenu>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText6ForManager" value="Suspended From Tranansfer"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colTransferDurationForManager">
                                                                    <h:inputText
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_transferDurationForManager}"
                                                                        id="txt_transferDurationForManager" value="#{currentRow['transferDuration']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText8ForManager" value="Transfer Suspended Duration"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemoveEntryForManager">
                                                                    <h:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btn_remove_action}"
                                                                        binding="#{Discipline$DisciplinePenaltyRegistrationPage.btn_remove}"
                                                                        id="btn_removeForManager" style="" value="Update"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemoveForManager" value="Edite"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coldeleteForManager">
                                                                    <ice:commandLink
                                                                        action="#{Discipline$DisciplinePenaltyRegistrationPage.lnkTxtPopupForColumnDeleteForManager_action}"
                                                                        id="lnkTxtPopupForColumnDeleteForManager" rendered="#{currentRow['selected']}" value="Delete"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText9" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <!--This is the endpoint-->
                                                        </ice:panelLayout>
                                                        <ice:inputTextarea binding="#{Discipline$DisciplinePenaltyRegistrationPage.txtaPenalty}" disabled="true"
                                                            id="txtaPenalty" style="left: 526px; top: 190px; position: absolute; width: 169px" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.txtaPenalty_processValueChange}"/>
                                                        <ice:outputLabel id="lblPenalty" style="left: 24px; top: 264px; position: absolute" value="#{msgsDecipline.Penalty}"/>
                                                        <ice:commandButton
                                                            action="#{Discipline$DisciplinePenaltyRegistrationPage.btnSaveDisciplinePenalty_action}"
                                                            binding="#{Discipline$DisciplinePenaltyRegistrationPage.btnSaveDisciplinePenalty}"
                                                            id="btnSaveDisciplinePenalty" style="left: 336px; top: 662px; position: absolute; width: 71px" value="#{msgsDecipline.Save}"/>
                                                        <ice:commandButton
                                                            action="#{Discipline$DisciplinePenaltyRegistrationPage.btnResetDisciplinePenalty_action}"
                                                            id="btnResetDisciplinePenalty" style="left: 432px; top: 662px; position: absolute; width: 71px" value="#{msgsDecipline.Reset}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drlPenalty}" id="drlPenalty"
                                                            partialSubmit="true" rendered="true"
                                                            style="left: 154px; top: 262px; position: absolute; width: 187px"
                                                            value="#{Discipline$DisciplinePenaltyRegistrationPage.selectedDataOfPenality.selectedObject}" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.drlPenalty_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Discipline$DisciplinePenaltyRegistrationPage.penaltyTypesListOption}"/>
                                                        </ice:selectOneMenu>
                                                        <!-- this is the starting point for Penality-->
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drlPenaltyForManger}"
                                                            id="drlPenaltyForManger" partialSubmit="true" rendered="false"
                                                            style="left: 154px; top: 262px; position: absolute; width: 187px"
                                                            value="#{Discipline$DisciplinePenaltyRegistrationPage.selectedDataOfPenality.selectedObject}" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.drlPenaltyForManger_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2ForManager" value="#{Discipline$DisciplinePenaltyRegistrationPage.penaltyTypesListOptionForManager}"/>
                                                        </ice:selectOneMenu>
                                                        <!-- this is the ending point-->
                                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btnAddPenaltyType_action}"
                                                            id="btnAddPenaltyType" style="left: 360px; top: 254px; position: absolute" value="+"/>
                                                        <ice:outputLabel id="lblDecider" style="left: 432px; top: 192px; position: absolute" value="#{msgsDecipline.Decider}"/>
                                                        <ice:outputLabel id="outputLabel4" style="left: 24px; top: 200px; position: absolute" value="#{msgsDecipline.Suspendedfrom}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplinePenaltyRegistrationPage.drl_processType}"
                                                            id="drl_processType" partialSubmit="true"
                                                            style="left: 154px; top: 200px; position: absolute; width: 181px" value="#{Discipline$DisciplinePenaltyRegistrationPage.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{Discipline$DisciplinePenaltyRegistrationPage.processTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="outputLabel5" style="left: 24px; top: 230px; position: absolute" value="#{msgsDecipline.SuspendedDuration}"/>
                                                        <ice:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_SuspendedDuration}"
                                                            id="txt_SuspendedDuration" style="left: 154px; top: 234px; position: absolute; width: 181px"/>
                                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btn_View_ProcessPopUp_action}"
                                                            binding="#{Discipline$DisciplinePenaltyRegistrationPage.btn_View_ProcessPopUp}"
                                                            id="btn_View_ProcessPopUp" rendered="false"
                                                            style="height: 25px; left: 338px; top: 146px; position: absolute; width: 25px" value="+"/>
                                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.btn_New_action}"
                                                            binding="#{Discipline$DisciplinePenaltyRegistrationPage.btn_New}" id="btn_New"
                                                            style="left: 240px; top: 662px; position: absolute; width: 71px" value="#{msgsDecipline.New}"/>
                                                        <ice:panelLayout id="panelLayout1Catagory" layout="flow"
                                                            style="height: 30px; margin-left: 15px; left: 0px; top: 10px; position: absolute; width: 702px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectOneRadio id="selectOneRadio1" partialSubmit="true"
                                                                style="left: 168px; top: 0px; position: absolute" valueChangeListener="#{Discipline$DisciplinePenaltyRegistrationPage.selectOneRadio1_processValueChange}">
                                                                <f:selectItem itemLabel="Discipline for Employee " itemValue="#{Discipline$DisciplinePenaltyRegistrationPage.EMPLOYEE}"/>
                                                                <f:selectItem itemLabel="Discipline for Management " itemValue="#{Discipline$DisciplinePenaltyRegistrationPage.MANAGER}"/>
                                                            </ice:selectOneRadio>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information|Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplinePenaltyRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplinePenaltyRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplinePenaltyRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplinePenaltyRegistrationPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Discipline$DisciplinePenaltyRegistrationPage.pan_PopUp_Register_Process}" clientOnly="true" draggable="false"
                            id="pan_PopUp_Register_Process" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 230px; left: 24px; top: 180px; position: absolute; width: 300px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnProcessMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 200px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Process Registration"/>
                                    <ice:commandLink action="#{Discipline$DisciplinePenaltyRegistrationPage.btnClosePopupProcessRergistrion_action}"
                                        id="btnClosePopupProcessRergistrion" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 630px; top: 25px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplinePenaltyRegistrationPage.panelGroupMessageProcess}"
                                    dragListener="#{Discipline$DisciplinePenaltyRegistrationPage.panelGroupMessageProcess_processMyEvent}"
                                    id="panelGroupMessageProcess" style="display: block; height: 180px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplinePenaltyRegistrationPage.pnlMainBody}" id="pnlMainBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 153px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <ice:outputLabel id="outputLabel1" style="left: 78px; top: 5px; position: absolute" value="Process ID"/>
                                        <ice:outputLabel id="outputLabel2" style="left: 78px; top: 52px; position: absolute" value="Process Name"/>
                                        <ice:outputLabel id="outputLabel3" style="left: 52px; top: 90px; position: absolute" value="Process Description"/>
                                        <ice:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_ProcessID}" id="txt_ProcessID" style="left: 180px; top: 5px; position: absolute"/>
                                        <ice:inputText binding="#{Discipline$DisciplinePenaltyRegistrationPage.txt_ProcessName}" id="txt_ProcessName" style="left: 180px; top: 50px; position: absolute"/>
                                        <ice:inputTextarea binding="#{Discipline$DisciplinePenaltyRegistrationPage.inTxt_ProcessDescription}"
                                            id="inTxt_ProcessDescription" style="left: 180px; top: 85px; position: absolute; width: 441px"/>
                                        <ice:commandButton action="#{Discipline$DisciplinePenaltyRegistrationPage.cmd_Save_Process_action}"
                                            id="cmd_Save_Process" style="left: 208px; top: 140px; position: absolute" value="Save"/>
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