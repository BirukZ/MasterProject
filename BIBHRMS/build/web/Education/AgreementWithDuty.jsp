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
        <f:loadBundle basename="Localization.HRLocalization_Education" var="msgse"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Duty Registration Form</title>
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
                    function AgreementWithDuty(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$AgreementWithDuty.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$AgreementWithDuty.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$AgreementWithDuty.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$AgreementWithDuty.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$AgreementWithDuty.panelBorder1Bean.renderEast}" style="top: 0px; position: relative" styleClass="whole_page" width="1024">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
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
                                                        <ice:selectInputText action="#{Education$AgreementWithDuty.txtSearchByName_action}" id="txtSearchByName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 5px; top:30px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete2" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete2" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
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
                                                            <ice:commandLink binding="#{Education$AgreementWithDuty.lnkEducationRequest}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$AgreementWithDuty.lnkEducationPaymentRequest}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$AgreementWithDuty.lnkEducationApprove}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$AgreementWithDuty.lnkEducationPaymentApprove}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$AgreementWithDuty.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$AgreementWithDuty.lnkChangeiNstitutionReq}" id="lnkChangeiNstitutionReq"
                                                                style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$AgreementWithDuty.lnkChangeInstApprove_action}"
                                                                binding="#{Education$AgreementWithDuty.lnkChangeInstApprove}" id="lnkChangeInstApprove"
                                                                style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$AgreementWithDuty.lnkInstRegistration_action}"
                                                                binding="#{Education$AgreementWithDuty.lnkInstRegistration}" id="lnkInstRegistration"
                                                                style="color:#306682;font-weight:bold" value="Institution Registration"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border-style: none; height: 277px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="List of Registered Employee"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" style="height: 384px" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; left: 0px; top:450px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Education$AgreementWithDuty.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6"
                                                                style="height: 264px; width: 190px; top: 100px"
                                                                value="#{Education$AgreementWithDuty.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$AgreementWithDuty.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$AgreementWithDuty.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$AgreementWithDuty.page_display_processMyEvent}" id="page_display" style="height: 829px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 795px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 800px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Duty Registration "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 769px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$AgreementWithDuty.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 742px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 732px; top: 0px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 181px; margin-left: 15px; left: 11px; top: 24px; position: absolute; width: 702px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectInputText action="#{Education$AgreementWithDuty.txtRequesterFullName_action}"
                                                                binding="#{Education$AgreementWithDuty.txtRequesterFullName}" id="txtRequesterFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="left: 182px; top: 26px; position: absolute"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 26px; top: 52px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 180px; top: 50px; position: absolute; width: 489px"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtRequesterId}" id="txtRequesterId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 26px; top: 26px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 180px; top: 76px; position: absolute; width: 489px"/>
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnSearchRequester_action}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif"
                                                                style="left: 624px; top: 26px; position: absolute" value="#{msgse.btnSearch}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtBirthDate}" disabled="true"
                                                                id="txtBirthDate" rendered="false" style="left: 180px; top: 128px; position: absolute; width: 130px"/>
                                                            <ice:outputLabel binding="#{Education$AgreementWithDuty.lblDeptID}" id="lblDeptID" rendered="false" style="height: 19px; left: 494px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel"
                                                                style="left: 26px; top: 104px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:outputLabel id="lblRequesterProgramName"
                                                                style="left: 26px; top: 130px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtlblRequesterEdLevel}" disabled="true"
                                                                id="txtlblRequesterEdLevel" style="left: 180px; top: 102px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtlblRequesterProgramName}" disabled="true"
                                                                id="txtlblRequesterProgramName" style="left: 180px; top: 128px; position: absolute; width: 239px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 480px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterEdLevel"
                                                                id="message2" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 96px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterProgramName"
                                                                id="message3" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 120px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                                id="message4" infoClass="infoMessage"
                                                                style="height: 20px; left: 384px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                                id="message5" infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                                id="message6" infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                            style="height: 21px; margin-left: 15px; left: 9px; top: 648px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnSaveOrUpdate_action}"
                                                                actionListener="#{Education$AgreementWithDuty.btnSaveOrUpdate_processAction}"
                                                                binding="#{Education$AgreementWithDuty.btnSaveOrUpdate}" disabled="true" id="btnSaveOrUpdate"
                                                                style="left: 240px; top: -10px; position: absolute; width: 71px" value="#{Education$AgreementWithDuty.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnReset_action}"
                                                                binding="#{Education$AgreementWithDuty.btnReset}" id="btnReset"
                                                                style="left: 336px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnDelete_action}"
                                                                binding="#{Education$AgreementWithDuty.btnDelete}" disabled="true" id="btnDelete"
                                                                style="left: 456px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnDelete}"/>
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnReset1_action}" id="btnReset1"
                                                                style="left: 144px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnNew}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution1" layout="flow"
                                                            style="height: 261px; margin-left: 15px; left: 9px; top: 360px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel" style="left: 24px; top: 72px; position: absolute" value="#{msgse.DutyinserviceYear}"/>
                                                            <ice:outputLabel id="lblStartDate" style="left: 24px; top: 120px; position: absolute" value="#{msgse.Dateofgraduation}"/>
                                                            <ice:commandButton action="#{Education$AgreementWithDuty.btnCalendarSatartDate_action}"
                                                                binding="#{Education$AgreementWithDuty.btnCalendarSatartDate}" id="btnCalendarSatartDate"
                                                                image="/resources/images/cal_icon.JPG" immediate="true"
                                                                style="left: 312px; top: 120px; position: absolute" value="submit"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 118px; position: absolute; width: 155px"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$AgreementWithDuty.chkDeny}" id="chkDeny"
                                                                partialSubmit="true" style="left: 286px; top: 22px; position: absolute"
                                                                value="#{Education$AgreementWithDuty.defaultSelectedData11.selectedBoolean}" valueChangeListener="#{Education$AgreementWithDuty.chkDeny_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$AgreementWithDuty.calStartDate}" id="calStartDate"
                                                                rendered="false"
                                                                style="left:400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                                value="#{Education$AgreementWithDuty.selectInputDate1Bean.date1}" valueChangeListener="#{Education$AgreementWithDuty.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$AgreementWithDuty.calAppliedDate}" id="calAppliedDate"
                                                                rendered="false"
                                                                style="left: 400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                                value="#{Education$AgreementWithDuty.selectInputDateBean2.date1}" valueChangeListener="#{Education$AgreementWithDuty.calAppliedDate_processValueChange}"/>
                                                            <ice:outputLabel id="lblEducationLevelBAsic" style="left: 336px; top: 24px; position: absolute" value="#{msgse.Deny}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 94px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblEndDate" style="left: 24px; top: 96px; position: absolute" value="#{msgse.CurrentDate}"/>
                                                            <ice:outputLabel id="lblDrivingSkill" style="left: 504px; top: 24px; position: absolute" value="#{msgse.Approve}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$AgreementWithDuty.chkApprove}" id="chkApprove"
                                                                partialSubmit="true" style="left: 478px; top: 22px; position: absolute"
                                                                value="#{Education$AgreementWithDuty.defaultSelectedData12.selectedBoolean}" valueChangeListener="#{Education$AgreementWithDuty.chkApprove_processValueChange}"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtStartDate" id="message10"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 360px; top: 120px; position: absolute; width: 22px" warnClass="warnMessage"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtDuty}" id="txtDuty" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblStartDate1" style="left: 24px; top: 168px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputTextarea binding="#{Education$AgreementWithDuty.txtRemark}" id="txtRemark" style="left: 144px; top: 168px; position: absolute; width: 261px"/>
                                                            <ice:outputLabel binding="#{Education$AgreementWithDuty.lbStatus}" id="lbStatus"
                                                                style="left: 24px; top: 24px; position: absolute; width: 237px" value="#{msgse.perminDuty}"/>
                                                            <ice:outputLabel binding="#{Education$AgreementWithDuty.lblEducationId}" id="lblEducationId" style="left: 624px; top: 0px; position: absolute; width: 69px"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtDuty" id="message12" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 312px; top: 72px; position: absolute; width: 22px" warnClass="iceMsgWarn warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution2" layout="flow"
                                                            style="height: 125px; margin-left: 15px; left: 9px; top: 216px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblInstitutionName1" style="left: 24px; top: 24px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblProgramName1" style="left: 360px; top: 24px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:outputLabel id="lblEducationLevel1" style="left: 24px; top: 48px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel binding="#{Education$AgreementWithDuty.lblEducreqestID}" id="lblEducreqestID"
                                                                rendered="false" style="height: 19px; left: 650px; top: 0px; position: absolute"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtLevel}" disabled="true" id="txtLevel" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtInstitName}" disabled="true"
                                                                id="txtInstitName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtProgName}" disabled="true" id="txtProgName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 478px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblDocumentReference1"
                                                                style="left: 360px; top: 48px; position: absolute; width: 117px" value="#{msgse.PermissioEducationdocNum}"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtDocreferenceNum}" disabled="true"
                                                                id="txtDocreferenceNum" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 478px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtInstitName" id="message7" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 288px; top: 24px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtLevel" id="message8" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 288px; top: 48px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtProgName" id="message9" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 648px; top: 24px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtDocreferenceNum" id="message11" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 648px; top: 48px; position: absolute; width: 45px" warnClass="iceMsgWarn warnMessage"/>
                                                            <ice:inputText binding="#{Education$AgreementWithDuty.txtGrade}" disabled="true" id="txtGrade" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 23px; left: 118px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblGrade1"
                                                                style="height: 41px; left: 24px; top: 72px; position: absolute; width: 93px" value="#{msgse.LevelofEducation}"/>
                                                        </ice:panelLayout>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2005-2006 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$AgreementWithDuty.pnlPopupSuccessOrFailure}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:100" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$AgreementWithDuty.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$AgreementWithDuty.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$AgreementWithDuty.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$AgreementWithDuty.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$AgreementWithDuty.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$AgreementWithDuty.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$AgreementWithDuty.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$AgreementWithDuty.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$AgreementWithDuty.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$AgreementWithDuty.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$AgreementWithDuty.decisionsMadeOnRequestList}" var="currentRow">
                                            <ice:column id="colNumber">
                                                <ice:outputText id="optTxtForColumnNumber" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDecisionGiven">
                                                <ice:outputText id="optTxtForColumnDecisionGiven" value="#{currentRow['givenDecision']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDecisionGiven" value="Decision"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpId">
                                                <ice:outputText id="optTxtForColumnEmpId" value="#{currentRow['deciderEmployeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId" value="EmpId"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEmpFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName" value="#{currentRow['deciderFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommentGiven">
                                                <ice:outputText id="optTxtForCommentGiven" value="#{currentRow['commentGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven" value="Comment Given"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colDate">
                                                <ice:outputText id="optTxtForDate" value="#{currentRow['decidedDateAndTIme']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate" value="Date"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
