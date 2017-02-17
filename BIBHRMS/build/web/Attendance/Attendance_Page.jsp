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
        <f:loadBundle basename="Localization.HRLocalization" var="msgs"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
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
                    function IncrementSalaryRequest(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <f:loadBundle basename="Localization.HR_Localization_Termination" var="msgAttendance"/>
                    <div>
                        <img alt="" class="source-image" height="1355px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Attendance$Attendance_Page.panelBorder1Bean.renderCenter}"
                            renderEast="#{Attendance$Attendance_Page.panelBorder1Bean.renderEast}"
                            renderNorth="#{Attendance$Attendance_Page.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Attendance$Attendance_Page.panelBorder1Bean.renderSouth}"
                            renderWest="#{Attendance$Attendance_Page.panelBorder1Bean.renderWest}" style="top: 0px; position: relative" styleClass="whole_page" width="1024px">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:910px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:1210px;top:15px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:1210px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="#{msgAttendance.Search}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%">
                                                    <ice:panelGroup id="btnSearchEmployeeState" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 240px; width: 100%">
                                                        <ice:outputLabel id="lblDateOfAttandanceTaken"
                                                            style="left: 10px; top: 40px; position: absolute; text-align: center; width: 177px" value="#{msgAttendance.Date}"/>
                                                        <ice:inputText binding="#{Attendance$Attendance_Page.txtfAbsentDateSearch}" id="txtfAbsentDateSearch"
                                                            required="true" style="border: 1px solid rgb(115, 179, 206); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 15px; top: 60px; position: absolute; width: 180px"/>
                                                        <ice:outputLabel id="lblAttandanceForDepartmentTaken"
                                                            style="left: 10px; top: 100px; position: absolute; text-align: center; width: 177px" value="#{msgAttendance.ForDepartment}"/>
                                                        <ice:selectOneMenu binding="#{Attendance$Attendance_Page.ddlDepartmentListsSearch}"
                                                            id="ddlDepartmentListsSearch" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); left: 15px; top: 120px; position: absolute; width: 180px"
                                                            value="#{Attendance$Attendance_Page.defaultSelectedData4.selectedObject}" valueChangeListener="#{Attendance$Attendance_Page.ddlDepartmentListsSearch_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Attendance$Attendance_Page.departmentLists}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Attendance$Attendance_Page.btnSearchAttendance_action}"
                                                            binding="#{Attendance$Attendance_Page.btnSearchAttendance}" id="btnSearchAttendance"
                                                            partialSubmit="true" style="left: 30px; top: 230px; position: absolute; width: 153px" value="#{msgAttendance.Search}"/>
                                                        <ice:commandButton action="#{Attendance$Attendance_Page.btnCalDateAttendaceSearch_action}"
                                                            binding="#{Attendance$Attendance_Page.btnCalDateAttendaceSearch}" id="btnCalDateAttendaceSearch"
                                                            image="/resources/images/cal_icon.JPG" partialSubmit="true"
                                                            style="left: 175px; top: 64px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Attendance$Attendance_Page.calSearchDate}" id="calSearchDate"
                                                            rendered="false" style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                            value="#{Attendance$Attendance_Page.selectInputDateBean2.date1}" valueChangeListener="#{Attendance$Attendance_Page.calSearchDate_processValueChange}"/>
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
                                                    <ice:panelGroup id="commonTasksGroup_Group" style="height:200px;width:100%">
                                                        <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                            <li>
                                                                <ice:commandLink id="lnkResignationType" style="color:#306682;font-weight:bold" value="#{msgAttendance.Leave}"/>
                                                            </li>
                                                            <li>
                                                                <ice:commandLink id="lnkTerminationClearance" style="color:#306682;font-weight:bold" value="#{msgAttendance.ClearanceManagement}"/>
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
                                                    <ice:panelGroup dragListener="#{Attendance$Attendance_Page.status_Group_processMyEvent}" id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;display: block;float:left;height: 530px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 450px; width: 100%">
                                                            <ice:outputLabel id="outputLabel18"
                                                                style="font-weight: bold; top: 10px; position: absolute; text-align: center; width: 177px" value="#{msgAttendance.DailyIssuedAttendanceForDepartments}"/>
                                                            <ice:selectOneListbox binding="#{Attendance$Attendance_Page.lstAttendanceReport}"
                                                                id="lstAttendanceReport" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 160px; left: 0px; top: 50px; position: absolute; width: 188px"
                                                                value="#{Attendance$Attendance_Page.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Attendance$Attendance_Page.lstAttendanceReport_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Attendance$Attendance_Page.dayliyAttendanceIssuesed}"/>
                                                            </ice:selectOneListbox>
                                                            <ice:selectOneListbox binding="#{Attendance$Attendance_Page.listApprovedAttendance}"
                                                                id="listApprovedAttendance" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 160px; left: 0px; top: 270px; position: absolute; width: 188px"
                                                                value="#{Attendance$Attendance_Page.selectOneListbox2Bean.selectedObject}" valueChangeListener="#{Attendance$Attendance_Page.listApprovedAttendance_processValueChange}">
                                                                <f:selectItems id="selectOneListbox2selectItems" value="#{Attendance$Attendance_Page.dayliyAttendanceProcessed}"/>
                                                            </ice:selectOneListbox>
                                                            <ice:outputLabel id="outputLabel19"
                                                                style="font-weight: bold; left: -5px; top: 230px; position: absolute; text-align: center; width: 208px" value="#{msgAttendance.DailyApprovedAttendanceForDepartments}"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height: 1130px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1110px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1100px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="#{msgAttendance.MaintainAttendanceRecord}"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1100px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 1000px" styleClass="filedset_border">
                                                    <ice:panelLayout binding="#{Attendance$Attendance_Page.pnMessage}" id="pnMessage"
                                                        style="left: 0px; top:-107px;position: absolute; width: 720px" styleClass="message">
                                                        <h:outputLabel binding="#{Attendance$Attendance_Page.lblFormMessage}" id="lblFormMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:outputConnectionStatus displayHourglassWhenActive="true" id="connectionStatus" style="left: 750px; top: -84px; position: absolute; width: 25px"/>
                                                    <label style="left: 20px; top: 65px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 660px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 705px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 945px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 990px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <ice:inputText binding="#{Attendance$Attendance_Page.txtfAbsentDate}" id="txtfAbsentDate"
                                                        partialSubmit="true" required="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 30px; position: absolute; width: 113px"
                                                        styleClass="required" validator="#{Attendance$Attendance_Page.txtfAbsentDate_validate}" valueChangeListener="#{Attendance$Attendance_Page.txtfAbsentDate_processValueChange}"/>
                                                    <ice:inputTextarea binding="#{Attendance$Attendance_Page.txtaDescription}" disabled="true"
                                                        id="txtaDescription" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 150px; position: absolute; width: 565px"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnListEmployees_action}"
                                                        binding="#{Attendance$Attendance_Page.btnListEmployees}" disabled="true" id="btnListEmployees"
                                                        style="left: 35px; top: 220px; position: absolute; width: 125px" value="#{msgAttendance.ListEmployee}"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnSave_action}"
                                                        binding="#{Attendance$Attendance_Page.btnSave}" disabled="true" id="btnSave" partialSubmit="true"
                                                        style="left: 160px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.Save}"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnUpdate_action}"
                                                        binding="#{Attendance$Attendance_Page.btnUpdate}" disabled="true" id="btnUpdate" partialSubmit="true"
                                                        style="left: 390px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.Update}"/>
                                                    <ice:commandButton binding="#{Attendance$Attendance_Page.btnDelete}" disabled="true" id="btnDelete"
                                                        partialSubmit="true" style="left: 620px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.Delete}"/>
                                                    <ice:outputLabel id="outputLabel3" style="font-size: 10px; left: 400px; top: 35px; position: absolute" value="#{msgAttendance.ForDepartment}"/>
                                                    <ice:panelLayout id="pnlAbsentee" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 361px; margin-left: 15px; left: 10px; top: 280px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:dataTable binding="#{Attendance$Attendance_Page.tblAbsentee}" headerClass="ceDatTblFtr"
                                                            id="tblAbsentee" style="top: -10px; position: absolute"
                                                            value="#{Attendance$Attendance_Page.attendanceAbsenteesLoad}" var="currentRow" width="732">
                                                            <f:facet name="header">
                                                                <ice:columnGroup>
                                                                    <ice:headerRow>
                                                                        <ice:column id="colEmpID" rowspan="2" style="width:100px;cursor:pointer;">
                                                                            <ice:outputText id="outputText2" value="#{msgAttendance.EmployeeId}"/>
                                                                        </ice:column>
                                                                        <ice:column id="colEmpFullName" rowspan="2" style="width:250px;cursor:pointer;">
                                                                            <ice:outputText id="outputText7" value="#{msgAttendance.FullName}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column3" rowspan="2">
                                                                            <ice:outputText id="outputText12" value="#{msgAttendance.Title}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column2" rowspan="2">
                                                                            <ice:outputText id="outputText10" value="#{msgAttendance.Rank}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column4" rowspan="2">
                                                                            <ice:outputText id="outputText14" value="#{msgAttendance.Position}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column1" rowspan="2">
                                                                            <ice:outputText id="outputText8" value="#{msgAttendance.Select}"/>
                                                                        </ice:column>
                                                                        <ice:column colspan="4" id="colHeader">
                                                                            <ice:outputText id="outputGroup" value="#{msgAttendance.Selectthestateoftheemployee}"/>
                                                                        </ice:column>
                                                                    </ice:headerRow>
                                                                    <ice:headerRow>
                                                                        <ice:column id="column5">
                                                                            <ice:outputText id="outputText6" value="#{msgAttendance.R}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column6">
                                                                            <ice:outputText id="outputText16" value="#{msgAttendance.C}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column7">
                                                                            <ice:outputText id="outputText18" value="#{msgAttendance.MT}"/>
                                                                        </ice:column>
                                                                        <ice:column id="column8">
                                                                            <ice:outputText id="outputText20" value="#{msgAttendance.MR}"/>
                                                                        </ice:column>
                                                                    </ice:headerRow>
                                                                </ice:columnGroup>
                                                            </f:facet>
                                                            <ice:column id="colEmpID" style="width:100px;cursor:pointer;">
                                                                <ice:outputText id="outputText1" value="#{currentRow['empId']}"/>
                                                            </ice:column>
                                                            <ice:column id="colEmpFullName" style="width:250px;cursor:pointer;">
                                                                <h:outputText id="outputText5" value="#{currentRow['empFullName']}"/>
                                                            </ice:column>
                                                            <ice:column id="column3">
                                                                <ice:outputText id="outputText11" value="#{currentRow['empTitle']}"/>
                                                            </ice:column>
                                                            <ice:column id="column4">
                                                                <ice:outputText id="outputText13" value="#{currentRow['empPosition']}"/>
                                                            </ice:column>
                                                            <ice:column id="column2">
                                                                <ice:outputText id="outputText9" value="#{currentRow['empRank']}"/>
                                                            </ice:column>
                                                            <ice:column id="column1">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkSelectEmployee}"
                                                                    disabled="true" id="chkSelectEmployee" partialSubmit="true"
                                                                    value="#{currentRow['selected']}" valueChangeListener="#{Attendance$Attendance_Page.chkSelectEmployee_processValueChange}"/>
                                                            </ice:column>
                                                            <ice:column id="column5">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkReport}" disabled="true"
                                                                    id="chkReport" partialSubmit="true" value="#{currentRow['report']}" valueChangeListener="#{Attendance$Attendance_Page.chkReport_processValueChange}"/>
                                                            </ice:column>
                                                            <ice:column id="column6">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkCancel}" disabled="true"
                                                                    id="chkCancel" partialSubmit="true" value="#{currentRow['cancel']}" valueChangeListener="#{Attendance$Attendance_Page.chkCancel_processValueChange}"/>
                                                            </ice:column>
                                                            <ice:column id="column7">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkMeasureTaken}"
                                                                    disabled="true" id="chkMeasureTaken" partialSubmit="true" value="#{currentRow['mtaken']}" valueChangeListener="#{Attendance$Attendance_Page.chkMeasureTaken_processValueChange}"/>
                                                            </ice:column>
                                                            <ice:column id="column8">
                                                                <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkMeasureRevoked}"
                                                                    disabled="true" id="chkMeasureRevoked" partialSubmit="true"
                                                                    value="#{currentRow['mrevoked']}" valueChangeListener="#{Attendance$Attendance_Page.chkMeasureRevoked_processValueChange}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:outputLabel id="outputLabel8" style="font-size: 11px; left: 70px; top: 750px; position: absolute" value="#{msgAttendance.ApproveAttendanceInformation}"/>
                                                    <ice:outputLabel id="outputLabel17" style="font-size: 11px; left: 450px; top: 750px; position: absolute" value="#{msgAttendance.CertifiedAttendanceInformation}"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtAppDate}" id="stxtAppDate" style="font-size: 11px; left: 300px; top: 750px; position: absolute; width: 136px"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtCertDate}" id="stxtCertDate" style="font-size: 11px; left: 680px; top: 750px; position: absolute; width: 78px"/>
                                                    <ice:panelLayout id="pnlApproval" style="border: 1px solid rgb(204, 204, 204); height: 150px; margin-left: 15px; left: 10px; top: 780px; overflow: auto; position: absolute; width: 732px">
                                                        <ice:outputLabel id="outputLabel9" style="font-size: 10px; left: 50px; top: 20px; position: absolute" value="#{msgAttendance.Title}"/>
                                                        <ice:outputLabel id="outputLabel10" style="font-size: 10px; left: 50px; top: 50px; position: absolute" value="#{msgAttendance.FullName}"/>
                                                        <ice:outputLabel id="outputLabel11" style="font-size: 10px; left: 50px; top: 80px; position: absolute" value="#{msgAttendance.Department}"/>
                                                        <ice:outputLabel id="outputLabel12" style="font-size: 10px; left: 50px; top: 110px; position: absolute" value="#{msgAttendance.Position}"/>
                                                        <ice:outputLabel id="outputLabel13" style="font-size: 10px; left: 430px; top: 20px; position: absolute" value="#{msgAttendance.Title}"/>
                                                        <ice:outputLabel id="outputLabel14" style="font-size: 10px; left: 430px; top: 50px; position: absolute" value="#{msgAttendance.FullName}"/>
                                                        <ice:outputLabel id="outputLabel15" style="font-size: 10px; left: 430px; top: 80px; position: absolute" value="#{msgAttendance.Department}"/>
                                                        <ice:outputLabel id="outputLabel16" style="font-size: 10px; left: 430px; top: 110px; position: absolute" value="#{msgAttendance.Position}"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtAppTitle}" id="stxtAppTitle" style="font-size: 10px; left: 120px; top: 20px; position: absolute; width: 193px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtAppFullName}" id="stxtAppFullName" style="font-size: 10px; left: 120px; top: 50px; position: absolute; width: 192px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtAppDept}" id="stxtAppDept" style="font-size: 10px; left: 120px; top: 80px; position: absolute; width: 193px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtAppJobPosition}" id="stxtAppJobPosition" style="font-size: 10px; left: 120px; top: 110px; position: absolute; width: 193px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtCertTitle}" id="stxtCertTitle" style="font-size: 10px; left: 505px; top: 20px; position: absolute; width: 194px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtCertFullName}" id="stxtCertFullName" style="font-size: 10px; left: 505px; top: 50px; position: absolute; width: 195px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtCertDept}" id="stxtCertDept" style="font-size: 10px; left: 505px; top: 80px; position: absolute; width: 197px"/>
                                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtCertJobPosition}" id="stxtCertJobPosition" style="font-size: 10px; left: 505px; top: 110px; position: absolute; width: 200px"/>
                                                        <ice:panelLayout id="pnlSeparator" style="border: 1px solid #CCCCCC; height: 105px; left: 370px; top: 20px; position: absolute; width: -1px; -webkit-border-radius: 12px;-moz-border-radius: 12px;"/>
                                                    </ice:panelLayout>
                                                    <ice:outputLabel id="outputLabel7" style="font-size: 10px; left: 40px; top: 115px; position: absolute" value="#{msgAttendance.ReporterDepartment}"/>
                                                    <ice:outputLabel id="outputLabel6" style="font-size: 10px; left: 400px; top: 115px; position: absolute;" value="#{msgAttendance.ReporterName}"/>
                                                    <ice:outputLabel id="outputLabel5" style="font-size: 10px; left: 400px; top: 80px; position: absolute" value="#{msgAttendance.ReporterJobPosition}"/>
                                                    <ice:outputLabel id="lblDate" style="font-size: 11px; left: 600px; top: -20px; position: absolute" value="#{msgAttendance.currentDate}"/>
                                                    <ice:outputLabel id="lblAttendanceId" style="font-size: 11px; left: 285px; top: -63px; position: absolute" value="#{msgAttendance.attendanceTakendate}"/>
                                                    <ice:outputLabel id="outputLabel2" style="font-size: 10px; left: 40px; top: 35px; position: absolute" value="#{msgAttendance.Date}"/>
                                                    <ice:outputLabel id="outputLabel1" style="font-size: 10px; left: 40px; top: 80px; position: absolute" value="#{msgAttendance.ReporterTitle}"/>
                                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtTitle}" disabled="true" id="stxtTitle" style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 150px; top: 75px; position: absolute; width: 200px"/>
                                                    <ice:inputText binding="#{Attendance$Attendance_Page.txtfReporterName}" disabled="true"
                                                        id="txtfReporterName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 515px; top: 110px; position: absolute; width: 200px"/>
                                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtDept}" disabled="true" id="stxtDept" style="color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 150px; top: 110px; position: absolute; width: 200px"/>
                                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtJobPosition}" disabled="true" id="stxtJobPosition" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 515px; top: 75px; position: absolute; width: 200px"/>
                                                    <ice:outputLabel id="outputLabel4" style="font-size: 10px; left: 40px; top: 150px; position: absolute" value="#{msgAttendance.ReporterRemark}"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.txtfAttendanceTakenDate}"
                                                        id="txtfAttendanceTakenDate" style="font-size: 11px; left: 415px; top: -63px; position: absolute; width: 104px"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.stxtDate}" id="stxtDate" style="color: rgb(153, 102, 0); font-size: 12px; font-weight: bold; left: 680px; top: -21px; position: absolute; width: 104px"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnCalDateAttendace_action}"
                                                        binding="#{Attendance$Attendance_Page.btnCalDateAttendace}" id="btnCalDateAttendace"
                                                        image="/resources/images/cal_icon.JPG" partialSubmit="true"
                                                        style="left: 245px; top: 34px; position: absolute" value="submit"/>
                                                    <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkBoxApprove}" disabled="true"
                                                        id="chkBoxApprove" partialSubmit="true" style="left: 260px; top: 752px; position: absolute"
                                                        value="#{Attendance$Attendance_Page.defaultSelectedData1.selectedBoolean}" valueChangeListener="#{Attendance$Attendance_Page.chkBoxApprove_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.chkBoxCertify}" disabled="true"
                                                        id="chkBoxCertify" partialSubmit="true" style="left: 640px; top: 752px; position: absolute"
                                                        value="#{Attendance$Attendance_Page.defaultSelectedData2.selectedBoolean}" valueChangeListener="#{Attendance$Attendance_Page.chkBoxCertify_processValueChange}"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.drlReportedByEmployeeID}"
                                                        id="drlReportedByEmployeeID" rendered="false" style="left: 200px; top: 10px; position: absolute; width: 100px"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.htxtfAppEmpId}" id="htxtfAppEmpId" rendered="false" style="left: 100px; top: 10px; position: absolute; width: 100px"/>
                                                    <ice:outputLabel binding="#{Attendance$Attendance_Page.htxtfCertEmpId}" id="htxtfCertEmpId" rendered="false" style="left: 10px; top: 10px; position: absolute; width: 105px"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnTakeAttendance_action}"
                                                        binding="#{Attendance$Attendance_Page.btnTakeAttendance}" id="btnTakeAttendance"
                                                        style="left: 45px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.New}"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnCancelAttendance_action}"
                                                        binding="#{Attendance$Attendance_Page.btnCancelAttendance}" disabled="true" id="btnCancelAttendance"
                                                        partialSubmit="true" style="left: 505px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.Cancel}"/>
                                                    <ice:selectOneMenu binding="#{Attendance$Attendance_Page.ddlDepartmentLists}" id="ddlDepartmentLists"
                                                        partialSubmit="true" required="true"
                                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 515px; top: 30px; position: absolute; width: 127px" value="#{Attendance$Attendance_Page.defaultSelectedData3.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems1" value="#{Attendance$Attendance_Page.departmentLists}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtfAbsentDate" id="message1"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 275px; top: 35px; position: absolute; width: 97px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="ddlDepartmentLists" id="message2"
                                                        infoClass="infoMessage" style="font-size: 11px; left: 670px; top: 35px; position: absolute; width: 85px" warnClass="warnMessage"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnEditAbsentee_action}"
                                                        binding="#{Attendance$Attendance_Page.btnEditAbsentee}" id="btnEditAbsentee" partialSubmit="true"
                                                        style="left: 275px; top: 660px; position: absolute; width: 90px" value="#{msgAttendance.Edit}"/>
                                                    <ice:outputLabel id="outputLabel20"
                                                        style="font-size: 12px; font-weight: bold; left: 70px; top: 710px; position: absolute" value="#{msgAttendance.ForAuthorizedPersonOnly}"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnApproveAttendance_action}"
                                                        binding="#{Attendance$Attendance_Page.btnApproveAttendance}" disabled="true" id="btnApproveAttendance"
                                                        partialSubmit="true" style="left: 220px; top: 945px; position: absolute; width: 130px" value="#{msgAttendance.ApproveAttendance}"/>
                                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnCertifyAttendance_action}"
                                                        binding="#{Attendance$Attendance_Page.btnCertifyAttendance}" disabled="true" id="btnCertifyAttendance"
                                                        partialSubmit="true" style="left: 420px; top: 945px; position: absolute; width: 130px" value="#{msgAttendance.CertifyAttendance}"/>
                                                    <ice:outputText binding="#{Attendance$Attendance_Page.lblAttendanceIdDB}" id="lblAttendanceIdDB" rendered="false"/>
                                                    <ice:selectInputDate binding="#{Attendance$Attendance_Page.calAttendanceTakenDate}"
                                                        id="calAttendanceTakenDate" rendered="false"
                                                        style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                        value="#{Attendance$Attendance_Page.selectInputDate1Bean.date1}" valueChangeListener="#{Attendance$Attendance_Page.calAttendanceTakenDate_processValueChange}"/>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.google.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION SYSTEM DIVISION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Attendance$Attendance_Page.pnlpopupAbsentee}" clientOnly="true" draggable="true"
                            id="pnlpopupAbsentee" modal="true" positionOnLoadOnly="true" rendered="false" style="display: block; height: 278px; left: 97px; top: 226px; position: absolute; width: 634px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpRequestProcessed" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpRequestProcessedTitle" style="width:400px" styleClass="popupHeaderText" value="Federal Police Human Resource Management System - Manage Absentees"/>
                                    <ice:commandButton action="#{Attendance$Attendance_Page.modalPnlCloseBtnRequestProcessed_action}" alt="Close"
                                        id="modalPnlCloseBtnRequestProcessed" image="/resources/images/close.gif" immediate="true"
                                        style="left: 614px; top: 2px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpRequestProcessed" style="display: block; height: 209px; position: relative; width: 586" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:outputLabel id="lblRequestProcessedHistory" style="left: 300px; top: 20px; position: absolute" value="By Name :"/>
                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtEmpFirstName}" disabled="true" id="stxtEmpFirstName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 135px; position: absolute; width: 160px"/>
                                    <ice:outputLabel id="lblProcessedByFullName" style="left: 50px; top: 116px; position: absolute" value="Employee Full Name"/>
                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtEmpMiddleName}" disabled="true" id="stxtEmpMiddleName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 225px; top: 134px; position: absolute; width: 160px"/>
                                    <ice:outputLabel id="lblProcessedByJobPosition" style="left: 400px; top: 53px; position: absolute" value="Attendance State"/>
                                    <ice:inputText binding="#{Attendance$Attendance_Page.stxtEmpLastName}" disabled="true" id="stxtEmpLastName" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 135px; position: absolute; width: 160px"/>
                                    <ice:outputLabel id="lblDateProcessed" style="left: 50px; top: 53px; position: absolute" value="Employee List"/>
                                    <ice:selectOneMenu binding="#{Attendance$Attendance_Page.drlEmpList}" id="drlEmpList" partialSubmit="true"
                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 50px; top: 71px; position: absolute; width: 160px"
                                        value="#{Attendance$Attendance_Page.selectOneMenu2Bean.selectedObject}" valueChangeListener="#{Attendance$Attendance_Page.drlEmpList_processValueChange}">
                                        <f:selectItems id="selectOneMenu2selectItems" value="#{Attendance$Attendance_Page.employeeLists}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectOneMenu binding="#{Attendance$Attendance_Page.drlAttendanceState}" id="drlAttendanceState"
                                        style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); left: 400px; top: 71px; position: absolute; width: 160px"
                                        value="#{Attendance$Attendance_Page.selectOneMenu1Bean.selectedObject}" valueChangeListener="#{Attendance$Attendance_Page.drlAttendanceState_processValueChange}">
                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Attendance$Attendance_Page.stateLists}"/>
                                    </ice:selectOneMenu>
                                    <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.ckbByIdentification}" id="ckbByIdentification"
                                        partialSubmit="true" style="left: 245px; top: 22px; position: absolute"
                                        value="#{Attendance$Attendance_Page.selectBooleanCheckbox2Bean.selectedBoolean}" valueChangeListener="#{Attendance$Attendance_Page.ckbByIdentification_processValueChange}"/>
                                    <ice:selectBooleanCheckbox binding="#{Attendance$Attendance_Page.ckbByName}" id="ckbByName" partialSubmit="true"
                                        style="left: 355px; top: 22px; position: absolute"
                                        value="#{Attendance$Attendance_Page.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Attendance$Attendance_Page.ckbByName_processValueChange}"/>
                                    <ice:outputLabel id="lblRequestProcessedHistory1" style="left: 150px; top: 20px; position: absolute" value="By Identification :"/>
                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnAddAbsenteesPOP_action}"
                                        binding="#{Attendance$Attendance_Page.btnAddAbsenteesPOP}" disabled="true" id="btnAddAbsenteesPOP"
                                        style="left: 200px; top: 170px; position: absolute; width: 110px" value="Add"/>
                                    <ice:commandButton action="#{Attendance$Attendance_Page.btnUpdateAbsenteesPOP_action}"
                                        binding="#{Attendance$Attendance_Page.btnUpdateAbsenteesPOP}" disabled="true" id="btnUpdateAbsenteesPOP"
                                        style="left: 400px; top: 170px; position: absolute; width: 110px" value="Update"/>
                                    <ice:panelLayout binding="#{Attendance$Attendance_Page.pnMessage2}" id="pnMessage2"
                                        style="left: 5px; top:2px;position: absolute; width: 450px" styleClass="message2">
                                        <ice:outputLabel binding="#{Attendance$Attendance_Page.lblAbsenteePopUpMsg}" id="lblAbsenteePopUpMsg" style="text-align: center; vertical-align: middle; font-size: 11px; height: 16px; left: 5px; top: 2px; position: absolute; text-align: left; width: 391px"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <div class="some" style="visibility:visible; z-index:999; position:absolute; top:-500px; left:-500px;">
                            <input id="cal_day_names" type="hidden" value="ሰ,ማ,ረ,�,ዓ,ቅ,እ"/>
                            <input id="cal_month_names" type="hidden" value="መስከረ�,ጥቅ�ት,ህዳር,ታህሳስ,ጥር,የካቲት,መጋቢት,ሚያ�ያ,�ንቦት,ሰኔ,ሀ�ሌ,�ሀሴ,ጷ�ሜ"/>
                        </div>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
