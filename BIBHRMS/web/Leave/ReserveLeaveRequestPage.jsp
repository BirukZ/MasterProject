<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
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
                    function ReserveLeaveApprovePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
               <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$ReserveLeaveRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$ReserveLeaveRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$ReserveLeaveRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$ReserveLeaveRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$ReserveLeaveRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border-style: none; height: 470px; top: 40px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:0px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 0px; top: 24px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                        <ice:selectInputText action="#{Leave$ReserveLeaveRequestPage.txtSearchByName_action}"
                                                            id="txtSearchByName" immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                            partialSubmit="true" rows="10" style="left: 5px; top: 50px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                    </ice:panelGrid>
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
                                                            <ice:commandLink action="#{Leave$ReserveLeaveRequestPage.lnkLeaveRequest_action}"
                                                                id="lnkLeaveRequest" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ReserveLeaveRequestPage.lnkPayrollSetUp_action}"
                                                                id="lnkPayrollSetUp" style="color:#333333;font-weight:bold" value="Approve Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ReserveLeaveRequestPage.lnkAccrualEntries_action}"
                                                                id="lnkAccrualEntries" style="color:#333333;font-weight:bold" value="Transfer Annual Leave"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Leave Transfer Request history"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox binding="#{Leave$ReserveLeaveRequestPage.listOfLeaveTransferRequest}"
                                                                id="listOfLeaveTransferRequest" partialSubmit="true" size="2"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 223px; left: 10px; top: -5px; position: absolute; width: 182px"
                                                                value="#{Leave$ReserveLeaveRequestPage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$ReserveLeaveRequestPage.listOfLeaveTransferRequest_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$ReserveLeaveRequestPage.listOfRequestLeaveTransfer}"/>
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
                                <ice:panelGroup id="page_display" style="height:840px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; top:65px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Reserve Employee Leave"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 686px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 270px; left: 30px; top: 20px; position: absolute; width: 725px">
                                                        <ice:inputText binding="#{Leave$ReserveLeaveRequestPage.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                        <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnEmplyeeSearch_action}"
                                                            binding="#{Leave$ReserveLeaveRequestPage.btnEmplyeeSearch}" id="btnEmplyeeSearch"
                                                            style="color: rgb(115, 179, 200); left: 380px; top: 9px; position: absolute; width: 100px" value="Search"/>
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 54px; position: absolute" value="Full Name"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveRequestPage.lblFull_Name}" id="lblFull_Name"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lbllDepartment2" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveRequestPage.lblDepartment}" id="lblDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveRequestPage.lblPosition}" id="lblPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="lblGender" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                        <ice:graphicImage binding="#{Leave$ReserveLeaveRequestPage.imgEmployeePicture}" height="194"
                                                            id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 545px; top: 10px; position: absolute"
                                                            value="/Employee/images/blank.gif" width="172"/>
                                                        <ice:outputText id="outputText8" style="font-size: 11px; left: 38px; top: 205px; position: absolute" value="Total Service Year"/>
                                                        <ice:outputText binding="#{Leave$ReserveLeaveRequestPage.lblServiceYear}" id="lblServiceYear"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 205px; position: absolute; width: 170px" value=":"/>
                                                        <ice:outputText id="outputText9" style="font-size: 11px; left: 38px; top: 239px; position: absolute" value="Request Date"/>
                                                        <ice:inputText binding="#{Leave$ReserveLeaveRequestPage.txtRequestDate}" id="txtRequestDate"
                                                            rendered="true" style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 239px; position: absolute; width: 190px"/>
                                                        <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnCalender_action}" id="btnCalender"
                                                            image="/Employee/images/calendar.gif"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 324px; top: 242px; position: absolute" value="submit"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequestDate" id="message1"
                                                            infoClass="infoMessage" style="left: 350px; top: 239px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:selectInputDate binding="#{Leave$ReserveLeaveRequestPage.calRequestDate}" id="calRequestDate"
                                                            popupDateFormat="yyyy-MM-dd"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 266px; position: absolute; width: 190px; z-index: 10"
                                                            value="#{Leave$ReserveLeaveRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Leave$ReserveLeaveRequestPage.calRequestDate_processValueChange}"/>
                                                        <ice:outputText id="lblMale" style="font-size: 11px; left: 175px; top: 168px; position: absolute" value="Male"/>
                                                        <ice:outputText id="lblFemale" style="font-size: 11px; left: 260px; top: 171px; position: absolute" value="Female"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ReserveLeaveRequestPage.choMale}" id="choMale"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 171px; position: absolute" value="#{Leave$ReserveLeaveRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ReserveLeaveRequestPage.choFemale}" id="choFemale"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 171px; position: absolute" value="#{Leave$ReserveLeaveRequestPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 315px; left: 30px; top: 300px; position: absolute; width: 725px">
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Leave Year"/>
                                                        <ice:outputText id="outputText3" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Available Leave Days"/>
                                                        <ice:selectOneMenu binding="#{Leave$ReserveLeaveRequestPage.drlLeaveYear}" id="drlLeaveYear"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"
                                                            value="#{Leave$ReserveLeaveRequestPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Leave$ReserveLeaveRequestPage.drlLeaveYear_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$ReserveLeaveRequestPage.recommendedYear}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputText binding="#{Leave$ReserveLeaveRequestPage.txtAvailableLeaveYear}"
                                                            id="txtAvailableLeaveYear" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 17px; position: absolute; width: 140px"/>
                                                        <ice:outputText id="lblStartDate" style="font-size: 10px; left: 38px; top: 60px; position: absolute" value="Start Date"/>
                                                        <ice:selectInputDate binding="#{Leave$ReserveLeaveRequestPage.calEndDate}" id="calEndDate"
                                                            popupDateFormat="yyyy-MM-dd" renderAsPopup="true"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 57px; position: absolute; width: 190px" value="#{Leave$ReserveLeaveRequestPage.selectInputDate2Bean.date1}"/>
                                                        <ice:selectInputDate binding="#{Leave$ReserveLeaveRequestPage.calStartDate}" id="calStartDate"
                                                            popupDateFormat="yyyy-MM-dd" renderAsPopup="true"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;                                                             left: 150px; top: 57px; position: absolute" value="#{Leave$ReserveLeaveRequestPage.selectInputDateBean1.date1}"/>
                                                        <ice:outputText id="lblEndDate" style="font-size: 10px; left: 396px; top: 60px; position: absolute" value="End Date"/>
                                                        <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnAdd_action}"
                                                            binding="#{Leave$ReserveLeaveRequestPage.btnAdd}" id="btnAdd"
                                                            style="color: rgb(115, 179, 200); left: 35px; top: 140px; position: absolute; width: 90px" value="Add"/>
                                                        <ice:panelLayout id="lyRequestTableInformation" style="border: 1px solid rgb(204, 204, 204); height: 120px; left: 10px; top: 180px; overflow: auto; position: absolute; width: 705px">
                                                            <ice:dataTable binding="#{Leave$ReserveLeaveRequestPage.dataTable1}" id="dataTable1"
                                                                style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                                value="#{Leave$ReserveLeaveRequestPage.avilebelLeaveList}" var="currentRow">
                                                                <ice:column id="column1">
                                                                    <ice:outputText id="outputText4" value="#{currentRow['leaveYear']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText5" value="Leave Year"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column2">
                                                                    <ice:outputText id="outputText6" value="#{currentRow['avilbelLeveDay']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText7" value="Available Leave Days"/>
                                                                    </f:facet>
                                                                    <ice:rowSelector binding="#{Leave$ReserveLeaveRequestPage.rwSelectorReservedLeave}"
                                                                        id="rwSelectorReservedLeave" immediate="true" multiple="false"
                                                                        selectionListener="#{Leave$ReserveLeaveRequestPage.rwSelectorReservedLeave_processMyEvent}" value="#{currentRow['selected']}"/>
                                                                </ice:column>
                                                                <ice:column id="colStartDate">
                                                                    <ice:outputText id="outStartDate" value="#{currentRow['starttDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblStartDate" value="Start Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colEndDate">
                                                                    <ice:outputText id="outEndDate" value="#{currentRow['endDate']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblEndDatee" value="End Date"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colRemark">
                                                                    <ice:outputText id="outRemarke" value="#{currentRow['remark']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblRemark" value="Remark"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colStatus">
                                                                    <ice:outputText id="outputSatus" value="#{currentRow['requestStatus']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="lblStatus" value="Request Status"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:outputText id="lblRemark" style="font-size: 10px; left: 38px; top: 100px; position: absolute" value="Remark"/>
                                                        <ice:inputTextarea binding="#{Leave$ReserveLeaveRequestPage.txtRemark}" id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 100px; position: absolute; width: 519px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLeaveYear" id="message2"
                                                            infoClass="infoMessage"
                                                            style=" font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top:37px; position: absolute; width: 190px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAvailableLeaveYear"
                                                            id="message3" infoClass="infoMessage"
                                                            style="font-size: 11px; font-style: normal; font-weight: lighter; left: 520px; top: 37px; position: absolute; width: 100px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRemark" id="message4"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 160px; position: absolute; width: 190px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                                <ice:panelLayout id="lyLeaveRequest" rendered="true" style="border: 1px solid rgb(204, 204, 204); left: 30px; top: 650px; position: absolute; width: 725px">
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnNew_action}"
                                                        binding="#{Leave$ReserveLeaveRequestPage.btnNew}" id="btnNew" partialSubmit="true"
                                                        style="margin-left: 10px; width: 80px" value="New"/>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnSave_action}"
                                                        binding="#{Leave$ReserveLeaveRequestPage.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="Request"/>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnEdit_action}" id="btnEdit"
                                                        style="margin-left: 40px; width: 80px" value="Edit"/>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnUpdate_action}"
                                                        binding="#{Leave$ReserveLeaveRequestPage.btnUpdate}" id="btnUpdate"
                                                        style="margin-left: 40px; width: 80px" value="Update"/>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnReset_action}"
                                                        binding="#{Leave$ReserveLeaveRequestPage.btnReset}" id="btnReset" immediate="true" partialSubmit="true"
                                                        style="margin-left: 40px; width: 80px" value="Cancel"/>
                                                    <ice:commandButton action="#{Leave$ReserveLeaveRequestPage.btnDelete_action}"
                                                        binding="#{Leave$ReserveLeaveRequestPage.btnDelete}" id="btnDelete"
                                                        style="margin-left: 40px; width: 80px" value="Delete"/>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#FFFFFF;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#FFFFFF;">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                    </div>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$ReserveLeaveRequestPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Leave$ReserveLeaveRequestPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup binding="#{Leave$ReserveLeaveRequestPage.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Leave$ReserveLeaveRequestPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                    layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Leave$ReserveLeaveRequestPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
