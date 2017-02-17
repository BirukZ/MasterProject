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
        <f:loadBundle basename="Localization.HRLocaalization_Transport" var="msgTr"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Transport Absence Date Payment Approve Page</title>
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
                    function TransportAbsenceDatePaymentApprovePage(field){

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
                        <ice:panelBorder id="whole_page" renderCenter="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelBorder1Bean.renderEast}"
                            style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
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
                                                                id="lnkOverTimeReport" style="color:#306682;font-weight:bold" value="Report"/>
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
                                                            <ice:selectOneListbox
                                                                binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.pendingRequestList}"/>
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
                                                            <ice:selectOneListbox
                                                                binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.requestHistoryList}"/>
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
                                                <ice:outputLabel value="Service Absent Payment Approve Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 961px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup
                                                    dragListener="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.pnlGrpPowerAllContent_processMyEvent}"
                                                    id="pnlGrpPowerAllContent" style="height: 910px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutEmployees" rendered="true"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 246px; margin-left: 15px; left: 20px; top: 318px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 213px; margin-left: 10px; left: 9px; top: 10px; overflow: auto; position: absolute; width: 670px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.dataTable}"
                                                                id="dataTable"
                                                                style="height: 8px; left: 0px; top: 0px; overflow: auto; position: absolute; width: 100%"
                                                                value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.requestModelList}" var="currentRow">
                                                                <ice:column id="colSelected" rendered="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectedColumnRendered}">
                                                                    <ice:selectBooleanCheckbox
                                                                        binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.ckbForColumnSelected}"
                                                                        disabled="true" id="ckbForColumnSelected" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextSelected" value="Selected"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column groupOn="#{currentRow['actualLocation']}" id="colserviceDestination">
                                                                    <ice:outputText id="optTxtForserviceDestination" value="#{currentRow['actualLocation']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextserviceDestination" value="service Destination"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colemployeeName">
                                                                    <ice:outputText id="optTxtForemployeeName" value="#{currentRow['employeeName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextemployeeName" value="employee name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colserviceAbsenteDate">
                                                                    <ice:outputText id="optTxtForserviceAbsenteDate" value="#{currentRow['serviceAbsenteDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextserviceAbsenteDate" value="S Absence Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colemployeeAbsenteDate">
                                                                    <ice:outputText id="optTxtForColumnemployeeAbsenteDate" value="#{currentRow['employeeAbsenteDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextemployeeAbsenteDate" value="E Absence Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coltarifPerDay">
                                                                    <ice:outputText id="optTxtForColumntarifPerDay" value="#{currentRow['tarifPerDay']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTexttarifPerDay" value="Tarif per day"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colpaymentForSAbsence">
                                                                    <ice:outputText id="optTxtForColumnpaymentForSAbsence" value="#{currentRow['paymentForSAbsence']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextAbsenceDate" value="Payment for S Absence"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coldaysInMonth">
                                                                    <ice:outputText id="optTxtForColumndaysInMonth" value="#{currentRow['daysInMonth']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextdaysInMonth" value="Days in Month"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coltotalEAbsenteDays">
                                                                    <ice:outputText id="optTxtForColumnStotalEAbsenteDays" value="#{currentRow['totalEAbsenteDays']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextStatus" value="Total E Absente Days"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colextraPaymentPerDay">
                                                                    <ice:outputText id="optTxtForColumnextraPaymentPerDay" value="#{currentRow['extraPaymentPerDay']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextextraPaymentPerDay" value="Extra Payment Per Day"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colpaymentForNoTransport">
                                                                    <ice:outputText id="optTxtForColumnpaymentForNoTransport" value="#{currentRow['paymentForNoTransport']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextpaymentForNoTransport" value="Payment For No Transport"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coltotalPayment">
                                                                    <ice:outputText id="optTxtForColumntotalPayment" value="#{currentRow['totalPayment']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTexttotalPayment" value="Total Payment"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelLayout3}"
                                                            id="panelLayout3" layout="flow" rendered="false"
                                                            style="border-width: 2px; border-style: solid; height: 360px; left: 450px; top: 45px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                        <!-- <ice:commandButton
                                                            action="#{TransportAbsenceDatePayment$TransportAbsenceDatePaymentApprovePage.btnAddToTable_action}"
                                                            id="btnAddToTable" style="left: 600px; top: 50px; position: absolute; width: 60px" value="Add"/>
                                                            -->
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 54px; margin-left: 15px; left: 20px; top: 780px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnSave_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnSave}" id="btnSave"
                                                            style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{TransportAbsenceDatePayment$TransportAbsenceDatePaymentRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnReset_action}"
                                                            id="btnReset" style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgTr.Reset}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestAttributesCommon"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 225px; margin-left: 15px; left: 20px; top: 75px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:selectInputText
                                                            action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtRequesterFullName_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtRequesterFullName}"
                                                            id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="color: #0066cc; left: 10px; top: 4px; position: absolute" value="#{msgTr.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 24px; top: 48px; position: absolute" value="#{msgTr.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgTr.Id}"/>
                                                        <ice:inputText
                                                            binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtRequesterDepartment}"
                                                            disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtRequesterId}"
                                                            id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 502px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 24px; top: 24px; position: absolute" value="#{msgTr.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 24px; top: 72px; position: absolute" value="#{msgTr.Position}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtRequesterPosition}"
                                                            disabled="true" id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton
                                                            action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtStartDate}"
                                                            id="txtStartDate" style="left: 502px; top: 142px; position: absolute; width: 133px"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtEndDate}"
                                                            id="txtEndDate" style="left: 502px; top: 166px; position: absolute; width: 133px"/>
                                                        <ice:commandButton
                                                            action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnStartDate_action}"
                                                            id="btnStartDate" image="/resources/images/cal_icon.JPG"
                                                            style="left: 640px; top: 130px; position: absolute; width: 33px" value="Start"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnEndDate_action}"
                                                            id="btnEndDate" image="/resources/images/cal_icon.JPG"
                                                            style="left: 640px; top: 160px; position: absolute; width: 33px" value="End"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.calStartDate}"
                                                            id="calStartDate" rendered="false"
                                                            style="height: 212px; left: 120px; top: 50px; position: absolute; width: 190px"
                                                            value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectInputDateBean1.date1}" valueChangeListener="#{TransportAbsenceDatePayment$TransportAbsenceDatePaymentRequestPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.calEndDate}"
                                                            id="calEndDate" rendered="false"
                                                            style="height: 212px; left: 120px; top: 50px; position: absolute; width: 190px"
                                                            value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.selectInputDateBean1.date1}" valueChangeListener="#{TransportAbsenceDatePayment$TransportAbsenceDatePaymentRequestPage.calEndDate_processValueChange}"/>
                                                        <ice:outputLabel id="lblStartDate" style="left: 408px; top: 144px; position: absolute" value="#{msgTr.StartDate}"/>
                                                        <ice:outputLabel id="lblEndDate" style="left: 408px; top: 168px; position: absolute" value="#{msgTr.EndDate}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtAppliedDate}"
                                                            id="txtAppliedDate" style="left: 166px; top: 130px; position: absolute; width: 133px"/>
                                                        <ice:outputLabel id="lblRequestDate" style="left: 24px; top: 120px; position: absolute" value="#{msgTr.RequestDate}"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                            <ice:panelLayout id="pnlLayoutDecider"
                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 174px; margin-left: 15px; left: 41px; top: 620px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                <ice:outputLabel id="lblDeciderDepartment" style="left: 24px; top: 24px; position: absolute" value="#{msgTr.DeciderDepartment}"/>
                                                <ice:outputLabel id="lblDeciderId" style="left: 24px; top: 48px; position: absolute" value="#{msgTr.DeciderId}"/>
                                                <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtDeciderDepartment}"
                                                    disabled="true" id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtDeciderId}" disabled="true"
                                                    id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                <ice:outputLabel id="lblDeciderFullName" style="left: 360px; top: 24px; position: absolute" value="#{msgTr.DeciderFullName}"/>
                                                <ice:outputLabel id="deciderPosition" style="left: 360px; top: 48px; position: absolute" value="#{msgTr.DeciderPosition}"/>
                                                <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtDeciderFullName}"
                                                    disabled="true" id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                <ice:inputText binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtDeciderPosition}"
                                                    disabled="true" id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                <ice:selectOneMenu binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.drlDecision}"
                                                    id="drlDecision" partialSubmit="true"
                                                    style="height: 23px; left: 167px; top: 89px; position: absolute; width: 143px" value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                    <f:selectItems id="selectDecisionAvailable" value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.availableDecisionsToMakeList}"/>
                                                </ice:selectOneMenu>
                                                <ice:outputLabel id="lblDecision" style="left: 24px; top: 72px; position: absolute" value="#{msgTr.Decision}"/>
                                                <ice:inputTextarea binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.txtaDeciderComment}"
                                                    id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                <ice:outputLabel id="lblDeciderComment" style="left: 24px; top: 120px; position: absolute" value="#{msgTr.Comment}"/>
                                                <ice:commandLink
                                                    action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.lnkViewPrevieousDecisions_action}"
                                                    binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.lnkViewPrevieousDecisions}"
                                                    id="lnkViewPrevieousDecisions" style=" left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.pnlPopupSuccessOrFailure}"
                            clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.pnlMessageBody}" id="pnlMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.pnlPopupViewPrevieousDecisions}"
                            draggable="true" id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="MUGHER HRMS - View request status "/>
                                    <ice:commandLink action="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{TransportPayment$TransportAbsenceDatePaymentApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
