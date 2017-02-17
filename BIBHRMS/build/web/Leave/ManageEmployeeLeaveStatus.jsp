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
                    function ManageEmployeeLeaveStatus(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!--  <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$ManageEmployeeLeaveStatus.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$ManageEmployeeLeaveStatus.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$ManageEmployeeLeaveStatus.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$ManageEmployeeLeaveStatus.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$ManageEmployeeLeaveStatus.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border-style: none; height: 470px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; left: 0px; position: relative;top: 50px; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 230px" styleClass="left_menu">
                                            <ice:panelCollapsible binding="#{Leave$ManageEmployeeLeaveStatus.pnl_col_Common_Tasks}" expanded="false"
                                                id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" style="font-size: 11px; font-weight: normal" value="Employee Requested Return From Leave "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%"/>
                                                    <ice:panelGroup id="statusGroupRequestFromLeave" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 230px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerRequestFromLeave" style="position: absolute;height: 200px; width: 100%">
                                                            <ice:selectOneListbox id="listemployeeOnLeavee" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 10px; top: 0px; position: absolute; width: 182px"
                                                                value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData2.selectedObject}" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.listemployeeOnLeavee_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems2" value="#{Leave$ManageEmployeeLeaveStatus.employeeListRequestedReturnFromLeave}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible binding="#{Leave$ManageEmployeeLeaveStatus.pnl_col_Status}" expanded="true"
                                                id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Employees on leave "/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 230px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="position: absolute;height: 200px; width: 100%">
                                                            <ice:selectOneListbox binding="#{Leave$ManageEmployeeLeaveStatus.listemployeeOnLeave}"
                                                                id="listemployeeOnLeave" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 10px; top: 0px; position: absolute; width: 182px"
                                                                value="#{Leave$ManageEmployeeLeaveStatus.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.listemployeeOnLeave_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$ManageEmployeeLeaveStatus.employeesOnLeave}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible binding="#{Leave$ManageEmployeeLeaveStatus.panelCollapsible1}" expanded="true"
                                                id="panelCollapsible1" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1">
                                                        <ice:outputText id="outputText4" value="Employees Not Return On Time"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrid1" width="100%">
                                                    <ice:panelGroup id="statusGroup" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 230px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="lyStatusContainer" style="position: absolute;height: 200px; width: 100%">
                                                            <ice:selectOneListbox id="slctEmployeeOnProvation" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 10px; top: 0px; position: absolute; width: 182px"
                                                                value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData1.selectedObject}" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.slctEmployeeOnProvation_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems1" value="#{Leave$ManageEmployeeLeaveStatus.employeesNotReturnOnTime}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible binding="#{Leave$ManageEmployeeLeaveStatus.panelTwoHoursLeave}" id="panelTwoHoursLeave" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGTwoHoursLeave">
                                                        <ice:outputText id="lblTwoHoursLeave" value="Employee On Two Hours Leave"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="panelGrTwoHoursLeave" width="100%">
                                                    <ice:panelGroup id="statusGroupTwoHoursLeave" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 230px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="lyStatusContainerTwoHoursLeave" style="position: absolute;height: 200px; width: 100%">
                                                            <ice:selectOneListbox id="slctTwoHoursLeave" partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 223px; left: 10px; top: 0px; position: absolute; width: 182px"
                                                                value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData5.selectedObject}" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.slctTwoHoursLeave_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems3" value="#{Leave$ManageEmployeeLeaveStatus.employeesOnTwoHoursLeave}"/>
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
                                <ice:panelGroup id="page_display" style="height:670px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 563px; left: 0px; top: 60px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 600px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Employee Leave Status"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 690px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 550px" styleClass="filedsetNormal">
                                                    <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblEmploymentStatus}" id="lblEmploymentStatus"
                                                        style="color: rgb(204, 102, 0); font-size: 11px; font-weight: bold; left: 675px; top: 30px; position: absolute; text-align: center; width: 114px" value="Active"/>
                                                    <ice:outputText id="lblStatusvalue1"
                                                        style="font-size: 11px; font-weight: bold; left: 550px; top: 30px; position: absolute" value="EMPLOYMENT STATUS :"/>
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 320px; left: 25px; top: 65px; position: absolute; width: 735px">
                                                        <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                        <ice:inputText binding="#{Leave$ManageEmployeeLeaveStatus.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblFullNmae" style="font-size: 10px; left: 38px; top: 54px; position: absolute"
                                                            styleClass="font-size: 10px; left: 414px; top: 77px; position: absolute" value="Full Name"/>
                                                        <ice:outputText id="lblZerf" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                        <ice:outputText id="lblDirectorate" rendered="false"
                                                            style="font-size: 10px; left: 414px; top: 109px; position: absolute" value="Directorate "/>
                                                        <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblFull_Name}" id="lblFull_Name"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblDepartment}" id="lblDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblPosition}" id="lblPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 370px" value=":"/>
                                                        <ice:outputText id="outputText1" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.chkMale}" disabled="true"
                                                            id="chkMale" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 171px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.chkFemale}" disabled="true"
                                                            id="chkFemale" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 171px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                        <ice:graphicImage binding="#{Leave$ManageEmployeeLeaveStatus.imgEmployeePicture}" height="194"
                                                            id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 10px; position: absolute"
                                                            value="/Employee/images/blank.gif" width="172"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblLeaveStartDate}" id="lblLeaveStartDate"
                                                            style="font-size: 11px; left: 395px; top: 239; position: absolute" value="Leave Start Date :"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblLeaveStartDateDis}"
                                                            id="lblLeaveStartDateDis"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 239px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblReason}" id="lblReason"
                                                            style="font-size: 11px; left: 38px; top: 274px; position: absolute" value="Leave End Date :"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblLeaveEndDate}" id="lblLeaveEndDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 274px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText id="lblWorkIn" style="font-size: 11px; left: 310px; top: 205px; position: absolute" value="Work-In"/>
                                                        <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 81px; left: 1px; top: 350px; position: absolute; width: 735px">
                                                            <ice:outputText id="outputText5"
                                                                style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Return to Job Information"/>
                                                            <ice:outputText id="returnDate" style="font-size: 10px; left: 38px; top: 36px; position: absolute" value="Return Date"/>
                                                            <ice:inputText binding="#{Leave$ManageEmployeeLeaveStatus.txtReturnDate}" id="txtReturnDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 35px; position: absolute; width: 190"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnCalenderReturnDate_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnCalender}" id="btnCalender"
                                                                image="/Employee/images/calendar.gif" partialSubmit="true"
                                                                style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 324px; top: 38px; position: absolute" value="submit"/>
                                                            <ice:selectInputDate binding="#{Leave$ManageEmployeeLeaveStatus.siDCalender}" id="siDCalender"
                                                                imageDir="/xmlhttp/css/rime/css-images/" popupDateFormat="yyyy-MM-dd" rendered="false"
                                                                style="left: 330px; top: 50px; position: absolute; z-index: 10" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.siDCalender_processValueChange}"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.button1_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnTime}" id="btnTime"
                                                                image="/resources/images/clock.png" rendered="false"
                                                                style="left: 350px; top: 35px; position: absolute" value="submit"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="ReturntoJobCrude" rendered="true" style="border: 1px solid rgb(204, 204, 204); left: 1px; top: 470px; position: absolute; width: 735px">
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnNew_action}" id="btnNew"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="New"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnSave_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnSave}" id="btnSave"
                                                                style="margin-left: 40px; width: 80px" value="Save"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnEdit_action}" id="btnEdit"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Edit"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnUpdate_action}" id="btnUpdate"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Update"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnDelete_action}" id="btnDelete"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Delete"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnCancel_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnCancel}" id="btnCancel"
                                                                style="margin-left: 40px; width: 80px" value="Cancel"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnExtendLeave_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnExtendLeave}" id="btnExtendLeave" rendered="false"
                                                                style="margin-left: 80px; width: 180px" value="Modify the Leave"/>
                                                        </ice:panelLayout>
                                                        <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnSearch_action}" id="btnSearch"
                                                            rendered="false" style="left: 380px; top: 9px; position: absolute; width: 90px" value="Search"/>
                                                        <ice:outputText id="outputText6" style="font-size: 11px; left: 175px; top: 171px; position: absolute" value="Male"/>
                                                        <ice:outputText id="outputText7" style="font-size: 11px; left: 265px; top: 171px; position: absolute" value="Female"/>
                                                        <ice:outputText id="lblLeaveType" style="font-size: 11px; left: 38px; top: 239; position: absolute" value="Leave Type"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblLeaveTypeDes}" id="lblLeaveTypeDes"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 239px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText id="lblEmployeeType" style="font-size: 11px; left: 38px; top: 205; position: absolute" value="Employee Type"/>
                                                        <ice:outputText id="lblRequestedReturnDateDis"
                                                            style="font-size: 11px; left: 395px; top: 274px; position: absolute" value="Requested Return Date"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblRequestedReturnDate}"
                                                            id="lblRequestedReturnDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 274px; position: absolute; width: 190px" value=":"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.choOffice}" disabled="true"
                                                            id="choOffice" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData3.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.choShift}" disabled="true"
                                                            id="choShift" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData4.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.choAddisAbeba}" disabled="true"
                                                            id="choAddisAbeba" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 370px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ManageEmployeeLeaveStatus.choMugher}" disabled="true"
                                                            id="choMugher" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 470px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                        <ice:outputText id="outputText11" style="font-size: 11px; left: 175px; top: 205px; position: absolute" value="Office"/>
                                                        <ice:outputText id="outputText10" style="font-size: 11px; left: 260px; top: 205px; position: absolute" value="Shift"/>
                                                        <ice:outputText id="outputText9" style="font-size: 11px; left: 395px; top: 205px; position: absolute" value="Addis Abeba"/>
                                                        <ice:outputText id="outputText8" style="font-size: 11px; left: 495px; top: 205px; position: absolute" value="OtherLocation"/>
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
                                                style="margin-left:10px;color:#333333;font-weight:bold;font-family:Cambria">Copyright @ 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">Bunna International Bank  |Department Information System  |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ManageEmployeeLeaveStatus.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$ManageEmployeeLeaveStatus.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$ManageEmployeeLeaveStatus.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ManageEmployeeLeaveStatus.pnExtendLeave}" clientOnly="true" draggable="false"
                            id="pnExtendLeave" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 182px; left: 63px; top: 800px; position: absolute; width: 600px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnExtendLeave" style="background-color:#333333; height: 20px; padding-top: 8px; width: 521px">
                                    <ice:outputText id="pnExtendLeaveTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 349px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Extend Leave"/>
                                    <ice:commandLink action="#{Leave$ManageEmployeeLeaveStatus.modalPnlCloseExtendLeave_action}" id="modalPnlCloseExtendLeave"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 590px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupExtendLeave" style="display: block; height: 120px; position: relative; width: 487px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlExtendLeaveBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 90px; position: relative; width: 421px; -rave-layout: grid" styleClass="message">
                                        <ice:outputText id="outputText12" style="left: 10px; top: 34px; position: absolute" value="From"/>
                                        <ice:outputText id="outputText13" style="left: 260px; top: 34px; position: absolute" value="Number Of Days"/>
                                        <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnModify_action}" id="btnModify"
                                            style="left: 200px; top: 65px; position: absolute; width: 200px" value="Modify"/>
                                        <ice:selectInputDate binding="#{Leave$ManageEmployeeLeaveStatus.calStartFrom}" id="calStartFrom"
                                            popupDateFormat="yyyy-MM-dd" renderAsPopup="true" style="left: 60px; top: 30px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectInputDate2Bean.date1}"/>
                                        <ice:outputText id="outputText14" style="left: 10px; top: 0px; position: absolute" value="Sick Leave"/>
                                        <ice:inputText binding="#{Leave$ManageEmployeeLeaveStatus.txtNumberOfDays}" id="txtNumberOfDays" style="left: 370px; top: 30px; position: absolute; width: 109px"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelLayout binding="#{Leave$ManageEmployeeLeaveStatus.pnlLayoutTimePanel}" id="pnlLayoutTimePanel" rendered="false"
                            style="border-width: 5px; border-style: solid; border-color: rgb(204, 204, 204); height: 294px; margin-left: 15px; left: 100px; top: 70px; overflow: auto; position: absolute; width: 280px" styleClass="insideContainerMain">
                            <ice:dataTable id="dataTableTime" rows="12"
                                style="border: 2px solid rgb(115, 179, 206) ;height: 8px; left: 5px; top: 25px; position: absolute; width:270px"
                                value="#{Leave$ManageEmployeeLeaveStatus.tableHour}" var="currentRow">
                                <ice:column id="colStartDate12">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForColumn00"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col00']}"/>
                                </ice:column>
                                <ice:column id="colStartDate02">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForColumn02"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col10']}"/>
                                </ice:column>
                                <ice:column id="colStartTime04">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForolumn04"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col20']}"/>
                                </ice:column>
                                <ice:column id="colStartTime06">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForColumn06"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col30']}"/>
                                </ice:column>
                                <ice:column id="colStartTime08">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForColumn08"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col40']}"/>
                                </ice:column>
                                <ice:column id="colStartTime10">
                                    <ice:commandLink actionListener="#{Leave$ManageEmployeeLeaveStatus.lnkShowTime_processAction}" id="optTxtForColumn10"
                                        onmouseout="this.style.backgroundColor='rgb(255,255, 255)'" onmouseover="this.style.backgroundColor='#306682'" value="#{currentRow['col50']}"/>
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
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
