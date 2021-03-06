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
                <title>Education Pre Payment Request</title>
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
                        <img alt="" class="source-image" height="1224" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$EducationPaymentRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$EducationPaymentRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$EducationPaymentRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$EducationPaymentRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$EducationPaymentRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1000">
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
                                <ice:panelGroup id="menu_left" style="border-style: none; height: 250px">
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
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkEducationRequest_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkEducationRequest}" id="lnkEducationRequest"
                                                                style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkEducationPaymentRequest_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkEducationPaymentRequest}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkEducationApprove_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkEducationApprove}" id="lnkEducationApprove"
                                                                style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkEducationPaymentApprove_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkEducationPaymentApprove}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkChangeiNstitutionReq}"
                                                                id="lnkChangeiNstitutionReq" style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkChangeInstApprove}"
                                                                id="lnkChangeInstApprove" style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkInstRegistration_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkInstRegistration}" id="lnkInstRegistration"
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
                                                        <ice:panelLayout id="StatusContainer" style="height: 185px; position: absolute; width: 214px">
                                                            <ice:selectOneListbox binding="#{Education$EducationPaymentRequestPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationPaymentRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$EducationPaymentRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$EducationPaymentRequestPage.pendingRequestList}"/>
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
                                                            <ice:selectOneListbox binding="#{Education$EducationPaymentRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationPaymentRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$EducationPaymentRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$EducationPaymentRequestPage.requestHistoryList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 1010px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 600px; left: 35px; position: relative; top: 20px; width: 800px; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 980px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Education Pre Payment Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 800px; left: 0px; top:50px; position: absolute; width: 100%">
                                                <ice:panelGroup id="leaveRequest" style="height: 745px; width: 95%; " styleClass="filedset_normal">
                                                    <ice:panelLayout id="panelDetail12" style="border: 1px solid rgb(204, 204, 204); height: 160px; left: 10px; top: 0px; position: absolute; width: 780px">
                                                        <ice:selectInputText action="#{Education$EducationPaymentRequestPage.txtRequesterFullName_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
                                                            immediate="true" listValue="#{ApplicationBean1.list}" listVar="employeeList" partialSubmit="true"
                                                            rows="10" style="left: 182px; top: 26px; position: absolute; "
                                                            valueChangeListener="#{ApplicationBean1.updateList}" width="200px">
                                                            <f:facet name="selectInputText">
                                                                <ice:panelGrid columnClasses="fullNameCol,empIdCol" columns="2">
                                                                    <ice:outputText id="lblFullNameAutoComplete" value="#{employeeList.fullName}"/>
                                                                    <ice:outputText id="lblEmployeeIdAutoComplete" value="#{employeeList.empIdentification}"/>
                                                                </ice:panelGrid>
                                                            </f:facet>
                                                        </ice:selectInputText>
                                                        <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgse.Requester}"/>
                                                        <ice:outputLabel id="lblRequesterDepartment" style="left: 26px; top: 52px; position: absolute" value="#{msgse.Department}"/>
                                                        <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgse.ID}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtRequesterDepartment}" disabled="true"
                                                            id="txtRequesterDepartment" style="left: 180px; top: 50px; position: absolute; width: 441px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtRequesterId}" id="txtRequesterId"
                                                            immediate="true" partialSubmit="true" style="left: 530px; top: 22px; position: absolute; width: 155px"/>
                                                        <ice:outputLabel id="lblRequsterFullName" style="left: 26px; top: 26px; position: absolute" value="#{msgse.FullName}"/>
                                                        <ice:outputLabel id="lblRequesterPosition" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtRequesterPosition}" disabled="true"
                                                            id="txtRequesterPosition" style="left: 180px; top: 76px; position: absolute; width: 441px"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnSearchRequester_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnSearchRequester}" id="btnSearchRequester"
                                                            image="/resources/images/fig_search.gif" style="left: 624px; top: 24px; position: absolute"/>
                                                        <ice:outputLabel id="lblRequesterEdLevel1"
                                                            style="left: 26px; top: 104px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtlblRequesterEdLevel}" disabled="true"
                                                            id="txtlblRequesterEdLevel" style="left: 180px; top: 102px; position: absolute; width: 239px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtlblRequesterProgramName}"
                                                            disabled="true" id="txtlblRequesterProgramName" style="left: 180px; top: 128px; position: absolute; width: 239px"/>
                                                        <ice:outputLabel id="lblRequesterProgramName1"
                                                            style="left: 26px; top: 130px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 480px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterEdLevel"
                                                            id="message2" infoClass="infoMessage"
                                                            style="height: 20px; left: 432px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterProgramName"
                                                            id="message17" infoClass="infoMessage"
                                                            style="height: 20px; left: 432px; top: 120px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                            id="message18" infoClass="infoMessage"
                                                            style="height: 20px; left: 624px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                            id="message19" infoClass="infoMessage"
                                                            style="height: 20px; left: 624px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                            id="message20" infoClass="infoMessage"
                                                            style="height: 20px; left: 384px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayputInstitution" layout="flow" rendered="false"
                                                        style="height: 125px; margin-left: 15px; left: 11px; top: 208px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblInstitutionName" style="left: 24px; top: 24px; position: absolute" value="#{msgse.Institution}"/>
                                                        <ice:outputLabel id="lblProgramName" style="left: 360px; top: 24px; position: absolute" value="#{msgse.ProgramName}"/>
                                                        <ice:outputLabel id="lblEducationLevel" style="left: 24px; top: 48px; position: absolute" value="#{msgse.Level}"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblEducreqestID}" id="lblEducreqestID"
                                                            rendered="false" style="height: 19px; left: 650px; top: 0px; position: absolute"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtLevel}" disabled="true" id="txtLevel" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 46px; position: absolute; width: 155px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtInstitName}" disabled="true"
                                                            id="txtInstitName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 22px; position: absolute; width: 155px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtProgName}" disabled="true"
                                                            id="txtProgName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 478px; top: 22px; position: absolute; width: 155px"/>
                                                        <ice:outputLabel id="lblDocumentReference"
                                                            style="left: 360px; top: 48px; position: absolute; width: 117px" value="#{msgse.PermissioEducationdocNum}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtDocreferenceNum}" disabled="true"
                                                            id="txtDocreferenceNum" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 478px; top: 46px; position: absolute; width: 155px"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtInstitName" id="message3"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 288px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtLevel" id="message4"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 288px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtProgName" id="message5"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocreferenceNum" id="message21"
                                                            infoClass="infoMessage"
                                                            style="height: 20px; left: 648px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtGrade}" disabled="true" id="txtGrade" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 23px; left: 118px; top: 70px; position: absolute; width: 155px"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblGrade}" id="lblGrade"
                                                            style="height: 41px; left: 24px; top: 72px; position: absolute; width: 93px" value="#{msgse.LevelofEducation}"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblInstitPrevId}" id="lblInstitPrevId"
                                                            rendered="false" style="height: 17px; left: 0px; top: 0px; position: absolute; width: 93px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayputPaymentRequest" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 285px; left: 10px; top: 170px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel id="lblIssueDate" style="font-size: 10px; left: 38px; top: 84px; position: absolute" value="#{msgse.Issuedate}"/>
                                                        <ice:outputLabel id="lblAppliedDate" style="font-size: 10px; left: 38px; top: 40px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblAdminstrativeCost}"
                                                            id="lblAdminstrativeCost" style="font-size: 10px; left: 445px; top: 128px; position: absolute" value="#{msgse.AdminstrativeCost}"/>
                                                        <ice:outputLabel id="lblAcademicYear"
                                                            style="font-size: 10px; left: 450px; top: 40px; position: absolute" value="#{msgse.Academicyear}"/>
                                                        <ice:outputLabel id="lblSemesterOrTerm"
                                                            style="font-size: 10px; left: 445px; top: 84px; position: absolute" value="#{msgse.Semester}"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblUnitCost}" id="lblUnitCost"
                                                            style="font-size: 10px; left: 445px; top: 168px; position: absolute" value="#{msgse.Cost}"/>
                                                        <ice:outputLabel id="lblDocumentReferenceNumber"
                                                            style="font-size: 10px; left: 38px; top: 168px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                        <ice:outputLabel id="lblDocumentRecieptNumber"
                                                            style="font-size: 10px; left: 38px; top: 128px; position: absolute" value="#{msgse.Receiptnumber}"/>
                                                        <ice:outputLabel id="lblRemark" style="font-size: 10px; left: 38px; top: 216px; position: absolute" value="#{msgse.Remark}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtIssueDate}" disabled="true"
                                                            id="txtIssueDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 81px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtAppliedDate}" disabled="true"
                                                            id="txtAppliedDate" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 37px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtUnitCost}" disabled="true"
                                                            id="txtUnitCost" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 565px; top: 166px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtDocumentReferenceNumber}"
                                                            disabled="true" id="txtDocumentReferenceNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 166px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtReciptNumber}" disabled="true"
                                                            id="txtReciptNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 118px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtAcademicYear}" disabled="true"
                                                            id="txtAcademicYear" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 565px; top: 37px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtSemesterOrTerm}" disabled="true"
                                                            id="txtSemesterOrTerm" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 565px; top: 81px; position: absolute; width: 190px"/>
                                                        <ice:inputTextarea binding="#{Education$EducationPaymentRequestPage.txtRemark}" disabled="true"
                                                            id="txtRemark" style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 150px; top: 213px; position: absolute; width: 400px"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnCalendarSatartDate_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnCalendarSatartDate}" id="btnCalendarSatartDate"
                                                            image="/resources/images/cal_button.gif" immediate="true"
                                                            style="left: 325px; top: 87px; position: absolute" value="submit"/>
                                                        <ice:selectInputDate binding="#{Education$EducationPaymentRequestPage.calStartDate}" id="calStartDate"
                                                            rendered="false"
                                                            style="left: 50px; top: 75px; position: absolute; height:212px; width: 190px; z-index:200"
                                                            value="#{Education$EducationPaymentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationPaymentRequestPage.calStartDate_processValueChange}"/>
                                                        <ice:selectInputDate binding="#{Education$EducationPaymentRequestPage.calAppliedDate}"
                                                            id="calAppliedDate" rendered="false"
                                                            style="left: 50px; top: 100px; position: absolute; height:212px; width: 190px;z-index:100"
                                                            value="#{Education$EducationPaymentRequestPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$EducationPaymentRequestPage.calAppliedDate_processValueChange}"/>
                                                        <ice:selectOneMenu binding="#{Education$EducationPaymentRequestPage.drlAdminstrativeCost}"
                                                            disabled="true" id="drlAdminstrativeCost" partialSubmit="true"
                                                            style="border: 1px solid rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 565px; top: 125px; position: absolute; width: 190px" valueChangeListener="#{Education$EducationPaymentRequestPage.drlAdminstrativeCost_processValueChange}">
                                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Education$EducationPaymentRequestPage.adminstrativeCosts}"/>
                                                        </ice:selectOneMenu>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnAdd_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnAdd}" id="btnAdd"
                                                            style="font-size: 10px; left: 600px; top: 216px; position: absolute; width: 150px" value="#{msgse.btnAddtoTable}"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons1" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 100px; left: 10px; top: 470px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblTutationFee}" id="lblTutationFee"
                                                            rendered="false" style="height: 19px; left: 234px; top: 0px; position: absolute" value="Total Cost Is"/>
                                                        <ice:dataTable binding="#{Education$EducationPaymentRequestPage.dataAdminstrativeCost}"
                                                            id="dataAdminstrativeCost" style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Education$EducationPaymentRequestPage.adminstrativeCostLists}" var="currentRow">
                                                            <ice:column groupOn="#{currentRow['requesterId']}" id="colEmpId1" rendered="false">
                                                                <ice:outputText id="optTxtForColumnadmoinsCostType1" value="#{currentRow['requesterId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextadmoinsCostType1" value="EmpID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                            <ice:column id="coladmoinsCostType" style="width: 259px">
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
                                                            <ice:column binding="#{Education$EducationPaymentRequestPage.coTotal}" id="coTotal" style="width: 58px">
                                                                <ice:inputText disabled="true" id="txtcolTotal" style="" value="#{currentRow['totalCost']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextTotal" value="Total"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Education$EducationPaymentRequestPage.rowSelectorAdminCost_processMyEvent}"/>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnCalculate_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnCalculate}" disabled="true" id="btnCalculate"
                                                            rendered="false" style="left: 494px; top: -10px; position: absolute; width: 103px" value="Calculate"/>
                                                        <ice:inputText action="#{Education$EducationPaymentRequestPage.txttotalCost_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.txttotalCost}" disabled="true" id="txttotalCost"
                                                            rendered="false" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 336px; top: -2px; position: absolute; width: 105px"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutTxtFiled" layout="flow" style="border: 1px solid rgb(204, 204, 204); height: 100px; left: 10px; top: 580px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid">
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblCourseCode}" id="lblCourseCode"
                                                            style="font-size: 10px; left: 24px; top: 20px; position: absolute" value="#{msgse.Coursecode}"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblCreditHour}" id="lblCreditHour"
                                                            style="font-size: 10px; left: 24px; top: 55px; position: absolute" value="#{msgse.CreditHour}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtCreditHour}" disabled="true"
                                                            id="txtCreditHour" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 46px; position: absolute; width: 190px"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtCourseCode}" disabled="true"
                                                            id="txtCourseCode" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 22px; position: absolute; width: 190px"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnAddCourse_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnAddCourse}" id="btnAddCourse"
                                                            style="font-size: 10px; left: 600px; top: 14px; position: absolute; width: 150px" value="#{msgse.btnAddtoTable}"/>
                                                        <ice:inputText binding="#{Education$EducationPaymentRequestPage.txtResult}" id="txtResult"
                                                            rendered="false" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 46px; position: absolute; width: 190px"/>
                                                        <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblResult}" id="lblResult"
                                                            rendered="false" style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="Result"/>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtons2" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); height: 127px; left: 10px; top: 690px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:dataTable binding="#{Education$EducationPaymentRequestPage.dataCourse}" id="dataCourse"
                                                            style="left: 0px; top: -10px; position: absolute; width: 100%"
                                                            value="#{Education$EducationPaymentRequestPage.courseTakingList}" var="currentRow">
                                                            <ice:column groupOn="#{currentRow['academicYear']}" id="colAcadamicCalander" style="width: 207px">
                                                                <ice:outputText id="optTxtForColumnQuantity3" value="#{currentRow['academicYear']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantit3" value="Acadamic Year"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorOverTime1" preStyleOnSelection="true" selectionListener="#{Education$EducationPaymentRequestPage.rowSelectorCourse_processMyEvent}"/>
                                                            </ice:column>
                                                            <ice:column groupOn="#{currentRow['semesterOrTerm']}" id="colCourseSemister" style="width: 207px">
                                                                <ice:outputText id="optTxtForColumnQuantity2" value="#{currentRow['semesterOrTerm']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextQuantit2" value="semesterOrTerm"/>
                                                                </f:facet>
                                                                <ice:rowSelector id="rowSelectorOverTime" multiple="false" preStyleOnSelection="true" selectionListener="#{Education$EducationPaymentRequestPage.rowSelectorCourse_processMyEvent}"/>
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
                                                            <ice:column groupOn="#{currentRow['requesterId']}" id="colCourseEmpId" rendered="false">
                                                                <ice:outputText id="optTxtForColumnadmoinsCostType2" value="#{currentRow['requesterId']}"/>
                                                                <f:facet name="header">
                                                                    <ice:outputText id="headerTextadmoinsCostType2" value="EmpID"/>
                                                                </f:facet>
                                                            </ice:column>
                                                        </ice:dataTable>
                                                    </ice:panelLayout>
                                                    <ice:panelLayout id="pnlLayoutButtonsStatus" layout="flow"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 32px; left: 10px; top: 830px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkViewPrevieousDecisions_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.lnkViewPrevieousDecisions}"
                                                            id="lnkViewPrevieousDecisions"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; left: 552px; top: 0px; position: absolute; width: 200px" value="View status of  this request"/>
                                                        <ice:commandLink action="#{Education$EducationPaymentRequestPage.lnkViewCourseLists_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.lnkViewCourseLists}" id="lnkViewCourseLists"
                                                            rendered="false"
                                                            style="color: rgb(48, 102, 130); font-weight: bold; left: 24px; top: 0px; position: absolute; width: 200px" value="Show List Of All Courses"/>
                                                    </ice:panelLayout>
                                                    <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnAcadamicYear_action}"
                                                        binding="#{Education$EducationPaymentRequestPage.btnAcadamicYear}" id="btnAcadamicYear"
                                                        image="/resources/images/cal_button.gif" immediate="true"
                                                        style="left: 745px; top: 213px; position: absolute" value="submit"/>
                                                    <ice:selectInputDate binding="#{Education$EducationPaymentRequestPage.calAcadamicYear}" id="calAcadamicYear"
                                                        rendered="false" style="left: 550px; top: 100px; position: absolute; height:212px; width: 190px"
                                                        value="#{Education$EducationPaymentRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationPaymentRequestPage.calAcadamicYear_processValueChange}"/>
                                                    <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblcourseInfo}" id="lblcourseInfo"
                                                        rendered="false" style="left: 24px; top: 384px; position: absolute; width: 335px" value="Course Information Taken From Sleep"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAppliedDate" id="message7"
                                                        infoClass="infoMessage" style="height: 20px; left: 361px; top: 217px; position: absolute; width: 22px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtIssueDate" id="message8"
                                                        infoClass="infoMessage" style="height: 20px; left: 361px; top: 241px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocumentReferenceNumber"
                                                        id="message9" infoClass="infoMessage"
                                                        style="height: 20px; left: 361px; top: 337px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAcademicYear" id="message10"
                                                        infoClass="infoMessage" style="height: 20px; left: 769px; top: 217px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtSemesterOrTerm" id="message11"
                                                        infoClass="infoMessage" style="height: 20px; left: 769px; top: 241px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtReciptNumber" id="message12"
                                                        infoClass="infoMessage" style="height: 20px; left: 361px; top: 289px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlAdminstrativeCost" id="message13"
                                                        infoClass="infoMessage" style="height: 20px; left: 769px; top: 289px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtUnitCost" id="message14"
                                                        infoClass="infoMessage" style="height: 20px; left: 769px; top: 337px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                    <ice:selectBooleanCheckbox binding="#{Education$EducationPaymentRequestPage.chkBasicLevel}"
                                                        id="chkBasicLevel" partialSubmit="true" rendered="false"
                                                        style="left: 382px; top: 454px; position: absolute"
                                                        value="#{Education$EducationPaymentRequestPage.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{Education$EducationPaymentRequestPage.chkBasicLevel_processValueChange}"/>
                                                    <ice:outputLabel id="lblBasic" rendered="false" style="left: 432px; top: 456px; position: absolute" value="Basic Level/ Driving Skil"/>
                                                    <ice:selectBooleanCheckbox binding="#{Education$EducationPaymentRequestPage.chkHigher}" id="chkHigher"
                                                        partialSubmit="true" rendered="false" style="left: 94px; top: 454px; position: absolute"
                                                        value="#{Education$EducationPaymentRequestPage.defaultSelectedData11.selectedBoolean}" valueChangeListener="#{Education$EducationPaymentRequestPage.chkHigher_processValueChange}"/>
                                                    <ice:outputLabel binding="#{Education$EducationPaymentRequestPage.lblHighrLevel}" id="lblHighrLevel"
                                                        rendered="false" style="left: 144px; top: 456px; position: absolute" value="Higher Level"/>
                                                    <ice:selectOneMenu binding="#{Education$EducationPaymentRequestPage.drlBasicLevel}" id="drlBasicLevel"
                                                        partialSubmit="true" rendered="false" style="left: 454px; top: 526px; position: absolute; width: 165px" value="#{Education$EducationPaymentRequestPage.defaultSelectedData12.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{Education$EducationPaymentRequestPage.educationLevel}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                        style="border: 1px solid rgb(204, 204, 204); left: 10px; top: 870px; overflow: auto; position: absolute; width: 780px; -rave-layout: grid" styleClass="insideContainerMain">
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnNew_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnNew}" id="btnNew" rendered="false"
                                                            style="margin-left: 100px; width: 120px" value="#{msgse.btnNew}"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnSaveOrUpdate_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnSaveOrUpdate}" disabled="true"
                                                            id="btnSaveOrUpdate" style="margin-left: 40px; width: 120px" value="Save"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnReset_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnReset}" id="btnReset"
                                                            style="margin-left: 40px; width: 120px" value="#{msgse.btnRest}"/>
                                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnDelete_action}"
                                                            binding="#{Education$EducationPaymentRequestPage.btnDelete}" disabled="true" id="btnDelete"
                                                            style="margin-left: 40px; width: 120px" value="#{msgse.btnDelete}"/>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright Â© 2005-2006 Ethiopian Calander | <a
                                                href="http://www.GOOGLE.COM" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationPaymentRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationPaymentRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationPaymentRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationPaymentRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$EducationPaymentRequestPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$EducationPaymentRequestPage.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationPaymentRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$EducationPaymentRequestPage.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationPaymentRequestPage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup binding="#{Education$EducationPaymentRequestPage.pnlPopUpClearingDepSetting1}" clientOnly="true" draggable="true"
                            id="pnlPopUpClearingDepSetting1" modal="true" rendered="false" style="display: block; height: 323px; left: 97px; top: 226px; position: absolute; width: 634px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpResignTye1" styleClass="icePnlGrp popupHeaderWrapper">
                                    <ice:outputText id="popUpResignTyeTitle1" style="width:400px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - List Of Taken Course"/>
                                    <ice:commandButton actionListener="#{Education$EducationPaymentRequestPage.modalPnlCloseBtn_processAction}" alt="Close"
                                        binding="#{Education$EducationPaymentRequestPage.modalPnlCloseBtn1}" id="modalPnlCloseBtn1"
                                        image="/resources/images/close.gif" style="left: 614px; top: 2px; position: absolute" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="lblSelected1" style="display: block; height: 256px; position: relative; width: 586" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="panelLayout2" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 234px; left: 22px; top: 13px; overflow: auto; position: absolute; width: 552px">
                                        <ice:dataTable binding="#{Education$EducationPaymentRequestPage.tblClearingDep1}" id="tblClearingDep1"
                                            scrollFooter="true" scrollHeight="true" sortAscending="true"
                                            style="left: 5px; right: 5px; top: 5px; position: absolute"
                                            value="#{Education$EducationPaymentRequestPage.availableCourses}" var="currentRow" width="541">
                                            <ice:column groupOn="#{currentRow['institutionName']}" id="column1" style="width: 50px">
                                                <ice:outputText id="outputText1" value="#{currentRow['institutionName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText15" value="Name Of Institution"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column3" style="width: 191px">
                                                <ice:outputText id="outputText4" value="#{currentRow['academicYear']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="outputText5" value="Acadamic Year"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="column2" style="width: 191px">
                                                <ice:outputText id="outputText11" value="#{currentRow['courseCode']}"/>
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
