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
                <title>Education Post Payment Request</title>
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
                    function EducationPaymentRequestPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1300" id="img" src="../resources/images/WholePageBG.png" width="1306"/>
                        <ice:panelBorder height="1300" id="whole_page" renderCenter="#{Education$EducationPostPaymentRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$EducationPostPaymentRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$EducationPostPaymentRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$EducationPostPaymentRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$EducationPostPaymentRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1100">
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
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px; left:0px; position:relative; width:100%;  -rave-layout: grid" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.lnkEducationRequest_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkEducationRequest}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$EducationPostPaymentRequestPage.lnkEducationPaymentRequest_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkEducationPaymentRequest}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.lnkEducationApprove_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkEducationApprove}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$EducationPostPaymentRequestPage.lnkEducationPaymentApprove_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkEducationPaymentApprove}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$EducationPostPaymentRequestPage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkChangeiNstitutionReq}"
                                                                id="lnkChangeiNstitutionReq" style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkChangeInstApprove}"
                                                                id="lnkChangeInstApprove" style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.lnkInstRegistration_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkInstRegistration}"
                                                                id="lnkInstRegistration" style="color:#306682;font-weight:bold" value="Institution Registration"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Status" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header">
                                                        <ice:outputText id="lblStatus" value="Pending"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoard" width="100%">
                                                    <ice:panelGroup id="status_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Education$EducationPostPaymentRequestPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationPostPaymentRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$EducationPostPaymentRequestPage.pendingRequestList}"/>
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
                                                    <ice:panelGroup id="History_Group" style="left:-5px;margin: -5px -5px -5px -10px;padding: 7px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="HistoryStatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox id="selectMyHistoryLists" partialSubmit="true" size="6"
                                                                style="height: 180px; width: 190px"
                                                                value="#{Education$EducationPostPaymentRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$EducationPostPaymentRequestPage.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$EducationPostPaymentRequestPage.page_display_processMyEvent}" id="page_display" style="height: 1300px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 600px; left: 35px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1300px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Education Post Payment Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1290px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$EducationPostPaymentRequestPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1250px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 1250px; left: 11px; top: 6px; position: absolute; width: 784px">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 187px; margin-left: 15px; left: 11px; top: 26px; position: absolute; width: 699px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectInputText
                                                                action="#{Education$EducationPostPaymentRequestPage.txtRequesterFullName_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.txtRequesterFullName}"
                                                                id="txtRequesterFullName" immediate="true" listValue="#{ApplicationBean1.list}"
                                                                listVar="employeeList" partialSubmit="true" rows="10"
                                                                style="left: 192px; top: 48px; position: absolute; z-index: 100"
                                                                valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                                <f:facet name="selectInputText">
                                                                    <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                        <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                        <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                    </ice:panelGrid>
                                                                </f:facet>
                                                            </ice:selectInputText>
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgse.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 24px; top: 72px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 456px; top: 48px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 190px; top: 70px; position: absolute; width: 441px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtRequesterId}"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 46px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 24px; top: 48px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 24px; top: 96px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtRequesterPosition}"
                                                                disabled="true" id="txtRequesterPosition" style="left: 190px; top: 94px; position: absolute; width: 441px"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnSearchRequester_action}"
                                                                actionListener="#{Education$EducationPostPaymentRequestPage.btnSearchRequester_processAction}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif" style="left: 624px; top: 48px; position: absolute"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel1"
                                                                style="left: 24px; top: 120px; position: absolute; text-align: left; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtlblRequesterEdLevel}"
                                                                disabled="true" id="txtlblRequesterEdLevel" style="left: 190px; top: 118px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtlblRequesterProgramName}"
                                                                disabled="true" id="txtlblRequesterProgramName" style="left: 190px; top: 142px; position: absolute; width: 239px"/>
                                                            <ice:outputLabel id="lblRequesterProgramName1"
                                                                style="left: 24px; top: 144px; position: absolute; text-align: left; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                                infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 480px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                                id="message2" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 408px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterProgramName"
                                                                id="message3" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 432px; top: 144px; position: absolute; width: 69px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterEdLevel"
                                                                id="message4" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 432px; top: 120px; position: absolute; width: 69px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                                id="message5" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 624px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                                id="message6" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 624px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution" layout="flow"
                                                            style="height: 149px; margin-left: 15px; left: 9px; top: 240px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblInstitutionName"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblProgramName"
                                                                style="font-size: 10px; left: 336px; top: 24px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:outputLabel id="lblEducationLevel"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblEducreqestID}"
                                                                id="lblEducreqestID" rendered="false" style="height: 19px; left: 650px; top: 0px; position: absolute"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtLevel}" disabled="true"
                                                                id="txtLevel" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 142px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtInstitName}" disabled="true"
                                                                id="txtInstitName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 142px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtProgName}" disabled="true"
                                                                id="txtProgName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 502px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblDocumentReference"
                                                                style="font-size: 10px; left: 336px; top: 48px; position: absolute; width: 153px" value="#{msgse.PermissioEducationdocNum}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtDocreferenceNum}"
                                                                disabled="true" id="txtDocreferenceNum" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 502px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtGrade}" disabled="true"
                                                                id="txtGrade" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 23px; left: 142px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblGrade1"
                                                                style="font-size: 10px; height: 17px; left: 24px; top: 72px; position: absolute" value="#{msgse.LevelofEducation}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblInstitPrevId}"
                                                                id="lblInstitPrevId" rendered="false" style="height: 17px; left: 0px; top: 0px; position: absolute; width: 69px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputPaymentRequest" layout="flow"
                                                            style="height: 765px; margin-left: 15px; left: 9px; top: 408px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblIssueDate"
                                                                style="font-size: 10px; left: 336px; top: 48px; position: absolute" value="#{msgse.Issuedate}"/>
                                                            <ice:outputLabel id="lblAppliedDate"
                                                                style="font-size: 10px; left: 336px; top: 24px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblAdminstrativeCost}"
                                                                id="lblAdminstrativeCost" style="font-size: 10px; left: 24px; top: 120px; position: absolute" value="#{msgse.AdminstrativeCost}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblAcademicYear}"
                                                                id="lblAcademicYear" style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Academicyear}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblSemesterOrTerm}"
                                                                id="lblSemesterOrTerm" style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.Semester}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblUnitCost}" id="lblUnitCost"
                                                                style="font-size: 10px; left: 24px; top: 144px; position: absolute" value="#{msgse.Cost}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber"
                                                                style="font-size: 10px; left: 336px; top: 72px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblDocumentRecieptNumber"
                                                                style="font-size: 10px; left: 24px; top: 80px; position: absolute; positionfont-size: 10.0px" value="#{msgse.Receiptnumber}"/>
                                                            <ice:outputLabel id="lblRemark" style="font-size: 10px; left: 336px; top: 96px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtIssueDate}" disabled="true"
                                                                id="txtIssueDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 440px; top: 50px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 440px; top: 24px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtUnitCost}" id="txtUnitCost" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 147px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtDocumentReferenceNumber}"
                                                                id="txtDocumentReferenceNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 440px; top: 76px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtReciptNumber}"
                                                                id="txtReciptNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 85px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtAcademicYear}"
                                                                disabled="true" id="txtAcademicYear" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtSemesterOrTerm}"
                                                                id="txtSemesterOrTerm" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 50px; position: absolute; width: 155px"/>
                                                            <ice:inputTextarea binding="#{Education$EducationPostPaymentRequestPage.txtRemark}" id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 77px; left: 440px; top: 102px; position: absolute; width: 233px"/>
                                                            <ice:commandButton
                                                                action="#{Education$EducationPostPaymentRequestPage.btnCalendarSatartDate_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnCalendarSatartDate}"
                                                                id="btnCalendarSatartDate" image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 598px; top: 52px; position: absolute" value="submit"/>
                                                            <ice:commandLink
                                                                action="#{Education$EducationPostPaymentRequestPage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 480px; top: 720px; position: absolute; width: 200px" value="View status of  this request"/>
                                                            <ice:selectInputDate binding="#{Education$EducationPostPaymentRequestPage.calStartDate}"
                                                                id="calStartDate" rendered="false"
                                                                style="left: 450px; top: 75px; position: absolute; height:212px; width: 190px; z-index:100"
                                                                value="#{Education$EducationPostPaymentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$EducationPostPaymentRequestPage.calAppliedDate}"
                                                                id="calAppliedDate" rendered="false"
                                                                style="left: 50px; top: 100px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$EducationPostPaymentRequestPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.calAppliedDate_processValueChange}"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationPostPaymentRequestPage.drlAdminstrativeCost}"
                                                                id="drlAdminstrativeCost" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 118px; position: absolute; width: 155px" valueChangeListener="#{Education$EducationPostPaymentRequestPage.drlAdminstrativeCost_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems2" value="#{Education$EducationPostPaymentRequestPage.adminstrativeCosts}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:panelLayout id="pnlLayoutButtons1" layout="flow"
                                                                style="height: 125px; margin-left: 15px; left: 9px; top: 240px; overflow: auto; position: absolute; width: 647px; -rave-layout: grid" styleClass="insideContainerMain">
                                                                <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblTutationFee}"
                                                                    id="lblTutationFee" rendered="false"
                                                                    style="height: 19px; left: 234px; top: 0px; position: absolute" value="Total Cost Is"/>
                                                                <ice:dataTable binding="#{Education$EducationPostPaymentRequestPage.dataAdminstrativeCost}"
                                                                    id="dataAdminstrativeCost"
                                                                    style="height: 8px; left: 16px; top: 16px; position: absolute; width: 600px"
                                                                    value="#{Education$EducationPostPaymentRequestPage.adminstrativeCostLists}" var="currentRow">
                                                                    <ice:column groupOn="#{currentRow['requesterId']}" id="colEmpId1" rendered="false">
                                                                        <ice:outputText id="optTxtForColumnadmoinsCostType1" value="#{currentRow['requesterId']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostType1" value="EmpID"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="coladmoinsCostType" style="width: 363px">
                                                                        <ice:outputText id="optTxtForColumnadmoinsCostType" value="#{currentRow['adminstraticeCostType']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostType" value="Adminstrative Cost Type"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colQuantity" style="width: 65px">
                                                                        <ice:outputText id="optTxtForColumnQuantity" value="#{currentRow['unitCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit" value="Cost"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column binding="#{Education$EducationPostPaymentRequestPage.coTotal}" id="coTotal" style="width: 58px">
                                                                        <ice:inputText disabled="true" id="txtcolTotal" style="" value="#{currentRow['totalCost']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextTotal" value="Total"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Education$EducationPostPaymentRequestPage.rowSelectorAdminCost_processMyEvent}"/>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                                <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnCalculate_action}"
                                                                    binding="#{Education$EducationPostPaymentRequestPage.btnCalculate}" disabled="true"
                                                                    id="btnCalculate" rendered="false"
                                                                    style="left: 494px; top: -10px; position: absolute; width: 103px" value="Calculate"/>
                                                                <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnAdd_action}"
                                                                    binding="#{Education$EducationPostPaymentRequestPage.btnAdd}" id="btnAdd"
                                                                    style="height: 25px; left: 0px; top: -10px; position: absolute; width: 103px" value="#{msgse.btnAddtoTable}"/>
                                                                <ice:inputText action="#{Education$EducationPostPaymentRequestPage.txttotalCost_action}"
                                                                    binding="#{Education$EducationPostPaymentRequestPage.txttotalCost}" disabled="true"
                                                                    id="txttotalCost" rendered="false" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 336px; top: -2px; position: absolute; width: 105px"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout binding="#{Education$EducationPostPaymentRequestPage.pnlLayoutButtons2}"
                                                                id="pnlLayoutButtons2" layout="flow"
                                                                style="height: 165px; margin-left: 15px; left: 9px; top: 552px; overflow: auto; position: absolute; width: 647px; -rave-layout: grid" styleClass="insideContainerMain">
                                                                <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnAddCourse_action}"
                                                                    binding="#{Education$EducationPostPaymentRequestPage.btnAddCourse}" id="btnAddCourse"
                                                                    style="height: 25px; left: 0px; top: -10px; position: absolute; width: 103px" value="#{msgse.btnAddtoTable}"/>
                                                                <ice:dataTable binding="#{Education$EducationPostPaymentRequestPage.dataCourse}" id="dataCourse"
                                                                    style="height: 8px; left: 16px; top: 16px; position: absolute; width: 600px"
                                                                    value="#{Education$EducationPostPaymentRequestPage.courseTakingList}" var="currentRow">
                                                                    <ice:column groupOn="#{currentRow['academicYear']}" id="colAcadamic" style="width: 207px">
                                                                        <ice:outputText id="optTxtForColumnQuantity5" value="#{currentRow['academicYear']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit5" value="Acadamic Year"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorOverTime1" preStyleOnSelection="true"
                                                                            selectionListener="#{Education$EducationPostPaymentRequestPage.rowSelectorCourse_processMyEvent}" value="#{currentRow['selected']}"/>
                                                                    </ice:column>
                                                                    <ice:column groupOn="#{currentRow['semesterOrTerm']}" id="colCourseSemister" style="width: 207px">
                                                                        <ice:outputText id="optTxtForColumnQuantity2" value="#{currentRow['semesterOrTerm']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit2" value="semesterOrTerm"/>
                                                                        </f:facet>
                                                                        <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Education$EducationPostPaymentRequestPage.rowSelectorCourse_processMyEvent}"/>
                                                                    </ice:column>
                                                                    <ice:column id="colCoursecredithr" style="width: 259px">
                                                                        <ice:outputText id="optTxtForColumnUnitCost1" value="#{currentRow['courseCode']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextUnitCost1" value="Course Code"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCoursCode" style="width: 65px">
                                                                        <ice:outputText id="optTxtForColumnQuantity1" value="#{currentRow['creditHr']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit1" value="Credit Hour"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCoursegrade" style="width: 207px">
                                                                        <ice:inputText id="optTxtForColumnQuantity4" value="#{currentRow['gradept']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit4" value="Grade Pt"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCourseCGPA" style="width: 207px">
                                                                        <ice:inputText id="optTxtForColumnQuantity3" value="#{currentRow['cumlativeGPA']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextQuantit3" value="CGPA"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colCourseEmpId" rendered="false">
                                                                        <ice:outputText id="optTxtForColumnadmoinsCostType2" value="#{currentRow['requesterId']}"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextadmoinsCostType2" value="EmpID"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colEdit">
                                                                        <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.cmdLnkOk_action}"
                                                                            binding="#{Education$EducationPostPaymentRequestPage.cmdLnkOk}" id="cmdLnkOk"
                                                                            rendered="#{currentRow['selected']}" value="Ok"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextEdit" value="Edit"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                    <ice:column id="colRemove">
                                                                        <ice:commandLink
                                                                            action="#{Education$EducationPostPaymentRequestPage.cmdLnkRemove_action}"
                                                                            binding="#{Education$EducationPostPaymentRequestPage.cmdLnkRemove}"
                                                                            id="cmdLnkRemove" rendered="#{currentRow['selected']}" value="Remove"/>
                                                                        <f:facet name="header">
                                                                            <ice:outputText id="headerTextRemove" value="Remove"/>
                                                                        </f:facet>
                                                                    </ice:column>
                                                                </ice:dataTable>
                                                            </ice:panelLayout>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblCourseCode}"
                                                                id="lblCourseCode" style="font-size: 10px; left: 24px; top: 432px; position: absolute" value="#{msgse.Coursecode}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblCreditHour}"
                                                                id="lblCreditHour" style="font-size: 10px; left: 24px; top: 456px; position: absolute" value="#{msgse.CreditHour}"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtCreditHour}"
                                                                id="txtCreditHour" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 454px; position: absolute; width: 167px"/>
                                                            <ice:inputText binding="#{Education$EducationPostPaymentRequestPage.txtCourseCode}"
                                                                id="txtCourseCode" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 430px; position: absolute; width: 167px"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblCGPA}" id="lblCGPA"
                                                                style="font-size: 10px; left: 24px; top: 480px; position: absolute" value="#{msgse.CGPA}"/>
                                                            <ice:inputText action="#{Education$EducationPostPaymentRequestPage.txttotalCost_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.txtCGPA}" id="txtCGPA" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 478px; position: absolute; width: 167px"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblGrade}" id="lblGrade"
                                                                style="font-size: 10px; left: 24px; top: 504px; position: absolute" value="#{msgse.Grade}"/>
                                                            <ice:inputText action="#{Education$EducationPostPaymentRequestPage.txttotalCost_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.txtgrade}" id="txtgrade" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 502px; position: absolute; width: 167px"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnAcadamicYear_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnAcadamicYear}" id="btnAcadamicYear"
                                                                image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 264px; top: 24px; position: absolute" value="submit"/>
                                                            <ice:selectInputDate binding="#{Education$EducationPostPaymentRequestPage.calAcadamicYear}"
                                                                id="calAcadamicYear" rendered="false"
                                                                style="left: 50px; top: 50px; position: absolute; height:212px; width: 190px; z-index:100"
                                                                value="#{Education$EducationPostPaymentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.calAcadamicYear_processValueChange}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblOption}" id="lblOption"
                                                                style="font-size: 10px; left: 120px; top: 384px; position: absolute" value="#{msgse.IscourseRegistered}"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnClickHere_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnClickHere}" id="btnClickHere"
                                                                rendered="false" style="height: 24px; left: 240px; top: 374px; position: absolute; width: 95px" value="Click Here"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationPostPaymentRequestPage.chkPostpay}"
                                                                disabled="true" id="chkPostpay" partialSubmit="true"
                                                                style="left: 96px; top: 384px; position: absolute"
                                                                validator="#{Education$EducationPostPaymentRequestPage.chkPostpay_validate}"
                                                                value="#{Education$EducationPostPaymentRequestPage.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.chkPostpay_processValueChange}"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationPostPaymentRequestPage.drlResultType}"
                                                                id="drlResultType" partialSubmit="true"
                                                                style="left: 478px; top: 430px; position: absolute; width: 167px"
                                                                value="#{Education$EducationPostPaymentRequestPage.defaultSelectedData11.selectedObject}" valueChangeListener="#{Education$EducationPostPaymentRequestPage.drlResultType_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Education$EducationPostPaymentRequestPage.resultType}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblResult}" id="lblResult"
                                                                style="font-size: 10px; left: 360px; top: 432px; position: absolute" value="#{msgse.SelectyourResult}"/>
                                                            <ice:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblScore}" id="lblScore"
                                                                style="font-size: 10px; left: 360px; top: 456px; position: absolute" value="#{msgse.Score}"/>
                                                            <ice:inputText action="#{Education$EducationPostPaymentRequestPage.txttotalCost_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.txtScore}" id="txtScore" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 478px; top: 454px; position: absolute; width: 167px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAppliedDate" id="message7"
                                                                infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 648px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtIssueDate" id="message8"
                                                                infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 648px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocumentReferenceNumber"
                                                                id="message9" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 648px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAcademicYear"
                                                                id="message10" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 288px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtSemesterOrTerm"
                                                                id="message11" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 288px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtReciptNumber"
                                                                id="message12" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 288px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlAdminstrativeCost"
                                                                id="message13" infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 288px; top: 120px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUnitCost" id="message14"
                                                                infoClass="infoMessage" showDetail="false"
                                                                style="height: 20px; left: 288px; top: 144px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtCourseCode" id="message15"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 432px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtCreditHour" id="message16"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 456px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtCGPA" id="message17"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 480px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtgrade" id="message18"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 504px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlResultType" id="message19"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 648px; top: 432px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtScore" id="message20"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 648px; top: 456px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.lnkViewCourseLists_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.lnkViewCourseLists}"
                                                                id="lnkViewCourseLists" rendered="false"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; height: 21px; left: 24px; top: 720px; position: absolute; width: 200px" value="Show All List Of All Courses"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                            style="height: 25px; margin-left: 15px; left: 9px; top: 1200px; overflow: auto; position: absolute; width: 693px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnSaveOrUpdate_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 192px; top: -10px; position: absolute; width: 71px" value="#{Education$EducationPostPaymentRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnReset_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnReset}" id="btnReset"
                                                                style="left: 312px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnDelete_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnDelete}" id="btnDelete"
                                                                style="left: 432px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnDelete}"/>
                                                            <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnNew_action}"
                                                                binding="#{Education$EducationPostPaymentRequestPage.btnNew}" id="btnNew" rendered="false"
                                                                style="height: 23px; left: 120px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnNew}"/>
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
                                                href="http://www.google.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |information |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPostPaymentRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationPostPaymentRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationPostPaymentRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationPostPaymentRequestPage.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPostPaymentRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$EducationPostPaymentRequestPage.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPostPaymentRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$EducationPostPaymentRequestPage.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationPostPaymentRequestPage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup binding="#{Education$EducationPostPaymentRequestPage.pnlPopUpClearingDepSetting1}" clientOnly="true" draggable="true"
                            id="pnlPopUpClearingDepSetting1" modal="true" rendered="false" style="display: block; height: 323px; left: 97px; top: 226px; position: absolute; width: 634px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpResignTye1" styleClass="icePnlGrp icePnlGrp popupHeaderWrapper">
                                    <ice:outputText id="popUpResignTyeTitle1" style="width:400px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - List Of Taken Course"/>
                                    <ice:commandButton action="#{Education$EducationPostPaymentRequestPage.modalPnlCloseBtn1_action}"
                                        actionListener="#{Education$EducationPostPaymentRequestPage.modalPnlCloseBtn_processAction}" alt="Close"
                                        id="modalPnlCloseBtn1" image="/resources/images/close.gif" style="left: 614px; top: 2px; position: absolute"
                                        title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="lblSelected1" style="display: block; height: 256px; position: relative; width: 586" styleClass="icePnlGrp icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 234px; left: 22px; top: 13px; overflow: auto; position: absolute; width: 552px">
                                        <ice:dataTable id="tblClearingDep1" scrollFooter="true" scrollHeight="true" sortAscending="true"
                                            style="left: 5px; right: 5px; top: 5px; position: absolute"
                                            value="#{Education$EducationPostPaymentRequestPage.availableCourses}" var="currentRow" width="541">
                                            <ice:column groupOn="#{currentRow['institutionName']}" id="column1" style="width: 50px">
                                                <ice:outputText id="outputText1" value="#{currentRow['institutionName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText2" value="Name Of Institution"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2" style="width: 191px">
                                                <ice:outputText id="outputText3" value="#{currentRow['academicYear']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText4" value="Acadamic Year"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3" style="width: 191px">
                                                <ice:outputText id="outputText5" value="#{currentRow['courseCode']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText6" value="Course Code"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column4" style="width: 191px">
                                                <ice:outputText id="outputText7" value="#{currentRow['creditHr']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText8" value="Credit Hour"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column5" style="width: 191px">
                                                <ice:outputText id="outputText9" value="#{currentRow['gradept']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText10" value="Grade Pt"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:inputHidden id="lblHResignationTypeID1"/>
                                    <ice:outputLabel id="outputLabel1"/>
                                    <ice:inputHidden id="inputHidden1" value="selected"/>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
