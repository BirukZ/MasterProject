<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : BravoZulu
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgLeave"/>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <link href="../hopr.ico" rel="icon"/>
                <title>Leave Request</title>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <style type="text/css">
                    .message {
                        display: none;
                        margin: 0 0 13px 0;
                        background-color:#EFA;
                        padding: 0 0 0 0;
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
                    function LeaveRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:form id="form1">
                    <ice:panelBorder height="480" id="whole_page" renderCenter="#{Leave$LeaveRequestPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Leave$LeaveRequestPage.panelBorder1Bean.renderEast}" renderNorth="#{Leave$LeaveRequestPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Leave$LeaveRequestPage.panelBorder1Bean.renderSouth}" renderWest="#{Leave$LeaveRequestPage.panelBorder1Bean.renderWest}"
                        style="top: 5px; position: relative" styleClass="whole_page" width="1040">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 75px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Hetext desader -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style="height: 613px; top: 37px; position: relative">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height: 670px; left: 0px; top: 17px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 15px; position: absolute; width: 213px" styleClass="list_menu">
                                        <ice:panelCollapsible binding="#{Leave$LeaveRequestPage.colsEmployeeSearchByName}" id="colsEmployeeSearchByName" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup4" styleClass="">
                                                    <ice:outputText id="outputText7" value="Search Leave Requester"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid4" style="height: 200px; width: 100%;border:none">
                                                <ice:selectInputText action="#{Leave$LeaveRequestPage.txtSearchByName_action}"
                                                    binding="#{Leave$LeaveRequestPage.txtSearchByName}" id="txtSearchByName" immediate="true"
                                                    listValue="#{Leave$LeaveRequestPage.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                    style="left: 5px; top: 50px; position: absolute"
                                                    valueChangeListener="#{Leave$LeaveRequestPage.txtSearchByName_processValueChange}" width="200px">
                                                    <f:facet name="selectInputText">
                                                        <ice:panelGrid columnClasses="picCo,empIdCol,fullNameCol" columns="3" style="width:150px">
                                                            <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                            <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                </ice:selectInputText>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible binding="#{Leave$LeaveRequestPage.colsRequestLisrt}" id="colsRequestLisrt">
                                            <f:facet name="header">
                                                <ice:panelGroup id="panelGroup1" styleClass="">
                                                    <ice:outputText id="outputText3" value="Request"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="panelGrid1" width="100%">
                                                <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:225px; width: 100%">
                                                    <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                        <ice:selectOneListbox id="lisLeaveRequestList" partialSubmit="true" size="2"
                                                            style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 0px; top: -5px; position: absolute; width: 190px"
                                                            value="#{Leave$LeaveRequestPage.defaultSelectedData11.selectedObject}" valueChangeListener="#{Leave$LeaveRequestPage.lisLeaveRequestList_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$LeaveRequestPage.requestsLists}"/>
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
                            <ice:panelGroup id="page_display" style="height: 970px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 820px; left: 0px; position: relative; top: 65px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 850px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Leave Request"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: -10px; position: absolute; width: 100%">
                                            <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%" styleClass="filedset_normal">
                                                <ice:panelLayout id="panelDetail12" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 290px; left: 30px; top: 65px; position: absolute; width: 745px">
                                                    <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblFullNmae" style="font-size: 10px; left: 38px; top: 54px; position: absolute"
                                                        styleClass="font-size: 10px; left: 414px; top: 77px; position: absolute" value="#{msgLeave.fullName}"/>
                                                    <ice:outputText id="lblZerf" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                    <ice:outputText id="lblDirectorate" rendered="false"
                                                        style="font-size: 10px; left: 414px; top: 109px; position: absolute" value="Directorate "/>
                                                    <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnEmplyeeSearch_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnEmplyeeSearch}" id="btnEmplyeeSearch"
                                                        style="left: 380px; top: 9px; position: absolute; width: 90px" value="Search"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblFull_Name}" id="lblFull_Name"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblDepartment}" id="lblDepartment"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblPosition}" id="lblPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 370px" value=":"/>
                                                    <ice:outputText id="outputText8" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choMale}" disabled="true" id="choMale"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 171px; position: absolute" value="#{Leave$LeaveRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choFemale}" disabled="true" id="choFemale"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 171px; position: absolute" value="#{Leave$LeaveRequestPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText9" style="font-size: 11px; left: 175px; top: 168px; position: absolute" value="Male"/>
                                                    <ice:outputText id="outputText10" style="font-size: 11px; left: 260px; top: 171px; position: absolute" value="Female"/>
                                                    <ice:graphicImage binding="#{Leave$LeaveRequestPage.imgEmployeePicture}" height="194"
                                                        id="imgEmployeePicture"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 10px; position: absolute"
                                                        value="/Employee/images/blank.gif" width="172"/>
                                                    <ice:outputText id="outputText2" style="font-size: 11px; left: 38px; top: 205px; position: absolute" value=" Service Year In BUNNA"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblServiceYear}" id="lblServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 205px; position: absolute; width: 100px" value=":"/>
                                                    <ice:outputText id="lblEmployeeType" style="font-size: 11px; left: 38px; top: 239px; position: absolute" value="Employee Type"/>
                                                    <ice:outputText id="outputText20" style="font-size: 11px; left: 350px; top: 239px; position: absolute" value="Work-In"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choOffice" id="message7"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 155px; top: 265px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choAddisAbeba" id="message8"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 440px; top: 265px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmployeeID" id="message9"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 220px; top: 40px; position: absolute;z-index:500" warnClass="warnMessage"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choOffice}" disabled="true" id="choOffice"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 239px; position: absolute"
                                                        value="#{Leave$LeaveRequestPage.defaultSelectedData19.selectedBoolean}" valueChangeListener="#{Leave$LeaveRequestPage.choOffice_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choShift}" disabled="true" id="choShift"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 239px; position: absolute"
                                                        value="#{Leave$LeaveRequestPage.defaultSelectedData20.selectedBoolean}" valueChangeListener="#{Leave$LeaveRequestPage.choShift_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choAddisAbeba}" disabled="true"
                                                        id="choAddisAbeba" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 430px; top: 239px; position: absolute"
                                                        value="#{Leave$LeaveRequestPage.selectBooleanCheckbox3Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveRequestPage.choAddisAbeba_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choMugher}" disabled="true" id="choMugher"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 520px; top: 239px; position: absolute"
                                                        value="#{Leave$LeaveRequestPage.selectBooleanCheckbox4Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveRequestPage.choMugher_processValueChange}"/>
                                                    <ice:outputText id="lblOffice" style="font-size: 11px; left: 175px; top: 243px; position: absolute" value="Office"/>
                                                    <ice:outputText id="choShift1" style="font-size: 11px; left: 260px; top: 243px; position: absolute" value="Shift"/>
                                                    <ice:outputText id="lblAddisAbeba" style="font-size: 11px; left: 450px; top: 243px; position: absolute" value="Addis Abeba"/>
                                                    <ice:outputText id="lblMugher" style="font-size: 11px; left: 545px; top: 243px; position: absolute" value="OtherLocation"/>
                                                    <ice:outputText id="lblExternalServiceYear"
                                                        style="font-size: 11px; left: 300px; top: 205px; position: absolute" value="External  Service Year"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.txtExternalServiceYear}" id="txtExternalServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 420px; top: 205px; position: absolute; width: 100px" value=":"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyRequestInformation" layout="flow" style="border: 1px solid rgb(204, 204, 204); height: 265px; left: 30px; top: 365px; position: absolute; width: 745px">
                                                    <ice:outputText id="lblFromDate" style="font-size: 10px; left: 38px; top: 70px; position: absolute" value="From Date"/>
                                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtDateFrom}" id="txtDateFrom" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 70px; position: absolute; width: 190px"/>
                                                    <ice:outputText id="lblToDate" style="font-size: 10px; left: 480px; top: 80px; position: absolute" value="To Date"/>
                                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtDateTo}" disabled="true" id="txtDateTo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 78px; position: absolute; width: 190px"/>
                                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtAvilablDayes}" disabled="true" id="txtAvilablDayes" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 406px; top: 62px; position: absolute; width: 47px"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblAvailableLeaveDays}" id="lblAvailableLeaveDays"
                                                        style="font-size: 10px; left: 396px; top: 36px; position: absolute" value="Actually Can Used "/>
                                                    <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 36px; position: absolute" value="Leave Type"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnCalenderDateFrom_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnCalenderDateFrom}" id="btnCalenderDateFrom"
                                                        image="/resources/images/cal_button.gif" immediate="true" partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 325px; top: 73px; position: absolute" value="submit"/>
                                                    <ice:outputText id="outputText5"
                                                        style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Leave Request Information"/>
                                                    <ice:outputText id="lblReasonLeaveRequest"
                                                        style="font-size: 10px; left: 38px; top: 175px; position: absolute" value="Reason Leave Request"/>
                                                    <ice:inputTextarea binding="#{Leave$LeaveRequestPage.txtReason}" id="txtReason" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 168px; position: absolute; width: 560px"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblLeaveDays}" id="lblLeaveDays"
                                                        style="font-size: 10px; left: 38px; top: 104px; position: absolute" value="Leave Days"/>
                                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtLeaveDays}" id="txtLeaveDays" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 104px; position: absolute; width: 100px"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnCalculateLeave_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnCalculateLeave}" id="btnCalculateLeave"
                                                        style="left: 400px; top: 110px; position: absolute" value="Calculate Leave Days"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnAddLeaveRequest_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnAddLeaveRequest}" id="btnAddLeaveRequest"
                                                        style="left: 150px; top: 220px; position: absolute" value="Add To Table "/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choRequestbyHours}" id="choRequestbyHours"
                                                        partialSubmit="true" rendered="false"
                                                        style="background-color: rgb(242, 246, 240); left: 255px; top: 107px; position: absolute" value="#{Leave$LeaveRequestPage.defaultSelectedData12.selectedBoolean}"/>
                                                    <ice:outputText id="lblRequestbyHours" rendered="false"
                                                        style="font-size: 10px; left: 280px; top: 104px; position: absolute" value="Request by Hours"/>
                                                    <ice:selectOneMenu binding="#{Leave$LeaveRequestPage.drlLeaveType}" id="drlLeaveType" partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 35px; position: absolute; width: 190px"
                                                        value="#{Leave$LeaveRequestPage.defaultSelectedData13.selectedObject}" valueChangeListener="#{Leave$LeaveRequestPage.drlLeaveType_processValueChange}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$LeaveRequestPage.leaveType}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:selectInputDate binding="#{Leave$LeaveRequestPage.calRequestDate}" id="calRequestDate"
                                                        popupDateFormat="yyyy-MM-dd" renderYearAsDropdown="true" rendered="false"
                                                        style="left: 330px; top: 80px; position: absolute;z-index:10"
                                                        value="#{Leave$LeaveRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Leave$LeaveRequestPage.calRequestDate_processValueChange}"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlLeaveType" id="message1"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 200px; top: 50px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateFrom" id="message2"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 200px; top: 85px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtLeaveDays" id="message3"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 200px; top: 120px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtReason" id="message4"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 400px; top: 220px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateTo" id="message5"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 550px; top: 95px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAvilablDayes" id="message6"
                                                        infoClass="infoMessage"
                                                        style="color: red; font-size: 10px; font-weight: bold; left: 384px; top: 62px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:commandLink action="#{Leave$LeaveRequestPage.commandLink1_action}" id="commandLink1"
                                                        style="color: rgb(48, 102, 130); left: 550px; top: 240px; position: absolute; text-decoration: underline" value="View status of  this request"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnTime_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnTime}" id="btnTime" image="/resources/images/clock.png"
                                                        rendered="false"
                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 250px; top: 104px; position: absolute" value="submit"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblCaptionReturnTime}" id="lblCaptionReturnTime"
                                                        rendered="false" style="font-size: 10px; left: 420px; top: 104px; position: absolute" value="Return Time"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblReturnDate}" id="lblReturnDate" rendered="false"
                                                        style="border-width: 1px; background-color: rgb(242, 246, 240); border-bottom-color: rgb(115, 179, 206); border-bottom-style: solid; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 525px; top: 105px; position: absolute; width: 127px" value="outputText"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.choHafeDay}" id="choHafeDay"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 280px; top: 104px; position: absolute" value="#{Leave$LeaveRequestPage.defaultSelectedData18.selectedBoolean}"/>
                                                    <ice:outputText id="outputText26" style="font-size: 12px; left: 305px; top: 104px; position: absolute" value="½  Day "/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblAnualAvailableLeaveDays}"
                                                        id="lblAnualAvailableLeaveDays" style="font-size: 11px; left: 396px; top: 5px; position: absolute" value="Available Leave Days"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.lblAvailableAnnualLeave}" id="lblAvailableAnnualLeave"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 520px; top: 5px; position: absolute; width: 219px" value=":"/>
                                                    <ice:outputText id="lblReturnDateFromLeave"
                                                        style="font-size: 10px; left: 38px; top: 135px; position: absolute" value="Return Date"/>
                                                    <ice:outputText binding="#{Leave$LeaveRequestPage.txtReturnDateFromLeave}" id="txtReturnDateFromLeave"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 138px; position: absolute; width: 190px" value=":"/>
                                                </ice:panelLayout>
                                                <ice:panelLayout id="lyRequestInformationTable" style="border: 1px solid rgb(204, 204, 204); height: 100px; left: 30px; top: 640px; overflow: auto; position: absolute; width: 745px">
                                                    <ice:dataTable id="dataTable2" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                        value="#{Leave$LeaveRequestPage.leaveRequestTable}" var="currentRow">
                                                        <ice:column id="column1">
                                                            <ice:outputText id="outputText4" value="#{currentRow['leaveTypeDesc']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6" value="Leave Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column2">
                                                            <ice:outputText id="outputText11" value="#{currentRow['avilebelLeaveDayes']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText12" value="Available Leave Days or hours"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column4">
                                                            <ice:outputText id="outputText13" value="#{currentRow['fromDate']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText144" value="From Date"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column5">
                                                            <ice:outputText id="outputText14" value="#{currentRow['toDate']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText15" value="To Date"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column6">
                                                            <ice:outputText id="outputText16" value="#{currentRow['leaveDays']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText17" value="Leave Days or hours"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colRequestYerFrom">
                                                            <ice:outputText id="txtRequestYerFrom" value="#{currentRow['usedYear']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblRequestYerFrom" value="From Year"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colReturnDate">
                                                            <ice:outputText id="txtblReturnDate" value="#{currentRow['returnDatet']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblTblRetrunDate" value="Return Datet"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column7">
                                                            <ice:outputText id="outputText18" value="#{currentRow['reason']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText19" value="Reason Leave Request"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:outputText binding="#{Leave$LeaveRequestPage.lblEmploymentStatus}" id="lblEmploymentStatus"
                                                    style="color: rgb(204, 102, 0); font-size: 11px; font-weight: bold; left: 675px; top: 20px; position: absolute; text-align: center; width: 114px" value="Active"/>
                                                <ice:outputText id="lblStatusvalue1"
                                                    style="font-size: 11px; font-weight: bold; left: 550px; top: 20px; position: absolute" value="EMPLOYMENT STATUS :"/>
                                                <ice:outputText id="lblEmployeeInformation"
                                                    style="font-size: 11px; font-weight: bold; left: 55px; top: 45px; position: absolute" value="Employee Information"/>
                                                <ice:panelLayout id="lyLeaveRequest" rendered="true" style="border: 1px solid rgb(204, 204, 204); left: 30px; top: 750px; position: absolute; width: 735px">
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnNew_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnNew}" id="btnNew" partialSubmit="true"
                                                        style="margin-left: 40px; width: 80px" value="#{msgLeave.new}"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnSave_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnSave}" id="btnSave" style="margin-left: 40px; width: 80px" value="#{msgLeave.post}"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnEdit_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnEdit}" id="btnEdit" style="margin-left: 40px; width: 80px" value="#{msgLeave.edit}"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnUpdate_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnUpdate}" id="btnUpdate" style="margin-left: 40px; width: 80px" value="#{msgLeave.update}"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnReset_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnReset}" id="btnReset" immediate="true" partialSubmit="true"
                                                        style="margin-left: 40px; width: 80px" value="#{msgLeave.cancel}"/>
                                                    <ice:commandButton action="#{Leave$LeaveRequestPage.btnDelete_action}"
                                                        binding="#{Leave$LeaveRequestPage.btnDelete}" id="btnDelete" style="margin-left: 40px; width: 80px" value="#{msgLeave.delete}"/>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </ice:panelLayout>
                                        <ice:panelLayout binding="#{Leave$LeaveRequestPage.pnlLayoutTimePanel}" id="pnlLayoutTimePanel" rendered="false"
                                            style="border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                                            <ice:dataTable id="dataTableTime" rows="12"
                                                style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                                value="#{Leave$LeaveRequestPage.tableHour}" var="currentRow">
                                                <ice:column id="colStartDate12">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForColumn00_processAction}"
                                                        id="optTxtForColumn00" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                        onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col00']}"/>
                                                </ice:column>
                                                <ice:column id="colStartDate02">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForColumn02_processAction}"
                                                        id="optTxtForColumn02" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                        onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col10']}"/>
                                                </ice:column>
                                                <ice:column id="colStartTime04">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForolumn04_processAction}"
                                                        id="optTxtForolumn04" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                        onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col20']}"/>
                                                </ice:column>
                                                <ice:column id="colStartTime06">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForColumn06_processAction}"
                                                        id="optTxtForColumn06" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                        onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col30']}"/>
                                                </ice:column>
                                                <ice:column id="colStartTime08">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForColumn08_processAction}"
                                                        id="optTxtForColumn08" onmouseout="this.style.backgroundColor='rgb(255,255, 255)'"
                                                        onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col40']}"/>
                                                </ice:column>
                                                <ice:column id="colStartTime10">
                                                    <ice:commandLink actionListener="#{Leave$LeaveRequestPage.optTxtForColumn10_processAction}"
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
                                    </fieldset>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="south">
                            <ice:panelGroup id="page_footer">
                                <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                    <label
                                            style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright @ 2005-2006 Ethiopian Calander | <a
                                            href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |Information System Department  |Software Division.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnlPopUpSuccessOrFailure}" id="pnlPopUpSuccessOrFailure"
                        rendered="false" style="height: 80px;  width: 500px" styleClass="message">
                        <f:facet name="body">
                            <ice:panelLayout binding="#{Leave$LeaveRequestPage.message}" id="message" style="left:0px; top:0px; height: 50px;  width: 450px" styleClass="message">
                                <ice:outputText binding="#{Leave$LeaveRequestPage.lblFormMessage}" id="lblFormMessage"
                                    style=" font-size: 15px; font-weight: bold; width: 200px;  position:relative; left: 37px; top: 31px; position: absolute" value="vcvxcvc"/>
                            </ice:panelLayout>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Leave$LeaveRequestPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{Leave$LeaveRequestPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Leave$LeaveRequestPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnConfirmationForDelete}" clientOnly="true" draggable="false"
                        id="pnConfirmationForDelete" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 150px; left: 95px; top: 794px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationHeader" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationDeleteTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Leave$LeaveRequestPage.cmdConfirmationCloseDeleete_action}" id="cmdConfirmationCloseDeleete"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 690px; top: 3px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelConfirmationDelete" style="display: block; height: 100px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 70px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Leave$LeaveRequestPage.lblFormDeleteMessage}" id="lblFormDeleteMessage"
                                        style="background-color: rgb(245, 245, 245); left: 10px; top: 25px; position: absolute; text-align: center; vertical-align: middle" value="ARE YOU SURE YOU WANT TO DELETE LEAVE REQUEST OF"/>
                                    <ice:commandButton action="#{Leave$LeaveRequestPage.bntYES_action}" id="bntYES"
                                        style="left: 428px; top: 55px; position: absolute; width: 80px" value="Yes"/>
                                    <ice:commandButton action="#{Leave$LeaveRequestPage.button2_action}" id="button2"
                                        style="left: 540px; top: 55px; position: absolute; width: 80px" value="No"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnlFamilyList}" clientOnly="true" draggable="true" id="pnlFamilyList"
                        modal="true" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 250px; left: 97px; top: 226px; position: absolute; width: 600px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridTransionHistory"
                                style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="580">
                                <ice:outputText id="lblTransionHistoryTitle"
                                    style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="BUNNA INTERNATIONAL BANK: - Employee Family List"/>
                                <ice:commandLink action="#{Leave$LeaveRequestPage.cmdClose_action}" id="cmdClose" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 570px; top: 2px; position: absolute; width: 19px"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupTransionHistoryBody" style="display: block; height: 280px; position: relative; width: 550px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="panelLayout17"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 200px; overflow: auto; position: absolute; width: 480px" styleClass="message">
                                    <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                        value="#{Leave$LeaveRequestPage.familyList}" var="currentRow">
                                        <ice:column id="column3">
                                            <ice:outputText id="outputText21" value="#{currentRow['familyName']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText22" value="Family Full Name"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column8">
                                            <ice:outputText id="outputText23" value="#{currentRow['relationType']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText24" value="Relation Type"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column9">
                                            <ice:selectBooleanCheckbox binding="#{Leave$LeaveRequestPage.cboFamilyStatus}" id="cboFamilyStatus" value="#{currentRow['status']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="outputText31" value="Select"/>
                                            </f:facet>
                                        </ice:column>
                                    </ice:dataTable>
                                </ice:panelLayout>
                                <ice:commandButton action="#{Leave$LeaveRequestPage.btnSaveLIstOfPassAwayeEmployeeFamily_action}"
                                    id="btnSaveLIstOfPassAwayeEmployeeFamily" style="left: 50px; top: 240px; position: absolute; width: 118px" value="Passed Away"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                        id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 200px; left: 97px; top: 226px; position: absolute; width: 600px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridPopupViewPrevieousDecisions"
                                style="background-color: rgb(48, 102, 130);                              display: block; height: 27px" width="670">
                                <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                    style="color: white; margin-top: 8px; top: 8px; text-align: left; vertical-align: middle;width:90%" value="BUNNA HRMS - View request status "/>
                                <ice:commandLink action="#{Leave$LeaveRequestPage.btnClosePopupViewPrevieousDecisions_action}"
                                    id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; left: 653px; top: 0px; position: absolute; width: 19px"/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlLayoutViewPrevieousDecisions" style="display: block; height: 230px; position: relative; width: 640px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlLayoutPopupTable"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 200px; overflow: auto; position: absolute; width: 575px" styleClass="message">
                                    <ice:dataTable id="dataTable3" style="left: -5px; top: -10px; position: absolute; width: 112%"
                                        value="#{Leave$LeaveRequestPage.decisionsMadeOnRequest}" var="currentRow">
                                        <ice:column id="column10">
                                            <ice:outputText id="outputText25" value="#{currentRow['counter']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="headerTextNumber" value="NO"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column11">
                                            <ice:outputText id="outputText27" value="#{currentRow['givenDecision']}"/>
                                            <f:facet name="header">
                                                <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                            </f:facet>
                                        </ice:column>
                                        <ice:column id="column12">
                                            <ice:outputText id="outputText29" value="#{currentRow['deciderEmployeeId']}"/>
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
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveRequestPage.pnlPopUpAttachment}" clientOnly="true" draggable="true"
                        id="pnlPopUpAttachment" modal="true" rendered="false" style="display: block; height: 300px; left: 97px; top: 146px; position: absolute; width: 812px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpAttachment" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpAttachmentTitle" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System-Request Commented History"/>
                                <ice:commandButton action="#{Leave$LeaveRequestPage.modalPnlCloseBtnAttachment_action}" alt="Close"
                                    id="modalPnlCloseBtnAttachment" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                    style="left: 789px; top: -1px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlgroupPopUpAttach" style="display: block; height: 230px; position: relative; width: 762px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="lyAddressLocation"
                                    style="border: 1px solid rgb(204, 204, 204); height: 170px; left: 10px; top: 10px; overflow: auto; position: absolute; width: 744px" styleClass="insideContainerMain">
                                    <ice:outputText id="lblRegion" style="font-size: 10px; left: 19px; top: 20px; position: absolute" value="Region:"/>
                                    <ice:outputText escape="false" id="lblZone" style="font-size: 10px; left: 19px; top: 54px; position: absolute" value="Woreda:"/>
                                    <ice:outputText id="lblZoneOrCity" style="font-size: 10px; left: 396px; top: 20px; position: absolute" value="Zone/City"/>
                                    <ice:outputText id="lblKabele" style="font-weight: normal; left: 396px; top: 54px; position: absolute" value="Kabele :"/>
                                    <ice:outputText id="lblHouseNumber" style="font-size: 10px; left: 19px; top: 88px; position: absolute" value="HouseNumber:"/>
                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtHouseNumber}" id="txtHouseNumber" immediate="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240);                                                                 color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal;                                                                 left: 138px; top: 84px; position: absolute"/>
                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlRegion" id="message21" infoClass="infoMessage"
                                        style="font-size: 10px; left: 200px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlZoneOrCity" id="message22" infoClass="infoMessage"
                                        style="font-size: 10px; left: 570px; top: 38px; position: absolute" warnClass="warnMessage"/>
                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlWoreda" id="message23" infoClass="infoMessage"
                                        style="font-size: 10px; left: 200px; top: 74px; position: absolute" warnClass="warnMessage"/>
                                    <ice:selectOneMenu binding="#{Leave$LeaveRequestPage.drlZoneOrCity}" id="drlZoneOrCity" partialSubmit="true"
                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 14px; position: absolute; width: 190px"
                                        value="#{Leave$LeaveRequestPage.defaultSelectedData16.selectedObject}" valueChangeListener="#{Leave$LeaveRequestPage.drlZoneOrCity_processValueChange}">
                                        <f:selectItems id="selectOneMenu3selectItems" value="#{Leave$LeaveRequestPage.zoneList}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Leave$LeaveRequestPage.drlRegion}" id="drlRegion" partialSubmit="true"
                                        style="border: 1px solid rgb(115, 179, 206); left: 138px; top: 14px; position: absolute; width: 190px"
                                        value="#{Leave$LeaveRequestPage.defaultSelectedData14.selectedObject}" valueChangeListener="#{Leave$LeaveRequestPage.drlRegion_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Leave$LeaveRequestPage.regionOpt}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Leave$LeaveRequestPage.drlWoreda}" id="drlWoreda" partialSubmit="true"
                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 138px; top: 50px; position: absolute; width: 190px"
                                        value="#{Leave$LeaveRequestPage.defaultSelectedData15.selectedObject}" valueChangeListener="#{Leave$LeaveRequestPage.drlWoreda_processValueChange}">
                                        <f:selectItems id="selectOneMenu2selectItems" value="#{Leave$LeaveRequestPage.woredaList}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Leave$LeaveRequestPage.drlKabele}" id="drlKabele" partialSubmit="true"
                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 50px; position: absolute; width: 150px;border: 1px solid rgb(115, 179, 206);" value="#{Leave$LeaveRequestPage.defaultSelectedData17.selectedObject}">
                                        <f:selectItems id="selectOneMenu4selectItems" value="#{Leave$LeaveRequestPage.kebeleList}"/>
                                    </ice:selectOneMenu>
                                    <ice:outputText id="lblTelephoneMoblie" style="font-size: 10px; left: 19px; top: 122px; position: absolute" value="Telephone Moblie"/>
                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtTelephoneMoblie}" id="txtTelephoneMoblie" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 138px; top: 120px; position: absolute; width: 180px"/>
                                    <ice:outputText id="lblTelephoneHome" style="font-size: 10px; left: 396px; top: 88px; position: absolute" value="Telephone Home"/>
                                    <ice:inputText binding="#{Leave$LeaveRequestPage.txtlblTelephoneHome}" id="txtlblTelephoneHome" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 84px; position: absolute; width: 180px"/>
                                </ice:panelLayout>
                                <ice:commandButton action="#{Leave$LeaveRequestPage.btnUpdateAddress_action}" id="btnUpdateAddress"
                                    style="left: 50px; top: 200px; position: absolute; width: 94px" value="Update"/>
                                <ice:outputText binding="#{Leave$LeaveRequestPage.lblErrorMessage}" id="lblErrorMessage" style="color: rgb(255, 0, 0); font-size: 10px; left: 100px; top: 180px; position: absolute; width: 474px"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
