<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
    Author     : mekete VS BravoZulu
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
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$DisciplineTypesRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$DisciplineTypesRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$DisciplineTypesRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$DisciplineTypesRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$DisciplineTypesRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                            <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.lnkPenaltyType_action}"
                                                                id="lnkPenaltyType" style="color:#306682;font-weight:bold" value="PenaltyType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="DisciplineIssue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.lnkCommitteeMembers_action}"
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
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%">
                                                            <ice:outputLabel id="lblMsgStatusForRequest"
                                                                style="color: white; font-weight: bold; margin-left: 20px; margin-top: 65px; left: 20px; position: absolute; width: 187px" value="Request History  Board"/>
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
                                                <ice:outputLabel value="REGISTER OFFENCE TYPE"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Discipline$DisciplineTypesRegistrationPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 718px;top: 10px " styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutDiscipline" layout="flow"
                                                        style="height: 232px; margin-left: 15px; left: 2px; top: 60px; position: absolute; width: 713px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{Discipline$DisciplineTypesRegistrationPage.txtPopupDescplineId}"
                                                            disabled="true" id="txtPopupDescplineId" rendered="false" style="left: 502px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineTypesRegistrationPage.txtPopupDesciplineCode}"
                                                            id="txtPopupDesciplineCode" style="left: 172px; top: 10px; position: absolute; width: 107px"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineTypesRegistrationPage.txtPopupDesciplineName}"
                                                            id="txtPopupDesciplineName" style="font-family: 'Visual Geez Unicode',Verdana,Arial,Helvetica,sans-serif; left: 166px; top: 65px; position: absolute; width: 516px"/>
                                                        <ice:inputTextarea binding="#{Discipline$DisciplineTypesRegistrationPage.txtaPopupDescription}"
                                                            id="txtaPopupDescription" style="left: 166px; top: 94px; position: absolute; width: 516px"/>
                                                        <ice:inputText binding="#{Discipline$DisciplineTypesRegistrationPage.txtPopupPhaseoutTime}"
                                                            id="txtPopupPhaseoutTime" style="left: 166px; top: 166px; position: absolute; width: 102px" value="12"/>
                                                        <ice:outputLabel id="lblPopupDisciplineId" rendered="false"
                                                            style="left: 432px; top: 24px; position: absolute" value="DisciplineId"/>
                                                        <ice:outputLabel id="lblPopupDisciplineCode" style="left: 48px; top: 10px; position: absolute" value="#{msgsDecipline.DisciplineCode}"/>
                                                        <ice:outputLabel id="lblPopupDesciplineName" style="left: 48px; top: 60px; position: absolute" value="#{msgsDecipline.DisciplineName}"/>
                                                        <ice:outputLabel id="lblPopupDescription" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Description}"/>
                                                        <ice:outputLabel id="lblPopupPhaseoutTime" style="left: 48px; top: 168px; position: absolute" value="#{msgsDecipline.PhaseoutTime}"/>
                                                        <ice:outputLabel id="lblPopupDisciplineCategory" style="left: 352px; top: 9px; position: absolute" value="#{msgsDecipline.DisciplineCategory}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplineTypesRegistrationPage.drlDisciplineCategory}"
                                                            id="drlDisciplineCategory" partialSubmit="true"
                                                            style="left: 490px; top: 9px; position: absolute; width: 202px" value="#{Discipline$DisciplineTypesRegistrationPage.defaultSelectedDataDisciplineCategory.selectedObject}">
                                                            <f:selectItems id="selectOneMenuDisciplineCategory" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineCategoryOption}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Discipline$DisciplineTypesRegistrationPage.btnPopupAddToTable_action}"
                                                            id="btnPopupAddToTable" style="left: 600px; top: 182px; position: absolute" value="#{msgsDecipline.AddToTable}"/>
                                                        <ice:outputText id="outputText1" style="left: 354px; top: 35px; position: absolute" value="#{msgsDecipline.DisciplineSubCatagory}"/>
                                                        <ice:selectOneMenu binding="#{Discipline$DisciplineTypesRegistrationPage.drlSubCatagory}"
                                                            id="drlSubCatagory" partialSubmit="true"
                                                            style="left: 490px; top: 35px; position: absolute; width: 203px" value="#{Discipline$DisciplineTypesRegistrationPage.defaultSelectedData2.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineSubCategoryOption}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:panelLayout id="panelLayoutCatagory" layout="flow"
                                                            style="height: 30px; margin-left: 15px; left: -15px; top: -40px; position: absolute; width: 717px" styleClass="insideContainerMain">
                                                            <ice:selectOneRadio id="selectOneRadio1" partialSubmit="true"
                                                                style="left: 168px; top: 0px; position: absolute" valueChangeListener="#{Discipline$DisciplineTypesRegistrationPage.selectOneRadio1_processValueChange}">
                                                                <f:selectItem itemLabel="Discipline for Employee " itemValue="#{Discipline$DisciplineTypesRegistrationPage.EMPLOYEE}"/>
                                                                <f:selectItem itemLabel="Discipline for Management " itemValue="#{Discipline$DisciplineTypesRegistrationPage.MANAGER}"/>
                                                            </ice:selectOneRadio>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutPopupTable"
                                                        style="height: 354px; left: 20px; top: 300px; overflow: auto; position: absolute; width: 711px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Discipline$DisciplineTypesRegistrationPage.dataTableDisciplineType}"
                                                            id="dataTableDisciplineType" rendered="false"
                                                            style="height: 8px; left: 10px; top: 0px; position: absolute"
                                                            value="#{Discipline$DisciplineTypesRegistrationPage.disciplineTypesList}" var="currentRow" width="670">
                                                            <ice:column id="colPopupDisciplineName">
                                                                <ice:inputTextarea id="txtPopupForColumnDisciplineName" value="#{currentRow['disciplineName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineName" value="disciplineName"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCode">
                                                                <ice:inputText id="txtPopupForColumnDisciplineTypeCode" value="#{currentRow['disciplineTypeCode']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineTypeCode" value="DisciplineCode"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineCategory">
                                                                <ice:selectOneMenu id="drlPopupForColumnDisciplineCategory" partialSubmit="true" value="#{currentRow['disciplineCatagory']}">
                                                                    <f:selectItems id="selectOneMenuPopupForColumnDisciplineCategory" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineCategoryOption}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineCategory" value="Discipline Category"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplinesubCategory">
                                                                <ice:selectOneMenu id="drlPopupForColumnDisciplineSubCategory" partialSubmit="true" value="#{currentRow['disciplineSubCatagory']}">
                                                                    <f:selectItems id="selectOneMenuPopupForColumnDisciplineSubCategory" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineSubCategoryOption}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineSubCategory" value="Discipline SubCategory"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDescription">
                                                                <ice:inputTextarea id="txtPopupForColumnDescription" value="#{currentRow['description']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDescription" value="Description"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupPhaseoutPeriod">
                                                                <ice:inputText id="txtPopupForColumnPhaseoutPeriod" value="#{currentRow['phaseoutPeriod']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPhaseoutPeriod" value="PhaseoutPeriod"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorDisciplinePenaltyType" multiple="false"
                                                                    preStyleOnSelection="true"
                                                                    selectionListener="#{Discipline$DisciplineTypesRegistrationPage.rowSelectorDisciplineType_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineEdit">
                                                                <ice:commandLink
                                                                    action="#{Discipline$DisciplineTypesRegistrationPage.btnPopupForColumnEdit_action}"
                                                                    id="btnPopupForColumnDisciplineEdit" rendered="#{currentRow['selected']}" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineEdit" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineDelete">
                                                                <ice:commandLink
                                                                    action="#{Discipline$DisciplineTypesRegistrationPage.lnkPopupForColumnDelete_action}"
                                                                    id="lnkTxtPopupForColumnDelete" rendered="#{currentRow['selected']}" value="Delete"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineDelete" value="Delete"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:dataTable
                                                            binding="#{Discipline$DisciplineTypesRegistrationPage.dataTableDisciplineTypeForManagement}"
                                                            id="dataTableDisciplineTypeForManagement" rendered="true"
                                                            style="height: 8px; left: 10px; top: 0px; position: absolute"
                                                            value="#{Discipline$DisciplineTypesRegistrationPage.disciplineTypesListForManager}" var="currentRow" width="670">
                                                            <ice:column id="colPopupDisciplineName">
                                                                <ice:inputTextarea id="txtPopupForColumnDisciplineNameForManagement" value="#{currentRow['disciplineName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineNameForManagement" value="Discipline Name For Management"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineTypeCodeForManagement">
                                                                <ice:inputText id="txtPopupForColumnDisciplineTypeCodeForManagement" value="#{currentRow['disciplineTypeCode']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineTypeCodeManagement" value="Discipline Code For Management"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineCategoryManagement">
                                                                <ice:selectOneMenu id="drlPopupForColumnDisciplineCategoryManagement" partialSubmit="true" value="#{currentRow['disciplineCatagory']}">
                                                                    <f:selectItems id="selectOneMenuPopupForColumnDisciplineCategoryManagement" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineCategoryOption}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineCategoryManagement" value="Discipline Category For Management"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplinesubCategoryManagement">
                                                                <ice:selectOneMenu id="drlPopupForColumnDisciplineSubCategoryManagement" partialSubmit="true" value="#{currentRow['disciplineSubCatagory']}">
                                                                    <f:selectItems id="selectOneMenuPopupForColumnDisciplineSubCategoryManagement" value="#{Discipline$DisciplineTypesRegistrationPage.disciplineSubCategoryOption}"/>
                                                                </ice:selectOneMenu>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextDisciplineSubCategoryManagement" value="Discipline SubCategory For Management"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDescriptionMansagement">
                                                                <ice:inputTextarea id="txtPopupForColumnDescriptionManagement" value="#{currentRow['description']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDescriptionManagement" value="Description For Management"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupPhaseoutPeriodManagement">
                                                                <ice:inputText id="txtPopupForColumnPhaseoutPeriod" value="#{currentRow['phaseoutPeriod']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPhaseoutPeriodManagement" value="PhaseoutPeriod For Management"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorDisciplinePenaltyTypeManagement" multiple="false"
                                                                    preStyleOnSelection="true"
                                                                    selectionListener="#{Discipline$DisciplineTypesRegistrationPage.rowSelectorDisciplineTypeManager_processMyEvent}"
                                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineEditManagement">
                                                                <ice:commandLink
                                                                    action="#{Discipline$DisciplineTypesRegistrationPage.btnPopupForColumnEditForManager_action}"
                                                                    id="btnPopupForColumnDisciplineEdit" rendered="#{currentRow['selected']}" value="Ok"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineEditManagement" value="Edit"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colPopupDisciplineDeleteManagement">
                                                                <ice:commandLink
                                                                    action="#{Discipline$DisciplineTypesRegistrationPage.lnkPopupForColumnDeleteForManager_action}"
                                                                    id="lnkTxtPopupForColumnDeleteManagement" rendered="#{currentRow['selected']}" value="Delete"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextPopupDisciplineDeleteManagement" value="Delete"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="height: 51px; left: 20px; top: 660px; overflow: auto; position: absolute; width: 711px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Discipline$DisciplineTypesRegistrationPage.btnSave_action}" id="btnSave"
                                                            style="left: 240px; top: -4px; position: absolute; width: 81px" value="#{msgsDecipline.Save}"/>
                                                        <ice:commandButton action="#{Discipline$DisciplineTypesRegistrationPage.btnReset_action}" id="btnReset"
                                                            style="left: 333px; top: -3px; position: absolute; width: 93px" value="#{msgsDecipline.Reset}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineTypesRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineTypesRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineTypesRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineTypesRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplineTypesRegistrationPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
