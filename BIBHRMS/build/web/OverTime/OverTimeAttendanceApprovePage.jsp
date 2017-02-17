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
                <title>Over Time Attendance Approve</title>
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
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{OverTime$OverTimeAttendanceApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{OverTime$OverTimeAttendanceApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{OverTime$OverTimeAttendanceApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{OverTime$OverTimeAttendanceApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{OverTime$OverTimeAttendanceApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 909px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:900px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 100px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerDateLists" style="height: 100px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectRequestAttendanceToBetakenDaysLis" partialSubmit="true" size="6"
                                                                style="height: 95px; width: 190px"
                                                                value="#{OverTime$OverTimeAttendanceApprovePage.selectedObjectAttendanceToBetakenDaysList.selectedObject}" valueChangeListener="#{OverTime$OverTimeAttendanceApprovePage.selectRequestAttendanceToBetakenDaysLis_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestAttendanceToBetakenDaysLis" value="#{OverTime$OverTimeAttendanceApprovePage.attendanceToBetakenDaysList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
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
                                                            <ice:commandLink action="#{OverTime$OverTimeAttendanceApprovePage.lblOverTimeReuestPage_action}"
                                                                id="lblOverTimeReuestPage" style="color:#306682;font-weight:bold" value="Reuest Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{OverTime$OverTimeAttendanceApprovePage.lnkOverTimeApprovePage_action}"
                                                                id="lnkOverTimeApprovePage" style="color:#306682;font-weight:bold" value="Approve Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblToTakeAttendance" value="Take Attendance"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 187px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{OverTime$OverTimeAttendanceApprovePage.selectRequestApprovedLists}"
                                                                id="selectRequestApprovedLists" partialSubmit="true" size="6"
                                                                style="height: 264px; width: 190px"
                                                                value="#{OverTime$OverTimeAttendanceApprovePage.selectedRequestFromApprovedList.selectedObject}" valueChangeListener="#{OverTime$OverTimeAttendanceApprovePage.selectRequestApprovedLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{OverTime$OverTimeAttendanceApprovePage.takenAttendancesList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" rendered="false" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistory" value="All History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardhistory" width="100%">
                                                    <ice:panelGroup id="history_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="historyContainer" style="height: 285px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectAttendanceHistoryLists" partialSubmit="true" size="6"
                                                                style="height: 264px; width: 190px"
                                                                value="#{OverTime$OverTimeAttendanceApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{OverTime$OverTimeAttendanceApprovePage.selectAttendanceHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxTakenAttendances" value="#{OverTime$OverTimeAttendanceApprovePage.approvedRequestsToTakeAttendance}"/>
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
                                        style="height: 990px; left: 0px; top: 20px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 960px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Overtime Attendance"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height:940px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{OverTime$OverTimeAttendanceApprovePage.pnProfile}" id="pnProfile" style="height: 890px; width: 100%">
                                                    <ice:panelGroup binding="#{OverTime$OverTimeAttendanceApprovePage.pnlGrpPowerDeligationContent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 885px; top: 20px; position: relative" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutRequesterAndRequest"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 255px; margin-left: 15px; left: 20px; top: 25px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRequester" style="left: 8px; top: 4px; position: absolute" value="#{msgOv.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 24px; top: 24px; position: absolute" value="#{msgOv.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 24px; top: 72px; position: absolute" value="#{msgOv.Id}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 118px; top: 22px; position: absolute; width: 195px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" style="left: 118px; top: 70px; position: absolute; width: 195px"/>
                                                            <ice:outputLabel id="lblRequesterFullName" style="left: 360px; top: 24px; position: absolute" value="#{msgOv.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 360px; top: 72px; position: absolute" value="#{msgOv.Position}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRequesterFullName}"
                                                                disabled="true" id="txtRequesterFullName" style="left: 454px; top: 22px; position: absolute; width: 219px"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRequesterPosition}"
                                                                disabled="true" id="txtRequesterPosition" style="left: 454px; top: 70px; position: absolute; width: 219px"/>
                                                            <ice:inputTextarea binding="#{OverTime$OverTimeAttendanceApprovePage.txtaReason}" disabled="true"
                                                                id="txtaReason" style="left: 116px; top: 110px; position: absolute; width: 552px"/>
                                                            <ice:outputLabel id="lblReason"
                                                                style="height: 41px; left: 24px; top: 120px; position: absolute; width: 69px" value="#{msgOv.ReasonDesc}"/>
                                                            <ice:outputLabel id="lblAddressCode" style="left: 24px; top: 216px; position: absolute" value="#{msgOv.AddressCode}"/>
                                                            <ice:selectOneMenu binding="#{OverTime$OverTimeAttendanceApprovePage.drlAddressCode}"
                                                                disabled="true" id="drlAddressCode" partialSubmit="true"
                                                                style="left: 120px; top: 216px; position: absolute; width: 191px" value="#{OverTime$OverTimeRequestPage.selectOneMenu1Bean.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$OverTimeRequestPage.addressCodeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 24px; top: 168px; position: absolute" value="#{msgOv.AppliedDate}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 118px; top: 166px; position: absolute; width: 191px"/>
                                                            <ice:outputLabel id="lblDocReferenceNumber" style="left: 384px; top: 168px; position: absolute" value="#{msgOv.DocRefNum}"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtReferenceNumber}"
                                                                disabled="true" id="txtReferenceNumber" style="left: 478px; top: 166px; position: absolute; width: 195px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRecorder" rendered="false"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 102px; margin-left: 15px; left: 20px; top: 702px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRecorder" style="left: 0px; top: 0px; position: absolute" value="You Are Loggged In As"/>
                                                            <ice:outputLabel id="lblRecorderDepartment" style="left: 48px; top: 24px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblRecorderId" style="left: 48px; top: 48px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRecorderDepartment}"
                                                                disabled="true" id="txtRecorderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRecorderId}" disabled="true"
                                                                id="txtRecorderId" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:outputLabel id="lblRecorderFullName" style="left: 408px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRecorderPosition" style="left: 408px; top: 48px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRecorderFullName}"
                                                                disabled="true" id="txtRecorderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{OverTime$OverTimeAttendanceApprovePage.txtRecorderPosition}"
                                                                disabled="true" id="txtRecorderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 476px; margin-left: 15px; left: 20px; top: 320px; overflow: auto; position: absolute; width: 697px" styleClass="insideContainerMain">
                                                            <ice:dataTable id="dataTable"
                                                                style="left: 20px; top: 0px; height:8px; width:655px; position: absolute"
                                                                value="#{OverTime$OverTimeAttendanceApprovePage.overTimeAttendanceEmployeeLists}" var="currentRow">
                                                                <ice:column groupOn="#{currentRow['employeeId']}" id="colEmployeeId">
                                                                    <ice:outputText id="optTxtForEmployeeid" value="#{currentRow['employeeId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextEmployeeId" value="Emp Id"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column groupOn="#{currentRow['employeeFullName']}" id="colDisciplimeName">
                                                                    <ice:outputText id="optTxtForColumnFullName" value="#{currentRow['employeeFullName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="Full Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colAttendanceDate">
                                                                    <ice:outputText id="optTxtForColumnAttendanceDate" value="#{currentRow['attendanceDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextAttendanceDate" value=" Date "/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStartTime">
                                                                    <ice:inputText disabled="true" id="optTxtForStartTime" style="width:80px" value="#{currentRow['startTime']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStartTime" value="Start Time"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndTime">
                                                                    <ice:inputText disabled="true" id="optTxtForEndTime" style="width:80px" value="#{currentRow['endTime']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndTime" value="End Time"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colOverTimeFactor" rendered="false">
                                                                    <ice:outputText id="optTxtForOverTimeFactor" value="#{currentRow['displayedOverTimeFactor']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextOverTimeFactor" value="Factor"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{OverTime$OverTimeAttendanceApprovePage.rowSelectorOverTime_processMyEvent}"/>
                                                                </ice:column>
                                                                <ice:column id="colAttendedEmployeeCheck">
                                                                    <ice:selectBooleanCheckbox id="ckbAttendedEmployeeCheck" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextAttendedEmployeeCheck" value="Attended"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEdit" rendered="#{OverTime$OverTimeAttendanceApprovePage.statusColumnRendered}">
                                                                    <ice:commandLink action="#{OverTime$OverTimeAttendanceApprovePage.cmdLnkEdit_action}"
                                                                        binding="#{OverTime$OverTimeAttendanceApprovePage.cmdLnkRemove}" id="cmdLnkEdit" value="Ok"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextRemove" value="Edit"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 822px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{OverTime$OverTimeAttendanceApprovePage.btnSaveAttendance_action}"
                                                                binding="#{OverTime$OverTimeAttendanceApprovePage.btnSaveAttendance}" id="btnSaveAttendance"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{OverTime$OverTimeAttendanceApprovePage.saveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{OverTime$OverTimeAttendanceApprovePage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgOv.Reset}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$OverTimeAttendanceApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$OverTimeAttendanceApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$OverTimeAttendanceApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$OverTimeAttendanceApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$OverTimeAttendanceApprovePage.lblSuccessOrErrorMessage}"
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
