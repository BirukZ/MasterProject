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
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Overtime Report</title>
                <link HREF="../header_icon.ico" REL="icon"/>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    <div>y
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$OverTimeReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$OverTimeReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$OverTimeReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$OverTimeReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$OverTimeReportPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:1000px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:980px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value=" "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="pnlGrpSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
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
                                                            <ice:commandLink action="#{OverTime$OverTimeReportPage.lnkOverTimeApprove_action}"
                                                                id="lnkOverTimeApprove" style="color:#306682;font-weight:bold" value="Over Time Approve"/>
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
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 309px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeReportPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 312px; width: 190px" value="#{OverTime$OverTimeReportPage.selectedRequestFromMyRequestList.selectedObject}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{OverTime$OverTimeReportPage.pendingRequestList}"/>
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
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 309px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeReportPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 312px; width: 190px" value="#{OverTime$OverTimeReportPage.selectedRequestFromHistoryList.selectedObject}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{OverTime$OverTimeReportPage.requestHistoryList}"/>
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
                                <ice:panelGroup id="page_display" style="height:1000px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height:995px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 970px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Over TIme Request Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 961px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout id="pnProfile" style="height: 961px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                    <ice:panelGroup id="pnlGrpPowerDeligationContent" style="height: 892px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutEmployees" rendered="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 415px; margin-left: 15px; left: 20px; top: 415px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbAnyParticipant}"
                                                                id="ckbAnyParticipant" partialSubmit="true" style="left: 150px; top: 5px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData2.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbAnyParticipant_processValueChange}"/>
                                                            <ice:selectInputText action="#{OverTime$OverTimeReportPage.txtParticipantFullName_action}"
                                                                binding="#{OverTime$OverTimeReportPage.txtParticipantFullName}" id="txtParticipantFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="left: 166px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblAttendants" style="left: 10px; top: 4px; position: absolute; width: 107px" value="Participants"/>
                                                            <ice:outputLabel id="lblAnyAttendant"
                                                                style="left: 200px; top: 4px; position: absolute; width: 107px" value="Any"/>
                                                            <ice:outputLabel id="lblParticipantDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblParticipantId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtParticipantDepartment}" disabled="true"
                                                                id="txtParticipantDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtParticipantId}" id="txtParticipantId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 143px"/>
                                                            <ice:outputLabel id="lblParticipantFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblParticipantPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtParticipantPosition}" disabled="true"
                                                                id="txtParticipantPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnSearchParticipant_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnSearchParticipant}" id="btnSearchParticipant"
                                                                image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnGenerateReport_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnGenerateReport}" id="btnGenerateReport"
                                                                style="left: 576px; top: 134px; position: absolute" value="Generate report"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnReset_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnReset}" id="btnReset"
                                                                style="left: 432px; top: 134px; position: absolute; width: 124px" value="Reset"/>
                                                            <ice:panelLayout id="pnlLayoutTable"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 213px; margin-left: 10px; left: 9px; top: 168px; overflow: auto; position: absolute; width: 670px" styleClass="insideContainerMain">
                                                                <ice:dataTable id="dataTable"
                                                                    style=" overflow: auto; left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                    value="#{OverTime$OverTimeReportPage.requestModelList}" var="currentRow">
                                                                    <ice:column id="colStatus">
                                                                        <ice:outputText id="optTxtForStatus" value="#{currentRow['databaseStatus']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headertextStatus" value="Status"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEmployeeId">
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
                                                                    <ice:column id="colRepitition">
                                                                        <ice:outputText id="optTxtForColumnDepartmentName" value="#{currentRow['departmentName']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextDepartmentName" value="Department"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colStartDate">
                                                                        <ice:outputText id="optTxtForColumnStartDate" value="#{currentRow['startDate']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextStartDate" value="Start Date"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEndDate">
                                                                        <ice:outputText id="optTxtForEndDate" value="#{currentRow['endDate']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEndDate" value="End Date"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colStartTime">
                                                                        <ice:outputText id="optTxtForStartTime" value="#{currentRow['startTime']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextStartTime" value="Start Time"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEndTime">
                                                                        <ice:outputText id="optTxtForEndTIme" value="#{currentRow['endTime']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEndTime" value="End Time"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colOverTimeFactor">
                                                                        <ice:outputText id="optTxtForOverTimeFactor" value="#{currentRow['overTimeFactor']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextOverTimeFactor" value="Rate"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 131px; margin-left: 15px; left: 20px; top: 25px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAnyRequester"
                                                                style="left: 150px; top: 4px; position: absolute; width: 107px" value="Any"/>
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbAnyRequester}"
                                                                id="ckbAnyRequester" partialSubmit="true" style="left: 94px; top: 5px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbAnyRequester_processValueChange}"/>
                                                            <ice:selectInputText action="#{OverTime$OverTimeReportPage.txtRequesterFullName_action}"
                                                                binding="#{OverTime$OverTimeReportPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="left: 166px; top: 22px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="Requester"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtRequesterId}" id="txtRequesterId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 149px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnSearchRequester_action}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 620px; top: 24px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequestStatus"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 50px; margin-left: 15px; left: 20px; top: 170px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbStatusAny}" id="ckbStatusAny"
                                                                partialSubmit="true" style="left: 50px; top: 10px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData4.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbStatusAny_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbStatusApproved}"
                                                                id="ckbStatusApproved" immediate="true" partialSubmit="true"
                                                                style="left: 200px; top: 10px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData5.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbStatusApproved_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbStatusOnProgress}"
                                                                id="ckbStatusOnProgress" immediate="true" partialSubmit="true"
                                                                style="left: 350px; top: 10px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData6.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbStatusOnProgress_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbStatusRejected}"
                                                                id="ckbStatusRejected" immediate="true" partialSubmit="true"
                                                                style="left: 500px; top: 10px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData7.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbStatusRejected_processValueChange}"/>
                                                            <ice:outputLabel id="lblRequestStatus" style="left: 5px; top: 5px; position: absolute" value="Status"/>
                                                            <ice:outputLabel id="lblStatusAny" style="left: 75px; top: 10px; position: absolute" value="Any"/>
                                                            <ice:outputLabel id="lblStatusApproved" style="left: 225px; top: 10px; position: absolute" value="Arpproved"/>
                                                            <ice:outputLabel id="lblStatusOnProgress" style="left: 375px; top: 10px; position: absolute" value="On progress"/>
                                                            <ice:outputLabel id="lblStatusRejected" style="left: 525px; top: 10px; position: absolute" value="Rejected"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequest"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 150px; margin-left: 15px; left: 20px; top: 250px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblAnyRequestParameter" style="left: 100px; top: 15px; position: absolute" value="Any Parameter"/>
                                                            <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeReportPage.ckbAnyRequestParameter}"
                                                                id="ckbAnyRequestParameter" immediate="true" partialSubmit="true"
                                                                style="left: 72px; top: 20px; position: absolute"
                                                                value="#{OverTime$OverTimeReportPage.defaultSelectedData3.selectedBoolean}" valueChangeListener="#{OverTime$OverTimeReportPage.ckbAnyRequestParameter_processValueChange}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:outputLabel id="lblStartDate" style="left: 72px; top: 48px; position: absolute" value="StartDate"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtEndDate}" disabled="true" id="txtEndDate" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnCalStartDate_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnCalStartDate}" id="btnCalStartDate"
                                                                image="/resources/images/cal_icon.JPG" immediate="true"
                                                                style="left: 288px; top: 48px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnCalEndDate_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnCalEndDate}" id="btnCalEndDate"
                                                                image="/resources/images/cal_icon.JPG" immediate="true"
                                                                style="left: 648px; top: 48px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnStartTime_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnStartTime}" id="btnStartTime"
                                                                image="/resources/images/clock.png" immediate="true"
                                                                style="left: 240px; top: 72px; position: absolute" value="submit"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeReportPage.btnEndTime_action}"
                                                                binding="#{OverTime$OverTimeReportPage.btnEndTime}" id="btnEndTime"
                                                                image="/resources/images/clock.png" immediate="true"
                                                                style="left: 600px; top: 72px; position: absolute" value="submit"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 408px; top: 48px; position: absolute" value="EndDate"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtStartTime}" disabled="true"
                                                                id="txtStartTime" style="left: 166px; top: 70px; position: absolute; width: 71px"/>
                                                            <ice:outputLabel id="lblTakenStartDate" style="left: 72px; top: 72px; position: absolute" value="StartTime"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeReportPage.txtEndTime}" disabled="true" id="txtEndTime" style="left: 526px; top: 70px; position: absolute; width: 71px"/>
                                                            <ice:outputLabel id="lblTakenEndDate"
                                                                style="height: 19px; left: 408px; top: 72px; position: absolute; width: 45px" value="EndTime"/>
                                                            <ice:outputLabel id="lblAddressCode" style="left: 408px; top: 96px; position: absolute" value="Address Code"/>
                                                            <ice:selectOneMenu binding="#{OverTime$OverTimeReportPage.drlAddressCode}" id="drlAddressCode"
                                                                partialSubmit="true" style="left: 526px; top: 94px; position: absolute; width: 143px"
                                                                value="#{OverTime$OverTimeReportPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{OverTime$OverTimeReportPage.drlAddressCode_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$OverTimeReportPage.addressCodeList}"/>
                                                            </ice:selectOneMenu>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout binding="#{OverTime$OverTimeReportPage.pnlLayoutTimePanel}" id="pnlLayoutTimePanel"
                                                            rendered="false"
                                                            style="border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTableTime" rows="12"
                                                                style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                                                value="#{OverTime$OverTimeReportPage.tableHour}" var="currentRow">
                                                                <ice:column id="colStartDate12">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForColumn00" onmouseover="hilite('optTxtForColumn00')" value="#{currentRow['col00']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartDate02">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForColumn02" value="#{currentRow['col10']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartTime04">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForolumn04" value="#{currentRow['col20']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartTime06">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForColumn06" value="#{currentRow['col30']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartTime08">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForColumn08" value="#{currentRow['col40']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartTime10">
                                                                    <ice:commandLink actionListener="#{OverTime$OverTimeReportPage.lnkShowTime_processAction}"
                                                                        id="optTxtForColumn10" value="#{currentRow['col50']}"/>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <ice:dataPaginator for="dataTableTime" style="layout:absolute; border: 1px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 2px; position: absolute; width:270px">
                                                                <f:facet name="first">
                                                                    <ice:outputText value=" From 00:00 to 11:55  "/>
                                                                </f:facet>
                                                                <f:facet name="last">
                                                                    <ice:outputText value="  From 12:00 to 23:55"/>
                                                                </f:facet>
                                                            </ice:dataPaginator>
                                                        </ice:panelLayout>
                                                        <ice:selectInputDate binding="#{OverTime$OverTimeReportPage.calStartDate}" id="calStartDate"
                                                            rendered="false" style="height: 212px; left: 120px; top: 150px; position: absolute; width: 190px"
                                                            value="#{OverTime$OverTimeReportPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$OverTimeReportPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{OverTime$OverTimeReportPage.calEndDate}" id="calEndDate"
                                                            rendered="false" style="left: 424px; top: 150px; position: absolute; height:212px; width: 190px"
                                                            value="#{OverTime$OverTimeReportPage.selectInputDate2Bean.date1}" valueChangeListener="#{OverTime$OverTimeReportPage.calEndDate_processValueChange}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeReportPage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$OverTimeReportPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$OverTimeReportPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$OverTimeReportPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$OverTimeReportPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
