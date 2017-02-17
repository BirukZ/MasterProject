<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : selectMyRequestListsDavePro
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <f:loadBundle basename="Localization.HRLocalization_Education" var="msgse"/>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
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
                    function EducationApprovePage(field){

                        if (field.defaultValue == field.value) field.value = '';
                        else if (field.value == '') field.value = field.defaultValue;

                    }
                </script>
            </head>
            <body id="outputBody1" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div>
                        <ice:panelBorder id="whole_page" renderCenter="#{Education$EducationApprovePage.panelBorder1Bean.renderCenter}"
                            renderEast="#{Education$EducationApprovePage.panelBorder1Bean.renderEast}"
                            renderNorth="#{Education$EducationApprovePage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{Education$EducationApprovePage.panelBorder1Bean.renderSouth}"
                            renderWest="#{Education$EducationApprovePage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
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
                                <ice:panelGroup id="menu_left" style="border:none; height:800px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:790px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height:770px; left: -4px; position: absolute; width: 213px" styleClass="left_menu">
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
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkEducationRequest_action}"
                                                                id="lnkEducationRequest" style="color:#306682;font-weight:bold" value="Education Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkEducationPaymentRequest_action}"
                                                                id="lnkEducationPaymentRequest" style="color:#306682;font-weight:bold" value="Education Payment Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkEducationApprove_action}"
                                                                id="lnkEducationApprove" style="color:#306682;font-weight:bold" value="Process Educ. Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkEducationPaymentApprove_action}"
                                                                id="lnkEducationPaymentApprove" style="color:#306682;font-weight:bold" value="Process Educ. Payment"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkChangeiNstitutionReq_action}"
                                                                binding="#{Education$EducationApprovePage.lnkChangeiNstitutionReq}" id="lnkChangeiNstitutionReq"
                                                                style="color:#306682;font-weight:bold" value="Change Institution Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkChangeInstApprove_action}"
                                                                binding="#{Education$EducationApprovePage.lnkChangeInstApprove}" id="lnkChangeInstApprove"
                                                                style="color:#306682;font-weight:bold" value="Process Change Instittion"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.lnkInstRegistration_action}"
                                                                binding="#{Education$EducationApprovePage.lnkInstRegistration}" id="lnkInstRegistration"
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
                                                            <ice:selectOneListbox binding="#{Education$EducationApprovePage.selectMyRequestLists}"
                                                                id="selectMyRequestLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                value="#{Education$EducationApprovePage.selectedRequestFromMyRequestList.selectedObject}" valueChangeListener="#{Education$EducationApprovePage.selectMyRequestLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxRequestListsToBeApproved" value="#{Education$EducationApprovePage.requestListsToBeApproved}"/>
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
                                                            <ice:selectOneListbox binding="#{Education$EducationApprovePage.selectMyHistoryLists}"
                                                                id="selectMyHistoryLists" partialSubmit="true" size="6" style="height: 180px; width: 190px"
                                                                validator="#{Education$EducationApprovePage.selectMyHistoryLists_validate}"
                                                                value="#{Education$EducationApprovePage.selectedRequestFromHistoryList.selectedObject}" valueChangeListener="#{Education$EducationApprovePage.selectMyHistoryLists_processValueChange}">
                                                                <f:selectItems id="selectOneListboxHistoryListsToBeViewed" value="#{Education$EducationApprovePage.requestHistoryList}"/>
                                                            </ice:selectOneListbox>
                                                        </ice:panelLayout>
                                                    </ice:panelGroup>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Commeete" style="border-style: none; height: 220px">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="status_Group_Header_Commeete">
                                                        <ice:outputText id="lblStatusCommittee" value="Forward To Committee"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="StatusBoardCommeete" width="100%">
                                                    <ice:panelGroup id="status_Group_Commeete" style="padding: 0px; background:transparent;border:none;display: block;float:left;height:190px; width: 100%">
                                                        <ice:panelLayout id="StatusContainerCommeete" style="height: 190px; position: absolute; width: 190px">
                                                            <ice:selectOneListbox binding="#{Education$EducationApprovePage.selectCommeete}" id="selectCommeete"
                                                                partialSubmit="true" size="7" style="position: relative; height: 150px; width: 190px" valueChangeListener="#{Education$EducationApprovePage.selectCommeete_processValueChange}">
                                                                <f:selectItems id="selectOneListbox3selectItemsCommeete" value="#{Education$EducationApprovePage.committeeForwardList}"/>
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
                                <ice:panelGroup id="page_display" style="height: 1381px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 1352px; left: 0px; top: 15px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 1380px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Manage Education request approval"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 1326px; left: 0px; top: 15px; position: absolute; width: 100%">
                                                <ice:panelGroup dragListener="#{Education$EducationApprovePage.RetirementApproval_processMyEvent}"
                                                    id="RetirementApproval" style="height: 1318px" styleClass="filedset_border">
                                                    <ice:panelLayout id="panelLayout1" style="height: 1308px; top: 0px; position: absolute; width: 780px">
                                                        <ice:panelLayout binding="#{Education$EducationApprovePage.pnlLayoutRequester}" id="pnlLayoutRequester"
                                                            layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 204px; margin-left: 15px; left: 9px; top: 24px; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtRequesterFullName}" disabled="true"
                                                                id="txtRequesterFullName" style="left: 190px; top: 46px; position: absolute; width: 233px" styleClass="inputText"/>
                                                            <ice:outputLabel id="lblRequesterDepartment"
                                                                style="height: 18px; left: 24px; top: 72px; position: absolute" value="#{msgse.Department}"/>
                                                            <ice:outputLabel id="lblRequesterId" style="left: 456px; top: 48px; position: absolute" value="#{msgse.ID}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtRequesterDepartment}" disabled="true"
                                                                id="txtRequesterDepartment" style="left: 190px; top: 70px; position: absolute; width: 467px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtRequesterId}" disabled="true"
                                                                id="txtRequesterId" immediate="true" partialSubmit="true" style="left: 526px; top: 46px; position: absolute; width: 148px"/>
                                                            <ice:outputLabel id="lblRequsterFullName" style="left: 24px; top: 48px; position: absolute" value="#{msgse.FullName}"/>
                                                            <ice:outputLabel id="lblRequesterPosition" style="left: 24px; top: 96px; position: absolute" value="#{msgse.Position}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtRequesterPosition}" disabled="true"
                                                                id="txtRequesterPosition" style="left: 190px; top: 94px; position: absolute; width: 467px"/>
                                                            <ice:outputLabel id="lblRequesterEdLevel1"
                                                                style="left: 24px; top: 120px; position: absolute; width: 165px" value="#{msgse.CurrentEducationLevel}"/>
                                                            <ice:outputLabel id="lblRequesterProgramName1"
                                                                style="left: 24px; top: 144px; position: absolute; width: 93px" value="#{msgse.FieldOfstudy}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtCurrentEdLevl}" disabled="true"
                                                                id="txtCurrentEdLevl" style="height: 23px; left: 190px; top: 118px; position: absolute; width: 207px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtField}" disabled="true" id="txtField" style="left: 190px; top: 145px; position: absolute; width: 207px"/>
                                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lblEdurequstStstus1}"
                                                                id="lblEdurequstStstus1" style="border-bottom: solid purple 1px; font-weight: bold; height: 17px; left: 384px; top: 0px; position: absolute; width: 143px"/>
                                                            <ice:outputLabel id="lblEdurequstStstus2"
                                                                style="height: 17px; left: 193px; top: 1px; position: absolute" value="Educational Status Requst For:-"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputInstitution" layout="flow"
                                                            style="height: 135px; margin-left: 15px; left: 9px; top: 245px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:outputText binding="#{Education$EducationApprovePage.lblInstId}" id="lblInstId"
                                                                rendered="false" style="font-family: 'Cambria'; height: 19px; left: 192px; top: 0px; position: absolute; width: 127px"/>
                                                            <ice:outputLabel id="lblInstitutionName"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Institution}"/>
                                                            <ice:outputLabel id="lblInstitutionAddress"
                                                                style="font-size: 10px; left: 24px; top: 72px; position: absolute" value="#{msgse.InstitutionAddress}"/>
                                                            <ice:inputTextarea binding="#{Education$EducationApprovePage.txtInstitutionName}" disabled="true"
                                                                id="txtInstitutionName" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206);   left: 128px; top: 24px; position: absolute; width: 285px"/>
                                                            <ice:inputTextarea binding="#{Education$EducationApprovePage.txtaInstitutionAddress}"
                                                                disabled="true" id="txtaInstitutionAddress" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); left: 128px; top: 76px; position: absolute; width: 285px"/>
                                                            <ice:outputText id="lblInstitutionAccredited1"
                                                                style="font-size: 10px; font-family: 'Cambria'; height: 19px; left: 442px; top: 26px; position: absolute; width: 107px" value="#{msgse.Accredited}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtAccred}" disabled="true" id="txtAccred"
                                                                style="left: 550px; top: 22px; position: absolute; width: 133px" styleClass="iceInpTxt"/>
                                                            <ice:outputText id="lblLocationInsideEthiopia1"
                                                                style="font-size: 10px; font-family: 'Cambria'; left: 456px; top: 72px; position: absolute" value="#{msgse.InsideOutside}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtInsideOut}" disabled="true"
                                                                id="txtInsideOut" style="left: 550px; top: 70px; position: absolute; width: 133px" styleClass="iceInpTxt"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayputRequest"
                                                            style="height: 225px; margin-left: 15px; left: 9px; top: 400px; overflow: auto; position: absolute; width: 703px" styleClass="insideContainerMain">
                                                            <ice:outputLabel id="lblEducationLevel"
                                                                style="font-size: 10px; left: 26px; top: 26px; position: absolute" value="#{msgse.Level}"/>
                                                            <ice:outputLabel id="lblProgramName"
                                                                style="font-size: 10px; left: 21px; top: 48px; position: absolute" value="#{msgse.ProgramName}"/>
                                                            <ice:outputLabel id="lblStartDate"
                                                                style="font-size: 10px; left: 364px; top: 52px; position: absolute" value="#{msgse.Startdate}"/>
                                                            <ice:outputLabel id="lblAppliedDate"
                                                                style="font-size: 10px; left: 26px; top: 78px; position: absolute" value="#{msgse.AppliedDate}"/>
                                                            <ice:outputLabel id="lblCostPerCreditHour"
                                                                style="font-size: 10px; left: 26px; top: 104px; position: absolute" value="#{msgse.Costpercredit}"/>
                                                            <ice:outputLabel id="lblAdminstrativeCost"
                                                                style="font-size: 10px; left: 26px; top: 130px; position: absolute" value="#{msgse.AdminstrativeCost}"/>
                                                            <ice:outputLabel id="lblDurationInYear"
                                                                style="font-size: 10px; left: 364px; top: 104px; position: absolute" value="#{msgse.DurationInYear}"/>
                                                            <ice:outputLabel id="lblxxDurationInYear"
                                                                style="font-size: 10px; left: 364px; top: 26px; position: absolute" value="#{msgse.Shift}"/>
                                                            <ice:outputLabel id="lblNumberOfCreditHours"
                                                                style="font-size: 10px; left: 364px; top: 78px; position: absolute" value="#{msgse.Noofcredit}"/>
                                                            <ice:outputLabel id="lblDocumentReferenceNumber"
                                                                style="font-size: 10px; left: 364px; top: 130px; position: absolute" value="#{msgse.Documentreferencenumber}"/>
                                                            <ice:outputLabel id="lblRemark" style="font-size: 10px; left: 26px; top: 156px; position: absolute" value="#{msgse.Remark}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtEducationProgramName}" disabled="true"
                                                                id="txtEducationProgramName" style="left: 128px; top: 50px; position: absolute; width: 133px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtStartDate}" disabled="true"
                                                                id="txtStartDate" style="left: 518px; top: 50px; position: absolute; width: 151px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtAppliedDate}" disabled="true"
                                                                id="txtAppliedDate" style="left: 128px; top: 76px; position: absolute; width: 133px"/>
                                                            <ice:inputText action="#{Education$EducationApprovePage.txtCostPerCreditHour_action}"
                                                                binding="#{Education$EducationApprovePage.txtCostPerCreditHour}" disabled="true"
                                                                id="txtCostPerCreditHour" style="left: 128px; top: 102px; position: absolute; width: 133px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtNumberOfCreditHours}" disabled="true"
                                                                id="txtNumberOfCreditHours" style="left: 518px; top: 76px; position: absolute; width: 95px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtDocumentReferenceNumber}"
                                                                disabled="true" id="txtDocumentReferenceNumber" style="left: 518px; top: 128px; position: absolute; width: 155px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtDurationInYear}" disabled="true"
                                                                id="txtDurationInYear" style="left: 518px; top: 102px; position: absolute; width: 93px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtTotalAdminstrativeCost}" disabled="true"
                                                                id="txtTotalAdminstrativeCost" style="left: 128px; top: 128px; position: absolute; width: 133px"/>
                                                            <ice:inputTextarea binding="#{Education$EducationApprovePage.txtRemark}" disabled="true"
                                                                id="txtRemark" style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); height: 50px; left: 128px; top: 154px; position: absolute; width: 541px"/>
                                                            <ice:selectInputDate binding="#{Education$EducationApprovePage.calStartDate}" id="calStartDate"
                                                                rendered="false"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206);  left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$EducationApprovePage.selectInputDate1Bean.date1}" valueChangeListener="#{Education$EducationApprovePage.calStartDate_processValueChange}"/>
                                                            <ice:selectInputDate binding="#{Education$EducationApprovePage.calAppliedDate}" id="calAppliedDate"
                                                                rendered="false" style="left: 24px; top: 16px; position: absolute; height:212px; width: 190px"
                                                                value="#{Education$EducationApprovePage.selectInputDateBean2.date1}" valueChangeListener="#{Education$EducationApprovePage.calAppliedDate_processValueChange}"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtEducationLevel}" disabled="true"
                                                                id="txtEducationLevel" style="left: 128px; top: 24px; position: absolute; width: 133px"/>
                                                            <ice:inputText binding="#{Education$EducationApprovePage.txtEducationShift}" disabled="true"
                                                                id="txtEducationShift" style="left: 518px; top: 24px; position: absolute; width: 151px"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout id="pnlLayoutButtons"
                                                            style="height: 41px; margin-left: 15px; left: 9px; top: 1248px; overflow: auto; position: absolute; width: 707px" styleClass="insideContainerMain">
                                                            <ice:commandButton action="#{Education$EducationApprovePage.btnPostDecision_action}"
                                                                binding="#{Education$EducationApprovePage.btnPostDecision}" id="btnPostDecision"
                                                                style="left: 216px; top: 0px; position: absolute; width: 71px" value="#{Education$EducationApprovePage.newOrEditOrUpdateLabel}"/>
                                                            <ice:commandButton action="#{Education$EducationApprovePage.btnReset_action}"
                                                                binding="#{Education$EducationApprovePage.btnReset}" id="btnReset"
                                                                style="left: 336px; top: 0px; position: absolute; width: 71px" value="#{msgse.btnRest}"/>
                                                        </ice:panelLayout>
                                                        <ice:panelLayout binding="#{Education$EducationApprovePage.pnlLayoutDecisoion}" id="pnlLayoutDecisoion"
                                                            layout="flow"
                                                            style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 586px; margin-left: 15px; left: 9px; top: 635px; overflow: auto; position: absolute; width: 707px; -rave-layout: grid" styleClass="insideContainerMain">
                                                            <ice:selectOneMenu binding="#{Education$EducationApprovePage.drlCommittee}" id="drlCommittee"
                                                                partialSubmit="true" rendered="false"
                                                                style="left: 94px; top: 142px; position: absolute; width: 191px" value="#{Education$EducationApprovePage.selectObjectOfCommittee.selectedObject}">
                                                                <f:selectItems id="selectOneMenuCommittee1" value="#{Education$EducationApprovePage.committeeLists}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lblCommitte}" id="lblCommitte"
                                                                rendered="false" style="left: 24px; top: 144px; position: absolute" value="Commitee"/>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdLinkConfirmCommitteeDecisions_action}"
                                                                binding="#{Education$EducationApprovePage.cmdLinkConfirmCommitteeDecisions}"
                                                                id="cmdLinkConfirmCommitteeDecisions" rendered="false"
                                                                style="color: rgb(48, 102, 130); height: 31px; left: 24px; top: 552px; position: absolute; width: 670px" value="You Can not give decision by yourself. All Committe members should confirm on the decision. Click here to decide"/>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdLinkViewPreviesDecisions_action}"
                                                                binding="#{Education$EducationApprovePage.cmdLinkViewPreviesDecisions}"
                                                                id="cmdLinkViewPreviesDecisions"
                                                                style="color: rgb(48, 102, 130); left: 528px; top: 528px; position: absolute" value="View Previeous Decisions"/>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdview_Committee_Comments_action}"
                                                                binding="#{Education$EducationApprovePage.cmdview_Committee_Comments}"
                                                                id="cmdview_Committee_Comments" style="left: 528px; top: 504px; position: absolute" value="ViewCommitteeComments"/>
                                                            <ice:selectOneMenu binding="#{Education$EducationApprovePage.drlDecision}" id="drlDecision"
                                                                partialSubmit="true" style="left: 94px; top: 142px; position: absolute; width: 263px" value="#{Education$EducationApprovePage.selectObjectOfDecisionType.selectedObject}">
                                                                <f:selectItems id="selectOneMenu1selectItems1" value="#{Education$EducationApprovePage.availableDecisionsToMakeList}"/>
                                                            </ice:selectOneMenu>
                                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lbDecisio}" id="lbDecisio"
                                                                style="font-size: 10px; left: 24px; top: 144px; position: absolute" value="#{msgse.Decision}"/>
                                                            <ice:inputTextarea binding="#{Education$EducationApprovePage.txtaDecisionExplanation}"
                                                                id="txtaDecisionExplanation" style="left: 94px; top: 22px; position: absolute; width: 285px"/>
                                                            <ice:outputLabel id="lbDeciderComment1"
                                                                style="font-size: 10px; left: 24px; top: 24px; position: absolute" value="#{msgse.Comment}"/>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationApprovePage.ckbForwardToCommittee}"
                                                                id="ckbForwardToCommittee" partialSubmit="true"
                                                                style="left: 94px; top: 94px; position: absolute"
                                                                value="#{Education$EducationApprovePage.defaultSelectedData5.selectedBoolean}" valueChangeListener="#{Education$EducationApprovePage.ckbForwardToCommittee_processValueChange}"/>
                                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lbForwardToCommittee1}"
                                                                id="lbForwardToCommittee1" style="font-size: 10px; left: 120px; top: 96px; position: absolute" value="#{msgse.ForwardtoCommittee}"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="drlDecision" id="message1"
                                                                infoClass="infoMessage"
                                                                style="height: 20px; left: 408px; top: 144px; position: absolute; width: 65px" warnClass="warnMessage"/>
                                                            <ice:message errorClass="errorMessage" fatalClass="fatalMessage" for="txtaDecisionExplanation"
                                                                id="message2" infoClass="infoMessage"
                                                                style="height: 21px; left: 408px; top: 24px; position: absolute; width: 93px" warnClass="warnMessage"/>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdviewAttachedDocument_action}"
                                                                binding="#{Education$EducationApprovePage.cmdviewAttachedDocument}" id="cmdviewAttachedDocument"
                                                                style="left: 24px; top: 216px; position: absolute; width: 119px" value="Attach a Document"/>
                                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdAccepatnce_action}"
                                                                binding="#{Education$EducationApprovePage.cmdAccepatnce1}" id="cmdAccepatnce1"
                                                                style="left: 336px; top: 216px; position: absolute" value="Down Load File"/>
                                                            <ice:panelLayout binding="#{Education$EducationApprovePage.pnlDownload1}" id="pnlDownload1" style="height: 47px; left: 456px; top: 192px; position: absolute; width: 20%">
                                                                <ice:outputResource attachment="false" fileName="#{Education$EducationApprovePage.fileName}"
                                                                    id="downloadButton" label="DownLoad" mimeType="#{Education$EducationApprovePage.mimeType}"
                                                                    rendered="#{Education$EducationApprovePage.downloadAvailable}"
                                                                    resource="#{Education$EducationApprovePage.faResource}"
                                                                    style="left: 40px; top: 10px; position: relative; width: 75px" type="button"/>
                                                            </ice:panelLayout>
                                                            <ice:panelLayout binding="#{Education$EducationApprovePage.lyTableFile2}" id="lyTableFile2"
                                                                layout="flow" rendered="false"
                                                                style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 117px; left: 48px; top: 384px; overflow: auto; position: absolute; visibility: visible; width: 549px; -rave-layout: grid"
                                                                styleClass="insideContainerMain" visible="true">
                                                                <ice:outputLabel id="lblAccusationAcceptanceValue3"
                                                                    style="left: 24px; top: 24px; position: absolute; width: 72px" value="Minute"/>
                                                                <ice:inputFile action="#{Education$EducationApprovePage.fileUploadAttached_action}"
                                                                    actionListener="#{Education$EducationApprovePage.fileUploadAttached_processAction}"
                                                                    failOnEmptyFile="true" id="fileUploadAttached1"
                                                                    style="background-color: rgb(242, 246, 240); left: 96px; top: 24px; position: absolute"
                                                                    uniqueFolder="true" width="421"/>
                                                                <ice:commandButton action="#{Education$EducationApprovePage.btnUpdateMInute_action}"
                                                                    binding="#{Education$EducationApprovePage.btnUpdateMInute}" id="btnUpdateMInute"
                                                                    style="left: 144px; top: 62px; position: absolute" value="Update Minute"/>
                                                            </ice:panelLayout>
                                                            <ice:selectBooleanCheckbox binding="#{Education$EducationApprovePage.chkUpdateminute}"
                                                                disabled="true" id="chkUpdateminute" partialSubmit="true"
                                                                style="left: 24px; top: 288px; position: absolute"
                                                                value="#{Education$EducationApprovePage.defaultSelectedData8.selectedBoolean}" valueChangeListener="#{Education$EducationApprovePage.chkUpdateminute_processValueChange}"/>
                                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lblUpdateMinute}" id="lblUpdateMinute"
                                                                style="left: 72px; top: 288px; position: absolute; width: 285px" value="Select if u want to update the attached minute"/>
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
                                                href="http://www.google.com" style="text-decoration:none;color:orange">BUNNA INTERNATIONAL BANK |INFORMATION |Software Department.</a> |</label>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationApprovePage.pnlPopupSuccessOrFailure}" clientOnly="true"
                            draggable="false" id="pnlPopupSuccessOrFailure" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 120px; top: 768px; position: absolute; width: 667px; z-index: 10000" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridpnMessage" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText id="pnMessageTitle"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationApprovePage.btnClosePopupSuccessOrFailure_action}"
                                        id="btnClosePopupSuccessOrFailure" immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationApprovePage.panelGroupMessage}" id="panelGroupMessage"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationApprovePage.pnlMessageBody}" id="pnlMessageBody" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationApprovePage.lblSuccessOrErrorMessage}" id="lblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationApprovePage.pnlPopupConfirmDelete}" draggable="true"
                            id="pnlPopupConfirmDelete" modal="true" rendered="false" style="height: 115; left: 419px; top: 246px; position: absolute; width: 418px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGrid1" style="display:block;width:380px;height:20px;">
                                    <ice:outputText id="otxtConfirmDeletePopupHeader" value="            BUNNA HRMS"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGrid id="pnlGrdPopupConfirmDeleteBody" style=" top:20px; display:block;width:380px;height:30px;">
                                    <ice:panelLayout id="pnlLayoutPopupConfirmDeleteBody">
                                        <ice:outputText binding="#{Education$EducationApprovePage.outputTextConfirmDelete}" id="outputTextConfirmDelete"
                                            style="left: 20px; top: 0px; position: absolute; width: 360px" value="AreYouSureYouWantToDelete"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnPopupOkDelete_action}" id="btnPopupOkDelete"
                                            style="left: 96px; top: 35px; position: absolute; width: 88px" value="Ok"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnPopupCancelDelete_action}" id="btnPopupCancelDelete"
                                            style="left: 192px; top: 35px; position: absolute; width: 96px" value="No"/>
                                    </ice:panelLayout>
                                </ice:panelGrid>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationApprovePage.pnlPopupViewPrevieousDecisions}" draggable="true"
                            id="pnlPopupViewPrevieousDecisions" modal="true" rendered="false" style="height: 261px; left: 408px; top: 240px; position: absolute; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupViewPrevieousDecisions" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText dir="left" id="otxtViewPrevieousDecisionsPopupHeader"
                                        style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - View request status "/>
                                    <ice:commandLink action="#{Education$EducationApprovePage.btnClosePopupViewPrevieousDecisions_action}"
                                        id="btnClosePopupViewPrevieousDecisions" style="background-image: url(../resources/close_icon.gif); height: 19px; left: 740px; left: 655px; top: 0px; position: absolute; width: 19px"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutViewPrevieousDecisions" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout id="pnlLayoutPopupTable" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable id="dataTableDisciplineType" style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationApprovePage.decisionsMadeOnRequestList}" var="currentRow">
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
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationApprovePage.pnlPopupCommitteeMembers}" id="pnlPopupCommitteeMembers"
                            modal="true" rendered="false" style="height: 453px; left: 408px; top: 840px; position: absolute; width: 813px">
                            <f:facet name="header">
                                <ice:panelGrid id="panelGridPopupCommitteeMembers" style="display: block; height: 20px; text-align: left" width="772">
                                    <ice:outputText dir="left" id="otxtCommitteeMembers" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - CONFIRM ON DECISION"/>
                                    <ice:commandLink action="#{Education$EducationApprovePage.btnClosePopupCommitteeMembers_action}"
                                        binding="#{Education$EducationApprovePage.btnClosePopupCommitteeMembers}" id="btnClosePopupCommitteeMembers"
                                        style="left: 650px; top: 20px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout id="pnlLayoutCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 284px; margin-left: 15px; left: 10px; top: 50px; overflow: auto; position: absolute; width: 770px">
                                    <ice:panelLayout id="pnlLayoutPopupCommitteeMembers" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 237px; margin-left: 15px; left: 0px; top: 24px; overflow: auto; position: absolute; width: 740px">
                                        <ice:panelLayout id="pnlLayoutPopupCommitteeMembersMessage" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 40px; margin-left: 15px; left: 0px; top: 14px; overflow: auto; position: absolute; width: 693px">
                                            <ice:outputLabel binding="#{Education$EducationApprovePage.lblSignInReminder}" id="lblSignInReminder" value="Signin using your username"/>
                                            <ice:commandLink action="#{Education$EducationApprovePage.cmdLnkClosePopupCommitteeMembers_action}"
                                                binding="#{Education$EducationApprovePage.cmdLnkClosePopupCommitteeMembers}"
                                                id="cmdLnkClosePopupCommitteeMembers" style="color: rgb(48, 102, 130)" value="CLOSE"/>
                                        </ice:panelLayout>
                                        <ice:dataTable id="dataTableCommitteeMembers" style="height: 8px; left: 14px; top: 60px; position: absolute"
                                            value="#{Education$EducationApprovePage.committeeMembersList}" var="currentRow" width="697">
                                            <ice:column id="colPopupMemberId">
                                                <h:inputText binding="#{Education$EducationApprovePage.employeeID_textField}" id="employeeID_textField" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberId" value="ID"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberFullName">
                                                <h:inputText binding="#{Education$EducationApprovePage.employeeName_textField}" id="employeeName_textField" value="#{currentRow['employeeFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberFullName" value="Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberResponsiblty">
                                                <h:inputTextarea binding="#{Education$EducationApprovePage.responsiblity_textArea}" id="responsiblity_textArea" value="#{currentRow['memberResponsibility']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMemberResponsiblty" value="Responsiblty"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupMemberComment">
                                                <h:inputTextarea binding="#{Education$EducationApprovePage.textArea}" id="textArea" value="#{currentRow['commeentesGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextMemberComent" value="Comment"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupUserName">
                                                <h:inputText binding="#{Education$EducationApprovePage.userName_textField}" id="userName_textField" value="#{currentRow['userName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupUserName" value="UserName"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupPassWord">
                                                <h:inputSecret binding="#{Education$EducationApprovePage.password_secretField}" id="password_secretField"
                                                    redisplay="true" value="#{currentRow['passWord']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPassWord" value="PassWord"/>
                                                </f:facet>
                                                <ice:rowSelector id="rowSelectorCommitteeMember" preStyleOnSelection="true"
                                                    selectionListener="#{Education$EducationApprovePage.rowSelectorCommitteeMember_processMyEvent}"
                                                    toggleOnClick="true" value="#{currentRow['selected']}"/>
                                            </ice:column>
                                            <ice:column id="colPopupMemberLogIn">
                                                <h:commandButton action="#{Education$EducationApprovePage.btnPopupForColumnMemberLogIn_action}"
                                                    binding="#{Education$EducationApprovePage.loginButton}" id="loginButton" value="Login"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupMemberLogIn" value="Log In"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colPopupLoginConfirmed">
                                                <h:outputText binding="#{Education$EducationApprovePage.loginConfirmed}" id="loginConfirmed"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextPopupLoginConfirmed" value="#{currentRow['logInConfirmed']}"/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                    <ice:panelPopup clientOnly="true" draggable="false" id="panelPopupMessageForCommeteComentes" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 106px; left: 33px; top: 10px; position: absolute; width: 667px">
                                        <f:facet name="header">
                                            <ice:panelGroup id="panelGrid1forcommentes" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                                <ice:outputText id="outputText"
                                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                <ice:commandLink action="#{Education$EducationApprovePage.commentsbtnClosePopupSuccessOrFailure_action}"
                                                    id="commentsbtnClosePopupSuccessOrFailure" immediate="true"
                                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 600px; top: 20px; position: absolute; width: 19px" title="Close Popup"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup id="commentespanelGroupMessage"
                                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                                <ice:panelLayout id="commentspnlMessageBody" layout="flow"
                                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                                    <h:outputLabel id="commenteslblSuccessOrErrorMessage" style="background-color: #F5F5F5;"/>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Education$EducationApprovePage.pnlPopupSuccessOrFailure1}" clientOnly="true" draggable="false"
                            id="pnlPopupSuccessOrFailure1" modal="false" rendered="false"
                            style="border-style: none; background-color: transparent; display: block; height: 106px; left: 3px; top: 80px; position: absolute; width: 667px" styleClass="message">
                            <f:facet name="header">
                                <ice:panelGroup binding="#{Education$EducationApprovePage.pnlgridpnMessage2}" id="pnlgridpnMessage2" style="background-color:#306682; height: 20px; padding-top: 8px; width: 672px">
                                    <ice:outputText binding="#{Education$EducationApprovePage.pnMessageTitle2}" id="pnMessageTitle2"
                                        style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                    <ice:commandLink action="#{Education$EducationApprovePage.btnClosePopupSuccessOrFailure2_action}"
                                        binding="#{Education$EducationApprovePage.btnClosePopupSuccessOrFailure2}" id="btnClosePopupSuccessOrFailure2"
                                        immediate="true"
                                        style="background-image: url(../resources/close_icon.gif); height: 19px; left: 700px; top: 20px; position: absolute; width: 19px"
                                        styleClass="popupHeaderImage" title="Close Popup"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup binding="#{Education$EducationApprovePage.panelGroupMessage2}" id="panelGroupMessage2"
                                    style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout binding="#{Education$EducationApprovePage.pnlMessageBody2}" id="pnlMessageBody2" layout="flow"
                                        style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                        <h:outputLabel binding="#{Education$EducationApprovePage.lblSuccessOrErrorMessage2}" id="lblSuccessOrErrorMessage2" style="background-color: #F5F5F5;"/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup autoCentre="true" binding="#{Education$EducationApprovePage.pnlPopupComeeteeComenets}" draggable="true"
                            id="pnlPopupComeeteeComenets" modal="true" rendered="false" style="height: 261px; width: 682px">
                            <f:facet name="header">
                                <ice:panelGrid binding="#{Education$EducationApprovePage.panelGridPopupViewCommiteeCommentes}"
                                    id="panelGridPopupViewCommiteeCommentes" style="display: block; height: 20px; text-align: left" width="672">
                                    <ice:outputText binding="#{Education$EducationApprovePage.otxtViewCommeeteCommentesPopupHeader}" dir="left"
                                        id="otxtViewCommeeteCommentesPopupHeader" style="display: block; height: 20px; text-align: right" value="BUNNA HRMS - "/>
                                    <ice:commandButton action="#{Education$EducationApprovePage.btnCloseViewPreviesDecisions_action}"
                                        actionListener="#{Education$EducationApprovePage.btnClosePopupCommeeteComeentes_processAction}"
                                        id="btnClosePopupCommeeteComeentes" style="left: 650px; top: -10px; position: absolute" value="X"/>
                                </ice:panelGrid>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelLayout binding="#{Education$EducationApprovePage.pnlLayoutCommeeteComentes}" id="pnlLayoutCommeeteComentes" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 164px; margin-left: 15px; left: -10px; top: 50px; overflow: auto; position: absolute; width: 670px">
                                    <ice:panelLayout binding="#{Education$EducationApprovePage.pnlLayoutPopupCommeteeCommentes}"
                                        id="pnlLayoutPopupCommeteeCommentes" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 119px; margin-left: 15px; left: 0px; top: 20px; overflow: auto; position: absolute; width: 640px">
                                        <ice:dataTable binding="#{Education$EducationApprovePage.dataTableCommetesComentes}" id="dataTableCommetesComentes"
                                            style="left: 10px; top: 0px; height:8px; width:600px; position: absolute"
                                            value="#{Education$EducationApprovePage.comeeteeCommentsGive}" var="currentRow">
                                            <ice:column id="colCommettes">
                                                <ice:outputText id="optTxtForColumnNumber1" value="#{currentRow['counter']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextNumber1" value="NO"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colMemberID">
                                                <ice:outputText id="optTxtForColumnEmpId1" value="#{currentRow['employeeId']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpId1" value="Employee ID"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colMemberFullName">
                                                <ice:outputText id="optTxtForColumnEmpFullName1" value="#{currentRow['committeeMembersFullName']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextEmpFullName1" value="Employee Full Name"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colResponsiblity">
                                                <ice:outputText id="optTxtForCommentGiven1" value="#{currentRow['responsiblity']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextCommentGiven1" value="Responsiblity"/>
                                                </f:facet>
                                            </ice:column>
                                            <ice:column id="colCommeentesGiven">
                                                <ice:outputText id="optTxtForDate1" value="#{currentRow['commeentesGiven']}"/>
                                                <f:facet name="header">
                                                    <ice:outputText id="headerTextDate1" value="Comments Given "/>
                                                </f:facet>
                                            </ice:column>
                                        </ice:dataTable>
                                    </ice:panelLayout>
                                </ice:panelLayout>
                            </f:facet>
                        </ice:panelPopup>
                        <ice:panelPopup binding="#{Education$EducationApprovePage.pnlPopUpForwardedList}" clientOnly="true" draggable="true"
                            id="pnlPopUpForwardedList" modal="true" rendered="false" style="display: block; height: 669px; left: 120px; top: 216px; position: absolute; width: 693px">
                            <f:facet name="header">
                                <ice:panelGroup id="pnlgridPopUpResignTye1" styleClass="icePnlGrp popupHeaderWrapper">
                                    <ice:outputText id="popUpResignTyeTitle1" style="width:400px" value="BUNNA INTERNATIONAL BANK Human Resource Management System - List Forwarded Request"/>
                                    <ice:commandButton action="#{Education$EducationApprovePage.modalPnlCloseBtn1_action}" alt="Close"
                                        binding="#{Education$EducationApprovePage.modalPnlCloseBtn1}" id="modalPnlCloseBtn1" image="/resources/images/close.gif"
                                        style="left: 673px; top: 4px; position: absolute" title="Close Popup" type="button"/>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="body">
                                <ice:panelGroup id="lblSelected1" style="display: block; height: 605px; position: relative; width: 675px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                    <ice:panelLayout id="panelLayout2" layout="flow" style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 405px; left: 24px; top: 192px; overflow: auto; position: absolute; width: 622px; -rave-layout: grid">
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnSaveMinute1_action}" id="btnSaveMinute1"
                                            style="left: 264px; top: 350px; position: absolute; width: 72px" value="Save"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnAddToGroup_action}"
                                            binding="#{Education$EducationApprovePage.btnAddToGroup}" id="btnAddToGroup"
                                            style="left: 264px; top: 86px; position: absolute; width: 95px" value="Add &gt;"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnRemoveFromGroup_action}"
                                            binding="#{Education$EducationApprovePage.btnRemoveFromGroup}" id="btnRemoveFromGroup"
                                            style="left: 264px; top: 134px; position: absolute; width: 95px" value="&lt; Remove"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnAddAllToGroup_action}"
                                            binding="#{Education$EducationApprovePage.btnAddAllToGroup}" id="btnAddAllToGroup"
                                            style="left: 264px; top: 182px; position: absolute; width: 95px" value="Add all&gt;&gt;"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnRemoveAllFromGroup_action}"
                                            binding="#{Education$EducationApprovePage.btnRemoveAllFromGroup}" id="btnRemoveAllFromGroup"
                                            style="left: 264px; top: 230px; position: absolute; width: 95px" value="&lt;&lt;Remove All"/>
                                        <ice:selectManyListbox binding="#{Education$EducationApprovePage.selecetForwardedList}" id="selecetForwardedList"
                                            partialSubmit="true" style="height: 263px; left: 22px; top: 70px; position: absolute; width: 215px" value="#{Education$EducationApprovePage.selectManyListbox1Bean.selectedItems}">
                                            <f:selectItems id="selectManyListbox1selectItems" value="#{Education$EducationApprovePage.forwardedList}"/>
                                        </ice:selectManyListbox>
                                        <ice:selectManyListbox binding="#{Education$EducationApprovePage.selectMiniteAttached}" id="selectMiniteAttached"
                                            partialSubmit="true" style="height: 264px; left: 382px; top: 70px; position: absolute; width: 215px" value="#{Education$EducationApprovePage.defaultSelectedData7.selectedItems}">
                                            <f:selectItems id="selectManyListbox1selectItems1" value="#{Education$EducationApprovePage.minuteAttachedForwardedList}"/>
                                        </ice:selectManyListbox>
                                        <ice:outputLabel id="lblAccusationAcceptanceValue1" style="left: 24px; top: 24px; position: absolute; width: 213px" value="Forwarded List"/>
                                        <ice:outputLabel id="lblAccusationAcceptanceValue2" style="left: 384px; top: 24px; position: absolute; width: 189px" value="Selected Request To Attach Minute"/>
                                    </ice:panelLayout>
                                    <ice:panelLayout binding="#{Education$EducationApprovePage.lyTableFile1}" id="lyTableFile1" layout="flow"
                                        style="border-width: 1px; border-style: solid; border-color: rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204) rgb(204, 204, 204); height: 142px; left: 24px; top: 24px; overflow: auto; position: absolute; visibility: visible; width: 622px; -rave-layout: grid"
                                        styleClass="insideContainerMain" visible="true">
                                        <ice:outputLabel binding="#{Education$EducationApprovePage.lblAccusationAcceptanceValue}"
                                            id="lblAccusationAcceptanceValue" style="left: 24px; top: 24px; position: absolute; width: 72px" value="Minute"/>
                                        <ice:inputFile action="#{Education$EducationApprovePage.fileUploadAttached_action}"
                                            actionListener="#{Education$EducationApprovePage.fileUploadAttached_processAction}"
                                            binding="#{Education$EducationApprovePage.fileUploadAttached}" failOnEmptyFile="true" id="fileUploadAttached"
                                            style="background-color: rgb(242, 246, 240); left: 96px; top: 24px; position: absolute" uniqueFolder="true" width="421"/>
                                        <ice:commandButton action="#{Education$EducationApprovePage.btnAttachMinute_action}"
                                            binding="#{Education$EducationApprovePage.btnAttachMinute}" id="btnAttachMinute" rendered="false"
                                            style="left: 144px; top: 62px; position: absolute; width: 119px" value="Attach Minute"/>
                                    </ice:panelLayout>
                                    <ice:panelPopup binding="#{Education$EducationApprovePage.pnlPopupSuccessOrFailure2}" clientOnly="true" draggable="false"
                                        id="pnlPopupSuccessOrFailure2" rendered="false" style="border-style: none; background-color: transparent; display: block; height: 106px; width: 523px; z-index: 5000; postion: absolute">
                                        <f:facet name="header">
                                            <ice:panelGroup binding="#{Education$EducationApprovePage.pnlgridpnMessage1}" id="pnlgridpnMessage1" style="background-color: rgb(48, 102, 130); height: 20px; padding-top: 8px; width: 504px">
                                                <ice:outputText binding="#{Education$EducationApprovePage.pnMessageTitle1}" id="pnMessageTitle1"
                                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="BUNNA INTERNATIONAL BANK Human Resource Management System:Message"/>
                                                <ice:commandLink action="#{Education$EducationApprovePage.btnClosePopupSuccessOrFailure1_action}"
                                                    binding="#{Education$EducationApprovePage.btnClosePopupSuccessOrFailure1}"
                                                    id="btnClosePopupSuccessOrFailure1" immediate="true"
                                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 509px; top: 5px; position: absolute; width: 19px" title="Close Popup"/>
                                            </ice:panelGroup>
                                        </f:facet>
                                        <f:facet name="body">
                                            <ice:panelGroup binding="#{Education$EducationApprovePage.panelGroupMessage3}" id="panelGroupMessage3"
                                                style="display: block; height: 50px; position: relative; width: 507px" styleClass="icePnlGrp icePnlGrp iceDatTblColHdr">
                                                <ice:panelLayout binding="#{Education$EducationApprovePage.pnlMessageBody3}" id="pnlMessageBody3" layout="flow"
                                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 456px; -rave-layout: grid" styleClass="message">
                                                    <h:outputLabel binding="#{Education$EducationApprovePage.lblSuccessOrErrorMessage3}"
                                                        id="lblSuccessOrErrorMessage3" style="background-color: #F5F5F5;"/>
                                                </ice:panelLayout>
                                            </ice:panelGroup>
                                        </f:facet>
                                    </ice:panelPopup>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelPopup>
                    </div>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>