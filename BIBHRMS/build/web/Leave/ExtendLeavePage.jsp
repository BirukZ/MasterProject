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
               <!-- <link HREF="../header_icon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1">
                <ice:form id="form1">
                    <div style="width:100%">
                        <img alt="" class="source-image" id="img" src="../resources/images/WholePageBG.png" width="100%"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Leave$ExtendLeavePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Leave$ExtendLeavePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Leave$ExtendLeavePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Leave$ExtendLeavePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Leave$ExtendLeavePage.panelBorder1Bean.renderWest}" style="top: 5px; position: relative; background:transparent;"
                            styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="height: 613px; top: 37px; position: relative">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height: 670px; left: 0px; top: -15px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 640px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="list_menu">
                                            <ice:panelCollapsible expanded="true" id="colsEmployeeSearchByName" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup4" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ExtendLeavePage.lnkResignApprovePage_action}"
                                                                id="lnkResignApprovePage" style="color:#333333;font-weight:bold" value="Leave Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Leave$ExtendLeavePage.lnkClearancePage_action}" id="lnkClearancePage"
                                                                style="color:#333333;font-weight:bold" value="Employee Profile"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="colsRequestLisrt">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="panelGroup1" styleClass=""/>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" style="height: 380px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="border-style: none; margin: -5px -5px -5px -10px; padding: 7px; background-color: transparent; display: block; float: left; height: 350px; left: -5px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 400px; position: absolute; width: 100%">
                                                            <ice:outputText id="outputText32"
                                                                style="font-family: Cambria; left: 10px; top: 10px; position: absolute" value="Employee On Annual Leave"/>
                                                            <ice:selectOneListbox binding="#{Leave$ExtendLeavePage.lstEmployeeOnLeave}" id="lstEmployeeOnLeave"
                                                                partialSubmit="true" size="2"
                                                                style="border: 1px solid rgb(115, 179, 206); height: 300px; left: 10px; top: 30px; position: absolute; width: 180px"
                                                                value="#{Leave$ExtendLeavePage.selectOneListbox1Bean.selectedObject}" valueChangeListener="#{Leave$ExtendLeavePage.lstEmployeeOnLeave_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems" value="#{Leave$ExtendLeavePage.listOfEmployeeLeave}"/>
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
                                <ice:panelGroup id="page_display" style="height: 670px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 700px; left: 15px; top: 20px; position: relative; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 640px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Employee Evaluation"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 670px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 700px; width: 95%" styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 320px; left: 5px; top: 30px; position: absolute; width: 790px">
                                                        <ice:outputText id="lblEmployeeID" style="font-size: 10px; left: 38px; top: 20px; position: absolute" value="Employee ID :"/>
                                                        <ice:inputText binding="#{Leave$ExtendLeavePage.txtEmployeeID}" id="txtEmployeeID" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 17px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="lblFullNmae" style="font-size: 10px; left: 38px; top: 54px; position: absolute"
                                                            styleClass="font-size: 10px; left: 414px; top: 77px; position: absolute" value="Full Name"/>
                                                        <ice:outputText id="lblZerf" style="font-size: 10px; left: 38px; top: 88px; position: absolute" value="Department :"/>
                                                        <ice:outputText id="lblDirectorate" rendered="false"
                                                            style="font-size: 10px; left: 414px; top: 109px; position: absolute" value="Directorate "/>
                                                        <ice:outputText id="lblJobPosition" style="font-size: 10px; left: 38px; top: 137px; position: absolute" value="Job Position"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblFull_Name}" id="lblFull_Name"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 54px; position: absolute; width: 390px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblDepartment}" id="lblDepartment"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 88px; position: absolute; width: 390px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblPosition}" id="lblPosition"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 137px; position: absolute; width: 390px" value=":"/>
                                                        <ice:outputText id="outputText1" style="font-size: 11px; left: 38px; top: 171px; position: absolute" value="Gender:"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.chkMale}" disabled="true" id="chkMale"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 171px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox1Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.chkFemale}" disabled="true" id="chkFemale"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 171px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                        <ice:graphicImage binding="#{Leave$ExtendLeavePage.imgEmployeePicture}" height="194"
                                                            id="imgEmployeePicture"
                                                            style="border: 1px solid rgb(153, 153, 153); left: 580px; top: 10px; position: absolute"
                                                            value="/Employee/images/blank.gif" width="172"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblLeaveStartDate}" id="lblLeaveStartDate"
                                                            style="font-size: 11px; left: 395px; top: 239; position: absolute" value="Leave Start Date :"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblLeaveStartDateDis}" id="lblLeaveStartDateDis"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 510px; top: 239px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText binding="#{Leave$ManageEmployeeLeaveStatus.lblReason}" id="lblReason"
                                                            style="font-size: 11px; left: 38px; top: 274px; position: absolute" value="Leave End Date :"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblLeaveEndDate}" id="lblLeaveEndDate"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 274px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText id="lblWorkIn" style="font-size: 11px; left: 310px; top: 205px; position: absolute" value="Work-In"/>
                                                        <ice:panelLayout id="ReturntoJobCrude" rendered="true" style="border: 1px solid rgb(204, 204, 204); left: 1px; top: 550px; position: absolute; width: 787px">
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnNew_action}" id="btnNew"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="New"/>
                                                            <ice:commandButton action="#{Leave$ExtendLeavePage.btnSave_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnSave}" id="btnSave"
                                                                style="margin-left: 40px; width: 144px" value="Extend"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnEdit_action}" id="btnEdit"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Edit"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnUpdate_action}" id="btnUpdate"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Update"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnDelete_action}" id="btnDelete"
                                                                rendered="false" style="margin-left: 40px; width: 80px" value="Delete"/>
                                                            <ice:commandButton action="#{Leave$ExtendLeavePage.btnCancel_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnCancel}" id="btnCancel"
                                                                style="margin-left: 40px; width: 144px" value="Cancel"/>
                                                            <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnExtendLeave_action}"
                                                                binding="#{Leave$ManageEmployeeLeaveStatus.btnExtendLeave}" id="btnExtendLeave" rendered="false"
                                                                style="margin-left: 80px; width: 180px" value="Modify the Leave"/>
                                                        </ice:panelLayout>
                                                        <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.btnSearch_action}" id="btnSearch"
                                                            rendered="false" style="left: 380px; top: 9px; position: absolute; width: 90px" value="Search"/>
                                                        <ice:outputText id="outputText6" style="font-size: 11px; left: 175px; top: 171px; position: absolute" value="Male"/>
                                                        <ice:outputText id="outputText7" style="font-size: 11px; left: 265px; top: 171px; position: absolute" value="Female"/>
                                                        <ice:outputText id="lblLeaveType" style="font-size: 11px; left: 38px; top: 239; position: absolute" value="Leave Type"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.lblLeaveTypeDes}" id="lblLeaveTypeDes"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 239px; position: absolute; width: 190px" value=":"/>
                                                        <ice:outputText id="lblEmployeeType" style="font-size: 11px; left: 38px; top: 205; position: absolute" value="Employee Type"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.choOffice}" disabled="true" id="choOffice"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 150px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData3.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.choShift}" disabled="true" id="choShift"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 235px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.defaultSelectedData4.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.choAddisAbeba}" disabled="true"
                                                            id="choAddisAbeba" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 370px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Leave$ExtendLeavePage.choMugher}" disabled="true" id="choMugher"
                                                            partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 470px; top: 205px; position: absolute" value="#{Leave$ManageEmployeeLeaveStatus.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                        <ice:outputText id="outputText11" style="font-size: 11px; left: 175px; top: 205px; position: absolute" value="Office"/>
                                                        <ice:outputText id="outputText10" style="font-size: 11px; left: 260px; top: 205px; position: absolute" value="Shift"/>
                                                        <ice:outputText id="outputText9" style="font-size: 11px; left: 395px; top: 205px; position: absolute" value="Addis Abeba"/>
                                                        <ice:outputText id="outputText8" style="font-size: 11px; left: 495px; top: 205px; position: absolute" value="Other"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="lyRequestInformation" style="border: 1px solid rgb(204, 204, 204); height: 210px; left: 5px; top: 360px; position: absolute; width: 790px">
                                                        <ice:outputText id="outputText5"
                                                            style="font-size: 11px; font-weight: bold; left: 37px; top: 5px; position: absolute" value="Extend Leave Because of Sick Leave"/>
                                                        <ice:outputText id="returnDate" style="font-size: 10px; left: 38px; top: 36px; position: absolute" value="Sick Leave Start Date"/>
                                                        <ice:inputText binding="#{Leave$ExtendLeavePage.txtDateFrom}" id="txtDateFrom" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 35px; position: absolute; width: 190"/>
                                                        <ice:commandButton action="#{Leave$ExtendLeavePage.btnCalender_action}"
                                                            binding="#{Leave$ExtendLeavePage.btnCalender}" id="btnCalender"
                                                            image="/Employee/images/calendar.gif" partialSubmit="true"
                                                            style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 324px; top: 38px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Leave$ManageEmployeeLeaveStatus.siDCalender}" id="siDCalender"
                                                            imageDir="/xmlhttp/css/rime/css-images/" popupDateFormat="yyyy-MM-dd" rendered="false"
                                                            style="left: 330px; top: 50px; position: absolute; z-index: 10" valueChangeListener="#{Leave$ManageEmployeeLeaveStatus.siDCalender_processValueChange}"/>
                                                        <ice:commandButton action="#{Leave$ManageEmployeeLeaveStatus.button1_action}"
                                                            binding="#{Leave$ManageEmployeeLeaveStatus.btnTime}" id="btnTime"
                                                            image="/resources/images/clock.png" rendered="false"
                                                            style="left: 350px; top: 35px; position: absolute" value="submit"/>
                                                        <ice:outputText id="outputText2" style="font-size: 10px; left: 38px; top: 70px; position: absolute" value="Leave Days"/>
                                                        <ice:inputText binding="#{Leave$ExtendLeavePage.txtLeaveDays}" id="txtLeaveDays" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 70px; position: absolute; width: 100px"/>
                                                        <ice:outputText id="outputText3" style="font-size: 10px; left: 450px; top: 70px; position: absolute" value="To Date"/>
                                                        <ice:inputText binding="#{Leave$ExtendLeavePage.txtDateTo}" id="txtDateTo" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; left: 520px; top: 68px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="outputText4" style="font-size: 10px; left: 38px; top: 104px; position: absolute" value="Annual Leave End Date"/>
                                                        <ice:outputText binding="#{Leave$ExtendLeavePage.txtReturnDateFromLeave}" id="txtReturnDateFromLeave"
                                                            style="border-bottom: solid rgb(153, 153, 153) 1px; background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 104px; position: absolute; width: 190px" value=":"/>
                                                        <ice:commandButton action="#{Leave$ExtendLeavePage.btnCalculateLeave_action}" id="btnCalculateLeave"
                                                            style="left: 400px; top: 95px; position: absolute; width: 151px" value="Calculate Leave Days"/>
                                                        <ice:outputText id="outputText13" style="font-size: 10px; left: 38px; top: 145px; position: absolute" value="Remark"/>
                                                        <ice:inputTextarea binding="#{Leave$ExtendLeavePage.txtRemark}" id="txtRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 138px; position: absolute; width: 560px"/>
                                                        <ice:selectInputDate binding="#{Leave$ExtendLeavePage.calLeaveStartDate}" id="calLeaveStartDate"
                                                            rendered="false" style="left: 330px; top: 50px; position: absolute; z-index: 10"
                                                            value="#{Leave$ExtendLeavePage.selectInputDate1Bean.date1}" valueChangeListener="#{Leave$ExtendLeavePage.calLeaveStartDate_processValueChange}"/>
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
                                                href="http://www.bunnabanksc.com" style="margin-left:10px;color:#333333;">BUNNA INTERNATIONAL BANK |infromation |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Leave$ExtendLeavePage.pnMessage}" clientOnly="true" draggable="false" id="pnMessage"
                            modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Leave$ExtendLeavePage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Leave$ExtendLeavePage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
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
