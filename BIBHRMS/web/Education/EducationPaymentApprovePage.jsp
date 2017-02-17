<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    AFuthor     : DavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_Education" var="msgse"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title>Education Payment Request Approve</title>
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
                    function ChangeInstitutionaPRROVEPage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1464" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$EducationPaymentApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$EducationPaymentApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$EducationPaymentApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$EducationPaymentApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$EducationPaymentApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="height: 979px">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px; top:15px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 0px; top: 0px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkEducationRequest_action}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkEducationPaymentRequest_action}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkEducationApprove_action}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkEducationPaymentApprove_action}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.lnkChangeiNstitutionReq}"
                                                                id="lnkChangeiNstitutionReq" style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.lnkChangeInstApprove}"
                                                                id="lnkChangeInstApprove" style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkInstRegistration_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.lnkInstRegistration}" id="lnkInstRegistration"
                                                                style="color:#306682;font-weight:bold" value="Institution Registration"/>
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
                                                        <ice:panelLayout id="StatusContainer" style="height: 228px; left: 0px; top: 350px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Education$EducationPaymentApprovePage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 192px; width: 190px"
                                                                value="#{Education$EducationPaymentApprovePage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$EducationPaymentApprovePage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$EducationPaymentApprovePage.requestListsToBeApproved}"/>
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
                                                                value="#{Education$EducationPaymentApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$EducationPaymentApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$EducationPaymentApprovePage.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$EducationPaymentApprovePage.page_display_processMyEvent}" id="page_display" style="height: 1309px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1200px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1300px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Education Pre-Payment Request Approve "/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1273px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$EducationPaymentApprovePage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1270px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 1260px; left: 11px; top: 32px; position: absolute; width: 100%">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 179px; margin-left: 15px; left: 13px; top: 26px; position: absolute; width: 697px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRequester" style="font-size: 10px; left: 10px; top:4px; position: absolute" value="#{msgse.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment"
                                                                style="font-size: 10px;left: 24px; top: 48px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId"
                                                                style="font-size: 10px; left: 456px; top: 24px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 190px; top: 46px; position: absolute; width: 441px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtRequesterPosition}"
                                                                disabled="true" id="txtRequesterPosition" style="left: 190px; top: 70px; position: absolute; width: 441px"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel1"
                                                                style="font-size: 10px; left: 24px; top: 120px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtlblRequesterEdLevel}"
                                                                disabled="true" id="txtlblRequesterEdLevel" style="left: 214px; top: 118px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtlblRequesterProgramName}"
                                                                disabled="true" id="txtlblRequesterProgramName" style="left: 214px; top: 142px; position: absolute; width: 240px"/>
                                                            <ice:outputLabel id="lblRequesterProgramName1"
                                                                style="font-size: 10px; left: 24px; top: 144px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtRequesterFullName}"
                                                                disabled="true" id="txtRequesterFullName" immediate="true" partialSubmit="true" style="left: 190px; top: 22px; position: absolute; width: 207px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution" layout="flow"
                                                            style="height: 123px; margin-left: 15px; left: 11px; top: 234px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblInstitutionName"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtEducationProgramName}"
                                                                disabled="true" id="txtEducationProgramName" style="left: 502px; top: 22px; position: absolute; width: 154px"/>
                                                            <ice:outputLabel id="lblProgramName"
                                                                style="font-size: 10px; left: 360px; top: 24px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:outputLabel id="lblEducationLevel"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtEducationLevel}" disabled="true"
                                                                id="txtEducationLevel" style="left: 142px; top: 46px; position: absolute; width: 154px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtInstitutionName}" disabled="true"
                                                                id="txtInstitutionName" style="left: 142px; top: 22px; position: absolute; width: 154px"/>
                                                            <ice:outputLabel id="lblGrade1"
                                                                style="font-size: 10px; height: 17px; left: 24px; top: 72px; position: absolute; width: 117px" value="#{msgse.LevelofEducation}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtGrade}" disabled="true"
                                                                id="txtGrade" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 23px; left: 142px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblDocumentReference1"
                                                                style="font-size: 10px; left: 360px; top: 48px; position: absolute; text-align: left; width: 153px" value="#{msgse.PermissioEducationdocNum}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDocreferenceNum}" disabled="true"
                                                                id="txtDocreferenceNum" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 502px; top: 46px; position: absolute; width: 156px"/>
                                                            <ice:outputLabel binding="#{Education$EducationPaymentApprovePage.lblInstitPrevId}"
                                                                id="lblInstitPrevId" rendered="false" style="height: 17px; left: 0px; top: 0px; position: absolute; width: 45px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputPaymentRequest" layout="flow"
                                                            style="height: 209px; margin-left: 15px; left: 11px; top: 364px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblIssueDate"
                                                                style="font-size: 10px; left: 390px; top: 52px; position: absolute" value="#{msgse.Issuedate}"/>
                                                            <ice:outputLabel id="lblAppliedDate"
                                                                style="font-size: 10px; left: 390px; top: 26px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:outputLabel id="lblAcademicYear"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Academicyear}"/>
                                                            <ice:outputLabel id="lblSemesterOrTerm"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.Semester}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblDocumentRecieptNumber"
                                                                style="font-size: 10px; left: 26px; top: 104px; position: absolute" value="#{msgse.Receiptnumber}"/>
                                                            <ice:outputLabel id="lblRemark" style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtIssueDate}" disabled="true"
                                                                id="txtIssueDate" style="left: 502px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 502px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDocumentReferenceNumber}"
                                                                disabled="true" id="txtDocumentReferenceNumber" style="left: 142px; top: 70px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtReciptNumber}" disabled="true"
                                                                id="txtReciptNumber" style="left: 142px; top: 94px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtAcademicYear}" disabled="true"
                                                                id="txtAcademicYear" style="left: 142px; top: 22px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtSemesterOrTerm}" disabled="true"
                                                                id="txtSemesterOrTerm" style="left: 142px; top: 46px; position: absolute; width: 129px"/>
                                                            <ice:inputTextarea binding="#{Education$EducationPaymentApprovePage.txtRemark}" disabled="true"
                                                                id="txtRemark" style="height: 50px; left: 142px; top: 118px; position: absolute; width: 301px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider" layout="flow"
                                                            style="height: 253px; margin-left: 15px; left: 11px; top: 920px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDeciderDepartment" style="left: 24px; top: 48px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblDeciderId" style="left: 419px; top: 14px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDeciderDepartment1}"
                                                                disabled="true" id="txtDeciderDepartment1" style="left: 128px; top: 50px; position: absolute; width: 526px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDeciderId1}" disabled="true"
                                                                id="txtDeciderId1" style="left: 503px; top: 13px; position: absolute; width: 137px"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 24px; top: 24px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="deciderPosition" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDeciderFullName1}"
                                                                disabled="true" id="txtDeciderFullName1" style="left: 128px; top: 24px; position: absolute; width: 196px"/>
                                                            <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtDeciderPosition1}"
                                                                disabled="true" id="txtDeciderPosition1" style="left: 128px; top: 76px; position: absolute; width: 527px"/>
                                                            <ice:outputLabel id="lblDecision" style="left: 26px; top: 104px; position: absolute" value="#{msgse.Decision}"/>
                                                            <ice:inputTextarea binding="#{Education$EducationPaymentApprovePage.txtaDeciderComment}"
                                                                id="txtaDeciderComment" style="left: 118px; top: 142px; position: absolute; width: 524px"/>
                                                            <ice:outputLabel id="lblDeciderComment" style="left: 23px; top: 145px; position: absolute" value="#{msgse.Comment}"/>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 408px; top: 216px; position: absolute; width: 265px" value="View previous decisions made on this request"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationPaymentApprovePage.drlDecision}" id="drlDecision"
                                                                partialSubmit="true"
                                                                style="height: 23px; left: 128px; top: 102px; position: absolute; width: 190px" value="#{Education$EducationPaymentApprovePage.selectedObjectOneMenuDecisionType.selectedObject}">
                                                                <f:selectItems id="selectDecisionAvailable1" value="#{Education$EducationPaymentApprovePage.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlDecision" id="message1"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 336px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:commandLink action="#{Education$EducationPaymentApprovePage.lnkViewCourseLists_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.lnkViewCourseLists}" id="lnkViewCourseLists"
                                                                rendered="false"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 24px; top: 216px; position: absolute; width: 200px" value="Show List Of All Courses"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 21px; margin-left: 15px; left: 9px; top: 1180px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$EducationPaymentApprovePage.btnSaveOrUpdate_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: -10px; position: absolute; width: 71px" value="#{OverTime$OverTimeRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$EducationPaymentApprovePage.btnReset_action}"
                                                                binding="#{Education$EducationPaymentApprovePage.btnReset}" id="btnReset"
                                                                style="left: 336px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons1" layout="flow"
                                                            style="height: 127px; margin-left: 15px; left: 9px; top: 584px; overflow: auto; position: absolute; width: 699px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblTutationFee1" rendered="false"
                                                                style="height: 19px; left: 234px; top: 0px; position: absolute" value="Total Cost Is"/>
                                                            <ice:dataTable binding="#{Education$EducationPaymentApprovePage.dataAdminstrativeCost}"
                                                                id="dataAdminstrativeCost"
                                                                style="height: 8px; left: 42px; top: -10px; position: absolute; width: 600px"
                                                                value="#{Education$EducationPaymentApprovePage.adminstrativeCostLists}" var="currentRow">
                                                                <ice:column groupOn="#{currentRow['requesterId']}" id="colEmpId1" rendered="false">
                                                                    <ice:outputText id="optTxtForColumnadmoinsCostType1" value="#{currentRow['requesterId']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextadmoinsCostType1" value="EmpID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coladmoinsCostType1" style="width: 155px">
                                                                    <ice:outputText id="optTxtForColumnadmoinsCostType2" value="#{currentRow['adminstraticeCostType']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextadmoinsCostType2" value="Adminstrative Cost Type"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colUnitCost1" style="width: 66px">
                                                                    <ice:outputText id="optTxtForColumnUnitCost1" value="#{currentRow['unitCost']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextUnitCost1" value="Cost"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="coTotal1" style="width: 58px">
                                                                    <ice:inputText disabled="true" id="txtcolTotal1" style="" value="#{currentRow['totalCost']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextTotal1" value="Total"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colCHeck">
                                                                    <h:selectBooleanCheckbox binding="#{Education$EducationPaymentApprovePage.checkbox}"
                                                                        disabled="true" id="checkbox" value="#{currentRow['selected']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextadmoinsCostType4" value="Select Approved"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                                <ice:column id="colId" rendered="false">
                                                                    <ice:outputText id="optTxtForColumnadmoinsCostType4" value="#{currentRow['id']}"/>
                                                                    <f:facet name="header">
                                                                        <ice:outputText id="headerTextadmoinsCostType5" value="ID"/>
                                                                    </f:facet>
                                                                </ice:column>
                                                            </ice:dataTable>
                                                            <ice:commandButton disabled="true" id="btnCalculate1" rendered="false"
                                                                style="left: 494px; top: -10px; position: absolute; width: 103px" value="Calculate"/>
                                                            <ice:inputText action="#{Education$EducationPaymentApprovePage.txttotalCost_action}" disabled="true"
                                                                id="txttotalCost1" rendered="false" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 336px; top: -2px; position: absolute; width: 105px"/>
                                                        </ice:panelLayout>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout binding="#{Education$EducationPaymentApprovePage.pnlLayoutButtons2}" id="pnlLayoutButtons2"
                                                        layout="flow"
                                                        style="height: 174px; margin-left: 15px; left: 20px; top: 755px; overflow: auto; position: absolute; width: 694px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Education$EducationPaymentApprovePage.dataCourse}" id="dataCourse"
                                                            style="height: 8px; left: 14px; top: 62px; position: absolute; width: 600px"
                                                            value="#{Education$EducationPaymentApprovePage.courseTakingList}" var="currentRow">
                                                            <ice:column groupOn="#{currentRow['academicYear']}" id="colCouAcadamiccalander" style="width: 207px">
                                                                <ice:outputText id="optTxtForColumnQuantity1" value="#{currentRow['academicYear']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantit1" value="Acadamic Calander"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column groupOn="#{currentRow['semesterOrTerm']}" id="colCourseSemister1" style="width: 207px">
                                                                <ice:outputText id="optTxtForColumnQuantity4" value="#{currentRow['semesterOrTerm']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantit4" value="semesterOrTerm"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colCourseUnitCost" style="width: 259px">
                                                                <ice:outputText id="optTxtForColumnUnitCost2" value="#{currentRow['courseCode']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextUnitCost2" value="Course Code"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="colCourseQuantity1" style="width: 65px">
                                                                <ice:outputText id="optTxtForColumnQuantity3" value="#{currentRow['creditHr']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantit3" value="Credit Hour"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column groupOn="#{currentRow['requesterId']}" id="colCourseEmpId1" rendered="false">
                                                                <ice:outputText id="optTxtForColumnadmoinsCostType3" value="#{currentRow['requesterId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextadmoinsCostType3" value="EmpID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentApprovePage.lblResult}" id="lblResult"
                                                            style="left: 48px; top: 24px; position: absolute" value="#{msgse.Result}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtResult}" disabled="true"
                                                            id="txtResult" style="left: 94px; top: 22px; position: absolute; width: 143px"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentApprovePage.lblScore}" id="lblScore"
                                                            style="left: 360px; top: 24px; position: absolute" value="#{msgse.Score}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentApprovePage.txtScore}" disabled="true" id="txtScore" style="left: 430px; top: 22px; position: absolute; width: 143px"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationPaymentApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationPaymentApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationPaymentApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationPaymentApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentApprovePage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value=" BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$EducationPaymentApprovePage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$EducationPaymentApprovePage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$EducationPaymentApprovePage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$EducationPaymentApprovePage.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationPaymentApprovePage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup binding="#{Education$EducationPaymentApprovePage.pnlPopUpClearingDepSetting1}" clientOnly="true" draggable="true"
                            id="pnlPopUpClearingDepSetting1" modal="true" rendered="false" style="display: block; height: 323px; left: 97px; top: 226px; position: absolute; width: 634px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpResignTye1" styleClass="icePnlGrp icePnlGrp popupHeaderWrapper">
                                    <ice:outputText id="popUpResignTyeTitle1" style="width:400px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - List Of Taken Course"/>
                                    <ice:commandButton action="#{Education$EducationPaymentApprovePage.modalPnlCloseBtn1_action}" alt="Close"
                                        id="modalPnlCloseBtn1" image="/resources/images/close.gif" style="left: 614px; top: 2px; position: absolute"
                                        title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="lblSelected1" style="display: block; height: 256px; position: relative; width: 586" styleClass="icePnlGrp icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 234px; left: 22px; top: 13px; overflow: auto; position: absolute; width: 552px">
                                        <ice:dataTable id="tblClearingDep1" scrollFooter="true" scrollHeight="true" sortAscending="true"
                                            style="left: 5px; right: 5px; top: 5px; position: absolute"
                                            value="#{Education$EducationPaymentApprovePage.availableCourses}" var="currentRow" width="541">
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
