<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
    Author     : mekete/BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link HREF="./resources/images/header_icon.ico" REL="icon"/>
                <title>Penalty Types Registration Page</title>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$PenalityTypesRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$PenalityTypesRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$PenalityTypesRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$PenalityTypesRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$PenalityTypesRegistrationPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:460px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:450px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.lnkDisciplineType_action}"
                                                                id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="DisciplineType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="DisciplineIssue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.lnkCommitteeMembers_action}"
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
                                <ice:panelGroup id="page_display" style="height: 700px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 603px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 650px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="REGISTER Penalty"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" layout="flow" style="height: 597px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="pnlLayoutPenalty" layout="flow"
                                                    style="height: 257px; margin-left: 15px; left: 11px; top: 90px; position: absolute; width: 727px" styleClass="insideContainerMain">
                                                    <ice:inputText binding="#{Discipline$PenalityTypesRegistrationPage.txtPenaltyCode}" id="txtPenaltyCode" style="left: 172px; top: 10px; position: absolute; width: 174px"/>
                                                    <ice:inputText binding="#{Discipline$PenalityTypesRegistrationPage.txtPenaltyName}" id="txtPenaltyName" style="left: 172px; top: 40px; position: absolute; width: 496px"/>
                                                    <ice:inputText binding="#{Discipline$PenalityTypesRegistrationPage.txtNumberOfpenaltyDays}" disabled="true"
                                                        id="txtNumberOfpenaltyDays" style="left: 173px; top: 136px; position: absolute; width: 47px" value="0"/>
                                                    <ice:selectBooleanCheckbox binding="#{Discipline$PenalityTypesRegistrationPage.ckbPopupPenaltyNumberOfDays}"
                                                        id="ckbPopupPenaltyNumberOfDays" partialSubmit="true"
                                                        style="left: 445px; top: 138px; position: absolute"
                                                        value="#{Discipline$PenalityTypesRegistrationPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Discipline$PenalityTypesRegistrationPage.ckbPopupPenaltyNumberOfDays_processValueChange}"/>
                                                    <ice:inputTextarea binding="#{Discipline$PenalityTypesRegistrationPage.txtaPenaltyDescription}"
                                                        id="txtaPenaltyDescription" style="left: 172px; top: 70px; position: absolute; width: 495px"/>
                                                    <ice:outputLabel id="lblPopupPenaltyId" rendered="false" style="left: 432px; top: 24px; position: absolute" value="PenaltyId"/>
                                                    <ice:outputLabel id="lblPopupPenaltyCode" style="left: 48px; top: 10px; position: absolute" value="#{msgsDecipline. PenaltyCode }"/>
                                                    <ice:outputLabel id="lblPopupPenaltyName" style="left: 48px; top: 40px; position: absolute" value="#{msgsDecipline. PenaltyName }"/>
                                                    <ice:outputLabel id="lblPopupPenaltyDescription" style="left: 48px; top: 70px; position: absolute" value="#{msgsDecipline. Description }"/>
                                                    <ice:outputLabel id="lblPopupPenaltyActionTaker" style="left: 52px; top: 230px; position: absolute" value="#{msgsDecipline. ActionTaker}"/>
                                                    <ice:outputLabel id="lblPopupPenaltyDeductionNumOfDays" style="left: 46px; top: 133px; position: absolute" value="#{msgsDecipline. AmountofDeduct }"/>
                                                    <ice:outputLabel id="lblPopupPenaltyDeductionNumOfDaysCheckbox"
                                                        style="left: 470px; top: 134px; position: absolute" value="#{msgsDecipline.Selectifpenalty }"/>
                                                    <ice:selectOneMenu binding="#{Discipline$PenalityTypesRegistrationPage.drlPenaltyActionTaker}"
                                                        id="drlPenaltyActionTaker" partialSubmit="true"
                                                        style="left: 173px; top: 229px; position: absolute; width: 179px" value="#{Discipline$PenalityTypesRegistrationPage.defaultSelectedData1.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems3" value="#{Discipline$PenalityTypesRegistrationPage.deciderTypes}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton action="#{Discipline$PenalityTypesRegistrationPage.btnAddPenaltyToTable_action}"
                                                        id="btnAddPenaltyToTable" style="left: 588px; top: 165px; position: absolute" value="#{msgsDecipline. AddToTable}"/>
                                                    <ice:outputLabel id="lblPopupPenaltyActionTakerNew" style="left: 53px; top: 203px; position: absolute" value="#{msgsDecipline. ActionTaken}"/>
                                                    <ice:selectOneMenu binding="#{Discipline$PenalityTypesRegistrationPage.drlActionTAken}" id="drlActionTAken"
                                                        partialSubmit="true" style="left: 173px; top: 203px; position: absolute; width: 179px" valueChangeListener="#{Discipline$PenalityTypesRegistrationPage.drlActionTAken_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$PenalityTypesRegistrationPage.forWhomdecide}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputLabel id="outputLabel1" style="position: absolute; left: 53px; top: 175px" value="#{msgsDecipline. PenaltyFor }"/>
                                                    <ice:selectOneMenu binding="#{Discipline$PenalityTypesRegistrationPage.drlPenaltyFor}" id="drlPenaltyFor"
                                                        partialSubmit="true" style="left: 173px; top: 175px; position: absolute; width: 179px" value="#{Discipline$PenalityTypesRegistrationPage.defaultSelectedData3.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Discipline$PenalityTypesRegistrationPage.penaltyFor}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:outputLabel id="outputLabel2" style="left: 260px; top: 135px; position: absolute" value="#{msgsDecipline.DeductionDuration }"/>
                                                    <ice:inputText binding="#{Discipline$PenalityTypesRegistrationPage.txt_Deduction_Duration}"
                                                        id="txt_Deduction_Duration" style="left: 366px; top: 135px; position: absolute; width: 51px" value="0"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlLayoutPopupTablePenalty"
                                                    style="height: 257px; margin-left: 15px; left: 11px; top: 350px; overflow: auto; position: absolute; width: 726px" styleClass="insideContainerMain">
                                                    <ice:dataTable binding="#{Discipline$PenalityTypesRegistrationPage.dataTablePenalty}" id="dataTablePenalty"
                                                        rendered="false" style="height: 8px; left: 10px; top: 0px; position: absolute"
                                                        value="#{Discipline$PenalityTypesRegistrationPage.penaltyTypesList}" var="currentRow" width="654">
                                                        <ice:column id="colPopupPenaltyName1">
                                                            <ice:inputTextarea id="txtPopupForColumnPenaltyName2" value="#{currentRow['penaltyName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyName3" value="PenaltyName"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenaltyTypeCode4">
                                                            <ice:inputText id="txtPopupForColumnPenaltyTypeCode5" value="#{currentRow['penaltyTypeCode']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPenaltyTypeCodeForEmployee6" value="PenaltyCode"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupNumberOfPenalisedDays7">
                                                            <ice:inputText id="txtPopupForColumnNumberOfPenalisedDays8" value="#{currentRow['numberOfPenalisedDays']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextNumberOfPenalisedDays9" value=" Penalised Amount"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colDeductionDuration10">
                                                            <h:inputText id="textField111" value="#{currentRow['deductionDuration']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText412" value="Deduction Duration"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupDescription13">
                                                            <ice:inputTextarea id="txtPopupForColumnPenaltyDescription14" value="#{currentRow['penaltyDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyDescription15" value="Description"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenalityForEmployee16">
                                                            <ice:selectOneMenu id="colPopupPenalityFor" partialSubmit="true" value="#{currentRow['penalityFor']}">
                                                                <f:selectItems id="selectOneMenu1selectItemspenlityFor" value="#{Discipline$PenalityTypesRegistrationPage.penaltyFor}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="outputText117"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText218" value="PenaltyFor"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupActionTaker19">
                                                            <ice:selectOneMenu id="drlPopupForColumnActionTaker" partialSubmit="true" value="#{currentRow['actionTaker']}">
                                                                <f:selectItems id="selectOneMenu1selectItems4" value="#{Discipline$PenalityTypesRegistrationPage.deciderTypes}"/>
                                                            </ice:selectOneMenu>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPhaseoutPeriod20" value="ActionTaker"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupActionTaken21">
                                                            <ice:selectOneMenu
                                                                binding="#{Discipline$PenalityTypesRegistrationPage.drlPopupForColumnActionTakeen}"
                                                                id="drlPopupForColumnActionTakeen" partialSubmit="true" value="#{currentRow['actionTaken']}">
                                                                <f:selectItems binding="#{Discipline$PenalityTypesRegistrationPage.drltableActionTaken}"
                                                                    id="drltableActionTaken" value="#{Discipline$PenalityTypesRegistrationPage.forWhomdecide}"/>
                                                            </ice:selectOneMenu>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPhaseoutPeriod11" value="ActionTaken"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenaltyStatus" rendered="false">
                                                            <ice:outputText id="optTxtPopupForColumnPenaltyStatus" value="#{currentRow['status']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyStatus" value="Status"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelector1Penalitytype" preStyleOnSelection="true"
                                                                selectionListener="#{Discipline$PenalityTypesRegistrationPage.rowSelector1Penalitytype_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="colPopupEditForEmployee">
                                                            <ice:commandLink
                                                                action="#{Discipline$PenalityTypesRegistrationPage.btnPopupForColumnDisciplineEdit_action}"
                                                                id="btnPopupForColumnDisciplineEdit" rendered="#{currentRow['selected']}" value="Edit"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupEdit" value="Edit"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupDelete">
                                                            <ice:commandLink
                                                                action="#{Discipline$PenalityTypesRegistrationPage.lnkTxtPopupForColumnDelete_action}"
                                                                id="lnkTxtPopupForColumnDelete" rendered="#{currentRow['selected']}" value="Delete"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupDelete" value="Delete"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                    <ice:dataTable binding="#{Discipline$PenalityTypesRegistrationPage.dataTablePenaltyForManager}"
                                                        id="dataTablePenaltyForManager" rendered="false"
                                                        style="height: 8px; left: 10px; top: 0px; position: absolute"
                                                        value="#{Discipline$PenalityTypesRegistrationPage.managerPenalityList}" var="currentRow" width="654">
                                                        <ice:column id="colPopupPenaltyNameForManager1">
                                                            <ice:inputTextarea id="txtPopupForColumnPenaltyNameForManger1" value="#{currentRow['penaltyName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyNameForManager1" value="Penalty Name For Manager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenaltyTypeCodeForManager">
                                                            <ice:inputText id="txtPopupForColumnPenaltyTypeCodeForManager1" value="#{currentRow['penaltyTypeCode']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPenaltyTypeCodeForManager1" value="Penalty Code For Manager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupNumberOfPenalisedDaysForManager1">
                                                            <ice:inputText id="txtPopupForColumnNumberOfPenalisedDaysForManager1" value="#{currentRow['deductionAmount']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextNumberOfPenalisedDaysForManager1" value=" Penalised Amount For Manager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colDeductionDurationForManager1">
                                                            <h:inputText id="textField1ForManaer1" value="#{currentRow['deductionDuration']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText4ForManager1" value="Deduction Duration For Manager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupDescriptionForManager1">
                                                            <ice:inputTextarea id="txtPopupForColumnPenaltyDescriptionForManager1" value="#{currentRow['penaltyDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyDescriptionForManager1" value="DescriptionForManager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenalityForManager0101">
                                                            <ice:selectOneMenu id="colPopupPenalityForManager" partialSubmit="true" value="#{currentRow['penalityFor']}">
                                                                <f:selectItems id="selectOneMenu1selectItemspenlityForManager" value="#{Discipline$PenalityTypesRegistrationPage.penaltyFor}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="outputText1Manager1"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText2Manager1" value="PenaltyForManager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupActionTakerManager1">
                                                            <ice:selectOneMenu id="drlPopupForColumnActionTakerManager1" partialSubmit="true" value="#{currentRow['actionTaker']}">
                                                                <f:selectItems id="selectOneMenu1selectItems4Manager1" value="#{Discipline$PenalityTypesRegistrationPage.deciderTypes}"/>
                                                            </ice:selectOneMenu>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPhaseoutPeriodManager1" value="ActionTakerForManager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupActionTakenManager1">
                                                            <ice:selectOneMenu
                                                                binding="#{Discipline$PenalityTypesRegistrationPage.drlPopupForColumnActionTakeenManager}"
                                                                id="drlPopupForColumnActionTakeenManager" partialSubmit="true" value="#{currentRow['actionTaken']}">
                                                                <f:selectItems binding="#{Discipline$PenalityTypesRegistrationPage.drltableActionTakenManager}"
                                                                    id="drltableActionTakenManager" value="#{Discipline$PenalityTypesRegistrationPage.forWhomdecide}"/>
                                                            </ice:selectOneMenu>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPhaseoutPeriod1Manager" value="ActionTakenForManager"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupPenaltyStatusManager1" rendered="false">
                                                            <ice:outputText id="optTxtPopupForColumnPenaltyStatusManager1" value="#{currentRow['status']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupPenaltyStatusManager1" value="Status"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rowSelector1PenalitytypeManager" preStyleOnSelection="true"
                                                                selectionListener="#{Discipline$PenalityTypesRegistrationPage.rowSelector1PenalitytypeManager_processMyEvent}"
                                                                toggleOnClick="true" value="#{currentRow['selected']}"/>
                                                        </ice:column>
                                                        <ice:column id="colPopupEdit">
                                                            <ice:commandLink
                                                                action="#{Discipline$PenalityTypesRegistrationPage.btnPopupForColumnDisciplineEditManager_action}"
                                                                id="btnPopupForColumnDisciplineEditManager" rendered="#{currentRow['selected']}" value="Edit"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupEditManager" value="Edit"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colPopupDeleteManager">
                                                            <ice:commandLink
                                                                action="#{Discipline$PenalityTypesRegistrationPage.lnkTxtPopupForManagerColumnDelete_action}"
                                                                id="lnkTxtPopupForColumnDeleteManager" rendered="#{currentRow['selected']}" value="Delete"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="headerTextPopupDeleteManager" value="Delete"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="pnlLayoutButtons"
                                                    style="height: 40px; margin-left: 15px; left: 11px; top: 610px; overflow: auto; position: absolute; width: 726px" styleClass="insideContainerMain">
                                                    <ice:commandButton action="#{Discipline$PenalityTypesRegistrationPage.btnPopupSavePenalty_action}"
                                                        binding="#{Discipline$PenalityTypesRegistrationPage.btnPopupSavePenalty}" id="btnPopupSavePenalty"
                                                        style="left: 253px; top: -2px; position: absolute; width: 96px" value="#{msgsDecipline. Save}"/>
                                                    <ice:commandButton action="#{Discipline$PenalityTypesRegistrationPage.btnPopupResetPenalty_action}"
                                                        binding="#{Discipline$PenalityTypesRegistrationPage.btnPopupResetPenalty}" id="btnPopupResetPenalty"
                                                        style="left: 361px; top: -3px; position: absolute; width: 102px" value="#{msgsDecipline.Reset}"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="panelLayout_SelectionCondition" layout="flow"
                                                    style="height: 30px; margin-left: 15px; left: 11px; top: 50px; position: absolute; width: 717px" styleClass="insideContainerMain">
                                                    <ice:selectOneRadio id="selectOneRadio1" partialSubmit="true"
                                                        style="left: 168px; top: 0px; position: absolute" valueChangeListener="#{Discipline$PenalityTypesRegistrationPage.selectOneRadio1_processValueChange}">
                                                        <f:selectItem itemLabel="Penality for Employee " itemValue="#{Discipline$PenalityTypesRegistrationPage.EMPLOYEE}"/>
                                                        <f:selectItem itemLabel="Penality for Management " itemValue="#{Discipline$PenalityTypesRegistrationPage.MANAGER}"/>
                                                    </ice:selectOneRadio>
                                                </ice:panelLayout>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$PenalityTypesRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$PenalityTypesRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$PenalityTypesRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$PenalityTypesRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$PenalityTypesRegistrationPage.lblSuccessOrErrorMessage}"
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
