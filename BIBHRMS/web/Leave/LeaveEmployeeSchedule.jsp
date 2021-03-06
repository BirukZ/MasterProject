<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : dereje
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
                        border: solid 1px #BD8;


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
                    function LeaveEmployeeSchedule(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
              <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgst"/>
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$LeaveEmployeeSchedule.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$LeaveEmployeeSchedule.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$LeaveEmployeeSchedule.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$LeaveEmployeeSchedule.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$LeaveEmployeeSchedule.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border-style: none; height: 400px; top: -50px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px; left: 0px; position: relative; width: 100%;-rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 0px; top: 48px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="Search Area"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" style="height: 200px; width: 100%;border:none">
                                                    <ice:selectInputText action="#{Leave$LeaveEmployeeSchedule.txtSearchByName_action}" id="txtSearchByName"
                                                        immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                        rows="10" style="left: 5px; top: 50px; position: absolute"
                                                        valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                        <f:facet name="selectInputText">
                                                            <ice:panelGrid columnClasses="picCo,empIdCol,fullNameCol" columns="3" style="width:150px">
                                                                <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                            </ice:panelGrid>
                                                        </f:facet>
                                                    </ice:selectInputText>
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
                                                            <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.lnkPayrollPeriodLists_action}"
                                                                id="lnkPayrollPeriodLists" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.lnkPayrollSetUp_action}" id="lnkPayrollSetUp"
                                                                style="color:#333333;font-weight:bold" value="Leave Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.lnkAccrualEntries_action}"
                                                                id="lnkAccrualEntries" style="color:#333333;font-weight:bold" value=" Leave Balance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.lnkPersonalDeductions_action}"
                                                                id="lnkPersonalDeductions" style="color:#333333;font-weight:bold" value="Leave Transfer Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.lnkGovernmentDeductions_action}"
                                                                id="lnkGovernmentDeductions" style="color:#333333;font-weight:bold" value="Leave Transfer Approve"/>
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
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 187px; width: 100%"/>
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
                                        style="height: 775px; left: 0px; top: 65px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 920px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Leave Schedule"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 900px; left: 0px; top: 30px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 860px" styleClass="filedset_border">
                                                    <ice:outputText id="lblEmployeementHistory"
                                                        style="font-size: 11px; font-weight: bold; left: 30px; top: 20px; position: absolute" value="#{msgst.empInfo}"/>
                                                    <label style="left: 20px; top: 40px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <ice:outputText escape="false" id="lblEmployeeId"
                                                        style="font-size: 12px; left: 38px; top: 65px; position: absolute" value="#{msgst.empId}"/>
                                                    <ice:outputText id="outputText5" style="font-size: 12px; left: 35px; top: 245px; position: absolute" value="Job Position :"/>
                                                    <ice:outputText id="outputText6" style="font-size: 12px; left: 38px; top: 105px; position: absolute" value="Full Name :"/>
                                                    <ice:outputText id="outputText8" style="font-size: 12px; left: 35px; top: 145px; position: absolute" value="#{msgst.gender}"/>
                                                    <ice:outputText escape="false" id="lbltotalServiceYear"
                                                        style="font-size: 12px; left: 35px; top: 285px; position: absolute" value="#{msgst.totalServiceYear}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveEmployeeSchedule.cbMale}" disabled="true" id="cbMale"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 150px; top: 145px; position: absolute" value="#{Leave$LeaveEmployeeSchedule.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                    <ice:outputText id="lblMale" style="font-size: 12px; left: 184px; top: 145px; position: absolute" value="#{msgst.male}"/>
                                                    <ice:outputText id="outputText18" style="font-size: 12px; left: 290px; top: 145px; position: absolute" value="#{msgst.female}"/>
                                                    <ice:inputText binding="#{Leave$LeaveEmployeeSchedule.txtEmployeeId}" disabled="true" id="txtEmployeeId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 60px; position: absolute; width: 145px"/>
                                                    <ice:outputText id="outputText43" style="font-size: 12px; left: 35px; top: 185px; position: absolute" value="Department :"/>
                                                    <ice:outputText id="lblhiredDate" style="font-size: 12px; left: 444px; top: 285px; position: absolute" value="#{msgst.hiredDate}"/>
                                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnSearch_action}" id="btnSearch"
                                                        partialSubmit="true" style="left: 310px; top: 47px; position: absolute; width: 105px" value="Search"/>
                                                    <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblDepartment}" id="lblDepartment" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 175px; position: absolute; width: 392px"/>
                                                    <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblServiceYear}" id="lblServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 285px; position: absolute; text-align: center; width: 200px" value=":"/>
                                                    <ice:graphicImage binding="#{Leave$LeaveEmployeeSchedule.imgEmployeePicture}" height="200"
                                                        id="imgEmployeePicture" ismap="true" lang="1000"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 64px; position: absolute"
                                                        value="/Employee/images/blank.gif" width="172"/>
                                                    <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblHireDate}" id="lblHireDate"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 285px; position: absolute; text-align: center; width: 209px" value=":"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEmployeeId" id="message3"
                                                        infoClass="infoMessage" style="font-family: Cambria; left: 150px; top: 85px; position: absolute" warnClass="warnMessage"/>
                                                    <ice:panelLayout id="panelLayout1" style="border-top: solid rgb(204, 204, 204) 1px; height: 520px; left: 24px; top: 335px; position: absolute; width: 725px">
                                                        <ice:panelLayout id="pnlAccrualEntry1" layout="flow" style="border-bottom: groove rgb(153, 153, 153) 1px; height: 140px; left: 0px; top: 0px; position: absolute; width: 718px; -rave-layout: grid">
                                                            <ice:outputText id="lpanelLayout1blSelectResignresign1" rendered="false"
                                                                style="font-size: 10px; left: 38px; top: 305px; position: absolute" value="#{msgst.selectResignReason}"/>
                                                            <ice:outputText id="lblUsedLeaveAmount2"
                                                                style="font-size: 12px; left: 10px; top: 20px; position: absolute; text-align: left; vertical-align: top; width: 115px" value="Available Annual Leave "/>
                                                            <ice:outputText id="lblUsedLeaveAmount4"
                                                                style="font-size: 12px; left: 10px; top: 65px; position: absolute; text-align: left; vertical-align: top; width: 119px" value="Annual Leave Extended From Previous Years"/>
                                                            <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblAvailableAnnualLeave}"
                                                                id="lblAvailableAnnualLeave"
                                                                style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 30px; position: absolute; width: 356px" value=":"/>
                                                            <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblExtendedLeave}" id="lblExtendedLeave"
                                                                style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 65px; position: absolute; width: 356px" value=":"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlSecheduleDate" layout="flow" style="border-bottom: groove rgb(153, 153, 153) 1px; height: 330px; left: 0px; top: 150px; position: absolute; width: 718px; -rave-layout: grid">
                                                            <ice:panelLayout id="panelLayout18" style="border: 1px solid rgb(204, 204, 204); height: 111px; left: 0px; top: 130px; overflow: auto; position: relative; width: 720px">
                                                                <ice:dataTable id="dataTable1" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                                    value="#{Leave$LeaveEmployeeSchedule.listOfSchedule}" var="currentRow">
                                                                    <ice:column groupOn="#{currentRow['scheduleYear']}" id="column1" style="width: 30%">
                                                                        <ice:outputText id="outputText1" value="#{currentRow['scheduleYear']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText3" value="Schedule For"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rwSelectorLeaveSchedule" immediate="true" multiple="false"
                                                                            selectionListener="#{Leave$LeaveEmployeeSchedule.rwSelectorLeaveSchedule_processMyEvent}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                    <ice:column id="column2">
                                                                        <ice:outputText id="outputText4" value="#{currentRow['monthDescription']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="outputText7" style="text-align: center" value="Month"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colDays">
                                                                        <ice:outputText id="colTxtDays" value="#{currentRow['days']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="colLblDays" style="text-align: center" value="Days"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:inputTextarea binding="#{Leave$LeaveEmployeeSchedule.txtRemark}" id="txtRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 50px; left: 0px; top: 270px; position: absolute; width: 720px"/>
                                                            <ice:outputLabel id="outputLabel7"
                                                                style="font-size: 12px; left: 10px; top: 250px; position: absolute" value="Remark"/>
                                                            <ice:selectOneMenu binding="#{Leave$LeaveEmployeeSchedule.drlMonths}" id="drlMonths"
                                                                partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 525px; top: 15px; position: absolute; width: 190px" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData5.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Leave$LeaveEmployeeSchedule.listofMonth}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputText id="lblMonths"
                                                                style="font-size: 12px; left: 435px; top: 20px; position: absolute; text-align: left; vertical-align: top; width: 70px" value="Months"/>
                                                            <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnAdd_action}"
                                                                binding="#{Leave$LeaveEmployeeSchedule.btnAdd}" id="btnAdd"
                                                                style="left: 400px; top: 90px; position: absolute; width: 100px" value="Add"/>
                                                            <ice:outputText id="lblDays"
                                                                style="font-size: 12px; left: 5px; top: 70px; position: absolute; text-align: left; vertical-align: top; width: 84px" value="Days"/>
                                                            <ice:inputText binding="#{Leave$LeaveEmployeeSchedule.txtDays}" id="txtDays" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 70px; position: absolute; width: 92px"/>
                                                            <ice:outputText id="outputText9"
                                                                style="font-size: 12px; left: 5px; top: 20px; position: absolute; text-align: left; vertical-align: top; width: 115px" value="Schedule For"/>
                                                            <ice:selectOneMenu binding="#{Leave$LeaveEmployeeSchedule.drlScheduleFor}" id="drlScheduleFor"
                                                                partialSubmit="true"
                                                                style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 122px; top: 15px; position: absolute; width: 190px" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData7.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Leave$LeaveEmployeeSchedule.pysicalLeaveTypes}"/>
                                                            </ice:selectOneMenu>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlSecheduleDateButton" layout="flow"
                                                            style="left: 0px; top: 490px; position: absolute; width: 718px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnSaveLeaveBalance_action}"
                                                                binding="#{Leave$LeaveEmployeeSchedule.btnSaveLeaveBalance}" disabled="true"
                                                                id="btnSaveLeaveBalance" style="margin-left: 40px; width: 80px" value="Save"/>
                                                            <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnDeleteLeaveBalance_action}"
                                                                binding="#{Leave$LeaveEmployeeSchedule.btnDeleteLeaveBalance}" id="btnDeleteLeaveBalance"
                                                                immediate="true" partialSubmit="true" style="margin-left: 40px; width: 80px" value="Delete"/>
                                                            <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.button1_action}" id="button1"
                                                                style="margin-left: 40px; width: 80px" value="Cancel"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 105px; position: absolute; width: 356px" value=":"/>
                                                    <ice:outputText binding="#{Leave$LeaveEmployeeSchedule.lblJobPosition}" id="lblJobPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 245px; position: absolute; width: 260px" value=":"/>
                                                    <ice:selectBooleanCheckbox binding="#{Leave$LeaveEmployeeSchedule.cbFemale}" disabled="true" id="cbFemale"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left:250px; top: 145px; position: absolute" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData6.selectedBoolean}"/>
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
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK Human Resource Management System - Leave Schedule.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveEmployeeSchedule.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                            modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$LeaveEmployeeSchedule.modalPnlCloseMesssage_action}"
                                        binding="#{Leave$LeaveEmployeeSchedule.modalPnlCloseMesssage}" id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$LeaveEmployeeSchedule.lblFormMessage}" id="lblFormMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveEmployeeSchedule.pnlPopUpMsg}" draggable="true" id="pnlPopUpMsg" modal="true"
                            rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblPopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupPopUpMsgBody" style="display: block; height: 94px; position: relative; width: 586">
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnPopUpNo_action}" id="btnPopUpNo"
                                        style="left: 480px; top: 60px; position: absolute; width: 70px" value="NO" visible="true"/>
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnPopUpYes_action}" id="btnPopUpYes"
                                        style="left: 370px; top: 60px; position: absolute; width: 70px" value="Yes" visible="true"/>
                                    <ice:outputText id="lblPopUpMsgMain"
                                        style="font-family: Georgia,'Times New Roman',times,serif; font-size: 18px; left: 40px; top: 15px; position: absolute; text-align: left; width: 478px" value="Are you sure you want to delete ?"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Leave$LeaveEmployeeSchedule.pnlPopUpSchedule}" clientOnly="true" draggable="true" id="pnlPopUpSchedule"
                            rendered="false" style="display: block; height: 245px; left: 120px; top: 0px; position: absolute; width: 440px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpDateSetting1" styleClass="icePnlGrp popupHeaderWrapper">
                                    <ice:outputText id="popUpAttachmentDateSetting1" style="width:400px" value="Employee Annual Leave Schedule"/>
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.modalPnlCloseBtnDateSetting1_action}" alt="Close"
                                        id="modalPnlCloseBtnDateSetting1" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 458px; top: 2px; position: absolute" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="lblDDID2" style="display: block; height: 193px; position: relative; width: 450px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:outputLabel id="outputLabel1"
                                        style="left: 10px; top: 35px; position: absolute; text-align: left; vertical-align: top; width: 84px" value=" Annual Leave Year:"/>
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnSaveSchedule_action}" id="btnSaveSchedule"
                                        style="left: 230px; top: 140px; position: absolute; width: 200px" value="Save"/>
                                    <ice:outputLabel id="lblDDID3" rendered="false"/>
                                    <label></label>
                                    <label></label>
                                    <ice:selectBooleanCheckbox id="chkActive" partialSubmit="true" style="left: 350px; top: 40px; position: absolute" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData2.selectedBoolean}"/>
                                    <ice:selectOneMenu id="ddnYear" partialSubmit="true"
                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 100px; top: 38px; position: absolute; width: 170px" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData1.selectedObject}">
                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Leave$LeaveEmployeeSchedule.pysicalLeaveTypes}"/>
                                    </ice:selectOneMenu>
                                    <!--   <ice:selectOneMenu binding="#{Leave$LeaveEmployeeSchedule.ddnYear}" id="ddnYear"
                                                                    partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 100px; top: 38px; position: absolute; width: 170px"
                                                                    value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData130.selectedObject}">
                                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Leave$LeaveEmployeeSchedule.pysicalLeaveTypes}"/>
                                                                </ice:selectOneMenu>-->
                                    <ice:outputLabel id="outputLabel2" style="left: 10px; top: 80px; position: absolute" value="Start Date"/>
                                    <ice:outputLabel id="outputLabel3" style="left: 10px; top: 118px; position: absolute" value="End Date"/>
                                    <ice:inputText binding="#{Leave$LeaveEmployeeSchedule.txtStrartDate}" id="txtStrartDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 100px; top: 80px; position: absolute; width: 170px"/>
                                    <ice:inputText binding="#{Leave$LeaveEmployeeSchedule.txtEndDate}" id="txtEndDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 100px; top: 118px; position: absolute; width: 170px"/>
                                    <ice:outputLabel id="outputLabel4" style="left:300px; top: 35px; position: absolute" value="Active"/>
                                    <!-- <ice:selectBooleanCheckbox binding="#{Leave$LeaveEmployeeSchedule.chkActive}" id="chkActive"
                                                                    partialSubmit="true" style="left: 350px; top: 40px; position: absolute" value="#{Leave$LeaveEmployeeSchedule.defaultSelectedData131.selectedBoolean}"/>-->
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnStartDate_action}"
                                        binding="#{Leave$LeaveEmployeeSchedule.btnStartDate}" id="btnStartDate" image="/Employee/images/calendar.gif"
                                        immediate="true"
                                        style="border-width: 1px; background-color: rgb(242, 246, 240);left: 254px; top: 80px; position: absolute" value="submit"/>
                                    <ice:commandButton action="#{Leave$LeaveEmployeeSchedule.btnEndDate_action}"
                                        binding="#{Leave$LeaveEmployeeSchedule.btnEndDate}" id="btnEndDate" image="/Employee/images/calendar.gif"
                                        immediate="true" style="left: 254px; top: 120px; position: absolute" value="submit"/>
                                    <!--  <ice:selectInputDate binding="#{Leave$LeaveEmployeeSchedule.calEndDate}" id="calEndDate"
                                                                    rendered="false"
                                                                    style="height: 212px; left: 264px; top: 120px; position: absolute; width: 190px"
                                                                    value="#{Leave$LeaveEmployeeSchedule.selectInputDate1Bean.date1}" valueChangeListener="#{Leave$LeaveEmployeeSchedule.calEndDate_processValueChange}"/>
                                                                <ice:selectInputDate binding="#{Leave$LeaveEmployeeSchedule.calStartDate}" id="calStartDate"
                                                                    rendered="false"
                                                                    style="height: 212px; left: 264px; top: 96px; position: absolute; width: 190px"
                                                                    value="#{Leave$LeaveEmployeeSchedule.selectInputDateBean2.date1}" valueChangeListener="#{Leave$LeaveEmployeeSchedule.calStartDate_processValueChange}"/>-->
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
