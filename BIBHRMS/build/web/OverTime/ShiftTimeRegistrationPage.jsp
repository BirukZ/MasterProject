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
        <f:loadBundle basename="Localization.HRLocaalization_Shift" var="msgshif"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Shift Time Registration</title>
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
                    function EmployeeShiftPage(field){

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
                                                <ice:outputLabel value="Shift Time Registration Page"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 961px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{OverTime$ShiftTimeRegistrationPage.pnlGrpPowerAllContent_processMyEvent}"
                                                    id="pnlGrpPowerAllContent" style="height: 910px" styleClass="icePnlGrp filedset_border">
                                                    <ice:panelLayout id="pnlLayoutEmployees" rendered="true"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 500px; margin-left: 15px; left: 20px; top: 215px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:panelLayout binding="#{OverTime$ShiftRegistrationPage.panelLayout3}" id="panelLayout3"
                                                            layout="flow" rendered="false"
                                                            style="border-width: 2px; border-style: solid; height: 360px; left: 450px; top: 45px; overflow: scroll; position: absolute; width: 400px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:tree action="#{OverTime$ShiftRegistrationPage.tree1_action}"
                                                                binding="#{OverTime$ShiftRegistrationPage.tree1}" id="tree1"
                                                                style="height: 286px; margin-left: 0px; margin-top: 0px; text-align: left; width: 190px"
                                                                value="#{OverTime$ShiftRegistrationPage.tree1Model.model}" var="item">
                                                                <ice:treeNode id="treeNode1">
                                                                    <f:facet name="icon">
                                                                        <ice:panelGroup id="panelGroup1" style="display: inline;">
                                                                            <ice:graphicImage id="graphicImage1" value="#{item.userObject.icon}"/>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                    <f:facet name="content">
                                                                        <ice:panelGroup id="panelGroup2" style="display: inline;">
                                                                            <ice:commandLink action="#{OverTime$ShiftRegistrationPage.commandLink1_action}"
                                                                                actionListener="#{OverTime$ShiftRegistrationPage.commandLink1_processAction}"
                                                                                id="commandLink1" partialSubmit="true">
                                                                                <ice:outputText id="outputText2" value="#{item.userObject.text}"/>
                                                                            </ice:commandLink>
                                                                        </ice:panelGroup>
                                                                    </f:facet>
                                                                </ice:treeNode>
                                                            </ice:tree>
                                                        </ice:panelLayout>
                                                        <ice:inputText binding="#{OverTime$ShiftTimeRegistrationPage.txtStartTime}" id="txtStartTime" style="margin-left: 5px; margin-right: 400px; left: 180px; top: 40px; position: absolute; width: 25%"/>
                                                        <ice:inputText binding="#{OverTime$ShiftTimeRegistrationPage.txtEndTime}" id="txtEndTime" style="margin-left: 5px; margin-right: 400px; left: 180px; top: 80px; position: absolute; width: 25%"/>
                                                        <ice:outputLabel id="outputLabel1"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 40px; position: absolute; width: 10%" value="#{msgshif.StartTime}"/>
                                                        <ice:outputLabel id="outputLabel2"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 80px; position: absolute; width: 10%" value="#{msgshif.EndTime}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnStartTime_action}" id="btnStartTime"
                                                            image="/resources/images/clock.png"
                                                            style="margin-left: 5px; margin-right: 400px; left: 350px; top: 40px; position: absolute" value="submit"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnEndTime_action}" id="btnEndTime"
                                                            image="/resources/images/clock.png"
                                                            style="margin-left: 5px; margin-right: 400px; left: 350px; top: 80px; position: absolute;" value="submit"/>
                                                        <ice:selectOneMenu binding="#{OverTime$ShiftTimeRegistrationPage.drlShiftName}" id="drlShiftName"
                                                            partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 180px; top: 160px; position: absolute; width: 27%" value="#{OverTime$ShiftTimeRegistrationPage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{OverTime$ShiftTimeRegistrationPage.sel}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="outputLabel3"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 160px; position: absolute; width: 10%" value="#{msgshif.shiftName}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnAdd_action}"
                                                            binding="#{OverTime$ShiftTimeRegistrationPage.btnAdd}" id="btnAdd" partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 50px; top: 240px; position: absolute; width: 15%" value="#{msgshif.Add}"/>
                                                        <ice:panelLayout id="pnlLayoutTable"
                                                            style="border: 1px solid rgb(204, 204, 204); height: 213px; margin-left: 10px; left: 9px; top: 280px; overflow: auto; position: absolute; width: 670px" styleClass="insideContainerMain">
                                                            <ice:dataTable binding="#{OverTime$ShiftTimeRegistrationPage.dataTable}" id="dataTable" rows="10"
                                                                style="height: 8px; left: 0px; top: 0px; overflow: auto; position: absolute; width: 100%"
                                                                value="#{OverTime$ShiftTimeRegistrationPage.sfttreg}" var="currentRow">
                                                                <ice:column id="colEmployeeId">
                                                                    <ice:outputText id="optTxtForEmployeeid" value="#{currentRow['start_time']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headertextEmployeeId" value="Start Time"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector id="rowSelector1" immediate="true" multiple="false" selectionListener="#{OverTime$ShiftTimeRegistrationPage.rowSelector1_processAction}"/>
                                                                </ice:column>
                                                                <ice:column id="colDisciplimeName">
                                                                    <ice:outputText id="optTxtForColumnFullName1" value="#{currentRow['end_time']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextFullName" value="End Time"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndDate">
                                                                    <ice:outputText id="optTxtForColumnFullName2" value="#{currentRow['shift_name']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndDate" value="Shift Name"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndTime">
                                                                    <ice:outputText id="optTxtForColumnFullName3" value="#{currentRow['registered_date']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextEndTime" value="Started Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colAddress">
                                                                    <ice:outputText id="Address" value="#{currentRow['address']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="Adress" value="Address"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:inputText binding="#{OverTime$ShiftTimeRegistrationPage.txtRegDate}" id="txtRegDate" style="margin-left: 5px; margin-right: 400px; left: 180px; top: 205px; position: absolute; width: 174px"/>
                                                        <ice:outputLabel id="outputLabel4"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 205px; position: absolute; width: 13%" value="#{msgshif.StartedDate}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnCalReg_action}"
                                                            binding="#{OverTime$ShiftTimeRegistrationPage.btnCalReg}" id="btnCalReg"
                                                            image="/resources/images/cal_icon.JPG"
                                                            style="margin-left: 5px; margin-right: 400px; left: 340px; top: 205px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{OverTime$ShiftTimeRegistrationPage.calendarRegDate}"
                                                            id="calendarRegDate" rendered="false"
                                                            style="height: 212px; left: 350px; top: 16px; position: absolute; width: 190px"
                                                            value="#{OverTime$ShiftTimeRegistrationPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$ShiftTimeRegistrationPage.calendarRegDate_processValueChange}"/>
                                                        <ice:selectOneMenu binding="#{OverTime$ShiftTimeRegistrationPage.drlAddress}" id="drlAddress"
                                                            partialSubmit="true"
                                                            style="margin-left: 5px; margin-right: 400px; left: 180px; top: 120px; position: absolute; width: 27%" value="#{OverTime$ShiftTimeRegistrationPage.defaultSelectedData1.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{OverTime$ShiftTimeRegistrationPage.addressCodeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="outputLabel5"
                                                            style="margin-left: 5px; margin-right: 400px; left: 70px; top: 120px; position: absolute; width: 10%" value="#{msgshif.Address}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 54px; margin-left: 15px; left: 20px; top: 730px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnSave_action}"
                                                            binding="#{OverTime$ShiftTimeRegistrationPage.btnSave}" id="btnSave"
                                                            style="left: 150px; top: 5px; position: absolute; width: 15%" value="#{msgshif.Save}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnUpdate_action}"
                                                            binding="#{OverTime$ShiftTimeRegistrationPage.btnUpdate}" disabled="true" id="btnUpdate"
                                                            style="left: 300px; top: 5px; position: absolute; width: 15%" value="#{msgshif.Update}"/>
                                                        <ice:commandButton action="#{OverTime$ShiftTimeRegistrationPage.btnReset_action}"
                                                            binding="#{OverTime$ShiftTimeRegistrationPage.btnReset}" id="btnReset"
                                                            style="left: 450px; top: 5px; position: absolute; width: 15%" value="#{msgshif.Reset}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestAttributesCommon"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 131px; margin-left: 15px; left: 20px; top: 75px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain"/>
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 120px; top: 100px; position: absolute; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDateBean1.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calAppliedDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calStartDate}" id="calStartDate"
                                                        rendered="false" style="height: 212px; left: 120px; top: 150px; position: absolute; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calStartDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{OverTime$OverTimeRequestPage.calEndDate}" id="calEndDate" rendered="false"
                                                        style="left: 424px; top: 150px; position: absolute; height:212px; width: 190px"
                                                        value="#{OverTime$OverTimeRequestPage.selectInputDate2Bean.date1}" valueChangeListener="#{OverTime$OverTimeRequestPage.calEndDate_processValueChange}"/>
                                                    <ice:panelLayout binding="#{OverTime$ShiftTimeRegistrationPage.pnlLayoutTimePanel}" id="pnlLayoutTimePanel"
                                                        rendered="false"
                                                        style="border: 5px solid rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 400px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                                                        <ice:dataTable id="dataTableTime" rows="12"
                                                            style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                                            value="#{OverTime$OverTimeRequestPage.tableHour}" var="currentRow">
                                                            <ice:column id="colStartDate12">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn00" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col00']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartDate02">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn02" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col10']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime04">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForolumn04" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col20']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime06">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn06" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col30']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime08">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn08_processAction}"
                                                                    id="optTxtForColumn08" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                                    onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col40']}"/>
                                                            </ice:column>
                                                            <ice:column id="colStartTime10">
                                                                <ice:commandLink
                                                                    actionListener="#{OverTime$ShiftTimeRegistrationPage.optTxtForColumn10_processAction}"
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
                        <ice:panelPopup autoCentre="true" binding="#{OverTime$ShiftTimeRegistrationPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{OverTime$ShiftTimeRegistrationPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{OverTime$ShiftTimeRegistrationPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{OverTime$ShiftTimeRegistrationPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{OverTime$ShiftTimeRegistrationPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
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
