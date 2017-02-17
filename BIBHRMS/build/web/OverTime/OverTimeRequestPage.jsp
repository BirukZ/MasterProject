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
                <title>Register Overtime Request</title>
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
                    function EyeWitnessesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <script type="text/javascript">

                    var _gaq = _gaq || [];
                    _gaq.push(['_setAccount', 'UA-24327002-1']);
                    _gaq.push(['_trackPageview']);

                    (function() {
                        var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
                        ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
                        var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
                    })();

                    function plusone_clicked() {
                        $('#thankyou').fadeIn(300);
                    }

                    $(document).ready(function() {
                        $('#floating_timepicker').timepicker({
                            onSelect: function(time, inst) {
                                $('#floating_selected_time').html('You selected ' + time);
                            }
                        });
                        $('#tabs').tabs();
                    });


                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$OverTimeRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$OverTimeRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$OverTimeRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$OverTimeRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$OverTimeRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:1000px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:980px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header" style="height: 43px">
                                                        <ice:outputText id="lblSearchArea" value="Login Person Information"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" style="height: 264px" width="100%">
                                                    <ice:panelLayout id="loginContainer" style="height: 115px; position: absolute; width: 204px">
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtDepartment}" id="txtDepartment" style="left: 25px; top: 49px; position: absolute"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtLoginId}" id="txtLoginId" style="height: 24px; left: 25px; top: -50px; position: absolute; width: 64px"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtFullName}" id="txtFullName" style="left: 25px; top: 2px; position: absolute"/>
                                                        <ice:outputLabel id="lblDepartment" style="left: 25px; top: 24px; position: absolute" value="Department:"/>
                                                        <ice:outputLabel id="lblFullName" style="left: 24px; top: -24px; position: absolute" value="Full Name:"/>
                                                        <ice:outputLabel id="lblLoginId" style="left: 24px; top: -74px; position: absolute" value="Login Person Id:"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtPosition}" id="txtPosition" style="left: 25px; top: 96px; position: absolute"/>
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
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeRequestPage.lnkOverTimeApprove_action}"
                                                                binding="#{OverTime$OverTimeRequestPage.lnkOverTimeApprove}" id="lnkOverTimeApprove"
                                                                style="color:#306682;font-weight:bold" value="Approve Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeRequestPage.lnkOverTimeAttendance_action}"
                                                                id="lnkOverTimeAttendance" style="color:#306682;font-weight:bold" value="Attendance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeRequestPage.lnkOverTimeReport_action}"
                                                                id="lnkOverTimeReport" style="color:#306682;font-weight:bold" value="Request Report"/>
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
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:210px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 213px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeRequestPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{OverTime$OverTimeRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{OverTime$OverTimeRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{OverTime$OverTimeRequestPage.pendingRequestList}"/>
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
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:210px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 210px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{OverTime$OverTimeRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{OverTime$OverTimeRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{OverTime$OverTimeRequestPage.requestHistoryList}"/>
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
                                                <ice:outputLabel value="Over TIme Request "/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 981px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlGrpPowerAllContent" style="height: 910px; left: 0px; top: 0px; width: 761px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutEmployees" rendered="true"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 437px; margin-left: 15px; left: 20px; top: 415px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{OverTime$OverTimeRequestPage.txtParticipantFullName_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.txtParticipantFullName}" id="txtParticipantFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 168px; top: 48px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="215">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblAttendants" style="color: #0066cc; left: 10px; top: 24px; position: absolute" value="#{msgOv.Participants}"/>
                                                        <ice:outputLabel id="lblParticipantDepartment" style="left: 72px; top: 92px; position: absolute" value="#{msgOv.Department}"/>
                                                        <ice:outputLabel id="lblParticipantId" style="left: 408px; top: 48px; position: absolute; width: 35px" value="#{msgOv.Id}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtParticipantDepartment}" disabled="true"
                                                            id="txtParticipantDepartment" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtParticipantId}" id="txtParticipantId"
                                                            immediate="true" partialSubmit="true" style="left: 502px; top: 46px; position: absolute; width: 143px"/>
                                                        <ice:outputLabel id="lblParticipantFullName" style="left: 72px; top: 48px; position: absolute" value="#{msgOv.FullName}"/>
                                                        <ice:outputLabel id="lblParticipantPosition" style="left: 72px; top: 134px; position: absolute" value="#{msgOv.Position}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtParticipantPosition}" disabled="true"
                                                            id="txtParticipantPosition" style="left: 166px; top: 132px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnSearchParticipant_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnSearchParticipant}" id="btnSearchParticipant"
                                                            image="/resources/images/fig_search.gif" style="left: 648px; top: 48px; position: absolute"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnAddToTable_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnAddToTable}" id="btnAddToTable"
                                                            style="left: 576px; top: 155px; position: absolute" value="#{msgOv.Add}"/>
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 213px; margin-left: 10px; left: 14px; top: 192px; overflow: auto; position: absolute; width: 670px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTable"
                                                                style=" overflow: auto; left: 20px; top: 0px; height:8px; width:615px; position: absolute"
                                                                value="#{OverTime$OverTimeRequestPage.requestModelList}" var="currentRow">
                                                                <ice:column id="colStatus" rendered="#{OverTime$OverTimeRequestPage.statusColumnRendered}">
                                                                    <ice:outputText id="optTxtForStatus" value="#{currentRow['databaseStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatus" value="Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colSelected" rendered="#{OverTime$OverTimeRequestPage.selectedColumnRendered}">
                                                                    <ice:selectBooleanCheckbox binding="#{OverTime$OverTimeRequestPage.ckbForColumnSelected}"
                                                                        disabled="true" id="ckbForColumnSelected" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextSelected" value="Selected"/>
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
                                                                    <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{OverTime$OverTimeRequestPage.rowSelectorOverTime_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colRemove" rendered="#{OverTime$OverTimeRequestPage.statusColumnRendered}">
                                                                    <ice:commandLink action="#{OverTime$OverTimeRequestPage.cmdLnkRemove_action}"
                                                                        binding="#{OverTime$OverTimeRequestPage.cmdLnkRemove}" id="cmdLnkRemove" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:commandLink action="#{OverTime$OverTimeRequestPage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.lnkViewPrevieousDecisions}" id="lnkViewPrevieousDecisions"
                                                            style="left: 480px; top: 408px; position: absolute" value="View status of  this request"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 54px; margin-left: 15px; left: 20px; top: 860px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnSave_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnSave}" id="btnSave"
                                                            style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{OverTime$OverTimeRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnReset_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnReset}" id="btnReset"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgOv.Reset}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequester"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 135px; margin-left: 15px; left: 20px; top: 25px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{OverTime$OverTimeRequestPage.txtRequesterFullName_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="color: #0066cc; left: 10px; top: 4px; position: absolute" value="#{msgOv.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgOv.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 472px; top: 24px; position: absolute" value="#{msgOv.Id}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtRequesterId}" id="txtRequesterId"
                                                            immediate="true" partialSubmit="true" style="left: 502px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgOv.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgOv.Position}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestAttributesCommon"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 131px; margin-left: 15px; left: 20px; top: 175px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDocReferenceNumber" style="left: 440px; top: 94px; position: absolute" value="#{msgOv.DocRefNum}"/>
                                                        <ice:outputLabel id="lblReasonDescription" style="left: 48px; top: 48px; position: absolute" value="#{msgOv.ReasonDesc}"/>
                                                        <ice:inputTextarea binding="#{OverTime$OverTimeRequestPage.txtaReasonDescription}"
                                                            id="txtaReasonDescription" style="height: 40px; left: 167px; top: 49px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="left: 48px; top: 93px; position: absolute" value="#{msgOv.AppliedDate}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtAppliedDate}" disabled="true"
                                                            id="txtAppliedDate" style="left: 168px; top: 101px; position: absolute"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnCalAppliedDate_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnCalAppliedDate}" id="btnCalAppliedDate"
                                                            image="/resources/images/cal_icon.JPG" immediate="true"
                                                            style="left: 314px; top: 99px; position: absolute" value="submit"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtDocReferenceNumber}"
                                                            id="txtDocReferenceNumber" style="left: 527px; top: 99px; position: absolute"/>
                                                        <ice:outputLabel id="lblAddressCode" style="left: 48px; top: 10px; position: absolute" value="#{msgOv.AddressCode}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$OverTimeRequestPage.drlAddressCode}" id="drlAddressCode"
                                                            partialSubmit="true" style="left: 166px; top: 11px; position: absolute; width: 171px" value="#{OverTime$OverTimeRequestPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$OverTimeRequestPage.addressCodeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblReasonSummary" style="left: 408px; top: 11px; position: absolute" value="#{msgOv.ReasonSummary}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$OverTimeRequestPage.drlReasonSummary}" id="drlReasonSummary"
                                                            partialSubmit="true" style="left: 526px; top: 11px; position: absolute; width: 143px" value="#{OverTime$OverTimeRequestPage.selectObjectOfReasonSummary.selectedObject}">
                                                            <f:selectItems id="selectOneMenuReasonSummary" value="#{OverTime$OverTimeRequestPage.reasonSummaryList}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequest"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 78px; margin-left: 15px; left: 20px; top: 318px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtStartDate}" disabled="true" id="txtStartDate" style="left: 166px; top: 13px; position: absolute"/>
                                                        <ice:outputLabel id="lblStartDate" style="left: 48px; top: 24px; position: absolute" value="#{msgOv.StartDate}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtEndDate}" disabled="true" id="txtEndDate" style="left: 527px; top: 13px; position: absolute"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnCalStartDate_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnCalStartDate}" id="btnCalStartDate"
                                                            image="/resources/images/cal_icon.JPG" immediate="true"
                                                            style="left: 313px; top: 14px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnCalEndDate_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnCalEndDate}" id="btnCalEndDate"
                                                            image="/resources/images/cal_icon.JPG" immediate="true"
                                                            style="left: 649px; top: 14px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnStartTime_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnStartTime}" id="btnStartTime"
                                                            image="/resources/images/clock.png" immediate="true"
                                                            style="left: 241px; top: 47px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{OverTime$OverTimeRequestPage.btnEndTime_action}"
                                                            binding="#{OverTime$OverTimeRequestPage.btnEndTime}" id="btnEndTime"
                                                            image="/resources/images/clock.png" immediate="true"
                                                            style="left: 601px; top: 42px; position: absolute" value="submit"/>
                                                        <ice:outputLabel id="lblEndDate" style="left: 408px; top: 24px; position: absolute" value="#{msgOv.EndDate}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtStartTime}" disabled="true" id="txtStartTime" style="left: 166px; top: 46px; position: absolute; width: 71px"/>
                                                        <ice:outputLabel id="lblTakenStartDate" style="left: 48px; top: 48px; position: absolute" value="#{msgOv.StartTime}"/>
                                                        <ice:inputText binding="#{OverTime$OverTimeRequestPage.txtEndTime}" disabled="true" id="txtEndTime" style="left: 526px; top: 43px; position: absolute; width: 71px"/>
                                                        <ice:outputLabel id="lblTakenEndDate" style="left: 408px; top: 48px; position: absolute" value="#{msgOv.EndTime}"/>
                                                        <ice:outputLabel id="lblOverTimeFactor" rendered="false"
                                                            style="left: 72px; top: 48px; position: absolute" value="Rate"/>
                                                        <ice:selectOneMenu binding="#{OverTime$OverTimeRequestPage.drlOverTimeFactor}" id="drlOverTimeFactor"
                                                            partialSubmit="true" rendered="false"
                                                            style="left: 166px; top: 46px; position: absolute; width: 143px" value="#{OverTime$OverTimeRequestPage.selectOneMenu2Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{OverTime$OverTimeRequestPage.overTimeFactorList}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{OverTime$OverTimeRequestPage.pnlLayoutTimePanel}" id="pnlLayoutTimePanel"
                                                        rendered="false"
                                                        style="border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableTime" rows="12"
                                                            style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                                            value="#{OverTime$OverTimeRequestPage.tableHour}" var="currentRow">
                                                            <ice:column id="colStartDate12">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForColumn00" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col00']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartDate02">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForColumn02" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col10']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime04">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForolumn04" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col20']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime06">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForColumn06" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col30']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime08">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForColumn08" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col40']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime10">
                                                                <ice:commandLink actionListener="#{OverTime$OverTimeRequestPage.lnkShowTime_processAction}"
                                                                    id="optTxtForColumn10" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col50']}"/>
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
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 120px; top: 100px; position: absolute; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDateBean1.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calAppliedDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calStartDate}" id="calStartDate"
                                                        rendered="false" style="height: 212px; left: 120px; top: 150px; position: absolute; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calStartDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calEndDate}" id="calEndDate" rendered="false"
                                                        style="left: 424px; top: 150px; position: absolute; height:212px; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDate2Bean.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calEndDate_processValueChange}"/>
                                                </ice:panelGroup>
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
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;visibility: visible;"
                            styleClass="message" visible="true">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$OverTimeRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$OverTimeRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$OverTimeRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$OverTimeRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeRequestPage.pnlPopupSuccessOrFailure1}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure1" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 43px; top: 400px; position: absolute; width: 751px;visibility: visible;" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage1" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle1"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$OverTimeRequestPage.btnClosePopupSuccessOrFailure1_action}"
                                        id="btnClosePopupSuccessOrFailure1" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage1" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody1" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$OverTimeRequestPage.lblSuccessOrErrorMessage1}" id="lblSuccessOrErrorMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{OverTime$OverTimeRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{OverTime$OverTimeRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
