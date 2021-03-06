<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : Bravozulu
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
                    function TransferRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
                <!-- <link HREF="../FederalIcon.ico" REL="icon"/>-->
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder height="480" id="whole_plstRequestsListage"
                            renderCenter="#{Termination$TransferRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Termination$TransferRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Termination$TransferRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Termination$TransferRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Termination$TransferRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 117px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 129px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:510px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:675px;top:15px;left: 5px;position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:675px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Search" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="search_Group_Header">
                                                        <ice:outputText id="lblSearchArea" value="#{msgTermination.searchArea}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="search_panelGrid" width="100%"/>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="#{msgTermination.commonTasks}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height:193px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{Termination$TransferRequestPage.lnkResignApprovePage_action}"
                                                                id="lnkResignApprovePage" style="color:#306682;font-weight:bold" value="Transfer Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Termination$TransferRequestPage.lnkClearancePage_action}"
                                                                id="lnkClearancePage" style="color:#306682;font-weight:bold" value="Clearance"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Previous Requests Made"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:325px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="border-style: none; background-color: transparent; height: 78px; position: absolute; width: 100%">
                                                            <ice:selectOneListbox binding="#{Termination$TransferRequestPage.lstRequestsList}"
                                                                id="lstRequestsList" partialSubmit="true" size="2"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 223px; left: 10px; top: -5px; position: absolute; width: 182px"
                                                                value="#{Termination$TransferRequestPage.defaultSelectedData123.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.lstRequestsList_processValueChange}">
                                                                <f:selectItems id="selectOneListbox1selectItems1" value="#{Termination$TransferRequestPage.requestsLists}"/>
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
                                <ice:panelGroup id="page_display" style="height: 1080px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height:1065px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1060px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Transfer Requests"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1049px; left: 0px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Termination$TransferRequestPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1010px; top: 40px; position: absolute" styleClass="filedset_border">
                                                    <ice:outputText id="lblEmployeementHistory"
                                                        style="font-size: 11px; font-weight: bold; left: 30px; top: 20px; position: absolute" value="#{msgTermination.empInfo}"/>
                                                    <ice:outputText id="lblStatusLable"
                                                        style="color: rgb(46, 100, 128); font-family: Narkisim; font-size: 12px; font-weight: bold; left: 240px; top: -25px; position: absolute" value="Current State"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblStateStatus}" id="lblStateStatus" style="color: rgb(46, 100, 128); font-family: Narkisim; font-size: 12px; font-weight: bold; left: 320px; top: -25px; position: absolute"/>
                                                    <label style="left: 20px; top: 40px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 955px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <label style="left: 20px; top: 910px; border-bottom:0.5px groove #176674; width:743px; position: absolute;"></label>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnEditRequest_action}"
                                                        binding="#{Termination$TransferRequestPage.btnEditRequest}" disabled="true" id="btnEditRequest"
                                                        partialSubmit="true" style="left: 288px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.edit}"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnCancelTerminationRequest_action}"
                                                        binding="#{Termination$TransferRequestPage.btnCancelTerminationRequest}" disabled="true"
                                                        id="btnCancelTerminationRequest" immediate="true" partialSubmit="true"
                                                        style="left: 528px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.cancel}"/>
                                                    <ice:outputText escape="false" id="outputText1"
                                                        style="font-size: 12px; left: 38px; top: 65px; position: absolute" value="#{msgTermination.empId}"/>
                                                    <ice:outputText id="outputText2" style="font-size: 12px; left: 33px; top: 325px; position: absolute" value="#{msgTermination.totalServiceYear}"/>
                                                    <ice:outputText id="outputText5" style="font-size: 12px; left: 35px; top: 245px; position: absolute" value="Employee Type"/>
                                                    <ice:outputText id="outputText6" style="font-size: 12px; left: 38px; top: 105px; position: absolute" value="Full Name"/>
                                                    <ice:outputText id="outputText8" style="font-size: 12px; left: 35px; top: 145px; position: absolute" value="#{msgTermination.gender}"/>
                                                    <ice:outputText escape="false" id="outputText9"
                                                        style="font-size: 12px; left: 35px; top: 285px; position: absolute" value="#{msgTermination.jobPosition}"/>
                                                    <ice:outputText id="outputText12" style="font-size: 12px; left: 35px; top: 365px; position: absolute" value="#{msgTermination.retirementNumber}"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnUpdateTerminationRequest_action}"
                                                        binding="#{Termination$TransferRequestPage.btnUpdateTerminationRequest}" disabled="true"
                                                        id="btnUpdateTerminationRequest" immediate="true"
                                                        style="left: 408px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.update}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.cbMale}" id="cbMale"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 150px; top: 145px; position: absolute"
                                                        value="#{Termination$TransferRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.cbMale_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.cbFemale}" id="cbFemale"
                                                        style="background-color: rgb(242, 246, 240); left: 257px; top: 145px; position: absolute" value="#{Termination$TransferRequestPage.selectBooleanCheckbox2Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText17" style="font-size: 12px; left: 184px; top: 145px; position: absolute" value="#{msgTermination.male}"/>
                                                    <ice:outputText id="outputText18" style="font-size: 12px; left: 290px; top: 145px; position: absolute" value="#{msgTermination.female}"/>
                                                    <ice:inputText binding="#{Termination$TransferRequestPage.txtEmployeeId}" id="txtEmployeeId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 60px; position: absolute; width: 145px"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnNewTermination_action}"
                                                        binding="#{Termination$TransferRequestPage.btnNewTermination}" id="btnNewTermination"
                                                        partialSubmit="true" style="left: 48px; top: 910px; position: absolute; width: 90px" value="#{msgTermination.new}"/>
                                                    <ice:outputLabel binding="#{Termination$TransferRequestPage.lblFormMessage}" id="lblFormMessage" style="color: rgb(204, 102, 0); font-size: 11px; font-weight: bold; left: 0px; top: -55px; position: absolute; width: 757px"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnNewTerminationPost_action}"
                                                        binding="#{Termination$TransferRequestPage.btnNewTerminationPost}" disabled="true"
                                                        id="btnNewTerminationPost" style="left: 168px; top: 910px; position: absolute; width: 90px" value="Save"/>
                                                    <ice:outputText id="outputText43" style="font-size: 12px; left: 35px; top: 185px; position: absolute" value="Department "/>
                                                    <ice:outputText id="outputText24" style="font-size: 12px; left: 444px; top: 285px; position: absolute" value="#{msgTermination.hiredDate}"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnCancelTerminationRequest_action}"
                                                        binding="#{Termination$TransferRequestPage.btnDeleteTerminationRequest}" disabled="true"
                                                        id="btnDeleteTerminationRequest" immediate="true" partialSubmit="true"
                                                        style="left: 648px; top: 910px; position: absolute; width: 90px" value="Delete"/>
                                                    <ice:commandButton action="#{Termination$TransferRequestPage.btnSearch_action}"
                                                        binding="#{Termination$TransferRequestPage.btnSearch}" id="btnSearch" partialSubmit="true"
                                                        style="left: 310px; top: 47px; position: absolute; width: 105px" value="Search"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblFullName}" id="lblFullName"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 105px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblDepartment}" id="lblDepartment" style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: 'Cambria'; left: 150px; top: 185px; position: absolute; width: 356px"/>
                                                    <ice:outputText id="outputText11" style="font-size: 12px; left: 179px; top: 246px; position: absolute" value="Clerical"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkCivil}" id="chkCivil"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 153px; top: 244px; position: absolute" value="#{Termination$TransferRequestPage.selectBooleanCheckbox3Bean.selectedBoolean}"/>
                                                    <ice:outputText id="outputText42" style="font-size: 12px; left: 275px; top: 246px; position: absolute" value="NonClerical"/>
                                                    <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkContrat}" id="chkContrat"
                                                        partialSubmit="true"
                                                        style="background-color: rgb(242, 246, 240); left: 249px; top: 244px; position: absolute" value="#{Termination$TransferRequestPage.selectBooleanCheckbox4Bean.selectedBoolean}"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblPosition}" id="lblPosition"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 285px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblServiceYear}" id="lblServiceYear"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 325px; position: absolute; width: 260px" value=":"/>
                                                    <ice:graphicImage binding="#{Termination$TransferRequestPage.imgEmployeePicture}" height="194"
                                                        id="imgEmployeePicture"
                                                        style="border: 1px solid rgb(153, 153, 153); left: 550px; top: 64px; position: absolute"
                                                        value="/Employee/images/blank.gif" width="172"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblHireDate}" id="lblHireDate"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 285px; position: absolute; width: 213px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblRetireNumber}" id="lblRetireNumber"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 150px; top: 365px; position: absolute; width: 260px" value=":"/>
                                                    <ice:outputText binding="#{Termination$TransferRequestPage.lblAge}" id="lblAge"
                                                        style="border-bottom: solid rgb(153, 153, 153) 1px; font-family: Cambria; left: 525px; top: 325px; position: absolute; width: 213px" value=":"/>
                                                    <ice:outputText id="outputText7" style="font-size: 12px; left: 444px; top: 325px; position: absolute" value="Age"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                        <ice:panelTabSet height="481" id="panelTabSet1" immediate="true"
                                            style="left: 24px; top: 474px; position: absolute; width: 725px" tabPlacement="Top" width="100%">
                                            <ice:panelTab id="panelTab1" label="Transfer Request Info" style="font-family: Cambria;">
                                                <ice:panelLayout id="panelLayout1" style="height: 440px; position: inherit; width: 100%">
                                                    <ice:panelLayout id="pnlAccrualEntry" layout="flow" style="height: 443px; position: absolute; width: 700px; -rave-layout: grid">
                                                        <ice:outputText binding="#{Termination$TransferRequestPage.lblSelectResignresign}"
                                                            id="lblSelectResignresign" rendered="false"
                                                            style="font-size: 10px; left: 38px; top: 305px; position: absolute" value="#{msgTermination.selectResignReason}"/>
                                                        <ice:inputText binding="#{Termination$TransferRequestPage.txtCurrentDate}" disabled="true"
                                                            id="txtCurrentDate" required="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 125px; top: 85px; position: absolute; width: 190px"/>
                                                        <ice:outputText id="outputText32" style="font-size: 12px; left: -5px; top: 85px; position: absolute" value="#{msgTermination.requestDate}"/>
                                                        <ice:inputTextarea binding="#{Termination$TransferRequestPage.txtReasonDescription}" disabled="true"
                                                            id="txtReasonDescription" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 54px; left: 125px; top: 382px; position: absolute; width: 536px"/>
                                                        <ice:outputText id="outputText13" style="font-size: 12px; left: 0px; top: 384px; position: absolute" value="Reason For Transfer:"/>
                                                        <ice:outputText id="outputText3" style="font-size: 12px; left: -5px; top: 25px; position: absolute" value="Transfer Type :"/>
                                                        <ice:outputText id="outputText4" style="font-size: 12px; left: -5px; top: 128px; position: absolute" value="From Department :"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="ddlstTerminationType"
                                                            id="message1" infoClass="infoMessage"
                                                            style="font-size: 11px; left: 340px; top: 35px; position: absolute; width: 207px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDateRequest" id="message2"
                                                            infoClass="infoMessage"
                                                            style="font-size: 11px; left: 340px; top: 135px; position: absolute; width: 203px" warnClass="warnMessage"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.lstTransferType}" disabled="true"
                                                            id="lstTransferType" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206);background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 125px; top: 25px; position: absolute; width: 190px"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData121.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.lstTransferType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Termination$TransferRequestPage.transferTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.lstFromDepartment}" disabled="true"
                                                            id="lstFromDepartment" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 125px; top: 125px; position: absolute; width: 190px"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData125.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.lstFromDepartment_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems4" value="#{Termination$TransferRequestPage.fromDepartmentList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.lstToDepartment}" disabled="true"
                                                            id="lstToDepartment" partialSubmit="true" required="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 125px; top: 215px; position: absolute; width: 190px"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData126.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.lstToDepartment_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems5" value="#{Termination$TransferRequestPage.toDepartmentList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText44" style="left: -5px; top: 218px; position: absolute" value="To Department :"/>
                                                        <ice:outputLabel binding="#{Termination$TransferRequestPage.lblFromdepartment}" id="lblFromdepartment" style="left: 125px; top: 160px; position: absolute; width: 567px"/>
                                                        <ice:outputLabel binding="#{Termination$TransferRequestPage.lblToDepartment}" id="lblToDepartment" style="left: 120px; top: 250px; position: absolute; width: 573px"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkEnternalCrossDepartment}"
                                                            disabled="true" id="chkEnternalCrossDepartment" partialSubmit="true"
                                                            style="left: 350px; top: 60px; position: absolute"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData127.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.chkEnternalCrossDepartment_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkEnternalSameDepartment}"
                                                            disabled="true" id="chkEnternalSameDepartment" partialSubmit="true"
                                                            style="left: 125px; top: 60px; position: absolute"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData128.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.chkEnternalSameDepartment_processValueChange}"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkExternal}" disabled="true"
                                                            id="chkExternal" partialSubmit="true" style="left: 575px; top: 60px; position: absolute"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData129.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.chkExternal_processValueChange}"/>
                                                        <ice:outputText id="outputText46" style="font-size: 12px; left: 600px; top: 57px; position: absolute" value="External"/>
                                                        <ice:outputText id="outputText58" style="font-size: 12px; left: 150px; top: 57px; position: absolute" value="Internal Same Department"/>
                                                        <ice:outputText id="outputText59" style="font-size: 12px; left: 375px; top: 57px; position: absolute" value="External Cross Department"/>
                                                        <ice:inputText binding="#{Termination$TransferRequestPage.txtEffectiveFrom}" id="txtEffectiveFrom"
                                                            partialSubmit="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 450px; top: 85px; position: absolute; width: 167px"/>
                                                        <ice:outputText id="outputText60" style="font-size: 12px; left: 336px; top: 85px; position: absolute" value="Effective From :"/>
                                                        <ice:outputText id="outputText10" style="left: 0px; top: 288px; position: absolute" value="ToPosition"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.drl_profession}" id="drl_profession"
                                                            partialSubmit="true" style="left: 118px; top: 286px; position: absolute; width: 191px" value="#{Termination$TransferRequestPage.defaultSelectedData130.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Termination$TransferRequestPage.perofation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText14" style="left: 240px; top: 360px; position: absolute" value="ToSalary"/>
                                                        <ice:outputText id="outputText15" style="left: 336px; top: 288px; position: absolute" value="Is Salary Affect"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkSalaryChanaged}"
                                                            id="chkSalaryChanaged" partialSubmit="true" style="left: 430px; top: 286px; position: absolute"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData131.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.chkSalaryChanaged_processValueChange}"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.drlRankId}" disabled="true" id="drlRankId"
                                                            partialSubmit="true" style="left: 430px; top: 310px; position: absolute; width: 191px"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData132.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.drlRankId_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Termination$TransferRequestPage.jobRank}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputText id="outputText16" style="left: 336px; top: 312px; position: absolute" value="RankID"/>
                                                        <ice:outputText id="outputText19" style="left: 336px; top: 336px; position: absolute" value="PayGrade"/>
                                                        <ice:selectOneMenu binding="#{Termination$TransferRequestPage.drlPayGrade}" disabled="true"
                                                            id="drlPayGrade" partialSubmit="true"
                                                            style="left: 430px; top: 344px; position: absolute; width: 191px"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData133.selectedObject}" valueChangeListener="#{Termination$TransferRequestPage.drlPayGrade_processValueChange}">
                                                            <f:selectItems id="selectOneMenu3selectItems" value="#{Termination$TransferRequestPage.payGradeOpt}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel binding="#{Termination$TransferRequestPage.txtSalaryChage}" id="txtSalaryChage" style="font-family: 'Times New Roman',Times,serif; font-size: 14px; font-weight: bold; left: 312px; top: 360px; position: absolute; text-decoration: underline; width: 117px"/>
                                                        <ice:commandButton action="#{Termination$TransferRequestPage.button1_action}" id="button1"
                                                            image="/resources/images/cal_icon.JPG" style="left: 624px; top: 85px; position: absolute" value="submit"/>
                                                        <ice:outputText binding="#{Termination$TransferRequestPage.out_txt_Position}" id="out_txt_Position"
                                                            style="left: 120px; top: 312px; position: absolute; width: 193px" value=":"/>
                                                        <ice:outputText id="outputText20" style="left: 480px; top: 288px; position: absolute" value="Promoted"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TransferRequestPage.chkPromoted}" id="chkPromoted"
                                                            partialSubmit="true" style="left: 550px; top: 286px; position: absolute"
                                                            value="#{Termination$TransferRequestPage.defaultSelectedData134.selectedBoolean}" valueChangeListener="#{Termination$TransferRequestPage.chkPromoted_processValueChange}"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                            <ice:panelTab id="panelTab12" label="Transfer Supportive info" style="font-family: Cambria;">
                                                <ice:panelLayout id="panelLayout12" style="height: 440px; position: inherit; width: 100%">
                                                    <ice:panelLayout id="pnlAccrualEntry2" layout="flow" style="height: 440px; position: absolute; width: 700px">
                                                        <ice:outputText id="outputText40" style="font-size: 10px; left: -5px; top: 25px; position: absolute" value="#{msgTermination.attachDocument}"/>
                                                        <ice:message for="inputFileComponent" style="top:600px; position: absolute;"/>
                                                        <ice:panelLayout id="panelLayout16" style="border: 1px solid rgb(204, 204, 204); height: 148px; margin-left: 15px; left: -15px; top: 65px; overflow: auto; position: absolute; width: 100%">
                                                            <ice:dataTable binding="#{Termination$TransferRequestPage.tblDocumentAttached}" clientOnly="true"
                                                                id="tblDocumentAttached" style="left: 0px; top:5px; position: absolute; width: 100%"
                                                                value="#{Termination$TransferRequestPage.fileAttachment}" var="currentRow" width="100%">
                                                                <ice:column id="column1" style="width: 10px">
                                                                    <h:graphicImage id="image1" style="width: 10px" value="#{currentRow['imageIcon']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText31" value="File"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column4" style="width: 200px">
                                                                    <h:commandLink action="#{Termination$TransferRequestPage.lnkDocumentAttached_action}"
                                                                        binding="#{Termination$TransferRequestPage.lnkDocumentAttached}"
                                                                        id="lnkDocumentAttached" value="#{currentRow['imageName']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText37" value="Attached Document"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="column2">
                                                                    <h:commandLink action="#{Termination$TransferRequestPage.lnkAttachedRemove_action}"
                                                                        binding="#{Termination$TransferRequestPage.lnkAttachedRemove}" disabled="false"
                                                                        id="lnkAttachedRemove" value="Remove"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="outputText35" value="Action"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                        </ice:panelLayout>
                                                        <ice:inputFile action="#{Termination$TransferRequestPage.fileUploadAttached_action}"
                                                            actionListener="#{Termination$TransferRequestPage.fileUploadAttached_processAction}"
                                                            binding="#{Termination$TransferRequestPage.fileUploadAttached}" disabled="true"
                                                            failOnEmptyFile="true" id="fileUploadAttached" immediate="true"
                                                            progressListener="#{Termination$TransferRequestPage.fileUploadAttached_processMyEvent}"
                                                            style="font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter;height: 46px; left: 125px; top: 18px; position: absolute" width="469"/>
                                                    </ice:panelLayout>
                                                </ice:panelLayout>
                                            </ice:panelTab>
                                        </ice:panelTabSet>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <label
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank |Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferRequestPage.pnlPopUpAttachment}" clientOnly="true" draggable="true"
                            id="pnlPopUpAttachment" modal="true" rendered="false" style="display: block; height: 455px; left: 97px; top: 146px; position: absolute; width: 812px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpAttachment" styleClass="popupHeaderWrapper">
                                    <ice:outputText id="PopUpAttachmentTitle" style="width:400px" styleClass="popupHeaderText" value="Bunna Bank Human Resource Management System-Request Commented History"/>
                                    <ice:commandButton actionListener="#{Termination$TransferRequestPage.modalPnlCloseBtnAttachment_processAction}" alt="Close"
                                        id="modalPnlCloseBtnAttachment" image="/resources/images/close.gif" immediate="true" partialSubmit="true"
                                        style="left: 789px; top: -1px; position: absolute" styleClass="popupHeaderImage" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="pnlgroupPopUpAttach" style="display: block; height: 387px; position: relative; width: 762px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:graphicImage binding="#{Termination$TransferRequestPage.gimgAttachedDocuments}" height="364" id="gimgAttachedDocuments"
                                        style="left: 5px; top: 5px; position: absolute" width="761"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TransferRequestPage.pnMessage}" clientOnly="true" draggable="false"
                            id="pnMessage" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Termination$TransferRequestPage.modalPnlCloseMesssage_action}" id="modalPnlCloseMesssage"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 735px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Termination$TransferRequestPage.lblFormMessage1}" id="lblFormMessage1" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:selectInputDate binding="#{Termination$TransferRequestPage.calEffectiveFrom}" id="calAppliedDate" rendered="false"
                            style="height: 117px; left: 670px; top: 610px; position: absolute; width: 190px"
                            value="#{Termination$TransferRequestPage.selectInputDateEffectiveFrom.date1}" valueChangeListener="#{Termination$TransferRequestPage.calEffectiveDate_processValueChange}"/>
                    </div>
                </ice:form>
                <div class="growlUI" id="demo12" style="background: url(check48.png) no-repeat 10px 10px">
                    <h1 style="color: white; padding: 5px 5px 5px 75px; text-align: left"></h1>
                </div>
            </body>
        </html>
    </f:view>
</jsp:root>
