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
                <title>Change Institution Request Approve</title>
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
                    function ChangeInstitutionApprovePageNew(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="left: -16px; top: -352px; position: absolute">
                        <img alt="" class="source-image" height="1400px" id="img" src="../resources/images/WholePageBG.png"/>
                        <ice:panelBorder height="1250" id="whole_page" renderCenter="#{Education$ChangeInstitutionApprovePageNew.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$ChangeInstitutionApprovePageNew.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$ChangeInstitutionApprovePageNew.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$ChangeInstitutionApprovePageNew.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$ChangeInstitutionApprovePageNew.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                                            <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.lnkEducationRequest_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkEducationRequest}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$ChangeInstitutionApprovePageNew.lnkEducationPaymentRequest_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkEducationPaymentRequest}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.lnkEducationApprove_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkEducationApprove}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$ChangeInstitutionApprovePageNew.lnkEducationPaymentApprove_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkEducationPaymentApprove}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink
                                                                action="#{Education$ChangeInstitutionApprovePageNew.lnkChangeInstituRequest_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkChangeInstituRequest}"
                                                                id="lnkChangeInstituRequest" style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.lnkChangeInstApprove_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.lnkChangeInstApprove}"
                                                                id="lnkChangeInstApprove" style="color:#306682;font-weight:bold" value="Change Institution Approve"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.lnkInstRegistration_action}"
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
                                                            <ice:selectOneListbox binding="#{Education$ChangeInstitutionApprovePageNew.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                validator="#{Education$ChangeInstitutionApprovePageNew.selectMyRequestLists_validate}"
                                                                value="#{Education$ChangeInstitutionApprovePageNew.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$ChangeInstitutionApprovePageNew.requestListsToBeApproved}"/>
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
                                                                value="#{Education$ChangeInstitutionApprovePageNew.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$ChangeInstitutionApprovePageNew.requestHistoryList}"/>
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
                                <ice:panelGroup dragListener="#{Education$ChangeInstitutionApprovePageNew.page_display_processMyEvent}" id="page_display" style="height: 1250px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1250px; left: 0px; position: relative; width: 100%; -rave-layout: grid; top:10px" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1200px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="APPROVE CHANGE INSTITUTION REQUEST"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1200px; left: 0px; top: 15px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$ChangeInstitutionApprovePageNew.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1200px; top: 5px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" layout="flow" style="height: 1210px; left: 11px; top: -354px; position: absolute; width: 100%; -rave-layout: grid">
                                                        <ice:panelLayout id="pnlLayoutRequester" layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 179px; margin-left: 15px; left: 11px; top: 26px; position: absolute; width: 702px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblRequester" style="left: 10px; top:4px; position: absolute" value="#{msgse.Requester}"/>
                                                            <ice:outputLabel id="lblRequesterDepartment" style="left: 52px; top: 52px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 468px; top: 26px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtRequesterDepartment}"
                                                                disabled="true" id="txtRequesterDepartment" style="left: 206px; top: 50px; position: absolute; width: 467px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 492px; top: 24px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 48px; top: 24px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 52px; top: 78px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtRequesterPosition_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 206px; top: 76px; position: absolute; width: 467px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtRequesterFullName}"
                                                                disabled="true" id="txtRequesterFullName" style="left: 206px; top: 24px; position: absolute; width: 233px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtlblRequesterEdLevel}"
                                                                disabled="true" id="txtlblRequesterEdLevel" style="left: 206px; top: 102px; position: absolute; width: 239px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtlblRequesterProgramName}"
                                                                disabled="true" id="txtlblRequesterProgramName" style="left: 206px; top: 128px; position: absolute; width: 239px"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel1"
                                                                style="left: 52px; top: 104px; position: absolute; width: 153px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:outputLabel id="lblRequesterProgramName1"
                                                                style="left: 52px; top: 130px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons" layout="flow"
                                                            style="height: 54px; margin-left: 15px; left: 11px; top: 1118px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnSaveOrUpdate_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.btnSaveOrUpdate}" id="btnSaveOrUpdate"
                                                                style="left: 208px; top: 0px; position: absolute; width: 71px" value="#{OverTime$OverTimeRequestPage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnReset_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.btnReset}" id="btnReset"
                                                                style="left: 338px; top: 0px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout binding="#{Education$ChangeInstitutionApprovePageNew.pnlLayputInstitution2}"
                                                            id="pnlLayputInstitution2"
                                                            style="height: 173px; margin-left: 15px; left: 345px; top: 234px; overflow: auto; position: absolute; width: 381px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputText id="lblInstitutionAccredited1"
                                                                style="font-size: 10px; font-family: 'Cambria'; height: 19px; left: 48px; top: 144px; position: absolute; width: 77px" value="#{msgse.Accredited}"/>
                                                            <ice:outputText id="lblLocationInsideEthiopia1"
                                                                style="font-size: 10px; font-family: 'Cambria'; left: 48px; top: 120px; position: absolute" value="#{msgse.InsideOutside}"/>
                                                            <ice:outputLabel id="lblInstitutionName1"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblInstitutionAddress1"
                                                                style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.InstitutionAddress}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtAccredNEw}" disabled="true"
                                                                id="txtAccredNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 142px; position: absolute; width: 161px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtInsideOutNEw}"
                                                                disabled="true" id="txtInsideOutNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 118px; position: absolute; width: 161px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionApprovePageNew.txtaInstitutionAddressNew}"
                                                                disabled="true" id="txtaInstitutionAddressNew"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 49px; left: 142px; top: 46px; position: absolute; width: 181px" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.txtaInstitutionAddressNew_processValueChange}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txInstNAme}" disabled="true"
                                                                id="txInstNAme" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 22px; position: absolute; width: 161px"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblInstId}" id="lblInstId"
                                                                rendered="false" style="height: 17px; left: 288px; top: 96px; position: absolute; width: 69px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution3"
                                                            style="height: 189px; margin-left: 15px; left: 345px; top: 428px; overflow: auto; position: absolute; width: 381px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel1"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel id="lblxxDurationInYear1"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblProgramName1"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtAppliedDateNew}"
                                                                id="txtAppliedDateNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 94px; position: absolute; width: 155px"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionApprovePageNew.calAppliedDateNew}"
                                                                id="calAppliedDateNew" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px" value="#{Education$ChangeInstitutionApprovePageNew.selectInputDate1Bean.date1}"/>
                                                            <ice:selectInputDate binding="#{Education$ChangeInstitutionApprovePageNew.calStartDateNEw}"
                                                                id="calStartDateNEw" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px" value="#{Education$ChangeInstitutionApprovePageNew.selectInputDate1Bean.date1}"/>
                                                            <ice:outputLabel id="lblStartDate1"
                                                                style="font-size: 10px; left: 24px; top: 120px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate1"
                                                                style="font-size: 10px; left: 24px; top: 96px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtStartDateNEw}"
                                                                id="txtStartDateNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 118px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtLevelNew}" id="txtLevelNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtProgramTypeNew}"
                                                                id="txtProgramTypeNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtShiftNew}" id="txtShiftNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblendDate1"
                                                                style="font-size: 10px; height: 17px; left: 24px; top: 144px; position: absolute; width: 69px" value="#{msgse.Enddate}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtendDateNew}" disabled="true"
                                                                id="txtendDateNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 23px; left: 118px; top: 142px; position: absolute; width: 155px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest1"
                                                            style="height: 214px; margin-left: 15px; left: 345px; top: 624px; overflow: auto; position: absolute; width: 381px; -rave-layout: grid" styleClass="insideContainerMain">
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
                                                                style="font-size: 10px; height: 19px; left: 24px; top: 168px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtCostPerCreditHourNew}"
                                                                id="txtCostPerCreditHourNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtNumberOfCreditHoursNew}"
                                                                id="txtNumberOfCreditHoursNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDocumentReferenceNumberNew}"
                                                                id="txtDocumentReferenceNumberNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 118px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDurationInYearNEw}"
                                                                id="txtDurationInYearNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 129px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionApprovePageNew.txtRemarkNEw}"
                                                                id="txtRemarkNEw" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 47px; left: 166px; top: 142px; position: absolute; width: 191px"/>
                                                            <ice:selectInputDate id="calStartDate1" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px" value="#{Education$ChangeInstitutionApprovePageNew.selectInputDate1Bean.date1}"/>
                                                            <ice:selectInputDate id="calAppliedDate1" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px" value="#{Education$ChangeInstitutionApprovePageNew.selectInputDateBean2.date1}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtTotalAdminstrativeCostNew}"
                                                                id="txtTotalAdminstrativeCostNew" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 129px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutDecider1"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 243px; margin-left: 15px; left: 11px; top: 858px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblDeciderDepartment1" style="left: 24px; top: 48px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblDeciderId1" style="left: 419px; top: 14px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDeciderDepartment}"
                                                                disabled="true" id="txtDeciderDepartment" style="left: 118px; top: 46px; position: absolute; width: 526px"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtDeciderId_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtDeciderId}" disabled="true"
                                                                id="txtDeciderId" style="left: 495px; top: 14px; position: absolute; width: 137px"/>
                                                            <ice:outputLabel id="lblDeciderFullName" style="left: 24px; top: 0px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="deciderPosition1" style="left: 24px; top: 72px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtDeciderFullName_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtDeciderFullName}" disabled="true"
                                                                id="txtDeciderFullName" style="left: 118px; top: 11px; position: absolute; width: 196px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDeciderPosition}"
                                                                disabled="true" id="txtDeciderPosition" style="left: 118px; top: 81px; position: absolute; width: 527px"/>
                                                            <ice:selectOneMenu binding="#{Education$ChangeInstitutionApprovePageNew.drlDecision}"
                                                                id="drlDecision" partialSubmit="true"
                                                                style="height: 23px; left: 120px; top: 115px; position: absolute; width: 190px" value="#{Education$ChangeInstitutionApprovePageNew.selectedObjectOneMenuDecisionType.selectedObject}">
                                                                <f:selectItems id="selectDecisionAvailable1" value="#{Education$ChangeInstitutionApprovePageNew.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel id="lblDecision1" style="left: 20px; top: 108px; position: absolute" value="#{msgse.Decision}"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionApprovePageNew.txtaDeciderComment}"
                                                                id="txtaDeciderComment" style="left: 122px; top: 151px; position: absolute; width: 524px" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.txtaDeciderComment_processValueChange}"/>
                                                            <ice:outputLabel id="lblDeciderComment1" style="left: 23px; top: 145px; position: absolute" value="#{msgse.Comment}"/>
                                                            <ice:commandLink
                                                                action="#{Education$ChangeInstitutionApprovePageNew.lnkViewPrevieousDecisions_action}"
                                                                id="lnkViewPrevieousDecisions"
                                                                style="color: rgb(48, 102, 130); font-weight: bold; left: 494px; top: 115px; position: absolute" value="View previous decisions"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlDecision" id="message1"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 336px; top: 120px; position: absolute; width: 69px" warnClass="warnMessage"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution1" layout="flow"
                                                            style="height: 179px; margin-left: 15px; left: 9px; top: 234px; overflow: auto; position: absolute; width: 310px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblInstitutionName2"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lbledRequId1" rendered="false" style="height: 19px; left: 0px; top: 0px; position: absolute"/>
                                                            <ice:outputLabel id="lblchangeInstituId1" rendered="false" style="height: 19px; left: 312px; top: 0px; position: absolute"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtInstNAmePrev}"
                                                                id="txtInstNAmePrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 118px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblInstitutionID}"
                                                                id="lblInstitutionID" rendered="false" style="height: 17px; left: 120px; top: 120px; position: absolute"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution4" layout="flow"
                                                            style="height: 189px; margin-left: 15px; left: 9px; top: 428px; overflow: auto; position: absolute; width: 309px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel2"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel id="lblxxDurationInYear2"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblProgramName2"
                                                                style="font-size: 10px; left: 24px; top: 48px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtAppliedDate_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtAppliedDatePrev}"
                                                                id="txtAppliedDatePrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 94px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblStartDate2"
                                                                style="font-size: 10px; left: 24px; top: 120px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate2"
                                                                style="font-size: 10px; left: 24px; top: 96px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtStartDatePrev}"
                                                                id="txtStartDatePrev"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 118px; position: absolute; width: 155px" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.txtStartDate_processValueChange}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtLevelPrev}" id="txtLevelPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 22px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtProgramNamePrev}"
                                                                id="txtProgramNamePrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 46px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtShiftPrev}" id="txtShiftPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 142px; top: 70px; position: absolute; width: 155px"/>
                                                            <ice:outputLabel id="lblendDate"
                                                                style="font-size: 10px; height: 17px; left: 24px; top: 144px; position: absolute" value="#{msgse.Enddate}"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtendDate}" disabled="true"
                                                                id="txtendDate" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 23px; left: 142px; top: 142px; position: absolute; width: 155px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest2" layout="flow"
                                                            style="height: 208px; margin-left: 15px; left: 9px; top: 624px; overflow: auto; position: absolute; width: 309px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblCostPerCreditHour2"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.Costpercredit}"/>
                                                            <ice:outputLabel id="lblAdminstrativeCost2"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Totaladministrativecost}"/>
                                                            <ice:outputLabel id="lblDurationInYear2"
                                                                style="font-size: 10px; left: 26px; top: 52px; position: absolute" value="#{msgse.DurationInYear}"/>
                                                            <ice:outputLabel id="lblNumberOfCreditHours2"
                                                                style="font-size: 10px; height: 19px; left: 26px; top: 104px; position: absolute; width: 127px" value="#{msgse.Noofcredit}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber2"
                                                                style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblRemark2"
                                                                style="font-size: 10px; height: 19px; left: 26px; top: 156px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtCostPerCreditHourPrev}" disabled="true"
                                                                id="txtCostPerCreditHourPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 70px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtNumberOfCreditHoursPrev}"
                                                                disabled="true" id="txtNumberOfCreditHoursPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 94px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDocumentReferenceNumberPrev}"
                                                                disabled="true" id="txtDocumentReferenceNumberPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 118px; position: absolute; width: 129px"/>
                                                            <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtDurationInYearPrev}"
                                                                disabled="true" id="txtDurationInYearPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 46px; position: absolute; width: 129px"/>
                                                            <ice:inputTextarea binding="#{Education$ChangeInstitutionApprovePageNew.txtRemarkPrev}"
                                                                disabled="true" id="txtRemarkPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; height: 51px; left: 94px; top: 142px; position: absolute; width: 192px"/>
                                                            <ice:selectInputDate id="calStartDate2" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate id="calAppliedDate2" rendered="false"
                                                                style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$ChangeInstitutionPage.selectInputDateBean2.date1}" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.calAppliedDate_processValueChange}"/>
                                                            <ice:inputText action="#{Education$ChangeInstitutionApprovePageNew.txtCostPerCreditHour_action}"
                                                                binding="#{Education$ChangeInstitutionApprovePageNew.txtTotalAdminsPrev}" disabled="true"
                                                                id="txtTotalAdminsPrev" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 166px; top: 22px; position: absolute; width: 130px"/>
                                                        </ice:panelLayout>
                                                        <ice:outputLabel id="lblInstitutionName3"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 144px; top: 216px; position: absolute" value="Institution Information"/>
                                                        <ice:outputLabel id="lblInstitutionName4"
                                                            style="font-size: 10px; font-weight: bold; height: 18px; left: 576px; top: 216px; position: absolute" value="Institution Information"/>
                                                        <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblPrev}" id="lblPrev"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 72px; top: 216px; position: absolute; width: 69px" value="Previous"/>
                                                        <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblNew}" id="lblNew"
                                                            style="font-size: 10px; font-weight: bold; height: 19px; left: 504px; top: 216px; position: absolute; width: 69px" value="New"/>
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
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionApprovePageNew.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 800px; position: absolute; width: 751px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$ChangeInstitutionApprovePageNew.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$ChangeInstitutionApprovePageNew.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblSuccessOrErrorMessage}"
                                            id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionApprovePageNew.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$ChangeInstitutionApprovePageNew.outputTextConfirmDelete}"
                                            id="outputTextConfirmDelete" style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnPopupCancelDelete_action}"
                                            id="btnPopupCancelDelete" style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionApprovePageNew.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$ChangeInstitutionApprovePageNew.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{Education$ChangeInstitutionApprovePageNew.pnlPopupEduactionaStatus}" draggable="true"
                            id="pnlPopupEduactionaStatus" modal="true" rendered="false" style="height: 261px;  position: absolute; width: 645px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupEducationalStatus" style="display: block; height: 20px" width="610">
                                    <ice:outputText dir="left" id="otxtEducationalStatus" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - Register Educational status "/>
                                    <ice:commandLink action="#{Education$ChangeInstitutionApprovePageNew.btnClosePopupEducationalStatus_action}"
                                        binding="#{Education$ChangeInstitutionApprovePageNew.btnClosePopupEducationalStatus}"
                                        id="btnClosePopupEducationalStatus"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 621px; top: 3px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupRegisterTakenRevokedDateBody" style="display: block; height: 206px; top: 20px" width="610">
                                    <ice:panelLayout id="pnlLayoutPopupTable1">
                                        <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblRequesterID}" id="lblRequesterID" style="left: 520px; top: -104px; position: absolute; width: 50px"/>
                                        <ice:outputLabel binding="#{Education$ChangeInstitutionApprovePageNew.lblEduRequestId}" id="lblEduRequestId" style="left: 468px; top: -104px; position: absolute; width: 24px"/>
                                        <ice:outputLabel id="lblEducationLStaus" style="left: 26px; top: 26px; position: absolute; width: 104px" value="Educational Status"/>
                                        <ice:outputLabel id="lblDAte" style="left: 26px; top: 52px; position: absolute" value="Date"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnCaldate_action}" id="btnCaldate"
                                            image="/resources/images/cal_icon.JPG" immediate="true" style="left: 312px; top: 52px; position: absolute" value="submit"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnSavePop_action}" id="btnSavePop"
                                            style="left: 156px; top: 120px; position: absolute; width: 71px" value="Save"/>
                                        <ice:inputText binding="#{Education$ChangeInstitutionApprovePageNew.txtdate}" disabled="true" id="txtdate"
                                            immediate="true" style="left: 128px; top: 50px; position: absolute; width: 182px"/>
                                        <ice:selectInputDate binding="#{Education$ChangeInstitutionApprovePageNew.calTakenRevokedStartDate}"
                                            id="calTakenRevokedStartDate" rendered="false"
                                            style="left: 325px; top: 45px; position: absolute; height:212px; width: 190px"
                                            value="#{Education$ChangeInstitutionApprovePageNew.selectInputDate1Bean.date1}" valueChangeListener="#{Education$ChangeInstitutionApprovePageNew.calTakenRevokedStartDate_processValueChange}"/>
                                        <ice:selectOneMenu binding="#{Education$ChangeInstitutionApprovePageNew.drlEducationRegisStatus}"
                                            id="drlEducationRegisStatus" partialSubmit="true" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); height: 22px; left: 128px; top: 24px; position: absolute; width: 208px">
                                            <f:selectItems id="selectOneMenu1selectItems2" value="#{Education$ChangeInstitutionApprovePageNew.educationalStatus}"/>
                                        </ice:selectOneMenu>
                                        <ice:outputLabel id="lblEduRequestId1" style="width: 24px"/>
                                        <ice:commandButton action="#{Education$ChangeInstitutionApprovePageNew.btnResetPop_action}" id="btnResetPop"
                                            style="left: 260px; top: 120px; position: absolute; width: 71px" value="Reset"/>
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