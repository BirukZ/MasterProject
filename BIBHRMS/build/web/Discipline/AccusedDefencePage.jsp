<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : mekete VS BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocaalization_Decipline" var="msgsDecipline"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link HREF="../header_icon.ico" REL="icon"/>
                <title>Accused Defence Page</title>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{Discipline$AccusedDefencePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Discipline$AccusedDefencePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Discipline$AccusedDefencePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Discipline$AccusedDefencePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Discipline$AccusedDefencePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:800px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:860px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 870px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
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
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#306682;font-weight:bold" value="DisciplineIssue"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#306682;font-weight:bold" value="DisciplineApprove"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkAccusedDefence_action}"
                                                                id="lnkAccusedDefence" style="color:#306682;font-weight:bold" value="Accused Defence"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkEyeWitness_action}" id="lnkEyeWitness"
                                                                style="color:#306682;font-weight:bold" value="Eye Witness"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkDisciplineType_action}"
                                                                id="lnkDisciplineType" style="color:#306682;font-weight:bold" value="DisciplineType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkPenaltyType_action}" id="lnkPenaltyType"
                                                                style="color:#306682;font-weight:bold" value="PenaltyType"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkDisciplinePenalty_action}"
                                                                id="lnkDisciplinePenalty" style="color:#306682;font-weight:bold" value="DisciplinePenalty"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkCommittee_action}" id="lnkCommittee"
                                                                style="color:#306682;font-weight:bold" value="Committees"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#306682;font-weight:bold" value="CommitteeMembers"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Pending">
                                                        <ice:outputText id="lblStatusPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardPending" width="100%">
                                                    <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerPending" style="height: 125px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectPending" partialSubmit="true" size="7"
                                                                style="position: relative;  top: 0px; left: 0px; width: 190px"
                                                                value="#{Discipline$AccusedDefencePage.selectedObjectPending.selectedObject}" valueChangeListener="#{Discipline$AccusedDefencePage.selectPending_processValueChange}">
                                                                <f:selectItems id="selectOneListbox3selectItems" value="#{Discipline$AccusedDefencePage.pendingRequestLists}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_History" style="border-style: none; height: 260px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_History">
                                                        <ice:outputText id="lblStatusHistory" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardHistory" width="100%">
                                                    <ice:panelGroup id="status_Group_History" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerHistory" style="height: 125px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectHistory" partialSubmit="true" size="7"
                                                                style="position: relative;  top: 0px; left: 0px; width: 190px"
                                                                value="#{Discipline$AccusedDefencePage.selectedObjectHistory.selectedObject}" valueChangeListener="#{Discipline$AccusedDefencePage.selectHistory_processValueChange}">
                                                                <f:selectItems id="selectOneListbox4selectItems" value="#{Discipline$AccusedDefencePage.historyRequestLists}"/>
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
                                <ice:panelGroup id="page_display" style="height:990px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 975px; left: 0px; top: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 965px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Accused Defence"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 931px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelLayout id="pnProfile" style="height: 940px; left: 0px; top: 0px; position: absolute; width: 776px">
                                                    <ice:panelGroup id="pnlGrpEvaluationContent" style="height: 910px; width: 749px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 136px; margin-left: 15px; left: 20px; top: 20px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                            <ice:outputLabel id="lblRequester" style="left: 12px; top: -3px; position: absolute" value="#{msgsDecipline.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" partialSubmit="true" style="height: 23px; left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutEmployee" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 140px; margin-left: 15px; left: 20px; top: 170px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtEmployeeFullName}" disabled="true"
                                                                id="txtEmployeeFullName" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:outputLabel id="lblAccused" style="left: 11px; top: -2px; position: absolute" value="#{msgsDecipline.Accused}"/>
                                                            <ice:outputLabel id="lblEmployeeDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgsDecipline.Department}"/>
                                                            <ice:outputLabel id="lblEmployeeId" style="left: 432px; top: 24px; position: absolute" value="#{msgsDecipline.Id}"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtEmployeeDepartment}" disabled="true"
                                                                id="txtEmployeeDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtEmployeeId}" disabled="true"
                                                                id="txtEmployeeId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblEmployeeFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.FullName}"/>
                                                            <ice:outputLabel id="lblEmployeePosition" style="left: 48px; top: 96px; position: absolute" value="#{msgsDecipline.Position}"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtEmployeePosition}" disabled="true"
                                                                id="txtEmployeePosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 840px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Discipline$AccusedDefencePage.btnSaveOrUpdate_action}"
                                                                binding="#{Discipline$AccusedDefencePage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{PowerDeligation$PowerDeligationRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Discipline$AccusedDefencePage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgs.Reset}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutHistory" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 268px; margin-left: 15px; left: 20px; top: 560px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAcceptOrNot" style=" top:10px; left:20px; position: absolute" value="#{msgsDecipline.DoYouAccept}"/>
                                                            <ice:selectOneRadio binding="#{Discipline$AccusedDefencePage.radioGroupAccusationAcceptance}"
                                                                dir="LTR" id="radioGroupAccusationAcceptance" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); left: 169px; top: 12px; position: absolute; width: 502px" valueChangeListener="#{Discipline$AccusedDefencePage.radioGroupAccusationAcceptance_processValueChange}">
                                                                <f:selectItem itemLabel="Fully Accept" itemValue="FAA"/>
                                                                <f:selectItem itemLabel="Partially Accept" itemValue="PAA"/>
                                                                <f:selectItem itemLabel="Dont Accept" itemValue="DAA"/>
                                                            </ice:selectOneRadio>
                                                            <ice:outputLabel id="lblAccusationAcceptance" style=" top:46px; left:20px; position: absolute" value="#{msgsDecipline.GiveyourComment}"/>
                                                            <ice:inputTextarea binding="#{Discipline$AccusedDefencePage.txtaAccusationAcceptance}"
                                                                id="txtaAccusationAcceptance" style="height: 23px; left: 166px; top: 46px; position: absolute; width: 500px"/>
                                                            <ice:outputLabel id="lblAcceptOrNot22" style="left: 24px; top: 120px; position: absolute" value="#{msgsDecipline. DoYouAcceptP }"/>
                                                            <ice:selectOneRadio binding="#{Discipline$AccusedDefencePage.radioGroupPenaltyAcceptance}" dir="LTR"
                                                                id="radioGroupPenaltyAcceptance" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); left: 168px; top: 120px; position: absolute; width: 499px" valueChangeListener="#{Discipline$AccusedDefencePage.radioGroupPenaltyAcceptance_processValueChange}">
                                                                <f:selectItem itemLabel="Fully Accept" itemValue="FAP"/>
                                                                <f:selectItem itemLabel="Partially Accept" itemValue="PAP"/>
                                                                <f:selectItem itemLabel="Dont Accept" itemValue="DAP"/>
                                                            </ice:selectOneRadio>
                                                            <ice:outputLabel id="lblPenaltyAcceptance" style="left: 24px; top: 162px; position: absolute" value="#{msgsDecipline. Whatisyourint }"/>
                                                            <ice:inputTextarea binding="#{Discipline$AccusedDefencePage.txtaPenaltyAcceptance}"
                                                                id="txtaPenaltyAcceptance" style="height: 24px; left: 166px; top: 166px; position: absolute; width: 501px"/>
                                                            <ice:outputLabel id="lblDocReferenceNumber" style="left: 24px; top: 236px; position: absolute" value="#{msgsDecipline. DocRefNo }"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtDocReferenceNumber}"
                                                                id="txtDocReferenceNumber" style="left: 166px; top: 240px; position: absolute"/>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkRecordEyeWitnesses_action}"
                                                                binding="#{Discipline$DisciplineRequestPage.lnkRecordEyeWitnesses}" id="lnkRecordEyeWitnesses"
                                                                style="left: 552px; top: 216px; position: absolute" value="#{msgsDecipline. regEyeWitness }"/>
                                                            <ice:commandLink action="#{Discipline$AccusedDefencePage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Discipline$AccusedDefencePage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions" style="left: 504px; top: 240px; position: absolute" value="#{msgsDecipline. viewDescision}"/>
                                                            <ice:outputLabel id="outputLabel1" style="left: 20px; top: 82px; position: absolute" value="#{msgsDecipline.attachCommetFile}"/>
                                                            <ice:outputText escape="false" id="outputText1" style="left: 24px; top: 200px; position: absolute" value="#{msgsDecipline. attacheinterstFile }"/>
                                                            <ice:inputFile actionListener="#{Discipline$AccusedDefencePage.inputFile_ForComment_processAction}"
                                                                binding="#{Discipline$AccusedDefencePage.inputFile_ForComment}" height="35"
                                                                id="inputFile_ForComment" style="background-color: rgb(242, 246, 240); left: 166px; top: 82px; position: absolute"/>
                                                            <ice:inputFile
                                                                actionListener="#{Discipline$AccusedDefencePage.inputFile_IntersetAttache_processAction}"
                                                                binding="#{Discipline$AccusedDefencePage.inputFile_IntersetAttache}" height="38"
                                                                id="inputFile_IntersetAttache" style="background-color: rgb(242, 246, 240); left: 166px; top: 199px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 214px; margin-left: 15px; left: 20px; top: 332px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDisciplineDate" style="left: 48px; top: 24px; position: absolute" value="#{msgsDecipline.DisciplineDate}"/>
                                                            <ice:outputLabel id="lblReportedDate" style="left: 49px; top: 55px; position: absolute" value="#{msgsDecipline.ReportedDate}"/>
                                                            <ice:outputLabel id="lblDisciplineType" style="left: 408px; top: 24px; position: absolute" value="#{msgsDecipline.DisciplineType}"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtDisciplineDate}" disabled="true"
                                                                id="txtDisciplineDate" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtReportedDate}" disabled="true"
                                                                id="txtReportedDate" style="left: 167px; top: 55px; position: absolute"/>
                                                            <ice:outputLabel id="lblRepitition" rendered="false"
                                                                style="left: 407px; top: 51px; position: absolute" value="Repitition"/>
                                                            <ice:inputTextarea binding="#{Discipline$AccusedDefencePage.txtaDisciplineDescription}"
                                                                disabled="true" id="txtaDisciplineDescription" style="height: 42px; left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <!--ice:selectOneMenu id="drlDisciplineType" immediate="true" partialSubmit="true"
                                                                style="left: 526px; top: 22px; position: absolute; width: 143px" value="#{Discipline$AccusedDefencePage.selectedObjectOfDisciplineType.selectedObject}"-->
                                                            <!--f:selectItems id="selectOneMenu1selectItems" value="#{Discipline$AccusedDefencePage.disciplineTypesList}"/-->
                                                            <!--/ice:selectOneMenu-->
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtDisciplineName}" disabled="true"
                                                                id="txtDisciplineName" style="left: 526px; top: 22px; position: absolute; width: 143px"/>
                                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtDisciplinePreviousOccurance}"
                                                                disabled="true" id="txtDisciplinePreviousOccurance" rendered="false" style="left: 527px; top: 58px; position: absolute; width: 143px"/>
                                                            <ice:inputTextarea binding="#{Discipline$AccusedDefencePage.txtaDisciplineDecisionTobeTaken}"
                                                                disabled="true" id="txtaDisciplineDecisionTobeTaken" style="left: 167px; top: 155px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDesciplineDecisiontoBeTaken"
                                                                style="left: 49px; top: 152px; position: absolute" value="#{msgsDecipline.RequesterInterest}"/>
                                                            <ice:outputLabel id="lblDesciplineDescription" style="left: 49px; top: 89px; position: absolute" value="#{msgsDecipline.Description}"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$AccusedDefencePage.pnlEyeWitnessesRegistration}" clientOnly="true"
                            draggable="false" id="pnlEyeWitnessesRegistration" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 406px; left: 3px; top: 80px; position: absolute; width: 811px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessageEyeWitnesses" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 810px">
                                    <ice:outputText id="pnMessageTitleEyeWitnesses"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 600px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$AccusedDefencePage.btnClosePopupEyeWitnesses_action}" id="btnClosePopupEyeWitnesses"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 825px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupEyeWitnesses" style="display: block; height: 350px; position: relative; width: 771px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBodyEyeWitnesses" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 323px; position: relative; width: 696px; -rave-layout: grid" styleClass="message">
                                        <ice:panelLayout id="pnlLayoutWitness"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 150px; margin-left: 15px; left: 10px; top: 22px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                            <ice:outputLabel id="lblWitness" style="left: 10px; top: 4px; position: absolute" value="Witness"/>
                                            <ice:outputLabel id="lblWitnessDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                            <ice:outputLabel id="lblWitnessId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtWitnessDepartment}" disabled="true"
                                                id="txtWitnessDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtWitnessId}" id="txtWitnessId" immediate="true"
                                                partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                            <ice:outputLabel id="lblWitnessFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                            <ice:outputLabel id="lblWitnessPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                            <ice:selectInputText action="#{Discipline$AccusedDefencePage.txtWitnessFullName_action}"
                                                binding="#{Discipline$AccusedDefencePage.txtWitnessFullName}" id="txtWitnessFullName" immediate="true"
                                                listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                style="left: 166px; height: 30px; top: 22px; position: absolute"
                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                <f:facet name="selectInputText">
                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                        <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                        <ice:outputText id="lblWitnessIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                    </ice:panelGrid>
                                                </f:facet>
                                            </ice:selectInputText>
                                            <ice:inputText binding="#{Discipline$AccusedDefencePage.txtWitnessPosition}" disabled="true" id="txtWitnessPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                            <ice:commandButton action="#{Discipline$AccusedDefencePage.btnSearchWitness_action}" id="btnSearchWitness"
                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                            <ice:commandButton action="#{Discipline$AccusedDefencePage.btnAddWinessToTable_action}" id="btnAddWinessToTable"
                                                style="left: 576px; top: 110px; position: absolute; width: 95px" value="Add"/>
                                        </ice:panelLayout>
                                        <ice:panelLayout id="pnlLayoutWitnessDataTable"
                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 10px; top: 190px; position: absolute; width: 710px" styleClass="insideContainerMain">
                                            <ice:dataTable id="dataTableEyeWitnesses" style="left: 10px; top: 0px; height:8px; width: 685px; position: absolute"
                                                value="#{Discipline$AccusedDefencePage.eyeWitnessesList}" var="currentRow">
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
                                                    <ice:rowSelector id="rowSelectorDisciplinePenalty" multiple="false" preStyleOnSelection="true" selectionListener="#{Discipline$DisciplineRequestPage.rowSelectorDisciplinePenalty_processMyEvent}"/>
                                                </ice:column>
                                                <ice:column id="colEmpId">
                                                    <ice:outputText id="optTxtForColumnWitnessDepartment" value="#{currentRow['witnessDepartment']}"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextEmpId" value="Department"/>
                                                    </f:facet>
                                                </ice:column>
                                                <ice:column id="colRemoveEntry">
                                                    <ice:commandLink action="#{Discipline$AccusedDefencePage.cmdLnkRemoveEntry_action}" id="cmdLnkRemoveEntry" value="Remove"/>
                                                    <f:facet name="header">
                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                    </f:facet>
                                                </ice:column>
                                            </ice:dataTable>
                                        </ice:panelLayout>
                                        <ice:commandButton action="#{Discipline$AccusedDefencePage.btnSaveWitnesses_action}" id="btnSaveWitnesses"
                                            style="left: 288px; top: 302px; position: absolute; width: 72px" value="Save"/>
                                        <ice:commandButton action="#{Discipline$AccusedDefencePage.btnResetWitnesses_action}" id="btnResetWitnesses"
                                            style="left: 384px; top: 302px; position: absolute; width: 71px" value="Reset"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$AccusedDefencePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Discipline$AccusedDefencePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Discipline$AccusedDefencePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Discipline$AccusedDefencePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Discipline$AccusedDefencePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Discipline$AccusedDefencePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 1200px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="972">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Discipline$AccusedDefencePage.btnClosePopupViewPrevieousDecisions_action}"
                                        binding="#{Discipline$AccusedDefencePage.btnClosePopupViewPrevieousDecisions}" id="btnClosePopupViewPrevieousDecisions"
                                        style="left: 950px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 1195px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 1170px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Discipline$AccusedDefencePage.decisionsMadeOnRequest}" var="currentRow">
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
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
