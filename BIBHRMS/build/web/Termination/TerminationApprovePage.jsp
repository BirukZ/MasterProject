<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2011, 7:48:31 AM
    Author     : mekete
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_Termination" var="msgst"/>
        <html id="outputHtml">
            <head id="outputHead1">
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle11"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <script src="../Script/jquery.notice.js"></script>
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
   
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1056" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Termination$TerminationApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Termination$TerminationApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Termination$TerminationApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Termination$TerminationApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Termination$TerminationApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Termination$TerminationApprovePage.lnkTerminationRequest_action}"
                                                                id="lnkTerminationRequest" style="color:#306682;font-weight:bold" value="Ttermination Request"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending Request"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;;border:none;display: block;float:left;height:180px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 187px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox
                                                                binding="#{Termination$TerminationApprovePage.selectRequestApprovableRequestLists}"
                                                                id="selectRequestApprovableRequestLists" partialSubmit="true" size="6"
                                                                style="height: 168px; width: 190px"
                                                                value="#{Termination$TerminationApprovePage.selectedRequestFromApprovableList.selectedObject}" valueChangeListener="#{Termination$TerminationApprovePage.selectedRequestFromApprovableList_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Termination$TerminationApprovePage.requestListsToBeApproved}"/>
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
                                                            <ice:selectOneListbox binding="#{Termination$TerminationApprovePage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 280px; width: 190px"
                                                                value="#{Termination$TerminationApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Termination$TerminationApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Termination$TerminationApprovePage.requestHistoryLists}"/>
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
                                <ice:panelGroup id="page_display" style="height: 901px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 891px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 885px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="TERMINATION APPROVE PAGE"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 865px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="trminationApproval" style="height: 838px" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 125px; margin-left: 15px; left: 20px; top: 175px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterFullName}" disabled="true"
                                                            id="txtRequesterFullName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgst.Terminator}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 48px; position: absolute" value="#{msgst.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgst.Id}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 479px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterId}" disabled="true"
                                                            id="txtRequesterId" immediate="true" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 454px; top: 22px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgst.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 72px; position: absolute" value="#{msgst.Position}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 479px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtSalary}" disabled="true" id="txtSalary" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblRequesterPosition2" style="left: 48px; top: 96px; position: absolute" value="#{msgst.Salary}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestInfo" layout="flow"
                                                        style="height: 261px; left: 35px; top: 320px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblTerminationType" style="left: 384px; top: 72px; position: absolute" value="#{msgst.TerminationType}"/>
                                                        <ice:outputLabel id="lblDocumentReferenceNumber" style="left: 384px; top: 96px; position: absolute" value="#{msgst.DocRefNumber}"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="left: 48px; top: 96px; position: absolute" value="#{msgst.AppliedDate}"/>
                                                        <ice:outputLabel id="lblTerminationDate" style="left: 48px; top: 120px; position: absolute" value="#{msgst.TerminationDate}"/>
                                                        <ice:inputText action="#{Termination$TerminationApprovePage.txtAppliedDate_action}"
                                                            binding="#{Termination$TerminationApprovePage.txtAppliedDate}" disabled="true" id="txtAppliedDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 191px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtTerminationDate}" disabled="true"
                                                            id="txtTerminationDate" style="left: 166px; top: 118px; position: absolute; width: 191px"/>
                                                        <ice:inputText action="#{Termination$TerminationApprovePage.txtDocReferenceNumber_action}"
                                                            binding="#{Termination$TerminationApprovePage.txtDocReferenceNumber}" disabled="true"
                                                            id="txtDocReferenceNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 502px; top: 94px; position: absolute; width: 155px"/>
                                                        <ice:inputTextarea binding="#{Termination$TerminationApprovePage.txtaDescription}" disabled="true"
                                                            id="txtaDescription" style="left: 166px; top: 190px; position: absolute; width: 503px"/>
                                                        <ice:outputLabel id="lblDescription" style="left: 48px; top: 192px; position: absolute" value="#{msgst.Description}"/>
                                                        <ice:outputLabel id="lblTerminationCatagory" style="left: 48px; top: 72px; position: absolute" value="#{msgst.TerminationCatagory}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtTermCategory}" disabled="true"
                                                            id="txtTermCategory" rendered="false" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txttermType}" disabled="true"
                                                            id="txttermType" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 502px; top: 70px; position: absolute; width: 155px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtCalculatedPenal}" disabled="true"
                                                            id="txtCalculatedPenal" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 502px; top: 118px; position: absolute; width: 155px"/>
                                                        <ice:outputLabel id="lblPaidSlary1" style="left: 384px; top: 120px; position: absolute" value="#{msgst.PenalityPayment}"/>
                                                        <ice:selectOneMenu binding="#{Termination$TerminationApprovePage.drlTerminationCatagory}"
                                                            disabled="true" id="drlTerminationCatagory" partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 168px; top: 72px; position: absolute; width: 191px" value="#{Termination$TerminationApprovePage.selectObjectOfTerminationCatagory.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Termination$TerminationApprovePage.terminationCatagories}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:selectBooleanCheckbox binding="#{Termination$TerminationApprovePage.chksuccesisor}"
                                                            id="chksuccesisor" partialSubmit="true"
                                                            style="height: 23px; left: 46px; top: 24px; position: absolute"
                                                            value="#{Termination$TerminationRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Termination$TerminationApprovePage.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior1" style="height: 17px; left: 96px; top: 24px; position: absolute" value="#{msgst.Succesiosor}"/>
                                                        <ice:commandButton action="#{Termination$TerminationApprovePage.btnCalculatePenality_action}"
                                                            binding="#{Termination$TerminationApprovePage.btnCalculatePenality}" id="btnCalculatePenality"
                                                            style="left: 168px; top: 134px; position: absolute; width: 191px" value="#{msgst.btnClaPenPay}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                        style="height: 174px; margin-left: 15px; left: 20px; top: 600px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeciderDepartment" style="left: 360px; top: 24px; position: absolute" value="#{msgst.DeciderDepartment}"/>
                                                        <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 24px; position: absolute" value="#{msgst.DeciderId}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtDeciderDepartment}" disabled="true"
                                                            id="txtDeciderDepartment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 22px; position: absolute; width: 215px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 167px"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 48px; top: 48px; position: absolute" value="#{msgst.DeciderFullName}"/>
                                                        <ice:outputLabel id="deciderPosition" style="left: 360px; top: 48px; position: absolute" value="#{msgst.DeciderPosition}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtDeciderFullName}" disabled="true"
                                                            id="txtDeciderFullName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 167px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtDeciderPosition}" disabled="true"
                                                            id="txtDeciderPosition" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 46px; position: absolute; width: 215px"/>
                                                        <ice:selectOneMenu binding="#{Termination$TerminationApprovePage.drlDecision}" id="drlDecision"
                                                            partialSubmit="true"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 167px"
                                                            value="#{Termination$TerminationApprovePage.selectedObjectOneMenuDecisionType.selectedObject}" visible="true">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{Termination$TerminationApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision" style="left: 53px; top: 78px; position: absolute" value="#{msgst.Decision}"/>
                                                        <ice:inputTextarea binding="#{Termination$TerminationApprovePage.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                        <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="#{msgst.Comment}"/>
                                                        <ice:commandLink action="#{Termination$TerminationApprovePage.lnkViewPrevieousDecisions_action}"
                                                            id="lnkViewPrevieousDecisions" style="left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                        style="height: 25px; margin-left: 15px; left: 20px; top: 790px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Termination$TerminationApprovePage.btnPostDecision_action}"
                                                            actionListener="#{Termination$TerminationApprovePage.btnPostDecision_processAction}"
                                                            binding="#{Termination$TerminationApprovePage.btnPostDecision}" id="btnPostDecision"
                                                            style="left: 264px; top: -10px; position: absolute; width: 71px" value="#{msgst.btnPost}"/>
                                                        <ice:commandButton action="#{Termination$TerminationApprovePage.btnReset_action}"
                                                            binding="#{Termination$TerminationApprovePage.btnReset}" id="btnReset"
                                                            style="left: 408px; top: -10px; position: absolute; width: 71px" value="#{msgst.btnReset}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequester1" layout="flow"
                                                        style="height: 106px; margin-left: 15px; left: 20px; top: 50px; position: absolute; width: 694px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblRequester1" style="left: 10px; top:4px; position: absolute" value="#{msgst.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment1" style="left: 48px; top: 48px; position: absolute" value="#{msgst.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId1" style="left: 456px; top: 24px; position: absolute" value="Id"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterDepartment1}" disabled="true"
                                                            id="txtRequesterDepartment1" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterId1}" disabled="true"
                                                            id="txtRequesterId1" immediate="true" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 22px; position: absolute; width: 191px"/>
                                                        <ice:outputLabel id="lblRequsterFullName1" style="left: 48px; top: 24px; position: absolute" value="#{msgst.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition1" style="left: 48px; top: 72px; position: absolute" value="#{msgst.Position}"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterPosition1}" disabled="true"
                                                            id="txtRequesterPosition1" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Termination$TerminationApprovePage.txtRequesterFullName1}" disabled="true"
                                                            id="txtRequesterFullName1" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 191px"/>
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
                                                href="http://www.bunnabanksc.comt" style="text-decoration:none;color:orange">Bunna International Bank|
                                                  Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Termination$TerminationApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Termination$TerminationApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Termination$TerminationApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Termination$TerminationApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Termination$TerminationApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
