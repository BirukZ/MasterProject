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
                <title>Transport Absence Date Payment Request Page</title>
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
                    function TransportAbsencePaymentRequestPage(field){

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
                        <ice:panelBorder id="whole_page" renderCenter="#{TransportPayment$TransportAbsencePaymentRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{TransportPayment$TransportAbsencePaymentRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{TransportPayment$TransportAbsencePaymentRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{TransportPayment$TransportAbsencePaymentRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{TransportPayment$TransportAbsencePaymentRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                                binding="#{TransportPayment$TransportAbsencePaymentRequestPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{TransportPayment$TransportAbsencePaymentRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{TransportPayment$TransportAbsencePaymentRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{TransportPayment$TransportAbsencePaymentRequestPage.pendingRequestList}"/>
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
                                                                binding="#{TransportPayment$TransportAbsencePaymentRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 200px; width: 190px"
                                                                value="#{TransportPayment$TransportAbsencePaymentRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{TransportPayment$TransportAbsencePaymentRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{TransportPayment$TransportAbsencePaymentRequestPage.requestHistoryList}"/>
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
                                        <fieldset class="filedset_css" style="height: 970px;width: 800px">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Service Absent Payment Request Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 961px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlGrpPowerAllContent" style="height: 910px; width: 780px">
                                                    <ice:panelLayout id="pnlLayoutRequestAttributesCommon"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 225px; left: 10px; top: 20px; position: absolute; width: 780px" styleClass="insideContainerMain">
                                                        <ice:selectInputText
                                                            action="#{TransportPayment$TransportAbsencePaymentRequestPage.txtRequesterFullName_action}"
                                                            binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtRequesterFullName}"
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
                                                        <ice:outputLabel id="lblRequesterDepartment"
                                                            style="font-size: 10px; left: 38px; top: 64px; position: absolute" value="#{msgTr.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgTr.Id}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtRequesterDepartment}"
                                                            disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 575px"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtRequesterId}"
                                                            id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 502px; top: 22px; position: absolute; width: 239px"/>
                                                        <ice:outputLabel id="lblRequsterFullName"
                                                            style="font-size: 10px; left: 38px; top: 30px; position: absolute" value="#{msgTr.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition"
                                                            style="font-size: 10px; left: 38px; top: 98px; position: absolute" value="#{msgTr.Position}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtRequesterPosition}"
                                                            disabled="true" id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 575px"/>
                                                        <ice:commandButton
                                                            action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtStartDate}"
                                                            id="txtStartDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240);   position: absolute; width: 133px;&#xa;left: 166px; top: 170px; position: absolute; width: 191px"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtEndDate}"
                                                            id="txtEndDate" style="background-color: rgb(242, 246, 240); left: 545px; top: 166px; position: absolute; width: 191px"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnStartDate_action}"
                                                            id="btnStartDate" image="/resources/images/cal_button.gif"
                                                            style="left: 341px; top: 176px; position: absolute" value="Start"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnEndDate_action}"
                                                            id="btnEndDate" image="/resources/images/cal_button.gif"
                                                            style="left: 720px; top: 172px; position: absolute" value="End"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsencePaymentRequestPage.calStartDate}"
                                                            id="calStartDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 50px; position: absolute; width: 190px;z-index:200"
                                                            value="#{TransportPayment$TransportAbsencePaymentRequestPage.selectInputDateBean1.date1}" valueChangeListener="#{TransportPayment$TransportAbsencePaymentRequestPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsencePaymentRequestPage.calEndDate}"
                                                            id="calEndDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 50px; position: absolute; width: 190px;z-index:200"
                                                            value="#{TransportPayment$TransportAbsencePaymentRequestPage.selectInputDateBean1.date1}" valueChangeListener="#{TransportPayment$TransportAbsencePaymentRequestPage.calEndDate_processValueChange}"/>
                                                        <ice:outputLabel id="lblStartDate" style="font-size: 11px; left: 38px; top: 175px; position: absolute" value="#{msgTr.StartDate}"/>
                                                        <ice:outputLabel id="lblEndDate" style="font-size: 11px; left: 438px; top: 175px; position: absolute" value="#{msgTr.EndDate}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsencePaymentRequestPage.txtAppliedDate}"
                                                            id="txtAppliedDate" style="left: 166px; top: 132px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="#{msgTr.RequestDate}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlCalculate"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 50px; left: 10px; top: 253px; position: absolute; width: 780px" styleClass="insideContainerMain"/>
                                                    <ice:panelLayout id="pnlLayoutTable"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 380px; left: 10px; top: 310px; overflow: auto; position: absolute; width: 780px" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{TransportPayment$TransportAbsencePaymentRequestPage.dataTable}" id="dataTable"
                                                            style="left: 0px; top: -10px; overflow: auto; position: absolute; width: 100%"
                                                            value="#{TransportPayment$TransportAbsencePaymentRequestPage.requestModelList}" var="currentRow">
                                                            <ice:column id="colSelected" rendered="#{TransportPayment$TransportAbsencePaymentRequestPage.selectedColumnRendered}">
                                                                <ice:selectBooleanCheckbox
                                                                    binding="#{TransportPayment$TransportAbsencePaymentRequestPage.ckbForColumnSelected}"
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
                                                                    <ice:outputText id="headerTextpaymentForNoTransport" value="Payment For no Transport"/>
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
                                                    <ice:panelLayout binding="#{TransportPayment$TransportAbsencePaymentRequestPage.panelLayout3}"
                                                        id="panelLayout3" layout="flow" rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 360px; left: 450px; top: 45px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                    <!-- <ice:commandButton
                                                            action="#{TransportAbsenceDatePayment$TransportAbsencePaymentRequestPage.btnAddToTable_action}"
                                                            id="btnAddToTable" style="left: 600px; top: 50px; position: absolute; width: 60px" value="Add"/>
                                                            -->
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 54px; left: 10px; top: 700px; overflow: auto; position: absolute; width: 780px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnSave_action}"
                                                            binding="#{TransportPayment$TransportAbsencePaymentRequestPage.btnSave}" id="btnSave"
                                                            style="left: 216px; top: 0px; position: absolute; width: 167px" value="#{TransportPayment$TransportAbsencePaymentRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnReset_action}"
                                                            id="btnReset" style="left: 400px; top: 0px; position: absolute; width: 171px" value="#{msgTr.Reset}"/>
                                                    </ice:panelLayout>
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
                        <ice:panelPopup autoCentre="true" binding="#{TransportPayment$TransportAbsencePaymentRequestPage.pnlPopupSuccessOrFailure}"
                            clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{TransportPayment$TransportAbsencePaymentRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{TransportPayment$TransportAbsencePaymentRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{TransportPayment$TransportAbsencePaymentRequestPage.pnlMessageBody}" id="pnlMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{TransportPayment$TransportAbsencePaymentRequestPage.lblSuccessOrErrorMessage}"
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
