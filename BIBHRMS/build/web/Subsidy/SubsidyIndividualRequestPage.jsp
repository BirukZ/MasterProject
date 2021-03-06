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
        <f:loadBundle basename="Localization.HRLocaalization_Subsidy" var="msgSu"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Subsidy Request</title>
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
                        <img alt="" class="source-image" height="600" id="img" src="../resources/images/WholePageBG.png" width="1056"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Subsidy$SubsidyIndividualRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Subsidy$SubsidyIndividualRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Subsidy$SubsidyIndividualRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Subsidy$SubsidyIndividualRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Subsidy$SubsidyIndividualRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                        style="height:470px; top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; top :20px; left: 5px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="Pending_Group_Header">
                                                        <ice:outputText id="lblPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="BoardPending" width="100%">
                                                    <ice:panelGroup id="Pending_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:100px; width: 100%">
                                                        <ice:panelLayout id="PendingContainer" style="height: 93px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Subsidy$SubsidyIndividualRequestPage.selectPending}"
                                                                id="selectPending" partialSubmit="true" size="2"
                                                                style="height: 94px; left: 0px; top: 0px; position: relative; width: 190px"
                                                                validator="#{Subsidy$SubsidyIndividualRequestPage.selectPending_validate}"
                                                                value="#{Subsidy$SubsidyIndividualRequestPage.selectObjectOfPendingBean.selectedObject}" valueChangeListener="#{Subsidy$SubsidyIndividualRequestPage.selectPending_processValueChange}">
                                                                <f:selectItems id="selectOneListboxPending" value="#{Subsidy$SubsidyIndividualRequestPage.pendingRequestLists}"/>
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
                                                            <ice:selectOneListbox binding="#{Subsidy$SubsidyIndividualRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 240px; width: 190px"
                                                                value="#{Subsidy$SubsidyIndividualRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Subsidy$SubsidyIndividualRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Subsidy$SubsidyIndividualRequestPage.requestHistoryLists}"/>
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
                                <ice:panelGroup dragListener="#{Subsidy$SubsidyIndividualRequestPage.page_display_processMyEvent}" id="page_display" style="height: 555px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 520px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 540px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="SUBSIDY REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 529px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="pnlGroupAll" style="height: 500px; left: 0px; top: 0px; position: absolute" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                        style="height: 135px; margin-left: 15px; left: 9px; top: 24px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:selectInputText action="#{Subsidy$SubsidyIndividualRequestPage.txtRequesterFullName_action}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 166px; top: 22px; position: absolute"
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgSu.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="#{msgSu.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 456px; top: 24px; position: absolute" value="#{msgSu.Id}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtRequesterId}" disabled="true"
                                                            id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgSu.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="#{msgSu.Position}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnSearchRequester_action}"
                                                            id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 648px; top: 24px; position: absolute"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 480px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
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
                                                    <ice:panelLayout id="pnlLayoutRequestInfo" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 228px; margin-left: 15px; left: 9px; top: 168px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblTerminationType"
                                                            style="font-size: 10px; left: 408px; top: 48px; position: absolute; width: 143px" value="#{msgSu.totalAmount}"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="font-size: 10px; left: 24px; top: 144px; position: absolute" value="#{msgSu.remark}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtMonth}" disabled="true" id="txtMonth" style="left: 166px; top: 46px; position: absolute; width: 167px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtTotalAmount}" disabled="true"
                                                            id="txtTotalAmount"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94);left: 550px; top: 46px; position: absolute; width: 144px" styleClass="iceInpTxt"/>
                                                        <ice:selectOneMenu binding="#{Subsidy$SubsidyIndividualRequestPage.drlLocation}" disabled="true"
                                                            id="drlLocation" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 168px; top: 72px; position: absolute; width: 191px"
                                                            styleClass="iceSelOneMnu" value="#{Subsidy$SubsidyIndividualRequestPage.selectObjectOfTerminationCatagory.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems" value="#{Subsidy$SubsidyIndividualRequestPage.subsidyLocation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputTextarea binding="#{Subsidy$SubsidyIndividualRequestPage.txtRemark}" disabled="true"
                                                            id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 166px; top: 118px; position: absolute; width: 287px"/>
                                                        <ice:outputLabel id="lblDescription" style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgSu.currentMonth}"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnCalendarTerminationDate_action}"
                                                            actionListener="#{Subsidy$SubsidyIndividualRequestPage.btnCalendarTerminationDate_processAction}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnCalendarTerminationDate}"
                                                            id="btnCalendarTerminationDate" image="/resources/images/cal_icon.JPG" immediate="true"
                                                            style="left: 336px; top: 48px; position: absolute" value="submit"/>
                                                        <ice:outputLabel id="lblTerminationCatagory"
                                                            style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgSu.location}"/>
                                                        <ice:outputLabel id="lblPaidSlary" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Penality Payment"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnCalculatePenality_action}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnCalculatePenality}" id="btnCalculatePenality"
                                                            rendered="false" style="left: 168px; top: 162px; position: absolute; width: 191px" value="Claculate Penality Payment"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtPenality}" disabled="true"
                                                            id="txtPenality" rendered="false" style="left: 526px; top: 118px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox binding="#{Subsidy$SubsidyIndividualRequestPage.chksuccesisor}"
                                                            id="chksuccesisor" partialSubmit="true" rendered="false"
                                                            style="position: absolute; left: 96px; top: 24px"
                                                            value="#{Subsidy$SubsidyIndividualRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Subsidy$SubsidyIndividualRequestPage.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior" rendered="false" style="left: 144px; top: 24px; position: absolute" value="Does the Terminator has a Succesiosor?"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtdocumnet}" disabled="true"
                                                            id="txtdocumnet"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 166px; top: 94px; position: absolute; width: 191px" styleClass="iceInpTxt"/>
                                                        <ice:outputLabel id="lblTerminationCatagory1"
                                                            style="font-size: 10px; left: 24px; top: 96px; position: absolute; width: 119px" value="#{msgSu.document}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualRequestPage.txtAppliedDate}" disabled="true"
                                                            id="txtAppliedDate" style="left: 166px; top: 22px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblDescription1" style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgSu.appliedDate}"/>
                                                        <ice:commandLink action="#{Subsidy$SubsidyIndividualRequestPage.lnkViewPrevieousDecisions_action}"
                                                            id="lnkViewPrevieousDecisions1" style="left: 528px; top: 192px; position: absolute" value="View Status of this request"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow" rendered="true"
                                                        style="height: 44px; margin-left: 15px; left: 9px; top: 432px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnSaveOrEditOrUpdate_action}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnSaveOrEditOrUpdate}" disabled="true"
                                                            id="btnSaveOrEditOrUpdate" style="left: 264px; top: 0px; position: absolute; width: 71px" value="#{Subsidy$SubsidyIndividualRequestPage.newOrEditOrUpdateLabel}"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnDelete_action}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnDelete}" disabled="true" id="btnDelete"
                                                            style="left: 360px; top: 0px; position: absolute; width: 71px" value="#{msgSu.Delete}"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnReset_action}"
                                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnReset}" id="btnReset"
                                                            style="left: 456px; top: 0px; position: absolute; width: 70px" value="#{msgSu.Reset}"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnNew_action}" id="btnNew"
                                                            style="left: 168px; top: 0px; position: absolute; width: 71px" value="#{msgSu.New}"/>
                                                    </ice:panelLayout>
                                                    <ice:selectInputDate binding="#{Subsidy$SubsidyIndividualRequestPage.calTerminationDate}"
                                                        id="calTerminationDate" rendered="false"
                                                        style="height: 212px; left: 300px; top: 200px; position: absolute; width: 190px; z-index:50"
                                                        value="#{Subsidy$SubsidyIndividualRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Subsidy$SubsidyIndividualRequestPage.calTerminationDate_processValueChange}"/>
                                                    <ice:selectInputDate binding="#{Subsidy$SubsidyIndividualRequestPage.calAppliedDate}" id="calAppliedDate"
                                                        rendered="false" style="height: 212px; left: 117px; top: 150px; position: absolute; width: 190px"
                                                        value="#{Subsidy$SubsidyIndividualRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Subsidy$SubsidyIndividualRequestPage.calAppliedDate_processValueChange}"/>
                                                    <!--/ice:panelLayout-->
                                                    <ice:outputLink id="outputLink1" value="outputLink"/>
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
                                                href="http://www.Bunna.com" style="text-decoration:none;color:orange">Bunna International Bank |
Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Subsidy$SubsidyIndividualRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Subsidy$SubsidyIndividualRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Subsidy$SubsidyIndividualRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmDelete" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            Bunna HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText id="outputText3" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnPopupOkDelete_action}"
                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnPopupOkDelete}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnPopupCancelDelete_action}"
                                            binding="#{Subsidy$SubsidyIndividualRequestPage.btnPopupCancelDelete}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualRequestPage.pnlPopupConfirmViewRequest}" draggable="true"
                            id="pnlPopupConfirmViewRequest" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupConfirmViewRequest" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmViewRequestPopupHeader" value="            Bunna HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmViewRequestBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmViewRequestBody">
                                        <ice:outputText id="outTxtConfirmViewRequest" style="left: 20px; top: 0px; position: absolute; width: 360px" value="THIS EMPLOYEE ALREADY POSTED REQUEST\nWANT TO VIEW THE REQUEST?"/>
                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnPopupConfirmViewRequestYes_action}"
                                            id="btnPopupConfirmViewRequestyes" style="left: 96px; top: 35px; position: absolute; width: 88px" value="Yes"/>
                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnPopupConfirmViewRequestNo_action}"
                                            id="btnPopupConfirmViewRequestNo" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna HRMS - "/>
                                    <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Subsidy$SubsidyIndividualRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
