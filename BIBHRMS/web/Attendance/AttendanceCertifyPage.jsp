<?xml version="1.0" encoding="UTF-8"?>
<!-- 
    Document   : AttendanceCertifyPage
    Created on : Dec 17, 2013, 10:59:21 AM
    Author     : Dereje
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
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
                    function AttendanceCertifyPage(field){
                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;
                    }
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <f:loadBundle basename="Localization.HR_Localization_Termination" var="msgAttendance"/>
                    <ice:panelBorder id="whole_page" renderCenter="#{Attendance$AttendanceCertifyPage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Attendance$AttendanceCertifyPage.panelBorder1Bean.renderEast}"
                        renderNorth="#{Attendance$AttendanceCertifyPage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Attendance$AttendanceCertifyPage.panelBorder1Bean.renderSouth}"
                        renderWest="#{Attendance$AttendanceCertifyPage.panelBorder1Bean.renderWest}" style="top: 0px; position: relative"
                        styleClass="whole_page" width="1024px">
                        <f:facet name="north">
                            <ice:panelGroup id="page_header" style="height: 75px">
                                <!-- Begin Header -->
                                <ice:panelLayout id="header" layout="flow" style="height: 75px; left: 0px; position: relative; width: 100%; -rave-layout: grid"
                                    styleClass="header" visible="true">
                                    <jsp:directive.include file="/Header.jspf"/>
                                </ice:panelLayout>
                                <!-- End Header -->
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="west">
                            <ice:panelGroup id="menu_left" style="border:none; height:650px;">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height:650px;top:50px;left:5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
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
                                                <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 567px; width: 100%">
                                                    <ice:panelLayout id="StatusContainer" style="height: 300px; position: absolute; width: 100%">
                                                        <ice:selectOneListbox binding="#{Attendance$AttendanceCertifyPage.lisMonth}" id="lisMonth"
                                                            partialSubmit="true" size="2"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 298px; left: 0px; top: 50px; position: absolute; width: 188px"
                                                            value="#{Attendance$AttendanceCertifyPage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Attendance$AttendanceCertifyPage.lisMonth_processValueChange}">
                                                            <f:selectItems id="selectOneListbox1selectItems" value="#{Attendance$AttendanceCertifyPage.monthlyAttendanceProcessed}"/>
                                                        </ice:selectOneListbox>
                                                        <!--<ice:selectOneListbox binding="#{Attendance$AttendanceCertifyPage.listApprovedAttendance}"
                                                            id="listApprovedAttendance" partialSubmit="true" size="2"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 298px; left: 0px; top: 50px; position: absolute; width: 188px"
                                                            value="#{Attendance$AttendanceCertifyPage.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{Attendance$AttendanceCertifyPage.listApprovedAttendance_processValueChange}">
                                                            <f:selectItems id="selectOneListbox2selectItems" value="#{Attendance$AttendanceCertifyPage.dayliyAttendanceProcessed}"/>
                                                        </ice:selectOneListbox>-->
                                                        <ice:outputLabel id="outputLabel19"
                                                            style="font-weight: bold; left: -5px; top: 10px; position: absolute; text-align: center; width: 208px" value="Monthly  Approved Attendance"/>
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
                            <ice:panelGroup id="page_display" style="height: 920px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 891px; left: 0px; position: relative; top: 60px; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 850px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="Certify Attendance Records"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 801px; left: 0px; top: 24px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval" style="height: 790px" styleClass="filedset_border">
                                                <label style="left: 30px; top: 750px; border-bottom:0.5px groove #176674; width:720px; position: absolute;"></label>
                                                <label style="left: 30px; top: 800px; border-bottom:0.5px groove #176674; width:720px; position: absolute;"></label>
                                                <ice:inputText binding="#{Attendance$AttendanceCertifyPage.txtfAbsentDate}" disabled="true" id="txtfAbsentDate"
                                                    partialSubmit="true" required="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 25px; position: absolute; width: 265px" styleClass="required"/>
                                                <ice:panelLayout id="pnlAbsentee"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 400px; margin-left: 15px; left: 10px; top: 80px; overflow: auto; position: absolute; width: 732px">bl
                                                    <ice:dataTable
                                                        headerClass="ceDatTblFtr" id="tblAbsentee" style="top: -10px; position: absolute"
                                                        value="#{Attendance$AttendanceCertifyPage.attendanceAbsenteesLoad}" var="currentRow" width="732">
                                                        <ice:column id="colEmpID754" style="width:100px;cursor:pointer;">
                                                            <ice:outputText id="outputText12312" value="#{currentRow['empId']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText2343" value="#{msgAttendance.EmployeeId}"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colEmpFullName1" style="width:250px;cursor:pointer;">
                                                            <h:outputText id="outputTex234t5" value="#{currentRow['empFullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText71" value="#{msgAttendance.FullName}"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colAbsentType">
                                                            <ice:outputText id="txtAbsentType" value="#{currentRow['absenttype']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblAbsentType" value="Absent Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText6" value="#{currentRow['absentAmount']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText7" value="Absent"/>
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
                                                <ice:panelLayout id="pnlApproval" style="border: 1px solid rgb(204, 204, 204); height: 235px; margin-left: 15px; left: 10px; top: 500px; overflow: auto; position: absolute; width: 732px">
                                                    <ice:outputLabel id="outputLabel9" style="font-family: Cambria; left: 20px; top: 30px; position: absolute" value="#{msgAttendance.FullName}"/>
                                                    <ice:outputLabel id="outputLabel10" style="font-family: Cambria; left: 390px; top: 30px; position: absolute" value="#{msgAttendance.Position}"/>
                                                    <ice:outputLabel id="outputLabel12" style="font-family: Cambria; left: 20px; top: 70px; position: absolute" value="#{msgAttendance.EmployeeId}"/>
                                                    <ice:outputLabel id="lblDecision" style="font-family: Cambria; left: 20px; top: 110px; position: absolute" value="#{msgAttendance.Decision}"/>
                                                    <ice:outputLabel id="lblComment" style="font-family: Cambria; left: 20px; top: 150px; position: absolute" value="#{msgAttendance.Comment}"/>
                                                    <ice:selectOneMenu binding="#{Attendance$AttendanceCertifyPage.drlDecision}" id="drlDecision"
                                                        partialSubmit="true"
                                                        style="border: 1px solid rgb(115, 179, 206); left: 140px; top: 105px; position: absolute; width: 200px" value="#{Attendance$AttendanceCertifyPage.selectOneMenu1Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Attendance$AttendanceCertifyPage.listOfDecision}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:inputTextarea binding="#{Attendance$AttendanceCertifyPage.txtRemark}" id="txtRemark" style="border: 1px solid rgb(115, 179, 206); height: 63px; left: 140px; top: 145px; position: absolute; width: 560px"/>
                                                    <ice:outputText binding="#{Attendance$AttendanceCertifyPage.lblFullName}" id="lblFullName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 140px; top: 30px; position: absolute; width: 200px"/>
                                                    <ice:outputText binding="#{Attendance$AttendanceCertifyPage.lblPosition}" id="lblPosition" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 500px; top: 30px; position: absolute; width: 210px"/>
                                                    <ice:outputText binding="#{Attendance$AttendanceCertifyPage.lblEmployeeId}" id="lblEmployeeId" style="left: 140px; top: 70px; position: absolute;&#xa;border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria;  width: 200px"/>
                                                </ice:panelLayout>
                                                <ice:outputLabel id="lblDate" style="font-size: 12px; left: 600px; top: -20px; position: absolute" value="#{msgAttendance.currentDate}"/>
                                                <ice:outputLabel id="outputLabel2" style="font-size: 12px; left: 40px; top: 30px; position: absolute" value="#{msgAttendance.Month}"/>
                                                <ice:outputLabel binding="#{Attendance$AttendanceCertifyPage.stxtDate}" id="stxtDate" style="color: rgb(153, 102, 0); font-size: 12px; font-weight: bold; left: 680px; top: -21px; position: absolute; width: 104px"/>
                                                <ice:outputLabel id="drlReportedByEmployeeID" rendered="false" style="left: 200px; top: 10px; position: absolute; width: 100px"/>
                                                <ice:outputLabel id="htxtfAppEmpId" rendered="false" style="left: 100px; top: 10px; position: absolute; width: 100px"/>
                                                <ice:outputLabel id="htxtfCertEmpId" rendered="false" style="left: 10px; top: 10px; position: absolute; width: 105px"/>
                                                <ice:commandButton action="#{Attendance$AttendanceCertifyPage.btnCertifyAttendance_action}"
                                                    binding="#{Attendance$AttendanceCertifyPage.btnCertifyAttendance}" id="btnCertifyAttendance"
                                                    partialSubmit="true" style="left: 30px; top: 750px; position: absolute; width: 130px" value="#{msgAttendance.Save}"/>
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
                                            href="http://www.google.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <!--
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendanceCertifyPage.pnlpopupAbsentee}" clientOnly="true" draggable="true"
                        id="pnlpopupAbsentee" modal="true" positionOnLoadOnly="true" rendered="false" style="display: block; height: 278px; left: 97px; top: 226px; position: absolute; width: 634px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpRequestProcessed" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpRequestProcessedTitle" style="width:400px" styleClass="popupHeaderText" value="National Bank of Ethiopia Human Resource Management System - Manage Absentees"/>
                                <ice:commandButton action="#{Attendance$AttendanceCertifyPage.modalPnlCloseBtnRequestProcessed_action}" alt="Close"
                                    id="modalPnlCloseBtnRequestProcessed" image="/resources/images/close.gif" immediate="true"
                                    style="left: 614px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlgroupPopUpRequestProcessed" style="display: block; height: 209px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:outputLabel id="lblRequestProcessedHistory" style="left: 300px; top: 20px; position: absolute" value="By Name :"/>
                                <ice:inputText binding="#{Attendance$AttendanceCertifyPage.stxtEmpFirstName}" disabled="true" id="stxtEmpFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 135px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblProcessedByFullName" style="left: 50px; top: 116px; position: absolute" value="Employee Full Name"/>
                                <ice:inputText binding="#{Attendance$AttendanceCertifyPage.stxtEmpMiddleName}" disabled="true" id="stxtEmpMiddleName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 225px; top: 134px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblProcessedByJobPosition" style="left: 400px; top: 53px; position: absolute" value="Attendance State"/>
                                <ice:inputText binding="#{Attendance$AttendanceCertifyPage.stxtEmpLastName}" disabled="true" id="stxtEmpLastName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 135px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblDateProcessed" style="left: 50px; top: 53px; position: absolute" value="Employee List"/>
                                <ice:selectOneMenu binding="#{Attendance$AttendanceCertifyPage.drlEmpList}" id="drlEmpList" partialSubmit="true"
                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 71px; position: absolute; width: 160px"
                                    value="#{Attendance$AttendanceCertifyPage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Attendance$AttendanceCertifyPage.drlEmpList_processValueChange}">
                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Attendance$AttendanceCertifyPage.employeeLists}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu binding="#{Attendance$AttendanceCertifyPage.drlAttendanceState}" id="drlAttendanceState"
                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 71px; position: absolute; width: 160px"
                                    value="#{Attendance$AttendanceCertifyPage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Attendance$AttendanceCertifyPage.drlAttendanceState_processValueChange}">
                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Attendance$AttendanceCertifyPage.stateLists}"/>
                                </ice:selectOneMenu>
                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendanceCertifyPage.ckbByIdentification}" id="ckbByIdentification"
                                    partialSubmit="true" style="left: 245px; top: 22px; position: absolute"
                                    value="#{Attendance$AttendanceCertifyPage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendanceCertifyPage.ckbByIdentification_processValueChange}"/>
                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendanceCertifyPage.ckbByName}" id="ckbByName" partialSubmit="true"
                                    style="left: 355px; top: 22px; position: absolute"
                                    value="#{Attendance$AttendanceCertifyPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendanceCertifyPage.ckbByName_processValueChange}"/>
                                <ice:outputLabel id="lblRequestProcessedHistory1" style="left: 150px; top: 20px; position: absolute" value="By Identification :"/>
                                <ice:commandButton action="#{Attendance$AttendanceCertifyPage.btnAddAbsenteesPOP_action}"
                                    binding="#{Attendance$AttendanceCertifyPage.btnAddAbsenteesPOP}" disabled="true" id="btnAddAbsenteesPOP"
                                    style="left: 200px; top: 170px; position: absolute; width: 110px" value="Add"/>
                                <ice:commandButton binding="#{Attendance$AttendanceCertifyPage.btnUpdateAbsenteesPOP}" disabled="true"
                                    id="btnUpdateAbsenteesPOP" style="left: 400px; top: 170px; position: absolute; width: 110px" value="Update"/>
                                <ice:panelLayout binding="#{Attendance$AttendanceCertifyPage.pnMessage2}" id="pnMessage2"
                                    style="left: 5px; top:2px;position: absolute; width: 450px" styleClass="message2">
                                    <ice:outputLabel binding="#{Attendance$AttendanceCertifyPage.lblAbsenteePopUpMsg}" id="lblAbsenteePopUpMsg" style="text-align: center; vertical-align: middle; font-size: 11px; height: 16px; left: 5px; top: 2px; position: absolute; text-align: left; width: 391px"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>

                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendanceCertifyPage.pnlAttendaneReport}" clientOnly="true" draggable="false"
                        id="pnlAttendaneReport" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 229px; left: 63px; top: 800px; position: absolute; width: 751px; z-index: 0" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnlAttendaneReport" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 738px">
                                <ice:outputText id="pnMessageTitlepnlAttendaneReport"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="National Bank of Ethiopia Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Attendance$AttendanceCertifyPage.modalPnlClosepnlAttendaneReport_action}"
                                    id="modalPnlClosepnlAttendaneReport" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 755px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup dragListener="#{Attendance$AttendanceCertifyPage.panelGrouppnlAttendaneReport_processMyEvent}"
                                id="panelGrouppnlAttendaneReport" style="display: block; height: 176px; position: relative; width: 699px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlAttendaneReportBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 141px; position: relative; width: 632px; -rave-layout: grid" styleClass="message">
                                    <ice:inputText binding="#{Attendance$AttendanceCertifyPage.txtPrintToDate}" id="txtPrintToDate" partialSubmit="true"
                                        required="true" style="left: 430px; top: 60px; position: absolute; width: 200px"/>
                                    <ice:inputText binding="#{Attendance$AttendanceCertifyPage.txtPrintFromDate}" id="txtPrintFromDate" partialSubmit="true"
                                        required="true" style="left: 115px; top: 60px; position: absolute; width: 200px"/>
                                    <ice:commandButton action="#{Attendance$AttendanceCertifyPage.btnPrintPriviewPrint_action}"
                                        binding="#{Attendance$AttendanceCertifyPage.btnPrintPriviewPrint}" id="btnPrintPriviewPrint" immediate="true"
                                        partialSubmit="true" style="left: 469px; top: 103px; position: absolute; width: 164px" value="Print Preview"/>
                                    <ice:outputText id="outputText11" style="left: 340px; top: 65px; position: absolute" value="To Date :"/>
                                    <ice:outputText id="outputText15" style="left: 30px; top: 65px; position: absolute" value="From Date :"/>
                                    <ice:commandButton id="calDateAttendaceSearch1" image="/resources/images/cal_button.gif"
                                        onclick="getId('form1:txtPrintFromDate'),getPosition(this.id);" partialSubmit="true"
                                        style="left: 296px; top: 64px; position: absolute; z-index: 1000" value="submit"/>
                                    <ice:commandButton id="calDateAttendaceSearch2" image="/resources/images/cal_button.gif"
                                        onclick="getId('form1:txtPrintToDate'),getPosition(this.id);" partialSubmit="true"
                                        style="left: 610px; top: 65px; position: absolute" value="submit"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelConfirmation acceptLabel="Yes " cancelLabel="No" id="deleteConfirmPanel"
                        message="Are you sure you want to delete the selected data ?"
                        rendered="#{Attendance$AttendanceCertifyPage.confirmationPanelBean.withConfirmation}" title="National Bank of Ethiopia-Human Resource"/>
                        -->
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendanceCertifyPage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                <ice:commandLink action="#{Attendance$AttendanceCertifyPage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                    immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Attendance$AttendanceCertifyPage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
