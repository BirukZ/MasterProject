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
                <title>Change Institution Request</title>
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
                    function ChangeInstitutionePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1200px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$ChangeInstitutionPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$ChangeInstitutionPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$ChangeInstitutionPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$ChangeInstitutionPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$ChangeInstitutionPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:600px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:600px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkEducationRequest_action}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkEducationPaymentRequest_action}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkEducationApprove_action}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkEducationPaymentApprove_action}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkChangeiNstitutionReq}"
                                                                id="lnkChangeiNstitutionReq" style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationPaymentRequestPage.lnkChangeInstApprove}"
                                                                id="lnkChangeInstApprove" style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkInstRegistration_action}"
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
                                                            <ice:selectOneListbox binding="#{Education$ChangeInstitutionPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$ChangeInstitutionPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$ChangeInstitutionPage.pendingRequestList}"/>
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
                                                                value="#{Education$ChangeInstitutionPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$ChangeInstitutionPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$ChangeInstitutionPage.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$ChangeInstitutionPage.page_display_processMyEvent}" id="page_display" style="height:1000px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 975px; left: 0px; position: relative; width: 100%; -rave-layout: grid; top: 15px" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 975px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="CHANGE INSTITUTION REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 970px; left: 0px; top: 15px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$ChangeInstitutionPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 970px; top:5px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" layout="flow" style="height: 942px; left: 11px; top: 6px; position: absolute; width: 100%; -rave-layout: grid">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 179px; margin-left: 15px; left: 11px; top: 26px; position: absolute; width: 702px" styleClass="insideContainerMain">
                                                            <ice:selectInputText action="#{Education$ChangeInstitutionPage.txtRequesterFullName_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtRequesterFullName}" id="txtRequesterFullName"
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
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgse.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 26px; top: 52px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 432px; top: 24px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 180px; top: 50px; position: absolute; width: 465px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtRequesterId}" id="txtRequesterId"
                                                                immediate="true" partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 26px; top: 26px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtRequesterPosition_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 180px; top: 76px; position: absolute; width: 465px"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnSearchRequester_action}"
                                                                actionListener="#{Education$ChangeInstitutionPage.btnSearchRequester_processAction}"
                                                                binding="#{Education$ChangeInstitutionPage.btnSearchRequester}" id="btnSearchRequester"
                                                                image="/resources/images/fig_search.gif" style="left: 624px; top: 26px; position: absolute"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel1"
                                                                style="left: 26px; top: 104px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtlblRequesterEdLevel}" disabled="true"
                                                                id="txtlblRequesterEdLevel" style="left: 180px; top: 102px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtlblRequesterProgramName}"
                                                                disabled="true" id="txtlblRequesterProgramName" style="left: 180px; top: 128px; position: absolute; width: 239px"/>
                                                            <ice:outputLabel id="lblRequesterProgramName1"
                                                                style="left: 26px; top: 130px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                                id="message1" infoClass="infoMessage"
                                                                style="height: 20px; left: 384px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message2"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 480px; top: 24px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                                id="message3" infoClass="infoMessage"
                                                                style="height: 20px; left: 648px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                                id="message4" infoClass="infoMessage"
                                                                style="height: 20px; left: 648px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterEdLevel"
                                                                id="message5" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterProgramName"
                                                                id="message6" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 120px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution" layout="flow"
                                                            style="height: 179px; margin-left: 15px; left: 11px; top: 234px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblInstitutionName"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lbledRequId}" id="lbledRequId"
                                                                rendered="false" style="height: 19px; left: 0px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblchangeInstituId}"
                                                                id="lblchangeInstituId" rendered="false" style="height: 19px; left: 312px; top: 0px; position: absolute"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtInstNAme}" disabled="true"
                                                                id="txtInstNAme" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblEduRequestId}" id="lblEduRequestId"
                                                                rendered="false" style="left: 48px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblRequesterID1}" id="lblRequesterID1"
                                                                rendered="false" style="height: 17px; left: 216px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblInstitPrevId}" id="lblInstitPrevId"
                                                                rendered="false" style="height: 17px; left: 144px; top: 72px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest" layout="flow"
                                                            style="height: 231px; margin-left: 15px; left: 11px; top: 624px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblCostPerCreditHour" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Costpercredit}"/>
                                                            <ice:outputLabel id="lblAdminstrativeCost"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Totaladministrativecost}"/>
                                                            <ice:outputLabel id="lblDurationInYear"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.DurationInYear}"/>
                                                            <ice:outputLabel id="lblNumberOfCreditHours"
                                                                style="font-size: 10px; height: 19px; left: 26px; top: 104px; position: absolute; width: 127px" value="#{msgse.Noofcredit}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber"
                                                                style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblRemark"
                                                                style="font-size: 10px; height: 19px; left: 26px; top: 156px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtCostPerCreditHour}" disabled="true"
                                                                id="txtCostPerCreditHour" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 76px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtNumberOfCreditHours}" disabled="true"
                                                                id="txtNumberOfCreditHours" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 102px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtDocumentReferenceNumber}"
                                                                disabled="true" id="txtDocumentReferenceNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 128px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtDurationInYear}" disabled="true"
                                                                id="txtDurationInYear" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 50px; position: absolute; width: 129px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionPage.txtRemarkprev}" disabled="true"
                                                                id="txtRemarkprev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 51px; left: 76px; top: 154px; position: absolute; width: 234px"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionPage.calStartDate}" id="calStartDate"
                                                                rendered="false" style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionPage.calAppliedDate}" id="calAppliedDate"
                                                                rendered="false" style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calAppliedDate_processValueChange}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtTotalAdminstrativeCost}" disabled="true"
                                                                id="txtTotalAdminstrativeCost" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 180px; top: 24px; position: absolute; width: 130px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                            style="height: 21px; margin-left: 15px; left: -15px; top: 888px; overflow: auto; position: absolute; width: 717px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnSaveOrUpdate_action}"
                                                                binding="#{Education$ChangeInstitutionPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 216px; top: -10px; position: absolute; width: 71px" value="#{Education$ChangeInstitutionPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnReset_action}"
                                                                binding="#{Education$ChangeInstitutionPage.btnReset}" id="btnReset"
                                                                style="left: 312px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnDelete_action}"
                                                                binding="#{Education$ChangeInstitutionPage.btnDelete}" id="btnDelete"
                                                                style="left: 408px; top: -10px; position: absolute; width: 71px" value="#{msgse.btnDelete}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution1" layout="flow"
                                                            style="height: 205px; margin-left: 15px; left: 11px; top: 416px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel id="lblxxDurationInYear"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblProgramName"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtAppliedDate_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtAppliedDate}" disabled="true" id="txtAppliedDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 102px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblStartDate"
                                                                style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate"
                                                                style="font-size: 10px; left: 26px; top: 104px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 128px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtLevel}" disabled="true" id="txtLevel" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 24px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtProgramName}" disabled="true"
                                                                id="txtProgramName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 50px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtShift}" disabled="true" id="txtShift" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 76px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtendDate}" disabled="true"
                                                                id="txtendDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 154px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblendDate" style="font-size: 10px; left: 26px; top: 156px; position: absolute" value="#{msgse.Enddate}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution2" layout="flow"
                                                            style="height: 179px; margin-left: 15px; left: 375px; top: 234px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputText id="lblInstitutionAccredited1"
                                                                style="font-size: 10px; font-family: 'Cambria'; height: 19px; left: 24px; top: 144px; position: absolute; width: 77px" value="#{msgse.Accredited}"/>
                                                            <ice:outputText id="lblLocationInsideEthiopia1"
                                                                style="font-size: 10px; font-family: 'Cambria'; left: 26px; top: 104px; position: absolute" value="#{msgse.InsideOutside}"/>
                                                            <ice:outputLabel id="lblInstitutionName1"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblInstitutionAddress1"
                                                                style="font-size: 10px; height: 39px; left: 24px; top: 48px; position: absolute; width: 91px" value="#{msgse.InstitutionAddress}"/>
                                                            <ice:selectOneMenu binding="#{Education$ChangeInstitutionPage.drlInstitutionNameNew}"
                                                                id="drlInstitutionNameNew" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 118px; top: 22px; position: absolute; width: 155px" valueChangeListener="#{Education$ChangeInstitutionPage.drlInstitutionNameNew_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Education$ChangeInstitutionPage.nameOfInstitution}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtAccredNEw}" disabled="true"
                                                                id="txtAccredNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 142px; position: absolute; width: 161px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtInsideOutNEw}" disabled="true"
                                                                id="txtInsideOutNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 118px; position: absolute; width: 161px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionPage.txtaInstitutionAddressNew}"
                                                                id="txtaInstitutionAddressNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 49px; left: 118px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlInstitutionNameNew"
                                                                id="message7" infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtaInstitutionAddressNew"
                                                                id="message8" infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtInsideOutNEw" id="message9"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 120px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtAccredNEw" id="message10"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 144px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblInstitutionNameNew}"
                                                                id="lblInstitutionNameNew" rendered="false" style="font-size: 12px; height: 17px; left: 120px; top: 0px; position: absolute; width: 170px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution3" layout="flow"
                                                            style="height: 205px; margin-left: 15px; left: 375px; top: 416px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel1"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:selectOneMenu binding="#{Education$ChangeInstitutionPage.drlEducationShiftNew}"
                                                                id="drlEducationShiftNew" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 76px; position: absolute; width: 155px" value="#{Education$ChangeInstitutionPage.selectObjectOfEducationShiftCatagory.selectedObject}">
                                                                <f:selectItems id="selectOneMenuEducationShift1" value="#{Education$ChangeInstitutionPage.educationShiftList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblxxDurationInYear1"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblProgramName1"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtAppliedDateNew}" disabled="true"
                                                                id="txtAppliedDateNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 102px; position: absolute; width: 155px"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionPage.calAppliedDateNew}"
                                                                id="calAppliedDateNew" rendered="false"
                                                                style="left: 50px; top: 10px; position: absolute; height:212px; width: 190px; z-index:100"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calAppliedDateNew_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionPage.calStartDateNEw}"
                                                                id="calStartDateNEw" rendered="false"
                                                                style="left: 50px; top: 10px; position: absolute; height:212px; width: 190px; z-index:100"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calStartDateNEw_processValueChange}"/>
                                                            <ice:outputLabel id="lblStartDate1"
                                                                style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate1"
                                                                style="font-size: 10px; left: 26px; top: 104px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnCalendarSatartDateNew_action}"
                                                                binding="#{Education$ChangeInstitutionPage.btnCalendarSatartDateNew}"
                                                                id="btnCalendarSatartDateNew" image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 286px; top: 130px; position: absolute" value="submit"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtStartDateNEw}" disabled="true"
                                                                id="txtStartDateNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 128px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblDeptID}" id="lblDeptID"
                                                                rendered="false" style="height: 19px; left: 0px; top: 0px; position: absolute"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtLevelNew}" disabled="true"
                                                                id="txtLevelNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 24px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtProgramNameNew}" disabled="true"
                                                                id="txtProgramNameNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 50px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtendDateNew}" id="txtendDateNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 154px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblendDate1"
                                                                style="font-size: 10px; left: 26px; top: 156px; position: absolute" value="#{msgse.Enddate}"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionPage.btnCalendarendDateNew_action}"
                                                                binding="#{Education$ChangeInstitutionPage.btnCalendarendDateNew}" id="btnCalendarendDateNew"
                                                                image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 286px; top: 156px; position: absolute" value="submit"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlEducationShiftNew"
                                                                id="message11" infoClass="infoMessage"
                                                                style="height: 20px; left: 288px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtStartDateNEw"
                                                                id="message12" infoClass="infoMessage"
                                                                style="height: 20px; left: 96px; top: 120px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtendDateNew" id="message13"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 96px; top: 144px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest1" layout="flow"
                                                            style="height: 237px; margin-left: 15px; left: 375px; top: 624px; overflow: auto; position: absolute; width: 335px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblCostPerCreditHour1"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Costpercredit}"/>
                                                            <ice:outputLabel id="lblAdminstrativeCost1"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Totaladministrativecost}"/>
                                                            <ice:outputLabel id="lblDurationInYear1"
                                                                style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.DurationInYear}"/>
                                                            <ice:outputLabel id="lblNumberOfCreditHours1"
                                                                style="font-size: 10px; height: 19px; left: 24px; top: 96px; position: absolute; width: 127px" value="#{msgse.Noofcredit}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber1"
                                                                style="font-size: 10px; left: 24px; top: 120px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblRemark1"
                                                                style="font-size: 10px; height: 19px; left: 24px; top: 168px; position: absolute; width: 49px" value="#{msgse.ReasonofChangingInstitution}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtCostPerCreditHourNew}"
                                                                id="txtCostPerCreditHourNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 129px"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtNumberOfCreditHoursNew_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtNumberOfCreditHoursNew}"
                                                                id="txtNumberOfCreditHoursNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtDocumentReferenceNumberNew}"
                                                                id="txtDocumentReferenceNumberNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 118px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionPage.txtDurationInYearNEw}"
                                                                id="txtDurationInYearNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 129px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionPage.txtRemarkNEw}" id="txtRemarkNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 51px; left: 76px; top: 154px; position: absolute; width: 234px"/>
                                                            <ice:selectInputDate id="calStartDate1" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate id="calAppliedDate1" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$ChangeInstitutionPage.calAppliedDate_processValueChange}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionPage.txtTotalAdminstrativeCostNew}"
                                                                id="txtTotalAdminstrativeCostNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 129px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTotalAdminstrativeCostNew"
                                                                id="message14" infoClass="infoMessage"
                                                                style="height: 20px; left: 312px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDurationInYearNEw"
                                                                id="message15" infoClass="infoMessage"
                                                                style="height: 20px; left: 312px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtCostPerCreditHourNew"
                                                                id="message16" infoClass="infoMessage"
                                                                style="height: 20px; left: 312px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNumberOfCreditHoursNew"
                                                                id="message17" infoClass="infoMessage"
                                                                style="height: 20px; left: 312px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocumentReferenceNumberNew"
                                                                id="message18" infoClass="infoMessage"
                                                                style="height: 20px; left: 312px; top: 120px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionPage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Education$ChangeInstitutionPage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions" rendered="false"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 96px; top: 216px; position: absolute" value="View status of  this request"/>
                                                        </ice:panelLayout>
                                                        <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblNew}" id="lblNew"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 432px; top: 216px; position: absolute; width: 69px" value="New"/>
                                                        <ice:outputLabel binding="#{Education$ChangeInstitutionPage.lblPrev}" id="lblPrev"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 96px; top: 216px; position: absolute; width: 69px" value="Previous"/>
                                                        <ice:outputLabel id="lblInstitutionName2"
                                                            style="font-size: 10px; font-weight: bold; height: 17px; left: 168px; top: 216px; position: absolute" value="Institution Information"/>
                                                        <ice:outputLabel id="lblInstitutionName3"
                                                            style="font-size: 10px; font-weight: bold; height: 18px; left: 504px; top: 216px; position: absolute" value="Institution Information"/>
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
                                                style="margin-left:10px;color:white;font-weight:bold;font-family:Cambria">Copyright © 2002-2003 Ethiopian Calander | <a
                                                href="http://www.insa.gov.et" style="text-decoration:none;color:orange">Information Network Security Agency |Directorate Of Research Technology |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:1000" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$ChangeInstitutionPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$ChangeInstitutionPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$ChangeInstitutionPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$ChangeInstitutionPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$ChangeInstitutionPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionPage.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$ChangeInstitutionPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$ChangeInstitutionPage.decisionsMadeOnRequestList}" var="currentRow">
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
