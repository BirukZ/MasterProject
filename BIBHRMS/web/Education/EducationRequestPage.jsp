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
                <title>Education  Request</title>
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
                    function AgreementWithDuty(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <img alt="" class="source-image" height="1285" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$EducationRequestPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$EducationRequestPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$EducationRequestPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$EducationRequestPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$EducationRequestPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                            <ice:commandLink binding="#{Education$EducationRequestPage.lnkEducationRequest}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$EducationRequestPage.lnkEducationPaymentRequest}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$EducationRequestPage.lnkEducationApprove}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink binding="#{Education$EducationRequestPage.lnkEducationPaymentApprove}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationRequestPage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationRequestPage.lnkChangeiNstitutionReq}" id="lnkChangeiNstitutionReq"
                                                                style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationRequestPage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationRequestPage.lnkChangeInstApprove}" id="lnkChangeInstApprove"
                                                                style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationRequestPage.lnkInstRegistration_action}"
                                                                binding="#{Education$EducationRequestPage.lnkInstRegistration}" id="lnkInstRegistration"
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
                                                            <ice:selectOneListbox binding="#{Education$EducationRequestPage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationRequestPage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$EducationRequestPage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$EducationRequestPage.pendingRequestList}"/>
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
                                                            <ice:selectOneListbox binding="#{Education$EducationRequestPage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationRequestPage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$EducationRequestPage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$EducationRequestPage.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$EducationRequestPage.page_display_processMyEvent}" id="page_display" style="height:1100px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1100px; left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1085px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Education Request"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1100px; left: 0px; top: 20px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$EducationRequestPage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1030px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 1020px; top: 0px; position: absolute; width: 756px">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 181px; margin-left: 15px; left: 11px; top: 24px; position: absolute; width: 702px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectInputText action="#{Education$EducationRequestPage.txtRequesterFullName_action}"
                                                                binding="#{Education$EducationRequestPage.txtRequesterFullName}" id="txtRequesterFullName"
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
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 180px; top: 50px; position: absolute; width: 489px"/>
                                                            <ice:inputText action="#{Education$EducationRequestPage.txtRequesterId_action}"
                                                                binding="#{Education$EducationRequestPage.txtRequesterId}" id="txtRequesterId" immediate="true"
                                                                partialSubmit="true" style="left: 526px; top: 22px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 26px; top: 26px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 26px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 180px; top: 76px; position: absolute; width: 489px"/>
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnSearchRequester_action}"
                                                                id="btnSearchRequester" image="/resources/images/fig_search.gif"
                                                                style="left: 624px; top: 26px; position: absolute" value="possi"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtBirthDate}" disabled="true"
                                                                id="txtBirthDate" rendered="false" style="left: 180px; top: 128px; position: absolute; width: 130px"/>
                                                            <ice:outputLabel binding="#{Education$EducationRequestPage.lblDeptID}" id="lblDeptID"
                                                                rendered="false" style="height: 19px; left: 494px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel"
                                                                style="left: 26px; top: 104px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:outputLabel id="lblRequesterProgramName"
                                                                style="left: 26px; top: 130px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtlblRequesterEdLevel}" disabled="true"
                                                                id="txtlblRequesterEdLevel" style="left: 180px; top: 102px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtlblRequesterProgramName}"
                                                                disabled="true" id="txtlblRequesterProgramName" style="left: 180px; top: 128px; position: absolute; width: 239px"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterId" id="message1"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 480px; top: 24px; position: absolute; width: 46px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterEdLevel"
                                                                id="message2" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 96px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtlblRequesterProgramName"
                                                                id="message3" infoClass="infoMessage"
                                                                style="height: 20px; left: 432px; top: 120px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterFullName"
                                                                id="message4" infoClass="infoMessage"
                                                                style="height: 20px; left: 384px; top: 24px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterDepartment"
                                                                id="message5" infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 48px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtRequesterPosition"
                                                                id="message6" infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution" layout="flow"
                                                            style="height: 171px; margin-left: 15px; left: 11px; top: 234px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel binding="#{Education$EducationRequestPage.lblEdurequstStstusdataB}"
                                                                id="lblEdurequstStstusdataB" style="border-bottom: solid purple 1px; font-style: normal; font-weight: bold; left: 576px; top: 0px; position: absolute; width: 119px"/>
                                                            <ice:outputText id="lblInstitutionAccredited"
                                                                style="font-size: 10px; font-size: 10px; font-family: 'Cambria'; height: 17px; left: 408px; top: 72px; position: absolute; width: 141px" value="#{msgse.Accredited}"/>
                                                            <ice:outputText id="lblLocationInsideEthiopia"
                                                                style="font-size: 10px; font-family: 'Cambria'; height: 17px; left: 408px; top: 120px; position: absolute; width: 141px" value="#{msgse.InsideOutside}"/>
                                                            <ice:outputLabel id="lblInstitutionName"
                                                                style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblInstitutionAddress"
                                                                style="font-size: 10px; left: 24px; top: 96px; position: absolute" value="#{msgse.InstitutionAddress}"/>
                                                            <ice:inputTextarea binding="#{Education$EducationRequestPage.txtaInstitutionAddress}"
                                                                disabled="true" id="txtaInstitutionAddress" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 78px; left: 142px; top: 70px; position: absolute; width: 239px"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlInstitutionName}" disabled="true"
                                                                id="drlInstitutionName" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); left: 144px; top: 46px; position: absolute; width: 239px"
                                                                validator="#{Education$EducationRequestPage.drlInstitutionName_validate}" valueChangeListener="#{Education$EducationRequestPage.drlInstitutionName_processValueChange}">
                                                                <f:selectItems id="selectOneMenu1selectItems" value="#{Education$EducationRequestPage.nameOfInstitution}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtAccred}" disabled="true" id="txtAccred" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 23px; left: 550px; top: 70px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtInsideOut}" disabled="true"
                                                                id="txtInsideOut" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 25px; left: 550px; top: 118px; position: absolute; width: 129px"/>
                                                            <ice:outputLabel binding="#{Education$EducationRequestPage.lblEdurequstStstus}"
                                                                id="lblEdurequstStstus"
                                                                style="font-size: 10px; height: 17px; left: 384px; top: 0px; position: absolute" value="Educational Status Requst For:-"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlInstitutionName"
                                                                id="message7" infoClass="infoMessage"
                                                                style="height: 20px; left: 384px; top: 48px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest" layout="flow"
                                                            style="height: 257px; margin-left: 15px; left: 9px; top: 672px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblCostPerCreditHour"
                                                                style="font-size: 10px; left: 336px; top: 48px; position: absolute" value="#{msgse.Costpercredit}"/>
                                                            <ice:outputLabel id="lblAdminstrativeCost"
                                                                style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.AdminstrativeCost}"/>
                                                            <ice:outputLabel id="lblDurationInYear"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.DurationInYear}"/>
                                                            <ice:outputLabel id="lblNumberOfCreditHours"
                                                                style="font-size: 10px; left: 336px; top: 72px; position: absolute" value="#{msgse.Noofcredit}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber"
                                                                style="font-size: 10px; left: 26px; top: 104px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblRemark"
                                                                style="font-size: 10px; height: 19px; left: 26px; top: 156px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText action="#{Education$EducationRequestPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$EducationRequestPage.txtCostPerCreditHour}" id="txtCostPerCreditHour" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 492px; top: 50px; position: absolute; width: 103px"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtNumberOfCreditHours}"
                                                                id="txtNumberOfCreditHours" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 492px; top: 76px; position: absolute; width: 103px"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtDocumentReferenceNumber}"
                                                                id="txtDocumentReferenceNumber" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 102px; position: absolute; width: 109px"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtDurationInYear}" id="txtDurationInYear" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 76px; position: absolute; width: 109px"/>
                                                            <ice:inputTextarea binding="#{Education$EducationRequestPage.txtRemark}" id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 51px; left: 128px; top: 128px; position: absolute; width: 545px"/>
                                                            <ice:commandLink action="#{Education$EducationRequestPage.lnkViewPrevieousDecisions_action}"
                                                                binding="#{Education$EducationRequestPage.lnkViewPrevieousDecisions}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 494px; top: 208px; position: absolute" value="View status of  this request"/>
                                                            <ice:inputText action="#{Education$EducationRequestPage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$EducationRequestPage.txtTotalAdminstrativeCost}"
                                                                id="txtTotalAdminstrativeCost" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 128px; top: 50px; position: absolute; width: 107px"/>
                                                            <ice:commandLink action="#{Education$EducationRequestPage.lnkViewsatusOfEducation_action}"
                                                                binding="#{Education$EducationRequestPage.lnkViewsatusOfEducation}" id="lnkViewsatusOfEducation"
                                                                rendered="false"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 26px; top: 234px; position: absolute" value="Register Educational Status"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtTotalAdminstrativeCost"
                                                                id="message12" infoClass="infoMessage"
                                                                style="height: 20px; left: 240px; top: 48px; position: absolute; width: 69px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDurationInYear"
                                                                id="message13" infoClass="infoMessage"
                                                                style="height: 20px; left: 240px; top: 72px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtCostPerCreditHour"
                                                                id="message14" infoClass="infoMessage"
                                                                style="height: 20px; left: 600px; top: 48px; position: absolute; width: 88px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtNumberOfCreditHours"
                                                                id="message15" infoClass="infoMessage"
                                                                style="position: absolute; left: 600px; top: 72px; width: 88px; height: 20px;" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtDocumentReferenceNumber"
                                                                id="message16" infoClass="infoMessage"
                                                                style="height: 20px; left: 240px; top: 96px; position: absolute; width: 45px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 45px; left: 24px; top: 936px; overflow: auto; position: absolute; width: 695px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnSaveOrUpdate_action}"
                                                                binding="#{Education$EducationRequestPage.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 96px; top: -10px; position: absolute; width: 120px" value="#{Education$EducationRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnReset_action}"
                                                                binding="#{Education$EducationRequestPage.btnReset}" id="btnReset"
                                                                style="left: 288px; top: -10px; position: absolute; width: 120px" value="#{msgse.btnRest}"/>
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnDelete_action}"
                                                                binding="#{Education$EducationRequestPage.btnDelete}" id="btnDelete"
                                                                style="left: 480px; top: -10px; position: absolute; width: 120px" value="#{msgse.btnDelete}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution1" layout="flow"
                                                            style="height: 213px; margin-left: 15px; left: 9px; top: 432px; overflow: auto; position: absolute; width: 703px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlEducationLevelCatagory}"
                                                                disabled="true" id="drlEducationLevelCatagory" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 72px; position: absolute; width: 215px"
                                                                value="#{Education$EducationRequestPage.selectObjectOfEducationLevelCatagory.selectedObject}" valueChangeListener="#{Education$EducationRequestPage.drlEducationLevelCatagory_processValueChange}">
                                                                <f:selectItems id="selectOneMenuEducationLevelCatagory" value="#{Education$EducationRequestPage.educationLevelCatagoryList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblEducationLevel"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlEducationShift}"
                                                                id="drlEducationShift" partialSubmit="true"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 94px; position: absolute; width: 215px" value="#{Education$EducationRequestPage.selectObjectOfEducationShiftCatagory.selectedObject}">
                                                                <f:selectItems id="selectOneMenuEducationShift" value="#{Education$EducationRequestPage.educationShiftList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblxxDurationInYear"
                                                                style="font-size: 10px; left: 408px; top: 96px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblProgramName"
                                                                style="font-size: 10px; left: 24px; top: 96px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 118px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblStartDate"
                                                                style="font-size: 10px; left: 408px; top: 144px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate"
                                                                style="font-size: 10px; left: 408px; top: 120px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnCalendarSatartDate_action}"
                                                                binding="#{Education$EducationRequestPage.btnCalendarSatartDate}" id="btnCalendarSatartDate"
                                                                image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 648px; top: 144px; position: absolute" value="submit"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 142px; position: absolute; width: 155px"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlProgramName}" id="drlProgramName"
                                                                partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 100px; position: absolute; width: 215px">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Education$EducationRequestPage.fieldOfStu}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationRequestPage.chkHigher}" id="chkHigher"
                                                                partialSubmit="true" style="left: 24px; top: 24px; position: absolute"
                                                                value="#{Education$EducationRequestPage.defaultSelectedData10.selectedBoolean}" valueChangeListener="#{Education$EducationRequestPage.chkHigher_processValueChange}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationRequestPage.chkBAsic}" id="chkBAsic"
                                                                partialSubmit="true" style="left: 262px; top: 22px; position: absolute"
                                                                value="#{Education$EducationRequestPage.defaultSelectedData11.selectedBoolean}" valueChangeListener="#{Education$EducationRequestPage.chkBAsic_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$EducationRequestPage.calStartDate}" id="calStartDate"
                                                                rendered="false"
                                                                style="left:400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                                value="#{Education$EducationRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationRequestPage.calStartDate_processValueChange}"/>
                                                            <ice:outputLabel id="lblEducationLevelHigher"
                                                                style="font-size: 10px; left: 48px; top: 24px; position: absolute" value="#{msgse.HilevelEduc}"/>
                                                            <ice:selectInputDate binding="#{Education$EducationRequestPage.calAppliedDate}" id="calAppliedDate"
                                                                rendered="false"
                                                                style="left: 400px; top: 0px; position: absolute; height:180px; width: 190px; z-index:150"
                                                                value="#{Education$EducationRequestPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$EducationRequestPage.calAppliedDate_processValueChange}"/>
                                                            <ice:outputLabel id="lblEducationLevelBAsic"
                                                                style="font-size: 10px; left: 288px; top: 24px; position: absolute" value="#{msgse.BasicLevel}"/>
                                                            <ice:inputText binding="#{Education$EducationRequestPage.txtEndDate}" disabled="true"
                                                                id="txtEndDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 478px; top: 166px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblEndDate"
                                                                style="font-size: 10px; left: 408px; top: 168px; position: absolute" value="#{msgse.Enddate}"/>
                                                            <ice:commandButton action="#{Education$EducationRequestPage.btnEndDate_action}"
                                                                binding="#{Education$EducationRequestPage.btnEndDate}" id="btnEndDate"
                                                                image="/resources/images/cal_button.gif" immediate="true"
                                                                style="left: 648px; top: 168px; position: absolute" value="submit"/>
                                                            <ice:outputLabel id="lblDrivingSkill"
                                                                style="font-size: 10px; left: 480px; top: 24px; position: absolute" value="#{msgse.DrivingSkill}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationRequestPage.chkdrivingSkill}"
                                                                id="chkdrivingSkill" partialSubmit="true" style="left: 454px; top: 22px; position: absolute"
                                                                value="#{Education$EducationRequestPage.defaultSelectedData12.selectedBoolean}" valueChangeListener="#{Education$EducationRequestPage.chkdrivingSkill_processValueChange}"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlEducationShift"
                                                                id="message8" infoClass="infoMessage"
                                                                style="height: 20px; left: 336px; top: 144px; position: absolute; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlProgramName" id="message9"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 336px; top: 96px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtStartDate" id="message10"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 144px; position: absolute; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtEndDate" id="message11"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 672px; top: 168px; position: absolute; width: 22px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlEducationLevelCatagory"
                                                                id="message17" infoClass="infoMessage"
                                                                style="height: 20px; left: 336px; top: 72px; position: absolute; width: 21px" warnClass="warnMessage"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationRequestPage.chkAllEducation}"
                                                                id="chkAllEducation" partialSubmit="true" style="left: 94px; top: 142px; position: absolute"
                                                                value="#{Education$EducationRequestPage.defaultSelectedData13.selectedBoolean}" valueChangeListener="#{Education$EducationRequestPage.chkAllEducation_processValueChange}"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlAllPrograms}" disabled="true"
                                                                id="drlAllPrograms" partialSubmit="true" rendered="false"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 120px; top: 144px; position: absolute; width: 215px" value="#{Education$EducationRequestPage.defaultSelectedData14.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems3" value="#{Education$EducationRequestPage.allFieldOfStu}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblAllProgram"
                                                                style="font-size: 10px; height: 43px; left: 24px; top: 120px; position: absolute; width: 69px" value="#{msgse.AllprogramName}"/>
                                                            <ice:message errorClass="iceMsgError errorMessage" fatalClass="iceMsgFatal fatalMessage"
                                                                for="txtAppliedDate" id="message18" infoClass="iceMsgInfo infoMessage"
                                                                style="height: 20px; left: 648px; top: 120px; position: absolute; width: 22px" warnClass="iceMsgWarn warnMessage"/>
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
                                                href="http://www.insa.gov.et" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationRequestPage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px;z-index:1000" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationRequestPage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationRequestPage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationRequestPage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationRequestPage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationRequestPage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$EducationRequestPage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$EducationRequestPage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$EducationRequestPage.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationRequestPage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$EducationRequestPage.btnCloseViewPreviesDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationRequestPage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationRequestPage.pnlPopupEduactionaStatus}" draggable="true"
                            id="pnlPopupEduactionaStatus" modal="true" rendered="false" style="height: 261px;  position: absolute; width: 645px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupEducationalStatus" style="display: block; height: 20px" width="610">
                                    <ice:outputText dir="left" id="otxtEducationalStatus" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - Register Educational status "/>
                                    <ice:commandLink action="#{Education$EducationRequestPage.btnCloseEducationalStatus_action}"
                                        binding="#{Education$EducationRequestPage.btnCloseEducationalStatus}" id="btnCloseEducationalStatus"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 621px; top: -20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupRegisterTakenRevokedDateBody" style="display: block; height: 206px; top: 20px" width="610">
                                    <ice:panelLayout id="pnlLayoutPopupTable1">
                                        <ice:outputLabel id="lblDAte" style="height: 20px; left: 26px; top: 26px; position: absolute; width: 128px" value="Date"/>
                                        <ice:outputLabel binding="#{Education$EducationRequestPage.lblRequesterID}" id="lblRequesterID" rendered="false" style="left: 520px; top: -104px; position: absolute; width: 50px"/>
                                        <ice:outputLabel binding="#{Education$EducationRequestPage.lblEduRequestId}" id="lblEduRequestId" rendered="false" style="left: 468px; top: -104px; position: absolute; width: 24px"/>
                                        <ice:outputLabel id="lblEducationLStaus" style="left: 26px; top: 0px; position: absolute; width: 104px" value="Educational Status"/>
                                        <ice:commandButton action="#{Education$EducationRequestPage.btnCaldate_action}" id="btnCaldate"
                                            image="/resources/images/cal_icon.JPG" immediate="true" style="left: 338px; top: 26px; position: absolute" value="submit"/>
                                        <ice:commandButton action="#{Education$EducationRequestPage.btnSavePop_action}" id="btnSavePop"
                                            style="height: 26px; left: 182px; top: 120px; position: absolute; width: 71px" value="Save"/>
                                        <ice:inputText binding="#{Education$EducationRequestPage.txtdate}" disabled="true" id="txtdate" immediate="true" style="left: 154px; top: 24px; position: absolute; width: 182px"/>
                                        <ice:selectInputDate binding="#{Education$EducationRequestPage.calTakenRevokedStartDate}" id="calTakenRevokedStartDate"
                                            rendered="false" style="left: 325px; top: 45px; position: absolute; height:212px; width: 190px"
                                            value="#{Education$EducationRequestPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationRequestPage.calTakenRevokedStartDate_processValueChange}"/>
                                        <ice:selectOneMenu binding="#{Education$EducationRequestPage.drlEducationRegisStatus}" id="drlEducationRegisStatus"
                                            partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 22px; left: 154px; top: -2px; position: absolute; width: 208px">
                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Education$EducationRequestPage.educationalStatus}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputLabel id="lblEduRequestId1" style="width: 24px"/>
                                        <ice:commandButton action="#{Education$EducationRequestPage.btnResetPop_action}" id="btnResetPop"
                                            style="height: 26px; left: 260px; top: 120px; position: absolute; width: 71px" value="Reset"/>
                                        <ice:inputTextarea binding="#{Education$EducationRequestPage.txtReason}" id="txtReason"
                                            style="solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94);height: 52px; left: 154px; top: 50px; position: absolute; width: 208px" valueChangeListener="#{Education$EducationRequestPage.txtReason_processValueChange}"/>
                                        <ice:outputLabel id="lbReason" style="txtReasonheight: 46px; left: 26px; top: 52px; position: absolute; width: 128px" value="Reason of Changing Status"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>