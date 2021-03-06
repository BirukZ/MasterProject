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
                <title>Document Request</title>
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
                        <ice:panelBorder id="whole_page" renderCenter="#{DocumentRequest$DocumentRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{DocumentRequest$DocumentRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{DocumentRequest$DocumentRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{DocumentRequest$DocumentRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{DocumentRequest$DocumentRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                        style="border-width: 1px; border-style: solid; border-color: rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200) rgb(200, 200, 200); height: 765px; top: 25px; position: relative; width: 98%; -rave-layout: grid" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{DocumentRequest$DocumentRequestPage.lnkDocumentApproval_action}"
                                                                id="lnkDocumentApproval" style="color:#306682;font-weight:bold" value="To Approval Page"/>
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
                                                                value="#{DocumentRequest$DocumentRequestPage.selectedRequestFromMyRequest.selectedObject}" valueChangeListener="#{DocumentRequest$DocumentRequestPage.selectPendingRequestLists_processValueChange}">
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
                                                            <ice:selectOneListbox id="selectRequestHistory" partialSubmit="true" size="6"
                                                                style="height: 100px; width: 190px"
                                                                value="#{DocumentRequest$DocumentRequestPage.selectedRequestFromMyHistory.selectedObject}" valueChangeListener="#{DocumentRequest$DocumentRequestPage.selectRequestHistory_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsHistory" value="#{DocumentRequest$DocumentRequestPage.myDocumentRequestsHistory}"/>
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
                                                <ice:outputLabel value="Document Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnlLayoutMainBody" style="height: 770px; left: 0px; top: 0px; position: absolute; width: 100%">
                                                <ice:panelLayout binding="#{DocumentRequest$DocumentRequestPage.pnProfile}" id="pnProfile" style="height: 668px; position: absolute; width: 100%">
                                                    <ice:panelGroup binding="#{DocumentRequest$DocumentRequestPage.pnlGrpPowerDeligationContent}"
                                                        id="pnlGrpPowerDeligationContent" style="height: 622px" styleClass="icePnlGrp filedset_border">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 179px; margin-left: 15px; left: 20px; top: 25px; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:selectInputText action="#{DocumentRequest$DocumentRequestPage.txtRequesterFullName_action}"
                                                                binding="#{DocumentRequest$DocumentRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                                immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList"
                                                                partialSubmit="true" rows="10" style="left: 166px; top: 22px; position: absolute" valueChangeListener="#{ApplicationBean1.updateList}">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="Requester"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 48px; top: 62px; position: absolute" value="Department"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="Id"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 166px; top: 60px; position: absolute; width: 503px"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtRequesterId}" id="txtRequesterId"
                                                                immediate="true" partialSubmit="true" style="left: 478px; top: 22px; position: absolute; width: 195px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="FullName"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 48px; top: 96px; position: absolute" value="Position"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 166px; top: 94px; position: absolute; width: 503px"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnRequesterIdSearch_action}"
                                                                id="btnRequesterIdSearch" image="/resources/images/fig_search.gif" rendered="true" style="left: 624px; top: 24px; position: absolute"/>
                                                            <ice:commandLink action="#{DocumentRequest$DocumentRequestPage.clnkExtOrg_action}" id="clnkExtOrg"
                                                                style="left: 504px; top: 144px; position: absolute" value="Document is for external body"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 44px; margin-left: 15px; left: 20px; top: 560px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnSaveOrUpdate_action}"
                                                                binding="#{DocumentRequest$DocumentRequestPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{DocumentRequest$DocumentRequestPage.newOrSaveOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnReset_action}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="Reset"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnDelete_action}"
                                                                binding="#{DocumentRequest$DocumentRequestPage.btnDelete}" disabled="true" id="btnDelete"
                                                                style="left: 456px; top: 0px; position: absolute; width: 71px" value="Delete"/>;
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayouRequestAttributes"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 318px; margin-left: 15px; left: 20px; top: 231px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDocumentType" style="left: 48px; top: 24px; position: absolute" value="DocumentType"/>
                                                            <ice:outputLabel id="lblAppliedDate" style="left: 48px; top: 48px; position: absolute" value="AppliedDate"/>
                                                            <ice:outputLabel id="lblRefererenceNumber" style="left: 408px; top: 24px; position: absolute" value="Ref.Number"/>
                                                            <ice:selectOneMenu binding="#{DocumentRequest$DocumentRequestPage.drlDocumentCatagory}"
                                                                id="drlDocumentCatagory" partialSubmit="true"
                                                                style="left: 166px; top: 22px; position: absolute; width: 143px" value="#{DocumentRequest$DocumentRequestPage.defaultSelectedData1.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{DocumentRequest$DocumentRequestPage.documentCatagories}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 166px; top: 46px; position: absolute"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtDocReferenceNumber}"
                                                                id="txtDocReferenceNumber" style="left: 526px; top: 22px; position: absolute"/>
                                                            <ice:outputLabel id="lblIsueeDate" style="left: 408px; top: 48px; position: absolute" value="IsueeDate"/>
                                                            <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.txtIsueeDate}" disabled="true"
                                                                id="txtIsueeDate" style="left: 526px; top: 46px; position: absolute"/>
                                                            <ice:inputTextarea binding="#{DocumentRequest$DocumentRequestPage.txtaReason}" id="txtaReason" style="left: 166px; top: 118px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblReason" style="left: 48px; top: 120px; position: absolute" value="Reason"/>
                                                            <ice:inputTextarea binding="#{DocumentRequest$DocumentRequestPage.txtaDescription}"
                                                                id="txtaDescription" style="left: 166px; top: 190px; position: absolute; width: 503px"/>
                                                            <ice:outputLabel id="lblDescription" style="left: 49px; top: 182px; position: absolute" value="Description"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnAppliedDate_action}"
                                                                id="btnAppliedDate" image="/resources/images/cal_icon.JPG" immediate="true" style="left: 312px; top: 48px; position: absolute"/>
                                                            <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnIsueeDate_action}"
                                                                id="btnIsueeDate" image="/resources/images/cal_icon.JPG" immediate="true" style="left: 672px; top: 48px; position: absolute"/>
                                                            <ice:selectInputDate binding="#{DocumentRequest$DocumentRequestPage.calAppliedDate}"
                                                                id="calAppliedDate" rendered="false"
                                                                style="left: 150px; top: 20px; position: absolute; height:212px; width: 190px"
                                                                value="#{DocumentRequest$DocumentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{DocumentRequest$DocumentRequestPage.calAppliedDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{DocumentRequest$DocumentRequestPage.calIsueeDate}" id="calIsueeDate"
                                                                rendered="false" style="left: 500px; top: 20px; position: absolute; height:212px; width: 190px"
                                                                value="#{DocumentRequest$DocumentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{DocumentRequest$DocumentRequestPage.calIsueeDate_processValueChange}"/>
                                                            <ice:commandLink action="#{DocumentRequest$DocumentRequestPage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{DocumentRequest$DocumentRequestPage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 504px; top: 264px; position: absolute" value="View status of this request"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{DocumentRequest$DocumentRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{DocumentRequest$DocumentRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{DocumentRequest$DocumentRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{DocumentRequest$DocumentRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{DocumentRequest$DocumentRequestPage.decisionsMadeOnRequest}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentRequestPage.popupConfirmDelete}" draggable="true"
                            id="popupConfirmDelete" modal="true" rendered="false" style="display: block; height: 156px; left: 97px; top: 226px; position: absolute; width: 623px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsg" style="display: block; height: 20px; width: 500px">
                                    <ice:outputText id="lblemployeePopUpMsgTitle" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="panelGroupemployeePopUpMsgBody" style="display: block; height: 94px; position: relative; width:586px">
                                    <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnPoppupDeleteCancel_action}" id="btnPoppupDeleteCancel"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="left: 510px; top: 60px; position: absolute; visibility: visible; width: 70px" value="No" visible="true"/>
                                    <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnPoppupDeleteAgree_action}" id="btnPoppupDeleteAgree"
                                        immediate="true" partialSubmit="true" rendered="true"
                                        style="background-position: 0 100%; background-repeat: no-repeat; left: 430px; top: 60px; position: absolute; visibility: visible; width: 70px"
                                        value="Yes" visible="true"/>
                                    <ice:outputText id="lblConfirmDelete" style="font-size: 18px; left: 95px; top: 30px; position: absolute; width: 496px" value="Are You Sure to Dlete This Request?"/>
                                    <ice:panelLayout id="panelLayoutImageHolderemployee" rendered="true"
                                        style=" width:62; height:56px; left: 10px; top: 15px; position: absolute;" styleClass="popUpBgimage" visible="true"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{DocumentRequest$DocumentRequestPage.popupExtOrganization}" draggable="true"
                            id="popupExtOrganization" modal="true" rendered="false" style="display: block; height: 597px; left: 168px; top: 264px; position: absolute; width: 717px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridemployeePopUpMsgss" style="display: block; height: 20px" width="480">
                                    <ice:outputText id="lblemployeePopUpMsgTitlesss" value="BUNNA INTERNATIONAL BANK Human Resource Management System"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutReturnOfGuaranteeDocss" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 525px; margin-left: 15px; left: 10px; top: 25px; overflow: auto; position: absolute; width: 669px; -rave-layout: grid">
                                    <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnUpdateChenge_action}" id="btnUpdateChenge"
                                        style="height: 30px; left: 96px; top: 470px; position: absolute; width: 110px" value="Save Changes"/>
                                    <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.itxtNo}" id="itxtNo" style="height: 23px; left: 46px; top: 46px; position: absolute; width: 191px"/>
                                    <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.itxtOrgName}" id="itxtOrgName" style="height: 23px; left: 46px; top: 118px; position: absolute; width: 191px"/>
                                    <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.itxtPageNo}" id="itxtPageNo" style="height: 23px; left: 46px; top: 190px; position: absolute; width: 191px"/>
                                    <ice:outputLabel id="outputLabel1" style="left: 48px; top: 24px; position: absolute" value="No"/>
                                    <ice:outputLabel id="outputLabel2" style="left: 48px; top: 96px; position: absolute" value="Requesting Organization Name"/>
                                    <ice:outputLabel id="outputLabel3" style="left: 48px; top: 168px; position: absolute" value="Pages"/>
                                    <ice:commandButton action="#{DocumentRequest$DocumentRequestPage.btnCancel_action}" id="btnCancel"
                                        style="height: 29px; left: 264px; top: 470px; position: absolute; width: 73px" value="Cancel"/>
                                    <ice:inputTextarea binding="#{DocumentRequest$DocumentRequestPage.itxtaPurpose}" id="itxtaPurpose" style="height: 71px; left: 46px; top: 262px; position: absolute; width: 191px"/>
                                    <ice:outputLabel id="outputLabel4" style="left: 48px; top: 240px; position: absolute" value="Purpose"/>
                                    <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.itxtLetterNo}" id="itxtLetterNo" style="height: 21px; left: 384px; top: 48px; position: absolute; width: 189px"/>
                                    <ice:inputText binding="#{DocumentRequest$DocumentRequestPage.itxtLetterDate}" id="itxtLetterDate" style="height: 21px; left: 384px; top: 120px; position: absolute; width: 189px"/>
                                    <ice:outputLabel id="outputLabel5" style="left: 384px; top: 96px; position: absolute" value="Requesting Organization Letter Date"/>
                                    <ice:outputLabel id="outputLabel6" style="left: 384px; top: 24px; position: absolute" value="Requesting Organization Letter Number"/>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
