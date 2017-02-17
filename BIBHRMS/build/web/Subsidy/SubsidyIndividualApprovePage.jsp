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
        <f:loadBundle basename="Localization.HRLocaalization_Subsidy" var="msgSu"/>
        <html id="outputHtml">
            <head id="outputHead1">
                <title>Subsidy Approve</title>
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
                    var SubsidyIndividualApprovePage=jQuery.noConflict();
                </script>
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="960" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Subsidy$SubsidyIndividualApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Subsidy$SubsidyIndividualApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Subsidy$SubsidyIndividualApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Subsidy$SubsidyIndividualApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Subsidy$SubsidyIndividualApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                                binding="#{Subsidy$SubsidyIndividualApprovePage.selectRequestApprovableRequestLists}"
                                                                id="selectRequestApprovableRequestLists" partialSubmit="true" size="6"
                                                                style="height: 168px; width: 190px"
                                                                value="#{Subsidy$SubsidyIndividualApprovePage.selectedRequestFromApprovableList.selectedObject}" valueChangeListener="#{Subsidy$SubsidyIndividualApprovePage.selectedRequestFromApprovableList_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Subsidy$SubsidyIndividualApprovePage.requestListsToBeApproved}"/>
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
                                                            <ice:selectOneListbox binding="#{Subsidy$SubsidyIndividualApprovePage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 280px; width: 190px"
                                                                value="#{Subsidy$SubsidyIndividualApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Subsidy$SubsidyIndividualApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Subsidy$SubsidyIndividualApprovePage.requestHistoryLists}"/>
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
                                <ice:panelGroup id="page_display" style="width: 814px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 795px; left: 0px; position: relative; width: 816px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1000px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="SUBSIDY APPROVE PAGE"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 769px; left: 0px; top: 20px; position: absolute; width: 814px">
                                                <ice:panelGroup id="trminationApproval" style="height: 742px" styleClass="filedset_border">
                                                    <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                        style="height: 174px; margin-left: 15px; left: 20px; top: 475px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="#{msgSu.DeciderDepartment}"/>
                                                        <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 48px; position: absolute" value="#{msgSu.DeciderId}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtDeciderDepartment}" disabled="true"
                                                            id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtDeciderId}" disabled="true"
                                                            id="txtDeciderId" style="left: 166px; top: 46px; position: absolute"/>
                                                        <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="#{msgSu.DeciderFullName}"/>
                                                        <ice:outputLabel id="deciderPosition" style="left: 408px; top: 48px; position: absolute" value="#{msgSu.DeciderPosition}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtDeciderFullName}" disabled="true"
                                                            id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute; width: 147px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtDeciderPosition}" disabled="true"
                                                            id="txtDeciderPosition" style="left: 526px; top: 46px; position: absolute"/>
                                                        <ice:selectOneMenu binding="#{Subsidy$SubsidyIndividualApprovePage.drlDecision}" id="drlDecision"
                                                            partialSubmit="true" style="height: 23px; left: 167px; top: 83px; position: absolute; width: 143px" value="#{Subsidy$SubsidyIndividualApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                            <f:selectItems id="selectDecisionAvailable" value="#{Subsidy$SubsidyIndividualApprovePage.availableDecisionsToMakeList}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:outputLabel id="lblDecision" style="left: 53px; top: 78px; position: absolute" value="#{msgSu.Decision}"/>
                                                        <ice:inputTextarea binding="#{Subsidy$SubsidyIndividualApprovePage.txtaDeciderComment}"
                                                            id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                        <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="#{msgSu.comment}"/>
                                                        <ice:commandLink action="#{Subsidy$SubsidyIndividualApprovePage.lnkViewPrevieousDecisions_action}"
                                                            id="lnkViewPrevieousDecisions" style="left: 432px; top: 96px; position: absolute" value="View decisions made on this request"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                        style="height: 44px; margin-left: 15px; left: 20px; top: 675px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualApprovePage.btnPostDecision_action}"
                                                            actionListener="#{Subsidy$SubsidyIndividualApprovePage.btnPostDecision_processAction}"
                                                            binding="#{Subsidy$SubsidyIndividualApprovePage.btnPostDecision}" id="btnPostDecision"
                                                            style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{msgSu.Save}"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualApprovePage.btnReset_action}"
                                                            binding="#{Subsidy$SubsidyIndividualApprovePage.btnReset}" id="btnReset"
                                                            style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgSu.Reset}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequester1" layout="flow"
                                                        style="height: 156px; margin-left: 15px; left: 20px; top: 50px; position: absolute; width: 694px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblRequesterDepartment1" style="left: 48px; top: 62px; position: absolute" value="#{msgSu.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId1" style="left: 456px; top: 24px; position: absolute" value="#{msgSu.Id}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtRequesterDepartment1}" disabled="true"
                                                            id="txtRequesterDepartment1" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtRequesterId1}" disabled="true"
                                                            id="txtRequesterId1" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                        <ice:outputLabel id="lblRequsterFullName1" style="left: 48px; top: 24px; position: absolute" value="#{msgSu.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition1" style="left: 48px; top: 96px; position: absolute" value="#{msgSu.Position}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtRequesterPosition1}" disabled="true"
                                                            id="txtRequesterPosition1" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtRequesterFullName1}" disabled="true"
                                                            id="txtRequesterFullName1" style="left: 166px; top: 22px; position: absolute; width: 215px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutRequestInfo1" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 219px; margin-left: 15px; left: 20px; top: 225px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblTerminationType1"
                                                            style="left: 384px; top: 24px; position: absolute; width: 143px" value="#{msgSu.totalAmount}"/>
                                                        <ice:outputLabel id="lblAppliedDate1" style="left: 24px; top: 144px; position: absolute" value="#{msgSu.remark}"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtMonth}" disabled="true" id="txtMonth" style="left: 166px; top: 46px; position: absolute; width: 167px"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtTotalAmount}" disabled="true"
                                                            id="txtTotalAmount" style="left: 526px; top: 22px; position: absolute; width: 144px"/>
                                                        <ice:selectOneMenu binding="#{Subsidy$SubsidyIndividualApprovePage.drlLocation}" disabled="true"
                                                            id="drlLocation" partialSubmit="true"
                                                            style="left: 168px; top: 72px; position: absolute; width: 167px" value="#{Subsidy$SubsidyIndividualRequestPage.selectObjectOfTerminationCatagory.selectedObject}">
                                                            <f:selectItems id="selectOneMenu1selectItems1" value="#{Subsidy$SubsidyIndividualRequestPage.subsidyLocation}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:inputTextarea binding="#{Subsidy$SubsidyIndividualApprovePage.txtRemark}" disabled="true"
                                                            id="txtRemark" style="left: 166px; top: 142px; position: absolute; width: 287px"/>
                                                        <ice:outputLabel id="lblDescription1" style="left: 24px; top: 48px; position: absolute" value="#{msgSu.currentMonth}"/>
                                                        <ice:outputLabel id="lblTerminationCatagory1" style="left: 24px; top: 72px; position: absolute" value="#{msgSu.location}"/>
                                                        <ice:outputLabel id="lblPaidSlary1" rendered="false" style="left: 408px; top: 120px; position: absolute" value="Penality Payment"/>
                                                        <ice:commandButton action="#{Subsidy$SubsidyIndividualRequestPage.btnCalculatePenality_action}"
                                                            id="btnCalculatePenality1" rendered="false"
                                                            style="left: 168px; top: 162px; position: absolute; width: 191px" value="Claculate Penality Payment"/>
                                                        <ice:inputText disabled="true" id="txtPenality1" rendered="false" style="left: 526px; top: 118px; position: absolute"/>
                                                        <ice:selectBooleanCheckbox id="chksuccesisor1" partialSubmit="true" rendered="false"
                                                            style="position: absolute; left: 96px; top: 24px"
                                                            value="#{Subsidy$SubsidyIndividualRequestPage.selectBooleanCheckbox1Bean.selectedBoolean}" valueChangeListener="#{Subsidy$SubsidyIndividualApprovePage.chksuccesisor_processValueChange}"/>
                                                        <ice:outputLabel id="lblSuccesior1" rendered="false" style="left: 144px; top: 24px; position: absolute" value="Does the Terminator has a Succesiosor?"/>
                                                        <ice:inputText binding="#{Subsidy$SubsidyIndividualApprovePage.txtdocumnet}" disabled="true"
                                                            id="txtdocumnet" style="left: 166px; top: 94px; position: absolute; width: 167px"/>
                                                        <ice:outputLabel id="lblTerminationCatagory2"
                                                            style="left: 24px; top: 96px; position: absolute; width: 119px" value="#{msgSu.document}"/>
                                                        <ice:inputText action="#{Subsidy$SubsidyIndividualApprovePage.txtAppliedDate_action}"
                                                            binding="#{Subsidy$SubsidyIndividualApprovePage.txtAppliedDate}" disabled="true" id="txtAppliedDate" style="left: 166px; top: 22px; position: absolute; width: 167px"/>
                                                        <ice:outputLabel id="lblDescription2" style="left: 24px; top: 24px; position: absolute" value="#{msgSu.appliedDate}"/>
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
                                                href="http://www.Bunna.com" style="text-decoration:none;color:orange">Bunna International Bank |
Information System Department |Software Division.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Bunna Bank Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupMessage" style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Subsidy$SubsidyIndividualApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Subsidy$SubsidyIndividualApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Subsidy$SubsidyIndividualApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="Bunna HRMS - View request status "/>
                                    <ice:commandLink action="#{Subsidy$SubsidyIndividualApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Subsidy$SubsidyIndividualApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
