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
        <f:loadBundle basename="Localization.HRLocaalization_OverTime" var="msgOv"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Process Overtime Request</title>
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
                    function OverTimeAttendanceApprovePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="height: 984px">
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$OverTimeApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$OverTimeApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$OverTimeApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$OverTimeApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$OverTimeApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:880px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header" style="height: 43px">
                                                        <ice:outputText id="lblSearchArea" value="Login Person Information"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" style="height: 264px" width="100%">
                                                    <ice:panelLayout id="loginContainer" style="height: 115px; position: absolute; width: 204px">
                                                        <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtDepartment}" id="txtDepartment" style="left: 25px; top: 49px; position: absolute"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtLoginId}" id="txtLoginId" style="height: 24px; left: 25px; top: -50px; position: absolute; width: 64px"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtFullName}" id="txtFullName" style="left: 25px; top: 2px; position: absolute"/>
                                                        <ice:outputLabel id="lblDepartment" style="left: 25px; top: 24px; position: absolute" value="Department:"/>
                                                        <ice:outputLabel id="lblFullName" style="left: 24px; top: -24px; position: absolute" value="Full Name:"/>
                                                        <ice:outputLabel id="lblLoginId" style="left: 24px; top: -74px; position: absolute" value="Login Person Id:"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtPosition}" id="txtPosition" style="left: 25px; top: 96px; position: absolute"/>
                                                        <ice:outputLabel id="lblPosition" style="left: 25px; top: 70px; position: absolute" value="Position:"/>
                                                    </ice:panelLayout>
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
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 104%;">
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeApprovePage.lnkRequestPage_action}" id="lnkRequestPage"
                                                                style="color:#306682;font-weight:bold" value="Request Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeApprovePage.lnkOverTimeAttendancePage_action}"
                                                                id="lnkOverTimeAttendancePage" style="color:#306682;font-weight:bold" value="Overtime Attendance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeApprovePage.lnkOverTimeReport_action}"
                                                                id="lnkOverTimeReport" style="color:#306682;font-weight:bold" value="Approve Report"/>
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
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:170px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 179px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeApprovePage.selectRequestApprovableRequestLists}"
                                                                id="selectRequestApprovableRequestLists" partialSubmit="true" size="6"
                                                                style="height: 172px; width: 190px"
                                                                value="#{OverTime$OverTimeApprovePage.selectedRequestFromApprovableList.selectedObject}" valueChangeListener="#{OverTime$OverTimeApprovePage.selectRequestApprovableRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{OverTime$OverTimeApprovePage.requestListsToBeApproved}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border-style: none; height: 183px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:170px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 165px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeApprovePage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 165px; width: 190px"
                                                                value="#{OverTime$OverTimeApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{OverTime$OverTimeApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{OverTime$OverTimeApprovePage.requestHistoryList}"/>
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
                                <ice:panelGroup id="page_display">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 900px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 870px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Approve Overtime Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 840px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{OverTime$OverTimeApprovePage.pnProfile}" id="pnProfile" style="height: 845px; position: absolute; width: 100%">
                                                    <ice:panelGroup binding="#{OverTime$OverTimeApprovePage.pnlGrpPowerDeligationContent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 790px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 222px; margin-left: 15px; left: 20px; top: 294px; position: absolute; width: 707px; overflow: auto" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTable"
                                                                style="left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                value="#{OverTime$OverTimeApprovePage.requestModelList}" var="currentRow">
                                                                <ice:column groupOn="#{currentRow['employeeId']}" id="colEmployeeId">
                                                                    <ice:outputText id="optTxtForEmployeeid" value="#{currentRow['employeeId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextEmployeeId" value="Emp Id"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colDisciplimeName">
                                                                    <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['employeeFullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStartDate">
                                                                    <ice:outputText id="optTxtForColumnStartDate" value="#{currentRow['startDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartDate" value="Start Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStartTime">
                                                                    <ice:outputText id="optTxtForStartTime" value="#{currentRow['startTime']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartTime" value="Start Time"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndDate">
                                                                    <ice:outputText id="optTxtForEndDate" value="#{currentRow['endDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndDate" value="End Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndTime">
                                                                    <ice:outputText id="optTxtForEndTIme" value="#{currentRow['endTime']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndTime" value="End Time"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colOverTimeFactor" rendered="false">
                                                                    <ice:outputText id="optTxtForOverTimeFactor" value="#{currentRow['overTimeFactor']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextOverTimeFactor" value="Rate "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSelected">
                                                                    <ice:selectBooleanCheckbox id="ckbSelected" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextSelected" value="Select"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 174px; margin-left: 15px; left: 20px; top: 534px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDeciderDepartment" style="left: 24px; top: 24px; position: absolute" value="#{msgOv.DeciderDepartment}"/>
                                                            <ice:outputLabel id="lblDeciderId" style="left: 24px; top: 48px; position: absolute" value="#{msgOv.DeciderId}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtDeciderDepartment}" disabled="true"
                                                                id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtDeciderId}" disabled="true"
                                                                id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="#{msgOv.DeciderFullName}"/>
                                                            <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="#{msgOv.DeciderPosition}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtDeciderFullName}" disabled="true"
                                                                id="txtDeciderFullName" style="left: 550px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtDeciderPosition}" disabled="true"
                                                                id="txtDeciderPosition" style="left: 550px; top: 46px; position: absolute"/>
                                                            <ice:selectOneMenu binding="#{OverTime$OverTimeApprovePage.drlDecision}" id="drlDecision"
                                                                partialSubmit="true"
                                                                style="height: 23px; left: 167px; top: 89px; position: absolute; width: 143px" value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                                <f:selectItems id="selectDecisionAvailable" value="#{OverTime$OverTimeApprovePage.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblDecision" style="left: 24px; top: 96px; position: absolute" value="#{msgOv.Decision}"/>
                                                            <ice:inputTextarea binding="#{OverTime$OverTimeApprovePage.txtaDeciderComment}"
                                                                id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                            <ice:outputLabel id="lblDeciderComment" style="left: 24px; top: 120px; position: absolute" value="#{msgOv.Comment}"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnSearchDecider_action}"
                                                                binding="#{OverTime$OverTimeApprovePage.btnSearchDecider}" id="btnSearchDecider"
                                                                style="left: 319px; top: 38px; position: absolute" value="Change"/>
                                                            <ice:commandLink action="#{OverTime$OverTimeApprovePage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{OverTime$OverTimeApprovePage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions" style=" left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 726px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnPostDecision_action}"
                                                                binding="#{OverTime$OverTimeApprovePage.btnPostDecision}" id="btnPostDecision"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{msgOv.Save}"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeApprovePage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgOv.Reset}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequesterAndRequest"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 251px; margin-left: 15px; left: 20px; top: 25px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRequester" style="left: 8px; top: 4px; position: absolute" value="#{msgOv.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 48px; position: absolute" value="#{msgOv.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgOv.Id}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 121px; top: 56px; position: absolute; width: 548px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" style="left: 476px; top: 27px; position: absolute; width: 195px"/>
                                                            <ice:outputLabel id="lblRequesterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgOv.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 72px; position: absolute" value="#{msgOv.Position}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 123px; top: 29px; position: absolute; width: 263px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 120px; top: 84px; position: absolute; width: 549px"/>
                                                            <ice:inputTextarea binding="#{OverTime$OverTimeApprovePage.txtaReason}" disabled="true"
                                                                id="txtaReason" style="left: 118px; top: 158px; position: absolute; width: 552px"/>
                                                            <ice:outputLabel id="lblReason" style="left: 24px; top: 168px; position: absolute" value="#{msgOv.ReasonDesc}"/>
                                                            <ice:outputLabel id="lblAddressCode"
                                                                style="height: 43px; left: 24px; top: 120px; position: absolute; width: 93px" value="#{msgOv.AddressCode}"/>
                                                            <ice:selectOneMenu binding="#{OverTime$OverTimeApprovePage.drlAddressCode}" disabled="true"
                                                                id="drlAddressCode" partialSubmit="true"
                                                                style="left: 121px; top: 124px; position: absolute; width: 166px" value="#{OverTime$OverTimeApprovePage.selectedObjectAddressCode.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$OverTimeApprovePage.addressCodeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 24px; top: 218px; position: absolute" value="#{msgOv.AppliedDate}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 118px; top: 218px; position: absolute; width: 191px"/>
                                                            <ice:outputLabel id="lblDocReferenceNumber" style="left: 400px; top: 218px; position: absolute" value="#{msgOv.DocRefNum}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeApprovePage.txtReferenceNumber}" disabled="true"
                                                                id="txtReferenceNumber" style="left: 502px; top: 218px; position: absolute; width: 119px"/>
                                                            <ice:outputLabel id="lblReasonSummary" style="left: 376px; top: 120px; position: absolute" value="#{msgOv.ReasonSummary}"/>
                                                            <ice:selectOneMenu binding="#{OverTime$OverTimeApprovePage.drlReasonSummary}" disabled="true"
                                                                id="drlReasonSummary" partialSubmit="true"
                                                                style="left: 504px; top: 124px; position: absolute; width: 170px" value="#{OverTime$OverTimeApprovePage.selectObjectOfReasonSummary.selectedObject}">
                                                                <f:selectItems id="selectOneMenuReasonSummary" value="#{OverTime$OverTimeApprovePage.reasonSummaryList}"/>
                                                            </ice:selectOneMenu>
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
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$OverTimeApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$OverTimeApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$OverTimeApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{OverTime$OverTimeApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{OverTime$OverTimeApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
