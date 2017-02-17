<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : Templete
    Created on : Dec 26, 2012, 10:33:40 AM
    Author     : Administrator
-->
<jsp:root version="2.1" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component" xmlns:jsp="http://java.sun.com/JSP/Page">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Employee Registration</title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/images/main.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
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
                    function IncrementSalaryRequest(field){
                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;
                    }
                </script>
                <link HREF="../header_icon.ico" REL="icon"/>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{DailyWorker$ApproveDailyWorkerAttendancePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{DailyWorker$ApproveDailyWorkerAttendancePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{DailyWorker$ApproveDailyWorkerAttendancePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{DailyWorker$ApproveDailyWorkerAttendancePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{DailyWorker$ApproveDailyWorkerAttendancePage.panelBorder1Bean.renderWest}"
                            style="top: 5px; position: relative; background:transparent;" styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:650px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 650px; left: 5px; top: 10px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:850px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="#{msgAttendance.CommonTasks}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group" style="height:200px;width:100%">
                                                        <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                            <li>
                                                                <ice:commandLink action="#{Attendance$AttendanceCertifyPage.lnkTakeAttendance_action}"
                                                                    id="lnkTakeAttendance" style="color:#333333;font-weight:bold" value="Take Attendance"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink action="#{Attendance$AttendanceCertifyPage.lnkApproveAttendance_action}"
                                                                    id="lnkApprove" style="color:#333333;font-weight:bold" value="Approve Attendance"/>
                                                            </li>
                                                        </ul>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="#{msgAttendance.ListofAttendanceHistory}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 515px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 300px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox id="lstDestionToMade" partialSubmit="true" size="2"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 298px; left: 0px; top: 50px; position: absolute; width: 188px"
                                                                value="#{DailyWorker$ApproveDailyWorkerAttendancePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{DailyWorker$ApproveDailyWorkerAttendancePage.lstDestionToMade_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{DailyWorker$ApproveDailyWorkerAttendancePage.monthlyAttendanceProcessed}"/>
                                                            </ice:selectOneListbox>
                                                            <ice:outputLabel id="outputLabel19"
                                                                style="font-weight: bold; left: -5px; top: 10px; position: absolute; text-align: center; width: 208px" value="Daily Worker Attendance  list"/>
                                                            <ice:commandButton id="btnPrintPreview" immediate="true" partialSubmit="true" rendered="false"
                                                                style="left: 5px; top: 250px; position: absolute; width: 181px" value="Prepare Attendance Report"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 830px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 720px; left: 15px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Evaluation"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height:600px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 400px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:dataTable headerClass="ceDatTblFtr" id="tblAbsentee"
                                                            style="top: -10px; position: absolute; width: 100%"
                                                            value="#{DailyWorker$ApproveDailyWorkerAttendancePage.dailyWorkerAttendanceModelLoad}"
                                                            var="currentRow" width="732">
                                                            <ice:column id="colEmpFullName1" style="width:250px;cursor:pointer;">
                                                                <h:outputText id="outputTex234t5" value="#{currentRow['dailyWorkerFullName']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="outputText71" value="#{msgAttendance.FullName}"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colAbsentType">
                                                                <ice:outputText id="txtAbsentType" value="#{currentRow['presentAmount']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblAbsentType" value="Total Working Day "/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colStatus">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendanceCertifyPage.chkDecision}"
                                                                    id="chkDecision" partialSubmit="true" value="#{currentRow['selected']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="lblSelectMekeDesstion" value="Select Here for Decision"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="panLeaveApprove" style="border: 1px solid rgb(204, 204, 204); height: 220px; left: 10px; top: 510px; overflow: auto; position: absolute; width: 780px">
                                                        <ice:outputLabel id="lblDeciderDepartment"
                                                            style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="DeciderDepartment"/>
                                                        <ice:outputLabel id="lblDeciderId"
                                                            style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="DeciderId"/>
                                                        <ice:inputText binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 140px; top: 70px; position: absolute; width: 169px"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 390px; top: 30px; position: absolute" value="Decider FullName"/>
                                                        <ice:outputLabel id="deciderPosition"
                                                            style="font-family: Cambria; left: 390px; top: 70px; position: absolute" value="Decider Position"/>
                                                        <ice:outputLabel id="lblDecision"
                                                            style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="Decision"/>
                                                        <ice:inputTextarea binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); height: 63px; left: 140px; top: 145px; position: absolute; width: 560px"/>
                                                        <ice:outputLabel id="lblDeciderComment"
                                                            style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="Comment"/>
                                                        <ice:outputText binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.lblDecider_Department}"
                                                            id="lblDecider_Department"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 140px; top: 30px; position: absolute; width: 200px" value=":"/>
                                                        <ice:outputText binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.lblEmployeeFullName}"
                                                            id="lblEmployeeFullName"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 30px; position: absolute; width: 210px" value=":"/>
                                                        <ice:outputText binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.lblDeciderPosition}"
                                                            id="lblDeciderPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 70px; position: absolute; width: 210px" value=":"/>
                                                        <ice:selectOneMenu id="drlDecision" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 140px; top: 105px; position: absolute; width: 200px" value="#{DailyWorker$ApproveDailyWorkerAttendancePage.selectOneMenu1Bean.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{DailyWorker$ApproveDailyWorkerAttendancePage.listOfDecision}"/>
                                                        </ice:selectOneMenu>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{DailyWorker$ApproveDailyWorkerAttendancePage.btnSave_action}" id="btnSave"
                                                        style="left: 169px; top: 750px; position: absolute; width: 143px" value="Save"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(255, 255, 255); font-family: serif; font-size: 14px; font-style: italic; font-weight: bolder; height: 18px; left: 48px; top: 0px; position: absolute; width: 622px" value="BUNNA INTERNATIONAL BANK Cement Enterprise Human Resource Management System - Employee Profile."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.pnMessage}" clientOnly="true"
                            draggable="false" id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{DailyWorker$ApproveDailyWorkerAttendancePage.modalPnlCloseMesssage_action}"
                                        id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{DailyWorker$ApproveDailyWorkerAttendancePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
