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
                    function LeaveSettlemen(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                         <!--
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$LeaveSettlemen.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$LeaveSettlemen.panelBorder1Bean.renderEast}" renderNorth="#{Leave$LeaveSettlemen.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$LeaveSettlemen.panelBorder1Bean.renderSouth}" renderWest="#{Leave$LeaveSettlemen.panelBorder1Bean.renderEast}"
                            style="top: 0px; position: relative" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                 
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height: 55px; width: 100%">
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
                                                            <ice:commandLink id="lnkPayrollPeriodLists" style="color:#333333;font-weight:bold" value="Workflow Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPayrollSetUp" style="color:#333333;font-weight:bold" value="Workflow Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkAccrualEntries" style="color:#333333;font-weight:bold" value="Workflow User Group Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkPersonalDeductions" style="color:#333333;font-weight:bold" value="Workflow States Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink id="lnkGovernmentDeductions" style="color:#333333;font-weight:bold" value="Workflow Transition Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Status"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:310px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%">
                                                          
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                               

                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Payroll List and assign a dedecated person"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 686px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelDetail12" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 290px; left: 30px; top: 65px; position: absolute; width: 745px">
                                                        <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                        <ice:inputText id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblFullNmae" style="font-size: 10px; left: 38px; top: 54px; position: absolute"
                                                            styleClass="font-size: 10px; left: 414px; top: 77px; position: absolute" value="Full Name"/>
                                                        <ice:outputText id="lblZerf" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                        <ice:outputText id="lblDirectorate" rendered="false"
                                                            style="font-size: 10px; left: 414px; top: 109px; position: absolute" value="Directorate "/>
                                                        <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                        <ice:commandButton action="#{Leave$LeaveSettlemen.btnEmplyeeSearch_action}" id="btnEmplyeeSearch"
                                                            style="left: 380px; top: 9px; position: absolute; width: 90px" value="Search"/>
                                                        <ice:outputText id="lblFull_Name"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value="outputText"/>
                                                        <ice:outputText id="lblDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value="outputText"/>
                                                        <ice:outputText id="lblPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 370px" value="outputText"/>
                                                        <ice:outputText id="outputText8" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                        <ice:outputText id="outputText9" style="font-size: 11px; left: 175px; top: 168px; position: absolute" value="Male"/>
                                                        <ice:outputText id="outputText10" style="font-size: 11px; left: 260px; top: 171px; position: absolute" value="Female"/>
                                                        <ice:graphicImage height="194" id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 10px; position: absolute"
                                                            value="/Employee/images/blank.gif" width="172"/>
                                                        <ice:outputText id="outputText2" style="font-size: 11px; left: 38px; top: 205px; position: absolute" value="Total Service Year"/>
                                                        <ice:outputText id="lblServiceYear"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 205px; position: absolute; width: 170px" value="outputText"/>
                                                        <ice:outputText id="lblEmployeeType" style="font-size: 11px; left: 38px; top: 239px; position: absolute" value="Employee Type"/>
                                                        <ice:outputText id="outputText20" style="font-size: 11px; left: 350px; top: 239px; position: absolute" value="Work-In"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choOffice" id="message7"
                                                            infoClass="infoMessage" style="font-size: 11px; left: 155px; top: 265px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="choAddisAbeba" id="message8"
                                                            infoClass="infoMessage" style="font-size: 11px; left: 440px; top: 265px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmployeeID" id="message9"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 220px; top: 40px; position: absolute;z-index:500" warnClass="warnMessage"/>
                                                        <ice:outputText id="lblOffice" style="font-size: 11px; left: 175px; top: 243px; position: absolute" value="Office"/>
                                                        <ice:outputText id="choShift1" style="font-size: 11px; left: 260px; top: 243px; position: absolute" value="Shift"/>
                                                        <ice:outputText id="lblAddisAbeba" style="font-size: 11px; left: 450px; top: 243px; position: absolute" value="Addis Abeba"/>
                                                        <ice:outputText id="lblMugher" style="font-size: 11px; left: 545px; top: 243px; position: absolute" value="Mugher"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.choMale}" id="choMale" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 171px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.choFemale}" id="choFemale"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 171px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.selectBooleanCheckbox3}"
                                                            id="selectBooleanCheckbox3" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 239px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.choShift}" id="choShift" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 239px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.choAddisAbeba}" id="choAddisAbeba"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 430px; top: 239px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox5Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlemen.choMugher}" id="choMugher"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 520px; top: 239px; position: absolute" value="#{Leave$LeaveSettlemen.selectBooleanCheckbox6Bean.selectedBoolean}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformation" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 223px; left: 30px; top: 365px; position: absolute; width: 745px">
                                                        <ice:outputText id="lblFromDate" style="font-size: 10px; left: 38px; top: 70px; position: absolute" value="From Date"/>
                                                        <ice:inputText id="txtDateFrom" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 70px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblToDate" style="font-size: 10px; left: 450px; top: 70px; position: absolute" value="To Date"/>
                                                        <ice:inputText disabled="true" id="txtDateTo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 68px; position: absolute; width: 190px"/>
                                                        <ice:inputText disabled="true" id="txtAvilablDayes" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 34px; position: absolute; width: 140px"/>
                                                        <ice:outputText id="lblAvailableLeaveDays"
                                                            style="font-size: 10px; left: 396px; top: 36px; position: absolute" value="Available Leave Days"/>
                                                        <ice:outputText id="outputText1" style="font-size: 10px; left: 38px; top: 36px; position: absolute" value="Leave Type"/>
                                                        <ice:commandButton id="btnCalenderDateFrom" image="/Employee/images/calendar.gif" immediate="true"
                                                            partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 325px; top: 73px; position: absolute" value="submit"/>
                                                        <ice:outputText id="outputText5"
                                                            style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Leave Request Information"/>
                                                        <ice:outputText id="lblReasonLeaveRequest"
                                                            style="font-size: 10px; left: 38px; top: 145px; position: absolute" value="Reason Leave Request"/>
                                                        <ice:inputTextarea id="txtReason" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 138px; position: absolute; width: 560px"/>
                                                        <ice:outputText id="lblLeaveDays" style="font-size: 10px; left: 38px; top: 104px; position: absolute" value="Leave Days"/>
                                                        <ice:inputText id="txtLeaveDays" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 104px; position: absolute; width: 100px"/>
                                                        <ice:commandButton id="btnCalculateLeave" style="left: 400px; top: 95px; position: absolute" value="Calculate Leave Days"/>
                                                        <ice:outputText id="lblRequestbyHours" rendered="false"
                                                            style="font-size: 10px; left: 280px; top: 104px; position: absolute" value="Request by Hours"/>
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
                                                            style="color: red; font-size: 10px; font-weight: bold; left: 400px; top: 190px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateTo" id="message5"
                                                            infoClass="infoMessage"
                                                            style="color: red; font-size: 10px; font-weight: bold; left: 550px; top: 85px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAvilablDayes" id="message6"
                                                            infoClass="infoMessage"
                                                            style="color: red; font-size: 10px; font-weight: bold; left: 550px; top: 50px; position: absolute" warnClass="warnMessage"/>
                                                        <ice:commandButton id="btnTime" image="/resources/images/clock.png" rendered="false"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 250px; top: 104px; position: absolute" value="submit"/>
                                                        <ice:outputText id="lblCaptionReturnTime" rendered="false"
                                                            style="font-size: 10px; left: 420px; top: 104px; position: absolute" value="Return Time"/>
                                                        <ice:outputText id="lblReturnDate" rendered="false"
                                                            style="border-width: 1px; background-color: rgb(242, 246, 240); border-bottom-color: rgb(115, 179, 206); border-bottom-style: solid; color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 525px; top: 105px; position: absolute; width: 127px" value="outputText"/>
                                                        <ice:selectOneMenu id="selectOneMenu1" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 35px; position: absolute; width: 190px" value="#{Leave$LeaveSettlemen.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$LeaveSettlemen.selectOneMenu1DefaultItems}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                               
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="margin-left:10px;color:#333333;">Information Network Security Agency |Directorate Of Research Technology |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                         -->
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
