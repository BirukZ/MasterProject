<?xml version="1.0" encoding="UTF-8"?>
<!--
    Document   : Page1
    Created on : Feb 26, 2010, 7:48:31 AM
    Author     : Dereje
-->
<jsp:root version="2.0" xmlns:f="http://java.sun.com/jsf/core" xmlns:h="http://java.sun.com/jsf/html" xmlns:ice="http://www.icesoft.com/icefaces/component"
    xmlns:jsp="http://java.sun.com/JSP/Page" xmlns:webuijsf="http://www.sun.com/webui/webuijsf">
    <jsp:directive.page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8"/>
    <f:view>
        <html id="outputHtml1">
            <head id="outputHead1">
                <title></title>
                <ice:outputStyle href="../resources/stylesheet.css" id="outputStyle1"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <ice:outputStyle href="../xmlhttp/css/rime/rime.css"/>
                <ice:outputStyle href="../resources/TempCSS.css"/>
                <script src="../Script/Ethiopian_Calendar.js"></script>
                <script src="../Script/jquery-1.3.2.min.js"></script>
                <ice:outputStyle href="../resources/ETH/KAMSI_CAL_STYLE.css" id="outputStyle22"/>
                <script src="../resources/ETH/KAMSI_CAL_SCRIPT.js"></script>
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
                <link HREF="../FederalIcon.ico" REL="icon"/>
            </head>
            <body id="outputBody1" onload="showCal()" style="-rave-layout: grid">
                <ice:form id="form1">
                    <div style="background-color:#F0F0F0;">
                        <ice:panelBorder id="whole_page" renderCenter="#{EmployeeHistory$PromoteReportPage.panelBorder1Bean.renderCenter}"
                            renderEast="#{EmployeeHistory$PromoteReportPage.panelBorder1Bean.renderEast}"
                            renderNorth="#{EmployeeHistory$PromoteReportPage.panelBorder1Bean.renderNorth}"
                            renderSouth="#{EmployeeHistory$PromoteReportPage.panelBorder1Bean.renderSouth}"
                            renderWest="#{EmployeeHistory$PromoteReportPage.panelBorder1Bean.renderEast}" style="top: 0px; position: relative"
                            styleClass="whole_page" width="1024">
                            <f:facet name="north">
                                <ice:panelGroup id="page_header" style="height: 75px">
                                    <!-- Begin Header -->
                                    <ice:panelLayout id="header" layout="flow"
                                        style="height: 75px; left: 0px; position: relative; width: 100%z; -rave-layout: grid" styleClass="header" visible="true">
                                        <jsp:directive.include file="/Header.jspf"/>
                                    </ice:panelLayout>
                                    <!-- End Header -->
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="west">
                                <ice:panelGroup id="menu_left" style="border:none; height:470px;">
                                    <ice:panelLayout id="left_menu1" layout="flow"
                                        style="height:470px;top:15px left: 0px; position: relative; width: 100%; -rave-layout: grid" styleClass="left_menu">
                                        <ice:panelLayout id="list_menu2" style="height: 470px; left: 5px; top: 62px; position: absolute; width: 213px" styleClass="left_menu">
                                            <ice:panelCollapsible expanded="true" id="pnl_col_Common_Tasks" style="border:none">
                                                <f:facet name="header">
                                                    <ice:panelGroup id="commonTasksGroup_header">
                                                        <ice:outputText id="lblCommonTasks" value="#{msgTermination.commonTasks}"/>
                                                    </ice:panelGroup>
                                                </f:facet>
                                                <ice:panelGrid id="commonTasksGroup_Grid11" style="height: 370px" width="100%">
                                                    <ice:panelGroup id="commonTasksGroup_Group22" style="width:100%;"/>
                                                    <ul style="list-style-type: none; list-style-image: none; list-style-position: outside; line-height: 174%;">
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$PromoteReportPage.lnkResignRequestPage_action}"
                                                                id="lnkResignRequestPage" style="color:#333333;font-weight:bold" value="Promotion Request"/>
                                                        </li>
                                                        <li>
                                                            <ice:commandLink action="#{EmployeeHistory$PromoteReportPage.lnkResignApprovePage_action}"
                                                                id="lnkResignApprovePage" style="color:#333333;font-weight:bold" value="Promote Without Vacancy"/>
                                                        </li>
                                                    </ul>
                                                </ice:panelGrid>
                                            </ice:panelCollapsible>
                                        </ice:panelLayout>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                            <f:facet name="center">
                                <ice:panelGroup id="page_display" style="height:500px">
                                    <ice:panelLayout id="container" layout="flow"
                                        style="height: 450px; left: 0px; top: 65px; position: relative; width: 100%; -rave-layout: grid" styleClass="page_display">
                                        <fieldset class="filedset_css" style="height: 400px;">
                                            <legend class="legend_css">
                                                <ice:outputLabel value="Generate Promotion Report"/>
                                            </legend>
                                            <ice:panelLayout id="pnProfile" style="height: 500px; left: -2px; top: -20px; position: absolute; width: 100%">
                                                <ice:panelGroup id="RetirementApproval" style="height: 350px" styleClass="filedsetNormal">
                                                    <ice:outputText id="outputText10" style="font-family: Cambria; left: 50px; top: 100px; position: absolute" value="Bach Code :"/>
                                                    <ice:outputText id="outputText11" style="font-family: Cambria; left: 150px; top: 250px; position: absolute" value="From "/>
                                                    <ice:outputText id="outputText12" style="font-family: Cambria; left: 460px; top: 250px; position: absolute" value="To "/>
                                                    <ice:outputText id="outputText14" style="font-family: Cambria; left: 50px; top: 250px; position: absolute" value="Promoted Date :"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteReportPage.btnSearch_action}"
                                                        binding="#{EmployeeHistory$PromoteReportPage.btnSearch}" id="btnSearch" immediate="true"
                                                        partialSubmit="true" style="left: 83px; top: 345px; position: absolute; width: 181px" value="Display"/>
                                                    <ice:commandButton action="#{EmployeeHistory$PromoteReportPage.btnPreviewSelected_action}"
                                                        binding="#{EmployeeHistory$PromoteReportPage.btnPreviewSelected}" id="btnPreviewSelected"
                                                        immediate="true" partialSubmit="true" rendered="false"
                                                        style="left: 556px; top: 356px; position: absolute; width: 130px" value="Preview Selected"/>
                                                    <ice:outputText escape="false" id="outputText18"
                                                        style="font-family: Cambria; left: 50px; top: 150px; position: absolute" value="Exam Result"/>
                                                    <ice:outputText escape="false" id="outputText20"
                                                        style="font-family: Cambria; left: 50px; top: 200px; position: absolute" value="Promoted Employee"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteReportPage.txtFromDate}" id="txtFromDate" immediate="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 220px; top: 245px; position: absolute; width: 186px"/>
                                                    <ice:inputText binding="#{EmployeeHistory$PromoteReportPage.txtToDate}" id="txtToDate" immediate="true" style="background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 550px; top: 245px; position: absolute; width: 190px"/>
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$PromoteReportPage.choPromotedEmployee}"
                                                        id="choPromotedEmployee" immediate="true" style="left: 222px; top: 200px; position: absolute"
                                                        value="#{EmployeeHistory$PromoteReportPage.selectBooleanCheckbox5Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$PromoteReportPage.choPromotedEmployee_processValueChange}"/>
                                                    <ice:selectBooleanCheckbox binding="#{EmployeeHistory$PromoteReportPage.choExamResult}" id="choExamResult"
                                                        immediate="true" style="left: 222px; top: 150px; position: absolute"
                                                        value="#{EmployeeHistory$PromoteReportPage.selectBooleanCheckbox6Bean.selectedBoolean}" valueChangeListener="#{EmployeeHistory$PromoteReportPage.choExamResult_processValueChange}"/>
                                                    <ice:selectOneMenu binding="#{EmployeeHistory$PromoteReportPage.drlBachCode}" id="drlBachCode"
                                                        immediate="true"
                                                        style="border-width: 1px; border-style: solid; border-color: rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206) rgb(115, 179, 206); background-color: rgb(242, 246, 240); color: rgb(54, 76, 94); font-family: 'Lucida Sans'; font-size: 11px; font-style: normal; font-weight: lighter; left: 220px; top: 100px; position: absolute; width: 258px" value="#{EmployeeHistory$PromoteReportPage.selectBooleanCheckbox625Bean.selectedObject}">
                                                        <f:selectItems id="selectOneMenu1selectItems" value="#{EmployeeHistory$PromoteReportPage.insideRecruitment}"/>
                                                    </ice:selectOneMenu>
                                                    <ice:commandButton id="btnFromDate" image="/resources/images/cal_button.gif" immediate="true"
                                                        onclick="getId('form1:txtFromDate'),getPosition(this.id);"
                                                        style="left: 391px; top: 250px; position: absolute; z-index: 100" value="submit"/>
                                                    <ice:commandButton id="btnToDate" image="/resources/images/cal_button.gif" immediate="true"
                                                        onclick="getId('form1:txtToDate'),getPosition(this.id);"
                                                        style="left: 722px; top: 250px; position: absolute; z-index: 100" value="submit"/>
                                                </ice:panelGroup>
                                            </ice:panelLayout>
                                        </fieldset>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                           <f:facet name="south">
                                <ice:panelGroup  id="page_footer" style=" text-align: left;">
                                    <ice:panelLayout id="footer" layout="flow" style="height: 21px; left: 0px; position: relative; -rave-layout: grid" styleClass="page_footer">
                                        <ice:outputLabel id="outputLabel1"
                                            style="color: rgb(255, 255, 255); font-family: serif; font-size: 14px; font-style: italic; font-weight: bolder; height: 18px; left: 24px; top: 0px; position: absolute; width: 622px" value="Mugher Cement Enterprise Human Resource Management System - Generate Promotion Report."/>
                                    </ice:panelLayout>
                                </ice:panelGroup>
                            </f:facet>
                        </ice:panelBorder>
                    </div>
                    <ice:panelPopup autoCentre="true" binding="#{EmployeeHistory$PromoteReportPage.pnConfirmationMessage}" clientOnly="true" draggable="false"
                        id="pnConfirmationMessage" modal="false" rendered="false"
                        style="border-style: none; background-color: transparent; display: block; height: 106px; left: 63px; top: 200px; position: absolute; width: 751px" styleClass="message">
                        <f:facet name="header">
                            <ice:panelGroup id="pnlConfirmationMessage" style="background-color:#333333; height: 20px; padding-top: 8px; width: 672px">
                                <ice:outputText id="pnConfirmationTitle"
                                    style="color: white; margin-top: 8px; top: 10px; text-align: left; vertical-align: middle; width: 500px" value="Federal Police Human Resource Management And Integrated Payroll System:Message"/>
                                <ice:commandLink action="#{EmployeeHistory$PromoteReportPage.cmdConfirmationCloseMesssage_action}"
                                    id="cmdConfirmationCloseMesssage" immediate="true"
                                    style="background-image: url(../resources/close_icon.gif); height: 19px; left: 744px; top: 15px; position: absolute; width: 19px"
                                    styleClass="popupHeaderImage" title="Close Popup"/>
                            </ice:panelGroup>
                        </f:facet>
                        <f:facet name="body">
                            <ice:panelGroup binding="#{EmployeeHistory$PromoteReportPage.panelConfirmationGroupMessage}" id="panelConfirmationGroupMessage"
                                style="display: block; height: 50px; position: relative; width: 638px" styleClass="icePnlGrp iceDatTblColHdr">
                                <ice:panelLayout binding="#{EmployeeHistory$PromoteReportPage.pnlConfirmationMessageBody}" id="pnlConfirmationMessageBody"
                                    layout="flow"
                                    style="background-color: rgb(245, 245, 245); display: block; height: 23px; position: relative; width: 572px; -rave-layout: grid" styleClass="message">
                                    <h:outputLabel binding="#{EmployeeHistory$PromoteReportPage.lblFormMessage4}" id="lblFormMessage4"
                                        style="background-color: #F5F5F5;" value=""/>
                                </ice:panelLayout>
                            </ice:panelGroup>
                        </f:facet>
                    </ice:panelPopup>
                </ice:form>
            </body>
        </html>
    </f:view>
</jsp:root>
