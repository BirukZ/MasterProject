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
        <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgst"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Termination Request</title>
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
                    function BenefitRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="990" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Termination$TerminationRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Termination$TerminationRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Termination$TerminationRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Termination$TerminationRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Termination$TerminationRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:400px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; top :20px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Termination$TerminationRequestPage.lnkTerminationApprove_action}"
                                                                id="lnkTerminationApprove" style="color:#306682;font-weight:bold" value="Termination Approve Page"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Termination$TerminationRequestPage.lnkAuthorization_action}"
                                                                id="lnkAuthorization" style="color:#306682;font-weight:bold" value="Authorization Page"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="Pending_Group_Header">
                                                        <ice:outputText id="lblPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="BoardPending" width="100%">
                                                    <ice:panelGroup id="Pending_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:100px; width: 100%">
                                                        <ice:panelLayout id="PendingContainer" style="height: 93px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Termination$TerminationRequestPage.selectPending}"
                                                                id="selectPending" partialSubmit="true" size="2"
                                                                style="height: 94px; left: 0px; top: 0px; position: relative; width: 190px"
                                                                validator="#{Termination$TerminationRequestPage.selectPending_validate}"
                                                                value="#{Termination$TerminationRequestPage.selectObjectOfPendingBean.selectedObject}" valueChangeListener="#{Termination$TerminationRequestPage.selectPending_processValueChange}">
                                                                <f:selectItems id="selectOneListboxPending" value="#{Termination$TerminationRequestPage.pendingRequestLists}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_history" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="history_Group_Header">
                                                        <ice:outputText id="lblHistoryStatus" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="HistoryStatusBoard" width="100%">
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:280px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 285px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Termination$TerminationRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 240px; width: 190px"
                                                                value="#{Termination$TerminationRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Termination$TerminationRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Termination$TerminationRequestPage.requestHistoryLists}"/>
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
                                <ice:panelGroup dragListener="#{Termination$TerminationRequestPage.page_display_processMyEvent}" id="page_display" style="height: 810px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 800px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 780px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="TERMINATION REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 793px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlGroupAll" style="height: 742px; left: 0px; top: 0px; position: absolute" styleClass="filedset_border">
                                                    <ice:panelLayout binding="#{Termination$TerminationRequestPage.pnlLayoutRequester}" id="pnlLayoutRequester"
                                                        layout="flow"
                                                        style="height: 156px; margin-left: 15px; left: 9px; top: 96px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{Termination$TerminationRequestPage.txtRequesterFullName_action}"
                                                            binding="#{Termination$TerminationRequestPage.txtRequesterFullName}" disabled="true"
                                                            id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgst.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgst.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgst.Id}"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtRequesterId}" id="txtRequesterId"
                                                            immediate="true" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 22px; position: absolute; width: 143px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgst.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgst.Position}"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 624px; top: 24px; position: absolute"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 456px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                            id="message7" infoClass="infoMessage"
                                                            style="height: 20px; left: 384px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                            id="message8" infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                            id="message9" infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Termination$TerminationRequestPage.pnlLayoutRequestInfo}"
                                                        id="pnlLayoutRequestInfo" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 228px; margin-left: 15px; left: 9px; top: 432px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblTerminationType" style="left: 24px; top: 72px; position: absolute" value="#{msgst.TerminationType}"/>
                                                        <ice:outputLabel id="lblDocumentReferenceNumber" style="left: 24px; top: 96px; position: absolute" value="#{msgst.DocRefNumber}"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="left: 384px; top: 48px; position: absolute" value="#{msgst.AppliedDate}"/>
                                                        <ice:outputLabel id="lblTerminationDate" style="left: 384px; top: 72px; position: absolute" value="#{msgst.TerminationDate}"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtAppliedDate}" id="txtAppliedDate"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 502px; top: 46px; position: absolute; width: 155px" value="#{Termination$TerminationRequestPage.today}"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtTerminationDate}" disabled="true"
                                                            id="txtTerminationDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 502px; top: 70px; position: absolute; width: 143px"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtDocReferenceNumber}"
                                                            id="txtDocReferenceNumber"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 94px; position: absolute; width: 191px" styleClass="iceInpTxt-dis"/>
                                                        <ice:selectOneMenu binding="#{Termination$TerminationRequestPage.drlTerminationCatagory}"
                                                            id="drlTerminationCatagory" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 46px; position: absolute; width: 191px"
                                                            value="#{Termination$TerminationRequestPage.selectObjectOfTerminationCatagory.selectedObject}" valueChangeListener="#{Termination$TerminationRequestPage.drlTerminationCatagory_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Termination$TerminationRequestPage.terminationCatagories}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectOneMenu binding="#{Termination$TerminationRequestPage.drlTerminationType}"
                                                            id="drlTerminationType" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 70px; position: absolute; width: 191px"
                                                            value="#{Termination$TerminationRequestPage.selectObjectOfTerminationType.selectedObject}" valueChangeListener="#{Termination$TerminationRequestPage.drlTerminationType_processValueChange}">
                                                            <f:selectItems id="selectOneMenu2selectItems" value="#{Termination$TerminationRequestPage.terminationTypes}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputTextarea binding="#{Termination$TerminationRequestPage.txtaDescription}" id="txtaDescription" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 142px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblDescription" style="left: 24px; top: 144px; position: absolute" value="#{msgst.Description}"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnCalendarTerminationDate_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnCalendarTerminationDate}"
                                                            id="btnCalendarTerminationDate" image="/resources/images/cal_button.gif" immediate="true"
                                                            style="left: 652px; top: 72px; position: absolute" value="submit"/>
                                                        <ice:outputLabel id="lblTerminationCatagory" style="left: 24px; top: 48px; position: absolute" value="#{msgst.TerminationCatagory}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTerminationCatagory"
                                                            id="message2" infoClass="infoMessage"
                                                            style="height: 20px; left: 336px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlTerminationType" id="message3"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 336px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocReferenceNumber"
                                                            id="message4" infoClass="infoMessage"
                                                            style="height: 20px; left: 336px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAppliedDate" id="message5"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTerminationDate" id="message6"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 672px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        <ice:outputLabel id="lblPaidSlary" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Penality Payment"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnCalculatePenality_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnCalculatePenality}" id="btnCalculatePenality"
                                                            rendered="false" style="left: 168px; top: 162px; position: absolute; width: 191px" value="Claculate Penality Payment"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtPenality}" disabled="true"
                                                            id="txtPenality" rendered="false" style="left: 526px; top: 118px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TerminationRequestPage.chksuccesisor}"
                                                            id="chksuccesisor" partialSubmit="true" rendered="false"
                                                            style="position: absolute; left: 96px; top: 24px"
                                                            value="#{Termination$TerminationRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Termination$TerminationRequestPage.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior" rendered="false" style="left: 144px; top: 24px; position: absolute" value="Does the Terminator has a Succesiosor?"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow" rendered="true"
                                                        style="height: 36px; margin-left: 15px; left: 9px; top: 672px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnSaveOrEditOrUpdate_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnSaveOrEditOrUpdate}" disabled="true"
                                                            id="btnSaveOrEditOrUpdate" style="left: 168px; top: 0px; position: absolute; width: 71px" value="#{Termination$TerminationRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnDelete_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnDelete}" id="btnDelete"
                                                            style="left: 264px; top: 0px; position: absolute; width: 71px" value="#{msgst.btnDelete}"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnReset_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnReset}" id="btnReset"
                                                            style="left: 360px; top: 0px; position: absolute; width: 70px" value="Reset"/>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Termination$TerminationRequestPage.calTerminationDate}"
                                                        id="calTerminationDate" immediate="true" popupDateFormat="yyyy-MM-dd" rendered="false"
                                                        style="height: 212px; left: 300px; top: 400px; position: absolute; width: 190px; z-index:50"
                                                        value="#{Termination$TerminationRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Termination$TerminationRequestPage.calTerminationDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{Termination$TerminationRequestPage.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 117px; top: 232px; position: absolute; width: 190px"
                                                        value="#{Termination$TerminationRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Termination$TerminationRequestPage.calAppliedDate_processValueChange}"/>
                                                    <!--/ice:panelLayout-->
                                                    <ice:outputLink id="outputLink1" value="outputLink"/>
                                                    <ice:panelLayout binding="#{Termination$TerminationRequestPage.pnlLayoutEmployee1}" id="pnlLayoutEmployee1"
                                                        layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 156px; margin-left: 15px; left: 9px; top: 264px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblTerminator" style="left: 10px; top: 4px; position: absolute" value="#{msgst.Terminator}"/>
                                                        <ice:outputLabel id="lblEmployeeDepartment1" style="left: 48px; top: 62px; position: absolute" value="#{msgst.Department}"/>
                                                        <ice:outputLabel id="lblEmployeeId1" style="left: 432px; top: 24px; position: absolute" value="#{msgst.Id}"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtEmployeeDepartment1}" disabled="true"
                                                            id="txtEmployeeDepartment1" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtEmployeeId}" id="txtEmployeeId"
                                                            immediate="true" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 22px; position: absolute; width: 143px"/>
                                                        <ice:outputLabel id="lblEmployeeFullName1" style="left: 48px; top: 24px; position: absolute" value="#{msgst.FullName}"/>
                                                        <ice:outputLabel id="lblEmployeePosition1" style="left: 48px; top: 96px; position: absolute" value="#{msgst.Position}"/>
                                                        <ice:selectInputText action="#{Termination$TerminationRequestPage.txtEmployeeFullName_action}"
                                                            binding="#{Termination$TerminationRequestPage.txtEmployeeFullName}" disabled="true"
                                                            id="txtEmployeeFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                            listVar="employeeList" partialSubmit="true" rows="10"
                                                            style="height: 23px; left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoCompleteAccused" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoCompleteAccused" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtEmployeePosition}" disabled="true"
                                                            id="txtEmployeePosition" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnSearchOffender1_action}"
                                                            binding="#{Termination$TerminationRequestPage.btnSearchOffender1}" id="btnSearchOffender1"
                                                            image="/resources/images/fig_search.gif" style="left: 624px; top: 24px; position: absolute"/>
                                                        <ice:inputText binding="#{Termination$TerminationRequestPage.txtSalary}" disabled="true" id="txtSalary" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 118px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblRequesterPosition2" style="left: 49px; top: 121px; position: absolute" value="#{msgst.Salary}"/>
                                                        <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                            for="txtEmployeeId" id="message10" infoClass="iceMsgInfo infoMessage"
                                                            style="height: 20px; left: 456px; top: 24px; position: absolute; width: 21px" warnClass="iceMsgWarn warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutForWhom1"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 9px; top: 24px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblForWhom1" style=" top:10px; left:20px; position: absolute" value="#{msgst.ForWhom}"/>
                                                        <ice:selectOneRadio binding="#{Termination$TerminationRequestPage.radioGroupApplierType}" dir="LTR"
                                                            id="radioGroupApplierType" partialSubmit="true" style=" top:10px; left:220px; position: absolute" valueChangeListener="#{Termination$TerminationRequestPage.radioGroupApplierType_processValueChange}">
                                                            <f:selectItem itemLabel="Me On Subordinates" itemValue="#{Termination$TerminationRequestPage.IMMEDIATEBOSS}"/>
                                                            <f:selectItem itemLabel="Another Employee" itemValue="#{Termination$TerminationRequestPage.ANOTHEREMPLOYEE}"/>
                                                        </ice:selectOneRadio>
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
                                                href="http://www.bunnabanksc.com" style="text-decoration:none;color:orange">Bunna International Bank|Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Termination$TerminationRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Termination$TerminationRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Termination$TerminationRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmDelete" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText id="outputText3" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnPopupOkDelete_action}"
                                            binding="#{Termination$TerminationRequestPage.btnPopupOkDelete}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnPopupCancelDelete_action}"
                                            binding="#{Termination$TerminationRequestPage.btnPopupCancelDelete}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationRequestPage.pnlPopupConfirmViewRequest}" draggable="true"
                            id="pnlPopupConfirmViewRequest" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmViewRequest" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmViewRequestPopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmViewRequestBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmViewRequestBody">
                                        <ice:outputText id="outTxtConfirmViewRequest" style="left: 20px; top: 0px; position: absolute; width: 360px" value="THIS EMPLOYEE ALREADY POSTED REQUEST\nWANT TO VIEW THE REQUEST?"/>
                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnPopupConfirmViewRequestYes_action}"
                                            id="btnPopupConfirmViewRequestyes" style="left: 96px; top: 35px; position: absolute; width: 88px" value="Yes"/>
                                        <ice:commandButton action="#{Termination$TerminationRequestPage.btnPopupConfirmViewRequestNo_action}"
                                            id="btnPopupConfirmViewRequestNo" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Termination$TerminationRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Termination$TerminationRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
