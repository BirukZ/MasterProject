<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Dec 26, 2012, 7:48:31 AM
    Author     : dereje
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
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" onload="showCal()">
                <ice:form id="form1">
                    <f:loadBundle basename="Localization.HR_Localization_Attendance" var="msgAttendance"/>
                    <ice:panelBorder id="whole_page" renderCenter="#{Attendance$AttendancePage.panelBorder1Bean.renderCenter}"
                        renderEast="#{Attendance$AttendancePage.panelBorder1Bean.renderEast}"
                        renderNorth="#{Attendance$AttendancePage.panelBorder1Bean.renderNorth}"
                        renderSouth="#{Attendance$AttendancePage.panelBorder1Bean.renderSouth}"
                        renderWest="#{Attendance$AttendancePage.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
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
                            <ice:panelGroup id="menu_left" style="height: 545px">
                                <ice:panelLayout id="left_menu1" layout="flow"
                                    style="height:500px;top:50px;left:5px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                    <ice:panelLayout id="list_menu2" style="height:850px; position: absolute; width: 213px" styleClass="left_menu">
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="search_Group_Header">
                                                    <ice:outputText id="lblSearchArea" value="#{msgAttendance.Search}"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="search_panelGrid" width="100%">
                                                <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 270px; width: 100%">
                                                    <ice:outputLabel id="lblDateOfAttandanceTaken"
                                                        style="left: 10px; top: 40px; position: absolute; text-align: center; width: 177px" value="#{msgAttendance.Date}"/>
                                                    <ice:inputText binding="#{Attendance$AttendancePage.txtfAbsentDateSearch}" id="txtfAbsentDateSearch" style="border: 1px solid rgb(115, 179, 206); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 15px; top: 60px; position: absolute; width: 180px"/>
                                                    <ice:commandButton action="#{Attendance$AttendancePage.btnSearchAttendance_action}" id="btnSearchAttendance"
                                                        partialSubmit="true" style="left: 30px; top: 80px; position: absolute; width: 153px" value="#{msgAttendance.Search}"/>
                                                    <ice:commandButton action="#{Attendance$AttendancePage.calDateAttendaceSearch_action}"
                                                        id="calDateAttendaceSearch" image="/resources/images/cal_button.gif" partialSubmit="true"
                                                        style="left: 175px; top: 64px; position: absolute" value="submit"/>
                                                    <ice:panelGroup id="panDefineAttendance" style="margin: 140px 5px 5px -5px; padding: 7px; background-color: transparent; display: block; float: left; height: 270px; left: -5px; width: 100%">
                                                        <ul style="list-style-type: none; list-style-image: none; top:250px; list-style-position: outside; line-height: 174%;">
                                                            <li>
                                                                <ice:commandLink action="#{Attendance$AttendancePage.lnkDefineMonthPayrollDay_action}"
                                                                    id="lnkDefineMonthPayrollDay" value="Define Month Payroll Day "/>
                                                            </li>
                                                        </ul>
                                                    </ice:panelGroup>
                                                    <ice:selectInputDate binding="#{Attendance$AttendancePage.calSearchDate}" id="calSearchDate"
                                                        rendered="false" style="height: 212px; left: 10px; top: 80px; position: absolute; width: 190px"
                                                        value="#{Attendance$AttendancePage.selectInputDate3Bean.date1}" valueChangeListener="#{Attendance$AttendancePage.calSearchDate_processValueChange}"/>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="commonTasksGroup_header">
                                                    <ice:outputText id="lblCommonTasks" value="#{msgAttendance.CommonTasks}"/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="commonTasksGroup_Grid" width="100%">
                                                <ice:panelGroup id="commonTasksGroup_Group" style="height:150px;width:100%">
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Attendance$AttendancePage.lnkApproveAttendance_action}"
                                                                id="lnkApproveAttendance" style="color:#333333;font-weight:bold" value="Approve Attendance"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Attendance$AttendancePage.lnkCertify_action}" id="lnkCertify"
                                                                style="color:#333333;font-weight:bold" value="Cerify Attendance"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                        <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                            <f:facet name="header">
                                                <ice:panelGroup id="status_Group_Header">
                                                    <ice:outputText id="lblStatus" value=""/>
                                                </ice:panelGroup>
                                            </f:facet>
                                            <ice:panelGrid id="StatusBoard" width="100%">
                                                <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 195px; width: 100%">
                                                    <ice:panelLayout id="StatusContainer" style="height: 180px; position: absolute; width: 100%"/>
                                                </ice:panelGroup>
                                            </ice:panelGrid>
                                        </ice:panelCollapsible>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="center">
                            <ice:panelGroup id="page_display" style="height: 820px">
                                <ice:panelLayout id="container" layout="flow"
                                    style="height: 811px; left: 0px; top:60px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                    <fieldset class="filedset_css" style="height: 750px;">
                                        <legend class="legend_css">
                                            <ice:outputLabel value="#{msgAttendance.MaintainAttendanceRecord}"/>
                                        </legend>
                                        <ice:panelLayout id="pnProfile" style="height: 770px; left: 0px; top: 24px; position: absolute; width: 100%">
                                            <ice:panelGroup id="RetirementApproval" style="height: 695px" styleClass="filedset_border">
                                                <ice:inputText binding="#{Attendance$AttendancePage.txtfAbsentDate}" id="txtfAbsentDate" partialSubmit="true" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 30px; position: absolute; width: 190px"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnListEmployees_action}"
                                                    binding="#{Attendance$AttendancePage.btnListEmployees}" id="btnListEmployees" partialSubmit="true"
                                                    style="left: 500px; top: 250px; position: absolute; width: 125px" value="Add"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnSave_action}"
                                                    binding="#{Attendance$AttendancePage.btnSave}" disabled="true" id="btnSave" partialSubmit="true"
                                                    style="left: 190px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Save}"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnUpdate_action}"
                                                    binding="#{Attendance$AttendancePage.btnUpdate}" disabled="true" id="btnUpdate" partialSubmit="true"
                                                    style="left: 335px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Update}"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnDelete_action}"
                                                    binding="#{Attendance$AttendancePage.btnDelete}" disabled="true" id="btnDelete"
                                                    style="left: 620px; top: 660px; position: absolute; width: 120px" value="Delete"/>
                                                <ice:panelLayout id="pnlAbsentee" style="border: 1px solid rgb(204, 204, 204); height: 350px; left: 30px; top: 300px; overflow: auto; position: absolute; width: 732px">
                                                    <ice:dataTable binding="#{Attendance$AttendancePage.tblAbsentee}" id="tblAbsentee"
                                                        style="  top: -10px; position: absolute; width: 100%"
                                                        value="#{Attendance$AttendancePage.attendanceAbsenteesLoad}" var="currentRow">
                                                        <ice:column id="column2">
                                                            <ice:outputText id="outputText4" value="#{currentRow['empId']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText6" value="Employee id"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colEmpFullName1" style="width:250px;cursor:pointer;">
                                                            <h:outputText id="outputTex234t5" value="#{currentRow['empFullName']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText71" value="Full Name"/>
                                                            </f:facet>
                                                            <ice:rowSelector id="rwSelectorPeriodList" immediate="true" multiple="false"
                                                                selectionListener="#{Attendance$AttendancePage.rwSelectorPeriodList_processMyEvent}" value="#{currentRow['selectedEmp']}"/>
                                                        </ice:column>
                                                        <ice:column id="column3">
                                                            <ice:outputText id="outputText10" value="#{currentRow['absentAmout']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="outputText11" value="Absent"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colDayCval">
                                                            <ice:outputText id="txtDayVal" value="#{currentRow['dayDescription']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblDayVal" value="Day Value"/>
                                                            </f:facet>
                                                        </ice:column>
                                                        <ice:column id="colAbsentType">
                                                            <ice:outputText id="txtAbsentType" value="#{currentRow['absentType']}"/>
                                                            <f:facet name="header">
                                                                <ice:outputText id="lblAbsentType" value="Absent Type"/>
                                                            </f:facet>
                                                        </ice:column>
                                                    </ice:dataTable>
                                                </ice:panelLayout>
                                                <ice:outputLabel id="lblDate" style="font-size: 12px; left: 600px; top: -20px; position: absolute" value="#{msgAttendance.currentDate}"/>
                                                <ice:outputLabel id="outputLabel2" style="font-size: 12px; left: 40px; top: 35px; position: absolute" value="#{msgAttendance.Date}"/>
                                                <ice:outputLabel id="outputLabel1" style="font-size: 12px; left: 40px; top: 110px; position: absolute" value="Employee Name :"/>
                                                <ice:outputLabel binding="#{Attendance$AttendancePage.stxtDate}" id="stxtDate" style="color: rgb(153, 102, 0); font-size: 12px; font-weight: bold; left: 680px; top: -21px; position: absolute; width: 104px"/>
                                                <ice:outputText id="lblEmployeeName" style="font-size: 12px; left: 40px; top: 165px; position: absolute" value="Employee Full Name :"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.calDateAttendace_action}"
                                                    binding="#{Attendance$AttendancePage.calDateAttendace}" id="calDateAttendace"
                                                    image="/resources/images/cal_button.gif" partialSubmit="true"
                                                    style="left: 345px; top: 36px; position: absolute" value="submit"/>
                                                <ice:outputLabel id="drlReportedByEmployeeID" rendered="false" style="left: 200px; top: 10px; position: absolute; width: 100px"/>
                                                <ice:outputLabel id="htxtfAppEmpId" rendered="false" style="left: 100px; top: 10px; position: absolute; width: 100px"/>
                                                <ice:outputLabel id="htxtfCertEmpId" rendered="false" style="left: 10px; top: 10px; position: absolute; width: 105px"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnTakeAttendance_action}" id="btnTakeAttendance"
                                                    partialSubmit="true" style="left: 45px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.New}"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnCancelAttendance_action}" id="btnCancelAttendance"
                                                    partialSubmit="true" style="left: 480px; top: 660px; position: absolute; width: 120px" value="#{msgAttendance.Cancel}"/>
                                                <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtfAbsentDate" id="message1"
                                                    infoClass="infoMessage" style="font-size: 11px; left: 370px; top: 35px; position: absolute; width: 146px" warnClass="warnMessage"/>
                                                <ice:outputText id="lblAttendanceIdDB" rendered="false"/>
                                                <ice:outputText id="outputText1" style="font-size: 12px; left: 40px; top: 65px; position: absolute" value="Timekeeper Full Name"/>
                                                <ice:outputText id="outputText5" rendered="false"
                                                    style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 50px; top: 400px; position: absolute" value="R : Report"/>
                                                <ice:outputText id="outputText7" rendered="false"
                                                    style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 150px; top: 400px; position: absolute" value="C : Cancel"/>
                                                <ice:outputText id="outputText8" rendered="false"
                                                    style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 250px; top: 400px; position: absolute" value="MT : Measure Taken"/>
                                                <ice:outputText id="outputText9" rendered="false"
                                                    style="color: rgb(0, 51, 0); font-family: Cambria; font-size: 14px; font-weight: bold; left: 420px; top: 400px; position: absolute" value="MR : Measure Revoked"/>
                                                <ice:outputText binding="#{Attendance$AttendancePage.lblFullName}" id="lblFullName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 170px; top: 60px; position: absolute; width: 507px"/>
                                                <!-- <ice:selectOneMenu  disabled="true"
                                                    id="dlstEmployeeLists" partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 305px; position: absolute; width: 341px"
                                                    value="#{Attendance$AttendancePage.defaultSelectedData9.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.dlstEmployeeLists_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Attendance$AttendancePage.employeeFiltered}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.dlstAbsenceType}" disabled="true" id="dlstAbsenceType"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 340px; position: absolute; width: 120px" value="#{Attendance$AttendancePage.defaultSelectedData10.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems3" value="#{Attendance$AttendancePage.stateType}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.dlstValue}" disabled="true" id="dlstValue"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 340px; position: absolute; width: 120px" value="#{Attendance$AttendancePage.defaultSelectedData11.selectedObject}">
                                                    <f:selectItems id="selectOneMenu2selectItems1" value="#{Attendance$AttendancePage.stateValue}"/>
                                                </ice:selectOneMenu>
                                                -->
                                                <ice:outputLabel id="outputLabel6" style="font-size: 12px; left: 40px; top: 220px; position: absolute" value="Select Absence Value :"/>
                                                <!--
                                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.chkInclude}" id="chkInclude"
                                                    partialSubmit="true" style="left: 380px; top: 285px; position: absolute"
                                                    value="#{Attendance$AttendancePage.defaultSelectedData12.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.chkInclude_processValueChange}"/>
                                                <ice:outputLabel id="outputLabel8" style="font-size: 12px; left: 40px; top: 375px; position: absolute" value="Record Found :"/>
                                                <ice:outputLabel binding="#{Attendance$AttendancePage.lblRecourd}" id="lblRecourd" style="font-size: 12px; left: 120px; top: 375px; position: absolute"/>
                                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.chkBasic}" id="chkBasic" partialSubmit="true"
                                                    style="left: 220px; top: 285px; position: absolute"
                                                    value="#{Attendance$AttendancePage.defaultSelectedData13.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.chkBasic_processValueChange}"/>
                                                <ice:outputLabel id="outputLabel9" style="font-size: 12px; left: 170px; top: 285px; position: absolute" value="Basic :"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnGetEmployee_action}" id="btnGetEmployee"
                                                    partialSubmit="true" style="left: 535px; top: 290px; position: absolute; width: 125px" value="Get Employee"/>
                                                    -->
                                                <ice:selectInputText action="#{Attendance$AttendancePage.txtSearchByName_action}"
                                                    binding="#{Attendance$AttendancePage.txtSearchByName}" id="txtSearchByName"
                                                    listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true" rows="10"
                                                    style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 105px; position: absolute; width: 350px" valueChangeListener="#{ApplicationBean1.updateList}">
                                                    <f:facet name="selectInputText">
                                                        <ice:panelGrid columnClasses="empIdCol,fullNameCol" columns="2" style="width:150px">
                                                            <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                            <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                        </ice:panelGrid>
                                                    </f:facet>
                                                </ice:selectInputText>
                                                <ice:outputText id="lblEmployeeId" style="font-size: 12px; left: 400px; top: 110px; position: absolute" value=" "/>
                                                <ice:inputText binding="#{Attendance$AttendancePage.txtEmployeeId}" id="txtEmployeeId" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 500px; top: 105px; position: absolute; width: 174px"/>
                                                <ice:commandButton action="#{Attendance$AttendancePage.btnSearch_action}"
                                                    binding="#{Attendance$AttendancePage.btnSearch}" id="btnSearch" image="/Employee/images/btn_search.gif"
                                                    style="left: 610px; top: 108px; position: absolute" value="submit"/>
                                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.drlAbsentValue}" id="drlAbsentValue"
                                                    partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 170px; top: 218px; position: absolute; width: 174px"
                                                    value="#{Attendance$AttendancePage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.drlAbsentValue_processValueChange}">
                                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Attendance$AttendancePage.stateLists}"/>
                                                </ice:selectOneMenu>
                                                <ice:selectInputDate binding="#{Attendance$AttendancePage.calenderDate}" id="calenderDate" rendered="false"
                                                    style="height: 212px; left: 163px; top: 55px; position: absolute; width: 190px; z-index: 1000"
                                                    value="#{Attendance$AttendancePage.selectInputDate1Bean.date1}" valueChangeListener="#{Attendance$AttendancePage.calenderDate_processValueChange}"/>
                                                <ice:outputText binding="#{Attendance$AttendancePage.lblAfternoon}" id="lblAfternoon"
                                                    style="font-size: 12px; left: 270px; top: 255px; position: absolute" value="Afternoon"/>
                                                <ice:outputText binding="#{Attendance$AttendancePage.lblMorning}" id="lblMorning"
                                                    style="font-size: 12px; left: 170px; top: 255px; position: absolute" value="Morning "/>
                                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.chkMorning}" id="chkMorning"
                                                    partialSubmit="true" style="font-size: 12px; left: 220px; top: 257px; position: absolute"
                                                    value="#{Attendance$AttendancePage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.chkMorning_processValueChange}"/>
                                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.chkAfternoon}" id="chkAfternoon"
                                                    partialSubmit="true" style="font-size: 12px; left: 333px; top: 257px; position: absolute"
                                                    value="#{Attendance$AttendancePage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.chkAfternoon_processValueChange}"/>
                                                <ice:outputText id="outputText2" style="font-size: 12px; left: 420px; top: 220px; position: absolute" value="Absence Type:"/>
                                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.drlAbsentType}" id="drlAbsentType" partialSubmit="true"
                                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 550px; top: 218px; position: absolute; width: 174px" value="#{Attendance$AttendancePage.defaultSelectedData3.selectedObject}">
                                                    <f:selectItems id="selectOneMenu1selectItems1" value="#{Attendance$AttendancePage.leaveType}"/>
                                                </ice:selectOneMenu>
                                                <ice:commandLink action="#{Attendance$AttendancePage.linLongAbsent_action}" id="linLongAbsent"
                                                    style="left: 40px; top: 270px; position: absolute" value="Long Absent"/>
                                                <ice:inputText binding="#{Attendance$AttendancePage.txtAbsentEmployeeFullName}" disabled="true"
                                                    id="txtAbsentEmployeeFullName" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 170px; top: 165px; position: absolute; width: 507px"/>
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
                                            style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright  2005-2006 Ethiopian Calander | <a
                                            href="http://www.google.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelBorder>
                    <!--
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.pnlpopupAbsentee}" clientOnly="true" draggable="true"
                        id="pnlpopupAbsentee" modal="true" positionOnLoadOnly="true" rendered="true" style="display: block; height: 278px; left: 97px; top: 226px; position: absolute; width: 634px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpRequestProcessed" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpRequestProcessedTitle" style="width:400px" styleClass="popupHeaderText" value="Federal Police Human Resource Management System - Manage Absentees"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.modalPnlCloseBtnRequestProcessed_action}" alt="Close"
                                    id="modalPnlCloseBtnRequestProcessed" image="/resources/images/close.gif" immediate="true"
                                    style="left: 614px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlgroupPopUpRequestProcessed" style="display: block; height: 209px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:outputLabel id="lblRequestProcessedHistory" style="left: 300px; top: 20px; position: absolute" value="By Name :"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.stxtEmpFirstName}" disabled="true" id="stxtEmpFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 135px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblProcessedByFullName" style="left: 50px; top: 116px; position: absolute" value="Employee Full Name"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.stxtEmpMiddleName}" disabled="true" id="stxtEmpMiddleName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 225px; top: 134px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblProcessedByJobPosition" style="left: 400px; top: 53px; position: absolute" value="Attendance State"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.stxtEmpLastName}" disabled="true" id="stxtEmpLastName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 135px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblDateProcessed" style="left: 50px; top: 53px; position: absolute" value="Employee List"/>
                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.drlEmpList}" id="drlEmpList" partialSubmit="true"
                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 71px; position: absolute; width: 160px"
                                    value="#{Attendance$AttendancePage.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.drlEmpList_processValueChange}">
                                    <f:selectItems id="selectOneMenu2selectItems" value="#{Attendance$AttendancePage.employeeLists}"/>
                                </ice:selectOneMenu>
                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.drlAttendanceState}" id="drlAttendanceState"
                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 71px; position: absolute; width: 160px"
                                    value="#{Attendance$AttendancePage.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.drlAttendanceState_processValueChange}">
                                    <f:selectItems id="selectOneMenu1selectItems" value="#{Attendance$AttendancePage.stateLists}"/>
                                </ice:selectOneMenu>
                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.ckbByIdentification}" id="ckbByIdentification"
                                    partialSubmit="true" style="left: 245px; top: 22px; position: absolute"
                                    value="#{Attendance$AttendancePage.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.ckbByIdentification_processValueChange}"/>
                                <ice:selectBooleanCheckbox binding="#{Attendance$AttendancePage.ckbByName}" id="ckbByName" partialSubmit="true"
                                    style="left: 355px; top: 22px; position: absolute"
                                    value="#{Attendance$AttendancePage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Attendance$AttendancePage.ckbByName_processValueChange}"/>
                                <ice:outputLabel id="lblRequestProcessedHistory1" style="left: 150px; top: 20px; position: absolute" value="By Identification :"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnAddAbsenteesPOP_action}"
                                    binding="#{Attendance$AttendancePage.btnAddAbsenteesPOP}" disabled="true" id="btnAddAbsenteesPOP"
                                    style="left: 200px; top: 170px; position: absolute; width: 110px" value="Add"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnUpdateAbsenteesPOP_action}"
                                    binding="#{Attendance$AttendancePage.btnUpdateAbsenteesPOP}" disabled="true" id="btnUpdateAbsenteesPOP"
                                    style="left: 400px; top: 170px; position: absolute; width: 110px" value="Update"/>
                                <ice:panelLayout  id="pnMess"
                                    style="left: 5px; top:2px;position: absolute; width: 450px" styleClass="message2">
                                    <ice:outputLabel id="lblAbsenteePopUpMsg" style="text-align: center; vertical-align: middle; font-size: 11px; height: 16px; left: 5px; top: 2px; position: absolute; text-align: left; width: 391px"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>

                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.pnlAttendaneReport}" clientOnly="true" draggable="false"
                        id="pnlAttendaneReport" modal="true" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 303px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnlAttendaneReport" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 738px">
                                <ice:outputText id="pnMessageTitlepnlAttendaneReport"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Federal Police Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{Attendance$AttendancePage.modalPnlClosepnlAttendaneReport_action}"
                                    id="modalPnlClosepnlAttendaneReport" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 755px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup dragListener="#{Attendance$AttendancePage.panelGrouppnlAttendaneReport_processMyEvent}"
                                id="panelGrouppnlAttendaneReport" style="display: block; height: 256px; position: relative; width: 699px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlAttendaneReportBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 221px; position: relative; width: 632px; -rave-layout: grid" styleClass="message">
                                    <ice:selectOneMenu binding="#{Attendance$AttendancePage.lstPrintDiretorate}" id="lstPrintDiretorate" partialSubmit="true"
                                        style="left: 430px; top: 40px; position: absolute; width: 200px"
                                        value="#{Attendance$AttendancePage.defaultSelectedData5.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.lstPrintDiretorate_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems4" value="#{Attendance$AttendancePage.lstPrintDiretorateDefaultItems}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Attendance$AttendancePage.lstPrintCooperative}" id="lstPrintCooperative" partialSubmit="true"
                                        style="left: 430px; top: 80px; position: absolute; width: 200px"
                                        value="#{Attendance$AttendancePage.defaultSelectedData6.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.lstPrintCooperative_processValueChange}">
                                        <f:selectItems id="selectOneMenu2selectItems2" value="#{Attendance$AttendancePage.lstPrintCooperativeDefaultItems}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Attendance$AttendancePage.lstPrintDivision}" id="lstPrintDivision" partialSubmit="true"
                                        style="left: 115px; top: 80px; position: absolute; width: 200px"
                                        value="#{Attendance$AttendancePage.defaultSelectedData7.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.lstPrintDivision_processValueChange}">
                                        <f:selectItems id="selectOneMenu3selectItems" value="#{Attendance$AttendancePage.lstPrintDivisionDefaultItems}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Attendance$AttendancePage.lstPrintSector}" id="lstPrintSector" partialSubmit="true"
                                        style="left: 115px; top: 40px; position: absolute; width: 200px"
                                        value="#{Attendance$AttendancePage.defaultSelectedData8.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.lstPrintSector_processValueChange}">
                                        <f:selectItems id="selectOneMenu4selectItems" value="#{Attendance$AttendancePage.lstPrintSectorDefaultItems}"/>
                                    </ice:selectOneMenu>
                                    <ice:inputText binding="#{Attendance$AttendancePage.txtPrintToDate}" id="txtPrintToDate" partialSubmit="true"
                                        required="true" style="left: 430px; top: 160px; position: absolute; width: 200px"/>
                                    <ice:inputText binding="#{Attendance$AttendancePage.txtPrintFromDate}" id="txtPrintFromDate" partialSubmit="true"
                                        required="true" style="left: 115px; top: 160px; position: absolute; width: 200px"/>
                                    <ice:commandButton action="#{Attendance$AttendancePage.btnPrintPriviewPrint_action}"
                                        binding="#{Attendance$AttendancePage.btnPrintPriviewPrint}" id="btnPrintPriviewPrint" immediate="true"
                                        partialSubmit="true" style="left: 469px; top: 203px; position: absolute; width: 164px" value="Print Preview"/>
                                    <ice:outputText id="outputText10" style="font-size: 12px; left: 30px; top: 45px; position: absolute" value="Sector :"/>
                                    <ice:outputText id="outputText11" style="left: 340px; top: 165px; position: absolute" value="To Date :"/>
                                    <ice:outputText id="outputText12" style="left: 340px; top: 85px; position: absolute" value="Cooperative :"/>
                                    <ice:outputText id="outputText13" style="left: 340px; top: 45px; position: absolute" value="Directorate :"/>
                                    <ice:outputText id="outputText14" style="left: 30px; top: 85px; position: absolute" value="Division :"/>
                                    <ice:outputText id="outputText15" style="left: 30px; top: 165px; position: absolute" value="From Date :"/>
                                    <ice:selectOneMenu binding="#{Attendance$AttendancePage.lstPrintTeam}" id="lstPrintTeam" partialSubmit="true"
                                        style="left: 115px; top: 120px; position: absolute; width: 200px"
                                        value="#{Attendance$AttendancePage.selectOneMenu5Bean.selectedObject}" valueChangeListener="#{Attendance$AttendancePage.lstPrintTeam_processValueChange}">
                                        <f:selectItems id="selectOneMenu5selectItems" value="#{Attendance$AttendancePage.lstPrintTeamDefaultItems}"/>
                                    </ice:selectOneMenu>
                                    <ice:outputText id="outputText16" style="left: 30px; top: 125px; position: absolute" value="Team :"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>







                        -->
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.pnlMonthlyPayRollDay}" clientOnly="true" draggable="true"
                        id="pnlMonthlyPayRollDay" modal="true" positionOnLoadOnly="true" rendered="false" style="display: block; height: 278px; left: 97px; top: 226px; position: absolute; width: 634px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpRPayRollDay" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpProcessedTitlePayRollDay" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System - Manage  Month Absent Dates"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.CloseBtnRequestProcessedPayRollDay_action}" alt="Close"
                                    id="CloseBtnRequestProcessedPayRollDay" image="/resources/images/close.gif" immediate="true"
                                    style="left: 614px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlgroupPopUpRequestPayRollDay" style="display: block; height: 209px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:inputText binding="#{Attendance$AttendancePage.stxtDateFrom}" disabled="true" id="stxtDateFrom" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 130px; top: 100px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblDateFrom" style="left: 30px; top: 100px; position: absolute" value="Date From"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.stxtToDate}" disabled="true" id="stxtToDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240);                                 left: 400px; top: 100px; position: absolute; width: 160px"/>
                                <ice:outputLabel id="lblDateTo" style="left: 350px; top: 100px; position: absolute" value="To"/>
                                <ice:outputLabel id="lblMonth" style="left: 30px; top: 40px; position: absolute" value="Month :"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnSavePayrollDate_action}" id="btnSavePayrollDate"
                                    style="left: 200px; top: 170px; position: absolute; width: 110px" value="Save"/>
                                <ice:selectOneMenu binding="#{Attendance$AttendancePage.drlMonth}" id="drlMonth" partialSubmit="true"
                                    style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 130px; top: 40px; position: absolute; width: 160px" value="#{Attendance$AttendancePage.defaultSelectedData4.selectedObject}">
                                    <f:selectItems id="selectOneMenu1selectItems2" value="#{Attendance$AttendancePage.monthLists}"/>
                                </ice:selectOneMenu>
                                <ice:selectInputDate binding="#{Attendance$AttendancePage.calDateFrom}" id="calDateFrom" rendered="false"
                                    style="height: 212px; left: 100px; top: 120px; position: absolute; width: 190px;z-index:200"
                                    value="#{Attendance$AttendancePage.selectInputDateBean2.date1}" valueChangeListener="#{Attendance$AttendancePage.calDateFrom_processValueChange}"/>
                                <ice:selectInputDate binding="#{Attendance$AttendancePage.calToDate}" id="calToDate" rendered="false"
                                    style="height: 212px; left: 385px; top: 120px; position: absolute; width: 190px; z-index: 200"
                                    value="#{Attendance$AttendancePage.selectInputDateBean3.date1}" valueChangeListener="#{Attendance$AttendancePage.calToDate_processValueChange}"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.bntCalDateFrom_action}" id="bntCalDateFrom"
                                    image="/resources/images/cal_button.gif" style="left: 275px; top: 105px; position: absolute" value="submit"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.bntCalDateTo_action}" id="bntCalDateTo"
                                    image="/resources/images/cal_button.gif" style="left: 545px; top: 105px; position: absolute" value="submit"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.employeePlanPopUpMsg}" draggable="true" id="employeePlanPopUpMsg"
                        modal="true" rendered="fasle" style="display: block; height: 156px; left: 97px; top: 500px; position: absolute; width: 623px">
                        <f:facet name="header">
                            <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                <ice:outputText id="lblemployeePopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Cement Enterprise Human Resource Management "/>
                            </ice:panelGrid>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                <ice:commandButton action="#{Attendance$AttendancePage.btntemployeePopUpNo_action}" id="btntemployeePopUpNo" immediate="true"
                                    partialSubmit="true" rendered="true" style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="No" visible="true"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btntemployeePopUpYes_action}" id="btntemployeePopUpYes" immediate="true"
                                    partialSubmit="true" rendered="true"
                                    style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                    value="Yes" visible="true"/>
                                <ice:outputText binding="#{Attendance$AttendancePage.lblemployeePopUpMsgMain}" id="lblemployeePopUpMsgMain" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px"/>
                                <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                    style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.pnlpopupAbsentee}" clientOnly="true" draggable="true"
                        id="pnlpopupAbsentee" modal="true" positionOnLoadOnly="true" rendered="false" style="display: block; height: 278px; left: 97px; top: 226px; position: absolute; width: 634px">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridPopUpRequestProcessed1" styleClass="popupHeaderWrapper">
                                <ice:outputText id="PopUpRequestProcessedTitle1" style="width:400px" styleClass="popupHeaderText" value="BUNNA INTERNATIONAL BANK Human Resource Management System - Manage Absentees"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.modalPnlCloseBtnRequestProcessed1_action}" alt="Close"
                                    id="modalPnlCloseBtnRequestProcessed1" image="/resources/images/close.gif" immediate="true"
                                    style="left: 614px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="pnlgroupPopUpRequestProcessed1" style="display: block; height: 209px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:outputLabel binding="#{Attendance$AttendancePage.lblEmployeeFullName}" id="lblEmployeeFullName"
                                    style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 170px; top: 17px; position: absolute; width: 406px" value=":"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.txtAbsentStartDate}" disabled="true" id="txtAbsentStartDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 170px; top: 67px; position: absolute; width: 188px"/>
                                <ice:inputText binding="#{Attendance$AttendancePage.txtAbsentEndDate}" disabled="true" id="txtAbsentEndDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 170px; top: 111px; position: absolute; width: 188px"/>
                                <ice:outputLabel id="lblProcessedByJobPosition1" style="left: 50px; top: 110px; position: absolute" value="End Date :"/>
                                <ice:outputLabel id="lblDateProcessed1" style="left: 50px; top: 65px; position: absolute" value="Start Date"/>
                                <ice:outputLabel id="lblRequestProcessedHistory11" style="left: 50px; top: 20px; position: absolute" value="Employee Full Name :"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnAddAbsenteesPOP_action}" id="btnAddAbsenteesPOP"
                                    style="left: 200px; top: 170px; position: absolute; width: 110px" value="#{msgAttendance.Save}"/>
                                <ice:panelLayout id="pnlPopUpHeader1" style="left: 5px; top:2px;position: absolute; width: 450px" styleClass="message2">
                                    <ice:outputLabel id="lblAbsenteePopUpMsg1" style="text-align: center; vertical-align: middle; font-size: 11px; height: 16px; left: 5px; top: 2px; position: absolute; text-align: left; width: 391px"/>
                                </ice:panelLayout>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnStartDate_action}" id="btnStartDate1"
                                    image="/resources/images/cal_button.gif" style="left: 343px; top: 72px; position: absolute" value="submit"/>
                                <ice:commandButton action="#{Attendance$AttendancePage.btnEndDate_action}" id="btnEndDate1"
                                    image="/resources/images/cal_button.gif" style="left: 343px; top: 116px; position: absolute" value="submit"/>
                                <ice:selectInputDate binding="#{Attendance$AttendancePage.calStartDate}" id="calStartDate1" popupDateFormat="yyyy-MM-dd"
                                    rendered="false" style="height: 212px; left: 170px; top: 90px; position: absolute; width: 190px"
                                    value="#{Attendance$AttendancePage.selectInputDateBean1.date1}" valueChangeListener="#{Attendance$AttendancePage.calStartDate_processValueChange}"/>
                                <ice:selectInputDate binding="#{Attendance$AttendancePage.calEndDate}" id="calEndDate1" popupDateFormat="yyyy-MM-dd"
                                    rendered="false" style="height: 212px; left: 170px; top: 135px; position: absolute; width: 190px"
                                    value="#{Attendance$AttendancePage.selectInputDate2Bean.date1}" valueChangeListener="#{Attendance$AttendancePage.calEndDate_processValueChange}"/>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                    <ice:panelPopup autoCentre="true" binding="#{Attendance$AttendancePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                        modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnMessageTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management"/>
                                <ice:commandLink action="#{Attendance$AttendancePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout id="pnlMessageBody" layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{Attendance$AttendancePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
