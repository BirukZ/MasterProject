<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Aprile 16, 2011, 7:48:31 AM
    Author     : ONE1423
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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                    var LeaveSettlementPage=jQuery.noConflict();
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$LeaveSettlementPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$LeaveSettlementPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$LeaveSettlementPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$LeaveSettlementPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$LeaveSettlementPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 783px">
                                    <ice:panelLayout id="left_menu1" layout="flow" style="height: 467px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 467px; left: 5px; top: 16px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height: 120px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveSettlementPage.lnkDisciplineApprove_action}"
                                                                id="lnkDisciplineApprove" style="color:#333333;font-weight:bold" value=" Leave Balance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveSettlementPage.lnkDisciplineRequest_action}"
                                                                id="lnkDisciplineRequest" style="color:#333333;font-weight:bold" value="Leave Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveSettlementPage.lnkDisciplinePenality_action}"
                                                                id="lnkDisciplinePenality" style="color:#333333;font-weight:bold" value=" Leave Balance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$LeaveSettlementPage.lnkCommitteeMembers_action}"
                                                                id="lnkCommitteeMembers" style="color:#333333;font-weight:bold" value="Leave Transfer Request"/>
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
                                                            <ice:outputLabel id="lblMsgStatusForRequest"
                                                                style="color: white; font-weight: bold; margin-left: 20px; margin-top: 65px; left: 20px; position: absolute; width: 187px" value="Request History  Board"/>
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
                                        style="height: 805px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 770px;">
                                            <ice:panelLayout id="pnProfile" style="height: 773px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelTabSet id="panelTabSet1" rows="1" selectedIndex="1"
                                                    style="height: 720px; left: 0px; top: 0px; position: absolute; width: 99%"
                                                    tabChangeListener="#{Leave$LeaveSettlementPage.panelTabSet1_processTabChange}" tabPlacement="Top">
                                                    <ice:panelTab id="tabChangeLeaveType" label="Change Used Leave Type ">
                                                        <ice:panelLayout id="panelLayout22" style="height: 700px; top: 0px; position: inherit; width: 100%">
                                                            <ice:panelLayout id="pnProfile122" style="height: 670px; left: 0px; top: -20px; position: relative; width: 750px">
                                                                <ice:outputText id="lblEmployeeID"
                                                                    style="font-size: 12px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                                <ice:outputText id="lblFullNmae"
                                                                    style="font-size: 12px; left: 38px; top: 54px; position: absolute"
                                                                    styleClass="font-size: 10px; left: 414px; top: 77px; position: absolute" value="FullName"/>
                                                                <ice:outputText id="lblZerf" style="font-size: 12px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                                <ice:outputText id="lblDirectorate" rendered="false"
                                                                    style="font-size: 10px; left: 414px; top: 109px; position: absolute" value="Directorate "/>
                                                                <ice:outputText id="lblJobPosition"
                                                                    style="font-size: 12px; left: 38px; top: 142px; position: absolute" value="Job Position"/>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnEmplyeeSearch_action}"
                                                                    binding="#{Leave$LeaveSettlementPage.btnEmplyeeSearch}" id="btnEmplyeeSearch"
                                                                    style="left: 380px; top: 9px; position: absolute; width: 90px" value="Search"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblFull_Name}" id="lblFull_Name"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblDepartment}" id="lblDepartment"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblPosition}" id="lblPosition"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 142px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText8"
                                                                    style="font-size: 12px; left: 38px; top: 176px; position: absolute" value="Gendert:"/>
                                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlementPage.choMale}" disabled="true"
                                                                    id="choMale" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 176px; position: absolute"
                                                                    value="#{Leave$LeaveSettlementPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Leave$LeaveSettlementPage.choMale_processValueChange}"/>
                                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlementPage.choFemale}" disabled="true"
                                                                    id="choFemale" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 176px; position: absolute" value="#{Leave$LeaveSettlementPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                                <ice:outputText id="outputText9"
                                                                    style="font-size: 11px; left: 175px; top: 173px; position: absolute" value="Male"/>
                                                                <ice:outputText id="outputText10"
                                                                    style="font-size: 11px; left: 260px; top: 173px; position: absolute" value="Female"/>
                                                                <ice:graphicImage binding="#{Leave$LeaveSettlementPage.imgEmployeePicture}" height="194"
                                                                    id="imgEmployeePicture"
                                                                    style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 10px; position: absolute"
                                                                    value="/Employee/images/blank.gif" width="172"/>
                                                                <ice:outputText id="lblServiceYear1"
                                                                    style="font-size: 12px; left: 38px; top: 210px; position: absolute" value="Total Service Year"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblServiceYear}" id="lblServiceYear"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 210px; position: absolute; width: 170px" value="outputText"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 420px; left: 18px; top: 300px; position: absolute; width: 745px">
                                                                <ice:outputText id="lblAssignedDate"
                                                                    style="font-size: 12px; left: 38px; top: 290px; position: absolute" value="Start Date"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtStartDate}" disabled="true"
                                                                    id="txtStartDate" partialSubmit="true"
                                                                    style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 290px; position: absolute; width: 190px" valueChangeListener="#{Leave$LeaveSettlementPage.txtStartDate_processValueChange}"/>
                                                                <ice:outputText id="lblEndDate"
                                                                    style="font-size: 12px; left: 396px; top: 290px; position: absolute" value="End Date"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtEndDate}" disabled="true" id="txtEndDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 290px; position: absolute; width: 190px"/>
                                                                <ice:outputText id="lblLeaveTypeTo"
                                                                    style="font-size: 12px; left: 396px; top: 216px; position: absolute" value="Leave Type To"/>
                                                                <ice:outputText id="lblLeaveTypeFrom"
                                                                    style="font-size: 12px; left: 38px; top: 216px; position: absolute" value="Leave Type From"/>
                                                                <ice:outputText id="outputText5"
                                                                    style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Leave Information"/>
                                                                <ice:inputTextarea binding="#{Leave$LeaveSettlementPage.txtRemark}" disabled="true"
                                                                    id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 154px; top: 362px; position: absolute; width: 536px"/>
                                                                <ice:outputText id="lblRemark"
                                                                    style="font-size: 12px; left: 38px; top: 375px; position: absolute" value="Reason "/>
                                                                <ice:selectOneMenu binding="#{Leave$LeaveSettlementPage.drlLeaveTypeFrom}" disabled="true"
                                                                    id="drlLeaveTypeFrom" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 215px; position: absolute; width: 190px"
                                                                    value="#{Leave$LeaveSettlementPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Leave$LeaveSettlementPage.drlLeaveTypeFrom_processValueChange}">
                                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Leave$LeaveSettlementPage.readCommitteeType}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:selectOneMenu binding="#{Leave$LeaveSettlementPage.drlLeaveTypeTo}" disabled="true"
                                                                    id="drlLeaveTypeTo" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 500px; top: 215px; position: absolute; width: 190px"
                                                                    value="#{Leave$LeaveSettlementPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Leave$LeaveSettlementPage.drlLeaveTypeTo_processValueChange}">
                                                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Leave$LeaveSettlementPage.readCommitteStatus}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:panelLayout id="lyEducationlevel" layout="flow"
                                                                    style="height: 160px; left: 5px; top: 35px; overflow: auto; position: absolute; width: 735px" styleClass="insideContainerMain">
                                                                    <ice:dataTable binding="#{Leave$LeaveSettlementPage.tblCommitteeMamber}"
                                                                        id="tblCommitteeMamber" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                                        value="#{Leave$LeaveSettlementPage.employeeLeaveList}" var="currentRow">
                                                                        <ice:column id="column1">
                                                                            <ice:outputText id="outputText3" value="#{currentRow['leaveTypeDescription']}"/>
                                                                            <f:facet name="header">
                                                                                <ice:outputText id="outputText4" value="Leave Type"/>
                                                                            </f:facet>
                                                                        </ice:column>
                                                                        <ice:column id="column2">
                                                                            <ice:outputText id="outputText6" value="#{currentRow['startDate']}"/>
                                                                            <f:facet name="header">
                                                                                <ice:outputText id="outputText7" value="Start Date"/>
                                                                            </f:facet>
                                                                        </ice:column>
                                                                        <ice:column id="column3">
                                                                            <ice:outputText id="outputText11" value="#{currentRow['endDate']}"/>
                                                                            <f:facet name="header">
                                                                                <ice:outputText id="outputText20" value="End Date"/>
                                                                            </f:facet>
                                                                        </ice:column>
                                                                        <ice:column id="column4">
                                                                            <ice:outputText id="outputText12" value="#{currentRow['leaveDay']}"/>
                                                                            <f:facet name="header">
                                                                                <ice:outputText id="outputText14" value="Leave Days"/>
                                                                            </f:facet>
                                                                            <ice:rowSelector id="rwSelectorLeaveType" immediate="true" multiple="false"
                                                                                selectionListener="#{Leave$LeaveSettlementPage.rwSelectorLeaveType_processMyEvent}" value="#{currentRow['selected']}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column58">
                                                                            <ice:outputText id="outputText18" value="#{currentRow['leaveRequestResone']}"/>
                                                                            <f:facet name="header">
                                                                                <ice:outputText id="outputText19" value="Reason Leave Request"/>
                                                                            </f:facet>
                                                                        </ice:column>
                                                                    </ice:dataTable>
                                                                </ice:panelLayout>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnCalenderDateFrom_action}"
                                                                    binding="#{Leave$LeaveSettlementPage.btnCalenderDateFrom}" id="btnCalenderDateFrom"
                                                                    image="/Employee/images/calendar.gif" immediate="true"
                                                                    onclick="getId('form1:panelTabSet1:0:txtAssignedDate'),getPosition(this.id);"
                                                                    partialSubmit="true" style="left: 325px; top: 293px; position: absolute" value="submit"/>
                                                                <ice:outputText id="lblAvilablDayes"
                                                                    style="font-size: 12px; left: 38px; top: 250px; position: absolute" value="Available Leave Days"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtAvilablDayes}" id="txtAvilablDayes" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 250px; position: absolute; width: 190px"/>
                                                                <ice:outputText id="outputText1"
                                                                    style="font-size: 12px; left: 396px; top: 250px; position: absolute" value="Chnge Leave Day"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtLeaveDays}" id="txtLeaveDays" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 500px; top: 250px; position: absolute; width: 121px"/>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.button1_action}" id="button1"
                                                                    style="left: 150px; top: 320px; position: absolute" value="Calculate Leave Days"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout id="lyCommiteRegister1" rendered="true" style="height: 20px; left: 18px; top: 720px; position: absolute; width: 745px">
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnNew_action}"
                                                                    binding="#{Leave$LeaveSettlementPage.btnNew}" id="btnNew" partialSubmit="true"
                                                                    style="margin-left: 180px; width: 120px" value="New"/>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnSave_action}"
                                                                    binding="#{Leave$LeaveSettlementPage.btnSave}" disabled="true" id="btnSave"
                                                                    style="margin-left: 30px; width: 120px" value="Change"/>
                                                                <ice:commandButton binding="#{Leave$LeaveSettlementPage.btnReset}" disabled="true" id="btnReset"
                                                                    immediate="true" partialSubmit="true" style="margin-left: 30px; width: 120px" value="Cancel"/>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                    </ice:panelTab>
                                                    <ice:panelTab id="tabLeaveSettlement" label=" Leave Settlement  ">
                                                        <ice:panelLayout id="panelLayout2" style="height: 700px; top: 0px; position: inherit; width: 100%">
                                                            <ice:panelLayout id="pnProfilepage" style="height: 670px; left: 0px; top: -20px; position: relative; width: 750px">
                                                                <label style="left: 5px; top: 650px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                                <label style="left: 5px; top: 715px; border-bottom:0.5px groove #176674; width:750px; position: absolute;"></label>
                                                                <ice:outputText id="lblCommenteName" style="left: 38px; top: 74px; position: absolute" value="Full Name :"/>
                                                                <ice:inputText binding="#{Leave$LeaveSettlementPage.txtEmployeeIDentification}"
                                                                    id="txtEmployeeIDentification" style="border: 1px solid rgb(115, 179, 206); background-color:                                                                      rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style:                                                                      normal; font-weight: lighter; left: 150px; top: 33px; position: absolute; width: 190px"/>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnSettleSave_action}"
                                                                    binding="#{Leave$LeaveSettlementPage.btnSettleSave}" disabled="true" id="btnSettleSave"
                                                                    style="left: 20px; top: 680px; position: absolute; width: 120px" value="Settle "/>
                                                                <ice:outputText id="lblEmployeeId"
                                                                    style="font-family: Cambria; left: 40px; top: 33px; position: absolute" value="Employee ID :"/>
                                                                <ice:selectOneMenu binding="#{Leave$LeaveSettlementPage.drlEmployeeID}" id="drlEmployeeID"
                                                                    partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: Cambria; font-size: 12px; font-weight: lighter; left: 575px; top: 30px; position: absolute; width: 180px"
                                                                    value="#{Leave$LeaveSettlementPage.defaultSelectedData6.selectedObject}" valueChangeListener="#{Leave$LeaveSettlementPage.drlEmployeeID_processValueChange}">
                                                                    <f:selectItems id="selectOneMenu4selectItems" value="#{Leave$LeaveSettlementPage.employeeOnLeave}"/>
                                                                </ice:selectOneMenu>
                                                                <ice:commandButton action="#{Leave$LeaveSettlementPage.btnSearchEmployeeLeave_action}"
                                                                    id="btnSearchEmployeeLeave" style="left: 380px; top: 20px; position: absolute; width: 90px" value="Search"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblFullName}" id="lblFullName"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 74px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText2" style="left: 38px; top: 115px; position: absolute" value="Department :"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblEmployeeDepartment}"
                                                                    id="lblEmployeeDepartment"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 115px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText15" style="left: 38px; top: 156px; position: absolute" value="Job Position"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblJobPosition1}" id="lblJobPosition1"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 156px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText17" style="left: 38px; top: 197px; position: absolute" value="Gender:"/>
                                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlementPage.choMaleSe}" disabled="true"
                                                                    id="choMaleSe" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 197px; position: absolute" value="#{Leave$LeaveSettlementPage.defaultSelectedData7.selectedBoolean}"/>
                                                                <ice:selectBooleanCheckbox binding="#{Leave$LeaveSettlementPage.choFemaleSe}" disabled="true"
                                                                    id="choFemaleSe" partialSubmit="true"
                                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 197px; position: absolute" value="#{Leave$LeaveSettlementPage.defaultSelectedData8.selectedBoolean}"/>
                                                                <ice:outputText id="lblMale"
                                                                    style="font-size: 11px; left: 175px; top: 197px; position: absolute" value="Male"/>
                                                                <ice:outputText id="lblFemale"
                                                                    style="font-size: 11px; left: 260px; top: 197px; position: absolute" value="Femalet"/>
                                                                <ice:panelLayout id="lySettlementInformation" style="border: 1px solid rgb(204, 204, 204); height: 235px; left: 4px; top: 400px; position: absolute; width: 745px">
                                                                    <ice:outputText id="lblDescription"
                                                                        style="font-size: 10px; left: 38px; top: 90px; position: absolute" value="Description :"/>
                                                                    <ice:inputTextarea binding="#{Leave$LeaveSettlementPage.txtLeaveSettleDescription}"
                                                                        disabled="true" id="txtLeaveSettleDescription" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 90px; left: 150px; top: 80px; position: absolute; width: 560px"/>
                                                                    <ice:outputText id="outputText13"
                                                                        style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Leave Settlement Information"/>
                                                                    <ice:inputText binding="#{Leave$LeaveSettlementPage.txtReturnDate}" id="txtReturnDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 35px; position: absolute; width: 211px"/>
                                                                    <ice:outputText id="outputText16" style="left: 38px; top: 36px; position: absolute" value="Retutn Date :"/>
                                                                    <ice:selectInputDate id="selectInputDate1" rendered="false"
                                                                        style="height: 212px; left: 350px; top: 45px; position: absolute; width: 190px" value="#{Leave$LeaveSettlementPage.selectInputDate1Bean.date1}"/>
                                                                    <ice:commandButton action="#{Leave$LeaveSettlementPage.btnCalender_action}" id="btnCalender"
                                                                        image="/Employee/images/calendar.gif"
                                                                        style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 345px; top: 38px; position: absolute" value="submit"/>
                                                                </ice:panelLayout>
                                                                <ice:graphicImage binding="#{Leave$LeaveSettlementPage.graphicImage1}" height="210"
                                                                    id="graphicImage1"
                                                                    style="border-width: 1px; border-style: solid; border-color: rgb(153, 153, 153) rgb(153, 153, 153) rgb(153, 153, 153) rgb(153, 153, 153); left: 550px; top: 74px; position: absolute"
                                                                    url="/Employee/images/blank.gif" value="/Employee/images/blank.gif" width="202"/>
                                                                <ice:outputText id="outputText21" style="left: 38px; top: 279px; position: absolute" value="Leave Days"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblLeaveType}" id="lblLeaveType"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 238px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText23" style="left: 38px; top: 238px; position: absolute" value="Leave Type"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.leaveDays}" id="leaveDays"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 279px; position: absolute; width: 370px" value="outputText"/>
                                                                <ice:outputText id="outputText22" style="left: 38px; top: 361px; position: absolute" value="Reason"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblReason}" id="lblReason"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 361px; position: absolute; width: 600px" value="outputText"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblEndDateLevel}" id="lblEndDateLevel"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 550px; top: 320px; position: absolute; width: 200px" value="outputText"/>
                                                                <ice:outputText id="outputText25" style="left: 470px; top: 320px; position: absolute" value="End Date"/>
                                                                <ice:outputText binding="#{Leave$LeaveSettlementPage.lblStartDate}" id="lblStartDate"
                                                                    style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 320px; position: absolute; width: 200px" value="outputText"/>
                                                                <ice:outputText id="outputText27" style="left: 38px; top: 320px; position: absolute" value="Start Date"/>
                                                            </ice:panelLayout>
                                                        </ice:panelLayout>
                                                    </ice:panelTab>
                                                </ice:panelTabSet>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright  2002-2003 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="margin-left:10px;color:#333333;">Information Network Security Agency |Directorate Of Research Technology |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveSettlementPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                            id="pnConfirmationMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 150px; top: 400px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$LeaveSettlementPage.cmdConfirmationCloseMesssage_action}" id="cmdConfirmationCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 742px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Leave$LeaveSettlementPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                        layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$LeaveSettlementPage.lblFormMessage4}" id="lblFormMessage4" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$LeaveSettlementPage.pnConfirmationForDelete}" clientOnly="true" draggable="false"
                            id="pnConfirmationForDelete" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 150px; left: 95px; top: 794px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlConfirmationHeader" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnConfirmationDeleteTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Mugher  Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$LeaveSettlementPage.cmdConfirmationCloseDeleete_action}" id="cmdConfirmationCloseDeleete"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 742px; top: 15px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelConfirmationDelete"
                                    style="display: block; height: 100px;                                 position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlConfirmationDeleteBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 70px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$LeaveSettlementPage.lblFormDeleteMessage}" id="lblFormDeleteMessage" style="background-color: #F5F5F5;color: green; font-size: 14px; font-weight: bold;text-align: center; vertical-align: middle"/>
                                        <ice:commandButton action="#{Leave$LeaveSettlementPage.bntYES_action}" id="bntYES"
                                            style="left: 428px; top: 55px; position: absolute; width: 80px" value="Yes"/>
                                        <ice:commandButton action="#{Leave$LeaveSettlementPage.button2_action}" id="button2"
                                            style="left: 540px; top: 55px; position: absolute; width: 80px" value="No"/>
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