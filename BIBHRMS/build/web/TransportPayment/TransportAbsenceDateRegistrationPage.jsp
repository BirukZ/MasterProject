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
                <title>Transport Absence Date Registration</title>
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
            function TransportAbsenceDateRegistrationPage(field){

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
                        <ice:panelBorder id="whole_page" renderCenter="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelBorder1Bean.renderEast}"
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
                                                <ice:outputLabel value="Service Absent Date Registration Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 961px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlGrpPowerAllContent" style="height: 910px">
                                                    <ice:panelLayout id="pnlLayoutRequestAttributesCommon" style="border: 1px solid rgb(204, 204, 204); height: 190px; left: 5px; top: 15px; overflow: auto; position: absolute; width: 770px">
                                                        <ice:outputLabel id="lblActualDestName"
                                                            style="font-size: 11px; left: 425px; top: 20px; position: absolute" value="#{msgTr.AbsenceDate}"/>
                                                        <ice:outputLabel id="lblInOut" style="font-size: 11px; left: 425px; top: 60px; position: absolute" value="#{msgTr.ServiceINOUT}"/>
                                                        <ice:outputLabel id="lblServiceDestName"
                                                            style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="#{msgTr.ServiceDestination}"/>
                                                        <ice:outputLabel id="lblextraTarif" style="font-size: 10px; left: 38px; top: 60px; position: absolute" value="#{msgTr.Shift}"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.txtAbsenceDate}"
                                                            id="txtAbsenceDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:selectOneMenu
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.drlServiceDestination}"
                                                            id="drlServiceDestination" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectOneMenu3Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.serviceList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.drlShift}"
                                                            id="drlShift" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 190px" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectOneMenu2Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.sel}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.drlInOut}"
                                                            id="drlInOut" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 54px; position: absolute; width: 190px" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems3" value="#{TransportPayment$TransportAbsenceDateRegistrationPage.inOut}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectBooleanCheckbox binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.chkDaily}"
                                                            id="chkDaily" partialSubmit="true" style="left: 170px; top: 98px; position: absolute"
                                                            value="#{TransportPayment$TransportAbsenceDateRegistrationPage.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{TransportPayment$TransportAbsenceDateRegistrationPage.chkDaily_processValueChange}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnCalender_action}"
                                                            id="btnCalender" image="/resources/images/cal_button.gif"
                                                            style="left: 695px; top: 23px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnEndDate_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnEndDate}" id="btnEndDate"
                                                            image="/resources/images/cal_button.gif"
                                                            style="left: 695px; top: 143px; position: absolute; z-index: 100" value="submit"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.calAppliedDate}"
                                                            id="calAppliedDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 10px; position: absolute; width: 190px;z-index:200"
                                                            value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectInputDateBean1.date1}" valueChangeListener="#{TransportPayment$TransportAbsenceDateRegistrationPage.calAppliedDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.calStartDate}"
                                                            id="calStartDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 10px; position: absolute; width: 190px;z-index:200"
                                                            value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectInputDateBean1.date1}" valueChangeListener="#{TransportPayment$TransportAbsenceDateRegistrationPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.calEndDate}"
                                                            id="calEndDate" rendered="false"
                                                            style="height: 212px; left: 400px; top: 10px; position: absolute; width: 190px;z-index:200"
                                                            value="#{TransportPayment$TransportAbsenceDateRegistrationPage.selectInputDateBean1.date1}" valueChangeListener="#{TransportPayment$TransportAbsenceDateRegistrationPage.calEndDate_processValueChange}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnStartDate_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnStartDate}" id="btnStartDate"
                                                            image="/resources/images/cal_button.gif"
                                                            style="left: 325px; top: 143px; position: absolute; z-index: 100" value="submit"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.txtStartDate}"
                                                            id="txtStartDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.txtEndDate}"
                                                            id="txtEndDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 137px; position: absolute; width: 190px"/>
                                                        <ice:outputLabel id="lblStartDate" style="font-size: 10px; left: 38px; top: 140px; position: absolute" value="#{msgTr.StartDate}"/>
                                                        <ice:outputLabel id="lblEndDate" style="font-size: 11px; left: 425px; top: 140px; position: absolute" value="#{msgTr.EndDate}"/>
                                                        <ice:outputLabel id="lblTotalDate" style="font-size: 10px; left: 38px; top: 95px; position: absolute" value="#{msgTr.IsManyDays}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlServiceDestination"
                                                            id="message1" infoClass="infoMessage" style="left: 350px; top: 20px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlShift" id="message2"
                                                            infoClass="infoMessage" style="left: 350px; top: 54px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlInOut" id="message3"
                                                            infoClass="infoMessage" style="left: 720px; top: 54px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAbsenceDate" id="message4"
                                                            infoClass="infoMessage" style="left: 720px; top: 20px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtStartDate" id="message5"
                                                            infoClass="infoMessage" style="left: 350px; top: 140px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEndDate" id="message6"
                                                            infoClass="infoMessage" style="left: 720px; top:140px; position: absolute" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutAdd" style="border: 1px solid rgb(204, 204, 204); height: 54px; left: 5px; top: 210px; overflow: auto; position: absolute; width: 770px">
                                                        <ice:commandButton
                                                            action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnAddToTable_action}"
                                                            id="btnAddToTable" style="width: 157px;margin-left: 40px; " value="#{msgTr.Add}"/>
                                                        <ice:commandButton
                                                            action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnShowPrevious_action}"
                                                            id="btnShowPrevious" style="width: 163px" value="#{msgTr.ShowpreviousRecord}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutTable" style="border: 1px solid rgb(204, 204, 204); height: 600px; left: 5px; top: 270px; overflow: auto; position: absolute; width: 770px">
                                                        <ice:dataTable binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.dataTable}"
                                                            id="dataTable" style="left: 0px; top: -10px; overflow: auto; position: absolute; width: 100%"
                                                            value="#{TransportPayment$TransportAbsenceDateRegistrationPage.serviceAbsenceDateList}" var="currentRow">
                                                            <ice:column id="colServiceId">
                                                                <ice:outputText id="optTxtForServiceId" value="#{currentRow['serviceName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headertextServiceId" value="Service Destination"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colShift">
                                                                <ice:outputText id="optTxtForColumnShift" value="#{currentRow['shift']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextShift" value="Shift"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colInOut">
                                                                <ice:outputText id="optTxtForColumnInOut" value="#{currentRow['inOut']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextInOut" value="In/Out"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colAbsenceDate">
                                                                <ice:outputText id="optTxtForColumnAbsenceDate" value="#{currentRow['absenceDate']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextAbsenceDate" value="Absence Date"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorTransportAbsentDate" multiple="false" preStyleOnSelection="true"
                                                                    selectionListener="#{TransportPayment$TransportAbsenceDateRegistrationPage.rowSelectorTransportAbsentDate_processMyEvent}" value="#{currentRow['selected']}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelLayout3}"
                                                        id="panelLayout3" layout="flow" rendered="false"
                                                        style="border-width: 2px; border-style: solid; height: 360px; left: 450px; top: 45px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain"/>
                                                    <ice:panelLayout id="pnlLayoutButtons" style="border: 1px solid rgb(204, 204, 204); height: 54px; left: 5px; top: 880px; overflow: auto; position: absolute; width: 770px">
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnNew_action}"
                                                            id="btnNew" style="margin-left: 40px; width: 80px" value="#{msgTr.New}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnSave_action}"
                                                            id="btnSave" style="margin-left: 40px; width: 80px" value="#{msgTr.Save}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnEdit_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnEdit}" id="btnEdit"
                                                            style="margin-left: 40px; width: 80px" value="#{msgTr.Edit}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnReset_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnReset}" id="btnReset"
                                                            style="margin-left: 40px; width: 80px" value="#{msgTr.Reset}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnUpdate_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnUpdate}" id="btnUpdate"
                                                            style="margin-left: 40px; width: 80px" value="#{msgTr.Update}"/>
                                                        <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnDelete_action}"
                                                            binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnDelete}" id="btnDelete"
                                                            style="margin-left: 40px; width: 80px" value="#{msgTr.Delete}"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.pnlPopupSuccessOrFailure}"
                            clientOnly="true" draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.pnlMessageBody}" id="pnlMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.areuShurePlanPopUpMsg}"
                            draggable="true" id="areuShurePlanPopUpMsg" modal="true" rendered="false" style="display: block; height: 156px; left: 96px; top: 216px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblemployeePopUpMsgTitle" value="Mugher Cement Enterprise Human Resource Management "/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                    <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btntemployeePopUpNo_action}"
                                        id="btntemployeePopUpNo" immediate="true" partialSubmit="true" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{TransportPayment$TransportAbsenceDateRegistrationPage.btntemployeePopUpYes_action}"
                                        id="btntemployeePopUpYes" immediate="true" partialSubmit="true" rendered="true"
                                        style="background-position: 0,100%; background-repeat: no-repeat; left: 432px; top: 62px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText binding="#{TransportPayment$TransportAbsenceDateRegistrationPage.lblemployeePopUpMsgMain}"
                                        id="lblemployeePopUpMsgMain" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px"/>
                                    <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
