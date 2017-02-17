<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : mekete VS Bravo Zulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>PROCESS ISSUED DISCIPLINE</title>
                <link HREF="../header_icon.ico" REL="icon"/>
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
                    function ReportPageRegistration(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$DisciplineApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$DisciplineApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$DisciplineApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$DisciplineApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$DisciplineApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1032">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:850px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 1013px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2"
                                            style="height: 789px; left: 0px; top: 0px; position: absolute; width: 213px; -rave-layout: grid" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="&quot;"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%"/>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="Common Tasks"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="DisciplineIssue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkAccusedDefence_action}"
                                                                id="lnkAccusedDefence" style="color:#306682;font-weight:bold" value="Accused Defence"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkEyeWitness_action}"
                                                                id="lnkEyeWitness" style="color:#306682;font-weight:bold" value="Eye Witness"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkDisciplineType_action}"
                                                                id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="DisciplineType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkPenaltyType_action}"
                                                                id="lnkPenaltyType" style="color:#306682;font-weight:bold" value="PenaltyType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkCommittee_action}" id="lnkCommittee"
                                                                style="color:#306682;font-weight:bold" value="Committees"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#306682;font-weight:bold" value="CommitteeMembers"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border-style: none; height: 245px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Pending">
                                                        <ice:outputText id="lblStatusPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardPending" width="100%">
                                                    <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:200px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerPending" style="height: 180px; position: absolute; width: 190px;overflow:scroll">
                                                            <ice:dataTable id="dataTable1" style="top: 0px; bottom: 0px; position: relative; width: 100%"
                                                                value="#{Discipline$DisciplineApprovePage.pendingRequestListsForTenacity}" var="currentRow">
                                                                <ice:column id="column15">
                                                                    <ice:outputText id="outputText32"
                                                                        style="color:#{currentRow['supportInfo'] eq 'true'?'black':'red'};" value="#{currentRow['requester_id']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText33" value="Requester id"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector2" multiple="false"
                                                                        selectionListener="#{Discipline$DisciplineApprovePage.rowSelector2_processMyEvent}" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                                <ice:column id="column16">
                                                                    <ice:outputText id="outputText34"
                                                                        style="color:#{currentRow['supportInfo'] eq 'true'?'black':'red'};" value="#{currentRow['offender_id']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText35" value="Offender id"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <ice:selectOneListbox id="selectPending" partialSubmit="true" rendered="false" size="7"
                                                                style="position: relative; height: 150px;  top: 0px; left: 0px; width: 190px"
                                                                value="#{Discipline$DisciplineApprovePage.selectedObjectPending.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.selectPending_processValueChange}">
                                                                <f:selectItems id="selectOneListbox3selectItems" value="#{Discipline$DisciplineApprovePage.pendingRequestLists}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border:none;  height: 260px;">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_History">
                                                        <ice:outputText id="lblStatusHistory" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardHistory" width="100%">
                                                    <ice:panelGroup id="status_Group_History" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:200px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerHistory" style="height: 190px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectHistory" partialSubmit="true" size="7"
                                                                style="position: relative;  top: 0px; height: 150px; left: 0px; width: 190px"
                                                                value="#{Discipline$DisciplineApprovePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.selectHistory_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Discipline$DisciplineApprovePage.decisionMadeByEmployeeLists}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Commeete" style="border-style: none; height: 220px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Commeete">
                                                        <ice:outputText id="lblStatusCommittee" value="Forward To Committee"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardCommeete" width="100%">
                                                    <ice:panelGroup id="status_Group_Commeete" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerCommeete" style="height: 190px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectCommeete" partialSubmit="true" size="7"
                                                                style="position: relative; height: 150px; width: 190px" valueChangeListener="#{Discipline$DisciplineApprovePage.selectCommeete_processValueChange}">
                                                                <f:selectItems id="selectOneListbox3selectItemsCommeete" value="#{Discipline$DisciplineApprovePage.committeeForwardList}"/>
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
                                <ice:panelGroup id="page_display" style="height:1200px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1200px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1170px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="PROCESS ISSUED DISCIPLINE"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 1150px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelLayout id="pnProfile" layout="flow" style="height: 1150px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                    <ice:panelGroup dragListener="#{Discipline$DisciplineApprovePage.pnlGrpEvaluationContent_processMyEvent}"
                                                        id="pnlGrpEvaluationContent" style="height: 1100px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 128px; margin-left: 15px; left: 20px; top: 10px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgsDecipline.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" partialSubmit="true" style="height: 23px; left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutEmployee"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 126px; margin-left: 15px; left: 20px; top: 150px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdLinkViewAllOffences_action}"
                                                                id="cmdLinkViewAllOffences" style="color:#306682; left: 248px; top: 4px; position: absolute" value="View All Offences Made by this Employee"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtEmployeeFullName}" disabled="true"
                                                                id="txtEmployeeFullName" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblAccused" style="left: 10px; top: 4px; position: absolute" value="#{msgsDecipline.Accused}"/>
                                                            <ice:outputLabel id="lblEmployeeDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblEmployeeId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtEmployeeDepartment}" disabled="true"
                                                                id="txtEmployeeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtEmployeeId}" disabled="true"
                                                                id="txtEmployeeId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblEmployeeFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblEmployeePosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtEmployeePosition}" disabled="true"
                                                                id="txtEmployeePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 1050px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnPostDecision_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.btnPostDecision}" disabled="true"
                                                                id="btnPostDecision" style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{PowerDeligation$PowerDeligationRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnReset_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.btnReset}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgsDecipline .Reset }"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutLink"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 20px; top: 990px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkToAccusedCommentPage_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.lnkToAccusedCommentPage}"
                                                                id="lnkToAccusedCommentPage"
                                                                style="color: rgb(48, 102, 130); height: 21px; left: 450px; top: 10px; position: absolute; width: 159px" value="To Accused Comment Page"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkViewAccusedComment_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.lnkViewAccusedComment}" id="lnkViewAccusedComment"
                                                                style="color: rgb(48, 102, 130); height: 21px; left: 304px; top: 10px; position: absolute; text-decoration: underline; width: 153px" value="view Accused Comment"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.lnkViewEyeWitnessComment_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.lnkViewEyeWitnessComment}"
                                                                id="lnkViewEyeWitnessComment"
                                                                style="color: rgb(48, 102, 130); height: 21px; left: 10px; top: 10px; position: absolute; width: 179px" value="view Eye Witness's Word"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.commandLink1_action}" id="commandLink1"
                                                                style="color: rgb(48, 102, 130); height: 21px; left: 610px; top: 10px; position: absolute; width: 101px" value="Reject Penality"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmd_OtherWord_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.cmd_OtherWord}" id="cmd_OtherWord"
                                                                style="color: rgb(48, 102, 130); height: 21px; left: 160px; top: 10px; position: absolute; width: 153px" value="ViewOther Witness Word"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlLayoutDecisoion}"
                                                            id="pnlLayoutDecisoion" layout="flow" rendered="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 395px; margin-left: 15px; left: 20px; top: 575px; position: absolute; width: 715px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txtaDecisionExplanation}"
                                                                id="txtaDecisionExplanation" style="left: 154px; top: 245px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbDecision}" id="lbDecision"
                                                                style="left: 52px; top: 338px; position: absolute" value="#{msgsDecipline.Decision}"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbNewPenalty}" id="lbNewPenalty"
                                                                style="left: 410px; top: 182px; position: absolute" value="#{msgsDecipline.otherPenality}"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlNewPenalty}" id="drlNewPenalty"
                                                                partialSubmit="true" style="left: 492px; top: 180px; position: absolute; width: 169px"
                                                                value="#{Discipline$DisciplineApprovePage.selectedDataOfPenality.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.drlNewPenalty_processValueChange}">
                                                                <f:selectItems id="selectOneMenuNewPenalty" value="#{Discipline$DisciplineApprovePage.penaltyTypesListOption}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlDecision}" id="drlDecision"
                                                                partialSubmit="true" style="left: 154px; top: 336px; position: absolute; width: 167px"
                                                                value="#{Discipline$DisciplineApprovePage.selectObjectOfDecisionType.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.drlDecision_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Discipline$DisciplineApprovePage.availableDecisionsToMake}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lblCommittee}" id="lblCommittee"
                                                                rendered="false" style="left: 52px; top: 335px; position: absolute" value="Committee"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlCommittee}" id="drlCommittee"
                                                                partialSubmit="true" rendered="false"
                                                                style="left: 166px; top: 335px; position: absolute; width: 167px" value="#{Discipline$DisciplineApprovePage.selectObjectOfCommittee.selectedObject}">
                                                                <f:selectItems id="selectOneMenuCommittee" value="#{Discipline$DisciplineApprovePage.committeeLists}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputTextarea
                                                                binding="#{Discipline$DisciplineApprovePage.txtaPenalityShouldBeGivenForThisOffence}"
                                                                disabled="true" id="txtaPenalityShouldBeGivenForThisOffence" rendered="true" style="height: 37px; left: 145px; top: 10px; position: absolute; width: 212px"/>
                                                            <ice:outputLabel id="lblAgreeOnDefaultPenalty"
                                                                style="height: 17px; left: 26px; top: 72px; position: absolute; width: 117px" value="#{msgsDecipline.Isthispenaltyfair}"/>
                                                            <ice:selectOneRadio binding="#{Discipline$DisciplineApprovePage.radioGroupAgreeOnDefaultPenalty}"
                                                                dir="LTR" id="radioGroupAgreeOnDefaultPenalty" layout="grid" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 21px; margin-left: 15px; left: 125px; top: 72px; position: absolute; width: 239px" valueChangeListener="#{Discipline$DisciplineApprovePage.radioGroupAgreeOnDefaultPenalty_processValueChange}">
                                                                <f:selectItem itemLabel="It Is Fair " itemValue="Fair"/>
                                                                <f:selectItem itemLabel="Exagurated " itemValue="Exagurated"/>
                                                                <f:selectItem itemLabel="Too  Small " itemValue="TooSmall"/>
                                                            </ice:selectOneRadio>
                                                            <ice:outputLabel id="lblPenalityShouldBeGiven" style="left: 26px; top: 24px; position: absolute" value="#{msgsDecipline.ExpectedPenality}"/>
                                                            <ice:outputLabel id="lbDeciderComment" rendered="false"
                                                                style="left: 78px; top: 337px; position: absolute" value="Comment"/>
                                                            <ice:outputLabel id="lbForwardToCommittee" style="left: 182px; top: 300px; position: absolute" value="#{msgsDecipline.Selectthisif}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Discipline$DisciplineApprovePage.ckbForwardToCommittee}"
                                                                id="ckbForwardToCommittee" partialSubmit="true"
                                                                style="left: 154px; top: 300px; position: absolute"
                                                                value="#{Discipline$DisciplineApprovePage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Discipline$DisciplineApprovePage.ckbForwardToCommittee_processValueChange}"/>
                                                            <ice:commandLink
                                                                action="#{Discipline$DisciplineApprovePage.cmdLinkConfirmCommitteeDecisions_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.cmdLinkConfirmCommitteeDecisions}"
                                                                id="cmdLinkConfirmCommitteeDecisions" rendered="true"
                                                                style="color: rgb(48, 102, 130); height: 31px; left: 26px; top: 364px; position: absolute; width: 670px" value="#{msgsDecipline .bringcommitteemembers}"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdLinkViewPreviesDecisions_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.cmdLinkViewPreviesDecisions}"
                                                                id="cmdLinkViewPreviesDecisions"
                                                                style="color: rgb(48, 102, 130); left: 520px; top: 338px; position: absolute" value="#{msgsDecipline .viewDescision}"/>
                                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdview_Committee_Comments_action}"
                                                                binding="#{Discipline$DisciplineApprovePage.cmdview_Committee_Comments}"
                                                                id="cmdview_Committee_Comments" style="left: 520px; top: 312px; position: absolute" value="#{msgsDecipline .ViewCommitteeComments}"/>
                                                            <ice:outputLabel id="outputLabel1" style="position: absolute; left: 410px; top: 24px" value="#{msgsDecipline.Deductamount}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_DeductAmount}" id="txt_DeductAmount" style="left: 500px; top: 24px; position: absolute; width: 65px"/>
                                                            <ice:outputLabel id="outputLabel2" style="left: 573px; top: 24px; position: absolute" value="#{msgsDecipline.Duration}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_Duration}" id="txt_Duration" style="left: 620px; top: 24px; position: absolute; width: 35px"/>
                                                            <ice:outputLabel id="outputLabel8" style="left: 416px; top: 105px; position: absolute" value="#{msgsDecipline.SuggetedPenalty}"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbl_SuggetedPenalty}"
                                                                id="lbl_SuggetedPenalty" style="left: 520px; top: 100px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel9" style="left: 340px; top: 144px; position: absolute" value="#{msgsDecipline.SuDeductamount }"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_Suggested_deduct}"
                                                                id="txt_Suggested_deduct" style="left: 492px; top: 150px; position: absolute; width: 65px"/>
                                                            <ice:outputLabel id="lbl_duration" style="left: 572px; top: 150px; position: absolute" value="#{msgsDecipline .SuDuration}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_suggetd_duration}"
                                                                id="txt_suggetd_duration" style="left: 640px; top: 150px; position: absolute; width: 33px"/>
                                                            <ice:outputLabel id="outputLabel10" style="left: 286px; top: 208px; position: absolute" value="#{msgsDecipline.ApprovedDeductamount }"/>
                                                            <ice:outputLabel id="outputLabel11" style="left: 520px; top: 208px; position: absolute" value="#{msgsDecipline.ApprovedDuration}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_approved_deduction}"
                                                                id="txt_approved_deduction" style="left: 440px; top: 206px; position: absolute; width: 70px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_approved_duration}"
                                                                id="txt_approved_duration" style="left: 622px; top: 206px; position: absolute; width: 33px"/>
                                                            <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.intxt_lastApprover_commeentes}"
                                                                id="intxt_lastApprover_commeentes" rendered="false" style="left: 154px; top: 240px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbl_approvedPen}" id="lbl_approvedPen"
                                                                rendered="false" style="left: 286px; top: 182px; position: absolute" value="Approved Penalty"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbl_approved_Penalty}"
                                                                id="lbl_approved_Penalty" rendered="false" style="left: 416px; top: 182px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel12" style="left: 390px; top: 52px; position: absolute" value="#{msgsDecipline.PromotionSuspend}"/>
                                                            <ice:outputLabel id="outputLabel13" style="left: 572px; top: 52px; position: absolute" value="#{msgsDecipline.Duration}"/>
                                                            <ice:outputLabel id="outputLabel14" style="left: 390px; top: 78px; position: absolute" value="#{msgsDecipline.TransferSuspend}"/>
                                                            <ice:outputLabel id="outputLabel15" style="left: 572px; top: 78px; position: absolute" value="#{msgsDecipline.Duration}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_Promotion_Suspend}"
                                                                id="txt_Promotion_Suspend" style="left: 500px; top: 50px; position: absolute; width: 69px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_Promotion_Duraion}"
                                                                id="txt_Promotion_Duraion" style="left: 622px; top: 50px; position: absolute; width: 60px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_SpendedTranfer}"
                                                                id="txt_SpendedTranfer" style="left: 500px; top: 76px; position: absolute; width: 69px"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_TransferDuration}"
                                                                id="txt_TransferDuration" style="left: 622px; top: 76px; position: absolute; width:60px"/>
                                                            <ice:outputLabel id="outputLabel16" style="left: 676px; top: 150px; position: absolute" value="#{msgsDecipline.Month}"/>
                                                            <ice:outputLabel id="outputLabel17" style="left: 665px; top: 26px; position: absolute" value="#{msgsDecipline.Month}"/>
                                                            <ice:outputLabel id="outputLabel18" style="left: 660px; top: 208px; position: absolute" value="#{msgsDecipline.Month}"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlPenaltyForManger1}"
                                                                id="drlPenaltyForManger1" partialSubmit="true" rendered="false"
                                                                style="left: 492px; top: 185px; position: absolute; width: 169px"
                                                                value="#{Discipline$DisciplineApprovePage.defaultSelectedData8.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.drlPenaltyForManger1_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems4" value="#{Discipline$DisciplineApprovePage.penaltyTypesListOptionForManager}"/>
                                                            </ice:selectOneMenu>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 195px; margin-left: 15px; left: 20px; top: 290px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDisciplineDate" style="left: 48px; top: 0px; position: absolute" value="#{msgsDecipline.DisciplineDate}"/>
                                                            <ice:outputLabel id="lblReportedDate" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.ReportedDate}"/>
                                                            <ice:outputLabel id="lblDisciplineType" style="left: 408px; top: 0px; position: absolute" value="#{msgsDecipline.DisciplineType }"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtDisciplineDate}" disabled="true"
                                                                id="txtDisciplineDate" style="left: 188px; top: 5px; position: absolute"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtReportedDate}" disabled="true"
                                                                id="txtReportedDate" style="left: 187px; top: 32px; position: absolute"/>
                                                            <ice:outputLabel id="lblRepitition" style="left: 408px; top: 34px; position: absolute" value="#{msgsDecipline.Repitition}"/>
                                                            <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txtaDisciplineDescription}"
                                                                disabled="true" id="txtaDisciplineDescription" style="height: 40px; left: 166px; top: 69px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDesciplineDescription" style="left: 49px; top: 64px; position: absolute" value="#{msgsDecipline.DisciplineDescription}"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlDisciplineType}" disabled="true"
                                                                id="drlDisciplineType" immediate="true" partialSubmit="true"
                                                                style="left: 528px; top: 8px; position: absolute; width: 143px" value="#{Discipline$DisciplineApprovePage.selectedObjectOfDisciplineType.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplineApprovePage.disciplineTypesList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtDisciplinePreviousOccurance}"
                                                                disabled="true" id="txtDisciplinePreviousOccurance" style="left: 527px; top: 35px; position: absolute; width: 143px"/>
                                                            <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txtaDisciplineDecisionTobeTaken}"
                                                                disabled="true" id="txtaDisciplineDecisionTobeTaken" style="height: 41px; left: 166px; top: 118px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDesciplineDecisiontoBeTaken"
                                                                style="left: 50px; top: 111px; position: absolute" value="#{msgsDecipline.RequesterInterest}"/>
                                                            <ice:inputText binding="#{Discipline$DisciplineApprovePage.txtDocReferenceNumber}" disabled="true"
                                                                id="txtDocReferenceNumber" style="left: 166px; top: 166px; position: absolute"/>
                                                            <ice:outputLabel id="lblDocReferenceNumber" style="left: 49px; top: 165px; position: absolute" value="#{msgsDecipline.DocRefNo}"/>
                                                            <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drl_disciplineForManager}"
                                                                id="drl_disciplineForManager" partialSubmit="true" rendered="true"
                                                                style="left: 528px; top: 8px; position: absolute; width: 143px" value="#{Discipline$DisciplineApprovePage.defaultSelectedData6.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Discipline$DisciplineApprovePage.disciplineTypesListForManager}"/>
                                                            </ice:selectOneMenu>
                                                        </ice:panelLayout>
                                                        <ice:selectInputDate binding="#{Discipline$DisciplineApprovePage.calOffenceDate}" id="calOffenceDate"
                                                            rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                            value="#{Discipline$DisciplineApprovePage.calOffenceDateBean.date1}" valueChangeListener="#{Discipline$DisciplineApprovePage.calOffenceDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Discipline$DisciplineApprovePage.calReportedDate}" id="calReportedDate"
                                                            rendered="false" style="left: 150px; top: 280px; position: absolute"
                                                            value="#{Discipline$DisciplineApprovePage.calReportedDateBean.date1}" valueChangeListener="#{Discipline$DisciplineApprovePage.calReportedDate_processValueChange}"/>
                                                        <ice:panelLayout id="pnl_Approver_txt" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 54px; margin-left: 15px; left: 20px; top: 500px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid">
                                                            <ice:outputLabel id="outputLabel21" style="left: 24px; top: 0px; position: absolute" value="#{msgsDecipline.ReporterID}"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.out_txt_deciderID}"
                                                                id="out_txt_deciderID" style="left: 144px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel23" style="left: 24px; top: 24px; position: absolute" value="#{msgsDecipline.ReporterFullName}"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.out_txt_deciderName}"
                                                                id="out_txt_deciderName" style="left: 144px; top: 24px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel25" style="left: 360px; top: 0px; position: absolute" value="#{msgsDecipline.ReporterDepartment}"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.out_txt_DeciderDepartment}"
                                                                id="out_txt_DeciderDepartment" style="left: 480px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel id="outputLabel27" style="left: 360px; top: 30px; position: absolute" value="#{msgsDecipline.ReporterPosition }"/>
                                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.out_txt_DeciderPosition}"
                                                                id="out_txt_DeciderPosition" style="left: 480px; top: 30px; position: absolute"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; top: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |
                                                           Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="false" binding="#{Discipline$DisciplineApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$DisciplineApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$DisciplineApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlPopupViewAccusedComment}" clientOnly="true"
                            draggable="false" id="pnlPopupViewAccusedComment" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 206px; left: 3px; top: 80px; position: absolute; width: 750px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageViewAccusedComment" style="background-color:#306682; height: 20px; padding-top: 8px; width: 750px">
                                    <ice:outputText id="pnMessageTitleViewAccusedComment"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System: Accused Reply"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.btnClosePopupViewAccusedComment_action}"
                                        id="btnClosePopupViewAccusedComment" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 775px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupViewAccusedComment" style="display: block; height: 160px; position: relative; width: 710px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:outputLabel id="lblAccusationAcceptance" style="left: 72px; top: 25px; position: absolute" value="Acceptance on Accusation"/>
                                    <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txtaAccusationAcceptance}" disabled="true"
                                        id="txtaAccusationAcceptance" style="height: 47px; left: 262px; top: 80px; position: absolute; width: 311px"/>
                                    <ice:outputLabel id="lblPenaltyAcceptance" style="left: 72px; top: 75px; position: absolute" value="Accused Interest "/>
                                    <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txtaPenaltyAcceptance}" disabled="true"
                                        id="txtaPenaltyAcceptance" style="height: 47px; left: 262px; top: 10px; position: absolute; width: 311px"/>
                                    <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lblPenaltyAcceptanceValue}" id="lblPenaltyAcceptanceValue"
                                        style="left: 582px; top: 80px; position: absolute; width: 119px" value=""/>
                                    <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lblAccusationAcceptanceValue}"
                                        id="lblAccusationAcceptanceValue" style="left: 580px; top: 10px; position: absolute; width: 118px" value=""/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdAccepatnce_action}"
                                        binding="#{Discipline$DisciplineApprovePage.cmdAccepatnce}" id="cmdAccepatnce" rendered="true"
                                        style="left: 582px; top: 35px; position: absolute " value="Down Load File"/>
                                    <ice:panelLayout id="pnlDownload" style="height: 38px; left: 72px; top: 105px; position: absolute; width: 20%">
                                        <ice:outputResource attachment="false" fileName="#{Discipline$DisciplineApprovePage.fileName}" id="downloadButton"
                                            label="DownLoad" mimeType="#{Discipline$DisciplineApprovePage.mimeType}"
                                            rendered="#{Discipline$DisciplineApprovePage.downloadAvailable}"
                                            resource="#{Discipline$DisciplineApprovePage.faResource}"
                                            style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                    </ice:panelLayout>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdInterset_action}"
                                        binding="#{Discipline$DisciplineApprovePage.cmdInterset}" id="cmdInterset" rendered="true"
                                        style="left: 582px; top: 105px; position: absolute " value="Down Load File"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlPopupAllCommittedOffences}" clientOnly="true"
                            draggable="false" id="pnlPopupAllCommittedOffences" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 300px; position: absolute; width: 838px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridAllCommittedOffences" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 840px">
                                    <ice:outputText id="pnMessageTitleAllCommittedOffences"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 780px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnClosePopupAllCommittedOffences_action}"
                                        id="btnClosePopupAllCommittedOffences" style="top: 5px; left :860px ;   position: absolute" value="x"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageAllCommittedOffences"
                                    style="display: block; height: 250px; position: relative; width: 800px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyAllCommittedOffences" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 222px; position: relative; width: 734px; -rave-layout: grid" styleClass="message">
                                        <ice:dataTable id="dataTableAllCommittedOffencesOfEmployee"
                                            style="left: 20px; top: 0px; height:8px; width:750px; position: absolute"
                                            value="#{Discipline$DisciplineApprovePage.allCommittedOffencesOfEmployee}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNum" value="#{currentRow['disciplineProblemId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNum" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column groupOn="#{currentRow['requesterId']}" id="colCommitteeName">
                                                <ice:outputText id="optTxtForColumnRequesteName" value="#{currentRow['requesterId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextRequesteName" value="Requester"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colRepitition">
                                                <ice:outputText id="optTxtForColumnOffenceDate" value="#{currentRow['dateOfOffence']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextOffenceDate" value="OffenceDate"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecider">
                                                <ice:outputText id="optTxtForColumnOffenceType" value="#{currentRow['offenceType']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextOffenceType" value="OffenceType"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPenality">
                                                <ice:outputText id="optTxtForColumnDescription" value="#{currentRow['descriptionOfOffence']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDescription" value="Description"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 1200px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="972">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 950px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px;  position: absolute; width: 1195px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 1170px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Discipline$DisciplineApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['lastCommeentes']}"/>
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
                                            <ice:column id="column1">
                                                <ice:outputText id="outputText3" value="#{currentRow['deductionAmount']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Expexted Deduction Amount"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2">
                                                <ice:outputText id="outputText5" value="#{currentRow['duration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText6" value="Expected Duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5">
                                                <ice:outputText id="outputText12" value="#{currentRow['suggetedPenality']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText13" value="Suggested penalty "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column6">
                                                <ice:outputText id="outputText14" value="#{currentRow['suggestedDeduction']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText15" value="Suggested penalty deduction"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column7">
                                                <ice:outputText id="outputText16" value="#{currentRow['suggestedDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText17" value="Suggested deduction duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column8">
                                                <ice:outputText id="outputText18" value="#{currentRow['approvedPenality']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText19" value="Approved Penalty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column9">
                                                <ice:outputText id="outputText20" value="#{currentRow['approvedDeduction']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText21" value="Approved penalty deduction"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column10">
                                                <ice:outputText id="outputText22" value="#{currentRow['approvedDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText23" value="Approved duration "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column11">
                                                <ice:outputText id="outputText24" value="#{currentRow['promotionSuspends']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText25" value="Suspended From Promtion"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column12">
                                                <ice:outputText id="outputText26" value="#{currentRow['promotionDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText27" value="Promotion Suspend Duration"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column13">
                                                <ice:outputText id="outputText28" value="#{currentRow['transferSuspends']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText29" value="Suspended From Transfer"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column14">
                                                <ice:outputText id="outputText30" value="#{currentRow['transferDuration']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText31" value="Transfer Suspend Duration"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlPopupCommitteeMembers}" id="pnlPopupCommitteeMembers"
                            modal="true" rendered="false" style="height: 453px; left: 408px; top: 240px; position: absolute; width: 813px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.btnClosePopupCommitteeMembers_action}"
                                        id="btnClosePopupCommitteeMembers" style="left: 650px; top: 20px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 356px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lblSignInReminder}" id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{Discipline$DisciplineApprovePage.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" rendered="true" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{Discipline$DisciplineApprovePage.committeeMembersList}" var="currentRow" width="697">
                                            <ice:column id="colPopupMemberId">
                                                <h:inputText binding="#{Discipline$DisciplineApprovePage.employeeID_textField}" id="employeeID_textField" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberId" value="ID"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberFullName">
                                                <h:inputText binding="#{Discipline$DisciplineApprovePage.employeeName_textField}" id="employeeName_textField" value="#{currentRow['employeeFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberFullName" value="Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberResponsiblty">
                                                <h:inputTextarea binding="#{Discipline$DisciplineApprovePage.responsiblity_textArea}"
                                                    id="responsiblity_textArea" value="#{currentRow['responsiblity']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMemberResponsiblty" value="Responsiblty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberComment">
                                                <h:inputTextarea id="textArea2" value="#{currentRow['commeentesGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMemberComent" value="Comment"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colSuggestedpenality">
                                                <h:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drl_suggestedPenality}" id="drl_suggestedPenality" value="#{currentRow['suggestedPenality']}">
                                                    <f:selectItems id="selectOneMenu1selectItemssuggestedPenality" value="#{Discipline$DisciplineApprovePage.penaltyTypesListOption}"/>
                                                </h:selectOneMenu>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10" value="Suggested Penalty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column binding="#{Discipline$DisciplineApprovePage.colCommeentsGivenDay}" id="colCommeentsGivenDay">
                                                <h:inputText binding="#{Discipline$DisciplineApprovePage.txt_CommeentsGivenDay}" id="txt_CommeentsGivenDay" value="#{currentRow['commeentGivenDay']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText2" value="Comments Given Day "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupUserName">
                                                <h:inputText binding="#{Discipline$DisciplineApprovePage.userName_textField}" id="userName_textField" value="#{currentRow['userName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupUserName" value="UserName"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupPassWord">
                                                <h:inputSecret binding="#{Discipline$DisciplineApprovePage.password_secretField}" id="password_secretField"
                                                    redisplay="true" value="#{currentRow['passWord']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPassWord" value="PassWord"/>
                                                </f:facet>
                                                <ice:rowSelector id="rowSelectorCommitteeMember" multiple="false" preStyleOnSelection="true"
                                                    selectionListener="#{Discipline$DisciplineApprovePage.rowSelectorCommitteeMember_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column id="colPopupMemberLogIn" rendered="true">
                                                <h:commandButton action="#{Discipline$DisciplineApprovePage.btnPopupForColumnMemberLogIn_action}"
                                                    binding="#{Discipline$DisciplineApprovePage.loginButton}" id="LoginButton" value="Login"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberLogIn" value="Log In"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupLoginConfirmed">
                                                <h:outputText binding="#{Discipline$DisciplineApprovePage.loginConfirmed1}" id="loginConfirmed1"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupLoginConfirmed" value="Confirmed"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:panelPopup binding="#{Discipline$DisciplineApprovePage.panelPopupMessageForCommeteComentes}" clientOnly="true"
                                        draggable="false" id="panelPopupMessageForCommeteComentes" rendered="false"
                                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 33px; top: 10px; position: absolute; width: 667px" styleClass="message">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGrid1forcommentes" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                <ice:outputText id="outputText1"
                                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                <ice:commandLink action="#{Discipline$DisciplineApprovePage.commentsbtnClosePopupSuccessOrFailure_action}"
                                                    id="commentsbtnClosePopupSuccessOrFailure" immediate="true"
                                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 600px; top: 20px; position: absolute; width: 19px"
                                                    styleClass="popupHeaderImage" title="Close Popup"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup binding="#{Discipline$DisciplineApprovePage.commentespanelGroupMessage}"
                                                id="commentespanelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                                <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.commentspnlMessageBody}"
                                                    id="commentspnlMessageBody" layout="flow"
                                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                    <h:outputLabel binding="#{Discipline$DisciplineApprovePage.commenteslblSuccessOrErrorMessage}"
                                                        id="commenteslblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
                                    <ice:outputText id="outputText36" style="position: absolute; left: 144px; top: 288px" value="Attach Committee Minute"/>
                                    <ice:inputFile actionListener="#{Discipline$DisciplineApprovePage.inputFile1_CommiteeMinute_processAction}"
                                        binding="#{Discipline$DisciplineApprovePage.inputFile1_CommiteeMinute}" id="inputFile1_CommiteeMinute" style="background-color: rgb(242, 246, 240); left: 312px; top: 288px; position: absolute"/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.button1_action}" id="button1"
                                        style="left: 408px; top: 320px; position: absolute" value="Save Minuite"/>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Discipline$DisciplineApprovePage.pnlPopupComeeteeComenets}" draggable="true" id="pnlPopupComeeteeComenets"
                            modal="true" rendered="fasle" style="height: 261px; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid binding="#{Discipline$DisciplineApprovePage.panelGridPopupViewCommiteeCommentes}"
                                    id="panelGridPopupViewCommiteeCommentes" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText binding="#{Discipline$DisciplineApprovePage.otxtViewCommeeteCommentesPopupHeader1}" dir="left"
                                        id="otxtViewCommeeteCommentesPopupHeader1" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnCloseViewPreviesDecisions_action}"
                                        actionListener="#{Discipline$DisciplineApprovePage.btnClosePopupCommeeteComeentes_processAction}"
                                        binding="#{Discipline$DisciplineApprovePage.btnClosePopupCommeeteComeentes}" id="btnClosePopupCommeeteComeentes"
                                        style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlLayoutCommeeteComentes}" id="pnlLayoutCommeeteComentes" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlLayoutPopupCommeteeCommentes}"
                                        id="pnlLayoutPopupCommeteeCommentes" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable binding="#{Discipline$DisciplineApprovePage.dataTableCommetesComentes}" id="dataTableCommetesComentes"
                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Discipline$DisciplineApprovePage.comeeteeCommentsGive}" var="currentRow">
                                            <ice:column id="colCommettes1">
                                                <ice:outputText id="optTxtForColumnNumber1" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber1" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colMemberID">
                                                <ice:outputText id="optTxtForColumnEmpId1" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId1" value="Employee ID"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colMemberFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName1" value="#{currentRow['committeeMembersFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName1" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colResponsiblity">
                                                <ice:outputText id="optTxtForCommentGiven1" value="#{currentRow['responsiblity']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven1" value="Responsiblity"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommeentesGiven">
                                                <ice:outputText id="optTxtForDate1" value="#{currentRow['commeentesGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate1" value="Comments Given "/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4">
                                                <ice:outputText id="outputText9" value="#{currentRow['suggestedPenality']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText11" value="Suggested Penality"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3">
                                                <ice:outputText id="outputText7" value="#{currentRow['commentesGivenDay']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8" value="Comments Given Day"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmd_view_ChairMan_Commeents_action}"
                                        binding="#{Discipline$DisciplineApprovePage.cmd_view_ChairMan_Commeents}" id="cmd_view_ChairMan_Commeents"
                                        rendered="true" style="left: 100px" value="View Chair Man Commentes"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmd_Post_chairMan_Commeete_action}"
                                        binding="#{Discipline$DisciplineApprovePage.cmd_Post_chairMan_Commeete}" id="cmd_Post_chairMan_Commeete"
                                        rendered="false" value="Post Chair Man Comments  "/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmd_downLoad_action}"
                                        binding="#{Discipline$DisciplineApprovePage.cmd_downLoad}" id="cmd_downLoad" value="DownLoad Miniute"/>
                                    <ice:panelLayout id="pnlDownloadForMinite" style="height: 38px; left: 480px; top: -5px; position: absolute; width: 20%">
                                        <ice:outputResource attachment="false" fileName="#{Discipline$DisciplineApprovePage.fileName}"
                                            id="downloadButtonForMini" label="DownLoad" mimeType="#{Discipline$DisciplineApprovePage.mimeType}"
                                            rendered="#{Discipline$DisciplineApprovePage.downloadAvailable}"
                                            resource="#{Discipline$DisciplineApprovePage.faResource}"
                                            style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.panelPopup_CommeeteChairMan}" clientOnly="true"
                            draggable="false" id="panelPopup_CommeeteChairMan" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 100px; position: absolute; width: 538px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridAllchairMan" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 630px">
                                    <ice:outputText id="pnMessageTitleAllCommitteeChairMan"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 580px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnClosePopupCommitteeChairMan_action}"
                                        id="btnClosePopupCommitteeChairMan" style="top: 5px; left:590px ;position: absolute" value="x"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageChairMan" style="display: block; height: 220px; position: relative; width: 600px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlMessageBodyAllChairMan}" id="pnlMessageBodyAllChairMan"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 162px; position: relative; width: 534px; -rave-layout: grid" styleClass="message">
                                        <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txt_ChairMan_Commentes}" id="txt_ChairMan_Commentes" style="height: 61px; left: 115px; top: 34px; position: absolute; width: 454px"/>
                                        <ice:outputLabel id="outputLabel3" style="left: 0px; top: 52px; position: absolute" value="General Commentes"/>
                                        <ice:outputLabel id="outputLabel4" style="left: 0px; top: 104px; position: absolute" value="Suggested Penality"/>
                                        <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drl_ChairMan_suggetedPenality}"
                                            id="drl_ChairMan_suggetedPenality" partialSubmit="true"
                                            style="left: 115px; top: 102px; position: absolute; width: 207px"
                                            value="#{Discipline$DisciplineApprovePage.defaultSelectedData5.selectedObject}" valueChangeListener="#{Discipline$DisciplineApprovePage.drl_ChairMan_suggetedPenality_processValueChange}">
                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Discipline$DisciplineApprovePage.penaltyTypesListOption}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputLabel id="outputLabel5" style="left: 338px; top: 102px; position: absolute" value="DeductAmount"/>
                                        <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_ChairMan_deductAmoun}" id="txt_ChairMan_deductAmoun" style="left: 425px; top: 102px; position: absolute; width: 77px"/>
                                        <ice:outputLabel id="outputLabel6" style="left: 338px; top: 130px; position: absolute" value="Duration"/>
                                        <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_chairMan_Duration}" id="txt_chairMan_Duration" style="left: 425px; top: 128px; position: absolute; width: 77px"/>
                                        <ice:commandButton action="#{Discipline$DisciplineApprovePage.btn_ChairMan_Post_action}" id="btn_ChairMan_Post"
                                            style="position: absolute; left: 130px; top: 140px" value="Save"/>
                                        <ice:outputLabel id="outputLabel7" style="left: 0px; top: 0px; position: absolute" value="Commeent Given Day"/>
                                        <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbl_commeents_Given_day}" id="lbl_commeents_Given_day" style="left: 130px; top: 0px; position: absolute"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.panelPopup_revocPenality}" clientOnly="true"
                            draggable="false" id="panelPopup_revocPenality" modal="true" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 130px; position: absolute; width: 538px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlGridAllrevocPenaltiy" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 630px">
                                    <ice:outputText id="pnMessageTitleRevocPenality"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 580px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandButton action="#{Discipline$DisciplineApprovePage.btnClosePopupRevocPenality_action}"
                                        id="btnClosePopupRevocPenality" style="top: 5px; left:590px ;position: absolute" value="x"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessageRevocPenality" style="display: block; height: 220px; position: relative; width: 600px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$DisciplineApprovePage.pnlMessageRevocPenality}" id="pnlMessageRevocPenality"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 190px; position: relative; width: 534px; -rave-layout: grid" styleClass="message">
                                        <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.txt_Approver_RevocPenality}"
                                            id="txt_Approver_RevocPenality" style="height: 57px; left: 115px; top: 34px; position: absolute; width: 454px"/>
                                        <ice:outputLabel id="outputLabelrevoc" style="left: 0px; top: 52px; position: absolute" value="General Commentes"/>
                                        <ice:commandButton action="#{Discipline$DisciplineApprovePage.btn_Revoce_Post_action}"
                                            binding="#{Discipline$DisciplineApprovePage.btn_Revoce_Post}" id="btn_Revoce_Post"
                                            style="left: 400px; top: 172px; position: absolute" value="Save"/>
                                        <ice:outputLabel id="outputLabeRevocl78" style="left: 0px; top: 0px; position: absolute" value="Commeent Given Day"/>
                                        <ice:outputLabel binding="#{Discipline$DisciplineApprovePage.lbl_commeents_Given_dayrevoc}"
                                            id="lbl_commeents_Given_dayrevoc" style="left: 130px; top: 0px; position: absolute"/>
                                        <ice:outputLabel id="outputLabel19" style="left: 0px; top: 156px; position: absolute" value="Document Referance Number"/>
                                        <ice:inputText binding="#{Discipline$DisciplineApprovePage.txt_Document_Referance}" id="txt_Document_Referance" style="height: 25px; left: 180px; top: 160px; position: absolute; width: 207px"/>
                                        <ice:outputLabel id="outputLabel20" style="left: 0px; top: 104px; position: absolute" value="CourtDecision "/>
                                        <ice:inputTextarea binding="#{Discipline$DisciplineApprovePage.in_txt_area_CourtDecision}"
                                            id="in_txt_area_CourtDecision" style="left: 115px; top: 102px; position: absolute; width: 454px"/>
                                        <ice:commandLink action="#{Discipline$DisciplineApprovePage.cmd_view_commeentes_action}" id="cmd_view_commeentes"
                                            style="left: 442px; top: 0px; position: absolute" value="ViewGivenCommeents"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlEyeWitnessesRegistration}" clientOnly="true"
                            draggable="false" id="pnlEyeWitnessesRegistration" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 406px; left: 3px; top: 80px; position: absolute; width: 787px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEyeWitnesses" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 820px">
                                    <ice:outputText id="pnMessageTitleEyeWitnesses"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 600px" value="BUNNA INTERNATIONAL BANK Human Resource Management System: List of eye witnesses"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.btnClosePopupEyeWitnesses_action}"
                                        id="btnClosePopupEyeWitnesses" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 845px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEyeWitnesses" style="display: block; height: 350px; position: relative; width: 771px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEyeWitnesses" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 323px; overflow:auto; position: relative; width: 696px; -rave-layout: grid" styleClass="message">
                                        <ice:panelLayout id="pnlLayoutWitnessDataTable"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 286px; margin-left: 15px; left: 10px; top: 24px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                            <ice:dataTable id="dataTableEyeWitnesses"
                                                style="width: 680px; left: 10px; top: 0px; height:8px;  position: absolute"
                                                value="#{Discipline$DisciplineApprovePage.eyeWitnessesList}" var="currentRow">
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
                                                </ice:column>
                                                <ice:column id="colMentionedByRequester">
                                                    <ice:outputText id="optTxtForColumnMentionedByRequester" value="#{currentRow['pointedByRequester']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextMentionedByRequester" value="BY REQ"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colMentionedByAccused">
                                                    <ice:outputText id="optTxtForColumnMentionedByAccused" value="#{currentRow['pointedByAccused']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextMentionedByAccused" value="BY ACC"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colEventDescription">
                                                    <ice:inputTextarea disabled="true" id="optTxtForColumnEventDescription" value="#{currentRow['eventDescription']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEventDesscription" value="Event Desscription"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colEmpId">
                                                    <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlSummaryOfWitness}" disabled="true"
                                                        id="drlSummaryOfWitness" value="#{currentRow['summary']}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$DisciplineApprovePage.summaryList}"/>
                                                    </ice:selectOneMenu>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEmpId" value="Summary"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colfileDownLoad">
                                                    <h:commandLink action="#{Discipline$DisciplineApprovePage.lnkFile_action}" disabled="false" id="lnkFile" value="#{currentRow['fileName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextDownLoad" value="File "/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colfileDownLoadButton">
                                                    <ice:panelLayout id="pnlDownloadEye" rendered="true" style="height: 38px; left:600px; top: 55px; position: absolute; width: 20%">
                                                        <ice:outputResource attachment="false" fileName="#{Discipline$DisciplineApprovePage.fileName}"
                                                            id="downloadButtonEye" label="DownLoad" mimeType="#{Discipline$DisciplineApprovePage.mimeType}"
                                                            rendered="#{Discipline$DisciplineApprovePage.downloadAvailable}"
                                                            resource="#{Discipline$DisciplineApprovePage.faResource}"
                                                            style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                    </ice:panelLayout>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextDownLoadButton" value="File Down Load"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$DisciplineApprovePage.pnlEyeWitnessesRegistrationOther}" clientOnly="true"
                            draggable="false" id="pnlEyeWitnessesRegistrationOther" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 406px; left: 3px; top: 80px; position: absolute; width: 787px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEyeWitnessesOther" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 820px">
                                    <ice:outputText id="pnMessageTitleEyeWitnessesOther"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 600px" value="BUNNA INTERNATIONAL BANK Human Resource Management System: List of eye witnesses"/>
                                    <ice:commandLink action="#{Discipline$DisciplineApprovePage.btnClosePopupEyeWitnessesOther_action}"
                                        id="btnClosePopupEyeWitnessesOther" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 845px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEyeWitnessesOther" style="display: block; height: 350px; position: relative; width: 771px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEyeWitnessesOther" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 323px; overflow:auto; position: relative; width: 696px; -rave-layout: grid" styleClass="message">
                                        <ice:panelLayout id="pnlLayoutWitnessDataTableOther"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 286px; margin-left: 15px; left: 10px; top: 24px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                            <ice:dataTable id="dataTableEyeWitnessesOther"
                                                style="width: 680px; left: 10px; top: 0px; height:8px;  position: absolute"
                                                value="#{Discipline$DisciplineApprovePage.eyeWitnessesListOther}" var="currentRow">
                                                <ice:column id="colStatusother">
                                                    <ice:outputText id="optTxtForColumnStatusOther" value="#{currentRow['databaseStatus']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextStatusOther" value="Status"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colWitnessIdOther">
                                                    <ice:outputText id="optTxtForColumnWitnessIdOther" value="#{currentRow['otherWitnessID']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextNumberOther" value="Witness Id"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colDecisionWitnessNameOther">
                                                    <ice:outputText id="optTxtForColumnWitnessNameOther" value="#{currentRow['otherwitnessFullName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextWitnessNameOther" value="Witness Name"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colMentionedByAccusedOther">
                                                    <ice:outputText id="optTxtForColumnMentionedByAccusedOther" value="#{currentRow['pointedBy']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextMentionedByAccusedOther" value="Pointed By"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colEventDescriptionOther">
                                                    <ice:inputTextarea disabled="true" id="optTxtForColumnEventDescriptionOther" value="#{currentRow['eventDescription']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEventDesscriptionOther" value="Event Desscription"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colEmpIdOther">
                                                    <ice:selectOneMenu binding="#{Discipline$DisciplineApprovePage.drlSummaryOfWitnessOther}" disabled="true"
                                                        id="drlSummaryOfWitnessOther" value="#{currentRow['summary']}">
                                                        <f:selectItems id="selectOneMenu1selectItemsOther" value="#{Discipline$DisciplineApprovePage.summaryList}"/>
                                                    </ice:selectOneMenu>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEmpIdOther" value="Summary"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colFileOther">
                                                    <h:commandLink action="#{Discipline$DisciplineApprovePage.lnkFileOther_action}" disabled="false"
                                                        id="lnkFileOther" value="#{currentRow['fileName']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextFileIdOther" value="AttahedFile"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colfileOtherDownLoadButton">
                                                    <ice:panelLayout id="pnlDownloadOtherEye" rendered="true" style="height: 38px; left:600px; top: 55px; position: absolute; width: 20%">
                                                        <ice:outputResource attachment="false" fileName="#{Discipline$DisciplineApprovePage.fileName}"
                                                            id="downloadButtonOtherEye" label="DownLoad" mimeType="#{Discipline$DisciplineApprovePage.mimeType}"
                                                            rendered="#{Discipline$DisciplineApprovePage.downloadAvailable}"
                                                            resource="#{Discipline$DisciplineApprovePage.faResource}"
                                                            style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                    </ice:panelLayout>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerFileDownLoadButton" value="File Down Load"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
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
