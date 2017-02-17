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
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Decision on Document Request</title>
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
                    function EyeWitnessesPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1000px" id="img" src="../resources/images/"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{DocumentRequest$DocumentApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{DocumentRequest$DocumentApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{DocumentRequest$DocumentApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{DocumentRequest$DocumentApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{DocumentRequest$DocumentApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px; ">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200,200,200); height:770px;top:15px left: 3px;top:25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:470px; left: 3px;top:2px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{DocumentRequest$DocumentApprovePage.lnkDocumentRequest_action}"
                                                                id="lnkDocumentRequest" style="color:#306682;font-weight:bold" value="To Document Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{DocumentRequest$DocumentApprovePage.lnkDocumentReturn_action}"
                                                                id="lnkDocumentReturn" style="color:#306682;font-weight:bold" value="Return Document"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Pending" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Pending">
                                                        <ice:outputText id="lblStatusPending" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardPending" width="100%">
                                                    <ice:panelGroup id="status_Group_Pending" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerPending" style="height: 125px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectPendingRequestLists" partialSubmit="true" size="6"
                                                                style="height: 100px; width: 190px"
                                                                value="#{DocumentRequest$DocumentRequestPage.selectedRequestFromMyRequest.selectedObject}" valueChangeListener="#{DocumentRequest$DocumentApprovePage.selectPendingRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{DocumentRequest$DocumentRequestPage.myPendingDocumentRequests}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_History" style="border-style: none; height: 311px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_History">
                                                        <ice:outputText id="lblStatusHistory" value="History"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardHistory" width="100%">
                                                    <ice:panelGroup id="status_Group_History" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:120px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerHistory" style="height: 261px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox id="selectHistoryDocRequest" partialSubmit="true" size="6"
                                                                style="height: 90px; width: 190px"
                                                                value="#{DocumentRequest$DocumentApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{DocumentRequest$DocumentApprovePage.selectHistoryDocRequest_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsHistory" value="#{DocumentRequest$DocumentApprovePage.requestListsHistory}"/>
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
                                <ice:panelGroup id="page_display" style="height:790px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 775px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 760px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Process Document Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{DocumentRequest$DocumentApprovePage.pnProfile}" id="pnProfile" style="height: 770px; width: 100%">
                                                    <ice:panelGroup binding="#{DocumentRequest$DocumentApprovePage.pnlGrpPowerDeligationContent}"
                                                        dragListener="#{DocumentRequest$DocumentApprovePage.pnlGrpPowerDeligationContent_processMyEvent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 686px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutRequester"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 150px; margin-left: 15px; left: 20px; top: 30px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 166px; top: 22px; position: absolute; width: 239px"/>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="Requester"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 174px;  left: 20px; top :450px; margin-left: 15px; overflow: auto; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDeciderDepartment" style="left: 48px; top: 24px; position: absolute" value="DeciderDepartment"/>
                                                            <ice:outputLabel id="lblDeciderId" style="left: 48px; top: 55px; position: absolute" value="DeciderId"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtDeciderDepartment}" disabled="true"
                                                                id="txtDeciderDepartment" style="left: 166px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtDeciderId}" disabled="true"
                                                                id="txtDeciderId" style="left: 166px; top: 55px; position: absolute"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 408px; top: 24px; position: absolute" value="DeciderFullName"/>
                                                            <ice:outputLabel id="deciderPosition" style="left: 408px; top: 55px; position: absolute" value="DeciderPosition"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtDeciderFullName}" disabled="true"
                                                                id="txtDeciderFullName" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtDeciderPosition}" disabled="true"
                                                                id="txtDeciderPosition" style="left: 526px; top: 55px; position: absolute"/>
                                                            <ice:selectOneMenu binding="#{DocumentRequest$DocumentApprovePage.drlDecision}" id="drlDecision"
                                                                partialSubmit="true"
                                                                style="height: 23px; left: 166px; top: 85px; position: absolute; width: 143px" value="#{DocumentRequest$DocumentApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                                <f:selectItems id="selectDecisionAvailable" value="#{DocumentRequest$DocumentApprovePage.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblDecision" style="left: 48px; top: 82px; position: absolute" value="Decision"/>
                                                            <ice:inputTextarea binding="#{DocumentRequest$DocumentApprovePage.txtaDeciderComment}"
                                                                id="txtaDeciderComment" style="left: 166px; top: 118px; position: absolute; width: 496px"/>
                                                            <ice:outputLabel id="lblDeciderComment" style="left: 48px; top: 120px; position: absolute" value="Comment"/>
                                                            <ice:commandButton id="btnSearchDecider" rendered="false"
                                                                style="left: 319px; top: 38px; position: absolute" value="Change"/>
                                                            <ice:commandLink action="#{DocumentRequest$DocumentApprovePage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{DocumentRequest$DocumentApprovePage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions" style="color:#306682;font-weight:bold" value="ViewPrevieousDecisions"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 640px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnPostDecision_action}"
                                                                binding="#{DocumentRequest$DocumentApprovePage.btnPostDecision}" id="btnPostDecision"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{PowerDeligation$PowerDeligationRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutRequestAttributes"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 233px; margin-left: 15px; left: 20px; top: 200px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDocumentType" style="left: 48px; top: 24px; position: absolute" value="DocumentType"/>
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 408px; top: 24px; position: absolute" value="AppliedDate"/>
                                                            <ice:outputLabel id="lblRefererenceNumber" style="left: 48px; top: 48px; position: absolute" value="Ref.Number"/>
                                                            <ice:selectOneMenu binding="#{DocumentRequest$DocumentApprovePage.drlDocumentCatagory}"
                                                                disabled="true" id="drlDocumentCatagory" partialSubmit="true"
                                                                style="left: 166px; top: 22px; position: absolute; width: 143px" value="#{DocumentRequest$DocumentRequestPage.defaultSelectedData1.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{DocumentRequest$DocumentRequestPage.documentCatagories}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtDocReferenceNumber}"
                                                                disabled="true" id="txtDocReferenceNumber" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:outputLabel id="lblIsueeDate" style="left: 408px; top: 55px; position: absolute" value="IsueeDate"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentApprovePage.txtIsueeDate}" disabled="true"
                                                                id="txtIsueeDate" style="left: 526px; top: 55px; position: absolute"/>
                                                            <ice:inputTextarea binding="#{DocumentRequest$DocumentApprovePage.txtaReason}" disabled="true"
                                                                id="txtaReason" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblReason" style="left: 48px; top: 96px; position: absolute" value="Reason"/>
                                                            <ice:inputTextarea binding="#{DocumentRequest$DocumentApprovePage.txtaDescription}" disabled="true"
                                                                id="txtaDescription" style="height: 49px; left: 166px; top: 166px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDescription" style="left: 46px; top: 158px; position: absolute" value="Description"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnCheckEmpHistory_action}"
                                                                id="btnCheckEmpHistory" style="left: 336px; top: 14px; position: absolute" value="Check"/>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelLayout>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="south">
                                <ice:panelGroup id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid">
                                        <jsp:directive.include file="/FOOTER.jspf"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{DocumentRequest$DocumentApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{DocumentRequest$DocumentApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{DocumentRequest$DocumentApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px" styleClass="insideContainerMain">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{DocumentRequest$DocumentApprovePage.decisionsMadeOnRequest}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentApprovePage.pnlPopupViewEmployees_History}" draggable="true"
                            id="pnlPopupViewEmployees_History" modal="true" rendered="false" style="height: 261px; left: 744px; top: 360px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions1" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader1"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnClosePopupViewPrevieousDecisions1_action}"
                                        id="btnClosePopupViewPrevieousDecisions1" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewEmpHistory" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupEmpHistoryTable"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px" styleClass="insideContainerMain">
                                        <ice:dataTable binding="#{DocumentRequest$DocumentApprovePage.dataTableEmpHistory}" id="dataTableEmpHistory"
                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{DocumentRequest$DocumentApprovePage.empExperienceModel}" var="currentRow">
                                            <ice:column id="colNumber1">
                                                <ice:outputText id="optTxtForColumnNumber1" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber1" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colJobCode">
                                                <ice:outputText id="optTxtForJobCode" value="#{currentRow['jobCode']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextJobCode" value="Job Code"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colJobDesc">
                                                <ice:outputText id="optTxtForJobDesc" value="#{currentRow['jobDesc']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerJobDesc" value="Job Description"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colRank">
                                                <ice:outputText id="optTxtForRank" value="#{currentRow['rank']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextRank" value="Rank"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colSalary">
                                                <ice:outputText id="optTxtForSalary" value="#{currentRow['salary']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextsalry" value="Salary"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colSartDate">
                                                <ice:outputText id="optTxtForSartDate" value="#{currentRow['startDate']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextSartDate" value="Start Date"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colEndDate">
                                                <ice:outputText id="optTxtForEndDate" value="#{currentRow['endDate']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEndDate" value="End Date"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentApprovePage.pnlPopupDocReturn}" draggable="true"
                            id="pnlPopupDocReturn" modal="true" rendered="false" style="height: 237px; left: 480px; top: 504px; position: absolute; width: 477px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupReturnGua" style="display: block; height: 20px; text-align: left" width="480">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader1ss"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton
                                        actionListener="#{DocumentRequest$DocumentApprovePage.btnClosePopupViewPrevieousDecisions1s_processAction}"
                                        id="btnClosePopupViewPrevieousDecisions1s" style="left: 450px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutReturnOfGuaranteeDocss" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 127px; margin-left: 15px; left: -7px; top: 55px; overflow: auto; position: absolute; width: 453px; -rave-layout: grid">
                                    <ice:commandButton action="#{DocumentRequest$DocumentApprovePage.btnUpdateChenge_action}" id="btnUpdateChenge"
                                        style="height: 30px; left: 48px; top: 62px; position: absolute; width: 110px" value="Update Change"/>
                                    <ice:selectOneRadio binding="#{DocumentRequest$DocumentApprovePage.selectOneRadioDocReturn}" id="selectOneRadioDocReturn"
                                        partialSubmit="true" style="left: 48px; top: 24px; position: absolute" value="#{DocumentRequest$DocumentApprovePage.selectOneRadio1Bean.selectedObject}">
                                        <f:selectItems id="selectOneRadio1selectItems" value="#{DocumentRequest$DocumentApprovePage.documentReturns}"/>
                                    </ice:selectOneRadio>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>